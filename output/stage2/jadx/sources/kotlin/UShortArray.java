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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "storage", "", "constructor-impl", "([S)[S", "size", "", "(I)[S", "getStorage$annotations", "()V", "get", "index", "get-Mh2AYeg", "([SI)S", "set", "", "value", "set-01HTLdE", "([SIS)V", "getSize-impl", "([S)I", "iterator", "", "iterator-impl", "([S)Ljava/util/Iterator;", "contains", "", "element", "contains-xj2QHRw", "([SS)Z", "containsAll", "elements", "containsAll-impl", "([SLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([S)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    private final short[] storage;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShortArray m358boximpl(short[] sArr) {
        return new UShortArray(sArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short[] m360constructorimpl(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{17, 77, 92, 71, 80, 84, 81}, "b9351346b17b06"));
        return sArr;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m362containsAllimpl(short[] sArr, Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{82, 85, 86, 95, 1, 87, 71, 64}, "7932d93345cbda7c", 0.0f));
        Collection<UShort> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof UShort) || !ArraysKt.contains(sArr, ((UShort) obj).getData())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m363equalsimpl(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual(sArr, ((UShortArray) obj).getStorage());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m364equalsimpl0(short[] sArr, short[] sArr2) {
        return Intrinsics.areEqual(sArr, sArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m367hashCodeimpl(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m371toStringimpl(short[] sArr) {
        return C0000.decode(new byte[]{101, 99, 90, 89, 64, 76, 118, 75, 64, 7, 31, 25, 68, 70, 95, 66, 83, 81, 87, 5}, "002628792ff172", 0.0f) + Arrays.toString(sArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 21, 85, 22, 83, 16, 92, 11, 88, 69, 89, 23, 18, 10, 90, 16, 22, 22, 69, 20, 66, 11, 71, 16, 83, 1, 16, 2, 93, 22, 21, 22, 83, 4, 84, 73, 93, 10, 89, 29, 22, 6, 95, 8, 94, 1, 86, 16, 95, 10, 94}, "6e0d2d5d", true));
    }

    /* JADX INFO: renamed from: add-xj2QHRw, reason: not valid java name */
    public boolean m372addxj2QHRw(short s) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 22, 1, 64, 82, 68, 12, 13, 94, 19, 90, 66, 18, 87, 89, 18, 68, 65, 70, 64, 21, 13, 66, 71, 86, 85, 18, 95, 89, 20, 68, 64, 86, 81, 1, 79, 95, 93, 95, 72, 18, 90, 89, 10, 8, 87, 80, 68, 12, 13, 94}, "6fd230eb033129", 2));
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 72, 85, 23, 84, 77, 89, 86, 92, 24, 89, 22, 21, 87, 95, 77, 18, 75, 69, 21, 69, 86, 66, 77, 87, 92, 16, 3, 90, 75, 16, 75, 87, 89, 84, 72, 90, 87, 92, 64, 18, 91, 95, 9, 89, 92, 83, 77, 91, 87, 94}, "280e5909"));
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{126, 17, 84, 16, 81, 66, 89, 92, 95, 65, 88, 17, 16, 88, 95, 71, 17, 18, 68, 18, 64, 89, 66, 71, 84, 5, 17, 4, 95, 68, 16, 65, 84, 0, 85, 79, 95, 88, 92, 74, 17, 2, 94, 14, 92, 83, 83, 71, 88, 14, 95}, "1a1b0603", 0.0f));
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{80, 13, 84, 9, 0, 10, 71, 65}, "5a1ded32c02d", false));
        return m362containsAllimpl(this.storage, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        return m363equalsimpl(this.storage, other);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m367hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 65, 1, 68, 0, 17, 92, 94, 10, 22, 8, 22, 21, 95, 11, 66, 65, 22, 64, 65, 20, 89, 19, 17, 80, 85, 68, 80, 14, 23, 21, 67, 1, 87, 5, 72, 90, 95, 8, 79, 65, 6, 90, 93, 8, 83, 2, 17, 92, 94, 10}, "51d6ae", false));
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 21, 92, 20, 4, 66, 93, 87, 15, 25, 95, 22, 25, 8, 10, 66, 20, 75, 20, 73, 70, 10, 75, 18, 0, 82, 20, 94, 14, 75, 22, 23, 92, 7, 1, 27, 91, 86, 13, 64, 22, 6, 86, 10, 9, 83, 87, 76, 8, 86, 88}, "6e9fe648a9"));
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 64, 6, 17, 84, 67, 94, 14, 13, 20, 93, 70, 19, 15, 93, 68, 67, 16, 64, 71, 71, 14, 17, 64, 81, 81, 19, 7, 93, 66, 67, 17, 80, 86, 83, 76, 12, 90, 88, 76, 19, 2, 93, 92, 15, 6, 86, 67, 94, 14, 13}, "20cc577ac4453a", 0.0f));
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{88, 66, 64, 82, 78}, "90237a37d3952f91", 0.0f));
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m371toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ short[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m373containsxj2QHRw(((UShort) obj).getData());
        }
        return false;
    }

    private /* synthetic */ UShortArray(short[] sArr) {
        this.storage = sArr;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short[] m359constructorimpl(int i) {
        return m360constructorimpl(new short[i]);
    }

    /* JADX INFO: renamed from: get-Mh2AYeg, reason: not valid java name */
    public static final short m365getMh2AYeg(short[] sArr, int i) {
        return UShort.m307constructorimpl(sArr[i]);
    }

    /* JADX INFO: renamed from: set-01HTLdE, reason: not valid java name */
    public static final void m370set01HTLdE(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m366getSizeimpl(short[] sArr) {
        return sArr.length;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m366getSizeimpl(this.storage);
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UShort> m369iteratorimpl(short[] sArr) {
        return new Iterator(sArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UShort> iterator() {
        return m369iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/UShortArray$Iterator;", "", "Lkotlin/UShort;", "array", "", "<init>", "([S)V", "index", "", "hasNext", "", "next", "next-Mh2AYeg", "()S", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Iterator implements java.util.Iterator<UShort>, KMappedMarker {
        private final short[] array;
        private int index;

        public Iterator(short[] sArr) {
            Intrinsics.checkNotNullParameter(sArr, C0000.decode(new byte[]{81, 19, 74, 4, 29}, "0a8ed767e5", 3));
            this.array = sArr;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 20, 6, 23, 82, 69, 13, 86, 88, 17, 95, 69, 22, 10, 12, 17, 19, 66, 17, 73, 70, 94, 68, 66, 83, 0, 67, 3, 92, 67, 68, 75, 83, 80, 82, 27, 89, 10, 15, 28, 19, 82, 11, 85, 90, 84, 85, 66, 95, 11, 13}, "6dce31d96166", true));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UShort next() {
            return UShort.m301boximpl(m375nextMh2AYeg());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        /* JADX INFO: renamed from: next-Mh2AYeg, reason: not valid java name */
        public short m375nextMh2AYeg() {
            int i = this.index;
            short[] sArr = this.array;
            if (i >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i + 1;
            return UShort.m307constructorimpl(sArr[i]);
        }
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public boolean m373containsxj2QHRw(short s) {
        return m361containsxj2QHRw(this.storage, s);
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public static boolean m361containsxj2QHRw(short[] sArr, short s) {
        return ArraysKt.contains(sArr, s);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m368isEmptyimpl(short[] sArr) {
        return sArr.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m368isEmptyimpl(this.storage);
    }
}
