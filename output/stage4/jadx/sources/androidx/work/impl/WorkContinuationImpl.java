package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.Operation;
import androidx.work.SystemClock;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.text.CharsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkContinuationImpl extends CharsKt {
    public final ArrayList mAllIds = new ArrayList();
    public boolean mEnqueued;
    public final int mExistingWorkPolicy;
    public final ArrayList mIds;
    public final String mName;
    public OperationImpl mOperation;
    public final List mWork;
    public final WorkManagerImpl mWorkManagerImpl;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{100, 89, 17, 10, 118, 11, 91, 21, 10, 15, 68, 4, 71, 95, 12, 15, 124, 9, 69, 13}, "36ca5d5aca1e", 7));
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, int i, List list, int i2) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mName = str;
        this.mExistingWorkPolicy = i;
        this.mWork = list;
        this.mIds = new ArrayList(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i == 1 && ((WorkRequest) list.get(i3)).workSpec.nextScheduleTimeOverride != Long.MAX_VALUE) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{119, 87, 73, 67, 22, 54, 84, 92, 85, 92, 76, 14, 0, 20, 109, 91, 92, 82, 22, 42, 65, 81, 66, 74, 80, 6, 0, 20, 84, 71, 66, 67, 22, 7, 82, 20, 69, 75, 92, 6, 69, 67, 80, 70, 89, 23, 115, 29, 94, 71, 68, 81, 87, 5, 53, 81, 75, 91, 94, 83, 95, 6, 96, 91, 66, 83, 105, 13, 9, 93, 90, 75, 100, 103, 114, 36, 99, 113, 16, 16, 73, 16, 0, 82, 92, 64, 80, 85, 90, 28, 30, 20, 95, 74, 25, 41, 32, 113, 105}, "92176e74089be4", 1));
            }
            String string = ((WorkRequest) list.get(i3)).id.toString();
            this.mIds.add(string);
            this.mAllIds.add(string);
        }
    }

    public static HashSet prerequisitesFor(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        workContinuationImpl.getClass();
        return hashSet;
    }

    public final Operation enqueue() {
        if (this.mEnqueued) {
            SystemClock systemClock = SystemClock.get();
            TextUtils.join(C0000.decode(new byte[]{78, 17}, "b1156cb4031c11", 1), this.mIds);
            systemClock.getClass();
        } else {
            OperationImpl operationImpl = new OperationImpl();
            this.mWorkManagerImpl.mWorkTaskExecutor.executeOnTaskThread(new EnqueueRunnable(this, operationImpl));
            this.mOperation = operationImpl;
        }
        return this.mOperation;
    }
}
