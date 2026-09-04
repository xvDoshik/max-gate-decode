package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class HandlerDispatcherKt {
    private static volatile Choreographer choreographer;

    static {
        Object failure;
        try {
            failure = new HandlerContext(asHandler(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = null;
        }
    }

    public static final Handler asHandler(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (Handler) Handler.class.getDeclaredMethod(C0000.decode(new byte[]{0, 20, 6, 84, 67, 6, 117, 16, 31, 10, 0}, "cfc57c4cfd", true), Looper.class).invoke(null, looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
