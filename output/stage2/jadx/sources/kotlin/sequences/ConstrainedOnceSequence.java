package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R(\u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \b*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "<init>", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConstrainedOnceSequence<T> implements Sequence<T> {
    private final AtomicReference<Sequence<T>> sequenceRef;

    public ConstrainedOnceSequence(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{71, 7, 67, 64, 7, 95, 86, 87}, "4b25b152"));
        this.sequenceRef = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        Sequence<T> andSet = this.sequenceRef.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException(C0000.decode(new byte[]{101, 91, 80, 68, 17, 71, 83, 73, 68, 86, 87, 84, 84, 20, 85, 89, 95, 19, 91, 82, 17, 87, 89, 86, 66, 70, 84, 82, 85, 20, 89, 86, 93, 74, 25, 88, 95, 87, 83, 22}, "13971468", 0.0f));
    }
}
