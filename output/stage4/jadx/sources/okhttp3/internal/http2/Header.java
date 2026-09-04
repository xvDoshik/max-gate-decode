package okhttp3.internal.http2;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Header {
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;
    public static final ByteString PSEUDO_PREFIX = ByteString.Companion.encodeUtf8(C0000.decode(new byte[]{15}, "508fc5b2c22faa", 5));
    public static final ByteString RESPONSE_STATUS = ByteString.Companion.encodeUtf8(C0000.decode(new byte[]{94, 64, 17, 4, 77, 68, 74}, "d3ee919b23c0", true));
    public static final ByteString TARGET_METHOD = ByteString.Companion.encodeUtf8(C0000.decode(new byte[]{10, 95, 3, 77, 12, 93, 5}, "02f9d2a5684e36"));
    public static final ByteString TARGET_PATH = ByteString.Companion.encodeUtf8(C0000.decode(new byte[]{3, 71, 0, 68, 9}, "97a0a7bd", 0.0f));
    public static final ByteString TARGET_SCHEME = ByteString.Companion.encodeUtf8(C0000.decode(new byte[]{13, 69, 84, 81, 82, 14, 85}, "76797c03b9b9", true));
    public static final ByteString TARGET_AUTHORITY = ByteString.Companion.encodeUtf8(C0000.decode(new byte[]{15, 89, 70, 76, 90, 13, 20, 15, 67, 64}, "58382bff79d5ecf9", 0.0f));

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString2.getSize$okio() + byteString.getSize$okio() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.areEqual(this.name, header.name) && Intrinsics.areEqual(this.value, header.value);
    }

    public final int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name.utf8());
        sb.append(C0000.decode(new byte[]{91, 25}, "a9d4882cc77e1b", 0.0f));
        sb.append(this.value.utf8());
        return sb.toString();
    }

    public Header(String str, String str2) {
        ByteString byteString = new ByteString(str.getBytes(Charsets.UTF_8));
        byteString.utf8 = str;
        ByteString byteString2 = new ByteString(str2.getBytes(Charsets.UTF_8));
        byteString2.utf8 = str2;
        this(byteString, byteString2);
    }

    public Header(ByteString byteString, String str) {
        ByteString byteString2 = new ByteString(str.getBytes(Charsets.UTF_8));
        byteString2.utf8 = str;
        this(byteString, byteString2);
    }
}
