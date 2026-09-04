package com.google.android.datatransport.runtime;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.messaging.FirebaseMessagingRegistrar;
import com.google.firebase.platforminfo.AutoValue_LibraryVersion;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class TransportImpl$$ExternalSyntheticLambda0 implements SQLiteEventStore.Function, ComponentFactory, Continuation {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ TransportImpl$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        Cursor cursorRawQuery = ((SQLiteDatabase) obj).rawQuery(C0000.decode(new byte[]{48, 113, 121, 112, 115, 100, 25, 80, 10, 71, 65, 92, 94, 83, 77, 20, 23, 26, 106, 92, 84, 28, 25, 64, 77, 86, 84, 86, 91, 85, 87, 80, 60, 90, 84, 88, 85, 28, 25, 64, 77, 68, 71, 92, 95, 66, 80, 64, 26, 24, 21, 65, 30, 85, 65, 64, 17, 85, 70, 21, 118, 98, 118, 121, 67, 64, 71, 84, 94, 67, 73, 91, 17, 64, 106, 86, 95, 94, 77, 81, 27, 64, 70, 21, 113, 99, 25, 64, 79, 20, 80, 67, 85, 94, 77, 71, 67, 117, 102, 21, 85, 16, 110, 124, 38, 102, 112, 21, 85, 30, 90, 91, 13, 64, 80, 77, 68, 111, 80, 80, 67, 9, 21, 65, 30, 111, 80, 80}, "c4550094", 0.0f), new String[0]);
        try {
            ArrayList arrayList = new ArrayList();
            while (cursorRawQuery.moveToNext()) {
                zzac zzacVarBuilder = AutoValue_TransportContext.builder();
                zzacVarBuilder.setBackendName(cursorRawQuery.getString(1));
                zzacVarBuilder.zzc = PriorityMapping.valueOf(cursorRawQuery.getInt(2));
                String string = cursorRawQuery.getString(3);
                zzacVarBuilder.zza = string == null ? null : Base64.decode(string, 0);
                arrayList.add(zzacVarBuilder.build());
            }
            return arrayList;
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(Request.Builder builder) {
        switch (this.$r8$classId) {
            case 7:
                return (ScheduledExecutorService) ExecutorsRegistrar.BG_EXECUTOR.get();
            case 8:
                return (ScheduledExecutorService) ExecutorsRegistrar.BLOCKING_EXECUTOR.get();
            case 9:
                return (ScheduledExecutorService) ExecutorsRegistrar.LITE_EXECUTOR.get();
            case 10:
                Lazy lazy = ExecutorsRegistrar.BG_EXECUTOR;
                return UiExecutor.INSTANCE;
            case 11:
                return TransportRegistrar.lambda$getComponents$0(builder);
            case 12:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(builder);
            case 13:
            case 14:
            case 15:
            default:
                Set of = builder.setOf(Qualified.unqualified(AutoValue_LibraryVersion.class));
                ConnectionPool connectionPool = ConnectionPool.INSTANCE;
                if (connectionPool == null) {
                    synchronized (ConnectionPool.class) {
                        try {
                            connectionPool = ConnectionPool.INSTANCE;
                            if (connectionPool == null) {
                                connectionPool = new ConnectionPool(1);
                                ConnectionPool.INSTANCE = connectionPool;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                }
                return new DefaultUserAgentPublisher(of, connectionPool);
            case 16:
                return FirebaseMessagingRegistrar.lambda$getComponents$0(builder);
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) throws IOException {
        int i;
        Object obj;
        switch (this.$r8$classId) {
            case 13:
                i = 403;
                break;
            case 14:
                i = -1;
                break;
            default:
                zzw zzwVar = (zzw) task;
                synchronized (zzwVar.zza) {
                    boolean z = zzwVar.zzc;
                    String strDecode = C0000.decode(new byte[]{55, 88, 66, 9, 22, 15, 18, 17, 13, 86, 69, 66, 79, 3, 21, 17, 0, 86, 92, 18, 90, 3, 21, 84}, "c91b6fa1", 1);
                    if (!z) {
                        throw new IllegalStateException(strDecode);
                    }
                    if (zzwVar.zzd) {
                        throw new CancellationException(C0000.decode(new byte[]{97, 81, 68, 93, 25, 90, 22, 69, 88, 93, 69, 82, 84, 84, 78, 22, 90, 82, 11, 6, 92, 93, 82, 83, 27}, "507693ee9177", 6));
                    }
                    if (IOException.class.isInstance(zzwVar.zzf)) {
                        throw ((Throwable) IOException.class.cast(zzwVar.zzf));
                    }
                    Exception exc = zzwVar.zzf;
                    if (exc != null) {
                        throw new RuntimeExecutionException(exc);
                    }
                    obj = zzwVar.zze;
                }
                Bundle bundle = (Bundle) obj;
                String strDecode2 = C0000.decode(new byte[]{103, 39, 49, 55, 123, 37, 32, 59, 118, 119, 103, 106, 117, 52, 34, 40, 126, 39, 39, 40, 125}, "4bca2fed8835");
                if (bundle == null) {
                    throw new IOException(strDecode2);
                }
                String string = bundle.getString(C0000.decode(new byte[]{67, 0, 2, 8, 18, 77, 68, 2, 76, 94, 9, 11, 109, 89, 93}, "1eeaa96c87fe2099", 2));
                if (string != null || (string = bundle.getString(C0000.decode(new byte[]{71, 11, 74, 0, 80, 12, 71, 67, 7, 16, 87, 1}, "2e8e7e47bb"))) != null) {
                    return string;
                }
                String string2 = bundle.getString(C0000.decode(new byte[]{3, 16, 69, 13, 68}, "fb7b6816eee5", false));
                if (C0000.decode(new byte[]{101, 107, 100}, "780f345744", 0.0f).equals(string2)) {
                    throw new IOException(C0000.decode(new byte[]{122, 120, 106, 55, 121, 118, 112, 115, 102, 42, 124, 103, 97, 115, 106, 38, 108}, "369c88"));
                }
                if (string2 != null) {
                    throw new IOException(string2);
                }
                bundle.toString();
                new Throwable();
                throw new IOException(strDecode2);
        }
        return Integer.valueOf(i);
    }

    public /* synthetic */ TransportImpl$$ExternalSyntheticLambda0(Request request) {
        this.$r8$classId = 17;
    }
}
