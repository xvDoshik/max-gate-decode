package kotlinx.coroutines.channels;

import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ChannelResult {
    public static final Failed failed = new Failed();
    public final Object holder;

    public final class Closed extends Failed {
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Closed) {
                return Intrinsics.areEqual(this.cause, ((Closed) obj).cause);
            }
            return false;
        }

        public final int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{33, 9, 91, 69, 82, 80, 17}, "be467496815936c2", 4));
            sb.append(this.cause);
            sb.append(')');
            return sb.toString();
        }
    }

    public class Failed {
        public String toString() {
            return C0000.decode(new byte[]{114, 85, 92, 91, 83, 0}, "44576d", 0.0f);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ChannelResult) {
            return Intrinsics.areEqual(this.holder, ((ChannelResult) obj).holder);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.holder;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.holder;
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return C0000.decode(new byte[]{111, 2, 9, 19, 80, 26}, "9cef52cc0d") + obj + ')';
    }
}
