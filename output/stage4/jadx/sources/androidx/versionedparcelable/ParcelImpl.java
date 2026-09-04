package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new zzb(5);
    public final VersionedParcelable mParcel;

    public ParcelImpl(Parcel parcel) {
        this.mParcel = new VersionedParcelParcel(parcel).readVersionedParcelable$1();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new VersionedParcelParcel(parcel).writeVersionedParcelable(this.mParcel);
    }
}
