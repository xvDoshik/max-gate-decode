package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.SynchronizedLazyImpl;
import kotlin.UNINITIALIZED_VALUE;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.Handshake;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public final boolean allowDataLossOnRecovery;
    public final RoomOpenHelper callback;
    public final Context context;
    public final SynchronizedLazyImpl lazyDelegate = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(3, this));
    public final String name;
    public final boolean useNoBackupDirectory;
    public boolean writeAheadLoggingEnabled;

    public final class OpenHelper extends SQLiteOpenHelper {
        public static final /* synthetic */ int $r8$clinit = 0;
        public final boolean allowDataLossOnRecovery;
        public final RoomOpenHelper callback;
        public final Context context;
        public final ConnectionPool dbRef;
        public final ProcessLock lock;
        public boolean migrated;
        public boolean opened;

        public final class CallbackException extends RuntimeException {
            public final int callbackName;
            public final Throwable cause;

            public CallbackException(int i, Throwable th) {
                super(th);
                this.callbackName = i;
                this.cause = th;
            }

            @Override // java.lang.Throwable
            public final Throwable getCause() {
                return this.cause;
            }
        }

        public OpenHelper(Context context, String str, final ConnectionPool connectionPool, final RoomOpenHelper roomOpenHelper, boolean z) {
            super(context, str, null, roomOpenHelper.version, new DatabaseErrorHandler(roomOpenHelper, connectionPool) { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0
                public final /* synthetic */ ConnectionPool f$1;

                {
                    this.f$1 = connectionPool;
                }

                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    int i = FrameworkSQLiteOpenHelper.OpenHelper.$r8$clinit;
                    ConnectionPool connectionPool2 = this.f$1;
                    FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) connectionPool2.delegate;
                    if (frameworkSQLiteDatabase == null || !Intrinsics.areEqual(frameworkSQLiteDatabase.delegate, sQLiteDatabase)) {
                        frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                        connectionPool2.delegate = frameworkSQLiteDatabase;
                    }
                    SQLiteDatabase sQLiteDatabase2 = frameworkSQLiteDatabase.delegate;
                    if (!sQLiteDatabase2.isOpen()) {
                        String path = sQLiteDatabase2.getPath();
                        if (path != null) {
                            RoomOpenHelper.deleteDatabaseFile(path);
                            return;
                        }
                        return;
                    }
                    List list = null;
                    try {
                        try {
                            list = frameworkSQLiteDatabase.attachedDbs;
                        } catch (SQLiteException unused) {
                        }
                        try {
                            frameworkSQLiteDatabase.close();
                        } catch (IOException unused2) {
                        }
                        if (list != null) {
                            return;
                        }
                    } finally {
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                RoomOpenHelper.deleteDatabaseFile((String) ((Pair) it.next()).second);
                            }
                        } else {
                            String path2 = sQLiteDatabase2.getPath();
                            if (path2 != null) {
                                RoomOpenHelper.deleteDatabaseFile(path2);
                            }
                        }
                    }
                }
            });
            this.context = context;
            this.dbRef = connectionPool;
            this.callback = roomOpenHelper;
            this.allowDataLossOnRecovery = z;
            this.lock = new ProcessLock(str == null ? UUID.randomUUID().toString() : str, context.getCacheDir(), false);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final void close() {
            ProcessLock processLock = this.lock;
            try {
                processLock.lock(processLock.processLock);
                super.close();
                this.dbRef.delegate = null;
                this.opened = false;
            } finally {
                processLock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getSupportDatabase(boolean z) {
            ProcessLock processLock = this.lock;
            try {
                processLock.lock((this.opened || getDatabaseName() == null) ? false : true);
                this.migrated = false;
                SQLiteDatabase sQLiteDatabaseInnerGetDatabase = innerGetDatabase(z);
                if (!this.migrated) {
                    return getWrappedDb(sQLiteDatabaseInnerGetDatabase);
                }
                close();
                return getSupportDatabase(z);
            } finally {
                processLock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            ConnectionPool connectionPool = this.dbRef;
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) connectionPool.delegate;
            if (frameworkSQLiteDatabase != null && Intrinsics.areEqual(frameworkSQLiteDatabase.delegate, sQLiteDatabase)) {
                return frameworkSQLiteDatabase;
            }
            FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = new FrameworkSQLiteDatabase(sQLiteDatabase);
            connectionPool.delegate = frameworkSQLiteDatabase2;
            return frameworkSQLiteDatabase2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v12, types: [android.database.sqlite.SQLiteDatabase] */
        /* JADX WARN: Type inference failed for: r6v14 */
        /* JADX WARN: Type inference failed for: r6v15 */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.database.sqlite.SQLiteDatabase] */
        public final SQLiteDatabase innerGetDatabase(boolean z) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            Context context = this.context;
            if (databaseName != null && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    parentFile.toString();
                }
            }
            try {
                z = z != 0 ? getWritableDatabase() : getReadableDatabase();
                return z;
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    z = z != 0 ? getWritableDatabase() : getReadableDatabase();
                    return z;
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = th;
                        int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(callbackException.callbackName);
                        Throwable th2 = callbackException.cause;
                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || !(th2 instanceof SQLiteException)) {
                            throw th2;
                        }
                    } else if (!(th instanceof SQLiteException) || databaseName == null || !this.allowDataLossOnRecovery) {
                        throw th;
                    }
                    context.deleteDatabase(databaseName);
                    try {
                        return z != 0 ? getWritableDatabase() : getReadableDatabase();
                    } catch (CallbackException e) {
                        throw e.cause;
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
            try {
                RoomOpenHelper roomOpenHelper = this.callback;
                getWrappedDb(sQLiteDatabase);
                roomOpenHelper.getClass();
            } catch (Throwable th) {
                throw new CallbackException(1, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                this.callback.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(2, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(4, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(5, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(3, th);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, RoomOpenHelper roomOpenHelper, boolean z, boolean z2) {
        this.context = context;
        this.name = str;
        this.callback = roomOpenHelper;
        this.useNoBackupDirectory = z;
        this.allowDataLossOnRecovery = z2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.lazyDelegate._value != UNINITIALIZED_VALUE.INSTANCE) {
            getDelegate().close();
        }
    }

    public final OpenHelper getDelegate() {
        return (OpenHelper) this.lazyDelegate.getValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final FrameworkSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        if (this.lazyDelegate._value != UNINITIALIZED_VALUE.INSTANCE) {
            getDelegate().setWriteAheadLoggingEnabled(z);
        }
        this.writeAheadLoggingEnabled = z;
    }
}
