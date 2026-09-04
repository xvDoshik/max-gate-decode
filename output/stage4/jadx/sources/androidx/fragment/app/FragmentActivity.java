package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.collection.ContainerHelpers;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport$DEFAULT_ARGS_KEY$1;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras$Empty;
import androidx.loader.app.LoaderManagerImpl$LoaderViewModel;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class FragmentActivity extends ComponentActivity implements ViewModelStoreOwner {
    public boolean mCreated;
    public int mNextCandidateRequestIndex;
    public SparseArrayCompat mPendingFragmentActivityResults;
    public boolean mResumed;
    public ViewModelStore mViewModelStore;
    public final AnonymousClass1 mHandler = new Handler() { // from class: androidx.fragment.app.FragmentActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ConnectionPool connectionPool = FragmentActivity.this.mFragments;
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            FragmentManagerImpl fragmentManagerImpl = ((HostCallbacks) connectionPool.delegate).mFragmentManager;
            fragmentManagerImpl.mStateSaved = false;
            fragmentManagerImpl.mStopped = false;
            fragmentManagerImpl.dispatchStateChange(4);
            ((HostCallbacks) connectionPool.delegate).mFragmentManager.execPendingActions();
        }
    };
    public final ConnectionPool mFragments = new ConnectionPool(3, new HostCallbacks());
    public boolean mStopped = true;

    public final class HostCallbacks extends FragmentManager {
        public final FragmentActivity mActivity;
        public final FragmentActivity mContext;
        public final FragmentManagerImpl mFragmentManager;
        public final AnonymousClass1 mHandler;

        public HostCallbacks() {
            AnonymousClass1 anonymousClass1 = FragmentActivity.this.mHandler;
            this.mFragmentManager = new FragmentManagerImpl();
            this.mActivity = FragmentActivity.this;
            this.mContext = FragmentActivity.this;
            if (anonymousClass1 == null) {
                throw new NullPointerException(C0000.decode(new byte[]{88, 81, 10, 81, 90, 92, 70, 16, 91, 4, 16, 94, 17, 89, 90}, "00d56940f9", 0.0f));
            }
            this.mHandler = anonymousClass1;
        }

        @Override // androidx.fragment.app.FragmentManager
        public final View onFindViewById(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        @Override // androidx.fragment.app.FragmentManager
        public final boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public final class NonConfigurationInstances {
        public FragmentManagerNonConfig fragments;
        public ViewModelStore viewModelStore;
    }

    public static void checkForValidRequestCode(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{119, 89, 86, 18, 13, 92, 85, 29, 65, 17, 68, 0, 69, 9, 91, 79, 93, 64, 66, 3, 15, 68, 3, 13, 67, 22, 69, 3, 91, 74, 24, 64, 7, 67, 76, 1, 18, 16, 116, 10, 1, 0}, "4882b29dad7eee", 1));
        }
    }

    public static boolean markState(FragmentManagerImpl fragmentManagerImpl) {
        List<Fragment> list;
        if (fragmentManagerImpl.mAdded.isEmpty()) {
            list = Collections.EMPTY_LIST;
        } else {
            synchronized (fragmentManagerImpl.mAdded) {
                list = (List) fragmentManagerImpl.mAdded.clone();
            }
        }
        boolean zMarkState = false;
        for (Fragment fragment : list) {
            if (fragment != null) {
                if (fragment.mLifecycleRegistry.state.compareTo(Lifecycle$State.STARTED) >= 0) {
                    LifecycleRegistry lifecycleRegistry = fragment.mLifecycleRegistry;
                    lifecycleRegistry.enforceMainThreadIfNeeded(C0000.decode(new byte[]{88, 82, 71, 94, 106, 21, 88, 66, 3}, "53559a96f401"));
                    Lifecycle$State lifecycle$State = Lifecycle$State.CREATED;
                    lifecycleRegistry.enforceMainThreadIfNeeded(C0000.decode(new byte[]{70, 92, 64, 115, 16, 23, 71, 92, 90, 68, 54, 17, 84, 77, 81}, "5940ee", 7));
                    lifecycleRegistry.moveToState(lifecycle$State);
                    zMarkState = true;
                }
                FragmentManagerImpl fragmentManagerImpl2 = fragment.mChildFragmentManager;
                if (fragmentManagerImpl2 != null) {
                    zMarkState |= markState(fragmentManagerImpl2);
                }
            }
        }
        return zMarkState;
    }

    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        LoaderManagerImpl$LoaderViewModel loaderManagerImpl$LoaderViewModel;
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print(C0000.decode(new byte[]{40, 95, 7, 86, 89, 23, 119, 75, 5, 87, 9, 82, 91, 67, 112, 90, 16, 89, 18, 94, 65, 78, 17}, "d0d75719"));
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(C0000.decode(new byte[]{22, 50, 64, 7, 76, 85, 14}, "6a4f804336b681"));
        String str2 = str + C0000.decode(new byte[]{65, 66}, "ab05e5b9140294", 0.0f);
        printWriter.print(str2);
        printWriter.print(C0000.decode(new byte[]{88, 38, 74, 93, 7, 64, 7, 81, 8}, "5e88f4b55052652e", 4));
        printWriter.print(this.mCreated);
        printWriter.print(C0000.decode(new byte[]{68, 14, 52, 81, 74, 77, 11, 0, 0, 94}, "dcf498fe", 1));
        printWriter.print(this.mResumed);
        printWriter.print(C0000.decode(new byte[]{65, 92, 103, 68, 86, 73, 21, 84, 5, 12}, "a14099e1", false));
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            ViewModelStore viewModelStore = getViewModelStore();
            CreationExtras$Empty creationExtras$Empty = CreationExtras$Empty.INSTANCE;
            String canonicalName = LoaderManagerImpl$LoaderViewModel.class.getCanonicalName();
            if (canonicalName == null) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{45, 10, 5, 89, 95, 66, 83, 13, 92, 25, 89, 93, 14, 11, 31, 85, 92, 23, 65, 67, 91, 85, 89, 64, 18, 0, 21, 24, 80, 3, 92, 67, 86, 86, 76, 19, 3, 0, 70, 110, 90, 7, 69, 46, 87, 93, 93, 95, 18}, "aef83b2c8983", 4));
            }
            String strConcat = C0000.decode(new byte[]{80, 87, 92, 66, 88, 95, 82, 73, 26, 9, 91, 87, 84, 90, 65, 83, 91, 83, 24, 103, 93, 0, 69, 124, 94, 93, 93, 92, 103, 68, 89, 71, 93, 1, 87, 67, 31, 125, 93, 86, 86, 67, 90, 69, 127, 0, 75, 11}, "198076614e21").concat(canonicalName);
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
                printWriter.print(str2);
                printWriter.println(C0000.decode(new byte[]{127, 86, 82, 85, 83, 68, 69, 15}, "3931666580736459", 0.0f));
                if (sparseArrayCompat.size() > 0) {
                    if (sparseArrayCompat.valueAt(0) != null) {
                        throw new ClassCastException();
                    }
                    printWriter.print(str2);
                    printWriter.print(C0000.decode(new byte[]{65, 20, 69}, "a4f6e87601b84b18"));
                    if (sparseArrayCompat.mGarbage) {
                        sparseArrayCompat.gc();
                    }
                    printWriter.print(sparseArrayCompat.mKeys[0]);
                    printWriter.print(C0000.decode(new byte[]{2, 65}, "8a09ae", false));
                    throw null;
                }
            }
        }
        ((HostCallbacks) this.mFragments.delegate).mFragmentManager.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public final LifecycleRegistry getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{61, 87, 65, 16, 68, 89, 85, 66, 10, 18, 94, 76, 73, 16, 11, 69, 68, 86, 91, 22, 68, 65, 83, 66, 67, 5, 67, 76, 81, 83, 10, 83, 0, 24, 64, 13, 68, 76, 94, 83, 67, 37, 71, 72, 92, 89, 1, 87, 16, 81, 91, 12, 68, 81, 88, 69, 23, 5, 89, 91, 85, 30, 66, 111, 11, 77, 20, 1, 5, 86, 17, 66, 67, 22, 82, 73, 69, 85, 17, 66, 68, 110, 93, 7, 19, 117, 89, 82, 6, 8, 23, 90, 85, 86, 13, 68, 1, 24, 91, 12, 39, 74, 83, 87, 23, 1, 23, 91, 81, 92, 14, 24}, "d84bd866cd7800b6", 3));
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

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        Object obj;
        Fragment fragmentFindFragmentByWho;
        ConnectionPool connectionPool = this.mFragments;
        connectionPool.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 == 0) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        SparseArrayCompat sparseArrayCompat = this.mPendingFragmentActivityResults;
        int iBinarySearch = ContainerHelpers.binarySearch(sparseArrayCompat.mKeys, sparseArrayCompat.mSize, i4);
        Object obj2 = SparseArrayCompat.DELETED;
        if (iBinarySearch < 0 || (obj = sparseArrayCompat.mValues[iBinarySearch]) == obj2) {
            obj = null;
        }
        String str = (String) obj;
        SparseArrayCompat sparseArrayCompat2 = this.mPendingFragmentActivityResults;
        int iBinarySearch2 = ContainerHelpers.binarySearch(sparseArrayCompat2.mKeys, sparseArrayCompat2.mSize, i4);
        if (iBinarySearch2 >= 0) {
            Object[] objArr = sparseArrayCompat2.mValues;
            if (objArr[iBinarySearch2] != obj2) {
                objArr[iBinarySearch2] = obj2;
                sparseArrayCompat2.mGarbage = true;
            }
        }
        if (str == null || (fragmentFindFragmentByWho = ((HostCallbacks) connectionPool.delegate).mFragmentManager.findFragmentByWho(str)) == null) {
            return;
        }
        fragmentFindFragmentByWho.getClass();
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        FragmentManagerImpl fragmentManagerImpl = ((HostCallbacks) this.mFragments.delegate).mFragmentManager;
        if (fragmentManagerImpl.mStateSaved || fragmentManagerImpl.mStopped || !fragmentManagerImpl.popBackStackImmediate()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ConnectionPool connectionPool = this.mFragments;
        connectionPool.noteStateNotSaved();
        ArrayList arrayList = ((HostCallbacks) connectionPool.delegate).mFragmentManager.mAdded;
        for (int i = 0; i < arrayList.size(); i++) {
            Fragment fragment = (Fragment) arrayList.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0098  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00be  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c6 A[LOOP:1: B:43:0x00ba->B:48:0x00c6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4 A[SYNTHETIC] */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ViewModelStore viewModelStore;
        ConnectionPool connectionPool = this.mFragments;
        HostCallbacks hostCallbacks = (HostCallbacks) connectionPool.delegate;
        HostCallbacks hostCallbacks2 = (HostCallbacks) connectionPool.delegate;
        FragmentManagerImpl fragmentManagerImpl = hostCallbacks.mFragmentManager;
        if (fragmentManagerImpl.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        fragmentManagerImpl.mHost = hostCallbacks;
        fragmentManagerImpl.mContainer = hostCallbacks;
        fragmentManagerImpl.mParent = null;
        super.onCreate(bundle);
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null && (viewModelStore = nonConfigurationInstances.viewModelStore) != null && this.mViewModelStore == null) {
            this.mViewModelStore = viewModelStore;
        }
        if (bundle != null) {
            hostCallbacks2.mFragmentManager.restoreAllState(bundle.getParcelable("android:support:fragments"), nonConfigurationInstances != null ? nonConfigurationInstances.fragments : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.mNextCandidateRequestIndex = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray != null && stringArray != null && intArray.length == stringArray.length) {
                    this.mPendingFragmentActivityResults = new SparseArrayCompat(intArray.length);
                    for (int i6 = 0; i6 < intArray.length; i6++) {
                        SparseArrayCompat sparseArrayCompat = this.mPendingFragmentActivityResults;
                        int i7 = intArray[i6];
                        String str = stringArray[i6];
                        int iBinarySearch = ContainerHelpers.binarySearch(sparseArrayCompat.mKeys, sparseArrayCompat.mSize, i7);
                        if (iBinarySearch >= 0) {
                            sparseArrayCompat.mValues[iBinarySearch] = str;
                        } else {
                            int i8 = ~iBinarySearch;
                            int i9 = sparseArrayCompat.mSize;
                            if (i8 < i9) {
                                Object[] objArr = sparseArrayCompat.mValues;
                                if (objArr[i8] == SparseArrayCompat.DELETED) {
                                    sparseArrayCompat.mKeys[i8] = i7;
                                    objArr[i8] = str;
                                } else {
                                    if (sparseArrayCompat.mGarbage && i9 >= sparseArrayCompat.mKeys.length) {
                                        sparseArrayCompat.gc();
                                        i8 = ~ContainerHelpers.binarySearch(sparseArrayCompat.mKeys, sparseArrayCompat.mSize, i7);
                                    }
                                    i = sparseArrayCompat.mSize;
                                    if (i >= sparseArrayCompat.mKeys.length) {
                                        i3 = (i + 1) * 4;
                                        for (i4 = 4; i4 < 32; i4++) {
                                            i5 = (1 << i4) - 12;
                                            if (i3 <= i5) {
                                                i3 = i5;
                                                break;
                                            }
                                        }
                                        int i10 = i3 / 4;
                                        int[] iArr = new int[i10];
                                        Object[] objArr2 = new Object[i10];
                                        int[] iArr2 = sparseArrayCompat.mKeys;
                                        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                                        Object[] objArr3 = sparseArrayCompat.mValues;
                                        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                                        sparseArrayCompat.mKeys = iArr;
                                        sparseArrayCompat.mValues = objArr2;
                                    }
                                    i2 = sparseArrayCompat.mSize - i8;
                                    if (i2 != 0) {
                                        int[] iArr3 = sparseArrayCompat.mKeys;
                                        int i11 = i8 + 1;
                                        System.arraycopy(iArr3, i8, iArr3, i11, i2);
                                        Object[] objArr4 = sparseArrayCompat.mValues;
                                        System.arraycopy(objArr4, i8, objArr4, i11, sparseArrayCompat.mSize - i8);
                                    }
                                    sparseArrayCompat.mKeys[i8] = i7;
                                    sparseArrayCompat.mValues[i8] = str;
                                    sparseArrayCompat.mSize++;
                                }
                            } else {
                                if (sparseArrayCompat.mGarbage) {
                                    sparseArrayCompat.gc();
                                    i8 = ~ContainerHelpers.binarySearch(sparseArrayCompat.mKeys, sparseArrayCompat.mSize, i7);
                                }
                                i = sparseArrayCompat.mSize;
                                if (i >= sparseArrayCompat.mKeys.length) {
                                    i3 = (i + 1) * 4;
                                    while (i4 < 32) {
                                        i5 = (1 << i4) - 12;
                                        if (i3 <= i5) {
                                            i3 = i5;
                                            break;
                                        }
                                    }
                                    int i12 = i3 / 4;
                                    int[] iArr4 = new int[i12];
                                    Object[] objArr5 = new Object[i12];
                                    int[] iArr5 = sparseArrayCompat.mKeys;
                                    System.arraycopy(iArr5, 0, iArr4, 0, iArr5.length);
                                    Object[] objArr6 = sparseArrayCompat.mValues;
                                    System.arraycopy(objArr6, 0, objArr5, 0, objArr6.length);
                                    sparseArrayCompat.mKeys = iArr4;
                                    sparseArrayCompat.mValues = objArr5;
                                }
                                i2 = sparseArrayCompat.mSize - i8;
                                if (i2 != 0) {
                                    int[] iArr6 = sparseArrayCompat.mKeys;
                                    int i13 = i8 + 1;
                                    System.arraycopy(iArr6, i8, iArr6, i13, i2);
                                    Object[] objArr7 = sparseArrayCompat.mValues;
                                    System.arraycopy(objArr7, i8, objArr7, i13, sparseArrayCompat.mSize - i8);
                                }
                                sparseArrayCompat.mKeys[i8] = i7;
                                sparseArrayCompat.mValues[i8] = str;
                                sparseArrayCompat.mSize++;
                            }
                        }
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new SparseArrayCompat();
            this.mNextCandidateRequestIndex = 0;
        }
        FragmentManagerImpl fragmentManagerImpl2 = hostCallbacks2.mFragmentManager;
        fragmentManagerImpl2.mStateSaved = false;
        fragmentManagerImpl2.mStopped = false;
        fragmentManagerImpl2.dispatchStateChange(1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean zOnCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        return zOnCreatePanelMenu | ((HostCallbacks) this.mFragments.delegate).mFragmentManager.dispatchCreateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        ((HostCallbacks) this.mFragments.delegate).mFragmentManager.onCreateView(view, str, context, attributeSet);
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (this.mViewModelStore != null && !isChangingConfigurations()) {
            this.mViewModelStore.clear();
        }
        ((HostCallbacks) this.mFragments.delegate).mFragmentManager.dispatchDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
        ArrayList arrayList = ((HostCallbacks) this.mFragments.delegate).mFragmentManager.mAdded;
        for (int i = 0; i < arrayList.size(); i++) {
            Fragment fragment = (Fragment) arrayList.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ConnectionPool connectionPool = this.mFragments;
        if (i == 0) {
            return ((HostCallbacks) connectionPool.delegate).mFragmentManager.dispatchOptionsItemSelected();
        }
        if (i != 6) {
            return false;
        }
        return ((HostCallbacks) connectionPool.delegate).mFragmentManager.dispatchContextItemSelected();
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        ArrayList arrayList = ((HostCallbacks) this.mFragments.delegate).mFragmentManager.mAdded;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged();
            }
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            ((HostCallbacks) this.mFragments.delegate).mFragmentManager.dispatchOptionsMenuClosed();
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        this.mResumed = false;
        AnonymousClass1 anonymousClass1 = this.mHandler;
        boolean zHasMessages = anonymousClass1.hasMessages(2);
        ConnectionPool connectionPool = this.mFragments;
        if (zHasMessages) {
            anonymousClass1.removeMessages(2);
            FragmentManagerImpl fragmentManagerImpl = ((HostCallbacks) connectionPool.delegate).mFragmentManager;
            fragmentManagerImpl.mStateSaved = false;
            fragmentManagerImpl.mStopped = false;
            fragmentManagerImpl.dispatchStateChange(4);
        }
        ((HostCallbacks) connectionPool.delegate).mFragmentManager.dispatchStateChange(3);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        ArrayList arrayList = ((HostCallbacks) this.mFragments.delegate).mFragmentManager.mAdded;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged();
            }
        }
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        removeMessages(2);
        ConnectionPool connectionPool = this.mFragments;
        FragmentManagerImpl fragmentManagerImpl = ((HostCallbacks) connectionPool.delegate).mFragmentManager;
        fragmentManagerImpl.mStateSaved = false;
        fragmentManagerImpl.mStopped = false;
        fragmentManagerImpl.dispatchStateChange(4);
        ((HostCallbacks) connectionPool.delegate).mFragmentManager.execPendingActions();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : super.onPreparePanel(0, view, menu) | ((HostCallbacks) this.mFragments.delegate).mFragmentManager.dispatchPrepareOptionsMenu();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Object obj;
        ConnectionPool connectionPool = this.mFragments;
        connectionPool.noteStateNotSaved();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            SparseArrayCompat sparseArrayCompat = this.mPendingFragmentActivityResults;
            int iBinarySearch = ContainerHelpers.binarySearch(sparseArrayCompat.mKeys, sparseArrayCompat.mSize, i3);
            Object obj2 = SparseArrayCompat.DELETED;
            if (iBinarySearch < 0 || (obj = sparseArrayCompat.mValues[iBinarySearch]) == obj2) {
                obj = null;
            }
            String str = (String) obj;
            SparseArrayCompat sparseArrayCompat2 = this.mPendingFragmentActivityResults;
            int iBinarySearch2 = ContainerHelpers.binarySearch(sparseArrayCompat2.mKeys, sparseArrayCompat2.mSize, i3);
            if (iBinarySearch2 >= 0) {
                Object[] objArr = sparseArrayCompat2.mValues;
                if (objArr[iBinarySearch2] != obj2) {
                    objArr[iBinarySearch2] = obj2;
                    sparseArrayCompat2.mGarbage = true;
                }
            }
            if (str == null) {
                return;
            }
            ((HostCallbacks) connectionPool.delegate).mFragmentManager.findFragmentByWho(str);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        sendEmptyMessage(2);
        this.mResumed = true;
        ((HostCallbacks) this.mFragments.delegate).mFragmentManager.execPendingActions();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        FragmentManagerImpl fragmentManagerImpl = ((HostCallbacks) this.mFragments.delegate).mFragmentManager;
        FragmentManagerImpl.setRetaining(fragmentManagerImpl.mSavedNonConfig);
        FragmentManagerNonConfig fragmentManagerNonConfig = fragmentManagerImpl.mSavedNonConfig;
        if (fragmentManagerNonConfig == null && this.mViewModelStore == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances = new NonConfigurationInstances();
        nonConfigurationInstances.viewModelStore = this.mViewModelStore;
        nonConfigurationInstances.fragments = fragmentManagerNonConfig;
        return nonConfigurationInstances;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        ConnectionPool connectionPool;
        super.onSaveInstanceState(bundle);
        do {
            connectionPool = this.mFragments;
        } while (markState(((HostCallbacks) connectionPool.delegate).mFragmentManager));
        FragmentManagerState fragmentManagerStateSaveAllState = ((HostCallbacks) connectionPool.delegate).mFragmentManager.saveAllState();
        if (fragmentManagerStateSaveAllState != null) {
            bundle.putParcelable(C0000.decode(new byte[]{3, 86, 83, 67, 10, 8, 6, 2, 68, 68, 21, 17, 13, 74, 67, 11, 3, 19, 3, 95, 90, 84, 11, 21, 17}, "b871ea", false), fragmentManagerStateSaveAllState);
        }
        if (this.mPendingFragmentActivityResults.size() > 0) {
            bundle.putInt(C0000.decode(new byte[]{89, 13, 93, 67, 89, 89, 84, 92, 71, 16, 68, 18, 10, 20, 76, 89, 87, 84, 78, 68, 111, 20, 81, 20, 65, 7, 22, 18, 103, 10, 87, 85, 83, 72}, "8c91600f4e4bef"), this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.size()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.size()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.size(); i++) {
                SparseArrayCompat sparseArrayCompat = this.mPendingFragmentActivityResults;
                if (sparseArrayCompat.mGarbage) {
                    sparseArrayCompat.gc();
                }
                iArr[i] = sparseArrayCompat.mKeys[i];
                strArr[i] = (String) this.mPendingFragmentActivityResults.valueAt(i);
            }
            bundle.putIntArray(C0000.decode(new byte[]{81, 15, 82, 16, 93, 89, 80, 15, 21, 66, 69, 73, 95, 19, 66, 88, 64, 85, 69, 64, 3, 68, 65, 102, 89, 15, 82, 11, 81, 89, 81, 70}, "0a6b2045f759", 0.0f), iArr);
            bundle.putStringArray(C0000.decode(new byte[]{4, 92, 86, 65, 92, 95, 1, 8, 65, 70, 67, 70, 10, 64, 70, 9, 65, 83, 20, 71, 87, 64, 71, 105, 3, 64, 83, 84, 94, 83, 11, 70, 109, 68, 91, 89}, "e22336", 0.0f), strArr);
        }
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        this.mStopped = false;
        boolean z = this.mCreated;
        ConnectionPool connectionPool = this.mFragments;
        if (!z) {
            this.mCreated = true;
            FragmentManagerImpl fragmentManagerImpl = ((HostCallbacks) connectionPool.delegate).mFragmentManager;
            fragmentManagerImpl.mStateSaved = false;
            fragmentManagerImpl.mStopped = false;
            fragmentManagerImpl.dispatchStateChange(2);
        }
        connectionPool.noteStateNotSaved();
        HostCallbacks hostCallbacks = (HostCallbacks) connectionPool.delegate;
        hostCallbacks.mFragmentManager.execPendingActions();
        FragmentManagerImpl fragmentManagerImpl2 = hostCallbacks.mFragmentManager;
        fragmentManagerImpl2.mStateSaved = false;
        fragmentManagerImpl2.mStopped = false;
        fragmentManagerImpl2.dispatchStateChange(3);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    @Override // android.app.Activity
    public final void onStop() {
        ConnectionPool connectionPool;
        super.onStop();
        this.mStopped = true;
        do {
            connectionPool = this.mFragments;
        } while (markState(((HostCallbacks) connectionPool.delegate).mFragmentManager));
        FragmentManagerImpl fragmentManagerImpl = ((HostCallbacks) connectionPool.delegate).mFragmentManager;
        fragmentManagerImpl.mStopped = true;
        fragmentManagerImpl.dispatchStateChange(2);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i) {
        if (i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        if (i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i != -1) {
            checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        ((HostCallbacks) this.mFragments.delegate).mFragmentManager.onCreateView(null, str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }
}
