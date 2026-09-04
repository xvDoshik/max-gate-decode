package androidx.activity;

import android.window.BackEvent;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BackEventCompat {
    public final float progress;
    public final int swipeEdge;
    public final float touchX;
    public final float touchY;

    public BackEventCompat(BackEvent backEvent) {
        Api34Impl api34Impl = Api34Impl.INSTANCE;
        float f = api34Impl.touchX(backEvent);
        float f2 = api34Impl.touchY(backEvent);
        float fProgress = api34Impl.progress(backEvent);
        int iSwipeEdge = api34Impl.swipeEdge(backEvent);
        this.touchX = f;
        this.touchY = f2;
        this.progress = fProgress;
        this.swipeEdge = iSwipeEdge;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{36, 88, 0, 92, 38, 20, 86, 93, 16, 117, 91, 95, 66, 80, 18, 66, 23, 88, 22, 1, 91, 107, 89}, "f9c7cb33d64221"));
        sb.append(this.touchX);
        sb.append(C0000.decode(new byte[]{74, 17, 71, 11, 23, 81, 81, 110, 92}, "f13db297a6195b"));
        sb.append(this.touchY);
        sb.append(C0000.decode(new byte[]{78, 66, 17, 17, 10, 3, 23, 84, 65, 70, 4}, "bbacede12598b950", 0.0f));
        sb.append(this.progress);
        sb.append(C0000.decode(new byte[]{30, 19, 17, 21, 88, 70, 6, 125, 92, 84, 83, 88}, "23bb16c8836e"));
        sb.append(this.swipeEdge);
        sb.append('}');
        return sb.toString();
    }
}
