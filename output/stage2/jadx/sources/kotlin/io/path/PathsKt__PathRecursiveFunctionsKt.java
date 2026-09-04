package kotlin.io.path;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u001aw\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012Q\b\u0002\u0010\u0003\u001aK\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u00150\bj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007\u001a´\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012Q\b\u0002\u0010\u0003\u001aK\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u00150\bj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2C\b\u0002\u0010\u000f\u001a=\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\u0002\b\u0012H\u0007\u001a\u0011\u0010\u0013\u001a\u00020\u0014*\u00020\u0011H\u0003¢\u0006\u0002\b\u0015\u001a\u0011\u0010\u0013\u001a\u00020\u0014*\u00020\u000bH\u0003¢\u0006\u0002\b\u0015\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0007\u001a\u001b\u0010\u0018\u001a\f\u0012\b\u0012\u00060\bj\u0002`\n0\u0019*\u00020\u0001H\u0002¢\u0006\u0002\b\u001a\u001a$\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fH\u0082\b¢\u0006\u0002\b \u001a&\u0010!\u001a\u0004\u0018\u0001H\"\"\u0004\b\u0000\u0010\"2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\"0\u001fH\u0082\b¢\u0006\u0004\b#\u0010$\u001a1\u0010%\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\b(\u001a'\u0010)\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\b*\u001a5\u0010+\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010,\u001a\u00020\u00012\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0.\"\u00020/H\u0002¢\u0006\u0004\b0\u00101\u001a'\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\b4\u001a\u001d\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\b7\u001a\f\u00108\u001a\u00020\u0017*\u00020\u0001H\u0000\u001a\u0019\u00109\u001a\u00020\u0017*\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002¢\u0006\u0002\b:¨\u0006;"}, d2 = {"copyToRecursively", "Ljava/nio/file/Path;", "target", "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "exception", "Lkotlin/Exception;", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "deleteRecursively", "", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "collectIfThrows", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "handleEntry", "Ljava/nio/file/SecureDirectoryStream;", "parent", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "insecureHandleEntry", "entry", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "checkFileName", "checkNotSameAs", "checkNotSameAs$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    /* JADX INFO: compiled from: PathRecursiveFunctions.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void checkFileName(Path path) throws IllegalFileNameException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{8, 23, 90, 93, 71, 8}, "4c2446", 2));
        String name = PathsKt.getName(path);
        int iHashCode = name.hashCode();
        if (iHashCode != 46) {
            if (iHashCode != 1518) {
                if (iHashCode != 45679) {
                    if (iHashCode != 45724) {
                        if (iHashCode != 1472) {
                            if (iHashCode != 1473 || !name.equals(C0000.decode(new byte[]{79, 77}, "ab14eb"))) {
                                return;
                            }
                        } else if (!name.equals(C0000.decode(new byte[]{72, 23}, "f9c400517cc470f6", 0.0f))) {
                            return;
                        }
                    } else if (!name.equals(C0000.decode(new byte[]{22, 30, 63}, "80c1d028", 7))) {
                        return;
                    }
                } else if (!name.equals(C0000.decode(new byte[]{27, 79, 74}, "5ae4bd12f65335"))) {
                    return;
                }
            } else if (!name.equals(C0000.decode(new byte[]{24, 58}, "6fdc1ecb31ef", 0.0f))) {
                return;
            }
        } else if (!name.equals(C0000.decode(new byte[]{31}, "1e553558", 1))) {
            return;
        }
        throw new IllegalFileNameException(path);
    }

    public static final Path copyToRecursively(final Path path, final Path path2, final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, boolean z, final Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function4) throws FileSystemException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{8, 64, 13, 88, 67, 6}, "44e108d66788"));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{17, 80, 69, 81, 83, 17}, "e1766e"));
        Intrinsics.checkNotNullParameter(function3, C0000.decode(new byte[]{92, 95, 39, 20, 17, 86, 67}, "31bfc9129794"));
        Intrinsics.checkNotNullParameter(function4, C0000.decode(new byte[]{86, 13, 69, 24, 36, 81, 66, 81, 9, 8}, "5b5ae268ff34d2"));
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(z);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (!Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            throw new NoSuchFileException(path.toString(), path2.toString(), C0000.decode(new byte[]{102, 88, 3, 68, 68, 87, 66, 20, 86, 86, 18, 95, 91, 92, 3, 68, 83, 87, 82, 21, 91, 20, 70, 25, 87, 72, 15, 23, 67, 22}, "20fd787f5329"));
        }
        boolean zStartsWith = false;
        if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (z || !Files.isSymbolicLink(path))) {
            boolean z2 = Files.exists(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !Files.isSymbolicLink(path2);
            if (!z2 || !Files.isSameFile(path, path2)) {
                if (Intrinsics.areEqual(path.getFileSystem(), path2.getFileSystem())) {
                    if (z2) {
                        zStartsWith = path2.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]));
                    } else {
                        Path parent = path2.getParent();
                        if (parent != null && Files.exists(parent, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && parent.toRealPath(new LinkOption[0]).startsWith(path.toRealPath(new LinkOption[0]))) {
                            zStartsWith = true;
                        }
                    }
                }
                if (zStartsWith) {
                    throw new FileSystemException(path.toString(), path2.toString(), C0000.decode(new byte[]{107, 86, 2, 70, 16, 71, 12, 69, 1, 92, 72, 17, 2, 92, 73, 74, 8, 93, 5, 20, 4, 19, 0, 89, 67, 84, 2, 71, 86, 65, 24, 19, 11, 90, 17, 92, 68, 89, 69, 66, 65, 64, 76, 81, 5, 90, 16, 81, 6, 71, 11, 66, 72, 17, 8, 64, 25, 67, 19, 92, 10, 93, 7, 90, 16, 85, 85, 31}, "93a3b4e3d011a3"));
                }
            }
        }
        final Path pathNormalize = path2.normalize();
        final ArrayList arrayList = new ArrayList();
        PathsKt.visitFileTree$default(path, 0, z, new Function1() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$6$PathsKt__PathRecursiveFunctionsKt(arrayList, function4, path, path2, pathNormalize, function3, (FileVisitorBuilder) obj);
            }
        }, 1, (Object) null);
        return path2;
    }

    public static final Path copyToRecursively(Path path, Path path2, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, final boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{12, 76, 89, 15, 21, 7}, "081ff9a524", 0.0f));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{65, 5, 69, 3, 3, 71}, "5d7df3"));
        Intrinsics.checkNotNullParameter(function3, C0000.decode(new byte[]{87, 92, 116, 19, 70, 88, 64}, "821a472d16", 0.0f));
        return z2 ? PathsKt.copyToRecursively(path, path2, function3, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(z, (CopyActionContext) obj, (Path) obj2, (Path) obj3);
            }
        }) : PathsKt.copyToRecursively$default(path, path2, function3, z, (Function3) null, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(ArrayList<Path> arrayList, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Path path3, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function4, Path path4, BasicFileAttributes basicFileAttributes) {
        try {
            if (!arrayList.isEmpty()) {
                PathsKt.checkFileName(path4);
                Object objLast = CollectionsKt.last((List<? extends Object>) arrayList);
                Intrinsics.checkNotNullExpressionValue(objLast, C0000.decode(new byte[]{95, 7, 67, 18, 76, 29, 74, 79, 74}, "3f0fd3dac5", 5));
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(path4, (Path) objLast);
            }
            return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(function3.invoke(DefaultCopyActionContext.INSTANCE, path4, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(path, path2, path3, path4)));
        } catch (Exception e) {
            return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function4, path, path2, path3, path4, e);
        }
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2, Path path3, Path path4) throws IllegalFileNameException {
        Path pathResolve = path2.resolve(PathsKt.relativeTo(path4, path).toString());
        if (!pathResolve.normalize().startsWith(path3)) {
            throw new IllegalFileNameException(path4, pathResolve, C0000.decode(new byte[]{116, 92, 18, 26, 10, 90, 84, 65, 83, 8, 91, 86, 17, 67, 23, 91, 19, 14, 64, 21, 68, 90, 6, 6, 67, 64, 91, 4, 21, 18, 71, 86, 1, 10, 5, 93, 86, 5, 21, 21, 86, 65, 5, 6, 23, 20, 87, 8, 71, 4, 84, 71, 13, 17, 26, 20, 90, 18, 21, 17, 69, 92, 10, 10, 1, 93, 71, 4, 81, 79, 23, 103, 10, 6, 67, 80, 90, 19, 80, 2, 67, 92, 16, 26, 67, 86, 86, 8, 91, 6, 23, 65, 7, 0, 22, 70, 64, 8, 67, 4, 91, 74, 66, 0, 12, 68, 90, 4, 81, 65, 90, 90, 5, 11, 23, 20, 80, 14, 91, 21, 86, 90, 12, 67, 2, 90, 19, 4, 91, 21, 69, 74, 66, 20, 10, 64, 91, 65, 84, 15, 23, 90, 14, 15, 6, 83, 82, 13, 21, 15, 86, 94, 7, 77}, "73bcc43a5a", true));
        }
        Intrinsics.checkNotNull(pathResolve);
        return pathResolve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyActionResult copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(boolean z, CopyActionContext copyActionContext, Path path, Path path2) {
        Intrinsics.checkNotNullParameter(copyActionContext, C0000.decode(new byte[]{64, 66, 93, 15, 64, 69, 91, 90, 73, 27, 96, 10, 102, 87, 7, 67, 71, 21, 90, 23, 93, 89, 64}, "d65f3a859b4e42", false));
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{74, 19, 5}, "9afb8389"));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{7, 71, 64}, "c4483a", 2));
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(z);
        boolean zIsDirectory = Files.isDirectory(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !zIsDirectory) {
            if (zIsDirectory) {
                PathsKt.deleteRecursively(path2);
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(linkOptions);
            spreadBuilder.add(StandardCopyOption.REPLACE_EXISTING);
            CopyOption[] copyOptionArr = (CopyOption[]) spreadBuilder.toArray(new CopyOption[spreadBuilder.size()]);
            Intrinsics.checkNotNullExpressionValue(Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), C0000.decode(new byte[]{5, 14, 19, 24, 28, 25, 22, 27, 28}, "faca478558"));
        }
        return CopyActionResult.CONTINUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CopyActionResult copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(boolean z, CopyActionContext copyActionContext, Path path, Path path2) {
        Intrinsics.checkNotNullParameter(copyActionContext, C0000.decode(new byte[]{4, 66, 14, 88, 65, 14}, "86f120703e94", 0.0f));
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{18, 22, 2}, "ada6e34044be0b", false));
        Intrinsics.checkNotNullParameter(path2, C0000.decode(new byte[]{7, 16, 70}, "cc28c0", true));
        return copyActionContext.copyToIgnoringExistingDirectory(path, path2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyToRecursively$lambda$6$PathsKt__PathRecursiveFunctionsKt(final ArrayList arrayList, final Function3 function3, final Path path, final Path path2, final Path path3, final Function3 function4, FileVisitorBuilder visitFileTree) {
        Intrinsics.checkNotNullParameter(visitFileTree, "$this$visitFileTree");
        visitFileTree.onPreVisitDirectory(new Function2() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$6$lambda$4$PathsKt__PathRecursiveFunctionsKt(arrayList, function3, path, path2, path3, function4, (Path) obj, (BasicFileAttributes) obj2);
            }
        });
        visitFileTree.onVisitFile(new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2(arrayList, function3, path, path2, path3, function4));
        visitFileTree.onVisitFileFailed(new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3(function4, path, path2, path3));
        visitFileTree.onPostVisitDirectory(new Function2() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$6$lambda$5$PathsKt__PathRecursiveFunctionsKt(arrayList, function4, path, path2, path3, (Path) obj, (IOException) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$lambda$6$lambda$4$PathsKt__PathRecursiveFunctionsKt(ArrayList arrayList, Function3 function3, Path path, Path path2, Path path3, Function3 function4, Path path4, BasicFileAttributes basicFileAttributes) {
        Intrinsics.checkNotNullParameter(path4, C0000.decode(new byte[]{85, 92, 68, 0, 85, 64, 88, 71, 64}, "156e64759eb0c5"));
        Intrinsics.checkNotNullParameter(basicFileAttributes, C0000.decode(new byte[]{2, 64, 17, 67, 94, 4, 23, 77, 87, 70}, "c4e17fb925ed"));
        FileVisitResult fileVisitResultCopyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt = copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(arrayList, function3, path, path2, path3, function4, path4, basicFileAttributes);
        if (fileVisitResultCopyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt == FileVisitResult.CONTINUE) {
            arrayList.add(path4);
        }
        return fileVisitResultCopyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$lambda$6$lambda$5$PathsKt__PathRecursiveFunctionsKt(ArrayList arrayList, Function3 function3, Path path, Path path2, Path path3, Path path4, IOException iOException) {
        Intrinsics.checkNotNullParameter(path4, C0000.decode(new byte[]{1, 95, 19, 82, 1, 70, 9, 16, 64}, "e6a7b2fb9a7030", false));
        CollectionsKt.removeLast(arrayList);
        return iOException == null ? FileVisitResult.CONTINUE : copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function3, path, path2, path3, path4, iOException);
    }

    public static final void deleteRecursively(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, C0000.decode(new byte[]{4, 69, 95, 8, 75, 10}, "817a84", 3));
        List<Exception> listDeleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(path);
        if (listDeleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt.isEmpty()) {
            return;
        }
        FileSystemException fileSystemException = new FileSystemException(C0000.decode(new byte[]{114, 88, 94, 84, 81, 87, 18, 70, 91, 25, 83, 93, 88, 86, 70, 87, 20, 86, 89, 93, 20, 92, 64, 18, 89, 86, 69, 93, 20, 85, 91, 94, 81, 74, 25, 24, 103, 86, 87, 18, 71, 76, 71, 72, 70, 86, 65, 65, 81, 93, 23, 93, 76, 80, 87, 66, 64, 80, 88, 86, 71, 19, 84, 93, 70, 25, 83, 93, 64, 82, 91, 94, 71, 23}, "49784322", false));
        Iterator<T> it = listDeleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(fileSystemException, (Exception) it.next());
        }
        throw fileSystemException;
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path path) throws IOException {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        boolean z = false;
        boolean z2 = true;
        ExceptionsCollector exceptionsCollector = new ExceptionsCollector(0, 1, null);
        Path parent = path.getParent();
        if (parent != null) {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable unused) {
                directoryStreamNewDirectoryStream = null;
            }
            if (directoryStreamNewDirectoryStream != null) {
                DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
                try {
                    DirectoryStream<Path> directoryStream2 = directoryStream;
                    if (directoryStream2 instanceof SecureDirectoryStream) {
                        exceptionsCollector.setPath(parent);
                        Path fileName = path.getFileName();
                        Intrinsics.checkNotNullExpressionValue(fileName, C0000.decode(new byte[]{83, 86, 67, 114, 90, 93, 81, 121, 2, 89, 81, 27, 25, 26, 29, 24}, "43743147c4", 2));
                        handleEntry$PathsKt__PathRecursiveFunctionsKt((SecureDirectoryStream) directoryStream2, fileName, null, exceptionsCollector);
                    } else {
                        z = true;
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(directoryStream, null);
                    z2 = z;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(directoryStream, th);
                        throw th2;
                    }
                }
            }
        }
        if (z2) {
            insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(path, null, exceptionsCollector);
        }
        return exceptionsCollector.getCollectedExceptions();
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path path, ExceptionsCollector exceptionsCollector) {
        SecureDirectoryStream<Path> secureDirectoryStreamNewDirectoryStream;
        try {
            try {
                secureDirectoryStreamNewDirectoryStream = secureDirectoryStream.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
            } catch (Exception e) {
                exceptionsCollector.collect(e);
                return;
            }
        } catch (NoSuchFileException unused) {
            secureDirectoryStreamNewDirectoryStream = null;
        }
        if (secureDirectoryStreamNewDirectoryStream != null) {
            SecureDirectoryStream<Path> secureDirectoryStream2 = secureDirectoryStreamNewDirectoryStream;
            try {
                SecureDirectoryStream<Path> secureDirectoryStream3 = secureDirectoryStream2;
                Iterator<Path> it = secureDirectoryStream3.iterator();
                Intrinsics.checkNotNullExpressionValue(it, C0000.decode(new byte[]{11, 70, 87, 17, 3, 76, 13, 64, 26, 77, 76, 22, 75}, "b22cb8", 0.0f));
                while (it.hasNext()) {
                    Path fileName = it.next().getFileName();
                    Intrinsics.checkNotNullExpressionValue(fileName, C0000.decode(new byte[]{4, 0, 69, 112, 81, 9, 87, ByteCompanionObject.MAX_VALUE, 83, 89, 92, 29, 77, 75, 31, 31}, "ce168e212495"));
                    handleEntry$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream3, fileName, exceptionsCollector.getPath(), exceptionsCollector);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(secureDirectoryStream2, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(secureDirectoryStream2, th);
                    throw th2;
                }
            }
        }
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path path, ExceptionsCollector exceptionsCollector) {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        try {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
            } catch (Exception e) {
                exceptionsCollector.collect(e);
                return;
            }
        } catch (NoSuchFileException unused) {
            directoryStreamNewDirectoryStream = null;
        }
        if (directoryStreamNewDirectoryStream != null) {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            try {
                Iterator<Path> it = directoryStream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, C0000.decode(new byte[]{93, 71, 84, 71, 5, 68, 91, 65, 25, 27, 74, 30, 29}, "4315d0", 2));
                while (it.hasNext()) {
                    Path next = it.next();
                    Intrinsics.checkNotNull(next);
                    insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(next, path, exceptionsCollector);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(directoryStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(directoryStream, th);
                    throw th2;
                }
            }
        }
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.copyToRecursively.1
                @Override // kotlin.jvm.functions.Function3
                public final Void invoke(Path path3, Path path4, Exception exc) throws Exception {
                    String strDecode = C0000.decode(new byte[]{14, 20, 90, 69, 21, 7, 82, 16, 78, 84, 17, 93}, "2a40fb6085cc16", 0.0f);
                    Intrinsics.checkNotNullParameter(path3, strDecode);
                    Intrinsics.checkNotNullParameter(path4, strDecode);
                    Intrinsics.checkNotNullParameter(exc, C0000.decode(new byte[]{86, 75, 82, 82, 18, 65, 81, 90, 87}, "3317b58597398c05", 5));
                    throw exc;
                }
            };
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, z2);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path path, Path path2, Function3 function3, final boolean z, Function3 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt.copyToRecursively.3
                @Override // kotlin.jvm.functions.Function3
                public final Void invoke(Path path3, Path path4, Exception exc) throws Exception {
                    String strDecode = C0000.decode(new byte[]{14, 76, 87, 67, 22, 7, 81, 67, 69, 3, 75, 10}, "2996eb5c3b945dc5", true);
                    Intrinsics.checkNotNullParameter(path3, strDecode);
                    Intrinsics.checkNotNullParameter(path4, strDecode);
                    Intrinsics.checkNotNullParameter(exc, C0000.decode(new byte[]{7, 64, 2, 7, 71, 71, 80, 95, 8}, "b8ab7390f036", 4));
                    throw exc;
                }
            };
        }
        if ((i & 8) != 0) {
            function4 = new Function3() { // from class: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(z, (CopyActionContext) obj2, (Path) obj3, (Path) obj4);
                }
            };
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) function4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3, Path path4, Exception exc) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(function3.invoke(path4, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(path, path2, path3, path4), exc));
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult copyActionResult) {
        int i = WhenMappings.$EnumSwitchMapping$0[copyActionResult.ordinal()];
        if (i == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i == 2) {
            return FileVisitResult.TERMINATE;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return FileVisitResult.SKIP_SUBTREE;
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult onErrorResult) {
        int i = WhenMappings.$EnumSwitchMapping$1[onErrorResult.ordinal()];
        if (i == 1) {
            return FileVisitResult.TERMINATE;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return FileVisitResult.SKIP_SUBTREE;
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector exceptionsCollector, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Exception e) {
            exceptionsCollector.collect(e);
        }
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> function0) {
        try {
            return function0.invoke();
        } catch (NoSuchFileException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0033 A[Catch: Exception -> 0x0039, NoSuchFileException -> 0x003d, TRY_LEAVE, TryCatch #0 {NoSuchFileException -> 0x003d, blocks: (B:9:0x002d, B:10:0x0033), top: B:18:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0020 A[Catch: Exception -> 0x0039, TRY_LEAVE, TryCatch #1 {Exception -> 0x0039, blocks: (B:4:0x0005, B:5:0x0012, B:7:0x0020, B:9:0x002d, B:10:0x0033), top: B:20:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x002d A[Catch: Exception -> 0x0039, NoSuchFileException -> 0x003d, TRY_ENTER, TryCatch #0 {NoSuchFileException -> 0x003d, blocks: (B:9:0x002d, B:10:0x0033), top: B:18:0x001e }] */
    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path path, Path path2, ExceptionsCollector exceptionsCollector) {
        int totalExceptions;
        exceptionsCollector.enterEntry(path);
        if (path2 != null) {
            try {
                Path path3 = exceptionsCollector.getPath();
                Intrinsics.checkNotNull(path3);
                PathsKt.checkFileName(path3);
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(path3, path2);
                try {
                    if (isDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
                        totalExceptions = exceptionsCollector.getTotalExceptions();
                        enterDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, exceptionsCollector);
                        if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                            secureDirectoryStream.deleteDirectory(path);
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        secureDirectoryStream.deleteFile(path);
                        Unit unit2 = Unit.INSTANCE;
                    }
                } catch (NoSuchFileException unused) {
                }
            } catch (Exception e) {
                exceptionsCollector.collect(e);
            }
        } else if (isDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, LinkOption.NOFOLLOW_LINKS)) {
            totalExceptions = exceptionsCollector.getTotalExceptions();
            enterDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, path, exceptionsCollector);
            if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                secureDirectoryStream.deleteDirectory(path);
                Unit unit3 = Unit.INSTANCE;
            }
        } else {
            secureDirectoryStream.deleteFile(path);
            Unit unit4 = Unit.INSTANCE;
        }
        exceptionsCollector.exitEntry(path);
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path path, LinkOption... linkOptionArr) {
        Boolean boolValueOf;
        try {
            boolValueOf = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(path, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException unused) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2, ExceptionsCollector exceptionsCollector) {
        if (path2 != null) {
            try {
                PathsKt.checkFileName(path);
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(path, path2);
            } catch (Exception e) {
                exceptionsCollector.collect(e);
                return;
            }
        }
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            int totalExceptions = exceptionsCollector.getTotalExceptions();
            insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(path, exceptionsCollector);
            if (totalExceptions == exceptionsCollector.getTotalExceptions()) {
                Files.deleteIfExists(path);
                return;
            }
            return;
        }
        Files.deleteIfExists(path);
    }

    private static final void checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(Path path, Path path2) throws FileSystemLoopException {
        if (!Files.isSymbolicLink(path) && Files.isSameFile(path, path2)) {
            throw new FileSystemLoopException(path.toString());
        }
    }
}
