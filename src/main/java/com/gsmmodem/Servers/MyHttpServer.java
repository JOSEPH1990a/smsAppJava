package com.gsmmodem.Servers;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.gsmmodem.dao_impl.DatabaseAccess;
import com.gsmmodem.entities.AppSettingsEntity;
import com.gsmmodem.entities.UsersEntity;
import fi.iki.elonen.NanoHTTPD;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class MyHttpServer extends NanoHTTPD {
    private static final String DATABASE_NAME = "gsm_modem_db";
    public static final long MINUTE_MILLIS = 60000;
    private static final String PACKAGE_TO_COM = "helper.gsm.com.gsmhelpertool";
    public static final long SECOND_MILLIS = 1000;
    private final String TAG = "GSM Modem: ";
    private AppSettingsEntity appSettingsEntity;
    private Context context;
    private DatabaseAccess databaseAccess;
    Intent intent;
    final Map<String, String> response = new HashMap();
    private UsersEntity usersEntity;

    public MyHttpServer(Context context2, int i) {
        super(i);
        this.context = context2;
        this.databaseAccess = (DatabaseAccess) Room.databaseBuilder(context2, DatabaseAccess.class, DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    public MyHttpServer(String str, int i) {
        super(str, i);
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        this.intent = new Intent();
        this.intent.addFlags(32);
        this.intent.setAction(PACKAGE_TO_COM);
        String uri = iHTTPSession.getUri();
        Log.v("GSM Modem: ", "url: " + uri);
        Map<String, String> parms = iHTTPSession.getParms();
        if (((uri.hashCode() == -342705790 && uri.equals("/SendSMS")) ? (char) 0 : 65535) != 0) {
            return newFixedLengthResponse(NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_HTML, homePage());
        }
        sendSMS(parms);
        return newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "text/json", new JSONObject(this.response).toString());
    }

    private void sendSMS(final Map<String, String> map) {
        if (!isPackageInstalled(PACKAGE_TO_COM, this.context.getPackageManager())) {
            this.response.put(NotificationCompat.CATEGORY_STATUS, "404");
            this.response.put("message", "GSM helper tool app is not installed in your device, please visit link for guide!");
            this.response.put("guideLink", "http://sindhitutorials.com/blog/gsm-modem-free-sms-android-app/");
        } else if (map.get("username") == null || map.get("password") == null) {
            this.response.put(NotificationCompat.CATEGORY_STATUS, "422");
            this.response.put("message", "username and password is required!");
        } else if (map.get("username") != null && map.get("username").length() <= 0) {
            this.response.put(NotificationCompat.CATEGORY_STATUS, "422");
            this.response.put("message", "username inappropriate length!");
        } else if (map.get("password") != null && map.get("password").length() <= 0) {
            this.response.put(NotificationCompat.CATEGORY_STATUS, "422");
            this.response.put("message", "password inappropriate length!");
        } else if (map.get("phone") == null) {
            this.response.put(NotificationCompat.CATEGORY_STATUS, "422");
            this.response.put("message", "phone number is required!");
        } else if (map.get("message") == null) {
            this.response.put(NotificationCompat.CATEGORY_STATUS, "422");
            this.response.put("message", "message is required!");
        } else if (map.get("phone").length() <= 3) {
            this.response.put(NotificationCompat.CATEGORY_STATUS, "422");
            this.response.put("message", "phone number inappropriate length!");
        } else if (map.get("message").length() <= 1) {
            this.response.put(NotificationCompat.CATEGORY_STATUS, "422");
            this.response.put("message", "message inappropriate length!");
        } else {
            this.usersEntity = this.databaseAccess.daoAccess().fetchUserByNameAndPass(map.get("username"), map.get("password"));
            if (this.usersEntity != null) {
                this.appSettingsEntity = this.databaseAccess.daoAccess().fetchAppSettingsEntityById(1);
                AppSettingsEntity appSettingsEntity2 = this.appSettingsEntity;
                if (appSettingsEntity2 == null || !appSettingsEntity2.getOUTGOING_SMS_SWITCH().booleanValue()) {
                    new Thread(new Runnable() {
                        /* class com.gsmmodem.Servers.MyHttpServer.AnonymousClass2 */

                        public void run() {
                            try {
                                MyHttpServer.this.intent.putExtra("phone", ((String) map.get("phone")).toLowerCase());
                                MyHttpServer.this.intent.putExtra("message", (String) map.get("message"));
                                MyHttpServer.this.context.sendBroadcast(MyHttpServer.this.intent);
                            } catch (Exception e) {
                                MyHttpServer.this.response.put(NotificationCompat.CATEGORY_STATUS, "500");
                                Map<String, String> map = MyHttpServer.this.response;
                                map.put("message", "Exception: " + e.getMessage());
                            }
                        }
                    }).start();
                    this.response.put(NotificationCompat.CATEGORY_STATUS, "200");
                    this.response.put("message", "Message has been sent");
                    this.response.put("phone", map.get("phone"));
                    return;
                }
                Integer num = 0;
                try {
                    num = Integer.valueOf(minutesDiff(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(this.appSettingsEntity.getDATE_LAST_SMS()), new Date()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (this.appSettingsEntity.getSMS_NUMBER_COUNT() == null) {
                    AppSettingsEntity appSettingsEntity3 = this.appSettingsEntity;
                    appSettingsEntity3.setDATE_LAST_SMS("" + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()));
                    this.appSettingsEntity.setSMS_NUMBER_COUNT(0);
                }
                if (this.appSettingsEntity.getSMS_NUMBER_COUNT().intValue() < this.appSettingsEntity.getNO_SMS().intValue() || num.intValue() >= this.appSettingsEntity.getNO_MINUTES().intValue()) {
                    if (this.appSettingsEntity.getSMS_NUMBER_COUNT().intValue() >= this.appSettingsEntity.getNO_SMS().intValue() && num.intValue() >= this.appSettingsEntity.getNO_MINUTES().intValue()) {
                        AppSettingsEntity appSettingsEntity4 = this.appSettingsEntity;
                        appSettingsEntity4.setDATE_LAST_SMS("" + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()));
                        this.appSettingsEntity.setSMS_NUMBER_COUNT(0);
                    }
                    AppSettingsEntity appSettingsEntity5 = this.appSettingsEntity;
                    appSettingsEntity5.setSMS_NUMBER_COUNT(Integer.valueOf(appSettingsEntity5.getSMS_NUMBER_COUNT().intValue() + 1));
                    new Thread(new Runnable() {
                        /* class com.gsmmodem.Servers.MyHttpServer.AnonymousClass1 */

                        public void run() {
                            try {
                                MyHttpServer.this.intent.putExtra("phone", ((String) map.get("phone")).toLowerCase());
                                MyHttpServer.this.intent.putExtra("message", (String) map.get("message"));
                                MyHttpServer.this.context.sendBroadcast(MyHttpServer.this.intent);
                            } catch (Exception e) {
                                MyHttpServer.this.response.put(NotificationCompat.CATEGORY_STATUS, "500");
                                Map<String, String> map = MyHttpServer.this.response;
                                map.put("message", "Exception: " + e.getMessage());
                            }
                        }
                    }).start();
                    this.response.put(NotificationCompat.CATEGORY_STATUS, "200");
                    this.response.put("message", "Message has been sent");
                    this.response.put("phone", map.get("phone"));
                } else {
                    Map<String, String> map2 = this.response;
                    map2.put("message", "Your SMS limit reached! SMS (" + this.appSettingsEntity.getSMS_NUMBER_COUNT() + ") - MINUTES (" + num + ")");
                    this.response.put(NotificationCompat.CATEGORY_STATUS, "201");
                }
                this.databaseAccess.daoAccess().updateAppSettingsEntity(this.appSettingsEntity);
                Map<String, String> map3 = this.response;
                map3.put("SMS_COUNT", "" + this.appSettingsEntity.getSMS_NUMBER_COUNT());
                Map<String, String> map4 = this.response;
                map4.put("MINUTES_COUNT", "" + num);
                return;
            }
            this.response.put(NotificationCompat.CATEGORY_STATUS, "422");
            this.response.put("message", "Username or Password is incorrect!");
        }
    }

    private String homePage() {
        return ((("<!DOCTYPE html> <html> <head> <meta charset=\"UTF-8\"> <title>GSM Modem</title> </head> <body>" + "<h1>Welcome to GSM Modem</h1>") + "<h2>Send SMS</h2>") + "<p> http://DeviceIP:port/SendSMS?username=abcd&amp;password=1234&amp;phone=111111111&amp;message=hello+test</p>") + " </body> </html>";
    }

    private int minutesDiff(Date date, Date date2) {
        if (date == null || date2 == null) {
            return 0;
        }
        return (int) ((date2.getTime() / MINUTE_MILLIS) - (date.getTime() / MINUTE_MILLIS));
    }

    private boolean isPackageInstalled(String str, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
