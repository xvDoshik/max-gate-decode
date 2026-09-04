package kotlin;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase$Builder;
import androidx.room.migration.Migration;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.Configuration;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.OneTimeWorkRequest;
import androidx.work.SystemClock;
import androidx.work.Worker;
import androidx.work.impl.CleanupCallback;
import androidx.work.impl.Migration_1_2;
import androidx.work.impl.Processor;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkMigration9To10;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.constraints.trackers.NetworkStateTrackerKt;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SerialExecutorImpl;
import com.base.template.OnboardingConfig;
import com.base.template.workers.PingWorker;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.messaging.ServiceStarter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.internal.PlatformImplementations$ReflectThrowable;
import kotlin.internal.jdk7.JDK7PlatformImplementations$ReflectSdkVersion;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ConflatedBufferedChannel;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ExceptionsKt {
    public static BufferedChannel Channel$default(int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if (i == -2) {
            if (i2 != 1) {
                return new ConflatedBufferedChannel(1, i2);
            }
            Channel.Factory.getClass();
            return new BufferedChannel(Channel.Factory.CHANNEL_DEFAULT_CAPACITY);
        }
        if (i == -1) {
            if (i2 == 1) {
                return new ConflatedBufferedChannel(1, 2);
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{37, 122, 125, 36, 116, 34, 50, 35, 116, 18, 5, 84, 67, 3, 91, 10, 18, 31, 16, 81, 7, 91, 93, 13, 76, 67, 4, 3, 16, 71, 21, 80, 87, 66, 79, 10, 18, 14, 16, 92, 9, 91, 30, 6, 93, 5, 7, 19, 92, 70, 70, 90, 93, 32, 77, 5, 0, 3, 66, 125, 16, 80, 65, 4, 84, 12, 17}, "f53b8cff02", 5));
        }
        if (i == 0) {
            return i2 == 1 ? new BufferedChannel(0) : new ConflatedBufferedChannel(1, i2);
        }
        if (i != Integer.MAX_VALUE) {
            return i2 == 1 ? new BufferedChannel(i) : new ConflatedBufferedChannel(i, i2);
        }
        return new BufferedChannel(Integer.MAX_VALUE);
    }

    public static void addSuppressed(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th != th2) {
            Integer num = JDK7PlatformImplementations$ReflectSdkVersion.sdkVersion;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = PlatformImplementations$ReflectThrowable.addSuppressed;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static Object await(Task task) throws InterruptedException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(C0000.decode(new byte[]{123, 20, 23, 17, 20, 91, 86, 69, 22, 3, 1, 69, 87, 84, 85, 93, 83, 5, 68, 10, 90, 21, 77, 89, 83, 65, 9, 4, 93, 91, 25, 80, 70, 17, 8, 12, 87, 84, 77, 88, 89, 15, 68, 17, 92, 71, 92, 80, 82}, "6ade4591", false));
        }
        zzag.checkNotNull(task, C0000.decode(new byte[]{55, 0, 67, 10, 24, 94, 71, 21, 67, 22, 15, 93, 23, 65, 82, 4, 24, 93, 71, 10, 91}, "ca0a832f76a2", 4));
        if (task.isComplete()) {
            return zza(task);
        }
        ConnectionPool connectionPool = new ConnectionPool(18);
        Executor executor = TaskExecutors.zza;
        task.addOnSuccessListener(executor, connectionPool);
        zzw zzwVar = (zzw) task;
        zzr zzrVar = zzwVar.zzb;
        zzrVar.zza(new zzh(executor, (OnFailureListener) connectionPool));
        zzwVar.zzi();
        zzrVar.zza(new zzh(executor, (OnCanceledListener) connectionPool));
        zzwVar.zzi();
        ((CountDownLatch) connectionPool.delegate).await();
        return zza(task);
    }

    public static Object await(Task task, long j, TimeUnit timeUnit) throws TimeoutException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(C0000.decode(new byte[]{117, 17, 21, 77, 66, 13, 10, 65, 24, 6, 3, 25, 1, 2, 9, 89, 93, 0, 70, 86, 12, 67, 17, 93, 93, 68, 11, 88, 11, 13, 69, 84, 72, 20, 10, 80, 1, 2, 17, 92, 87, 10, 70, 77, 10, 17, 0, 84, 92}, "8df9bce5", 0.0f));
        }
        zzag.checkNotNull(task, C0000.decode(new byte[]{97, 80, 17, 13, 25, 14, 17, 74, 77, 23, 11, 95, 69, 24, 87, 84, 66, 8, 76, 15, 8}, "51bf9cd997e018", 3));
        zzag.checkNotNull(timeUnit, C0000.decode(new byte[]{48, 92, 14, 0, 101, 93, 12, 64, 25, 15, 17, 70, 23, 69, 94, 92, 17, 20, 91, 7, 68, 91, 22, 9, 92}, "d5ce03e49b", false));
        if (task.isComplete()) {
            return zza(task);
        }
        ConnectionPool connectionPool = new ConnectionPool(18);
        Executor executor = TaskExecutors.zza;
        task.addOnSuccessListener(executor, connectionPool);
        zzw zzwVar = (zzw) task;
        zzr zzrVar = zzwVar.zzb;
        zzrVar.zza(new zzh(executor, (OnFailureListener) connectionPool));
        zzwVar.zzi();
        zzrVar.zza(new zzh(executor, (OnCanceledListener) connectionPool));
        zzwVar.zzi();
        if (((CountDownLatch) connectionPool.delegate).await(j, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException(C0000.decode(new byte[]{98, 94, 8, 86, 85, 70, 92, 66, 23, 20, 68, 88, 95, 67, 12, 93, 86, 70, 85, 88, 17, 20, 103, 88, 69, 92}, "67e31f37c439", 4));
    }

    public static SetBuilder build(SetBuilder setBuilder) {
        MapBuilder mapBuilder = setBuilder.backing;
        mapBuilder.checkIsMutable$kotlin_stdlib();
        mapBuilder.isReadOnly = true;
        if (mapBuilder.size <= 0) {
            MapBuilder mapBuilder2 = MapBuilder.Empty;
        }
        return mapBuilder.size > 0 ? setBuilder : SetBuilder.Empty;
    }

    public static zzw call(Executor executor, Callable callable) {
        zzag.checkNotNull(executor, C0000.decode(new byte[]{119, 29, 1, 85, 71, 18, 95, 66, 23, 91, 71, 22, 16, 22, 92, 9, 68, 16, 85, 83, 18, 11, 17, 90, 94}, "2ed62f0076", 6));
        zzw zzwVar = new zzw();
        executor.execute(new Worker.AnonymousClass2(zzwVar, callable, 15, false));
        return zzwVar;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x02f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x02ea A[LOOP:1: B:64:0x02b1->B:77:0x02ea, LOOP_END] */
    public static final WorkManagerImpl createWorkManager(Context context, Configuration configuration) {
        RoomDatabase$Builder roomDatabase$Builder;
        boolean zContainsKey;
        int i;
        int i2;
        Dispatcher dispatcher = new Dispatcher((ExecutorService) configuration.taskExecutor);
        Context applicationContext = context.getApplicationContext();
        SerialExecutorImpl serialExecutorImpl = (SerialExecutorImpl) dispatcher.executorServiceOrNull;
        SystemClock systemClock = (SystemClock) configuration.clock;
        int i3 = 1;
        if (context.getResources().getBoolean(2130837507)) {
            roomDatabase$Builder = new RoomDatabase$Builder(applicationContext, null);
            roomDatabase$Builder.allowMainThreadQueries = true;
        } else {
            String strDecode = C0000.decode(new byte[]{82, 91, 6, 71, 88, 91, 82, 76, 26, 64, 92, 71, 9, 27, 64, 93, 68, 95, 80, 85}, "35b5726447", true);
            if (StringsKt__StringsJVMKt.isBlank(strDecode)) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{115, 7, 88, 86, 12, 70, 24, 81, 76, 12, 92, 2, 22, 89, 67, 86, 89, 71, 88, 7, 81, 21, 83, 24, 20, 91, 76, 91, 25, 11, 69, 10, 90, 24, 12, 64, 24, 86, 84, 21, 68, 31, 22, 86, 2, 95, 93, 29, 25, 44, 86, 70, 79, 87, 22, 18, 89, 65, 92, 69, 68, 20, 79, 81, 13, 85, 24, 71, 86, 69, 83, 20, 83, 89, 23, 87, 24, 82, 87, 69, 89, 8, 22, 85, 6, 95, 87, 65, 64, 69, 84, 7, 66, 89, 1, 83, 75, 86, 21, 69, 69, 21, 83, 24, 49, 93, 87, 94, 23, 12, 94, 43, 83, 85, 12, 64, 65, 119, 88, 17, 81, 4, 87, 75, 6, 112, 77, 90, 85, 1, 85, 20}, "0f68c2839e", 0.0f));
            }
            RoomDatabase$Builder roomDatabase$Builder2 = new RoomDatabase$Builder(applicationContext, strDecode);
            roomDatabase$Builder2.factory = new CctTransportBackend$$ExternalSyntheticLambda0(i3, applicationContext);
            roomDatabase$Builder = roomDatabase$Builder2;
        }
        roomDatabase$Builder.queryExecutor = serialExecutorImpl;
        CleanupCallback cleanupCallback = new CleanupCallback(systemClock);
        ArrayList arrayList = roomDatabase$Builder.callbacks;
        arrayList.add(cleanupCallback);
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE);
        roomDatabase$Builder.addMigrations(new WorkMigration9To10(applicationContext, 2, 3));
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$5);
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$6);
        roomDatabase$Builder.addMigrations(new WorkMigration9To10(applicationContext, 5, 6));
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$7);
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$8);
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$9);
        roomDatabase$Builder.addMigrations(new WorkMigration9To10(applicationContext));
        roomDatabase$Builder.addMigrations(new WorkMigration9To10(applicationContext, 10, 11));
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$1);
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$2);
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$3);
        roomDatabase$Builder.addMigrations(Migration_1_2.INSTANCE$4);
        roomDatabase$Builder.requireMigration = false;
        roomDatabase$Builder.allowDestructiveMigrationOnDowngrade = true;
        Executor executor = roomDatabase$Builder.queryExecutor;
        if (executor == null && roomDatabase$Builder.transactionExecutor == null) {
            ArchTaskExecutor$$ExternalSyntheticLambda0 archTaskExecutor$$ExternalSyntheticLambda0 = ArchTaskExecutor.sIOThreadExecutor;
            roomDatabase$Builder.transactionExecutor = archTaskExecutor$$ExternalSyntheticLambda0;
            roomDatabase$Builder.queryExecutor = archTaskExecutor$$ExternalSyntheticLambda0;
        } else if (executor != null && roomDatabase$Builder.transactionExecutor == null) {
            roomDatabase$Builder.transactionExecutor = executor;
        } else if (executor == null) {
            roomDatabase$Builder.queryExecutor = roomDatabase$Builder.transactionExecutor;
        }
        HashSet hashSet = roomDatabase$Builder.migrationStartAndEndVersions;
        LinkedHashSet linkedHashSet = roomDatabase$Builder.migrationsNotRequiredFrom;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (linkedHashSet.contains(Integer.valueOf(iIntValue))) {
                    throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{43, 90, 80, 14, 88, 67, 81, 16, 16, 82, 12, 87, 74, 65, 82, 85, 76, 6, 7, 67, 7, 80, 29, 65, 119, 16, 117, 10, 3, 69, 3, 64, 90, 14, 88, 16, 79, 2, 23, 23, 17, 65, 67, 17, 90, 89, 93, 7, 68, 67, 13, 20, 82, 5, 82, 125, 81, 4, 22, 86, 22, 93, 92, 15, 30, 125, 81, 4, 22, 86, 22, 93, 92, 15, 24, 30, 22, 67, 9, 94, 5, 70, 82, 21, 95, 95, 86, 16, 77, 23, 22, 92, 82, 21, 22, 88, 89, 16, 68, 86, 66, 71, 71, 0, 68, 68, 24, 12, 22, 23, 7, 90, 87, 65, 64, 85, 74, 16, 13, 88, 12, 20, 86, 16, 67, 81, 84, 67, 16, 88, 66, 85, 19, 18, 66, 81, 74, 23, 68, 65, 7, 70, 64, 8, 89, 94, 24, 16, 17, 71, 18, 88, 90, 4, 82, 16, 76, 12, 68, 81, 3, 88, 95, 3, 87, 83, 83, 55, 11, 115, 7, 71, 71, 19, 67, 83, 76, 10, 18, 82, 47, 93, 84, 19, 87, 68, 81, 12, 10, 113, 16, 91, 94, 73, 95, 94, 76, 77, 74, 25, 66, 71, 71, 0, 68, 68, 110, 6, 22, 68, 11, 91, 93, 18, 31, 30, 24, 48, 16, 86, 16, 64, 19, 23, 83, 66, 75, 10, 11, 89, 88, 20}, "b43a608cd7", true), iIntValue).toString());
                }
            }
        }
        SupportSQLiteOpenHelper.Factory profileInstaller$2 = roomDatabase$Builder.factory;
        if (profileInstaller$2 == null) {
            profileInstaller$2 = new ProfileInstaller$2();
        }
        SupportSQLiteOpenHelper.Factory factory = profileInstaller$2;
        long j = roomDatabase$Builder.autoCloseTimeout;
        String strDecode2 = C0000.decode(new byte[]{49, 0, 70, 76, 89, 19, 82, 0, 25, 21, 80, 84, 70, 81, 67, 18, 86, 74, 16, 15, 66, 8, 85, 77}, "ce790a7d9c1834", 0.0f);
        if (j > 0) {
            if (roomDatabase$Builder.name != null) {
                throw new IllegalArgumentException(strDecode2);
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{122, 80, 95, 10, 87, 76, 17, 2, 75, 84, 80, 16, 93, 24, 80, 20, 77, 94, 28, 7, 84, 87, 66, 8, 87, 86, 17, 0, 89, 76, 80, 3, 88, 66, 84, 68, 94, 87, 67, 65, 88, 95, 17, 13, 86, 21, 92, 4, 84, 94, 67, 29, 24, 92, 80, 21, 88, 83, 80, 23, 93, 22}, "911d881a"));
        }
        boolean z = roomDatabase$Builder.allowMainThreadQueries;
        int i4 = roomDatabase$Builder.journalMode;
        if (i4 == 0) {
            throw null;
        }
        Context context2 = roomDatabase$Builder.context;
        if (i4 == 1) {
            i4 = !((ActivityManager) context2.getSystemService(C0000.decode(new byte[]{84, 83, 65, 15, 70, 90, 65, 73}, "505f03", 3))).isLowRamDevice() ? 3 : 2;
        }
        Executor executor2 = roomDatabase$Builder.queryExecutor;
        if (executor2 == null) {
            throw new IllegalArgumentException(strDecode2);
        }
        Executor executor3 = roomDatabase$Builder.transactionExecutor;
        if (executor3 == null) {
            throw new IllegalArgumentException(strDecode2);
        }
        boolean z2 = roomDatabase$Builder.requireMigration;
        boolean z3 = roomDatabase$Builder.allowDestructiveMigrationOnDowngrade;
        String str = roomDatabase$Builder.name;
        int i5 = i4;
        ConnectionPool connectionPool = roomDatabase$Builder.migrationContainer;
        ArrayList arrayList2 = roomDatabase$Builder.typeConverters;
        ArrayList arrayList3 = roomDatabase$Builder.autoMigrationSpecs;
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context2, str, factory, connectionPool, arrayList, z, i5, executor2, executor3, z2, z3, linkedHashSet, arrayList2, arrayList3);
        String strDecode3 = C0000.decode(new byte[]{74, 82, 85, 11, 86, 92, 13, 82, 85, 9, 119, 83, 9, 84}, "d14e92", 0.0f);
        String name = WorkDatabase.class.getPackage().getName();
        String canonicalName = WorkDatabase.class.getCanonicalName();
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        String strConcat = canonicalName.replace('.', '_').concat(C0000.decode(new byte[]{61, 126, 89, 72, 94}, "b748204d33e70611", false));
        try {
            WorkDatabase workDatabase = (WorkDatabase) Class.forName(name.length() == 0 ? strConcat : name + '.' + strConcat, true, WorkDatabase.class.getClassLoader()).newInstance();
            InvalidationTracker invalidationTracker = workDatabase.invalidationTracker;
            LinkedHashMap linkedHashMap = workDatabase.autoMigrationSpecs;
            workDatabase.internalOpenHelper = workDatabase.createOpenHelper(databaseConfiguration);
            Set requiredAutoMigrationSpecs = workDatabase.getRequiredAutoMigrationSpecs();
            BitSet bitSet = new BitSet();
            Iterator it2 = requiredAutoMigrationSpecs.iterator();
            while (true) {
                int i6 = -1;
                if (!it2.hasNext()) {
                    int size = arrayList3.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i7 = size - 1;
                            if (!bitSet.get(size)) {
                                throw new IllegalArgumentException(C0000.decode(new byte[]{52, 10, 6, 27, 17, 93, 83, 68, 4, 0, 67, 2, 20, 76, 95, 16, 12, 13, 4, 17, 0, 76, 89, 95, 15, 68, 16, 19, 4, 91, 67, 16, 7, 11, 22, 13, 5, 22, 16, 113, 15, 10, 12, 23, 0, 76, 85, 16, 32, 17, 23, 12, 44, 81, 87, 66, 0, 16, 10, 12, 15, 107, 64, 85, 2, 68, 10, 14, 17, 84, 85, 93, 4, 10, 23, 2, 21, 81, 95, 94, 65, 19, 10, 23, 9, 24, 112, 96, 19, 11, 21, 10, 5, 93, 84, 113, 20, 16, 12, 46, 8, 95, 66, 81, 21, 13, 12, 13, 50, 72, 85, 83, 65, 5, 13, 13, 14, 76, 81, 68, 8, 11, 13, 67, 14, 74, 16, 66, 4, 9, 12, 21, 4, 24, 68, 88, 8, 23, 67, 16, 17, 93, 83, 16, 7, 22, 12, 14, 65, 76, 88, 85, 65, 6, 22, 10, 13, 92, 85, 66, 79}, "adcca800"));
                            }
                            if (i7 < 0) {
                                break;
                            }
                            size = i7;
                        }
                    }
                    for (Migration migration : workDatabase.getAutoMigrations()) {
                        int i8 = migration.startVersion;
                        int i9 = migration.endVersion;
                        LinkedHashMap linkedHashMap2 = (LinkedHashMap) connectionPool.delegate;
                        if (linkedHashMap2.containsKey(Integer.valueOf(i8))) {
                            Map map = (Map) linkedHashMap2.get(Integer.valueOf(i8));
                            if (map == null) {
                                map = EmptyMap.INSTANCE;
                            }
                            zContainsKey = map.containsKey(Integer.valueOf(i9));
                        } else {
                            zContainsKey = false;
                        }
                        if (!zContainsKey) {
                            connectionPool.addMigrations(migration);
                        }
                    }
                    SupportSQLiteOpenHelper supportSQLiteOpenHelper = workDatabase.internalOpenHelper;
                    if (supportSQLiteOpenHelper == null) {
                        supportSQLiteOpenHelper = null;
                    }
                    SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = workDatabase.internalOpenHelper;
                    if (supportSQLiteOpenHelper2 == null) {
                        supportSQLiteOpenHelper2 = r0;
                    }
                    boolean z4 = databaseConfiguration.journalMode == 3;
                    SupportSQLiteOpenHelper supportSQLiteOpenHelper3 = workDatabase.internalOpenHelper;
                    if (supportSQLiteOpenHelper3 == null) {
                        supportSQLiteOpenHelper3 = r0;
                    }
                    supportSQLiteOpenHelper3.setWriteAheadLoggingEnabled(z4);
                    workDatabase.mCallbacks = databaseConfiguration.callbacks;
                    workDatabase.internalQueryExecutor = databaseConfiguration.queryExecutor;
                    new ArrayDeque();
                    workDatabase.allowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
                    Map requiredTypeConverters = workDatabase.getRequiredTypeConverters();
                    BitSet bitSet2 = new BitSet();
                    for (Map.Entry entry : requiredTypeConverters.entrySet()) {
                        Class cls = (Class) entry.getKey();
                        for (Class cls2 : (List) entry.getValue()) {
                            int size2 = arrayList2.size() - 1;
                            if (size2 < 0) {
                                size2 = -1;
                                break;
                            }
                            while (true) {
                                int i10 = size2 - 1;
                                if (cls2.isAssignableFrom(arrayList2.get(size2).getClass())) {
                                    bitSet2.set(size2);
                                    break;
                                }
                                if (i10 < 0) {
                                    size2 = -1;
                                    break;
                                }
                                size2 = i10;
                            }
                            if (!(size2 >= 0)) {
                                throw new IllegalArgumentException((C0000.decode(new byte[]{39, 65, 65, 93, 73, 22, 15, 19, 86, 92, 24, 23, 31, 17, 86, 24, 91, 12, 8, 23, 86, 74, 76, 6, 20, 65, 27}, "fa388c", 0) + cls2 + C0000.decode(new byte[]{72, 68, 0, 91, 68, 17}, "adf4612d", 0.0f) + cls.getCanonicalName() + C0000.decode(new byte[]{67, 80, 70, 24, 85, 93, 65, 67, 13, 89, 1, 66, 88, 95, 65, 70, 11, 92, 21, 92, 89, 64, 83, 82, 5, 68, 3, 66, 82, 94, 15, 84, 10, 94, 64, 74, 89, 64, 91, 95, 10, 25}, "c9588420d7fb11a2", 0.0f)).toString());
                            }
                            workDatabase.typeConverters.put(cls2, arrayList2.get(size2));
                        }
                    }
                    int size3 = arrayList2.size() - 1;
                    if (size3 >= 0) {
                        while (true) {
                            int i11 = size3 - 1;
                            if (!bitSet2.get(size3)) {
                                throw new IllegalArgumentException(C0000.decode(new byte[]{102, 86, 7, 74, 65, 85, 85, 76, 85, 93, 22, 71, 65, 71, 86, 24, 1, 93, 95, 70, 83, 74, 68, 92, 68, 19}, "38b21068096387", 0.0f) + arrayList2.get(size3) + C0000.decode(new byte[]{22, 25, 112, 12, 95, 9, 77, 84, 18, 83, 17, 97, 73, 70, 3, 113, 87, 87, 71, 7, 67, 18, 92, 71, 70, 85, 93, 84, 67, 69, 70, 69, 81, 77, 89, 66, 113, 54, 75, 90, 16, 95, 85, 80, 84, 98, 31, 66, 93, 122, 94, 12, 71, 3, 75, 65, 3, 68, 17, 84, 94, 88, 9, 70, 89, 77, 88, 13, 95, 70, 86, 71, 70, 68, 84, 88, 95, 64, 3, 18, 76, 81, 88, 17, 17, 5, 86, 91, 16, 83, 67, 65, 85, 68, 70, 84, 74, 86, 92, 66, 69, 14, 92, 21, 4, 67, 88, 89, 84, 83, 20, 28}, "891b1f95f61506f2", 6));
                            }
                            if (i11 >= 0) {
                                size3 = i11;
                            }
                        }
                    }
                    Context applicationContext2 = context.getApplicationContext();
                    BatteryNotLowTracker batteryNotLowTracker = new BatteryNotLowTracker(applicationContext2.getApplicationContext(), dispatcher, 1);
                    BatteryNotLowTracker batteryNotLowTracker2 = new BatteryNotLowTracker(applicationContext2.getApplicationContext(), dispatcher, 0);
                    Context applicationContext3 = applicationContext2.getApplicationContext();
                    int i12 = NetworkStateTrackerKt.$r8$clinit;
                    NetworkStateTracker24 networkStateTracker24 = new NetworkStateTracker24(applicationContext3, dispatcher);
                    BatteryNotLowTracker batteryNotLowTracker3 = new BatteryNotLowTracker(applicationContext2.getApplicationContext(), dispatcher, 2);
                    ServiceStarter serviceStarter = new ServiceStarter();
                    serviceStarter.firebaseMessagingServiceClassName = batteryNotLowTracker;
                    serviceStarter.hasWakeLockPermission = batteryNotLowTracker2;
                    serviceStarter.hasAccessNetworkStatePermission = networkStateTracker24;
                    serviceStarter.messagingEvents = batteryNotLowTracker3;
                    Processor processor = new Processor(context.getApplicationContext(), configuration, dispatcher, workDatabase);
                    int i13 = Schedulers.$r8$clinit;
                    SystemJobScheduler systemJobScheduler = new SystemJobScheduler(context, workDatabase, configuration);
                    PackageManagerHelper.setComponentEnabled(context, SystemJobService.class, true);
                    SystemClock.get().getClass();
                    return new WorkManagerImpl(context.getApplicationContext(), configuration, dispatcher, workDatabase, CollectionsKt__CollectionsKt.listOf(systemJobScheduler, new GreedyScheduler(context, configuration, serviceStarter, processor, new WorkLauncherImpl(processor, dispatcher), dispatcher)), processor, serviceStarter);
                }
                Class cls3 = (Class) it2.next();
                int size4 = arrayList3.size() - 1;
                if (size4 >= 0) {
                    while (true) {
                        int i14 = size4 - 1;
                        i = i6;
                        if (cls3.isAssignableFrom(arrayList3.get(size4).getClass())) {
                            bitSet.set(size4);
                            i2 = size4;
                            break;
                        }
                        if (i14 >= 0) {
                            size4 = i14;
                            i6 = i;
                        }
                    }
                    if (i2 >= 0) {
                        throw new IllegalArgumentException((C0000.decode(new byte[]{120, 23, 74, 92, 23, 67, 12, 19, 92, 87, 69, 87, 67, 77, 94, 70, 84, 94, 95, 75, 7, 66, 12, 14, 87, 19, 22, 70, 83, 90, 17, 78}, "9789f6ea93e6691f", 1) + cls3.getCanonicalName() + C0000.decode(new byte[]{77, 16, 11, 17, 68, 15, 13, 67, 17, 11, 10, 5, 68, 89, 12, 66, 16, 10, 1, 16, 6, 3, 16, 3, 6, 81, 17, 7, 68, 1, 11, 94, 4, 11, 3, 23, 22, 81, 22, 11, 11, 12, 74}, "d0bbdb")).toString());
                    }
                    linkedHashMap.put(cls3, arrayList3.get(i2));
                } else {
                    i = -1;
                }
                i2 = i;
                if (i2 >= 0) {
                    throw new IllegalArgumentException((C0000.decode(new byte[]{120, 23, 74, 92, 23, 67, 12, 19, 92, 87, 69, 87, 67, 77, 94, 70, 84, 94, 95, 75, 7, 66, 12, 14, 87, 19, 22, 70, 83, 90, 17, 78}, "9789f6ea93e6691f", 1) + cls3.getCanonicalName() + C0000.decode(new byte[]{77, 16, 11, 17, 68, 15, 13, 67, 17, 11, 10, 5, 68, 89, 12, 66, 16, 10, 1, 16, 6, 3, 16, 3, 6, 81, 17, 7, 68, 1, 11, 94, 4, 11, 3, 23, 22, 81, 22, 11, 11, 12, 74}, "d0bbdb")).toString());
                }
                linkedHashMap.put(cls3, arrayList3.get(i2));
            }
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException(C0000.decode(new byte[]{117, 83, 10, 89, 91, 77, 24, 85, 11, 90, 92, 25, 11, 15, 70, 94, 1, 90, 81, 87, 76, 82, 22, 93, 87, 87, 66, 4, 89, 64, 68}, "62d74983b489bb") + WorkDatabase.class.getCanonicalName() + C0000.decode(new byte[]{31, 67}, "1c3db140", 0.0f) + strConcat + C0000.decode(new byte[]{16, 82, 86, 0, 70, 22, 94, 89, 77, 69, 80, 78, 89, 69, 77}, "069e56", 0.0f));
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException(C0000.decode(new byte[]{122, 87, 11, 93, 93, 22, 21, 80, 2, 87, 92, 69, 22, 19, 70, 10, 80, 17, 2, 91, 87, 69, 17, 65, 71, 1, 65, 94, 19, 20}, "96e32b51a4") + WorkDatabase.class + strDecode3);
        } catch (InstantiationException unused3) {
            throw new RuntimeException(C0000.decode(new byte[]{117, 83, 81, 93, 83, 7, 70, 71, 94, 69, 5, 69, 86, 83, 76, 84, 22, 2, 8, 19, 88, 11, 21, 67, 82, 92, 91, 84, 22, 12, 0, 19}, "32816cf31ef7", 3) + WorkDatabase.class + strDecode3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00de  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e8 A[LOOP:1: B:54:0x00dc->B:57:0x00e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x00ee A[EDGE_INSN: B:79:0x00ee->B:58:0x00ee BREAK  A[LOOP:1: B:54:0x00dc->B:57:0x00e8], SYNTHETIC] */
    public static final InetAddress decodeIpv6(String str, int i, int i2) {
        int i3;
        int i4;
        int hexDigit;
        byte[] bArr = new byte[16];
        int i5 = i;
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (i5 < i2) {
            if (i6 == 16) {
                return null;
            }
            int i9 = i5 + 2;
            if (i9 <= i2 && str.startsWith(C0000.decode(new byte[]{9, 94}, "3dd99e", false), i5)) {
                if (i7 != -1) {
                    return null;
                }
                i6 += 2;
                i7 = i6;
                if (i9 == i2) {
                    break;
                }
                i8 = i9;
                i3 = 0;
                i5 = i8;
                while (i5 < i2) {
                    hexDigit = Util.parseHexDigit(str.charAt(i5));
                    if (hexDigit != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + hexDigit;
                    i5++;
                }
                i4 = i5 - i8;
                return i4 == 0 ? null : null;
            }
            if (i6 != 0) {
                if (!str.startsWith(C0000.decode(new byte[]{8}, "2299d114663d5c50", 0.0f), i5)) {
                    if (!str.startsWith(C0000.decode(new byte[]{28}, "2d63b3768c", 4), i5)) {
                        return null;
                    }
                    int i10 = i6 - 2;
                    int i11 = i10;
                    while (i8 < i2) {
                        if (i11 == 16) {
                            return null;
                        }
                        if (i11 != i10) {
                            if (str.charAt(i8) != '.') {
                                return null;
                            }
                            i8++;
                        }
                        int i12 = 0;
                        int i13 = i8;
                        while (i13 < i2) {
                            char cCharAt = str.charAt(i13);
                            if (Intrinsics.compare(cCharAt, 48) < 0 || Intrinsics.compare(cCharAt, 57) > 0) {
                                break;
                            }
                            if ((i12 == 0 && i8 != i13) || (i12 = ((i12 * 10) + cCharAt) - 48) > 255) {
                                return null;
                            }
                            i13++;
                        }
                        if (i13 - i8 == 0) {
                            return null;
                        }
                        bArr[i11] = (byte) i12;
                        i11++;
                        i8 = i13;
                    }
                    if (i11 != i6 + 2) {
                        return null;
                    }
                    i6 += 2;
                    break;
                }
                i5++;
            }
            i8 = i5;
            i3 = 0;
            i5 = i8;
            while (i5 < i2) {
                hexDigit = Util.parseHexDigit(str.charAt(i5));
                if (hexDigit != -1) {
                    break;
                }
                i3 = (i3 << 4) + hexDigit;
                i5++;
            }
            i4 = i5 - i8;
            if (i4 == 0 && i4 <= 4) {
                int i14 = i6 + 1;
                bArr[i6] = (byte) (255 & (i3 >>> 8));
                i6 += 2;
                bArr[i14] = (byte) (i3 & 255);
            }
        }
        if (i6 != 16) {
            if (i7 == -1) {
                return null;
            }
            int i15 = i6 - i7;
            System.arraycopy(bArr, i7, bArr, 16 - i15, i15);
            Arrays.fill(bArr, i7, (16 - i6) + i7, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static zzw forResult(Object obj) {
        zzw zzwVar = new zzw();
        zzwVar.zzb(obj);
        return zzwVar;
    }

    public static boolean isRu() {
        String str = OnboardingConfig.LANG;
        String strDecode = C0000.decode(new byte[]{22, 69}, "d0e7d1");
        if (Intrinsics.areEqual(str, strDecode)) {
            return true;
        }
        if (Intrinsics.areEqual(str, C0000.decode(new byte[]{86, 12}, "3be27e893849", 0))) {
            return false;
        }
        return Intrinsics.areEqual(Locale.getDefault().getLanguage(), strDecode);
    }

    public static String pin(X509Certificate x509Certificate) {
        if (x509Certificate == null) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{32, 82, 75, 16, 80, 3, 92, 82, 85, 67, 6, 23, 73, 13, 87, 11, 92, 95, 83, 23, 17, 82, 72, 17, 80, 23, 80, 66, 20, 111, 86, 7, 0, 68, 90, 0, 71, 69, 93, 81, 10, 84, 88, 16, 92, 22}, "c79d9e5147", true));
        }
        return C0000.decode(new byte[]{66, 92, 80, 7, 3, 6, 78}, "141560ac7b", false) + ByteString.Companion.of$default(x509Certificate.getPublicKey().getEncoded()).digest$okio(C0000.decode(new byte[]{54, 42, 114, 78, 1, 7, 3}, "eb3c3256a93f", 0.0f)).base64();
    }

    public static void pingNow(Context context) {
        try {
            OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(PingWorker.class);
            ((LinkedHashSet) builder.tags).add(C0000.decode(new byte[]{70, 13, 90, 5, 61, 93, 86, 66}, "6d4bb39582a5", 7));
            new WorkContinuationImpl(WorkManagerImpl.getInstance$1(context), C0000.decode(new byte[]{19, 11, 13, 82, 111, 12, 12, 78, 60, 21, 12, 71, 91, 7, 17}, "cbc50bc9", 3), 1, Collections.singletonList((OneTimeWorkRequest) builder.build()), 0).enqueue();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static final List readForeignKeyFieldMappings(Cursor cursor) {
        ArrayList arrayList;
        int columnIndex = cursor.getColumnIndex(C0000.decode(new byte[]{89, 93}, "09ff51c6", 6));
        int columnIndex2 = cursor.getColumnIndex(C0000.decode(new byte[]{74, 82, 67}, "972bf2d583867f"));
        int columnIndex3 = cursor.getColumnIndex(C0000.decode(new byte[]{2, 66, 92, 93}, "d03035d41deea9"));
        int columnIndex4 = cursor.getColumnIndex(C0000.decode(new byte[]{16, 14}, "daf9f38e", 0.0f));
        ListBuilder listBuilder = new ListBuilder();
        while (cursor.moveToNext()) {
            listBuilder.add(new TableInfo.ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        if (listBuilder.backing != null) {
            throw new IllegalStateException();
        }
        listBuilder.checkIsMutable();
        listBuilder.isReadOnly = true;
        if (listBuilder.length <= 0) {
            listBuilder = ListBuilder.Empty;
        }
        if (listBuilder != null) {
            if (listBuilder.getSize() <= 1) {
                return CollectionsKt.toList(listBuilder);
            }
            Object[] array = listBuilder.toArray(new Comparable[0]);
            Comparable[] comparableArr = (Comparable[]) array;
            if (comparableArr.length > 1) {
                Arrays.sort(comparableArr);
            }
            return Arrays.asList(array);
        }
        if (listBuilder == null) {
            arrayList = new ArrayList();
            Iterator it = listBuilder.iterator();
            while (true) {
                ListBuilder.Itr itr = (ListBuilder.Itr) it;
                if (!itr.hasNext()) {
                    break;
                }
                arrayList.add(itr.next());
            }
        } else {
            arrayList = new ArrayList(listBuilder);
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    public static final TableInfo.Index readIndex(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str, boolean z) throws IOException {
        Cursor cursorQuery = frameworkSQLiteDatabase.query(C0000.decode(new byte[]{53, 99, 36, 38, 40, 116, 24, 10, 88, 85, 93, 78, 62, 28, 13, 88, 3, 94, 77, 1}, "e1eae58c6186add6", true) + str + C0000.decode(new byte[]{1, 16}, "a944a31d9c97ae", true));
        try {
            int columnIndex = cursorQuery.getColumnIndex(C0000.decode(new byte[]{17, 6, 20, 87, 90}, "bce9529e3bf12d", 0));
            int columnIndex2 = cursorQuery.getColumnIndex(C0000.decode(new byte[]{7, 92, 82}, "d56e9fc937cd"));
            int columnIndex3 = cursorQuery.getColumnIndex(C0000.decode(new byte[]{92, 4, 8, 86}, "2ee3ff616a51"));
            int columnIndex4 = cursorQuery.getColumnIndex(C0000.decode(new byte[]{5, 81, 66, 2}, "a41a63c7fe4db1f4"));
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorQuery.moveToNext()) {
                    if (cursorQuery.getInt(columnIndex2) >= 0) {
                        int i = cursorQuery.getInt(columnIndex);
                        String string = cursorQuery.getString(columnIndex3);
                        String strDecode = cursorQuery.getInt(columnIndex4) > 0 ? C0000.decode(new byte[]{118, 119, 55, 117}, "22d6a9", 5) : C0000.decode(new byte[]{32, 55, 34}, "adaebe", false);
                        treeMap.put(Integer.valueOf(i), string);
                        treeMap2.put(Integer.valueOf(i), strDecode);
                    }
                }
                TableInfo.Index index = new TableInfo.Index(str, z, CollectionsKt.toList(treeMap.values()), CollectionsKt.toList(treeMap2.values()));
                cursorQuery.close();
                return index;
            }
            cursorQuery.close();
            return null;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursorQuery, th);
                throw th2;
            }
        }
    }

    public static String readText$default(File file) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
        try {
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[8192];
            for (int i = inputStreamReader.read(cArr); i >= 0; i = inputStreamReader.read(cArr)) {
                stringWriter.write(cArr, 0, i);
            }
            String string = stringWriter.toString();
            inputStreamReader.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public static Set setOf(Object... objArr) {
        int length;
        if (objArr.length <= 0 || (length = objArr.length) == 0) {
            return EmptySet.INSTANCE;
        }
        if (length == 1) {
            return Collections.singleton(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(CloseableKt.mapCapacity(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static final String toCanonicalHost(String str) {
        int i = -1;
        int i2 = 0;
        if (!StringsKt.contains$default(str, C0000.decode(new byte[]{8}, "2f167826", 0.0f))) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt = lowerCase.charAt(i3);
                    if (Intrinsics.compare(cCharAt, 31) <= 0 || Intrinsics.compare(cCharAt, 127) >= 0 || StringsKt.indexOf$default(C0000.decode(new byte[]{19, 22, 28, 25, 89, 91, 36, 104, 100, 108}, "3596cdd381", 0.0f), cCharAt, 0, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressDecodeIpv6 = (str.startsWith(C0000.decode(new byte[]{104}, "3d6d161d4664")) && str.endsWith(C0000.decode(new byte[]{59}, "f8d9d5ac2980ee09", 0.0f))) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
        if (inetAddressDecodeIpv6 == null) {
            return null;
        }
        byte[] address = inetAddressDecodeIpv6.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressDecodeIpv6.getHostAddress();
            }
            throw new AssertionError(C0000.decode(new byte[]{44, 93, 70, 85, 84, 90, 87, 25, 44, 99, 70, 2, 24, 82, 87, 93, 23, 86, 67, 71, 2, 19, 20}, "e3048339", true) + str + '\'');
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < address.length) {
            int i6 = i4;
            while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        Buffer buffer = new Buffer();
        while (i2 < address.length) {
            if (i2 == i) {
                buffer.m23writeByte(58);
                i2 += i5;
                if (i2 == 16) {
                    buffer.m23writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.m23writeByte(58);
                }
                byte b = address[i2];
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                buffer.m24writeHexadecimalUnsignedLong(((b & 255) << 8) | (address[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static Object zza(Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (((zzw) task).zzd) {
            throw new CancellationException(C0000.decode(new byte[]{109, 5, 66, 82, 17, 88, 71, 67, 7, 89, 17, 84, 88, 86, 27, 16, 90, 5, 95, 90, 84, 93, 81, 7}, "9d19114cf5c192b0", 0.0f));
        }
        throw new ExecutionException(task.getException());
    }

    public abstract boolean casListeners(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture.Listener listener, AbstractResolvableFuture.Listener listener2);

    public abstract boolean casValue(AbstractResolvableFuture abstractResolvableFuture, Object obj, Object obj2);

    public abstract boolean casWaiters(AbstractResolvableFuture abstractResolvableFuture, AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2);

    public abstract void putNext(AbstractResolvableFuture.Waiter waiter, AbstractResolvableFuture.Waiter waiter2);

    public abstract void putThread(AbstractResolvableFuture.Waiter waiter, Thread thread);
}
