package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\r\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0002\u001a\r\u0010\u000f\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\u001a\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u001c\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\r\u0010\"\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010#\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020%H\u0000\u001a\u0010\u0010(\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u001e\u001a\u00020\u001f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006)"}, d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "isDefined", "", "isLetter", "isLetterOrDigit", "isDigit", "isIdentifierIgnorable", "isISOControl", "isJavaIdentifierPart", "isJavaIdentifierStart", "isWhitespace", "isUpperCase", "isLowerCase", "toUpperCase", "uppercaseChar", "uppercase", "", "locale", "Ljava/util/Locale;", "toLowerCase", "lowercaseChar", "lowercase", "isTitleCase", "toTitleCase", "titlecaseChar", "titlecase", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "isHighSurrogate", "isLowSurrogate", "digitOf", "", "char", "radix", "checkRadix", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/CharsKt")
public class CharsKt__CharJVMKt {
    public static final int checkRadix(int i) {
        if (2 > i || i >= 37) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{65, 81, 1, 13, 73, 25}, "30ed19", false) + i + C0000.decode(new byte[]{65, 22, 86, 75, 21, 11, 90, 66, 22, 80, 12, 68, 21, 4, 13, 8, 83, 24, 71, 4, 91, 81, 83, 25}, "aa785e5669bdce") + new IntRange(2, 36));
        }
        return i;
    }

    private static final String lowercase(char c) {
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, C0000.decode(new byte[]{11, 19, 88, 8, 18, 0, 5, 94, 15, 10, 17, 70, 86, 1, 18, 0, 5, 67, 21, 69, 17, 9, 20, 10, 93, 13, 73, 94, 20, 9, 9, 70, 64, 29, 66, 6, 68, 90, 0, 19, 4, 72, 88, 5, 92, 4, 74, 99, 21, 23, 12, 8, 83}, "ef4d2cd0ae", 0.0f));
        String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{68, 93, 125, 87, 65, 7, 67, 112, 4, 22, 6, 17, 76, 30, 30, 27}, "02186b13eec9b0", true));
        return lowerCase;
    }

    public static final String lowercase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{91, 11, 1, 0, 95, 3}, "7dba3f9b8d672ab5", 0.0f));
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, C0000.decode(new byte[]{8, 76, 15, 14, 19, 85, 88, 15, 13, 95, 18, 22, 1, 7, 67, 2, 7, 74, 23, 66, 71, 89, 25, 15, 12, 94, 75, 88, 22, 14, 15, 65, 18, 64, 19, 7, 19, 92, 88, 23, 2, 30, 10, 87, 13, 5, 77, 50, 18, 75, 10, 12, 84}, "f9cb369ac0f6cbca", 5));
        String lowerCase = strValueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{21, 91, 47, 13, 19, 3, 19, 37, 0, 71, 6, 74, 74, 72, 79, 79}, "a4cbdfaf"));
        return lowerCase;
    }

    public static final String titlecase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{84, 95, 91, 82, 85, 81}, "8083946eeddf"));
        String strUppercase = CharsKt.uppercase(c, locale);
        int length = strUppercase.length();
        String strDecode = C0000.decode(new byte[]{88, 64, 90, 85, 16, 87, 5, 8, 88, 14, 66, 25, 4, 7, 22, 86, 87, 74, 68, 20, 16, 9, 22, 15, 89, 87, 75, 12, 67, 89, 90, 25, 68, 77, 20, 3, 22, 11, 87, 79, 7, 76, 90, 84, 88, 94, 30, 103, 16, 20, 95, 15, 81}, "656904df6a69fb", 4);
        if (length <= 1) {
            String strValueOf = String.valueOf(c);
            Intrinsics.checkNotNull(strValueOf, strDecode);
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, C0000.decode(new byte[]{65, 10, 102, 69, 18, 81, 16, 37, 86, 23, 93, 75, 27, 75, 29, 28}, "5e35b4bf7d8c"));
            if (Intrinsics.areEqual(strUppercase, upperCase)) {
                return String.valueOf(Character.toTitleCase(c));
            }
        } else if (c != 329) {
            char cCharAt = strUppercase.charAt(0);
            Intrinsics.checkNotNull(strUppercase, strDecode);
            String strSubstring = strUppercase.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{75, 68, 1, 18, 17, 64, 81, 95, 4, 73, 75, 28, 22, 24}, "81cae2"));
            Intrinsics.checkNotNull(strSubstring, strDecode);
            String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{64, 12, 116, 9, 66, 6, 68, 116, 80, 74, 0, 31, 31, 26, 26, 74}, "4c8f5c6719e714", 0.0f));
            return cCharAt + lowerCase;
        }
        return strUppercase;
    }

    private static final String uppercase(char c) {
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, C0000.decode(new byte[]{90, 16, 14, 85, 67, 6, 86, 95, 93, 92, 64, 69, 0, 92, 67, 6, 86, 66, 71, 19, 64, 10, 66, 87, 12, 11, 26, 95, 70, 95, 88, 69, 22, 64, 19, 0, 23, 91, 82, 69, 85, 75, 14, 88, 13, 2, 25, 98, 71, 65, 93, 11, 5}, "4eb9ce7133", 3));
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, C0000.decode(new byte[]{76, 92, 108, 66, 18, 1, 23, 113, 86, 22, 86, 25, 22, 29, 23, 27}, "8392bde27e31", true));
        return upperCase;
    }

    public static final String uppercase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{95, 13, 83, 2, 14, 81}, "3b0cb42fa31edafe", 0.0f));
        String strValueOf = String.valueOf(c);
        Intrinsics.checkNotNull(strValueOf, C0000.decode(new byte[]{91, 65, 93, 91, 25, 5, 84, 90, 95, 88, 77, 70, 87, 81, 17, 84, 88, 21, 65, 20, 69, 88, 25, 8, 90, 90, 28, 89, 76, 10, 89, 20, 69, 78, 73, 3, 21, 94, 80, 65, 88, 72, 89, 85, 95, 80, 23, 53, 65, 70, 88, 89, 94}, "54179f"));
        String upperCase = strValueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, C0000.decode(new byte[]{65, 93, 55, 72, 67, 83, 70, 117, 4, 16, 1, 76, 30, 74, 27, 27}, "52b83646ecdd0d", 0.0f));
        return upperCase;
    }

    public static final CharCategory getCategory(char c) {
        return CharCategory.INSTANCE.valueOf(Character.getType(c));
    }

    private static final boolean isDefined(char c) {
        return Character.isDefined(c);
    }

    private static final boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    private static final boolean isLetterOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static final boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static final boolean isIdentifierIgnorable(char c) {
        return Character.isIdentifierIgnorable(c);
    }

    private static final boolean isISOControl(char c) {
        return Character.isISOControl(c);
    }

    private static final boolean isJavaIdentifierPart(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    private static final boolean isJavaIdentifierStart(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    private static final boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    private static final boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toUpperCase(char c) {
        return Character.toUpperCase(c);
    }

    private static final char uppercaseChar(char c) {
        return Character.toUpperCase(c);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    private static final char lowercaseChar(char c) {
        return Character.toLowerCase(c);
    }

    private static final boolean isTitleCase(char c) {
        return Character.isTitleCase(c);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final char toTitleCase(char c) {
        return Character.toTitleCase(c);
    }

    private static final char titlecaseChar(char c) {
        return Character.toTitleCase(c);
    }

    public static final CharDirectionality getDirectionality(char c) {
        return CharDirectionality.INSTANCE.valueOf(Character.getDirectionality(c));
    }

    private static final boolean isHighSurrogate(char c) {
        return Character.isHighSurrogate(c);
    }

    private static final boolean isLowSurrogate(char c) {
        return Character.isLowSurrogate(c);
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }
}
