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
/* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$2<R> extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMapIndexed$2 INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$2();

    SequencesKt___SequencesKt$flatMapIndexed$2() {
        super(1, Sequence.class, C0000.decode(new byte[]{92, 69, 84, 71, 7, 23, 90, 67}, "5115fc", false), C0000.decode(new byte[]{93, 21, 87, 74, 86, 18, 91, 19, 26, 17, 123, 12, 85, 23, 83, 23, 66, 18, 93, 13, 29, 113, 67, 3, 70, 0, 70, 87, 69, 93}, "4a287f", 0), 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Iterator<R> invoke(Sequence<? extends R> sequence) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{17, 5}, "a5bed81ca1a99e", 5));
        return sequence.iterator();
    }
}
