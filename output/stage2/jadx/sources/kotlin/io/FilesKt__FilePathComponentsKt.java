package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¢\u0006\u0002\b\u0003\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0005H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0000\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u0013"}, d2 = {"getRootLength", "", "", "getRootLength$FilesKt__FilePathComponentsKt", "rootName", "Ljava/io/File;", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "isRooted", "", "(Ljava/io/File;)Z", "toComponents", "Lkotlin/io/FilePathComponents;", "subPath", "beginIndex", "endIndex", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt {
    public static final File getRoot(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{88, 17, 91, 88, 65, 90}, "de312da0"));
        return new File(FilesKt.getRootName(file));
    }

    public static final String getRootName(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{11, 77, 80, 80, 17, 88}, "7989bf0d", 0.0f));
        String path = file.getPath();
        String strDecode = C0000.decode(new byte[]{87, 1, 16, 52, 88, 16, 95, 31, 31, 24, 30, 77}, "0ddd9d7716", 5);
        Intrinsics.checkNotNullExpressionValue(path, strDecode);
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, strDecode);
        String strSubstring = path.substring(0, getRootLength$FilesKt__FilePathComponentsKt(path2));
        Intrinsics.checkNotNullExpressionValue(strSubstring, C0000.decode(new byte[]{64, 22, 87, 74, 70, 66, 91, 87, 6, 31, 25, 79, 22, 31}, "3c592029a77a8632", 1));
        return strSubstring;
    }

    public static final boolean isRooted(File file) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{94, 23, 91, 92, 16, 6}, "bc35c8", false));
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, C0000.decode(new byte[]{83, 1, 68, 53, 80, 16, 13, 25, 72, 30, 72, 72}, "4d0e1de1f0fa61", 0.0f));
        return getRootLength$FilesKt__FilePathComponentsKt(path) > 0;
    }

    public static final File subPath(File file, int i, int i2) {
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{94, 21, 88, 15, 66, 12}, "ba0f12d2"));
        return FilesKt.toComponents(file).subPath(i, i2);
    }

    public static final FilePathComponents toComponents(File file) {
        ArrayList arrayListEmptyList;
        Intrinsics.checkNotNullParameter(file, C0000.decode(new byte[]{90, 23, 90, 94, 74, 92}, "fc279b766097", true));
        String path = file.getPath();
        Intrinsics.checkNotNull(path);
        int rootLength$FilesKt__FilePathComponentsKt = getRootLength$FilesKt__FilePathComponentsKt(path);
        String strSubstring = path.substring(0, rootLength$FilesKt__FilePathComponentsKt);
        String strDecode = C0000.decode(new byte[]{23, 68, 6, 17, 16, 17, 15, 15, 1, 16, 74, 31, 74, 75}, "d1dbdcfaf8", 0.0f);
        Intrinsics.checkNotNullExpressionValue(strSubstring, strDecode);
        String strSubstring2 = path.substring(rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, strDecode);
        String str = strSubstring2;
        if (str.length() == 0) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            List listSplit$default = StringsKt.split$default((CharSequence) str, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            arrayListEmptyList = arrayList;
        }
        return new FilePathComponents(new File(strSubstring), arrayListEmptyList);
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String str) {
        int iIndexOf$default;
        String str2 = str;
        int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, File.separatorChar, 0, false, 4, (Object) null);
        if (iIndexOf$default2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != File.separatorChar || (iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, File.separatorChar, 2, false, 4, (Object) null)) < 0) {
                return 1;
            }
            int iIndexOf$default3 = StringsKt.indexOf$default((CharSequence) str2, File.separatorChar, iIndexOf$default + 1, false, 4, (Object) null);
            return iIndexOf$default3 >= 0 ? iIndexOf$default3 + 1 : str.length();
        }
        if (iIndexOf$default2 > 0 && str.charAt(iIndexOf$default2 - 1) == ':') {
            return iIndexOf$default2 + 1;
        }
        if (iIndexOf$default2 == -1 && StringsKt.endsWith$default((CharSequence) str2, ':', false, 2, (Object) null)) {
            return str.length();
        }
        return 0;
    }
}
