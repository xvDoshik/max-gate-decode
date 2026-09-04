package com.mobilex.hub;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import p000.C0010;

/* JADX INFO: loaded from: classes2.dex */
public class hv970Gaa {

    /* JADX INFO: renamed from: ۟۟ۥۨۢ, reason: not valid java name and contains not printable characters */
    public static int f38 = 631763143;

    /* JADX INFO: renamed from: ۟ۨۦ۠, reason: not valid java name and contains not printable characters */
    private static String f39 = null;

    /* JADX INFO: renamed from: ۠ۦۦۢ, reason: not valid java name and contains not printable characters */
    private static byte[] f40 = null;

    /* JADX INFO: renamed from: ۢ۠۠ۥۦ, reason: not valid java name and contains not printable characters */
    private static byte[] f41 = null;

    /* JADX INFO: renamed from: ۣ۠ۤۤ, reason: not valid java name and contains not printable characters */
    public static int f42 = 1142064384;

    /* JADX INFO: renamed from: ۥ۠ۢۡ, reason: contains not printable characters */
    public static int f43 = -132;

    /* JADX INFO: renamed from: ۥۤۧۥ, reason: contains not printable characters */
    private static String f44;

    /* JADX INFO: renamed from: ۨۡۡۡۨۨ, reason: not valid java name and contains not printable characters */
    private static short[] f45 = {-7047, -7058, -7071, -7083, -7054, -7118, -7108, 925, 1020, 1017, 998, 1010, 896, 940, 899, -27571, -27550, -27544, -27522, -27549, -27547, -27544, -27604, -27553, -27576, -27577, -27604, -27538, -27527, -27547, -27552, -27528, -27604, -27542, -27549, -27522, -27604, -27532, -27596, -27590, 24445, 24395, 24406, 24400, 24413, 24333, 24417, -16117, -16119, -16126, -16119, -16098, -16123, -16113, 13372, 13369, 13364, 13358, 13361, 13363, 13430, 13355, 13345, 13355, 13356, 13373, 13365, 13430, 13338, 13369, 13355, 13373, 13340, 13373, 13344, 13339, 13364, 13369, 13355, 13355, 13332, 13367, 13369, 13372, 13373, 13354, -25738, -25738, -25740, -25745, -25445, -25452, -25442, -25464, -25451, -25453, -25442, -25388, -25445, -25462, -25462, -25388, -25413, -25447, -25458, -25453, -25460, -25453, -25458, -25469, -25426, -25454, -25464, -25441, -25445, -25442, -29460, -29450, -29459, -29442, -29458, -29460, -29444, -29442, -30501, -30508, -30527, -30500, -30525, -30512, -30471, -30500, -30505, -30521, -30508, -30521, -30516, -30491, -30508, -30527, -30499, -30480, -30503, -30512, -30504, -30512, -30501, -30527, -30522, 15208, 15175, 15181, 15184, 23785, 26215, 4927, 4922, 4922, 4895, 4909, 4909, 4923, 4906, 4878, 4927, 4906, 4918, 4895, 4909, 4877, 4918, 4927, 4908, 4923, 4922, 4882, 4919, 4924, 4908, 4927, 4908, 4903, 31850, 31829, 31842, 31860, 31848, 31858, 31861, 31844, 31842, 31860};

    /* JADX INFO: renamed from: ۣ۟۠ۧۦ, reason: not valid java name and contains not printable characters */
    public static byte[] m141(Object obj, Object obj2) {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-67, -104, -29, -7, -70, -58, -67, -106}, "f08faf", 0.0f));
        while (true) {
            switch (iM310) {
                case 54153186:
                    if (m146() < 0) {
                        return IRGXHKLL.nativeCipher((byte[]) obj, (String) obj2);
                    }
                    return null;
                case 54154947:
                    int i = f42 * (f38 | 2532);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-66, -111, -67, -64, -19, -86, -19, -111}, "e4fa656997c7cc", 0.0f));
                    break;
                case 54182854:
                    int i2 = f42 * (f38 ^ 8106);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-67, -53, -29, -58, -71, -83, -67, -4}, "fc8bb2", false));
                    break;
                case 54185732:
                    int i3 = f42 * (f38 + 4648);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-18, -112, -71, -110, -19, -105, -72, -50}, "52b064cf940fed", 0.0f));
                    break;
                case 54213606:
                    int i4 = f42 * (f38 ^ 3344);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-65, -59, -19, -108, -20, -108, -20, -107}, "de677072"));
                    break;
                case 54215493:
                    int i5 = f42 * (f38 ^ 4604);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-21, -112, -65, -107, -22, -108, -21, -111}, "07d416"));
                    break;
                case 54241445:
                    int i6 = f42 * (f38 | 4959);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-70, -111, -24, -57, -29, -111, -19, -108}, "a03a8267", 4));
                    break;
                case 54244350:
                    int i7 = f42 * (f38 | 1852);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-22, -112, -71, -99, -29, -108, -72, -99}, "14b880c57472d738", 0.0f));
                    break;
                case 54303941:
                    int i8 = f42 * (f38 | 2230);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-72, -58, -66, -108, -19, -61, -20, -97}, "cce16b79200a5c"));
                    break;
                case 54329733:
                    int i9 = f42 * (f38 | 8102);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-22, -50, -19, -81, -18, -111, -70, -98}, "1f6054a6", false));
                    break;
                case 54330723:
                    int i10 = f42 * (f38 | 7072);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-23, -112, -65, -55, -19, -110, -17, -107}, "25da6246", 0.0f));
                    break;
                case 54333637:
                    int i11 = f42 * (f38 + 6273);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-66, -57, -71, -58, -19, -98, -70, -57}, "eabf69ac508f9c34"));
                    break;
                case 54336486:
                    int i12 = f42 * (f38 + 1595);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-23, -3, -17, -112, -29, -112, -70, -57}, "2b4388aa", true));
                    break;
                case 54358807:
                    int i13 = f42 * (f38 + 1901);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-21, -99, -65, -106, -18, -103, -19, -110}, "05d0596274e2", 0.0f));
                    break;
                case 54387605:
                    int i14 = f42 * (f38 + 3328);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-21, -105, -72, -97, -71, -63, -21, -107}, "07c9be", 0));
                    break;
                case 54389406:
                    int i15 = f42 * (f38 | 1771);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-30, -55, -67, -100, -70, -7, -22, -59}, "9af9af1e", 0.0f));
                    break;
                case 54391235:
                    int i16 = f42 * (f38 | 167);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-65, -102, -30, -112, -23, -105, -24, -5}, "d895233dca", 5));
                    break;
                case 54417213:
                    int i17 = f42 * (f38 | 2446);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-17, -50, -23, -97, -23, -106, -70, -109}, "4f2825a44204a1", true));
                    break;
                case 54417370:
                    int i18 = f42 * (f38 ^ 725);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-22, -109, -19, -5, -72, -110, -71, -58}, "146dc4be2fbb35", 2));
                    break;
                case 54421980:
                    int i19 = f42 * (f38 | 5012);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-18, -109, -22, -64, -65, -63, -19, -109}, "561bda65", false));
                    break;
                case 54422942:
                    int i20 = f42 * (f38 + 5113);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-22, -107, -71, -105, -67, -57, -66, -111}, "14b3fce6607c", true));
                    break;
                case 54423934:
                    int i21 = f42 * (f38 + 2305);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-20, -85, -24, -109, -67, -106, -67, -106}, "7436f5f6aa", true));
                    break;
                case 54424995:
                    int i22 = f42 * (f38 + 273);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-29, -58, -24, -101, -23, -83, -65, -59}, "8a3822dc64fccd"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۡۥ۟ۤ, reason: not valid java name and contains not printable characters */
    public static void m142(Object obj, Object obj2) throws IOException {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-23, -4, -23, -105, -71, -112, -19, -59}, "2c27b16ce756c24f"));
        while (true) {
            switch (iM323) {
                case 54149211:
                    int i = f42 * (f38 + 5951);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-20, -7, -30, -64, -65, -107, -17, -6}, "7f9fd04e", 0.0f));
                    break;
                case 54150086:
                    int i2 = f42 * (f38 | 6137);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-20, -111, -67, -60, -24, -62, -67, -84}, "74fb3af3a646d2a6", 0.0f));
                    break;
                case 54155969:
                    int i3 = f42 * (f38 | 7142);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-17, -110, -70, -112, -67, -63, -30, -51}, "40a0fa9e265b42e8"));
                    break;
                case 54179132:
                    int i4 = f42 * (f38 + 492);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-65, -111, -66, -57, -21, -101, -30, -7}, "d1ef089f04d6ba46", false));
                    break;
                case 54180002:
                    int i5 = f42 * (f38 + 1752);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-67, -97, -65, -63, -21, -54, -72, -112}, "f8da0bc0c72f4b29", 4));
                    break;
                case 54180893:
                    int i6 = f42 * (f38 ^ 2845);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-21, -105, -19, -111, -22, -111, -19, -59}, "0761146b", false));
                    break;
                case 54182945:
                    if (eRLkMqbO.m105() < 0) {
                        ((FileOutputStream) obj).write((byte[]) obj2);
                        return;
                    }
                    return;
                case 54183778:
                    int i7 = f42 * (f38 | 5402);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-71, -60, -29, -64, -20, -57, -29, -111}, "ba8e7a84", true));
                    break;
                case 54239430:
                    int i8 = f42 * (f38 | 6862);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-66, -105, -67, -60, -66, -112, -65, -99}, "e2fde4d9", 5));
                    break;
                case 54239459:
                    int i9 = f42 * (f38 + 8017);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-18, -111, -21, -102, -19, -108, -18, -106}, "550961564752", 0));
                    break;
                case 54243427:
                    int i10 = f42 * (f38 + 3006);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-29, -110, -66, -63, -66, -108, -21, -106}, "82ebe30310", false));
                    break;
                case 54275014:
                    int i11 = f42 * (f38 | 6237);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-19, -110, -18, -110, -23, -60, -22, -103}, "64532c1113", false));
                    break;
                case 54302042:
                    int i12 = f42 * (f38 | 4498);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-66, -110, -72, -61, -19, -108, -18, -63}, "e7cc675c22dc0771", true));
                    break;
                case 54328890:
                    int i13 = f42 * (f38 | 3964);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-20, -104, -21, -81, -71, -51, -19, -57}, "7800be6bb1", 0));
                    break;
                case 54328923:
                    int i14 = f42 * (f38 | 7896);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-67, -61, -30, -58, -30, -61, -17, -64}, "fa9b9f4f", 6));
                    break;
                case 54333791:
                    int i15 = f42 * (f38 + 6388);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-67, -106, -23, -97, -18, -57, -66, -110}, "f5295fe6", true));
                    break;
                case 54334653:
                    int i16 = f42 * (f38 ^ 7665);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-19, -110, -21, -108, -20, -103, -66, -105}, "600478e1a3e1"));
                    break;
                case 54359772:
                    int i17 = f42 * (f38 | 3984);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-66, -63, -72, -110, -20, -62, -66, -7}, "efc07d"));
                    break;
                case 54364444:
                    int i18 = f42 * (f38 ^ 6135);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-29, -110, -24, -112, -18, -58, -22, -61}, "82345e1bd2", 0.0f));
                    break;
                case 54388625:
                    int i19 = f42 * (f38 + 5735);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-30, -110, -65, -109, -65, -102, -20, -85}, "94d5d974fd22b1", 0.0f));
                    break;
                case 54390484:
                    int i20 = f42 * (f38 | 3891);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-65, -3, -71, -87, -70, -107, -21, -85}, "dbb6a1049e", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۡۥۨۥ, reason: not valid java name and contains not printable characters */
    public static int m143(Object obj) {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-70, -61, -29, -59, -17, -108, -70, -53}, "ac8e43ac1fe2", 0.0f));
        while (true) {
            switch (iM333) {
                case 54149155:
                    int i = f42 * (f38 | 1521);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-19, -108, -66, -6, -22, -111, -18, -60}, "62ee115c00f6fb59", 1));
                    break;
                case 54151142:
                    int i2 = f42 * (f38 | 1265);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-20, -54, -18, -109, -20, -112, -19, -111}, "7b547166", true));
                    break;
                case 54155938:
                    return obj.hashCode();
                case 54180065:
                    int i3 = f42 * (f38 | 7789);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-30, -4, -19, -108, -72, -58, -19, -97}, "9c65cb67fa71"));
                    break;
                case 54215489:
                    int i4 = f42 * (f38 | 6396);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-20, -109, -67, -5, -24, -106, -66, -60}, "75fd30eefc96", 0.0f));
                    break;
                case 54242463:
                    int i5 = f42 * (f38 | 4707);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-66, -86, -24, -112, -30, -110, -24, -87}, "e5369636", 0.0f));
                    break;
                case 54246401:
                    int i6 = f42 * (f38 | 4056);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-29, -61, -30, -108, -29, -112, -21, -83}, "8b92830223d368"));
                    break;
                case 54271328:
                    int i7 = f42 * (f38 + 1841);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-20, -64, -18, -62, -72, -63, -29, -6}, "7e5fcc8e"));
                    break;
                case 54274235:
                    int i8 = f42 * (f38 ^ 2047);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-24, -105, -24, -110, -21, -98, -23, -57}, "3535062ca73822", 7));
                    break;
                case 54275102:
                    int i9 = f42 * (f38 ^ 3743);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-19, -107, -66, -64, -19, -112, -70, -110}, "67ec65a1d8", 6));
                    break;
                case 54332700:
                    int i10 = f42 * (f38 ^ 8114);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-19, -100, -72, -3, -18, -57, -71, -62}, "64cb5dbba4c8"));
                    break;
                case 54333791:
                    int i11 = f42 * (f38 ^ 905);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-24, -59, -23, -57, -20, -111, -20, -108}, "3b2e7071", true));
                    break;
                case 54357632:
                    int i12 = f42 * (f38 ^ 1815);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-72, -107, -67, -111, -29, -97, -65, -98}, "c6f389d97941", false));
                    break;
                case 54357812:
                    int i13 = f42 * (f38 + 1890);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-19, -112, -19, -97, -21, -87, -22, -64}, "6668061c09", 7));
                    break;
                case 54365285:
                    int i14 = f42 * (f38 | 3841);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-19, -59, -21, -106, -24, -63, -20, -90}, "6f003e79d05f", 1));
                    break;
                case 54390335:
                    int i15 = f42 * (f38 | 7297);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-20, -61, -30, -107, -22, -60, -65, -105}, "7d961ad23c4f"));
                    break;
                case 54391420:
                    int i16 = f42 * (f38 + 5028);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-72, -2, -67, -2, -18, -106, -72, -60}, "cafa54", 2));
                    break;
                case 54393252:
                    int i17 = f42 * (f38 + 4053);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-65, -64, -29, -107, -67, -107, -72, -109}, "de80f3c64d0fbe", false));
                    break;
                case 54417300:
                    int i18 = f42 * (f38 ^ 4049);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-29, -110, -23, -63, -72, -111, -29, -111}, "812dc6", false));
                    break;
                case 54424933:
                    int i19 = f42 * (f38 ^ 1422);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-70, -108, -18, -108, -19, -63, -70, -51}, "a3516cae16c562b0", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۡۧۤ, reason: not valid java name and contains not printable characters */
    private static String m144() {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-72, -61, -18, -61, -66, -106, -72, -81}, "cd5ce2c03c23", 0.0f));
        while (true) {
            switch (iM323) {
                case 54152129:
                    int i = f42 * (f38 + 6653);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-29, -62, -71, -110, -22, -109, -24, -81}, "8eb71430257f89", 4));
                    break;
                case 54178948:
                    int i2 = f42 * (f38 + 1300);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-17, -62, -21, -108, -17, -107, -17, -58}, "4a0344"));
                    break;
                case 54209821:
                    int i3 = f42 * (f38 | 6553);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-18, -57, -67, -98, -71, -111, -71, -59}, "5ff6b7be9aacbd60", 5));
                    break;
                case 54211682:
                    int i4 = f42 * (f38 ^ 2789);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-70, -98, -18, -110, -22, -101, -70, -111}, "a95018", 0.0f));
                    break;
                case 54217505:
                    int i5 = f42 * (f38 + 2851);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-72, -58, -24, -63, -19, -97, -66, -64}, "cb3d67ea", 0.0f));
                    break;
                case 54244257:
                    int i6 = f42 * (f38 ^ 4437);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-17, -64, -67, -59, -18, -105, -30, -106}, "4efc5193ce", 0));
                    break;
                case 54269462:
                    int i7 = f42 * (f38 ^ 3402);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-30, -62, -30, -105, -21, -111, -66, -99}, "9d9101e9", 0.0f));
                    break;
                case 54275978:
                    int i8 = f42 * (f38 | 186);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-65, -88, -66, -112, -71, -100, -22, -58}, "d7e2b91e9c0d", 6));
                    break;
                case 54298972:
                    int i9 = f42 * (f38 | 284);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-18, -64, -17, -58, -65, -104, -67, -105}, "5d4cd0f2ea"));
                    break;
                case 54304058:
                    int i10 = f42 * (f38 | 2947);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-70, -110, -18, -110, -29, -57, -72, -109}, "a4558fc08d44", false));
                    break;
                case 54304062:
                    int i11 = f42 * (f38 + 4970);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-70, -101, -71, -110, -20, -90, -22, -62}, "a3b0791e"));
                    break;
                case 54334752:
                    int i12 = f42 * (f38 | 1854);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-24, -98, -65, -111, -65, -102, -66, -105}, "39d7d9e50260", 1));
                    break;
                case 54363642:
                    int i13 = f42 * (f38 ^ 3115);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-72, -107, -19, -4, -20, -63, -67, -112}, "c56c7cf7", 0.0f));
                    break;
                case 54364356:
                    return C0005.m336(f45, 154, 846707886 ^ C0008.f78, 1);
                case 54365347:
                    int i14 = f42 * (f38 ^ 7525);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-22, -57, -24, -62, -65, -90, -22, -4}, "1c3bd9", 7));
                    break;
                case 54366526:
                    int i15 = f42 * (f38 ^ 4300);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-22, -106, -30, -59, -72, -64, -65, -59}, "179ecfda65", 0.0f));
                    break;
                case 54388500:
                    int i16 = f42 * (f38 + 3070);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-24, -106, -71, -112, -30, -98, -20, -109}, "30b5967061e9"));
                    break;
                case 54390400:
                    int i17 = f42 * (f38 ^ 3555);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-23, -61, -29, -112, -17, -104, -29, -90}, "2a85498959", true));
                    break;
                case 54393398:
                    int i18 = f42 * (f38 ^ 4769);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-18, -53, -23, -112, -70, -64, -65, -99}, "5c28acd9a14882"));
                    break;
                case 54394238:
                    int i19 = f42 * (f38 ^ 4203);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-67, -107, -66, -103, -71, -99, -20, -64}, "f3e1b57dec22b0ae", 1));
                    break;
                case 54420066:
                    int i20 = f42 * (f38 ^ 888);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-23, -59, -24, -109, -20, -50, -70, -107}, "2f337fa4"));
                    break;
                case 54425953:
                    int i21 = f42 * (f38 | 116);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-20, -108, -67, -101, -22, -109, -19, -106}, "75f917636673c0", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۟ۡۨۡ, reason: not valid java name and contains not printable characters */
    public static String m145() {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-30, -107, -24, -106, -71, -82, -66, -58}, "9735b1eb41af76", 0.0f));
        while (true) {
            switch (iM342) {
                case 54152068:
                    int i = f42 * (f38 + 2339);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-21, -106, -66, -51, -20, -110, -71, -110}, "07ee71b164a5", 0.0f));
                    break;
                case 54154920:
                    int i2 = f42 * (f38 | 3843);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-66, -58, -20, -105, -67, -50, -70, -98}, "ed76ffa8a60774d6", 0.0f));
                    break;
                case 54179039:
                    int i3 = f42 * (f38 ^ 1100);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-24, -57, -20, -108, -23, -98, -24, -61}, "3b7029"));
                    break;
                case 54181923:
                    int i4 = f42 * (f38 + 312);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-24, -63, -19, -60, -65, -105, -29, -55}, "3b6ad58a", 1));
                    break;
                case 54210845:
                    int i5 = f42 * (f38 | 2569);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-30, -111, -29, -110, -30, -81, -30, -109}, "908590", 3));
                    break;
                case 54216330:
                    int i6 = f42 * (f38 ^ 193);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-71, -86, -72, -111, -18, -111, -20, -100}, "b5c45378a2", false));
                    break;
                case 54217415:
                    if (eRLkMqbO.m105() < 0) {
                        return m155();
                    }
                    return null;
                case 54239422:
                    int i7 = f42 * (f38 | 2371);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-18, -109, -30, -110, -29, -109, -20, -54}, "5790817b4bdb", 0.0f));
                    break;
                case 54240637:
                    int i8 = f42 * (f38 + 6141);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-23, -63, -22, -97, -21, -59, -29, -81}, "2c180f80eb168835"));
                    break;
                case 54242278:
                    int i9 = f42 * (f38 + 5704);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-18, -58, -23, -87, -24, -105, -21, -110}, "5b2631033aa971db", 1));
                    break;
                case 54243328:
                    int i10 = f42 * (f38 + 5096);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-19, -105, -29, -102, -17, -61, -71, -62}, "62884abd8797b6"));
                    break;
                case 54246241:
                    int i11 = f42 * (f38 | 3327);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-70, -63, -71, -107, -23, -62, -66, -61}, "adb12febe1", 6));
                    break;
                case 54269376:
                    int i12 = f42 * (f38 ^ 4988);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-24, -63, -70, -103, -23, -58, -67, -107}, "3ca92ff5ca", 5));
                    break;
                case 54274088:
                    int i13 = f42 * (f38 + 263);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-17, -104, -65, -109, -66, -54, -24, -112}, "49d2eb35b62e", 0.0f));
                    break;
                case 54298230:
                    int i14 = f42 * (f38 + 1126);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-66, -102, -20, -112, -66, -61, -66, -111}, "e970ef", true));
                    break;
                case 54299166:
                    int i15 = f42 * (f38 ^ 941);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-29, -59, -66, -7, -67, -57, -67, -61}, "8eeffbff5a", 1));
                    break;
                case 54300996:
                    int i16 = f42 * (f38 | 3290);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-29, -106, -20, -102, -21, -109, -29, -112}, "867806", 0.0f));
                    break;
                case 54304898:
                    int i17 = f42 * (f38 | 3464);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-19, -102, -29, -62, -17, -3, -24, -105}, "628b4b34cb63c9c9", 6));
                    break;
                case 54330785:
                    int i18 = f42 * (f38 + 2683);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-71, -88, -17, -112, -72, -57, -67, -112}, "b742cdf4afc0", true));
                    break;
                case 54332764:
                    int i19 = f42 * (f38 ^ 5484);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-20, -57, -65, -62, -71, -111, -29, -107}, "7cddb5813ec693", true));
                    break;
                case 54332857:
                    int i20 = f42 * (f38 + 613);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-23, -50, -23, -102, -66, -61, -29, -108}, "2f29eb86", 0.0f));
                    break;
                case 54418140:
                    int i21 = f42 * (f38 | 7648);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-17, -107, -19, -103, -17, -57, -23, -111}, "41694b26", 3));
                    break;
                case 54421084:
                    int i22 = f42 * (f38 ^ 6332);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-19, -63, -71, -107, -71, -102, -18, -111}, "6cb1b851b1f199", 6));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۟ۢۢۡ, reason: not valid java name and contains not printable characters */
    public static int m146() {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-72, -111, -19, -105, -18, -54, -21, -63}, "c6655b0cda41", 0.0f));
        while (true) {
            switch (iM333) {
                case 54151136:
                    int i = f42 * (f38 ^ 4882);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-18, -106, -29, -58, -18, -62, -18, -111}, "558a5b"));
                    break;
                case 54152160:
                    int i2 = f42 * (f38 ^ 6294);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-66, -89, -72, -106, -71, -110, -70, -112}, "e8c7b6a2", 0.0f));
                    break;
                case 54157775:
                    int i3 = f42 * (f38 ^ 6881);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-23, -112, -17, -99, -23, -59, -70, -100}, "28482ca8"));
                    break;
                case 54180994:
                    int i4 = f42 * (f38 + 864);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-19, -101, -23, -111, -19, -104, -71, -108}, "632069b098", 0.0f));
                    break;
                case 54185613:
                    int i5 = f42 * (f38 + 1179);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-20, -110, -65, -59, -71, -51, -29, -106}, "73dcbe87"));
                    break;
                case 54210563:
                    int i6 = f42 * (f38 ^ 4944);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-70, -108, -22, -101, -21, -102, -20, -107}, "a5190270883c"));
                    break;
                case 54211806:
                    int i7 = f42 * (f38 ^ 909);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-24, -62, -30, -62, -24, -108, -67, -58}, "3c9e36fdd4", true));
                    break;
                case 54215646:
                    return (-810) ^ Z5HFgwkz.f23;
                case 54216422:
                    int i8 = f42 * (f38 | 434);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-19, -62, -70, -60, -65, -62, -30, -60}, "6babdb9c", 4));
                    break;
                case 54242279:
                    int i9 = f42 * (f38 ^ 7912);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-71, -4, -30, -104, -23, -60, -19, -62}, "bc902e6e"));
                    break;
                case 54244421:
                    int i10 = f42 * (f38 + 147);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-67, -111, -67, -58, -66, -57, -23, -107}, "f6ffed2700b9c9", true));
                    break;
                case 54270208:
                    int i11 = f42 * (f38 ^ 5477);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-30, -102, -24, -109, -22, -81, -30, -107}, "9830109071"));
                    break;
                case 54271295:
                    int i12 = f42 * (f38 + 6534);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-21, -106, -18, -59, -20, -104, -72, -62}, "055d79ca64a80d", 6));
                    break;
                case 54275944:
                    int i13 = f42 * (f38 ^ 993);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-70, -62, -71, -112, -18, -99, -22, -102}, "aeb858122a2c3a8f", 4));
                    break;
                case 54388472:
                    int i14 = f42 * (f38 ^ 7507);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-72, -106, -72, -103, -21, -98, -23, -59}, "c6c8082b39", 5));
                    break;
                case 54390549:
                    int i15 = f42 * (f38 | 5571);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-19, -112, -23, -106, -21, -5, -24, -111}, "67230d32981292"));
                    break;
                case 54393154:
                    int i16 = f42 * (f38 ^ 6613);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-23, -82, -66, -64, -17, -111, -17, -109}, "21eb4740"));
                    break;
                case 54396228:
                    int i17 = f42 * (f38 + 8182);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-66, -59, -24, -109, -23, -108, -66, -61}, "ef3121", 0.0f));
                    break;
                case 54419164:
                    int i18 = f42 * (f38 + 6049);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-23, -108, -20, -62, -70, -7, -22, -110}, "257caf109e6668"));
                    break;
                case 54423163:
                    int i19 = f42 * (f38 ^ 8101);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-67, -101, -20, -64, -18, -105, -70, -112}, "f97e51a8eb3d"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۟۟ۧۥ, reason: not valid java name and contains not printable characters */
    public static String m147() {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-67, -112, -70, -105, -29, -110, -70, -107}, "f8a285a53fac4f48"));
        while (true) {
            switch (iM338) {
                case 54154923:
                    int i = f42 * (f38 ^ 493);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-29, -111, -17, -61, -19, -63, -29, -62}, "844f6d8fb8", 0.0f));
                    break;
                case 54182974:
                    int i2 = f42 * (f38 + 1869);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-70, -111, -72, -101, -70, -105, -67, -103}, "a1c3a0f1b5ce885d"));
                    break;
                case 54183814:
                    int i3 = f42 * (f38 | 6077);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-70, -107, -72, -106, -66, -107, -70, -105}, "a0c5e3", 0.0f));
                    break;
                case 54187753:
                    if (m146() <= 0) {
                        return Build.MODEL;
                    }
                    return null;
                case 54187780:
                    int i4 = f42 * (f38 + 694);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-17, -60, -20, -109, -65, -106, -20, -86}, "4f76d575", 4));
                    break;
                case 54244319:
                    int i5 = f42 * (f38 | 6771);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-67, -97, -70, -105, -30, -107, -22, -98}, "f7a69419f5e7abfe", 4));
                    break;
                case 54268507:
                    int i6 = f42 * (f38 | 5432);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-70, -109, -17, -112, -19, -107, -65, -107}, "a54464d20f6ddf", 0.0f));
                    break;
                case 54275041:
                    int i7 = f42 * (f38 | 1019);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-23, -112, -20, -108, -72, -111, -23, -86}, "2571c5"));
                    break;
                case 54301018:
                    int i8 = f42 * (f38 | 5505);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-67, -108, -20, -98, -70, -106, -29, -103}, "f076a1883e", 0.0f));
                    break;
                case 54302015:
                    int i9 = f42 * (f38 + 5776);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-65, -87, -66, -109, -67, -106, -17, -108}, "d6e6f443ed5a", 5));
                    break;
                case 54306910:
                    int i10 = f42 * (f38 + 4596);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-72, -62, -71, -59, -72, -61, -66, -59}, "cabccaee", false));
                    break;
                case 54331871:
                    int i11 = f42 * (f38 ^ 6085);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-70, -100, -21, -105, -67, -102, -29, -85}, "a805f984a5", 0.0f));
                    break;
                case 54333723:
                    int i12 = f42 * (f38 ^ 4657);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-66, -110, -67, -107, -18, -64, -22, -112}, "e4f75f141f02250e", 0.0f));
                    break;
                case 54333759:
                    int i13 = f42 * (f38 ^ 0);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-19, -112, -23, -112, -19, -5, -30, -86}, "68206d951373e806", true));
                    break;
                case 54360698:
                    int i14 = f42 * (f38 | 5841);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-21, -108, -30, -100, -66, -64, -65, -99}, "0399ecd9a1dc", 0.0f));
                    break;
                case 54362468:
                    int i15 = f42 * (f38 ^ 5494);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-65, -62, -24, -111, -17, -98, -18, -112}, "db3946544ccba3"));
                    break;
                case 54391483:
                    int i16 = f42 * (f38 | 5952);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-71, -109, -21, -62, -30, -104, -66, -107}, "b30a90e629167ec8", 0));
                    break;
                case 54393247:
                    int i17 = f42 * (f38 | 8034);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-29, -60, -70, -107, -72, -107, -29, -62}, "8da1c1", false));
                    break;
                case 54393279:
                    int i18 = f42 * (f38 | 1350);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-19, -97, -23, -107, -29, -106, -19, -98}, "682681", true));
                    break;
                case 54418136:
                    int i19 = f42 * (f38 | 7348);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-71, -109, -65, -60, -19, -112, -65, -107}, "b4da62d6a2cb", 2));
                    break;
                case 54419167:
                    int i20 = f42 * (f38 + 3755);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-30, -111, -29, -111, -70, -110, -24, -108}, "9582a630bb4c0e", 7));
                    break;
                case 54423190:
                    int i21 = f42 * (f38 ^ 1755);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-22, -58, -70, -6, -67, -55, -22, -62}, "1eaefa"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤ۟ۤۧ, reason: not valid java name and contains not printable characters */
    public static String m148() {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-24, -98, -70, -83, -66, -100, -72, -58}, "38a2e8cb", true));
        while (true) {
            switch (iM323) {
                case 54154117:
                    if (eRLkMqbO.m105() <= 0) {
                        return m178();
                    }
                    return null;
                case 54181855:
                    int i = f42 * (f38 ^ 5955);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-18, -104, -20, -110, -24, -101, -71, -63}, "507533bdb965", false));
                    break;
                case 54211588:
                    int i2 = f42 * (f38 | 4117);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-21, -52, -65, -97, -30, -106, -29, -60}, "0dd9948d3b"));
                    break;
                case 54213483:
                    int i3 = f42 * (f38 + 7667);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-21, -61, -29, -52, -21, -110, -24, -64}, "0a8d043f36", 0.0f));
                    break;
                case 54214500:
                    int i4 = f42 * (f38 ^ 5696);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-17, -63, -72, -107, -22, -105, -70, -90}, "4fc216a92270", true));
                    break;
                case 54247302:
                    int i5 = f42 * (f38 | 7763);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-67, -103, -22, -60, -23, -107, -67, -108}, "f11c27", 0.0f));
                    break;
                case 54270359:
                    int i6 = f42 * (f38 | 170);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-17, -112, -67, -107, -65, -61, -19, -108}, "43f0dd64807e5f", 0.0f));
                    break;
                case 54271106:
                    int i7 = f42 * (f38 + 5950);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-67, -64, -21, -110, -17, -63, -24, -105}, "fd074c33", false));
                    break;
                case 54274235:
                    int i8 = f42 * (f38 ^ 4503);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-65, -108, -65, -57, -18, -59, -30, -106}, "d7db5b976177", true));
                    break;
                case 54274236:
                    int i9 = f42 * (f38 | 2864);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-17, -63, -66, -103, -67, -59, -65, -102}, "4ee9fcd8a296bb", 0.0f));
                    break;
                case 54299192:
                    int i10 = f42 * (f38 | 8039);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-21, -109, -22, -111, -72, -88, -20, -102}, "0013c778ad", true));
                    break;
                case 54300127:
                    int i11 = f42 * (f38 ^ 7401);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-70, -103, -65, -99, -21, -83, -70, -108}, "a1d802"));
                    break;
                case 54303875:
                    int i12 = f42 * (f38 | 3624);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-72, -112, -67, -57, -30, -111, -18, -107}, "c4ff9452fa057d91", 0));
                    break;
                case 54357753:
                    int i13 = f42 * (f38 + 1420);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-19, -61, -29, -64, -30, -62, -19, -61}, "6c8b9a", 6));
                    break;
                case 54366304:
                    int i14 = f42 * (f38 ^ 5219);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-18, -111, -17, -106, -24, -108, -72, -62}, "504435cfd4", true));
                    break;
                case 54394206:
                    int i15 = f42 * (f38 ^ 1747);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-20, -59, -17, -97, -65, -108, -17, -90}, "7c47d549c921060b"));
                    break;
                case 54395134:
                    int i16 = f42 * (f38 + 7200);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-30, -97, -22, -101, -30, -64, -21, -5}, "98139d0dba72e445", 0.0f));
                    break;
                case 54396188:
                    int i17 = f42 * (f38 + 2085);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-30, -111, -24, -108, -20, -111, -19, -3}, "9235776b4c85", 2));
                    break;
                case 54422947:
                    int i18 = f42 * (f38 | 7247);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-21, -7, -23, -100, -20, -60, -21, -63}, "0f287c", 0.0f));
                    break;
                case 54423996:
                    int i19 = f42 * (f38 + 3654);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-17, -110, -70, -62, -24, -103, -23, -111}, "43af3929796be1"));
                    break;
                case 54424962:
                    int i20 = f42 * (f38 + 3014);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-70, -112, -21, -109, -23, -63, -20, -63}, "a1062c7c417c2516"));
                    break;
                case 54425148:
                    int i21 = f42 * (f38 + 7692);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-23, -97, -20, -61, -29, -60, -20, -104}, "287e8f7947", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۟ۤۢۧ, reason: not valid java name and contains not printable characters */
    public static Method m149(Object obj, Object obj2, Object obj3) {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-72, -58, -30, -60, -20, -112, -19, -59}, "cb9c726ca9ce0b", 0.0f));
        while (true) {
            switch (iM342) {
                case 54152161:
                    int i = f42 * (f38 ^ 1562);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-21, -109, -72, -59, -65, -107, -21, -104}, "00ced6", 2));
                    break;
                case 54183661:
                    int i2 = f42 * (f38 + 2593);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-19, -60, -21, -98, -65, -98, -19, -64}, "6b08d8", 7));
                    break;
                case 54186539:
                    int i3 = f42 * (f38 ^ 190);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-30, -50, -22, -87, -17, -50, -29, -112}, "9f164f802697"));
                    break;
                case 54187653:
                    int i4 = f42 * (f38 | 2560);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-18, -105, -22, -62, -67, -112, -67, -107}, "551cf7f6045171c0"));
                    break;
                case 54210600:
                    int i5 = f42 * (f38 | 2596);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-29, -60, -23, -97, -22, -50, -67, -85}, "8b281ff4961c53", 0.0f));
                    break;
                case 54212700:
                    int i6 = f42 * (f38 | 7740);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-20, -105, -72, -59, -20, -58, -66, -100}, "72cd7ce8ee03bd"));
                    break;
                case 54216396:
                    int i7 = f42 * (f38 | 6568);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-67, -64, -71, -112, -71, -64, -18, -111}, "fab3bf5184", 5));
                    break;
                case 54240603:
                    int i8 = f42 * (f38 | 4274);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-70, -112, -66, -7, -30, -111, -17, -60}, "a5ef964ac7", 4));
                    break;
                case 54247149:
                    int i9 = f42 * (f38 | 2764);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-29, -109, -22, -59, -20, -104, -72, -112}, "821d78c8", 0));
                    break;
                case 54269314:
                    int i10 = f42 * (f38 ^ 4729);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-29, -112, -18, -105, -70, -111, -66, -105}, "8652a4e073015d", 0.0f));
                    break;
                case 54302080:
                    int i11 = f42 * (f38 | 7525);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-71, -106, -19, -98, -19, -99, -18, -59}, "b666695dbfea", false));
                    break;
                case 54305799:
                    int i12 = f42 * (f38 + 6362);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-71, -60, -71, -60, -29, -63, -71, -62}, "bcba8f", false));
                    break;
                case 54328056:
                    int i13 = f42 * (f38 | 5711);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-22, -61, -23, -110, -66, -90, -66, -110}, "1c25e9e129"));
                    break;
                case 54329915:
                    int i14 = f42 * (f38 ^ 4547);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-18, -57, -17, -63, -21, -57, -70, -61}, "5c4b0aade731", 0));
                    break;
                case 54335552:
                    int i15 = f42 * (f38 + 7932);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-18, -109, -66, -86, -17, -63, -23, -101}, "54e54e29d4c0", false));
                    break;
                case 54363553:
                    int i16 = f42 * (f38 ^ 1762);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-21, -97, -18, -90, -22, -102, -21, -90}, "085912093b6d65", true));
                    break;
                case 54364540:
                    int i17 = f42 * (f38 ^ 2531);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-17, -64, -72, -107, -22, -64, -18, -86}, "4ec21a55c1f27f"));
                    break;
                case 54365560:
                    int i18 = f42 * (f38 | 5022);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-24, -60, -67, -62, -66, -4, -71, -52}, "3dffecbd2162f071"));
                    break;
                case 54387542:
                    int i19 = f42 * (f38 + 6484);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-30, -6, -65, -110, -19, -57, -17, -58}, "9ed06a4b7338eba4", 0.0f));
                    break;
                case 54387663:
                    int i20 = f42 * (f38 + 6231);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-71, -112, -24, -58, -70, -105, -71, -106}, "b13aa6", true));
                    break;
                case 54393400:
                    int i21 = f42 * (f38 + 3373);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-18, -106, -71, -111, -70, -62, -71, -50}, "54b9acbf6b"));
                    break;
                case 54417455:
                    if (Z5HFgwkz.m63() >= 0) {
                        return C0009.m351((Class) obj, (String) obj2, (Class[]) obj3);
                    }
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤۢۥۧۨ, reason: not valid java name and contains not printable characters */
    private static String m150() {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-19, -104, -72, -110, -22, -108, -24, -54}, "60c3133b39", 4));
        while (true) {
            switch (iM317) {
                case 54149313:
                    int i = f42 * (f38 + 118);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-17, -60, -72, -63, -18, -106, -22, -64}, "4cce541db7", 3));
                    break;
                case 54153900:
                    int i2 = f42 * (f38 | 5868);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-19, -97, -65, -60, -65, -106, -23, -59}, "67dfd62f190e64", 0.0f));
                    break;
                case 54208893:
                    int i3 = f42 * (f38 + 3768);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-20, -108, -24, -106, -65, -62, -29, -87}, "7232de86c3a81c67", 2));
                    break;
                case 54209817:
                    int i4 = f42 * (f38 | 3640);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-67, -63, -71, -105, -70, -110, -29, -106}, "fcb1a783", true));
                    break;
                case 54241473:
                    int i5 = f42 * (f38 ^ 2741);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-20, -59, -18, -57, -66, -111, -24, -59}, "7c5fe93a", 0.0f));
                    break;
                case 54245348:
                    int i6 = f42 * (f38 + 4749);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-70, -97, -23, -57, -72, -58, -23, -64}, "a92eca2e", true));
                    break;
                case 54246246:
                    int i7 = f42 * (f38 | 5602);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-67, -112, -70, -112, -30, -107, -29, -63}, "f2a2918d6e", 2));
                    break;
                case 54299941:
                    int i8 = f42 * (f38 + 2745);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-22, -54, -70, -110, -66, -105, -29, -107}, "1ba3e582a802f83e"));
                    break;
                case 54304059:
                    int i9 = f42 * (f38 ^ 19);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-66, -61, -29, -97, -29, -101, -67, -98}, "ed8789f9314cd9", 0.0f));
                    break;
                case 54333732:
                    int i10 = f42 * (f38 + 4532);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-24, -107, -70, -105, -23, -57, -71, -57}, "37a02dbccd", false));
                    break;
                case 54334565:
                    int i11 = f42 * (f38 ^ 7993);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-19, -111, -72, -59, -67, -108, -65, -104}, "60cef2d8daaf1a"));
                    break;
                case 54334595:
                    int i12 = f42 * (f38 ^ 7962);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-23, -64, -22, -60, -67, -86, -24, -112}, "2d1ef537baeff273"));
                    break;
                case 54359799:
                    return C0005.m336(f45, 153, 1061067665 ^ C0009.f80, 0);
                case 54360730:
                    int i13 = f42 * (f38 ^ 3622);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-18, -106, -66, -6, -23, -63, -23, -61}, "57ee2f2e7dbbb6", 0));
                    break;
                case 54362646:
                    int i14 = f42 * (f38 + 281);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-22, -60, -17, -110, -19, -111, -30, -63}, "1b45609f17", 0.0f));
                    break;
                case 54365351:
                    int i15 = f42 * (f38 + 2461);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-30, -63, -19, -111, -20, -103, -29, -58}, "9d67788e2832a1", 2));
                    break;
                case 54392287:
                    int i16 = f42 * (f38 ^ 6379);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-17, -108, -29, -57, -24, -98, -65, -106}, "408b36d4", 7));
                    break;
                case 54396134:
                    int i17 = f42 * (f38 | 6698);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-67, -89, -30, -59, -29, -106, -67, -97}, "f89a86", 3));
                    break;
                case 54419198:
                    int i18 = f42 * (f38 ^ 1437);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-29, -6, -21, -85, -29, -59, -29, -51}, "8e048b", 0.0f));
                    break;
                case 54419354:
                    int i19 = f42 * (f38 | 5174);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-30, -64, -19, -60, -71, -61, -30, -107}, "9e6bbc917252", 2));
                    break;
                case 54420093:
                    int i20 = f42 * (f38 + 1806);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-20, -108, -20, -109, -22, -59, -66, -50}, "71761aeffb", 2));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤۦ۟۟, reason: not valid java name and contains not printable characters */
    public static String m151(Object obj) {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-67, -82, -23, -52, -23, -50, -30, -108}, "f12d2f975d1cd3", false));
        while (true) {
            switch (iM342) {
                case 54152226:
                    int i = f42 * (f38 ^ 1296);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-24, -55, -30, -57, -70, -5, -67, -61}, "3a9fadfd0427", 0.0f));
                    break;
                case 54154110:
                    int i2 = f42 * (f38 ^ 3891);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-72, -59, -67, -99, -17, -82, -17, -110}, "caf5414682f3"));
                    break;
                case 54154145:
                    int i3 = f42 * (f38 + 287);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-23, -107, -65, -64, -65, -6, -70, -61}, "22dedeae"));
                    break;
                case 54157988:
                    int i4 = f42 * (f38 ^ 4026);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-22, -108, -18, -7, -67, -104, -29, -5}, "165ff08d", 6));
                    break;
                case 54179009:
                    int i5 = f42 * (f38 ^ 3415);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-17, -57, -29, -106, -70, -112, -72, -89}, "4f87a0c8", true));
                    break;
                case 54179963:
                    int i6 = f42 * (f38 + 1313);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-70, -5, -23, -57, -17, -60, -18, -103}, "ad2c4c5957aac7bf", 0.0f));
                    break;
                case 54182761:
                    int i7 = f42 * (f38 + 296);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-66, -107, -66, -111, -17, -98, -30, -89}, "e1e448989078"));
                    break;
                case 54208763:
                    int i8 = f42 * (f38 ^ 5406);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-23, -108, -19, -53, -24, -4, -19, -62}, "216c3c6c816b"));
                    break;
                case 54210591:
                    int i9 = f42 * (f38 ^ 1985);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-67, -110, -29, -112, -30, -57, -30, -105}, "f5879a97948c", 6));
                    break;
                case 54213543:
                    int i10 = f42 * (f38 + 4090);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-22, -112, -24, -64, -17, -105, -66, -85}, "173a43e4", 0.0f));
                    break;
                case 54238708:
                    int i11 = f42 * (f38 + 2196);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-72, -62, -21, -3, -71, -112, -70, -112}, "cc0bb3a05b", 0.0f));
                    break;
                case 54246281:
                    int i12 = f42 * (f38 ^ 3360);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-65, -105, -70, -87, -70, -58, -19, -59}, "d7a6ab6cf5", false));
                    break;
                case 54268317:
                    int i13 = f42 * (f38 ^ 3934);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-21, -63, -21, -62, -30, -64, -21, -82}, "0a0b9d0198db", 0.0f));
                    break;
                case 54303994:
                    int i14 = f42 * (f38 ^ 7983);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-66, -108, -71, -99, -30, -101, -65, -60}, "e5b999db2a", true));
                    break;
                case 54306665:
                    int i15 = f42 * (f38 | 2699);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-29, -61, -72, -99, -21, -105, -70, -106}, "8dc903a0eb49", 0.0f));
                    break;
                case 54336453:
                    int i16 = f42 * (f38 | 1415);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-18, -107, -17, -6, -71, -64, -22, -58}, "564ebb1ead4ca42b", 0));
                    break;
                case 54389461:
                    int i17 = f42 * (f38 ^ 3347);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-29, -109, -30, -98, -22, -107, -17, -52}, "8199114df0", 0.0f));
                    break;
                case 54392351:
                    int i18 = f42 * (f38 | 962);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-22, -81, -29, -100, -29, -98, -70, -99}, "108886a9e951", false));
                    break;
                case 54393157:
                    int i19 = f42 * (f38 | 2321);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-66, -86, -22, -58, -19, -52, -71, -106}, "e51d6db10264de", 2));
                    break;
                case 54395290:
                    if (z1rBEw9J.m266() < 0) {
                        return ((File) obj).getAbsolutePath();
                    }
                    return null;
                case 54419105:
                    int i20 = f42 * (f38 ^ 4826);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-29, -112, -30, -59, -19, -103, -29, -61}, "809f688d581b", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤۦۦ, reason: not valid java name and contains not printable characters */
    public static String m152() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-24, -106, -67, -109, -30, -5, -23, -111}, "35f79d265dc9b2", true));
        while (true) {
            switch (iM347) {
                case 54150178:
                    int i = f42 * (f38 + 5424);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-19, -110, -72, -101, -18, -106, -65, -60}, "61c954dcebd4"));
                    break;
                case 54181952:
                    int i2 = f42 * (f38 | 6915);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-30, -108, -24, -60, -70, -105, -66, -59}, "973da6eaf038b549", 0.0f));
                    break;
                case 54212668:
                    int i3 = f42 * (f38 + 1803);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-23, -110, -18, -59, -29, -64, -17, -106}, "265e8c42ac3c4d27", 0.0f));
                    break;
                case 54243304:
                    int i4 = f42 * (f38 + 5843);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-18, -110, -23, -112, -71, -61, -65, -57}, "5128bdded475d452", 0.0f));
                    break;
                case 54244289:
                    int i5 = f42 * (f38 | 3649);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-24, -101, -17, -62, -30, -111, -24, -106}, "394f9031c3", 7));
                    break;
                case 54269248:
                    int i6 = f42 * (f38 ^ 7429);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-21, -112, -21, -60, -23, -60, -29, -109}, "070b2a877f0ac843", 0.0f));
                    break;
                case 54271204:
                    int i7 = f42 * (f38 ^ 3253);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-65, -109, -71, -61, -71, -62, -18, -99}, "d7babe5880cf9b", 0.0f));
                    break;
                case 54273033:
                    int i8 = f42 * (f38 ^ 7414);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-65, -111, -66, -111, -18, -58, -72, -105}, "d5e15ac5cd79", true));
                    break;
                case 54273245:
                    int i9 = f42 * (f38 | 7084);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-29, -104, -29, -62, -65, -112, -19, -84}, "898ad563c2"));
                    break;
                case 54274143:
                    int i10 = f42 * (f38 | 363);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-70, -59, -30, -106, -29, -61, -19, -57}, "aa908f6cf4", true));
                    break;
                case 54276937:
                    int i11 = f42 * (f38 + 5829);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-19, -61, -19, -58, -29, -107, -19, -57}, "6c6d83", 1));
                    break;
                case 54277120:
                    if (m146() < 0) {
                        return m188();
                    }
                    return null;
                case 54299101:
                    int i12 = f42 * (f38 ^ 4628);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-24, -88, -67, -63, -65, -108, -24, -110}, "37fad0", false));
                    break;
                case 54299223:
                    int i13 = f42 * (f38 + 5575);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-22, -58, -22, -111, -66, -62, -30, -60}, "1e15ed9fca1c2121", 6));
                    break;
                case 54301148:
                    int i14 = f42 * (f38 ^ 5423);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-23, -105, -65, -62, -23, -102, -24, -57}, "20db223ec85d", true));
                    break;
                case 54304929:
                    int i15 = f42 * (f38 ^ 1847);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-22, -110, -22, -110, -70, -58, -70, -105}, "1017ada79c41d8", 2));
                    break;
                case 54336639:
                    int i16 = f42 * (f38 | 2202);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-72, -57, -22, -112, -18, -59, -19, -64}, "ca165e6c8fb129", 0.0f));
                    break;
                case 54364355:
                    int i17 = f42 * (f38 ^ 7966);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-18, -57, -72, -64, -67, -99, -24, -62}, "5dcef93c1506", 0.0f));
                    break;
                case 54388627:
                    int i18 = f42 * (f38 + 4294);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-65, -112, -70, -60, -18, -57, -65, -81}, "d8af5bd07e87988d", 6));
                    break;
                case 54394302:
                    int i19 = f42 * (f38 ^ 3593);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-21, -112, -71, -99, -17, -57, -21, -108}, "05b54b", 0));
                    break;
                case 54420244:
                    int i20 = f42 * (f38 | 1947);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-20, -63, -22, -52, -30, -106, -20, -57}, "7b1d97", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤۨ۠ۦ, reason: not valid java name and contains not printable characters */
    public static String m153() {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-66, -64, -24, -61, -30, -107, -24, -109}, "ee3c91306a", 0.0f));
        while (true) {
            switch (iM333) {
                case 54152193:
                    int i = f42 * (f38 ^ 5052);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-23, -58, -29, -4, -66, -109, -72, -109}, "2a8ce6c13074", 0.0f));
                    break;
                case 54154080:
                    int i2 = f42 * (f38 | 7188);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-65, -98, -23, -112, -72, -111, -65, -112}, "d827c0", 0.0f));
                    break;
                case 54184834:
                    int i3 = f42 * (f38 | 3235);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-70, -54, -23, -105, -67, -58, -67, -58}, "ab23fcfa63", 0.0f));
                    break;
                case 54208705:
                    if (z1rBEw9J.m266() <= 0) {
                        return m173();
                    }
                    return null;
                case 54210813:
                    int i4 = f42 * (f38 ^ 4282);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-67, -107, -18, -112, -66, -104, -21, -111}, "f156e906", 0.0f));
                    break;
                case 54214474:
                    int i5 = f42 * (f38 + 493);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-17, -105, -71, -100, -18, -102, -22, -52}, "41b9521d", 0));
                    break;
                case 54215403:
                    int i6 = f42 * (f38 ^ 272);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-24, -90, -30, -57, -72, -59, -24, -100}, "399ecb", 0.0f));
                    break;
                case 54242552:
                    int i7 = f42 * (f38 ^ 7594);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-70, -101, -24, -110, -17, -58, -29, -109}, "a3304b84"));
                    break;
                case 54243298:
                    int i8 = f42 * (f38 ^ 7243);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-17, -112, -20, -62, -70, -106, -22, -111}, "417da617d38eda1a", false));
                    break;
                case 54270174:
                    int i9 = f42 * (f38 | 8070);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-66, -57, -19, -59, -18, -58, -66, -61}, "ea6c5e", true));
                    break;
                case 54304808:
                    int i10 = f42 * (f38 | 6327);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-70, -106, -21, -107, -21, -106, -22, -111}, "a301071746"));
                    break;
                case 54328922:
                    int i11 = f42 * (f38 | 5515);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-23, -104, -19, -112, -22, -59, -66, -109}, "29611be79dc41d97", 4));
                    break;
                case 54332676:
                    int i12 = f42 * (f38 | 5530);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-71, -107, -29, -111, -20, -62, -71, -106}, "b7857c", true));
                    break;
                case 54363647:
                    int i13 = f42 * (f38 | 5717);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-70, -102, -22, -61, -29, -112, -29, -108}, "a91b8084dd1247", false));
                    break;
                case 54364447:
                    int i14 = f42 * (f38 + 7817);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-20, -97, -65, -110, -24, -109, -30, -52}, "77d5319dcccafd8f", 6));
                    break;
                case 54365352:
                    int i15 = f42 * (f38 + 4120);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-24, -103, -71, -2, -29, -64, -66, -109}, "38ba8ae75c", 0.0f));
                    break;
                case 54366367:
                    int i16 = f42 * (f38 | 2719);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-17, -87, -22, -64, -23, -57, -22, -60}, "461d2a1e", false));
                    break;
                case 54387573:
                    int i17 = f42 * (f38 + 1110);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-72, -59, -23, -60, -21, -110, -65, -112}, "ce2a04d34d", 0.0f));
                    break;
                case 54420221:
                    int i18 = f42 * (f38 + 2548);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-72, -104, -72, -110, -72, -108, -71, -62}, "c0c6c5bf72b68589", 0.0f));
                    break;
                case 54422047:
                    int i19 = f42 * (f38 | 1348);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-19, -62, -20, -99, -17, -106, -65, -62}, "6c7847deb549c2", 0.0f));
                    break;
                case 54422174:
                    int i20 = f42 * (f38 + 5136);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-21, -102, -20, -58, -29, -101, -66, -83}, "087e83e2c8fc"));
                    break;
                case 54424965:
                    int i21 = f42 * (f38 | 5757);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-18, -110, -22, -103, -29, -102, -65, -105}, "541189d73886e9", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۥ۠ۨۧ, reason: not valid java name and contains not printable characters */
    public static void m154(Object obj, boolean z) {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-22, -106, -29, -57, -65, -5, -29, -63}, "158add8dad", 0.0f));
        while (true) {
            switch (iM317) {
                case 54154025:
                    int i = f42 * (f38 + 1558);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-72, -109, -30, -84, -65, -87, -65, -59}, "c793d6db", true));
                    break;
                case 54213544:
                    int i2 = f42 * (f38 + 1119);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-71, -61, -65, -62, -30, -59, -17, -111}, "bdde9d4428e75daf", 1));
                    break;
                case 54244195:
                    int i3 = f42 * (f38 + 5445);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-20, -101, -67, -2, -30, -108, -67, -59}, "78fa96fd020560"));
                    break;
                case 54246214:
                    int i4 = f42 * (f38 | 6791);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-21, -108, -70, -57, -21, -108, -20, -112}, "01ab027150"));
                    break;
                case 54268315:
                    int i5 = f42 * (f38 | 6385);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-66, -54, -67, -63, -24, -90, -70, -105}, "ebfc39a7", false));
                    break;
                case 54274953:
                    int i6 = f42 * (f38 | 5071);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-20, -60, -23, -112, -65, -101, -20, -60}, "7b28d3", 0.0f));
                    break;
                case 54276133:
                    int i7 = f42 * (f38 + 6963);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-71, -98, -23, -106, -65, -111, -71, -104}, "b823d6", 0));
                    break;
                case 54298019:
                    int i8 = f42 * (f38 ^ 4253);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-17, -97, -66, -110, -22, -111, -66, -2}, "49e012ea", true));
                    break;
                case 54305761:
                    int i9 = f42 * (f38 ^ 4235);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-18, -107, -21, -53, -29, -105, -71, -110}, "530c85b6b8a0", 1));
                    break;
                case 54306823:
                    int i10 = f42 * (f38 + 4841);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-67, -58, -29, -104, -72, -63, -67, -58}, "fa88cb", 0.0f));
                    break;
                case 54333787:
                    int i11 = f42 * (f38 | 2612);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-71, -106, -67, -54, -66, -62, -30, -97}, "b2fbef983d4682", 7));
                    break;
                case 54336732:
                    int i12 = f42 * (f38 + 870);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-67, -60, -19, -98, -30, -107, -66, -58}, "ff6997ee", true));
                    break;
                case 54359703:
                    int i13 = f42 * (f38 | 2426);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-20, -99, -22, -55, -23, -104, -70, -111}, "781a20a079a255", 0.0f));
                    break;
                case 54360600:
                    int i14 = f42 * (f38 | 7402);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-29, -60, -24, -100, -22, -7, -23, -86}, "8f391f25", 0.0f));
                    break;
                case 54363608:
                    int i15 = f42 * (f38 ^ 4529);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-22, -107, -21, -104, -18, -102, -19, -98}, "120052683895", true));
                    break;
                case 54366340:
                    int i16 = f42 * (f38 + 913);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-65, -101, -21, -111, -18, -105, -72, -98}, "d80651c9", 1));
                    break;
                case 54366528:
                    int i17 = f42 * (f38 + 1617);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-66, -52, -30, -106, -17, -105, -66, -58}, "ed9145", false));
                    break;
                case 54388477:
                    int i18 = f42 * (f38 ^ 5006);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-71, -85, -66, -62, -29, -107, -29, -52}, "b4ef818d0d"));
                    break;
                case 54395140:
                    int i19 = f42 * (f38 + 3855);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-21, -59, -67, -58, -65, -103, -21, -2}, "0afad8"));
                    break;
                case 54396319:
                    int i20 = f42 * (f38 | 5498);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-24, -108, -19, -112, -21, -109, -66, -62}, "326106ec27"));
                    break;
                case 54420059:
                    if (Z5HFgwkz.m63() >= 0) {
                        C0004.m330((Method) obj, z);
                        return;
                    }
                    return;
                case 54424959:
                    int i21 = f42 * (f38 + 5652);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-24, -110, -20, -110, -18, -107, -67, -106}, "337657f19d58cc", 0));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۥۦۥ, reason: not valid java name and contains not printable characters */
    private static String m155() {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-18, -107, -22, -106, -71, -111, -65, -98}, "5214b3d655853747"));
        while (true) {
            switch (iM342) {
                case 54154829:
                    int i = f42 * (f38 | 6193);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-70, -103, -21, -62, -29, -110, -23, -87}, "a80d87263ba11c"));
                    break;
                case 54154920:
                    int i2 = f42 * (f38 + 6878);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-65, -109, -29, -109, -67, -61, -65, -107}, "d185fa", 0.0f));
                    break;
                case 54184713:
                    int i3 = f42 * (f38 ^ 4256);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-24, -111, -66, -105, -24, -108, -23, -57}, "30e6362e"));
                    break;
                case 54209599:
                    int i4 = f42 * (f38 | 4443);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-70, -105, -65, -111, -72, -105, -19, -108}, "a7d4c562ed5d0650", 6));
                    break;
                case 54210656:
                    int i5 = f42 * (f38 | 5852);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-71, -60, -71, -107, -21, -112, -30, -63}, "bfb2009bdbef3076"));
                    break;
                case 54215551:
                    int i6 = f42 * (f38 | 4804);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-72, -63, -65, -108, -66, -109, -18, -64}, "cdd6e25f2f", 0));
                    break;
                case 54238529:
                    int i7 = f42 * (f38 | 2173);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-20, -63, -21, -58, -30, -54, -24, -104}, "7e0c9b390c1b"));
                    break;
                case 54240475:
                    int i8 = f42 * (f38 ^ 3361);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-30, -99, -70, -90, -20, -105, -72, -110}, "98a970c2badf3d10"));
                    break;
                case 54244230:
                    int i9 = f42 * (f38 ^ 3543);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-70, -87, -30, -60, -29, -88, -70, -112}, "a69a87", 0.0f));
                    break;
                case 54245254:
                    return C0005.m336(f45, 0, 1400305845 ^ C0002.f66, 7);
                case 54246152:
                    int i10 = f42 * (f38 | 3327);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-17, -112, -22, -108, -29, -53, -17, -109}, "47178c", 0.0f));
                    break;
                case 54269306:
                    int i11 = f42 * (f38 + 7506);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-21, -102, -71, -103, -72, -57, -23, -81}, "08b8cd20112a211d", 6));
                    break;
                case 54304058:
                    int i12 = f42 * (f38 ^ 6269);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-70, -110, -72, -100, -19, -107, -24, -57}, "a0c9653d", 7));
                    break;
                case 54305981:
                    int i13 = f42 * (f38 | 4221);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-72, -62, -72, -63, -71, -112, -72, -61}, "cdcdb8"));
                    break;
                case 54328051:
                    int i14 = f42 * (f38 ^ 6147);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-29, -58, -65, -105, -30, -61, -70, -63}, "8cd09bace265", true));
                    break;
                case 54330754:
                    int i15 = f42 * (f38 | 5534);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-29, -97, -18, -58, -18, -111, -19, -62}, "895f576cc1d1c9fe", true));
                    break;
                case 54335555:
                    int i16 = f42 * (f38 + 2159);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-24, -107, -67, -106, -66, -52, -20, -109}, "31f1ed7105300a", 4));
                    break;
                case 54336736:
                    int i17 = f42 * (f38 + 1719);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-22, -64, -30, -58, -23, -57, -22, -59}, "1c9f2d1e2e41", false));
                    break;
                case 54358773:
                    int i18 = f42 * (f38 ^ 7224);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-70, -61, -20, -103, -17, -50, -23, -60}, "af714f2a", 0));
                    break;
                case 54363646:
                    int i19 = f42 * (f38 + 4024);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-22, -86, -22, -106, -66, -64, -65, -109}, "1513ebd7adc9", 0.0f));
                    break;
                case 54390369:
                    int i20 = f42 * (f38 + 3505);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-22, -64, -65, -104, -29, -89, -18, -83}, "1ad88852ee", 3));
                    break;
                case 54391512:
                    int i21 = f42 * (f38 ^ 4834);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-29, -110, -17, -86, -22, -107, -29, -106}, "804517", 7));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۥۨ۟ۡ, reason: not valid java name and contains not printable characters */
    public static ClassLoader m156(Object obj) {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-23, -107, -20, -55, -18, -111, -24, -58}, "247a533ce80a3ba4", true));
        while (true) {
            switch (iM323) {
                case 54157989:
                    if (eRLkMqbO.m105() < 0) {
                        return C0005.m334((Context) obj);
                    }
                    return null;
                case 54180769:
                    int i = f42 * (f38 | 328);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-18, -110, -20, -81, -66, -6, -72, -62}, "5170eeccc467ee"));
                    break;
                case 54186536:
                    int i2 = f42 * (f38 | 4354);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-19, -50, -71, -7, -65, -5, -21, -108}, "6fbfdd076dfd2f92", 0.0f));
                    break;
                case 54186573:
                    int i3 = f42 * (f38 + 6040);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-30, -63, -72, -81, -17, -58, -67, -6}, "9fc04cfe", 5));
                    break;
                case 54211743:
                    int i4 = f42 * (f38 ^ 644);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-22, -62, -18, -97, -22, -107, -18, -61}, "1b58155e56d1", 0.0f));
                    break;
                case 54217386:
                    int i5 = f42 * (f38 | 4157);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-19, -60, -29, -86, -18, -104, -71, -103}, "6b8558b1", 0.0f));
                    break;
                case 54245192:
                    int i6 = f42 * (f38 | 3161);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-21, -112, -67, -102, -17, -62, -70, -109}, "01f84da7", 7));
                    break;
                case 54247117:
                    int i7 = f42 * (f38 + 3638);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-20, -99, -70, -110, -71, -112, -70, -58}, "78a6b0aac76a9b", false));
                    break;
                case 54268222:
                    int i8 = f42 * (f38 ^ 7502);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-22, -106, -66, -97, -19, -7, -72, -106}, "13e96fc58957eb6c", 0.0f));
                    break;
                case 54275913:
                    int i9 = f42 * (f38 ^ 2714);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-70, -112, -67, -105, -65, -111, -70, -108}, "a6f6d6", 0.0f));
                    break;
                case 54300930:
                    int i10 = f42 * (f38 + 3037);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-20, -111, -23, -61, -72, -83, -18, -62}, "712dc25bef7f", false));
                    break;
                case 54332615:
                    int i11 = f42 * (f38 + 2112);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-20, -64, -22, -54, -23, -59, -18, -109}, "7b1b2e5427", 0.0f));
                    break;
                case 54332646:
                    int i12 = f42 * (f38 ^ 5091);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-21, -108, -18, -105, -18, -90, -22, -90}, "04565919e442"));
                    break;
                case 54334533:
                    int i13 = f42 * (f38 + 7604);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-23, -54, -20, -62, -29, -63, -29, -108}, "2b7b8d8209"));
                    break;
                case 54357633:
                    int i14 = f42 * (f38 ^ 2497);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-67, -110, -70, -63, -21, -81, -22, -62}, "f1af001fc46e", 0.0f));
                    break;
                case 54359766:
                    int i15 = f42 * (f38 ^ 151);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-30, -108, -17, -58, -18, -87, -71, -61}, "914b56bd76040db5", 0.0f));
                    break;
                case 54365317:
                    int i16 = f42 * (f38 ^ 4546);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-65, -61, -66, -107, -17, -58, -21, -112}, "dde74a01b4306d", 1));
                    break;
                case 54387570:
                    int i17 = f42 * (f38 + 4716);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-67, -109, -22, -102, -66, -59, -18, -59}, "f718ee5a45accc3c", true));
                    break;
                case 54390517:
                    int i18 = f42 * (f38 | 5896);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-19, -4, -70, -98, -22, -51, -29, -99}, "6ca61e898c92"));
                    break;
                case 54417179:
                    int i19 = f42 * (f38 + 3469);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-21, -106, -66, -63, -24, -105, -17, -63}, "00ef374e0b6e"));
                    break;
                case 54418329:
                    int i20 = f42 * (f38 ^ 4870);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-30, -105, -66, -59, -72, -111, -29, -105}, "95ecc183b6b9", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۦ۟ۤ۠, reason: not valid java name and contains not printable characters */
    public static Object m157(Object obj, Object obj2, Object obj3) {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-23, -64, -19, -62, -23, -7, -18, -5}, "2c6c2f5de804c00d", 0));
        while (true) {
            switch (iM323) {
                case 54150299:
                    int i = f42 * (f38 | 2005);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-29, -97, -23, -59, -29, -101, -22, -62}, "882d881e0417", 0.0f));
                    break;
                case 54181984:
                    int i2 = f42 * (f38 | 2915);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-18, -101, -29, -64, -23, -63, -29, -106}, "598e2e8167f46ee0", 5));
                    break;
                case 54209854:
                    if (m146() < 0) {
                        return ((Method) obj).invoke(obj2, (Object[]) obj3);
                    }
                    return null;
                case 54217327:
                    int i3 = f42 * (f38 + 4715);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-29, -106, -72, -110, -20, -97, -23, -107}, "87c2782346", 5));
                    break;
                case 54244358:
                    int i4 = f42 * (f38 | 848);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-29, -107, -72, -112, -18, -102, -23, -98}, "81c559293bc86981", 0.0f));
                    break;
                case 54269367:
                    int i5 = f42 * (f38 ^ 909);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-72, -105, -17, -102, -19, -109, -29, -110}, "c34865855b930a87", 0.0f));
                    break;
                case 54270142:
                    int i6 = f42 * (f38 | 3659);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-29, -112, -70, -54, -71, -108, -24, -108}, "88abb237e2", 4));
                    break;
                case 54270235:
                    int i7 = f42 * (f38 + 3581);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-66, -104, -72, -51, -19, -58, -66, -111}, "e9ce6f", 0.0f));
                    break;
                case 54270273:
                    int i8 = f42 * (f38 ^ 1292);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-72, -63, -22, -64, -19, -61, -71, -7}, "cb1a6abff29e", 0.0f));
                    break;
                case 54272102:
                    int i9 = f42 * (f38 ^ 7892);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-67, -7, -29, -110, -65, -97, -22, -111}, "ff82d713ee0b1bee"));
                    break;
                case 54274054:
                    int i10 = f42 * (f38 | 2620);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-24, -64, -20, -59, -29, -105, -67, -112}, "3c7f87f65c07c4c5", 0.0f));
                    break;
                case 54276187:
                    int i11 = f42 * (f38 | 1861);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-30, -97, -19, -61, -71, -112, -20, -107}, "976eb570b9dffc"));
                    break;
                case 54298081:
                    int i12 = f42 * (f38 | 2512);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-67, -111, -71, -63, -65, -104, -21, -107}, "f7bdd90551fa2d", true));
                    break;
                case 54301119:
                    int i13 = f42 * (f38 + 4803);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-65, -105, -65, -63, -71, -63, -30, -109}, "d7dcbf969a8145"));
                    break;
                case 54303909:
                    int i14 = f42 * (f38 ^ 7384);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-17, -111, -24, -108, -65, -98, -72, -88}, "4233d6c7a292", 0.0f));
                    break;
                case 54305793:
                    int i15 = f42 * (f38 + 616);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-23, -59, -30, -110, -22, -112, -66, -85}, "2f9215e45c", 2));
                    break;
                case 54363422:
                    int i16 = f42 * (f38 + 7305);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-67, -62, -22, -99, -19, -112, -67, -60}, "fa1861", false));
                    break;
                case 54389438:
                    int i17 = f42 * (f38 + 7781);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-17, -57, -19, -60, -71, -61, -67, -108}, "4c6cbaf4", 0.0f));
                    break;
                case 54424094:
                    int i18 = f42 * (f38 | 4025);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-29, -104, -29, -60, -65, -112, -30, -55}, "808cd79a56b7", 0.0f));
                    break;
                case 54425120:
                    int i19 = f42 * (f38 ^ 2410);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-30, -58, -67, -64, -19, -109, -21, -112}, "9efa6006948e022b"));
                    break;
                case 54426045:
                    int i20 = f42 * (f38 ^ 1460);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-20, -111, -19, -89, -19, -61, -20, -110}, "75686b", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۦۤۥۤ, reason: not valid java name and contains not printable characters */
    public static String m158() {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-72, -60, -17, -112, -24, -104, -70, -110}, "cf4730a1f8de40", true));
        while (true) {
            switch (iM338) {
                case 54151049:
                    int i = f42 * (f38 + 1180);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-20, -64, -72, -106, -30, -64, -67, -102}, "7dc39af947cfd132", 4));
                    break;
                case 54179010:
                    int i2 = f42 * (f38 ^ 2317);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-70, -62, -20, -63, -21, -104, -70, -61}, "ae7b09", true));
                    break;
                case 54182973:
                    int i3 = f42 * (f38 ^ 5032);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-70, -81, -72, -103, -72, -108, -23, -102}, "a0c8c5221d25"));
                    break;
                case 54209819:
                    int i4 = f42 * (f38 | 4331);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-24, -50, -20, -64, -72, -60, -65, -61}, "3f7ccfdc74d15deb", 0.0f));
                    break;
                case 54217412:
                    int i5 = f42 * (f38 | 3916);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-18, -106, -72, -58, -18, -59, -24, -102}, "54ca5b38839b00"));
                    break;
                case 54242430:
                    int i6 = f42 * (f38 | 2587);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-20, -111, -65, -64, -70, -106, -29, -84}, "72dfa28307dd45", 0.0f));
                    break;
                case 54246368:
                    int i7 = f42 * (f38 ^ 1309);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-30, -59, -30, -90, -20, -86, -65, -54}, "9c9975dbc4", 4));
                    break;
                case 54246400:
                    int i8 = f42 * (f38 + 3452);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-72, -61, -30, -64, -23, -97, -72, -64}, "cf9b28", false));
                    break;
                case 54268381:
                    int i9 = f42 * (f38 + 5053);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-21, -103, -22, -53, -65, -108, -22, -61}, "081cd71c16d0", 0));
                    break;
                case 54275102:
                    int i10 = f42 * (f38 | 3647);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-67, -112, -66, -85, -17, -57, -65, -98}, "f4e44dd60e", 3));
                    break;
                case 54298144:
                    int i11 = f42 * (f38 ^ 1966);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-71, -63, -18, -102, -70, -55, -70, -111}, "ba59aaa37e0f07c4", false));
                    break;
                case 54299972:
                    if (m146() < 0) {
                        return m163();
                    }
                    return null;
                case 54301056:
                    int i12 = f42 * (f38 ^ 2051);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-24, -60, -24, -63, -30, -64, -70, -103}, "3c3c9fa808d6", true));
                    break;
                case 54303843:
                    int i13 = f42 * (f38 ^ 7651);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-30, -97, -17, -54, -66, -86, -71, -100}, "994be5b44860d506", 0.0f));
                    break;
                case 54330940:
                    int i14 = f42 * (f38 | 1361);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-21, -112, -29, -102, -70, -108, -23, -97}, "0488a02995"));
                    break;
                case 54357602:
                    int i15 = f42 * (f38 ^ 5713);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-17, -112, -72, -110, -18, -57, -17, -109}, "42c15c", true));
                    break;
                case 54363483:
                    int i16 = f42 * (f38 | 5397);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-71, -105, -19, -84, -66, -59, -30, -62}, "b763ea9efd03", 0.0f));
                    break;
                case 54366251:
                    int i17 = f42 * (f38 ^ 1562);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-67, -97, -18, -109, -72, -54, -19, -82}, "f853cb61"));
                    break;
                case 54388624:
                    int i18 = f42 * (f38 ^ 6657);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-22, -62, -65, -105, -65, -61, -72, -107}, "1cd7dec7fb", false));
                    break;
                case 54390486:
                    int i19 = f42 * (f38 | 3067);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-72, -111, -65, -2, -67, -99, -20, -107}, "c2daf97091356dbf", 0.0f));
                    break;
                case 54391297:
                    int i20 = f42 * (f38 | 513);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-29, -106, -30, -109, -20, -104, -29, -107}, "829278"));
                    break;
                case 54421113:
                    int i21 = f42 * (f38 + 6379);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-29, -109, -29, -58, -66, -112, -67, -89}, "858ce3f850ff"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۦۦۤۥۧ, reason: not valid java name and contains not printable characters */
    private static String m159() {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-66, -89, -18, -104, -22, -101, -66, -101}, "e85813"));
        while (true) {
            switch (iM333) {
                case 54150300:
                    int i = f42 * (f38 ^ 416);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-22, -103, -24, -2, -29, -58, -19, -103}, "113a8f61", true));
                    break;
                case 54151016:
                    int i2 = f42 * (f38 + 3244);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-22, -60, -21, -52, -30, -106, -71, -105}, "1c0d91b443", true));
                    break;
                case 54182691:
                    int i3 = f42 * (f38 | 6864);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-17, -109, -17, -106, -20, -62, -66, -54}, "40437debe396ac", false));
                    break;
                case 54208824:
                    int i4 = f42 * (f38 | 7425);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-21, -103, -18, -109, -70, -103, -67, -111}, "0853a9f6a6", 5));
                    break;
                case 54209638:
                    int i5 = f42 * (f38 | 611);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-30, -64, -30, -6, -19, -106, -30, -60}, "9b9e64"));
                    break;
                case 54215397:
                    int i6 = f42 * (f38 | 2603);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-20, -112, -29, -110, -67, -110, -18, -111}, "7480f65600b8", 0.0f));
                    break;
                case 54238529:
                    int i7 = f42 * (f38 ^ 2405);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-22, -57, -19, -101, -19, -102, -23, -57}, "1e69692b2d", 0.0f));
                    break;
                case 54241442:
                    int i8 = f42 * (f38 + 6929);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-66, -54, -70, -108, -72, -99, -24, -112}, "eba5c93796"));
                    break;
                case 54246338:
                    int i9 = f42 * (f38 ^ 6706);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-72, -107, -66, -63, -20, -106, -22, -106}, "c0ef71155bcaf9", 6));
                    break;
                case 54274212:
                    int i10 = f42 * (f38 ^ 3407);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-19, -81, -66, -112, -65, -111, -20, -97}, "60e1d179f4", 1));
                    break;
                case 54301057:
                    int i11 = f42 * (f38 ^ 6579);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-19, -59, -24, -4, -71, -109, -29, -2}, "6d3cb68a37efcf", true));
                    break;
                case 54306697:
                    int i12 = f42 * (f38 + 3605);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-66, -111, -71, -106, -22, -64, -19, -101}, "e6b11a69", 0.0f));
                    break;
                case 54327992:
                    int i13 = f42 * (f38 ^ 2244);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-19, -62, -23, -111, -67, -109, -29, -111}, "6c27f38160ed82"));
                    break;
                case 54335742:
                    int i14 = f42 * (f38 + 4250);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-66, -108, -22, -54, -70, -112, -17, -107}, "e01ba0404c265443"));
                    break;
                case 54361568:
                    int i15 = f42 * (f38 + 5002);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-30, -61, -17, -106, -65, -81, -71, -90}, "9c45d0b921be", 7));
                    break;
                case 54362462:
                    int i16 = f42 * (f38 + 1020);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-65, -98, -22, -106, -30, -58, -24, -111}, "d8159e3774a8", true));
                    break;
                case 54395137:
                    int i17 = f42 * (f38 + 6270);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-23, -60, -20, -89, -67, -105, -66, -111}, "2a78f2e209", 1));
                    break;
                case 54396285:
                    int i18 = f42 * (f38 ^ 3689);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-71, -102, -17, -107, -22, -105, -18, -108}, "b84211576ff00f"));
                    break;
                case 54417215:
                    int i19 = f42 * (f38 + 2056);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-71, -110, -20, -108, -22, -109, -19, -64}, "b470126a986aa0d9", true));
                    break;
                case 54419260:
                    return C0005.m336(f45, 54, 978027097 ^ C0003.f68, 32);
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۧ۠۠ۦ, reason: not valid java name and contains not printable characters */
    public static String m160() {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-19, -107, -66, -107, -24, -112, -17, -112}, "62e63344ec76"));
        while (true) {
            switch (iM333) {
                case 54149094:
                    int i = f42 * (f38 ^ 3673);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-65, -54, -22, -62, -67, -111, -65, -59}, "db1ff3", false));
                    break;
                case 54154915:
                    int i2 = f42 * (f38 | 2831);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-71, -110, -65, -85, -70, -57, -29, -54}, "b5d4ab8b", 1));
                    break;
                case 54182946:
                    int i3 = f42 * (f38 + 906);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-20, -112, -66, -98, -66, -59, -22, -102}, "78e6eb189c48665a", false));
                    break;
                case 54184834:
                    int i4 = f42 * (f38 ^ 23);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-71, -7, -17, -99, -72, -105, -71, -7}, "bf48c5"));
                    break;
                case 54241599:
                    int i5 = f42 * (f38 + 5383);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-18, -60, -67, -112, -29, -85, -30, -60}, "5af3849ff9", 0.0f));
                    break;
                case 54246150:
                    int i6 = f42 * (f38 | 6243);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-29, -109, -21, -99, -30, -60, -71, -58}, "83089bbe2f5fd4", 0.0f));
                    break;
                case 54272254:
                    int i7 = f42 * (f38 ^ 4864);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-70, -106, -21, -64, -21, -112, -67, -89}, "a30b01f8", false));
                    break;
                case 54300989:
                    int i8 = f42 * (f38 ^ 4569);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-21, -58, -17, -108, -30, -109, -17, -107}, "0a4293439e", 5));
                    break;
                case 54305763:
                    int i9 = f42 * (f38 | 411);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-24, -57, -29, -107, -18, -104, -20, -110}, "3a84597091", 1));
                    break;
                case 54330011:
                    if (z1rBEw9J.m266() < 0) {
                        return m159();
                    }
                    return null;
                case 54330747:
                    int i10 = f42 * (f38 ^ 6954);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-29, -112, -29, -58, -65, -62, -22, -62}, "848adc1c6cc3", false));
                    break;
                case 54331649:
                    int i11 = f42 * (f38 | 1986);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-71, -106, -21, -101, -66, -60, -67, -54}, "b303eefbfe33"));
                    break;
                case 54336522:
                    int i12 = f42 * (f38 + 3716);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-18, -86, -22, -82, -22, -110, -23, -98}, "55111228d80d", false));
                    break;
                case 54359580:
                    int i13 = f42 * (f38 + 2718);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-67, -60, -66, -112, -70, -106, -21, -64}, "fde3a10fae75eb", 6));
                    break;
                case 54366528:
                    int i14 = f42 * (f38 | 2244);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-17, -112, -23, -109, -18, -64, -17, -63}, "43205e4b8b"));
                    break;
                case 54387579:
                    int i15 = f42 * (f38 | 4334);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-70, -63, -22, -61, -70, -107, -21, -60}, "ae1aa70e1e"));
                    break;
                case 54391357:
                    int i16 = f42 * (f38 + 7754);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-23, -109, -29, -60, -20, -54, -72, -58}, "218f7bca3452", 5));
                    break;
                case 54394149:
                    int i17 = f42 * (f38 + 3466);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-66, -97, -21, -98, -67, -52, -72, -110}, "e906fdc44292", 4));
                    break;
                case 54418261:
                    int i18 = f42 * (f38 + 221);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-18, -107, -18, -61, -21, -59, -17, -112}, "575d0e41e6538f92", false));
                    break;
                case 54422081:
                    int i19 = f42 * (f38 ^ 875);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-21, -53, -21, -59, -67, -58, -21, -58}, "0c0efe0ff9", false));
                    break;
                case 54426075:
                    int i20 = f42 * (f38 + 7509);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-29, -60, -23, -109, -19, -97, -23, -109}, "8a22672444c2ec43", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۧۢۢ۟, reason: not valid java name and contains not printable characters */
    public static File m161(Object obj) {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-65, -99, -19, -64, -71, -111, -29, -108}, "d86db580"));
        while (true) {
            switch (iM333) {
                case 54151107:
                    int i = f42 * (f38 ^ 3414);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-23, -57, -19, -85, -65, -62, -72, -101}, "2c64dcc992bc5c1b", false));
                    break;
                case 54180031:
                    int i2 = f42 * (f38 + 1224);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-70, -107, -72, -103, -71, -108, -66, -103}, "a1c1b4e16615"));
                    break;
                case 54180989:
                    int i3 = f42 * (f38 + 8030);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-19, -64, -65, -110, -23, -106, -21, -88}, "6cd42707992c76", 1));
                    break;
                case 54217318:
                    int i4 = f42 * (f38 ^ 3185);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-65, -98, -17, -105, -22, -112, -24, -59}, "d840113dad151631", 0.0f));
                    break;
                case 54217388:
                    int i5 = f42 * (f38 + 7916);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-72, -98, -30, -107, -65, -108, -72, -101}, "c990d6c8d86f", 6));
                    break;
                case 54245407:
                    int i6 = f42 * (f38 + 6084);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-18, -63, -19, -109, -66, -62, -23, -61}, "5f67ef2d", true));
                    break;
                case 54271171:
                    int i7 = f42 * (f38 + 3918);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-30, -111, -29, -108, -29, -60, -70, -57}, "93828caef291221f"));
                    break;
                case 54275009:
                    int i8 = f42 * (f38 + 2275);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-66, -107, -22, -107, -70, -112, -65, -106}, "e315a4d4"));
                    break;
                case 54298076:
                    int i9 = f42 * (f38 ^ 7205);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-66, -106, -71, -57, -17, -54, -17, -102}, "e3ba4b425105"));
                    break;
                case 54306700:
                    int i10 = f42 * (f38 ^ 4114);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-29, -63, -67, -64, -70, -106, -17, -106}, "8bfba743"));
                    break;
                case 54328052:
                    int i11 = f42 * (f38 | 1655);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-29, -53, -29, -108, -70, -106, -29, -62}, "8c86a4"));
                    break;
                case 54332767:
                    int i12 = f42 * (f38 + 7074);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-19, -109, -18, -107, -21, -64, -22, -107}, "63550f104cdf47", false));
                    break;
                case 54334817:
                    int i13 = f42 * (f38 ^ 6590);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-29, -110, -30, -102, -67, -63, -19, -63}, "8392fc6f"));
                    break;
                case 54357691:
                    int i14 = f42 * (f38 + 6696);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-22, -81, -66, -105, -66, -63, -17, -107}, "10e6eb41c068fa", 1));
                    break;
                case 54358712:
                    if (m146() <= 0) {
                        return ((Context) obj).getCodeCacheDir();
                    }
                    return null;
                case 54365345:
                    int i15 = f42 * (f38 + 6715);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-22, -51, -30, -111, -17, -111, -22, -60}, "1e9441", false));
                    break;
                case 54392352:
                    int i16 = f42 * (f38 | 1206);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-21, -109, -17, -86, -23, -60, -17, -112}, "06452c418ceecc", true));
                    break;
                case 54393247:
                    int i17 = f42 * (f38 | 8176);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-71, -103, -23, -98, -65, -62, -17, -90}, "b826db490cbd", false));
                    break;
                case 54420153:
                    int i18 = f42 * (f38 ^ 1205);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-24, -57, -17, -4, -67, -111, -30, -57}, "3a4cf39c", 0));
                    break;
                case 54422974:
                    int i19 = f42 * (f38 | 3458);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-22, -106, -23, -103, -17, -110, -19, -112}, "1628446249e80908"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۧۥۨۦ, reason: not valid java name and contains not printable characters */
    public static Object m162(Object obj, Object obj2) {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-65, -54, -19, -83, -71, -89, -17, -111}, "db62b841da1b0b", 0.0f));
        while (true) {
            switch (iM333) {
                case 54149247:
                    int i = f42 * (f38 ^ 7718);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-23, -106, -29, -107, -23, -112, -18, -62}, "2384235f", 6));
                    break;
                case 54150116:
                    int i2 = f42 * (f38 ^ 8120);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-30, -57, -19, -107, -66, -60, -30, -62}, "9d65ea"));
                    break;
                case 54151108:
                    int i3 = f42 * (f38 | 6159);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-70, -111, -23, -61, -21, -110, -66, -106}, "a02a00e294ed"));
                    break;
                case 54153148:
                    int i4 = f42 * (f38 ^ 7716);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-20, -103, -24, -60, -19, -81, -22, -111}, "783e60121c"));
                    break;
                case 54180025:
                    int i5 = f42 * (f38 | 6290);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-67, -111, -21, -108, -22, -110, -22, -100}, "f40014146259", true));
                    break;
                case 54180901:
                    int i6 = f42 * (f38 | 1494);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-72, -102, -19, -110, -67, -107, -19, -63}, "c261f36b136d", 4));
                    break;
                case 54209756:
                    int i7 = f42 * (f38 ^ 4938);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-20, -112, -30, -101, -18, -62, -66, -61}, "77995fee57ed7bdb"));
                    break;
                case 54210564:
                    int i8 = f42 * (f38 | 1571);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-71, -3, -67, -89, -20, -58, -71, -57}, "bbf87cbc"));
                    break;
                case 54211619:
                    int i9 = f42 * (f38 | 7353);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-19, -108, -23, -110, -29, -111, -67, -108}, "652285f537ac", 1));
                    break;
                case 54212517:
                    int i10 = f42 * (f38 ^ 771);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-19, -106, -22, -102, -71, -111, -19, -106}, "6719b5", 0.0f));
                    break;
                case 54212639:
                    int i11 = f42 * (f38 ^ 2315);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-19, -62, -71, -61, -71, -106, -29, -4}, "6bbcb08cd6", 0.0f));
                    break;
                case 54239579:
                    int i12 = f42 * (f38 | 7077);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-21, -88, -24, -109, -23, -112, -29, -110}, "07322387ba6080", 5));
                    break;
                case 54246249:
                    int i13 = f42 * (f38 ^ 4260);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-19, -61, -20, -57, -67, -106, -65, -102}, "6b7df6d95027d0f5"));
                    break;
                case 54269374:
                    int i14 = f42 * (f38 + 7880);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-23, -105, -21, -63, -23, -100, -17, -105}, "200d284624954646", false));
                    break;
                case 54269404:
                    int i15 = f42 * (f38 | 7729);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-65, -83, -29, -105, -19, -109, -24, -63}, "d287613d717c", false));
                    break;
                case 54328794:
                    int i16 = f42 * (f38 | 1706);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-23, -104, -17, -107, -24, -64, -72, -61}, "28443ccd8300b632", 1));
                    break;
                case 54329853:
                    int i17 = f42 * (f38 ^ 3616);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-18, -64, -65, -111, -22, -57, -18, -58}, "5cd11a", true));
                    break;
                case 54332833:
                    int i18 = f42 * (f38 | 5032);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-72, -112, -19, -107, -21, -106, -72, -112}, "c26503"));
                    break;
                case 54390429:
                    int i19 = f42 * (f38 ^ 112);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-71, -7, -71, -105, -65, -63, -67, -6}, "bfb4dffe01"));
                    break;
                case 54393307:
                    int i20 = f42 * (f38 | 4283);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-17, -57, -29, -110, -19, -104, -17, -7}, "4b82684fbf60eb", 4));
                    break;
                case 54417176:
                    int i21 = f42 * (f38 + 2595);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-72, -58, -24, -109, -29, -112, -30, -63}, "cd34839fe97ebe74", false));
                    break;
                case 54421240:
                    if (m146() < 0) {
                        return ((Constructor) obj).newInstance((Object[]) obj2);
                    }
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۧۧۥ۟, reason: not valid java name and contains not printable characters */
    private static String m163() {
        int iM350 = C0009.m350(C0010.decode(new byte[]{-20, -3, -71, -111, -30, -110, -71, -63}, "7bb990be0ecc45", 1));
        while (true) {
            switch (iM350) {
                case 54155816:
                    int i = f42 * (f38 + 2290);
                    iM350 = C0006.m338(C0010.decode(new byte[]{-17, -112, -66, -107, -17, -59, -19, -60}, "40e54e6cc0aae0", false));
                    break;
                case 54156744:
                    int i2 = f42 * (f38 + 6498);
                    iM350 = C0004.m329(C0010.decode(new byte[]{-70, -62, -66, -51, -19, -110, -23, -106}, "aaee6627b9add3", false));
                    break;
                case 54157803:
                    int i3 = f42 * (f38 | 3538);
                    iM350 = C0000.m310(C0010.decode(new byte[]{-18, -59, -20, -112, -20, -108, -18, -60}, "5b7776"));
                    break;
                case 54179847:
                    int i4 = f42 * (f38 | 4457);
                    iM350 = C0007.m342(C0010.decode(new byte[]{-22, -63, -67, -107, -72, -105, -29, -62}, "1bf5c08bea54ca", 3));
                    break;
                case 54180774:
                    int i5 = f42 * (f38 | 4241);
                    iM350 = C0000.m310(C0010.decode(new byte[]{-23, -105, -22, -63, -17, -90, -71, -58}, "231c49bd", true));
                    break;
                case 54185765:
                    int i6 = f42 * (f38 | 6079);
                    iM350 = C0001.m315(C0010.decode(new byte[]{-29, -108, -21, -58, -30, -98, -24, -109}, "830d9632b85d4436"));
                    break;
                case 54212579:
                    int i7 = f42 * (f38 + 7665);
                    iM350 = C0004.m329(C0010.decode(new byte[]{-70, -110, -29, -62, -29, -60, -17, -111}, "a28d8a4535", false));
                    break;
                case 54215372:
                    int i8 = f42 * (f38 ^ 1840);
                    iM350 = C0008.m347(C0010.decode(new byte[]{-72, -112, -17, -98, -22, -57, -20, -63}, "c1481d7a6a"));
                    break;
                case 54215490:
                    int i9 = f42 * (f38 | 2054);
                    iM350 = C0005.m333(C0010.decode(new byte[]{-71, -5, -23, -64, -18, -105, -30, -57}, "bd2f579f06ba97", true));
                    break;
                case 54217294:
                    int i10 = f42 * (f38 | 6603);
                    iM350 = C0008.m347(C0010.decode(new byte[]{-67, -64, -17, -63, -71, -110, -70, -97}, "fb4bb6a7f89d1e", false));
                    break;
                case 54242437:
                    int i11 = f42 * (f38 | 2042);
                    iM350 = C0007.m342(C0010.decode(new byte[]{-18, -108, -22, -60, -24, -109, -18, -108}, "531e37", true));
                    break;
                case 54269430:
                    int i12 = f42 * (f38 + 4579);
                    iM350 = C0004.m329(C0010.decode(new byte[]{-22, -61, -24, -58, -72, -107, -24, -106}, "1b3ec735", 6));
                    break;
                case 54274144:
                    int i13 = f42 * (f38 ^ 855);
                    iM350 = C0009.m350(C0010.decode(new byte[]{-18, -109, -29, -87, -29, -108, -72, -63}, "558680cc3e", 3));
                    break;
                case 54275078:
                    int i14 = f42 * (f38 | 5595);
                    iM350 = C0007.m342(C0010.decode(new byte[]{-66, -107, -72, -64, -18, -3, -21, -110}, "e5ca5b069c8981", 0.0f));
                    break;
                case 54277026:
                    return C0005.m336(f45, 47, 524318573 ^ C0003.f68, 7);
                case 54300897:
                    int i15 = f42 * (f38 ^ 1696);
                    iM350 = C0009.m350(C0010.decode(new byte[]{-20, -64, -23, -52, -30, -3, -65, -110}, "7a2d9bd48a", false));
                    break;
                case 54357751:
                    int i16 = f42 * (f38 + 5180);
                    iM350 = C0006.m338(C0010.decode(new byte[]{-18, -62, -21, -59, -18, -85, -17, -64}, "5c0c544f513a63", 0.0f));
                    break;
                case 54361565:
                    int i17 = f42 * (f38 + 951);
                    iM350 = C0003.m323(C0010.decode(new byte[]{-19, -88, -19, -109, -67, -2, -19, -88}, "6764fa", false));
                    break;
                case 54389469:
                    int i18 = f42 * (f38 + 5194);
                    iM350 = C0002.m317(C0010.decode(new byte[]{-18, -60, -21, -59, -23, -102, -22, -62}, "5b0f291a", 5));
                    break;
                case 54390548:
                    int i19 = f42 * (f38 | 7206);
                    iM350 = C0005.m333(C0010.decode(new byte[]{-65, -64, -29, -111, -20, -64, -17, -112}, "dc877c46", false));
                    break;
                case 54395172:
                    int i20 = f42 * (f38 | 4905);
                    iM350 = C0004.m329(C0010.decode(new byte[]{-19, -102, -17, -100, -70, -62, -19, -112}, "6949af62", 0));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۨۢۥ, reason: not valid java name and contains not printable characters */
    public static void m164(Object obj, Object obj2, int i, int i2) {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-17, -61, -20, -100, -71, -111, -17, -99}, "4b79b3457280a1", false));
        while (true) {
            switch (iM338) {
                case 54150147:
                    int i3 = f42 * (f38 + 5714);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-22, -105, -19, -86, -67, -97, -20, -111}, "1065f97926aa"));
                    break;
                case 54152189:
                    int i4 = f42 * (f38 | 2682);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-20, -111, -17, -85, -20, -111, -21, -101}, "704476094dec", 0.0f));
                    break;
                case 54155940:
                    int i5 = f42 * (f38 ^ 1895);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-72, -54, -71, -55, -29, -111, -20, -106}, "cbba817485", 6));
                    break;
                case 54208889:
                    int i6 = f42 * (f38 ^ 1787);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-18, -110, -70, -112, -22, -64, -71, -62}, "56a81dbc", 4));
                    break;
                case 54214506:
                    int i7 = f42 * (f38 + 4838);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-24, -54, -22, -60, -29, -87, -24, -54}, "3b1f86", 0.0f));
                    break;
                case 54215584:
                    int i8 = f42 * (f38 ^ 5208);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-65, -109, -23, -84, -29, -60, -20, -105}, "d4238f74603c8184"));
                    break;
                case 54216452:
                    int i9 = f42 * (f38 | 7237);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-24, -58, -21, -62, -65, -106, -70, -90}, "3a0dd3a9764b", 0.0f));
                    break;
                case 54241408:
                    int i10 = f42 * (f38 ^ 4873);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-24, -103, -72, -111, -18, -102, -24, -103}, "38c659"));
                    break;
                case 54274111:
                    int i11 = f42 * (f38 | 7562);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-18, -112, -22, -109, -17, -89, -72, -97}, "581348c9"));
                    break;
                case 54306817:
                    int i12 = f42 * (f38 + 3087);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-72, -97, -20, -111, -65, -86, -70, -109}, "c876d5a7", true));
                    break;
                case 54365564:
                    int i13 = f42 * (f38 | 3729);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-72, -61, -29, -61, -19, -108, -29, -106}, "cb8e6287338a"));
                    break;
                case 54387481:
                    int i14 = f42 * (f38 + 5450);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-30, -110, -22, -102, -71, -106, -22, -110}, "9018b410", 4));
                    break;
                case 54387610:
                    int i15 = f42 * (f38 ^ 4132);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-23, -86, -65, -106, -72, -63, -66, -57}, "25d0ceef73ee506d", 3));
                    break;
                case 54392322:
                    if (z1rBEw9J.m266() <= 0) {
                        C0001.m312((ByteArrayOutputStream) obj, (byte[]) obj2, i, i2);
                        return;
                    }
                    return;
                case 54394297:
                    int i16 = f42 * (f38 + 5857);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-21, -83, -19, -112, -29, -108, -21, -105}, "026087", true));
                    break;
                case 54395077:
                    int i17 = f42 * (f38 ^ 382);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-67, -58, -19, -99, -20, -64, -67, -55}, "fa697cfa", 4));
                    break;
                case 54418143:
                    int i18 = f42 * (f38 ^ 1814);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-19, -6, -71, -111, -20, -61, -66, -62}, "6eb37dec4a14ea", 0.0f));
                    break;
                case 54420067:
                    int i19 = f42 * (f38 | 6238);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-67, -97, -70, -53, -22, -111, -30, -90}, "f7ac1299", 2));
                    break;
                case 54425858:
                    int i20 = f42 * (f38 ^ 7198);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-20, -110, -66, -106, -70, -62, -17, -60}, "71e3aa4db9c800", 2));
                    break;
                case 54425948:
                    int i21 = f42 * (f38 ^ 7121);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-24, -107, -67, -60, -18, -99, -30, -59}, "33fc559f81bbd203", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۨۧۢ, reason: not valid java name and contains not printable characters */
    public static String m165() {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-18, -102, -18, -58, -17, -62, -70, -110}, "595d4aa59f", 2));
        while (true) {
            switch (iM342) {
                case 54150024:
                    int i = f42 * (f38 | 8110);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-65, -102, -17, -106, -20, -61, -22, -7}, "d2417d1fc105524c", 5));
                    break;
                case 54153185:
                    int i2 = f42 * (f38 | 1596);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-70, -61, -70, -108, -19, -108, -22, -111}, "ada46616", true));
                    break;
                case 54154081:
                    int i3 = f42 * (f38 ^ 2795);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-70, -64, -29, -60, -70, -57, -19, -58}, "af8cac6fc4", 1));
                    break;
                case 54155939:
                    int i4 = f42 * (f38 ^ 2319);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-22, -108, -71, -57, -71, -105, -18, -108}, "13bcb752", 0.0f));
                    break;
                case 54157832:
                    int i5 = f42 * (f38 + 3418);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-72, -109, -65, -89, -23, -63, -24, -57}, "c7d82a3d", 0.0f));
                    break;
                case 54181735:
                    int i6 = f42 * (f38 + 6085);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-29, -103, -21, -102, -65, -106, -29, -108}, "8109d0", false));
                    break;
                case 54213666:
                    int i7 = f42 * (f38 + 3658);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-70, -87, -24, -110, -17, -106, -65, -103}, "a63442d95c08", 0));
                    break;
                case 54217536:
                    int i8 = f42 * (f38 | 4368);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-18, -111, -23, -107, -65, -84, -66, -57}, "5127d3ec471c", 0));
                    break;
                case 54239642:
                    int i9 = f42 * (f38 | 2527);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-17, -103, -17, -104, -29, -112, -71, -61}, "414985be5d28"));
                    break;
                case 54247210:
                    int i10 = f42 * (f38 | 5320);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-20, -110, -20, -109, -72, -55, -29, -57}, "7473ca8eae41", 7));
                    break;
                case 54271235:
                    int i11 = f42 * (f38 + 5002);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-23, -110, -70, -97, -24, -110, -24, -58}, "20a7313aa5"));
                    break;
                case 54275200:
                    int i12 = f42 * (f38 | 2275);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-23, -98, -71, -112, -21, -57, -67, -109}, "26b70df4c1", 0.0f));
                    break;
                case 54276871:
                    int i13 = f42 * (f38 + 4429);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-72, -3, -66, -60, -22, -3, -70, -107}, "cbed1ba3603a9403", 0.0f));
                    break;
                case 54298046:
                    int i14 = f42 * (f38 + 3012);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-18, -111, -17, -58, -30, -62, -18, -107}, "504b9d", false));
                    break;
                case 54306944:
                    int i15 = f42 * (f38 | 7144);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-20, -110, -66, -97, -18, -111, -20, -109}, "73e756", 0.0f));
                    break;
                case 54358836:
                    int i16 = f42 * (f38 + 6373);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-30, -82, -18, -55, -17, -107, -70, -60}, "915a46af", 0.0f));
                    break;
                case 54365437:
                    int i17 = f42 * (f38 ^ 7745);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-67, -112, -17, -55, -21, -102, -67, -100}, "f44a02f8c37aa92c", 0.0f));
                    break;
                case 54388446:
                    int i18 = f42 * (f38 ^ 558);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-24, -63, -19, -108, -70, -106, -72, -59}, "3b62a1cad59c"));
                    break;
                case 54392227:
                    int i19 = f42 * (f38 | 6656);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-22, -64, -20, -60, -29, -98, -30, -57}, "1b7d899d40"));
                    break;
                case 54419290:
                    int i20 = f42 * (f38 | 5866);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-71, -86, -20, -57, -65, -52, -23, -100}, "b57ddd2917", 0.0f));
                    break;
                case 54421242:
                    if (Z5HFgwkz.m63() > 0) {
                        return m190();
                    }
                    return null;
                case 54424995:
                    int i21 = f42 * (f38 + 4274);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-66, -64, -18, -50, -66, -84, -18, -61}, "ec5fe35b70", 0.0f));
                    break;
                case 54425111:
                    int i22 = f42 * (f38 + 7959);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-22, -81, -18, -59, -70, -97, -22, -102}, "105aa91897", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠۟۠ۦ۟, reason: not valid java name and contains not printable characters */
    public static int m166() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-70, -106, -67, -7, -19, -108, -18, -60}, "a5ff665c99761a", 1));
        while (true) {
            switch (iM347) {
                case 54156841:
                    int i = f42 * (f38 | 7082);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-70, -112, -72, -50, -20, -99, -20, -64}, "a6cf787d", 1));
                    break;
                case 54157771:
                    int i2 = f42 * (f38 | 7277);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-23, -61, -24, -3, -71, -100, -19, -3}, "2b3bb46b", true));
                    break;
                case 54179002:
                    int i3 = f42 * (f38 | 5882);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-67, -109, -65, -109, -71, -104, -20, -59}, "f6d6b97ba4"));
                    break;
                case 54180955:
                    int i4 = f42 * (f38 | 2392);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-71, -64, -70, -111, -67, -106, -23, -60}, "baa3f72cf36512", 2));
                    break;
                case 54208917:
                    int i5 = f42 * (f38 ^ 1873);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-72, -107, -24, -106, -18, -58, -70, -90}, "c5375ca9e95d", 5));
                    break;
                case 54211591:
                    int i6 = f42 * (f38 ^ 842);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-21, -63, -72, -107, -66, -106, -17, -108}, "0dc1e042439b", 4));
                    break;
                case 54238616:
                    int i7 = f42 * (f38 | 2935);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-17, -99, -23, -107, -70, -104, -24, -63}, "4923a93c", 0.0f));
                    break;
                case 54239580:
                    int i8 = f42 * (f38 ^ 5450);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-29, -111, -30, -101, -22, -104, -19, -104}, "83991969", 0.0f));
                    break;
                case 54241376:
                    int i9 = f42 * (f38 ^ 7514);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-66, -82, -21, -109, -21, -112, -65, -63}, "e10402db015f0b4f", 7));
                    break;
                case 54246180:
                    int i10 = f42 * (f38 + 6964);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-71, -64, -18, -60, -70, -60, -71, -63}, "bb5daa", true));
                    break;
                case 54247358:
                    int i11 = f42 * (f38 | 5400);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-30, -103, -17, -109, -29, -83, -21, -100}, "9146820489cc7c", true));
                    break;
                case 54268321:
                    int i12 = f42 * (f38 ^ 7083);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-71, -108, -18, -112, -29, -61, -71, -61}, "b6578bbc", 0));
                    break;
                case 54276939:
                    int i13 = f42 * (f38 + 1223);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-29, -62, -19, -63, -67, -105, -29, -107}, "8d6df58417", 3));
                    break;
                case 54304803:
                    int i14 = f42 * (f38 | 5606);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-24, -108, -24, -99, -24, -102, -65, -109}, "363532d3627635", 0.0f));
                    break;
                case 54332801:
                    int i15 = f42 * (f38 | 7493);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-23, -62, -22, -51, -29, -108, -23, -58}, "2a1e85"));
                    break;
                case 54332831:
                    int i16 = 0;
                    int i17 = 0;
                    char c = 46317;
                    while (true) {
                        switch (c) {
                            case 29928:
                                int i18 = 1051101143 % 26;
                                break;
                            case 46317:
                                int i19 = 1727655313 % 27;
                                i16 = 289740500;
                                i17 = 1464411304;
                                c = 22059;
                                break;
                            case 62716:
                                return i16;
                            case 22059:
                                i16 ^= i17;
                                c = 62716;
                                break;
                        }
                    }
                    break;
                case 54333638:
                    int i20 = f42 * (f38 | 5438);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-71, -106, -70, -64, -18, -99, -18, -112}, "b3ad58570a08"));
                    break;
                case 54334755:
                    int i21 = f42 * (f38 + 986);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-20, -57, -30, -90, -67, -99, -66, -109}, "7e99f8e33477", 2));
                    break;
                case 54363454:
                    int i22 = f42 * (f38 ^ 1187);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-71, -108, -30, -98, -19, -111, -21, -111}, "b198670991d5117a"));
                    break;
                case 54366433:
                    int i23 = f42 * (f38 | 2198);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-23, -107, -22, -6, -21, -112, -29, -88}, "251e0487eb", false));
                    break;
                case 54422950:
                    int i24 = f42 * (f38 | 4400);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-71, -2, -70, -53, -72, -110, -67, -64}, "baacc3fc4c0fc88a", 3));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠۠ۧۤ۟, reason: not valid java name and contains not printable characters */
    private static String m167() {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-19, -60, -24, -112, -30, -109, -65, -90}, "6d3696d9f606"));
        while (true) {
            switch (iM323) {
                case 54179840:
                    int i = f42 * (f38 + 8183);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-23, -59, -20, -105, -29, -61, -21, -105}, "2f718c0313e5da31", 0.0f));
                    break;
                case 54184649:
                    int i2 = f42 * (f38 ^ 1138);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-22, -111, -18, -106, -29, -112, -17, -60}, "1651804eeb779874"));
                    break;
                case 54185760:
                    int i3 = f42 * (f38 + 472);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-18, -52, -20, -98, -66, -107, -18, -63}, "5d76e4", 5));
                    break;
                case 54212704:
                    int i4 = f42 * (f38 ^ 5412);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-20, -64, -65, -102, -21, -109, -67, -63}, "7cd205fcc5", 0.0f));
                    break;
                case 54215435:
                    int i5 = f42 * (f38 + 5986);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-22, -111, -67, -100, -71, -103, -67, -58}, "13f8b9fb9d5baa", false));
                    break;
                case 54216547:
                    return C0005.m336(f45, 124, 1301976660 ^ C0001.f64, 25);
                case 54239520:
                    int i6 = f42 * (f38 + 321);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-72, -60, -65, -64, -71, -102, -17, -59}, "cfdfb84c82", true));
                    break;
                case 54242435:
                    int i7 = f42 * (f38 + 4094);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-19, -110, -21, -102, -23, -58, -19, -110}, "65022e", 2));
                    break;
                case 54243270:
                    int i8 = f42 * (f38 ^ 4481);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-72, -110, -24, -109, -24, -110, -17, -106}, "c2363242"));
                    break;
                case 54245256:
                    int i9 = f42 * (f38 ^ 6379);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-19, -111, -70, -112, -29, -108, -19, -107}, "63a380"));
                    break;
                case 54272259:
                    int i10 = f42 * (f38 ^ 4532);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-29, -109, -18, -60, -23, -112, -67, -110}, "815d23f75e", 0));
                    break;
                case 54274983:
                    int i11 = f42 * (f38 ^ 6841);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-17, -106, -67, -107, -18, -63, -19, -111}, "41f35e6268967c78", false));
                    break;
                case 54277026:
                    int i12 = f42 * (f38 + 6484);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-22, -108, -18, -97, -22, -112, -29, -62}, "1559118e13b69e8d"));
                    break;
                case 54277089:
                    int i13 = f42 * (f38 + 7737);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-19, -107, -70, -112, -66, -109, -65, -99}, "63a6e2d9022b", 2));
                    break;
                case 54364387:
                    int i14 = f42 * (f38 + 6238);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-23, -101, -29, -51, -72, -64, -18, -59}, "288ecd5d85a6"));
                    break;
                case 54394270:
                    int i15 = f42 * (f38 | 224);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-19, -106, -17, -102, -67, -57, -18, -112}, "6549fb5898", 0.0f));
                    break;
                case 54395105:
                    int i16 = f42 * (f38 ^ 2621);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-20, -109, -66, -60, -20, -110, -20, -58}, "72ec747e"));
                    break;
                case 54396165:
                    int i17 = f42 * (f38 | 5040);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-65, -112, -72, -108, -18, -108, -67, -111}, "d8c755f5ba"));
                    break;
                case 54421086:
                    int i18 = f42 * (f38 | 6504);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-30, -106, -21, -112, -70, -61, -71, -64}, "9703aebd884d237f", false));
                    break;
                case 54425892:
                    int i19 = f42 * (f38 | 6535);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-70, -58, -17, -62, -23, -105, -67, -105}, "af4b27f7", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۢ۠۠, reason: not valid java name and contains not printable characters */
    public static InputStream m168(Object obj, Object obj2) {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-71, -101, -66, -59, -18, -63, -71, -112}, "b9ef5db73796", 0.0f));
        while (true) {
            switch (iM329) {
                case 54156994:
                    int i = f42 * (f38 ^ 7699);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-72, -104, -65, -100, -30, -111, -17, -110}, "c0d89341ec4ea3", true));
                    break;
                case 54179904:
                    int i2 = f42 * (f38 ^ 1432);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-29, -106, -29, -6, -66, -62, -67, -112}, "878eedf87e8ce519", false));
                    break;
                case 54181987:
                    int i3 = f42 * (f38 | 4330);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-21, -110, -19, -105, -71, -109, -30, -105}, "0463b294f9", 0.0f));
                    break;
                case 54184676:
                    int i4 = f42 * (f38 + 6340);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-21, -99, -20, -97, -65, -111, -30, -99}, "0978d095572d85c4", 0.0f));
                    break;
                case 54208864:
                    int i5 = f42 * (f38 | 1018);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-23, -59, -24, -64, -66, -64, -22, -104}, "2e3eea1826cf", false));
                    break;
                case 54210786:
                    int i6 = f42 * (f38 ^ 7390);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-17, -52, -23, -106, -22, -60, -67, -58}, "4d231ffb0ec5b93c", true));
                    break;
                case 54242467:
                    int i7 = f42 * (f38 + 1755);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-20, -99, -23, -109, -67, -58, -20, -101}, "7826fc", 0.0f));
                    break;
                case 54243425:
                    if (Z5HFgwkz.m63() >= 0) {
                        return C0000.m308((AssetManager) obj, (String) obj2);
                    }
                    return null;
                case 54298043:
                    int i8 = f42 * (f38 | 7447);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-22, -110, -18, -82, -18, -108, -66, -107}, "175150e7cf36", true));
                    break;
                case 54305770:
                    int i9 = f42 * (f38 | 6834);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-21, -84, -67, -63, -70, -111, -19, -108}, "03ffa6658eec", 1));
                    break;
                case 54327960:
                    int i10 = f42 * (f38 | 1838);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-30, -52, -22, -99, -30, -111, -30, -60}, "9d1596", false));
                    break;
                case 54331804:
                    int i11 = f42 * (f38 + 3083);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-23, -112, -23, -112, -30, -64, -66, -63}, "20209bec43", 0.0f));
                    break;
                case 54333758:
                    int i12 = f42 * (f38 + 1840);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-67, -109, -17, -99, -23, -106, -29, -60}, "f549228f", true));
                    break;
                case 54360762:
                    int i13 = f42 * (f38 ^ 1394);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-72, -109, -71, -112, -30, -105, -17, -106}, "c6b393445efc85", true));
                    break;
                case 54362464:
                    int i14 = f42 * (f38 + 2561);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-24, -103, -19, -63, -22, -60, -72, -103}, "316f1ac8a922d4d6"));
                    break;
                case 54362556:
                    int i15 = f42 * (f38 ^ 302);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-71, -101, -20, -58, -65, -97, -72, -82}, "b37ad9c146", 0.0f));
                    break;
                case 54422077:
                    int i16 = f42 * (f38 + 7482);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-19, -107, -65, -6, -71, -63, -17, -112}, "61deba40a9", 0));
                    break;
                case 54423039:
                    int i17 = f42 * (f38 | 4265);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-67, -110, -23, -110, -66, -111, -18, -105}, "f420e95125", 0.0f));
                    break;
                case 54425051:
                    int i18 = f42 * (f38 + 1615);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-18, -64, -21, -64, -66, -108, -18, -105}, "5b0de153", 0.0f));
                    break;
                case 54425080:
                    int i19 = f42 * (f38 ^ 5492);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-72, -60, -20, -112, -17, -57, -72, -51}, "ce714a", 0.0f));
                    break;
                case 54426073:
                    int i20 = f42 * (f38 | 4544);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-67, -105, -71, -111, -67, -60, -18, -111}, "f7b3fc5965ab", 7));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۠ۤۧ, reason: not valid java name and contains not printable characters */
    public static List m169(Object obj, int i) {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-70, -98, -66, -63, -24, -103, -29, -59}, "a8ef388e7bbfb1b1", true));
        while (true) {
            switch (iM329) {
                case 54153863:
                    int i2 = f42 * (f38 | 3194);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-19, -110, -72, -89, -29, -59, -23, -50}, "67c88c2f7a03f3d7"));
                    break;
                case 54179130:
                    if (eRLkMqbO.m105() < 0) {
                        return ((PackageManager) obj).getInstalledApplications(i);
                    }
                    return null;
                case 54179810:
                    int i3 = f42 * (f38 | 7177);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-23, -53, -22, -98, -19, -87, -21, -108}, "2c1866011f1aad", true));
                    break;
                case 54182852:
                    int i4 = f42 * (f38 | 5573);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-67, -106, -66, -87, -17, -100, -20, -62}, "f6e6447a06459a", 0.0f));
                    break;
                case 54183752:
                    int i5 = f42 * (f38 | 2942);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-70, -105, -30, -54, -71, -101, -18, -6}, "a29bb35ea5", 0.0f));
                    break;
                case 54186575:
                    int i6 = f42 * (f38 | 3764);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-17, -102, -17, -7, -23, -111, -67, -64}, "424f27ff28210e79", false));
                    break;
                case 54209670:
                    int i7 = f42 * (f38 | 6327);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-30, -106, -29, -61, -29, -58, -72, -110}, "918b8ec0", 6));
                    break;
                case 54240417:
                    int i8 = f42 * (f38 ^ 5146);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-72, -57, -71, -111, -17, -101, -21, -111}, "ceb44805", 0.0f));
                    break;
                case 54244324:
                    int i9 = f42 * (f38 | 2437);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-18, -4, -30, -63, -19, -85, -72, -59}, "5c9e64cdb36d"));
                    break;
                case 54247114:
                    int i10 = f42 * (f38 + 4926);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-17, -61, -24, -112, -65, -55, -66, -112}, "4f37dae3", false));
                    break;
                case 54277157:
                    int i11 = f42 * (f38 + 2555);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-66, -105, -21, -104, -18, -60, -23, -103}, "e6085e218883"));
                    break;
                case 54328028:
                    int i12 = f42 * (f38 + 6634);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-66, -112, -24, -112, -18, -112, -29, -100}, "e7385884de3097", 7));
                    break;
                case 54335773:
                    int i13 = f42 * (f38 | 4872);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-72, -63, -29, -109, -20, -112, -71, -62}, "cf8672ba", 3));
                    break;
                case 54336730:
                    int i14 = f42 * (f38 | 2852);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-29, -106, -18, -50, -17, -101, -19, -52}, "855f436d", true));
                    break;
                case 54364600:
                    int i15 = f42 * (f38 + 167);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-18, -107, -21, -108, -65, -61, -71, -61}, "5500dabe0d5d3f", true));
                    break;
                case 54365344:
                    int i16 = f42 * (f38 | 39);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-23, -107, -23, -111, -66, -85, -70, -108}, "2521e4a54ac352", 7));
                    break;
                case 54389433:
                    int i17 = f42 * (f38 + 4218);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-71, -63, -72, -61, -24, -57, -71, -64}, "bccb3fbc9e21c3e0", 0.0f));
                    break;
                case 54393247:
                    int i18 = f42 * (f38 ^ 405);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-30, -109, -19, -62, -65, -106, -20, -110}, "936ad277aa69fe", true));
                    break;
                case 54396321:
                    int i19 = f42 * (f38 | 3842);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-20, -110, -22, -63, -66, -109, -70, -50}, "721fe3af71", false));
                    break;
                case 54417399:
                    int i20 = f42 * (f38 ^ 2600);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-17, -107, -22, -54, -29, -112, -30, -57}, "471b809c2c55", false));
                    break;
                case 54423908:
                    int i21 = f42 * (f38 ^ 7457);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-71, -112, -67, -107, -20, -52, -19, -61}, "b6f37d6cfa06", 6));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۥۣۤ, reason: not valid java name and contains not printable characters */
    public static AssetManager m170(Object obj) {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-17, -107, -23, -63, -18, -97, -66, -107}, "472d59e73aa47f", 0.0f));
        while (true) {
            switch (iM347) {
                case 54154953:
                    int i = f42 * (f38 | 5799);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-71, -61, -29, -61, -19, -60, -71, -58}, "be8c6f", 4));
                    break;
                case 54155074:
                    int i2 = f42 * (f38 + 1568);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-22, -109, -65, -108, -20, -111, -29, -110}, "16d074807b36", 3));
                    break;
                case 54182917:
                    int i3 = f42 * (f38 + 1871);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-19, -63, -70, -103, -29, -6, -67, -58}, "6ca18efa", 1));
                    break;
                case 54183935:
                    int i4 = f42 * (f38 + 3455);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-22, -97, -65, -112, -66, -108, -70, -62}, "17d6e5abe3", 1));
                    break;
                case 54211555:
                    int i5 = f42 * (f38 + 3530);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-21, -53, -20, -102, -18, -106, -65, -105}, "0c7957d6"));
                    break;
                case 54217413:
                    int i6 = f42 * (f38 | 504);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-71, -7, -21, -111, -66, -58, -22, -57}, "bf04ea1d", true));
                    break;
                case 54244415:
                    int i7 = f42 * (f38 ^ 8124);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-24, -59, -29, -59, -18, -99, -23, -112}, "3a8b5527e751"));
                    break;
                case 54247086:
                    int i8 = f42 * (f38 + 7584);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-29, -106, -72, -107, -21, -109, -17, -109}, "87c70341b64b0a"));
                    break;
                case 54304742:
                    int i9 = f42 * (f38 | 2711);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-19, -110, -67, -111, -20, -82, -29, -108}, "67f57186d48540", 0.0f));
                    break;
                case 54304959:
                    int i10 = f42 * (f38 + 5335);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-19, -100, -67, -112, -23, -112, -24, -111}, "69f72735b30178", true));
                    break;
                case 54305986:
                    int i11 = f42 * (f38 + 251);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-18, -109, -19, -57, -21, -51, -70, -107}, "536c0ea662b051", false));
                    break;
                case 54328956:
                    int i12 = f42 * (f38 | 1147);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-18, -59, -30, -110, -72, -112, -19, -100}, "5e91c664853f4116"));
                    break;
                case 54330724:
                    int i13 = f42 * (f38 ^ 2404);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-18, -105, -20, -104, -19, -106, -18, -109}, "507866"));
                    break;
                case 54331715:
                    if (Z5HFgwkz.m63() >= 0) {
                        return ((Resources) obj).getAssets();
                    }
                    return null;
                case 54332610:
                    int i14 = f42 * (f38 | 6786);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-23, -99, -67, -109, -17, -57, -70, -59}, "29f54aaf86be88e3", 7));
                    break;
                case 54332796:
                    int i15 = f42 * (f38 + 5252);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-19, -107, -20, -106, -67, -99, -29, -60}, "6076f88bffef4421", 0.0f));
                    break;
                case 54335743:
                    int i16 = f42 * (f38 ^ 2933);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-65, -62, -66, -54, -66, -111, -19, -62}, "dcebe26cd4", 5));
                    break;
                case 54358651:
                    int i17 = f42 * (f38 + 7966);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-29, -107, -72, -106, -23, -112, -29, -106}, "80c521", 7));
                    break;
                case 54388380:
                    int i18 = f42 * (f38 + 4411);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-66, -59, -65, -109, -70, -5, -70, -101}, "ead5ada8415b", 5));
                    break;
                case 54421083:
                    int i19 = f42 * (f38 ^ 4780);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-17, -52, -21, -58, -20, -109, -30, -59}, "4d0a769a6e984a66", true));
                    break;
                case 54423965:
                    int i20 = f42 * (f38 ^ 4896);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-71, -64, -71, -112, -67, -60, -71, -62}, "beb2fd", false));
                    break;
                case 54425054:
                    int i21 = f42 * (f38 + 7617);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-29, -83, -20, -63, -72, -57, -70, -64}, "827dcdaf8410"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۧۦۧ, reason: not valid java name and contains not printable characters */
    public static String m171(short[] sArr, int i, int i2, int i3) {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-17, -112, -70, -105, -70, -104, -72, -58}, "44a5a9cd0958074a", true));
        while (true) {
            switch (iM329) {
                case 54155073:
                    int i4 = f42 * (f38 ^ 3639);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-65, -111, -65, -86, -19, -62, -30, -52}, "d1d56a9d", 0.0f));
                    break;
                case 54156038:
                    int i5 = f42 * (f38 + 3139);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-21, -58, -18, -59, -66, -108, -24, -110}, "0c5ae33204383d98"));
                    break;
                case 54178980:
                    int i6 = f42 * (f38 | 3532);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-17, -97, -72, -103, -72, -63, -67, -81}, "49c8ccf095e5ad", 7));
                    break;
                case 54180868:
                    int i7 = f42 * (f38 ^ 4700);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-17, -63, -17, -82, -66, -105, -29, -99}, "4e41e789"));
                    break;
                case 54182753:
                    int i8 = f42 * (f38 + 8103);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-17, -109, -22, -6, -67, -7, -17, -109}, "411eff", true));
                    break;
                case 54210692:
                    int i9 = f42 * (f38 | 4811);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-66, -101, -67, -61, -19, -52, -67, -59}, "e9ff6dfeeb41a4ed", 0.0f));
                    break;
                case 54238432:
                    int i10 = f42 * (f38 + 7131);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-65, -105, -72, -62, -30, -110, -20, -61}, "d1ce977cb2ad0a", true));
                    break;
                case 54238616:
                    int i11 = f42 * (f38 + 4965);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-20, -63, -19, -107, -66, -103, -17, -111}, "7f60e8459042f002", 0.0f));
                    break;
                case 54244475:
                    char[] cArr = new char[i2];
                    for (int i12 = 0; i12 < i2; i12++) {
                        cArr[i12] = (char) (sArr[i + i12] ^ i3);
                    }
                    return new String(cArr);
                case 54245221:
                    int i13 = f42 * (f38 ^ 2964);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-29, -84, -22, -60, -71, -98, -17, -102}, "831ab948c1"));
                    break;
                case 54246337:
                    int i14 = f42 * (f38 | 4276);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-29, -57, -66, -57, -22, -60, -19, -61}, "8cee1f6c6bdd", 1));
                    break;
                case 54275909:
                    int i15 = f42 * (f38 | 3473);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-66, -112, -29, -82, -23, -108, -29, -109}, "e2812183092cefaf", false));
                    break;
                case 54298047:
                    int i16 = f42 * (f38 + 604);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-29, -2, -24, -111, -29, -105, -18, -105}, "8a3780515565"));
                    break;
                case 54300959:
                    int i17 = f42 * (f38 + 5245);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-22, -109, -29, -60, -30, -2, -66, -106}, "108c9ae6933bfe4e", 0.0f));
                    break;
                case 54300988:
                    int i18 = f42 * (f38 + 3021);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-70, -62, -20, -110, -23, -112, -66, -111}, "ac7323e6b3fa218a", true));
                    break;
                case 54306915:
                    int i19 = f42 * (f38 | 6295);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-70, -98, -29, -57, -65, -111, -18, -108}, "a68cd555dcdabb", 0.0f));
                    break;
                case 54330809:
                    int i20 = f42 * (f38 | 4409);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-30, -64, -70, -60, -66, -107, -70, -105}, "9bace3a558d0"));
                    break;
                case 54332856:
                    int i21 = f42 * (f38 ^ 1257);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-65, -111, -21, -105, -20, -107, -67, -111}, "d30174f3", false));
                    break;
                case 54359608:
                    int i22 = f42 * (f38 + 6545);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-22, -112, -70, -107, -65, -54, -17, -89}, "18a1db48acba5f", 4));
                    break;
                case 54365468:
                    int i23 = f42 * (f38 + 7517);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-71, -104, -70, -109, -66, -61, -23, -106}, "b8a2ea23", true));
                    break;
                case 54393217:
                    int i24 = f42 * (f38 | 5943);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-24, -108, -29, -111, -24, -110, -29, -2}, "3482338af48f"));
                    break;
                case 54422137:
                    int i25 = f42 * (f38 + 2523);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-22, -58, -21, -108, -29, -111, -30, -81}, "1c068290", 0.0f));
                    break;
                case 54422259:
                    int i26 = f42 * (f38 ^ 294);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-30, -62, -66, -102, -30, -60, -21, -105}, "9fe29c01293e12", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۨۡ۠, reason: not valid java name and contains not printable characters */
    private static String m172() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-65, -108, -66, -108, -29, -64, -65, -62}, "d1e38ddc0583"));
        while (true) {
            switch (iM347) {
                case 54152969:
                    int i = f42 * (f38 | 5371);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-65, -62, -67, -105, -23, -86, -23, -62}, "dff5252bd45dec", true));
                    break;
                case 54179872:
                    int i2 = f42 * (f38 + 988);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-30, -106, -24, -87, -66, -52, -20, -101}, "9336ed73", 4));
                    break;
                case 54209732:
                    int i3 = f42 * (f38 ^ 2040);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-20, -98, -66, -112, -67, -63, -17, -107}, "78e3fd45ad79bf", false));
                    break;
                case 54215559:
                    int i4 = f42 * (f38 + 4713);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-66, -62, -29, -59, -19, -62, -66, -60}, "ef8d6f", 0.0f));
                    break;
                case 54274243:
                    int i5 = f42 * (f38 | 7681);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-21, -51, -66, -109, -22, -102, -23, -110}, "0ee11922cd9a"));
                    break;
                case 54300091:
                    int i6 = f42 * (f38 | 4829);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-22, -61, -19, -7, -22, -63, -19, -62}, "1e6f1d6b4ef590"));
                    break;
                case 54300126:
                    int i7 = f42 * (f38 + 3132);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-22, -60, -21, -110, -67, -59, -17, -104}, "1c01fa48ed", 0.0f));
                    break;
                case 54300895:
                    int i8 = f42 * (f38 ^ 4754);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-65, -54, -17, -105, -22, -108, -17, -59}, "db46134d0fd9e5b3", 0.0f));
                    break;
                case 54328090:
                    int i9 = f42 * (f38 ^ 1009);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-24, -105, -66, -99, -30, -63, -65, -99}, "30e99dd59521", 0.0f));
                    break;
                case 54335647:
                    int i10 = f42 * (f38 + 5319);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-21, -112, -21, -110, -30, -59, -30, -52}, "03079b9d19cd08", 4));
                    break;
                case 54336517:
                    return C0005.m336(f45, 149, 1081278752 ^ C0000.f62, 4);
                case 54357780:
                    int i11 = f42 * (f38 | 3581);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-71, -100, -19, -57, -67, -61, -71, -106}, "b46cfb"));
                    break;
                case 54361624:
                    int i12 = f42 * (f38 ^ 6329);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-29, -62, -22, -51, -23, -99, -24, -61}, "8d1e253c", 0));
                    break;
                case 54366522:
                    int i13 = f42 * (f38 ^ 1941);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-21, -99, -23, -98, -30, -106, -20, -58}, "0826977ed64b4f35", 2));
                    break;
                case 54389498:
                    int i14 = f42 * (f38 | 4388);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-30, -90, -22, -111, -70, -111, -30, -110}, "9912a0942f30", true));
                    break;
                case 54391384:
                    int i15 = f42 * (f38 ^ 7683);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-21, -109, -18, -60, -18, -57, -24, -110}, "045e5b37a283cdd4"));
                    break;
                case 54392384:
                    int i16 = f42 * (f38 ^ 3800);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-29, -57, -67, -59, -22, -58, -30, -108}, "8ffc1c93", 0.0f));
                    break;
                case 54393185:
                    int i17 = f42 * (f38 ^ 825);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-24, -100, -71, -111, -65, -105, -29, -97}, "38b0d289"));
                    break;
                case 54395236:
                    int i18 = f42 * (f38 | 1146);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-67, -110, -30, -110, -66, -57, -21, -106}, "f292ef0754", false));
                    break;
                case 54419347:
                    int i19 = f42 * (f38 ^ 6198);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-66, -103, -22, -63, -72, -105, -23, -97}, "e81ac427", 0.0f));
                    break;
                case 54420183:
                    int i20 = f42 * (f38 | 3674);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-22, -105, -20, -62, -20, -62, -22, -104}, "107e7f", true));
                    break;
                case 54422045:
                    int i21 = f42 * (f38 + 3466);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-23, -98, -18, -57, -67, -103, -24, -112}, "295bf9337e93", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۨۦۤۨ۠, reason: not valid java name and contains not printable characters */
    private static String m173() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-17, -104, -20, -112, -30, -101, -17, -102}, "497598", 0.0f));
        while (true) {
            switch (iM347) {
                case 54150209:
                    int i = f42 * (f38 | 916);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-72, -111, -20, -61, -30, -58, -72, -110}, "c67c9b", 1));
                    break;
                case 54152218:
                    int i2 = f42 * (f38 | 1528);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-23, -53, -19, -98, -30, -104, -22, -112}, "2c6998165d6ad9", true));
                    break;
                case 54153867:
                    int i3 = f42 * (f38 ^ 600);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-65, -83, -29, -63, -70, -60, -65, -63}, "d28aaadd", 3));
                    break;
                case 54182818:
                    int i4 = f42 * (f38 ^ 4186);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-21, -108, -17, -7, -23, -111, -20, -87}, "064f267640d7", 1));
                    break;
                case 54211525:
                    int i5 = f42 * (f38 + 4679);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-19, -111, -30, -105, -72, -58, -67, -104}, "6392cff0b117", true));
                    break;
                case 54211680:
                    int i6 = f42 * (f38 + 3771);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-65, -111, -23, -106, -66, -61, -22, -101}, "d320ee19980aa7", true));
                    break;
                case 54214532:
                    int i7 = f42 * (f38 | 8053);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-66, -111, -65, -100, -70, -59, -66, -112}, "e0d9ac", 0));
                    break;
                case 54214622:
                    int i8 = f42 * (f38 | 5978);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-70, -109, -30, -2, -67, -108, -18, -106}, "a19af254122f"));
                    break;
                case 54217482:
                    int i9 = f42 * (f38 + 4433);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-66, -112, -65, -112, -66, -107, -17, -3}, "e7d1e44bc4723967", true));
                    break;
                case 54238649:
                    int i10 = f42 * (f38 ^ 2689);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-18, -61, -29, -108, -67, -112, -17, -58}, "5d83f84f9dff"));
                    break;
                case 54238677:
                    int i11 = f42 * (f38 | 2214);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-71, -61, -22, -52, -19, -64, -18, -112}, "bb1d6e582e8c", true));
                    break;
                case 54244235:
                    return C0005.m336(f45, 40, 360503660 ^ C0007.f76, 7);
                case 54245376:
                    int i12 = f42 * (f38 ^ 1610);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-20, -108, -66, -57, -22, -101, -67, -108}, "74ed18f660", 0.0f));
                    break;
                case 54273030:
                    int i13 = f42 * (f38 + 3992);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-20, -57, -18, -111, -71, -102, -20, -57}, "7c57b9"));
                    break;
                case 54304867:
                    int i14 = f42 * (f38 ^ 363);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-24, -84, -22, -64, -24, -53, -67, -87}, "331b3cf67c4a5e53", true));
                    break;
                case 54388505:
                    int i15 = f42 * (f38 | 5934);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-20, -110, -22, -102, -23, -83, -18, -108}, "73182257", 0.0f));
                    break;
                case 54389368:
                    int i16 = f42 * (f38 | 6345);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-24, -5, -65, -99, -21, -3, -24, -63}, "3dd90b", true));
                    break;
                case 54395352:
                    int i17 = f42 * (f38 | 813);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-30, -105, -22, -63, -71, -6, -23, -62}, "941ebe2fb0508b5d"));
                    break;
                case 54396254:
                    int i18 = f42 * (f38 + 6155);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-29, -104, -17, -63, -70, -100, -21, -59}, "894ca80f541822"));
                    break;
                case 54424901:
                    int i19 = f42 * (f38 | 7876);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-21, -105, -66, -52, -21, -64, -22, -106}, "00ed0f1544", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۡۦۦ, reason: not valid java name and contains not printable characters */
    private static String m174() {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-71, -81, -72, -105, -19, -106, -24, -112}, "b0c7673439ac"));
        while (true) {
            switch (iM317) {
                case 54150025:
                    int i = f42 * (f38 + 6364);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-19, -58, -72, -98, -19, -106, -18, -112}, "6dc6615389", 2));
                    break;
                case 54150056:
                    int i2 = f42 * (f38 ^ 3000);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-66, -106, -23, -109, -66, -52, -67, -59}, "e226edfa2a2847", true));
                    break;
                case 54150084:
                    int i3 = f42 * (f38 + 2895);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-18, -81, -19, -103, -65, -109, -18, -105}, "5069d3", 1));
                    break;
                case 54153031:
                    int i4 = f42 * (f38 ^ 2406);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-66, -99, -20, -98, -30, -51, -17, -105}, "e5789e420f37b38f", 0.0f));
                    break;
                case 54156036:
                    int i5 = f42 * (f38 ^ 6696);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-19, -109, -17, -105, -24, -60, -29, -63}, "65423f8f5902ab", 0));
                    break;
                case 54179036:
                    int i6 = f42 * (f38 ^ 953);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-17, -111, -65, -108, -24, -84, -70, -84}, "43d133a363"));
                    break;
                case 54179963:
                    return C0005.m336(f45, 155, 188831983 ^ C0006.f74, 27);
                case 54184706:
                    int i7 = f42 * (f38 + 5445);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-21, -109, -19, -107, -18, -100, -29, -98}, "02675888a8", 0.0f));
                    break;
                case 54208672:
                    int i8 = f42 * (f38 + 6216);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-30, -60, -19, -111, -29, -84, -21, -106}, "9f63830107c080eb", true));
                    break;
                case 54211683:
                    int i9 = f42 * (f38 | 2763);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-20, -6, -17, -58, -20, -4, -19, -62}, "7e4f7c6ec0db1d", 4));
                    break;
                case 54215647:
                    int i10 = f42 * (f38 | 8159);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-30, -107, -20, -107, -70, -110, -30, -86}, "9570a0", 0.0f));
                    break;
                case 54241320:
                    int i11 = f42 * (f38 | 883);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-71, -105, -24, -108, -19, -110, -21, -7}, "b734660f0f7cd38d", 0.0f));
                    break;
                case 54244195:
                    int i12 = f42 * (f38 + 7129);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-67, -60, -67, -109, -24, -100, -18, -106}, "faf63455d0fe"));
                    break;
                case 54247330:
                    int i13 = f42 * (f38 | 479);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-67, -112, -67, -108, -66, -109, -24, -103}, "f8f6e338", true));
                    break;
                case 54304061:
                    int i14 = f42 * (f38 | 4335);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-72, -6, -66, -57, -29, -63, -19, -108}, "ceea8f609ad2aa", 6));
                    break;
                case 54333851:
                    int i15 = f42 * (f38 + 1671);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-29, -82, -18, -110, -67, -107, -20, -64}, "8151f67fd8fce850", 1));
                    break;
                case 54360483:
                    int i16 = f42 * (f38 + 5288);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-66, -104, -71, -111, -24, -109, -23, -64}, "e0b0352a8230b558", true));
                    break;
                case 54363460:
                    int i17 = f42 * (f38 | 6097);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-29, -109, -24, -107, -72, -100, -17, -57}, "8233c44e"));
                    break;
                case 54419316:
                    int i18 = f42 * (f38 ^ 7598);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-29, -60, -18, -88, -21, -112, -24, -102}, "8d570538", 0.0f));
                    break;
                case 54420091:
                    int i19 = f42 * (f38 | 2258);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-30, -64, -17, -110, -24, -87, -20, -109}, "9f4036752a6a8da8", 6));
                    break;
                case 54424187:
                    int i20 = f42 * (f38 ^ 6807);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-66, -110, -24, -82, -29, -108, -70, -110}, "e33184a05d"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۡۥۦ, reason: not valid java name and contains not printable characters */
    public static String m175() {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-20, -58, -72, -63, -21, -60, -65, -99}, "7bcf0ad9", 0.0f));
        while (true) {
            switch (iM310) {
                case 54180802:
                    int i = f42 * (f38 ^ 369);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-19, -57, -22, -64, -17, -57, -21, -61}, "6b1c4a0da671"));
                    break;
                case 54183873:
                    int i2 = f42 * (f38 + 6382);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-24, -105, -22, -102, -67, -105, -19, -53}, "3412f36c1e", false));
                    break;
                case 54210690:
                    int i3 = f42 * (f38 + 6855);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-18, -108, -67, -97, -23, -112, -18, -111}, "52f926", true));
                    break;
                case 54216582:
                    int i4 = f42 * (f38 + 3267);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-21, -107, -71, -106, -24, -105, -30, -64}, "03b7379fd0"));
                    break;
                case 54217451:
                    int i5 = f42 * (f38 ^ 820);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-19, -59, -19, -103, -17, -61, -67, -112}, "6c694bf03b", 1));
                    break;
                case 54245194:
                    int i6 = f42 * (f38 ^ 7022);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-70, -63, -24, -112, -18, -110, -19, -59}, "aa31526dc1", 0.0f));
                    break;
                case 54268257:
                    int i7 = f42 * (f38 + 1704);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-21, -109, -66, -89, -23, -105, -72, -103}, "06e822c83efab0"));
                    break;
                case 54268440:
                    int i8 = f42 * (f38 + 7594);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-22, -111, -71, -62, -30, -60, -17, -57}, "16ba9f4a", 0.0f));
                    break;
                case 54271297:
                    if (Z5HFgwkz.m63() > 0) {
                        return m194();
                    }
                    return null;
                case 54277033:
                    int i9 = f42 * (f38 ^ 6531);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-24, -58, -66, -110, -29, -107, -17, -2}, "3ce7824a", false));
                    break;
                case 54298298:
                    int i10 = f42 * (f38 + 2172);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-20, -111, -18, -108, -20, -100, -66, -112}, "725679e7f12c", 5));
                    break;
                case 54305890:
                    int i11 = f42 * (f38 | 224);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-21, -60, -22, -106, -29, -98, -20, -111}, "0d128872a5a96564"));
                    break;
                case 54327990:
                    int i12 = f42 * (f38 + 2785);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-20, -64, -17, -107, -71, -103, -22, -105}, "7b43b9113281348c", true));
                    break;
                case 54331871:
                    int i13 = f42 * (f38 + 3420);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-72, -99, -24, -89, -21, -54, -72, -97}, "c9380bc8474f4c", false));
                    break;
                case 54333816:
                    int i14 = f42 * (f38 ^ 6237);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-71, -53, -22, -86, -17, -112, -23, -107}, "bc154827", 0.0f));
                    break;
                case 54358617:
                    int i15 = f42 * (f38 + 3744);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-21, -108, -66, -87, -66, -110, -65, -105}, "07e6e4d5462c", false));
                    break;
                case 54359553:
                    int i16 = f42 * (f38 ^ 8166);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-67, -109, -21, -99, -24, -58, -67, -111}, "f2053bf901e6e4ec", 0.0f));
                    break;
                case 54364541:
                    int i17 = f42 * (f38 + 1287);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-21, -53, -19, -106, -17, -105, -19, -64}, "0c60476c", 0.0f));
                    break;
                case 54391328:
                    int i18 = f42 * (f38 + 1031);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-23, -107, -19, -97, -65, -58, -30, -108}, "2268da93d4badee1", 0.0f));
                    break;
                case 54395328:
                    int i19 = f42 * (f38 ^ 3003);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-67, -110, -30, -86, -29, -61, -19, -109}, "f1958c662f45e1", false));
                    break;
                case 54417457:
                    int i20 = f42 * (f38 + 1546);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-17, -106, -67, -105, -29, -57, -24, -100}, "47f68d392d35fc36", 0.0f));
                    break;
                case 54423937:
                    int i21 = f42 * (f38 + 5186);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-22, -112, -17, -106, -20, -63, -22, -98}, "11417f1911", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۧۨ۟ۦۤ, reason: not valid java name and contains not printable characters */
    private static String m176() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-67, -60, -72, -112, -72, -64, -67, -58}, "ffc1cc", 1));
        while (true) {
            switch (iM329) {
                case 54181885:
                    int i = f42 * (f38 | 7241);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-23, -62, -29, -82, -17, -109, -29, -58}, "2a81428df17e2e"));
                    break;
                case 54210561:
                    int i2 = f42 * (f38 + 309);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-65, -60, -20, -62, -21, -108, -65, -111}, "de7e00d1"));
                    break;
                case 54216482:
                    int i3 = f42 * (f38 ^ 4323);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-66, -106, -22, -108, -22, -62, -71, -60}, "e2111cbe7eec7e44"));
                    break;
                case 54238654:
                    int i4 = f42 * (f38 ^ 6919);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-30, -111, -72, -55, -19, -106, -67, -59}, "94ca67fa50462f", 5));
                    break;
                case 54240476:
                    int i5 = f42 * (f38 ^ 3254);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-29, -107, -20, -58, -71, -104, -29, -88}, "877cb9"));
                    break;
                case 54243297:
                    int i6 = f42 * (f38 | 1361);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-24, -105, -29, -63, -18, -59, -30, -58}, "348a5e9a", 0.0f));
                    break;
                case 54244257:
                    int i7 = f42 * (f38 ^ 1996);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-21, -58, -70, -97, -24, -111, -21, -61}, "0aa931"));
                    break;
                case 54268285:
                    int i8 = f42 * (f38 | 1691);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-19, -107, -20, -62, -20, -111, -72, -97}, "637f74c8", true));
                    break;
                case 54269220:
                    int i9 = f42 * (f38 ^ 134);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-17, -62, -29, -63, -70, -111, -72, -110}, "4a8aa9c742e713e6"));
                    break;
                case 54269466:
                    int i10 = f42 * (f38 | 2073);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-20, -60, -65, -106, -24, -112, -20, -57}, "7ad336"));
                    break;
                case 54303841:
                    return C0005.m336(f45, 182, 1855076278 ^ C0006.f74, 10);
                case 54305793:
                    int i11 = f42 * (f38 + 4234);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-17, -107, -70, -107, -65, -90, -72, -110}, "44a4d9c21cc5e496", 0.0f));
                    break;
                case 54329011:
                    int i12 = f42 * (f38 ^ 1559);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-21, -110, -71, -64, -19, -112, -67, -5}, "02bb64fd8a3981", false));
                    break;
                case 54333792:
                    int i13 = f42 * (f38 | 2394);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-70, -109, -24, -61, -70, -102, -17, -61}, "a73da84c"));
                    break;
                case 54336518:
                    int i14 = f42 * (f38 ^ 4384);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-30, -51, -70, -109, -30, -101, -30, -100}, "9ea69898759f"));
                    break;
                case 54358715:
                    int i15 = f42 * (f38 ^ 1568);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-70, -105, -21, -58, -19, -98, -70, -83}, "a20f69", 0.0f));
                    break;
                case 54359555:
                    int i16 = f42 * (f38 | 3280);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-17, -106, -67, -106, -66, -112, -19, -106}, "40f6e463d2c6", 5));
                    break;
                case 54362592:
                    int i17 = f42 * (f38 | 3629);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-29, -112, -72, -87, -19, -64, -17, -110}, "82c66f45c85231", false));
                    break;
                case 54394145:
                    int i18 = f42 * (f38 + 4999);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-21, -109, -30, -111, -71, -112, -67, -50}, "0590b0ff54509822"));
                    break;
                case 54423070:
                    int i19 = f42 * (f38 | 1711);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-29, -105, -72, -99, -71, -107, -71, -108}, "85c9b4b458", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۨۤۨ۟, reason: not valid java name and contains not printable characters */
    private static String m177() {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-24, -63, -65, -55, -66, -107, -66, -62}, "3fdae3eb1e3822b5", 0.0f));
        while (true) {
            switch (iM338) {
                case 54152003:
                    int i = f42 * (f38 ^ 6466);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-67, -100, -23, -6, -24, -111, -66, -97}, "f42e39e75fda61", 0.0f));
                    break;
                case 54185762:
                    int i2 = f42 * (f38 ^ 4819);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-67, -61, -20, -59, -23, -64, -18, -105}, "fb7f2d57f864"));
                    break;
                case 54209790:
                    int i3 = f42 * (f38 + 944);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-70, -97, -67, -108, -66, -107, -20, -87}, "a9f4e776466c"));
                    break;
                case 54210600:
                    int i4 = f42 * (f38 | 4924);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-30, -60, -67, -86, -65, -110, -30, -107}, "9cf5d597ce", 0.0f));
                    break;
                case 54212638:
                    int i5 = f42 * (f38 | 3821);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-67, -7, -30, -102, -72, -106, -17, -64}, "ff98c74a", 2));
                    break;
                case 54238711:
                    int i6 = f42 * (f38 + 7812);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-67, -110, -70, -105, -65, -60, -70, -106}, "f7a6dea090f1a571", true));
                    break;
                case 54241344:
                    int i7 = f42 * (f38 ^ 7546);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-20, -106, -30, -57, -29, -102, -20, -85}, "749e88", true));
                    break;
                case 54241405:
                    int i8 = f42 * (f38 ^ 6923);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-70, -107, -20, -110, -29, -6, -29, -62}, "a6758e8f2e2f"));
                    break;
                case 54242336:
                    int i9 = f42 * (f38 | 5384);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-24, -60, -29, -107, -71, -112, -17, -107}, "3d83b544db7099", 3));
                    break;
                case 54275913:
                    int i10 = f42 * (f38 | 309);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-19, -110, -21, -83, -21, -63, -17, -60}, "66020b4a275441"));
                    break;
                case 54276157:
                    int i11 = f42 * (f38 ^ 7166);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-70, -62, -66, -107, -22, -97, -19, -5}, "ade5196d2cef", 0.0f));
                    break;
                case 54298141:
                    int i12 = f42 * (f38 + 4773);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-71, -62, -17, -63, -18, -58, -67, -104}, "bd4a5ff02d6661ec", 0.0f));
                    break;
                case 54329793:
                    int i13 = f42 * (f38 + 6822);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-66, -109, -17, -62, -72, -105, -22, -107}, "e14ac6151a82", 0.0f));
                    break;
                case 54330966:
                    int i14 = f42 * (f38 | 5804);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-19, -111, -67, -112, -65, -110, -17, -111}, "63f2d241", 5));
                    break;
                case 54358594:
                    int i15 = f42 * (f38 | 4390);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-65, -104, -23, -63, -22, -64, -65, -99}, "d92a1e", 4));
                    break;
                case 54358647:
                    int i16 = f42 * (f38 ^ 2526);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-72, -103, -21, -57, -29, -107, -20, -51}, "c80f857edf73e8c8", 6));
                    break;
                case 54358771:
                    return C0005.m336(f45, 116, 1419216794 ^ C0005.f72, 8);
                case 54387635:
                    int i17 = f42 * (f38 | 6073);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-24, -64, -67, -112, -19, -111, -72, -58}, "3cf766cf", false));
                    break;
                case 54388540:
                    int i18 = f42 * (f38 | 5610);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-19, -112, -67, -81, -30, -55, -19, -112}, "62f09a", 0.0f));
                    break;
                case 54396251:
                    int i19 = f42 * (f38 + 488);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-19, -110, -19, -104, -72, -106, -19, -99}, "6568c3", true));
                    break;
                case 54417463:
                    int i20 = f42 * (f38 ^ 1843);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-67, -112, -18, -63, -18, -97, -67, -108}, "f55c57", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢ۠ۦۦ, reason: not valid java name and contains not printable characters */
    private static String m178() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-23, -112, -65, -3, -65, -61, -23, -102}, "27dbda2245", 3));
        while (true) {
            switch (iM329) {
                case 54151012:
                    int i = f42 * (f38 ^ 2932);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-29, -61, -71, -59, -29, -108, -29, -64}, "8aba85", 6));
                    break;
                case 54151948:
                    int i2 = f42 * (f38 + 3846);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-18, -103, -72, -105, -19, -109, -71, -106}, "59c761b7e9bf", true));
                    break;
                case 54154140:
                    return C0005.m336(f45, 7, 1008941514 ^ C0000.f62, 8);
                case 54179903:
                    int i3 = f42 * (f38 + 7474);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-21, -102, -30, -58, -17, -58, -71, -111}, "089f4bb652fe", false));
                    break;
                case 54209885:
                    int i4 = f42 * (f38 + 5398);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-71, -89, -30, -57, -23, -59, -20, -64}, "b89f2e7b"));
                    break;
                case 54213571:
                    int i5 = f42 * (f38 + 4501);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-23, -58, -17, -105, -67, -59, -19, -106}, "2e43fd679afc5f", 2));
                    break;
                case 54217482:
                    int i6 = f42 * (f38 ^ 6509);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-18, -101, -30, -105, -22, -58, -65, -101}, "58961ed8b47a33", false));
                    break;
                case 54239553:
                    int i7 = f42 * (f38 | 7639);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-66, -107, -22, -64, -67, -58, -30, -63}, "e01dfc9c801bcebe", 4));
                    break;
                case 54242402:
                    int i8 = f42 * (f38 ^ 4999);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-19, -97, -19, -58, -30, -111, -22, -64}, "696d971c72", 4));
                    break;
                case 54243298:
                    int i9 = f42 * (f38 | 3745);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-23, -98, -17, -63, -18, -60, -23, -98}, "294a5b", 0.0f));
                    break;
                case 54270270:
                    int i10 = f42 * (f38 ^ 5912);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-66, -112, -17, -107, -20, -112, -66, -97}, "e74372"));
                    break;
                case 54273089:
                    int i11 = f42 * (f38 + 7546);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-21, -61, -66, -110, -66, -63, -67, -64}, "0ae1ebfdd2062f"));
                    break;
                case 54277149:
                    int i12 = f42 * (f38 | 884);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-71, -58, -18, -53, -20, -59, -65, -105}, "bc5c7fd186"));
                    break;
                case 54332796:
                    int i13 = f42 * (f38 ^ 346);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-72, -59, -65, -107, -20, -112, -17, -62}, "cdd1734a73fa"));
                    break;
                case 54335683:
                    int i14 = f42 * (f38 | 751);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-21, -106, -21, -50, -67, -104, -24, -105}, "050ff0374bcd", 0.0f));
                    break;
                case 54336582:
                    int i15 = f42 * (f38 + 7828);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-70, -6, -19, -57, -17, -112, -70, -6}, "ae6c48"));
                    break;
                case 54360697:
                    int i16 = f42 * (f38 | 574);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-67, -64, -29, -58, -30, -106, -23, -59}, "fe8a932c79deedc4", 0));
                    break;
                case 54387486:
                    int i17 = f42 * (f38 | 6413);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-72, -112, -67, -5, -18, -63, -19, -59}, "c8fd5c6a64"));
                    break;
                case 54388570:
                    int i18 = f42 * (f38 ^ 347);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-18, -53, -17, -112, -72, -5, -18, -62}, "5c47cd", 4));
                    break;
                case 54394213:
                    int i19 = f42 * (f38 ^ 1292);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-67, -108, -21, -61, -23, -55, -24, -61}, "f50c2a3e", 0.0f));
                    break;
                case 54395322:
                    int i20 = f42 * (f38 ^ 5710);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-72, -106, -21, -102, -18, -107, -22, -99}, "c7025015caa4", 2));
                    break;
                case 54417273:
                    int i21 = f42 * (f38 | 3962);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-23, -60, -20, -109, -20, -107, -22, -59}, "2c74721d2a7c"));
                    break;
                case 54424865:
                    int i22 = f42 * (f38 ^ 6813);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-66, -6, -22, -111, -67, -88, -67, -51}, "ee13f7fe519c", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۥۧ۟۠, reason: not valid java name and contains not printable characters */
    public static int m179() {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-30, -54, -24, -62, -17, -63, -30, -61}, "9b3c4c"));
        while (true) {
            switch (iM323) {
                case 54152938:
                    int i = f42 * (f38 | 8019);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-18, -109, -20, -97, -29, -112, -22, -59}, "5278801bfc75d5"));
                    break;
                case 54181792:
                    int i2 = f42 * (f38 ^ 2600);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-67, -100, -19, -63, -23, -111, -65, -53}, "f46a20dc4a89"));
                    break;
                case 54185800:
                    int i3 = f42 * (f38 | 8145);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-24, -111, -30, -7, -72, -108, -70, -59}, "379fc3af", 0.0f));
                    break;
                case 54214652:
                    int i4 = f42 * (f38 | 6108);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-66, -110, -67, -63, -66, -105, -66, -106}, "e1fce5", false));
                    break;
                case 54216365:
                    int i5 = f42 * (f38 ^ 6660);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-18, -62, -67, -59, -66, -5, -72, -108}, "5ffeedc7895a3b", true));
                    break;
                case 54238432:
                    int i6 = f42 * (f38 ^ 8117);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-24, -59, -22, -107, -21, -111, -23, -105}, "3f10092341b1", 3));
                    break;
                case 54240480:
                    int i7 = f42 * (f38 | 1975);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-72, -109, -66, -2, -22, -89, -72, -109}, "c1ea18", true));
                    break;
                case 54271204:
                    int i8 = f42 * (f38 ^ 828);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-21, -2, -29, -57, -30, -110, -21, -60}, "0a8d920b44", false));
                    break;
                case 54274270:
                    int i9 = f42 * (f38 ^ 5981);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-18, -61, -65, -103, -72, -110, -67, -102}, "5dd9c1f8287327"));
                    break;
                case 54274986:
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    char c = 61584;
                    while (true) {
                        switch (c) {
                            case 46790:
                                return i10;
                            case 4658:
                                i13 = 1361187770;
                                i12 %= 64;
                                i10 ^= i11;
                                c = 46790;
                                break;
                            case 39953:
                                i12 |= (i13 % 59) % 57;
                                i13 = 308340348;
                                break;
                            case 61584:
                                i13 += 7;
                                i12 %= 24;
                                i10 = 539621165;
                                i11 = 84686378;
                                c = 4658;
                                break;
                        }
                    }
                    break;
                case 54298143:
                    int i14 = f42 * (f38 + 7336);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-20, -110, -24, -61, -29, -97, -65, -111}, "753b89d95c4b0458", 0.0f));
                    break;
                case 54298976:
                    int i15 = f42 * (f38 + 4754);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-22, -112, -17, -62, -19, -104, -71, -109}, "134d68b42459", false));
                    break;
                case 54302074:
                    int i16 = f42 * (f38 | 908);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-22, -109, -71, -111, -22, -102, -72, -112}, "11b019c4cae1907d", 0));
                    break;
                case 54305769:
                    int i17 = f42 * (f38 + 4322);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-30, -110, -22, -82, -18, -64, -70, -106}, "96115ca1", 0.0f));
                    break;
                case 54357845:
                    int i18 = f42 * (f38 | 5495);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-29, -104, -24, -61, -20, -57, -67, -89}, "883a7ff82ab7bf", 0));
                    break;
                case 54360481:
                    int i19 = f42 * (f38 ^ 8077);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-70, -57, -30, -107, -22, -106, -24, -111}, "ac961030", 1));
                    break;
                case 54388472:
                    int i20 = f42 * (f38 ^ 2059);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-24, -55, -65, -61, -70, -100, -23, -110}, "3adfa826bf", 3));
                    break;
                case 54389532:
                    int i21 = f42 * (f38 | 1459);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-72, -109, -29, -105, -18, -105, -22, -89}, "c2825018"));
                    break;
                case 54418207:
                    int i22 = f42 * (f38 | 7187);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-71, -107, -70, -60, -72, -109, -21, -59}, "b1acc20b7b423e88", 0.0f));
                    break;
                case 54419192:
                    int i23 = f42 * (f38 + 1794);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-18, -53, -21, -57, -22, -61, -66, -105}, "5c0a1fe0cf", 0.0f));
                    break;
                case 54423101:
                    int i24 = f42 * (f38 + 6426);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-70, -110, -23, -98, -72, -97, -66, -112}, "a228c9e8"));
                    break;
                case 54424096:
                    int i25 = f42 * (f38 | 391);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-67, -61, -18, -112, -24, -84, -17, -57}, "fe52334c082c", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۧ۟ۧۡ, reason: not valid java name and contains not printable characters */
    private static String m180() {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-19, -61, -70, -107, -70, -100, -17, -108}, "6ca1a9450c199b"));
        while (true) {
            switch (iM323) {
                case 54150176:
                    int i = f42 * (f38 | 7151);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-66, -109, -67, -60, -17, -81, -21, -6}, "e3fb400e5599e1"));
                    break;
                case 54154140:
                    int i2 = f42 * (f38 ^ 2101);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-66, -63, -66, -102, -21, -105, -66, -60}, "ebe902", 5));
                    break;
                case 54178976:
                    int i3 = f42 * (f38 + 5996);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-72, -97, -29, -107, -72, -102, -19, -64}, "c985c96e9a", true));
                    break;
                case 54183840:
                    int i4 = f42 * (f38 | 820);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-71, -107, -23, -110, -19, -82, -30, -105}, "b3216192adb80630"));
                    break;
                case 54184738:
                    int i5 = f42 * (f38 + 4937);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-65, -104, -72, -2, -70, -63, -22, -62}, "d8caab1f8c"));
                    break;
                case 54185574:
                    int i6 = f42 * (f38 | 1921);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-66, -57, -29, -90, -65, -100, -22, -61}, "ef89d41a2d"));
                    break;
                case 54208920:
                    int i7 = f42 * (f38 + 8129);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-65, -111, -24, -104, -66, -6, -65, -108}, "d730ee", false));
                    break;
                case 54209632:
                    int i8 = f42 * (f38 ^ 593);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-18, -108, -67, -58, -30, -105, -66, -112}, "54fc94e01b", 7));
                    break;
                case 54211742:
                    int i9 = f42 * (f38 + 7155);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-67, -104, -29, -106, -72, -104, -71, -61}, "f085c8bc4d", 0.0f));
                    break;
                case 54213444:
                    int i10 = f42 * (f38 | 4317);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-21, -60, -17, -110, -71, -3, -30, -110}, "0c40bb938b36f746", 0.0f));
                    break;
                case 54242372:
                    int i11 = f42 * (f38 + 3526);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-20, -110, -29, -108, -29, -5, -19, -61}, "73808d6ca23c6c", false));
                    break;
                case 54272257:
                    int i12 = f42 * (f38 + 7840);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-22, -104, -67, -106, -72, -57, -30, -112}, "10f1ce937f44", 1));
                    break;
                case 54275044:
                    int i13 = f42 * (f38 + 6065);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-18, -57, -22, -110, -18, -104, -19, -108}, "5a135863f0"));
                    break;
                case 54358684:
                    int i14 = f42 * (f38 ^ 4136);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-23, -6, -24, -64, -65, -54, -30, -83}, "2e3ddb929ab0d7", false));
                    break;
                case 54359554:
                    int i15 = f42 * (f38 ^ 1029);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-65, -111, -20, -109, -24, -97, -24, -97}, "d7773739", true));
                    break;
                case 54361443:
                    int i16 = f42 * (f38 ^ 7631);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-30, -85, -17, -60, -71, -109, -72, -111}, "944db7c24e", 6));
                    break;
                case 54362684:
                    int i17 = f42 * (f38 + 3312);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-23, -64, -29, -104, -71, -110, -23, -59}, "2a88b22d"));
                    break;
                case 54366246:
                    int i18 = f42 * (f38 ^ 8133);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-66, -109, -67, -108, -23, -105, -20, -111}, "e0f2257275ed4b", false));
                    break;
                case 54390269:
                    int i19 = f42 * (f38 | 3186);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-30, -111, -20, -101, -29, -107, -21, -107}, "90798306edd77896", 7));
                    break;
                case 54421051:
                    return C0005.m336(f45, 155, 516264217 ^ C0006.f74, 0);
                case 54424960:
                    int i20 = f42 * (f38 ^ 390);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-18, -107, -23, -57, -23, -111, -23, -63}, "572d232d54d010", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۧۤ۠, reason: not valid java name and contains not printable characters */
    public static String m181() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-70, -86, -30, -108, -20, -110, -70, -110}, "a59372", 5));
        while (true) {
            switch (iM329) {
                case 54154924:
                    int i = f42 * (f38 + 58);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-65, -59, -24, -5, -65, -110, -65, -58}, "da3dd5"));
                    break;
                case 54156783:
                    int i2 = f42 * (f38 | 6589);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-22, -62, -66, -59, -17, -108, -30, -90}, "1dec45991d6378ca", 0.0f));
                    break;
                case 54185730:
                    int i3 = f42 * (f38 + 6559);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-72, -111, -24, -102, -71, -105, -70, -62}, "c032b4aa1a7206"));
                    break;
                case 54187529:
                    int i4 = f42 * (f38 ^ 3570);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-30, -64, -65, -83, -66, -59, -30, -61}, "9ed2eb", true));
                    break;
                case 54213663:
                    int i5 = f42 * (f38 + 2943);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-20, -60, -20, -58, -67, -110, -29, -64}, "7c7ef48c939bf1", true));
                    break;
                case 54217415:
                    int i6 = f42 * (f38 | 6005);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-66, -105, -22, -63, -29, -107, -71, -109}, "e51c84b2", 3));
                    break;
                case 54239426:
                    int i7 = f42 * (f38 ^ 258);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-30, -55, -24, -62, -29, -99, -19, -58}, "9a3f896c5130", 5));
                    break;
                case 54241376:
                    int i8 = f42 * (f38 | 1837);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-22, -58, -17, -62, -21, -107, -72, -109}, "1a4c00c1fc", true));
                    break;
                case 54298267:
                    int i9 = f42 * (f38 ^ 893);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-19, -64, -20, -63, -23, -58, -19, -64}, "6b7a2f6dfa5d", 1));
                    break;
                case 54328057:
                    int i10 = f42 * (f38 + 7919);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-30, -52, -67, -100, -24, -106, -65, -112}, "9df933d8", 3));
                    break;
                case 54333633:
                    int i11 = f42 * (f38 | 4357);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-20, -111, -71, -97, -19, -104, -30, -111}, "71b768902e57", 5));
                    break;
                case 54357842:
                    int i12 = f42 * (f38 ^ 837);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-67, -108, -71, -64, -23, -62, -67, -108}, "f4bf2f", false));
                    break;
                case 54358654:
                    int i13 = f42 * (f38 | 3206);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-19, -106, -72, -59, -23, -112, -24, -64}, "67ca263b", 0.0f));
                    break;
                case 54364382:
                    int i14 = f42 * (f38 ^ 3883);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-67, -109, -71, -108, -66, -64, -29, -57}, "f5b4eb8a59"));
                    break;
                case 54389495:
                    int i15 = f42 * (f38 + 4531);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-24, -111, -70, -102, -70, -61, -21, -109}, "39a2ae021117", 6));
                    break;
                case 54391449:
                    int i16 = f42 * (f38 ^ 2789);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-18, -62, -65, -84, -22, -58, -24, -111}, "5dd31a31", 0.0f));
                    break;
                case 54396197:
                    if (z1rBEw9J.m266() < 0) {
                        return m177();
                    }
                    return null;
                case 54422110:
                    int i17 = f42 * (f38 ^ 5182);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-66, -5, -21, -58, -71, -109, -19, -50}, "ed0cb16f"));
                    break;
                case 54422141:
                    int i18 = f42 * (f38 ^ 7813);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-22, -108, -65, -99, -65, -107, -18, -63}, "11d8d45c72", false));
                    break;
                case 54423136:
                    int i19 = f42 * (f38 | 243);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-23, -107, -30, -103, -72, -63, -21, -53}, "2291ce0c5e96", 3));
                    break;
                case 54426043:
                    int i20 = f42 * (f38 | 907);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-21, -54, -72, -110, -72, -63, -22, -99}, "0bc6cb18", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤ۠ۢۨ, reason: not valid java name and contains not printable characters */
    public static void m182(Object obj, int i, Object obj2, int i2, int i3) {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-19, -100, -17, -102, -70, -81, -71, -109}, "6448a0b27bf4"));
        while (true) {
            switch (iM333) {
                case 54152134:
                    int i4 = f42 * (f38 | 5820);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-65, -109, -21, -105, -19, -110, -66, -106}, "d30662e7"));
                    break;
                case 54157893:
                    int i5 = f42 * (f38 | 2753);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-65, -62, -29, -107, -72, -105, -72, -111}, "db84c0c13658"));
                    break;
                case 54180802:
                    int i6 = f42 * (f38 ^ 529);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-17, -108, -66, -6, -21, -81, -67, -57}, "43ee00fe1c60"));
                    break;
                case 54181018:
                    int i7 = f42 * (f38 | 1938);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-21, -108, -70, -101, -24, -51, -21, -87}, "06a93e", 0.0f));
                    break;
                case 54184868:
                    int i8 = f42 * (f38 + 8077);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-17, -61, -71, -98, -65, -105, -67, -100}, "4eb8d6f8"));
                    break;
                case 54241591:
                    int i9 = f42 * (f38 ^ 6430);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-24, -86, -70, -63, -72, -106, -29, -102}, "35acc3820380856d", false));
                    break;
                case 54246342:
                    int i10 = f42 * (f38 + 3346);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-70, -58, -20, -110, -18, -110, -70, -57}, "aa7756", 0.0f));
                    break;
                case 54269467:
                    int i11 = f42 * (f38 ^ 2644);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-18, -107, -19, -64, -19, -112, -29, -112}, "556e67868f"));
                    break;
                case 54273243:
                    int i12 = f42 * (f38 ^ 6842);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-66, -111, -23, -58, -22, -60, -22, -109}, "e22a1b1209", 0.0f));
                    break;
                case 54276127:
                    int i13 = f42 * (f38 + 1057);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-24, -63, -71, -108, -23, -112, -24, -60}, "3cb326", 0.0f));
                    break;
                case 54335773:
                    int i14 = f42 * (f38 | 1833);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-29, -104, -23, -60, -19, -106, -18, -111}, "802c615497"));
                    break;
                case 54364387:
                    int i15 = f42 * (f38 ^ 6188);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-21, -4, -72, -98, -67, -109, -29, -64}, "0cc6f68a0f1c", 4));
                    break;
                case 54387387:
                    int i16 = f42 * (f38 + 2612);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-19, -100, -18, -64, -30, -110, -29, -112}, "645d968255cacb"));
                    break;
                case 54393312:
                    int i17 = f42 * (f38 ^ 1849);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-18, -58, -20, -111, -20, -58, -30, -61}, "5a767f9fdc", 0.0f));
                    break;
                case 54395109:
                    int i18 = f42 * (f38 ^ 7027);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-24, -62, -24, -112, -17, -51, -24, -57}, "3a304e"));
                    break;
                case 54395264:
                    int i19 = f42 * (f38 ^ 4532);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-65, -100, -30, -58, -23, -63, -65, -105}, "d49e2a", true));
                    break;
                case 54420060:
                    int i20 = f42 * (f38 + 5802);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-29, -108, -17, -112, -22, -99, -18, -109}, "8347185607", false));
                    break;
                case 54421054:
                    int i21 = f42 * (f38 ^ 6858);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-17, -109, -66, -57, -23, -57, -17, -112}, "40ec2a", true));
                    break;
                case 54422138:
                    int i22 = f42 * (f38 + 2005);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-70, -61, -19, -98, -23, -99, -24, -112}, "af6925335420d3"));
                    break;
                case 54425117:
                    if (z1rBEw9J.m266() < 0) {
                        C0007.m344(obj, i, obj2, i2, i3);
                        return;
                    }
                    return;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۡۥ۠, reason: not valid java name and contains not printable characters */
    public static String m183() {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-23, -58, -72, -112, -22, -101, -23, -83}, "2dc31822", true));
        while (true) {
            switch (iM310) {
                case 54151016:
                    int i = f42 * (f38 ^ 1937);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-18, -105, -22, -97, -70, -60, -66, -103}, "5318abe11b", 0.0f));
                    break;
                case 54186569:
                    int i2 = f42 * (f38 ^ 6979);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-30, -59, -19, -105, -18, -61, -22, -109}, "9b665e16f2", 4));
                    break;
                case 54187651:
                    int i3 = f42 * (f38 + 2706);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-70, -108, -70, -109, -19, -110, -70, -97}, "a7a167", true));
                    break;
                case 54208797:
                    int i4 = f42 * (f38 | 7329);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-21, -57, -18, -110, -72, -90, -23, -104}, "0e50c928", true));
                    break;
                case 54215646:
                    int i5 = f42 * (f38 + 185);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-23, -112, -29, -60, -29, -57, -23, -83}, "228b8b", false));
                    break;
                case 54241313:
                    int i6 = f42 * (f38 ^ 2501);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-17, -60, -20, -82, -19, -57, -29, -105}, "4b716e8538abd8", 0.0f));
                    break;
                case 54242397:
                    int i7 = f42 * (f38 | 4722);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-24, -58, -67, -59, -17, -57, -24, -107}, "3dfb4f33d6"));
                    break;
                case 54245342:
                    int i8 = f42 * (f38 ^ 1652);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-19, -109, -23, -106, -18, -102, -30, -106}, "6623529097", 0.0f));
                    break;
                case 54246186:
                    int i9 = f42 * (f38 | 5751);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-24, -63, -29, -52, -29, -58, -24, -2}, "3a8d8b", false));
                    break;
                case 54268473:
                    int i10 = f42 * (f38 ^ 1402);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-70, -108, -17, -84, -66, -109, -18, -106}, "a543e755ed", 4));
                    break;
                case 54271298:
                    int i11 = f42 * (f38 | 4481);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-30, -110, -66, -109, -72, -107, -66, -112}, "92e4c5e2c3ee921d", false));
                    break;
                case 54305925:
                    int i12 = f42 * (f38 + 7505);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-18, -63, -22, -107, -67, -57, -65, -106}, "5d12fad456c4", 0.0f));
                    break;
                case 54333854:
                    int i13 = f42 * (f38 ^ 4504);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-72, -109, -18, -112, -19, -110, -70, -64}, "c45265ad9ee72e", 2));
                    break;
                case 54335710:
                    int i14 = f42 * (f38 + 2558);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-18, -60, -18, -60, -67, -107, -70, -63}, "5c5df3aa", 3));
                    break;
                case 54357689:
                    int i15 = f42 * (f38 + 2470);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-19, -106, -70, -61, -17, -104, -66, -107}, "67ae40e41baa", true));
                    break;
                case 54388444:
                    int i16 = f42 * (f38 ^ 2238);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-66, -110, -67, -5, -20, -108, -67, -108}, "e1fd73f034c48617", 1));
                    break;
                case 54388563:
                    int i17 = f42 * (f38 | 811);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-29, -63, -18, -109, -72, -111, -23, -106}, "8f53c3238b"));
                    break;
                case 54389529:
                    int i18 = f42 * (f38 + 1342);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-70, -102, -18, -111, -21, -106, -66, -107}, "a25202e4c0c640ee", 0.0f));
                    break;
                case 54390520:
                    if (Z5HFgwkz.m63() > 0) {
                        return m167();
                    }
                    return null;
                case 54421176:
                    int i19 = f42 * (f38 ^ 2587);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-66, -90, -20, -106, -67, -111, -29, -57}, "e977f18a47bcc3"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۤۤۡ, reason: not valid java name and contains not printable characters */
    public static String m184() {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-20, -112, -30, -108, -20, -106, -29, -87}, "7095758669f785"));
        while (true) {
            switch (iM323) {
                case 54180893:
                    int i = f42 * (f38 ^ 3199);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-17, -60, -21, -112, -17, -110, -65, -2}, "4b0040da2b53", 0.0f));
                    break;
                case 54181021:
                    int i2 = f42 * (f38 + 3544);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-17, -108, -70, -86, -22, -52, -67, -58}, "47a51dfd602ddd", 0.0f));
                    break;
                case 54238717:
                    int i3 = f42 * (f38 ^ 4730);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-17, -64, -29, -112, -22, -101, -18, -98}, "4e831358", false));
                    break;
                case 54268502:
                    int i4 = f42 * (f38 ^ 818);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-17, -108, -17, -111, -20, -108, -17, -112}, "474674", false));
                    break;
                case 54273149:
                    int i5 = f42 * (f38 | 4435);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-67, -111, -22, -106, -70, -87, -21, -105}, "f915a6058ac21183", 0.0f));
                    break;
                case 54275947:
                    int i6 = f42 * (f38 ^ 6450);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-17, -100, -71, -57, -66, -59, -22, -62}, "49bfed1b226b8b", 0.0f));
                    break;
                case 54298047:
                    if (eRLkMqbO.m105() <= 0) {
                        return m172();
                    }
                    return null;
                case 54301923:
                    int i7 = f42 * (f38 + 3909);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-24, -100, -23, -106, -30, -64, -22, -109}, "34229f11", 0.0f));
                    break;
                case 54327904:
                    int i8 = f42 * (f38 + 7371);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-67, -112, -18, -61, -18, -103, -23, -107}, "f65c5127b494", 0.0f));
                    break;
                case 54329787:
                    int i9 = f42 * (f38 + 5454);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-72, -63, -72, -108, -23, -57, -19, -3}, "cbc02d6b00d1008d", 0.0f));
                    break;
                case 54331932:
                    int i10 = f42 * (f38 + 3496);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-18, -61, -71, -61, -67, -100, -72, -104}, "5fbdf4c0eb"));
                    break;
                case 54335778:
                    int i11 = f42 * (f38 ^ 7433);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-72, -59, -29, -83, -24, -107, -67, -100}, "ca8235f8"));
                    break;
                case 54358647:
                    int i12 = f42 * (f38 + 1648);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-20, -59, -24, -106, -18, -107, -23, -62}, "7c33552ed16ab1", 6));
                    break;
                case 54358836:
                    int i13 = f42 * (f38 + 1297);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-22, -109, -23, -82, -29, -52, -21, -102}, "11218d02114c", 3));
                    break;
                case 54363398:
                    int i14 = f42 * (f38 + 2131);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-29, -109, -24, -61, -22, -108, -18, -112}, "833b13533ea1be72", true));
                    break;
                case 54363612:
                    int i15 = f42 * (f38 | 7929);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-17, -108, -70, -107, -17, -107, -23, -106}, "40a64423"));
                    break;
                case 54388377:
                    int i16 = f42 * (f38 ^ 3271);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-29, -112, -70, -108, -22, -53, -17, -57}, "87a21c4e", 6));
                    break;
                case 54390487:
                    int i17 = f42 * (f38 ^ 3595);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-72, -112, -72, -112, -66, -105, -22, -60}, "c7c0e71dcf74d20e", false));
                    break;
                case 54394393:
                    int i18 = f42 * (f38 ^ 7259);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-29, -58, -29, -6, -24, -57, -29, -53}, "8c8e3e", false));
                    break;
                case 54421022:
                    int i19 = f42 * (f38 + 8087);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-70, -112, -71, -105, -24, -105, -71, -63}, "a6b230bef293"));
                    break;
                case 54422200:
                    int i20 = f42 * (f38 + 1167);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-70, -63, -18, -105, -18, -108, -67, -63}, "af5552fc4bc0"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۦۢۥ, reason: not valid java name and contains not printable characters */
    public static String m185() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-24, -58, -71, -106, -29, -106, -24, -55}, "3ab285", 5));
        while (true) {
            switch (iM347) {
                case 54156775:
                    int i = f42 * (f38 ^ 3204);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-20, -109, -22, -112, -17, -63, -19, -108}, "76134a66"));
                    break;
                case 54180924:
                    int i2 = f42 * (f38 + 4369);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-67, -98, -18, -59, -70, -59, -23, -60}, "f85aaa2c23a9"));
                    break;
                case 54183810:
                    int i3 = f42 * (f38 ^ 4159);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-67, -58, -22, -60, -23, -109, -17, -109}, "fc1e23411df5"));
                    break;
                case 54208858:
                    int i4 = f42 * (f38 + 4263);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-20, -97, -22, -106, -24, -62, -66, -90}, "77153de979", 0.0f));
                    break;
                case 54213604:
                    int i5 = f42 * (f38 ^ 5159);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-66, -110, -20, -100, -22, -99, -66, -112}, "e27819", true));
                    break;
                case 54215582:
                    int i6 = f42 * (f38 | 4883);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-71, -63, -30, -58, -20, -110, -71, -58}, "be9a75", true));
                    break;
                case 54238717:
                    int i7 = f42 * (f38 + 2510);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-17, -60, -17, -60, -72, -111, -18, -111}, "4c4ec354", 0.0f));
                    break;
                case 54273059:
                    int i8 = f42 * (f38 ^ 25);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-24, -110, -67, -64, -67, -109, -20, -3}, "33fff57b95e2", 0.0f));
                    break;
                case 54273244:
                    int i9 = f42 * (f38 | 4844);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-19, -110, -70, -5, -17, -64, -19, -107}, "63ad4f67d9", 0.0f));
                    break;
                case 54273995:
                    int i10 = f42 * (f38 ^ 784);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-19, -59, -22, -107, -30, -108, -21, -109}, "6f1192020eca37", 0.0f));
                    break;
                case 54274986:
                    int i11 = f42 * (f38 + 3150);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-72, -64, -20, -100, -72, -112, -17, -52}, "cd74c34d", 0.0f));
                    break;
                case 54298979:
                    if (eRLkMqbO.m105() <= 0) {
                        return Build.HARDWARE;
                    }
                    return null;
                case 54301857:
                    int i12 = f42 * (f38 + 205);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-24, -58, -17, -98, -66, -59, -22, -98}, "3e48ee19", false));
                    break;
                case 54305951:
                    int i13 = f42 * (f38 ^ 1841);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-30, -106, -21, -108, -65, -83, -70, -107}, "9207d2a4", false));
                    break;
                case 54306793:
                    int i14 = f42 * (f38 | 3789);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-20, -110, -24, -58, -29, -108, -18, -84}, "773d825384"));
                    break;
                case 54329758:
                    int i15 = f42 * (f38 + 7369);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-18, -111, -22, -104, -66, -106, -21, -2}, "5119e20a51", 6));
                    break;
                case 54330902:
                    int i16 = f42 * (f38 + 2782);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-70, -105, -24, -109, -24, -106, -70, -109}, "a63732", 1));
                    break;
                case 54331680:
                    int i17 = f42 * (f38 ^ 3603);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-29, -61, -70, -88, -29, -97, -30, -50}, "8aa7879f", 0.0f));
                    break;
                case 54362561:
                    int i18 = f42 * (f38 | 3800);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-21, -83, -29, -62, -23, -59, -29, -4}, "028e2e8ca972e3", 7));
                    break;
                case 54389405:
                    int i19 = f42 * (f38 ^ 7243);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-20, -100, -21, -62, -67, -90, -23, -105}, "780bf921843b", 0.0f));
                    break;
                case 54392322:
                    int i20 = f42 * (f38 + 7536);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-21, -107, -29, -108, -72, -6, -70, -55}, "0681ceaa8e2a", true));
                    break;
                case 54421236:
                    int i21 = f42 * (f38 | 3223);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-19, -111, -17, -110, -17, -62, -22, -109}, "62464b11"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۦۥۨ, reason: not valid java name and contains not printable characters */
    public static boolean m186(Object obj, Object obj2) {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-24, -106, -66, -107, -19, -101, -65, -109}, "32e563d0", true));
        while (true) {
            switch (iM338) {
                case 54149093:
                    if (Z5HFgwkz.m63() >= 0) {
                        return ((String) obj).equalsIgnoreCase((String) obj2);
                    }
                    return false;
                case 54150987:
                    int i = f42 * (f38 | 5717);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-67, -110, -20, -61, -30, -102, -18, -107}, "f27e99506075971b", 0.0f));
                    break;
                case 54155977:
                    int i2 = f42 * (f38 | 6294);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-21, -111, -67, -59, -65, -62, -21, -109}, "07fede"));
                    break;
                case 54182793:
                    int i3 = f42 * (f38 ^ 7227);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-29, -104, -29, -59, -65, -108, -29, -101}, "888cd0", 0.0f));
                    break;
                case 54185574:
                    int i4 = f42 * (f38 | 3857);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-67, -110, -17, -102, -67, -107, -71, -111}, "f249f7b992", 6));
                    break;
                case 54185704:
                    int i5 = f42 * (f38 + 4388);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-19, -57, -72, -64, -18, -4, -20, -60}, "6fcf5c7cf8ae05f2"));
                    break;
                case 54185733:
                    int i6 = f42 * (f38 + 6473);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-30, -88, -24, -97, -18, -111, -19, -106}, "973954614155361b", 5));
                    break;
                case 54209759:
                    int i7 = f42 * (f38 ^ 2392);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-70, -62, -67, -59, -22, -88, -19, -88}, "abfc1767c8", 2));
                    break;
                case 54215373:
                    int i8 = f42 * (f38 | 335);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-30, -88, -22, -5, -24, -110, -29, -58}, "971d328c92"));
                    break;
                case 54215646:
                    int i9 = f42 * (f38 | 786);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-23, -60, -71, -112, -20, -98, -17, -62}, "2bb3764cfa48", false));
                    break;
                case 54245251:
                    int i10 = f42 * (f38 + 2223);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-70, -61, -21, -107, -23, -109, -65, -3}, "ad0022dbf4363a"));
                    break;
                case 54247242:
                    int i11 = f42 * (f38 | 5281);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-22, -106, -23, -102, -20, -90, -70, -61}, "112279ad8aad", 7));
                    break;
                case 54268318:
                    int i12 = f42 * (f38 ^ 3145);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-71, -99, -24, -107, -22, -85, -70, -104}, "b53714a9", 0.0f));
                    break;
                case 54269219:
                    int i13 = f42 * (f38 + 3653);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-29, -111, -18, -111, -72, -105, -29, -108}, "8051c3", false));
                    break;
                case 54269376:
                    int i14 = f42 * (f38 | 4521);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-70, -61, -30, -111, -17, -64, -67, -59}, "aa974bfd7e"));
                    break;
                case 54299255:
                    int i15 = f42 * (f38 + 807);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-18, -63, -72, -61, -71, -109, -67, -110}, "5bccb3f48d7273b5", 0.0f));
                    break;
                case 54299938:
                    int i16 = f42 * (f38 ^ 1796);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-67, -101, -30, -4, -24, -57, -30, -99}, "f89c3e9994e112"));
                    break;
                case 54358807:
                    int i17 = f42 * (f38 ^ 3791);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-70, -109, -17, -52, -21, -108, -66, -102}, "a14d00e2"));
                    break;
                case 54361718:
                    int i18 = f42 * (f38 ^ 274);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-22, -87, -65, -57, -72, -81, -17, -52}, "16dfc04d"));
                    break;
                case 54393212:
                    int i19 = f42 * (f38 ^ 996);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-22, -61, -18, -61, -23, -52, -22, -112}, "1b5e2d11793f"));
                    break;
                case 54396041:
                    int i20 = f42 * (f38 ^ 3750);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-17, -107, -72, -61, -70, -81, -71, -111}, "41cba0b5", 0));
                    break;
                case 54420060:
                    int i21 = f42 * (f38 ^ 8141);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-30, -110, -72, -61, -23, -64, -24, -104}, "91cc2e30fcc5e1", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۦۧۥ۠ۤ, reason: not valid java name and contains not printable characters */
    private static String m187() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-22, -106, -70, -81, -70, -4, -22, -51}, "16a0ac1e158c0d01", false));
        while (true) {
            switch (iM347) {
                case 54154890:
                    int i = f42 * (f38 + 5708);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-29, -106, -29, -105, -19, -108, -23, -61}, "8183652b", 0.0f));
                    break;
                case 54156806:
                    int i2 = f42 * (f38 | 6014);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-22, -61, -17, -62, -71, -110, -23, -110}, "1c4ab625de", true));
                    break;
                case 54178856:
                    int i3 = f42 * (f38 + 2916);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-65, -108, -22, -88, -71, -110, -71, -57}, "d417b1ba219d48"));
                    break;
                case 54178978:
                    int i4 = f42 * (f38 | 4045);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-20, -60, -20, -60, -18, -99, -20, -62}, "7e7c55", false));
                    break;
                case 54179126:
                    int i5 = f42 * (f38 | 6576);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-66, -6, -71, -100, -65, -112, -30, -107}, "eeb9d1906724a142"));
                    break;
                case 54180770:
                    int i6 = f42 * (f38 ^ 1383);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-21, -111, -66, -110, -18, -64, -21, -5}, "01e75f0def1d"));
                    break;
                case 54182854:
                    int i7 = f42 * (f38 + 3726);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-24, -63, -29, -110, -65, -110, -71, -57}, "3c83d3ba176914", false));
                    break;
                case 54184830:
                    int i8 = f42 * (f38 | 2862);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-66, -57, -30, -62, -29, -60, -65, -112}, "ea9f8ad218f4a0"));
                    break;
                case 54185667:
                    int i9 = f42 * (f38 ^ 4781);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-66, -102, -23, -63, -21, -105, -21, -2}, "e82f060ab88e", 0));
                    break;
                case 54212582:
                    int i10 = f42 * (f38 + 421);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-17, -105, -65, -109, -71, -3, -29, -54}, "40d5bb8b810868fb", 3));
                    break;
                case 54215552:
                    int i11 = f42 * (f38 | 1522);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-18, -100, -21, -110, -72, -108, -22, -108}, "5804c31732"));
                    break;
                case 54216613:
                    int i12 = f42 * (f38 | 6290);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-29, -109, -20, -109, -70, -101, -17, -62}, "8270a94d3327", 4));
                    break;
                case 54240420:
                    int i13 = f42 * (f38 ^ 3987);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-72, -106, -21, -110, -22, -106, -72, -108}, "c30511", 7));
                    break;
                case 54246179:
                    int i14 = f42 * (f38 + 6615);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-72, -63, -66, -62, -24, -52, -65, -64}, "ceea3ddfde1f80cd"));
                    break;
                case 54302141:
                    int i15 = f42 * (f38 + 6494);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-23, -106, -29, -108, -19, -85, -30, -108}, "26856494", 0.0f));
                    break;
                case 54304990:
                    int i16 = f42 * (f38 ^ 6602);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-22, -107, -70, -104, -17, -106, -66, -64}, "10a041ed714ede", false));
                    break;
                case 54335746:
                    int i17 = f42 * (f38 | 5662);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-72, -105, -72, -2, -23, -111, -30, -84}, "c7ca2993", 2));
                    break;
                case 54336704:
                    int i18 = f42 * (f38 ^ 6243);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-23, -97, -70, -57, -65, -110, -29, -110}, "27aad0856b"));
                    break;
                case 54362587:
                    return C0005.m336(f45, 153, 1178493381 ^ C0006.f74, 0);
                case 54392253:
                    int i19 = f42 * (f38 | 6607);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-22, -110, -17, -106, -72, -106, -29, -105}, "1340c387ebd28517"));
                    break;
                case 54394120:
                    int i20 = f42 * (f38 | 2417);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-30, -4, -23, -111, -72, -106, -71, -81}, "9c26c7b06971c3a3", 7));
                    break;
                case 54424003:
                    int i21 = f42 * (f38 ^ 5501);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-70, -60, -66, -111, -24, -58, -65, -6}, "ade73dde7157"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۤۥ۟, reason: contains not printable characters */
    private static String m188() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-17, -57, -22, -108, -20, -102, -20, -57}, "4b14787e", 3));
        while (true) {
            switch (iM329) {
                case 54181954:
                    int i = f42 * (f38 ^ 6075);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-30, -98, -70, -60, -70, -100, -67, -112}, "98ada8f162", false));
                    break;
                case 54183745:
                    int i2 = f42 * (f38 | 7570);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-67, -57, -30, -58, -19, -55, -30, -59}, "ff9d6a9c0756cd2f", 3));
                    break;
                case 54187529:
                    int i3 = f42 * (f38 + 7634);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-17, -59, -19, -2, -22, -107, -71, -6}, "4f6a14be632f", 0.0f));
                    break;
                case 54211807:
                    int i4 = f42 * (f38 | 791);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-20, -108, -30, -62, -23, -64, -22, -108}, "779c2c15af16", false));
                    break;
                case 54245283:
                    int i5 = f42 * (f38 ^ 912);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-18, -59, -20, -108, -18, -110, -24, -81}, "5f765030", false));
                    break;
                case 54268282:
                    int i6 = f42 * (f38 | 2755);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-29, -61, -23, -112, -23, -111, -21, -4}, "8c24230cb69b66", 0));
                    break;
                case 54270268:
                    int i7 = f42 * (f38 + 762);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-18, -106, -70, -110, -19, -109, -65, -98}, "53a466d917", true));
                    break;
                case 54271196:
                    int i8 = f42 * (f38 ^ 2974);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-17, -97, -18, -102, -20, -59, -30, -105}, "48597c90a63a", 2));
                    break;
                case 54277090:
                    int i9 = f42 * (f38 ^ 6666);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-71, -111, -22, -110, -67, -88, -67, -109}, "b417f7f49f84a639"));
                    break;
                case 54298045:
                    int i10 = f42 * (f38 ^ 7805);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-72, -52, -72, -57, -20, -103, -72, -58}, "cdcc79", 0.0f));
                    break;
                case 54299999:
                    int i11 = f42 * (f38 ^ 1199);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-67, -111, -17, -62, -70, -105, -21, -57}, "f44ea00c", 0.0f));
                    break;
                case 54328859:
                    int i12 = f42 * (f38 | 1365);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-24, -59, -24, -97, -29, -111, -70, -58}, "3c3887ab819260db", false));
                    break;
                case 54333576:
                    int i13 = f42 * (f38 | 3306);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-66, -108, -19, -60, -22, -112, -71, -111}, "e66b13b3", 0));
                    break;
                case 54334723:
                    int i14 = f42 * (f38 ^ 1396);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-67, -57, -24, -82, -29, -60, -70, -58}, "fc318dadfe53b840", 0.0f));
                    break;
                case 54335743:
                    int i15 = f42 * (f38 + 1315);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-65, -61, -29, -101, -24, -106, -65, -59}, "dc8930", 0.0f));
                    break;
                case 54358711:
                    return C0005.m336(f45, 15, 259557555 ^ C0002.f66, 25);
                case 54363616:
                    int i16 = f42 * (f38 | 5885);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-30, -59, -23, -104, -66, -62, -30, -60}, "9e20eb", 0.0f));
                    break;
                case 54365503:
                    int i17 = f42 * (f38 | 5151);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-66, -108, -17, -51, -18, -97, -18, -102}, "e74e5959d183"));
                    break;
                case 54391453:
                    int i18 = f42 * (f38 + 5663);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-66, -110, -71, -61, -70, -111, -17, -97}, "e4bfa647a275", true));
                    break;
                case 54422014:
                    int i19 = f42 * (f38 | 6250);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-18, -53, -24, -63, -30, -105, -72, -53}, "5c3d92cc33a8c309", 0.0f));
                    break;
                case 54423136:
                    int i20 = f42 * (f38 ^ 7953);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-23, -63, -22, -62, -72, -106, -29, -108}, "2e1cc7873a"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۧۢۦ, reason: contains not printable characters */
    public static String m189(String str) {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-66, -58, -66, -83, -66, -105, -18, -99}, "ece2e755d69742", true));
        while (true) {
            switch (iM338) {
                case 54185614:
                    int i = f42 * (f38 | 1565);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-72, -62, -24, -100, -20, -59, -72, -52}, "ca387ecd41cc1f"));
                    break;
                case 54215583:
                    int i2 = f42 * (f38 | 2212);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-66, -55, -71, -112, -71, -53, -24, -61}, "eab3bc3ab06535fb", 2));
                    break;
                case 54215588:
                    int i3 = f42 * (f38 ^ 2646);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-70, -63, -65, -110, -70, -111, -24, -84}, "aed4a133"));
                    break;
                case 54240391:
                    int i4 = f42 * (f38 ^ 3545);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-71, -59, -22, -57, -29, -104, -72, -99}, "be1a88c592", false));
                    break;
                case 54269275:
                    int i5 = f42 * (f38 ^ 3038);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-22, -62, -19, -112, -65, -104, -22, -84}, "1d62d013cd78", false));
                    break;
                case 54273065:
                    int i6 = f42 * (f38 ^ 8088);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-71, -61, -67, -63, -66, -110, -18, -99}, "bffce258e730cc", 0.0f));
                    break;
                case 54300991:
                    int i7 = f42 * (f38 + 723);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-24, -57, -24, -59, -29, -107, -24, -59}, "3a3e813b08", 0));
                    break;
                case 54304769:
                    int i8 = f42 * (f38 ^ 6707);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-17, -109, -70, -101, -65, -64, -19, -106}, "44a8dc64f262ba1e", false));
                    break;
                case 54327842:
                    int i9 = f42 * (f38 + 767);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-23, -107, -29, -58, -21, -107, -23, -4}, "208d012ce2e439", 0.0f));
                    break;
                case 54330722:
                    String strM187 = m187();
                    int i10 = 0;
                    String strM150 = m150();
                    while (i10 < 15) {
                        strM187 = new StringBuffer().append(strM187).append(Integer.toHexString(i10)).toString();
                        String string = new StringBuffer().append(strM150).append(((int) (Math.random() * ((double) 10))) ^ i10).toString();
                        i10++;
                        strM150 = string;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
                    for (int i11 = 0; i11 < str.length(); i11 += 2) {
                        byteArrayOutputStream.write((strM187.indexOf(str.charAt(i11)) << 4) | strM187.indexOf(str.charAt(i11 + 1)));
                    }
                    byte[] bArrM341 = C0007.m341(byteArrayOutputStream);
                    String strM195 = m195();
                    while (strM195.length() > 0) {
                        strM195 = m192();
                        if (strM195.length() == 0) {
                            strM195 = m144();
                        }
                    }
                    int length = strM195.length();
                    int length2 = strM150.length();
                    for (int i12 = 0; i12 < length; i12++) {
                        bArrM341[i12] = (byte) (bArrM341[i12] ^ strM150.charAt(i12 % length2));
                    }
                    for (int length3 = 0; length3 < bArrM341.length; length3 = m180().length() + 1) {
                    }
                    return new String(bArrM341);
                case 54330840:
                    int i13 = f42 * (f38 | 5451);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-21, -111, -22, -55, -30, -81, -21, -110}, "061a90", 4));
                    break;
                case 54358717:
                    int i14 = f42 * (f38 + 3779);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-70, -104, -18, -58, -65, -4, -72, -4}, "a05ddccc960c11", 0.0f));
                    break;
                case 54360755:
                    int i15 = f42 * (f38 ^ 5482);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-23, -110, -20, -64, -72, -58, -67, -51}, "207acffe884704e2"));
                    break;
                case 54389342:
                    int i16 = f42 * (f38 + 4768);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-20, -105, -20, -105, -22, -60, -65, -58}, "76711bdf504144fe", true));
                    break;
                case 54391355:
                    int i17 = f42 * (f38 ^ 7707);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-65, -100, -72, -107, -24, -6, -22, -62}, "d4c03e1dffff788e", 0.0f));
                    break;
                case 54396038:
                    int i18 = f42 * (f38 + 1948);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-71, -102, -19, -105, -23, -87, -67, -110}, "b26026f773", 0.0f));
                    break;
                case 54417462:
                    int i19 = f42 * (f38 + 6854);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-23, -110, -71, -64, -17, -58, -65, -109}, "26bb4dd0", 0.0f));
                    break;
                case 54420058:
                    int i20 = f42 * (f38 ^ 736);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-66, -63, -71, -112, -18, -108, -70, -109}, "efb154a7fa90", 0.0f));
                    break;
                case 54421301:
                    int i21 = f42 * (f38 + 3847);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-18, -106, -22, -108, -18, -58, -23, -61}, "55145d2c2fcc35", 0.0f));
                    break;
                case 54422948:
                    int i22 = f42 * (f38 | 8055);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-71, -98, -72, -81, -24, -99, -71, -111}, "b6c035", true));
                    break;
                case 54424869:
                    int i23 = f42 * (f38 ^ 2938);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-19, -59, -21, -112, -23, -64, -19, -63}, "6d062f", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۧۤ۟, reason: contains not printable characters */
    private static String m190() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-65, -97, -71, -84, -29, -97, -23, -53}, "d8b3872c1c"));
        while (true) {
            switch (iM329) {
                case 54150298:
                    int i = f42 * (f38 | 7921);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-21, -53, -72, -57, -30, -106, -17, -106}, "0ccc9440", 0));
                    break;
                case 54154862:
                    int i2 = f42 * (f38 + 5691);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-20, -63, -29, -108, -29, -105, -29, -106}, "7f8584878d90", 0.0f));
                    break;
                case 54184897:
                    int i3 = f42 * (f38 | 5937);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-19, -3, -19, -63, -20, -98, -17, -105}, "6b6a7646", 0.0f));
                    break;
                case 54216388:
                    int i4 = f42 * (f38 + 7500);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-19, -108, -30, -87, -71, -108, -19, -103}, "6196b6", 0.0f));
                    break;
                case 54241380:
                    int i5 = f42 * (f38 | 6343);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-67, -110, -21, -61, -17, -108, -71, -7}, "f30d45bf3ce46ac1", 0.0f));
                    break;
                case 54268257:
                    int i6 = f42 * (f38 | 1973);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-21, -106, -66, -105, -17, -60, -67, -108}, "02e04cf1c70f27", false));
                    break;
                case 54271324:
                    int i7 = f42 * (f38 + 2926);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-23, -106, -24, -4, -22, -109, -24, -61}, "253c133fc9405630", 0.0f));
                    break;
                case 54301957:
                    int i8 = f42 * (f38 | 4246);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-30, -112, -22, -105, -67, -111, -21, -64}, "9510f60d539c", false));
                    break;
                case 54303997:
                    int i9 = f42 * (f38 ^ 825);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-23, -112, -18, -63, -67, -109, -71, -99}, "245bf1b58225", 0.0f));
                    break;
                case 54305953:
                    int i10 = f42 * (f38 | 376);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-23, -98, -23, -112, -30, -110, -21, -57}, "2924910ce3ee", 0.0f));
                    break;
                case 54327904:
                    int i11 = f42 * (f38 ^ 7391);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-65, -59, -24, -109, -67, -107, -23, -58}, "da36f32d"));
                    break;
                case 54328889:
                    int i12 = f42 * (f38 ^ 7705);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-30, -109, -30, -57, -70, -64, -17, -110}, "919eaa47660890", 0.0f));
                    break;
                case 54330938:
                    int i13 = f42 * (f38 + 1691);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-17, -110, -18, -105, -29, -105, -71, -64}, "475784baca61", 0));
                    break;
                case 54335743:
                    int i14 = f42 * (f38 ^ 1764);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-70, -104, -29, -99, -17, -55, -72, -111}, "a8884ac5", 1));
                    break;
                case 54387672:
                    int i15 = f42 * (f38 + 7328);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-65, -110, -22, -104, -18, -111, -67, -107}, "d51055f599", 0.0f));
                    break;
                case 54389432:
                    int i16 = f42 * (f38 + 7513);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-70, -61, -66, -108, -30, -109, -21, -109}, "afe69407", 3));
                    break;
                case 54392318:
                    return C0005.m336(f45, 86, 1524376078 ^ C0004.f70, 4);
                case 54396189:
                    int i17 = f42 * (f38 ^ 3850);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-29, -55, -72, -101, -67, -99, -71, -102}, "8ac9f8b98265090f", false));
                    break;
                case 54420248:
                    int i18 = f42 * (f38 ^ 177);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-71, -7, -30, -61, -70, -105, -17, -100}, "bf9fa744b2b3fd", 0.0f));
                    break;
                case 54422080:
                    int i19 = f42 * (f38 ^ 6397);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-19, -111, -19, -60, -23, -112, -71, -105}, "626f26b496", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۤ۟, reason: contains not printable characters */
    public static String m191() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-29, -109, -20, -57, -23, -99, -19, -57}, "867d286a00", 0.0f));
        while (true) {
            switch (iM329) {
                case 54149180:
                    int i = f42 * (f38 ^ 379);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-71, -109, -30, -3, -19, -105, -24, -61}, "b09b633deb4a54", 0.0f));
                    break;
                case 54153923:
                    int i2 = f42 * (f38 | 3101);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-19, -110, -66, -59, -22, -50, -65, -111}, "60ea1fd0", true));
                    break;
                case 54178949:
                    int i3 = f42 * (f38 ^ 7444);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-23, -106, -21, -101, -18, -60, -22, -104}, "22085f19"));
                    break;
                case 54183846:
                    int i4 = f42 * (f38 | 1620);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-67, -112, -65, -111, -71, -108, -20, -64}, "f4d7b57e9bf781"));
                    break;
                case 54239547:
                    int i5 = f42 * (f38 + 7291);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-65, -81, -65, -63, -70, -62, -66, -85}, "d0deace4b900"));
                    break;
                case 54239645:
                    int i6 = f42 * (f38 + 2273);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-18, -109, -22, -110, -23, -90, -71, -106}, "571729b3ab1d46dd", true));
                    break;
                case 54241443:
                    int i7 = f42 * (f38 | 6263);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-67, -102, -23, -83, -67, -7, -18, -106}, "f922ff529ef1", false));
                    break;
                case 54242308:
                    int i8 = f42 * (f38 + 4564);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-19, -99, -24, -58, -19, -111, -70, -111}, "693c64a37b27", 0.0f));
                    break;
                case 54242556:
                    int i9 = f42 * (f38 | 7917);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-23, -64, -19, -63, -66, -63, -29, -58}, "2c6ceb8bf310d6"));
                    break;
                case 54243515:
                    int i10 = f42 * (f38 + 5294);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-17, -105, -29, -110, -24, -58, -20, -64}, "45803e7f709568"));
                    break;
                case 54268225:
                    int i11 = f42 * (f38 + 11);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-66, -58, -71, -108, -29, -109, -72, -61}, "edb484ce2e", true));
                    break;
                case 54268383:
                    int i12 = f42 * (f38 | 4906);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-21, -112, -20, -105, -18, -111, -24, -107}, "0277553474", 0.0f));
                    break;
                case 54271232:
                    if (m146() <= 0) {
                        return m174();
                    }
                    return null;
                case 54272104:
                    int i13 = f42 * (f38 ^ 6616);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-22, -106, -71, -104, -23, -107, -22, -108}, "11b925", 3));
                    break;
                case 54301950:
                    int i14 = f42 * (f38 + 2463);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-22, -61, -21, -101, -20, -112, -72, -105}, "1a0878c4c3dc", 0.0f));
                    break;
                case 54303783:
                    int i15 = f42 * (f38 | 2290);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-67, -106, -18, -61, -21, -109, -22, -57}, "f15c041fdfb93379", true));
                    break;
                case 54303966:
                    int i16 = f42 * (f38 ^ 3745);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-66, -102, -30, -108, -30, -63, -24, -55}, "e9979a3a", 0.0f));
                    break;
                case 54304806:
                    int i17 = f42 * (f38 ^ 7473);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-17, -90, -30, -3, -67, -57, -72, -81}, "499bfdc0", 0.0f));
                    break;
                case 54331839:
                    int i18 = f42 * (f38 + 3253);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-72, -107, -19, -101, -72, -62, -24, -60}, "c263ce3de1d4c260", true));
                    break;
                case 54388595:
                    int i19 = f42 * (f38 | 7882);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-70, -102, -24, -62, -19, -88, -24, -111}, "a23e6739dd61"));
                    break;
                case 54389343:
                    int i20 = f42 * (f38 | 2901);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-71, -110, -65, -107, -66, -112, -19, -97}, "b2d1e56865", 0.0f));
                    break;
                case 54396282:
                    int i21 = f42 * (f38 | 5150);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-65, -102, -24, -62, -65, -112, -65, -101}, "d83ad0"));
                    break;
                case 54424872:
                    int i22 = f42 * (f38 ^ 4670);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-71, -62, -17, -86, -21, -57, -71, -54}, "bb450e"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۦۥۧ, reason: contains not printable characters */
    private static String m192() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-72, -58, -23, -111, -70, -111, -30, -105}, "cc26a69116ace0", 2));
        while (true) {
            switch (iM347) {
                case 54149127:
                    int i = f42 * (f38 + 2784);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-24, -59, -70, -53, -20, -51, -24, -105}, "3cac7e3142", 0.0f));
                    break;
                case 54156782:
                    int i2 = f42 * (f38 + 5172);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-30, -108, -65, -97, -29, -104, -30, -112}, "93d980", 1));
                    break;
                case 54181951:
                    int i3 = f42 * (f38 | 3143);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-23, -64, -72, -59, -21, -98, -66, -109}, "2bcb08e4eb47", true));
                    break;
                case 54186758:
                    int i4 = f42 * (f38 ^ 1480);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-23, -90, -70, -97, -66, -58, -19, -62}, "29a8ef6d", 0.0f));
                    break;
                case 54208708:
                    int i5 = f42 * (f38 ^ 418);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-72, -105, -67, -110, -22, -110, -23, -109}, "c3f01024d6", true));
                    break;
                case 54208832:
                    int i6 = f42 * (f38 | 146);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-66, -62, -24, -112, -24, -60, -20, -64}, "eb373b7ec36623"));
                    break;
                case 54239610:
                    int i7 = f42 * (f38 + 5638);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-30, -58, -70, -63, -17, -107, -67, -104}, "9eaa40f80aa89c", true));
                    break;
                case 54246342:
                    int i8 = f42 * (f38 ^ 4984);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-70, -109, -65, -83, -66, -112, -72, -109}, "a6d2e8c17af4", true));
                    break;
                case 54269368:
                    int i9 = f42 * (f38 | 6251);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-17, -110, -72, -108, -17, -101, -17, -107}, "44c449", 2));
                    break;
                case 54300995:
                    int i10 = f42 * (f38 + 695);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-24, -100, -22, -107, -24, -112, -66, -107}, "391730e2cc88"));
                    break;
                case 54302010:
                    int i11 = f42 * (f38 ^ 1860);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-21, -103, -24, -86, -22, -64, -21, -97}, "08351e", 0.0f));
                    break;
                case 54304957:
                    int i12 = f42 * (f38 | 1401);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-70, -109, -67, -57, -23, -107, -70, -111}, "a4fa20"));
                    break;
                case 54328084:
                    int i13 = f42 * (f38 | 6676);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-72, -107, -72, -101, -22, -57, -29, -107}, "c2c91c8208", 0.0f));
                    break;
                case 54330724:
                    int i14 = f42 * (f38 + 711);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-22, -62, -30, -109, -30, -112, -22, -63}, "1b9196", true));
                    break;
                case 54331903:
                    int i15 = f42 * (f38 + 6256);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-65, -104, -23, -2, -70, -108, -17, -58}, "d92aa54ac6004d", 0.0f));
                    break;
                case 54335745:
                    int i16 = f42 * (f38 | 8007);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-19, -105, -19, -64, -71, -110, -30, -62}, "636fb49ccf666c", 0));
                    break;
                case 54358649:
                    int i17 = f42 * (f38 ^ 813);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-71, -61, -23, -64, -18, -62, -20, -101}, "bf2c5e738d"));
                    break;
                case 54366528:
                    int i18 = f42 * (f38 ^ 2663);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-29, -59, -21, -98, -67, -64, -18, -64}, "8b06fa5bcc", 1));
                    break;
                case 54390430:
                    int i19 = f42 * (f38 | 4563);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-21, -87, -67, -87, -20, -103, -65, -55}, "06f678da"));
                    break;
                case 54394303:
                    int i20 = f42 * (f38 | 2155);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-66, -57, -72, -62, -71, -57, -67, -89}, "eccabcf8ad7b6763", false));
                    break;
                case 54394394:
                    int i21 = f42 * (f38 | 4249);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-65, -111, -30, -59, -17, -98, -66, -106}, "d39e48e439bd7e5c"));
                    break;
                case 54396098:
                    return C0005.m336(f45, 154, 905187374 ^ C0009.f80, 0);
            }
        }
    }

    /* JADX INFO: renamed from: ۧۢ۟ۤ, reason: not valid java name and contains not printable characters */
    public static String m193(Object obj) {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-70, -63, -17, -2, -20, -59, -17, -112}, "aa4a7d42b4fc8ff2"));
        while (true) {
            switch (iM323) {
                case 54149343:
                    int i = f42 * (f38 + 1338);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-29, -109, -21, -50, -67, -103, -67, -106}, "800ff9f7", 0.0f));
                    break;
                case 54150235:
                    int i2 = f42 * (f38 | 1136);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-22, -107, -71, -90, -20, -111, -24, -97}, "13b972379597"));
                    break;
                case 54152999:
                    int i3 = f42 * (f38 ^ 8145);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-71, -107, -23, -98, -17, -63, -24, -99}, "b7284c35"));
                    break;
                case 54155847:
                    int i4 = f42 * (f38 | 8115);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-66, -112, -67, -111, -71, -59, -19, -102}, "e0f7ba69c4f9e588", 0.0f));
                    break;
                case 54178912:
                    int i5 = f42 * (f38 + 3610);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-17, -82, -29, -84, -72, -51, -71, -105}, "4183ceb08aaa", 0.0f));
                    break;
                case 54180995:
                    int i6 = f42 * (f38 + 2227);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-22, -105, -70, -7, -24, -100, -70, -106}, "10af38a131c2fe", 0.0f));
                    break;
                case 54185733:
                    int i7 = f42 * (f38 + 8013);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-19, -63, -18, -57, -17, -107, -66, -112}, "6a5f43e845c573", 6));
                    break;
                case 54186536:
                    int i8 = f42 * (f38 | 1419);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-72, -101, -24, -111, -19, -111, -18, -110}, "c83665505d", 0.0f));
                    break;
                case 54211526:
                    int i9 = f42 * (f38 ^ 4709);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-18, -109, -21, -111, -23, -108, -22, -60}, "5107201c5437", true));
                    break;
                case 54238562:
                    int i10 = f42 * (f38 ^ 7384);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-21, -64, -21, -107, -23, -83, -70, -52}, "0b0422ad", true));
                    break;
                case 54240360:
                    int i11 = f42 * (f38 | 377);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-17, -3, -29, -64, -22, -62, -24, -108}, "4b8f1c356f4a0460", 2));
                    break;
                case 54245258:
                    int i12 = f42 * (f38 | 4421);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-29, -112, -67, -111, -66, -4, -29, -107}, "81f3ec"));
                    break;
                case 54245319:
                    int i13 = f42 * (f38 | 1970);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-22, -81, -71, -112, -22, -62, -23, -106}, "10b01d26ffcc06"));
                    break;
                case 54246368:
                    int i14 = f42 * (f38 ^ 1176);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-23, -7, -21, -57, -72, -106, -23, -61}, "2f0dc4"));
                    break;
                case 54275227:
                    int i15 = f42 * (f38 | 3824);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-65, -102, -29, -111, -70, -107, -22, -105}, "d287a11355b9d16e", 0.0f));
                    break;
                case 54276066:
                    int i16 = f42 * (f38 + 7347);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-23, -111, -70, -88, -67, -101, -29, -97}, "23a7f8870a"));
                    break;
                case 54276902:
                    int i17 = f42 * (f38 + 6470);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-67, -58, -30, -62, -20, -60, -23, -58}, "fd9e7c2d03d1ca48"));
                    break;
                case 54336583:
                    int i18 = f42 * (f38 + 5378);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-24, -107, -18, -61, -30, -106, -20, -107}, "325d94742deb", 0.0f));
                    break;
                case 54357726:
                    int i19 = f42 * (f38 ^ 6532);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-23, -111, -71, -109, -23, -83, -21, -60}, "21b4220de9202c8d"));
                    break;
                case 54360602:
                    int i20 = f42 * (f38 | 5232);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-65, -57, -67, -98, -17, -112, -18, -105}, "dbf6435015458a"));
                    break;
                case 54387547:
                    int i21 = f42 * (f38 + 407);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-24, -111, -21, -109, -70, -54, -20, -104}, "3205ab78", 0.0f));
                    break;
                case 54395167:
                    if (m146() <= 0) {
                        return ((String) obj).trim();
                    }
                    return null;
                case 54424062:
                    int i22 = f42 * (f38 + 3803);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-23, -112, -71, -105, -72, -106, -23, -105}, "26b5c5", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۧۧ۟, reason: not valid java name and contains not printable characters */
    private static String m194() {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-30, -59, -19, -108, -24, -57, -21, -108}, "9e653e04a1", 5));
        while (true) {
            switch (iM310) {
                case 54152159:
                    int i = f42 * (f38 | 6295);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-30, -109, -22, -102, -21, -61, -30, -108}, "91190c", false));
                    break;
                case 54154885:
                    int i2 = f42 * (f38 ^ 1148);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-72, -102, -17, -109, -66, -112, -72, -108}, "c240e3", false));
                    break;
                case 54157864:
                    return C0005.m336(f45, 90, 722913378 ^ C0009.f80, 26);
                case 54157926:
                    int i3 = f42 * (f38 ^ 2082);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-70, -111, -19, -106, -72, -58, -71, -55}, "a962caba42"));
                    break;
                case 54180863:
                    int i4 = f42 * (f38 + 6871);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-20, -61, -19, -103, -67, -105, -23, -101}, "7b61f228", false));
                    break;
                case 54186721:
                    int i5 = f42 * (f38 | 3097);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-19, -59, -70, -112, -30, -105, -18, -61}, "6ba0965d", false));
                    break;
                case 54210751:
                    int i6 = f42 * (f38 | 4273);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-67, -63, -29, -51, -71, -57, -66, -110}, "fb8ebde5fedee9", 6));
                    break;
                case 54217477:
                    int i7 = f42 * (f38 | 2896);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-24, -107, -18, -6, -29, -111, -23, -112}, "365e8923a0", 2));
                    break;
                case 54242310:
                    int i8 = f42 * (f38 | 8016);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-70, -85, -24, -97, -71, -64, -70, -109}, "a437bda04814", 6));
                    break;
                case 54268503:
                    int i9 = f42 * (f38 + 7146);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-72, -54, -22, -110, -23, -99, -20, -97}, "cb1728790f", true));
                    break;
                case 54276040:
                    int i10 = f42 * (f38 | 6508);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-17, -63, -29, -97, -17, -105, -17, -2}, "4a8842"));
                    break;
                case 54277001:
                    int i11 = f42 * (f38 | 374);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-30, -57, -29, -112, -29, -59, -30, -64}, "9c858f", 0.0f));
                    break;
                case 54303905:
                    int i12 = f42 * (f38 | 7013);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-30, -61, -24, -110, -24, -111, -30, -61}, "9d3734"));
                    break;
                case 54305985:
                    int i13 = f42 * (f38 + 2383);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-24, -89, -72, -99, -70, -64, -24, -104}, "38c8aa", 0.0f));
                    break;
                case 54306846:
                    int i14 = f42 * (f38 + 4585);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-67, -84, -20, -52, -30, -62, -67, -112}, "f37d9d", false));
                    break;
                case 54388415:
                    int i15 = f42 * (f38 ^ 6978);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-24, -59, -30, -53, -21, -110, -21, -89}, "3a9c0708a47d", true));
                    break;
                case 54393344:
                    int i16 = f42 * (f38 + 3930);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-30, -86, -19, -57, -19, -105, -70, -110}, "956e61a0", 3));
                    break;
                case 54421150:
                    int i17 = f42 * (f38 ^ 112);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-67, -104, -23, -51, -65, -106, -19, -63}, "f02ed56d95", true));
                    break;
                case 54422237:
                    int i18 = f42 * (f38 ^ 377);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-19, -106, -67, -60, -24, -104, -19, -108}, "62fc30"));
                    break;
                case 54423134:
                    int i19 = f42 * (f38 | 7506);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-21, -57, -22, -112, -67, -101, -66, -110}, "0d17f8e51d", 0.0f));
                    break;
                case 54425954:
                    int i20 = f42 * (f38 | 3805);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-65, -61, -17, -107, -66, -110, -71, -109}, "db44e7b72e40", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۢۧ۟, reason: not valid java name and contains not printable characters */
    private static String m195() {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-23, -2, -65, -108, -65, -83, -20, -104}, "2ad4d270c77311ad", 0.0f));
        while (true) {
            switch (iM342) {
                case 54150026:
                    int i = f42 * (f38 ^ 7981);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-24, -61, -21, -112, -72, -59, -71, -109}, "3d05ceb2f588be", 5));
                    break;
                case 54152187:
                    int i2 = f42 * (f38 ^ 5797);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-30, -99, -21, -109, -67, -111, -20, -111}, "9506f3719a", 4));
                    break;
                case 54156782:
                    int i3 = f42 * (f38 | 3031);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-18, -64, -22, -110, -67, -61, -18, -62}, "5f12fb", 3));
                    break;
                case 54184833:
                    int i4 = f42 * (f38 ^ 7846);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-65, -59, -17, -59, -66, -107, -66, -111}, "da4ce0e3222ec6", true));
                    break;
                case 54210810:
                    int i5 = f42 * (f38 + 6778);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-20, -112, -30, -104, -71, -112, -70, -100}, "7898b0a9711c527a", 0.0f));
                    break;
                case 54212546:
                    int i6 = f42 * (f38 + 1433);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-65, -97, -29, -100, -21, -107, -24, -105}, "d88406304797"));
                    break;
                case 54244351:
                    int i7 = f42 * (f38 ^ 7773);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-70, -58, -65, -61, -70, -111, -65, -111}, "aadaa0d3", 5));
                    break;
                case 54303845:
                    int i8 = f42 * (f38 | 951);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-70, -60, -17, -111, -71, -59, -24, -97}, "ab45be38bc", false));
                    break;
                case 54304927:
                    int i9 = f42 * (f38 | 5009);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-66, -102, -65, -107, -29, -105, -17, -105}, "e8d0834707"));
                    break;
                case 54305854:
                    int i10 = f42 * (f38 + 5524);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-65, -97, -21, -110, -18, -99, -17, -59}, "d805554a92", false));
                    break;
                case 54331771:
                    int i11 = f42 * (f38 + 2020);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-72, -108, -22, -59, -23, -111, -72, -81}, "c01b25", 3));
                    break;
                case 54336482:
                    return C0005.m336(f45, 153, 1784043421 ^ C0005.f72, 1);
                case 54358621:
                    int i12 = f42 * (f38 ^ 5104);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-20, -58, -66, -108, -66, -105, -67, -106}, "7fe1e1f4226a", false));
                    break;
                case 54362437:
                    int i13 = f42 * (f38 ^ 2052);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-71, -55, -72, -84, -21, -106, -67, -86}, "bac300f587d5", 4));
                    break;
                case 54390332:
                    int i14 = f42 * (f38 | 2307);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-65, -106, -21, -63, -72, -63, -17, -61}, "d30bcb4c", 0.0f));
                    break;
                case 54393183:
                    int i15 = f42 * (f38 | 4323);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-22, -64, -67, -64, -67, -103, -30, -108}, "1dfef891", 0));
                    break;
                case 54395356:
                    int i16 = f42 * (f38 + 6072);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-67, -2, -70, -64, -65, -97, -66, -81}, "faabd8e021c4", 0.0f));
                    break;
                case 54396165:
                    int i17 = f42 * (f38 ^ 622);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-20, -111, -65, -107, -23, -63, -20, -111}, "70d42f"));
                    break;
                case 54417392:
                    int i18 = f42 * (f38 + 7354);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-20, -106, -19, -59, -30, -59, -18, -59}, "776f9d5dc93f81", 0.0f));
                    break;
                case 54418173:
                    int i19 = f42 * (f38 + 3442);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-20, -52, -30, -111, -72, -112, -21, -58}, "7d90c60cf5b088", 4));
                    break;
                case 54419320:
                    int i20 = f42 * (f38 + 6698);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-22, -7, -70, -59, -18, -103, -70, -108}, "1fab59a22068", 2));
                    break;
                case 54423035:
                    int i21 = f42 * (f38 | 4190);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-19, -108, -23, -51, -29, -105, -22, -6}, "612e871e2c", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۨۨۢ, reason: not valid java name and contains not printable characters */
    public static String m196() {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-20, -111, -29, -102, -17, -110, -20, -110}, "748946"));
        while (true) {
            switch (iM317) {
                case 54211530:
                    int i = f42 * (f38 | 6960);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-66, -59, -29, -109, -72, -54, -22, -87}, "eb81cb16c307", 3));
                    break;
                case 54212615:
                    if (Z5HFgwkz.m63() >= 0) {
                        return m176();
                    }
                    return null;
                case 54215583:
                    int i2 = f42 * (f38 ^ 3439);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-66, -105, -21, -107, -19, -64, -21, -102}, "e3036b023c35"));
                    break;
                case 54241593:
                    int i3 = f42 * (f38 | 3463);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-23, -63, -67, -62, -71, -105, -23, -52}, "2dfeb2", 4));
                    break;
                case 54244226:
                    int i4 = f42 * (f38 + 5493);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-30, -99, -70, -98, -24, -81, -30, -104}, "99a630"));
                    break;
                case 54246399:
                    int i5 = f42 * (f38 ^ 517);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-19, -112, -22, -107, -67, -64, -17, -110}, "6316fb458993e7"));
                    break;
                case 54270301:
                    int i6 = f42 * (f38 | 2047);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-29, -61, -30, -105, -71, -112, -17, -61}, "8a95b84b", true));
                    break;
                case 54272165:
                    int i7 = f42 * (f38 | 4490);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-18, -109, -71, -61, -65, -60, -18, -82}, "51bfdd", 1));
                    break;
                case 54273249:
                    int i8 = f42 * (f38 ^ 1030);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-22, -110, -30, -57, -70, -99, -65, -109}, "119fa9d0c5dbb0"));
                    break;
                case 54304840:
                    int i9 = f42 * (f38 ^ 7207);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-20, -105, -67, -109, -65, -111, -30, -104}, "70f5d299", 7));
                    break;
                case 54306662:
                    int i10 = f42 * (f38 | 5119);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-22, -110, -66, -60, -66, -112, -18, -105}, "13ebe657854b", false));
                    break;
                case 54330716:
                    int i11 = f42 * (f38 ^ 2937);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-71, -112, -20, -61, -72, -111, -23, -62}, "b87bc92ff0b84b19", false));
                    break;
                case 54330812:
                    int i12 = f42 * (f38 + 7257);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-66, -103, -22, -107, -17, -107, -30, -98}, "e115439641", 0.0f));
                    break;
                case 54331808:
                    int i13 = f42 * (f38 ^ 7988);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-29, -111, -29, -106, -19, -55, -66, -111}, "83816ae36a", 3));
                    break;
                case 54335685:
                    int i14 = f42 * (f38 ^ 4811);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-21, -109, -30, -109, -30, -7, -30, -102}, "02919f927f", 5));
                    break;
                case 54390546:
                    int i15 = f42 * (f38 | 6895);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-19, -98, -67, -107, -29, -108, -70, -5}, "69f080ad3790a78d", false));
                    break;
                case 54393305:
                    int i16 = f42 * (f38 + 6389);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-30, -108, -19, -109, -67, -59, -30, -109}, "9161ff", 6));
                    break;
                case 54394237:
                    int i17 = f42 * (f38 + 923);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-65, -110, -19, -110, -72, -63, -65, -88}, "d760ca"));
                    break;
                case 54418362:
                    int i18 = f42 * (f38 + 776);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-29, -54, -72, -110, -17, -50, -21, -105}, "8bc34f070e", 6));
                    break;
                case 54419377:
                    int i19 = f42 * (f38 ^ 3318);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-71, -61, -19, -62, -21, -102, -19, -104}, "bb6a0960"));
                    break;
                case 54419381:
                    int i20 = f42 * (f38 | 1631);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-21, -110, -18, -105, -17, -61, -17, -108}, "01534e4223c484a8", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۨۨۡ, reason: not valid java name and contains not printable characters */
    public static int m197() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-17, -88, -21, -102, -18, -61, -17, -109}, "47025c"));
        while (true) {
            switch (iM315) {
                case 54152005:
                    int i = f42 * (f38 ^ 4345);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-19, -110, -24, -108, -30, -110, -65, -101}, "623297d9f4"));
                    break;
                case 54154828:
                    int i2 = f42 * (f38 ^ 2805);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-24, -61, -24, -101, -23, -110, -24, -59}, "3e3827", true));
                    break;
                case 54157741:
                    int i3 = f42 * (f38 ^ 5354);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-65, -99, -66, -63, -20, -110, -67, -58}, "d5ec70fae2a6ad", 0.0f));
                    break;
                case 54185763:
                    int i4 = f42 * (f38 | 4740);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-24, -102, -20, -7, -24, -97, -29, -60}, "397f378c24ce71", 0.0f));
                    break;
                case 54209726:
                    int i5 = f42 * (f38 | 6742);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-67, -106, -65, -108, -65, -104, -18, -62}, "f2d6d95e", 0.0f));
                    break;
                case 54212550:
                    int i6 = f42 * (f38 | 1338);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-22, -111, -21, -60, -66, -59, -66, -81}, "140ceee080", true));
                    break;
                case 54242522:
                    int i7 = f42 * (f38 | 631);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-19, -60, -67, -106, -23, -58, -19, -108}, "6cf22b61b6c684", 2));
                    break;
                case 54268507:
                    int i8 = f42 * (f38 | 5633);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-23, -112, -70, -63, -20, -59, -17, -61}, "23ab7a4d"));
                    break;
                case 54272227:
                    int i9 = f42 * (f38 ^ 5787);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-65, -90, -24, -100, -72, -4, -23, -106}, "d939cc2327e087f8", true));
                    break;
                case 54276033:
                    int i10 = f42 * (f38 | 3511);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-21, -89, -21, -61, -18, -108, -19, -111}, "080a55625f", 0.0f));
                    break;
                case 54300964:
                    int i11 = f42 * (f38 + 5036);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-29, -61, -30, -105, -71, -3, -21, -60}, "8f92bb0fc15d69"));
                    break;
                case 54330969:
                    int i12 = f42 * (f38 ^ 7497);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-23, -102, -65, -102, -65, -112, -30, -87}, "22d2d296dcc81d", 0.0f));
                    break;
                case 54333571:
                    int i13 = 0;
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    char c = 37260;
                    while (true) {
                        switch (c) {
                            case 37260:
                                i15 += i15;
                                i13 = 1237523456;
                                i14 = 1988295030;
                                c = 62394;
                                break;
                            case 62394:
                                i15 ^= i15;
                                i16 += 36;
                                i13 ^= i14;
                                c = 45459;
                                break;
                            case 45459:
                                return i13;
                            case 30527:
                                i16 %= 5;
                                i15 = ((i15 + 54) % 40) + 119;
                                break;
                        }
                    }
                    break;
                case 54335521:
                    int i17 = f42 * (f38 ^ 2787);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-70, -106, -22, -105, -22, -106, -19, -62}, "a510156bdf"));
                    break;
                case 54360605:
                    int i18 = f42 * (f38 + 3166);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-22, -97, -24, -108, -22, -101, -67, -104}, "173119f8e20816b8", true));
                    break;
                case 54361624:
                    int i19 = f42 * (f38 | 5976);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-23, -108, -70, -102, -22, -61, -21, -110}, "26a91d026f", false));
                    break;
                case 54392350:
                    int i20 = f42 * (f38 ^ 8113);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-22, -60, -70, -103, -29, -111, -22, -57}, "1ea982", 6));
                    break;
                case 54420159:
                    int i21 = f42 * (f38 + 4304);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-21, -110, -29, -102, -19, -111, -18, -106}, "0488625278"));
                    break;
                case 54423035:
                    int i22 = f42 * (f38 | 3775);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-72, -57, -71, -105, -18, -50, -70, -64}, "cbb55fad3bc3a5"));
                    break;
                case 54425917:
                    int i23 = f42 * (f38 ^ 7103);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-23, -60, -17, -105, -65, -59, -65, -106}, "2e44ddd325c4e0", 0.0f));
                    break;
            }
        }
    }
}
