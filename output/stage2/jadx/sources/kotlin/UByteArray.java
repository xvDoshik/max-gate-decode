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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u0011\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001cH\u0016¢\u0006\u0004\b%\u0010&J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006."}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "storage", "", "constructor-impl", "([B)[B", "size", "", "(I)[B", "getStorage$annotations", "()V", "get", "index", "get-w2LRezQ", "([BI)B", "set", "", "value", "set-VurrAj0", "([BIB)V", "getSize-impl", "([B)I", "iterator", "", "iterator-impl", "([B)Ljava/util/Iterator;", "contains", "", "element", "contains-7apg3OU", "([BB)Z", "containsAll", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([B)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    private final byte[] storage;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByteArray m95boximpl(byte[] bArr) {
        return new UByteArray(bArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m97constructorimpl(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{68, 23, 87, 16, 80, 81, 82}, "7c8b16", 2));
        return bArr;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m99containsAllimpl(byte[] bArr, Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{84, 10, 7, 8, 86, 89, 66, 69}, "1fbe3766017b", 3));
        Collection<UByte> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!(obj instanceof UByte) || !ArraysKt.contains(bArr, ((UByte) obj).getData())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m100equalsimpl(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual(bArr, ((UByteArray) obj).getStorage());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m101equalsimpl0(byte[] bArr, byte[] bArr2) {
        return Intrinsics.areEqual(bArr, bArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m104hashCodeimpl(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m108toStringimpl(byte[] bArr) {
        return C0000.decode(new byte[]{51, 122, 77, 77, 82, 115, 19, 70, 4, 27, 75, 69, 18, 87, 70, 88, 80, 87, 92}, "f84972a4ebc6", 0.0f) + Arrays.toString(bArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{125, 20, 6, 22, 87, 65, 81, 93, 10, 23, 91, 23, 67, 10, 89, 65, 24, 65, 17, 71, 66, 11, 17, 16, 83, 81, 24, 84, 11, 69, 18, 22, 6, 5, 82, 24, 87, 92, 8, 78, 18, 7, 12, 8, 90, 80, 91, 70, 13, 88, 92}, "2dcd6582d7", 7));
    }

    /* JADX INFO: renamed from: add-7apg3OU, reason: not valid java name */
    public boolean m109add7apg3OU(byte b) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{119, 69, 6, 23, 87, 67, 93, 11, 93, 22, 95, 69, 68, 95, 87, 65, 67, 22, 67, 71, 68, 11, 65, 66, 83, 82, 68, 87, 87, 71, 67, 23, 83, 86, 80, 73, 92, 88, 90, 79, 68, 82, 87, 89, 15, 0, 85, 67, 93, 11, 93}, "85ce674d3666d1", 5));
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 67, 93, 74, 0, 69, 88, 12, 90, 70, 91, 74, 68, 93, 87, 76, 65, 66, 68, 19, 68, 9, 64, 77, 1, 87, 24, 94, 14, 67, 17, 17, 81, 7, 86, 20, 11, 93, 84, 65, 65, 82, 94, 15, 88, 3, 81, 77, 13, 92, 86}, "d388a11c4f29", 0.0f));
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{46, 72, 85, 68, 4, 66, 8, 87, 94, 22, 12, 69, 65, 86, 95, 66, 69, 69, 20, 72, 64, 89, 23, 66, 4, 92, 16, 80, 10, 68, 65, 74, 85, 87, 1, 27, 14, 86, 92, 79, 69, 85, 14, 84, 92, 83, 6, 66, 8, 87, 94}, "a806e6"));
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{86, 90, 86, 8, 93, 86, 21, 21}, "363e88af1717f78d", true));
        return m99containsAllimpl(this.storage, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        return m100equalsimpl(this.storage, other);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m104hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{41, 17, 3, 17, 82, 65, 15, 14, 8, 67, 90, 70, 70, 15, 9, 23, 19, 70, 19, 17, 22, 12, 65, 65, 3, 5, 70, 5, 92, 71, 70, 19, 3, 2, 87, 24, 9, 15, 10, 26, 19, 86, 9, 13, 10, 6, 80, 65, 15, 14, 8}, "fafc35", 0.0f));
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{121, 68, 3, 64, 5, 71, 8, 86, 10, 68, 95, 71, 70, 92, 11, 71, 65, 74, 17, 20, 70, 91, 20, 70, 1, 87, 65, 95, 11, 22, 22, 70, 3, 83, 0, 30, 14, 87, 8, 29, 22, 87, 9, 94, 8, 86, 2, 77, 13, 11, 88}, "64f2d3a9dd", false));
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{43, 72, 81, 71, 86, 68, 13, 10, 94, 21, 88, 67, 68, 86, 91, 65, 23, 67, 17, 21, 64, 90, 67, 68, 1, 92, 20, 83, 88, 66, 68, 23, 85, 84, 85, 29, 11, 86, 88, 76, 23, 83, 11, 9, 92, 80, 82, 68, 13, 87, 90}, "d84570de0510"));
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{86, 68, 65, 87, 75}, "76362eea38b758", 7));
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public String toString() {
        return m108toStringimpl(this.storage);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte[] getStorage() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m110contains7apg3OU(((UByte) obj).getData());
        }
        return false;
    }

    private /* synthetic */ UByteArray(byte[] bArr) {
        this.storage = bArr;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m96constructorimpl(int i) {
        return m97constructorimpl(new byte[i]);
    }

    /* JADX INFO: renamed from: get-w2LRezQ, reason: not valid java name */
    public static final byte m102getw2LRezQ(byte[] bArr, int i) {
        return UByte.m44constructorimpl(bArr[i]);
    }

    /* JADX INFO: renamed from: set-VurrAj0, reason: not valid java name */
    public static final void m107setVurrAj0(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m103getSizeimpl(byte[] bArr) {
        return bArr.length;
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m103getSizeimpl(this.storage);
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UByte> m106iteratorimpl(byte[] bArr) {
        return new Iterator(bArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UByte> iterator() {
        return m106iteratorimpl(this.storage);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/UByteArray$Iterator;", "", "Lkotlin/UByte;", "array", "", "<init>", "([B)V", "index", "", "hasNext", "", "next", "next-w2LRezQ", "()B", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {
        private final byte[] array;
        private int index;

        public Iterator(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{88, 17, 64, 86, 64}, "9c2795afc91b"));
            this.array = bArr;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{45, 65, 7, 70, 85, 64, 10, 87, 90, 25, 81, 64, 66, 95, 13, 64, 20, 71, 22, 72, 68, 86, 74, 71, 7, 85, 66, 82, 91, 70, 67, 74, 81, 88, 92, 30, 13, 95, 14, 77, 20, 87, 12, 84, 88, 92, 91, 71, 11, 94, 12}, "b1b444c84983"));
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UByte next() {
            return UByte.m38boximpl(m112nextw2LRezQ());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        /* JADX INFO: renamed from: next-w2LRezQ, reason: not valid java name */
        public byte m112nextw2LRezQ() {
            int i = this.index;
            byte[] bArr = this.array;
            if (i >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i + 1;
            return UByte.m44constructorimpl(bArr[i]);
        }
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m110contains7apg3OU(byte b) {
        return m98contains7apg3OU(this.storage, b);
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public static boolean m98contains7apg3OU(byte[] bArr, byte b) {
        return ArraysKt.contains(bArr, b);
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m105isEmptyimpl(byte[] bArr) {
        return bArr.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m105isEmptyimpl(this.storage);
    }
}
