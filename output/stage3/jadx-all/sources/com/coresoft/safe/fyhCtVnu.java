package com.coresoft.safe;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Iterator;
import p000.p001.C0010;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage3/dex/classes11.dex */
public class fyhCtVnu {

    /* JADX INFO: renamed from: ۟۟ۥۨۢ, reason: not valid java name and contains not printable characters */
    public static int f30 = 102574609;

    /* JADX INFO: renamed from: ۟ۢۨ۠, reason: not valid java name and contains not printable characters */
    public static int f31 = -715;

    /* JADX INFO: renamed from: ۠ۦۧۥ, reason: not valid java name and contains not printable characters */
    private static String f32 = null;

    /* JADX INFO: renamed from: ۣ۠ۤۤ, reason: not valid java name and contains not printable characters */
    public static int f33 = 1525235897;

    /* JADX INFO: renamed from: ۤ۠ۡ۟ۨ۠, reason: not valid java name and contains not printable characters */
    private static byte[] f34;

    /* JADX INFO: renamed from: ۥ۠ۧۤ, reason: contains not printable characters */
    private static String f35;

    /* JADX INFO: renamed from: ۦۧ۠ۡۡ, reason: contains not printable characters */
    private static short[] f36 = {18199, 18179, 18190, 18201, 18265, 18263, 18193, -12701, -12706, -12689, -12691, -12699, -12689, -12695, -12693, -12675, 25628, 25615, 25600, 25613, 25606, 25627, 8104, 8168, 8182, 8153, 8163, 8190, 8178, 8104, 8167, 8182, 8173, -8063, -8043, -8040, -8049, -7985, -7999, 30653, 30655, 30644, 30655, 30632, 30643, 30649, 30709, 30633, 30654, 30641, 30709, 30653, 30655, 30644, 30655, 30632, 30643, 30649, 1016, 1017, 1006, -16267, -16265, -16260, -16265, -16288, -16261, -16271, -16323, -16284, -16272, -16259, -16278, -16342, -16348, -16286, -16323, -16284, -16272, -16259, -16278, -16342, -16348, -16286, -2661, -2631, -2638, -2651, -2639, -2637, -2648, -2635, -2637, -2638, -7248, -7253, -7250, -7253, -7254, -7246, -7253};

    /* JADX INFO: renamed from: ۣ۟۟ۦۤ, reason: not valid java name and contains not printable characters */
    public static Object m152(Object obj) {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-18, -100, -72, -112, -20, -59, -67, -82}, "58c47af1ce", true));
        while (true) {
            switch (iM336) {
                case 54149125:
                    int i = f33 * (f30 + 5655);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-24, -105, -66, -107, -22, -97, -29, -110}, "30e31887", true));
                    break;
                case 54152969:
                    int i2 = f33 * (f30 | 7506);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-70, -62, -66, -109, -67, -112, -29, -108}, "abe2f287", 4));
                    break;
                case 54156032:
                    int i3 = f33 * (f30 | 621);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-18, -109, -71, -102, -72, -5, -18, -110}, "53b9cd", 7));
                    break;
                case 54180866:
                    if (hYNP32vq.m211() > 0) {
                        return ((Iterator) obj).next();
                    }
                    return null;
                case 54182693:
                    int i4 = f33 * (f30 | 2982);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-21, -59, -20, -108, -22, -102, -21, -53}, "0c7312"));
                    break;
                case 54182978:
                    int i5 = f33 * (f30 | 1881);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-22, -54, -29, -59, -22, -85, -65, -6}, "1b8c14deabec45"));
                    break;
                case 54214528:
                    int i6 = f33 * (f30 + 2728);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-70, -61, -65, -60, -23, -98, -66, -107}, "afde26e59f", 6));
                    break;
                case 54245345:
                    int i7 = f33 * (f30 ^ 6767);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-17, -97, -21, -109, -17, -62, -22, -106}, "48044b12", 0));
                    break;
                case 54246397:
                    int i8 = f33 * (f30 | 109);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-66, -63, -29, -100, -70, -111, -66, -58}, "ed84a6", 5));
                    break;
                case 54273311:
                    int i9 = f33 * (f30 | 7911);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-30, -2, -23, -64, -21, -108, -70, -59}, "9a2f03ae", true));
                    break;
                case 54300153:
                    int i10 = f33 * (f30 ^ 1702);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-66, -59, -20, -60, -29, -108, -66, -61}, "eb7e81", true));
                    break;
                case 54302971:
                    int i11 = f33 * (f30 ^ 3236);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-71, -100, -23, -108, -17, -58, -18, -109}, "b4204f5613b3", 7));
                    break;
                case 54327992:
                    int i12 = f33 * (f30 + 5336);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-70, -59, -72, -62, -22, -104, -24, -57}, "afcf103a9457", 5));
                    break;
                case 54329791:
                    int i13 = f33 * (f30 + 1645);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-65, -59, -71, -111, -19, -62, -19, -61}, "dab06d6a5928cb"));
                    break;
                case 54330004:
                    int i14 = f33 * (f30 ^ 2792);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-24, -58, -23, -64, -19, -100, -65, -109}, "3d2f69d114", 6));
                    break;
                case 54336702:
                    int i15 = f33 * (f30 ^ 6542);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-65, -103, -22, -109, -18, -104, -71, -109}, "d91050b4f9dc", false));
                    break;
                case 54365569:
                    int i16 = f33 * (f30 ^ 3699);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-24, -103, -65, -58, -30, -64, -18, -61}, "31de9e5f1a002b"));
                    break;
                case 54389494:
                    int i17 = f33 * (f30 | 1943);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-67, -106, -66, -90, -29, -63, -19, -58}, "f3e98d6e2c", 0.0f));
                    break;
                case 54394365:
                    int i18 = f33 * (f30 + 4731);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-72, -106, -72, -110, -72, -107, -22, -59}, "c3c3c41aa5b2", 0.0f));
                    break;
                case 54395108:
                    int i19 = f33 * (f30 ^ 6006);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-66, -7, -67, -63, -22, -107, -18, -61}, "effb145e", 2));
                    break;
                case 54421211:
                    int i20 = f33 * (f30 ^ 1957);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-71, -107, -72, -61, -67, -63, -67, -89}, "b4cffbf8a1eae2", 1));
                    break;
                case 54422017:
                    int i21 = f33 * (f30 ^ 6470);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-30, -63, -67, -111, -21, -111, -23, -104}, "9cf60928fd06c64c", 0.0f));
                    break;
                case 54423902:
                    int i22 = f33 * (f30 ^ 1477);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-23, -85, -71, -88, -19, -104, -20, -110}, "24b76974e2", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۠۠ۨۢ, reason: not valid java name and contains not printable characters */
    public static boolean m153(Object obj) {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-65, -97, -19, -89, -24, -100, -30, -58}, "d968349cbf", true));
        while (true) {
            switch (iM311) {
                case 54156961:
                    int i = f33 * (f30 + 4655);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-19, -60, -71, -110, -71, -109, -21, -112}, "6bb2b70200ec"));
                    break;
                case 54157771:
                    int i2 = f33 * (f30 ^ 6372);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-72, -85, -24, -111, -17, -60, -29, -84}, "c4364b8301"));
                    break;
                case 54157868:
                    int i3 = f33 * (f30 + 5390);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-29, -63, -70, -109, -30, -59, -18, -101}, "8ba59d531b", 1));
                    break;
                case 54185862:
                    int i4 = f33 * (f30 + 1509);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-18, -106, -23, -62, -22, -104, -65, -106}, "542f18d6", true));
                    break;
                case 54214435:
                    int i5 = f33 * (f30 + 6062);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-30, -60, -29, -60, -20, -57, -66, -107}, "9b8b7fe7", 0.0f));
                    break;
                case 54216581:
                    int i6 = f33 * (f30 | 5002);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-23, -108, -21, -108, -20, -61, -22, -108}, "27077b1669", false));
                    break;
                case 54217447:
                    int i7 = f33 * (f30 | 1350);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-23, -61, -67, -89, -17, -106, -22, -106}, "2ef84312dfae04", true));
                    break;
                case 54239639:
                    int i8 = f33 * (f30 | 5715);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-21, -106, -24, -106, -22, -112, -21, -85}, "043014", 0.0f));
                    break;
                case 54243266:
                    int i9 = f33 * (f30 + 2049);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-22, -54, -19, -59, -71, -105, -22, -97}, "1b6bb61859", 6));
                    break;
                case 54245311:
                    if (OUHQwdrD.m42() <= 0) {
                        return ((Iterator) obj).hasNext();
                    }
                    return false;
                case 54246181:
                    int i10 = f33 * (f30 | 3760);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-22, -107, -22, -106, -22, -109, -70, -58}, "171614af3e58"));
                    break;
                case 54272129:
                    int i11 = f33 * (f30 | 123);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-22, -112, -71, -108, -19, -62, -65, -90}, "11b16bd913b894", 0.0f));
                    break;
                case 54275018:
                    int i12 = f33 * (f30 ^ 3800);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-24, -102, -17, -52, -20, -3, -21, -109}, "394d7b0162620516", 0));
                    break;
                case 54276872:
                    int i13 = f33 * (f30 ^ 1697);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-67, -110, -71, -106, -19, -87, -18, -57}, "f6b7665b454a", 0.0f));
                    break;
                case 54299939:
                    int i14 = f33 * (f30 + 2744);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-20, -105, -66, -101, -70, -112, -19, -86}, "71e3a565db", 1));
                    break;
                case 54357784:
                    int i15 = f33 * (f30 | 3320);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-29, -6, -23, -111, -72, -110, -65, -58}, "8e29c6daac", false));
                    break;
                case 54357878:
                    int i16 = f33 * (f30 ^ 1896);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-72, -87, -67, -99, -66, -59, -72, -107}, "c6f5ed", true));
                    break;
                case 54358712:
                    int i17 = f33 * (f30 + 4827);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-24, -61, -21, -109, -30, -102, -67, -53}, "3c0592fc", true));
                    break;
                case 54364385:
                    int i18 = f33 * (f30 | 2578);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-65, -110, -19, -111, -17, -59, -24, -112}, "d0664d312a0b", 0.0f));
                    break;
                case 54366428:
                    int i19 = f33 * (f30 | 4878);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-29, -111, -23, -111, -65, -98, -67, -59}, "8026d9fc4f43613a", 2));
                    break;
                case 54424153:
                    int i20 = f33 * (f30 ^ 2249);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-70, -103, -22, -101, -22, -109, -30, -59}, "a813179a"));
                    break;
                case 54424933:
                    int i21 = f33 * (f30 + 1476);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-17, -50, -23, -108, -19, -58, -30, -110}, "4f226a90703c3ed8", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۠ۢۨ۠, reason: not valid java name and contains not printable characters */
    public static void m154(Object obj) throws IOException {
        int iM343 = C0008.m343(C0010.decode(new byte[]{-18, -64, -67, -106, -70, -53, -18, -62}, "5cf3ac", true));
        while (true) {
            switch (iM343) {
                case 54154980:
                    int i = f33 * (f30 ^ 4901);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-18, -82, -22, -53, -71, -61, -19, -111}, "511cbe60ffa0ba", 6));
                    break;
                case 54155077:
                    int i2 = f33 * (f30 | 859);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-19, -108, -70, -109, -65, -110, -18, -100}, "66a4d05467", 0.0f));
                    break;
                case 54157924:
                    int i3 = f33 * (f30 | 5803);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-23, -106, -21, -81, -19, -107, -17, -84}, "2700604346a3ac", true));
                    break;
                case 54183936:
                    int i4 = f33 * (f30 + 5279);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-18, -57, -71, -107, -29, -7, -22, -60}, "5ab58f1ce469b1de", 0.0f));
                    break;
                case 54208796:
                    int i5 = f33 * (f30 + 1302);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-17, -61, -67, -57, -65, -107, -22, -64}, "4efad41f5e", 0.0f));
                    break;
                case 54208824:
                    int i6 = f33 * (f30 | 520);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-19, -108, -22, -109, -20, -111, -19, -111}, "631370"));
                    break;
                case 54245410:
                    int i7 = f33 * (f30 + 5895);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-21, -59, -23, -99, -19, -101, -19, -64}, "0b29636eca8819"));
                    break;
                case 54246219:
                    int i8 = f33 * (f30 + 1040);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-17, -64, -17, -106, -65, -60, -66, -62}, "4c41dceb", 4));
                    break;
                case 54274267:
                    int i9 = f33 * (f30 | 5136);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-67, -97, -23, -98, -18, -100, -18, -81}, "f9295850", 0.0f));
                    break;
                case 54276157:
                    int i10 = f33 * (f30 + 5823);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-71, -60, -65, -99, -18, -112, -30, -112}, "bad85191bee9", 0));
                    break;
                case 54329978:
                    int i11 = f33 * (f30 ^ 5509);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-72, -53, -20, -105, -29, -62, -72, -64}, "cc758bcad872", true));
                    break;
                case 54331654:
                    int i12 = f33 * (f30 + 21);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-67, -108, -67, -108, -66, -107, -72, -97}, "f1f7e7c7d66a7912"));
                    break;
                case 54331748:
                    int i13 = f33 * (f30 | 5502);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-29, -100, -70, -112, -71, -61, -66, -111}, "84a0bde77e"));
                    break;
                case 54333632:
                    int i14 = f33 * (f30 ^ 6505);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-24, -104, -71, -88, -65, -108, -19, -64}, "39b7d06bfa65"));
                    break;
                case 54334816:
                    int i15 = f33 * (f30 | 5782);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-72, -105, -19, -109, -20, -84, -30, -59}, "c260739b0923", 4));
                    break;
                case 54358562:
                    int i16 = f33 * (f30 + 3469);
                    iM343 = C0000.m309(C0010.decode(new byte[]{-30, -89, -20, -58, -29, -105, -22, -101}, "987c83193c"));
                    break;
                case 54364389:
                    int i17 = f33 * (f30 | 2070);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-24, -99, -17, -61, -70, -62, -29, -111}, "384bae84c488", 2));
                    break;
                case 54365436:
                    int i18 = f33 * (f30 | 2230);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-17, -104, -20, -59, -23, -100, -18, -99}, "487a24590b5f2e", 4));
                    break;
                case 54387483:
                    if (hYNP32vq.m211() > 0) {
                        ((FileOutputStream) obj).close();
                        return;
                    }
                    return;
                case 54388410:
                    int i19 = f33 * (f30 + 503);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-19, -3, -21, -57, -65, -59, -30, -112}, "6b0bdb96208e34", 0));
                    break;
                case 54392474:
                    int i20 = f33 * (f30 | 4272);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-66, -64, -71, -59, -66, -50, -19, -98}, "eebcef69", 7));
                    break;
                case 54418391:
                    int i21 = f33 * (f30 | 3068);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-21, -111, -70, -86, -30, -58, -21, -109}, "06a59d", true));
                    break;
                case 54420091:
                    int i22 = f33 * (f30 ^ 3164);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-22, -102, -19, -98, -71, -108, -30, -108}, "1868b391", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۠ۤۥۨ, reason: not valid java name and contains not printable characters */
    public static void m155(Object obj) throws IOException {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-20, -109, -20, -60, -67, -58, -17, -100}, "747afa440e62af", 7));
        while (true) {
            switch (iM336) {
                case 54149089:
                    int i = f33 * (f30 | 5248);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-71, -105, -29, -108, -72, -82, -20, -61}, "b287c17cc6cd1b42"));
                    break;
                case 54150297:
                    int i2 = f33 * (f30 ^ 183);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-21, -3, -21, -103, -67, -103, -66, -7}, "0b01f9efd99d7fb3"));
                    break;
                case 54152226:
                    int i3 = f33 * (f30 | 7883);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-20, -111, -23, -62, -17, -112, -30, -107}, "722d4293", true));
                    break;
                case 54156782:
                    int i4 = f33 * (f30 + 2488);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-71, -97, -66, -4, -65, -106, -19, -111}, "b7ecd36081c8c4"));
                    break;
                case 54157736:
                    int i5 = f33 * (f30 | 5326);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-70, -58, -22, -101, -71, -5, -70, -55}, "aa18bd", 5));
                    break;
                case 54184621:
                    int i6 = f33 * (f30 + 2334);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-24, -110, -19, -88, -23, -58, -66, -60}, "33672deef3"));
                    break;
                case 54208733:
                    int i7 = f33 * (f30 | 3041);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-70, -108, -65, -105, -17, -58, -67, -64}, "a6d14ffb82e2", 1));
                    break;
                case 54209849:
                    if (m156() <= 0) {
                        C0001.m314((InputStream) obj);
                        return;
                    }
                    return;
                case 54245190:
                    int i8 = f33 * (f30 | 5886);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-71, -105, -18, -61, -67, -58, -30, -107}, "b35bfe9682"));
                    break;
                case 54275047:
                    int i9 = f33 * (f30 ^ 6823);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-23, -59, -17, -112, -71, -62, -24, -108}, "2a47bb35b02e", 1));
                    break;
                case 54298013:
                    int i10 = f33 * (f30 | 6484);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-19, -112, -71, -103, -30, -63, -17, -112}, "61b99f4135d452", 1));
                    break;
                case 54300061:
                    int i11 = f33 * (f30 | 5330);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-18, -89, -72, -107, -23, -54, -22, -105}, "58c52b17", false));
                    break;
                case 54305732:
                    int i12 = f33 * (f30 + 1001);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-23, -62, -71, -84, -18, -87, -29, -103}, "2fb356885328b6c6", true));
                    break;
                case 54331647:
                    int i13 = f33 * (f30 ^ 4685);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-30, -97, -67, -105, -66, -100, -70, -111}, "99f6e8a0", 0));
                    break;
                case 54359672:
                    int i14 = f33 * (f30 ^ 6161);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-66, -84, -24, -105, -70, -53, -19, -107}, "e335ac62ddc598"));
                    break;
                case 54363452:
                    int i15 = f33 * (f30 + 2580);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-20, -90, -17, -86, -67, -104, -20, -104}, "7945f8", 6));
                    break;
                case 54363612:
                    int i16 = f33 * (f30 | 4461);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-21, -110, -30, -57, -21, -82, -19, -105}, "029b0160", 0.0f));
                    break;
                case 54391237:
                    int i17 = f33 * (f30 ^ 2982);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-29, -5, -72, -98, -30, -110, -22, -110}, "8dc992142049"));
                    break;
                case 54393407:
                    int i18 = f33 * (f30 + 2823);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-30, -106, -30, -60, -29, -59, -18, -105}, "909a8b5363f6"));
                    break;
                case 54417363:
                    int i19 = f33 * (f30 + 2406);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-67, -105, -17, -108, -66, -106, -67, -82}, "f141e4", 2));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۣ۟ۡۧ, reason: not valid java name and contains not printable characters */
    public static int m156() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-22, -109, -67, -97, -24, -107, -22, -108}, "12f93214767032", 6));
        while (true) {
            switch (iM324) {
                case 54151228:
                    int i = f33 * (f30 + 2405);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-30, -60, -71, -112, -30, -61, -20, -109}, "9fb09a74dc", true));
                    break;
                case 54153901:
                    int i2 = f33 * (f30 ^ 6323);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-17, -63, -70, -105, -17, -108, -23, -58}, "4ea4402b7641", 5));
                    break;
                case 54179966:
                    int i3 = f33 * (f30 ^ 2750);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-23, -107, -65, -105, -17, -107, -29, -60}, "21d4428f0a8d269b", true));
                    break;
                case 54209599:
                    int i4 = f33 * (f30 | 3201);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-24, -106, -21, -108, -20, -107, -24, -105}, "330674"));
                    break;
                case 54215614:
                    int i5 = f33 * (f30 + 7484);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-17, -102, -18, -57, -66, -107, -72, -106}, "485de2c387aa6c20", false));
                    break;
                case 54216360:
                    int i6 = f33 * (f30 | 6994);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-18, -107, -72, -112, -24, -85, -20, -84}, "54c03473ff5c", false));
                    break;
                case 54239491:
                    int i7 = f33 * (f30 ^ 4247);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-18, -100, -70, -60, -20, -2, -71, -112}, "58ad7ab07d81dbd2"));
                    break;
                case 54242527:
                    int i8 = f33 * (f30 + 2770);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-30, -108, -17, -108, -66, -112, -72, -112}, "9044e8c56498", 2));
                    break;
                case 54247304:
                    int i9 = f33 * (f30 | 4927);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-23, -107, -19, -98, -66, -61, -20, -58}, "2469ec7d9d", true));
                    break;
                case 54272224:
                    int i10 = f33 * (f30 ^ 5752);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-20, -110, -24, -107, -66, -107, -21, -54}, "7633e40bcfa804"));
                    break;
                case 54298973:
                    int i11 = f33 * (f30 + 8033);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-23, -112, -17, -102, -22, -106, -66, -58}, "234912eb948b", 3));
                    break;
                case 54299257:
                    int i12 = f33 * (f30 | 6168);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-72, -63, -67, -100, -30, -111, -70, -52}, "ccf497ad", false));
                    break;
                case 54302015:
                    int i13 = f33 * (f30 ^ 5189);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-19, -108, -30, -58, -22, -58, -24, -111}, "639e1a34d7", 0));
                    break;
                case 54302106:
                    return 198 ^ f31;
                case 54302880:
                    int i14 = f33 * (f30 | 5028);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-30, -112, -24, -99, -21, -59, -67, -58}, "94350dfdff"));
                    break;
                case 54304809:
                    int i15 = f33 * (f30 | 709);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-72, -64, -21, -109, -22, -110, -29, -107}, "ce00148083bc", true));
                    break;
                case 54304836:
                    int i16 = f33 * (f30 | 2295);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-65, -58, -18, -63, -20, -108, -70, -106}, "db5e75a71e6e37dc", 7));
                    break;
                case 54306725:
                    int i17 = f33 * (f30 + 2962);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-72, -64, -71, -112, -67, -107, -72, -111}, "cfb4f6c709921890"));
                    break;
                case 54330752:
                    int i18 = f33 * (f30 ^ 3706);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-17, -7, -70, -62, -20, -106, -70, -55}, "4faf76aa0f6d210f", 6));
                    break;
                case 54331869:
                    int i19 = f33 * (f30 + 7746);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-18, -104, -70, -106, -22, -62, -21, -105}, "58a61f0563", 0.0f));
                    break;
                case 54362529:
                    int i20 = f33 * (f30 ^ 2526);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-30, -81, -17, -112, -21, -107, -71, -109}, "904102b2", 0.0f));
                    break;
                case 54391482:
                    int i21 = f33 * (f30 ^ 1540);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-66, -58, -24, -57, -20, -61, -18, -112}, "eb3a7a54296a0b7e", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۢۥۤۦ, reason: not valid java name and contains not printable characters */
    public static String m157(String str) {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-22, -97, -22, -109, -30, -62, -18, -108}, "18129a507f7cf65f", 0.0f));
        while (true) {
            switch (iM311) {
                case 54151014:
                    String strM185 = m185();
                    int i = 0;
                    String strM178 = m178();
                    while (i < 15) {
                        strM185 = new StringBuffer().append(strM185).append(Integer.toHexString(i)).toString();
                        String string = new StringBuffer().append(strM178).append(((int) (Math.random() * ((double) 10))) ^ i).toString();
                        i++;
                        strM178 = string;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
                    while (str.length() > 0) {
                        byteArrayOutputStream.write((strM185.indexOf(str.charAt(-2)) << 4) | strM185.indexOf(str.charAt(-1)));
                    }
                    byte[] bArrM327 = C0004.m327(byteArrayOutputStream);
                    int length = bArrM327.length;
                    int length2 = strM178.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        bArrM327[i2] = (byte) (bArrM327[i2] ^ strM178.charAt(i2 % length2));
                    }
                    return new String(bArrM327);
                case 54178879:
                    int i3 = f33 * (f30 + 300);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-17, -63, -23, -106, -19, -106, -17, -62}, "4c2161", 0.0f));
                    break;
                case 54179101:
                    int i4 = f33 * (f30 + 4350);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-18, -105, -70, -104, -22, -102, -65, -108}, "53a018d5576d9991", 4));
                    break;
                case 54180901:
                    int i5 = f33 * (f30 + 2164);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-22, -53, -30, -103, -19, -59, -70, -62}, "1c916cad3fac6c6a", 0.0f));
                    break;
                case 54183811:
                    int i6 = f33 * (f30 | 5763);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-22, -82, -23, -112, -66, -107, -22, -107}, "1121e5", 0.0f));
                    break;
                case 54186728:
                    int i7 = f33 * (f30 + 4188);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-30, -62, -19, -6, -71, -60, -67, -110}, "9b6ebcf79aa1", 6));
                    break;
                case 54244293:
                    int i8 = f33 * (f30 + 5088);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-71, -107, -29, -86, -70, -103, -24, -2}, "b685a83a95c89f", 0.0f));
                    break;
                case 54245437:
                    int i9 = f33 * (f30 + 7919);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-71, -109, -18, -112, -17, -99, -71, -107}, "b35748b3", 0.0f));
                    break;
                case 54246367:
                    int i10 = f33 * (f30 ^ 902);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-18, -112, -72, -106, -17, -52, -30, -57}, "52c04d9f6729", 4));
                    break;
                case 54268282:
                    int i11 = f33 * (f30 | 5818);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-17, -109, -72, -111, -23, -111, -70, -105}, "46c327a770", 0));
                    break;
                case 54272070:
                    int i12 = f33 * (f30 | 8060);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-67, -111, -67, -105, -67, -106, -23, -58}, "f1f3f22e6b84", 0));
                    break;
                case 54275140:
                    int i13 = f33 * (f30 + 4315);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-20, -109, -70, -81, -19, -105, -23, -98}, "77a06529670f596e", 4));
                    break;
                case 54298112:
                    int i14 = f33 * (f30 | 1077);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-21, -109, -65, -105, -65, -61, -72, -109}, "05d6dac2", false));
                    break;
                case 54306755:
                    int i15 = f33 * (f30 ^ 4833);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-29, -104, -70, -61, -19, -108, -29, -97}, "88ab67", false));
                    break;
                case 54330903:
                    int i16 = f33 * (f30 ^ 3948);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-22, -105, -70, -108, -29, -105, -22, -60}, "14a2821b5510c8", 4));
                    break;
                case 54359610:
                    int i17 = f33 * (f30 + 7691);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-23, -111, -24, -101, -19, -83, -22, -109}, "22386216"));
                    break;
                case 54389435:
                    int i18 = f33 * (f30 + 3756);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-18, -63, -18, -106, -70, -110, -18, -60}, "5f50a7", 0.0f));
                    break;
                case 54389554:
                    int i19 = f33 * (f30 + 6483);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-71, -105, -20, -87, -65, -108, -21, -63}, "b776d40a363087"));
                    break;
                case 54394300:
                    int i20 = f33 * (f30 + 1682);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-30, -109, -21, -61, -21, -110, -22, -90}, "940b0519d840", 0));
                    break;
                case 54426048:
                    int i21 = f33 * (f30 + 7911);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-65, -105, -18, -107, -21, -63, -23, -111}, "d5500c25"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۢۥۥ, reason: not valid java name and contains not printable characters */
    public static ByteBuffer m158(Object obj) {
        int iM321 = C0003.m321(C0010.decode(new byte[]{-67, -63, -23, -109, -67, -57, -18, -60}, "fc21fa5f43574497"));
        while (true) {
            switch (iM321) {
                case 54150176:
                    if (yGhVwXcV.m266() <= 0) {
                        return C0002.m318((byte[]) obj);
                    }
                    return null;
                case 54151043:
                    int i = f33 * (f30 | 2408);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-29, -110, -23, -111, -23, -81, -29, -111}, "872620", true));
                    break;
                case 54178847:
                    int i2 = f33 * (f30 + 3531);
                    iM321 = C0009.m349(C0010.decode(new byte[]{-18, -57, -71, -57, -29, -109, -72, -108}, "5bbc82c6", 1));
                    break;
                case 54185576:
                    int i3 = f33 * (f30 + 586);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-20, -112, -21, -105, -22, -111, -20, -109}, "720619", 0.0f));
                    break;
                case 54187627:
                    int i4 = f33 * (f30 ^ 2595);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-21, -60, -29, -110, -66, -110, -65, -110}, "0c86e6d7c0515405", 4));
                    break;
                case 54209664:
                    int i5 = f33 * (f30 + 4517);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-18, -59, -23, -64, -21, -58, -29, -60}, "5f2d0c8a7476", 0.0f));
                    break;
                case 54213478:
                    int i6 = f33 * (f30 | 2325);
                    iM321 = C0005.m330(C0010.decode(new byte[]{-22, -109, -22, -100, -22, -7, -19, -109}, "11191f67", 7));
                    break;
                case 54240515:
                    int i7 = f33 * (f30 ^ 6082);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-67, -98, -66, -107, -22, -61, -22, -107}, "f8e31e1659adb580", false));
                    break;
                case 54240632:
                    int i8 = f33 * (f30 | 3170);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-20, -101, -65, -109, -20, -7, -20, -111}, "73d17f", true));
                    break;
                case 54241532:
                    int i9 = f33 * (f30 ^ 6982);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-72, -63, -70, -104, -23, -53, -24, -103}, "cfa82c39df395621", 7));
                    break;
                case 54244200:
                    int i10 = f33 * (f30 | 2914);
                    iM321 = C0006.m336(C0010.decode(new byte[]{-22, -106, -21, -52, -17, -61, -22, -112}, "100d4e", false));
                    break;
                case 54273217:
                    int i11 = f33 * (f30 ^ 2197);
                    iM321 = C0006.m336(C0010.decode(new byte[]{-72, -58, -21, -108, -30, -5, -65, -59}, "cf029ddd71666979", 0.0f));
                    break;
                case 54332672:
                    int i12 = f33 * (f30 ^ 5651);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-23, -109, -66, -64, -29, -63, -18, -64}, "24ee8d5e00", 4));
                    break;
                case 54333577:
                    int i13 = f33 * (f30 ^ 1889);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-29, -103, -18, -87, -21, -2, -71, -82}, "89560ab149525d", 0.0f));
                    break;
                case 54335497:
                    int i14 = f33 * (f30 + 7381);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-21, -112, -66, -63, -24, -83, -19, -103}, "06eb32686123", true));
                    break;
                case 54361439:
                    int i15 = f33 * (f30 | 1439);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-72, -82, -66, -111, -21, -63, -65, -110}, "c1e10ed1ca8e76", true));
                    break;
                case 54364541:
                    int i16 = f33 * (f30 ^ 3330);
                    iM321 = C0006.m336(C0010.decode(new byte[]{-66, -110, -19, -59, -30, -104, -30, -60}, "e36e999f3b5d", 0.0f));
                    break;
                case 54366460:
                    int i17 = f33 * (f30 ^ 7197);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-66, -110, -22, -61, -22, -2, -19, -111}, "e71f1a6913be25e1", false));
                    break;
                case 54388625:
                    int i18 = f33 * (f30 | 6426);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-66, -52, -18, -63, -22, -7, -65, -106}, "ed5a1fd4", 0.0f));
                    break;
                case 54392350:
                    int i19 = f33 * (f30 ^ 4449);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-29, -64, -65, -104, -22, -106, -17, -97}, "8bd91247bd024e", 2));
                    break;
                case 54393342:
                    int i20 = f33 * (f30 ^ 3204);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-23, -3, -20, -105, -22, -105, -24, -112}, "2b761632c13b5b", 0.0f));
                    break;
                case 54418139:
                    int i21 = f33 * (f30 ^ 5200);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-19, -105, -24, -112, -18, -110, -71, -64}, "673851bff008", 0.0f));
                    break;
                case 54420061:
                    int i22 = f33 * (f30 | 4979);
                    iM321 = C0005.m330(C0010.decode(new byte[]{-65, -59, -65, -108, -21, -60, -67, -58}, "ddd00dfe56c1fa58", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۟۟ۧۡ, reason: not valid java name and contains not printable characters */
    public static String m159(Object obj) {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-65, -110, -72, -107, -65, -97, -65, -54}, "d6c5d8db0f88", true));
        while (true) {
            switch (iM316) {
                case 54149062:
                    int i = f33 * (f30 + 1665);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-21, -61, -18, -107, -22, -108, -19, -111}, "0b50166463afc335", true));
                    break;
                case 54149307:
                    int i2 = f33 * (f30 ^ 4691);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-21, -6, -65, -60, -19, -110, -22, -105}, "0edb63156f9bb5", false));
                    break;
                case 54150300:
                    int i3 = f33 * (f30 + 971);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-67, -107, -19, -111, -24, -5, -71, -98}, "f7643db8aa5c0585", 0.0f));
                    break;
                case 54151047:
                    int i4 = f33 * (f30 ^ 734);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-22, -103, -20, -59, -65, -106, -30, -105}, "197fd390"));
                    break;
                case 54155848:
                    if (OUHQwdrD.m42() <= 0) {
                        return ((CharSequence) obj).toString();
                    }
                    return null;
                case 54156746:
                    int i5 = f33 * (f30 | 1492);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-18, -60, -21, -63, -72, -112, -70, -63}, "5e0bc0aa31", true));
                    break;
                case 54178852:
                    int i6 = f33 * (f30 | 4130);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-18, -89, -18, -83, -21, -61, -20, -58}, "58520d7d0893"));
                    break;
                case 54182885:
                    int i7 = f33 * (f30 | 2741);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-24, -112, -22, -109, -29, -87, -22, -107}, "361686124a51"));
                    break;
                case 54212514:
                    int i8 = f33 * (f30 | 5144);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-30, -105, -29, -57, -19, -59, -30, -112}, "948e6f", true));
                    break;
                case 54214440:
                    int i9 = f33 * (f30 | 1284);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-72, -3, -17, -108, -18, -64, -21, -105}, "cb455a01", 0.0f));
                    break;
                case 54214503:
                    int i10 = f33 * (f30 ^ 413);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-17, -57, -22, -58, -20, -90, -18, -98}, "4b1c795975bb9b9e"));
                    break;
                case 54239429:
                    int i11 = f33 * (f30 + 7996);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-30, -106, -22, -5, -72, -60, -19, -111}, "901dcf66211699", false));
                    break;
                case 54239614:
                    int i12 = f33 * (f30 | 4608);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-65, -88, -22, -2, -70, -88, -65, -110}, "d71aa7", 0.0f));
                    break;
                case 54244202:
                    int i13 = f33 * (f30 ^ 3379);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-65, -64, -24, -104, -24, -97, -71, -98}, "db3839b80154", false));
                    break;
                case 54271232:
                    int i14 = f33 * (f30 + 6454);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-24, -111, -65, -63, -70, -111, -24, -105}, "30dda133", false));
                    break;
                case 54299229:
                    int i15 = f33 * (f30 | 6744);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-24, -58, -23, -102, -21, -55, -24, -3}, "3b290a3b72c0", 0.0f));
                    break;
                case 54302134:
                    int i16 = f33 * (f30 ^ 6202);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-21, -105, -67, -110, -22, -108, -70, -109}, "00f110a6eb", 0));
                    break;
                case 54333576:
                    int i17 = f33 * (f30 ^ 2921);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-29, -58, -20, -88, -19, -90, -71, -100}, "8f7769b88c95dc4d", false));
                    break;
                case 54357694:
                    int i18 = f33 * (f30 | 663);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-71, -2, -19, -106, -17, -6, -71, -64}, "ba614e"));
                    break;
                case 54363367:
                    int i19 = f33 * (f30 + 2520);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-19, -83, -17, -104, -20, -112, -30, -107}, "624878967fad", true));
                    break;
                case 54391389:
                    int i20 = f33 * (f30 ^ 2578);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-67, -107, -17, -110, -71, -112, -66, -110}, "f245b5e5", false));
                    break;
                case 54395266:
                    int i21 = f33 * (f30 | 4374);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-71, -58, -65, -107, -71, -106, -67, -98}, "bdd5b6f9"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۣ۟۠ۨ, reason: not valid java name and contains not printable characters */
    public static String m160() {
        int iM349 = C0009.m349(C0010.decode(new byte[]{-22, -59, -23, -58, -22, -81, -19, -6}, "1d2f106e39b3e7", 1));
        while (true) {
            switch (iM349) {
                case 54157869:
                    int i = f33 * (f30 ^ 6537);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-70, -107, -70, -64, -17, -87, -24, -109}, "a5ac4633", 5));
                    break;
                case 54182692:
                    int i2 = f33 * (f30 | 1948);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-30, -98, -71, -101, -72, -57, -24, -82}, "96b8cc3148", true));
                    break;
                case 54209599:
                    int i3 = f33 * (f30 + 3689);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-23, -112, -24, -112, -65, -106, -67, -60}, "2335d6fc1f07"));
                    break;
                case 54238653:
                    int i4 = f33 * (f30 ^ 1267);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-19, -60, -22, -107, -22, -85, -71, -5}, "6b1014bd"));
                    break;
                case 54239612:
                    int i5 = f33 * (f30 | 7882);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-29, -57, -29, -81, -30, -112, -29, -61}, "8e8096"));
                    break;
                case 54244387:
                    int i6 = f33 * (f30 + 2213);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-17, -64, -18, -97, -17, -90, -20, -89}, "4c5949787b0b", 4));
                    break;
                case 54245351:
                    int i7 = f33 * (f30 ^ 274);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-67, -111, -17, -57, -18, -106, -65, -63}, "f64f52da16bca5", 0.0f));
                    break;
                case 54247110:
                    int i8 = f33 * (f30 | 6181);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-23, -57, -17, -62, -18, -106, -17, -97}, "2e4d5347040267a1", 0));
                    break;
                case 54274025:
                    int i9 = f33 * (f30 | 1482);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-29, -88, -21, -100, -21, -111, -65, -51}, "870405dedb54", 7));
                    break;
                case 54274947:
                    int i10 = f33 * (f30 + 6129);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-71, -61, -67, -57, -71, -103, -71, -61}, "bffcb1"));
                    break;
                case 54298166:
                    int i11 = f33 * (f30 + 7435);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-17, -60, -20, -64, -21, -106, -22, -112}, "4b7d01186b76dbad", 0));
                    break;
                case 54304002:
                    int i12 = f33 * (f30 + 4206);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-22, -112, -72, -90, -70, -63, -20, -88}, "14c9ae779b55b52e", 0.0f));
                    break;
                case 54332892:
                    int i13 = f33 * (f30 + 596);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-67, -110, -29, -107, -20, -109, -67, -88}, "f78077", 6));
                    break;
                case 54333723:
                    int i14 = f33 * (f30 + 4815);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-22, -110, -17, -107, -29, -107, -67, -62}, "164083fe162c", false));
                    break;
                case 54362655:
                    int i15 = f33 * (f30 | 2897);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-20, -106, -66, -108, -21, -86, -30, -111}, "71e50597"));
                    break;
                case 54363359:
                    int i16 = f33 * (f30 + 610);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-20, -63, -70, -100, -21, -110, -20, -99}, "7ca9077825"));
                    break;
                case 54389313:
                    if (hYNP32vq.m211() >= 0) {
                        return m172();
                    }
                    return null;
                case 54389462:
                    int i17 = f33 * (f30 ^ 3500);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-24, -60, -24, -103, -71, -110, -20, -59}, "3f39b47a337209", false));
                    break;
                case 54421174:
                    int i18 = f33 * (f30 + 5920);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-71, -112, -30, -108, -67, -112, -71, -89}, "b891f1", false));
                    break;
                case 54421299:
                    int i19 = f33 * (f30 | 6852);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-20, -102, -66, -112, -72, -59, -20, -104}, "78e8ce", 3));
                    break;
                case 54423003:
                    int i20 = f33 * (f30 | 4942);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-19, -99, -22, -107, -66, -112, -19, -107}, "6516e8", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤ۟ۧۥ, reason: not valid java name and contains not printable characters */
    public static String m161() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-24, -110, -18, -106, -66, -59, -65, -59}, "3053eeddf8d0", true));
        while (true) {
            switch (iM309) {
                case 54179135:
                    int i = f33 * (f30 ^ 2038);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-22, -60, -72, -63, -71, -110, -17, -61}, "1dceb54d3bfdd1", false));
                    break;
                case 54182785:
                    int i2 = f33 * (f30 | 7729);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-17, -97, -30, -106, -29, -106, -17, -97}, "479083", 0));
                    break;
                case 54183908:
                    int i3 = f33 * (f30 ^ 8039);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-71, -110, -17, -59, -21, -109, -67, -106}, "b34a00f056", 0));
                    break;
                case 54184618:
                    int i4 = f33 * (f30 | 4020);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-19, -109, -24, -83, -24, -104, -21, -100}, "63323004", 5));
                    break;
                case 54184680:
                    int i5 = f33 * (f30 + 4892);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-71, -64, -21, -103, -19, -5, -18, -64}, "bb096d5bbb", 6));
                    break;
                case 54209696:
                    int i6 = f33 * (f30 | 6143);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-20, -59, -72, -107, -24, -111, -22, -109}, "7dc33116dc", true));
                    break;
                case 54213574:
                    int i7 = f33 * (f30 ^ 7159);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-24, -58, -22, -64, -18, -57, -70, -105}, "3b1a5ca3b20e", 4));
                    break;
                case 54215402:
                    int i8 = f33 * (f30 + 5423);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-29, -59, -29, -59, -17, -107, -19, -106}, "8e8f47665489"));
                    break;
                case 54239393:
                    int i9 = f33 * (f30 | 7244);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-65, -60, -67, -87, -72, -58, -23, -112}, "dcf6ca2006", 3));
                    break;
                case 54241346:
                    int i10 = f33 * (f30 | 4087);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-18, -59, -71, -108, -20, -85, -70, -100}, "5eb174a834bdab"));
                    break;
                case 54244228:
                    int i11 = f33 * (f30 ^ 4886);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-72, -57, -30, -64, -30, -105, -71, -112}, "cb9a91b67cd285", false));
                    break;
                case 54275071:
                    if (hYNP32vq.m211() >= 0) {
                        return m168();
                    }
                    return null;
                case 54300093:
                    int i12 = f33 * (f30 + 5347);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-72, -105, -21, -109, -30, -107, -30, -4}, "c405969cc863"));
                    break;
                case 54301051:
                    int i13 = f33 * (f30 ^ 230);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-20, -57, -17, -110, -29, -58, -67, -5}, "7c468afdfbae3776", 0.0f));
                    break;
                case 54303064:
                    int i14 = f33 * (f30 | 1034);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-67, -64, -71, -63, -65, -61, -65, -112}, "fbbcdcd2"));
                    break;
                case 54329948:
                    int i15 = f33 * (f30 ^ 1581);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-17, -100, -70, -109, -66, -109, -17, -111}, "49a2e4", 0.0f));
                    break;
                case 54329981:
                    int i16 = f33 * (f30 ^ 3625);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-30, -61, -18, -88, -29, -106, -29, -108}, "9e57808633fbeb", 3));
                    break;
                case 54357813:
                    int i17 = f33 * (f30 | 3045);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-23, -55, -21, -58, -71, -63, -67, -59}, "2a0fbefef2"));
                    break;
                case 54387633:
                    int i18 = f33 * (f30 + 3100);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-67, -63, -65, -64, -19, -99, -23, -108}, "fedb69253d9138", 0.0f));
                    break;
                case 54387670:
                    int i19 = f33 * (f30 + 7267);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-72, -50, -18, -112, -29, -106, -71, -100}, "cf5386b84a", 3));
                    break;
                case 54418292:
                    int i20 = f33 * (f30 | 6713);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-70, -104, -23, -111, -72, -112, -24, -59}, "a921c23fc86a4d93", false));
                    break;
                case 54421055:
                    int i21 = f33 * (f30 + 3009);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-29, -59, -17, -109, -70, -57, -66, -107}, "8e46afe1"));
                    break;
                case 54424097:
                    int i22 = f33 * (f30 + 217);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-19, -108, -72, -83, -72, -54, -72, -107}, "63c2cbc34996"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۟ۤۦۧ, reason: not valid java name and contains not printable characters */
    public static Field m162(Object obj, Object obj2) {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-72, -104, -18, -110, -67, -112, -67, -63}, "c851f4fb", 7));
        while (true) {
            switch (iM336) {
                case 54151169:
                    int i = f33 * (f30 | 2590);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-18, -108, -65, -63, -17, -61, -67, -103}, "54dd4df80e9bf0d3", 0.0f));
                    break;
                case 54156807:
                    int i2 = f33 * (f30 + 5422);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-65, -104, -17, -112, -30, -62, -22, -107}, "d8449a1138700d6e"));
                    break;
                case 54179039:
                    int i3 = f33 * (f30 + 5960);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-19, -111, -17, -100, -66, -106, -23, -86}, "6749e22553", 0.0f));
                    break;
                case 54182850:
                    int i4 = f33 * (f30 ^ 5627);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-23, -109, -21, -58, -29, -64, -71, -60}, "260b8fbcdff9"));
                    break;
                case 54183781:
                    int i5 = f33 * (f30 + 5926);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-71, -61, -17, -86, -67, -64, -22, -58}, "bc45fe1c071278", true));
                    break;
                case 54183839:
                    int i6 = f33 * (f30 | 6639);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-18, -60, -17, -104, -67, -59, -23, -109}, "5e48fc25ed90", false));
                    break;
                case 54184863:
                    int i7 = f33 * (f30 + 3741);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-70, -64, -67, -109, -71, -100, -67, -106}, "aff6b4f5b3258e4d", true));
                    break;
                case 54209823:
                    int i8 = f33 * (f30 | 5506);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-17, -51, -20, -109, -71, -87, -65, -112}, "4e71b6d58a1734f5", 0.0f));
                    break;
                case 54238618:
                    int i9 = f33 * (f30 ^ 4581);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-72, -52, -72, -60, -17, -109, -67, -109}, "cdcd43f4", 3));
                    break;
                case 54240475:
                    int i10 = f33 * (f30 | 6547);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-24, -55, -17, -100, -21, -106, -66, -6}, "3a4401ee", 5));
                    break;
                case 54242274:
                    int i11 = f33 * (f30 ^ 241);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-22, -106, -30, -107, -65, -98, -29, -98}, "1593d886c0f528", 2));
                    break;
                case 54245435:
                    int i12 = f33 * (f30 | 7802);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-24, -112, -30, -105, -29, -109, -18, -107}, "38968456dee8fa8f", 5));
                    break;
                case 54275173:
                    int i13 = f33 * (f30 ^ 324);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-72, -109, -22, -60, -21, -111, -66, -97}, "c41d02e7", false));
                    break;
                case 54332832:
                    int i14 = f33 * (f30 + 6469);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-17, -53, -71, -83, -21, -58, -22, -108}, "4cb20d1676870f9d", 1));
                    break;
                case 54363514:
                    int i15 = f33 * (f30 ^ 3198);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-23, -57, -19, -64, -70, -5, -23, -59}, "2e6cad", 7));
                    break;
                case 54363642:
                    int i16 = f33 * (f30 ^ 5608);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-20, -109, -72, -109, -21, -63, -20, -89}, "71c20b781e", 0.0f));
                    break;
                case 54388478:
                    int i17 = f33 * (f30 | 6182);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-17, -5, -65, -109, -23, -60, -70, -105}, "4dd22aa30963", 0.0f));
                    break;
                case 54389374:
                    int i18 = f33 * (f30 ^ 5504);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-24, -101, -70, -4, -19, -107, -17, -109}, "39ac604182", 0.0f));
                    break;
                case 54417271:
                    int i19 = f33 * (f30 + 3776);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-21, -105, -67, -110, -65, -54, -71, -5}, "05f4dbbde9", false));
                    break;
                case 54418175:
                    if (hYNP32vq.m211() > 0) {
                        return ((Class) obj).getDeclaredField((String) obj2);
                    }
                    return null;
                case 54419349:
                    int i20 = f33 * (f30 ^ 1162);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-72, -5, -20, -60, -17, -111, -24, -60}, "cd7c403ddc7e"));
                    break;
                case 54420064:
                    int i21 = f33 * (f30 ^ 3460);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-24, -59, -29, -61, -18, -61, -71, -107}, "3b8b5bb0", true));
                    break;
                case 54426072:
                    int i22 = f33 * (f30 + 4845);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-29, -105, -30, -64, -71, -61, -19, -106}, "879dbf666b310165", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤۧۤۦ, reason: not valid java name and contains not printable characters */
    public static String m163() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-20, -108, -30, -104, -23, -111, -24, -62}, "7799253a96c84d64", 0.0f));
        while (true) {
            switch (iM336) {
                case 54149184:
                    int i = f33 * (f30 + 7330);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-29, -57, -66, -111, -24, -108, -71, -108}, "8ae034b1f1faadb9", 7));
                    break;
                case 54157962:
                    int i2 = f33 * (f30 | 3364);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-23, -63, -23, -104, -71, -103, -70, -112}, "2f28b1a287"));
                    break;
                case 54183810:
                    int i3 = f33 * (f30 + 1029);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-22, -98, -29, -108, -23, -104, -24, -98}, "18872939db62d739", false));
                    break;
                case 54187651:
                    int i4 = f33 * (f30 ^ 7905);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-17, -109, -24, -61, -20, -107, -17, -110}, "443e75", false));
                    break;
                case 54217415:
                    int i5 = f33 * (f30 ^ 5024);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-18, -111, -20, -109, -70, -111, -67, -105}, "5273a5f22764", false));
                    break;
                case 54239390:
                    int i6 = f33 * (f30 ^ 4284);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-22, -55, -22, -111, -29, -105, -19, -110}, "1a11826290a2"));
                    break;
                case 54269342:
                    int i7 = f33 * (f30 + 1478);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-24, -108, -70, -100, -70, -110, -65, -109}, "37a8a7d7b6", true));
                    break;
                case 54269463:
                    int i8 = f33 * (f30 | 5864);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-21, -108, -66, -109, -19, -61, -18, -111}, "00e06f50fbb3e2", true));
                    break;
                case 54270301:
                    int i9 = f33 * (f30 + 6329);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-19, -63, -23, -59, -17, -106, -70, -110}, "6f2f47a3a8d6eeeb"));
                    break;
                case 54273216:
                    int i10 = f33 * (f30 | 6393);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-30, -111, -29, -50, -67, -111, -65, -109}, "998ff4d3"));
                    break;
                case 54301925:
                    int i11 = f33 * (f30 + 7349);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-30, -63, -71, -106, -20, -107, -29, -63}, "9fb0748b0944c3", false));
                    break;
                case 54302043:
                    int i12 = f33 * (f30 + 4715);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-66, -110, -23, -57, -30, -99, -66, -110}, "e22c99e07aaea5", 0));
                    break;
                case 54333607:
                    int i13 = f33 * (f30 ^ 74);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-22, -87, -70, -53, -18, -61, -22, -98}, "16ac5d"));
                    break;
                case 54359552:
                    int i14 = f33 * (f30 ^ 5767);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-19, -61, -70, -101, -30, -110, -21, -62}, "6ba3910a72"));
                    break;
                case 54361507:
                    int i15 = f33 * (f30 ^ 6072);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-65, -58, -70, -104, -71, -82, -22, -4}, "dda8b11c77f9", 0.0f));
                    break;
                case 54388627:
                    int i16 = f33 * (f30 ^ 6921);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-72, -112, -17, -109, -19, -112, -72, -111}, "c34368", false));
                    break;
                case 54391292:
                    int i17 = f33 * (f30 ^ 942);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-65, -53, -66, -58, -22, -86, -65, -61}, "dcec15dd"));
                    break;
                case 54394149:
                    int i18 = f33 * (f30 | 5606);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-30, -105, -24, -107, -29, -111, -67, -58}, "923081faea67", true));
                    break;
                case 54394177:
                    if (hYNP32vq.m211() >= 0) {
                        return Build.PRODUCT;
                    }
                    return null;
                case 54418323:
                    int i19 = f33 * (f30 | 5246);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-18, -87, -18, -83, -71, -59, -21, -64}, "5652bf0c", 0.0f));
                    break;
                case 54422949:
                    int i20 = f33 * (f30 ^ 2830);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-30, -108, -20, -53, -71, -112, -30, -85}, "947cb4"));
                    break;
                case 54426011:
                    int i21 = f33 * (f30 + 5183);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-21, -64, -72, -108, -22, -105, -30, -109}, "0dc7169484a93010"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۥ۟ۢ۟, reason: not valid java name and contains not printable characters */
    public static int m164() {
        int iM343 = C0008.m343(C0010.decode(new byte[]{-21, -109, -22, -57, -24, -83, -23, -104}, "061c3229618c1cc6", 5));
        while (true) {
            switch (iM343) {
                case 54154111:
                    int i = f33 * (f30 | 5940);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-18, -107, -72, -108, -20, -111, -67, -108}, "51c672f129b402"));
                    break;
                case 54179938:
                    int i2 = f33 * (f30 | 1186);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-66, -64, -67, -64, -67, -112, -29, -84}, "eefff0838941", 4));
                    break;
                case 54180094:
                    int i3 = f33 * (f30 | 8125);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-72, -98, -22, -106, -20, -107, -29, -58}, "c817778de56400b7", 4));
                    break;
                case 54242555:
                    int i4 = f33 * (f30 + 3773);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-22, -61, -29, -99, -23, -110, -65, -111}, "1d8522d71f", 4));
                    break;
                case 54247334:
                    int i5 = f33 * (f30 | 5085);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-66, -59, -70, -62, -30, -101, -65, -100}, "eaae99d8", false));
                    break;
                case 54274026:
                    int i6 = f33 * (f30 | 3674);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-19, -110, -65, -109, -23, -108, -70, -61}, "62d327af", false));
                    break;
                case 54301024:
                    int i7 = f33 * (f30 | 4674);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-29, -110, -21, -7, -17, -104, -67, -86}, "850f40f5c12627f4"));
                    break;
                case 54301147:
                    int i8 = f33 * (f30 | 6432);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-65, -61, -30, -62, -21, -111, -66, -109}, "dc9b09e50dc823"));
                    break;
                case 54305797:
                    int i9 = f33 * (f30 | 471);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-72, -102, -18, -99, -65, -109, -29, -102}, "c958d382e1", 7));
                    break;
                case 54328981:
                    int i10 = f33 * (f30 ^ 3458);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-22, -54, -72, -52, -71, -58, -17, -102}, "1bcdbd49", 4));
                    break;
                case 54332609:
                    int i11 = f33 * (f30 + 2041);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-21, -111, -17, -60, -19, -57, -29, -90}, "074d6a8915cc60", 5));
                    break;
                case 54333819:
                    int i12 = f33 * (f30 + 3460);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-24, -105, -22, -57, -20, -108, -70, -64}, "331e73ad", 2));
                    break;
                case 54334560:
                    int i13 = f33 * (f30 ^ 3947);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-18, -105, -71, -112, -19, -106, -19, -107}, "52b56167bf2fb5", 0.0f));
                    break;
                case 54336730:
                    int i14 = 0;
                    int i15 = 0;
                    int i16 = 0;
                    int i17 = 0;
                    char c = 23820;
                    while (true) {
                        switch (c) {
                            case 39197:
                                int i18 = i17 + 79;
                                i17 = 533319100;
                                i14 ^= i15;
                                c = 23562;
                                break;
                            case 23820:
                                int i19 = i16 + 82;
                                i16 = 513506057;
                                i14 = 1235350307;
                                i15 = 1281442892;
                                c = 39197;
                                break;
                            case 7362:
                                i17 = (i17 % 38) | i16;
                                break;
                            case 23562:
                                return i14;
                        }
                    }
                    break;
                case 54358585:
                    int i20 = f33 * (f30 + 6509);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-21, -109, -70, -51, -66, -53, -67, -2}, "06aeecfaf932baae", 0.0f));
                    break;
                case 54358771:
                    int i21 = f33 * (f30 ^ 3336);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-30, -99, -66, -104, -70, -61, -17, -109}, "98e8ae4394", 7));
                    break;
                case 54359611:
                    int i22 = f33 * (f30 ^ 4512);
                    iM343 = C0000.m309(C0010.decode(new byte[]{-19, -63, -23, -61, -20, -106, -24, -64}, "6f2c733d9c"));
                    break;
                case 54363424:
                    int i23 = f33 * (f30 | 6621);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-30, -105, -18, -111, -66, -111, -30, -110}, "9559e6", false));
                    break;
                case 54387663:
                    int i24 = f33 * (f30 + 2840);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-70, -110, -71, -62, -71, -111, -21, -4}, "a4bbb10cd043e3a3", false));
                    break;
                case 54388536:
                    int i25 = f33 * (f30 + 5282);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-71, -57, -70, -111, -24, -50, -18, -64}, "bea23f5b", true));
                    break;
                case 54396071:
                    int i26 = f33 * (f30 + 1995);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-66, -88, -21, -108, -18, -59, -23, -62}, "e7005b2c8311", 0.0f));
                    break;
                case 54425921:
                    int i27 = f33 * (f30 ^ 7537);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-21, -108, -23, -99, -67, -107, -20, -60}, "0228f47f8d95", 2));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۥۧۡ, reason: not valid java name and contains not printable characters */
    public static String m165() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-23, -63, -19, -104, -17, -109, -21, -106}, "2f684207ffc41c", true));
        while (true) {
            switch (iM336) {
                case 54155850:
                    int i = f33 * (f30 + 5699);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-29, -109, -72, -63, -21, -60, -20, -64}, "86cf0d7adf9c", false));
                    break;
                case 54157993:
                    int i2 = f33 * (f30 + 4321);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-22, -107, -67, -103, -18, -110, -70, -106}, "11f855a2"));
                    break;
                case 54179813:
                    int i3 = f33 * (f30 + 6223);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-67, -112, -17, -64, -23, -109, -29, -59}, "f44e248c14bfc8"));
                    break;
                case 54185823:
                    int i4 = f33 * (f30 ^ 1881);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-71, -110, -65, -60, -17, -84, -29, -59}, "b2dd438a14f5cb0b", true));
                    break;
                case 54209855:
                    int i5 = f33 * (f30 | 6593);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-71, -62, -22, -63, -30, -62, -71, -59}, "bd1c9e", false));
                    break;
                case 54212733:
                    int i6 = f33 * (f30 | 7583);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-20, -60, -23, -97, -72, -107, -70, -59}, "7d29c2ae", true));
                    break;
                case 54215520:
                    int i7 = f33 * (f30 ^ 5251);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-18, -6, -20, -59, -22, -106, -21, -105}, "5e7c170383b6ea"));
                    break;
                case 54247207:
                    int i8 = f33 * (f30 + 1098);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-71, -106, -72, -111, -22, -59, -71, -82}, "b1c11e", true));
                    break;
                case 54268474:
                    int i9 = f33 * (f30 ^ 6420);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-21, -109, -71, -97, -22, -107, -19, -83}, "02b911626361", 2));
                    break;
                case 54270181:
                    int i10 = f33 * (f30 + 7260);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-20, -59, -18, -111, -70, -58, -18, -61}, "7c57ae5f8e85", 0.0f));
                    break;
                case 54274243:
                    int i11 = f33 * (f30 ^ 6310);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-21, -110, -23, -59, -21, -111, -22, -61}, "032e061d504c22d5", false));
                    break;
                case 54298019:
                    int i12 = f33 * (f30 ^ 2323);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-19, -110, -24, -110, -22, -60, -65, -51}, "61371cde", false));
                    break;
                case 54300186:
                    int i13 = f33 * (f30 + 4224);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-29, -100, -22, -3, -23, -6, -17, -111}, "881b2e46fe0c2ec8", true));
                    break;
                case 54304032:
                    int i14 = f33 * (f30 ^ 5662);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-21, -58, -30, -112, -70, -107, -24, -112}, "0d98a634d8"));
                    break;
                case 54305735:
                    int i15 = f33 * (f30 | 3459);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-30, -62, -65, -62, -20, -99, -71, -107}, "9eda78b1", 5));
                    break;
                case 54335523:
                    if (hYNP32vq.m211() > 0) {
                        return m184();
                    }
                    return null;
                case 54360726:
                    int i16 = f33 * (f30 | 2046);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-21, -112, -24, -99, -19, -110, -24, -107}, "06356336ca479a", false));
                    break;
                case 54364450:
                    int i17 = f33 * (f30 + 2060);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-22, -90, -19, -100, -23, -111, -20, -111}, "196429791b7d1905"));
                    break;
                case 54366308:
                    int i18 = f33 * (f30 + 5090);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-30, -106, -24, -111, -67, -63, -65, -106}, "9236fad209be79"));
                    break;
                case 54388376:
                    int i19 = f33 * (f30 + 1901);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-22, -110, -21, -59, -18, -110, -23, -58}, "110d522ad372", true));
                    break;
                case 54388409:
                    int i20 = f33 * (f30 + 7716);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-71, -64, -23, -108, -70, -105, -19, -111}, "ba27a063ed9c673d"));
                    break;
                case 54391419:
                    int i21 = f33 * (f30 ^ 9);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-19, -97, -66, -52, -29, -107, -23, -57}, "67ed872a3f25ab4c"));
                    break;
                case 54425924:
                    int i22 = f33 * (f30 ^ 7341);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-17, -64, -18, -2, -67, -98, -22, -105}, "4c5af912", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۦۥۤ, reason: not valid java name and contains not printable characters */
    public static String m166() {
        int iM349 = C0009.m349(C0010.decode(new byte[]{-23, -109, -17, -3, -71, -106, -23, -108}, "224bb5", true));
        while (true) {
            switch (iM349) {
                case 54150144:
                    int i = f33 * (f30 | 2927);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-66, -99, -18, -105, -23, -89, -30, -62}, "e550289d", 0.0f));
                    break;
                case 54179126:
                    int i2 = f33 * (f30 | 2980);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-29, -83, -65, -103, -71, -109, -66, -108}, "82d9b0e6cc5c78d9", true));
                    break;
                case 54182824:
                    int i3 = f33 * (f30 + 7212);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-30, -111, -19, -110, -18, -58, -30, -105}, "97645b", 0));
                    break;
                case 54184712:
                    int i4 = f33 * (f30 | 6343);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-66, -59, -18, -63, -19, -105, -18, -58}, "eb5d625e", 0.0f));
                    break;
                case 54208769:
                    int i5 = f33 * (f30 ^ 6752);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-65, -108, -65, -61, -29, -112, -30, -110}, "d5de8691", 0.0f));
                    break;
                case 54213662:
                    int i6 = f33 * (f30 | 7052);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-21, -112, -65, -7, -21, -98, -22, -104}, "06df0919a1d896", 0.0f));
                    break;
                case 54215586:
                    int i7 = f33 * (f30 | 8009);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-19, -57, -65, -107, -19, -87, -17, -110}, "6ad76644edc62845", false));
                    break;
                case 54216453:
                    int i8 = f33 * (f30 | 1145);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-72, -103, -71, -57, -67, -107, -71, -100}, "c9bdf6b404cc", false));
                    break;
                case 54243299:
                    int i9 = f33 * (f30 ^ 68);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-23, -103, -72, -5, -22, -54, -24, -86}, "29cd1b35119f", false));
                    break;
                case 54246117:
                    int i10 = f33 * (f30 | 7779);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-24, -109, -23, -109, -17, -57, -21, -83}, "31244b02a22c", 0.0f));
                    break;
                case 54246303:
                    if (yGhVwXcV.m266() < 0) {
                        return m183();
                    }
                    return null;
                case 54269249:
                    int i11 = f33 * (f30 ^ 1052);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-21, -59, -67, -99, -67, -111, -17, -106}, "0df9f7472d", true));
                    break;
                case 54269468:
                    int i12 = f33 * (f30 | 2653);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-65, -61, -72, -104, -65, -110, -24, -106}, "dfc9d634f98004ca", 0.0f));
                    break;
                case 54273151:
                    int i13 = f33 * (f30 | 8023);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-20, -110, -29, -104, -17, -108, -21, -58}, "7688420afcd1c14e", 0.0f));
                    break;
                case 54299197:
                    int i14 = f33 * (f30 | 7241);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-72, -59, -30, -63, -18, -63, -65, -61}, "ce9d5cdf0947"));
                    break;
                case 54329882:
                    int i15 = f33 * (f30 | 7956);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-72, -101, -65, -111, -65, -104, -72, -101}, "c9d5d9", false));
                    break;
                case 54357843:
                    int i16 = f33 * (f30 + 1872);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-19, -112, -20, -104, -67, -98, -29, -60}, "6378f68c75bf098c"));
                    break;
                case 54359701:
                    int i17 = f33 * (f30 | 5540);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-22, -106, -24, -62, -30, -112, -17, -58}, "173e934d55", 0.0f));
                    break;
                case 54360483:
                    int i18 = f33 * (f30 + 4480);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-19, -108, -30, -107, -21, -64, -65, -3}, "62940edb986278", 0.0f));
                    break;
                case 54364476:
                    int i19 = f33 * (f30 | 4742);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-24, -108, -65, -108, -22, -112, -67, -64}, "37d013fa", 6));
                    break;
                case 54387422:
                    int i20 = f33 * (f30 + 5911);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-20, -112, -72, -61, -72, -89, -21, -81}, "72cdc8005a", true));
                    break;
                case 54393340:
                    int i21 = f33 * (f30 | 7868);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-17, -64, -23, -103, -17, -62, -70, -110}, "4c294ca70b330b"));
                    break;
                case 54424870:
                    int i22 = f33 * (f30 | 7059);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-21, -62, -21, -83, -19, -111, -30, -112}, "0e026196c8e2bbbf", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۤۦ۟ۦۢ, reason: not valid java name and contains not printable characters */
    private static String m167() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-19, -107, -19, -110, -19, -58, -70, -59}, "64626eae", true));
        while (true) {
            switch (iM324) {
                case 54179134:
                    int i = f33 * (f30 | 2792);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-18, -106, -66, -4, -24, -86, -66, -107}, "55ec35e6b4", true));
                    break;
                case 54182947:
                    int i2 = f33 * (f30 | 3684);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-71, -110, -72, -111, -67, -57, -24, -107}, "b4c3fc320b938452"));
                    break;
                case 54183683:
                    int i3 = f33 * (f30 | 555);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-17, -111, -19, -88, -65, -110, -17, -105}, "4267d7", false));
                    break;
                case 54187503:
                    int i4 = f33 * (f30 | 5209);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-17, -98, -18, -110, -19, -64, -17, -87}, "46506c", true));
                    break;
                case 54187658:
                    int i5 = f33 * (f30 | 5924);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-70, -110, -24, -62, -29, -107, -24, -111}, "a53c80358ded2d", 6));
                    break;
                case 54209724:
                    int i6 = f33 * (f30 + 6120);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-24, -111, -20, -112, -66, -105, -19, -59}, "3373e56c", 0.0f));
                    break;
                case 54242373:
                    int i7 = f33 * (f30 + 5034);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-71, -107, -22, -103, -29, -106, -19, -64}, "b118806b1a3345", 7));
                    break;
                case 54244325:
                    int i8 = f33 * (f30 | 306);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-23, -102, -70, -58, -21, -108, -72, -112}, "22ac02c33a0d17"));
                    break;
                case 54268224:
                    return C0009.m350(f36, 39, 332468097 ^ C0007.f73, 19);
                case 54268412:
                    int i9 = f33 * (f30 + 4679);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-17, -60, -20, -90, -18, -98, -71, -64}, "4c7959bdcbd77a95"));
                    break;
                case 54269220:
                    int i10 = f33 * (f30 ^ 83);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-72, -59, -17, -105, -72, -107, -65, -60}, "ce44c2dce33e4a", 4));
                    break;
                case 54300153:
                    int i11 = f33 * (f30 | 6749);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-18, -61, -22, -64, -22, -64, -23, -63}, "5a1e1c2de779f7", 0.0f));
                    break;
                case 54360478:
                    int i12 = f33 * (f30 | 1759);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-67, -112, -67, -103, -17, -101, -24, -101}, "f7f84833d0c43dd3", 0.0f));
                    break;
                case 54360639:
                    int i13 = f33 * (f30 + 2520);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-67, -103, -70, -54, -18, -99, -19, -60}, "f9ab596b", 0.0f));
                    break;
                case 54366401:
                    int i14 = f33 * (f30 + 2329);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-70, -106, -29, -99, -66, -82, -70, -112}, "a685e1", true));
                    break;
                case 54387637:
                    int i15 = f33 * (f30 + 1715);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-23, -108, -19, -86, -70, -98, -24, -59}, "2465a63b5d72", true));
                    break;
                case 54389439:
                    int i16 = f33 * (f30 | 5433);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-20, -107, -72, -50, -71, -57, -21, -105}, "73cfbc04", 3));
                    break;
                case 54389497:
                    int i17 = f33 * (f30 | 3774);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-20, -64, -72, -61, -66, -85, -20, -57}, "7fcae4", 0.0f));
                    break;
                case 54420182:
                    int i18 = f33 * (f30 | 889);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-19, -103, -65, -64, -22, -106, -30, -87}, "69dd16969a9cfd"));
                    break;
                case 54423162:
                    int i19 = f33 * (f30 + 6893);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-30, -105, -72, -63, -17, -62, -71, -106}, "94ca4bb1"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۤ۟ۥۨۥ, reason: not valid java name and contains not printable characters */
    private static String m168() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-22, -61, -19, -110, -30, -112, -72, -110}, "1e6398c77c23", 0.0f));
        while (true) {
            switch (iM330) {
                case 54180002:
                    int i = f33 * (f30 + 8092);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-65, -103, -22, -54, -30, -58, -65, -97}, "d81b9c", 0.0f));
                    break;
                case 54181768:
                    int i2 = f33 * (f30 | 4005);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-67, -62, -67, -64, -18, -98, -17, -109}, "fbfc5843", 0.0f));
                    break;
                case 54181954:
                    return C0009.m350(f36, 7, 1440926440 ^ C0006.f71, 9);
                case 54182909:
                    int i3 = f33 * (f30 | 7545);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-65, -109, -23, -6, -66, -99, -65, -62}, "d22ee5de839477"));
                    break;
                case 54185609:
                    int i4 = f33 * (f30 | 5098);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-66, -60, -66, -61, -72, -109, -23, -83}, "eeefc522", 5));
                    break;
                case 54186725:
                    int i5 = f33 * (f30 | 433);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-24, -55, -22, -64, -22, -99, -17, -53}, "3a1b184cd2", false));
                    break;
                case 54208925:
                    int i6 = f33 * (f30 ^ 437);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-20, -110, -30, -106, -24, -62, -67, -98}, "77943bf606d1bd", 0.0f));
                    break;
                case 54214621:
                    int i7 = f33 * (f30 ^ 7981);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-21, -57, -24, -61, -20, -63, -23, -112}, "0a3f7a2401e3d01c"));
                    break;
                case 54214686:
                    int i8 = f33 * (f30 + 3570);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-17, -59, -66, -108, -72, -100, -23, -110}, "4ee3c921", true));
                    break;
                case 54215399:
                    int i9 = f33 * (f30 + 4423);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-21, -107, -17, -98, -30, -107, -30, -111}, "0548959280bd89", false));
                    break;
                case 54217481:
                    int i10 = f33 * (f30 ^ 5518);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-23, -57, -70, -57, -70, -58, -29, -54}, "2eacae8bde", 4));
                    break;
                case 54240513:
                    int i11 = f33 * (f30 ^ 7098);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-67, -100, -66, -110, -71, -109, -67, -104}, "f9e0b1", 0.0f));
                    break;
                case 54243367:
                    int i12 = f33 * (f30 | 194);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-30, -107, -20, -55, -21, -111, -71, -83}, "967a04b28405", 6));
                    break;
                case 54270182:
                    int i13 = f33 * (f30 ^ 7540);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-67, -108, -30, -57, -71, -107, -24, -60}, "f59ab53faf90ce", 0.0f));
                    break;
                case 54277055:
                    int i14 = f33 * (f30 + 1884);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-19, -112, -19, -59, -20, -108, -70, -52}, "636d74aded", true));
                    break;
                case 54302111:
                    int i15 = f33 * (f30 | 5693);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-66, -62, -17, -62, -22, -87, -17, -107}, "ed4b1641366f", true));
                    break;
                case 54306792:
                    int i16 = f33 * (f30 | 6120);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-18, -104, -66, -101, -19, -60, -18, -106}, "58e96d502f"));
                    break;
                case 54330725:
                    int i17 = f33 * (f30 ^ 3061);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-23, -107, -17, -102, -29, -106, -29, -112}, "2548808676ccd2"));
                    break;
                case 54330780:
                    int i18 = f33 * (f30 + 3973);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-24, -112, -23, -64, -23, -52, -20, -108}, "312e2d7679d66ac3", false));
                    break;
                case 54358559:
                    int i19 = f33 * (f30 | 2959);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-19, -109, -20, -64, -22, -57, -23, -111}, "617a1c2719cb80", 0.0f));
                    break;
                case 54359800:
                    int i20 = f33 * (f30 ^ 3021);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-19, -107, -24, -60, -67, -105, -19, -110}, "653df2"));
                    break;
                case 54363395:
                    int i21 = f33 * (f30 + 310);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-21, -111, -23, -110, -67, -112, -71, -108}, "0521f7b3ae", 0.0f));
                    break;
                case 54420253:
                    int i22 = f33 * (f30 | 5720);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-20, -108, -67, -51, -17, -108, -18, -108}, "70fe4753c413c529"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۦۧۧۥ۠, reason: not valid java name and contains not printable characters */
    private static String m169() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-65, -106, -22, -106, -70, -63, -24, -61}, "d511ac3b", true));
        while (true) {
            switch (iM324) {
                case 54155944:
                    int i = f33 * (f30 ^ 3470);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-19, -63, -72, -107, -72, -102, -72, -3}, "6ac1c9cb939def"));
                    break;
                case 54156808:
                    int i2 = f33 * (f30 + 4683);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-71, -61, -20, -61, -19, -58, -70, -112}, "ba7a6da88e66", 0.0f));
                    break;
                case 54157768:
                    int i3 = f33 * (f30 | 3604);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-66, -61, -23, -99, -30, -60, -19, -58}, "ec299d6fe2e8"));
                    break;
                case 54183684:
                    int i4 = f33 * (f30 + 3269);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-21, -106, -66, -111, -24, -110, -30, -110}, "00e03390e64a", 0));
                    break;
                case 54183776:
                    int i5 = f33 * (f30 + 4754);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-21, -58, -19, -64, -67, -58, -21, -105}, "0f6ffd050c", 1));
                    break;
                case 54185670:
                    int i6 = f33 * (f30 ^ 4448);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-70, -112, -19, -110, -71, -103, -20, -107}, "a763b87100333490", true));
                    break;
                case 54187752:
                    int i7 = f33 * (f30 + 4795);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-18, -108, -18, -106, -72, -55, -71, -85}, "5257cab425b6", true));
                    break;
                case 54210843:
                    int i8 = f33 * (f30 ^ 3938);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-71, -111, -30, -107, -17, -103, -67, -111}, "b69248f5d4ee", true));
                    break;
                case 54215621:
                    int i9 = f33 * (f30 | 3606);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-30, -110, -66, -112, -65, -55, -65, -110}, "93e1dad13614", 6));
                    break;
                case 54241414:
                    int i10 = f33 * (f30 + 632);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-23, -57, -22, -64, -24, -106, -21, -3}, "2c1d350be8f71f"));
                    break;
                case 54276003:
                    int i11 = f33 * (f30 ^ 3608);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-29, -99, -21, -62, -18, -97, -17, -109}, "890b5844", 0.0f));
                    break;
                case 54299228:
                    int i12 = f33 * (f30 + 6533);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-70, -64, -70, -107, -66, -102, -70, -106}, "afa3e2a59572", 6));
                    break;
                case 54302817:
                    int i13 = f33 * (f30 | 25);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-22, -2, -21, -111, -23, -58, -70, -60}, "1a072baa7785619d"));
                    break;
                case 54302940:
                    int i14 = f33 * (f30 ^ 4273);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-17, -106, -24, -97, -65, -57, -29, -54}, "4139dd8bb01cd5"));
                    break;
                case 54329821:
                    int i15 = f33 * (f30 + 1841);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-17, -64, -20, -106, -19, -110, -22, -110}, "4a706515d3"));
                    break;
                case 54359580:
                    int i16 = f33 * (f30 + 165);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-23, -7, -65, -108, -19, -103, -18, -61}, "2fd3685b14de", 0.0f));
                    break;
                case 54359794:
                    int i17 = f33 * (f30 ^ 7666);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-70, -61, -71, -57, -22, -64, -20, -102}, "afbf1b794d", 0.0f));
                    break;
                case 54364603:
                    int i18 = f33 * (f30 + 3338);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-21, -81, -30, -101, -30, -104, -21, -112}, "009399", 0.0f));
                    break;
                case 54389373:
                    int i19 = f33 * (f30 + 2702);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-20, -62, -66, -53, -29, -108, -72, -112}, "7bec83c7198d75"));
                    break;
                case 54394244:
                    int i20 = f33 * (f30 | 6888);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-20, -109, -70, -108, -67, -84, -66, -112}, "77a0f3e06d97"));
                    break;
                case 54395139:
                    return C0009.m350(f36, 94, 1057807544 ^ C0000.f59, 7);
            }
        }
    }

    /* JADX INFO: renamed from: ۣۢ۠۟, reason: not valid java name and contains not printable characters */
    public static String m170(short[] sArr, int i, int i2, int i3) {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-20, -82, -70, -112, -65, -2, -20, -82}, "71a4da", true));
        while (true) {
            switch (iM330) {
                case 54151010:
                    int i4 = f33 * (f30 | 1799);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-24, -111, -71, -99, -17, -62, -65, -110}, "31b94fd3640c7734", 2));
                    break;
                case 54151263:
                    char[] cArr = new char[i2];
                    for (int i5 = 0; i5 < i2; i5++) {
                        cArr[i5] = (char) (sArr[i + i5] ^ i3);
                    }
                    return new String(cArr);
                case 54153861:
                    int i6 = f33 * (f30 + 1797);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-21, -97, -29, -109, -70, -58, -21, -111}, "0784ad", 0.0f));
                    break;
                case 54183809:
                    int i7 = f33 * (f30 | 4316);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-70, -110, -29, -58, -71, -100, -30, -59}, "a58eb89e", 4));
                    break;
                case 54208801:
                    int i8 = f33 * (f30 + 5520);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-66, -61, -21, -61, -29, -110, -30, -105}, "ed0f8694", false));
                    break;
                case 54211552:
                    int i9 = f33 * (f30 ^ 7661);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-66, -101, -67, -57, -21, -89, -65, -51}, "e3fb08de0972"));
                    break;
                case 54211584:
                    int i10 = f33 * (f30 ^ 7384);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-70, -58, -70, -102, -30, -61, -70, -58}, "aba99d"));
                    break;
                case 54300127:
                    int i11 = f33 * (f30 + 4763);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-21, -112, -29, -97, -22, -111, -21, -112}, "068912", 0.0f));
                    break;
                case 54302108:
                    int i12 = f33 * (f30 | 531);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-19, -108, -29, -111, -23, -110, -24, -60}, "6080273cce", true));
                    break;
                case 54303874:
                    int i13 = f33 * (f30 | 6327);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-72, -57, -22, -61, -23, -59, -19, -6}, "cf1a2e6e", true));
                    break;
                case 54358774:
                    int i14 = f33 * (f30 ^ 7505);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-70, -83, -20, -110, -23, -61, -19, -103}, "a2732c69", 0.0f));
                    break;
                case 54360693:
                    int i15 = f33 * (f30 ^ 6759);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-18, -59, -19, -60, -23, -112, -66, -63}, "5b6a21ed", 0.0f));
                    break;
                case 54362462:
                    int i16 = f33 * (f30 ^ 2970);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-19, -5, -24, -60, -29, -97, -65, -99}, "6d3e87d8406d"));
                    break;
                case 54364356:
                    int i17 = f33 * (f30 ^ 5024);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-66, -105, -22, -61, -67, -110, -70, -107}, "e31ff0a650b357", false));
                    break;
                case 54364451:
                    int i18 = f33 * (f30 + 8057);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-30, -64, -18, -58, -70, -57, -24, -58}, "9f5faa3deafe4c", 0.0f));
                    break;
                case 54391384:
                    int i19 = f33 * (f30 ^ 1818);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-65, -62, -18, -7, -17, -109, -72, -58}, "dc5f47cacd05", 4));
                    break;
                case 54393218:
                    int i20 = f33 * (f30 | 1915);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-30, -59, -66, -106, -17, -61, -30, -57}, "9ce04c", 1));
                    break;
                case 54393309:
                    int i21 = f33 * (f30 | 2189);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-72, -62, -21, -110, -71, -104, -24, -62}, "cd06b93cbbe365"));
                    break;
                case 54422950:
                    int i22 = f33 * (f30 ^ 6021);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-19, -110, -30, -106, -29, -104, -66, -110}, "639489e2c57d", true));
                    break;
                case 54424963:
                    int i23 = f33 * (f30 + 4409);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-67, -111, -72, -105, -65, -110, -20, -3}, "f7c5d47bcce3ab0b", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢ۠ۡۨ, reason: not valid java name and contains not printable characters */
    public static String m171() {
        int iM349 = C0009.m349(C0010.decode(new byte[]{-23, -57, -30, -104, -70, -53, -67, -63}, "2a99acfe0ed959", 0));
        while (true) {
            switch (iM349) {
                case 54180089:
                    int i = f33 * (f30 ^ 7201);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-70, -107, -24, -106, -72, -88, -22, -98}, "a136c719539b"));
                    break;
                case 54182946:
                    if (m156() <= 0) {
                        return m180();
                    }
                    return null;
                case 54183931:
                    int i2 = f33 * (f30 | 1208);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-71, -103, -24, -111, -23, -60, -71, -59}, "b1302fbed6d616c5", 1));
                    break;
                case 54184776:
                    int i3 = f33 * (f30 + 1059);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-18, -61, -67, -105, -22, -64, -72, -106}, "5ff11ac4b0a36e71", 3));
                    break;
                case 54212547:
                    int i4 = f33 * (f30 | 7594);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-20, -64, -66, -63, -20, -89, -21, -60}, "7eea780d5a74f9", 0.0f));
                    break;
                case 54241382:
                    int i5 = f33 * (f30 | 6586);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-29, -106, -29, -64, -66, -61, -67, -58}, "808dedfe2c7628"));
                    break;
                case 54243267:
                    int i6 = f33 * (f30 + 6062);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-19, -105, -71, -108, -67, -111, -18, -98}, "67b7f658", 0.0f));
                    break;
                case 54272285:
                    int i7 = f33 * (f30 | 8028);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-23, -60, -21, -110, -65, -112, -23, -53}, "2c07d7", 0.0f));
                    break;
                case 54298980:
                    int i8 = f33 * (f30 + 6005);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-66, -110, -71, -58, -29, -107, -65, -61}, "e4ba86de83", 6));
                    break;
                case 54304957:
                    int i9 = f33 * (f30 | 114);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-17, -60, -66, -6, -67, -102, -17, -2}, "4aeef9", 0.0f));
                    break;
                case 54327926:
                    int i10 = f33 * (f30 + 6237);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-24, -108, -67, -112, -22, -61, -21, -108}, "33f21c07db"));
                    break;
                case 54328764:
                    int i11 = f33 * (f30 + 6445);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-21, -63, -29, -99, -71, -110, -21, -62}, "0c89b2", true));
                    break;
                case 54334594:
                    int i12 = f33 * (f30 + 3588);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-22, -105, -29, -59, -29, -112, -17, -87}, "178a8846a5b04748", false));
                    break;
                case 54336646:
                    int i13 = f33 * (f30 + 4981);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-65, -62, -29, -108, -72, -54, -22, -57}, "db84cb1f26", false));
                    break;
                case 54357846:
                    int i14 = f33 * (f30 | 3429);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-20, -100, -71, -55, -67, -60, -21, -51}, "79bafa0e64b7", 4));
                    break;
                case 54359799:
                    int i15 = f33 * (f30 | 5288);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-66, -59, -29, -64, -65, -108, -29, -109}, "ea8fd28208"));
                    break;
                case 54362650:
                    int i16 = f33 * (f30 + 422);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-24, -59, -71, -107, -70, -59, -20, -107}, "3eb0aa72", 0.0f));
                    break;
                case 54365412:
                    int i17 = f33 * (f30 + 6128);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-23, -101, -66, -58, -30, -110, -72, -59}, "28ee94cf8814"));
                    break;
                case 54390302:
                    int i18 = f33 * (f30 | 2683);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-21, -61, -65, -81, -66, -106, -21, -63}, "0ed0e1", 7));
                    break;
                case 54393407:
                    int i19 = f33 * (f30 + 2530);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-19, -107, -19, -109, -23, -106, -29, -112}, "67612787070722c4", false));
                    break;
                case 54419191:
                    int i20 = f33 * (f30 | 6612);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-66, -111, -17, -58, -70, -106, -29, -57}, "e04ea78e75a883", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۡۤۧ۠ۧ, reason: not valid java name and contains not printable characters */
    private static String m172() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-24, -109, -72, -60, -65, -97, -70, -105}, "34cdd7a63fc1d399", false));
        while (true) {
            switch (iM324) {
                case 54153925:
                    int i = f33 * (f30 ^ 4937);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-23, -110, -19, -105, -71, -106, -19, -106}, "2163b7633336", 0.0f));
                    break;
                case 54157001:
                    int i2 = f33 * (f30 + 1491);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-70, -64, -23, -103, -70, -105, -17, -86}, "ae28a145c8c54819", true));
                    break;
                case 54180867:
                    return C0009.m350(f36, 0, 1075935260 ^ C0000.f59, 7);
                case 54182972:
                    int i3 = f33 * (f30 + 2004);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-70, -107, -20, -58, -29, -64, -20, -57}, "a67d8b7a3f", 1));
                    break;
                case 54184900:
                    int i4 = f33 * (f30 + 5012);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-20, -59, -24, -60, -66, -61, -20, -59}, "7b3beb"));
                    break;
                case 54209723:
                    int i5 = f33 * (f30 ^ 4900);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-65, -64, -30, -107, -65, -105, -65, -51}, "de93d3"));
                    break;
                case 54214592:
                    int i6 = f33 * (f30 ^ 6871);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-17, -108, -23, -58, -66, -57, -17, -112}, "412cec41e317"));
                    break;
                case 54243303:
                    int i7 = f33 * (f30 + 7085);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-67, -108, -17, -112, -21, -64, -18, -106}, "f5450e576081e0", 0.0f));
                    break;
                case 54245159:
                    int i8 = f33 * (f30 + 6620);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-30, -105, -65, -108, -17, -104, -23, -97}, "95d049297f4080", 0.0f));
                    break;
                case 54245253:
                    int i9 = f33 * (f30 | 3732);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-67, -108, -24, -102, -17, -97, -70, -104}, "f03248a0", true));
                    break;
                case 54271203:
                    int i10 = f33 * (f30 + 3927);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-30, -81, -21, -98, -70, -59, -17, -99}, "9009ab458d", 0.0f));
                    break;
                case 54273093:
                    int i11 = f33 * (f30 + 8144);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-67, -59, -30, -62, -20, -60, -30, -58}, "fe9c7f9b26", true));
                    break;
                case 54306917:
                    int i12 = f33 * (f30 | 70);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-65, -108, -22, -108, -18, -112, -66, -112}, "d31651e5993f3283", 0.0f));
                    break;
                case 54329941:
                    int i13 = f33 * (f30 | 1949);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-23, -58, -21, -64, -21, -101, -66, -62}, "2f0e03ee775580", 0.0f));
                    break;
                case 54333725:
                    int i14 = f33 * (f30 ^ 3016);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-29, -62, -66, -105, -71, -109, -67, -7}, "8ce7b0ff49", false));
                    break;
                case 54334693:
                    int i15 = f33 * (f30 | 3740);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-20, -108, -24, -102, -72, -54, -72, -109}, "7439cbc2ac6e1f10", 2));
                    break;
                case 54388626:
                    int i16 = f33 * (f30 + 5014);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-71, -110, -19, -108, -17, -82, -22, -111}, "b06241136cc477", 1));
                    break;
                case 54390335:
                    int i17 = f33 * (f30 ^ 520);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-29, -97, -20, -111, -21, -63, -29, -112}, "87730a816e4a84", 0.0f));
                    break;
                case 54394181:
                    int i18 = f33 * (f30 + 2864);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-21, -112, -19, -109, -67, -57, -29, -108}, "0265fe8715", 7));
                    break;
                case 54420091:
                    int i19 = f33 * (f30 | 3040);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-19, -84, -20, -100, -72, -60, -24, -64}, "6378ce3a5f855b"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۤ۠ۢۧ, reason: not valid java name and contains not printable characters */
    public static int m173() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-67, -106, -24, -109, -67, -110, -66, -62}, "f131f5efbb", false));
        while (true) {
            switch (iM316) {
                case 54186788:
                    int i = f33 * (f30 | 7861);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-22, -63, -70, -61, -24, -111, -22, -57}, "1fac39"));
                    break;
                case 54187620:
                    int i2 = f33 * (f30 ^ 824);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-65, -112, -30, -107, -67, -87, -22, -61}, "d896f61b148f", 0.0f));
                    break;
                case 54209633:
                    int i3 = f33 * (f30 + 1209);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-67, -57, -70, -111, -19, -109, -67, -58}, "fca960"));
                    break;
                case 54246397:
                    int i4 = f33 * (f30 ^ 805);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-65, -112, -66, -97, -65, -103, -65, -102}, "d2e7d1", false));
                    break;
                case 54247366:
                    int i5 = f33 * (f30 ^ 3622);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-24, -111, -17, -111, -24, -63, -17, -107}, "31463f41e5a7767c", 4));
                    break;
                case 54271106:
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    char c = 30267;
                    while (true) {
                        switch (c) {
                            case 7078:
                                return i6;
                            case 39515:
                                int i9 = 557127678 + 19;
                                i8 = (i8 % 11) % 38;
                                break;
                            case 30267:
                                int i10 = i8 | i8;
                                i8 = i10 & i10;
                                i6 = 2020509621;
                                i7 = 1624930762;
                                c = 53546;
                                break;
                            case 53546:
                                i8 += 31;
                                i6 ^= i7;
                                c = 7078;
                                break;
                        }
                    }
                    break;
                case 54271351:
                    int i11 = f33 * (f30 ^ 6062);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-19, -59, -71, -60, -67, -5, -17, -111}, "6fbffd43298cd2", 0.0f));
                    break;
                case 54274956:
                    int i12 = f33 * (f30 | 7693);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-23, -105, -70, -5, -19, -2, -22, -58}, "21ad6a1d", false));
                    break;
                case 54298113:
                    int i13 = f33 * (f30 ^ 1042);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-72, -110, -19, -110, -66, -110, -17, -82}, "c160e54174", 6));
                    break;
                case 54298233:
                    int i14 = f33 * (f30 + 3969);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-17, -102, -20, -109, -66, -51, -17, -104}, "4874ee"));
                    break;
                case 54300964:
                    int i15 = f33 * (f30 + 7951);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-19, -105, -19, -111, -24, -61, -30, -106}, "60663e91b59b"));
                    break;
                case 54306790:
                    int i16 = f33 * (f30 | 5178);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-71, -54, -19, -111, -23, -52, -67, -64}, "bb612dfe", 0.0f));
                    break;
                case 54327901:
                    int i17 = f33 * (f30 ^ 5828);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-66, -100, -65, -108, -66, -55, -66, -112}, "e4d1eae4324204a2", false));
                    break;
                case 54329945:
                    int i18 = f33 * (f30 + 5107);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-23, -106, -18, -107, -22, -64, -24, -108}, "22571a33", 0.0f));
                    break;
                case 54333699:
                    int i19 = f33 * (f30 | 5760);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-21, -106, -72, -112, -20, -105, -19, -61}, "07c0776a11b707", 0.0f));
                    break;
                case 54357596:
                    int i20 = f33 * (f30 + 1818);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-29, -61, -24, -107, -17, -98, -29, -59}, "8f3448"));
                    break;
                case 54388626:
                    int i21 = f33 * (f30 + 7998);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-30, -62, -21, -106, -24, -86, -21, -52}, "9a00350d8d10d3c2"));
                    break;
                case 54389402:
                    int i22 = f33 * (f30 | 2953);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-71, -58, -67, -6, -17, -63, -18, -99}, "bbfe4c55ec6e", false));
                    break;
                case 54390520:
                    int i23 = f33 * (f30 + 7293);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-65, -62, -20, -4, -66, -109, -66, -58}, "df7ce5eb2e3b80", 0.0f));
                    break;
                case 54395297:
                    int i24 = f33 * (f30 + 2298);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-21, -106, -18, -111, -19, -59, -67, -57}, "03546ffa948b", 0.0f));
                    break;
                case 54418421:
                    int i25 = f33 * (f30 + 3362);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-18, -106, -70, -55, -17, -112, -24, -6}, "56aa433e237fac", 6));
                    break;
                case 54421021:
                    int i26 = f33 * (f30 + 66);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-19, -105, -20, -87, -71, -57, -22, -112}, "6276be15e46119"));
                    break;
                case 54423225:
                    int i27 = f33 * (f30 | 2028);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-23, -110, -29, -59, -20, -110, -20, -107}, "258d70777c"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۨۥۤۥ, reason: not valid java name and contains not printable characters */
    public static int m174() {
        int iM343 = C0008.m343(C0010.decode(new byte[]{-17, -112, -24, -111, -21, -63, -17, -110}, "40350b", false));
        while (true) {
            switch (iM343) {
                case 54150174:
                    int i = f33 * (f30 + 1725);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-21, -106, -18, -58, -21, -107, -70, -55}, "075d02aaf8b06f", 3));
                    break;
                case 54155047:
                    int i2 = f33 * (f30 | 2349);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-24, -62, -19, -106, -17, -106, -24, -60}, "3a6746", 4));
                    break;
                case 54157959:
                    int i3 = f33 * (f30 + 1258);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-17, -102, -65, -97, -22, -86, -22, -105}, "49d715104fc0", 0.0f));
                    break;
                case 54183779:
                    int i4 = f33 * (f30 | 2137);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-65, -4, -66, -103, -21, -111, -24, -109}, "dce905324a95"));
                    break;
                case 54211714:
                    int i5 = f33 * (f30 | 1243);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-20, -101, -20, -59, -30, -90, -65, -110}, "787b99d4"));
                    break;
                case 54211778:
                    int i6 = f33 * (f30 | 1773);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-19, -111, -70, -101, -30, -103, -30, -64}, "69a9919de987", true));
                    break;
                case 54214501:
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    char c = 16343;
                    while (true) {
                        switch (c) {
                            case 47716:
                                i9 %= 63;
                                i7 ^= i8;
                                c = 5377;
                                break;
                            case 5377:
                                return i7;
                            case 16343:
                                i9 += 31;
                                i7 = 185148715;
                                i8 = 1979992758;
                                c = 47716;
                                break;
                            case 22690:
                                i10 <<= 825962946;
                                i9 = 825962946 % 46;
                                break;
                        }
                    }
                    break;
                case 54270179:
                    int i11 = f33 * (f30 | 7671);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-21, -110, -71, -58, -30, -110, -70, -111}, "04bb91a7eb", 0.0f));
                    break;
                case 54275915:
                    int i12 = f33 * (f30 | 8168);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-24, -62, -24, -100, -65, -52, -24, -62}, "3d39dd", false));
                    break;
                case 54276877:
                    int i13 = f33 * (f30 + 5868);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-71, -57, -24, -107, -29, -110, -20, -111}, "bc308475aa931905", 1));
                    break;
                case 54300095:
                    int i14 = f33 * (f30 + 2595);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-17, -6, -67, -63, -20, -109, -22, -106}, "4efd7511", 1));
                    break;
                case 54303999:
                    int i15 = f33 * (f30 ^ 6188);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-29, -110, -22, -64, -24, -101, -66, -108}, "871f38e727", true));
                    break;
                case 54334657:
                    int i16 = f33 * (f30 | 2756);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-72, -108, -72, -107, -70, -62, -24, -59}, "c0c4af3cc5fb17f4"));
                    break;
                case 54360763:
                    int i17 = f33 * (f30 + 1090);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-71, -63, -71, -105, -20, -100, -67, -57}, "bfb178fe33a7341a", 3));
                    break;
                case 54362529:
                    int i18 = f33 * (f30 | 6262);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-22, -60, -66, -111, -70, -104, -22, -59}, "1be3a0"));
                    break;
                case 54362615:
                    int i19 = f33 * (f30 + 3185);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-70, -112, -23, -55, -30, -57, -70, -109}, "a72a9b", true));
                    break;
                case 54363458:
                    int i20 = f33 * (f30 + 3382);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-67, -105, -23, -63, -71, -63, -67, -111}, "f62cbdf7523f49", true));
                    break;
                case 54363645:
                    int i21 = f33 * (f30 + 5274);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-30, -81, -22, -101, -70, -106, -21, -109}, "9013a1065d81", 1));
                    break;
                case 54394269:
                    int i22 = f33 * (f30 | 1410);
                    iM343 = C0000.m309(C0010.decode(new byte[]{-22, -64, -67, -64, -71, -62, -30, -89}, "1ffdbd98a7d97e", false));
                    break;
                case 54396224:
                    int i23 = f33 * (f30 + 122);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-70, -104, -65, -110, -21, -101, -29, -106}, "a9d709853d", 5));
                    break;
                case 54417272:
                    int i24 = f33 * (f30 ^ 5687);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-65, -61, -22, -111, -72, -110, -23, -99}, "de14c028", 0.0f));
                    break;
                case 54420342:
                    int i25 = f33 * (f30 ^ 1236);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-70, -100, -24, -6, -21, -107, -19, -105}, "a43e07647f", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۥۨۨ, reason: not valid java name and contains not printable characters */
    public static String m175() {
        int iM349 = C0009.m349(C0010.decode(new byte[]{-29, -100, -24, -108, -19, -50, -30, -53}, "88366f9c", 0.0f));
        while (true) {
            switch (iM349) {
                case 54151196:
                    if (OUHQwdrD.m42() < 0) {
                        return m167();
                    }
                    return null;
                case 54151945:
                    int i = f33 * (f30 | 6494);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-20, -109, -66, -105, -24, -111, -30, -109}, "71e035953b"));
                    break;
                case 54154887:
                    int i2 = f33 * (f30 ^ 4272);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-17, -59, -24, -100, -30, -105, -30, -107}, "4b38979387"));
                    break;
                case 54180900:
                    int i3 = f33 * (f30 | 912);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-29, -58, -20, -64, -66, -111, -29, -61}, "8e7be0", 3));
                    break;
                case 54182941:
                    int i4 = f33 * (f30 ^ 3541);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-22, -110, -72, -62, -65, -64, -30, -110}, "13cedc93d2", 0.0f));
                    break;
                case 54183874:
                    int i5 = f33 * (f30 + 2155);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-29, -60, -66, -106, -72, -62, -29, -59}, "8de5ce"));
                    break;
                case 54184892:
                    int i6 = f33 * (f30 | 1416);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-21, -57, -23, -62, -30, -97, -67, -108}, "0e2e98f7d8d348", 3));
                    break;
                case 54211769:
                    int i7 = f33 * (f30 | 5375);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-23, -81, -29, -99, -19, -107, -30, -108}, "20886496aa53", true));
                    break;
                case 54216452:
                    int i8 = f33 * (f30 + 4435);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-17, -61, -67, -105, -71, -61, -17, -57}, "4af6bd"));
                    break;
                case 54240606:
                    int i9 = f33 * (f30 ^ 2523);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-29, -110, -30, -59, -20, -108, -20, -59}, "829d777c", false));
                    break;
                case 54243429:
                    int i10 = f33 * (f30 | 3376);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-29, -103, -29, -110, -22, -64, -29, -106}, "81821f81c4", 3));
                    break;
                case 54244203:
                    int i11 = f33 * (f30 ^ 4186);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-70, -7, -30, -111, -66, -86, -66, -109}, "af93e5e65d", true));
                    break;
                case 54246279:
                    int i12 = f33 * (f30 ^ 1687);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-70, -112, -30, -3, -67, -106, -29, -110}, "a79bf68283145018", 6));
                    break;
                case 54246369:
                    int i13 = f33 * (f30 + 1147);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-21, -112, -71, -58, -65, -109, -66, -101}, "02bbd6e333b53bd6", 0.0f));
                    break;
                case 54271172:
                    int i14 = f33 * (f30 + 4698);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-18, -62, -30, -110, -72, -111, -18, -4}, "5c90c6", 0.0f));
                    break;
                case 54301182:
                    int i15 = f33 * (f30 | 6350);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-24, -108, -22, -111, -17, -50, -24, -85}, "34144f"));
                    break;
                case 54357781:
                    int i16 = f33 * (f30 ^ 710);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-71, -98, -18, -106, -71, -63, -66, -97}, "b652bae950b04e", 0.0f));
                    break;
                case 54387416:
                    int i17 = f33 * (f30 ^ 2026);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-20, -99, -23, -111, -24, -107, -19, -57}, "7521346a3d4d0f", 1));
                    break;
                case 54392227:
                    int i18 = f33 * (f30 | 310);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-24, -110, -66, -105, -21, -7, -71, -110}, "30e20fb571d8d8", true));
                    break;
                case 54418205:
                    int i19 = f33 * (f30 + 7781);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-66, -54, -24, -109, -30, -60, -23, -108}, "eb309c26a7", 0.0f));
                    break;
                case 54418361:
                    int i20 = f33 * (f30 + 3546);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-18, -57, -30, -89, -20, -61, -70, -60}, "5a987fae"));
                    break;
                case 54421270:
                    int i21 = f33 * (f30 | 5958);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-19, -87, -65, -59, -71, -59, -72, -62}, "66ddbccbdd", 0.0f));
                    break;
                case 54422018:
                    int i22 = f33 * (f30 + 6987);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-17, -109, -71, -112, -29, -62, -17, -109}, "43b48d47"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۨۨ۟, reason: not valid java name and contains not printable characters */
    public static String m176() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-21, -105, -19, -102, -30, -50, -19, -107}, "03699f61fbb5", 0.0f));
        while (true) {
            switch (iM324) {
                case 54151199:
                    int i = f33 * (f30 ^ 7674);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-24, -64, -72, -105, -71, -112, -21, -102}, "3bc4b4086dcfb2b1", true));
                    break;
                case 54152161:
                    int i2 = f33 * (f30 ^ 5350);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-72, -60, -65, -100, -21, -61, -72, -62}, "cdd40d", 3));
                    break;
                case 54153033:
                    int i3 = f33 * (f30 ^ 4841);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-70, -105, -22, -51, -65, -110, -70, -108}, "a71ed4", 7));
                    break;
                case 54157959:
                    int i4 = f33 * (f30 ^ 6688);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-72, -111, -72, -107, -66, -97, -30, -109}, "c2c7e896c2", 0.0f));
                    break;
                case 54180926:
                    int i5 = f33 * (f30 ^ 1283);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-20, -104, -18, -109, -21, -108, -21, -111}, "70510606935c39"));
                    break;
                case 54184679:
                    int i6 = f33 * (f30 | 7674);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-66, -63, -20, -60, -21, -61, -67, -58}, "ec7f0afd54fb", 3));
                    break;
                case 54187717:
                    int i7 = f33 * (f30 + 222);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-29, -51, -17, -110, -71, -62, -66, -58}, "8e44baed7db95d"));
                    break;
                case 54187751:
                    int i8 = f33 * (f30 + 4475);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-23, -110, -66, -103, -19, -57, -71, -110}, "26e96db1d9", true));
                    break;
                case 54211744:
                    if (yGhVwXcV.m266() < 0) {
                        return m188();
                    }
                    return null;
                case 54212672:
                    int i9 = f33 * (f30 | 2486);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-70, -101, -70, -61, -24, -58, -22, -58}, "a9ac3d1f77", 0.0f));
                    break;
                case 54239484:
                    int i10 = f33 * (f30 ^ 3143);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-21, -63, -24, -112, -17, -63, -65, -7}, "0f304edfabe8", 3));
                    break;
                case 54241408:
                    int i11 = f33 * (f30 + 3938);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-65, -64, -71, -62, -18, -112, -18, -62}, "daba555aed4782", 7));
                    break;
                case 54242431:
                    int i12 = f33 * (f30 + 7896);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-22, -61, -20, -63, -21, -112, -29, -112}, "1f7a0888b6b1cf"));
                    break;
                case 54271357:
                    int i13 = f33 * (f30 | 473);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-67, -109, -24, -103, -70, -106, -67, -59}, "f338a2fdaf55897f"));
                    break;
                case 54299100:
                    int i14 = f33 * (f30 | 6849);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-71, -6, -18, -102, -29, -60, -65, -60}, "be528cdafad0c3", true));
                    break;
                case 54302139:
                    int i15 = f33 * (f30 ^ 2029);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-66, -4, -23, -60, -66, -105, -22, -57}, "ec2ee11dbdb279", 0.0f));
                    break;
                case 54329051:
                    int i16 = f33 * (f30 ^ 1715);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-23, -82, -20, -102, -29, -98, -22, -108}, "2178881079515891", false));
                    break;
                case 54388500:
                    int i17 = f33 * (f30 | 1174);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-65, -108, -65, -63, -23, -57, -67, -100}, "d5dc2af963", false));
                    break;
                case 54420159:
                    int i18 = f33 * (f30 | 2157);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-18, -89, -66, -63, -23, -110, -70, -112}, "58eb21a8e3db", 0.0f));
                    break;
                case 54424029:
                    int i19 = f33 * (f30 ^ 749);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-23, -108, -22, -99, -19, -109, -22, -57}, "2418621d41"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤ۠ۧۥ, reason: not valid java name and contains not printable characters */
    public static Class m177(Object obj) {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-70, -107, -24, -4, -21, -105, -70, -87}, "a63c07", true));
        while (true) {
            switch (iM336) {
                case 54156937:
                    int i = f33 * (f30 ^ 5978);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-70, -105, -29, -61, -72, -64, -72, -110}, "a38dcbc7"));
                    break;
                case 54185736:
                    int i2 = f33 * (f30 | 5848);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-65, -109, -65, -58, -24, -64, -21, -58}, "d4da3d0e75"));
                    break;
                case 54185856:
                    int i3 = f33 * (f30 + 7709);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-18, -62, -70, -100, -23, -63, -30, -82}, "5ea42e91853002", 2));
                    break;
                case 54187659:
                    int i4 = f33 * (f30 | 69);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-70, -108, -71, -108, -23, -106, -66, -109}, "a5b526e69eb826b4", false));
                    break;
                case 54210597:
                    int i5 = f33 * (f30 ^ 6984);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-22, -109, -23, -97, -67, -81, -18, -105}, "1028f0553a9e8d8c", 0.0f));
                    break;
                case 54211746:
                    int i6 = f33 * (f30 ^ 587);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-18, -109, -71, -88, -17, -52, -19, -107}, "54b74d62", true));
                    break;
                case 54216609:
                    if (hYNP32vq.m211() > 0) {
                        return Class.forName((String) obj);
                    }
                    return null;
                case 54241594:
                    int i7 = f33 * (f30 ^ 5405);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-70, -98, -65, -105, -18, -107, -70, -104}, "a8d054", true));
                    break;
                case 54268251:
                    int i8 = f33 * (f30 | 2807);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-23, -58, -71, -105, -66, -106, -23, -64}, "2fb1e2", 7));
                    break;
                case 54273218:
                    int i9 = f33 * (f30 | 205);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-67, -107, -65, -62, -65, -111, -67, -105}, "f5ddd9"));
                    break;
                case 54275911:
                    int i10 = f33 * (f30 ^ 96);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-67, -106, -30, -64, -67, -64, -67, -112}, "f79bff"));
                    break;
                case 54276129:
                    int i11 = f33 * (f30 | 4303);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-19, -63, -30, -108, -29, -98, -66, -60}, "6c9686ef", 0.0f));
                    break;
                case 54305798:
                    int i12 = f33 * (f30 | 6732);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-67, -104, -70, -110, -17, -105, -66, -111}, "f0a041e1dd"));
                    break;
                case 54359799:
                    int i13 = f33 * (f30 | 6230);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-66, -108, -67, -59, -18, -111, -30, -105}, "e7fa5491f0", 0.0f));
                    break;
                case 54361499:
                    int i14 = f33 * (f30 | 3076);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-17, -112, -18, -107, -70, -4, -17, -104}, "4854ac", 0));
                    break;
                case 54365344:
                    int i15 = f33 * (f30 + 1630);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-17, -109, -22, -109, -23, -57, -66, -3}, "45102feb6683a334"));
                    break;
                case 54387671:
                    int i16 = f33 * (f30 ^ 1082);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-20, -111, -29, -57, -19, -60, -23, -85}, "798e6a24d8cdcd"));
                    break;
                case 54395231:
                    int i17 = f33 * (f30 + 1378);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-21, -105, -21, -50, -66, -100, -21, -109}, "070fe804b2a91cf0", false));
                    break;
                case 54396188:
                    int i18 = f33 * (f30 ^ 5047);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-22, -63, -67, -109, -19, -98, -17, -58}, "1bf4684ee926", 0));
                    break;
                case 54419098:
                    int i19 = f33 * (f30 | 7852);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-23, -57, -20, -105, -29, -104, -71, -64}, "2f7080bc8789d5"));
                    break;
                case 54420244:
                    int i20 = f33 * (f30 | 6270);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-24, -7, -23, -105, -21, -110, -23, -61}, "3f20072e9f38", 0.0f));
                    break;
                case 54420276:
                    int i21 = f33 * (f30 ^ 1896);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-72, -110, -66, -105, -23, -100, -66, -63}, "c4e624eef993d18b", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۦۨۥۦ, reason: not valid java name and contains not printable characters */
    private static String m178() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-18, -60, -19, -105, -18, -107, -18, -106}, "5c6450512714ae78"));
        while (true) {
            switch (iM316) {
                case 54150181:
                    int i = f33 * (f30 + 3841);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-70, -85, -19, -59, -30, -63, -71, -110}, "a46b9bb1", true));
                    break;
                case 54155941:
                    int i2 = f33 * (f30 ^ 7705);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-18, -62, -22, -104, -19, -61, -18, -5}, "5d196d"));
                    break;
                case 54156872:
                    int i3 = f33 * (f30 | 563);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-21, -112, -65, -63, -67, -108, -29, -112}, "08def681", 6));
                    break;
                case 54182915:
                    int i4 = f33 * (f30 + 7028);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-23, -107, -22, -61, -72, -64, -23, -108}, "211fce", 0.0f));
                    break;
                case 54183777:
                    int i5 = f33 * (f30 ^ 7536);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-72, -4, -71, -112, -18, -63, -72, -63}, "ccb65e", 0.0f));
                    break;
                case 54186665:
                    int i6 = f33 * (f30 + 5437);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-22, -108, -72, -100, -66, -63, -21, -104}, "14c8eb08", true));
                    break;
                case 54186667:
                    int i7 = f33 * (f30 + 1762);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-20, -111, -70, -59, -17, -111, -67, -52}, "72ad44fd0b", 0.0f));
                    break;
                case 54210685:
                    int i8 = f33 * (f30 ^ 8126);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-65, -101, -67, -59, -65, -111, -19, -57}, "d9fcd36aba", false));
                    break;
                case 54213637:
                    int i9 = f33 * (f30 | 39);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-65, -58, -22, -112, -18, -105, -18, -90}, "db1255596686acfd", 0));
                    break;
                case 54213666:
                    int i10 = f33 * (f30 ^ 4469);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-29, -82, -67, -103, -24, -108, -24, -97}, "81f93037", 7));
                    break;
                case 54240351:
                    return C0009.m350(f36, 0, 1392960533 ^ C0005.f69, 0);
                case 54245256:
                    int i11 = f33 * (f30 ^ 59);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-71, -57, -23, -62, -72, -111, -17, -110}, "bc2fc543324d", true));
                    break;
                case 54270337:
                    int i12 = f33 * (f30 ^ 6682);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-19, -108, -66, -57, -20, -88, -19, -87}, "66ef77", 3));
                    break;
                case 54274019:
                    int i13 = f33 * (f30 ^ 528);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-20, -107, -72, -58, -67, -105, -65, -111}, "75caf4d47f96", 0));
                    break;
                case 54300189:
                    int i14 = f33 * (f30 ^ 3154);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-71, -61, -72, -57, -30, -111, -72, -57}, "bbcc97cbe264c2", 0.0f));
                    break;
                case 54300987:
                    int i15 = f33 * (f30 | 6052);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-65, -111, -29, -109, -67, -59, -67, -110}, "d082fff236a04f", true));
                    break;
                case 54301176:
                    int i16 = f33 * (f30 ^ 6321);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-72, -61, -20, -110, -70, -107, -72, -60}, "cc75a6", true));
                    break;
                case 54302973:
                    int i17 = f33 * (f30 + 6352);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-21, -62, -70, -106, -72, -112, -18, -57}, "0fa4c85ecd5c3050", 6));
                    break;
                case 54303969:
                    int i18 = f33 * (f30 + 2891);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-67, -57, -65, -58, -67, -103, -22, -62}, "fddcf91c6b85"));
                    break;
                case 54359763:
                    int i19 = f33 * (f30 + 287);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-20, -63, -24, -57, -30, -58, -67, -60}, "7e3f9afc2a214ae8"));
                    break;
                case 54391422:
                    int i20 = f33 * (f30 ^ 7905);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-20, -55, -20, -100, -71, -111, -22, -64}, "7a79b01e3b95", 0.0f));
                    break;
                case 54422075:
                    int i21 = f33 * (f30 | 2233);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-70, -108, -19, -64, -66, -105, -20, -59}, "a56de27beaaba9", 7));
                    break;
                case 54423009:
                    int i22 = f33 * (f30 | 2308);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-71, -60, -17, -57, -20, -64, -71, -59}, "bd4d7fbc39a0", 0));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۧ۟ۡ, reason: not valid java name and contains not printable characters */
    public static byte[] m179(Object obj) {
        int iM337 = C0007.m337(C0010.decode(new byte[]{-21, -109, -20, -112, -30, -64, -20, -111}, "01729b71cb"));
        while (true) {
            switch (iM337) {
                case 54150055:
                    int i = f33 * (f30 | 682);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-29, -109, -29, -64, -22, -104, -29, -112}, "828f19", 0));
                    break;
                case 54157774:
                    int i2 = f33 * (f30 + 6875);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-21, -51, -24, -106, -30, -108, -21, -62}, "0e3297", 0.0f));
                    break;
                case 54157892:
                    int i3 = f33 * (f30 | 7450);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-70, -107, -22, -106, -21, -111, -70, -110}, "a51205", true));
                    break;
                case 54183815:
                    int i4 = f33 * (f30 ^ 8019);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-19, -105, -30, -109, -67, -102, -19, -108}, "6694f9", 3));
                    break;
                case 54215430:
                    int i5 = f33 * (f30 ^ 3005);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-65, -106, -22, -108, -29, -57, -22, -60}, "d3138d1d5bd3", 1));
                    break;
                case 54216453:
                    int i6 = f33 * (f30 | 732);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-19, -61, -70, -108, -30, -100, -17, -100}, "6aa294499bb288"));
                    break;
                case 54241406:
                    int i7 = f33 * (f30 | 1507);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-70, -4, -30, -55, -72, -62, -24, -62}, "ac9acc3dbe6065"));
                    break;
                case 54245409:
                    if (OUHQwdrD.m42() <= 0) {
                        return wgkqDvlG.a((Context) obj);
                    }
                    return null;
                case 54245441:
                    int i8 = f33 * (f30 + 5366);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-65, -109, -65, -99, -19, -108, -72, -58}, "d6d561cd", true));
                    break;
                case 54270368:
                    int i9 = f33 * (f30 + 1162);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-17, -50, -22, -109, -17, -108, -70, -112}, "4f1442a0a4", 7));
                    break;
                case 54275912:
                    int i10 = f33 * (f30 + 1041);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-66, -53, -22, -105, -20, -61, -17, -108}, "ec107e45ab"));
                    break;
                case 54299103:
                    int i11 = f33 * (f30 + 59);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-20, -112, -29, -105, -70, -109, -70, -105}, "7887a1a7b6d9", 0.0f));
                    break;
                case 54334784:
                    int i12 = f33 * (f30 | 328);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-17, -101, -21, -64, -71, -107, -22, -97}, "480ab31742"));
                    break;
                case 54335615:
                    int i13 = f33 * (f30 ^ 7944);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-65, -60, -66, -97, -30, -97, -65, -57}, "dae998", false));
                    break;
                case 54336640:
                    int i14 = f33 * (f30 | 669);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-19, -107, -30, -61, -18, -109, -22, -59}, "619c501cf990850c", false));
                    break;
                case 54363425:
                    int i15 = f33 * (f30 | 4871);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-17, -4, -20, -110, -24, -109, -24, -107}, "4c7233339b", true));
                    break;
                case 54388385:
                    int i16 = f33 * (f30 ^ 6171);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-20, -111, -29, -59, -72, -82, -20, -111}, "728bc1", 0.0f));
                    break;
                case 54418230:
                    int i17 = f33 * (f30 | 295);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-24, -109, -21, -111, -67, -104, -72, -106}, "3504f9c5e28a36", 0));
                    break;
                case 54422112:
                    int i18 = f33 * (f30 + 6367);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-20, -106, -17, -110, -18, -106, -19, -100}, "71425664dd7408", 6));
                    break;
                case 54425081:
                    int i19 = f33 * (f30 ^ 6466);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-19, -101, -19, -106, -22, -59, -72, -99}, "69601bc9c057"));
                    break;
                case 54425082:
                    int i20 = f33 * (f30 + 761);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-19, -85, -66, -102, -21, -61, -20, -58}, "64e20f7fc5781136"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۨۤۧ, reason: not valid java name and contains not printable characters */
    private static String m180() {
        int iM337 = C0007.m337(C0010.decode(new byte[]{-17, -109, -20, -102, -23, -64, -22, -111}, "46792d123494", false));
        while (true) {
            switch (iM337) {
                case 54149276:
                    int i = f33 * (f30 | 4564);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-23, -99, -22, -106, -29, -86, -66, -112}, "291185e1", 5));
                    break;
                case 54151040:
                    int i2 = f33 * (f30 ^ 7241);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-17, -60, -21, -61, -30, -59, -19, -6}, "4b0b9b6e22b725", false));
                    break;
                case 54151970:
                    return C0009.m350(f36, 33, 672438444 ^ C0007.f73, 6);
                case 54156783:
                    int i3 = f33 * (f30 + 547);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-20, -112, -29, -99, -72, -60, -65, -5}, "7585cbddd70d", 0.0f));
                    break;
                case 54156870:
                    int i4 = f33 * (f30 ^ 6287);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-21, -64, -67, -63, -65, -101, -21, -53}, "0cffd9", 6));
                    break;
                case 54179847:
                    int i5 = f33 * (f30 ^ 2529);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-30, -3, -66, -2, -21, -107, -23, -101}, "9bea03296f32eb", 4));
                    break;
                case 54181832:
                    int i6 = f33 * (f30 + 7404);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-21, -111, -70, -112, -21, -58, -19, -97}, "09a10b695a67", 0.0f));
                    break;
                case 54184869:
                    int i7 = f33 * (f30 ^ 141);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-19, -84, -70, -107, -67, -59, -72, -103}, "63a2ffc87fd7cd", 6));
                    break;
                case 54210842:
                    int i8 = f33 * (f30 | 1320);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-21, -106, -22, -106, -23, -109, -21, -106}, "041521", 0.0f));
                    break;
                case 54212518:
                    int i9 = f33 * (f30 + 6940);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-67, -86, -20, -105, -72, -111, -71, -81}, "f575c1b03e6848"));
                    break;
                case 54242369:
                    int i10 = f33 * (f30 ^ 4052);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-20, -107, -22, -54, -65, -109, -20, -63}, "711bd47d", 0.0f));
                    break;
                case 54269370:
                    int i11 = f33 * (f30 ^ 1351);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-67, -109, -30, -109, -65, -105, -17, -108}, "f592d44231", 0));
                    break;
                case 54276010:
                    int i12 = f33 * (f30 ^ 5299);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-30, -57, -18, -102, -23, -111, -22, -110}, "9f5921162ff575", 0.0f));
                    break;
                case 54299971:
                    int i13 = f33 * (f30 | 7649);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-19, -58, -22, -105, -65, -59, -30, -106}, "6f17de91a181", true));
                    break;
                case 54305701:
                    int i14 = f33 * (f30 ^ 3372);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-30, -55, -20, -104, -71, -61, -30, -57}, "9a79bb", 0.0f));
                    break;
                case 54306914:
                    int i15 = f33 * (f30 | 3499);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-22, -107, -19, -60, -19, -64, -22, -110}, "106f6f", 4));
                    break;
                case 54330905:
                    int i16 = f33 * (f30 | 2416);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-20, -110, -22, -105, -71, -109, -19, -112}, "7117b662cab42e5d", 6));
                    break;
                case 54331805:
                    int i17 = f33 * (f30 | 6575);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-65, -104, -17, -57, -71, -109, -67, -101}, "d84eb1f34cd7", 3));
                    break;
                case 54336668:
                    int i18 = f33 * (f30 | 7163);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-20, -109, -24, -58, -70, -112, -70, -97}, "733ca7a8d9", 3));
                    break;
                case 54359646:
                    int i19 = f33 * (f30 ^ 4280);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-19, -64, -71, -109, -66, -59, -71, -111}, "6db2eeb793ab6f"));
                    break;
                case 54359763:
                    int i20 = f33 * (f30 | 3325);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-29, -89, -65, -106, -21, -106, -29, -97}, "88d106", 1));
                    break;
                case 54419166:
                    int i21 = f33 * (f30 ^ 3290);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-71, -84, -22, -104, -70, -111, -22, -4}, "b319a01c8fca21"));
                    break;
                case 54419259:
                    int i22 = f33 * (f30 ^ 743);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-65, -108, -66, -108, -17, -102, -65, -105}, "d5e542", 6));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥ۟ۢ۠ۥ, reason: contains not printable characters */
    private static String m181() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-17, -110, -23, -57, -20, -57, -19, -103}, "412e7b6869391f", true));
        while (true) {
            switch (iM330) {
                case 54149218:
                    int i = f33 * (f30 | 6365);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-65, -63, -17, -81, -22, -62, -19, -87}, "db401d66d4ed", true));
                    break;
                case 54151173:
                    int i2 = f33 * (f30 | 1615);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-65, -108, -67, -58, -65, -110, -18, -62}, "d6ffd75f4e42", 0.0f));
                    break;
                case 54156753:
                    int i3 = f33 * (f30 | 4125);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-65, -58, -20, -111, -22, -98, -17, -108}, "de771844f54568", true));
                    break;
                case 54180960:
                    int i4 = f33 * (f30 | 2862);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-70, -112, -17, -101, -21, -7, -72, -105}, "a0430fc3", 4));
                    break;
                case 54182695:
                    int i5 = f33 * (f30 ^ 133);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-65, -5, -19, -110, -19, -5, -20, -53}, "dd656d7ca162fd21", false));
                    break;
                case 54185702:
                    int i6 = f33 * (f30 + 5457);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-67, -111, -30, -86, -66, -109, -18, -110}, "f495e752cd"));
                    break;
                case 54186539:
                    int i7 = f33 * (f30 + 7118);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-66, -110, -19, -110, -24, -107, -65, -60}, "e36434daacbf", false));
                    break;
                case 54187501:
                    int i8 = f33 * (f30 | 5910);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-70, -110, -29, -109, -65, -81, -67, -108}, "a686d0f33382"));
                    break;
                case 54187502:
                    int i9 = f33 * (f30 ^ 2972);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-20, -97, -71, -107, -29, -57, -70, -111}, "77b68fa735", 0.0f));
                    break;
                case 54213575:
                    int i10 = f33 * (f30 + 4416);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-24, -7, -70, -82, -18, -57, -17, -61}, "3fa15c4e", 0.0f));
                    break;
                case 54215433:
                    int i11 = f33 * (f30 + 652);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-65, -108, -70, -109, -22, -57, -65, -105}, "d4a51d", true));
                    break;
                case 54239581:
                    int i12 = f33 * (f30 ^ 5928);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-19, -108, -24, -64, -18, -63, -17, -59}, "603a5f4be1d53caa", 0.0f));
                    break;
                case 54243457:
                    int i13 = f33 * (f30 ^ 2807);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-21, -88, -21, -60, -18, -112, -21, -97}, "070e55", 6));
                    break;
                case 54268437:
                    int i14 = f33 * (f30 + 486);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-65, -58, -65, -97, -65, -85, -17, -58}, "dfd8d44e", 0.0f));
                    break;
                case 54271291:
                    int i15 = f33 * (f30 | 2475);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-19, -102, -18, -103, -20, -89, -23, -105}, "6251782395", 0.0f));
                    break;
                case 54275165:
                    int i16 = f33 * (f30 | 2678);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-30, -109, -17, -87, -30, -106, -17, -102}, "944697428b", 0.0f));
                    break;
                case 54300189:
                    int i17 = f33 * (f30 | 4616);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-23, -57, -18, -108, -22, -59, -66, -108}, "2c531be6", 4));
                    break;
                case 54303785:
                    int i18 = f33 * (f30 | 4954);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-70, -60, -18, -111, -72, -4, -21, -63}, "ad52cc0b9bfecb78"));
                    break;
                case 54305950:
                    return C0009.m350(f36, 84, 1687538337 ^ C0000.f59, 10);
                case 54327958:
                    int i19 = f33 * (f30 ^ 1906);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-71, -112, -24, -111, -17, -64, -17, -107}, "b0304e4194381c", false));
                    break;
                case 54387455:
                    int i20 = f33 * (f30 | 561);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-17, -112, -17, -102, -17, -5, -71, -108}, "40424db1", 2));
                    break;
                case 54421088:
                    int i21 = f33 * (f30 | 1757);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-20, -102, -65, -99, -65, -98, -67, -61}, "78d9d8ff55", 0.0f));
                    break;
                case 54425829:
                    int i22 = f33 * (f30 + 4310);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-19, -110, -71, -64, -19, -106, -17, -110}, "63bd65454beeaea9", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۣ۠ۥ, reason: contains not printable characters */
    public static int m182(Object obj) {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-70, -105, -29, -55, -21, -107, -66, -106}, "a18a00e496a2d3", 0.0f));
        while (true) {
            switch (iM336) {
                case 54152220:
                    int i = f33 * (f30 | 4823);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-72, -109, -66, -110, -20, -108, -72, -111}, "c5e477", 0.0f));
                    break;
                case 54182912:
                    int i2 = f33 * (f30 | 34);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-72, -109, -70, -109, -72, -112, -24, -62}, "c4a7c73f29892725", 6));
                    break;
                case 54209786:
                    int i3 = f33 * (f30 ^ 7276);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-22, -107, -20, -61, -30, -109, -21, -111}, "117e9009bbbdcf56", 1));
                    break;
                case 54211801:
                    int i4 = f33 * (f30 ^ 1755);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-72, -108, -18, -88, -71, -106, -72, -110}, "c257b2", 0.0f));
                    break;
                case 54213445:
                    int i5 = f33 * (f30 | 6853);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-21, -109, -22, -101, -29, -111, -20, -111}, "02198971f2", 0.0f));
                    break;
                case 54238467:
                    int i6 = f33 * (f30 + 338);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-20, -5, -20, -111, -23, -97, -17, -112}, "7d732741", 2));
                    break;
                case 54241537:
                    int i7 = f33 * (f30 | 2927);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-20, -60, -70, -112, -70, -61, -65, -101}, "7aa5afd331d434", 0.0f));
                    break;
                case 54272188:
                    int i8 = f33 * (f30 ^ 481);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-18, -109, -29, -101, -18, -64, -67, -63}, "51895fff"));
                    break;
                case 54274085:
                    int i9 = f33 * (f30 | 7684);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-20, -111, -30, -57, -18, -105, -29, -97}, "769e5689"));
                    break;
                case 54275198:
                    return obj.hashCode();
                case 54304871:
                    int i10 = f33 * (f30 ^ 8049);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-18, -107, -71, -107, -21, -89, -20, -102}, "53b70879df"));
                    break;
                case 54333763:
                    int i11 = f33 * (f30 | 2337);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-24, -111, -70, -107, -18, -108, -18, -109}, "30a551532abadd", false));
                    break;
                case 54357749:
                    int i12 = f33 * (f30 ^ 1247);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-19, -64, -70, -64, -29, -109, -66, -105}, "6cae81e2b56d7023", true));
                    break;
                case 54360480:
                    int i13 = f33 * (f30 | 5321);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-70, -97, -70, -59, -21, -52, -21, -88}, "a7ae0d07", 2));
                    break;
                case 54364449:
                    int i14 = f33 * (f30 | 6765);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-71, -64, -29, -107, -29, -112, -20, -5}, "bc86837d0437ae65", 0.0f));
                    break;
                case 54366431:
                    int i15 = f33 * (f30 + 3450);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-23, -62, -24, -60, -71, -109, -29, -63}, "2e3ab58ee6", 1));
                    break;
                case 54390336:
                    int i16 = f33 * (f30 + 2177);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-21, -62, -21, -112, -65, -62, -72, -105}, "0a06dec5", false));
                    break;
                case 54391385:
                    int i17 = f33 * (f30 ^ 638);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-24, -100, -21, -60, -30, -2, -17, -4}, "340d9a4c320f", 0));
                    break;
                case 54392442:
                    int i18 = f33 * (f30 | 293);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-24, -62, -18, -112, -24, -112, -70, -108}, "3e5334a529", 0.0f));
                    break;
                case 54393372:
                    int i19 = f33 * (f30 + 5372);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-22, -63, -67, -57, -17, -100, -24, -61}, "1ffa443d9328", 7));
                    break;
                case 54394398:
                    int i20 = f33 * (f30 ^ 5437);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-18, -107, -19, -89, -17, -108, -20, -107}, "576844733f"));
                    break;
                case 54418136:
                    int i21 = f33 * (f30 + 2704);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-30, -105, -21, -58, -17, -87, -70, -59}, "960b46ad3a", 3));
                    break;
                case 54418415:
                    int i22 = f33 * (f30 + 7415);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-71, -103, -17, -111, -20, -111, -29, -64}, "b942778c94", 7));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۤ۠ۧۨ, reason: contains not printable characters */
    private static String m183() {
        int iM337 = C0007.m337(C0010.decode(new byte[]{-17, -108, -22, -59, -30, -57, -17, -109}, "431c9b"));
        while (true) {
            switch (iM337) {
                case 54155041:
                    int i = f33 * (f30 ^ 5494);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-29, -100, -70, -63, -18, -61, -65, -111}, "84aa5cd366"));
                    break;
                case 54156961:
                    int i2 = f33 * (f30 ^ 7793);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-24, -111, -22, -57, -29, -55, -17, -109}, "331b8a44815a1959", false));
                    break;
                case 54179907:
                    int i3 = f33 * (f30 ^ 4877);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-22, -106, -23, -108, -71, -110, -22, -111}, "1126b717c3302525"));
                    break;
                case 54186662:
                    int i4 = f33 * (f30 | 5514);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-72, -60, -17, -107, -65, -103, -19, -60}, "cb44d96a", 0.0f));
                    break;
                case 54217567:
                    int i5 = f33 * (f30 + 3762);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-66, -60, -29, -111, -67, -112, -19, -106}, "ed86f364", false));
                    break;
                case 54239582:
                    int i6 = f33 * (f30 | 2958);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-24, -108, -67, -59, -23, -63, -24, -101}, "33fb2e388a3ae660", 0.0f));
                    break;
                case 54242465:
                    int i7 = f33 * (f30 + 4517);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-66, -63, -21, -107, -23, -111, -66, -110}, "ec0524e76cdf20", 0));
                    break;
                case 54244482:
                    int i8 = f33 * (f30 ^ 6193);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-17, -62, -19, -111, -18, -61, -65, -61}, "4f665bdc58", 0.0f));
                    break;
                case 54269338:
                    int i9 = f33 * (f30 | 8131);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-67, -99, -29, -58, -71, -53, -30, -3}, "f58fbc9ba55a0c", false));
                    break;
                case 54300962:
                    int i10 = f33 * (f30 ^ 7550);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-70, -105, -18, -63, -30, -57, -70, -110}, "a75a9e"));
                    break;
                case 54301983:
                    int i11 = f33 * (f30 ^ 6061);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-65, -112, -21, -107, -71, -61, -72, -61}, "d407bbcf7d286e", true));
                    break;
                case 54305762:
                    int i12 = f33 * (f30 + 6605);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-72, -61, -67, -109, -24, -104, -67, -62}, "cef139fc", 3));
                    break;
                case 54327957:
                    int i13 = f33 * (f30 | 115);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-24, -52, -65, -64, -66, -112, -24, -57}, "3ddee0"));
                    break;
                case 54359552:
                    int i14 = f33 * (f30 + 6672);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-20, -112, -19, -108, -70, -106, -18, -59}, "7467a55fb9", 1));
                    break;
                case 54360540:
                    return C0009.m350(f36, 22, 2135826683 ^ C0000.f59, 11);
                case 54390460:
                    int i15 = f33 * (f30 ^ 1214);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-23, -112, -71, -109, -71, -100, -18, -110}, "23b3b85339"));
                    break;
                case 54394298:
                    int i16 = f33 * (f30 | 4853);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-66, -7, -18, -57, -71, -108, -67, -61}, "ef5bb2fbe8a2", 5));
                    break;
                case 54395231:
                    int i17 = f33 * (f30 + 2358);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-17, -3, -21, -61, -72, -98, -17, -3}, "4b0dc8"));
                    break;
                case 54418170:
                    int i18 = f33 * (f30 | 1279);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-30, -59, -67, -104, -66, -104, -30, -60}, "9df0e0", false));
                    break;
                case 54418415:
                    int i19 = f33 * (f30 | 7915);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-22, -108, -30, -6, -30, -64, -65, -81}, "119e9dd001", 7));
                    break;
                case 54422976:
                    int i20 = f33 * (f30 | 4206);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-30, -102, -71, -109, -72, -107, -72, -109}, "98b0c0c6f3cf7515"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۥۤۧ, reason: contains not printable characters */
    private static String m184() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-65, -108, -66, -111, -20, -83, -30, -108}, "d5e572960dbccd", true));
        while (true) {
            switch (iM336) {
                case 54151198:
                    int i = f33 * (f30 ^ 6735);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-65, -105, -65, -101, -23, -110, -70, -107}, "d6d822a3", 6));
                    break;
                case 54155787:
                    int i2 = f33 * (f30 | 4819);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-30, -112, -17, -59, -20, -108, -30, -100}, "984d71", 6));
                    break;
                case 54156846:
                    int i3 = f33 * (f30 | 6380);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-30, -54, -66, -110, -17, -108, -30, -58}, "9be345"));
                    break;
                case 54156930:
                    int i4 = f33 * (f30 + 6182);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-30, -84, -30, -98, -17, -82, -66, -59}, "939841ef78a87a65"));
                    break;
                case 54187591:
                    int i5 = f33 * (f30 + 2329);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-21, -106, -23, -104, -72, -50, -20, -107}, "0720cf75f0780066", true));
                    break;
                case 54212520:
                    int i6 = f33 * (f30 | 1282);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-22, -82, -24, -105, -21, -64, -72, -81}, "11300ec05d", true));
                    break;
                case 54213446:
                    int i7 = f33 * (f30 + 6242);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-30, -61, -18, -111, -66, -106, -72, -111}, "9a51e3c607"));
                    break;
                case 54213540:
                    int i8 = f33 * (f30 ^ 7982);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-66, -109, -21, -98, -24, -108, -24, -90}, "e50630395656e1", false));
                    break;
                case 54217567:
                    int i9 = f33 * (f30 ^ 6965);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-71, -112, -21, -59, -71, -97, -66, -108}, "b60eb8e397"));
                    break;
                case 54239584:
                    int i10 = f33 * (f30 ^ 1738);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-19, -62, -24, -105, -21, -101, -67, -101}, "6c3309f884a9", 0.0f));
                    break;
                case 54243456:
                    int i11 = f33 * (f30 | 1906);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-20, -112, -65, -57, -66, -107, -23, -107}, "74dee22412"));
                    break;
                case 54245188:
                    return C0009.m350(f36, 16, 858742920 ^ C0006.f71, 6);
                case 54270181:
                    int i12 = f33 * (f30 + 7639);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-29, -105, -70, -108, -29, -63, -66, -105}, "82a58de6"));
                    break;
                case 54301144:
                    int i13 = f33 * (f30 | 8047);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-22, -105, -24, -104, -17, -57, -67, -112}, "17304ef16204", false));
                    break;
                case 54305887:
                    int i14 = f33 * (f30 + 7669);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-65, -60, -20, -57, -17, -112, -65, -64}, "da7f40", 2));
                    break;
                case 54329757:
                    int i15 = f33 * (f30 ^ 1792);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-17, -112, -22, -106, -72, -58, -17, -58}, "4210cf4f", 7));
                    break;
                case 54329912:
                    int i16 = f33 * (f30 ^ 3510);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-20, -90, -17, -62, -66, -110, -72, -111}, "794ce4c30fd22c86", 7));
                    break;
                case 54331746:
                    int i17 = f33 * (f30 ^ 3210);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-22, -87, -20, -61, -21, -61, -72, -111}, "167d0ac9", 0.0f));
                    break;
                case 54358810:
                    int i18 = f33 * (f30 + 2172);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-71, -62, -21, -111, -66, -57, -23, -112}, "bf06eb215e10bedc"));
                    break;
                case 54366397:
                    int i19 = f33 * (f30 + 5388);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-30, -107, -72, -111, -19, -64, -18, -108}, "90c26b5242"));
                    break;
                case 54419164:
                    int i20 = f33 * (f30 + 1750);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-18, -59, -30, -110, -23, -109, -22, -108}, "5f932313bb", false));
                    break;
                case 54419288:
                    int i21 = f33 * (f30 ^ 123);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-72, -98, -70, -111, -71, -58, -66, -57}, "c6a9bbee270b", 1));
                    break;
                case 54425982:
                    int i22 = f33 * (f30 + 2524);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-65, -108, -71, -112, -20, -108, -18, -58}, "d6b4725bc6", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۦۤۦۡ, reason: contains not printable characters */
    private static String m185() {
        int iM321 = C0003.m321(C0010.decode(new byte[]{-17, -111, -24, -106, -29, -107, -72, -58}, "423382cb", 2));
        while (true) {
            switch (iM321) {
                case 54178911:
                    int i = f33 * (f30 + 4058);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-23, -98, -71, -106, -29, -59, -23, -90}, "29b68c", 4));
                    break;
                case 54180003:
                    int i2 = f33 * (f30 + 4513);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-72, -64, -66, -60, -17, -61, -67, -110}, "cfec4df514fb", false));
                    break;
                case 54182787:
                    int i3 = f33 * (f30 ^ 6434);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-30, -107, -22, -57, -24, -106, -20, -110}, "931d31731d2f"));
                    break;
                case 54185637:
                    int i4 = f33 * (f30 ^ 5660);
                    iM321 = C0005.m330(C0010.decode(new byte[]{-18, -61, -30, -106, -30, -57, -17, -59}, "5f979c4eeb2c70", 6));
                    break;
                case 54187778:
                    int i5 = f33 * (f30 + 2823);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-70, -102, -24, -98, -67, -106, -22, -107}, "a938f516168b59"));
                    break;
                case 54245165:
                    int i6 = f33 * (f30 | 2551);
                    iM321 = C0009.m349(C0010.decode(new byte[]{-23, -57, -29, -111, -72, -51, -23, -61}, "2d89ce", 0.0f));
                    break;
                case 54245221:
                    int i7 = f33 * (f30 + 4995);
                    iM321 = C0006.m336(C0010.decode(new byte[]{-71, -60, -21, -110, -21, -57, -71, -59}, "ba010dbac41ddb", 0.0f));
                    break;
                case 54273088:
                    int i8 = f33 * (f30 | 833);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-21, -110, -24, -101, -18, -100, -22, -102}, "02335418009ddfc7", false));
                    break;
                case 54274239:
                    int i9 = f33 * (f30 + 168);
                    iM321 = C0005.m330(C0010.decode(new byte[]{-29, -107, -23, -112, -17, -53, -66, -103}, "81234ce988523d"));
                    break;
                case 54275075:
                    int i10 = f33 * (f30 | 136);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-70, -102, -65, -103, -22, -101, -65, -108}, "a2d919d7", false));
                    break;
                case 54277156:
                    int i11 = f33 * (f30 + 869);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-67, -109, -17, -107, -30, -110, -67, -112}, "f04193", true));
                    break;
                case 54302108:
                    int i12 = f33 * (f30 + 7763);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-21, -111, -30, -63, -18, -107, -65, -97}, "019a50d73db7a8"));
                    break;
                case 54302135:
                    int i13 = f33 * (f30 | 3901);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-21, -104, -65, -62, -21, -112, -72, -108}, "08da02c67f0265", false));
                    break;
                case 54303779:
                    int i14 = f33 * (f30 | 2861);
                    iM321 = C0006.m336(C0010.decode(new byte[]{-29, -64, -17, -110, -21, -97, -20, -108}, "8d4108702c873aaf"));
                    break;
                case 54329880:
                    int i15 = f33 * (f30 ^ 5523);
                    iM321 = C0005.m330(C0010.decode(new byte[]{-67, -57, -66, -105, -70, -111, -72, -58}, "fbe5a2cfcef0cc94"));
                    break;
                case 54330810:
                    int i16 = f33 * (f30 + 4276);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-65, -105, -70, -103, -66, -111, -19, -111}, "d0a1e966", 0.0f));
                    break;
                case 54331775:
                    int i17 = f33 * (f30 ^ 8045);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-23, -104, -66, -109, -67, -62, -18, -112}, "28e5fc5051afa1", false));
                    break;
                case 54361687:
                    int i18 = f33 * (f30 + 6811);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-20, -97, -23, -109, -20, -57, -70, -57}, "77257eafca79"));
                    break;
                case 54365537:
                    int i19 = f33 * (f30 | 1459);
                    iM321 = C0009.m349(C0010.decode(new byte[]{-22, -61, -70, -109, -23, -90, -70, -111}, "1aa529a95df77f", true));
                    break;
                case 54388562:
                    int i20 = f33 * (f30 | 6960);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-72, -112, -17, -111, -29, -5, -66, -64}, "c4448dea27e71f", 0.0f));
                    break;
                case 54396320:
                    return C0009.m350(f36, 0, 1711364831 ^ C0002.f63, 0);
                case 54418233:
                    int i21 = f33 * (f30 + 538);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-70, -57, -20, -64, -19, -60, -17, -110}, "ae7f6e40", false));
                    break;
                case 54423997:
                    int i22 = f33 * (f30 ^ 4750);
                    iM321 = C0006.m336(C0010.decode(new byte[]{-65, -60, -65, -4, -30, -109, -18, -105}, "dddc92562d9f", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۤۦۦ, reason: not valid java name and contains not printable characters */
    public static String m186() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-22, -106, -17, -54, -66, -111, -22, -64}, "174be01f2bb4", 0.0f));
        while (true) {
            switch (iM324) {
                case 54149057:
                    int i = f33 * (f30 + 3215);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-19, -109, -24, -105, -22, -59, -21, -108}, "67341c004b"));
                    break;
                case 54150212:
                    int i2 = f33 * (f30 | 5233);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-19, -62, -24, -81, -70, -107, -20, -55}, "6d30a47a957291", 0.0f));
                    break;
                case 54152008:
                    int i3 = f33 * (f30 | 5986);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-22, -59, -21, -107, -30, -110, -18, -103}, "1e039759c054", false));
                    break;
                case 54152009:
                    int i4 = f33 * (f30 ^ 3721);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-21, -107, -18, -64, -19, -107, -66, -58}, "025a64ebe834"));
                    break;
                case 54153027:
                    int i5 = f33 * (f30 ^ 1947);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-24, -63, -71, -64, -23, -104, -29, -110}, "3dbd2983", 2));
                    break;
                case 54155852:
                    int i6 = f33 * (f30 ^ 3094);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-72, -85, -30, -4, -72, -7, -17, -107}, "c49ccf457e60", 0.0f));
                    break;
                case 54157984:
                    int i7 = f33 * (f30 ^ 8059);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-21, -111, -21, -104, -29, -64, -71, -64}, "02008abfe1729f9c", 4));
                    break;
                case 54185761:
                    int i8 = f33 * (f30 ^ 1365);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-70, -57, -19, -63, -71, -86, -70, -61}, "ad6fb5", 0.0f));
                    break;
                case 54211681:
                    int i9 = f33 * (f30 | 3693);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-70, -63, -17, -84, -30, -106, -20, -61}, "ae43917f1eaac8"));
                    break;
                case 54217356:
                    int i10 = f33 * (f30 + 2399);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-67, -85, -21, -60, -22, -57, -17, -98}, "f40d1b461c07", 0.0f));
                    break;
                case 54242429:
                    int i11 = f33 * (f30 | 6743);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-19, -58, -18, -111, -22, -63, -23, -90}, "6c571f29ea"));
                    break;
                case 54275916:
                    int i12 = f33 * (f30 ^ 5378);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-67, -100, -19, -86, -67, -112, -20, -97}, "f865f579cb98fa", 0.0f));
                    break;
                case 54276938:
                    int i13 = f33 * (f30 + 4337);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-67, -87, -19, -106, -22, -102, -22, -111}, "f6651913de", false));
                    break;
                case 54298204:
                    int i14 = f33 * (f30 + 6373);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-22, -3, -29, -110, -17, -105, -72, -111}, "1b8046c6", 1));
                    break;
                case 54298265:
                    int i15 = f33 * (f30 ^ 1753);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-20, -88, -29, -110, -22, -108, -71, -107}, "778415b3", 0.0f));
                    break;
                case 54302077:
                    int i16 = f33 * (f30 ^ 5046);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-66, -3, -29, -102, -21, -105, -67, -97}, "eb8806f9a26e1cff", 0.0f));
                    break;
                case 54305953:
                    int i17 = f33 * (f30 | 3559);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-17, -103, -29, -101, -70, -111, -17, -111}, "4188a9", 0.0f));
                    break;
                case 54332671:
                    if (OUHQwdrD.m42() <= 0) {
                        return m190();
                    }
                    return null;
                case 54334777:
                    int i18 = f33 * (f30 + 1991);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-65, -107, -23, -101, -19, -106, -72, -58}, "d42962cb31b449", 1));
                    break;
                case 54357664:
                    int i19 = f33 * (f30 | 5364);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-72, -57, -24, -57, -66, -63, -22, -107}, "ce3dee15d8c21f57", 1));
                    break;
                case 54389373:
                    int i20 = f33 * (f30 ^ 2226);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-23, -58, -24, -112, -30, -58, -72, -109}, "2b379ac67d"));
                    break;
                case 54421299:
                    int i21 = f33 * (f30 ^ 5490);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-67, -89, -19, -52, -20, -112, -67, -89}, "f86d78", 2));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۦۣۧ, reason: not valid java name and contains not printable characters */
    public static boolean m187(Object obj, Object obj2) {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-29, -106, -71, -57, -20, -5, -21, -61}, "86bc7d0daec7", 2));
        while (true) {
            switch (iM336) {
                case 54179967:
                    int i = f33 * (f30 | 5684);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-24, -55, -30, -107, -71, -62, -18, -105}, "3a95ba518d9733", 1));
                    break;
                case 54180869:
                    int i2 = f33 * (f30 | 7927);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-23, -108, -22, -105, -24, -58, -71, -60}, "20143bbccba1a14e", 0.0f));
                    break;
                case 54181019:
                    int i3 = f33 * (f30 + 1324);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-71, -64, -23, -99, -65, -58, -21, -110}, "bc28dd02", 0.0f));
                    break;
                case 54182760:
                    int i4 = f33 * (f30 + 5367);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-22, -112, -21, -109, -24, -110, -22, -109}, "150335", 6));
                    break;
                case 54183660:
                    int i5 = f33 * (f30 | 19);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-72, -107, -70, -111, -24, -105, -22, -111}, "c5a03010", 0.0f));
                    break;
                case 54213451:
                    int i6 = f33 * (f30 + 5036);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-65, -62, -66, -107, -30, -109, -65, -60}, "dbe692db", 0.0f));
                    break;
                case 54268469:
                    int i7 = f33 * (f30 ^ 1025);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-66, -58, -29, -106, -18, -63, -66, -60}, "eb855d", true));
                    break;
                case 54274080:
                    int i8 = f33 * (f30 + 6387);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-17, -111, -17, -106, -21, -106, -72, -112}, "494404c6c8a3", true));
                    break;
                case 54302018:
                    int i9 = f33 * (f30 | 2429);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-18, -106, -70, -106, -65, -99, -67, -57}, "56a6d9fdc0"));
                    break;
                case 54302048:
                    int i10 = f33 * (f30 ^ 7716);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-23, -63, -30, -106, -29, -50, -17, -57}, "2d938f4e", false));
                    break;
                case 54329018:
                    int i11 = f33 * (f30 ^ 2721);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-70, -99, -29, -58, -72, -63, -70, -111}, "a58fcc"));
                    break;
                case 54333850:
                    int i12 = f33 * (f30 ^ 4042);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-67, -58, -67, -3, -66, -106, -66, -106}, "fafbe7e784e0", true));
                    break;
                case 54361690:
                    int i13 = f33 * (f30 + 2548);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-67, -50, -24, -111, -29, -58, -20, -54}, "ff328b7b", 1));
                    break;
                case 54387448:
                    int i14 = f33 * (f30 | 4364);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-24, -106, -17, -64, -66, -97, -24, -106}, "314fe8", 0.0f));
                    break;
                case 54394367:
                    int i15 = f33 * (f30 ^ 4579);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-30, -112, -20, -111, -22, -111, -18, -109}, "90701355", 0.0f));
                    break;
                case 54418234:
                    int i16 = f33 * (f30 | 60);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-67, -63, -65, -83, -65, -106, -67, -62}, "fbd2d1"));
                    break;
                case 54418267:
                    if (m156() <= 0) {
                        return C0005.m331((String) obj, (String) obj2);
                    }
                    return false;
                case 54418386:
                    int i17 = f33 * (f30 + 2876);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-23, -62, -19, -102, -23, -111, -72, -58}, "2d6926cb3a9d", 6));
                    break;
                case 54420158:
                    int i18 = f33 * (f30 | 190);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-17, -100, -66, -103, -21, -98, -24, -62}, "44e9093c665a49d9", 0.0f));
                    break;
                case 54421183:
                    int i19 = f33 * (f30 | 8052);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-18, -57, -24, -62, -72, -87, -65, -62}, "5f3fc6de528ba0", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۡۦۤ, reason: not valid java name and contains not printable characters */
    private static String m188() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-22, -89, -72, -105, -66, -62, -67, -90}, "18c1eef918550179", true));
        while (true) {
            switch (iM324) {
                case 54156031:
                    int i = f33 * (f30 + 550);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-70, -57, -20, -109, -30, -101, -65, -84}, "af7798d3a6705afd"));
                    break;
                case 54179874:
                    int i2 = f33 * (f30 ^ 888);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-22, -111, -19, -112, -22, -112, -29, -105}, "19681082", 0.0f));
                    break;
                case 54182011:
                    int i3 = f33 * (f30 ^ 7342);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-71, -107, -67, -108, -19, -109, -29, -63}, "b1f3678bd0", 3));
                    break;
                case 54210779:
                    int i4 = f33 * (f30 ^ 7190);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-71, -109, -20, -60, -66, -60, -19, -108}, "b37dee67982b7b", 0.0f));
                    break;
                case 54210785:
                    int i5 = f33 * (f30 ^ 6938);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-20, -112, -65, -111, -19, -108, -20, -105}, "75d967"));
                    break;
                case 54213507:
                    int i6 = f33 * (f30 | 1629);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-24, -98, -17, -111, -18, -109, -66, -52}, "394354ed", true));
                    break;
                case 54213567:
                    int i7 = f33 * (f30 ^ 4542);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-29, -110, -65, -104, -71, -61, -29, -108}, "83d9be"));
                    break;
                case 54239642:
                    int i8 = f33 * (f30 + 463);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-72, -59, -30, -110, -30, -108, -66, -63}, "ca9190ee42e0bd00", 2));
                    break;
                case 54242368:
                    int i9 = f33 * (f30 + 3491);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-67, -57, -23, -61, -30, -109, -70, -106}, "fb2b93a5ab5975", true));
                    break;
                case 54244452:
                    int i10 = f33 * (f30 ^ 4287);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-29, -106, -24, -58, -72, -59, -71, -98}, "853ecdb8"));
                    break;
                case 54272133:
                    int i11 = f33 * (f30 | 2904);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-66, -58, -23, -112, -65, -105, -66, -64}, "eb20d0"));
                    break;
                case 54299223:
                    int i12 = f33 * (f30 + 7632);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-20, -62, -67, -101, -65, -60, -20, -60}, "7ef3dd", false));
                    break;
                case 54302015:
                    return C0009.m350(f36, 58, 552553026 ^ C0008.f75, 3);
                case 54305858:
                    int i13 = f33 * (f30 | 6189);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-21, -60, -66, -112, -19, -99, -21, -59}, "0be065"));
                    break;
                case 54329759:
                    int i14 = f33 * (f30 ^ 2173);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-72, -60, -65, -57, -71, -53, -18, -105}, "cddebc560cb22b"));
                    break;
                case 54336578:
                    int i15 = f33 * (f30 | 3262);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-24, -107, -70, -109, -67, -62, -23, -54}, "37a6fe2b", true));
                    break;
                case 54358841:
                    int i16 = f33 * (f30 + 2105);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-21, -109, -24, -63, -29, -98, -17, -57}, "013a894d26916b39"));
                    break;
                case 54388354:
                    int i17 = f33 * (f30 ^ 4222);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-29, -64, -17, -107, -65, -61, -19, -105}, "8a41db660c918ca4", true));
                    break;
                case 54390524:
                    int i18 = f33 * (f30 + 446);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-17, -62, -23, -109, -21, -109, -22, -110}, "4c220513", 0.0f));
                    break;
                case 54396066:
                    int i19 = f33 * (f30 ^ 3180);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-21, -108, -20, -111, -72, -90, -70, -53}, "0371c9ac", 0.0f));
                    break;
                case 54425861:
                    int i20 = f33 * (f30 + 7738);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-20, -101, -67, -107, -65, -110, -19, -109}, "79f6d062b355", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۨ۟ۧ, reason: not valid java name and contains not printable characters */
    public static String m189() {
        int iM321 = C0003.m321(C0010.decode(new byte[]{-24, -104, -21, -85, -30, -111, -71, -60}, "390494bf", 0.0f));
        while (true) {
            switch (iM321) {
                case 54178856:
                    int i = f33 * (f30 ^ 4881);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-30, -59, -65, -90, -67, -106, -30, -60}, "9ad9f5", 0.0f));
                    break;
                case 54183907:
                    int i2 = f33 * (f30 + 1074);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-17, -105, -72, -112, -19, -59, -21, -84}, "42c46d0379cdc3"));
                    break;
                case 54185606:
                    int i3 = f33 * (f30 + 6833);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-19, -51, -70, -99, -18, -105, -72, -62}, "6ea557ce", true));
                    break;
                case 54187628:
                    int i4 = f33 * (f30 ^ 7440);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-21, -61, -66, -112, -67, -61, -65, -106}, "0de0fed05e3e38dd", 0.0f));
                    break;
                case 54208827:
                    int i5 = f33 * (f30 ^ 7457);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-17, -105, -19, -87, -65, -59, -30, -110}, "4566df9632", 0.0f));
                    break;
                case 54211561:
                    int i6 = f33 * (f30 + 36);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-67, -60, -21, -86, -66, -83, -29, -98}, "fd05e286eed428", 0.0f));
                    break;
                case 54215584:
                    int i7 = f33 * (f30 ^ 7755);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-65, -99, -65, -57, -19, -109, -65, -84}, "d5db65d36167fb86", 4));
                    break;
                case 54238558:
                    int i8 = f33 * (f30 ^ 6741);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-72, -107, -23, -111, -66, -106, -72, -81}, "c024e6"));
                    break;
                case 54240606:
                    int i9 = f33 * (f30 + 2559);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-71, -109, -65, -54, -24, -59, -70, -109}, "b3db3fa42f6684", 0.0f));
                    break;
                case 54274080:
                    int i10 = f33 * (f30 ^ 7620);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-20, -64, -66, -104, -19, -110, -20, -58}, "7de965"));
                    break;
                case 54276902:
                    int i11 = f33 * (f30 | 1757);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-17, -61, -30, -112, -71, -108, -24, -111}, "4a91b3373884"));
                    break;
                case 54298141:
                    int i12 = f33 * (f30 + 1016);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-30, -111, -66, -63, -17, -109, -65, -111}, "92ed41d11ec6"));
                    break;
                case 54300184:
                    int i13 = f33 * (f30 ^ 113);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-24, -111, -23, -110, -29, -106, -21, -64}, "3126810fad", true));
                    break;
                case 54306761:
                    int i14 = f33 * (f30 | 4968);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-72, -62, -67, -54, -17, -61, -17, -64}, "cafb4c4aaf6e7b30"));
                    break;
                case 54332669:
                    int i15 = f33 * (f30 ^ 1293);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-72, -112, -21, -110, -70, -60, -66, -59}, "c704abea5bf081", true));
                    break;
                case 54333599:
                    int i16 = f33 * (f30 | 580);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-30, -108, -29, -111, -23, -111, -72, -102}, "958321c22ecf"));
                    break;
                case 54334724:
                    int i17 = f33 * (f30 + 6374);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-67, -61, -21, -105, -21, -97, -19, -103}, "fb010968689209b4", 0));
                    break;
                case 54388569:
                    if (OUHQwdrD.m42() <= 0) {
                        return m181();
                    }
                    return null;
                case 54391507:
                    int i18 = f33 * (f30 + 8059);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-18, -59, -20, -111, -19, -60, -71, -62}, "5e776dbb4f915f", 0.0f));
                    break;
                case 54394333:
                    int i19 = f33 * (f30 | 7510);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-17, -105, -29, -108, -21, -100, -20, -85}, "40870474e14a", 0.0f));
                    break;
                case 54423158:
                    int i20 = f33 * (f30 + 6085);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-70, -62, -22, -102, -20, -63, -70, -63}, "af127c"));
                    break;
                case 54425863:
                    int i21 = f33 * (f30 + 5532);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-29, -64, -23, -109, -67, -109, -21, -104}, "8e25f600", 2));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۥۥ۠, reason: not valid java name and contains not printable characters */
    private static String m190() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-67, -59, -72, -110, -70, -62, -71, -109}, "fcc5afb3c1d7d3"));
        while (true) {
            switch (iM336) {
                case 54156846:
                    int i = f33 * (f30 ^ 7902);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-65, -59, -29, -61, -17, -4, -65, -64}, "da8b4c", 2));
                    break;
                case 54178944:
                    int i2 = f33 * (f30 | 1414);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-67, -59, -72, -102, -23, -82, -19, -62}, "fcc8216ffd7af1", false));
                    break;
                case 54240541:
                    int i3 = f33 * (f30 ^ 5400);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-65, -109, -18, -62, -71, -61, -72, -108}, "d55ebbc64c", false));
                    break;
                case 54271104:
                    int i4 = f33 * (f30 | 6080);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-70, -58, -72, -88, -22, -109, -23, -63}, "afc7112b5985db2e", 0.0f));
                    break;
                case 54274083:
                    int i5 = f33 * (f30 | 1934);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-71, -100, -21, -4, -20, -104, -71, -99}, "b80c78", true));
                    break;
                case 54298048:
                    int i6 = f33 * (f30 + 1809);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-20, -98, -71, -61, -21, -57, -66, -102}, "78bf0fe80e19", 0.0f));
                    break;
                case 54299935:
                    int i7 = f33 * (f30 ^ 7917);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-22, -111, -20, -108, -29, -106, -20, -99}, "16708778e24c9a", 0.0f));
                    break;
                case 54301860:
                    int i8 = f33 * (f30 ^ 3179);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-71, -105, -30, -63, -72, -97, -21, -108}, "b39dc8079b07f779"));
                    break;
                case 54304029:
                    int i9 = f33 * (f30 ^ 7454);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-18, -111, -70, -101, -66, -105, -30, -108}, "57a8e493f3fb51", 0.0f));
                    break;
                case 54332709:
                    int i10 = f33 * (f30 | 829);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-72, -106, -18, -102, -17, -98, -72, -107}, "c15848"));
                    break;
                case 54360481:
                    int i11 = f33 * (f30 + 5469);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-67, -97, -72, -61, -66, -107, -66, -111}, "f7cbe4e0138a4280", 2));
                    break;
                case 54361569:
                    int i12 = f33 * (f30 + 5377);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-71, -107, -30, -59, -22, -60, -18, -105}, "b39b1b531f", false));
                    break;
                case 54363424:
                    int i13 = f33 * (f30 ^ 2686);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-18, -63, -21, -108, -17, -111, -29, -53}, "5d00438c", 0.0f));
                    break;
                case 54365346:
                    int i14 = f33 * (f30 | 355);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-29, -108, -65, -109, -71, -3, -72, -111}, "80d0bbc5aac4", 0));
                    break;
                case 54365437:
                    int i15 = f33 * (f30 | 5498);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-67, -53, -17, -111, -19, -108, -66, -99}, "fc4666e552e8889d"));
                    break;
                case 54365503:
                    int i16 = f33 * (f30 + 2790);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-22, -97, -67, -106, -72, -108, -67, -108}, "17f6c6f4aafee9", false));
                    break;
                case 54390489:
                    return C0009.m350(f36, 61, 1659138844 ^ C0005.f69, 23);
                case 54392257:
                    int i17 = f33 * (f30 + 5523);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-19, -62, -65, -60, -70, -108, -67, -105}, "6adaa6f4", 5));
                    break;
                case 54418230:
                    int i18 = f33 * (f30 ^ 2113);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-30, -3, -70, -105, -21, -106, -66, -99}, "9ba004e525c9d377", false));
                    break;
                case 54419161:
                    int i19 = f33 * (f30 | 2548);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-70, -57, -29, -109, -66, -64, -70, -58}, "ae82ee", 0.0f));
                    break;
                case 54424965:
                    int i20 = f33 * (f30 ^ 8093);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-66, -112, -29, -102, -23, -6, -66, -109}, "e3882e", 3));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۧۦۦ, reason: not valid java name and contains not printable characters */
    public static String m191() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-67, -53, -22, -110, -65, -81, -67, -4}, "fc10d0", true));
        while (true) {
            switch (iM336) {
                case 54151197:
                    int i = f33 * (f30 + 4);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-30, -111, -67, -108, -22, -61, -22, -109}, "90f61f10eb"));
                    break;
                case 54184901:
                    int i2 = f33 * (f30 ^ 5167);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-66, -61, -30, -110, -20, -59, -67, -106}, "ef977ef686f8", 7));
                    break;
                case 54186754:
                    int i3 = f33 * (f30 + 3563);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-66, -109, -72, -63, -67, -54, -66, -101}, "e3cdfb", 3));
                    break;
                case 54186792:
                    int i4 = f33 * (f30 | 4253);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-23, -64, -23, -105, -23, -99, -22, -3}, "2e23291befd4"));
                    break;
                case 54211711:
                    int i5 = f33 * (f30 | 6250);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-67, -62, -24, -63, -67, -112, -67, -111}, "fc3bf4f2"));
                    break;
                case 54212641:
                    int i6 = f33 * (f30 ^ 7547);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-19, -64, -22, -100, -24, -101, -66, -3}, "6d1933eb0bc5a9", 6));
                    break;
                case 54215369:
                    int i7 = f33 * (f30 ^ 5738);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-66, -102, -30, -60, -66, -61, -18, -62}, "e29ded5a", 1));
                    break;
                case 54217292:
                    int i8 = f33 * (f30 ^ 7552);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-67, -63, -67, -59, -19, -107, -18, -7}, "fdfa625f34"));
                    break;
                case 54238460:
                    int i9 = f33 * (f30 ^ 3875);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-17, -111, -20, -50, -24, -6, -70, -58}, "407f3eab819e34", 0.0f));
                    break;
                case 54272320:
                    int i10 = f33 * (f30 | 1028);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-70, -102, -67, -109, -70, -88, -65, -108}, "a2f2a7d52dfe5759"));
                    break;
                case 54298266:
                    int i11 = f33 * (f30 ^ 2526);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-21, -105, -18, -111, -72, -108, -71, -59}, "0250c2bfeefa"));
                    break;
                case 54304056:
                    int i12 = f33 * (f30 + 1784);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-72, -106, -66, -4, -65, -110, -30, -7}, "c4ecd29ff409b9"));
                    break;
                case 54328084:
                    if (m156() < 0) {
                        return m169();
                    }
                    return null;
                case 54329945:
                    int i13 = f33 * (f30 ^ 327);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-23, -5, -24, -59, -67, -64, -22, -105}, "2d3dff16", 1));
                    break;
                case 54332762:
                    int i14 = f33 * (f30 | 943);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-20, -61, -70, -97, -70, -7, -21, -105}, "7ba9af045503c011", 3));
                    break;
                case 54332855:
                    int i15 = f33 * (f30 | 3817);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-17, -111, -23, -101, -29, -97, -22, -62}, "4228881e02401b8c", 5));
                    break;
                case 54333600:
                    int i16 = f33 * (f30 ^ 128);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-21, -109, -18, -81, -70, -104, -18, -58}, "0650a05d2633", 0.0f));
                    break;
                case 54359741:
                    int i17 = f33 * (f30 + 6166);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-20, -105, -65, -106, -65, -64, -70, -103}, "70d3dba96e4ae3", 0));
                    break;
                case 54393244:
                    int i18 = f33 * (f30 + 4887);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-67, -111, -23, -84, -71, -97, -22, -109}, "f523b81574fb", 0.0f));
                    break;
                case 54418388:
                    int i19 = f33 * (f30 ^ 2131);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-22, -57, -70, -111, -18, -97, -29, -54}, "1aa0598b5f78", true));
                    break;
                case 54419099:
                    int i20 = f33 * (f30 + 1249);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-65, -107, -66, -107, -17, -98, -67, -107}, "d5e248f4a290"));
                    break;
                case 54420058:
                    int i21 = f33 * (f30 | 5705);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-65, -58, -20, -97, -17, -62, -65, -50}, "df784e", 0.0f));
                    break;
            }
        }
    }
}
