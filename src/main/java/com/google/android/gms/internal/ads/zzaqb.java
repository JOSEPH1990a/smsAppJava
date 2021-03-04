package com.google.android.gms.internal.ads;

import java.util.List;

/* access modifiers changed from: package-private */
public final class zzaqb implements zzbbm<List<zzabr>, zzabm> {
    private final /* synthetic */ String zzdtr;
    private final /* synthetic */ Integer zzdts;
    private final /* synthetic */ Integer zzdtt;
    private final /* synthetic */ int zzdtu;
    private final /* synthetic */ int zzdtv;
    private final /* synthetic */ int zzdtw;
    private final /* synthetic */ int zzdtx;
    private final /* synthetic */ boolean zzdty;

    zzaqb(zzapw zzapw, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.zzdtr = str;
        this.zzdts = num;
        this.zzdtt = num2;
        this.zzdtu = i;
        this.zzdtv = i2;
        this.zzdtw = i3;
        this.zzdtx = i4;
        this.zzdty = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzbbm
    public final /* synthetic */ zzabm apply(List<zzabr> list) {
        List<zzabr> list2 = list;
        Integer num = null;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        String str = this.zzdtr;
        Integer num2 = this.zzdts;
        Integer num3 = this.zzdtt;
        int i = this.zzdtu;
        if (i > 0) {
            num = Integer.valueOf(i);
        }
        return new zzabm(str, list2, num2, num3, num, this.zzdtv + this.zzdtw, this.zzdtx, this.zzdty);
    }
}
