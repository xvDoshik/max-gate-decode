package androidx.sqlite.db;

import java.io.Closeable;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i, byte[] bArr);

    void bindDouble(int i, double d);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindString(String str, int i);
}
