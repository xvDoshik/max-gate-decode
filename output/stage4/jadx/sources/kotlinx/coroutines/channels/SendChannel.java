package kotlinx.coroutines.channels;

import kotlin.collections.IndexedValue;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface SendChannel {
    Object send(IndexedValue indexedValue, CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1);

    /* JADX INFO: renamed from: trySend-JP2dKIU */
    Object mo17trySendJP2dKIU(Object obj);
}
