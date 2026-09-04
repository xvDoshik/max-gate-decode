package androidx.work.impl.utils;

import java.util.WeakHashMap;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WakeLocksHolder {
    public static final WakeLocksHolder INSTANCE = new WakeLocksHolder();
    public static final WeakHashMap wakeLocks = new WeakHashMap();
}
