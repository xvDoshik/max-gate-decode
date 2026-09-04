package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.Closeable;
import java.util.List;
import kotlinx.coroutines.internal.Symbol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FrameworkSQLiteDatabase implements Closeable {
    public static final String[] CONFLICT_VALUES = {"", C0000.decode(new byte[]{17, 127, 97, 16, 51, 122, 40, 42, 115, 113, 112, 123, 65}, "1030a5df", 0.0f), C0000.decode(new byte[]{16, 120, 98, 66, 115, 33, 126, 99, 99, 67}, "070b2c117c58", 0.0f), C0000.decode(new byte[]{17, 120, 107, 18, 115, 32, 44, 117, 23}, "17925ae9722949df", 2), C0000.decode(new byte[]{19, 41, 107, 17, 40, 113, 44, 46, 103, 117, 24}, "3f91a6ba50813afd", true), C0000.decode(new byte[]{65, 44, 52, 16, 100, 36, 100, 120, 35, 123, 116, 67}, "acf06a44b81c", 0.0f)};
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public final List attachedDbs;
    public final SQLiteDatabase delegate;

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.delegate = sQLiteDatabase;
        this.attachedDbs = sQLiteDatabase.getAttachedDbs();
    }

    public final void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public final void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }

    public final FrameworkSQLiteStatement compileStatement(String str) {
        return new FrameworkSQLiteStatement(this.delegate.compileStatement(str));
    }

    public final void endTransaction() {
        this.delegate.endTransaction();
    }

    public final void execSQL(String str) {
        this.delegate.execSQL(str);
    }

    public final void execSQL(Object[] objArr) {
        this.delegate.execSQL(C0000.decode(new byte[]{113, 44, 106, 33, 55, 54, 66, 121, 106, 18, 48, 119, 102, 41, 121, 33, 124, 68, 44, 44, 54, 121, 24, 82, 50, 64, 83, 3, 93, 16, 92, 10, 6, 7, 2, 22, 16, 82, 9, 87, 79, 5, 20, 66, 89, 8, 10, 12, 5, 105, 78, 83, 14, 71, 83, 5, 17, 66, 111, 37, 41, 55, 39, 101, 24, 26, 34, 89, 83, 28, 20, 66, 121, 8, 10, 12, 5, 105, 78, 83, 14, 71, 83, 76}, "8b9debb682b26e", true), objArr);
    }

    public final boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public final boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    public final Cursor query(String str) {
        return query(new Symbol(str, 1));
    }

    public final void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        final FrameworkSQLiteDatabase$query$cursorFactory$1 frameworkSQLiteDatabase$query$cursorFactory$1 = new FrameworkSQLiteDatabase$query$cursorFactory$1(supportSQLiteQuery);
        return this.delegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$$ExternalSyntheticLambda0
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                frameworkSQLiteDatabase$query$cursorFactory$1.$query.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
    }
}
