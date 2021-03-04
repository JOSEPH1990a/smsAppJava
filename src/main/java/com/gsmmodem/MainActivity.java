package com.gsmmodem;

import android.app.Notification;
import android.app.NotificationManager;
import android.arch.persistence.room.Room;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.gsmmodem.Servers.HttpSendSMSService;
import com.gsmmodem.Servers.MyHttpServer;
import com.gsmmodem.dao_impl.DatabaseAccess;
import com.gsmmodem.entities.AppSettingsEntity;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "gsm_modem_db";
    private static boolean isStarted = false;
    private AppSettingsEntity appSettingsEntity;
    private BroadcastReceiver broadcastReceiver = new MySMSReceiver();
    private BroadcastReceiver broadcastReceiverNetworkState;
    private DatabaseAccess databaseAccess;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private MyHttpServer myHttpServer;
    private String portNumber = "";
    private TextView serverAddress;
    private TextView statusAction;
    private ToggleButton toggleButton;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.serverAddress = (TextView) findViewById(R.id.serverAddress);
        this.serverAddress.setText(getIpAccess());
        MobileAds.initialize(getApplicationContext(), getString(R.string.admob_app_id));
        this.statusAction = (TextView) findViewById(R.id.statusAction);
        this.toggleButton = (ToggleButton) findViewById(R.id.startStopButton);
        this.toggleButton.setOnClickListener(new View.OnClickListener() {
            /* class com.gsmmodem.MainActivity.AnonymousClass1 */
            final Intent intent = new Intent(MainActivity.this, HttpSendSMSService.class);

            public void onClick(View view) {
                MainActivity.this.showAdd();
                if (!MainActivity.this.isConnectedInWifi()) {
                    MainActivity mainActivity = MainActivity.this;
                    Toast.makeText(mainActivity, "" + MainActivity.this.getString(R.string.wifi_message), 0).show();
                    MainActivity.this.toggleButton.setChecked(false);
                    MainActivity.this.statusAction.setText("Stopped");
                    MainActivity.this.statusAction.setBackgroundResource(R.drawable.status_style_red);
                } else if (!MainActivity.isStarted && MainActivity.this.startServer().booleanValue()) {
                    boolean unused = MainActivity.isStarted = true;
                    MainActivity.this.toggleButton.setChecked(true);
                    MainActivity.this.statusAction.setText("Started");
                    MainActivity.this.statusAction.setBackgroundResource(R.drawable.status_style_green);
                } else if (MainActivity.this.stopServer().booleanValue()) {
                    boolean unused2 = MainActivity.isStarted = false;
                    MainActivity.this.toggleButton.setChecked(false);
                    MainActivity.this.statusAction.setText("Stopped");
                    MainActivity.this.statusAction.setBackgroundResource(R.drawable.status_style_red);
                }
            }
        });
        findViewById(R.id.serverConfigs).setOnClickListener(new View.OnClickListener() {
            /* class com.gsmmodem.MainActivity.AnonymousClass2 */

            public void onClick(View view) {
                MainActivity.this.startActivityBayName("settings");
            }
        });
        findViewById(R.id.jsonSamples).setOnClickListener(new View.OnClickListener() {
            /* class com.gsmmodem.MainActivity.AnonymousClass3 */

            public void onClick(View view) {
                MainActivity.this.startActivityBayName("json_samples");
            }
        });
        findViewById(R.id.userManageButton).setOnClickListener(new View.OnClickListener() {
            /* class com.gsmmodem.MainActivity.AnonymousClass4 */

            public void onClick(View view) {
                MainActivity.this.startActivityBayName("users");
            }
        });
        this.toggleButton.post(new Runnable() {
            /* class com.gsmmodem.MainActivity.AnonymousClass5 */

            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.databaseAccess = (DatabaseAccess) Room.databaseBuilder(mainActivity.getApplicationContext(), DatabaseAccess.class, MainActivity.DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
                MainActivity.this.appSettingsEntity = new AppSettingsEntity();
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.appSettingsEntity = mainActivity2.databaseAccess.daoAccess().fetchAppSettingsEntityById(1);
                if (MainActivity.this.appSettingsEntity != null) {
                    MainActivity mainActivity3 = MainActivity.this;
                    mainActivity3.portNumber = mainActivity3.appSettingsEntity.getPORT();
                } else {
                    MainActivity.this.portNumber = "8090";
                }
                MainActivity.this.initBroadcastReceiverNetworkStateChanged();
            }
        });
        this.mAdView = (AdView) findViewById(R.id.adView);
        this.mAdView.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd = new InterstitialAd(getApplicationContext());
        this.mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        this.mInterstitialAd.setAdListener(new AdListener() {
            /* class com.gsmmodem.MainActivity.AnonymousClass6 */

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                MainActivity.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
                MainActivity.this.mAdView.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showAdd() {
        if (this.mInterstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_settings) {
            startActivityBayName("settings");
        } else if (itemId == R.id.action_json_samples) {
            startActivityBayName("json_samples");
        } else if (itemId == R.id.action_user_manual) {
            startActivityBayName("user_manual");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isStarted", isStarted);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        isStarted = bundle.getBoolean("isStarted");
        if (isStarted) {
            this.toggleButton.setChecked(true);
            this.statusAction.setText("Started");
            this.statusAction.setBackgroundColor(Color.parseColor("#04ab1a"));
            return;
        }
        this.toggleButton.setChecked(false);
        this.statusAction.setText("Stopped");
        this.statusAction.setBackgroundColor(Color.parseColor("#ab0407"));
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.toggleButton.post(new Runnable() {
            /* class com.gsmmodem.MainActivity.AnonymousClass7 */

            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.appSettingsEntity = mainActivity.databaseAccess.daoAccess().fetchAppSettingsEntityById(1);
                if (MainActivity.this.appSettingsEntity != null) {
                    MainActivity mainActivity2 = MainActivity.this;
                    mainActivity2.portNumber = mainActivity2.appSettingsEntity.getPORT();
                    if (MainActivity.this.portNumber == null || "".equals(MainActivity.this.portNumber)) {
                        MainActivity.this.portNumber = "8090";
                    }
                    if (MainActivity.this.appSettingsEntity.getGET_SMS_SWITCH() != null && MainActivity.this.appSettingsEntity.getGET_SMS_SWITCH().booleanValue()) {
                        String get_sms_url = MainActivity.this.appSettingsEntity.getGET_SMS_URL();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(BuildConfig.APPLICATION_ID);
                        try {
                            MainActivity.this.registerReceiver(MainActivity.this.broadcastReceiver, intentFilter);
                            Notification.Builder contentTitle = new Notification.Builder(MainActivity.this.getApplicationContext()).setSmallIcon(R.drawable.mobile).setContentTitle("SMS Receiver Service");
                            Notification.Builder when = contentTitle.setTicker("Service started for posting SMS to " + get_sms_url).setWhen(System.currentTimeMillis());
                            ((NotificationManager) MainActivity.this.getSystemService("notification")).notify(0, when.setContentText("Service started for posting SMS to " + get_sms_url).setPriority(2).build());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    MainActivity.this.portNumber = "8090";
                }
            }
        });
        setIpAccess();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        stopServer();
        isStarted = false;
        try {
            super.unregisterReceiver(this.broadcastReceiverNetworkState);
            this.appSettingsEntity = this.databaseAccess.daoAccess().fetchAppSettingsEntityById(1);
            if (this.appSettingsEntity != null) {
                this.appSettingsEntity.setGET_SMS_SWITCH(false);
                this.databaseAccess.daoAccess().updateAppSettingsEntity(this.appSettingsEntity);
            }
            super.unregisterReceiver(this.broadcastReceiver);
            ((NotificationManager) getSystemService("notification")).notify(0, new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.mobile).setContentTitle("SMS Receiver Service").setTicker("Service stopped for posting SMS to service").setWhen(System.currentTimeMillis()).setContentText("Service stopped for posting SMS to service").setPriority(2).build());
            this.databaseAccess.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DatabaseAccess databaseAccess2 = this.databaseAccess;
        if (databaseAccess2 != null) {
            databaseAccess2.close();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startActivityBayName(java.lang.String r3) {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gsmmodem.MainActivity.startActivityBayName(java.lang.String):void");
    }

    public boolean isConnectedInWifi() {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService("wifi");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && wifiManager.isWifiEnabled() && "WIFI".equals(activeNetworkInfo.getTypeName());
    }

    private String getIpAccess() {
        int ipAddress = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
        String format = String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
        return "http://" + format + ":" + this.portNumber;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Boolean startServer() {
        if (!isStarted) {
            try {
                if (this.portNumber == null || "".equals(this.portNumber)) {
                    this.portNumber = "8080";
                }
                this.myHttpServer = new MyHttpServer(getApplicationContext(), Integer.parseInt(this.portNumber));
                this.myHttpServer.start();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "The PORT " + this.portNumber + " doesn't work, please change it between 1000 and 9999.", 0).show();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Boolean stopServer() {
        MyHttpServer myHttpServer2;
        if (!isStarted || (myHttpServer2 = this.myHttpServer) == null) {
            return false;
        }
        myHttpServer2.stop();
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initBroadcastReceiverNetworkStateChanged() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.broadcastReceiverNetworkState = new BroadcastReceiver() {
            /* class com.gsmmodem.MainActivity.AnonymousClass8 */

            public void onReceive(Context context, Intent intent) {
                MainActivity.this.setIpAccess();
            }
        };
        super.registerReceiver(this.broadcastReceiverNetworkState, intentFilter);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setIpAccess() {
        this.serverAddress.setText(getIpAccess());
    }

    @Override // android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback, android.support.v4.app.FragmentActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Permission denied to read your External storage", 0).show();
            }
        }
    }
}
