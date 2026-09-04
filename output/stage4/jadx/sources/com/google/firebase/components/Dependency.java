package com.google.firebase.components;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Dependency {
    public final Qualified anInterface;
    public final int injection;
    public final int type;

    public Dependency(Class cls, int i, int i2) {
        this(Qualified.unqualified(cls), i, i2);
    }

    public static Dependency required(Class cls) {
        return new Dependency(cls, 1, 0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        return this.anInterface.equals(dependency.anInterface) && this.type == dependency.type && this.injection == dependency.injection;
    }

    public final int hashCode() {
        return ((((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ this.type) * 1000003) ^ this.injection;
    }

    public final String toString() {
        String strDecode;
        String strDecode2;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{114, 93, 20, 1, 93, 80, 3, 95, 85, 65, 31, 5, 93, 125, 8, 69, 83, 74, 2, 5, 80, 81, 91}, "68dd34f1", 0.0f));
        sb.append(this.anInterface);
        sb.append(C0000.decode(new byte[]{26, 65, 68, 27, 64, 4, 10}, "6a0b0a7900"));
        int i = this.type;
        if (i == 1) {
            strDecode = C0000.decode(new byte[]{74, 1, 19, 22, 12, 67, 4, 81}, "8dbce1a5048b", false);
        } else {
            strDecode = i == 0 ? C0000.decode(new byte[]{94, 68, 77, 12, 12, 86, 88, 8}, "149ec89d2e1186f4", true) : C0000.decode(new byte[]{65, 83, 70}, "262e5b92", 0.0f);
        }
        sb.append(strDecode);
        sb.append(C0000.decode(new byte[]{27, 20, 92, 11, 95, 93, 5, 21, 13, 13, 88, 10}, "745e58fadb67a6"));
        int i2 = this.injection;
        if (i2 == 0) {
            strDecode2 = C0000.decode(new byte[]{82, 94, 75, 7, 82, 68}, "679b10");
        } else if (i2 == 1) {
            strDecode2 = C0000.decode(new byte[]{73, 68, 13, 79, 91, 83, 4, 17}, "96b927ac7536");
        } else {
            if (i2 != 2) {
                throw new AssertionError(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{96, 8, 68, 65, 67, 19, 11, 64, 65, 93, 82, 69, 92, 8, 93, 81, 80, 23, 13, 93, 91, 2, 22}, "5f743cd2586e", 0.0f), i2));
            }
            strDecode2 = C0000.decode(new byte[]{87, 1, 81, 1, 23, 23, 81, 83}, "3d7dee47af", 0);
        }
        return FileSectionType$EnumUnboxingLocalUtility.m(sb, strDecode2, C0000.decode(new byte[]{72}, "513f9271c0df77", true));
    }

    public Dependency(Qualified qualified, int i, int i2) {
        this.anInterface = qualified;
        this.type = i;
        this.injection = i2;
    }
}
