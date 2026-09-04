package com.template.shellapp;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.ByteCompanionObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class LibLoader {
    private static final String T = C0000.decode(new byte[]{126, 41, 108, 118, 112, 113}, "2e32264e", 0.0f);
    private static boolean sLoaded;

    public static synchronized boolean load(Context context, String str) {
        int i;
        boolean z;
        String str2;
        String strDecode = C0000.decode(new byte[]{5, 18, 23, 6, 18, 68, 23, 75, 11, 14, 16, 67, 5, 88, 66, 87, 16, 92}, "dadcf779");
        String strDecode2 = C0000.decode(new byte[]{2, 81, 80, 93, 93, 5}, "a035886779a7", 0.0f);
        synchronized (LibLoader.class) {
            if (sLoaded) {
                return true;
            }
            try {
                File codeCacheDir = context.getCodeCacheDir();
                File file = new File(codeCacheDir, str);
                Log.d(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 47, 103, 37, 113, 126}, "3c8a39"), strDecode2 + codeCacheDir + C0000.decode(new byte[]{69, 14, 65, 21, 13}, "ea4a0a4c2a59", true) + file);
                if (!file.exists() || file.length() < 1024) {
                    AssetManager assets = context.getAssets();
                    String[] list = assets.list("");
                    Log.d(C0000.decode(new byte[]{126, ByteCompanionObject.MAX_VALUE, 109, 33, 35, 33}, "232eafab94209b", 0.0f), strDecode + (list != null ? list.length : 0));
                    if (list == null) {
                        return false;
                    }
                    String[] strArr = Build.SUPPORTED_ABIS;
                    int length = strArr.length;
                    while (true) {
                        if (i >= length) {
                            z = false;
                            break;
                        }
                        String str3 = strArr[i];
                        i = (str3.contains(C0000.decode(new byte[]{7, 22, 15, 87, 6}, "fdba2c")) || str3.contains(C0000.decode(new byte[]{79, 10, 7, 58, 85, 87}, "721ecc2b7a"))) ? 0 : i + 1;
                        z = true;
                        break;
                    }
                    Log.d(C0000.decode(new byte[]{120, ByteCompanionObject.MAX_VALUE, 103, 114, 38, 34}, "4386de", 1), C0000.decode(new byte[]{89, 74, 80, 3, 10}, "09f77072", false) + z);
                    int length2 = list.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            str2 = null;
                            break;
                        }
                        str2 = list[i2];
                        if (str2.endsWith(C0000.decode(new byte[]{72, 2, 7, 73, 74, 6, 2, 17}, "ffb1dbce11", 7))) {
                            Log.d(C0000.decode(new byte[]{126, 47, 104, 125, 123, 33}, "2c799f", false), C0000.decode(new byte[]{4, 94, 64, 92, 83, 19, 6, 84, 77, 28, 83, 82, 22, 11, 21}, "b15273") + str2);
                            if ((z && !str2.contains(C0000.decode(new byte[]{110, 5, 5}, "16768e", 4))) || (!z && str2.contains(C0000.decode(new byte[]{109, 81, 0}, "2b237d", true)))) {
                                break;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (str2 == null) {
                        for (String str4 : list) {
                            if (str4.endsWith(C0000.decode(new byte[]{26, 0, 7, 73, 25, 92, 85, 16}, "4db178", 0.0f))) {
                                str2 = str4;
                                break;
                            }
                        }
                    }
                    Log.d(C0000.decode(new byte[]{117, 41, 109, 37, 38, 115}, "9e2ad4bb689a", 4), C0000.decode(new byte[]{84, 22, 22, 83, 66, 42, 84, 8, 0, 11}, "5ee66d", true) + str2);
                    if (str2 == null) {
                        return false;
                    }
                    InputStream inputStreamOpen = assets.open(str2);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[ConstantsKt.DEFAULT_BUFFER_SIZE];
                    while (true) {
                        int i3 = inputStreamOpen.read(bArr);
                        if (i3 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i3);
                    }
                    inputStreamOpen.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Log.d(C0000.decode(new byte[]{ByteCompanionObject.MAX_VALUE, 126, 103, 32, 119, 113}, "328d56daafcb", true), C0000.decode(new byte[]{16, 6, 80, 93, 69}, "bc19e7066dbd01", 0.0f) + byteArray.length + C0000.decode(new byte[]{69, 90, 75, 18, 92, 23, 69, 94, 64, 9, 84, 68, 4, 75, 65, 3, 77}, "e82f9d", 6));
                    byte[] bytes = str2.substring(0, 8).getBytes();
                    for (int i4 = 0; i4 < byteArray.length; i4++) {
                        byteArray[i4] = (byte) (byteArray[i4] ^ bytes[i4 % bytes.length]);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(byteArray);
                    fileOutputStream.close();
                    file.setReadable(true, false);
                    file.setExecutable(true, false);
                    Log.d(C0000.decode(new byte[]{120, 117, 57, 113, 36, 113}, "49f5f60ded79"), C0000.decode(new byte[]{66, 20, 10, 23, 92, 19}, "5fec93", 2) + file.length() + C0000.decode(new byte[]{66, 86, 31, 17, 0, 75, 66, 64, 9, 69}, "b4fee8", 0.0f) + file);
                }
                Log.d(C0000.decode(new byte[]{47, 47, 60, 33, 114, 126}, "ccce09fd5da02989", true), C0000.decode(new byte[]{85, 4, 15, 88, 13, 91, 82, 67, 99, 72, 22, 64, 81, 91, 76, 8, 89, 4, 7, 28}, "6ec4d55c01e446bd") + file.getAbsolutePath() + C0000.decode(new byte[]{29}, "4ddea2b7", 0.0f));
                System.load(file.getAbsolutePath());
                sLoaded = true;
                Log.d(C0000.decode(new byte[]{45, 116, 109, 119, 116, 115}, "a823646286c515", false), C0000.decode(new byte[]{94, 94, 88, 81, 93, 2, 19, 43, 121}, "21958f3d", 0.0f));
                return true;
            } catch (Throwable th) {
                Log.e(C0000.decode(new byte[]{45, 120, 62, 118, 122, 34}, "a4a28e5b612ec6f6", 7), C0000.decode(new byte[]{37, 114, 43, 126, 35, 37, 11, 70}, "c3b2fa1f3e") + th.getMessage(), th);
                return false;
            }
        }
    }
}
