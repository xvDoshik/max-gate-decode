package com.mobilex.hub;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class Mlgflhnd {
    private static final int fadixegafiv = 0;
    private static final String[] geketepofa = null;

    /* JADX INFO: renamed from: ۢۨ۟۟ۧۥ, reason: not valid java name and contains not printable characters */
    private static int f12;

    /* JADX INFO: renamed from: ۤ۟ۡۨ, reason: not valid java name and contains not printable characters */
    private static int f13;

    /* JADX INFO: renamed from: ۧۧۢۥۦ, reason: not valid java name and contains not printable characters */
    private static long f14;

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0033. Please report as an issue. */
    public static byte[] a(Context context) throws IOException {
        try {
            Z5HFgwkz.m77(347 ^ ((long) z1rBEw9J.f53));
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
                InputStream inputStreamM168 = hv970Gaa.m168(z1rBEw9J.m305(context), z1rBEw9J.m262());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(LinANwu2.f10 ^ (-16826));
                byte[] bArr = new byte[8192];
                while (true) {
                    int iM303 = z1rBEw9J.m303(inputStreamM168, bArr);
                    int i2 = 1740;
                    while (true) {
                        i2 ^= 1757;
                        switch (i2) {
                            case 17:
                                i2 = iM303 != -1 ? 1833 : 1802;
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
                        eRLkMqbO.m104(inputStreamM168);
                        byte[] bArrM48 = Z5HFgwkz.m48(byteArrayOutputStream);
                        int length = bArrM48.length;
                        int iM270 = z1rBEw9J.m270(eRLkMqbO.m108(bArrM48)) + (LinANwu2.f10 ^ (-446));
                        int i3 = length - iM270;
                        byte[] bArr2 = new byte[i3];
                        hv970Gaa.m182(bArrM48, iM270, bArr2, 0, i3);
                        return bArr2;
                    }
                    hv970Gaa.m164(byteArrayOutputStream, bArr, 0, iM303);
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
                    Z5HFgwkz.m59(str);
                    return true;
                case 239:
                    return false;
                default:
                    continue;
            }
            i = 1678;
        }
    }

    /* JADX INFO: renamed from: ۢۨۡۧۤ, reason: not valid java name and contains not printable characters */
    public static int m11() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        char c = 54005;
        while (true) {
            switch (c) {
                case 37534:
                    int i5 = i4 + 65;
                    i3 = (i3 ^ i5) % 51;
                    i4 = i5 % 24;
                    break;
                case 7506:
                    i3 += 10;
                    i ^= i2;
                    c = 49085;
                    break;
                case 49085:
                    return i;
                case 54005:
                    int i6 = i4 - i3;
                    i4 = 80785740;
                    i = 668349484;
                    i2 = 36825943;
                    c = 7506;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦ۠ۥ۠ۢ, reason: contains not printable characters */
    public static int m12() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        char c = 16243;
        while (true) {
            switch (c) {
                case 12573:
                    i3 = 1901652360;
                    i ^= i2;
                    c = 62601;
                    break;
                case 62601:
                    return i;
                case 16243:
                    i3 += 56;
                    i4 += 40;
                    i = 950221097;
                    i2 = 1486775282;
                    c = 12573;
                    break;
                case 8053:
                    i4 = 1539373775 + 1539373775;
                    i3 %= 35;
                    break;
            }
        }
    }
}
