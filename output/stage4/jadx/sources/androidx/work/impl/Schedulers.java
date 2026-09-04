package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.SystemClock;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Schedulers {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{96, 1, 12, 3, 5, 67, 84, 4, 17, 23}, "3bdfa68acd994c89", 7));
    }

    public static void markScheduled(WorkSpecDao_Impl workSpecDao_Impl, SystemClock systemClock, ArrayList arrayList) {
        if (arrayList.size() > 0) {
            systemClock.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                workSpecDao_Impl.markWorkSpecScheduled(jCurrentTimeMillis, ((WorkSpec) obj).id);
            }
        }
    }

    public static void schedule(Configuration configuration, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            ArrayList eligibleWorkForSchedulingWithContentUris = workSpecDao_ImplWorkSpecDao.getEligibleWorkForSchedulingWithContentUris();
            markScheduled(workSpecDao_ImplWorkSpecDao, (SystemClock) configuration.clock, eligibleWorkForSchedulingWithContentUris);
            ArrayList eligibleWorkForScheduling = workSpecDao_ImplWorkSpecDao.getEligibleWorkForScheduling(configuration.maxSchedulerLimit);
            markScheduled(workSpecDao_ImplWorkSpecDao, (SystemClock) configuration.clock, eligibleWorkForScheduling);
            eligibleWorkForScheduling.addAll(eligibleWorkForSchedulingWithContentUris);
            ArrayList allEligibleWorkSpecsForScheduling = workSpecDao_ImplWorkSpecDao.getAllEligibleWorkSpecsForScheduling();
            workDatabase.setTransactionSuccessful();
            workDatabase.internalEndTransaction();
            if (eligibleWorkForScheduling.size() > 0) {
                WorkSpec[] workSpecArr = (WorkSpec[]) eligibleWorkForScheduling.toArray(new WorkSpec[eligibleWorkForScheduling.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Scheduler scheduler = (Scheduler) it.next();
                    if (scheduler.hasLimitedSchedulingSlots()) {
                        scheduler.schedule(workSpecArr);
                    }
                }
            }
            if (allEligibleWorkSpecsForScheduling.size() > 0) {
                WorkSpec[] workSpecArr2 = (WorkSpec[]) allEligibleWorkSpecsForScheduling.toArray(new WorkSpec[allEligibleWorkSpecsForScheduling.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    Scheduler scheduler2 = (Scheduler) it2.next();
                    if (!scheduler2.hasLimitedSchedulingSlots()) {
                        scheduler2.schedule(workSpecArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.internalEndTransaction();
            throw th;
        }
    }
}
