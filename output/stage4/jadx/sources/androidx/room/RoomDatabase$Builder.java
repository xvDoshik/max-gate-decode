package androidx.room;

import android.content.Context;
import androidx.room.migration.Migration;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RoomDatabase$Builder {
    public boolean allowDestructiveMigrationOnDowngrade;
    public boolean allowMainThreadQueries;
    public final Context context;
    public CctTransportBackend$$ExternalSyntheticLambda0 factory;
    public HashSet migrationStartAndEndVersions;
    public final String name;
    public Executor queryExecutor;
    public Executor transactionExecutor;
    public final ArrayList callbacks = new ArrayList();
    public final ArrayList typeConverters = new ArrayList();
    public final ArrayList autoMigrationSpecs = new ArrayList();
    public final int journalMode = 1;
    public boolean requireMigration = true;
    public final long autoCloseTimeout = -1;
    public final ConnectionPool migrationContainer = new ConnectionPool(5);
    public final LinkedHashSet migrationsNotRequiredFrom = new LinkedHashSet();

    public RoomDatabase$Builder(Context context, String str) {
        this.context = context;
        this.name = str;
    }

    public final void addMigrations(Migration... migrationArr) {
        if (this.migrationStartAndEndVersions == null) {
            this.migrationStartAndEndVersions = new HashSet();
        }
        for (Migration migration : migrationArr) {
            this.migrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
            this.migrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
        }
        this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrationArr, migrationArr.length));
    }
}
