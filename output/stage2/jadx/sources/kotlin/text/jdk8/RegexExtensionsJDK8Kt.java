package kotlin.text.jdk8;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0002¨\u0006\u0005"}, d2 = {"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", "", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, pn = "kotlin.text", xi = 48)
public final class RegexExtensionsJDK8Kt {
    public static final MatchGroup get(MatchGroupCollection matchGroupCollection, String str) {
        Intrinsics.checkNotNullParameter(matchGroupCollection, C0000.decode(new byte[]{89, 64, 93, 80, 17, 11}, "e459b584a192", 6));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{87, 3, 89, 6}, "9b4cfe", 3));
        MatchNamedGroupCollection matchNamedGroupCollection = matchGroupCollection instanceof MatchNamedGroupCollection ? (MatchNamedGroupCollection) matchGroupCollection : null;
        if (matchNamedGroupCollection != null) {
            return matchNamedGroupCollection.get(str);
        }
        throw new UnsupportedOperationException(C0000.decode(new byte[]{106, 83, 77, 68, 11, 4, 20, 8, 12, 6, 22, 86, 75, 86, 66, 64, 75, 22, 91, 79, 66, 15, 3, 12, 7, 65, 95, 66, 25, 87, 88, 68, 24, 69, 76, 70, 18, 14, 16, 21, 7, 5, 22, 94, 87, 25, 67, 88, 81, 69, 25, 70, 14, 0, 22, 7, 13, 19, 91, 31}, "8696bababa619970", 5));
    }
}
