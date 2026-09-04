package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new zzb(3);
    public FragmentState[] mActive;
    public int[] mAdded;
    public BackStackState[] mBackStack;
    public int mNextFragmentIndex;
    public int mPrimaryNavActiveIndex;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.mActive, i);
        parcel.writeIntArray(this.mAdded);
        parcel.writeTypedArray(this.mBackStack, i);
        parcel.writeInt(this.mPrimaryNavActiveIndex);
        parcel.writeInt(this.mNextFragmentIndex);
    }
}
