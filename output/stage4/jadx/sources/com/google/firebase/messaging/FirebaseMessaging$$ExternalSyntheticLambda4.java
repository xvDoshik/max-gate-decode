package com.google.firebase.messaging;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import androidx.tracing.Trace;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class FirebaseMessaging$$ExternalSyntheticLambda4 implements SynchronizationGuard.CriticalSection, SQLiteEventStore.Function, SuccessContinuation {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ FirebaseMessaging$$ExternalSyntheticLambda4(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) throws Throwable {
        long jInsert;
        Cursor cursor;
        LogEventDropped.Reason reason;
        int i = this.$r8$classId;
        String strDecode = C0000.decode(new byte[]{0, 28, 71, 4, 64}, "be3a3776c356f2db", 2);
        String strDecode2 = C0000.decode(new byte[]{51, 54, 112, 115, 44, 120, 70, 21, 2, 3, 84, 107, 18, 80, 28, 0}, "cd14a9fe", 0.0f);
        String strDecode3 = C0000.decode(new byte[]{100, 51, 114, 33, 122, 34, 25, 20, 3, 87, 7, 109, 85, 13, 66, 88, 64}, "4a3f7c9db0b26b76", 0.0f);
        int i2 = 5;
        int i3 = 4;
        int i4 = 3;
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.CACHE_FULL;
        int i5 = 2;
        int i6 = 1;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        int i7 = 0;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0;
        switch (i) {
            case 2:
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj3;
                EncodedPayload encodedPayload = autoValue_EventInternal.encodedPayload;
                String str = autoValue_EventInternal.transportName;
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) obj2;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                long jSimpleQueryForLong = sQLiteEventStore.getDb().compileStatement(strDecode2).simpleQueryForLong() * sQLiteEventStore.getDb().compileStatement(strDecode3).simpleQueryForLong();
                AutoValue_EventStoreConfig autoValue_EventStoreConfig = sQLiteEventStore.config;
                if (jSimpleQueryForLong >= autoValue_EventStoreConfig.maxStorageSizeInBytes) {
                    sQLiteEventStore.recordLogEventDropped(1L, reason2, str);
                    return -1L;
                }
                Long transportContextId = SQLiteEventStore.getTransportContextId(sQLiteDatabase, autoValue_TransportContext);
                if (transportContextId != null) {
                    jInsert = transportContextId.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(C0000.decode(new byte[]{90, 82, 5, 83, 6, 91, 87, 61, 86, 87, 8, 83}, "83f8c53b86e6248c", false), autoValue_TransportContext.backendName);
                    contentValues.put(C0000.decode(new byte[]{20, 74, 80, 11, 19, 92, 70, 75}, "d89da522073ce389"), Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
                    contentValues.put(C0000.decode(new byte[]{95, 3, 26, 68, 107, 67, 84, 23, 23, 85, 71, 69, 110, 11, 17}, "1fb041", 2), (Integer) 0);
                    byte[] bArr = autoValue_TransportContext.extras;
                    if (bArr != null) {
                        contentValues.put(C0000.decode(new byte[]{80, 77, 21, 23, 4, 65}, "55aee2ab3b5a06", true), Base64.encodeToString(bArr, 0));
                    }
                    jInsert = sQLiteDatabase.insert(C0000.decode(new byte[]{17, 17, 87, 91, 23, 68, 88, 22, 21, 102, 90, 86, 91, 16, 0, 27, 66, 70}, "ec65d47da9995d", 0.0f), null, contentValues);
                }
                int i8 = autoValue_EventStoreConfig.maxBlobByteSizePerRow;
                byte[] bArr2 = encodedPayload.bytes;
                boolean z = bArr2.length <= i8;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(C0000.decode(new byte[]{82, 91, 11, 76, 83, 64, 70, 106, 94, 86}, "14e8682572", false), Long.valueOf(jInsert));
                contentValues2.put(C0000.decode(new byte[]{22, 67, 87, 92, 21, 66, 13, 71, 22, 110, 88, 83, 11, 87}, "b162f2b5", 0.0f), str);
                contentValues2.put(C0000.decode(new byte[]{70, 93, 88, 86, 65, 16, 4, 91, 70, 109, 8, 70}, "24532de662e5", false), Long.valueOf(autoValue_EventInternal.eventMillis));
                contentValues2.put(C0000.decode(new byte[]{65, 69, 22, 88, 88, 87, 110, 89, 71}, "45b15214"), Long.valueOf(autoValue_EventInternal.uptimeMillis));
                contentValues2.put(C0000.decode(new byte[]{66, 87, 77, 93, 95, 88, 1, 60, 80, 12, 91, 95, 81, 11, 93, 87}, "264109ec5b805b30", 0.0f), encodedPayload.encoding.name);
                contentValues2.put(C0000.decode(new byte[]{91, 14, 81, 1}, "8a5de448", 4), autoValue_EventInternal.code);
                contentValues2.put(C0000.decode(new byte[]{87, 71, 90, 106, 2, 23, 77, 87, 90, 69, 23, 16}, "9275cc"), (Integer) 0);
                contentValues2.put(C0000.decode(new byte[]{90, 93, 13, 10, 89, 82}, "33ac77b24e7ee0", true), Boolean.valueOf(z));
                contentValues2.put(C0000.decode(new byte[]{72, 5, 79, 92, 10, 81, 2}, "8d60e0f2ea0700", 0.0f), z ? bArr2 : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert(C0000.decode(new byte[]{81, 23, 80, 12, 65, 21}, "4a5b5f4f71", 5), null, contentValues2);
                String strDecode4 = C0000.decode(new byte[]{6, 70, 3, 95, 68, 102, 10, 84}, "c0f109");
                if (!z) {
                    int iCeil = (int) Math.ceil(((double) bArr2.length) / ((double) i8));
                    for (int i9 = 1; i9 <= iCeil; i9++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i9 - 1) * i8, Math.min(i9 * i8, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put(strDecode4, Long.valueOf(jInsert2));
                        contentValues3.put(C0000.decode(new byte[]{21, 92, 66, 66, 0, 93, 0, 87, 58, 89, 69, 90}, "f937e3c2e707"), Integer.valueOf(i9));
                        contentValues3.put(strDecode, bArrCopyOfRange);
                        sQLiteDatabase.insert(C0000.decode(new byte[]{83, 16, 93, 87, 64, 103, 20, 89, 72, 89, 89, 7, 92, 74}, "6f8948d815", 0.0f), null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(autoValue_EventInternal.autoMetadata).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put(strDecode4, Long.valueOf(jInsert2));
                    contentValues4.put(C0000.decode(new byte[]{95, 5, 90, 3}, "1d7f1e", 4), (String) entry.getKey());
                    contentValues4.put(C0000.decode(new byte[]{21, 86, 92, 65, 84}, "c70412b4", 0.0f), (String) entry.getValue());
                    sQLiteDatabase.insert(C0000.decode(new byte[]{6, 16, 7, 86, 66, 58, 95, 82, 64, 4, 1, 88, 23, 3}, "cfb86e274ee9cb", 2), null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case 3:
                ArrayList arrayList = (ArrayList) obj3;
                AutoValue_TransportContext autoValue_TransportContext2 = (AutoValue_TransportContext) obj2;
                Cursor cursor2 = (Cursor) obj;
                while (cursor2.moveToNext()) {
                    long j = cursor2.getLong(0);
                    int i10 = cursor2.getInt(7) != 0 ? i6 : 0;
                    Request request = new Request();
                    request.lazyCacheControl = new HashMap();
                    String string = cursor2.getString(i6);
                    if (string == null) {
                        throw new NullPointerException(C0000.decode(new byte[]{45, 68, 85, 14, 67, 18, 74, 5, 15, 16, 19, 94, 75, 22, 45, 7, 85, 1}, "c19bcf8dac", 6));
                    }
                    request.method = string;
                    request.body = Long.valueOf(cursor2.getLong(i5));
                    request.tags = Long.valueOf(cursor2.getLong(3));
                    if (i10 != 0) {
                        String string2 = cursor2.getString(4);
                        request.headers = new EncodedPayload(string2 == null ? SQLiteEventStore.PROTOBUF_ENCODING : new Encoding(string2), cursor2.getBlob(5));
                    } else {
                        String string3 = cursor2.getString(4);
                        Encoding encoding = string3 == null ? SQLiteEventStore.PROTOBUF_ENCODING : new Encoding(string3);
                        Cursor cursorQuery = sQLiteEventStore.getDb().query("event_payloads", new String[]{strDecode}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList2 = new ArrayList();
                            int length = 0;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(0);
                                arrayList2.add(blob);
                                length += blob.length;
                            }
                            byte[] bArr3 = new byte[length];
                            int i11 = 0;
                            int length2 = 0;
                            while (i11 < arrayList2.size()) {
                                byte[] bArr4 = (byte[]) arrayList2.get(i11);
                                cursor = cursorQuery;
                                try {
                                    ArrayList arrayList3 = arrayList2;
                                    System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
                                    length2 += bArr4.length;
                                    i11++;
                                    cursorQuery = cursor;
                                    arrayList2 = arrayList3;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            }
                            cursorQuery.close();
                            request.headers = new EncodedPayload(encoding, bArr3);
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                        }
                    }
                    if (!cursor2.isNull(6)) {
                        request.url = Integer.valueOf(cursor2.getInt(6));
                    }
                    arrayList.add(new AutoValue_PersistedEvent(j, autoValue_TransportContext2, request.build()));
                    i5 = 2;
                    i6 = 1;
                }
                return null;
            default:
                HashMap map = (HashMap) obj3;
                ServiceStarter serviceStarter = (ServiceStarter) obj2;
                ArrayList arrayList4 = (ArrayList) serviceStarter.hasAccessNetworkStatePermission;
                Cursor cursor3 = (Cursor) obj;
                sQLiteEventStore.getClass();
                while (cursor3.moveToNext()) {
                    String string4 = cursor3.getString(i7);
                    int i12 = cursor3.getInt(1);
                    LogEventDropped.Reason reason3 = LogEventDropped.Reason.REASON_UNKNOWN;
                    if (i12 != 0) {
                        if (i12 == 1) {
                            reason3 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
                        } else if (i12 == 2) {
                            reason = reason2;
                        } else if (i12 == i4) {
                            reason3 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
                        } else if (i12 == i3) {
                            reason3 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
                        } else if (i12 == i2) {
                            reason3 = LogEventDropped.Reason.INVALID_PAYLOD;
                        } else if (i12 == 6) {
                            reason3 = LogEventDropped.Reason.SERVER_ERROR;
                        } else {
                            Trace.d(C0000.decode(new byte[]{99, 55, 121, 13, 23, 81, 118, 18, 0, 10, 77, 53, 68, 9, 71, 1}, "0f5dc43ded9f", false), C0000.decode(new byte[]{71, 89, 19, 80, 23, 66, 95, 95, 77, 20, 67, 89, 14, 94, 87, 23, 68, 44, 94, 16, 84, 85, 65, 91, 10, 82, 87, 25, 40, 13, 86, 117, 79, 81, 91, 76, 38, 69, 92, 73, 20, 7, 85, 29, 107, 81, 84, 75, 13, 89, 19, 95, 11, 23, 95, 84, 23, 20, 97, 74, 7, 86, 71, 92, 0, 66, 88, 68, 25, 85, 70, 24, 48, 114, 114, 106, 43, 44, 110, 101, 119, 127, 123, 119, 53, 121}, "b739db109458", 2), Integer.valueOf(i12));
                        }
                        reason = reason3;
                    } else {
                        reason = reason3;
                    }
                    long j2 = cursor3.getLong(2);
                    if (!map.containsKey(string4)) {
                        map.put(string4, new ArrayList());
                    }
                    ((List) map.get(string4)).add(new LogEventDropped(j2, reason));
                    i7 = 0;
                    i2 = 5;
                    i3 = 4;
                    i4 = 3;
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    int i13 = LogSourceMetrics.$r8$clinit;
                    new ArrayList();
                    arrayList4.add(new LogSourceMetrics((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                }
                long time = sQLiteEventStore.wallClock.getTime();
                SQLiteDatabase db = sQLiteEventStore.getDb();
                db.beginTransaction();
                try {
                    Cursor cursorRawQuery = db.rawQuery(C0000.decode(new byte[]{49, 114, 121, 112, 38, 100, 16, 91, 3, 22, 68, 57, 90, 87, 18, 67, 11, 84, 70, 106, 16, 64, 92, 88, 3, 1, 111, 11, 68, 18, 32, 99, 45, 122, 21, 82, 9, 95, 82, 86, 14, 58, 92, 9, 80, 109, 3, 71, 7, 89, 65, 106, 22, 68, 81, 67, 7, 69, 124, 47, 122, 123, 50, 17, 83}, "b755e007be0f72f1"), new String[0]);
                    try {
                        cursorRawQuery.moveToNext();
                        TimeWindow timeWindow = new TimeWindow(cursorRawQuery.getLong(0), time);
                        cursorRawQuery.close();
                        db.setTransactionSuccessful();
                        db.endTransaction();
                        serviceStarter.hasWakeLockPermission = timeWindow;
                        serviceStarter.messagingEvents = new GlobalMetrics(new StorageMetrics(sQLiteEventStore.getDb().compileStatement(strDecode2).simpleQueryForLong() * sQLiteEventStore.getDb().compileStatement(strDecode3).simpleQueryForLong(), AutoValue_EventStoreConfig.DEFAULT.maxStorageSizeInBytes));
                        serviceStarter.firebaseMessagingServiceClassName = (String) sQLiteEventStore.packageName.get();
                        return new ClientMetrics((TimeWindow) serviceStarter.hasWakeLockPermission, Collections.unmodifiableList(arrayList4), (GlobalMetrics) serviceStarter.messagingEvents, (String) serviceStarter.firebaseMessagingServiceClassName);
                    } catch (Throwable th3) {
                        cursorRawQuery.close();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    db.endTransaction();
                    throw th4;
                }
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        DefaultScheduler defaultScheduler = (DefaultScheduler) this.f$0;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.f$2;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) defaultScheduler.eventStore;
        sQLiteEventStore.getClass();
        Priority priority = autoValue_TransportContext.priority;
        if (Log.isLoggable(C0000.decode(new byte[]{109, 51, 68, 13, 68, 10, 88, 85, 72}, "9a1c0c50f9e3", 5).concat(C0000.decode(new byte[]{55, 48, 47, 80, 16, 85, 35, 66, 4, 11, 18, 100, 66, 92, 16, 6}, "dac9d0f4aef763bc", 4)), 3)) {
            new StringBuilder(C0000.decode(new byte[]{55, 66, 89, 75, 93, 12, 3, 22, 83, 79, 81, 12, 16, 22, 65, 80, 64, 10, 68, 70, 68, 80, 91, 16, 13, 66, 79, 4}, "d6694b", true)).append(priority);
        }
        ((Long) sQLiteEventStore.inTransaction(new FirebaseMessaging$$ExternalSyntheticLambda4(sQLiteEventStore, autoValue_EventInternal, autoValue_TransportContext, 2))).getClass();
        defaultScheduler.workScheduler.schedule(autoValue_TransportContext, 1, false);
        return null;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public zzw then(Object obj) {
        String string;
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f$0;
        String str = (String) this.f$1;
        Store.Token token = (Store.Token) this.f$2;
        String str2 = (String) obj;
        Store store = FirebaseMessaging.getStore(firebaseMessaging.context);
        String strDecode = C0000.decode(new byte[]{111, 117, 125, 118, 118, 98, 124, 55, 63}, "4180770cb1220a0b", 6);
        FirebaseApp firebaseApp = firebaseMessaging.firebaseApp;
        firebaseApp.checkNotDeleted();
        String persistenceKey = strDecode.equals(firebaseApp.name) ? "" : firebaseApp.getPersistenceKey();
        String appVersionCode = firebaseMessaging.metadata.getAppVersionCode();
        synchronized (store) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i = Store.Token.$r8$clinit;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C0000.decode(new byte[]{77, 11, 8, 3, 93}, "9dcf3602c6"), str2);
                    jSONObject.put(C0000.decode(new byte[]{4, 18, 72, 101, 83, 67, 22, 11, 87, 93}, "eb8361", 0.0f), appVersionCode);
                    jSONObject.put(C0000.decode(new byte[]{67, 15, 89, 7, 18, 22, 81, 11, 21}, "7f4bab0fe9", 4), jCurrentTimeMillis);
                    string = jSONObject.toString();
                } catch (JSONException e) {
                    e.toString();
                    string = null;
                }
                if (string != null) {
                    SharedPreferences.Editor editorEdit = store.store.edit();
                    editorEdit.putString(persistenceKey + C0000.decode(new byte[]{79, 50, 69}, "3f9dcc58950c", false) + str + C0000.decode(new byte[]{75, 26}, "709aa1b3", true), string);
                    editorEdit.commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (token == null || !str2.equals(token.token)) {
            String strDecode2 = C0000.decode(new byte[]{56, 37, 114, 112, 32, 99, 125, 50, 101}, "ca76a61f8f57", 5);
            FirebaseApp firebaseApp2 = firebaseMessaging.firebaseApp;
            firebaseApp2.checkNotDeleted();
            if (strDecode2.equals(firebaseApp2.name)) {
                if (Log.isLoggable(C0000.decode(new byte[]{117, 81, 75, 83, 0, 84, 22, 0, 126, 93, 74, 69, 3, 82, 12, 11, 84}, "3896b5ee", 0.0f), 3)) {
                    firebaseApp2.checkNotDeleted();
                }
                Intent intent = new Intent(C0000.decode(new byte[]{0, 86, 8, 28, 83, 10, 12, 94, 9, 87, 26, 3, 10, 75, 0, 80, 85, 22, 6, 23, 8, 87, 71, 22, 2, 94, 12, 92, 83, 75, 45, 124, 50, 109, 96, 42, 40, 124, 43}, "c9e24e", 4));
                intent.putExtra(C0000.decode(new byte[]{18, 92, 88, 84, 13}, "f331cd8dcc", true), str2);
                new RequestDeduplicator(firebaseMessaging.context).process(intent);
            }
        }
        return ExceptionsKt.forResult(str2);
    }
}
