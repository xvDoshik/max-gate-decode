package okio;

import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.concurrent.TimeUnit;
import kotlin.collections.AbstractList;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Options extends AbstractList implements RandomAccess {
    public final ByteString[] byteStrings;
    public final int[] trie;

    public abstract class Companion {
        public static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();

        public static AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head.next;
            if (asyncTimeout == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.condition.await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                if (AsyncTimeout.head.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jNanoTime2 = asyncTimeout.timeoutAt - System.nanoTime();
            if (jNanoTime2 > 0) {
                AsyncTimeout.condition.await(jNanoTime2, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout.head.next = asyncTimeout.next;
            asyncTimeout.next = null;
            return asyncTimeout;
        }

        public static void buildTrieRecursive(long j, Buffer buffer, int i, ArrayList arrayList, int i2, int i3, ArrayList arrayList2) {
            int i4;
            int i5;
            ArrayList arrayList3;
            long j2;
            int i6;
            int i7 = i;
            ArrayList arrayList4 = arrayList;
            ArrayList arrayList5 = arrayList2;
            String strDecode = C0000.decode(new byte[]{32, 82, 80, 95, 93, 2, 22, 71, 93, 65, 70, 15, 67, 83, 11, 86, 87, 71, 22}, "f3938f65803f16");
            if (i2 >= i3) {
                throw new IllegalArgumentException(strDecode);
            }
            for (int i8 = i2; i8 < i3; i8++) {
                if (((ByteString) arrayList4.get(i8)).getSize$okio() < i7) {
                    throw new IllegalArgumentException(strDecode);
                }
            }
            ByteString byteString = (ByteString) arrayList.get(i2);
            ByteString byteString2 = (ByteString) arrayList4.get(i3 - 1);
            if (i7 == byteString.getSize$okio()) {
                int iIntValue = ((Number) arrayList5.get(i2)).intValue();
                int i9 = i2 + 1;
                ByteString byteString3 = (ByteString) arrayList4.get(i9);
                i4 = i9;
                i5 = iIntValue;
                byteString = byteString3;
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (byteString.internalGet$okio(i7) == byteString2.internalGet$okio(i7)) {
                int iMin = Math.min(byteString.getSize$okio(), byteString2.getSize$okio());
                int i10 = 0;
                for (int i11 = i7; i11 < iMin && byteString.internalGet$okio(i11) == byteString2.internalGet$okio(i11); i11++) {
                    i10++;
                }
                long j3 = 4;
                long j4 = (buffer.size / j3) + j + ((long) 2) + ((long) i10) + 1;
                buffer.m25writeInt(-i10);
                buffer.m25writeInt(i5);
                int i12 = i7 + i10;
                while (i7 < i12) {
                    buffer.m25writeInt(byteString.internalGet$okio(i7) & 255);
                    i7++;
                }
                if (i4 + 1 == i3) {
                    if (i12 != ((ByteString) arrayList4.get(i4)).getSize$okio()) {
                        throw new IllegalStateException(C0000.decode(new byte[]{34, 10, 87, 90, 94, 23, 7, 3, 91, 85, 80, 83, 79}, "ab2957", 2));
                    }
                    buffer.m25writeInt(((Number) arrayList5.get(i4)).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    buffer.m25writeInt(((int) ((buffer2.size / j3) + j4)) * (-1));
                    buildTrieRecursive(j4, buffer2, i12, arrayList4, i4, i3, arrayList5);
                    buffer.writeAll(buffer2);
                    return;
                }
            }
            int i13 = 1;
            for (int i14 = i4 + 1; i14 < i3; i14++) {
                if (((ByteString) arrayList4.get(i14 - 1)).internalGet$okio(i7) != ((ByteString) arrayList4.get(i14)).internalGet$okio(i7)) {
                    i13++;
                }
            }
            long j5 = 4;
            long j6 = (buffer.size / j5) + j + ((long) 2) + ((long) (i13 * 2));
            buffer.m25writeInt(i13);
            buffer.m25writeInt(i5);
            for (int i15 = i4; i15 < i3; i15++) {
                int iInternalGet$okio = ((ByteString) arrayList4.get(i15)).internalGet$okio(i7);
                if (i15 == i4 || iInternalGet$okio != ((ByteString) arrayList4.get(i15 - 1)).internalGet$okio(i7)) {
                    buffer.m25writeInt(iInternalGet$okio & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            int i16 = i4;
            while (i16 < i3) {
                byte bInternalGet$okio = ((ByteString) arrayList4.get(i16)).internalGet$okio(i7);
                int i17 = i16 + 1;
                int i18 = i17;
                while (true) {
                    if (i18 >= i3) {
                        i18 = i3;
                        break;
                    } else if (bInternalGet$okio != ((ByteString) arrayList4.get(i18)).internalGet$okio(i7)) {
                        break;
                    } else {
                        i18++;
                    }
                }
                if (i17 == i18 && i7 + 1 == ((ByteString) arrayList4.get(i16)).getSize$okio()) {
                    buffer.m25writeInt(((Number) arrayList5.get(i16)).intValue());
                    arrayList3 = arrayList5;
                    j2 = j6;
                    i6 = i18;
                } else {
                    buffer.m25writeInt(((int) ((buffer3.size / j5) + j6)) * (-1));
                    arrayList3 = arrayList5;
                    j2 = j6;
                    i6 = i18;
                    buildTrieRecursive(j2, buffer3, i7 + 1, arrayList, i16, i6, arrayList3);
                    arrayList4 = arrayList;
                }
                j6 = j2;
                i16 = i6;
                arrayList5 = arrayList3;
            }
            buffer.writeAll(buffer3);
        }

        public static final void checkOffsetAndCount(long j, long j2, long j3) {
            if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
                throw new ArrayIndexOutOfBoundsException(C0000.decode(new byte[]{66, 92, 75, 84, 9}, "151141d9951e") + j + C0000.decode(new byte[]{24, 10, 7, 83, 66, 93, 65, 89}, "8ea5185d1c6926", false) + j2 + C0000.decode(new byte[]{17, 86, 75, 68, 6, 119, 93, 64, 95, 64, 15}, "1420c425", 4) + j3);
            }
        }
    }

    public Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    @Override // kotlin.collections.AbstractList, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return super.contains((ByteString) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.byteStrings[i];
    }

    @Override // kotlin.collections.AbstractList
    public final int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return super.lastIndexOf((ByteString) obj);
        }
        return -1;
    }
}
