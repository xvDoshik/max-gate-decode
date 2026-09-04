package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import p000.C0000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class QosTier {
    public static final /* synthetic */ QosTier[] $VALUES;
    public static final QosTier DEFAULT;

    static {
        QosTier qosTier = new QosTier(C0000.decode(new byte[]{34, 114, 36, 37, 55, 120, 97}, "f7bdb459", 5), 0);
        DEFAULT = qosTier;
        QosTier qosTier2 = new QosTier(C0000.decode(new byte[]{97, 121, 125, 116, 55, 36, 52, 124, 37, 60, 121, 124, 120, 110}, "4701caf9ac62", 0.0f), 1);
        QosTier qosTier3 = new QosTier(C0000.decode(new byte[]{109, 126, 40, 36, 54, 38, 107, 35, 124, 111, 42, 51, 61, 39, 120, 47, 116, 105}, "80eabc9f", 0.0f), 2);
        QosTier qosTier4 = new QosTier(C0000.decode(new byte[]{35, 120, 97, 48, 58, 121, 35, 102, 96, 37, 33, 121, 42, 102, 115, 51, 36, 123, 32}, "e92de0"), 3);
        QosTier qosTier5 = new QosTier(C0000.decode(new byte[]{120, 114, 100, 117, 102}, "6720460989011c58", true), 4);
        QosTier qosTier6 = new QosTier(C0000.decode(new byte[]{96, 122, 106, 116, 33, 41, 114, 122, 113, 107, 39, 34}, "5481bf", 6), 5);
        $VALUES = new QosTier[]{qosTier, qosTier2, qosTier3, qosTier4, qosTier5, qosTier6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, qosTier);
        sparseArray.put(1, qosTier2);
        sparseArray.put(2, qosTier3);
        sparseArray.put(3, qosTier4);
        sparseArray.put(4, qosTier5);
        sparseArray.put(-1, qosTier6);
    }

    public static QosTier valueOf(String str) {
        return (QosTier) Enum.valueOf(QosTier.class, str);
    }

    public static QosTier[] values() {
        return (QosTier[]) $VALUES.clone();
    }
}
