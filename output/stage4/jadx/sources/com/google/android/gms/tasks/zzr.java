package com.google.android.gms.tasks;

import android.os.DeadObjectException;
import android.os.IInterface;
import android.os.Parcel;
import androidx.activity.ComponentActivity;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistry;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.internal.base.zac;
import java.util.ArrayDeque;
import java.util.ArrayList;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzr {
    public final Object zza;
    public Object zzb;
    public boolean zzc;

    public zzr() {
        this.zza = new Object();
    }

    public void doExecute(Api.Client client, TaskCompletionSource taskCompletionSource) {
        IInterface iInterface;
        TelemetryData telemetryData = (TelemetryData) ((ConnectionPool) ((ConnectionPool) this.zzb).delegate).delegate;
        zap zapVar = (zap) client;
        synchronized (zapVar.zzp) {
            if (zapVar.zzv == 5) {
                throw new DeadObjectException();
            }
            if (!zapVar.isConnected()) {
                throw new IllegalStateException(C0000.decode(new byte[]{122, 87, 69, 23, 5, 10, 95, 87, 3, 85, 64, 93, 85, 25, 70, 38, 80, 85, 10, 22, 87, 87, 95, 89, 3, 6, 69, 17, 79, 22, 85, 86, 85, 23, 17, 4, 88, 77, 70, 80, 91, 74, 17, 88, 8, 38, 94, 87, 8, 83, 87, 76, 84, 83, 78, 76, 17, 77, 9, 22, 86, 93, 17, 84, 7, 9, 93, 92, 2, 24}, "4817fe19f6", 0.0f));
            }
            iInterface = zapVar.zzs;
            zzag.checkNotNull(iInterface, C0000.decode(new byte[]{37, 84, 94, 87, 88, 66, 21, 81, 74, 17, 82, 13, 8, 88, 3, 91, 67, 87, 82, 22, 87, 77, 77, 17, 66, 7, 20, 64, 15, 91, 82, 18, 95, 69, 21, 86, 76, 93, 93}, "f8726658911bf6", 0.0f));
        }
        zai zaiVar = (zai) iInterface;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(zaiVar.zab);
        int i = zac.$r8$clinit;
        if (telemetryData == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            telemetryData.writeToParcel(parcelObtain, 0);
        }
        try {
            zaiVar.zaa.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            taskCompletionSource.setResult(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public void performAttach() {
        ComponentActivity componentActivity = (ComponentActivity) this.zza;
        LifecycleRegistry lifecycleRegistry = componentActivity.mLifecycleRegistry;
        if (lifecycleRegistry.state != Lifecycle$State.INITIALIZED) {
            throw new IllegalStateException(C0000.decode(new byte[]{51, 3, 18, 17, 5, 66, 21, 3, 19, 69, 9, 69, 18, 18, 65, 7, 1, 16, 2, 20, 4, 4, 16, 85, 5, 70, 14, 11, 8, 73, 65, 2, 20, 23, 13, 94, 6, 70, 14, 18, 10, 85, 19, 65, 18, 69, 13, 94, 8, 18, 8, 4, 8, 89, 27, 7, 21, 12, 11, 94, 65, 21, 21, 4, 3, 85}, "afaed0"));
        }
        lifecycleRegistry.addObserver(new Recreator(componentActivity));
        final SavedStateRegistry savedStateRegistry = (SavedStateRegistry) this.zzb;
        if (savedStateRegistry.attached) {
            throw new IllegalStateException(C0000.decode(new byte[]{107, 82, 20, 82, 84, 106, 76, 82, 22, 82, 98, 92, 95, 90, 17, 67, 66, 64, 24, 68, 3, 68, 16, 88, 84, 65, 7, 86, 84, 64, 24, 82, 22, 67, 81, 90, 80, 86, 6, 25}, "83b709", 2));
        }
        lifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.savedstate.SavedStateRegistry$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
                Lifecycle$Event lifecycle$Event2 = Lifecycle$Event.ON_START;
                SavedStateRegistry savedStateRegistry2 = savedStateRegistry;
                if (lifecycle$Event == lifecycle$Event2) {
                    savedStateRegistry2.isAllowingSavingState = true;
                } else if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
                    savedStateRegistry2.isAllowingSavingState = false;
                }
            }
        });
        savedStateRegistry.attached = true;
        this.zzc = true;
    }

    public void zza(zzq zzqVar) {
        synchronized (this.zza) {
            try {
                if (((ArrayDeque) this.zzb) == null) {
                    this.zzb = new ArrayDeque();
                }
                ((ArrayDeque) this.zzb).add(zzqVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void zzb(Task task) {
        zzq zzqVar;
        synchronized (this.zza) {
            if (((ArrayDeque) this.zzb) != null && !this.zzc) {
                this.zzc = true;
                while (true) {
                    synchronized (this.zza) {
                        try {
                            zzqVar = (zzq) ((ArrayDeque) this.zzb).poll();
                            if (zzqVar == null) {
                                this.zzc = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zzqVar.zzd(task);
                }
            }
        }
    }

    public zzr(ConnectionPool connectionPool, Feature[] featureArr, boolean z) {
        this.zzb = connectionPool;
        this.zza = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.zzc = z2;
    }

    public zzr(ComponentActivity componentActivity) {
        this.zza = componentActivity;
        this.zzb = new SavedStateRegistry();
    }

    public zzr(ComponentActivity$$ExternalSyntheticLambda1 componentActivity$$ExternalSyntheticLambda1) {
        this.zza = new Object();
        this.zzb = new ArrayList();
    }
}
