package androidx.room;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List callbacks;
    public final Context context;
    public final int journalMode;
    public final ConnectionPool migrationContainer;
    public final Set migrationNotRequiredFrom;
    public final String name;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, ConnectionPool connectionPool, List list, boolean z, int i, Executor executor, Executor executor2, boolean z2, boolean z3, Set set, List list2, List list3) {
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = connectionPool;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = i;
        this.queryExecutor = executor;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
        this.migrationNotRequiredFrom = set;
    }
}
