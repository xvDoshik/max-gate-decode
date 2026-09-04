package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a,\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087\b\u001a&\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0086\b¢\u0006\u0002\u0010\u000b\u001a/\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0001\u001a#\u0010\u0014\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"orEmpty", "", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", "charset", "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "arrayOfNulls", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeToIndexCheck", "", "toIndex", "contentDeepHashCodeImpl", "contentDeepHashCode", "([Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
class ArraysKt__ArraysJVMKt {
    public static final <T> T[] arrayOfNulls(T[] tArr, int i) {
        Intrinsics.checkNotNullParameter(tArr, C0000.decode(new byte[]{66, 82, 83, 86, 20, 82, 87, 7, 85}, "0753f79d", 0.0f));
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i);
        Intrinsics.checkNotNull(objNewInstance, C0000.decode(new byte[]{12, 65, 94, 90, 67, 87, 4, 89, 92, 10, 70, 66, 84, 83, 19, 0, 3, 71, 70, 22, 23, 91, 69, 89, 93, 11, 31, 12, 67, 90, 95, 67, 22, 77, 66, 83, 67, 95, 10, 67, 94, 12, 92, 76, 119, 68, 65, 2, 27, 8, 102, 22, 12, 82, 69, 92, 93, 17, 94, 11, 88, 24, 80, 12, 14, 88, 87, 85, 23, 93, 10, 89, 65, 75, 115, 16, 68, 87, 74, 16, 41, 64, 109, 105, 34, 70, 23, 86, 75, 22, 120, 52, 123, 125, 71, 77, 3, 70, 64, 87, 26, 123, 3, 121, 71, 9, 94, 17, 8}, "b426c4e72e2b663c"));
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final void copyOfRangeToIndexCheck(int i, int i2) {
        if (i > i2) {
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{17, 90, 122, 86, 86, 0, 73, 69, 28}, "e5382e1e41", 0.0f) + i + C0000.decode(new byte[]{24, 70, 88, 74, 22, 84, 67, 7, 85, 68, 7, 75, 17, 18, 89, 88, 88, 19, 66, 11, 78, 85, 66, 17}, "1f19631b40b9") + i2 + C0000.decode(new byte[]{75, 26}, "b43a6c6f10fbad"));
        }
    }

    public static final /* synthetic */ <T> T[] orEmpty(T[] tArr) {
        if (tArr != null) {
            return tArr;
        }
        Intrinsics.reifiedOperationMarker(0, C0000.decode(new byte[]{97}, "537d7c40f2", 5));
        return (T[]) new Object[0];
    }

    private static final String toString(byte[] bArr, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{12, 67, 95, 95, 67, 95}, "07760a25", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{80, 10, 83, 75, 75, 82, 70}, "3b29872e4bc7", 0.0f));
        return new String(bArr, charset);
    }

    public static final /* synthetic */ <T> T[] toTypedArray(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, C0000.decode(new byte[]{93, 65, 9, 91, 17, 9}, "a5a2b7203ccec8", 2));
        Intrinsics.reifiedOperationMarker(0, C0000.decode(new byte[]{97, 90}, "5e82d5ae78189d", false));
        return (T[]) collection.toArray(new Object[0]);
    }

    public static final <T> int contentDeepHashCode(T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }
}
