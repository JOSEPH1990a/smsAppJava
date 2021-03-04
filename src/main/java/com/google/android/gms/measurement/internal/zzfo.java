package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzfo implements zzct {
    private static volatile zzfo zzatg;
    private final zzbw zzada;
    private zzbq zzath;
    private zzaw zzati;
    private zzt zzatj;
    private zzbb zzatk;
    private zzfk zzatl;
    private zzm zzatm;
    private final zzfu zzatn;
    private zzdv zzato;
    private boolean zzatp;
    private boolean zzatq;
    @VisibleForTesting
    private long zzatr;
    private List<Runnable> zzats;
    private int zzatt;
    private int zzatu;
    private boolean zzatv;
    private boolean zzatw;
    private boolean zzatx;
    private FileLock zzaty;
    private FileChannel zzatz;
    private List<Long> zzaua;
    private List<Long> zzaub;
    private long zzauc;
    private boolean zzvz;

    /* access modifiers changed from: package-private */
    public class zza implements zzv {
        zzfw zzaug;
        List<Long> zzauh;
        List<zzft> zzaui;
        private long zzauj;

        private zza() {
        }

        @Override // com.google.android.gms.measurement.internal.zzv
        public final void zzb(zzfw zzfw) {
            Preconditions.checkNotNull(zzfw);
            this.zzaug = zzfw;
        }

        @Override // com.google.android.gms.measurement.internal.zzv
        public final boolean zza(long j, zzft zzft) {
            Preconditions.checkNotNull(zzft);
            if (this.zzaui == null) {
                this.zzaui = new ArrayList();
            }
            if (this.zzauh == null) {
                this.zzauh = new ArrayList();
            }
            if (this.zzaui.size() > 0 && zza(this.zzaui.get(0)) != zza(zzft)) {
                return false;
            }
            long zzvx = this.zzauj + ((long) zzft.zzvx());
            if (zzvx >= ((long) Math.max(0, zzai.zzajc.get().intValue()))) {
                return false;
            }
            this.zzauj = zzvx;
            this.zzaui.add(zzft);
            this.zzauh.add(Long.valueOf(j));
            if (this.zzaui.size() >= Math.max(1, zzai.zzajd.get().intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzft zzft) {
            return ((zzft.zzaxb.longValue() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzfo zzfo, zzfp zzfp) {
            this();
        }
    }

    public static zzfo zzn(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzatg == null) {
            synchronized (zzfo.class) {
                if (zzatg == null) {
                    zzatg = new zzfo(new zzft(context));
                }
            }
        }
        return zzatg;
    }

    private zzfo(zzft zzft) {
        this(zzft, null);
    }

    private zzfo(zzft zzft, zzbw zzbw) {
        this.zzvz = false;
        Preconditions.checkNotNull(zzft);
        this.zzada = zzbw.zza(zzft.zzri, (zzan) null);
        this.zzauc = -1;
        zzfu zzfu = new zzfu(this);
        zzfu.zzq();
        this.zzatn = zzfu;
        zzaw zzaw = new zzaw(this);
        zzaw.zzq();
        this.zzati = zzaw;
        zzbq zzbq = new zzbq(this);
        zzbq.zzq();
        this.zzath = zzbq;
        this.zzada.zzgs().zzc(new zzfp(this, zzft));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzft zzft) {
        this.zzada.zzgs().zzaf();
        zzt zzt = new zzt(this);
        zzt.zzq();
        this.zzatj = zzt;
        this.zzada.zzgv().zza(this.zzath);
        zzm zzm = new zzm(this);
        zzm.zzq();
        this.zzatm = zzm;
        zzdv zzdv = new zzdv(this);
        zzdv.zzq();
        this.zzato = zzdv;
        zzfk zzfk = new zzfk(this);
        zzfk.zzq();
        this.zzatl = zzfk;
        this.zzatk = new zzbb(this);
        if (this.zzatt != this.zzatu) {
            this.zzada.zzgt().zzjg().zze("Not all upload components initialized", Integer.valueOf(this.zzatt), Integer.valueOf(this.zzatu));
        }
        this.zzvz = true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void start() {
        this.zzada.zzgs().zzaf();
        zzjt().zzij();
        if (this.zzada.zzgu().zzana.get() == 0) {
            this.zzada.zzgu().zzana.set(this.zzada.zzbx().currentTimeMillis());
        }
        zzmb();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final zzn zzgw() {
        return this.zzada.zzgw();
    }

    public final zzq zzgv() {
        return this.zzada.zzgv();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final zzas zzgt() {
        return this.zzada.zzgt();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final zzbr zzgs() {
        return this.zzada.zzgs();
    }

    private final zzbq zzls() {
        zza(this.zzath);
        return this.zzath;
    }

    public final zzaw zzlt() {
        zza(this.zzati);
        return this.zzati;
    }

    public final zzt zzjt() {
        zza(this.zzatj);
        return this.zzatj;
    }

    private final zzbb zzlu() {
        zzbb zzbb = this.zzatk;
        if (zzbb != null) {
            return zzbb;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzfk zzlv() {
        zza(this.zzatl);
        return this.zzatl;
    }

    public final zzm zzjs() {
        zza(this.zzatm);
        return this.zzatm;
    }

    public final zzdv zzlw() {
        zza(this.zzato);
        return this.zzato;
    }

    public final zzfu zzjr() {
        zza(this.zzatn);
        return this.zzatn;
    }

    public final zzaq zzgq() {
        return this.zzada.zzgq();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final Context getContext() {
        return this.zzada.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzct
    public final Clock zzbx() {
        return this.zzada.zzbx();
    }

    public final zzfy zzgr() {
        return this.zzada.zzgr();
    }

    @WorkerThread
    private final void zzaf() {
        this.zzada.zzgs().zzaf();
    }

    /* access modifiers changed from: package-private */
    public final void zzlx() {
        if (!this.zzvz) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zza(zzfn zzfn) {
        if (zzfn == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzfn.isInitialized()) {
            String valueOf = String.valueOf(zzfn.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzk zzk) {
        zzaf();
        zzlx();
        Preconditions.checkNotEmpty(zzk.packageName);
        zzg(zzk);
    }

    private final long zzly() {
        long currentTimeMillis = this.zzada.zzbx().currentTimeMillis();
        zzbd zzgu = this.zzada.zzgu();
        zzgu.zzcl();
        zzgu.zzaf();
        long j = zzgu.zzane.get();
        if (j == 0) {
            j = 1 + ((long) zzgu.zzgr().zzmk().nextInt(86400000));
            zzgu.zzane.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(zzag zzag, String str) {
        zzg zzbm = zzjt().zzbm(str);
        if (zzbm == null || TextUtils.isEmpty(zzbm.zzak())) {
            this.zzada.zzgt().zzjn().zzg("No app data available; dropping event", str);
            return;
        }
        Boolean zzc = zzc(zzbm);
        if (zzc == null) {
            if (!"_ui".equals(zzag.name)) {
                this.zzada.zzgt().zzjj().zzg("Could not find package. appId", zzas.zzbw(str));
            }
        } else if (!zzc.booleanValue()) {
            this.zzada.zzgt().zzjg().zzg("App version does not match; dropping event. appId", zzas.zzbw(str));
            return;
        }
        zzc(zzag, new zzk(str, zzbm.getGmpAppId(), zzbm.zzak(), zzbm.zzhf(), zzbm.zzhg(), zzbm.zzhh(), zzbm.zzhi(), (String) null, zzbm.isMeasurementEnabled(), false, zzbm.getFirebaseInstanceId(), zzbm.zzhv(), 0L, 0, zzbm.zzhw(), zzbm.zzhx(), false, zzbm.zzhb()));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzag zzag, zzk zzk) {
        List<zzo> list;
        List<zzo> list2;
        List<zzo> list3;
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk.packageName);
        zzaf();
        zzlx();
        String str = zzk.packageName;
        long j = zzag.zzaig;
        if (zzjr().zze(zzag, zzk)) {
            if (!zzk.zzafr) {
                zzg(zzk);
                return;
            }
            zzjt().beginTransaction();
            try {
                zzt zzjt = zzjt();
                Preconditions.checkNotEmpty(str);
                zzjt.zzaf();
                zzjt.zzcl();
                if (j < 0) {
                    zzjt.zzgt().zzjj().zze("Invalid time querying timed out conditional properties", zzas.zzbw(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzjt.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzo zzo : list) {
                    if (zzo != null) {
                        this.zzada.zzgt().zzjn().zzd("User property timed out", zzo.packageName, this.zzada.zzgq().zzbv(zzo.zzags.name), zzo.zzags.getValue());
                        if (zzo.zzagt != null) {
                            zzd(new zzag(zzo.zzagt, j), zzk);
                        }
                        zzjt().zzk(str, zzo.zzags.name);
                    }
                }
                zzt zzjt2 = zzjt();
                Preconditions.checkNotEmpty(str);
                zzjt2.zzaf();
                zzjt2.zzcl();
                if (j < 0) {
                    zzjt2.zzgt().zzjj().zze("Invalid time querying expired conditional properties", zzas.zzbw(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzjt2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzo zzo2 : list2) {
                    if (zzo2 != null) {
                        this.zzada.zzgt().zzjn().zzd("User property expired", zzo2.packageName, this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
                        zzjt().zzh(str, zzo2.zzags.name);
                        if (zzo2.zzagv != null) {
                            arrayList.add(zzo2.zzagv);
                        }
                        zzjt().zzk(str, zzo2.zzags.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzd(new zzag((zzag) obj, j), zzk);
                }
                zzt zzjt3 = zzjt();
                String str2 = zzag.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzjt3.zzaf();
                zzjt3.zzcl();
                if (j < 0) {
                    zzjt3.zzgt().zzjj().zzd("Invalid time querying triggered conditional properties", zzas.zzbw(str), zzjt3.zzgq().zzbt(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzjt3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzo zzo3 : list3) {
                    if (zzo3 != null) {
                        zzfv zzfv = zzo3.zzags;
                        zzfx zzfx = new zzfx(zzo3.packageName, zzo3.origin, zzfv.name, j, zzfv.getValue());
                        if (zzjt().zza(zzfx)) {
                            this.zzada.zzgt().zzjn().zzd("User property triggered", zzo3.packageName, this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        } else {
                            this.zzada.zzgt().zzjg().zzd("Too many active user properties, ignoring", zzas.zzbw(zzo3.packageName), this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                        }
                        if (zzo3.zzagu != null) {
                            arrayList3.add(zzo3.zzagu);
                        }
                        zzo3.zzags = new zzfv(zzfx);
                        zzo3.active = true;
                        zzjt().zza(zzo3);
                    }
                }
                zzd(zzag, zzk);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzd(new zzag((zzag) obj2, j), zzk);
                }
                zzjt().setTransactionSuccessful();
            } finally {
                zzjt().endTransaction();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:180:0x0780  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x07ad  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x028a  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzd(com.google.android.gms.measurement.internal.zzag r25, com.google.android.gms.measurement.internal.zzk r26) {
        /*
        // Method dump skipped, instructions count: 2044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzd(com.google.android.gms.measurement.internal.zzag, com.google.android.gms.measurement.internal.zzk):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzlz() {
        zzg zzbm;
        String str;
        zzaf();
        zzlx();
        this.zzatx = true;
        try {
            this.zzada.zzgw();
            Boolean zzli = this.zzada.zzgl().zzli();
            if (zzli == null) {
                this.zzada.zzgt().zzjj().zzby("Upload data called on the client side before use of service was decided");
            } else if (zzli.booleanValue()) {
                this.zzada.zzgt().zzjg().zzby("Upload called in the client side when service should be used");
                this.zzatx = false;
                zzmc();
            } else if (this.zzatr > 0) {
                zzmb();
                this.zzatx = false;
                zzmc();
            } else {
                zzaf();
                if (this.zzaua != null) {
                    this.zzada.zzgt().zzjo().zzby("Uploading requested multiple times");
                    this.zzatx = false;
                    zzmc();
                } else if (!zzlt().zzfb()) {
                    this.zzada.zzgt().zzjo().zzby("Network not connected, ignoring upload request");
                    zzmb();
                    this.zzatx = false;
                    zzmc();
                } else {
                    long currentTimeMillis = this.zzada.zzbx().currentTimeMillis();
                    String str2 = null;
                    zzd((String) null, currentTimeMillis - zzq.zzic());
                    long j = this.zzada.zzgu().zzana.get();
                    if (j != 0) {
                        this.zzada.zzgt().zzjn().zzg("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                    }
                    String zzih = zzjt().zzih();
                    if (!TextUtils.isEmpty(zzih)) {
                        if (this.zzauc == -1) {
                            this.zzauc = zzjt().zzio();
                        }
                        List<Pair<zzfw, Long>> zzb = zzjt().zzb(zzih, this.zzada.zzgv().zzb(zzih, zzai.zzaja), Math.max(0, this.zzada.zzgv().zzb(zzih, zzai.zzajb)));
                        if (!zzb.isEmpty()) {
                            Iterator<Pair<zzfw, Long>> it = zzb.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzfw zzfw = (zzfw) it.next().first;
                                if (!TextUtils.isEmpty(zzfw.zzaxv)) {
                                    str = zzfw.zzaxv;
                                    break;
                                }
                            }
                            if (str != null) {
                                int i = 0;
                                while (true) {
                                    if (i >= zzb.size()) {
                                        break;
                                    }
                                    zzfw zzfw2 = (zzfw) zzb.get(i).first;
                                    if (!(TextUtils.isEmpty(zzfw2.zzaxv) || zzfw2.zzaxv.equals(str))) {
                                        zzb = zzb.subList(0, i);
                                        break;
                                    }
                                    i++;
                                }
                            }
                            zzfv zzfv = new zzfv();
                            zzfv.zzaxf = new zzfw[zzb.size()];
                            ArrayList arrayList = new ArrayList(zzb.size());
                            boolean z = zzq.zzie() && this.zzada.zzgv().zzas(zzih);
                            for (int i2 = 0; i2 < zzfv.zzaxf.length; i2++) {
                                zzfv.zzaxf[i2] = (zzfw) zzb.get(i2).first;
                                arrayList.add((Long) zzb.get(i2).second);
                                zzfv.zzaxf[i2].zzaxu = Long.valueOf(this.zzada.zzgv().zzhh());
                                zzfv.zzaxf[i2].zzaxk = Long.valueOf(currentTimeMillis);
                                zzfw zzfw3 = zzfv.zzaxf[i2];
                                this.zzada.zzgw();
                                zzfw3.zzaxz = false;
                                if (!z) {
                                    zzfv.zzaxf[i2].zzayh = null;
                                }
                            }
                            if (this.zzada.zzgt().isLoggable(2)) {
                                str2 = zzjr().zzb(zzfv);
                            }
                            byte[] zza2 = zzjr().zza(zzfv);
                            String str3 = zzai.zzajk.get();
                            try {
                                URL url = new URL(str3);
                                Preconditions.checkArgument(!arrayList.isEmpty());
                                if (this.zzaua != null) {
                                    this.zzada.zzgt().zzjg().zzby("Set uploading progress before finishing the previous upload");
                                } else {
                                    this.zzaua = new ArrayList(arrayList);
                                }
                                this.zzada.zzgu().zzanb.set(currentTimeMillis);
                                String str4 = "?";
                                if (zzfv.zzaxf.length > 0) {
                                    str4 = zzfv.zzaxf[0].zztt;
                                }
                                this.zzada.zzgt().zzjo().zzd("Uploading data. app, uncompressed size, data", str4, Integer.valueOf(zza2.length), str2);
                                this.zzatw = true;
                                zzaw zzlt = zzlt();
                                zzfq zzfq = new zzfq(this, zzih);
                                zzlt.zzaf();
                                zzlt.zzcl();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(zza2);
                                Preconditions.checkNotNull(zzfq);
                                zzlt.zzgs().zzd(new zzba(zzlt, zzih, url, zza2, null, zzfq));
                            } catch (MalformedURLException unused) {
                                this.zzada.zzgt().zzjg().zze("Failed to parse upload URL. Not uploading. appId", zzas.zzbw(zzih), str3);
                            }
                        }
                    } else {
                        this.zzauc = -1;
                        String zzad = zzjt().zzad(currentTimeMillis - zzq.zzic());
                        if (!TextUtils.isEmpty(zzad) && (zzbm = zzjt().zzbm(zzad)) != null) {
                            zzb(zzbm);
                        }
                    }
                    this.zzatx = false;
                    zzmc();
                }
            }
        } finally {
            this.zzatx = false;
            zzmc();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r7 = null;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009e, code lost:
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:518:0x0dc2, code lost:
        r8.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v100 android.database.Cursor) = (r3v98 android.database.Cursor), (r3v98 android.database.Cursor), (r3v98 android.database.Cursor), (r3v98 android.database.Cursor), (r3v0 android.database.Cursor), (r3v0 android.database.Cursor) binds: [B:22:0x0080, B:23:?, B:28:0x0091, B:29:?, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x05b8 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x067e  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x06ff  */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0dab  */
    /* JADX WARNING: Removed duplicated region for block: B:518:0x0dc2  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r44, long r45) {
        /*
        // Method dump skipped, instructions count: 3550
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzd(java.lang.String, long):boolean");
    }

    private final boolean zza(zzft zzft, zzft zzft2) {
        String str;
        Preconditions.checkArgument("_e".equals(zzft.name));
        zzjr();
        zzfu zza2 = zzfu.zza(zzft, "_sc");
        String str2 = null;
        if (zza2 == null) {
            str = null;
        } else {
            str = zza2.zzaml;
        }
        zzjr();
        zzfu zza3 = zzfu.zza(zzft2, "_pc");
        if (zza3 != null) {
            str2 = zza3.zzaml;
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzjr();
        zzfu zza4 = zzfu.zza(zzft, "_et");
        if (zza4.zzaxe == null || zza4.zzaxe.longValue() <= 0) {
            return true;
        }
        long longValue = zza4.zzaxe.longValue();
        zzjr();
        zzfu zza5 = zzfu.zza(zzft2, "_et");
        if (!(zza5 == null || zza5.zzaxe == null || zza5.zzaxe.longValue() <= 0)) {
            longValue += zza5.zzaxe.longValue();
        }
        zzjr();
        zzft2.zzaxa = zzfu.zza(zzft2.zzaxa, "_et", Long.valueOf(longValue));
        zzjr();
        zzft.zzaxa = zzfu.zza(zzft.zzaxa, "_fr", (Object) 1L);
        return true;
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, @NonNull String str) {
        int i = 0;
        while (true) {
            if (i >= zzfuArr.length) {
                i = -1;
                break;
            } else if (str.equals(zzfuArr[i].name)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return zzfuArr;
        }
        return zza(zzfuArr, i);
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, int i) {
        zzfu[] zzfuArr2 = new zzfu[(zzfuArr.length - 1)];
        if (i > 0) {
            System.arraycopy(zzfuArr, 0, zzfuArr2, 0, i);
        }
        if (i < zzfuArr2.length) {
            System.arraycopy(zzfuArr, i + 1, zzfuArr2, i, zzfuArr2.length - i);
        }
        return zzfuArr2;
    }

    @VisibleForTesting
    private static zzfu[] zza(zzfu[] zzfuArr, int i, String str) {
        for (zzfu zzfu : zzfuArr) {
            if ("_err".equals(zzfu.name)) {
                return zzfuArr;
            }
        }
        zzfu[] zzfuArr2 = new zzfu[(zzfuArr.length + 2)];
        System.arraycopy(zzfuArr, 0, zzfuArr2, 0, zzfuArr.length);
        zzfu zzfu2 = new zzfu();
        zzfu2.name = "_err";
        zzfu2.zzaxe = Long.valueOf((long) i);
        zzfu zzfu3 = new zzfu();
        zzfu3.name = "_ev";
        zzfu3.zzaml = str;
        zzfuArr2[zzfuArr2.length - 2] = zzfu2;
        zzfuArr2[zzfuArr2.length - 1] = zzfu3;
        return zzfuArr2;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzaf();
        zzlx();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzatw = false;
                zzmc();
                throw th2;
            }
        }
        List<Long> list = this.zzaua;
        this.zzaua = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzada.zzgu().zzana.set(this.zzada.zzbx().currentTimeMillis());
                this.zzada.zzgu().zzanb.set(0);
                zzmb();
                this.zzada.zzgt().zzjo().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzjt().beginTransaction();
                try {
                    for (Long l : list) {
                        try {
                            zzt zzjt = zzjt();
                            long longValue = l.longValue();
                            zzjt.zzaf();
                            zzjt.zzcl();
                            try {
                                if (zzjt.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                                }
                            } catch (SQLiteException e) {
                                zzjt.zzgt().zzjg().zzg("Failed to delete a bundle in a queue table", e);
                                throw e;
                            }
                        } catch (SQLiteException e2) {
                            if (this.zzaub == null || !this.zzaub.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzjt().setTransactionSuccessful();
                    zzjt().endTransaction();
                    this.zzaub = null;
                    if (!zzlt().zzfb() || !zzma()) {
                        this.zzauc = -1;
                        zzmb();
                    } else {
                        zzlz();
                    }
                    this.zzatr = 0;
                } catch (Throwable th3) {
                    zzjt().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzada.zzgt().zzjg().zzg("Database error while trying to delete uploaded bundles", e3);
                this.zzatr = this.zzada.zzbx().elapsedRealtime();
                this.zzada.zzgt().zzjo().zzg("Disable upload, time", Long.valueOf(this.zzatr));
            }
        } else {
            this.zzada.zzgt().zzjo().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzada.zzgu().zzanb.set(this.zzada.zzbx().currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                this.zzada.zzgu().zzanc.set(this.zzada.zzbx().currentTimeMillis());
            }
            if (this.zzada.zzgv().zzaw(str)) {
                zzjt().zzc(list);
            }
            zzmb();
        }
        this.zzatw = false;
        zzmc();
    }

    private final boolean zzma() {
        zzaf();
        zzlx();
        return zzjt().zzim() || !TextUtils.isEmpty(zzjt().zzih());
    }

    @WorkerThread
    private final void zzb(zzg zzg) {
        ArrayMap arrayMap;
        zzaf();
        if (!TextUtils.isEmpty(zzg.getGmpAppId()) || (zzq.zzig() && !TextUtils.isEmpty(zzg.zzhb()))) {
            zzq zzgv = this.zzada.zzgv();
            Uri.Builder builder = new Uri.Builder();
            String gmpAppId = zzg.getGmpAppId();
            if (TextUtils.isEmpty(gmpAppId) && zzq.zzig()) {
                gmpAppId = zzg.zzhb();
            }
            Uri.Builder encodedAuthority = builder.scheme(zzai.zzaiy.get()).encodedAuthority(zzai.zzaiz.get());
            String valueOf = String.valueOf(gmpAppId);
            encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", zzg.getAppInstanceId()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzgv.zzhh()));
            String uri = builder.build().toString();
            try {
                URL url = new URL(uri);
                this.zzada.zzgt().zzjo().zzg("Fetching remote configuration", zzg.zzal());
                zzfp zzcg = zzls().zzcg(zzg.zzal());
                String zzch = zzls().zzch(zzg.zzal());
                if (zzcg == null || TextUtils.isEmpty(zzch)) {
                    arrayMap = null;
                } else {
                    ArrayMap arrayMap2 = new ArrayMap();
                    arrayMap2.put("If-Modified-Since", zzch);
                    arrayMap = arrayMap2;
                }
                this.zzatv = true;
                zzaw zzlt = zzlt();
                String zzal = zzg.zzal();
                zzfr zzfr = new zzfr(this);
                zzlt.zzaf();
                zzlt.zzcl();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzfr);
                zzlt.zzgs().zzd(new zzba(zzlt, zzal, url, null, arrayMap, zzfr));
            } catch (MalformedURLException unused) {
                this.zzada.zzgt().zzjg().zze("Failed to parse config URL. Not fetching. appId", zzas.zzbw(zzg.zzal()), uri);
            }
        } else {
            zzb(zzg.zzal(), 204, null, null, null);
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014a  */
    @android.support.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
        // Method dump skipped, instructions count: 413
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfo.zzb(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    @WorkerThread
    private final void zzmb() {
        long j;
        long j2;
        zzaf();
        zzlx();
        if (zzmf() || this.zzada.zzgv().zza(zzai.zzald)) {
            if (this.zzatr > 0) {
                long abs = 3600000 - Math.abs(this.zzada.zzbx().elapsedRealtime() - this.zzatr);
                if (abs > 0) {
                    this.zzada.zzgt().zzjo().zzg("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzlu().unregister();
                    zzlv().cancel();
                    return;
                }
                this.zzatr = 0;
            }
            if (!this.zzada.zzkv() || !zzma()) {
                this.zzada.zzgt().zzjo().zzby("Nothing to upload or uploading impossible");
                zzlu().unregister();
                zzlv().cancel();
                return;
            }
            long currentTimeMillis = this.zzada.zzbx().currentTimeMillis();
            long max = Math.max(0L, zzai.zzaju.get().longValue());
            boolean z = zzjt().zzin() || zzjt().zzii();
            if (z) {
                String zzid = this.zzada.zzgv().zzid();
                if (TextUtils.isEmpty(zzid) || ".none.".equals(zzid)) {
                    j = Math.max(0L, zzai.zzajo.get().longValue());
                } else {
                    j = Math.max(0L, zzai.zzajp.get().longValue());
                }
            } else {
                j = Math.max(0L, zzai.zzajn.get().longValue());
            }
            long j3 = this.zzada.zzgu().zzana.get();
            long j4 = this.zzada.zzgu().zzanb.get();
            long max2 = Math.max(zzjt().zzik(), zzjt().zzil());
            if (max2 == 0) {
                j2 = 0;
            } else {
                long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(j3 - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(j4 - currentTimeMillis);
                long max3 = Math.max(abs3, abs4);
                long j5 = abs2 + max;
                if (z && max3 > 0) {
                    j5 = Math.min(abs2, max3) + j;
                }
                j2 = !zzjr().zzb(max3, j) ? max3 + j : j5;
                if (abs4 != 0 && abs4 >= abs2) {
                    int i = 0;
                    while (true) {
                        if (i >= Math.min(20, Math.max(0, zzai.zzajw.get().intValue()))) {
                            j2 = 0;
                            break;
                        }
                        j2 += Math.max(0L, zzai.zzajv.get().longValue()) * (1 << i);
                        if (j2 > abs4) {
                            break;
                        }
                        i++;
                    }
                }
            }
            if (j2 == 0) {
                this.zzada.zzgt().zzjo().zzby("Next upload time is 0");
                zzlu().unregister();
                zzlv().cancel();
            } else if (!zzlt().zzfb()) {
                this.zzada.zzgt().zzjo().zzby("No network");
                zzlu().zzey();
                zzlv().cancel();
            } else {
                long j6 = this.zzada.zzgu().zzanc.get();
                long max4 = Math.max(0L, zzai.zzajl.get().longValue());
                if (!zzjr().zzb(j6, max4)) {
                    j2 = Math.max(j2, j6 + max4);
                }
                zzlu().unregister();
                long currentTimeMillis2 = j2 - this.zzada.zzbx().currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    currentTimeMillis2 = Math.max(0L, zzai.zzajq.get().longValue());
                    this.zzada.zzgu().zzana.set(this.zzada.zzbx().currentTimeMillis());
                }
                this.zzada.zzgt().zzjo().zzg("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzlv().zzh(currentTimeMillis2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzg(Runnable runnable) {
        zzaf();
        if (this.zzats == null) {
            this.zzats = new ArrayList();
        }
        this.zzats.add(runnable);
    }

    @WorkerThread
    private final void zzmc() {
        zzaf();
        if (this.zzatv || this.zzatw || this.zzatx) {
            this.zzada.zzgt().zzjo().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzatv), Boolean.valueOf(this.zzatw), Boolean.valueOf(this.zzatx));
            return;
        }
        this.zzada.zzgt().zzjo().zzby("Stopping uploading service(s)");
        List<Runnable> list = this.zzats;
        if (list != null) {
            for (Runnable runnable : list) {
                runnable.run();
            }
            this.zzats.clear();
        }
    }

    @WorkerThread
    private final Boolean zzc(zzg zzg) {
        try {
            if (zzg.zzhf() != -2147483648L) {
                if (zzg.zzhf() == ((long) Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzg.zzal(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzg.zzal(), 0).versionName;
                if (zzg.zzak() != null && zzg.zzak().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzmd() {
        zzaf();
        try {
            this.zzatz = new RandomAccessFile(new File(this.zzada.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaty = this.zzatz.tryLock();
            if (this.zzaty != null) {
                this.zzada.zzgt().zzjo().zzby("Storage concurrent access okay");
                return true;
            }
            this.zzada.zzgt().zzjg().zzby("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzada.zzgt().zzjg().zzg("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            this.zzada.zzgt().zzjg().zzg("Failed to access storage lock file", e2);
            return false;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzaf();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzada.zzgt().zzjg().zzby("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzada.zzgt().zzjj().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzada.zzgt().zzjg().zzg("Failed to read from channel", e);
            return 0;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzaf();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzada.zzgt().zzjg().zzby("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzada.zzgt().zzjg().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzada.zzgt().zzjg().zzg("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzme() {
        zzaf();
        zzlx();
        if (!this.zzatq) {
            this.zzatq = true;
            zzaf();
            zzlx();
            if ((this.zzada.zzgv().zza(zzai.zzald) || zzmf()) && zzmd()) {
                int zza2 = zza(this.zzatz);
                int zzjd = this.zzada.zzgk().zzjd();
                zzaf();
                if (zza2 > zzjd) {
                    this.zzada.zzgt().zzjg().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzjd));
                } else if (zza2 < zzjd) {
                    if (zza(zzjd, this.zzatz)) {
                        this.zzada.zzgt().zzjo().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzjd));
                    } else {
                        this.zzada.zzgt().zzjg().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzjd));
                    }
                }
            }
        }
        if (!this.zzatp && !this.zzada.zzgv().zza(zzai.zzald)) {
            this.zzada.zzgt().zzjm().zzby("This instance being marked as an uploader");
            this.zzatp = true;
            zzmb();
        }
    }

    @WorkerThread
    private final boolean zzmf() {
        zzaf();
        zzlx();
        return this.zzatp;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzd(zzk zzk) {
        if (this.zzaua != null) {
            this.zzaub = new ArrayList();
            this.zzaub.addAll(this.zzaua);
        }
        zzt zzjt = zzjt();
        String str = zzk.packageName;
        Preconditions.checkNotEmpty(str);
        zzjt.zzaf();
        zzjt.zzcl();
        try {
            SQLiteDatabase writableDatabase = zzjt.getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("apps", "app_id=?", strArr) + 0 + writableDatabase.delete("events", "app_id=?", strArr) + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("queue", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzjt.zzgt().zzjo().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzjt.zzgt().zzjg().zze("Error resetting analytics data. appId, error", zzas.zzbw(str), e);
        }
        zzk zza2 = zza(this.zzada.getContext(), zzk.packageName, zzk.zzafi, zzk.zzafr, zzk.zzaft, zzk.zzafu, zzk.zzago, zzk.zzafv);
        if (!this.zzada.zzgv().zzba(zzk.packageName) || zzk.zzafr) {
            zzf(zza2);
        }
    }

    private final zzk zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        String str5;
        int i;
        String str6 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzada.zzgt().zzjg().zzby("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str6 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException unused) {
            this.zzada.zzgt().zzjg().zzg("Error retrieving installer package name. appId", zzas.zzbw(str));
        }
        if (str6 == null) {
            str4 = "manual_install";
        } else {
            str4 = "com.android.vending".equals(str6) ? "" : str6;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    applicationLabel.toString();
                }
                str5 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                str5 = "Unknown";
                i = Integer.MIN_VALUE;
            }
            this.zzada.zzgw();
            return new zzk(str, str2, str5, (long) i, str4, this.zzada.zzgv().zzhh(), this.zzada.zzgr().zzd(context, str), (String) null, z, false, "", 0L, this.zzada.zzgv().zzbc(str) ? j : 0, 0, z2, z3, false, str3);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.zzada.zzgt().zzjg().zze("Error retrieving newly installed package info. appId, appName", zzas.zzbw(str), "Unknown");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzfv zzfv, zzk zzk) {
        zzaf();
        zzlx();
        if (TextUtils.isEmpty(zzk.zzafi) && TextUtils.isEmpty(zzk.zzafv)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
            return;
        }
        int zzcv = this.zzada.zzgr().zzcv(zzfv.name);
        if (zzcv != 0) {
            this.zzada.zzgr();
            this.zzada.zzgr().zza(zzk.packageName, zzcv, "_ev", zzfy.zza(zzfv.name, 24, true), zzfv.name != null ? zzfv.name.length() : 0);
            return;
        }
        int zzi = this.zzada.zzgr().zzi(zzfv.name, zzfv.getValue());
        if (zzi != 0) {
            this.zzada.zzgr();
            String zza2 = zzfy.zza(zzfv.name, 24, true);
            Object value = zzfv.getValue();
            this.zzada.zzgr().zza(zzk.packageName, zzi, "_ev", zza2, (value == null || (!(value instanceof String) && !(value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
            return;
        }
        Object zzj = this.zzada.zzgr().zzj(zzfv.name, zzfv.getValue());
        if (zzj != null) {
            if (this.zzada.zzgv().zzbh(zzk.packageName) && "_sno".equals(zzfv.name)) {
                long j = 0;
                zzfx zzi2 = zzjt().zzi(zzk.packageName, "_sno");
                if (zzi2 == null || !(zzi2.value instanceof Long)) {
                    zzac zzg = zzjt().zzg(zzk.packageName, "_s");
                    if (zzg != null) {
                        j = zzg.zzahv;
                        this.zzada.zzgt().zzjo().zzg("Backfill the session number. Last used session number", Long.valueOf(j));
                    }
                } else {
                    j = ((Long) zzi2.value).longValue();
                }
                zzj = Long.valueOf(j + 1);
            }
            zzfx zzfx = new zzfx(zzk.packageName, zzfv.origin, zzfv.name, zzfv.zzauk, zzj);
            this.zzada.zzgt().zzjn().zze("Setting user property", this.zzada.zzgq().zzbv(zzfx.name), zzj);
            zzjt().beginTransaction();
            try {
                zzg(zzk);
                boolean zza3 = zzjt().zza(zzfx);
                zzjt().setTransactionSuccessful();
                if (zza3) {
                    this.zzada.zzgt().zzjn().zze("User property set", this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                } else {
                    this.zzada.zzgt().zzjg().zze("Too many unique user properties are set. Ignoring user property", this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                    this.zzada.zzgr().zza(zzk.packageName, 9, (String) null, (String) null, 0);
                }
            } finally {
                zzjt().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzfv zzfv, zzk zzk) {
        zzaf();
        zzlx();
        if (TextUtils.isEmpty(zzk.zzafi) && TextUtils.isEmpty(zzk.zzafv)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
            return;
        }
        this.zzada.zzgt().zzjn().zzg("Removing user property", this.zzada.zzgq().zzbv(zzfv.name));
        zzjt().beginTransaction();
        try {
            zzg(zzk);
            zzjt().zzh(zzk.packageName, zzfv.name);
            zzjt().setTransactionSuccessful();
            this.zzada.zzgt().zzjn().zzg("User property removed", this.zzada.zzgq().zzbv(zzfv.name));
        } finally {
            zzjt().endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzfn zzfn) {
        this.zzatt++;
    }

    /* access modifiers changed from: package-private */
    public final void zzmg() {
        this.zzatu++;
    }

    /* access modifiers changed from: package-private */
    public final zzbw zzmh() {
        return this.zzada;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzf(zzk zzk) {
        int i;
        zzac zzac;
        long j;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        boolean z;
        zzaf();
        zzlx();
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk.packageName);
        if (!TextUtils.isEmpty(zzk.zzafi) || !TextUtils.isEmpty(zzk.zzafv)) {
            zzg zzbm = zzjt().zzbm(zzk.packageName);
            if (zzbm != null && TextUtils.isEmpty(zzbm.getGmpAppId()) && !TextUtils.isEmpty(zzk.zzafi)) {
                zzbm.zzu(0);
                zzjt().zza(zzbm);
                zzls().zzcj(zzk.packageName);
            }
            if (!zzk.zzafr) {
                zzg(zzk);
                return;
            }
            long j2 = zzk.zzago;
            if (j2 == 0) {
                j2 = this.zzada.zzbx().currentTimeMillis();
            }
            int i2 = zzk.zzagp;
            if (i2 == 0 || i2 == 1) {
                i = i2;
            } else {
                this.zzada.zzgt().zzjj().zze("Incorrect app type, assuming installed app. appId, appType", zzas.zzbw(zzk.packageName), Integer.valueOf(i2));
                i = 0;
            }
            zzjt().beginTransaction();
            try {
                zzg zzbm2 = zzjt().zzbm(zzk.packageName);
                if (zzbm2 != null) {
                    this.zzada.zzgr();
                    if (zzfy.zza(zzk.zzafi, zzbm2.getGmpAppId(), zzk.zzafv, zzbm2.zzhb())) {
                        this.zzada.zzgt().zzjj().zzg("New GMP App Id passed in. Removing cached database data. appId", zzas.zzbw(zzbm2.zzal()));
                        zzt zzjt = zzjt();
                        String zzal = zzbm2.zzal();
                        zzjt.zzcl();
                        zzjt.zzaf();
                        Preconditions.checkNotEmpty(zzal);
                        try {
                            SQLiteDatabase writableDatabase = zzjt.getWritableDatabase();
                            String[] strArr = {zzal};
                            int delete = writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
                            if (delete > 0) {
                                zzjt.zzgt().zzjo().zze("Deleted application data. app, records", zzal, Integer.valueOf(delete));
                            }
                        } catch (SQLiteException e) {
                            zzjt.zzgt().zzjg().zze("Error deleting application data. appId, error", zzas.zzbw(zzal), e);
                        }
                        zzbm2 = null;
                    }
                }
                if (zzbm2 != null) {
                    if (zzbm2.zzhf() != -2147483648L) {
                        if (zzbm2.zzhf() != zzk.zzafo) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", zzbm2.zzak());
                            zzc(new zzag("_au", new zzad(bundle), "auto", j2), zzk);
                        }
                    } else if (zzbm2.zzak() != null && !zzbm2.zzak().equals(zzk.zzts)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("_pv", zzbm2.zzak());
                        zzc(new zzag("_au", new zzad(bundle2), "auto", j2), zzk);
                    }
                }
                zzg(zzk);
                if (i == 0) {
                    zzac = zzjt().zzg(zzk.packageName, "_f");
                } else {
                    zzac = i == 1 ? zzjt().zzg(zzk.packageName, "_v") : null;
                }
                if (zzac == null) {
                    long j3 = ((j2 / 3600000) + 1) * 3600000;
                    if (i == 0) {
                        j = 1;
                        zzb(new zzfv("_fot", j2, Long.valueOf(j3), "auto"), zzk);
                        if (this.zzada.zzgv().zzbe(zzk.zzafi)) {
                            zzaf();
                            this.zzada.zzkk().zzce(zzk.packageName);
                        }
                        zzaf();
                        zzlx();
                        Bundle bundle3 = new Bundle();
                        bundle3.putLong("_c", 1);
                        bundle3.putLong("_r", 1);
                        bundle3.putLong("_uwa", 0);
                        bundle3.putLong("_pfo", 0);
                        bundle3.putLong("_sys", 0);
                        bundle3.putLong("_sysu", 0);
                        if (this.zzada.zzgv().zzbk(zzk.packageName)) {
                            bundle3.putLong("_et", 1);
                        }
                        if (this.zzada.zzgv().zzba(zzk.packageName) && zzk.zzagq) {
                            bundle3.putLong("_dac", 1);
                        }
                        if (this.zzada.getContext().getPackageManager() == null) {
                            this.zzada.zzgt().zzjg().zzg("PackageManager is null, first open report might be inaccurate. appId", zzas.zzbw(zzk.packageName));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(this.zzada.getContext()).getPackageInfo(zzk.packageName, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                this.zzada.zzgt().zzjg().zze("Package info is null, first open report might be inaccurate. appId", zzas.zzbw(zzk.packageName), e2);
                                packageInfo = null;
                            }
                            if (!(packageInfo == null || packageInfo.firstInstallTime == 0)) {
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    bundle3.putLong("_uwa", 1);
                                    z = false;
                                } else {
                                    z = true;
                                }
                                zzb(new zzfv("_fi", j2, Long.valueOf(z ? 1 : 0), "auto"), zzk);
                            }
                            try {
                                applicationInfo = Wrappers.packageManager(this.zzada.getContext()).getApplicationInfo(zzk.packageName, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                this.zzada.zzgt().zzjg().zze("Application info is null, first open report might be inaccurate. appId", zzas.zzbw(zzk.packageName), e3);
                                applicationInfo = null;
                            }
                            if (applicationInfo != null) {
                                if ((applicationInfo.flags & 1) != 0) {
                                    bundle3.putLong("_sys", 1);
                                }
                                if ((applicationInfo.flags & 128) != 0) {
                                    bundle3.putLong("_sysu", 1);
                                }
                            }
                        }
                        zzt zzjt2 = zzjt();
                        String str = zzk.packageName;
                        Preconditions.checkNotEmpty(str);
                        zzjt2.zzaf();
                        zzjt2.zzcl();
                        long zzn = zzjt2.zzn(str, "first_open_count");
                        if (zzn >= 0) {
                            bundle3.putLong("_pfo", zzn);
                        }
                        zzc(new zzag("_f", new zzad(bundle3), "auto", j2), zzk);
                    } else {
                        j = 1;
                        if (i == 1) {
                            zzb(new zzfv("_fvt", j2, Long.valueOf(j3), "auto"), zzk);
                            zzaf();
                            zzlx();
                            Bundle bundle4 = new Bundle();
                            bundle4.putLong("_c", 1);
                            bundle4.putLong("_r", 1);
                            if (this.zzada.zzgv().zzbk(zzk.packageName)) {
                                bundle4.putLong("_et", 1);
                            }
                            if (this.zzada.zzgv().zzba(zzk.packageName) && zzk.zzagq) {
                                bundle4.putLong("_dac", 1);
                            }
                            zzc(new zzag("_v", new zzad(bundle4), "auto", j2), zzk);
                        }
                    }
                    if (!this.zzada.zzgv().zze(zzk.packageName, zzai.zzala)) {
                        Bundle bundle5 = new Bundle();
                        bundle5.putLong("_et", j);
                        if (this.zzada.zzgv().zzbk(zzk.packageName)) {
                            bundle5.putLong("_fr", j);
                        }
                        zzc(new zzag("_e", new zzad(bundle5), "auto", j2), zzk);
                    }
                } else if (zzk.zzagn) {
                    zzc(new zzag("_cd", new zzad(new Bundle()), "auto", j2), zzk);
                }
                zzjt().setTransactionSuccessful();
            } finally {
                zzjt().endTransaction();
            }
        }
    }

    @WorkerThread
    private final zzk zzcr(String str) {
        zzg zzbm = zzjt().zzbm(str);
        if (zzbm == null || TextUtils.isEmpty(zzbm.zzak())) {
            this.zzada.zzgt().zzjn().zzg("No app data available; dropping", str);
            return null;
        }
        Boolean zzc = zzc(zzbm);
        if (zzc == null || zzc.booleanValue()) {
            return new zzk(str, zzbm.getGmpAppId(), zzbm.zzak(), zzbm.zzhf(), zzbm.zzhg(), zzbm.zzhh(), zzbm.zzhi(), (String) null, zzbm.isMeasurementEnabled(), false, zzbm.getFirebaseInstanceId(), zzbm.zzhv(), 0L, 0, zzbm.zzhw(), zzbm.zzhx(), false, zzbm.zzhb());
        }
        this.zzada.zzgt().zzjg().zzg("App version does not match; dropping. appId", zzas.zzbw(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zze(zzo zzo) {
        zzk zzcr = zzcr(zzo.packageName);
        if (zzcr != null) {
            zzb(zzo, zzcr);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzo zzo, zzk zzk) {
        Preconditions.checkNotNull(zzo);
        Preconditions.checkNotEmpty(zzo.packageName);
        Preconditions.checkNotNull(zzo.origin);
        Preconditions.checkNotNull(zzo.zzags);
        Preconditions.checkNotEmpty(zzo.zzags.name);
        zzaf();
        zzlx();
        if (TextUtils.isEmpty(zzk.zzafi) && TextUtils.isEmpty(zzk.zzafv)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
            return;
        }
        zzo zzo2 = new zzo(zzo);
        boolean z = false;
        zzo2.active = false;
        zzjt().beginTransaction();
        try {
            zzo zzj = zzjt().zzj(zzo2.packageName, zzo2.zzags.name);
            if (zzj != null && !zzj.origin.equals(zzo2.origin)) {
                this.zzada.zzgt().zzjj().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.origin, zzj.origin);
            }
            if (zzj != null && zzj.active) {
                zzo2.origin = zzj.origin;
                zzo2.creationTimestamp = zzj.creationTimestamp;
                zzo2.triggerTimeout = zzj.triggerTimeout;
                zzo2.triggerEventName = zzj.triggerEventName;
                zzo2.zzagu = zzj.zzagu;
                zzo2.active = zzj.active;
                zzo2.zzags = new zzfv(zzo2.zzags.name, zzj.zzags.zzauk, zzo2.zzags.getValue(), zzj.zzags.origin);
            } else if (TextUtils.isEmpty(zzo2.triggerEventName)) {
                zzo2.zzags = new zzfv(zzo2.zzags.name, zzo2.creationTimestamp, zzo2.zzags.getValue(), zzo2.zzags.origin);
                zzo2.active = true;
                z = true;
            }
            if (zzo2.active) {
                zzfv zzfv = zzo2.zzags;
                zzfx zzfx = new zzfx(zzo2.packageName, zzo2.origin, zzfv.name, zzfv.zzauk, zzfv.getValue());
                if (zzjt().zza(zzfx)) {
                    this.zzada.zzgt().zzjn().zzd("User property updated immediately", zzo2.packageName, this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                } else {
                    this.zzada.zzgt().zzjg().zzd("(2)Too many active user properties, ignoring", zzas.zzbw(zzo2.packageName), this.zzada.zzgq().zzbv(zzfx.name), zzfx.value);
                }
                if (z && zzo2.zzagu != null) {
                    zzd(new zzag(zzo2.zzagu, zzo2.creationTimestamp), zzk);
                }
            }
            if (zzjt().zza(zzo2)) {
                this.zzada.zzgt().zzjn().zzd("Conditional property added", zzo2.packageName, this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
            } else {
                this.zzada.zzgt().zzjg().zzd("Too many conditional properties, ignoring", zzas.zzbw(zzo2.packageName), this.zzada.zzgq().zzbv(zzo2.zzags.name), zzo2.zzags.getValue());
            }
            zzjt().setTransactionSuccessful();
        } finally {
            zzjt().endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzf(zzo zzo) {
        zzk zzcr = zzcr(zzo.packageName);
        if (zzcr != null) {
            zzc(zzo, zzcr);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzo zzo, zzk zzk) {
        Preconditions.checkNotNull(zzo);
        Preconditions.checkNotEmpty(zzo.packageName);
        Preconditions.checkNotNull(zzo.zzags);
        Preconditions.checkNotEmpty(zzo.zzags.name);
        zzaf();
        zzlx();
        if (TextUtils.isEmpty(zzk.zzafi) && TextUtils.isEmpty(zzk.zzafv)) {
            return;
        }
        if (!zzk.zzafr) {
            zzg(zzk);
            return;
        }
        zzjt().beginTransaction();
        try {
            zzg(zzk);
            zzo zzj = zzjt().zzj(zzo.packageName, zzo.zzags.name);
            if (zzj != null) {
                this.zzada.zzgt().zzjn().zze("Removing conditional user property", zzo.packageName, this.zzada.zzgq().zzbv(zzo.zzags.name));
                zzjt().zzk(zzo.packageName, zzo.zzags.name);
                if (zzj.active) {
                    zzjt().zzh(zzo.packageName, zzo.zzags.name);
                }
                if (zzo.zzagv != null) {
                    zzd(this.zzada.zzgr().zza(zzo.packageName, zzo.zzagv.name, zzo.zzagv.zzahu != null ? zzo.zzagv.zzahu.zziy() : null, zzj.origin, zzo.zzagv.zzaig, true, false), zzk);
                }
            } else {
                this.zzada.zzgt().zzjj().zze("Conditional user property doesn't exist", zzas.zzbw(zzo.packageName), this.zzada.zzgq().zzbv(zzo.zzags.name));
            }
            zzjt().setTransactionSuccessful();
        } finally {
            zzjt().endTransaction();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final zzg zzg(zzk zzk) {
        boolean z;
        zzaf();
        zzlx();
        Preconditions.checkNotNull(zzk);
        Preconditions.checkNotEmpty(zzk.packageName);
        zzg zzbm = zzjt().zzbm(zzk.packageName);
        String zzca = this.zzada.zzgu().zzca(zzk.packageName);
        if (zzbm == null) {
            zzbm = new zzg(this.zzada, zzk.packageName);
            zzbm.zzaj(this.zzada.zzgr().zzmm());
            zzbm.zzam(zzca);
            z = true;
        } else if (!zzca.equals(zzbm.zzhc())) {
            zzbm.zzam(zzca);
            zzbm.zzaj(this.zzada.zzgr().zzmm());
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(zzk.zzafi, zzbm.getGmpAppId())) {
            zzbm.zzak(zzk.zzafi);
            z = true;
        }
        if (!TextUtils.equals(zzk.zzafv, zzbm.zzhb())) {
            zzbm.zzal(zzk.zzafv);
            z = true;
        }
        if (!TextUtils.isEmpty(zzk.zzafk) && !zzk.zzafk.equals(zzbm.getFirebaseInstanceId())) {
            zzbm.zzan(zzk.zzafk);
            z = true;
        }
        if (!(zzk.zzade == 0 || zzk.zzade == zzbm.zzhh())) {
            zzbm.zzr(zzk.zzade);
            z = true;
        }
        if (!TextUtils.isEmpty(zzk.zzts) && !zzk.zzts.equals(zzbm.zzak())) {
            zzbm.setAppVersion(zzk.zzts);
            z = true;
        }
        if (zzk.zzafo != zzbm.zzhf()) {
            zzbm.zzq(zzk.zzafo);
            z = true;
        }
        if (zzk.zzafp != null && !zzk.zzafp.equals(zzbm.zzhg())) {
            zzbm.zzao(zzk.zzafp);
            z = true;
        }
        if (zzk.zzafq != zzbm.zzhi()) {
            zzbm.zzs(zzk.zzafq);
            z = true;
        }
        if (zzk.zzafr != zzbm.isMeasurementEnabled()) {
            zzbm.setMeasurementEnabled(zzk.zzafr);
            z = true;
        }
        if (!TextUtils.isEmpty(zzk.zzagm) && !zzk.zzagm.equals(zzbm.zzht())) {
            zzbm.zzap(zzk.zzagm);
            z = true;
        }
        if (zzk.zzafs != zzbm.zzhv()) {
            zzbm.zzac(zzk.zzafs);
            z = true;
        }
        if (zzk.zzaft != zzbm.zzhw()) {
            zzbm.zze(zzk.zzaft);
            z = true;
        }
        if (zzk.zzafu != zzbm.zzhx()) {
            zzbm.zzf(zzk.zzafu);
            z = true;
        }
        if (z) {
            zzjt().zza(zzbm);
        }
        return zzbm;
    }

    /* access modifiers changed from: package-private */
    public final String zzh(zzk zzk) {
        try {
            return (String) this.zzada.zzgs().zzb(new zzfs(this, zzk)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzada.zzgt().zzjg().zze("Failed to get app instance id. appId", zzas.zzbw(zzk.packageName), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzm(boolean z) {
        zzmb();
    }
}
