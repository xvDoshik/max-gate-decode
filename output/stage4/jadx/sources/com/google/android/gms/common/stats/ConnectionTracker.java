package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConnectionTracker {
    public static final Object zzb = new Object();
    public static volatile ConnectionTracker zzc;
    public ConcurrentHashMap zza;

    public static ConnectionTracker getInstance() {
        if (zzc == null) {
            synchronized (zzb) {
                try {
                    if (zzc == null) {
                        ConnectionTracker connectionTracker = new ConnectionTracker();
                        connectionTracker.zza = new ConcurrentHashMap();
                        zzc = connectionTracker;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ConnectionTracker connectionTracker2 = zzc;
        zzag.checkNotNull(connectionTracker2);
        return connectionTracker2;
    }

    public final void unbindService(Context context, ServiceConnection serviceConnection) {
        ConcurrentHashMap concurrentHashMap = this.zza;
        if ((serviceConnection instanceof zzo) || !concurrentHashMap.containsKey(serviceConnection)) {
            try {
                context.unbindService(serviceConnection);
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
            }
        } else {
            try {
                try {
                    context.unbindService((ServiceConnection) concurrentHashMap.get(serviceConnection));
                } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
                }
            } finally {
                concurrentHashMap.remove(serviceConnection);
            }
        }
    }

    public final boolean zzc(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ConcurrentHashMap concurrentHashMap = this.zza;
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            C0000.decode(new byte[]{91, 89, 9, 76, 4, 89, 91, 86, 90, 85, 22, 84, 86, 82, 22, 13, 10, 82, 26, 86, 91, 67}, "86dbc6416085", true).equals(packageName);
            try {
                if ((Wrappers.packageManager(context).zza.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (serviceConnection instanceof zzo) {
            return context.bindService(intent, serviceConnection, i);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) concurrentHashMap.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            String.format(C0000.decode(new byte[]{39, 17, 22, 90, 12, 80, 89, 71, 85, 22, 91, 88, 90, 92, 94, 10, 4, 68, 17, 95, 17, 91, 24, 71, 88, 83, 25, 66, 85, 85, 82, 68, 48, 1, 20, 64, 12, 80, 93, 112, 95, 88, 87, 84, 87, 76, 94, 11, 13, 94, 70, 19, 22, 31, 24, 22, 67, 26, 25, 20, 71, 22}, "cdf6e3830691487d", 0.0f), serviceConnection, str, intent.getAction());
        }
        try {
            boolean zBindService = context.bindService(intent, serviceConnection, i);
            if (zBindService) {
                return zBindService;
            }
            concurrentHashMap.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th) {
            concurrentHashMap.remove(serviceConnection, serviceConnection);
            throw th;
        }
    }
}
