package com.google.android.datatransport.cct.internal;

import java.util.ArrayList;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_BatchedLogRequest extends BatchedLogRequest {
    public final ArrayList logRequests;

    public AutoValue_BatchedLogRequest(ArrayList arrayList) {
        this.logRequests = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BatchedLogRequest)) {
            return false;
        }
        return this.logRequests.equals(((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
    }

    public final int hashCode() {
        return this.logRequests.hashCode() ^ 1000003;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{117, 88, 67, 90, 13, 81, 83, 117, 88, 94, 55, 81, 70, 76, 82, 74, 17, 79, 91, 86, 80, 107, 0, 69, 66, 92, 68, 77, 22, 9}, "7979e4", false));
        sb.append(this.logRequests);
        sb.append(C0000.decode(new byte[]{31}, "ba5df29bfe"));
        return sb.toString();
    }
}
