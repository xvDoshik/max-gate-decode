package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.delegate = sQLiteProgram;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int i, byte[] bArr) {
        this.delegate.bindBlob(i, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i, double d) {
        this.delegate.bindDouble(i, d);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i, long j) {
        this.delegate.bindLong(i, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i) {
        this.delegate.bindNull(i);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(String str, int i) {
        this.delegate.bindString(i, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }
}
