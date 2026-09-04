package kotlinx.coroutines;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class StandaloneCoroutine extends AbstractCoroutine {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean handleJobException(Throwable th) {
        BuildersKt.handleCoroutineException(this.context, th);
        return true;
    }
}
