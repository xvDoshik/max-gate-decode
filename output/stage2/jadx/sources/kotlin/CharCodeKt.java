package kotlin;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\"\u001f\u0010\u0002\u001a\u00020\u0003*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Char", "", "code", "", "getCode$annotations", "(C)V", "getCode", "(C)I", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CharCodeKt {
    private static final char Char(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{120, 13, 18, 4, 89, 95, 92, 69, 39, 91, 80, 17, 68, 6, 90, 82, 93, 95, 68}, "1cde568ed3", 0.0f) + i);
        }
        return (char) i;
    }

    private static final int getCode(char c) {
        return c;
    }

    public static /* synthetic */ void getCode$annotations(char c) {
    }
}
