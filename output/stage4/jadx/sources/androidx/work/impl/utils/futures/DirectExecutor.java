package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;
import p000.C0000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DirectExecutor implements Executor {
    public static final /* synthetic */ DirectExecutor[] $VALUES;
    public static final DirectExecutor INSTANCE;

    static {
        DirectExecutor directExecutor = new DirectExecutor(C0000.decode(new byte[]{125, 120, 96, 55, 118, 118, 34, 125}, "463c78a8432a9317", true), 0);
        INSTANCE = directExecutor;
        $VALUES = new DirectExecutor[]{directExecutor};
    }

    public static DirectExecutor valueOf(String str) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, str);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return C0000.decode(new byte[]{112, 92, 74, 6, 7, 64, 113, 76, 93, 81, 22, 21, 91, 71}, "458cd44482ca", 0.0f);
    }
}
