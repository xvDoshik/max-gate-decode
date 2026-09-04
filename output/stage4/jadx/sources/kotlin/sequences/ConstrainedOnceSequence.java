package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConstrainedOnceSequence implements Sequence {
    public final AtomicReference sequenceRef;

    public ConstrainedOnceSequence(SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1) {
        this.sequenceRef = new AtomicReference(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        Sequence sequence = (Sequence) this.sequenceRef.getAndSet(null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException(C0000.decode(new byte[]{50, 9, 90, 23, 18, 17, 83, 68, 19, 4, 93, 7, 87, 66, 85, 84, 8, 65, 81, 1, 18, 1, 89, 91, 21, 20, 94, 1, 86, 66, 89, 91, 10, 24, 19, 11, 92, 1, 83, 27}, "fa3d2b65", true));
    }
}
