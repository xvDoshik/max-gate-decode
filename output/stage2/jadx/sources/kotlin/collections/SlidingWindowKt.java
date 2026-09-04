package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aD\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001aH\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedSequence", "Lkotlin/sequences/Sequence;", "", "T", "partialWindows", "", "reuseBuffer", "windowedIterator", "", "iterator", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Iterator<T> $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(int i, int i2, Iterator<? extends T> it, boolean z, boolean z2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$size = i;
            this.$step = i2;
            this.$iterator = it;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super List<? extends T>> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0090  */
        /* JADX WARN: Code duplicated, block: B:32:0x00bd  */
        /* JADX WARN: Code duplicated, block: B:33:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:37:0x00d4  */
        /* JADX WARN: Code duplicated, block: B:65:0x0153  */
        /* JADX WARN: Code duplicated, block: B:67:0x0157  */
        /* JADX WARN: Code duplicated, block: B:68:0x015b  */
        /* JADX WARN: Code duplicated, block: B:73:0x017d  */
        /* JADX WARN: Code duplicated, block: B:75:0x0186  */
        /* JADX WARN: Code duplicated, block: B:87:0x00cb A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:88:0x0099 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:89:0x0096 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:90:0x00a4 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:92:0x008a A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b5 -> B:16:0x0065). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x013c -> B:59:0x013f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0174 -> B:72:0x0177). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:15:0x0054
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 440
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void checkWindowSizeStep(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            String strDecode = C0000.decode(new byte[]{20, 94, 67, 22, 66, 69, 84, 84, 21, 84, 70, 86, 87, 17, 83, 23, 22, 69, 93, 82, 90, 19, 76, 0, 68, 10, 24}, "436e6e6153");
            throw new IllegalArgumentException((i != i2 ? C0000.decode(new byte[]{118, 90, 22, 11, 25, 22, 8, 24, 85, 23}, "45bc9eab07a10c", 5) + i + C0000.decode(new byte[]{65, 3, 11, 6, 18, 69, 77, 82, 20, 69}, "abeb2697de", true) + i2 + strDecode : C0000.decode(new byte[]{71, 93, 79, 82, 21}, "445754", 0.0f) + i + strDecode).toString());
        }
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(it, C0000.decode(new byte[]{95, 68, 6, 71, 87, 17, 9, 66}, "60c56ef09a11310d", 0.0f));
        return !it.hasNext() ? EmptyIterator.INSTANCE : SequencesKt.iterator(new AnonymousClass1(i, i2, it, z2, z, null));
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> sequence, final int i, final int i2, final boolean z, final boolean z2) {
        Intrinsics.checkNotNullParameter(sequence, C0000.decode(new byte[]{15, 69, 9, 15, 74, 93}, "31af9c49e1", 0));
        checkWindowSizeStep(i, i2);
        return new Sequence<List<? extends T>>() { // from class: kotlin.collections.SlidingWindowKt$windowedSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<List<? extends T>> iterator() {
                return SlidingWindowKt.windowedIterator(sequence.iterator(), i, i2, z, z2);
            }
        };
    }
}
