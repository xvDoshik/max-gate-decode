package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.work.Worker;
import androidx.work.impl.OperationImpl;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class zzh implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ zzn zza;

    public /* synthetic */ zzh(zzn zznVar, int i) {
        this.$r8$classId = i;
        this.zza = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                zzn zznVar = this.zza;
                synchronized (zznVar) {
                    if (zznVar.zza == 1) {
                        zznVar.zza(C0000.decode(new byte[]{48, 81, 90, 1, 86, 21, 93, 69, 67, 69, 67, 81, 90, 94, 1, 24, 85, 13, 92, 81, 91, 94, 80}, "d87d25207e4932"));
                    }
                    break;
                }
                return;
            default:
                this.zza.zza(C0000.decode(new byte[]{96, 7, 67, 20, 91, 1, 81, 25, 92, 12, 68, 0, 86, 11, 93, 7, 82, 22, 87, 6}, "3b1b2b498e7c9e", 0.0f));
                return;
        }
        while (true) {
            zzn zznVar2 = this.zza;
            synchronized (zznVar2) {
                try {
                    if (zznVar2.zza != 2) {
                        return;
                    }
                    if (zznVar2.zzd.isEmpty()) {
                        zznVar2.zzf();
                        return;
                    }
                    zzq zzqVar = (zzq) zznVar2.zzd.poll();
                    zznVar2.zze.put(zzqVar.zza, zzqVar);
                    zznVar2.zzf.zzc.schedule(new Worker.AnonymousClass2(zznVar2, zzqVar, 7, false), 30L, TimeUnit.SECONDS);
                    if (Log.isLoggable(C0000.decode(new byte[]{47, 6, 18, 75, 6, 93, 5, 6, 19, 113, 19, 80, 33, 15, 8, 93, 13, 71}, "bca8c3"), 3)) {
                        C0000.decode(new byte[]{96, 93, 8, 81, 88, 92, 2, 20}, "38f512e4465d5e", true).concat(String.valueOf(zzqVar));
                    }
                    zzu zzuVar = zznVar2.zzf;
                    Messenger messenger = zznVar2.zzb;
                    int i = zzqVar.zzc;
                    Context context = zzuVar.zzb;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = i;
                    messageObtain.arg1 = zzqVar.zza;
                    messageObtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(C0000.decode(new byte[]{94, 95, 80, 52, 89, 64}, "115c891ca94a2c90", false), zzqVar.zzb());
                    bundle.putString(C0000.decode(new byte[]{68, 94, 2}, "45e74db75cd8", 6), context.getPackageName());
                    bundle.putBundle(C0000.decode(new byte[]{84, 3, 67, 87}, "0b76adab", false), zzqVar.zzd);
                    messageObtain.setData(bundle);
                    try {
                        OperationImpl operationImpl = zznVar2.zzc;
                        Messenger messenger2 = (Messenger) operationImpl.mOperationState;
                        if (messenger2 != null) {
                            messenger2.send(messageObtain);
                        } else {
                            zze zzeVar = (zze) operationImpl.mOperationFuture;
                            if (zzeVar == null) {
                                throw new IllegalStateException(C0000.decode(new byte[]{35, 91, 64, 80, 25, 93, 84, 68, 18, 7, 15, 83, 81, 74, 74, 16, 80, 69, 4, 66, 15, 65, 88, 84}, "a4489017ab", 2));
                            }
                            Messenger messenger3 = zzeVar.zza;
                            messenger3.getClass();
                            messenger3.send(messageObtain);
                        }
                    } catch (RemoteException e) {
                        zznVar2.zza(e.getMessage());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
