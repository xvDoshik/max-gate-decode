package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0007\u001a\u0012\u0010\u000e\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u0003*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\b\u0014\u001a&\u0010\u0015\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a8\u0010\u001b\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001a\b\u0002\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d\u001a\n\u0010 \u001a\u00020\u0018*\u00020\u0001\u001a\u0012\u0010!\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001\u001a\u0012\u0010!\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0003\u001a\u0012\u0010#\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001\u001a\u0012\u0010#\u001a\u00020\u0018*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0003\u001a\n\u0010$\u001a\u00020\u0001*\u00020\u0001\u001a\u0011\u0010$\u001a\u00020%*\u00020%H\u0002¢\u0006\u0002\b&\u001a\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010'*\b\u0012\u0004\u0012\u00020\u00010'H\u0002¢\u0006\u0002\b&\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0003\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0001\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u00012\u0006\u0010)\u001a\u00020\u0003\"\u0015\u0010\u0007\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u0015\u0010\f\u001a\u00020\u0003*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006+"}, d2 = {"createTempDir", "Ljava/io/File;", "prefix", "", "suffix", "directory", "createTempFile", "extension", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "toRelativeString", "base", "relativeTo", "relativeToOrSelf", "relativeToOrNull", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "copyTo", "target", "overwrite", "", "bufferSize", "", "copyRecursively", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "deleteRecursively", "startsWith", "other", "endsWith", "normalize", "Lkotlin/io/FilePathComponents;", "normalize$FilesKt__UtilsKt", "", "resolve", "relative", "resolveSibling", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyRecursively$lambda$4$FilesKt__UtilsKt(Function2 function2, File file, IOException iOException) throws TerminateException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{81}, "7d28cd5031", 6));
        Intrinsics.checkNotNullParameter(iOException, C0000.decode(new byte[]{3}, "f3a9fc46ad", false));
        if (function2.invoke(file, iOException) != OnErrorAction.TERMINATE) {
            return Unit.INSTANCE;
        }
        throw new TerminateException(file);
    }

    public static final File copyTo(File file, File file2, boolean z, int i) throws IOException {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{4, 23, 93, 95, 69, 6}, "8c5668583d", 2));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{17, 80, 19, 82, 81, 23}, "e1a54ce4111520bc"));
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, C0000.decode(new byte[]{53, 13, 86, 24, 21, 86, 20, 23, 80, 93, 70, 95, 8, 9, 86, 24, 2, 86, 4, 22, 93, 31, 18, 25, 4, 29, 90, 75, 18, 23}, "ae38f9", 5), 2, null);
        }
        if (file2.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(file, file2, C0000.decode(new byte[]{100, 89, 93, 19, 93, 86, 64, 69, 89, 95, 89, 71, 80, 92, 93, 17, 86, 88, 84, 86, 25, 82, 95, 67, 85, 80, 92, 74, 25, 86, 75, 88, 67, 69, 75, 29}, "01839331", 6));
            }
            if (!file2.delete()) {
                throw new FileAlreadyExistsException(file, file2, C0000.decode(new byte[]{101, 64, 15, 86, 6, 20, 71, 86, 70, 13, 64, 93, 71, 68, 67, 91, 18, 86, 66, 64, 91, 92, 70, 6, 83, 75, 65, 90, 95, 83, 18, 90, 13, 90, 31, 25, 4, 23, 66, 24, 83, 82, 88, 94, 3, 87, 66, 64, 92, 25, 2, 7, 90, 93, 65, 86, 17, 91, 18, 29}, "12f3b439fb6853", true));
            }
        }
        if (file.isDirectory()) {
            if (file2.mkdirs()) {
                return file2;
            }
            throw new FileSystemException(file, file2, C0000.decode(new byte[]{35, 0, 89, 8, 85, 83, 17, 21, 92, 68, 6, 19, 85, 5, 68, 82, 17, 21, 82, 22, 2, 4, 68, 68, 84, 94, 67, 4, 80, 16, 10, 19, 73, 74}, "ea0d071a3d", 1));
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                long jCopyTo = ByteStreamsKt.copyTo(fileInputStream2, fileOutputStream, i);
                CloseableKt.closeFinally(fileOutputStream, null);
                Long.valueOf(jCopyTo);
                CloseableKt.closeFinally(fileInputStream, null);
                return file2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileInputStream, th3);
                throw th4;
            }
        }
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(String str, String str2, File file) throws IOException {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{18, 67, 85, 95, 95, 64}, "b10968c16395fae0", 0.0f));
        File fileCreateTempFile = File.createTempFile(str, str2, file);
        fileCreateTempFile.delete();
        if (!fileCreateTempFile.mkdir()) {
            throw new IOException(C0000.decode(new byte[]{100, 95, 4, 0, 14, 82, 20, 16, 92, 67, 80, 69, 84, 80, 17, 7, 66, 67, 81, 9, 67, 12, 65, 86, 67, 72, 69, 6, 11, 69, 81, 7, 71, 12, 65, 78, 17}, "11ebb74d3c37", 0.0f) + fileCreateTempFile + '.');
        }
        Intrinsics.checkNotNull(fileCreateTempFile);
        return fileCreateTempFile;
    }

    public static /* synthetic */ File createTempDir$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = C0000.decode(new byte[]{23, 85, 66}, "c82e868cf3");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return FilesKt.createTempDir(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(String str, String str2, File file) throws IOException {
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{22, 19, 3, 84, 91, 75}, "faf2231e78", 7));
        File fileCreateTempFile = File.createTempFile(str, str2, file);
        Intrinsics.checkNotNullExpressionValue(fileCreateTempFile, C0000.decode(new byte[]{1, 74, 82, 86, 68, 80, 96, 84, 92, 64, 36, 81, 91, 82, 24, 27, 26, 31, 24}, "b877054110"));
        return fileCreateTempFile;
    }

    public static /* synthetic */ File createTempFile$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = C0000.decode(new byte[]{69, 93, 65}, "1015326f36cebb20", 7);
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return FilesKt.createTempFile(str, str2, file);
    }

    public static final boolean deleteRecursively(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{8, 23, 12, 89, 75, 93}, "4cd08cf7129ce90a", 0.0f));
        while (true) {
            boolean z = true;
            for (File file2 : FilesKt.walkBottomUp(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z) {
                    }
                }
                z = false;
            }
            return z;
        }
    }

    public static final boolean endsWith(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{5, 23, 12, 94, 70, 7}, "9cd759", 0.0f));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{86, 68, 88, 80, 71}, "900550f5dd19be"));
        FilePathComponents components = FilesKt.toComponents(file);
        FilePathComponents components2 = FilesKt.toComponents(file2);
        if (components2.isRooted()) {
            return Intrinsics.areEqual(file, file2);
        }
        int size = components.getSize() - components2.getSize();
        if (size < 0) {
            return false;
        }
        return components.getSegments().subList(size, components.getSize()).equals(components2.getSegments());
    }

    public static final boolean endsWith(File file, String str) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{88, 67, 91, 89, 67, 90}, "d7300d967f30", 5));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{88, 17, 94, 87, 67}, "7e6211467d9b69ed", false));
        return FilesKt.endsWith(file, new File(str));
    }

    public static final String getExtension(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{10, 64, 13, 80, 67, 12}, "64e9027be1", false));
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, C0000.decode(new byte[]{4, 83, 64, 119, 84, 11, 6, 30, 26, 23, 27, 79}, "c6495f", true));
        return StringsKt.substringAfterLast(name, '.', "");
    }

    public static final String getInvariantSeparatorsPath(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{95, 23, 91, 12, 64, 92}, "cc3e3b74ca71", 2));
        char c = File.separatorChar;
        String strDecode = C0000.decode(new byte[]{84, 6, 16, 51, 85, 18, 95, 17, 31, 27, 76, 25}, "3cdc4f7915b072b0");
        if (c != '/') {
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, strDecode);
            return StringsKt.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, strDecode);
        return path2;
    }

    public static final String getNameWithoutExtension(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{15, 66, 94, 91, 64, 95}, "36623a2b99b8", 0.0f));
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, C0000.decode(new byte[]{81, 1, 17, 42, 4, 91, 80, 74, 74, 25, 30, 28}, "6dede65bd70560", true));
        return StringsKt.substringBeforeLast$default(name, C0000.decode(new byte[]{27}, "5c8d58bd0fb7"), (String) null, 2, (Object) null);
    }

    public static final File normalize(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{9, 76, 94, 8, 17, 8}, "586ab64d44e2"));
        FilePathComponents components = FilesKt.toComponents(file);
        File root = components.getRoot();
        List<File> listNormalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(components.getSegments());
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, C0000.decode(new byte[]{75, 83, 20, 89, 70, 83, 21, 11, 20}, "86d842adfa5d3d", 0.0f));
        return FilesKt.resolve(root, CollectionsKt.joinToString$default(listNormalize$FilesKt__UtilsKt, str, null, null, 0, null, null, 62, null));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!Intrinsics.areEqual(name, C0000.decode(new byte[]{77}, "caa9a20b", false))) {
                String strDecode = C0000.decode(new byte[]{74, 77}, "dc0cb1bea36c", 0.0f);
                if (!Intrinsics.areEqual(name, strDecode)) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || Intrinsics.areEqual(((File) CollectionsKt.last((List) arrayList)).getName(), strDecode)) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    public static final File relativeTo(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{11, 23, 80, 81, 67, 93}, "7c880c032b", 0.0f));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{82, 0, 66, 7}, "0a1b97c7", false));
        return new File(FilesKt.toRelativeString(file, file2));
    }

    public static final File relativeToOrNull(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{11, 68, 80, 91, 64, 91}, "70823eaefac2e478", 2));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{80, 84, 17, 81}, "25b4de", true));
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return new File(relativeStringOrNull$FilesKt__UtilsKt);
        }
        return null;
    }

    public static final File relativeToOrSelf(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{5, 21, 9, 90, 65, 92}, "9aa32b9ebbeb2e", 6));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{82, 85, 65, 92}, "0429ba80b8", 4));
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        return relativeStringOrNull$FilesKt__UtilsKt != null ? new File(relativeStringOrNull$FilesKt__UtilsKt) : file;
    }

    public static final File resolve(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{90, 21, 90, 15, 23, 11}, "fa2fd561c117", 2));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{17, 4, 94, 81, 17, 11, 19, 82}, "ca20ebe7067be918"));
        if (FilesKt.isRooted(file2)) {
            return file2;
        }
        String string = file.toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{76, 11, 48, 70, 64, 15, 90, 80, 31, 77, 28, 29, 76}, "8dc22f477c23e5", 5));
        String str = string;
        return (str.length() == 0 || StringsKt.endsWith$default((CharSequence) str, File.separatorChar, false, 2, (Object) null)) ? new File(string + file2) : new File(string + File.separatorChar + file2);
    }

    public static final File resolve(File file, String str) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{13, 67, 91, 13, 16, 88}, "173dcff16626fa8c"));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{64, 1, 9, 7, 70, 88, 70, 6}, "2def210cc77904"));
        return FilesKt.resolve(file, new File(str));
    }

    public static final File resolveSibling(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{15, 77, 90, 15, 69, 7}, "392f69", 0.0f));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{17, 84, 8, 89, 23, 95, 20, 93}, "c1d8c6b8adbb9e95"));
        FilePathComponents components = FilesKt.toComponents(file);
        return FilesKt.resolve(FilesKt.resolve(components.getRoot(), components.getSize() == 0 ? new File(C0000.decode(new byte[]{77, 22}, "c899d6cc6e74ec69", 0.0f)) : components.subPath(0, components.getSize() - 1)), file2);
    }

    public static final File resolveSibling(File file, String str) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{13, 17, 89, 88, 16, 93}, "1e11cc171dabdc58", true));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{70, 81, 88, 2, 77, 11, 66, 81}, "444c9b", 0.0f));
        return FilesKt.resolveSibling(file, new File(str));
    }

    public static final boolean startsWith(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{88, 70, 88, 80, 23, 93}, "d209dc", 5));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{11, 64, 93, 85, 64}, "d4502f", false));
        FilePathComponents components = FilesKt.toComponents(file);
        FilePathComponents components2 = FilesKt.toComponents(file2);
        if (Intrinsics.areEqual(components.getRoot(), components2.getRoot()) && components.getSize() >= components2.getSize()) {
            return components.getSegments().subList(0, components2.getSize()).equals(components2.getSegments());
        }
        return false;
    }

    public static final boolean startsWith(File file, String str) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{14, 66, 12, 91, 65, 91}, "26d22e9a", 2));
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 65, 81, 84, 68}, "0591647b", 2));
        return FilesKt.startsWith(file, new File(str));
    }

    public static final String toRelativeString(File file, File file2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{15, 23, 80, 12, 22, 90}, "3c8eed3bcfa538", 0.0f));
        Intrinsics.checkNotNullParameter(file2, C0000.decode(new byte[]{6, 83, 66, 93}, "d218c40a", 0.0f));
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt(file, file2);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{69, 91, 12, 69, 25, 88, 95, 87, 69, 84, 88, 74, 84, 19, 3, 95, 85, 92, 66, 19, 13, 87, 79, 92, 17, 87, 12, 80, 95, 92, 67, 86, 11, 66, 25, 75, 94, 92, 17, 69, 3, 25}, "13e699", 0) + file + C0000.decode(new byte[]{22, 80, 90, 7, 67}, "614cc7eb26b12c") + file2 + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File file, File file2) {
        FilePathComponents filePathComponentsNormalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt(FilesKt.toComponents(file));
        FilePathComponents filePathComponentsNormalize$FilesKt__UtilsKt2 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(file2));
        if (!Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt.getRoot(), filePathComponentsNormalize$FilesKt__UtilsKt2.getRoot())) {
            return null;
        }
        int size = filePathComponentsNormalize$FilesKt__UtilsKt2.getSize();
        int size2 = filePathComponentsNormalize$FilesKt__UtilsKt.getSize();
        int iMin = Math.min(size2, size);
        int i = 0;
        while (i < iMin && Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt.getSegments().get(i), filePathComponentsNormalize$FilesKt__UtilsKt2.getSegments().get(i))) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = size - 1;
        if (i <= i2) {
            while (!Intrinsics.areEqual(filePathComponentsNormalize$FilesKt__UtilsKt2.getSegments().get(i2).getName(), "..")) {
                sb.append("..");
                if (i2 != i) {
                    sb.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < size2) {
            if (i < size) {
                sb.append(File.separatorChar);
            }
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            CollectionsKt.joinTo(CollectionsKt.drop(filePathComponentsNormalize$FilesKt__UtilsKt.getSegments(), i), sb, (124 & 2) != 0 ? ", " : separator, (124 & 4) != 0 ? "" : null, (124 & 8) != 0 ? "" : null, (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        return sb.toString();
    }

    public static /* synthetic */ File copyTo$default(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = ConstantsKt.DEFAULT_BUFFER_SIZE;
        }
        return FilesKt.copyTo(file, file2, z, i);
    }

    public static /* synthetic */ boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function2 = new Function2() { // from class: kotlin.io.FilesKt__UtilsKt.copyRecursively.1
                @Override // kotlin.jvm.functions.Function2
                public final Void invoke(File file3, IOException iOException) throws IOException {
                    Intrinsics.checkNotNullParameter(file3, C0000.decode(new byte[]{8, 66, 93, 17, 69, 3, 85, 68, 66, 86, 65, 90}, "473d6f1d", false));
                    Intrinsics.checkNotNullParameter(iOException, C0000.decode(new byte[]{80, 72, 2, 81, 64, 16, 12, 14, 89}, "50a40dea7b2b002e", true));
                    throw iOException;
                }
            };
        }
        return FilesKt.copyRecursively(file, file2, z, function2);
    }

    public static final boolean copyRecursively(File file, File target, boolean z, final Function2<? super File, ? super IOException, ? extends OnErrorAction> onError) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(onError, "onError");
        if (!file.exists()) {
            return onError.invoke(file, new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            for (File file2 : FilesKt.walkTopDown(file).onFail(new Function2() { // from class: kotlin.io.FilesKt__UtilsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesKt__UtilsKt.copyRecursively$lambda$4$FilesKt__UtilsKt(onError, (File) obj, (IOException) obj2);
                }
            })) {
                if (!file2.exists()) {
                    if (onError.invoke(file2, new NoSuchFileException(file2, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                        return false;
                    }
                } else {
                    File file3 = new File(target, FilesKt.toRelativeString(file2, file));
                    if (file3.exists() && (!file2.isDirectory() || !file3.isDirectory())) {
                        if (z) {
                            if (file3.isDirectory()) {
                                if (!FilesKt.deleteRecursively(file3)) {
                                }
                            } else if (!file3.delete()) {
                            }
                        }
                        if (onError.invoke(file3, new FileAlreadyExistsException(file2, file3, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                    }
                    if (file2.isDirectory()) {
                        file3.mkdirs();
                    } else {
                        boolean z2 = z;
                        if (FilesKt.copyTo$default(file2, file3, z2, 0, 4, null).length() != file2.length() && onError.invoke(file2, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                        z = z2;
                    }
                }
            }
            return true;
        } catch (TerminateException unused) {
            return false;
        }
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents filePathComponents) {
        return new FilePathComponents(filePathComponents.getRoot(), normalize$FilesKt__UtilsKt(filePathComponents.getSegments()));
    }
}
