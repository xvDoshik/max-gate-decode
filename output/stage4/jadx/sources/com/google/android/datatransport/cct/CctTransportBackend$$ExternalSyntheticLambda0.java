package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.tracing.Trace;
import androidx.work.JobListenableFuture;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_LogResponse;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonValueObjectEncoderContext;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessaging$$ExternalSyntheticLambda4;
import com.google.firebase.messaging.ServiceStarter;
import com.google.firebase.messaging.TopicsSubscriber;
import com.google.firebase.messaging.WakeLockHolder;
import com.google.firebase.messaging.WithinAppServiceConnection;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class CctTransportBackend$$ExternalSyntheticLambda0 implements SupportSQLiteOpenHelper.Factory, OnSuccessListener, SynchronizationGuard.CriticalSection, ComponentFactory, OnCompleteListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ CctTransportBackend$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    public CctTransportBackend.HttpResponse apply(WorkTagDao_Impl workTagDao_Impl) throws IOException {
        CctTransportBackend cctTransportBackend = (CctTransportBackend) this.f$0;
        URL url = (URL) workTagDao_Impl.__db;
        String strDecode = C0000.decode(new byte[]{96, 51, 68, 12, 71, 93, 12, 6, 77}, "4a1b34acc422b318", 1);
        String strDecode2 = C0000.decode(new byte[]{118, 81, 16, 100, 64, 4, 94, 66, 73, 90, 66, 65, 117, 80, 86, 89, 1, 94, 86}, "52d02e01950571", 4);
        if (Log.isLoggable(strDecode.concat(strDecode2), 4)) {
            String.format(C0000.decode(new byte[]{44, 88, 95, 94, 13, 81, 23, 65, 4, 67, 71, 87, 18, 77, 20, 67, 12, 12, 23, 22, 18}, "a947c673a222", true), url);
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cctTransportBackend.readTimeout);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(C0000.decode(new byte[]{103, 125, 53, 55}, "72fc8894ce01f5", 7));
        httpURLConnection.setRequestProperty(C0000.decode(new byte[]{51, 16, 93, 69, 29, 113, 2, 4, 92, 66}, "fc8700ea266a5b6c", 3), C0000.decode(new byte[]{81, 7, 67, 7, 76, 74, 84, 8, 68, 22, 87, 74, 65, 73, 4, 72, 9, 22, 13, 70, 86, 8, 92, 74, 90, 15, 83, 73}, "5f7f88"));
        String strDecode3 = C0000.decode(new byte[]{39, 93, 8, 16, 92, 91, 70, 78, 125, 91, 0, 92, 0, 91, 8, 3}, "d2fd952c85c3", true);
        String strDecode4 = C0000.decode(new byte[]{2, 27, 91, 19}, "ea2cf60c50", 6);
        httpURLConnection.setRequestProperty(strDecode3, strDecode4);
        String strDecode5 = C0000.decode(new byte[]{88, 22, 18, 8, 92, 5, 0, 69, 93, 91, 94, 27, 83, 21, 13, 10}, "9fbd5fa14404", 4);
        String strDecode6 = C0000.decode(new byte[]{37, 92, 94, 77, 6, 91, 16, 21, 108, 76, 66, 87}, "f309c5d88522103a", true);
        httpURLConnection.setRequestProperty(strDecode6, strDecode5);
        httpURLConnection.setRequestProperty(C0000.decode(new byte[]{35, 85, 87, 7, 73, 18, 30, 36, 93, 82, 89, 80, 94, 8, 5}, "b64b9f3a31647f"), strDecode4);
        String str = (String) workTagDao_Impl.__preparedStmtOfDeleteByWorkSpecId;
        if (str != null) {
            httpURLConnection.setRequestProperty(C0000.decode(new byte[]{96, 79, 35, 94, 93, 82, 25, 116, 21, 90, 21, 126, 1, 79}, "8bd12545e385d6"), str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    ConnectionPool connectionPool = cctTransportBackend.dataEncoder;
                    AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = (AutoValue_BatchedLogRequest) workTagDao_Impl.__insertionAdapterOfWorkTag;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) connectionPool.delegate;
                    JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(bufferedWriter, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
                    jsonValueObjectEncoderContext.add(autoValue_BatchedLogRequest);
                    jsonValueObjectEncoderContext.maybeUnNest();
                    jsonValueObjectEncoderContext.jsonWriter.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer numValueOf = Integer.valueOf(responseCode);
                    if (Log.isLoggable(strDecode.concat(strDecode2), 4)) {
                        String.format(C0000.decode(new byte[]{54, 66, 3, 21, 64, 16, 19, 33, 95, 2, 80, 12, 68, 20, 1}, "e6ba5c3b0f56d1"), numValueOf);
                    }
                    Trace.d(strDecode2, C0000.decode(new byte[]{113, 94, 8, 76, 85, 8, 16, 21, 97, 28, 71, 93, 95, 68, 23, 66}, "21f80fd85e78ed", 0), httpURLConnection.getHeaderField(strDecode6));
                    Trace.d(strDecode2, C0000.decode(new byte[]{122, 92, 87, 16, 80, 87, 21, 75, 124, 93, 90, 11, 81, 80, 15, 1, 3, 19, 28, 23}, "939d59af", 7), httpURLConnection.getHeaderField(strDecode3));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new CctTransportBackend.HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField(C0000.decode(new byte[]{41, 86, 91, 82, 71, 94, 94, 95}, "e9833711e0abea", 0.0f))), 0L);
                    }
                    if (responseCode != 200) {
                        return new CctTransportBackend.HttpResponse(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = strDecode4.equals(httpURLConnection.getHeaderField(strDecode3)) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            CctTransportBackend.HttpResponse httpResponse = new CctTransportBackend.HttpResponse(responseCode, null, AutoValue_LogResponse.fromJson(new BufferedReader(new InputStreamReader(gZIPInputStream))).nextRequestWaitMillis);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return httpResponse;
                        } catch (Throwable th) {
                            if (gZIPInputStream == null) {
                                throw th;
                            }
                            try {
                                gZIPInputStream.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        if (inputStream == null) {
                            throw th3;
                        }
                        try {
                            inputStream.close();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                } catch (Throwable th5) {
                    try {
                        gZIPOutputStream.close();
                        throw th5;
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                if (outputStream == null) {
                    throw th7;
                }
                try {
                    outputStream.close();
                    throw th7;
                } catch (Throwable th8) {
                    th7.addSuppressed(th8);
                    throw th7;
                }
            }
        } catch (EncodingException | IOException unused) {
            Trace.getTag(strDecode2);
            return new CctTransportBackend.HttpResponse(400, null, 0L);
        } catch (ConnectException | UnknownHostException unused2) {
            Trace.getTag(strDecode2);
            return new CctTransportBackend.HttpResponse(500, null, 0L);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        Context context = (Context) this.f$0;
        String str = configuration.name;
        RoomOpenHelper roomOpenHelper = configuration.callback;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{127, 76, 70, 67, 21, 17, 87, 77, 21, 86, 21, 12, 93, 87, 24, 89, 64, 14, 94, 25, 81, 86, 65, 3, 80, 88, 70, 82, 21, 12, 83, 84, 80, 23, 65, 13, 18, 88, 21, 84, 90, 12, 84, 80, 82, 66, 71, 3, 70, 80, 90, 89, 21, 22, 90, 88, 65, 23, 64, 17, 87, 74, 21, 67, 93, 7, 18, 87, 90, 23, 87, 3, 81, 82, 64, 71, 21, 6, 91, 75, 80, 84, 65, 13, 64, 64, 27}, "29575b", true));
        }
        return new FrameworkSQLiteOpenHelper(context, str, roomOpenHelper, true, true);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        int i = this.$r8$classId;
        int i2 = 1;
        Object obj = this.f$0;
        switch (i) {
            case 4:
                SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((ClientHealthMetricsStore) obj);
                sQLiteEventStore.getClass();
                int i3 = ClientMetrics.$r8$clinit;
                ServiceStarter serviceStarter = new ServiceStarter();
                serviceStarter.hasWakeLockPermission = null;
                serviceStarter.hasAccessNetworkStatePermission = new ArrayList();
                serviceStarter.messagingEvents = null;
                serviceStarter.firebaseMessagingServiceClassName = "";
                HashMap map = new HashMap();
                String strDecode = C0000.decode(new byte[]{99, 118, 122, 32, 115, 102, 21, 94, 11, 4, 111, 64, 89, 16, 66, 81, 80, 30, 68, 17, 85, 82, 69, 10, 94, 30, 21, 87, 18, 6, 94, 71, 69, 58, 84, 64, 90, 66, 20, 6, 84, 108, 85, 10, 69, 92, 65, 18, 34, 49, 127, 126, 22, 9, 95, 85, 106, 87, 18, 6, 94, 71, 105, 1, 66, 93, 69, 66, 1, 7}, "036e0252dc");
                SQLiteDatabase db = sQLiteEventStore.getDb();
                db.beginTransaction();
                try {
                    ClientMetrics clientMetrics = (ClientMetrics) SQLiteEventStore.tryWithCursor(db.rawQuery(strDecode, new String[0]), new FirebaseMessaging$$ExternalSyntheticLambda4(sQLiteEventStore, map, serviceStarter, 4));
                    db.setTransactionSuccessful();
                    return clientMetrics;
                } finally {
                    db.endTransaction();
                }
            case 5:
                SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) ((EventStore) obj);
                long time = sQLiteEventStore2.wallClock.getTime() - sQLiteEventStore2.config.eventCleanUpAge;
                SQLiteDatabase db2 = sQLiteEventStore2.getDb();
                db2.beginTransaction();
                try {
                    String strDecode2 = C0000.decode(new byte[]{97, 116, 122, 35, 116, 100, 17, 33, 123, 54, 124, 101, 30, 76, 30, 28, 17, 22, 70, 2, 92, 66, 70, 9, 69, 68, 110, 12, 85, 14, 87, 17, 112, 52, 120, 125, 17, 7, 66, 6, 92, 69, 69, 70, 96, 120, 116, 48, 113, 67, 70, 88, 91, 3, 68, 68, 80, 15, 68, 60, 95, 66, 22, 90, 23, 15, 17, 37, 102, 44, 103, 97, 22, 36, 110, 16, 69, 16, 85, 13, 65, 65, 89, 20, 67, 111, 95, 3, 89, 6}, "216f701b4c", 0.0f);
                    String[] strArr = {String.valueOf(time)};
                    Cursor cursorRawQuery = db2.rawQuery(strDecode2, strArr);
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            sQLiteEventStore2.recordLogEventDropped(cursorRawQuery.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursorRawQuery.getString(1));
                        } catch (Throwable th) {
                            cursorRawQuery.close();
                            throw th;
                        }
                    }
                    cursorRawQuery.close();
                    int iDelete = db2.delete(C0000.decode(new byte[]{86, 64, 3, 95, 67, 16}, "36f17cae1418", false), C0000.decode(new byte[]{16, 90, 94, 4, 65, 68, 5, 94, 67, 62, 95, 67, 68, 15, 19, 94}, "d33a20", false), strArr);
                    db2.setTransactionSuccessful();
                    db2.endTransaction();
                    return Integer.valueOf(iDelete);
                } catch (Throwable th2) {
                    db2.endTransaction();
                    throw th2;
                }
            case 6:
                SQLiteEventStore sQLiteEventStore3 = (SQLiteEventStore) ((Uploader) obj).clientHealthMetricsStore;
                SQLiteDatabase db3 = sQLiteEventStore3.getDb();
                db3.beginTransaction();
                try {
                    db3.compileStatement(C0000.decode(new byte[]{39, 115, 122, 116, 48, 118, 16, 113, 106, 121, 123, 21, 15, 89, 81, 110, 1, 69, 85, 89, 76, 105, 82, 71, 12, 70, 70, 84, 0}, "c661d3078665")).execute();
                    db3.compileStatement(C0000.decode(new byte[]{55, 99, 113, 118, 50, 124, 66, 95, 92, 95, 82, 3, 14, 108, 89, 88, 1, 102, 7, 78, 85, 94, 68, 61, 17, 71, 84, 67, 3, 25, 49, 125, 100, 16, 92, 3, 17, 71, 106, 90, 3, 77, 16, 81, 83, 67, 111, 23, 18, 95, 90, 86, 2, 102, 15, 75, 13}, "b357f9b8000b") + sQLiteEventStore3.wallClock.getTime()).execute();
                    db3.setTransactionSuccessful();
                    return null;
                } finally {
                    db3.endTransaction();
                }
            default:
                Dispatcher dispatcher = (Dispatcher) obj;
                Iterator it = ((Iterable) ((SQLiteEventStore) ((EventStore) dispatcher.readyAsyncCalls)).inTransaction(new TransportImpl$$ExternalSyntheticLambda0(i2))).iterator();
                while (it.hasNext()) {
                    ((WorkTagDao_Impl) dispatcher.runningAsyncCalls).schedule((AutoValue_TransportContext) it.next(), 1, false);
                }
                return null;
        }
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.$r8$classId) {
            case 11:
                WakeLockHolder.completeWakefulIntent((Intent) this.f$0);
                break;
            case 12:
                ((WithinAppServiceConnection.BindRequest) this.f$0).taskCompletionSource.trySetResult(null);
                break;
            default:
                ((ScheduledFuture) this.f$0).cancel(false);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        boolean z;
        switch (this.$r8$classId) {
            case 2:
                ((JobListenableFuture.AnonymousClass1) this.f$0).invoke(obj);
                return;
            case 3:
                ((JobListenableFuture.AnonymousClass1) this.f$0).invoke(obj);
                return;
            default:
                TopicsSubscriber topicsSubscriber = (TopicsSubscriber) obj;
                if (!((FirebaseMessaging) this.f$0).autoInit.isEnabled() || topicsSubscriber.store.getNextTopicOperation() == null) {
                    return;
                }
                synchronized (topicsSubscriber) {
                    z = topicsSubscriber.syncScheduledOrRunning;
                }
                if (z) {
                    return;
                }
                topicsSubscriber.syncWithDelaySecondsInternal(0L);
                return;
        }
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(Request.Builder builder) {
        switch (this.$r8$classId) {
            case 8:
                return this.f$0;
            default:
                return new DefaultHeartBeatController((Context) builder.get(Context.class), ((FirebaseApp) builder.get(FirebaseApp.class)).getPersistenceKey(), builder.setOf(Qualified.unqualified(ProfileInstaller$2.class)), builder.getProvider(DefaultUserAgentPublisher.class), (Executor) builder.get((Qualified) this.f$0));
        }
    }
}
