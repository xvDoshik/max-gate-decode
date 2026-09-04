package com.google.firebase.concurrent;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import p000.C0000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class UiExecutor implements Executor {
    public static final /* synthetic */ UiExecutor[] $VALUES;
    public static final Handler HANDLER;
    public static final UiExecutor INSTANCE;

    static {
        UiExecutor uiExecutor = new UiExecutor(C0000.decode(new byte[]{127, 126, 49, 96, 34, 122, 33, 114}, "60b4c4b78a", 0.0f), 0);
        INSTANCE = uiExecutor;
        $VALUES = new UiExecutor[]{uiExecutor};
        HANDLER = new Handler(Looper.getMainLooper());
    }

    public static UiExecutor valueOf(String str) {
        return (UiExecutor) Enum.valueOf(UiExecutor.class, str);
    }

    public static UiExecutor[] values() {
        return (UiExecutor[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        HANDLER.post(runnable);
    }
}
