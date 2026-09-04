package kotlin.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lkotlin/text/HexFormat;", "", "upperCase", "", "bytes", "Lkotlin/text/HexFormat$BytesHexFormat;", "number", "Lkotlin/text/HexFormat$NumberHexFormat;", "<init>", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", "getUpperCase", "()Z", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat;", "toString", "", "BytesHexFormat", "NumberHexFormat", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HexFormat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HexFormat Default = new HexFormat(false, BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib(), NumberHexFormat.INSTANCE.getDefault$kotlin_stdlib());
    private static final HexFormat UpperCase = new HexFormat(true, BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib(), NumberHexFormat.INSTANCE.getDefault$kotlin_stdlib());
    private final BytesHexFormat bytes;
    private final NumberHexFormat number;
    private final boolean upperCase;

    public HexFormat(boolean z, BytesHexFormat bytesHexFormat, NumberHexFormat numberHexFormat) {
        Intrinsics.checkNotNullParameter(bytesHexFormat, C0000.decode(new byte[]{80, 29, 68, 86, 75}, "2d038ad95c", 0.0f));
        Intrinsics.checkNotNullParameter(numberHexFormat, C0000.decode(new byte[]{90, 64, 85, 87, 80, 70}, "458554ebaf84fcde", false));
        this.upperCase = z;
        this.bytes = bytesHexFormat;
        this.number = numberHexFormat;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C0000.decode(new byte[]{126, 3, 28, 113, 91, 67, 15, 0, 76, 26, 60, 70, 68, 23, 20, 68, 18, 17, 93, 64, 117, 7, 23, 82, 20, 12, 66}, "6fd741ba82", true));
        sb.append(this.upperCase).append(C0000.decode(new byte[]{27, 105, 65, 20, 19, 65, 3, 77, 17, 6, 22, 24, 89, 23, 118, 75, 67, 6, 18, 124, 86, 25, 39, 91, 23, 14, 4, 76, 76, Base64.padSymbol}, "7ca43aa4ece8d742", false));
        BytesHexFormat bytesHexFormat = this.bytes;
        String strDecode = C0000.decode(new byte[]{16, 18, 25, 17, 19, 20, 24, 17}, "02913481", false);
        bytesHexFormat.appendOptionsTo$kotlin_stdlib(sb, strDecode).append('\n');
        sb.append(C0000.decode(new byte[]{25, 65, 17, 20, 77, 21}, "9a14d910940c", true)).append('\n');
        sb.append(C0000.decode(new byte[]{17, 21, 20, 23, 91, 16, 12, 90, 85, 67, 18, 89, 19, 121, 68, 88, 86, 82, 71, 45, 4, 64, 118, 94, 64, 9, 82, 67, 25}, "15475ea8012d37", 0.0f)).append('\n');
        this.number.appendOptionsTo$kotlin_stdlib(sb, strDecode).append('\n');
        sb.append(C0000.decode(new byte[]{66, 65, 18, 65, 24}, "ba2a1e0e754f9a", false)).append('\n');
        sb.append(C0000.decode(new byte[]{31}, "63532189"));
        return sb.toString();
    }

    public final boolean getUpperCase() {
        return this.upperCase;
    }

    public final BytesHexFormat getBytes() {
        return this.bytes;
    }

    public final NumberHexFormat getNumber() {
        return this.number;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u0006H\u0016J'\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\n\u0010 \u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006&"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat;", "", "bytesPerLine", "", "bytesPerGroup", "groupSeparator", "", "byteSeparator", "bytePrefix", "byteSuffix", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBytesPerLine", "()I", "getBytesPerGroup", "getGroupSeparator", "()Ljava/lang/String;", "getByteSeparator", "getBytePrefix", "getByteSuffix", "noLineAndGroupSeparator", "", "getNoLineAndGroupSeparator$kotlin_stdlib", "()Z", "shortByteSeparatorNoPrefixAndSuffix", "getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib", "ignoreCase", "getIgnoreCase$kotlin_stdlib", "toString", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BytesHexFormat {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final BytesHexFormat Default = new BytesHexFormat(IntCompanionObject.MAX_VALUE, IntCompanionObject.MAX_VALUE, C0000.decode(new byte[]{23, 69}, "7e71562fb82b", false), "", "", "");
        private final String bytePrefix;
        private final String byteSeparator;
        private final String byteSuffix;
        private final int bytesPerGroup;
        private final int bytesPerLine;
        private final String groupSeparator;
        private final boolean ignoreCase;
        private final boolean noLineAndGroupSeparator;
        private final boolean shortByteSeparatorNoPrefixAndSuffix;

        public BytesHexFormat(int i, int i2, String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{6, 17, 90, 64, 68, 55, 3, 64, 2, 69, 0, 23, 90, 71}, "ac554df0c7", 0.0f));
            Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{3, 64, 76, 81, 98, 0, 64, 82, 75, 87, 21, 86, 74}, "a9841e0396", true));
            Intrinsics.checkNotNullParameter(str3, C0000.decode(new byte[]{91, 76, 23, 83, 97, 16, 80, 7, 80, 72}, "95c61b5a9093bb", 0.0f));
            Intrinsics.checkNotNullParameter(str4, C0000.decode(new byte[]{81, 28, 23, 92, 48, 67, 84, 0, 90, 29}, "3ec9c62f", 7));
            this.bytesPerLine = i;
            this.bytesPerGroup = i2;
            this.groupSeparator = str;
            this.byteSeparator = str2;
            this.bytePrefix = str3;
            this.byteSuffix = str4;
            this.noLineAndGroupSeparator = i == Integer.MAX_VALUE && i2 == Integer.MAX_VALUE;
            this.shortByteSeparatorNoPrefixAndSuffix = str3.length() == 0 && str4.length() == 0 && str2.length() <= 1;
            this.ignoreCase = HexFormatKt.isCaseSensitive(str) || HexFormatKt.isCaseSensitive(str2) || HexFormatKt.isCaseSensitive(str3) || HexFormatKt.isCaseSensitive(str4);
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{66, 90}, "180f7b2c", 0.0f));
            Intrinsics.checkNotNullParameter(indent, C0000.decode(new byte[]{13, 89, 81, 83, 92, 18}, "d7562f691bf89e", true));
            StringBuilder sbAppend = sb.append(indent).append(C0000.decode(new byte[]{82, 24, 66, 84, 64, 98, 3, 68, 46, 80, 11, 81, 17, 95, 65}, "0a6132f6b9e41bae", 2)).append(this.bytesPerLine);
            String strDecode = C0000.decode(new byte[]{73}, "e098457cb3a14ca5", false);
            sbAppend.append(strDecode).append('\n');
            sb.append(indent).append(C0000.decode(new byte[]{85, 78, 16, 82, 67, 103, 81, 69, 36, 65, 88, 66, 20, 23, 13, 23}, "77d70747c3", 3)).append(this.bytesPerGroup).append(strDecode).append('\n');
            StringBuilder sbAppend2 = sb.append(indent).append(C0000.decode(new byte[]{82, 75, 11, 70, 68, 99, 7, 20, 89, 20, 86, 17, 95, 71, 21, 4, 68, 17}, "59d340bd8f7e05", true)).append(this.groupSeparator);
            String strDecode2 = C0000.decode(new byte[]{64, 31}, "b3326f955ac3");
            sbAppend2.append(strDecode2).append('\n');
            sb.append(indent).append(C0000.decode(new byte[]{4, 31, 69, 84, 100, 86, 21, 7, 20, 7, 69, 94, 69, 19, 88, 70, 68}, "ff1173ef", 5)).append(this.byteSeparator).append(strDecode2).append('\n');
            sb.append(indent).append(C0000.decode(new byte[]{87, 31, 70, 1, 98, 16, 87, 7, 8, 76, 20, 13, 19, 27}, "5f2d2b2aa44039")).append(this.bytePrefix).append(strDecode2).append('\n');
            sb.append(indent).append(C0000.decode(new byte[]{90, 72, 77, 84, 97, 17, 81, 4, 11, 65, 25, 88, 69, 21}, "81912d7bb99ee7", true)).append(this.byteSuffix).append(C0000.decode(new byte[]{67}, "a194bbf3a8", false));
            return sb;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(C0000.decode(new byte[]{116, 73, 76, 4, 66, 126, 3, 27, 113, 86, 64, 85, 87, 67, 30, 58}, "608a16fc792867", 3));
            appendOptionsTo$kotlin_stdlib(sb, C0000.decode(new byte[]{69, 69, 67, 22}, "eec69e45", 0.0f)).append('\n');
            sb.append(C0000.decode(new byte[]{31}, "600ea3", 0.0f));
            return sb.toString();
        }

        public final int getBytesPerLine() {
            return this.bytesPerLine;
        }

        public final int getBytesPerGroup() {
            return this.bytesPerGroup;
        }

        public final String getGroupSeparator() {
            return this.groupSeparator;
        }

        public final String getByteSeparator() {
            return this.byteSeparator;
        }

        public final String getBytePrefix() {
            return this.bytePrefix;
        }

        public final String getByteSuffix() {
            return this.byteSuffix;
        }

        /* JADX INFO: renamed from: getNoLineAndGroupSeparator$kotlin_stdlib, reason: from getter */
        public final boolean getNoLineAndGroupSeparator() {
            return this.noLineAndGroupSeparator;
        }

        /* JADX INFO: renamed from: getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib, reason: from getter */
        public final boolean getShortByteSeparatorNoPrefixAndSuffix() {
            return this.shortByteSeparatorNoPrefixAndSuffix;
        }

        /* JADX INFO: renamed from: getIgnoreCase$kotlin_stdlib, reason: from getter */
        public final boolean getIgnoreCase() {
            return this.ignoreCase;
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fR$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R$\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006 "}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "", "<init>", "()V", "value", "", "bytesPerLine", "getBytesPerLine", "()I", "setBytesPerLine", "(I)V", "bytesPerGroup", "getBytesPerGroup", "setBytesPerGroup", "groupSeparator", "", "getGroupSeparator", "()Ljava/lang/String;", "setGroupSeparator", "(Ljava/lang/String;)V", "byteSeparator", "getByteSeparator", "setByteSeparator", "bytePrefix", "getBytePrefix", "setBytePrefix", "byteSuffix", "getByteSuffix", "setByteSuffix", "build", "Lkotlin/text/HexFormat$BytesHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            private int bytesPerLine = BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib().getBytesPerLine();
            private int bytesPerGroup = BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib().getBytesPerGroup();
            private String groupSeparator = BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib().getGroupSeparator();
            private String byteSeparator = BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib().getByteSeparator();
            private String bytePrefix = BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib().getBytePrefix();
            private String byteSuffix = BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib().getByteSuffix();

            public final void setBytePrefix(String str) {
                Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{71, 81, 15, 69, 83}, "10c06668a4", true));
                String str2 = str;
                if (StringsKt.contains$default((CharSequence) str2, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{45, 119, 23, 87, 95, 84, 68, 116, 96, 70, 81, 92, 84, 67, 0, 82, 67, 83, 67, 67, 68, 86, 64, 3, 18, 68, 71, 94, 9, 88, 85, 95, 69, 85, 0, 23, 91, 8, 18, 86, 76, 69, 4, 97, 69, 83, 87, 89, 28, 27, 18, 4, 71, 64, 21, 70, 0, 66, 23}, "a17610d72f2451", 0) + str);
                }
                this.bytePrefix = str;
            }

            public final void setByteSeparator(String str) {
                Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{23, 80, 9, 70, 83}, "a1e36c", 0.0f));
                String str2 = str;
                if (StringsKt.contains$default((CharSequence) str2, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{42, 116, 19, 3, 88, 2, 69, 115, 103, 22, 5, 90, 82, 16, 87, 5, 17, 85, 71, 69, 70, 83, 65, 7, 22, 22, 23, 95, 93, 95, 4, 91, 71, 7, 82, 70, 12, 94, 21, 84, 31, 70, 86, 49, 83, 22, 4, 66, 84, 66, 9, 64, 31, 66, 84, 19, 17, 16, 66, 87, 21, 18}, "f23b6fe056", 1) + str);
                }
                this.byteSeparator = str;
            }

            public final void setByteSuffix(String str) {
                Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{19, 3, 91, 20, 82}, "eb7a74"));
                String str2 = str;
                if (StringsKt.contains$default((CharSequence) str2, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{45, 37, 66, 81, 88, 87, 18, 38, 98, 67, 82, 9, 89, 70, 84, 1, 21, 6, 16, 67, 22, 82, 64, 0, 16, 19, 67, 14, 80, 93, 87, 11, 21, 6, 6, 16, 95, 93, 18, 7, 73, 23, 84, 50, 77, 82, 83, 11, 25, 79, 66, 82, 67, 71, 18, 18, 81, 16, 17}, "acb0632e0c1a845b", false) + str);
                }
                this.byteSuffix = str;
            }

            public final void setBytesPerGroup(int i) {
                if (i <= 0) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{125, 91, 89, 73, 21, 88, 68, 93, 67, 15, 70, 92, 19, 66, 86, 8, 16, 82, 68, 20, 86, 20, 85, 25, 67, 70, 88, 12, 12, 85, 94, 64, 82, 2, 16, 95, 92, 70, 23, 6, 28, 67, 82, 71, 103, 3, 66, 126, 65, 91, 66, 20, 73, 23, 85, 65, 67, 70, 71, 88, 64, 20}, "347de7747f09", true) + i);
                }
                this.bytesPerGroup = i;
            }

            public final void setBytesPerLine(int i) {
                if (i <= 0) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{122, 13, 13, 73, 73, 92, 16, 13, 64, 93, 19, 87, 17, 65, 82, 94, 65, 7, 16, 68, 88, 65, 6, 68, 68, 70, 10, 90, 88, 85, 90, 70, 81, 6, 67, 2, 86, 65, 67, 6, 77, 64, 0, 65, 97, 82, 65, 126, 93, 12, 6, 72, 25, 81, 22, 16, 20, 67, 4, 65, 17}, "4bcd93cd44e21732", 0.0f) + i);
                }
                this.bytesPerLine = i;
            }

            public final void setGroupSeparator(String str) {
                Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{89, 74, 82, 67, 73, 10, 91}, "e977d5", true));
                this.groupSeparator = str;
            }

            public final int getBytesPerLine() {
                return this.bytesPerLine;
            }

            public final int getBytesPerGroup() {
                return this.bytesPerGroup;
            }

            public final String getGroupSeparator() {
                return this.groupSeparator;
            }

            public final String getByteSeparator() {
                return this.byteSeparator;
            }

            public final String getBytePrefix() {
                return this.bytePrefix;
            }

            public final String getByteSuffix() {
                return this.byteSuffix;
            }

            public final BytesHexFormat build$kotlin_stdlib() {
                return new BytesHexFormat(this.bytesPerLine, this.bytesPerGroup, this.groupSeparator, this.byteSeparator, this.bytePrefix, this.byteSuffix);
            }
        }

        /* JADX INFO: compiled from: HexFormat.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/text/HexFormat$BytesHexFormat$Companion;", "", "<init>", "()V", "Default", "Lkotlin/text/HexFormat$BytesHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$BytesHexFormat;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BytesHexFormat getDefault$kotlin_stdlib() {
                return BytesHexFormat.Default;
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001a\u001a\u00020\u0003H\u0016J'\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006$"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat;", "", "prefix", "", "suffix", "removeLeadingZeros", "", "minLength", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "getPrefix", "()Ljava/lang/String;", "getSuffix", "getRemoveLeadingZeros", "()Z", "getMinLength$annotations", "()V", "getMinLength", "()I", "isDigitsOnly", "isDigitsOnly$kotlin_stdlib", "isDigitsOnlyAndNoPadding", "isDigitsOnlyAndNoPadding$kotlin_stdlib", "ignoreCase", "getIgnoreCase$kotlin_stdlib", "toString", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "Builder", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NumberHexFormat {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final NumberHexFormat Default = new NumberHexFormat("", "", false, 1);
        private final boolean ignoreCase;
        private final boolean isDigitsOnly;
        private final boolean isDigitsOnlyAndNoPadding;
        private final int minLength;
        private final String prefix;
        private final boolean removeLeadingZeros;
        private final String suffix;

        public NumberHexFormat(String str, String str2, boolean z, int i) {
            Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{20, 19, 92, 87, 92, 74}, "da915233"));
            Intrinsics.checkNotNullParameter(str2, C0000.decode(new byte[]{71, 64, 86, 5, 92, 65}, "450c5939c3"));
            this.prefix = str;
            this.suffix = str2;
            this.removeLeadingZeros = z;
            this.minLength = i;
            boolean z2 = str.length() == 0 && str2.length() == 0;
            this.isDigitsOnly = z2;
            this.isDigitsOnlyAndNoPadding = z2 && i == 1;
            this.ignoreCase = HexFormatKt.isCaseSensitive(str) || HexFormatKt.isCaseSensitive(str2);
        }

        public static /* synthetic */ void getMinLength$annotations() {
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, C0000.decode(new byte[]{21, 90}, "f8ec71e7fe354c", 0.0f));
            Intrinsics.checkNotNullParameter(indent, C0000.decode(new byte[]{94, 87, 93, 93, 8, 71}, "7998f3a1e5", true));
            StringBuilder sbAppend = sb.append(indent).append(C0000.decode(new byte[]{72, 66, 3, 83, 10, 28, 18, 89, 20, 64}, "80f5cd2d4b", 1)).append(this.prefix);
            String strDecode = C0000.decode(new byte[]{27, 31}, "93a4e3e8e18a", false);
            sbAppend.append(strDecode).append('\n');
            sb.append(indent).append(C0000.decode(new byte[]{68, 76, 80, 84, 11, 72, 65, 15, 23, 27}, "7962b0a2", true)).append(this.suffix).append(strDecode).append('\n');
            sb.append(indent).append(C0000.decode(new byte[]{23, 87, 8, 89, 20, 92, 126, 1, 87, 80, 12, 92, 2, 108, 7, 75, 93, 23, 22, 9, 69}, "e2e6b92d64")).append(this.removeLeadingZeros).append(',').append('\n');
            sb.append(indent).append(C0000.decode(new byte[]{88, 92, 95, 41, 1, 10, 86, 76, 10, 16, 8, 21}, "551edd18b0", 5)).append(this.minLength);
            return sb;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(C0000.decode(new byte[]{124, 69, 84, 86, 80, 16, 122, 84, 74, 37, 90, 64, 95, 81, 77, 28, 63}, "20945b212c52", 0.0f));
            appendOptionsTo$kotlin_stdlib(sb, C0000.decode(new byte[]{25, 24, 22, 16}, "9860f51c013885")).append('\n');
            sb.append(C0000.decode(new byte[]{29}, "4f010b964026008a", 5));
            return sb.toString();
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getSuffix() {
            return this.suffix;
        }

        public final boolean getRemoveLeadingZeros() {
            return this.removeLeadingZeros;
        }

        public final int getMinLength() {
            return this.minLength;
        }

        /* JADX INFO: renamed from: isDigitsOnly$kotlin_stdlib, reason: from getter */
        public final boolean getIsDigitsOnly() {
            return this.isDigitsOnly;
        }

        /* JADX INFO: renamed from: isDigitsOnlyAndNoPadding$kotlin_stdlib, reason: from getter */
        public final boolean getIsDigitsOnlyAndNoPadding() {
            return this.isDigitsOnlyAndNoPadding;
        }

        /* JADX INFO: renamed from: getIgnoreCase$kotlin_stdlib, reason: from getter */
        public final boolean getIgnoreCase() {
            return this.ignoreCase;
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dR$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R,\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "", "<init>", "()V", "value", "", "prefix", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "suffix", "getSuffix", "setSuffix", "removeLeadingZeros", "", "getRemoveLeadingZeros", "()Z", "setRemoveLeadingZeros", "(Z)V", "", "minLength", "getMinLength$annotations", "getMinLength", "()I", "setMinLength", "(I)V", "build", "Lkotlin/text/HexFormat$NumberHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            private String prefix = NumberHexFormat.INSTANCE.getDefault$kotlin_stdlib().getPrefix();
            private String suffix = NumberHexFormat.INSTANCE.getDefault$kotlin_stdlib().getSuffix();
            private boolean removeLeadingZeros = NumberHexFormat.INSTANCE.getDefault$kotlin_stdlib().getRemoveLeadingZeros();
            private int minLength = NumberHexFormat.INSTANCE.getDefault$kotlin_stdlib().getMinLength();

            public static /* synthetic */ void getMinLength$annotations() {
            }

            public final void setMinLength(int i) {
                if (i <= 0) {
                    throw new IllegalArgumentException((C0000.decode(new byte[]{44, 95, 13, 31, 22, 93, 67, 15, 71, 80, 20, 85, 67, 68, 7, 94, 69, 3, 64, 25, 3, 66, 6, 18, 22, 64, 95, 14, 90, 91, 11, 68, 6, 86, 70, 84, 95, 20, 19, 84, 11, 94, 47, 87, 8, 85, 68, 14, 31, 25, 0, 69, 23, 18, 17, 83, 67, 70}, "b0c2f20f39", true) + i).toString());
                }
                this.minLength = i;
            }

            public final void setPrefix(String str) {
                Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{71, 87, 8, 76, 81}, "16d94aead9c7435f", true));
                String str2 = str;
                if (StringsKt.contains$default((CharSequence) str2, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{117, 118, 66, 85, 10, 81, 24, 113, 107, 16, 1, 92, 5, 71, 89, 81, 77, 85, 16, 71, 68, 84, 74, 87, 25, 64, 16, 91, 12, 92, 90, 91, 77, 85, 6, 20, 13, 91, 24, 66, 75, 85, 4, 93, 28, 25, 24, 80, 76, 68, 66, 67, 5, 70, 24}, "90b4d582", 5) + str);
                }
                this.prefix = str;
            }

            public final void setSuffix(String str) {
                Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{18, 83, 9, 16, 83}, "d2ee6a35df"));
                String str2 = str;
                if (StringsKt.contains$default((CharSequence) str2, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{122, 115, 16, 3, 89, 84, 22, 118, 98, 66, 84, 88, 87, 71, 81, 1, 67, 85, 68, 70, 16, 3, 69, 85, 22, 69, 66, 13, 95, 89, 84, 92, 68, 7, 83, 16, 95, 91, 16, 17, 66, 86, 80, 92, 72, 78, 23, 82, 67, 65, 16, 21, 86, 67, 22}, "650b70", false) + str);
                }
                this.suffix = str;
            }

            public final String getPrefix() {
                return this.prefix;
            }

            public final String getSuffix() {
                return this.suffix;
            }

            public final boolean getRemoveLeadingZeros() {
                return this.removeLeadingZeros;
            }

            public final void setRemoveLeadingZeros(boolean z) {
                this.removeLeadingZeros = z;
            }

            public final int getMinLength() {
                return this.minLength;
            }

            public final NumberHexFormat build$kotlin_stdlib() {
                return new NumberHexFormat(this.prefix, this.suffix, this.removeLeadingZeros, this.minLength);
            }
        }

        /* JADX INFO: compiled from: HexFormat.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/text/HexFormat$NumberHexFormat$Companion;", "", "<init>", "()V", "Default", "Lkotlin/text/HexFormat$NumberHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$NumberHexFormat;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final NumberHexFormat getDefault$kotlin_stdlib() {
                return NumberHexFormat.Default;
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0017H\u0087\bø\u0001\u0000J%\u0010\u000f\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0017H\u0087\bø\u0001\u0000J\b\u0010\u0018\u001a\u00020\u0019H\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"Lkotlin/text/HexFormat$Builder;", "", "<init>", "()V", "upperCase", "", "getUpperCase", "()Z", "setUpperCase", "(Z)V", "bytes", "Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "_bytes", "number", "Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "_number", "", "builderAction", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "build", "Lkotlin/text/HexFormat;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private BytesHexFormat.Builder _bytes;
        private NumberHexFormat.Builder _number;
        private boolean upperCase = HexFormat.INSTANCE.getDefault().getUpperCase();

        private final void bytes(Function1<? super BytesHexFormat.Builder, Unit> builderAction) {
            Intrinsics.checkNotNullParameter(builderAction, C0000.decode(new byte[]{81, 67, 80, 94, 2, 7, 74, 116, 91, 65, 90, 89, 87}, "3692fb8585", 5));
            builderAction.invoke(getBytes());
        }

        private final void number(Function1<? super NumberHexFormat.Builder, Unit> builderAction) {
            Intrinsics.checkNotNullParameter(builderAction, C0000.decode(new byte[]{87, 23, 93, 88, 1, 82, 68, 34, 85, 23, 92, 13, 90}, "5b44e76c6c", 0.0f));
            builderAction.invoke(getNumber());
        }

        public final boolean getUpperCase() {
            return this.upperCase;
        }

        public final void setUpperCase(boolean z) {
            this.upperCase = z;
        }

        public final BytesHexFormat.Builder getBytes() {
            if (this._bytes == null) {
                this._bytes = new BytesHexFormat.Builder();
            }
            BytesHexFormat.Builder builder = this._bytes;
            Intrinsics.checkNotNull(builder);
            return builder;
        }

        public final NumberHexFormat.Builder getNumber() {
            if (this._number == null) {
                this._number = new NumberHexFormat.Builder();
            }
            NumberHexFormat.Builder builder = this._number;
            Intrinsics.checkNotNull(builder);
            return builder;
        }

        public final HexFormat build() {
            BytesHexFormat default$kotlin_stdlib;
            NumberHexFormat default$kotlin_stdlib2;
            boolean z = this.upperCase;
            BytesHexFormat.Builder builder = this._bytes;
            if (builder == null || (default$kotlin_stdlib = builder.build$kotlin_stdlib()) == null) {
                default$kotlin_stdlib = BytesHexFormat.INSTANCE.getDefault$kotlin_stdlib();
            }
            NumberHexFormat.Builder builder2 = this._number;
            if (builder2 == null || (default$kotlin_stdlib2 = builder2.build$kotlin_stdlib()) == null) {
                default$kotlin_stdlib2 = NumberHexFormat.INSTANCE.getDefault$kotlin_stdlib();
            }
            return new HexFormat(z, default$kotlin_stdlib, default$kotlin_stdlib2);
        }
    }

    /* JADX INFO: compiled from: HexFormat.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/text/HexFormat$Companion;", "", "<init>", "()V", "Default", "Lkotlin/text/HexFormat;", "getDefault", "()Lkotlin/text/HexFormat;", "UpperCase", "getUpperCase", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HexFormat getDefault() {
            return HexFormat.Default;
        }

        public final HexFormat getUpperCase() {
            return HexFormat.UpperCase;
        }
    }
}
