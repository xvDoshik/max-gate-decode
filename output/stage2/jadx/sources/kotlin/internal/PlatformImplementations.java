package kotlin.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;
import kotlin.time.Clock;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0017¨\u0006\u0016"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "<init>", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "defaultPlatformRandom", "Lkotlin/random/Random;", "getSystemClock", "Lkotlin/time/Clock;", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PlatformImplementations {
    public void addSuppressed(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(cause, C0000.decode(new byte[]{5, 87, 76, 68, 6}, "f697c289181b", 0.0f));
        Intrinsics.checkNotNullParameter(exception, C0000.decode(new byte[]{85, 25, 82, 87, 71, 70, 15, 91, 8}, "0a1272f4feda", true));
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        Intrinsics.checkNotNullParameter(matchResult, C0000.decode(new byte[]{8, 87, 65, 1, 95, 102, 6, 67, 16, 90, 65}, "e65b74c0", 7));
        Intrinsics.checkNotNullParameter(name, C0000.decode(new byte[]{15, 83, 91, 93}, "a26895acbc99", 0.0f));
        throw new UnsupportedOperationException(C0000.decode(new byte[]{51, 6, 64, 19, 13, 87, 71, 81, 13, 81, 65, 4, 70, 14, 17, 66, 66, 24, 1, 79, 65, 13, 85, 12, 1, 18, 88, 75, 67, 88, 14, 23, 20, 18, 17, 66, 65, 87, 17, 66, 4, 7, 20, 14, 10, 18, 69, 80, 10, 69, 65, 19, 88, 0, 16, 84, 94, 74, 14, 24}, "ac4ad218c6", 0.0f));
    }

    public List<Throwable> getSuppressed(Throwable exception) {
        Object objInvoke;
        List<Throwable> listAsList;
        Intrinsics.checkNotNullParameter(exception, C0000.decode(new byte[]{84, 25, 81, 1, 68, 18, 90, 9, 11}, "1a2d4f3fe21431bb"));
        Method method = ReflectThrowable.getSuppressed;
        return (method == null || (objInvoke = method.invoke(exception, new Object[0])) == null || (listAsList = ArraysKt.asList((Throwable[]) objInvoke)) == null) ? CollectionsKt.emptyList() : listAsList;
    }

    public Clock getSystemClock() {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{80, 93, 16, 96, 31, 22, 17, 1, 85, 118, 91, 87, 7, 88, 70, 22, 13, 11, 77, 89, 83, 24, 10, 92, 18, 69, 7, 1, 24, 86, 86, 84, 8, 86, 2, 69, 10, 10, 24, 65, 95, 93, 68, 81, 7, 22, 0, 68, 104, 89, 86, 76, 2, 92, 20, 8, 44, 9, 72, 89, 82, 85, 1, 93, 18, 4, 17, 13, 87, 91, 68, 22}, "78d3feed85", true));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "<init>", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = new ReflectThrowable();
        public static final Method addSuppressed;
        public static final Method getSuppressed;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            Intrinsics.checkNotNull(methods);
            int length = methods.length;
            int i = 0;
            while (true) {
                method = null;
                if (i >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i];
                if (Intrinsics.areEqual(method2.getName(), C0000.decode(new byte[]{87, 87, 93, 103, 64, 68, 17, 20, 81, 17, 23, 86, 80}, "639454af4bd349"))) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, C0000.decode(new byte[]{3, 93, 65, 105, 5, 69, 5, 85, 80, 77, 1, 69, 48, 65, 69, 92, 23, 31, 74, 22, 27, 16}, "d859d7", 0.0f));
                    if (Intrinsics.areEqual(ArraysKt.singleOrNull(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i++;
            }
            addSuppressed = method2;
            for (Method method3 : methods) {
                if (Intrinsics.areEqual(method3.getName(), C0000.decode(new byte[]{80, 81, 65, 103, 19, 69, 68, 23, 3, 66, 75, 83, 86}, "7454f54ef1862716"))) {
                    method = method3;
                    break;
                }
            }
            getSuppressed = method;
        }

        private ReflectThrowable() {
        }
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }
}
