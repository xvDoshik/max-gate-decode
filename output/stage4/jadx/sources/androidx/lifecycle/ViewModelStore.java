package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ViewModelStore {
    public final LinkedHashMap map = new LinkedHashMap();

    public final void clear() {
        for (ViewModel viewModel : this.map.values()) {
            HashMap map = viewModel.mBagOfTags;
            if (map != null) {
                synchronized (map) {
                    try {
                        for (Object obj : viewModel.mBagOfTags.values()) {
                            if (obj instanceof Closeable) {
                                try {
                                    ((Closeable) obj).close();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            LinkedHashSet linkedHashSet = viewModel.mCloseables;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        for (Closeable closeable : viewModel.mCloseables) {
                            if (closeable != null) {
                                try {
                                    closeable.close();
                                } catch (IOException e2) {
                                    throw new RuntimeException(e2);
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            viewModel.onCleared();
        }
        this.map.clear();
    }
}
