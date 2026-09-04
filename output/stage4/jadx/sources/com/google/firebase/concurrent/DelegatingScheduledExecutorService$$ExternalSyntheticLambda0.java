package com.google.firebase.concurrent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.work.impl.Processor$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda3;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class DelegatingScheduledExecutorService$$ExternalSyntheticLambda0 implements SynchronizationGuard.CriticalSection, DelegatingScheduledFuture.Resolver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ DelegatingScheduledExecutorService$$ExternalSyntheticLambda0(Uploader uploader, Iterable iterable, AutoValue_TransportContext autoValue_TransportContext, long j) {
        this.$r8$classId = 1;
        this.f$0 = uploader;
        this.f$1 = iterable;
        this.f$3 = autoValue_TransportContext;
        this.f$2 = j;
    }

    @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
    public ScheduledFuture addCompleter(ConnectionPool connectionPool) {
        switch (this.$r8$classId) {
            case 0:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = (DelegatingScheduledExecutorService) this.f$0;
                Runnable runnable = (Runnable) this.f$1;
                return delegatingScheduledExecutorService.scheduler.schedule(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda4(delegatingScheduledExecutorService, runnable, connectionPool, 1), this.f$2, (TimeUnit) this.f$3);
            default:
                DelegatingScheduledExecutorService delegatingScheduledExecutorService2 = (DelegatingScheduledExecutorService) this.f$0;
                Callable callable = (Callable) this.f$1;
                return delegatingScheduledExecutorService2.scheduler.schedule(new Processor$$ExternalSyntheticLambda0(delegatingScheduledExecutorService2, callable, connectionPool, 1), this.f$2, (TimeUnit) this.f$3);
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        Uploader uploader = (Uploader) this.f$0;
        Iterable iterable = (Iterable) this.f$1;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$3;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) uploader.eventStore;
        sQLiteEventStore.getClass();
        if (iterable.iterator().hasNext()) {
            String str = C0000.decode(new byte[]{51, 99, 113, 112, 48, 115, 21, 82, 64, 6, 8, 71, 70, 17, 55, 115, 97, 23, 88, 22, 11, 108, 84, 69, 16, 83, 88, 71, 66, 16, 70, 14, 21, 95, 17, 91, 106, 86, 66, 23, 3, 94, 69, 69, 23, 22, 30, 23, 7, 67, 49, 123, 112, 99, 33, 22, 106, 94, 82, 67, 15, 93, 21}, "f351d6576c", false) + SQLiteEventStore.toIdList(iterable);
            String strDecode = C0000.decode(new byte[]{96, 38, 40, 118, 38, 100, 67, 33, 125, 48, 125, 55, 76, 25, 76, 28, 67, 22, 64, 4, 93, 16, 20, 92, 23, 68, 60, 12, 83, 8, 86, 67, 34, 97, 42, 125, 67, 7, 68, 0, 93, 23, 23, 19, 50, 120, 38, 48, 119, 69, 93, 22, 9, 108, 4, 68, 23, 7, 95, 21, 71, 16, 68, 13, 88, 16, 82, 84, 18, 34, 97, 44, 49, 99, 69, 114, 58, 66, 70, 23, 82, 13, 23, 67, 10, 66, 23, 61, 92, 4, 94, 6}, "3cd3e0cb2e", true);
            SQLiteDatabase db = sQLiteEventStore.getDb();
            db.beginTransaction();
            try {
                db.compileStatement(str).execute();
                Cursor cursorRawQuery = db.rawQuery(strDecode, null);
                while (cursorRawQuery.moveToNext()) {
                    try {
                        sQLiteEventStore.recordLogEventDropped(cursorRawQuery.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursorRawQuery.getString(1));
                    } catch (Throwable th) {
                        cursorRawQuery.close();
                        throw th;
                    }
                }
                cursorRawQuery.close();
                db.compileStatement(C0000.decode(new byte[]{113, 38, 46, 33, 102, 125, 70, 116, 106, 124, 44, 20, 7, 23, 80, 13, 22, 23, 18, 111, 46, 119, 106, 118, 65, 90, 23, 12, 106, 2, 22, 16, 87, 85, 22, 70, 75, 19, 95, 9, 66, 80, 3}, "5cbd28f283a4ba", 0.0f)).execute();
                db.setTransactionSuccessful();
                db.endTransaction();
            } catch (Throwable th2) {
                db.endTransaction();
                throw th2;
            }
        }
        sQLiteEventStore.inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda3(uploader.clock.getTime() + this.f$2, autoValue_TransportContext));
        return null;
    }

    public /* synthetic */ DelegatingScheduledExecutorService$$ExternalSyntheticLambda0(DelegatingScheduledExecutorService delegatingScheduledExecutorService, Object obj, long j, TimeUnit timeUnit, int i) {
        this.$r8$classId = i;
        this.f$0 = delegatingScheduledExecutorService;
        this.f$1 = obj;
        this.f$2 = j;
        this.f$3 = timeUnit;
    }
}
