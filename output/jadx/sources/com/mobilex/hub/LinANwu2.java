package com.mobilex.hub;

import java.io.ByteArrayOutputStream;
import p000.C0010;

/* JADX INFO: loaded from: classes9.dex */
public class LinANwu2 {

    /* JADX INFO: renamed from: ۟۟ۥۨۢ, reason: not valid java name and contains not printable characters */
    public static int f4 = 1993620854;

    /* JADX INFO: renamed from: ۠۠ۦۢۥ۟, reason: not valid java name and contains not printable characters */
    private static byte[] f5 = null;

    /* JADX INFO: renamed from: ۠ۢۥۢۧ, reason: not valid java name and contains not printable characters */
    private static long f6 = 0;

    /* JADX INFO: renamed from: ۣ۠ۤۤ, reason: not valid java name and contains not printable characters */
    public static int f7 = 1279007263;

    /* JADX INFO: renamed from: ۦ۠ۤۡ۠ۤ, reason: contains not printable characters */
    private static String f8 = null;

    /* JADX INFO: renamed from: ۦۦۡۧۦ, reason: contains not printable characters */
    private static String f9 = null;

    /* JADX INFO: renamed from: ۣۧۥۦ, reason: not valid java name and contains not printable characters */
    public static int f10 = -442;

    /* JADX INFO: renamed from: ۧۨۨۨۤ, reason: not valid java name and contains not printable characters */
    private static String f11;

    /* JADX INFO: renamed from: ۟۠ۤۥ۠, reason: not valid java name and contains not printable characters */
    public static String m2(String str) {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-17, -62, -20, -110, -72, -59, -66, -106}, "4e77cfe6", 0.0f));
        while (true) {
            switch (iM342) {
                case 54155971:
                    int i = f7 * (f4 + 7359);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-23, -58, -21, -109, -66, -111, -18, -111}, "2a01e051", 7));
                    break;
                case 54187621:
                    int i2 = f7 * (f4 | 4116);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-71, -58, -22, -104, -19, -100, -17, -98}, "bc106449f346237a", 4));
                    break;
                case 54240599:
                    int i3 = f7 * (f4 | 8113);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-66, -103, -19, -64, -65, -58, -23, -99}, "e16bde28", false));
                    break;
                case 54242273:
                    int i4 = f7 * (f4 | 6032);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-67, -101, -22, -105, -21, -83, -71, -105}, "f31002b2e9", false));
                    break;
                case 54244475:
                    int i5 = f7 * (f4 ^ 3514);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-22, -60, -67, -58, -70, -101, -23, -63}, "1cfaa92ba12578b4", true));
                    break;
                case 54244479:
                    int i6 = f7 * (f4 + 450);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-17, -87, -20, -108, -66, -111, -18, -62}, "4672e45c669dd2", false));
                    break;
                case 54271298:
                    int i7 = f7 * (f4 + 2931);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-17, -112, -66, -112, -30, -58, -29, -57}, "44e89e8faa2b8f", false));
                    break;
                case 54275103:
                    int i8 = f7 * (f4 | 196);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-70, -97, -22, -105, -19, -59, -20, -5}, "a7166b7df0d9", 6));
                    break;
                case 54299255:
                    int i9 = f7 * (f4 ^ 1621);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-22, -55, -20, -112, -30, -102, -21, -59}, "1a72990f7c078df5", 1));
                    break;
                case 54306786:
                    int i10 = f7 * (f4 + 5874);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-65, -109, -18, -107, -30, -5, -20, -85}, "d1569d74", 0.0f));
                    break;
                case 54336612:
                    String strM3 = m3();
                    int i11 = 0;
                    String strM10 = m10();
                    while (i11 < 15) {
                        strM3 = new StringBuffer().append(strM3).append(Integer.toHexString(i11)).toString();
                        String string = new StringBuffer().append(strM10).append(((int) (Math.random() * ((double) 10))) ^ i11).toString();
                        i11++;
                        strM10 = string;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
                    while (str.length() > 0) {
                        byteArrayOutputStream.write((strM3.indexOf(str.charAt(-2)) << 4) | strM3.indexOf(str.charAt(-1)));
                    }
                    byte[] bArrM341 = C0007.m341(byteArrayOutputStream);
                    int length = bArrM341.length;
                    int length2 = strM10.length();
                    for (int i12 = 0; i12 < length; i12++) {
                        bArrM341[i12] = (byte) (bArrM341[i12] ^ strM10.charAt(i12 % length2));
                    }
                    return new String(bArrM341);
                case 54336738:
                    int i13 = f7 * (f4 ^ 3021);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-24, -61, -65, -103, -17, -110, -19, -105}, "3dd94665", true));
                    break;
                case 54358585:
                    int i14 = f7 * (f4 + 766);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-18, -106, -17, -104, -67, -97, -17, -57}, "5248f74dc982ce"));
                    break;
                case 54388503:
                    int i15 = f7 * (f4 + 6016);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-18, -108, -72, -54, -22, -106, -17, -64}, "51cb124e"));
                    break;
                case 54390330:
                    int i16 = f7 * (f4 | 3891);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-24, -52, -20, -106, -30, -58, -66, -83}, "3d719fe259e53b2e"));
                    break;
                case 54393275:
                    int i17 = f7 * (f4 ^ 4698);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-71, -63, -29, -111, -22, -105, -19, -83}, "bc8010624c8683e2"));
                    break;
                case 54395169:
                    int i18 = f7 * (f4 ^ 7451);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-20, -111, -22, -60, -29, -62, -23, -109}, "721b8f23f0"));
                    break;
                case 54419345:
                    int i19 = f7 * (f4 | 4510);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-20, -111, -22, -62, -71, -59, -17, -4}, "771bbe4cd43af69b", false));
                    break;
                case 54420186:
                    int i20 = f7 * (f4 + 7604);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-70, -59, -19, -97, -72, -112, -70, -59}, "ae67c3"));
                    break;
                case 54420188:
                    int i21 = f7 * (f4 + 310);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-18, -64, -71, -112, -17, -111, -18, -53}, "5cb244", 2));
                    break;
                case 54424869:
                    int i22 = f7 * (f4 ^ 3988);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-70, -109, -70, -111, -22, -104, -21, -105}, "a1a41003aed0f9"));
                    break;
                case 54424894:
                    int i23 = f7 * (f4 + 1257);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-29, -63, -17, -100, -20, -103, -30, -108}, "8c4971946cf0", 4));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۢۧۢۦۦ, reason: not valid java name and contains not printable characters */
    private static String m3() {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-21, -51, -72, -63, -71, -108, -29, -105}, "0ecdb787", 0.0f));
        while (true) {
            switch (iM342) {
                case 54150179:
                    int i = f7 * (f4 ^ 3867);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-22, -98, -23, -101, -72, -90, -65, -88}, "1823c9d746cb", 0.0f));
                    break;
                case 54150303:
                    int i2 = f7 * (f4 ^ 3984);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-29, -110, -23, -59, -18, -52, -24, -62}, "872b5d3f28f57aa5"));
                    break;
                case 54150986:
                    return C0005.m336(ۧ۟ۦ۠۟, 0, 1947346375 ^ C0004.f70, 0);
                case 54151946:
                    int i3 = f7 * (f4 + 7657);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-18, -101, -24, -109, -17, -99, -20, -59}, "5335497a", 1));
                    break;
                case 54241316:
                    int i4 = f7 * (f4 | 414);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-18, -63, -19, -108, -21, -107, -23, -108}, "5f6601248eaf"));
                    break;
                case 54242338:
                    int i5 = f7 * (f4 | 2287);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-66, -64, -66, -112, -19, -84, -65, -107}, "ebe263d6d459", 7));
                    break;
                case 54270336:
                    int i6 = f7 * (f4 ^ 1763);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-29, -107, -72, -59, -22, -86, -67, -111}, "86cb15f9", 3));
                    break;
                case 54275917:
                    int i7 = f7 * (f4 | 42);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-70, -84, -21, -105, -65, -84, -22, -107}, "a306d31273"));
                    break;
                case 54304059:
                    int i8 = f7 * (f4 | 1247);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-67, -84, -24, -60, -70, -100, -24, -64}, "f33da83f8f", 0.0f));
                    break;
                case 54305858:
                    int i9 = f7 * (f4 + 4929);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-70, -87, -20, -106, -24, -90, -66, -106}, "a67439e00008"));
                    break;
                case 54306817:
                    int i10 = f7 * (f4 | 353);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-72, -110, -23, -59, -71, -104, -17, -64}, "c02fb94b579b400b"));
                    break;
                case 54334720:
                    int i11 = f7 * (f4 | 6769);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-70, -87, -70, -62, -72, -111, -66, -108}, "a6abc9e270", 0.0f));
                    break;
                case 54335774:
                    int i12 = f7 * (f4 | 158);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-66, -64, -17, -105, -24, -109, -21, -102}, "ed403709", 0.0f));
                    break;
                case 54359648:
                    int i13 = f7 * (f4 | 3714);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-70, -58, -18, -105, -17, -98, -23, -106}, "ab524624e9", false));
                    break;
                case 54366242:
                    int i14 = f7 * (f4 ^ 4739);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-29, -52, -71, -57, -71, -61, -29, -63}, "8dbeba8d", false));
                    break;
                case 54390423:
                    int i15 = f7 * (f4 + 3365);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-23, -50, -67, -101, -67, -61, -23, -62}, "2ff8fe", true));
                    break;
                case 54420157:
                    int i16 = f7 * (f4 | 2711);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-24, -62, -30, -106, -24, -110, -20, -63}, "3a97377f65", 7));
                    break;
                case 54421241:
                    int i17 = f7 * (f4 + 6453);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-65, -106, -71, -103, -24, -62, -65, -104}, "d0b83a", false));
                    break;
                case 54423066:
                    int i18 = f7 * (f4 | 7498);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-21, -107, -67, -57, -20, -107, -24, -64}, "00fa703d3e6f94f6"));
                    break;
                case 54424062:
                    int i19 = f7 * (f4 | 5754);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-29, -107, -65, -98, -71, -59, -29, -108}, "81d6ba857fd68830", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۥۣۨۤ, reason: not valid java name and contains not printable characters */
    public static String m4(short[] sArr, int i, int i2, int i3) {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-70, -111, -70, -60, -21, -106, -20, -110}, "a1aa0072799f5b0d", 0.0f));
        while (true) {
            switch (iM333) {
                case 54150181:
                    int i4 = f7 * (f4 ^ 5360);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-22, -4, -18, -106, -65, -98, -66, -107}, "1c57d8e313da"));
                    break;
                case 54151202:
                    int i5 = f7 * (f4 | 3709);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-24, -90, -23, -61, -71, -53, -17, -59}, "392ebc4e6f", 0.0f));
                    break;
                case 54156063:
                    int i6 = f7 * (f4 | 5401);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-19, -111, -71, -111, -17, -3, -19, -111}, "64b04b", true));
                    break;
                case 54184831:
                    int i7 = f7 * (f4 ^ 7332);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-17, -85, -18, -104, -22, -58, -67, -54}, "44581bfb5c", 5));
                    break;
                case 54187567:
                    int i8 = f7 * (f4 ^ 1622);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-18, -97, -65, -104, -22, -100, -70, -3}, "59d914abf70a6da9", true));
                    break;
                case 54214656:
                    int i9 = f7 * (f4 + 7714);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-17, -64, -19, -3, -24, -60, -22, -61}, "4b6b3f1ba3d70c14", 0.0f));
                    break;
                case 54238524:
                    int i10 = f7 * (f4 | 3573);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-72, -104, -18, -52, -71, -61, -72, -112}, "c85dbb", false));
                    break;
                case 54243426:
                    int i11 = f7 * (f4 | 7073);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-65, -99, -70, -111, -30, -59, -23, -60}, "d5a69e2d3f13d4", 0.0f));
                    break;
                case 54245346:
                    int i12 = f7 * (f4 ^ 1);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-24, -106, -70, -63, -71, -64, -24, -106}, "34aebe33ba", 2));
                    break;
                case 54247145:
                    int i13 = f7 * (f4 | 1048);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-18, -63, -30, -110, -19, -107, -22, -57}, "5c94601d67", 0.0f));
                    break;
                case 54268255:
                    int i14 = f7 * (f4 ^ 6801);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-24, -112, -29, -58, -24, -64, -20, -108}, "358f3b70c1", 0.0f));
                    break;
                case 54268287:
                    char[] cArr = new char[i2];
                    for (int i15 = 0; i15 < i2; i15++) {
                        cArr[i15] = (char) (sArr[i + i15] ^ i3);
                    }
                    return new String(cArr);
                case 54328861:
                    int i16 = f7 * (f4 | 2768);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-29, -61, -29, -108, -21, -107, -70, -58}, "8f8102aaf7", 4));
                    break;
                case 54329730:
                    int i17 = f7 * (f4 | 4169);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-65, -101, -20, -112, -20, -112, -23, -63}, "d978712ea5cc"));
                    break;
                case 54333762:
                    int i18 = f7 * (f4 ^ 7693);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-19, -99, -23, -63, -18, -110, -70, -60}, "652b57ad", 5));
                    break;
                case 54333824:
                    int i19 = f7 * (f4 | 3188);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-21, -55, -20, -99, -70, -61, -66, -106}, "0a75afe3f026cb8b", true));
                    break;
                case 54359794:
                    int i20 = f7 * (f4 ^ 4846);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-19, -60, -21, -108, -19, -108, -18, -63}, "6a01615f"));
                    break;
                case 54393221:
                    int i21 = f7 * (f4 | 4049);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-29, -97, -71, -101, -30, -61, -67, -108}, "88b39ff69d", 2));
                    break;
                case 54396222:
                    int i22 = f7 * (f4 + 6811);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-20, -112, -71, -4, -30, -64, -19, -112}, "73bc9a64bf"));
                    break;
                case 54421206:
                    int i23 = f7 * (f4 + 3988);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-23, -63, -29, -58, -70, -109, -66, -51}, "2f8ca2ee094ecce1"));
                    break;
                case 54424895:
                    int i24 = f7 * (f4 + 3274);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-23, -64, -71, -84, -19, -58, -29, -106}, "2cb36f8595", 0.0f));
                    break;
                case 54426016:
                    int i25 = f7 * (f4 + 6866);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-17, -104, -66, -60, -66, -112, -66, -108}, "49eae7e7"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۤۥۨ, reason: not valid java name and contains not printable characters */
    public static int m5() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-20, -111, -19, -50, -72, -63, -67, -62}, "746fcffd8a88", 5));
        while (true) {
            switch (iM329) {
                case 54153868:
                    int i = f7 * (f4 ^ 7489);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-24, -112, -19, -106, -66, -62, -19, -101}, "3766ec63fbb3", 0.0f));
                    break;
                case 54179011:
                    int i2 = f7 * (f4 + 432);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-72, -62, -71, -99, -66, -105, -17, -104}, "cab8e64028c5", 2));
                    break;
                case 54180771:
                    int i3 = f7 * (f4 + 524);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-19, -111, -24, -59, -18, -62, -17, -108}, "623b5f42", 0.0f));
                    break;
                case 54180931:
                    int i4 = f7 * (f4 | 178);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-72, -105, -17, -84, -72, -107, -72, -86}, "c543c4"));
                    break;
                case 54213606:
                    int i5 = f7 * (f4 + 2917);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-24, -112, -17, -109, -66, -106, -21, -110}, "3246e705e0b4", 3));
                    break;
                case 54214412:
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    char c = 53885;
                    while (true) {
                        switch (c) {
                            case 14837:
                                return i6;
                            case 29113:
                                i9 = 896770582 + 109;
                                i8 ^= i9;
                                break;
                            case 53885:
                                i9 = (i9 % 37) + 17 + 6;
                                i6 = 965503160;
                                i7 = 201972481;
                                c = 30062;
                                break;
                            case 30062:
                                i8 += 9;
                                i6 ^= i7;
                                c = 14837;
                                break;
                        }
                    }
                    break;
                case 54216451:
                    int i10 = f7 * (f4 + 2416);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-22, -109, -71, -111, -67, -103, -21, -106}, "11b6f106be", 0));
                    break;
                case 54238491:
                    int i11 = f7 * (f4 + 3585);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-23, -97, -22, -58, -22, -106, -65, -99}, "271e17d9c90e6d", 0.0f));
                    break;
                case 54241444:
                    int i12 = f7 * (f4 ^ 6441);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-20, -101, -18, -61, -67, -111, -70, -57}, "785ff9af56b1c079", false));
                    break;
                case 54244265:
                    int i13 = f7 * (f4 | 4605);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-23, -98, -66, -112, -19, -112, -17, -55}, "28e7684a2753", 7));
                    break;
                case 54246397:
                    int i14 = f7 * (f4 | 6073);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-19, -57, -20, -111, -70, -110, -18, -103}, "6e79a259b5"));
                    break;
                case 54247110:
                    int i15 = f7 * (f4 + 1202);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-72, -109, -70, -105, -66, -2, -72, -107}, "c2a2ea", 0.0f));
                    break;
                case 54274057:
                    int i16 = f7 * (f4 | 392);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-30, -103, -22, -59, -67, -59, -18, -58}, "981bff5fdba8", 0.0f));
                    break;
                case 54274267:
                    int i17 = f7 * (f4 ^ 1242);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-66, -63, -29, -110, -67, -60, -70, -61}, "ed80ffac928031", 3));
                    break;
                case 54276070:
                    int i18 = f7 * (f4 | 345);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-18, -110, -67, -58, -17, -58, -18, -105}, "50fd4e", 7));
                    break;
                case 54330779:
                    int i19 = f7 * (f4 + 993);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-19, -104, -24, -87, -72, -64, -21, -112}, "6836cd084d"));
                    break;
                case 54336706:
                    int i20 = f7 * (f4 ^ 2981);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-19, -111, -30, -105, -18, -99, -19, -105}, "609359", 1));
                    break;
                case 54365569:
                    int i21 = f7 * (f4 + 6554);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-72, -6, -24, -109, -65, -82, -17, -57}, "ce37d14a", 0));
                    break;
                case 54388416:
                    int i22 = f7 * (f4 + 6004);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-65, -60, -71, -60, -30, -107, -20, -61}, "ddbe917e"));
                    break;
                case 54421086:
                    int i23 = f7 * (f4 + 1614);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-21, -105, -20, -105, -30, -81, -70, -61}, "077690ab", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۢۢ۟, reason: not valid java name and contains not printable characters */
    public static int m6() {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-66, -57, -17, -107, -71, -7, -30, -110}, "ef40bf93b8629b", true));
        while (true) {
            switch (iM317) {
                case 54149154:
                    int i = f7 * (f4 ^ 3252);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-23, -109, -66, -105, -19, -99, -70, -108}, "22e169a50f", false));
                    break;
                case 54149217:
                    int i2 = f7 * (f4 + 3917);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-30, -59, -70, -99, -24, -110, -19, -50}, "9da8336f2f", 0.0f));
                    break;
                case 54153094:
                    int i3 = f7 * (f4 + 1146);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-21, -103, -65, -107, -29, -57, -65, -110}, "08d58dd5d16b517f", true));
                    break;
                case 54156904:
                    int i4 = f7 * (f4 ^ 5778);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-67, -107, -66, -60, -21, -98, -67, -108}, "f0ee08", 0.0f));
                    break;
                case 54183657:
                    int i5 = f7 * (f4 + 2902);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-21, -4, -70, -97, -22, -105, -66, -108}, "0ca813e000a0", true));
                    break;
                case 54209731:
                    int i6 = f7 * (f4 + 1800);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-65, -61, -66, -59, -18, -108, -67, -61}, "daeb56fd1b8602", 4));
                    break;
                case 54214406:
                    int i7 = f7 * (f4 + 7024);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-71, -110, -67, -97, -20, -112, -71, -110}, "b5f872", 0.0f));
                    break;
                case 54214475:
                    int i8 = f7 * (f4 ^ 1250);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-70, -61, -19, -57, -30, -109, -65, -109}, "af6c90d20e404331"));
                    break;
                case 54214658:
                    int i9 = f7 * (f4 + 4978);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-72, -88, -22, -82, -66, -101, -70, -59}, "c711e9aa", false));
                    break;
                case 54215522:
                    int i10 = f7 * (f4 | 5211);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-70, -62, -66, -99, -22, -81, -70, -59}, "ace510", 0.0f));
                    break;
                case 54217294:
                    int i11 = f7 * (f4 | 7863);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-22, -82, -22, -111, -17, -105, -66, -98}, "111242e98faa6e", false));
                    break;
                case 54238434:
                    int i12 = f7 * (f4 + 5967);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-65, -112, -30, -110, -23, -58, -22, -57}, "d4972d1e72e2", 0.0f));
                    break;
                case 54243359:
                    int i13 = f7 * (f4 + 4889);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-23, -2, -23, -7, -71, -109, -65, -111}, "2a2fb7d49082c2", true));
                    break;
                case 54246187:
                    int i14 = f7 * (f4 ^ 7552);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-18, -64, -24, -7, -70, -2, -22, -110}, "5b3faa167fbd", false));
                    break;
                case 54246218:
                    int i15 = f7 * (f4 ^ 5242);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-65, -111, -17, -58, -21, -57, -72, -62}, "d34b0dcb08615a", 0.0f));
                    break;
                case 54303873:
                    int i16 = f7 * (f4 + 6589);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-22, -104, -22, -58, -17, -4, -65, -62}, "181b4cdf"));
                    break;
                case 54329946:
                    int i17 = f7 * (f4 ^ 2100);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-65, -103, -24, -110, -65, -106, -65, -99}, "d837d1", 0.0f));
                    break;
                case 54332733:
                    int i18 = f7 * (f4 | 2462);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-29, -53, -21, -64, -70, -107, -70, -64}, "8c0ba3ab", true));
                    break;
                case 54363367:
                    int i19 = 0;
                    int i20 = 0;
                    int i21 = 0;
                    int i22 = 0;
                    char c = 5036;
                    while (true) {
                        switch (c) {
                            case 5036:
                                i21 *= i22;
                                i22 += 123;
                                i19 = 70553415;
                                i20 = 368555370;
                                c = 39524;
                                break;
                            case 29414:
                                i21 = 513866113;
                                i22 %= 19;
                                break;
                            case 39524:
                                i21 <<= i21;
                                i19 ^= i20;
                                c = 12851;
                                break;
                            case 12851:
                                return i19;
                        }
                    }
                    break;
                case 54395173:
                    int i23 = f7 * (f4 ^ 3346);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-29, -54, -70, -61, -65, -111, -21, -63}, "8baad20f", 6));
                    break;
                case 54420190:
                    int i24 = f7 * (f4 + 6645);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-29, -111, -21, -105, -23, -105, -66, -112}, "830026e7b351", 0.0f));
                    break;
                case 54420278:
                    int i25 = f7 * (f4 | 4067);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-29, -98, -65, -108, -29, -5, -29, -97}, "88d18d", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۦۧۥ, reason: not valid java name and contains not printable characters */
    public static int m7() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-23, -63, -24, -62, -21, -60, -23, -60}, "2a3a0c"));
        while (true) {
            switch (iM347) {
                case 54154946:
                    int i = f7 * (f4 | 5134);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-66, -64, -72, -97, -67, -50, -70, -64}, "ecc7ffade3", 0.0f));
                    break;
                case 54179003:
                    int i2 = f7 * (f4 ^ 4719);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-67, -111, -20, -105, -23, -7, -24, -58}, "f7762f3a"));
                    break;
                case 54182945:
                    int i3 = f7 * (f4 | 2098);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-70, -106, -65, -106, -67, -61, -72, -60}, "a7d5fcca471d", true));
                    break;
                case 54183687:
                    int i4 = f7 * (f4 + 6527);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-20, -105, -20, -103, -71, -109, -66, -111}, "7478b5e90974", true));
                    break;
                case 54183906:
                    int i5 = f7 * (f4 ^ 3265);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-72, -64, -65, -106, -23, -105, -18, -108}, "cfd52050"));
                    break;
                case 54184713:
                    int i6 = f7 * (f4 ^ 4415);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-72, -59, -71, -98, -29, -64, -72, -63}, "cab68fcb4d622b", true));
                    break;
                case 54212519:
                    int i7 = f7 * (f4 + 6645);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-20, -61, -20, -61, -23, -97, -20, -51}, "7e7d27", true));
                    break;
                case 54269312:
                    int i8 = f7 * (f4 + 1214);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-23, -97, -19, -109, -67, -97, -18, -111}, "2867f7543de5caf8", 0.0f));
                    break;
                case 54270368:
                    int i9 = f7 * (f4 | 5838);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-21, -106, -23, -4, -22, -108, -21, -106}, "062c1006d5", 4));
                    break;
                case 54273122:
                    int i10 = f7 * (f4 + 725);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-19, -60, -29, -110, -65, -108, -70, -61}, "6d87d6ae0db5", 7));
                    break;
                case 54276131:
                    int i11 = f7 * (f4 | 395);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-72, -89, -70, -109, -30, -107, -72, -89}, "c8a696", 7));
                    break;
                case 54277153:
                    int i12 = f7 * (f4 + 6465);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-65, -58, -23, -111, -65, -101, -24, -63}, "de25d93ba4e425", true));
                    break;
                case 54306881:
                    return (-474) ^ z1rBEw9J.f53;
                case 54333785:
                    int i13 = f7 * (f4 | 4170);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-22, -98, -66, -59, -24, -63, -65, -110}, "19ed3ed19c85acc7"));
                    break;
                case 54334591:
                    int i14 = f7 * (f4 ^ 2931);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-29, -109, -71, -62, -18, -97, -19, -57}, "83bf586beb"));
                    break;
                case 54334785:
                    int i15 = f7 * (f4 + 1152);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-17, -110, -23, -106, -17, -105, -66, -88}, "452043e758b6", 6));
                    break;
                case 54359523:
                    int i16 = f7 * (f4 ^ 7424);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-65, -106, -30, -97, -71, -109, -20, -97}, "d399b4787fd1", 2));
                    break;
                case 54361690:
                    int i17 = f7 * (f4 + 4660);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-21, -104, -23, -106, -67, -108, -22, -58}, "0822f41eed4b", 0.0f));
                    break;
                case 54365569:
                    int i18 = f7 * (f4 + 3085);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-22, -107, -23, -61, -22, -103, -71, -61}, "122d11bc08aa"));
                    break;
                case 54389465:
                    int i19 = f7 * (f4 | 458);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-22, -57, -71, -107, -20, -103, -19, -89}, "1bb378681101"));
                    break;
                case 54392474:
                    int i20 = f7 * (f4 + 2378);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-71, -64, -18, -112, -23, -61, -71, -58}, "bc572e"));
                    break;
                case 54394266:
                    int i21 = f7 * (f4 | 1016);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-22, -62, -29, -110, -20, -62, -21, -105}, "1a827a0161"));
                    break;
                case 54395352:
                    int i22 = f7 * (f4 | 4397);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-22, -108, -30, -106, -24, -97, -24, -7}, "1193393f", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۧۢۤ, reason: not valid java name and contains not printable characters */
    public static int m8() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-67, -89, -23, -60, -21, -109, -29, -59}, "f82b038fadf832", 3));
        while (true) {
            switch (iM315) {
                case 54152125:
                    int i = f7 * (f4 ^ 7729);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-30, -59, -22, -63, -72, -106, -21, -50}, "9c1fc30f"));
                    break;
                case 54155009:
                    int i2 = f7 * (f4 | 1409);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-72, -102, -30, -105, -17, -86, -66, -106}, "c99045e2", 5));
                    break;
                case 54155818:
                    int i3 = f7 * (f4 + 7541);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-23, -99, -29, -98, -19, -6, -17, -59}, "25896e4c3c", 0));
                    break;
                case 54208672:
                    int i4 = f7 * (f4 | 1451);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-71, -105, -22, -58, -70, -108, -29, -82}, "b51ba281", false));
                    break;
                case 54212545:
                    int i5 = f7 * (f4 | 7698);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-23, -112, -18, -109, -23, -63, -22, -86}, "24572b1561"));
                    break;
                case 54243451:
                    int i6 = f7 * (f4 | 441);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-18, -58, -20, -57, -72, -103, -18, -58}, "5e7ec9"));
                    break;
                case 54243453:
                    int i7 = f7 * (f4 | 7313);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-72, -105, -72, -90, -21, -110, -22, -109}, "c2c90711f939", 0.0f));
                    break;
                case 54244421:
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    char c = 39087;
                    while (true) {
                        switch (c) {
                            case 38161:
                                int i12 = i11 << (i10 + 16);
                                i10 = 466777271;
                                i11 = i12 % 13;
                                break;
                            case 39087:
                                i10 += 75;
                                i8 = 1279260155;
                                i9 = 459521186;
                                c = 61956;
                                break;
                            case 53341:
                                return i8;
                            case 61956:
                                i11 += 29;
                                i10 %= 53;
                                i8 ^= i9;
                                c = 53341;
                                break;
                        }
                    }
                    break;
                case 54245349:
                    int i13 = f7 * (f4 + 4517);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-23, -107, -65, -106, -70, -110, -21, -106}, "27d2a4071962773e", true));
                    break;
                case 54245440:
                    int i14 = f7 * (f4 + 2460);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-19, -108, -72, -7, -23, -62, -71, -106}, "65cf2bb4599f1a", true));
                    break;
                case 54246400:
                    int i15 = f7 * (f4 ^ 7210);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-20, -107, -71, -105, -29, -110, -71, -52}, "77b284bd2633", 0));
                    break;
                case 54271138:
                    int i16 = f7 * (f4 ^ 5412);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-20, -112, -66, -105, -66, -61, -19, -109}, "77e5ef6608", 3));
                    break;
                case 54275913:
                    int i17 = f7 * (f4 ^ 5073);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-23, -3, -66, -57, -18, -100, -22, -82}, "2bee5911408d8c", 1));
                    break;
                case 54302139:
                    int i18 = f7 * (f4 + 1162);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-67, -110, -66, -61, -29, -55, -66, -106}, "f0ed8ae56a", true));
                    break;
                case 54302940:
                    int i19 = f7 * (f4 + 7401);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-65, -58, -19, -4, -72, -111, -23, -106}, "dc6cc420afb123eb", 7));
                    break;
                case 54327991:
                    int i20 = f7 * (f4 ^ 7517);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-24, -98, -17, -57, -72, -109, -70, -110}, "364bc4a089d03c"));
                    break;
                case 54327995:
                    int i21 = f7 * (f4 ^ 7496);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-72, -102, -18, -110, -21, -64, -72, -60}, "c8540ecb", 0.0f));
                    break;
                case 54360570:
                    int i22 = f7 * (f4 ^ 4847);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-20, -62, -18, -99, -20, -105, -65, -61}, "7d5877db", 0.0f));
                    break;
                case 54363392:
                    int i23 = f7 * (f4 | 6744);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-23, -101, -70, -61, -23, -100, -29, -99}, "29ae24896963", false));
                    break;
                case 54365476:
                    int i24 = f7 * (f4 ^ 3725);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-70, -59, -30, -101, -24, -107, -70, -60}, "ad9834", false));
                    break;
                case 54390459:
                    int i25 = f7 * (f4 ^ 4509);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-24, -82, -21, -64, -22, -58, -18, -59}, "310e1c5efb", 0.0f));
                    break;
                case 54423192:
                    int i26 = f7 * (f4 + 361);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-30, -99, -20, -107, -29, -99, -23, -109}, "99768527", true));
                    break;
                case 54424870:
                    int i27 = f7 * (f4 + 4211);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-70, -60, -71, -64, -18, -64, -24, -104}, "abbb5b385ba6", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۤۤۥ, reason: not valid java name and contains not printable characters */
    public static int m9(Object obj) {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-29, -64, -17, -111, -65, -57, -29, -109}, "8f45df86", 0.0f));
        while (true) {
            switch (iM338) {
                case 54157900:
                    int i = f7 * (f4 + 3883);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-29, -111, -22, -100, -21, -111, -29, -105}, "831803", false));
                    break;
                case 54180897:
                    int i2 = f7 * (f4 | 5187);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-30, -62, -19, -90, -72, -62, -19, -64}, "9e69cb6ca978", 0.0f));
                    break;
                case 54182786:
                    int i3 = f7 * (f4 | 2814);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-66, -109, -65, -63, -22, -57, -71, -63}, "e0da1bbc79baa0", false));
                    break;
                case 54182909:
                    int i4 = f7 * (f4 | 3999);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-70, -59, -71, -59, -20, -61, -66, -103}, "aabf7be8fd"));
                    break;
                case 54208702:
                    int i5 = f7 * (f4 ^ 3047);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-30, -105, -29, -64, -29, -102, -22, -61}, "968b881b", 0));
                    break;
                case 54211616:
                    int i6 = f7 * (f4 ^ 6028);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-20, -106, -24, -62, -29, -101, -17, -98}, "753a8849"));
                    break;
                case 54215583:
                    int i7 = f7 * (f4 ^ 7853);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-23, -108, -30, -106, -66, -64, -23, -107}, "2694eb224c", true));
                    break;
                case 54241413:
                    int i8 = f7 * (f4 + 5508);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-19, -53, -66, -112, -23, -107, -72, -54}, "6ce526cb", 0.0f));
                    break;
                case 54243332:
                    int i9 = f7 * (f4 + 62);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-29, -105, -70, -85, -19, -59, -70, -109}, "86a46da248fe8a", 4));
                    break;
                case 54244232:
                    int i10 = f7 * (f4 ^ 3064);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-65, -7, -29, -55, -29, -99, -20, -50}, "df8a887f9791", false));
                    break;
                case 54246273:
                    int i11 = f7 * (f4 + 3857);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-19, -110, -30, -58, -65, -109, -17, -53}, "679dd44c430dad33"));
                    break;
                case 54269370:
                    int i12 = f7 * (f4 ^ 1526);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-71, -59, -23, -61, -70, -62, -71, -58}, "bb2aaa", 3));
                    break;
                case 54272196:
                    int i13 = f7 * (f4 + 6911);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-24, -57, -18, -112, -19, -110, -30, -59}, "3e57669e352c07", 0.0f));
                    break;
                case 54301919:
                    int i14 = f7 * (f4 ^ 3195);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-70, -107, -67, -103, -30, -98, -66, -107}, "a0f996e0a4"));
                    break;
                case 54329048:
                    int i15 = f7 * (f4 + 6584);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-17, -98, -72, -102, -20, -112, -18, -53}, "46c2705c8155"));
                    break;
                case 54330942:
                    int i16 = f7 * (f4 + 390);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-18, -63, -20, -107, -72, -98, -19, -111}, "5a76c8614c", 0.0f));
                    break;
                case 54362436:
                    int i17 = f7 * (f4 + 3214);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-23, -62, -21, -108, -66, -58, -24, -102}, "2b05ee3994", 3));
                    break;
                case 54362466:
                    int i18 = f7 * (f4 ^ 2808);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-22, -109, -20, -109, -18, -64, -17, -111}, "13705b40", 3));
                    break;
                case 54362468:
                    int i19 = f7 * (f4 | 2205);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-23, -60, -19, -107, -19, -61, -18, -61}, "2e636e5c6e", 2));
                    break;
                case 54387419:
                    int i20 = f7 * (f4 ^ 5339);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-21, -111, -23, -108, -72, -58, -72, -109}, "0321cfc68acccb", 5));
                    break;
                case 54390396:
                    int i21 = f7 * (f4 ^ 2613);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-22, -62, -19, -106, -18, -59, -67, -60}, "1d625efba152"));
                    break;
                case 54423074:
                    return obj.hashCode();
                case 54425864:
                    int i22 = f7 * (f4 ^ 2939);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-72, -97, -65, -99, -30, -108, -22, -58}, "c9d9951a37ff", 4));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۤۥۥۢۧ, reason: not valid java name and contains not printable characters */
    private static String m10() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-65, -85, -29, -58, -66, -106, -71, -109}, "d48be2b2"));
        while (true) {
            switch (iM347) {
                case 54154018:
                    int i = f7 * (f4 + 1922);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-66, -109, -17, -105, -66, -99, -67, -105}, "e143e8f6f54f"));
                    break;
                case 54155012:
                    int i2 = f7 * (f4 | 34);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-30, -58, -22, -85, -21, -100, -17, -110}, "9b140941baac", true));
                    break;
                case 54183877:
                    int i3 = f7 * (f4 ^ 1848);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-21, -108, -71, -63, -29, -108, -30, -107}, "06ba8390ed5b"));
                    break;
                case 54187624:
                    int i4 = f7 * (f4 + 3429);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-23, -62, -29, -62, -21, -61, -21, -106}, "2b8f0e012040a9", 0.0f));
                    break;
                case 54210846:
                    int i5 = f7 * (f4 + 3852);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-17, -61, -65, -107, -65, -61, -30, -105}, "4bd1dd90daf7e857"));
                    break;
                case 54213699:
                    int i6 = f7 * (f4 + 8031);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-21, -101, -71, -99, -22, -111, -19, -100}, "08b81264a0", 3));
                    break;
                case 54216614:
                    int i7 = f7 * (f4 | 7163);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-19, -61, -72, -111, -66, -63, -65, -63}, "6ec0ebdb573568", 4));
                    break;
                case 54239610:
                    int i8 = f7 * (f4 | 3823);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-21, -102, -71, -108, -22, -60, -66, -98}, "08b11ee9f9"));
                    break;
                case 54239644:
                    int i9 = f7 * (f4 | 4904);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-71, -101, -22, -84, -70, -106, -71, -97}, "b813a1", false));
                    break;
                case 54241347:
                    int i10 = f7 * (f4 | 6604);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-65, -107, -19, -107, -24, -63, -20, -109}, "d6653c732b34"));
                    break;
                case 54243422:
                    int i11 = f7 * (f4 ^ 1162);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-70, -59, -23, -97, -19, -59, -29, -101}, "aa286c88c645d464", 4));
                    break;
                case 54244265:
                    int i12 = f7 * (f4 ^ 1532);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-21, -50, -66, -108, -19, -57, -71, -3}, "0fe36fbb"));
                    break;
                case 54246152:
                    int i13 = f7 * (f4 + 5029);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-18, -63, -29, -102, -70, -59, -65, -64}, "5a82afdc10bc938f", 0.0f));
                    break;
                case 54268476:
                    int i14 = f7 * (f4 ^ 5903);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-21, -102, -72, -60, -17, -64, -66, -98}, "02ce4be8f31030", 1));
                    break;
                case 54269275:
                    int i15 = f7 * (f4 + 3639);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-29, -110, -24, -60, -65, -98, -70, -88}, "843fd6a7a6ac", true));
                    break;
                case 54274119:
                    int i16 = f7 * (f4 + 1192);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-30, -60, -18, -58, -66, -51, -30, -51}, "9e5aee"));
                    break;
                case 54298201:
                    return C0005.m336(ۧ۟ۦ۠۟, 0, 1836667357 ^ C0002.f66, 0);
                case 54305920:
                    int i17 = f7 * (f4 ^ 5508);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-24, -102, -17, -57, -19, -105, -24, -101}, "384e67", 6));
                    break;
                case 54359643:
                    int i18 = f7 * (f4 | 4339);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-29, -110, -22, -57, -29, -105, -20, -86}, "851a83759df2af", true));
                    break;
                case 54360755:
                    int i19 = f7 * (f4 | 429);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-67, -110, -65, -62, -30, -57, -20, -110}, "f0db9a7079ee65d1", 2));
                    break;
                case 54394266:
                    int i20 = f7 * (f4 ^ 6920);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-21, -83, -21, -57, -21, -106, -18, -102}, "020b0359c69e16", false));
                    break;
                case 54419197:
                    int i21 = f7 * (f4 ^ 6896);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-18, -106, -72, -61, -24, -98, -17, -109}, "57cb3645", false));
                    break;
                case 54424925:
                    int i22 = f7 * (f4 | 6830);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-18, -106, -67, -105, -22, -109, -29, -105}, "54f01384b54b9b", false));
                    break;
            }
        }
    }
}
