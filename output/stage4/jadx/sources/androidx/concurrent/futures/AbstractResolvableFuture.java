package androidx.concurrent.futures;

import androidx.work.impl.utils.futures.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.ExceptionsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AbstractResolvableFuture implements ListenableFuture {
    public static final ExceptionsKt ATOMIC_HELPER;
    public static final Object NULL;
    public volatile Listener listeners;
    public volatile Object value;
    public volatile Waiter waiters;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty(C0000.decode(new byte[]{94, 77, 85, 20, 7, 77, 84, 94, 89, 5, 76, 74, 70, 7, 8, 23, 25, 86, 82, 8, 92, 74, 85, 22, 3, 60, 84, 80, 89, 5, 92, 84, 88, 3, 18, 10, 88, 95, 104, 5, 88, 77, 71, 7}, "984bfc717f"), C0000.decode(new byte[]{84, 84, 15, 75, 3}, "25c8f773", 0)));
    public static final Logger log = Logger.getLogger(AbstractResolvableFuture.class.getName());

    public final class Cancellation {
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public final Throwable cause;
        public final boolean wasInterrupted;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                CAUSELESS_CANCELLED = null;
                CAUSELESS_INTERRUPTED = null;
            } else {
                CAUSELESS_CANCELLED = new Cancellation(null, false);
                CAUSELESS_INTERRUPTED = new Cancellation(null, true);
            }
        }

        public Cancellation(Throwable th, boolean z) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    public final class Failure {
        public final Throwable exception;

        static {
            new Failure(new AbstractFuture.Failure.AnonymousClass1(C0000.decode(new byte[]{32, 81, 80, 88, 22, 64, 85, 17, 89, 81, 5, 69, 75, 70, 6, 86, 16, 70, 94, 91, 10, 85, 25, 64, 17, 75, 89, 95, 81, 18, 18, 95, 25, 82, 10, 92, 89, 66, 94, 18, 7, 16, 95, 65, 23, 71, 66, 84, 24}, "f094c20162", false), 1));
        }

        public Failure(Throwable th) {
            boolean z = AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES;
            th.getClass();
            this.exception = th;
        }
    }

    public final class Listener {
        public static final Listener TOMBSTONE = new Listener(null, null);
        public final Executor executor;
        public Listener next;
        public final Runnable task;

        public Listener(Runnable runnable, Executor executor) {
            this.task = runnable;
            this.executor = executor;
        }
    }

    public final class SafeAtomicHelper extends ExceptionsKt {
        public final AtomicReferenceFieldUpdater listenersUpdater;
        public final AtomicReferenceFieldUpdater valueUpdater;
        public final AtomicReferenceFieldUpdater waiterNextUpdater;
        public final AtomicReferenceFieldUpdater waiterThreadUpdater;
        public final AtomicReferenceFieldUpdater waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        @Override // kotlin.ExceptionsKt
        public final boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, Listener listener, Listener listener2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.listenersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, listener, listener2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == listener);
            return false;
        }

        @Override // kotlin.ExceptionsKt
        public final boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.valueUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == obj);
            return false;
        }

        @Override // kotlin.ExceptionsKt
        public final boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.waitersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, waiter, waiter2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == waiter);
            return false;
        }

        @Override // kotlin.ExceptionsKt
        public final void putNext(Waiter waiter, Waiter waiter2) {
            this.waiterNextUpdater.lazySet(waiter, waiter2);
        }

        @Override // kotlin.ExceptionsKt
        public final void putThread(Waiter waiter, Thread thread) {
            this.waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    public final class SynchronizedHelper extends ExceptionsKt {
        @Override // kotlin.ExceptionsKt
        public final boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.listeners != listener) {
                        return false;
                    }
                    abstractResolvableFuture.listeners = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlin.ExceptionsKt
        public final boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.value != obj) {
                        return false;
                    }
                    abstractResolvableFuture.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlin.ExceptionsKt
        public final boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                try {
                    if (abstractResolvableFuture.waiters != waiter) {
                        return false;
                    }
                    abstractResolvableFuture.waiters = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlin.ExceptionsKt
        public final void putNext(Waiter waiter, Waiter waiter2) {
            waiter.next = waiter2;
        }

        @Override // kotlin.ExceptionsKt
        public final void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }
    }

    public final class Waiter {
        public static final Waiter TOMBSTONE = new Waiter();
        public volatile Waiter next;
        public volatile Thread thread;

        public Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    static {
        ExceptionsKt synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, C0000.decode(new byte[]{70, 92, 64, 86, 2, 0}, "2423cde85c29", 0.0f)), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, C0000.decode(new byte[]{90, 83, 26, 65}, "46b561", 0)), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, C0000.decode(new byte[]{66, 7, 12, 23, 83, 68, 69}, "5fec6664785e", 0.0f)), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, C0000.decode(new byte[]{8, 13, 64, 67, 93, 8, 93, 75, 69}, "dd378f8962d2", 1)), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, C0000.decode(new byte[]{71, 4, 93, 23, 80}, "1e1b505aea23", false)));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = synchronizedHelper;
        if (th != null) {
            log.log(Level.SEVERE, C0000.decode(new byte[]{100, 84, 5, 1, 35, 70, 88, 92, 15, 6, 112, 86, 94, 22, 6, 74, 23, 92, 16, 68, 0, 64, 88, 90, 3, 11, 25}, "75cdb271fe832fc8", true), th);
        }
        NULL = new Object();
    }

    public static void complete(AbstractResolvableFuture abstractResolvableFuture) {
        Waiter waiter;
        Listener listener;
        Listener listener2;
        Listener listener3;
        do {
            waiter = abstractResolvableFuture.waiters;
        } while (!ATOMIC_HELPER.casWaiters(abstractResolvableFuture, waiter, Waiter.TOMBSTONE));
        while (true) {
            listener = null;
            if (waiter == null) {
                break;
            }
            Thread thread = waiter.thread;
            if (thread != null) {
                waiter.thread = null;
                LockSupport.unpark(thread);
            }
            waiter = waiter.next;
        }
        abstractResolvableFuture.afterDone();
        do {
            listener2 = abstractResolvableFuture.listeners;
        } while (!ATOMIC_HELPER.casListeners(abstractResolvableFuture, listener2, Listener.TOMBSTONE));
        while (true) {
            listener3 = listener;
            listener = listener2;
            if (listener == null) {
                break;
            }
            listener2 = listener.next;
            listener.next = listener3;
        }
        while (listener3 != null) {
            Listener listener4 = listener3.next;
            executeListener(listener3.task, listener3.executor);
            listener3 = listener4;
        }
    }

    public static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, C0000.decode(new byte[]{96, 67, 13, 71, 81, 90, 87, 115, 27, 80, 93, 71, 70, 95, 12, 93, 24, 64, 90, 95, 15, 86, 24, 82, 74, 83, 0, 70, 76, 94, 92, 81, 67, 65, 77, 89, 92, 87, 1, 95, 93, 23}, "26c387") + runnable + C0000.decode(new byte[]{19, 19, 93, 21, 10, 65, 92, 25, 86, 7, 65, 21, 13, 19, 25}, "3d4aba9a") + executor, (Throwable) e);
        }
    }

    public static Object getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            Throwable th = ((Cancellation) obj).cause;
            CancellationException cancellationException = new CancellationException(C0000.decode(new byte[]{48, 88, 71, 14, 67, 20, 86, 22, 25, 81, 0, 93, 0, 4, 91, 15, 1, 93, 26}, "d94ecc7e92a3ca7c"));
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).exception);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    public static Object getUninterruptibly(AbstractResolvableFuture abstractResolvableFuture) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = abstractResolvableFuture.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void addDoneString(StringBuilder sb) {
        String strDecode = C0000.decode(new byte[]{104}, "5d44fee4555c98", 0.0f);
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append(C0000.decode(new byte[]{48, 99, 117, 39, 117, 97, 96, 78, 16, 64, 6, 69, 67, 8, 68, 15, 104}, "c66d023b02", true));
            sb.append(uninterruptibly == this ? C0000.decode(new byte[]{64, 91, 95, 66, 67, 7, 76, 65, 65, 65, 83}, "4361ca95", 4) : String.valueOf(uninterruptibly));
            sb.append(strDecode);
        } catch (CancellationException unused) {
            sb.append(C0000.decode(new byte[]{117, 118, 121, 112, 112, 120, 125, 116, 39}, "67735411c6ba", false));
        } catch (RuntimeException e) {
            sb.append(C0000.decode(new byte[]{48, 122, 122, 120, 127, 111, 45, 25, 17, 0, 4, 65, 66, 83, 13, 99}, "e41608c51c", 7));
            sb.append(e.getClass());
            sb.append(C0000.decode(new byte[]{67, 16, 90, 65, 9, 64, 15, 66, 2, 67, 12, 9, 18, 84, 3, 67, 73, 75, 57}, "cd23f7abd1", 0.0f));
        } catch (ExecutionException e2) {
            sb.append(C0000.decode(new byte[]{112, 112, 112, 47, 52, 54, 119, 26, 67, 83, 87, 68, 74, 6, 92, 63}, "619cad26c0", 0.0f));
            sb.append(e2.getCause());
            sb.append(strDecode);
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        executor.getClass();
        Listener listener = this.listeners;
        Listener listener2 = Listener.TOMBSTONE;
        if (listener != listener2) {
            Listener listener3 = new Listener(runnable, executor);
            do {
                listener3.next = listener;
                if (ATOMIC_HELPER.casListeners(this, listener, listener3)) {
                    return;
                } else {
                    listener = this.listeners;
                }
            } while (listener != listener2);
        }
        executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Cancellation cancellation;
        Object obj = this.value;
        if (obj == null) {
            if (GENERATE_CANCELLATION_CAUSES) {
                cancellation = new Cancellation(new CancellationException(C0000.decode(new byte[]{116, 70, 68, 64, 16, 80, 79, 91, 80, 92, 81, 86, 92, 29, 75, 21, 22, 89, 66, 18, 81, 82, 92, 89, 7, 81, 79}, "2305b5a812", true)), z);
            } else {
                cancellation = z ? Cancellation.CAUSELESS_INTERRUPTED : Cancellation.CAUSELESS_CANCELLED;
            }
            if (ATOMIC_HELPER.casValue(this, obj, cancellation)) {
                complete(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Waiter waiter = Waiter.TOMBSTONE;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if (obj != null) {
            return getDoneValue(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter2 = this.waiters;
            if (waiter2 != waiter) {
                Waiter waiter3 = new Waiter();
                while (true) {
                    ExceptionsKt exceptionsKt = ATOMIC_HELPER;
                    exceptionsKt.putNext(waiter3, waiter2);
                    if (exceptionsKt.casWaiters(this, waiter2, waiter3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(waiter3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if (obj2 != null) {
                                return getDoneValue(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        removeWaiter(waiter3);
                        break;
                    }
                    waiter2 = this.waiters;
                    if (waiter2 == waiter) {
                    }
                }
            }
            return getDoneValue(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if (obj3 != null) {
                return getDoneValue(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{99, 4, 13, 21, 85, 82, 22}, "4eda066a8b64"));
        sb.append(j);
        String strDecode = C0000.decode(new byte[]{16}, "0c1804993c", true);
        sb.append(strDecode);
        sb.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sb.toString();
        if (nanos + 1000 < 0) {
            String str = string3 + C0000.decode(new byte[]{19, 24, 18, 85, 77, 75, 19}, "30b988", false);
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str2 = str + jConvert + strDecode + lowerCase;
                if (z) {
                    str2 = str2 + C0000.decode(new byte[]{28}, "05ef46cbf7");
                }
                str = str2 + strDecode;
            }
            if (z) {
                str = str + nanos2 + C0000.decode(new byte[]{18, 8, 4, 90, 94, 68, 81, 80, 13, 93, 83, 75, 21}, "2fe41743b37852", 0.0f);
            }
            string3 = str + C0000.decode(new byte[]{81, 6, 89, 3, 78, 76}, "5c5b7e", true);
        }
        if (isDone()) {
            throw new TimeoutException(string3 + C0000.decode(new byte[]{18, 80, 19, 67, 67, 94, 68, 21, 64, 19, 87, 18, 5, 88, 14, 72, 93, 4, 65, 4, 86, 18, 7, 68, 67, 76, 88, 12, 80, 14, 71, 70, 70, 82, 27, 72, 88, 19, 80, 5}, "22f7c81a5a", false));
        }
        throw new TimeoutException(string3 + C0000.decode(new byte[]{21, 2, 87, 69, 20}, "5d874851fb5920", true) + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.value != null;
    }

    public final void removeWaiter(Waiter waiter) {
        waiter.thread = null;
        while (true) {
            Waiter waiter2 = this.waiters;
            if (waiter2 == Waiter.TOMBSTONE) {
                return;
            }
            Waiter waiter3 = null;
            while (waiter2 != null) {
                Waiter waiter4 = waiter2.next;
                if (waiter2.thread != null) {
                    waiter3 = waiter2;
                } else if (waiter3 != null) {
                    waiter3.next = waiter4;
                    if (waiter3.thread == null) {
                    }
                } else if (!ATOMIC_HELPER.casWaiters(this, waiter2, waiter4)) {
                }
                waiter2 = waiter4;
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(C0000.decode(new byte[]{109, 21, 68, 81, 23, 22, 64, 91}, "6f00cc3f6f"));
        boolean z = this.value instanceof Cancellation;
        String strDecode = C0000.decode(new byte[]{111}, "2288bd88", true);
        if (z) {
            sb.append(C0000.decode(new byte[]{118, 118, 123, 117, 119, 127, 121, 114, 113}, "575623"));
        } else if (isDone()) {
            addDoneString(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = C0000.decode(new byte[]{67, 85, 85, 7, 10, 13, 94, 10, 95, 65, 83, 84, 88, 84, 78, 13, 106}, "108fcc7d8a714570", 0.0f) + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + C0000.decode(new byte[]{16, 94, 16, 105}, "03c44150");
                } else {
                    str = null;
                }
            } catch (RuntimeException e) {
                str = C0000.decode(new byte[]{113, 64, 0, 0, 65, 21, 93, 87, 13, 69, 69, 9, 70, 87, 20, 11, 17, 7, 70, 87, 14, 69, 88, 12, 68, 84, 6, 8, 84, 15, 64, 89, 23, 12, 94, 15, 14, 24}, "48ce1a", 0.0f) + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append(C0000.decode(new byte[]{102, 33, 45, 116, 121, 47, 113, 72, 67, 89, 94, 7, 89, 89, 56}, "6dc00a"));
                sb.append(str);
                sb.append(strDecode);
            } else if (isDone()) {
                addDoneString(sb);
            } else {
                sb.append(C0000.decode(new byte[]{53, 36, 124, 125, 124, 44, 126}, "ea295b9a0a0219", 0.0f));
            }
        }
        sb.append(strDecode);
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        Waiter waiter = Waiter.TOMBSTONE;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if (obj2 != null) {
                return getDoneValue(obj2);
            }
            Waiter waiter2 = this.waiters;
            if (waiter2 != waiter) {
                Waiter waiter3 = new Waiter();
                do {
                    ExceptionsKt exceptionsKt = ATOMIC_HELPER;
                    exceptionsKt.putNext(waiter3, waiter2);
                    if (exceptionsKt.casWaiters(this, waiter2, waiter3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return getDoneValue(obj);
                    }
                    waiter2 = this.waiters;
                } while (waiter2 != waiter);
            }
            return getDoneValue(this.value);
        }
        throw new InterruptedException();
    }
}
