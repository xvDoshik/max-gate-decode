package kotlin.comparisons;

import java.util.Comparator;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NaturalOrderComparator implements Comparator {
    public static final NaturalOrderComparator INSTANCE = new NaturalOrderComparator(0);
    public static final NaturalOrderComparator INSTANCE$1 = new NaturalOrderComparator(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ NaturalOrderComparator(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            default:
                return ((Comparable) obj2).compareTo((Comparable) obj);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.$r8$classId) {
            case 0:
                return INSTANCE$1;
            default:
                return INSTANCE;
        }
    }
}
