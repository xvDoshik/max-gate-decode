package kotlin.uuid;

import java.io.Serializable;
import java.util.Comparator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByteArray;
import kotlin.ULong;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001*B\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\\\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00100\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015J\\\u0010\u0016\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00100\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0015J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0007J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000f\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\u0011\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\u0000H\u0097\u0002J\b\u0010(\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020%H\u0002R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"Lkotlin/uuid/Uuid;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "mostSignificantBits", "", "leastSignificantBits", "<init>", "(JJ)V", "getMostSignificantBits$annotations", "()V", "getMostSignificantBits", "()J", "getLeastSignificantBits$annotations", "getLeastSignificantBits", "toLongs", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toULongs", "Lkotlin/ULong;", "toString", "", "toHexDashString", "toHexString", "toByteArray", "", "toUByteArray", "Lkotlin/UByteArray;", "toUByteArray-TcUX1vc", "()[B", "equals", "", "other", "", "compareTo", "", "hashCode", "writeReplace", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Uuid implements Comparable<Uuid>, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Uuid NIL = new Uuid(0, 0);
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    public /* synthetic */ Uuid(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }

    private final <T> T toLongs(Function2<? super Long, ? super Long, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, C0000.decode(new byte[]{85, 0, 76, 13, 90, 87}, "4c8d59de1d4737f6", 0.0f));
        return action.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    private final <T> T toULongs(Function2<? super ULong, ? super ULong, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, C0000.decode(new byte[]{86, 81, 21, 89, 88, 13}, "72a07c9a3f800ca6"));
        return action.invoke(ULong.m194boximpl(ULong.m200constructorimpl(getMostSignificantBits())), ULong.m194boximpl(ULong.m200constructorimpl(getLeastSignificantBits())));
    }

    @Override // java.lang.Comparable
    public int compareTo(Uuid other) {
        Intrinsics.checkNotNullParameter(other, C0000.decode(new byte[]{13, 70, 10, 6, 16}, "b2bcbaf5154dd143", 6));
        long j = this.mostSignificantBits;
        return j != other.mostSignificantBits ? Long.compareUnsigned(ULong.m200constructorimpl(j), ULong.m200constructorimpl(other.mostSignificantBits)) : Long.compareUnsigned(ULong.m200constructorimpl(this.leastSignificantBits), ULong.m200constructorimpl(other.leastSignificantBits));
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        UuidKt.setLongAt(bArr, 0, this.mostSignificantBits);
        UuidKt.setLongAt(bArr, 8, this.leastSignificantBits);
        return bArr;
    }

    public final String toHexDashString() {
        byte[] bArr = new byte[36];
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 4);
        bArr[8] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 9, 4, 6);
        bArr[13] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 14, 6, 8);
        bArr[18] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, bArr, 19, 0, 2);
        bArr[23] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, bArr, 24, 2, 8);
        return StringsKt.decodeToString(bArr);
    }

    public final String toHexString() {
        byte[] bArr = new byte[32];
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 8);
        UuidKt.formatBytesInto(this.leastSignificantBits, bArr, 16, 0, 8);
        return StringsKt.decodeToString(bArr);
    }

    private Uuid(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public String toString() {
        return toHexDashString();
    }

    /* JADX INFO: renamed from: toUByteArray-TcUX1vc, reason: not valid java name */
    public final byte[] m1510toUByteArrayTcUX1vc() {
        return UByteArray.m97constructorimpl(toByteArray());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) other;
        return this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits;
    }

    public int hashCode() {
        return Long.hashCode(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    private final Object writeReplace() {
        return UuidKt.serializedUuid(this);
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u001d\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001dH\u0007J\u000e\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R*\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050$j\b\u0012\u0004\u0012\u00020\u0005`%8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lkotlin/uuid/Uuid$Companion;", "", "<init>", "()V", "NIL", "Lkotlin/uuid/Uuid;", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BYTES", "", "SIZE_BITS", "fromLongs", "mostSignificantBits", "", "leastSignificantBits", "fromULongs", "Lkotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "fromByteArray", "byteArray", "", "fromUByteArray", "ubyteArray", "Lkotlin/UByteArray;", "fromUByteArray-GBYM_sE", "([B)Lkotlin/uuid/Uuid;", "parse", "uuidString", "", "parseHexDash", "hexDashString", "parseHex", "hexString", "random", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getLEXICAL_ORDER$annotations", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use naturalOrder<Uuid>() instead", replaceWith = @ReplaceWith(expression = "naturalOrder<Uuid>()", imports = {"kotlin.comparisons.naturalOrder"}))
        @DeprecatedSinceKotlin(warningSince = "2.1")
        public static /* synthetic */ void getLEXICAL_ORDER$annotations() {
        }

        public final Uuid fromByteArray(byte[] byteArray) {
            Intrinsics.checkNotNullParameter(byteArray, C0000.decode(new byte[]{82, 76, 18, 86, 117, 68, 66, 84, 31}, "05f346", 0.0f));
            if (byteArray.length == 16) {
                return fromLongs(UuidKt.getLongAt(byteArray, 0), UuidKt.getLongAt(byteArray, 8));
            }
            throw new IllegalArgumentException((C0000.decode(new byte[]{118, 73, 73, 93, 1, 16, 92, 0, 66, 82, 30, 80, 91, 69, 92, 76, 19, 0, 15, 24, 0, 29, 77, 1, 17, 27, 70, 83, 77, 69, 16, 66, 82, 66, 25}, "3198bd9db7f18105") + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(byteArray, 32) + C0000.decode(new byte[]{67, 13, 2, 67, 64, 15, 79, 1, 17}, "cbdc3f5d106929") + byteArray.length).toString());
        }

        /* JADX INFO: renamed from: fromUByteArray-GBYM_sE, reason: not valid java name */
        public final Uuid m1511fromUByteArrayGBYM_sE(byte[] ubyteArray) {
            Intrinsics.checkNotNullParameter(ubyteArray, C0000.decode(new byte[]{19, 1, 64, 66, 3, 119, 65, 20, 86, 77}, "fc96f63f7423", 1));
            return fromByteArray(ubyteArray);
        }

        public final Uuid parse(String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, C0000.decode(new byte[]{16, 22, 90, 1, 53, 64, 69, 94, 89, 84}, "ec3ef4777340", 4));
            int length = uuidString.length();
            if (length == 32) {
                return UuidKt.uuidParseHex(uuidString);
            }
            if (length == 36) {
                return UuidKt.uuidParseHexDash(uuidString);
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{118, 29, 73, 81, 84, 77, 86, 1, 25, 81, 94, 77, 91, 0, 75, 20, 86, 25, 0, 83, 20, 87, 95, 88, 65, 69, 74, 64, 69, 80, 93, 2, 25, 93, 89, 25, 71, 13, 92, 20, 68, 77, 82, 11, 93, 85, 69, 93, 19, 13, 92, 76, 26, 88, 93, 1, 20, 80, 86, 74, 91, 69, 108, 97, 126, 125, 19, 3, 86, 70, 90, 88, 71, 69, 86, 70, 23, 88, 19, 86, 11, 25, 84, 81, 82, 23, 25, 92, 82, 65, 82, 1, 92, 87, 94, 84, 82, 9, 25, 71, 67, 75, 90, 11, 94, 24, 23, 91, 70, 17, 25, 67, 86, 74, 19, 71}, "3e9479", 2) + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(uuidString, 64) + C0000.decode(new byte[]{27, 67, 95, 7, 68, 89, 3, 90, 85, 21, 10, 25}, "9c0ad5f42ab9e8", true) + uuidString.length());
        }

        public final Uuid parseHex(String hexString) {
            Intrinsics.checkNotNullParameter(hexString, C0000.decode(new byte[]{91, 0, 77, 53, 64, 70, 95, 92, 1}, "3e5f4462ff4c", 7));
            if (hexString.length() == 32) {
                return UuidKt.uuidParseHex(hexString);
            }
            throw new IllegalArgumentException((C0000.decode(new byte[]{119, 26, 21, 84, 87, 23, 81, 83, 18, 3, 69, 2, 6, 78, 87, 95, 83, 16, 69, 89, 81, 27, 85, 83, 87, 1, 12, 92, 85, 15, 20, 68, 70, 16, 12, 95, 83, 79, 20, 85, 71, 22, 69, 70, 85, 16, 20, 21}, "2be14c47", 0.0f) + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexString, 64) + C0000.decode(new byte[]{67, 68, 13, 0, 24, 90, 84, 91, 85, 68, 89, 25}, "adbf86152019", false) + hexString.length()).toString());
        }

        public final Uuid parseHexDash(String hexDashString) {
            Intrinsics.checkNotNullParameter(hexDashString, C0000.decode(new byte[]{95, 81, 77, 114, 5, 70, 93, 96, 76, 64, 94, 90, 82}, "7456d55382"));
            if (hexDashString.length() == 36) {
                return UuidKt.uuidParseHexDash(hexDashString);
            }
            throw new IllegalArgumentException((C0000.decode(new byte[]{35, 76, 22, 93, 5, 64, 84, 5, 70, 85, 70, 11, 80, 25, 82, 9, 7, 70, 70, 75, 18, 70, 88, 15, 1, 20, 15, 86, 70, 64, 89, 4, 70, 71, 18, 89, 8, 80, 80, 19, 2, 20, 14, 93, 30, 25, 80, 15, 2, 25, 2, 89, 21, 92, 17, 52, 51, 125, 34, 24, 0, 91, 67, 12, 7, 64, 74, 24, 4, 65, 69, 65, 17, 85, 21, 24, 68}, "f4f8f41a", 3) + UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexDashString, 64) + C0000.decode(new byte[]{18, 70, 93, 95, 23, 88, 7, 95, 82, 77, 11, 21}, "0f2974b159c5ae", 7) + hexDashString.length()).toString());
        }

        private Companion() {
        }

        public final Uuid getNIL() {
            return Uuid.NIL;
        }

        public final Uuid fromLongs(long mostSignificantBits, long leastSignificantBits) {
            if (mostSignificantBits == 0 && leastSignificantBits == 0) {
                return getNIL();
            }
            return new Uuid(mostSignificantBits, leastSignificantBits, null);
        }

        /* JADX INFO: renamed from: fromULongs-eb3DHEI, reason: not valid java name */
        public final Uuid m1512fromULongseb3DHEI(long mostSignificantBits, long leastSignificantBits) {
            return fromLongs(mostSignificantBits, leastSignificantBits);
        }

        public final Uuid random() {
            return UuidKt.secureRandomUuid();
        }

        public final Comparator<Uuid> getLEXICAL_ORDER() {
            return ComparisonsKt.naturalOrder();
        }
    }
}
