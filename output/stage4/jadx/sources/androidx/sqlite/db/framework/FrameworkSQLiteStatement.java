package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteStatement delegate;

    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.delegate = sQLiteStatement;
    }

    public final int executeUpdateDelete() {
        return this.delegate.executeUpdateDelete();
    }
}
