package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class FileProvider extends ContentProvider {
    private String mAuthority;
    private PathStrategy mLocalPathStrategy;
    private int mResourceId;
    private static final String ATTR_NAME = C0000.decode(new byte[]{93, 86, 92, 80}, "3715d6f4bcc4d5b9");
    private static final String ATTR_PATH = C0000.decode(new byte[]{18, 85, 17, 10}, "b4eb50fb25");
    private static final String DISPLAYNAME_FIELD = C0000.decode(new byte[]{82, 12, 75, 64, 88, 84, 29, 125, 3, 9, 82}, "6e8045d3bd74ca5c", false);
    private static final String META_DATA_FILE_PROVIDER_PATHS = C0000.decode(new byte[]{83, 11, 2, 75, 89, 10, 86, 75, 21, 76, 70, 19, 93, 23, 18, 23, 112, 42, 126, 32, 57, 105, 100, 44, 100, 44, 34, 124, 100, 60, 98, 36, 50, 113, 101}, "2ef96c", 0.0f);
    private static final String TAG_CACHE_PATH = C0000.decode(new byte[]{90, 3, 2, 80, 80, 24, 19, 82, 16, 89}, "9ba855c3d1ca", true);
    private static final String TAG_EXTERNAL = C0000.decode(new byte[]{0, 25, 66, 82, 75, 94, 86, 95, 31, 64, 87, 69, 13}, "ea6790732061");
    private static final String TAG_EXTERNAL_CACHE = C0000.decode(new byte[]{80, 25, 66, 85, 74, 92, 80, 90, 29, 1, 81, 5, 88, 87, 28, 67, 84, 21, 94}, "5a6082160b0f0213", 0.0f);
    private static final String TAG_EXTERNAL_FILES = C0000.decode(new byte[]{0, 78, 70, 87, 65, 91, 88, 8, 30, 95, 95, 90, 0, 69, 31, 66, 82, 65, 81}, "e622359d3966", false);
    private static final String TAG_EXTERNAL_MEDIA = C0000.decode(new byte[]{86, 27, 69, 7, 67, 94, 82, 15, 28, 15, 84, 84, 90, 2, 28, 18, 80, 68, 91}, "3c1b10");
    private static final String TAG_FILES_PATH = C0000.decode(new byte[]{81, 93, 14, 80, 17, 26, 70, 85, 66, 89}, "74b5b76461", false);
    private static final String TAG_ROOT_PATH = C0000.decode(new byte[]{71, 86, 93, 65, 30, 20, 83, 70, 89}, "59253d221d1e660f", 0.0f);
    private static final String[] COLUMNS = {C0000.decode(new byte[]{108, 85, 91, 16, 66, 92, 82, 72, 109, 13, 83, 93, 86}, "312c20", false), C0000.decode(new byte[]{110, 70, 81, 66, 82}, "158870cff7967da1", 7)};
    private static final File DEVICE_ROOT = new File(C0000.decode(new byte[]{75}, "d63d319bee", 4));
    private static final HashMap<String, PathStrategy> sCache = new HashMap<>();

    public abstract class Api21Impl {
        public static File[] getExternalMediaDirs(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    public interface PathStrategy {
    }

    public final class SimplePathStrategy implements PathStrategy {
        public final String mAuthority;
        public final HashMap mRoots = new HashMap();

        public SimplePathStrategy(String str) {
            this.mAuthority = str;
        }

        public final File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = (File) this.mRoots.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{96, 11, 84, 0, 13, 92, 24, 77, 94, 20, 83, 12, 91, 6, 65, 90, 87, 87, 87, 93, 82, 16, 71, 7, 5, 25, 74, 86, 94, 64, 21, 3, 90, 16, 65}, "5e5ba98914", true) + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException(C0000.decode(new byte[]{97, 84, 68, 94, 9, 78, 85, 81, 19, 71, 89, 65, 89, 70, 89, 68, 90, 65, 0, 92, 16, 87, 86, 78, 87, 91, 85, 70, 80, 94, 89, 87, 12, 95, 69, 71, 86, 83, 24, 71, 94, 9, 71}, "3171e80537851f", 0.0f));
            } catch (IOException unused) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{116, 0, 91, 85, 87, 93, 18, 69, 93, 23, 23, 84, 21, 95, 94, 23, 87, 25, 81, 88, 92, 94, 92, 94, 6, 80, 10, 16, 66, 0, 70, 81, 18, 95, 93, 67, 18}, "2a29292127e1f0") + file2);
            }
        }
    }

    public FileProvider() {
        this.mResourceId = 0;
    }

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] copyOf(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    public static XmlResourceParser getFileProviderPathsMetaData(Context context, String str, ProviderInfo providerInfo, int i) {
        if (providerInfo == null) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{34, 11, 20, 91, 83, 92, 65, 22, 24, 82, 80, 13, 5, 68, 12, 82, 67, 83, 75, 6, 89, 64, 88, 67, 7, 11, 19, 23, 71, 64, 9, 20, 81, 80, 92, 17, 65, 19, 8, 67, 95, 18, 7, 23, 76, 92, 86, 17, 8, 16, 24, 23}, "ada772fb849c") + str);
        }
        Bundle bundle = providerInfo.metaData;
        String strDecode = C0000.decode(new byte[]{4, 89, 2, 71, 11, 80, 92, 22, 75, 19, 21, 71, 9, 71, 16, 23, 126, 113, 116, 35, 58, 103, 52, 122, 50, 112, 124, 125, 106, 57, 53, 118, 50, 125, 55}, "e7f5d9888f", 0.0f);
        if (bundle == null && i != 0) {
            Bundle bundle2 = new Bundle(1);
            providerInfo.metaData = bundle2;
            bundle2.putInt(strDecode, i);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), strDecode);
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{117, 88, 67, 65, 91, 91, 1, 68, 89, 87, 92, 22, 87, 88, 84, 28, 65, 64, 22, 20, 87, 75, 76, 74, 126, 120, 124, 119, 109, 101, 52, 43, 110, 112, 124, 33, 106, 110, 96, 115, 102, 125, 53, 68, 85, 92, 76, 5, 21, 85, 81, 70, 83}, "810225fd898d", 0.0f));
    }

    private PathStrategy getLocalPathStrategy() {
        PathStrategy pathStrategy;
        synchronized (this) {
            try {
                if (this.mLocalPathStrategy == null) {
                    this.mLocalPathStrategy = getPathStrategy(getContext(), this.mAuthority, this.mResourceId);
                }
                pathStrategy = this.mLocalPathStrategy;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pathStrategy;
    }

    private static PathStrategy getPathStrategy(Context context, String str, int i) {
        PathStrategy pathStrategy;
        HashMap<String, PathStrategy> map = sCache;
        synchronized (map) {
            try {
                pathStrategy = map.get(str);
                if (pathStrategy == null) {
                    try {
                        try {
                            pathStrategy = parsePathStrategy(context, str, i);
                            map.put(str, pathStrategy);
                        } catch (IOException e) {
                            throw new IllegalArgumentException(C0000.decode(new byte[]{112, 84, 89, 85, 4, 85, 69, 70, 12, 22, 71, 83, 68, 70, 85, 25, 0, 95, 1, 64, 12, 95, 83, 28, 69, 64, 64, 73, 14, 67, 17, 28, 37, 127, 123, 119, 105, 101, 98, 118, 55, 120, 33, 119, 49, 105, 103, 115, 98, 125, 99, 25, 12, 84, 17, 83, 78, 82, 86, 70, 87}, "6509a1e2c672", 0.0f), e);
                        }
                    } catch (XmlPullParserException e2) {
                        throw new IllegalArgumentException(C0000.decode(new byte[]{117, 2, 95, 95, 85, 92, 20, 66, 10, 70, 67, 2, 68, 64, 85, 24, 85, 88, 1, 20, 92, 10, 82, 29, 67, 77, 68, 70, 10, 20, 71, 77, 112, 122, 124, 125, 107, 102, 55, 41, 101, 42, 114, 118, 98, 103, 100, 119, 49, 46, 96, 67, 91, 86, 68, 89, 25, 82, 4, 18, 82}, "3c630846ef", 0.0f), e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return pathStrategy;
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        SimplePathStrategy simplePathStrategy = (SimplePathStrategy) getPathStrategy(context, str, 0);
        simplePathStrategy.getClass();
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : simplePathStrategy.mRoots.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{115, 86, 93, 15, 4, 84, 17, 76, 12, 22, 84, 15, 87, 81, 24, 84, 90, 89, 82, 10, 6, 69, 67, 93, 7, 22, 64, 9, 86, 65, 24, 67, 93, 86, 64, 67, 2, 95, 95, 76, 2, 95, 92, 21, 25}, "574ca018c62f9587", 5) + canonicalPath);
            }
            String path2 = ((File) entry.getValue()).getPath();
            String strDecode = C0000.decode(new byte[]{30}, "125aa97a55", true);
            return new Uri.Builder().scheme(C0000.decode(new byte[]{82, 94, 10, 69, 81, 10, 17}, "11d14de17d608520", 0.0f)).authority(simplePathStrategy.mAuthority).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith(strDecode) ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), strDecode)).build();
        } catch (IOException unused) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{117, 81, 93, 14, 83, 80, 23, 18, 11, 16, 65, 85, 71, 13, 90, 66, 82, 70, 7, 81, 93, 95, 90, 11, 85, 85, 91, 70, 20, 81, 71, 88, 20, 4, 89, 70, 23}, "304b647fd0", true) + file);
        }
    }

    @SuppressLint({"StreamFiles"})
    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter(C0000.decode(new byte[]{92, 89, 66, 73, 94, 2, 79, 120, 89, 93, 84}, "80192c66", 1), str2).build();
    }

    private static int modeToMode(String str) {
        if (C0000.decode(new byte[]{64}, "2d8dec234861dd77", true).equals(str)) {
            return 268435456;
        }
        if (C0000.decode(new byte[]{22}, "a2800196", false).equals(str) || C0000.decode(new byte[]{20, 69}, "c1ec565ac5", 4).equals(str)) {
            return 738197504;
        }
        if (C0000.decode(new byte[]{18, 4}, "ee87fd3a", 0.0f).equals(str)) {
            return 704643072;
        }
        if (C0000.decode(new byte[]{22, 66}, "d5b574", 0.0f).equals(str)) {
            return 939524096;
        }
        if (C0000.decode(new byte[]{20, 17, 67}, "ff77c6da26c4").equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{42, 11, 19, 2, 85, 10, 83, 18, 93, 9, 7, 0, 95, 67}, "ceec9c720f", true) + str);
    }

    private static PathStrategy parsePathStrategy(Context context, String str, int i) throws XmlPullParserException, IOException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        XmlResourceParser fileProviderPathsMetaData = getFileProviderPathsMetaData(context, str, context.getPackageManager().resolveContentProvider(str, 128), i);
        while (true) {
            int next = fileProviderPathsMetaData.next();
            if (next == 1) {
                return simplePathStrategy;
            }
            if (next == 2) {
                String name = fileProviderPathsMetaData.getName();
                File externalStorageDirectory = null;
                String attributeValue = fileProviderPathsMetaData.getAttributeValue(null, C0000.decode(new byte[]{92, 0, 8, 82}, "2ae7b5e86691", true));
                String attributeValue2 = fileProviderPathsMetaData.getAttributeValue(null, C0000.decode(new byte[]{70, 7, 17, 12}, "6fedabf8d4eb23f6", 2));
                if (C0000.decode(new byte[]{69, 89, 89, 17, 28, 71, 5, 16, 81}, "766e17dd940e").equals(name)) {
                    externalStorageDirectory = DEVICE_ROOT;
                } else if (C0000.decode(new byte[]{2, 8, 14, 4, 66, 25, 66, 84, 67, 91}, "daba142573f0ace3", 0.0f).equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if (C0000.decode(new byte[]{80, 83, 2, 81, 84, 76, 18, 89, 67, 11}, "32a91ab87c").equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if (C0000.decode(new byte[]{86, 74, 70, 0, 65, 12, 82, 8, 29, 70, 7, 23, 91}, "322e3b3d06fc", false).equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if (C0000.decode(new byte[]{82, 29, 18, 83, 23, 87, 86, 9, 75, 80, 12, 85, 82, 22, 75, 70, 4, 77, 95}, "7ef6e9", 0.0f).equals(name)) {
                    File[] externalFilesDirs = ContextCompat$Api19Impl.getExternalFilesDirs(context, null);
                    if (externalFilesDirs.length > 0) {
                        externalStorageDirectory = externalFilesDirs[0];
                    }
                } else if (C0000.decode(new byte[]{3, 26, 23, 82, 68, 10, 0, 89, 27, 85, 80, 6, 93, 82, 75, 18, 2, 67, 94}, "fbc76da5661e57").equals(name)) {
                    File[] externalCacheDirs = ContextCompat$Api19Impl.getExternalCacheDirs(context);
                    if (externalCacheDirs.length > 0) {
                        externalStorageDirectory = externalCacheDirs[0];
                    }
                } else if (C0000.decode(new byte[]{93, 64, 64, 4, 71, 13, 82, 94, 30, 92, 85, 84, 89, 83, 31, 69, 89, 76, 92}, "884a5c3231000225", 0.0f).equals(name)) {
                    File[] externalMediaDirs = Api21Impl.getExternalMediaDirs(context);
                    if (externalMediaDirs.length > 0) {
                        externalStorageDirectory = externalMediaDirs[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    File fileBuildPath = buildPath(externalStorageDirectory, attributeValue2);
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException(C0000.decode(new byte[]{118, 4, 9, 6, 17, 88, 66, 67, 77, 21, 8, 95, 76, 69, 6, 6, 17, 80, 90, 64, 77, 76}, "8edc157095f0", true));
                    }
                    try {
                        simplePathStrategy.mRoots.put(attributeValue, fileBuildPath.getCanonicalFile());
                    } catch (IOException e) {
                        throw new IllegalArgumentException(C0000.decode(new byte[]{39, 83, 80, 9, 1, 5, 67, 77, 88, 17, 19, 87, 74, 10, 8, 23, 6, 25, 84, 80, 15, 93, 87, 12, 7, 0, 15, 25, 71, 80, 21, 90, 25, 3, 11, 19, 67}, "a29edac971", 0.0f) + fileBuildPath, e);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException(C0000.decode(new byte[]{50, 19, 93, 66, 13, 82, 0, 20, 69, 12, 66, 74, 18, 21, 91, 14, 22, 65, 80, 81, 68, 83, 29, 22, 10, 19, 67, 92, 2}, "ba24d6efea79f55a"));
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException(C0000.decode(new byte[]{99, 64, 94, 20, 81, 2, 82, 17, 19, 95, 68, 17, 76, 70, 80, 17, 82, 92, 69, 66, 77, 20, 94, 67, 67, 87, 67, 15, 81, 21, 68, 10, 92, 92, 66}, "321b8f7c"));
        }
        this.mAuthority = providerInfo.authority.split(C0000.decode(new byte[]{11}, "0d48fd0f4b1c", false))[0];
        HashMap<String, PathStrategy> map = sCache;
        synchronized (map) {
            map.remove(this.mAuthority);
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return ((SimplePathStrategy) getLocalPathStrategy()).getFileForUri(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileForUri = ((SimplePathStrategy) getLocalPathStrategy()).getFileForUri(uri);
        int iLastIndexOf = fileForUri.getName().lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(iLastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return C0000.decode(new byte[]{4, 68, 71, 8, 12, 85, 4, 64, 94, 11, 11, 25, 10, 87, 67, 1, 17, 27, 22, 64, 69, 1, 4, 91}, "e47de6", 0.0f);
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return C0000.decode(new byte[]{7, 69, 21, 8, 93, 5, 7, 65, 12, 11, 90, 73, 9, 86, 17, 1, 64, 75, 21, 65, 23, 1, 85, 11}, "f5ed4f");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{123, 87, 20, 83, 79, 68, 4, 23, 94, 80, 14, 66, 92, 86, 71, 83, 69, 68, 18}, "584670ae01bb", 1));
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(((SimplePathStrategy) getLocalPathStrategy()).getFileForUri(uri), modeToMode(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File fileForUri = ((SimplePathStrategy) getLocalPathStrategy()).getFileForUri(uri);
        String queryParameter = uri.getQueryParameter(C0000.decode(new byte[]{82, 12, 66, 72, 89, 5, 77, 126, 87, 8, 84}, "6e185d40", 0.0f));
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            String strDecode = C0000.decode(new byte[]{107, 81, 15, 18, 73, 10, 4, 77, 106, 12, 7, 94, 81}, "45fa9fe45bf3");
            if (strDecode.equals(str3)) {
                strArr3[i2] = strDecode;
                i = i2 + 1;
                objArr[i2] = queryParameter == null ? fileForUri.getName() : queryParameter;
            } else {
                String strDecode2 = C0000.decode(new byte[]{58, 70, 15, 78, 83}, "e5f46b249cf4");
                if (strDecode2.equals(str3)) {
                    strArr3[i2] = strDecode2;
                    i = i2 + 1;
                    objArr[i2] = Long.valueOf(fileForUri.length());
                }
            }
            i2 = i;
        }
        String[] strArrCopyOf = copyOf(strArr3, i2);
        Object[] objArrCopyOf = copyOf(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArrCopyOf, 1);
        matrixCursor.addRow(objArrCopyOf);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException(C0000.decode(new byte[]{124, 86, 23, 82, 29, 23, 7, 19, 88, 88, 91, 68, 71, 73, 83, 86, 17, 6, 17}, "2977ecba697d", 2));
    }

    public FileProvider(int i) {
        this.mResourceId = i;
    }

    private static Object[] copyOf(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
