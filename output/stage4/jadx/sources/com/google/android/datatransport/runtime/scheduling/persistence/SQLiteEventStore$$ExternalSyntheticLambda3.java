package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda3 implements SQLiteEventStore.Function {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ AutoValue_TransportContext f$1;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda3(long j, AutoValue_TransportContext autoValue_TransportContext) {
        this.f$0 = j;
        this.f$1 = autoValue_TransportContext;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put(C0000.decode(new byte[]{8, 4, 79, 68, 57, 23, 87, 19, 64, 82, 21, 21, 104, 93, 21}, "fa70fe2b57", 0.0f), Long.valueOf(this.f$0));
        AutoValue_TransportContext autoValue_TransportContext = this.f$1;
        String str = autoValue_TransportContext.backendName;
        Priority priority = autoValue_TransportContext.priority;
        String[] strArr = {str, String.valueOf(PriorityMapping.toInt(priority))};
        String strDecode = C0000.decode(new byte[]{21, 71, 82, 11, 70, 71, 91, 67, 16, 60, 5, 90, 15, 65, 86, 29, 65, 68}, "a53e5741dcf5");
        if (sQLiteDatabase.update(strDecode, contentValues, C0000.decode(new byte[]{0, 81, 90, 14, 1, 93, 93, 62, 86, 82, 95, 93, 66, 13, 25, 90, 68, 82, 87, 5, 24, 67, 64, 81, 13, 66, 80, 17, 29, 19, 4, 65, 7}, "b09ed39a8328", 6), strArr) < 1) {
            contentValues.put(C0000.decode(new byte[]{80, 5, 80, 93, 80, 94, 86, 59, 93, 87, 88, 85}, "2d3650", 2), autoValue_TransportContext.backendName);
            contentValues.put(C0000.decode(new byte[]{20, 64, 88, 86, 65, 80, 16, 75}, "d21939"), Integer.valueOf(PriorityMapping.toInt(priority)));
            sQLiteDatabase.insert(strDecode, null, contentValues);
        }
        return null;
    }
}
