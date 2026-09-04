package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import androidx.work.Worker;
import androidx.work.impl.OperationImpl;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.base.zaq;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzn implements ServiceConnection {
    public int zza = 0;
    public final Messenger zzb;
    public OperationImpl zzc;
    public final ArrayDeque zzd;
    public final SparseArray zze;
    public final /* synthetic */ zzu zzf;

    public zzn(zzu zzuVar) {
        this.zzf = zzuVar;
        zaq zaqVar = new zaq(Looper.getMainLooper(), new zzk(0, this));
        Looper.getMainLooper();
        this.zzb = new Messenger(zaqVar);
        this.zzd = new ArrayDeque();
        this.zze = new SparseArray();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzf.zzc.execute(new Worker.AnonymousClass2(this, iBinder, 6, false));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzf.zzc.execute(new zzh(this, 2));
    }

    public final synchronized void zza(String str) {
        zzb(str, null);
    }

    public final synchronized void zzb(String str, SecurityException securityException) {
        try {
            if (Log.isLoggable(C0000.decode(new byte[]{47, 84, 22, 71, 83, 95, 5, 84, 23, 125, 70, 82, 33, 93, 12, 81, 88, 69}, "b1e461", false), 3)) {
                C0000.decode(new byte[]{113, 94, 68, 7, 13, 89, 92, 86, 84, 70, 84, 6, 15, 23}, "577db723721b", 0.0f).concat(String.valueOf(str));
            }
            int i = this.zza;
            if (i == 0) {
                throw new IllegalStateException();
            }
            if (i != 1 && i != 2) {
                if (i != 3) {
                    return;
                }
                this.zza = 4;
                return;
            }
            this.zza = 4;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
            zzs zzsVar = new zzs(str, securityException);
            Iterator it = this.zzd.iterator();
            while (it.hasNext()) {
                ((zzq) it.next()).zzc(zzsVar);
            }
            this.zzd.clear();
            for (int i2 = 0; i2 < this.zze.size(); i2++) {
                ((zzq) this.zze.valueAt(i2)).zzc(zzsVar);
            }
            this.zze.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzf() {
        if (this.zza == 2 && this.zzd.isEmpty() && this.zze.size() == 0) {
            this.zza = 3;
            ConnectionTracker.getInstance().unbindService(this.zzf.zzb, this);
        }
    }

    public final synchronized boolean zzg(zzq zzqVar) throws Throwable {
        Throwable th;
        try {
            try {
                int i = this.zza;
                if (i == 0) {
                    this.zzd.add(zzqVar);
                    if (this.zza != 0) {
                        throw new IllegalStateException();
                    }
                    this.zza = 1;
                    Intent intent = new Intent(C0000.decode(new byte[]{90, 13, 92, 27, 86, 12, 90, 84, 85, 86, 23, 3, 95, 81, 67, 12, 92, 87, 23, 80, 11, 6, 92, 27, 88, 13, 65, 86, 87, 71, 23, 48, 116, 114, 120, 48, 97, 118, 107}, "9b151c5393", false));
                    intent.setPackage(C0000.decode(new byte[]{84, 10, 91, 26, 3, 86, 87, 2, 91, 0, 24, 85, 10, 93, 74, 10, 94, 1, 24, 83, 9, 74}, "7e64d98e", 2));
                    try {
                        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                        Context context = this.zzf.zzb;
                        try {
                            if (connectionTracker.zzc(context, context.getClass().getName(), intent, this, 1)) {
                                this.zzf.zzc.schedule(new zzh(this, 1), 30L, TimeUnit.SECONDS);
                            } else {
                                zza(C0000.decode(new byte[]{98, 92, 80, 3, 13, 3, 24, 66, 87, 18, 7, 10, 87, 7, 22, 71, 88, 18, 66, 4, 19, 16, 81, 85, 93}, "721aaf8682ec9c63", 0.0f));
                            }
                        } catch (SecurityException e) {
                            e = e;
                            zzb(C0000.decode(new byte[]{51, 15, 86, 84, 8, 93, 65, 76, 90, 65, 81, 94, 8, 5, 23, 66, 11, 24, 18, 93, 71, 23, 90, 84, 3}, "fa76d8a85a37", 1), e);
                        }
                    } catch (SecurityException e2) {
                        e = e2;
                    }
                    return true;
                }
                try {
                    if (i == 1) {
                        this.zzd.add(zzqVar);
                        return true;
                    }
                    if (i != 2) {
                        return false;
                    }
                    this.zzd.add(zzqVar);
                    this.zzf.zzc.execute(new zzh(this, 0));
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        throw th;
    }
}
