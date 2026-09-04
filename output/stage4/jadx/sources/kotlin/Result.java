package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Result implements Serializable {

    public final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            this.exception = th;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Failure) {
                return Intrinsics.areEqual(this.exception, ((Failure) obj).exception);
            }
            return false;
        }

        public final int hashCode() {
            return this.exception.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{114, 83, 10, 88, 23, 65, 6, 31}, "42c4b3c7cc538c", 7));
            sb.append(this.exception);
            sb.append(')');
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m12exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }
}
