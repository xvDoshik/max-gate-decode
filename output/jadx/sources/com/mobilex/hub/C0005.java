package com.mobilex.hub;

import android.content.Context;
import android.util.Base64;

/* JADX INFO: renamed from: com.mobilex.hub.ۡۥۡۨۢ, reason: contains not printable characters */
/* JADX INFO: loaded from: classes6.dex */
public class C0005 {

    /* JADX INFO: renamed from: ۟۟ۥۨۢ, reason: not valid java name and contains not printable characters */
    public static int f71 = 674160591;

    /* JADX INFO: renamed from: ۢۧۨۦۡ, reason: not valid java name and contains not printable characters */
    public static int f72 = 412093205;

    /* JADX INFO: renamed from: ۢۦۨۡۧۤ, reason: not valid java name and contains not printable characters */
    public static byte[] m331(String str, int i) {
        return Base64.decode(str, i);
    }

    /* JADX INFO: renamed from: ۢۧۦۦ, reason: not valid java name and contains not printable characters */
    public static int m332() {
        return 78420223 ^ f72;
    }

    /* JADX INFO: renamed from: ۣ۟ۡۢ۟, reason: not valid java name and contains not printable characters */
    public static int m333(Object obj) {
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: ۤ۠ۦۦۥ, reason: not valid java name and contains not printable characters */
    public static ClassLoader m334(Object obj) {
        return ((Context) obj).getClassLoader();
    }

    /* JADX INFO: renamed from: ۦۧۨۦۧ, reason: contains not printable characters */
    public static boolean m335(Object obj, Object obj2) {
        return ((String) obj).equals(obj2);
    }

    /* JADX INFO: renamed from: ۨۥۢ۟, reason: not valid java name and contains not printable characters */
    public static String m336(short[] sArr, int i, int i2, int i3) {
        char[] cArr = new char[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            cArr[i4] = (char) (sArr[i + i4] ^ i2);
        }
        return new String(cArr);
    }
}
