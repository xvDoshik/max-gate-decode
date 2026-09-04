package kotlin.uuid;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001\u001a,\u0010\n\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0001\u001a\u001c\u0010\u0010\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006H\u0001\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0001\u001a\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0014H\u0001\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0018*\u00020\u0001H\u0087\b\u001a\f\u0010\u001a\u001a\u00020\u0001*\u00020\u001bH\u0007\u001a\u0014\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\u0014\u0010\u001c\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u001a\u001c\u0010\u001c\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0001H\u0007\u001a\r\u0010\u001d\u001a\u00020\u0006*\u00020\u0006H\u0080\b¨\u0006\u001e"}, d2 = {"secureRandomUuid", "Lkotlin/uuid/Uuid;", "serializedUuid", "", "uuid", "getLongAt", "", "", "index", "", "formatBytesInto", "", "dst", "dstOffset", "startIndex", "endIndex", "setLongAt", "value", "uuidParseHexDash", "hexDashString", "", "uuidParseHex", "hexString", "toKotlinUuid", "Ljava/util/UUID;", "toJavaUuid", "getUuid", "Ljava/nio/ByteBuffer;", "putUuid", "reverseBytes", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
class UuidKt__UuidJVMKt {
    public static final void formatBytesInto(long j, byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{6, 75, 71}, "b83c6bda89", 0.0f));
        UuidKt.formatBytesIntoCommonImpl(j, bArr, i, i2, i3);
    }

    public static final long getLongAt(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{89, 18, 91, 90, 69, 6}, "ef33687384e06c10", 0.0f));
        return UuidKt.getLongAtCommonImpl(bArr, i);
    }

    public static final Uuid getUuid(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, C0000.decode(new byte[]{95, 64, 91, 15, 68, 8}, "c43f76223e48ea2f", 0));
        if (byteBuffer.position() + 15 >= byteBuffer.limit()) {
            throw new BufferUnderflowException();
        }
        long jReverseBytes = byteBuffer.getLong();
        long jReverseBytes2 = byteBuffer.getLong();
        if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.LITTLE_ENDIAN)) {
            jReverseBytes = Long.reverseBytes(jReverseBytes);
            jReverseBytes2 = Long.reverseBytes(jReverseBytes2);
        }
        return Uuid.INSTANCE.fromLongs(jReverseBytes, jReverseBytes2);
    }

    public static final Uuid getUuid(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, C0000.decode(new byte[]{90, 64, 13, 11, 21, 92}, "f4ebfb"));
        if (i < 0) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{120, 7, 95, 82, 65, 15, 64, 7, 24, 90, 91, 2, 83, 26, 2, 19}, "6b835f", 0.0f) + i);
        }
        if (i + 15 >= byteBuffer.limit()) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{43, 86, 64, 70, 82, 93, 11, 67, 82, 9, 65, 83, 28, 77, 81, 21, 23, 71, 11, 22, 71, 4, 0, 85, 69, 88, 20, 19, 66, 90, 0, 22, 84, 21, 65, 88, 11, 93, 81, 30, 13, 19}, "e94f73d65aa1") + i + C0000.decode(new byte[]{27, 20, 20, 80, 66, 10, 18, 15, 93, 84, 92, 64, 14, 69}, "74c96b2c49544e", 0.0f) + byteBuffer.limit() + ' ');
        }
        long jReverseBytes = byteBuffer.getLong(i);
        long jReverseBytes2 = byteBuffer.getLong(i + 8);
        if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.LITTLE_ENDIAN)) {
            jReverseBytes = Long.reverseBytes(jReverseBytes);
            jReverseBytes2 = Long.reverseBytes(jReverseBytes2);
        }
        return Uuid.INSTANCE.fromLongs(jReverseBytes, jReverseBytes2);
    }

    public static final ByteBuffer putUuid(ByteBuffer byteBuffer, int i, Uuid uuid) {
        ByteBuffer byteBufferPutLong;
        Intrinsics.checkNotNullParameter(byteBuffer, C0000.decode(new byte[]{14, 23, 10, 11, 68, 6}, "2cbb78"));
        Intrinsics.checkNotNullParameter(uuid, C0000.decode(new byte[]{23, 16, 90, 82}, "be369880", true));
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        if (i < 0) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{126, 86, 6, 3, 76, 12, 21, 92, 16, 90, 15, 6, 93, 29, 89, 25}, "03ab8ec9", 1) + i);
        }
        if (i + 15 >= byteBuffer.limit()) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{123, 13, 22, 19, 86, 13, 11, 76, 6, 90, 23, 1, 84, 18, 3, 80, 90, 23, 29, 25, 21, 93, 23, 21, 71, 11, 22, 86, 19, 2, 68, 76, 20, 91, 83, 66, 84, 22, 66, 90, 93, 7, 1, 65, 91, 18}, "5bb33cd9a27b", 0.0f) + i + C0000.decode(new byte[]{26, 21, 68, 11, 21, 13, 70, 8, 95, 88, 90, 22, 91, 69}, "653baefd", 0.0f) + byteBuffer.limit() + ' ');
        }
        if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
            byteBuffer.putLong(i, mostSignificantBits);
            byteBufferPutLong = byteBuffer.putLong(i + 8, leastSignificantBits);
        } else {
            byteBuffer.putLong(i, Long.reverseBytes(mostSignificantBits));
            byteBufferPutLong = byteBuffer.putLong(i + 8, Long.reverseBytes(leastSignificantBits));
        }
        Intrinsics.checkNotNullExpressionValue(byteBufferPutLong, C0000.decode(new byte[]{65, 86, 47, 13, 94, 6, 17, 75, 77, 23, 29, 77}, "59cb0abcc93de310", true));
        return byteBufferPutLong;
    }

    public static final ByteBuffer putUuid(ByteBuffer byteBuffer, Uuid uuid) {
        ByteBuffer byteBufferPutLong;
        Intrinsics.checkNotNullParameter(byteBuffer, C0000.decode(new byte[]{88, 71, 90, 89, 17, 8}, "d320b633cf", 0.0f));
        Intrinsics.checkNotNullParameter(uuid, C0000.decode(new byte[]{76, 20, 80, 5}, "9a9aae0a", 4));
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        if (byteBuffer.position() + 15 >= byteBuffer.limit()) {
            throw new BufferOverflowException();
        }
        if (Intrinsics.areEqual(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
            byteBuffer.putLong(mostSignificantBits);
            byteBufferPutLong = byteBuffer.putLong(leastSignificantBits);
        } else {
            byteBuffer.putLong(Long.reverseBytes(mostSignificantBits));
            byteBufferPutLong = byteBuffer.putLong(Long.reverseBytes(leastSignificantBits));
        }
        Intrinsics.checkNotNullExpressionValue(byteBufferPutLong, C0000.decode(new byte[]{16, 94, 124, 14, 10, 4, 17, 17, 74, 31, 30, 72}, "d10adcb9", 0.0f));
        return byteBufferPutLong;
    }

    public static final Uuid secureRandomUuid() {
        byte[] bArr = new byte[16];
        SecureRandomHolder.INSTANCE.getInstance().nextBytes(bArr);
        return UuidKt.uuidFromRandomBytes(bArr);
    }

    public static final Object serializedUuid(Uuid uuid) {
        Intrinsics.checkNotNullParameter(uuid, C0000.decode(new byte[]{69, 77, 80, 80}, "089442644ff6e5", true));
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final void setLongAt(byte[] bArr, int i, long j) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{11, 69, 95, 11, 74, 12}, "717b92410a"));
        UuidKt.setLongAtCommonImpl(bArr, i, j);
    }

    public static final UUID toJavaUuid(Uuid uuid) {
        Intrinsics.checkNotNullParameter(uuid, C0000.decode(new byte[]{14, 67, 90, 8, 66, 91}, "272a1eb0cf4e", 0));
        return new UUID(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final Uuid toKotlinUuid(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, C0000.decode(new byte[]{13, 17, 94, 80, 66, 92}, "1e691b", 5));
        return Uuid.INSTANCE.fromLongs(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final Uuid uuidParseHex(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 4, 78, 101, 76, 68, 15, 93, 81}, "da6686f369b3ba84", 0.0f));
        return UuidKt.uuidParseHexCommonImpl(str);
    }

    public static final Uuid uuidParseHexDash(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 0, 64, 39, 0, 64, 80, 48, 76, 68, 13, 12, 2}, "ee8ca38c86dbedd5", 2));
        return UuidKt.uuidParseHexDashCommonImpl(str);
    }

    public static final long reverseBytes(long j) {
        return Long.reverseBytes(j);
    }
}
