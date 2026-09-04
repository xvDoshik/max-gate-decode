package kotlinx.coroutines.internal;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class MainDispatcherLoader {
    public static final HandlerContext dispatcher;

    static {
        String property;
        String strDecode = C0000.decode(new byte[]{92, 9, 71, 89, 88, 91, 29, 30, 84, 88, 74, 11, 64, 66, 94, 8, 86, 70, 31, 83, 4, 67, 67, 25, 75, 1, 71, 64, 94, 5, 86, 27, 93, 90, 4, 84, 82, 69}, "7f3515e0778d56");
        int i = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        Object next = null;
        try {
            property = System.getProperty(strDecode);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = SequencesKt.toList(new ConstrainedOnceSequence(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(0, Arrays.asList(new AndroidDispatcherFactory()).iterator()))).iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    ((AndroidDispatcherFactory) next).getClass();
                    do {
                        ((AndroidDispatcherFactory) it.next()).getClass();
                    } while (it.hasNext());
                }
            }
            if (((AndroidDispatcherFactory) next) == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{127, 93, 82, 19, 90, 82, 23, 78, 8, 77, 91, 68, 23, 94, 87, 18, 123, 7, 95, 89, 23, 93, 8, 74, 67, 5, 23, 85, 90, 87, 68, 70, 95, 68, 23, 84, 8, 74, 64, 13, 13, 81, 28, 18, 119, 2, 82, 23, 83, 92, 17, 92, 93, 0, 6, 88, 81, 75, 22, 22, 68, 88, 65, 80, 5, 80, 93, 3, 67, 66, 90, 87, 22, 43, 87, 94, 89, 25, 5, 80, 64, 20, 2, 66, 81, 90, 83, 20, 26, 23, 82, 23, 6, 23, 19, 67, 8, 89, 70, 94, 95, 8, 78, 26, 84, 86, 19, 86, 70, 16, 10, 88, 87, 65, 27, 7, 88, 83, 69, 86, 8, 93, 20, 68, 2, 88, 86, 18, 83, 8, 69, 66, 69, 92, 65, 80, 71, 68, 11, 87, 65, 18, 66, 14, 83, 23, 68, 88, 12, 92, 19, 18, 6, 68, 65, 91, 89, 8, 22, 86, 68, 25, 70, 82, 92, 16, 15, 95, 92, 74, 27, 5, 89, 69, 88, 76, 21, 80, 93, 1, 16, 27, 81, 93, 68, 3, 17}, "226f6779a93dc6", 0.0f));
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{97, 12, 1, 23, 84, 80, 93, 94, 23, 92, 11, 90, 22, 3, 16, 69, 92, 23, 68, 89, 86, 69, 20, 81, 65, 81, 13, 89, 7, 4, 14, 0}, "5dd7914070d5ffbe", 0));
            }
            dispatcher = new HandlerContext(HandlerDispatcherKt.asHandler(mainLooper), false);
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
