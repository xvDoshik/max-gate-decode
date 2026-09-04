package kotlin.sequences;

import java.util.Iterator;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 implements Sequence {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $this_asSequence$inlined;

    public /* synthetic */ SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(int i, Object obj) {
        this.$r8$classId = i;
        this.$this_asSequence$inlined = obj;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return (Iterator) this.$this_asSequence$inlined;
            default:
                return ((Iterable) this.$this_asSequence$inlined).iterator();
        }
    }
}
