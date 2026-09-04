package kotlin.text;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0087\b¨\u0006\u0007"}, d2 = {"toRegex", "Lkotlin/text/Regex;", "", "option", "Lkotlin/text/RegexOption;", "options", "", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__RegexExtensionsKt extends StringsKt__RegexExtensionsJVMKt {
    private static final Regex toRegex(String str) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{12, 65, 89, 93, 65, 15}, "051421", false));
        return new Regex(str);
    }

    private static final Regex toRegex(String str, Set<? extends RegexOption> set) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{94, 21, 10, 13, 70, 88}, "babd5f133f", true));
        Intrinsics.checkNotNullParameter(set, C0000.decode(new byte[]{9, 20, 18, 88, 10, 88, 21}, "fdf1e6", 0.0f));
        return new Regex(str, set);
    }

    private static final Regex toRegex(String str, RegexOption regexOption) {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{8, 65, 90, 91, 71, 14}, "452240e67d"));
        Intrinsics.checkNotNullParameter(regexOption, C0000.decode(new byte[]{88, 70, 22, 90, 87, 92}, "76b382f8a7", 6));
        return new Regex(str, regexOption);
    }
}
