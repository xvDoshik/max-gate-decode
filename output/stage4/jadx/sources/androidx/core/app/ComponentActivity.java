package androidx.core.app;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ComponentActivity extends Activity implements LifecycleOwner {
    public final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);

    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean zBooleanValue;
        View decorView = getWindow().getDecorView();
        if (decorView != null && Headers.Companion.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return super.dispatchKeyEvent(keyEvent);
        }
        onUserInteraction();
        Window window = getWindow();
        boolean z = false;
        if (window.hasFeature(8)) {
            ActionBar actionBar = getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                if (!Headers.Companion.sActionBarFieldsFetched) {
                    try {
                        Headers.Companion.sActionBarOnMenuKeyMethod = actionBar.getClass().getMethod(C0000.decode(new byte[]{86, 86, 117, 93, 90, 23, 115, 82, 27, 39, 79, 93, 86, 76}, "98884b87bb", false), KeyEvent.class);
                    } catch (NoSuchMethodException unused) {
                    }
                    Headers.Companion.sActionBarFieldsFetched = true;
                }
                Method method = Headers.Companion.sActionBarOnMenuKeyMethod;
                if (method != null) {
                    try {
                        Object objInvoke = method.invoke(actionBar, keyEvent);
                        if (objInvoke == null) {
                            zBooleanValue = false;
                        } else {
                            zBooleanValue = ((Boolean) objInvoke).booleanValue();
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                    }
                } else {
                    zBooleanValue = false;
                }
                if (zBooleanValue) {
                    return true;
                }
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView2 = window.getDecorView();
        int i = ViewCompat.$r8$clinit;
        if (Build.VERSION.SDK_INT < 28) {
            ArrayList arrayList = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
            ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager = (ViewCompat.UnhandledKeyEventManager) decorView2.getTag(2131099738);
            if (unhandledKeyEventManager == null) {
                unhandledKeyEventManager = new ViewCompat.UnhandledKeyEventManager();
                unhandledKeyEventManager.mViewsContainingListeners = null;
                unhandledKeyEventManager.mCapturedKeys = null;
                unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = null;
                decorView2.setTag(2131099738, unhandledKeyEventManager);
            }
            if (keyEvent.getAction() == 0) {
                WeakHashMap weakHashMap = unhandledKeyEventManager.mViewsContainingListeners;
                if (weakHashMap != null) {
                    weakHashMap.clear();
                }
                ArrayList arrayList2 = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
                if (!arrayList2.isEmpty()) {
                    synchronized (arrayList2) {
                        try {
                            if (unhandledKeyEventManager.mViewsContainingListeners == null) {
                                unhandledKeyEventManager.mViewsContainingListeners = new WeakHashMap();
                            }
                            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                                ArrayList arrayList3 = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
                                View view = (View) ((WeakReference) arrayList3.get(size)).get();
                                if (view == null) {
                                    arrayList3.remove(size);
                                } else {
                                    unhandledKeyEventManager.mViewsContainingListeners.put(view, Boolean.TRUE);
                                    for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        unhandledKeyEventManager.mViewsContainingListeners.put((View) parent, Boolean.TRUE);
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
            View viewDispatchInOrder = unhandledKeyEventManager.dispatchInOrder(decorView2);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewDispatchInOrder != null && !KeyEvent.isModifierKey(keyCode)) {
                    if (unhandledKeyEventManager.mCapturedKeys == null) {
                        unhandledKeyEventManager.mCapturedKeys = new SparseArray();
                    }
                    unhandledKeyEventManager.mCapturedKeys.put(keyCode, new WeakReference(viewDispatchInOrder));
                }
            }
            if (viewDispatchInOrder != null) {
                z = true;
            }
        }
        if (z) {
            return true;
        }
        return keyEvent.dispatch(this, decorView2 != null ? decorView2.getKeyDispatcherState() : null, this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !Headers.Companion.dispatchBeforeHierarchy(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    public LifecycleRegistry getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        String strDecode = C0000.decode(new byte[]{94, 0, 66, 93, 48, 64, 3, 76, 86}, "3a06c4b8", false);
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        lifecycleRegistry.enforceMainThreadIfNeeded(strDecode);
        lifecycleRegistry.enforceMainThreadIfNeeded(C0000.decode(new byte[]{70, 83, 66, 34, 66, 66, 71, 83, 88, 21, 100, 68, 84, 66, 83}, "566a70", 2));
        lifecycleRegistry.moveToState(Lifecycle$State.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
