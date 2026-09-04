package kotlinx.coroutines;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface ChildHandle extends DisposableHandle {
    boolean childCancelled(Throwable th);
}
