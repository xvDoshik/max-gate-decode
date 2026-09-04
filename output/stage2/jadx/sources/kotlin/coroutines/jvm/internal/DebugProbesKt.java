package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001¨\u0006\b"}, d2 = {"probeCoroutineCreated", "Lkotlin/coroutines/Continuation;", "T", "completion", "probeCoroutineResumed", "", "frame", "probeCoroutineSuspended", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DebugProbesKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> probeCoroutineCreated(Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{86, 90, 15, 69, 89, 3, 65, 92, 13, 91}, "55b55f", true));
        return continuation;
    }

    public static final void probeCoroutineResumed(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{94, 69, 86, 94, 0}, "8773ea", 1));
    }

    public static final void probeCoroutineSuspended(Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, C0000.decode(new byte[]{94, 67, 2, 8, 81}, "81ce4a22623069", 0.0f));
    }
}
