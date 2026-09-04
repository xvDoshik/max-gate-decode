package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
    final /* synthetic */ Function3<CopyActionContext, Path, Path, CopyActionResult> $copyAction;
    final /* synthetic */ Path $normalizedTarget;
    final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
    final /* synthetic */ ArrayList<Path> $stack;
    final /* synthetic */ Path $target;
    final /* synthetic */ Path $this_copyToRecursively;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2(ArrayList<Path> arrayList, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Path path3, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function4) {
        super(2, Intrinsics.Kotlin.class, C0000.decode(new byte[]{82, 11, 21, 31}, "1def8fe46a0a", 0), C0000.decode(new byte[]{85, 87, 69, 79, 108, 86, 97, 6, 7, 68, 68, 75, 92, 64, 93, 85, 74, 71, 7, 94, 70, 65, 17, 102, 89, 77, 91, 16, 47, 69, 105, 103, 101, 87, 76, 81, 97, 6, 7, 68, 68, 75, 92, 64, 93, ByteCompanionObject.MAX_VALUE, 70, 13, 7, 69, 95, 87, 91, 69, 115, 77, 27, 47, 14, 80, 64, 89, 26, 67, 76, 80, 95, 76, 37, 67, 68, 89, 76, 122, 81, 74, 71, 88, 40, 90, 89, 76, 89, 95, 86, 22, 89, 21, 9, 30, 80, 77, 91, 85, 76, 80, 92, 13, 23, 30, 112, 77, 91, 85, 76, 80, 92, 13, 87, 10, 122, 82, 84, 64, 89, 22, 93, 10, 11, 30, 80, 81, 89, 83, 23, 105, 82, 23, 12, 10, 122, 82, 84, 64, 89, 22, 93, 10, 11, 30, 80, 81, 89, 83, 23, 105, 82, 23, 12, 10, 122, 82, 84, 64, 89, 22, 93, 10, 11, 30, 80, 81, 89, 83, 23, 105, 82, 23, 12, 10, 122, 83, 90, 66, 84, 80, 93, 76, 14, 71, 91, 23, 83, 67, 86, 90, 71, 10, 11, 95, 69, 23, 115, 67, 86, 90, 71, 10, 11, 95, 5, 3, 121, 92, 89, 79, 82, 76, 10, 88, 89, 23, 83, 95, 84, 92, 28, 51, 5, 69, 94, 3, 121, 92, 89, 79, 82, 76, 10, 88, 89, 23, 83, 95, 84, 92, 28, 2, 16, 69, 68, 81, 87, 67, 76, 92, 28, 33, 5, 66, 95, 91, 115, 95, 84, 92, 114, 23, 16, 67, 95, 90, 64, 66, 93, 74, 8, 74, 40, 91, 87, 78, 84, 25, 86, 80, 92, 76, 2, 88, 90, 93, 26, 112, 81, 85, 86, 53, 13, 66, 95, 76, 103, 83, 75, 76, 95, 23, 95}, "6856893cd1", 0.0f), 0);
        this.$stack = arrayList;
        this.$copyAction = function3;
        this.$this_copyToRecursively = path;
        this.$target = path2;
        this.$normalizedTarget = path3;
        this.$onError = function4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final FileVisitResult invoke(Path path, BasicFileAttributes basicFileAttributes) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{17, 9}, "a99ab31dfed97d", 0.0f));
        Intrinsics.checkNotNullParameter(basicFileAttributes, C0000.decode(new byte[]{19, 82}, "ccde2bb4", false));
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(this.$stack, this.$copyAction, this.$this_copyToRecursively, this.$target, this.$normalizedTarget, this.$onError, path, basicFileAttributes);
    }
}
