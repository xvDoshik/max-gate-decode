package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "storage", "", "constructor-impl", "([J)[J", "size", "", "(I)[J", "getStorage$annotations", "()V", "get", "index", "get-s-VKNKU", "([JI)J", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "getSize-impl", "([J)I", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([J)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    private final long[] storage;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULongArray m253boximpl(long[] jArr) {
        return new ULongArray(jArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long[] m255constructorimpl(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{23, 65, 9, 71, 87, 81, 1}, "d5f566", false));
        return jArr;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m257containsAllimpl(long[] jArr, Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{6, 9, 93, 94, 83, 94, 18, 65}, "ce8360f2df2238", 7));
        Collection<ULong> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof ULong) || !ArraysKt.contains(jArr, ((ULong) obj).getData())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m258equalsimpl(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual(jArr, ((ULongArray) obj).getStorage());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m259equalsimpl0(long[] jArr, long[] jArr2) {
        return Intrinsics.areEqual(jArr, jArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m262hashCodeimpl(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m266toStringimpl(long[] jArr) {
        return C0000.decode(new byte[]{100, 126, 89, 91, 80, 36, 20, 23, 87, 79, 27, 22, 66, 10, 67, 83, 81, 80, 10}, "12657efe663e6e", 0.0f) + Arrays.toString(jArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 18, 82, 23, 7, 18, 10, 92, 13, 16, 94, 64, 25, 92, 10, 65, 22, 17, 66, 21, 22, 9, 17, 71, 6, 84, 23, 85, 86, 64, 69, 71, 83, 3, 83, 72, 9, 8, 15, 74, 67, 83, 88, 95, 85, 87, 6, 65, 95, 13, 89}, "6b7effc3c07392e5", 0.0f));
    }

    /* JADX INFO: renamed from: add-VKZWuLQ, reason: not valid java name */
    public boolean m267addVKZWuLQ(long j) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 69, 85, 19, 82, 69, 95, 13, 90, 21, 89, 18, 19, 95, 89, 22, 20, 70, 69, 17, 67, 94, 68, 22, 81, 81, 16, 7, 92, 67, 22, 16, 81, 84, 84, 76, 92, 95, 90, 27, 20, 86, 95, 13, 95, 84, 85, 22, 93, 90, 94}, "450a316b", 2));
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 22, 86, 23, 86, 70, 94, 89, 88, 22, 92, 21, 22, 12, 94, 18, 19, 22, 66, 66, 71, 89, 68, 66, 80, 2, 22, 4, 94, 20, 19, 23, 82, 83, 83, 27, 89, 88, 89, 31, 22, 1, 94, 10, 95, 0, 84, 70, 94, 89, 88}, "1f3e7276665f6b", false));
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{44, 17, 81, 22, 7, 17, 80, 94, 91, 16, 15, 22, 25, 91, 12, 21, 20, 23, 19, 21, 73, 94, 71, 68, 3, 1, 25, 83, 12, 19, 20, 22, 3, 4, 93, 28, 90, 94, 10, 28, 25, 86, 12, 13, 88, 1, 5, 17, 80, 94, 91}, "ca4dfe9150fe95", 5));
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{3, 13, 81, 88, 3, 92, 18, 18}, "fa45f2", 4));
        return m257containsAllimpl(this.storage, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        return m258equalsimpl(this.storage, other);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m262hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 21, 83, 23, 89, 23, 93, 93, 10, 69, 95, 22, 24, 13, 91, 70, 68, 22, 67, 21, 72, 12, 70, 70, 1, 1, 22, 3, 87, 17, 20, 64, 1, 4, 82, 72, 87, 13, 88, 75, 68, 6, 89, 9, 84, 6, 87, 70, 13, 10, 88}, "de6e8c42"));
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 22, 86, 75, 80, 71, 88, 94, 86, 67, 94, 67, 65, 8, 92, 77, 17, 64, 68, 65, 72, 12, 69, 68, 4, 2, 19, 95, 94, 65, 17, 67, 93, 2, 83, 29, 14, 8, 95, 64, 17, 80, 94, 93, 84, 6, 84, 68, 8, 9, 93}, "af3913118c70", 0.0f));
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 71, 93, 66, 82, 76, 11, 10, 88, 23, 81, 67, 19, 86, 13, 17, 22, 68, 77, 64, 67, 87, 16, 17, 83, 83, 24, 86, 92, 74, 66, 23, 83, 86, 92, 29, 92, 86, 14, 28, 22, 84, 87, 92, 95, 93, 1, 17, 95, 88, 86}, "678038be", 0.0f));
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{4, 74, 70, 83, 29}, "e842dd07e5cedd62", true));
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m266toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m268containsVKZWuLQ(((ULong) obj).getData());
        }
        return false;
    }

    private /* synthetic */ ULongArray(long[] jArr) {
        this.storage = jArr;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long[] m254constructorimpl(int i) {
        return m255constructorimpl(new long[i]);
    }

    /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
    public static final long m260getsVKNKU(long[] jArr, int i) {
        return ULong.m200constructorimpl(jArr[i]);
    }

    /* JADX INFO: renamed from: set-k8EXiF4, reason: not valid java name */
    public static final void m265setk8EXiF4(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m261getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m261getSizeimpl(this.storage);
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<ULong> m264iteratorimpl(long[] jArr) {
        return new Iterator(jArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<ULong> iterator() {
        return m264iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/ULongArray$Iterator;", "", "Lkotlin/ULong;", "array", "", "<init>", "([J)V", "index", "", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {
        private final long[] array;
        private int index;

        public Iterator(long[] jArr) {
            Intrinsics.checkNotNullParameter(jArr, C0000.decode(new byte[]{0, 70, 68, 81, 29}, "a460de218e8ac77a", 4));
            this.array = jArr;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 70, 86, 75, 81, 69, 89, 92, 95, 22, 90, 74, 16, 95, 95, 71, 17, 69, 70, 73, 64, 94, 66, 71, 84, 82, 19, 95, 95, 67, 16, 65, 84, 87, 87, 20, 95, 95, 92, 74, 17, 85, 92, 85, 92, 84, 83, 71, 88, 89, 93}, "16390103", 0.0f));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ULong next() {
            return ULong.m194boximpl(m270nextsVKNKU());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        /* JADX INFO: renamed from: next-s-VKNKU, reason: not valid java name */
        public long m270nextsVKNKU() {
            int i = this.index;
            long[] jArr = this.array;
            if (i >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i + 1;
            return ULong.m200constructorimpl(jArr[i]);
        }
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m268containsVKZWuLQ(long j) {
        return m256containsVKZWuLQ(this.storage, j);
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public static boolean m256containsVKZWuLQ(long[] jArr, long j) {
        return ArraysKt.contains(jArr, j);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m263isEmptyimpl(long[] jArr) {
        return jArr.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m263isEmptyimpl(this.storage);
    }
}
