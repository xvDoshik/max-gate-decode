package kotlin;

import kotlin.ranges.IntRange;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class KotlinVersion implements Comparable {
    public static final KotlinVersion CURRENT = new KotlinVersion();
    public final int version;

    public KotlinVersion() {
        if (!new IntRange(0, 255, 1).contains(1) || !new IntRange(0, 255, 1).contains(9) || !new IntRange(0, 255, 1).contains(10)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{51, 7, 20, 69, 89, 10, 87, 24, 6, 13, 11, 70, 95, 11, 92, 86, 17, 17, 70, 87, 66, 0, 25, 87, 16, 22, 70, 89, 86, 69, 75, 89, 11, 5, 3, 12, 16, 84, 23, 1, 75, 83, 86}, "ebf60e98", true).toString());
        }
        this.version = 67850;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        KotlinVersion kotlinVersion = (KotlinVersion) obj;
        return this.version - kotlinVersion.version;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        return kotlinVersion != null && this.version == kotlinVersion.version;
    }

    public final int hashCode() {
        return this.version;
    }

    public final String toString() {
        return C0000.decode(new byte[]{0, 30, 13, 74, 84, 82}, "104deb");
    }
}
