package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2 = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "storage", "", "constructor-impl", "([I)[I", "size", "", "(I)[I", "getStorage$annotations", "()V", "get", "index", "get-pVg5ArA", "([II)I", "set", "", "value", "set-VXSXFK8", "([III)V", "getSize-impl", "([I)I", "iterator", "", "iterator-impl", "([I)Ljava/util/Iterator;", "contains", "", "element", "contains-WZ4Q5Ns", "([II)Z", "containsAll", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([I)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    private final int[] storage;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UIntArray m174boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m176constructorimpl(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{16, 22, 87, 71, 87, 80, 1}, "cb8567d9b8"));
        return iArr;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m178containsAllimpl(int[] iArr, Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{83, 89, 85, 11, 84, 91, 77, 65}, "650f15923b3766"));
        Collection<UInt> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof UInt) || !ArraysKt.contains(iArr, ((UInt) obj).getData())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m179equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).getStorage());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m180equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m183hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m187toStringimpl(int[] iArr) {
        return C0000.decode(new byte[]{102, 122, 87, 16, 118, 65, 68, 83, 74, 76, 70, 21, 13, 22, 82, 84, 92, 89}, "339d73623d5abd", 6) + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 73, 93, 71, 0, 66, 95, 10, 12, 23, 91, 74, 24, 91, 14, 66, 22, 22, 23, 71, 66, 86, 74, 65, 4, 82, 22, 3, 13, 69, 18, 75, 93, 84, 5, 27, 89, 11, 14, 78, 18, 90, 87, 89, 13, 83, 85, 17, 11, 88, 92}, "2985a66eb7"));
    }

    /* JADX INFO: renamed from: add-WZ4Q5Ns, reason: not valid java name */
    public boolean m188addWZ4Q5Ns(int i) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 20, 93, 22, 84, 71, 90, 91, 93, 22, 89, 68, 70, 95, 11, 65, 16, 23, 77, 20, 69, 92, 65, 64, 86, 82, 16, 81, 9, 67, 68, 71, 85, 5, 92, 73, 90, 93, 95, 77, 19, 85, 95, 91, 10, 84, 7, 65, 89, 11, 86}, "0d8d53343607f1d5", 1));
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{42, 71, 85, 64, 86, 70, 90, 91, 89, 16, 12, 22, 69, 89, 95, 70, 23, 65, 70, 68, 71, 95, 23, 17, 0, 83, 16, 84, 88, 64, 19, 70, 82, 81, 1, 72, 10, 89, 92, 75, 23, 81, 92, 88, 91, 85, 6, 17, 12, 88, 94}, "e702723470ee", true));
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 73, 7, 71, 3, 17, 80, 14, 91, 25, 11, 70, 66, 11, 86, 21, 21, 74, 23, 69, 18, 10, 75, 21, 80, 93, 66, 83, 13, 23, 25, 19, 80, 88, 6, 24, 13, 11, 85, 24, 21, 90, 13, 89, 14, 0, 90, 21, 92, 86, 12}, "59b5be9a", true));
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{1, 88, 85, 88, 81, 15, 68, 18}, "d4054a0a8e70f5ca"));
        return m178containsAllimpl(this.storage, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        return m179equalsimpl(this.storage, other);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m183hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{119, 65, 6, 17, 87, 16, 81, 94, 13, 67, 95, 23, 24, 95, 12, 23, 22, 23, 77, 65, 19, 12, 68, 16, 93, 85, 67, 5, 89, 22, 24, 67, 6, 2, 82, 73, 87, 95, 15, 26, 22, 7, 87, 93, 15, 6, 85, 16, 81, 94, 13}, "81cc6d", 0.0f));
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{119, 72, 80, 17, 81, 23, 89, 91, 15, 67, 94, 16, 66, 15, 14, 21, 24, 75, 64, 19, 64, 12, 66, 64, 4, 7, 23, 5, 13, 19, 65, 19, 93, 89, 81, 78, 95, 13, 92, 77, 65, 0, 88, 15, 14, 4, 2, 21, 81, 87, 91}, "885c0c04ac7cbaaa", 0.0f));
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 18, 83, 65, 86, 71, 95, 13, 88, 19, 94, 64, 22, 12, 89, 71, 23, 64, 67, 18, 70, 92, 69, 71, 83, 6, 22, 85, 88, 65, 22, 16, 83, 82, 83, 30, 89, 12, 90, 74, 23, 80, 89, 14, 90, 86, 84, 71, 95, 13, 88}, "6b6373", 4));
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{4, 71, 68, 81, 29}, "e560d5", 1));
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m187toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m189containsWZ4Q5Ns(((UInt) obj).getData());
        }
        return false;
    }

    private /* synthetic */ UIntArray(int[] iArr) {
        this.storage = iArr;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m175constructorimpl(int i) {
        return m176constructorimpl(new int[i]);
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m181getpVg5ArA(int[] iArr, int i) {
        return UInt.m121constructorimpl(iArr[i]);
    }

    /* JADX INFO: renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m186setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m182getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m182getSizeimpl(this.storage);
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UInt> m185iteratorimpl(int[] iArr) {
        return new Iterator(iArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UInt> iterator() {
        return m185iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/UIntArray$Iterator;", "", "Lkotlin/UInt;", "array", "", "<init>", "([I)V", "index", "", "hasNext", "", "next", "next-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {
        private final int[] array;
        private int index;

        public Iterator(int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{82, 16, 65, 83, 79}, "3b326f"));
            this.array = iArr;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 70, 1, 22, 86, 76, 90, 86, 88, 22, 13, 23, 23, 86, 92, 77, 22, 69, 17, 20, 71, 87, 65, 77, 83, 82, 68, 2, 88, 74, 19, 75, 83, 87, 0, 73, 88, 86, 95, 64, 22, 85, 11, 8, 91, 93, 80, 77, 95, 89, 10}, "66dd7839", false));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UInt next() {
            return UInt.m115boximpl(m191nextpVg5ArA());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        /* JADX INFO: renamed from: next-pVg5ArA, reason: not valid java name */
        public int m191nextpVg5ArA() {
            int i = this.index;
            int[] iArr = this.array;
            if (i >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i + 1;
            return UInt.m121constructorimpl(iArr[i]);
        }
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m189containsWZ4Q5Ns(int i) {
        return m177containsWZ4Q5Ns(this.storage, i);
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public static boolean m177containsWZ4Q5Ns(int[] iArr, int i) {
        return ArraysKt.contains(iArr, i);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m184isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m184isEmptyimpl(this.storage);
    }
}
