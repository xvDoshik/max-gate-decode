package kotlin.internal.jdk7;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "<init>", "()V", "sdkIsNullOrAtLeast", "", "version", "", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "ReflectSdkVersion", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class JDK7PlatformImplementations extends PlatformImplementations {
    @Override // kotlin.internal.PlatformImplementations
    public void addSuppressed(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(cause, C0000.decode(new byte[]{84, 4, 64, 67, 3}, "7e50fa56", 5));
        Intrinsics.checkNotNullParameter(exception, C0000.decode(new byte[]{6, 78, 91, 1, 65, 64, 88, 89, 13}, "c68d1416cb50", true));
        if (sdkIsNullOrAtLeast(19)) {
            cause.addSuppressed(exception);
        } else {
            super.addSuppressed(cause, exception);
        }
    }

    @Override // kotlin.internal.PlatformImplementations
    public List<Throwable> getSuppressed(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, C0000.decode(new byte[]{93, 27, 85, 81, 71, 21, 8, 93, 8}, "8c647aa2f4", 6));
        if (!sdkIsNullOrAtLeast(19)) {
            return super.getSuppressed(exception);
        }
        Throwable[] suppressed = exception.getSuppressed();
        Intrinsics.checkNotNullExpressionValue(suppressed, C0000.decode(new byte[]{3, 83, 76, 106, 77, 18, 70, 64, 80, 75, 64, 4, 0, 30, 22, 23, 22, 75}, "d6898b62583a"));
        return ArraysKt.asList(suppressed);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion;", "", "<init>", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = new ReflectSdkVersion();
        public static final Integer sdkVersion;

        static {
            Integer num;
            Integer num2 = null;
            try {
                Object obj = Class.forName(C0000.decode(new byte[]{5, 89, 0, 67, 93, 11, 0, 25, 11, 66, 28, 32, 17, 94, 8, 85, 22, 52, 33, 101, 55, 120, 125, 44}, "d7d12b", 6)).getField(C0000.decode(new byte[]{102, 115, 120, 111, 125, 124, 54}, "573042b9a37c", 4)).get(null);
                num = obj instanceof Integer ? (Integer) obj : null;
            } catch (Throwable unused) {
            }
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            sdkVersion = num2;
        }

        private ReflectSdkVersion() {
        }
    }

    private final boolean sdkIsNullOrAtLeast(int version) {
        return ReflectSdkVersion.sdkVersion == null || ReflectSdkVersion.sdkVersion.intValue() >= version;
    }
}
