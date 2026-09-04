package androidx.savedstate;

import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SavedStateRegistry {
    public boolean attached;
    public final SafeIterableMap components = new SafeIterableMap();
    public boolean isAllowingSavingState = true;
    public boolean isRestored;
    public Recreator.SavedStateProvider recreatorProvider;
    public Bundle restoredState;

    public interface AutoRecreated {
    }

    public interface SavedStateProvider {
        Bundle saveState();
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        if (!this.isRestored) {
            throw new IllegalStateException(C0000.decode(new byte[]{97, 12, 76, 65, 7, 89, 13, 21, 90, 9, 88, 18, 67, 15, 93, 49, 92, 18, 16, 87, 17, 80, 93, 53, 66, 0, 66, 7, 126, 12, 75, 42, 1, 65, 67, 90, 87, 10, 79, 65, 87, 4, 76, 6, 75, 65, 23, 77, 19, 80, 75, 72, 89, 15, 117, 16, 93, 2, 77, 4, 68, 87, 5, 21, 90, 9, 68, 19, 83, 17, 72, 12, 87, 5, 13, 86, 4, 21, 90, 9, 91, 17, 89, 12, 93, 13, 77}, "8c9ad8c59f6a6b", 0.0f));
        }
        Bundle bundle = this.restoredState;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.restoredState;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.restoredState;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.restoredState = null;
        return bundle2;
    }

    public final void registerSavedStateProvider(String str, SavedStateProvider savedStateProvider) {
        Object obj;
        SafeIterableMap safeIterableMap = this.components;
        SafeIterableMap.Entry entry = safeIterableMap.get(str);
        if (entry != null) {
            obj = entry.mValue;
        } else {
            SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(str, savedStateProvider);
            safeIterableMap.mSize++;
            SafeIterableMap.Entry entry3 = safeIterableMap.mEnd;
            if (entry3 == null) {
                safeIterableMap.mStart = entry2;
                safeIterableMap.mEnd = entry2;
            } else {
                entry3.mNext = entry2;
                entry2.mPrevious = entry3;
                safeIterableMap.mEnd = entry2;
            }
            obj = null;
        }
        if (((SavedStateProvider) obj) != null) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{103, 4, 16, 93, 82, 96, 76, 85, 64, 0, 54, 74, 89, 69, 81, 80, 81, 23, 70, 79, 95, 71, 80, 20, 64, 13, 3, 24, 81, 90, 78, 81, 90, 69, 13, 93, 79, 19, 81, 71, 20, 4, 10, 74, 83, 82, 92, 77, 20, 23, 3, 95, 95, 64, 76, 81, 70, 0, 2}, "4ef86384", false));
        }
    }
}
