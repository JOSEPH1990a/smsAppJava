package com.gsmmodem;

import android.arch.persistence.room.Room;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.gsmmodem.dao_impl.DatabaseAccess;
import com.gsmmodem.entities.AppSettingsEntity;

public class JsonSamples extends AppCompatActivity {
    private static final String DATABASE_NAME = "gsm_modem_db";
    private AppSettingsEntity appSettingsEntity;
    private DatabaseAccess databaseAccess;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private String portNumber;
    private TextView urlToSemdSMS;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_json_samples);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.urlToSemdSMS = (TextView) findViewById(R.id.textView3);
        this.urlToSemdSMS.post(new Runnable() {
            /* class com.gsmmodem.JsonSamples.AnonymousClass1 */

            public void run() {
                MobileAds.initialize(JsonSamples.this.getApplicationContext(), JsonSamples.this.getString(R.string.admob_app_id));
                JsonSamples jsonSamples = JsonSamples.this;
                jsonSamples.mAdView = (AdView) jsonSamples.findViewById(R.id.adView);
                JsonSamples.this.mAdView.loadAd(new AdRequest.Builder().build());
                JsonSamples jsonSamples2 = JsonSamples.this;
                jsonSamples2.mInterstitialAd = new InterstitialAd(jsonSamples2.getApplicationContext());
                JsonSamples.this.mInterstitialAd.setAdUnitId(JsonSamples.this.getString(R.string.interstitial_ad_unit_id));
                JsonSamples.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
                JsonSamples jsonSamples3 = JsonSamples.this;
                jsonSamples3.databaseAccess = (DatabaseAccess) Room.databaseBuilder(jsonSamples3.getApplicationContext(), DatabaseAccess.class, JsonSamples.DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
                JsonSamples.this.appSettingsEntity = new AppSettingsEntity();
                JsonSamples jsonSamples4 = JsonSamples.this;
                jsonSamples4.appSettingsEntity = jsonSamples4.databaseAccess.daoAccess().fetchAppSettingsEntityById(1);
                if (JsonSamples.this.appSettingsEntity == null) {
                    JsonSamples.this.portNumber = "8090";
                } else if (JsonSamples.this.appSettingsEntity.getPORT() == null || "".equals(JsonSamples.this.appSettingsEntity.getPORT())) {
                    JsonSamples.this.portNumber = "8090";
                } else {
                    JsonSamples jsonSamples5 = JsonSamples.this;
                    jsonSamples5.portNumber = jsonSamples5.appSettingsEntity.getPORT();
                }
                if (!(JsonSamples.this.appSettingsEntity == null || JsonSamples.this.appSettingsEntity.getGET_SMS_SWITCH() == null || !JsonSamples.this.appSettingsEntity.getGET_SMS_SWITCH().booleanValue())) {
                    ((TextView) JsonSamples.this.findViewById(R.id.textView5)).setText(JsonSamples.this.appSettingsEntity.getGET_SMS_URL());
                }
                TextView textView = JsonSamples.this.urlToSemdSMS;
                textView.setText(JsonSamples.this.getIpAccess() + "/SendSMS?username=Sadiq&password=1234&phone=0300xxxxxxx&message=hello");
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getIpAccess() {
        int ipAddress = ((WifiManager) getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress();
        String format = String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
        return "http://" + format + ":" + this.portNumber;
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
