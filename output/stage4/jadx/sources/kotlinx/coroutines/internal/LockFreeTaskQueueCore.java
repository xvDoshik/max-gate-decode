package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class LockFreeTaskQueueCore {
    private volatile Object _next;
    private volatile long _state;
    public final AtomicReferenceArray array;
    public final int capacity;
    public final int mask;
    public final boolean singleConsumer;
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, C0000.decode(new byte[]{102, 15, 82, 77, 77}, "9a759d1c138c4da9", true));
    public static final AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, C0000.decode(new byte[]{102, 69, 69, 85, 21, 4}, "9614aac326"));
    public static final Symbol REMOVE_FROZEN = new Symbol(C0000.decode(new byte[]{102, 32, 122, 119, 55, 125, 109, 32, 98, 120, 99, 118, 42}, "4e78a82f0793d4", false), 0);

    public final class Placeholder {
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.capacity = i;
        this.singleConsumer = z;
        int i2 = i - 1;
        this.mask = i2;
        this.array = new AtomicReferenceArray(i);
        String strDecode = C0000.decode(new byte[]{122, 91, 82, 5, 15, 70, 3, 81, 15, 92, 93, 85, 72}, "937fdfe0f081f72e", 7);
        if (i2 > 1073741823) {
            throw new IllegalStateException(strDecode);
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException(strDecode);
        }
    }

    public final int addLast(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.mask;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            boolean z = this.singleConsumer;
            AtomicReferenceArray atomicReferenceArray = this.array;
            if (z || atomicReferenceArray.get(i2 & i3) == null) {
                if (_state$FU.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                    atomicReferenceArray.set(i2 & i3, obj);
                    LockFreeTaskQueueCore next = this;
                    while ((atomicLongFieldUpdater.get(next) & 1152921504606846976L) != 0) {
                        next = next.next();
                        AtomicReferenceArray atomicReferenceArray2 = next.array;
                        int i4 = next.mask & i2;
                        Object obj2 = atomicReferenceArray2.get(i4);
                        if ((obj2 instanceof Placeholder) && ((Placeholder) obj2).index == i2) {
                            atomicReferenceArray2.set(i4, obj);
                        } else {
                            next = null;
                        }
                        if (next == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i5 = this.capacity;
                if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean close() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = _state$FU;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    public final LockFreeTaskQueueCore next() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        LockFreeTaskQueueCore lockFreeTaskQueueCore;
        while (true) {
            atomicLongFieldUpdater = _state$FU;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                lockFreeTaskQueueCore = this;
                break;
            }
            long j2 = 1152921504606846976L | j;
            lockFreeTaskQueueCore = this;
            if (atomicLongFieldUpdater.compareAndSet(lockFreeTaskQueueCore, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore2 != null) {
                return lockFreeTaskQueueCore2;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore3 = new LockFreeTaskQueueCore(lockFreeTaskQueueCore.capacity * 2, lockFreeTaskQueueCore.singleConsumer);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = lockFreeTaskQueueCore.mask;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object placeholder = lockFreeTaskQueueCore.array.get(i4);
                if (placeholder == null) {
                    placeholder = new Placeholder(i);
                }
                lockFreeTaskQueueCore3.array.set(lockFreeTaskQueueCore3.mask & i, placeholder);
                i++;
            }
            atomicLongFieldUpdater.set(lockFreeTaskQueueCore3, (-1152921504606846977L) & j);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueueCore3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object removeFirstOrNull() {
        LockFreeTaskQueueCore next = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
            long j = atomicLongFieldUpdater.get(next);
            if ((j & 1152921504606846976L) != 0) {
                return REMOVE_FROZEN;
            }
            int i = (int) (j & 1073741823);
            int i2 = next.mask;
            int i3 = i & i2;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) != i3) {
                AtomicReferenceArray atomicReferenceArray = next.array;
                Object obj = atomicReferenceArray.get(i3);
                boolean z = next.singleConsumer;
                if (obj == null) {
                    if (z) {
                    }
                } else if (!(obj instanceof Placeholder)) {
                    long j2 = (i + 1) & 1073741823;
                    if (_state$FU.compareAndSet(next, j, (j & (-1073741824)) | j2)) {
                        atomicReferenceArray.set(i3, null);
                        return obj;
                    }
                    next = this;
                    if (z) {
                        while (true) {
                            long j3 = atomicLongFieldUpdater.get(next);
                            int i4 = (int) (j3 & 1073741823);
                            if ((j3 & 1152921504606846976L) != 0) {
                                next = next.next();
                            } else {
                                LockFreeTaskQueueCore lockFreeTaskQueueCore = next;
                                if (_state$FU.compareAndSet(lockFreeTaskQueueCore, j3, (j3 & (-1073741824)) | j2)) {
                                    lockFreeTaskQueueCore.array.set(i4 & lockFreeTaskQueueCore.mask, null);
                                    next = null;
                                } else {
                                    next = lockFreeTaskQueueCore;
                                }
                            }
                            if (next == null) {
                                return obj;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
}
