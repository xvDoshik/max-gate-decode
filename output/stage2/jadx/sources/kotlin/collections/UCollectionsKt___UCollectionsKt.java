package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007¢\u0006\u0002\u0010\b\u001a\u0017\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0007¢\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0007¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0011\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0007¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u0019\u0010\u0011\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"toUByteArray", "Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "Lkotlin/UInt;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "(Ljava/util/Collection;)[S", "sum", "", "sumOfUInt", "(Ljava/lang/Iterable;)I", "sumOfULong", "(Ljava/lang/Iterable;)J", "sumOfUByte", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    public static final int sumOfUByte(Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{14, 17, 13, 10, 75, 95}, "2eec8aca79b644b7", true));
        Iterator<UByte> it = iterable.iterator();
        int iM121constructorimpl = 0;
        while (it.hasNext()) {
            iM121constructorimpl = UInt.m121constructorimpl(iM121constructorimpl + UInt.m121constructorimpl(it.next().getData() & UByte.MAX_VALUE));
        }
        return iM121constructorimpl;
    }

    public static final int sumOfUInt(Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{10, 17, 88, 92, 65, 13}, "6e0523"));
        Iterator<UInt> it = iterable.iterator();
        int iM121constructorimpl = 0;
        while (it.hasNext()) {
            iM121constructorimpl = UInt.m121constructorimpl(iM121constructorimpl + it.next().getData());
        }
        return iM121constructorimpl;
    }

    public static final long sumOfULong(Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{15, 21, 13, 91, 71, 13}, "3ae243b0cc93", true));
        Iterator<ULong> it = iterable.iterator();
        long jM200constructorimpl = 0;
        while (it.hasNext()) {
            jM200constructorimpl = ULong.m200constructorimpl(jM200constructorimpl + it.next().getData());
        }
        return jM200constructorimpl;
    }

    public static final int sumOfUShort(Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{4, 70, 10, 10, 71, 15}, "82bc4177f3b6", false));
        Iterator<UShort> it = iterable.iterator();
        int iM121constructorimpl = 0;
        while (it.hasNext()) {
            iM121constructorimpl = UInt.m121constructorimpl(iM121constructorimpl + UInt.m121constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return iM121constructorimpl;
    }

    public static final byte[] toUByteArray(Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{15, 71, 90, 15, 71, 8}, "332f4617", true));
        byte[] bArrM96constructorimpl = UByteArray.m96constructorimpl(collection.size());
        Iterator<UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UByteArray.m107setVurrAj0(bArrM96constructorimpl, i, it.next().getData());
            i++;
        }
        return bArrM96constructorimpl;
    }

    public static final int[] toUIntArray(Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{94, 66, 89, 89, 66, 14}, "b61010be026603ea", 1));
        int[] iArrM175constructorimpl = UIntArray.m175constructorimpl(collection.size());
        Iterator<UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UIntArray.m186setVXSXFK8(iArrM175constructorimpl, i, it.next().getData());
            i++;
        }
        return iArrM175constructorimpl;
    }

    public static final long[] toULongArray(Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{89, 76, 11, 11, 65, 7}, "e8cb29b35c", 0.0f));
        long[] jArrM254constructorimpl = ULongArray.m254constructorimpl(collection.size());
        Iterator<ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            ULongArray.m265setk8EXiF4(jArrM254constructorimpl, i, it.next().getData());
            i++;
        }
        return jArrM254constructorimpl;
    }

    public static final short[] toUShortArray(Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{13, 67, 13, 95, 69, 9}, "17e667", false));
        short[] sArrM359constructorimpl = UShortArray.m359constructorimpl(collection.size());
        Iterator<UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            UShortArray.m370set01HTLdE(sArrM359constructorimpl, i, it.next().getData());
            i++;
        }
        return sArrM359constructorimpl;
    }
}
