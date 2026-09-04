package kotlin;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Configuration;
import androidx.work.JobListenableFuture;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.constraints.controllers.ConstraintController$track$1$1;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.firebase.components.Component;
import com.google.firebase.components.CycleDetector$ComponentNode;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.DependencyCycleException;
import com.google.firebase.components.Qualified;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.NotCompleted;
import kotlinx.coroutines.channels.ProduceKt$awaitClose$1;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ResultKt {
    public static Context zza;
    public static Boolean zzb;

    public static final void access$log(Task task, TaskQueue taskQueue, String str) {
        TaskRunner.Companion.getClass();
        Logger logger = TaskRunner.logger;
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.name);
        sb.append(' ');
        sb.append(String.format(C0000.decode(new byte[]{70, 21, 81, 6, 67}, "c8c4096ae6", 3), Arrays.copyOf(new Object[]{str}, 1)));
        sb.append(C0000.decode(new byte[]{12, 70}, "6fb9d7106eafa5ff", 0.0f));
        sb.append(task.name);
        logger.fine(sb.toString());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object awaitClose(ProducerScope producerScope, ConstraintController$track$1$1 constraintController$track$1$1, ContinuationImpl continuationImpl) {
        ProduceKt$awaitClose$1 produceKt$awaitClose$1;
        if (continuationImpl instanceof ProduceKt$awaitClose$1) {
            produceKt$awaitClose$1 = (ProduceKt$awaitClose$1) continuationImpl;
            int i = produceKt$awaitClose$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                produceKt$awaitClose$1.label = i - Integer.MIN_VALUE;
            } else {
                produceKt$awaitClose$1 = new ProduceKt$awaitClose$1(continuationImpl);
            }
        } else {
            produceKt$awaitClose$1 = new ProduceKt$awaitClose$1(continuationImpl);
        }
        Object obj = produceKt$awaitClose$1.result;
        int i2 = produceKt$awaitClose$1.label;
        try {
            if (i2 == 0) {
                throwOnFailure(obj);
                if (produceKt$awaitClose$1._context.get(Job.Key.$$INSTANCE) != producerScope) {
                    throw new IllegalStateException(C0000.decode(new byte[]{89, 19, 5, 80, 16, 119, 84, 11, 23, 92, 76, 29, 24, 7, 5, 87, 68, 91, 86, 8, 29, 25, 6, 81, 24, 13, 10, 79, 11, 95, 93, 0, 68, 95, 22, 91, 85, 68, 16, 81, 1, 20, 72, 22, 11, 93, 17, 87, 93, 22, 68, 90, 11, 90, 76, 1, 28, 77}, "8dd9d4", 0.0f));
                }
                produceKt$awaitClose$1.L$1 = constraintController$track$1$1;
                produceKt$awaitClose$1.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, Headers.Companion.intercepted(produceKt$awaitClose$1));
                DisposableHandle disposableHandleInstallParentHandle = cancellableContinuationImpl.installParentHandle();
                if (disposableHandleInstallParentHandle != null && !(CancellableContinuationImpl._state$FU.get(cancellableContinuationImpl) instanceof NotCompleted)) {
                    disposableHandleInstallParentHandle.dispose();
                    CancellableContinuationImpl._parentHandle$FU.set(cancellableContinuationImpl, NonDisposableHandle.INSTANCE);
                }
                ((ProducerCoroutine) producerScope).invokeOnClose(new JobListenableFuture.AnonymousClass1(5, cancellableContinuationImpl));
                Object result = cancellableContinuationImpl.getResult();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (result == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException(C0000.decode(new byte[]{2, 2, 93, 85, 21, 64, 86, 20, 21, 66, 4, 67, 71, 8, 81, 30, 65, 1, 84, 95, 90, 70, 92, 20, 21, 89, 15, 70, 93, 14, 81, 30, 65, 20, 88, 77, 93, 20, 90, 91, 64, 95, 20, 68, 91, 11, 81}, "ac19549420a02e49", 3));
                }
                constraintController$track$1$1 = produceKt$awaitClose$1.L$1;
                throwOnFailure(obj);
            }
            constraintController$track$1$1.invoke();
            return Unit.INSTANCE;
        } catch (Throwable th) {
            constraintController$track$1$1.invoke();
            throw th;
        }
    }

    public static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static void detect(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            Component component = (Component) obj;
            CycleDetector$ComponentNode cycleDetector$ComponentNode = new CycleDetector$ComponentNode(component);
            for (final Qualified qualified : component.providedInterfaces) {
                boolean z = component.type == 0;
                final boolean z2 = !z;
                Object obj2 = new Object(qualified, z2) { // from class: com.google.firebase.components.CycleDetector$Dep
                    public final Qualified anInterface;
                    public final boolean set;

                    {
                        this.anInterface = qualified;
                        this.set = z2;
                    }

                    public final boolean equals(Object obj3) {
                        if (obj3 instanceof CycleDetector$Dep) {
                            CycleDetector$Dep cycleDetector$Dep = (CycleDetector$Dep) obj3;
                            if (cycleDetector$Dep.anInterface.equals(this.anInterface) && cycleDetector$Dep.set == this.set) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public final int hashCode() {
                        return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
                    }
                };
                if (!map.containsKey(obj2)) {
                    map.put(obj2, new HashSet());
                }
                Set set = (Set) map.get(obj2);
                if (!set.isEmpty() && z) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{123, 20, 92, 71, 10, 20, 88, 80, 25, 1, 14, 90, 70, 14, 94, 86, 13, 16, 71, 21, 73, 16, 14, 65, 95, 5, 85, 19}, "6a03cd459ba7") + qualified + C0000.decode(new byte[]{23}, "90047f"));
                }
                set.add(cycleDetector$ComponentNode);
            }
        }
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            for (CycleDetector$ComponentNode cycleDetector$ComponentNode2 : (Set) it.next()) {
                for (Dependency dependency : cycleDetector$ComponentNode2.component.dependencies) {
                    if (dependency.injection == 0) {
                        final Qualified qualified2 = dependency.anInterface;
                        final boolean z3 = dependency.type == 2;
                        Set<CycleDetector$ComponentNode> set2 = (Set) map.get(new Object(qualified2, z3) { // from class: com.google.firebase.components.CycleDetector$Dep
                            public final Qualified anInterface;
                            public final boolean set;

                            {
                                this.anInterface = qualified2;
                                this.set = z3;
                            }

                            public final boolean equals(Object obj3) {
                                if (obj3 instanceof CycleDetector$Dep) {
                                    CycleDetector$Dep cycleDetector$Dep = (CycleDetector$Dep) obj3;
                                    if (cycleDetector$Dep.anInterface.equals(this.anInterface) && cycleDetector$Dep.set == this.set) {
                                        return true;
                                    }
                                }
                                return false;
                            }

                            public final int hashCode() {
                                return ((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.set).hashCode();
                            }
                        });
                        if (set2 != null) {
                            for (CycleDetector$ComponentNode cycleDetector$ComponentNode3 : set2) {
                                cycleDetector$ComponentNode2.dependencies.add(cycleDetector$ComponentNode3);
                                cycleDetector$ComponentNode3.dependents.add(cycleDetector$ComponentNode2);
                            }
                        }
                    }
                }
            }
        }
        HashSet<CycleDetector$ComponentNode> hashSet = new HashSet();
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            hashSet.addAll((Set) it2.next());
        }
        HashSet hashSet2 = new HashSet();
        for (CycleDetector$ComponentNode cycleDetector$ComponentNode4 : hashSet) {
            if (cycleDetector$ComponentNode4.dependents.isEmpty()) {
                hashSet2.add(cycleDetector$ComponentNode4);
            }
        }
        while (!hashSet2.isEmpty()) {
            CycleDetector$ComponentNode cycleDetector$ComponentNode5 = (CycleDetector$ComponentNode) hashSet2.iterator().next();
            hashSet2.remove(cycleDetector$ComponentNode5);
            i++;
            for (CycleDetector$ComponentNode cycleDetector$ComponentNode6 : cycleDetector$ComponentNode5.dependencies) {
                cycleDetector$ComponentNode6.dependents.remove(cycleDetector$ComponentNode5);
                if (cycleDetector$ComponentNode6.dependents.isEmpty()) {
                    hashSet2.add(cycleDetector$ComponentNode6);
                }
            }
        }
        if (i == arrayList.size()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (CycleDetector$ComponentNode cycleDetector$ComponentNode7 : hashSet) {
            if (!cycleDetector$ComponentNode7.dependents.isEmpty() && !cycleDetector$ComponentNode7.dependencies.isEmpty()) {
                arrayList2.add(cycleDetector$ComponentNode7.component);
            }
        }
        throw new DependencyCycleException(C0000.decode(new byte[]{124, 82, 68, 80, 95, 82, 1, 8, 1, 72, 16, 80, 72, 84, 9, 84, 24, 83, 81, 65, 84, 85, 16, 3, 6, 11, 16}, "874516dfb10317e1", 0.0f) + Arrays.toString(arrayList2.toArray()));
    }

    public static final String formatDuration(long j) {
        String str;
        String strDecode = C0000.decode(new byte[]{16, 67, 68}, "00d98f7d5f144ae4");
        if (j <= -999500000) {
            str = ((j - ((long) 500000000)) / ((long) 1000000000)) + strDecode;
        } else {
            String strDecode2 = C0000.decode(new byte[]{19, 84, 70}, "3952904670d2");
            if (j <= -999500) {
                str = ((j - ((long) 500000)) / ((long) 1000000)) + strDecode2;
            } else {
                String strDecode3 = C0000.decode(new byte[]{67, -92, -115, 65}, "cf82ec");
                if (j <= 0) {
                    str = ((j - ((long) 500)) / ((long) 1000)) + strDecode3;
                } else if (j < 999500) {
                    str = ((j + ((long) 500)) / ((long) 1000)) + strDecode3;
                } else if (j < 999500000) {
                    str = ((j + ((long) 500000)) / ((long) 1000000)) + strDecode2;
                } else {
                    str = ((j + ((long) 500000000)) / ((long) 1000000000)) + strDecode;
                }
            }
        }
        return String.format(C0000.decode(new byte[]{18, 15, 70}, "795d48de"), Arrays.copyOf(new Object[]{str}, 1));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final Class getJavaObjectType(KClass kClass) {
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (jClass.isPrimitive()) {
            String name = jClass.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals(C0000.decode(new byte[]{82, 12, 70, 84, 13, 92}, "6c36a910b1ed2e"))) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals(C0000.decode(new byte[]{92, 11, 67}, "5e73f77406ac9c", 0))) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals(C0000.decode(new byte[]{83, 28, 71, 84}, "1e31af578baf", 6))) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals(C0000.decode(new byte[]{7, 81, 0, 22}, "d9ad48f9c56a3227", 2))) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals(C0000.decode(new byte[]{15, 91, 89, 81}, "c476d345", 0.0f))) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals(C0000.decode(new byte[]{70, 93, 15, 86}, "02f2754b45", 0.0f))) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals(C0000.decode(new byte[]{4, 9, 92, 95, 3, 82, 12}, "ff33f3b3", 0))) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals(C0000.decode(new byte[]{2, 15, 92, 82, 71}, "dc3334", 7))) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals(C0000.decode(new byte[]{17, 89, 91, 19, 64}, "b14a47bea5bbbe", 0.0f))) {
                        return Short.class;
                    }
                    break;
            }
        }
        return jClass;
    }

    public static void incrementAttempts(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(C0000.decode(new byte[]{67, 2, 103, 20, 89, 90, 75, 95}, "7e8d1387365dbe", 0.0f), 0);
        String strDecode = C0000.decode(new byte[]{82, 18, 65, 86, 15, 21, 17, 64}, "3f53bee3", 6);
        sharedPreferences.edit().putInt(strDecode, sharedPreferences.getInt(strDecode, 0) + 1).apply();
    }

    public static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{42, 10, 67, 89, 92, 10, 7, 68, 92, 86, 64, 22, 23, 68, 71, 93, 83, 6, 10, 18, 80, 92}, "cd580c", 7));
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0082  */
    public static long parseExpires(String str, int i) {
        int iDateCharacterOffset = dateCharacterOffset(str, 0, i, false);
        Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int iIndexOf$default = -1;
        int i5 = -1;
        int i6 = -1;
        while (iDateCharacterOffset < i) {
            int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i, true);
            matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
            if (i3 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                i3 = Integer.parseInt(matcher.group(1));
                i5 = Integer.parseInt(matcher.group(2));
                i6 = Integer.parseInt(matcher.group(3));
            } else if (i4 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            } else if (iIndexOf$default == -1) {
                Pattern pattern = Cookie.MONTH_PATTERN;
                if (matcher.usePattern(pattern).matches()) {
                    iIndexOf$default = StringsKt.indexOf$default(pattern.pattern(), matcher.group(1).toLowerCase(Locale.US), 0, 6) / 4;
                } else if (i2 != -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    i2 = Integer.parseInt(matcher.group(1));
                }
            } else if (i2 != -1) {
            }
            iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i, false);
        }
        if (70 <= i2 && i2 < 100) {
            i2 += 1900;
        }
        if (i2 >= 0 && i2 < 70) {
            i2 += 2000;
        }
        String strDecode = C0000.decode(new byte[]{126, 85, 95, 13, 87, 93, 70, 68, 83, 19, 65, 93, 16, 85, 12, 86, 86, 64, 24}, "846a29f66b44b0a3");
        if (i2 < 1601) {
            throw new IllegalArgumentException(strDecode);
        }
        if (iIndexOf$default == -1) {
            throw new IllegalArgumentException(strDecode);
        }
        if (1 > i4 || i4 >= 32) {
            throw new IllegalArgumentException(strDecode);
        }
        if (i3 < 0 || i3 >= 24) {
            throw new IllegalArgumentException(strDecode);
        }
        if (i5 < 0 || i5 >= 60) {
            throw new IllegalArgumentException(strDecode);
        }
        if (i6 < 0 || i6 >= 60) {
            throw new IllegalArgumentException(strDecode);
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i2);
        gregorianCalendar.set(2, iIndexOf$default - 1);
        gregorianCalendar.set(5, i4);
        gregorianCalendar.set(11, i3);
        gregorianCalendar.set(12, i5);
        gregorianCalendar.set(13, i6);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public static final void resetRange(Object[] objArr, int i, int i2) {
        while (i < i2) {
            objArr[i] = null;
            i++;
        }
    }

    public static final void throwOnFailure(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }

    public static final void updateWorkImpl(Processor processor, final WorkDatabase workDatabase, Configuration configuration, final List list, final WorkSpec workSpec, final Set set) {
        final String str = workSpec.id;
        final WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(str);
        if (workSpec2 == null) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{54, 13, 65, 93, 82, 70, 66, 64, 12, 21, 80, 16}, "ab3674b7ea804c"), str, C0000.decode(new byte[]{69, 87, 90, 6, 64, 87, 66, 71, 21, 6, 75, 80, 22, 71}, "e35c39")));
        }
        if (NetworkType$EnumUnboxingLocalUtility._isFinished(workSpec2.state)) {
            return;
        }
        if (workSpec2.isPeriodic() ^ workSpec.isPeriodic()) {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{119, 86, 95, 17, 16, 70, 22, 19, 80, 86, 69, 83, 68}, "4716dfcc"));
            boolean zIsPeriodic = workSpec2.isPeriodic();
            String strDecode = C0000.decode(new byte[]{118, 90, 80, 100, 88, 92, 82}, "94501174");
            String strDecode2 = C0000.decode(new byte[]{105, 6, 71, 15, 95, 0, 8, 2}, "9c5f0daa3c");
            sb.append(zIsPeriodic ? strDecode2 : strDecode);
            sb.append(C0000.decode(new byte[]{16, 101, 87, 22, 10, 7, 68, 20, 67, 90, 16}, "028dab6475"));
            if (workSpec.isPeriodic()) {
                strDecode = strDecode2;
            }
            throw new UnsupportedOperationException(FileSectionType$EnumUnboxingLocalUtility.m(sb, strDecode, C0000.decode(new byte[]{21, 97, 13, 22, 94, 0, 64, 72, 70, 100, 68, 6, 84, 66, 7, 68, 90, 21, 87, 20, 7, 69, 93, 13, 91, 22, 15, 17, 70, 17, 18, 22, 20, 84, 71, 7, 71, 64, 7, 68, 66, 10, 64, 13, 3, 67, 19, 17, 21, 66, 27, 20, 80, 75}, "56bd5e2ff14b")));
        }
        final boolean zIsEnqueued = processor.isEnqueued(str);
        if (!zIsEnqueued) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Scheduler) it.next()).cancel(str);
            }
        }
        Runnable runnable = new Runnable(workSpec2, workSpec, list, str, set, zIsEnqueued) { // from class: androidx.work.impl.WorkerUpdater$$ExternalSyntheticLambda1
            public final /* synthetic */ WorkSpec f$1;
            public final /* synthetic */ WorkSpec f$2;
            public final /* synthetic */ String f$4;
            public final /* synthetic */ Set f$5;
            public final /* synthetic */ boolean f$6;

            {
                this.f$4 = str;
                this.f$5 = set;
                this.f$6 = zIsEnqueued;
            }

            @Override // java.lang.Runnable
            public final void run() {
                WorkDatabase workDatabase2 = this.f$0;
                WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase2.workSpecDao();
                WorkTagDao_Impl workTagDao_ImplWorkTagDao = workDatabase2.workTagDao();
                WorkSpec workSpec3 = this.f$1;
                int i = workSpec3.state;
                int i2 = workSpec3.runAttemptCount;
                long j = workSpec3.lastEnqueueTime;
                int i3 = workSpec3.generation + 1;
                int i4 = workSpec3.periodCount;
                long j2 = workSpec3.nextScheduleTimeOverride;
                int i5 = workSpec3.nextScheduleTimeOverrideGeneration;
                WorkSpec workSpec4 = this.f$2;
                WorkSpec workSpecCopy$default = WorkSpec.copy$default(workSpec4, null, i, null, null, i2, j, i4, i3, j2, i5, 4447229);
                if (workSpec4.nextScheduleTimeOverrideGeneration == 1) {
                    workSpecCopy$default.nextScheduleTimeOverride = workSpec4.nextScheduleTimeOverride;
                    workSpecCopy$default.nextScheduleTimeOverrideGeneration++;
                }
                WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
                workDatabase_Impl.assertNotSuspendingTransaction();
                workDatabase_Impl.beginTransaction();
                try {
                    WorkTagDao_Impl.AnonymousClass2 anonymousClass2 = workSpecDao_ImplWorkSpecDao.__updateAdapterOfWorkSpec;
                    FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = anonymousClass2.acquire();
                    try {
                        anonymousClass2.bind(frameworkSQLiteStatementAcquire, workSpecCopy$default);
                        frameworkSQLiteStatementAcquire.executeUpdateDelete();
                        anonymousClass2.release(frameworkSQLiteStatementAcquire);
                        workDatabase_Impl.setTransactionSuccessful();
                        workDatabase_Impl.internalEndTransaction();
                        WorkDatabase_Impl workDatabase_Impl2 = (WorkDatabase_Impl) workTagDao_ImplWorkTagDao.__db;
                        workDatabase_Impl2.assertNotSuspendingTransaction();
                        WorkTagDao_Impl.AnonymousClass2 anonymousClass3 = (WorkTagDao_Impl.AnonymousClass2) workTagDao_ImplWorkTagDao.__preparedStmtOfDeleteByWorkSpecId;
                        FrameworkSQLiteStatement frameworkSQLiteStatementAcquire2 = anonymousClass3.acquire();
                        String str2 = this.f$4;
                        frameworkSQLiteStatementAcquire2.bindString(str2, 1);
                        workDatabase_Impl2.beginTransaction();
                        try {
                            frameworkSQLiteStatementAcquire2.executeUpdateDelete();
                            workDatabase_Impl2.setTransactionSuccessful();
                            workDatabase_Impl2.internalEndTransaction();
                            anonymousClass3.release(frameworkSQLiteStatementAcquire2);
                            workTagDao_ImplWorkTagDao.insertTags(str2, this.f$5);
                            if (this.f$6) {
                                return;
                            }
                            workSpecDao_ImplWorkSpecDao.markWorkSpecScheduled(-1L, str2);
                            workDatabase2.workProgressDao().delete(str2);
                        } catch (Throwable th) {
                            workDatabase_Impl2.internalEndTransaction();
                            anonymousClass3.release(frameworkSQLiteStatementAcquire2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        anonymousClass2.release(frameworkSQLiteStatementAcquire);
                        throw th2;
                    }
                } catch (Throwable th3) {
                    workDatabase_Impl.internalEndTransaction();
                    throw th3;
                }
            }
        };
        workDatabase.beginTransaction();
        try {
            runnable.run();
            workDatabase.setTransactionSuccessful();
            workDatabase.internalEndTransaction();
            if (zIsEnqueued) {
                return;
            }
            Schedulers.schedule(configuration, workDatabase, list);
        } catch (Throwable th) {
            workDatabase.internalEndTransaction();
            throw th;
        }
    }
}
