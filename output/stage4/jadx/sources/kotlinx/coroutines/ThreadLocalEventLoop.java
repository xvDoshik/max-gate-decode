package kotlinx.coroutines;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ThreadLocalEventLoop {
    public static final ThreadLocal ref = new ThreadLocal();

    public static EventLoopImplPlatform getEventLoop$kotlinx_coroutines_core() {
        ThreadLocal threadLocal = ref;
        EventLoopImplPlatform eventLoopImplPlatform = (EventLoopImplPlatform) threadLocal.get();
        if (eventLoopImplPlatform != null) {
            return eventLoopImplPlatform;
        }
        BlockingEventLoop blockingEventLoop = new BlockingEventLoop(Thread.currentThread());
        threadLocal.set(blockingEventLoop);
        return blockingEventLoop;
    }
}
