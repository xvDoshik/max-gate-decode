package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ComponentActivity;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ReportFragment extends Fragment {
    public static final /* synthetic */ int $r8$clinit = 0;

    public abstract class Companion {
        /* JADX WARN: Multi-variable type inference failed */
        public static void dispatch$lifecycle_runtime_release(Activity activity, Lifecycle$Event lifecycle$Event) {
            LifecycleRegistry lifecycle;
            if (!(activity instanceof LifecycleOwner) || (lifecycle = ((LifecycleOwner) activity).getLifecycle()) == null) {
                return;
            }
            lifecycle.handleLifecycleEvent(lifecycle$Event);
        }
    }

    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final Companion Companion = new Companion();

        public final class Companion {
        }

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle$Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle$Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle$Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle$Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle$Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            int i = ReportFragment.$r8$clinit;
            Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle$Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static final void injectIfNeededIn(ComponentActivity componentActivity) {
        if (Build.VERSION.SDK_INT >= 29) {
            LifecycleCallbacks.Companion.getClass();
            componentActivity.registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        }
        FragmentManager fragmentManager = componentActivity.getFragmentManager();
        String strDecode = C0000.decode(new byte[]{81, 93, 92, 17, 11, 8, 82, 77, 75, 90, 91, 87, 86, 83, 27, 7, 92, 86, 22, 47, 13, 7, 83, 86, 28, 85, 94, 84, 119, 89, 17, 20, 81, 71, 91, 11, 1, 19, 24, 71, 0, 70, 93, 67, 71, 111, 4, 22, 81, 84, 85, 6, 10, 21, 105, 65, 4, 81}, "038cda65e62130bd", 0.0f);
        if (fragmentManager.findFragmentByTag(strDecode) == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), strDecode).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void dispatch(Lifecycle$Event lifecycle$Event) {
        if (Build.VERSION.SDK_INT < 29) {
            Companion.dispatch$lifecycle_runtime_release(getActivity(), lifecycle$Event);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dispatch(Lifecycle$Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle$Event.ON_DESTROY);
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        dispatch(Lifecycle$Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        dispatch(Lifecycle$Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        dispatch(Lifecycle$Event.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        dispatch(Lifecycle$Event.ON_STOP);
    }
}
