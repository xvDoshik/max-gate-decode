package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzr;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class zzk implements Handler.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;

    public /* synthetic */ zzk(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.$r8$classId) {
            case 0:
                int i = message.arg1;
                zzn zznVar = (zzn) this.zza;
                synchronized (zznVar) {
                    try {
                        zzq zzqVar = (zzq) zznVar.zze.get(i);
                        if (zzqVar == null) {
                            return true;
                        }
                        zznVar.zze.remove(i);
                        zznVar.zzf();
                        Bundle data = message.getData();
                        if (data.getBoolean(C0000.decode(new byte[]{66, 91, 66, 17, 21, 66, 93, 23, 65, 3, 84}, "751de22e5f07", 0.0f), false)) {
                            zzqVar.zzc(new zzs(C0000.decode(new byte[]{45, 10, 16, 70, 21, 66, 21, 64, 12, 23, 16, 3, 2, 23, 7, 73, 67, 34, 9, 21, 37, 88, 23, 85}, "cedff7e0", 7), null));
                            return true;
                        }
                        switch (zzqVar.$r8$classId) {
                            case 0:
                                if (!data.getBoolean(C0000.decode(new byte[]{5, 82, 15}, "d1d42a17670af0"), false)) {
                                    zzqVar.zzc(new zzs(C0000.decode(new byte[]{40, 90, 18, 7, 90, 80, 2, 66, 22, 6, 65, 17, 86, 94, 18, 81, 68, 18, 89, 25, 9, 12, 1, 67, 69, 0, 64, 16, 19, 81, 21, 19, 83, 74, 18}, "a4df69fbdc2a90", true), null));
                                    return true;
                                }
                                if (Log.isLoggable(C0000.decode(new byte[]{127, 0, 67, 70, 83, 86, 84, 85, 71, 113, 68, 5, 38, 10, 81, 6, 92, 17}, "2e056830584fef8c", 6), 3)) {
                                    zzqVar.toString();
                                }
                                zzqVar.zzb.setResult(null);
                                return true;
                            default:
                                Bundle bundle = data.getBundle(C0000.decode(new byte[]{5, 81, 65, 86}, "a0574e21", 3));
                                if (bundle == null) {
                                    bundle = Bundle.EMPTY;
                                }
                                if (Log.isLoggable(C0000.decode(new byte[]{126, 4, 66, 21, 86, 94, 84, 84, 65, 40, 65, 5, 112, 92, 90, 84, 93, 21}, "3a1f3031", 0.0f), 3)) {
                                    zzqVar.toString();
                                    String.valueOf(bundle);
                                }
                                zzqVar.zzb.setResult(bundle);
                                return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            default:
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 != 1) {
                        return false;
                    }
                    synchronized (((zzr) this.zza).zzb) {
                        try {
                            com.google.android.gms.common.internal.zzn zznVar2 = (com.google.android.gms.common.internal.zzn) message.obj;
                            zzo zzoVar = (zzo) ((zzr) this.zza).zzb.get(zznVar2);
                            if (zzoVar != null && zzoVar.zzc == 3) {
                                String.valueOf(zznVar2);
                                new Exception();
                                ComponentName componentName = zzoVar.zzg;
                                if (componentName == null) {
                                    zznVar2.getClass();
                                    componentName = null;
                                }
                                if (componentName == null) {
                                    String str = zznVar2.zzc;
                                    zzag.checkNotNull(str);
                                    componentName = new ComponentName(str, C0000.decode(new byte[]{22, 10, 13, 94, 92, 65, 15}, "cdf036ad", 0.0f));
                                }
                                zzoVar.onServiceDisconnected(componentName);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                } else {
                    synchronized (((zzr) this.zza).zzb) {
                        try {
                            com.google.android.gms.common.internal.zzn zznVar3 = (com.google.android.gms.common.internal.zzn) message.obj;
                            zzo zzoVar2 = (zzo) ((zzr) this.zza).zzb.get(zznVar3);
                            if (zzoVar2 != null && zzoVar2.zzb.isEmpty()) {
                                if (zzoVar2.zzd) {
                                    zzoVar2.zza.zzd.removeMessages(1, zzoVar2.zzf);
                                    zzr zzrVar = zzoVar2.zza;
                                    zzrVar.zzf.unbindService(zzrVar.zzc, zzoVar2);
                                    zzoVar2.zzd = false;
                                    zzoVar2.zzc = 2;
                                }
                                ((zzr) this.zza).zzb.remove(zznVar3);
                            }
                        } catch (Throwable th3) {
                            throw th3;
                        }
                        break;
                    }
                }
                return true;
        }
    }
}
