package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.tracing.Trace;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.concurrent.DelegatingScheduledExecutorService$$ExternalSyntheticLambda0;
import com.google.firebase.tracing.ComponentMonitor$$ExternalSyntheticLambda0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Uploader {
    public final MetadataBackendRegistry backendRegistry;
    public final ClientHealthMetricsStore clientHealthMetricsStore;
    public final Clock clock;
    public final Context context;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final Clock uptimeClock;
    public final WorkTagDao_Impl workScheduler;

    public Uploader(Context context, MetadataBackendRegistry metadataBackendRegistry, EventStore eventStore, WorkTagDao_Impl workTagDao_Impl, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.context = context;
        this.backendRegistry = metadataBackendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = workTagDao_Impl;
        this.executor = executor;
        this.guard = synchronizationGuard;
        this.clock = clock;
        this.uptimeClock = clock2;
        this.clientHealthMetricsStore = clientHealthMetricsStore;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:117:0x0603  */
    /* JADX WARN: Code duplicated, block: B:119:0x060b  */
    /* JADX WARN: Code duplicated, block: B:120:0x0615  */
    /* JADX WARN: Code duplicated, block: B:122:0x0618  */
    /* JADX WARN: Code duplicated, block: B:125:0x0627  */
    /* JADX WARN: Code duplicated, block: B:148:0x05da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x0660 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x0660 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x0641 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x0637 A[SYNTHETIC] */
    public final void logAndUpdateState(AutoValue_TransportContext autoValue_TransportContext, int i) {
        byte[] bArr;
        TransportBackend transportBackend;
        long j;
        AutoValue_BackendResponse autoValue_BackendResponse;
        String str;
        AutoValue_BackendResponse autoValue_BackendResponse2;
        int i2;
        CctTransportBackend.HttpResponse httpResponseApply;
        String str2;
        Integer numValueOf;
        long j2;
        WorkerWrapper.Builder builder;
        int i3;
        HashMap map;
        Iterator it;
        String str3;
        final Uploader uploader = this;
        final AutoValue_TransportContext autoValue_TransportContext2 = autoValue_TransportContext;
        byte[] bArr2 = autoValue_TransportContext2.extras;
        TransportBackend transportBackend2 = uploader.backendRegistry.get(autoValue_TransportContext2.backendName);
        long jMax = 0;
        while (true) {
            final int i4 = 0;
            SynchronizationGuard.CriticalSection criticalSection = new SynchronizationGuard.CriticalSection(uploader) { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda3
                public final /* synthetic */ Uploader f$0;

                {
                    this.f$0 = uploader;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Boolean bool;
                    switch (i4) {
                        case 0:
                            AutoValue_TransportContext autoValue_TransportContext3 = autoValue_TransportContext2;
                            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0.eventStore;
                            SQLiteDatabase db = sQLiteEventStore.getDb();
                            db.beginTransaction();
                            try {
                                Long transportContextId = SQLiteEventStore.getTransportContextId(db, autoValue_TransportContext3);
                                if (transportContextId == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = sQLiteEventStore.getDb().rawQuery(C0000.decode(new byte[]{55, 39, 41, 115, 113, 49, 17, 0, 23, 117, 99, 42, 44, 22, 1, 20, 0, 88, 70, 22, 17, 102, 127, 118, 99, 32, 65, 85, 11, 12, 17, 83, 74, 17, 110, 88, 83, 19, 12, 69, 94, 22, 40, 43, 40, 127, 102, 69, 0}, "dbe62e11731ea6", 2), new String[]{transportContextId.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                db.setTransactionSuccessful();
                                db.endTransaction();
                                return bool;
                            } catch (Throwable th2) {
                                db.endTransaction();
                                throw th2;
                            }
                        default:
                            SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) this.f$0.eventStore;
                            sQLiteEventStore2.getClass();
                            return (Iterable) sQLiteEventStore2.inTransaction(new ComponentMonitor$$ExternalSyntheticLambda0(sQLiteEventStore2, 3, autoValue_TransportContext2));
                    }
                }
            };
            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) uploader.guard;
            if (!((Boolean) sQLiteEventStore.runCriticalSection(criticalSection)).booleanValue()) {
                sQLiteEventStore.runCriticalSection(new Uploader$$ExternalSyntheticLambda9(uploader, autoValue_TransportContext2, jMax));
                return;
            }
            final int i5 = 1;
            Iterable iterable = (Iterable) sQLiteEventStore.runCriticalSection(new SynchronizationGuard.CriticalSection(uploader) { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda3
                public final /* synthetic */ Uploader f$0;

                {
                    this.f$0 = uploader;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Boolean bool;
                    switch (i5) {
                        case 0:
                            AutoValue_TransportContext autoValue_TransportContext3 = autoValue_TransportContext2;
                            SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) this.f$0.eventStore;
                            SQLiteDatabase db = sQLiteEventStore2.getDb();
                            db.beginTransaction();
                            try {
                                Long transportContextId = SQLiteEventStore.getTransportContextId(db, autoValue_TransportContext3);
                                if (transportContextId == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = sQLiteEventStore2.getDb().rawQuery(C0000.decode(new byte[]{55, 39, 41, 115, 113, 49, 17, 0, 23, 117, 99, 42, 44, 22, 1, 20, 0, 88, 70, 22, 17, 102, 127, 118, 99, 32, 65, 85, 11, 12, 17, 83, 74, 17, 110, 88, 83, 19, 12, 69, 94, 22, 40, 43, 40, 127, 102, 69, 0}, "dbe62e11731ea6", 2), new String[]{transportContextId.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                db.setTransactionSuccessful();
                                db.endTransaction();
                                return bool;
                            } catch (Throwable th2) {
                                db.endTransaction();
                                throw th2;
                            }
                        default:
                            SQLiteEventStore sQLiteEventStore3 = (SQLiteEventStore) this.f$0.eventStore;
                            sQLiteEventStore3.getClass();
                            return (Iterable) sQLiteEventStore3.inTransaction(new ComponentMonitor$$ExternalSyntheticLambda0(sQLiteEventStore3, 3, autoValue_TransportContext2));
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return;
            }
            int i6 = 4;
            if (transportBackend2 == null) {
                Trace.d(C0000.decode(new byte[]{102, 70, 90, 92, 80, 83, 4, 64}, "366317a217b0", 0.0f), C0000.decode(new byte[]{101, 12, 14, 8, 13, 20, 8, 17, 4, 87, 2, 83, 92, 88, 2, 22, 86, 13, 23, 70, 71, 16, 74, 17, 2, 83, 13, 93, 77, 95, 8, 81, 16, 7, 19, 3, 12, 23, 70, 83, 7, 66, 2, 80, 25, 80, 9, 68, 16, 11, 17, 72, 76, 77}, "0befbcf1f6a896f6"), autoValue_TransportContext2);
                autoValue_BackendResponse2 = new AutoValue_BackendResponse(3, -1L);
                bArr = bArr2;
                transportBackend = transportBackend2;
                j = jMax;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((AutoValue_PersistedEvent) it2.next()).event);
                }
                String strDecode = C0000.decode(new byte[]{22, 23, 11, 77, 89}, "fed967f8", 0.0f);
                if (bArr2 != null) {
                    ClientHealthMetricsStore clientHealthMetricsStore = uploader.clientHealthMetricsStore;
                    Objects.requireNonNull(clientHealthMetricsStore);
                    ClientMetrics clientMetrics = (ClientMetrics) sQLiteEventStore.runCriticalSection(new CctTransportBackend$$ExternalSyntheticLambda0(i6, clientHealthMetricsStore));
                    Request request = new Request();
                    request.lazyCacheControl = new HashMap();
                    request.body = Long.valueOf(uploader.clock.getTime());
                    request.tags = Long.valueOf(uploader.uptimeClock.getTime());
                    request.method = C0000.decode(new byte[]{113, 118, 55, 62, 116, 127, 125, 119, 120, 102, 60, 44, 114, 103, 102, 123, 117, 97}, "62ca7342", false);
                    Encoding encoding = new Encoding(strDecode);
                    clientMetrics.getClass();
                    WorkTagDao_Impl workTagDao_Impl = ProtoEncoderDoNotUse.ENCODER;
                    workTagDao_Impl.getClass();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        workTagDao_Impl.encode(clientMetrics, byteArrayOutputStream);
                    } catch (IOException unused) {
                    }
                    request.headers = new EncodedPayload(encoding, byteArrayOutputStream.toByteArray());
                    arrayList.add(((CctTransportBackend) transportBackend2).decorate(request.build()));
                }
                CctTransportBackend cctTransportBackend = (CctTransportBackend) transportBackend2;
                HashMap map2 = new HashMap();
                int size = arrayList.size();
                int i7 = 0;
                while (i7 < size) {
                    Object obj = arrayList.get(i7);
                    i7++;
                    AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj;
                    String str4 = autoValue_EventInternal.transportName;
                    if (map2.containsKey(str4)) {
                        ((List) map2.get(str4)).add(autoValue_EventInternal);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(autoValue_EventInternal);
                        map2.put(str4, arrayList2);
                    }
                    bArr2 = bArr2;
                }
                bArr = bArr2;
                ArrayList arrayList3 = new ArrayList();
                Iterator it3 = map2.entrySet().iterator();
                while (true) {
                    boolean zHasNext = it3.hasNext();
                    String strDecode2 = C0000.decode(new byte[]{114, 5, 67, 103, 17, 84, 91, 70, 65, 9, 69, 71, 33, 84, 86, 94, 84, 8, 83}, "1f73c555", 0.0f);
                    if (zHasNext) {
                        Map.Entry entry = (Map.Entry) it3.next();
                        AutoValue_EventInternal autoValue_EventInternal2 = (AutoValue_EventInternal) ((List) entry.getValue()).get(0);
                        QosTier qosTier = QosTier.DEFAULT;
                        long time = cctTransportBackend.wallTimeClock.getTime();
                        long time2 = cctTransportBackend.uptimeClock.getTime();
                        AutoValue_ClientInfo autoValue_ClientInfo = new AutoValue_ClientInfo(new AutoValue_AndroidClientInfo(Integer.valueOf(autoValue_EventInternal2.getInteger(C0000.decode(new byte[]{23, 5, 13, 29, 18, 84, 22, 18, 15, 95, 10}, "daf0d1", 0.0f))), autoValue_EventInternal2.get(C0000.decode(new byte[]{89, 93, 84, 93, 14}, "4208b9a35c", false)), autoValue_EventInternal2.get(C0000.decode(new byte[]{95, 82, 20, 84, 69, 84, 75, 7}, "73f0259b4e", 0.0f)), autoValue_EventInternal2.get(C0000.decode(new byte[]{83, 7, 18, 88, 91, 80}, "7bd185afd438", 0.0f)), autoValue_EventInternal2.get(C0000.decode(new byte[]{19, 70, 93, 93, 67, 81, 17}, "c42962ef6eaa67fd")), autoValue_EventInternal2.get(C0000.decode(new byte[]{91, 21, 72, 20, 15, 9, 6}, "4feafeb1c783e183", 0.0f)), autoValue_EventInternal2.get(C0000.decode(new byte[]{89, 84, 12, 64, 86, 2, 6, 69, 65, 64, 3, 20}, "45b50ce142ff8d5c", 0.0f)), autoValue_EventInternal2.get(C0000.decode(new byte[]{7, 81, 91, 95, 3, 74, 67, 71, 8, 10, 21}, "a858f835ad")), autoValue_EventInternal2.get(C0000.decode(new byte[]{10, 88, 80, 5, 85, 86}, "f73d93")), autoValue_EventInternal2.get(C0000.decode(new byte[]{7, 93, 76, 8, 22, 67, 72}, "d29fb114f2a33b51", true)), autoValue_EventInternal2.get(C0000.decode(new byte[]{85, 1, 86, 103, 93, 87, 6}, "8b5809eaa489", 2)), autoValue_EventInternal2.get(C0000.decode(new byte[]{80, 66, 67, 95, 10, 84, 3, 17, 88, 93, 93, 108, 1, 66, 11, 9, 85}, "1233c7be"))));
                        try {
                            numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                            str2 = null;
                        } catch (NumberFormatException unused2) {
                            str2 = (String) entry.getKey();
                            numValueOf = null;
                        }
                        ArrayList arrayList4 = new ArrayList();
                        for (AutoValue_EventInternal autoValue_EventInternal3 : (List) entry.getValue()) {
                            EncodedPayload encodedPayload = autoValue_EventInternal3.encodedPayload;
                            TransportBackend transportBackend3 = transportBackend2;
                            Encoding encoding2 = encodedPayload.encoding;
                            byte[] bArr3 = encodedPayload.bytes;
                            if (encoding2.equals(new Encoding(strDecode))) {
                                builder = new WorkerWrapper.Builder();
                                builder.mConfiguration = bArr3;
                                j2 = jMax;
                            } else {
                                j2 = jMax;
                                if (encoding2.equals(new Encoding(C0000.decode(new byte[]{15, 65, 10, 89}, "e2e7e11bd0")))) {
                                    String str5 = new String(bArr3, Charset.forName(C0000.decode(new byte[]{101, 109, 117, 73, 15}, "093d73bc1aad2a", true)));
                                    WorkerWrapper.Builder builder2 = new WorkerWrapper.Builder();
                                    builder2.mWorkDatabase = str5;
                                    builder = builder2;
                                } else if (Log.isLoggable(C0000.decode(new byte[]{102, 54, 76, 94, 71, 12, 92, 80, 27}, "2d903e1555").concat(strDecode2), 5)) {
                                    encoding2.toString();
                                }
                                transportBackend2 = transportBackend3;
                                jMax = j2;
                            }
                            builder.mAppContext = Long.valueOf(autoValue_EventInternal3.eventMillis);
                            builder.mWorkTaskExecutor = Long.valueOf(autoValue_EventInternal3.uptimeMillis);
                            String str6 = (String) autoValue_EventInternal3.autoMetadata.get(C0000.decode(new byte[]{64, 25, 25, 14, 4, 85, 22, 6, 64}, "4c4ab3ec", 0));
                            builder.mWorkSpec = Long.valueOf(str6 == null ? 0L : Long.valueOf(str6).longValue());
                            builder.mTags = new AutoValue_NetworkConnectionInfo((NetworkConnectionInfo.NetworkType) NetworkConnectionInfo.NetworkType.valueMap.get(autoValue_EventInternal3.getInteger(C0000.decode(new byte[]{93, 92, 70, 75, 65, 26, 72, 82}, "392f5c87d622", 0.0f))), (NetworkConnectionInfo.MobileSubtype) NetworkConnectionInfo.MobileSubtype.valueMap.get(autoValue_EventInternal3.getInteger(C0000.decode(new byte[]{85, 11, 84, 93, 92, 83, 20, 71, 77, 80, 67, 72, 18, 6}, "8d6406948271bc26", 7))));
                            Integer num = autoValue_EventInternal3.code;
                            if (num != null) {
                                builder.mForegroundProcessor = num;
                            }
                            String strDecode3 = ((Long) builder.mAppContext) == null ? C0000.decode(new byte[]{21, 4, 68, 82, 10, 69, 53, 15, 14, 84, 47, 70}, "5a27d1afc1b5809a") : "";
                            if (((Long) builder.mWorkTaskExecutor) == null) {
                                strDecode3 = strDecode3.concat(C0000.decode(new byte[]{70, 81, 20, 83, 95, 66, 52, 68, 69, 88, 92, 92, 47, 23}, "f4b616a41119bdcd"));
                            }
                            if (((Long) builder.mWorkSpec) == null) {
                                strDecode3 = strDecode3 + C0000.decode(new byte[]{24, 70, 8, 95, 0, 76, 91, 93, 93, 125, 7, 84, 22, 83, 64, 96, 93, 81, 14, 92, 1, 69}, "82a2e643", true);
                            }
                            if (!strDecode3.isEmpty()) {
                                throw new IllegalStateException(C0000.decode(new byte[]{117, 10, 22, 21, 8, 86, 4, 16, 20, 81, 21, 76, 94, 64, 82, 1, 24, 19, 23, 9, 17, 93, 17, 68, 15, 81, 23, 3}, "8cefa8c0f4d9727e").concat(strDecode3));
                            }
                            arrayList4.add(new AutoValue_LogEvent(((Long) builder.mAppContext).longValue(), (Integer) builder.mForegroundProcessor, ((Long) builder.mWorkTaskExecutor).longValue(), (byte[]) builder.mConfiguration, (String) builder.mWorkDatabase, ((Long) builder.mWorkSpec).longValue(), (AutoValue_NetworkConnectionInfo) builder.mTags));
                            transportBackend2 = transportBackend3;
                            jMax = j2;
                        }
                        arrayList3.add(new AutoValue_LogRequest(time, time2, autoValue_ClientInfo, numValueOf, str2, arrayList4));
                    } else {
                        transportBackend = transportBackend2;
                        j = jMax;
                        AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = new AutoValue_BatchedLogRequest(arrayList3);
                        URL urlOrThrow = cctTransportBackend.endPoint;
                        if (bArr != null) {
                            try {
                                CCTDestination cCTDestinationFromByteArray = CCTDestination.fromByteArray(bArr);
                                str = cCTDestinationFromByteArray.apiKey;
                                if (str == null) {
                                    str = null;
                                }
                                String str7 = cCTDestinationFromByteArray.endPoint;
                                if (str7 != null) {
                                    urlOrThrow = CctTransportBackend.parseUrlOrThrow(str7);
                                }
                            } catch (IllegalArgumentException unused3) {
                                autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                            }
                        } else {
                            str = null;
                        }
                        try {
                            WorkTagDao_Impl workTagDao_Impl2 = new WorkTagDao_Impl(urlOrThrow, autoValue_BatchedLogRequest, str);
                            CctTransportBackend$$ExternalSyntheticLambda0 cctTransportBackend$$ExternalSyntheticLambda0 = new CctTransportBackend$$ExternalSyntheticLambda0(0, cctTransportBackend);
                            int i8 = 5;
                            do {
                                httpResponseApply = cctTransportBackend$$ExternalSyntheticLambda0.apply(workTagDao_Impl2);
                                URL url = httpResponseApply.redirectUrl;
                                if (url != null) {
                                    Trace.d(strDecode2, C0000.decode(new byte[]{36, 93, 9, 89, 95, 17, 13, 12, 85, 66, 68, 6, 87, 93, 69, 92, 1, 70, 69, 65, 95, 92, 68, 71, 65}, "b2e50fdb2b6c3479", 0.0f), url);
                                    workTagDao_Impl2 = new WorkTagDao_Impl(url, (AutoValue_BatchedLogRequest) workTagDao_Impl2.__insertionAdapterOfWorkTag, (String) workTagDao_Impl2.__preparedStmtOfDeleteByWorkSpecId);
                                } else {
                                    workTagDao_Impl2 = null;
                                }
                                if (workTagDao_Impl2 == null) {
                                    break;
                                } else {
                                    i8--;
                                }
                            } while (i8 >= 1);
                            int i9 = httpResponseApply.code;
                            if (i9 == 200) {
                                autoValue_BackendResponse2 = new AutoValue_BackendResponse(1, httpResponseApply.nextRequestMillis);
                            } else {
                                if (i9 >= 500 || i9 == 404) {
                                    autoValue_BackendResponse = new AutoValue_BackendResponse(2, -1L);
                                } else if (i9 == 400) {
                                    try {
                                        autoValue_BackendResponse = new AutoValue_BackendResponse(4, -1L);
                                    } catch (IOException unused4) {
                                        Trace.getTag(strDecode2);
                                        i2 = 2;
                                        autoValue_BackendResponse2 = new AutoValue_BackendResponse(2, -1L);
                                        break;
                                    }
                                } else {
                                    autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                                }
                                autoValue_BackendResponse2 = autoValue_BackendResponse;
                            }
                        } catch (IOException unused5) {
                        }
                    }
                }
                i3 = autoValue_BackendResponse2.status;
                if (i3 == i2) {
                    sQLiteEventStore.runCriticalSection(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda0(this, iterable, autoValue_TransportContext, j));
                    this.workScheduler.schedule(autoValue_TransportContext, i + 1, true);
                    return;
                }
                uploader = this;
                autoValue_TransportContext2 = autoValue_TransportContext;
                jMax = j;
                sQLiteEventStore.runCriticalSection(new ComponentMonitor$$ExternalSyntheticLambda0(uploader, 1, iterable));
                if (i3 == 1) {
                    jMax = Math.max(jMax, autoValue_BackendResponse2.nextRequestWaitMillis);
                    if (bArr != null) {
                        sQLiteEventStore.runCriticalSection(new CctTransportBackend$$ExternalSyntheticLambda0(6, uploader));
                    }
                } else if (i3 == 4) {
                    map = new HashMap();
                    it = iterable.iterator();
                    while (it.hasNext()) {
                        str3 = ((AutoValue_PersistedEvent) it.next()).event.transportName;
                        if (map.containsKey(str3)) {
                            map.put(str3, Integer.valueOf(((Integer) map.get(str3)).intValue() + 1));
                        } else {
                            map.put(str3, 1);
                        }
                    }
                    sQLiteEventStore.runCriticalSection(new ComponentMonitor$$ExternalSyntheticLambda0(uploader, 2, map));
                }
                bArr2 = bArr;
                transportBackend2 = transportBackend;
            }
            i2 = 2;
            i3 = autoValue_BackendResponse2.status;
            if (i3 == i2) {
                sQLiteEventStore.runCriticalSection(new DelegatingScheduledExecutorService$$ExternalSyntheticLambda0(this, iterable, autoValue_TransportContext, j));
                this.workScheduler.schedule(autoValue_TransportContext, i + 1, true);
                return;
            }
            uploader = this;
            autoValue_TransportContext2 = autoValue_TransportContext;
            jMax = j;
            sQLiteEventStore.runCriticalSection(new ComponentMonitor$$ExternalSyntheticLambda0(uploader, 1, iterable));
            if (i3 == 1) {
                jMax = Math.max(jMax, autoValue_BackendResponse2.nextRequestWaitMillis);
                if (bArr != null) {
                    sQLiteEventStore.runCriticalSection(new CctTransportBackend$$ExternalSyntheticLambda0(6, uploader));
                }
            } else if (i3 == 4) {
                map = new HashMap();
                it = iterable.iterator();
                while (it.hasNext()) {
                    str3 = ((AutoValue_PersistedEvent) it.next()).event.transportName;
                    if (map.containsKey(str3)) {
                        map.put(str3, 1);
                    } else {
                        map.put(str3, Integer.valueOf(((Integer) map.get(str3)).intValue() + 1));
                    }
                }
                sQLiteEventStore.runCriticalSection(new ComponentMonitor$$ExternalSyntheticLambda0(uploader, 2, map));
            }
            bArr2 = bArr;
            transportBackend2 = transportBackend;
        }
    }
}
