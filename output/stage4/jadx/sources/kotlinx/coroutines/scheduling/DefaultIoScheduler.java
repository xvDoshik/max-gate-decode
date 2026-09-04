package kotlinx.coroutines.scheduling;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {
    public static final DefaultIoScheduler INSTANCE = new DefaultIoScheduler();

    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final CoroutineDispatcher f2default;

    static {
        CoroutineDispatcher limitedDispatcher = UnlimitedIoScheduler.INSTANCE;
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        if (64 >= i) {
            i = 64;
        }
        int iSystemProp$default = AtomicKt.systemProp$default(C0000.decode(new byte[]{9, 11, 22, 95, 93, 89, 76, 26, 1, 11, 16, 92, 65, 67, 93, 90, 7, 23, 76, 90, 91, 25, 68, 85, 16, 5, 14, 95, 81, 91, 93, 71, 15}, "bdb34744", 2), i, 12);
        String strDecode = C0000.decode(new byte[]{125, 65, 22, 4, 90, 69, 7, 82, 24, 73, 9, 18, 80, 69, 11, 64, 93, 25, 22, 0, 75, 80, 14, 90, 93, 85, 15, 18, 84, 17, 14, 83, 78, 92, 10, 77, 25, 83, 23, 66, 24, 94, 9, 21, 25}, "89fa91b6");
        if (iSystemProp$default < 1) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(strDecode, iSystemProp$default).toString());
        }
        if (iSystemProp$default < TasksKt.MAX_POOL_SIZE) {
            if (iSystemProp$default < 1) {
                throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(strDecode, iSystemProp$default).toString());
            }
            limitedDispatcher = new LimitedDispatcher(iSystemProp$default);
        }
        f2default = limitedDispatcher;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException(C0000.decode(new byte[]{39, 84, 93, 88, 94, 16, 68, 87, 86, 22, 88, 10, 18, 90, 88, 83, 85, 68, 11, 91, 19, 114, 88, 23, 20, 84, 71, 85, 89, 1, 22, 70, 29, 127, 126}, "d5361d", true));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f2default.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        f2default.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return C0000.decode(new byte[]{119, 80, 74, 17, 82, 71, 84, 9, 82, 19, 71, 74, 122, 118}, "399a337a7a4d", 5);
    }
}
