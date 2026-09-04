package com.coresoft.safe;

import android.content.Context;
import android.util.Base64;

/* JADX INFO: renamed from: com.coresoft.safe.ۦۨۤۧ۟, reason: contains not printable characters */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage3/dex/classes8.dex */
public class C0009 {

    /* JADX INFO: renamed from: ۟۟ۥۨۢ, reason: not valid java name and contains not printable characters */
    public static int f76 = 450516468;

    /* JADX INFO: renamed from: ۡۢۨۧ۟, reason: not valid java name and contains not printable characters */
    public static int f77 = 805956137;

    /* JADX INFO: renamed from: ۠۟۠ۤ۟, reason: not valid java name and contains not printable characters */
    public static boolean m347(Object obj, Object obj2) {
        return ((String) obj).equals(obj2);
    }

    /* JADX INFO: renamed from: ۠ۦ۟ۨ, reason: not valid java name and contains not printable characters */
    public static int m348() {
        return 1361183469 ^ f77;
    }

    /* JADX INFO: renamed from: ۣ۟ۡۢ۟, reason: not valid java name and contains not printable characters */
    public static int m349(Object obj) {
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: ۦ۠ۡ۟ۨۦ, reason: contains not printable characters */
    public static String m350(short[] sArr, int i, int i2, int i3) {
        char[] cArr = new char[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            cArr[i4] = (char) (sArr[i + i4] ^ i2);
        }
        return new String(cArr);
    }

    /* JADX INFO: renamed from: ۧ۠۠ۥ۟, reason: not valid java name and contains not printable characters */
    public static ClassLoader m351(Object obj) {
        return ((Context) obj).getClassLoader();
    }

    /* JADX INFO: renamed from: ۧۧۨ۠, reason: not valid java name and contains not printable characters */
    public static byte[] m352(String str, int i) {
        return Base64.decode(str, i);
    }
}
