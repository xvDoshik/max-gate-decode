package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.tracing.Trace;
import androidx.work.ForegroundInfo;
import androidx.work.SystemClock;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.foreground.SystemForegroundService.AnonymousClass1;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.StopWorkRunnable;
import com.google.android.gms.common.api.internal.zabn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlinx.coroutines.Job;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SystemForegroundDispatcher implements OnConstraintsStateChangedListener, ExecutionListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    public SystemForegroundService mCallback;
    public final ConnectionPool mConstraintsTracker;
    public WorkGenerationalId mCurrentForegroundId;
    public final LinkedHashMap mForegroundInfoById;
    public final Object mLock = new Object();
    public final Dispatcher mTaskExecutor;
    public final HashMap mTrackedWorkSpecs;
    public final WorkManagerImpl mWorkManagerImpl;
    public final HashMap mWorkSpecById;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{48, 65, 21, 18, 1, 8, 35, 2, 112, 89, 23, 18, 83, 21, 0, 80, 3, 20}, "c8ffdeee40db2a", true));
    }

    public SystemForegroundDispatcher(Context context) {
        WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(context);
        this.mWorkManagerImpl = instance$1;
        this.mTaskExecutor = instance$1.mWorkTaskExecutor;
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashMap();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new ConnectionPool(instance$1.mTrackers);
        instance$1.mProcessor.addExecutionListener(this);
    }

    public static Intent createNotifyIntent(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction(C0000.decode(new byte[]{121, 37, 98, 112, 43, 120, 108, 44, 127, 109, 113, 32, 111}, "8f69d63b09"));
        intent.putExtra(C0000.decode(new byte[]{122, 32, 104, 108, 122, 44, 103, 44, 36, 42, 118, 118, 97, 47, 121, 120, 110, 44, 117}, "1e134c3ebc575f66", 0.0f), foregroundInfo.mNotificationId);
        intent.putExtra(C0000.decode(new byte[]{42, 38, 107, 61, 118, 120, 106, 117, 34, 51, 119, 101, 47, 39, 109, 49, 117, 101, 110, 121, 38, 36, 103, 100, 56, 51, 119}, "ac2b0780ea80", 0), foregroundInfo.mForegroundServiceType);
        intent.putExtra(C0000.decode(new byte[]{121, 38, 108, 110, 121, 120, 100, 47, 126, 45, 113, 34, 97, 120, 120, 121}, "2c51770f8d", false), foregroundInfo.mNotification);
        intent.putExtra(C0000.decode(new byte[]{41, 116, 110, 57, 99, 119, 51, 122, 55, 100, 124, 115, 60, 43, 38}, "b17f48a1d490cb", 6), workGenerationalId.workSpecId);
        intent.putExtra(C0000.decode(new byte[]{42, 113, 58, 110, 36, 125, 42, 33, 100, 36, 49, 44, 119, 123}, "a4c1c8dd6eee8596", 0), workGenerationalId.generation);
        return intent;
    }

    public static Intent createStartForegroundIntent(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction(C0000.decode(new byte[]{115, 32, 54, 121, 43, 127, 57, 100, 53, 35, 96, 55, 61, 118, 43, 99, 35, 112, 51, 45, 103, 45, 38}, "2cb0d1f7ab", 0.0f));
        intent.putExtra(C0000.decode(new byte[]{127, 119, 61, 58, 100, 126, 102, 121, 55, 53, 118, 114, 107, 123, 32}, "42de31", true), workGenerationalId.workSpecId);
        intent.putExtra(C0000.decode(new byte[]{47, 118, 58, 58, 126, 35, 120, 124, 54, 114, 55, 44, 118, 40}, "d3ce9f69", 0.0f), workGenerationalId.generation);
        intent.putExtra(C0000.decode(new byte[]{115, 118, 108, 57, 127, 120, 108, 122, 115, 47, 114, 118, 108, 122, 122, 40, 110, 126, 124}, "835f17", 3), foregroundInfo.mNotificationId);
        intent.putExtra(C0000.decode(new byte[]{125, 33, 63, 102, 126, 46, 55, 116, 112, 99, 121, 49, 40, 125, 103, 50, 32, 99, 97, 120, 117, 33, 57, 109, 97, 49, 32}, "6df98ae171"), foregroundInfo.mForegroundServiceType);
        intent.putExtra(C0000.decode(new byte[]{121, 118, 107, 107, 123, 123, 102, 40, 37, 124, 117, 118, 102, 122, 125, 122}, "2324542ac567"), foregroundInfo.mNotification);
        return intent;
    }

    public final void handleNotify(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra(C0000.decode(new byte[]{120, 35, 107, 108, 118, 44, 49, 112, 116, 113, 39, 113, 103, 47, 125, 125, 103, 42, 33}, "3f238ce928d0", 0.0f), 0);
        int intExtra2 = intent.getIntExtra(C0000.decode(new byte[]{122, 117, 104, 102, 113, 46, 101, 115, 118, 98, 126, 108, 121, 37, 104, 101, 116, 98, 103, 112, 116, 36, 104, 98, 104, 96, 116}, "10197a76", 2), 0);
        WorkGenerationalId workGenerationalId = new WorkGenerationalId(intent.getStringExtra(C0000.decode(new byte[]{47, 112, 104, 109, 100, 119, 49, 125, 50, 99, 118, 116, 58, 123, 32}, "d51238c6a337e2", 0.0f)), intent.getIntExtra(C0000.decode(new byte[]{123, 116, 96, 105, 38, 116, 122, 117, 102, 120, 96, 47, 127, 127}, "0196a140494f", false), 0));
        Notification notification = (Notification) intent.getParcelableExtra(C0000.decode(new byte[]{47, 124, 56, 61, 43, 124, 101, 127, 116, 124, 39, 120, 53, 43, 42, 125}, "d9abe31625"));
        SystemClock.get().getClass();
        if (notification == null || this.mCallback == null) {
            return;
        }
        ForegroundInfo foregroundInfo = new ForegroundInfo(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.mForegroundInfoById;
        linkedHashMap.put(workGenerationalId, foregroundInfo);
        if (this.mCurrentForegroundId == null) {
            this.mCurrentForegroundId = workGenerationalId;
            SystemForegroundService systemForegroundService = this.mCallback;
            systemForegroundService.mHandler.post(systemForegroundService.new AnonymousClass1(intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = this.mCallback;
        systemForegroundService2.mHandler.post(new SystemForegroundService.AnonymousClass2(systemForegroundService2, intExtra, notification));
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            i |= ((ForegroundInfo) ((Map.Entry) it.next()).getValue()).mForegroundServiceType;
        }
        ForegroundInfo foregroundInfo2 = (ForegroundInfo) linkedHashMap.get(this.mCurrentForegroundId);
        if (foregroundInfo2 != null) {
            SystemForegroundService systemForegroundService3 = this.mCallback;
            systemForegroundService3.mHandler.post(systemForegroundService3.new AnonymousClass1(foregroundInfo2.mNotificationId, foregroundInfo2.mNotification, i));
        }
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public final void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState constraintsState) {
        if (constraintsState instanceof ConstraintsState.ConstraintsNotMet) {
            SystemClock.get().getClass();
            WorkGenerationalId workGenerationalIdGenerationalId = Trace.generationalId(workSpec);
            WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
            workManagerImpl.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(workManagerImpl.mProcessor, new StartStopToken(workGenerationalIdGenerationalId), true, -512));
        }
    }

    public final void onDestroy() {
        this.mCallback = null;
        synchronized (this.mLock) {
            try {
                Iterator it = this.mTrackedWorkSpecs.values().iterator();
                while (it.hasNext()) {
                    ((Job) it.next()).cancel(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mWorkManagerImpl.mProcessor.removeExecutionListener(this);
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        Map.Entry entry;
        synchronized (this.mLock) {
            try {
                Job job = ((WorkSpec) this.mWorkSpecById.remove(workGenerationalId)) != null ? (Job) this.mTrackedWorkSpecs.remove(workGenerationalId) : null;
                if (job != null) {
                    job.cancel(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.mForegroundInfoById.remove(workGenerationalId);
        if (workGenerationalId.equals(this.mCurrentForegroundId)) {
            if (this.mForegroundInfoById.size() > 0) {
                Iterator it = this.mForegroundInfoById.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.mCurrentForegroundId = (WorkGenerationalId) entry.getKey();
                if (this.mCallback != null) {
                    ForegroundInfo foregroundInfo2 = (ForegroundInfo) entry.getValue();
                    SystemForegroundService systemForegroundService = this.mCallback;
                    systemForegroundService.mHandler.post(systemForegroundService.new AnonymousClass1(foregroundInfo2.mNotificationId, foregroundInfo2.mNotification, foregroundInfo2.mForegroundServiceType));
                    SystemForegroundService systemForegroundService2 = this.mCallback;
                    systemForegroundService2.mHandler.post(new zabn(systemForegroundService2, foregroundInfo2.mNotificationId, 1));
                }
            } else {
                this.mCurrentForegroundId = null;
            }
        }
        SystemForegroundService systemForegroundService3 = this.mCallback;
        if (foregroundInfo == null || systemForegroundService3 == null) {
            return;
        }
        SystemClock systemClock = SystemClock.get();
        workGenerationalId.toString();
        systemClock.getClass();
        systemForegroundService3.mHandler.post(new zabn(systemForegroundService3, foregroundInfo.mNotificationId, 1));
    }
}
