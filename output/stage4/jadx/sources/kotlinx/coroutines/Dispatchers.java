package kotlinx.coroutines;

import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Dispatchers {
    public static final DefaultScheduler Default = DefaultScheduler.INSTANCE;
    public static final DefaultIoScheduler IO = DefaultIoScheduler.INSTANCE;
}
