package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\b0\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0004¨\u0006\f"}, d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "sumOfUInt", "(Lkotlin/sequences/Sequence;)I", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UByte;", "sumOfUByte", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt {
    public static final int sumOfUByte(Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{11, 71, 89, 12, 18, 12}, "731ea2bc5ec18e", 0.0f));
        Iterator<UByte> it = sequence.iterator();
        int iM121constructorimpl = 0;
        while (it.hasNext()) {
            iM121constructorimpl = UInt.m121constructorimpl(iM121constructorimpl + UInt.m121constructorimpl(it.next().getData() & UByte.MAX_VALUE));
        }
        return iM121constructorimpl;
    }

    public static final int sumOfUInt(Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{88, 70, 94, 12, 74, 12}, "d26e92c0e308"));
        Iterator<UInt> it = sequence.iterator();
        int iM121constructorimpl = 0;
        while (it.hasNext()) {
            iM121constructorimpl = UInt.m121constructorimpl(iM121constructorimpl + it.next().getData());
        }
        return iM121constructorimpl;
    }

    public static final long sumOfULong(Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{88, 66, 95, 81, 16, 8}, "d678c64c", 0.0f));
        Iterator<ULong> it = sequence.iterator();
        long jM200constructorimpl = 0;
        while (it.hasNext()) {
            jM200constructorimpl = ULong.m200constructorimpl(jM200constructorimpl + it.next().getData());
        }
        return jM200constructorimpl;
    }

    public static final int sumOfUShort(Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{95, 69, 12, 12, 18, 90}, "c1dead9401", false));
        Iterator<UShort> it = sequence.iterator();
        int iM121constructorimpl = 0;
        while (it.hasNext()) {
            iM121constructorimpl = UInt.m121constructorimpl(iM121constructorimpl + UInt.m121constructorimpl(it.next().getData() & UShort.MAX_VALUE));
        }
        return iM121constructorimpl;
    }
}
