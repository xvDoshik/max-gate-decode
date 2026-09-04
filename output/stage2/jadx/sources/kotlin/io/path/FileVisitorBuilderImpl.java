package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u000f26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u0005H\u0016J@\u0010\t\u001a\u00020\u000f26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u0005H\u0016J@\u0010\n\u001a\u00020\u000f26\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b0\u0005H\u0016JB\u0010\f\u001a\u00020\u000f28\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u001a\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0012\u001a\u00020\u001cH\u0002R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/io/path/FileVisitorBuilderImpl;", "Lkotlin/io/path/FileVisitorBuilder;", "<init>", "()V", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/Path;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "isBuilt", "", "", "function", "Lkotlin/ParameterName;", "name", "directory", "attributes", "file", "exception", "build", "Ljava/nio/file/FileVisitor;", "checkIsNotBuilt", "checkNotDefined", "", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileVisitorBuilderImpl implements FileVisitorBuilder {
    private boolean isBuilt;
    private Function2<? super Path, ? super IOException, ? extends FileVisitResult> onPostVisitDirectory;
    private Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> onPreVisitDirectory;
    private Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> onVisitFile;
    private Function2<? super Path, ? super IOException, ? extends FileVisitResult> onVisitFileFailed;

    private final void checkIsNotBuilt() {
        if (this.isBuilt) {
            throw new IllegalStateException(C0000.decode(new byte[]{50, 93, 8, 75, 17, 7, 23, 15, 95, 85, 86, 22, 17, 79, 7, 70, 65, 89, 93, 23, 7, 7, 87, 72, 19, 6, 68, 81, 10, 65}, "f5a81ebf313d18", true));
        }
    }

    private final void checkNotDefined(Object function, String name) {
        if (function != null) {
            throw new IllegalStateException(name + C0000.decode(new byte[]{18, 19, 0, 21, 22, 4, 13, 20, 87, 5, 5, 31, 22, 1, 4, 0, 91, 10, 4, 2}, "2daf6eaf", true));
        }
    }

    @Override // kotlin.io.path.FileVisitorBuilder
    public void onPostVisitDirectory(Function2<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        Intrinsics.checkNotNullParameter(function, C0000.decode(new byte[]{86, 17, 15, 2, 22, 81, 12, 8}, "0daab8cfb1"));
        checkIsNotBuilt();
        checkNotDefined(this.onPostVisitDirectory, C0000.decode(new byte[]{11, 89, 105, 9, 67, 65, 100, 10, 70, 11, 64, 39, 13, 69, 92, 5, 68, 90, 64, 26}, "d79f052c5b4c", true));
        this.onPostVisitDirectory = function;
    }

    @Override // kotlin.io.path.FileVisitorBuilder
    public void onPreVisitDirectory(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        Intrinsics.checkNotNullParameter(function, C0000.decode(new byte[]{94, 71, 8, 80, 65, 89, 86, 91}, "82f35095416a2e4b", 0.0f));
        checkIsNotBuilt();
        checkNotDefined(this.onPreVisitDirectory, C0000.decode(new byte[]{86, 11, 49, 74, 82, 52, 88, 22, 93, 77, 39, 80, 75, 0, 2, 76, 88, 16, 72}, "9ea87b1e49c9", 0.0f));
        this.onPreVisitDirectory = function;
    }

    @Override // kotlin.io.path.FileVisitorBuilder
    public void onVisitFile(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function) {
        Intrinsics.checkNotNullParameter(function, C0000.decode(new byte[]{2, 67, 93, 87, 68, 10, 12, 86}, "d6340cc808c7f27d", 0.0f));
        checkIsNotBuilt();
        checkNotDefined(this.onVisitFile, C0000.decode(new byte[]{90, 90, 52, 8, 64, 11, 68, 39, 95, 90, 6}, "54ba3b0a66c3", false));
        this.onVisitFile = function;
    }

    @Override // kotlin.io.path.FileVisitorBuilder
    public void onVisitFileFailed(Function2<? super Path, ? super IOException, ? extends FileVisitResult> function) {
        Intrinsics.checkNotNullParameter(function, C0000.decode(new byte[]{86, 17, 13, 2, 70, 92, 95, 10}, "0dca25", false));
        checkIsNotBuilt();
        checkNotDefined(this.onVisitFileFailed, C0000.decode(new byte[]{95, 12, 100, 88, 21, 12, 68, 36, 91, 93, 3, 35, 81, 11, 94, 84, 2}, "0b21fe", false));
        this.onVisitFileFailed = function;
    }

    public final FileVisitor<Path> build() {
        checkIsNotBuilt();
        this.isBuilt = true;
        return new FileVisitorImpl(this.onPreVisitDirectory, this.onVisitFile, this.onVisitFileFailed, this.onPostVisitDirectory);
    }
}
