package androidx.work.impl;

import android.database.Cursor;
import android.os.Looper;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.EmptySet;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class WorkDatabase {
    public boolean allowMainThreadQueries;
    public SupportSQLiteOpenHelper internalOpenHelper;
    public Executor internalQueryExecutor;
    public List mCallbacks;
    public volatile FrameworkSQLiteDatabase mDatabase;
    public final LinkedHashMap typeConverters;
    public final InvalidationTracker invalidationTracker = createInvalidationTracker();
    public final LinkedHashMap autoMigrationSpecs = new LinkedHashMap();
    public final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public final ThreadLocal suspendingTransactionId = new ThreadLocal();

    public WorkDatabase() {
        Collections.synchronizedMap(new LinkedHashMap());
        this.typeConverters = new LinkedHashMap();
    }

    public static Object unwrapOpenHelper(Class cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    public final void assertNotMainThread() {
        if (!this.allowMainThreadQueries && Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException(C0000.decode(new byte[]{119, 87, 11, 86, 9, 67, 19, 85, 87, 85, 0, 75, 21, 23, 87, 85, 64, 87, 7, 89, 21, 82, 19, 91, 90, 22, 17, 80, 3, 23, 94, 85, 93, 88, 69, 76, 14, 69, 86, 85, 80, 22, 22, 81, 8, 84, 86, 20, 93, 66, 69, 85, 7, 78, 19, 68, 91, 66, 0, 86, 18, 94, 82, 88, 88, 79, 69, 84, 9, 84, 88, 20, 64, 94, 0, 24, 51, 126, 19, 82, 91, 68, 69, 89, 70, 91, 92, 90, 83, 22, 21, 93, 20, 94, 92, 80, 20, 89, 3, 24, 18, 94, 94, 81, 26}, "46e8f734", false));
        }
    }

    public final void assertNotSuspendingTransaction() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper == null) {
            supportSQLiteOpenHelper = null;
        }
        if (!supportSQLiteOpenHelper.getWritableDatabase().inTransaction() && this.suspendingTransactionId.get() != null) {
            throw new IllegalStateException(C0000.decode(new byte[]{34, 84, 86, 13, 94, 70, 65, 85, 86, 81, 83, 74, 18, 21, 92, 2, 69, 83, 3, 85, 70, 87, 22, 86, 15, 21, 89, 67, 85, 91, 7, 82, 80, 64, 83, 87, 21, 21, 91, 12, 67, 93, 20, 64, 92, 92, 83, 25, 2, 90, 86, 23, 84, 74, 21, 20, 92, 92, 94, 92, 19, 92, 76, 6, 85, 18, 7, 70, 90, 95, 22, 88, 65, 70, 77, 16, 65, 87, 15, 80, 92, 92, 81, 25, 21, 71, 89, 13, 66, 83, 2, 64, 92, 93, 88, 23}, "a58c12a45269"));
        }
    }

    public final void beginTransaction() {
        assertNotMainThread();
        assertNotMainThread();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper == null) {
            supportSQLiteOpenHelper = null;
        }
        FrameworkSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
        this.invalidationTracker.syncTriggers$room_runtime_release(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    public abstract Api dependencyDao();

    public List getAutoMigrations() {
        return EmptyList.INSTANCE;
    }

    public Set getRequiredAutoMigrationSpecs() {
        return EmptySet.INSTANCE;
    }

    public Map getRequiredTypeConverters() {
        return EmptyMap.INSTANCE;
    }

    public final void internalEndTransaction() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper == null) {
            supportSQLiteOpenHelper = null;
        }
        supportSQLiteOpenHelper.getWritableDatabase().endTransaction();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = this.internalOpenHelper;
        if (supportSQLiteOpenHelper2 == null) {
            supportSQLiteOpenHelper2 = null;
        }
        if (supportSQLiteOpenHelper2.getWritableDatabase().inTransaction()) {
            return;
        }
        InvalidationTracker invalidationTracker = this.invalidationTracker;
        if (invalidationTracker.pendingRefresh.compareAndSet(false, true)) {
            Executor executor = invalidationTracker.database.internalQueryExecutor;
            (executor != null ? executor : null).execute(invalidationTracker.refreshRunnable);
        }
    }

    public abstract OperationImpl preferenceDao();

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper == null) {
            supportSQLiteOpenHelper = null;
        }
        return supportSQLiteOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    public final Object runInTransaction(Callable callable) {
        beginTransaction();
        try {
            Object objCall = callable.call();
            setTransactionSuccessful();
            return objCall;
        } finally {
            internalEndTransaction();
        }
    }

    public final void setTransactionSuccessful() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper == null) {
            supportSQLiteOpenHelper = null;
        }
        supportSQLiteOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }

    public abstract Dispatcher systemIdInfoDao();

    public abstract WorkLauncherImpl workNameDao();

    public abstract zzac workProgressDao();

    public abstract WorkSpecDao_Impl workSpecDao();

    public abstract WorkTagDao_Impl workTagDao();
}
