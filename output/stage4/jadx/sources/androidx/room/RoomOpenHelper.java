package androidx.room;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.CleanupCallback;
import androidx.work.impl.WorkDatabaseKt;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.gms.common.internal.zzu;
import com.google.firebase.installations.remote.AutoValue_TokenResult;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.ConnectionPool;
import okhttp3.Protocol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RoomOpenHelper {
    public final /* synthetic */ int $r8$classId;
    public Object configuration;
    public Object delegate;
    public int version;

    public /* synthetic */ RoomOpenHelper() {
        this.$r8$classId = 1;
    }

    public static void deleteDatabaseFile(String str) {
        if (StringsKt__StringsJVMKt.equals(str, C0000.decode(new byte[]{2, 89, 86, 85, 88, 65, 79, 92}, "8438736f", 0.0f))) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare(str.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                } else {
                    length--;
                }
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() == 0) {
            return;
        }
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception unused) {
        }
    }

    public AutoValue_TokenResult build() {
        if (!"".isEmpty()) {
            throw new IllegalStateException(C0000.decode(new byte[]{124, 92, 71, 65, 94, 91, 86, 19, 67, 80, 69, 71, 94, 71, 84, 87, 17, 69, 70, 93, 71, 80, 67, 71, 88, 80, 71, 8}, "15427513", 0.0f).concat(""));
        }
        String str = (String) this.configuration;
        return new AutoValue_TokenResult(this.version, ((Long) this.delegate).longValue(), str);
    }

    public void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws IOException {
        ConnectionPool connectionPool = (ConnectionPool) this.delegate;
        Cursor cursorQuery = frameworkSQLiteDatabase.query(C0000.decode(new byte[]{55, 118, 123, 125, 114, 108, 19, 82, 9, 20, 90, 17, 76, 25, 30, 24, 119, 106, 124, 124, 70, 18, 69, 9, 13, 71, 82, 103, 92, 89, 64, 69, 3, 19, 20, 50, 44, 118, 101, 125, 17, 86, 82, 92, 3, 65, 21, 88, 68, 20, 86, 86, 85, 74, 92, 88, 2, 62, 89, 0, 16, 82, 83, 89, 69, 89, 20}, "d3781831fa4e", false));
        try {
            boolean z = cursorQuery.moveToFirst() && cursorQuery.getInt(0) == 0;
            cursorQuery.close();
            ConnectionPool.createAllTables(frameworkSQLiteDatabase);
            if (!z) {
                zzu zzuVarOnValidateSchema = ConnectionPool.onValidateSchema(frameworkSQLiteDatabase);
                if (!zzuVarOnValidateSchema.zzd) {
                    throw new IllegalStateException(C0000.decode(new byte[]{97, 74, 85, 31, 20, 86, 83, 82, 81, 83, 93, 85, 68, 85, 5, 67, 80, 90, 81, 65, 1, 23, 88, 88, 67, 20, 89, 95, 68, 88, 10, 65, 80, 84, 89, 86, 68, 68, 83, 81, 85, 89, 89, 11, 68}, "1802d7090481d1d7", 3) + zzuVarOnValidateSchema.zza);
                }
            }
            updateIdentity(frameworkSQLiteDatabase);
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) connectionPool.delegate;
            List list = workDatabase_Impl.mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ((CleanupCallback) workDatabase_Impl.mCallbacks.get(i)).getClass();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    public void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws IOException {
        Cursor cursorQuery = frameworkSQLiteDatabase.query(C0000.decode(new byte[]{98, 38, 120, 116, 38, 97, 24, 5, 25, 36, 106, 119, 123, 69, 22, 68, 93, 10, 64, 84, 58, 88, 89, 71, 77, 7, 74, 24, 97, 45, 32, 103, 116, 67, 64, 72, 21, 80, 24, 9, 25, 69, 76, 89, 84, 9, 0, 18, 17, 34, 122, 117, 69, 91, 89, 89, 92, 95, 31, 74, 89, 10, 8, 106, 92, 2, 71, 69, 0, 71, 103, 64, 88, 0, 84, 93, 17}, "1c41e5849b886ee5", 3));
        try {
            boolean z = cursorQuery.moveToFirst() && cursorQuery.getInt(0) != 0;
            cursorQuery.close();
            if (z) {
                Cursor cursorQuery2 = frameworkSQLiteDatabase.query(new Symbol(C0000.decode(new byte[]{103, 119, 120, 124, 118, 99, 65, 8, 93, 85, 90, 70, 93, 77, 76, 104, 9, 0, 74, 88, 20, 116, 102, 118, 120, 23, 19, 14, 86, 93, 107, 95, 85, 74, 65, 82, 19, 62, 77, 81, 86, 94, 81, 25, 98, 127, 36, 51, 124, 16, 93, 86, 20, 4, 21, 3, 83, 65, 117, 121, 121, 123, 96, 25, 4}, "424957aa90", 0.0f), 1));
                try {
                    String string = cursorQuery2.moveToFirst() ? cursorQuery2.getString(0) : null;
                    cursorQuery2.close();
                    if (!C0000.decode(new byte[]{2, 92, 5, 81, 80, 86, 4, 83, 5, 84, 82, 13, 7, 91, 11, 7, 1, 86, 3, 13, 86, 0, 82, 86, 83, 1, 84, 6, 81, 86, 86, 87}, "582b4d554665").equals(string) && !C0000.decode(new byte[]{1, 86, 5, 87, 87, 9, 2, 87, 5, 83, 1, 95, 80, 84, 0, 2, 7, 85, 7, 85, 82, 5, 86, 94, 81, 2, 7, 95, 85, 1, 6, 84}, "2f2f415f").equals(string)) {
                        throw new IllegalStateException(C0000.decode(new byte[]{54, 88, 93, 89, 23, 83, 83, 15, 95, 90, 17, 65, 21, 83, 67, 80, 2, 78, 18, 64, 95, 85, 18, 5, 80, 65, 4, 65, 10, 88, 69, 92, 3, 69, 91, 64, 78, 30, 18, 45, 94, 90, 14, 18, 67, 90, 88, 82, 1, 23, 75, 91, 66, 23, 68, 4, 17, 86, 13, 0, 13, 81, 84, 93, 68, 68, 81, 92, 82, 93, 83, 65, 83, 64, 17, 65, 5, 89, 67, 94, 11, 67, 18, 64, 88, 16, 71, 17, 85, 84, 17, 4, 67, 66, 89, 92, 68, 65, 87, 70, 68, 89, 93, 15, 17, 91, 16, 12, 1, 83, 67, 23, 68, 110, 93, 65, 23, 83, 83, 15, 17, 70, 12, 12, 19, 90, 72, 25, 2, 94, 74, 20, 67, 88, 91, 18, 17, 87, 28, 65, 10, 88, 82, 75, 1, 86, 65, 93, 89, 87, 18, 21, 89, 80, 69, 23, 6, 68, 66, 80, 11, 89, 18, 90, 66, 93, 80, 4, 67, 27, 69, 36, 27, 70, 84, 90, 16, 82, 86, 20, 94, 84, 87, 15, 69, 92, 17, 24, 67, 94, 80, 74, 12, 13, 18, 3, 83, 7, 1, 5, 3, 4, 3, 80, 1, 82, 9, 11, 7, 14, 87, 1, 5, 6, 10, 3, 7, 81, 6, 7, 90, 80, 85, 92, 86, 84, 80, 24, 23, 86, 93, 20, 95, 81, 95, 65}, "d724702a15eac619", true) + string);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery2, th);
                        throw th2;
                    }
                }
            } else {
                zzu zzuVarOnValidateSchema = ConnectionPool.onValidateSchema(frameworkSQLiteDatabase);
                if (!zzuVarOnValidateSchema.zzd) {
                    throw new IllegalStateException(C0000.decode(new byte[]{103, 67, 80, 20, 70, 5, 0, 91, 3, 6, 84, 84, 20, 93, 81, 17, 86, 83, 84, 74, 83, 68, 11, 81, 17, 65, 80, 94, 20, 80, 94, 19, 86, 93, 92, 93, 22, 23, 0, 88, 7, 12, 80, 10, 20}, "71596dc0ba10490e", 0.0f) + zzuVarOnValidateSchema.zza);
                }
                updateIdentity(frameworkSQLiteDatabase);
            }
            ConnectionPool connectionPool = (ConnectionPool) this.delegate;
            ((WorkDatabase_Impl) connectionPool.delegate).mDatabase = frameworkSQLiteDatabase;
            frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{104, 97, 120, 117, 40, 113, 16, 0, 92, 17, 3, 93, 95, 93, 102, 89, 0, 73, 67, 70, 14, 67, 41, 122}, "8392e00f3cf4", true));
            InvalidationTracker invalidationTracker = ((WorkDatabase_Impl) connectionPool.delegate).invalidationTracker;
            synchronized (invalidationTracker.trackerLock) {
                if (!invalidationTracker.initialized) {
                    frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{52, 96, 112, 112, 126, 121, 68, 70, 84, 90, 67, 103, 23, 70, 94, 69, 86, 24, 89, 18, 124, 114, 126, 119, 54, 107, 10}, "d21738", 1));
                    frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{99, 99, 35, 115, 43, 36, 19, 67, 7, 87, 19, 23, 64, 88, 20, 81, 57, 17, 65, 88, 5, 83, 3, 23, 64, 12, 69, 123, 40, 66, 8}, "31b4fe", 2));
                    frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{118, 52, 117, 112, 98, 114, 68, 50, 115, 120, 103, 16, 97, 39, 114, 125, 115, 23, 22, 9, 89, 88, 104, 68, 84, 4, 92, 84, 105, 90, 11, 2, 95, 83, 94, 83, 84, 18, 89, 94, 88, 104, 8, 9, 81, 21, 31, 68, 84, 4, 92, 84, 105, 94, 0, 70, 127, 123, 99, 117, 114, 35, 98, 17, 102, 101, 45, 43, 119, 103, 110, 16, 126, 35, 105, 29, 22, 94, 10, 16, 87, 89, 94, 84, 84, 18, 85, 85, 22, 126, 42, 50, 115, 114, 114, 98, 21, 40, 127, 101, 22, 121, 49, 42, 122, 21, 115, 117, 115, 39, 101, 125, 98, 23, 84, 79}, "5f0167df6570", 2));
                    invalidationTracker.syncTriggers$room_runtime_release(frameworkSQLiteDatabase);
                    invalidationTracker.cleanupStatement = frameworkSQLiteDatabase.compileStatement(C0000.decode(new byte[]{52, 53, 119, 34, 99, 119, 66, 68, 12, 9, 15, 62, 64, 87, 3, 9, 86, 60, 90, 93, 6, 95, 5, 15, 1, 0, 64, 95, 14, 11, 108, 15, 88, 85, 66, 101, 38, 50, 66, 8, 90, 64, 0, 9, 90, 7, 86, 70, 7, 82, 67, 91, 66, 81, 20, 97, 41, 32, 97, 38, 23, 91, 12, 64, 2, 10, 11, 5, 85, 66, 4, 1, 19, 94, 23, 3}, "ae3c72b6cfba46"));
                    invalidationTracker.initialized = true;
                }
            }
            List list = ((WorkDatabase_Impl) connectionPool.delegate).mCallbacks;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    CleanupCallback cleanupCallback = (CleanupCallback) ((WorkDatabase_Impl) connectionPool.delegate).mCallbacks.get(i);
                    cleanupCallback.getClass();
                    frameworkSQLiteDatabase.beginTransaction();
                    try {
                        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{113, 118, 47, 38, 96, 38, 66, 112, 101, 127, 116, 69, 79, 95, 67, 93, 70, 67, 6, 0, 20, 52, 42, 115, 101, 117, 25, 22, 76, 81, 69, 83, 21, 122, 45, 67, 28, 81, 78, 22, 4, 28, 25, 80, 17, 16, 112, 120, 113, 19, 75, 15, 85, 16, 22, 105, 82, 94, 72, 16, 93, 69, 84, 105, 65, 90, 14, 6, 20, 72, 66, 91, 94, 94, 80, 8, 77, 93, 110, 68, 80, 71, 6, 13, 64, 10, 13, 88, 104, 84, 76, 23, 89, 68, 88, 89, 91, 26, 67, 95, 20}, "53cc4cb6709e8016", 0.0f));
                        cleanupCallback.clock.getClass();
                        sb.append(System.currentTimeMillis() - WorkDatabaseKt.PRUNE_THRESHOLD_MILLIS);
                        sb.append(C0000.decode(new byte[]{70, 112, 124, 113, 67, 25, 106, 35, 40, 116, 37, 108, 18, 38, 124, 99, 40, 101, 26, 31, 74, 12, 9, 70, 34, 99, 41, 117, 18, 1, 86, 70, 3, 95, 86, 80, 13, 82, 64, 70, 51, 121, 35, 106, 119, 69, 19, 22, 70, 17, 66, 71, 6, 67, 92, 23, 17, 88, 21, 81, 70, 0, 108, 95, 2, 12, 91, 81, 67, 112, 119, 34, 68, 17, 70, 24, 18, 18, 92, 68, 13, 110, 65, 69, 6, 82, 102, 15, 0, 17, 40, 119, 102, 69, 122, 120, 70, 17, 18, 21, 67, 17, 25, 70, 68, 25, 53, 125, 126, 32, 112, 98, 70, 88, 86, 21, 37, 99, 118, 43, 68, 70, 9, 74, 89, 22, 67, 83, 5, 17, 101, 125, 38, 99, 124, 70, 23, 69, 7, 76, 87, 69, 122, 120, 70, 25, 0, 25, 67, 2, 21, 70, 81, 24, 79, 17}, "f125c19fd1f82e36", true));
                        frameworkSQLiteDatabase.execSQL(sb.toString());
                        frameworkSQLiteDatabase.setTransactionSuccessful();
                        frameworkSQLiteDatabase.endTransaction();
                    } catch (Throwable th3) {
                        frameworkSQLiteDatabase.endTransaction();
                        throw th3;
                    }
                }
            }
            this.configuration = null;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                CloseableKt.closeFinally(cursorQuery, th4);
                throw th5;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:? A[LOOP:3: B:11:0x0022->B:116:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x003a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0041  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    public void onUpgrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i, int i2) throws IOException {
        Set set;
        Iterable iterable;
        TreeMap treeMap;
        Set setKeySet;
        Iterator it;
        boolean z;
        Integer num;
        int i3;
        int iIntValue;
        int iIntValue2;
        ConnectionPool connectionPool = (ConnectionPool) this.delegate;
        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.configuration;
        if (databaseConfiguration != null) {
            ConnectionPool connectionPool2 = databaseConfiguration.migrationContainer;
            connectionPool2.getClass();
            if (i == i2) {
                iterable = EmptyList.INSTANCE;
            } else {
                boolean z2 = i2 > i;
                ArrayList arrayList = new ArrayList();
                int iIntValue3 = i;
                while (true) {
                    if (z2) {
                        if (iIntValue3 < i2) {
                            treeMap = (TreeMap) ((LinkedHashMap) connectionPool2.delegate).get(Integer.valueOf(iIntValue3));
                            if (treeMap != null) {
                                if (z2) {
                                    setKeySet = treeMap.descendingKeySet();
                                } else {
                                    setKeySet = treeMap.keySet();
                                }
                                it = setKeySet.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    num = (Integer) it.next();
                                    if (z2) {
                                        i3 = iIntValue3 + 1;
                                        iIntValue = num.intValue();
                                        if (i3 <= iIntValue && iIntValue <= i2) {
                                            arrayList.add(treeMap.get(num));
                                            iIntValue3 = num.intValue();
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        iIntValue2 = num.intValue();
                                        if (i2 <= iIntValue2 && iIntValue2 < iIntValue3) {
                                            arrayList.add(treeMap.get(num));
                                            iIntValue3 = num.intValue();
                                            z = true;
                                            break;
                                            break;
                                        }
                                    }
                                }
                                if (!z) {
                                }
                            }
                            iterable = null;
                        } else {
                            iterable = arrayList;
                        }
                    } else if (iIntValue3 > i2) {
                        treeMap = (TreeMap) ((LinkedHashMap) connectionPool2.delegate).get(Integer.valueOf(iIntValue3));
                        if (treeMap != null) {
                            if (z2) {
                                setKeySet = treeMap.descendingKeySet();
                            } else {
                                setKeySet = treeMap.keySet();
                            }
                            it = setKeySet.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    z = false;
                                    break;
                                    break;
                                }
                                num = (Integer) it.next();
                                if (z2) {
                                    i3 = iIntValue3 + 1;
                                    iIntValue = num.intValue();
                                    if (i3 <= iIntValue) {
                                        continue;
                                    }
                                } else {
                                    iIntValue2 = num.intValue();
                                    if (i2 <= iIntValue2) {
                                        continue;
                                    }
                                }
                            }
                            if (!z) {
                            }
                        }
                        iterable = null;
                    } else {
                        iterable = arrayList;
                    }
                }
            }
            if (iterable != null) {
                ListBuilder listBuilder = new ListBuilder();
                Cursor cursorQuery = frameworkSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
                while (cursorQuery.moveToNext()) {
                    try {
                        listBuilder.add(cursorQuery.getString(0));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(cursorQuery, th);
                            throw th2;
                        }
                    }
                }
                cursorQuery.close();
                if (listBuilder.backing != null) {
                    throw new IllegalStateException();
                }
                listBuilder.checkIsMutable();
                listBuilder.isReadOnly = true;
                if (listBuilder.length <= 0) {
                    listBuilder = ListBuilder.Empty;
                }
                Iterator it2 = listBuilder.iterator();
                while (true) {
                    ListBuilder.Itr itr = (ListBuilder.Itr) it2;
                    if (!itr.hasNext()) {
                        break;
                    }
                    String str = (String) itr.next();
                    if (str.startsWith("room_fts_content_sync_")) {
                        frameworkSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS ".concat(str));
                    }
                }
                Iterator it3 = iterable.iterator();
                while (it3.hasNext()) {
                    ((Migration) it3.next()).migrate(frameworkSQLiteDatabase);
                }
                zzu zzuVarOnValidateSchema = ConnectionPool.onValidateSchema(frameworkSQLiteDatabase);
                if (!zzuVarOnValidateSchema.zzd) {
                    throw new IllegalStateException("Migration didn't properly handle: " + zzuVarOnValidateSchema.zza);
                }
                updateIdentity(frameworkSQLiteDatabase);
                return;
            }
        }
        DatabaseConfiguration databaseConfiguration2 = (DatabaseConfiguration) this.configuration;
        if (databaseConfiguration2 != null) {
            if (!((i <= i2 || !databaseConfiguration2.allowDestructiveMigrationOnDowngrade) && databaseConfiguration2.requireMigration && ((set = databaseConfiguration2.migrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(i))))) {
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
                frameworkSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preference`");
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) connectionPool.delegate;
                List list = workDatabase_Impl.mCallbacks;
                if (list != null) {
                    int size = list.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((CleanupCallback) workDatabase_Impl.mCallbacks.get(i4)).getClass();
                    }
                }
                ConnectionPool.createAllTables(frameworkSQLiteDatabase);
                return;
            }
        }
        throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 3:
                StringBuilder sb = new StringBuilder();
                if (((Protocol) this.configuration) == Protocol.HTTP_1_0) {
                    sb.append(C0000.decode(new byte[]{126, 53, 96, 103, 22, 6, 26, 1}, "6a479741e2bdd2", 3));
                } else {
                    sb.append(C0000.decode(new byte[]{43, 48, 100, 100, 75, 1, 29, 80}, "cd04d03a45d1", 4));
                }
                sb.append(' ');
                sb.append(this.version);
                sb.append(' ');
                sb.append((String) this.delegate);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void updateIdentity(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{118, 101, 35, 117, 55, 113, 22, 102, 115, 33, 127, 114, 21, 126, 115, 23, 40, 123, 55, 20, 115, 106, 123, 48, 103, 100, 21, 69, 90, 88, 11, 107, 14, 85, 69, 70, 87, 17, 108, 67, 84, 85, 89, 82, 70, 28, 10, 80, 22, 123, 124, 55, 118, 112, 112, 101, 21, 103, 52, 125, 46, 117, 100, 107, 18, 40, 118, 110, 25, 94, 81, 82, 8, 64, 10, 64, 79, 109, 90, 2, 64, 95, 21, 99, 112, 111, 50, 29}, "57f4c4622c3757"));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{112, 122, 48, 117, 96, 55, 66, 126, 102, 18, 107, 113, 51, 124, 115, 32, 39, 17, 125, 124, 109, 123, 67, 66, 93, 12, 15, 110, 89, 83, 74, 64, 6, 66, 109, 23, 3, 83, 88, 87, 25, 28, 10, 84, 30, 10, 6, 84, 90, 70, 80, 64, 26, 111, 90, 2, 17, 89, 29, 18, 111, 117, 47, 101, 119, 48, 74, 5, 6, 30, 25, 19, 84, 84, 5, 80, 6, 3, 5, 84, 8, 86, 7, 8, 0, 0, 91, 84, 1, 0, 15, 12, 1, 6, 86, 0, 4, 8, 82, 86, 92, 6, 0, 82, 21, 74}, "94c02cb142", true));
    }

    public /* synthetic */ RoomOpenHelper(Object obj, int i, Serializable serializable, int i2) {
        this.$r8$classId = i2;
        this.configuration = obj;
        this.version = i;
        this.delegate = serializable;
    }

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, ConnectionPool connectionPool) {
        this.$r8$classId = 0;
        this.$r8$classId = 0;
        this.version = 20;
        this.configuration = databaseConfiguration;
        this.delegate = connectionPool;
    }
}
