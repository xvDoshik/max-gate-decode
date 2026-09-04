package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.text.CharsKt;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DiagnosticsWorker extends Worker {
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        Dispatcher dispatcher;
        WorkLauncherImpl workLauncherImpl;
        WorkTagDao_Impl workTagDao_Impl;
        WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(this.mAppContext);
        WorkDatabase workDatabase = instance$1.mWorkDatabase;
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        WorkLauncherImpl workLauncherImplWorkNameDao = workDatabase.workNameDao();
        WorkTagDao_Impl workTagDao_ImplWorkTagDao = workDatabase.workTagDao();
        Dispatcher dispatcherSystemIdInfoDao = workDatabase.systemIdInfoDao();
        ((SystemClock) instance$1.mConfiguration.clock).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        workSpecDao_ImplWorkSpecDao.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{53, 112, 120, 35, 117, 49, 68, 18, 20, 32, 97, 44, 41, 24, 71, 11, 20, 94, 71, 22, 83, 6, 68, 111, 124, 35, 97, 38, 68, 84, 81, 23, 18, 106, 81, 8, 71, 16, 1, 77, 81, 57, 71, 10, 9, 93, 16, 90, 91, 21, 11, 70, 119, 43, 32, 24, 71, 18, 82, 23, 1, 24, 121, 42, 70, 29, 6, 74, 22, 86, 72, 24, 1, 79, 19, 44, 54, 124, 117, 54, 70, 119, 109, 70, 90, 4, 23, 76, 107, 3, 93, 18, 17, 93, 69, 1, 57, 65, 93, 11, 83, 69, 32, 125, 103, 37}, "f54f6ed84f3cd80d", false), 1);
        roomSQLiteQueryAcquire.bindLong(1, jCurrentTimeMillis);
        WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{12, 85}, "e11a0464"));
            int columnIndexOrThrow2 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 77, 7, 23, 4}, "d9fca4bd5874"));
            int columnIndexOrThrow3 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{68, 9, 17, 94, 7, 71, 60, 0, 95, 7, 16, 70, 61, 91, 2, 14, 86}, "3fc5b5cc", 6));
            int columnIndexOrThrow4 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{89, 91, 71, 67, 65, 108, 15, 3, 69, 85, 1, 70, 58, 2, 8, 0, 67, 70, 104, 88, 84, 94, 7}, "057653bf72d4eada", true));
            int columnIndexOrThrow5 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{89, 90, 71, 64, 77}, "047591149f0f", false));
            int columnIndexOrThrow6 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{91, 22, 65, 65, 71, 70}, "4c5122aa", false));
            int columnIndexOrThrow7 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{11, 12, 8, 69, 91, 2, 94, 60, 80, 6, 13, 86, 31}, "bba12c2c4ca7f448"));
            int columnIndexOrThrow8 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{11, 13, 17, 82, 69, 21, 84, 15, 61, 7, 16, 69, 86, 23, 92, 12, 12}, "bce77c5c", 0.0f));
            int columnIndexOrThrow9 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{81, 85, 87, 27, 107, 5, 66, 75, 83, 23, 93, 14, 89}, "792c4a", 1));
            int columnIndexOrThrow10 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{66, 70, 15, 59, 87, 16, 18, 84, 92, 66, 21, 61, 83, 92, 20, 10, 66}, "03ad6df112ab", 6));
            int columnIndexOrThrow11 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{80, 87, 86, 9, 93, 82, 84, 111, 65, 92, 85, 91, 82, 74}, "265b2420139213"));
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow12 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{87, 87, 90, 13, 12, 5, 83, 105, 93, 3, 15, 2, 76, 105, 93, 19, 17, 2, 65, 95, 86, 8}, "569fcc"));
                int columnIndexOrThrow13 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{85, 80, 69, 71, 57, 0, 90, 69, 65, 1, 76, 84, 105, 71, 15, 8, 81}, "9163fe444d", true));
                int columnIndexOrThrow14 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{11, 89, 10, 94, 85, 67, 9, 61, 16, 6, 21, 82, 8, 68, 13, 88, 86, 105, 0, 23, 16, 2, 21, 94, 9, 94}, "f0d786dbbca7", true));
                int columnIndexOrThrow15 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{17, 1, 13, 86, 87, 68, 85, 80, 106, 75, 93, 71, 16, 84, 16, 70, 7, 6, 58, 82, 71}, "bbe331955986e1c2", false));
                int columnIndexOrThrow16 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{68, 16, 88, 104, 13, 15, 105, 3, 89, 69, 1, 6, 68, 10, 67, 89, 0}, "6e67da", 0.0f));
                int columnIndexOrThrow17 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{11, 16, 22, 58, 95, 84, 61, 73, 68, 90, 16, 4, 61, 21, 95, 94, 11, 91, 72}, "debe02b815", 5));
                int columnIndexOrThrow18 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 93, 74, 94, 90, 84, 108, 2, 92, 70, 95, 76}, "1887503a33", 6));
                int columnIndexOrThrow19 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{2, 93, 91, 85, 65, 89, 64, 81, 11, 91}, "e8503848d5", 6));
                int columnIndexOrThrow20 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{12, 92, 27, 69, 102, 66, 6, 80, 80, 6, 69, 95, 84, 58, 70, 88, 15, 92, 60, 94, 79, 84, 23, 74, 92, 6, 85}, "b9c191e85b031e21", 2));
                int columnIndexOrThrow21 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{92, 1, 28, 22, 108, 16, 83, 12, 4, 85, 71, 8, 1, 61, 71, 10, 93, 1, 62, 94, 68, 1, 22, 16, 90, 7, 85, 59, 6, 84, 92, 1, 22, 3, 71, 10, 95, 10}, "2ddb3c0da1"));
                int columnIndexOrThrow22 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{70, 76, 89, 73, 104, 17, 3, 85, 70, 87, 88}, "58697cf4", 0.0f));
                int columnIndexOrThrow23 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{70, 0, 16, 68, 10, 20, 93, 81, 109, 86, 87, 71, 71, 11, 16, 83, 107, 17, 24, 65, 6}, "4ea1cf8528230db8", 1));
                int columnIndexOrThrow24 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{64, 3, 18, 17, 89, 22, 87, 21, 60, 7, 88, 5, 64, 1, 10, 10, 87}, "2fcd0d", false));
                int columnIndexOrThrow25 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{66, 83, 21, 71, 81, 16, 93, 21, 61, 83, 87, 78, 8, 91, 3, 111, 89, 82, 8, 87}, "06d28b8fb728a8f0", 0.0f));
                int columnIndexOrThrow26 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 7, 64, 64, 92, 19, 85, 71, 58, 3, 89, 22, 69, 80, 71, 24, 111, 90, 10, 21, 103, 14, 94, 66}, "8b155a04ea", true));
                int columnIndexOrThrow27 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 84, 70, 65, 93, 19, 4, 16, 58, 66, 67, 91, 70, 0, 6, 6, 58, 95, 88, 64, 107, 13, 14, 20}, "e1744aac", 0.0f));
                int columnIndexOrThrow28 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{68, 68, 91, 95, 83, 84, 66, 105, 81, 87, 90, 69, 85, 88, 70, 103, 65, 65, 84, 87, 70, 93, 107, 85, 85, 90, 83, 65}, "062841", 1));
                int columnIndexOrThrow29 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{70, 68, 81, 2, 4, 92, 16, 105, 85, 85, 64, 110, 81, 89, 86, 17, 6, 87, 22, 105, 92, 81, 84, 80, 75}, "268ec9b68481", true));
                int columnIndexOrThrow30 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{90, 11, 15, 65, 92, 89, 76, 62, 76, 22, 8, 106, 77, 69, 81, 6, 94, 1, 19, 70}, "9da5978a", 0.0f));
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    int iIntToState = Headers.Companion.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j = cursorQuery.getLong(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i2 = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = Headers.Companion.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    int i3 = i;
                    long j6 = cursorQuery.getLong(i3);
                    int i4 = columnIndexOrThrow;
                    int i5 = columnIndexOrThrow15;
                    long j7 = cursorQuery.getLong(i5);
                    columnIndexOrThrow15 = i5;
                    int i6 = columnIndexOrThrow16;
                    boolean z = cursorQuery.getInt(i6) != 0;
                    columnIndexOrThrow16 = i6;
                    int i7 = columnIndexOrThrow17;
                    int iIntToOutOfQuotaPolicy = Headers.Companion.intToOutOfQuotaPolicy(cursorQuery.getInt(i7));
                    columnIndexOrThrow17 = i7;
                    int i8 = columnIndexOrThrow18;
                    int i9 = cursorQuery.getInt(i8);
                    columnIndexOrThrow18 = i8;
                    int i10 = columnIndexOrThrow19;
                    int i11 = cursorQuery.getInt(i10);
                    columnIndexOrThrow19 = i10;
                    int i12 = columnIndexOrThrow20;
                    long j8 = cursorQuery.getLong(i12);
                    columnIndexOrThrow20 = i12;
                    int i13 = columnIndexOrThrow21;
                    int i14 = cursorQuery.getInt(i13);
                    columnIndexOrThrow21 = i13;
                    int i15 = columnIndexOrThrow22;
                    int i16 = cursorQuery.getInt(i15);
                    columnIndexOrThrow22 = i15;
                    int i17 = columnIndexOrThrow23;
                    int iIntToNetworkType = Headers.Companion.intToNetworkType(cursorQuery.getInt(i17));
                    columnIndexOrThrow23 = i17;
                    int i18 = columnIndexOrThrow24;
                    boolean z2 = cursorQuery.getInt(i18) != 0;
                    columnIndexOrThrow24 = i18;
                    int i19 = columnIndexOrThrow25;
                    boolean z3 = cursorQuery.getInt(i19) != 0;
                    columnIndexOrThrow25 = i19;
                    int i20 = columnIndexOrThrow26;
                    boolean z4 = cursorQuery.getInt(i20) != 0;
                    columnIndexOrThrow26 = i20;
                    int i21 = columnIndexOrThrow27;
                    boolean z5 = cursorQuery.getInt(i21) != 0;
                    columnIndexOrThrow27 = i21;
                    int i22 = columnIndexOrThrow28;
                    long j9 = cursorQuery.getLong(i22);
                    columnIndexOrThrow28 = i22;
                    int i23 = columnIndexOrThrow29;
                    long j10 = cursorQuery.getLong(i23);
                    columnIndexOrThrow29 = i23;
                    int i24 = columnIndexOrThrow30;
                    if (!cursorQuery.isNull(i24)) {
                        blob = cursorQuery.getBlob(i24);
                    }
                    columnIndexOrThrow30 = i24;
                    arrayList.add(new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, Headers.Companion.byteArrayToSetOfTriggers(blob)), i2, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i9, i11, j8, i14, i16));
                    columnIndexOrThrow = i4;
                    i = i3;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                ArrayList runningWork = workSpecDao_ImplWorkSpecDao.getRunningWork();
                ArrayList allEligibleWorkSpecsForScheduling = workSpecDao_ImplWorkSpecDao.getAllEligibleWorkSpecsForScheduling();
                if (arrayList.isEmpty()) {
                    dispatcher = dispatcherSystemIdInfoDao;
                    workLauncherImpl = workLauncherImplWorkNameDao;
                    workTagDao_Impl = workTagDao_ImplWorkTagDao;
                } else {
                    SystemClock systemClock = SystemClock.get();
                    int i25 = DiagnosticsWorkerKt.$r8$clinit;
                    systemClock.getClass();
                    SystemClock systemClock2 = SystemClock.get();
                    dispatcher = dispatcherSystemIdInfoDao;
                    workLauncherImpl = workLauncherImplWorkNameDao;
                    workTagDao_Impl = workTagDao_ImplWorkTagDao;
                    DiagnosticsWorkerKt.access$workSpecRows(workLauncherImpl, workTagDao_Impl, dispatcher, arrayList);
                    systemClock2.getClass();
                }
                if (!runningWork.isEmpty()) {
                    SystemClock systemClock3 = SystemClock.get();
                    int i26 = DiagnosticsWorkerKt.$r8$clinit;
                    systemClock3.getClass();
                    SystemClock systemClock4 = SystemClock.get();
                    DiagnosticsWorkerKt.access$workSpecRows(workLauncherImpl, workTagDao_Impl, dispatcher, runningWork);
                    systemClock4.getClass();
                }
                if (!allEligibleWorkSpecsForScheduling.isEmpty()) {
                    SystemClock systemClock5 = SystemClock.get();
                    int i27 = DiagnosticsWorkerKt.$r8$clinit;
                    systemClock5.getClass();
                    SystemClock systemClock6 = SystemClock.get();
                    DiagnosticsWorkerKt.access$workSpecRows(workLauncherImpl, workTagDao_Impl, dispatcher, allEligibleWorkSpecsForScheduling);
                    systemClock6.getClass();
                }
                return new ListenableWorker.Result.Success(Data.EMPTY);
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }
}
