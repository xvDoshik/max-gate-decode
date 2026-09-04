package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ThreadSafeHeap {
    public static final AtomicIntegerFieldUpdater _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, C0000.decode(new byte[]{58, 23, 11, 76, 85}, "edb600cb1cf7cb", 5));
    private volatile int _size;
}
