package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.internal.base.zad;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zap extends GmsClient {
    public final TelemetryLoggingOptions zaa;

    public zap(Context context, Looper looper, zzac zzacVar, TelemetryLoggingOptions telemetryLoggingOptions, zabq zabqVar, zabq zabqVar2) {
        super(context, looper, 270, zzacVar, zabqVar, zabqVar2);
        this.zaa = telemetryLoggingOptions;
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        String strDecode = C0000.decode(new byte[]{5, 87, 91, 76, 83, 13, 92, 94, 91, 1, 72, 89, 88, 6, 70, 13, 90, 93, 25, 3, 11, 75, 24, 1, 91, 15, 94, 86, 89, 74, 15, 86, 66, 7, 70, 12, 82, 85, 25, 23, 3, 74, 64, 11, 87, 7, 29, 112, 116, 8, 15, 93, 88, 22, 96, 7, 95, 92, 90, 1, 18, 74, 79, 49, 81, 16, 69, 80, 84, 1}, "f86b4b397d", true);
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(strDecode);
        return iInterfaceQueryLocalInterface instanceof zai ? (zai) iInterfaceQueryLocalInterface : new zai(iBinder, strDecode);
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final Feature[] getApiFeatures() {
        return zad.zab;
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        this.zaa.getClass();
        return new Bundle();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final String getServiceDescriptor() {
        return C0000.decode(new byte[]{1, 91, 88, 26, 85, 93, 13, 83, 89, 81, 28, 83, 12, 80, 71, 91, 91, 86, 76, 83, 88, 71, 28, 81, 13, 89, 88, 91, 92, 28, 11, 90, 65, 81, 64, 92, 3, 88, 27, 71, 87, 64, 20, 93, 86, 81, 28, 123, 33, 88, 92, 81, 92, 70, 54, 81, 89, 81, 95, 87, 22, 70, 76, 103, 87, 64, 20, 93, 86, 81}, "b45422", 0.0f);
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final String getStartServiceAction() {
        return C0000.decode(new byte[]{1, 14, 93, 22, 4, 12, 88, 81, 14, 4, 30, 89, 13, 7, 69, 89, 11, 5, 30, 95, 14, 16, 25, 85, 13, 12, 93, 87, 13, 77, 67, 83, 14, 4, 93, 93, 23, 17, 78, 24, 17, 4, 66, 78, 10, 0, 82, 24, 49, 53, 113, 106, 55}, "ba08cc76", 1);
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    public final boolean getUseDynamicLookup() {
        return true;
    }
}
