package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManagerImpl;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zad;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.Hex;
import java.lang.reflect.Modifier;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final Object zaa = new Object();
    public static final GoogleApiAvailability zab = new GoogleApiAvailability();

    public static AlertDialog zaa(Activity activity, int i, zad zadVar, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = C0000.decode(new byte[]{55, 89, 0, 14, 3, 22, 38, 8, 2, 93, 10, 4, 72, 121, 14, 4, 17, 69}, "c1ecf8ba", false).equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(com.google.android.gms.common.internal.zac.zad(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i == 1) {
            string = resources.getString(2131427340);
        } else if (i != 2) {
            string = i != 3 ? resources.getString(R.string.ok) : resources.getString(2131427337);
        } else {
            string = resources.getString(2131427347);
        }
        if (string != null) {
            builder.setPositiveButton(string, zadVar);
        }
        String strZag = com.google.android.gms.common.internal.zac.zag(activity, i);
        if (strZag != null) {
            builder.setTitle(strZag);
        }
        new IllegalArgumentException();
        return builder.create();
    }

    public static void zad(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        String strDecode = C0000.decode(new byte[]{33, 2, 10, 91, 92, 76, 18, 93, 13, 67, 18, 15, 5, 76, 19, 86, 71, 85, 8, 16, 6, 10, 5, 89, 92, 95}, "bcd53829d0", 5);
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManagerImpl fragmentManagerImpl = ((FragmentActivity.HostCallbacks) ((FragmentActivity) activity).mFragments.delegate).mFragmentManager;
                SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
                supportErrorDialogFragment.mStyle = 0;
                supportErrorDialogFragment.mTheme = 0;
                supportErrorDialogFragment.mCancelable = true;
                supportErrorDialogFragment.mShowsDialog = true;
                supportErrorDialogFragment.mBackStackId = -1;
                zzag.checkNotNull(alertDialog, strDecode);
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                supportErrorDialogFragment.zaa = alertDialog;
                if (onCancelListener != null) {
                    supportErrorDialogFragment.zab = onCancelListener;
                }
                supportErrorDialogFragment.mDismissed = false;
                supportErrorDialogFragment.mShownByMe = true;
                fragmentManagerImpl.getClass();
                BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
                int modifiers = SupportErrorDialogFragment.class.getModifiers();
                if (SupportErrorDialogFragment.class.isAnonymousClass() || !Modifier.isPublic(modifiers) || (SupportErrorDialogFragment.class.isMemberClass() && !Modifier.isStatic(modifiers))) {
                    throw new IllegalStateException(C0000.decode(new byte[]{37, 16, 85, 3, 88, 4, 11, 67, 67}, "cb4d5ae7") + SupportErrorDialogFragment.class.getCanonicalName() + C0000.decode(new byte[]{65, 91, 20, 68, 66, 67, 80, 82, 24, 0, 23, 71, 23, 7, 15, 90, 2, 22, 18, 67, 87, 23, 91, 84, 24, 2, 91, 86, 17, 22, 67, 71, 14, 22, 3, 82, 22, 67, 66, 69, 87, 17, 82, 69, 14, 28, 67, 65, 4, 85, 19, 82, 87, 23, 87, 83, 24, 7, 69, 88, 15, 69, 10, 93, 18, 66, 0, 89, 85, 6, 18, 68, 76, 0, 67, 82, 76}, "a6a76c278a77bec3", false));
                }
                supportErrorDialogFragment.mFragmentManager = backStackRecord.mManager;
                String str2 = supportErrorDialogFragment.mTag;
                if (str2 == null || str.equals(str2)) {
                    supportErrorDialogFragment.mTag = str;
                    backStackRecord.addOp(new BackStackRecord.Op(1, supportErrorDialogFragment));
                    backStackRecord.commitInternal(false);
                    return;
                } else {
                    throw new IllegalStateException(C0000.decode(new byte[]{114, 86, 15, 66, 76, 67, 85, 92, 80, 15, 86, 82, 65, 17, 89, 4, 22, 91, 87, 65, 87, 69, 0, 2, 85, 6, 88, 64, 17}, "17ae8c641a") + supportErrorDialogFragment + C0000.decode(new byte[]{10, 24, 17, 82, 16, 25}, "08f3c9eb76", 2) + supportErrorDialogFragment.mTag + C0000.decode(new byte[]{66, 86, 10, 67, 23}, "b8e478c5c7c7", 0.0f) + str);
                }
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        zzag.checkNotNull(alertDialog, strDecode);
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        errorDialogFragment.zaa = alertDialog;
        if (onCancelListener != null) {
            errorDialogFragment.zab = onCancelListener;
        }
        errorDialogFragment.show(fragmentManager, str);
    }

    public final void showErrorDialogFragment(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogZaa = zaa(googleApiActivity, i, new zad(super.getErrorResolutionIntent(googleApiActivity, C0000.decode(new byte[]{82}, "69f2fa771245", 0.0f), i), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogZaa == null) {
            return;
        }
        zad(googleApiActivity, alertDialogZaa, C0000.decode(new byte[]{126, 93, 13, 94, 92, 85, 103, 91, 3, 28, 101, 0, 69, 78, 80, 81, 7, 74, 117, 66, 69, 88, 16, 33, 95, 4, 91, 87, 94}, "92b90077be6e78"), googleApiActivity2);
    }

    public final void zae(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        new IllegalArgumentException();
        if (i == 18) {
            new zac(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            return;
        }
        String strZai = i == 6 ? com.google.android.gms.common.internal.zac.zai(context, C0000.decode(new byte[]{86, 91, 89, 85, 13, 94, 104, 80, 89, 91, 6, 10, 92, 108, 69, 88, 85, 65, 61, 67, 82, 69, 64, 93, 2, 3, 74, 108, 71, 81, 71, 87, 14, 69, 67, 94, 89, 90, 62, 20, 92, 66, 64, 93, 70, 93, 6, 111, 67, 94, 66, 88, 4}, "5448b07764af93")) : com.google.android.gms.common.internal.zac.zag(context, i);
        if (strZai == null) {
            strZai = context.getResources().getString(2131427344);
        }
        String strZah = (i == 6 || i == 19) ? com.google.android.gms.common.internal.zac.zah(context, C0000.decode(new byte[]{81, 13, 94, 8, 11, 93, 58, 86, 88, 12, 85, 14, 86, 58, 20, 95, 4, 72, 104, 16, 87, 16, 69, 12, 7, 86, 22, 110, 69, 6, 65, 13, 95, 16, 16, 90, 10, 95, 104, 17, 87, 19, 70, 12, 22, 86, 1, 110, 67, 6, 74, 22}, "2b3ed3e17c", 0.0f), com.google.android.gms.common.internal.zac.zaa(context)) : com.google.android.gms.common.internal.zac.zad(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService(C0000.decode(new byte[]{89, 86, 64, 89, 3, 88, 84, 88, 64, 89, 10, 95}, "7940e1"));
        zzag.checkNotNull(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, null);
        notificationCompat$Builder.mLocalOnly = true;
        notificationCompat$Builder.setFlag(16, true);
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(strZai);
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
        notificationCompat$BigTextStyle.mBigText = NotificationCompat$Builder.limitCharSequenceLength(strZah);
        notificationCompat$Builder.setStyle(notificationCompat$BigTextStyle);
        PackageManager packageManager = context.getPackageManager();
        if (Hex.zzd == null) {
            Hex.zzd = Boolean.valueOf(packageManager.hasSystemFeature(C0000.decode(new byte[]{88, 13, 7, 19, 95, 93, 87, 77, 80, 89, 20, 0, 22, 86, 71, 87, 23, 23, 26, 17, 85, 26, 68, 2, 76, 91, 14}, "9cca043c88fda752", 0.0f)));
        }
        if (Hex.zzd.booleanValue()) {
            notificationCompat$Builder.mNotification.icon = context.getApplicationInfo().icon;
            notificationCompat$Builder.mPriority = 2;
            if (Hex.isWearableWithoutPlayStore(context)) {
                notificationCompat$Builder.mActions.add(new NotificationCompat$Action(resources.getString(2131427352), pendingIntent));
            } else {
                notificationCompat$Builder.mContentIntent = pendingIntent;
            }
        } else {
            notificationCompat$Builder.mNotification.icon = R.drawable.stat_sys_warning;
            notificationCompat$Builder.mNotification.tickerText = NotificationCompat$Builder.limitCharSequenceLength(resources.getString(2131427344));
            notificationCompat$Builder.mNotification.when = System.currentTimeMillis();
            notificationCompat$Builder.mContentIntent = pendingIntent;
            notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(strZah);
        }
        synchronized (zaa) {
        }
        String strDecode = C0000.decode(new byte[]{85, 92, 84, 74, 6, 10, 90, 4, 90, 1, 24, 82, 87, 0, 19, 10, 92, 7, 24, 3, 91, 64, 23, 5, 23, 4, 92, 15, 87, 6, 95, 95, 80, 16, 24}, "639dae5c6d");
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(strDecode);
        String string = context.getResources().getString(2131427343);
        if (notificationChannel == null) {
            notificationManager.createNotificationChannel(new NotificationChannel(strDecode, string, 4));
        } else if (!string.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(string);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationCompat$Builder.mChannelId = strDecode;
        Notification notificationBuild = notificationCompat$Builder.build();
        if (i == 1 || i == 2 || i == 3) {
            GooglePlayServicesUtil.sCanceledAvailabilityNotification.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationBuild);
    }

    public final void zag(Activity activity, LifecycleFragment lifecycleFragment, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogZaa = zaa(activity, i, new zad(super.getErrorResolutionIntent(activity, C0000.decode(new byte[]{84}, "04e0044579ff32ae", 3), i), lifecycleFragment, 1), onCancelListener);
        if (alertDialogZaa == null) {
            return;
        }
        zad(activity, alertDialogZaa, C0000.decode(new byte[]{36, 11, 90, 82, 90, 82, 102, 15, 2, 29, 102, 80, 68, 65, 95, 0, 6, 23, 112, 71, 68, 88, 68, 39, 10, 5, 89, 90, 81}, "cd55676c", false), onCancelListener);
    }
}
