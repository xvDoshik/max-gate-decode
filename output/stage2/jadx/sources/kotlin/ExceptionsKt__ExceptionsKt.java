package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\b\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0007\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0007\"!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u00028F¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"printStackTrace", "", "", "writer", "Ljava/io/PrintWriter;", "stream", "Ljava/io/PrintStream;", "stackTrace", "", "Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "stackTraceToString", "", "addSuppressed", "exception", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/ExceptionsKt")
public class ExceptionsKt__ExceptionsKt {
    public static final void addSuppressed(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{93, 64, 90, 10, 16, 6}, "a42cc816bf", false));
        Intrinsics.checkNotNullParameter(th2, C0000.decode(new byte[]{81, 78, 84, 80, 22, 22, 94, 90, 87}, "4675fb759ea6356d"));
        if (th != th2) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, th2);
        }
    }

    public static final StackTraceElement[] getStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{90, 16, 88, 91, 64, 15}, "fd0231a47e7a", false));
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable th) {
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable th) {
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{4, 69, 81, 89, 68, 6}, "8190788c5a020b27", 0.0f));
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(th);
    }

    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th) {
    }

    private static final void printStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{10, 67, 92, 15, 18, 90}, "674fadff58ff", 0.0f));
        th.printStackTrace();
    }

    private static final void printStackTrace(Throwable th, PrintStream printStream) {
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{9, 23, 92, 91, 21, 9}, "5c42f71a95dea0", 4));
        Intrinsics.checkNotNullParameter(printStream, C0000.decode(new byte[]{18, 66, 71, 82, 83, 15}, "a6572beaa7b818d7", 0.0f));
        th.printStackTrace(printStream);
    }

    private static final void printStackTrace(Throwable th, PrintWriter printWriter) {
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{11, 17, 9, 12, 23, 7}, "7eaed9656167", 7));
        Intrinsics.checkNotNullParameter(printWriter, C0000.decode(new byte[]{19, 75, 94, 77, 7, 71}, "d979b5aeeada", 0.0f));
        th.printStackTrace(printWriter);
    }

    public static final String stackTraceToString(Throwable th) {
        Intrinsics.checkNotNullParameter(th, C0000.decode(new byte[]{13, 70, 13, 88, 17, 91}, "12e1be", true));
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{70, 94, 98, 16, 16, 81, 15, 6, 76, 23, 27, 26, 17}, "211db8aad9548773", false));
        return string;
    }
}
