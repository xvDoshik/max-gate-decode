package androidx.profileinstaller;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract /* synthetic */ class FileSectionType$EnumUnboxingLocalUtility {
    public static final /* synthetic */ int[] $VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    public static /* synthetic */ boolean equals(int i, int i2) {
        if (i != 0) {
            return i == i2;
        }
        throw null;
    }

    public static String m(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static /* synthetic */ int ordinal(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] values(int i) {
        int[] iArr = new int[i];
        System.arraycopy($VALUES, 0, iArr, 0, i);
        return iArr;
    }
}
