package kotlin.text;

import java.nio.charset.Charset;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Charsets {
    public static final Charset UTF_8 = Charset.forName(C0000.decode(new byte[]{51, 100, 114, 72, 9}, "f04e1d90", false));
    public static volatile Charset utf_32be;
    public static volatile Charset utf_32le;

    static {
        Charset.forName(C0000.decode(new byte[]{102, 98, 126, 75, 8, 1}, "368f973c"));
        Charset.forName(C0000.decode(new byte[]{109, 50, 112, 76, 7, 87, 39, 119}, "8f6a6ae2", true));
        Charset.forName(C0000.decode(new byte[]{55, 99, 112, 20, 9, 5, 45, 39}, "b76983ab584b", 6));
        Charset.forName(C0000.decode(new byte[]{99, 102, 79, 37, 98, 37, 112, 122}, "65bd1f9398888b"));
        Charset.forName(C0000.decode(new byte[]{122, 55, 43, 29, 11, 91, 84, 15, 20, 84}, "3dd03ca69e", 0));
    }
}
