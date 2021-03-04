package com.gsmmodem;

import android.app.Notification;
import android.app.NotificationManager;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.gsmmodem.dao_impl.DatabaseAccess;
import com.gsmmodem.entities.AppSettingsEntity;

public class Settings extends AppCompatActivity {
    private static final String DATABASE_NAME = "gsm_modem_db";
    private final String TAG = "GSM";
    AppSettingsEntity appSettingsEntity;
    private DatabaseAccess databaseAccess;
    private EditText getSMSAtURL;
    private Switch getSMSAtURLSwitch;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private EditText noOfMinutes;
    private EditText noOfSMS;
    private Switch noOfSMSPerMinutesSwitch;
    private Integer operationIndex = -1;
    EditText portNumberEditText;
    private String portNumberStr = "";

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        this.portNumberEditText = (EditText) findViewById(R.id.portNumber);
        this.getSMSAtURLSwitch = (Switch) findViewById(R.id.getSMSAtURLSwitch);
        this.noOfSMSPerMinutesSwitch = (Switch) findViewById(R.id.noOfSMSPerMinutesSwitch);
        this.getSMSAtURL = (EditText) findViewById(R.id.getSMSAtURL);
        this.noOfSMS = (EditText) findViewById(R.id.noOfSMS);
        this.noOfMinutes = (EditText) findViewById(R.id.noOfMinutes);
        ((Button) findViewById(R.id.saveSettings)).setOnClickListener(new View.OnClickListener() {
            /* class com.gsmmodem.Settings.AnonymousClass1 */

            public void onClick(View view) {
                if (Settings.this.mInterstitialAd.isLoaded()) {
                    Settings.this.mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                if (Settings.this.portNumberEditText.getText() != null && Settings.this.portNumberEditText.getText().toString().equals("")) {
                    Toast.makeText(Settings.this, "Port number is required!", 0).show();
                } else if (Settings.this.getSMSAtURLSwitch != null && Settings.this.getSMSAtURLSwitch.isChecked() && Settings.this.getSMSAtURL != null && Settings.this.getSMSAtURL.getText().toString().equals("")) {
                    Toast.makeText(Settings.this, "GET SMS at URL is required!", 0).show();
                } else if (Settings.this.noOfSMSPerMinutesSwitch != null && Settings.this.noOfSMSPerMinutesSwitch.isChecked() && Settings.this.noOfSMS != null && Settings.this.noOfSMS.getText().toString().equals("") && Settings.this.noOfMinutes != null && Settings.this.noOfMinutes.getText().toString().equals("")) {
                    Toast.makeText(Settings.this, "SMS and Minutes are required!", 0).show();
                } else if (Settings.this.appSettingsEntity != null) {
                    Settings.this.setObjectProperties();
                    Settings.this.databaseAccess.daoAccess().updateAppSettingsEntity(Settings.this.appSettingsEntity);
                    Toast.makeText(Settings.this, "New parameters updated!", 0).show();
                } else {
                    Settings.this.appSettingsEntity = new AppSettingsEntity();
                    Settings.this.setObjectProperties();
                    Settings.this.databaseAccess.daoAccess().insertAppSettingsEntity(Settings.this.appSettingsEntity);
                    Toast.makeText(Settings.this, "New parameters inserted!", 0).show();
                }
            }
        });
        this.getSMSAtURLSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.gsmmodem.Settings.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    try {
                        Notification.Builder contentTitle = new Notification.Builder(Settings.this.getApplicationContext()).setSmallIcon(R.drawable.mobile).setContentTitle("SMS Receiver Service");
                        Notification.Builder when = contentTitle.setTicker("Service started for posting SMS to " + ((Object) Settings.this.getSMSAtURL.getText())).setWhen(System.currentTimeMillis());
                        ((NotificationManager) Settings.this.getSystemService("notification")).notify(0, when.setContentText("Service started for posting SMS to " + ((Object) Settings.this.getSMSAtURL.getText())).setPriority(2).build());
                        Settings.this.getSMSAtURL.setEnabled(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Notification.Builder contentTitle2 = new Notification.Builder(Settings.this.getApplicationContext()).setSmallIcon(R.drawable.mobile).setContentTitle("SMS Receiver Service");
                        Notification.Builder when2 = contentTitle2.setTicker("Service stopped for posting SMS to " + ((Object) Settings.this.getSMSAtURL.getText())).setWhen(System.currentTimeMillis());
                        ((NotificationManager) Settings.this.getSystemService("notification")).notify(0, when2.setContentText("Service stopped for posting SMS to " + ((Object) Settings.this.getSMSAtURL.getText())).setPriority(2).build());
                        Settings.this.getSMSAtURL.setEnabled(false);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (Settings.this.mInterstitialAd.isLoaded()) {
                    Settings.this.mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });
        this.noOfSMSPerMinutesSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.gsmmodem.Settings.AnonymousClass3 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    Settings.this.noOfSMS.setEnabled(true);
                    Settings.this.noOfMinutes.setEnabled(true);
                } else {
                    Settings.this.noOfSMS.setEnabled(false);
                    Settings.this.noOfMinutes.setEnabled(false);
                }
                if (Settings.this.mInterstitialAd.isLoaded()) {
                    Settings.this.mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });
        ((Button) findViewById(R.id.cancelSettingsButton)).setOnClickListener(new View.OnClickListener() {
            /* class com.gsmmodem.Settings.AnonymousClass4 */

            public void onClick(View view) {
                Settings.this.finish();
            }
        });
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.noOfMinutes.post(new Runnable() {
            /* class com.gsmmodem.Settings.AnonymousClass5 */

            public void run() {
                MobileAds.initialize(Settings.this.getApplicationContext(), Settings.this.getString(R.string.admob_app_id));
                Settings settings = Settings.this;
                settings.mAdView = (AdView) settings.findViewById(R.id.adView);
                Settings.this.mAdView.loadAd(new AdRequest.Builder().build());
                Settings settings2 = Settings.this;
                settings2.mInterstitialAd = new InterstitialAd(settings2.getApplicationContext());
                Settings.this.mInterstitialAd.setAdUnitId(Settings.this.getString(R.string.interstitial_ad_unit_id));
                Settings.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Settings settings3 = Settings.this;
                settings3.databaseAccess = (DatabaseAccess) Room.databaseBuilder(settings3.getApplicationContext(), DatabaseAccess.class, Settings.DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
                Settings settings4 = Settings.this;
                settings4.appSettingsEntity = settings4.databaseAccess.daoAccess().fetchAppSettingsEntityById(1);
                if (Settings.this.appSettingsEntity != null) {
                    Settings.this.runOnUiThread(new Runnable() {
                        /* class com.gsmmodem.Settings.AnonymousClass5.AnonymousClass1 */

                        public void run() {
                            String str;
                            String str2;
                            Settings.this.portNumberEditText.setText(Settings.this.appSettingsEntity.getPORT() == null ? "8090" : Settings.this.appSettingsEntity.getPORT());
                            boolean z = false;
                            Settings.this.getSMSAtURLSwitch.setChecked(Settings.this.appSettingsEntity.getGET_SMS_SWITCH() == null ? false : Settings.this.appSettingsEntity.getGET_SMS_SWITCH().booleanValue());
                            Settings.this.getSMSAtURL.setEnabled(Settings.this.appSettingsEntity.getGET_SMS_SWITCH() == null ? false : Settings.this.appSettingsEntity.getGET_SMS_SWITCH().booleanValue());
                            Settings.this.getSMSAtURL.setText(Settings.this.appSettingsEntity.getGET_SMS_URL() == null ? "" : Settings.this.appSettingsEntity.getGET_SMS_URL());
                            Settings.this.noOfSMSPerMinutesSwitch.setChecked(Settings.this.appSettingsEntity.getOUTGOING_SMS_SWITCH() == null ? false : Settings.this.appSettingsEntity.getOUTGOING_SMS_SWITCH().booleanValue());
                            Settings.this.noOfSMS.setEnabled(Settings.this.appSettingsEntity.getOUTGOING_SMS_SWITCH() == null ? false : Settings.this.appSettingsEntity.getOUTGOING_SMS_SWITCH().booleanValue());
                            EditText editText = Settings.this.noOfMinutes;
                            if (Settings.this.appSettingsEntity.getOUTGOING_SMS_SWITCH() != null) {
                                z = Settings.this.appSettingsEntity.getOUTGOING_SMS_SWITCH().booleanValue();
                            }
                            editText.setEnabled(z);
                            EditText editText2 = Settings.this.noOfSMS;
                            if (Settings.this.appSettingsEntity.getNO_SMS() == null) {
                                str = "0";
                            } else {
                                str = "" + Settings.this.appSettingsEntity.getNO_SMS();
                            }
                            editText2.setText(str);
                            EditText editText3 = Settings.this.noOfMinutes;
                            if (Settings.this.appSettingsEntity.getNO_MINUTES() == null) {
                                str2 = "0";
                            } else {
                                str2 = "" + Settings.this.appSettingsEntity.getNO_MINUTES();
                            }
                            editText3.setText(str2);
                        }
                    });
                } else {
                    Settings.this.runOnUiThread(new Runnable() {
                        /* class com.gsmmodem.Settings.AnonymousClass5.AnonymousClass2 */

                        public void run() {
                            Settings.this.portNumberEditText.setText("");
                            Settings.this.getSMSAtURLSwitch.setChecked(false);
                            Settings.this.getSMSAtURL.setEnabled(false);
                            Settings.this.getSMSAtURL.setText("");
                            Settings.this.noOfSMSPerMinutesSwitch.setChecked(false);
                            Settings.this.noOfSMS.setEnabled(false);
                            Settings.this.noOfMinutes.setEnabled(false);
                            Settings.this.noOfSMS.setText("");
                            Settings.this.noOfMinutes.setText("");
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setObjectProperties() {
        this.appSettingsEntity.setPORT(this.portNumberEditText.getText() == null ? "8090" : this.portNumberEditText.getText().toString());
        this.appSettingsEntity.setGET_SMS_SWITCH(Boolean.valueOf(this.getSMSAtURLSwitch.isChecked()));
        this.appSettingsEntity.setGET_SMS_URL(this.getSMSAtURL.getText() == null ? "" : this.getSMSAtURL.getText().toString());
        this.appSettingsEntity.setOUTGOING_SMS_SWITCH(Boolean.valueOf(this.noOfSMSPerMinutesSwitch.isChecked()));
        int i = 0;
        this.appSettingsEntity.setNO_SMS(Integer.valueOf((this.noOfSMS.getText() != null && !this.noOfSMS.getText().toString().equals("")) ? Integer.parseInt(this.noOfSMS.getText().toString()) : 0));
        AppSettingsEntity appSettingsEntity2 = this.appSettingsEntity;
        if (this.noOfMinutes.getText() != null && !this.noOfMinutes.getText().toString().equals("")) {
            i = Integer.parseInt(this.noOfMinutes.getText().toString());
        }
        appSettingsEntity2.setNO_MINUTES(Integer.valueOf(i));
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
    }
}
