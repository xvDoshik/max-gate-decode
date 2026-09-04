package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.result.ActivityResult;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.SavedStateHandlesProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.tracing.Trace;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import androidx.work.Worker;
import com.google.android.gms.tasks.zzr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.internal.connection.Exchange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements ViewModelStoreOwner {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final AnonymousClass1 mActivityResultRegistry;
    public boolean mDispatchingOnMultiWindowModeChanged;
    public boolean mDispatchingOnPictureInPictureModeChanged;
    public final zzr mFullyDrawnReporter;
    public final LifecycleRegistry mLifecycleRegistry;
    public Exchange mOnBackPressedDispatcher;
    public final CopyOnWriteArrayList mOnConfigurationChangedListeners;
    public final CopyOnWriteArrayList mOnMultiWindowModeChangedListeners;
    public final CopyOnWriteArrayList mOnNewIntentListeners;
    public final CopyOnWriteArrayList mOnPictureInPictureModeChangedListeners;
    public final CopyOnWriteArrayList mOnTrimMemoryListeners;
    public final ReportFullyDrawnExecutorApi16Impl mReportFullyDrawnExecutor;
    public final zzr mSavedStateRegistryController;
    public ViewModelStore mViewModelStore;
    public final ContextAwareHelper mContextAwareHelper = new ContextAwareHelper();
    public final ConnectionPool mMenuHostHelper = new ConnectionPool(new CoroutineWorker$$ExternalSyntheticLambda0(1, this));

    /* JADX INFO: renamed from: androidx.activity.ComponentActivity$1, reason: invalid class name */
    public final class AnonymousClass1 {
        public final transient HashMap mKeyToCallback;
        public ArrayList mLaunchedKeys;
        public final HashMap mParsedPendingResults;
        public final Bundle mPendingResults;
        public final HashMap mRcToKey = new HashMap();
        public final HashMap mKeyToRc = new HashMap();

        public AnonymousClass1() {
            new HashMap();
            this.mLaunchedKeys = new ArrayList();
            this.mKeyToCallback = new HashMap();
            this.mParsedPendingResults = new HashMap();
            this.mPendingResults = new Bundle();
        }

        public final boolean dispatchResult(int i, int i2, Intent intent) {
            String str = (String) this.mRcToKey.get(Integer.valueOf(i));
            if (str == null) {
                return false;
            }
            if (this.mKeyToCallback.get(str) != null) {
                throw new ClassCastException();
            }
            this.mParsedPendingResults.remove(str);
            this.mPendingResults.putParcelable(str, new ActivityResult(intent, i2));
            return true;
        }
    }

    public abstract class Api33Impl {
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    public final class NonConfigurationInstances {
        public ViewModelStore viewModelStore;
    }

    public final class ReportFullyDrawnExecutorApi16Impl implements Executor, ViewTreeObserver.OnDrawListener, Runnable {
        public final long mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
        public boolean mOnDrawScheduled = false;
        public Runnable mRunnable;

        public ReportFullyDrawnExecutorApi16Impl() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.mRunnable = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.mOnDrawScheduled) {
                decorView.postOnAnimation(new CoroutineWorker$$ExternalSyntheticLambda0(2, this));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            boolean z;
            Runnable runnable = this.mRunnable;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.mEndWatchTimeMillis) {
                    this.mOnDrawScheduled = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.mRunnable = null;
            zzr zzrVar = ComponentActivity.this.mFullyDrawnReporter;
            synchronized (zzrVar.zza) {
                z = zzrVar.zzc;
            }
            if (z) {
                this.mOnDrawScheduled = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        public final void viewCreated(View view) {
            if (this.mOnDrawScheduled) {
                return;
            }
            this.mOnDrawScheduled = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.activity.ComponentActivity$$ExternalSyntheticLambda1] */
    public ComponentActivity() {
        String strDecode;
        LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        this.mLifecycleRegistry = lifecycleRegistry;
        zzr zzrVar = new zzr(this);
        this.mSavedStateRegistryController = zzrVar;
        SavedStateRegistry.SavedStateProvider savedStateProvider = null;
        this.mOnBackPressedDispatcher = null;
        this.mReportFullyDrawnExecutor = new ReportFullyDrawnExecutorApi16Impl();
        this.mFullyDrawnReporter = new zzr((ComponentActivity$$ExternalSyntheticLambda1) new Function0() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i = ComponentActivity.$r8$clinit;
                this.f$0.reportFullyDrawn();
                return null;
            }
        });
        new AtomicInteger();
        this.mActivityResultRegistry = new AnonymousClass1();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        lifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
                if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        lifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
                if (lifecycle$Event == Lifecycle$Event.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.context = null;
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().clear();
                    }
                    ReportFullyDrawnExecutorApi16Impl reportFullyDrawnExecutorApi16Impl = ComponentActivity.this.mReportFullyDrawnExecutor;
                    ComponentActivity componentActivity = ComponentActivity.this;
                    componentActivity.getWindow().getDecorView().removeCallbacks(reportFullyDrawnExecutorApi16Impl);
                    componentActivity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(reportFullyDrawnExecutorApi16Impl);
                }
            }
        });
        lifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
                ComponentActivity componentActivity = ComponentActivity.this;
                if (componentActivity.mViewModelStore == null) {
                    NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) componentActivity.getLastNonConfigurationInstance();
                    if (nonConfigurationInstances != null) {
                        componentActivity.mViewModelStore = nonConfigurationInstances.viewModelStore;
                    }
                    if (componentActivity.mViewModelStore == null) {
                        componentActivity.mViewModelStore = new ViewModelStore();
                    }
                }
                componentActivity.mLifecycleRegistry.removeObserver(this);
            }
        });
        zzrVar.performAttach();
        Lifecycle$State lifecycle$State = lifecycleRegistry.state;
        if (lifecycle$State != Lifecycle$State.INITIALIZED && lifecycle$State != Lifecycle$State.CREATED) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{35, 4, 8, 84, 87, 80, 69, 23, 0, 20, 20, 81, 64, 81, 8, 0, 11, 17, 79}, "eea824ee", 7));
        }
        Iterator it = ((SavedStateRegistry) zzrVar.zzb).components.iterator();
        while (true) {
            SafeIterableMap.AscendingIterator ascendingIterator = (SafeIterableMap.AscendingIterator) it;
            boolean zHasNext = ascendingIterator.hasNext();
            strDecode = C0000.decode(new byte[]{81, 90, 2, 66, 10, 90, 85, 74, 74, 84, 11, 5, 85, 87, 31, 83, 9, 86, 31, 91, 10, 76, 7, 17, 94, 85, 10, 30, 54, 82, 71, 87, 0, 107, 22, 2, 68, 81, 46, 81, 11, 87, 93, 87, 23, 104, 16, 12, 70, 93, 2, 85, 23}, "04f0e312d8bc", 0.0f);
            if (!zHasNext) {
                break;
            }
            Map.Entry entry = (Map.Entry) ascendingIterator.next();
            String str = (String) entry.getKey();
            SavedStateRegistry.SavedStateProvider savedStateProvider2 = (SavedStateRegistry.SavedStateProvider) entry.getValue();
            if (Intrinsics.areEqual(str, strDecode)) {
                savedStateProvider = savedStateProvider2;
                break;
            }
        }
        if (savedStateProvider == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider((SavedStateRegistry) zzrVar.zzb, this);
            ((SavedStateRegistry) zzrVar.zzb).registerSavedStateProvider(strDecode, savedStateHandlesProvider);
            lifecycleRegistry.addObserver(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
        ((SavedStateRegistry) this.mSavedStateRegistryController.zzb).registerSavedStateProvider(C0000.decode(new byte[]{0, 95, 93, 23, 86, 90, 0, 13, 18, 68, 73, 21, 86, 65, 16, 13, 0, 82, 77, 12, 79, 90, 16, 78, 76, 67, 92, 22, 76, 95, 16}, "a19e93d7"), new SavedStateRegistry.SavedStateProvider() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda2
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                int i = ComponentActivity.$r8$clinit;
                Bundle bundle = new Bundle();
                ComponentActivity.AnonymousClass1 anonymousClass1 = this.f$0.mActivityResultRegistry;
                anonymousClass1.getClass();
                HashMap map = anonymousClass1.mKeyToRc;
                bundle.putIntegerArrayList(C0000.decode(new byte[]{45, 39, 63, 107, 119, 42, 43, 97, 119, 120, 36, 127, 50, 61, 39, 119, 96, 44, 48, 120, 108, 111, 62, 99, 35, 37, 47, 103, 96, 32, 52, 116, 124, 105, 51, 114, 53}, "fbf44ef186a1", true), new ArrayList<>(map.values()));
                bundle.putStringArrayList(C0000.decode(new byte[]{45, 119, 96, 62, 112, 44, 46, 53, 41, 124, 124, 47, 103, 60, 34, 38, 50, 123, 111, 40, 103, 58, 60, 55, 35, 117, 112, 50, 103, 38, 49, 32, 34, 109, 114, 36, 106, 48}, "f29a3cce", false), new ArrayList<>(map.keySet()));
                bundle.putStringArrayList(C0000.decode(new byte[]{120, 113, 60, 60, 113, 124, 124, 100, 121, 126, 38, 124, 53, 110, 36, 37, 103, 125, 51, 42, 102, 106, 110, 120, 119, 101, 45, 113, 41, 116, 33, 57, 120, 113, 60, 48}, "34ec231460c2a1ef", 0.0f), new ArrayList<>(anonymousClass1.mLaunchedKeys));
                bundle.putBundle(C0000.decode(new byte[]{114, 32, 106, 107, 37, 123, 124, 51, 126, 42, 124, 43, 103, 107, 39, 119, 101, 42, 103, 45, 109, 60, 108, 100, 35, 122, 117, 42, 127, 35, 102, 55, 118, 103, 51, 120, 101}, "9e34f41c1d"), (Bundle) anonymousClass1.mPendingResults.clone());
                return bundle;
            }
        });
        ComponentActivity$$ExternalSyntheticLambda3 componentActivity$$ExternalSyntheticLambda3 = new ComponentActivity$$ExternalSyntheticLambda3(this);
        ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
        if (contextAwareHelper.context != null) {
            componentActivity$$ExternalSyntheticLambda3.onContextAvailable();
        }
        contextAwareHelper.listeners.add(componentActivity$$ExternalSyntheticLambda3);
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public final LifecycleRegistry getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{106, 12, 67, 66, 65, 88, 87, 65, 91, 19, 89, 23, 74, 67, 95, 67, 65, 87, 91, 65, 18, 28, 85, 23, 19, 2, 66, 68, 0, 90, 92, 80, 86, 69, 68, 12, 19, 23, 94, 85, 65, 120, 68, 69, 94, 12, 83, 2, 71, 10, 89, 94, 65, 80, 90, 70, 70, 4, 94, 0, 86, 77, 22, 105, 14, 76, 20, 86, 83, 11, 23, 23, 19, 17, 83, 65, 20, 92, 71, 65, 18, 51, 89, 6, 68, 46, 89, 84, 4, 85, 20, 87, 87, 3, 95, 17, 86, 67, 89, 94, 34, 75, 81, 84, 70, 0, 16, 0, 82, 15, 90, 30}, "3c60a9452e0c", 3));
        }
        if (this.mViewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.mViewModelStore = nonConfigurationInstances.viewModelStore;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
        return this.mViewModelStore;
    }

    public final void initializeViewTreeOwners() {
        getWindow().getDecorView().setTag(2131099746, this);
        getWindow().getDecorView().setTag(2131099749, this);
        getWindow().getDecorView().setTag(2131099748, this);
        getWindow().getDecorView().setTag(2131099747, this);
        getWindow().getDecorView().setTag(2131099722, this);
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        if (this.mActivityResultRegistry.dispatchResult(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new Exchange(new Worker.AnonymousClass1(1, this));
            this.mLifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity.6
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
                    if (lifecycle$Event != Lifecycle$Event.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                        return;
                    }
                    Exchange exchange = ComponentActivity.this.mOnBackPressedDispatcher;
                    exchange.connection = Api33Impl.getOnBackInvokedDispatcher((ComponentActivity) lifecycleOwner);
                    OnBackInvokedDispatcher onBackInvokedDispatcher = (OnBackInvokedDispatcher) exchange.connection;
                    OnBackInvokedCallback onBackInvokedCallback = (OnBackInvokedCallback) exchange.codec;
                    if (onBackInvokedDispatcher == null || onBackInvokedCallback == null || !exchange.hasFailure) {
                        return;
                    }
                    OnBackPressedDispatcher$Api33Impl.INSTANCE.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
                    exchange.hasFailure = false;
                }
            });
        }
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.mOnConfigurationChangedListeners.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        zzr zzrVar = this.mSavedStateRegistryController;
        if (!zzrVar.zzc) {
            zzrVar.performAttach();
        }
        LifecycleRegistry lifecycleRegistry = ((ComponentActivity) zzrVar.zza).mLifecycleRegistry;
        if (lifecycleRegistry.state.compareTo(Lifecycle$State.STARTED) >= 0) {
            throw new IllegalStateException((C0000.decode(new byte[]{19, 87, 19, 95, 89, 68, 15, 102, 92, 74, 23, 93, 19, 92, 22, 85, 3, 90, 87, 86, 23, 18, 3, 92, 22, 85, 3, 88, 85, 92, 7, 18, 22, 81, 83, 88, 66, 91, 78, 87, 6, 64, 65, 80, 69, 22}, "c2a966b499", 0.0f) + lifecycleRegistry.state).toString());
        }
        SavedStateRegistry savedStateRegistry = (SavedStateRegistry) zzrVar.zzb;
        if (!savedStateRegistry.attached) {
            throw new IllegalStateException(C0000.decode(new byte[]{58, 12, 17, 67, 95, 17, 16, 23, 68, 0, 83, 8, 15, 67, 20, 6, 64, 2, 12, 17, 9, 34, 70, 16, 2, 0, 12, 75, 27, 68, 1, 6, 2, 12, 64, 1, 67, 0, 5, 15, 94, 13, 13, 4, 68, 19, 87, 22, 5, 12, 22, 14, 96, 1, 16, 23, 11, 17, 87, 76, 33, 22, 10, 7, 94, 1, 74, 77}, "ccdc2d", 0.0f));
        }
        if (savedStateRegistry.isRestored) {
            throw new IllegalStateException(C0000.decode(new byte[]{53, 83, 20, 82, 93, 53, 17, 80, 66, 84, 102, 7, 1, 91, 17, 67, 75, 31, 69, 70, 87, 66, 20, 3, 10, 64, 7, 86, 93, 31, 69, 67, 83, 66, 64, 13, 20, 87, 6, 25}, "f2b79fe1614b", false));
        }
        savedStateRegistry.restoredState = bundle != null ? bundle.getBundle(C0000.decode(new byte[]{2, 91, 5, 75, 95, 81, 7, 76, 77, 89, 8, 95, 85, 91, 26, 87, 15, 80, 79, 123, 69, 86, 7, 88, 2, 87, 13, 92, 99, 89, 21, 81, 7, 102, 21, 88, 68, 93, 49, 81, 4, 92, 18, 77, 66, 65, 77, 95, 6, 76}, "c5a908c4", 0.0f)) : null;
        savedStateRegistry.isRestored = true;
        ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
        contextAwareHelper.context = this;
        Iterator it = contextAwareHelper.listeners.iterator();
        while (it.hasNext()) {
            ((ComponentActivity$$ExternalSyntheticLambda3) it.next()).onContextAvailable();
        }
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.mMenuHostHelper.delegate).iterator();
        if (!it.hasNext()) {
            return true;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) this.mMenuHostHelper.delegate).iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        if (this.mDispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator it = this.mOnMultiWindowModeChangedListeners.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.mOnNewIntentListeners.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.mMenuHostHelper.delegate).iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        if (this.mDispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator it = this.mOnPictureInPictureModeChangedListeners.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.mMenuHostHelper.delegate).iterator();
        if (!it.hasNext()) {
            return true;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.dispatchResult(i, -1, new Intent().putExtra(C0000.decode(new byte[]{81, 89, 85, 22, 11, 88, 92, 73, 77, 2, 86, 18, 94, 71, 89, 67, 72, 74, 22, 84, 75, 68, 15, 23, 27, 5, 88, 95, 68, 69, 80, 7, 16, 31, 93, 73, 23, 17, 84, 72, 103, 116, 98, 122, 120, 55, 55, 120, 119, 127, 48}, "071dd181cc5f71", 2), strArr).putExtra(C0000.decode(new byte[]{86, 13, 0, 64, 9, 90, 87, 30, 75, 2, 84, 23, 13, 68, 15, 71, 74, 72, 23, 6, 68, 22, 8, 70, 72, 80, 92, 8, 17, 17, 86, 0, 16, 28, 3, 75, 71, 20, 4, 77, 103, 38, 54, 127, 47, 96, 96, 47, 42, 45, 104, 36, 54, 115, 40, 103, 108, 52, 32, 48, 98, 47, 48, 97}, "7cd2f33fec", false), iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.viewModelStore;
        }
        if (viewModelStore == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.viewModelStore = viewModelStore;
        return nonConfigurationInstances2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        if (lifecycleRegistry != null) {
            lifecycleRegistry.enforceMainThreadIfNeeded(C0000.decode(new byte[]{69, 7, 70, 112, 17, 17, 68, 7, 92, 71, 55, 23, 87, 22, 87}, "6b23dc", 1));
            lifecycleRegistry.moveToState(Lifecycle$State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        SavedStateRegistry savedStateRegistry = (SavedStateRegistry) this.mSavedStateRegistryController.zzb;
        savedStateRegistry.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = savedStateRegistry.restoredState;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap safeIterableMap = savedStateRegistry.components;
        safeIterableMap.getClass();
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = safeIterableMap.new IteratorWithAdditions();
        safeIterableMap.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
        while (iteratorWithAdditions.hasNext()) {
            Map.Entry entry = (Map.Entry) iteratorWithAdditions.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle(C0000.decode(new byte[]{80, 15, 0, 75, 88, 12, 83, 26, 31, 13, 13, 95, 82, 6, 78, 1, 93, 4, 74, 123, 66, 11, 83, 14, 80, 3, 8, 92, 100, 4, 65, 7, 85, 50, 16, 88, 67, 0, 101, 7, 86, 8, 23, 77, 69, 28, 25, 9, 84, 24}, "1ad97e7b", 5), bundle2);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.mOnTrimMemoryListeners.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                android.os.Trace.beginSection(C0000.decode(new byte[]{70, 6, 64, 11, 16, 21, 115, 23, 89, 84, 75, 38, 68, 80, 22, 88, 28, 74, 16, 2, 13, 19, 21, 33, 90, 85, 66, 13, 88, 84, 15, 66, 117, 0, 68, 13, 20, 8, 65, 27}, "4c0dba5b582b61a6", 0));
            }
            super.reportFullyDrawn();
            zzr zzrVar = this.mFullyDrawnReporter;
            synchronized (zzrVar.zza) {
                try {
                    zzrVar.zzc = true;
                    ArrayList arrayList = (ArrayList) zzrVar.zzb;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        ((Function0) obj).invoke();
                    }
                    ((ArrayList) zzrVar.zzb).clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            android.os.Trace.endSection();
        } catch (Throwable th2) {
            android.os.Trace.endSection();
            throw th2;
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator it = this.mOnMultiWindowModeChangedListeners.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator it = this.mOnPictureInPictureModeChangedListeners.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }
}
