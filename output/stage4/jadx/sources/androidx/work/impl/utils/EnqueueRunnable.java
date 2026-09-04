package androidx.work.impl.utils;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Operation;
import androidx.work.Operation$State$FAILURE;
import androidx.work.SystemClock;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.text.CharsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class EnqueueRunnable implements Runnable {
    public final OperationImpl mOperation;
    public final WorkContinuationImpl mWorkContinuation;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{39, 91, 23, 20, 85, 68, 4, 55, 71, 90, 12, 85, 0, 89, 3}, "b5fa01ae24b4", 0.0f));
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, OperationImpl operationImpl) {
        this.mWorkContinuation = workContinuationImpl;
        this.mOperation = operationImpl;
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0139  */
    /* JADX WARN: Code duplicated, block: B:70:0x013e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0140  */
    /* JADX WARN: Code duplicated, block: B:74:0x0146  */
    /* JADX WARN: Code duplicated, block: B:75:0x0149  */
    /* JADX WARN: Code duplicated, block: B:77:0x014c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0156  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a2  */
    public static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean z;
        boolean z2;
        boolean z3;
        List<WorkRequest> list;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        boolean z9;
        HashSet hashSetPrerequisitesFor = WorkContinuationImpl.prerequisitesFor(workContinuationImpl);
        WorkManagerImpl workManagerImpl = workContinuationImpl.mWorkManagerImpl;
        List list2 = workContinuationImpl.mWork;
        int i2 = 0;
        String[] strArr = (String[]) hashSetPrerequisitesFor.toArray(new String[0]);
        String str = workContinuationImpl.mName;
        int i3 = workContinuationImpl.mExistingWorkPolicy;
        ((SystemClock) workManagerImpl.mConfiguration.clock).getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        boolean z10 = strArr != null && strArr.length > 0;
        if (z10) {
            int length = strArr.length;
            z2 = false;
            z3 = false;
            z = true;
            while (true) {
                if (i2 < length) {
                    WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(strArr[i2]);
                    if (workSpec == null) {
                        SystemClock.get().getClass();
                    } else {
                        int i4 = workSpec.state;
                        z &= i4 == 3;
                        if (i4 == 4) {
                            z3 = true;
                        } else if (i4 == 6) {
                            z2 = true;
                        }
                        i2++;
                    }
                }
                z6 = false;
                workContinuationImpl.mEnqueued = true;
                return z6;
            }
        }
        z = true;
        z2 = false;
        z3 = false;
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (zIsEmpty || z10) {
            list = list2;
            z4 = zIsEmpty;
            z5 = false;
        } else {
            ArrayList workSpecIdAndStatesForName = workDatabase.workSpecDao().getWorkSpecIdAndStatesForName(str);
            if (workSpecIdAndStatesForName.isEmpty()) {
                list = list2;
                z4 = zIsEmpty;
            } else if (i3 == 3 || i3 == 4) {
                Api apiDependencyDao = workDatabase.dependencyDao();
                ArrayList arrayList = new ArrayList();
                int size = workSpecIdAndStatesForName.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = workSpecIdAndStatesForName.get(i5);
                    i5++;
                    WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) obj;
                    String str2 = idAndState.id;
                    List list3 = list2;
                    WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) apiDependencyDao.zaa;
                    Api api = apiDependencyDao;
                    boolean z11 = zIsEmpty;
                    RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{50, 38, 125, 33, 119, 97, 20, 39, 119, 55, 127, 97, 30, 31, 74, 10, 81, 67, 119, 54, 123, 120, 20, 0, 93, 18, 84, 91, 82, 80, 13, 87, 24, 67, 102, 44, 113, 103, 113, 68, 72, 16, 84, 71, 83, 68, 22, 93, 18, 10, 69, 1, 107, 92, 80, 89, 7}, "ac1d454d8b1565c4", false), 1);
                    if (str2 == null) {
                        roomSQLiteQueryAcquire.bindNull(1);
                    } else {
                        roomSQLiteQueryAcquire.bindString(str2, 1);
                    }
                    workDatabase_Impl.assertNotSuspendingTransaction();
                    Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
                    try {
                        if (cursorQuery.moveToFirst()) {
                            z7 = false;
                            if (cursorQuery.getInt(0) != 0) {
                                z8 = true;
                            }
                            cursorQuery.close();
                            roomSQLiteQueryAcquire.release();
                            if (z8) {
                                i = idAndState.state;
                                if (i == 3) {
                                    z9 = true;
                                } else {
                                    z9 = z7;
                                }
                                boolean z12 = z & z9;
                                if (i == 4) {
                                    z3 = true;
                                } else if (i == 6) {
                                    z2 = true;
                                }
                                arrayList.add(idAndState.id);
                                z = z12;
                            }
                            list2 = list3;
                            apiDependencyDao = api;
                            zIsEmpty = z11;
                        } else {
                            z7 = false;
                        }
                        z8 = z7;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        if (z8) {
                            i = idAndState.state;
                            if (i == 3) {
                                z9 = true;
                            } else {
                                z9 = z7;
                            }
                            boolean z13 = z & z9;
                            if (i == 4) {
                                z3 = true;
                            } else if (i == 6) {
                                z2 = true;
                            }
                            arrayList.add(idAndState.id);
                            z = z13;
                        }
                        list2 = list3;
                        apiDependencyDao = api;
                        zIsEmpty = z11;
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                }
                list = list2;
                z4 = zIsEmpty;
                List list4 = arrayList;
                list4 = arrayList;
                if (i3 == 4 && (z2 || z3)) {
                    WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
                    ArrayList workSpecIdAndStatesForName2 = workSpecDao_ImplWorkSpecDao.getWorkSpecIdAndStatesForName(str);
                    int size2 = workSpecIdAndStatesForName2.size();
                    int i6 = 0;
                    while (i6 < size2) {
                        Object obj2 = workSpecIdAndStatesForName2.get(i6);
                        i6++;
                        workSpecDao_ImplWorkSpecDao.delete(((WorkSpec.IdAndState) obj2).id);
                    }
                    z2 = false;
                    z3 = false;
                    list4 = Collections.EMPTY_LIST;
                }
                strArr = (String[]) list4.toArray(strArr);
                z10 = strArr.length > 0;
            } else {
                if (i3 == 2) {
                    int size3 = workSpecIdAndStatesForName.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 < size3) {
                            Object obj3 = workSpecIdAndStatesForName.get(i7);
                            i7++;
                            int i8 = ((WorkSpec.IdAndState) obj3).state;
                            if (i8 == 1 || i8 == 2) {
                                z6 = false;
                                workContinuationImpl.mEnqueued = true;
                                return z6;
                            }
                        }
                    }
                }
                new CancelWorkRunnable.AnonymousClass1(workManagerImpl, str, 1).run();
                WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao2 = workDatabase.workSpecDao();
                int size4 = workSpecIdAndStatesForName.size();
                int i9 = 0;
                while (i9 < size4) {
                    Object obj4 = workSpecIdAndStatesForName.get(i9);
                    i9++;
                    workSpecDao_ImplWorkSpecDao2.delete(((WorkSpec.IdAndState) obj4).id);
                }
                list = list2;
                z4 = zIsEmpty;
                z5 = true;
            }
            z5 = false;
        }
        boolean z14 = z5;
        for (WorkRequest workRequest : list) {
            WorkSpec workSpec2 = workRequest.workSpec;
            UUID uuid = workRequest.id;
            if (!z10 || z) {
                workSpec2.lastEnqueueTime = jCurrentTimeMillis;
            } else if (z3) {
                workSpec2.state = 4;
            } else if (z2) {
                workSpec2.state = 6;
            } else {
                workSpec2.state = 5;
            }
            if (workSpec2.state == 1) {
                z14 = true;
            }
            WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao3 = workDatabase.workSpecDao();
            WorkDatabase_Impl workDatabase_Impl2 = workSpecDao_ImplWorkSpecDao3.__db;
            workDatabase_Impl2.assertNotSuspendingTransaction();
            workDatabase_Impl2.beginTransaction();
            try {
                workSpecDao_ImplWorkSpecDao3.__insertionAdapterOfWorkSpec.insert(workSpec2);
                workDatabase_Impl2.setTransactionSuccessful();
                workDatabase_Impl2.internalEndTransaction();
                if (z10) {
                    for (String str3 : strArr) {
                        Dependency dependency = new Dependency(uuid.toString(), str3);
                        Api apiDependencyDao2 = workDatabase.dependencyDao();
                        WorkDatabase_Impl workDatabase_Impl3 = (WorkDatabase_Impl) apiDependencyDao2.zaa;
                        workDatabase_Impl3.assertNotSuspendingTransaction();
                        workDatabase_Impl3.beginTransaction();
                        try {
                            ((WorkTagDao_Impl.AnonymousClass1) apiDependencyDao2.zac).insert(dependency);
                            workDatabase_Impl3.setTransactionSuccessful();
                            workDatabase_Impl3.internalEndTransaction();
                        } catch (Throwable th2) {
                            workDatabase_Impl3.internalEndTransaction();
                            throw th2;
                        }
                    }
                }
                workDatabase.workTagDao().insertTags(uuid.toString(), workRequest.tags);
                if (!z4) {
                    WorkLauncherImpl workLauncherImplWorkNameDao = workDatabase.workNameDao();
                    WorkName workName = new WorkName(str, uuid.toString());
                    WorkDatabase_Impl workDatabase_Impl4 = (WorkDatabase_Impl) workLauncherImplWorkNameDao.processor;
                    workDatabase_Impl4.assertNotSuspendingTransaction();
                    workDatabase_Impl4.beginTransaction();
                    try {
                        ((WorkTagDao_Impl.AnonymousClass1) workLauncherImplWorkNameDao.workTaskExecutor).insert(workName);
                        workDatabase_Impl4.setTransactionSuccessful();
                        workDatabase_Impl4.internalEndTransaction();
                    } catch (Throwable th3) {
                        workDatabase_Impl4.internalEndTransaction();
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                workDatabase_Impl2.internalEndTransaction();
                throw th4;
            }
        }
        z6 = z14;
        workContinuationImpl.mEnqueued = true;
        return z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        OperationImpl operationImpl = this.mOperation;
        WorkContinuationImpl workContinuationImpl = this.mWorkContinuation;
        WorkManagerImpl workManagerImpl = workContinuationImpl.mWorkManagerImpl;
        String strDecode = C0000.decode(new byte[]{49, 87, 66, 8, 113, 94, 8, 76, 89, 13, 71, 80, 18, 81, 95, 13, 18, 89, 7, 75, 16, 0, 75, 82, 10, 93, 67, 67, 26}, "f80c21", true);
        try {
            HashSet hashSet = new HashSet();
            hashSet.addAll(workContinuationImpl.mIds);
            HashSet hashSetPrerequisitesFor = WorkContinuationImpl.prerequisitesFor(workContinuationImpl);
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    hashSet.removeAll(workContinuationImpl.mIds);
                    z = false;
                    break;
                } else if (hashSetPrerequisitesFor.contains((String) it.next())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                throw new IllegalStateException(strDecode + workContinuationImpl + C0000.decode(new byte[]{31}, "666c9c1dcf42", 5));
            }
            WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                CharsKt.checkContentUriTriggerWorkerLimits(workDatabase, workManagerImpl.mConfiguration, workContinuationImpl);
                boolean zProcessContinuation = processContinuation(workContinuationImpl);
                workDatabase.setTransactionSuccessful();
                workDatabase.internalEndTransaction();
                if (zProcessContinuation) {
                    PackageManagerHelper.setComponentEnabled(workManagerImpl.mContext, RescheduleReceiver.class, true);
                    Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                }
                operationImpl.markState(Operation.SUCCESS);
            } catch (Throwable th) {
                workDatabase.internalEndTransaction();
                throw th;
            }
        } catch (Throwable th2) {
            operationImpl.markState(new Operation$State$FAILURE(th2));
        }
    }
}
