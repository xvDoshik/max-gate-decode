package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "startIndex", "", "endIndex", "<init>", "(Lkotlin/sequences/Sequence;II)V", "count", "getCount", "()I", "drop", "n", "take", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int endIndex;
    private final Sequence<T> sequence;
    private final int startIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public SubSequence(Sequence<? extends T> sequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{75, 93, 65, 64, 3, 8, 91, 93}, "8805ff", true));
        this.sequence = sequence;
        this.startIndex = i;
        this.endIndex = i2;
        if (i < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{22, 76, 82, 70, 68, 43, 94, 7, 3, 29, 22, 16, 13, 87, 70, 88, 84, 66, 82, 6, 70, 11, 89, 13, 72, 86, 86, 83, 81, 22, 89, 21, 3, 73, 22, 1, 16, 76, 19, 93, 67, 66}, "e8340b0cfe6c", true) + i).toString());
        }
        if (i2 < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{0, 11, 81, 45, 87, 6, 4, 72, 66, 74, 92, 12, 65, 9, 87, 20, 7, 0, 21, 10, 86, 12, 76, 94, 7, 94, 85, 23, 93, 19, 86, 24, 69, 7, 64, 16, 25, 11, 18, 16}, "ee5d9ba0b94c4e34", 4) + i2).toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{82, 12, 0, 43, 87, 7, 82, 26, 68, 17, 81, 12, 66, 14, 0, 66, 91, 6, 23, 12, 11, 22, 25, 15, 82, 17, 23, 66, 77, 11, 86, 12, 68, 17, 77, 2, 69, 22, 45, 12, 93, 6, 79, 78, 68, 0, 76, 23, 23, 21, 5, 17, 25}, "7bdb9c") + i2 + C0000.decode(new byte[]{23, 93, 66}, "7ab1f5e7") + i).toString());
        }
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int n) {
        return n >= getCount() ? SequencesKt.emptySequence() : new SubSequence(this.sequence, this.startIndex + n, this.endIndex);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int n) {
        if (n >= getCount()) {
            return this;
        }
        Sequence<T> sequence = this.sequence;
        int i = this.startIndex;
        return new SubSequence(sequence, i, n + i);
    }

    /* JADX INFO: renamed from: kotlin.sequences.SubSequence$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private int position;
        final /* synthetic */ SubSequence<T> this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 18, 86, 64, 0, 69, 15, 91, 90, 24, 13, 22, 18, 12, 13, 66, 20, 17, 70, 66, 17, 94, 20, 64, 81, 92, 68, 3, 93, 16, 66, 68, 81, 3, 87, 31, 14, 95, 10, 77, 20, 91, 11, 9, 94, 7, 1, 66, 93, 13, 93}, "4b32a1f448de2bb6", true));
        }

        AnonymousClass1(SubSequence<T> subSequence) {
            this.this$0 = subSequence;
            this.iterator = ((SubSequence) subSequence).sequence.iterator();
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final int getPosition() {
            return this.position;
        }

        public final void setPosition(int i) {
            this.position = i;
        }

        private final void drop() {
            while (this.position < ((SubSequence) this.this$0).startIndex && this.iterator.hasNext()) {
                this.iterator.next();
                this.position++;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            drop();
            return this.position < ((SubSequence) this.this$0).endIndex && this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            drop();
            if (this.position >= ((SubSequence) this.this$0).endIndex) {
                throw new NoSuchElementException();
            }
            this.position++;
            return this.iterator.next();
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
