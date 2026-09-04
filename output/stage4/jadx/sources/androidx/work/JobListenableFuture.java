package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.SettableFuture;
import com.base.template.App;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.JobImpl;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class JobListenableFuture implements ListenableFuture {
    public final SettableFuture underlying = new SettableFuture();

    /* JADX INFO: renamed from: androidx.work.JobListenableFuture$1, reason: invalid class name */
    public final class AnonymousClass1 extends Lambda implements Function1 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            super(1);
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    Throwable th = (Throwable) obj;
                    JobListenableFuture jobListenableFuture = (JobListenableFuture) this.this$0;
                    if (th == null) {
                        if (!jobListenableFuture.underlying.isDone()) {
                            throw new IllegalArgumentException(C0000.decode(new byte[]{117, 3, 15, 8, 3, 6, 18, 22, 86, 16, 70, 11, 20, 1, 11, 7, 92, 16, 29}, "3bfdfb2d3a", 0.0f));
                        }
                    } else if (th instanceof CancellationException) {
                        jobListenableFuture.underlying.cancel(true);
                    } else {
                        SettableFuture settableFuture = jobListenableFuture.underlying;
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            th = cause;
                        }
                        settableFuture.setException(th);
                    }
                    return Unit.INSTANCE;
                case 1:
                    String str = (String) obj;
                    if (str.length() > 0) {
                        ((App) this.this$0).getSharedPreferences(C0000.decode(new byte[]{4}, "b1be2d6d915505", 0.0f), 0).edit().putString(C0000.decode(new byte[]{18}, "f7913ce201eb2ed1", false), str).apply();
                    }
                    return Unit.INSTANCE;
                case 2:
                    String str2 = (String) obj;
                    if (str2.length() > 0) {
                        ((Context) this.this$0).getSharedPreferences(C0000.decode(new byte[]{83}, "56ce845a", 0.0f), 0).edit().putString(C0000.decode(new byte[]{16}, "d5a84152"), str2).apply();
                    }
                    return Unit.INSTANCE;
                case 3:
                    return obj == ((AbstractList) this.this$0) ? C0000.decode(new byte[]{25, 67, 95, 91, 68, 70, 122, 95, 85, 90, 87, 86, 23, 93, 94, 89, 30}, "17727f909625c4", true) : String.valueOf(obj);
                case 4:
                    IntRange intRange = (IntRange) obj;
                    return ((CharSequence) this.this$0).subSequence(intRange.first, intRange.last + 1).toString();
                default:
                    CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) this.this$0;
                    Unit unit = Unit.INSTANCE;
                    cancellableContinuationImpl.resumeWith(unit);
                    return unit;
            }
        }
    }

    public JobListenableFuture(JobImpl jobImpl) {
        jobImpl.invokeOnCompletion(false, true, new AnonymousClass1(0, this));
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        this.underlying.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.underlying.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.underlying.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.underlying.value instanceof AbstractFuture.Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.underlying.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.underlying.get(j, timeUnit);
    }
}
