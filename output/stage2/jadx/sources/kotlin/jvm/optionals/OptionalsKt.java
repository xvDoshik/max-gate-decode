package kotlin.jvm.optionals;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a,\u0010\u0005\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00010\u00032\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aC\u0010\b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\u0087\bø\u0001\u0001ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\n\u001a;\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\r*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u000e\u001a\u0002H\fH\u0007¢\u0006\u0002\u0010\u000f\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0011\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0007\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0013\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0007\u001a$\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0007\u0082\u0002\u000b\n\u0002\b9\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"getOrNull", "T", "", "Ljava/util/Optional;", "(Ljava/util/Optional;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toCollection", "C", "", "destination", "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "toList", "", "toSet", "", "asSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk8"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class OptionalsKt {
    public static final <T> Sequence<T> asSequence(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, C0000.decode(new byte[]{11, 22, 9, 93, 67, 9}, "7ba407d9833e6e74", 2));
        return optional.isPresent() ? SequencesKt.sequenceOf(optional.get()) : SequencesKt.emptySequence();
    }

    public static final <T> T getOrDefault(Optional<? extends T> optional, T t) {
        Intrinsics.checkNotNullParameter(optional, C0000.decode(new byte[]{88, 18, 92, 12, 22, 6}, "df4ee81760", false));
        return optional.isPresent() ? optional.get() : t;
    }

    public static final <T> T getOrElse(Optional<? extends T> optional, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(optional, C0000.decode(new byte[]{4, 68, 13, 81, 23, 93}, "80e8dc78c67612", true));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{80, 84, 85, 4, 71, 91, 66, 50, 7, 94, 77, 86}, "413e276df283408f", 0.0f));
        return optional.isPresent() ? optional.get() : function0.invoke();
    }

    public static final <T> T getOrNull(Optional<T> optional) {
        Intrinsics.checkNotNullParameter(optional, C0000.decode(new byte[]{93, 76, 14, 10, 64, 14}, "a8fc300bf4", 7));
        return optional.orElse(null);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Optional<T> optional, C c) {
        Intrinsics.checkNotNullParameter(optional, C0000.decode(new byte[]{13, 76, 93, 10, 69, 6}, "185c68ace03e", 0.0f));
        Intrinsics.checkNotNullParameter(c, C0000.decode(new byte[]{0, 83, 64, 23, 15, 87, 7, 64, 10, 10, 91}, "d63cf9f4ce561d80", 0.0f));
        if (optional.isPresent()) {
            T t = optional.get();
            Intrinsics.checkNotNullExpressionValue(t, C0000.decode(new byte[]{85, 6, 66, 29, 77, 28, 29, 77}, "2c65c23da85acc"));
            c.add(t);
        }
        return c;
    }

    public static final <T> List<T> toList(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, C0000.decode(new byte[]{5, 71, 95, 15, 68, 10}, "937f74"));
        return optional.isPresent() ? CollectionsKt.listOf(optional.get()) : CollectionsKt.emptyList();
    }

    public static final <T> Set<T> toSet(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, C0000.decode(new byte[]{4, 76, 90, 15, 65, 14}, "882f2090aeb8", true));
        return optional.isPresent() ? SetsKt.setOf(optional.get()) : SetsKt.emptySet();
    }
}
