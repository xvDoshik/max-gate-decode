package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzag;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzw extends Task {
    public final Object zza = new Object();
    public final zzr zzb = new zzr();
    public boolean zzc;
    public volatile boolean zzd;
    public Object zze;
    public Exception zzf;

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        this.zzb.zza(new zzh(executor, onCompleteListener));
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        this.zzb.zza(new zzh(executor, onSuccessListener));
        zzi();
        return this;
    }

    public final zzw continueWith(Executor executor, Continuation continuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzd(executor, continuation, zzwVar, 0));
        zzi();
        return zzwVar;
    }

    public final zzw continueWithTask(Executor executor, Continuation continuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzd(executor, continuation, zzwVar, 1));
        zzi();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object getResult() {
        Object obj;
        synchronized (this.zza) {
            try {
                boolean z = this.zzc;
                String strDecode = C0000.decode(new byte[]{108, 89, 75, 13, 18, 91, 68, 17, 87, 95, 64, 70, 78, 6, 22, 25, 91, 87, 85, 22, 94, 87, 67, 84}, "888f2271904f7cb9", true);
                if (!z) {
                    throw new IllegalStateException(strDecode);
                }
                if (this.zzd) {
                    throw new CancellationException(C0000.decode(new byte[]{102, 5, 21, 10, 16, 88, 66, 23, 80, 15, 68, 4, 87, 82, 75, 68, 5, 0, 94, 82, 84, 91, 84, 7, 24}, "2dfa01171c6a66", true));
                }
                Exception exc = this.zzf;
                if (exc != null) {
                    throw new RuntimeExecutionException(exc);
                }
                obj = this.zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            try {
                z = false;
                if (this.zzc && !this.zzd && this.zzf == null) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final zzw onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzh(executor, successContinuation, zzwVar));
        zzi();
        return zzwVar;
    }

    public final void zza(Exception exc) {
        zzag.checkNotNull(exc, C0000.decode(new byte[]{35, 72, 2, 83, 66, 77, 88, 88, 91, 70, 90, 20, 21, 68, 65, 88, 93, 77, 17, 85, 80, 70, 89, 20, 10, 92}, "f0a629175f7a"));
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zzf = exc;
        }
        this.zzb.zzb(this);
    }

    public final void zzb(Object obj) {
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zze = obj;
        }
        this.zzb.zzb(this);
    }

    public final void zzc() {
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    return;
                }
                this.zzc = true;
                this.zzd = true;
                this.zzb.zzb(this);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzh() {
        String strDecode;
        if (this.zzc) {
            int i = ClosedSendChannelException.$r8$clinit;
            if (!isComplete()) {
                throw new IllegalStateException(C0000.decode(new byte[]{34, 67, 21, 10, 92, 7, 82, 66, 80, 101, 83, 65, 13, 117, 10, 11, 69, 8, 86, 66, 92, 94, 92, 119, 30, 85, 0, 22, 65, 13, 92, 88, 21, 82, 83, 92, 70, 89, 11, 10, 76, 68, 81, 83, 21, 82, 64, 87, 7, 66, 0, 2, 21, 2, 65, 89, 88, 17, 81, 93, 11, 70, 9, 3, 65, 1, 87, 22, 97, 80, 65, 89, 72}, "f6ef5d365122"));
            }
            Exception exception = getException();
            if (exception != null) {
                strDecode = C0000.decode(new byte[]{82, 81, 81, 89, 71, 67, 86}, "4085213cf10946e2", 6);
            } else if (isSuccessful()) {
                strDecode = C0000.decode(new byte[]{66, 85, 66, 70, 91, 17, 66}, "00137eb66a", 7).concat(String.valueOf(getResult()));
            } else {
                strDecode = this.zzd ? C0000.decode(new byte[]{81, 0, 90, 91, 3, 92, 89, 88, 67, 95, 92, 91}, "2a48f059763568c6") : C0000.decode(new byte[]{23, 88, 89, 88, 12, 66, 93, 70, 12, 64, 22, 19, 4}, "b626c53fe3efa1", 6);
            }
        }
    }

    public final void zzi() {
        synchronized (this.zza) {
            try {
                if (this.zzc) {
                    this.zzb.zzb(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
