package com.google.android.gms.tasks;

import androidx.work.Worker;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzh implements zzq, OnSuccessListener, OnFailureListener, OnCanceledListener {
    public final /* synthetic */ int $r8$classId;
    public final Executor zza;
    public final Object zzb;
    public final Object zzc;

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.$r8$classId = 0;
        this.zzb = new Object();
        this.zza = executor;
        this.zzc = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public void onCanceled() {
        ((zzw) this.zzc).zzc();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        ((zzw) this.zzc).zza(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((zzw) this.zzc).zzb(obj);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        switch (this.$r8$classId) {
            case 0:
                if (((zzw) task).zzd) {
                    synchronized (this.zzb) {
                        break;
                    }
                    this.zza.execute(new Worker.AnonymousClass1(13, this));
                    return;
                }
                return;
            case 1:
                synchronized (this.zzb) {
                    break;
                }
                this.zza.execute(new Worker.AnonymousClass2(this, 11, task));
                return;
            case 2:
                if (task.isSuccessful() || ((zzw) task).zzd) {
                    return;
                }
                synchronized (this.zzb) {
                    break;
                }
                this.zza.execute(new Worker.AnonymousClass2(this, 12, task));
                return;
            case 3:
                if (task.isSuccessful()) {
                    synchronized (this.zzb) {
                        break;
                    }
                    this.zza.execute(new Worker.AnonymousClass2(this, 13, task));
                    return;
                }
                return;
            default:
                this.zza.execute(new Worker.AnonymousClass2(this, 14, task));
                return;
        }
    }

    public zzh(Executor executor, OnCompleteListener onCompleteListener) {
        this.$r8$classId = 1;
        this.zzb = new Object();
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public zzh(Executor executor, OnFailureListener onFailureListener) {
        this.$r8$classId = 2;
        this.zzb = new Object();
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    public zzh(Executor executor, OnSuccessListener onSuccessListener) {
        this.$r8$classId = 3;
        this.zzb = new Object();
        this.zza = executor;
        this.zzc = onSuccessListener;
    }

    public zzh(Executor executor, SuccessContinuation successContinuation, zzw zzwVar) {
        this.$r8$classId = 4;
        this.zza = executor;
        this.zzb = successContinuation;
        this.zzc = zzwVar;
    }
}
