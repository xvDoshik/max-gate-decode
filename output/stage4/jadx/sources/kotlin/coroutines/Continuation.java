package kotlin.coroutines;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Continuation {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
