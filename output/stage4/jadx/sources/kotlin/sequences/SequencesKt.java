package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class SequencesKt extends SequencesKt__SequencesJVMKt {
    public static List toList(Sequence sequence) {
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return EmptyList.INSTANCE;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Collections.singletonList(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
