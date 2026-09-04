package androidx.work.impl.workers;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.tracing.Trace;
import androidx.work.SystemClock;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTagDao_Impl;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class DiagnosticsWorkerKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{112, 15, 2, 3, 90, 11, 21, 67, 81, 83, 18, 96, 70, 13, 17}, "4fcd4df780a7"));
    }

    public static final void access$workSpecRows(WorkLauncherImpl workLauncherImpl, WorkTagDao_Impl workTagDao_Impl, Dispatcher dispatcher, ArrayList arrayList) {
        String strDecode;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            WorkSpec workSpec = (WorkSpec) obj;
            WorkGenerationalId workGenerationalIdGenerationalId = Trace.generationalId(workSpec);
            String str = workSpec.id;
            SystemIdInfo systemIdInfo = dispatcher.getSystemIdInfo(workGenerationalIdGenerationalId);
            Integer numValueOf = systemIdInfo != null ? Integer.valueOf(systemIdInfo.systemId) : null;
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) workLauncherImpl.processor;
            RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{96, 112, 123, 124, 117, 54, 17, 90, 81, 91, 6, 69, 117, 103, 120, 116, 22, 21, 94, 70, 91, 88, 2, 8, 86, 21, 96, 113, 115, 48, 116, 20, 71, 89, 17, 14, 108, 70, 71, 92, 85, 61, 88, 80, 13, 9}, "35796b1406ce"), 1);
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(1);
            } else {
                roomSQLiteQueryAcquire.bindString(str, 1);
            }
            workDatabase_Impl.assertNotSuspendingTransaction();
            Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
            try {
                ArrayList arrayList2 = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    arrayList2.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                }
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                String strDecode2 = C0000.decode(new byte[]{21}, "9dbafcb0");
                String strJoinToString$default = CollectionsKt.joinToString$default(arrayList2, strDecode2, null, 62);
                String strJoinToString$default2 = CollectionsKt.joinToString$default(workTagDao_Impl.getTagsForWorkSpecId(str), strDecode2, null, 62);
                StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{57}, "31e1ff69"));
                sb.append(str);
                String strDecode3 = C0000.decode(new byte[]{49, 68}, "8dfffe");
                sb.append(strDecode3);
                sb.append(workSpec.workerClassName);
                sb.append(strDecode3);
                sb.append(numValueOf);
                sb.append(strDecode3);
                switch (workSpec.state) {
                    case 1:
                        strDecode = C0000.decode(new byte[]{115, 123, 98, 54, 35, 103, 115, 113}, "653cf2");
                        break;
                    case 2:
                        strDecode = C0000.decode(new byte[]{99, 51, 126, 120, 47, 43, 113}, "1f06fe613832");
                        break;
                    case 3:
                        strDecode = C0000.decode(new byte[]{49, 55, 114, 113, 117, 35, 118, 33, 113}, "bb120f2d57b534");
                        break;
                    case 4:
                        strDecode = C0000.decode(new byte[]{39, 113, 124, 47, 124, 113}, "a05c9513");
                        break;
                    case 5:
                        strDecode = C0000.decode(new byte[]{116, 124, 46, 123, 42, 113, 112}, "60a8a44d8555");
                        break;
                    case 6:
                        strDecode = C0000.decode(new byte[]{116, 114, 118, 122, 116, 120, 117, 119, 118}, "738914922fd5");
                        break;
                    default:
                        throw null;
                }
                sb.append(strDecode);
                sb.append(strDecode3);
                sb.append(strJoinToString$default);
                sb.append(strDecode3);
                sb.append(strJoinToString$default2);
                sb.append('\t');
            } catch (Throwable th) {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
                throw th;
            }
        }
    }
}
