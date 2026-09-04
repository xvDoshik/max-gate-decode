package com.google.android.datatransport;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Encoding {
    public final String name;

    public Encoding(String str) {
        if (str == null) {
            throw new NullPointerException(C0000.decode(new byte[]{91, 5, 93, 81, 69, 15, 22, 21, 10, 65, 90, 94}, "5d04efe5d462d29f", false));
        }
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.name.equals(((Encoding) obj).name);
    }

    public final int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    public final String toString() {
        return FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(C0000.decode(new byte[]{112, 87, 85, 90, 1, 91, 92, 82, 72, 87, 0, 8, 80, 4, 20}, "5965e22539ae", true)), this.name, C0000.decode(new byte[]{71, 78}, "e3e8a7f1a5e41d", true));
    }
}
