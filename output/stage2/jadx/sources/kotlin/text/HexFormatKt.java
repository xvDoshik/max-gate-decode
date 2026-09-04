package kotlin.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"HexFormat", "Lkotlin/text/HexFormat;", "builderAction", "Lkotlin/Function1;", "Lkotlin/text/HexFormat$Builder;", "", "Lkotlin/ExtensionFunctionType;", "isCaseSensitive", "", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HexFormatKt {
    private static final HexFormat HexFormat(Function1<? super HexFormat.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, C0000.decode(new byte[]{80, 66, 12, 94, 6, 92, 75, 121, 85, 21, 10, 12, 88}, "27e2b9986acc62", 1));
        HexFormat.Builder builder = new HexFormat.Builder();
        function1.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isCaseSensitive(String str) {
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            char cCharAt = str2.charAt(i);
            if (Intrinsics.compare((int) cCharAt, Uuid.SIZE_BITS) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }
}
