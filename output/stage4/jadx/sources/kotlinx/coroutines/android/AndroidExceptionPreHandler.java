package kotlinx.coroutines.android;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineContext.Element {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(Job.Key.$$INSTANCE$1);
        this._preHandler = this;
    }

    public final void handleException(Throwable th) {
        Method declaredMethod;
        if (Build.VERSION.SDK_INT < 28) {
            Object obj = this._preHandler;
            if (obj != this) {
                declaredMethod = (Method) obj;
            } else {
                try {
                    declaredMethod = Thread.class.getDeclaredMethod(C0000.decode(new byte[]{4, 85, 77, 55, 13, 81, 85, 68, 4, 88, 77, 39, 27, 81, 81, 65, 23, 89, 86, 12, 51, 64, 81, 121, 2, 94, 93, 14, 6, 64}, "c09bc241", 5), null);
                    if (!Modifier.isPublic(declaredMethod.getModifiers()) || !Modifier.isStatic(declaredMethod.getModifiers())) {
                        declaredMethod = null;
                    }
                } catch (Throwable unused) {
                }
                this._preHandler = declaredMethod;
            }
            Object objInvoke = declaredMethod != null ? declaredMethod.invoke(null, null) : null;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
