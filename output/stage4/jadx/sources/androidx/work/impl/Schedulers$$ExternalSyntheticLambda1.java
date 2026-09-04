package androidx.work.impl;

import androidx.work.Configuration;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.Operation;
import androidx.work.Operation$State$FAILURE;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import okhttp3.internal.connection.RealConnection$connectTls$1;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class Schedulers$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ Schedulers$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                List list = (List) this.f$0;
                WorkGenerationalId workGenerationalId = (WorkGenerationalId) this.f$1;
                Configuration configuration = (Configuration) this.f$2;
                WorkDatabase workDatabase = (WorkDatabase) this.f$3;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Scheduler) it.next()).cancel(workGenerationalId.workSpecId);
                }
                Schedulers.schedule(configuration, workDatabase, list);
                break;
            default:
                WorkManagerImpl workManagerImpl = (WorkManagerImpl) this.f$0;
                OperationImpl operationImpl = (OperationImpl) this.f$1;
                RealConnection$connectTls$1 realConnection$connectTls$1 = (RealConnection$connectTls$1) this.f$2;
                WorkRequest workRequest = (WorkRequest) this.f$3;
                WorkDatabase workDatabase2 = workManagerImpl.mWorkDatabase;
                WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase2.workSpecDao();
                ArrayList workSpecIdAndStatesForName = workSpecDao_ImplWorkSpecDao.getWorkSpecIdAndStatesForName(C0000.decode(new byte[]{72, 92, 12, 84, 110, 79, 87, 71, 9, 86, 67}, "85b318"));
                if (workSpecIdAndStatesForName.size() > 1) {
                    operationImpl.markState(new Operation$State$FAILURE(new UnsupportedOperationException(C0000.decode(new byte[]{116, 7, 94, 23, 67, 65, 7, 66, 19, 13, 24, 68, 54, 101, 125, 32, 99, 35, 16, 64, 88, 13, 15, 81, 26, 65, 21, 11, 67, 65, 81, 4, 23, 5, 88, 81, 94, 15, 21, 18, 12, 7, 65, 19, 12, 71, 82, 79}, "7f007af2caadc59a", 2))));
                } else {
                    WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) (workSpecIdAndStatesForName.isEmpty() ? null : workSpecIdAndStatesForName.get(0));
                    if (idAndState == null) {
                        realConnection$connectTls$1.invoke();
                    } else {
                        String str = idAndState.id;
                        WorkSpec workSpec = workSpecDao_ImplWorkSpecDao.getWorkSpec(str);
                        if (workSpec == null) {
                            operationImpl.markState(new Operation$State$FAILURE(new IllegalStateException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{98, 87, 16, 94, 55, 70, 92, 0, 21, 79, 11, 65, 12, 22}, "58b5d69c", false), str, C0000.decode(new byte[]{20, 21, 76, 91, 3, 66, 65, 91, 3, 17, 87, 94, 92, 67, 24, 84, 24, 93, 3, 91, 4, 22, 64, 21, 93, 88, 94, 111, 79, 90, 74, 88, 7, 68, 67, 26, 66, 18, 85, 69, 87, 23, 76, 21, 94, 92, 23, 88, 5}, "8583b6a6be4690", 0.0f)))));
                        } else if (!workSpec.isPeriodic()) {
                            operationImpl.markState(new Operation$State$FAILURE(new UnsupportedOperationException(C0000.decode(new byte[]{114, 83, 90, 20, 17, 67, 68, 66, 80, 82, 17, 6, 17, 125, 90, 86, 49, 10, 92, 87, 99, 92, 23, 8, 84, 64, 20, 71, 10, 67, 97, 87, 70, 90, 10, 7, 88, 81, 20, 100, 10, 17, 90, 87, 70, 29, 69, 54, 65, 86, 85, 71, 0, 67, 94, 66, 81, 65, 4, 23, 88, 93, 90, 19, 8, 22, 66, 70, 20, 67, 23, 6, 66, 87, 70, 69, 0, 67, 70, 93, 70, 88, 0, 17, 22, 65, 20, 71, 28, 19, 84, 28}, "1243ec", 2))));
                        } else if (idAndState.state == 6) {
                            workSpecDao_ImplWorkSpecDao.delete(str);
                            realConnection$connectTls$1.invoke();
                        } else {
                            try {
                                ResultKt.updateWorkImpl(workManagerImpl.mProcessor, workDatabase2, workManagerImpl.mConfiguration, workManagerImpl.mSchedulers, WorkSpec.copy$default(workRequest.workSpec, idAndState.id, 0, null, null, 0, 0L, 0, 0, 0L, 0, 8388606), workRequest.tags);
                                operationImpl.markState(Operation.SUCCESS);
                            } catch (Throwable th) {
                                operationImpl.markState(new Operation$State$FAILURE(th));
                            }
                        }
                    }
                }
                break;
        }
    }
}
