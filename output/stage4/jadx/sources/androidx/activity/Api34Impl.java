package androidx.activity;

import android.window.BackEvent;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Api34Impl {
    public static final Api34Impl INSTANCE = new Api34Impl();

    public final BackEvent createOnBackEvent(float f, float f2, float f3, int i) {
        return new BackEvent(f, f2, f3, i);
    }

    public final float progress(BackEvent backEvent) {
        return backEvent.getProgress();
    }

    public final int swipeEdge(BackEvent backEvent) {
        return backEvent.getSwipeEdge();
    }

    public final float touchX(BackEvent backEvent) {
        return backEvent.getTouchX();
    }

    public final float touchY(BackEvent backEvent) {
        return backEvent.getTouchY();
    }
}
