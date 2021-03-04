package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.ArrayList;
import java.util.List;

@zzark
public final class zzada extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zzdab = new ArrayList();
    private final zzacx zzddp;
    private String zzddq;

    public zzada(zzacx zzacx) {
        zzadb zzadb;
        IBinder iBinder;
        this.zzddp = zzacx;
        try {
            this.zzddq = this.zzddp.getText();
        } catch (RemoteException e) {
            zzbbd.zzb("", e);
            this.zzddq = "";
        }
        try {
            for (zzadb zzadb2 : zzacx.zzro()) {
                if (!(zzadb2 instanceof IBinder) || (iBinder = (IBinder) zzadb2) == null) {
                    zzadb = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                    zzadb = queryLocalInterface instanceof zzadb ? (zzadb) queryLocalInterface : new zzadd(iBinder);
                }
                if (zzadb != null) {
                    this.zzdab.add(new zzade(zzadb));
                }
            }
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final CharSequence getText() {
        return this.zzddq;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo
    public final List<NativeAd.Image> getImages() {
        return this.zzdab;
    }
}
