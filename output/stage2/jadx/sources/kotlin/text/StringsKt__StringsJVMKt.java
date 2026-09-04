package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\b\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\b\u001a\u001d\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\b\u001a\u001d\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001H\u0081\b\u001a \u0010\b\u001a\u00020\t*\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a$\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a$\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a$\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a$\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\f\u0010\u0016\u001a\u00020\u0002*\u00020\u0017H\u0007\u001a \u0010\u0016\u001a\u00020\u0002*\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001H\u0007\u001a \u0010\u001a\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001H\u0007\u001a\f\u0010\u001b\u001a\u00020\u0002*\u00020\u001cH\u0007\u001a*\u0010\u001b\u001a\u00020\u0002*\u00020\u001c2\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0007\u001a\f\u0010\u001e\u001a\u00020\u001c*\u00020\u0002H\u0007\u001a*\u0010\u001e\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0007\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u0002H\u0087\b\u001a3\u0010\u001a\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0001H\u0087\b\u001a*\u0010!\u001a\u00020\u0002*\u00020\u00022\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0087\b¢\u0006\u0002\u0010%\u001a2\u0010!\u001a\u00020\u0002*\u00020&2\u0006\u0010!\u001a\u00020\u00022\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0087\b¢\u0006\u0002\u0010'\u001a4\u0010!\u001a\u00020\u0002*\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010)2\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0087\b¢\u0006\u0002\u0010*\u001a<\u0010!\u001a\u00020\u0002*\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010!\u001a\u00020\u00022\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0087\b¢\u0006\u0002\u0010+\u001a\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020-*\u00020.2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\u0001\u001a\u0015\u00102\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0001H\u0087\b\u001a\u001d\u00102\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u001a\u001c\u00103\u001a\u00020\t*\u00020\u00022\u0006\u00104\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a$\u00103\u001a\u00020\t*\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\u001c\u00105\u001a\u00020\t*\u00020\u00022\u0006\u00106\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a)\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020<H\u0087\b\u001a\u0019\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020<H\u0087\b\u001a!\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u001cH\u0087\b\u001a\u0011\u00107\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0017H\u0087\b\u001a!\u00107\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u0001H\u0087\b\u001a!\u00107\u001a\u00020\u00022\u0006\u0010>\u001a\u00020?2\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u0001H\u0087\b\u001a\u0011\u00107\u001a\u00020\u00022\u0006\u0010@\u001a\u00020AH\u0087\b\u001a\u0011\u00107\u001a\u00020\u00022\u0006\u0010B\u001a\u00020CH\u0087\b\u001a\u0015\u0010D\u001a\u00020\u0001*\u00020\u00022\u0006\u0010E\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010F\u001a\u00020\u0001*\u00020\u00022\u0006\u0010E\u001a\u00020\u0001H\u0087\b\u001a\u001d\u0010G\u001a\u00020\u0001*\u00020\u00022\u0006\u0010H\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u001a\u001c\u0010I\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\u0015\u0010J\u001a\u00020\t*\u00020\u00022\u0006\u0010K\u001a\u00020.H\u0087\b\u001a\u0015\u0010J\u001a\u00020\t*\u00020\u00022\u0006\u0010B\u001a\u00020AH\u0087\b\u001a\u0019\u0010J\u001a\u00020\t*\u0004\u0018\u00010.2\b\u0010\n\u001a\u0004\u0018\u00010.H\u0087\u0004\u001a \u0010J\u001a\u00020\t*\u0004\u0018\u00010.2\b\u0010\n\u001a\u0004\u0018\u00010.2\u0006\u0010\u000b\u001a\u00020\tH\u0007\u001a\r\u0010L\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u001d\u0010M\u001a\u00020\u0001*\u00020\u00022\u0006\u0010E\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\b\u001a4\u0010O\u001a\u00020\t*\u00020.2\u0006\u0010P\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020.2\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a4\u0010O\u001a\u00020\t*\u00020\u00022\u0006\u0010P\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\u0015\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020)H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020)H\u0087\b\u001a\u0015\u0010\u0012\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020)H\u0087\b\u001a\u0015\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020)H\u0087\b\u001a\u0017\u0010R\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010;\u001a\u00020<H\u0087\b\u001a\u0017\u0010S\u001a\u000200*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u0001H\u0087\b\u001a\f\u0010U\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020)H\u0007\u001a\f\u0010V\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010V\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020)H\u0007\u001a\u0012\u0010W\u001a\u00020\u0002*\u00020.2\u0006\u0010X\u001a\u00020\u0001\"%\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020\u00020Zj\b\u0012\u0004\u0012\u00020\u0002`[*\u00020&8F¢\u0006\u0006\u001a\u0004\b\\\u0010]¨\u0006^"}, d2 = {"nativeIndexOf", "", "", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "equals", "", "other", "ignoreCase", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "toUpperCase", "uppercase", "toLowerCase", "lowercase", "concatToString", "", "startIndex", "endIndex", "toCharArray", "decodeToString", "", "throwOnInvalidSequence", "encodeToByteArray", "destination", "destinationOffset", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "locale", "Ljava/util/Locale;", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "split", "", "", "regex", "Ljava/util/regex/Pattern;", "limit", "substring", "startsWith", "prefix", "endsWith", "suffix", "String", "bytes", "offset", "length", "charset", "Ljava/nio/charset/Charset;", "chars", "codePoints", "", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "compareTo", "contentEquals", "charSequence", "intern", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "toByteArray", "toPattern", "flags", "capitalize", "decapitalize", "repeat", "n", "CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    private static final String String(StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, C0000.decode(new byte[]{64, 21, 74, 80, 15, 84, 123, 20, 84, 7, 0, 16}, "3a89a39a2aeb", 6));
        return new String(stringBuffer);
    }

    private static final String String(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{69, 65, 74, 8, 92, 87, 116, 64, 81, 13, 86, 85, 68}, "658a20", true));
        return new String(sb);
    }

    private static final String String(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{80, 65, 65, 0, 17}, "285eb4e7"));
        return new String(bArr, Charsets.UTF_8);
    }

    private static final String String(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{91, 27, 21, 7, 66}, "9bab1496af97563c", 4));
        return new String(bArr, i, i2, Charsets.UTF_8);
    }

    private static final String String(byte[] bArr, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{7, 77, 21, 85, 68}, "e4a076f56463c0e9"));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{0, 93, 85, 70, 71, 82, 22}, "c54447b5b257", true));
        return new String(bArr, i, i2, charset);
    }

    private static final String String(byte[] bArr, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{1, 29, 18, 93, 65}, "cdf824", 6));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{0, 95, 82, 64, 21, 4, 67}, "c732fa7afa", 1));
        return new String(bArr, charset);
    }

    private static final String String(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{80, 90, 89, 20, 16}, "328fc1b09fe2e65d", false));
        return new String(cArr);
    }

    private static final String String(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{1, 81, 2, 19, 17}, "b9cab813c7bc8f"));
        return new String(cArr, i, i2);
    }

    private static final String String(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, C0000.decode(new byte[]{85, 86, 87, 0, 54, 14, 95, 87, 71, 22}, "693efa"));
        return new String(iArr, i, i2);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 68, 11, 11, 74, 91}, "f0cb9e", true));
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, C0000.decode(new byte[]{80, 0, 69, 117, 3, 82, 85, 76, 15, 77, 75, 75, 75, 29, 30}, "7e11f449c9cee3", 3));
        return StringsKt.capitalize(str, locale);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 23, 93, 81, 67, 7}, "cc5809ad76e2b49e", true));
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{85, 92, 80, 82, 89, 1}, "93335d00786865", 0.0f));
        if (str.length() <= 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        char upperCase = Character.toUpperCase(cCharAt);
        String strDecode = C0000.decode(new byte[]{66, 76, 6, 23, 22, 23, 11, 87, 2, 73, 31, 74, 27, 74}, "19ddbeb9ea1d5cd9", 0.0f);
        if (titleCase != upperCase) {
            sb.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, strDecode);
            Intrinsics.checkNotNull(strSubstring, C0000.decode(new byte[]{91, 16, 85, 85, 18, 84, 0, 15, 87, 88, 23, 68, 80, 80, 68, 80, 84, 22, 77, 25, 70, 88, 65, 15, 86, 89, 78, 10, 71, 89, 8, 19, 65, 28, 73, 92, 18, 93, 0, 23, 88, 25, 15, 5, 92, 82, 74, 96, 65, 23, 80, 87, 85}, "5e9927aa97cd25d3", 0.0f));
            String upperCase2 = strSubstring.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase2, C0000.decode(new byte[]{77, 95, 103, 64, 18, 3, 75, 115, 83, 67, 7, 78, 23, 30, 28, 25}, "9020bf", 0.0f));
            sb.append(upperCase2);
        }
        String strSubstring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, strDecode);
        sb.append(strSubstring2);
        return sb.toString();
    }

    private static final int codePointAt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 76, 90, 93, 17, 7}, "d824b9", 7));
        return str.codePointAt(i);
    }

    private static final int codePointBefore(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 17, 94, 95, 64, 15}, "6e6631fc8918cc", 0.0f));
        return str.codePointBefore(i);
    }

    private static final int codePointCount(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 70, 93, 93, 22, 9}, "4254e77dabbe94c1", 0.0f));
        return str.codePointCount(i, i2);
    }

    public static final int compareTo(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 76, 94, 12, 67, 8}, "a86e06", 3));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{86, 23, 81, 1, 16}, "9c9db9490b", 0));
        return z ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }

    public static final String concatToString(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{4, 23, 94, 80, 17, 88}, "8c69bf22ea2d42ab"));
        return new String(cArr);
    }

    public static final String concatToString(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{15, 66, 88, 15, 67, 93}, "360f0c5e88c2ac", 1));
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    private static final boolean contentEquals(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 17, 90, 15, 67, 93}, "ae2f0cfc14"));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{90, 10, 89, 69, 55, 86, 68, 22, 0, 12, 90, 7}, "9b87d35ceb"));
        return str.contentEquals(charSequence);
    }

    private static final boolean contentEquals(String str, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 67, 90, 81, 69, 12}, "e728625d505eb9d6", 4));
        Intrinsics.checkNotNullParameter(stringBuffer, C0000.decode(new byte[]{69, 16, 69, 95, 93, 3, 36, 17, 11, 95, 5, 84, 66}, "6d763dfdb3a106"));
        return str.contentEquals(stringBuffer);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 18, 12, 91, 21, 10}, "dfd2f47f9cf0d7f3", 0.0f));
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        String strDecode = C0000.decode(new byte[]{66, 76, 87, 69, 21, 75, 89, 86, 3, 31, 31, 23, 27, 31}, "1956a908d7", false);
        Intrinsics.checkNotNullExpressionValue(strSubstring, strDecode);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, C0000.decode(new byte[]{83, 7, 65, 39, 7, 83, 4, 19, 84, 76, 24, 74, 26, 29, 75}, "4b5cb5ef880d43bc"));
        Intrinsics.checkNotNull(strSubstring, C0000.decode(new byte[]{87, 68, 84, 88, 18, 84, 88, 8, 93, 13, 77, 17, 90, 81, 18, 84, 88, 21, 71, 66, 77, 94, 24, 90, 93, 89, 20, 8, 70, 14, 85, 17, 76, 77, 66, 82, 25, 12, 82, 20, 88, 31, 84, 85, 92, 80, 23, 53, 71, 16, 80, 95, 95}, "9184279f3b", 5));
        String lowerCase = strSubstring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{21, 95, 124, 87, 65, 92, 20, 113, 82, 16, 1, 25, 74, 26, 79, 25}, "a00869f23cd1d4", 1));
        StringBuilder sbAppend = sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, strDecode);
        return sbAppend.append(strSubstring2).toString();
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 66, 90, 81, 23, 88}, "d628df44"));
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{88, 14, 91, 5, 15, 1}, "4a8dcd3f685a3c"));
        if (str.length() <= 0 || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        String strDecode = C0000.decode(new byte[]{67, 68, 87, 16, 70, 67, 90, 10, 95, 78, 30, 31, 27, 74}, "015c213d8f");
        Intrinsics.checkNotNullExpressionValue(strSubstring, strDecode);
        Intrinsics.checkNotNull(strSubstring, C0000.decode(new byte[]{8, 66, 88, 93, 67, 90, 7, 89, 90, 94, 23, 25, 4, 82, 20, 82, 2, 74, 18, 23, 64, 94, 67, 87, 9, 89, 25, 95, 22, 85, 10, 23, 64, 72, 19, 92, 70, 93, 85, 71, 2, 23, 10, 86, 90, 86, 77, 106, 18, 69, 93, 95, 4}, "f741c9"));
        String lowerCase = strSubstring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{68, 88, 47, 14, 64, 84, 70, 116, 81, 68, 6, 73, 25, 31, 26, 30}, "07ca7147"));
        StringBuilder sbAppend = sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, strDecode);
        return sbAppend.append(strSubstring2).toString();
    }

    public static final String decodeToString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{15, 18, 95, 81, 66, 92}, "3f781ba9", 0.0f));
        return new String(bArr, Charsets.UTF_8);
    }

    public static final String decodeToString(byte[] bArr, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, C0000.decode(new byte[]{14, 17, 80, 15, 70, 13}, "2e8f53c0636d0a"));
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (!z) {
            return new String(bArr, i, i2 - i, Charsets.UTF_8);
        }
        String string = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i, i2 - i)).toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{66, 14, 101, 22, 20, 11, 87, 95, 16, 79, 72, 30, 31}, "6a6bfb988af0"));
        return string;
    }

    public static final byte[] encodeToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{14, 77, 12, 81, 75, 88}, "29d88fb9", 0.0f));
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, C0000.decode(new byte[]{3, 6, 68, 35, 27, 23, 83, 71, 29, 79, 74, 77, 25}, "dc0abc645a", false));
        return bytes;
    }

    public static final byte[] encodeToByteArray(String str, int i, int i2, boolean z) throws CharacterCodingException {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 69, 95, 11, 23, 8}, "517bd6bff98a", true));
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (!z) {
            String strSubstring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{66, 65, 84, 16, 66, 19, 11, 89, 4, 28, 25, 31, 22, 24}, "146c6ab7c47181", true));
            Charset charset = Charsets.UTF_8;
            Intrinsics.checkNotNull(strSubstring, C0000.decode(new byte[]{93, 67, 93, 13, 16, 83, 4, 10, 12, 12, 23, 70, 85, 81, 19, 85, 80, 18, 68, 16, 17, 11, 66, 13, 12, 8, 26, 90, 70, 90, 93, 65, 68, 73, 21, 1, 66, 9, 2, 16, 86, 26, 95, 87, 95, 6, 30, 99, 17, 22, 11, 13, 4}, "361a00edbccf74", 3));
            byte[] bytes = strSubstring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, C0000.decode(new byte[]{4, 0, 21, 32, 75, 65, 6, 69, 74, 31, 72, 72, 16}, "ceab25c6b1ff9988", 0.0f));
            return bytes;
        }
        ByteBuffer byteBufferEncode = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i, i2));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            Intrinsics.checkNotNull(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                Intrinsics.checkNotNull(bArrArray2);
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    public static final boolean endsWith(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 71, 11, 8, 74, 8}, "43ca9698179b", 2));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{71, 17, 94, 85, 13, 75}, "4d83d34a", false));
        return !z ? str.endsWith(str2) : StringsKt.regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    private static final String format(String str, Locale locale, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 77, 80, 94, 66, 15}, "598711df7267b7b9", 0.0f));
        Intrinsics.checkNotNullParameter(objArr, C0000.decode(new byte[]{7, 67, 4, 16}, "f1cc77a61e", false));
        String str2 = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(str2, C0000.decode(new byte[]{4, 89, 23, 85, 3, 65, 17, 74, 77, 26, 75}, "b6e8b59dc4"));
        return str2;
    }

    private static final String format(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 17, 95, 88, 64, 95}, "4e713a1a9ca5", false));
        Intrinsics.checkNotNullParameter(objArr, C0000.decode(new byte[]{4, 70, 81, 66}, "e461e1", 0.0f));
        String str2 = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(str2, C0000.decode(new byte[]{85, 10, 22, 91, 4, 77, 74, 72, 72, 31, 79}, "3ed6e9bff1f0"));
        return str2;
    }

    private static final String format(StringCompanionObject stringCompanionObject, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, C0000.decode(new byte[]{9, 66, 80, 88, 70, 9}, "56815791e02f71", 0.0f));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{83, 9, 22, 94, 2, 68}, "5fd3c032", 0.0f));
        Intrinsics.checkNotNullParameter(objArr, C0000.decode(new byte[]{7, 68, 94, 21}, "f69fd8c1"));
        String str2 = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(str2, C0000.decode(new byte[]{94, 93, 74, 8, 89, 69, 29, 29, 26, 23, 17}, "828e81534987", 2));
        return str2;
    }

    private static final String format(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, C0000.decode(new byte[]{4, 64, 95, 93, 21, 90}, "8474fd042c", true));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{94, 90, 23, 9, 4, 21}, "85edea6084", 7));
        Intrinsics.checkNotNullParameter(objArr, C0000.decode(new byte[]{82, 23, 84, 74}, "3e3976553e6bb2", 2));
        String str2 = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(str2, C0000.decode(new byte[]{94, 13, 17, 95, 88, 23, 16, 76, 77, 28, 16}, "8bc29c"));
        return str2;
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, C0000.decode(new byte[]{13, 69, 10, 95, 22, 7}, "11b6e9", 0.0f));
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(comparator, C0000.decode(new byte[]{122, 35, 96, 38, 109, 120, 44, 103, 124, 44, 96, 42, 102, 120, 52, 113, 102, 45, 97, 39, 119, 99}, "9b3c21b4", 1));
        return comparator;
    }

    private static final String intern(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 65, 10, 94, 74, 95}, "85b79a"));
        String strIntern = str.intern();
        Intrinsics.checkNotNullExpressionValue(strIntern, C0000.decode(new byte[]{81, 15, 69, 82, 16, 11, 26, 76, 22, 79, 24}, "8a17be2b"));
        return strIntern;
    }

    private static final String lowercase(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{15, 66, 10, 91, 23, 8}, "36b2d6", 1));
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{23, 12, 120, 91, 65, 87, 75, 38, 89, 18, 1, 30, 77, 77, 26, 29}, "cc44629e8ad6"));
        return lowerCase;
    }

    private static final String lowercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{11, 65, 14, 13, 21, 7}, "75fdf96e7ef3", 0.0f));
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{9, 87, 84, 3, 9, 84}, "e87be14701309f", false));
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{23, 11, 45, 88, 18, 82, 17, 119, 0, 16, 6, 27, 77, 74, 79, 30}, "cda7e7c4acc3", false));
        return lowerCase;
    }

    private static final int nativeIndexOf(String str, char c, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 23, 14, 89, 16, 11}, "fcf0c520347342dc"));
        return str.indexOf(c, i);
    }

    private static final int nativeIndexOf(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{15, 64, 10, 91, 65, 90}, "34b22d6e6db7", 1));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{64, 64, 16}, "34beab3d8a", 5));
        return str.indexOf(str2, i);
    }

    private static final int nativeLastIndexOf(String str, char c, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 66, 12, 94, 74, 95}, "86d79ab03b78", 0.0f));
        return str.lastIndexOf(c, i);
    }

    private static final int nativeLastIndexOf(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 71, 80, 10, 66, 93}, "d38c1c6d5456fb", 0));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{70, 69, 71}, "5154b6980cb9748f", true));
        return str.lastIndexOf(str2, i);
    }

    private static final int offsetByCodePoints(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 68, 13, 13, 16, 88}, "d0edcf7664afd6", 0));
        return str.offsetByCodePoints(i, i2);
    }

    public static final boolean regionMatches(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{12, 16, 13, 94, 17, 95}, "0de7bab2", 0.0f));
        Intrinsics.checkNotNullParameter(charSequence2, C0000.decode(new byte[]{9, 76, 10, 80, 22}, "f8b5d49707c498c2", true));
        return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? StringsKt.regionMatches((String) charSequence, i, (String) charSequence2, i2, i3, z) : StringsKt.regionMatchesImpl(charSequence, i, charSequence2, i2, i3, z);
    }

    public static final boolean regionMatches(String str, int i, String str2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 23, 11, 88, 66, 6}, "ecc118", 2));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{95, 16, 13, 6, 17}, "0decc5ce040e6d80"));
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static final String repeat(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{13, 68, 94, 80, 18, 7}, "1069a9ad"));
        if (i < 0) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{123, 90, 20, 89, 23, 17, 65, 8, 30, 67, 88, 23, 65, 71, 24, 81, 93, 21, 15, 88, 13, 28, 8, 3, 94, 2, 65, 11, 68, 86, 20, 19, 90, 64, 21, 23, 20, 80, 21, 70}, "85a7c1ff9c5b2383", false) + i + '.').toString());
        }
        if (i == 0) {
            return "";
        }
        int i2 = 1;
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append(charSequence);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final String replace(String str, char c, char c2, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 67, 9, 15, 23, 93}, "47afdc50159b", true));
        if (!z) {
            String strReplace = str.replace(c, c2);
            Intrinsics.checkNotNullExpressionValue(strReplace, C0000.decode(new byte[]{64, 85, 22, 92, 83, 91, 0, 77, 28, 30, 72, 25}, "20f028ee", false));
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            char cCharAt = str2.charAt(i);
            if (CharsKt.equals(cCharAt, c, z)) {
                cCharAt = c2;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static final String replace(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 66, 90, 89, 65, 14}, "1620209d", 2));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{88, 88, 82, 97, 89, 93, 66, 81}, "746781", true));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{92, 3, 18, 103, 84, 15, 71, 4}, "2fe15c2a35b99cc7", 0.0f));
        String str4 = str;
        int i = 0;
        int iIndexOf = StringsKt.indexOf(str4, str2, 0, z);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str2.length();
        int iCoerceAtLeast = RangesKt.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str4, i, iIndexOf).append(str3);
            i = iIndexOf + length;
            if (iIndexOf >= str.length()) {
                break;
            }
            iIndexOf = StringsKt.indexOf(str4, str2, iIndexOf + iCoerceAtLeast, z);
        } while (iIndexOf > 0);
        String string = sb.append((CharSequence) str4, i, str.length()).toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{76, 89, 48, 76, 67, 81, 87, 80, 28, 30, 27, 23, 17}, "86c818974059", 0.0f));
        return string;
    }

    public static final String replaceFirst(String str, char c, char c2, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 69, 95, 13, 67, 88}, "e17d0f85a1", 0.0f));
        String str2 = str;
        int iIndexOf$default = StringsKt.indexOf$default(str2, c, 0, z, 2, (Object) null);
        return iIndexOf$default < 0 ? str : StringsKt.replaceRange((CharSequence) str2, iIndexOf$default, iIndexOf$default + 1, (CharSequence) String.valueOf(c2)).toString();
    }

    public static final String replaceFirst(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 17, 91, 88, 23, 95}, "8e31dafd0a1e", false));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{93, 9, 1, 103, 2, 89, 20, 7}, "2ee1c5ab", false));
        Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{8, 4, 68, 102, 80, 9, 76, 86}, "fa301e937c48", false));
        String str4 = str;
        int iIndexOf$default = StringsKt.indexOf$default(str4, str2, 0, z, 2, (Object) null);
        return iIndexOf$default < 0 ? str : StringsKt.replaceRange((CharSequence) str4, iIndexOf$default, str2.length() + iIndexOf$default, (CharSequence) str3).toString();
    }

    public static final List<String> split(CharSequence charSequence, Pattern pattern, int i) {
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{10, 23, 10, 81, 18, 93}, "6cb8ac8275"));
        Intrinsics.checkNotNullParameter(pattern, C0000.decode(new byte[]{69, 81, 82, 80, 76}, "745545", false));
        StringsKt.requireNonNegativeLimit(i);
        if (i == 0) {
            i = -1;
        }
        String[] strArrSplit = pattern.split(charSequence, i);
        Intrinsics.checkNotNullExpressionValue(strArrSplit, C0000.decode(new byte[]{16, 19, 91, 91, 70, 73, 75, 23, 74, 26}, "cc722ae9d3", false));
        return ArraysKt.asList(strArrSplit);
    }

    public static final boolean startsWith(String str, String str2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 67, 91, 93, 70, 91}, "f7345e", false));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{19, 65, 0, 7, 90, 29}, "c3ea3ef783", 7));
        return !z ? str.startsWith(str2, i) : StringsKt.regionMatches(str, i, str2, 0, str2.length(), z);
    }

    public static final boolean startsWith(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{5, 76, 9, 95, 75, 14}, "98a6800d7208"));
        Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{18, 67, 84, 87, 95, 27}, "b1116cc81fec3112", false));
        return !z ? str.startsWith(str2) : StringsKt.regionMatches(str, 0, str2, 0, str2.length(), z);
    }

    private static final String substring(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{4, 16, 91, 81, 69, 13}, "8d3863b2b41574", 0.0f));
        String strSubstring = str.substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{18, 64, 84, 70, 17, 23, 92, 12, 81, 29, 27, 30, 79, 28}, "a565ee5b6550", 0.0f));
        return strSubstring;
    }

    private static final String substring(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 76, 12, 12, 22, 13}, "58dee3b885", 0));
        String strSubstring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{64, 16, 4, 70, 77, 67, 10, 10, 94, 78, 77, 76, 29, 76}, "3ef591cd9fcb"));
        return strSubstring;
    }

    private static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 66, 91, 95, 16, 12}, "f636c2e0d8", 3));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{1, 92, 4, 70, 68, 84, 18}, "b4e471f24753", false));
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, C0000.decode(new byte[]{3, 82, 23, 119, 24, 76, 4, 18, 73, 76, 23, 25, 77}, "d7c5a8aaab97", 0.0f));
        return bytes;
    }

    static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 23, 80, 80, 64, 6}, "cc8938aa230c7090", false));
        Intrinsics.checkNotNullParameter(charset, C0000.decode(new byte[]{80, 90, 84, 22, 66, 82, 16}, "325d17d2316017", 2));
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, C0000.decode(new byte[]{82, 93, 71, 123, 79, 70, 80, 75, 27, 23, 24, 28, 28}, "583962", 0.0f));
        return bytes;
    }

    private static final char[] toCharArray(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{14, 69, 9, 81, 70, 7}, "21a85950b1c974", 0.0f));
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, C0000.decode(new byte[]{66, 14, 114, 13, 84, 23, 121, 75, 17, 7, 79, 73, 31, 75, 27, 76}, "6a1e5e89cf", true));
        return charArray;
    }

    public static final char[] toCharArray(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 70, 9, 12, 75, 8}, "02ae86d0", 1));
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        char[] cArr = new char[i2 - i];
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    private static final char[] toCharArray(String str, char[] cArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 65, 88, 8, 74, 12}, "e50a92a2", true));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{84, 80, 68, 77, 8, 90, 81, 65, 94, 86, 15}, "0579a4", true));
        str.getChars(i2, i3, cArr, i);
        return cArr;
    }

    static /* synthetic */ char[] toCharArray$default(String str, char[] cArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = str.length();
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 64, 11, 89, 16, 6}, "c4c0c83bdc07eccb"));
        Intrinsics.checkNotNullParameter(cArr, C0000.decode(new byte[]{0, 92, 70, 23, 80, 13, 89, 70, 95, 14, 12}, "d95c9c826abe"));
        str.getChars(i2, i3, cArr, i);
        return cArr;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final String toLowerCase(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{93, 66, 92, 93, 68, 9}, "a64477bc24", 0.0f));
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{70, 91, 120, 88, 65, 3, 64, 119, 85, 68, 83, 78, 28, 26, 26, 30}, "24476f", false));
        return lowerCase;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final String toLowerCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{9, 21, 80, 10, 21, 88}, "5a8cff052dff", 0.0f));
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{10, 94, 81, 87, 9, 92}, "f126e995022c7633", false));
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, C0000.decode(new byte[]{17, 89, 47, 14, 70, 80, 23, 37, 88, 69, 0, 30, 77, 79, 31, 28}, "e6ca15ef96", false));
        return lowerCase;
    }

    private static final Pattern toPattern(String str, int i) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 23, 9, 15, 68, 11}, "1caf75c4", true));
        Pattern patternCompile = Pattern.compile(str, i);
        Intrinsics.checkNotNullExpressionValue(patternCompile, C0000.decode(new byte[]{86, 89, 9, 22, 92, 13, 87, 26, 27, 24, 74, 79}, "56df5a22", 4));
        return patternCompile;
    }

    static /* synthetic */ Pattern toPattern$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{10, 68, 89, 15, 64, 11}, "601f35c0", 0.0f));
        Pattern patternCompile = Pattern.compile(str, i);
        Intrinsics.checkNotNullExpressionValue(patternCompile, C0000.decode(new byte[]{84, 12, 12, 64, 93, 89, 82, 75, 79, 30, 26, 28}, "7ca045", 7));
        return patternCompile;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final String toUpperCase(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 76, 91, 10, 23, 15}, "c83cd1e6eb", 5));
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, C0000.decode(new byte[]{18, 10, 97, 21, 65, 3, 69, 123, 7, 22, 81, 77, 31, 72, 25, 17}, "fe4e1f78", 0.0f));
        return upperCase;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.5")
    private static final String toUpperCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{13, 18, 13, 81, 71, 7}, "1fe8493cd612a905"));
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{95, 89, 86, 2, 14, 80}, "365cb50c", 0.0f));
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, C0000.decode(new byte[]{70, 95, 97, 67, 70, 85, 68, 112, 82, 18, 87, 24, 26, 29, 24, 25}, "204360633a", false));
        return upperCase;
    }

    private static final String uppercase(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{5, 68, 81, 88, 75, 14}, "909180923b"));
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, C0000.decode(new byte[]{71, 94, 108, 19, 17, 7, 64, 118, 82, 66, 92, 75, 79, 76, 28, 28}, "319cab25"));
        return upperCase;
    }

    private static final String uppercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{90, 77, 92, 81, 64, 11}, "f94835d91b", 0.0f));
        Intrinsics.checkNotNullParameter(locale, C0000.decode(new byte[]{10, 89, 86, 89, 88, 86}, "f65843b8", 3));
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, C0000.decode(new byte[]{65, 14, 99, 21, 64, 4, 69, 118, 85, 22, 1, 30, 27, 79, 24, 76}, "5a6e0a754ed6", 1));
        return upperCase;
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.equals(str, str2, z);
    }

    public static final boolean equals(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ String replace$default(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(str, c, c2, z);
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(str, str2, str3, z);
    }

    public static /* synthetic */ String replaceFirst$default(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replaceFirst(str, c, c2, z);
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replaceFirst(str, str2, str3, z);
    }

    public static /* synthetic */ String concatToString$default(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return StringsKt.concatToString(cArr, i, i2);
    }

    public static /* synthetic */ char[] toCharArray$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return StringsKt.toCharArray(str, i, i2);
    }

    public static /* synthetic */ String decodeToString$default(byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return StringsKt.decodeToString(bArr, i, i2, z);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return StringsKt.encodeToByteArray(str, i, i2, z);
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, pattern, i);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(str, str2, z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(str, str2, i, z);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(str, str2, z);
    }

    public static /* synthetic */ int compareTo$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.compareTo(str, str2, z);
    }

    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return StringsKt.contentEqualsImpl(charSequence, charSequence2);
    }

    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (z) {
            return StringsKt.contentEqualsIgnoreCaseImpl(charSequence, charSequence2);
        }
        return StringsKt.contentEquals(charSequence, charSequence2);
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return StringsKt.regionMatches(charSequence, i, charSequence2, i2, i3, z);
    }

    public static /* synthetic */ boolean regionMatches$default(String str, int i, String str2, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = false;
        }
        return StringsKt.regionMatches(str, i, str2, i2, i3, z);
    }
}
