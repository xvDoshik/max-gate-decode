package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011J\u0012\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\fj\u0002`\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\f\u0012\b\u0012\u00060\fj\u0002`\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lkotlin/io/path/ExceptionsCollector;", "", "limit", "", "<init>", "(I)V", "value", "totalExceptions", "getTotalExceptions", "()I", "collectedExceptions", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCollectedExceptions", "()Ljava/util/List;", "path", "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "setPath", "(Ljava/nio/file/Path;)V", "enterEntry", "", "name", "exitEntry", "collect", "exception", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ExceptionsCollector {
    private final List<Exception> collectedExceptions;
    private final int limit;
    private Path path;
    private int totalExceptions;

    public ExceptionsCollector() {
        this(0, 1, null);
    }

    public final void collect(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, C0000.decode(new byte[]{81, 78, 87, 84, 67, 70, 10, 11, 92}, "464132cd2f32", true));
        this.totalExceptions++;
        if (this.collectedExceptions.size() < this.limit) {
            if (this.path != null) {
                Throwable thInitCause = new FileSystemException(String.valueOf(this.path)).initCause(exception);
                Intrinsics.checkNotNull(thInitCause, C0000.decode(new byte[]{13, 20, 92, 94, 22, 80, 81, 90, 89, 88, 17, 19, 1, 4, 16, 81, 87, 64, 68, 20, 67, 88, 69, 93, 12, 15, 29, 92, 67, 95, 92, 20, 67, 78, 21, 86, 67, 11, 81, 68, 87, 29, 94, 93, 88, 25, 3, 90, 15, 4, 30, 116, 95, 95, 85, 103, 78, 68, 17, 86, 14, 36, 72, 81, 83, 67, 68, 93, 88, 89}, "ca02630477e3", true));
                exception = (FileSystemException) thInitCause;
            }
            this.collectedExceptions.add(exception);
        }
    }

    public final void enterEntry(Path name) {
        Intrinsics.checkNotNullParameter(name, C0000.decode(new byte[]{89, 3, 89, 87}, "7b423f4b8e", false));
        Path path = this.path;
        this.path = path != null ? path.resolve(name) : null;
    }

    public final void exitEntry(Path name) {
        Intrinsics.checkNotNullParameter(name, C0000.decode(new byte[]{93, 80, 91, 1}, "316d94acd19f", 0.0f));
        Path path = this.path;
        if (!Intrinsics.areEqual(name, path != null ? path.getFileName() : null)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{112, 85, 11, 95, 86, 93, 69, 66, 0, 67, 71, 90, 70, 84, 88, 80, 88, 64, 76}, "64b339e0e2234155", 0).toString());
        }
        Path path2 = this.path;
        this.path = path2 != null ? path2.getParent() : null;
    }

    public ExceptionsCollector(int i) {
        this.limit = i;
        this.collectedExceptions = new ArrayList();
    }

    public /* synthetic */ ExceptionsCollector(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 64 : i);
    }

    public final int getTotalExceptions() {
        return this.totalExceptions;
    }

    public final List<Exception> getCollectedExceptions() {
        return this.collectedExceptions;
    }

    public final Path getPath() {
        return this.path;
    }

    public final void setPath(Path path) {
        this.path = path;
    }
}
