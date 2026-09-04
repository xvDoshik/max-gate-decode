package kotlinx.coroutines;

import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Waiter {
    void invokeOnCancellation(Segment segment, int i);
}
