package p000.p001;

/* JADX INFO: renamed from: ۦ۟ۤ.ۡۨ.ۤۧۧ۠۠, reason: contains not printable characters */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage3/dex/classes.dex */
public class C0001 {
    public static String decode(byte[] bArr, String str) {
        int length = bArr.length;
        int length2 = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i % length2));
        }
        return new String(bArr);
    }

    public static String decode(byte[] bArr, String str, double d) {
        int length = bArr.length;
        int length2 = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i % length2));
        }
        return new String(bArr);
    }

    public static String decode(byte[] bArr, String str, float f) {
        int length = bArr.length;
        int length2 = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i % length2));
        }
        return new String(bArr);
    }

    public static String decode(byte[] bArr, String str, int i) {
        int length = bArr.length;
        int length2 = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ str.charAt(i2 % length2));
        }
        return new String(bArr);
    }

    public static String decode(byte[] bArr, String str, long j) {
        int length = bArr.length;
        int length2 = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i % length2));
        }
        return new String(bArr);
    }

    public static String decode(byte[] bArr, String str, boolean z) {
        int length = bArr.length;
        int length2 = str.length();
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArr[i] ^ str.charAt(i % length2));
        }
        return new String(bArr);
    }
}
