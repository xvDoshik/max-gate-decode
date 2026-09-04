package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkLauncherImpl;
import com.google.android.gms.cloudmessaging.zzs;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzw;
import java.util.Map;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zag extends zac {
    public final zzr zaa;
    public final TaskCompletionSource zab;
    public final ByteString.Companion zad;

    public zag(zzr zzrVar, TaskCompletionSource taskCompletionSource, ByteString.Companion companion) {
        super(2);
        this.zab = taskCompletionSource;
        this.zaa = zzrVar;
        this.zad = companion;
        if (zzrVar.zzc) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{112, 1, 66, 17, 26, 6, 84, 2, 94, 23, 67, 67, 69, 22, 88, 17, 82, 67, 81, 5, 93, 9, 68, 67, 81, 5, 95, 11, 88, 23, 18, 20, 80, 22, 68, 67, 95, 1, 69, 13, 88, 7, 65, 68, 69, 13, 86, 23, 18, 23, 89, 10, 66, 15, 86, 68, 80, 16, 67, 12, 31, 22, 84, 22, 88, 15, 68, 1, 17, 8, 94, 16, 65, 13, 95, 2, 23, 5, 87, 5, 69, 16, 69, 6, 65, 74}, "2d1e7c", false));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        return this.zaa.zzc;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq zabqVar) {
        return (Feature[]) this.zaa.zza;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zad(Status status) {
        this.zad.getClass();
        this.zab.trySetException(status.zze != null ? new ResolvableApiException(status) : new zzs(status));
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zae(Exception exc) {
        this.zab.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        TaskCompletionSource taskCompletionSource = this.zab;
        try {
            this.zaa.doExecute(zabqVar.zac, taskCompletionSource);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zad(zac.zah(e2));
        } catch (RuntimeException e3) {
            taskCompletionSource.trySetException(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zag(WorkLauncherImpl workLauncherImpl, boolean z) {
        Map map = (Map) workLauncherImpl.workTaskExecutor;
        Boolean boolValueOf = Boolean.valueOf(z);
        TaskCompletionSource taskCompletionSource = this.zab;
        map.put(taskCompletionSource, boolValueOf);
        zzw zzwVar = taskCompletionSource.zza;
        OperationImpl operationImpl = new OperationImpl(workLauncherImpl, taskCompletionSource);
        zzwVar.getClass();
        zzwVar.zzb.zza(new zzh(TaskExecutors.MAIN_THREAD, operationImpl));
        zzwVar.zzi();
    }
}
