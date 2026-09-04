package com.google.firebase.installations.remote;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.room.RoomOpenHelper;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_TokenResult {
    public final int responseCode;
    public final String token;
    public final long tokenExpirationTimestamp;

    public AutoValue_TokenResult(int i, long j, String str) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = i;
    }

    public static RoomOpenHelper builder() {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper();
        roomOpenHelper.delegate = 0L;
        return roomOpenHelper;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_TokenResult)) {
            return false;
        }
        AutoValue_TokenResult autoValue_TokenResult = (AutoValue_TokenResult) obj;
        int i = autoValue_TokenResult.responseCode;
        String str = autoValue_TokenResult.token;
        String str2 = this.token;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.tokenExpirationTimestamp != autoValue_TokenResult.tokenExpirationTimestamp) {
            return false;
        }
        int i2 = this.responseCode;
        if (i2 == 0) {
            return i == 0;
        }
        return FileSectionType$EnumUnboxingLocalUtility.equals(i2, i);
    }

    public final int hashCode() {
        String str = this.token;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003;
        int i2 = this.responseCode;
        return (i2 != 0 ? FileSectionType$EnumUnboxingLocalUtility.ordinal(i2) : 0) ^ i;
    }

    public final String toString() {
        String strDecode;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{54, 90, 93, 82, 89, 48, 85, 21, 68, 90, 77, 79, 22, 90, 93, 82, 89, 95}, "b5677b0f1694"));
        sb.append(this.token);
        sb.append(C0000.decode(new byte[]{77, 23, 77, 94, 13, 86, 13, 125, 25, 71, 80, 67, 7, 71, 10, 87, 15, 99, 80, 92, 3, 64, 23, 89, 12, 71, 4}, "a791f3c8", 0.0f));
        sb.append(this.tokenExpirationTimestamp);
        sb.append(C0000.decode(new byte[]{78, 67, 75, 82, 70, 20, 91, 91, 67, 4, 115, 93, 83, 87, 95}, "bc975d450a0272", 0.0f));
        int i = this.responseCode;
        if (i == 1) {
            strDecode = C0000.decode(new byte[]{119, 121}, "82f9e685", 0.0f);
        } else if (i != 2) {
            strDecode = i != 3 ? C0000.decode(new byte[]{11, 77, 14, 88}, "e8b44c507904", 7) : C0000.decode(new byte[]{112, 108, 50, 121, 109, 114, 96, 54, 41, 99}, "19f1272df1f2", true);
        } else {
            strDecode = C0000.decode(new byte[]{116, 117, 37, 58, 112, 121, 47, 36, 124, 37}, "64ae36ab5bd37172", 5);
        }
        sb.append(strDecode);
        sb.append(C0000.decode(new byte[]{31}, "bb5c4e1c12", 0.0f));
        return sb.toString();
    }
}
