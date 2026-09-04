package kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lkotlin/io/path/DefaultCopyActionContext;", "Lkotlin/io/path/CopyActionContext;", "<init>", "()V", "copyToIgnoringExistingDirectory", "Lkotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", "target", "followLinks", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DefaultCopyActionContext implements CopyActionContext {
    public static final DefaultCopyActionContext INSTANCE = new DefaultCopyActionContext();

    @Override // kotlin.io.path.CopyActionContext
    public CopyActionResult copyToIgnoringExistingDirectory(Path path, Path path2, boolean z) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{12, 70, 10, 95, 67, 93}, "02b60c88ef"));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{64, 80, 70, 80, 82, 21}, "41477a5051bf", false));
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(z);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) && Files.isDirectory(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            Unit unit = Unit.INSTANCE;
        } else {
            CopyOption[] copyOptionArr = (CopyOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
            Intrinsics.checkNotNullExpressionValue(Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), C0000.decode(new byte[]{5, 90, 66, 74, 29, 26, 72, 27, 28}, "f52354f557ad", true));
        }
        return CopyActionResult.CONTINUE;
    }

    private DefaultCopyActionContext() {
    }
}
