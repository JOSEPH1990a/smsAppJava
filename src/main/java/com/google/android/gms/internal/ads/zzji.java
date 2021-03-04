package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class zzji implements zzhz {
    private static final zzic zzahq = new zzjj();
    private static final int zzaps = zzqe.zzam("seig");
    private static final byte[] zzapt = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long zzaan;
    private final zzpx zzahx;
    private int zzajm;
    private int zzajn;
    private zzib zzajq;
    private final zzjs zzapu;
    private final SparseArray<zzjl> zzapv;
    private final zzpx zzapw;
    private final zzpx zzapx;
    private final zzpx zzapy;
    private final zzqb zzapz;
    private final zzpx zzaqa;
    private final byte[] zzaqb;
    private final Stack<zziw> zzaqc;
    private final LinkedList<zzjk> zzaqd;
    private int zzaqe;
    private int zzaqf;
    private long zzaqg;
    private int zzaqh;
    private zzpx zzaqi;
    private long zzaqj;
    private int zzaqk;
    private long zzaql;
    private zzjl zzaqm;
    private int zzaqn;
    private boolean zzaqo;
    private zzii zzaqp;
    private zzii[] zzaqq;
    private boolean zzaqr;

    public zzji() {
        this(0);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void release() {
    }

    public zzji(int i) {
        this(i, null);
    }

    private zzji(int i, zzqb zzqb) {
        this(i, null, null);
    }

    private zzji(int i, zzqb zzqb, zzjs zzjs) {
        this.flags = i;
        this.zzapz = null;
        this.zzapu = null;
        this.zzaqa = new zzpx(16);
        this.zzahx = new zzpx(zzpu.zzbhi);
        this.zzapw = new zzpx(5);
        this.zzapx = new zzpx();
        this.zzapy = new zzpx(1);
        this.zzaqb = new byte[16];
        this.zzaqc = new Stack<>();
        this.zzaqd = new LinkedList<>();
        this.zzapv = new SparseArray<>();
        this.zzaan = -9223372036854775807L;
        this.zzaql = -9223372036854775807L;
        zzei();
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final boolean zza(zzia zzia) throws IOException, InterruptedException {
        return zzjr.zzd(zzia);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zza(zzib zzib) {
        this.zzajq = zzib;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zzc(long j, long j2) {
        int size = this.zzapv.size();
        for (int i = 0; i < size; i++) {
            this.zzapv.valueAt(i).reset();
        }
        this.zzaqd.clear();
        this.zzaqk = 0;
        this.zzaqc.clear();
        zzei();
    }

    /* JADX WARNING: Removed duplicated region for block: B:258:0x0367 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x05fd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0004 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0004 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhz
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzia r27, com.google.android.gms.internal.ads.zzif r28) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 1552
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzji.zza(com.google.android.gms.internal.ads.zzia, com.google.android.gms.internal.ads.zzif):int");
    }

    private final void zzei() {
        this.zzaqe = 0;
        this.zzaqh = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:160:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzt(long r55) throws com.google.android.gms.internal.ads.zzfx {
        /*
        // Method dump skipped, instructions count: 1821
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzji.zzt(long):void");
    }

    private static void zza(zzpx zzpx, int i, zzju zzju) throws zzfx {
        zzpx.setPosition(i + 8);
        int zzag = zziv.zzag(zzpx.readInt());
        if ((zzag & 1) == 0) {
            boolean z = (zzag & 2) != 0;
            int zzhg = zzpx.zzhg();
            if (zzhg == zzju.zzapk) {
                Arrays.fill(zzju.zzatf, 0, zzhg, z);
                zzju.zzak(zzpx.zzhb());
                zzpx.zze(zzju.zzati.data, 0, zzju.zzath);
                zzju.zzati.setPosition(0);
                zzju.zzatj = false;
                return;
            }
            int i2 = zzju.zzapk;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(zzhg);
            sb.append(", ");
            sb.append(i2);
            throw new zzfx(sb.toString());
        }
        throw new zzfx("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static zzhp zzb(List<zzix> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            zzix zzix = list.get(i);
            if (zzix.type == zziv.zzamu) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = zzix.zzaos.data;
                UUID zze = zzjq.zze(bArr);
                if (zze == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzhp.zza(zze, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzhp(arrayList);
    }
}
