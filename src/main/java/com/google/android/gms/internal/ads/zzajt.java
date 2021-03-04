package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzu;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzark
public final class zzajt implements zzaic, zzajs {
    private final zzajr zzdjy;
    private final HashSet<AbstractMap.SimpleEntry<String, zzu<? super zzajr>>> zzdjz = new HashSet<>();

    public zzajt(zzajr zzajr) {
        this.zzdjy = zzajr;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(String str, Map map) {
        zzaid.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzahu, com.google.android.gms.internal.ads.zzaic
    public final void zza(String str, JSONObject jSONObject) {
        zzaid.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzais
    public final void zzb(String str, JSONObject jSONObject) {
        zzaid.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaic
    public final void zzh(String str, String str2) {
        zzaid.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaic, com.google.android.gms.internal.ads.zzais
    public final void zzcg(String str) {
        this.zzdjy.zzcg(str);
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, zzu<? super zzajr> zzu) {
        this.zzdjy.zza(str, zzu);
        this.zzdjz.add(new AbstractMap.SimpleEntry<>(str, zzu));
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zzb(String str, zzu<? super zzajr> zzu) {
        this.zzdjy.zzb(str, zzu);
        this.zzdjz.remove(new AbstractMap.SimpleEntry(str, zzu));
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final void zzuh() {
        Iterator<AbstractMap.SimpleEntry<String, zzu<? super zzajr>>> it = this.zzdjz.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzu<? super zzajr>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzaxz.v(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdjy.zzb(next.getKey(), next.getValue());
        }
        this.zzdjz.clear();
    }
}
