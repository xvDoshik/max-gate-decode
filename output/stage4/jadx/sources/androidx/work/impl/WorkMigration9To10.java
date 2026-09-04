package androidx.work.impl;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkMigration9To10 extends Migration {
    public final /* synthetic */ int $r8$classId = 0;
    public final Context context;

    public WorkMigration9To10(Context context, int i, int i2) {
        super(i, i2);
        this.context = context;
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        switch (this.$r8$classId) {
            case 0:
                frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{112, 101, 119, 39, 50, 115, 69, 96, 114, 39, 127, 114, 18, 47, 32, 22, 43, 123, 103, 69, 118, 111, 123, 53, 50, 101, 69, 84, 99, 23, 86, 81, 87, 20, 3, 88, 6, 81, 83, 69, 27, 87, 89, 3, 31, 86, 69, 96, 118, 61, 103, 23, 124, 41, 50, 22, 43, 97, 127, 41, 31, 23, 82, 10, 9, 88, 2, 107, 69, 4, 95, 66, 87, 6, 70, 127, 43, 96, 118, 34, 118, 101, 30, 70, 54, 100, 44, 121, 114, 55, 106, 23, 121, 35, 63, 30, 5, 95, 86, 28, 83, 30, 27}, "372ff6e43e"));
                Context context = this.context;
                SharedPreferences sharedPreferences = context.getSharedPreferences(C0000.decode(new byte[]{7, 11, 2, 71, 88, 90, 93, 25, 79, 19, 95, 71, 13, 75, 19, 65, 94, 95, 23, 17, 19, 1, 86, 80, 20, 0, 8, 86, 82, 64}, "fef5739aad05"), 0);
                String strDecode = C0000.decode(new byte[]{70, 93, 64, 6, 90, 82, 1, 23, 10, 92, 102, 12, 81, 93, 87, 0, 86}, "483e27ebf99b");
                boolean zContains = sharedPreferences.contains(strDecode);
                String strDecode2 = C0000.decode(new byte[]{95, 0, 18, 64, 106, 84, 83, 90, 2, 1, 92, 111, 82, 13, 13, 107, 65, 94, 95, 81, 62, 9, 67}, "3aa45724ad00", true);
                if (zContains || sharedPreferences.contains(strDecode2)) {
                    long j = sharedPreferences.getLong(strDecode2, 0L);
                    long j2 = sharedPreferences.getBoolean(strDecode, false) ? 1L : 0L;
                    frameworkSQLiteDatabase.beginTransaction();
                    try {
                        frameworkSQLiteDatabase.execSQL(new Object[]{strDecode2, Long.valueOf(j)});
                        frameworkSQLiteDatabase.execSQL(new Object[]{strDecode, Long.valueOf(j2)});
                        sharedPreferences.edit().clear().apply();
                        frameworkSQLiteDatabase.setTransactionSuccessful();
                        frameworkSQLiteDatabase.endTransaction();
                    } catch (Throwable th) {
                        frameworkSQLiteDatabase.endTransaction();
                        throw th;
                    }
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences(C0000.decode(new byte[]{81, 11, 80, 68, 95, 13, 83, 77, 24, 65, 88, 65, 15, 79, 64, 65, 89, 9, 26, 95, 84}, "0e460d756673da55", false), 0);
                String strDecode3 = C0000.decode(new byte[]{90, 6, 28, 17, 57, 83, 91, 1, 59, 22, 5, 81, 81, 7, 17, 9, 3, 75, 107, 10, 0}, "4cdef9", 7);
                if (sharedPreferences2.contains(strDecode3) || sharedPreferences2.contains(strDecode3)) {
                    int i = sharedPreferences2.getInt(strDecode3, 0);
                    String strDecode4 = C0000.decode(new byte[]{8, 84, 75, 70, 111, 89, 14, 5, 20, 92, 108, 95, 81, 86, 3, 3, 3, 67, 108, 91, 84}, "f13208bd", 5);
                    int i2 = sharedPreferences2.getInt(strDecode4, 0);
                    frameworkSQLiteDatabase.beginTransaction();
                    try {
                        frameworkSQLiteDatabase.execSQL(new Object[]{strDecode3, Integer.valueOf(i)});
                        frameworkSQLiteDatabase.execSQL(new Object[]{strDecode4, Integer.valueOf(i2)});
                        sharedPreferences2.edit().clear().apply();
                        frameworkSQLiteDatabase.setTransactionSuccessful();
                        return;
                    } finally {
                        frameworkSQLiteDatabase.endTransaction();
                    }
                }
                return;
            default:
                int i3 = this.endVersion;
                String strDecode5 = C0000.decode(new byte[]{75, 87, 23, 2, 94, 0, 6, 71, 93, 7, 102, 15, 84, 83, 93, 87, 0}, "92da6eb21b9a16", false);
                if (i3 >= 10) {
                    frameworkSQLiteDatabase.execSQL(new Object[]{strDecode5, 1});
                    return;
                } else {
                    this.context.getSharedPreferences(C0000.decode(new byte[]{83, 90, 93, 64, 92, 91, 85, 73, 28, 67, 86, 64, 88, 28, 68, 69, 91, 88, 23, 66, 65, 87, 87, 84, 64, 81, 87, 81, 86, 65}, "24923211"), 0).edit().putBoolean(strDecode5, true).apply();
                    return;
                }
        }
    }

    public WorkMigration9To10(Context context) {
        super(9, 10);
        this.context = context;
    }
}
