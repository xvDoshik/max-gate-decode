package com.google.firebase.installations.local;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_PersistedInstallationEntry {
    public final String authToken;
    public final long expiresInSecs;
    public final String firebaseInstallationId;
    public final String fisError;
    public final String refreshToken;
    public final int registrationStatus;
    public final long tokenCreationEpochInSecs;

    public final class Builder {
        public String authToken;
        public Long expiresInSecs;
        public String firebaseInstallationId;
        public String fisError;
        public String refreshToken;
        public int registrationStatus;
        public Long tokenCreationEpochInSecs;

        public final AutoValue_PersistedInstallationEntry build() {
            String strDecode = this.registrationStatus == 0 ? C0000.decode(new byte[]{17, 16, 3, 84, 91, 75, 66, 23, 87, 77, 81, 14, 95, 49, 18, 82, 70, 77, 69}, "1bf3286e698a", 0.0f) : "";
            if (this.expiresInSecs == null) {
                strDecode = strDecode.concat(C0000.decode(new byte[]{17, 7, 76, 66, 88, 65, 93, 67, 121, 11, 98, 7, 87, 65}, "1b4213800e", 0.0f));
            }
            if (this.tokenCreationEpochInSecs == null) {
                strDecode = strDecode + C0000.decode(new byte[]{21, 71, 91, 83, 3, 90, 114, 71, 82, 88, 71, 93, 11, 95, 36, 17, 90, 80, 92, 113, 8, 103, 84, 86, 68}, "5348f4157934d1aa");
            }
            if (strDecode.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.firebaseInstallationId, this.registrationStatus, this.authToken, this.refreshToken, this.expiresInSecs.longValue(), this.tokenCreationEpochInSecs.longValue(), this.fisError);
            }
            throw new IllegalStateException(C0000.decode(new byte[]{127, 80, 66, 18, 95, 12, 80, 21, 22, 83, 68, 69, 93, 70, 87, 93, 17, 17, 68, 13, 71, 80, 22, 66, 92, 85, 71, 14}, "291a6b75d65044", false).concat(strDecode));
        }
    }

    public AutoValue_PersistedInstallationEntry(String str, int i, String str2, String str3, long j, long j2, String str4) {
        this.firebaseInstallationId = str;
        this.registrationStatus = i;
        this.authToken = str2;
        this.refreshToken = str3;
        this.expiresInSecs = j;
        this.tokenCreationEpochInSecs = j2;
        this.fisError = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_PersistedInstallationEntry)) {
            return false;
        }
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry = (AutoValue_PersistedInstallationEntry) obj;
        String str = autoValue_PersistedInstallationEntry.fisError;
        String str2 = autoValue_PersistedInstallationEntry.refreshToken;
        String str3 = autoValue_PersistedInstallationEntry.authToken;
        String str4 = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        String str5 = this.firebaseInstallationId;
        if (str5 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str5.equals(str4)) {
            return false;
        }
        if (!FileSectionType$EnumUnboxingLocalUtility.equals(this.registrationStatus, autoValue_PersistedInstallationEntry.registrationStatus)) {
            return false;
        }
        String str6 = this.authToken;
        if (str6 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str6.equals(str3)) {
            return false;
        }
        String str7 = this.refreshToken;
        if (str7 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str7.equals(str2)) {
            return false;
        }
        if (this.expiresInSecs != autoValue_PersistedInstallationEntry.expiresInSecs || this.tokenCreationEpochInSecs != autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs) {
            return false;
        }
        String str8 = this.fisError;
        if (str8 == null) {
            return str == null;
        }
        return str8.equals(str);
    }

    public final int hashCode() {
        String str = this.firebaseInstallationId;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ FileSectionType$EnumUnboxingLocalUtility.ordinal(this.registrationStatus)) * 1000003;
        String str2 = this.authToken;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.refreshToken;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.expiresInSecs;
        int i = (iHashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.tokenCreationEpochInSecs;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.fisError;
        return (str4 != null ? str4.hashCode() : 0) ^ i2;
    }

    public final Builder toBuilder() {
        Builder builder = new Builder();
        builder.firebaseInstallationId = this.firebaseInstallationId;
        builder.registrationStatus = this.registrationStatus;
        builder.authToken = this.authToken;
        builder.refreshToken = this.refreshToken;
        builder.expiresInSecs = Long.valueOf(this.expiresInSecs);
        builder.tokenCreationEpochInSecs = Long.valueOf(this.tokenCreationEpochInSecs);
        builder.fisError = this.fisError;
        return builder;
    }

    public final String toString() {
        String strDecode;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{98, 82, 17, 68, 11, 64, 76, 82, 86, 126, 13, 68, 22, 82, 84, 91, 83, 67, 10, 88, 12, 118, 86, 67, 64, 78, 24, 81, 11, 65, 93, 85, 83, 68, 6, 126, 12, 64, 76, 86, 94, 91, 2, 67, 11, 92, 86, 126, 86, 10}, "27c7b387", 6));
        sb.append(this.firebaseInstallationId);
        sb.append(C0000.decode(new byte[]{29, 16, 65, 1, 94, 94, 18, 70, 64, 86, 69, 11, 10, 94, 98, 77, 80, 68, 70, 23, 4}, "103d97a2271be019", false));
        int i = this.registrationStatus;
        if (i == 1) {
            strDecode = C0000.decode(new byte[]{34, 53, 109, 117, 126, 102, 97, 111, 117, 127, 38, 49, 113, 50, 43, 46, 45}, "ca90365086ac0fba", 0.0f);
        } else if (i == 2) {
            strDecode = C0000.decode(new byte[]{118, 44, 54, 104, 112, 125, 42, 38, 103, 121, 50, 115, 32}, "8cb778dc58f6d1", true);
        } else if (i == 3) {
            strDecode = C0000.decode(new byte[]{108, 45, 49, 35, 114, 45, 100, 98, 36, 52, 124, 39}, "9ccf5d76af", 0);
        } else if (i != 4) {
            strDecode = i != 5 ? C0000.decode(new byte[]{8, 67, 92, 95}, "f60308f0") : C0000.decode(new byte[]{96, 117, 38, 113, 48, 50, 116, 96, 105, 38, 96, 98, 46, 106}, "20a8cf126c", true);
        } else {
            strDecode = C0000.decode(new byte[]{49, 114, 116, 126, 97, 109, 38, 101, 118, 115}, "c73729", 7);
        }
        sb.append(strDecode);
        sb.append(C0000.decode(new byte[]{30, 24, 80, 68, 65, 94, 108, 94, 15, 1, 92, 5}, "28115681dd"));
        sb.append(this.authToken);
        sb.append(C0000.decode(new byte[]{24, 20, 75, 80, 2, 64, 92, 16, 14, 96, 12, 89, 81, 90, 4}, "4495d29cf4c2", false));
        sb.append(this.refreshToken);
        sb.append(C0000.decode(new byte[]{26, 67, 92, 29, 20, 8, 19, 3, 17, 126, 88, 48, 92, 6, 23, 92}, "6c9edaafb7", 0.0f));
        sb.append(this.expiresInSecs);
        sb.append(C0000.decode(new byte[]{28, 69, 21, 92, 93, 93, 90, 32, 66, 82, 83, 76, 89, 10, 15, 118, 70, 87, 87, 11, 121, 89, 97, 93, 83, 22, 92}, "0ea3684c0728", 0.0f));
        sb.append(this.tokenCreationEpochInSecs);
        sb.append(C0000.decode(new byte[]{28, 16, 85, 95, 74, 113, 67, 67, 89, 23, 91}, "003694116ef5", 7));
        return FileSectionType$EnumUnboxingLocalUtility.m(sb, this.fisError, C0000.decode(new byte[]{74}, "7d6d56df93db", 0.0f));
    }
}
