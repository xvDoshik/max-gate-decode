package com.google.android.gms.stats;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import android.text.TextUtils;
import androidx.startup.StartupException;
import androidx.work.Worker;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.stats.zzb;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WakeLock {
    public static final long zzb = TimeUnit.DAYS.toMillis(366);
    public static volatile ScheduledExecutorService zzc = null;
    public static final Object zzd = new Object();
    public zzb zza;
    public final Object zzf;
    public final PowerManager.WakeLock zzg;
    public int zzh;
    public ScheduledFuture zzi;
    public long zzj;
    public final HashSet zzk;
    public boolean zzl;
    public final DefaultClock zzn;
    public final String zzp;
    public final HashMap zzs;
    public final AtomicInteger zzt;
    public final ScheduledExecutorService zzu;

    public WakeLock(Context context) {
        String strDecode = C0000.decode(new byte[]{22, 2, 10, 85, 2, 7, 86, 92, 23, 5, 94, 11, 2, 14, 4, 77, 7, 89, 74, 1, 91, 80, 74, 7, 31, 13, 12, 6, 79, 52, 0, 91, 93, 40, 86, 82, 82, 42, 94, 8, 1, 7, 19}, "aca08d919b1deb");
        String packageName = context.getPackageName();
        this.zzf = new Object();
        this.zzh = 0;
        this.zzk = new HashSet();
        this.zzl = true;
        this.zzn = DefaultClock.zza;
        this.zzs = new HashMap();
        this.zzt = new AtomicInteger(0);
        zzag.checkNotEmpty(strDecode, C0000.decode(new byte[]{52, 89, 10, 6, 126, 13, 87, 13, 89, 24, 22, 2, 89, 7, 120, 9, 0, 83, 47, 2, 95, 7, 20, 11, 22, 75, 21, 67, 92, 13, 64, 70, 1, 93, 65, 6, 95, 18, 64, 31}, "c8ac2b4f", 0.0f));
        context.getApplicationContext();
        WorkSource workSource = null;
        this.zza = null;
        if (C0000.decode(new byte[]{85, 94, 88, 72, 4, 10, 89, 86, 89, 3, 77, 4, 88, 85, 71, 9, 10, 1, 24, 86, 88, 21}, "615fce").equals(context.getPackageName())) {
            this.zzp = strDecode;
        } else {
            String strDecode2 = C0000.decode(new byte[]{27, 84, 84, 9, 19, 7, 76, 2}, "137fabf8f5", 0.0f);
            this.zzp = strDecode.length() != 0 ? strDecode2.concat(strDecode) : new String(strDecode2);
        }
        PowerManager powerManager = (PowerManager) context.getSystemService(C0000.decode(new byte[]{21, 11, 64, 4, 17}, "ed7ac177f8bc96", false));
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) C0000.decode(new byte[]{84, 74, 72, 82, 83, 77, 82, 0, 67, 81, 65, 91, 12, 89, 28, 92, 77, 91, 92, 25, 69, 1, 5, 85, 19, 80, 13, 84, 84}, "1287097dc0a5c7", true), 0, 29);
            throw new StartupException(sb.toString());
        }
        this.zzg = powerManager.newWakeLock(1, strDecode);
        Method method = WorkSourceUtil.zzb;
        if (context.getPackageManager() != null) {
            if (Wrappers.packageManager(context).zza.getPackageManager().checkPermission(C0000.decode(new byte[]{82, 90, 80, 71, 11, 10, 2, 22, 64, 87, 75, 85, 90, 71, 71, 92, 11, 13, 72, 109, 96, 118, 120, 108, 118, 107, 112, 112, 50, 42, 37, 125, 111, 97, 109, 121, 103, 103}, "3445dcf80298"), context.getPackageName()) == 0) {
                int i = Strings.$r8$clinit;
                packageName = (packageName == null || packageName.trim().isEmpty()) ? context.getPackageName() : packageName;
                if (context.getPackageManager() != null && packageName != null) {
                    try {
                        ApplicationInfo applicationInfo = Wrappers.packageManager(context).zza.getPackageManager().getApplicationInfo(packageName, 0);
                        if (applicationInfo == null) {
                            C0000.decode(new byte[]{38, 87, 66, 15, 83, 69, 12, 90, 68, 23, 83, 80, 67, 65, 80, 17, 21, 84, 94, 0, 86, 17, 11, 90, 94, 126, 90, 83, 88, 65, 87, 19, 10, 85, 23, 19, 86, 6, 9, 84, 87, 82, 14, 21}, "e87c7eb507457a1a", false).concat(packageName);
                        } else {
                            int i2 = applicationInfo.uid;
                            workSource = new WorkSource();
                            Method method2 = WorkSourceUtil.zzc;
                            try {
                                if (method2 != null) {
                                    method2.invoke(workSource, Integer.valueOf(i2), packageName);
                                } else {
                                    Method method3 = WorkSourceUtil.zzb;
                                    if (method3 != null) {
                                        method3.invoke(workSource, Integer.valueOf(i2));
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        C0000.decode(new byte[]{34, 86, 65, 84, 80, 19, 95, 92, 21, 25, 82, 81, 90, 87, 17, 67, 0, 90, 95, 89, 83, 86, 11, 19}, "a9484313", false).concat(packageName);
                    }
                }
                if (workSource != null) {
                    try {
                        this.zzg.setWorkSource(workSource);
                    } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                        e.toString();
                    }
                }
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = zzc;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (zzd) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = zzc;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        zzc = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.zzu = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public final void acquire(long j) {
        this.zzt.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, zzb), 1L);
        if (j > 0) {
            jMax = Math.min(j, jMax);
        }
        synchronized (this.zzf) {
            try {
                if (!isHeld()) {
                    this.zza = zzb.zza;
                    this.zzg.acquire();
                    this.zzn.getClass();
                    SystemClock.elapsedRealtime();
                }
                this.zzh++;
                if (this.zzl) {
                    TextUtils.isEmpty(null);
                }
                zzc zzcVar = (zzc) this.zzs.get(null);
                if (zzcVar == null) {
                    zzcVar = new zzc();
                    this.zzs.put(null, zzcVar);
                }
                zzcVar.zza++;
                this.zzn.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = Long.MAX_VALUE - jElapsedRealtime > jMax ? jElapsedRealtime + jMax : Long.MAX_VALUE;
                if (j2 > this.zzj) {
                    this.zzj = j2;
                    ScheduledFuture scheduledFuture = this.zzi;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.zzi = this.zzu.schedule(new Worker.AnonymousClass1(12, this), jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isHeld() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzh > 0;
        }
        return z;
    }

    public final void release() {
        if (this.zzt.decrementAndGet() < 0) {
            String.valueOf(this.zzp).concat(C0000.decode(new byte[]{16, 16, 82, 15, 92, 81, 67, 7, 23, 20, 80, 68, 88, 13, 66, 23, 25, 81, 16, 15, 86, 23, 90, 88, 85, 6, 23, 2, 90, 65, 69, 11, 69, 6, 24}, "0b7c90", false));
        }
        synchronized (this.zzf) {
            try {
                if (this.zzl) {
                    TextUtils.isEmpty(null);
                }
                if (this.zzs.containsKey(null)) {
                    zzc zzcVar = (zzc) this.zzs.get(null);
                    if (zzcVar != null) {
                        int i = zzcVar.zza - 1;
                        zzcVar.zza = i;
                        if (i == 0) {
                            this.zzs.remove(null);
                        }
                    }
                } else {
                    String.valueOf(this.zzp).concat(C0000.decode(new byte[]{20, 81, 91, 17, 92, 71, 4, 67, 20, 93, 86, 92, 70, 23, 90, 93, 64, 68, 87, 75, 8, 66, 64}, "424d23a1499957"));
                }
                zzd();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc() {
        HashSet hashSet = this.zzk;
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        hashSet.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    public final void zzd() {
        synchronized (this.zzf) {
            try {
                if (isHeld()) {
                    if (this.zzl) {
                        int i = this.zzh - 1;
                        this.zzh = i;
                        if (i > 0) {
                            return;
                        }
                    } else {
                        this.zzh = 0;
                    }
                    zzc();
                    Iterator it = this.zzs.values().iterator();
                    while (it.hasNext()) {
                        ((zzc) it.next()).zza = 0;
                    }
                    this.zzs.clear();
                    ScheduledFuture scheduledFuture = this.zzi;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.zzi = null;
                        this.zzj = 0L;
                    }
                    if (this.zzg.isHeld()) {
                        try {
                            try {
                                this.zzg.release();
                                if (this.zza != null) {
                                    this.zza = null;
                                }
                            } catch (RuntimeException e) {
                                if (!e.getClass().equals(RuntimeException.class)) {
                                    throw e;
                                }
                                String.valueOf(this.zzp).concat(C0000.decode(new byte[]{25, 95, 86, 89, 94, 80, 93, 25, 67, 95, 18, 71, 92, 85, 82, 81, 65, 80, 24}, "997025", 0));
                                if (this.zza != null) {
                                    this.zza = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.zza != null) {
                                this.zza = null;
                            }
                            throw th;
                        }
                    } else {
                        String.valueOf(this.zzp).concat(C0000.decode(new byte[]{19, 18, 11, 93, 77, 91, 92, 16, 1, 6, 70, 80, 83, 93, 87, 64}, "3ac28780ccf861", 1));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
