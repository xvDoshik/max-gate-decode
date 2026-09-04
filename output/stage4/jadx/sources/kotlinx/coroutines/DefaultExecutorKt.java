package kotlinx.coroutines;

import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class DefaultExecutorKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        String property;
        String strDecode = C0000.decode(new byte[]{95, 89, 69, 95, 15, 95, 73, 75, 87, 89, 67, 92, 19, 69, 88, 11, 81, 69, 31, 94, 7, 88, 95, 75, 80, 83, 93, 82, 31}, "4613f11e", 0.0f);
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            property = System.getProperty(strDecode);
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            DefaultExecutor defaultExecutor = DefaultExecutor.INSTANCE;
            return;
        }
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        HandlerContext handlerContext = MainDispatcherLoader.dispatcher;
        HandlerContext handlerContext2 = handlerContext.immediate;
        if (handlerContext == null) {
            DefaultExecutor defaultExecutor2 = DefaultExecutor.INSTANCE;
        }
    }
}
