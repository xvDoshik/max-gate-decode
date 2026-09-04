package androidx.fragment.app;

import android.animation.Animator;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.startup.StartupException;
import androidx.tracing.Trace;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner {
    public boolean mAdded;
    public AnimationInfo mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    public boolean mCalled;
    public FragmentManagerImpl mChildFragmentManager;
    public FragmentManagerNonConfig mChildNonConfig;
    public ViewGroup mContainer;
    public int mContainerId;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public FragmentManagerImpl mFragmentManager;
    public boolean mFromLayout;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public FragmentActivity.HostCallbacks mHost;
    public boolean mInLayout;
    public boolean mIsCreated;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetaining;
    public Bundle mSavedFragmentState;
    public SparseArray mSavedViewState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public ViewModelStore mViewModelStore;
    public String mWho;
    public static final SimpleArrayMap sClassMap = new SimpleArrayMap();
    public static final Object USE_DEFAULT_TRANSITION = new Object();
    public int mState = 0;
    public int mIndex = -1;
    public int mTargetIndex = -1;
    public boolean mUserVisibleHint = true;
    public final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    public final MutableLiveData mViewLifecycleOwnerLiveData = new MutableLiveData();

    public final class AnimationInfo {
        public Animator mAnimator;
        public int mNextAnim;
        public int mNextTransition;
        public int mNextTransitionStyle;
        public Object mReenterTransition;
        public Object mReturnTransition;
        public Object mSharedElementReturnTransition;
        public int mStateAfterAnimating;
    }

    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        String strDecode = C0000.decode(new byte[]{3, 22, 89, 88, 91, 80, 25, 69, 65, 75, 85, 21, 90, 90, 85, 74, 67, 21, 87, 87, 89, 92, 16, 80, 65, 95, 71, 77, 67, 25, 25, 95, 71, 25, 64, 64, 91, 90, 93, 90, 28, 21, 88, 88, 80, 25, 88, 84, 74, 22, 85, 87, 16, 80, 84, 70, 64, 64, 16, 86, 86, 88, 71, 77, 66, 64, 90, 66, 91, 75, 16, 65, 81, 87, 64, 25, 89, 70, 25, 70, 65, 91, 92, 92, 90}, "964905");
        String strDecode2 = C0000.decode(new byte[]{55, 95, 81, 83, 89, 83, 65, 66, 13, 17, 89, 95, 70, 66, 0, 88, 22, 88, 81, 69, 80, 22, 7, 68, 3, 86, 93, 84, 91, 66, 65}, "b10156a6", false);
        try {
            SimpleArrayMap simpleArrayMap = sClassMap;
            Class<?> clsLoadClass = (Class) simpleArrayMap.get(str);
            if (clsLoadClass == null) {
                clsLoadClass = context.getClassLoader().loadClass(str);
                simpleArrayMap.put(str, clsLoadClass);
            }
            Fragment fragment = (Fragment) clsLoadClass.getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (ClassNotFoundException e) {
            throw new StartupException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, str, strDecode), e);
        } catch (IllegalAccessException e2) {
            throw new StartupException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, str, strDecode), e2);
        } catch (InstantiationException e3) {
            throw new StartupException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, str, strDecode), e3);
        } catch (NoSuchMethodException e4) {
            throw new StartupException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, str, C0000.decode(new byte[]{92, 24, 84, 13, 70, 89, 92, 17, 89, 93, 18, 24, 81, 11, 93, 81, 24, 119, 69, 83, 1, 85, 82, 12, 71, 21, 91, 94, 89, 65, 18, 74, 66, 1, 71, 90, 74}, "f87b358172", 7)), e4);
        } catch (InvocationTargetException e5) {
            throw new StartupException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, str, C0000.decode(new byte[]{11, 16, 90, 88, 85, 91, 10, 10, 5, 22, 119, 66, 88, 94, 84, 82, 13, 16, 66, 85, 94, 94, 74, 77, 75, 66, 0, 16, 13, 68, 17, 83, 88, 76, 74, 82, 7, 68, 3, 88, 17, 85, 65, 90, 92, 71, 23, 13, 13, 88}, "109997cdb6", 0.0f)), e5);
        }
    }

    public final AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            AnimationInfo animationInfo = new AnimationInfo();
            Object obj = USE_DEFAULT_TRANSITION;
            animationInfo.mReturnTransition = obj;
            animationInfo.mReenterTransition = obj;
            animationInfo.mSharedElementReturnTransition = obj;
            this.mAnimationInfo = animationInfo;
        }
        return this.mAnimationInfo;
    }

    public final Animator getAnimator() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mAnimator;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final LifecycleRegistry getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if ((hostCallbacks == null ? null : hostCallbacks.mContext) == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{118, 5, 11, 23, 71, 19, 86, 86, 90, 87, 70, 23, 69, 102, 90, 86, 64, 120, 86, 86, 80, 8, 22, 16, 85, 65, 88, 88, 25, 86, 80, 16, 4, 83, 91, 86, 83, 21, 95, 64, 84, 3, 8, 85, 93, 71}, "5de0337592", 7));
        }
        if (this.mViewModelStore == null) {
            this.mViewModelStore = new ViewModelStore();
        }
        return this.mViewModelStore;
    }

    public final void instantiateChildFragmentManager() {
        if (this.mHost == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{116, 64, 87, 85, 85, 85, 86, 18, 20, 11, 2, 16, 25, 91, 92, 66, 18, 80, 83, 87, 86, 16, 89, 18, 64, 2, 0, 11, 92, 81, 19, 79, 87, 70, 24}, "2262808f4ccc9536", 0.0f));
        }
        FragmentManagerImpl fragmentManagerImpl = new FragmentManagerImpl();
        this.mChildFragmentManager = fragmentManagerImpl;
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        FragmentManager fragmentManager = new FragmentManager() { // from class: androidx.fragment.app.Fragment.2
            @Override // androidx.fragment.app.FragmentManager
            public final Fragment instantiate(Context context, String str, Bundle bundle) {
                Fragment.this.mHost.getClass();
                return Fragment.instantiate(context, str, bundle);
            }

            @Override // androidx.fragment.app.FragmentManager
            public final View onFindViewById(int i) {
                throw new IllegalStateException(C0000.decode(new byte[]{39, 75, 0, 80, 14, 1, 12, 21, 23, 0, 14, 92, 18, 23, 13, 11, 22, 65, 95, 5, 23, 92, 65, 86, 67, 18, 11, 4, 64}, "a9a7cdba7d"));
            }

            @Override // androidx.fragment.app.FragmentManager
            public final boolean onHasView() {
                return false;
            }
        };
        if (fragmentManagerImpl.mHost != null) {
            throw new IllegalStateException(C0000.decode(new byte[]{116, 9, 71, 83, 4, 86, 75, 19, 5, 76, 65, 4, 86, 94, 0, 86}, "5e56e223d8", false));
        }
        fragmentManagerImpl.mHost = hostCallbacks;
        fragmentManagerImpl.mContainer = fragmentManager;
        fragmentManagerImpl.mParent = this;
    }

    public abstract void onActivityCreated(Bundle bundle);

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if ((hostCallbacks == null ? null : hostCallbacks.mActivity) != null) {
            this.mCalled = true;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public abstract void onCreate(Bundle bundle);

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        (hostCallbacks == null ? null : hostCallbacks.mActivity).onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public abstract void onDestroyView();

    public abstract void onDetach();

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        if (hostCallbacks == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{10, 12, 38, 3, 64, 124, 87, 65, 10, 23, 21, 47, 90, 86, 90, 89, 17, 7, 19, 78, 29, 16, 85, 89, 11, 12, 14, 18, 20, 82, 83, 24, 0, 26, 4, 5, 65, 68, 83, 92, 69, 23, 15, 18, 93, 92, 22, 76, 13, 7, 65, 32, 70, 81, 81, 85, 0, 12, 21, 70, 93, 67, 22, 89, 17, 22, 0, 5, 92, 85, 82, 24, 17, 13, 65, 18, 92, 85, 22, 126, 23, 3, 6, 11, 81, 94, 66, 117, 4, 12, 0, 1, 81, 66, 24}, "ebaf4068"));
        }
        FragmentActivity fragmentActivity = FragmentActivity.this;
        LayoutInflater layoutInflaterCloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            int i = this.mState;
            if (i >= 4) {
                FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
                fragmentManagerImpl.mStateSaved = false;
                fragmentManagerImpl.mStopped = false;
                fragmentManagerImpl.dispatchStateChange(4);
            } else if (i >= 3) {
                FragmentManagerImpl fragmentManagerImpl2 = this.mChildFragmentManager;
                fragmentManagerImpl2.mStateSaved = false;
                fragmentManagerImpl2.mStopped = false;
                fragmentManagerImpl2.dispatchStateChange(3);
            } else if (i >= 2) {
                FragmentManagerImpl fragmentManagerImpl3 = this.mChildFragmentManager;
                fragmentManagerImpl3.mStateSaved = false;
                fragmentManagerImpl3.mStopped = false;
                fragmentManagerImpl3.dispatchStateChange(2);
            } else if (i >= 1) {
                FragmentManagerImpl fragmentManagerImpl4 = this.mChildFragmentManager;
                fragmentManagerImpl4.mStateSaved = false;
                fragmentManagerImpl4.mStopped = false;
                fragmentManagerImpl4.dispatchStateChange(1);
            }
        }
        FragmentManagerImpl fragmentManagerImpl5 = this.mChildFragmentManager;
        fragmentManagerImpl5.getClass();
        layoutInflaterCloneInContext.setFactory2(fragmentManagerImpl5);
        return layoutInflaterCloneInContext;
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.mCalled = true;
    }

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStart();

    public abstract void onStop();

    public final void performConfigurationChanged() {
        this.mCalled = true;
        FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
        if (fragmentManagerImpl != null) {
            ArrayList arrayList = fragmentManagerImpl.mAdded;
            for (int i = 0; i < arrayList.size(); i++) {
                Fragment fragment = (Fragment) arrayList.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged();
                }
            }
        }
    }

    public final void performLowMemory() {
        this.mCalled = true;
        FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
        if (fragmentManagerImpl != null) {
            ArrayList arrayList = fragmentManagerImpl.mAdded;
            for (int i = 0; i < arrayList.size(); i++) {
                Fragment fragment = (Fragment) arrayList.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }

    public final void performMultiWindowModeChanged() {
        FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
        if (fragmentManagerImpl != null) {
            ArrayList arrayList = fragmentManagerImpl.mAdded;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged();
                }
            }
        }
    }

    public final void performPictureInPictureModeChanged() {
        FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
        if (fragmentManagerImpl != null) {
            ArrayList arrayList = fragmentManagerImpl.mAdded;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null) {
                    fragment.performPictureInPictureModeChanged();
                }
            }
        }
    }

    public final void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable(C0000.decode(new byte[]{7, 90, 85, 22, 10, 13, 5, 88, 64, 65, 22, 69, 95, 22, 76, 91, 0, 70, 80, 3, 8, 1, 15, 22, 64}, "f41dedab34f50d8a"))) == null) {
            return;
        }
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
        }
        this.mChildFragmentManager.restoreAllState(parcelable, this.mChildNonConfig);
        this.mChildNonConfig = null;
        FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.dispatchStateChange(1);
    }

    public final void setArguments(Bundle bundle) {
        FragmentManagerImpl fragmentManagerImpl;
        if (this.mIndex >= 0 && (fragmentManagerImpl = this.mFragmentManager) != null && (fragmentManagerImpl.mStateSaved || fragmentManagerImpl.mStopped)) {
            throw new IllegalStateException(C0000.decode(new byte[]{114, 17, 7, 6, 91, 86, 86, 16, 20, 3, 15, 66, 81, 2, 2, 24, 22, 82, 91, 16, 93, 20, 6, 16, 85, 13, 2, 65, 69, 71, 89, 16, 81, 66, 11, 81, 71, 67, 4, 4, 83, 93, 24, 23, 85, 20, 6, 84}, "4cfa638d4bc0"));
        }
        this.mArguments = bundle;
    }

    public final void setIndex(int i, Fragment fragment) {
        this.mIndex = i;
        if (fragment == null) {
            this.mWho = C0000.decode(new byte[]{85, 90, 87, 19, 12, 8, 85, 95, 95, 70, 85, 83, 94, 4, 13, 21, 11}, "443aca1e94", false) + this.mIndex;
        } else {
            this.mWho = fragment.mWho + C0000.decode(new byte[]{94}, "d22de3e123dd", 3) + this.mIndex;
        }
    }

    public final void setNextAnim(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        ensureAnimationInfo().mNextAnim = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        Trace.buildShortClassTag(this, sb);
        if (this.mIndex >= 0) {
            sb.append(C0000.decode(new byte[]{70, 16}, "f3c330d25719", 0.0f));
            sb.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            sb.append(C0000.decode(new byte[]{24, 93, 6, 89, 3, 79}, "84bd37c418", 0.0f));
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(C0000.decode(new byte[]{17}, "10a751db9641", 5));
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }
}
