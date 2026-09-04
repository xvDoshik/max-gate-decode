package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.impl.WorkDatabase_Impl;
import java.util.ArrayList;
import kotlin.text.CharsKt;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkSpecDao_Impl {
    public final WorkDatabase_Impl __db;
    public final WorkTagDao_Impl.AnonymousClass1 __insertionAdapterOfWorkSpec;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfDelete;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfIncrementPeriodCount;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfMarkWorkSpecScheduled;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfResetScheduledState;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfResetWorkSpecRunAttemptCount;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfSetCancelledState;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfSetLastEnqueueTime;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfSetOutput;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfSetState;
    public final WorkTagDao_Impl.AnonymousClass2 __preparedStmtOfSetStopReason;
    public final WorkTagDao_Impl.AnonymousClass2 __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(WorkDatabase_Impl workDatabase_Impl) {
        this.__db = workDatabase_Impl;
        this.__insertionAdapterOfWorkSpec = new WorkTagDao_Impl.AnonymousClass1(workDatabase_Impl, 6);
        this.__updateAdapterOfWorkSpec = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 13);
        this.__preparedStmtOfDelete = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 14);
        this.__preparedStmtOfSetState = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 15);
        this.__preparedStmtOfSetCancelledState = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 16);
        this.__preparedStmtOfIncrementPeriodCount = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 17);
        this.__preparedStmtOfSetOutput = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 18);
        this.__preparedStmtOfSetLastEnqueueTime = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 19);
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 20);
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 5);
        new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 6);
        this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 7);
        this.__preparedStmtOfMarkWorkSpecScheduled = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 8);
        this.__preparedStmtOfResetScheduledState = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 9);
        new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 10);
        new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 11);
        this.__preparedStmtOfSetStopReason = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 12);
    }

    public final void delete(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = this.__preparedStmtOfDelete;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 1);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final ArrayList getAllEligibleWorkSpecsForScheduling() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{55, 125, 41, 35, 115, 49, 69, 31, 68, 36, 101, 46, 44, 21, 20, 88, 22, 83, 22, 22, 85, 6, 69, 98, 44, 39, 101, 36, 65, 70, 23, 86, 16, 93, 88, 86, 16, 42, 55, 113, 33, 48, 23, 35, 56, 21, 15, 86, 23, 76, 58, 3, 94, 20, 16, 80, 17, 7, 104, 21, 8, 88, 6, 23, 40, 113, 40, 47, 100, 69, 90}, "d8ef0ee5db7aa5c7", false), 1);
        roomSQLiteQueryAcquire.bindLong(1, 200);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{81, 7}, "8cd7c4a70b3d", 2));
            int columnIndexOrThrow2 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{18, 64, 84, 66, 82}, "a4567e", true));
            int columnIndexOrThrow3 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{69, 93, 23, 8, 0, 67, 103, 7, 94, 83, 22, 16, 58, 95, 89, 9, 87}, "22ece18d", 0));
            int columnIndexOrThrow4 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{95, 94, 73, 68, 17, 58, 11, 6, 68, 87, 92, 67, 58, 6, 10, 2, 69, 67, 102, 95, 4, 8, 3}, "6091eefc", 0.0f));
            int columnIndexOrThrow5 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{15, 86, 20, 65, 22}, "f8d4ba", false));
            int columnIndexOrThrow6 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{88, 22, 70, 70, 23, 23}, "7c26bc764e"));
            int columnIndexOrThrow7 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{8, 91, 12, 23, 80, 81, 9, 111, 81, 81, 14, 80, 24}, "a5ec90e054b1", true));
            int columnIndexOrThrow8 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{12, 95, 64, 83, 67, 71, 5, 8, 106, 5, 66, 69, 4, 21, 12, 94, 90}, "e14611dd5a77ea", true));
            int columnIndexOrThrow9 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{4, 95, 86, 79, 108, 87, 67, 16, 2, 64, 92, 93, 92}, "b337336bc4522689", true));
            int columnIndexOrThrow10 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{68, 23, 15, 106, 81, 64, 64, 81, 11, 64, 66, 61, 2, 90, 69, 90, 64}, "6ba50444f0", 0.0f));
            int columnIndexOrThrow11 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{80, 3, 82, 91, 94, 94, 83, 59, 67, 90, 94, 11, 82, 73}, "2b10185d35"));
            int columnIndexOrThrow12 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{84, 3, 5, 90, 93, 85, 3, 105, 82, 82, 13, 4, 27, 57, 81, 68, 68, 3, 18, 88, 93, 93}, "6bf123e667aebf51"));
            int columnIndexOrThrow13 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{13, 80, 21, 23, 60, 6, 93, 65, 17, 80, 20, 84, 57, 23, 10, 14, 86}, "a1fccc30d5", 0.0f));
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{91, 10, 8, 91, 15, 71, 91, 58, 68, 6, 18, 87, 12, 70, 95, 10, 88, 60, 2, 71, 16, 83, 66, 12, 89, 13}, "6cf2b26e", 1));
                int columnIndexOrThrow15 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 84, 81, 6, 2, 66, 91, 87, 102, 69, 92, 18, 19, 82, 68, 70, 92, 83, 102, 2, 18}, "979cf772", 0.0f));
                int columnIndexOrThrow16 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 23, 91, 111, 81, 13, 105, 80, 91, 19, 85, 3, 22, 11, 77, 12, 81}, "8b508c664a0ddd", false));
                int columnIndexOrThrow17 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{93, 20, 64, 111, 94, 3, 105, 23, 71, 14, 64, 81, 110, 21, 89, 10, 91, 2, 77}, "2a401e6f", 0.0f));
                int columnIndexOrThrow18 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{67, 1, 16, 11, 89, 92, 58, 80, 90, 69, 95, 70}, "3dbb68e35012", false));
                int columnIndexOrThrow19 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{87, 0, 12, 7, 20, 5, 68, 12, 13, 12}, "0ebbfd", 0.0f));
                int columnIndexOrThrow20 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{94, 0, 77, 22, 102, 69, 91, 14, 1, 81, 16, 91, 81, 111, 68, 12, 88, 7, 102, 89, 78, 3, 22, 71, 12, 83, 81}, "0e5b968fd5e740", 2));
                int columnIndexOrThrow21 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{88, 85, 76, 18, 58, 16, 82, 80, 81, 81, 66, 92, 83, 111, 64, 15, 8, 6, 110, 87, 66, 80, 69, 66, 95, 84, 81, 57, 2, 6, 95, 93, 70, 84, 67, 89, 89, 94}, "604fec184570"));
                int columnIndexOrThrow22 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 22, 9, 67, 106, 67, 86, 85, 70, 93, 92}, "9bf35134522e5c", true));
                int columnIndexOrThrow23 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 4, 73, 19, 92, 19, 93, 81, 107, 95, 85, 71, 19, 94, 67, 9, 58, 21, 65, 22, 80}, "ea8f5a854103d11b", 0.0f));
                int columnIndexOrThrow24 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 93, 71, 67, 88, 23, 1, 66, 108, 91, 94, 87, 67, 2, 13, 95, 84}, "38661ed1", 0.0f));
                int columnIndexOrThrow25 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{71, 84, 16, 71, 81, 69, 6, 70, 59, 2, 80, 71, 8, 81, 93, 104, 10, 81, 8, 3}, "51a287c5df"));
                int columnIndexOrThrow26 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 86, 20, 16, 91, 17, 84, 17, 103, 81, 4, 17, 70, 6, 67, 27, 103, 93, 10, 17, 109, 15, 94, 21}, "83ee2c1b"));
                int columnIndexOrThrow27 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{71, 0, 18, 23, 8, 65, 80, 22, 60, 17, 21, 92, 71, 4, 4, 7, 62, 93, 90, 17, 60, 14, 14, 68}, "5ecba3"));
                int columnIndexOrThrow28 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{67, 67, 13, 95, 82, 85, 70, 58, 7, 92, 89, 69, 1, 86, 65, 111, 65, 21, 0, 82, 67, 84, 59, 92, 80, 92, 85, 28}, "71d8504ed3", false));
                int columnIndexOrThrow29 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{66, 69, 93, 1, 5, 84, 22, 102, 95, 80, 78, 61, 91, 11, 10, 65, 83, 89, 64, 57, 6, 84, 8, 88, 75}, "674fb1d9216b8dd5", 7));
                int columnIndexOrThrow30 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{81, 88, 94, 68, 80, 13, 21, 110, 71, 69, 89, 111, 65, 17, 8, 86, 85, 82, 66, 67}, "27005ca1", 0.0f));
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
                return arrayList;
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

    public final ArrayList getAllUnfinishedWork() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{107, 118, 42, 124, 37, 102, 17, 80, 7, 25, 35, 98, 43, 122, 65, 22, 87, 65, 13, 74, 22, 87, 82, 25, 52, 113, 32, 98, 33, 23, 18, 21, 89, 71, 3, 25, 40, 125, 101, 25, 42, 119, 69, 24, 86, 27, 65, 82, 20, 19, 83, 16}, "83f9f219c9e0d7aa"), 0);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public final ArrayList getEligibleWorkForScheduling(int i) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{97, 125, 120, 119, 33, 50, 18, 18, 20, 116, 48, 41, 127, 24, 67, 93, 16, 13, 65, 72, 81, 81, 66, 49, 122, 125, 102, 119, 66, 21, 70, 89, 64, 87, 95, 86, 18, 121, 122, 118, 66, 21, 81, 80, 81, 86, 23, 10, 87, 103, 70, 87, 19, 19, 87, 75, 64, 87, 6, 57, 83, 76, 9, 31, 83, 70, 125, 106, 112, 119, 48, 70, 112, 97, 20, 94, 3, 21, 70, 103, 81, 92, 19, 19, 87, 77, 81, 109, 22, 15, 95, 93, 20, 126, 43, 43, 123, 108, 20, 26, 49, 35, 126, 125, 119, 102, 66, 43, 115, 96, 28, 13, 79, 37, 125, 109, 122, 102, 74, 76, 27, 20, 20, 2, 75, 70, 116, 106, 123, 127, 66, 17, 93, 74, 95, 65, 18, 3, 81, 24, 99, 122, 39, 52, 119, 24, 71, 81, 10, 3, 86, 77, 88, 87, 61, 20, 87, 73, 65, 87, 17, 18, 87, 92, 107, 83, 22, 90, 12, 21, 5, 18, 35, 40, 118, 24, 120, 119, 44, 33, 102, 112, 28, 81, 13, 8, 70, 93, 90, 70, 61, 19, 64, 81, 107, 70, 16, 15, 85, 95, 81, 64, 17, 79, 15, 8, 20, 115, 44, 34, 18, 75, 64, 83, 22, 3, 18, 118, 123, 102, 66, 47, 124, 24, 28, 0, 78, 70, 1, 20, 20, 7, 75, 79}, "2842bf", 1), 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{91, 87}, "23d1cfcfbc", 5));
            int columnIndexOrThrow2 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{70, 64, 80, 77, 80}, "54195ae9d08d", 0.0f));
            int columnIndexOrThrow3 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{21, 89, 20, 91, 85, 67, 61, 85, 10, 81, 67, 66, 61, 88, 7, 93, 85}, "b6f001"));
            int columnIndexOrThrow4 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{93, 95, 72, 70, 17, 58, 90, 82, 70, 86, 93, 65, 58, 6, 91, 86, 71, 66, 103, 93, 4, 8, 82}, "4183ee77", 0));
            int columnIndexOrThrow5 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{88, 86, 73, 19, 70}, "189f23832c9f", 0.0f));
            int columnIndexOrThrow6 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{90, 22, 22, 22, 65, 70}, "5cbf42d5c56a", false));
            int columnIndexOrThrow7 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{15, 8, 88, 68, 95, 2, 92, 61, 2, 3, 93, 81, 79}, "ff106c0b", 5));
            int columnIndexOrThrow8 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{80, 92, 17, 6, 67, 18, 89, 88, 108, 5, 64, 70, 88, 70, 12, 12, 95}, "92ec1d843a54", false));
            int columnIndexOrThrow9 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{5, 89, 0, 77, 110, 0, 71, 66, 81, 69, 95, 91, 15}, "c5e51d200164ad", 6));
            int columnIndexOrThrow10 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 17, 11, 110, 3, 22, 64, 93, 92, 69, 67, 104, 91, 11, 16, 95, 22}, "8de1bb481577", true));
            int columnIndexOrThrow11 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{7, 89, 5, 14, 11, 86, 82, 103, 71, 93, 95, 90, 82, 79}, "e8fed04872331602", 0.0f));
            int columnIndexOrThrow12 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{0, 80, 87, 94, 88, 0, 4, 110, 80, 80, 91, 7, 27, 110, 80, 64, 69, 7, 22, 88, 91, 91}, "b1457f"));
            int columnIndexOrThrow13 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{95, 87, 71, 16, 102, 82, 93, 71, 65, 1, 76, 82, 108, 66, 93, 9, 92}, "364d97", 0.0f));
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{11, 13, 10, 93, 94, 68, 15, 109, 20, 1, 16, 81, 93, 69, 11, 93, 8, 59, 0, 65, 65, 80, 22, 91, 9, 10}, "fdd431b2", false));
                int columnIndexOrThrow15 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{68, 6, 92, 86, 5, 17, 8, 7, 102, 68, 0, 70, 16, 82, 68, 17, 81, 87, 62, 5, 16}, "7e43addb96e7e7", false));
                int columnIndexOrThrow16 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{70, 66, 15, 62, 10, 8, 103, 0, 86, 65, 4, 94, 70, 88, 20, 15, 7}, "47aacf8f93a9", 0.0f));
                int columnIndexOrThrow17 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{87, 23, 66, 111, 95, 7, 110, 18, 77, 13, 66, 81, 111, 17, 94, 15, 81, 1, 79}, "8b600a1c", true));
                int columnIndexOrThrow18 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{18, 1, 17, 88, 94, 87, 106, 82, 88, 19, 87, 68}, "bdc113517f90", 2));
                int columnIndexOrThrow19 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{95, 7, 92, 4, 22, 83, 76, 11, 93, 15}, "8b2ad2", 0.0f));
                int columnIndexOrThrow20 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{91, 92, 64, 66, 106, 22, 83, 12, 6, 85, 19, 9, 80, 102, 76, 95, 88, 0, 111, 11, 21, 84, 20, 23, 92, 93, 93}, "59865e0dc1fe", 0.0f));
                int columnIndexOrThrow21 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{92, 84, 26, 76, 106, 18, 82, 9, 4, 93, 23, 88, 3, 59, 64, 90, 95, 84, 61, 87, 67, 4, 67, 19, 8, 93, 7, 107, 1, 1, 90, 86, 64, 80, 22, 81, 90, 15}, "21b85a1aa9b4fd43"));
                int columnIndexOrThrow22 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 68, 13, 20, 59, 68, 4, 85, 64, 11, 94}, "90bdd6a43d066a5a", 7));
                int columnIndexOrThrow23 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{75, 7, 64, 20, 94, 69, 0, 5, 61, 90, 80, 68, 64, 14, 71, 89, 102, 22, 72, 17, 82}, "9b1a77eab4507a52", 3));
                int columnIndexOrThrow24 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{70, 4, 20, 70, 12, 71, 6, 17, 57, 87, 91, 5, 70, 6, 12, 93, 2}, "4ae3e5cbf43d"));
                int columnIndexOrThrow25 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{75, 93, 72, 66, 15, 68, 87, 68, 102, 5, 6, 18, 88, 85, 92, 103, 80, 83, 10, 83}, "9897f6279acd16"));
                int columnIndexOrThrow26 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{20, 3, 68, 70, 92, 74, 92, 21, 107, 1, 82, 16, 18, 3, 71, 74, 106, 86, 86, 18, 107, 15, 92, 19}, "ff53589f4c3d", false));
                int columnIndexOrThrow27 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 3, 18, 77, 93, 70, 84, 65, 108, 21, 23, 87, 70, 85, 86, 87, 108, 8, 12, 76, 107, 88, 94, 69}, "3fc84412"));
                int columnIndexOrThrow28 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 67, 13, 83, 1, 80, 16, 110, 90, 92, 91, 71, 87, 15, 64, 103, 22, 65, 0, 85, 18, 80, 61, 85, 92, 95, 84, 74}, "c1d4f5b193532a48", 0.0f));
                int columnIndexOrThrow29 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{69, 22, 13, 2, 80, 93, 23, 60, 88, 80, 76, 106, 82, 11, 10, 17, 82, 86, 17, 60, 81, 84, 88, 84, 72}, "1dde78ec5145", true));
                int columnIndexOrThrow30 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{6, 87, 87, 64, 87, 91, 69, 62, 77, 23, 95, 58, 66, 22, 12, 95, 94, 81, 64, 70}, "e894251a8e6e6d", 0.0f));
                int i2 = columnIndexOrThrow14;
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
                    int i3 = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = Headers.Companion.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    int i4 = i2;
                    long j6 = cursorQuery.getLong(i4);
                    int i5 = columnIndexOrThrow;
                    int i6 = columnIndexOrThrow15;
                    long j7 = cursorQuery.getLong(i6);
                    columnIndexOrThrow15 = i6;
                    int i7 = columnIndexOrThrow16;
                    boolean z = cursorQuery.getInt(i7) != 0;
                    columnIndexOrThrow16 = i7;
                    int i8 = columnIndexOrThrow17;
                    int iIntToOutOfQuotaPolicy = Headers.Companion.intToOutOfQuotaPolicy(cursorQuery.getInt(i8));
                    columnIndexOrThrow17 = i8;
                    int i9 = columnIndexOrThrow18;
                    int i10 = cursorQuery.getInt(i9);
                    columnIndexOrThrow18 = i9;
                    int i11 = columnIndexOrThrow19;
                    int i12 = cursorQuery.getInt(i11);
                    columnIndexOrThrow19 = i11;
                    int i13 = columnIndexOrThrow20;
                    long j8 = cursorQuery.getLong(i13);
                    columnIndexOrThrow20 = i13;
                    int i14 = columnIndexOrThrow21;
                    int i15 = cursorQuery.getInt(i14);
                    columnIndexOrThrow21 = i14;
                    int i16 = columnIndexOrThrow22;
                    int i17 = cursorQuery.getInt(i16);
                    columnIndexOrThrow22 = i16;
                    int i18 = columnIndexOrThrow23;
                    int iIntToNetworkType = Headers.Companion.intToNetworkType(cursorQuery.getInt(i18));
                    columnIndexOrThrow23 = i18;
                    int i19 = columnIndexOrThrow24;
                    boolean z2 = cursorQuery.getInt(i19) != 0;
                    columnIndexOrThrow24 = i19;
                    int i20 = columnIndexOrThrow25;
                    boolean z3 = cursorQuery.getInt(i20) != 0;
                    columnIndexOrThrow25 = i20;
                    int i21 = columnIndexOrThrow26;
                    boolean z4 = cursorQuery.getInt(i21) != 0;
                    columnIndexOrThrow26 = i21;
                    int i22 = columnIndexOrThrow27;
                    boolean z5 = cursorQuery.getInt(i22) != 0;
                    columnIndexOrThrow27 = i22;
                    int i23 = columnIndexOrThrow28;
                    long j9 = cursorQuery.getLong(i23);
                    columnIndexOrThrow28 = i23;
                    int i24 = columnIndexOrThrow29;
                    long j10 = cursorQuery.getLong(i24);
                    columnIndexOrThrow29 = i24;
                    int i25 = columnIndexOrThrow30;
                    if (!cursorQuery.isNull(i25)) {
                        blob = cursorQuery.getBlob(i25);
                    }
                    columnIndexOrThrow30 = i25;
                    arrayList.add(new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, Headers.Companion.byteArrayToSetOfTriggers(blob)), i3, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i10, i12, j8, i15, i17));
                    columnIndexOrThrow = i5;
                    i2 = i4;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
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

    public final ArrayList getEligibleWorkForSchedulingWithContentUris() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{99, 35, 126, 33, 118, 97, 68, 18, 16, 32, 96, 43, 120, 21, 19, 87, 66, 13, 65, 20, 80, 86, 68, 111, 120, 35, 96, 33, 21, 70, 16, 89, 68, 3, 15, 84, 21, 116, 42, 124, 16, 21, 81, 12, 80, 81, 17, 84, 85, 57, 64, 1, 68, 64, 1, 75, 68, 3, 86, 59, 84, 65, 89, 21, 1, 70, 115, 42, 113, 21, 40, 125, 126, 33, 102, 44, 29, 86, 11, 86, 68, 3, 92, 16, 106, 64, 22, 81, 111, 18, 64, 13, 82, 82, 1, 74, 67, 79, 14, 90, 5, 21, 43, 106, 116, 35, 96, 68, 119, 108, 68, 84, 81, 21, 70, 59, 80, 91, 21, 77, 85, 19, 87, 59, 65, 92, 9, 93}, "0f2d55d8"), 0);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{90, 87}, "33e7a8", 0.0f));
            int columnIndexOrThrow2 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{66, 66, 86, 69, 83}, "16716968c6a4", false));
            int columnIndexOrThrow3 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 9, 75, 10, 82, 22, 61, 5, 13, 83, 69, 21, 102, 15, 86, 9, 7}, "6f9a7dbfa2", false));
            int columnIndexOrThrow4 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{89, 13, 66, 70, 69, 109, 8, 82, 67, 4, 1, 70, 111, 0, 94, 82, 66, 65, 58, 89, 80, 14, 1}, "0c2312e71cd4", 3));
            int columnIndexOrThrow5 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{10, 13, 70, 22, 67}, "cc6c76543b0f8760"));
            int columnIndexOrThrow6 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{94, 65, 64, 20, 23, 66}, "144db6", 3));
            int columnIndexOrThrow7 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{13, 90, 88, 68, 92, 89, 8, 107, 85, 85, 89, 89, 29}, "d41058", false));
            int columnIndexOrThrow8 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{93, 94, 67, 80, 65, 23, 85, 92, 104, 81, 70, 19, 85, 68, 94, 90, 93}, "40753a", 2));
            int columnIndexOrThrow9 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{5, 13, 81, 77, 102, 0, 22, 19, 85, 65, 80, 11, 13}, "ca459d"));
            int columnIndexOrThrow10 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{68, 22, 13, 58, 85, 69, 66, 0, 88, 73, 21, 103, 85, 12, 22, 11, 64}, "6cce416e59a8", 6));
            int columnIndexOrThrow11 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{80, 3, 7, 13, 86, 7, 84, 61, 20, 9, 85, 8, 81, 27}, "2bdf9a", 2));
            int columnIndexOrThrow12 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{82, 0, 82, 89, 90, 86, 80, 58, 80, 87, 90, 85, 29, 58, 84, 20, 67, 83, 65, 89, 89, 11}, "0a12506e4264de", 2));
            int columnIndexOrThrow13 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{92, 84, 74, 69, 107, 83, 12, 71, 22, 6, 70, 81, 102, 77, 89, 88, 92}, "059146b6cc3499", 0.0f));
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{8, 15, 11, 90, 89, 76, 90, 108, 23, 3, 17, 86, 90, 77, 94, 92, 11, 57, 1, 70, 70, 88, 67, 90, 10, 8}, "efe34973"));
                int columnIndexOrThrow15 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{17, 85, 91, 80, 5, 22, 14, 4, 111, 67, 6, 20, 23, 83, 64, 65, 4, 7, 61, 0, 68}, "b635acba01ce"));
                int columnIndexOrThrow16 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 67, 10, 108, 11, 86, 57, 2, 88, 64, 7, 6, 65, 89, 17, 93, 6}, "36d3b8fd72ba"));
                int columnIndexOrThrow17 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{93, 23, 70, 61, 95, 95, 111, 72, 20, 93, 68, 7, 106, 20, 91, 95, 91, 1, 75}, "2b2b0909a20f5d43"));
                int columnIndexOrThrow18 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{71, 82, 69, 80, 13, 84, 57, 87, 88, 66, 94, 64}, "7779b0f47704c95d", 0.0f));
                int columnIndexOrThrow19 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{1, 3, 13, 93, 16, 2, 65, 8, 87, 10}, "ffc8bc5a8d", true));
                int columnIndexOrThrow20 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{88, 86, 27, 66, 110, 67, 90, 90, 83, 87, 22, 90, 84, 111, 77, 91, 91, 86, 60, 89, 71, 85, 75, 64, 95, 87, 6}, "63c61092"));
                int columnIndexOrThrow21 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{94, 82, 65, 22, 58, 68, 6, 81, 85, 83, 76, 14, 0, 104, 17, 80, 93, 82, 102, 13, 19, 82, 23, 75, 89, 83, 92, 61, 2, 82, 11, 92, 66, 86, 77, 11, 10, 89}, "079be7e9", false));
                int columnIndexOrThrow22 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{21, 71, 13, 73, 109, 68, 7, 84, 23, 11, 94}, "f3b926b5dd04", false));
                int columnIndexOrThrow23 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{69, 81, 72, 67, 90, 16, 81, 2, 105, 90, 93, 18, 79, 87, 16, 88, 104, 64, 64, 70, 86}, "74963b4f648f88b3", false));
                int columnIndexOrThrow24 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{67, 81, 73, 77, 81, 74, 84, 22, 105, 1, 93, 7, 74, 1, 88, 90, 95}, "1488881e6b5f8f"));
                int columnIndexOrThrow25 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{17, 80, 65, 20, 11, 74, 6, 70, 111, 5, 7, 78, 10, 86, 85, 62, 11, 92, 15, 80}, "c50ab8", false));
                int columnIndexOrThrow26 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 6, 72, 76, 91, 22, 81, 74, 103, 1, 88, 77, 70, 1, 70, 64, 103, 13, 86, 77, 109, 8, 91, 78}, "8c992d49", false));
                int columnIndexOrThrow27 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 85, 69, 66, 92, 70, 3, 16, 110, 65, 71, 95, 70, 84, 85, 80, 103, 94, 91, 67, 106, 88, 9, 20}, "804754fc12304525", false));
                int columnIndexOrThrow28 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{17, 68, 12, 84, 80, 80, 67, 110, 85, 14, 11, 66, 0, 93, 67, 106, 68, 65, 82, 0, 17, 83, 58, 87, 82, 89, 80, 72}, "e6e375116a", false));
                int columnIndexOrThrow29 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{17, 16, 10, 82, 81, 84, 71, 110, 94, 80, 78, 111, 6, 13, 13, 65, 83, 95, 65, 110, 87, 84, 90, 81, 28}, "ebc561513160", 1));
                int columnIndexOrThrow30 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{84, 14, 91, 70, 83, 95, 70, 58, 65, 70, 94, 106, 67, 19, 92, 85, 81, 84, 64, 22}, "7a52612e4475", true));
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
                return arrayList;
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

    public final ArrayList getRunningWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{103, 33, 121, 119, 119, 50, 70, 75, 70, 35, 97, 42, 121, 68, 66, 93, 70, 13, 21, 17, 3, 6, 19, 50, 124, 33, 103, 119, 20, 21, 18, 0, 18, 0, 14, 84}, "4d524ffafe3e", 3), 0);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{13, 81}, "d5b4e8"));
            int columnIndexOrThrow2 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{22, 71, 84, 17, 84}, "e35e13", 0.0f));
            int columnIndexOrThrow3 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{79, 86, 64, 83, 84, 67, 62, 90, 90, 4, 75, 74, 109, 86, 80, 92, 4}, "892811a96e", 1));
            int columnIndexOrThrow4 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{90, 95, 67, 71, 67, 106, 94, 0, 70, 94, 82, 64, 109, 90, 95, 83, 64, 66, 108, 92, 86, 88, 86}, "3132753e49722932"));
            int columnIndexOrThrow5 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{92, 89, 22, 68, 17}, "57f1e18ed702"));
            int columnIndexOrThrow6 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{88, 17, 18, 67, 71, 18}, "7df32fd1bd3799", 0.0f));
            int columnIndexOrThrow7 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{12, 88, 94, 66, 92, 83, 90, 103, 1, 83, 91, 87, 76}, "e6765268", true));
            int columnIndexOrThrow8 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{89, 86, 76, 7, 16, 66, 4, 94, 59, 81, 77, 69, 81, 76, 81, 13, 12}, "088bb4e2d587", 0.0f));
            int columnIndexOrThrow9 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{87, 84, 7, 75, 102, 2, 66, 17, 85, 17, 15, 86, 90}, "18b39f7c4ef941", 7));
            int columnIndexOrThrow10 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{71, 16, 86, 57, 7, 65, 65, 0, 85, 22, 18, 106, 86, 10, 77, 8, 18}, "5e8ff5", 4));
            int columnIndexOrThrow11 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{80, 3, 91, 83, 89, 95, 94, 58, 73, 11, 10, 80, 81, 27}, "2b88698e9df9", 4));
            int columnIndexOrThrow12 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{3, 3, 87, 15, 14, 94, 2, 103, 0, 82, 90, 83, 29, 111, 5, 23, 70, 5, 21, 81, 11, 86}, "ab4da8d8d762d0"));
            int columnIndexOrThrow13 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{85, 86, 75, 65, 111, 87, 87, 70, 77, 80, 69, 87, 102, 67, 81, 88, 85}, "978502", 5));
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{88, 81, 89, 92, 92, 64, 88, 103, 69, 80, 69, 80, 91, 76, 94, 90, 95, 106, 81, 77, 69, 84, 69, 92, 90, 86}, "587515", true));
                int columnIndexOrThrow15 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 85, 11, 93, 80, 66, 91, 3, 57, 22, 87, 64, 22, 84, 66, 65, 92, 82, 60, 89, 64}, "96c8477ffd21c115", 0.0f));
                int columnIndexOrThrow16 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{75, 68, 90, 104, 81, 93, 104, 82, 91, 17, 92, 86, 70, 88, 77, 93, 83}, "914783744c", true));
                int columnIndexOrThrow17 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{10, 17, 67, 57, 13, 80, 60, 65, 16, 11, 67, 7, 61, 70, 12, 92, 12, 7, 78}, "ed7fb6c0"));
                int columnIndexOrThrow18 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{71, 80, 75, 13, 88, 0, 61, 87, 13, 69, 89, 65}, "759d7db4b0", false));
                int columnIndexOrThrow19 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{1, 0, 92, 7, 70, 83, 64, 92, 95, 8}, "fe2b42450f", 4));
                int columnIndexOrThrow20 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{10, 7, 29, 67, 62, 67, 87, 91, 1, 6, 17, 14, 0, 104, 21, 89, 89, 86, 59, 13, 18, 7, 23, 69, 8, 84, 81}, "dbe7a043db"));
                int columnIndexOrThrow21 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{13, 84, 26, 22, 58, 23, 0, 89, 7, 6, 16, 8, 6, 110, 22, 11, 8, 1, 60, 94, 20, 7, 23, 22, 10, 85, 7, 61, 2, 1, 13, 84, 16, 3, 17, 13, 12, 95}, "c1bbed", 0.0f));
                int columnIndexOrThrow22 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{74, 68, 14, 73, 107, 68, 3, 4, 16, 10, 88}, "90a946fece636616", 0.0f));
                int columnIndexOrThrow23 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 86, 18, 76, 80, 71, 0, 2, 105, 93, 3, 21, 68, 92, 17, 82, 102, 65, 28, 22, 83}, "33c995ef63fa", 2));
                int columnIndexOrThrow24 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 84, 64, 19, 94, 16, 0, 66, 110, 5, 95, 3, 23, 86, 88, 8, 80}, "e11f7b", 5));
                int columnIndexOrThrow25 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{19, 6, 71, 68, 12, 22, 6, 74, 108, 6, 4, 21, 95, 82, 0, 59, 10, 93, 95, 7}, "ac61edc93b", 4));
                int columnIndexOrThrow26 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{71, 83, 72, 66, 80, 68, 1, 18, 60, 85, 84, 66, 77, 82, 75, 79, 59, 15, 12, 67, 106, 90, 86, 64}, "569796dac7"));
                int columnIndexOrThrow27 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{19, 80, 19, 19, 91, 65, 85, 71, 58, 74, 68, 14, 22, 0, 6, 80, 61, 8, 93, 71, 111, 88, 10, 78}, "a5bf2304e90ada"));
                int columnIndexOrThrow28 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{71, 20, 90, 3, 5, 87, 65, 57, 80, 11, 12, 70, 86, 8, 71, 59, 23, 66, 87, 7, 71, 1, 61, 86, 86, 10, 82, 29}, "3f3db2", 0.0f));
                int columnIndexOrThrow29 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{22, 67, 88, 2, 85, 87, 67, 109, 15, 80, 73, 58, 81, 93, 95, 70, 7, 95, 69, 58, 86, 87, 93, 83, 27}, "b11e2212", true));
                int columnIndexOrThrow30 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{85, 93, 92, 23, 82, 90, 77, 60, 19, 17, 95, 109, 70, 17, 94, 83, 94, 6, 20, 16}, "622c749cfc", 5));
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
                return arrayList;
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

    public final ArrayList getScheduledWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{55, 118, 42, 35, 119, 99, 66, 75, 16, 118, 103, 41, 124, 65, 64, 12, 22, 88, 21, 22, 81, 84, 66, 54, 120, 117, 103, 35, 17, 18, 67, 2, 16, 86, 91, 86, 20, 118, 44, 37, 16, 67, 86, 14, 84, 5, 66, 15, 1, 108, 20, 3, 69, 66, 7, 18, 68, 85, 81, 57, 80, 21, 11, 93, 73, 2}, "d3ff47ba005f1a7c", false), 0);
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{89, 1}, "0ec96f", 0));
            int columnIndexOrThrow2 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{21, 67, 4, 17, 0}, "f7eeebc0", 0.0f));
            int columnIndexOrThrow3 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{64, 9, 74, 89, 6, 22, 107, 91, 90, 88, 71, 22, 104, 8, 89, 95, 6}, "7f82cd48694e"));
            int columnIndexOrThrow4 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{95, 91, 19, 19, 16, 107, 91, 80, 17, 1, 1, 70, 105, 86, 15, 7, 23, 71, 105, 91, 2, 11, 1}, "65cfd4", 0.0f));
            int columnIndexOrThrow5 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{80, 90, 22, 22, 68}, "94fc0c4874"));
            int columnIndexOrThrow6 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{11, 22, 71, 19, 76, 67}, "dc3c97d1"));
            int columnIndexOrThrow7 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{8, 10, 88, 18, 90, 88, 91, 104, 81, 6, 91, 81, 24}, "ad1f39775c70", false));
            int columnIndexOrThrow8 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{80, 88, 68, 84, 22, 70, 85, 90, 60, 87, 22, 75, 88, 66, 89, 94, 10}, "9601d046c3c9", 5));
            int columnIndexOrThrow9 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{84, 95, 93, 75, 104, 83, 64, 71, 7, 16, 80, 92, 92}, "23837755fd93", 0.0f));
            int columnIndexOrThrow10 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{75, 64, 89, 61, 81, 21, 77, 80, 90, 18, 68, 62, 90, 90, 66, 12, 68}, "957b0a", false));
            int columnIndexOrThrow11 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{1, 89, 91, 92, 12, 94, 83, 106, 67, 12, 93, 91, 90, 74}, "c887c8553c1293"));
            int columnIndexOrThrow12 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{81, 82, 1, 93, 11, 5, 82, 111, 87, 86, 14, 87, 29, 60, 80, 69, 65, 82, 22, 95, 11, 13}, "33b6dc40"));
            int columnIndexOrThrow13 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{9, 4, 16, 69, 106, 6, 12, 67, 16, 0, 22, 84, 106, 23, 11, 95, 0}, "eec15cb2", 0.0f));
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{92, 91, 15, 93, 12, 20, 9, 111, 74, 92, 68, 86, 91, 65, 95, 94, 95, 109, 5, 65, 19, 0, 16, 89, 87, 87}, "12a4aad089035561"));
                int columnIndexOrThrow15 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{17, 1, 89, 86, 82, 20, 84, 6, 106, 66, 4, 64, 77, 4, 66, 17, 7, 6, 110, 82, 66}, "bb136a8c50a18a1e"));
                int columnIndexOrThrow16 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 17, 8, 103, 94, 87, 103, 7, 10, 22, 3, 95, 69, 86, 77, 15, 1}, "edf8798a"));
                int columnIndexOrThrow17 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{94, 69, 66, 110, 91, 4, 58, 21, 67, 9, 69, 81, 105, 65, 91, 14, 12, 7, 79}, "10614bed6f"));
                int columnIndexOrThrow18 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{22, 85, 66, 93, 88, 82, 107, 91, 13, 65, 8, 68}, "f0047648b4", 2));
                int columnIndexOrThrow19 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{5, 82, 92, 85, 68, 83, 66, 15, 13, 89}, "b720626f", true));
                int columnIndexOrThrow20 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{87, 80, 28, 16, 102, 69, 81, 11, 0, 87, 19, 90, 3, 104, 77, 92, 9, 1, 102, 89, 68, 6, 23, 65, 15, 82, 3}, "95dd962ce3f6f7"));
                int columnIndexOrThrow21 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{87, 1, 72, 66, 103, 75, 7, 12, 4, 82, 23, 14, 92, 59, 68, 95, 85, 93, 59, 11, 23, 83, 16, 16, 80, 0, 85, 105, 95, 93, 10, 1, 19, 87, 22, 11, 86, 10}, "9d0688dda6bb"));
                int columnIndexOrThrow22 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{69, 77, 87, 72, 57, 23, 6, 82, 67, 90, 88}, "6988fec305", 0));
                int columnIndexOrThrow23 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{75, 84, 66, 65, 93, 17, 92, 85, 108, 90, 81, 23, 78, 94, 65, 95, 107, 23, 64, 65, 86}, "91344c", true));
                int columnIndexOrThrow24 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{67, 4, 72, 66, 13, 22, 7, 65, 104, 80, 95, 4, 69, 87, 11, 91, 86}, "1a97ddb2737e70b5", true));
                int columnIndexOrThrow25 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{70, 81, 67, 68, 90, 69, 81, 71, 109, 85, 86, 65, 93, 87, 87, 110, 90, 83, 88, 81}, "442137", 0.0f));
                int columnIndexOrThrow26 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 85, 64, 67, 95, 67, 85, 70, 102, 1, 84, 66, 65, 83, 20, 74, 58, 94, 94, 66, 105, 93, 95, 66}, "e01661059c5656f3", 0.0f));
                int columnIndexOrThrow27 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 84, 70, 22, 13, 75, 86, 66, 104, 16, 16, 86, 65, 80, 80, 6, 59, 87, 92, 69, 104, 15, 11, 78}, "317cd9", 4));
                int columnIndexOrThrow28 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{21, 64, 80, 84, 6, 3, 19, 109, 90, 92, 15, 18, 4, 92, 77, 108, 20, 22, 5, 83, 77, 86, 62, 2, 4, 94, 88, 74}, "a293af"));
                int columnIndexOrThrow29 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 17, 12, 81, 85, 82, 66, 105, 14, 89, 27, 60, 6, 89, 92, 67, 85, 88, 23, 103, 7, 6, 9, 87, 75}, "cce62706c8", true));
                int columnIndexOrThrow30 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{82, 14, 11, 70, 81, 94, 71, 111, 65, 69, 15, 60, 69, 19, 12, 85, 83, 85, 65, 67}, "1ae2403047fc", 0.0f));
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
                return arrayList;
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

    public final int getState(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{102, 119, 121, 112, 119, 55, 21, 65, 65, 84, 64, 6, 21, 116, 103, 122, 121, 67, 66, 93, 71, 94, 71, 19, 80, 81, 21, 98, 124, 38, 103, 119, 21, 92, 80, 94, 10}, "52554c"), 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int iIntToState = 0;
            if (cursorQuery.moveToFirst()) {
                Integer numValueOf = cursorQuery.isNull(0) ? null : Integer.valueOf(cursorQuery.getInt(0));
                if (numValueOf != null) {
                    iIntToState = Headers.Companion.intToState(numValueOf.intValue());
                }
            }
            return iIntToState;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public final ArrayList getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{103, 114, 122, 33, 33, 99, 18, 88, 87, 23, 114, 101, 121, 41, 66, 64, 93, 67, 88, 68, 68, 82, 85, 68, 53, 127, 119, 99, 118, 23, 71, 67, 87, 16, 7, 23, 124, 126, 103, 23, 125, 121, 22, 76, 80, 27, 18, 2, 31, 23, 1, 30, 22, 37, 44, 115, 18, 88, 87, 23, 125, 121, 22, 76, 49, 114, 126, 116, 112, 99, 20, 64, 89, 22, 9, 104, 65, 65, 86, 84, 107, 94, 82, 68, 36, 101, 125, 124, 19, 64, 91, 69, 93, 10, 3, 90, 87, 17, 100, 127, 113, 101, 115, 68, 12, 86, 95, 84, 14, 8, 29}, "476db72137", true), 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public final WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{102, 114, 40, 38, 37, 100, 23, 78, 25, 127, 103, 120, 41, 67, 17, 95, 69, 15, 74, 73, 80, 84, 68, 52, 46, 117, 101, 33, 25, 80, 81, 10, 91}, "57dcf07d99", 0), 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{13, 7}, "dc71e23c94ef", 5));
            int columnIndexOrThrow2 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 18, 84, 22, 92}, "df5b9a186b"));
            int columnIndexOrThrow3 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{21, 95, 75, 9, 82, 23, 105, 0, 94, 88, 65, 67, 61, 94, 88, 15, 82}, "b09b7e6c2920", 0.0f));
            int columnIndexOrThrow4 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{95, 91, 69, 69, 71, 105, 92, 82, 67, 80, 6, 22, 105, 86, 89, 81, 64, 69, 110, 89, 80, 90, 6}, "6550361717cd", true));
            int columnIndexOrThrow5 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{95, 10, 18, 76, 70}, "6db927519a", true));
            int columnIndexOrThrow6 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{9, 17, 64, 66, 77, 17}, "fd428e", 0.0f));
            int columnIndexOrThrow7 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{10, 89, 11, 77, 8, 2, 15, 59, 80, 1, 84, 2, 31}, "c7b9accd4d8cfc", true));
            int columnIndexOrThrow8 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{93, 10, 66, 87, 23, 65, 4, 15, 61, 92, 64, 20, 85, 16, 95, 93, 11}, "4d62e7ecb85f", 6));
            int columnIndexOrThrow9 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{86, 10, 1, 30, 103, 87, 19, 70, 85, 76, 88, 10, 94}, "0fdf83f4481e", 2));
            int columnIndexOrThrow10 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{66, 66, 86, 106, 5, 67, 77, 3, 92, 22, 65, 104, 83, 88, 77, 91, 16}, "0785d79f1f57", false));
            int columnIndexOrThrow11 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{6, 88, 82, 82, 86, 4, 5, 105, 20, 10, 8, 80, 82, 64}, "d9199bc6de", 4));
            int columnIndexOrThrow12 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{86, 87, 91, 10, 90, 81, 82, 105, 92, 4, 89, 86, 77, 105, 92, 20, 71, 86, 64, 95, 87, 15}, "468a57", 5));
            int columnIndexOrThrow13 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{13, 82, 65, 64, 109, 6, 13, 71, 20, 86, 71, 81, 109, 23, 10, 91, 4}, "a3242cc6", 0.0f));
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow14 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{91, 94, 87, 89, 84, 76, 91, 104, 75, 85, 77, 92, 88, 67, 80, 95, 87, 102, 82, 66, 75, 81, 77, 80, 89, 89}, "679099"));
                int columnIndexOrThrow15 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{18, 1, 92, 80, 93, 77, 90, 93, 104, 66, 4, 19, 65, 80, 74, 76, 83, 92, 104, 81, 21}, "ab45986870", false));
                int columnIndexOrThrow16 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{68, 64, 91, 61, 95, 8, 110, 5, 90, 69, 93, 4, 74, 89, 67, 91, 81}, "655b6f1c578c86", 7));
                int columnIndexOrThrow17 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{92, 67, 68, 58, 11, 82, 102, 72, 22, 90, 71, 87, 111, 21, 11, 88, 80, 90, 26}, "360ed499c5"));
                int columnIndexOrThrow18 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{68, 4, 16, 12, 12, 84, 106, 6, 91, 20, 12, 17}, "4abec05e", true));
                int columnIndexOrThrow19 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{82, 87, 87, 1, 23, 86, 17, 95, 12, 86}, "529de7e6c8", 0.0f));
                int columnIndexOrThrow20 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{89, 82, 29, 17, 104, 68, 87, 10, 82, 83, 16, 9, 82, 104, 64, 11, 90, 82, 58, 10, 65, 82, 70, 16, 94, 83, 0}, "77ee774b", 0.0f));
                int columnIndexOrThrow21 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{86, 84, 64, 76, 106, 74, 7, 95, 87, 7, 67, 15, 81, 105, 77, 81, 85, 84, 103, 87, 67, 92, 22, 69, 91, 7, 83, 60, 83, 83, 87, 93, 74, 80, 76, 81, 90, 87}, "818859d72c6c4698", 2));
                int columnIndexOrThrow22 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{75, 18, 95, 66, 108, 71, 4, 4, 67, 89, 90}, "8f0235ae0640ff", 6));
                int columnIndexOrThrow23 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{70, 3, 71, 71, 91, 70, 7, 85, 110, 15, 4, 76, 71, 88, 64, 83, 107, 18, 79, 66, 87}, "4f6224b11aa80728", 0.0f));
                int columnIndexOrThrow24 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 83, 72, 20, 93, 20, 4, 65, 111, 81, 91, 87, 75, 6, 93, 8, 6}, "369a4fa202"));
                int columnIndexOrThrow25 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 0, 64, 76, 80, 66, 7, 67, 62, 1, 87, 20, 92, 7, 7, 62, 90, 1, 93, 92}, "3e1990b0ae2b5dba", 6));
                int columnIndexOrThrow26 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{20, 86, 73, 67, 11, 70, 93, 23, 109, 86, 89, 22, 70, 92, 74, 79, 57, 93, 87, 66, 61, 88, 87, 19}, "f386b48d248b2986", false));
                int columnIndexOrThrow27 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{67, 4, 16, 16, 10, 75, 93, 65, 108, 69, 69, 14, 19, 4, 4, 92, 103, 92, 92, 66, 110, 13, 14, 18}, "1aaec98236", 7));
                int columnIndexOrThrow28 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{65, 69, 81, 3, 4, 93, 71, 110, 90, 12, 91, 70, 80, 89, 76, 59, 22, 72, 81, 80, 77, 6, 106, 86, 80, 91, 89, 29}, "578dc8519c52"));
                int columnIndexOrThrow29 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{64, 17, 12, 5, 82, 86, 68, 109, 89, 2, 29, 61, 86, 92, 88, 70, 81, 13, 17, 61, 81, 86, 90, 83, 77}, "4ceb5362", 0.0f));
                int columnIndexOrThrow30 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{81, 91, 15, 77, 84, 12, 70, 107, 20, 75, 88, 61, 70, 70, 8, 94, 86, 7, 64, 71}, "24a91b", 0.0f));
                WorkSpec workSpec = null;
                byte[] blob = null;
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow);
                    int iIntToState = Headers.Companion.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    String string2 = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                    String string3 = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                    Data dataFromByteArray = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getBlob(columnIndexOrThrow5));
                    Data dataFromByteArray2 = Data.fromByteArray(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getBlob(columnIndexOrThrow6));
                    long j = cursorQuery.getLong(columnIndexOrThrow7);
                    long j2 = cursorQuery.getLong(columnIndexOrThrow8);
                    long j3 = cursorQuery.getLong(columnIndexOrThrow9);
                    int i = cursorQuery.getInt(columnIndexOrThrow10);
                    int iIntToBackoffPolicy = Headers.Companion.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow11));
                    long j4 = cursorQuery.getLong(columnIndexOrThrow12);
                    long j5 = cursorQuery.getLong(columnIndexOrThrow13);
                    long j6 = cursorQuery.getLong(columnIndexOrThrow14);
                    long j7 = cursorQuery.getLong(columnIndexOrThrow15);
                    boolean z = cursorQuery.getInt(columnIndexOrThrow16) != 0;
                    int iIntToOutOfQuotaPolicy = Headers.Companion.intToOutOfQuotaPolicy(cursorQuery.getInt(columnIndexOrThrow17));
                    int i2 = cursorQuery.getInt(columnIndexOrThrow18);
                    int i3 = cursorQuery.getInt(columnIndexOrThrow19);
                    long j8 = cursorQuery.getLong(columnIndexOrThrow20);
                    int i4 = cursorQuery.getInt(columnIndexOrThrow21);
                    int i5 = cursorQuery.getInt(columnIndexOrThrow22);
                    int iIntToNetworkType = Headers.Companion.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow23));
                    boolean z2 = cursorQuery.getInt(columnIndexOrThrow24) != 0;
                    boolean z3 = cursorQuery.getInt(columnIndexOrThrow25) != 0;
                    boolean z4 = cursorQuery.getInt(columnIndexOrThrow26) != 0;
                    boolean z5 = cursorQuery.getInt(columnIndexOrThrow27) != 0;
                    long j9 = cursorQuery.getLong(columnIndexOrThrow28);
                    long j10 = cursorQuery.getLong(columnIndexOrThrow29);
                    if (!cursorQuery.isNull(columnIndexOrThrow30)) {
                        blob = cursorQuery.getBlob(columnIndexOrThrow30);
                    }
                    workSpec = new WorkSpec(string, iIntToState, string2, string3, dataFromByteArray, dataFromByteArray2, j, j2, j3, new Constraints(iIntToNetworkType, z2, z3, z4, z5, j9, j10, Headers.Companion.byteArrayToSetOfTriggers(blob)), i, iIntToBackoffPolicy, j4, j5, j6, j7, z, iIntToOutOfQuotaPolicy, i2, i3, j8, i4, i5);
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return workSpec;
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

    public final ArrayList getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{48, 116, 47, 33, 33, 96, 68, 89, 92, 28, 16, 68, 23, 80, 23, 1, 66, 114, 54, 127, 117, 16, 71, 88, 17, 90, 16, 20, 7, 87, 68, 103, 112, 117, 98, 114, 67, 88, 7, 68, 43, 122, 68, 24, 107, 117, 124, 114, 32, 101, 67, 19, 13, 70, 15, 111, 75, 64, 85, 84, 60, 88, 7, 68, 36, 102, 43, 125, 24, 71, 95, 69, 8, 95, 2, 9, 7, 20, 51, 120, 125, 98, 117, 23, 13, 80, 14, 1, 95, 11, 77}, "c1cdb4d08007"), 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.isNull(0) ? null : cursorQuery.getString(0);
                int iIntToState = Headers.Companion.intToState(cursorQuery.getInt(1));
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.id = string;
                idAndState.state = iIntToState;
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public final void markWorkSpecScheduled(long j, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = this.__preparedStmtOfMarkWorkSpecScheduled;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void resetWorkSpecNextScheduleTimeOverride(String str, int i) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = this.__preparedStmtOfResetWorkSpecNextScheduleTimeOverride;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 1);
        }
        frameworkSQLiteStatementAcquire.bindLong(2, i);
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void setLastEnqueueTime(long j, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = this.__preparedStmtOfSetLastEnqueueTime;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void setOutput(String str, Data data) throws Throwable {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = this.__preparedStmtOfSetOutput;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void setState(String str, int i) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = this.__preparedStmtOfSetState;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, Headers.Companion.stateToInt(i));
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    public final void setStopReason(String str, int i) {
        WorkDatabase_Impl workDatabase_Impl = this.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = this.__preparedStmtOfSetStopReason;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        frameworkSQLiteStatementAcquire.bindLong(1, i);
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(2);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 2);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }
}
