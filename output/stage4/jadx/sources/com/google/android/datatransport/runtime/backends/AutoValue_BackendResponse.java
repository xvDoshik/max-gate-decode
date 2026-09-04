package com.google.android.datatransport.runtime.backends;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_BackendResponse {
    public final long nextRequestWaitMillis;
    public final int status;

    public AutoValue_BackendResponse(int i, long j) {
        if (i == 0) {
            throw new NullPointerException(C0000.decode(new byte[]{122, 64, 85, 85, 20, 23, 71, 82, 64, 19, 66}, "45994d334f10", 0.0f));
        }
        this.status = i;
        this.nextRequestWaitMillis = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_BackendResponse)) {
            return false;
        }
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) obj;
        return FileSectionType$EnumUnboxingLocalUtility.equals(this.status, autoValue_BackendResponse.status) && this.nextRequestWaitMillis == autoValue_BackendResponse.nextRequestWaitMillis;
    }

    public final int hashCode() {
        int iOrdinal = (FileSectionType$EnumUnboxingLocalUtility.ordinal(this.status) ^ 1000003) * 1000003;
        long j = this.nextRequestWaitMillis;
        return iOrdinal ^ ((int) ((j >>> 32) ^ j));
    }

    public final String toString() {
        String strDecode;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{33, 4, 6, 15, 87, 90, 81, 55, 86, 64, 65, 87, 13, 22, 0, 31, 65, 64, 84, 17, 70, 64, 12}, "ceed245e3318"));
        int i = this.status;
        if (i == 1) {
            strDecode = C0000.decode(new byte[]{46, 125}, "a649affe4743a6", 6);
        } else if (i == 2) {
            strDecode = C0000.decode(new byte[]{101, 52, 36, 119, 107, 40, 116, 40, 49, 102, 125, 51, 99, 41, 55}, "1fe98a", 0.0f);
        } else if (i != 3) {
            strDecode = i != 4 ? C0000.decode(new byte[]{94, 19, 84, 8}, "0f8dd08e06b2", true) : C0000.decode(new byte[]{43, 45, 111, 113, 40, 120, 116, 61, 53, 116, 58, 122, 45, 34, 125}, "bc90d10be5c6", 4);
        } else {
            strDecode = C0000.decode(new byte[]{32, 35, 98, 36, 46, 106, 39, 103, 106, 46, 52}, "fb6eb5b58afdfb", false);
        }
        sb.append(strDecode);
        sb.append(C0000.decode(new byte[]{28, 19, 12, 82, 65, 77, 100, 84, 72, 66, 85, 68, 71, 52, 3, 90, 68, 126, 11, 91, 85, 80, 69, 12}, "03b7996197073cb3", false));
        sb.append(this.nextRequestWaitMillis);
        sb.append(C0000.decode(new byte[]{25}, "d866e9480289"));
        return sb.toString();
    }
}
