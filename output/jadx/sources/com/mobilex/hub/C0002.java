package com.mobilex.hub;

import android.content.Context;
import android.content.res.Resources;
import java.io.File;

/* JADX INFO: renamed from: com.mobilex.hub.۟ۧۧۢ۠ۡ, reason: contains not printable characters */
/* JADX INFO: loaded from: classes2.dex */
public class C0002 {

    /* JADX INFO: renamed from: ۟۟ۥۨۢ, reason: not valid java name and contains not printable characters */
    public static int f65 = 1887670758;

    /* JADX INFO: renamed from: ۢۥ۠۠ۤ, reason: not valid java name and contains not printable characters */
    public static int f66 = 362355903;

    /* JADX INFO: renamed from: ۡۢ۠ۤ, reason: not valid java name and contains not printable characters */
    public static int m316() {
        return 1554227503 ^ C0003.f68;
    }

    /* JADX INFO: renamed from: ۣ۟ۡۢ۟, reason: not valid java name and contains not printable characters */
    public static int m317(Object obj) {
        return obj.hashCode();
    }

    /* JADX INFO: renamed from: ۥۤۦۥ, reason: contains not printable characters */
    public static boolean m318(Object obj, String str) {
        return ((String) obj).startsWith(str);
    }

    /* JADX INFO: renamed from: ۦۤ۟ۢۤۥ, reason: contains not printable characters */
    public static boolean m319(Object obj) {
        return ((File) obj).exists();
    }

    /* JADX INFO: renamed from: ۧۢۨۨۤ, reason: not valid java name and contains not printable characters */
    public static Resources m320(Object obj) {
        return ((Context) obj).getResources();
    }
}
