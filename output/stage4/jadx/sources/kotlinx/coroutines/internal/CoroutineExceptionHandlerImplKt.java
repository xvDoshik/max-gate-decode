package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.List;
import java.util.ServiceConfigurationError;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CoroutineExceptionHandlerImplKt {
    public static final List platformExceptionHandlers;

    static {
        try {
            platformExceptionHandlers = SequencesKt.toList(new ConstrainedOnceSequence(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(0, Arrays.asList(new AndroidExceptionPreHandler()).iterator())));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
