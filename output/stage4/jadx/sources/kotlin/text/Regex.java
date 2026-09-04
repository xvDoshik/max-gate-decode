package kotlin.text;

import java.io.Serializable;
import java.util.regex.Pattern;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Regex implements Serializable {
    public final /* synthetic */ int $r8$classId;
    public Object nativePattern;

    public Regex(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                break;
            default:
                this.nativePattern = Pattern.compile(C0000.decode(new byte[]{30, 58, 85, 72, 9, 83, 78, 86, 116, 25, 114, 100, 28, 91, 62, 85, 29, 11, 2, 29, 83, 117, 25, 127, 12, 79, 56, 79, 25, 78, 75, 107, 105, 80, 26, 100, 29, 72}, "6aee02c05449", 4));
                break;
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return ((Pattern) this.nativePattern).toString();
            default:
                return String.valueOf(this.nativePattern);
        }
    }
}
