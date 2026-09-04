package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.SystemClock;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = SystemClock.tagWithPrefix(C0000.decode(new byte[]{49, 26, 16, 21, 7, 85, 44, 88, 85, 50, 0, 68, 78, 12, 2, 93}, "bccab8f77ae68ea8", true));
    private final Map<WorkGenerationalId, JobParameters> mJobParameters = new HashMap();
    private final StartStopTokens mStartStopTokens = new StartStopTokens();
    private WorkLauncher mWorkLauncher;
    private WorkManagerImpl mWorkManagerImpl;

    public abstract class Api24Impl {
        public static String[] getTriggeredContentAuthorities(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        public static Uri[] getTriggeredContentUris(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    public abstract class Api28Impl {
        public static Network getNetwork(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    public abstract class Api31Impl {
        public static int getStopReason(JobParameters jobParameters) {
            return SystemJobService.stopReason(jobParameters.getStopReason());
        }
    }

    public static int stopReason(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return i;
            default:
                return -512;
        }
    }

    private static WorkGenerationalId workGenerationalIdFromJobParameters(JobParameters jobParameters) {
        String strDecode = C0000.decode(new byte[]{119, 104, 103, 98, 113, 60, 54, 42, 98, 40, 60, 98, 53, 113, 113, 111, 122, 116}, "20300cae0cc1e4", 0.0f);
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey(strDecode)) {
                return null;
            }
            return new WorkGenerationalId(extras.getString(strDecode), extras.getInt(C0000.decode(new byte[]{32, 61, 50, 97, 115, 109, 54, 126, 102, 124, 58, 54, 54, 118, 113, 109, 38, 116, 122, 114, 55, 36, 50, 122, 125, 124}, "eef322a147")));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(getApplicationContext());
            this.mWorkManagerImpl = instance$1;
            Processor processor = instance$1.mProcessor;
            this.mWorkLauncher = new WorkLauncherImpl(processor, instance$1.mWorkTaskExecutor);
            processor.addExecutionListener(this);
        } catch (IllegalStateException e) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException(C0000.decode(new byte[]{99, 88, 20, 8, 122, 2, 90, 86, 1, 6, 69, 67, 90, 82, 3, 7, 68, 67, 64, 88, 70, 1, 82, 67, 93, 89, 15, 23, 94, 2, 88, 94, 28, 6, 83, 67, 66, 94, 7, 67, 86, 67, 119, 88, 8, 23, 82, 13, 64, 103, 20, 12, 65, 10, 80, 82, 20, 64, 88, 13, 119, 69, 3, 2, 67, 6, 28, 30, 70, 12, 69, 67, 85, 89, 70, 34, 71, 19, 88, 94, 5, 2, 67, 10, 91, 89, 69, 12, 89, 32, 70, 82, 7, 23, 82, 75, 29, 25}, "47fc7c", true), e);
            }
            SystemClock.get().getClass();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            workManagerImpl.mProcessor.removeExecutionListener(this);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        JobParameters jobParametersRemove;
        SystemClock systemClock = SystemClock.get();
        String str = workGenerationalId.workSpecId;
        systemClock.getClass();
        synchronized (this.mJobParameters) {
            jobParametersRemove = this.mJobParameters.remove(workGenerationalId);
        }
        this.mStartStopTokens.remove(workGenerationalId);
        if (jobParametersRemove != null) {
            jobFinished(jobParametersRemove, z);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.mWorkManagerImpl == null) {
            SystemClock.get().getClass();
            jobFinished(jobParameters, true);
            return false;
        }
        WorkGenerationalId workGenerationalIdWorkGenerationalIdFromJobParameters = workGenerationalIdFromJobParameters(jobParameters);
        if (workGenerationalIdWorkGenerationalIdFromJobParameters == null) {
            SystemClock.get().getClass();
            return false;
        }
        synchronized (this.mJobParameters) {
            try {
                if (this.mJobParameters.containsKey(workGenerationalIdWorkGenerationalIdFromJobParameters)) {
                    SystemClock systemClock = SystemClock.get();
                    workGenerationalIdWorkGenerationalIdFromJobParameters.toString();
                    systemClock.getClass();
                    return false;
                }
                SystemClock systemClock2 = SystemClock.get();
                workGenerationalIdWorkGenerationalIdFromJobParameters.toString();
                systemClock2.getClass();
                this.mJobParameters.put(workGenerationalIdWorkGenerationalIdFromJobParameters, jobParameters);
                int i = Build.VERSION.SDK_INT;
                SystemClock systemClock3 = new SystemClock();
                if (Api24Impl.getTriggeredContentUris(jobParameters) != null) {
                    Arrays.asList(Api24Impl.getTriggeredContentUris(jobParameters));
                }
                if (Api24Impl.getTriggeredContentAuthorities(jobParameters) != null) {
                    Arrays.asList(Api24Impl.getTriggeredContentAuthorities(jobParameters));
                }
                if (i >= 28) {
                    Api28Impl.getNetwork(jobParameters);
                }
                WorkLauncher workLauncher = this.mWorkLauncher;
                WorkLauncherImpl workLauncherImpl = (WorkLauncherImpl) workLauncher;
                ((Dispatcher) workLauncherImpl.workTaskExecutor).executeOnTaskThread(new StartWorkRunnable((Processor) workLauncherImpl.processor, this.mStartStopTokens.tokenFor(workGenerationalIdWorkGenerationalIdFromJobParameters), systemClock3, 0));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        if (this.mWorkManagerImpl == null) {
            SystemClock.get().getClass();
            return true;
        }
        WorkGenerationalId workGenerationalIdWorkGenerationalIdFromJobParameters = workGenerationalIdFromJobParameters(jobParameters);
        if (workGenerationalIdWorkGenerationalIdFromJobParameters == null) {
            SystemClock.get().getClass();
            return false;
        }
        SystemClock systemClock = SystemClock.get();
        workGenerationalIdWorkGenerationalIdFromJobParameters.toString();
        systemClock.getClass();
        synchronized (this.mJobParameters) {
            this.mJobParameters.remove(workGenerationalIdWorkGenerationalIdFromJobParameters);
        }
        StartStopToken startStopTokenRemove = this.mStartStopTokens.remove(workGenerationalIdWorkGenerationalIdFromJobParameters);
        if (startStopTokenRemove != null) {
            int stopReason = Build.VERSION.SDK_INT >= 31 ? Api31Impl.getStopReason(jobParameters) : -512;
            WorkLauncher workLauncher = this.mWorkLauncher;
            workLauncher.getClass();
            WorkLauncherImpl workLauncherImpl = (WorkLauncherImpl) workLauncher;
            ((Dispatcher) workLauncherImpl.workTaskExecutor).executeOnTaskThread(new StopWorkRunnable((Processor) workLauncherImpl.processor, startStopTokenRemove, false, stopReason));
        }
        Processor processor = this.mWorkManagerImpl.mProcessor;
        String str = workGenerationalIdWorkGenerationalIdFromJobParameters.workSpecId;
        synchronized (processor.mLock) {
            zContains = processor.mCancelledIds.contains(str);
        }
        return !zContains;
    }
}
