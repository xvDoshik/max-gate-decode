package androidx.work;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import java.lang.reflect.Array;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.SynchronizedLazyImpl;
import kotlin.io.CloseableKt;
import okhttp3.Handshake;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class WorkRequest {
    public final UUID id;
    public final Set tags;
    public final WorkSpec workSpec;

    public WorkRequest(UUID uuid, WorkSpec workSpec, LinkedHashSet linkedHashSet) {
        this.id = uuid;
        this.workSpec = workSpec;
        this.tags = linkedHashSet;
    }

    public abstract class Builder {
        public Object id;
        public Object tags;
        public Object workSpec;

        public Builder(WorkDatabase workDatabase) {
            this.id = workDatabase;
            this.workSpec = new AtomicBoolean(false);
            this.tags = new SynchronizedLazyImpl(new Handshake.AnonymousClass2(2, this));
        }

        public static boolean equalsSetHelper(Set set, Object obj) {
            if (set == obj) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        public FrameworkSQLiteStatement acquire() {
            WorkDatabase workDatabase = (WorkDatabase) this.id;
            workDatabase.assertNotMainThread();
            if (((AtomicBoolean) this.workSpec).compareAndSet(false, true)) {
                return (FrameworkSQLiteStatement) ((SynchronizedLazyImpl) this.tags).getValue();
            }
            String strCreateQuery = createQuery();
            workDatabase.assertNotMainThread();
            workDatabase.assertNotSuspendingTransaction();
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = workDatabase.internalOpenHelper;
            if (supportSQLiteOpenHelper == null) {
                supportSQLiteOpenHelper = null;
            }
            return supportSQLiteOpenHelper.getWritableDatabase().compileStatement(strCreateQuery);
        }

        public WorkRequest build() {
            WorkRequest workRequestBuildInternal$work_runtime_release = buildInternal$work_runtime_release();
            Constraints constraints = ((WorkSpec) this.workSpec).constraints;
            boolean z = !constraints.contentUriTriggers.isEmpty() || constraints.requiresBatteryNotLow || constraints.requiresCharging || constraints.requiresDeviceIdle;
            WorkSpec workSpec = (WorkSpec) this.workSpec;
            if (workSpec.expedited) {
                if (z) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{38, 74, 69, 80, 84, 81, 67, 0, 7, 18, 95, 90, 82, 75, 23, 10, 13, 94, 76, 21, 67, 77, 71, 21, 12, 64, 65, 21, 94, 93, 67, 18, 12, 64, 94, 21, 81, 86, 83, 69, 16, 70, 90, 71, 81, 95, 82, 69, 0, 93, 91, 70, 68, 74, 86, 12, 13, 70, 70}, "c255087e", false));
                }
                if (workSpec.initialDelay > 0) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{33, 65, 71, 85, 83, 88, 69, 4, 0, 25, 93, 95, 85, 66, 17, 2, 5, 87, 89, 95, 67, 17, 83, 4, 68, 93, 82, 92, 86, 72, 84, 5}, "d970711a", 4));
                }
            }
            UUID uuidRandomUUID = UUID.randomUUID();
            this.id = uuidRandomUUID;
            String string = uuidRandomUUID.toString();
            WorkSpec workSpec2 = (WorkSpec) this.workSpec;
            this.workSpec = new WorkSpec(string, workSpec2.state, workSpec2.workerClassName, workSpec2.inputMergerClassName, new Data(workSpec2.input), new Data(workSpec2.output), workSpec2.initialDelay, workSpec2.intervalDuration, workSpec2.flexDuration, new Constraints(workSpec2.constraints), workSpec2.runAttemptCount, workSpec2.backoffPolicy, workSpec2.backoffDelayDuration, workSpec2.lastEnqueueTime, workSpec2.minimumRetentionDuration, workSpec2.scheduleRequestedAt, workSpec2.expedited, workSpec2.outOfQuotaPolicy, workSpec2.periodCount, workSpec2.nextScheduleTimeOverride, workSpec2.nextScheduleTimeOverrideGeneration, workSpec2.stopReason, 524288);
            return workRequestBuildInternal$work_runtime_release;
        }

        public abstract WorkRequest buildInternal$work_runtime_release();

        public abstract void colClear();

        public abstract Object colGetEntry(int i, int i2);

        public abstract Map colGetMap();

        public abstract int colGetSize();

        public abstract int colIndexOfKey(Object obj);

        public abstract int colIndexOfValue(Object obj);

        public abstract void colPut(Object obj, Object obj2);

        public abstract void colRemoveAt(int i);

        public abstract Object colSetValue(int i, Object obj);

        public abstract String createQuery();

        public void release(FrameworkSQLiteStatement frameworkSQLiteStatement) {
            if (frameworkSQLiteStatement == ((FrameworkSQLiteStatement) ((SynchronizedLazyImpl) this.tags).getValue())) {
                ((AtomicBoolean) this.workSpec).set(false);
            }
        }

        public Object[] toArrayHelper(Object[] objArr, int i) {
            int iColGetSize = colGetSize();
            if (objArr.length < iColGetSize) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iColGetSize);
            }
            for (int i2 = 0; i2 < iColGetSize; i2++) {
                objArr[i2] = colGetEntry(i2, i);
            }
            if (objArr.length > iColGetSize) {
                objArr[iColGetSize] = null;
            }
            return objArr;
        }

        public Builder(Class cls) {
            this.id = UUID.randomUUID();
            this.workSpec = new WorkSpec(((UUID) this.id).toString(), 0, cls.getName(), (String) null, (Data) null, (Data) null, 0L, 0L, 0L, (Constraints) null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 0L, 0, 0, 8388602);
            String[] strArr = {cls.getName()};
            LinkedHashSet linkedHashSet = new LinkedHashSet(CloseableKt.mapCapacity(1));
            linkedHashSet.add(strArr[0]);
            this.tags = linkedHashSet;
        }
    }
}
