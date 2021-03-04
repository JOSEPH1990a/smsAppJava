package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzaeb;
import com.google.android.gms.internal.ads.zzaee;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaek;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzafz;
import com.google.android.gms.internal.ads.zzagf;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxd;
import com.google.android.gms.internal.ads.zzxh;
import com.google.android.gms.internal.ads.zzxz;

@zzark
public final class zzak extends zzxh {
    private final Context mContext;
    private final zzv zzbly;
    private final zzalg zzbma;
    private zzxa zzbnn;
    private zzagf zzbnq;
    private zzwf zzbnt;
    private PublisherAdViewOptions zzbnu;
    private zzacp zzbnx;
    private zzafz zzbny;
    private zzxz zzbnz;
    private final String zzboa;
    private final zzbbi zzbob;
    private zzaeb zzbog;
    private zzaeq zzboh;
    private zzaee zzboi;
    private SimpleArrayMap<String, zzaeh> zzboj = new SimpleArrayMap<>();
    private SimpleArrayMap<String, zzaek> zzbok = new SimpleArrayMap<>();
    private zzaen zzbol;

    public zzak(Context context, String str, zzalg zzalg, zzbbi zzbbi, zzv zzv) {
        this.mContext = context;
        this.zzboa = str;
        this.zzbma = zzalg;
        this.zzbob = zzbbi;
        this.zzbly = zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxd zzkd() {
        return new zzah(this.mContext, this.zzboa, this.zzbma, this.zzbob, this.zzbnn, this.zzbog, this.zzboh, this.zzbnq, this.zzboi, this.zzbok, this.zzboj, this.zzbnx, this.zzbny, this.zzbnz, this.zzbly, this.zzbol, this.zzbnt, this.zzbnu);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzb(zzxa zzxa) {
        this.zzbnn = zzxa;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzacp zzacp) {
        this.zzbnx = zzacp;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzbnu = publisherAdViewOptions;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzb(zzxz zzxz) {
        this.zzbnz = zzxz;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzafz zzafz) {
        this.zzbny = zzafz;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaee zzaee) {
        this.zzboi = zzaee;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaeb zzaeb) {
        this.zzbog = zzaeb;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaeq zzaeq) {
        this.zzboh = zzaeq;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzagf zzagf) {
        this.zzbnq = zzagf;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(String str, zzaek zzaek, zzaeh zzaeh) {
        if (!TextUtils.isEmpty(str)) {
            this.zzbok.put(str, zzaek);
            this.zzboj.put(str, zzaeh);
            return;
        }
        throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaen zzaen, zzwf zzwf) {
        this.zzbol = zzaen;
        this.zzbnt = zzwf;
    }
}
