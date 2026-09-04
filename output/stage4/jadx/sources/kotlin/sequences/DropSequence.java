package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIterator;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DropSequence implements Sequence {
    public final int count;
    public final Sequence sequence;

    public DropSequence(Sequence sequence, int i) {
        this.sequence = sequence;
        this.count = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException((C0000.decode(new byte[]{90, 88, 19, 92, 69, 68, 94, 70, 69, 66, 19, 87, 92, 23, 8, 93, 95, 73, 93, 86, 81, 87, 71, 92, 79, 82, 74, 18, 83, 17, 71, 19, 65, 87, 64, 21}, "97f21d336635", 5) + i + '.').toString());
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new ArrayIterator(this);
    }
}
