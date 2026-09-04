package androidx.work.impl;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {
    public volatile Api _dependencyDao;
    public volatile OperationImpl _preferenceDao;
    public volatile Dispatcher _systemIdInfoDao;
    public volatile WorkLauncherImpl _workNameDao;
    public volatile zzac _workProgressDao;
    public volatile WorkSpecDao_Impl _workSpecDao;
    public volatile WorkTagDao_Impl _workTagDao;

    @Override // androidx.work.impl.WorkDatabase
    public final InvalidationTracker createInvalidationTracker() {
        HashMap map = new HashMap(0);
        HashMap map2 = new HashMap(0);
        String strDecode = C0000.decode(new byte[]{110, 88, 66, 89, 50, 70, 11, 80, 66, 1, 21, 16}, "9702b4d70dfc", true);
        String strDecode2 = C0000.decode(new byte[]{51, 20, 84, 85, 81, 70, 82, 12, 84, 80}, "cf13447b7503", 0.0f);
        return new InvalidationTracker(this, map, map2, C0000.decode(new byte[]{34, 92, 68, 6, 15, 93, 86, 90, 85, 75}, "f94ca9346208528b", false), C0000.decode(new byte[]{100, 87, 22, 91, 102, 73, 86, 91}, "38d059", 0), C0000.decode(new byte[]{52, 12, 20, 13, 50, 5, 84}, "ccfffd366c3bb6", 0.0f), C0000.decode(new byte[]{53, 31, 65, 64, 93, 94, 47, 2, 123, 90, 94, 92}, "ff2483"), C0000.decode(new byte[]{103, 93, 65, 91, 126, 0, 90, 1}, "02300a7d", 5), strDecode, strDecode2);
    }

    @Override // androidx.work.impl.WorkDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(new SupportSQLiteOpenHelper.Configuration(databaseConfiguration.context, databaseConfiguration.name, new RoomOpenHelper(databaseConfiguration, new ConnectionPool(9, this)), false, false));
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Api dependencyDao() {
        Api api;
        if (this._dependencyDao != null) {
            return this._dependencyDao;
        }
        synchronized (this) {
            try {
                if (this._dependencyDao == null) {
                    this._dependencyDao = new Api(this);
                }
                api = this._dependencyDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return api;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final List getAutoMigrations() {
        int i = 13;
        int i2 = 14;
        Migration_1_2 migration_1_2 = new Migration_1_2(i, i2, 10);
        Migration_1_2 migration_1_3 = new Migration_1_2(11);
        int i3 = 17;
        Migration_1_2 migration_1_4 = new Migration_1_2(16, i3, 12);
        int i4 = 18;
        Migration_1_2 migration_1_5 = new Migration_1_2(i3, i4, i);
        Migration_1_2 migration_1_6 = new Migration_1_2(i4, 19, i2);
        Migration_1_2 migration_1_7 = new Migration_1_2(15);
        Migration[] migrationArr = new Migration[6];
        migrationArr[0] = migration_1_2;
        migrationArr[1] = migration_1_3;
        migrationArr[2] = migration_1_4;
        migrationArr[3] = migration_1_5;
        migrationArr[4] = migration_1_6;
        migrationArr[5] = migration_1_7;
        return Arrays.asList(migrationArr);
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(WorkSpecDao_Impl.class, list);
        map.put(Api.class, list);
        map.put(WorkTagDao_Impl.class, list);
        map.put(Dispatcher.class, list);
        map.put(WorkLauncherImpl.class, list);
        map.put(zzac.class, list);
        map.put(OperationImpl.class, list);
        map.put(ExceptionsKt.class, list);
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final OperationImpl preferenceDao() {
        OperationImpl operationImpl;
        if (this._preferenceDao != null) {
            return this._preferenceDao;
        }
        synchronized (this) {
            try {
                if (this._preferenceDao == null) {
                    this._preferenceDao = new OperationImpl((WorkDatabase) this);
                }
                operationImpl = this._preferenceDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return operationImpl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final Dispatcher systemIdInfoDao() {
        Dispatcher dispatcher;
        if (this._systemIdInfoDao != null) {
            return this._systemIdInfoDao;
        }
        synchronized (this) {
            try {
                if (this._systemIdInfoDao == null) {
                    this._systemIdInfoDao = new Dispatcher(this);
                }
                dispatcher = this._systemIdInfoDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dispatcher;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkLauncherImpl workNameDao() {
        WorkLauncherImpl workLauncherImpl;
        if (this._workNameDao != null) {
            return this._workNameDao;
        }
        synchronized (this) {
            try {
                if (this._workNameDao == null) {
                    this._workNameDao = new WorkLauncherImpl(this);
                }
                workLauncherImpl = this._workNameDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workLauncherImpl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final zzac workProgressDao() {
        zzac zzacVar;
        if (this._workProgressDao != null) {
            return this._workProgressDao;
        }
        synchronized (this) {
            try {
                if (this._workProgressDao == null) {
                    this._workProgressDao = new zzac(this);
                }
                zzacVar = this._workProgressDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzacVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkSpecDao_Impl workSpecDao() {
        WorkSpecDao_Impl workSpecDao_Impl;
        if (this._workSpecDao != null) {
            return this._workSpecDao;
        }
        synchronized (this) {
            try {
                if (this._workSpecDao == null) {
                    this._workSpecDao = new WorkSpecDao_Impl(this);
                }
                workSpecDao_Impl = this._workSpecDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workSpecDao_Impl;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final WorkTagDao_Impl workTagDao() {
        WorkTagDao_Impl workTagDao_Impl;
        if (this._workTagDao != null) {
            return this._workTagDao;
        }
        synchronized (this) {
            try {
                if (this._workTagDao == null) {
                    WorkTagDao_Impl workTagDao_Impl2 = new WorkTagDao_Impl();
                    workTagDao_Impl2.__db = this;
                    workTagDao_Impl2.__insertionAdapterOfWorkTag = new WorkTagDao_Impl.AnonymousClass1(this, 0);
                    workTagDao_Impl2.__preparedStmtOfDeleteByWorkSpecId = new WorkTagDao_Impl.AnonymousClass2(this, 0);
                    this._workTagDao = workTagDao_Impl2;
                }
                workTagDao_Impl = this._workTagDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return workTagDao_Impl;
    }
}
