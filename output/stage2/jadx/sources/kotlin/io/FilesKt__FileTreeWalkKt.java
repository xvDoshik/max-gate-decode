package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lkotlin/io/FileWalkDirection;", "walkTopDown", "walkBottomUp", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public static final FileTreeWalk walk(File file, FileWalkDirection fileWalkDirection) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{90, 67, 12, 95, 68, 14}, "f7d6703b6720d5"));
        Intrinsics.checkNotNullParameter(fileWalkDirection, C0000.decode(new byte[]{85, 94, 19, 3, 90, 70, 88, 88, 15}, "17af92", 4));
        return new FileTreeWalk(file, fileWalkDirection);
    }

    public static final FileTreeWalk walkBottomUp(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{12, 16, 90, 94, 17, 92}, "0d27bb91c771ca", false));
        return FilesKt.walk(file, FileWalkDirection.BOTTOM_UP);
    }

    public static final FileTreeWalk walkTopDown(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{90, 67, 89, 92, 71, 90}, "f7154d0016", false));
        return FilesKt.walk(file, FileWalkDirection.TOP_DOWN);
    }

    public static /* synthetic */ FileTreeWalk walk$default(File file, FileWalkDirection fileWalkDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return FilesKt.walk(file, fileWalkDirection);
    }
}
