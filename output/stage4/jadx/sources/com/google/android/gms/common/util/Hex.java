package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.common.internal.zzag;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Hex {
    public static String zza;

    /* JADX INFO: renamed from: zza, reason: collision with other field name */
    public static final char[] f1zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static int zzb;
    public static Boolean zzd;
    public static Boolean zze;
    public static Boolean zzg;
    public static Boolean zzi;

    public static String getMyProcessName() throws Throwable {
        BufferedReader bufferedReader;
        String strDecode = C0000.decode(new byte[]{26, 72, 71, 90, 1, 73}, "5855bf073643", 0.0f);
        if (zza == null) {
            int iMyPid = zzb;
            if (iMyPid == 0) {
                iMyPid = Process.myPid();
                zzb = iMyPid;
            }
            String strTrim = null;
            strTrim = null;
            strTrim = null;
            BufferedReader bufferedReader2 = null;
            if (iMyPid > 0) {
                try {
                    String str = strDecode + iMyPid + C0000.decode(new byte[]{24, 7, 8, 7, 13, 92, 89, 84}, "7deca57168f1964a");
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        bufferedReader = new BufferedReader(new FileReader(str));
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        try {
                            String line = bufferedReader.readLine();
                            zzag.checkNotNull(line);
                            strTrim = line.trim();
                        } catch (IOException unused) {
                            if (bufferedReader != null) {
                            }
                            zza = strTrim;
                            return zza;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th2;
                    }
                } catch (IOException unused3) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
            }
            zza = strTrim;
        }
        return zza;
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (zzd == null) {
            zzd = Boolean.valueOf(packageManager.hasSystemFeature(C0000.decode(new byte[]{0, 95, 7, 65, 9, 94, 0, 79, 12, 3, 19, 86, 22, 80, 17, 86, 72, 67, 29, 17, 1, 76, 22, 83, 21, 82, 11}, "a1c3f7dadba2", true)));
        }
        zzd.booleanValue();
        if (zze == null) {
            zze = Boolean.valueOf(context.getPackageManager().hasSystemFeature(C0000.decode(new byte[]{83, 88, 76, 83, 95, 93, 87, 90, 7}, "06b402")));
        }
        return zze.booleanValue() && Build.VERSION.SDK_INT >= 30;
    }
}
