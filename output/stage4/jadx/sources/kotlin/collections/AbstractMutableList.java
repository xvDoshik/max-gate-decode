package kotlin.collections;

import java.util.List;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class AbstractMutableList extends java.util.AbstractList implements List {
    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return removeAt(i);
    }

    public abstract Object removeAt(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
