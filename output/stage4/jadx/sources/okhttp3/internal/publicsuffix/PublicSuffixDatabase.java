package okhttp3.internal.publicsuffix;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.DropSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.GzipSource;
import okio.InputStreamSource;
import okio.Okio__JvmOkioKt;
import okio.RealBufferedSource;
import okio.Timeout;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final String PUBLIC_SUFFIX_RESOURCE = C0000.decode(new byte[]{21, 69, 0, 91, 88, 87, 22, 69, 4, 81, 88, 76, 0, 67, 76, 80, 75}, "e0b714", 0);
    public static final Companion Companion = new Companion();
    private static final byte[] WILDCARD_LABEL = {42};
    private static final List<String> PREVAILING_RULE = Collections.singletonList(C0000.decode(new byte[]{24}, "2fce360fd476"));
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public final class Companion {
        public static final String access$binarySearch(Companion companion, byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            companion.getClass();
            int length = bArr.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = (i5 + length) / 2;
                while (i6 > -1 && bArr[i6] != 10) {
                    i6--;
                }
                int i7 = i6 + 1;
                int i8 = 1;
                while (true) {
                    i2 = i7 + i8;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i8++;
                }
                int i9 = i2 - i7;
                int i10 = i;
                boolean z2 = false;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        byte b = bArr2[i10][i11];
                        byte[] bArr3 = Util.EMPTY_BYTE_ARRAY;
                        int i13 = b & 255;
                        z = z2;
                        i3 = i13;
                    }
                    byte b2 = bArr[i7 + i12];
                    byte[] bArr4 = Util.EMPTY_BYTE_ARRAY;
                    i4 = i3 - (b2 & 255);
                    if (i4 != 0) {
                        break;
                    }
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        i11 = -1;
                        z2 = true;
                    }
                }
                if (i4 >= 0) {
                    if (i4 <= 0) {
                        int i14 = i9 - i12;
                        int length2 = bArr2[i10].length - i11;
                        int length3 = bArr2.length;
                        for (int i15 = i10 + 1; i15 < length3; i15++) {
                            length2 += bArr2[i15].length;
                        }
                        if (length2 >= i14) {
                            if (length2 <= i14) {
                                return new String(bArr, i7, i9, StandardCharsets.UTF_8);
                            }
                        }
                    }
                    i5 = i2 + 1;
                }
                length = i6;
            }
            return null;
        }
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String strAccess$binarySearch;
        String strAccess$binarySearch2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{51, 91, 80, 1, 8, 81, 70, 65, 94, 67, 8, 91, 7, 81, 17, 19, 17, 86, 10, 92, 82, 16, 17, 82, 0, 92, 73, 6, 23, 26, 1, 79, 17, 17, 1, 71, 9, 64, 67, 0, 1, 20, 0, 71, 94, 14, 68, 64, 14, 80, 17, 0, 8, 85, 21, 70, 65, 2, 16, 92, 72}, "f51cd4", 0.0f));
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            bArr[i] = list.get(i).getBytes(StandardCharsets.UTF_8);
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= size) {
                strAccess$binarySearch = null;
                break;
            }
            Companion companion = Companion;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                bArr2 = null;
            }
            strAccess$binarySearch = Companion.access$binarySearch(companion, bArr2, bArr, i2);
            if (strAccess$binarySearch != null) {
                break;
            }
            i2++;
        }
        if (size <= 1) {
            strAccess$binarySearch2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                strAccess$binarySearch2 = null;
                break;
            }
            bArr3[i3] = WILDCARD_LABEL;
            Companion companion2 = Companion;
            byte[] bArr4 = this.publicSuffixListBytes;
            if (bArr4 == null) {
                bArr4 = null;
            }
            strAccess$binarySearch2 = Companion.access$binarySearch(companion2, bArr4, bArr3, i3);
            if (strAccess$binarySearch2 != null) {
                break;
            }
            i3++;
        }
        if (strAccess$binarySearch2 != null) {
            int i4 = size - 1;
            for (int i5 = 0; i5 < i4; i5++) {
                Companion companion3 = Companion;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    bArr5 = null;
                }
                String strAccess$binarySearch3 = Companion.access$binarySearch(companion3, bArr5, bArr, i5);
                if (strAccess$binarySearch3 != null) {
                    str = strAccess$binarySearch3;
                    break;
                }
            }
        }
        if (str != null) {
            return StringsKt.split$default(C0000.decode(new byte[]{16}, "1395d31349b4").concat(str), new char[]{'.'});
        }
        if (strAccess$binarySearch == null && strAccess$binarySearch2 == null) {
            return PREVAILING_RULE;
        }
        List<String> listSplit$default = EmptyList.INSTANCE;
        List<String> listSplit$default2 = strAccess$binarySearch != null ? StringsKt.split$default(strAccess$binarySearch, new char[]{'.'}) : listSplit$default;
        if (strAccess$binarySearch2 != null) {
            listSplit$default = StringsKt.split$default(strAccess$binarySearch2, new char[]{'.'});
        }
        return listSplit$default2.size() > listSplit$default.size() ? listSplit$default2 : listSplit$default;
    }

    private final void readTheList() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(C0000.decode(new byte[]{22, 71, 86, 92, 91, 7, 67, 17, 95, 87, 81, 29, 3, 65, 26, 87, 72}, "f2402d0d918e", 6));
            if (resourceAsStream != null) {
                Logger logger = Okio__JvmOkioKt.logger;
                RealBufferedSource realBufferedSource = new RealBufferedSource(new GzipSource(new InputStreamSource(resourceAsStream, 0, new Timeout())));
                try {
                    long j = realBufferedSource.readInt();
                    realBufferedSource.require(j);
                    byte[] byteArray = realBufferedSource.bufferField.readByteArray(j);
                    long j2 = realBufferedSource.readInt();
                    realBufferedSource.require(j2);
                    byte[] byteArray2 = realBufferedSource.bufferField.readByteArray(j2);
                    realBufferedSource.close();
                    synchronized (this) {
                        this.publicSuffixListBytes = byteArray;
                        this.publicSuffixExceptionListBytes = byteArray2;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(realBufferedSource, th);
                        throw th2;
                    }
                }
            }
            this.readCompleteLatch.countDown();
        } catch (Throwable th3) {
            this.readCompleteLatch.countDown();
            throw th3;
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    Platform platform = Platform.platform;
                    Platform platform2 = Platform.platform;
                    String strDecode = C0000.decode(new byte[]{118, 84, 12, 88, 84, 7, 16, 65, 10, 20, 67, 6, 81, 81, 69, 68, 68, 1, 92, 92, 6, 20, 66, 22, 86, 83, 12, 76, 17, 15, 89, 70, 17}, "05e41c");
                    platform2.getClass();
                    Platform.log(strDecode, 5, e);
                    if (!z) {
                        return;
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    private final List<String> splitDomain(String str) {
        List<String> listSplit$default = StringsKt.split$default(str, new char[]{'.'});
        boolean zIsEmpty = listSplit$default.isEmpty();
        String strDecode = C0000.decode(new byte[]{41, 80, 66, 69, 70, 88, 16, 70, 1, 88, 70, 66, 79, 31}, "e911f1cfd56661", false);
        if (zIsEmpty) {
            throw new NoSuchElementException(strDecode);
        }
        if (!Intrinsics.areEqual(listSplit$default.get(CollectionsKt__CollectionsKt.getLastIndex(listSplit$default)), "")) {
            return listSplit$default;
        }
        int size = listSplit$default.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{97, 93, 18, 22, 3, 16, 67, 87, 86, 66, 84, 14, 86, 85, 6, 13, 18, 67, 84, 93, 71, 12, 69, 66}, "38ccfc722b1b", 6), C0000.decode(new byte[]{20, 81, 65, 21, 93, 1, 17, 17, 68, 16, 90, 83, 11, 22, 78, 93, 64, 90, 31}, "48251dbbdd22e6", true), size).toString());
        }
        EmptyList emptyList = EmptyList.INSTANCE;
        if (size == 0) {
            return emptyList;
        }
        if (size >= listSplit$default.size()) {
            return CollectionsKt.toList(listSplit$default);
        }
        if (size == 1) {
            if (listSplit$default.isEmpty()) {
                throw new NoSuchElementException(strDecode);
            }
            return Collections.singletonList(listSplit$default.get(0));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = listSplit$default.iterator();
        int i = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i++;
            if (i == size) {
                break;
            }
        }
        int size2 = arrayList.size();
        if (size2 != 0) {
            return size2 != 1 ? arrayList : Collections.singletonList(arrayList.get(0));
        }
        return emptyList;
    }

    public final String getEffectiveTldPlusOne(String str) {
        int size;
        int size2;
        List<String> listSplitDomain = splitDomain(IDN.toUnicode(str));
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        int i = 0;
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        int i2 = size - size2;
        Sequence sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 = new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(1, splitDomain(str));
        if (i2 < 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{103, 0, 65, 70, 87, 65, 70, 82, 80, 67, 83, 13, 0, 95, 85, 12, 65, 69, 83, 92, 71, 92, 70, 23}, "5e0322274c6ae20b"), C0000.decode(new byte[]{17, 93, 68, 67, 92, 84, 71, 16, 19, 17, 12, 0, 95, 20, 77, 6, 66, 94, 26}, "147c014c3eda", 5), i2).toString());
        }
        if (i2 != 0) {
            sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 = new DropSequence(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1, i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) C0000.decode(new byte[]{31}, "11dbbbb0", 0.0f));
            }
            CloseableKt.appendElement(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
