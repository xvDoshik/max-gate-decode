package androidx.work.impl;

import com.google.firebase.concurrent.DelegatingScheduledExecutorService;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class Processor$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ Processor$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.$r8$classId) {
            case 0:
                Processor processor = (Processor) this.f$0;
                ArrayList arrayList = (ArrayList) this.f$1;
                String str = (String) this.f$2;
                WorkDatabase workDatabase = processor.mWorkDatabase;
                arrayList.addAll(workDatabase.workTagDao().getTagsForWorkSpecId(str));
                return workDatabase.workSpecDao().getWorkSpec(str);
            default:
                return ((DelegatingScheduledExecutorService) this.f$0).delegate.submit(new Processor$$ExternalSyntheticLambda2((Callable) this.f$1, 16, (ConnectionPool) this.f$2));
        }
    }
}
