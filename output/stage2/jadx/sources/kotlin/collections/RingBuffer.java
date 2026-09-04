package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\n\u0010\rJ\u0016\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096\u0002J'\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0001\u0010\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0014¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0014¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010 \u001a\u00020\tJ\u0013\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\tJ\u0015\u0010'\u001a\u00020\t*\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0082\bR\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lkotlin/collections/RingBuffer;", "T", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "buffer", "", "", "filledSize", "", "<init>", "([Ljava/lang/Object;I)V", "capacity", "(I)V", "[Ljava/lang/Object;", "startIndex", "value", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "isFull", "", "iterator", "", "toArray", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "expanded", "maxCapacity", "add", "", "element", "(Ljava/lang/Object;)V", "removeFirst", "n", "forward", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class RingBuffer<T> extends AbstractList<T> implements RandomAccess {
    private final Object[] buffer;
    private final int capacity;
    private int size;
    private int startIndex;

    public RingBuffer(Object[] objArr, int i) {
        Intrinsics.checkNotNullParameter(objArr, C0000.decode(new byte[]{3, 17, 87, 80, 0, 71}, "ad16e5884714"));
        this.buffer = objArr;
        if (i < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{74, 81, 11, 80, 66, 0, 65, 4, 94, 93, 23, 23, 4, 11, 88, 14, 93, 92, 69, 68, 11, 24, 81, 66, 75, 80, 10, 66, 14, 6, 20, 12, 87, 76, 69, 85, 7, 66, 90, 7, 95, 89, 17, 94, 20, 7, 20, 0, 77, 76, 69, 94, 22, 66, 93, 17, 24}, "88e7bb4b", 0.0f) + i).toString());
        }
        if (i > objArr.length) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{65, 88, 94, 87, 69, 84, 64, 0, 85, 84, 66, 16, 3, 95, 89, 10, 86, 85, 16, 67, 12, 76, 80, 92, 19}, "3100e65f", 5) + i + C0000.decode(new byte[]{70, 6, 7, 90, 89, 13, 68, 66, 3, 93, 23, 95, 88, 64, 1, 0, 20, 20, 67, 10, 81, 12, 65, 76, 95, 86, 25, 80, 19, 3, 0, 81, 69, 66, 67, 11, 27, 93, 13, 19}, "fef47b0ba87392", 6) + objArr.length).toString());
        }
        this.capacity = objArr.length;
        this.size = i;
    }

    private final int forward(int i, int i2) {
        return (i + i2) % this.capacity;
    }

    @Override // java.util.Collection, java.util.List
    public final void add(T element) {
        if (isFull()) {
            throw new IllegalStateException(C0000.decode(new byte[]{23, 80, 11, 80, 17, 86, 76, 81, 3, 92, 23, 23, 88, 71, 25, 81, 16, 85, 9}, "e9e71497", 0.0f));
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = element;
        this.size = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RingBuffer<T> expanded(int maxCapacity) {
        Object[] array;
        int i = this.capacity;
        int iCoerceAtMost = RangesKt.coerceAtMost(i + (i >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            array = Arrays.copyOf(this.buffer, iCoerceAtMost);
            Intrinsics.checkNotNullExpressionValue(array, C0000.decode(new byte[]{5, 93, 66, 74, 126, 94, 25, 75, 72, 28, 27}, "f223181e", false));
        } else {
            array = toArray(new Object[iCoerceAtMost]);
        }
        return new RingBuffer<>(array, size());
    }

    public final void removeFirst(int n) {
        if (n < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{95, 22, 16, 90, 89, 22, 93, 82, 13, 21, 66, 67, 83, 83, 67, 92, 83, 4, 80, 66, 10, 68, 83, 67, 83, 67, 23, 18, 95, 23, 17, 95, 16, 18}, "16c26c") + n).toString());
        }
        if (n > size()) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{88, 70, 17, 89, 10, 67, 93, 92, 15, 70, 66, 70, 0, 84, 69, 81, 67, 93, 0, 21, 83, 20, 66, 69, 13, 87, 95, 24, 21, 9, 83, 70, 0, 68, 3, 80, 84, 74, 65, 18, 95, 28, 7, 11, 69, 88, 17, 5, 65}, "6fb1e618aa", false) + n + C0000.decode(new byte[]{31, 16, 22, 8, 25, 80, 69, 13, 21}, "30eac5e05118", 0.0f) + size()).toString());
        }
        if (n > 0) {
            int i = this.startIndex;
            int i2 = (i + n) % this.capacity;
            if (i > i2) {
                ArraysKt.fill(this.buffer, (Object) null, i, this.capacity);
                ArraysKt.fill(this.buffer, (Object) null, 0, i2);
            } else {
                ArraysKt.fill(this.buffer, (Object) null, i, i2);
            }
            this.startIndex = i2;
            this.size = size() - n;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, C0000.decode(new byte[]{87, 75, 68, 3, 64}, "696b9df315", 0.0f));
        int length = array.length;
        Object[] objArr = array;
        if (length < size()) {
            Object[] objArr2 = (T[]) Arrays.copyOf(array, size());
            Intrinsics.checkNotNullExpressionValue(objArr2, C0000.decode(new byte[]{5, 88, 64, 26, 46, 81, 30, 79, 72, 25, 25}, "f70ca76a", true));
            objArr = objArr2;
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.startIndex; i2 < size && i3 < this.capacity; i3++) {
            objArr[i2] = this.buffer[i3];
            i2++;
        }
        while (i2 < size) {
            objArr[i2] = this.buffer[i];
            i2++;
            i++;
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size, objArr);
    }

    public RingBuffer(int i) {
        this(new Object[i], 0);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (T) this.buffer[(this.startIndex + index) % this.capacity];
    }

    public final boolean isFull() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.collections.RingBuffer.iterator.1
            private int count;
            private int index;
            final /* synthetic */ RingBuffer<T> this$0;

            {
                this.this$0 = this;
                this.count = this.size();
                this.index = ((RingBuffer) this).startIndex;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                if (this.count != 0) {
                    setNext(((RingBuffer) this.this$0).buffer[this.index]);
                    this.index = (this.index + 1) % ((RingBuffer) this.this$0).capacity;
                    this.count--;
                    return;
                }
                done();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
