package com.gsmmodem;

import android.arch.persistence.room.Room;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.gsmmodem.dao_impl.DatabaseAccess;
import com.gsmmodem.entities.UsersEntity;
import java.util.ArrayList;

public class UserManagement extends AppCompatActivity {
    private static final String DATABASE_NAME = "gsm_modem_db";
    private CoordinatorLayout coordinatorLayout;
    private Cursor cursor;
    private CustomUserListAdapter customUserListAdapter;
    private DatabaseAccess databaseAccess;
    private CheckBox isCheckedBox;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private PopupWindow mPopupWindow;
    private EditText passwordEdit;
    ListView userListView;
    private EditText userNameEdit;
    private ArrayList<UsersEntity> usersEntities;

    /* access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.SupportActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_management);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.userListView = (ListView) findViewById(R.id.usersList);
        this.userListView.post(new Runnable() {
            /* class com.gsmmodem.UserManagement.AnonymousClass1 */

            public void run() {
                UserManagement userManagement = UserManagement.this;
                userManagement.databaseAccess = (DatabaseAccess) Room.databaseBuilder(userManagement.getApplicationContext(), DatabaseAccess.class, UserManagement.DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
                MobileAds.initialize(UserManagement.this.getApplicationContext(), UserManagement.this.getString(R.string.admob_app_id));
                UserManagement userManagement2 = UserManagement.this;
                userManagement2.mAdView = (AdView) userManagement2.findViewById(R.id.adView);
                UserManagement.this.mAdView.loadAd(new AdRequest.Builder().build());
                UserManagement userManagement3 = UserManagement.this;
                userManagement3.mInterstitialAd = new InterstitialAd(userManagement3.getApplicationContext());
                UserManagement.this.mInterstitialAd.setAdUnitId(UserManagement.this.getString(R.string.interstitial_ad_unit_id));
                UserManagement.this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
                UserManagement userManagement4 = UserManagement.this;
                userManagement4.cursor = userManagement4.databaseAccess.daoAccess().fetchUsersAll();
                if (UserManagement.this.cursor != null) {
                    UserManagement.this.usersEntities = new ArrayList();
                    if (UserManagement.this.cursor.moveToFirst()) {
                        do {
                            UsersEntity usersEntity = new UsersEntity();
                            usersEntity.setId(Integer.valueOf(UserManagement.this.cursor.getInt(UserManagement.this.cursor.getColumnIndex("id"))));
                            usersEntity.setName(UserManagement.this.cursor.getString(UserManagement.this.cursor.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME)));
                            usersEntity.setPassword(UserManagement.this.cursor.getString(UserManagement.this.cursor.getColumnIndex("password")));
                            usersEntity.setChecked(Boolean.valueOf(UserManagement.this.cursor.getInt(UserManagement.this.cursor.getColumnIndex("isChecked")) > 0));
                            UserManagement.this.usersEntities.add(usersEntity);
                        } while (UserManagement.this.cursor.moveToNext());
                    }
                    UserManagement.this.updateUsersList();
                }
            }
        });
        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.user_management);
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            /* class com.gsmmodem.UserManagement.AnonymousClass2 */

            public void onClick(View view) {
                View inflate = ((LayoutInflater) UserManagement.this.getApplicationContext().getSystemService("layout_inflater")).inflate(R.layout.window_add_user, (ViewGroup) null);
                UserManagement.this.mPopupWindow = new PopupWindow(inflate, -2, -2);
                if (Build.VERSION.SDK_INT >= 21) {
                    UserManagement.this.mPopupWindow.setElevation(5.0f);
                }
                ((ImageButton) inflate.findViewById(R.id.ib_close)).setOnClickListener(new View.OnClickListener() {
                    /* class com.gsmmodem.UserManagement.AnonymousClass2.AnonymousClass1 */

                    public void onClick(View view) {
                        UserManagement.this.mPopupWindow.dismiss();
                    }
                });
                UserManagement.this.userNameEdit = (EditText) inflate.findViewById(R.id.usernameEdit);
                UserManagement.this.passwordEdit = (EditText) inflate.findViewById(R.id.passwordEdit);
                UserManagement.this.isCheckedBox = (CheckBox) inflate.findViewById(R.id.isCheckedEdit);
                ((Button) inflate.findViewById(R.id.saveOrUpdateUser)).setOnClickListener(new View.OnClickListener() {
                    /* class com.gsmmodem.UserManagement.AnonymousClass2.AnonymousClass2 */

                    public void onClick(View view) {
                        UsersEntity usersEntity = new UsersEntity();
                        if (UserManagement.this.userNameEdit.getText() != null && UserManagement.this.userNameEdit.getText().toString().equals("")) {
                            Toast.makeText(UserManagement.this, "Username is required!", 0).show();
                        } else if (UserManagement.this.userNameEdit.getText() != null && UserManagement.this.isUserNameAvailable(UserManagement.this.userNameEdit.getText().toString(), -1).booleanValue()) {
                            Toast.makeText(UserManagement.this, "Username already exists!", 0).show();
                        } else if (UserManagement.this.passwordEdit.getText() == null || !UserManagement.this.passwordEdit.getText().toString().equals("")) {
                            usersEntity.setName(UserManagement.this.userNameEdit.getText().toString());
                            usersEntity.setPassword(UserManagement.this.passwordEdit.getText().toString());
                            usersEntity.setChecked(Boolean.valueOf(UserManagement.this.isCheckedBox.isChecked()));
                            UserManagement.this.databaseAccess.daoAccess().insertUser(usersEntity);
                            UserManagement.this.usersEntities.add(usersEntity);
                            if (UserManagement.this.customUserListAdapter != null) {
                                UserManagement.this.customUserListAdapter.notifyDataSetChanged();
                            }
                            UserManagement.this.mPopupWindow.dismiss();
                        } else {
                            Toast.makeText(UserManagement.this, "Password is required!", 0).show();
                        }
                    }
                });
                UserManagement.this.mPopupWindow.showAtLocation(UserManagement.this.coordinatorLayout, 17, 0, 0);
                UserManagement.this.mPopupWindow.setFocusable(true);
                UserManagement.this.mPopupWindow.update();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void updateUsersList() {
        this.customUserListAdapter = new CustomUserListAdapter(this, this.usersEntities);
        this.userListView.setAdapter((ListAdapter) this.customUserListAdapter);
        this.userListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.gsmmodem.UserManagement.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                final Integer valueOf = Integer.valueOf(i);
                final UsersEntity usersEntity = (UsersEntity) UserManagement.this.userListView.getItemAtPosition(i);
                View inflate = ((LayoutInflater) UserManagement.this.getApplicationContext().getSystemService("layout_inflater")).inflate(R.layout.window_update_delete_user, (ViewGroup) null);
                UserManagement.this.mPopupWindow = new PopupWindow(inflate, -2, -2);
                if (Build.VERSION.SDK_INT >= 21) {
                    UserManagement.this.mPopupWindow.setElevation(5.0f);
                }
                ((ImageButton) inflate.findViewById(R.id.ib_close)).setOnClickListener(new View.OnClickListener() {
                    /* class com.gsmmodem.UserManagement.AnonymousClass3.AnonymousClass1 */

                    public void onClick(View view) {
                        UserManagement.this.mPopupWindow.dismiss();
                    }
                });
                UserManagement.this.userNameEdit = (EditText) inflate.findViewById(R.id.usernameEdit);
                UserManagement.this.userNameEdit.setText(usersEntity.getName());
                UserManagement.this.passwordEdit = (EditText) inflate.findViewById(R.id.passwordEdit);
                UserManagement.this.passwordEdit.setText(usersEntity.getPassword());
                UserManagement.this.isCheckedBox = (CheckBox) inflate.findViewById(R.id.isCheckedEdit);
                UserManagement.this.isCheckedBox.setChecked(usersEntity.getChecked().booleanValue());
                ((Button) inflate.findViewById(R.id.updateUserButton)).setOnClickListener(new View.OnClickListener() {
                    /* class com.gsmmodem.UserManagement.AnonymousClass3.AnonymousClass2 */

                    public void onClick(View view) {
                        if (UserManagement.this.userNameEdit.getText() != null && UserManagement.this.userNameEdit.getText().toString().equals("")) {
                            Toast.makeText(UserManagement.this, "Username is required!", 0).show();
                        } else if (UserManagement.this.userNameEdit.getText() != null && UserManagement.this.isUserNameAvailable(UserManagement.this.userNameEdit.getText().toString(), valueOf).booleanValue()) {
                            Toast.makeText(UserManagement.this, "Username already exists!", 0).show();
                        } else if (UserManagement.this.passwordEdit.getText() == null || !UserManagement.this.passwordEdit.getText().toString().equals("")) {
                            usersEntity.setName(UserManagement.this.userNameEdit.getText().toString());
                            usersEntity.setPassword(UserManagement.this.passwordEdit.getText().toString());
                            usersEntity.setChecked(Boolean.valueOf(UserManagement.this.isCheckedBox.isChecked()));
                            UserManagement.this.databaseAccess.daoAccess().updateUser(usersEntity);
                            UserManagement.this.usersEntities.set(valueOf.intValue(), usersEntity);
                            if (UserManagement.this.customUserListAdapter != null) {
                                UserManagement.this.customUserListAdapter.notifyDataSetChanged();
                            }
                            UserManagement.this.mPopupWindow.dismiss();
                        } else {
                            Toast.makeText(UserManagement.this, "Password is required!", 0).show();
                        }
                    }
                });
                ((Button) inflate.findViewById(R.id.deleteUserButton)).setOnClickListener(new View.OnClickListener() {
                    /* class com.gsmmodem.UserManagement.AnonymousClass3.AnonymousClass3 */

                    public void onClick(View view) {
                        UserManagement.this.databaseAccess.daoAccess().deleteUser(usersEntity);
                        UserManagement.this.usersEntities.remove(usersEntity);
                        if (UserManagement.this.customUserListAdapter != null) {
                            UserManagement.this.customUserListAdapter.notifyDataSetChanged();
                        }
                        UserManagement.this.mPopupWindow.dismiss();
                    }
                });
                UserManagement.this.mPopupWindow.showAtLocation(UserManagement.this.coordinatorLayout, 17, 0, 0);
                UserManagement.this.mPopupWindow.setFocusable(true);
                UserManagement.this.mPopupWindow.update();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Boolean isUserNameAvailable(String str, Integer num) {
        for (Integer num2 = 0; num2.intValue() < this.usersEntities.size(); num2 = Integer.valueOf(num2.intValue() + 1)) {
            if (str.equalsIgnoreCase(this.usersEntities.get(num2.intValue()).getName()) && num != num2) {
                return true;
            }
        }
        return false;
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
