package okhttp3.internal.connection;

import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.Collections;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealConnection$connectTls$1 extends Lambda implements Function0 {
    public final /* synthetic */ Object $address;
    public final /* synthetic */ Object $certificatePinner;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $unverifiedHandshake;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealConnection$connectTls$1(Object obj, Object obj2, Object obj3, int i) {
        super(0);
        this.$r8$classId = i;
        this.$certificatePinner = obj;
        this.$unverifiedHandshake = obj2;
        this.$address = obj3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return ((CertificatePinner) this.$certificatePinner).certificateChainCleaner.clean(((Address) this.$address).url.host, ((Handshake) this.$unverifiedHandshake).peerCertificates());
            default:
                new EnqueueRunnable(new WorkContinuationImpl((WorkManagerImpl) this.$unverifiedHandshake, C0000.decode(new byte[]{18, 90, 10, 81, 108, 66, 10, 69, 83, 83, 19}, "b3d635e786adb5d4", 1), 2, Collections.singletonList((WorkRequest) this.$certificatePinner), 0), (OperationImpl) this.$address).run();
                return Unit.INSTANCE;
        }
    }
}
