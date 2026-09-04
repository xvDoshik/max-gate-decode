package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class StackTraceRecoveryKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        Object failure;
        Object failure2;
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[0];
        new StackTraceElement(C0000.decode(new byte[]{108, 38, 119, 51, 43, 102, 103, 44, 118, 36, 74, 108, 113, 42, 109, 47, 32, 114, 97, 60}, "3e8ad3"), C0000.decode(new byte[]{106}, "5aa3d38153f06d40", 3), stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            failure = ContinuationImpl.class.getCanonicalName();
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (Result.m12exceptionOrNullimpl(failure) != null) {
            failure = C0000.decode(new byte[]{90, 87, 76, 84, 88, 12, 31, 91, 87, 74, 94, 23, 69, 81, 86, 93, 66, 76, 91, 78, 85, 22, 88, 12, 69, 93, 74, 86, 80, 14, 31, 122, 89, 75, 84, 33, 94, 86, 76, 81, 95, 23, 80, 76, 81, 87, 95, 43, 92, 72, 84}, "18881b", 0.0f);
        }
        try {
            failure2 = StackTraceRecoveryKt.class.getCanonicalName();
        } catch (Throwable th2) {
            failure2 = new Result.Failure(th2);
        }
        if (Result.m12exceptionOrNullimpl(failure2) != null) {
            failure2 = C0000.decode(new byte[]{93, 12, 16, 14, 95, 11, 29, 24, 87, 10, 19, 9, 67, 23, 13, 12, 83, 22, 75, 95, 90, 17, 4, 20, 88, 2, 8, 76, 101, 17, 4, 85, 95, 49, 19, 7, 85, 6, 54, 7, 85, 10, 19, 83, 70, 28, 42, 18}, "6cdb6ee64eaf", false);
        }
    }
}
