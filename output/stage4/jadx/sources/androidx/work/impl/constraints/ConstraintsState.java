package androidx.work.impl.constraints;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ConstraintsState {

    public final class ConstraintsMet extends ConstraintsState {
        public static final ConstraintsMet INSTANCE = new ConstraintsMet();
    }

    public final class ConstraintsNotMet extends ConstraintsState {
        public final int reason;

        public ConstraintsNotMet(int i) {
            this.reason = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.reason == ((ConstraintsNotMet) obj).reason;
        }

        public final int hashCode() {
            return Integer.hashCode(this.reason);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{37, 14, 13, 67, 64, 66, 85, 91, 93, 68, 69, 125, 93, 64, 43, 4, 23, 24, 70, 85, 85, 65, 92, 94, 11}, "fac04042306324", 0.0f));
            sb.append(this.reason);
            sb.append(')');
            return sb.toString();
        }
    }
}
