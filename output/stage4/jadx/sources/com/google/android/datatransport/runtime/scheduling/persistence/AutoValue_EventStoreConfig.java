package com.google.android.datatransport.runtime.scheduling.persistence;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_EventStoreConfig {
    public static final AutoValue_EventStoreConfig DEFAULT = new AutoValue_EventStoreConfig(10485760, 200, 10000, 604800000, 81920);
    public final int criticalSectionEnterTimeoutMs;
    public final long eventCleanUpAge;
    public final int loadBatchSize;
    public final int maxBlobByteSizePerRow;
    public final long maxStorageSizeInBytes;

    public AutoValue_EventStoreConfig(long j, int i, int i2, long j2, int i3) {
        this.maxStorageSizeInBytes = j;
        this.loadBatchSize = i;
        this.criticalSectionEnterTimeoutMs = i2;
        this.eventCleanUpAge = j2;
        this.maxBlobByteSizePerRow = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_EventStoreConfig) {
            AutoValue_EventStoreConfig autoValue_EventStoreConfig = (AutoValue_EventStoreConfig) obj;
            if (this.maxStorageSizeInBytes == autoValue_EventStoreConfig.maxStorageSizeInBytes && this.loadBatchSize == autoValue_EventStoreConfig.loadBatchSize && this.criticalSectionEnterTimeoutMs == autoValue_EventStoreConfig.criticalSectionEnterTimeoutMs && this.eventCleanUpAge == autoValue_EventStoreConfig.eventCleanUpAge && this.maxBlobByteSizePerRow == autoValue_EventStoreConfig.maxBlobByteSizePerRow) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.maxStorageSizeInBytes;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.loadBatchSize) * 1000003) ^ this.criticalSectionEnterTimeoutMs) * 1000003;
        long j2 = this.eventCleanUpAge;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.maxBlobByteSizePerRow;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{38, 66, 82, 13, 76, 54, 17, 10, 64, 6, 32, 91, 89, 5, 81, 2, 30, 8, 83, 27, 48, 64, 88, 17, 89, 2, 0, 54, 91, 25, 6, 125, 89, 33, 65, 17, 0, 22, 15}, "c47c8eee2c", 4));
        sb.append(this.maxStorageSizeInBytes);
        sb.append(C0000.decode(new byte[]{77, 20, 8, 88, 84, 0, 35, 89, 22, 84, 89, 98, 8, 25, 86, 94}, "a4d75da8b711ac3c", 0));
        sb.append(this.loadBatchSize);
        sb.append(C0000.decode(new byte[]{74, 70, 0, 68, 95, 23, 81, 87, 87, 88, 53, 85, 82, 76, 15, 9, 13, 115, 88, 23, 93, 70, 98, 93, 11, 85, 94, 77, 18, 43, 16, 11}, "ffc66c8464f018"));
        sb.append(this.criticalSectionEnterTimeoutMs);
        sb.append(C0000.decode(new byte[]{24, 23, 6, 23, 83, 93, 16, 116, 85, 3, 85, 89, 54, 17, 119, 84, 1, 10}, "47ca63d79f", 4));
        sb.append(this.eventCleanUpAge);
        sb.append(C0000.decode(new byte[]{20, 23, 93, 0, 30, 33, 8, 87, 82, 115, 27, 76, 86, 49, 91, 75, 93, 103, 85, 19, 52, 12, 19, 5}, "870afcd801b83b21"));
        sb.append(this.maxBlobByteSizePerRow);
        sb.append(C0000.decode(new byte[]{69}, "81d183", 0.0f));
        return sb.toString();
    }
}
