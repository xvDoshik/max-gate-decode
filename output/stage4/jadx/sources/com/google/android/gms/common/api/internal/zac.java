package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.work.impl.WorkLauncherImpl;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class zac {
    public final int zac;

    public zac(int i) {
        this.zac = i;
    }

    public static /* bridge */ /* synthetic */ Status zah(RemoteException remoteException) {
        return new Status(remoteException.getClass().getSimpleName() + C0000.decode(new byte[]{95, 67}, "ec83cd", 0.0f) + remoteException.getLocalizedMessage(), 19);
    }

    public abstract boolean zaa(zabq zabqVar);

    public abstract Feature[] zab(zabq zabqVar);

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zabq zabqVar);

    public abstract void zag(WorkLauncherImpl workLauncherImpl, boolean z);
}
