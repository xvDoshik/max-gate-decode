package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import androidx.work.Worker;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class MutableLiveData {
    public static final Object NOT_SET = new Object();
    public volatile Object mData;
    public boolean mDispatchInvalidated;
    public boolean mDispatchingValue;
    public volatile Object mPendingData;
    public final Worker.AnonymousClass1 mPostValueRunnable;
    public final Object mDataLock = new Object();
    public final SafeIterableMap mObservers = new SafeIterableMap();

    public MutableLiveData() {
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new Worker.AnonymousClass1(4, this);
        this.mData = obj;
    }
}
