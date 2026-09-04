package androidx.lifecycle;

import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ViewModel {
    public final HashMap mBagOfTags = new HashMap();
    public final LinkedHashSet mCloseables = new LinkedHashSet();

    public void onCleared() {
    }
}
