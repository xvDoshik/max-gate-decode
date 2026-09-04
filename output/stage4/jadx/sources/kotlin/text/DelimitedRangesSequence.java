package kotlin.text;

import androidx.tracing.Trace;
import androidx.work.JobListenableFuture;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.DelimitedRangesSequence.AnonymousClass1;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DelimitedRangesSequence implements Sequence {
    public final /* synthetic */ int $r8$classId = 0;
    public final Lambda getNextMatch;
    public final Object input;

    /* JADX INFO: renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator {
        public int currentStartIndex;
        public IntRange nextItem;
        public int nextSearchIndex;
        public int nextState = -1;

        public AnonymousClass1() {
            int iCoerceIn = Trace.coerceIn(0, ((CharSequence) DelimitedRangesSequence.this.input).length());
            this.currentStartIndex = iCoerceIn;
            this.nextSearchIndex = iCoerceIn;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
        public final void calcNext() {
            Pair pair;
            DelimitedRangesSequence delimitedRangesSequence = DelimitedRangesSequence.this;
            CharSequence charSequence = (CharSequence) delimitedRangesSequence.input;
            int i = this.nextSearchIndex;
            if (i < 0) {
                this.nextState = 0;
                this.nextItem = null;
                return;
            }
            if (i <= charSequence.length() && (pair = (Pair) delimitedRangesSequence.getNextMatch.invoke(charSequence, Integer.valueOf(this.nextSearchIndex))) != null) {
                int iIntValue = ((Number) pair.first).intValue();
                int iIntValue2 = ((Number) pair.second).intValue();
                this.nextItem = Trace.until(this.currentStartIndex, iIntValue);
                int i2 = iIntValue + iIntValue2;
                this.currentStartIndex = i2;
                this.nextSearchIndex = i2 + (iIntValue2 == 0 ? 1 : 0);
            } else {
                this.nextItem = new IntRange(this.currentStartIndex, StringsKt.getLastIndex(charSequence), 1);
                this.nextSearchIndex = -1;
            }
            this.nextState = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.nextState == -1) {
                calcNext();
            }
            return this.nextState == 1;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.nextState == -1) {
                calcNext();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            IntRange intRange = this.nextItem;
            this.nextItem = null;
            this.nextState = -1;
            return intRange;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 68, 0, 74, 7, 71, 12, 12, 86, 20, 15, 71, 69, 86, 9, 71, 69, 16, 77, 68, 22, 91, 23, 76, 3, 87, 69, 5, 87, 70, 70, 70, 0, 89, 2, 30, 10, 13, 84, 77, 70, 87, 10, 84, 10, 86, 6, 23, 81, 91, 8}, "f4e8f3ec84"));
        }
    }

    public DelimitedRangesSequence(DelimitedRangesSequence delimitedRangesSequence, JobListenableFuture.AnonymousClass1 anonymousClass1) {
        this.input = delimitedRangesSequence;
        this.getNextMatch = anonymousClass1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new AnonymousClass1();
            default:
                return new Iterator() { // from class: kotlin.sequences.TransformingSequence$iterator$1
                    public final Iterator iterator;

                    {
                        this.iterator = ((DelimitedRangesSequence) this.this$0.input).new AnonymousClass1();
                    }

                    @Override // java.util.Iterator
                    public final boolean hasNext() {
                        return this.iterator.hasNext();
                    }

                    @Override // java.util.Iterator
                    public final Object next() {
                        return ((JobListenableFuture.AnonymousClass1) this.this$0.getNextMatch).invoke(this.iterator.next());
                    }

                    @Override // java.util.Iterator
                    public final void remove() {
                        throw new UnsupportedOperationException(C0000.decode(new byte[]{42, 68, 92, 65, 83, 77, 10, 88, 93, 17, 91, 70, 69, 90, 86, 71, 18, 74, 22, 71, 67, 94, 64, 65, 0, 80, 25, 85, 93, 75, 67, 69, 86, 80, 86, 24, 10, 90, 85, 74, 18, 90, 12, 91, 95, 84, 81, 65, 12, 91, 87}, "e49329c73125", 1));
                    }
                };
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence charSequence, Function2 function2) {
        this.input = charSequence;
        this.getNextMatch = (Lambda) function2;
    }
}
