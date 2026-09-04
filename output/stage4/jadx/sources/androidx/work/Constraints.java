package androidx.work;

import android.net.Uri;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Constraints {
    public static final Constraints NONE = new Constraints(1, false, false, false, false, -1, -1, EmptySet.INSTANCE);
    public final long contentTriggerMaxDelayMillis;
    public final long contentTriggerUpdateDelayMillis;
    public final Set contentUriTriggers;
    public final int requiredNetworkType;
    public final boolean requiresBatteryNotLow;
    public final boolean requiresCharging;
    public final boolean requiresDeviceIdle;
    public final boolean requiresStorageNotLow;

    public final class ContentUriTrigger {
        public final boolean isTriggeredForDescendants;
        public final Uri uri;

        public ContentUriTrigger(Uri uri, boolean z) {
            this.uri = uri;
            this.isTriggeredForDescendants = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!ContentUriTrigger.class.equals(obj != null ? obj.getClass() : null)) {
                return false;
            }
            ContentUriTrigger contentUriTrigger = (ContentUriTrigger) obj;
            return Intrinsics.areEqual(this.uri, contentUriTrigger.uri) && this.isTriggeredForDescendants == contentUriTrigger.isTriggeredForDescendants;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.isTriggeredForDescendants) + (this.uri.hashCode() * 31);
        }
    }

    public Constraints(int i, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, Set set) {
        this.requiredNetworkType = i;
        this.requiresCharging = z;
        this.requiresDeviceIdle = z2;
        this.requiresBatteryNotLow = z3;
        this.requiresStorageNotLow = z4;
        this.contentTriggerUpdateDelayMillis = j;
        this.contentTriggerMaxDelayMillis = j2;
        this.contentUriTriggers = set;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Constraints.class.equals(obj.getClass())) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.requiresCharging == constraints.requiresCharging && this.requiresDeviceIdle == constraints.requiresDeviceIdle && this.requiresBatteryNotLow == constraints.requiresBatteryNotLow && this.requiresStorageNotLow == constraints.requiresStorageNotLow && this.contentTriggerUpdateDelayMillis == constraints.contentTriggerUpdateDelayMillis && this.contentTriggerMaxDelayMillis == constraints.contentTriggerMaxDelayMillis && this.requiredNetworkType == constraints.requiredNetworkType) {
            return Intrinsics.areEqual(this.contentUriTriggers, constraints.contentUriTriggers);
        }
        return false;
    }

    public final int hashCode() {
        int iOrdinal = ((((((((FileSectionType$EnumUnboxingLocalUtility.ordinal(this.requiredNetworkType) * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31;
        long j = this.contentTriggerUpdateDelayMillis;
        int i = (iOrdinal + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.contentTriggerMaxDelayMillis;
        return this.contentUriTriggers.hashCode() + ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{116, 93, 93, 22, 68, 23, 86, 91, 93, 17, 67, 30, 69, 87, 66, 16, 89, 23, 82, 86, 125, 0, 68, 18, 88, 64, 88, 49, 73, 21, 82, 15}, "723e0e", true));
        sb.append(NetworkType$EnumUnboxingLocalUtility.stringValueOf(this.requiredNetworkType));
        sb.append(C0000.decode(new byte[]{31, 19, 20, 81, 18, 22, 13, 68, 82, 16, 123, 88, 85, 74, 81, 80, 93, 84, 91}, "33f4ccd67c804869", 0.0f));
        sb.append(this.requiresCharging);
        sb.append(C0000.decode(new byte[]{79, 21, 23, 85, 67, 76, 93, 69, 6, 70, 33, 85, 68, 80, 87, 82, 42, 81, 9, 85, 15}, "c5e02947", 4));
        sb.append(this.requiresDeviceIdle);
        sb.append(C0000.decode(new byte[]{77, 67, 66, 83, 69, 77, 90, 75, 87, 17, 35, 2, 68, 66, 81, 74, 74, 119, 93, 22, 45, 12, 71, 11}, "ac0648392b", 0.0f));
        sb.append(this.requiresBatteryNotLow);
        sb.append(C0000.decode(new byte[]{26, 67, 69, 81, 64, 23, 89, 19, 83, 16, 100, 64, 94, 16, 81, 6, 83, 45, 88, 64, 125, 13, 71, 92}, "6c741b0a", true));
        sb.append(this.requiresStorageNotLow);
        sb.append(C0000.decode(new byte[]{31, 18, 1, 91, 10, 22, 1, 93, 71, 102, 16, 93, 3, 5, 1, 65, 102, 66, 6, 85, 16, 7, 32, 86, 95, 83, 27, 121, 13, 14, 8, 90, 64, 15}, "32b4dbd3", 2));
        sb.append(this.contentTriggerUpdateDelayMillis);
        sb.append(C0000.decode(new byte[]{77, 65, 90, 10, 95, 71, 80, 91, 70, 54, 16, 80, 81, 81, 4, 19, 116, 4, 73, 119, 80, 89, 83, 27, 47, 80, 90, 90, 8, 18, 4}, "aa9e13552bb966", 3));
        sb.append(this.contentTriggerMaxDelayMillis);
        sb.append(C0000.decode(new byte[]{73, 69, 6, 89, 95, 69, 80, 94, 69, 51, 19, 94, 49, 23, 12, 81, 86, 84, 71, 67, 12}, "eee611501fa7", 0.0f));
        sb.append(this.contentUriTriggers);
        sb.append(C0000.decode(new byte[]{31, 22, 31}, "36b141582ad5", 0));
        return sb.toString();
    }

    public Constraints(Constraints constraints) {
        this.requiresCharging = constraints.requiresCharging;
        this.requiresDeviceIdle = constraints.requiresDeviceIdle;
        this.requiredNetworkType = constraints.requiredNetworkType;
        this.requiresBatteryNotLow = constraints.requiresBatteryNotLow;
        this.requiresStorageNotLow = constraints.requiresStorageNotLow;
        this.contentUriTriggers = constraints.contentUriTriggers;
        this.contentTriggerUpdateDelayMillis = constraints.contentTriggerUpdateDelayMillis;
        this.contentTriggerMaxDelayMillis = constraints.contentTriggerMaxDelayMillis;
    }
}
