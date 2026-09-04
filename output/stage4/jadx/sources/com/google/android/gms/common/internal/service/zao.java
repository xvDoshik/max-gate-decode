package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.AutoMigration_14_15;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi$Settings;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zag;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzw;
import java.lang.reflect.InvocationTargetException;
import okhttp3.ConnectionPool;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zao {
    public static final Api zae = new Api(new zan(), new AutoMigration_14_15());
    public final GoogleApiManager zaa;
    public final Context zab;
    public final String zac;
    public final Api zad;
    public final TelemetryLoggingOptions zae$1;
    public final ApiKey zaf;
    public final int zah;
    public final ByteString.Companion zaj;

    public zao(Context context, Api api, GoogleApi$Settings googleApi$Settings) {
        zzag.checkNotNull(context, C0000.decode(new byte[]{124, 76, 14, 10, 67, 0, 94, 10, 70, 92, 26, 18, 67, 10, 66, 68, 92, 86, 22, 70, 19, 6, 67, 9, 91, 77, 22, 3, 7, 77}, "29bfcc1d", 0.0f));
        zzag.checkNotNull(api, C0000.decode(new byte[]{116, 65, 80, 23, 85, 64, 67, 69, 21, 13, 12, 71, 17, 86, 87, 23, 91, 68, 85, 91, 22}, "519785015cc31427", 0.0f));
        zzag.checkNotNull(googleApi$Settings, C0000.decode(new byte[]{101, 84, 18, 71, 15, 88, 6, 68, 68, 12, 20, 23, 76, 70, 88, 94, 18, 19, 4, 83, 65, 89, 17, 13, 13, 95, 24, 19, 69, 84, 70, 96, 3, 66, 21, 94, 10, 6, 18, 74, 124, 35, 112, 112, 51, 127, 50, 105, 50, 114, 48, 53, 40, 42, 127, 53, 22, 88, 8, 64, 18, 83, 0, 83, 74}, "61f3f6a7daad8f", true));
        this.zab = context.getApplicationContext();
        String str = null;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                str = (String) Context.class.getMethod(C0000.decode(new byte[]{94, 82, 16, 35, 67, 76, 70, 88, 83, 64, 18, 90, 94, 91, 109, 86, 3}, "97db784115f315", true), null).invoke(context, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.zac = str;
        this.zad = api;
        this.zae$1 = TelemetryLoggingOptions.zaa;
        this.zaf = new ApiKey(api, str);
        GoogleApiManager googleApiManagerZam = GoogleApiManager.zam(this.zab);
        this.zaa = googleApiManagerZam;
        this.zah = googleApiManagerZam.zan.getAndIncrement();
        this.zaj = googleApi$Settings.zaa;
        zaq zaqVar = googleApiManagerZam.zat;
        zaqVar.sendMessage(zaqVar.obtainMessage(7, this));
    }

    public final zzw log(TelemetryData telemetryData) {
        ConnectionPool connectionPool = new ConnectionPool(13);
        Feature[] featureArr = {zad.zaa};
        connectionPool.delegate = new ConnectionPool(15, telemetryData);
        zzr zzrVar = new zzr(connectionPool, featureArr, false);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.getClass();
        zag zagVar = new zag(zzrVar, taskCompletionSource, this.zaj);
        zaq zaqVar = googleApiManager.zat;
        zaqVar.sendMessage(zaqVar.obtainMessage(4, new zach(zagVar, googleApiManager.zao.get(), this)));
        return taskCompletionSource.zza;
    }
}
