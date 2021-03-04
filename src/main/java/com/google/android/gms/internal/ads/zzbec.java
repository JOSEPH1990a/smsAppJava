package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

@zzark
@TargetApi(14)
public final class zzbec implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager mAudioManager;
    private boolean zzeri;
    private final zzbed zzeui;
    private boolean zzeuj;
    private boolean zzeuk;
    private float zzeul = 1.0f;

    public zzbec(Context context, zzbed zzbed) {
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.zzeui = zzbed;
    }

    public final void setMuted(boolean z) {
        this.zzeuk = z;
        zzacg();
    }

    public final void setVolume(float f) {
        this.zzeul = f;
        zzacg();
    }

    public final float getVolume() {
        float f = this.zzeuk ? 0.0f : this.zzeul;
        if (this.zzeuj) {
            return f;
        }
        return 0.0f;
    }

    public final void zzacd() {
        this.zzeri = true;
        zzacg();
    }

    public final void zzace() {
        this.zzeri = false;
        zzacg();
    }

    public final void onAudioFocusChange(int i) {
        this.zzeuj = i > 0;
        this.zzeui.zzabd();
    }

    private final void zzacg() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = this.zzeri && !this.zzeuk && this.zzeul > 0.0f;
        if (z4 && !(z2 = this.zzeuj)) {
            AudioManager audioManager = this.mAudioManager;
            if (audioManager != null && !z2) {
                if (audioManager.requestAudioFocus(this, 3, 2) == 1) {
                    z3 = true;
                }
                this.zzeuj = z3;
            }
            this.zzeui.zzabd();
        } else if (!z4 && (z = this.zzeuj)) {
            AudioManager audioManager2 = this.mAudioManager;
            if (audioManager2 != null && z) {
                if (audioManager2.abandonAudioFocus(this) == 0) {
                    z3 = true;
                }
                this.zzeuj = z3;
            }
            this.zzeui.zzabd();
        }
    }
}
