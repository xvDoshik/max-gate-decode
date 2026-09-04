package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.base.template.network.WsPersistManager$$ExternalSyntheticLambda2;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.cloudmessaging.zzac;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter(C0000.decode(new byte[]{83, 83, 6, 88, 81, 91, 82, 40, 88, 84, 7}, "12e3456f99bfde81", true));
        String queryParameter2 = intent.getData().getQueryParameter(C0000.decode(new byte[]{1, 27, 17, 68, 84, 71}, "dce654049e0b", 0.0f));
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter(C0000.decode(new byte[]{21, 64, 91, 86, 75, 92, 21, 76}, "e22995a599", 4))).intValue();
        int i = intent.getExtras().getInt(C0000.decode(new byte[]{88, 66, 22, 3, 84, 72, 69, 125, 70, 8, 81, 84, 66}, "96bf98133e3100", 0.0f));
        TransportRuntime.initialize(context);
        zzac zzacVarBuilder = AutoValue_TransportContext.builder();
        zzacVarBuilder.setBackendName(queryParameter);
        zzacVarBuilder.zzc = PriorityMapping.valueOf(iIntValue);
        if (queryParameter2 != null) {
            zzacVarBuilder.zza = Base64.decode(queryParameter2, 0);
        }
        Uploader uploader = TransportRuntime.getInstance().uploader;
        uploader.executor.execute(new Uploader$$ExternalSyntheticLambda0(uploader, zzacVarBuilder.build(), i, new WsPersistManager$$ExternalSyntheticLambda2(2)));
    }
}
