package com.mobilex.hub;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Iterator;
import p000.C0010;

/* JADX INFO: loaded from: classes3.dex */
public class eRLkMqbO {

    /* JADX INFO: renamed from: ۟۟ۥۨۢ, reason: not valid java name and contains not printable characters */
    public static int f30 = 1579099351;

    /* JADX INFO: renamed from: ۟ۢۨ۠, reason: not valid java name and contains not printable characters */
    public static int f31 = -715;

    /* JADX INFO: renamed from: ۢ۠ۤ۠ۧۥ, reason: not valid java name and contains not printable characters */
    private static int f32 = 0;

    /* JADX INFO: renamed from: ۢۡۨۤۦ, reason: not valid java name and contains not printable characters */
    private static String f33 = null;

    /* JADX INFO: renamed from: ۣ۠ۤۤ, reason: not valid java name and contains not printable characters */
    public static int f34 = 296966175;

    /* JADX INFO: renamed from: ۦۡۨۦۤۡ, reason: contains not printable characters */
    private static String f35;

    /* JADX INFO: renamed from: ۧۡۥۦۢۧ, reason: not valid java name and contains not printable characters */
    private static short[] f36 = {5561, 5549, 5536, 5559, 5623, 5625, 5567, 11524, 11577, 11528, 11530, 11522, 11528, 11534, 11532, 11546, 2249, 2266, 2261, 2264, 2259, 2254, -5118, -5054, -5028, -5005, -5047, -5036, -5032, -5118, -5043, -5028, -5049, -26200, -26180, -26191, -26202, -26138, -26136, -987, -985, -980, -985, -976, -981, -991, -915, -975, -986, -983, -915, -987, -985, -980, -985, -976, -981, -991, 3684, 3685, 3698, 6238, 6236, 6231, 6236, 6219, 6224, 6234, 6166, 6223, 6235, 6230, 6209, 6145, 6159, 6217, 6166, 6223, 6235, 6230, 6209, 6145, 6159, 6217, 16527, 16557, 16550, 16561, 16549, 16551, 16572, 16545, 16551, 16550, 32752, 32747, 32750, 32747, 32746, 32754, 32747};

    /* JADX INFO: renamed from: ۨۦۤۦۢۢ, reason: not valid java name and contains not printable characters */
    private static String f37;

    /* JADX INFO: renamed from: ۣ۟۟ۦۤ, reason: not valid java name and contains not printable characters */
    public static Object m101(Object obj) {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-17, -98, -29, -60, -23, -108, -72, -107}, "488f25c76d", 0.0f));
        while (true) {
            switch (iM317) {
                case 54180990:
                    int i = f34 * (f30 ^ 1074);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-67, -109, -70, -64, -18, -112, -67, -108}, "f1ae50f2", 0));
                    break;
                case 54210566:
                    int i2 = f34 * (f30 | 2190);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-65, -57, -30, -111, -23, -64, -22, -63}, "db912c1de8217e", 0.0f));
                    break;
                case 54211777:
                    int i3 = f34 * (f30 ^ 5673);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-30, -109, -21, -100, -72, -107, -17, -61}, "9704c34e097644", 0.0f));
                    break;
                case 54214658:
                    int i4 = f34 * (f30 | 1037);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-29, -97, -19, -60, -65, -108, -23, -90}, "886ad4293a84", 0.0f));
                    break;
                case 54243243:
                    int i5 = f34 * (f30 ^ 4056);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-67, -101, -23, -52, -70, -58, -21, -106}, "f82dad07"));
                    break;
                case 54244233:
                    int i6 = f34 * (f30 | 7842);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-24, -107, -30, -105, -17, -98, -24, -106}, "339448", 0.0f));
                    break;
                case 54246398:
                    int i7 = f34 * (f30 + 2029);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-18, -107, -18, -107, -72, -62, -20, -107}, "5554cd76cc4e"));
                    break;
                case 54271384:
                    int i8 = f34 * (f30 | 1036);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-65, -107, -67, -100, -20, -105, -22, -62}, "d6f9751d6bf166b2", 0.0f));
                    break;
                case 54272318:
                    int i9 = f34 * (f30 ^ 2103);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-30, -107, -17, -110, -18, -104, -30, -105}, "964050", false));
                    break;
                case 54274086:
                    int i10 = f34 * (f30 + 5229);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-67, -110, -18, -84, -22, -110, -21, -83}, "f5531202de72697d"));
                    break;
                case 54276964:
                    int i11 = f34 * (f30 ^ 1927);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-20, -106, -21, -64, -22, -106, -72, -111}, "710c15c13126f7bc"));
                    break;
                case 54301112:
                    if (Z5HFgwkz.m63() > 0) {
                        return ((Iterator) obj).next();
                    }
                    return null;
                case 54306884:
                    int i12 = f34 * (f30 | 3231);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-22, -101, -70, -108, -19, -111, -67, -58}, "18a766fc44193d29", true));
                    break;
                case 54328893:
                    int i13 = f34 * (f30 + 6432);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-30, -112, -70, -111, -70, -83, -71, -7}, "98a3a2bf51", 0.0f));
                    break;
                case 54334535:
                    int i14 = f34 * (f30 | 5240);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-24, -61, -66, -62, -70, -7, -21, -104}, "3aefaf006d"));
                    break;
                case 54360541:
                    int i15 = f34 * (f30 ^ 4860);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-20, -60, -23, -101, -29, -62, -17, -61}, "7e298e4d9b", 0.0f));
                    break;
                case 54361660:
                    int i16 = f34 * (f30 | 7674);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-67, -57, -18, -57, -72, -106, -23, -63}, "fc5ec02a"));
                    break;
                case 54387415:
                    int i17 = f34 * (f30 | 2197);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-65, -64, -30, -109, -18, -81, -23, -111}, "da925024aeb2dc52"));
                    break;
                case 54391353:
                    int i18 = f34 * (f30 ^ 297);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-17, -111, -29, -58, -21, -50, -67, -104}, "438a0ff9"));
                    break;
                case 54393181:
                    int i19 = f34 * (f30 ^ 489);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-24, -52, -65, -60, -21, -106, -23, -112}, "3dda0720", 0.0f));
                    break;
                case 54420058:
                    int i20 = f34 * (f30 | 4659);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-71, -108, -17, -107, -22, -106, -72, -106}, "b54011c32f318378", 3));
                    break;
                case 54423004:
                    int i21 = f34 * (f30 | 3957);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-21, -111, -67, -107, -21, -6, -21, -58}, "04f30e0cfe6d", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۠۠ۨۢ, reason: not valid java name and contains not printable characters */
    public static boolean m102(Object obj) {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-71, -110, -29, -109, -66, -61, -71, -105}, "b684ef"));
        while (true) {
            switch (iM342) {
                case 54185706:
                    int i = f34 * (f30 + 5776);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-67, -64, -71, -58, -17, -109, -24, -58}, "fcbe443f67e15d"));
                    break;
                case 54187777:
                    int i2 = f34 * (f30 + 8142);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-72, -52, -67, -57, -30, -107, -23, -112}, "cdfb9423b755b8", 6));
                    break;
                case 54214628:
                    int i3 = f34 * (f30 | 3503);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-71, -107, -70, -63, -67, -64, -29, -59}, "b6acfc8ffd", 0.0f));
                    break;
                case 54245252:
                    int i4 = f34 * (f30 + 565);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-22, -110, -66, -109, -29, -64, -17, -111}, "16e48d434341", 0.0f));
                    break;
                case 54270332:
                    int i5 = f34 * (f30 | 2474);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-22, -58, -29, -101, -71, -110, -17, -112}, "1b89b0475c3ead", 6));
                    break;
                case 54271231:
                    int i6 = f34 * (f30 | 6313);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-20, -108, -19, -106, -30, -83, -23, -111}, "70629224", 5));
                    break;
                case 54271259:
                    int i7 = f34 * (f30 + 2237);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-19, -55, -66, -108, -71, -105, -66, -62}, "6ae6b0eb3bcd4f", 3));
                    break;
                case 54272313:
                    int i8 = f34 * (f30 + 2520);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-17, -59, -67, -62, -70, -54, -71, -100}, "4cfaabb8", 0.0f));
                    break;
                case 54299097:
                    int i9 = f34 * (f30 + 4007);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-17, -64, -22, -112, -19, -111, -22, -108}, "4b1663162e", 2));
                    break;
                case 54300995:
                    int i10 = f34 * (f30 + 1049);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-24, -61, -70, -109, -70, -2, -18, -88}, "3fa4aa577efce9"));
                    break;
                case 54302822:
                    int i11 = f34 * (f30 ^ 4918);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-19, -106, -30, -106, -19, -61, -67, -108}, "60936ef73f82d1cc", 3));
                    break;
                case 54305857:
                    int i12 = f34 * (f30 + 2608);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-71, -107, -17, -98, -71, -112, -24, -57}, "b546b83f1686", 0.0f));
                    break;
                case 54305887:
                    int i13 = f34 * (f30 ^ 3264);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-22, -106, -72, -57, -67, -5, -18, -98}, "10cefd586ccc", 2));
                    break;
                case 54335490:
                    int i14 = f34 * (f30 | 1447);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-18, -58, -71, -61, -72, -100, -24, -107}, "5ebac83567", true));
                    break;
                case 54336514:
                    int i15 = f34 * (f30 + 978);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-65, -59, -22, -108, -29, -57, -24, -63}, "de128d3f99e975", false));
                    break;
                case 54360483:
                    int i16 = f34 * (f30 | 4793);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-65, -106, -17, -112, -20, -110, -71, -98}, "d04373b8", false));
                    break;
                case 54361506:
                    int i17 = f34 * (f30 | 2624);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-22, -62, -65, -108, -23, -105, -66, -59}, "1ad522efcc74c1ba", 4));
                    break;
                case 54361721:
                    int i18 = f34 * (f30 + 5633);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-66, -51, -23, -63, -23, -98, -72, -111}, "ee2a29c7f11c2876", 5));
                    break;
                case 54363580:
                    if (hv970Gaa.m146() <= 0) {
                        return ((Iterator) obj).hasNext();
                    }
                    return false;
                case 54418391:
                    int i19 = f34 * (f30 | 7704);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-22, -110, -17, -63, -65, -61, -71, -107}, "134ddeb3e104"));
                    break;
                case 54420307:
                    int i20 = f34 * (f30 | 440);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-19, -64, -29, -62, -30, -110, -19, -60}, "6d8b91", true));
                    break;
                case 54423007:
                    int i21 = f34 * (f30 ^ 4446);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-30, -63, -18, -104, -18, -104, -22, -104}, "9d505918", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۠ۢۨ۠, reason: not valid java name and contains not printable characters */
    public static void m103(Object obj) throws IOException {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-19, -81, -18, -107, -70, -100, -22, -112}, "6054a916ceafdf", 3));
        while (true) {
            switch (iM315) {
                case 54151016:
                    int i = f34 * (f30 | 610);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-66, -62, -21, -97, -67, -107, -66, -59}, "ed08f4", 0.0f));
                    break;
                case 54151135:
                    int i2 = f34 * (f30 ^ 6497);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-18, -108, -30, -64, -23, -105, -20, -111}, "559f2774b7bb2756", 2));
                    break;
                case 54151171:
                    int i3 = f34 * (f30 ^ 5483);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-65, -59, -18, -5, -66, -105, -29, -59}, "db5de68f29", true));
                    break;
                case 54151973:
                    int i4 = f34 * (f30 ^ 4133);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-71, -111, -29, -105, -22, -106, -23, -112}, "b4821025", 3));
                    break;
                case 54152995:
                    int i5 = f34 * (f30 + 473);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-18, -5, -18, -106, -23, -109, -70, -110}, "5d5727a392a3"));
                    break;
                case 54179042:
                    int i6 = f34 * (f30 ^ 3813);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-21, -110, -30, -57, -22, -109, -21, -112}, "069e14", false));
                    break;
                case 54187746:
                    int i7 = f34 * (f30 + 6425);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-30, -108, -29, -84, -19, -61, -67, -97}, "94836ff75a2917c3", 0.0f));
                    break;
                case 54215402:
                    int i8 = f34 * (f30 + 4999);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-19, -110, -18, -112, -18, -105, -65, -57}, "675253deb67c", 0.0f));
                    break;
                case 54238615:
                    int i9 = f34 * (f30 ^ 4878);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-19, -89, -66, -61, -71, -104, -17, -58}, "68eab84d703216", false));
                    break;
                case 54245257:
                    int i10 = f34 * (f30 + 4663);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-21, -103, -29, -111, -72, -110, -18, -64}, "0186c15c4a3f", true));
                    break;
                case 54274951:
                    int i11 = f34 * (f30 | 7789);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-24, -107, -23, -61, -20, -57, -30, -58}, "372e7e9a076f", 1));
                    break;
                case 54301149:
                    int i12 = f34 * (f30 + 3562);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-23, -99, -24, -63, -18, -55, -23, -101}, "283b5a", false));
                    break;
                case 54305730:
                    int i13 = f34 * (f30 | 3838);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-20, -82, -23, -111, -24, -58, -23, -105}, "71203f21f4895bf4"));
                    break;
                case 54330843:
                    int i14 = f34 * (f30 | 7433);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-70, -99, -30, -109, -72, -107, -70, -98}, "a895c4", 3));
                    break;
                case 54331929:
                    int i15 = f34 * (f30 ^ 1672);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-18, -60, -20, -61, -21, -83, -22, -57}, "5c7a021e022e12", 2));
                    break;
                case 54333791:
                    int i16 = f34 * (f30 + 7915);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-71, -111, -20, -97, -65, -5, -66, -111}, "b279dde2"));
                    break;
                case 54334598:
                    int i17 = f34 * (f30 ^ 3870);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-23, -110, -71, -88, -17, -106, -71, -81}, "20b743b094"));
                    break;
                case 54365345:
                    int i18 = f34 * (f30 | 3576);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-70, -55, -19, -57, -65, -112, -67, -64}, "aa6bd0fc3cc919", true));
                    break;
                case 54387450:
                    int i19 = f34 * (f30 ^ 5490);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-20, -89, -20, -105, -20, -61, -20, -103}, "78747a", 7));
                    break;
                case 54390270:
                    if (Z5HFgwkz.m63() > 0) {
                        ((FileOutputStream) obj).close();
                        return;
                    }
                    return;
                case 54422976:
                    int i20 = f34 * (f30 ^ 1348);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-20, -108, -19, -50, -23, -107, -30, -109}, "746f2292edc5a6", false));
                    break;
                case 54424991:
                    int i21 = f34 * (f30 ^ 5132);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-65, -63, -24, -109, -20, -111, -71, -82}, "de3471b18cd66d"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟۠ۤۥۨ, reason: not valid java name and contains not printable characters */
    public static void m104(Object obj) throws IOException {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-19, -106, -22, -109, -72, -108, -22, -63}, "6317c01ddabb47"));
        while (true) {
            switch (iM347) {
                case 54152067:
                    int i = f34 * (f30 ^ 6638);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-29, -62, -66, -107, -67, -106, -29, -57}, "8fe0f2"));
                    break;
                case 54155814:
                    int i2 = f34 * (f30 + 2273);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-20, -83, -17, -106, -18, -112, -29, -58}, "7244538e7ba338", 0.0f));
                    break;
                case 54155877:
                    int i3 = f34 * (f30 + 4206);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-72, -106, -30, -106, -23, -109, -20, -108}, "c3912276b7", 0.0f));
                    break;
                case 54156904:
                    int i4 = f34 * (f30 + 3461);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-17, -111, -72, -105, -24, -112, -17, -100}, "49c635", 0.0f));
                    break;
                case 54157024:
                    int i5 = f34 * (f30 + 3649);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-19, -110, -71, -60, -29, -2, -30, -99}, "60bd8a95", 0));
                    break;
                case 54181980:
                    int i6 = f34 * (f30 | 1939);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-24, -88, -17, -97, -22, -52, -65, -61}, "37481ddce2108b65", 0.0f));
                    break;
                case 54182975:
                    int i7 = f34 * (f30 ^ 4860);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-22, -108, -17, -51, -17, -109, -72, -112}, "134e47c24986eb", 0.0f));
                    break;
                case 54208829:
                    if (m105() <= 0) {
                        C0004.m328((InputStream) obj);
                        return;
                    }
                    return;
                case 54239399:
                    int i8 = f34 * (f30 ^ 7303);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-23, -64, -30, -112, -20, -105, -72, -103}, "2f9773c994"));
                    break;
                case 54244356:
                    int i9 = f34 * (f30 | 70);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-24, -6, -20, -61, -20, -64, -29, -59}, "3e7e7b8e4b", 1));
                    break;
                case 54273030:
                    int i10 = f34 * (f30 + 1096);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-24, -62, -19, -108, -29, -101, -20, -112}, "3b6783742c", 6));
                    break;
                case 54301022:
                    int i11 = f34 * (f30 + 7461);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-71, -57, -29, -62, -71, -83, -71, -55}, "ba8bb2"));
                    break;
                case 54303934:
                    int i12 = f34 * (f30 ^ 6610);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-70, -58, -67, -63, -67, -58, -30, -109}, "abfcfe900094b8cd"));
                    break;
                case 54332768:
                    int i13 = f34 * (f30 + 1053);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-21, -104, -30, -64, -66, -112, -20, -61}, "089be77b7d"));
                    break;
                case 54335555:
                    int i14 = f34 * (f30 + 2220);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-21, -105, -72, -64, -30, -3, -24, -109}, "04cd9b37bef5e51d", 0.0f));
                    break;
                case 54358563:
                    int i15 = f34 * (f30 | 1511);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-30, -4, -19, -63, -21, -109, -72, -111}, "9c6f07c5395e", true));
                    break;
                case 54359798:
                    int i16 = f34 * (f30 + 3543);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-72, -62, -30, -3, -17, -61, -19, -63}, "cc9b4f6e", false));
                    break;
                case 54365437:
                    int i17 = f34 * (f30 + 7572);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-67, -54, -30, -112, -29, -53, -24, -3}, "fb938c3be657bc", 0.0f));
                    break;
                case 54389526:
                    int i18 = f34 * (f30 | 5103);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-30, -2, -30, -64, -30, -58, -21, -3}, "9a9f9f0b24022e", true));
                    break;
                case 54396191:
                    int i19 = f34 * (f30 | 4324);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-70, -108, -72, -110, -21, -53, -71, -110}, "a2c30cb1ee9e"));
                    break;
                case 54419289:
                    int i20 = f34 * (f30 + 2320);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-17, -64, -30, -107, -30, -100, -24, -110}, "4b909837de942e", false));
                    break;
                case 54421298:
                    int i21 = f34 * (f30 + 7990);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-22, -112, -72, -112, -18, -62, -70, -109}, "17c15da1136d1579"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۣ۟ۡۧ, reason: not valid java name and contains not printable characters */
    public static int m105() {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-72, -4, -30, -108, -65, -59, -21, -107}, "cc92df041f21edbf", false));
        while (true) {
            switch (iM317) {
                case 54154080:
                    int i = f34 * (f30 + 1810);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-71, -61, -21, -61, -66, -108, -30, -61}, "ba0fe09f9d", true));
                    break;
                case 54155909:
                    int i2 = f34 * (f30 | 392);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-19, -108, -72, -89, -20, -110, -23, -105}, "62c87524"));
                    break;
                case 54187594:
                    int i3 = f34 * (f30 + 982);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-71, -106, -24, -60, -29, -61, -65, -62}, "b03d8dde921e", 0.0f));
                    break;
                case 54208737:
                    int i4 = f34 * (f30 + 4854);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-70, -106, -72, -107, -71, -110, -72, -106}, "a5c2b4c454bc8c", true));
                    break;
                case 54210661:
                    int i5 = f34 * (f30 | 8131);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-29, -57, -70, -60, -18, -61, -29, -7}, "8fab5e", 7));
                    break;
                case 54215467:
                    int i6 = f34 * (f30 + 4533);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-22, -99, -29, -110, -66, -98, -71, -81}, "1981e8b031219348"));
                    break;
                case 54215582:
                    int i7 = f34 * (f30 ^ 8130);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-72, -101, -24, -84, -70, -110, -17, -63}, "c333a74e6efc234e", 0.0f));
                    break;
                case 54244356:
                    int i8 = f34 * (f30 + 6593);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-65, -60, -24, -50, -17, -60, -17, -106}, "dc3f4d463e8dae", 0.0f));
                    break;
                case 54268226:
                    int i9 = f34 * (f30 + 427);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-70, -107, -21, -59, -17, -108, -24, -59}, "a20f453c", true));
                    break;
                case 54276128:
                    int i10 = f34 * (f30 | 4506);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-17, -112, -66, -105, -29, -103, -30, -62}, "47e3899d89822a", 0.0f));
                    break;
                case 54302072:
                    int i11 = f34 * (f30 | 1426);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-65, -108, -66, -106, -21, -108, -67, -57}, "d1e705fb31d7", false));
                    break;
                case 54329792:
                    int i12 = f34 * (f30 | 5359);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-29, -111, -23, -53, -29, -105, -30, -57}, "892c849f81c4", 7));
                    break;
                case 54357845:
                    int i13 = f34 * (f30 + 8089);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-66, -108, -67, -97, -72, -109, -24, -105}, "e4f7c133caf3", 5));
                    break;
                case 54358810:
                    int i14 = f34 * (f30 ^ 5930);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-71, -110, -19, -106, -21, -102, -70, -107}, "b46009a161c8", false));
                    break;
                case 54364449:
                    int i15 = f34 * (f30 | 4470);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-21, -105, -29, -61, -67, -102, -19, -111}, "068ef869a4"));
                    break;
                case 54391297:
                    int i16 = f34 * (f30 + 163);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-67, -60, -20, -109, -72, -58, -20, -63}, "fe72cd7fe92c"));
                    break;
                case 54392227:
                    int i17 = f34 * (f30 ^ 1531);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-23, -63, -21, -6, -21, -7, -66, -60}, "2b0e0feabbdb51", 2));
                    break;
                case 54396065:
                    return 198 ^ f31;
                case 54417366:
                    int i18 = f34 * (f30 | 7948);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-19, -82, -17, -59, -71, -59, -18, -64}, "614abc5a48ac", false));
                    break;
                case 54425950:
                    int i19 = f34 * (f30 ^ 5965);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-22, -62, -65, -6, -65, -63, -21, -106}, "1cdedc0324007b", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۢۢ۠ۤ, reason: not valid java name and contains not printable characters */
    private static String m106() {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-29, -104, -71, -63, -19, -106, -17, -90}, "88bb664922", 0.0f));
        while (true) {
            switch (iM310) {
                case 54150265:
                    int i = f34 * (f30 | 3369);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-20, -59, -22, -58, -23, -63, -22, -109}, "7b1c2a15684e9f", 7));
                    break;
                case 54178978:
                    int i2 = f34 * (f30 | 3439);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-19, -112, -24, -64, -70, -64, -70, -100}, "643eaaa42f"));
                    break;
                case 54182722:
                    int i3 = f34 * (f30 ^ 2239);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-72, -112, -66, -60, -23, -59, -72, -103}, "c1ee2d"));
                    break;
                case 54210631:
                    int i4 = f34 * (f30 + 2227);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-23, -108, -18, -112, -21, -109, -67, -107}, "235404f18545db88"));
                    break;
                case 54244383:
                    int i5 = f34 * (f30 ^ 3218);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-70, -110, -17, -109, -20, -2, -21, -99}, "a4407a0952", true));
                    break;
                case 54269189:
                    int i6 = f34 * (f30 ^ 1095);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-70, -59, -66, -3, -67, -82, -22, -62}, "acebf11e4c9f82"));
                    break;
                case 54269369:
                    return C0005.m336(f36, 0, 759344355 ^ C0004.f70, 7);
                case 54272162:
                    int i7 = f34 * (f30 | 3146);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-66, -106, -67, -63, -18, -105, -21, -4}, "e1fa510c4bf8", 0.0f));
                    break;
                case 54273279:
                    int i8 = f34 * (f30 | 7844);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-67, -53, -29, -112, -19, -99, -20, -111}, "fc8369772b", 5));
                    break;
                case 54298044:
                    int i9 = f34 * (f30 + 5524);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-65, -100, -23, -6, -23, -58, -23, -51}, "d92e2b2e70", 4));
                    break;
                case 54301089:
                    int i10 = f34 * (f30 + 3044);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-30, -105, -24, -84, -20, -101, -65, -107}, "973378d3b1de890b", 0));
                    break;
                case 54303848:
                    int i11 = f34 * (f30 ^ 5892);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-71, -109, -18, -111, -29, -58, -18, -108}, "b0558a51"));
                    break;
                case 54304867:
                    int i12 = f34 * (f30 + 5622);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-20, -59, -71, -101, -24, -63, -20, -55}, "7ab93d", 0.0f));
                    break;
                case 54327966:
                    int i13 = f34 * (f30 | 2735);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-67, -110, -71, -111, -19, -101, -71, -110}, "f6b768b69e36"));
                    break;
                case 54357601:
                    int i14 = f34 * (f30 + 6143);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-30, -107, -18, -112, -29, -111, -30, -105}, "965084"));
                    break;
                case 54361442:
                    int i15 = f34 * (f30 ^ 6157);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-20, -99, -19, -59, -66, -111, -24, -62}, "756be73e"));
                    break;
                case 54388562:
                    int i16 = f34 * (f30 + 5365);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-67, -90, -19, -108, -67, -107, -67, -90}, "f964f2"));
                    break;
                case 54392442:
                    int i17 = f34 * (f30 | 3349);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-17, -100, -17, -87, -17, -60, -17, -103}, "48464d", 0.0f));
                    break;
                case 54393188:
                    int i18 = f34 * (f30 + 1782);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-66, -101, -70, -61, -70, -111, -66, -104}, "e9afa4", 0.0f));
                    break;
                case 54419130:
                    int i19 = f34 * (f30 | 3058);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-24, -101, -65, -59, -29, -106, -23, -64}, "38df842d2ddc8a", 0.0f));
                    break;
                case 54421181:
                    int i20 = f34 * (f30 + 3780);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-66, -103, -65, -112, -23, -58, -71, -57}, "e1d12fbfea0a"));
                    break;
                case 54425088:
                    int i21 = f34 * (f30 | 1904);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-72, -106, -22, -108, -66, -88, -72, -110}, "c514e7", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۢۥۤۦ, reason: not valid java name and contains not printable characters */
    public static String m107(String str) {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-23, -109, -19, -110, -70, -64, -70, -60}, "2065acac", 0.0f));
        while (true) {
            switch (iM317) {
                case 54154828:
                    int i = f34 * (f30 + 7153);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-67, -60, -67, -55, -30, -102, -29, -52}, "fafa988d"));
                    break;
                case 54182694:
                    int i2 = f34 * (f30 ^ 6527);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-20, -106, -70, -60, -67, -106, -20, -61}, "75adf57ca976fa", false));
                    break;
                case 54183906:
                    int i3 = f34 * (f30 + 2077);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-65, -108, -72, -99, -18, -105, -21, -107}, "d0c55302aa"));
                    break;
                case 54185730:
                    int i4 = f34 * (f30 + 2218);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-30, -107, -29, -105, -71, -112, -20, -112}, "9084b8770e4cc49e", 0.0f));
                    break;
                case 54209761:
                    int i5 = f34 * (f30 + 1795);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-67, -57, -19, -63, -17, -57, -21, -102}, "fd6a4a082042", false));
                    break;
                case 54214622:
                    int i6 = f34 * (f30 ^ 6172);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-29, -58, -24, -58, -22, -62, -66, -58}, "8f3b1eec25ca", 0.0f));
                    break;
                case 54241500:
                    int i7 = f34 * (f30 | 4466);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-22, -112, -24, -61, -70, -3, -22, -112}, "153fab", 0.0f));
                    break;
                case 54269306:
                    int i8 = f34 * (f30 ^ 4993);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-21, -64, -70, -111, -66, -98, -20, -105}, "0aa4e877dc6db024", 0.0f));
                    break;
                case 54269401:
                    int i9 = f34 * (f30 + 6208);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-29, -64, -23, -106, -71, -63, -67, -6}, "8e24bafe", true));
                    break;
                case 54275202:
                    int i10 = f34 * (f30 ^ 6584);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-18, -108, -30, -57, -67, -102, -21, -106}, "529df80716ac", 0.0f));
                    break;
                case 54276040:
                    int i11 = f34 * (f30 + 1556);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-22, -59, -23, -110, -67, -103, -18, -109}, "1c20f157fa1d6c6f", 0.0f));
                    break;
                case 54298079:
                    int i12 = f34 * (f30 ^ 1107);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-24, -105, -19, -109, -71, -3, -65, -110}, "3760bbd0ccb1"));
                    break;
                case 54299011:
                    int i13 = f34 * (f30 | 1873);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-24, -64, -24, -101, -19, -108, -24, -111}, "3b39613059eb", false));
                    break;
                case 54300212:
                    int i14 = f34 * (f30 + 5376);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-22, -50, -30, -107, -70, -108, -22, -60}, "1f91a0"));
                    break;
                case 54306823:
                    String strM119 = m119();
                    int i15 = 0;
                    String strM127 = m127();
                    while (i15 < 15) {
                        strM119 = new StringBuffer().append(strM119).append(Integer.toHexString(i15)).toString();
                        String string = new StringBuffer().append(strM127).append(((int) (Math.random() * ((double) 10))) ^ i15).toString();
                        i15++;
                        strM127 = string;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
                    while (str.length() > 0) {
                        byteArrayOutputStream.write((strM119.indexOf(str.charAt(-2)) << 4) | strM119.indexOf(str.charAt(-1)));
                    }
                    byte[] bArrM341 = C0007.m341(byteArrayOutputStream);
                    int length = bArrM341.length;
                    int length2 = strM127.length();
                    for (int i16 = 0; i16 < length; i16++) {
                        bArrM341[i16] = (byte) (bArrM341[i16] ^ strM127.charAt(i16 % length2));
                    }
                    return new String(bArrM341);
                case 54330716:
                    int i17 = f34 * (f30 | 1713);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-30, -106, -65, -109, -24, -63, -65, -98}, "95d53fd8"));
                    break;
                case 54331933:
                    int i18 = f34 * (f30 ^ 6797);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-30, -63, -17, -7, -65, -107, -72, -57}, "9e4fd4cb", 0));
                    break;
                case 54333574:
                    int i19 = f34 * (f30 ^ 1644);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-65, -107, -21, -63, -66, -63, -24, -64}, "d40aee3f", 2));
                    break;
                case 54336553:
                    int i20 = f34 * (f30 ^ 7128);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-72, -108, -18, -64, -67, -100, -67, -83}, "c05af4f25f5762", 0.0f));
                    break;
                case 54360760:
                    int i21 = f34 * (f30 + 4433);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-19, -3, -19, -99, -17, -5, -19, -57}, "6b684d", 7));
                    break;
                case 54361532:
                    int i22 = f34 * (f30 ^ 1281);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-19, -107, -22, -107, -18, -57, -72, -104}, "65135cc82d"));
                    break;
                case 54422138:
                    int i23 = f34 * (f30 | 6641);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-23, -105, -23, -109, -66, -105, -30, -110}, "2323e79599915d4e"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۢۥۥ, reason: not valid java name and contains not printable characters */
    public static ByteBuffer m108(Object obj) {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-72, -7, -29, -61, -18, -112, -71, -50}, "cf8c54bfbfab51f2"));
        while (true) {
            switch (iM329) {
                case 54150181:
                    int i = f34 * (f30 ^ 1309);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-67, -112, -23, -61, -29, -110, -67, -110}, "f72d82", true));
                    break;
                case 54157924:
                    int i2 = f34 * (f30 + 5439);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-29, -112, -30, -102, -24, -82, -29, -97}, "889831", 0.0f));
                    break;
                case 54185763:
                    int i3 = f34 * (f30 ^ 2486);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-65, -63, -23, -98, -22, -105, -17, -112}, "da2612413ca3", false));
                    break;
                case 54187684:
                    int i4 = f34 * (f30 ^ 6321);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-19, -99, -70, -110, -22, -58, -66, -105}, "68a11ce29c", 0.0f));
                    break;
                case 54209884:
                    int i5 = f34 * (f30 ^ 5232);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-72, -101, -19, -100, -17, -102, -65, -81}, "c86948d0802b58", false));
                    break;
                case 54210687:
                    int i6 = f34 * (f30 ^ 4407);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-21, -60, -19, -61, -20, -112, -65, -111}, "0f6e75d6e037a0", 3));
                    break;
                case 54211677:
                    int i7 = f34 * (f30 | 2118);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-72, -57, -67, -112, -19, -110, -24, -57}, "cdf0653a118d2427"));
                    break;
                case 54212730:
                    int i8 = f34 * (f30 | 2953);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-17, -111, -24, -57, -71, -64, -19, -106}, "443dbd63af0eee"));
                    break;
                case 54241378:
                    int i9 = f34 * (f30 ^ 6490);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-66, -64, -70, -59, -17, -110, -18, -86}, "eaaf4555d50bd0", 1));
                    break;
                case 54242436:
                    if (z1rBEw9J.m266() <= 0) {
                        return C0008.m346((byte[]) obj);
                    }
                    return null;
                case 54245350:
                    int i10 = f34 * (f30 | 3802);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-18, -64, -24, -107, -17, -101, -18, -62}, "5f3243", true));
                    break;
                case 54269436:
                    int i11 = f34 * (f30 ^ 5140);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-24, -112, -70, -105, -67, -110, -17, -108}, "32a5f347", false));
                    break;
                case 54274079:
                    int i12 = f34 * (f30 + 1573);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-20, -105, -24, -2, -23, -63, -20, -112}, "703a2b", 7));
                    break;
                case 54328801:
                    int i13 = f34 * (f30 + 4516);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-20, -107, -67, -112, -30, -99, -20, -111}, "74f095", 3));
                    break;
                case 54331807:
                    int i14 = f34 * (f30 + 5221);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-18, -104, -29, -105, -21, -110, -17, -57}, "5881074ef5"));
                    break;
                case 54331838:
                    int i15 = f34 * (f30 + 3982);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-67, -60, -66, -106, -21, -59, -65, -64}, "fee70fdb5de5"));
                    break;
                case 54365565:
                    int i16 = f34 * (f30 + 4708);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-67, -105, -66, -106, -22, -99, -20, -97}, "f5e519789e171b18", 0.0f));
                    break;
                case 54387509:
                    int i17 = f34 * (f30 + 2569);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-23, -86, -18, -97, -23, -59, -23, -108}, "25572c"));
                    break;
                case 54395109:
                    int i18 = f34 * (f30 | 7373);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-71, -97, -19, -106, -20, -106, -70, -52}, "b76475adc6", 5));
                    break;
                case 54420066:
                    int i19 = f34 * (f30 ^ 3379);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-22, -57, -20, -107, -21, -106, -23, -58}, "1f77022fc129fdbd"));
                    break;
                case 54420191:
                    int i20 = f34 * (f30 + 6097);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-70, -111, -18, -62, -19, -62, -20, -61}, "a45b6b7e8e6e32", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۟۟ۧۡ, reason: not valid java name and contains not printable characters */
    public static String m109(Object obj) {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-72, -60, -66, -59, -18, -62, -18, -101}, "cfed5e539208", true));
        while (true) {
            switch (iM329) {
                case 54151261:
                    int i = f34 * (f30 | 5328);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-24, -99, -21, -4, -29, -57, -71, -60}, "380c8bbb71066757", 1));
                    break;
                case 54152004:
                    int i2 = f34 * (f30 ^ 5883);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-22, -102, -67, -60, -66, -60, -67, -107}, "18faeff25c0f0f3a", 0.0f));
                    break;
                case 54154886:
                    int i3 = f34 * (f30 | 3944);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-67, -61, -19, -107, -71, -87, -29, -104}, "fe65b6809b94", 0.0f));
                    break;
                case 54180958:
                    int i4 = f34 * (f30 | 4781);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-22, -63, -30, -88, -21, -58, -18, -83}, "1f970e522c0ebb", false));
                    break;
                case 54215369:
                    int i5 = f34 * (f30 ^ 847);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-67, -62, -65, -64, -22, -110, -71, -110}, "ffde11b19961a7", false));
                    break;
                case 54240608:
                    int i6 = f34 * (f30 ^ 5546);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-18, -102, -20, -98, -66, -63, -18, -109}, "5279ec", 0.0f));
                    break;
                case 54244296:
                    int i7 = f34 * (f30 | 6765);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-71, -106, -29, -59, -65, -88, -19, -108}, "b78cd7675deb61", 0.0f));
                    break;
                case 54247329:
                    int i8 = f34 * (f30 | 3521);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-29, -112, -22, -111, -23, -57, -72, -57}, "85172acdb947"));
                    break;
                case 54268500:
                    int i9 = f34 * (f30 | 4786);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-66, -63, -72, -109, -67, -109, -19, -59}, "eec4f46aef", 0.0f));
                    break;
                case 54299037:
                    int i10 = f34 * (f30 ^ 228);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-30, -57, -18, -55, -66, -62, -24, -60}, "9e5aee3f9f", true));
                    break;
                case 54303905:
                    if (hv970Gaa.m146() <= 0) {
                        return ((CharSequence) obj).toString();
                    }
                    return null;
                case 54305952:
                    int i11 = f34 * (f30 | 6027);
                    iM329 = C0002.m317(C0010.decode(new byte[]{-70, -108, -24, -59, -21, -63, -21, -107}, "a13c0c011e", true));
                    break;
                case 54306726:
                    int i12 = f34 * (f30 ^ 7555);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-29, -58, -17, -2, -66, -52, -20, -59}, "8e4aed7e", 0.0f));
                    break;
                case 54327995:
                    int i13 = f34 * (f30 | 5674);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-66, -111, -70, -53, -19, -106, -20, -112}, "e5ac6773dc"));
                    break;
                case 54334627:
                    int i14 = f34 * (f30 | 4406);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-17, -58, -66, -59, -29, -111, -30, -57}, "4bee809e32ae0f7a"));
                    break;
                case 54334750:
                    int i15 = f34 * (f30 ^ 6851);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-19, -62, -66, -50, -66, -98, -71, -102}, "6eefe9b2"));
                    break;
                case 54358563:
                    int i16 = f34 * (f30 ^ 2436);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-21, -111, -67, -64, -66, -61, -22, -7}, "09ffed1f21dc", 4));
                    break;
                case 54387508:
                    int i17 = f34 * (f30 + 2784);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-24, -90, -67, -111, -71, -107, -65, -61}, "39f3b4da4f7ba27b", 0));
                    break;
                case 54396290:
                    int i18 = f34 * (f30 + 2055);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-65, -88, -72, -58, -20, -109, -22, -59}, "d7cc721d1150", false));
                    break;
                case 54424150:
                    int i19 = f34 * (f30 + 1221);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-23, -103, -65, -103, -20, -64, -23, -101}, "29d87e", 5));
                    break;
                case 54424958:
                    int i20 = f34 * (f30 ^ 47);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-30, -86, -30, -109, -21, -101, -30, -106}, "959203"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۣ۟۠ۨ, reason: not valid java name and contains not printable characters */
    public static String m110() {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-21, -64, -23, -110, -21, -107, -70, -110}, "0a2403a7", false));
        while (true) {
            switch (iM338) {
                case 54150080:
                    int i = f34 * (f30 + 7470);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-18, -59, -66, -108, -70, -111, -70, -112}, "5ce1a4a25dae"));
                    break;
                case 54150272:
                    int i2 = f34 * (f30 ^ 1530);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-67, -111, -19, -62, -65, -108, -22, -61}, "f66ad11af2098a", false));
                    break;
                case 54155014:
                    int i3 = f34 * (f30 ^ 3785);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-66, -89, -24, -60, -21, -107, -66, -104}, "e83d04", 7));
                    break;
                case 54184862:
                    int i4 = f34 * (f30 ^ 4344);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-71, -97, -67, -105, -23, -61, -19, -84}, "b8f22d63dc9379", 0.0f));
                    break;
                case 54210624:
                    int i5 = f34 * (f30 ^ 7060);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-23, -107, -66, -90, -29, -107, -30, -105}, "22e9829424"));
                    break;
                case 54211746:
                    int i6 = f34 * (f30 | 1808);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-65, -63, -18, -63, -24, -62, -24, -109}, "db5c3c352423b7", 7));
                    break;
                case 54215588:
                    int i7 = f34 * (f30 + 2522);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-29, -109, -29, -110, -22, -112, -66, -57}, "868413ea79421b", false));
                    break;
                case 54216359:
                    int i8 = f34 * (f30 ^ 1486);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-19, -89, -18, -62, -24, -108, -22, -60}, "685b331bf8", false));
                    break;
                case 54242553:
                    int i9 = f34 * (f30 | 724);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-23, -83, -19, -107, -17, -111, -23, -105}, "226044", false));
                    break;
                case 54271172:
                    int i10 = f34 * (f30 + 3009);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-22, -111, -29, -106, -66, -111, -70, -61}, "1183e6ac124b", false));
                    break;
                case 54274955:
                    int i11 = f34 * (f30 | 5222);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-71, -107, -70, -60, -66, -111, -72, -60}, "b3ace9cb6e", 0.0f));
                    break;
                case 54276968:
                    int i12 = f34 * (f30 | 1753);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-30, -108, -71, -59, -30, -103, -65, -57}, "90bc91dba33074", 4));
                    break;
                case 54305023:
                    if (Z5HFgwkz.m63() >= 0) {
                        return m106();
                    }
                    return null;
                case 54333760:
                    int i13 = f34 * (f30 ^ 4228);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-65, -111, -18, -109, -23, -106, -22, -112}, "d7562011", true));
                    break;
                case 54334660:
                    int i14 = f34 * (f30 + 8118);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-19, -98, -30, -5, -30, -5, -71, -60}, "669d9dbf7c"));
                    break;
                case 54363548:
                    int i15 = f34 * (f30 | 6218);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-70, -104, -19, -104, -70, -99, -18, -111}, "a060a856e3eb5cb3", 0.0f));
                    break;
                case 54363578:
                    int i16 = f34 * (f30 + 468);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-22, -63, -71, -98, -70, -89, -23, -107}, "1bb8a822a439", 0));
                    break;
                case 54365567:
                    int i17 = f34 * (f30 + 4141);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-29, -62, -21, -111, -66, -59, -29, -62}, "8c03ec8e", true));
                    break;
                case 54387636:
                    int i18 = f34 * (f30 | 188);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-72, -100, -24, -107, -70, -63, -24, -57}, "c930ad3b51ba18", false));
                    break;
                case 54391417:
                    int i19 = f34 * (f30 ^ 1320);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-30, -57, -30, -103, -24, -110, -72, -58}, "9d9130cce1", false));
                    break;
                case 54393398:
                    int i20 = f34 * (f30 | 6787);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-66, -110, -29, -97, -22, -103, -72, -60}, "e38819ce9a"));
                    break;
                case 54417178:
                    int i21 = f34 * (f30 ^ 7630);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-23, -108, -17, -105, -19, -98, -24, -105}, "264466376a449a", 0.0f));
                    break;
                case 54426018:
                    int i22 = f34 * (f30 + 5911);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-71, -62, -19, -110, -29, -60, -71, -62}, "bc638e", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤ۟ۧۥ, reason: not valid java name and contains not printable characters */
    public static String m111() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-22, -105, -20, -59, -65, -57, -19, -112}, "137bdd6355"));
        while (true) {
            switch (iM315) {
                case 54149311:
                    int i = f34 * (f30 | 2994);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-66, -106, -17, -63, -17, -57, -29, -110}, "e44c4c87", 0.0f));
                    break;
                case 54150116:
                    int i2 = f34 * (f30 | 6379);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-24, -107, -21, -60, -23, -109, -24, -85}, "340f26", true));
                    break;
                case 54184898:
                    int i3 = f34 * (f30 | 4107);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-24, -64, -21, -105, -24, -5, -65, -110}, "3e003dd073ac0e5d", 0.0f));
                    break;
                case 54211707:
                    int i4 = f34 * (f30 | 6758);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-65, -111, -19, -53, -19, -62, -71, -90}, "d26c6db9a0dd", 1));
                    break;
                case 54211801:
                    int i5 = f34 * (f30 ^ 6327);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-29, -63, -18, -62, -65, -110, -20, -98}, "8d5ad678"));
                    break;
                case 54238526:
                    int i6 = f34 * (f30 ^ 1355);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-19, -57, -23, -107, -65, -58, -17, -111}, "6c27de40e91f4b1c", 0.0f));
                    break;
                case 54241473:
                    if (Z5HFgwkz.m63() >= 0) {
                        return m124();
                    }
                    return null;
                case 54246340:
                    int i7 = f34 * (f30 + 5081);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-22, -5, -17, -4, -30, -105, -29, -98}, "1d4c908806", 0.0f));
                    break;
                case 54269215:
                    int i8 = f34 * (f30 | 7624);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-67, -100, -21, -60, -65, -59, -67, -100}, "f40adb", 3));
                    break;
                case 54277086:
                    int i9 = f34 * (f30 ^ 6936);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-23, -59, -21, -111, -20, -59, -72, -108}, "2c017ac5b58c6ba1", 5));
                    break;
                case 54299226:
                    int i10 = f34 * (f30 + 403);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-22, -97, -19, -110, -72, -97, -19, -59}, "1767c76fb0a0060d", 4));
                    break;
                case 54301020:
                    int i11 = f34 * (f30 ^ 6176);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-20, -109, -67, -111, -22, -103, -71, -103}, "72f311b95a", 6));
                    break;
                case 54305827:
                    int i12 = f34 * (f30 + 488);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-67, -62, -65, -105, -29, -103, -19, -105}, "fed1896083"));
                    break;
                case 54331808:
                    int i13 = f34 * (f30 | 2241);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-22, -109, -18, -57, -66, -53, -21, -100}, "135bec09beda", 0.0f));
                    break;
                case 54335493:
                    int i14 = f34 * (f30 + 525);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-72, -63, -30, -105, -30, -61, -22, -108}, "cf909c16ae", 0.0f));
                    break;
                case 54358711:
                    int i15 = f34 * (f30 | 2813);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-30, -63, -65, -112, -30, -108, -30, -64}, "9ed093", 0));
                    break;
                case 54394150:
                    int i16 = f34 * (f30 + 1012);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-66, -102, -24, -81, -71, -110, -18, -64}, "e830b05cf548"));
                    break;
                case 54395106:
                    int i17 = f34 * (f30 | 5295);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-20, -109, -19, -62, -18, -61, -70, -60}, "706b5caffa16", 0.0f));
                    break;
                case 54423198:
                    int i18 = f34 * (f30 + 6179);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-65, -7, -22, -111, -23, -58, -67, -64}, "df112dfe135e9171", 0.0f));
                    break;
                case 54423224:
                    int i19 = f34 * (f30 ^ 7998);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-65, -61, -30, -58, -65, -106, -19, -108}, "da9ad061d7c1fc1a", 4));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣ۟ۤۦۧ, reason: not valid java name and contains not printable characters */
    public static Field m112(Object obj, Object obj2) {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-17, -105, -18, -103, -65, -100, -24, -105}, "4258d932d0aba9d1", true));
        while (true) {
            switch (iM347) {
                case 54151262:
                    int i = f34 * (f30 + 3809);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-21, -108, -20, -98, -70, -109, -29, -106}, "0178a284d3", 4));
                    break;
                case 54152933:
                    int i2 = f34 * (f30 + 1735);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-22, -110, -17, -104, -67, -4, -30, -62}, "1248fc9beadfbc", 7));
                    break;
                case 54153900:
                    int i3 = f34 * (f30 ^ 7782);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-21, -103, -22, -112, -29, -63, -21, -99}, "09188b"));
                    break;
                case 54179809:
                    int i4 = f34 * (f30 | 2408);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-20, -57, -70, -62, -20, -103, -21, -64}, "7eab780fc76f", 0.0f));
                    break;
                case 54182849:
                    int i5 = f34 * (f30 | 6683);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-71, -59, -18, -99, -23, -62, -66, -50}, "be552defbe50cf", false));
                    break;
                case 54187625:
                    int i6 = f34 * (f30 + 5010);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-20, -62, -18, -110, -72, -59, -71, -83}, "7f54ccb2a10dfda2"));
                    break;
                case 54187722:
                    int i7 = f34 * (f30 + 6388);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-18, -110, -24, -112, -19, -101, -17, -58}, "5130684fc3d67c"));
                    break;
                case 54239459:
                    int i8 = f34 * (f30 | 6817);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-71, -100, -18, -54, -20, -107, -71, -90}, "b95b73"));
                    break;
                case 54245284:
                    int i9 = f34 * (f30 | 240);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-22, -110, -29, -109, -21, -84, -71, -102}, "168603b9dce8d988", 0.0f));
                    break;
                case 54269306:
                    int i10 = f34 * (f30 | 1955);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-65, -86, -23, -59, -17, -63, -22, -61}, "d52f4a1be83f8f1e", 3));
                    break;
                case 54298046:
                    int i11 = f34 * (f30 + 44);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-70, -60, -72, -62, -20, -62, -29, -5}, "accb7c8d"));
                    break;
                case 54303781:
                    int i12 = f34 * (f30 ^ 1349);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-65, -62, -21, -111, -18, -52, -67, -107}, "df065df60c", false));
                    break;
                case 54304955:
                    int i13 = f34 * (f30 | 4144);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-30, -111, -66, -105, -20, -108, -70, -110}, "99e574a1864f96"));
                    break;
                case 54305982:
                    int i14 = f34 * (f30 | 8150);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-67, -110, -22, -4, -71, -106, -71, -59}, "f61cb6bf", 7));
                    break;
                case 54329916:
                    int i15 = f34 * (f30 + 2478);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-24, -58, -72, -62, -30, -105, -66, -107}, "3fca93e73db32bb0", 5));
                    break;
                case 54334594:
                    int i16 = f34 * (f30 | 8076);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-65, -97, -17, -106, -72, -108, -18, -106}, "d845c650a4af80", 5));
                    break;
                case 54336668:
                    int i17 = f34 * (f30 + 848);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-72, -101, -19, -59, -22, -107, -21, -64}, "c36f100c65", false));
                    break;
                case 54388407:
                    int i18 = f34 * (f30 + 6410);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-67, -85, -24, -106, -18, -52, -72, -105}, "f4375dc35b97cef1", 5));
                    break;
                case 54391328:
                    if (Z5HFgwkz.m63() > 0) {
                        return ((Class) obj).getDeclaredField((String) obj2);
                    }
                    return null;
                case 54420093:
                    int i19 = f34 * (f30 ^ 310);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-70, -111, -65, -62, -72, -63, -29, -57}, "a3ddcb8dac"));
                    break;
                case 54421209:
                    int i20 = f34 * (f30 ^ 3217);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-17, -7, -24, -105, -18, -110, -17, -63}, "4f3352", 3));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۤۧۤۦ, reason: not valid java name and contains not printable characters */
    public static String m113() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-67, -54, -30, -111, -70, -51, -67, -110}, "fb91aef1", 0.0f));
        while (true) {
            switch (iM347) {
                case 54153991:
                    int i = f34 * (f30 | 1481);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-67, -100, -24, -108, -65, -6, -24, -64}, "f834de3d51d5ed08", true));
                    break;
                case 54157773:
                    int i2 = f34 * (f30 | 6537);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-21, -102, -20, -51, -20, -105, -30, -59}, "097e769ede", true));
                    break;
                case 54185581:
                    int i3 = f34 * (f30 | 4433);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-17, -83, -29, -104, -70, -106, -17, -105}, "4280a7", 0.0f));
                    break;
                case 54209662:
                    int i4 = f34 * (f30 ^ 4631);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-21, -58, -71, -103, -72, -112, -72, -105}, "0cb1c5c756"));
                    break;
                case 54215435:
                    int i5 = f34 * (f30 | 3594);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-18, -112, -19, -109, -23, -84, -17, -57}, "5763234fab7f", false));
                    break;
                case 54215652:
                    int i6 = f34 * (f30 + 6268);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-67, -106, -30, -63, -65, -108, -23, -107}, "f49ad725", 1));
                    break;
                case 54239515:
                    int i7 = f34 * (f30 ^ 2012);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-20, -112, -24, -110, -65, -105, -66, -106}, "7630d1e238cd", 0.0f));
                    break;
                case 54241566:
                    int i8 = f34 * (f30 ^ 2335);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-65, -99, -22, -63, -19, -107, -65, -109}, "d51d66"));
                    break;
                case 54243397:
                    int i9 = f34 * (f30 ^ 3499);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-70, -62, -67, -57, -29, -98, -20, -105}, "acfa86703dac", 0.0f));
                    break;
                case 54244264:
                    int i10 = f34 * (f30 | 5221);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-21, -110, -29, -50, -71, -111, -21, -107}, "068fb3", false));
                    break;
                case 54276932:
                    int i11 = f34 * (f30 | 4938);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-71, -97, -21, -53, -21, -111, -22, -62}, "b80c011b", false));
                    break;
                case 54298977:
                    int i12 = f34 * (f30 + 7040);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-30, -106, -67, -105, -17, -111, -19, -110}, "97f140656f7e22", 7));
                    break;
                case 54305023:
                    int i13 = f34 * (f30 ^ 3214);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-29, -107, -21, -109, -66, -108, -67, -62}, "8706e5fd", 1));
                    break;
                case 54306757:
                    int i14 = f34 * (f30 | 5743);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-19, -106, -24, -58, -66, -88, -22, -63}, "633de71c"));
                    break;
                case 54330688:
                    int i15 = f34 * (f30 ^ 7388);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-65, -64, -17, -101, -23, -111, -24, -109}, "de482034a614e80f", 6));
                    break;
                case 54331716:
                    int i16 = f34 * (f30 ^ 242);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-17, -61, -17, -108, -71, -110, -24, -107}, "4a40b63251", 3));
                    break;
                case 54336638:
                    if (Z5HFgwkz.m63() >= 0) {
                        return Build.PRODUCT;
                    }
                    return null;
                case 54360698:
                    int i17 = f34 * (f30 ^ 5682);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-72, -108, -67, -104, -18, -111, -20, -61}, "c5f8507c", 4));
                    break;
                case 54388347:
                    int i18 = f34 * (f30 | 688);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-30, -106, -29, -62, -23, -107, -20, -99}, "918b2078e1068c52", true));
                    break;
                case 54388537:
                    int i19 = f34 * (f30 + 1452);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-17, -109, -18, -61, -24, -112, -67, -63}, "475e38fdf4", false));
                    break;
                case 54396065:
                    int i20 = f34 * (f30 | 6355);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-19, -64, -21, -107, -17, -108, -30, -60}, "6b07439a", 1));
                    break;
                case 54418419:
                    int i21 = f34 * (f30 ^ 4212);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-24, -109, -29, -57, -17, -89, -67, -57}, "338a48fa", 5));
                    break;
                case 54423072:
                    int i22 = f34 * (f30 ^ 4483);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-20, -89, -65, -62, -29, -63, -65, -112}, "78df8bd5042cd41e"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۥۧۡ, reason: not valid java name and contains not printable characters */
    public static String m114() {
        int iM347 = C0008.m347(C0010.decode(new byte[]{-71, -109, -71, -102, -18, -112, -66, -98}, "b1b850e9e861ab", 0.0f));
        while (true) {
            switch (iM347) {
                case 54152998:
                    int i = f34 * (f30 ^ 3366);
                    iM347 = C0000.m310(C0010.decode(new byte[]{-18, -106, -24, -62, -17, -103, -18, -105}, "513e48", true));
                    break;
                case 54155912:
                    int i2 = f34 * (f30 | 6841);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-30, -102, -19, -108, -66, -58, -30, -101}, "9961ea"));
                    break;
                case 54156871:
                    int i3 = f34 * (f30 + 654);
                    iM347 = C0001.m315(C0010.decode(new byte[]{-71, -61, -22, -109, -65, -108, -22, -109}, "bb10d515"));
                    break;
                case 54179004:
                    int i4 = f34 * (f30 + 4776);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-29, -2, -18, -106, -65, -105, -18, -108}, "8a51d4561ab2", 0.0f));
                    break;
                case 54179910:
                    int i5 = f34 * (f30 ^ 4135);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-19, -97, -72, -109, -23, -64, -18, -99}, "67c62f5598"));
                    break;
                case 54212551:
                    int i6 = f34 * (f30 | 5260);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-29, -64, -19, -83, -23, -102, -18, -4}, "8e62285c", 0.0f));
                    break;
                case 54241351:
                    int i7 = f34 * (f30 | 1643);
                    iM347 = C0007.m342(C0010.decode(new byte[]{-17, -4, -71, -57, -71, -63, -72, -110}, "4cbabbc6b41c9587", false));
                    break;
                case 54244478:
                    int i8 = f34 * (f30 | 8081);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-65, -50, -22, -100, -19, -107, -22, -99}, "df196115fbe077", false));
                    break;
                case 54245410:
                    int i9 = f34 * (f30 + 2228);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-71, -112, -18, -103, -30, -106, -20, -111}, "b451977048b01d80", 6));
                    break;
                case 54274237:
                    int i10 = f34 * (f30 + 2786);
                    iM347 = C0002.m317(C0010.decode(new byte[]{-72, -103, -70, -62, -23, -63, -18, -52}, "c9ab2c5de6a36b"));
                    break;
                case 54298291:
                    int i11 = f34 * (f30 | 4281);
                    iM347 = C0009.m350(C0010.decode(new byte[]{-65, -98, -66, -99, -17, -110, -71, -61}, "d8e842bac9c26a", 3));
                    break;
                case 54304804:
                    int i12 = f34 * (f30 + 3189);
                    iM347 = C0008.m347(C0010.decode(new byte[]{-21, -105, -23, -111, -23, -103, -18, -110}, "02232953a38114"));
                    break;
                case 54306724:
                    int i13 = f34 * (f30 + 455);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-21, -83, -17, -63, -23, -101, -72, -111}, "024b29c583e7ff", false));
                    break;
                case 54327895:
                    int i14 = f34 * (f30 + 3479);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-17, -63, -21, -81, -17, -111, -21, -59}, "4e00490e2ee3", true));
                    break;
                case 54330718:
                    int i15 = f34 * (f30 ^ 7943);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-24, -111, -65, -57, -65, -98, -24, -108}, "34dcd8", false));
                    break;
                case 54332825:
                    if (Z5HFgwkz.m63() > 0) {
                        return m139();
                    }
                    return null;
                case 54361532:
                    int i16 = f34 * (f30 ^ 5819);
                    iM347 = C0005.m333(C0010.decode(new byte[]{-24, -61, -18, -90, -18, -112, -65, -62}, "3c5954dc60889d", false));
                    break;
                case 54363393:
                    int i17 = f34 * (f30 | 27);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-70, -106, -72, -109, -22, -60, -23, -100}, "a4c51c29"));
                    break;
                case 54394365:
                    int i18 = f34 * (f30 | 2812);
                    iM347 = C0006.m338(C0010.decode(new byte[]{-23, -60, -30, -105, -23, -63, -29, -64}, "2b942c8af8c5", false));
                    break;
                case 54395141:
                    int i19 = f34 * (f30 ^ 8105);
                    iM347 = C0003.m323(C0010.decode(new byte[]{-22, -64, -30, -62, -19, -59, -23, -62}, "1d9d6d2a8789", 5));
                    break;
                case 54423105:
                    int i20 = f34 * (f30 | 590);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-30, -111, -70, -57, -72, -58, -71, -106}, "96aacab3", 0.0f));
                    break;
                case 54423167:
                    int i21 = f34 * (f30 | 3555);
                    iM347 = C0004.m329(C0010.decode(new byte[]{-71, -108, -18, -60, -29, -99, -24, -57}, "b65a853d"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۟ۦۥۤ, reason: not valid java name and contains not printable characters */
    public static String m115() {
        int iM350 = C0009.m350(C0010.decode(new byte[]{-67, -110, -19, -107, -17, -106, -71, -111}, "f26044b1", 0.0f));
        while (true) {
            switch (iM350) {
                case 54149244:
                    int i = f34 * (f30 ^ 2895);
                    iM350 = C0000.m310(C0010.decode(new byte[]{-67, -60, -20, -107, -67, -6, -17, -51}, "fc77fe4ecb2417"));
                    break;
                case 54154018:
                    int i2 = f34 * (f30 ^ 369);
                    iM350 = C0006.m338(C0010.decode(new byte[]{-20, -101, -21, -110, -65, -100, -23, -106}, "7904d92367315c33", true));
                    break;
                case 54155791:
                    int i3 = f34 * (f30 ^ 3878);
                    iM350 = C0008.m347(C0010.decode(new byte[]{-70, -110, -29, -100, -30, -110, -22, -5}, "a484941d", 0.0f));
                    break;
                case 54157926:
                    int i4 = f34 * (f30 | 2860);
                    iM350 = C0007.m342(C0010.decode(new byte[]{-17, -51, -29, -100, -67, -64, -29, -58}, "4e89fd8c", 1));
                    break;
                case 54179069:
                    int i5 = f34 * (f30 ^ 2808);
                    iM350 = C0009.m350(C0010.decode(new byte[]{-29, -105, -72, -64, -17, -106, -29, -112}, "87cc46"));
                    break;
                case 54179816:
                    int i6 = f34 * (f30 | 1424);
                    iM350 = C0005.m333(C0010.decode(new byte[]{-30, -63, -72, -59, -71, -99, -24, -85}, "9fccb5346bd81bb3"));
                    break;
                case 54182730:
                    int i7 = f34 * (f30 ^ 155);
                    iM350 = C0002.m317(C0010.decode(new byte[]{-29, -105, -72, -58, -72, -105, -67, -3}, "86cfc1fb25", 0.0f));
                    break;
                case 54184620:
                    int i8 = f34 * (f30 + 1450);
                    iM350 = C0006.m338(C0010.decode(new byte[]{-70, -105, -21, -111, -30, -58, -22, -61}, "a6059e1ccd98"));
                    break;
                case 54184707:
                    int i9 = f34 * (f30 | 7777);
                    iM350 = C0004.m329(C0010.decode(new byte[]{-24, -62, -17, -59, -72, -89, -70, -58}, "3c4ec8ac66", 0.0f));
                    break;
                case 54209605:
                    int i10 = f34 * (f30 ^ 4124);
                    iM350 = C0004.m329(C0010.decode(new byte[]{-23, -81, -19, -110, -30, -99, -23, -111}, "206699", 6));
                    break;
                case 54209816:
                    int i11 = f34 * (f30 ^ 894);
                    iM350 = C0009.m350(C0010.decode(new byte[]{-23, -83, -24, -97, -19, -109, -29, -106}, "22376585", 7));
                    break;
                case 54213568:
                    int i12 = f34 * (f30 + 3684);
                    iM350 = C0005.m333(C0010.decode(new byte[]{-17, -57, -19, -58, -66, -105, -72, -104}, "4a6ce6c8c8", false));
                    break;
                case 54245348:
                    int i13 = f34 * (f30 + 2366);
                    iM350 = C0002.m317(C0010.decode(new byte[]{-19, -110, -72, -89, -70, -112, -67, -59}, "62c8a6fa99255307", 0));
                    break;
                case 54300150:
                    int i14 = f34 * (f30 ^ 3837);
                    iM350 = C0001.m315(C0010.decode(new byte[]{-67, -58, -20, -106, -29, -87, -18, -97}, "ff738659"));
                    break;
                case 54331841:
                    int i15 = f34 * (f30 ^ 6833);
                    iM350 = C0006.m338(C0010.decode(new byte[]{-17, -5, -20, -59, -17, -90, -21, -97}, "4d7c4908b3a4", true));
                    break;
                case 54335645:
                    int i16 = f34 * (f30 + 6352);
                    iM350 = C0007.m342(C0010.decode(new byte[]{-19, -89, -23, -83, -23, -99, -20, -106}, "68222877", 0));
                    break;
                case 54363422:
                    if (z1rBEw9J.m266() < 0) {
                        return m136();
                    }
                    return null;
                case 54364352:
                    int i17 = f34 * (f30 | 2261);
                    iM350 = C0007.m342(C0010.decode(new byte[]{-22, -110, -24, -61, -17, -109, -20, -88}, "163b4577", 0.0f));
                    break;
                case 54366459:
                    int i18 = f34 * (f30 ^ 590);
                    iM350 = C0001.m315(C0010.decode(new byte[]{-19, -108, -30, -98, -67, -106, -66, -84}, "6199f2e360babf12", 0.0f));
                    break;
                case 54390276:
                    int i19 = f34 * (f30 ^ 4071);
                    iM350 = C0001.m315(C0010.decode(new byte[]{-67, -61, -30, -104, -72, -84, -17, -61}, "fc98c34da4f6", false));
                    break;
                case 54394390:
                    int i20 = f34 * (f30 ^ 1926);
                    iM350 = C0001.m315(C0010.decode(new byte[]{-20, -58, -70, -58, -70, -111, -30, -105}, "7aaaa59542", false));
                    break;
                case 54395230:
                    int i21 = f34 * (f30 ^ 4932);
                    iM350 = C0001.m315(C0010.decode(new byte[]{-17, -97, -30, -61, -72, -107, -67, -108}, "499ec5f4125715", false));
                    break;
                case 54423102:
                    int i22 = f34 * (f30 ^ 3996);
                    iM350 = C0005.m333(C0010.decode(new byte[]{-71, -99, -23, -59, -19, -99, -65, -55}, "b82f68da98c3"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠۠ۤ۟, reason: not valid java name and contains not printable characters */
    private static String m116() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-22, -59, -30, -110, -17, -106, -22, -57}, "1f92441cec", false));
        while (true) {
            switch (iM329) {
                case 54150085:
                    int i = f34 * (f30 + 6932);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-20, -55, -65, -60, -29, -64, -65, -64}, "7adc8dda"));
                    break;
                case 54152223:
                    int i2 = f34 * (f30 | 4165);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-21, -101, -18, -63, -17, -88, -67, -106}, "035a47f2", false));
                    break;
                case 54153033:
                    int i3 = f34 * (f30 + 7617);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-67, -108, -18, -97, -65, -107, -72, -105}, "f757d7c3d16a"));
                    break;
                case 54156062:
                    int i4 = f34 * (f30 | 1684);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-20, -60, -23, -108, -71, -107, -19, -98}, "7e20b169635f55"));
                    break;
                case 54186814:
                    int i5 = f34 * (f30 + 1819);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-23, -90, -72, -60, -23, -55, -70, -58}, "29cf2aabbdcb3af8"));
                    break;
                case 54213606:
                    int i6 = f34 * (f30 + 4495);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-20, -105, -18, -58, -70, -106, -17, -57}, "705da64f060e6241", 5));
                    break;
                case 54247238:
                    return C0005.m336(f36, 61, 1751428664 ^ C0003.f68, 23);
                case 54269278:
                    int i7 = f34 * (f30 | 7300);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-17, -106, -67, -107, -72, -108, -65, -112}, "42f3c0d4", 0.0f));
                    break;
                case 54269279:
                    int i8 = f34 * (f30 + 7073);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-20, -105, -22, -112, -20, -60, -20, -106}, "70137c", 4));
                    break;
                case 54276967:
                    int i9 = f34 * (f30 + 3021);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-66, -112, -65, -110, -24, -7, -21, -63}, "e7d33f0b03f057", 0.0f));
                    break;
                case 54303103:
                    int i10 = f34 * (f30 | 2003);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-67, -97, -29, -64, -24, -106, -65, -83}, "f98f30d2cf"));
                    break;
                case 54304898:
                    int i11 = f34 * (f30 ^ 2827);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-24, -105, -21, -107, -19, -112, -20, -62}, "3301687ee4", 1));
                    break;
                case 54363390:
                    int i12 = f34 * (f30 ^ 4391);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-70, -100, -17, -97, -24, -100, -72, -63}, "a44834cb9424", true));
                    break;
                case 54364537:
                    int i13 = f34 * (f30 ^ 2807);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-20, -51, -17, -50, -65, -99, -23, -100}, "7e4fd524796bcd54", 2));
                    break;
                case 54366373:
                    int i14 = f34 * (f30 ^ 5809);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-22, -88, -24, -111, -71, -103, -20, -100}, "1731b879f93106"));
                    break;
                case 54389310:
                    int i15 = f34 * (f30 + 8022);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-22, -62, -24, -101, -18, -59, -21, -59}, "1e385c0d", 0.0f));
                    break;
                case 54390300:
                    int i16 = f34 * (f30 + 4148);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-70, -106, -29, -112, -65, -61, -24, -108}, "a580da377d34", 0.0f));
                    break;
                case 54391447:
                    int i17 = f34 * (f30 | 8004);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-19, -82, -17, -105, -17, -102, -19, -82}, "614142", 0.0f));
                    break;
                case 54391483:
                    int i18 = f34 * (f30 + 2227);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-30, -84, -22, -112, -71, -111, -65, -51}, "9313b2de5b806688", 6));
                    break;
                case 54418141:
                    int i19 = f34 * (f30 | 2806);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-19, -105, -30, -50, -72, -112, -21, -64}, "619fc30f", 0.0f));
                    break;
                case 54425020:
                    int i20 = f34 * (f30 ^ 3632);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-71, -64, -70, -108, -20, -62, -71, -7}, "bfa17b", 2));
                    break;
                case 54425146:
                    int i21 = f34 * (f30 ^ 2755);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-72, -110, -30, -98, -71, -59, -72, -108}, "c096ba", 0.0f));
                    break;
                case 54426112:
                    int i22 = f34 * (f30 | 1543);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-20, -110, -29, -109, -19, -50, -30, -6}, "72846f9e8681bc"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۠ۨۦۧ۟ۧ, reason: not valid java name and contains not printable characters */
    private static String m117() {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-65, -59, -24, -112, -29, -64, -70, -58}, "db318eab7211", false));
        while (true) {
            switch (iM317) {
                case 54153988:
                    int i = f34 * (f30 + 2801);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-23, -63, -29, -110, -19, -98, -23, -61}, "2d8168", 5));
                    break;
                case 54179128:
                    int i2 = f34 * (f30 + 2289);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-66, -109, -18, -87, -19, -111, -17, -105}, "e15663462382b524", true));
                    break;
                case 54184647:
                    int i3 = f34 * (f30 + 3100);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-21, -106, -20, -109, -72, -107, -20, -105}, "0172c37437", 6));
                    break;
                case 54216483:
                    int i4 = f34 * (f30 | 3812);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-29, -102, -17, -51, -20, -62, -18, -106}, "824e7d5594dad8", 0.0f));
                    break;
                case 54238524:
                    int i5 = f34 * (f30 ^ 7253);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-29, -102, -72, -105, -21, -58, -29, -99}, "89c70e"));
                    break;
                case 54243331:
                    int i6 = f34 * (f30 | 311);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-66, -112, -29, -100, -20, -106, -21, -101}, "e284770962de652a", 6));
                    break;
                case 54244415:
                    int i7 = f34 * (f30 + 4899);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-66, -100, -30, -81, -66, -57, -29, -105}, "e490ed84c99bae"));
                    break;
                case 54246182:
                    int i8 = f34 * (f30 + 3195);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-17, -84, -29, -62, -29, -62, -71, -110}, "438f8ab0", true));
                    break;
                case 54247143:
                    int i9 = f34 * (f30 + 315);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-24, -107, -19, -64, -30, -62, -22, -64}, "376e9d1b"));
                    break;
                case 54269310:
                    return C0005.m336(f36, 94, 2046910820 ^ C0001.f64, 7);
                case 54273308:
                    int i10 = f34 * (f30 + 4510);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-70, -61, -70, -58, -66, -104, -70, -61}, "aaaae9", false));
                    break;
                case 54328022:
                    int i11 = f34 * (f30 ^ 5467);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-23, -62, -66, -88, -21, -112, -21, -106}, "2be70807853cca06", 0));
                    break;
                case 54329018:
                    int i12 = f34 * (f30 + 7007);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-18, -107, -29, -100, -71, -99, -18, -107}, "5688b5"));
                    break;
                case 54331715:
                    int i13 = f34 * (f30 ^ 5587);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-66, -111, -65, -86, -22, -59, -70, -63}, "e4d51cac", true));
                    break;
                case 54331871:
                    int i14 = f34 * (f30 | 7602);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-67, -109, -21, -60, -22, -52, -18, -87}, "f60b1d56", true));
                    break;
                case 54334808:
                    int i15 = f34 * (f30 ^ 6997);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-71, -64, -29, -64, -72, -61, -19, -105}, "bb8dca64d5baaf8b", 5));
                    break;
                case 54389497:
                    int i16 = f34 * (f30 + 7937);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-71, -107, -17, -60, -21, -112, -22, -108}, "b54a0016ae7192", 1));
                    break;
                case 54389527:
                    int i17 = f34 * (f30 | 3448);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-18, -60, -67, -111, -17, -112, -18, -60}, "5ef644", 0.0f));
                    break;
                case 54417303:
                    int i18 = f34 * (f30 | 2388);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-67, -108, -24, -58, -24, -110, -67, -57}, "f13e33fa505d0628"));
                    break;
                case 54426045:
                    int i19 = f34 * (f30 | 2508);
                    iM317 = C0007.m342(C0010.decode(new byte[]{-67, -57, -67, -62, -24, -97, -21, -111}, "fbfb380747", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡ۟۠ۨ۟۟, reason: not valid java name and contains not printable characters */
    private static String m118() {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-67, -4, -30, -50, -24, -97, -30, -111}, "fc9f3991", 3));
        while (true) {
            switch (iM338) {
                case 54155110:
                    int i = f34 * (f30 + 3133);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-71, -62, -72, -97, -65, -105, -71, -58}, "bfc9d0"));
                    break;
                case 54157923:
                    int i2 = f34 * (f30 | 3380);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-71, -106, -17, -86, -19, -58, -66, -57}, "b6456aeeae", 0.0f));
                    break;
                case 54179098:
                    int i3 = f34 * (f30 | 8140);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-66, -99, -66, -61, -29, -82, -66, -99}, "e8ea81", 4));
                    break;
                case 54179815:
                    int i4 = f34 * (f30 ^ 911);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-22, -108, -17, -5, -17, -112, -21, -105}, "174d4304792a4494", false));
                    break;
                case 54241503:
                    int i5 = f34 * (f30 + 3844);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-70, -106, -22, -104, -18, -88, -70, -112}, "a61857", 0.0f));
                    break;
                case 54268348:
                    int i6 = f34 * (f30 | 7108);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-29, -108, -24, -64, -70, -61, -20, -102}, "873baf72", 3));
                    break;
                case 54271298:
                    int i7 = f34 * (f30 ^ 1905);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-66, -53, -21, -105, -18, -110, -19, -63}, "ec03546c", 4));
                    break;
                case 54303843:
                    int i8 = f34 * (f30 | 754);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-30, -84, -17, -105, -24, -55, -29, -54}, "93423a8b5ef9", 0.0f));
                    break;
                case 54304893:
                    int i9 = f34 * (f30 ^ 8139);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-67, -106, -21, -105, -67, -110, -67, -112}, "f405f7", false));
                    break;
                case 54304963:
                    int i10 = f34 * (f30 ^ 5374);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-17, -57, -23, -105, -20, -88, -66, -7}, "4b2177efd9342d", true));
                    break;
                case 54304987:
                    int i11 = f34 * (f30 ^ 2872);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-20, -50, -18, -58, -24, -98, -67, -112}, "7f5e39f7a749"));
                    break;
                case 54327873:
                    int i12 = f34 * (f30 | 5938);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-29, -111, -20, -112, -30, -62, -17, -106}, "85769d417bbe26"));
                    break;
                case 54327903:
                    int i13 = f34 * (f30 ^ 5744);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-70, -60, -65, -63, -20, -102, -70, -59}, "aadb72"));
                    break;
                case 54330691:
                    int i14 = f34 * (f30 | 3959);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-18, -100, -17, -106, -71, -111, -67, -110}, "5440b7f491db92ca"));
                    break;
                case 54331930:
                    int i15 = f34 * (f30 ^ 4050);
                    iM338 = C0003.m323(C0010.decode(new byte[]{-66, -109, -70, -62, -71, -108, -65, -5}, "e7adb0dd5f5eb7", false));
                    break;
                case 54334529:
                    int i16 = f34 * (f30 | 7799);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-20, -52, -20, -63, -66, -107, -29, -88}, "7d7de18745", 0));
                    break;
                case 54360484:
                    return C0005.m336(f36, 84, 528047657 ^ C0001.f64, 10);
                case 54421275:
                    int i17 = f34 * (f30 | 674);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-21, -107, -20, -5, -67, -57, -21, -105}, "007dfe", true));
                    break;
                case 54422200:
                    int i18 = f34 * (f30 ^ 2514);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-66, -98, -29, -108, -20, -85, -66, -97}, "e88674", 3));
                    break;
                case 54423096:
                    int i19 = f34 * (f30 + 979);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-22, -62, -30, -112, -24, -62, -22, -59}, "1f953c", 1));
                    break;
                case 54424126:
                    int i20 = f34 * (f30 | 8097);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-67, -108, -19, -87, -20, -57, -67, -103}, "f1667f"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۡۤۡ۟, reason: not valid java name and contains not printable characters */
    private static String m119() {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-71, -88, -71, -90, -66, -104, -17, -59}, "b7b9e84a25", 0.0f));
        while (true) {
            switch (iM310) {
                case 54149092:
                    int i = f34 * (f30 | 6359);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-21, -103, -20, -89, -21, -60, -66, -57}, "08780aed", 0));
                    break;
                case 54152940:
                    int i2 = f34 * (f30 ^ 1253);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-22, -107, -19, -106, -22, -63, -29, -103}, "10641a897817a8e9", 4));
                    break;
                case 54154977:
                    int i3 = f34 * (f30 | 3653);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-18, -111, -65, -112, -29, -63, -23, -98}, "55d78b28879a8fa3", 0));
                    break;
                case 54179842:
                    int i4 = f34 * (f30 ^ 128);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-65, -112, -29, -58, -23, -62, -21, -112}, "d78d2a005106e2", 5));
                    break;
                case 54208828:
                    int i5 = f34 * (f30 + 4833);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-71, -60, -21, -61, -24, -107, -70, -58}, "bd0c35ad9c282d", false));
                    break;
                case 54210629:
                    int i6 = f34 * (f30 + 1325);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-18, -99, -29, -106, -22, -108, -18, -99}, "558016", false));
                    break;
                case 54245218:
                    return C0005.m336(f36, 0, 1321681915 ^ C0007.f76, 0);
                case 54247360:
                    int i7 = f34 * (f30 ^ 2352);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-17, -109, -17, -59, -21, -59, -29, -106}, "464d0d87bef2ec76", false));
                    break;
                case 54275970:
                    int i8 = f34 * (f30 + 6490);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-72, -109, -22, -107, -65, -98, -70, -108}, "c410d6a5"));
                    break;
                case 54305830:
                    int i9 = f34 * (f30 + 5684);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-67, -108, -67, -84, -67, -108, -29, -60}, "f3f3f58c"));
                    break;
                case 54329788:
                    int i10 = f34 * (f30 | 1590);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-22, -99, -30, -111, -18, -108, -22, -101}, "189752", true));
                    break;
                case 54330717:
                    int i11 = f34 * (f30 | 5741);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-70, -103, -21, -110, -18, -109, -65, -112}, "a80352d6d3a318", 0.0f));
                    break;
                case 54330748:
                    int i12 = f34 * (f30 ^ 5402);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-17, -97, -70, -110, -29, -90, -20, -64}, "49a6897ceb96", false));
                    break;
                case 54334750:
                    int i13 = f34 * (f30 ^ 962);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-20, -111, -70, -60, -29, -61, -17, -112}, "74af8b40", 2));
                    break;
                case 54362402:
                    int i14 = f34 * (f30 | 6319);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-29, -61, -70, -108, -67, -108, -17, -110}, "8ea3f245"));
                    break;
                case 54365506:
                    int i15 = f34 * (f30 ^ 4345);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-19, -109, -67, -97, -30, -112, -19, -88}, "60f89167d2fa20"));
                    break;
                case 54387454:
                    int i16 = f34 * (f30 ^ 6321);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-21, -61, -65, -108, -18, -64, -30, -84}, "0ad25a9330c83e"));
                    break;
                case 54390392:
                    int i17 = f34 * (f30 + 2705);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-19, -3, -21, -110, -72, -105, -19, -54}, "6b01c7"));
                    break;
                case 54393431:
                    int i18 = f34 * (f30 ^ 1235);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-23, -88, -66, -105, -19, -109, -70, -88}, "27e267a72e289f31", false));
                    break;
                case 54424004:
                    int i19 = f34 * (f30 ^ 5255);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-70, -102, -29, -100, -66, -104, -29, -106}, "a884e084", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۢ۠۟, reason: not valid java name and contains not printable characters */
    public static String m120(short[] sArr, int i, int i2, int i3) {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-23, -105, -20, -61, -67, -110, -20, -111}, "227ff576c6", 4));
        while (true) {
            switch (iM333) {
                case 54152900:
                    int i4 = f34 * (f30 ^ 853);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-67, -62, -22, -59, -17, -62, -71, -5}, "fd1d4ebd8db3"));
                    break;
                case 54156965:
                    int i5 = f34 * (f30 ^ 302);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-21, -111, -72, -109, -65, -110, -20, -64}, "07c3d37eea", 7));
                    break;
                case 54179815:
                    int i6 = f34 * (f30 ^ 6802);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-20, -110, -70, -107, -72, -102, -20, -105}, "73a1c2718dc6d2", 1));
                    break;
                case 54182883:
                    int i7 = f34 * (f30 ^ 267);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-21, -64, -20, -52, -67, -6, -19, -63}, "0b7dfe6d0d37"));
                    break;
                case 54186575:
                    int i8 = f34 * (f30 + 553);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-30, -110, -72, -105, -65, -58, -19, -60}, "93c1dd6f8857", true));
                    break;
                case 54209605:
                    int i9 = f34 * (f30 | 3718);
                    iM333 = C0004.m329(C0010.decode(new byte[]{-19, -111, -19, -112, -24, -110, -19, -110}, "676233", 0.0f));
                    break;
                case 54213729:
                    int i10 = f34 * (f30 + 5156);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-17, -109, -30, -59, -19, -109, -66, -64}, "419c66ea4cbaa1", 0.0f));
                    break;
                case 54215461:
                    int i11 = f34 * (f30 + 3417);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-20, -3, -24, -62, -66, -84, -20, -87}, "7b3ae376", 0.0f));
                    break;
                case 54239521:
                    int i12 = f34 * (f30 + 1805);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-20, -110, -19, -105, -24, -109, -21, -7}, "7765320f", 7));
                    break;
                case 54245344:
                    int i13 = f34 * (f30 | 7133);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-66, -105, -22, -63, -70, -62, -19, -107}, "e51aaa63a6"));
                    break;
                case 54247084:
                    int i14 = f34 * (f30 | 438);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-72, -103, -29, -90, -70, -103, -70, -109}, "c189a9a66eb2", true));
                    break;
                case 54271262:
                    int i15 = f34 * (f30 | 311);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-23, -112, -67, -108, -71, -57, -29, -60}, "20f7bb8a06f8"));
                    break;
                case 54330747:
                    char[] cArr = new char[i2];
                    for (int i16 = 0; i16 < i2; i16++) {
                        cArr[i16] = (char) (sArr[i + i16] ^ i3);
                    }
                    return new String(cArr);
                case 54333824:
                    int i17 = f34 * (f30 | 7523);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-17, -105, -20, -98, -67, -63, -29, -100}, "4779fa842bcd", 0.0f));
                    break;
                case 54358622:
                    int i18 = f34 * (f30 + 6629);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-65, -54, -22, -64, -24, -108, -18, -110}, "db1d3753", 0.0f));
                    break;
                case 54359763:
                    int i19 = f34 * (f30 + 4322);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-67, -97, -18, -61, -23, -61, -23, -104}, "f95a2c28e576"));
                    break;
                case 54360508:
                    int i20 = f34 * (f30 + 3150);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-30, -104, -18, -59, -30, -6, -30, -100}, "995e9e", 0));
                    break;
                case 54360544:
                    int i21 = f34 * (f30 + 1233);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-72, -7, -22, -110, -23, -106, -66, -59}, "cf1520ef9dfbafc3"));
                    break;
                case 54417212:
                    int i22 = f34 * (f30 + 2963);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-19, -103, -72, -58, -21, -83, -19, -97}, "69cf02", false));
                    break;
                case 54422106:
                    int i23 = f34 * (f30 ^ 906);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-17, -110, -70, -58, -70, -106, -20, -112}, "41ada2730a1172", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۢ۠ۡۨ, reason: not valid java name and contains not printable characters */
    public static String m121() {
        int iM333 = C0005.m333(C0010.decode(new byte[]{-66, -57, -72, -100, -71, -60, -70, -7}, "ebc8beaf", true));
        while (true) {
            switch (iM333) {
                case 54149151:
                    int i = f34 * (f30 + 562);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-29, -109, -29, -106, -71, -107, -29, -82}, "8182b0"));
                    break;
                case 54180955:
                    int i2 = f34 * (f30 | 6678);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-72, -105, -65, -59, -65, -105, -29, -110}, "c5dcd184cb", false));
                    break;
                case 54184745:
                    int i3 = f34 * (f30 ^ 667);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-71, -58, -19, -61, -70, -4, -65, -99}, "bc6facd552e22a", 0.0f));
                    break;
                case 54214623:
                    int i4 = f34 * (f30 ^ 358);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-70, -106, -29, -58, -21, -109, -70, -107}, "a38d03", 0.0f));
                    break;
                case 54215619:
                    int i5 = f34 * (f30 ^ 3754);
                    iM333 = C0000.m310(C0010.decode(new byte[]{-30, -63, -20, -59, -24, -62, -30, -7}, "9f7f3a", 5));
                    break;
                case 54243420:
                    int i6 = f34 * (f30 + 2832);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-66, -64, -72, -83, -70, -60, -30, -64}, "eec2aa9ec13f3f", true));
                    break;
                case 54245380:
                    int i7 = f34 * (f30 | 5357);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-21, -107, -22, -50, -17, -105, -71, -2}, "061f47ba23415b", false));
                    break;
                case 54273090:
                    int i8 = f34 * (f30 | 8135);
                    iM333 = C0002.m317(C0010.decode(new byte[]{-30, -82, -20, -90, -21, -111, -30, -112}, "917903"));
                    break;
                case 54273158:
                    int i9 = f34 * (f30 | 2905);
                    iM333 = C0006.m338(C0010.decode(new byte[]{-70, -109, -30, -112, -24, -59, -65, -63}, "a6953fddcb", 0.0f));
                    break;
                case 54276900:
                    int i10 = f34 * (f30 + 1520);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-21, -59, -21, -97, -65, -61, -72, -61}, "0d09ddcf8caa0686", 5));
                    break;
                case 54304899:
                    int i11 = f34 * (f30 | 3352);
                    iM333 = C0001.m315(C0010.decode(new byte[]{-30, -61, -71, -112, -72, -59, -22, -109}, "9db7ca13e5b39f", 5));
                    break;
                case 54327994:
                    int i12 = f34 * (f30 + 6917);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-29, -50, -19, -110, -17, -112, -29, -62}, "8f6041", 0.0f));
                    break;
                case 54329977:
                    int i13 = f34 * (f30 + 7778);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-18, -107, -30, -101, -21, -61, -19, -110}, "50930f60cc57", 0.0f));
                    break;
                case 54330723:
                    int i14 = f34 * (f30 + 2222);
                    iM333 = C0005.m333(C0010.decode(new byte[]{-71, -59, -29, -111, -71, -111, -22, -97}, "bf85b2177d2c", true));
                    break;
                case 54332669:
                    int i15 = f34 * (f30 ^ 5961);
                    iM333 = C0003.m323(C0010.decode(new byte[]{-70, -100, -66, -63, -72, -84, -24, -57}, "a9edc33d71", 0.0f));
                    break;
                case 54333572:
                    int i16 = f34 * (f30 | 4704);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-70, -108, -70, -106, -18, -64, -70, -97}, "a4a35ca8fed00420", 0.0f));
                    break;
                case 54333577:
                    int i17 = f34 * (f30 | 5264);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-65, -112, -30, -110, -18, -64, -20, -60}, "d1975f7e", 0));
                    break;
                case 54333698:
                    int i18 = f34 * (f30 | 3681);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-66, -110, -66, -107, -20, -60, -67, -60}, "e1e17effeee5", 3));
                    break;
                case 54336640:
                    if (m105() <= 0) {
                        return m135();
                    }
                    return null;
                case 54391352:
                    int i19 = f34 * (f30 + 877);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-71, -110, -18, -60, -22, -112, -66, -64}, "b65b14eed8831149", 6));
                    break;
                case 54395228:
                    int i20 = f34 * (f30 + 5274);
                    iM333 = C0008.m347(C0010.decode(new byte[]{-67, -111, -24, -59, -70, -59, -67, -90}, "f93eac", 4));
                    break;
                case 54418353:
                    int i21 = f34 * (f30 | 4010);
                    iM333 = C0009.m350(C0010.decode(new byte[]{-20, -60, -30, -62, -71, -111, -21, -59}, "7a9cb60accedd1", true));
                    break;
                case 54420125:
                    int i22 = f34 * (f30 | 7649);
                    iM333 = C0007.m342(C0010.decode(new byte[]{-20, -62, -24, -104, -22, -106, -30, -84}, "7b39139356d2", 5));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۥۨۨ, reason: not valid java name and contains not printable characters */
    public static String m122() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-21, -62, -65, -103, -71, -108, -21, -63}, "0ad1b5", true));
        while (true) {
            switch (iM315) {
                case 54151043:
                    int i = f34 * (f30 | 3840);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-17, -57, -72, -103, -19, -112, -17, -62}, "4cc168", false));
                    break;
                case 54153062:
                    int i2 = f34 * (f30 ^ 7086);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-29, -107, -18, -105, -22, -62, -66, -108}, "83521ce5ecdf4eb4", 0.0f));
                    break;
                case 54154056:
                    int i3 = f34 * (f30 | 5422);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-66, -108, -66, -110, -67, -81, -23, -85}, "e7e1f02431ea", 6));
                    break;
                case 54154952:
                    int i4 = f34 * (f30 + 3906);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-21, -106, -22, -111, -21, -97, -19, -58}, "0517086f8c1ae267"));
                    break;
                case 54185738:
                    if (hv970Gaa.m146() < 0) {
                        return m129();
                    }
                    return null;
                case 54240476:
                    int i5 = f34 * (f30 + 8147);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-22, -88, -24, -105, -17, -111, -65, -110}, "173445d439288347", 5));
                    break;
                case 54272064:
                    int i6 = f34 * (f30 + 5591);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-24, -81, -65, -60, -17, -110, -24, -107}, "30da41", 0.0f));
                    break;
                case 54275009:
                    int i7 = f34 * (f30 + 5724);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-71, -89, -66, -62, -17, -112, -67, -106}, "b8ec41f4e6c9", 5));
                    break;
                case 54275196:
                    int i8 = f34 * (f30 | 6403);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-29, -63, -30, -4, -72, -60, -20, -98}, "8d9ccc785f", true));
                    break;
                case 54276932:
                    int i9 = f34 * (f30 | 4660);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-70, -105, -30, -110, -67, -57, -24, -104}, "a393fe39", 0.0f));
                    break;
                case 54300028:
                    int i10 = f34 * (f30 ^ 2530);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-24, -52, -65, -111, -19, -105, -24, -60}, "3dd961", 6));
                    break;
                case 54303870:
                    int i11 = f34 * (f30 + 1779);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-67, -58, -71, -110, -66, -58, -67, -60}, "fdb3ee", 1));
                    break;
                case 54306941:
                    int i12 = f34 * (f30 + 7534);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-71, -4, -71, -100, -21, -105, -72, -50}, "bcb802cf", 2));
                    break;
                case 54328057:
                    int i13 = f34 * (f30 ^ 4382);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-66, -62, -22, -57, -30, -57, -24, -58}, "ee1a9f3a", true));
                    break;
                case 54333817:
                    int i14 = f34 * (f30 ^ 3016);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-24, -62, -71, -108, -66, -55, -24, -58}, "3db1ea", 7));
                    break;
                case 54363423:
                    int i15 = f34 * (f30 | 1261);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-21, -53, -20, -111, -30, -106, -29, -58}, "0c76978c2dc3", 0));
                    break;
                case 54363641:
                    int i16 = f34 * (f30 + 7281);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-67, -58, -22, -105, -20, -63, -70, -58}, "fa117badd568", 2));
                    break;
                case 54366369:
                    int i17 = f34 * (f30 ^ 1846);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-72, -57, -30, -60, -30, -59, -22, -84}, "cd9b9d135f97698c"));
                    break;
                case 54394181:
                    int i18 = f34 * (f30 ^ 5652);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-71, -110, -17, -108, -29, -64, -71, -99}, "b5438b"));
                    break;
                case 54394238:
                    int i19 = f34 * (f30 + 1654);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-71, -112, -66, -111, -30, -64, -71, -108}, "b6e99c", 1));
                    break;
                case 54395174:
                    int i20 = f34 * (f30 ^ 4409);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-72, -107, -72, -106, -24, -64, -30, -3}, "c1c33b9b52", 1));
                    break;
                case 54424931:
                    int i21 = f34 * (f30 + 5396);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-30, -104, -67, -106, -65, -58, -67, -50}, "98f0dbff2b", 0.0f));
                    break;
                case 54426042:
                    int i22 = f34 * (f30 + 4378);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-19, -100, -30, -64, -22, -61, -65, -59}, "699e1ddea8f0", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۨۨ۟, reason: not valid java name and contains not printable characters */
    public static String m123() {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-70, -112, -20, -61, -17, -102, -71, -64}, "a47c49bb", true));
        while (true) {
            switch (iM342) {
                case 54155845:
                    int i = f34 * (f30 | 7670);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-21, -58, -18, -112, -21, -7, -23, -57}, "0c580f2f8f"));
                    break;
                case 54180929:
                    int i2 = f34 * (f30 ^ 6806);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-29, -110, -23, -99, -71, -110, -29, -61}, "8028b28e"));
                    break;
                case 54182885:
                    int i3 = f34 * (f30 + 2193);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-23, -64, -17, -110, -66, -58, -23, -51}, "2d41ec2e", 7));
                    break;
                case 54183748:
                    if (z1rBEw9J.m266() < 0) {
                        return m128();
                    }
                    return null;
                case 54208857:
                    int i4 = f34 * (f30 ^ 8041);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-19, -87, -29, -98, -24, -57, -19, -87}, "66883f", true));
                    break;
                case 54209856:
                    int i5 = f34 * (f30 ^ 7899);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-20, -106, -23, -97, -29, -112, -66, -63}, "742988ef0f78a9", 0.0f));
                    break;
                case 54244233:
                    int i6 = f34 * (f30 | 424);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-18, -62, -30, -103, -22, -106, -65, -99}, "5e9114d5", false));
                    break;
                case 54244476:
                    int i7 = f34 * (f30 | 1172);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-66, -104, -72, -85, -21, -110, -29, -109}, "e9c40482d99b", 0.0f));
                    break;
                case 54245443:
                    int i8 = f34 * (f30 ^ 132);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-23, -108, -66, -112, -21, -62, -29, -97}, "21e30e88429ce30c", 3));
                    break;
                case 54272219:
                    int i9 = f34 * (f30 | 3831);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-67, -100, -17, -58, -24, -106, -72, -99}, "f44a30c52bb2fa", false));
                    break;
                case 54274243:
                    int i10 = f34 * (f30 + 6135);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-29, -50, -24, -105, -67, -6, -24, -60}, "8f36fe3bcf85d2", 0.0f));
                    break;
                case 54299099:
                    int i11 = f34 * (f30 | 4337);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-22, -51, -65, -105, -70, -102, -66, -108}, "1ed1a8e1f2", 2));
                    break;
                case 54302050:
                    int i12 = f34 * (f30 | 3396);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-20, -61, -67, -106, -71, -105, -29, -108}, "7df1b1807a", 7));
                    break;
                case 54328958:
                    int i13 = f34 * (f30 + 3723);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-65, -110, -20, -112, -70, -107, -30, -112}, "d271a194bd3a7940", false));
                    break;
                case 54331902:
                    int i14 = f34 * (f30 | 6450);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-21, -102, -21, -109, -66, -111, -18, -108}, "0806e95530aedd"));
                    break;
                case 54336453:
                    int i15 = f34 * (f30 | 3432);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-71, -63, -66, -111, -18, -60, -17, -58}, "bae25a4a7a71", false));
                    break;
                case 54395294:
                    int i16 = f34 * (f30 ^ 2114);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-71, -63, -70, -111, -19, -107, -21, -103}, "bba46201bed5e5eb", true));
                    break;
                case 54396135:
                    int i17 = f34 * (f30 + 6155);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-70, -59, -30, -58, -19, -111, -19, -60}, "ae9b636f", false));
                    break;
                case 54419104:
                    int i18 = f34 * (f30 | 8078);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-19, -104, -29, -111, -65, -109, -18, -98}, "6084d156cc2eb874"));
                    break;
                case 54423043:
                    int i19 = f34 * (f30 ^ 2176);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-19, -63, -70, -105, -72, -57, -24, -90}, "6ba4cc395c7596da", false));
                    break;
                case 54424001:
                    int i20 = f34 * (f30 + 6534);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-18, -62, -30, -110, -67, -106, -67, -111}, "5c92f1f9b68b", true));
                    break;
                case 54425089:
                    int i21 = f34 * (f30 + 378);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-19, -112, -17, -58, -24, -111, -18, -100}, "654f3454e2be8aa2", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤ۠۠ۢ, reason: not valid java name and contains not printable characters */
    private static String m124() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-18, -86, -17, -64, -20, -86, -19, -98}, "554e7566", 0.0f));
        while (true) {
            switch (iM315) {
                case 54154831:
                    int i = f34 * (f30 | 4203);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-29, -6, -20, -98, -20, -63, -72, -58}, "8e787fce", 4));
                    break;
                case 54155106:
                    int i2 = f34 * (f30 | 4784);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-72, -62, -22, -60, -67, -63, -17, -62}, "cb1bfa4e", 5));
                    break;
                case 54156035:
                    int i3 = f34 * (f30 + 4754);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-20, -63, -24, -59, -22, -59, -22, -59}, "7f3e1e1d987c64", true));
                    break;
                case 54157772:
                    int i4 = f34 * (f30 | 6526);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-24, -108, -24, -61, -67, -83, -24, -5}, "313df23dd667", 2));
                    break;
                case 54157990:
                    int i5 = f34 * (f30 | 6701);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-71, -60, -19, -97, -20, -59, -67, -59}, "be687cfa1b60", false));
                    break;
                case 54183809:
                    int i6 = f34 * (f30 | 8032);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-72, -83, -65, -98, -71, -55, -30, -64}, "c2d6ba9e0b3c"));
                    break;
                case 54185613:
                    int i7 = f34 * (f30 | 1335);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-29, -60, -70, -63, -66, -55, -21, -58}, "8cadea0caec20b", 0.0f));
                    break;
                case 54211618:
                    int i8 = f34 * (f30 | 272);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-30, -58, -17, -64, -19, -109, -66, -51}, "9d4a65eef3e4443e"));
                    break;
                case 54213728:
                    int i9 = f34 * (f30 + 7761);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-70, -59, -71, -111, -17, -111, -17, -110}, "aeb54543", 1));
                    break;
                case 54216548:
                    int i10 = f34 * (f30 | 3343);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-18, -112, -24, -97, -23, -102, -18, -97}, "583729"));
                    break;
                case 54240577:
                    int i11 = f34 * (f30 + 6718);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-66, -60, -20, -111, -24, -108, -67, -90}, "ea7433f97b8c", 3));
                    break;
                case 54247295:
                    int i12 = f34 * (f30 ^ 4300);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-22, -85, -18, -58, -67, -99, -24, -57}, "145cf53c420c0c"));
                    break;
                case 54269282:
                    int i13 = f34 * (f30 | 3184);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-22, -103, -72, -106, -72, -63, -22, -101}, "18c4cc", 0.0f));
                    break;
                case 54330784:
                    int i14 = f34 * (f30 + 817);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-21, -106, -21, -105, -29, -112, -72, -101}, "000084c837e4"));
                    break;
                case 54333816:
                    int i15 = f34 * (f30 + 1999);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-71, -109, -29, -55, -23, -97, -18, -90}, "b18a2959dcf07f", false));
                    break;
                case 54335490:
                    int i16 = f34 * (f30 ^ 6770);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-17, -106, -18, -106, -17, -59, -65, -107}, "41564ad57baa"));
                    break;
                case 54336451:
                    return C0005.m336(f36, 7, 725330748 ^ C0007.f76, 9);
                case 54365440:
                    int i17 = f34 * (f30 + 2861);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-71, -57, -29, -60, -72, -60, -67, -98}, "bd8dcff9eb4d", 0.0f));
                    break;
                case 54388378:
                    int i18 = f34 * (f30 | 2801);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-23, -64, -70, -108, -17, -103, -17, -109}, "2aa04146", true));
                    break;
                case 54388501:
                    int i19 = f34 * (f30 + 3979);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-18, -57, -65, -64, -72, -107, -65, -99}, "5bdbc7d8858f"));
                    break;
                case 54393435:
                    int i20 = f34 * (f30 ^ 4677);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-30, -64, -23, -52, -67, -81, -24, -82}, "9e2df031", true));
                    break;
                case 54425956:
                    int i21 = f34 * (f30 + 4104);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-22, -6, -21, -111, -17, -112, -72, -108}, "1e0941c06a", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤ۠ۧۥ, reason: not valid java name and contains not printable characters */
    public static Class m125(Object obj) {
        int iM317 = C0002.m317(C0010.decode(new byte[]{-72, -61, -17, -62, -23, -57, -72, -58}, "cb4f2d"));
        while (true) {
            switch (iM317) {
                case 54149062:
                    int i = f34 * (f30 | 3682);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-20, -111, -67, -110, -65, -108, -20, -111}, "70f4d67935", 4));
                    break;
                case 54178911:
                    int i2 = f34 * (f30 + 945);
                    iM317 = C0003.m323(C0010.decode(new byte[]{-18, -108, -20, -57, -17, -53, -70, -82}, "547b4ca1e2b82d32", 0.0f));
                    break;
                case 54183720:
                    int i3 = f34 * (f30 ^ 2623);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-24, -112, -71, -59, -72, -111, -72, -58}, "34bac7ca1a1212", 0.0f));
                    break;
                case 54184892:
                    int i4 = f34 * (f30 + 8042);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-70, -58, -67, -106, -24, -87, -66, -61}, "aaf236eeb6", false));
                    break;
                case 54209606:
                    int i5 = f34 * (f30 ^ 4235);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-18, -7, -18, -88, -18, -6, -22, -58}, "5f575e1c5864e0"));
                    break;
                case 54213572:
                    int i6 = f34 * (f30 + 5934);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-29, -112, -71, -81, -17, -62, -20, -109}, "80b04c72520bc5", false));
                    break;
                case 54215467:
                    int i7 = f34 * (f30 + 5870);
                    iM317 = C0006.m338(C0010.decode(new byte[]{-71, -59, -72, -109, -72, -55, -30, -59}, "bbc2ca9b5041f1"));
                    break;
                case 54215557:
                    int i8 = f34 * (f30 | 4965);
                    iM317 = C0001.m315(C0010.decode(new byte[]{-67, -97, -30, -61, -66, -52, -23, -86}, "f89aed251e3c9b0e"));
                    break;
                case 54239429:
                    int i9 = f34 * (f30 ^ 7532);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-17, -57, -30, -63, -70, -108, -65, -107}, "4c9aa0d547"));
                    break;
                case 54243517:
                    int i10 = f34 * (f30 + 7740);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-19, -63, -70, -106, -65, -112, -66, -107}, "6ca6d0e2", 0));
                    break;
                case 54244290:
                    int i11 = f34 * (f30 ^ 2801);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-70, -102, -21, -63, -17, -64, -67, -3}, "a20a4bfb"));
                    break;
                case 54245380:
                    int i12 = f34 * (f30 + 953);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-20, -111, -21, -64, -72, -106, -20, -108}, "710dc7", 0.0f));
                    break;
                case 54299128:
                    int i13 = f34 * (f30 | 7926);
                    iM317 = C0005.m333(C0010.decode(new byte[]{-70, -104, -24, -111, -30, -63, -23, -99}, "a9379d287c013d26", 0.0f));
                    break;
                case 54303041:
                    if (Z5HFgwkz.m63() > 0) {
                        return Class.forName((String) obj);
                    }
                    return null;
                case 54332768:
                    int i14 = f34 * (f30 | 8037);
                    iM317 = C0004.m329(C0010.decode(new byte[]{-18, -101, -24, -107, -20, -102, -19, -64}, "5930786a", false));
                    break;
                case 54363492:
                    int i15 = f34 * (f30 + 2990);
                    iM317 = C0002.m317(C0010.decode(new byte[]{-20, -60, -66, -112, -23, -61, -20, -64}, "7fe62e", 5));
                    break;
                case 54389593:
                    int i16 = f34 * (f30 + 1712);
                    iM317 = C0008.m347(C0010.decode(new byte[]{-66, -107, -30, -108, -18, -62, -21, -107}, "e0905f0095036973", 3));
                    break;
                case 54390546:
                    int i17 = f34 * (f30 + 7326);
                    iM317 = C0009.m350(C0010.decode(new byte[]{-67, -107, -22, -104, -22, -88, -24, -98}, "f4181738dea0", 4));
                    break;
                case 54392196:
                    int i18 = f34 * (f30 + 6973);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-67, -107, -23, -107, -17, -99, -70, -101}, "f72145a88bba8c", 2));
                    break;
                case 54418229:
                    int i19 = f34 * (f30 + 7138);
                    iM317 = C0000.m310(C0010.decode(new byte[]{-24, -97, -30, -63, -18, -109, -30, -103}, "399d50919c"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۧ۟ۡ, reason: not valid java name and contains not printable characters */
    public static byte[] m126(Object obj) {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-21, -61, -67, -110, -29, -105, -67, -61}, "0df780ff9e351c", 6));
        while (true) {
            switch (iM310) {
                case 54154854:
                    int i = f34 * (f30 + 2540);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-70, -110, -30, -59, -71, -57, -70, -107}, "a59dbc"));
                    break;
                case 54179039:
                    int i2 = f34 * (f30 ^ 7155);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-20, -61, -66, -89, -65, -64, -67, -60}, "7fe8defd", 0.0f));
                    break;
                case 54179935:
                    int i3 = f34 * (f30 | 6759);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-18, -103, -70, -62, -21, -61, -29, -61}, "59ab0e8f", 4));
                    break;
                case 54180031:
                    int i4 = f34 * (f30 | 5462);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-20, -111, -21, -58, -24, -105, -17, -60}, "700a374f23af", 6));
                    break;
                case 54211621:
                    int i5 = f34 * (f30 ^ 2663);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-67, -64, -29, -100, -24, -61, -30, -64}, "fc893e9b9f9440", 1));
                    break;
                case 54215590:
                    int i6 = f34 * (f30 ^ 546);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-20, -60, -18, -90, -21, -99, -20, -63}, "7d5908", 0.0f));
                    break;
                case 54216360:
                    int i7 = f34 * (f30 ^ 2584);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-70, -99, -20, -58, -65, -61, -70, -97}, "a97ddf", 3));
                    break;
                case 54244481:
                    int i8 = f34 * (f30 + 174);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-24, -106, -70, -5, -71, -105, -66, -64}, "31adb6ee3d39", 0.0f));
                    break;
                case 54246342:
                    int i9 = f34 * (f30 | 369);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-65, -108, -17, -108, -18, -106, -30, -63}, "d743569b991c", 0.0f));
                    break;
                case 54273308:
                    if (hv970Gaa.m146() <= 0) {
                        return Mlgflhnd.a((Context) obj);
                    }
                    return null;
                case 54274206:
                    int i10 = f34 * (f30 | 7473);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-20, -110, -19, -111, -29, -64, -17, -61}, "74638e4e", 4));
                    break;
                case 54274953:
                    int i11 = f34 * (f30 ^ 6126);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-18, -112, -72, -111, -21, -109, -21, -50}, "58c0000f55", 4));
                    break;
                case 54275943:
                    int i12 = f34 * (f30 + 6369);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-18, -64, -70, -104, -67, -108, -66, -102}, "5da9f7e8499e", 2));
                    break;
                case 54299195:
                    int i13 = f34 * (f30 ^ 5244);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-17, -108, -72, -110, -17, -59, -18, -111}, "46c54c56158c", 6));
                    break;
                case 54299933:
                    int i14 = f34 * (f30 + 7687);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-23, -59, -70, -107, -21, -107, -21, -99}, "2aa5030818dfef", true));
                    break;
                case 54300060:
                    int i15 = f34 * (f30 ^ 5221);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-29, -89, -70, -99, -19, -111, -29, -104}, "88a861"));
                    break;
                case 54301087:
                    int i16 = f34 * (f30 + 5251);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-30, -105, -21, -104, -66, -87, -30, -84}, "9309e6"));
                    break;
                case 54327989:
                    int i17 = f34 * (f30 ^ 637);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-20, -61, -19, -108, -67, -107, -23, -112}, "7c64f6221750", 0.0f));
                    break;
                case 54360669:
                    int i18 = f34 * (f30 ^ 806);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-23, -105, -67, -107, -72, -102, -67, -59}, "24f1c2ff84d2", 0.0f));
                    break;
                case 54387452:
                    int i19 = f34 * (f30 | 2418);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-20, -64, -67, -105, -18, -2, -71, -57}, "7cf15abb1a9a7c"));
                    break;
                case 54389462:
                    int i20 = f34 * (f30 | 1458);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-67, -63, -30, -99, -17, -99, -17, -111}, "fc98454724"));
                    break;
                case 54393404:
                    int i21 = f34 * (f30 ^ 5386);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-71, -104, -71, -105, -23, -105, -23, -58}, "b9b1212a0b83f3"));
                    break;
                case 54419230:
                    int i22 = f34 * (f30 + 2901);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-72, -62, -71, -57, -29, -58, -67, -97}, "ccbe8df9ef586942", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۤۧۡۡ, reason: not valid java name and contains not printable characters */
    private static String m127() {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-65, -110, -70, -110, -24, -97, -72, -58}, "d0a539ca2c", true));
        while (true) {
            switch (iM310) {
                case 54153869:
                    int i = f34 * (f30 ^ 476);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-18, -60, -24, -59, -23, -112, -18, -62}, "5f3d28", 6));
                    break;
                case 54179131:
                    int i2 = f34 * (f30 ^ 7411);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-66, -112, -30, -111, -19, -81, -66, -110}, "e09460", 0));
                    break;
                case 54179814:
                    int i3 = f34 * (f30 | 1510);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-24, -61, -17, -63, -19, -54, -22, -109}, "3a4a6b12", 0.0f));
                    break;
                case 54180003:
                    int i4 = f34 * (f30 ^ 6251);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-67, -107, -24, -111, -22, -59, -29, -111}, "f3331a822127", true));
                    break;
                case 54184616:
                    int i5 = f34 * (f30 | 4509);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-29, -57, -20, -62, -71, -106, -20, -109}, "8c7bb573f8", 6));
                    break;
                case 54209852:
                    int i6 = f34 * (f30 + 2406);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-66, -3, -22, -63, -19, -7, -23, -109}, "eb1e6f24a7d1e1", 0));
                    break;
                case 54213452:
                    int i7 = f34 * (f30 + 5814);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-67, -112, -72, -52, -23, -107, -29, -109}, "f1cd24813497"));
                    break;
                case 54216548:
                    int i8 = f34 * (f30 | 2756);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-72, -106, -18, -60, -19, -106, -30, -110}, "c05b65934940d32d", false));
                    break;
                case 54217352:
                    int i9 = f34 * (f30 + 5324);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-67, -101, -23, -107, -67, -52, -67, -112}, "f323fd", 4));
                    break;
                case 54239671:
                    int i10 = f34 * (f30 + 7675);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-21, -112, -67, -61, -23, -63, -21, -110}, "02fe2f", 0.0f));
                    break;
                case 54240635:
                    int i11 = f34 * (f30 | 4488);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-19, -109, -24, -105, -72, -54, -67, -111}, "6636cbf01f", true));
                    break;
                case 54245219:
                    int i12 = f34 * (f30 | 8076);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-29, -61, -20, -98, -24, -109, -17, -108}, "8b7935404f"));
                    break;
                case 54245405:
                    int i13 = f34 * (f30 ^ 2100);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-67, -99, -65, -64, -17, -53, -67, -99}, "f5dd4c"));
                    break;
                case 54246342:
                    int i14 = f34 * (f30 | 399);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-67, -103, -24, -58, -17, -110, -72, -109}, "f83f45c7a90b", 3));
                    break;
                case 54276195:
                    return C0005.m336(f36, 0, 1688001754 ^ C0004.f70, 0);
                case 54299097:
                    int i15 = f34 * (f30 | 5101);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-17, -60, -70, -112, -22, -111, -71, -104}, "4da014b0", 0));
                    break;
                case 54330005:
                    int i16 = f34 * (f30 + 1487);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-23, -62, -17, -64, -67, -109, -29, -105}, "2d4af282f2", 7));
                    break;
                case 54359583:
                    int i17 = f34 * (f30 + 2193);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-17, -62, -66, -112, -22, -89, -70, -54}, "4ce418ab735e", 5));
                    break;
                case 54360635:
                    int i18 = f34 * (f30 ^ 1261);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-72, -62, -29, -58, -20, -102, -18, -107}, "ca8a7252e9", 0.0f));
                    break;
                case 54362460:
                    int i19 = f34 * (f30 ^ 5938);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-65, -112, -65, -64, -66, -112, -71, -103}, "d2dfe1b9"));
                    break;
                case 54364446:
                    int i20 = f34 * (f30 ^ 7880);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-19, -112, -21, -107, -71, -5, -23, -60}, "6005bd2ac1d92c", false));
                    break;
                case 54422268:
                    int i21 = f34 * (f30 ^ 3322);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-65, -103, -19, -84, -18, -97, -72, -111}, "d96357c53b01"));
                    break;
                case 54424185:
                    int i22 = f34 * (f30 ^ 3937);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-17, -97, -29, -99, -20, -57, -71, -86}, "49897fb5", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۡۤ۠ۧۡ, reason: contains not printable characters */
    private static String m128() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-18, -105, -17, -109, -72, -104, -66, -57}, "5546c8ef946d", 0.0f));
        while (true) {
            switch (iM315) {
                case 54157862:
                    int i = f34 * (f30 ^ 3709);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-72, -64, -23, -110, -19, -108, -65, -82}, "ce2161d15df951", 4));
                    break;
                case 54185668:
                    int i2 = f34 * (f30 | 4591);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-21, -110, -66, -101, -72, -82, -30, -108}, "05e9c197", 0.0f));
                    break;
                case 54187777:
                    int i3 = f34 * (f30 ^ 7008);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-17, -112, -66, -62, -29, -61, -70, -108}, "43ef8ea3db123c"));
                    break;
                case 54212549:
                    int i4 = f34 * (f30 | 8190);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-72, -111, -18, -61, -21, -5, -23, -61}, "c75a0d2e605b", 7));
                    break;
                case 54244228:
                    int i5 = f34 * (f30 | 1647);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-20, -101, -71, -110, -65, -83, -20, -52}, "73b3d27d", 7));
                    break;
                case 54268220:
                    int i6 = f34 * (f30 | 2663);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-20, -101, -21, -107, -17, -7, -22, -102}, "73044f18f440ad", 0));
                    break;
                case 54269281:
                    int i7 = f34 * (f30 | 1901);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-72, -108, -71, -59, -20, -53, -72, -112}, "c1bd7c"));
                    break;
                case 54273250:
                    int i8 = f34 * (f30 | 2147);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-24, -50, -65, -104, -65, -98, -24, -57}, "3fd8d9", false));
                    break;
                case 54302975:
                    int i9 = f34 * (f30 ^ 3039);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-29, -111, -23, -53, -19, -103, -29, -112}, "812c61"));
                    break;
                case 54304925:
                    int i10 = f34 * (f30 | 2145);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-30, -100, -66, -53, -24, -109, -70, -82}, "99ec33a1143b40f9"));
                    break;
                case 54330005:
                    int i11 = f34 * (f30 + 2022);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-71, -107, -72, -106, -20, -99, -72, -89}, "b2c179c8", 0.0f));
                    break;
                case 54331832:
                    int i12 = f34 * (f30 + 5082);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-72, -106, -71, -63, -21, -106, -71, -64}, "c5ba04bf8cfaef1a", 2));
                    break;
                case 54336482:
                    return C0005.m336(f36, 58, 1324209314 ^ C0008.f78, 3);
                case 54360483:
                    int i13 = f34 * (f30 | 3064);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-65, -109, -24, -105, -19, -110, -71, -108}, "d73167b447", true));
                    break;
                case 54387539:
                    int i14 = f34 * (f30 + 6418);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-21, -102, -22, -90, -70, -6, -66, -6}, "0919aeee8251"));
                    break;
                case 54390270:
                    int i15 = f34 * (f30 ^ 1504);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-67, -106, -24, -101, -65, -61, -29, -112}, "f738db84", 4));
                    break;
                case 54390271:
                    int i16 = f34 * (f30 | 1192);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-67, -111, -30, -108, -20, -100, -71, -110}, "f59078b1d6"));
                    break;
                case 54395227:
                    int i17 = f34 * (f30 + 8087);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-71, -102, -72, -106, -19, -52, -72, -112}, "b2c46dc67082", 5));
                    break;
                case 54418386:
                    int i18 = f34 * (f30 + 224);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-71, -110, -17, -88, -65, -63, -19, -5}, "b547de6d37"));
                    break;
                case 54419100:
                    int i19 = f34 * (f30 ^ 6674);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-65, -112, -20, -61, -65, -86, -65, -107}, "d77ad5", true));
                    break;
                case 54419106:
                    int i20 = f34 * (f30 ^ 1155);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-70, -81, -70, -97, -18, -58, -65, -108}, "a0a75bd5e8", 0.0f));
                    break;
                case 54420344:
                    int i21 = f34 * (f30 ^ 3269);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-67, -111, -20, -61, -21, -63, -29, -103}, "f17e0c89db4c14", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۥۤۤۦ, reason: contains not printable characters */
    private static String m129() {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-23, -99, -18, -90, -21, -61, -29, -108}, "25590d83305234", false));
        while (true) {
            switch (iM342) {
                case 54149092:
                    int i = f34 * (f30 + 5270);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-17, -60, -21, -104, -24, -102, -21, -110}, "4e083206957a8106", true));
                    break;
                case 54154862:
                    int i2 = f34 * (f30 | 4618);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-20, -111, -66, -105, -23, -59, -22, -112}, "73e52f13e7d1"));
                    break;
                case 54208703:
                    int i3 = f34 * (f30 | 4988);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-71, -63, -21, -64, -72, -103, -30, -110}, "bb0cc997da", 0.0f));
                    break;
                case 54209883:
                    int i4 = f34 * (f30 | 3564);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-71, -62, -23, -59, -23, -83, -17, -61}, "bd2f224c83b5d6"));
                    break;
                case 54240546:
                    int i5 = f34 * (f30 + 6555);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-29, -97, -71, -97, -22, -104, -20, -60}, "87b8107d", 7));
                    break;
                case 54241440:
                    int i6 = f34 * (f30 + 1900);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-22, -97, -30, -99, -66, -107, -72, -102}, "1898e6c896", 2));
                    break;
                case 54244443:
                    int i7 = f34 * (f30 + 6517);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-70, -64, -20, -110, -29, -106, -70, -63}, "ae7686", 0.0f));
                    break;
                case 54272101:
                    int i8 = f34 * (f30 ^ 2640);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-23, -108, -20, -59, -67, -6, -22, -2}, "217afe1a"));
                    break;
                case 54274951:
                    int i9 = f34 * (f30 ^ 5537);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-20, -2, -70, -107, -72, -63, -23, -52}, "7aa0ca2da8", 0.0f));
                    break;
                case 54332607:
                    int i10 = f34 * (f30 | 4095);
                    iM342 = C0006.m338(C0010.decode(new byte[]{-30, -60, -30, -110, -67, -106, -30, -112}, "9f93f398237574"));
                    break;
                case 54332643:
                    int i11 = f34 * (f30 ^ 6779);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-72, -106, -19, -60, -23, -2, -66, -105}, "c16a2ae13a", 0.0f));
                    break;
                case 54333855:
                    int i12 = f34 * (f30 + 3921);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-19, -84, -17, -88, -30, -60, -20, -111}, "63479d75bc80", 0.0f));
                    break;
                case 54361438:
                    int i13 = f34 * (f30 | 926);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-30, -103, -24, -81, -17, -106, -20, -106}, "98304774edc3", 0.0f));
                    break;
                case 54361719:
                    int i14 = f34 * (f30 ^ 2980);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-21, -58, -17, -64, -71, -111, -21, -5}, "0d4eb6", true));
                    break;
                case 54393157:
                    return C0005.m336(f36, 39, 24699133 ^ C0002.f66, 19);
                case 54393277:
                    int i15 = f34 * (f30 ^ 4204);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-66, -97, -17, -52, -71, -52, -22, -53}, "e74dbd1c8f", 6));
                    break;
                case 54417431:
                    int i16 = f34 * (f30 | 258);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-30, -50, -71, -59, -17, -109, -18, -110}, "9fbc4650a2ae91", false));
                    break;
                case 54424091:
                    int i17 = f34 * (f30 + 4429);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-18, -109, -22, -97, -24, -6, -20, -58}, "50193e7eb7", 4));
                    break;
                case 54425143:
                    int i18 = f34 * (f30 | 6167);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-20, -107, -65, -102, -24, -51, -29, -64}, "73d93e8bf6a45608"));
                    break;
                case 54426112:
                    int i19 = f34 * (f30 | 1156);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-19, -100, -29, -63, -30, -103, -22, -112}, "698d9117fbe73820", true));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۣ۠ۥ, reason: contains not printable characters */
    public static int m130(Object obj) {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-30, -58, -20, -57, -22, -58, -70, -59}, "9c7e1eae99ba", true));
        while (true) {
            switch (iM310) {
                case 54149307:
                    int i = f34 * (f30 + 1857);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-66, -104, -72, -60, -19, -106, -66, -107}, "e0cd61"));
                    break;
                case 54151072:
                    int i2 = f34 * (f30 ^ 7594);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-67, -108, -72, -98, -17, -108, -29, -106}, "f6c942853b", false));
                    break;
                case 54154084:
                    int i3 = f34 * (f30 ^ 974);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-30, -105, -21, -62, -66, -106, -30, -110}, "950ae2968ff1"));
                    break;
                case 54155011:
                    int i4 = f34 * (f30 | 7385);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-21, -110, -19, -6, -18, -111, -72, -61}, "046e55cb", true));
                    break;
                case 54180895:
                    int i5 = f34 * (f30 | 547);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-20, -61, -18, -107, -20, -61, -23, -86}, "7d517e2587", 2));
                    break;
                case 54184833:
                    int i6 = f34 * (f30 ^ 2187);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-19, -62, -19, -59, -22, -85, -71, -111}, "6f6f14b9e7b25732"));
                    break;
                case 54208733:
                    int i7 = f34 * (f30 | 7428);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-17, -62, -66, -111, -23, -58, -20, -105}, "4be02e760e", 0.0f));
                    break;
                case 54209666:
                    int i8 = f34 * (f30 + 5399);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-19, -53, -17, -106, -30, -53, -20, -105}, "6c439c71", 0.0f));
                    break;
                case 54239582:
                    int i9 = f34 * (f30 | 4173);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-21, -59, -23, -111, -21, -112, -30, -101}, "0e240699", 0.0f));
                    break;
                case 54242433:
                    int i10 = f34 * (f30 | 1088);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-23, -5, -29, -87, -66, -112, -71, -111}, "2d86e7b3537bb43d", false));
                    break;
                case 54246338:
                    int i11 = f34 * (f30 | 3346);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-66, -101, -70, -110, -65, -52, -72, -112}, "e8a7ddc35d5e67"));
                    break;
                case 54272221:
                    int i12 = f34 * (f30 ^ 4712);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-30, -57, -66, -111, -72, -110, -23, -98}, "9ae2c12921b4", 0.0f));
                    break;
                case 54274269:
                    int i13 = f34 * (f30 + 399);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-66, -3, -29, -109, -18, -112, -18, -101}, "eb8655596a", true));
                    break;
                case 54301864:
                    int i14 = f34 * (f30 + 3123);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-20, -61, -20, -58, -20, -110, -65, -2}, "7e7a71daf9d5", 0.0f));
                    break;
                case 54330810:
                    int i15 = f34 * (f30 + 5327);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-70, -63, -71, -105, -21, -105, -72, -111}, "acb702c4"));
                    break;
                case 54357750:
                    int i16 = f34 * (f30 + 4655);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-19, -64, -20, -87, -72, -106, -18, -62}, "6a76c45c", 0.0f));
                    break;
                case 54361569:
                    int i17 = f34 * (f30 ^ 446);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-20, -4, -20, -107, -71, -64, -71, -111}, "7c71bfb41c700b"));
                    break;
                case 54365405:
                    int i18 = f34 * (f30 | 7761);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-18, -108, -65, -102, -70, -106, -19, -57}, "57d9a26fbde44f"));
                    break;
                case 54392406:
                    return obj.hashCode();
                case 54393369:
                    int i19 = f34 * (f30 ^ 4247);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-17, -5, -24, -64, -72, -106, -72, -60}, "4d3ac4cdf79aea21", 0.0f));
                    break;
                case 54418390:
                    int i20 = f34 * (f30 ^ 5736);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-18, -106, -70, -62, -67, -60, -23, -63}, "57abfe2e69", 0.0f));
                    break;
                case 54423227:
                    int i21 = f34 * (f30 ^ 1637);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-24, -110, -17, -105, -70, -112, -20, -107}, "3542a674127a"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۦۤۢۥۢ, reason: contains not printable characters */
    public static int m131() {
        int iM350 = C0009.m350(C0010.decode(new byte[]{-21, -4, -23, -4, -19, -107, -21, -110}, "0c2c6102"));
        while (true) {
            switch (iM350) {
                case 54149087:
                    int i = f34 * (f30 + 2282);
                    iM350 = C0006.m338(C0010.decode(new byte[]{-17, -107, -71, -3, -65, -62, -18, -7}, "42bbdb5fa67b", 3));
                    break;
                case 54149212:
                    int i2 = f34 * (f30 ^ 2808);
                    iM350 = C0007.m342(C0010.decode(new byte[]{-29, -57, -70, -112, -67, -97, -18, -107}, "8fa3f854"));
                    break;
                case 54156751:
                    int i3 = f34 * (f30 + 6624);
                    iM350 = C0005.m333(C0010.decode(new byte[]{-70, -63, -22, -112, -23, -60, -24, -55}, "ac162a3a3c055a19", true));
                    break;
                case 54157986:
                    int i4 = f34 * (f30 ^ 6925);
                    iM350 = C0002.m317(C0010.decode(new byte[]{-71, -106, -70, -108, -72, -108, -30, -58}, "b4a1c19efe", false));
                    break;
                case 54186726:
                    int i5 = f34 * (f30 | 123);
                    iM350 = C0003.m323(C0010.decode(new byte[]{-71, -99, -65, -109, -72, -81, -18, -62}, "b8d1c05d9bc0", 0.0f));
                    break;
                case 54187652:
                    int i6 = f34 * (f30 + 2150);
                    iM350 = C0008.m347(C0010.decode(new byte[]{-17, -64, -21, -107, -22, -111, -17, -61}, "4f0010", 3));
                    break;
                case 54212732:
                    int i7 = f34 * (f30 | 1126);
                    iM350 = C0002.m317(C0010.decode(new byte[]{-65, -83, -30, -83, -29, -58, -71, -3}, "d2928fbbb621", false));
                    break;
                case 54215587:
                    int i8 = f34 * (f30 ^ 4548);
                    iM350 = C0003.m323(C0010.decode(new byte[]{-71, -107, -70, -59, -23, -100, -20, -106}, "b5ab297283472b", 0.0f));
                    break;
                case 54244385:
                    int i9 = f34 * (f30 | 829);
                    iM350 = C0008.m347(C0010.decode(new byte[]{-29, -58, -65, -57, -22, -109, -20, -110}, "8cde167741b0bebd", 4));
                    break;
                case 54245351:
                    int i10 = f34 * (f30 ^ 1844);
                    iM350 = C0002.m317(C0010.decode(new byte[]{-71, -85, -71, -55, -72, -111, -72, -62}, "b4bac9cc86a99c", 0.0f));
                    break;
                case 54271261:
                    int i11 = f34 * (f30 | 7235);
                    iM350 = C0002.m317(C0010.decode(new byte[]{-70, -108, -72, -107, -71, -5, -71, -102}, "a7c6bdb9", true));
                    break;
                case 54272068:
                    int i12 = f34 * (f30 | 5129);
                    iM350 = C0005.m333(C0010.decode(new byte[]{-20, -62, -65, -111, -30, -110, -24, -63}, "7ad2913ea44fc1ea", 7));
                    break;
                case 54272193:
                    int i13 = f34 * (f30 ^ 6568);
                    iM350 = C0007.m342(C0010.decode(new byte[]{-22, -107, -22, -54, -18, -107, -17, -108}, "151b5144ea91", 0.0f));
                    break;
                case 54303872:
                    int i14 = f34 * (f30 ^ 5665);
                    iM350 = C0000.m310(C0010.decode(new byte[]{-19, -108, -17, -60, -23, -100, -67, -61}, "614f29fab18ccb", 5));
                    break;
                case 54306760:
                    int i15 = f34 * (f30 + 5354);
                    iM350 = C0006.m338(C0010.decode(new byte[]{-17, -102, -19, -62, -22, -109, -23, -58}, "426b162a710f", false));
                    break;
                case 54330692:
                    int i16 = f34 * (f30 + 4539);
                    iM350 = C0003.m323(C0010.decode(new byte[]{-65, -60, -70, -111, -19, -64, -70, -104}, "daa76ba09c"));
                    break;
                case 54330874:
                    int i17 = f34 * (f30 | 6388);
                    iM350 = C0008.m347(C0010.decode(new byte[]{-67, -111, -30, -52, -67, -101, -70, -106}, "f59df9a0da42aa", true));
                    break;
                case 54330877:
                    int i18 = f34 * (f30 | 4904);
                    iM350 = C0002.m317(C0010.decode(new byte[]{-19, -100, -17, -109, -23, -63, -71, -107}, "68462cb4"));
                    break;
                case 54334631:
                    int i19 = f34 * (f30 | 3584);
                    iM350 = C0008.m347(C0010.decode(new byte[]{-65, -112, -70, -2, -67, -109, -65, -110}, "d6aaf1"));
                    break;
                case 54357691:
                    int i20 = 0;
                    int i21 = 0;
                    int i22 = 0;
                    int i23 = 0;
                    char c = 5580;
                    while (true) {
                        switch (c) {
                            case 23126:
                                i23 %= 10;
                                i22 = 1956039423;
                                i20 ^= i21;
                                c = 39712;
                                break;
                            case 39712:
                                return i20;
                            case 5580:
                                i23 = (i23 * i22) + 110;
                                i20 = 2044028579;
                                i21 = 1749208115;
                                c = 23126;
                                break;
                            case 62585:
                                int i24 = i23 % 11;
                                i22 = 1917937097;
                                i23 = 2007834110 % 5;
                                break;
                        }
                    }
                    break;
                case 54363427:
                    int i25 = f34 * (f30 | 7086);
                    iM350 = C0001.m315(C0010.decode(new byte[]{-21, -82, -70, -110, -30, -83, -24, -98}, "01a59238", 0.0f));
                    break;
                case 54387415:
                    int i26 = f34 * (f30 + 3041);
                    iM350 = C0005.m333(C0010.decode(new byte[]{-29, -62, -20, -101, -71, -110, -29, -110}, "8a79b680d8", 6));
                    break;
                case 54418330:
                    int i27 = f34 * (f30 | 7541);
                    iM350 = C0009.m350(C0010.decode(new byte[]{-20, -106, -72, -64, -21, -62, -20, -109}, "77cf0d", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۢۤ۟, reason: not valid java name and contains not printable characters */
    public static int m132() {
        int iM342 = C0007.m342(C0010.decode(new byte[]{-23, -64, -71, -104, -21, -110, -29, -52}, "2bb8058d", 0.0f));
        while (true) {
            switch (iM342) {
                case 54185641:
                    int i = f34 * (f30 ^ 5293);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-17, -109, -20, -107, -20, -103, -17, -105}, "477379", 0.0f));
                    break;
                case 54208736:
                    int i2 = f34 * (f30 | 945);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-71, -108, -17, -111, -18, -50, -66, -98}, "b7405fe6ae", 5));
                    break;
                case 54239647:
                    int i3 = f34 * (f30 | 6490);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-19, -103, -67, -98, -20, -107, -71, -106}, "61f973b5ce", 0.0f));
                    break;
                case 54245312:
                    int i4 = f34 * (f30 ^ 6112);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-18, -101, -72, -54, -66, -100, -71, -99}, "58cbe9b8e5", 3));
                    break;
                case 54270337:
                    int i5 = f34 * (f30 | 6254);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-30, -59, -19, -111, -65, -63, -72, -112}, "9b66ddc0", 4));
                    break;
                case 54270430:
                    int i6 = f34 * (f30 ^ 6068);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-66, -105, -29, -105, -70, -109, -66, -104}, "e581a7e89a63b84c"));
                    break;
                case 54271328:
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    int i10 = 0;
                    char c = 16233;
                    while (true) {
                        switch (c) {
                            case 30922:
                                i10 += i9;
                                i9 += 23;
                                i7 ^= i8;
                                c = 15107;
                                break;
                            case 37539:
                                i10 = ((1724317037 + 101) % 33) + 67;
                                break;
                            case 15107:
                                return i7;
                            case 16233:
                                i9 = ((i9 % 26) + 98) & i10;
                                i7 = 1616858426;
                                i8 = 336056521;
                                c = 30922;
                                break;
                        }
                    }
                    break;
                case 54277061:
                    int i11 = f34 * (f30 + 4403);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-22, -111, -72, -64, -18, -59, -18, -64}, "14ca5f5d242d", 3));
                    break;
                case 54298167:
                    int i12 = f34 * (f30 | 6540);
                    iM342 = C0002.m317(C0010.decode(new byte[]{-67, -111, -65, -111, -19, -100, -67, -107}, "f6d369"));
                    break;
                case 54302980:
                    int i13 = f34 * (f30 ^ 3741);
                    iM342 = C0008.m347(C0010.decode(new byte[]{-18, -100, -17, -58, -30, -99, -22, -109}, "584b95147d", 7));
                    break;
                case 54303103:
                    int i14 = f34 * (f30 | 5600);
                    iM342 = C0003.m323(C0010.decode(new byte[]{-23, -98, -67, -109, -29, -63, -23, -62}, "28f68c2f97e0f883", 0.0f));
                    break;
                case 54304770:
                    int i15 = f34 * (f30 | 1818);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-18, -112, -71, -57, -20, -58, -21, -58}, "55ba7d0c411a70", 0));
                    break;
                case 54329853:
                    int i16 = f34 * (f30 | 4808);
                    iM342 = C0007.m342(C0010.decode(new byte[]{-65, -61, -72, -52, -21, -112, -65, -63}, "decd01"));
                    break;
                case 54334628:
                    int i17 = f34 * (f30 ^ 3770);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-21, -62, -18, -61, -24, -97, -20, -105}, "0a5a39708a7705a8", 5));
                    break;
                case 54363457:
                    int i18 = f34 * (f30 + 7052);
                    iM342 = C0004.m329(C0010.decode(new byte[]{-21, -101, -70, -110, -19, -58, -21, -112}, "08a36c", false));
                    break;
                case 54364569:
                    int i19 = f34 * (f30 + 2061);
                    iM342 = C0009.m350(C0010.decode(new byte[]{-66, -59, -21, -88, -17, -106, -19, -105}, "ed0744631eeadd", 0.0f));
                    break;
                case 54366309:
                    int i20 = f34 * (f30 ^ 2550);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-30, -101, -71, -58, -24, -59, -66, -104}, "93be3ae0f402"));
                    break;
                case 54390457:
                    int i21 = f34 * (f30 + 4065);
                    iM342 = C0001.m315(C0010.decode(new byte[]{-72, -57, -71, -107, -72, -64, -72, -53}, "ccb1cd"));
                    break;
                case 54395259:
                    int i22 = f34 * (f30 + 2325);
                    iM342 = C0005.m333(C0010.decode(new byte[]{-66, -105, -72, -106, -30, -106, -17, -107}, "e1c09145b3856e", 0.0f));
                    break;
                case 54421183:
                    int i23 = f34 * (f30 + 4715);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-23, -103, -18, -109, -66, -105, -23, -99}, "2955e6"));
                    break;
                case 54425084:
                    int i24 = f34 * (f30 + 6749);
                    iM342 = C0000.m310(C0010.decode(new byte[]{-70, -99, -72, -86, -21, -107, -18, -60}, "a9c5015d63a1d029"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۤۦۦ, reason: not valid java name and contains not printable characters */
    public static String m133() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-30, -58, -20, -108, -17, -102, -20, -102}, "9e70487299"));
        while (true) {
            switch (iM315) {
                case 54180902:
                    int i = f34 * (f30 + 3981);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-65, -57, -21, -112, -18, -57, -67, -2}, "dd025efac65a", true));
                    break;
                case 54184776:
                    int i2 = f34 * (f30 | 3481);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-21, -62, -24, -57, -72, -112, -67, -57}, "0f3cc1ff9a70", 0.0f));
                    break;
                case 54212483:
                    int i3 = f34 * (f30 + 6105);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-22, -110, -20, -112, -30, -112, -22, -111}, "147595", 5));
                    break;
                case 54212668:
                    int i4 = f34 * (f30 | 2651);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-65, -59, -19, -57, -30, -101, -65, -52}, "dd6b99", 0.0f));
                    break;
                case 54214506:
                    int i5 = f34 * (f30 ^ 1347);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-30, -109, -66, -104, -24, -59, -30, -82}, "91e93f"));
                    break;
                case 54238438:
                    int i6 = f34 * (f30 ^ 6243);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-66, -106, -22, -60, -21, -63, -70, -108}, "e51e0ba6bb", 0));
                    break;
                case 54240475:
                    int i7 = f34 * (f30 + 3184);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-21, -99, -23, -108, -20, -107, -21, -59}, "0521750fa997effa", 3));
                    break;
                case 54242274:
                    int i8 = f34 * (f30 ^ 6420);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-17, -64, -18, -106, -66, -106, -24, -101}, "4e53e6396d19", 0.0f));
                    break;
                case 54269308:
                    if (hv970Gaa.m146() <= 0) {
                        return m116();
                    }
                    return null;
                case 54270269:
                    int i9 = f34 * (f30 ^ 4506);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-24, -109, -18, -109, -71, -111, -19, -6}, "3250b46ee7"));
                    break;
                case 54271196:
                    int i10 = f34 * (f30 + 3143);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-23, -107, -20, -5, -19, -106, -23, -111}, "207d63", 0.0f));
                    break;
                case 54273127:
                    int i11 = f34 * (f30 | 8107);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-23, -60, -20, -107, -65, -102, -20, -100}, "2d74d974b0e9", true));
                    break;
                case 54302880:
                    int i12 = f34 * (f30 ^ 7939);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-67, -105, -22, -64, -65, -107, -66, -3}, "f01cd7eb45", 0.0f));
                    break;
                case 54327990:
                    int i13 = f34 * (f30 ^ 602);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-18, -110, -72, -87, -23, -4, -67, -51}, "50c62cfe9275940a", true));
                    break;
                case 54333602:
                    int i14 = f34 * (f30 | 7997);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-24, -110, -19, -111, -24, -112, -67, -110}, "326434f5c6", 2));
                    break;
                case 54363551:
                    int i15 = f34 * (f30 + 6403);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-21, -98, -22, -60, -30, -110, -21, -111}, "061f9701d685b9", 0.0f));
                    break;
                case 54391321:
                    int i16 = f34 * (f30 | 3338);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-22, -64, -20, -109, -72, -83, -17, -62}, "1a70c24bbf9a661c"));
                    break;
                case 54418291:
                    int i17 = f34 * (f30 | 3803);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-19, -57, -29, -62, -72, -102, -17, -109}, "6d8bc94121e2"));
                    break;
                case 54420245:
                    int i18 = f34 * (f30 ^ 1073);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-19, -97, -71, -60, -65, -99, -19, -88}, "67bdd9", false));
                    break;
                case 54422976:
                    int i19 = f34 * (f30 + 4124);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-23, -107, -67, -63, -20, -83, -18, -60}, "27fb725d5d1b44c9", 6));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۦۣۧ, reason: not valid java name and contains not printable characters */
    public static boolean m134(Object obj, Object obj2) {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-30, -85, -22, -100, -72, -63, -30, -108}, "9419cc"));
        while (true) {
            switch (iM323) {
                case 54154916:
                    int i = f34 * (f30 | 5977);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-24, -110, -30, -2, -66, -109, -24, -87}, "369ae0", 4));
                    break;
                case 54185612:
                    int i2 = f34 * (f30 + 6539);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-19, -64, -72, -64, -18, -107, -24, -111}, "6fce5632fdb04830", true));
                    break;
                case 54211587:
                    int i3 = f34 * (f30 | 3299);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-29, -59, -72, -108, -65, -111, -24, -2}, "8ac3d73adb51cb", 2));
                    break;
                case 54213729:
                    int i4 = f34 * (f30 ^ 2212);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-65, -63, -67, -59, -23, -59, -17, -100}, "deff2f4421"));
                    break;
                case 54240545:
                    int i5 = f34 * (f30 ^ 7080);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-71, -111, -65, -109, -72, -57, -24, -57}, "b0d1cf3d9a52e9ab"));
                    break;
                case 54276191:
                    int i6 = f34 * (f30 + 7567);
                    iM323 = C0009.m350(C0010.decode(new byte[]{-22, -110, -18, -99, -22, -110, -17, -64}, "1758154e71263b", true));
                    break;
                case 54298135:
                    int i7 = f34 * (f30 + 3042);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-19, -101, -18, -111, -71, -61, -67, -111}, "6950bff6", 0.0f));
                    break;
                case 54299035:
                    int i8 = f34 * (f30 ^ 5893);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-72, -108, -17, -99, -22, -62, -66, -111}, "c3451ee1958e3f98"));
                    break;
                case 54301988:
                    if (m105() <= 0) {
                        return C0002.m318((String) obj, (String) obj2);
                    }
                    return false;
                case 54305916:
                    int i9 = f34 * (f30 ^ 6610);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-21, -102, -20, -108, -29, -112, -21, -102}, "097388", 4));
                    break;
                case 54327873:
                    int i10 = f34 * (f30 + 7522);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-20, -98, -70, -108, -18, -63, -29, -104}, "78a45d89499fbb0d", 0.0f));
                    break;
                case 54333822:
                    int i11 = f34 * (f30 + 3313);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-29, -58, -22, -103, -30, -105, -23, -57}, "8c11972cc739ae", 0.0f));
                    break;
                case 54336487:
                    int i12 = f34 * (f30 + 8061);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-19, -105, -18, -60, -72, -62, -22, -105}, "635dcc17e0"));
                    break;
                case 54358742:
                    int i13 = f34 * (f30 | 6830);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-72, -105, -19, -60, -18, -63, -20, -4}, "c06d5d7c94883f", false));
                    break;
                case 54360669:
                    int i14 = f34 * (f30 | 6914);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-23, -111, -70, -109, -19, -105, -21, -59}, "26a0660e40", 5));
                    break;
                case 54363487:
                    int i15 = f34 * (f30 | 7279);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-20, -106, -20, -85, -17, -109, -72, -103}, "737442c1", 0.0f));
                    break;
                case 54388531:
                    int i16 = f34 * (f30 ^ 5616);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-24, -103, -18, -112, -21, -99, -19, -105}, "38540561cf1aeb", 0.0f));
                    break;
                case 54391291:
                    int i17 = f34 * (f30 + 1409);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-66, -61, -29, -106, -19, -105, -20, -110}, "ec806774", 0.0f));
                    break;
                case 54396282:
                    int i18 = f34 * (f30 ^ 1414);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-24, -97, -72, -58, -29, -99, -67, -106}, "37ca89f6eb", 7));
                    break;
                case 54425019:
                    int i19 = f34 * (f30 | 5286);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-20, -98, -66, -102, -19, -110, -20, -98}, "78e867", 0.0f));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۧۨۧۥۦۧ, reason: not valid java name and contains not printable characters */
    private static String m135() {
        int iM329 = C0004.m329(C0010.decode(new byte[]{-24, -62, -30, -60, -66, -108, -30, -54}, "3a9ee69bfdaea909", 0.0f));
        while (true) {
            switch (iM329) {
                case 54152193:
                    int i = f34 * (f30 | 4177);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-65, -101, -65, -89, -17, -110, -23, -99}, "d8d84629"));
                    break;
                case 54157953:
                    int i2 = f34 * (f30 | 7230);
                    iM329 = C0005.m333(C0010.decode(new byte[]{-17, -112, -65, -110, -19, -105, -71, -61}, "47d065bddc552485", 7));
                    break;
                case 54178912:
                    int i3 = f34 * (f30 ^ 6474);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-19, -109, -71, -59, -29, -63, -19, -107}, "66be8d", 6));
                    break;
                case 54179037:
                    int i4 = f34 * (f30 ^ 2856);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-21, -105, -24, -106, -30, -99, -71, -105}, "073595b5"));
                    break;
                case 54182973:
                    int i5 = f34 * (f30 | 1931);
                    iM329 = C0003.m323(C0010.decode(new byte[]{-22, -100, -67, -59, -65, -54, -22, -90}, "19fedb", 4));
                    break;
                case 54217411:
                    int i6 = f34 * (f30 | 5621);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-22, -101, -65, -111, -30, -100, -66, -7}, "18d698ef8898bc80", true));
                    break;
                case 54268380:
                    int i7 = f34 * (f30 + 5016);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-65, -51, -18, -63, -24, -108, -29, -97}, "de5a3287", true));
                    break;
                case 54270244:
                    int i8 = f34 * (f30 | 7116);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-29, -61, -22, -4, -65, -108, -29, -64}, "8c1cd1", 0.0f));
                    break;
                case 54273310:
                    int i9 = f34 * (f30 ^ 2394);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-29, -88, -29, -102, -72, -109, -29, -88}, "8782c4", true));
                    break;
                case 54276063:
                    int i10 = f34 * (f30 | 6285);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-17, -62, -70, -106, -24, -108, -30, -97}, "4da43199ab6e6cb3"));
                    break;
                case 54276067:
                    int i11 = f34 * (f30 + 872);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-70, -7, -18, -105, -71, -58, -17, -60}, "af55ba4af8bdb590", false));
                    break;
                case 54276962:
                    int i12 = f34 * (f30 ^ 6282);
                    iM329 = C0008.m347(C0010.decode(new byte[]{-24, -109, -71, -61, -20, -110, -29, -111}, "30bd768210d080", false));
                    break;
                case 54300181:
                    int i13 = f34 * (f30 + 5501);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-18, -62, -72, -55, -71, -111, -18, -85}, "5acab354", 0.0f));
                    break;
                case 54328953:
                    int i14 = f34 * (f30 ^ 3144);
                    iM329 = C0001.m315(C0010.decode(new byte[]{-18, -60, -18, -50, -24, -112, -24, -89}, "5e5f3338f84fe7", 5));
                    break;
                case 54329042:
                    int i15 = f34 * (f30 ^ 8077);
                    iM329 = C0006.m338(C0010.decode(new byte[]{-30, -112, -23, -106, -72, -111, -66, -63}, "9527c1eedea49f", false));
                    break;
                case 54329760:
                    int i16 = f34 * (f30 | 8117);
                    iM329 = C0000.m310(C0010.decode(new byte[]{-24, -54, -19, -63, -21, -105, -70, -107}, "3b6a07a6"));
                    break;
                case 54360669:
                    int i17 = f34 * (f30 ^ 1474);
                    iM329 = C0009.m350(C0010.decode(new byte[]{-66, -59, -23, -107, -21, -111, -67, -58}, "ef2109fc359f", 2));
                    break;
                case 54390368:
                    int i18 = f34 * (f30 | 4609);
                    iM329 = C0007.m342(C0010.decode(new byte[]{-17, -59, -18, -59, -67, -106, -17, -4}, "4a5df14c"));
                    break;
                case 54418171:
                    int i19 = f34 * (f30 ^ 6114);
                    iM329 = C0004.m329(C0010.decode(new byte[]{-67, -60, -23, -90, -67, -112, -67, -58}, "fd29f1"));
                    break;
                case 54418362:
                    return C0005.m336(f36, 33, 1257808855 ^ C0000.f62, 6);
            }
        }
    }

    /* JADX INFO: renamed from: ۨ۠۠ۦۥ, reason: not valid java name and contains not printable characters */
    private static String m136() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-18, -109, -66, -59, -17, -111, -22, -63}, "54ed411c16", 5));
        while (true) {
            switch (iM315) {
                case 54152904:
                    int i = f34 * (f30 | 6419);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-66, -112, -71, -98, -20, -105, -72, -60}, "e6b877cc", 6));
                    break;
                case 54153089:
                    int i2 = f34 * (f30 | 3776);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-70, -106, -30, -63, -18, -60, -30, -64}, "a69f5c9d1b", 0));
                    break;
                case 54154053:
                    int i3 = f34 * (f30 + 1689);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-30, -100, -70, -112, -72, -104, -65, -5}, "94a1c8dd", 0.0f));
                    break;
                case 54155109:
                    int i4 = f34 * (f30 ^ 4119);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-21, -111, -70, -110, -19, -83, -70, -106}, "02a662a7f40489"));
                    break;
                case 54186788:
                    int i5 = f34 * (f30 ^ 2770);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-21, -53, -17, -106, -67, -109, -17, -108}, "0c45f541", 0.0f));
                    break;
                case 54217356:
                    int i6 = f34 * (f30 ^ 2732);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-17, -82, -67, -100, -21, -112, -71, -62}, "41f908be5bbb", true));
                    break;
                case 54241537:
                    int i7 = f34 * (f30 | 2759);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-72, -4, -70, -101, -24, -84, -19, -108}, "cca833673110bf20", false));
                    break;
                case 54273027:
                    int i8 = f34 * (f30 ^ 8062);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-24, -58, -17, -109, -29, -111, -67, -62}, "3d4187fe"));
                    break;
                case 54299995:
                    int i9 = f34 * (f30 ^ 4368);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-19, -111, -67, -54, -17, -63, -20, -57}, "69fb4e7deb", false));
                    break;
                case 54300903:
                    int i10 = f34 * (f30 ^ 1765);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-70, -85, -65, -64, -71, -108, -20, -57}, "a4dcb17ec73e", 0.0f));
                    break;
                case 54301027:
                    return C0005.m336(f36, 22, 808363933 ^ C0006.f74, 11);
                case 54334533:
                    int i11 = f34 * (f30 ^ 1392);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-65, -62, -21, -108, -29, -107, -22, -60}, "dd07821e1dd4a0"));
                    break;
                case 54361687:
                    int i12 = f34 * (f30 ^ 2076);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-19, -98, -71, -105, -70, -107, -29, -108}, "69b6a480", 0.0f));
                    break;
                case 54364359:
                    int i13 = f34 * (f30 | 5978);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-70, -58, -67, -57, -30, -87, -67, -53}, "abfe96fcddc1"));
                    break;
                case 54387604:
                    int i14 = f34 * (f30 | 3895);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-67, -64, -29, -102, -71, -104, -24, -60}, "fa82b93b", false));
                    break;
                case 54389340:
                    int i15 = f34 * (f30 ^ 4545);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-20, -64, -19, -62, -72, -62, -17, -84}, "7d6ccc4342", 0.0f));
                    break;
                case 54389373:
                    int i16 = f34 * (f30 | 5119);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-21, -60, -70, -83, -19, -109, -66, -111}, "0ca265e34953f2", 0.0f));
                    break;
                case 54419128:
                    int i17 = f34 * (f30 | 6664);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-30, -99, -19, -101, -71, -62, -17, -101}, "9969ba4353"));
                    break;
                case 54421242:
                    int i18 = f34 * (f30 | 5377);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-24, -88, -66, -110, -17, -61, -66, -63}, "37e64fed", 3));
                    break;
                case 54425983:
                    int i19 = f34 * (f30 | 6955);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-66, -57, -70, -109, -65, -3, -24, -62}, "eba5db3a"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۣۨ۟ۧ, reason: not valid java name and contains not printable characters */
    public static String m137() {
        int iM315 = C0001.m315(C0010.decode(new byte[]{-71, -112, -67, -60, -30, -61, -71, -105}, "b7fd9f", false));
        while (true) {
            switch (iM315) {
                case 54154142:
                    int i = f34 * (f30 | 5335);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-30, -62, -20, -83, -67, -84, -66, -62}, "9a72f3ea5e", 0.0f));
                    break;
                case 54178881:
                    int i2 = f34 * (f30 ^ 5635);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-24, -107, -19, -111, -29, -107, -22, -111}, "326680192dae6899", 0.0f));
                    break;
                case 54180775:
                    int i3 = f34 * (f30 | 6194);
                    iM315 = C0007.m342(C0010.decode(new byte[]{-29, -108, -24, -112, -20, -64, -30, -64}, "84377b9b070c", 7));
                    break;
                case 54186631:
                    int i4 = f34 * (f30 + 1069);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-23, -111, -30, -111, -67, -104, -23, -3}, "2793f82b"));
                    break;
                case 54209639:
                    int i5 = f34 * (f30 | 706);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-24, -2, -21, -99, -18, -97, -65, -111}, "3a0957d05a7e", 0.0f));
                    break;
                case 54242397:
                    int i6 = f34 * (f30 | 2694);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-24, -110, -20, -105, -72, -59, -30, -98}, "3377ce9657f2", true));
                    break;
                case 54268224:
                    int i7 = f34 * (f30 + 6088);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-23, -103, -19, -59, -21, -84, -23, -100}, "296d03", 0.0f));
                    break;
                case 54271260:
                    int i8 = f34 * (f30 ^ 6234);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-67, -107, -67, -64, -23, -62, -65, -107}, "f1fb2ed59ba715", 0.0f));
                    break;
                case 54272190:
                    int i9 = f34 * (f30 | 7358);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-23, -97, -72, -107, -20, -3, -72, -103}, "29c17bc98a9e"));
                    break;
                case 54298977:
                    int i10 = f34 * (f30 ^ 4835);
                    iM315 = C0001.m315(C0010.decode(new byte[]{-72, -57, -70, -101, -72, -59, -22, -61}, "cda9ca1ba4aae2", 3));
                    break;
                case 54301143:
                    int i11 = f34 * (f30 + 1396);
                    iM315 = C0009.m350(C0010.decode(new byte[]{-19, -107, -20, -64, -18, -59, -23, -112}, "667c5f214024adc7", 1));
                    break;
                case 54303814:
                    int i12 = f34 * (f30 + 6017);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-70, -64, -71, -58, -72, -101, -30, -102}, "afbbc39220fab90e", false));
                    break;
                case 54335622:
                    int i13 = f34 * (f30 ^ 305);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-17, -107, -21, -112, -71, -106, -18, -57}, "4205b25d", 6));
                    break;
                case 54360507:
                    int i14 = f34 * (f30 + 935);
                    iM315 = C0003.m323(C0010.decode(new byte[]{-24, -50, -65, -62, -70, -62, -22, -109}, "3fdaaf11c9bb"));
                    break;
                case 54362399:
                    int i15 = f34 * (f30 ^ 2100);
                    iM315 = C0000.m310(C0010.decode(new byte[]{-67, -52, -22, -59, -22, -106, -67, -60}, "fd1b11", true));
                    break;
                case 54362686:
                    int i16 = f34 * (f30 | 5630);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-21, -63, -72, -104, -19, -7, -22, -64}, "0ec86f1d247fdd", true));
                    break;
                case 54388532:
                    int i17 = f34 * (f30 + 1923);
                    iM315 = C0004.m329(C0010.decode(new byte[]{-70, -101, -20, -102, -20, -102, -65, -81}, "a97979d0f7be"));
                    break;
                case 54393309:
                    int i18 = f34 * (f30 ^ 1393);
                    iM315 = C0006.m338(C0010.decode(new byte[]{-71, -105, -21, -2, -29, -103, -72, -112}, "b70a89c2", 4));
                    break;
                case 54395267:
                    int i19 = f34 * (f30 ^ 6493);
                    iM315 = C0005.m333(C0010.decode(new byte[]{-72, -54, -22, -58, -24, -61, -72, -59}, "cb1f3c", 6));
                    break;
                case 54418175:
                    if (hv970Gaa.m146() <= 0) {
                        return m118();
                    }
                    return null;
                case 54421177:
                    int i20 = f34 * (f30 ^ 7207);
                    iM315 = C0002.m317(C0010.decode(new byte[]{-30, -62, -22, -63, -67, -60, -17, -106}, "9f1dfd43efbb03bc", 1));
                    break;
                case 54425112:
                    int i21 = f34 * (f30 + 4649);
                    iM315 = C0008.m347(C0010.decode(new byte[]{-29, -108, -65, -111, -70, -112, -18, -98}, "81d6a359f2411b"));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۤۢ۟, reason: not valid java name and contains not printable characters */
    public static int m138() {
        int iM323 = C0003.m323(C0010.decode(new byte[]{-17, -112, -23, -61, -21, -58, -21, -112}, "442e0b0180e2", false));
        while (true) {
            switch (iM323) {
                case 54149180:
                    int i = f34 * (f30 + 7011);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-20, -105, -19, -105, -70, -110, -17, -61}, "7462a34a9aca", 0.0f));
                    break;
                case 54150021:
                    int i2 = f34 * (f30 | 7897);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-23, -57, -70, -98, -66, -97, -24, -57}, "2ba6e83bde86801b", 0.0f));
                    break;
                case 54217541:
                    int i3 = f34 * (f30 + 7040);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-72, -100, -18, -60, -17, -111, -72, -109}, "c45e46", true));
                    break;
                case 54241374:
                    int i4 = f34 * (f30 | 7100);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-19, -103, -20, -106, -30, -108, -66, -99}, "617192e9d4bbb049"));
                    break;
                case 54245190:
                    int i5 = f34 * (f30 ^ 676);
                    iM323 = C0004.m329(C0010.decode(new byte[]{-66, -108, -71, -109, -65, -63, -17, -58}, "e7b5dc4f7c49b4", false));
                    break;
                case 54268291:
                    int i6 = f34 * (f30 + 4839);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-21, -109, -67, -64, -19, -103, -29, -64}, "01ff698b4dba4c43", 4));
                    break;
                case 54274051:
                    int i7 = f34 * (f30 + 6712);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-65, -6, -67, -109, -19, -89, -65, -58}, "def368", true));
                    break;
                case 54275041:
                    int i8 = f34 * (f30 + 2081);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-22, -7, -18, -2, -30, -59, -22, -7}, "1f5a9f", 1));
                    break;
                case 54302106:
                    int i9 = f34 * (f30 + 5604);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-23, -62, -65, -97, -65, -111, -23, -64}, "2ed8d5", true));
                    break;
                case 54303940:
                    int i10 = f34 * (f30 | 1131);
                    iM323 = C0005.m333(C0010.decode(new byte[]{-66, -108, -70, -105, -70, -108, -66, -86}, "e2a4a3e5ea26"));
                    break;
                case 54304028:
                    int i11 = f34 * (f30 + 3705);
                    iM323 = C0007.m342(C0010.decode(new byte[]{-66, -64, -29, -3, -19, -108, -19, -97}, "ec8b656749f9", 4));
                    break;
                case 54304895:
                    int i12 = f34 * (f30 | 5327);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-21, -107, -65, -100, -29, -50, -24, -111}, "02d98f342dbd", 5));
                    break;
                case 54336705:
                    int i13 = 0;
                    int i14 = 0;
                    int i15 = 0;
                    char c = 39053;
                    while (true) {
                        switch (c) {
                            case 39053:
                                i15 += 70;
                                i13 = 5922768;
                                i14 = 1115145598;
                                c = 36979;
                                break;
                            case 15910:
                                i15 = (i15 % 21) % 26;
                                break;
                            case 36979:
                                i13 ^= i14;
                                c = 12615;
                                break;
                            case 12615:
                                return i13;
                        }
                    }
                    break;
                case 54360638:
                    int i16 = f34 * (f30 | 73);
                    iM323 = C0003.m323(C0010.decode(new byte[]{-21, -102, -29, -106, -20, -61, -65, -84}, "08847bd39fc1", true));
                    break;
                case 54361685:
                    int i17 = f34 * (f30 + 3129);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-17, -62, -19, -64, -66, -105, -17, -62}, "4d6be3"));
                    break;
                case 54393435:
                    int i18 = f34 * (f30 | 2953);
                    iM323 = C0000.m310(C0010.decode(new byte[]{-21, -63, -21, -109, -65, -98, -71, -111}, "0e00d9b3", false));
                    break;
                case 54395233:
                    int i19 = f34 * (f30 ^ 3253);
                    iM323 = C0001.m315(C0010.decode(new byte[]{-23, -103, -67, -111, -22, -105, -70, -58}, "28f910ac", 0));
                    break;
                case 54419353:
                    int i20 = f34 * (f30 ^ 2413);
                    iM323 = C0002.m317(C0010.decode(new byte[]{-21, -105, -18, -112, -24, -105, -22, -98}, "03553319a17f", true));
                    break;
                case 54424990:
                    int i21 = f34 * (f30 + 4215);
                    iM323 = C0008.m347(C0010.decode(new byte[]{-20, -112, -66, -100, -18, -61, -66, -112}, "74e95de2c236714f", 0.0f));
                    break;
                case 54425085:
                    int i22 = f34 * (f30 | 2491);
                    iM323 = C0006.m338(C0010.decode(new byte[]{-24, -104, -70, -63, -19, -108, -66, -112}, "30af67e219ef42", 2));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۥۡۨۡ, reason: not valid java name and contains not printable characters */
    private static String m139() {
        int iM310 = C0000.m310(C0010.decode(new byte[]{-65, -111, -24, -109, -24, -107, -24, -58}, "d532343dc3dd5850", true));
        while (true) {
            switch (iM310) {
                case 54179848:
                    int i = f34 * (f30 | 5275);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-17, -97, -65, -87, -22, -104, -17, -104}, "49d619"));
                    break;
                case 54209694:
                    int i2 = f34 * (f30 ^ 3755);
                    iM310 = C0000.m310(C0010.decode(new byte[]{-21, -112, -29, -63, -30, -109, -30, -62}, "058c959ce26243db", 0.0f));
                    break;
                case 54214594:
                    int i3 = f34 * (f30 | 2035);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-72, -100, -20, -97, -21, -106, -22, -3}, "c478061bb970", false));
                    break;
                case 54215589:
                    return C0005.m336(f36, 16, 1544422318 ^ C0005.f72, 6);
                case 54216456:
                    int i4 = f34 * (f30 | 5520);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-18, -63, -24, -59, -24, -108, -66, -104}, "5a3e34e08cb4efbc"));
                    break;
                case 54242402:
                    int i5 = f34 * (f30 | 2616);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-71, -104, -24, -58, -18, -106, -19, -101}, "b93c5368fda28d1d"));
                    break;
                case 54269283:
                    int i6 = f34 * (f30 | 4965);
                    iM310 = C0002.m317(C0010.decode(new byte[]{-29, -64, -65, -102, -70, -111, -65, -102}, "8dd8a4d830d5", 6));
                    break;
                case 54299972:
                    int i7 = f34 * (f30 | 5649);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-22, -111, -66, -64, -29, -105, -22, -109}, "16ed87", true));
                    break;
                case 54299998:
                    int i8 = f34 * (f30 + 8048);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-20, -112, -65, -112, -30, -63, -19, -99}, "75d29a68e26e0543", 5));
                    break;
                case 54301083:
                    int i9 = f34 * (f30 + 5201);
                    iM310 = C0003.m323(C0010.decode(new byte[]{-71, -58, -18, -51, -19, -7, -29, -55}, "bb5e6f8acedd", 0.0f));
                    break;
                case 54301924:
                    int i10 = f34 * (f30 + 8187);
                    iM310 = C0009.m350(C0010.decode(new byte[]{-24, -110, -18, -106, -19, -103, -66, -63}, "365769ef4834cfa0", false));
                    break;
                case 54306669:
                    int i11 = f34 * (f30 + 415);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-72, -106, -71, -62, -22, -62, -67, -60}, "c7bd1dfb4029101c", 0.0f));
                    break;
                case 54328024:
                    int i12 = f34 * (f30 ^ 6913);
                    iM310 = C0001.m315(C0010.decode(new byte[]{-19, -100, -24, -63, -72, -105, -65, -109}, "683bc6d5", 0.0f));
                    break;
                case 54330011:
                    int i13 = f34 * (f30 ^ 5649);
                    iM310 = C0005.m333(C0010.decode(new byte[]{-20, -105, -66, -99, -72, -61, -20, -111}, "70e8ce", 6));
                    break;
                case 54330722:
                    int i14 = f34 * (f30 | 2736);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-67, -110, -70, -59, -18, -105, -67, -105}, "f5ad57", 2));
                    break;
                case 54330904:
                    int i15 = f34 * (f30 | 288);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-67, -60, -67, -109, -67, -105, -20, -106}, "fef4f473e0ae", 0.0f));
                    break;
                case 54331836:
                    int i16 = f34 * (f30 + 4456);
                    iM310 = C0006.m338(C0010.decode(new byte[]{-30, -111, -65, -107, -22, -51, -71, -62}, "94d41ebe08"));
                    break;
                case 54357657:
                    int i17 = f34 * (f30 ^ 594);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-72, -57, -22, -90, -17, -109, -66, -111}, "cb1945e526"));
                    break;
                case 54389340:
                    int i18 = f34 * (f30 + 1214);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-20, -105, -19, -107, -29, -63, -66, -112}, "72668de3d8a6920a", 6));
                    break;
                case 54391483:
                    int i19 = f34 * (f30 ^ 6572);
                    iM310 = C0004.m329(C0010.decode(new byte[]{-71, -63, -20, -107, -22, -109, -66, -111}, "bb7511e9d4", 0));
                    break;
                case 54392226:
                    int i20 = f34 * (f30 | 6947);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-30, -107, -72, -112, -29, -107, -72, -97}, "92c382c900cd447f", 4));
                    break;
                case 54393369:
                    int i21 = f34 * (f30 + 684);
                    iM310 = C0007.m342(C0010.decode(new byte[]{-65, -102, -22, -107, -65, -102, -21, -108}, "d816d900"));
                    break;
                case 54424894:
                    int i22 = f34 * (f30 + 6901);
                    iM310 = C0008.m347(C0010.decode(new byte[]{-67, -61, -65, -105, -21, -105, -71, -107}, "fbd705b45fbfa2", false));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: ۨۧۦۦ, reason: not valid java name and contains not printable characters */
    public static String m140() {
        int iM338 = C0006.m338(C0010.decode(new byte[]{-17, -110, -18, -111, -67, -99, -17, -108}, "4059f9", 0.0f));
        while (true) {
            switch (iM338) {
                case 54152962:
                    int i = f34 * (f30 + 5967);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-30, -103, -17, -105, -29, -7, -65, -109}, "99468fd6", true));
                    break;
                case 54157026:
                    int i2 = f34 * (f30 | 3406);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-22, -57, -18, -107, -66, -64, -20, -111}, "1c50ec741899ca2d", true));
                    break;
                case 54180775:
                    int i3 = f34 * (f30 ^ 5486);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-18, -81, -66, -97, -72, -98, -65, -102}, "50e8c6d86b4d6c"));
                    break;
                case 54184737:
                    int i4 = f34 * (f30 + 3195);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-24, -111, -65, -97, -21, -111, -23, -64}, "32d9022a", 0.0f));
                    break;
                case 54184899:
                    int i5 = f34 * (f30 ^ 6514);
                    iM338 = C0002.m317(C0010.decode(new byte[]{-18, -61, -66, -111, -17, -57, -20, -2}, "5ce44d7ac6fa85", 2));
                    break;
                case 54213511:
                    int i6 = f34 * (f30 | 6647);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-65, -101, -71, -109, -72, -111, -65, -106}, "d9b0c7d4bc07"));
                    break;
                case 54242493:
                    int i7 = f34 * (f30 + 2900);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-65, -107, -29, -104, -17, -105, -29, -111}, "d0894282c35367f7", 0.0f));
                    break;
                case 54242557:
                    int i8 = f34 * (f30 | 5578);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-29, -90, -23, -58, -65, -106, -30, -84}, "892ed7939a2ca3e6", 0.0f));
                    break;
                case 54247238:
                    int i9 = f34 * (f30 + 4796);
                    iM338 = C0007.m342(C0010.decode(new byte[]{-65, -97, -66, -105, -71, -105, -19, -109}, "d8e1b262c75ee8"));
                    break;
                case 54275073:
                    int i10 = f34 * (f30 ^ 4217);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-30, -109, -20, -61, -18, -105, -23, -99}, "967b542599", 7));
                    break;
                case 54277033:
                    int i11 = f34 * (f30 | 1965);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-22, -108, -17, -107, -70, -103, -22, -58}, "1541a81cbd3842"));
                    break;
                case 54303907:
                    int i12 = f34 * (f30 ^ 4865);
                    iM338 = C0006.m338(C0010.decode(new byte[]{-23, -112, -30, -64, -65, -106, -65, -105}, "249fd3d18fce"));
                    break;
                case 54304931:
                    int i13 = f34 * (f30 ^ 4684);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-23, -100, -72, -57, -24, -112, -66, -7}, "29cc36ef84b12a", 0));
                    break;
                case 54327963:
                    int i14 = f34 * (f30 ^ 6581);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-21, -106, -71, -98, -20, -110, -65, -99}, "05b676d564d9", true));
                    break;
                case 54329857:
                    int i15 = f34 * (f30 | 2034);
                    iM338 = C0008.m347(C0010.decode(new byte[]{-72, -58, -72, -82, -71, -105, -29, -57}, "ccc1b38b103fa5", true));
                    break;
                case 54329914:
                    int i16 = f34 * (f30 ^ 1112);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-67, -104, -65, -99, -30, -60, -22, -86}, "f0d89b1577"));
                    break;
                case 54332824:
                    int i17 = f34 * (f30 ^ 7456);
                    iM338 = C0004.m329(C0010.decode(new byte[]{-22, -51, -70, -109, -23, -109, -22, -58}, "1ea024", 4));
                    break;
                case 54334690:
                    int i18 = f34 * (f30 + 1719);
                    iM338 = C0009.m350(C0010.decode(new byte[]{-17, -97, -19, -64, -71, -100, -67, -60}, "496eb9fa"));
                    break;
                case 54363551:
                    if (m105() < 0) {
                        return m117();
                    }
                    return null;
                case 54394299:
                    int i19 = f34 * (f30 ^ 5102);
                    iM338 = C0005.m333(C0010.decode(new byte[]{-65, -111, -17, -111, -19, -55, -22, -100}, "d3426a18", 7));
                    break;
                case 54421271:
                    int i20 = f34 * (f30 | 7317);
                    iM338 = C0000.m310(C0010.decode(new byte[]{-21, -103, -21, -63, -17, -111, -19, -105}, "090d4961", true));
                    break;
                case 54423158:
                    int i21 = f34 * (f30 ^ 2812);
                    iM338 = C0001.m315(C0010.decode(new byte[]{-70, -107, -23, -110, -19, -64, -23, -57}, "a0246d2b92"));
                    break;
            }
        }
    }
}
