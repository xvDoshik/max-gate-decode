package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u00020\u00072\u001b\u0010\b\u001a\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a>\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u001b\u0010\b\u001a\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a/\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u000f\"\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010\u001a/\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u000f\"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0011\u001a2\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0087\b¢\u0006\u0002\u0010\u0016\u001a\u001a\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\b¢\u0006\u0002\u0010\u0018\u001a$\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0019H\u0087\b¢\u0006\u0002\u0010\u001a\u001a$\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0087\b¢\u0006\u0002\u0010\u001b\u001a$\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\u0013H\u0087\b¢\u0006\u0002\u0010\u001c\u001a\"\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\u001dH\u0087\b¢\u0006\u0002\u0010\u001e\u001a\"\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\u001fH\u0087\b¢\u0006\u0002\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "obj", "", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "buildString", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "str", "", "offset", "len", "(Ljava/lang/StringBuilder;[CII)Ljava/lang/StringBuilder;", "appendLine", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    private static final StringBuilder append(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{90, 23, 93, 91, 65, 13}, "fc5223a2cee0b098"));
        return sb.append(obj);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @ReplaceWith(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    private static final StringBuilder append(StringBuilder sb, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{90, 23, 12, 81, 74, 15}, "fcd89168de", false));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{70, 18, 64}, "5f26182033692393"));
        throw new NotImplementedError(null, 1, null);
    }

    public static final StringBuilder append(StringBuilder sb, Object... objArr) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{10, 76, 88, 12, 17, 15}, "680eb1f8", true));
        Intrinsics.checkNotNullParameter(objArr, C0000.decode(new byte[]{64, 88, 92, 65, 92}, "6904965e", 5));
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }

    public static final StringBuilder append(StringBuilder sb, String... strArr) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{11, 69, 95, 95, 74, 10}, "717694b20a", true));
        Intrinsics.checkNotNullParameter(strArr, C0000.decode(new byte[]{66, 4, 93, 66, 93}, "4e178c2f84e6"));
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{88, 23, 10, 95, 69, 13}, "dcb66358", true));
        return sb.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{94, 67, 80, 93, 64, 9}, "b7843760db4185", false));
        return sb.append(c).append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{93, 67, 10, 94, 23, 14}, "a7b7d05ac26c7f"));
        return sb.append(charSequence).append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{10, 70, 14, 90, 64, 10}, "62f3347ee42136", false));
        return sb.append(obj).append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{12, 70, 89, 91, 71, 9}, "0212475c0b01", 1));
        return sb.append(str).append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{11, 22, 89, 11, 68, 92}, "7b1b7b", 0.0f));
        return sb.append(z).append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder sb, char[] cArr) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{95, 23, 88, 11, 67, 13}, "cc0b03f2d4f842"));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{21, 4, 13, 19, 4}, "ceafae297bb6", 0.0f));
        return sb.append(cArr).append('\n');
    }

    private static final String buildString(int i, Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{6, 67, 89, 85, 82, 93, 22, 119, 83, 77, 95, 87, 10}, "d60968", 5));
        StringBuilder sb = new StringBuilder(i);
        function1.invoke(sb);
        return sb.toString();
    }

    private static final String buildString(Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{4, 71, 13, 10, 80, 93, 68, 114, 85, 21, 81, 9, 13}, "f2df48636a8fc86e"));
        StringBuilder sb = new StringBuilder();
        function1.invoke(sb);
        return sb.toString();
    }
}
