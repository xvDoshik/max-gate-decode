package androidx.arch.core.executor;

import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ArchTaskExecutor extends CloseableKt {
    public static final ArchTaskExecutor$$ExternalSyntheticLambda0 sIOThreadExecutor = new ArchTaskExecutor$$ExternalSyntheticLambda0(0);
    public static volatile ArchTaskExecutor sInstance;
    public final DefaultTaskExecutor mDelegate = new DefaultTaskExecutor();

    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (sInstance == null) {
                    sInstance = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sInstance;
    }
}
