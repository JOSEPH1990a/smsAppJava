package com.google.android.gms.internal.ads;

@zzark
public final class zzapo extends zzaxv {
    private final zzapm zzdsj;
    private final zzaxg zzdsk;
    private final zzasm zzdsl = this.zzdsk.zzehy;

    public zzapo(zzaxg zzaxg, zzapm zzapm) {
        this.zzdsk = zzaxg;
        this.zzdsj = zzapm;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        zzayh.zzelc.post(new zzapp(this, new zzaxf(this.zzdsk.zzeag.zzdwg, null, null, 0, null, null, this.zzdsl.orientation, this.zzdsl.zzdlx, this.zzdsk.zzeag.zzdwj, false, null, null, null, null, null, this.zzdsl.zzdye, this.zzdsk.zzbst, this.zzdsl.zzdyc, this.zzdsk.zzehn, this.zzdsl.zzdyh, this.zzdsl.zzdyi, this.zzdsk.zzehh, null, null, null, null, this.zzdsk.zzehy.zzdyu, this.zzdsk.zzehy.zzdyv, null, null, null, this.zzdsk.zzehw, this.zzdsk.zzehy.zzbph, this.zzdsk.zzehx, this.zzdsk.zzehy.zzdzc, null, this.zzdsk.zzehy.zzbpi, this.zzdsk.zzehy.zzdzd, this.zzdsk.zzehy.zzdzf)));
    }
}
