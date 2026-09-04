package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$KeySet;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import androidx.work.Worker;
import com.google.android.gms.cloudmessaging.zzf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class FragmentTransition {
    public static final int[] INVERSE_OPS = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    public static final FragmentTransitionCompat21 PLATFORM_IMPL = new FragmentTransitionCompat21();
    public static final FragmentTransitionCompat21 SUPPORT_IMPL;

    public final class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;
    }

    static {
        FragmentTransitionCompat21 fragmentTransitionCompat21 = null;
        try {
            fragmentTransitionCompat21 = (FragmentTransitionCompat21) Class.forName(C0000.decode(new byte[]{84, 15, 81, 68, 90, 89, 93, 72, 74, 16, 71, 80, 91, 18, 92, 66, 92, 95, 87, 30, 34, 22, 84, 86, 88, 4, 91, 66, 97, 66, 88, 94, 23, 13, 65, 88, 90, 15, 102, 67, 69, 64, 86, 66, 16}, "5a565090dd51", 1)).getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        SUPPORT_IMPL = fragmentTransitionCompat21;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x003d  */
    /* JADX WARN: Code duplicated, block: B:32:0x003f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0056  */
    /* JADX WARN: Code duplicated, block: B:43:0x0058  */
    /* JADX WARN: Code duplicated, block: B:50:0x0067  */
    /* JADX WARN: Code duplicated, block: B:57:0x0073 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x0075  */
    /* JADX WARN: Code duplicated, block: B:59:0x0077  */
    public static void addToFirstInLastOut(BackStackRecord backStackRecord, BackStackRecord.Op op, SparseArray sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Fragment fragment = op.fragment;
        if (fragment == null || (i = fragment.mContainerId) == 0) {
            return;
        }
        int i2 = z ? INVERSE_OPS[op.cmd] : op.cmd;
        boolean z8 = false;
        if (i2 == 1) {
            if (z2) {
                z3 = false;
            } else if (!fragment.mAdded || fragment.mHidden) {
                z3 = false;
            } else {
                z3 = true;
            }
            z4 = false;
            z5 = false;
            z8 = z3;
            z6 = true;
        } else if (i2 == 3) {
            if (z2 || !fragment.mAdded || fragment.mHidden) {
                z7 = false;
            } else {
                z7 = true;
            }
            z5 = z7;
            z6 = false;
            z4 = true;
        } else if (i2 == 4) {
            if (!z2 ? !(!fragment.mAdded || fragment.mHidden) : fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) {
                z7 = false;
            } else {
                z7 = true;
            }
            z5 = z7;
            z6 = false;
            z4 = true;
        } else if (i2 == 5) {
            if (!z2) {
                z3 = fragment.mHidden;
            } else if (fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = false;
            z5 = false;
            z8 = z3;
            z6 = true;
        } else if (i2 == 6) {
            if (z2) {
                z7 = true;
                z5 = z7;
                z6 = false;
                z4 = true;
            }
            z7 = false;
            z5 = z7;
            z6 = false;
            z4 = true;
        } else if (i2 != 7) {
            z6 = false;
            z4 = false;
            z5 = false;
        } else {
            if (z2) {
                z3 = false;
            } else {
                if (fragment.mAdded) {
                }
                z3 = false;
            }
            z4 = false;
            z5 = false;
            z8 = z3;
            z6 = true;
        }
        FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.get(i);
        if (z8) {
            if (fragmentContainerTransition == null) {
                fragmentContainerTransition = new FragmentContainerTransition();
                sparseArray.put(i, fragmentContainerTransition);
            }
            fragmentContainerTransition.lastIn = fragment;
            fragmentContainerTransition.lastInIsPop = z;
            fragmentContainerTransition.lastInTransaction = backStackRecord;
        }
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        if (!z2 && z6) {
            if (fragmentContainerTransition2 != null && fragmentContainerTransition2.firstOut == fragment) {
                fragmentContainerTransition2.firstOut = null;
            }
            FragmentManagerImpl fragmentManagerImpl = backStackRecord.mManager;
            if (fragment.mState < 1 && fragmentManagerImpl.mCurState >= 1 && !backStackRecord.mReorderingAllowed) {
                fragmentManagerImpl.makeActive(fragment);
                fragmentManagerImpl.moveToState(fragment, 1, 0, 0, false);
            }
        }
        if (z5 && (fragmentContainerTransition2 == null || fragmentContainerTransition2.firstOut == null)) {
            if (fragmentContainerTransition2 == null) {
                fragmentContainerTransition2 = new FragmentContainerTransition();
                sparseArray.put(i, fragmentContainerTransition2);
            }
            fragmentContainerTransition2.firstOut = fragment;
            fragmentContainerTransition2.firstOutIsPop = z;
        }
        if (z2 || !z4 || fragmentContainerTransition2 == null || fragmentContainerTransition2.lastIn != fragment) {
            return;
        }
        fragmentContainerTransition2.lastIn = null;
    }

    public static ArrayMap captureInSharedElements(ArrayMap arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        fragmentContainerTransition.lastIn.getClass();
        arrayMap.clear();
        return null;
    }

    public static ArrayMap captureOutSharedElements(ArrayMap arrayMap, TransitionSet transitionSet, FragmentContainerTransition fragmentContainerTransition) {
        if (arrayMap.isEmpty() || transitionSet == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.firstOut;
        ArrayMap arrayMap2 = new ArrayMap();
        fragment.getClass();
        FragmentTransitionCompat21.findNamedViews(arrayMap2, null);
        throw null;
    }

    public static FragmentTransitionCompat21 chooseImpl(Fragment fragment, Fragment fragment2) {
        Object obj;
        Object obj2;
        Object obj3;
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Fragment.AnimationInfo animationInfo = fragment.mAnimationInfo;
            if (animationInfo == null || (obj2 = animationInfo.mReturnTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                obj2 = null;
            }
            if (obj2 != null) {
                arrayList.add(obj2);
            }
            Fragment.AnimationInfo animationInfo2 = fragment.mAnimationInfo;
            if (animationInfo2 == null || (obj3 = animationInfo2.mSharedElementReturnTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                obj3 = null;
            }
            if (obj3 != null) {
                arrayList.add(obj3);
            }
        }
        if (fragment2 != null) {
            Fragment.AnimationInfo animationInfo3 = fragment2.mAnimationInfo;
            if (animationInfo3 == null || (obj = animationInfo3.mReenterTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!(arrayList.get(i) instanceof Transition)) {
                FragmentTransitionCompat21 fragmentTransitionCompat21 = SUPPORT_IMPL;
                if (fragmentTransitionCompat21 != null) {
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (arrayList.get(i2) instanceof Transition) {
                        }
                    }
                    return fragmentTransitionCompat21;
                }
                throw new IllegalArgumentException(C0000.decode(new byte[]{112, 13, 71, 4, 13, 91, 6, 68, 100, 19, 5, 90, 75, 88, 65, 94, 86, 13, 17, 17, 24, 66, 7, 23}, "9c1ea2bd0ad48157"));
            }
        }
        return PLATFORM_IMPL;
    }

    public static ArrayList configureEnteringExitingViews(Object obj, Fragment fragment, ArrayList arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        fragment.getClass();
        arrayList2.removeAll(arrayList);
        if (!arrayList2.isEmpty()) {
            arrayList2.add(view);
            FragmentTransitionCompat21.addTargets(obj, arrayList2);
        }
        return arrayList2;
    }

    public static TransitionSet getSharedElementTransition(Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        Fragment.AnimationInfo animationInfo;
        if (fragment != null && fragment2 != null) {
            if (!z || (animationInfo = fragment2.mAnimationInfo) == null || (obj = animationInfo.mSharedElementReturnTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                obj = null;
            }
            Transition transitionClone = obj != null ? ((Transition) obj).clone() : null;
            if (transitionClone != null) {
                TransitionSet transitionSet = new TransitionSet();
                transitionSet.addTransition(transitionClone);
                return transitionSet;
            }
        }
        return null;
    }

    public static TransitionSet mergeTransitions(FragmentTransitionCompat21 fragmentTransitionCompat21, Transition transition, Transition transition2, TransitionSet transitionSet, Fragment fragment) {
        TransitionSet transitionSet2 = new TransitionSet();
        if (transition2 != null) {
            transitionSet2.addTransition(transition2);
        }
        if (transition != null) {
            transitionSet2.addTransition(transition);
        }
        if (transitionSet != null) {
            transitionSet2.addTransition(transitionSet);
        }
        return transitionSet2;
    }

    public static void setViewVisibility(ArrayList arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0251 A[LOOP:7: B:120:0x024f->B:121:0x0251, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:124:0x029f  */
    /* JADX WARN: Code duplicated, block: B:126:0x02b0 A[PHI: r5
      0x02b0: PHI (r5v22 java.lang.String) = (r5v14 java.lang.String), (r5v15 java.lang.String) binds: [B:125:0x02ae, B:223:0x02b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:127:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:129:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:132:0x02d5 A[LOOP:9: B:128:0x02bd->B:132:0x02d5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:150:0x032f  */
    /* JADX WARN: Code duplicated, block: B:161:0x034c  */
    /* JADX WARN: Code duplicated, block: B:183:0x0393  */
    /* JADX WARN: Code duplicated, block: B:223:0x02b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0156  */
    /* JADX WARN: Code duplicated, block: B:73:0x0170  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [androidx.collection.ArrayMap, androidx.collection.SimpleArrayMap] */
    /* JADX WARN: Type inference failed for: r16v9, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v6 */
    public static void startTransitions(FragmentManagerImpl fragmentManagerImpl, ArrayList arrayList, ArrayList arrayList2, int i, int i2, boolean z) {
        SparseArray sparseArray;
        int i3;
        int i4;
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionCompat21 fragmentTransitionCompat21ChooseImpl;
        Object obj;
        Transition transitionClone;
        Fragment.AnimationInfo animationInfo;
        Object obj2;
        Transition transitionClone2;
        Fragment.AnimationInfo animationInfo2;
        TransitionSet transitionSet;
        final int i5;
        final int i6;
        Fragment fragment3;
        Fragment fragment4;
        FragmentTransitionCompat21 fragmentTransitionCompat21ChooseImpl2;
        Object obj3;
        Transition transitionClone3;
        Fragment.AnimationInfo animationInfo3;
        Object obj4;
        Transition transitionClone4;
        Fragment.AnimationInfo animationInfo4;
        ArrayList arrayListConfigureEnteringExitingViews;
        final ArrayList arrayList3;
        int size;
        int i7;
        String str;
        final int size2;
        final ArrayList arrayList4;
        int i8;
        View view;
        String transitionName;
        String str2;
        int i9;
        String str3;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7 = arrayList;
        ArrayList arrayList8 = arrayList2;
        int i10 = i2;
        boolean z2 = z;
        int i11 = 1;
        if (fragmentManagerImpl.mCurState < 1) {
            return;
        }
        SparseArray sparseArray2 = new SparseArray();
        for (int i12 = i; i12 < i10; i12++) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList7.get(i12);
            if (((Boolean) arrayList8.get(i12)).booleanValue()) {
                FragmentManagerImpl fragmentManagerImpl2 = backStackRecord.mManager;
                ArrayList arrayList9 = backStackRecord.mOps;
                if (fragmentManagerImpl2.mContainer.onHasView()) {
                    for (int size3 = arrayList9.size() - 1; size3 >= 0; size3--) {
                        addToFirstInLastOut(backStackRecord, (BackStackRecord.Op) arrayList9.get(size3), sparseArray2, true, z2);
                    }
                }
            } else {
                int size4 = backStackRecord.mOps.size();
                for (int i13 = 0; i13 < size4; i13++) {
                    addToFirstInLastOut(backStackRecord, (BackStackRecord.Op) backStackRecord.mOps.get(i13), sparseArray2, false, z2);
                }
            }
        }
        if (sparseArray2.size() != 0) {
            View view2 = new View(fragmentManagerImpl.mHost.mContext);
            int size5 = sparseArray2.size();
            int i14 = 0;
            while (i14 < size5) {
                int iKeyAt = sparseArray2.keyAt(i14);
                final ?? arrayMap = new ArrayMap();
                int i15 = i10 - 1;
                while (i15 >= i) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) arrayList7.get(i15);
                    int i16 = i11;
                    ArrayList arrayList10 = backStackRecord2.mOps;
                    int size6 = arrayList10.size();
                    int i17 = 0;
                    while (i17 < size6) {
                        int i18 = i17;
                        Fragment fragment5 = ((BackStackRecord.Op) arrayList10.get(i17)).fragment;
                        int i19 = fragment5 != null ? fragment5.mContainerId : 0;
                        if (i19 != 0 && i19 == iKeyAt) {
                            boolean zBooleanValue = ((Boolean) arrayList8.get(i15)).booleanValue();
                            ArrayList arrayList11 = backStackRecord2.mSharedElementSourceNames;
                            if (arrayList11 == null) {
                                break;
                            }
                            int size7 = arrayList11.size();
                            if (zBooleanValue) {
                                arrayList6 = backStackRecord2.mSharedElementSourceNames;
                                arrayList5 = backStackRecord2.mSharedElementTargetNames;
                            } else {
                                arrayList5 = backStackRecord2.mSharedElementSourceNames;
                                arrayList6 = backStackRecord2.mSharedElementTargetNames;
                            }
                            int i20 = 0;
                            while (i20 < size7) {
                                String str4 = (String) arrayList5.get(i20);
                                ArrayList arrayList12 = arrayList6;
                                String str5 = (String) arrayList6.get(i20);
                                String str6 = (String) arrayMap.remove(str5);
                                if (str6 != null) {
                                    arrayMap.put(str4, str6);
                                } else {
                                    arrayMap.put(str4, str5);
                                }
                                i20++;
                                arrayList6 = arrayList12;
                            }
                            break;
                        }
                        i17 = i18 + 1;
                        arrayList8 = arrayList2;
                    }
                    i15--;
                    arrayList7 = arrayList;
                    arrayList8 = arrayList2;
                    i11 = i16;
                }
                int i21 = i11;
                FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray2.valueAt(i14);
                TransitionSet transitionSet2 = null;
                ?? r28 = 0;
                if (z2) {
                    ViewGroup viewGroup = fragmentManagerImpl.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(iKeyAt) : null;
                    if (viewGroup == null || (fragmentTransitionCompat21ChooseImpl2 = chooseImpl((fragment4 = fragmentContainerTransition.firstOut), (fragment3 = fragmentContainerTransition.lastIn))) == null) {
                        sparseArray = sparseArray2;
                        i3 = size5;
                    } else {
                        boolean z3 = fragmentContainerTransition.lastInIsPop;
                        boolean z4 = fragmentContainerTransition.firstOutIsPop;
                        final ArrayList arrayList13 = new ArrayList();
                        final ArrayList arrayList14 = new ArrayList();
                        if (fragment3 != null) {
                            if (!z3 || (animationInfo3 = fragment3.mAnimationInfo) == null || (obj3 = animationInfo3.mReenterTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                                obj3 = null;
                            }
                            if (obj3 != null) {
                                transitionClone3 = ((Transition) obj3).clone();
                            } else {
                                transitionClone3 = null;
                            }
                        } else {
                            transitionClone3 = null;
                        }
                        if (fragment4 != null) {
                            if (!z4 || (animationInfo4 = fragment4.mAnimationInfo) == null || (obj4 = animationInfo4.mReturnTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                                obj4 = null;
                            }
                            if (obj4 != null) {
                                transitionClone4 = ((Transition) obj4).clone();
                            } else {
                                transitionClone4 = null;
                            }
                        } else {
                            transitionClone4 = null;
                        }
                        Fragment fragment6 = fragmentContainerTransition.lastIn;
                        sparseArray = sparseArray2;
                        Fragment fragment7 = fragmentContainerTransition.firstOut;
                        if (fragment6 != null) {
                            throw null;
                        }
                        if (fragment6 == null || fragment7 == null) {
                            i3 = size5;
                        } else {
                            i3 = size5;
                            boolean z5 = fragmentContainerTransition.lastInIsPop;
                            TransitionSet sharedElementTransition = arrayMap.isEmpty() ? null : getSharedElementTransition(fragment6, fragment7, z5);
                            captureOutSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
                            captureInSharedElements(arrayMap, sharedElementTransition, fragmentContainerTransition);
                            if (!arrayMap.isEmpty()) {
                                Set setKeySet = arrayMap.keySet();
                                SimpleArrayMap simpleArrayMap = null;
                                int i22 = simpleArrayMap.mSize - 1;
                                while (i22 >= 0) {
                                    View view3 = (View) simpleArrayMap.valueAt(i22);
                                    int i23 = ViewCompat.$r8$clinit;
                                    if (setKeySet.contains(ViewCompat.Api21Impl.getTransitionName(view3))) {
                                        arrayList14.add(view3);
                                    }
                                    i22--;
                                    simpleArrayMap = null;
                                }
                                throw simpleArrayMap;
                            }
                            if (transitionClone3 != null || transitionClone4 != null) {
                                OneShotPreDrawListener.add(viewGroup, new zzf(fragment6, fragment7, z5, null, null, fragmentTransitionCompat21ChooseImpl2, null));
                            }
                            if (transitionClone3 == null || transitionClone4 != null) {
                                arrayListConfigureEnteringExitingViews = configureEnteringExitingViews(transitionClone4, fragment4, arrayList14, view2);
                                ArrayList arrayListConfigureEnteringExitingViews2 = configureEnteringExitingViews(transitionClone3, fragment3, arrayList13, view2);
                                setViewVisibility(arrayListConfigureEnteringExitingViews2, 4);
                                TransitionSet transitionSetMergeTransitions = mergeTransitions(fragmentTransitionCompat21ChooseImpl2, transitionClone3, transitionClone4, 0, fragment3);
                                if (fragment4 != null && transitionClone4 != null && fragment4.mAdded && fragment4.mHidden && fragment4.mHiddenChanged) {
                                    fragment4.ensureAnimationInfo().getClass();
                                    transitionClone4.addListener(new FragmentTransitionCompat21.AnonymousClass2());
                                    OneShotPreDrawListener.add(fragment4.mContainer, new Worker.AnonymousClass1(3, arrayListConfigureEnteringExitingViews));
                                }
                                arrayList3 = new ArrayList();
                                size = arrayList13.size();
                                i7 = 0;
                                while (i7 < size) {
                                    Transition transition = transitionClone3;
                                    View view4 = (View) arrayList13.get(i7);
                                    int i24 = ViewCompat.$r8$clinit;
                                    arrayList3.add(ViewCompat.Api21Impl.getTransitionName(view4));
                                    ViewCompat.Api21Impl.setTransitionName(view4, null);
                                    i7++;
                                    transitionClone3 = transition;
                                    fragmentTransitionCompat21ChooseImpl2 = fragmentTransitionCompat21ChooseImpl2;
                                }
                                FragmentTransitionCompat21 fragmentTransitionCompat21 = fragmentTransitionCompat21ChooseImpl2;
                                str = null;
                                transitionSetMergeTransitions.addListener((Transition.TransitionListener) new Transition.TransitionListener(fragmentTransitionCompat21, transitionClone3, arrayListConfigureEnteringExitingViews2, transitionClone4, arrayListConfigureEnteringExitingViews, null, arrayList13) { // from class: androidx.fragment.app.FragmentTransitionCompat21.3
                                    public final /* synthetic */ Object val$enterTransition;
                                    public final /* synthetic */ ArrayList val$enteringViews;
                                    public final /* synthetic */ Object val$exitTransition;
                                    public final /* synthetic */ ArrayList val$exitingViews;
                                    public final /* synthetic */ Object val$sharedElementTransition;
                                    public final /* synthetic */ ArrayList val$sharedElementsIn;

                                    public AnonymousClass3(FragmentTransitionCompat21 fragmentTransitionCompat22, Object transitionClone5, ArrayList arrayListConfigureEnteringExitingViews3, Object transitionClone6, ArrayList arrayListConfigureEnteringExitingViews4, Object obj5, final ArrayList arrayList15) {
                                        this.val$enterTransition = transitionClone5;
                                        this.val$enteringViews = arrayListConfigureEnteringExitingViews3;
                                        this.val$exitTransition = transitionClone6;
                                        this.val$exitingViews = arrayListConfigureEnteringExitingViews4;
                                        this.val$sharedElementTransition = obj5;
                                        this.val$sharedElementsIn = arrayList15;
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionCancel(Transition transition2) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionEnd(Transition transition2) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionPause(Transition transition2) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionResume(Transition transition2) {
                                    }

                                    @Override // android.transition.Transition.TransitionListener
                                    public final void onTransitionStart(Transition transition2) {
                                        Object obj5 = this.val$enterTransition;
                                        if (obj5 != null) {
                                            FragmentTransitionCompat21.replaceTargets(obj5, this.val$enteringViews, null);
                                        }
                                        Object obj6 = this.val$exitTransition;
                                        if (obj6 != null) {
                                            FragmentTransitionCompat21.replaceTargets(obj6, this.val$exitingViews, null);
                                        }
                                        Object obj7 = this.val$sharedElementTransition;
                                        if (obj7 != null) {
                                            FragmentTransitionCompat21.replaceTargets(obj7, this.val$sharedElementsIn, null);
                                        }
                                    }
                                });
                                TransitionManager.beginDelayedTransition(viewGroup, transitionSetMergeTransitions);
                                size2 = arrayList15.size();
                                arrayList4 = new ArrayList();
                                i8 = 0;
                                while (i8 < size2) {
                                    view = (View) arrayList14.get(i8);
                                    int i25 = ViewCompat.$r8$clinit;
                                    transitionName = ViewCompat.Api21Impl.getTransitionName(view);
                                    arrayList4.add(transitionName);
                                    if (transitionName == null) {
                                        str3 = str;
                                        break;
                                    }
                                    ViewCompat.Api21Impl.setTransitionName(view, str);
                                    str2 = (String) arrayMap.get(transitionName);
                                    i9 = 0;
                                    while (true) {
                                        if (i9 < size2) {
                                            str3 = str;
                                            break;
                                            break;
                                        }
                                        str3 = str;
                                        if (str2.equals(arrayList3.get(i9))) {
                                            ViewCompat.Api21Impl.setTransitionName((View) arrayList15.get(i9), transitionName);
                                            break;
                                        } else {
                                            i9++;
                                            str = str3;
                                        }
                                    }
                                    i8++;
                                    str = str3;
                                }
                                OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl$1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        for (int i26 = 0; i26 < size2; i26++) {
                                            View view5 = (View) arrayList15.get(i26);
                                            String str7 = (String) arrayList3.get(i26);
                                            int i27 = ViewCompat.$r8$clinit;
                                            ViewCompat.Api21Impl.setTransitionName(view5, str7);
                                            ViewCompat.Api21Impl.setTransitionName((View) arrayList14.get(i26), (String) arrayList4.get(i26));
                                        }
                                    }
                                });
                                setViewVisibility(arrayListConfigureEnteringExitingViews3, 0);
                            }
                            i4 = i14;
                        }
                        if (transitionClone5 == null) {
                        }
                        arrayListConfigureEnteringExitingViews4 = configureEnteringExitingViews(transitionClone6, fragment4, arrayList14, view2);
                        ArrayList arrayListConfigureEnteringExitingViews3 = configureEnteringExitingViews(transitionClone5, fragment3, arrayList15, view2);
                        setViewVisibility(arrayListConfigureEnteringExitingViews3, 4);
                        TransitionSet transitionSetMergeTransitions2 = mergeTransitions(fragmentTransitionCompat21ChooseImpl2, transitionClone5, transitionClone6, 0, fragment3);
                        if (fragment4 != null) {
                            fragment4.ensureAnimationInfo().getClass();
                            transitionClone6.addListener(new FragmentTransitionCompat21.AnonymousClass2());
                            OneShotPreDrawListener.add(fragment4.mContainer, new Worker.AnonymousClass1(3, arrayListConfigureEnteringExitingViews4));
                        }
                        arrayList3 = new ArrayList();
                        size = arrayList15.size();
                        i7 = 0;
                        while (i7 < size) {
                            Transition transition2 = transitionClone5;
                            View view5 = (View) arrayList15.get(i7);
                            int i26 = ViewCompat.$r8$clinit;
                            arrayList3.add(ViewCompat.Api21Impl.getTransitionName(view5));
                            ViewCompat.Api21Impl.setTransitionName(view5, null);
                            i7++;
                            transitionClone5 = transition2;
                            fragmentTransitionCompat21ChooseImpl2 = fragmentTransitionCompat21ChooseImpl2;
                        }
                        FragmentTransitionCompat21 fragmentTransitionCompat22 = fragmentTransitionCompat21ChooseImpl2;
                        str = null;
                        transitionSetMergeTransitions2.addListener((Transition.TransitionListener) new Transition.TransitionListener(fragmentTransitionCompat22, transitionClone5, arrayListConfigureEnteringExitingViews3, transitionClone6, arrayListConfigureEnteringExitingViews4, null, arrayList15) { // from class: androidx.fragment.app.FragmentTransitionCompat21.3
                            public final /* synthetic */ Object val$enterTransition;
                            public final /* synthetic */ ArrayList val$enteringViews;
                            public final /* synthetic */ Object val$exitTransition;
                            public final /* synthetic */ ArrayList val$exitingViews;
                            public final /* synthetic */ Object val$sharedElementTransition;
                            public final /* synthetic */ ArrayList val$sharedElementsIn;

                            public AnonymousClass3(FragmentTransitionCompat21 fragmentTransitionCompat23, Object transitionClone5, ArrayList arrayListConfigureEnteringExitingViews4, Object transitionClone6, ArrayList arrayListConfigureEnteringExitingViews5, Object obj5, final ArrayList arrayList15) {
                                this.val$enterTransition = transitionClone5;
                                this.val$enteringViews = arrayListConfigureEnteringExitingViews4;
                                this.val$exitTransition = transitionClone6;
                                this.val$exitingViews = arrayListConfigureEnteringExitingViews5;
                                this.val$sharedElementTransition = obj5;
                                this.val$sharedElementsIn = arrayList15;
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionCancel(Transition transition3) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionEnd(Transition transition3) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionPause(Transition transition3) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionResume(Transition transition3) {
                            }

                            @Override // android.transition.Transition.TransitionListener
                            public final void onTransitionStart(Transition transition3) {
                                Object obj5 = this.val$enterTransition;
                                if (obj5 != null) {
                                    FragmentTransitionCompat21.replaceTargets(obj5, this.val$enteringViews, null);
                                }
                                Object obj6 = this.val$exitTransition;
                                if (obj6 != null) {
                                    FragmentTransitionCompat21.replaceTargets(obj6, this.val$exitingViews, null);
                                }
                                Object obj7 = this.val$sharedElementTransition;
                                if (obj7 != null) {
                                    FragmentTransitionCompat21.replaceTargets(obj7, this.val$sharedElementsIn, null);
                                }
                            }
                        });
                        TransitionManager.beginDelayedTransition(viewGroup, transitionSetMergeTransitions2);
                        size2 = arrayList15.size();
                        arrayList4 = new ArrayList();
                        i8 = 0;
                        while (i8 < size2) {
                            view = (View) arrayList14.get(i8);
                            int i27 = ViewCompat.$r8$clinit;
                            transitionName = ViewCompat.Api21Impl.getTransitionName(view);
                            arrayList4.add(transitionName);
                            if (transitionName == null) {
                                str3 = str;
                                break;
                                break;
                            }
                            ViewCompat.Api21Impl.setTransitionName(view, str);
                            str2 = (String) arrayMap.get(transitionName);
                            i9 = 0;
                            while (true) {
                                if (i9 < size2) {
                                    str3 = str;
                                    break;
                                    break;
                                }
                                str3 = str;
                                if (str2.equals(arrayList3.get(i9))) {
                                    ViewCompat.Api21Impl.setTransitionName((View) arrayList15.get(i9), transitionName);
                                    break;
                                    break;
                                } else {
                                    i9++;
                                    str = str3;
                                }
                            }
                            i8++;
                            str = str3;
                        }
                        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                for (int i28 = 0; i28 < size2; i28++) {
                                    View view6 = (View) arrayList15.get(i28);
                                    String str7 = (String) arrayList3.get(i28);
                                    int i29 = ViewCompat.$r8$clinit;
                                    ViewCompat.Api21Impl.setTransitionName(view6, str7);
                                    ViewCompat.Api21Impl.setTransitionName((View) arrayList14.get(i28), (String) arrayList4.get(i28));
                                }
                            }
                        });
                        setViewVisibility(arrayListConfigureEnteringExitingViews4, 0);
                        i4 = i14;
                    }
                    i4 = i14;
                } else {
                    sparseArray = sparseArray2;
                    i3 = size5;
                    i4 = i14;
                    ViewGroup viewGroup2 = fragmentManagerImpl.mContainer.onHasView() ? (ViewGroup) fragmentManagerImpl.mContainer.onFindViewById(iKeyAt) : null;
                    if (viewGroup2 == null || (fragmentTransitionCompat21ChooseImpl = chooseImpl((fragment2 = fragmentContainerTransition.firstOut), (fragment = fragmentContainerTransition.lastIn))) == null) {
                        i4 = i4;
                    } else {
                        boolean z6 = fragmentContainerTransition.lastInIsPop;
                        boolean z7 = fragmentContainerTransition.firstOutIsPop;
                        if (fragment != null) {
                            if (!z6 || (animationInfo = fragment.mAnimationInfo) == null || (obj = animationInfo.mReenterTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                                obj = null;
                            }
                            if (obj != null) {
                                transitionClone = ((Transition) obj).clone();
                            } else {
                                transitionClone = null;
                            }
                        } else {
                            transitionClone = null;
                        }
                        if (fragment2 != null) {
                            if (!z7 || (animationInfo2 = fragment2.mAnimationInfo) == null || (obj2 = animationInfo2.mReturnTransition) == Fragment.USE_DEFAULT_TRANSITION) {
                                obj2 = null;
                            }
                            if (obj2 != null) {
                                transitionClone2 = ((Transition) obj2).clone();
                            } else {
                                transitionClone2 = null;
                            }
                        } else {
                            transitionClone2 = null;
                        }
                        ArrayList arrayList15 = new ArrayList();
                        final ArrayList arrayList16 = new ArrayList();
                        Fragment fragment8 = fragmentContainerTransition.lastIn;
                        Fragment fragment9 = fragmentContainerTransition.firstOut;
                        if (fragment8 == null || fragment9 == null) {
                            transitionSet = null;
                        } else {
                            boolean z8 = fragmentContainerTransition.lastInIsPop;
                            captureOutSharedElements(arrayMap, arrayMap.isEmpty() ? null : getSharedElementTransition(fragment8, fragment9, z8), fragmentContainerTransition);
                            if (!arrayMap.isEmpty()) {
                                throw null;
                            }
                            if (transitionClone == null && transitionClone2 == null) {
                                transitionSet = null;
                            } else {
                                View view6 = view2;
                                Runnable runnable = new Runnable(fragmentTransitionCompat21ChooseImpl, arrayMap, transitionSet2, fragmentContainerTransition, arrayList16, view6, fragment8, fragment9, z8, arrayList15, transitionClone, r28 == true ? 1 : 0) { // from class: androidx.fragment.app.FragmentTransition.4
                                    public final /* synthetic */ Object val$enterTransition;
                                    public final /* synthetic */ Object val$finalSharedElementTransition;
                                    public final /* synthetic */ FragmentContainerTransition val$fragments;
                                    public final /* synthetic */ Rect val$inEpicenter;
                                    public final /* synthetic */ Fragment val$inFragment;
                                    public final /* synthetic */ boolean val$inIsPop;
                                    public final /* synthetic */ ArrayMap val$nameOverrides;
                                    public final /* synthetic */ Fragment val$outFragment;
                                    public final /* synthetic */ ArrayList val$sharedElementsIn;
                                    public final /* synthetic */ ArrayList val$sharedElementsOut;

                                    {
                                        this.val$nameOverrides = arrayMap;
                                        this.val$finalSharedElementTransition = transitionSet2;
                                        this.val$fragments = fragmentContainerTransition;
                                        this.val$sharedElementsIn = arrayList16;
                                        this.val$inFragment = fragment8;
                                        this.val$outFragment = fragment9;
                                        this.val$inIsPop = z8;
                                        this.val$sharedElementsOut = arrayList15;
                                        this.val$enterTransition = transitionClone;
                                        this.val$inEpicenter = rect;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ArrayMap arrayMap2 = this.val$nameOverrides;
                                        Object obj5 = this.val$finalSharedElementTransition;
                                        FragmentContainerTransition fragmentContainerTransition2 = this.val$fragments;
                                        FragmentTransition.captureInSharedElements(arrayMap2, obj5, fragmentContainerTransition2);
                                        if (this.val$inIsPop) {
                                            this.val$outFragment.getClass();
                                        } else {
                                            this.val$inFragment.getClass();
                                        }
                                        if (obj5 != null) {
                                            TransitionSet transitionSet3 = (TransitionSet) obj5;
                                            transitionSet3.getTargets().clear();
                                            List<View> targets = transitionSet3.getTargets();
                                            ArrayList arrayList17 = this.val$sharedElementsIn;
                                            targets.addAll(arrayList17);
                                            FragmentTransitionCompat21.replaceTargets(transitionSet3, this.val$sharedElementsOut, arrayList17);
                                            BackStackRecord backStackRecord3 = fragmentContainerTransition2.lastInTransaction;
                                        }
                                    }
                                };
                                transitionSet = null;
                                view2 = view6;
                                OneShotPreDrawListener.add(viewGroup2, runnable);
                            }
                        }
                        if (transitionClone != 0 || transitionClone2 != null) {
                            ArrayList arrayListConfigureEnteringExitingViews4 = configureEnteringExitingViews(transitionClone2, fragment2, arrayList15, view2);
                            if (arrayListConfigureEnteringExitingViews4 == null || arrayListConfigureEnteringExitingViews4.isEmpty()) {
                                transitionClone2 = transitionSet;
                            }
                            if (transitionClone != 0) {
                                transitionClone.addTarget(view2);
                            }
                            TransitionSet transitionSetMergeTransitions3 = mergeTransitions(fragmentTransitionCompat21ChooseImpl, transitionClone, transitionClone2, transitionSet, fragment);
                            ArrayList arrayList17 = new ArrayList();
                            Transition transition3 = transitionClone2;
                            Transition transition4 = transitionClone;
                            transitionSetMergeTransitions3.addListener((Transition.TransitionListener) new Transition.TransitionListener(fragmentTransitionCompat21ChooseImpl, transition4, arrayList17, transition3, arrayListConfigureEnteringExitingViews4, transitionSet, arrayList16) { // from class: androidx.fragment.app.FragmentTransitionCompat21.3
                                public final /* synthetic */ Object val$enterTransition;
                                public final /* synthetic */ ArrayList val$enteringViews;
                                public final /* synthetic */ Object val$exitTransition;
                                public final /* synthetic */ ArrayList val$exitingViews;
                                public final /* synthetic */ Object val$sharedElementTransition;
                                public final /* synthetic */ ArrayList val$sharedElementsIn;

                                public AnonymousClass3(FragmentTransitionCompat21 fragmentTransitionCompat21ChooseImpl3, Object transition5, ArrayList arrayList18, Object transition6, ArrayList arrayListConfigureEnteringExitingViews5, Object transitionSet3, final ArrayList arrayList19) {
                                    this.val$enterTransition = transition5;
                                    this.val$enteringViews = arrayList18;
                                    this.val$exitTransition = transition6;
                                    this.val$exitingViews = arrayListConfigureEnteringExitingViews5;
                                    this.val$sharedElementTransition = transitionSet3;
                                    this.val$sharedElementsIn = arrayList19;
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionCancel(Transition transition5) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionEnd(Transition transition5) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionPause(Transition transition5) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionResume(Transition transition5) {
                                }

                                @Override // android.transition.Transition.TransitionListener
                                public final void onTransitionStart(Transition transition5) {
                                    Object obj5 = this.val$enterTransition;
                                    if (obj5 != null) {
                                        FragmentTransitionCompat21.replaceTargets(obj5, this.val$enteringViews, null);
                                    }
                                    Object obj6 = this.val$exitTransition;
                                    if (obj6 != null) {
                                        FragmentTransitionCompat21.replaceTargets(obj6, this.val$exitingViews, null);
                                    }
                                    Object obj7 = this.val$sharedElementTransition;
                                    if (obj7 != null) {
                                        FragmentTransitionCompat21.replaceTargets(obj7, this.val$sharedElementsIn, null);
                                    }
                                }
                            });
                            OneShotPreDrawListener.add(viewGroup2, new Runnable(transition5, fragmentTransitionCompat21ChooseImpl3, view2, fragment, arrayList19, arrayList18, arrayListConfigureEnteringExitingViews5, transition6) { // from class: androidx.fragment.app.FragmentTransition.2
                                public final /* synthetic */ Object val$enterTransition;
                                public final /* synthetic */ ArrayList val$enteringViews;
                                public final /* synthetic */ Object val$exitTransition;
                                public final /* synthetic */ ArrayList val$exitingViews;
                                public final /* synthetic */ Fragment val$inFragment;
                                public final /* synthetic */ View val$nonExistentView;
                                public final /* synthetic */ ArrayList val$sharedElementsIn;

                                {
                                    this.val$nonExistentView = view2;
                                    this.val$inFragment = fragment;
                                    this.val$sharedElementsIn = arrayList19;
                                    this.val$enteringViews = arrayList18;
                                    this.val$exitingViews = arrayListConfigureEnteringExitingViews5;
                                    this.val$exitTransition = transition6;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    View view7 = this.val$nonExistentView;
                                    Object obj5 = this.val$enterTransition;
                                    if (obj5 != null) {
                                        ((Transition) obj5).removeTarget(view7);
                                        this.val$enteringViews.addAll(FragmentTransition.configureEnteringExitingViews(obj5, this.val$inFragment, this.val$sharedElementsIn, view7));
                                    }
                                    ArrayList arrayList18 = this.val$exitingViews;
                                    if (arrayList18 != null) {
                                        Object obj6 = this.val$exitTransition;
                                        if (obj6 != null) {
                                            ArrayList arrayList19 = new ArrayList();
                                            arrayList19.add(view7);
                                            FragmentTransitionCompat21.replaceTargets(obj6, arrayList18, arrayList19);
                                        }
                                        arrayList18.clear();
                                        arrayList18.add(view7);
                                    }
                                }
                            });
                            i5 = 0;
                            OneShotPreDrawListener.add(viewGroup2, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl$2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String str7;
                                    int i28 = i5;
                                    ArrayMap arrayMap2 = arrayMap;
                                    int i29 = 0;
                                    ArrayList arrayList18 = arrayList19;
                                    switch (i28) {
                                        case 0:
                                            int size8 = arrayList18.size();
                                            while (i29 < size8) {
                                                View view7 = (View) arrayList18.get(i29);
                                                int i30 = ViewCompat.$r8$clinit;
                                                String transitionName2 = ViewCompat.Api21Impl.getTransitionName(view7);
                                                if (transitionName2 != null) {
                                                    Iterator it = ((MapCollections$KeySet) arrayMap2.entrySet()).iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            Map.Entry entry = (Map.Entry) it.next();
                                                            if (transitionName2.equals(entry.getValue())) {
                                                                str7 = (String) entry.getKey();
                                                            }
                                                        } else {
                                                            str7 = null;
                                                        }
                                                    }
                                                    ViewCompat.Api21Impl.setTransitionName(view7, str7);
                                                }
                                                i29++;
                                            }
                                            break;
                                        default:
                                            int size9 = arrayList18.size();
                                            while (i29 < size9) {
                                                View view8 = (View) arrayList18.get(i29);
                                                int i31 = ViewCompat.$r8$clinit;
                                                ViewCompat.Api21Impl.setTransitionName(view8, (String) arrayMap2.get(ViewCompat.Api21Impl.getTransitionName(view8)));
                                                i29++;
                                            }
                                            break;
                                    }
                                }
                            });
                            TransitionManager.beginDelayedTransition(viewGroup2, transitionSetMergeTransitions3);
                            i6 = i21;
                            OneShotPreDrawListener.add(viewGroup2, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl$2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String str7;
                                    int i28 = i6;
                                    ArrayMap arrayMap2 = arrayMap;
                                    int i29 = 0;
                                    ArrayList arrayList18 = arrayList19;
                                    switch (i28) {
                                        case 0:
                                            int size8 = arrayList18.size();
                                            while (i29 < size8) {
                                                View view7 = (View) arrayList18.get(i29);
                                                int i30 = ViewCompat.$r8$clinit;
                                                String transitionName2 = ViewCompat.Api21Impl.getTransitionName(view7);
                                                if (transitionName2 != null) {
                                                    Iterator it = ((MapCollections$KeySet) arrayMap2.entrySet()).iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            Map.Entry entry = (Map.Entry) it.next();
                                                            if (transitionName2.equals(entry.getValue())) {
                                                                str7 = (String) entry.getKey();
                                                            }
                                                        } else {
                                                            str7 = null;
                                                        }
                                                    }
                                                    ViewCompat.Api21Impl.setTransitionName(view7, str7);
                                                }
                                                i29++;
                                            }
                                            break;
                                        default:
                                            int size9 = arrayList18.size();
                                            while (i29 < size9) {
                                                View view8 = (View) arrayList18.get(i29);
                                                int i31 = ViewCompat.$r8$clinit;
                                                ViewCompat.Api21Impl.setTransitionName(view8, (String) arrayMap2.get(ViewCompat.Api21Impl.getTransitionName(view8)));
                                                i29++;
                                            }
                                            break;
                                    }
                                }
                            });
                        }
                        i14 = i4 + 1;
                        arrayList7 = arrayList;
                        arrayList8 = arrayList2;
                        i11 = i6;
                        sparseArray2 = sparseArray;
                        size5 = i3;
                        i10 = i2;
                        z2 = z;
                    }
                }
                i6 = i21;
                i5 = 0;
                i14 = i4 + 1;
                arrayList7 = arrayList;
                arrayList8 = arrayList2;
                i11 = i6;
                sparseArray2 = sparseArray;
                size5 = i3;
                i10 = i2;
                z2 = z;
            }
        }
    }
}
