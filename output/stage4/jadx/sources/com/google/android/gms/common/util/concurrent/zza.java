package com.google.android.gms.common.util.concurrent;

import android.os.Process;
import androidx.tracing.Trace;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zza implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final Runnable zza;

    public /* synthetic */ zza(Runnable runnable, int i) {
        this.$r8$classId = i;
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                Process.setThreadPriority(0);
                this.zza.run();
                break;
            case 1:
                try {
                    this.zza.run();
                } catch (Exception unused) {
                    Trace.getTag(C0000.decode(new byte[]{124, 78, 92, 2, 65, 17, 89, 16}, "969a4e6b6b015a32"));
                    return;
                }
                break;
            default:
                this.zza.run();
                break;
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                return this.zza.toString();
            default:
                return super.toString();
        }
    }
}
