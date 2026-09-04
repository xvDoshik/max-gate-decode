package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "<init>", "()V", "notOnJava9", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "cache", "getModuleName", "", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "buildCache", "Cache", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ModuleNameRetriever {
    private static Cache cache;
    public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
    private static final Cache notOnJava9 = new Cache(null, null, null);

    private final Cache buildCache(BaseContinuationImpl continuation) {
        try {
            Cache cache2 = new Cache(Class.class.getDeclaredMethod(C0000.decode(new byte[]{94, 83, 68, 47, 11, 87, 19, 95, 82}, "960bd3f374", 7), new Class[0]), continuation.getClass().getClassLoader().loadClass(C0000.decode(new byte[]{90, 89, 68, 7, 79, 91, 89, 11, 84, 23, 121, 95, 6, 67, 92, 93}, "082fa78e3940b6", false)).getDeclaredMethod(C0000.decode(new byte[]{1, 3, 71, 37, 6, 17, 2, 68, 8, 21, 70, 90, 19}, "ff3acba6ae25a4"), new Class[0]), continuation.getClass().getClassLoader().loadClass(C0000.decode(new byte[]{94, 7, 19, 3, 29, 8, 7, 95, 83, 72, 8, 13, 87, 17, 10, 84, 26, 43, 10, 6, 70, 8, 3, 117, 81, 21, 6, 16, 90, 20, 18, 94, 70}, "4feb3df1", 0.0f)).getDeclaredMethod(C0000.decode(new byte[]{87, 0, 93, 0}, "9a0e4e6d30", 0.0f), new Class[0]));
            cache = cache2;
            return cache2;
        } catch (Exception unused) {
            Cache cache3 = notOnJava9;
            cache = cache3;
            return cache3;
        }
    }

    public final String getModuleName(BaseContinuationImpl continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{82, 90, 10, 71, 93, 13, 68, 84, 16, 90, 91, 13}, "15d34c", 7));
        Cache cacheBuildCache = cache;
        if (cacheBuildCache == null) {
            cacheBuildCache = buildCache(continuation);
        }
        if (cacheBuildCache != notOnJava9 && (method = cacheBuildCache.getModuleMethod) != null && (objInvoke = method.invoke(continuation.getClass(), new Object[0])) != null && (method2 = cacheBuildCache.getDescriptorMethod) != null && (objInvoke2 = method2.invoke(objInvoke, new Object[0])) != null) {
            Method method3 = cacheBuildCache.nameMethod;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
            if (objInvoke3 instanceof String) {
                return (String) objInvoke3;
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: DebugMetadata.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Cache {
        public final Method getDescriptorMethod;
        public final Method getModuleMethod;
        public final Method nameMethod;

        public Cache(Method method, Method method2, Method method3) {
            this.getModuleMethod = method;
            this.getDescriptorMethod = method2;
            this.nameMethod = method3;
        }
    }

    private ModuleNameRetriever() {
    }
}
