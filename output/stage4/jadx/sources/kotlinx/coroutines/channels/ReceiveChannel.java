package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface ReceiveChannel {
    void cancel(CancellationException cancellationException);

    /* JADX INFO: renamed from: receiveCatching-JP2dKIU */
    Object mo14receiveCatchingJP2dKIU(CombineKt$combineInternal$2 combineKt$combineInternal$2);

    /* JADX INFO: renamed from: tryReceive-PtdJZtk */
    Object mo16tryReceivePtdJZtk();
}
