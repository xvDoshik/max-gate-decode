package androidx.lifecycle;

import java.util.List;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class SavedStateHandleSupport {
    public static final SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 SAVED_STATE_REGISTRY_OWNER_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();
    public static final SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 VIEW_MODEL_STORE_OWNER_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();
    public static final SavedStateHandleSupport$DEFAULT_ARGS_KEY$1 DEFAULT_ARGS_KEY = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();

    public static void invokeMethodsForEvent(List list, LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event, LifecycleEventObserver lifecycleEventObserver) {
        int size;
        if (list == null || (size = list.size() - 1) < 0) {
            return;
        }
        ((ClassesInfoCache$MethodReference) list.get(size)).getClass();
        throw null;
    }
}
