package androidx.lifecycle;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.savedstate.SavedStateRegistry;
import java.util.Iterator;
import java.util.Map;
import kotlin.SynchronizedLazyImpl;
import okhttp3.Handshake;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    public boolean restored;
    public Bundle restoredState;
    public final SavedStateRegistry savedStateRegistry;
    public final SynchronizedLazyImpl viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ComponentActivity componentActivity) {
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel$delegate = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(1, componentActivity));
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.restoredState;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        Iterator it = ((SavedStateHandlesVM) this.viewModel$delegate.getValue()).handles.entrySet().iterator();
        if (!it.hasNext()) {
            this.restored = false;
            return bundle;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getValue().getClass();
        throw new ClassCastException();
    }
}
