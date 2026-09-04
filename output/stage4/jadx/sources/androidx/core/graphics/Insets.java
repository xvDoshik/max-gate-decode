package androidx.core.graphics;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Insets {
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    public abstract class Api29Impl {
        public static android.graphics.Insets of(int i, int i2, int i3, int i4) {
            return android.graphics.Insets.of(i, i2, i3, i4);
        }
    }

    public Insets(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    public static Insets of(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? NONE : new Insets(i, i2, i3, i4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.top == insets.top;
    }

    public final int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final android.graphics.Insets toPlatformInsets() {
        return Api29Impl.of(this.left, this.top, this.right, this.bottom);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{112, 8, 64, 7, 70, 18, 67, 84, 85, 83, 77, 91}, "9f3b2a8805", false));
        sb.append(this.left);
        sb.append(C0000.decode(new byte[]{78, 65, 23, 88, 65, 13}, "bac710440a", 7));
        sb.append(this.top);
        sb.append(C0000.decode(new byte[]{78, 19, 75, 12, 86, 9, 22, 14}, "b39e1a", 0.0f));
        sb.append(this.right);
        sb.append(C0000.decode(new byte[]{21, 69, 86, 90, 18, 64, 88, 9, 4}, "9e45f47d", 0.0f));
        sb.append(this.bottom);
        sb.append('}');
        return sb.toString();
    }
}
