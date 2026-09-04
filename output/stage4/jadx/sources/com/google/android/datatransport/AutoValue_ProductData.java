package com.google.android.datatransport;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_ProductData {
    public final Integer productId;

    public AutoValue_ProductData(Integer num) {
        this.productId = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_ProductData)) {
            return false;
        }
        Integer num = ((AutoValue_ProductData) obj).productId;
        Integer num2 = this.productId;
        if (num2 == null) {
            return num == null;
        }
        return num2.equals(num);
    }

    public final int hashCode() {
        Integer num = this.productId;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{96, 70, 14, 86, 65, 5, 23, 37, 0, 71, 0, 78, 20, 66, 14, 2, 69, 87, 21, 123, 80, 91}, "04a24fcaa3a5d0af", 0.0f));
        sb.append(this.productId);
        sb.append(C0000.decode(new byte[]{28}, "a1fae7"));
        return sb.toString();
    }
}
