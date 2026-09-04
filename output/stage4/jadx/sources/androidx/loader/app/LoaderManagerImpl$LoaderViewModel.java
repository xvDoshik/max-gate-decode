package androidx.loader.app;

import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class LoaderManagerImpl$LoaderViewModel extends ViewModel {
    public final SparseArrayCompat mLoaders = new SparseArrayCompat();

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        SparseArrayCompat sparseArrayCompat = this.mLoaders;
        if (sparseArrayCompat.size() > 0) {
            sparseArrayCompat.valueAt(0).getClass();
            throw new ClassCastException();
        }
        int i = sparseArrayCompat.mSize;
        Object[] objArr = sparseArrayCompat.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        sparseArrayCompat.mSize = 0;
        sparseArrayCompat.mGarbage = false;
    }
}
