package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import com.google.android.gms.common.api.Api;
import java.util.HashMap;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@Deprecated
public abstract class JobIntentService extends Service {
    public CommandProcessor mCurProcessor;
    public JobServiceEngineImpl mJobImpl;

    public final class CommandProcessor extends AsyncTask {
        public CommandProcessor() {
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0034  */
        /* JADX WARN: Code duplicated, block: B:20:0x004f A[Catch: all -> 0x0057, TryCatch #1 {all -> 0x0057, blocks: (B:18:0x0047, B:20:0x004f, B:23:0x0059), top: B:32:0x0047 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:34:0x005d A[SYNTHETIC] */
        @Override // android.os.AsyncTask
        public final Object doInBackground(Object[] objArr) {
            Api api;
            JobParameters jobParameters;
            while (true) {
                JobIntentService jobIntentService = JobIntentService.this;
                jobIntentService.mJobImpl.getClass();
                JobServiceEngineImpl jobServiceEngineImpl = jobIntentService.mJobImpl;
                synchronized (jobServiceEngineImpl.mLock) {
                    try {
                        JobParameters jobParameters2 = jobServiceEngineImpl.mParams;
                        if (jobParameters2 != null) {
                            JobWorkItem jobWorkItemDequeueWork = jobParameters2.dequeueWork();
                            if (jobWorkItemDequeueWork != null) {
                                jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(jobServiceEngineImpl.mService.getClassLoader());
                                api = new Api(jobServiceEngineImpl, 2, jobWorkItemDequeueWork);
                            }
                            if (api != null) {
                                return null;
                            }
                            JobIntentService jobIntentService2 = JobIntentService.this;
                            ((JobWorkItem) api.zaa).getIntent();
                            jobIntentService2.onHandleWork();
                            synchronized (((JobServiceEngineImpl) api.zac).mLock) {
                                try {
                                    jobParameters = ((JobServiceEngineImpl) api.zac).mParams;
                                    if (jobParameters != null) {
                                        jobParameters.completeWork((JobWorkItem) api.zaa);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                api = null;
                if (api != null) {
                    return null;
                }
                JobIntentService jobIntentService3 = JobIntentService.this;
                ((JobWorkItem) api.zaa).getIntent();
                jobIntentService3.onHandleWork();
                synchronized (((JobServiceEngineImpl) api.zac).mLock) {
                    jobParameters = ((JobServiceEngineImpl) api.zac).mParams;
                    if (jobParameters != null) {
                        jobParameters.completeWork((JobWorkItem) api.zaa);
                    }
                }
            }
        }

        @Override // android.os.AsyncTask
        public final void onCancelled(Object obj) {
            JobIntentService.this.getClass();
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Object obj) {
            JobIntentService.this.getClass();
        }
    }

    public final class JobServiceEngineImpl extends JobServiceEngine {
        public final Object mLock;
        public JobParameters mParams;
        public final JobIntentService mService;

        public JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mLock = new Object();
            this.mService = jobIntentService;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStartJob(JobParameters jobParameters) {
            this.mParams = jobParameters;
            JobIntentService jobIntentService = this.mService;
            if (jobIntentService.mCurProcessor != null) {
                return true;
            }
            CommandProcessor commandProcessor = jobIntentService.new CommandProcessor();
            jobIntentService.mCurProcessor = commandProcessor;
            commandProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public final boolean onStopJob(JobParameters jobParameters) {
            CommandProcessor commandProcessor = this.mService.mCurProcessor;
            if (commandProcessor != null) {
                commandProcessor.cancel(false);
            }
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return true;
        }
    }

    static {
        new HashMap();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        JobServiceEngineImpl jobServiceEngineImpl = this.mJobImpl;
        if (jobServiceEngineImpl != null) {
            return jobServiceEngineImpl.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.mJobImpl = new JobServiceEngineImpl(this);
    }

    public abstract void onHandleWork();

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
