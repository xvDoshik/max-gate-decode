package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Job extends CoroutineContext.Element {

    public final class Key implements CoroutineContext.Key {
        public static final /* synthetic */ Key $$INSTANCE$1 = new Key();
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    void cancel(CancellationException cancellationException);

    boolean isActive();
}
