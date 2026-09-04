package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionCompat21;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class zzf implements Runnable {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ Object zze;

    public /* synthetic */ zzf(CloudMessagingReceiver cloudMessagingReceiver, Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        this.zza = cloudMessagingReceiver;
        this.zzb = intent;
        this.zzc = context;
        this.zzd = z;
        this.zze = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int iZzb;
        switch (this.$r8$classId) {
            case 0:
                CloudMessagingReceiver cloudMessagingReceiver = (CloudMessagingReceiver) this.zza;
                Intent intent = (Intent) this.zzb;
                Context context = (Context) this.zzc;
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.zze;
                try {
                    Parcelable parcelableExtra = intent.getParcelableExtra(C0000.decode(new byte[]{70, 74, 81, 65, 20, 87, 1, 59, 92, 86, 69, 93, 94, 69}, "1801d2ed58"));
                    Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
                    if (intent2 != null) {
                        String strDecode = C0000.decode(new byte[]{20, 87, 11, 92, 8, 90, 5, 102, 12, 15, 65, 1, 91, 68}, "d2e8a4b9ea5d50", 0.0f);
                        PendingIntent pendingIntent = (PendingIntent) intent2.getParcelableExtra(strDecode);
                        if (pendingIntent != null) {
                            try {
                                pendingIntent.send();
                                break;
                            } catch (PendingIntent.CanceledException unused) {
                            }
                        }
                        Bundle extras = intent2.getExtras();
                        if (extras != null) {
                            extras.remove(strDecode);
                        } else {
                            extras = new Bundle();
                        }
                        String action = intent2.getAction();
                        String strDecode2 = C0000.decode(new byte[]{81, 95, 93, 25, 6, 12, 92, 83, 91, 81, 75, 80, 80, 64, 87, 82, 81, 68, 4, 77, 94, 81, 68, 71, 4, 81, 80, 92, 85, 30, 126, 120, 53, 42, 117, 125, 116, 117, 49, 127, 118, 124, 109, 116, 121, 100, 44, 42, 96, 103}, "2007ac3474e692", 4);
                        if (action == strDecode2 || (action != null && action.equals(strDecode2))) {
                            cloudMessagingReceiver.onNotificationDismissed(extras);
                            iZzb = -1;
                        } else {
                            iZzb = 500;
                        }
                    } else {
                        iZzb = cloudMessagingReceiver.zzb(context, intent);
                    }
                    if (this.zzd) {
                        pendingResult.setResultCode(iZzb);
                        break;
                    }
                    return;
                } finally {
                    pendingResult.finish();
                }
            default:
                Fragment fragment = (Fragment) this.zza;
                Fragment fragment2 = (Fragment) this.zzb;
                if (this.zzd) {
                    fragment2.getClass();
                } else {
                    fragment.getClass();
                }
                View view = (View) this.zzc;
                if (view != null) {
                    FragmentTransitionCompat21.getBoundsOnScreen(view, (Rect) this.zze);
                    return;
                }
                return;
        }
    }

    public zzf(Fragment fragment, Fragment fragment2, boolean z, ArrayMap arrayMap, View view, FragmentTransitionCompat21 fragmentTransitionCompat21, Rect rect) {
        this.zza = fragment;
        this.zzb = fragment2;
        this.zzd = z;
        this.zzc = view;
        this.zze = rect;
    }
}
