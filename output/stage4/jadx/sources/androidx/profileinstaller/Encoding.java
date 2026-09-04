package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Encoding {
    public static final ByteString.Companion EMPTY_DIAGNOSTICS = new ByteString.Companion();
    public static final byte[] MAGIC_PROF = {112, 114, 111, 0};
    public static final byte[] MAGIC_PROFM = {112, 114, 109, 0};
    public static final byte[] V015_S = {48, 49, 53, 0};
    public static final byte[] V010_P = {48, 49, 48, 0};
    public static final byte[] V009_O_MR1 = {48, 48, 57, 0};
    public static final byte[] V005_O = {48, 48, 53, 0};
    public static final byte[] V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V001_N = {48, 48, 49, 0};
    public static final byte[] METADATA_V002 = {48, 48, 50, 0};

    public static byte[] compress(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    deflaterOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            deflater.end();
            throw th3;
        }
    }

    public static byte[] createCompressibleBody(DexProfileData[] dexProfileDataArr, byte[] bArr) throws IOException {
        int length = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            length += ((((dexProfileData.numMethodIds * 2) + 7) & (-8)) / 8) + (dexProfileData.classSetSize * 2) + generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + dexProfileData.hotMethodRegionSize;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, V009_O_MR1)) {
            for (DexProfileData dexProfileData2 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(dexProfileData2.apkName, dexProfileData2.dexName, bArr));
                writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData2);
                int[] iArr = dexProfileData2.classes;
                int length2 = iArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length2) {
                    int i3 = iArr[i];
                    writeUInt16(byteArrayOutputStream, i3 - i2);
                    i++;
                    i2 = i3;
                }
                writeMethodBitmap(byteArrayOutputStream, dexProfileData2);
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(dexProfileData3.apkName, dexProfileData3.dexName, bArr));
            }
            for (DexProfileData dexProfileData4 : dexProfileDataArr) {
                writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData4);
                int[] iArr2 = dexProfileData4.classes;
                int length3 = iArr2.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length3) {
                    int i6 = iArr2[i4];
                    writeUInt16(byteArrayOutputStream, i6 - i5);
                    i4++;
                    i5 = i6;
                }
                writeMethodBitmap(byteArrayOutputStream, dexProfileData4);
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException(C0000.decode(new byte[]{99, 93, 6, 16, 87, 31, 18, 7, 21, 17, 68, 84, 21, 85, 81, 70, 2, 13, 70, 95, 88, 65, 67, 93, 84, 18, 5, 10, 70, 84, 79, 69, 6, 83, 65, 7, 18, 11, 9, 95, 25, 21, 2, 83, 65, 19, 7, 14, 91}, "75c05ffbf1", 6) + byteArrayOutputStream.size() + C0000.decode(new byte[]{70, 83, 79, 20, 1, 91, 64, 0, 80, 14}, "f67dd84e4305b4", 5) + length);
    }

    public static boolean deleteFilesRecursively(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = deleteFilesRecursively(file2) && z;
        }
        return z;
    }

    public static String generateDexKey(String str, String str2, byte[] bArr) {
        byte[] bArr2 = V001_N;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = V005_O;
        String strDecode = C0000.decode(new byte[]{22}, "7ee78801bd", 0.0f);
        String strDecode2 = C0000.decode(new byte[]{13}, "7cf878", false);
        String str3 = (zEquals || Arrays.equals(bArr, bArr3)) ? strDecode2 : strDecode;
        if (str.length() <= 0) {
            if (strDecode.equals(str3)) {
                return str2.replace(strDecode2, strDecode);
            }
            if (strDecode2.equals(str3)) {
                return str2.replace(strDecode, strDecode2);
            }
        } else {
            if (str2.equals(C0000.decode(new byte[]{84, 92, 81, 66, 66, 93, 68, 30, 84, 84, 73}, "700118"))) {
                return str;
            }
            if (str2.contains(strDecode) || str2.contains(strDecode2)) {
                if (strDecode.equals(str3)) {
                    return str2.replace(strDecode2, strDecode);
                }
                if (strDecode2.equals(str3)) {
                    return str2.replace(strDecode, strDecode2);
                }
            } else if (!str2.endsWith(C0000.decode(new byte[]{27, 81, 66, 94}, "5025bb5f", 0.0f))) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) {
                    strDecode = strDecode2;
                }
                return FileSectionType$EnumUnboxingLocalUtility.m(sb, strDecode, str2);
            }
        }
        return str2;
    }

    public static void noteProfileWrittenFor(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, C0000.decode(new byte[]{67, 67, 89, 86, 91, 90, 86, 93, 89, 21, 17, 89, 90, 92, 87, 23, 108, 65, 68, 95, 84, 95, 95, 81, 96, 20, 12, 76, 66, 85, 92, 35, 92, 67, 105, 92, 83, 69, 71, 97, 71, 2, 4, 76, 83, 100, 91, 8, 86, 31, 82, 81, 70}, "316026347fe8602e", false))));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] read(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                throw new IllegalStateException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{122, 91, 16, 25, 80, 11, 91, 65, 3, 81, 21, 7, 77, 64, 1, 74, 21, 17, 91, 20, 22, 92, 84, 1, 14, 20}, "44d95e", 0), i));
            }
            i2 += i3;
        }
        return bArr;
    }

    public static int[] readClasses(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int uInt = 0;
        for (int i2 = 0; i2 < i; i2++) {
            uInt += (int) readUInt(byteArrayInputStream, 2);
            iArr[i2] = uInt;
        }
        return iArr;
    }

    public static byte[] readCompressed(FileInputStream fileInputStream, int i, int i2) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int i4 = fileInputStream.read(bArr2);
                if (i4 < 0) {
                    throw new IllegalStateException(C0000.decode(new byte[]{40, 12, 79, 3, 90, 10, 1, 23, 27, 11, 73, 66, 82, 2, 17, 86, 79, 66, 106, 22, 68, 6, 4, 90, 65, 7, 87, 6, 83, 7, 69, 86, 7, 22, 92, 16, 22, 71, 17, 88, 21, 3, 85, 32, 79, 23, 0, 68, 51, 7, 88, 6, 22, 1, 28, 67, 4, 17, 23, 66, 115, 27, 21, 82, 2, 22, 92, 6, 22}, "ab9b6ce7") + i + C0000.decode(new byte[]{69, 3, 29, 76, 6, 69}, "ead8c613e6", true));
                }
                inflater.setInput(bArr2, 0, i4);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i2 - iInflate);
                    i3 += i4;
                } catch (DataFormatException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            }
            if (i3 == i) {
                if (!inflater.finished()) {
                    throw new IllegalStateException(C0000.decode(new byte[]{123, 91, 83, 10, 88, 77, 3, 23, 18, 87, 10, 83, 18, 12, 93, 65, 21, 0, 80, 87, 15, 22, 90}, "255f99fe23c72b", true));
                }
                inflater.end();
                return bArr;
            }
            throw new IllegalStateException(C0000.decode(new byte[]{119, 93, 86, 90, 70, 76, 20, 70, 3, 4, 82, 22, 86, 90, 93, 65, 6, 80, 20, 86, 31, 17, 83, 69, 19, 80, 71, 70, 8, 86, 83, 20, 2, 0, 85, 89, 94, 68, 64, 81, 18, 75, 93, 91, 8, 75, 22, 83, 75, 68, 87, 87, 21, 93, 80, 9}, "3424a844fe66") + i + C0000.decode(new byte[]{70, 87, 90, 22, 69, 84, 92, 12}, "f69b050149921419") + i3);
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static DexProfileData[] readMeta(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] bArr3 = METADATA_V001_N;
        boolean zEquals = Arrays.equals(bArr, bArr3);
        String strDecode = C0000.decode(new byte[]{99, 94, 75, 22, 72, 19, 89, 17, 18, 0, 7, 20, 12, 87, 69, 4, 22, 70, 93, 17, 75, 10, 89, 13}, "608c8c6cfec4a21e", 5);
        String strDecode2 = C0000.decode(new byte[]{113, 91, 11, 22, 80, 92, 22, 67, 84, 91, 16, 12, 81, 18, 3, 5, 70, 81, 23, 66, 65, 90, 7, 67, 87, 90, 1, 66, 90, 84, 66, 5, 91, 88, 0}, "24eb52bc", true);
        if (!zEquals) {
            if (!Arrays.equals(bArr, METADATA_V002)) {
                throw new IllegalStateException(strDecode);
            }
            int uInt = (int) readUInt(fileInputStream, 2);
            byte[] compressed = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException(strDecode2);
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
            try {
                DexProfileData[] metadataV002Body = readMetadataV002Body(byteArrayInputStream, bArr2, uInt, dexProfileDataArr);
                byteArrayInputStream.close();
                return metadataV002Body;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(V015_S, bArr2)) {
            throw new IllegalStateException(C0000.decode(new byte[]{103, 87, 23, 20, 80, 68, 3, 21, 66, 10, 3, 19, 21, 117, 7, 22, 80, 94, 15, 15, 92, 22, 54, 20, 13, 2, 15, 8, 80, 23, 43, 0, 65, 83, 2, 0, 77, 87, 72, 70, 50, 8, 3, 5, 70, 82, 70, 23, 80, 80, 19, 8, 85, 82, 70, 18, 10, 1, 70, 37, 101, 124, 70, 18, 92, 70, 14, 65, 120, 88, 2, 20, 13, 13, 2, 68, 114, 69, 7, 1, 89, 87, 70, 49, 85, 67, 1, 15, 12, 68, 81, 74, 7, 23, 37, 4, 91, 83, 20, 24, 25, 1, 70, 9, 16, 68, 14, 13, 82, 95, 3, 23}, "52fa96ffbdfd57fe", 4));
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException(strDecode);
        }
        int uInt2 = (int) readUInt(fileInputStream, 1);
        byte[] compressed2 = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException(strDecode2);
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(compressed2);
        try {
            DexProfileData[] metadataForNBody = readMetadataForNBody(byteArrayInputStream2, uInt2, dexProfileDataArr);
            byteArrayInputStream2.close();
            return metadataForNBody;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static DexProfileData[] readMetadataForNBody(ByteArrayInputStream byteArrayInputStream, int i, DexProfileData[] dexProfileDataArr) {
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i != dexProfileDataArr.length) {
            throw new IllegalStateException(C0000.decode(new byte[]{43, 12, 70, 93, 5, 17, 83, 12, 3, 7, 70, 11, 64, 93, 6, 0, 66, 68, 9, 5, 70, 1, 80, 72, 68, 3, 89, 8, 3, 16, 70, 3, 90, 69, 10, 1, 16, 13, 8, 67, 11, 0, 65, 81, 0, 4, 68, 5}, "fe50de0dfc", 3));
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int uInt = (int) readUInt(byteArrayInputStream, 2);
            iArr[i2] = (int) readUInt(byteArrayInputStream, 2);
            strArr[i2] = new String(read(byteArrayInputStream, uInt), StandardCharsets.UTF_8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            DexProfileData dexProfileData = dexProfileDataArr[i3];
            if (!dexProfileData.dexName.equals(strArr[i3])) {
                throw new IllegalStateException(C0000.decode(new byte[]{120, 65, 83, 82, 75, 65, 88, 3, 21, 0, 3, 30, 95, 10, 91, 86, 68, 23, 80, 15, 23, 8, 80, 16, 7, 2, 88, 23, 86, 19, 83, 94, 93, 65, 89, 10, 65, 68, 11, 7, 77, 0, 95, 19, 85, 86, 74, 4, 91, 12, 91, 1}, "73779a7e5dff9c", 0.0f));
            }
            int i4 = iArr[i3];
            dexProfileData.classSetSize = i4;
            dexProfileData.classes = readClasses(byteArrayInputStream, i4);
        }
        return dexProfileDataArr;
    }

    public static DexProfileData[] readMetadataV002Body(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, DexProfileData[] dexProfileDataArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i != dexProfileDataArr.length) {
            throw new IllegalStateException(C0000.decode(new byte[]{116, 11, 74, 85, 4, 18, 1, 90, 93, 93, 25, 12, 76, 85, 7, 3, 16, 18, 87, 95, 25, 6, 92, 64, 69, 0, 11, 94, 93, 74, 25, 4, 86, 77, 11, 2, 66, 91, 86, 25, 84, 7, 77, 89, 1, 7, 22, 83}, "9b98efb289"));
        }
        for (int i2 = 0; i2 < i; i2++) {
            readUInt(byteArrayInputStream, 2);
            String str = new String(read(byteArrayInputStream, (int) readUInt(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long uInt = readUInt(byteArrayInputStream, 4);
            int uInt2 = (int) readUInt(byteArrayInputStream, 2);
            DexProfileData dexProfileData = null;
            if (dexProfileDataArr.length > 0) {
                int iIndexOf = str.indexOf(C0000.decode(new byte[]{19}, "2daa6b57"));
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(C0000.decode(new byte[]{88}, "b3778fb97003ae4e"));
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                for (int i3 = 0; i3 < dexProfileDataArr.length; i3++) {
                    if (dexProfileDataArr[i3].dexName.equals(strSubstring)) {
                        dexProfileData = dexProfileDataArr[i3];
                        break;
                    }
                }
            }
            if (dexProfileData == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{117, 81, 66, 68, 93, 92, 80, 65, 18, 17, 91, 94, 11, 90, 93, 24, 90, 82, 77, 8, 23}, "8817427abc48b6").concat(str));
            }
            dexProfileData.mTypeIdCount = uInt;
            int[] classes = readClasses(byteArrayInputStream, uInt2);
            if (Arrays.equals(bArr, V001_N)) {
                dexProfileData.classSetSize = uInt2;
                dexProfileData.classes = classes;
            }
        }
        return dexProfileDataArr;
    }

    public static DexProfileData[] readProfile(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, V010_P)) {
            throw new IllegalStateException(C0000.decode(new byte[]{49, 12, 69, 71, 66, 21, 9, 68, 68, 80, 0, 66, 64, 87, 64, 22, 15, 89, 94}, "db622ef605"));
        }
        int uInt = (int) readUInt(fileInputStream, 1);
        byte[] compressed = readCompressed(fileInputStream, (int) readUInt(fileInputStream, 4), (int) readUInt(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException(C0000.decode(new byte[]{37, 90, 87, 67, 86, 13, 68, 23, 0, 90, 76, 89, 87, 67, 81, 81, 18, 80, 75, 23, 71, 11, 85, 23, 3, 91, 93, 23, 92, 5, 16, 81, 15, 89, 92}, "f5973c07", 0.0f));
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        try {
            DexProfileData[] uncompressedBody = readUncompressedBody(byteArrayInputStream, str, uInt);
            byteArrayInputStream.close();
            return uncompressedBody;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long readUInt(InputStream inputStream, int i) throws IOException {
        byte[] bArr = read(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += ((long) (bArr[i2] & 255)) << (i2 * 8);
        }
        return j;
    }

    public static DexProfileData[] readUncompressedBody(ByteArrayInputStream byteArrayInputStream, String str, int i) throws IOException {
        int i2 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i];
        for (int i3 = 0; i3 < i; i3++) {
            int uInt = (int) readUInt(byteArrayInputStream, 2);
            int uInt2 = (int) readUInt(byteArrayInputStream, 2);
            dexProfileDataArr[i3] = new DexProfileData(str, new String(read(byteArrayInputStream, uInt), StandardCharsets.UTF_8), readUInt(byteArrayInputStream, 4), uInt2, (int) readUInt(byteArrayInputStream, 4), (int) readUInt(byteArrayInputStream, 4), new int[uInt2], new TreeMap());
        }
        int i4 = 0;
        while (i4 < i) {
            DexProfileData dexProfileData = dexProfileDataArr[i4];
            int iAvailable = byteArrayInputStream.available();
            int i5 = dexProfileData.hotMethodRegionSize;
            int i6 = dexProfileData.numMethodIds;
            TreeMap treeMap = dexProfileData.methods;
            int i7 = iAvailable - i5;
            int uInt3 = i2;
            while (byteArrayInputStream.available() > i7) {
                uInt3 += (int) readUInt(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(uInt3), 1);
                int uInt4 = (int) readUInt(byteArrayInputStream, 2);
                while (uInt4 > 0) {
                    readUInt(byteArrayInputStream, 2);
                    int uInt5 = (int) readUInt(byteArrayInputStream, 1);
                    if (uInt5 != 6 && uInt5 != 7) {
                        while (uInt5 > 0) {
                            readUInt(byteArrayInputStream, 1);
                            int i8 = i2;
                            int i9 = i4;
                            for (int uInt6 = (int) readUInt(byteArrayInputStream, 1); uInt6 > 0; uInt6--) {
                                readUInt(byteArrayInputStream, 2);
                            }
                            uInt5--;
                            i2 = i8;
                            i4 = i9;
                        }
                    }
                    uInt4--;
                    i2 = i2;
                    i4 = i4;
                }
            }
            int i10 = i2;
            int i11 = i4;
            if (byteArrayInputStream.available() != i7) {
                throw new IllegalStateException(C0000.decode(new byte[]{99, 4, 83, 1, 22, 69, 94, 10, 17, 12, 71, 6, 94, 17, 85, 4, 69, 0, 18, 1, 67, 67, 88, 11, 86, 65, 66, 23, 89, 87, 88, 9, 84, 65, 94, 12, 88, 84, 17, 21, 80, 19, 65, 0}, "1a2e611e", 0));
            }
            dexProfileData.classes = readClasses(byteArrayInputStream, dexProfileData.classSetSize);
            BitSet bitSetValueOf = BitSet.valueOf(read(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
            for (int i12 = i10; i12 < i6; i12++) {
                int i13 = bitSetValueOf.get(i12) ? 2 : i10;
                if (bitSetValueOf.get(i12 + i6)) {
                    i13 |= 4;
                }
                if (i13 != 0) {
                    Integer numValueOf = (Integer) treeMap.get(Integer.valueOf(i12));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i10);
                    }
                    treeMap.put(Integer.valueOf(i12), Integer.valueOf(i13 | numValueOf.intValue()));
                }
            }
            i4 = i11 + 1;
            i2 = i10;
        }
        return dexProfileDataArr;
    }

    public static boolean transcodeAndWriteBody(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        long j;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = V015_S;
        int i = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = V010_P;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrCreateCompressibleBody = createCompressibleBody(dexProfileDataArr, bArr3);
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                writeUInt(byteArrayOutputStream, bArrCreateCompressibleBody.length, 4);
                byte[] bArrCompress = compress(bArrCreateCompressibleBody);
                writeUInt(byteArrayOutputStream, bArrCompress.length, 4);
                byteArrayOutputStream.write(bArrCompress);
                return true;
            }
            byte[] bArr4 = V005_O;
            if (Arrays.equals(bArr, bArr4)) {
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                for (DexProfileData dexProfileData : dexProfileDataArr) {
                    int size = dexProfileData.methods.size() * 4;
                    String strGenerateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    writeUInt16(byteArrayOutputStream, strGenerateDexKey.getBytes(charset).length);
                    writeUInt16(byteArrayOutputStream, dexProfileData.classes.length);
                    writeUInt(byteArrayOutputStream, size, 4);
                    writeUInt(byteArrayOutputStream, dexProfileData.dexChecksum, 4);
                    byteArrayOutputStream.write(strGenerateDexKey.getBytes(charset));
                    Iterator it = dexProfileData.methods.keySet().iterator();
                    while (it.hasNext()) {
                        writeUInt16(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        writeUInt16(byteArrayOutputStream, 0);
                    }
                    for (int i2 : dexProfileData.classes) {
                        writeUInt16(byteArrayOutputStream, i2);
                    }
                }
                return true;
            }
            byte[] bArr5 = V009_O_MR1;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrCreateCompressibleBody2 = createCompressibleBody(dexProfileDataArr, bArr5);
                writeUInt(byteArrayOutputStream, dexProfileDataArr.length, 1);
                writeUInt(byteArrayOutputStream, bArrCreateCompressibleBody2.length, 4);
                byte[] bArrCompress2 = compress(bArrCreateCompressibleBody2);
                writeUInt(byteArrayOutputStream, bArrCompress2.length, 4);
                byteArrayOutputStream.write(bArrCompress2);
                return true;
            }
            byte[] bArr6 = V001_N;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            writeUInt16(byteArrayOutputStream, dexProfileDataArr.length);
            for (DexProfileData dexProfileData2 : dexProfileDataArr) {
                String str = dexProfileData2.apkName;
                TreeMap treeMap = dexProfileData2.methods;
                String strGenerateDexKey2 = generateDexKey(str, dexProfileData2.dexName, bArr6);
                Charset charset2 = StandardCharsets.UTF_8;
                writeUInt16(byteArrayOutputStream, strGenerateDexKey2.getBytes(charset2).length);
                writeUInt16(byteArrayOutputStream, treeMap.size());
                writeUInt16(byteArrayOutputStream, dexProfileData2.classes.length);
                writeUInt(byteArrayOutputStream, dexProfileData2.dexChecksum, 4);
                byteArrayOutputStream.write(strGenerateDexKey2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    writeUInt16(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i3 : dexProfileData2.classes) {
                    writeUInt16(byteArrayOutputStream, i3);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            writeUInt16(byteArrayOutputStream2, dexProfileDataArr.length);
            int i4 = 2;
            int i5 = 2;
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeUInt(byteArrayOutputStream2, dexProfileData3.dexChecksum, 4);
                writeUInt(byteArrayOutputStream2, dexProfileData3.mTypeIdCount, 4);
                writeUInt(byteArrayOutputStream2, dexProfileData3.numMethodIds, 4);
                String strGenerateDexKey3 = generateDexKey(dexProfileData3.apkName, dexProfileData3.dexName, bArr2);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = strGenerateDexKey3.getBytes(charset3).length;
                writeUInt16(byteArrayOutputStream2, length2);
                i5 = i5 + 14 + length2;
                byteArrayOutputStream2.write(strGenerateDexKey3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            int length3 = byteArray.length;
            String strDecode = C0000.decode(new byte[]{27, 70, 85, 9, 81, 67, 68, 89, 90, 22, 69, 92, 3, 21, 2, 12, 23, 7, 82, 18, 65, 81, 8, 23, 70, 11, 31, 84, 66}, "7f1f40d75be1baad");
            String strDecode2 = C0000.decode(new byte[]{39, 27, 69, 6, 5, 18, 4, 80, 69, 22, 93, 66, 7, 67}, "bc5cffa4ee48");
            if (i5 != length3) {
                throw new IllegalStateException(strDecode2 + i5 + strDecode + byteArray.length);
            }
            WritableFileSection writableFileSection = new WritableFileSection(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(writableFileSection);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i6 = 0;
            int i7 = 0;
            while (i6 < dexProfileDataArr.length) {
                try {
                    DexProfileData dexProfileData4 = dexProfileDataArr[i6];
                    writeUInt16(byteArrayOutputStream3, i6);
                    writeUInt16(byteArrayOutputStream3, dexProfileData4.classSetSize);
                    i7 = i7 + 4 + (dexProfileData4.classSetSize * i4);
                    int[] iArr = dexProfileData4.classes;
                    int length4 = iArr.length;
                    int i8 = i;
                    int i9 = i4;
                    int i10 = i8;
                    while (i10 < length4) {
                        int i11 = iArr[i10];
                        writeUInt16(byteArrayOutputStream3, i11 - i8);
                        i10++;
                        i8 = i11;
                    }
                    i6++;
                    i4 = i9;
                    i = 0;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i7 != byteArray2.length) {
                throw new IllegalStateException(strDecode2 + i7 + strDecode + byteArray2.length);
            }
            WritableFileSection writableFileSection2 = new WritableFileSection(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(writableFileSection2);
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
            int i12 = 0;
            int i13 = 0;
            while (i12 < dexProfileDataArr.length) {
                try {
                    DexProfileData dexProfileData5 = dexProfileDataArr[i12];
                    Iterator it3 = dexProfileData5.methods.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    try {
                        writeMethodBitmap(byteArrayOutputStream5, dexProfileData5);
                        byte[] byteArray3 = byteArrayOutputStream5.toByteArray();
                        byteArrayOutputStream5.close();
                        ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                        try {
                            writeMethodsWithInlineCaches(byteArrayOutputStream6, dexProfileData5);
                            byte[] byteArray4 = byteArrayOutputStream6.toByteArray();
                            byteArrayOutputStream6.close();
                            writeUInt16(byteArrayOutputStream4, i12);
                            int length5 = byteArray3.length + 2 + byteArray4.length;
                            int i14 = i13 + 6;
                            ArrayList arrayList4 = arrayList3;
                            writeUInt(byteArrayOutputStream4, length5, 4);
                            writeUInt16(byteArrayOutputStream4, iIntValue);
                            byteArrayOutputStream4.write(byteArray3);
                            byteArrayOutputStream4.write(byteArray4);
                            i13 = i14 + length5;
                            i12++;
                            arrayList3 = arrayList4;
                        } catch (Throwable th3) {
                            try {
                                byteArrayOutputStream6.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            byteArrayOutputStream5.close();
                            throw th5;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        byteArrayOutputStream4.close();
                        throw th7;
                    } catch (Throwable th8) {
                        th7.addSuppressed(th8);
                        throw th7;
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream4.toByteArray();
            if (i13 != byteArray5.length) {
                throw new IllegalStateException(strDecode2 + i13 + strDecode + byteArray5.length);
            }
            WritableFileSection writableFileSection3 = new WritableFileSection(4, byteArray5, true);
            byteArrayOutputStream4.close();
            arrayList2.add(writableFileSection3);
            long j2 = 4;
            long size2 = j2 + j2 + 4 + ((long) (arrayList2.size() * 16));
            writeUInt(byteArrayOutputStream, arrayList2.size(), 4);
            int i15 = 0;
            while (i15 < arrayList2.size()) {
                WritableFileSection writableFileSection4 = (WritableFileSection) arrayList2.get(i15);
                int i16 = writableFileSection4.mType;
                byte[] bArr7 = writableFileSection4.mContents;
                if (i16 == 1) {
                    j = 0;
                } else if (i16 == 2) {
                    j = 1;
                } else if (i16 == 3) {
                    j = 2;
                } else if (i16 == 4) {
                    j = 3;
                } else {
                    if (i16 != 5) {
                        throw null;
                    }
                    j = 4;
                }
                writeUInt(byteArrayOutputStream, j, 4);
                writeUInt(byteArrayOutputStream, size2, 4);
                if (writableFileSection4.mNeedsCompression) {
                    long length6 = bArr7.length;
                    byte[] bArrCompress3 = compress(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrCompress3);
                    writeUInt(byteArrayOutputStream, bArrCompress3.length, 4);
                    writeUInt(byteArrayOutputStream, length6, 4);
                    length = bArrCompress3.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    writeUInt(byteArrayOutputStream, bArr7.length, 4);
                    writeUInt(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += (long) length;
                i15++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i17 = 0; i17 < arrayList6.size(); i17++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i17));
            }
            return true;
        } catch (Throwable th9) {
            try {
                byteArrayOutputStream2.close();
                throw th9;
            } catch (Throwable th10) {
                th9.addSuppressed(th10);
                throw th9;
            }
        }
    }

    public static void writeLineHeader(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        writeUInt16(byteArrayOutputStream, str.getBytes(charset).length);
        writeUInt16(byteArrayOutputStream, dexProfileData.classSetSize);
        writeUInt(byteArrayOutputStream, dexProfileData.hotMethodRegionSize, 4);
        writeUInt(byteArrayOutputStream, dexProfileData.dexChecksum, 4);
        writeUInt(byteArrayOutputStream, dexProfileData.numMethodIds, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void writeMethodBitmap(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[(((dexProfileData.numMethodIds * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i = iIntValue / 8;
                bArr[i] = (byte) (bArr[i] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i2 = iIntValue + dexProfileData.numMethodIds;
                int i3 = i2 / 8;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeMethodsWithInlineCaches(ByteArrayOutputStream byteArrayOutputStream, DexProfileData dexProfileData) throws IOException {
        int i = 0;
        for (Map.Entry entry : dexProfileData.methods.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                writeUInt16(byteArrayOutputStream, iIntValue - i);
                writeUInt16(byteArrayOutputStream, 0);
                i = iIntValue;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x021b A[Catch: all -> 0x0229, TRY_LEAVE, TryCatch #3 {all -> 0x0229, blocks: (B:119:0x020f, B:121:0x021b, B:130:0x022c), top: B:213:0x020f, outer: #27 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x022c A[Catch: all -> 0x0229, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0229, blocks: (B:119:0x020f, B:121:0x021b, B:130:0x022c), top: B:213:0x020f, outer: #27 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0249  */
    /* JADX WARN: Code duplicated, block: B:145:0x0253  */
    /* JADX WARN: Code duplicated, block: B:146:0x0257  */
    /* JADX WARN: Code duplicated, block: B:154:0x0271 A[Catch: all -> 0x0293, TRY_LEAVE, TryCatch #28 {all -> 0x0293, blocks: (B:151:0x0269, B:152:0x026b, B:154:0x0271), top: B:232:0x0269 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:200:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:205:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:242:0x025b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:247:0x020a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:0x0276 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public static void writeProfile(Context context, Executor executor, ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback, boolean z) {
        FileInputStream fileInputStreamOpenStreamFromAssets;
        char c;
        DexProfileData[] profile;
        ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback2;
        DexProfileData[] dexProfileDataArr;
        byte[] bArr;
        String strDecode;
        byte[] bArr2;
        boolean z2;
        ByteArrayInputStream byteArrayInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        byte[] bArr3;
        int i;
        boolean z3;
        ByteArrayOutputStream byteArrayOutputStream;
        int i2;
        DeviceProfileWriter deviceProfileWriter;
        boolean z4;
        boolean z5;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z) {
                File file = new File(filesDir, C0000.decode(new byte[]{71, 75, 13, 83, 81, 93, 86, 92, 89, 17, 21, 81, 10, 94, 82, 75, 61, 69, 74, 94, 85, 92, 91, 7, 54, 66, 15, 70, 67, 92, 12, 115, 87, 67, 108, 89, 86, 17, 21, 101, 22, 86, 86, 77, 7, 97, 81, 92, 86, 27, 83, 3, 21}, "79b581357ba0f2"));
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j = dataInputStream.readLong();
                            dataInputStream.close();
                            z5 = j == packageInfo.lastUpdateTime;
                            if (z5) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(2, null);
                            }
                        } catch (Throwable th2) {
                            try {
                                dataInputStream.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    } catch (IOException unused) {
                        z5 = false;
                    }
                } else {
                    z5 = false;
                }
                if (z5) {
                    context.getPackageName();
                    ProfileVerifier.writeProfileVerification(context, false);
                    return;
                }
            }
            context.getPackageName();
            int i3 = Build.VERSION.SDK_INT;
            File file2 = new File(new File(C0000.decode(new byte[]{76, 82, 80, 23, 4, 25, 11, 92, 16, 85, 30, 19, 23, 89, 0, 92, 15, 83, 66, 76, 6, 67, 20, 26, 83}, "c61ce6f5", 7), packageName), C0000.decode(new byte[]{17, 75, 15, 14, 7, 23, 27, 23, 19, 17, 14, 7}, "a9fcfeb9ccaa", 0.0f));
            String strDecode2 = C0000.decode(new byte[]{5, 81, 25, 12, 72, 69, 28, 87, 0, 71, 4, 15, 81, 95, 86, 27, 17, 70, 14, 5}, "a4ac8135", 6);
            DeviceProfileWriter deviceProfileWriter2 = new DeviceProfileWriter(assets, executor, profileInstaller$DiagnosticsCallback, name, file2);
            byte[] bArr4 = deviceProfileWriter2.mDesiredVersion;
            if (bArr4 != null) {
                if (file2.canWrite()) {
                    deviceProfileWriter2.mDeviceSupportsAotProfile = true;
                    try {
                        fileInputStreamOpenStreamFromAssets = deviceProfileWriter2.openStreamFromAssets(assets, strDecode2);
                    } catch (FileNotFoundException e) {
                        profileInstaller$DiagnosticsCallback.onResultReceived(6, e);
                        fileInputStreamOpenStreamFromAssets = null;
                    } catch (IOException e2) {
                        profileInstaller$DiagnosticsCallback.onResultReceived(7, e2);
                        fileInputStreamOpenStreamFromAssets = null;
                    }
                    String strDecode3 = C0000.decode(new byte[]{43, 12, 70, 5, 9, 88, 6, 66, 93, 5, 2, 88, 1}, "bb0de1", 6);
                    byte[] bArr5 = MAGIC_PROF;
                    c = '\b';
                    try {
                        if (fileInputStreamOpenStreamFromAssets != null) {
                            try {
                                if (!Arrays.equals(bArr5, read(fileInputStreamOpenStreamFromAssets, 4))) {
                                    throw new IllegalStateException(strDecode3);
                                }
                                profile = readProfile(fileInputStreamOpenStreamFromAssets, read(fileInputStreamOpenStreamFromAssets, 4), deviceProfileWriter2.mApkName);
                                try {
                                    fileInputStreamOpenStreamFromAssets.close();
                                } catch (IOException e3) {
                                    profileInstaller$DiagnosticsCallback.onResultReceived(7, e3);
                                }
                                deviceProfileWriter2.mProfile = profile;
                            } catch (IOException e4) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(7, e4);
                                try {
                                    fileInputStreamOpenStreamFromAssets.close();
                                } catch (IOException e5) {
                                    profileInstaller$DiagnosticsCallback.onResultReceived(7, e5);
                                }
                                profile = null;
                            } catch (IllegalStateException e6) {
                                profileInstaller$DiagnosticsCallback.onResultReceived(8, e6);
                                fileInputStreamOpenStreamFromAssets.close();
                                profile = null;
                            }
                        }
                        DexProfileData[] dexProfileDataArr2 = deviceProfileWriter2.mProfile;
                        if (dexProfileDataArr2 != null && (i2 = Build.VERSION.SDK_INT) <= 33) {
                            switch (i2) {
                                case 31:
                                case 32:
                                case 33:
                                    try {
                                        FileInputStream fileInputStreamOpenStreamFromAssets2 = deviceProfileWriter2.openStreamFromAssets(assets, C0000.decode(new byte[]{81, 92, 27, 12, 65, 18, 27, 86, 85, 16, 83, 93, 92, 87, 6, 77, 65, 20, 91, 82, 89}, "59cc1f444c61"));
                                        if (fileInputStreamOpenStreamFromAssets2 != null) {
                                            try {
                                                if (!Arrays.equals(MAGIC_PROFM, read(fileInputStreamOpenStreamFromAssets2, 4))) {
                                                    throw new IllegalStateException(strDecode3);
                                                }
                                                deviceProfileWriter2.mProfile = readMeta(fileInputStreamOpenStreamFromAssets2, read(fileInputStreamOpenStreamFromAssets2, 4), bArr4, dexProfileDataArr2);
                                                fileInputStreamOpenStreamFromAssets2.close();
                                                deviceProfileWriter = deviceProfileWriter2;
                                            } catch (Throwable th4) {
                                                try {
                                                    fileInputStreamOpenStreamFromAssets2.close();
                                                    throw th4;
                                                } catch (Throwable th5) {
                                                    th4.addSuppressed(th5);
                                                    throw th4;
                                                }
                                            }
                                        } else {
                                            if (fileInputStreamOpenStreamFromAssets2 != null) {
                                                fileInputStreamOpenStreamFromAssets2.close();
                                            }
                                            deviceProfileWriter = null;
                                        }
                                    } catch (FileNotFoundException e7) {
                                        profileInstaller$DiagnosticsCallback.onResultReceived(9, e7);
                                    } catch (IOException e8) {
                                        profileInstaller$DiagnosticsCallback.onResultReceived(7, e8);
                                    } catch (IllegalStateException e9) {
                                        deviceProfileWriter2.mProfile = null;
                                        profileInstaller$DiagnosticsCallback.onResultReceived(8, e9);
                                    }
                                    if (deviceProfileWriter != null) {
                                        deviceProfileWriter2 = deviceProfileWriter;
                                        break;
                                    }
                                default:
                                    profileInstaller$DiagnosticsCallback2 = deviceProfileWriter2.mDiagnostics;
                                    dexProfileDataArr = deviceProfileWriter2.mProfile;
                                    bArr = deviceProfileWriter2.mDesiredVersion;
                                    strDecode = C0000.decode(new byte[]{102, 80, 95, 74, 16, 81, 82, 18, 94, 91, 6, 20, 86, 87, 83, 74, 94, 18, 67, 68, 68, 77, 19, 68, 93, 74, 66, 25, 81, 90, 67, 74, 23, 124, 10, 80, 18, 65, 89, 76, 16, 86, 86, 8, 91, 24, 7, 81, 68, 81, 85, 92, 99, 64, 71, 20, 88, 74, 23, 71, 115, 87, 66, 105, 66, 90, 81, 13, 91, 93, 75, 29, 13}, "2869057d78c4", true);
                                    if (dexProfileDataArr != null && bArr != null) {
                                        if (deviceProfileWriter2.mDeviceSupportsAotProfile) {
                                            throw new IllegalStateException(strDecode);
                                        }
                                        try {
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            try {
                                                byteArrayOutputStream.write(bArr5);
                                                byteArrayOutputStream.write(bArr);
                                                if (transcodeAndWriteBody(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                                                    deviceProfileWriter2.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                                                    byteArrayOutputStream.close();
                                                    deviceProfileWriter2.mProfile = null;
                                                } else {
                                                    profileInstaller$DiagnosticsCallback2.onResultReceived(5, null);
                                                    deviceProfileWriter2.mProfile = null;
                                                    byteArrayOutputStream.close();
                                                }
                                            } catch (Throwable th6) {
                                                try {
                                                    byteArrayOutputStream.close();
                                                    throw th6;
                                                } catch (Throwable th7) {
                                                    th6.addSuppressed(th7);
                                                    throw th6;
                                                }
                                            }
                                        } catch (IOException e10) {
                                            profileInstaller$DiagnosticsCallback2.onResultReceived(7, e10);
                                        } catch (IllegalStateException e11) {
                                            profileInstaller$DiagnosticsCallback2.onResultReceived(8, e11);
                                        }
                                    }
                                    bArr2 = deviceProfileWriter2.mTranscodedProfile;
                                    if (bArr2 != null) {
                                        z2 = false;
                                        c = 1;
                                    } else {
                                        try {
                                            if (deviceProfileWriter2.mDeviceSupportsAotProfile) {
                                                throw new IllegalStateException(strDecode);
                                            }
                                            try {
                                                try {
                                                    byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                                    try {
                                                        fileOutputStream = new FileOutputStream(deviceProfileWriter2.mCurProfile);
                                                        try {
                                                            try {
                                                                bArr3 = new byte[512];
                                                                while (true) {
                                                                    i = byteArrayInputStream.read(bArr3);
                                                                    if (i > 0) {
                                                                        fileOutputStream.write(bArr3, 0, i);
                                                                    } else {
                                                                        c = 1;
                                                                        try {
                                                                            deviceProfileWriter2.result(1, null);
                                                                            fileOutputStream.close();
                                                                            byteArrayInputStream.close();
                                                                            deviceProfileWriter2.mTranscodedProfile = null;
                                                                            deviceProfileWriter2.mProfile = null;
                                                                            z2 = true;
                                                                        } catch (Throwable th8) {
                                                                            th = th8;
                                                                        }
                                                                    }
                                                                    th = th;
                                                                    try {
                                                                        fileOutputStream.close();
                                                                        throw th;
                                                                    } catch (Throwable th9) {
                                                                        th.addSuppressed(th9);
                                                                        throw th;
                                                                    }
                                                                }
                                                            } catch (Throwable th10) {
                                                                th = th10;
                                                                Throwable th11 = th;
                                                                try {
                                                                    byteArrayInputStream.close();
                                                                    throw th11;
                                                                } catch (Throwable th12) {
                                                                    th11.addSuppressed(th12);
                                                                    throw th11;
                                                                }
                                                            }
                                                        } catch (Throwable th13) {
                                                            th = th13;
                                                        }
                                                    } catch (Throwable th14) {
                                                        th = th14;
                                                    }
                                                } catch (FileNotFoundException e12) {
                                                    e = e12;
                                                    c = 1;
                                                    deviceProfileWriter2.result(6, e);
                                                    deviceProfileWriter2.mTranscodedProfile = null;
                                                    deviceProfileWriter2.mProfile = null;
                                                    z2 = false;
                                                } catch (IOException e13) {
                                                    e = e13;
                                                    c = 1;
                                                    deviceProfileWriter2.result(7, e);
                                                    deviceProfileWriter2.mTranscodedProfile = null;
                                                    deviceProfileWriter2.mProfile = null;
                                                    z2 = false;
                                                }
                                            } catch (FileNotFoundException e14) {
                                                e = e14;
                                                deviceProfileWriter2.result(6, e);
                                                deviceProfileWriter2.mTranscodedProfile = null;
                                                deviceProfileWriter2.mProfile = null;
                                                z2 = false;
                                            } catch (IOException e15) {
                                                e = e15;
                                                deviceProfileWriter2.result(7, e);
                                                deviceProfileWriter2.mTranscodedProfile = null;
                                                deviceProfileWriter2.mProfile = null;
                                                z2 = false;
                                            }
                                        } catch (Throwable th15) {
                                            deviceProfileWriter2.mTranscodedProfile = null;
                                            deviceProfileWriter2.mProfile = null;
                                            throw th15;
                                        }
                                    }
                                    if (z2) {
                                        noteProfileWrittenFor(packageInfo, filesDir);
                                    }
                                    z3 = z2;
                                    break;
                            }
                        }
                        profileInstaller$DiagnosticsCallback2 = deviceProfileWriter2.mDiagnostics;
                        dexProfileDataArr = deviceProfileWriter2.mProfile;
                        bArr = deviceProfileWriter2.mDesiredVersion;
                        strDecode = C0000.decode(new byte[]{102, 80, 95, 74, 16, 81, 82, 18, 94, 91, 6, 20, 86, 87, 83, 74, 94, 18, 67, 68, 68, 77, 19, 68, 93, 74, 66, 25, 81, 90, 67, 74, 23, 124, 10, 80, 18, 65, 89, 76, 16, 86, 86, 8, 91, 24, 7, 81, 68, 81, 85, 92, 99, 64, 71, 20, 88, 74, 23, 71, 115, 87, 66, 105, 66, 90, 81, 13, 91, 93, 75, 29, 13}, "2869057d78c4", true);
                        if (dexProfileDataArr != null) {
                            if (deviceProfileWriter2.mDeviceSupportsAotProfile) {
                                throw new IllegalStateException(strDecode);
                            }
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            byteArrayOutputStream.write(bArr5);
                            byteArrayOutputStream.write(bArr);
                            if (transcodeAndWriteBody(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                                profileInstaller$DiagnosticsCallback2.onResultReceived(5, null);
                                deviceProfileWriter2.mProfile = null;
                                byteArrayOutputStream.close();
                            } else {
                                deviceProfileWriter2.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                deviceProfileWriter2.mProfile = null;
                            }
                        }
                        bArr2 = deviceProfileWriter2.mTranscodedProfile;
                        if (bArr2 != null) {
                            if (deviceProfileWriter2.mDeviceSupportsAotProfile) {
                                throw new IllegalStateException(strDecode);
                            }
                            byteArrayInputStream = new ByteArrayInputStream(bArr2);
                            fileOutputStream = new FileOutputStream(deviceProfileWriter2.mCurProfile);
                            bArr3 = new byte[512];
                            while (true) {
                                i = byteArrayInputStream.read(bArr3);
                                if (i > 0) {
                                    fileOutputStream.write(bArr3, 0, i);
                                } else {
                                    c = 1;
                                    deviceProfileWriter2.result(1, null);
                                    fileOutputStream.close();
                                    byteArrayInputStream.close();
                                    deviceProfileWriter2.mTranscodedProfile = null;
                                    deviceProfileWriter2.mProfile = null;
                                    z2 = true;
                                }
                                th = th;
                                fileOutputStream.close();
                                throw th;
                            }
                        }
                        z2 = false;
                        c = 1;
                        if (z2) {
                            noteProfileWrittenFor(packageInfo, filesDir);
                        }
                        z3 = z2;
                    } catch (Throwable th16) {
                        try {
                            fileInputStreamOpenStreamFromAssets.close();
                            throw th16;
                        } catch (IOException e16) {
                            profileInstaller$DiagnosticsCallback.onResultReceived(7, e16);
                            throw th16;
                        }
                    }
                } else {
                    deviceProfileWriter2.result(4, null);
                }
                if (z3 || !z) {
                    z4 = 0;
                } else {
                    z4 = c;
                }
                ProfileVerifier.writeProfileVerification(context, z4);
            }
            deviceProfileWriter2.result(3, Integer.valueOf(i3));
            z3 = false;
            c = 1;
            if (z3) {
                z4 = 0;
            } else {
                z4 = 0;
            }
            ProfileVerifier.writeProfileVerification(context, z4);
        } catch (PackageManager.NameNotFoundException e17) {
            profileInstaller$DiagnosticsCallback.onResultReceived(7, e17);
            ProfileVerifier.writeProfileVerification(context, false);
        }
    }

    public static void writeUInt(ByteArrayOutputStream byteArrayOutputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void writeUInt16(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        writeUInt(byteArrayOutputStream, i, 2);
    }
}
