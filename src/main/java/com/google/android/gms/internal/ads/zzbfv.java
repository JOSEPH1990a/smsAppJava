package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

@zzark
public final class zzbfv extends zzbfk implements zzpn<zzov> {
    private String url;
    private ByteBuffer zzaep;
    private final zzbdy zzeuo;
    private boolean zzexf;
    private final zzbfu zzexg = new zzbfu();
    private final zzbfc zzexh = new zzbfc();
    private boolean zzexi;
    private final Object zzexj = new Object();
    private boolean zzexk;

    public zzbfv(zzbdz zzbdz, zzbdy zzbdy) {
        super(zzbdz);
        this.zzeuo = zzbdy;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* bridge */ /* synthetic */ void zzc(zzov zzov, int i) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* bridge */ /* synthetic */ void zze(zzov zzov) {
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zzadc() {
        return this.zzexk;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbfk
    public final String zzey(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.zzey(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final void zzabm() {
        int zzl = (int) this.zzexh.zzl(this.zzaep);
        int round = Math.round(((float) zzl) * (((float) this.zzaep.position()) / ((float) ((int) this.zzexg.zzadb()))));
        boolean z = round > 0;
        int zzacx = zzbes.zzacx();
        int zzacy = zzbes.zzacy();
        String str = this.url;
        zza(str, zzey(str), (long) round, (long) zzl, z, zzacx, zzacy);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c2, code lost:
        if (r21.zzaep.remaining() > 0) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c4, code lost:
        zzabm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cb, code lost:
        if (r21.zzexf != false) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cd, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d5, code lost:
        if ((r12 - r16) < r4) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d7, code lost:
        zzabm();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e3, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ed, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010a, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010b, code lost:
        r1 = r21.zzaep.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0130, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0136, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0137, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return true;
     */
    @Override // com.google.android.gms.internal.ads.zzbfk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzex(java.lang.String r22) {
        /*
        // Method dump skipped, instructions count: 422
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfv.zzex(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void abort() {
        this.zzexf = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzexj) {
            if (this.zzaep != null && !this.zzexi) {
                this.zzaep.flip();
                this.zzexi = true;
            }
            this.zzexf = true;
        }
        return this.zzaep;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.google.android.gms.internal.ads.zzoz] */
    @Override // com.google.android.gms.internal.ads.zzpn
    public final /* synthetic */ void zza(zzov zzov, zzoz zzoz) {
        zzov zzov2 = zzov;
        if (zzov2 instanceof zzpb) {
            this.zzexg.zza((zzpb) zzov2);
        }
    }
}
