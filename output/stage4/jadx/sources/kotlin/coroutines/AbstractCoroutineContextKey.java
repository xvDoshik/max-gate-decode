package kotlin.coroutines;

import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AbstractCoroutineContextKey implements CoroutineContext.Key {
    public abstract CoroutineContext.Element tryCast$kotlin_stdlib(CoroutineDispatcher coroutineDispatcher);
}
