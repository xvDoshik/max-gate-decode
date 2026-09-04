package androidx.work.impl.utils.futures;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
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
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AbstractFuture implements ListenableFuture {
    public static final CloseableKt ATOMIC_HELPER;
    public static final Object NULL;
    public volatile Listener listeners;
    public volatile Object value;
    public volatile Waiter waiters;
    public static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty(C0000.decode(new byte[]{6, 70, 81, 70, 89, 28, 81, 94, 88, 84, 64, 19, 19, 92, 15, 71, 30, 87, 93, 92, 87, 67, 87, 67, 80, 62, 2, 88, 15, 80, 85, 92, 84, 83, 70, 88, 89, 89, 106, 2, 0, 76, 18, 86}, "a3008221675aa9"), C0000.decode(new byte[]{3, 83, 92, 64, 87}, "e2032d5e2c891d56", 7)));
    public static final Logger log = Logger.getLogger(AbstractFuture.class.getName());

    public final class Cancellation {
        public static final Cancellation CAUSELESS_CANCELLED;
        public static final Cancellation CAUSELESS_INTERRUPTED;
        public final Throwable cause;
        public final boolean wasInterrupted;

        static {
            if (AbstractFuture.GENERATE_CANCELLATION_CAUSES) {
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
        public static final Failure FALLBACK_INSTANCE = new Failure(new AnonymousClass1(C0000.decode(new byte[]{36, 4, 90, 90, 69, 69, 87, 24, 88, 7, 6, 67, 19, 66, 7, 1, 19, 65, 88, 94, 94, 93, 23, 16, 23, 79, 8, 94, 5, 69, 71, 89, 16, 81, 91, 86, 94, 23, 13, 22, 0, 16, 4, 16, 71, 67, 66, 82, 28}, "be3607287de6a0"), 0));
        public final Throwable exception;

        /* JADX INFO: renamed from: androidx.work.impl.utils.futures.AbstractFuture$Failure$1, reason: invalid class name */
        public final class AnonymousClass1 extends Throwable {
            public final /* synthetic */ int $r8$classId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ AnonymousClass1(String str, int i) {
                super(str);
                this.$r8$classId = i;
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                int i = this.$r8$classId;
                synchronized (this) {
                    switch (i) {
                        case 0:
                            break;
                        default:
                            break;
                    }
                    return this;
                }
            }
        }

        public Failure(Throwable th) {
            boolean z = AbstractFuture.GENERATE_CANCELLATION_CAUSES;
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

    public final class SafeAtomicHelper extends CloseableKt {
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

        @Override // kotlin.io.CloseableKt
        public final boolean casListeners(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.listenersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, listener, listener2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == listener);
            return false;
        }

        @Override // kotlin.io.CloseableKt
        public final boolean casValue(AbstractFuture abstractFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.valueUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == obj);
            return false;
        }

        @Override // kotlin.io.CloseableKt
        public final boolean casWaiters(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.waitersUpdater;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, waiter, waiter2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == waiter);
            return false;
        }

        @Override // kotlin.io.CloseableKt
        public final void putNext(Waiter waiter, Waiter waiter2) {
            this.waiterNextUpdater.lazySet(waiter, waiter2);
        }

        @Override // kotlin.io.CloseableKt
        public final void putThread(Waiter waiter, Thread thread) {
            this.waiterThreadUpdater.lazySet(waiter, thread);
        }
    }

    public final class SetFuture implements Runnable {
        public final ListenableFuture future;
        public final SettableFuture owner;

        public SetFuture(SettableFuture settableFuture, ListenableFuture listenableFuture) {
            this.owner = settableFuture;
            this.future = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.owner.value != this) {
                return;
            }
            if (AbstractFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractFuture.getFutureValue(this.future))) {
                AbstractFuture.complete(this.owner);
            }
        }
    }

    public final class SynchronizedHelper extends CloseableKt {
        @Override // kotlin.io.CloseableKt
        public final boolean casListeners(AbstractFuture abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.listeners != listener) {
                        return false;
                    }
                    abstractFuture.listeners = listener2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlin.io.CloseableKt
        public final boolean casValue(AbstractFuture abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.value != obj) {
                        return false;
                    }
                    abstractFuture.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlin.io.CloseableKt
        public final boolean casWaiters(AbstractFuture abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                try {
                    if (abstractFuture.waiters != waiter) {
                        return false;
                    }
                    abstractFuture.waiters = waiter2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // kotlin.io.CloseableKt
        public final void putNext(Waiter waiter, Waiter waiter2) {
            waiter.next = waiter2;
        }

        @Override // kotlin.io.CloseableKt
        public final void putThread(Waiter waiter, Thread thread) {
            waiter.thread = thread;
        }
    }

    public final class Waiter {
        public static final Waiter TOMBSTONE = new Waiter();
        public volatile Waiter next;
        public volatile Thread thread;

        public Waiter() {
            AbstractFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    static {
        CloseableKt synchronizedHelper;
        try {
            synchronizedHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, C0000.decode(new byte[]{17, 81, 75, 6, 88, 5}, "e99c9a06de82f54a", false)), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, C0000.decode(new byte[]{90, 87, 75, 22}, "423bd002e53890d6", true)), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, C0000.decode(new byte[]{65, 82, 11, 23, 81, 67, 71}, "63bc41426146e2", 0.0f)), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, C0000.decode(new byte[]{84, 12, 22, 65, 87, 87, 93, 23, 22}, "8ee529")), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, C0000.decode(new byte[]{69, 85, 94, 66, 1}, "3427d4f2fca8")));
            th = null;
        } catch (Throwable th) {
            th = th;
            synchronizedHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = synchronizedHelper;
        if (th != null) {
            log.log(Level.SEVERE, C0000.decode(new byte[]{103, 2, 80, 83, 34, 21, 87, 95, 15, 83, 121, 7, 84, 71, 81, 17, 22, 95, 16, 65, 90, 64, 9, 91, 84, 12, 25}, "4c66ca82f01b87", 5), th);
        }
        NULL = new Object();
    }

    public static void complete(AbstractFuture abstractFuture) {
        Listener listener;
        Listener listener2;
        Listener listener3 = null;
        while (true) {
            Waiter waiter = abstractFuture.waiters;
            if (ATOMIC_HELPER.casWaiters(abstractFuture, waiter, Waiter.TOMBSTONE)) {
                while (waiter != null) {
                    Thread thread = waiter.thread;
                    if (thread != null) {
                        waiter.thread = null;
                        LockSupport.unpark(thread);
                    }
                    waiter = waiter.next;
                }
                do {
                    listener = abstractFuture.listeners;
                } while (!ATOMIC_HELPER.casListeners(abstractFuture, listener, Listener.TOMBSTONE));
                while (true) {
                    listener2 = listener3;
                    listener3 = listener;
                    if (listener3 == null) {
                        break;
                    }
                    listener = listener3.next;
                    listener3.next = listener2;
                }
                while (listener2 != null) {
                    listener3 = listener2.next;
                    Runnable runnable = listener2.task;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        abstractFuture = setFuture.owner;
                        if (abstractFuture.value == setFuture) {
                            if (ATOMIC_HELPER.casValue(abstractFuture, setFuture, getFutureValue(setFuture.future))) {
                            }
                        } else {
                            continue;
                        }
                    } else {
                        executeListener(runnable, listener2.executor);
                    }
                    listener2 = listener3;
                }
                return;
            }
        }
    }

    public static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, C0000.decode(new byte[]{100, 23, 90, 22, 81, 88, 82, 115, 76, 80, 83, 73, 22, 91, 93, 10, 22, 21, 92, 11, 84, 80, 23, 83, 76, 86, 85, 76, 22, 91, 92, 3, 22, 16, 65, 12, 86, 84, 85, 90, 81, 19}, "6b4b85764369b22d", false) + runnable + C0000.decode(new byte[]{70, 79, 8, 68, 93, 25, 81, 74, 3, 91, 20, 68, 90, 75, 20}, "f8a05942") + executor, (Throwable) e);
        }
    }

    public static Object getDoneValue$1(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            Throwable th = ((Cancellation) obj).cause;
            CancellationException cancellationException = new CancellationException(C0000.decode(new byte[]{55, 2, 18, 82, 19, 20, 3, 69, 65, 0, 2, 87, 0, 6, 13, 85, 86, 7, 76}, "cca93cb6acc9", true));
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

    public static Object getFutureValue(ListenableFuture listenableFuture) {
        Object obj;
        if (listenableFuture instanceof AbstractFuture) {
            Object obj2 = ((AbstractFuture) listenableFuture).value;
            if (!(obj2 instanceof Cancellation)) {
                return obj2;
            }
            Cancellation cancellation = (Cancellation) obj2;
            if (cancellation.wasInterrupted) {
                return cancellation.cause != null ? new Cancellation(cancellation.cause, false) : Cancellation.CAUSELESS_CANCELLED;
            }
            return obj2;
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        boolean z = true;
        if ((!GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            return Cancellation.CAUSELESS_CANCELLED;
        }
        boolean z2 = false;
        while (true) {
            try {
                try {
                    obj = listenableFuture.get();
                    break;
                } catch (InterruptedException unused) {
                    z2 = z;
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException e) {
                if (zIsCancelled) {
                    return new Cancellation(e, false);
                }
                return new Failure(new IllegalArgumentException(C0000.decode(new byte[]{6, 4, 66, 17, 30, 25, 21, 9, 68, 92, 64, 25, 34, 0, 88, 90, 82, 85, 13, 0, 66, 80, 88, 87, 36, 25, 85, 92, 71, 77, 8, 14, 88, 21, 23, 93, 4, 18, 70, 80, 67, 92, 65, 19, 83, 73, 88, 75, 21, 8, 88, 94, 23, 80, 18, 34, 87, 87, 84, 92, 13, 13, 83, 93, 31, 16, 65, 92, 11, 25, 81, 88, 13, 18, 83, 3, 23}, "aa6979", false) + listenableFuture, e));
            } catch (ExecutionException e2) {
                return new Failure(e2.getCause());
            } catch (Throwable th2) {
                return new Failure(th2);
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj == null ? NULL : obj;
    }

    public final void addDoneString$1(StringBuilder sb) {
        Object obj;
        String strDecode = C0000.decode(new byte[]{56}, "e3d42810e166eb", 0.0f);
        boolean z = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append(C0000.decode(new byte[]{122, 116, 121, 117, 125, 126, 120, 33, 39}, "9576824dc7", 1));
                return;
            } catch (RuntimeException e) {
                sb.append(C0000.decode(new byte[]{52, 124, 124, 119, 42, 52, 42, 21, 18, 90, 2, 77, 69, 93, 92, 105}, "a279ecd929c868", true));
                sb.append(e.getClass());
                sb.append(C0000.decode(new byte[]{17, 68, 93, 65, 89, 71, 13, 16, 3, 64, 87, 85, 68, 95, 84, 68, 29, 26, 107}, "105360c0e288d8"));
                return;
            } catch (ExecutionException e2) {
                sb.append(C0000.decode(new byte[]{119, 32, 124, 45, 97, 107, 33, 31, 66, 2, 80, 77, 64, 82, 11, 105}, "1a5a49d3ba183762"));
                sb.append(e2.getCause());
                sb.append(strDecode);
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append(C0000.decode(new byte[]{53, 49, 114, 39, 39, 100, 102, 77, 18, 19, 3, 18, 64, 85, 68, 95, 61}, "fd1db75a2afa590b", true));
        sb.append(obj == this ? C0000.decode(new byte[]{65, 95, 93, 66, 18, 84, 16, 70, 20, 65, 86}, "574122e2a338ad", 7) : String.valueOf(obj));
        sb.append(strDecode);
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

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Cancellation cancellation;
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof SetFuture)) {
            return false;
        }
        if (GENERATE_CANCELLATION_CAUSES) {
            cancellation = new Cancellation(new CancellationException(C0000.decode(new byte[]{126, 77, 69, 64, 69, 82, 25, 84, 81, 15, 83, 84, 92, 24, 17, 24, 70, 84, 68, 23, 84, 86, 92, 13, 85, 85, 30}, "881577770a0100", 2)), z);
        } else {
            cancellation = z ? Cancellation.CAUSELESS_INTERRUPTED : Cancellation.CAUSELESS_CANCELLED;
        }
        AbstractFuture abstractFuture = this;
        boolean z2 = false;
        while (true) {
            if (ATOMIC_HELPER.casValue(abstractFuture, obj, cancellation)) {
                complete(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    break;
                }
                ListenableFuture listenableFuture = ((SetFuture) obj).future;
                if (!(listenableFuture instanceof AbstractFuture)) {
                    listenableFuture.cancel(z);
                    break;
                }
                abstractFuture = (AbstractFuture) listenableFuture;
                obj = abstractFuture.value;
                if (!(obj == null) && !(obj instanceof SetFuture)) {
                    break;
                }
                z2 = true;
            } else {
                obj = abstractFuture.value;
                if (!(obj instanceof SetFuture)) {
                    return z2;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z;
        Waiter waiter = Waiter.TOMBSTONE;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof SetFuture))) {
            return getDoneValue$1(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            Waiter waiter2 = this.waiters;
            if (waiter2 != waiter) {
                Waiter waiter3 = new Waiter();
                z = true;
                while (true) {
                    CloseableKt closeableKt = ATOMIC_HELPER;
                    closeableKt.putNext(waiter3, waiter2);
                    if (closeableKt.casWaiters(this, waiter2, waiter3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                removeWaiter(waiter3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                return getDoneValue$1(obj2);
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
            return getDoneValue$1(this.value);
        }
        z = true;
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null ? z : false) && (!(obj3 instanceof SetFuture))) {
                return getDoneValue$1(obj3);
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
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{54, 88, 94, 64, 0, 82, 20}, "a974e640ad2e", 0.0f));
        sb.append(j);
        String strDecode = C0000.decode(new byte[]{65}, "a736e0e7f5c1", true);
        sb.append(strDecode);
        sb.append(timeUnit.toString().toLowerCase(locale));
        String string3 = sb.toString();
        if (nanos + 1000 < 0) {
            String str = string3 + C0000.decode(new byte[]{68, 16, 67, 93, 17, 65, 22}, "d831d261a5f1");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z2 = (jConvert == 0 || nanos2 > 1000) ? z : false;
            if (jConvert > 0) {
                String str2 = str + jConvert + strDecode + lowerCase;
                if (z2) {
                    str2 = str2 + C0000.decode(new byte[]{25}, "56f12e8f72", true);
                }
                str = str2 + strDecode;
            }
            if (z2) {
                str = str + nanos2 + C0000.decode(new byte[]{68, 12, 89, 93, 92, 23, 85, 81, 11, 12, 92, 64, 19}, "db833d02", true);
            }
            string3 = str + C0000.decode(new byte[]{80, 1, 92, 84, 24, 74}, "4d05ac", 0.0f);
        }
        if (isDone()) {
            throw new TimeoutException(string3 + C0000.decode(new byte[]{23, 6, 77, 69, 69, 85, 22, 16, 17, 22, 4, 68, 7, 91, 90, 20, 84, 84, 17, 86, 7, 68, 5, 23, 65, 16, 13, 89, 82, 11, 77, 69, 69, 86, 27, 20, 13, 22, 4, 0}, "7d81e3cdddadd4", false));
        }
        throw new TimeoutException(string3 + C0000.decode(new byte[]{23, 95, 13, 71, 16}, "79b50e3bde", 1) + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof SetFuture)) & (obj != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String pendingToString() {
        Object obj = this.value;
        if (obj instanceof SetFuture) {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{22, 3, 67, 39, 70, 21, 16, 20, 82, 92, 104}, "ef7a3a", true));
            ListenableFuture listenableFuture = ((SetFuture) obj).future;
            return FileSectionType$EnumUnboxingLocalUtility.m(sb, listenableFuture == this ? C0000.decode(new byte[]{76, 95, 91, 70, 65, 2, 66, 66, 77, 16, 93}, "8725ad768b", 0.0f) : String.valueOf(listenableFuture), C0000.decode(new byte[]{63}, "be99257972e6e69e", 0));
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return C0000.decode(new byte[]{64, 3, 12, 82, 12, 89, 80, 95, 5, 16, 86, 3, 13, 82, 28, 10, 98}, "2fa3e791b0") + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + C0000.decode(new byte[]{68, 90, 21, 107}, "d7f6d8b5ed", 0.0f);
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

    public final String toString() {
        String strPendingToString;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(C0000.decode(new byte[]{107, 21, 64, 88, 22, 76, 21, 12}, "0f49b9f1f956cf", 4));
        boolean z = this.value instanceof Cancellation;
        String strDecode = C0000.decode(new byte[]{56}, "e42cb37bfb", 0.0f);
        if (z) {
            sb.append(C0000.decode(new byte[]{114, 39, 123, 112, 116, 47, 120, 118, 38}, "1f531c43b575", 7));
        } else if (isDone()) {
            addDoneString$1(sb);
        } else {
            try {
                strPendingToString = pendingToString();
            } catch (RuntimeException e) {
                strPendingToString = C0000.decode(new byte[]{125, 29, 6, 87, 70, 23, 88, 95, 90, 16, 64, 89, 74, 14, 21, 89, 24, 3, 23, 93, 91, 67, 88, 93, 68, 92, 81, 92, 93, 15, 22, 86, 76, 12, 10, 92, 12, 67}, "8ee26c1040418ab7", 0.0f) + e.getClass();
            }
            if (strPendingToString != null && !strPendingToString.isEmpty()) {
                sb.append(C0000.decode(new byte[]{101, 113, 125, 39, 47, 127, 126, 29, 21, 93, 93, 5, 9, 12, 98}, "543cf191", 0.0f));
                sb.append(strPendingToString);
                sb.append(strDecode);
            } else if (isDone()) {
                addDoneString$1(sb);
            } else {
                sb.append(C0000.decode(new byte[]{97, 125, 45, 113, 121, 126, 119}, "18c50007", 2));
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
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return getDoneValue$1(obj2);
            }
            Waiter waiter2 = this.waiters;
            if (waiter2 != waiter) {
                Waiter waiter3 = new Waiter();
                do {
                    CloseableKt closeableKt = ATOMIC_HELPER;
                    closeableKt.putNext(waiter3, waiter2);
                    if (closeableKt.casWaiters(this, waiter2, waiter3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                removeWaiter(waiter3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return getDoneValue$1(obj);
                    }
                    waiter2 = this.waiters;
                } while (waiter2 != waiter);
            }
            return getDoneValue$1(this.value);
        }
        throw new InterruptedException();
    }
}
