package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;
import kotlin.ExceptionsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkManagerInitializer implements Initializer {
    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{51, 70, 8, 125, 94, 69, 121, 13, 13, 64, 10, 81, 85, 94, 74, 6, 22}, "d4c0970c"));
    }

    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        SystemClock.get().getClass();
        Configuration configuration = new Configuration();
        synchronized (WorkManagerImpl.sLock) {
            try {
                WorkManagerImpl workManagerImpl = WorkManagerImpl.sDelegatedInstance;
                if (workManagerImpl != null && WorkManagerImpl.sDefaultInstance != null) {
                    throw new IllegalStateException(C0000.decode(new byte[]{51, 12, 65, 9, 40, 3, 87, 87, 2, 0, 22, 67, 90, 17, 69, 3, 85, 68, 0, 4, 0, 26, 19, 11, 11, 11, 77, 95, 4, 9, 13, 25, 86, 6, 75, 66, 25, 114, 12, 1, 68, 26, 92, 23, 69, 22, 75, 79, 69, 17, 11, 67, 90, 12, 12, 22, 80, 87, 9, 12, 30, 6, 19, 11, 17, 66, 84, 87, 11, 16, 5, 15, 95, 27, 69, 21, 80, 66, 13, 10, 17, 23, 19, 6, 12, 17, 88, 84, 9, 12, 10, 4, 19, 53, 10, 16, 82, 123, 4, 11, 5, 4, 86, 16, 44, 12, 80, 66, 12, 4, 8, 10, 73, 7, 23, 93, 25, 101, 0, 0, 68, 52, 92, 16, 14, 47, 88, 88, 4, 2, 1, 17, 16, 11, 11, 11, 77, 95, 4, 9, 13, 25, 86, 74, 38, 13, 87, 66, 0, 29, 16, 79, 19, 33, 10, 12, 95, 95, 2, 16, 22, 2, 71, 11, 10, 12, 16, 22, 10, 23, 68, 23, 91, 7, 69, 1, 85, 87, 22, 22, 68, 15, 86, 20, 0, 14, 25, 124, 4, 19, 5, 7, 92, 1, 69, 4, 86, 68, 69, 8, 11, 17, 86, 66, 12, 12, 95, 89, 23, 8, 5, 23, 90, 13, 11, 76}, "dc3beb96ee", 6));
                }
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (WorkManagerImpl.sDefaultInstance == null) {
                        WorkManagerImpl.sDefaultInstance = ExceptionsKt.createWorkManager(applicationContext, configuration);
                    }
                    WorkManagerImpl.sDelegatedInstance = WorkManagerImpl.sDefaultInstance;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return WorkManagerImpl.getInstance$1(context);
    }

    @Override // androidx.startup.Initializer
    public final void dependencies() {
        List list = Collections.EMPTY_LIST;
    }
}
