package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzms implements zzlm, zzlx<zzmj<zzmq>> {
    final int id;
    private final int zzawn;
    private final zzot zzawq;
    private zzln zzawz;
    private final zzkt zzbah;
    private final zzmr zzbax;
    private final long zzbay;
    private final zzpk zzbaz;
    private final zzmt[] zzbba;
    private zzmj<zzmq>[] zzbbb = new zzmj[0];
    private zzla zzbbc = new zzla(this.zzbbb);
    private zznj zzbbd;
    private List<zzni> zzbbe;
    private final zzma zzxk;
    private int zzyr;

    public zzms(int i, zznj zznj, int i2, zzmr zzmr, int i3, zzkt zzkt, long j, zzpk zzpk, zzot zzot) {
        int i4;
        int i5;
        boolean z;
        boolean z2;
        zznm zznm;
        this.id = i;
        this.zzbbd = zznj;
        this.zzyr = i2;
        this.zzbax = zzmr;
        this.zzawn = i3;
        this.zzbah = zzkt;
        this.zzbay = j;
        this.zzbaz = zzpk;
        this.zzawq = zzot;
        this.zzbbe = zznj.zzba(i2).zzbbe;
        List<zzni> list = this.zzbbe;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i6 = 0; i6 < size; i6++) {
            sparseIntArray.put(list.get(i6).id, i6);
        }
        int[][] iArr = new int[size][];
        boolean[] zArr = new boolean[size];
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            if (!zArr[i8]) {
                zArr[i8] = true;
                List<zznm> list2 = list.get(i8).zzbcp;
                int i9 = 0;
                while (true) {
                    if (i9 >= list2.size()) {
                        zznm = null;
                        break;
                    }
                    zznm zznm2 = list2.get(i9);
                    if ("urn:mpeg:dash:adaptation-set-switching:2016".equals(zznm2.zzbdi)) {
                        zznm = zznm2;
                        break;
                    }
                    i9++;
                }
                if (zznm == null) {
                    iArr[i7] = new int[]{i8};
                    i7++;
                } else {
                    String[] split = zznm.value.split(",");
                    int[] iArr2 = new int[(split.length + 1)];
                    iArr2[0] = i8;
                    int i10 = 0;
                    while (i10 < split.length) {
                        int i11 = sparseIntArray.get(Integer.parseInt(split[i10]));
                        zArr[i11] = true;
                        i10++;
                        iArr2[i10] = i11;
                    }
                    iArr[i7] = iArr2;
                    i7++;
                }
            }
        }
        iArr = i7 < size ? (int[][]) Arrays.copyOf(iArr, i7) : iArr;
        int length = iArr.length;
        boolean[] zArr2 = new boolean[length];
        boolean[] zArr3 = new boolean[length];
        int i12 = length;
        for (int i13 = 0; i13 < length; i13++) {
            int[] iArr3 = iArr[i13];
            int length2 = iArr3.length;
            int i14 = 0;
            while (true) {
                if (i14 >= length2) {
                    z = false;
                    break;
                }
                List<zznp> list3 = list.get(iArr3[i14]).zzbcn;
                for (int i15 = 0; i15 < list3.size(); i15++) {
                    if (!list3.get(i15).zzbdo.isEmpty()) {
                        z = true;
                        break;
                    }
                }
                i14++;
            }
            if (z) {
                zArr2[i13] = true;
                i12++;
            }
            int[] iArr4 = iArr[i13];
            int length3 = iArr4.length;
            int i16 = 0;
            while (true) {
                if (i16 >= length3) {
                    z2 = false;
                    break;
                }
                List<zznm> list4 = list.get(iArr4[i16]).zzbco;
                for (int i17 = 0; i17 < list4.size(); i17++) {
                    if ("urn:scte:dash:cc:cea-608:2015".equals(list4.get(i17).zzbdi)) {
                        z2 = true;
                        break;
                    }
                }
                i16++;
            }
            if (z2) {
                zArr3[i13] = true;
                i12++;
            }
        }
        zzlz[] zzlzArr = new zzlz[i12];
        zzmt[] zzmtArr = new zzmt[i12];
        int i18 = 0;
        int i19 = 0;
        while (i18 < length) {
            int[] iArr5 = iArr[i18];
            ArrayList arrayList = new ArrayList();
            for (int i20 : iArr5) {
                arrayList.addAll(list.get(i20).zzbcn);
            }
            zzfs[] zzfsArr = new zzfs[arrayList.size()];
            for (int i21 = 0; i21 < zzfsArr.length; i21++) {
                zzfsArr[i21] = ((zznp) arrayList.get(i21)).zzaad;
            }
            zzni zzni = list.get(iArr5[0]);
            boolean z3 = zArr2[i18];
            boolean z4 = zArr3[i18];
            zzlzArr[i19] = new zzlz(zzfsArr);
            int i22 = i19 + 1;
            zzmtArr[i19] = new zzmt(zzni.type, iArr5, i19, true, z3, z4);
            if (z3) {
                int i23 = zzni.id;
                StringBuilder sb = new StringBuilder(16);
                sb.append(i23);
                sb.append(":emsg");
                zzlzArr[i22] = new zzlz(zzfs.zza(sb.toString(), "application/x-emsg", null, -1, null));
                i4 = i22 + 1;
                zzmtArr[i22] = new zzmt(4, iArr5, i19, false, false, false);
            } else {
                i4 = i22;
            }
            if (z4) {
                int i24 = zzni.id;
                StringBuilder sb2 = new StringBuilder(18);
                sb2.append(i24);
                sb2.append(":cea608");
                zzlzArr[i4] = new zzlz(zzfs.zza(sb2.toString(), "application/cea-608", (String) null, -1, 0, (String) null, (zzhp) null));
                i5 = i4 + 1;
                zzmtArr[i4] = new zzmt(3, iArr5, i19, false, false, false);
            } else {
                i5 = i4;
            }
            i18++;
            i19 = i5;
        }
        Pair create = Pair.create(new zzma(zzlzArr), zzmtArr);
        this.zzxk = (zzma) create.first;
        this.zzbba = (zzmt[]) create.second;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzey() {
        return -9223372036854775807L;
    }

    public final void zza(zznj zznj, int i) {
        this.zzbbd = zznj;
        this.zzyr = i;
        this.zzbbe = zznj.zzba(i).zzbbe;
        zzmj<zzmq>[] zzmjArr = this.zzbbb;
        if (zzmjArr != null) {
            for (zzmj<zzmq> zzmj : zzmjArr) {
                zzmj.zzfy().zza(zznj, i);
            }
            this.zzawz.zza((zzlw) this);
        }
    }

    public final void release() {
        for (zzmj<zzmq> zzmj : this.zzbbb) {
            zzmj.release();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zza(zzln zzln, long j) {
        this.zzawz = zzln;
        zzln.zza((zzlm) this);
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zzew() throws IOException {
        this.zzbaz.zzev();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final zzma zzex() {
        return this.zzxk;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zza(zzom[] zzomArr, boolean[] zArr, zzlv[] zzlvArr, boolean[] zArr2, long j) {
        boolean z;
        zzlv zzlv;
        int i;
        int i2;
        HashMap hashMap = new HashMap();
        char c = 0;
        int i3 = 0;
        while (i3 < zzomArr.length) {
            if (zzlvArr[i3] instanceof zzmj) {
                zzmj zzmj = (zzmj) zzlvArr[i3];
                if (zzomArr[i3] == null || !zArr[i3]) {
                    zzmj.release();
                    zzlvArr[i3] = null;
                } else {
                    hashMap.put(Integer.valueOf(this.zzxk.zza(zzomArr[i3].zzgk())), zzmj);
                }
            }
            if (zzlvArr[i3] != null || zzomArr[i3] == null) {
                i = i3;
            } else {
                int zza = this.zzxk.zza(zzomArr[i3].zzgk());
                zzmt zzmt = this.zzbba[zza];
                if (zzmt.zzbbg) {
                    zzom zzom = zzomArr[i3];
                    int[] iArr = new int[2];
                    boolean z2 = zzmt.zzbbi;
                    if (z2) {
                        iArr[c] = 4;
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    boolean z3 = zzmt.zzbbj;
                    if (z3) {
                        iArr[i2] = 3;
                        i2++;
                    }
                    if (i2 < 2) {
                        iArr = Arrays.copyOf(iArr, i2);
                    }
                    i = i3;
                    zzmj zzmj2 = new zzmj(zzmt.zzwg, iArr, this.zzbax.zza(this.zzbaz, this.zzbbd, this.zzyr, zzmt.zzbbf, zzom, zzmt.zzwg, this.zzbay, z2, z3), this, this.zzawq, j, this.zzawn, this.zzbah);
                    hashMap.put(Integer.valueOf(zza), zzmj2);
                    zzlvArr[i] = zzmj2;
                    zArr2[i] = true;
                } else {
                    i = i3;
                }
            }
            i3 = i + 1;
            c = 0;
        }
        for (int i4 = 0; i4 < zzomArr.length; i4++) {
            if (((zzlvArr[i4] instanceof zzmk) || (zzlvArr[i4] instanceof zzlb)) && (zzomArr[i4] == null || !zArr[i4])) {
                zza(zzlvArr[i4]);
                zzlvArr[i4] = null;
            }
            if (zzomArr[i4] != null) {
                zzmt zzmt2 = this.zzbba[this.zzxk.zza(zzomArr[i4].zzgk())];
                if (!zzmt2.zzbbg) {
                    zzmj<T> zzmj3 = (zzmj) hashMap.get(Integer.valueOf(zzmt2.zzbbh));
                    zzlv zzlv2 = zzlvArr[i4];
                    if (zzmj3 == null) {
                        z = zzlv2 instanceof zzlb;
                    } else {
                        z = (zzlv2 instanceof zzmk) && ((zzmk) zzlv2).zzbap == zzmj3;
                    }
                    if (!z) {
                        zza(zzlv2);
                        if (zzmj3 == null) {
                            zzlv = new zzlb();
                        } else {
                            zzlv = zzmj3.zza(j, zzmt2.zzwg);
                        }
                        zzlvArr[i4] = zzlv;
                        zArr2[i4] = true;
                    }
                }
            }
        }
        this.zzbbb = new zzmj[hashMap.size()];
        hashMap.values().toArray(this.zzbbb);
        this.zzbbc = new zzla(this.zzbbb);
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final void zzaa(long j) {
        for (zzmj<zzmq> zzmj : this.zzbbb) {
            zzmj.zzaf(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlw, com.google.android.gms.internal.ads.zzlm
    public final boolean zzy(long j) {
        return this.zzbbc.zzy(j);
    }

    @Override // com.google.android.gms.internal.ads.zzlw, com.google.android.gms.internal.ads.zzlm
    public final long zzeu() {
        return this.zzbbc.zzeu();
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzez() {
        long j = Long.MAX_VALUE;
        for (zzmj<zzmq> zzmj : this.zzbbb) {
            long zzez = zzmj.zzez();
            if (zzez != Long.MIN_VALUE) {
                j = Math.min(j, zzez);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzlm
    public final long zzab(long j) {
        for (zzmj<zzmq> zzmj : this.zzbbb) {
            zzmj.zzag(j);
        }
        return j;
    }

    private static void zza(zzlv zzlv) {
        if (zzlv instanceof zzmk) {
            ((zzmk) zzlv).release();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzlw] */
    @Override // com.google.android.gms.internal.ads.zzlx
    public final /* synthetic */ void zza(zzmj<zzmq> zzmj) {
        this.zzawz.zza((zzlw) this);
    }
}
