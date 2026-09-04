package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.cloudmessaging.zzac;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class JobInfoSchedulerService extends JobService {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartJob$0(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString(C0000.decode(new byte[]{81, 7, 2, 91, 80, 91, 92, 124, 82, 11, 4}, "3fa05582", true));
        String string2 = jobParameters.getExtras().getString(C0000.decode(new byte[]{7, 75, 69, 69, 89, 68}, "b31787", true));
        int i = jobParameters.getExtras().getInt(C0000.decode(new byte[]{68, 69, 95, 14, 64, 89, 64, 78}, "476a20"));
        int i2 = jobParameters.getExtras().getInt(C0000.decode(new byte[]{84, 66, 69, 86, 92, 64, 65, 120, 68, 94, 83, 85, 71}, "561310", true));
        TransportRuntime.initialize(getApplicationContext());
        zzac zzacVarBuilder = AutoValue_TransportContext.builder();
        zzacVarBuilder.setBackendName(string);
        zzacVarBuilder.zzc = PriorityMapping.valueOf(i);
        if (string2 != null) {
            zzacVarBuilder.zza = Base64.decode(string2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        uploader.executor.execute(new Uploader$$ExternalSyntheticLambda0(uploader, zzacVarBuilder.build(), i2, new Processor$$ExternalSyntheticLambda2(this, 12, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
