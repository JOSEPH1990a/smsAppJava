package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;

@zzark
public final class zzabm extends zzacy {
    private static final int zzczw = Color.rgb(12, 174, 206);
    private static final int zzczx;
    private static final int zzczy;
    private static final int zzczz = zzczw;
    private final int mTextColor;
    private final String zzdaa;
    private final List<zzabr> zzdab = new ArrayList();
    private final List<zzadb> zzdac = new ArrayList();
    private final int zzdad;
    private final int zzdae;
    private final int zzdaf;
    private final int zzdag;
    private final boolean zzdah;

    public zzabm(String str, List<zzabr> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzdaa = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzabr zzabr = list.get(i3);
                this.zzdab.add(zzabr);
                this.zzdac.add(zzabr);
            }
        }
        this.zzdad = num != null ? num.intValue() : zzczy;
        this.mTextColor = num2 != null ? num2.intValue() : zzczz;
        this.zzdae = num3 != null ? num3.intValue() : 12;
        this.zzdaf = i;
        this.zzdag = i2;
        this.zzdah = z;
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final String getText() {
        return this.zzdaa;
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final List<zzadb> zzro() {
        return this.zzdac;
    }

    public final List<zzabr> zzrp() {
        return this.zzdab;
    }

    public final int getBackgroundColor() {
        return this.zzdad;
    }

    public final int getTextColor() {
        return this.mTextColor;
    }

    public final int getTextSize() {
        return this.zzdae;
    }

    public final int zzrq() {
        return this.zzdaf;
    }

    public final int zzrr() {
        return this.zzdag;
    }

    public final boolean zzrs() {
        return this.zzdah;
    }

    static {
        int rgb = Color.rgb(204, 204, 204);
        zzczx = rgb;
        zzczy = rgb;
    }
}
