package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.Insets;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ViewCompat {
    public static final /* synthetic */ int $r8$clinit = 0;

    public abstract class Api19Impl {
        public static int getAccessibilityLiveRegion(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public static boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        public static boolean isLaidOut(View view) {
            return view.isLaidOut();
        }

        public static boolean isLayoutDirectionResolved(View view) {
            return view.isLayoutDirectionResolved();
        }

        public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
        }

        public static void setAccessibilityLiveRegion(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    public abstract class Api21Impl {
        public static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(2131099740);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
            WindowInsets windowInsets = impl instanceof WindowInsetsCompat.Impl20 ? ((WindowInsetsCompat.Impl20) impl).mPlatformInsets : null;
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        public static boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        public static boolean dispatchNestedPreFling(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        public static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        public static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        public static ColorStateList getBackgroundTintList(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode getBackgroundTintMode(View view) {
            return view.getBackgroundTintMode();
        }

        public static float getElevation(View view) {
            return view.getElevation();
        }

        public static WindowInsetsCompat getRootWindowInsets(View view) {
            WindowInsetsCompat.BuilderImpl builderImpl29;
            if (WindowInsetsCompat.Api21ReflectionHolder.sReflectionSucceeded && view.isAttachedToWindow()) {
                try {
                    Object obj = WindowInsetsCompat.Api21ReflectionHolder.sViewAttachInfoField.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) WindowInsetsCompat.Api21ReflectionHolder.sStableInsets.get(obj);
                        Rect rect2 = (Rect) WindowInsetsCompat.Api21ReflectionHolder.sContentInsets.get(obj);
                        if (rect != null && rect2 != null) {
                            int i = Build.VERSION.SDK_INT;
                            if (i >= 30) {
                                builderImpl29 = new WindowInsetsCompat.BuilderImpl30();
                            } else {
                                builderImpl29 = i >= 29 ? new WindowInsetsCompat.BuilderImpl29() : new WindowInsetsCompat.BuilderImpl20();
                            }
                            builderImpl29.setStableInsets(Insets.of(rect.left, rect.top, rect.right, rect.bottom));
                            builderImpl29.setSystemWindowInsets(Insets.of(rect2.left, rect2.top, rect2.right, rect2.bottom));
                            WindowInsetsCompat windowInsetsCompatBuild = builderImpl29.build();
                            windowInsetsCompatBuild.mImpl.setRootWindowInsets(windowInsetsCompatBuild);
                            windowInsetsCompatBuild.mImpl.copyRootViewBounds(view.getRootView());
                            return windowInsetsCompatBuild;
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.getMessage();
                }
            }
            return null;
        }

        public static String getTransitionName(View view) {
            return view.getTransitionName();
        }

        public static float getTranslationZ(View view) {
            return view.getTranslationZ();
        }

        public static float getZ(View view) {
            return view.getZ();
        }

        public static boolean hasNestedScrollingParent(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean isImportantForAccessibility(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean isNestedScrollingEnabled(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void setElevation(View view, float f) {
            view.setElevation(f);
        }

        public static void setNestedScrollingEnabled(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(2131099732, onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(2131099740));
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(view, onApplyWindowInsetsListener) { // from class: androidx.core.view.ViewCompat.Api21Impl.1
                    public WindowInsetsCompat mLastInsets = null;
                    public final /* synthetic */ View val$v;

                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view2);
                        if (Build.VERSION.SDK_INT < 30) {
                            Api21Impl.callCompatInsetAnimationCallback(windowInsets, this.val$v);
                            if (windowInsetsCompat.equals(this.mLastInsets)) {
                                throw null;
                            }
                        }
                        this.mLastInsets = windowInsetsCompat;
                        throw null;
                    }
                });
            }
        }

        public static void setTransitionName(View view, String str) {
            view.setTransitionName(str);
        }

        public static void setTranslationZ(View view, float f) {
            view.setTranslationZ(f);
        }

        public static void setZ(View view, float f) {
            view.setZ(f);
        }

        public static boolean startNestedScroll(View view, int i) {
            return view.startNestedScroll(i);
        }

        public static void stopNestedScroll(View view) {
            view.stopNestedScroll();
        }
    }

    public abstract class Api23Impl {
        public static WindowInsetsCompat getRootWindowInsets(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets, null);
            WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
            impl.setRootWindowInsets(windowInsetsCompat);
            impl.copyRootViewBounds(view.getRootView());
            return windowInsetsCompat;
        }

        public static int getScrollIndicators(View view) {
            return view.getScrollIndicators();
        }

        public static void setScrollIndicators(View view, int i) {
            view.setScrollIndicators(i);
        }

        public static void setScrollIndicators(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    public final class UnhandledKeyEventManager {
        public static final ArrayList sViewsWithListeners = new ArrayList();
        public SparseArray mCapturedKeys;
        public WeakReference mLastDispatchedPreViewKeyEvent;
        public WeakHashMap mViewsContainingListeners;

        public final View dispatchInOrder(View view) {
            int size;
            WeakHashMap weakHashMap = this.mViewsContainingListeners;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View viewDispatchInOrder = dispatchInOrder(viewGroup.getChildAt(childCount));
                    if (viewDispatchInOrder != null) {
                        return viewDispatchInOrder;
                    }
                }
            }
            ArrayList arrayList = (ArrayList) view.getTag(2131099739);
            if (arrayList == null || (size = arrayList.size() - 1) < 0) {
                return null;
            }
            arrayList.get(size).getClass();
            throw new ClassCastException();
        }
    }

    static {
        new AtomicInteger(1);
        new WeakHashMap();
    }
}
