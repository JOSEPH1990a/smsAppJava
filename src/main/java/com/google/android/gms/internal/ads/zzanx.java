package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzbv;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

@zzark
public final class zzanx extends zzaok {
    private final Context mContext;
    private final Map<String, String> zzczl;
    private String zzdoz = zzcy("description");
    private long zzdpa = zzcz("start_ticks");
    private long zzdpb = zzcz("end_ticks");
    private String zzdpc = zzcy("summary");
    private String zzdpd = zzcy(FirebaseAnalytics.Param.LOCATION);

    public zzanx(zzbgg zzbgg, Map<String, String> map) {
        super(zzbgg, "createCalendarEvent");
        this.zzczl = map;
        this.mContext = zzbgg.zzabw();
    }

    private final String zzcy(String str) {
        return TextUtils.isEmpty(this.zzczl.get(str)) ? "" : this.zzczl.get(str);
    }

    private final long zzcz(String str) {
        String str2 = this.zzczl.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final void execute() {
        if (this.mContext == null) {
            zzda("Activity context is not available.");
            return;
        }
        zzbv.zzlf();
        if (!zzayh.zzam(this.mContext).zzqu()) {
            zzda("This feature is not available on the device.");
            return;
        }
        zzbv.zzlf();
        AlertDialog.Builder zzal = zzayh.zzal(this.mContext);
        Resources resources = zzbv.zzlj().getResources();
        zzal.setTitle(resources != null ? resources.getString(R.string.s5) : "Create calendar event");
        zzal.setMessage(resources != null ? resources.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        zzal.setPositiveButton(resources != null ? resources.getString(R.string.s3) : "Accept", new zzany(this));
        zzal.setNegativeButton(resources != null ? resources.getString(R.string.s4) : "Decline", new zzanz(this));
        zzal.create().show();
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzdoz);
        data.putExtra("eventLocation", this.zzdpd);
        data.putExtra("description", this.zzdpc);
        long j = this.zzdpa;
        if (j > -1) {
            data.putExtra("beginTime", j);
        }
        long j2 = this.zzdpb;
        if (j2 > -1) {
            data.putExtra("endTime", j2);
        }
        data.setFlags(268435456);
        return data;
    }
}
