package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001By\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0016R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "onPreVisitDirectory", "Lkotlin/Function2;", "Ljava/nio/file/attribute/BasicFileAttributes;", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "onVisitFileFailed", "Ljava/io/IOException;", "onPostVisitDirectory", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "preVisitDirectory", "dir", "attrs", "visitFile", "file", "visitFileFailed", "exc", "postVisitDirectory", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FileVisitorImpl extends SimpleFileVisitor<Path> {
    private final Function2<Path, IOException, FileVisitResult> onPostVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onPreVisitDirectory;
    private final Function2<Path, BasicFileAttributes, FileVisitResult> onVisitFile;
    private final Function2<Path, IOException, FileVisitResult> onVisitFileFailed;

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        FileVisitResult fileVisitResultInvoke;
        Intrinsics.checkNotNullParameter(dir, C0000.decode(new byte[]{6, 90, 23}, "b3ead842ea5f2b", false));
        Function2<Path, IOException, FileVisitResult> function2 = this.onPostVisitDirectory;
        if (function2 != null && (fileVisitResultInvoke = function2.invoke(dir, exc)) != null) {
            return fileVisitResultInvoke;
        }
        FileVisitResult fileVisitResultPostVisitDirectory = super.postVisitDirectory(dir, exc);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultPostVisitDirectory, C0000.decode(new byte[]{67, 90, 23, 70, 101, 15, 68, 95, 66, 33, 93, 16, 6, 90, 71, 90, 22, 75, 27, 72, 25, 24, 31}, "35d23f766e4bc9", false));
        return fileVisitResultPostVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResultInvoke;
        Intrinsics.checkNotNullParameter(dir, C0000.decode(new byte[]{81, 89, 16}, "50bed8", false));
        Intrinsics.checkNotNullParameter(attrs, C0000.decode(new byte[]{84, 66, 64, 70, 21}, "5644f551", 6));
        Function2<Path, BasicFileAttributes, FileVisitResult> function2 = this.onPreVisitDirectory;
        if (function2 != null && (fileVisitResultInvoke = function2.invoke(dir, attrs)) != null) {
            return fileVisitResultInvoke;
        }
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultPreVisitDirectory, C0000.decode(new byte[]{64, 65, 93, 51, 12, 69, 91, 76, 39, 81, 66, 86, 91, 17, 10, 68, 75, 16, 77, 22, 30, 26}, "038ee628c8", false));
        return fileVisitResultPreVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileVisitResult fileVisitResultInvoke;
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{2, 10, 94, 84}, "dc21a92335", 0.0f));
        Intrinsics.checkNotNullParameter(attrs, C0000.decode(new byte[]{83, 22, 71, 19, 71}, "2b3a4a878752", 1));
        Function2<Path, BasicFileAttributes, FileVisitResult> function2 = this.onVisitFile;
        if (function2 != null && (fileVisitResultInvoke = function2.invoke(file, attrs)) != null) {
            return fileVisitResultInvoke;
        }
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultVisitFile, C0000.decode(new byte[]{21, 10, 70, 12, 76, 36, 80, 88, 83, 74, 77, 77, 27, 76}, "cc5e8b946b"));
        return fileVisitResultVisitFile;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        FileVisitResult fileVisitResultInvoke;
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{83, 93, 95, 93}, "5438d962", false));
        Intrinsics.checkNotNullParameter(exc, C0000.decode(new byte[]{4, 27, 7}, "acd520cf1eea7b1e", 0.0f));
        Function2<Path, IOException, FileVisitResult> function2 = this.onVisitFileFailed;
        if (function2 != null && (fileVisitResultInvoke = function2.invoke(file, exc)) != null) {
            return fileVisitResultInvoke;
        }
        FileVisitResult fileVisitResultVisitFileFailed = super.visitFileFailed(file, exc);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultVisitFileFailed, C0000.decode(new byte[]{68, 90, 66, 90, 65, 32, 92, 92, 1, 113, 83, 90, 93, 86, 81, 78, 27, 30, 74, 30}, "23135f50d7", false));
        return fileVisitResultVisitFileFailed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileVisitorImpl(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2, Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function3, Function2<? super Path, ? super IOException, ? extends FileVisitResult> function4, Function2<? super Path, ? super IOException, ? extends FileVisitResult> function5) {
        this.onPreVisitDirectory = function2;
        this.onVisitFile = function3;
        this.onVisitFileFailed = function4;
        this.onPostVisitDirectory = function5;
    }
}
