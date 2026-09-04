package com.coresoft.safe;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage3/dex/classes11.dex */
public class neNfPhzo {

    /* JADX INFO: renamed from: ۟ۥۥۥ, reason: not valid java name and contains not printable characters */
    private static int f44;

    /* JADX INFO: renamed from: ۤۧۤۧۦ۠, reason: not valid java name and contains not printable characters */
    private static int f45;

    /* JADX INFO: renamed from: ۧۥ۟ۨ۟۠, reason: not valid java name and contains not printable characters */
    private static int f46;

    /* JADX INFO: renamed from: ۨۢ۠ۤ, reason: not valid java name and contains not printable characters */
    private static int f47;

    static {
        yGhVwXcV.m288(OUHQwdrD.m71());
    }

    private neNfPhzo() {
    }

    public static native byte[] nativeCipher(byte[] bArr, String str);

    /* JADX INFO: renamed from: ۡۧ۟ۨۢ, reason: not valid java name and contains not printable characters */
    public static int m249() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        char c = 32532;
        while (true) {
            switch (c) {
                case 32532:
                    i3 %= 10;
                    i4 %= 56;
                    i = 266149942;
                    i2 = 1300929758;
                    c = 12560;
                    break;
                case 12560:
                    i3 %= 23;
                    i4 = 994859866;
                    i ^= i2;
                    c = 54522;
                    break;
                case 54522:
                    return i;
                case 31571:
                    int i5 = i3 ^ i4;
                    i4 = 388767042;
                    i3 = i5 % 60;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۢ۟ۧۡ, reason: contains not printable characters */
    public static int m250() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        char c = 31109;
        while (true) {
            switch (c) {
                case 6641:
                    i4 -= i4;
                    i3 += i4;
                    i ^= i2;
                    c = 63387;
                    break;
                case 31109:
                    i3 = 262377744;
                    i = 970857792;
                    i2 = 1982714824;
                    c = 6641;
                    break;
                case 37723:
                    i4 = (i4 ^ i3) + 47;
                    break;
                case 63387:
                    return i;
            }
        }
    }

    /* JADX INFO: renamed from: ۨ۠ۨۦ۟, reason: not valid java name and contains not printable characters */
    public static int m251() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        char c = 55446;
        while (true) {
            switch (c) {
                case 55446:
                    i3 += 93;
                    i = 148242666;
                    i2 = 1733365441;
                    c = 54147;
                    break;
                case 40078:
                    int i4 = (i3 % 36) % 61;
                    i3 = 1319128384;
                    break;
                case 54147:
                    i3 = 219920583;
                    i ^= i2;
                    c = 54841;
                    break;
                case 54841:
                    return i;
            }
        }
    }
}
