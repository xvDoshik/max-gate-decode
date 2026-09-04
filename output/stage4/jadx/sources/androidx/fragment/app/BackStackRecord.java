package androidx.fragment.app;

import java.util.ArrayList;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BackStackRecord implements FragmentManagerImpl.OpGenerator {
    public boolean mAddToBackStack;
    public int mBreadCrumbShortTitleRes;
    public CharSequence mBreadCrumbShortTitleText;
    public int mBreadCrumbTitleRes;
    public CharSequence mBreadCrumbTitleText;
    public boolean mCommitted;
    public int mEnterAnim;
    public int mExitAnim;
    public final FragmentManagerImpl mManager;
    public String mName;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public ArrayList mSharedElementSourceNames;
    public ArrayList mSharedElementTargetNames;
    public int mTransition;
    public int mTransitionStyle;
    public final ArrayList mOps = new ArrayList();
    public int mIndex = -1;
    public boolean mReorderingAllowed = false;

    public final class Op {
        public int cmd;
        public int enterAnim;
        public int exitAnim;
        public Fragment fragment;
        public int popEnterAnim;
        public int popExitAnim;

        public Op(int i, Fragment fragment) {
            this.cmd = i;
            this.fragment = fragment;
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.mManager = fragmentManagerImpl;
    }

    public final void addOp(Op op) {
        this.mOps.add(op);
        op.enterAnim = this.mEnterAnim;
        op.exitAnim = this.mExitAnim;
        op.popEnterAnim = this.mPopEnterAnim;
        op.popExitAnim = this.mPopExitAnim;
    }

    public final void bumpBackStackNesting(int i) {
        if (this.mAddToBackStack) {
            int i2 = FragmentManagerImpl.$r8$clinit;
            ArrayList arrayList = this.mOps;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = ((Op) arrayList.get(i3)).fragment;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    int i4 = FragmentManagerImpl.$r8$clinit;
                }
            }
        }
    }

    public final int commitInternal(boolean z) {
        int size;
        if (this.mCommitted) {
            throw new IllegalStateException(C0000.decode(new byte[]{81, 93, 84, 15, 94, 17, 66, 85, 93, 71, 86, 85, 0, 24, 18, 81, 88, 14, 91, 0, 6}, "229b7eb41534da", 0.0f));
        }
        int i = FragmentManagerImpl.$r8$clinit;
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            FragmentManagerImpl fragmentManagerImpl = this.mManager;
            synchronized (fragmentManagerImpl) {
                try {
                    ArrayList arrayList = fragmentManagerImpl.mAvailBackStackIndices;
                    if (arrayList == null || arrayList.size() <= 0) {
                        if (fragmentManagerImpl.mBackStackIndices == null) {
                            fragmentManagerImpl.mBackStackIndices = new ArrayList();
                        }
                        size = fragmentManagerImpl.mBackStackIndices.size();
                        fragmentManagerImpl.mBackStackIndices.add(this);
                    } else {
                        ArrayList arrayList2 = fragmentManagerImpl.mAvailBackStackIndices;
                        size = ((Integer) arrayList2.remove(arrayList2.size() - 1)).intValue();
                        fragmentManagerImpl.mBackStackIndices.set(size, this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.mIndex = size;
        } else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction(this, z);
        return this.mIndex;
    }

    public final void executeOps() {
        ArrayList arrayList = this.mOps;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            FragmentManagerImpl fragmentManagerImpl = this.mManager;
            if (i >= size) {
                if (this.mReorderingAllowed) {
                    return;
                }
                fragmentManagerImpl.moveToState(fragmentManagerImpl.mCurState, true);
                return;
            }
            Op op = (Op) arrayList.get(i);
            Fragment fragment = op.fragment;
            if (fragment != null) {
                int i2 = this.mTransition;
                int i3 = this.mTransitionStyle;
                if (fragment.mAnimationInfo != null || i2 != 0 || i3 != 0) {
                    fragment.ensureAnimationInfo();
                    Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
                    animationInfo.mNextTransition = i2;
                    animationInfo.mNextTransitionStyle = i3;
                }
            }
            switch (op.cmd) {
                case 1:
                    fragment.setNextAnim(op.enterAnim);
                    fragmentManagerImpl.addFragment(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException(C0000.decode(new byte[]{109, 12, 93, 86, 12, 78, 12, 68, 91, 15, 82, 2, 67}, "8b68c9bd", 0.0f) + op.cmd);
                case 3:
                    fragment.setNextAnim(op.exitAnim);
                    fragmentManagerImpl.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(op.exitAnim);
                    fragmentManagerImpl.getClass();
                    if (!fragment.mHidden) {
                        fragment.mHidden = true;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                    }
                    break;
                case 5:
                    fragment.setNextAnim(op.enterAnim);
                    fragmentManagerImpl.getClass();
                    if (fragment.mHidden) {
                        fragment.mHidden = false;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                    }
                    break;
                case 6:
                    fragment.setNextAnim(op.exitAnim);
                    fragmentManagerImpl.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(op.enterAnim);
                    fragmentManagerImpl.attachFragment(fragment);
                    break;
                case 8:
                    fragmentManagerImpl.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    fragmentManagerImpl.mPrimaryNav = null;
                    break;
            }
            if (!this.mReorderingAllowed && op.cmd != 1 && fragment != null) {
                fragmentManagerImpl.moveFragmentToExpectedState(fragment);
            }
            i++;
        }
    }

    public final void executePopOps(boolean z) {
        ArrayList arrayList = this.mOps;
        int size = arrayList.size() - 1;
        while (true) {
            FragmentManagerImpl fragmentManagerImpl = this.mManager;
            if (size < 0) {
                if (this.mReorderingAllowed || !z) {
                    return;
                }
                fragmentManagerImpl.moveToState(fragmentManagerImpl.mCurState, true);
                return;
            }
            Op op = (Op) arrayList.get(size);
            Fragment fragment = op.fragment;
            if (fragment != null) {
                int i = this.mTransition;
                int i2 = FragmentManagerImpl.$r8$clinit;
                int i3 = 8194;
                if (i != 4097) {
                    i3 = i != 4099 ? i != 8194 ? 0 : 4097 : 4099;
                }
                int i4 = this.mTransitionStyle;
                if (fragment.mAnimationInfo != null || i3 != 0 || i4 != 0) {
                    fragment.ensureAnimationInfo();
                    Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
                    animationInfo.mNextTransition = i3;
                    animationInfo.mNextTransitionStyle = i4;
                }
            }
            switch (op.cmd) {
                case 1:
                    fragment.setNextAnim(op.popExitAnim);
                    fragmentManagerImpl.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException(C0000.decode(new byte[]{48, 89, 9, 10, 94, 70, 93, 25, 6, 90, 6, 94, 17}, "e7bd1139", 0.0f) + op.cmd);
                case 3:
                    fragment.setNextAnim(op.popEnterAnim);
                    fragmentManagerImpl.addFragment(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(op.popEnterAnim);
                    fragmentManagerImpl.getClass();
                    if (fragment.mHidden) {
                        fragment.mHidden = false;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                    }
                    break;
                case 5:
                    fragment.setNextAnim(op.popExitAnim);
                    fragmentManagerImpl.getClass();
                    if (!fragment.mHidden) {
                        fragment.mHidden = true;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                    }
                    break;
                case 6:
                    fragment.setNextAnim(op.popEnterAnim);
                    fragmentManagerImpl.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(op.popExitAnim);
                    fragmentManagerImpl.detachFragment(fragment);
                    break;
                case 8:
                    fragmentManagerImpl.mPrimaryNav = null;
                    break;
                case 9:
                    fragmentManagerImpl.setPrimaryNavigationFragment(fragment);
                    break;
            }
            if (!this.mReorderingAllowed && op.cmd != 3 && fragment != null) {
                fragmentManagerImpl.moveFragmentToExpectedState(fragment);
            }
            size--;
        }
    }

    @Override // androidx.fragment.app.FragmentManagerImpl.OpGenerator
    public final boolean generateOps(ArrayList arrayList, ArrayList arrayList2) {
        int i = FragmentManagerImpl.$r8$clinit;
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.mAddToBackStack) {
            return true;
        }
        FragmentManagerImpl fragmentManagerImpl = this.mManager;
        if (fragmentManagerImpl.mBackStack == null) {
            fragmentManagerImpl.mBackStack = new ArrayList();
        }
        fragmentManagerImpl.mBackStack.add(this);
        return true;
    }

    public final boolean interactsWith(ArrayList arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        ArrayList arrayList2 = this.mOps;
        int size = arrayList2.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = ((Op) arrayList2.get(i4)).fragment;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i6);
                    int size2 = backStackRecord.mOps.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = ((Op) backStackRecord.mOps.get(i7)).fragment;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(C0000.decode(new byte[]{123, 4, 1, 91, 50, 18, 88, 0, 13, 39, 93, 16, 71, 75, 29}, "9eb0af9cfb3d52ff", true));
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(C0000.decode(new byte[]{18, 20}, "2783bf79cfb81b", 7));
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(C0000.decode(new byte[]{68}, "d77a8b", 0.0f));
            sb.append(this.mName);
        }
        sb.append(C0000.decode(new byte[]{68}, "9a0ccbdf33", 0.0f));
        return sb.toString();
    }
}
