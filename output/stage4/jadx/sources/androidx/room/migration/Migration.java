package androidx.room.migration;

import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int i, int i2) {
        this.startVersion = i;
        this.endVersion = i2;
    }

    public abstract void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase);
}
