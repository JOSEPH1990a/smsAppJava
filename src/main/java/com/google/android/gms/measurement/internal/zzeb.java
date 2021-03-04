package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdq;
import com.gsmmodem.Servers.MyHttpServer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzeb extends zzf {
    private final zzes zzasb;
    private zzaj zzasc;
    private volatile Boolean zzasd;
    private final zzy zzase;
    private final zzfj zzasf;
    private final List<Runnable> zzasg = new ArrayList();
    private final zzy zzash;

    protected zzeb(zzbw zzbw) {
        super(zzbw);
        this.zzasf = new zzfj(zzbw.zzbx());
        this.zzasb = new zzes(this);
        this.zzase = new zzec(this, zzbw);
        this.zzash = new zzek(this, zzbw);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzgy() {
        return false;
    }

    @WorkerThread
    public final boolean isConnected() {
        zzaf();
        zzcl();
        return this.zzasc != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzlg() {
        zzaf();
        zzcl();
        zzf(new zzel(this, zzl(true)));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzaj zzaj, AbstractSafeParcelable abstractSafeParcelable, zzk zzk) {
        int i;
        List<AbstractSafeParcelable> zzr;
        zzaf();
        zzgg();
        zzcl();
        boolean zzlh = zzlh();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zzlh || (zzr = zzgn().zzr(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zzr);
                i = zzr.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzag) {
                    try {
                        zzaj.zza((zzag) abstractSafeParcelable2, zzk);
                    } catch (RemoteException e) {
                        zzgt().zzjg().zzg("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzfv) {
                    try {
                        zzaj.zza((zzfv) abstractSafeParcelable2, zzk);
                    } catch (RemoteException e2) {
                        zzgt().zzjg().zzg("Failed to send attribute to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzo) {
                    try {
                        zzaj.zza((zzo) abstractSafeParcelable2, zzk);
                    } catch (RemoteException e3) {
                        zzgt().zzjg().zzg("Failed to send conditional property to the service", e3);
                    }
                } else {
                    zzgt().zzjg().zzby("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzc(zzag zzag, String str) {
        Preconditions.checkNotNull(zzag);
        zzaf();
        zzcl();
        boolean zzlh = zzlh();
        zzf(new zzem(this, zzlh, zzlh && zzgn().zza(zzag), zzag, zzl(true), str));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzd(zzo zzo) {
        Preconditions.checkNotNull(zzo);
        zzaf();
        zzcl();
        zzgw();
        zzf(new zzen(this, true, zzgn().zzc(zzo), new zzo(zzo), zzl(true), zzo));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzo>> atomicReference, String str, String str2, String str3) {
        zzaf();
        zzcl();
        zzf(new zzeo(this, atomicReference, str, str2, str3, zzl(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzfv>> atomicReference, String str, String str2, String str3, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzep(this, atomicReference, str, str2, str3, z, zzl(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzdq zzdq, String str, String str2, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzeq(this, str, str2, z, zzl(false), zzdq));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzfv zzfv) {
        zzaf();
        zzcl();
        zzf(new zzer(this, zzlh() && zzgn().zza(zzfv), zzfv, zzl(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzfv>> atomicReference, boolean z) {
        zzaf();
        zzcl();
        zzf(new zzed(this, atomicReference, zzl(false), z));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void resetAnalyticsData() {
        zzaf();
        zzgg();
        zzcl();
        zzk zzl = zzl(false);
        if (zzlh()) {
            zzgn().resetAnalyticsData();
        }
        zzf(new zzee(this, zzl));
    }

    private final boolean zzlh() {
        zzgw();
        return true;
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzaf();
        zzcl();
        zzf(new zzef(this, atomicReference, zzl(false)));
    }

    @WorkerThread
    public final void getAppInstanceId(zzdq zzdq) {
        zzaf();
        zzcl();
        zzf(new zzeg(this, zzl(false), zzdq));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzld() {
        zzaf();
        zzcl();
        zzf(new zzeh(this, zzl(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(zzdx zzdx) {
        zzaf();
        zzcl();
        zzf(new zzei(this, zzdx));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzcy() {
        zzaf();
        this.zzasf.start();
        this.zzase.zzh(zzai.zzaka.get().longValue());
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzdj() {
        boolean z;
        boolean z2;
        zzaf();
        zzcl();
        if (!isConnected()) {
            boolean z3 = false;
            if (this.zzasd == null) {
                zzaf();
                zzcl();
                Boolean zzjx = zzgu().zzjx();
                if (zzjx == null || !zzjx.booleanValue()) {
                    zzgw();
                    if (zzgk().zzje() == 1) {
                        z = true;
                        z2 = true;
                    } else {
                        zzgt().zzjo().zzby("Checking service availability");
                        int zzs = zzgr().zzs(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                        if (zzs == 9) {
                            zzgt().zzjj().zzby("Service invalid");
                            z = false;
                            z2 = false;
                        } else if (zzs != 18) {
                            switch (zzs) {
                                case 0:
                                    zzgt().zzjo().zzby("Service available");
                                    z = true;
                                    z2 = true;
                                    break;
                                case 1:
                                    zzgt().zzjo().zzby("Service missing");
                                    z = false;
                                    z2 = true;
                                    break;
                                case 2:
                                    zzgt().zzjn().zzby("Service container out of date");
                                    if (zzgr().zzml() >= 14500) {
                                        Boolean zzjx2 = zzgu().zzjx();
                                        z = zzjx2 == null || zzjx2.booleanValue();
                                        z2 = false;
                                        break;
                                    } else {
                                        z = false;
                                        z2 = true;
                                        break;
                                    }
                                    break;
                                case 3:
                                    zzgt().zzjj().zzby("Service disabled");
                                    z = false;
                                    z2 = false;
                                    break;
                                default:
                                    zzgt().zzjj().zzg("Unexpected service status", Integer.valueOf(zzs));
                                    z = false;
                                    z2 = false;
                                    break;
                            }
                        } else {
                            zzgt().zzjj().zzby("Service updating");
                            z = true;
                            z2 = true;
                        }
                    }
                    if (!z && zzgv().zzif()) {
                        zzgt().zzjg().zzby("No way to upload. Consider using the full version of Analytics");
                        z2 = false;
                    }
                    if (z2) {
                        zzgu().zzg(z);
                    }
                } else {
                    z = true;
                }
                this.zzasd = Boolean.valueOf(z);
            }
            if (this.zzasd.booleanValue()) {
                this.zzasb.zzll();
            } else if (!zzgv().zzif()) {
                zzgw();
                List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    z3 = true;
                }
                if (z3) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context context = getContext();
                    zzgw();
                    intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zzasb.zzb(intent);
                    return;
                }
                zzgt().zzjg().zzby("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzli() {
        return this.zzasd;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzaj zzaj) {
        zzaf();
        Preconditions.checkNotNull(zzaj);
        this.zzasc = zzaj;
        zzcy();
        zzlj();
    }

    @WorkerThread
    public final void disconnect() {
        zzaf();
        zzcl();
        this.zzasb.zzlk();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzasb);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzasc = null;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzaf();
        if (this.zzasc != null) {
            this.zzasc = null;
            zzgt().zzjo().zzg("Disconnected from device MeasurementService", componentName);
            zzaf();
            zzdj();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzcz() {
        zzaf();
        if (isConnected()) {
            zzgt().zzjo().zzby("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    private final void zzf(Runnable runnable) throws IllegalStateException {
        zzaf();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzasg.size()) >= 1000) {
            zzgt().zzjg().zzby("Discarding data. Max runnable queue size reached");
        } else {
            this.zzasg.add(runnable);
            this.zzash.zzh(MyHttpServer.MINUTE_MILLIS);
            zzdj();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzlj() {
        zzaf();
        zzgt().zzjo().zzg("Processing queued up service tasks", Integer.valueOf(this.zzasg.size()));
        for (Runnable runnable : this.zzasg) {
            try {
                runnable.run();
            } catch (Exception e) {
                zzgt().zzjg().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzasg.clear();
        this.zzash.cancel();
    }

    @WorkerThread
    @Nullable
    private final zzk zzl(boolean z) {
        zzgw();
        return zzgk().zzbs(z ? zzgt().zzjq() : null);
    }

    @WorkerThread
    public final void zza(zzdq zzdq, zzag zzag, String str) {
        zzaf();
        zzcl();
        if (zzgr().zzs(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzgt().zzjj().zzby("Not bundling data. Service unavailable or out of date");
            zzgr().zza(zzdq, new byte[0]);
            return;
        }
        zzf(new zzej(this, zzag, str, zzdq));
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgf() {
        super.zzgf();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgg() {
        super.zzgg();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzgh() {
        super.zzgh();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zza zzgi() {
        return super.zzgi();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzda zzgj() {
        return super.zzgj();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzam zzgk() {
        return super.zzgk();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzeb zzgl() {
        return super.zzgl();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzdy zzgm() {
        return super.zzgm();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzao zzgn() {
        return super.zzgn();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzfd zzgo() {
        return super.zzgo();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaa zzgp() {
        return super.zzgp();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzaq zzgq() {
        return super.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzfy zzgr() {
        return super.zzgr();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzas zzgt() {
        return super.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzbd zzgu() {
        return super.zzgu();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr
    public final /* bridge */ /* synthetic */ zzq zzgv() {
        return super.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzcr, com.google.android.gms.measurement.internal.zzct
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }
}
