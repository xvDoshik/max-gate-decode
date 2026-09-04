package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "<init>", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PathRelativizer {
    public static final PathRelativizer INSTANCE = new PathRelativizer();
    private static final Path emptyPath = Paths.get("", new String[0]);
    private static final Path parentPath = Paths.get(C0000.decode(new byte[]{28, 75}, "2e5f57", 0.0f), new String[0]);

    public final Path tryRelativeTo(Path path, Path base) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{72, 85, 23, 81}, "84c97952"));
        Intrinsics.checkNotNullParameter(base, C0000.decode(new byte[]{81, 86, 21, 93}, "37f837", true));
        Path pathNormalize = base.normalize();
        Path pathNormalize2 = path.normalize();
        Path pathRelativize = pathNormalize.relativize(pathNormalize2);
        int iMin = Math.min(pathNormalize.getNameCount(), pathNormalize2.getNameCount());
        for (int i = 0; i < iMin; i++) {
            Path name = pathNormalize.getName(i);
            Path path2 = parentPath;
            if (!Intrinsics.areEqual(name, path2)) {
                break;
            }
            if (!Intrinsics.areEqual(pathNormalize2.getName(i), path2)) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{103, 86, 85, 6, 90, 84, 65, 70, 91, 17, 6, 93, 95, 72, 65, 16, 83, 17, 19, 87, 88, 80, 17, 91, 68, 93, 20, 20, 87, 69, 9}, "284d61a241e2", 0.0f));
            }
        }
        if (Intrinsics.areEqual(pathNormalize2, pathNormalize) || !Intrinsics.areEqual(pathNormalize, emptyPath)) {
            String string = pathRelativize.toString();
            String separator = pathRelativize.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, C0000.decode(new byte[]{5, 1, 21, 107, 86, 72, 7, 16, 88, 23, 9, 71, 73, 24, 74, 75, 75}, "bda838fb9cf5a6de", true));
            pathNormalize2 = StringsKt.endsWith$default(string, separator, false, 2, (Object) null) ? pathRelativize.getFileSystem().getPath(StringsKt.dropLast(string, pathRelativize.getFileSystem().getSeparator().length()), new String[0]) : pathRelativize;
        }
        Intrinsics.checkNotNull(pathNormalize2);
        return pathNormalize2;
    }

    private PathRelativizer() {
    }
}
