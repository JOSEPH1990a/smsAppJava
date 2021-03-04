package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

final class zzit {
    private final zzpx zzahz = new zzpx(8);
    private int zzaky;

    public final boolean zza(zzia zzia) throws IOException, InterruptedException {
        long length = zzia.getLength();
        long j = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        if (length != -1 && length <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            j = length;
        }
        int i = (int) j;
        zzia.zza(this.zzahz.data, 0, 4);
        long zzhd = this.zzahz.zzhd();
        this.zzaky = 4;
        while (zzhd != 440786851) {
            int i2 = this.zzaky + 1;
            this.zzaky = i2;
            if (i2 == i) {
                return false;
            }
            zzia.zza(this.zzahz.data, 0, 1);
            zzhd = ((zzhd << 8) & -256) | ((long) (this.zzahz.data[0] & 255));
        }
        long zzc = zzc(zzia);
        long j2 = (long) this.zzaky;
        if (zzc == Long.MIN_VALUE || (length != -1 && j2 + zzc >= length)) {
            return false;
        }
        while (true) {
            int i3 = this.zzaky;
            long j3 = j2 + zzc;
            if (((long) i3) < j3) {
                if (zzc(zzia) == Long.MIN_VALUE) {
                    return false;
                }
                long zzc2 = zzc(zzia);
                if (zzc2 < 0 || zzc2 > 2147483647L) {
                    return false;
                }
                if (zzc2 != 0) {
                    zzia.zzx((int) zzc2);
                    this.zzaky = (int) (((long) this.zzaky) + zzc2);
                }
            } else if (((long) i3) == j3) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private final long zzc(zzia zzia) throws IOException, InterruptedException {
        int i = 0;
        zzia.zza(this.zzahz.data, 0, 1);
        int i2 = this.zzahz.data[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (i3 ^ -1);
        zzia.zza(this.zzahz.data, 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.zzahz.data[i] & 255) + (i5 << 8);
        }
        this.zzaky += i4 + 1;
        return (long) i5;
    }
}
