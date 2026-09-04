package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.SystemClock;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.SerialExecutorImpl;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import com.google.android.gms.tasks.zzu;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SystemAlarmDispatcher implements ExecutionListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final CommandHandler mCommandHandler;
    public SystemAlarmService mCompletedListener;
    public final Context mContext;
    public Intent mCurrentIntent;
    public final ArrayList mIntents;
    public final Processor mProcessor;
    public final Dispatcher mTaskExecutor;
    public final WorkLauncher mWorkLauncher;
    public final WorkManagerImpl mWorkManager;
    public final WorkTimer mWorkTimer;

    /* JADX INFO: renamed from: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher$1, reason: invalid class name */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final SystemAlarmDispatcher this$0;

        public /* synthetic */ AnonymousClass1(SystemAlarmDispatcher systemAlarmDispatcher, int i) {
            this.$r8$classId = i;
            this.this$0 = systemAlarmDispatcher;
        }

        /* JADX WARN: Code duplicated, block: B:34:0x008c A[Catch: all -> 0x0039, TryCatch #3 {all -> 0x0039, blocks: (B:6:0x0015, B:8:0x0019, B:10:0x0035, B:13:0x003b, B:14:0x0051, B:15:0x0052, B:16:0x005c, B:20:0x0066, B:22:0x006e, B:23:0x0070, B:27:0x007a, B:29:0x0085, B:37:0x0097, B:33:0x008b, B:34:0x008c, B:36:0x0094, B:41:0x009b, B:24:0x0071, B:25:0x0077, B:17:0x005d, B:18:0x0063), top: B:69:0x0015, inners: #1, #2 }] */
        /* JADX WARN: Code duplicated, block: B:36:0x0094 A[Catch: all -> 0x0039, TryCatch #3 {all -> 0x0039, blocks: (B:6:0x0015, B:8:0x0019, B:10:0x0035, B:13:0x003b, B:14:0x0051, B:15:0x0052, B:16:0x005c, B:20:0x0066, B:22:0x006e, B:23:0x0070, B:27:0x007a, B:29:0x0085, B:37:0x0097, B:33:0x008b, B:34:0x008c, B:36:0x0094, B:41:0x009b, B:24:0x0071, B:25:0x0077, B:17:0x005d, B:18:0x0063), top: B:69:0x0015, inners: #1, #2 }] */
        @Override // java.lang.Runnable
        public final void run() {
            zzu zzuVar;
            AnonymousClass1 anonymousClass1;
            boolean zIsEmpty;
            boolean zIsEmpty2;
            switch (this.$r8$classId) {
                case 0:
                    synchronized (this.this$0.mIntents) {
                        SystemAlarmDispatcher systemAlarmDispatcher = this.this$0;
                        systemAlarmDispatcher.mCurrentIntent = (Intent) systemAlarmDispatcher.mIntents.get(0);
                        break;
                    }
                    Intent intent = this.this$0.mCurrentIntent;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = this.this$0.mCurrentIntent.getIntExtra(C0000.decode(new byte[]{45, 113, 58, 103, 100, 49, 120, 52, 55, 57, 127, 116}, "f4c87e9fcf60947d", 5), 0);
                        SystemClock systemClock = SystemClock.get();
                        int i = SystemAlarmDispatcher.$r8$clinit;
                        Objects.toString(this.this$0.mCurrentIntent);
                        systemClock.getClass();
                        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.this$0.mContext, action + C0000.decode(new byte[]{16, 78}, "0f3c4e36", 0.0f) + intExtra + C0000.decode(new byte[]{27}, "25d62f09b9", 0.0f));
                        int i2 = 1;
                        try {
                            try {
                                SystemClock systemClock2 = SystemClock.get();
                                wakeLockNewWakeLock.toString();
                                systemClock2.getClass();
                                wakeLockNewWakeLock.acquire();
                                SystemAlarmDispatcher systemAlarmDispatcher2 = this.this$0;
                                systemAlarmDispatcher2.mCommandHandler.onHandleIntent(intExtra, systemAlarmDispatcher2.mCurrentIntent, systemAlarmDispatcher2);
                                SystemClock systemClock3 = SystemClock.get();
                                wakeLockNewWakeLock.toString();
                                systemClock3.getClass();
                                wakeLockNewWakeLock.release();
                                SystemAlarmDispatcher systemAlarmDispatcher3 = this.this$0;
                                zzuVar = (zzu) systemAlarmDispatcher3.mTaskExecutor.runningSyncCalls;
                                anonymousClass1 = new AnonymousClass1(systemAlarmDispatcher3, i2);
                            } catch (Throwable unused) {
                                SystemClock systemClock4 = SystemClock.get();
                                int i3 = SystemAlarmDispatcher.$r8$clinit;
                                systemClock4.getClass();
                                SystemClock systemClock5 = SystemClock.get();
                                wakeLockNewWakeLock.toString();
                                systemClock5.getClass();
                                wakeLockNewWakeLock.release();
                                SystemAlarmDispatcher systemAlarmDispatcher4 = this.this$0;
                                zzuVar = (zzu) systemAlarmDispatcher4.mTaskExecutor.runningSyncCalls;
                                anonymousClass1 = new AnonymousClass1(systemAlarmDispatcher4, i2);
                            }
                            zzuVar.execute(anonymousClass1);
                            return;
                        } catch (Throwable th) {
                            SystemClock systemClock6 = SystemClock.get();
                            int i4 = SystemAlarmDispatcher.$r8$clinit;
                            wakeLockNewWakeLock.toString();
                            systemClock6.getClass();
                            wakeLockNewWakeLock.release();
                            SystemAlarmDispatcher systemAlarmDispatcher5 = this.this$0;
                            ((zzu) systemAlarmDispatcher5.mTaskExecutor.runningSyncCalls).execute(new AnonymousClass1(systemAlarmDispatcher5, i2));
                            throw th;
                        }
                    }
                    return;
                default:
                    SystemAlarmDispatcher systemAlarmDispatcher6 = this.this$0;
                    SystemClock.get().getClass();
                    SystemAlarmDispatcher.assertMainThread();
                    synchronized (systemAlarmDispatcher6.mIntents) {
                        try {
                            if (systemAlarmDispatcher6.mCurrentIntent != null) {
                                SystemClock systemClock7 = SystemClock.get();
                                Objects.toString(systemAlarmDispatcher6.mCurrentIntent);
                                systemClock7.getClass();
                                if (!((Intent) systemAlarmDispatcher6.mIntents.remove(0)).equals(systemAlarmDispatcher6.mCurrentIntent)) {
                                    throw new IllegalStateException(C0000.decode(new byte[]{115, 80, 65, 71, 84, 22, 81, 24, 83, 21, 83, 93, 92, 14, 85, 91, 83, 21, 89, 65, 17, 13, 91, 65, 23, 65, 88, 87, 17, 5, 93, 71, 68, 65, 30}, "75021c45", 0.0f));
                                }
                                systemAlarmDispatcher6.mCurrentIntent = null;
                            }
                            SerialExecutorImpl serialExecutorImpl = (SerialExecutorImpl) systemAlarmDispatcher6.mTaskExecutor.executorServiceOrNull;
                            CommandHandler commandHandler = systemAlarmDispatcher6.mCommandHandler;
                            synchronized (commandHandler.mLock) {
                                zIsEmpty = commandHandler.mPendingDelayMet.isEmpty();
                                break;
                            }
                            if (zIsEmpty && systemAlarmDispatcher6.mIntents.isEmpty()) {
                                synchronized (serialExecutorImpl.mLock) {
                                    zIsEmpty2 = serialExecutorImpl.mTasks.isEmpty();
                                    break;
                                }
                                if (zIsEmpty2) {
                                    SystemClock.get().getClass();
                                    SystemAlarmService systemAlarmService = systemAlarmDispatcher6.mCompletedListener;
                                    if (systemAlarmService != null) {
                                        systemAlarmService.onAllCommandsCompleted();
                                    }
                                } else if (!systemAlarmDispatcher6.mIntents.isEmpty()) {
                                    systemAlarmDispatcher6.processCommand();
                                }
                            } else if (!systemAlarmDispatcher6.mIntents.isEmpty()) {
                                systemAlarmDispatcher6.processCommand();
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return;
            }
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{97, 31, 75, 68, 4, 89, 32, 8, 83, 74, 8, 34, 81, 18, 66, 7, 76, 83, 9, 81, 19}, "2f80a4ad28ef8a"));
    }

    public SystemAlarmDispatcher(SystemAlarmService systemAlarmService) {
        Context applicationContext = systemAlarmService.getApplicationContext();
        this.mContext = applicationContext;
        StartStopTokens startStopTokens = new StartStopTokens();
        WorkManagerImpl instance$1 = WorkManagerImpl.getInstance$1(systemAlarmService);
        Configuration configuration = instance$1.mConfiguration;
        this.mWorkManager = instance$1;
        this.mCommandHandler = new CommandHandler(applicationContext, (SystemClock) configuration.clock, startStopTokens);
        this.mWorkTimer = new WorkTimer((ConnectionPool) configuration.runnableScheduler);
        Processor processor = instance$1.mProcessor;
        this.mProcessor = processor;
        Dispatcher dispatcher = instance$1.mWorkTaskExecutor;
        this.mTaskExecutor = dispatcher;
        this.mWorkLauncher = new WorkLauncherImpl(processor, dispatcher);
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
    }

    public static void assertMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(C0000.decode(new byte[]{121, 7, 85, 1, 71, 21, 65, 87, 67, 81, 6, 17, 94, 12, 70, 10, 95, 80, 81, 24, 12, 93, 67, 69, 95, 7, 16, 8, 85, 92, 91, 24, 23, 91, 17, 84, 86, 6, 30}, "7b0e4558c3c1", 4));
        }
    }

    public final void add(Intent intent, int i) {
        SystemClock systemClock = SystemClock.get();
        Objects.toString(intent);
        systemClock.getClass();
        assertMainThread();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            SystemClock.get().getClass();
            return;
        }
        if (C0000.decode(new byte[]{116, 116, 48, 40, 121, 123, 106, 116, 43, 47, 101, 97, 103, 118, 45, 47, 98, 102, 106, 116, 44, 32, 120, 114, 112, 115}, "57da65", 3).equals(action)) {
            String strDecode = C0000.decode(new byte[]{119, 123, 96, 112, 118, 44, 62, 117, 123, 123, 99, 97, 96, 117, 127, 118, 96, 106, 102, 33, 41, 119, 122, 114, 117, 113}, "68499ba6450524", 0.0f);
            assertMainThread();
            synchronized (this.mIntents) {
                try {
                    ArrayList arrayList = this.mIntents;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        if (strDecode.equals(((Intent) obj).getAction())) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        intent.putExtra(C0000.decode(new byte[]{47, 36, 61, 106, 106, 103, 121, 98, 98, 57, 43, 112}, "dad593806fb46c"), i);
        synchronized (this.mIntents) {
            try {
                boolean zIsEmpty = this.mIntents.isEmpty();
                this.mIntents.add(intent);
                if (zIsEmpty) {
                    processCommand();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        zzu zzuVar = (zzu) this.mTaskExecutor.runningSyncCalls;
        int i = CommandHandler.$r8$clinit;
        Intent intent = new Intent(this.mContext, (Class<?>) SystemAlarmService.class);
        intent.setAction(C0000.decode(new byte[]{115, 37, 100, 113, 119, 122, 104, 32, 106, 115, 116, 98, 54, 124, 119, 45, 109, 37, 127, 117, 104, 120, 114, 49, 119, 114}, "2f08847e2677b58c", 0));
        intent.putExtra(C0000.decode(new byte[]{47, 32, 58, 59, 124, 32, 38, 116, 101, 59, 51, 112, 55, 38, 43, 33, 118, 48, 47, 117}, "decd2ec06da5", 2), z);
        CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
        zzuVar.execute(new SystemForegroundService.AnonymousClass2(0, intent, this));
    }

    public final void processCommand() {
        assertMainThread();
        PowerManager.WakeLock wakeLockNewWakeLock = WakeLocks.newWakeLock(this.mContext, C0000.decode(new byte[]{52, 19, 86, 7, 1, 74, 66, 33, 92, 90, 9, 0, 87, 0}, "da9dd91b37", 0.0f));
        try {
            wakeLockNewWakeLock.acquire();
            this.mWorkManager.mWorkTaskExecutor.executeOnTaskThread(new AnonymousClass1(this, 0));
        } finally {
            wakeLockNewWakeLock.release();
        }
    }
}
