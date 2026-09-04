package com.google.firebase.installations.remote;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_InstallationResponse {
    public final AutoValue_TokenResult authToken;
    public final String fid;
    public final String refreshToken;
    public final int responseCode;
    public final String uri;

    public AutoValue_InstallationResponse(String str, String str2, String str3, AutoValue_TokenResult autoValue_TokenResult, int i) {
        this.uri = str;
        this.fid = str2;
        this.refreshToken = str3;
        this.authToken = autoValue_TokenResult;
        this.responseCode = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_InstallationResponse)) {
            return false;
        }
        AutoValue_InstallationResponse autoValue_InstallationResponse = (AutoValue_InstallationResponse) obj;
        int i = autoValue_InstallationResponse.responseCode;
        AutoValue_TokenResult autoValue_TokenResult = autoValue_InstallationResponse.authToken;
        String str = autoValue_InstallationResponse.refreshToken;
        String str2 = autoValue_InstallationResponse.fid;
        String str3 = autoValue_InstallationResponse.uri;
        String str4 = this.uri;
        if (str4 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str4.equals(str3)) {
            return false;
        }
        String str5 = this.fid;
        if (str5 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str5.equals(str2)) {
            return false;
        }
        String str6 = this.refreshToken;
        if (str6 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str6.equals(str)) {
            return false;
        }
        AutoValue_TokenResult autoValue_TokenResult2 = this.authToken;
        if (autoValue_TokenResult2 == null) {
            if (autoValue_TokenResult != null) {
                return false;
            }
        } else if (!autoValue_TokenResult2.equals(autoValue_TokenResult)) {
            return false;
        }
        int i2 = this.responseCode;
        if (i2 == 0) {
            return i == 0;
        }
        return FileSectionType$EnumUnboxingLocalUtility.equals(i2, i);
    }

    public final int hashCode() {
        String str = this.uri;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.fid;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.refreshToken;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        AutoValue_TokenResult autoValue_TokenResult = this.authToken;
        int iHashCode4 = (iHashCode3 ^ (autoValue_TokenResult == null ? 0 : autoValue_TokenResult.hashCode())) * 1000003;
        int i = this.responseCode;
        return (i != 0 ? FileSectionType$EnumUnboxingLocalUtility.ordinal(i) : 0) ^ iHashCode4;
    }

    public final String toString() {
        String strDecode;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{44, 10, 17, 22, 89, 8, 9, 5, 22, 11, 87, 10, 55, 1, 17, 18, 87, 10, 22, 1, 25, 23, 74, 13, 88}, "edbb8d", 0.0f));
        sb.append(this.uri);
        sb.append(C0000.decode(new byte[]{24, 18, 83, 92, 84, 12}, "425501f44c", false));
        sb.append(this.fid);
        sb.append(C0000.decode(new byte[]{31, 21, 64, 4, 85, 64, 1, 66, 91, 97, 93, 10, 86, 92, 89}, "352a32d1", 0.0f));
        sb.append(this.refreshToken);
        sb.append(C0000.decode(new byte[]{26, 19, 84, 16, 70, 14, 97, 90, 89, 93, 12, 14}, "635e2f5528b32536", false));
        sb.append(this.authToken);
        sb.append(C0000.decode(new byte[]{28, 24, 67, 7, 71, 68, 94, 11, 23, 86, 115, 86, 84, 93, 12}, "081b441ed309", false));
        int i = this.responseCode;
        if (i != 1) {
            strDecode = i != 2 ? C0000.decode(new byte[]{8, 19, 15, 91}, "ffc72ebd5f", 6) : C0000.decode(new byte[]{39, 113, 37, 58, 34, 126, 43, 118, 40, 34}, "e0aea1", false);
        } else {
            strDecode = C0000.decode(new byte[]{118, 127}, "9467870a", 0.0f);
        }
        sb.append(strDecode);
        sb.append(C0000.decode(new byte[]{27}, "fb96e9ccd7162ff2", true));
        return sb.toString();
    }
}
