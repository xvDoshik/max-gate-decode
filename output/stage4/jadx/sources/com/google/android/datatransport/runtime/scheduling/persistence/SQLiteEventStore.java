package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda9;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import javax.inject.Provider;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {
    public static final Encoding PROTOBUF_ENCODING = new Encoding(C0000.decode(new byte[]{65, 75, 92, 22, 9}, "193bfbbed133a6", true));
    public final AutoValue_EventStoreConfig config;
    public final Clock monotonicClock;
    public final Provider packageName;
    public final SchemaManager schemaManager;
    public final Clock wallClock;

    public interface Function {
        Object apply(Object obj);
    }

    public final class Metadata {
        public final String key;
        public final String value;

        public Metadata(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    public SQLiteEventStore(Clock clock, Clock clock2, AutoValue_EventStoreConfig autoValue_EventStoreConfig, SchemaManager schemaManager, Provider provider) {
        this.schemaManager = schemaManager;
        this.wallClock = clock;
        this.monotonicClock = clock2;
        this.config = autoValue_EventStoreConfig;
        this.packageName = provider;
    }

    public static Long getTransportContextId(SQLiteDatabase sQLiteDatabase, AutoValue_TransportContext autoValue_TransportContext) {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{3, 80, 7, 10, 87, 86, 7, 110, 11, 83, 12, 84, 68, 92, 18, 7, 67, 80, 11, 86, 65, 65, 22, 8, 93, 74, 10, 69, 28, 18, 92, 17, 91}, "a1da28c1e2", 3));
        ArrayList arrayList = new ArrayList(Arrays.asList(autoValue_TransportContext.backendName, String.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority))));
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr != null) {
            sb.append(C0000.decode(new byte[]{65, 5, 88, 86, 20, 7, 74, 68, 64, 84, 18, 68, 11, 18, 11}, "ad624b2025"));
            arrayList.add(Base64.encodeToString(bArr, 0));
        } else {
            sb.append(C0000.decode(new byte[]{20, 82, 95, 85, 22, 80, 26, 23, 71, 82, 18, 16, 91, 71, 25, 95, 65, 95, 93}, "431165bc53a02491", true));
        }
        Cursor cursorQuery = sQLiteDatabase.query(C0000.decode(new byte[]{70, 23, 88, 90, 69, 18, 10, 20, 66, 108, 83, 11, 95, 23, 81, 79, 70, 22}, "2e946bef630d1c47", 0.0f), new String[]{C0000.decode(new byte[]{59, 94, 84}, "d70dad", 0.0f)}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            return !cursorQuery.moveToNext() ? null : Long.valueOf(cursorQuery.getLong(0));
        } finally {
            cursorQuery.close();
        }
    }

    public static String toIdList(Iterable iterable) {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{76}, "dd957df3ececb14e"));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((AutoValue_PersistedEvent) it.next()).id);
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static Object tryWithCursor(Cursor cursor, Function function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.schemaManager.close();
    }

    public final SQLiteDatabase getDb() {
        SchemaManager schemaManager = this.schemaManager;
        Objects.requireNonNull(schemaManager);
        Clock clock = this.monotonicClock;
        long time = clock.getTime();
        while (true) {
            try {
                return schemaManager.getWritableDatabase();
            } catch (SQLiteDatabaseLockedException e) {
                if (clock.getTime() >= ((long) this.config.criticalSectionEnterTimeoutMs) + time) {
                    throw new SynchronizationException(C0000.decode(new byte[]{53, 95, 88, 4, 5, 21, 88, 66, 21, 22, 66, 9, 8, 89, 82, 23, 21, 68, 76, 8, 15, 82, 23, 67, 14, 22, 90, 17, 4, 91, 23, 83, 3, 24}, "a65aa577", 3), e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    public final Object inTransaction(Function function) {
        SQLiteDatabase db = getDb();
        db.beginTransaction();
        try {
            Object objApply = function.apply(db);
            db.setTransactionSuccessful();
            return objApply;
        } finally {
            db.endTransaction();
        }
    }

    public final ArrayList loadEvents(SQLiteDatabase sQLiteDatabase, AutoValue_TransportContext autoValue_TransportContext, int i) {
        ArrayList arrayList = new ArrayList();
        Long transportContextId = getTransportContextId(sQLiteDatabase, autoValue_TransportContext);
        if (transportContextId == null) {
            return arrayList;
        }
        tryWithCursor(sQLiteDatabase.query(C0000.decode(new byte[]{85, 70, 85, 87, 64, 66}, "000941", 0.0f), new String[]{C0000.decode(new byte[]{60, 80, 92}, "c98fe4c680", 5), C0000.decode(new byte[]{76, 64, 80, 90, 71, 67, 89, 68, 69, 110, 10, 85, 93, 1}, "8214436611d40d", false), C0000.decode(new byte[]{17, 90, 94, 1, 64, 17, 83, 88, 21, 108, 94, 23}, "e33d3e25", 5), C0000.decode(new byte[]{22, 64, 67, 81, 90, 6, 107, 12, 67}, "c0787c4a02eb", 0.0f), C0000.decode(new byte[]{17, 3, 72, 85, 14, 88, 80, 111, 83, 87, 2, 13, 85, 80, 15, 94}, "ab19a94069", 5), C0000.decode(new byte[]{20, 84, 28, 94, 92, 89, 81}, "d5e23857cb2053"), C0000.decode(new byte[]{82, 87, 86, 87}, "1822b68a60e5dc", false), C0000.decode(new byte[]{95, 93, 15, 11, 12, 0}, "63cbbe04f3175a62", true)}, C0000.decode(new byte[]{87, 94, 87, 76, 0, 29, 76, 106, 93, 85, 25, 5, 69, 90}, "4198ee85", false), new String[]{transportContextId.toString()}, null, null, null, String.valueOf(i)), new FirebaseMessaging$$ExternalSyntheticLambda4(this, arrayList, autoValue_TransportContext, 3));
        return arrayList;
    }

    public final void recordLogEventDropped(long j, LogEventDropped.Reason reason, String str) {
        inTransaction(new Uploader$$ExternalSyntheticLambda9(str, reason, j));
    }

    public final Object runCriticalSection(SynchronizationGuard.CriticalSection criticalSection) {
        SQLiteDatabase db = getDb();
        Clock clock = this.monotonicClock;
        long time = clock.getTime();
        while (true) {
            try {
                db.beginTransaction();
                try {
                    Object objExecute = criticalSection.execute();
                    db.setTransactionSuccessful();
                    return objExecute;
                } finally {
                    db.endTransaction();
                }
            } catch (SQLiteDatabaseLockedException e) {
                if (clock.getTime() >= ((long) this.config.criticalSectionEnterTimeoutMs) + time) {
                    throw new SynchronizationException(C0000.decode(new byte[]{96, 90, 15, 83, 5, 22, 9, 16, 64, 70, 67, 91, 11, 90, 4, 22, 18, 23, 77, 15, 90, 84, 66, 66, 14, 22, 7, 6, 69, 19, 93, 65, 7, 22, 21, 94, 3, 69, 88, 9, 87, 88, 76}, "43b6a6fe4f", 0.0f), e);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
