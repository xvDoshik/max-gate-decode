package com.template.shellapp;

import android.content.Context;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class NativeBridge {
    static {
        System.loadLibrary(C0000.decode(new byte[]{8, 87, 68, 8, 66, 83, 92, 92, 3}, "f60a4605aaf3", 0.0f));
    }

    public static native boolean antiSandbox(Context context);

    public static native void startDaemon(Context context, String str);
}
