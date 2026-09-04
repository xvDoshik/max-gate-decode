package androidx.work;

import android.content.Context;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkerFactory$1 {
    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{102, 89, 19, 90, 1, 65, 32, 5, 86, 71, 93, 69, 27}, "16a1d3fd5327b2", 4));
    }

    public static ListenableWorker createWorkerWithDefaultFallback(Context context, String str, WorkerParameters workerParameters) {
        Class clsAsSubclass;
        ListenableWorker listenableWorker = null;
        try {
            clsAsSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
        } catch (Throwable unused) {
            SystemClock.get().getClass();
            clsAsSubclass = null;
        }
        if (clsAsSubclass != null) {
            try {
                listenableWorker = (ListenableWorker) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable unused2) {
                SystemClock.get().getClass();
            }
        }
        if (listenableWorker == null || !listenableWorker.mUsed) {
            return listenableWorker;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{49, 86, 16, 90, 80, 64, 32, 88, 1, 69, 90, 64, 31, 25, 74}, "f9b152", 6) + WorkerFactory$1.class.getName() + C0000.decode(new byte[]{28, 69, 23, 87, 68, 71, 23, 11, 4, 81, 21, 4, 11, 18, 89, 92, 22, 17, 0, 91, 86, 0, 69, 93, 86, 18, 4, 69, 45, 92, 70, 17, 0, 92, 81, 80, 9, 0, 54, 90, 71, 14, 0, 64, 16, 26}, "5ee202eea5", 0.0f) + str + C0000.decode(new byte[]{26, 25, 20, 95, 12, 82, 95, 70, 91, 82, 64, 25, 2, 91, 23, 84, 86, 2, 74, 19, 81, 92, 6, 89, 69, 88, 89, 16, 92, 88, 86, 93, 77, 23, 6, 67, 82, 7, 71, 86, 100, 86, 17, 92, 0, 67, 31, 79, 19, 94, 70, 74, 23, 23, 4, 93, 64, 7, 74, 64, 19, 75, 6, 67, 16, 67, 89, 70, 82, 19, 93, 92, 20, 23, 12, 95, 68, 18, 82, 93, 80, 92, 67, 88, 3, 17, 86, 70, 127, 90, 64, 77, 6, 89, 4, 83, 91, 3, 100, 92, 65, 82, 6, 69, 75}, "39c7e17f33", true));
    }
}
