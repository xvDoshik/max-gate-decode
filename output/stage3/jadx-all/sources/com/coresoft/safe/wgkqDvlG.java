package com.coresoft.safe;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage3/dex/classes.dex */
public class wgkqDvlG {
    private static final String[] kiyayod = null;
    private static final int rufahebiv = 0;

    /* JADX INFO: renamed from: ۢۧۦ۠۠ۢ, reason: not valid java name and contains not printable characters */
    private static int f48;

    /* JADX INFO: renamed from: ۤۦۧۦۤۢ, reason: not valid java name and contains not printable characters */
    private static int f49;

    /* JADX INFO: renamed from: ۦ۠۠ۦۥۢ, reason: contains not printable characters */
    private static String f50;

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0033. Please report as an issue. */
    public static byte[] a(Context context) throws IOException {
        try {
            hYNP32vq.m226(347 ^ ((long) yGhVwXcV.f53));
            int i = 1616;
            while (true) {
                i ^= 1633;
                switch (i) {
                    case 14:
                        break;
                    case 49:
                        i = 1647;
                        continue;
                    default:
                        continue;
                }
                InputStream inputStreamM59 = OUHQwdrD.m59(yGhVwXcV.m301(context), yGhVwXcV.m262());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Ny31Pi7Y.f14 ^ (-16826));
                byte[] bArr = new byte[8192];
                while (true) {
                    int iM299 = yGhVwXcV.m299(inputStreamM59, bArr);
                    int i2 = 1740;
                    while (true) {
                        i2 ^= 1757;
                        switch (i2) {
                            case 17:
                                i2 = iM299 != -1 ? 1833 : 1802;
                                break;
                            case 54:
                                break;
                            case 471:
                                break;
                            case 500:
                                break;
                            default:
                                break;
                        }
                        fyhCtVnu.m155(inputStreamM59);
                        byte[] bArrM196 = hYNP32vq.m196(byteArrayOutputStream);
                        int length = bArrM196.length;
                        int iM270 = yGhVwXcV.m270(fyhCtVnu.m158(bArrM196)) + (Ny31Pi7Y.f14 ^ (-446));
                        int i3 = length - iM270;
                        byte[] bArr2 = new byte[i3];
                        OUHQwdrD.m73(bArrM196, iM270, bArr2, 0, i3);
                        return bArr2;
                    }
                    OUHQwdrD.m56(byteArrayOutputStream, bArr, 0, iM299);
                    int i4 = 1864;
                    while (true) {
                        i4 ^= 1881;
                        switch (i4) {
                            case 17:
                                i4 = 48674;
                                break;
                            case 47483:
                                break;
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private static /* synthetic */ boolean b(String str) {
        int i = 1616;
        while (true) {
            i ^= 1633;
            switch (i) {
                case 14:
                    break;
                case 49:
                    if (str != null) {
                        i = 1709;
                    }
                    break;
                case 204:
                    hYNP32vq.m207(str);
                    return true;
                case 239:
                    return false;
                default:
                    continue;
            }
            i = 1678;
        }
    }

    /* JADX INFO: renamed from: ۟۠ۥۢ۟, reason: not valid java name and contains not printable characters */
    public static int m252() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        char c = 54411;
        while (true) {
            switch (c) {
                case 45898:
                    i4 = 633889854;
                    break;
                case 46097:
                    return i;
                case 54411:
                    i4 &= i4;
                    int i5 = i3 % 56;
                    i3 = 2096626654;
                    i = 1951151319;
                    i2 = 1480933427;
                    c = 56249;
                    break;
                case 56249:
                    i3 = 1726342422;
                    i ^= i2;
                    c = 46097;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۦ۟ۢۡ, reason: not valid java name and contains not printable characters */
    public static int m253() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        char c = 48931;
        while (true) {
            switch (c) {
                case 20977:
                    i4 = (i4 + 120) % 56;
                    i ^= i2;
                    c = 54862;
                    break;
                case 54862:
                    return i;
                case 48931:
                    i3 += 66;
                    i = 626671595;
                    i2 = 78548104;
                    c = 20977;
                    break;
                case 40479:
                    i3 <<= 753793041;
                    i4 = 753793041 << 753793041;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢ۟ۢۤۧ, reason: not valid java name and contains not printable characters */
    public static int m254() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        char c = 24179;
        while (true) {
            switch (c) {
                case 30056:
                    return i;
                case 48656:
                    i3 |= i3;
                    i4 %= 43;
                    i ^= i2;
                    c = 30056;
                    break;
                case 24179:
                    i3 = 1816588668;
                    i = 1935257490;
                    i2 = 1145504358;
                    c = 48656;
                    break;
                case 28750:
                    int i5 = i4 % 42;
                    i4 = 1183390847 & 1183390847;
                    break;
            }
        }
    }
}
