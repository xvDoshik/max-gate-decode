package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3 extends FunctionReferenceImpl implements Function2<Path, Exception, FileVisitResult> {
    final /* synthetic */ Path $normalizedTarget;
    final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
    final /* synthetic */ Path $target;
    final /* synthetic */ Path $this_copyToRecursively;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3) {
        super(2, Intrinsics.Kotlin.class, C0000.decode(new byte[]{3, 67, 16, 92, 70}, "f1b346671deb8a", 0.0f), C0000.decode(new byte[]{80, 93, 72, 79, 50, 11, 99, 6, 82, 20, 68, 69, 88, 71, 1, 85, 74, 22, 93, 68, 20, 11, 67, 71, 97, 0, 66, 94, 66, 122, 16, 102, 108, 98, 89, 66, 14, 54, 84, 0, 68, 19, 69, 95, 71, 84, 34, 76, 93, 81, 76, 95, 9, 10, 66, 40, 69, 73, 122, 93, 94, 69, 8, 80, 93, 29, 82, 64, 11, 75, 87, 22, 95, 2, 66, 95, 94, 95, 23, 22, 117, 71, 86, 85, 18, 13, 94, 13, 2, 90, 122, 92, 80, 71, 5, 22, 93, 91, 87, 25, 0, 13, 93, 6, 30, 49, 87, 66, 89, 10, 40, 83, 82, 68, 89, 25, 8, 13, 94, 76, 87, 8, 90, 83, 30, 97, 5, 77, 91, 9, 116, 92, 7, 18, 80, 76, 95, 8, 89, 25, 87, 88, 8, 92, 28, 98, 89, 66, 14, 95, 125, 9, 80, 23, 87, 25, 95, 88, 11, 22, 85, 91, 84, 83, 73, 52, 80, 23, 89, 90, 122, 92, 80, 71, 5, 22, 95, 83, 86, 81, 73, 33, 73, 0, 84, 17, 66, 95, 94, 95, 95, 16, ByteCompanionObject.MAX_VALUE, 88, 89, 64, 7, 75, 95, 10, 94, 78, 80, 95, 93, 84, 75, ByteCompanionObject.MAX_VALUE, 90, 94, 93, 96, 15, 23, 88, 23, 99, 4, 69, 67, 93, 69, 95}, "3286fd1c1a6611d9"), 0);
        this.$onError = function3;
        this.$this_copyToRecursively = path;
        this.$target = path2;
        this.$normalizedTarget = path3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final FileVisitResult invoke(Path path, Exception exc) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{22, 6}, "f6f3819755d1ed2d"));
        Intrinsics.checkNotNullParameter(exc, C0000.decode(new byte[]{18, 2}, "b310be3e0014d500"));
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(this.$onError, this.$this_copyToRecursively, this.$target, this.$normalizedTarget, path, exc);
    }
}
