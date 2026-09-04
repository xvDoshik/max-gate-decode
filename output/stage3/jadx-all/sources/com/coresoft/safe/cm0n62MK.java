package com.coresoft.safe;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import p000.p001.C0010;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage3/dex/classes8.dex */
public class cm0n62MK {

    /* JADX INFO: renamed from: ۟۟ۥۨۢ, reason: not valid java name and contains not printable characters */
    public static int f24 = 1368812109;

    /* JADX INFO: renamed from: ۡۨۧۤۢ, reason: not valid java name and contains not printable characters */
    private static String f25 = null;

    /* JADX INFO: renamed from: ۣ۠ۤۤ, reason: not valid java name and contains not printable characters */
    public static int f26 = 853849942;

    /* JADX INFO: renamed from: ۤۡۨ۠, reason: not valid java name and contains not printable characters */
    private static String f27;

    /* JADX INFO: renamed from: ۦۢۦۡۧ, reason: contains not printable characters */
    private static short[] f28 = {-20107, -20111, -20152, -27256, -27201, -27258, -6441, -6444, -6441, 28878, 28921, 28921, 17518, 17511, 17497, -13530, -13530, -22436, -22438, -22428, 20903, 20897, 20902, -30904, -30902, -30901, 15460, 15459, 15458, -2859, -2859, -2861, -13398, -13399, -13393, -18268, -18258, -18264, -21022, -21024, -21020, -31434, -31440, -31439, -22797, -22797, -22797, -20313, -20326, -20326, 20818, 20818, -12502, -12521, -12526, 23512, 23517, 23506, 29812, 29812, 29817, -3051, -3049, -3055, -20663, -20670, -20672, -24794, -24795, -24796, 20721, 20730, 20728, 23514, 23512, 23512, -15175, -15184, -15179, -847, -846, -848, -1026, -1082, -1027, 24047, 24036, 24035, -5734, -5729, -5732, 25646, 25642, 25647, -20704, -20701, -20697, 21797, 21799, 21797, 24303, 24297, 24303, -7327, -7329, -7327, 26794, 26796, 32058, 32054, 32053, 3348, 3349, -11732, -11734, -11730, 13869, 13871, 13866, 11051, 11053, 11055, -14619, -14609, -14614, -32424, -32422, -32419, -17471, -17468, -17462, -6859, -6850, -6859, -2405, -2405, -2394, 7187, 7188, 7188, 3765, 3721, 3765};

    /* JADX INFO: renamed from: ۧۢ۟ۡ۟ۧ, reason: not valid java name and contains not printable characters */
    private static int f29;

    private static Object a(ClassLoader classLoader) {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-22, -61, -67, -107, -29, -62, -22, -58}, "1cf18c"));
        while (true) {
            switch (iM330) {
                case 54149093:
                    int i = f26 * (f24 + 5023);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-20, -106, -18, -87, -20, -61, -65, -63}, "70567dda", 6));
                    break;
                case 54155079:
                    int i2 = f26 * (f24 | 5852);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-67, -61, -30, -98, -18, -90, -66, -52}, "fc9859ed17", 0.0f));
                    break;
                case 54181983:
                    int i3 = f26 * (f24 + 2189);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-66, -111, -70, -62, -21, -105, -19, -58}, "e9ab026fc4", 0.0f));
                    break;
                case 54182943:
                    int i4 = f26 * (f24 | 1805);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-24, -57, -22, -86, -17, -106, -24, -99}, "3a154038", 0.0f));
                    break;
                case 54183720:
                    int i5 = f26 * (f24 | 5467);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-19, -97, -30, -107, -67, -99, -18, -108}, "6993f8549461a224", 0));
                    break;
                case 54185583:
                    int i6 = f26 * (f24 + 2271);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-17, -112, -19, -99, -67, -86, -17, -108}, "4665f544", 0.0f));
                    break;
                case 54216576:
                    int i7 = f26 * (f24 | 7184);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-30, -102, -67, -50, -18, -108, -23, -57}, "98ff552fbb", 0.0f));
                    break;
                case 54244446:
                    int i8 = f26 * (f24 | 3380);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-30, -62, -67, -106, -17, -108, -18, -58}, "9bf4435b", false));
                    break;
                case 54247142:
                    int i9 = f26 * (f24 ^ 6978);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-29, -3, -67, -99, -22, -59, -29, -54}, "8bf81b", false));
                    break;
                case 54268441:
                    int i10 = f26 * (f24 | 7717);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-71, -97, -24, -60, -71, -99, -29, -110}, "b93eb8803c", false));
                    break;
                case 54270267:
                    int i11 = f26 * (f24 | 6327);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-20, -104, -29, -64, -30, -111, -20, -101}, "788c96", 0.0f));
                    break;
                case 54302018:
                    int i12 = f26 * (f24 + 206);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-19, -59, -19, -106, -20, -102, -66, -111}, "6b6078e4"));
                    break;
                case 54303009:
                    int i13 = f26 * (f24 + 6902);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-21, -6, -67, -85, -18, -109, -21, -64}, "0ef453", 3));
                    break;
                case 54357816:
                    String strM102 = m102();
                    Class<ClassLoader> cls = null;
                    Object obj = null;
                    String str = null;
                    Field field = null;
                    while (true) {
                        switch (fyhCtVnu.m182(strM102)) {
                            case 1746975:
                                return obj;
                            case 1747773:
                                String strM275 = yGhVwXcV.m275();
                                strM102 = m103();
                                str = strM275;
                                break;
                            case 1749787:
                                cls = ClassLoader.class;
                                strM102 = m123();
                                break;
                            case 1755343:
                                Object objM284 = yGhVwXcV.m284(field, classLoader);
                                strM102 = m129();
                                obj = objM284;
                                break;
                            case 1755398:
                                Field fieldM162 = fyhCtVnu.m162(cls, str);
                                strM102 = m132();
                                field = fieldM162;
                                break;
                            default:
                                yGhVwXcV.m259(field, true);
                                strM102 = m106();
                                break;
                        }
                    }
                    break;
                case 54357842:
                    int i14 = f26 * (f24 ^ 4974);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-24, -111, -65, -63, -18, -62, -21, -58}, "35db5f0a64fd4b", 2));
                    break;
                case 54359704:
                    int i15 = f26 * (f24 | 976);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-70, -112, -70, -110, -19, -86, -24, -109}, "a8a36536aad4c1e6"));
                    break;
                case 54362561:
                    int i16 = f26 * (f24 | 6183);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-29, -57, -67, -62, -18, -110, -22, -61}, "8ffe551bf92e2528", 0.0f));
                    break;
                case 54364507:
                    int i17 = f26 * (f24 + 4283);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-18, -111, -23, -108, -71, -60, -70, -63}, "5321bcac02", true));
                    break;
                case 54366243:
                    int i18 = f26 * (f24 | 6142);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-72, -57, -24, -87, -70, -105, -18, -112}, "cd36a153", true));
                    break;
                case 54394210:
                    int i19 = f26 * (f24 | 5117);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-30, -112, -66, -107, -30, -62, -67, -58}, "98e79cff2c1a", 0.0f));
                    break;
                case 54418323:
                    int i20 = f26 * (f24 + 4362);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-19, -59, -24, -59, -24, -106, -29, -59}, "6a3a338cc3fb33", 4));
                    break;
                case 54419103:
                    int i21 = f26 * (f24 ^ 1569);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-21, -105, -70, -105, -23, -107, -17, -61}, "04a6264ca8", true));
                    break;
                case 54420121:
                    int i22 = f26 * (f24 ^ 6314);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-65, -57, -72, -64, -71, -112, -29, -97}, "dacdb48856e2", false));
                    break;
            }
        }
    }

    public static void apply(Context context, byte[] bArr) {
        int iM321 = C0003.m321(C0010.decode(new byte[]{-17, -58, -72, -58, -22, -63, -17, -55}, "4acc1f"));
        while (true) {
            switch (iM321) {
                case 54155040:
                    int i = f26 * (f24 | 2082);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-20, -98, -71, -109, -70, -105, -18, -59}, "79b2a45f3f", 0.0f));
                    break;
                case 54179874:
                    int i2 = f26 * (f24 | 2164);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-71, -104, -66, -64, -24, -60, -23, -111}, "b9eb3f2267", true));
                    break;
                case 54211618:
                    ClassLoader classLoaderM50 = OUHQwdrD.m50(context);
                    String strM96 = m96(context, bArr);
                    m95(context, strM96);
                    int i3 = 1616;
                    while (true) {
                        i3 ^= 1633;
                        switch (i3) {
                            case 14:
                                try {
                                    ClassLoader classLoaderM148 = m148(strM96, OUHQwdrD.m46(OUHQwdrD.m54(context)), m105(classLoaderM50));
                                    m141(classLoaderM50, classLoaderM148);
                                    m94(classLoaderM50, classLoaderM148);
                                    int i4 = 1740;
                                    while (true) {
                                        i4 ^= 1757;
                                        switch (i4) {
                                            case 17:
                                                i4 = 1771;
                                                break;
                                            case 54:
                                                return;
                                        }
                                    }
                                } catch (Throwable th) {
                                    return;
                                }
                                break;
                            case 49:
                                i3 = 1647;
                                break;
                        }
                    }
                    break;
                case 54239645:
                    int i5 = f26 * (f24 + 479);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-24, -108, -30, -109, -23, -59, -19, -57}, "36962f6b66"));
                    break;
                case 54241345:
                    int i6 = f26 * (f24 ^ 7636);
                    iM321 = C0005.m330(C0010.decode(new byte[]{-65, -63, -21, -99, -30, -111, -65, -109}, "db0597d3a4f7", false));
                    break;
                case 54244325:
                    int i7 = f26 * (f24 ^ 1985);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-24, -110, -24, -64, -66, -59, -67, -64}, "313aeffaf293bc", 0.0f));
                    break;
                case 54247238:
                    int i8 = f26 * (f24 ^ 2427);
                    iM321 = C0009.m349(C0010.decode(new byte[]{-71, -57, -22, -110, -20, -59, -17, -100}, "bb137d4481"));
                    break;
                case 54270268:
                    int i9 = f26 * (f24 + 7236);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-66, -55, -70, -109, -70, -3, -18, -111}, "eaa7ab547686", 2));
                    break;
                case 54273310:
                    int i10 = f26 * (f24 + 7062);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-24, -109, -17, -105, -72, -4, -70, -111}, "3646cca786"));
                    break;
                case 54277087:
                    int i11 = f26 * (f24 | 3927);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-66, -63, -29, -97, -20, -99, -72, -106}, "ed8778c65bf98ee2", false));
                    break;
                case 54298168:
                    int i12 = f26 * (f24 + 2366);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-17, -108, -72, -57, -19, -5, -65, -111}, "42ce6dd7", 0.0f));
                    break;
                case 54329731:
                    int i13 = f26 * (f24 | 4957);
                    iM321 = C0009.m349(C0010.decode(new byte[]{-20, -111, -67, -62, -20, -110, -70, -102}, "71fb73a9178ba778", 0.0f));
                    break;
                case 54329795:
                    int i14 = f26 * (f24 ^ 3100);
                    iM321 = C0006.m336(C0010.decode(new byte[]{-19, -102, -66, -62, -17, -63, -19, -57}, "68eb4f6a03fd8b"));
                    break;
                case 54336638:
                    int i15 = f26 * (f24 ^ 4914);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-18, -109, -30, -61, -65, -58, -70, -107}, "549ddfa3f7", 0.0f));
                    break;
                case 54358835:
                    int i16 = f26 * (f24 ^ 2615);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-72, -63, -66, -101, -23, -61, -71, -108}, "cce92cb5c0", false));
                    break;
                case 54360483:
                    int i17 = f26 * (f24 ^ 7164);
                    iM321 = C0005.m330(C0010.decode(new byte[]{-29, -105, -17, -106, -18, -98, -23, -110}, "84425627", 0.0f));
                    break;
                case 54389434:
                    int i18 = f26 * (f24 ^ 7257);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-30, -100, -22, -87, -72, -107, -30, -103}, "9816c1"));
                    break;
                case 54393407:
                    int i19 = f26 * (f24 ^ 1551);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-70, -109, -21, -50, -67, -105, -72, -64}, "a10ff3cd43e9301d", true));
                    break;
                case 54395110:
                    int i20 = f26 * (f24 + 2271);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-65, -84, -70, -57, -20, -108, -21, -111}, "d3ab7201f9eb3b", 6));
                    break;
                case 54421986:
                    int i21 = f26 * (f24 ^ 7404);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-17, -108, -66, -110, -19, -98, -17, -109}, "42e266", false));
                    break;
            }
        }
    }

    private static ClassLoader b(String str, String str2, Object obj) {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-18, -61, -29, -106, -18, -86, -18, -63}, "5e8755"));
        while (true) {
            switch (iM316) {
                case 54150981:
                    int i = f26 * (f24 ^ 7150);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-67, -104, -72, -106, -24, -111, -21, -111}, "f9c13006"));
                    break;
                case 54154017:
                    int i2 = f26 * (f24 ^ 2580);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-23, -53, -20, -55, -72, -110, -66, -108}, "2c7ac3e5733d68"));
                    break;
                case 54154888:
                    int i3 = f26 * (f24 | 7499);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-29, -112, -19, -106, -22, -108, -19, -103}, "88601061d524299f"));
                    break;
                case 54156068:
                    int i4 = f26 * (f24 ^ 2937);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-23, -108, -18, -111, -30, -97, -19, -101}, "265198631b326d25"));
                    break;
                case 54210722:
                    int i5 = f26 * (f24 | 8085);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-65, -63, -71, -108, -65, -109, -20, -107}, "deb7d27488a6"));
                    break;
                case 54216396:
                    int i6 = f26 * (f24 ^ 4115);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-24, -4, -29, -62, -71, -112, -72, -61}, "3c8db8cf"));
                    break;
                case 54239611:
                    int i7 = f26 * (f24 + 1562);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-29, -81, -67, -106, -18, -104, -29, -109}, "80f359"));
                    break;
                case 54239647:
                    int i8 = f26 * (f24 + 3965);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-23, -5, -17, -111, -24, -63, -66, -109}, "2d453ee3a9"));
                    break;
                case 54239671:
                    int i9 = f26 * (f24 | 3203);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-17, -57, -23, -108, -72, -60, -67, -110}, "4e21cdf6"));
                    break;
                case 54240390:
                    int i10 = f26 * (f24 + 6178);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-66, -61, -70, -54, -65, -107, -20, -105}, "efabd3754d348b"));
                    break;
                case 54241476:
                    int i11 = f26 * (f24 + 4014);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-19, -105, -71, -106, -70, -103, -29, -59}, "65b7a98bb6"));
                    break;
                case 54244231:
                    int i12 = f26 * (f24 | 3795);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-17, -105, -30, -111, -18, -51, -17, -112}, "42935e"));
                    break;
                case 54298172:
                    int i13 = f26 * (f24 | 3075);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-18, -64, -17, -109, -67, -110, -65, -60}, "5a42f6db70fc5220"));
                    break;
                case 54301919:
                    int i14 = f26 * (f24 | 6995);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-18, -85, -65, -110, -23, -82, -65, -61}, "54d321dac722d5d8"));
                    break;
                case 54330967:
                    int i15 = f26 * (f24 ^ 2303);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-72, -110, -71, -104, -17, -112, -72, -108}, "c4b944c0"));
                    break;
                case 54336671:
                    int i16 = f26 * (f24 | 1519);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-21, -111, -17, -111, -30, -108, -67, -58}, "064597fd46e1a1"));
                    break;
                case 54359520:
                    int i17 = f26 * (f24 ^ 5850);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-20, -64, -19, -112, -71, -111, -22, -111}, "7b62b5190b44"));
                    break;
                case 54359675:
                    int i18 = f26 * (f24 | 3224);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-18, -109, -17, -111, -71, -105, -18, -110}, "5141b1"));
                    break;
                case 54364387:
                    String str3 = null;
                    Class cls = null;
                    Class[] clsArr = null;
                    Class cls2 = null;
                    Class cls3 = null;
                    Constructor constructor = null;
                    Object objM55 = null;
                    ClassLoader classLoader = null;
                    String strM138 = m138();
                    Object[] objArr = null;
                    while (true) {
                        switch (fyhCtVnu.m182(strM138)) {
                            case 1746788:
                                clsArr[1] = cls2;
                                strM138 = m113();
                                break;
                            case 1747686:
                                strM138 = m124();
                                cls3 = ClassLoader.class;
                                break;
                            case 1747745:
                                return classLoader;
                            case 1747867:
                                strM138 = m112();
                                classLoader = (ClassLoader) objM55;
                                break;
                            case 1749570:
                                Constructor constructorM285 = yGhVwXcV.m285(cls, clsArr);
                                strM138 = m146();
                                constructor = constructorM285;
                                break;
                            case 1749827:
                                clsArr[3] = cls3;
                                strM138 = m150();
                                break;
                            case 1750722:
                                strM138 = m121();
                                objArr = new Object[4];
                                break;
                            case 1751652:
                                objArr[0] = str;
                                strM138 = m133();
                                break;
                            case 1752550:
                                clsArr[0] = cls2;
                                strM138 = m111();
                                break;
                            case 1752648:
                                objArr[2] = null;
                                strM138 = m100();
                                break;
                            case 1752671:
                                strM138 = m104();
                                cls2 = String.class;
                                break;
                            case 1752703:
                                clsArr[2] = cls2;
                                strM138 = m144();
                                break;
                            case 1752705:
                                objArr[3] = obj;
                                strM138 = m120();
                                break;
                            case 1754437:
                                String strM199 = hYNP32vq.m199();
                                strM138 = m127();
                                str3 = strM199;
                                break;
                            case 1754536:
                                Class clsM177 = fyhCtVnu.m177(str3);
                                strM138 = m134();
                                cls = clsM177;
                                break;
                            case 1755434:
                                strM138 = m149();
                                clsArr = new Class[4];
                                break;
                            case 1755462:
                                objArr[1] = str2;
                                strM138 = m145();
                                break;
                            default:
                                objM55 = OUHQwdrD.m55(constructor, objArr);
                                strM138 = m99();
                                break;
                        }
                    }
                    break;
                case 54392316:
                    int i19 = f26 * (f24 | 2154);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-65, -110, -30, -6, -70, -105, -65, -109}, "d69ea3"));
                    break;
                case 54424066:
                    int i20 = f26 * (f24 | 1737);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-17, -60, -70, -110, -29, -104, -17, -58}, "4ba489"));
                    break;
                case 54425888:
                    int i21 = f26 * (f24 ^ 1276);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-18, -107, -20, -104, -22, -54, -65, -57}, "57781bdff67b70"));
                    break;
            }
        }
    }

    private static void c(ClassLoader classLoader, ClassLoader classLoader2) throws IllegalAccessException {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-19, -63, -19, -106, -22, -64, -22, -7}, "6c671c1f7b", 0));
        while (true) {
            switch (iM316) {
                case 54153991:
                    int i = f26 * (f24 | 3468);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-19, -109, -72, -110, -66, -60, -20, -107}, "63c0ef74a0e9cdc5"));
                    break;
                case 54157772:
                    int i2 = f26 * (f24 + 6295);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-66, -51, -30, -86, -30, -59, -20, -110}, "ee959b7379", 0.0f));
                    break;
                case 54157798:
                    int i3 = f26 * (f24 | 4542);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-70, -107, -23, -111, -66, -105, -29, -55}, "a326e48a49", false));
                    break;
                case 54180030:
                    int i4 = f26 * (f24 | 2610);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-66, -99, -67, -57, -18, -108, -22, -105}, "e9fc5210f1f206", 1));
                    break;
                case 54181825:
                    int i5 = f26 * (f24 + 8040);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-66, -111, -17, -59, -30, -60, -71, -112}, "e14e9bb4983e", true));
                    break;
                case 54210843:
                    String strM108 = m108();
                    Class<ClassLoader> cls = null;
                    String str = null;
                    Field field = null;
                    while (true) {
                        switch (fyhCtVnu.m182(strM108)) {
                            case 1750595:
                                yGhVwXcV.m259(field, true);
                                strM108 = m116();
                                break;
                            case 1752675:
                                return;
                            case 1754380:
                                yGhVwXcV.m256(field, classLoader, classLoader2);
                                strM108 = m117();
                                break;
                            case 1755462:
                                cls = ClassLoader.class;
                                strM108 = m98();
                                break;
                            case 1755465:
                                String strM275 = yGhVwXcV.m275();
                                strM108 = m151();
                                str = strM275;
                                break;
                            default:
                                Field fieldM162 = fyhCtVnu.m162(cls, str);
                                strM108 = m136();
                                field = fieldM162;
                                break;
                        }
                    }
                    break;
                case 54211554:
                    int i6 = f26 * (f24 + 6150);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-66, -107, -30, -107, -70, -61, -67, -63}, "e797acfa3aa7"));
                    break;
                case 54240475:
                    int i7 = f26 * (f24 ^ 2977);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-18, -90, -65, -100, -21, -57, -67, -100}, "59d80df97815"));
                    break;
                case 54241344:
                    int i8 = f26 * (f24 ^ 5740);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-18, -102, -67, -106, -30, -109, -24, -81}, "59f19330", 0.0f));
                    break;
                case 54275939:
                    int i9 = f26 * (f24 | 2068);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-19, -101, -20, -107, -71, -109, -19, -104}, "6872b2", false));
                    break;
                case 54275971:
                    int i10 = f26 * (f24 | 7497);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-20, -110, -19, -62, -65, -108, -19, -111}, "756dd161", 0.0f));
                    break;
                case 54303041:
                    int i11 = f26 * (f24 ^ 990);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-70, -97, -30, -60, -66, -108, -66, -110}, "a99be2e3a1e193", 0.0f));
                    break;
                case 54305891:
                    int i12 = f26 * (f24 | 3393);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-21, -100, -23, -101, -70, -108, -71, -102}, "0929a6b91a4431", false));
                    break;
                case 54330782:
                    int i13 = f26 * (f24 ^ 1242);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-72, -6, -17, -54, -24, -107, -29, -105}, "ce4b3483bd9b06", 0.0f));
                    break;
                case 54364513:
                    int i14 = f26 * (f24 ^ 505);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-18, -101, -18, -57, -22, -107, -67, -111}, "535f10f711e69f4d", 0.0f));
                    break;
                case 54364539:
                    int i15 = f26 * (f24 + 3953);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-29, -88, -22, -50, -30, -61, -29, -88}, "871f9a"));
                    break;
                case 54365414:
                    int i16 = f26 * (f24 + 7610);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-17, -59, -20, -63, -24, -110, -17, -111}, "4a7f374431998a", 0));
                    break;
                case 54394298:
                    int i17 = f26 * (f24 | 3198);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-65, -59, -21, -107, -21, -111, -30, -106}, "dc030490af105560", 0.0f));
                    break;
                case 54417425:
                    int i18 = f26 * (f24 | 2475);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-19, -97, -20, -98, -66, -89, -19, -112}, "6778e8", 7));
                    break;
                case 54419290:
                    int i19 = f26 * (f24 | 7525);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-71, -107, -21, -108, -72, -101, -71, -105}, "b405c3", 5));
                    break;
                case 54423910:
                    int i20 = f26 * (f24 + 7957);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-20, -61, -70, -108, -71, -109, -20, -61}, "7ba6b3", false));
                    break;
            }
        }
    }

    private static void d(ClassLoader classLoader, ClassLoader classLoader2) throws IllegalAccessException {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-70, -62, -71, -62, -18, -103, -67, -97}, "aabd51f82b11", 3));
        while (true) {
            switch (iM316) {
                case 54183873:
                    int i = f26 * (f24 ^ 3916);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-66, -102, -20, -63, -23, -107, -71, -54}, "e97f21bb92aed2"));
                    break;
                case 54210688:
                    int i2 = f26 * (f24 | 8178);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-71, -103, -17, -108, -72, -60, -66, -112}, "b141cde3"));
                    break;
                case 54214471:
                    int i3 = f26 * (f24 ^ 118);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-70, -57, -66, -112, -21, -6, -66, -109}, "abe10ee5cb7b41"));
                    break;
                case 54239522:
                    int i4 = f26 * (f24 ^ 2057);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-71, -111, -67, -59, -65, -103, -71, -58}, "b6ffd1ba46e80d", 0.0f));
                    break;
                case 54243457:
                    int i5 = f26 * (f24 ^ 3531);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-21, -64, -67, -103, -65, -107, -21, -58}, "0cf8d5", 5));
                    break;
                case 54270179:
                    int i6 = f26 * (f24 | 2650);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-24, -109, -66, -57, -22, -103, -66, -57}, "32eb18ec2feb", 2));
                    break;
                case 54275234:
                    int i7 = f26 * (f24 ^ 5212);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-24, -60, -66, -105, -66, -59, -24, -54}, "3ce0eb3b3ee2", 6));
                    break;
                case 54276072:
                    int i8 = f26 * (f24 ^ 4346);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-23, -110, -30, -101, -20, -112, -23, -98}, "269377", true));
                    break;
                case 54298981:
                    int i9 = f26 * (f24 | 1990);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-22, -107, -21, -61, -24, -64, -66, -107}, "140b3ce6e4", 0.0f));
                    break;
                case 54299163:
                    int i10 = f26 * (f24 | 6764);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-22, -62, -70, -64, -21, -109, -72, -109}, "1fac05c7fa", false));
                    break;
                case 54302077:
                    int i11 = f26 * (f24 ^ 629);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-30, -59, -30, -50, -71, -107, -23, -64}, "9a9fb32f", 0.0f));
                    break;
                case 54306884:
                    int i12 = f26 * (f24 + 186);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-71, -55, -29, -6, -67, -111, -30, -109}, "ba8ef0931f89", true));
                    break;
                case 54306917:
                    int i13 = f26 * (f24 | 1756);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-67, -98, -70, -58, -24, -108, -18, -86}, "f8ae3255", 0.0f));
                    break;
                case 54329731:
                    int i14 = f26 * (f24 + 5207);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-22, -60, -19, -4, -29, -63, -65, -4}, "1b6c8bdc", 7));
                    break;
                case 54335522:
                    int i15 = f26 * (f24 + 6009);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-66, -64, -71, -100, -23, -60, -67, -105}, "ebb82bf20f7878", 0));
                    break;
                case 54357717:
                    String strM142 = m142();
                    Object objM284 = null;
                    Object obj = null;
                    Object obj2 = null;
                    Class cls = null;
                    Field field = null;
                    String str = null;
                    while (true) {
                        switch (fyhCtVnu.m182(strM142)) {
                            case 56321:
                                Object objM285 = yGhVwXcV.m284(field, objM284);
                                strM142 = m119();
                                obj2 = objM285;
                                break;
                            case 56478:
                                Field fieldM162 = fyhCtVnu.m162(cls, str);
                                strM142 = m139();
                                field = fieldM162;
                                break;
                            case 1746690:
                                yGhVwXcV.m259(field, true);
                                strM142 = m101();
                                break;
                            case 1748611:
                                Field fieldM163 = fyhCtVnu.m162(cls, str);
                                strM142 = m115();
                                field = fieldM163;
                                break;
                            case 1748740:
                                Object objM286 = yGhVwXcV.m284(field, objM284);
                                strM142 = m110();
                                obj2 = objM286;
                                break;
                            case 1748863:
                                objM284 = yGhVwXcV.m284(field, classLoader);
                                strM142 = m135();
                                break;
                            case 1749762:
                                yGhVwXcV.m256(field, obj, obj2);
                                strM142 = m109();
                                break;
                            case 1750600:
                                String strM75 = OUHQwdrD.m75();
                                strM142 = m137();
                                str = strM75;
                                break;
                            case 1750757:
                                return;
                            case 1751529:
                                String strM201 = hYNP32vq.m201();
                                strM142 = m97();
                                str = strM201;
                                break;
                            case 1751557:
                                String strM53 = OUHQwdrD.m53();
                                strM142 = m107();
                                str = strM53;
                                break;
                            case 1751714:
                                Object objM287 = yGhVwXcV.m284(field, classLoader2);
                                strM142 = m125();
                                obj = objM287;
                                break;
                            case 1752585:
                                String strM290 = yGhVwXcV.m290();
                                strM142 = m147();
                                str = strM290;
                                break;
                            case 1753452:
                                yGhVwXcV.m259(field, true);
                                strM142 = m140();
                                break;
                            case 1753602:
                                yGhVwXcV.m256(field, obj, obj2);
                                strM142 = m126();
                                break;
                            case 1755437:
                                Class clsM209 = hYNP32vq.m209(objM284);
                                strM142 = m131();
                                cls = clsM209;
                                break;
                            case 1755469:
                                yGhVwXcV.m259(field, true);
                                strM142 = m128();
                                break;
                            case 1755499:
                                Field fieldM164 = fyhCtVnu.m162(cls, str);
                                strM142 = m118();
                                field = fieldM164;
                                break;
                            default:
                                Class clsM177 = fyhCtVnu.m177(str);
                                strM142 = m143();
                                cls = clsM177;
                                break;
                        }
                    }
                    break;
                case 54360481:
                    int i16 = f26 * (f24 + 436);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-21, -99, -17, -61, -21, -111, -66, -110}, "084d01e25da6", 0.0f));
                    break;
                case 54361654:
                    int i17 = f26 * (f24 + 1317);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-66, -109, -71, -58, -71, -111, -71, -63}, "e7bfb4be", 0.0f));
                    break;
                case 54391515:
                    int i18 = f26 * (f24 + 2129);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-67, -52, -19, -59, -29, -61, -67, -57}, "fd6f8d"));
                    break;
                case 54395329:
                    int i19 = f26 * (f24 ^ 6292);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-18, -103, -65, -110, -20, -107, -18, -112}, "59d67353846249", 4));
                    break;
                case 54417238:
                    int i20 = f26 * (f24 | 4329);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-29, -108, -20, -60, -18, -81, -29, -104}, "807d50", 1));
                    break;
                case 54421271:
                    int i21 = f26 * (f24 + 1631);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-72, -107, -17, -101, -20, -5, -72, -63}, "c3497dce"));
                    break;
                case 54422976:
                    int i22 = f26 * (f24 | 7694);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-30, -110, -24, -108, -17, -102, -30, -105}, "903449", 5));
                    break;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x02b3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:37:0x02c9. Please report as an issue. */
    private static String e(Context context, byte[] bArr) throws IOException {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-17, -98, -24, -106, -24, -5, -17, -103}, "48373d"));
        while (true) {
            switch (iM309) {
                case 54153182:
                    int i = f26 * (f24 | 2704);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-20, -106, -70, -110, -20, -57, -70, -112}, "73a57fa493", false));
                    break;
                case 54180087:
                    int i2 = f26 * (f24 + 6157);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-71, -109, -65, -58, -66, -51, -20, -52}, "b0daee7d316599ca", true));
                    break;
                case 54186666:
                    int i3 = f26 * (f24 | 6434);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-21, -63, -72, -57, -71, -90, -23, -52}, "0fcdb92d", 6));
                    break;
                case 54186668:
                    int i4 = f26 * (f24 + 7910);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-22, -112, -30, -98, -66, -111, -29, -58}, "1299e48a77", 6));
                    break;
                case 54187719:
                    int i5 = f26 * (f24 | 6096);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-23, -101, -29, -112, -24, -112, -23, -107}, "238433", 3));
                    break;
                case 54208890:
                    int i6 = f26 * (f24 ^ 4680);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-18, -108, -66, -61, -23, -87, -18, -98}, "56ea26", 5));
                    break;
                case 54211713:
                    int i7 = f26 * (f24 ^ 6700);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-17, -101, -70, -88, -65, -97, -67, -108}, "49a7d9f5", 0.0f));
                    break;
                case 54211743:
                    int i8 = f26 * (f24 | 3691);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-70, -108, -23, -98, -67, -62, -70, -111}, "a426fd", true));
                    break;
                case 54215464:
                    int i9 = f26 * (f24 | 4516);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-71, -108, -72, -82, -22, -105, -19, -111}, "b5c11062", 5));
                    break;
                case 54216457:
                    int i10 = f26 * (f24 | 6219);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-21, -112, -24, -111, -22, -112, -66, -57}, "053118ede3"));
                    break;
                case 54238648:
                    int i11 = f26 * (f24 + 5856);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-65, -103, -24, -111, -72, -102, -18, -60}, "d936c95b2aebcb"));
                    break;
                case 54241321:
                    int i12 = f26 * (f24 ^ 4397);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-23, -59, -21, -103, -70, -98, -23, -63}, "2b08a9"));
                    break;
                case 54246311:
                    int i13 = f26 * (f24 ^ 4896);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-29, -112, -65, -112, -65, -102, -29, -107}, "87d4d9"));
                    break;
                case 54276196:
                    int i14 = f26 * (f24 + 5544);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-70, -5, -22, -62, -23, -101, -66, -110}, "ad1a23e0a51cfee4", true));
                    break;
                case 54328087:
                    int i15 = f26 * (f24 | 553);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-22, -103, -65, -112, -18, -57, -22, -98}, "18d75d", 0.0f));
                    break;
                case 54329046:
                    int i16 = f26 * (f24 + 7711);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-29, -57, -71, -111, -29, -60, -30, -109}, "8fb78f963363c001"));
                    break;
                case 54335557:
                    int i17 = f26 * (f24 + 4888);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-17, -112, -72, -6, -65, -100, -70, -109}, "45ced4a6a3"));
                    break;
                case 54359517:
                    int i18 = f26 * (f24 + 609);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-21, -60, -30, -105, -29, -62, -29, -110}, "0e958d868352"));
                    break;
                case 54389558:
                    File file = new File(OUHQwdrD.m54(context), fyhCtVnu.m166());
                    boolean zM219 = hYNP32vq.m219(file);
                    int i19 = 1616;
                    while (true) {
                        i19 ^= 1633;
                        switch (i19) {
                            case 14:
                                break;
                            case 49:
                                i19 = zM219 ? 1709 : 1678;
                                break;
                            case 204:
                                long jM205 = hYNP32vq.m205(file);
                                long length = bArr.length;
                                int i20 = 1740;
                                while (true) {
                                    i20 ^= 1757;
                                    switch (i20) {
                                        case 17:
                                            i20 = jM205 == length ? 1833 : 1802;
                                            break;
                                        case 54:
                                            break;
                                        case 471:
                                            hYNP32vq.m240(file, true, false);
                                            yGhVwXcV.m267(file);
                                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                                            OUHQwdrD.m39(fileOutputStream, bArr);
                                            fyhCtVnu.m154(fileOutputStream);
                                            hYNP32vq.m240(file, false, false);
                                            hYNP32vq.m237(file);
                                            break;
                                        case 500:
                                            int i21 = 1864;
                                            while (true) {
                                                i21 ^= 1881;
                                                switch (i21) {
                                                    case 17:
                                                        i21 = 48674;
                                                        break;
                                                    case 47483:
                                                        break;
                                                }
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                }
                                break;
                            case 239:
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                OUHQwdrD.m39(fileOutputStream2, bArr);
                                fyhCtVnu.m154(fileOutputStream2);
                                hYNP32vq.m240(file, false, false);
                                hYNP32vq.m237(file);
                                break;
                            default:
                                break;
                        }
                    }
                    return OUHQwdrD.m46(file);
                case 54391237:
                    int i22 = f26 * (f24 | 3745);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-72, -62, -70, -110, -19, -54, -18, -83}, "cba26b52", 4));
                    break;
                case 54392316:
                    int i23 = f26 * (f24 | 386);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-65, -59, -24, -54, -66, -3, -21, -99}, "db3beb08c20069", false));
                    break;
                case 54396039:
                    int i24 = f26 * (f24 + 7701);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-67, -62, -22, -63, -30, -61, -19, -64}, "fc1c9f6e6830ac", 6));
                    break;
                case 54422111:
                    int i25 = f26 * (f24 | 8024);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-30, -109, -21, -109, -65, -57, -30, -98}, "9304dd964408ed", 2));
                    break;
            }
        }
    }

    private static void f(AssetManager assetManager, String str) {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-17, -106, -67, -102, -23, -111, -17, -57}, "42f9264d4787cd"));
        while (true) {
            switch (iM309) {
                case 54150239:
                    int i = f26 * (f24 + 6638);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-72, -109, -67, -88, -19, -2, -19, -64}, "c6f76a6fb25faf26", true));
                    break;
                case 54152221:
                    int i2 = f26 * (f24 + 1290);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-19, -109, -30, -97, -18, -61, -21, -99}, "60995c092e1e"));
                    break;
                case 54157927:
                    int i3 = f26 * (f24 | 7390);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-67, -112, -20, -103, -21, -60, -67, -61}, "f3790ffe10308808"));
                    break;
                case 54184712:
                    int i4 = f26 * (f24 ^ 4372);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-18, -109, -24, -101, -67, -64, -67, -99}, "5239fdf5c4", false));
                    break;
                case 54211685:
                    int i5 = f26 * (f24 ^ 6214);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-17, -101, -29, -108, -22, -108, -65, -58}, "438416df6a9972ec", 0.0f));
                    break;
                case 54238467:
                    int i6 = f26 * (f24 ^ 3220);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-72, -112, -20, -98, -65, -63, -30, -60}, "c679db9ab53d", false));
                    break;
                case 54239551:
                    int i7 = f26 * (f24 | 5365);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-70, -3, -22, -112, -29, -98, -70, -64}, "ab1286", true));
                    break;
                case 54242371:
                    int i8 = f26 * (f24 | 5351);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-65, -102, -17, -89, -30, -104, -71, -112}, "d84898b63649b80d", false));
                    break;
                case 54247267:
                    int i9 = f26 * (f24 | 8116);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-24, -107, -67, -6, -67, -102, -20, -108}, "33fef975", 0.0f));
                    break;
                case 54269281:
                    int i10 = 1616;
                    while (true) {
                        i10 ^= 1633;
                        switch (i10) {
                            case 14:
                                break;
                            case 49:
                                if (assetManager == null) {
                                    i10 = 1709;
                                }
                                break;
                            case 204:
                                return;
                            case 239:
                                Class clsM209 = hYNP32vq.m209(assetManager);
                                Method methodM45 = OUHQwdrD.m45(clsM209, hYNP32vq.m231(), new Class[]{String.class});
                                OUHQwdrD.m49(methodM45, true);
                                OUHQwdrD.m51(methodM45, assetManager, new Object[]{str});
                                int i11 = 1740;
                                while (true) {
                                    i11 ^= 1757;
                                    switch (i11) {
                                        case 17:
                                            i11 = 1771;
                                            break;
                                        case 54:
                                            try {
                                                Method methodM46 = OUHQwdrD.m45(clsM209, OUHQwdrD.m83(), new Class[]{String.class});
                                                OUHQwdrD.m49(methodM46, true);
                                                OUHQwdrD.m51(methodM46, assetManager, new Object[]{str});
                                                int i12 = 1864;
                                                while (true) {
                                                    i12 ^= 1881;
                                                    switch (i12) {
                                                        case 17:
                                                            i12 = 48674;
                                                            break;
                                                        case 47483:
                                                            return;
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                return;
                                            }
                                            break;
                                    }
                                }
                                break;
                            default:
                                continue;
                        }
                        i10 = 1678;
                    }
                    break;
                case 54270360:
                    int i13 = f26 * (f24 | 1249);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-66, -112, -21, -63, -17, -64, -19, -57}, "e00d4b6b175b5b", false));
                    break;
                case 54274953:
                    int i14 = f26 * (f24 + 1351);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-17, -64, -67, -57, -66, -108, -18, -106}, "4cffe2567a32", false));
                    break;
                case 54274983:
                    int i15 = f26 * (f24 + 7387);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-67, -110, -24, -60, -19, -98, -67, -60}, "f53b69fd", false));
                    break;
                case 54275973:
                    int i16 = f26 * (f24 ^ 7614);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-67, -109, -21, -62, -24, -110, -65, -108}, "f10a30d0a01c", 7));
                    break;
                case 54302107:
                    int i17 = f26 * (f24 ^ 70);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-24, -59, -21, -60, -30, -2, -24, -110}, "3f0b9a3706ba", false));
                    break;
                case 54327809:
                    int i18 = f26 * (f24 + 3937);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-22, -60, -18, -112, -20, -57, -22, -64}, "1a567d", true));
                    break;
                case 54334655:
                    int i19 = f26 * (f24 + 1585);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-29, -101, -22, -109, -21, -58, -67, -105}, "89130bf20c2bf1", 0.0f));
                    break;
                case 54357719:
                    int i20 = f26 * (f24 | 620);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-24, -82, -17, -53, -67, -61, -29, -62}, "314cfe8f", 2));
                    break;
                case 54365411:
                    int i21 = f26 * (f24 ^ 5956);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-20, -102, -67, -53, -67, -60, -20, -102}, "78fcfa", false));
                    break;
                case 54394360:
                    int i22 = f26 * (f24 + 249);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-19, -63, -22, -109, -71, -111, -72, -60}, "6b14b0cf1310ab", 0.0f));
                    break;
                case 54418230:
                    int i23 = f26 * (f24 + 5761);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-30, -84, -19, -112, -71, -64, -65, -111}, "9360bfd5"));
                    break;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:117:0x0455. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x0321. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:69:0x036e. Please report as an issue. */
    private static void g(Context context, String str) {
        int i;
        Field fieldM162;
        int i2;
        int iM330 = C0005.m330(C0010.decode(new byte[]{-30, -105, -66, -83, -17, -107, -30, -107}, "97e243", 5));
        while (true) {
            switch (iM330) {
                case 54150117:
                    int i3 = f26 * (f24 | 4957);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-29, -54, -22, -60, -19, -110, -21, -111}, "8b1a64030df9a1", 0.0f));
                    break;
                case 54152997:
                    int i4 = f26 * (f24 ^ 6689);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-20, -109, -66, -85, -23, -58, -30, -89}, "74e42c9837", true));
                    break;
                case 54153895:
                    int i5 = f26 * (f24 ^ 5891);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-71, -103, -18, -108, -22, -105, -18, -109}, "b8551154c121"));
                    break;
                case 54179039:
                    int i6 = f26 * (f24 + 4886);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-21, -106, -70, -60, -65, -105, -23, -107}, "00acd32685fc0e41", 3));
                    break;
                case 54179067:
                    int i7 = f26 * (f24 ^ 2843);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-23, -4, -21, -58, -67, -108, -23, -59}, "2c0ff6", false));
                    break;
                case 54182762:
                    int i8 = f26 * (f24 | 5788);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-18, -62, -19, -2, -30, -97, -18, -57}, "5f6a98", 5));
                    break;
                case 54186602:
                    int i9 = f26 * (f24 ^ 1233);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-67, -84, -29, -108, -65, -103, -67, -111}, "f380d9", 0.0f));
                    break;
                case 54187505:
                    int i10 = f26 * (f24 ^ 273);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-30, -111, -20, -102, -19, -59, -71, -103}, "91796db1", 6));
                    break;
                case 54210785:
                    int i11 = f26 * (f24 | 1511);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-29, -63, -20, -90, -30, -58, -67, -58}, "8a799cfc", 0.0f));
                    break;
                case 54214439:
                    int i12 = f26 * (f24 + 569);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-66, -99, -20, -62, -20, -62, -30, -63}, "e87a7d9c241504", true));
                    break;
                case 54238434:
                    int i13 = f26 * (f24 + 1583);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-18, -109, -29, -7, -20, -4, -23, -63}, "558f7c2d78e748", 0.0f));
                    break;
                case 54239583:
                    int i14 = f26 * (f24 + 1650);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-19, -82, -66, -106, -30, -64, -19, -110}, "61e59b"));
                    break;
                case 54239677:
                    int i15 = f26 * (f24 + 5017);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-24, -52, -71, -107, -30, -98, -18, -108}, "3db49957b6d32a", 1));
                    break;
                case 54240416:
                    m130(yGhVwXcV.m301(context), str);
                    int i16 = 1616;
                    while (true) {
                        i16 ^= 1633;
                        switch (i16) {
                            case 14:
                                m130(OUHQwdrD.m63(hYNP32vq.m193(context)), str);
                                int i17 = 1740;
                                while (true) {
                                    i17 ^= 1757;
                                    switch (i17) {
                                        case 17:
                                            i17 = 1771;
                                            break;
                                        case 54:
                                            try {
                                                Class clsM177 = fyhCtVnu.m177(hYNP32vq.m197());
                                                Method methodM45 = OUHQwdrD.m45(clsM177, hYNP32vq.m204(), new Class[0]);
                                                OUHQwdrD.m49(methodM45, true);
                                                Object objM51 = OUHQwdrD.m51(methodM45, null, new Object[0]);
                                                try {
                                                    fieldM162 = fyhCtVnu.m162(clsM177, hYNP32vq.m203());
                                                    int i18 = 1864;
                                                    while (true) {
                                                        i18 ^= 1881;
                                                        switch (i18) {
                                                            case 17:
                                                                i18 = 48674;
                                                                continue;
                                                            case 47483:
                                                                break;
                                                            default:
                                                                continue;
                                                        }
                                                        yGhVwXcV.m259(fieldM162, true);
                                                        Iterator itM305 = yGhVwXcV.m305(yGhVwXcV.m269((Map) yGhVwXcV.m284(fieldM162, objM51)));
                                                        while (true) {
                                                            boolean zM153 = fyhCtVnu.m153(itM305);
                                                            int i19 = 48767;
                                                            while (true) {
                                                                i19 ^= 48784;
                                                                switch (i19) {
                                                                    case 14:
                                                                        break;
                                                                    case 45:
                                                                        int i20 = 49914;
                                                                        while (true) {
                                                                            i20 ^= 49931;
                                                                            switch (i20) {
                                                                                case 497:
                                                                                    i20 = 50596;
                                                                                    break;
                                                                                case 1711:
                                                                                    break;
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 76:
                                                                        try {
                                                                            Object objM297 = yGhVwXcV.m297((Reference) fyhCtVnu.m152(itM305));
                                                                            int i21 = 48891;
                                                                            while (true) {
                                                                                i21 ^= 48908;
                                                                                switch (i21) {
                                                                                    case 22:
                                                                                        break;
                                                                                    case 53:
                                                                                        break;
                                                                                    case 503:
                                                                                        i21 = objM297 != null ? 49635 : 48953;
                                                                                        break;
                                                                                    case 32495:
                                                                                        Field fieldM163 = fyhCtVnu.m162(hYNP32vq.m209(objM297), hYNP32vq.m243());
                                                                                        yGhVwXcV.m259(fieldM163, true);
                                                                                        m130((AssetManager) yGhVwXcV.m284(fieldM163, objM297), str);
                                                                                        int i22 = 49666;
                                                                                        while (true) {
                                                                                            i22 ^= 49683;
                                                                                            switch (i22) {
                                                                                                case 17:
                                                                                                    i22 = 49697;
                                                                                                    break;
                                                                                                case 50:
                                                                                                    break;
                                                                                                default:
                                                                                                    break;
                                                                                            }
                                                                                            break;
                                                                                        }
                                                                                        break;
                                                                                    default:
                                                                                        break;
                                                                                }
                                                                            }
                                                                            while (true) {
                                                                                i2 ^= 49807;
                                                                                switch (i2) {
                                                                                    case 18:
                                                                                        break;
                                                                                    case 241:
                                                                                        i2 = 49821;
                                                                                        break;
                                                                                }
                                                                            }
                                                                        } catch (Throwable th) {
                                                                        }
                                                                        i2 = 49790;
                                                                        break;
                                                                    case 239:
                                                                        i19 = zM153 ? 48860 : 48829;
                                                                        break;
                                                                    default:
                                                                        break;
                                                                }
                                                                try {
                                                                    Class clsM178 = fyhCtVnu.m177(OUHQwdrD.m67());
                                                                    Method methodM46 = OUHQwdrD.m45(clsM178, hYNP32vq.m200(), new Class[0]);
                                                                    OUHQwdrD.m49(methodM46, true);
                                                                    Object objM52 = OUHQwdrD.m51(methodM46, null, new Object[0]);
                                                                    int i23 = 50689;
                                                                    while (true) {
                                                                        i23 ^= 50706;
                                                                        switch (i23) {
                                                                            case 19:
                                                                                i23 = objM52 != null ? 50782 : 50751;
                                                                                break;
                                                                            case 45:
                                                                                break;
                                                                            case 50:
                                                                                break;
                                                                            case 76:
                                                                                Field fieldM164 = fyhCtVnu.m162(clsM178, fyhCtVnu.m161());
                                                                                yGhVwXcV.m259(fieldM164, true);
                                                                                Iterator itM306 = yGhVwXcV.m305(yGhVwXcV.m269((Map) yGhVwXcV.m284(fieldM164, objM52)));
                                                                                while (true) {
                                                                                    boolean zM154 = fyhCtVnu.m153(itM306);
                                                                                    int i24 = 50813;
                                                                                    while (true) {
                                                                                        i24 ^= 50830;
                                                                                        switch (i24) {
                                                                                            case 18:
                                                                                                break;
                                                                                            case 53:
                                                                                                break;
                                                                                            case 243:
                                                                                                i24 = zM154 ? 51557 : 50875;
                                                                                                break;
                                                                                            case 4075:
                                                                                                try {
                                                                                                    Object objM298 = yGhVwXcV.m297((Reference) fyhCtVnu.m152(itM306));
                                                                                                    int i25 = 51588;
                                                                                                    while (true) {
                                                                                                        i25 ^= 51605;
                                                                                                        switch (i25) {
                                                                                                            case 17:
                                                                                                                i25 = objM298 != null ? 51681 : 51650;
                                                                                                                break;
                                                                                                            case 54:
                                                                                                                break;
                                                                                                            case 87:
                                                                                                                break;
                                                                                                            case 116:
                                                                                                                Field fieldM165 = fyhCtVnu.m162(hYNP32vq.m209(objM298), OUHQwdrD.m92());
                                                                                                                yGhVwXcV.m259(fieldM165, true);
                                                                                                                Object objM284 = yGhVwXcV.m284(fieldM165, objM298);
                                                                                                                int i26 = 51712;
                                                                                                                while (true) {
                                                                                                                    i26 ^= 51729;
                                                                                                                    switch (i26) {
                                                                                                                        case 14:
                                                                                                                            break;
                                                                                                                        case 17:
                                                                                                                            i26 = objM284 != null ? 51805 : 51774;
                                                                                                                            break;
                                                                                                                        case 47:
                                                                                                                            break;
                                                                                                                        case 76:
                                                                                                                            m130(OUHQwdrD.m63((Resources) objM284), str);
                                                                                                                            int i27 = 51836;
                                                                                                                            while (true) {
                                                                                                                                i27 ^= 51853;
                                                                                                                                switch (i27) {
                                                                                                                                    case 241:
                                                                                                                                        i27 = 52518;
                                                                                                                                        break;
                                                                                                                                    case 1963:
                                                                                                                                        break;
                                                                                                                                    default:
                                                                                                                                        break;
                                                                                                                                }
                                                                                                                                break;
                                                                                                                            }
                                                                                                                            break;
                                                                                                                        default:
                                                                                                                            break;
                                                                                                                    }
                                                                                                                }
                                                                                                                break;
                                                                                                            default:
                                                                                                                break;
                                                                                                        }
                                                                                                    }
                                                                                                    while (true) {
                                                                                                        i ^= 52628;
                                                                                                        switch (i) {
                                                                                                            case 23:
                                                                                                                i = 52642;
                                                                                                                break;
                                                                                                            case 54:
                                                                                                                break;
                                                                                                        }
                                                                                                    }
                                                                                                } catch (Throwable th2) {
                                                                                                }
                                                                                                i = 52611;
                                                                                                break;
                                                                                            default:
                                                                                                break;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                break;
                                                                            default:
                                                                                break;
                                                                        }
                                                                        return;
                                                                    }
                                                                    int i28 = 52735;
                                                                    while (true) {
                                                                        i28 ^= 52752;
                                                                        switch (i28) {
                                                                            case 14:
                                                                                return;
                                                                            case 1007:
                                                                                i28 = 52766;
                                                                                break;
                                                                        }
                                                                    }
                                                                } catch (Throwable th3) {
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th4) {
                                                    fieldM162 = fyhCtVnu.m162(clsM177, yGhVwXcV.m287());
                                                }
                                            } catch (Throwable th5) {
                                            }
                                            break;
                                    }
                                }
                                break;
                            case 49:
                                i16 = 1647;
                                break;
                        }
                    }
                    break;
                case 54298261:
                    int i29 = f26 * (f24 | 5861);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-24, -64, -30, -107, -67, -111, -70, -109}, "3d97f6a2f7b6286a"));
                    break;
                case 54301144:
                    int i30 = f26 * (f24 + 3047);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-23, -63, -66, -63, -24, -51, -30, -109}, "2cea3e94bf6bf3fd", 0.0f));
                    break;
                case 54331866:
                    int i31 = f26 * (f24 + 2873);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-24, -109, -24, -59, -24, -100, -30, -108}, "353a399558112e", 6));
                    break;
                case 54357599:
                    int i32 = f26 * (f24 + 271);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-70, -57, -66, -107, -18, -111, -19, -111}, "aee554674b"));
                    break;
                case 54362586:
                    int i33 = f26 * (f24 + 6445);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-30, -112, -29, -62, -17, -111, -23, -59}, "908e402a405e01", true));
                    break;
                case 54365440:
                    int i34 = f26 * (f24 ^ 4342);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-18, -59, -30, -99, -17, -84, -18, -51}, "5e9543", false));
                    break;
                case 54387570:
                    int i35 = f26 * (f24 ^ 3342);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-18, -108, -24, -112, -70, -105, -66, -105}, "5535a7e49fc981", 4));
                    break;
                case 54419349:
                    int i36 = f26 * (f24 ^ 4133);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-17, -106, -22, -104, -18, -106, -66, -112}, "441957e236f1b9", 6));
                    break;
                case 54423161:
                    int i37 = f26 * (f24 | 4791);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-24, -60, -17, -85, -66, -2, -72, -111}, "3f44eac56fa02eea"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۟ۢ۟ۧ, reason: not valid java name and contains not printable characters */
    public static void m94(Object obj, Object obj2) throws IllegalAccessException {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-24, -64, -67, -111, -66, -59, -23, -111}, "3df5ee24b772", false));
        while (true) {
            switch (iM336) {
                case 54150177:
                    int i = f26 * (f24 ^ 2263);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-71, -105, -24, -110, -66, -101, -71, -109}, "b431e3"));
                    break;
                case 54185792:
                    int i2 = f26 * (f24 | 4977);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-71, -106, -20, -111, -18, -58, -66, -62}, "b3775fee7c17", 7));
                    break;
                case 54186572:
                    int i3 = f26 * (f24 | 2068);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-30, -59, -17, -112, -72, -106, -21, -100}, "9c47c00939", 0.0f));
                    break;
                case 54214436:
                    int i4 = f26 * (f24 ^ 3741);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-70, -61, -67, -107, -66, -112, -72, -104}, "adf4e7c85c60", true));
                    break;
                case 54215432:
                    int iM211 = hYNP32vq.m211();
                    int i5 = 1616;
                    while (true) {
                        i5 ^= 1633;
                        switch (i5) {
                            case 14:
                                break;
                            case 49:
                                if (iM211 > 0) {
                                    i5 = 1709;
                                }
                                break;
                            case 204:
                                d((ClassLoader) obj, (ClassLoader) obj2);
                                return;
                            case 239:
                                int i6 = 1740;
                                while (true) {
                                    i6 ^= 1757;
                                    switch (i6) {
                                        case 17:
                                            i6 = 1771;
                                            break;
                                        case 54:
                                            return;
                                    }
                                }
                                break;
                            default:
                                continue;
                        }
                        i5 = 1678;
                    }
                    break;
                case 54241536:
                    int i7 = f26 * (f24 + 290);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-67, -108, -18, -111, -67, -111, -67, -111}, "f357f9", 0.0f));
                    break;
                case 54272351:
                    int i8 = f26 * (f24 + 5306);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-30, -58, -67, -81, -30, -57, -67, -60}, "9bf09dfa1d", 0.0f));
                    break;
                case 54277093:
                    int i9 = f26 * (f24 | 2300);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-23, -108, -29, -98, -23, -58, -18, -63}, "24892f5d", 0.0f));
                    break;
                case 54298141:
                    int i10 = f26 * (f24 + 5271);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-67, -102, -19, -101, -21, -102, -20, -108}, "f26908731cf46dee", 0.0f));
                    break;
                case 54302853:
                    int i11 = f26 * (f24 + 4816);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-30, -61, -18, -107, -29, -106, -21, -106}, "9c538006836fc9", 0.0f));
                    break;
                case 54330779:
                    int i12 = f26 * (f24 ^ 8167);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-21, -59, -22, -99, -24, -62, -70, -59}, "0b193caf3ccdf0ab", 3));
                    break;
                case 54334568:
                    int i13 = f26 * (f24 | 5740);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-22, -61, -72, -108, -19, -60, -21, -60}, "1ac66b0b26", true));
                    break;
                case 54363424:
                    int i14 = f26 * (f24 | 4459);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-67, -2, -30, -105, -66, -99, -67, -59}, "fa97e9", true));
                    break;
                case 54365504:
                    int i15 = f26 * (f24 ^ 3485);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-29, -100, -20, -85, -18, -107, -19, -59}, "8474546c7421459b"));
                    break;
                case 54387545:
                    int i16 = f26 * (f24 | 3363);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-24, -59, -29, -110, -72, -111, -21, -6}, "3b87c90e", true));
                    break;
                case 54389555:
                    int i17 = f26 * (f24 + 6666);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-23, -61, -21, -7, -24, -100, -23, -106}, "2d0f382337dc", 0.0f));
                    break;
                case 54391327:
                    int i18 = f26 * (f24 | 2187);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-70, -105, -19, -107, -71, -64, -70, -109}, "a160ba", 3));
                    break;
                case 54392255:
                    int i19 = f26 * (f24 | 2413);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-17, -63, -24, -58, -29, -57, -17, -61}, "4f3e8e"));
                    break;
                case 54392408:
                    int i20 = f26 * (f24 ^ 1585);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-30, -64, -21, -60, -19, -111, -30, -59}, "9a0b60", 7));
                    break;
                case 54393429:
                    int i21 = f26 * (f24 ^ 844);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-65, -112, -30, -103, -66, -62, -65, -107}, "d391ed"));
                    break;
                case 54394393:
                    int i22 = f26 * (f24 + 3968);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-65, -99, -72, -58, -20, -106, -70, -58}, "d8cd74af"));
                    break;
                case 54417244:
                    int i23 = f26 * (f24 + 7372);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-72, -61, -20, -105, -66, -105, -22, -62}, "cd73e11cdf", 0.0f));
                    break;
                case 54420159:
                    int i24 = f26 * (f24 + 6326);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-23, -112, -23, -63, -72, -106, -72, -110}, "212dc6c2", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۠۠ۡۦ, reason: not valid java name and contains not printable characters */
    public static void m95(Object obj, Object obj2) {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-23, -58, -18, -109, -67, -110, -30, -109}, "2c50f293cefa3e", true));
        while (true) {
            switch (iM316) {
                case 54152225:
                    int i = f26 * (f24 | 7767);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-72, -60, -21, -111, -24, -58, -20, -90}, "cc013a79f691", 6));
                    break;
                case 54153060:
                    int i2 = f26 * (f24 + 6590);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-22, -58, -65, -106, -66, -111, -23, -54}, "1ad6e32b351466", 0.0f));
                    break;
                case 54179935:
                    int i3 = f26 * (f24 | 7578);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-66, -64, -21, -101, -21, -108, -71, -97}, "ed0900b7be1f", 0.0f));
                    break;
                case 54212677:
                    int i4 = f26 * (f24 | 2581);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-21, -99, -23, -61, -23, -90, -21, -86}, "052e29"));
                    break;
                case 54216389:
                    int i5 = f26 * (f24 ^ 7325);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-18, -109, -67, -110, -65, -59, -30, -60}, "51f5dc9f33", 1));
                    break;
                case 54217295:
                    int i6 = f26 * (f24 + 2520);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-65, -111, -23, -58, -22, -57, -22, -98}, "d02e1b164e", 7));
                    break;
                case 54239394:
                    int iM211 = hYNP32vq.m211();
                    int i7 = 1616;
                    while (true) {
                        i7 ^= 1633;
                        switch (i7) {
                            case 14:
                                break;
                            case 49:
                                if (iM211 >= 0) {
                                    i7 = 1709;
                                }
                                break;
                            case 204:
                                g((Context) obj, (String) obj2);
                                return;
                            case 239:
                                int i8 = 1740;
                                while (true) {
                                    i8 ^= 1757;
                                    switch (i8) {
                                        case 17:
                                            i8 = 1771;
                                            break;
                                        case 54:
                                            return;
                                    }
                                }
                                break;
                            default:
                                continue;
                        }
                        i7 = 1678;
                    }
                    break;
                case 54243519:
                    int i9 = f26 * (f24 ^ 1860);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-71, -107, -71, -59, -17, -107, -21, -103}, "b7bb4101c4cbf6d6"));
                    break;
                case 54244413:
                    int i10 = f26 * (f24 + 6587);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-17, -57, -29, -59, -18, -104, -17, -62}, "4c8b584c62"));
                    break;
                case 54246281:
                    int i11 = f26 * (f24 | 739);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-23, -109, -17, -58, -19, -57, -72, -59}, "214c6acedb", 0.0f));
                    break;
                case 54246337:
                    int i12 = f26 * (f24 | 7704);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-66, -102, -66, -105, -72, -83, -24, -105}, "e8e7c234614f", false));
                    break;
                case 54275228:
                    int i13 = f26 * (f24 ^ 3942);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-22, -111, -21, -58, -30, -100, -22, -106}, "130b94"));
                    break;
                case 54301058:
                    int i14 = f26 * (f24 | 4182);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-17, -109, -17, -107, -67, -106, -24, -110}, "4242f73214", 4));
                    break;
                case 54302047:
                    int i15 = f26 * (f24 + 4537);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-66, -81, -65, -106, -19, -52, -30, -105}, "e0d46d91196707", true));
                    break;
                case 54302913:
                    int i16 = f26 * (f24 | 3752);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-66, -89, -20, -102, -30, -111, -66, -112}, "e87995e486b481"));
                    break;
                case 54305732:
                    int i17 = f26 * (f24 + 7294);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-21, -100, -72, -62, -17, -111, -20, -106}, "08ca44731e76", 0.0f));
                    break;
                case 54331678:
                    int i18 = f26 * (f24 + 2902);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-67, -110, -19, -111, -23, -100, -18, -107}, "f16724546f", 0.0f));
                    break;
                case 54359581:
                    int i19 = f26 * (f24 ^ 3713);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-72, -100, -22, -105, -71, -109, -22, -111}, "c813b112b3f69c8f"));
                    break;
                case 54363584:
                    int i20 = f26 * (f24 + 2319);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-19, -59, -21, -110, -65, -64, -19, -57}, "6e02dc", 7));
                    break;
                case 54388447:
                    int i21 = f26 * (f24 ^ 327);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-22, -61, -20, -111, -29, -110, -70, -106}, "1e7484a1c6f8", 0.0f));
                    break;
                case 54388593:
                    int i22 = f26 * (f24 ^ 5110);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-19, -110, -71, -112, -21, -106, -19, -57}, "65b3016f", 0.0f));
                    break;
                case 54391478:
                    int i23 = f26 * (f24 | 2769);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-23, -103, -72, -97, -18, -81, -24, -59}, "28c7503bcfba"));
                    break;
                case 54423902:
                    int i24 = f26 * (f24 + 591);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-67, -57, -22, -111, -30, -103, -23, -105}, "fa1098249e8e188c", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۠ۥۦۢ, reason: not valid java name and contains not printable characters */
    public static String m96(Object obj, Object obj2) {
        int iM343 = C0008.m343(C0010.decode(new byte[]{-29, -108, -65, -110, -22, -110, -67, -111}, "83d115f5"));
        while (true) {
            switch (iM343) {
                case 54153894:
                    int i = f26 * (f24 + 6725);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-71, -59, -24, -99, -72, -64, -65, -112}, "bc38cfd34a", 0));
                    break;
                case 54157025:
                    int i2 = f26 * (f24 + 4310);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-18, -58, -67, -59, -29, -108, -22, -104}, "5cfb86185b", true));
                    break;
                case 54179072:
                    int i3 = f26 * (f24 ^ 2815);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-65, -81, -67, -106, -71, -107, -71, -59}, "d0f2b5bd51", false));
                    break;
                case 54179970:
                    int i4 = f26 * (f24 ^ 1496);
                    iM343 = C0000.m309(C0010.decode(new byte[]{-67, -97, -67, -60, -19, -64, -65, -6}, "f7fc6cde", true));
                    break;
                case 54214406:
                    int i5 = f26 * (f24 ^ 5291);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-71, -108, -72, -99, -71, -108, -29, -89}, "b7c5b3889aced016", 0.0f));
                    break;
                case 54214596:
                    int i6 = f26 * (f24 | 5197);
                    iM343 = C0000.m309(C0010.decode(new byte[]{-23, -63, -71, -109, -24, -61, -67, -110}, "2cb33af042", 0.0f));
                    break;
                case 54238554:
                    int i7 = f26 * (f24 ^ 8143);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-20, -107, -66, -54, -19, -61, -20, -105}, "76eb6d", 6));
                    break;
                case 54239486:
                    int i8 = f26 * (f24 ^ 5852);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-18, -59, -70, -110, -70, -63, -30, -108}, "5ca6af90", true));
                    break;
                case 54242435:
                    int i9 = f26 * (f24 | 7862);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-66, -3, -65, -98, -18, -54, -72, -60}, "ebd95bce10fcbc", 0.0f));
                    break;
                case 54277117:
                    int i10 = f26 * (f24 ^ 3747);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-65, -112, -20, -62, -22, -58, -67, -63}, "d77c1fffd2c6efce", 0.0f));
                    break;
                case 54277119:
                    int i11 = f26 * (f24 + 5852);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-65, -110, -66, -104, -22, -108, -66, -109}, "d2e810e5", 1));
                    break;
                case 54302851:
                    int i12 = f26 * (f24 ^ 8030);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-66, -64, -18, -88, -21, -64, -70, -107}, "eb570ca5f1"));
                    break;
                case 54327807:
                    int iM266 = yGhVwXcV.m266();
                    int i13 = 1616;
                    while (true) {
                        i13 ^= 1633;
                        switch (i13) {
                            case 14:
                                break;
                            case 49:
                                if (iM266 < 0) {
                                    i13 = 1709;
                                }
                                break;
                            case 204:
                                return e((Context) obj, (byte[]) obj2);
                            case 239:
                                int i14 = 1740;
                                while (true) {
                                    i14 ^= 1757;
                                    switch (i14) {
                                        case 17:
                                            i14 = 1771;
                                            break;
                                        case 54:
                                            return null;
                                    }
                                }
                                break;
                            default:
                                continue;
                        }
                        i13 = 1678;
                    }
                    break;
                case 54335584:
                    int i15 = f26 * (f24 ^ 6721);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-22, -99, -67, -58, -24, -103, -29, -112}, "19fb3983c64557"));
                    break;
                case 54335747:
                    int i16 = f26 * (f24 + 2181);
                    iM343 = C0000.m309(C0010.decode(new byte[]{-21, -58, -29, -6, -71, -3, -72, -108}, "0c8ebbc0", 0));
                    break;
                case 54362403:
                    int i17 = f26 * (f24 ^ 6087);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-66, -111, -22, -61, -30, -82, -66, -111}, "e01f91", 0));
                    break;
                case 54362651:
                    int i18 = f26 * (f24 ^ 3940);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-70, -59, -18, -89, -65, -109, -66, -98}, "ae58d5e922", 0.0f));
                    break;
                case 54363576:
                    int i19 = f26 * (f24 | 3175);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-29, -59, -67, -59, -18, -86, -30, -106}, "8cfa5592d9", 0.0f));
                    break;
                case 54363580:
                    int i20 = f26 * (f24 | 4464);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-66, -107, -20, -61, -30, -112, -70, -50}, "e07d97af9d85dd"));
                    break;
                case 54389345:
                    int i21 = f26 * (f24 ^ 2252);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-19, -102, -65, -107, -30, -2, -19, -102}, "62d39a", false));
                    break;
                case 54391481:
                    int i22 = f26 * (f24 + 2536);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-67, -112, -24, -59, -29, -62, -71, -60}, "f23f8fbba8", true));
                    break;
                case 54423911:
                    int i23 = f26 * (f24 + 4103);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-72, -103, -24, -108, -20, -108, -19, -106}, "c8317163cfa6", 2));
                    break;
                case 54424987:
                    int i24 = f26 * (f24 ^ 1535);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-72, -106, -29, -58, -65, -106, -65, -88}, "c08cd0d7", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۢۧ۠, reason: not valid java name and contains not printable characters */
    private static String m97() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-70, -108, -17, -101, -66, -108, -70, -107}, "a643e6"));
        while (true) {
            switch (iM316) {
                case 54149122:
                    int i = f26 * (f24 | 7487);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-71, -109, -67, -83, -23, -7, -30, -112}, "b7f22f946a", 0.0f));
                    break;
                case 54151016:
                    int i2 = f26 * (f24 ^ 4659);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-20, -82, -20, -89, -72, -59, -67, -109}, "7178cdf0", true));
                    break;
                case 54151105:
                    int i3 = f26 * (f24 | 6888);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-18, -59, -18, -110, -72, -61, -18, -61}, "5c55cb"));
                    break;
                case 54181764:
                    int i4 = f26 * (f24 + 1061);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-24, -101, -22, -110, -21, -62, -29, -112}, "33160c86cf"));
                    break;
                case 54181855:
                    int i5 = f26 * (f24 ^ 6413);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-18, -58, -23, -63, -30, -107, -30, -4}, "5e2c919c", 5));
                    break;
                case 54183780:
                    int i6 = f26 * (f24 ^ 2020);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-70, -105, -23, -55, -30, -60, -20, -109}, "a12a9e71", 7));
                    break;
                case 54208638:
                    return C0009.m350(f28, 106, 1142855909 ^ C0004.f67, 2);
                case 54216329:
                    int i7 = f26 * (f24 ^ 4147);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-23, -59, -72, -108, -70, -62, -72, -63}, "2ec0aacb17e4"));
                    break;
                case 54247175:
                    int i8 = f26 * (f24 + 6500);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-21, -63, -22, -107, -65, -100, -71, -111}, "0d15d8b09a", 0.0f));
                    break;
                case 54247272:
                    int i9 = f26 * (f24 ^ 8087);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-20, -112, -71, -112, -67, -85, -20, -100}, "74b7f4", false));
                    break;
                case 54271258:
                    int i10 = f26 * (f24 ^ 8148);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-70, -105, -19, -109, -19, -63, -21, -58}, "a4656e0f10d342", 4));
                    break;
                case 54275103:
                    int i11 = f26 * (f24 | 784);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-23, -112, -66, -111, -19, -111, -29, -63}, "28e5668d580aa7", true));
                    break;
                case 54298016:
                    int i12 = f26 * (f24 + 1257);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-19, -103, -20, -112, -22, -64, -19, -103}, "69721c", 0.0f));
                    break;
                case 54305708:
                    int i13 = f26 * (f24 | 4834);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-21, -107, -18, -83, -66, -2, -18, -84}, "0452ea5301"));
                    break;
                case 54328920:
                    int i14 = f26 * (f24 + 1580);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-19, -86, -71, -61, -30, -111, -70, -61}, "65bb92aa", true));
                    break;
                case 54365344:
                    int i15 = f26 * (f24 ^ 7748);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-18, -54, -66, -53, -18, -59, -71, -58}, "5bec5cbc", false));
                    break;
                case 54366307:
                    int i16 = f26 * (f24 | 6873);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-30, -59, -22, -63, -18, -106, -66, -111}, "9e1c56e39a7c3b"));
                    break;
                case 54422049:
                    int i17 = f26 * (f24 | 5173);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-66, -109, -71, -101, -17, -112, -30, -108}, "e1b34593507b15"));
                    break;
                case 54422234:
                    int i18 = f26 * (f24 ^ 4520);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-66, -59, -29, -58, -24, -6, -70, -108}, "ed8a3ea651f357", false));
                    break;
                case 54426047:
                    int i19 = f26 * (f24 ^ 3189);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-20, -2, -23, -110, -21, -107, -30, -62}, "7a23059df328", 5));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤۨۥ, reason: not valid java name and contains not printable characters */
    private static String m98() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-18, -107, -23, -63, -71, -109, -22, -101}, "502cb2130f", false));
        while (true) {
            switch (iM336) {
                case 54150235:
                    int i = f26 * (f24 | 3048);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-23, -61, -22, -110, -70, -106, -23, -63}, "2a16a5", 0.0f));
                    break;
                case 54178980:
                    int i2 = f26 * (f24 + 2712);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-30, -112, -70, -110, -72, -106, -23, -109}, "94a3c523"));
                    break;
                case 54179101:
                    int i3 = f26 * (f24 | 7890);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-72, -63, -19, -106, -21, -105, -22, -110}, "cc6502146df81249", 4));
                    break;
                case 54180095:
                    int i4 = f26 * (f24 + 4489);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-67, -107, -20, -109, -65, -106, -24, -107}, "f270d23695", false));
                    break;
                case 54242466:
                    int i5 = f26 * (f24 ^ 3241);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-20, -109, -70, -112, -30, -110, -20, -57}, "77a7947a"));
                    break;
                case 54243359:
                    int i6 = f26 * (f24 ^ 1362);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-30, -107, -23, -82, -30, -64, -20, -62}, "96219b7fda4f932e", 6));
                    break;
                case 54244264:
                    int i7 = f26 * (f24 ^ 1257);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-65, -58, -19, -62, -18, -108, -17, -97}, "da6e5447e3", true));
                    break;
                case 54268318:
                    int i8 = f26 * (f24 + 7583);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-23, -60, -18, -86, -30, -111, -21, -60}, "2a55970e402991c9", 0.0f));
                    break;
                case 54275941:
                    int i9 = f26 * (f24 ^ 7218);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-23, -57, -22, -60, -30, -107, -19, -103}, "2a1d9561"));
                    break;
                case 54300058:
                    int i10 = f26 * (f24 + 2771);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-22, -106, -65, -106, -18, -60, -23, -108}, "12d55b24fc8f"));
                    break;
                case 54302073:
                    int i11 = f26 * (f24 + 6584);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-20, -59, -21, -107, -71, -59, -21, -7}, "7a00bf0fdc"));
                    break;
                case 54303034:
                    int i12 = f26 * (f24 + 4325);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-30, -59, -71, -109, -21, -61, -23, -112}, "9fb40c219fa28591", 0.0f));
                    break;
                case 54303901:
                    int i13 = f26 * (f24 | 1479);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-23, -88, -17, -104, -30, -108, -21, -111}, "27489201fcf536a4", true));
                    break;
                case 54305923:
                    int i14 = f26 * (f24 ^ 947);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-18, -112, -67, -106, -67, -106, -30, -108}, "54f2f0948e77", 0.0f));
                    break;
                case 54328021:
                    int i15 = f26 * (f24 ^ 4489);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-22, -63, -21, -110, -71, -98, -30, -106}, "1a02b6918a8c443a", 0.0f));
                    break;
                case 54330756:
                    int i16 = f26 * (f24 | 4997);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-21, -61, -29, -102, -70, -102, -22, -57}, "0f89a91e8b43501b", false));
                    break;
                case 54331773:
                    int i17 = f26 * (f24 + 2513);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-24, -105, -66, -97, -17, -99, -19, -109}, "32e845608390335e"));
                    break;
                case 54335773:
                    int i18 = f26 * (f24 ^ 1328);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-29, -112, -29, -84, -65, -106, -17, -107}, "8083d140", 0));
                    break;
                case 54358594:
                    int i19 = f26 * (f24 ^ 2383);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-67, -60, -19, -58, -30, -105, -71, -60}, "ff6c96bb6b7c3c", true));
                    break;
                case 54391387:
                    return C0009.m350(f28, 85, 2087478394 ^ C0000.f59, 3);
                case 54395112:
                    int i20 = f26 * (f24 + 6099);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-18, -62, -17, -83, -29, -110, -21, -111}, "5b428109"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۦۡۤۥۦ, reason: not valid java name and contains not printable characters */
    private static String m99() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-70, -63, -21, -108, -72, -109, -29, -105}, "ac05c585b676424b", 0.0f));
        while (true) {
            switch (iM330) {
                case 54156931:
                    int i = f26 * (f24 ^ 2134);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-19, -55, -66, -105, -71, -97, -70, -55}, "6ae1b7aac930", 0.0f));
                    break;
                case 54157989:
                    int i2 = f26 * (f24 | 6903);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-30, -110, -24, -84, -23, -107, -23, -61}, "9733262b2427", false));
                    break;
                case 54179033:
                    return C0009.m350(f28, 20, 366191085 ^ C0004.f67, 3);
                case 54179810:
                    int i3 = f26 * (f24 | 8010);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-67, -57, -71, -110, -66, -107, -24, -54}, "ffb6e03b8c4f9e", 2));
                    break;
                case 54181856:
                    int i4 = f26 * (f24 | 5808);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-72, -112, -19, -4, -18, -57, -70, -4}, "c66c5eacb4c4e278", 7));
                    break;
                case 54184839:
                    int i5 = f26 * (f24 + 5635);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-21, -104, -29, -64, -72, -107, -21, -112}, "008fc4", true));
                    break;
                case 54210816:
                    int i6 = f26 * (f24 ^ 5208);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-23, -108, -71, -61, -23, -57, -22, -100}, "23be2f14", 0.0f));
                    break;
                case 54213638:
                    int i7 = f26 * (f24 + 4369);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-66, -61, -67, -64, -17, -57, -67, -64}, "ecfb4dfa", 0.0f));
                    break;
                case 54216490:
                    int i8 = f26 * (f24 + 6484);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-22, -112, -70, -112, -18, -105, -24, -51}, "10a5513e58a066", 3));
                    break;
                case 54240480:
                    int i9 = f26 * (f24 ^ 4623);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-17, -98, -18, -97, -20, -57, -21, -90}, "46597a09", 0.0f));
                    break;
                case 54240571:
                    int i10 = f26 * (f24 + 5706);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-67, -112, -65, -110, -70, -108, -66, -101}, "f1d5a0e3399a55", 0.0f));
                    break;
                case 54244477:
                    int i11 = f26 * (f24 + 748);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-66, -64, -19, -60, -29, -110, -24, -111}, "eb6e81358a9ec950", false));
                    break;
                case 54299197:
                    int i12 = f26 * (f24 ^ 1106);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-67, -108, -30, -112, -29, -88, -22, -106}, "f4908717"));
                    break;
                case 54304776:
                    int i13 = f26 * (f24 + 2605);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-71, -62, -20, -83, -21, -63, -22, -89}, "bb720d1824869a0f"));
                    break;
                case 54327928:
                    int i14 = f26 * (f24 | 1253);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-67, -111, -20, -60, -30, -50, -23, -101}, "f37a9f29bf48", 0.0f));
                    break;
                case 54357686:
                    int i15 = f26 * (f24 ^ 828);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-71, -105, -23, -100, -72, -100, -72, -102}, "b029c8c89ce5", 0.0f));
                    break;
                case 54359676:
                    int i16 = f26 * (f24 ^ 3652);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-29, -83, -17, -110, -71, -63, -19, -110}, "8245bd625695d1", true));
                    break;
                case 54360635:
                    int i17 = f26 * (f24 | 2542);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-20, -97, -71, -61, -22, -100, -67, -63}, "79bb18fda42c", true));
                    break;
                case 54393308:
                    int i18 = f26 * (f24 ^ 189);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-18, -62, -30, -108, -23, -108, -18, -57}, "5d9620", 4));
                    break;
                case 54394182:
                    int i19 = f26 * (f24 + 1235);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-65, -57, -22, -59, -30, -109, -17, -108}, "dc1e954324fe", false));
                    break;
                case 54423965:
                    int i20 = f26 * (f24 | 4189);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-29, -84, -30, -51, -65, -102, -65, -100}, "839ed2d84e6d2381", 0.0f));
                    break;
                case 54424119:
                    int i21 = f26 * (f24 + 5494);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-66, -110, -18, -107, -18, -59, -19, -60}, "e3545b6c8d710b17", false));
                    break;
                case 54424190:
                    int i22 = f26 * (f24 | 6105);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-66, -59, -72, -109, -70, -106, -30, -61}, "eac5a69e60", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۧۡ۟ۤ, reason: not valid java name and contains not printable characters */
    private static String m100() {
        int iM337 = C0007.m337(C0010.decode(new byte[]{-72, -98, -65, -102, -18, -106, -21, -104}, "c8d85000"));
        while (true) {
            switch (iM337) {
                case 54150984:
                    int i = f26 * (f24 + 7614);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-29, -107, -18, -106, -67, -62, -29, -112}, "8154fe"));
                    break;
                case 54183784:
                    int i2 = f26 * (f24 ^ 4589);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-24, -106, -19, -60, -66, -106, -71, -106}, "336fe2b5f0c6af1a"));
                    break;
                case 54184714:
                    return C0009.m350(f28, 38, 1762563194 ^ C0000.f59, 3);
                case 54186724:
                    int i3 = f26 * (f24 ^ 6097);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-20, -107, -18, -106, -30, -108, -22, -106}, "73519616"));
                    break;
                case 54246275:
                    int i4 = f26 * (f24 | 5456);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-30, -58, -70, -97, -65, -87, -72, -107}, "9ba8d6c5", 0.0f));
                    break;
                case 54272096:
                    int i5 = f26 * (f24 + 7935);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-66, -110, -72, -112, -72, -57, -24, -106}, "e1c3cf363367", 3));
                    break;
                case 54272127:
                    int i6 = f26 * (f24 + 6811);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-19, -109, -66, -98, -71, -107, -72, -60}, "61e9b1cf027e58", 3));
                    break;
                case 54277119:
                    int i7 = f26 * (f24 ^ 3476);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-70, -53, -19, -63, -70, -52, -23, -112}, "ac6bad22dd72", 7));
                    break;
                case 54300091:
                    int i8 = f26 * (f24 ^ 738);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-22, -103, -19, -107, -17, -110, -72, -97}, "196040c8646cd3"));
                    break;
                case 54300959:
                    int i9 = f26 * (f24 ^ 4980);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-21, -109, -21, -107, -70, -110, -24, -102}, "0704a638141aa3", 5));
                    break;
                case 54301144:
                    int i10 = f26 * (f24 | 7014);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-22, -61, -19, -102, -17, -3, -21, -64}, "1f694b0e3d734d", 0.0f));
                    break;
                case 54305700:
                    int i11 = f26 * (f24 ^ 5182);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-18, -63, -71, -57, -71, -110, -20, -101}, "5ebeb3791d78"));
                    break;
                case 54330844:
                    int i12 = f26 * (f24 | 1286);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-21, -57, -72, -98, -67, -111, -30, -104}, "0dc6f699", 0.0f));
                    break;
                case 54331652:
                    int i13 = f26 * (f24 | 7729);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-71, -111, -21, -111, -30, -60, -20, -112}, "b1069a7226b30bae", false));
                    break;
                case 54360702:
                    int i14 = f26 * (f24 ^ 4002);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-22, -109, -72, -105, -17, -112, -20, -108}, "15c34170", 0));
                    break;
                case 54362465:
                    int i15 = f26 * (f24 ^ 2495);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-66, -111, -65, -62, -66, -109, -70, -62}, "e1dfe0ae9324867f"));
                    break;
                case 54365375:
                    int i16 = f26 * (f24 + 1169);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-71, -102, -19, -60, -65, -105, -71, -102}, "b26ad2", 0.0f));
                    break;
                case 54387573:
                    int i17 = f26 * (f24 ^ 3848);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-71, -97, -22, -57, -65, -59, -71, -57}, "b71adfbff2"));
                    break;
                case 54421301:
                    int i18 = f26 * (f24 | 2124);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-67, -6, -21, -110, -65, -86, -19, -110}, "fe03d567a4"));
                    break;
                case 54423136:
                    int i19 = f26 * (f24 + 7035);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-67, -60, -23, -3, -29, -110, -67, -63}, "fc2b87", 0.0f));
                    break;
                case 54424028:
                    int i20 = f26 * (f24 ^ 1935);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-66, -62, -65, -58, -29, -103, -65, -62}, "eade89db", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠۠۠ۡ, reason: not valid java name and contains not printable characters */
    private static String m101() {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-65, -84, -19, -61, -66, -103, -65, -112}, "d36be1d078b6"));
        while (true) {
            switch (iM311) {
                case 54150049:
                    int i = f26 * (f24 + 1053);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-29, -86, -17, -107, -19, -105, -19, -83}, "85466462abded76d", 0.0f));
                    break;
                case 54151258:
                    int i2 = f26 * (f24 + 7432);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-17, -86, -70, -109, -19, -58, -17, -108}, "45a76f", 0.0f));
                    break;
                case 54153024:
                    int i3 = f26 * (f24 ^ 7303);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-17, -60, -72, -111, -65, -98, -17, -58}, "4bc2d8", 0.0f));
                    break;
                case 54153030:
                    int i4 = f26 * (f24 ^ 836);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-19, -60, -70, -57, -21, -62, -65, -112}, "6aac0dd538"));
                    break;
                case 54153180:
                    int i5 = f26 * (f24 | 7109);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-17, -107, -29, -62, -71, -51, -30, -61}, "458bbe9a66f8c25e"));
                    break;
                case 54153186:
                    int i6 = f26 * (f24 | 7967);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-70, -112, -17, -58, -22, -62, -17, -58}, "a74f1f4fed"));
                    break;
                case 54153867:
                    int i7 = f26 * (f24 | 3278);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-66, -109, -29, -59, -24, -110, -66, -108}, "e18a34", 1));
                    break;
                case 54153894:
                    int i8 = f26 * (f24 | 4006);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-23, -62, -24, -61, -23, -61, -70, -106}, "2a3e2fa6fd05", 0.0f));
                    break;
                case 54180090:
                    int i9 = f26 * (f24 + 3121);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-17, -4, -65, -110, -70, -105, -72, -103}, "4cd2a7c9c1", 6));
                    break;
                case 54210778:
                    int i10 = f26 * (f24 ^ 4828);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-30, -106, -67, -53, -22, -106, -30, -108}, "91fc14", true));
                    break;
                case 54239492:
                    int i11 = f26 * (f24 ^ 7171);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-20, -81, -22, -106, -70, -87, -18, -106}, "7012a65374", 2));
                    break;
                case 54243457:
                    return C0009.m350(f28, 119, 1530058356 ^ C0001.f61, 3);
                case 54273063:
                    int i12 = f26 * (f24 | 6290);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-67, -87, -18, -111, -66, -104, -17, -97}, "f652e0492fe8d8", 1));
                    break;
                case 54275134:
                    int i13 = f26 * (f24 | 7081);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-71, -59, -19, -63, -23, -109, -20, -89}, "ba6e2478cf", 7));
                    break;
                case 54301051:
                    int i14 = f26 * (f24 ^ 5269);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-67, -106, -21, -102, -17, -58, -67, -102}, "f2084c", 5));
                    break;
                case 54301089:
                    int i15 = f26 * (f24 | 3659);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-22, -59, -70, -110, -18, -97, -65, -63}, "1da359daa7834984", 6));
                    break;
                case 54303064:
                    int i16 = f26 * (f24 + 7325);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-21, -7, -24, -63, -20, -112, -21, -61}, "0f3b73", true));
                    break;
                case 54332830:
                    int i17 = f26 * (f24 | 1746);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-67, -111, -67, -112, -29, -109, -20, -64}, "f9f5857a", true));
                    break;
                case 54361659:
                    int i18 = f26 * (f24 + 1799);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-20, -57, -65, -106, -65, -107, -20, -62}, "7dd2d5", true));
                    break;
                case 54388501:
                    int i19 = f26 * (f24 + 3415);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-72, -109, -24, -105, -18, -99, -65, -59}, "c73559dd", 2));
                    break;
                case 54396132:
                    int i20 = f26 * (f24 ^ 7104);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-18, -101, -24, -60, -17, -57, -19, -100}, "593d4e6493ed", true));
                    break;
                case 54420307:
                    int i21 = f26 * (f24 + 7234);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-24, -7, -29, -105, -21, -100, -17, -107}, "3f840445"));
                    break;
                case 54423160:
                    int i22 = f26 * (f24 | 2993);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-70, -100, -67, -60, -30, -112, -19, -111}, "a4ff9761", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۡۡۧ۟, reason: not valid java name and contains not printable characters */
    private static String m102() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-70, -97, -23, -57, -29, -59, -23, -64}, "a92f8f2afe8cac", false));
        while (true) {
            switch (iM309) {
                case 54183838:
                    int i = f26 * (f24 ^ 1796);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-17, -62, -20, -105, -23, -61, -30, -105}, "4f762e907e2666cf"));
                    break;
                case 54185580:
                    int i2 = f26 * (f24 + 37);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-23, -61, -24, -63, -67, -111, -30, -6}, "2c3ef49ecb3e"));
                    break;
                case 54208771:
                    int i3 = f26 * (f24 + 962);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-30, -63, -72, -110, -22, -102, -30, -62}, "9cc212", 0.0f));
                    break;
                case 54217505:
                    int i4 = f26 * (f24 + 3516);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-65, -62, -24, -110, -65, -4, -21, -60}, "db34dc0a45", 3));
                    break;
                case 54239671:
                    int i5 = f26 * (f24 + 6153);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-22, -110, -71, -110, -30, -87, -17, -104}, "15b3964968a3e786", 0.0f));
                    break;
                case 54247147:
                    int i6 = f26 * (f24 ^ 1792);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-21, -62, -29, -89, -29, -63, -72, -111}, "0c888bc9bf", 0.0f));
                    break;
                case 54247209:
                    return C0009.m350(f28, 0, 1758106978 ^ C0002.f63, 3);
                case 54275978:
                    int i7 = f26 * (f24 | 5560);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-21, -61, -30, -59, -18, -58, -20, -109}, "0e9a5a75ac", true));
                    break;
                case 54298232:
                    int i8 = f26 * (f24 | 5122);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-24, -111, -67, -108, -65, -111, -71, -108}, "36f5d9b4e5b4a7", false));
                    break;
                case 54300158:
                    int i9 = f26 * (f24 + 5954);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-24, -63, -29, -102, -22, -97, -30, -6}, "3e88199e5a85a9", 0.0f));
                    break;
                case 54300988:
                    int i10 = f26 * (f24 ^ 7669);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-21, -61, -19, -58, -72, -110, -17, -101}, "0e6bc54970bca0e7", 0.0f));
                    break;
                case 54301111:
                    int i11 = f26 * (f24 | 731);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-18, -109, -71, -60, -20, -112, -21, -109}, "50bc71048bdd86", false));
                    break;
                case 54301926:
                    int i12 = f26 * (f24 ^ 3265);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-18, -59, -66, -110, -66, -107, -20, -112}, "5be7e775", 6));
                    break;
                case 54359641:
                    int i13 = f26 * (f24 ^ 1054);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-19, -54, -29, -82, -18, -112, -24, -62}, "6b81503f61ea", false));
                    break;
                case 54362649:
                    int i14 = f26 * (f24 ^ 349);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-29, -64, -70, -54, -19, -109, -67, -112}, "8bab62f606"));
                    break;
                case 54362653:
                    int i15 = f26 * (f24 + 6952);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-71, -59, -24, -87, -21, -109, -29, -59}, "ba36058f4c2bbb42"));
                    break;
                case 54389308:
                    int i16 = f26 * (f24 + 43);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-71, -111, -18, -109, -29, -3, -71, -108}, "b6528b"));
                    break;
                case 54389309:
                    int i17 = f26 * (f24 ^ 4958);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-67, -100, -65, -63, -23, -103, -29, -111}, "f8db2889", 0.0f));
                    break;
                case 54389586:
                    int i18 = f26 * (f24 + 1427);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-17, -64, -29, -102, -70, -101, -19, -64}, "4b82a86f", false));
                    break;
                case 54393249:
                    int i19 = f26 * (f24 | 8071);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-17, -106, -23, -112, -30, -59, -29, -110}, "47289c82", 0.0f));
                    break;
                case 54417211:
                    int i20 = f26 * (f24 | 994);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-67, -62, -17, -111, -19, -107, -67, -58}, "ff4367", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۡۤۢ, reason: not valid java name and contains not printable characters */
    private static String m103() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-19, -103, -19, -109, -17, -106, -29, -106}, "61624682f7d6", false));
        while (true) {
            switch (iM330) {
                case 54155009:
                    return C0009.m350(f28, 12, 1774143072 ^ C0006.f71, 3);
                case 54180030:
                    int i = f26 * (f24 ^ 3319);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-23, -98, -23, -104, -18, -106, -23, -51}, "2620562e0bd73202", 0.0f));
                    break;
                case 54209787:
                    int i2 = f26 * (f24 | 2977);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-22, -110, -18, -60, -29, -4, -66, -108}, "175c8ce6", 0.0f));
                    break;
                case 54211771:
                    int i3 = f26 * (f24 ^ 3643);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-67, -103, -29, -98, -65, -88, -70, -110}, "f189d7a4", 0.0f));
                    break;
                case 54270275:
                    int i4 = f26 * (f24 ^ 5516);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-17, -54, -72, -60, -70, -62, -23, -99}, "4bccab299d5c652f", false));
                    break;
                case 54301860:
                    int i5 = f26 * (f24 + 1576);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-72, -59, -21, -63, -17, -107, -21, -109}, "ce0a43074ec13e", false));
                    break;
                case 54327992:
                    int i6 = f26 * (f24 + 531);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-29, -98, -71, -108, -21, -3, -18, -109}, "86b30b53e3a26c", 4));
                    break;
                case 54334568:
                    int i7 = f26 * (f24 ^ 1334);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-67, -97, -17, -103, -18, -107, -18, -62}, "f949535a", 0.0f));
                    break;
                case 54335493:
                    int i8 = f26 * (f24 | 3183);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-18, -50, -30, -62, -18, -55, -65, -105}, "5f9c5ad3", false));
                    break;
                case 54358775:
                    int i9 = f26 * (f24 + 6959);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-19, -97, -29, -57, -72, -57, -19, -106}, "678fcf", 0.0f));
                    break;
                case 54393337:
                    int i10 = f26 * (f24 | 6799);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-29, -3, -71, -112, -66, -57, -21, -60}, "8bb5eb0d4e15ed27", true));
                    break;
                case 54419133:
                    int i11 = f26 * (f24 + 2300);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-19, -108, -65, -98, -22, -63, -71, -107}, "61d81ab2bd9a", 0.0f));
                    break;
                case 54419161:
                    int i12 = f26 * (f24 + 5597);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-71, -111, -20, -58, -18, -108, -71, -111}, "b07d53", 0.0f));
                    break;
                case 54419168:
                    int i13 = f26 * (f24 ^ 5503);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-20, -110, -30, -101, -71, -85, -20, -110}, "7698b4", true));
                    break;
                case 54419381:
                    int i14 = f26 * (f24 + 1614);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-72, -103, -23, -62, -65, -104, -71, -50}, "c12cd9bf13a1", true));
                    break;
                case 54422166:
                    int i15 = f26 * (f24 | 1603);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-21, -109, -22, -61, -30, -99, -66, -107}, "041f98e509", 5));
                    break;
                case 54424864:
                    int i16 = f26 * (f24 | 7296);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-66, -111, -17, -109, -30, -107, -29, -62}, "e043908cd10f", 7));
                    break;
                case 54424870:
                    int i17 = f26 * (f24 + 4232);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-66, -60, -20, -2, -67, -105, -70, -57}, "ea7af2ad7c591240", 0));
                    break;
                case 54424899:
                    int i18 = f26 * (f24 | 7771);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-19, -100, -18, -63, -72, -105, -17, -89}, "645ec2480764a1", true));
                    break;
                case 54425864:
                    int i19 = f26 * (f24 ^ 8050);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-30, -57, -72, -106, -19, -110, -65, -53}, "9dc761dc33"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۤۨ۠ۥ, reason: not valid java name and contains not printable characters */
    private static String m104() {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-21, -60, -22, -112, -72, -61, -67, -103}, "0e13cdf187c5", 3));
        while (true) {
            switch (iM311) {
                case 54150144:
                    int i = f26 * (f24 ^ 5991);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-66, -62, -29, -7, -23, -81, -18, -108}, "ed8f2056e2eb", 0.0f));
                    break;
                case 54183656:
                    int i2 = f26 * (f24 | 6634);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-70, -63, -22, -55, -18, -107, -70, -58}, "ad1a57", 0.0f));
                    break;
                case 54183750:
                    int i3 = f26 * (f24 + 3750);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-72, -107, -70, -108, -70, -58, -72, -105}, "c7a7afc4", 6));
                    break;
                case 54183808:
                    int i4 = f26 * (f24 | 8108);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-66, -84, -67, -103, -66, -111, -66, -111}, "e3f9e2"));
                    break;
                case 54212739:
                    int i5 = f26 * (f24 + 5524);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-23, -109, -65, -63, -72, -110, -19, -88}, "25dfc667"));
                    break;
                case 54216422:
                    int i6 = f26 * (f24 ^ 288);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-19, -62, -30, -62, -21, -58, -19, -111}, "6b9f0b61", true));
                    break;
                case 54242308:
                    int i7 = f26 * (f24 ^ 182);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-29, -64, -24, -2, -71, -106, -21, -59}, "8c3ab60d541c5d", false));
                    break;
                case 54268253:
                    int i8 = f26 * (f24 + 5241);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-23, -109, -22, -97, -18, -108, -23, -112}, "221856", 2));
                    break;
                case 54271135:
                    return C0009.m350(f28, 26, 492162091 ^ C0004.f67, 3);
                case 54336547:
                    int i9 = f26 * (f24 ^ 569);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-72, -63, -19, -109, -22, -62, -22, -109}, "cb611b13f5909673", 0.0f));
                    break;
                case 54357596:
                    int i10 = f26 * (f24 + 2803);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-21, -101, -21, -62, -65, -97, -21, -107}, "030ad8"));
                    break;
                case 54360540:
                    int i11 = f26 * (f24 + 6715);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-24, -58, -21, -54, -65, -57, -24, -55}, "3a0bdf"));
                    break;
                case 54364480:
                    int i12 = f26 * (f24 ^ 4714);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-72, -57, -66, -106, -24, -110, -66, -61}, "cae433eb"));
                    break;
                case 54365436:
                    int i13 = f26 * (f24 ^ 3192);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-17, -110, -72, -112, -23, -63, -70, -6}, "45c82aae838dc0", 4));
                    break;
                case 54390398:
                    int i14 = f26 * (f24 ^ 2911);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-67, -112, -21, -108, -19, -107, -67, -110}, "f60261", false));
                    break;
                case 54394143:
                    int i15 = f26 * (f24 ^ 2094);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-19, -110, -29, -111, -71, -105, -23, -63}, "6285b52ee2", 3));
                    break;
                case 54396064:
                    int i16 = f26 * (f24 | 7578);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-71, -58, -23, -105, -21, -112, -70, -97}, "ba2503a9", true));
                    break;
                case 54396104:
                    int i17 = f26 * (f24 ^ 4345);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-29, -98, -67, -61, -23, -107, -29, -111}, "86fd27", 3));
                    break;
                case 54421274:
                    int i18 = f26 * (f24 ^ 5696);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-24, -106, -17, -109, -65, -87, -24, -107}, "3647d6"));
                    break;
                case 54424964:
                    int i19 = f26 * (f24 + 951);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-30, -60, -71, -112, -22, -103, -18, -105}, "9cb61957", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۦۥۣ, reason: not valid java name and contains not printable characters */
    public static Object m105(Object obj) {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-72, -110, -20, -106, -22, -107, -65, -60}, "c27216da13094f", 2));
        while (true) {
            switch (iM309) {
                case 54150237:
                    int i = f26 * (f24 + 7413);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-17, -107, -66, -82, -23, -103, -17, -112}, "45e121", false));
                    break;
                case 54152909:
                    int i2 = f26 * (f24 + 7714);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-66, -63, -21, -62, -18, -5, -23, -57}, "ec0b5d2b555cb4", 0.0f));
                    break;
                case 54157864:
                    int i3 = f26 * (f24 ^ 3913);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-72, -107, -18, -89, -30, -97, -23, -111}, "c658992788180f", false));
                    break;
                case 54179132:
                    int iM42 = OUHQwdrD.m42();
                    int i4 = 1616;
                    while (true) {
                        i4 ^= 1633;
                        switch (i4) {
                            case 14:
                                break;
                            case 49:
                                if (iM42 < 0) {
                                    i4 = 1709;
                                }
                                break;
                            case 204:
                                return a((ClassLoader) obj);
                            case 239:
                                int i5 = 1740;
                                while (true) {
                                    i5 ^= 1757;
                                    switch (i5) {
                                        case 17:
                                            i5 = 1771;
                                            break;
                                        case 54:
                                            return null;
                                    }
                                }
                                break;
                            default:
                                continue;
                        }
                        i4 = 1678;
                    }
                    break;
                case 54182725:
                    int i6 = f26 * (f24 | 2619);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-65, -64, -22, -106, -29, -62, -71, -106}, "df148cb6", true));
                    break;
                case 54183782:
                    int i7 = f26 * (f24 | 6956);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-70, -62, -29, -98, -24, -108, -67, -109}, "aa8634f69c", 0.0f));
                    break;
                case 54184746:
                    int i8 = f26 * (f24 ^ 8053);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-66, -103, -65, -60, -65, -98, -65, -57}, "e1dcd8dbcc97425a", true));
                    break;
                case 54186570:
                    int i9 = f26 * (f24 ^ 2034);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-71, -60, -22, -58, -18, -61, -22, -106}, "bf1e5e12ca", 0.0f));
                    break;
                case 54216514:
                    int i10 = f26 * (f24 | 5165);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-67, -108, -24, -110, -70, -63, -71, -112}, "f431aab2", 4));
                    break;
                case 54239396:
                    int i11 = f26 * (f24 | 4271);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-71, -81, -65, -100, -18, -57, -72, -63}, "b0d45ccbf631", 5));
                    break;
                case 54239676:
                    int i12 = f26 * (f24 ^ 1254);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-71, -106, -20, -109, -23, -110, -23, -102}, "b676212257ec9f"));
                    break;
                case 54242495:
                    int i13 = f26 * (f24 | 337);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-30, -5, -71, -109, -71, -108, -30, -58}, "9db3b2", 0.0f));
                    break;
                case 54246153:
                    int i14 = f26 * (f24 | 7509);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-71, -99, -65, -110, -29, -107, -71, -112}, "b8d787b253"));
                    break;
                case 54268444:
                    int i15 = f26 * (f24 ^ 5505);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-17, -58, -17, -63, -66, -104, -65, -108}, "4d4ae0d206290163", 2));
                    break;
                case 54270209:
                    int i16 = f26 * (f24 | 2453);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-70, -112, -22, -101, -70, -64, -70, -112}, "a818aa", false));
                    break;
                case 54276906:
                    int i17 = f26 * (f24 | 364);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-70, -86, -21, -105, -20, -85, -24, -98}, "a5047436", 5));
                    break;
                case 54306725:
                    int i18 = f26 * (f24 | 217);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-18, -61, -72, -110, -17, -103, -17, -102}, "5cc54949671b4a"));
                    break;
                case 54333664:
                    int i19 = f26 * (f24 | 2965);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-66, -62, -30, -51, -67, -111, -71, -63}, "ef9ef0bc1541"));
                    break;
                case 54357660:
                    int i20 = f26 * (f24 ^ 6719);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-30, -57, -30, -108, -66, -104, -71, -105}, "9e93e8b3"));
                    break;
                case 54360539:
                    int i21 = f26 * (f24 ^ 476);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-20, -108, -20, -58, -19, -110, -29, -107}, "727c6787", 0.0f));
                    break;
                case 54363548:
                    int i22 = f26 * (f24 | 6407);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-19, -58, -65, -105, -29, -106, -17, -105}, "6ed68743d7"));
                    break;
                case 54421090:
                    int i23 = f26 * (f24 + 7460);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-30, -111, -22, -86, -20, -64, -30, -109}, "97157a", 4));
                    break;
                case 54425086:
                    int i24 = f26 * (f24 | 582);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-30, -103, -66, -106, -24, -99, -30, -103}, "98e138", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۧ۠ۤ, reason: not valid java name and contains not printable characters */
    private static String m106() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-23, -99, -65, -104, -72, -82, -66, -57}, "28d8c1ee", 4));
        while (true) {
            switch (iM336) {
                case 54153893:
                    int i = f26 * (f24 + 8190);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-24, -109, -30, -106, -65, -112, -24, -103}, "3192d5", 0.0f));
                    break;
                case 54153959:
                    int i2 = f26 * (f24 | 7195);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-19, -105, -22, -112, -29, -63, -23, -55}, "63128e2a23b1f5e4"));
                    break;
                case 54156009:
                    int i3 = f26 * (f24 + 5428);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-72, -7, -24, -59, -17, -108, -19, -58}, "cf3a446f3173d5a9", 0.0f));
                    break;
                case 54156869:
                    int i4 = f26 * (f24 | 4771);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-65, -60, -29, -64, -30, -108, -17, -55}, "db8c914a0cf8e8", true));
                    break;
                case 54184864:
                    int i5 = f26 * (f24 ^ 6589);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-24, -106, -70, -105, -30, -109, -71, -59}, "30a590bc09", 0.0f));
                    break;
                case 54209731:
                    int i6 = f26 * (f24 + 5538);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-20, -62, -66, -109, -24, -62, -18, -58}, "7be63e5d74d3", 0));
                    break;
                case 54214409:
                    int i7 = f26 * (f24 ^ 5975);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-29, -84, -71, -100, -66, -109, -72, -110}, "83b8e1c61d", false));
                    break;
                case 54239576:
                    int i8 = f26 * (f24 ^ 5570);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-29, -64, -21, -105, -18, -112, -66, -106}, "8a0753e1", 5));
                    break;
                case 54243429:
                    int i9 = f26 * (f24 ^ 6966);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-67, -61, -71, -112, -22, -90, -65, -99}, "fbb519d9863353"));
                    break;
                case 54244196:
                    int i10 = f26 * (f24 ^ 949);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-24, -64, -22, -110, -18, -110, -65, -106}, "3d1254d53fac17", 2));
                    break;
                case 54270366:
                    int i11 = f26 * (f24 + 33);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-71, -60, -24, -105, -18, -63, -71, -7}, "bf375d"));
                    break;
                case 54299193:
                    int i12 = f26 * (f24 + 5017);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-66, -62, -30, -64, -22, -57, -18, -105}, "ea9a1a51", 0.0f));
                    break;
                case 54301058:
                    int i13 = f26 * (f24 | 5067);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-65, -99, -72, -112, -70, -87, -65, -103}, "d5c5a6d16deb39", 0.0f));
                    break;
                case 54328766:
                    int i14 = f26 * (f24 | 7284);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-65, -61, -29, -102, -22, -62, -67, -105}, "de881ff1", 0.0f));
                    break;
                case 54331927:
                    int i15 = f26 * (f24 | 4282);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-19, -110, -24, -107, -23, -104, -70, -111}, "673228a7a11a82b8", false));
                    break;
                case 54332673:
                    int i16 = f26 * (f24 | 8112);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-18, -111, -21, -109, -72, -111, -72, -109}, "5400c9c2765f99", false));
                    break;
                case 54335528:
                    int i17 = f26 * (f24 ^ 5446);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-72, -85, -65, -58, -72, -102, -66, -103}, "c4dac9e92e"));
                    break;
                case 54336576:
                    int i18 = f26 * (f24 | 5620);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-24, -111, -21, -63, -19, -90, -71, -109}, "330d69b3ebe272", 0.0f));
                    break;
                case 54360607:
                    int i19 = f26 * (f24 ^ 7564);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-29, -98, -30, -63, -18, -105, -30, -109}, "869a5594", false));
                    break;
                case 54360638:
                    int i20 = f26 * (f24 ^ 7287);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-67, -6, -20, -106, -66, -105, -24, -104}, "fe70e13056d96321", 6));
                    break;
                case 54361632:
                    return C0009.m350(f28, 3, 603945289 ^ C0009.f77, 3);
                case 54418237:
                    int i21 = f26 * (f24 + 5810);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-29, -61, -21, -62, -24, -57, -23, -108}, "8f0f3f27", 7));
                    break;
                case 54422950:
                    int i22 = f26 * (f24 ^ 3686);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-65, -111, -24, -50, -22, -110, -65, -108}, "d43f11", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۧۨۨۡ, reason: not valid java name and contains not printable characters */
    private static String m107() {
        int iM343 = C0008.m343(C0010.decode(new byte[]{-17, -62, -23, -63, -70, -98, -17, -64}, "4a2aa9", 3));
        while (true) {
            switch (iM343) {
                case 54152001:
                    return C0009.m350(f28, 140, 766061215 ^ C0002.f63, 3);
                case 54157026:
                    int i = f26 * (f24 | 6632);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-67, -102, -19, -7, -18, -7, -21, -57}, "f86f5f0a31a24cba"));
                    break;
                case 54181978:
                    int i2 = f26 * (f24 ^ 8172);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-23, -110, -23, -108, -21, -64, -23, -106}, "27270b22", true));
                    break;
                case 54185641:
                    int i3 = f26 * (f24 | 3470);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-22, -111, -24, -61, -67, -58, -18, -107}, "133afc50", 0.0f));
                    break;
                case 54210656:
                    int i4 = f26 * (f24 | 6975);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-24, -105, -67, -104, -19, -107, -66, -112}, "33f867e2", 0.0f));
                    break;
                case 54213660:
                    int i5 = f26 * (f24 | 4867);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-71, -3, -19, -57, -67, -62, -19, -83}, "bb6efc62d0bb83", true));
                    break;
                case 54215616:
                    int i6 = f26 * (f24 | 7514);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-72, -60, -19, -112, -29, -112, -67, -84}, "cd6287f3", 0.0f));
                    break;
                case 54238436:
                    int i7 = f26 * (f24 ^ 5951);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-20, -106, -67, -100, -19, -62, -71, -112}, "70f86ab068b7c83b", false));
                    break;
                case 54241504:
                    int i8 = f26 * (f24 ^ 7195);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-67, -64, -30, -60, -24, -63, -30, -109}, "fc9e3a96a203a3", 0.0f));
                    break;
                case 54269431:
                    int i9 = f26 * (f24 | 7431);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-66, -99, -65, -101, -18, -112, -23, -107}, "e8d957259fd92e", 2));
                    break;
                case 54270179:
                    int i10 = f26 * (f24 + 352);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-19, -102, -23, -60, -23, -110, -24, -107}, "622d2432", 3));
                    break;
                case 54275234:
                    int i11 = f26 * (f24 | 5042);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-22, -106, -20, -111, -67, -84, -67, -111}, "1171f3f5d1", false));
                    break;
                case 54299068:
                    int i12 = f26 * (f24 + 454);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-21, -109, -23, -111, -30, -59, -29, -61}, "04239e8e41dd", 0));
                    break;
                case 54300216:
                    int i13 = f26 * (f24 ^ 4415);
                    iM343 = C0008.m343(C0010.decode(new byte[]{-72, -105, -20, -97, -18, -101, -19, -110}, "c47953653a8c65", false));
                    break;
                case 54330934:
                    int i14 = f26 * (f24 + 319);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-20, -108, -24, -60, -30, -109, -20, -105}, "753b94"));
                    break;
                case 54331744:
                    int i15 = f26 * (f24 + 4294);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-23, -88, -21, -107, -72, -52, -23, -107}, "2702cd", 0.0f));
                    break;
                case 54335584:
                    int i16 = f26 * (f24 | 3365);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-65, -108, -65, -61, -18, -103, -19, -57}, "d4de586c", false));
                    break;
                case 54335744:
                    int i17 = f26 * (f24 ^ 8175);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-17, -100, -65, -109, -65, -99, -24, -102}, "48d2d539", false));
                    break;
                case 54362523:
                    int i18 = f26 * (f24 ^ 6630);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-18, -106, -71, -104, -19, -108, -19, -110}, "57b96660", 0.0f));
                    break;
                case 54388350:
                    int i19 = f26 * (f24 ^ 5603);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-29, -58, -71, -58, -18, -108, -70, -105}, "8cba56a7748bad86"));
                    break;
                case 54390305:
                    int i20 = f26 * (f24 + 6801);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-20, -105, -20, -97, -72, -59, -67, -107}, "7278cbf067", 0.0f));
                    break;
                case 54418361:
                    int i21 = f26 * (f24 ^ 810);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-19, -107, -71, -58, -20, -112, -29, -84}, "64bb76830a6eee", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۨۥ۟۟ۧ, reason: not valid java name and contains not printable characters */
    private static String m108() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-24, -2, -24, -102, -29, -106, -19, -60}, "3a38846f", false));
        while (true) {
            switch (iM330) {
                case 54152035:
                    int i = f26 * (f24 ^ 1453);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-72, -97, -24, -63, -20, -107, -17, -109}, "c73e7546dd4b47"));
                    break;
                case 54154080:
                    int i2 = f26 * (f24 | 3291);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-19, -112, -29, -50, -65, -109, -30, -103}, "678fd19167", 0.0f));
                    break;
                case 54156844:
                    int i3 = f26 * (f24 | 2513);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-22, -64, -65, -109, -67, -60, -19, -88}, "1ad0fe67eeccdc", 0.0f));
                    break;
                case 54184740:
                    int i4 = f26 * (f24 ^ 8138);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-20, -85, -24, -60, -17, -60, -21, -105}, "743c4f01b969"));
                    break;
                case 54184742:
                    int i5 = f26 * (f24 | 1392);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-23, -61, -24, -105, -18, -101, -23, -110}, "2c32582031", 4));
                    break;
                case 54184771:
                    int i6 = f26 * (f24 | 2576);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-20, -110, -71, -106, -71, -60, -30, -59}, "77b1be9a4f272f", 7));
                    break;
                case 54210661:
                    int i7 = f26 * (f24 + 6001);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-72, -108, -65, -111, -24, -55, -67, -110}, "c7d43af1", 6));
                    break;
                case 54212544:
                    int i8 = f26 * (f24 | 5394);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-19, -60, -24, -107, -70, -108, -67, -111}, "6c37a5f0", 4));
                    break;
                case 54215588:
                    int i9 = f26 * (f24 + 2808);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-24, -54, -70, -103, -24, -109, -67, -61}, "3ba137fe549456", true));
                    break;
                case 54244266:
                    int i10 = f26 * (f24 | 7744);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-72, -59, -17, -106, -21, -57, -71, -109}, "cd470eb4", 0.0f));
                    break;
                case 54244447:
                    int i11 = f26 * (f24 + 2139);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-17, -109, -18, -82, -19, -110, -17, -108}, "455162", 0.0f));
                    break;
                case 54274269:
                    int i12 = f26 * (f24 | 7317);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-19, -103, -30, -109, -71, -59, -20, -111}, "6996bf75b822e3", 5));
                    break;
                case 54334596:
                    int i13 = f26 * (f24 | 3853);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-24, -105, -17, -61, -17, -110, -24, -107}, "374f46", true));
                    break;
                case 54335557:
                    int i14 = f26 * (f24 + 6172);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-19, -4, -21, -110, -22, -62, -19, -62}, "6c061d", 0.0f));
                    break;
                case 54357626:
                    int i15 = f26 * (f24 | 2116);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-71, -110, -29, -105, -18, -112, -66, -63}, "b38156ed1c3edc"));
                    break;
                case 54363640:
                    return C0009.m350(f28, 70, 1170947323 ^ C0003.f65, 3);
                case 54366466:
                    int i16 = f26 * (f24 ^ 5335);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-30, -58, -65, -105, -71, -98, -19, -102}, "9dd2b96933b19e", 0.0f));
                    break;
                case 54390331:
                    int i17 = f26 * (f24 + 949);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-19, -57, -19, -99, -66, -108, -17, -111}, "6a65e2474d", false));
                    break;
                case 54396135:
                    int i18 = f26 * (f24 ^ 6613);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-24, -106, -17, -106, -70, -109, -29, -55}, "3443a28ad2419063"));
                    break;
                case 54422017:
                    int i19 = f26 * (f24 ^ 886);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-20, -111, -21, -110, -66, -111, -18, -109}, "7404e057df", 0));
                    break;
                case 54425986:
                    int i20 = f26 * (f24 ^ 5790);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-29, -111, -70, -58, -29, -100, -19, -112}, "87ac8461b35a1ea3", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۨۥۧ, reason: not valid java name and contains not printable characters */
    private static String m109() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-30, -105, -66, -57, -20, -97, -20, -64}, "95ec797f99", 0.0f));
        while (true) {
            switch (iM336) {
                case 54151105:
                    int i = f26 * (f24 | 2337);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-18, -108, -20, -105, -66, -107, -65, -111}, "5671e1d525f2a1", 6));
                    break;
                case 54179811:
                    int i2 = f26 * (f24 | 1881);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-29, -63, -23, -64, -30, -61, -65, -63}, "8d2b9cdb4b", 0.0f));
                    break;
                case 54180870:
                    int i3 = f26 * (f24 ^ 3163);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-70, -109, -70, -108, -67, -59, -30, -97}, "a1a4fe98", 0.0f));
                    break;
                case 54187566:
                    int i4 = f26 * (f24 | 3699);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-65, -112, -21, -59, -17, -111, -67, -108}, "d00d43f353de3af3", 4));
                    break;
                case 54208919:
                    int i5 = f26 * (f24 | 1130);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-30, -87, -20, -106, -30, -101, -23, -106}, "96779824", true));
                    break;
                case 54209878:
                    int i6 = f26 * (f24 ^ 27);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-70, -100, -72, -111, -18, -62, -22, -107}, "a4c95e1687d0", false));
                    break;
                case 54212513:
                    int i7 = f26 * (f24 ^ 3762);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-70, -58, -20, -64, -67, -60, -66, -112}, "ac7bfae8c4f3", false));
                    break;
                case 54239429:
                    int i8 = f26 * (f24 ^ 1141);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-72, -107, -71, -108, -72, -101, -17, -6}, "c4b4c34ee4", 1));
                    break;
                case 54239612:
                    int i9 = f26 * (f24 ^ 4466);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-72, -53, -17, -61, -17, -106, -29, -107}, "cc4c4180c85eb647", true));
                    break;
                case 54243453:
                    int i10 = f26 * (f24 ^ 2882);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-29, -97, -72, -106, -22, -61, -21, -104}, "89c11c00d937"));
                    break;
                case 54243458:
                    int i11 = f26 * (f24 + 2902);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-24, -108, -18, -103, -72, -82, -21, -105}, "3459c105", 5));
                    break;
                case 54245316:
                    int i12 = f26 * (f24 | 2908);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-21, -105, -65, -110, -30, -111, -17, -112}, "05d29744", 0));
                    break;
                case 54273150:
                    int i13 = f26 * (f24 + 3186);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-24, -53, -20, -105, -71, -57, -20, -109}, "3c72bf7633140630", 3));
                    break;
                case 54330720:
                    int i14 = f26 * (f24 | 5342);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-17, -107, -19, -57, -19, -58, -29, -88}, "446d6f87ae4f70", 6));
                    break;
                case 54330880:
                    int i15 = f26 * (f24 ^ 773);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-29, -59, -22, -98, -24, -59, -19, -106}, "8e163d61da25"));
                    break;
                case 54365321:
                    return C0009.m350(f28, 128, 1242727007 ^ C0000.f59, 3);
                case 54393216:
                    int i16 = f26 * (f24 + 5391);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-67, -112, -65, -99, -29, -111, -70, -112}, "f2d987a13e", false));
                    break;
                case 54418390:
                    int i17 = f26 * (f24 + 1704);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-20, -58, -72, -110, -23, -106, -67, -63}, "7ec625fadaee09", 2));
                    break;
                case 54423009:
                    int i18 = f26 * (f24 ^ 662);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-22, -111, -22, -100, -30, -60, -22, -107}, "16199e", 4));
                    break;
                case 54426076:
                    int i19 = f26 * (f24 | 6796);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-67, -105, -29, -90, -66, -54, -23, -59}, "f689eb2d1a4778"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡ۟ۡۨ, reason: not valid java name and contains not printable characters */
    private static String m110() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-29, -97, -71, -108, -67, -105, -67, -107}, "89b5f3f248e7e796", 0.0f));
        while (true) {
            switch (iM336) {
                case 54150148:
                    int i = f26 * (f24 ^ 4552);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-29, -63, -17, -108, -17, -102, -30, -57}, "8e42489a"));
                    break;
                case 54157865:
                    int i2 = f26 * (f24 ^ 2169);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-20, -64, -23, -105, -72, -61, -20, -60}, "7a24ca", 3));
                    break;
                case 54187558:
                    int i3 = f26 * (f24 ^ 2633);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-29, -109, -67, -104, -72, -99, -24, -111}, "84f9c53488c4", 0.0f));
                    break;
                case 54212581:
                    int i4 = f26 * (f24 | 4524);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-18, -61, -30, -109, -30, -57, -30, -106}, "5a919f929f8d59", 7));
                    break;
                case 54215525:
                    int i5 = f26 * (f24 | 5730);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-71, -110, -30, -104, -21, -97, -29, -85}, "b798098475db8d", false));
                    break;
                case 54241379:
                    int i6 = f26 * (f24 ^ 1713);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-24, -62, -29, -109, -22, -82, -24, -64}, "3e8711", false));
                    break;
                case 54244227:
                    int i7 = f26 * (f24 ^ 4485);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-71, -108, -72, -97, -23, -60, -24, -90}, "b4c72e39", 0.0f));
                    break;
                case 54245252:
                    int i8 = f26 * (f24 ^ 2804);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-30, -105, -19, -108, -21, -98, -29, -112}, "946209848b06cd77"));
                    break;
                case 54275200:
                    int i9 = f26 * (f24 + 4600);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-18, -83, -70, -112, -65, -112, -18, -108}, "52a0d3", 3));
                    break;
                case 54300902:
                    int i10 = f26 * (f24 ^ 5767);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-30, -88, -21, -97, -17, -109, -30, -109}, "970747", 0.0f));
                    break;
                case 54301117:
                    int i11 = f26 * (f24 + 7294);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-23, -107, -20, -107, -30, -104, -23, -110}, "227190", 0.0f));
                    break;
                case 54304838:
                    int i12 = f26 * (f24 + 580);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-65, -57, -66, -60, -19, -81, -24, -97}, "dcef60388d", 0.0f));
                    break;
                case 54328980:
                    int i13 = f26 * (f24 + 4306);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-19, -108, -19, -103, -18, -97, -72, -108}, "636859c445", true));
                    break;
                case 54359678:
                    int i14 = f26 * (f24 + 5175);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-72, -110, -23, -112, -17, -105, -29, -99}, "c4284589"));
                    break;
                case 54361535:
                    int i15 = f26 * (f24 | 1457);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-72, -111, -21, -112, -21, -63, -17, -106}, "c0060e42d7", true));
                    break;
                case 54366340:
                    int i16 = f26 * (f24 | 4200);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-24, -63, -66, -107, -19, -62, -23, -64}, "3ee76d2e036034", true));
                    break;
                case 54389524:
                    int i17 = f26 * (f24 ^ 7332);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-19, -63, -72, -111, -72, -112, -19, -61}, "6cc4c0"));
                    break;
                case 54389591:
                    return C0009.m350(f28, 137, 572464663 ^ C0006.f71, 3);
                case 54392195:
                    int i18 = f26 * (f24 ^ 7715);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-21, -58, -72, -103, -18, -60, -67, -61}, "0ac15efd0839", 0.0f));
                    break;
                case 54392469:
                    int i19 = f26 * (f24 | 1367);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-20, -58, -29, -112, -67, -64, -20, -58}, "7d86fb"));
                    break;
                case 54396103:
                    int i20 = f26 * (f24 ^ 3277);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-18, -106, -29, -62, -70, -105, -18, -108}, "508aa5", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡ۠۠ۥۨ, reason: not valid java name and contains not printable characters */
    private static String m111() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-65, -100, -71, -99, -20, -64, -23, -57}, "d9b57e2d216f76"));
        while (true) {
            switch (iM336) {
                case 54153027:
                    int i = f26 * (f24 | 7824);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-19, -63, -72, -109, -30, -109, -20, -99}, "6bc69075", 4));
                    break;
                case 54181921:
                    int i2 = f26 * (f24 | 6925);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-30, -109, -70, -60, -20, -102, -65, -82}, "92ae79d1d7e8", 7));
                    break;
                case 54187784:
                    int i3 = f26 * (f24 + 1798);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-22, -59, -67, -105, -19, -60, -30, -58}, "1bf36c9ec4e6f78b", false));
                    break;
                case 54209635:
                    int i4 = f26 * (f24 | 3185);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-29, -59, -18, -108, -17, -57, -19, -58}, "8f514d6a776d", 0.0f));
                    break;
                case 54210684:
                    int i5 = f26 * (f24 | 4100);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-20, -59, -20, -63, -18, -112, -71, -111}, "7d7a50b5dc", false));
                    break;
                case 54211715:
                    int i6 = f26 * (f24 ^ 2831);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-17, -107, -22, -58, -66, -108, -65, -111}, "451de1d56236", 0.0f));
                    break;
                case 54269460:
                    int i7 = f26 * (f24 + 4805);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-71, -112, -67, -97, -30, -112, -65, -111}, "b0f798d9c617", false));
                    break;
                case 54271259:
                    int i8 = f26 * (f24 ^ 497);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-18, -62, -30, -97, -18, -112, -72, -112}, "5a9954c8ae5ed46b", 0.0f));
                    break;
                case 54274118:
                    int i9 = f26 * (f24 | 311);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-67, -107, -66, -63, -65, -64, -67, -112}, "f0efdbf6a1", 4));
                    break;
                case 54274119:
                    int i10 = f26 * (f24 + 2787);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-67, -61, -30, -2, -67, -106, -30, -98}, "fe9af2980ee63c", 6));
                    break;
                case 54275111:
                    int i11 = f26 * (f24 ^ 8042);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-18, -3, -20, -57, -17, -64, -70, -112}, "5b7d4ca2", 0.0f));
                    break;
                case 54301860:
                    int i12 = f26 * (f24 + 3734);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-65, -58, -23, -108, -71, -110, -17, -62}, "da27b34b4eca", 0.0f));
                    break;
                case 54303812:
                    int i13 = f26 * (f24 ^ 3968);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-67, -59, -17, -112, -66, -87, -66, -112}, "fc41e6e1e8aad91e", 0.0f));
                    break;
                case 54335590:
                    int i14 = f26 * (f24 | 6289);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-17, -59, -70, -110, -65, -108, -67, -110}, "4fa0d0f2287df75a", 0.0f));
                    break;
                case 54336641:
                    int i15 = f26 * (f24 + 6194);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-20, -97, -70, -109, -22, -86, -22, -103}, "77a1151833e8e5", 0.0f));
                    break;
                case 54357755:
                    return C0009.m350(f28, 52, 335065518 ^ C0007.f73, 3);
                case 54358680:
                    int i16 = f26 * (f24 | 3413);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-30, -104, -24, -107, -20, -57, -24, -58}, "99377b3ac871"));
                    break;
                case 54359517:
                    int i17 = f26 * (f24 + 2073);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-71, -64, -22, -111, -67, -51, -70, -5}, "bc11fead"));
                    break;
                case 54360515:
                    int i18 = f26 * (f24 | 7417);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-19, -108, -65, -108, -67, -3, -20, -62}, "60d7fb7f4a6f32", 2));
                    break;
                case 54391291:
                    int i19 = f26 * (f24 ^ 4249);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-70, -110, -20, -106, -19, -62, -17, -64}, "a4766a4a61a93d", 0.0f));
                    break;
                case 54392441:
                    int i20 = f26 * (f24 | 8049);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-67, -107, -18, -106, -23, -59, -17, -105}, "f3542e402886", 0.0f));
                    break;
                case 54420060:
                    int i21 = f26 * (f24 | 5542);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-21, -109, -24, -108, -66, -63, -70, -109}, "0731eaa0d8fb9cb8", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡ۠ۦۥۥۨ, reason: not valid java name and contains not printable characters */
    private static String m112() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-17, -101, -72, -106, -19, -53, -70, -98}, "43c36ca8b15cbb"));
        while (true) {
            switch (iM309) {
                case 54186757:
                    int i = f26 * (f24 + 7979);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-71, -110, -21, -112, -65, -107, -71, -58}, "b604d1bd268d"));
                    break;
                case 54212551:
                    int i2 = f26 * (f24 | 2051);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-29, -108, -67, -59, -19, -53, -21, -106}, "81fc6c065c0511ea", 0.0f));
                    break;
                case 54212580:
                    int i3 = f26 * (f24 | 7865);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-24, -99, -22, -111, -23, -109, -71, -59}, "351025bb9d7782", true));
                    break;
                case 54212736:
                    int i4 = f26 * (f24 | 2843);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-17, -108, -22, -109, -71, -97, -71, -64}, "4712b9bfde4941", true));
                    break;
                case 54217322:
                    return C0009.m350(f28, 23, 1896595157 ^ C0000.f59, 3);
                case 54238497:
                    int i5 = f26 * (f24 + 7119);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-19, -105, -24, -98, -65, -61, -20, -58}, "6739de7b82bb", false));
                    break;
                case 54246120:
                    int i6 = f26 * (f24 ^ 3932);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-23, -108, -19, -99, -18, -61, -23, -110}, "20655e", 3));
                    break;
                case 54270366:
                    int i7 = f26 * (f24 | 6782);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-67, -104, -22, -60, -71, -111, -19, -111}, "f01eb166920d4a95", 0));
                    break;
                case 54273025:
                    int i8 = f26 * (f24 | 5779);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-29, -58, -72, -112, -66, -106, -72, -64}, "8ac8e5cf", 2));
                    break;
                case 54273278:
                    int i9 = f26 * (f24 | 7569);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-18, -109, -65, -58, -71, -84, -22, -105}, "51dab315c1", 2));
                    break;
                case 54302974:
                    int i10 = f26 * (f24 + 7742);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-21, -109, -19, -105, -71, -62, -70, -112}, "0666bba773"));
                    break;
                case 54306880:
                    int i11 = f26 * (f24 + 6940);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-66, -107, -72, -102, -17, -60, -20, -107}, "e4c94f7125", false));
                    break;
                case 54329763:
                    int i12 = f26 * (f24 | 2818);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-17, -111, -66, -61, -17, -109, -29, -111}, "46ef44805cfe07ce", 1));
                    break;
                case 54334809:
                    int i13 = f26 * (f24 + 7520);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-21, -60, -23, -105, -67, -105, -22, -99}, "0e24f018fbe3b56f", 0.0f));
                    break;
                case 54393159:
                    int i14 = f26 * (f24 | 6394);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-23, -59, -65, -109, -17, -90, -21, -85}, "2fd74904", 0.0f));
                    break;
                case 54393187:
                    int i15 = f26 * (f24 | 696);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-66, -103, -20, -63, -19, -59, -66, -98}, "e87b6d", false));
                    break;
                case 54393400:
                    int i16 = f26 * (f24 + 4644);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-70, -109, -22, -108, -24, -63, -29, -110}, "a4113a879b2c57"));
                    break;
                case 54396164:
                    int i17 = f26 * (f24 ^ 6638);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-19, -110, -21, -85, -19, -108, -18, -60}, "6004655a66", 0.0f));
                    break;
                case 54419136:
                    int i18 = f26 * (f24 + 7799);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-21, -110, -30, -57, -67, -109, -71, -100}, "019cf4b8d9", 2));
                    break;
                case 54419322:
                    int i19 = f26 * (f24 ^ 6356);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-71, -64, -19, -102, -19, -61, -20, -62}, "ba626c7a21bc8c1a", 0.0f));
                    break;
                case 54423227:
                    int i20 = f26 * (f24 + 4216);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-21, -112, -22, -100, -65, -89, -67, -51}, "0719d8fec808421a", 4));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۢۦ۟ۦ, reason: not valid java name and contains not printable characters */
    private static String m113() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-21, -106, -70, -54, -29, -111, -23, -59}, "02ab852e18a7522b", false));
        while (true) {
            switch (iM316) {
                case 54149277:
                    int i = f26 * (f24 ^ 3379);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-23, -112, -29, -58, -66, -111, -17, -59}, "278ce74c9440ec"));
                    break;
                case 54179998:
                    int i2 = f26 * (f24 ^ 4439);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-17, -62, -71, -59, -30, -110, -19, -108}, "4bbb9360fc24", 0.0f));
                    break;
                case 54180033:
                    int i3 = f26 * (f24 ^ 8062);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-70, -106, -21, -105, -23, -103, -22, -61}, "a204291f3a4792b7", 1));
                    break;
                case 54180834:
                    int i4 = f26 * (f24 + 3978);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-21, -106, -67, -62, -19, -109, -21, -111}, "06fb65", 1));
                    break;
                case 54183874:
                    int i5 = f26 * (f24 | 5002);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-66, -64, -22, -2, -22, -107, -65, -60}, "ed1a13ddc1", false));
                    break;
                case 54186602:
                    int i6 = f26 * (f24 | 7669);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-17, -103, -18, -6, -65, -106, -66, -112}, "485ed3e61413", 0.0f));
                    break;
                case 54208831:
                    int i7 = f26 * (f24 | 6663);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-72, -111, -20, -98, -70, -107, -18, -105}, "c776a050b86f5929", 7));
                    break;
                case 54211741:
                    int i8 = f26 * (f24 ^ 4800);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-30, -99, -24, -59, -67, -110, -30, -105}, "953af0", 0.0f));
                    break;
                case 54216420:
                    int i9 = f26 * (f24 + 3821);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-66, -110, -23, -105, -17, -90, -22, -2}, "e423491ab5c7926d"));
                    break;
                case 54298229:
                    int i10 = f26 * (f24 ^ 1837);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-21, -104, -71, -58, -17, -63, -71, -110}, "09ba4cb2", 7));
                    break;
                case 54301892:
                    int i11 = f26 * (f24 ^ 331);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-70, -106, -18, -58, -67, -58, -24, -98}, "a05bfe399a", true));
                    break;
                case 54303099:
                    int i12 = f26 * (f24 | 2934);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-17, -109, -22, -111, -29, -111, -24, -61}, "4310803a"));
                    break;
                case 54306816:
                    int i13 = f26 * (f24 | 7979);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-22, -104, -17, -112, -19, -63, -66, -111}, "18406de22017"));
                    break;
                case 54362398:
                    int i14 = f26 * (f24 + 4358);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-67, -61, -19, -63, -18, -59, -23, -106}, "fd6b5c2215", true));
                    break;
                case 54362530:
                    int i15 = f26 * (f24 | 8159);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-30, -81, -22, -2, -71, -64, -18, -64}, "901abf5cf01301", 0.0f));
                    break;
                case 54366436:
                    int i16 = f26 * (f24 | 1676);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-30, -61, -24, -58, -70, -57, -67, -111}, "9c3baaf5c0", 0.0f));
                    break;
                case 54391291:
                    return C0009.m350(f28, 61, 1854998862 ^ C0001.f61, 3);
                case 54391450:
                    int i17 = f26 * (f24 | 7808);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-66, -109, -23, -59, -20, -97, -70, -102}, "e72a77a9284e"));
                    break;
                case 54393374:
                    int i18 = f26 * (f24 | 6633);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-17, -103, -67, -59, -18, -106, -17, -112}, "41fe51"));
                    break;
                case 54395356:
                    int i19 = f26 * (f24 ^ 629);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-29, -107, -18, -112, -21, -64, -18, -59}, "82530a5ef955", false));
                    break;
                case 54418386:
                    int i20 = f26 * (f24 + 1764);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-19, -61, -24, -63, -65, -105, -71, -61}, "6b3cd1bac8", 7));
                    break;
                case 54422076:
                    int i21 = f26 * (f24 ^ 6080);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-19, -111, -67, -106, -29, -52, -30, -107}, "66f18d915c4615", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۦۢۧ, reason: not valid java name and contains not printable characters */
    public static int m114() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-72, -109, -30, -110, -65, -109, -65, -110}, "c595d4d6dd9e6fc8"));
        while (true) {
            switch (iM330) {
                case 54181981:
                    int i = f26 * (f24 | 2257);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-18, -64, -18, -106, -67, -109, -72, -64}, "5b55f1cbfbdd", 0.0f));
                    break;
                case 54210808:
                    int i2 = f26 * (f24 + 7929);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-22, -105, -65, -60, -21, -62, -22, -109}, "12db0c"));
                    break;
                case 54240388:
                    int i3 = f26 * (f24 | 697);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-70, -102, -29, -108, -65, -60, -70, -107}, "a986daa2", 0.0f));
                    break;
                case 54242369:
                    int i4 = f26 * (f24 + 5111);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-22, -58, -22, -110, -72, -86, -22, -62}, "1e14c5", 7));
                    break;
                case 54244293:
                    int i5 = f26 * (f24 + 1431);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-70, -64, -66, -3, -72, -101, -71, -107}, "adebc9b479fc4d4b", 0.0f));
                    break;
                case 54247297:
                    int i6 = f26 * (f24 ^ 5584);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-72, -107, -19, -60, -66, -105, -66, -86}, "c06de5e5dd", 0.0f));
                    break;
                case 54271297:
                    int i7 = f26 * (f24 ^ 7732);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-66, -112, -22, -106, -21, -87, -22, -53}, "e716061cebabe0fc", 0.0f));
                    break;
                case 54272064:
                    int i8 = f26 * (f24 + 6254);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-71, -108, -67, -63, -23, -107, -24, -106}, "b2ff2136f6", 0.0f));
                    break;
                case 54274955:
                    int i9 = f26 * (f24 + 7843);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-71, -57, -17, -98, -20, -100, -71, -60}, "bd4678", 5));
                    break;
                case 54277025:
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    int i13 = 0;
                    char c = 48025;
                    while (true) {
                        switch (c) {
                            case 23678:
                                return i10;
                            case 31289:
                                i12 = (i12 + 87) % 39;
                                i13 = 1681660827;
                                break;
                            case 48025:
                                i13 = 76709145;
                                i12 = (i12 % 17) % 10;
                                i10 = 1947383958;
                                i11 = 1014547671;
                                c = 23928;
                                break;
                            case 23928:
                                i12 = 1907871740;
                                i13 %= 47;
                                i10 ^= i11;
                                c = 23678;
                                break;
                        }
                    }
                    break;
                case 54298106:
                    int i14 = f26 * (f24 + 8035);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-22, -101, -20, -57, -22, -89, -24, -3}, "187d183b740774", 1));
                    break;
                case 54328856:
                    int i15 = f26 * (f24 ^ 6401);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-70, -64, -71, -108, -30, -82, -71, -101}, "afb291b3a0de", 0.0f));
                    break;
                case 54334593:
                    int i16 = f26 * (f24 ^ 1021);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-66, -108, -17, -99, -71, -58, -67, -64}, "e648bdfd84ed1217", 0.0f));
                    break;
                case 54335741:
                    int i17 = f26 * (f24 | 6274);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-30, -108, -70, -107, -22, -111, -23, -60}, "96a4112a", 4));
                    break;
                case 54363454:
                    int i18 = f26 * (f24 + 5161);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-24, -112, -72, -111, -20, -105, -22, -107}, "38c474147f059d"));
                    break;
                case 54364329:
                    int i19 = f26 * (f24 ^ 2308);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-20, -108, -71, -111, -30, -108, -20, -109}, "71b693"));
                    break;
                case 54365437:
                    int i20 = f26 * (f24 | 614);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-19, -61, -70, -100, -24, -106, -19, -60}, "6ea934", true));
                    break;
                case 54365534:
                    int i21 = f26 * (f24 ^ 1679);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-19, -104, -23, -106, -18, -62, -72, -85}, "69275ec4028539", 0.0f));
                    break;
                case 54388354:
                    int i22 = f26 * (f24 + 5237);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-67, -105, -66, -102, -72, -59, -70, -111}, "f7e8cba36b8f", 0));
                    break;
                case 54423067:
                    int i23 = f26 * (f24 | 3439);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-18, -106, -20, -112, -67, -108, -24, -62}, "5478f23c", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۦۥ۠ۨ, reason: not valid java name and contains not printable characters */
    private static String m115() {
        int iM349 = C0009.m349(C0010.decode(new byte[]{-67, -64, -19, -109, -17, -108, -71, -109}, "fe6143b3a8", 2));
        while (true) {
            switch (iM349) {
                case 54150025:
                    int i = f26 * (f24 | 2874);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-23, -2, -71, -110, -20, -97, -20, -64}, "2ab1787bd82e6d2d"));
                    break;
                case 54152193:
                    int i2 = f26 * (f24 ^ 477);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-17, -55, -67, -108, -66, -64, -29, -57}, "4af0eb8c9c"));
                    break;
                case 54152196:
                    int i3 = f26 * (f24 + 6704);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-30, -109, -21, -61, -65, -108, -29, -105}, "950cd0877351f8d1", 7));
                    break;
                case 54153151:
                    int i4 = f26 * (f24 ^ 3725);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-67, -88, -71, -105, -67, -109, -72, -109}, "f7b5f4c6a6"));
                    break;
                case 54157957:
                    int i5 = f26 * (f24 ^ 1052);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-70, -98, -72, -61, -20, -5, -21, -57}, "a6cc7d0baaa3bd"));
                    break;
                case 54181862:
                    int i6 = f26 * (f24 | 7253);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-66, -103, -20, -61, -30, -58, -65, -107}, "e87e9cd6ab8441"));
                    break;
                case 54183783:
                    int i7 = f26 * (f24 + 6229);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-30, -59, -18, -111, -19, -4, -24, -61}, "9d506c3f", 1));
                    break;
                case 54210560:
                    int i8 = f26 * (f24 ^ 3742);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-18, -61, -21, -108, -66, -111, -30, -62}, "5c06e29ecc49"));
                    break;
                case 54210566:
                    int i9 = f26 * (f24 | 2030);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-30, -111, -20, -59, -72, -82, -65, -81}, "907dc1d08fa66fd3"));
                    break;
                case 54211525:
                    return C0009.m350(f28, 131, 436607075 ^ C0001.f61, 3);
                case 54215555:
                    int i10 = f26 * (f24 + 4345);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-20, -90, -20, -112, -17, -6, -24, -61}, "79704e3d", 0.0f));
                    break;
                case 54243460:
                    int i11 = f26 * (f24 ^ 6443);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-19, -58, -18, -106, -29, -60, -72, -105}, "6a538cc3d3f7", 4));
                    break;
                case 54268314:
                    int i12 = f26 * (f24 + 6921);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-30, -111, -70, -105, -66, -107, -30, -52}, "93a3e39d", 2));
                    break;
                case 54330872:
                    int i13 = f26 * (f24 | 1958);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-70, -88, -24, -58, -67, -106, -66, -52}, "a73df1ed454eea", 3));
                    break;
                case 54330934:
                    int i14 = f26 * (f24 | 4944);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-20, -59, -23, -81, -24, -60, -18, -107}, "7f203f55", true));
                    break;
                case 54335772:
                    int i15 = f26 * (f24 + 4530);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-72, -82, -71, -99, -20, -110, -23, -101}, "c1b5752826b543bf", 0));
                    break;
                case 54358710:
                    int i16 = f26 * (f24 + 1477);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-17, -64, -70, -112, -21, -84, -17, -62}, "4aa203", false));
                    break;
                case 54393403:
                    int i17 = f26 * (f24 ^ 2506);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-72, -108, -72, -105, -18, -111, -23, -64}, "c1c0592b", 6));
                    break;
                case 54418142:
                    int i18 = f26 * (f24 ^ 3732);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-67, -60, -18, -106, -70, -107, -29, -60}, "fd52a68b3d3d6d39", 6));
                    break;
                case 54422078:
                    int i19 = f26 * (f24 + 3594);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-71, -111, -19, -106, -72, -106, -19, -111}, "b464c361fdb35a0e", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۧۤ۟ۢۤ, reason: not valid java name and contains not printable characters */
    private static String m116() {
        int iM349 = C0009.m349(C0010.decode(new byte[]{-22, -104, -17, -58, -19, -109, -24, -112}, "184c653808d98117"));
        while (true) {
            switch (iM349) {
                case 54157800:
                    int i = f26 * (f24 + 1056);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-70, -104, -67, -112, -72, -64, -72, -111}, "a0f1cfc3", 0.0f));
                    break;
                case 54180834:
                    int i2 = f26 * (f24 ^ 6379);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-22, -59, -18, -82, -24, -64, -18, -59}, "1d513b5e070a", true));
                    break;
                case 54181736:
                    int i3 = f26 * (f24 ^ 1130);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-20, -57, -18, -107, -30, -99, -29, -60}, "7f51998e1a7ff399", 0.0f));
                    break;
                case 54184839:
                    int i4 = f26 * (f24 | 425);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-24, -57, -66, -59, -24, -101, -65, -64}, "3eee38dff0", true));
                    break;
                case 54186787:
                    int i5 = f26 * (f24 ^ 1675);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-71, -112, -17, -63, -70, -63, -24, -111}, "b44bae37", true));
                    break;
                case 54208732:
                    int i6 = f26 * (f24 + 4862);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-29, -102, -67, -106, -19, -98, -72, -81}, "88f469c0572e", 6));
                    break;
                case 54208771:
                    int i7 = f26 * (f24 + 3559);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-21, -64, -21, -107, -23, -81, -67, -62}, "0c0220fbf963fd58", 3));
                    break;
                case 54210809:
                    int i8 = f26 * (f24 + 2483);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-29, -105, -30, -83, -67, -63, -17, -98}, "8592ff495f4326", 5));
                    break;
                case 54213600:
                    int i9 = f26 * (f24 ^ 20);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-29, -3, -70, -50, -21, -106, -66, -104}, "8baf04e9"));
                    break;
                case 54238685:
                    int i10 = f26 * (f24 | 6862);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-22, -111, -19, -6, -22, -61, -66, -88}, "146e1de7adb8d2", 0.0f));
                    break;
                case 54239521:
                    int i11 = f26 * (f24 | 8022);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-30, -105, -67, -105, -20, -98, -21, -110}, "97f0790123af", 0.0f));
                    break;
                case 54239645:
                    int i12 = f26 * (f24 ^ 1245);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-67, -105, -22, -112, -65, -108, -70, -64}, "f711d5ab6d"));
                    break;
                case 54241560:
                    int i13 = f26 * (f24 | 3638);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-70, -104, -70, -60, -71, -107, -23, -112}, "a9aeb2204476", 0.0f));
                    break;
                case 54275909:
                    int i14 = f26 * (f24 ^ 1970);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-71, -60, -24, -107, -70, -5, -24, -102}, "ba36ad3970"));
                    break;
                case 54298261:
                    int i15 = f26 * (f24 + 3599);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-21, -59, -67, -104, -23, -106, -66, -60}, "0cf825eaec9216cd", 0.0f));
                    break;
                case 54302017:
                    int i16 = f26 * (f24 | 2703);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-17, -57, -66, -60, -21, -109, -17, -61}, "4eed04"));
                    break;
                case 54306910:
                    int i17 = f26 * (f24 ^ 1518);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-17, -112, -18, -106, -65, -86, -30, -106}, "4054d593d56485f1", 0.0f));
                    break;
                case 54328050:
                    int i18 = f26 * (f24 ^ 3347);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-30, -106, -72, -98, -65, -110, -23, -108}, "91c9d720"));
                    break;
                case 54331650:
                    int i19 = f26 * (f24 ^ 3014);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-72, -99, -17, -111, -17, -97, -30, -60}, "c949489ea43168bb", true));
                    break;
                case 54358684:
                    int i20 = f26 * (f24 | 6106);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-24, -61, -18, -86, -21, -64, -24, -54}, "3b550c"));
                    break;
                case 54395263:
                    int i21 = f26 * (f24 + 4212);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-70, -62, -23, -4, -72, -97, -70, -64}, "af2cc8aaaf2a", 0.0f));
                    break;
                case 54419317:
                    return C0009.m350(f28, 82, 651543140 ^ C0000.f59, 3);
            }
        }
    }

    /* JADX INFO: renamed from: ۡۨۥۥ, reason: not valid java name and contains not printable characters */
    private static String m117() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-71, -87, -17, -64, -65, -51, -71, -105}, "b64bde", 0.0f));
        while (true) {
            switch (iM316) {
                case 54151011:
                    int i = f26 * (f24 | 811);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-30, -57, -19, -57, -22, -112, -17, -63}, "9c6a174e94a003", 1));
                    break;
                case 54152220:
                    int i2 = f26 * (f24 | 819);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-29, -105, -30, -110, -70, -61, -24, -106}, "8393aa371d14", false));
                    break;
                case 54154047:
                    int i3 = f26 * (f24 + 7389);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-20, -108, -66, -105, -70, -108, -19, -105}, "77e5a165", 0.0f));
                    break;
                case 54217289:
                    int i4 = f26 * (f24 ^ 5592);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-21, -58, -19, -105, -23, -58, -21, -62}, "0a612f", 6));
                    break;
                case 54271292:
                    int i5 = f26 * (f24 + 2399);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-17, -100, -17, -64, -23, -111, -65, -112}, "494b20d4e237dbcb", false));
                    break;
                case 54275913:
                    int i6 = f26 * (f24 | 6086);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-65, -50, -17, -50, -30, -107, -30, -105}, "df4f9094b4355566", 0.0f));
                    break;
                case 54300028:
                    int i7 = f26 * (f24 + 335);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-71, -59, -17, -111, -66, -89, -29, -57}, "bc44e88c", 0.0f));
                    break;
                case 54301115:
                    int i8 = f26 * (f24 ^ 3226);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-72, -111, -70, -99, -17, -98, -29, -108}, "c6a54980562aa5bd", 0.0f));
                    break;
                case 54304990:
                    return C0009.m350(f28, 79, 1307050474 ^ C0001.f61, 3);
                case 54304991:
                    int i9 = f26 * (f24 | 1873);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-70, -104, -21, -102, -30, -3, -70, -111}, "a9029ba0a3325f", 0.0f));
                    break;
                case 54330752:
                    int i10 = f26 * (f24 + 7624);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-20, -58, -65, -107, -20, -58, -20, -63}, "7bd37a"));
                    break;
                case 54330941:
                    int i11 = f26 * (f24 + 2485);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-29, -82, -66, -104, -29, -60, -17, -110}, "81e98d43db15"));
                    break;
                case 54363364:
                    int i12 = f26 * (f24 ^ 7757);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-23, -98, -70, -104, -19, -51, -67, -100}, "29a06ef87e5a"));
                    break;
                case 54363391:
                    int i13 = f26 * (f24 + 80);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-29, -98, -67, -112, -18, -82, -17, -3}, "89f0514b20c2"));
                    break;
                case 54388345:
                    int i14 = f26 * (f24 | 1925);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-30, -105, -30, -109, -18, -61, -23, -110}, "93915e21407215e9", 0.0f));
                    break;
                case 54394146:
                    int i15 = f26 * (f24 + 4846);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-17, -111, -22, -109, -24, -83, -17, -106}, "421432"));
                    break;
                case 54396286:
                    int i16 = f26 * (f24 ^ 1969);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-17, -61, -24, -101, -72, -110, -17, -105}, "4f39c540", 7));
                    break;
                case 54396317:
                    int i17 = f26 * (f24 + 1075);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-72, -102, -66, -109, -21, -61, -18, -107}, "c2e30e50ab306c", false));
                    break;
                case 54418359:
                    int i18 = f26 * (f24 + 1801);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-65, -97, -71, -99, -29, -63, -65, -103}, "d9b88a", 3));
                    break;
                case 54426014:
                    int i19 = f26 * (f24 | 3198);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-17, -50, -65, -51, -66, -54, -30, -60}, "4fdeeb9a8354fa"));
                    break;
                case 54426109:
                    int i20 = f26 * (f24 ^ 1994);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-67, -83, -18, -110, -18, -61, -21, -81}, "f2565f005bc036", 4));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۨۧ۟, reason: not valid java name and contains not printable characters */
    private static String m118() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-66, -99, -20, -109, -24, -60, -66, -112}, "e5733f"));
        while (true) {
            switch (iM324) {
                case 54151970:
                    int i = f26 * (f24 + 1893);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-70, -111, -72, -89, -18, -63, -71, -63}, "a7c85bbab1639004", false));
                    break;
                case 54152032:
                    int i2 = f26 * (f24 | 3703);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-22, -55, -66, -99, -17, -55, -17, -112}, "1ae84a44a4b0"));
                    break;
                case 54184775:
                    int i3 = f26 * (f24 | 4650);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-23, -99, -67, -59, -72, -57, -29, -111}, "28ffcd8334c09e", 0.0f));
                    break;
                case 54186815:
                    int i4 = f26 * (f24 ^ 6167);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-67, -103, -23, -61, -22, -60, -65, -61}, "f82f1edc79"));
                    break;
                case 54209601:
                    int i5 = f26 * (f24 ^ 6477);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-22, -112, -71, -89, -19, -111, -30, -100}, "16b86299a01a1b8c", 7));
                    break;
                case 54214467:
                    int i6 = f26 * (f24 + 4968);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-17, -111, -20, -57, -72, -63, -70, -110}, "447fcba34bdb442e", false));
                    break;
                case 54243426:
                    int i7 = f26 * (f24 | 997);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-20, -110, -70, -61, -65, -110, -66, -107}, "77acd7e2c5", false));
                    break;
                case 54245443:
                    return C0009.m350(f28, 100, 1475392032 ^ C0009.f77, 3);
                case 54268507:
                    int i8 = f26 * (f24 | 5356);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-29, -112, -71, -59, -72, -85, -20, -110}, "81bec473eab9", 2));
                    break;
                case 54328957:
                    int i9 = f26 * (f24 + 6690);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-67, -104, -20, -107, -22, -100, -67, -104}, "f87214", 3));
                    break;
                case 54329850:
                    int i10 = f26 * (f24 | 5965);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-65, -60, -18, -59, -22, -54, -19, -98}, "df5c1b6951dc0c", 0.0f));
                    break;
                case 54330693:
                    int i11 = f26 * (f24 + 241);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-66, -6, -17, -101, -21, -106, -17, -86}, "ee490445f2e9", false));
                    break;
                case 54331773:
                    int i12 = f26 * (f24 | 4457);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-29, -107, -23, -59, -22, -112, -65, -5}, "832b15dd5448"));
                    break;
                case 54357718:
                    int i13 = f26 * (f24 + 1797);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-67, -60, -71, -97, -19, -62, -23, -107}, "fcb76e21ae429c", 0));
                    break;
                case 54357723:
                    int i14 = f26 * (f24 | 7539);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-65, -105, -67, -97, -65, -110, -29, -107}, "d1f8d78505de", 0.0f));
                    break;
                case 54365467:
                    int i15 = f26 * (f24 ^ 4829);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-71, -109, -20, -60, -66, -3, -67, -108}, "b67febf329a8cc3e"));
                    break;
                case 54365468:
                    int i16 = f26 * (f24 | 2326);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-22, -82, -21, -64, -20, -104, -71, -85}, "110b78b49a97", false));
                    break;
                case 54396286:
                    int i17 = f26 * (f24 ^ 2727);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-72, -58, -22, -109, -22, -100, -21, -112}, "cd171905be", 0.0f));
                    break;
                case 54418235:
                    int i18 = f26 * (f24 ^ 5268);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-20, -104, -19, -64, -66, -108, -22, -105}, "786ee011"));
                    break;
                case 54423225:
                    int i19 = f26 * (f24 + 5360);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-24, -63, -22, -3, -71, -99, -67, -110}, "3b1bb5f53c00", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۡ۟ۦ۟ۡ, reason: not valid java name and contains not printable characters */
    private static String m119() {
        int iM337 = C0007.m337(C0010.decode(new byte[]{-24, -62, -18, -60, -72, -58, -24, -108}, "3f5ecb35691def", 7));
        while (true) {
            switch (iM337) {
                case 54151103:
                    int i = f26 * (f24 | 5277);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-72, -104, -22, -63, -66, -103, -30, -109}, "c81de196", 0.0f));
                    break;
                case 54157736:
                    return C0009.m350(f28, 94, 299979384 ^ C0001.f61, 3);
                case 54184898:
                    int i2 = f26 * (f24 | 1929);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-23, -98, -23, -110, -29, -63, -23, -97}, "28258a28712fa17d", 0.0f));
                    break;
                case 54213604:
                    int i3 = f26 * (f24 | 6835);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-71, -59, -65, -107, -21, -97, -18, -64}, "bad3095a729bbe76"));
                    break;
                case 54238461:
                    int i4 = f26 * (f24 + 3194);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-71, -64, -18, -100, -65, -86, -65, -61}, "bc58d5dcb3"));
                    break;
                case 54238622:
                    int i5 = f26 * (f24 + 2707);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-19, -112, -24, -7, -21, -107, -72, -112}, "633f02c530", 7));
                    break;
                case 54268474:
                    int i6 = f26 * (f24 ^ 1016);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-65, -106, -30, -112, -24, -63, -29, -60}, "d3953c8df91cac", true));
                    break;
                case 54273026:
                    int i7 = f26 * (f24 | 5214);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-20, -64, -17, -105, -30, -61, -24, -85}, "7c419c34", true));
                    break;
                case 54274978:
                    int i8 = f26 * (f24 | 2925);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-71, -106, -71, -60, -17, -112, -66, -107}, "b2ba40e4b9b21f"));
                    break;
                case 54298144:
                    int i9 = f26 * (f24 + 2281);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-30, -103, -19, -111, -66, -100, -30, -109}, "9865e89603"));
                    break;
                case 54300090:
                    int i10 = f26 * (f24 ^ 6995);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-30, -64, -21, -112, -70, -64, -18, -64}, "9d04ac5d9825ec41", 6));
                    break;
                case 54302945:
                    int i11 = f26 * (f24 | 1828);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-24, -59, -23, -112, -66, -111, -20, -109}, "3c25e6716e", 0.0f));
                    break;
                case 54303810:
                    int i12 = f26 * (f24 + 766);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-30, -4, -67, -100, -24, -108, -23, -2}, "9cf4342a91a71568"));
                    break;
                case 54304957:
                    int i13 = f26 * (f24 ^ 4324);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-21, -106, -66, -6, -66, -64, -30, -110}, "04eeee94b5af"));
                    break;
                case 54330747:
                    int i14 = f26 * (f24 | 4681);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-18, -61, -65, -106, -24, -112, -29, -61}, "5ed3368aec982d97", false));
                    break;
                case 54333662:
                    int i15 = f26 * (f24 + 4978);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-30, -112, -22, -109, -20, -59, -30, -86}, "95117d", true));
                    break;
                case 54363486:
                    int i16 = f26 * (f24 ^ 7547);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-66, -62, -17, -59, -67, -111, -66, -62}, "ee4cf7"));
                    break;
                case 54363579:
                    int i17 = f26 * (f24 + 5326);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-70, -59, -20, -106, -29, -105, -24, -105}, "ac738435e9ca"));
                    break;
                case 54363610:
                    int i18 = f26 * (f24 | 7506);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-17, -52, -18, -112, -71, -108, -70, -111}, "4d52b2a0", 4));
                    break;
                case 54365320:
                    int i19 = f26 * (f24 + 5212);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-18, -106, -66, -90, -29, -109, -30, -50}, "52e9809f50"));
                    break;
                case 54394336:
                    int i20 = f26 * (f24 + 5514);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-70, -108, -72, -86, -70, -106, -19, -62}, "a6c5a66bdf", false));
                    break;
                case 54396257:
                    int i21 = f26 * (f24 | 4190);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-17, -3, -20, -64, -29, -109, -17, -62}, "4b7a80", true));
                    break;
                case 54420277:
                    int i22 = f26 * (f24 ^ 3366);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-71, -63, -23, -50, -72, -110, -22, -111}, "bf2fc41722e3", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۡۦۤۨۦ, reason: not valid java name and contains not printable characters */
    private static String m120() {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-29, -102, -19, -62, -29, -60, -22, -109}, "896a8e14373e2213", 6));
        while (true) {
            switch (iM311) {
                case 54150984:
                    int i = f26 * (f24 ^ 5414);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-67, -64, -66, -107, -71, -82, -22, -104}, "fde2b1102062", 0.0f));
                    break;
                case 54157836:
                    int i2 = f26 * (f24 + 5093);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-21, -53, -29, -62, -29, -109, -67, -97}, "0c8d86f9c8a2a26d", 0));
                    break;
                case 54179998:
                    int i3 = f26 * (f24 ^ 5880);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-70, -110, -24, -101, -29, -111, -72, -107}, "a13880c0d09fc907", false));
                    break;
                case 54180807:
                    int i4 = f26 * (f24 ^ 2597);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-22, -85, -20, -64, -21, -4, -72, -112}, "147a0cc5230f", 0.0f));
                    break;
                case 54183840:
                    int i5 = f26 * (f24 + 710);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-23, -102, -21, -106, -23, -111, -20, -60}, "2802227acc", true));
                    break;
                case 54184896:
                    int i6 = f26 * (f24 ^ 2519);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-17, -64, -66, -4, -22, -107, -17, -55}, "4aec13", true));
                    break;
                case 54208864:
                    int i7 = f26 * (f24 | 2123);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-67, -83, -18, -51, -21, -62, -71, -60}, "f25e0abbf9e84c18", 0.0f));
                    break;
                case 54243364:
                    return C0009.m350(f28, 50, 840576982 ^ C0007.f73, 2);
                case 54245195:
                    int i8 = f26 * (f24 + 2891);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-30, -50, -20, -104, -22, -58, -17, -7}, "9f791d4f2d"));
                    break;
                case 54268438:
                    int i9 = f26 * (f24 ^ 6461);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-66, -110, -24, -107, -29, -62, -66, -105}, "e6378ee48060c2ab", 1));
                    break;
                case 54272132:
                    int i10 = f26 * (f24 ^ 1602);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-71, -112, -24, -97, -18, -63, -70, -112}, "b2395aa7", true));
                    break;
                case 54272134:
                    int i11 = f26 * (f24 | 5145);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-20, -58, -24, -111, -19, -107, -72, -101}, "7f3160c8", 0.0f));
                    break;
                case 54273127:
                    int i12 = f26 * (f24 + 1974);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-71, -112, -67, -57, -22, -50, -22, -105}, "b0fb1f14a636", 0.0f));
                    break;
                case 54301146:
                    int i13 = f26 * (f24 | 5427);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-21, -57, -29, -64, -72, -59, -66, -62}, "0a8fcaef"));
                    break;
                case 54305708:
                    int i14 = f26 * (f24 + 1551);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-30, -57, -19, -105, -19, -109, -30, -61}, "9b6767", 0.0f));
                    break;
                case 54328920:
                    int i15 = f26 * (f24 + 1279);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-66, -97, -23, -107, -22, -57, -17, -4}, "e8201b4cace065", 2));
                    break;
                case 54364480:
                    int i16 = f26 * (f24 + 5414);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-30, -109, -67, -63, -24, -101, -65, -98}, "90fe39d6f53f", 7));
                    break;
                case 54393336:
                    int i17 = f26 * (f24 | 2764);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-72, -103, -70, -58, -19, -112, -23, -105}, "c9ab6526200b36d7", false));
                    break;
                case 54418324:
                    int i18 = f26 * (f24 ^ 3870);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-29, -111, -30, -3, -24, -62, -66, -63}, "829b3dea87", 0.0f));
                    break;
                case 54419190:
                    int i19 = f26 * (f24 ^ 1107);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-24, -99, -20, -108, -19, -111, -67, -59}, "357464fd", true));
                    break;
                case 54424095:
                    int i20 = f26 * (f24 | 6411);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-19, -112, -70, -57, -29, -107, -21, -112}, "60af850684", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۥۦۥ, reason: not valid java name and contains not printable characters */
    private static String m121() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-71, -99, -20, -106, -65, -102, -23, -57}, "b872d22bd4", 4));
        while (true) {
            switch (iM309) {
                case 54151229:
                    int i = f26 * (f24 + 7336);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-17, -57, -66, -99, -17, -62, -17, -50}, "4fe84e", 7));
                    break;
                case 54153086:
                    int i2 = f26 * (f24 ^ 1903);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-20, -111, -20, -99, -17, -63, -17, -109}, "76794c453e72", 7));
                    break;
                case 54155819:
                    int i3 = f26 * (f24 + 6376);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-30, -57, -21, -108, -18, -105, -72, -111}, "9a0553c43b", 0.0f));
                    break;
                case 54156842:
                    int i4 = f26 * (f24 ^ 5412);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-19, -55, -67, -60, -21, -111, -19, -60}, "6afc01", true));
                    break;
                case 54181950:
                    return C0009.m350(f28, 44, 1229376245 ^ C0003.f65, 3);
                case 54214661:
                    int i5 = f26 * (f24 | 6083);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-24, -110, -19, -98, -66, -110, -24, -103}, "3166e4", 0));
                    break;
                case 54241562:
                    int i6 = f26 * (f24 ^ 2530);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-66, -64, -66, -59, -18, -4, -67, -58}, "efef5cfd4c464b", 2));
                    break;
                case 54276132:
                    int i7 = f26 * (f24 | 2313);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-24, -97, -70, -59, -70, -61, -22, -63}, "39afaf1d7a354b", true));
                    break;
                case 54277095:
                    int i8 = f26 * (f24 ^ 1315);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-21, -51, -65, -90, -20, -109, -65, -89}, "0ed974d82d1f", false));
                    break;
                case 54332731:
                    int i9 = f26 * (f24 ^ 1420);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-72, -58, -20, -111, -66, -64, -72, -55}, "ca79ee", 0));
                    break;
                case 54332892:
                    int i10 = f26 * (f24 + 7607);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-20, -2, -30, -59, -71, -110, -71, -107}, "7a9cb2b12b", 0.0f));
                    break;
                case 54359676:
                    int i11 = f26 * (f24 | 893);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-71, -64, -17, -107, -29, -108, -66, -105}, "bc4282e162"));
                    break;
                case 54361440:
                    int i12 = f26 * (f24 ^ 5010);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-20, -90, -72, -111, -17, -63, -23, -58}, "79c64c2b1f", 2));
                    break;
                case 54361629:
                    int i13 = f26 * (f24 + 6778);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-29, -87, -21, -112, -18, -63, -24, -89}, "86035d38d0a181", 0.0f));
                    break;
                case 54388600:
                    int i14 = f26 * (f24 | 5631);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-20, -57, -67, -112, -21, -112, -20, -86}, "7bf40375266cc5", 0));
                    break;
                case 54392289:
                    int i15 = f26 * (f24 ^ 1778);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-70, -110, -71, -62, -70, -62, -70, -109}, "a5bbae", 0.0f));
                    break;
                case 54396228:
                    int i16 = f26 * (f24 ^ 6802);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-18, -112, -23, -102, -30, -63, -19, -112}, "52289f610cc7", 1));
                    break;
                case 54417423:
                    int i17 = f26 * (f24 | 587);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-67, -52, -71, -111, -72, -112, -71, -64}, "fdb5c1be0c07", true));
                    break;
                case 54422048:
                    int i18 = f26 * (f24 ^ 4611);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-20, -109, -72, -57, -30, -108, -70, -106}, "73ce92a42e06", 0));
                    break;
                case 54424900:
                    int i19 = f26 * (f24 + 2739);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-30, -89, -22, -111, -24, -98, -24, -107}, "981039375cf65f", 4));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۦۧۧ, reason: not valid java name and contains not printable characters */
    public static int m122() {
        int iM337 = C0007.m337(C0010.decode(new byte[]{-21, -103, -19, -103, -21, -109, -65, -106}, "016900d6ce85", 0.0f));
        while (true) {
            switch (iM337) {
                case 54156934:
                    int i = f26 * (f24 + 586);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-22, -64, -67, -109, -70, -111, -17, -104}, "1af7a74982da45"));
                    break;
                case 54184802:
                    int i2 = f26 * (f24 ^ 6529);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-19, -109, -65, -110, -20, -111, -29, -98}, "61d77688", false));
                    break;
                case 54209728:
                    int i3 = f26 * (f24 ^ 1216);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-20, -108, -17, -52, -20, -110, -20, -108}, "734d70", 6));
                    break;
                case 54212488:
                    int i4 = f26 * (f24 | 3495);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-22, -110, -24, -54, -66, -106, -22, -98}, "163be2", 0.0f));
                    break;
                case 54213662:
                    int i5 = f26 * (f24 ^ 5484);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-22, -110, -21, -108, -65, -101, -20, -61}, "1006d37bf335ac", 0.0f));
                    break;
                case 54238556:
                    int i6 = f26 * (f24 + 4094);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-18, -58, -30, -64, -29, -101, -70, -98}, "5b9a89a65935"));
                    break;
                case 54241593:
                    int i7 = f26 * (f24 | 993);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-70, -54, -67, -64, -72, -57, -21, -106}, "abffcc05", 0.0f));
                    break;
                case 54244450:
                    int i8 = f26 * (f24 | 2246);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-65, -105, -21, -104, -20, -111, -24, -59}, "d608723a"));
                    break;
                case 54275914:
                    int i9 = f26 * (f24 | 845);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-22, -52, -22, -88, -71, -109, -66, -105}, "1d17b3e7"));
                    break;
                case 54298292:
                    int i10 = f26 * (f24 | 7346);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-17, -63, -24, -109, -67, -100, -23, -101}, "4a36f929", 2));
                    break;
                case 54300035:
                    int i11 = f26 * (f24 ^ 5687);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-30, -103, -67, -106, -30, -90, -72, -112}, "98f599c534b3a0", 2));
                    break;
                case 54304836:
                    int i12 = f26 * (f24 ^ 360);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-72, -58, -23, -59, -66, -100, -72, -60}, "cb2be4", true));
                    break;
                case 54305985:
                    int i13 = f26 * (f24 + 3143);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-22, -57, -23, -112, -22, -106, -70, -63}, "1a2217ad", 5));
                    break;
                case 54306824:
                    int i14 = f26 * (f24 ^ 7809);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-30, -62, -19, -86, -21, -104, -65, -61}, "9f6500db9a", 0.0f));
                    break;
                case 54335556:
                    int i15 = f26 * (f24 | 4005);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-22, -107, -17, -111, -30, -58, -66, -58}, "12479dec416d47", false));
                    break;
                case 54360544:
                    int i16 = f26 * (f24 ^ 7703);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-70, -102, -29, -82, -67, -57, -18, -58}, "a881fd5d", 0.0f));
                    break;
                case 54393245:
                    int i17 = f26 * (f24 | 8180);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-29, -63, -24, -98, -22, -60, -29, -57}, "8d391e", 0.0f));
                    break;
                case 54394210:
                    int i18 = 0;
                    int i19 = 0;
                    int i20 = 0;
                    int i21 = 0;
                    char c = 37858;
                    while (true) {
                        switch (c) {
                            case 37858:
                                i21 += 46;
                                i20 = (i20 % 53) - i21;
                                i18 = 1399200336;
                                i19 = 1234872868;
                                c = 15582;
                                break;
                            case 15582:
                                int i22 = i20 % 10;
                                i20 = 454320712;
                                i18 ^= i19;
                                c = 48056;
                                break;
                            case 48056:
                                return i18;
                            case 13019:
                                i20 += 10;
                                int i23 = 712617251 % 54;
                                i21 = i23 ^ i23;
                                break;
                        }
                    }
                    break;
                case 54396134:
                    int i24 = f26 * (f24 + 5199);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-30, -101, -30, -106, -29, -6, -20, -110}, "98918e77efa0c2"));
                    break;
                case 54417207:
                    int i25 = f26 * (f24 ^ 2865);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-66, -60, -17, -109, -66, -111, -18, -111}, "ec46e350bf8e", 0.0f));
                    break;
                case 54418261:
                    int i26 = f26 * (f24 ^ 6366);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-23, -83, -67, -63, -21, -57, -21, -63}, "22ff0b0bf0cb40c2", true));
                    break;
                case 54424061:
                    int i27 = f26 * (f24 ^ 3786);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-70, -107, -71, -106, -21, -106, -30, -109}, "a1b0049755ae", 5));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۦۨۦ, reason: not valid java name and contains not printable characters */
    private static String m123() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-72, -61, -71, -64, -18, -111, -18, -112}, "cbbf57573ddb6eea", false));
        while (true) {
            switch (iM336) {
                case 54154980:
                    int i = f26 * (f24 + 7780);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-66, -107, -72, -110, -67, -110, -66, -110}, "e7c2f1", 4));
                    break;
                case 54156038:
                    int i2 = f26 * (f24 ^ 1290);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-23, -81, -70, -99, -30, -99, -17, -64}, "20a8994b", 2));
                    break;
                case 54184834:
                    int i3 = f26 * (f24 | 7719);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-67, -5, -29, -108, -72, -98, -17, -57}, "fd82c94a7c"));
                    break;
                case 54213601:
                    int i4 = f26 * (f24 + 7726);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-21, -103, -70, -110, -17, -61, -67, -63}, "09a74efb", 4));
                    break;
                case 54215590:
                    int i5 = f26 * (f24 + 457);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-30, -108, -66, -112, -66, -60, -30, -109}, "93e5ef", 4));
                    break;
                case 54216333:
                    int i6 = f26 * (f24 + 5587);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-70, -109, -17, -112, -71, -61, -24, -108}, "a643bb3732f5b3e3"));
                    break;
                case 54239519:
                    int i7 = f26 * (f24 + 3685);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-29, -101, -65, -61, -70, -106, -29, -97}, "89dfa1", 0.0f));
                    break;
                case 54239520:
                    return C0009.m350(f28, 6, 2029998905 ^ C0005.f69, 3);
                case 54244450:
                    int i8 = f26 * (f24 ^ 4837);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-21, -98, -71, -112, -18, -97, -22, -106}, "06b75715", 0.0f));
                    break;
                case 54270180:
                    int i9 = f26 * (f24 | 7686);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-66, -61, -21, -108, -18, -63, -20, -110}, "eb005e708f3eddf1", 4));
                    break;
                case 54299007:
                    int i10 = f26 * (f24 + 5569);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-17, -105, -65, -99, -18, -64, -17, -58}, "43d85d4becfbfa", 0.0f));
                    break;
                case 54302012:
                    int i11 = f26 * (f24 ^ 2459);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-66, -102, -20, -99, -72, -62, -65, -105}, "e278cad7745ff9", 4));
                    break;
                case 54303937:
                    int i12 = f26 * (f24 ^ 822);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-66, -58, -72, -58, -71, -111, -66, -63}, "eacbb2"));
                    break;
                case 54331712:
                    int i13 = f26 * (f24 ^ 6966);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-18, -107, -29, -104, -21, -111, -22, -62}, "5788021fbb136e90", 6));
                    break;
                case 54366250:
                    int i14 = f26 * (f24 + 2728);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-17, -62, -23, -109, -24, -86, -19, -64}, "4e26356b3a3d6891", 1));
                    break;
                case 54392314:
                    int i15 = f26 * (f24 ^ 6501);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-66, -108, -70, -51, -24, -87, -66, -109}, "e2ae36e40df5ed28", true));
                    break;
                case 54393153:
                    int i16 = f26 * (f24 ^ 3276);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-71, -58, -72, -109, -29, -107, -18, -109}, "bec28555172c0169"));
                    break;
                case 54393244:
                    int i17 = f26 * (f24 + 6835);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-24, -62, -20, -109, -21, -105, -70, -108}, "3f7003a551e7", false));
                    break;
                case 54423066:
                    int i18 = f26 * (f24 | 6093);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-19, -112, -71, -98, -67, -3, -19, -105}, "61b9fb", 0.0f));
                    break;
                case 54425146:
                    int i19 = f26 * (f24 + 1240);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-29, -105, -71, -105, -65, -62, -20, -107}, "83b7db76a732"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۨ۠۠, reason: not valid java name and contains not printable characters */
    private static String m124() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-66, -110, -67, -101, -66, -108, -18, -53}, "e7f9e55c", 7));
        while (true) {
            switch (iM309) {
                case 54150026:
                    int i = f26 * (f24 + 6818);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-70, -106, -22, -62, -72, -109, -19, -105}, "a41ec06799c0c4", 0.0f));
                    break;
                case 54154885:
                    int i2 = f26 * (f24 + 4849);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-22, -112, -24, -99, -70, -51, -22, -105}, "1735ae", 0.0f));
                    break;
                case 54184898:
                    int i3 = f26 * (f24 + 5296);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-70, -99, -67, -108, -71, -109, -70, -58}, "a8f7b5ab694b5a39", 4));
                    break;
                case 54208919:
                    int i4 = f26 * (f24 | 4735);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-72, -107, -22, -87, -70, -85, -67, -106}, "c016a4f5", 0.0f));
                    break;
                case 54217389:
                    int i5 = f26 * (f24 ^ 4917);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-24, -107, -17, -111, -67, -57, -19, -63}, "3343fd6fc4acd3ac", 4));
                    break;
                case 54242369:
                    int i6 = f26 * (f24 + 2138);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-20, -7, -24, -111, -72, -57, -30, -109}, "7f34cf930fd5"));
                    break;
                case 54245382:
                    int i7 = f26 * (f24 ^ 1066);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-29, -61, -22, -111, -30, -98, -21, -61}, "8e11990c33683c"));
                    break;
                case 54246242:
                    int i8 = f26 * (f24 ^ 6011);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-29, -105, -66, -107, -24, -104, -72, -105}, "83e230c3dab213", 0.0f));
                    break;
                case 54272102:
                    int i9 = f26 * (f24 ^ 7361);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-30, -106, -29, -112, -22, -106, -30, -108}, "938117", 0.0f));
                    break;
                case 54305983:
                    int i10 = f26 * (f24 | 2211);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-21, -57, -67, -107, -70, -106, -19, -108}, "0ef6a466"));
                    break;
                case 54327806:
                    int i11 = f26 * (f24 + 383);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-29, -58, -17, -64, -66, -106, -18, -88}, "8c4ae757bf", false));
                    break;
                case 54329786:
                    return C0009.m350(f28, 55, 1600028623 ^ C0002.f63, 3);
                case 54329794:
                    int i12 = f26 * (f24 ^ 7666);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-71, -57, -72, -62, -17, -57, -20, -107}, "baca4f7287350115", false));
                    break;
                case 54330756:
                    int i13 = f26 * (f24 ^ 2076);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-29, -103, -22, -60, -24, -108, -71, -97}, "811a34b7fd0ffa4b", false));
                    break;
                case 54331868:
                    int i14 = f26 * (f24 | 4315);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-67, -105, -67, -102, -21, -104, -17, -108}, "f4f908425e2d84", false));
                    break;
                case 54358803:
                    int i15 = f26 * (f24 ^ 7544);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-71, -108, -19, -6, -65, -103, -30, -59}, "b56ed19d3be314", 0.0f));
                    break;
                case 54360608:
                    int i16 = f26 * (f24 ^ 4585);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-67, -112, -29, -58, -23, -98, -67, -107}, "f08c26", false));
                    break;
                case 54361507:
                    int i17 = f26 * (f24 + 7556);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-17, -101, -22, -59, -66, -59, -30, -101}, "491cec932fdf", 0.0f));
                    break;
                case 54396313:
                    int i18 = f26 * (f24 + 7977);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-21, -102, -24, -90, -24, -97, -65, -59}, "023937dd51", 2));
                    break;
                case 54417456:
                    int i19 = f26 * (f24 + 6115);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-22, -107, -70, -52, -29, -61, -22, -104}, "14ad8a100e807f80", false));
                    break;
                case 54422981:
                    int i20 = f26 * (f24 + 7124);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-21, -81, -24, -106, -29, -3, -72, -112}, "00368bc8caa2"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢۨۨۢۦ۟, reason: not valid java name and contains not printable characters */
    private static String m125() {
        int iM321 = C0003.m321(C0010.decode(new byte[]{-72, -105, -72, -53, -21, -3, -18, -104}, "c2cc0b58717458"));
        while (true) {
            switch (iM321) {
                case 54149094:
                    int i = f26 * (f24 | 7752);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-71, -60, -71, -104, -71, -104, -17, -111}, "bbb8b8454f322fd4", false));
                    break;
                case 54208677:
                    int i2 = f26 * (f24 + 5970);
                    iM321 = C0000.m309(C0010.decode(new byte[]{-17, -100, -66, -89, -67, -104, -70, -109}, "44e8f8a01c60", 0.0f));
                    break;
                case 54209599:
                    int i3 = f26 * (f24 + 4530);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-66, -63, -65, -104, -29, -63, -22, -107}, "efd98b1255d38f", false));
                    break;
                case 54211587:
                    int i4 = f26 * (f24 ^ 7963);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-65, -62, -20, -87, -70, -103, -24, -108}, "dc76a9332824", true));
                    break;
                case 54215585:
                    int i5 = f26 * (f24 ^ 3430);
                    iM321 = C0006.m336(C0010.decode(new byte[]{-18, -105, -22, -99, -24, -111, -70, -85}, "501830a44c60"));
                    break;
                case 54240635:
                    int i6 = f26 * (f24 | 7985);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-22, -90, -19, -2, -22, -63, -22, -97}, "196a1a"));
                    break;
                case 54268442:
                    int i7 = f26 * (f24 | 3597);
                    iM321 = C0009.m349(C0010.decode(new byte[]{-21, -98, -70, -107, -18, -62, -72, -97}, "06a25dc955", 0.0f));
                    break;
                case 54269406:
                    int i8 = f26 * (f24 ^ 7707);
                    iM321 = C0008.m343(C0010.decode(new byte[]{-71, -53, -23, -106, -72, -99, -70, -105}, "bc24c5a45c8d9e", 0.0f));
                    break;
                case 54274055:
                    int i9 = f26 * (f24 + 4637);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-23, -105, -30, -102, -65, -106, -18, -106}, "2698d7555eb7", 0));
                    break;
                case 54300926:
                    int i10 = f26 * (f24 + 2561);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-20, -98, -65, -102, -67, -105, -70, -107}, "79d8f6a2", 4));
                    break;
                case 54336452:
                    int i11 = f26 * (f24 ^ 3596);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-23, -61, -21, -106, -23, -53, -23, -106}, "2a072c22", 2));
                    break;
                case 54358590:
                    int i12 = f26 * (f24 | 1491);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-72, -54, -67, -57, -67, -108, -72, -60}, "cbfbf7", 6));
                    break;
                case 54389438:
                    int i13 = f26 * (f24 ^ 3343);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-66, -58, -19, -82, -65, -97, -30, -106}, "ee61d9925796", false));
                    break;
                case 54390337:
                    return C0009.m350(f28, 122, 1352874931 ^ C0001.f61, 3);
                case 54393212:
                    int i14 = f26 * (f24 ^ 19);
                    iM321 = C0002.m316(C0010.decode(new byte[]{-23, -111, -29, -63, -66, -108, -30, -110}, "258ce492"));
                    break;
                case 54394336:
                    int i15 = f26 * (f24 + 1340);
                    iM321 = C0007.m337(C0010.decode(new byte[]{-19, -108, -20, -109, -29, -109, -29, -108}, "677682823dbe1e37", true));
                    break;
                case 54417210:
                    int i16 = f26 * (f24 | 5401);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-19, -64, -22, -110, -72, -87, -30, -83}, "6a12c692805c13fb", 0));
                    break;
                case 54420341:
                    int i17 = f26 * (f24 ^ 1641);
                    iM321 = C0004.m324(C0010.decode(new byte[]{-19, -101, -65, -112, -24, -59, -71, -108}, "63d73db3", true));
                    break;
                case 54423072:
                    int i18 = f26 * (f24 + 3801);
                    iM321 = C0009.m349(C0010.decode(new byte[]{-17, -58, -22, -108, -71, -97, -66, -109}, "4e14b9e4634465", 0.0f));
                    break;
                case 54424933:
                    int i19 = f26 * (f24 | 5166);
                    iM321 = C0001.m311(C0010.decode(new byte[]{-67, -110, -70, -112, -24, -60, -20, -60}, "f5a63b7cc8fd3e", false));
                    break;
                case 54425087:
                    int i20 = f26 * (f24 ^ 689);
                    iM321 = C0003.m321(C0010.decode(new byte[]{-65, -60, -24, -97, -21, -57, -18, -111}, "de390a53a9b0023d", 4));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤ۟ۥۢ۟ۦ, reason: not valid java name and contains not printable characters */
    private static String m126() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-29, -63, -19, -111, -29, -106, -17, -61}, "8d67824a6a7803", 0.0f));
        while (true) {
            switch (iM330) {
                case 54154920:
                    int i = f26 * (f24 + 5798);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-71, -110, -29, -100, -67, -107, -29, -61}, "b784f28a6b37", 0.0f));
                    break;
                case 54181795:
                    int i2 = f26 * (f24 ^ 5265);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-19, -58, -30, -112, -18, -106, -23, -7}, "6e92562f9085e1b2"));
                    break;
                case 54208669:
                    int i3 = f26 * (f24 + 3928);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-70, -105, -70, -112, -66, -64, -18, -111}, "a3a0eb59", 0.0f));
                    break;
                case 54208707:
                    int i4 = f26 * (f24 | 4251);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-72, -62, -70, -112, -19, -60, -71, -107}, "cea36cb6c2ae", 0.0f));
                    break;
                case 54241315:
                    int i5 = f26 * (f24 ^ 1721);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-70, -98, -20, -62, -29, -61, -21, -64}, "a67f8b0e89", 5));
                    break;
                case 54243241:
                    int i6 = f26 * (f24 + 6435);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-30, -63, -23, -107, -29, -101, -20, -107}, "9b248377", 3));
                    break;
                case 54268254:
                    int i7 = f26 * (f24 ^ 6298);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-20, -57, -67, -102, -19, -2, -67, -109}, "7af86af5", true));
                    break;
                case 54270180:
                    int i8 = f26 * (f24 + 7916);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-17, -88, -30, -99, -21, -102, -29, -111}, "47980885a8", 0.0f));
                    break;
                case 54270424:
                    int i9 = f26 * (f24 | 324);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-22, -63, -24, -61, -71, -60, -72, -60}, "1a3abecfb0a270", 0.0f));
                    break;
                case 54271134:
                    int i10 = f26 * (f24 + 190);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-19, -58, -70, -58, -22, -3, -71, -101}, "6dad1bb943", true));
                    break;
                case 54273277:
                    int i11 = f26 * (f24 ^ 492);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-24, -112, -67, -5, -65, -60, -65, -90}, "31fdddd9cf1f8666", false));
                    break;
                case 54275973:
                    int i12 = f26 * (f24 + 2071);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-19, -105, -67, -104, -18, -103, -67, -97}, "64f959f9109864", 1));
                    break;
                case 54299074:
                    int i13 = f26 * (f24 + 5454);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-30, -101, -17, -107, -71, -83, -71, -109}, "9941b2b55562a7", 6));
                    break;
                case 54303875:
                    int i14 = f26 * (f24 + 105);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-71, -110, -18, -62, -19, -109, -70, -64}, "b15f64ac55d4dd20", false));
                    break;
                case 54334687:
                    int i15 = f26 * (f24 ^ 2243);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-71, -109, -70, -63, -65, -107, -24, -111}, "b0afd433e53aff"));
                    break;
                case 54336702:
                    int i16 = f26 * (f24 + 2860);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-70, -103, -24, -90, -19, -59, -30, -110}, "a8396d94", false));
                    break;
                case 54360483:
                    int i17 = f26 * (f24 + 4166);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-20, -63, -23, -107, -18, -102, -24, -105}, "7e2058337d1c", true));
                    break;
                case 54391480:
                    int i18 = f26 * (f24 | 3251);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-22, -101, -22, -110, -65, -2, -23, -111}, "1311da25", true));
                    break;
                case 54421024:
                    int i19 = f26 * (f24 | 7242);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-19, -57, -67, -85, -22, -63, -18, -64}, "6df41a5bb4", 1));
                    break;
                case 54422048:
                    int i20 = f26 * (f24 ^ 3225);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-65, -98, -24, -60, -20, -88, -23, -112}, "d63b7726f56bd01a", 0.0f));
                    break;
                case 54423909:
                    return C0009.m350(f28, 125, 761515631 ^ C0008.f75, 3);
            }
        }
    }

    /* JADX INFO: renamed from: ۤۡۤۧۡۡ, reason: not valid java name and contains not printable characters */
    private static String m127() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-22, -97, -18, -110, -70, -61, -72, -60}, "1750accb692e7d14"));
        while (true) {
            switch (iM309) {
                case 54150056:
                    int i = f26 * (f24 | 830);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-70, -108, -65, -64, -20, -63, -70, -85}, "a4df7e"));
                    break;
                case 54155944:
                    int i2 = f26 * (f24 + 2226);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-17, -108, -20, -108, -20, -111, -18, -112}, "467373580558", false));
                    break;
                case 54180778:
                    int i3 = f26 * (f24 | 942);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-30, -105, -23, -60, -70, -60, -30, -107}, "952baa", false));
                    break;
                case 54185729:
                    int i4 = f26 * (f24 ^ 4497);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-18, -106, -17, -63, -72, -61, -70, -110}, "504ccfa5c9e4", true));
                    break;
                case 54245343:
                    int i5 = f26 * (f24 + 6221);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-20, -89, -70, -108, -20, -106, -70, -100}, "78a272a97c83"));
                    break;
                case 54246219:
                    int i6 = f26 * (f24 ^ 6713);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-30, -55, -29, -59, -67, -58, -29, -100}, "9a8ffe88eb8b", true));
                    break;
                case 54247296:
                    int i7 = f26 * (f24 | 5475);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-65, -59, -70, -107, -23, -112, -67, -59}, "dfa125ff952891"));
                    break;
                case 54271236:
                    int i8 = f26 * (f24 + 5155);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-23, -4, -70, -63, -71, -60, -29, -112}, "2caabd8736d6", 0.0f));
                    break;
                case 54273215:
                    int i9 = f26 * (f24 | 2158);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-67, -110, -70, -51, -23, -63, -29, -60}, "f5ae2c8a61c0b2", 4));
                    break;
                case 54301895:
                    int i10 = f26 * (f24 ^ 4998);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-29, -101, -71, -110, -17, -62, -65, -55}, "88b04ada7743b7", true));
                    break;
                case 54303841:
                    int i11 = f26 * (f24 + 3356);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-67, -97, -18, -98, -66, -58, -23, -110}, "f858ea2458ed2da8", 0.0f));
                    break;
                case 54360670:
                    int i12 = f26 * (f24 + 1824);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-66, -98, -22, -97, -17, -63, -24, -57}, "e6184c3bdee5dd"));
                    break;
                case 54365285:
                    int i13 = f26 * (f24 ^ 1394);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-70, -64, -71, -100, -18, -105, -70, -111}, "abb451a1", 0.0f));
                    break;
                case 54393250:
                    int i14 = f26 * (f24 | 278);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-17, -97, -71, -63, -66, -3, -22, -106}, "49bfeb151f", 4));
                    break;
                case 54394366:
                    int i15 = f26 * (f24 ^ 493);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-72, -108, -70, -61, -70, -108, -72, -107}, "c3afa6"));
                    break;
                case 54396065:
                    return C0009.m350(f28, 67, 904898236 ^ C0000.f59, 3);
                case 54396132:
                    int i16 = f26 * (f24 + 324);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-72, -109, -67, -60, -71, -89, -72, -101}, "c3feb8", 4));
                    break;
                case 54420096:
                    int i17 = f26 * (f24 ^ 5529);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-72, -64, -29, -106, -24, -106, -30, -103}, "cd8337982b"));
                    break;
                case 54421148:
                    int i18 = f26 * (f24 | 5662);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-20, -100, -24, -107, -66, -62, -72, -97}, "7836ebc7a77c41"));
                    break;
                case 54424962:
                    int i19 = f26 * (f24 | 4709);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-71, -107, -20, -101, -21, -107, -22, -62}, "b273051be4"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۤۦۥۡۢ, reason: not valid java name and contains not printable characters */
    private static String m128() {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-30, -7, -20, -111, -29, -110, -22, -85}, "9f7084143cba", false));
        while (true) {
            switch (iM311) {
                case 54151195:
                    int i = f26 * (f24 ^ 6083);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-19, -112, -66, -106, -18, -63, -21, -61}, "65e65a0a"));
                    break;
                case 54152187:
                    int i2 = f26 * (f24 ^ 1815);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-66, -63, -22, -63, -22, -98, -29, -112}, "eb1d1687ca7a"));
                    break;
                case 54157708:
                    int i3 = f26 * (f24 | 7288);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-21, -107, -29, -4, -70, -107, -72, -111}, "038ca4c9be17", 0.0f));
                    break;
                case 54180059:
                    return C0009.m350(f28, 116, 1839516530 ^ C0001.f61, 3);
                case 54186542:
                    int i4 = f26 * (f24 | 6104);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-29, -106, -65, -64, -65, -98, -71, -108}, "81ded6b115a130"));
                    break;
                case 54238466:
                    int i5 = f26 * (f24 ^ 4663);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-21, -112, -23, -97, -17, -87, -18, -64}, "0028465f5db10615", true));
                    break;
                case 54245343:
                    int i6 = f26 * (f24 + 7140);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-17, -4, -72, -99, -23, -2, -71, -107}, "4cc52ab7b551", 3));
                    break;
                case 54271351:
                    int i7 = f26 * (f24 | 6813);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-23, -62, -19, -61, -21, -62, -71, -58}, "2b6c0ebd9d84"));
                    break;
                case 54271356:
                    int i8 = f26 * (f24 | 7806);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-72, -2, -70, -58, -20, -111, -19, -83}, "caad76626ad7", true));
                    break;
                case 54274273:
                    int i9 = f26 * (f24 ^ 1400);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-24, -109, -72, -81, -29, -58, -24, -108}, "31c08f", 1));
                    break;
                case 54275942:
                    int i10 = f26 * (f24 + 5198);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-70, -105, -21, -101, -18, -105, -17, -109}, "a1035446", 0.0f));
                    break;
                case 54327837:
                    int i11 = f26 * (f24 + 272);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-66, -111, -67, -106, -30, -104, -17, -109}, "e4f09947337ad622"));
                    break;
                case 54328797:
                    int i12 = f26 * (f24 ^ 6183);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-30, -51, -66, -112, -65, -62, -17, -108}, "9ee2de416f", 0));
                    break;
                case 54334596:
                    int i13 = f26 * (f24 ^ 6197);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-21, -101, -20, -60, -66, -58, -21, -89}, "087fea", true));
                    break;
                case 54357664:
                    int i14 = f26 * (f24 ^ 1101);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-23, -57, -66, -59, -18, -108, -67, -60}, "2deb54ff00391c", true));
                    break;
                case 54366372:
                    int i15 = f26 * (f24 ^ 6480);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-30, -51, -21, -60, -19, -98, -30, -61}, "9e0f69", false));
                    break;
                case 54391230:
                    int i16 = f26 * (f24 ^ 2977);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-19, -50, -20, -106, -71, -106, -67, -58}, "6f77b6faff", 4));
                    break;
                case 54393435:
                    int i17 = f26 * (f24 | 1621);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-66, -111, -71, -60, -71, -112, -19, -61}, "e9bbb06d51ac", false));
                    break;
                case 54419136:
                    int i18 = f26 * (f24 | 3976);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-24, -112, -20, -90, -17, -107, -24, -106}, "357945", 0.0f));
                    break;
                case 54420312:
                    int i19 = f26 * (f24 + 4412);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-23, -61, -23, -60, -29, -110, -19, -60}, "2a2b876dfc", 0.0f));
                    break;
                case 54420313:
                    int i20 = f26 * (f24 | 1861);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-20, -107, -72, -110, -67, -63, -65, -107}, "76c0ffd1460058", false));
                    break;
                case 54423941:
                    int i21 = f26 * (f24 | 5533);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-70, -59, -23, -110, -22, -87, -22, -61}, "ab21161b4e2d3f", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۥۢۦۨ, reason: not valid java name and contains not printable characters */
    private static String m129() {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-72, -107, -24, -59, -21, -57, -21, -106}, "c23b0d07b56b2403", 5));
        while (true) {
            switch (iM311) {
                case 54187597:
                    int i = f26 * (f24 ^ 2654);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-66, -109, -66, -111, -70, -63, -66, -107}, "e6e2af"));
                    break;
                case 54209886:
                    int i2 = f26 * (f24 + 212);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-29, -110, -67, -112, -65, -109, -72, -98}, "83f1d3c663", 0.0f));
                    break;
                case 54210600:
                    return C0009.m350(f28, 9, 2067369391 ^ C0001.f61, 3);
                case 54213482:
                    int i3 = f26 * (f24 + 5407);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-23, -61, -29, -58, -18, -101, -66, -104}, "2a8d59e9020ea89d", true));
                    break;
                case 54216419:
                    int i4 = f26 * (f24 | 2619);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-72, -102, -29, -106, -71, -58, -18, -59}, "c881bc5a414fb0fb"));
                    break;
                case 54240353:
                    int i5 = f26 * (f24 + 6500);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-19, -62, -18, -112, -67, -57, -20, -62}, "6f57fa7bbb3d"));
                    break;
                case 54241407:
                    int i6 = f26 * (f24 | 3970);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-21, -57, -72, -105, -67, -62, -21, -59}, "0bc0fb"));
                    break;
                case 54246308:
                    int i7 = f26 * (f24 | 7190);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-17, -105, -65, -102, -18, -110, -30, -108}, "40d9519486b0d8b2", 0.0f));
                    break;
                case 54275107:
                    int i8 = f26 * (f24 | 705);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-22, -100, -24, -64, -65, -60, -17, -105}, "183edd43", 0.0f));
                    break;
                case 54300026:
                    int i9 = f26 * (f24 ^ 4485);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-71, -106, -23, -97, -71, -108, -72, -3}, "b329b7cb864a49", true));
                    break;
                case 54300060:
                    int i10 = f26 * (f24 | 5634);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-66, -59, -72, -58, -72, -63, -67, -60}, "edcbcafcfff1c82c"));
                    break;
                case 54300902:
                    int i11 = f26 * (f24 + 6764);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-19, -112, -70, -51, -70, -111, -70, -106}, "60aea3a12e59"));
                    break;
                case 54303813:
                    int i12 = f26 * (f24 + 5848);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-18, -109, -67, -107, -19, -84, -17, -111}, "57f763468d43873d", 0.0f));
                    break;
                case 54305764:
                    int i13 = f26 * (f24 ^ 5580);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-70, -98, -71, -112, -72, -105, -24, -111}, "a8b4c632aba7cef4", 2));
                    break;
                case 54305917:
                    int i14 = f26 * (f24 | 5931);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-24, -108, -66, -97, -23, -107, -19, -61}, "30e8246a228e04ef"));
                    break;
                case 54331898:
                    int i15 = f26 * (f24 | 6401);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-23, -109, -70, -103, -65, -102, -30, -109}, "22a9d294f6", 4));
                    break;
                case 54334653:
                    int i16 = f26 * (f24 + 1178);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-19, -111, -67, -104, -71, -64, -70, -61}, "65f9bcaa91", 4));
                    break;
                case 54335529:
                    int i17 = f26 * (f24 | 7672);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-29, -101, -72, -110, -72, -62, -23, -111}, "83c1cb22185fec", 0.0f));
                    break;
                case 54362464:
                    int i18 = f26 * (f24 + 6387);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-71, -110, -18, -64, -65, -62, -29, -112}, "b45fdb811ea6", true));
                    break;
                case 54364353:
                    int i19 = f26 * (f24 + 1247);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-66, -112, -66, -57, -20, -100, -66, -105}, "e3ea78", 0));
                    break;
                case 54391353:
                    int i20 = f26 * (f24 ^ 64);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-21, -57, -21, -112, -71, -6, -70, -59}, "0e01bead6e", 4));
                    break;
                case 54395198:
                    int i21 = f26 * (f24 + 1773);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-18, -109, -21, -57, -22, -107, -18, -88}, "570f17", false));
                    break;
                case 54421054:
                    int i22 = f26 * (f24 | 7084);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-30, -103, -21, -111, -67, -101, -71, -86}, "9806f9b5a13f", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۥۥۡ, reason: not valid java name and contains not printable characters */
    public static void m130(Object obj, Object obj2) {
        int iM337 = C0007.m337(C0010.decode(new byte[]{-70, -60, -71, -57, -71, -3, -66, -89}, "afbebbe88931dc"));
        while (true) {
            switch (iM337) {
                case 54182878:
                    int i = f26 * (f24 + 5787);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-17, -107, -65, -99, -23, -64, -17, -108}, "45d52f"));
                    break;
                case 54186537:
                    int i2 = f26 * (f24 ^ 3522);
                    iM337 = C0009.m349(C0010.decode(new byte[]{-30, -110, -20, -111, -29, -53, -18, -105}, "95728c559f18e8", true));
                    break;
                case 54187715:
                    int i3 = f26 * (f24 | 6696);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-70, -106, -22, -87, -72, -60, -17, -105}, "a716ca4517f61c", false));
                    break;
                case 54208827:
                    int i4 = f26 * (f24 | 5534);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-67, -106, -21, -104, -21, -106, -30, -62}, "f408029f"));
                    break;
                case 54211808:
                    int i5 = f26 * (f24 + 5901);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-24, -108, -17, -61, -19, -7, -70, -107}, "344d6fa48314a3"));
                    break;
                case 54239550:
                    int i6 = f26 * (f24 ^ 4461);
                    iM337 = C0004.m324(C0010.decode(new byte[]{-29, -64, -67, -112, -30, -106, -21, -102}, "8df39308", false));
                    break;
                case 54241312:
                    int i7 = f26 * (f24 | 7417);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-23, -63, -21, -104, -66, -87, -17, -61}, "2e09e64ea96e4269", true));
                    break;
                case 54244388:
                    int i8 = f26 * (f24 + 2943);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-65, -107, -70, -4, -30, -106, -18, -107}, "d3ac9254a2", false));
                    break;
                case 54298232:
                    int i9 = f26 * (f24 ^ 2146);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-29, -107, -23, -112, -70, -58, -23, -111}, "8023af22", 0.0f));
                    break;
                case 54299940:
                    int i10 = f26 * (f24 ^ 8075);
                    iM337 = C0008.m343(C0010.decode(new byte[]{-17, -64, -21, -58, -22, -112, -65, -109}, "4d0d16d507"));
                    break;
                case 54301118:
                    int i11 = f26 * (f24 + 3682);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-21, -63, -67, -104, -66, -58, -18, -63}, "0df0ed5d67f1", 0.0f));
                    break;
                case 54302044:
                    int i12 = f26 * (f24 ^ 2287);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-29, -100, -72, -111, -19, -81, -19, -60}, "88c4606de8", 0.0f));
                    break;
                case 54303778:
                    int i13 = f26 * (f24 + 6304);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-22, -111, -72, -82, -23, -60, -65, -58}, "15c12bdeca89f200", 0.0f));
                    break;
                case 54304742:
                    int i14 = f26 * (f24 + 5179);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-19, -106, -65, -110, -72, -107, -23, -103}, "61d5c728e07be6be"));
                    break;
                case 54305956:
                    int iM211 = hYNP32vq.m211();
                    int i15 = 1616;
                    while (true) {
                        i15 ^= 1633;
                        switch (i15) {
                            case 14:
                                break;
                            case 49:
                                if (iM211 >= 0) {
                                    i15 = 1709;
                                }
                                break;
                            case 204:
                                f((AssetManager) obj, (String) obj2);
                                return;
                            case 239:
                                int i16 = 1740;
                                while (true) {
                                    i16 ^= 1757;
                                    switch (i16) {
                                        case 17:
                                            i16 = 1771;
                                            break;
                                        case 54:
                                            return;
                                    }
                                }
                                break;
                            default:
                                continue;
                        }
                        i15 = 1678;
                    }
                    break;
                case 54331681:
                    int i17 = f26 * (f24 + 8162);
                    iM337 = C0000.m309(C0010.decode(new byte[]{-65, -58, -71, -58, -67, -111, -65, -62}, "ddbcf4", 6));
                    break;
                case 54336550:
                    int i18 = f26 * (f24 ^ 2452);
                    iM337 = C0001.m311(C0010.decode(new byte[]{-20, -60, -20, -61, -72, -54, -72, -62}, "7e7acbcefd"));
                    break;
                case 54357750:
                    int i19 = f26 * (f24 ^ 4925);
                    iM337 = C0007.m337(C0010.decode(new byte[]{-23, -53, -17, -100, -23, -64, -23, -58}, "2c482c", 7));
                    break;
                case 54391510:
                    int i20 = f26 * (f24 ^ 549);
                    iM337 = C0006.m336(C0010.decode(new byte[]{-65, -101, -67, -112, -17, -3, -30, -105}, "d3f74b95c7", false));
                    break;
                case 54395167:
                    int i21 = f26 * (f24 ^ 7869);
                    iM337 = C0005.m330(C0010.decode(new byte[]{-30, -108, -72, -106, -24, -98, -65, -51}, "90c139de4accd2e2", 0.0f));
                    break;
                case 54422110:
                    int i22 = f26 * (f24 | 6035);
                    iM337 = C0002.m316(C0010.decode(new byte[]{-24, -58, -17, -64, -66, -5, -70, -109}, "3b4feda066f9"));
                    break;
                case 54424866:
                    int i23 = f26 * (f24 | 6244);
                    iM337 = C0003.m321(C0010.decode(new byte[]{-29, -105, -29, -102, -71, -100, -30, -62}, "8789b99b", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۥۧۥ, reason: not valid java name and contains not printable characters */
    private static String m131() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-18, -4, -21, -82, -23, -100, -19, -111}, "5c012863", 5));
        while (true) {
            switch (iM330) {
                case 54149214:
                    int i = f26 * (f24 | 3532);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-20, -112, -30, -59, -72, -112, -19, -110}, "789dc46326cf07", 0.0f));
                    break;
                case 54152070:
                    int i2 = f26 * (f24 | 7080);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-29, -63, -18, -99, -71, -61, -70, -59}, "8a55beaa", true));
                    break;
                case 54180803:
                    int i3 = f26 * (f24 ^ 6018);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-19, -103, -29, -111, -72, -106, -17, -81}, "6984c540757f8bb8", true));
                    break;
                case 54182762:
                    int i4 = f26 * (f24 + 3094);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-71, -63, -29, -105, -17, -64, -29, -109}, "bb804d83"));
                    break;
                case 54183939:
                    int i5 = f26 * (f24 ^ 7504);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-72, -62, -67, -102, -29, -112, -17, -111}, "cbf9814932719c"));
                    break;
                case 54184737:
                    return C0009.m350(f28, 113, 180090428 ^ C0002.f63, 3);
                case 54187718:
                    int i6 = f26 * (f24 ^ 773);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-66, -63, -17, -61, -23, -58, -19, -109}, "ec4f2e645d6548"));
                    break;
                case 54209816:
                    int i7 = f26 * (f24 + 3362);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-66, -103, -22, -90, -71, -63, -70, -108}, "e119bca28d9a", 2));
                    break;
                case 54213479:
                    int i8 = f26 * (f24 ^ 3330);
                    iM330 = C0002.m316(C0010.decode(new byte[]{-66, -105, -21, -111, -30, -61, -21, -108}, "e4069b01eb", 0));
                    break;
                case 54238561:
                    int i9 = f26 * (f24 ^ 8104);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-72, -106, -23, -60, -70, -105, -65, -101}, "c62ea7d93c106c", 7));
                    break;
                case 54244327:
                    int i10 = f26 * (f24 | 5170);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-30, -108, -72, -97, -20, -110, -30, -105}, "96c871971d47cfe9"));
                    break;
                case 54245256:
                    int i11 = f26 * (f24 + 4013);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-72, -59, -72, -107, -70, -61, -66, -84}, "cbc0ace346dbef3b", 2));
                    break;
                case 54246242:
                    int i12 = f26 * (f24 ^ 4935);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-23, -61, -23, -110, -24, -109, -24, -112}, "2a2431366b86", true));
                    break;
                case 54247117:
                    int i13 = f26 * (f24 | 7435);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-24, -59, -21, -59, -19, -105, -21, -106}, "3b0c670349ac", true));
                    break;
                case 54275976:
                    int i14 = f26 * (f24 ^ 5747);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-24, -105, -67, -59, -70, -60, -30, -112}, "31fbaa93ea26", false));
                    break;
                case 54276064:
                    int i15 = f26 * (f24 + 3042);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-21, -106, -22, -57, -29, -109, -72, -60}, "031e81cca11b56"));
                    break;
                case 54330786:
                    int i16 = f26 * (f24 | 2954);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-66, -110, -70, -104, -17, -112, -30, -106}, "e0a0409133e32ea8", false));
                    break;
                case 54365471:
                    int i17 = f26 * (f24 ^ 6688);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-70, -110, -18, -2, -70, -101, -70, -105}, "a05aa8", true));
                    break;
                case 54393181:
                    int i18 = f26 * (f24 + 8046);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-72, -109, -70, -108, -21, -106, -65, -4}, "c4a101dc80b2f906", false));
                    break;
                case 54393398:
                    int i19 = f26 * (f24 ^ 6894);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-18, -108, -21, -59, -67, -98, -18, -86}, "550ef8", false));
                    break;
                case 54394148:
                    int i20 = f26 * (f24 + 5841);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-29, -85, -24, -111, -67, -110, -23, -57}, "8433f12a", false));
                    break;
                case 54417275:
                    int i21 = f26 * (f24 | 2564);
                    iM330 = C0005.m330(C0010.decode(new byte[]{-18, -104, -72, -99, -24, -59, -18, -99}, "59c93e", 0.0f));
                    break;
                case 54419254:
                    int i22 = f26 * (f24 | 2212);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-66, -112, -29, -57, -65, -55, -70, -58}, "e08cdaaa1dbbf4", 5));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۨۡ۠, reason: not valid java name and contains not printable characters */
    private static String m132() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-30, -3, -72, -58, -20, -57, -30, -62}, "9bca7b", 6));
        while (true) {
            switch (iM324) {
                case 54156931:
                    int i = f26 * (f24 + 4041);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-66, -97, -23, -51, -65, -61, -66, -104}, "e82ede", 0.0f));
                    break;
                case 54179904:
                    int i2 = f26 * (f24 ^ 2974);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-65, -112, -72, -97, -19, -111, -65, -110}, "d3c763"));
                    break;
                case 54179968:
                    int i3 = f26 * (f24 ^ 1638);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-23, -109, -18, -62, -70, -61, -72, -99}, "245fabc9cf9f", 5));
                    break;
                case 54180900:
                    int i4 = f26 * (f24 | 6815);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-65, -108, -19, -64, -65, -5, -18, -103}, "d26ddd516bea", true));
                    break;
                case 54187658:
                    int i5 = f26 * (f24 + 7424);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-72, -111, -71, -58, -20, -112, -19, -60}, "c1bf726f7a8045a8", 2));
                    break;
                case 54209849:
                    int i6 = f26 * (f24 ^ 4153);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-72, -64, -29, -64, -70, -6, -18, -89}, "cd8cae5878", 0.0f));
                    break;
                case 54240483:
                    int i7 = f26 * (f24 ^ 4054);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-23, -97, -20, -57, -67, -112, -20, -108}, "287cf37274", false));
                    break;
                case 54244321:
                    int i8 = f26 * (f24 | 1364);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-20, -112, -21, -105, -29, -109, -70, -90}, "720087a9", 0.0f));
                    break;
                case 54246272:
                    int i9 = f26 * (f24 ^ 5826);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-29, -58, -24, -104, -19, -105, -29, -64}, "8f3063", 1));
                    break;
                case 54276964:
                    int i10 = f26 * (f24 | 7176);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-23, -109, -21, -106, -72, -57, -72, -64}, "2701cdcb46"));
                    break;
                case 54301855:
                    int i11 = f26 * (f24 | 3933);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-22, -108, -22, -57, -72, -59, -24, -108}, "131eca3220"));
                    break;
                case 54305826:
                    int i12 = f26 * (f24 | 2733);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-71, -57, -22, -103, -66, -105, -20, -110}, "be18e4754a", 0.0f));
                    break;
                case 54306816:
                    int i13 = f26 * (f24 ^ 2648);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-23, -104, -65, -103, -67, -109, -17, -108}, "28d8f042d65a09", true));
                    break;
                case 54306850:
                    int i14 = f26 * (f24 ^ 1484);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-66, -112, -29, -51, -19, -100, -66, -108}, "e48e68", true));
                    break;
                case 54362407:
                    return C0009.m350(f28, 15, 1390556798 ^ C0001.f61, 2);
                case 54387544:
                    int i15 = f26 * (f24 + 3143);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-66, -109, -70, -61, -22, -106, -19, -110}, "e3ac12668fbca336", 0.0f));
                    break;
                case 54390429:
                    int i16 = f26 * (f24 + 6553);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-67, -111, -66, -106, -19, -88, -70, -61}, "f9e367ae2f295e"));
                    break;
                case 54392256:
                    int i17 = f26 * (f24 | 8016);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-65, -106, -67, -100, -30, -109, -70, -108}, "d2f496a71d57d3", 0));
                    break;
                case 54392320:
                    int i18 = f26 * (f24 + 7637);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-72, -110, -23, -112, -18, -112, -67, -62}, "c32057fc", 0.0f));
                    break;
                case 54396251:
                    int i19 = f26 * (f24 ^ 935);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-21, -106, -17, -112, -30, -106, -72, -60}, "044595ce1b", 3));
                    break;
                case 54422948:
                    int i20 = f26 * (f24 ^ 5192);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-67, -109, -67, -88, -70, -111, -67, -112}, "f4f7a5", 5));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۡۨۦ, reason: contains not printable characters */
    private static String m133() {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-72, -58, -21, -64, -18, -3, -65, -102}, "ce0e5bd9dce5a0", true));
        while (true) {
            switch (iM311) {
                case 54157738:
                    int i = f26 * (f24 | 2138);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-70, -105, -30, -110, -17, -103, -70, -110}, "a09249"));
                    break;
                case 54157860:
                    int i2 = f26 * (f24 ^ 2700);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-30, -109, -23, -50, -18, -52, -18, -108}, "952f5d51e826ed", true));
                    break;
                case 54181768:
                    int i3 = f26 * (f24 ^ 849);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-66, -62, -65, -109, -23, -107, -17, -102}, "eed0254845"));
                    break;
                case 54184746:
                    int i4 = f26 * (f24 ^ 4812);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-71, -64, -19, -6, -24, -106, -65, -111}, "be6e31d9aad6db"));
                    break;
                case 54210562:
                    int i5 = f26 * (f24 + 6086);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-70, -105, -19, -108, -70, -2, -22, -60}, "a663aa1b5481f8", 0.0f));
                    break;
                case 54216333:
                    int i6 = f26 * (f24 | 6910);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-23, -106, -22, -101, -70, -58, -71, -62}, "2513aeba509ccdfb", 2));
                    break;
                case 54243297:
                    int i7 = f26 * (f24 ^ 5732);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-17, -111, -67, -64, -23, -106, -21, -111}, "47ff2605"));
                    break;
                case 54243360:
                    int i8 = f26 * (f24 + 4680);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-67, -61, -71, -105, -65, -59, -23, -108}, "fab2df238b7025", true));
                    break;
                case 54244327:
                    int i9 = f26 * (f24 ^ 7162);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-20, -58, -29, -58, -71, -111, -20, -53}, "7c8cb1", 0.0f));
                    break;
                case 54273990:
                    int i10 = f26 * (f24 ^ 6559);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-19, -88, -66, -103, -24, -61, -19, -106}, "67e13c", 1));
                    break;
                case 54276997:
                    int i11 = f26 * (f24 | 4323);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-19, -104, -22, -63, -17, -51, -24, -104}, "601d4e395b", 7));
                    break;
                case 54301954:
                    int i12 = f26 * (f24 + 2936);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-20, -108, -65, -63, -22, -111, -20, -105}, "72de10"));
                    break;
                case 54304928:
                    return C0009.m350(f28, 64, 1488629063 ^ C0006.f71, 3);
                case 54328059:
                    int i13 = f26 * (f24 | 1120);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-66, -109, -66, -63, -72, -61, -66, -110}, "e7ebca", true));
                    break;
                case 54333608:
                    int i14 = f26 * (f24 + 1794);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-30, -107, -67, -108, -71, -106, -21, -103}, "95f1b5010bf72d6e", 1));
                    break;
                case 54362466:
                    int i15 = f26 * (f24 ^ 1253);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-29, -105, -30, -112, -72, -86, -29, -105}, "8691c5"));
                    break;
                case 54364356:
                    int i16 = f26 * (f24 + 5704);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-22, -82, -21, -52, -72, -107, -17, -3}, "110dc14b", 0.0f));
                    break;
                case 54366527:
                    int i17 = f26 * (f24 | 5510);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-29, -112, -65, -112, -70, -109, -19, -59}, "84d6a66f60", false));
                    break;
                case 54388379:
                    int i18 = f26 * (f24 + 748);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-21, -53, -70, -109, -72, -111, -18, -108}, "0ca1c9570b", 7));
                    break;
                case 54391262:
                    int i19 = f26 * (f24 + 3336);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-22, -107, -22, -106, -71, -105, -22, -106}, "1712b4", 1));
                    break;
                case 54420341:
                    int i20 = f26 * (f24 + 2276);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-18, -109, -66, -58, -22, -62, -18, -107}, "53ed1b", true));
                    break;
                case 54423222:
                    int i21 = f26 * (f24 | 3684);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-71, -58, -24, -110, -19, -59, -22, -110}, "bd366d1296f4a271", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۥ۠ۤۨ, reason: contains not printable characters */
    private static String m134() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-66, -105, -29, -85, -29, -108, -22, -112}, "e28485187621d283", true));
        while (true) {
            switch (iM324) {
                case 54152002:
                    return C0009.m350(f28, 35, 1131482434 ^ C0005.f69, 3);
                case 54154986:
                    int i = f26 * (f24 + 5825);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-19, -111, -23, -105, -22, -111, -70, -101}, "652410a80d", true));
                    break;
                case 54209726:
                    int i2 = f26 * (f24 | 4045);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-65, -57, -30, -97, -29, -64, -67, -112}, "da978af125ef", 0.0f));
                    break;
                case 54210598:
                    int i3 = f26 * (f24 | 4227);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-29, -99, -70, -101, -66, -111, -23, -58}, "88a8e02e"));
                    break;
                case 54211711:
                    int i4 = f26 * (f24 ^ 5461);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-22, -60, -71, -110, -29, -57, -70, -50}, "1bb58fafa2", 0.0f));
                    break;
                case 54214498:
                    int i5 = f26 * (f24 + 761);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-67, -112, -67, -2, -65, -64, -67, -106}, "f3fade", 0.0f));
                    break;
                case 54268412:
                    int i6 = f26 * (f24 | 7741);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-18, -109, -72, -109, -70, -83, -72, -106}, "50c7a2c4c44669"));
                    break;
                case 54273028:
                    int i7 = f26 * (f24 | 2432);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-66, -59, -17, -107, -17, -58, -65, -98}, "ed444fd803160b", 0));
                    break;
                case 54300004:
                    int i8 = f26 * (f24 ^ 6144);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-24, -57, -21, -100, -71, -109, -18, -58}, "3c04b75f5c94", true));
                    break;
                case 54301921:
                    int i9 = f26 * (f24 + 5770);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-72, -105, -22, -57, -24, -103, -65, -4}, "c11f31dc6c716b", 0.0f));
                    break;
                case 54303963:
                    int i10 = f26 * (f24 + 6158);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-30, -5, -19, -57, -18, -112, -70, -112}, "9d6b54a8d9", 0.0f));
                    break;
                case 54306816:
                    int i11 = f26 * (f24 | 1186);
                    iM324 = C0006.m336(C0010.decode(new byte[]{-72, -104, -67, -109, -65, -101, -23, -111}, "c9f6d921f903e74b", 0.0f));
                    break;
                case 54327873:
                    int i12 = f26 * (f24 ^ 3388);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-71, -111, -17, -111, -71, -63, -71, -58}, "b043bdbe7f", 0.0f));
                    break;
                case 54331712:
                    int i13 = f26 * (f24 + 1924);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-23, -106, -21, -110, -70, -112, -22, -57}, "2702a31e"));
                    break;
                case 54334658:
                    int i14 = f26 * (f24 ^ 2047);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-29, -105, -24, -112, -23, -60, -18, -3}, "83352a5bff4787b8", 3));
                    break;
                case 54359794:
                    int i15 = f26 * (f24 ^ 803);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-23, -3, -21, -101, -24, -105, -17, -62}, "2b09364b1d3696d4", 7));
                    break;
                case 54365352:
                    int i16 = f26 * (f24 | 1929);
                    iM324 = C0007.m337(C0010.decode(new byte[]{-67, -62, -21, -106, -17, -57, -67, -57}, "fe004bfc", 0.0f));
                    break;
                case 54366306:
                    int i17 = f26 * (f24 + 732);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-19, -64, -72, -107, -30, -107, -70, -106}, "6ec396a2", true));
                    break;
                case 54394302:
                    int i18 = f26 * (f24 ^ 3186);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-23, -111, -22, -105, -22, -63, -23, -101}, "29121a28e3"));
                    break;
                case 54422976:
                    int i19 = f26 * (f24 | 6900);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-18, -97, -70, -99, -21, -61, -30, -55}, "57a80a9a4f2ad23e"));
                    break;
                case 54423043:
                    int i20 = f26 * (f24 | 3236);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-29, -112, -22, -112, -18, -112, -18, -101}, "84115153835f1389", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۦۡۦۢۦ, reason: contains not printable characters */
    private static String m135() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-20, -110, -22, -89, -70, -108, -24, -99}, "7318a135"));
        while (true) {
            switch (iM316) {
                case 54153930:
                    int i = f26 * (f24 + 6915);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-22, -97, -71, -109, -19, -63, -22, -106}, "18b36e14f7e7d9c0"));
                    break;
                case 54154022:
                    int i2 = f26 * (f24 + 4207);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-29, -105, -66, -58, -30, -61, -24, -60}, "87ec9a3dcd", 0.0f));
                    break;
                case 54181956:
                    int i3 = f26 * (f24 ^ 4169);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-71, -59, -19, -112, -17, -60, -71, -61}, "ba674b", 0.0f));
                    break;
                case 54184707:
                    int i4 = f26 * (f24 + 824);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-20, -107, -18, -57, -71, -61, -70, -105}, "705cbda2", true));
                    break;
                case 54208833:
                    int i5 = f26 * (f24 + 1577);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-65, -63, -70, -107, -67, -104, -72, -101}, "dca4f0c3aba413f6", 3));
                    break;
                case 54238555:
                    int i6 = f26 * (f24 ^ 3048);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-23, -108, -21, -57, -65, -63, -17, -90}, "200ada4993", 1));
                    break;
                case 54240639:
                    int i7 = f26 * (f24 | 2648);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-72, -111, -71, -99, -70, -107, -29, -59}, "c7b5a48f32d063c0"));
                    break;
                case 54245187:
                    int i8 = f26 * (f24 + 4244);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-71, -110, -22, -97, -30, -61, -29, -61}, "b5179d8cdb14e04a", 0.0f));
                    break;
                case 54273064:
                    int i9 = f26 * (f24 | 3865);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-29, -109, -19, -97, -29, -103, -71, -89}, "816989b89bdbfb", false));
                    break;
                case 54302135:
                    int i10 = f26 * (f24 ^ 5104);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-30, -61, -66, -59, -71, -97, -70, -110}, "9fefb7a43a3d38", true));
                    break;
                case 54303784:
                    int i11 = f26 * (f24 ^ 3993);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-72, -60, -66, -81, -72, -105, -72, -59}, "cae0c2", 6));
                    break;
                case 54304769:
                    int i12 = f26 * (f24 + 3078);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-17, -58, -29, -112, -20, -110, -17, -64}, "4a8275", true));
                    break;
                case 54305919:
                    int i13 = f26 * (f24 ^ 7826);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-23, -100, -20, -101, -67, -60, -22, -105}, "2873ff10f4c9"));
                    break;
                case 54306761:
                    int i14 = f26 * (f24 + 1827);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-21, -108, -66, -63, -71, -108, -72, -111}, "07eeb4c6", false));
                    break;
                case 54327993:
                    int i15 = f26 * (f24 | 2258);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-29, -63, -21, -106, -22, -100, -23, -60}, "8e05142dd311df"));
                    break;
                case 54331841:
                    int i16 = f26 * (f24 + 7469);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-29, -105, -66, -89, -20, -102, -29, -108}, "85e879"));
                    break;
                case 54331932:
                    int i17 = f26 * (f24 ^ 1717);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-23, -86, -23, -62, -20, -106, -23, -109}, "252f77"));
                    break;
                case 54332861:
                    int i18 = f26 * (f24 ^ 2592);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-21, -100, -19, -101, -23, -57, -19, -111}, "09682b69", 0.0f));
                    break;
                case 54366308:
                    int i19 = f26 * (f24 + 3766);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-66, -98, -30, -99, -21, -105, -65, -109}, "e69800d73d58", false));
                    break;
                case 54388503:
                    int i20 = f26 * (f24 ^ 2277);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-22, -81, -17, -59, -24, -62, -23, -109}, "104a3f26817cf0", 0.0f));
                    break;
                case 54390517:
                    return C0009.m350(f28, 97, 5650723 ^ C0003.f65, 3);
                case 54396282:
                    int i21 = f26 * (f24 ^ 4245);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-67, -63, -20, -112, -71, -3, -65, -111}, "fe75bbd7"));
                    break;
                case 54423194:
                    int i22 = f26 * (f24 ^ 5423);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-71, -111, -29, -112, -17, -98, -70, -98}, "b18248a6e6b45a"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦ۟ۤ۠ۡ, reason: contains not printable characters */
    private static String m136() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-71, -106, -30, -60, -18, -108, -71, -106}, "b09b54", 0.0f));
        while (true) {
            switch (iM309) {
                case 54154055:
                    int i = f26 * (f24 ^ 3449);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-30, -64, -19, -111, -20, -103, -30, -59}, "9a6478", false));
                    break;
                case 54155015:
                    int i2 = f26 * (f24 + 3166);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-72, -63, -71, -109, -17, -112, -23, -64}, "cdb5462b43", 0));
                    break;
                case 54157864:
                    int i3 = f26 * (f24 ^ 6440);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-71, -63, -72, -104, -17, -105, -17, -107}, "bcc94643"));
                    break;
                case 54208924:
                    int i4 = f26 * (f24 + 6932);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-30, -102, -70, -112, -72, -58, -20, -105}, "92a5cc74"));
                    break;
                case 54214471:
                    int i5 = f26 * (f24 ^ 8099);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-30, -64, -66, -6, -24, -57, -71, -59}, "9bee3ebe1515ba78", 6));
                    break;
                case 54238523:
                    int i6 = f26 * (f24 + 1642);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-22, -109, -71, -98, -23, -63, -22, -105}, "15b92d", true));
                    break;
                case 54238531:
                    int i7 = f26 * (f24 ^ 934);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-66, -99, -17, -111, -29, -107, -72, -109}, "e94081c156", 6));
                    break;
                case 54240360:
                    int i8 = f26 * (f24 | 5447);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-71, -103, -18, -58, -23, -62, -29, -60}, "b15f2a8e74525d21", false));
                    break;
                case 54240420:
                    return C0009.m350(f28, 73, 649995618 ^ C0007.f73, 3);
                case 54244383:
                    int i9 = f26 * (f24 ^ 5886);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-30, -90, -19, -106, -24, -99, -29, -105}, "99623880612f", 3));
                    break;
                case 54269213:
                    int i10 = f26 * (f24 ^ 1139);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-72, -108, -20, -106, -22, -105, -72, -107}, "c17216c64b98e3", false));
                    break;
                case 54269400:
                    int i11 = f26 * (f24 | 932);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-20, -105, -23, -111, -71, -7, -20, -99}, "7520bf"));
                    break;
                case 54300091:
                    int i12 = f26 * (f24 + 3054);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-67, -6, -30, -50, -66, -62, -65, -57}, "fe9fefddce48"));
                    break;
                case 54305894:
                    int i13 = f26 * (f24 + 1463);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-66, -107, -72, -111, -66, -82, -30, -60}, "e2c6e19fd9ffe90e", 0.0f));
                    break;
                case 54332673:
                    int i14 = f26 * (f24 ^ 7046);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-24, -58, -19, -107, -70, -111, -21, -54}, "3b62a40be0b5b169", 0.0f));
                    break;
                case 54334749:
                    int i15 = f26 * (f24 | 3774);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-65, -101, -22, -4, -70, -111, -65, -111}, "d91ca3", true));
                    break;
                case 54335554:
                    int i16 = f26 * (f24 ^ 8120);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-22, -63, -20, -58, -29, -105, -18, -62}, "1b7f815cfa", 0.0f));
                    break;
                case 54364358:
                    int i17 = f26 * (f24 ^ 2668);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-21, -110, -20, -109, -20, -61, -20, -107}, "00767f7485", 0.0f));
                    break;
                case 54365470:
                    int i18 = f26 * (f24 ^ 7739);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-19, -111, -29, -111, -72, -110, -66, -108}, "6486c3e5fb44a0", 0.0f));
                    break;
                case 54395075:
                    int i19 = f26 * (f24 + 1185);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-19, -82, -71, -61, -21, -64, -23, -97}, "61bf0e29374ee0", 5));
                    break;
                case 54418262:
                    int i20 = f26 * (f24 + 173);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-72, -64, -67, -87, -70, -52, -17, -112}, "caf6ad468a"));
                    break;
                case 54423131:
                    int i21 = f26 * (f24 ^ 6554);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-70, -102, -23, -105, -21, -61, -18, -104}, "a9270c5867f311", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦ۟ۨ۟, reason: contains not printable characters */
    private static String m137() {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-20, -59, -24, -2, -21, -6, -72, -100}, "7b3a0ec947b164a7", 0.0f));
        while (true) {
            switch (iM311) {
                case 54154018:
                    int i = f26 * (f24 + 6820);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-72, -112, -19, -111, -66, -82, -72, -108}, "c463e1"));
                    break;
                case 54184834:
                    int i2 = f26 * (f24 + 618);
                    iM311 = C0007.m337(C0010.decode(new byte[]{-71, -107, -20, -103, -67, -112, -72, -112}, "b679f0c25c", false));
                    break;
                case 54185609:
                    return C0009.m350(f28, 103, 1458428669 ^ C0000.f59, 3);
                case 54212612:
                    int i3 = f26 * (f24 + 1444);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-66, -108, -23, -82, -19, -4, -66, -106}, "e2216ce33713", 3));
                    break;
                case 54216607:
                    int i4 = f26 * (f24 ^ 6934);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-19, -108, -67, -50, -67, -109, -22, -61}, "63fff31d59505d6c", false));
                    break;
                case 54242371:
                    int i5 = f26 * (f24 ^ 111);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-23, -104, -71, -64, -18, -57, -18, -107}, "29bc5d50ef5a", false));
                    break;
                case 54242556:
                    int i6 = f26 * (f24 + 1024);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-24, -107, -20, -109, -29, -52, -66, -103}, "31748de1189b", 0));
                    break;
                case 54246179:
                    int i7 = f26 * (f24 + 4172);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-71, -103, -71, -108, -19, -111, -72, -57}, "b8b369cf34a3", 0.0f));
                    break;
                case 54269215:
                    int i8 = f26 * (f24 | 2439);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-30, -107, -24, -101, -24, -98, -21, -103}, "90393808cd68"));
                    break;
                case 54270267:
                    int i9 = f26 * (f24 ^ 7711);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-23, -111, -30, -111, -72, -103, -20, -106}, "2197c9758a23"));
                    break;
                case 54273278:
                    int i10 = f26 * (f24 | 4504);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-17, -99, -17, -97, -21, -60, -17, -97}, "48480f"));
                    break;
                case 54300895:
                    int i11 = f26 * (f24 ^ 2309);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-72, -105, -18, -108, -70, -50, -72, -106}, "c557af", 2));
                    break;
                case 54301982:
                    int i12 = f26 * (f24 | 7005);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-20, -57, -66, -112, -65, -112, -20, -63}, "7ee3d2", 0.0f));
                    break;
                case 54303005:
                    int i13 = f26 * (f24 ^ 7129);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-23, -112, -71, -58, -18, -108, -23, -106}, "24be57", false));
                    break;
                case 54305987:
                    int i14 = f26 * (f24 | 6361);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-21, -112, -24, -110, -17, -60, -71, -102}, "04364ab86004286e", 2));
                    break;
                case 54330904:
                    int i15 = f26 * (f24 | 4250);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-29, -108, -20, -59, -72, -60, -71, -63}, "877accbe411a8f", 3));
                    break;
                case 54335591:
                    int i16 = f26 * (f24 + 4664);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-17, -58, -21, -104, -23, -59, -17, -59}, "4e092f", 7));
                    break;
                case 54357599:
                    int i17 = f26 * (f24 | 4399);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-23, -63, -70, -57, -67, -106, -30, -111}, "2aabf092d1", 0.0f));
                    break;
                case 54362593:
                    int i18 = f26 * (f24 + 5751);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-29, -6, -29, -111, -30, -111, -29, -60}, "8e8595"));
                    break;
                case 54387390:
                    int i19 = f26 * (f24 ^ 4669);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-66, -107, -20, -106, -18, -104, -66, -88}, "e77159", false));
                    break;
                case 54396072:
                    int i20 = f26 * (f24 + 1360);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-21, -60, -18, -57, -72, -100, -23, -97}, "0b5cc927"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۥۨۡ۟ۤ, reason: contains not printable characters */
    private static String m138() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-20, -109, -18, -111, -19, -63, -19, -103}, "77506e6810ef"));
        while (true) {
            switch (iM336) {
                case 54156993:
                    int i = f26 * (f24 + 5859);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-19, -103, -67, -62, -19, -60, -19, -103}, "61fe6b68f3c156", 3));
                    break;
                case 54179135:
                    return C0009.m350(f28, 17, 446874713 ^ C0003.f65, 3);
                case 54187775:
                    int i2 = f26 * (f24 + 7681);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-18, -103, -29, -63, -19, -61, -18, -104}, "588a6d"));
                    break;
                case 54208771:
                    int i3 = f26 * (f24 ^ 7973);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-66, -58, -21, -55, -71, -58, -19, -58}, "ee0abc6a", 3));
                    break;
                case 54209848:
                    int i4 = f26 * (f24 ^ 7977);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-29, -112, -67, -106, -18, -62, -65, -109}, "84f65ad729b0b42a", 0.0f));
                    break;
                case 54211680:
                    int i5 = f26 * (f24 + 5210);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-24, -111, -17, -100, -18, -112, -67, -90}, "374957f9ece9", 0.0f));
                    break;
                case 54214591:
                    int i6 = f26 * (f24 | 5139);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-23, -104, -19, -101, -72, -50, -23, -89}, "2863cf", false));
                    break;
                case 54243242:
                    int i7 = f26 * (f24 ^ 3701);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-23, -59, -30, -101, -67, -63, -22, -101}, "2a93fd18", 0.0f));
                    break;
                case 54275230:
                    int i8 = f26 * (f24 + 42);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-66, -112, -20, -3, -19, -55, -23, -97}, "e07b6a27", 0.0f));
                    break;
                case 54277063:
                    int i9 = f26 * (f24 + 3539);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-30, -112, -30, -58, -29, -112, -18, -58}, "949a875e78", 0.0f));
                    break;
                case 54299101:
                    int i10 = f26 * (f24 | 7290);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-66, -110, -67, -102, -20, -58, -71, -110}, "e3f87bb16c", 0));
                    break;
                case 54300090:
                    int i11 = f26 * (f24 | 3979);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-30, -110, -70, -101, -71, -105, -21, -62}, "97a8b40f8de40f86", 0.0f));
                    break;
                case 54303908:
                    int i12 = f26 * (f24 | 1752);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-21, -89, -66, -98, -65, -58, -22, -110}, "08e9da12cef84ed5"));
                    break;
                case 54305951:
                    int i13 = f26 * (f24 ^ 1871);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-20, -61, -65, -103, -23, -106, -29, -59}, "7dd9258a921c4cb9", 0.0f));
                    break;
                case 54306850:
                    int i14 = f26 * (f24 | 7595);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-70, -112, -65, -98, -24, -107, -20, -102}, "a5d63778"));
                    break;
                case 54331775:
                    int i15 = f26 * (f24 ^ 2584);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-17, -103, -19, -6, -66, -107, -17, -98}, "486ee6462498", 1));
                    break;
                case 54336547:
                    int i16 = f26 * (f24 ^ 7681);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-70, -107, -66, -61, -30, -106, -65, -103}, "a4ef93d92d"));
                    break;
                case 54363607:
                    int i17 = f26 * (f24 ^ 8151);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-23, -102, -67, -107, -67, -97, -19, -106}, "22f4f7625ee40e", 0));
                    break;
                case 54388474:
                    int i18 = f26 * (f24 + 4334);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-22, -64, -71, -110, -24, -111, -66, -98}, "1db732e8bda616e2", 1));
                    break;
                case 54390398:
                    int i19 = f26 * (f24 ^ 4111);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-21, -110, -19, -107, -66, -97, -21, -110}, "0163e7"));
                    break;
                case 54418419:
                    int i20 = f26 * (f24 ^ 7005);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-22, -58, -23, -58, -67, -83, -67, -60}, "1d2bf2fce7"));
                    break;
                case 54419381:
                    int i21 = f26 * (f24 ^ 7726);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-67, -58, -19, -102, -20, -63, -67, -57}, "fa687b", 0));
                    break;
                case 54425082:
                    int i22 = f26 * (f24 + 3697);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-20, -101, -24, -103, -67, -100, -22, -109}, "7339f410"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۧۡ۟, reason: contains not printable characters */
    private static String m139() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-18, -105, -19, -107, -66, -57, -24, -62}, "5463ea3d", false));
        while (true) {
            switch (iM316) {
                case 54178918:
                    int i = f26 * (f24 ^ 95);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-19, -107, -67, -63, -17, -109, -67, -112}, "67fc43f6c925", 0));
                    break;
                case 54180988:
                    int i2 = f26 * (f24 | 405);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-21, -60, -23, -112, -20, -108, -71, -99}, "0d2377b58a3602c9"));
                    break;
                case 54182824:
                    int i3 = f26 * (f24 + 5936);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-29, -53, -71, -107, -22, -108, -21, -62}, "8cb7160e", 3));
                    break;
                case 54184775:
                    int i4 = f26 * (f24 | 1621);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-71, -105, -67, -58, -30, -59, -20, -82}, "b2fa9b712c267993", false));
                    break;
                case 54210654:
                    int i5 = f26 * (f24 | 4213);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-65, -108, -71, -87, -66, -108, -66, -55}, "d4b6e5ea", false));
                    break;
                case 54214535:
                    int i6 = f26 * (f24 | 3588);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-71, -106, -70, -107, -19, -62, -23, -105}, "b2a26b27cf"));
                    break;
                case 54217574:
                    int i7 = f26 * (f24 + 3707);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-29, -112, -23, -104, -65, -3, -29, -112}, "8229db", 0.0f));
                    break;
                case 54240354:
                    int i8 = f26 * (f24 ^ 6231);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-72, -105, -70, -106, -70, -112, -24, -106}, "c0a3a23215", false));
                    break;
                case 54241350:
                    int i9 = f26 * (f24 ^ 2806);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-22, -106, -70, -104, -72, -51, -72, -62}, "17a0cecef5"));
                    break;
                case 54275171:
                    int i10 = f26 * (f24 | 2510);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-30, -100, -22, -111, -23, -64, -18, -110}, "99102a5021"));
                    break;
                case 54277061:
                    int i11 = f26 * (f24 ^ 2800);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-22, -105, -24, -64, -71, -63, -30, -60}, "163ebb9b", 0.0f));
                    break;
                case 54301979:
                    int i12 = f26 * (f24 | 6841);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-72, -105, -72, -105, -72, -62, -71, -103}, "c7c6cdb8472b45", 6));
                    break;
                case 54303997:
                    return C0009.m350(f28, 134, 975884089 ^ C0000.f59, 3);
                case 54304960:
                    int i13 = f26 * (f24 ^ 6546);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-30, -103, -19, -108, -67, -2, -30, -108}, "9163fa"));
                    break;
                case 54305731:
                    int i14 = f26 * (f24 + 4980);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-22, -64, -71, -111, -66, -109, -22, -51}, "1eb6e4", 2));
                    break;
                case 54329789:
                    int i15 = f26 * (f24 | 310);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-22, -59, -30, -97, -29, -58, -30, -64}, "1f978c9e82", 4));
                    break;
                case 54335738:
                    int i16 = f26 * (f24 + 2172);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-20, -111, -19, -105, -24, -105, -20, -112}, "706635", false));
                    break;
                case 54335747:
                    int i17 = f26 * (f24 | 4075);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-23, -111, -67, -61, -65, -63, -24, -57}, "21ffde3af64d1b", true));
                    break;
                case 54393248:
                    int i18 = f26 * (f24 + 7559);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-17, -105, -19, -60, -72, -110, -20, -109}, "436bc4771104cc", 0.0f));
                    break;
                case 54394143:
                    int i19 = f26 * (f24 + 5767);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-71, -100, -71, -57, -18, -110, -29, -111}, "b8bb5483", 1));
                    break;
                case 54420159:
                    int i20 = f26 * (f24 | 1855);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-70, -98, -30, -64, -66, -103, -71, -106}, "a99fe9b638"));
                    break;
                case 54424869:
                    int i21 = f26 * (f24 ^ 3648);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-67, -100, -70, -105, -24, -105, -23, -88}, "f8a4342724e8", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۨۡۧۢۤ, reason: contains not printable characters */
    private static String m140() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-21, -98, -24, -59, -24, -106, -22, -63}, "063b331a2f", true));
        while (true) {
            switch (iM336) {
                case 54150235:
                    int i = f26 * (f24 | 2027);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-30, -111, -22, -105, -30, -58, -66, -87}, "99169fe6c1"));
                    break;
                case 54151106:
                    int i2 = f26 * (f24 | 6451);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-20, -111, -72, -57, -17, -89, -29, -90}, "71cd4889092b", 0.0f));
                    break;
                case 54151939:
                    int i3 = f26 * (f24 + 6197);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-21, -98, -72, -58, -30, -60, -20, -64}, "09ca9b7e896b2b29", 0.0f));
                    break;
                case 54182691:
                    int i4 = f26 * (f24 | 6638);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-22, -63, -23, -112, -20, -97, -71, -87}, "1d2179b6f0a6d8", true));
                    break;
                case 54183872:
                    int i5 = f26 * (f24 ^ 3733);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-29, -54, -29, -111, -19, -85, -30, -64}, "8b85649eb60ddf"));
                    break;
                case 54210848:
                    int i6 = f26 * (f24 + 5420);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-70, -99, -70, -58, -23, -105, -19, -50}, "a8ad226f20"));
                    break;
                case 54211776:
                    int i7 = f26 * (f24 | 4787);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-29, -7, -22, -109, -65, -81, -17, -6}, "8f11d04e364ba08b"));
                    break;
                case 54215556:
                    int i8 = f26 * (f24 + 623);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-70, -57, -72, -104, -30, -98, -22, -97}, "afc996175f", 0.0f));
                    break;
                case 54243270:
                    int i9 = f26 * (f24 | 6649);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-22, -59, -67, -64, -18, -63, -19, -111}, "1dfb5f67a2a88e", 0.0f));
                    break;
                case 54304990:
                    int i10 = f26 * (f24 + 1542);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-71, -86, -24, -64, -18, -110, -66, -105}, "b53a51e4", true));
                    break;
                case 54306691:
                    int i11 = f26 * (f24 ^ 4135);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-23, -111, -20, -59, -21, -110, -71, -57}, "237a02bc", 1));
                    break;
                case 54329941:
                    int i12 = f26 * (f24 | 2200);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-65, -106, -22, -109, -23, -110, -17, -110}, "d1152443eb0896", 0.0f));
                    break;
                case 54330880:
                    int i13 = f26 * (f24 | 5775);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-29, -50, -30, -111, -21, -57, -72, -5}, "8f990fcd6d7a9d", 1));
                    break;
                case 54362399:
                    int i14 = f26 * (f24 ^ 6849);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-18, -107, -65, -58, -18, -110, -70, -104}, "52dc53a82d9612"));
                    break;
                case 54393213:
                    int i15 = f26 * (f24 + 5504);
                    iM336 = C0007.m337(C0010.decode(new byte[]{-71, -62, -21, -108, -17, -106, -66, -64}, "bb0040eb9184706e", true));
                    break;
                case 54394330:
                    int i16 = f26 * (f24 | 6788);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-17, -57, -30, -105, -21, -105, -17, -62}, "4f9102"));
                    break;
                case 54395295:
                    int i17 = f26 * (f24 | 1861);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-71, -106, -23, -109, -22, -60, -23, -63}, "b2251c2bd47c"));
                    break;
                case 54419128:
                    int i18 = f26 * (f24 + 2339);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-66, -63, -30, -104, -30, -112, -23, -2}, "ee90902aad0d"));
                    break;
                case 54421986:
                    return C0009.m350(f28, 111, 1970418825 ^ C0000.f59, 2);
                case 54425050:
                    int i19 = f26 * (f24 | 3174);
                    iM336 = C0008.m343(C0010.decode(new byte[]{-70, -85, -29, -110, -17, -64, -17, -108}, "a4824f44", 0.0f));
                    break;
                case 54425886:
                    int i20 = f26 * (f24 | 6522);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-23, -61, -17, -57, -29, -87, -19, -110}, "2e4c86628c0acb"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧ۟ۥۡ, reason: not valid java name and contains not printable characters */
    public static void m141(Object obj, Object obj2) throws IllegalAccessException {
        int iM343 = C0008.m343(C0010.decode(new byte[]{-24, -60, -17, -108, -19, -4, -70, -60}, "3a416cac", true));
        while (true) {
            switch (iM343) {
                case 54153962:
                    int i = f26 * (f24 | 7787);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-21, -105, -66, -107, -66, -103, -72, -105}, "02e0e8c6ac54", 4));
                    break;
                case 54182848:
                    int i2 = f26 * (f24 | 5173);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-21, -99, -30, -105, -67, -3, -22, -99}, "0592fb18e668288c", true));
                    break;
                case 54183811:
                    int i3 = f26 * (f24 + 2464);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-66, -62, -17, -109, -72, -103, -66, -57}, "ea45c9"));
                    break;
                case 54239548:
                    int i4 = f26 * (f24 + 586);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-23, -102, -67, -88, -19, -112, -22, -110}, "22f76115d692", 5));
                    break;
                case 54268319:
                    int i5 = f26 * (f24 + 1928);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-65, -58, -65, -58, -66, -110, -71, -58}, "dadfe2bc28", 2));
                    break;
                case 54271135:
                    int i6 = f26 * (f24 ^ 5052);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-23, -63, -67, -63, -19, -62, -67, -101}, "2afe6ff8f30f", 3));
                    break;
                case 54272286:
                    int i7 = f26 * (f24 + 6680);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-17, -64, -17, -97, -29, -105, -19, -57}, "4c48846b50", 0.0f));
                    break;
                case 54274150:
                    int i8 = f26 * (f24 + 5352);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-67, -104, -72, -57, -65, -106, -67, -112}, "f8cdd2f17030c5", true));
                    break;
                case 54274985:
                    int i9 = f26 * (f24 + 6603);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-20, -102, -18, -83, -29, -60, -23, -105}, "72528c27778e"));
                    break;
                case 54276038:
                    int i10 = f26 * (f24 + 1287);
                    iM343 = C0003.m321(C0010.decode(new byte[]{-71, -112, -71, -90, -66, -101, -18, -100}, "b3b9e959", true));
                    break;
                case 54277151:
                    int i11 = f26 * (f24 | 3892);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-18, -82, -17, -108, -17, -64, -70, -110}, "51404ba53c", false));
                    break;
                case 54298205:
                    int i12 = f26 * (f24 + 3373);
                    iM343 = C0006.m336(C0010.decode(new byte[]{-19, -110, -21, -63, -18, -59, -24, -63}, "600a5a3c"));
                    break;
                case 54299103:
                    int i13 = f26 * (f24 + 4832);
                    iM343 = C0001.m311(C0010.decode(new byte[]{-20, -58, -20, -58, -21, -112, -23, -105}, "7e7d00278b7346f8", 1));
                    break;
                case 54303848:
                    int i14 = f26 * (f24 | 1605);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-67, -57, -30, -98, -17, -51, -67, -58}, "fd964e", 5));
                    break;
                case 54330905:
                    int iM42 = OUHQwdrD.m42();
                    int i15 = 1616;
                    while (true) {
                        i15 ^= 1633;
                        switch (i15) {
                            case 14:
                                break;
                            case 49:
                                if (iM42 < 0) {
                                    i15 = 1709;
                                }
                                break;
                            case 204:
                                c((ClassLoader) obj, (ClassLoader) obj2);
                                return;
                            case 239:
                                int i16 = 1740;
                                while (true) {
                                    i16 ^= 1757;
                                    switch (i16) {
                                        case 17:
                                            i16 = 1771;
                                            break;
                                        case 54:
                                            return;
                                    }
                                }
                                break;
                            default:
                                continue;
                        }
                        i15 = 1678;
                    }
                    break;
                case 54333576:
                    int i17 = f26 * (f24 ^ 7672);
                    iM343 = C0009.m349(C0010.decode(new byte[]{-65, -57, -21, -63, -24, -109, -71, -112}, "dc0a30b6af2331", 2));
                    break;
                case 54333632:
                    int i18 = f26 * (f24 | 5095);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-66, -60, -19, -105, -20, -98, -22, -108}, "ea657816c4", 7));
                    break;
                case 54388382:
                    int i19 = f26 * (f24 ^ 3435);
                    iM343 = C0002.m316(C0010.decode(new byte[]{-24, -100, -18, -4, -18, -58, -23, -98}, "385c5c295518", 4));
                    break;
                case 54417245:
                    int i20 = f26 * (f24 + 5783);
                    iM343 = C0005.m330(C0010.decode(new byte[]{-70, -100, -70, -63, -20, -111, -71, -111}, "a8ad70b9f3", 0.0f));
                    break;
                case 54417424:
                    int i21 = f26 * (f24 | 698);
                    iM343 = C0004.m324(C0010.decode(new byte[]{-21, -59, -66, -106, -71, -109, -18, -111}, "0fe3b759c5df886c", 0.0f));
                    break;
                case 54422947:
                    int i22 = f26 * (f24 ^ 1399);
                    iM343 = C0007.m337(C0010.decode(new byte[]{-18, -106, -20, -109, -20, -112, -24, -63}, "5570763e6ceb20", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧ۠ۥ۠, reason: not valid java name and contains not printable characters */
    private static String m142() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-19, -60, -70, -64, -65, -62, -29, -59}, "6bafdb8d", true));
        while (true) {
            switch (iM316) {
                case 54151943:
                    int i = f26 * (f24 | 7758);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-72, -88, -19, -101, -18, -62, -24, -108}, "c7635a35", 2));
                    break;
                case 54153118:
                    int i2 = f26 * (f24 ^ 3549);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-18, -57, -19, -99, -19, -63, -71, -59}, "5c696cbb8cf0"));
                    break;
                case 54153124:
                    int i3 = f26 * (f24 ^ 5592);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-22, -110, -22, -61, -20, -63, -18, -63}, "141a7f5d80", 0.0f));
                    break;
                case 54154978:
                    int i4 = f26 * (f24 | 3263);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-30, -52, -18, -81, -18, -58, -70, -60}, "9d505fab10", 0));
                    break;
                case 54157831:
                    int i5 = f26 * (f24 + 5158);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-30, -82, -18, -60, -29, -108, -66, -63}, "915a80ea", 3));
                    break;
                case 54179999:
                    int i6 = f26 * (f24 + 3536);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-18, -55, -20, -105, -72, -112, -67, -5}, "5a70c8fd2116d4", 1));
                    break;
                case 54181917:
                    int i7 = f26 * (f24 ^ 6691);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-70, -64, -71, -111, -30, -106, -66, -106}, "afb695e7"));
                    break;
                case 54208920:
                    int i8 = f26 * (f24 | 541);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-67, -60, -70, -64, -72, -63, -21, -101}, "fbaaca03995c", 3));
                    break;
                case 54216488:
                    int i9 = f26 * (f24 | 5335);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-23, -109, -18, -99, -66, -108, -23, -109}, "2458e1", 0.0f));
                    break;
                case 54269221:
                    return C0009.m350(f28, 88, 1568431216 ^ C0005.f69, 3);
                case 54302917:
                    int i10 = f26 * (f24 + 513);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-67, -64, -21, -62, -66, -105, -72, -59}, "fa0ee3cc8df9bcfd"));
                    break;
                case 54305856:
                    int i11 = f26 * (f24 + 3416);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-21, -111, -71, -90, -18, -102, -18, -102}, "00b95258a9", 3));
                    break;
                case 54305980:
                    int i12 = f26 * (f24 + 5656);
                    iM316 = C0002.m316(C0010.decode(new byte[]{-22, -108, -71, -105, -70, -109, -30, -112}, "14b5a6902ebd"));
                    break;
                case 54359555:
                    int i13 = f26 * (f24 + 4794);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-72, -83, -30, -101, -65, -60, -24, -110}, "c298db32", false));
                    break;
                case 54360730:
                    int i14 = f26 * (f24 | 23);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-70, -88, -71, -61, -18, -3, -70, -108}, "a7ba5b", true));
                    break;
                case 54364353:
                    int i15 = f26 * (f24 + 190);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-67, -109, -67, -109, -29, -57, -67, -106}, "f7f48c", true));
                    break;
                case 54365407:
                    int i16 = f26 * (f24 | 4420);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-29, -82, -67, -110, -21, -106, -29, -57}, "81f1008a98f54aa8", 0.0f));
                    break;
                case 54393306:
                    int i17 = f26 * (f24 + 7232);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-65, -64, -22, -112, -18, -111, -23, -103}, "dd17592890df", 0.0f));
                    break;
                case 54393344:
                    int i18 = f26 * (f24 ^ 7505);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-70, -60, -24, -59, -65, -108, -70, -64}, "ad3ed1", 0.0f));
                    break;
                case 54417213:
                    int i19 = f26 * (f24 ^ 4743);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-30, -98, -71, -62, -66, -87, -30, -102}, "96bce699", 3));
                    break;
                case 54419101:
                    int i20 = f26 * (f24 ^ 7632);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-18, -112, -67, -103, -24, -109, -72, -103}, "53f933c11a93", true));
                    break;
                case 54425142:
                    int i21 = f26 * (f24 | 4713);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-66, -107, -67, -61, -65, -106, -19, -104}, "e2ffd2688a2c7e", 7));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۡۦۧ, reason: not valid java name and contains not printable characters */
    private static String m143() {
        int iM330 = C0005.m330(C0010.decode(new byte[]{-66, -109, -72, -105, -67, -112, -18, -7}, "e4c5f15f082ba9c1"));
        while (true) {
            switch (iM330) {
                case 54149280:
                    int i = f26 * (f24 ^ 5712);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-30, -86, -22, -104, -66, -62, -29, -85}, "9510eb84", 1));
                    break;
                case 54151044:
                    int i2 = f26 * (f24 | 2790);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-22, -104, -30, -111, -29, -62, -24, -106}, "19948d34e0773507", 1));
                    break;
                case 54154983:
                    int i3 = f26 * (f24 + 7894);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-30, -58, -17, -106, -72, -60, -19, -102}, "9f42cc626303f4", false));
                    break;
                case 54157736:
                    int i4 = f26 * (f24 + 3963);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-17, -57, -71, -62, -66, -61, -17, -63}, "4cbbea"));
                    break;
                case 54183658:
                    int i5 = f26 * (f24 + 6150);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-30, -102, -67, -100, -72, -106, -71, -105}, "99f4c7b597daf0ff"));
                    break;
                case 54183714:
                    int i6 = f26 * (f24 + 5548);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-70, -111, -23, -105, -24, -107, -18, -63}, "a426355c836c", 0.0f));
                    break;
                case 54183909:
                    int i7 = f26 * (f24 | 834);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-65, -105, -70, -109, -30, -6, -65, -109}, "d2a79e", false));
                    break;
                case 54214624:
                    return C0009.m350(f28, 91, 153239615 ^ C0002.f63, 3);
                case 54216361:
                    int i8 = f26 * (f24 | 6850);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-66, -81, -70, -110, -20, -57, -70, -63}, "e0a37fab3c0c23bc"));
                    break;
                case 54240601:
                    int i9 = f26 * (f24 ^ 763);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-24, -105, -22, -63, -24, -60, -23, -63}, "301b3e2ffaa9"));
                    break;
                case 54247363:
                    int i10 = f26 * (f24 | 394);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-23, -104, -30, -106, -18, -85, -23, -99}, "289254"));
                    break;
                case 54276934:
                    int i11 = f26 * (f24 + 7995);
                    iM330 = C0008.m343(C0010.decode(new byte[]{-70, -99, -30, -103, -71, -106, -70, -107}, "a599b4", true));
                    break;
                case 54299068:
                    int i12 = f26 * (f24 + 6328);
                    iM330 = C0000.m309(C0010.decode(new byte[]{-72, -112, -67, -111, -65, -105, -70, -88}, "c0f5d6a7", 0.0f));
                    break;
                case 54305708:
                    int i13 = f26 * (f24 | 3269);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-20, -87, -20, -112, -23, -111, -20, -109}, "767525", 0));
                    break;
                case 54329758:
                    int i14 = f26 * (f24 ^ 7612);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-23, -62, -67, -62, -22, -58, -20, -109}, "2dfe1d77587868"));
                    break;
                case 54332609:
                    int i15 = f26 * (f24 | 4910);
                    iM330 = C0004.m324(C0010.decode(new byte[]{-29, -111, -23, -112, -71, -110, -18, -110}, "8424b554a6", 4));
                    break;
                case 54332862:
                    int i16 = f26 * (f24 + 6110);
                    iM330 = C0001.m311(C0010.decode(new byte[]{-20, -108, -19, -111, -24, -60, -72, -64}, "76603ccae5bd", 0.0f));
                    break;
                case 54334692:
                    int i17 = f26 * (f24 | 4130);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-66, -112, -72, -111, -71, -109, -30, -110}, "e1c6b391d5bbc3", false));
                    break;
                case 54336459:
                    int i18 = f26 * (f24 | 5917);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-21, -111, -19, -103, -70, -98, -18, -106}, "0361a6534d", 1));
                    break;
                case 54365379:
                    int i19 = f26 * (f24 + 3360);
                    iM330 = C0006.m336(C0010.decode(new byte[]{-21, -57, -22, -106, -19, -89, -21, -53}, "0c1168", true));
                    break;
                case 54390329:
                    int i20 = f26 * (f24 | 4624);
                    iM330 = C0003.m321(C0010.decode(new byte[]{-20, -84, -23, -90, -67, -61, -18, -60}, "7329fe5b7a", false));
                    break;
                case 54391298:
                    int i21 = f26 * (f24 | 3405);
                    iM330 = C0007.m337(C0010.decode(new byte[]{-67, -111, -72, -98, -70, -4, -67, -61}, "f4c6acfdd8168007", 0.0f));
                    break;
                case 54418230:
                    int i22 = f26 * (f24 + 2186);
                    iM330 = C0009.m349(C0010.decode(new byte[]{-29, -108, -70, -107, -21, -111, -24, -106}, "81a30531", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۢۡ۟ۡۨ, reason: not valid java name and contains not printable characters */
    private static String m144() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-65, -59, -19, -110, -71, -110, -67, -83}, "dc64b4f21bd4", 0.0f));
        while (true) {
            switch (iM309) {
                case 54152126:
                    int i = f26 * (f24 | 401);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-71, -2, -21, -111, -29, -109, -71, -112}, "ba0783b1aec74f", 1));
                    break;
                case 54153095:
                    int i2 = f26 * (f24 + 3530);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-71, -111, -23, -63, -65, -107, -66, -100}, "b92cd1e8efb757", 0.0f));
                    break;
                case 54153869:
                    return C0009.m350(f28, 29, 1446366536 ^ C0000.f59, 3);
                case 54155816:
                    int i3 = f26 * (f24 + 958);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-29, -110, -72, -55, -66, -57, -65, -57}, "83caedda64660d", 0.0f));
                    break;
                case 54157961:
                    int i4 = f26 * (f24 + 4790);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-20, -106, -22, -61, -72, -57, -20, -88}, "771fcd"));
                    break;
                case 54181985:
                    int i5 = f26 * (f24 + 2639);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-17, -97, -29, -64, -30, -110, -65, -107}, "488d90d3", 6));
                    break;
                case 54182017:
                    int i6 = f26 * (f24 | 4956);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-22, -111, -20, -61, -70, -59, -18, -105}, "117aab51", 0.0f));
                    break;
                case 54182878:
                    int i7 = f26 * (f24 | 6954);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-20, -6, -17, -97, -72, -60, -20, -62}, "7e47cc", 0.0f));
                    break;
                case 54214528:
                    int i8 = f26 * (f24 | 3777);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-20, -62, -19, -59, -29, -55, -24, -60}, "7c6c8a3dfd90", 1));
                    break;
                case 54215645:
                    int i9 = f26 * (f24 + 5282);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-22, -3, -67, -59, -24, -112, -70, -111}, "1bff35a98c1c0fb5", 2));
                    break;
                case 54217418:
                    int i10 = f26 * (f24 ^ 7700);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-19, -107, -19, -61, -22, -60, -18, -61}, "626e1e5d47", 5));
                    break;
                case 54239609:
                    int i11 = f26 * (f24 + 4470);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-21, -58, -17, -102, -22, -101, -71, -107}, "0f4813b28c0f9798", 4));
                    break;
                case 54246247:
                    int i12 = f26 * (f24 ^ 3887);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-66, -112, -66, -57, -17, -99, -21, -107}, "e0ed48055aa0a5"));
                    break;
                case 54332863:
                    int i13 = f26 * (f24 ^ 6585);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-24, -7, -67, -110, -65, -85, -65, -97}, "3ff6d4d88f4f57"));
                    break;
                case 54364537:
                    int i14 = f26 * (f24 | 1076);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-19, -105, -17, -60, -21, -106, -29, -111}, "654d0080c68852", 3));
                    break;
                case 54366335:
                    int i15 = f26 * (f24 ^ 6815);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-67, -107, -67, -61, -17, -101, -67, -57}, "f7fd48fb8966", true));
                    break;
                case 54392289:
                    int i16 = f26 * (f24 ^ 3570);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-65, -85, -22, -64, -30, -63, -71, -108}, "d41b9db448", 6));
                    break;
                case 54394181:
                    int i17 = f26 * (f24 | 4938);
                    iM309 = C0005.m330(C0010.decode(new byte[]{-30, -103, -66, -106, -72, -63, -30, -112}, "91e1cb", 6));
                    break;
                case 54417214:
                    int i18 = f26 * (f24 + 7079);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-65, -59, -70, -104, -22, -57, -66, -2}, "dca01eea3473e2", false));
                    break;
                case 54420218:
                    int i19 = f26 * (f24 | 5886);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-21, -112, -21, -111, -21, -59, -67, -59}, "05050bfb07d13d", 0));
                    break;
                case 54424989:
                    int i20 = f26 * (f24 + 1059);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-19, -97, -29, -81, -17, -110, -18, -109}, "6780425434"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۤۧۢ۠, reason: not valid java name and contains not printable characters */
    private static String m145() {
        int iM311 = C0001.m311(C0010.decode(new byte[]{-22, -109, -18, -111, -21, -63, -72, -101}, "12500dc3d14155fd", 0.0f));
        while (true) {
            switch (iM311) {
                case 54154051:
                    int i = f26 * (f24 ^ 2733);
                    iM311 = C0003.m321(C0010.decode(new byte[]{-22, -61, -19, -6, -71, -110, -22, -54}, "1b6eb2", 0.0f));
                    break;
                case 54157025:
                    int i2 = f26 * (f24 + 1760);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-19, -109, -67, -97, -17, -107, -65, -61}, "62f740de", 3));
                    break;
                case 54179904:
                    int i3 = f26 * (f24 + 4569);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-19, -99, -18, -109, -17, -105, -23, -111}, "6550402922", 0.0f));
                    break;
                case 54180027:
                    int i4 = f26 * (f24 + 5656);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-67, -64, -70, -109, -24, -98, -72, -108}, "fba538c29990", 0.0f));
                    break;
                case 54180866:
                    int i5 = f26 * (f24 ^ 7085);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-66, -63, -17, -59, -70, -107, -66, -64}, "ea4ea3", 0.0f));
                    break;
                case 54181922:
                    int i6 = f26 * (f24 + 446);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-30, -112, -66, -55, -18, -89, -29, -61}, "97ea588d54", 5));
                    break;
                case 54182009:
                    int i7 = f26 * (f24 + 5187);
                    iM311 = C0005.m330(C0010.decode(new byte[]{-70, -107, -67, -102, -72, -105, -21, -53}, "a6f9c60c0d0243"));
                    break;
                case 54208678:
                    int i8 = f26 * (f24 | 4960);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-24, -109, -19, -57, -24, -107, -19, -100}, "336e30698eda48", 0.0f));
                    break;
                case 54209725:
                    int i9 = f26 * (f24 ^ 6806);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-29, -106, -20, -110, -23, -110, -23, -108}, "86722026ff1b73b4", 0.0f));
                    break;
                case 54210755:
                    int i10 = f26 * (f24 + 3557);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-20, -82, -18, -111, -19, -54, -20, -60}, "71566b7eb4b1", 0));
                    break;
                case 54214653:
                    int i11 = f26 * (f24 | 3696);
                    iM311 = C0006.m336(C0010.decode(new byte[]{-71, -110, -20, -106, -18, -108, -72, -64}, "b67455ce668ce7", true));
                    break;
                case 54217418:
                    int i12 = f26 * (f24 + 1589);
                    iM311 = C0008.m343(C0010.decode(new byte[]{-21, -87, -66, -108, -72, -57, -66, -102}, "06e0cbe9e3b62a", true));
                    break;
                case 54217480:
                    int i13 = f26 * (f24 + 5874);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-66, -112, -20, -57, -71, -107, -66, -105}, "e57bb6", 3));
                    break;
                case 54245380:
                    int i14 = f26 * (f24 + 4604);
                    iM311 = C0004.m324(C0010.decode(new byte[]{-24, -105, -29, -57, -67, -60, -24, -106}, "368bfc", 5));
                    break;
                case 54272135:
                    int i15 = f26 * (f24 ^ 6803);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-21, -106, -19, -110, -21, -61, -23, -62}, "06630a2a", 5));
                    break;
                case 54273305:
                    int i16 = f26 * (f24 | 7464);
                    iM311 = C0001.m311(C0010.decode(new byte[]{-18, -103, -18, -60, -72, -97, -24, -2}, "595fc73aee075307"));
                    break;
                case 54300962:
                    int i17 = f26 * (f24 | 2782);
                    iM311 = C0009.m349(C0010.decode(new byte[]{-23, -108, -24, -111, -66, -59, -22, -60}, "2337ed1a7b"));
                    break;
                case 54333695:
                    int i18 = f26 * (f24 | 5098);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-71, -110, -17, -52, -24, -102, -18, -61}, "b34d395edd", 4));
                    break;
                case 54394179:
                    int i19 = f26 * (f24 ^ 4189);
                    iM311 = C0002.m316(C0010.decode(new byte[]{-70, -104, -30, -112, -30, -107, -71, -109}, "a99096b2379774e9"));
                    break;
                case 54396041:
                    int i20 = f26 * (f24 ^ 5775);
                    iM311 = C0000.m309(C0010.decode(new byte[]{-29, -110, -18, -110, -29, -50, -29, -111}, "81568f", 0.0f));
                    break;
                case 54421276:
                    return C0009.m350(f28, 58, 374961783 ^ C0006.f71, 3);
            }
        }
    }

    /* JADX INFO: renamed from: ۧۦ۠۠, reason: not valid java name and contains not printable characters */
    private static String m146() {
        int iM336 = C0006.m336(C0010.decode(new byte[]{-24, -107, -21, -109, -70, -109, -24, -109}, "3303a0", 5));
        while (true) {
            switch (iM336) {
                case 54151200:
                    int i = f26 * (f24 + 7723);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-21, -110, -71, -82, -22, -109, -21, -109}, "05b116", 0.0f));
                    break;
                case 54156966:
                    int i2 = f26 * (f24 + 4176);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-18, -105, -67, -52, -23, -108, -23, -106}, "55fd26255464", false));
                    break;
                case 54182784:
                    int i3 = f26 * (f24 | 1986);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-23, -110, -18, -99, -30, -55, -23, -58}, "24589a2ac94f", false));
                    break;
                case 54214501:
                    int i4 = f26 * (f24 + 1398);
                    iM336 = C0001.m311(C0010.decode(new byte[]{-66, -90, -70, -112, -19, -112, -19, -105}, "e9a166633b07", 0.0f));
                    break;
                case 54245351:
                    int i5 = f26 * (f24 + 4958);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-71, -112, -18, -106, -17, -108, -21, -110}, "b6514500e36fc7", 1));
                    break;
                case 54247175:
                    int i6 = f26 * (f24 ^ 1591);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-70, -111, -70, -105, -30, -104, -23, -62}, "a2a7992e3185"));
                    break;
                case 54269251:
                    int i7 = f26 * (f24 ^ 4815);
                    iM336 = C0006.m336(C0010.decode(new byte[]{-71, -51, -30, -109, -17, -106, -22, -58}, "be90471c"));
                    break;
                case 54276096:
                    int i8 = f26 * (f24 | 4124);
                    iM336 = C0009.m349(C0010.decode(new byte[]{-20, -97, -30, -99, -22, -107, -21, -111}, "789517053115", false));
                    break;
                case 54299035:
                    int i9 = f26 * (f24 | 4419);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-65, -51, -71, -110, -18, -110, -66, -64}, "deb252eff5b9f0", 5));
                    break;
                case 54330965:
                    int i10 = f26 * (f24 ^ 7148);
                    iM336 = C0002.m316(C0010.decode(new byte[]{-18, -112, -21, -108, -23, -101, -18, -97}, "580128"));
                    break;
                case 54335495:
                    int i11 = f26 * (f24 + 5028);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-23, -57, -23, -62, -21, -106, -20, -62}, "2a2a077d", 5));
                    break;
                case 54358679:
                    int i12 = f26 * (f24 + 8017);
                    iM336 = C0003.m321(C0010.decode(new byte[]{-20, -106, -30, -58, -20, -111, -23, -82}, "769e7321fbb67095"));
                    break;
                case 54361506:
                    int i13 = f26 * (f24 ^ 2424);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-21, -110, -24, -61, -71, -52, -29, -61}, "073abd8c92e31df9"));
                    break;
                case 54363646:
                    int i14 = f26 * (f24 + 3658);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-70, -83, -66, -111, -17, -64, -72, -110}, "a2e64fc6d099", 0.0f));
                    break;
                case 54365346:
                    int i15 = f26 * (f24 | 5712);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-17, -110, -71, -63, -29, -82, -17, -109}, "47bf81"));
                    break;
                case 54387577:
                    return C0009.m350(f28, 41, 432240747 ^ C0001.f61, 3);
                case 54396131:
                    int i16 = f26 * (f24 ^ 4747);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-24, -61, -72, -111, -67, -108, -23, -64}, "3bc4f62c"));
                    break;
                case 54418174:
                    int i17 = f26 * (f24 | 2007);
                    iM336 = C0000.m309(C0010.decode(new byte[]{-65, -58, -20, -106, -30, -112, -71, -55}, "dd7095baf6", true));
                    break;
                case 54421087:
                    int i18 = f26 * (f24 + 464);
                    iM336 = C0004.m324(C0010.decode(new byte[]{-72, -110, -22, -112, -18, -64, -24, -103}, "c6105a39c6", 0));
                    break;
                case 54423073:
                    int i19 = f26 * (f24 | 1248);
                    iM336 = C0005.m330(C0010.decode(new byte[]{-21, -111, -30, -59, -71, -109, -72, -109}, "029bb6c2", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨ۟ۥ۟ۡ, reason: not valid java name and contains not printable characters */
    private static String m147() {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-23, -61, -21, -111, -29, -60, -70, -58}, "2a038caf3929"));
        while (true) {
            switch (iM316) {
                case 54153861:
                    int i = f26 * (f24 ^ 3508);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-18, -102, -71, -109, -22, -112, -24, -58}, "58b7163d1b543a"));
                    break;
                case 54156934:
                    int i2 = f26 * (f24 | 634);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-29, -108, -22, -112, -70, -109, -24, -63}, "8414a03ba5", false));
                    break;
                case 54182822:
                    int i3 = f26 * (f24 ^ 4012);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-20, -103, -18, -100, -71, -104, -19, -112}, "7158b967bdf74611", true));
                    break;
                case 54182979:
                    int i4 = f26 * (f24 ^ 4068);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-29, -57, -24, -104, -19, -112, -67, -55}, "8a3864faeaea1f", true));
                    break;
                case 54183780:
                    int i5 = f26 * (f24 | 6279);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-67, -61, -30, -57, -23, -53, -30, -50}, "fc9d2c9f6c"));
                    break;
                case 54185824:
                    int i6 = f26 * (f24 + 5263);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-65, -54, -22, -61, -65, -103, -72, -109}, "db1ed8c15a", true));
                    break;
                case 54210782:
                    int i7 = f26 * (f24 | 1260);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-24, -63, -22, -83, -65, -108, -20, -87}, "3e12d7763a0ed3"));
                    break;
                case 54213510:
                    int i8 = f26 * (f24 + 6717);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-18, -55, -23, -58, -21, -103, -71, -4}, "5a2c08bc18759e", 0.0f));
                    break;
                case 54241561:
                    int i9 = f26 * (f24 ^ 8162);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-67, -109, -66, -57, -18, -107, -17, -111}, "f2ef5345", 0.0f));
                    break;
                case 54243454:
                    int i10 = f26 * (f24 | 6750);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-21, -84, -18, -107, -66, -99, -24, -102}, "0352e839db", 0.0f));
                    break;
                case 54298135:
                    int i11 = f26 * (f24 | 5547);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-30, -105, -65, -63, -24, -99, -71, -99}, "93da38b5", 6));
                    break;
                case 54299167:
                    int i12 = f26 * (f24 | 2947);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-30, -98, -18, -100, -29, -110, -21, -60}, "9959820b2d", 0.0f));
                    break;
                case 54299190:
                    int i13 = f26 * (f24 ^ 7430);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-21, -104, -18, -64, -70, -112, -21, -99}, "095da1", 6));
                    break;
                case 54304742:
                    int i14 = f26 * (f24 ^ 1729);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-71, -107, -71, -64, -23, -109, -71, -59}, "b3bc23ba77ef", false));
                    break;
                case 54329757:
                    int i15 = f26 * (f24 + 6353);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-22, -110, -72, -57, -72, -90, -65, -109}, "16cac9d0", true));
                    break;
                case 54358718:
                    return C0009.m350(f28, 108, 1035894580 ^ C0006.f71, 3);
                case 54361473:
                    int i16 = f26 * (f24 | 5124);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-23, -58, -67, -110, -67, -109, -20, -104}, "2ff4f479", 7));
                    break;
                case 54362401:
                    int i17 = f26 * (f24 + 6369);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-70, -88, -24, -58, -71, -2, -22, -88}, "a73bba17f3", false));
                    break;
                case 54393188:
                    int i18 = f26 * (f24 + 306);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-29, -110, -66, -105, -19, -64, -30, -61}, "82e46c9ed886bb", 1));
                    break;
                case 54422050:
                    int i19 = f26 * (f24 | 158);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-30, -101, -29, -97, -21, -64, -29, -108}, "93880f85", 0.0f));
                    break;
                case 54423003:
                    int i20 = f26 * (f24 ^ 644);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-30, -98, -21, -105, -71, -89, -30, -102}, "9803b8", 5));
                    break;
                case 54423967:
                    int i21 = f26 * (f24 | 3746);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-18, -111, -71, -111, -72, -64, -24, -111}, "55b1cf31", false));
                    break;
                case 54425082:
                    int i22 = f26 * (f24 + 4233);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-17, -111, -71, -110, -72, -111, -72, -111}, "44b3c1c0152e0972", 1));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۨۤۨ, reason: not valid java name and contains not printable characters */
    public static ClassLoader m148(Object obj, Object obj2, Object obj3) {
        int iM316 = C0002.m316(C0010.decode(new byte[]{-18, -110, -70, -107, -66, -52, -21, -57}, "54a2ed0fd461", 0.0f));
        while (true) {
            switch (iM316) {
                case 54150980:
                    int i = f26 * (f24 | 6867);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-24, -4, -21, -111, -20, -108, -24, -58}, "3c0076", 3));
                    break;
                case 54151077:
                    int i2 = f26 * (f24 ^ 1908);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-24, -60, -65, -59, -71, -108, -65, -109}, "3bddb7d3", 1));
                    break;
                case 54154887:
                    int i3 = f26 * (f24 | 7249);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-24, -109, -19, -81, -22, -63, -24, -101}, "31601c38ac45"));
                    break;
                case 54155076:
                    int i4 = f26 * (f24 | 4182);
                    iM316 = C0003.m321(C0010.decode(new byte[]{-18, -111, -67, -110, -30, -88, -24, -58}, "52f4973c295d168e", 0.0f));
                    break;
                case 54157745:
                    int i5 = f26 * (f24 ^ 6245);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-21, -108, -23, -82, -70, -110, -65, -104}, "0021a2d93e", 6));
                    break;
                case 54157926:
                    int i6 = f26 * (f24 | 1428);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-24, -112, -70, -110, -70, -63, -24, -105}, "32a5ae", 0.0f));
                    break;
                case 54213544:
                    int i7 = f26 * (f24 + 1702);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-70, -102, -66, -108, -72, -97, -70, -103}, "a9e7c7", true));
                    break;
                case 54238526:
                    int i8 = f26 * (f24 | 7753);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-70, -5, -70, -97, -30, -98, -17, -106}, "ada79845", true));
                    break;
                case 54239520:
                    int i9 = f26 * (f24 ^ 1978);
                    iM316 = C0005.m330(C0010.decode(new byte[]{-66, -111, -66, -59, -22, -85, -66, -111}, "e9ee14", 0.0f));
                    break;
                case 54246278:
                    int i10 = f26 * (f24 ^ 81);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-18, -90, -19, -103, -20, -86, -24, -61}, "5968753b49417b", 3));
                    break;
                case 54272344:
                    int i11 = f26 * (f24 | 6064);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-22, -104, -21, -61, -24, -109, -22, -105}, "100f32", false));
                    break;
                case 54274953:
                    int i12 = f26 * (f24 | 5005);
                    iM316 = C0009.m349(C0010.decode(new byte[]{-21, -51, -65, -57, -72, -107, -65, -111}, "0edbc7d7f051a361", 0.0f));
                    break;
                case 54298044:
                    int i13 = f26 * (f24 | 148);
                    iM316 = C0001.m311(C0010.decode(new byte[]{-65, -85, -66, -57, -23, -111, -21, -58}, "d4eb200d980da6f5", 2));
                    break;
                case 54301018:
                    int iM211 = hYNP32vq.m211();
                    int i14 = 1616;
                    while (true) {
                        i14 ^= 1633;
                        switch (i14) {
                            case 14:
                                break;
                            case 49:
                                if (iM211 >= 0) {
                                    i14 = 1709;
                                }
                                break;
                            case 204:
                                return b((String) obj, (String) obj2, obj3);
                            case 239:
                                int i15 = 1740;
                                while (true) {
                                    i15 ^= 1757;
                                    switch (i15) {
                                        case 17:
                                            i15 = 1771;
                                            break;
                                        case 54:
                                            return null;
                                    }
                                }
                                break;
                            default:
                                continue;
                        }
                        i14 = 1678;
                    }
                    break;
                case 54359640:
                    int i16 = f26 * (f24 | 4965);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-71, -104, -20, -61, -70, -98, -71, -61}, "b07ca8beade9", 5));
                    break;
                case 54365562:
                    int i17 = f26 * (f24 + 5969);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-66, -6, -65, -100, -70, -109, -71, -98}, "eed4a3b622738de4", 0.0f));
                    break;
                case 54396127:
                    int i18 = f26 * (f24 + 2812);
                    iM316 = C0006.m336(C0010.decode(new byte[]{-29, -58, -66, -58, -70, -59, -71, -107}, "8defafb0bc33"));
                    break;
                case 54418145:
                    int i19 = f26 * (f24 | 6675);
                    iM316 = C0004.m324(C0010.decode(new byte[]{-72, -110, -19, -100, -17, -101, -72, -98}, "c36849c9cbfa85", false));
                    break;
                case 54418360:
                    int i20 = f26 * (f24 | 3947);
                    iM316 = C0000.m309(C0010.decode(new byte[]{-19, -97, -70, -97, -23, -64, -19, -108}, "68a72b64ca9408", true));
                    break;
                case 54423011:
                    int i21 = f26 * (f24 ^ 4157);
                    iM316 = C0008.m343(C0010.decode(new byte[]{-17, -86, -70, -110, -20, -105, -17, -112}, "45a770", 0.0f));
                    break;
                case 54423041:
                    int i22 = f26 * (f24 + 2680);
                    iM316 = C0007.m337(C0010.decode(new byte[]{-70, -111, -19, -60, -65, -107, -23, -4}, "a56fd62c2cb9", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۥۢ۠, reason: not valid java name and contains not printable characters */
    private static String m149() {
        int iM309 = C0000.m309(C0010.decode(new byte[]{-22, -104, -21, -108, -72, -63, -17, -112}, "1803ca47ee5c"));
        while (true) {
            switch (iM309) {
                case 54152103:
                    int i = f26 * (f24 | 1411);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-67, -61, -66, -63, -18, -3, -22, -107}, "feec5b11bd", 4));
                    break;
                case 54156868:
                    int i2 = f26 * (f24 ^ 5053);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-23, -61, -21, -112, -71, -108, -30, -51}, "2a04b79eff0655", 0.0f));
                    break;
                case 54186574:
                    int i3 = f26 * (f24 + 7579);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-71, -60, -65, -107, -67, -105, -70, -59}, "bfd0f4ab", true));
                    break;
                case 54211710:
                    int i4 = f26 * (f24 + 3669);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-72, -105, -30, -89, -17, -58, -72, -63}, "c0984ccc37de", true));
                    break;
                case 54240420:
                    int i5 = f26 * (f24 | 1487);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-72, -62, -72, -64, -20, -106, -29, -112}, "cccb738299e58b", 5));
                    break;
                case 54243367:
                    int i6 = f26 * (f24 + 5043);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-22, -7, -71, -63, -71, -57, -67, -50}, "1fbcbcff6de28a", 0.0f));
                    break;
                case 54244327:
                    int i7 = f26 * (f24 + 5512);
                    iM309 = C0000.m309(C0010.decode(new byte[]{-17, -54, -29, -59, -30, -111, -71, -64}, "4b8d92bd151ee8"));
                    break;
                case 54246211:
                    int i8 = f26 * (f24 + 6958);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-67, -109, -30, -97, -18, -106, -66, -111}, "f19855e4"));
                    break;
                case 54246247:
                    return C0009.m350(f28, 32, 709245925 ^ C0004.f67, 3);
                case 54268315:
                    int i9 = f26 * (f24 ^ 1082);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-70, -63, -29, -105, -70, -64, -70, -62}, "ad85ae", 0.0f));
                    break;
                case 54300962:
                    int i10 = f26 * (f24 + 2819);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-30, -101, -71, -97, -23, -63, -72, -62}, "99b82ccb9c", 3));
                    break;
                case 54303777:
                    int i11 = f26 * (f24 + 7553);
                    iM309 = C0004.m324(C0010.decode(new byte[]{-65, -59, -20, -81, -18, -100, -66, -61}, "dc7058eb8781", 4));
                    break;
                case 54306820:
                    int i12 = f26 * (f24 + 1323);
                    iM309 = C0008.m343(C0010.decode(new byte[]{-67, -106, -23, -60, -23, -86, -67, -83}, "f22a25", 1));
                    break;
                case 54330878:
                    int i13 = f26 * (f24 | 4472);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-23, -112, -20, -111, -24, -57, -72, -105}, "28753ec1523e0651", 1));
                    break;
                case 54357750:
                    int i14 = f26 * (f24 + 98);
                    iM309 = C0001.m311(C0010.decode(new byte[]{-70, -58, -19, -63, -21, -6, -67, -101}, "aa6c0ef8da3ed8", 0.0f));
                    break;
                case 54360481:
                    int i15 = f26 * (f24 | 6513);
                    iM309 = C0006.m336(C0010.decode(new byte[]{-67, -112, -65, -61, -18, -103, -23, -61}, "f2db582e228239f3", 7));
                    break;
                case 54387573:
                    int i16 = f26 * (f24 | 4255);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-22, -108, -29, -57, -72, -63, -70, -102}, "138ccda817be3c", 0.0f));
                    break;
                case 54390271:
                    int i17 = f26 * (f24 ^ 7592);
                    iM309 = C0003.m321(C0010.decode(new byte[]{-29, -5, -67, -58, -19, -110, -29, -5}, "8dfa61", 0.0f));
                    break;
                case 54392378:
                    int i18 = f26 * (f24 ^ 6201);
                    iM309 = C0002.m316(C0010.decode(new byte[]{-29, -110, -66, -90, -71, -60, -18, -61}, "81e9bf5b37f125"));
                    break;
                case 54419226:
                    int i19 = f26 * (f24 | 2389);
                    iM309 = C0007.m337(C0010.decode(new byte[]{-67, -100, -72, -53, -23, -108, -67, -100}, "f8cc20", true));
                    break;
                case 54422080:
                    int i20 = f26 * (f24 ^ 7163);
                    iM309 = C0009.m349(C0010.decode(new byte[]{-19, -64, -22, -102, -22, -57, -21, -105}, "6d181f02c1e3"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۧ۟ۨۥۨ, reason: not valid java name and contains not printable characters */
    private static String m150() {
        int iM349 = C0009.m349(C0010.decode(new byte[]{-24, -5, -71, -61, -22, -105, -23, -106}, "3dbd1220b8", 3));
        while (true) {
            switch (iM349) {
                case 54149065:
                    int i = f26 * (f24 ^ 6335);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-18, -107, -24, -85, -67, -107, -71, -84}, "5734f4b33687"));
                    break;
                case 54149095:
                    int i2 = f26 * (f24 ^ 7072);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-21, -106, -30, -102, -24, -112, -21, -106}, "009931"));
                    break;
                case 54156937:
                    int i3 = f26 * (f24 ^ 436);
                    iM349 = C0003.m321(C0010.decode(new byte[]{-66, -112, -17, -4, -65, -101, -18, -109}, "e24cd354c939", true));
                    break;
                case 54209699:
                    int i4 = f26 * (f24 ^ 2473);
                    iM349 = C0005.m330(C0010.decode(new byte[]{-18, -110, -22, -111, -67, -111, -66, -58}, "5410f4eab63f8aff", true));
                    break;
                case 54214406:
                    int i5 = f26 * (f24 + 3322);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-65, -109, -72, -105, -66, -57, -19, -62}, "d1c2ee6ab941badc"));
                    break;
                case 54216420:
                    int i6 = f26 * (f24 ^ 1643);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-22, -110, -65, -105, -65, -97, -22, -111}, "16d7d91132"));
                    break;
                case 54238491:
                    int i7 = f26 * (f24 ^ 4051);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-72, -100, -21, -58, -21, -110, -18, -112}, "c90b0057e5c043"));
                    break;
                case 54238716:
                    int i8 = f26 * (f24 | 2627);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-20, -108, -22, -100, -19, -3, -20, -108}, "75196b", 0.0f));
                    break;
                case 54244292:
                    int i9 = f26 * (f24 | 5060);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-29, -2, -66, -3, -21, -60, -19, -106}, "8aeb0d61", 1));
                    break;
                case 54245404:
                    int i10 = f26 * (f24 | 4600);
                    iM349 = C0009.m349(C0010.decode(new byte[]{-30, -110, -29, -107, -21, -86, -30, -106}, "978505", true));
                    break;
                case 54247328:
                    int i11 = f26 * (f24 ^ 1097);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-19, -64, -20, -7, -67, -107, -23, -64}, "6c7ff02d4051", 1));
                    break;
                case 54268411:
                    int i12 = f26 * (f24 | 7010);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-20, -64, -17, -112, -29, -112, -70, -109}, "7a4082a5d1d1af", 1));
                    break;
                case 54273275:
                    int i13 = f26 * (f24 ^ 4680);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-21, -63, -24, -109, -21, -111, -66, -87}, "0c3506e6", 0.0f));
                    break;
                case 54299190:
                    return C0009.m350(f28, 47, 1919846712 ^ C0000.f59, 3);
                case 54302015:
                    int i14 = f26 * (f24 ^ 2699);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-30, -90, -19, -85, -17, -83, -30, -54}, "9964429b85059ff8"));
                    break;
                case 54328765:
                    int i15 = f26 * (f24 | 5842);
                    iM349 = C0008.m343(C0010.decode(new byte[]{-22, -64, -67, -107, -66, -106, -22, -58}, "1ef5e2", 0.0f));
                    break;
                case 54328922:
                    int i16 = f26 * (f24 + 3604);
                    iM349 = C0004.m324(C0010.decode(new byte[]{-17, -101, -70, -62, -22, -106, -72, -58}, "43ab16cf7acc19"));
                    break;
                case 54332708:
                    int i17 = f26 * (f24 | 250);
                    iM349 = C0007.m337(C0010.decode(new byte[]{-30, -110, -24, -59, -29, -98, -70, -61}, "913a89aba7c575d6", 0.0f));
                    break;
                case 54359709:
                    int i18 = f26 * (f24 + 5469);
                    iM349 = C0000.m309(C0010.decode(new byte[]{-17, -109, -67, -102, -22, -111, -67, -64}, "47f915fd5fcbdb", 0.0f));
                    break;
                case 54360631:
                    int i19 = f26 * (f24 + 5025);
                    iM349 = C0002.m316(C0010.decode(new byte[]{-17, -109, -30, -99, -18, -63, -71, -64}, "41955fba112bea37", false));
                    break;
                case 54361506:
                    int i20 = f26 * (f24 + 386);
                    iM349 = C0006.m336(C0010.decode(new byte[]{-30, -107, -65, -107, -71, -62, -19, -2}, "93d7bf6ab9667a", 0.0f));
                    break;
                case 54418168:
                    int i21 = f26 * (f24 | 216);
                    iM349 = C0001.m311(C0010.decode(new byte[]{-21, -64, -67, -111, -29, -108, -30, -103}, "0af68699a8", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۧۧۥۢ, reason: not valid java name and contains not printable characters */
    private static String m151() {
        int iM324 = C0004.m324(C0010.decode(new byte[]{-21, -62, -18, -107, -20, -63, -70, -105}, "0f567ca49bed46c3", false));
        while (true) {
            switch (iM324) {
                case 54152998:
                    int i = f26 * (f24 | 4986);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-23, -108, -23, -107, -21, -99, -67, -111}, "252105f7c0", false));
                    break;
                case 54157709:
                    int i2 = f26 * (f24 + 4458);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-18, -51, -20, -59, -65, -107, -18, -6}, "5e7dd6", false));
                    break;
                case 54180801:
                    int i3 = f26 * (f24 + 8088);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-22, -107, -65, -64, -23, -107, -23, -108}, "11dc2021"));
                    break;
                case 54180805:
                    int i4 = f26 * (f24 | 7128);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-67, -103, -66, -60, -23, -107, -20, -59}, "f9ee257eaef1", 0.0f));
                    break;
                case 54186823:
                    int i5 = f26 * (f24 ^ 3656);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-67, -106, -23, -102, -66, -85, -30, -5}, "f029e49d65", 1));
                    break;
                case 54211679:
                    int i6 = f26 * (f24 ^ 7883);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-71, -85, -23, -54, -17, -2, -20, -63}, "b42b4a7b16cced38", false));
                    break;
                case 54213729:
                    int i7 = f26 * (f24 | 5921);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-70, -100, -29, -112, -67, -58, -70, -110}, "a482fc", 0.0f));
                    break;
                case 54246371:
                    int i8 = f26 * (f24 | 2976);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-19, -107, -72, -112, -30, -111, -19, -106}, "64c295", true));
                    break;
                case 54270332:
                    return C0009.m350(f28, 76, 957210788 ^ C0002.f63, 3);
                case 54271387:
                    int i9 = f26 * (f24 ^ 2186);
                    iM324 = C0008.m343(C0010.decode(new byte[]{-66, -106, -66, -58, -21, -58, -70, -110}, "e2ed0aa5bc92"));
                    break;
                case 54274209:
                    int i10 = f26 * (f24 + 1040);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-67, -101, -29, -60, -66, -110, -22, -102}, "f88ee7199f"));
                    break;
                case 54274986:
                    int i11 = f26 * (f24 ^ 3894);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-70, -57, -19, -85, -23, -101, -71, -62}, "aa6423ba520832ad", 0.0f));
                    break;
                case 54301150:
                    int i12 = f26 * (f24 | 6299);
                    iM324 = C0000.m309(C0010.decode(new byte[]{-18, -62, -30, -109, -19, -64, -22, -105}, "5a966f12", 0.0f));
                    break;
                case 54301952:
                    int i13 = f26 * (f24 | 7733);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-23, -110, -70, -109, -70, -106, -23, -105}, "24a6a3", 5));
                    break;
                case 54302047:
                    int i14 = f26 * (f24 + 1136);
                    iM324 = C0004.m324(C0010.decode(new byte[]{-21, -109, -67, -59, -71, -105, -21, -108}, "01fbb0", 3));
                    break;
                case 54357876:
                    int i15 = f26 * (f24 ^ 4310);
                    iM324 = C0003.m321(C0010.decode(new byte[]{-72, -62, -19, -107, -29, -100, -19, -54}, "cb62846b48356d8a", true));
                    break;
                case 54361437:
                    int i16 = f26 * (f24 | 2311);
                    iM324 = C0002.m316(C0010.decode(new byte[]{-72, -4, -17, -109, -29, -102, -72, -111}, "cc4088c5bf", true));
                    break;
                case 54363549:
                    int i17 = f26 * (f24 ^ 3975);
                    iM324 = C0005.m330(C0010.decode(new byte[]{-20, -112, -29, -112, -18, -112, -19, -99}, "70815069893a1acd", true));
                    break;
                case 54391360:
                    int i18 = f26 * (f24 | 1979);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-20, -63, -30, -111, -65, -62, -20, -61}, "7b97db7da4827c3a"));
                    break;
                case 54419221:
                    int i19 = f26 * (f24 + 2964);
                    iM324 = C0001.m311(C0010.decode(new byte[]{-17, -108, -20, -59, -66, -111, -24, -58}, "437fe23aae675db1"));
                    break;
                case 54420251:
                    int i20 = f26 * (f24 | 6326);
                    iM324 = C0009.m349(C0010.decode(new byte[]{-67, -111, -21, -58, -23, -101, -23, -111}, "f20d232530df", true));
                    break;
            }
        }
    }
}
