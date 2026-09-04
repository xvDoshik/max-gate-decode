package com.google.firebase.platforminfo;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_LibraryVersion {
    public final String libraryName;
    public final String version;

    public AutoValue_LibraryVersion(String str, String str2) {
        this.libraryName = str;
        if (str2 == null) {
            throw new NullPointerException(C0000.decode(new byte[]{125, 64, 91, 85, 25, 64, 80, 64, 64, 92, 88, 87}, "35799652", 0.0f));
        }
        this.version = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_LibraryVersion) {
            AutoValue_LibraryVersion autoValue_LibraryVersion = (AutoValue_LibraryVersion) obj;
            if (this.libraryName.equals(autoValue_LibraryVersion.libraryName) && this.version.equals(autoValue_LibraryVersion.version)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.libraryName.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{126, 80, 82, 69, 89, 64, 75, 103, 86, 64, 65, 80, 95, 89, 67, 94, 91, 83, 65, 83, 64, 64, 126, 86, 85, 87, 15}, "2907822132", 7));
        sb.append(this.libraryName);
        sb.append(C0000.decode(new byte[]{72, 67, 19, 82, 64, 65, 13, 12, 11, 10}, "dce722", false));
        return FileSectionType$EnumUnboxingLocalUtility.m(sb, this.version, C0000.decode(new byte[]{24}, "e13ba709ecfa", 0.0f));
    }
}
