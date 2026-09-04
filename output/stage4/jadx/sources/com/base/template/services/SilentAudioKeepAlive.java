package com.base.template.services;

import android.media.AudioTrack;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SilentAudioKeepAlive {
    public volatile boolean running;
    public Thread thread;
    public volatile AudioTrack track;

    public final void start() {
        if (this.running) {
            return;
        }
        this.running = true;
        Thread thread = new Thread(new CoroutineWorker$$ExternalSyntheticLambda0(8, this), C0000.decode(new byte[]{99, 95, 8, 80, 12, 71, 114, 17, 84, 95, 11}, "06d5b33d", 0.0f));
        this.thread = thread;
        thread.setPriority(1);
        Thread thread2 = this.thread;
        if (thread2 != null) {
            thread2.start();
        }
    }
}
