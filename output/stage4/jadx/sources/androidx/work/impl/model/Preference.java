package androidx.work.impl.model;

import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Preference {
    public final String key;
    public final Long value;

    public Preference(String str, Long l) {
        this.key = str;
        this.value = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return Intrinsics.areEqual(this.key, preference.key) && Intrinsics.areEqual(this.value, preference.value);
    }

    public final int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        Long l = this.value;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{50, 16, 86, 83, 85, 67, 0, 15, 7, 82, 76, 93, 7, 27, 14}, "bb3501ead7d6", false));
        sb.append(this.key);
        sb.append(C0000.decode(new byte[]{77, 66, 19, 7, 85, 77, 81, 14}, "abef98434ac0f10c"));
        sb.append(this.value);
        sb.append(')');
        return sb.toString();
    }
}
