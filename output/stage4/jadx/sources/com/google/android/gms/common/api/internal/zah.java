package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.work.impl.WorkLauncherImpl;
import com.google.android.gms.cloudmessaging.zzs;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zah extends zac {
    public final TaskCompletionSource zaa;

    public zah(TaskCompletionSource taskCompletionSource) {
        super(4);
        this.zaa = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        if (zabqVar.zag.get(null) == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq zabqVar) {
        if (zabqVar.zag.get(null) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    public final void zac(zabq zabqVar) {
        if (zabqVar.zag.remove(null) != null) {
            throw new ClassCastException();
        }
        this.zaa.trySetResult(Boolean.FALSE);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zad(Status status) {
        this.zaa.trySetException(new zzs(status));
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zae(Exception exc) {
        this.zaa.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        try {
            zac(zabqVar);
        } catch (DeadObjectException e) {
            zad(zac.zah(e));
            throw e;
        } catch (RemoteException e2) {
            zad(zac.zah(e2));
        } catch (RuntimeException e3) {
            this.zaa.trySetException(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final /* bridge */ /* synthetic */ void zag(WorkLauncherImpl workLauncherImpl, boolean z) {
    }
}
