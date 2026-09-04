package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new zzb(1);
    public final Intent mData;
    public final int mResultCode;

    public ActivityResult(Intent intent, int i) {
        this.mResultCode = i;
        this.mData = intent;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String strDecode;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{113, 86, 77, 8, 16, 12, 22, 64, 96, 3, 64, 65, 94, 21, 75, 71, 92, 18, 19, 9, 22, 122, 93, 2, 86, 9}, "059afeb92f342a", 0.0f));
        int i = this.mResultCode;
        if (i != -1) {
            strDecode = i != 0 ? String.valueOf(i) : C0000.decode(new byte[]{103, 33, 98, 101, 127, 97, 106, 39, 112, 126, 112, 112, 121, 33, 117}, "5d1035");
        } else {
            strDecode = C0000.decode(new byte[]{106, 124, 53, 108, 47, 96, 59, 124, 122}, "89f9c4d31a", true);
        }
        sb.append(strDecode);
        sb.append(C0000.decode(new byte[]{27, 17, 1, 88, 64, 5, 92}, "71e94da173", 7));
        sb.append(this.mData);
        sb.append('}');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mResultCode);
        Intent intent = this.mData;
        parcel.writeInt(intent == null ? 0 : 1);
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mData = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
