package androidx.work.impl.utils;

import androidx.work.SystemClock;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.WorkSpecDao_Impl;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkForegroundUpdater {
    public final ForegroundProcessor mForegroundProcessor;
    public final Dispatcher mTaskExecutor;
    public final WorkSpecDao_Impl mWorkSpecDao;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{50, 125, 113, 5, 52, 22, 6, 84, 69, 0, 69}, "e07bafb51e7d779a", 0.0f));
    }

    public WorkForegroundUpdater(WorkDatabase workDatabase, Processor processor, Dispatcher dispatcher) {
        this.mForegroundProcessor = processor;
        this.mTaskExecutor = dispatcher;
        this.mWorkSpecDao = workDatabase.workSpecDao();
    }
}
