package androidx.savedstate;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LegacySavedStateHandleController$OnRecreation;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Recreator implements LifecycleEventObserver {
    public final ComponentActivity owner;

    public final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        public final LinkedHashSet classes = new LinkedHashSet();

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.registerSavedStateProvider(C0000.decode(new byte[]{81, 11, 2, 19, 94, 92, 92, 74, 74, 68, 82, 67, 83, 82, 67, 17, 7, 21, 84, 27, 106, 87, 23, 67, 82, 71, 66, 83, 66}, "0efa1582d73566", 0.0f), this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public final Bundle saveState() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(C0000.decode(new byte[]{6, 91, 85, 22, 17, 85, 18, 58, 17, 88, 107, 23, 7, 67, 21, 10, 23, 82}, "e74eb0ae", 5), new ArrayList<>(this.classes));
            return bundle;
        }
    }

    public Recreator(ComponentActivity componentActivity) {
        this.owner = componentActivity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        Object obj;
        boolean z;
        if (lifecycle$Event != Lifecycle$Event.ON_CREATE) {
            throw new AssertionError(C0000.decode(new byte[]{122, 83, 25, 70, 24, 82, 70, 6, 86, 67, 21, 91, 65, 69, 21, 18, 90, 82, 16, 44, 118, 104, 118, 100, 113, 119, 53, 119}, "46a2870c8756"));
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
        Bundle bundleConsumeRestoredStateForKey = ((SavedStateRegistry) this.owner.mSavedStateRegistryController.zzb).consumeRestoredStateForKey(C0000.decode(new byte[]{83, 94, 84, 16, 86, 8, 81, 73, 29, 71, 0, 64, 85, 93, 65, 68, 81, 22, 92, 79, 103, 84, 64, 64, 0, 68, 68, 92, 64}, "200b9a5134a609"));
        if (bundleConsumeRestoredStateForKey == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleConsumeRestoredStateForKey.getStringArrayList(C0000.decode(new byte[]{84, 15, 89, 21, 23, 7, 16, 59, 21, 10, 104, 67, 4, 22, 21, 92, 69, 6}, "7c8fdbcdae71aea3"));
        if (stringArrayList == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{123, 64, 88, 87, 85, 87, 18, 69, 81, 23, 95, 23, 67, 80, 74, 65, 89, 65, 92, 86, 18, 65, 76, 2, 67, 82, 17, 83, 86, 71, 22, 71, 81, 87, 18, 81, 87, 14, 71, 88, 95, 80, 87, 65, 22, 17, 88, 92, 86, 64, 87, 10, 83, 79, 31, 70, 88, 67, 83, 87, 74, 70, 83, 70, 93, 77, 101, 82, 66, 65, 88, 71, 66, 86, 75, 16, 18, 95, 77, 16, 67, 23, 82, 90, 87, 65, 87, 90, 87, 18, 94, 91, 75, 23, 23, 88, 87, 21, 74, 65, 68, 90, 87, 85, 65, 18, 90, 26, 23, 67, 89, 80, 25, 94, 83, 74, 25, 16, 81, 94, 89, 16, 68, 82, 66, 106, 77, 90, 105, 65, 92, 65, 70, 93, 74, 6, 21}, "956392228c7715"));
        }
        int size = stringArrayList.size();
        int i = 0;
        while (i < size) {
            String str = stringArrayList.get(i);
            i++;
            String str2 = str;
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        ComponentActivity componentActivity = this.owner;
                        ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                        SavedStateRegistry savedStateRegistry = (SavedStateRegistry) componentActivity.mSavedStateRegistryController.zzb;
                        viewModelStore.getClass();
                        Iterator it = new HashSet(viewModelStore.map.keySet()).iterator();
                        while (it.hasNext()) {
                            ViewModel viewModel = (ViewModel) viewModelStore.map.get((String) it.next());
                            LifecycleRegistry lifecycleRegistry = componentActivity.mLifecycleRegistry;
                            String strDecode = C0000.decode(new byte[]{87, 13, 92, 19, 86, 92, 80, 73, 24, 15, 81, 7, 92, 86, 77, 82, 90, 6, 22, 18, 88, 67, 81, 85, 69, 23, 89, 21, 92, 27, 66, 92, 24, 23, 89, 6}, "6c8a9541");
                            HashMap map = viewModel.mBagOfTags;
                            if (map == null) {
                                obj = null;
                            } else {
                                synchronized (map) {
                                    obj = viewModel.mBagOfTags.get(strDecode);
                                }
                            }
                            SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
                            if (savedStateHandleController != null && !(z = savedStateHandleController.isAttached)) {
                                if (z) {
                                    throw new IllegalStateException(C0000.decode(new byte[]{34, 14, 65, 83, 87, 0, 64, 66, 2, 77, 18, 82, 6, 13, 6, 6, 19, 66, 89, 68, 85, 11, 5, 92, 5, 74, 6, 9, 6, 45, 68, 88, 83, 22}, "cb366d9bc9f3ee"));
                                }
                                savedStateHandleController.isAttached = true;
                                lifecycleRegistry.addObserver(savedStateHandleController);
                                throw null;
                            }
                        }
                        if (!new HashSet(viewModelStore.map.keySet()).isEmpty()) {
                            if (!savedStateRegistry.isAllowingSavingState) {
                                throw new IllegalStateException(C0000.decode(new byte[]{123, 7, 12, 20, 13, 14, 76, 17, 72, 3, 16, 82, 12, 19, 85, 17, 76, 14, 11, 71, 67, 0, 91, 69, 81, 9, 12, 20, 2, 7, 76, 84, 74, 70, 13, 90, 48, 0, 78, 84, 113, 8, 17, 64, 2, 15, 91, 84, 107, 18, 3, 64, 6}, "8fb4ca81"));
                            }
                            SavedStateProvider savedStateProvider = savedStateRegistry.recreatorProvider;
                            if (savedStateProvider == null) {
                                savedStateProvider = new SavedStateProvider(savedStateRegistry);
                            }
                            savedStateRegistry.recreatorProvider = savedStateProvider;
                            try {
                                LegacySavedStateHandleController$OnRecreation.class.getDeclaredConstructor(null);
                                SavedStateProvider savedStateProvider2 = savedStateRegistry.recreatorProvider;
                                if (savedStateProvider2 != null) {
                                    savedStateProvider2.classes.add(LegacySavedStateHandleController$OnRecreation.class.getName());
                                }
                            } catch (NoSuchMethodException e) {
                                throw new IllegalArgumentException(C0000.decode(new byte[]{115, 15, 84, 70, 69, 21}, "0c5565") + LegacySavedStateHandleController$OnRecreation.class.getSimpleName() + C0000.decode(new byte[]{18, 15, 68, 17, 64, 70, 91, 81, 65, 4, 68, 2, 80, 83, 86, 67, 94, 22, 17, 1, 91, 8, 64, 68, 69, 20, 7, 18, 90, 71, 23, 95, 92, 66, 94, 16, 80, 3, 65, 16, 67, 14, 68, 4, 80, 21, 86, 67, 70, 13, 92, 3, 64, 15, 80, 81, 91, 13, 29, 70, 71, 80, 84, 68, 87, 3, 69, 7, 80}, "2b1b4f307adf5576"), e);
                            }
                        }
                    } catch (Exception e2) {
                        throw new RuntimeException(C0000.decode(new byte[]{36, 84, 11, 14, 0, 83, 66, 65, 13, 66, 12, 89, 17, 65, 3, 12, 17, 94, 3, 65, 7, 66}, "b5bbe7") + str2, e2);
                    }
                } catch (NoSuchMethodException e3) {
                    throw new IllegalStateException(C0000.decode(new byte[]{118, 93, 85, 74, 67, 18}, "514902") + clsAsSubclass.getSimpleName() + C0000.decode(new byte[]{22, 11, 66, 69, 70, 67, 10, 80, 70, 7, 19, 86, 83, 0, 86, 67, 94, 23, 66, 82, 95, 12, 64, 70, 68, 19, 84, 66, 93, 17, 66, 88, 94, 66, 92, 64, 82, 3, 69, 22, 70, 12, 66, 83, 85, 66, 82, 71, 66, 9, 90, 87, 70, 10, 1, 80, 92, 14, 74, 18, 68, 3, 84, 68, 87, 2, 22, 84, 84}, "6f762cb10b32"), e3);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{115, 84, 87, 16, 65, 66}, "086c2bf364"), str2, C0000.decode(new byte[]{18, 64, 0, 16, 12, 31, 70, 23, 7, 12, 23, 86, 86}, "27acb8")), e4);
            }
        }
    }
}
