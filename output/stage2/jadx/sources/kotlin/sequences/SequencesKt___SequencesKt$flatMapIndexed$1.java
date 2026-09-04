package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$1<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMapIndexed$1 INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$1();

    SequencesKt___SequencesKt$flatMapIndexed$1() {
        super(1, Iterable.class, C0000.decode(new byte[]{12, 16, 7, 70, 89, 68, 11, 69}, "edb480d7e985", true), C0000.decode(new byte[]{90, 65, 87, 70, 7, 77, 95, 67, 78, 30, 41, 89, 2, 67, 80, 77, 70, 65, 91, 88, 73, 112, 68, 84, 20, 86, 17, 92, 17, 14}, "3524f901f7e3c51b", 0.0f), 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Iterator<R> invoke(Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(iterable, C0000.decode(new byte[]{71, 0}, "705521", true));
        return iterable.iterator();
    }
}
