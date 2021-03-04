package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    @SafeParcelable.Field(id = 6)
    public boolean active;
    @SafeParcelable.Field(id = 5)
    public long creationTimestamp;
    @SafeParcelable.Field(id = 3)
    public String origin;
    @SafeParcelable.Field(id = 2)
    public String packageName;
    @SafeParcelable.Field(id = 11)
    public long timeToLive;
    @SafeParcelable.Field(id = 7)
    public String triggerEventName;
    @SafeParcelable.Field(id = 9)
    public long triggerTimeout;
    @SafeParcelable.Field(id = 4)
    public zzfv zzags;
    @SafeParcelable.Field(id = 8)
    public zzag zzagt;
    @SafeParcelable.Field(id = 10)
    public zzag zzagu;
    @SafeParcelable.Field(id = 12)
    public zzag zzagv;

    zzo(zzo zzo) {
        Preconditions.checkNotNull(zzo);
        this.packageName = zzo.packageName;
        this.origin = zzo.origin;
        this.zzags = zzo.zzags;
        this.creationTimestamp = zzo.creationTimestamp;
        this.active = zzo.active;
        this.triggerEventName = zzo.triggerEventName;
        this.zzagt = zzo.zzagt;
        this.triggerTimeout = zzo.triggerTimeout;
        this.zzagu = zzo.zzagu;
        this.timeToLive = zzo.timeToLive;
        this.zzagv = zzo.zzagv;
    }

    @SafeParcelable.Constructor
    zzo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) zzfv zzfv, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) zzag zzag, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) zzag zzag2, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) zzag zzag3) {
        this.packageName = str;
        this.origin = str2;
        this.zzags = zzfv;
        this.creationTimestamp = j;
        this.active = z;
        this.triggerEventName = str3;
        this.zzagt = zzag;
        this.triggerTimeout = j2;
        this.zzagu = zzag2;
        this.timeToLive = j3;
        this.zzagv = zzag3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.origin, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzags, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.creationTimestamp);
        SafeParcelWriter.writeBoolean(parcel, 6, this.active);
        SafeParcelWriter.writeString(parcel, 7, this.triggerEventName, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzagt, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.triggerTimeout);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzagu, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.timeToLive);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzagv, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
