package com.google.firebase.tracing;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Trace;
import androidx.collection.ArrayMap;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.messaging.EnhancedIntentService;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.platforminfo.AutoValue_LibraryVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class ComponentMonitor$$ExternalSyntheticLambda0 implements SynchronizationGuard.CriticalSection, SQLiteEventStore.Function, OnCompleteListener, Continuation, ComponentFactory {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ComponentMonitor$$ExternalSyntheticLambda0(RequestDeduplicator requestDeduplicator, String str) {
        this.$r8$classId = 5;
        this.f$1 = requestDeduplicator;
        this.f$0 = str;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        AutoValue_EventStoreConfig autoValue_EventStoreConfig = sQLiteEventStore.config;
        ArrayList arrayListLoadEvents = sQLiteEventStore.loadEvents(sQLiteDatabase, autoValue_TransportContext, autoValue_EventStoreConfig.loadBatchSize);
        for (Priority priority : Priority.values()) {
            if (priority != autoValue_TransportContext.priority) {
                int size = autoValue_EventStoreConfig.loadBatchSize - arrayListLoadEvents.size();
                if (size <= 0) {
                    break;
                }
                zzac zzacVarBuilder = AutoValue_TransportContext.builder();
                zzacVarBuilder.setBackendName(autoValue_TransportContext.backendName);
                if (priority == null) {
                    throw new NullPointerException(C0000.decode(new byte[]{122, 17, 90, 95, 65, 20, 23, 92, 91, 22, 95, 71, 24}, "4d63ade5"));
                }
                zzacVarBuilder.zzc = priority;
                zzacVarBuilder.zza = autoValue_TransportContext.extras;
                arrayListLoadEvents.addAll(sQLiteEventStore.loadEvents(sQLiteDatabase, zzacVarBuilder.build(), size));
            }
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{82, 69, 86, 86, 64, 109, 94, 87, 19, 113, 122, 18, 31}, "733842"));
        for (int i = 0; i < arrayListLoadEvents.size(); i++) {
            sb.append(((AutoValue_PersistedEvent) arrayListLoadEvents.get(i)).id);
            if (i < arrayListLoadEvents.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query(C0000.decode(new byte[]{4, 71, 82, 90, 23, 109, 89, 4, 70, 86, 5, 80, 67, 85}, "a174c24a27"), new String[]{C0000.decode(new byte[]{4, 70, 0, 86, 65, 105, 11, 86}, "a0e856b254a8"), C0000.decode(new byte[]{10, 82, 11, 6}, "d3fcf0"), C0000.decode(new byte[]{21, 83, 8, 70, 6}, "c2d3c0")}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j), hashSet);
                }
                hashSet.add(new SQLiteEventStore.Metadata(cursorQuery.getString(1), cursorQuery.getString(2)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayListLoadEvents.listIterator();
        while (listIterator.hasNext()) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) listIterator.next();
            long j2 = autoValue_PersistedEvent.id;
            if (map.containsKey(Long.valueOf(j2))) {
                Request builder = autoValue_PersistedEvent.event.toBuilder();
                for (SQLiteEventStore.Metadata metadata : (Set) map.get(Long.valueOf(j2))) {
                    builder.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(new AutoValue_PersistedEvent(j2, autoValue_PersistedEvent.transportContext, builder.build()));
            }
        }
        return arrayListLoadEvents;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002e  */
    @Override // com.google.firebase.components.ComponentFactory
    public Object create(Request.Builder builder) {
        String strValueOf;
        switch (this.$r8$classId) {
            case 0:
                String str = (String) this.f$0;
                Component component = (Component) this.f$1;
                try {
                    Trace.beginSection(str);
                    return component.factory.create(builder);
                } finally {
                    Trace.endSection();
                }
            default:
                String str2 = (String) this.f$0;
                TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = (TransportImpl$$ExternalSyntheticLambda0) this.f$1;
                Context context = (Context) builder.get(Context.class);
                switch (transportImpl$$ExternalSyntheticLambda0.$r8$classId) {
                    case 2:
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        if (applicationInfo == null) {
                            strValueOf = "";
                        } else {
                            strValueOf = String.valueOf(applicationInfo.targetSdkVersion);
                        }
                        break;
                    case 3:
                        ApplicationInfo applicationInfo2 = context.getApplicationInfo();
                        if (applicationInfo2 == null) {
                            strValueOf = "";
                        } else {
                            strValueOf = String.valueOf(applicationInfo2.minSdkVersion);
                        }
                        break;
                    case 4:
                        if (context.getPackageManager().hasSystemFeature(C0000.decode(new byte[]{88, 94, 1, 69, 9, 11, 93, 30, 13, 86, 20, 6, 78, 81, 23, 82, 72, 22, 64, 64, 0, 25, 18, 7, 85, 85, 19, 94, 21, 11, 86, 94}, "90e7fb", 0.0f))) {
                            strValueOf = C0000.decode(new byte[]{65, 64}, "5606724f05fb80");
                        } else if (context.getPackageManager().hasSystemFeature(C0000.decode(new byte[]{4, 90, 85, 64, 90, 92, 83, 31, 88, 89, 23, 80, 70, 83, 71, 80, 25, 69, 73, 72, 0, 26, 70, 83, 65, 86, 95}, "e412557108", 0.0f))) {
                            strValueOf = C0000.decode(new byte[]{79, 88, 18, 0, 94}, "89fc61149232ea46");
                        } else if (context.getPackageManager().hasSystemFeature(C0000.decode(new byte[]{5, 92, 85, 19, 12, 88, 6, 76, 13, 80, 74, 7, 19, 83, 67, 4, 77, 69, 27, 18, 0, 31, 89, 22, 16, 93, 92, 14, 23, 88, 20, 7}, "d21ac1bbe18c", 4))) {
                            strValueOf = C0000.decode(new byte[]{81, 65, 71, 90}, "043526", false);
                        } else if (!context.getPackageManager().hasSystemFeature(C0000.decode(new byte[]{81, 8, 2, 67, 14, 89, 82, 31, 11, 5, 66, 2, 17, 80, 19, 85, 24, 69, 26, 20, 85, 72, 3, 92, 3, 85, 82, 85, 6, 0}, "0ff1a061cd", false))) {
                            strValueOf = "";
                        } else {
                            strValueOf = C0000.decode(new byte[]{1, 11, 80, 83, 93, 93, 93, 1}, "df26998e2aac89", 0.0f);
                        }
                        break;
                    default:
                        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                        if (installerPackageName == null) {
                            strValueOf = "";
                        } else {
                            strValueOf = FirebaseCommonRegistrar.safeValue(installerPackageName);
                        }
                        break;
                }
                return new AutoValue_LibraryVersion(str2, strValueOf);
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.$r8$classId) {
            case 1:
                Uploader uploader = (Uploader) this.f$0;
                Iterable iterable = (Iterable) this.f$1;
                SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) uploader.eventStore;
                sQLiteEventStore.getClass();
                if (iterable.iterator().hasNext()) {
                    sQLiteEventStore.getDb().compileStatement(C0000.decode(new byte[]{39, 119, 122, 35, 53, 114, 16, 117, 100, 121, 125, 25, 0, 18, 6, 92, 66, 21, 65, 96, 120, 118, 100, 115, 16, 102, 12, 0, 67, 91, 88, 70}, "c26fa7036609ed", 2) + SQLiteEventStore.toIdList(iterable)).execute();
                    break;
                }
                break;
            default:
                Uploader uploader2 = (Uploader) this.f$0;
                for (Map.Entry entry : ((HashMap) this.f$1).entrySet()) {
                    ((SQLiteEventStore) uploader2.clientHealthMetricsStore).recordLogEventDropped(((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        EnhancedIntentService enhancedIntentService = (EnhancedIntentService) this.f$0;
        Intent intent = (Intent) this.f$1;
        int i = EnhancedIntentService.$r8$clinit;
        enhancedIntentService.finishTask(intent);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        RequestDeduplicator requestDeduplicator = (RequestDeduplicator) this.f$1;
        String str = (String) this.f$0;
        synchronized (requestDeduplicator) {
            ((ArrayMap) requestDeduplicator.getTokenRequests).remove(str);
        }
        return task;
    }

    public /* synthetic */ ComponentMonitor$$ExternalSyntheticLambda0(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }
}
