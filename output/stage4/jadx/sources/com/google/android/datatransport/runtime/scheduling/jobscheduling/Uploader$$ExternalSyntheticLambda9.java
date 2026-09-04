package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda3;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class Uploader$$ExternalSyntheticLambda9 implements SynchronizationGuard.CriticalSection, SQLiteEventStore.Function {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ Uploader$$ExternalSyntheticLambda9(Object obj, Object obj2, long j) {
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = j;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        String str = (String) this.f$0;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i = ((LogEventDropped.Reason) this.f$1).number_;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(C0000.decode(new byte[]{50, 33, 121, 35, 34, 102, 16, 82, 65, 34, 103, 41, 44, 18, 92, 12, 6, 59, 80, 16, 4, 92, 68, 60, 5, 22, 90, 22, 17, 87, 84, 67, 54, 44, 112, 52, 36, 18, 92, 12, 6, 59, 70, 9, 20, 64, 83, 6, 65, 89, 21, 89, 65, 115, 126, 39, 65, 22, 80, 7, 18, 93, 94, 67, 92, 68, 10}, "ad5fa20c"), new String[]{str, Integer.toString(i)});
        try {
            boolean z = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j = this.f$2;
            if (z) {
                sQLiteDatabase.execSQL(C0000.decode(new byte[]{54, 97, 118, 115, 100, 115, 21, 94, 12, 86, 109, 87, 70, 83, 91, 70, 60, 85, 64, 93, 64, 70, 80, 86, 67, 98, 119, 102, 16, 83, 67, 87, 13, 69, 65, 109, 84, 68, 90, 66, 19, 84, 86, 109, 83, 89, 64, 92, 23, 17, 15, 18, 85, 64, 80, 92, 23, 66, 109, 86, 66, 89, 69, 66, 6, 85, 109, 81, 95, 67, 91, 70, 67, 26, 18}, "c1220652", 5) + j + C0000.decode(new byte[]{67, 96, 43, 38, 107, 113, 19, 8, 94, 81, 61, 66, 11, 76, 17, 84, 6, 67, 4, 20, 12, 68, 112, 120, 38, 17, 22, 92, 2, 68, 12, 13, 25, 9, 19, 91}, "c7cc943d16b1d9", 0), new String[]{str, Integer.toString(i)});
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(C0000.decode(new byte[]{88, 86, 5, 62, 23, 88, 68, 17, 87, 92}, "49bad71c", true), str);
            contentValues.put(C0000.decode(new byte[]{22, 3, 80, 16, 92, 92}, "df1c32b0", 4), Integer.valueOf(i));
            contentValues.put(C0000.decode(new byte[]{3, 71, 1, 87, 69, 71, 59, 2, 20, 94, 20, 73, 84, 80, 59, 5, 9, 68, 10, 77}, "f1d914df"), Long.valueOf(j));
            sQLiteDatabase.insert(C0000.decode(new byte[]{85, 93, 85, 60, 83, 71, 84, 91, 77, 109, 86, 17, 89, 65, 65, 80, 93}, "922c6115"), null, contentValues);
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        Uploader uploader = (Uploader) this.f$0;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
        EventStore eventStore = uploader.eventStore;
        long time = uploader.clock.getTime() + this.f$2;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) eventStore;
        sQLiteEventStore.getClass();
        sQLiteEventStore.inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda3(time, autoValue_TransportContext));
        return null;
    }
}
