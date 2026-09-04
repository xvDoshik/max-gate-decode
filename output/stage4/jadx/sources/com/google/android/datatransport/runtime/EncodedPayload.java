package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class EncodedPayload {
    public final byte[] bytes;
    public final Encoding encoding;

    public EncodedPayload(Encoding encoding, byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException(C0000.decode(new byte[]{1, 11, 83, 90, 5, 93, 15, 80, 66, 13, 64, 65, 88, 65, 84, 95}, "de05a4a7bd3a6483", 3));
        }
        if (bArr == null) {
            throw new NullPointerException(C0000.decode(new byte[]{83, 31, 18, 3, 68, 21, 81, 21, 18, 13, 68, 10, 10}, "1fff758f2c"));
        }
        this.encoding = encoding;
        this.bytes = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (this.encoding.equals(encodedPayload.encoding)) {
            return Arrays.equals(this.bytes, encodedPayload.bytes);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{117, 15, 80, 88, 85, 86, 83, 104, 81, 24, 95, 88, 80, 87, 76, 93, 94, 2, 92, 83, 88, 93, 80, 5}, "0a371378"));
        sb.append(this.encoding);
        sb.append(C0000.decode(new byte[]{26, 70, 91, 79, 70, 81, 22, 89, 110, 74, 79, 29, 108, 76}, "6f9624ed5da311", false));
        return sb.toString();
    }
}
