package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.Priority;
import java.util.HashMap;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class PriorityMapping {
    public static final HashMap PRIORITY_INT_MAP;
    public static final SparseArray PRIORITY_MAP = new SparseArray();

    static {
        HashMap map = new HashMap();
        PRIORITY_INT_MAP = map;
        map.put(Priority.DEFAULT, 0);
        map.put(Priority.VERY_LOW, 1);
        map.put(Priority.HIGHEST, 2);
        for (Priority priority : map.keySet()) {
            PRIORITY_MAP.append(((Integer) PRIORITY_INT_MAP.get(priority)).intValue(), priority);
        }
    }

    public static int toInt(Priority priority) {
        Integer num = (Integer) PRIORITY_INT_MAP.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException(C0000.decode(new byte[]{98, 22, 11, 94, 65, 11, 22, 73, 126, 83, 64, 22, 92, 92, 80, 19, 91, 23, 66, 92, 90, 17, 17, 89, 93, 85, 16, 13, 91, 93, 64, 93, 18, 52, 16, 88, 92, 16, 11, 68, 74, 18, 70, 7, 89, 71, 82, 19}, "2db13bb0320f5273", false) + priority);
    }

    public static Priority valueOf(int i) {
        Priority priority = (Priority) PRIORITY_MAP.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{101, 87, 13, 86, 94, 19, 89, 22, 51, 66, 15, 10, 68, 8, 68, 64, 70, 94, 94, 22, 23, 64, 2, 92, 19, 0, 22}, "09f81d76c0fe6a"), i));
    }
}
