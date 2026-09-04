package androidx.core.view;

import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat$Api19Impl;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DisplayCutoutCompat {
    public final DisplayCutout mDisplayCutout;

    public DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.mDisplayCutout = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.mDisplayCutout, ((DisplayCutoutCompat) obj).mDisplayCutout);
    }

    public final int hashCode() {
        return this.mDisplayCutout.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{116, 88, 23, 19, 93, 86, 29, 38, 70, 18, 86, 16, 23, 119, 88, 92, 64, 80, 16, 24}, "01dc17de3f9ec471", 0.0f));
        sb.append(this.mDisplayCutout);
        sb.append(C0000.decode(new byte[]{79}, "2dc2f30780", 3));
        return sb.toString();
    }
}
