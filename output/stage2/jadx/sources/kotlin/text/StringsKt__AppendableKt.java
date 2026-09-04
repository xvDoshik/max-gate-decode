package kotlin.text;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\t\u001a5\u0010\n\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000b\"\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\f\u001a\u001a\u0010\r\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\b¢\u0006\u0002\u0010\u000e\u001a$\u0010\r\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0087\b¢\u0006\u0002\u0010\u000f\u001a\"\u0010\r\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0010H\u0087\b¢\u0006\u0002\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0014\u001a\u0002H\u00012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016H\u0000¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"appendRange", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "append", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendLine", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "", "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
public class StringsKt__AppendableKt {
    public static final <T extends Appendable> T append(T t, CharSequence... charSequenceArr) throws IOException {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{4, 18, 80, 13, 69, 15}, "8f8d616dc02e70", 3));
        Intrinsics.checkNotNullParameter(charSequenceArr, C0000.decode(new byte[]{78, 86, 94, 19, 80}, "872f5c8f6c38c4", false));
        for (CharSequence charSequence : charSequenceArr) {
            t.append(charSequence);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void appendElement(Appendable appendable, T t, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter(appendable, C0000.decode(new byte[]{89, 65, 11, 10, 67, 11}, "e5cc05ef4863cc", 0.0f));
        if (function1 != null) {
            appendable.append(function1.invoke(t));
            return;
        }
        if (t == 0 ? true : t instanceof CharSequence) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(t.toString());
        }
    }

    private static final Appendable appendLine(Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, C0000.decode(new byte[]{11, 21, 14, 93, 67, 93}, "7af40cb141bc80", 0.0f));
        return appendable.append('\n');
    }

    private static final Appendable appendLine(Appendable appendable, char c) {
        Intrinsics.checkNotNullParameter(appendable, C0000.decode(new byte[]{13, 70, 89, 12, 69, 93}, "121e6cf560f90b9b", 0.0f));
        return appendable.append(c).append('\n');
    }

    private static final Appendable appendLine(Appendable appendable, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(appendable, C0000.decode(new byte[]{89, 71, 95, 89, 22, 7}, "e370e92e786b55", 7));
        return appendable.append(charSequence).append('\n');
    }

    public static final <T extends Appendable> T appendRange(T t, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, C0000.decode(new byte[]{11, 71, 11, 15, 74, 10}, "73cf94dc"));
        Intrinsics.checkNotNullParameter(charSequence, C0000.decode(new byte[]{20, 86, 89, 68, 81}, "b75144f3691bf013", true));
        T t2 = (T) t.append(charSequence, i, i2);
        Intrinsics.checkNotNull(t2, C0000.decode(new byte[]{88, 69, 94, 89, 19, 86, 87, 94, 92, 90, 71, 21, 84, 85, 18, 86, 82, 70, 66, 16, 70, 90, 19, 91, 89, 94, 31, 91, 70, 89, 90, 16, 70, 76, 67, 80, 22, 100, 18, 90, 85, 21, 93, 95, 70, 89, 90, 91, 24, 68, 87, 77, 71, 27, 101, 68, 64, 92, 93, 82, 69, 123, 70, 106, 108, 116, 70, 64, 87, 91, 87, 84, 84, 92, 87, 126, 71, 27, 87, 64, 66, 80, 93, 81, 100, 81, 92, 82, 86}, "602535", false));
        return t2;
    }
}
