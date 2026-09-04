package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.collection.ArraySet;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.LogWriter;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandleSupport$DEFAULT_ARGS_KEY$1;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras$Empty;
import androidx.loader.app.LoaderManagerImpl$LoaderViewModel;
import androidx.tracing.Trace;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.Worker;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
    public static final /* synthetic */ int $r8$clinit = 0;
    public SparseArray mActive;
    public ArrayList mAvailBackStackIndices;
    public ArrayList mBackStack;
    public ArrayList mBackStackIndices;
    public FragmentManager mContainer;
    public ArrayList mCreatedMenus;
    public boolean mDestroyed;
    public boolean mExecutingActions;
    public boolean mHavePendingDeferredStart;
    public FragmentActivity.HostCallbacks mHost;
    public Fragment mParent;
    public ArrayList mPendingActions;
    public Fragment mPrimaryNav;
    public FragmentManagerNonConfig mSavedNonConfig;
    public boolean mStateSaved;
    public boolean mStopped;
    public ArrayList mTmpAddedFragments;
    public ArrayList mTmpIsPop;
    public ArrayList mTmpRecords;
    public int mNextFragmentIndex = 0;
    public final ArrayList mAdded = new ArrayList();
    public final CopyOnWriteArrayList mLifecycleCallbacks = new CopyOnWriteArrayList();
    public int mCurState = 0;
    public Bundle mStateBundle = null;
    public final Worker.AnonymousClass1 mExecCommit = new Worker.AnonymousClass1(2, this);

    public interface OpGenerator {
        boolean generateOps(ArrayList arrayList, ArrayList arrayList2);
    }

    public final class PopBackStackState implements OpGenerator {
        public final int mId;

        public PopBackStackState(int i) {
            this.mId = i;
        }

        @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
        public final boolean generateOps(ArrayList arrayList, ArrayList arrayList2) {
            FragmentManagerImpl fragmentManagerImpl;
            FragmentManagerImpl fragmentManagerImpl2 = FragmentManagerImpl.this;
            Fragment fragment = fragmentManagerImpl2.mPrimaryNav;
            int i = this.mId;
            if (fragment == null || i >= 0 || (fragmentManagerImpl = fragment.mChildFragmentManager) == null || !fragmentManagerImpl.popBackStackImmediate()) {
                return fragmentManagerImpl2.popBackStackState(arrayList, arrayList2, i, 1);
            }
            return false;
        }
    }

    public abstract class StartEnterTransitionListener {
        public abstract void completeTransaction();
    }

    static {
        new DecelerateInterpolator(2.5f);
        new DecelerateInterpolator(1.5f);
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    public static void setRetaining(FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (fragmentManagerNonConfig == null) {
            return;
        }
        List list = fragmentManagerNonConfig.mFragments;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Fragment) it.next()).mRetaining = true;
            }
        }
        List list2 = fragmentManagerNonConfig.mChildNonConfigs;
        if (list2 != null) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                setRetaining((FragmentManagerNonConfig) it2.next());
            }
        }
    }

    public final void addFragment(Fragment fragment, boolean z) {
        makeActive(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (this.mAdded.contains(fragment)) {
            throw new IllegalStateException(C0000.decode(new byte[]{113, 17, 89, 5, 12, 0, 93, 64, 65, 5, 13, 71, 82, 2, 92, 27, 65, 4, 87, 80, 4, 0, 91, 21}, "7c8bae34ada5", 6) + fragment);
        }
        synchronized (this.mAdded) {
            this.mAdded.add(fragment);
        }
        fragment.mAdded = true;
        fragment.mRemoving = false;
        fragment.mHiddenChanged = false;
        if (z) {
            moveToState(fragment, this.mCurState, 0, 0, false);
        }
    }

    public final void attachFragment(Fragment fragment) {
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (this.mAdded.contains(fragment)) {
                throw new IllegalStateException(C0000.decode(new byte[]{116, 64, 86, 80, 92, 82, 88, 65, 22, 84, 93, 23, 87, 83, 83, 78, 17, 86, 82, 81, 83, 81, 11, 69}, "22771765651e") + fragment);
            }
            synchronized (this.mAdded) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
        }
    }

    public final void burpActive() {
        SparseArray sparseArray = this.mActive;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.mActive.valueAt(size) == null) {
                    SparseArray sparseArray2 = this.mActive;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    public final void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public final void completeExecute(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        FragmentManagerImpl fragmentManagerImpl;
        if (z) {
            backStackRecord.executePopOps(z3);
        } else {
            backStackRecord.executeOps();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            fragmentManagerImpl = this;
            FragmentTransition.startTransitions(fragmentManagerImpl, arrayList, arrayList2, 0, 1, true);
        } else {
            fragmentManagerImpl = this;
        }
        if (z3) {
            moveToState(fragmentManagerImpl.mCurState, true);
        }
        SparseArray sparseArray = fragmentManagerImpl.mActive;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
            }
        }
    }

    public final void detachFragment(Fragment fragment) {
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            synchronized (this.mAdded) {
                this.mAdded.remove(fragment);
            }
            fragment.mAdded = false;
        }
    }

    public final boolean dispatchContextItemSelected() {
        FragmentManagerImpl fragmentManagerImpl;
        if (this.mCurState >= 1) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.mAdded;
                if (i >= arrayList.size()) {
                    break;
                }
                Fragment fragment = (Fragment) arrayList.get(i);
                if (fragment != null) {
                    if ((fragment.mHidden || (fragmentManagerImpl = fragment.mChildFragmentManager) == null || !fragmentManagerImpl.dispatchContextItemSelected()) ? false : true) {
                        return true;
                    }
                }
                i++;
            }
        }
        return false;
    }

    public final boolean dispatchCreateOptionsMenu() {
        FragmentManagerImpl fragmentManagerImpl;
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList arrayList = null;
        int i = 0;
        boolean z = false;
        while (true) {
            ArrayList arrayList2 = this.mAdded;
            if (i >= arrayList2.size()) {
                break;
            }
            Fragment fragment = (Fragment) arrayList2.get(i);
            if (fragment != null) {
                if ((fragment.mHidden || (fragmentManagerImpl = fragment.mChildFragmentManager) == null) ? false : fragmentManagerImpl.dispatchCreateOptionsMenu()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(fragment);
                    z = true;
                }
            }
            i++;
        }
        if (this.mCreatedMenus != null) {
            for (int i2 = 0; i2 < this.mCreatedMenus.size(); i2++) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.getClass();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final void dispatchDestroy() {
        this.mDestroyed = true;
        execPendingActions();
        dispatchStateChange(0);
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }

    public final void dispatchOnFragmentActivityCreated(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentActivityCreated(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentAttached(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentAttached(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentCreated(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentCreated(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentDestroyed(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentDestroyed(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentDetached(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentDetached(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentPaused(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentPaused(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentPreAttached(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentPreAttached(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentPreCreated(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentPreCreated(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentResumed(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentResumed(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentSaveInstanceState(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentSaveInstanceState(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentStarted(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentStarted(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentStopped(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentStopped(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final void dispatchOnFragmentViewDestroyed(boolean z) {
        FragmentManagerImpl fragmentManagerImpl;
        Fragment fragment = this.mParent;
        if (fragment != null && (fragmentManagerImpl = fragment.mFragmentManager) != null) {
            fragmentManagerImpl.dispatchOnFragmentViewDestroyed(true);
        }
        Iterator it = this.mLifecycleCallbacks.iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z) {
                throw null;
            }
            throw null;
        }
    }

    public final boolean dispatchOptionsItemSelected() {
        FragmentManagerImpl fragmentManagerImpl;
        if (this.mCurState >= 1) {
            int i = 0;
            while (true) {
                ArrayList arrayList = this.mAdded;
                if (i >= arrayList.size()) {
                    break;
                }
                Fragment fragment = (Fragment) arrayList.get(i);
                if (fragment != null) {
                    if ((fragment.mHidden || (fragmentManagerImpl = fragment.mChildFragmentManager) == null || !fragmentManagerImpl.dispatchOptionsItemSelected()) ? false : true) {
                        return true;
                    }
                }
                i++;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed() {
        FragmentManagerImpl fragmentManagerImpl;
        if (this.mCurState < 1) {
            return;
        }
        int i = 0;
        while (true) {
            ArrayList arrayList = this.mAdded;
            if (i >= arrayList.size()) {
                return;
            }
            Fragment fragment = (Fragment) arrayList.get(i);
            if (fragment != null && !fragment.mHidden && (fragmentManagerImpl = fragment.mChildFragmentManager) != null) {
                fragmentManagerImpl.dispatchOptionsMenuClosed();
            }
            i++;
        }
    }

    public final boolean dispatchPrepareOptionsMenu() {
        FragmentManagerImpl fragmentManagerImpl;
        int i = 0;
        if (this.mCurState < 1) {
            return false;
        }
        boolean z = false;
        while (true) {
            ArrayList arrayList = this.mAdded;
            if (i >= arrayList.size()) {
                return z;
            }
            Fragment fragment = (Fragment) arrayList.get(i);
            if (fragment != null) {
                if ((fragment.mHidden || (fragmentManagerImpl = fragment.mChildFragmentManager) == null) ? false : fragmentManagerImpl.dispatchPrepareOptionsMenu()) {
                    z = true;
                }
            }
            i++;
        }
    }

    public final void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            moveToState(i, false);
            this.mExecutingActions = false;
            execPendingActions();
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x02ab  */
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        String str2;
        int size4;
        int size5;
        LoaderManagerImpl$LoaderViewModel loaderManagerImpl$LoaderViewModel;
        String str3 = str + "    ";
        SparseArray sparseArray = this.mActive;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.getClass();
                    printWriter.print(str3);
                    printWriter.print("mFragmentId=#");
                    printWriter.print(Integer.toHexString(fragment.mFragmentId));
                    printWriter.print(" mContainerId=#");
                    printWriter.print(Integer.toHexString(fragment.mContainerId));
                    printWriter.print(" mTag=");
                    printWriter.println(fragment.mTag);
                    printWriter.print(str3);
                    printWriter.print("mState=");
                    printWriter.print(fragment.mState);
                    printWriter.print(" mIndex=");
                    printWriter.print(fragment.mIndex);
                    printWriter.print(" mWho=");
                    printWriter.print(fragment.mWho);
                    printWriter.print(" mBackStackNesting=");
                    printWriter.println(fragment.mBackStackNesting);
                    printWriter.print(str3);
                    printWriter.print("mAdded=");
                    printWriter.print(fragment.mAdded);
                    printWriter.print(" mRemoving=");
                    printWriter.print(fragment.mRemoving);
                    printWriter.print(" mFromLayout=");
                    printWriter.print(fragment.mFromLayout);
                    printWriter.print(" mInLayout=");
                    printWriter.println(fragment.mInLayout);
                    printWriter.print(str3);
                    printWriter.print("mHidden=");
                    printWriter.print(fragment.mHidden);
                    printWriter.print(" mDetached=");
                    printWriter.print(fragment.mDetached);
                    printWriter.print(" mMenuVisible=");
                    printWriter.print(true);
                    printWriter.print(" mHasMenu=");
                    printWriter.println(false);
                    printWriter.print(str3);
                    printWriter.print("mRetainInstance=");
                    printWriter.print(fragment.mRetainInstance);
                    printWriter.print(" mRetaining=");
                    printWriter.print(fragment.mRetaining);
                    printWriter.print(" mUserVisibleHint=");
                    printWriter.println(fragment.mUserVisibleHint);
                    if (fragment.mFragmentManager != null) {
                        printWriter.print(str3);
                        printWriter.print("mFragmentManager=");
                        printWriter.println(fragment.mFragmentManager);
                    }
                    if (fragment.mHost != null) {
                        printWriter.print(str3);
                        printWriter.print("mHost=");
                        printWriter.println(fragment.mHost);
                    }
                    if (fragment.mParentFragment != null) {
                        printWriter.print(str3);
                        printWriter.print("mParentFragment=");
                        printWriter.println(fragment.mParentFragment);
                    }
                    if (fragment.mArguments != null) {
                        printWriter.print(str3);
                        printWriter.print("mArguments=");
                        printWriter.println(fragment.mArguments);
                    }
                    if (fragment.mSavedFragmentState != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedFragmentState=");
                        printWriter.println(fragment.mSavedFragmentState);
                    }
                    if (fragment.mSavedViewState != null) {
                        printWriter.print(str3);
                        printWriter.print("mSavedViewState=");
                        printWriter.println(fragment.mSavedViewState);
                    }
                    if (fragment.mTarget != null) {
                        printWriter.print(str3);
                        printWriter.print("mTarget=");
                        printWriter.print(fragment.mTarget);
                        printWriter.print(" mTargetRequestCode=");
                        printWriter.println(fragment.mTargetRequestCode);
                    }
                    Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
                    if ((animationInfo == null ? 0 : animationInfo.mNextAnim) != 0) {
                        printWriter.print(str3);
                        printWriter.print("mNextAnim=");
                        Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
                        printWriter.println(animationInfo2 == null ? 0 : animationInfo2.mNextAnim);
                    }
                    if (fragment.mContainer != null) {
                        printWriter.print(str3);
                        printWriter.print("mContainer=");
                        printWriter.println(fragment.mContainer);
                    }
                    FragmentActivity.HostCallbacks hostCallbacks = fragment.mHost;
                    if ((hostCallbacks == null ? null : hostCallbacks.mContext) != null) {
                        ViewModelStore viewModelStore = fragment.getViewModelStore();
                        CreationExtras$Empty creationExtras$Empty = CreationExtras$Empty.INSTANCE;
                        String canonicalName = LoaderManagerImpl$LoaderViewModel.class.getCanonicalName();
                        if (canonicalName == null) {
                            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                        }
                        String strConcat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
                        ViewModel viewModel = (ViewModel) viewModelStore.map.get(strConcat);
                        if (!LoaderManagerImpl$LoaderViewModel.class.isInstance(viewModel)) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.putAll((LinkedHashMap) creationExtras$Empty.mBuilder);
                            linkedHashMap.put(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE$1, strConcat);
                            try {
                                loaderManagerImpl$LoaderViewModel = new LoaderManagerImpl$LoaderViewModel();
                            } catch (AbstractMethodError unused) {
                                loaderManagerImpl$LoaderViewModel = new LoaderManagerImpl$LoaderViewModel();
                            }
                            viewModel = loaderManagerImpl$LoaderViewModel;
                            ViewModel viewModel2 = (ViewModel) viewModelStore.map.put(strConcat, viewModel);
                            if (viewModel2 != null) {
                                viewModel2.onCleared();
                            }
                        }
                        SparseArrayCompat sparseArrayCompat = ((LoaderManagerImpl$LoaderViewModel) viewModel).mLoaders;
                        if (sparseArrayCompat.size() > 0) {
                            printWriter.print(str3);
                            printWriter.println("Loaders:");
                            if (sparseArrayCompat.size() > 0) {
                                if (sparseArrayCompat.valueAt(0) != null) {
                                    throw new ClassCastException();
                                }
                                printWriter.print(str3);
                                printWriter.print("  #");
                                if (sparseArrayCompat.mGarbage) {
                                    sparseArrayCompat.gc();
                                }
                                printWriter.print(sparseArrayCompat.mKeys[0]);
                                printWriter.print(": ");
                                throw null;
                            }
                        }
                    }
                    if (fragment.mChildFragmentManager != null) {
                        printWriter.print(str3);
                        printWriter.println("Child " + fragment.mChildFragmentManager + ":");
                        fragment.mChildFragmentManager.dump(str3 + "  ", fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        int size6 = this.mAdded.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                Fragment fragment2 = (Fragment) this.mAdded.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList = this.mCreatedMenus;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment3 = (Fragment) this.mCreatedMenus.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList2 = this.mBackStack;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                ArrayList arrayList3 = backStackRecord.mOps;
                printWriter.print(str3);
                printWriter.print("mName=");
                printWriter.print(backStackRecord.mName);
                printWriter.print(" mIndex=");
                printWriter.print(backStackRecord.mIndex);
                printWriter.print(" mCommitted=");
                printWriter.println(backStackRecord.mCommitted);
                if (backStackRecord.mTransition != 0) {
                    printWriter.print(str3);
                    printWriter.print("mTransition=#");
                    printWriter.print(Integer.toHexString(backStackRecord.mTransition));
                    printWriter.print(" mTransitionStyle=#");
                    printWriter.println(Integer.toHexString(backStackRecord.mTransitionStyle));
                }
                if (backStackRecord.mEnterAnim != 0 || backStackRecord.mExitAnim != 0) {
                    printWriter.print(str3);
                    printWriter.print("mEnterAnim=#");
                    printWriter.print(Integer.toHexString(backStackRecord.mEnterAnim));
                    printWriter.print(" mExitAnim=#");
                    printWriter.println(Integer.toHexString(backStackRecord.mExitAnim));
                }
                if (backStackRecord.mPopEnterAnim != 0 || backStackRecord.mPopExitAnim != 0) {
                    printWriter.print(str3);
                    printWriter.print("mPopEnterAnim=#");
                    printWriter.print(Integer.toHexString(backStackRecord.mPopEnterAnim));
                    printWriter.print(" mPopExitAnim=#");
                    printWriter.println(Integer.toHexString(backStackRecord.mPopExitAnim));
                }
                if (backStackRecord.mBreadCrumbTitleRes != 0 || backStackRecord.mBreadCrumbTitleText != null) {
                    printWriter.print(str3);
                    printWriter.print("mBreadCrumbTitleRes=#");
                    printWriter.print(Integer.toHexString(backStackRecord.mBreadCrumbTitleRes));
                    printWriter.print(" mBreadCrumbTitleText=");
                    printWriter.println(backStackRecord.mBreadCrumbTitleText);
                }
                if (backStackRecord.mBreadCrumbShortTitleRes != 0 || backStackRecord.mBreadCrumbShortTitleText != null) {
                    printWriter.print(str3);
                    printWriter.print("mBreadCrumbShortTitleRes=#");
                    printWriter.print(Integer.toHexString(backStackRecord.mBreadCrumbShortTitleRes));
                    printWriter.print(" mBreadCrumbShortTitleText=");
                    printWriter.println(backStackRecord.mBreadCrumbShortTitleText);
                }
                if (!arrayList3.isEmpty()) {
                    printWriter.print(str3);
                    printWriter.println("Operations:");
                    int size7 = arrayList3.size();
                    for (int i5 = 0; i5 < size7; i5++) {
                        BackStackRecord.Op op = (BackStackRecord.Op) arrayList3.get(i5);
                        switch (op.cmd) {
                            case 0:
                                str2 = "NULL";
                                break;
                            case 1:
                                str2 = "ADD";
                                break;
                            case 2:
                                str2 = "REPLACE";
                                break;
                            case 3:
                                str2 = "REMOVE";
                                break;
                            case 4:
                                str2 = "HIDE";
                                break;
                            case 5:
                                str2 = "SHOW";
                                break;
                            case 6:
                                str2 = "DETACH";
                                break;
                            case 7:
                                str2 = "ATTACH";
                                break;
                            case 8:
                                str2 = "SET_PRIMARY_NAV";
                                break;
                            case 9:
                                str2 = "UNSET_PRIMARY_NAV";
                                break;
                            default:
                                str2 = "cmd=" + op.cmd;
                                break;
                        }
                        printWriter.print(str3);
                        printWriter.print("  Op #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.print(str2);
                        printWriter.print(" ");
                        printWriter.println(op.fragment);
                        if (op.enterAnim != 0 || op.exitAnim != 0) {
                            printWriter.print(str3);
                            printWriter.print("enterAnim=#");
                            printWriter.print(Integer.toHexString(op.enterAnim));
                            printWriter.print(" exitAnim=#");
                            printWriter.println(Integer.toHexString(op.exitAnim));
                        }
                        if (op.popEnterAnim != 0 || op.popExitAnim != 0) {
                            printWriter.print(str3);
                            printWriter.print("popEnterAnim=#");
                            printWriter.print(Integer.toHexString(op.popEnterAnim));
                            printWriter.print(" popExitAnim=#");
                            printWriter.println(Integer.toHexString(op.popExitAnim));
                        }
                    }
                }
            }
        }
        synchronized (this) {
            try {
                ArrayList arrayList4 = this.mBackStackIndices;
                if (arrayList4 != null && (size2 = arrayList4.size()) > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i6 = 0; i6 < size2; i6++) {
                        Object obj = (BackStackRecord) this.mBackStackIndices.get(i6);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i6);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
                ArrayList arrayList5 = this.mAvailBackStackIndices;
                if (arrayList5 != null && arrayList5.size() > 0) {
                    printWriter.print(str);
                    printWriter.print("mAvailBackStackIndices: ");
                    printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayList6 = this.mPendingActions;
        if (arrayList6 != null && (size = arrayList6.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i7 = 0; i7 < size; i7++) {
                Object obj2 = (OpGenerator) this.mPendingActions.get(i7);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x004d  */
    public final void enqueueAction(OpGenerator opGenerator, boolean z) {
        boolean z2;
        if (!z && (this.mStateSaved || this.mStopped)) {
            throw new IllegalStateException(C0000.decode(new byte[]{39, 85, 8, 16, 91, 9, 23, 65, 20, 85, 75, 7, 11, 70, 11, 16, 65, 14, 10, 18, 68, 81, 90, 21, 13, 91, 8, 16, 84, 0, 23, 4, 22, 16, 86, 15, 55, 85, 16, 85, 124, 8, 16, 21, 5, 94, 90, 4, 55, 64, 7, 68, 80}, "d4f05fcad09a"));
        }
        synchronized (this) {
            try {
                if (!this.mDestroyed && this.mHost != null) {
                    if (this.mPendingActions == null) {
                        this.mPendingActions = new ArrayList();
                    }
                    this.mPendingActions.add(opGenerator);
                    synchronized (this) {
                        try {
                            ArrayList arrayList = this.mPendingActions;
                            if (arrayList != null) {
                                z2 = true;
                                if (arrayList.size() != 1) {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                removeCallbacks(this.mExecCommit);
                                post(this.mExecCommit);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                }
                if (!z) {
                    throw new IllegalStateException(C0000.decode(new byte[]{114, 82, 69, 91, 69, 8, 18, 65, 20, 95, 86, 16, 22, 3, 86, 84, 95, 18, 87, 4, 21, 76, 70, 88, 78, 6, 82}, "31123af8477c6a", 0.0f));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void ensureExecReady() {
        if (this.mExecutingActions) {
            throw new IllegalStateException(C0000.decode(new byte[]{112, 19, 80, 6, 93, 93, 88, 21, 124, 0, 94, 89, 81, 4, 67, 65, 89, 75, 22, 0, 93, 19, 85, 89, 82, 24, 17, 4, 72, 93, 85, 20, 69, 8, 94, 95, 22, 21, 67, 0, 94, 75, 87, 2, 69, 8, 95, 86, 69}, "6a1a08", 7));
        }
        if (this.mHost == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{39, 17, 2, 1, 94, 81, 88, 65, 20, 94, 92, 21, 64, 65, 81, 2, 18, 67, 1, 3, 86, 90, 22, 81, 81, 69, 71, 20, 91, 24, 92, 7}, "accf3465463f4a9c"));
        }
        if (Looper.myLooper() != getLooper()) {
            throw new IllegalStateException(C0000.decode(new byte[]{117, 66, 68, 64, 21, 1, 80, 19, 5, 87, 94, 92, 4, 5, 70, 0, 74, 88, 90, 20, 88, 2, 92, 93, 70, 66, 90, 66, 4, 0, 2, 70, 87, 81, 23, 82, 71, 2, 82, 94, 3, 88, 70, 16, 9, 14, 21, 18}, "87745c53f620aaff", 7));
        }
        if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList();
            this.mTmpIsPop = new ArrayList();
        }
        this.mExecutingActions = true;
        try {
            executePostponedTransaction(null, null);
        } finally {
            this.mExecutingActions = false;
        }
    }

    public final boolean execPendingActions() {
        boolean zGenerateOps;
        ensureExecReady();
        boolean z = false;
        while (true) {
            ArrayList arrayList = this.mTmpRecords;
            ArrayList arrayList2 = this.mTmpIsPop;
            synchronized (this) {
                try {
                    ArrayList arrayList3 = this.mPendingActions;
                    if (arrayList3 == null || arrayList3.size() == 0) {
                        zGenerateOps = false;
                    } else {
                        int size = this.mPendingActions.size();
                        zGenerateOps = false;
                        for (int i = 0; i < size; i++) {
                            zGenerateOps |= ((OpGenerator) this.mPendingActions.get(i)).generateOps(arrayList, arrayList2);
                        }
                        this.mPendingActions.clear();
                        removeCallbacks(this.mExecCommit);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!zGenerateOps) {
                break;
            }
            z = true;
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th2) {
                cleanupExec();
                throw th2;
            }
        }
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
        burpActive();
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x0146  */
    public final void executeOpsTogether(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        FragmentManagerImpl fragmentManagerImpl;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int i3;
        Object obj;
        int i4;
        boolean z;
        boolean z2;
        int i5;
        FragmentManagerImpl fragmentManagerImpl2 = this;
        ArrayList arrayList7 = arrayList;
        boolean z3 = ((BackStackRecord) arrayList7.get(i)).mReorderingAllowed;
        ArrayList arrayList8 = fragmentManagerImpl2.mTmpAddedFragments;
        if (arrayList8 == null) {
            fragmentManagerImpl2.mTmpAddedFragments = new ArrayList();
        } else {
            arrayList8.clear();
        }
        fragmentManagerImpl2.mTmpAddedFragments.addAll(fragmentManagerImpl2.mAdded);
        Fragment fragment = fragmentManagerImpl2.mPrimaryNav;
        int i6 = i;
        boolean z4 = false;
        while (true) {
            int i7 = 1;
            if (i6 >= i2) {
                boolean z5 = z3;
                Object obj2 = null;
                fragmentManagerImpl2.mTmpAddedFragments.clear();
                if (z5) {
                    arrayList3 = arrayList;
                    arrayList4 = arrayList2;
                } else {
                    FragmentTransition.startTransitions(fragmentManagerImpl2, arrayList, arrayList2, i, i2, false);
                    arrayList3 = arrayList;
                    arrayList4 = arrayList2;
                }
                int i8 = i;
                while (i8 < i2) {
                    BackStackRecord backStackRecord = (BackStackRecord) arrayList3.get(i8);
                    if (((Boolean) arrayList4.get(i8)).booleanValue()) {
                        backStackRecord.bumpBackStackNesting(-1);
                        backStackRecord.executePopOps(i8 == i2 + (-1));
                    } else {
                        backStackRecord.bumpBackStackNesting(1);
                        backStackRecord.executeOps();
                    }
                    i8++;
                }
                if (z5) {
                    ArraySet arraySet = new ArraySet(0);
                    ArrayList arrayList9 = fragmentManagerImpl2.mAdded;
                    int i9 = fragmentManagerImpl2.mCurState;
                    if (i9 >= 1) {
                        int iMin = Math.min(i9, 3);
                        int size = arrayList9.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Fragment fragment2 = (Fragment) arrayList9.get(i10);
                            if (fragment2.mState < iMin) {
                                Fragment.AnimationInfo animationInfo = fragment2.mAnimationInfo;
                                fragmentManagerImpl2.moveToState(fragment2, iMin, animationInfo == null ? 0 : animationInfo.mNextAnim, animationInfo == null ? 0 : animationInfo.mNextTransition, false);
                            }
                            i10++;
                            fragmentManagerImpl2 = this;
                        }
                    }
                    for (int i11 = i2 - 1; i11 >= i; i11--) {
                        BackStackRecord backStackRecord2 = (BackStackRecord) arrayList3.get(i11);
                        ((Boolean) arrayList4.get(i11)).getClass();
                        ArrayList arrayList10 = backStackRecord2.mOps;
                        for (int i12 = 0; i12 < arrayList10.size(); i12++) {
                            Fragment fragment3 = ((BackStackRecord.Op) arrayList10.get(i12)).fragment;
                        }
                    }
                    int i13 = arraySet.mSize;
                    for (int i14 = 0; i14 < i13; i14++) {
                        if (!((Fragment) arraySet.mArray[i14]).mAdded) {
                            throw null;
                        }
                    }
                }
                if (i2 == i || !z5) {
                    fragmentManagerImpl = this;
                    arrayList5 = arrayList3;
                    arrayList6 = arrayList4;
                    i3 = i2;
                } else {
                    fragmentManagerImpl = this;
                    arrayList5 = arrayList3;
                    arrayList6 = arrayList4;
                    i3 = i2;
                    FragmentTransition.startTransitions(fragmentManagerImpl, arrayList5, arrayList6, i, i3, true);
                    fragmentManagerImpl.moveToState(fragmentManagerImpl.mCurState, true);
                }
                int i15 = i;
                while (i15 < i3) {
                    BackStackRecord backStackRecord3 = (BackStackRecord) arrayList5.get(i15);
                    if (!((Boolean) arrayList6.get(i15)).booleanValue() || (i4 = backStackRecord3.mIndex) < 0) {
                        obj = obj2;
                    } else {
                        synchronized (this) {
                            try {
                                obj = obj2;
                                fragmentManagerImpl.mBackStackIndices.set(i4, obj);
                                if (fragmentManagerImpl.mAvailBackStackIndices == null) {
                                    fragmentManagerImpl.mAvailBackStackIndices = new ArrayList();
                                }
                                fragmentManagerImpl.mAvailBackStackIndices.add(Integer.valueOf(i4));
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        backStackRecord3.mIndex = -1;
                    }
                    backStackRecord3.getClass();
                    i15++;
                    obj2 = obj;
                }
                return;
            }
            BackStackRecord backStackRecord4 = (BackStackRecord) arrayList7.get(i6);
            if (((Boolean) arrayList2.get(i6)).booleanValue()) {
                z = z3;
                int i16 = 1;
                ArrayList arrayList11 = fragmentManagerImpl2.mTmpAddedFragments;
                ArrayList arrayList12 = backStackRecord4.mOps;
                int i17 = 0;
                while (i17 < arrayList12.size()) {
                    BackStackRecord.Op op = (BackStackRecord.Op) arrayList12.get(i17);
                    int i18 = op.cmd;
                    if (i18 != i16) {
                        if (i18 != 3) {
                            switch (i18) {
                                case 6:
                                    arrayList11.add(op.fragment);
                                    break;
                                case 8:
                                    fragment = null;
                                    break;
                                case 9:
                                    fragment = op.fragment;
                                    break;
                            }
                        } else {
                            arrayList11.add(op.fragment);
                        }
                        i17++;
                        i16 = 1;
                    }
                    arrayList11.remove(op.fragment);
                    i17++;
                    i16 = 1;
                }
            } else {
                ArrayList arrayList13 = fragmentManagerImpl2.mTmpAddedFragments;
                ArrayList arrayList14 = backStackRecord4.mOps;
                int i19 = 0;
                while (i19 < arrayList14.size()) {
                    BackStackRecord.Op op2 = (BackStackRecord.Op) arrayList14.get(i19);
                    int i20 = op2.cmd;
                    if (i20 != i7) {
                        int i21 = i7;
                        z2 = z3;
                        if (i20 == 2) {
                            Fragment fragment4 = op2.fragment;
                            int i22 = fragment4.mContainerId;
                            int size2 = arrayList13.size() - 1;
                            int i23 = 0;
                            while (size2 >= 0) {
                                int i24 = size2;
                                Fragment fragment5 = (Fragment) arrayList13.get(size2);
                                if (fragment5.mContainerId == i22) {
                                    if (fragment5 == fragment4) {
                                        i23 = i21;
                                    } else {
                                        if (fragment5 == fragment) {
                                            arrayList14.add(i19, new BackStackRecord.Op(9, fragment5));
                                            i19++;
                                            fragment = null;
                                        }
                                        BackStackRecord.Op op3 = new BackStackRecord.Op(3, fragment5);
                                        op3.enterAnim = op2.enterAnim;
                                        op3.popEnterAnim = op2.popEnterAnim;
                                        op3.exitAnim = op2.exitAnim;
                                        op3.popExitAnim = op2.popExitAnim;
                                        arrayList14.add(i19, op3);
                                        arrayList13.remove(fragment5);
                                        i19++;
                                    }
                                }
                                size2 = i24 - 1;
                            }
                            if (i23 != 0) {
                                arrayList14.remove(i19);
                                i19--;
                            } else {
                                i5 = i21;
                                op2.cmd = i5;
                                arrayList13.add(fragment4);
                            }
                            i19 += i5;
                            i7 = i5;
                            z3 = z2;
                        } else if (i20 == 3 || i20 == 6) {
                            arrayList13.remove(op2.fragment);
                            Fragment fragment6 = op2.fragment;
                            if (fragment6 == fragment) {
                                arrayList14.add(i19, new BackStackRecord.Op(9, fragment6));
                                i19++;
                                fragment = null;
                            }
                        } else if (i20 == 7) {
                            i5 = i21;
                        } else if (i20 == 8) {
                            arrayList14.add(i19, new BackStackRecord.Op(9, fragment));
                            i19++;
                            fragment = op2.fragment;
                        }
                        i5 = i21;
                        i19 += i5;
                        i7 = i5;
                        z3 = z2;
                    } else {
                        z2 = z3;
                        i5 = i7;
                    }
                    arrayList13.add(op2.fragment);
                    i19 += i5;
                    i7 = i5;
                    z3 = z2;
                }
                z = z3;
            }
            z4 = z4 || backStackRecord4.mAddToBackStack;
            i6++;
            arrayList7 = arrayList;
            z3 = z;
        }
    }

    public final void executePostponedTransaction(ArrayList arrayList, ArrayList arrayList2) {
    }

    public final Fragment findFragmentById(int i) {
        ArrayList arrayList = this.mAdded;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        SparseArray sparseArray = this.mActive;
        if (sparseArray == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            Fragment fragment2 = (Fragment) this.mActive.valueAt(size2);
            if (fragment2 != null && fragment2.mFragmentId == i) {
                return fragment2;
            }
        }
        return null;
    }

    public final Fragment findFragmentByWho(String str) {
        SparseArray sparseArray = this.mActive;
        if (sparseArray == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            Fragment fragmentFindFragmentByWho = (Fragment) this.mActive.valueAt(size);
            if (fragmentFindFragmentByWho != null) {
                if (!str.equals(fragmentFindFragmentByWho.mWho)) {
                    FragmentManagerImpl fragmentManagerImpl = fragmentFindFragmentByWho.mChildFragmentManager;
                    fragmentFindFragmentByWho = fragmentManagerImpl != null ? fragmentManagerImpl.findFragmentByWho(str) : null;
                }
                if (fragmentFindFragmentByWho != null) {
                    return fragmentFindFragmentByWho;
                }
            }
        }
        return null;
    }

    public final void makeActive(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            return;
        }
        int i = this.mNextFragmentIndex;
        this.mNextFragmentIndex = i + 1;
        fragment.setIndex(i, this.mParent);
        if (this.mActive == null) {
            this.mActive = new SparseArray();
        }
        this.mActive.put(fragment.mIndex, fragment);
    }

    public final void moveFragmentToExpectedState(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        int iMin = this.mCurState;
        if (fragment.mRemoving) {
            iMin = fragment.mBackStackNesting > 0 ? Math.min(iMin, 1) : Math.min(iMin, 0);
        }
        int i = iMin;
        Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
        moveToState(fragment, i, animationInfo == null ? 0 : animationInfo.mNextTransition, animationInfo == null ? 0 : animationInfo.mNextTransitionStyle, false);
        if (fragment.mHiddenChanged) {
            fragment.mHiddenChanged = false;
        }
    }

    public final void moveToState(int i, boolean z) {
        if (this.mHost == null && i != 0) {
            throw new IllegalStateException(C0000.decode(new byte[]{120, 10, 69, 2, 87, 16, 15, 64, 81, 23, 74}, "6eec4df68c3e", 0.0f));
        }
        if (z || i != this.mCurState) {
            this.mCurState = i;
            if (this.mActive != null) {
                ArrayList arrayList = this.mAdded;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    moveFragmentToExpectedState((Fragment) arrayList.get(i2));
                }
                int size2 = this.mActive.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Fragment fragment = (Fragment) this.mActive.valueAt(i3);
                    if (fragment != null && (fragment.mRemoving || fragment.mDetached)) {
                        moveFragmentToExpectedState(fragment);
                    }
                }
                startPendingDeferredFragments();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x024e  */
    /* JADX WARN: Code duplicated, block: B:108:0x0287  */
    /* JADX WARN: Code duplicated, block: B:111:0x028e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0292  */
    /* JADX WARN: Code duplicated, block: B:115:0x0296 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x0298  */
    /* JADX WARN: Code duplicated, block: B:122:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:123:0x02ac A[Catch: NotFoundException -> 0x02e4, TryCatch #1 {NotFoundException -> 0x02e4, blocks: (B:120:0x02a6, B:125:0x02b0, B:126:0x02bb, B:127:0x02e3, B:123:0x02ac), top: B:297:0x02a6 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x02b0 A[Catch: NotFoundException -> 0x02e4, TryCatch #1 {NotFoundException -> 0x02e4, blocks: (B:120:0x02a6, B:125:0x02b0, B:126:0x02bb, B:127:0x02e3, B:123:0x02ac), top: B:297:0x02a6 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x02bb A[Catch: NotFoundException -> 0x02e4, TryCatch #1 {NotFoundException -> 0x02e4, blocks: (B:120:0x02a6, B:125:0x02b0, B:126:0x02bb, B:127:0x02e3, B:123:0x02ac), top: B:297:0x02a6 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0363  */
    /* JADX WARN: Code duplicated, block: B:133:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:136:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:140:0x03be  */
    /* JADX WARN: Code duplicated, block: B:143:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:145:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:147:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:150:0x0407  */
    /* JADX WARN: Code duplicated, block: B:152:0x040b  */
    /* JADX WARN: Code duplicated, block: B:155:0x041e  */
    /* JADX WARN: Code duplicated, block: B:157:0x0422  */
    /* JADX WARN: Code duplicated, block: B:159:0x0432  */
    /* JADX WARN: Code duplicated, block: B:162:0x045f  */
    /* JADX WARN: Code duplicated, block: B:164:0x0463  */
    /* JADX WARN: Code duplicated, block: B:167:0x0477  */
    /* JADX WARN: Code duplicated, block: B:169:0x047b  */
    /* JADX WARN: Code duplicated, block: B:171:0x0495  */
    /* JADX WARN: Code duplicated, block: B:238:0x067a  */
    /* JADX WARN: Code duplicated, block: B:245:0x0697  */
    /* JADX WARN: Code duplicated, block: B:246:0x069f  */
    /* JADX WARN: Code duplicated, block: B:248:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:250:0x06ac  */
    /* JADX WARN: Code duplicated, block: B:253:0x06bc  */
    /* JADX WARN: Code duplicated, block: B:254:0x06be  */
    /* JADX WARN: Code duplicated, block: B:259:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:266:0x06d7  */
    /* JADX WARN: Code duplicated, block: B:267:0x06dd  */
    /* JADX WARN: Code duplicated, block: B:269:0x0709  */
    /* JADX WARN: Code duplicated, block: B:272:0x0714  */
    /* JADX WARN: Code duplicated, block: B:274:0x0718  */
    /* JADX WARN: Code duplicated, block: B:276:0x071c  */
    /* JADX WARN: Code duplicated, block: B:277:0x0722  */
    /* JADX WARN: Code duplicated, block: B:281:0x076c  */
    /* JADX WARN: Code duplicated, block: B:283:0x0770  */
    /* JADX WARN: Code duplicated, block: B:286:0x0775  */
    /* JADX WARN: Code duplicated, block: B:287:0x079d  */
    /* JADX WARN: Code duplicated, block: B:288:0x07a4  */
    /* JADX WARN: Code duplicated, block: B:293:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:302:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:87:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:90:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:92:0x0201  */
    /* JADX WARN: Code duplicated, block: B:95:0x0211  */
    /* JADX WARN: Code duplicated, block: B:96:0x021a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0244  */
    /* JADX WARN: Instruction removed from duplicated block: B:100:0x024e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:126:0x02bb, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:131:0x0363, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:147:0x03dd, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:159:0x0432, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:171:0x0495, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:267:0x06dd, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:277:0x0722, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:288:0x07a4, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:96:0x021a, please report this as an issue */
    public final void moveToState(Fragment fragment, int i, int i2, int i3, boolean z) {
        int i4;
        Fragment fragment2;
        FragmentManagerImpl fragmentManagerImpl;
        int i5;
        FragmentManagerImpl fragmentManagerImpl2;
        FragmentActivity.HostCallbacks hostCallbacks;
        FragmentActivity fragmentActivity;
        ViewModelStore viewModelStore;
        LoaderManagerImpl$LoaderViewModel loaderManagerImpl$LoaderViewModel;
        FragmentManagerImpl fragmentManagerImpl3;
        FragmentManagerImpl fragmentManagerImpl4;
        Fragment fragment3;
        FragmentManagerImpl fragmentManagerImpl5;
        FragmentManagerImpl fragmentManagerImpl6;
        int i6;
        ViewGroup viewGroup;
        FragmentManagerImpl fragmentManagerImpl7;
        String strDecode;
        FragmentActivity.HostCallbacks hostCallbacks2;
        FragmentActivity fragmentActivity2;
        FragmentManagerImpl fragmentManagerImpl8;
        FragmentManagerImpl fragmentManagerImpl9;
        FragmentManagerImpl fragmentManagerImpl10;
        FragmentManagerImpl fragmentManagerImpl11;
        FragmentManagerImpl fragmentManagerImpl12;
        int i7;
        boolean z2 = fragment.mAdded;
        LifecycleRegistry lifecycleRegistry = fragment.mLifecycleRegistry;
        int i8 = 1;
        if (!z2 || fragment.mDetached) {
            i4 = i;
            if (i4 > 1) {
                i4 = 1;
            }
        } else {
            i4 = i;
        }
        if (fragment.mRemoving && i4 > (i7 = fragment.mState)) {
            i4 = (i7 != 0 || fragment.mBackStackNesting <= 0) ? i7 : 1;
        }
        int i9 = (!fragment.mDeferStart || fragment.mState >= 3 || i4 <= 2) ? i4 : 2;
        int i10 = fragment.mState;
        String strDecode2 = C0000.decode(new byte[]{34, 68, 85, 80, 12, 83, 86, 70, 68}, "d647a682d69a48", false);
        if (i10 > i9) {
            fragment2 = fragment;
            if (i10 > i9) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 == 4) {
                                if (i9 < 4) {
                                    lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_PAUSE);
                                    FragmentManagerImpl fragmentManagerImpl13 = fragment2.mChildFragmentManager;
                                    if (fragmentManagerImpl13 != null) {
                                        fragmentManagerImpl13.dispatchStateChange(3);
                                    }
                                    fragment2.mState = 3;
                                    fragment2.mCalled = true;
                                    dispatchOnFragmentPaused(false);
                                }
                            }
                        }
                        if (i9 < 3) {
                            lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_STOP);
                            FragmentManagerImpl fragmentManagerImpl14 = fragment2.mChildFragmentManager;
                            if (fragmentManagerImpl14 != null) {
                                fragmentManagerImpl14.mStopped = true;
                                fragmentManagerImpl14.dispatchStateChange(2);
                            }
                            fragment2.mState = 2;
                            fragment2.mCalled = false;
                            fragment2.onStop();
                            if (!fragment2.mCalled) {
                                throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{20, 81, 80, 7, 67, 92, 10, 68, 68, 1, 2, 88, 10, 69, 18, 89, 70, 90, 76, 4, 11, 18, 17, 95, 68, 17, 22, 68, 3, 23, 72, 94, 90, 102, 77, 12, 19, 26, 76}, "459cc2e0dbc4fef1", 1));
                            }
                            dispatchOnFragmentStopped(false);
                        }
                    }
                    if (i9 < 2) {
                        FragmentManagerImpl fragmentManagerImpl15 = fragment2.mChildFragmentManager;
                        if (fragmentManagerImpl15 != null) {
                            fragmentManagerImpl15.dispatchStateChange(1);
                        }
                        fragment2.mState = 1;
                        fragment2.mCalled = false;
                        fragment2.onDestroyView();
                        if (!fragment2.mCalled) {
                            throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{18, 84, 80, 82, 65, 95, 9, 23, 20, 5, 80, 85, 94, 16, 77, 94, 19, 94, 19, 4, 92, 70, 69, 86, 18, 67, 76, 70, 4, 67, 72, 12, 90, 34, 84, 74, 70, 66, 86, 79, 55, 88, 3, 20, 28, 79}, "2096a1fc4f19", 0.0f));
                        }
                        ViewModelStore viewModelStore2 = fragment2.getViewModelStore();
                        CreationExtras$Empty creationExtras$Empty = CreationExtras$Empty.INSTANCE;
                        String canonicalName = LoaderManagerImpl$LoaderViewModel.class.getCanonicalName();
                        if (canonicalName == null) {
                            throw new IllegalArgumentException(C0000.decode(new byte[]{47, 13, 87, 0, 90, 67, 81, 90, 81, 16, 86, 92, 93, 95, 26, 15, 91, 20, 69, 67, 83, 88, 84, 67, 68, 87, 65, 17, 0, 3, 90, 65, 88, 12, 68, 20, 87, 85, 23, 100, 91, 84, 20, 47, 91, 5, 83, 15, 67}, "cb4a6c04507221"));
                        }
                        String strConcat = C0000.decode(new byte[]{89, 90, 5, 70, 13, 11, 85, 64, 24, 14, 81, 82, 4, 87, 27, 1, 93, 93, 24, 52, 81, 81, 22, 121, 13, 6, 84, 84, 102, 16, 87, 66, 8, 80, 7, 16, 31, 124, 83, 4, 89, 65, 13, 64, 41, 7, 72, 2}, "84a4bb186b", 4).concat(canonicalName);
                        ViewModel viewModel = (ViewModel) viewModelStore2.map.get(strConcat);
                        if (!LoaderManagerImpl$LoaderViewModel.class.isInstance(viewModel)) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            linkedHashMap.putAll((LinkedHashMap) creationExtras$Empty.mBuilder);
                            linkedHashMap.put(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE$1, strConcat);
                            try {
                                loaderManagerImpl$LoaderViewModel = new LoaderManagerImpl$LoaderViewModel();
                            } catch (AbstractMethodError unused) {
                                loaderManagerImpl$LoaderViewModel = new LoaderManagerImpl$LoaderViewModel();
                            }
                            viewModel = loaderManagerImpl$LoaderViewModel;
                            ViewModel viewModel2 = (ViewModel) viewModelStore2.map.put(strConcat, viewModel);
                            if (viewModel2 != null) {
                                viewModel2.onCleared();
                            }
                        }
                        SparseArrayCompat sparseArrayCompat = ((LoaderManagerImpl$LoaderViewModel) viewModel).mLoaders;
                        if (sparseArrayCompat.size() > 0) {
                            sparseArrayCompat.valueAt(0).getClass();
                            throw new ClassCastException();
                        }
                        fragment2.mPerformedCreateView = false;
                        dispatchOnFragmentViewDestroyed(false);
                        fragment2.mContainer = null;
                        MutableLiveData mutableLiveData = fragment2.mViewLifecycleOwnerLiveData;
                        mutableLiveData.getClass();
                        ArchTaskExecutor.getInstance().mDelegate.getClass();
                        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                            throw new IllegalStateException(C0000.decode(new byte[]{113, 86, 10, 91, 92, 71, 69, 15, 89, 68, 9, 95, 87, 23, 23, 80, 71, 101, 4, 10, 66, 87, 70, 91, 92, 23, 5, 21, 81, 82, 6, 13, 80, 64, 9, 65, 92, 83, 68, 65, 91, 65, 0, 7, 83}, "27d533ef72f4", 0));
                        }
                        mutableLiveData.mData = null;
                        if (mutableLiveData.mDispatchingValue) {
                            mutableLiveData.mDispatchInvalidated = true;
                        } else {
                            mutableLiveData.mDispatchingValue = true;
                            do {
                                mutableLiveData.mDispatchInvalidated = false;
                                SafeIterableMap safeIterableMap = mutableLiveData.mObservers;
                                safeIterableMap.getClass();
                                SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = safeIterableMap.new IteratorWithAdditions();
                                safeIterableMap.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
                                if (iteratorWithAdditions.hasNext()) {
                                    throw null;
                                }
                            } while (mutableLiveData.mDispatchInvalidated);
                            mutableLiveData.mDispatchingValue = false;
                        }
                        fragment2.mInLayout = false;
                    }
                    if (i9 >= 1) {
                        if (this.mDestroyed) {
                            Animator animator = fragment2.getAnimator();
                            fragment2.ensureAnimationInfo().mAnimator = null;
                            animator.cancel();
                        }
                        if (fragment2.getAnimator() != null) {
                            fragment2.ensureAnimationInfo().mStateAfterAnimating = i9;
                        } else {
                            if (fragment2.mRetaining) {
                                fragment2.mState = 0;
                            } else {
                                lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_DESTROY);
                                fragmentManagerImpl2 = fragment2.mChildFragmentManager;
                                if (fragmentManagerImpl2 != null) {
                                    fragmentManagerImpl2.dispatchDestroy();
                                }
                                fragment2.mState = 0;
                                fragment2.mCalled = false;
                                fragment2.mIsCreated = false;
                                fragment2.mCalled = true;
                                hostCallbacks = fragment2.mHost;
                                if (hostCallbacks == null) {
                                    fragmentActivity = null;
                                } else {
                                    fragmentActivity = hostCallbacks.mActivity;
                                }
                                if (fragmentActivity == null) {
                                }
                                viewModelStore = fragment2.mViewModelStore;
                                if (viewModelStore != null) {
                                    viewModelStore.clear();
                                }
                                if (fragment2.mCalled) {
                                    throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{19, 92, 8, 86, 66, 86, 12, 68, 24, 91, 86, 9, 93, 68, 18, 10, 65, 87, 20, 85, 10, 24, 23, 95, 24, 75, 66, 21, 84, 22, 72, 13, 93, 124, 4, 65, 22, 74, 12, 73, 16, 17}, "38a2b8c0887e1dfb", 6));
                                }
                                fragment2.mChildFragmentManager = null;
                                dispatchOnFragmentDestroyed(false);
                            }
                            fragment2.mCalled = false;
                            fragment2.onDetach();
                            if (fragment2.mCalled) {
                                throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{68, 92, 12, 86, 24, 90, 11, 76, 69, 81, 89, 88, 8, 24, 17, 90, 74, 91, 17, 95, 13, 18, 76, 91, 68, 75, 16, 66, 93, 70, 74, 87, 11, 118, 93, 64, 5, 91, 13, 26, 17}, "d8e284"));
                            }
                            fragmentManagerImpl = fragment2.mChildFragmentManager;
                            if (fragmentManagerImpl != null) {
                                if (fragment2.mRetaining) {
                                    throw new IllegalStateException(C0000.decode(new byte[]{33, 90, 15, 88, 0, 20, 127, 67, 83, 3, 11, 85, 12, 70, 43, 85, 10, 85, 94, 84, 64, 68, 9, 86, 66}, "b2f4d4912df0", 0.0f) + fragment2 + C0000.decode(new byte[]{19, 22, 82, 21, 67, 12, 92, 21, 19, 70, 7, 7, 64, 21, 65, 9, 26, 7, 87, 65, 82, 8, 7, 66, 71, 9, 90, 21, 67, 4, 65, 0, 84, 11, 6, 12, 71, 65, 90, 21, 67, 12, 92, 21, 19, 20, 6, 22, 82, 8, 93, 15, 13, 5, 19, 8, 93, 21, 23, 3, 93, 2, 86}, "3a3fcb", false));
                                }
                                fragmentManagerImpl.dispatchDestroy();
                                fragment2.mChildFragmentManager = null;
                            }
                            dispatchOnFragmentDetached(false);
                            if (!z) {
                                if (fragment2.mRetaining) {
                                    fragment2.mHost = null;
                                    fragment2.mParentFragment = null;
                                    fragment2.mFragmentManager = null;
                                } else {
                                    i5 = fragment2.mIndex;
                                    if (i5 >= 0) {
                                        this.mActive.put(i5, null);
                                        fragment2.mIndex = -1;
                                        fragment2.mWho = null;
                                        fragment2.mAdded = false;
                                        fragment2.mRemoving = false;
                                        fragment2.mFromLayout = false;
                                        fragment2.mInLayout = false;
                                        fragment2.mRestored = false;
                                        fragment2.mBackStackNesting = 0;
                                        fragment2.mFragmentManager = null;
                                        fragment2.mChildFragmentManager = null;
                                        fragment2.mHost = null;
                                        fragment2.mFragmentId = 0;
                                        fragment2.mContainerId = 0;
                                        fragment2.mTag = null;
                                        fragment2.mHidden = false;
                                        fragment2.mDetached = false;
                                        fragment2.mRetaining = false;
                                    }
                                }
                            }
                        }
                    }
                } else if (i9 >= 1) {
                    if (this.mDestroyed && fragment2.getAnimator() != null) {
                        Animator animator2 = fragment2.getAnimator();
                        fragment2.ensureAnimationInfo().mAnimator = null;
                        animator2.cancel();
                    }
                    if (fragment2.getAnimator() != null) {
                        fragment2.ensureAnimationInfo().mStateAfterAnimating = i9;
                    } else {
                        if (fragment2.mRetaining) {
                            lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_DESTROY);
                            fragmentManagerImpl2 = fragment2.mChildFragmentManager;
                            if (fragmentManagerImpl2 != null) {
                                fragmentManagerImpl2.dispatchDestroy();
                            }
                            fragment2.mState = 0;
                            fragment2.mCalled = false;
                            fragment2.mIsCreated = false;
                            fragment2.mCalled = true;
                            hostCallbacks = fragment2.mHost;
                            if (hostCallbacks == null) {
                                fragmentActivity = null;
                            } else {
                                fragmentActivity = hostCallbacks.mActivity;
                            }
                            boolean z3 = fragmentActivity == null && fragmentActivity.isChangingConfigurations();
                            viewModelStore = fragment2.mViewModelStore;
                            if (viewModelStore != null && !z3) {
                                viewModelStore.clear();
                            }
                            if (fragment2.mCalled) {
                                throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{19, 92, 8, 86, 66, 86, 12, 68, 24, 91, 86, 9, 93, 68, 18, 10, 65, 87, 20, 85, 10, 24, 23, 95, 24, 75, 66, 21, 84, 22, 72, 13, 93, 124, 4, 65, 22, 74, 12, 73, 16, 17}, "38a2b8c0887e1dfb", 6));
                            }
                            fragment2.mChildFragmentManager = null;
                            dispatchOnFragmentDestroyed(false);
                        } else {
                            fragment2.mState = 0;
                        }
                        fragment2.mCalled = false;
                        fragment2.onDetach();
                        if (fragment2.mCalled) {
                            throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{68, 92, 12, 86, 24, 90, 11, 76, 69, 81, 89, 88, 8, 24, 17, 90, 74, 91, 17, 95, 13, 18, 76, 91, 68, 75, 16, 66, 93, 70, 74, 87, 11, 118, 93, 64, 5, 91, 13, 26, 17}, "d8e284"));
                        }
                        fragmentManagerImpl = fragment2.mChildFragmentManager;
                        if (fragmentManagerImpl != null) {
                            if (fragment2.mRetaining) {
                                throw new IllegalStateException(C0000.decode(new byte[]{33, 90, 15, 88, 0, 20, 127, 67, 83, 3, 11, 85, 12, 70, 43, 85, 10, 85, 94, 84, 64, 68, 9, 86, 66}, "b2f4d4912df0", 0.0f) + fragment2 + C0000.decode(new byte[]{19, 22, 82, 21, 67, 12, 92, 21, 19, 70, 7, 7, 64, 21, 65, 9, 26, 7, 87, 65, 82, 8, 7, 66, 71, 9, 90, 21, 67, 4, 65, 0, 84, 11, 6, 12, 71, 65, 90, 21, 67, 12, 92, 21, 19, 20, 6, 22, 82, 8, 93, 15, 13, 5, 19, 8, 93, 21, 23, 3, 93, 2, 86}, "3a3fcb", false));
                            }
                            fragmentManagerImpl.dispatchDestroy();
                            fragment2.mChildFragmentManager = null;
                        }
                        dispatchOnFragmentDetached(false);
                        if (!z) {
                            if (fragment2.mRetaining) {
                                i5 = fragment2.mIndex;
                                if (i5 >= 0) {
                                    this.mActive.put(i5, null);
                                    fragment2.mIndex = -1;
                                    fragment2.mWho = null;
                                    fragment2.mAdded = false;
                                    fragment2.mRemoving = false;
                                    fragment2.mFromLayout = false;
                                    fragment2.mInLayout = false;
                                    fragment2.mRestored = false;
                                    fragment2.mBackStackNesting = 0;
                                    fragment2.mFragmentManager = null;
                                    fragment2.mChildFragmentManager = null;
                                    fragment2.mHost = null;
                                    fragment2.mFragmentId = 0;
                                    fragment2.mContainerId = 0;
                                    fragment2.mTag = null;
                                    fragment2.mHidden = false;
                                    fragment2.mDetached = false;
                                    fragment2.mRetaining = false;
                                }
                            } else {
                                fragment2.mHost = null;
                                fragment2.mParentFragment = null;
                                fragment2.mFragmentManager = null;
                            }
                        }
                    }
                }
            }
            if (fragment2.mState != i8) {
                fragment2.toString();
                fragment2.mState = i8;
            }
        }
        if (fragment.mFromLayout && !fragment.mInLayout) {
            return;
        }
        if (fragment.getAnimator() != null) {
            fragment.ensureAnimationInfo().getClass();
            fragment.ensureAnimationInfo().mAnimator = null;
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            int i11 = animationInfo == null ? 0 : animationInfo.mStateAfterAnimating;
            fragmentManagerImpl3 = this;
            fragmentManagerImpl3.moveToState(fragment, i11, 0, 0, true);
        } else {
            fragmentManagerImpl3 = this;
        }
        int i12 = fragment.mState;
        if (i12 == 0) {
            if (i9 > 0) {
                Bundle bundle = fragment.mSavedFragmentState;
                if (bundle != null) {
                    bundle.setClassLoader(fragmentManagerImpl3.mHost.mContext.getClassLoader());
                    fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(C0000.decode(new byte[]{83, 15, 85, 22, 92, 10, 86, 91, 71, 13, 86, 20, 109, 18, 69, 5, 71, 6}, "2a1d3c", 3));
                    int i13 = fragment.mSavedFragmentState.getInt(C0000.decode(new byte[]{7, 93, 0, 67, 92, 88, 1, 91, 18, 86, 66, 86, 4, 66, 108, 65, 18, 82, 16, 84}, "f3d131eaf701a632", true), -1);
                    if (i13 == -1) {
                        fragment3 = null;
                    } else {
                        fragment3 = (Fragment) fragmentManagerImpl3.mActive.get(i13);
                        if (fragment3 == null) {
                            fragmentManagerImpl3.throwException(new IllegalStateException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{119, 20, 86, 83, 95, 4, 95, 18, 23, 90, 93, 65, 93, 9, 89, 83, 87, 19, 17, 3, 79, 93, 65, 21, 66, 70, 81, 91, 64, 65, 90, 3, 78, 20, 83, 15, 85, 20, 88, 93, 86, 91, 69, 7, 69, 83, 87, 21, 110, 21, 67, 85, 70, 4, 11, 70, 94, 90, 86, 4, 73, 70}, "1f742a", 3), i13)));
                            throw null;
                        }
                    }
                    fragment.mTarget = fragment3;
                    if (fragment3 != null) {
                        fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt(C0000.decode(new byte[]{87, 86, 80, 64, 90, 10, 81, 92, 64, 7, 20, 2, 83, 76, 107, 64, 80, 18, 106, 21, 64, 7, 18, 0}, "68425c5f4ffe"), 0);
                    }
                    boolean z4 = fragment.mSavedFragmentState.getBoolean(C0000.decode(new byte[]{88, 88, 83, 64, 90, 93, 81, 89, 23, 71, 3, 69, 104, 23, 80, 69, 94, 80, 89, 81, 106, 11, 11, 90, 18}, "9672545cb4f77a", true), true);
                    fragment.mUserVisibleHint = z4;
                    if (!z4) {
                        fragment.mDeferStart = true;
                        if (i9 > 2) {
                            i9 = 2;
                        }
                    }
                }
                FragmentActivity.HostCallbacks hostCallbacks3 = fragmentManagerImpl3.mHost;
                fragment.mHost = hostCallbacks3;
                Fragment fragment4 = fragmentManagerImpl3.mParent;
                fragment.mParentFragment = fragment4;
                fragment.mFragmentManager = fragment4 != null ? fragment4.mChildFragmentManager : hostCallbacks3.mFragmentManager;
                Fragment fragment5 = fragment.mTarget;
                if (fragment5 != null) {
                    Object obj = fragmentManagerImpl3.mActive.get(fragment5.mIndex);
                    Fragment fragment6 = fragment.mTarget;
                    if (obj != fragment6) {
                        throw new IllegalStateException(strDecode2 + fragment + C0000.decode(new byte[]{19, 7, 0, 81, 90, 89, 22, 0, 0, 67, 69, 81, 64, 1, 3, 22, 19, 5, 23, 83, 81, 85, 1, 11, 16, 67}, "3ce268dedc102ffb") + fragment.mTarget + C0000.decode(new byte[]{22, 65, 80, 82, 21, 18, 1, 89, 3, 22, 20, 89, 89, 65, 24, 81, 4, 94, 10, 88, 1, 69, 64, 88, 22, 65, 80, 90, 18, 18, 35, 68, 7, 2, 89, 82, 88, 65, 117, 82, 15, 83, 2, 83, 20, 68}, "6583a2e6fe47"));
                    }
                    if (fragment6.mState < 1) {
                        fragment2 = fragment;
                        fragmentManagerImpl3.moveToState(fragment6, 1, 0, 0, true);
                    } else {
                        fragment2 = fragment;
                    }
                    FragmentActivity fragmentActivity3 = fragmentManagerImpl3.mHost.mContext;
                    fragmentManagerImpl3.dispatchOnFragmentPreAttached(false);
                    fragment2.mCalled = false;
                    fragment2.onAttach(fragmentManagerImpl3.mHost.mContext);
                    if (fragment2.mCalled) {
                        throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{24, 85, 81, 86, 68, 90, 14, 17, 65, 81, 3, 8, 13, 67, 76, 89, 74, 93, 17, 83, 9, 69, 21, 93, 66, 23, 20, 19, 93, 67, 22, 93, 10, 117, 21, 17, 0, 81, 10, 76, 72}, "8182d4aea2bdac", 6));
                    }
                    if (fragment2.mParentFragment == null) {
                        FragmentActivity fragmentActivity4 = FragmentActivity.this;
                    }
                    FragmentActivity fragmentActivity5 = fragmentManagerImpl3.mHost.mContext;
                    fragmentManagerImpl3.dispatchOnFragmentAttached(false);
                    if (fragment2.mIsCreated) {
                        fragment2.restoreChildFragmentState(fragment2.mSavedFragmentState);
                        fragment2.mState = 1;
                    } else {
                        fragmentManagerImpl3.dispatchOnFragmentPreCreated(false);
                        Bundle bundle2 = fragment2.mSavedFragmentState;
                        fragmentManagerImpl4 = fragment2.mChildFragmentManager;
                        if (fragmentManagerImpl4 != null) {
                            fragmentManagerImpl4.noteStateNotSaved();
                        }
                        fragment2.mState = 1;
                        fragment2.mCalled = false;
                        fragment2.onCreate(bundle2);
                        fragment2.mIsCreated = true;
                        if (fragment2.mCalled) {
                            throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{22, 2, 92, 2, 17, 92, 14, 18, 16, 82, 82, 90, 89, 68, 23, 88, 68, 9, 64, 1, 89, 18, 21, 9, 16, 66, 70, 70, 80, 22, 77, 95, 88, 37, 71, 3, 80, 70, 4, 78, 25}, "6f5f12af01365dc0"));
                        }
                        lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_CREATE);
                        fragmentManagerImpl3.dispatchOnFragmentCreated(false);
                    }
                    fragment2.mRetaining = false;
                } else {
                    fragment2 = fragment;
                }
                FragmentActivity fragmentActivity6 = fragmentManagerImpl3.mHost.mContext;
                fragmentManagerImpl3.dispatchOnFragmentPreAttached(false);
                fragment2.mCalled = false;
                fragment2.onAttach(fragmentManagerImpl3.mHost.mContext);
                if (fragment2.mCalled) {
                    throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{24, 85, 81, 86, 68, 90, 14, 17, 65, 81, 3, 8, 13, 67, 76, 89, 74, 93, 17, 83, 9, 69, 21, 93, 66, 23, 20, 19, 93, 67, 22, 93, 10, 117, 21, 17, 0, 81, 10, 76, 72}, "8182d4aea2bdac", 6));
                }
                if (fragment2.mParentFragment == null) {
                    FragmentActivity fragmentActivity7 = FragmentActivity.this;
                }
                FragmentActivity fragmentActivity8 = fragmentManagerImpl3.mHost.mContext;
                fragmentManagerImpl3.dispatchOnFragmentAttached(false);
                if (fragment2.mIsCreated) {
                    fragmentManagerImpl3.dispatchOnFragmentPreCreated(false);
                    Bundle bundle3 = fragment2.mSavedFragmentState;
                    fragmentManagerImpl4 = fragment2.mChildFragmentManager;
                    if (fragmentManagerImpl4 != null) {
                        fragmentManagerImpl4.noteStateNotSaved();
                    }
                    fragment2.mState = 1;
                    fragment2.mCalled = false;
                    fragment2.onCreate(bundle3);
                    fragment2.mIsCreated = true;
                    if (fragment2.mCalled) {
                        throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{22, 2, 92, 2, 17, 92, 14, 18, 16, 82, 82, 90, 89, 68, 23, 88, 68, 9, 64, 1, 89, 18, 21, 9, 16, 66, 70, 70, 80, 22, 77, 95, 88, 37, 71, 3, 80, 70, 4, 78, 25}, "6f5f12af01365dc0"));
                    }
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_CREATE);
                    fragmentManagerImpl3.dispatchOnFragmentCreated(false);
                } else {
                    fragment2.restoreChildFragmentState(fragment2.mSavedFragmentState);
                    fragment2.mState = 1;
                }
                fragment2.mRetaining = false;
            }
            if (fragment2.mFromLayout && !fragment2.mPerformedCreateView) {
                fragment2.onGetLayoutInflater(fragment2.mSavedFragmentState);
                fragmentManagerImpl8 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl8 != null) {
                    fragmentManagerImpl8.noteStateNotSaved();
                }
                fragment2.mPerformedCreateView = true;
            }
            if (i9 > 1) {
                if (!fragment2.mFromLayout) {
                    i6 = fragment2.mContainerId;
                    if (i6 != 0) {
                        viewGroup = null;
                    } else {
                        if (i6 != -1) {
                            fragmentManagerImpl3.throwException(new IllegalArgumentException(C0000.decode(new byte[]{123, 85, 15, 87, 14, 66, 69, 83, 71, 80, 7, 17, 81, 65, 94, 70, 0, 94, 12, 83, 11, 68, 21}, "84a9a6e055fe4a", true) + fragment2 + C0000.decode(new byte[]{17, 81, 13, 64, 70, 86, 69, 86, 9, 13, 70, 81, 94, 92, 84, 69, 66, 68, 15, 82, 18, 21, 17, 10, 70, 88, 23, 92, 94, 23, 11, 86}, "17b2f7e5fc2072")));
                            throw null;
                        }
                        viewGroup = (ViewGroup) fragmentManagerImpl3.mContainer.onFindViewById(i6);
                        if (viewGroup == null && !fragment2.mRestored) {
                            try {
                                hostCallbacks2 = fragment2.mHost;
                                if (hostCallbacks2 == null) {
                                    fragmentActivity2 = null;
                                } else {
                                    fragmentActivity2 = hostCallbacks2.mContext;
                                }
                                if (fragmentActivity2 != null) {
                                    throw new IllegalStateException(strDecode2 + fragment2 + C0000.decode(new byte[]{67, 12, 89, 67, 19, 89, 18, 64, 7, 2, 14, 85, 7, 66, 66, 88, 19, 89, 70, 87, 9, 15, 18, 85, 27, 22, 24}, "cb6738f4faf0"));
                                }
                                strDecode = fragmentActivity2.getResources().getResourceName(fragment2.mContainerId);
                                fragmentManagerImpl3.throwException(new IllegalArgumentException(C0000.decode(new byte[]{43, 87, 68, 21, 11, 81, 68, 24, 86, 13, 16, 86, 0, 67, 4, 91, 65, 24, 89, 6, 69, 8, 28}, "e8dcb4380b", true) + Integer.toHexString(fragment2.mContainerId) + C0000.decode(new byte[]{66, 74}, "bb7f994ec4cd", true) + strDecode + C0000.decode(new byte[]{27, 68, 94, 89, 74, 69, 82, 66, 83, 87, 9, 7, 88, 71, 21}, "2d868e4020db635f", false) + fragment2));
                                throw null;
                            } catch (Resources.NotFoundException unused2) {
                                strDecode = C0000.decode(new byte[]{20, 11, 8, 94, 87, 71, 8}, "aec080f6ac5ab5");
                            }
                        }
                    }
                    fragment2.mContainer = viewGroup;
                    fragment2.onGetLayoutInflater(fragment2.mSavedFragmentState);
                    fragmentManagerImpl7 = fragment2.mChildFragmentManager;
                    if (fragmentManagerImpl7 != null) {
                        fragmentManagerImpl7.noteStateNotSaved();
                    }
                    fragment2.mPerformedCreateView = true;
                }
                Bundle bundle4 = fragment2.mSavedFragmentState;
                fragmentManagerImpl5 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl5 != null) {
                    fragmentManagerImpl5.noteStateNotSaved();
                }
                fragment2.mState = 2;
                fragment2.mCalled = false;
                fragment2.onActivityCreated(bundle4);
                if (fragment2.mCalled) {
                    throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{67, 0, 13, 86, 70, 86, 12, 16, 68, 81, 7, 84, 15, 68, 16, 90, 20, 87, 22, 3, 12, 18, 18, 87, 67, 23, 17, 66, 3, 74, 77, 11, 10, 115, 5, 76, 10, 18, 13, 70, 31, 123, 17, 1, 5, 70, 3, 92, 75, 77}, "cdd2f8"));
                }
                fragmentManagerImpl6 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl6 != null) {
                    fragmentManagerImpl6.mStateSaved = false;
                    fragmentManagerImpl6.mStopped = false;
                    fragmentManagerImpl6.dispatchStateChange(2);
                }
                fragmentManagerImpl3.dispatchOnFragmentActivityCreated(false);
                fragment2.mSavedFragmentState = null;
            }
            if (i9 > 2) {
                fragmentManagerImpl9 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl9 != null) {
                    fragmentManagerImpl9.noteStateNotSaved();
                    fragment2.mChildFragmentManager.execPendingActions();
                }
                fragment2.mState = 3;
                fragment2.mCalled = false;
                fragment2.onStart();
                if (!fragment2.mCalled) {
                    throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{24, 82, 91, 92, 16, 92, 11, 22, 22, 2, 7, 10, 9, 69, 76, 94, 64, 87, 69, 85, 12, 66, 66, 14, 70, 21, 16, 21, 93, 68, 28, 87, 94, 97, 16, 3, 68, 21, 78, 79}, "862802db6affee", 5));
                }
                fragmentManagerImpl10 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl10 != null) {
                    fragmentManagerImpl10.mStateSaved = false;
                    fragmentManagerImpl10.mStopped = false;
                    fragmentManagerImpl10.dispatchStateChange(3);
                }
                lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_START);
                fragmentManagerImpl3.dispatchOnFragmentStarted(false);
            }
            if (i9 > 3) {
                fragmentManagerImpl11 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl11 != null) {
                    fragmentManagerImpl11.noteStateNotSaved();
                    fragment2.mChildFragmentManager.execPendingActions();
                }
                fragment2.mState = 4;
                fragment2.mCalled = false;
                fragment2.mCalled = true;
                if (!fragment2.mCalled) {
                    throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{20, 87, 80, 5, 67, 92, 92, 21, 18, 90, 83, 95, 13, 70, 66, 89, 70, 92, 76, 6, 11, 18, 71, 14, 18, 74, 71, 67, 4, 20, 24, 94, 90, 97, 92, 18, 22, 95, 86, 73, 27}, "439ac23a2923af61", 3));
                }
                fragmentManagerImpl12 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl12 != null) {
                    fragmentManagerImpl12.mStateSaved = false;
                    fragmentManagerImpl12.mStopped = false;
                    fragmentManagerImpl12.dispatchStateChange(4);
                    fragment2.mChildFragmentManager.execPendingActions();
                }
                lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_RESUME);
                fragmentManagerImpl3.dispatchOnFragmentResumed(false);
                fragment2.mSavedFragmentState = null;
                fragment2.mSavedViewState = null;
            }
        } else if (i12 != 1) {
            fragment2 = fragment;
            fragmentManagerImpl3 = fragmentManagerImpl3;
            if (i12 != 2) {
                if (i12 == 3) {
                }
            } else if (i9 > 2) {
                fragmentManagerImpl9 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl9 != null) {
                    fragmentManagerImpl9.noteStateNotSaved();
                    fragment2.mChildFragmentManager.execPendingActions();
                }
                fragment2.mState = 3;
                fragment2.mCalled = false;
                fragment2.onStart();
                if (!fragment2.mCalled) {
                    throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{24, 82, 91, 92, 16, 92, 11, 22, 22, 2, 7, 10, 9, 69, 76, 94, 64, 87, 69, 85, 12, 66, 66, 14, 70, 21, 16, 21, 93, 68, 28, 87, 94, 97, 16, 3, 68, 21, 78, 79}, "862802db6affee", 5));
                }
                fragmentManagerImpl10 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl10 != null) {
                    fragmentManagerImpl10.mStateSaved = false;
                    fragmentManagerImpl10.mStopped = false;
                    fragmentManagerImpl10.dispatchStateChange(3);
                }
                lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_START);
                fragmentManagerImpl3.dispatchOnFragmentStarted(false);
            }
            if (i9 > 3) {
                fragmentManagerImpl11 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl11 != null) {
                    fragmentManagerImpl11.noteStateNotSaved();
                    fragment2.mChildFragmentManager.execPendingActions();
                }
                fragment2.mState = 4;
                fragment2.mCalled = false;
                fragment2.mCalled = true;
                if (!fragment2.mCalled) {
                    throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{20, 87, 80, 5, 67, 92, 92, 21, 18, 90, 83, 95, 13, 70, 66, 89, 70, 92, 76, 6, 11, 18, 71, 14, 18, 74, 71, 67, 4, 20, 24, 94, 90, 97, 92, 18, 22, 95, 86, 73, 27}, "439ac23a2923af61", 3));
                }
                fragmentManagerImpl12 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl12 != null) {
                    fragmentManagerImpl12.mStateSaved = false;
                    fragmentManagerImpl12.mStopped = false;
                    fragmentManagerImpl12.dispatchStateChange(4);
                    fragment2.mChildFragmentManager.execPendingActions();
                }
                lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_RESUME);
                fragmentManagerImpl3.dispatchOnFragmentResumed(false);
                fragment2.mSavedFragmentState = null;
                fragment2.mSavedViewState = null;
            }
        }
        fragment2 = fragment;
        fragmentManagerImpl3 = fragmentManagerImpl3;
        if (fragment2.mFromLayout) {
            fragment2.onGetLayoutInflater(fragment2.mSavedFragmentState);
            fragmentManagerImpl8 = fragment2.mChildFragmentManager;
            if (fragmentManagerImpl8 != null) {
                fragmentManagerImpl8.noteStateNotSaved();
            }
            fragment2.mPerformedCreateView = true;
        }
        if (i9 > 1) {
            if (!fragment2.mFromLayout) {
                i6 = fragment2.mContainerId;
                if (i6 != 0) {
                    viewGroup = null;
                } else {
                    if (i6 != -1) {
                        fragmentManagerImpl3.throwException(new IllegalArgumentException(C0000.decode(new byte[]{123, 85, 15, 87, 14, 66, 69, 83, 71, 80, 7, 17, 81, 65, 94, 70, 0, 94, 12, 83, 11, 68, 21}, "84a9a6e055fe4a", true) + fragment2 + C0000.decode(new byte[]{17, 81, 13, 64, 70, 86, 69, 86, 9, 13, 70, 81, 94, 92, 84, 69, 66, 68, 15, 82, 18, 21, 17, 10, 70, 88, 23, 92, 94, 23, 11, 86}, "17b2f7e5fc2072")));
                        throw null;
                    }
                    viewGroup = (ViewGroup) fragmentManagerImpl3.mContainer.onFindViewById(i6);
                    if (viewGroup == null) {
                        hostCallbacks2 = fragment2.mHost;
                        if (hostCallbacks2 == null) {
                            fragmentActivity2 = null;
                        } else {
                            fragmentActivity2 = hostCallbacks2.mContext;
                        }
                        if (fragmentActivity2 != null) {
                            throw new IllegalStateException(strDecode2 + fragment2 + C0000.decode(new byte[]{67, 12, 89, 67, 19, 89, 18, 64, 7, 2, 14, 85, 7, 66, 66, 88, 19, 89, 70, 87, 9, 15, 18, 85, 27, 22, 24}, "cb6738f4faf0"));
                        }
                        strDecode = fragmentActivity2.getResources().getResourceName(fragment2.mContainerId);
                        fragmentManagerImpl3.throwException(new IllegalArgumentException(C0000.decode(new byte[]{43, 87, 68, 21, 11, 81, 68, 24, 86, 13, 16, 86, 0, 67, 4, 91, 65, 24, 89, 6, 69, 8, 28}, "e8dcb4380b", true) + Integer.toHexString(fragment2.mContainerId) + C0000.decode(new byte[]{66, 74}, "bb7f994ec4cd", true) + strDecode + C0000.decode(new byte[]{27, 68, 94, 89, 74, 69, 82, 66, 83, 87, 9, 7, 88, 71, 21}, "2d868e4020db635f", false) + fragment2));
                        throw null;
                    }
                }
                fragment2.mContainer = viewGroup;
                fragment2.onGetLayoutInflater(fragment2.mSavedFragmentState);
                fragmentManagerImpl7 = fragment2.mChildFragmentManager;
                if (fragmentManagerImpl7 != null) {
                    fragmentManagerImpl7.noteStateNotSaved();
                }
                fragment2.mPerformedCreateView = true;
            }
            Bundle bundle5 = fragment2.mSavedFragmentState;
            fragmentManagerImpl5 = fragment2.mChildFragmentManager;
            if (fragmentManagerImpl5 != null) {
                fragmentManagerImpl5.noteStateNotSaved();
            }
            fragment2.mState = 2;
            fragment2.mCalled = false;
            fragment2.onActivityCreated(bundle5);
            if (fragment2.mCalled) {
                throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{67, 0, 13, 86, 70, 86, 12, 16, 68, 81, 7, 84, 15, 68, 16, 90, 20, 87, 22, 3, 12, 18, 18, 87, 67, 23, 17, 66, 3, 74, 77, 11, 10, 115, 5, 76, 10, 18, 13, 70, 31, 123, 17, 1, 5, 70, 3, 92, 75, 77}, "cdd2f8"));
            }
            fragmentManagerImpl6 = fragment2.mChildFragmentManager;
            if (fragmentManagerImpl6 != null) {
                fragmentManagerImpl6.mStateSaved = false;
                fragmentManagerImpl6.mStopped = false;
                fragmentManagerImpl6.dispatchStateChange(2);
            }
            fragmentManagerImpl3.dispatchOnFragmentActivityCreated(false);
            fragment2.mSavedFragmentState = null;
        }
        if (i9 > 2) {
            fragmentManagerImpl9 = fragment2.mChildFragmentManager;
            if (fragmentManagerImpl9 != null) {
                fragmentManagerImpl9.noteStateNotSaved();
                fragment2.mChildFragmentManager.execPendingActions();
            }
            fragment2.mState = 3;
            fragment2.mCalled = false;
            fragment2.onStart();
            if (!fragment2.mCalled) {
                throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{24, 82, 91, 92, 16, 92, 11, 22, 22, 2, 7, 10, 9, 69, 76, 94, 64, 87, 69, 85, 12, 66, 66, 14, 70, 21, 16, 21, 93, 68, 28, 87, 94, 97, 16, 3, 68, 21, 78, 79}, "862802db6affee", 5));
            }
            fragmentManagerImpl10 = fragment2.mChildFragmentManager;
            if (fragmentManagerImpl10 != null) {
                fragmentManagerImpl10.mStateSaved = false;
                fragmentManagerImpl10.mStopped = false;
                fragmentManagerImpl10.dispatchStateChange(3);
            }
            lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_START);
            fragmentManagerImpl3.dispatchOnFragmentStarted(false);
        }
        if (i9 > 3) {
            fragmentManagerImpl11 = fragment2.mChildFragmentManager;
            if (fragmentManagerImpl11 != null) {
                fragmentManagerImpl11.noteStateNotSaved();
                fragment2.mChildFragmentManager.execPendingActions();
            }
            fragment2.mState = 4;
            fragment2.mCalled = false;
            fragment2.mCalled = true;
            if (!fragment2.mCalled) {
                throw new SuperNotCalledException(strDecode2 + fragment2 + C0000.decode(new byte[]{20, 87, 80, 5, 67, 92, 92, 21, 18, 90, 83, 95, 13, 70, 66, 89, 70, 92, 76, 6, 11, 18, 71, 14, 18, 74, 71, 67, 4, 20, 24, 94, 90, 97, 92, 18, 22, 95, 86, 73, 27}, "439ac23a2923af61", 3));
            }
            fragmentManagerImpl12 = fragment2.mChildFragmentManager;
            if (fragmentManagerImpl12 != null) {
                fragmentManagerImpl12.mStateSaved = false;
                fragmentManagerImpl12.mStopped = false;
                fragmentManagerImpl12.dispatchStateChange(4);
                fragment2.mChildFragmentManager.execPendingActions();
            }
            lifecycleRegistry.handleLifecycleEvent(Lifecycle$Event.ON_RESUME);
            fragmentManagerImpl3.dispatchOnFragmentResumed(false);
            fragment2.mSavedFragmentState = null;
            fragment2.mSavedViewState = null;
        }
        i8 = i9;
        if (fragment2.mState != i8) {
            fragment2.toString();
            fragment2.mState = i8;
        }
    }

    public final void noteStateNotSaved() {
        FragmentManagerImpl fragmentManagerImpl;
        this.mSavedNonConfig = null;
        this.mStateSaved = false;
        this.mStopped = false;
        ArrayList arrayList = this.mAdded;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) arrayList.get(i);
            if (fragment != null && (fragmentManagerImpl = fragment.mChildFragmentManager) != null) {
                fragmentManagerImpl.noteStateNotSaved();
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        if (C0000.decode(new byte[]{4, 23, 4, 85, 90, 83, 8, 22}, "bee276fb").equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, C0000.decode(new byte[]{7, 10, 80, 16, 68}, "df1c742f550ad1"));
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentManager.Fragment);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            FragmentActivity fragmentActivity = this.mHost.mContext;
            try {
                SimpleArrayMap simpleArrayMap = Fragment.sClassMap;
                Class<?> clsLoadClass = (Class) simpleArrayMap.get(attributeValue);
                if (clsLoadClass == null) {
                    clsLoadClass = fragmentActivity.getClassLoader().loadClass(attributeValue);
                    simpleArrayMap.put(attributeValue, clsLoadClass);
                }
                zIsAssignableFrom = Fragment.class.isAssignableFrom(clsLoadClass);
            } catch (ClassNotFoundException unused) {
                zIsAssignableFrom = false;
            }
            if (zIsAssignableFrom) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + C0000.decode(new byte[]{95, 65, 124, 64, 69, 77, 66, 65, 19, 81, 87, 88, 84, 27, 69, 20, 95, 92, 71, 76, 7, 18, 2, 90, 80, 67, 93, 11, 1, 91, 88, 81, 26, 25, 3, 92, 7, 70, 91, 88, 86, 88, 17, 0, 86, 25, 22, 86, 16, 18, 11, 85, 66, 84, 18, 3, 69, 17, 80, 71, 83, 87, 22, 18, 20, 93, 64, 89, 18, 3, 11, 65, 88, 81, 22, 95, 13, 64, 67}, "ea1569b2c4412b") + attributeValue);
                }
                Fragment fragmentFindFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
                if (fragmentFindFragmentById == null && string != null) {
                    ArrayList arrayList = this.mAdded;
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size >= 0) {
                            Fragment fragment = (Fragment) arrayList.get(size);
                            if (fragment != null && string.equals(fragment.mTag)) {
                                fragmentFindFragmentById = fragment;
                                break;
                            }
                            size--;
                        } else {
                            SparseArray sparseArray = this.mActive;
                            if (sparseArray == null) {
                                fragmentFindFragmentById = null;
                                break;
                            }
                            int size2 = sparseArray.size() - 1;
                            while (true) {
                                if (size2 >= 0) {
                                    Fragment fragment2 = (Fragment) this.mActive.valueAt(size2);
                                    if (fragment2 != null && string.equals(fragment2.mTag)) {
                                        fragmentFindFragmentById = fragment2;
                                        break;
                                    }
                                    size2--;
                                } else {
                                    fragmentFindFragmentById = null;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (fragmentFindFragmentById == null && id != -1) {
                    fragmentFindFragmentById = findFragmentById(id);
                }
                if (fragmentFindFragmentById == null) {
                    fragmentFindFragmentById = this.mContainer.instantiate(context, attributeValue, null);
                    fragmentFindFragmentById.mFromLayout = true;
                    if (resourceId == 0) {
                        resourceId = id;
                    }
                    fragmentFindFragmentById.mFragmentId = resourceId;
                    fragmentFindFragmentById.mContainerId = id;
                    fragmentFindFragmentById.mTag = string;
                    fragmentFindFragmentById.mInLayout = true;
                    fragmentFindFragmentById.mFragmentManager = this;
                    FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
                    fragmentFindFragmentById.mHost = hostCallbacks;
                    FragmentActivity fragmentActivity2 = hostCallbacks.mContext;
                    fragmentFindFragmentById.mCalled = true;
                    if ((hostCallbacks != null ? hostCallbacks.mActivity : null) != null) {
                        fragmentFindFragmentById.mCalled = true;
                    }
                    addFragment(fragmentFindFragmentById, true);
                } else {
                    if (fragmentFindFragmentById.mInLayout) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + C0000.decode(new byte[]{10, 67, 38, 77, 65, 94, 10, 91, 82, 21, 4, 19, 11, 2, 16, 83, 26}, "0cb812c83aa3bf") + Integer.toHexString(resourceId) + C0000.decode(new byte[]{27, 24, 71, 3, 86, 20}, "783b146abb77") + string + C0000.decode(new byte[]{77, 70, 94, 23, 69, 22, 7, 66, 3, 88, 21, 70, 88, 1, 69, 86, 30}, "af1eeff0f6") + Integer.toHexString(id) + C0000.decode(new byte[]{20, 67, 13, 68, 93, 66, 0, 86, 9, 65, 95, 85, 67, 17, 82, 70, 5, 87, 88, 7, 15, 76, 70, 83, 88, 66, 17}, "44d05ba8f57011") + attributeValue);
                    }
                    fragmentFindFragmentById.mInLayout = true;
                    FragmentActivity.HostCallbacks hostCallbacks2 = this.mHost;
                    fragmentFindFragmentById.mHost = hostCallbacks2;
                    if (!fragmentFindFragmentById.mRetaining) {
                        FragmentActivity fragmentActivity3 = hostCallbacks2.mContext;
                        fragmentFindFragmentById.mCalled = true;
                        if ((hostCallbacks2 != null ? hostCallbacks2.mActivity : null) != null) {
                            fragmentFindFragmentById.mCalled = true;
                        }
                    }
                }
                Fragment fragment3 = fragmentFindFragmentById;
                int i = this.mCurState;
                if (i >= 1 || !fragment3.mFromLayout) {
                    moveToState(fragment3, i, 0, 0, false);
                } else {
                    moveToState(fragment3, 1, 0, 0, false);
                }
                throw new IllegalStateException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{114, 71, 84, 85, 84, 84, 8, 71, 20}, "455291f3"), attributeValue, C0000.decode(new byte[]{69, 7, 89, 6, 68, 11, 95, 17, 70, 84, 23, 7, 4, 23, 85, 66, 5, 69, 70, 12, 3, 64, 75}, "ec0bde0ef7eb")));
            }
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        onCreateView(null, str, context, attributeSet);
        return null;
    }

    public final boolean popBackStackImmediate() {
        FragmentManagerImpl fragmentManagerImpl;
        if (this.mStateSaved || this.mStopped) {
            throw new IllegalStateException(C0000.decode(new byte[]{32, 85, 88, 70, 87, 92, 64, 19, 18, 85, 17, 82, 89, 20, 84, 19, 64, 91, 11, 67, 67, 85, 85, 18, 80, 92, 90, 19, 3, 86, 23, 81, 68, 70, 86, 93, 103, 82, 20, 85, 42, 90, 69, 18, 88, 93, 87, 86, 49, 68, 2, 64, 83}, "c46f9343b0"));
        }
        execPendingActions();
        ensureExecReady();
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && (fragmentManagerImpl = fragment.mChildFragmentManager) != null && fragmentManagerImpl.popBackStackImmediate()) {
            return true;
        }
        boolean zPopBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, -1, 0);
        if (zPopBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
        burpActive();
        return zPopBackStackState;
    }

    public final boolean popBackStackState(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        int size;
        BackStackRecord backStackRecord;
        ArrayList arrayList3 = this.mBackStack;
        if (arrayList3 == null) {
            return false;
        }
        if (i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.mBackStack.remove(size2));
            arrayList2.add(Boolean.TRUE);
            return true;
        }
        if (i >= 0) {
            size = arrayList3.size() - 1;
            while (size >= 0) {
                BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(size);
                if (i >= 0 && i == backStackRecord2.mIndex) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return false;
            }
            if ((i2 & 1) != 0) {
                do {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    backStackRecord = (BackStackRecord) this.mBackStack.get(size);
                    if (i < 0) {
                        break;
                    }
                } while (i == backStackRecord.mIndex);
            }
        } else {
            size = -1;
        }
        if (size == this.mBackStack.size() - 1) {
            return false;
        }
        for (int size3 = this.mBackStack.size() - 1; size3 > size; size3--) {
            arrayList.add(this.mBackStack.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void removeFragment(Fragment fragment) {
        boolean z = fragment.mBackStackNesting > 0;
        if (fragment.mDetached && z) {
            return;
        }
        synchronized (this.mAdded) {
            this.mAdded.remove(fragment);
        }
        fragment.mAdded = false;
        fragment.mRemoving = true;
    }

    public final void removeRedundantOperationsAndExecute(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException(C0000.decode(new byte[]{42, 90, 71, 1, 75, 8, 0, 85, 67, 81, 65, 22, 86, 20, 65, 78, 10, 64, 91, 68, 77, 14, 4, 25, 1, 85, 80, 15, 25, 21, 21, 88, 0, 95, 19, 22, 92, 5, 14, 75, 7, 71}, "c43d9fa9", true));
        }
        executePostponedTransaction(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((BackStackRecord) arrayList.get(i)).mReorderingAllowed) {
                if (i2 != i) {
                    executeOpsTogether(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).mReorderingAllowed) {
                        i2++;
                    }
                }
                executeOpsTogether(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            executeOpsTogether(arrayList, arrayList2, i2, size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void restoreAllState(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        List list;
        List list2;
        FragmentState[] fragmentStateArr;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.mActive == null) {
            return;
        }
        FragmentManagerNonConfig fragmentManagerNonConfig2 = null;
        if (fragmentManagerNonConfig != null) {
            List list3 = fragmentManagerNonConfig.mFragments;
            list = fragmentManagerNonConfig.mChildNonConfigs;
            list2 = fragmentManagerNonConfig.mViewModelStores;
            int size = list3 != null ? list3.size() : 0;
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) list3.get(i);
                int i2 = 0;
                while (true) {
                    fragmentStateArr = fragmentManagerState.mActive;
                    if (i2 >= fragmentStateArr.length || fragmentStateArr[i2].mIndex == fragment.mIndex) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == fragmentStateArr.length) {
                    throwException(new IllegalStateException(C0000.decode(new byte[]{117, 87, 17, 10, 80, 23, 88, 87, 16, 70, 82, 94, 88, 92, 68, 7, 87, 67, 95, 78, 1, 70, 82, 69, 87, 95, 9, 3, 90, 67, 22, 79, 13, 18, 92, 23, 95, 86, 0, 3, 76, 23}, "68df47", 6) + fragment.mIndex));
                    throw null;
                }
                FragmentState fragmentState = fragmentStateArr[i2];
                fragmentState.mInstance = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                fragment.mTarget = null;
                Bundle bundle = fragmentState.mSavedFragmentState;
                if (bundle != null) {
                    bundle.setClassLoader(this.mHost.mContext.getClassLoader());
                    fragment.mSavedViewState = fragmentState.mSavedFragmentState.getSparseParcelableArray(C0000.decode(new byte[]{3, 8, 93, 69, 90, 8, 83, 13, 20, 15, 92, 64, 106, 18, 67, 86, 22, 3}, "bf975a77", true));
                    fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                }
            }
        } else {
            list = null;
            list2 = null;
        }
        this.mActive = new SparseArray(fragmentManagerState.mActive.length);
        int i3 = 0;
        while (true) {
            FragmentState[] fragmentStateArr2 = fragmentManagerState.mActive;
            if (i3 >= fragmentStateArr2.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr2[i3];
            if (fragmentState2 != null) {
                FragmentManagerNonConfig fragmentManagerNonConfig3 = (list == null || i3 >= list.size()) ? fragmentManagerNonConfig2 : (FragmentManagerNonConfig) list.get(i3);
                ViewModelStore viewModelStore = (list2 == null || i3 >= list2.size()) ? fragmentManagerNonConfig2 : (ViewModelStore) list2.get(i3);
                FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
                FragmentManager fragmentManager = this.mContainer;
                Fragment fragment2 = this.mParent;
                String str = fragmentState2.mClassName;
                Bundle bundle2 = fragmentState2.mArguments;
                if (fragmentState2.mInstance == null) {
                    FragmentActivity fragmentActivity = hostCallbacks.mContext;
                    if (bundle2 != null) {
                        bundle2.setClassLoader(fragmentActivity.getClassLoader());
                    }
                    if (fragmentManager != null) {
                        fragmentState2.mInstance = fragmentManager.instantiate(fragmentActivity, str, bundle2);
                    } else {
                        fragmentState2.mInstance = Fragment.instantiate(fragmentActivity, str, bundle2);
                    }
                    Bundle bundle3 = fragmentState2.mSavedFragmentState;
                    if (bundle3 != null) {
                        bundle3.setClassLoader(fragmentActivity.getClassLoader());
                        fragmentState2.mInstance.mSavedFragmentState = fragmentState2.mSavedFragmentState;
                    }
                    fragmentState2.mInstance.setIndex(fragmentState2.mIndex, fragment2);
                    Fragment fragment3 = fragmentState2.mInstance;
                    fragment3.mFromLayout = fragmentState2.mFromLayout;
                    fragment3.mRestored = true;
                    fragment3.mFragmentId = fragmentState2.mFragmentId;
                    fragment3.mContainerId = fragmentState2.mContainerId;
                    fragment3.mTag = fragmentState2.mTag;
                    fragment3.mRetainInstance = fragmentState2.mRetainInstance;
                    fragment3.mDetached = fragmentState2.mDetached;
                    fragment3.mHidden = fragmentState2.mHidden;
                    fragment3.mFragmentManager = hostCallbacks.mFragmentManager;
                }
                Fragment fragment4 = fragmentState2.mInstance;
                fragment4.mChildNonConfig = fragmentManagerNonConfig3;
                fragment4.mViewModelStore = viewModelStore;
                this.mActive.put(fragment4.mIndex, fragment4);
                fragmentState2.mInstance = null;
            }
            i3++;
            fragmentManagerNonConfig2 = null;
        }
        if (fragmentManagerNonConfig != null) {
            List list4 = fragmentManagerNonConfig.mFragments;
            int size2 = list4 != null ? list4.size() : 0;
            for (int i4 = 0; i4 < size2; i4++) {
                Fragment fragment5 = (Fragment) list4.get(i4);
                int i5 = fragment5.mTargetIndex;
                if (i5 >= 0) {
                    Fragment fragment6 = (Fragment) this.mActive.get(i5);
                    fragment5.mTarget = fragment6;
                    if (fragment6 == null) {
                        fragment5.toString();
                    }
                }
            }
        }
        this.mAdded.clear();
        if (fragmentManagerState.mAdded != null) {
            int i6 = 0;
            while (true) {
                int[] iArr = fragmentManagerState.mAdded;
                if (i6 >= iArr.length) {
                    break;
                }
                Fragment fragment7 = (Fragment) this.mActive.get(iArr[i6]);
                if (fragment7 == null) {
                    throwException(new IllegalStateException(C0000.decode(new byte[]{44, 10, 66, 95, 93, 67, 77, 2, 15, 69, 11, 4, 22, 83, 87, 16, 95, 17, 0, 86, 15, 0, 12, 66, 19, 86, 86, 17, 65, 88, 12, 1, 7, 78, 19, 19}, "beb6309ca1", false) + fragmentManagerState.mAdded[i6]));
                    throw null;
                }
                fragment7.mAdded = true;
                if (this.mAdded.contains(fragment7)) {
                    throw new IllegalStateException(C0000.decode(new byte[]{39, 91, 16, 85, 87, 6, 65, 16, 87, 93, 2, 82, 6, 17}, "f7b06b8069", 3));
                }
                synchronized (this.mAdded) {
                    this.mAdded.add(fragment7);
                }
                i6++;
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
            int i7 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.mBackStack;
                if (i7 >= backStackStateArr.length) {
                    break;
                }
                BackStackState backStackState = backStackStateArr[i7];
                int[] iArr2 = backStackState.mOps;
                BackStackRecord backStackRecord = new BackStackRecord(this);
                int i8 = 0;
                while (i8 < iArr2.length) {
                    BackStackRecord.Op op = new BackStackRecord.Op();
                    op.cmd = iArr2[i8];
                    int i9 = i8 + 2;
                    int i10 = iArr2[i8 + 1];
                    if (i10 >= 0) {
                        op.fragment = (Fragment) this.mActive.get(i10);
                    } else {
                        op.fragment = null;
                    }
                    int i11 = iArr2[i9];
                    op.enterAnim = i11;
                    int i12 = iArr2[i8 + 3];
                    op.exitAnim = i12;
                    int i13 = i8 + 5;
                    int i14 = iArr2[i8 + 4];
                    op.popEnterAnim = i14;
                    i8 += 6;
                    int i15 = iArr2[i13];
                    op.popExitAnim = i15;
                    backStackRecord.mEnterAnim = i11;
                    backStackRecord.mExitAnim = i12;
                    backStackRecord.mPopEnterAnim = i14;
                    backStackRecord.mPopExitAnim = i15;
                    backStackRecord.addOp(op);
                }
                backStackRecord.mTransition = backStackState.mTransition;
                backStackRecord.mTransitionStyle = backStackState.mTransitionStyle;
                backStackRecord.mName = backStackState.mName;
                backStackRecord.mIndex = backStackState.mIndex;
                backStackRecord.mAddToBackStack = true;
                backStackRecord.mBreadCrumbTitleRes = backStackState.mBreadCrumbTitleRes;
                backStackRecord.mBreadCrumbTitleText = backStackState.mBreadCrumbTitleText;
                backStackRecord.mBreadCrumbShortTitleRes = backStackState.mBreadCrumbShortTitleRes;
                backStackRecord.mBreadCrumbShortTitleText = backStackState.mBreadCrumbShortTitleText;
                backStackRecord.mSharedElementSourceNames = backStackState.mSharedElementSourceNames;
                backStackRecord.mSharedElementTargetNames = backStackState.mSharedElementTargetNames;
                backStackRecord.mReorderingAllowed = backStackState.mReorderingAllowed;
                backStackRecord.bumpBackStackNesting(1);
                this.mBackStack.add(backStackRecord);
                int i16 = backStackRecord.mIndex;
                if (i16 >= 0) {
                    synchronized (this) {
                        try {
                            if (this.mBackStackIndices == null) {
                                this.mBackStackIndices = new ArrayList();
                            }
                            int size3 = this.mBackStackIndices.size();
                            if (i16 < size3) {
                                this.mBackStackIndices.set(i16, backStackRecord);
                            } else {
                                while (size3 < i16) {
                                    this.mBackStackIndices.add(null);
                                    if (this.mAvailBackStackIndices == null) {
                                        this.mAvailBackStackIndices = new ArrayList();
                                    }
                                    this.mAvailBackStackIndices.add(Integer.valueOf(size3));
                                    size3++;
                                }
                                this.mBackStackIndices.add(backStackRecord);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                i7++;
            }
        } else {
            this.mBackStack = null;
        }
        int i17 = fragmentManagerState.mPrimaryNavActiveIndex;
        if (i17 >= 0) {
            this.mPrimaryNav = (Fragment) this.mActive.get(i17);
        }
        this.mNextFragmentIndex = fragmentManagerState.mNextFragmentIndex;
    }

    public final FragmentManagerState saveAllState() {
        int[] iArr;
        int size;
        Bundle bundle;
        FragmentManagerState fragmentManagerStateSaveAllState;
        SparseArray sparseArray = this.mActive;
        int size2 = sparseArray == null ? 0 : sparseArray.size();
        for (int i = 0; i < size2; i++) {
            Fragment fragment = (Fragment) this.mActive.valueAt(i);
            if (fragment != null && fragment.getAnimator() != null) {
                fragment.getAnimator().end();
            }
        }
        execPendingActions();
        this.mStateSaved = true;
        BackStackState[] backStackStateArr = null;
        this.mSavedNonConfig = null;
        SparseArray sparseArray2 = this.mActive;
        if (sparseArray2 != null && sparseArray2.size() > 0) {
            int size3 = this.mActive.size();
            FragmentState[] fragmentStateArr = new FragmentState[size3];
            int i2 = 0;
            boolean z = false;
            while (true) {
                String strDecode = C0000.decode(new byte[]{25, 92, 86, 65, 22, 80, 90, 6, 80, 64, 85, 84, 20, 8, 87, 80, 82, 74, 12, 19}, "9472636c12004a", 7);
                String strDecode2 = C0000.decode(new byte[]{37, 4, 92, 8, 20, 71, 93, 23, 16, 4, 67, 13, 15, 82, 24, 68, 23, 4, 65, 1, 91, 21, 89, 84, 23, 12, 67, 1, 65}, "ce5da587", 0.0f);
                if (i2 >= size3) {
                    if (!z) {
                        break;
                    }
                    ArrayList arrayList = this.mAdded;
                    int size4 = arrayList.size();
                    if (size4 > 0) {
                        iArr = new int[size4];
                        for (int i3 = 0; i3 < size4; i3++) {
                            int i4 = ((Fragment) arrayList.get(i3)).mIndex;
                            iArr[i3] = i4;
                            if (i4 < 0) {
                                throwException(new IllegalStateException(strDecode2 + arrayList.get(i3) + strDecode + iArr[i3]));
                                throw null;
                            }
                        }
                    } else {
                        iArr = null;
                    }
                    ArrayList arrayList2 = this.mBackStack;
                    if (arrayList2 != null && (size = arrayList2.size()) > 0) {
                        backStackStateArr = new BackStackState[size];
                        for (int i5 = 0; i5 < size; i5++) {
                            backStackStateArr[i5] = new BackStackState((BackStackRecord) this.mBackStack.get(i5));
                        }
                    }
                    FragmentManagerState fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.mPrimaryNavActiveIndex = -1;
                    fragmentManagerState.mActive = fragmentStateArr;
                    fragmentManagerState.mAdded = iArr;
                    fragmentManagerState.mBackStack = backStackStateArr;
                    Fragment fragment2 = this.mPrimaryNav;
                    if (fragment2 != null) {
                        fragmentManagerState.mPrimaryNavActiveIndex = fragment2.mIndex;
                    }
                    fragmentManagerState.mNextFragmentIndex = this.mNextFragmentIndex;
                    saveNonConfig();
                    return fragmentManagerState;
                }
                Fragment fragment3 = (Fragment) this.mActive.valueAt(i2);
                if (fragment3 != null) {
                    if (fragment3.mIndex < 0) {
                        throwException(new IllegalStateException(strDecode2 + fragment3 + strDecode + fragment3.mIndex));
                        throw null;
                    }
                    FragmentState fragmentState = new FragmentState(fragment3);
                    fragmentStateArr[i2] = fragmentState;
                    if (fragment3.mState <= 0 || fragmentState.mSavedFragmentState != null) {
                        fragmentState.mSavedFragmentState = fragment3.mSavedFragmentState;
                    } else {
                        if (this.mStateBundle == null) {
                            this.mStateBundle = new Bundle();
                        }
                        Bundle bundle2 = this.mStateBundle;
                        fragment3.onSaveInstanceState(bundle2);
                        FragmentManagerImpl fragmentManagerImpl = fragment3.mChildFragmentManager;
                        if (fragmentManagerImpl != null && (fragmentManagerStateSaveAllState = fragmentManagerImpl.saveAllState()) != null) {
                            bundle2.putParcelable(C0000.decode(new byte[]{80, 15, 86, 70, 94, 92, 80, 12, 66, 65, 69, 18, 94, 19, 70, 14, 87, 71, 85, 81, 92, 81, 91, 22, 66}, "1a241546145b"), fragmentManagerStateSaveAllState);
                        }
                        dispatchOnFragmentSaveInstanceState(false);
                        if (this.mStateBundle.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = this.mStateBundle;
                            this.mStateBundle = null;
                        }
                        if (fragment3.mSavedViewState != null) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putSparseParcelableArray(C0000.decode(new byte[]{84, 90, 86, 70, 9, 13, 1, 14, 23, 15, 82, 22, 106, 71, 70, 85, 18, 1}, "5424fde4af7a", 1), fragment3.mSavedViewState);
                        }
                        if (!fragment3.mUserVisibleHint) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putBoolean(C0000.decode(new byte[]{81, 10, 83, 64, 12, 94, 7, 14, 66, 23, 84, 17, 59, 18, 89, 23, 94, 80, 15, 82, 60, 92, 94, 10, 69}, "0d72c7c47d1cdd", 7), fragment3.mUserVisibleHint);
                        }
                        fragmentState.mSavedFragmentState = bundle;
                        Fragment fragment4 = fragment3.mTarget;
                        if (fragment4 != null) {
                            if (fragment4.mIndex < 0) {
                                throwException(new IllegalStateException(C0000.decode(new byte[]{34, 80, 91, 92, 19, 64, 1, 17, 65, 81, 16, 91, 10, 86, 18, 67, 18, 83, 16, 84, 8, 16}, "d120f2", 0.0f) + fragment3 + C0000.decode(new byte[]{23, 89, 84, 67, 24, 76, 5, 23, 2, 0, 77, 68, 89, 94, 65, 16, 81, 86, 68, 3, 23, 4, 94, 9, 82, 95, 65, 16, 85, 89, 10, 4, 2, 0, 75, 94, 23}, "715088deee9d", 1) + fragment3.mTarget));
                                throw null;
                            }
                            if (bundle == null) {
                                fragmentState.mSavedFragmentState = new Bundle();
                            }
                            Bundle bundle3 = fragmentState.mSavedFragmentState;
                            Fragment fragment5 = fragment3.mTarget;
                            int i6 = fragment5.mIndex;
                            if (i6 < 0) {
                                throwException(new IllegalStateException(C0000.decode(new byte[]{118, 22, 86, 2, 93, 93, 93, 67, 17}, "0d7e083717248b24") + fragment5 + C0000.decode(new byte[]{24, 11, 69, 67, 92, 89, 76, 18, 5, 70, 74, 16, 83, 13, 70, 90, 65, 18, 15, 93, 24, 22, 94, 6, 18, 112, 74, 83, 1, 94, 93, 12, 66, 46, 83, 88, 89, 85, 3, 65}, "8b6c2682f3", 7)));
                                throw null;
                            }
                            bundle3.putInt(C0000.decode(new byte[]{86, 93, 84, 22, 95, 94, 83, 3, 67, 82, 66, 3, 85, 67, 104, 74, 67, 82, 68, 1}, "730d0779", false), i6);
                            int i7 = fragment3.mTargetRequestCode;
                            if (i7 != 0) {
                                fragmentState.mSavedFragmentState.putInt(C0000.decode(new byte[]{89, 94, 93, 22, 91, 13, 83, 88, 16, 80, 74, 87, 92, 16, 107, 22, 82, 19, 59, 66, 76, 81, 77, 1}, "809d4d7bd1"), i7);
                            }
                        }
                    }
                    z = true;
                }
                i2++;
            }
        }
        return null;
    }

    public final void saveNonConfig() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        FragmentManagerNonConfig fragmentManagerNonConfig;
        if (this.mActive != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i = 0; i < this.mActive.size(); i++) {
                Fragment fragment = (Fragment) this.mActive.valueAt(i);
                if (fragment != null) {
                    if (fragment.mRetainInstance) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(fragment);
                        Fragment fragment2 = fragment.mTarget;
                        fragment.mTargetIndex = fragment2 != null ? fragment2.mIndex : -1;
                    }
                    FragmentManagerImpl fragmentManagerImpl = fragment.mChildFragmentManager;
                    if (fragmentManagerImpl != null) {
                        fragmentManagerImpl.saveNonConfig();
                        fragmentManagerNonConfig = fragment.mChildFragmentManager.mSavedNonConfig;
                    } else {
                        fragmentManagerNonConfig = fragment.mChildNonConfig;
                    }
                    if (arrayList2 == null && fragmentManagerNonConfig != null) {
                        arrayList2 = new ArrayList(this.mActive.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(fragmentManagerNonConfig);
                    }
                    if (arrayList3 == null && fragment.mViewModelStore != null) {
                        arrayList3 = new ArrayList(this.mActive.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(fragment.mViewModelStore);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.mSavedNonConfig = null;
        } else {
            this.mSavedNonConfig = new FragmentManagerNonConfig(arrayList, arrayList2, arrayList3);
        }
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null || (this.mActive.get(fragment.mIndex) == fragment && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            this.mPrimaryNav = fragment;
            return;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{112, 64, 4, 3, 9, 87, 91, 67, 23}, "62edd25779d646", 0.0f) + fragment + C0000.decode(new byte[]{23, 93, 65, 21, 86, 10, 67, 66, 86, 90, 18, 84, 91, 17, 94, 20, 82, 20, 84, 71, 89, 2, 90, 7, 89, 64, 18, 90, 94, 69, 113, 16, 86, 83, 95, 80, 86, 17, 122, 3, 89, 85, 85, 80, 74, 69}, "74258e7b", false) + this);
    }

    public final void startPendingDeferredFragments() {
        if (this.mActive == null) {
            return;
        }
        for (int i = 0; i < this.mActive.size(); i++) {
            Fragment fragment = (Fragment) this.mActive.valueAt(i);
            if (fragment != null && fragment.mDeferStart) {
                if (this.mExecutingActions) {
                    this.mHavePendingDeferredStart = true;
                } else {
                    fragment.mDeferStart = false;
                    moveToState(fragment, this.mCurState, 0, 0, false);
                }
            }
        }
    }

    public final void throwException(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new LogWriter());
        FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
        String strDecode = C0000.decode(new byte[]{22, 70}, "6f3a8fef3596", true);
        try {
            if (hostCallbacks != null) {
                FragmentActivity.this.dump(strDecode, null, printWriter, new String[0]);
            } else {
                dump(strDecode, null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception unused) {
            throw runtimeException;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(C0000.decode(new byte[]{35, 22, 82, 2, 8, 3, 92, 70, 40, 7, 91, 2, 86, 82, 23, 31}, "ed3eef22ef5c17", 6));
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(C0000.decode(new byte[]{23, 12, 10, 70}, "7edf1629", 0.0f));
        Fragment fragment = this.mParent;
        if (fragment != null) {
            Trace.buildShortClassTag(fragment, sb);
        } else {
            Trace.buildShortClassTag(this.mHost, sb);
        }
        sb.append(C0000.decode(new byte[]{79, 27}, "2f02143774", 4));
        return sb.toString();
    }
}
