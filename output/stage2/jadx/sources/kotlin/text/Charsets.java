package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/text/Charsets;", "", "<init>", "()V", "UTF_8", "Ljava/nio/charset/Charset;", "UTF_16", "UTF_16BE", "UTF_16LE", "US_ASCII", "ISO_8859_1", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "utf_32", "UTF_32LE", "UTF32_LE", "utf_32le", "UTF_32BE", "UTF32_BE", "utf_32be", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Charsets {
    public static final Charsets INSTANCE = new Charsets();
    public static final Charset ISO_8859_1;
    public static final Charset US_ASCII;
    public static final Charset UTF_16;
    public static final Charset UTF_16BE;
    public static final Charset UTF_16LE;
    public static final Charset UTF_8;
    private static volatile Charset utf_32;
    private static volatile Charset utf_32be;
    private static volatile Charset utf_32le;

    static {
        Charset charsetForName = Charset.forName(C0000.decode(new byte[]{96, 108, ByteCompanionObject.MAX_VALUE, 79, 12}, "589b4a9e20", true));
        String strDecode = C0000.decode(new byte[]{2, 87, 23, 120, 80, 12, 82, 25, 31, 25, 72, 25}, "d8e61a7117f09c37");
        Intrinsics.checkNotNullExpressionValue(charsetForName, strDecode);
        UTF_8 = charsetForName;
        Charset charsetForName2 = Charset.forName(C0000.decode(new byte[]{102, 53, 116, 78, 0, 87}, "3a2c1a7e082a"));
        Intrinsics.checkNotNullExpressionValue(charsetForName2, strDecode);
        UTF_16 = charsetForName2;
        Charset charsetForName3 = Charset.forName(C0000.decode(new byte[]{49, 48, 116, 29, 7, 84, 38, 33}, "dd206b", true));
        Intrinsics.checkNotNullExpressionValue(charsetForName3, strDecode);
        UTF_16BE = charsetForName3;
        Charset charsetForName4 = Charset.forName(C0000.decode(new byte[]{97, 97, 37, 28, 9, 14, 116, 125}, "45c18888", 0.0f));
        Intrinsics.checkNotNullExpressionValue(charsetForName4, strDecode);
        UTF_16LE = charsetForName4;
        Charset charsetForName5 = Charset.forName(C0000.decode(new byte[]{100, 100, 31, 121, 101, 122, 47, 43}, "172869fb", false));
        Intrinsics.checkNotNullExpressionValue(charsetForName5, strDecode);
        US_ASCII = charsetForName5;
        Charset charsetForName6 = Charset.forName(C0000.decode(new byte[]{44, 100, 122, 20, 12, 15, 7, 0, 30, 0}, "e759472931", 0.0f));
        Intrinsics.checkNotNullExpressionValue(charsetForName6, strDecode);
        ISO_8859_1 = charsetForName6;
    }

    public final Charset UTF32() {
        Charset charset = utf_32;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName(C0000.decode(new byte[]{97, 103, 115, 27, 6, 2}, "435650cddee9", 0.0f));
        Intrinsics.checkNotNullExpressionValue(charsetForName, C0000.decode(new byte[]{7, 94, 16, 45, 0, 90, 83, 16, 77, 22, 72, 24}, "a1bca768c8f1", 4));
        utf_32 = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_BE() {
        Charset charset = utf_32be;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName(C0000.decode(new byte[]{54, 49, 39, 72, 0, 2, 39, 119}, "ceae30e2", 0.0f));
        Intrinsics.checkNotNullExpressionValue(charsetForName, C0000.decode(new byte[]{3, 13, 74, 42, 7, 12, 84, 24, 74, 27, 22, 75}, "eb8dfa10d58bc1ea", 0.0f));
        utf_32be = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_LE() {
        Charset charset = utf_32le;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName(C0000.decode(new byte[]{98, 99, 37, 25, 6, 1, 123, 116}, "77c45371", 0.0f));
        Intrinsics.checkNotNullExpressionValue(charsetForName, C0000.decode(new byte[]{82, 89, 23, 122, 81, 93, 81, 31, 76, 72, 26, 31}, "46e40047bf", false));
        utf_32le = charsetForName;
        return charsetForName;
    }

    private Charsets() {
    }
}
