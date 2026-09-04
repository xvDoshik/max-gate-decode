package com.google.android.gms.common.api.internal;

import androidx.work.Worker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zzag;
import java.util.Set;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zabu {
    public final /* synthetic */ GoogleApiManager zaa;
    public final Api.Client zab;
    public final ApiKey zac;
    public final IAccountAccessor zad = null;
    public final Set zae = null;
    public boolean zaf = false;

    public zabu(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.zaa = googleApiManager;
        this.zab = client;
        this.zac = apiKey;
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.zaa.zat.post(new Worker.AnonymousClass2(this, 8, connectionResult));
    }

    public final void zae(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) this.zaa.zap.get(this.zac);
        if (zabqVar != null) {
            zzag.checkHandlerThread(zabqVar.zaa.zat);
            Api.Client client = zabqVar.zac;
            String name = client.getClass().getName();
            String strValueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(name.length() + 25 + strValueOf.length());
            sb.append(C0000.decode(new byte[]{14, 88, 49, 89, 80, 8, 47, 13, 32, 0, 95, 89, 4, 82, 66, 86, 88, 20, 70}, "a6b07ffcfa65", false));
            sb.append(name);
            sb.append(C0000.decode(new byte[]{17, 67, 80, 23, 10, 65}, "149cba9a28650aa5", 7));
            sb.append(strValueOf);
            client.disconnect(sb.toString());
            zabqVar.zar(connectionResult, null);
        }
    }
}
