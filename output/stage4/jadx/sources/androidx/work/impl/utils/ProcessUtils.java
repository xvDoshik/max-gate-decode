package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.work.SystemClock;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ProcessUtils {
    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{100, 66, 89, 7, 87, 18, 67, 102, 64, 89, 90, 23}, "406d2a03", 6));
    }

    public static final boolean isDefaultProcess(Context context) {
        String processName;
        Object next;
        if (Build.VERSION.SDK_INT >= 28) {
            processName = Api28Impl.INSTANCE.getProcessName();
        } else {
            processName = null;
            try {
                Method declaredMethod = Class.forName(C0000.decode(new byte[]{80, 11, 81, 64, 14, 94, 6, 25, 88, 17, 65, 75, 116, 81, 21, 94, 20, 94, 77, 24, 101, 13, 71, 87, 0, 83}, "1e52a7b79a", 2), false, CloseableKt.class.getClassLoader()).getDeclaredMethod(C0000.decode(new byte[]{7, 77, 68, 68, 82, 11, 17, 54, 16, 87, 85, 7, 68, 16, 42, 88, 9, 93}, "d8667eefb86b7cd9"), null);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, null);
                if (objInvoke instanceof String) {
                    processName = (String) objInvoke;
                } else {
                    int iMyPid = Process.myPid();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(C0000.decode(new byte[]{7, 86, 67, 12, 79, 12, 23, 24}, "f57e9eca"))).getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        Iterator<T> it = runningAppProcesses.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (((ActivityManager.RunningAppProcessInfo) next).pid != iMyPid);
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                        if (runningAppProcessInfo != null) {
                            processName = runningAppProcessInfo.processName;
                        }
                    }
                }
            } catch (Throwable unused) {
                SystemClock.get().getClass();
            }
        }
        return Intrinsics.areEqual(processName, context.getApplicationInfo().processName);
    }
}
