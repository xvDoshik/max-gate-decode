package androidx.work;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkerParameters {
    public ExecutorService mBackgroundExecutor;
    public UUID mId;
    public Data mInputData;
    public Dispatcher mWorkTaskExecutor;
    public WorkerFactory$1 mWorkerFactory;
}
