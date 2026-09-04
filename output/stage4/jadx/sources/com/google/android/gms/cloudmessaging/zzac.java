package com.google.android.gms.cloudmessaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat$BigPictureStyle;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat$Api23Impl;
import androidx.core.graphics.drawable.IconCompat;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.ServiceLifecycleDispatcher$DispatchRunnable;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.impl.AutoMigration_14_15;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.messaging.CommonNotificationBuilder;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.ImageDownload;
import com.google.firebase.messaging.ServiceStarter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Provider;
import kotlin.ExceptionsKt;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.Request;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class zzac implements Factory, OnCompleteListener {
    public final /* synthetic */ int $r8$classId;
    public Object zza;
    public Object zzb;
    public Object zzc;

    public /* synthetic */ zzac() {
        this.$r8$classId = 3;
    }

    public AutoValue_TransportContext build() {
        String strDecode = ((String) this.zzb) == null ? C0000.decode(new byte[]{24, 7, 2, 85, 91, 3, 91, 85, 121, 86, 85, 0}, "8ec60f5177", 0.0f) : "";
        if (((Priority) this.zzc) == null) {
            strDecode = strDecode.concat(C0000.decode(new byte[]{68, 22, 23, 15, 10, 17, 95, 17, 24}, "dfefec6ea2b7fbdd", 0.0f));
        }
        if (strDecode.isEmpty()) {
            return new AutoValue_TransportContext((String) this.zzb, (byte[]) this.zza, (Priority) this.zzc);
        }
        throw new IllegalStateException(C0000.decode(new byte[]{46, 93, 64, 75, 95, 90, 3, 25, 19, 0, 16, 20, 94, 74, 7, 80, 67, 68, 65, 87, 70, 81, 22, 77, 8, 0, 18, 91}, "c43864d9aeaa78b4", false).concat(strDecode));
    }

    public void delete(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.zza;
        workDatabase_Impl.assertNotSuspendingTransaction();
        WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = (WorkTagDao_Impl.AnonymousClass2) this.zzb;
        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
        if (str == null) {
            frameworkSQLiteStatementAcquire.bindNull(1);
        } else {
            frameworkSQLiteStatementAcquire.bindString(str, 1);
        }
        workDatabase_Impl.beginTransaction();
        try {
            frameworkSQLiteStatementAcquire.executeUpdateDelete();
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
            anonymousClass2.release(frameworkSQLiteStatementAcquire);
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 4:
                return new TransportRuntime(new ProfileInstaller$2(), new ByteString.Companion(), (Scheduler) ((Request.Builder) this.zza).get(), (Uploader) ((WorkerWrapper.Builder) this.zzb).get(), (Dispatcher) ((ServiceStarter) this.zzc).get());
            default:
                return new WorkTagDao_Impl((Context) ((Provider) this.zza).get(), (EventStore) ((Provider) this.zzb).get(), (AutoValue_SchedulerConfig) ((AutoMigration_14_15) this.zzc).get());
        }
    }

    /* JADX WARN: Code duplicated, block: B:146:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:264:0x05e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v126 */
    /* JADX WARN: Type inference failed for: r0v127, types: [int] */
    /* JADX WARN: Type inference failed for: r0v209 */
    /* JADX WARN: Type inference failed for: r0v210 */
    /* JADX WARN: Type inference failed for: r0v211 */
    /* JADX WARN: Type inference failed for: r0v212 */
    public boolean handleNotification() {
        ImageDownload imageDownload;
        Bundle bundle;
        int identifier;
        Uri defaultUri;
        Intent launchIntentForPackage;
        int i;
        PendingIntent activity;
        Integer numValueOf;
        Long lValueOf;
        long[] jArr;
        int[] iArr;
        IconCompat iconCompat;
        boolean z;
        int i2;
        int i3 = 1;
        if (((ConnectionPool) this.zzc).getBoolean(C0000.decode(new byte[]{82, 91, 88, 26, 95, 29, 91, 87, 64, 93}, "585413", 6))) {
            return true;
        }
        FirebaseMessagingService firebaseMessagingService = (FirebaseMessagingService) this.zzb;
        if (!((KeyguardManager) firebaseMessagingService.getSystemService(C0000.decode(new byte[]{15, 81, 64, 83, 20, 4, 74, 80}, "d494ae84f44c", 1))).inKeyguardRestrictedInputMode()) {
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) firebaseMessagingService.getSystemService(C0000.decode(new byte[]{0, 85, 22, 93, 65, 80, 64, 26}, "a6b4794c4d85b1", 5))).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == iMyPid) {
                        if (runningAppProcessInfo.importance != 100) {
                            break;
                        }
                        return false;
                    }
                }
            }
        }
        String string = ((ConnectionPool) this.zzc).getString(C0000.decode(new byte[]{82, 83, 90, 29, 13, 31, 8, 90, 83, 94, 1}, "5073c1a729dd15c1", 2));
        if (TextUtils.isEmpty(string)) {
            imageDownload = null;
        } else {
            try {
                imageDownload = new ImageDownload(new URL(string));
            } catch (MalformedURLException unused) {
                imageDownload = null;
            }
        }
        if (imageDownload != null) {
            ExecutorService executorService = (ExecutorService) this.zza;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            imageDownload.future = executorService.submit(new Processor$$ExternalSyntheticLambda2(imageDownload, 18, taskCompletionSource));
            imageDownload.task = taskCompletionSource.zza;
        }
        FirebaseMessagingService firebaseMessagingService2 = (FirebaseMessagingService) this.zzb;
        ConnectionPool connectionPool = (ConnectionPool) this.zzc;
        AtomicInteger atomicInteger = CommonNotificationBuilder.requestCodeProvider;
        try {
            ApplicationInfo applicationInfo = firebaseMessagingService2.getPackageManager().getApplicationInfo(firebaseMessagingService2.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                bundle = Bundle.EMPTY;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.toString();
        }
        Bundle bundle2 = bundle;
        String string2 = connectionPool.getString(C0000.decode(new byte[]{84, 82, 93, 23, 94, 29, 88, 15, 82, 23, 89, 92, 85, 59, 91, 81, 82, 95, 94, 92, 92, 108, 80, 5}, "3109039a6e651d89"));
        try {
            if (firebaseMessagingService2.getPackageManager().getApplicationInfo(firebaseMessagingService2.getPackageName(), 0).targetSdkVersion < 26) {
                string2 = null;
            } else {
                NotificationManager notificationManager = (NotificationManager) firebaseMessagingService2.getSystemService(NotificationManager.class);
                if (TextUtils.isEmpty(string2) || notificationManager.getNotificationChannel(string2) == null) {
                    string2 = bundle2.getString(C0000.decode(new byte[]{83, 13, 88, 30, 2, 88, 10, 4, 92, 7, 27, 86, 12, 69, 0, 1, 81, 17, 80, 30, 8, 82, 22, 16, 81, 5, 92, 94, 2, 25, 1, 6, 86, 3, 64, 92, 17, 104, 11, 12, 68, 11, 83, 89, 6, 86, 17, 10, 95, 12, 106, 83, 13, 86, 11, 13, 85, 14, 106, 89, 1}, "0b50e7ec", 0.0f));
                    if (TextUtils.isEmpty(string2) || notificationManager.getNotificationChannel(string2) == null) {
                        string2 = C0000.decode(new byte[]{4, 2, 15, 103, 95, 81, 91, 8, 80, 5, 6, 15, 61, 15, 13, 76, 80, 86, 94, 7, 83, 16, 12, 11, 12, 62, 1, 80, 88, 94, 89, 1, 94}, "bab8907d2ded", 0.0f);
                        if (notificationManager.getNotificationChannel(string2) == null) {
                            int identifier2 = firebaseMessagingService2.getResources().getIdentifier(C0000.decode(new byte[]{65, 110, 68, 5, 72, 76, 93, 25, 71, 65, 81, 15, 6, 91}, "311d269a509ad1"), C0000.decode(new byte[]{70, 64, 71, 88, 12, 1}, "5451bf07c2e3", 0.0f), firebaseMessagingService2.getPackageName());
                            notificationManager.createNotificationChannel(new NotificationChannel(string2, identifier2 == 0 ? C0000.decode(new byte[]{126, 94, 16, 87}, "37c4d4", false) : firebaseMessagingService2.getString(identifier2), 3));
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        AtomicInteger atomicInteger2 = CommonNotificationBuilder.requestCodeProvider;
        String packageName = firebaseMessagingService2.getPackageName();
        Resources resources = firebaseMessagingService2.getResources();
        PackageManager packageManager = firebaseMessagingService2.getPackageManager();
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(firebaseMessagingService2, string2);
        String possiblyLocalizedString = connectionPool.getPossiblyLocalizedString(resources, packageName, C0000.decode(new byte[]{81, 2, 90, 29, 89, 31, 64, 10, 17, 84, 0}, "6a73714ce8e9"));
        if (!TextUtils.isEmpty(possiblyLocalizedString)) {
            notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(possiblyLocalizedString);
        }
        String possiblyLocalizedString2 = connectionPool.getPossiblyLocalizedString(resources, packageName, C0000.decode(new byte[]{83, 81, 14, 22, 87, 75, 87, 94, 80, 75}, "42c89e51", 0.0f));
        if (!TextUtils.isEmpty(possiblyLocalizedString2)) {
            notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(possiblyLocalizedString2);
            NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
            notificationCompat$BigTextStyle.mBigText = NotificationCompat$Builder.limitCharSequenceLength(possiblyLocalizedString2);
            notificationCompat$Builder.setStyle(notificationCompat$BigTextStyle);
        }
        String string3 = connectionPool.getString(C0000.decode(new byte[]{87, 2, 8, 29, 13, 29, 91, 87, 9, 89}, "0ae3c324f7", true));
        if (TextUtils.isEmpty(string3) || (((identifier = resources.getIdentifier(string3, C0000.decode(new byte[]{92, 23, 83, 69, 83, 82, 9, 93}, "8e2220e8c7c6", false), packageName)) == 0 || !CommonNotificationBuilder.isValidIcon(resources, identifier)) && ((identifier = resources.getIdentifier(string3, C0000.decode(new byte[]{12, 12, 68, 92, 84, 73}, "ae415950", 7), packageName)) == 0 || !CommonNotificationBuilder.isValidIcon(resources, identifier)))) {
            identifier = bundle2.getInt(C0000.decode(new byte[]{2, 95, 11, 30, 84, 86, 11, 82, 89, 85, 79, 87, 88, 75, 83, 6, 0, 67, 3, 30, 94, 92, 23, 70, 84, 87, 8, 95, 86, 23, 82, 1, 7, 81, 19, 92, 71, 102, 10, 90, 65, 89, 7, 88, 82, 88, 66, 13, 14, 94, 57, 89, 80, 86, 10}, "a0f039d550a1196d", 0.0f), 0);
            if (identifier == 0 || !CommonNotificationBuilder.isValidIcon(resources, identifier)) {
                try {
                    identifier = packageManager.getApplicationInfo(packageName, 0).icon;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.toString();
                }
            }
            if (identifier == 0 || !CommonNotificationBuilder.isValidIcon(resources, identifier)) {
                identifier = 17301651;
            }
        }
        notificationCompat$Builder.mNotification.icon = identifier;
        String string4 = connectionPool.getString(C0000.decode(new byte[]{5, 87, 90, 24, 11, 26, 17, 87, 68, 86, 83, 81}, "b476e4b8187c14", 0.0f));
        if (TextUtils.isEmpty(string4)) {
            string4 = connectionPool.getString(C0000.decode(new byte[]{86, 90, 94, 74, 86, 74, 18, 90, 65, 87, 82}, "193d8da54962", 4));
        }
        if (TextUtils.isEmpty(string4)) {
            defaultUri = null;
        } else if (C0000.decode(new byte[]{2, 92, 86, 0, 76, 15, 69}, "f90a9c14d4").equals(string4) || resources.getIdentifier(string4, C0000.decode(new byte[]{67, 80, 20}, "11cceff4c986", 0.0f), packageName) == 0) {
            defaultUri = RingtoneManager.getDefaultUri(2);
        } else {
            defaultUri = Uri.parse(C0000.decode(new byte[]{87, 86, 81, 71, 94, 81, 80, 77, 68, 93, 70, 90, 68, 74, 87, 6, 12, 23, 26}, "6855184c", 4) + packageName + C0000.decode(new byte[]{74, 66, 84, 79, 28}, "e05836cb64", 0.0f) + string4);
        }
        if (defaultUri != null) {
            Notification notification = notificationCompat$Builder.mNotification;
            notification.sound = defaultUri;
            notification.audioStreamType = -1;
            notification.audioAttributes = NotificationCompat$Builder.Api21Impl.build(NotificationCompat$Builder.Api21Impl.setUsage(NotificationCompat$Builder.Api21Impl.setContentType(NotificationCompat$Builder.Api21Impl.createBuilder(), 4), 5));
        }
        String string5 = connectionPool.getString(C0000.decode(new byte[]{3, 0, 8, 75, 90, 24, 90, 92, 88, 0, 10, 109, 4, 84, 16, 10, 10, 11}, "dcee46901ca2e7", 0));
        if (TextUtils.isEmpty(string5)) {
            String string6 = connectionPool.getString(C0000.decode(new byte[]{1, 7, 84, 28, 89, 76, 85, 8, 94, 95, 107, 81, 11, 2, 22, 88, 15, 0}, "fd927b9a0440efd7", true));
            if (TextUtils.isEmpty(string6)) {
                string6 = connectionPool.getString(C0000.decode(new byte[]{87, 90, 88, 22, 92, 26, 91, 12, 11, 91}, "0958247ee05b700c"));
            }
            Uri uri = !TextUtils.isEmpty(string6) ? Uri.parse(string6) : null;
            if (uri != null) {
                launchIntentForPackage = new Intent(C0000.decode(new byte[]{3, 92, 1, 19, 91, 13, 86, 29, 91, 91, 69, 80, 87, 16, 76, 83, 6, 21, 93, 11, 92, 29, 100, 124, 116, 98}, "b2ea4d2325159d"));
                launchIntentForPackage.setPackage(packageName);
                launchIntentForPackage.setData(uri);
            } else {
                launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
            }
        } else {
            launchIntentForPackage = new Intent(string5);
            launchIntentForPackage.setPackage(packageName);
            launchIntentForPackage.setFlags(268435456);
        }
        String strDecode = C0000.decode(new byte[]{81, 92, 12, 86, 91, 85, 79, 5, 31, 0, 29, 87}, "63c170af1a3221", 0.0f);
        if (launchIntentForPackage == null) {
            i = 1;
            activity = null;
        } else {
            launchIntentForPackage.addFlags(67108864);
            Bundle bundle3 = (Bundle) connectionPool.delegate;
            Bundle bundle4 = new Bundle(bundle3);
            for (String str : bundle3.keySet()) {
                int i4 = i3;
                if (str.startsWith(C0000.decode(new byte[]{94, 13, 88, 95, 93, 84, 24, 82, 23}, "9b781161", 0.0f)) || str.startsWith(C0000.decode(new byte[]{82, 90, 12, 75, 93, 31}, "59ae3161")) || str.startsWith(C0000.decode(new byte[]{83, 1, 92, 23, 86, 86, 23, 8, 85, 91, 86, 7, 69, 93, 86, 93, 26}, "4b1989ca325f1493", 1))) {
                    bundle4.remove(str);
                }
                i3 = i4;
            }
            i = i3;
            launchIntentForPackage.putExtras(bundle4);
            if (connectionPool.getBoolean(strDecode)) {
                launchIntentForPackage.putExtra(C0000.decode(new byte[]{86, 82, 11, 74, 10, 24, 2, 94, 80, 93, 31, 16, 13, 85, 16, 111, 85, 80, 18, 5}, "11fdd6c0", false), connectionPool.paramsForAnalyticsIntent());
            }
            activity = PendingIntent.getActivity(firebaseMessagingService2, atomicInteger2.incrementAndGet(), launchIntentForPackage, 1140850688);
        }
        notificationCompat$Builder.mContentIntent = activity;
        PendingIntent broadcast = !connectionPool.getBoolean(strDecode) ? null : PendingIntent.getBroadcast(firebaseMessagingService2, atomicInteger2.incrementAndGet(), new Intent(C0000.decode(new byte[]{6, 12, 88, 26, 87, 90, 86, 85, 88, 7, 28, 80, 89, 84, 23, 12, 92, 80, 30, 86, 11, 86, 89, 76, 91, 95, 67, 85, 11, 23, 27, 102, 117, 118, 124, 123, 98, 39}, "ec5405924b2170", 0.0f)).setPackage(firebaseMessagingService2.getPackageName()).putExtra(C0000.decode(new byte[]{64, 69, 0, 70, 71, 85, 83, 104, 8, 88, 67, 85, 89, 67}, "77a670", 1), new Intent(C0000.decode(new byte[]{2, 94, 90, 72, 95, 10, 91, 87, 90, 6, 22, 0, 8, 67, 82, 4, 89, 22, 81, 30, 91, 6, 75, 21, 0, 86, 94, 8, 95, 75, 122, 127, 98, 42, 126, 47, 34, 112, 99, 47, 119, 43, 107, 116, 127, 48, 117, 47, 50, 98}, "a17f8e406c8f")).putExtras(connectionPool.paramsForAnalyticsIntent())), 1140850688);
        if (broadcast != null) {
            notificationCompat$Builder.mNotification.deleteIntent = broadcast;
        }
        String string7 = connectionPool.getString(C0000.decode(new byte[]{5, 0, 15, 30, 86, 74, 1, 12, 14, 95, 74}, "bcb08d", 0));
        if (TextUtils.isEmpty(string7)) {
            i2 = bundle2.getInt(C0000.decode(new byte[]{83, 86, 12, 76, 94, 14, 93, 94, 92, 92, 79, 4, 80, 19, 87, 91, 81, 74, 4, 76, 84, 4, 65, 74, 81, 94, 8, 12, 94, 79, 86, 92, 86, 88, 20, 14, 77, 62, 92, 86, 68, 80, 7, 11, 90, 0, 70, 80, 95, 87, 62, 1, 86, 13, 93, 75}, "09ab9a29", true), 0);
            if (i2 != 0) {
                numValueOf = Integer.valueOf(ContextCompat$Api23Impl.getColor(firebaseMessagingService2, i2));
            } else {
                numValueOf = null;
            }
        } else {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(string7));
            } catch (IllegalArgumentException unused3) {
                i2 = bundle2.getInt(C0000.decode(new byte[]{83, 86, 12, 76, 94, 14, 93, 94, 92, 92, 79, 4, 80, 19, 87, 91, 81, 74, 4, 76, 84, 4, 65, 74, 81, 94, 8, 12, 94, 79, 86, 92, 86, 88, 20, 14, 77, 62, 92, 86, 68, 80, 7, 11, 90, 0, 70, 80, 95, 87, 62, 1, 86, 13, 93, 75}, "09ab9a29", true), 0);
                if (i2 != 0) {
                    try {
                        numValueOf = Integer.valueOf(ContextCompat$Api23Impl.getColor(firebaseMessagingService2, i2));
                    } catch (Resources.NotFoundException unused4) {
                        numValueOf = null;
                    }
                } else {
                    numValueOf = null;
                }
            }
        }
        if (numValueOf != null) {
            notificationCompat$Builder.mColor = numValueOf.intValue();
        }
        notificationCompat$Builder.setFlag(16, !connectionPool.getBoolean(C0000.decode(new byte[]{81, 5, 12, 77, 8, 74, 16, 67, 95, 6, 91, 75}, "6facfdc76e02", false)));
        notificationCompat$Builder.mLocalOnly = connectionPool.getBoolean(C0000.decode(new byte[]{2, 7, 11, 29, 94, 30, 89, 13, 6, 5, 10, 108, 95, 94, 89, 27}, "edf3005b", 0.0f));
        String string8 = connectionPool.getString(C0000.decode(new byte[]{94, 1, 15, 23, 12, 75, 77, 11, 1, 82, 7, 23}, "9bb9be"));
        if (string8 != null) {
            notificationCompat$Builder.mNotification.tickerText = NotificationCompat$Builder.limitCharSequenceLength(string8);
        }
        Integer integer = connectionPool.getInteger(C0000.decode(new byte[]{87, 2, 95, 75, 93, 72, 94, 14, 70, 12, 85, 15, 83, 0, 70, 12, 92, 8, 111, 17, 64, 12, 92, 20, 89, 21, 75}, "0a2e3f", 1));
        if (integer == null || integer.intValue() < -2 || integer.intValue() > 2) {
            integer = null;
        }
        if (integer != null) {
            notificationCompat$Builder.mPriority = integer.intValue();
        }
        Integer integer2 = connectionPool.getInteger(C0000.decode(new byte[]{86, 81, 90, 72, 94, 79, 70, 80, 70, 80, 6, 15, 15, 90, 65, 27}, "127f0a0959dfc35b", 6));
        if (integer2 == null || integer2.intValue() < -1 || integer2.intValue() > i) {
            integer2 = null;
        }
        if (integer2 != null) {
            notificationCompat$Builder.mVisibility = integer2.intValue();
        }
        Integer integer3 = connectionPool.getInteger(C0000.decode(new byte[]{86, 90, 14, 76, 88, 24, 87, 90, 18, 95, 87, 80, 0, 3, 66, 95, 86, 91, 57, 85, 94, 76, 13, 22}, "19cb6695f6", 0.0f));
        if (integer3 == null || integer3.intValue() < 0) {
            integer3 = null;
        }
        if (integer3 != null) {
            notificationCompat$Builder.mNumber = integer3.intValue();
        }
        String strDecode2 = C0000.decode(new byte[]{2, 0, 12, 23, 13, 24, 80, 67, 0, 13, 21, 102, 23, 95, 88, 80}, "eca9c655", 7);
        String string9 = connectionPool.getString(strDecode2);
        if (TextUtils.isEmpty(string9)) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(string9));
            } catch (NumberFormatException unused5) {
                ConnectionPool.userFriendlyKey(strDecode2);
                lValueOf = null;
            }
        }
        if (lValueOf != null) {
            notificationCompat$Builder.mShowWhen = true;
            notificationCompat$Builder.mNotification.when = lValueOf.longValue();
        }
        JSONArray jSONArray = connectionPool.getJSONArray(C0000.decode(new byte[]{1, 87, 8, 30, 92, 30, 68, 95, 80, 16, 82, 70, 92, 57, 76, 10, 11, 93, 11, 87, 65}, "f4e020262b329f8c"));
        if (jSONArray == null) {
            jArr = null;
        } else {
            try {
                if (jSONArray.length() <= 1) {
                    throw new JSONException(C0000.decode(new byte[]{19, 12, 85, 69, 81, 16, 82, 101, 95, 88, 10, 8, 94, 71, 69, 13, 86, 65, 85, 68, 94, 95, 64, 84, 15, 15, 93, 20, 9, 0, 89, 80, 68, 12}, "ee770d7165cf94", true));
                }
                int length = jSONArray.length();
                jArr = new long[length];
                for (int i5 = 0; i5 < length; i5++) {
                    jArr[i5] = jSONArray.optLong(i5);
                }
            } catch (NumberFormatException | JSONException unused6) {
                jSONArray.toString();
                jArr = null;
            }
        }
        if (jArr != null) {
            notificationCompat$Builder.mNotification.vibrate = jArr;
        }
        JSONArray jSONArray2 = connectionPool.getJSONArray(C0000.decode(new byte[]{86, 5, 88, 74, 15, 31, 89, 8, 3, 81, 77, 104, 18, 1, 16, 64, 88, 8, 82, 23}, "1f5da15ad997add4", true));
        if (jSONArray2 == null) {
            iArr = null;
        } else {
            iArr = new int[3];
            try {
                if (jSONArray2.length() != 3) {
                    throw new JSONException(C0000.decode(new byte[]{95, 91, 3, 10, 18, 99, 81, 71, 66, 12, 88, 86, 64, 18, 0, 13, 8, 23, 64, 19, 94, 4, 64, 84, 19, 83, 8, 14, 70, 68, 92, 65, 83, 0, 22, 87, 90, 87, 8, 6, 21}, "32dbf0436e61", false));
                }
                int color = Color.parseColor(jSONArray2.optString(0));
                if (color == -16777216) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{55, 69, 83, 91, 71, 70, 84, 64, 92, 94, 66, 19, 2, 92, 15, 14, 17, 23, 91, 70, 20, 95, 91, 68, 88, 92, 95, 87}, "c72546529063a3ca", true));
                }
                iArr[0] = color;
                iArr[1] = jSONArray2.optInt(1);
                iArr[2] = jSONArray2.optInt(2);
            } catch (IllegalArgumentException e3) {
                jSONArray2.toString();
                e3.getMessage();
                iArr = null;
            } catch (JSONException unused7) {
                jSONArray2.toString();
                iArr = null;
            }
        }
        if (iArr != null) {
            int i6 = iArr[0];
            int i7 = iArr[1];
            int i8 = iArr[2];
            Notification notification2 = notificationCompat$Builder.mNotification;
            notification2.ledARGB = i6;
            notification2.ledOnMS = i7;
            notification2.ledOffMS = i8;
            notification2.flags = ((i7 == 0 || i8 == 0) ? 0 : 1) | ((-2) & notification2.flags);
        }
        boolean z2 = connectionPool.getBoolean(C0000.decode(new byte[]{84, 84, 88, 28, 87, 25, 82, 4, 85, 86, 64, 94, 77, 104, 69, 14, 70, 89, 81}, "3752976a", 1));
        ?? r0 = z2;
        if (connectionPool.getBoolean(C0000.decode(new byte[]{1, 81, 15, 75, 86, 74, 2, 87, 4, 4, 77, 8, 18, 109, 20, 12, 90, 22, 7, 70, 7, 58, 76, 13, 11, 91, 12, 2, 75}, "f2be8d", false))) {
            r0 = (z2 ? 1 : 0) | 2;
        }
        ?? r1 = r0;
        if (connectionPool.getBoolean(C0000.decode(new byte[]{80, 87, 90, 25, 8, 25, 0, 82, 83, 89, 66, 88, 67, 104, 10, 94, 3, 95, 65, 103, 68, 81, 67, 67, 15, 89, 3, 68}, "7477f7d758", 3))) {
            r1 = (r0 == true ? 1 : 0) | 4;
        }
        Notification notification3 = notificationCompat$Builder.mNotification;
        notification3.defaults = r1;
        if ((r1 & 4) != 0) {
            notification3.flags |= 1;
        }
        String string10 = connectionPool.getString(C0000.decode(new byte[]{87, 83, 14, 76, 11, 77, 67, 80, 3}, "00cbec71d65e8cb0"));
        if (TextUtils.isEmpty(string10)) {
            string10 = C0000.decode(new byte[]{34, 32, 116, 27, 127, 86, 22, 88, 0, 15, 0, 88, 23, 91, 11, 13, 3}, "dc9619b1ffc9c2", 0.0f) + SystemClock.uptimeMillis();
        }
        String str2 = string10;
        if (imageDownload != null) {
            try {
                zzw zzwVar = imageDownload.task;
                zzag.checkNotNull(zzwVar);
                Bitmap bitmap = (Bitmap) ExceptionsKt.await(zzwVar, 5L, TimeUnit.SECONDS);
                notificationCompat$Builder.setLargeIcon(bitmap);
                NotificationCompat$BigPictureStyle notificationCompat$BigPictureStyle = new NotificationCompat$BigPictureStyle();
                if (bitmap == null) {
                    iconCompat = null;
                    z = true;
                } else {
                    z = true;
                    iconCompat = new IconCompat(1);
                    iconCompat.mObj1 = bitmap;
                }
                notificationCompat$BigPictureStyle.mPictureIcon = iconCompat;
                notificationCompat$BigPictureStyle.mBigLargeIcon = null;
                notificationCompat$BigPictureStyle.mBigLargeIconSet = z;
                notificationCompat$Builder.setStyle(notificationCompat$BigPictureStyle);
            } catch (InterruptedException unused8) {
                imageDownload.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e4) {
                Objects.toString(e4.getCause());
            } catch (TimeoutException unused9) {
                imageDownload.close();
            }
        }
        ((NotificationManager) ((FirebaseMessagingService) this.zzb).getSystemService(C0000.decode(new byte[]{88, 9, 21, 10, 3, 15, 80, 81, 68, 95, 89, 8}, "6facef3006"))).notify(str2, 0, notificationCompat$Builder.build());
        return true;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        Rpc rpc = (Rpc) this.zza;
        String str = (String) this.zzb;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.zzc;
        synchronized (rpc.zze) {
            rpc.zze.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    public void postDispatchRunnable(final Lifecycle$Event lifecycle$Event) {
        ServiceLifecycleDispatcher$DispatchRunnable serviceLifecycleDispatcher$DispatchRunnable = (ServiceLifecycleDispatcher$DispatchRunnable) this.zzc;
        if (serviceLifecycleDispatcher$DispatchRunnable != null) {
            serviceLifecycleDispatcher$DispatchRunnable.run();
        }
        final LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) this.zza;
        Runnable runnable = new Runnable(lifecycleRegistry, lifecycle$Event) { // from class: androidx.lifecycle.ServiceLifecycleDispatcher$DispatchRunnable
            public final Lifecycle$Event event;
            public final LifecycleRegistry registry;
            public boolean wasExecuted;

            {
                this.registry = lifecycleRegistry;
                this.event = lifecycle$Event;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.wasExecuted) {
                    return;
                }
                this.registry.handleLifecycleEvent(this.event);
                this.wasExecuted = true;
            }
        };
        this.zzc = runnable;
        ((Handler) this.zzb).postAtFrontOfQueue(runnable);
    }

    public void setBackendName(String str) {
        if (str == null) {
            throw new NullPointerException(C0000.decode(new byte[]{43, 66, 93, 13, 68, 83, 3, 87, 93, 6, 93, 80, 43, 86, 92, 4}, "e71ad1b46c34", 0.0f));
        }
        this.zzb = str;
    }

    public /* synthetic */ zzac(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public zzac(Set set, String str, String str2) {
        this.$r8$classId = 6;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        Map map = Collections.EMPTY_MAP;
        this.zzb = str2;
        this.zzc = SignInOptions.zaa;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.zza = Collections.unmodifiableSet(hashSet);
        } else {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public zzac(LifecycleService lifecycleService) {
        this.$r8$classId = 2;
        this.zza = new LifecycleRegistry(lifecycleService);
        this.zzb = new Handler();
    }

    public zzac(WorkDatabase_Impl workDatabase_Impl) {
        this.$r8$classId = 1;
        this.zza = workDatabase_Impl;
        new WorkTagDao_Impl.AnonymousClass1(workDatabase_Impl, 5);
        this.zzb = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 3);
        this.zzc = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 4);
    }

    public zzac(FirebaseMessagingService firebaseMessagingService, ConnectionPool connectionPool, ExecutorService executorService) {
        this.$r8$classId = 7;
        this.zza = executorService;
        this.zzb = firebaseMessagingService;
        this.zzc = connectionPool;
    }
}
