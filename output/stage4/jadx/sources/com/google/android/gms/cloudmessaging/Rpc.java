package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.work.Worker;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Huffman;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Rpc {
    public static int zza;
    public static PendingIntent zzb;
    public static final Pattern zzd = Pattern.compile(C0000.decode(new byte[]{56, 75, 112, 32, 62, 73, 29, 58, 108, 26, 60, 27, 77, 107, 69, 94, 93, 30, 29, 79, 24, 79}, "d79db55a2fa0", true));
    public final Context zzf;
    public final Huffman.Node zzg;
    public final ScheduledThreadPoolExecutor zzh;
    public Messenger zzj;
    public zze zzk;
    public final SimpleArrayMap zze = new SimpleArrayMap();
    public final Messenger zzi = new Messenger(new zzad(this, Looper.getMainLooper()));

    public Rpc(Context context) {
        this.zzf = context;
        this.zzg = new Huffman.Node(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzh = scheduledThreadPoolExecutor;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0161  */
    /* JADX WARN: Code duplicated, block: B:39:0x0167  */
    public final zzw zze(Bundle bundle) {
        String string;
        synchronized (Rpc.class) {
            int i = zza;
            zza = i + 1;
            string = Integer.toString(i);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.zze) {
            this.zze.put(string, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage(C0000.decode(new byte[]{81, 94, 11, 75, 84, 12, 11, 3, 91, 7, 28, 80, 8, 1, 65, 12, 13, 0, 25, 5, 95, 66}, "21fe3cdd7b"));
        if (this.zzg.zzb() == 2) {
            intent.setAction(C0000.decode(new byte[]{91, 91, 92, 76, 84, 9, 87, 83, 93, 7, 29, 15, 81, 80, 31, 54, 124, 45, 125, 122, 110, 48, 118, 55, 109, 113, 98, 54}, "841b3f"));
        } else {
            intent.setAction(C0000.decode(new byte[]{87, 14, 89, 31, 84, 10, 91, 6, 88, 84, 29, 4, 90, 5, 70, 94, 90, 1, 26, 2, 6, 85, 94, 75, 93, 15, 64, 84, 93, 17, 26, 51, 113, 118, 122, 54, 96, 36, 102}, "4a413e", false));
        }
        intent.putExtras(bundle);
        Context context = this.zzf;
        synchronized (Rpc.class) {
            try {
                if (zzb == null) {
                    Intent intent2 = new Intent();
                    intent2.setPackage(C0000.decode(new byte[]{1, 11, 94, 29, 83, 12, 9, 85, 94, 92, 76, 87, 73, 0, 11, 64, 14, 1, 29, 90, 90, 21, 7, 94, 91, 93, 18, 83, 82, 10, 7, 87, 7}, "bd334cf229b21af0", true));
                    zzb = PendingIntent.getBroadcast(context, 0, intent2, zza.zza);
                }
                intent.putExtra(C0000.decode(new byte[]{86, 70, 21}, "76e54165b82e", true), zzb);
            } catch (Throwable th) {
                throw th;
            }
        }
        intent.putExtra(C0000.decode(new byte[]{82, 11, 5}, "9ba3cbe55b021618", 5), C0000.decode(new byte[]{68, 123, 117, 72}, "82147799d26953", 5) + string + C0000.decode(new byte[]{79}, "30269e6e444749", 0.0f));
        if (Log.isLoggable(C0000.decode(new byte[]{49, 73, 90}, "c99eb7788d96562c"), 3)) {
            C0000.decode(new byte[]{102, 82, 87, 5, 95, 15, 3, 21}, "579a6ad532e2").concat(String.valueOf(intent.getExtras()));
        }
        intent.putExtra(C0000.decode(new byte[]{84, 86, 94, 86, 13, 85, 75, 9, 86, 74, 66, 84, 15, 87, 0, 22}, "3911a0ed", 1), this.zzi);
        if (this.zzj != null || this.zzk != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.zzj;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    Messenger messenger2 = this.zzk.zza;
                    messenger2.getClass();
                    messenger2.send(messageObtain);
                }
            } catch (RemoteException unused) {
                if (this.zzg.zzb() == 2) {
                    this.zzf.sendBroadcast(intent);
                } else {
                    this.zzf.startService(intent);
                }
            }
        } else if (this.zzg.zzb() == 2) {
            this.zzf.sendBroadcast(intent);
        } else {
            this.zzf.startService(intent);
        }
        taskCompletionSource.zza.addOnCompleteListener(zzy.zza, new zzac(this, string, this.zzh.schedule(new Worker.AnonymousClass1(8, taskCompletionSource), 30L, TimeUnit.SECONDS), 0));
        return taskCompletionSource.zza;
    }

    public final void zzh(String str, Bundle bundle) {
        synchronized (this.zze) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zze.remove(str);
                if (taskCompletionSource == null) {
                    return;
                }
                taskCompletionSource.setResult(bundle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
