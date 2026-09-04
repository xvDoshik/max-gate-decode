package kotlin.text;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a%\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0014\u0010\t\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a!\u0010\n\u001a\u00020\u000b*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0087\n\u001a-\u0010\r\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\b\u001a%\u0010\u0012\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a7\u0010\u0013\u001a\u00020\u000b*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0087\b\u001a-\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a-\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a5\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a5\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a\u001f\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bH\u0087\b\u001a%\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001dH\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\b\u001a\u0014\u0010\u001f\u001a\u00060 j\u0002`!*\u00060 j\u0002`!H\u0007\u001a\u001f\u0010\u001f\u001a\u00060 j\u0002`!*\u00060 j\u0002`!2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060 j\u0002`!*\u00060 j\u0002`!2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u0014\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001f\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bH\u0087\b\u001a\u001f\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a\u001f\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0087\b\u001a\u001f\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\b\u001a%\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020#H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001dH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\b¨\u0006$"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "", "insert", "index", "", "clear", "set", "", "", "setRange", "startIndex", "endIndex", "", "deleteAt", "deleteRange", "toCharArray", "destination", "", "destinationOffset", "appendRange", "", "insertRange", "appendLine", "Ljava/lang/StringBuffer;", "", "", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    private static final StringBuilder append(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{94, 66, 14, 15, 74, 8}, "b6ff962885", true));
        StringBuilder sbAppend = sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{7, 69, 22, 6, 93, 87, 25, 72, 27, 72, 30}, "f5fc331f5f72", 6));
        return sbAppend;
    }

    private static final StringBuilder append(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{10, 16, 94, 80, 18, 15}, "6d69a1", false));
        StringBuilder sbAppend = sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{89, 67, 19, 87, 94, 6, 28, 72, 72, 76, 75}, "83c20b4ffbb529bf"));
        return sbAppend;
    }

    private static final StringBuilder appendLine(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{12, 69, 92, 89, 67, 11}, "0140058dd8ec87e4", 0.0f));
        StringBuilder sbAppend = sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{87, 64, 18, 1, 10, 85, 73, 72, 24, 30, 75}, "60bdd1af", false));
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, double d) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{11, 65, 93, 92, 75, 7}, "755589b2c64e", true));
        StringBuilder sbAppend = sb.append(d);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{3, 71, 19, 1, 8, 85, 74, 27, 30, 28, 24}, "b7cdf1b5021b09dc", 2));
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, float f) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{10, 70, 90, 8, 71, 11}, "622a45", 5));
        StringBuilder sbAppend = sb.append(f);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{4, 22, 70, 7, 91, 82, 26, 79, 30, 79, 75}, "ef6b562a0ab6eb", 0));
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{90, 17, 9, 89, 17, 12}, "fea0b2ee1903", false));
        StringBuilder sbAppend = sb.append(i);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{7, 64, 67, 86, 89, 5, 17, 28, 72, 30, 26}, "f0337a92", 0.0f));
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, long j) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{10, 69, 10, 81, 70, 92}, "61b85b", 0.0f));
        StringBuilder sbAppend = sb.append(j);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{83, 20, 65, 85, 89, 0, 26, 30, 30, 27, 17}, "2d107d20058c", 0.0f));
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{14, 16, 92, 91, 71, 8}, "2d4246d93d9166fd", 3));
        StringBuilder sbAppend = sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{81, 66, 66, 3, 88, 5, 78, 22, 79, 30, 72}, "022f6af8a0a4b95d", 0.0f));
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{5, 21, 12, 10, 70, 90}, "9adc5d1d28", 0.0f));
        StringBuilder sbAppend = sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{87, 17, 68, 81, 95, 93, 75, 74, 28, 75, 31}, "6a4419cd2e68", 0.0f));
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{89, 76, 12, 92, 17, 8}, "e8d5b6c61565fca2", 6));
        StringBuilder sbAppend = sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{86, 17, 64, 7, 94, 1, 24, 31, 25, 79, 25}, "7a0b0e01", 0.0f));
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendRange(StringBuilder sb, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{12, 69, 88, 10, 66, 90}, "010c1d45ce2f7492", 4));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{18, 86, 15, 66, 84}, "d7c7121a32", false));
        StringBuilder sbAppend = sb.append(charSequence, i, i2);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{88, 68, 69, 85, 87, 85, 30, 25, 23, 26, 28}, "94509167", 0.0f));
        return sbAppend;
    }

    private static final StringBuilder appendRange(StringBuilder sb, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{11, 64, 89, 89, 75, 91}, "74108e278059", 2));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{23, 82, 92, 20, 81}, "a30a4c1c98", 7));
        StringBuilder sbAppend = sb.append(cArr, i, i2 - i);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{87, 64, 21, 3, 11, 84, 25, 29, 24, 30, 27}, "60efe0136027", 0.0f));
        return sbAppend;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final Appendable appendln(Appendable appendable) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, C0000.decode(new byte[]{4, 64, 93, 90, 67, 8}, "845306b5fa61a860", 6));
        Appendable appendableAppend = appendable.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, C0000.decode(new byte[]{5, 67, 18, 82, 8, 86, 73, 24, 31, 74, 31}, "d3b7f2a61d60aa6b", true));
        return appendableAppend;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final Appendable appendln(Appendable appendable, char c) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, C0000.decode(new byte[]{90, 16, 88, 8, 17, 10}, "fd0ab46bbf", 0.0f));
        Appendable appendableAppend = appendable.append(c);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, C0000.decode(new byte[]{85, 18, 67, 87, 87, 85, 73, 76, 74, 76, 26}, "4b3291abdb3b95", 0.0f));
        return StringsKt.appendln(appendableAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final Appendable appendln(Appendable appendable, CharSequence charSequence) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, C0000.decode(new byte[]{5, 68, 93, 90, 71, 91}, "90534e7d"));
        Appendable appendableAppend = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, C0000.decode(new byte[]{4, 67, 69, 4, 88, 5, 74, 75, 31, 22, 72}, "e35a6abe18ab7c6d", true));
        return StringsKt.appendln(appendableAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final StringBuilder appendln(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{11, 17, 89, 93, 64, 13}, "7e14330c98e0", 7));
        StringBuilder sbAppend = sb.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{0, 17, 19, 85, 11, 81, 78, 31, 23, 30, 72}, "aac0e5f190a6", 0.0f));
        return sbAppend;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{8, 22, 9, 88, 68, 95}, "4ba17aca650e", 0));
        StringBuilder sbAppend = sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{87, 69, 70, 86, 91, 87, 31, 74, 22, 74, 75}, "6563537d8db2", true));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{9, 65, 92, 13, 67, 93}, "554d0c20dd", false));
        StringBuilder sbAppend = sb.append(c);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{88, 71, 21, 92, 8, 2, 27, 77, 24, 22, 16}, "97e9ff3c689130", 1));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, double d) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{95, 66, 89, 88, 71, 95}, "c6114a97", false));
        StringBuilder sbAppend = sb.append(d);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{86, 70, 21, 6, 13, 0, 77, 77, 25, 24, 76}, "76eccdec", 6));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, float f) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{5, 71, 91, 94, 64, 15}, "933731a3eb33", 0.0f));
        StringBuilder sbAppend = sb.append(f);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{87, 22, 64, 92, 12, 87, 16, 75, 28, 79, 77}, "6f09b38e2ad8"));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{89, 64, 80, 89, 21, 7}, "e480f9c3e7b6af", 0.0f));
        StringBuilder sbAppend = sb.append(i);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{3, 69, 72, 3, 95, 0, 74, 27, 22, 72, 24}, "b58f1d", 7));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, long j) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{12, 23, 80, 8, 21, 10}, "0c8af4b95c37"));
        StringBuilder sbAppend = sb.append(j);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{82, 22, 73, 87, 87, 93, 17, 24, 72, 79, 27}, "3f929996fa2c79"));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{9, 76, 88, 91, 23, 13}, "5802d33da816c1", true));
        StringBuilder sbAppend = sb.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{84, 17, 71, 84, 10, 6, 27, 26, 27, 79, 30}, "5a71db34", false));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{94, 76, 93, 12, 21, 12}, "b85ef21f19", true));
        StringBuilder sbAppend = sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{86, 68, 21, 84, 88, 92, 24, 30, 76, 26, 76}, "74e16800b4e735d4", 6));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{8, 65, 95, 94, 75, 14}, "4577803f88"));
        StringBuilder sbAppend = sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{85, 69, 20, 93, 12, 6, 24, 27, 26, 30, 77}, "45d8bb0540de4b"));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{8, 69, 81, 92, 21, 95}, "4195fae3802114", true));
        StringBuilder sbAppend = sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{4, 71, 73, 85, 92, 87, 74, 30, 75, 74, 76}, "e79023b0ed", 0.0f));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{11, 17, 80, 88, 18, 13}, "7e81a3139912b143", 2));
        StringBuilder sbAppend = sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{3, 71, 72, 3, 94, 5, 74, 25, 22, 72, 25}, "b78f0a", 0.0f));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{15, 66, 11, 93, 70, 91}, "36c45e5a32"));
        StringBuilder sbAppend = sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{83, 22, 72, 6, 86, 1, 26, 72, 22, 77, 17}, "2f8c8e"));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{95, 23, 93, 8, 67, 13}, "cc5a03026e", 0));
        StringBuilder sbAppend = sb.append(z);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{2, 66, 67, 4, 11, 87, 77, 25, 28, 22, 30}, "c23ae3e7287a99", 6));
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder sb, char[] cArr) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{95, 23, 88, 12, 21, 95}, "cc0efaa46c2b", false));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{68, 86, 14, 64, 92}, "27b5970f", 1));
        StringBuilder sbAppend = sb.append(cArr);
        Intrinsics.checkNotNullExpressionValue(sbAppend, C0000.decode(new byte[]{82, 67, 69, 93, 10, 6, 28, 26, 31, 29, 17}, "3358db44138941", 0.0f));
        return StringsKt.appendln(sbAppend);
    }

    public static final StringBuilder clear(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{15, 70, 94, 91, 16, 6}, "3262c8", 7));
        sb.setLength(0);
        return sb;
    }

    private static final StringBuilder deleteAt(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{9, 65, 90, 92, 16, 92}, "5525cb6d"));
        StringBuilder sbDeleteCharAt = sb.deleteCharAt(i);
        Intrinsics.checkNotNullExpressionValue(sbDeleteCharAt, C0000.decode(new byte[]{80, 92, 89, 81, 64, 81, 113, 13, 2, 22, 32, 21, 28, 23, 27, 26, 29}, "4954442ecdaa"));
        return sbDeleteCharAt;
    }

    private static final StringBuilder deleteRange(StringBuilder sb, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{4, 17, 13, 93, 22, 7}, "8ee4e9", 1));
        StringBuilder sbDelete = sb.delete(i, i2);
        Intrinsics.checkNotNullExpressionValue(sbDelete, C0000.decode(new byte[]{85, 6, 14, 93, 68, 1, 76, 31, 77, 27, 24}, "1cb80dd1c5", 0.0f));
        return sbDelete;
    }

    private static final StringBuilder insert(StringBuilder sb, int i, byte b) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{15, 22, 12, 13, 66, 10}, "3bdd14bb0d8e7c", false));
        StringBuilder sbInsert = sb.insert(i, (int) b);
        Intrinsics.checkNotNullExpressionValue(sbInsert, C0000.decode(new byte[]{93, 10, 23, 80, 17, 17, 28, 74, 74, 27, 74}, "4dd5ce", true));
        return sbInsert;
    }

    private static final StringBuilder insert(StringBuilder sb, int i, short s) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{14, 77, 89, 10, 64, 90}, "291c3d", 2));
        StringBuilder sbInsert = sb.insert(i, (int) s);
        Intrinsics.checkNotNullExpressionValue(sbInsert, C0000.decode(new byte[]{91, 11, 70, 0, 66, 71, 17, 77, 23, 25, 74}, "2e5e039c97c227", false));
        return sbInsert;
    }

    private static final StringBuilder insertRange(StringBuilder sb, int i, CharSequence charSequence, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{8, 16, 80, 92, 21, 12}, "4d85f220b0", 0));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{67, 2, 85, 67, 1}, "5c96d2f9f8"));
        StringBuilder sbInsert = sb.insert(i, charSequence, i2, i3);
        Intrinsics.checkNotNullExpressionValue(sbInsert, C0000.decode(new byte[]{80, 94, 22, 81, 71, 23, 27, 22, 22, 31, 30}, "90e45c38817a3f6a", 0.0f));
        return sbInsert;
    }

    private static final StringBuilder insertRange(StringBuilder sb, int i, char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{88, 18, 9, 89, 22, 13}, "dfa0e3"));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{21, 85, 14, 76, 0}, "c4b9eae90d92"));
        StringBuilder sbInsert = sb.insert(i, cArr, i2, i3 - i2);
        Intrinsics.checkNotNullExpressionValue(sbInsert, C0000.decode(new byte[]{93, 94, 16, 7, 20, 16, 73, 29, 79, 29, 30}, "40cbfda3a378b071", 5));
        return sbInsert;
    }

    private static final void set(StringBuilder sb, int i, char c) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{13, 17, 93, 81, 23, 12}, "1e58d25fbea3", true));
        sb.setCharAt(i, c);
    }

    private static final StringBuilder setRange(StringBuilder sb, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{94, 76, 94, 11, 22, 8}, "b86be670b7657b6f", 0.0f));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{71, 7, 94, 67, 3}, "1f26fba88488ec", 6));
        StringBuilder sbReplace = sb.replace(i, i2, str);
        Intrinsics.checkNotNullExpressionValue(sbReplace, C0000.decode(new byte[]{64, 86, 69, 13, 4, 83, 83, 28, 30, 76, 24, 29}, "235ae0640b64c3", 0.0f));
        return sbReplace;
    }

    private static final void toCharArray(StringBuilder sb, char[] cArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{9, 67, 10, 10, 64, 88}, "57bc3ff5de33", 2));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{92, 6, 17, 22, 88, 10, 5, 76, 91, 13, 95}, "8cbb1dd82b14", 6));
        sb.getChars(i2, i3, cArr, i);
    }

    static /* synthetic */ void toCharArray$default(StringBuilder sb, char[] cArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sb.length();
        }
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{11, 23, 14, 8, 74, 6}, "7cfa98"));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{87, 82, 70, 21, 91, 11, 7, 17, 92, 10, 91}, "375a2efe5e512f83"));
        sb.getChars(i2, i3, cArr, i);
    }
}
