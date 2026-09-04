package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b¨\u0006\u0004"}, d2 = {"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CharsetsKt {
    private static final Charset charset(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{91, 93, 0, 16, 68, 83, 65, 121, 86, 89, 0}, "85ab765774e0", 3));
        Charset charsetForName = Charset.forName(str);
        Intrinsics.checkNotNullExpressionValue(charsetForName, C0000.decode(new byte[]{2, 10, 71, 124, 5, 94, 1, 31, 74, 75, 27, 27}, "de52d3d7"));
        return charsetForName;
    }
}
