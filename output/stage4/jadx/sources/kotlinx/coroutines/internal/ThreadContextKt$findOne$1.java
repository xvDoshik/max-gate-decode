package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ThreadContextKt$findOne$1 extends Lambda implements Function2 {
    public static final ThreadContextKt$findOne$1 INSTANCE;
    public static final ThreadContextKt$findOne$1 INSTANCE$1;
    public static final ThreadContextKt$findOne$1 INSTANCE$2;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 2;
        INSTANCE$1 = new ThreadContextKt$findOne$1(i, 1);
        INSTANCE = new ThreadContextKt$findOne$1(i, 0);
        INSTANCE$2 = new ThreadContextKt$findOne$1(i, 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThreadContextKt$findOne$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ThreadContextElement threadContextElement = (ThreadContextElement) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                if (threadContextElement != null) {
                    return threadContextElement;
                }
                if (element instanceof ThreadContextElement) {
                    return (ThreadContextElement) element;
                }
                return null;
            case 1:
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                if (!(element2 instanceof ThreadContextElement)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? element2 : Integer.valueOf(iIntValue + 1);
            default:
                return (ThreadState) obj;
        }
    }
}
