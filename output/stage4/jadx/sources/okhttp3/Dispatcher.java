package okhttp3;

import android.app.Notification;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompatBuilder$Api16Impl;
import androidx.core.app.NotificationCompatBuilder$Api17Impl;
import androidx.core.app.NotificationCompatBuilder$Api19Impl;
import androidx.core.app.NotificationCompatBuilder$Api20Impl;
import androidx.core.app.NotificationCompatBuilder$Api21Impl;
import androidx.core.app.NotificationCompatBuilder$Api23Impl;
import androidx.core.app.NotificationCompatBuilder$Api24Impl;
import androidx.core.app.NotificationCompatBuilder$Api26Impl;
import androidx.core.app.NotificationCompatBuilder$Api28Impl;
import androidx.core.app.NotificationCompatBuilder$Api29Impl;
import androidx.core.app.NotificationCompatBuilder$Api31Impl;
import androidx.core.graphics.drawable.IconCompat;
import androidx.room.RoomSQLiteQuery;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.SerialExecutorImpl;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.zzu;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.text.CharsKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import okhttp3.internal.Util;
import okhttp3.internal.Util$$ExternalSyntheticLambda1;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.RealWebSocket;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Dispatcher {
    public Object executorServiceOrNull;
    public final Object readyAsyncCalls;
    public final Object runningAsyncCalls;
    public final Object runningSyncCalls;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32, types: [android.net.Uri, java.lang.CharSequence, long[]] */
    /* JADX WARN: Type inference failed for: r8v33 */
    public Dispatcher(NotificationCompat$Builder notificationCompat$Builder) {
        String strDecode;
        ArrayList arrayList;
        ?? r8;
        int i;
        ArrayList arrayList2;
        int i2;
        new ArrayList();
        this.runningSyncCalls = new Bundle();
        this.runningAsyncCalls = notificationCompat$Builder;
        Context context = notificationCompat$Builder.mContext;
        ArrayList arrayList3 = notificationCompat$Builder.mPeople;
        ArrayList arrayList4 = notificationCompat$Builder.mPersonList;
        ArrayList arrayList5 = notificationCompat$Builder.mInvisibleActions;
        this.executorServiceOrNull = context;
        Notification.Builder builderCreateBuilder = NotificationCompatBuilder$Api26Impl.createBuilder(context, notificationCompat$Builder.mChannelId);
        this.readyAsyncCalls = builderCreateBuilder;
        Notification notification = notificationCompat$Builder.mNotification;
        Context context2 = null;
        builderCreateBuilder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(notificationCompat$Builder.mContentTitle).setContentText(notificationCompat$Builder.mContentText).setContentInfo(null).setContentIntent(notificationCompat$Builder.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(notificationCompat$Builder.mFullScreenIntent, (notification.flags & 128) != 0).setNumber(notificationCompat$Builder.mNumber).setProgress(0, 0, false);
        IconCompat iconCompat = notificationCompat$Builder.mLargeIcon;
        NotificationCompatBuilder$Api23Impl.setLargeIcon(builderCreateBuilder, iconCompat == null ? null : IconCompat.Api23Impl.toIcon(iconCompat, context));
        NotificationCompatBuilder$Api16Impl.setPriority(NotificationCompatBuilder$Api16Impl.setUsesChronometer(NotificationCompatBuilder$Api16Impl.setSubText(builderCreateBuilder, null), false), notificationCompat$Builder.mPriority);
        ArrayList arrayList6 = notificationCompat$Builder.mActions;
        int size = arrayList6.size();
        int i3 = 0;
        while (true) {
            strDecode = C0000.decode(new byte[]{87, 95, 80, 16, 14, 93, 81, 23, 18, 76, 18, 68, 89, 67, 64, 76, 0, 88, 89, 86, 22, 126, 7, 90, 83, 67, 85, 22, 4, 80, 103, 92, 17, 85, 11, 81, 69}, "614ba459a9b4");
            if (i3 >= size) {
                break;
            }
            Object obj = arrayList6.get(i3);
            i3++;
            NotificationCompat$Action notificationCompat$Action = (NotificationCompat$Action) obj;
            if (notificationCompat$Action.mIcon == null && (i2 = notificationCompat$Action.icon) != 0) {
                notificationCompat$Action.mIcon = IconCompat.createWithResource(i2);
            }
            IconCompat iconCompat2 = notificationCompat$Action.mIcon;
            boolean z = notificationCompat$Action.mAllowGeneratedReplies;
            Bundle bundle = notificationCompat$Action.mExtras;
            Notification.Action.Builder builderCreateBuilder2 = NotificationCompatBuilder$Api23Impl.createBuilder(iconCompat2 != null ? IconCompat.Api23Impl.toIcon(iconCompat2, context2) : context2, notificationCompat$Action.title, notificationCompat$Action.actionIntent);
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putBoolean(strDecode, z);
            int i4 = Build.VERSION.SDK_INT;
            NotificationCompatBuilder$Api24Impl.setAllowGeneratedReplies(builderCreateBuilder2, z);
            bundle2.putInt(C0000.decode(new byte[]{7, 11, 5, 75, 86, 88, 83, 27, 71, 64, 18, 18, 86, 67, 68, 31, 7, 6, 21, 80, 86, 95, 25, 70, 81, 88, 3, 12, 77, 88, 83, 112, 5, 17, 8, 86, 87}, "fea9917545bb9101", true), 0);
            if (i4 >= 28) {
                NotificationCompatBuilder$Api28Impl.setSemanticAction(builderCreateBuilder2, 0);
            }
            if (i4 >= 29) {
                NotificationCompatBuilder$Api29Impl.setContextual(builderCreateBuilder2, false);
            }
            if (i4 >= 31) {
                NotificationCompatBuilder$Api31Impl.setAuthenticationRequired(builderCreateBuilder2, false);
            }
            bundle2.putBoolean(C0000.decode(new byte[]{83, 92, 6, 65, 91, 90, 86, 28, 17, 70, 68, 67, 93, 64, 22, 29, 85, 80, 70, 91, 13, 93, 26, 64, 90, 93, 21, 64, 97, 64, 87, 64, 43, 93, 64, 86, 64, 84, 3, 80, 81}, "22b343"), notificationCompat$Action.mShowsUserInterface);
            NotificationCompatBuilder$Api20Impl.addExtras(builderCreateBuilder2, bundle2);
            NotificationCompatBuilder$Api20Impl.addAction((Notification.Builder) this.readyAsyncCalls, NotificationCompatBuilder$Api20Impl.build(builderCreateBuilder2));
            context2 = null;
        }
        Bundle bundle3 = notificationCompat$Builder.mExtras;
        if (bundle3 != null) {
            ((Bundle) this.runningSyncCalls).putAll(bundle3);
        }
        int i5 = Build.VERSION.SDK_INT;
        NotificationCompatBuilder$Api17Impl.setShowWhen((Notification.Builder) this.readyAsyncCalls, notificationCompat$Builder.mShowWhen);
        NotificationCompatBuilder$Api20Impl.setLocalOnly((Notification.Builder) this.readyAsyncCalls, notificationCompat$Builder.mLocalOnly);
        NotificationCompatBuilder$Api20Impl.setGroup((Notification.Builder) this.readyAsyncCalls, null);
        NotificationCompatBuilder$Api20Impl.setSortKey((Notification.Builder) this.readyAsyncCalls, null);
        NotificationCompatBuilder$Api20Impl.setGroupSummary((Notification.Builder) this.readyAsyncCalls, false);
        NotificationCompatBuilder$Api21Impl.setCategory((Notification.Builder) this.readyAsyncCalls, notificationCompat$Builder.mCategory);
        NotificationCompatBuilder$Api21Impl.setColor((Notification.Builder) this.readyAsyncCalls, notificationCompat$Builder.mColor);
        NotificationCompatBuilder$Api21Impl.setVisibility((Notification.Builder) this.readyAsyncCalls, notificationCompat$Builder.mVisibility);
        NotificationCompatBuilder$Api21Impl.setPublicVersion((Notification.Builder) this.readyAsyncCalls, null);
        NotificationCompatBuilder$Api21Impl.setSound((Notification.Builder) this.readyAsyncCalls, notification.sound, notification.audioAttributes);
        if (i5 < 28) {
            if (arrayList4 == null) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList(arrayList4.size());
                Iterator it = arrayList4.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
            }
            if (arrayList2 != null) {
                if (arrayList3 == null) {
                    arrayList3 = arrayList2;
                } else {
                    ArraySet arraySet = new ArraySet(arrayList3.size() + arrayList2.size());
                    arraySet.addAll(arrayList2);
                    arraySet.addAll(arrayList3);
                    arrayList3 = new ArrayList(arraySet);
                }
            }
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            int i6 = 0;
            while (i6 < size2) {
                Object obj2 = arrayList3.get(i6);
                i6++;
                NotificationCompatBuilder$Api21Impl.addPerson((Notification.Builder) this.readyAsyncCalls, (String) obj2);
            }
        }
        if (arrayList5.size() > 0) {
            if (notificationCompat$Builder.mExtras == null) {
                notificationCompat$Builder.mExtras = new Bundle();
            }
            Bundle bundle4 = notificationCompat$Builder.mExtras;
            String strDecode2 = C0000.decode(new byte[]{86, 90, 81, 22, 93, 13, 81, 75, 84, 3, 65, 30, 119, 58, 48, 112, 121, 103, 124, 43, 124, 55}, "745d2d5e7b302bd5", true);
            Bundle bundle5 = bundle4.getBundle(strDecode2);
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            int i7 = 0;
            while (i7 < arrayList5.size()) {
                String string = Integer.toString(i7);
                NotificationCompat$Action notificationCompat$Action2 = (NotificationCompat$Action) arrayList5.get(i7);
                Bundle bundle8 = new Bundle();
                if (notificationCompat$Action2.mIcon == null && (i = notificationCompat$Action2.icon) != 0) {
                    notificationCompat$Action2.mIcon = IconCompat.createWithResource(i);
                }
                IconCompat iconCompat3 = notificationCompat$Action2.mIcon;
                Bundle bundle9 = notificationCompat$Action2.mExtras;
                ArrayList arrayList7 = arrayList4;
                bundle8.putInt(C0000.decode(new byte[]{15, 86, 89, 92}, "f56234", true), iconCompat3 != null ? iconCompat3.getResId() : 0);
                bundle8.putCharSequence(C0000.decode(new byte[]{23, 91, 71, 13, 1}, "c23ad9", true), notificationCompat$Action2.title);
                bundle8.putParcelable(C0000.decode(new byte[]{83, 6, 23, 94, 14, 93, 43, 86, 70, 0, 13, 67}, "2ec7a3b8", 2), notificationCompat$Action2.actionIntent);
                Bundle bundle10 = bundle9 != null ? new Bundle(bundle9) : new Bundle();
                bundle10.putBoolean(strDecode, notificationCompat$Action2.mAllowGeneratedReplies);
                bundle8.putBundle(C0000.decode(new byte[]{0, 26, 23, 66, 2, 75}, "ebc0c80077", true), bundle10);
                bundle8.putParcelableArray(C0000.decode(new byte[]{68, 84, 89, 12, 68, 85, 121, 88, 22, 64, 66, 23}, "614c0006f56d", 1), null);
                bundle8.putBoolean(C0000.decode(new byte[]{68, 81, 95, 64, 69, 48, 68, 92, 66, 126, 88, 17, 82, 75, 86, 86, 85, 0}, "79076e"), notificationCompat$Action2.mShowsUserInterface);
                bundle8.putInt(C0000.decode(new byte[]{66, 92, 93, 86, 86, 71, 95, 2, 117, 5, 70, 90, 94, 87}, "1907836a4f23", 4), 0);
                bundle7.putBundle(string, bundle8);
                i7++;
                arrayList4 = arrayList7;
            }
            arrayList = arrayList4;
            String strDecode3 = C0000.decode(new byte[]{8, 94, 70, 11, 16, 12, 3, 92, 85, 61, 2, 6, 21, 89, 95, 12, 16}, "a00bce", 1);
            bundle5.putBundle(strDecode3, bundle7);
            bundle6.putBundle(strDecode3, bundle7);
            if (notificationCompat$Builder.mExtras == null) {
                notificationCompat$Builder.mExtras = new Bundle();
            }
            notificationCompat$Builder.mExtras.putBundle(strDecode2, bundle5);
            ((Bundle) this.runningSyncCalls).putBundle(strDecode2, bundle6);
        } else {
            arrayList = arrayList4;
        }
        int i8 = Build.VERSION.SDK_INT;
        NotificationCompatBuilder$Api19Impl.setExtras((Notification.Builder) this.readyAsyncCalls, notificationCompat$Builder.mExtras);
        NotificationCompatBuilder$Api24Impl.setRemoteInputHistory((Notification.Builder) this.readyAsyncCalls, null);
        NotificationCompatBuilder$Api26Impl.setBadgeIconType((Notification.Builder) this.readyAsyncCalls, 0);
        NotificationCompatBuilder$Api26Impl.setSettingsText((Notification.Builder) this.readyAsyncCalls, null);
        NotificationCompatBuilder$Api26Impl.setShortcutId((Notification.Builder) this.readyAsyncCalls, null);
        NotificationCompatBuilder$Api26Impl.setTimeoutAfter((Notification.Builder) this.readyAsyncCalls, 0L);
        NotificationCompatBuilder$Api26Impl.setGroupAlertBehavior((Notification.Builder) this.readyAsyncCalls, 0);
        if (!TextUtils.isEmpty(notificationCompat$Builder.mChannelId)) {
            ((Notification.Builder) this.readyAsyncCalls).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        if (i8 >= 28) {
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                it2.next().getClass();
                throw new ClassCastException();
            }
        }
        if (i8 >= 29) {
            NotificationCompatBuilder$Api29Impl.setAllowSystemGeneratedContextualActions((Notification.Builder) this.readyAsyncCalls, notificationCompat$Builder.mAllowSystemGeneratedContextualActions);
            r8 = 0;
            NotificationCompatBuilder$Api29Impl.setBubbleMetadata((Notification.Builder) this.readyAsyncCalls, null);
        } else {
            r8 = 0;
        }
        if (notificationCompat$Builder.mSilent) {
            ((NotificationCompat$Builder) this.runningAsyncCalls).getClass();
            ((Notification.Builder) this.readyAsyncCalls).setVibrate(r8);
            ((Notification.Builder) this.readyAsyncCalls).setSound(r8);
            int i9 = notification.defaults & (-4);
            notification.defaults = i9;
            ((Notification.Builder) this.readyAsyncCalls).setDefaults(i9);
            ((NotificationCompat$Builder) this.runningAsyncCalls).getClass();
            if (TextUtils.isEmpty(r8)) {
                NotificationCompatBuilder$Api20Impl.setGroup((Notification.Builder) this.readyAsyncCalls, C0000.decode(new byte[]{69, 90, 95, 3, 8, 21}, "633ffa3b"));
            }
            NotificationCompatBuilder$Api26Impl.setGroupAlertBehavior((Notification.Builder) this.readyAsyncCalls, 1);
        }
    }

    public Dispatcher(WorkDatabase_Impl workDatabase_Impl) {
        this.executorServiceOrNull = workDatabase_Impl;
        this.readyAsyncCalls = new WorkTagDao_Impl.AnonymousClass1(workDatabase_Impl, 3);
        this.runningAsyncCalls = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 1);
        this.runningSyncCalls = new WorkTagDao_Impl.AnonymousClass2(workDatabase_Impl, 2);
    }

    public void executeOnTaskThread(Runnable runnable) {
        ((SerialExecutorImpl) this.executorServiceOrNull).execute(runnable);
    }

    public void finished(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError(C0000.decode(new byte[]{34, 87, 94, 94, 22, 20, 87, 75, 91, 69, 21, 22, 91, 92, 27, 5, 90, 81, 82, 10, 21, 23}, "a6226c685b", 0.0f));
            }
        }
        promoteAndExecute();
    }

    public void finished$okhttp(RealCall.AsyncCall asyncCall) {
        asyncCall.callsPerHost.decrementAndGet();
        finished((ArrayDeque) this.runningAsyncCalls, asyncCall);
    }

    public SystemIdInfo getSystemIdInfo(WorkGenerationalId workGenerationalId) {
        String str = workGenerationalId.workSpecId;
        int i = workGenerationalId.generation;
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.executorServiceOrNull;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{100, 125, 122, 124, 117, 101, 70, 72, 70, 119, 101, 119, 123, 25, 101, 72, 21, 22, 3, 92, 126, 92, 127, 87, 80, 94, 70, 53, 46, 116, 101, 125, 22, 78, 89, 67, 13, 61, 21, 65, 82, 91, 105, 80, 82, 12, 89, 66, 39, 127, 115, 24, 81, 92, 88, 84, 20, 3, 18, 88, 88, 86, 11, 6}, "786961fbf1", 0.0f), 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        roomSQLiteQueryAcquire.bindLong(2, i);
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{22, 86, 70, 88, 109, 64, 71, 4, 2, 102, 93, 87}, "a943237a", 6));
            int columnIndexOrThrow2 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{82, 6, 11, 82, 66, 87, 22, 88, 88, 13}, "5ce706b17c", 1));
            int columnIndexOrThrow3 = CharsKt.getColumnIndexOrThrow(cursorQuery, C0000.decode(new byte[]{23, 76, 17, 68, 3, 95, 103, 15, 81}, "d5b0f28f52ee"));
            SystemIdInfo systemIdInfo = null;
            String string = null;
            if (cursorQuery.moveToFirst()) {
                if (!cursorQuery.isNull(columnIndexOrThrow)) {
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                systemIdInfo = new SystemIdInfo(string, cursorQuery.getInt(columnIndexOrThrow2), cursorQuery.getInt(columnIndexOrThrow3));
            }
            return systemIdInfo;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.executorServiceOrNull;
        workDatabase_Impl.assertNotSuspendingTransaction();
        workDatabase_Impl.beginTransaction();
        try {
            ((WorkTagDao_Impl.AnonymousClass1) this.readyAsyncCalls).insert(systemIdInfo);
            workDatabase_Impl.setTransactionSuccessful();
        } finally {
            workDatabase_Impl.internalEndTransaction();
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0060  */
    /* JADX WARN: Code duplicated, block: B:24:0x006e A[Catch: all -> 0x00a7, TryCatch #3 {all -> 0x00a7, blocks: (B:22:0x0068, B:24:0x006e, B:27:0x00a9), top: B:53:0x0068 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x006e, please report this as an issue */
    public void promoteAndExecute() {
        int size;
        int i;
        RealCall.AsyncCall asyncCall;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.readyAsyncCalls).iterator();
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall2 = (RealCall.AsyncCall) it.next();
                    if (((ArrayDeque) this.runningAsyncCalls).size() >= 64) {
                        break;
                    }
                    if (asyncCall2.callsPerHost.get() < 5) {
                        it.remove();
                        asyncCall2.callsPerHost.incrementAndGet();
                        arrayList.add(asyncCall2);
                        ((ArrayDeque) this.runningAsyncCalls).add(asyncCall2);
                    }
                }
                synchronized (this) {
                    ((ArrayDeque) this.runningAsyncCalls).size();
                    ((ArrayDeque) this.runningSyncCalls).size();
                }
                size = arrayList.size();
                for (i = 0; i < size; i++) {
                    asyncCall = (RealCall.AsyncCall) arrayList.get(i);
                    synchronized (this) {
                        try {
                            if (((ThreadPoolExecutor) this.executorServiceOrNull) == null) {
                                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new Util$$ExternalSyntheticLambda1(Util.okHttpName + C0000.decode(new byte[]{70, 34, 15, 64, 22, 80, 77, 85, 90, 85, 20}, "fff3f19620"), false));
                            }
                            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.executorServiceOrNull;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    RealCall realCall = RealCall.this;
                    byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                    try {
                        try {
                            threadPoolExecutor.execute(asyncCall);
                        } catch (Throwable th2) {
                            realCall.client.dispatcher.finished$okhttp(asyncCall);
                            throw th2;
                        }
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException(C0000.decode(new byte[]{86, 27, 93, 81, 23, 71, 9, 70, 70, 74, 82, 88, 7, 87, 71, 6, 92}, "3c82b3f4f872b4"));
                        interruptedIOException.initCause(e);
                        realCall.noMoreExchanges$okhttp(interruptedIOException);
                        ((RealWebSocket) asyncCall.responseCallback.processor).failWebSocket(interruptedIOException);
                        realCall.client.dispatcher.finished$okhttp(asyncCall);
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        size = arrayList.size();
        while (i < size) {
            asyncCall = (RealCall.AsyncCall) arrayList.get(i);
            synchronized (this) {
                if (((ThreadPoolExecutor) this.executorServiceOrNull) == null) {
                    this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new Util$$ExternalSyntheticLambda1(Util.okHttpName + C0000.decode(new byte[]{70, 34, 15, 64, 22, 80, 77, 85, 90, 85, 20}, "fff3f19620"), false));
                }
                ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) this.executorServiceOrNull;
                RealCall realCall2 = RealCall.this;
                byte[] bArr3 = Util.EMPTY_BYTE_ARRAY;
                threadPoolExecutor2.execute(asyncCall);
            }
        }
    }

    public Dispatcher() {
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    public Dispatcher(ExecutorService executorService) {
        this.runningAsyncCalls = new Handler(Looper.getMainLooper());
        this.runningSyncCalls = new zzu(1, this);
        SerialExecutorImpl serialExecutorImpl = new SerialExecutorImpl(executorService);
        this.executorServiceOrNull = serialExecutorImpl;
        this.readyAsyncCalls = new ExecutorCoroutineDispatcherImpl(serialExecutorImpl);
    }

    public Dispatcher(Executor executor, EventStore eventStore, WorkTagDao_Impl workTagDao_Impl, SynchronizationGuard synchronizationGuard) {
        this.executorServiceOrNull = executor;
        this.readyAsyncCalls = eventStore;
        this.runningAsyncCalls = workTagDao_Impl;
        this.runningSyncCalls = synchronizationGuard;
    }
}
