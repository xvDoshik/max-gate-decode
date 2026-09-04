package com.google.android.gms.cloudmessaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.zzw;
import java.lang.ref.SoftReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.ExceptionsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    public static SoftReference zza;

    public abstract int onMessageReceive(Context context, CloudMessage cloudMessage);

    public void onNotificationDismissed(Bundle bundle) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        ExecutorService executorService;
        if (intent == null) {
            return;
        }
        boolean zIsOrderedBroadcast = isOrderedBroadcast();
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        synchronized (CloudMessagingReceiver.class) {
            try {
                SoftReference softReference = zza;
                ExecutorService executorServiceUnconfigurableExecutorService = softReference != null ? (ExecutorService) softReference.get() : null;
                if (executorServiceUnconfigurableExecutorService == null) {
                    executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new NamedThreadFactory(C0000.decode(new byte[]{5, 88, 75, 92, 83, 82, 67, 85, 78, 10, 92, 86, 21, 7, 28, 80, 0, 68, 77, 86, 67}, "c1991300cc528bd5", true))));
                    zza = new SoftReference(executorServiceUnconfigurableExecutorService);
                }
                executorService = executorServiceUnconfigurableExecutorService;
            } catch (Throwable th) {
                throw th;
            }
        }
        executorService.execute(new zzf(this, intent, context, zIsOrderedBroadcast, pendingResultGoAsync));
    }

    public final int zzb(Context context, Intent intent) {
        int i;
        zzw zzwVarZzg;
        if (intent.getExtras() == null) {
            return 500;
        }
        CloudMessage cloudMessage = new CloudMessage(intent);
        String stringExtra = intent.getStringExtra(C0000.decode(new byte[]{83, 11, 92, 83, 89, 93, 25, 11, 85, 66, 64, 5, 6, 81, 59, 91, 80}, "4d34587f013da4d2", true));
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra(C0000.decode(new byte[]{90, 82, 65, 16, 5, 95, 83, 59, 12, 2}, "772cd86def0111", 0.0f));
        }
        if (TextUtils.isEmpty(stringExtra)) {
            zzwVarZzg = ExceptionsKt.forResult(null);
        } else {
            Bundle bundle = new Bundle();
            String stringExtra2 = intent.getStringExtra(C0000.decode(new byte[]{81, 93, 10, 85, 92, 81, 30, 12, 3, 69, 69, 83, 2, 87, 111, 93, 84}, "62e2040af6"));
            if (stringExtra2 == null) {
                stringExtra2 = intent.getStringExtra(C0000.decode(new byte[]{11, 85, 67, 69, 88, 81, 92, 57, 12, 87}, "f006969fe3", 0.0f));
            }
            bundle.putString(C0000.decode(new byte[]{6, 90, 87, 87, 93, 85, 24, 9, 7, 70, 69, 81, 6, 80, 103, 89, 85}, "a580106db560", false), stringExtra2);
            String strDecode = C0000.decode(new byte[]{3, 86, 92, 85, 15, 92, 77, 71, 69, 10, 93, 71, 1, 77, 105, 92, 0}, "d932c9c77e92b965", 6);
            Integer numValueOf = intent.hasExtra(strDecode) ? Integer.valueOf(intent.getIntExtra(strDecode, 0)) : null;
            if (numValueOf != null) {
                bundle.putInt(C0000.decode(new byte[]{83, 93, 10, 95, 92, 86, 76, 65, 20, 86, 80, 71, 6, 76, 111, 90, 6}, "42e803b1f9"), numValueOf.intValue());
            }
            bundle.putBoolean(C0000.decode(new byte[]{22, 69, 69, 73, 11, 23, 21, 71, 58, 93, 80, 74, 23, 4, 6, 81, 58, 88, 84, 87, 0, 9, 4, 80}, "e059dea4", false), true);
            zzu zzuVarZzb = zzu.zzb(context);
            synchronized (zzuVarZzb) {
                i = zzuVarZzb.zze;
                zzuVarZzb.zze = i + 1;
            }
            zzwVarZzg = zzuVarZzb.zzg(new zzq(i, 2, bundle, 0));
        }
        int iOnMessageReceive = onMessageReceive(context, cloudMessage);
        try {
            ExceptionsKt.await(zzwVarZzg, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
            return iOnMessageReceive;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            C0000.decode(new byte[]{44, 82, 75, 71, 81, 85, 83, 22, 0, 1, 10, 23, 94, 85, 89, 94, 83, 82, 91, 66}, "a7840266ab", 7).concat(e.toString());
            return iOnMessageReceive;
        }
    }
}
