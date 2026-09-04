package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u001a6\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"withLock", "T", "Ljava/util/concurrent/locks/Lock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "read", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class LocksKt {
    private static final <T> T read(ReentrantReadWriteLock reentrantReadWriteLock, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(reentrantReadWriteLock, C0000.decode(new byte[]{94, 17, 81, 80, 18, 9}, "be99a7", true));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{5, 80, 67, 93, 86, 93}, "d374931669413dda", false));
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            return function0.invoke();
        } finally {
            lock.unlock();
        }
    }

    private static final <T> T withLock(Lock lock, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(lock, C0000.decode(new byte[]{12, 21, 88, 93, 21, 7}, "0a04f93c", false));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{5, 91, 18, 90, 13, 87}, "d8f3b9bbdb6984", true));
        lock.lock();
        try {
            return function0.invoke();
        } finally {
            lock.unlock();
        }
    }

    private static final <T> T write(ReentrantReadWriteLock reentrantReadWriteLock, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(reentrantReadWriteLock, C0000.decode(new byte[]{93, 64, 81, 80, 74, 88}, "a4999f64", 0.0f));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{2, 83, 67, 81, 94, 8}, "c0781feb966a54"));
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            T tInvoke = function0.invoke();
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            return tInvoke;
        } finally {
            while (i < readHoldCount) {
                lock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }
}
