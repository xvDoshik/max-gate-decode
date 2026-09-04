package okhttp3.internal.http2;

import java.io.IOException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StreamResetException extends IOException {
    public final int errorCode;

    /* JADX WARN: Illegal instructions before constructor call */
    public StreamResetException(int i) {
        String strDecode;
        switch (i) {
            case 1:
                strDecode = C0000.decode(new byte[]{120, 120, 102, 38, 102, 48, 124, 101}, "679c4b3756eff157", true);
                break;
            case 2:
                strDecode = C0000.decode(new byte[]{102, 107, 121, 103, 43, 37, 121, 117, 105, 118, 54, 52, 121, 107}, "6963df", 1);
                break;
            case 3:
                strDecode = C0000.decode(new byte[]{122, 120, 97, 125, 107, 118, 39, 47, 110, 39, 99, 107, 124, 100}, "365898fc1b19");
                break;
            case 4:
                strDecode = C0000.decode(new byte[]{116, 45, 46, 98, 62, 118, 124, 44, 103, 106, 41, 122, 58, 35, 107, 107, 125, 51}, "2aa5a53b38f6ef99");
                break;
            case 5:
                strDecode = C0000.decode(new byte[]{102, 39, 53, 49, 124, 47, 34, 48, 104, 50, 121, 43, 38, 44, 96, 54}, "5bae5aec7f0fcc", true);
                break;
            case 6:
                strDecode = C0000.decode(new byte[]{103, 49, 102, 32, 35, 43, 107, 38, 120, 42, 49, 35, 112}, "4e4ebf", 3);
                break;
            case 7:
                strDecode = C0000.decode(new byte[]{126, 107, 36, 40, 114, 103, 100, 122, 63, 33, 62, 125, 107, 100, 119, 107}, "89ee7873eda896");
                break;
            case 8:
                strDecode = C0000.decode(new byte[]{97, 117, 36, 101, 49, 114, 37, 105, 99, 97, 55, 39, 114, 125}, "30b0b7a605eb", 0.0f);
                break;
            case 9:
                strDecode = C0000.decode(new byte[]{37, 35, 118, 37, 117, 45}, "fb8f0a");
                break;
            case 10:
                strDecode = C0000.decode(new byte[]{114, 119, 44, 103, 49, 33, 99, 102, 122, 46, 120, 107, 114, 99, 99, 119, 51}, "18a7cd053a6471", true);
                break;
            case 11:
                strDecode = C0000.decode(new byte[]{117, 124, 121, 43, 36, 116, 99, 106, 114, 96, 49, 42, 100}, "637ea77572ce", 4);
                break;
            case 12:
                strDecode = C0000.decode(new byte[]{124, 43, 46, 36, 122, 118, 125, 108, 108, 44, 108, 55, 57, 38, 117, 121, 117}, "9efe45835c");
                break;
            case 13:
                strDecode = C0000.decode(new byte[]{40, 42, 118, 116, 114, 51, 52, 116, 48, 112, 61, 96, 119, 113, 49, 107, 40, 48, 110}, "ad707ba5d5b322d9", false);
                break;
            case 14:
                strDecode = C0000.decode(new byte[]{43, 100, 102, 99, 60, 8, 59, 5, 57, 106, 38, 97, 103, 122, 49, 124, 32}, "c023c9d4f8", 5);
                break;
            default:
                strDecode = C0000.decode(new byte[]{86, 77, 94, 84}, "88288d8e16", false);
                break;
        }
        super(C0000.decode(new byte[]{17, 68, 67, 84, 3, 11, 20, 68, 2, 18, 25, 67, 93, 69, 7, 68, 11, 17}, "b011bf43ca9186", false).concat(strDecode));
        this.errorCode = i;
    }
}
