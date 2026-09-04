package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0000\u0018\u0000 Q*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0003QRSB\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0016\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\tH\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&2\u0006\u0010\u001b\u001a\u00020\tH\u0016J\u0015\u0010'\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\u001d\u0010'\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\u001e\u0010+\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\b\u0010.\u001a\u00020)H\u0016J\u0015\u0010/\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u001cJ\u0015\u00100\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010(J\u0016\u00101\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\u0016\u00102\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0016J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J'\u00106\u001a\b\u0012\u0004\u0012\u0002H70\r\"\u0004\b\u0001\u001072\f\u00108\u001a\b\u0012\u0004\u0012\u0002H70\rH\u0016¢\u0006\u0002\u00109J\u0015\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\rH\u0016¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010=\u001a\u00020\tH\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020)H\u0002J\b\u0010A\u001a\u00020)H\u0002J\u0010\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020\tH\u0002J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020\tH\u0002J\u0014\u0010F\u001a\u00020\u00112\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J\u0018\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\t2\u0006\u0010C\u001a\u00020\tH\u0002J\u001d\u0010I\u001a\u00020)2\u0006\u0010H\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J&\u0010J\u001a\u00020)2\u0006\u0010H\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010C\u001a\u00020\tH\u0002J\u0015\u0010K\u001a\u00028\u00002\u0006\u0010H\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u001cJ\u0018\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\tH\u0002J.\u0010O\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-2\u0006\u0010P\u001a\u00020\u0011H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006T"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initialCapacity", "", "<init>", "(I)V", "backing", "", "[Ljava/lang/Object;", "length", "isReadOnly", "", "build", "", "writeReplace", "", "size", "getSize", "()I", "isEmpty", "get", "index", "(I)Ljava/lang/Object;", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "iterator", "", "listIterator", "", "add", "(Ljava/lang/Object;)Z", "", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "removeAt", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "registerModification", "checkIsMutable", "ensureExtraCapacity", "n", "ensureCapacityInternal", "minCapacity", "contentEquals", "insertAtInternal", "i", "addAtInternal", "addAllInternal", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainOrRemoveAllInternal", "retain", "Companion", "Itr", "BuilderSubList", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
    private static final Companion Companion = new Companion(null);
    private static final ListBuilder Empty;
    private E[] backing;
    private boolean isReadOnly;
    private int length;

    public ListBuilder() {
        this(0, 1, null);
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException(C0000.decode(new byte[]{54, 90, 80, 25, 15, 10, 70, 68, 67, 81, 86, 13, 12, 93, 65, 25, 1, 6, 21, 67, 6, 64, 94, 2, 14, 91, 79, 92, 7, 67, 66, 88, 10, 94, 82, 67, 11, 70, 21, 80, 16, 67, 87, 85, 10, 92, 80, 67, 0, 71, 92, 85, 23, 77}, "b259cc50c27c"));
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{7, 92, 7, 88, 84, 94, 76, 69}, "b0b51086e2dd9ae0", true));
        checkIsMutable();
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        int size = elements.size();
        addAllInternal(index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{92, 9, 92, 14, 0, 94, 22, 70}, "9e9ce0b5d5058f79", 0.0f));
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.length, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{81, 85, 84, 91, 83, 94, 76, 18}, "4916608a5f597f"));
        checkIsMutable();
        return retainOrRemoveAllInternal(0, this.length, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{92, 90, 86, 84, 87, 89, 77, 16}, "9639279c8a0e35", 3));
        checkIsMutable();
        return retainOrRemoveAllInternal(0, this.length, elements, true) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, C0000.decode(new byte[]{2, 69, 20, 7, 79}, "c7ff6b82c4cbcff8", 7));
        int length = array.length;
        int i = this.length;
        if (length >= i) {
            ArraysKt.copyInto(this.backing, array, 0, 0, i);
            return (T[]) CollectionsKt.terminateCollectionToArray(this.length, array);
        }
        T[] tArr = (T[]) Arrays.copyOfRange(this.backing, 0, i, array.getClass());
        Intrinsics.checkNotNullExpressionValue(tArr, C0000.decode(new byte[]{82, 86, 64, 76, 121, 95, 51, 88, 95, 5, 84, 17, 30, 27, 24, 16}, "190569a91b", 0.0f));
        return tArr;
    }

    public ListBuilder(int i) {
        this.backing = (E[]) ListBuilderKt.arrayOfUninitializedElements(i);
    }

    public /* synthetic */ ListBuilder(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i);
    }

    /* JADX INFO: compiled from: ListBuilder.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Companion;", "", "<init>", "()V", "Empty", "Lkotlin/collections/builders/ListBuilder;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        ListBuilder listBuilder = new ListBuilder(0);
        listBuilder.isReadOnly = true;
        Empty = listBuilder;
    }

    public final List<E> build() {
        checkIsMutable();
        this.isReadOnly = true;
        return this.length > 0 ? this : Empty;
    }

    @Override // kotlin.collections.AbstractMutableList
    /* JADX INFO: renamed from: getSize, reason: from getter */
    public int getLength() {
        return this.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        return this.backing[index];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        checkIsMutable();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        E[] eArr = this.backing;
        E e = eArr[index];
        eArr[index] = element;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        for (int i = 0; i < this.length; i++) {
            if (Intrinsics.areEqual(this.backing[i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.backing[i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        return new Itr(this, index);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        checkIsMutable();
        addAtInternal(this.length, element);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        checkIsMutable();
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
        addAtInternal(index, element);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(0, this.length);
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        checkIsMutable();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
        return removeAtInternal(index);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        checkIsMutable();
        int iIndexOf = indexOf(element);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
        return new BuilderSubList(this.backing, fromIndex, toIndex - fromIndex, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ArraysKt.copyOfRange(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object other) {
        if (other != this) {
            return (other instanceof List) && contentEquals((List) other);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return ListBuilderKt.subarrayContentHashCode(this.backing, 0, this.length);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return ListBuilderKt.subarrayContentToString(this.backing, 0, this.length, this);
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void checkIsMutable() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    private final void ensureExtraCapacity(int n) {
        ensureCapacityInternal(this.length + n);
    }

    private final void ensureCapacityInternal(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > this.backing.length) {
            this.backing = (E[]) ListBuilderKt.copyOfUninitializedElements(this.backing, AbstractList.INSTANCE.newCapacity$kotlin_stdlib(this.backing.length, minCapacity));
        }
    }

    private final boolean contentEquals(List<?> other) {
        return ListBuilderKt.subarrayContentEquals(this.backing, 0, this.length, other);
    }

    private final void insertAtInternal(int i, int n) {
        ensureExtraCapacity(n);
        E[] eArr = this.backing;
        ArraysKt.copyInto(eArr, eArr, i + n, i, this.length);
        this.length += n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAtInternal(int i, E element) {
        registerModification();
        insertAtInternal(i, 1);
        this.backing[i] = element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAllInternal(int i, Collection<? extends E> elements, int n) {
        registerModification();
        insertAtInternal(i, n);
        Iterator<? extends E> it = elements.iterator();
        for (int i2 = 0; i2 < n; i2++) {
            this.backing[i + i2] = it.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E removeAtInternal(int i) {
        registerModification();
        E[] eArr = this.backing;
        E e = eArr[i];
        ArraysKt.copyInto(eArr, eArr, i, i + 1, this.length);
        ListBuilderKt.resetAt(this.backing, this.length - 1);
        this.length--;
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeRangeInternal(int rangeOffset, int rangeLength) {
        if (rangeLength > 0) {
            registerModification();
        }
        E[] eArr = this.backing;
        ArraysKt.copyInto(eArr, eArr, rangeOffset, rangeOffset + rangeLength, this.length);
        E[] eArr2 = this.backing;
        int i = this.length;
        ListBuilderKt.resetRange(eArr2, i - rangeLength, i);
        this.length -= rangeLength;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
        int i = 0;
        int i2 = 0;
        while (i < rangeLength) {
            int i3 = rangeOffset + i;
            if (elements.contains(this.backing[i3]) == retain) {
                E[] eArr = this.backing;
                i++;
                eArr[i2 + rangeOffset] = eArr[i3];
                i2++;
            } else {
                i++;
            }
        }
        int i4 = rangeLength - i2;
        E[] eArr2 = this.backing;
        ArraysKt.copyInto(eArr2, eArr2, rangeOffset + i2, rangeLength + rangeOffset, this.length);
        E[] eArr3 = this.backing;
        int i5 = this.length;
        ListBuilderKt.resetRange(eArr3, i5 - i4, i5);
        if (i4 > 0) {
            registerModification();
        }
        this.length -= i4;
        return i4;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\fH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\r\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder;", "index", "", "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "expectedModCount", "hasPrevious", "", "hasNext", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "set", "", "element", "(Ljava/lang/Object;)V", "add", "remove", "checkForComodification", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
        private int expectedModCount;
        private int index;
        private int lastIndex;
        private final ListBuilder<E> list;

        public Itr(ListBuilder<E> listBuilder, int i) {
            Intrinsics.checkNotNullParameter(listBuilder, C0000.decode(new byte[]{9, 92, 22, 21}, "e5eaf85c6ca8ef49"));
            this.list = listBuilder;
            this.index = i;
            this.lastIndex = -1;
            this.expectedModCount = listBuilder.modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            int i = this.lastIndex;
            if (i == -1) {
                throw new IllegalStateException(C0000.decode(new byte[]{114, 88, 9, 84, 20, 10, 82, 75, 69, 17, 76, 24, 91, 22, 23, 67, 67, 92, 19, 81, 91, 17, 68, 27, 24, 25, 7, 93, 82, 11, 69, 86, 17, 75, 0, 85, 91, 18, 94, 93, 86, 25, 0, 84, 81, 9, 82, 93, 69, 25, 3, 74, 91, 9, 23, 71, 89, 92, 69, 81, 64, 1, 69, 82, 69, 86, 23, 22}, "19e84d73", true).toString());
            }
            this.list.remove(i);
            this.index = this.lastIndex;
            this.lastIndex = -1;
            this.expectedModCount = this.list.modCount;
        }

        @Override // java.util.ListIterator
        public void set(E element) {
            checkForComodification();
            int i = this.lastIndex;
            if (i == -1) {
                throw new IllegalStateException(C0000.decode(new byte[]{115, 4, 8, 15, 69, 90, 6, 26, 68, 77, 77, 67, 10, 70, 67, 18, 66, 0, 18, 10, 10, 65, 16, 74, 25, 69, 6, 6, 3, 91, 17, 7, 16, 23, 1, 19, 9, 85, 0, 11, 94, 2, 68, 6, 9, 81, 14, 7, 94, 17, 68, 5, 23, 91, 14, 66, 68, 13, 1, 67, 12, 64, 6, 16, 81, 17, 11, 17, 75}, "0edce4cb", 0.0f).toString());
            }
            this.list.set(i, element);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < ((ListBuilder) this.list).length;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            int i = this.index;
            if (i <= 0) {
                throw new NoSuchElementException();
            }
            int i2 = i - 1;
            this.index = i2;
            this.lastIndex = i2;
            return (E) ((ListBuilder) this.list).backing[this.lastIndex];
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (this.index >= ((ListBuilder) this.list).length) {
                throw new NoSuchElementException();
            }
            int i = this.index;
            this.index = i + 1;
            this.lastIndex = i;
            return (E) ((ListBuilder) this.list).backing[this.lastIndex];
        }

        @Override // java.util.ListIterator
        public void add(E element) {
            checkForComodification();
            ListBuilder<E> listBuilder = this.list;
            int i = this.index;
            this.index = i + 1;
            listBuilder.add(i, element);
            this.lastIndex = -1;
            this.expectedModCount = this.list.modCount;
        }

        private final void checkForComodification() {
            if (this.list.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\f\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001QBC\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010!J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010$H\u0096\u0002J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010&H\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010&2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0015\u0010'\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010(J\u001d\u0010'\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-H\u0016J\u001e\u0010+\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-H\u0016J\b\u0010.\u001a\u00020)H\u0016J\u0015\u0010/\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001cJ\u0015\u00100\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010(J\u0016\u00101\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-H\u0016J\u0016\u00102\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-H\u0016J\u001e\u00103\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000bH\u0016J'\u00106\u001a\b\u0012\u0004\u0012\u0002H70\t\"\u0004\b\u0002\u001072\f\u00108\u001a\b\u0012\u0004\u0012\u0002H70\tH\u0016¢\u0006\u0002\u00109J\u0015\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\tH\u0016¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020\u00192\b\u0010<\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010=\u001a\u00020\u000bH\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020)H\u0002J\b\u0010A\u001a\u00020)H\u0002J\b\u0010B\u001a\u00020)H\u0002J\u0014\u0010E\u001a\u00020\u00192\n\u0010<\u001a\u0006\u0012\u0002\b\u00030FH\u0002J\u001d\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010*J&\u0010I\u001a\u00020)2\u0006\u0010H\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010J\u001a\u00020\u000bH\u0002J\u0015\u0010K\u001a\u00028\u00012\u0006\u0010H\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001cJ\u0018\u0010L\u001a\u00020)2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000bH\u0002J.\u0010O\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-2\u0006\u0010P\u001a\u00020\u0019H\u0002R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010C\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006R"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "backing", "", "offset", "", "length", "parent", "root", "Lkotlin/collections/builders/ListBuilder;", "<init>", "([Ljava/lang/Object;IILkotlin/collections/builders/ListBuilder$BuilderSubList;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "writeReplace", "", "size", "getSize", "()I", "isEmpty", "", "get", "index", "(I)Ljava/lang/Object;", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "iterator", "", "listIterator", "", "add", "(Ljava/lang/Object;)Z", "", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "removeAt", "remove", "removeAll", "retainAll", "subList", "fromIndex", "toIndex", "toArray", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "", "registerModification", "checkForComodification", "checkIsMutable", "isReadOnly", "()Z", "contentEquals", "", "addAtInternal", "i", "addAllInternal", "n", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainOrRemoveAllInternal", "retain", "Itr", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BuilderSubList<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {
        private E[] backing;
        private int length;
        private final int offset;
        private final BuilderSubList<E> parent;
        private final ListBuilder<E> root;

        public BuilderSubList(E[] eArr, int i, int i2, BuilderSubList<E> builderSubList, ListBuilder<E> listBuilder) {
            Intrinsics.checkNotNullParameter(eArr, C0000.decode(new byte[]{86, 84, 84, 89, 8, 89, 82}, "4572a75c", 6));
            Intrinsics.checkNotNullParameter(listBuilder, C0000.decode(new byte[]{64, 11, 89, 18}, "2d6ffac6490e"));
            this.backing = eArr;
            this.offset = i;
            this.length = i2;
            this.parent = builderSubList;
            this.root = listBuilder;
            this.modCount = listBuilder.modCount;
        }

        private final Object writeReplace() throws NotSerializableException {
            if (isReadOnly()) {
                return new SerializedCollection(this, 0);
            }
            throw new NotSerializableException(C0000.decode(new byte[]{49, 12, 4, 20, 95, 11, 68, 68, 20, 80, 4, 10, 15, 91, 71, 66, 85, 85, 20, 64, 0, 22, 8, 85, 95, 11, 77, 85, 80, 19, 18, 12, 8, 88, 86, 66, 94, 68, 20, 90, 22, 68, 3, 81, 90, 12, 80, 16, 86, 70, 12, 8, 21, 26}, "eda43b7043", 0.0f));
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int index, Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{6, 10, 84, 90, 85, 95, 18, 65}, "cf1701f2a003", 0.0f));
            checkIsMutable();
            checkForComodification();
            AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
            int size = elements.size();
            addAllInternal(this.offset + index, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> elements) {
            Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{93, 14, 1, 11, 87, 10, 66, 23}, "8bdf2d6d92c257", 0.0f));
            checkIsMutable();
            checkForComodification();
            int size = elements.size();
            addAllInternal(this.offset + this.length, elements, size);
            return size > 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean removeAll(Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{0, 92, 80, 89, 81, 8, 17, 67}, "e0544f", 5));
            checkIsMutable();
            checkForComodification();
            return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean retainAll(Collection<?> elements) {
            Intrinsics.checkNotNullParameter(elements, C0000.decode(new byte[]{86, 94, 86, 12, 81, 11, 21, 22}, "323a4eaeee9c", 0.0f));
            checkIsMutable();
            checkForComodification();
            return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] array) {
            Intrinsics.checkNotNullParameter(array, C0000.decode(new byte[]{80, 20, 71, 83, 75}, "1f5221ec3c", false));
            checkForComodification();
            int length = array.length;
            int i = this.length;
            if (length >= i) {
                E[] eArr = this.backing;
                int i2 = this.offset;
                ArraysKt.copyInto(eArr, array, 0, i2, i + i2);
                return (T[]) CollectionsKt.terminateCollectionToArray(this.length, array);
            }
            E[] eArr2 = this.backing;
            int i3 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr2, i3, i + i3, array.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, C0000.decode(new byte[]{6, 92, 73, 26, 46, 7, 100, 88, 15, 6, 82, 78, 75, 29, 23, 74}, "e39caa69aa7f", 0.0f));
            return tArr;
        }

        @Override // kotlin.collections.AbstractMutableList
        /* JADX INFO: renamed from: getSize */
        public int getLength() {
            checkForComodification();
            return this.length;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            checkForComodification();
            return this.length == 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            checkForComodification();
            AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
            return this.backing[this.offset + index];
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public E set(int index, E element) {
            checkIsMutable();
            checkForComodification();
            AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
            E[] eArr = this.backing;
            int i = this.offset;
            E e = eArr[i + index];
            eArr[i + index] = element;
            return e;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object element) {
            checkForComodification();
            for (int i = 0; i < this.length; i++) {
                if (Intrinsics.areEqual(this.backing[this.offset + i], element)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object element) {
            checkForComodification();
            for (int i = this.length - 1; i >= 0; i--) {
                if (Intrinsics.areEqual(this.backing[this.offset + i], element)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int index) {
            checkForComodification();
            AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
            return new Itr(this, index);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(E element) {
            checkIsMutable();
            checkForComodification();
            addAtInternal(this.offset + this.length, element);
            return true;
        }

        @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
        public void add(int index, E element) {
            checkIsMutable();
            checkForComodification();
            AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.length);
            addAtInternal(this.offset + index, element);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkIsMutable();
            checkForComodification();
            removeRangeInternal(this.offset, this.length);
        }

        @Override // kotlin.collections.AbstractMutableList
        public E removeAt(int index) {
            checkIsMutable();
            checkForComodification();
            AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.length);
            return removeAtInternal(this.offset + index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object element) {
            checkIsMutable();
            checkForComodification();
            int iIndexOf = indexOf(element);
            if (iIndexOf >= 0) {
                remove(iIndexOf);
            }
            return iIndexOf >= 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.length);
            return new BuilderSubList(this.backing, this.offset + fromIndex, toIndex - fromIndex, this, this.root);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            checkForComodification();
            E[] eArr = this.backing;
            int i = this.offset;
            return ArraysKt.copyOfRange(eArr, i, this.length + i);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object other) {
            checkForComodification();
            if (other != this) {
                return (other instanceof List) && contentEquals((List) other);
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            checkForComodification();
            return ListBuilderKt.subarrayContentHashCode(this.backing, this.offset, this.length);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            checkForComodification();
            return ListBuilderKt.subarrayContentToString(this.backing, this.offset, this.length, this);
        }

        private final void registerModification() {
            this.modCount++;
        }

        private final void checkForComodification() {
            if (this.root.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private final void checkIsMutable() {
            if (isReadOnly()) {
                throw new UnsupportedOperationException();
            }
        }

        private final boolean isReadOnly() {
            return ((ListBuilder) this.root).isReadOnly;
        }

        private final boolean contentEquals(List<?> other) {
            return ListBuilderKt.subarrayContentEquals(this.backing, this.offset, this.length, other);
        }

        private final void addAtInternal(int i, E element) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList == null) {
                this.root.addAtInternal(i, element);
            } else {
                builderSubList.addAtInternal(i, element);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length++;
        }

        private final void addAllInternal(int i, Collection<? extends E> elements, int n) {
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList == null) {
                this.root.addAllInternal(i, elements, n);
            } else {
                builderSubList.addAllInternal(i, elements, n);
            }
            this.backing = (E[]) ((ListBuilder) this.root).backing;
            this.length += n;
        }

        private final E removeAtInternal(int i) {
            E eRemoveAtInternal;
            registerModification();
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList == null) {
                eRemoveAtInternal = (E) this.root.removeAtInternal(i);
            } else {
                eRemoveAtInternal = builderSubList.removeAtInternal(i);
            }
            this.length--;
            return eRemoveAtInternal;
        }

        private final void removeRangeInternal(int rangeOffset, int rangeLength) {
            if (rangeLength > 0) {
                registerModification();
            }
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList == null) {
                this.root.removeRangeInternal(rangeOffset, rangeLength);
            } else {
                builderSubList.removeRangeInternal(rangeOffset, rangeLength);
            }
            this.length -= rangeLength;
        }

        private final int retainOrRemoveAllInternal(int rangeOffset, int rangeLength, Collection<? extends E> elements, boolean retain) {
            int iRetainOrRemoveAllInternal;
            BuilderSubList<E> builderSubList = this.parent;
            if (builderSubList == null) {
                iRetainOrRemoveAllInternal = this.root.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
            } else {
                iRetainOrRemoveAllInternal = builderSubList.retainOrRemoveAllInternal(rangeOffset, rangeLength, elements, retain);
            }
            if (iRetainOrRemoveAllInternal > 0) {
                registerModification();
            }
            this.length -= iRetainOrRemoveAllInternal;
            return iRetainOrRemoveAllInternal;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\t\u0010\r\u001a\u00020\fH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\r\u0010\u0010\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0002H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lkotlin/collections/builders/ListBuilder$BuilderSubList$Itr;", "E", "", "list", "Lkotlin/collections/builders/ListBuilder$BuilderSubList;", "index", "", "<init>", "(Lkotlin/collections/builders/ListBuilder$BuilderSubList;I)V", "lastIndex", "expectedModCount", "hasPrevious", "", "hasNext", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "set", "", "element", "(Ljava/lang/Object;)V", "add", "remove", "checkForComodification", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        private static final class Itr<E> implements ListIterator<E>, KMutableListIterator {
            private int expectedModCount;
            private int index;
            private int lastIndex;
            private final BuilderSubList<E> list;

            public Itr(BuilderSubList<E> builderSubList, int i) {
                Intrinsics.checkNotNullParameter(builderSubList, C0000.decode(new byte[]{15, 92, 23, 22}, "c5db9680db"));
                this.list = builderSubList;
                this.index = i;
                this.lastIndex = -1;
                this.expectedModCount = builderSubList.modCount;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                checkForComodification();
                int i = this.lastIndex;
                if (i == -1) {
                    throw new IllegalStateException(C0000.decode(new byte[]{112, 82, 90, 90, 69, 89, 87, 74, 18, 16, 76, 18, 86, 70, 19, 67, 68, 83, 19, 94, 93, 71, 21, 16, 76, 18, 91, 81, 85, 92, 68, 83, 69, 69, 87, 95, 9, 78, 12, 92, 94, 20, 86, 95, 83, 91, 0, 89, 70, 18, 0, 74, 10, 95, 25, 64, 91, 86, 22, 95, 17, 82, 64, 83, 18, 87, 23, 28}, "3366e722f8e294").toString());
                }
                this.list.remove(i);
                this.index = this.lastIndex;
                this.lastIndex = -1;
                this.expectedModCount = this.list.modCount;
            }

            @Override // java.util.ListIterator
            public void set(E element) {
                checkForComodification();
                int i = this.lastIndex;
                if (i == -1) {
                    throw new IllegalStateException(C0000.decode(new byte[]{117, 81, 89, 90, 19, 13, 0, 26, 70, 73, 31, 16, 90, 68, 19, 19, 23, 7, 68, 8, 89, 69, 70, 30, 26, 67, 7, 7, 84, 14, 68, 85, 21, 68, 86, 19, 9, 3, 81, 8, 88, 87, 21, 83, 95, 6, 8, 7, 92, 21, 22, 86, 71, 89, 94, 67, 17, 10, 87, 65, 95, 68, 80, 68, 82, 23, 10, 16, 28}, "60563ceb2a").toString());
                }
                this.list.set(i, element);
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.index > 0;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.index < ((BuilderSubList) this.list).length;
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.index - 1;
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.index;
            }

            @Override // java.util.ListIterator
            public E previous() {
                checkForComodification();
                int i = this.index;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i2 = i - 1;
                this.index = i2;
                this.lastIndex = i2;
                return (E) ((BuilderSubList) this.list).backing[((BuilderSubList) this.list).offset + this.lastIndex];
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public E next() {
                checkForComodification();
                if (this.index >= ((BuilderSubList) this.list).length) {
                    throw new NoSuchElementException();
                }
                int i = this.index;
                this.index = i + 1;
                this.lastIndex = i;
                return (E) ((BuilderSubList) this.list).backing[((BuilderSubList) this.list).offset + this.lastIndex];
            }

            @Override // java.util.ListIterator
            public void add(E element) {
                checkForComodification();
                BuilderSubList<E> builderSubList = this.list;
                int i = this.index;
                this.index = i + 1;
                builderSubList.add(i, element);
                this.lastIndex = -1;
                this.expectedModCount = this.list.modCount;
            }

            private final void checkForComodification() {
                if (((BuilderSubList) this.list).root.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        }
    }
}
