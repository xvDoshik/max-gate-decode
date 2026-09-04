package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006/"}, d2 = {"Lkotlin/text/CharCategory;", "", "value", "", "code", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getCode", "()Ljava/lang/String;", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "contains", "", "char", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum CharCategory {
    UNASSIGNED(0, C0000.decode(new byte[]{117, 15}, "6ac2a45648", false)),
    UPPERCASE_LETTER(1, C0000.decode(new byte[]{117, 22}, "9c9b435f", true)),
    LOWERCASE_LETTER(2, C0000.decode(new byte[]{41, 85}, "e9a0699ec3c7")),
    TITLECASE_LETTER(3, C0000.decode(new byte[]{120, 71}, "430eef2d", 6)),
    MODIFIER_LETTER(4, C0000.decode(new byte[]{116, 9}, "8d46f0dca60d1d", false)),
    OTHER_LETTER(5, C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 11}, "3dfde4a92f4135", 3)),
    NON_SPACING_MARK(6, C0000.decode(new byte[]{117, 11}, "8e8cfc")),
    ENCLOSING_MARK(7, C0000.decode(new byte[]{126, 84}, "319e937467", false)),
    COMBINING_SPACING_MARK(8, C0000.decode(new byte[]{47, 86}, "b5b5f9e0b1")),
    DECIMAL_DIGIT_NUMBER(9, C0000.decode(new byte[]{122, 2}, "4fc2960b83", 0.0f)),
    LETTER_NUMBER(10, C0000.decode(new byte[]{122, 90}, "46245f7282")),
    OTHER_NUMBER(11, C0000.decode(new byte[]{124, 92}, "23fea65b52edd75b", false)),
    SPACE_SEPARATOR(12, C0000.decode(new byte[]{106, 67}, "000fb98d69620a99", 0.0f)),
    LINE_SEPARATOR(13, C0000.decode(new byte[]{105, 14}, "3b7853", 0.0f)),
    PARAGRAPH_SEPARATOR(14, C0000.decode(new byte[]{107, 73}, "195253bfe526", true)),
    CONTROL(15, C0000.decode(new byte[]{115, 84}, "07192a0711", 0.0f)),
    FORMAT(16, C0000.decode(new byte[]{119, 87}, "4189906d76c60f", 0.0f)),
    PRIVATE_USE(18, C0000.decode(new byte[]{33, 10}, "be4b2119f5e4a8", 0)),
    SURROGATE(19, C0000.decode(new byte[]{118, 66}, "51a646a28d4a97", true)),
    DASH_PUNCTUATION(20, C0000.decode(new byte[]{105, 84}, "9087136d4354", 0.0f)),
    START_PUNCTUATION(21, C0000.decode(new byte[]{102, 23}, "6d0e6eac83")),
    END_PUNCTUATION(22, C0000.decode(new byte[]{51, 0}, "ce171607", 0.0f)),
    CONNECTOR_PUNCTUATION(23, C0000.decode(new byte[]{103, 87}, "74e1c2", 0.0f)),
    OTHER_PUNCTUATION(24, C0000.decode(new byte[]{96, 87}, "084a651bd95e")),
    MATH_SYMBOL(25, C0000.decode(new byte[]{48, 90}, "c74042e999")),
    CURRENCY_SYMBOL(26, C0000.decode(new byte[]{99, 87}, "04b59d")),
    MODIFIER_SYMBOL(27, C0000.decode(new byte[]{96, 92}, "3735f2a407bc49")),
    OTHER_SYMBOL(28, C0000.decode(new byte[]{100, 86}, "7933ba1c1b")),
    INITIAL_QUOTE_PUNCTUATION(29, C0000.decode(new byte[]{50, 15}, "bf9488", false)),
    FINAL_QUOTE_PUNCTUATION(30, C0000.decode(new byte[]{53, 95}, "e99e8162", 0.0f));

    private final String code;
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<CharCategory> getEntries() {
        return $ENTRIES;
    }

    CharCategory(int i, String str) {
        this.value = i;
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }

    public final boolean contains(char c) {
        return Character.getType(c) == this.value;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkotlin/text/CharCategory$Companion;", "", "<init>", "()V", "valueOf", "Lkotlin/text/CharCategory;", "category", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CharCategory valueOf(int category) {
            if (category >= 0 && category < 17) {
                return CharCategory.getEntries().get(category);
            }
            if (18 > category || category >= 31) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{123, 88, 65, 82, 86, 91, 66, 29, 68, 71}, "8957140ddd30f4fe", 0.0f) + category + C0000.decode(new byte[]{19, 90, 70, 16, 88, 89, 77, 23, 84, 82, 4, 12, 93, 86, 81, 30}, "3350669707be"));
            }
            return CharCategory.getEntries().get(category - 1);
        }

        private Companion() {
        }
    }
}
