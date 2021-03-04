package com.gsmmodem;

import android.app.Notification;
import android.app.NotificationManager;
import android.arch.persistence.room.Room;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.gsmmodem.dao_impl.DatabaseAccess;
import com.gsmmodem.entities.AppSettingsEntity;
import com.gsmmodem.entities.UsersEntity;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class MySMSReceiver extends BroadcastReceiver {
    private static final String DATABASE_NAME = "gsm_modem_db";
    private AppSettingsEntity appSettingsEntity;
    private Context context;
    private DatabaseAccess databaseAccess;
    final SmsManager sms = SmsManager.getDefault();
    private UsersEntity usersEntity;

    public void onReceive(final Context context2, Intent intent) {
        String encode;
        this.databaseAccess = (DatabaseAccess) Room.databaseBuilder(context2, DatabaseAccess.class, DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        DatabaseAccess databaseAccess2 = this.databaseAccess;
        if (databaseAccess2 != null) {
            this.appSettingsEntity = databaseAccess2.daoAccess().fetchAppSettingsEntityById(1);
            String str = null;
            Boolean bool = false;
            AppSettingsEntity appSettingsEntity2 = this.appSettingsEntity;
            if (appSettingsEntity2 != null) {
                str = appSettingsEntity2.getGET_SMS_URL();
                bool = this.appSettingsEntity.getGET_SMS_SWITCH();
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                try {
                    String string = extras.getString("phone");
                    String string2 = extras.getString("message");
                    if (str != null) {
                        try {
                            if (bool.booleanValue()) {
                                Notification.Builder contentTitle = new Notification.Builder(context2).setSmallIcon(R.drawable.mobile).setContentTitle("SMS Receiver Service");
                                Notification.Builder when = contentTitle.setTicker("SMS received by " + string + " and posted to service").setWhen(System.currentTimeMillis());
                                ((NotificationManager) context2.getSystemService("notification")).notify(0, when.setContentText("SMS received by " + string + " and posted to service").setPriority(2).build());
                                RequestQueue newRequestQueue = Volley.newRequestQueue(context2);
                                try {
                                    encode = URLEncoder.encode(string2, "UTF-8");
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                newRequestQueue.add(new JsonObjectRequest(0, str + "?phoneNumber=" + string + "&message=" + encode, null, new Response.Listener<JSONObject>() {
                                    /* class com.gsmmodem.MySMSReceiver.AnonymousClass1 */

                                    public void onResponse(JSONObject jSONObject) {
                                        try {
                                            Integer valueOf = Integer.valueOf(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
                                            String string = jSONObject.getString("message");
                                            Context context = context2;
                                            Toast.makeText(context, "Status: " + valueOf + " | Message: " + string, 0).show();
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }, new Response.ErrorListener() {
                                    /* class com.gsmmodem.MySMSReceiver.AnonymousClass2 */

                                    @Override // com.android.volley.Response.ErrorListener
                                    public void onErrorResponse(VolleyError volleyError) {
                                        Toast.makeText(context2, "Error Occurred!", 0).show();
                                    }
                                }));
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    Log.e("SmsReceiver", "Exception smsReceiver" + e3);
                }
            }
        }
    }
}
