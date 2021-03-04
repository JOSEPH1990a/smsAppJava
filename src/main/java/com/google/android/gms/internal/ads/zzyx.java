package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@zzark
public final class zzyx {
    private final boolean zzbli;
    private final int zzcjs;
    private final String zzcjt;
    private final int zzcjv;
    private final int zzcjy;
    private final String zzcjz;
    private final String zzckb;
    private final Bundle zzckd;
    private final String zzckf;
    private final boolean zzckh;
    private final Bundle zzclz;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzcma;
    private final SearchAdRequest zzcmb;
    private final Set<String> zzcmc;
    private final Set<String> zzcmd;
    private final zzbjc zzcme;
    private final Date zzih;
    private final Set<String> zzij;
    private final Location zzil;

    public zzyx(zzyy zzyy) {
        this(zzyy, null);
    }

    public zzyx(zzyy zzyy, SearchAdRequest searchAdRequest) {
        this.zzih = zzyy.zza(zzyy);
        this.zzckb = zzyy.zzb(zzyy);
        this.zzcjv = zzyy.zzc(zzyy);
        this.zzij = Collections.unmodifiableSet(zzyy.zzd(zzyy));
        this.zzil = zzyy.zze(zzyy);
        this.zzbli = zzyy.zzf(zzyy);
        this.zzclz = zzyy.zzg(zzyy);
        this.zzcma = Collections.unmodifiableMap(zzyy.zzh(zzyy));
        this.zzcjz = zzyy.zzi(zzyy);
        this.zzckf = zzyy.zzj(zzyy);
        this.zzcmb = searchAdRequest;
        this.zzcjy = zzyy.zzk(zzyy);
        this.zzcmc = Collections.unmodifiableSet(zzyy.zzl(zzyy));
        this.zzckd = zzyy.zzm(zzyy);
        this.zzcmd = Collections.unmodifiableSet(zzyy.zzn(zzyy));
        this.zzckh = zzyy.zzo(zzyy);
        this.zzcme = null;
        this.zzcjs = zzyy.zzp(zzyy);
        this.zzcjt = zzyy.zzq(zzyy);
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzih;
    }

    public final String getContentUrl() {
        return this.zzckb;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcjv;
    }

    public final Set<String> getKeywords() {
        return this.zzij;
    }

    public final Location getLocation() {
        return this.zzil;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbli;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzcma.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzclz.getBundle(cls.getName());
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzclz.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final String getPublisherProvidedId() {
        return this.zzcjz;
    }

    public final String zzqi() {
        return this.zzckf;
    }

    public final SearchAdRequest zzqj() {
        return this.zzcmb;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.zzcmc;
        zzwu.zzpv();
        return set.contains(zzbat.zzbf(context));
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqk() {
        return this.zzcma;
    }

    public final Bundle zzql() {
        return this.zzclz;
    }

    public final int zzqm() {
        return this.zzcjy;
    }

    public final Bundle getCustomTargeting() {
        return this.zzckd;
    }

    public final Set<String> zzqn() {
        return this.zzcmd;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzckh;
    }

    public final int zzqo() {
        return this.zzcjs;
    }

    @Nullable
    public final String zzqp() {
        return this.zzcjt;
    }
}
