package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class NetworkConnectionInfo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public final class MobileSubtype {
        public static final /* synthetic */ MobileSubtype[] $VALUES;
        public static final SparseArray valueMap;

        /* JADX INFO: Fake field, exist only in values array */
        MobileSubtype EF1;

        static {
            MobileSubtype mobileSubtype = new MobileSubtype(C0000.decode(new byte[]{101, 120, 124, 45, 124, 96, 118, 103, 121, 121, 117, 43, 124, 115, 104, 48, 102, 117, 108, 97, 100, 115}, "067c3788467b", 5), 0);
            MobileSubtype mobileSubtype2 = new MobileSubtype(C0000.decode(new byte[]{119, 49, 107, 54}, "0a9e5d62c7e0"), 1);
            MobileSubtype mobileSubtype3 = new MobileSubtype(C0000.decode(new byte[]{32, 115, 34, 115}, "e7e64787ceae881b", 0.0f), 2);
            MobileSubtype mobileSubtype4 = new MobileSubtype(C0000.decode(new byte[]{52, 120, 48, 96}, "a5d3a1e463"), 3);
            MobileSubtype mobileSubtype5 = new MobileSubtype(C0000.decode(new byte[]{33, 114, 126, 118}, "b6371f02", 7), 4);
            MobileSubtype mobileSubtype6 = new MobileSubtype(C0000.decode(new byte[]{113, 110, 39, 119, 58, 6}, "48c8e6ceb0", 0.0f), 5);
            MobileSubtype mobileSubtype7 = new MobileSubtype(C0000.decode(new byte[]{35, 51, 116, 44, 58, 32}, "fe0cea9370819a55", 4), 6);
            MobileSubtype mobileSubtype8 = new MobileSubtype(C0000.decode(new byte[]{101, 109, 49}, "79e49f304599"), 7);
            MobileSubtype mobileSubtype9 = new MobileSubtype(C0000.decode(new byte[]{126, 54, 116, 99, 112}, "6e0319e021"), 8);
            MobileSubtype mobileSubtype10 = new MobileSubtype(C0000.decode(new byte[]{122, 101, 52, 100, 37}, "26a4d093f03f", 0), 9);
            MobileSubtype mobileSubtype11 = new MobileSubtype(C0000.decode(new byte[]{121, 55, 99, 112}, "1d3160ee544470", 5), 10);
            MobileSubtype mobileSubtype12 = new MobileSubtype(C0000.decode(new byte[]{42, 114, 116, 42}, "c61d1976e88e10"), 11);
            MobileSubtype mobileSubtype13 = new MobileSubtype(C0000.decode(new byte[]{32, 99, 118, 120, 108, 115}, "e52731b53c", 0.0f), 12);
            MobileSubtype mobileSubtype14 = new MobileSubtype(C0000.decode(new byte[]{40, 96, 32}, "d4e927", 0.0f), 13);
            MobileSubtype mobileSubtype15 = new MobileSubtype(C0000.decode(new byte[]{117, 43, 97, 52, 125}, "0c3d9c9c164c6739", 5), 14);
            MobileSubtype mobileSubtype16 = new MobileSubtype(C0000.decode(new byte[]{113, 107, 101, 39, 102}, "985f69874bac"), 15);
            MobileSubtype mobileSubtype17 = new MobileSubtype(C0000.decode(new byte[]{115, 53, 125}, "4f0398431d507965", false), 16);
            MobileSubtype mobileSubtype18 = new MobileSubtype(C0000.decode(new byte[]{49, 39, 62, 49, 115, 113, 127, 35}, "ecab052b9adc3b", false), 17);
            MobileSubtype mobileSubtype19 = new MobileSubtype(C0000.decode(new byte[]{113, 102, 42, 120, 119}, "81f9901bf9c1", 0.0f), 18);
            MobileSubtype mobileSubtype20 = new MobileSubtype(C0000.decode(new byte[]{40, 50, 119, 109, 118, 37}, "df225d", 0.0f), 19);
            $VALUES = new MobileSubtype[]{mobileSubtype, mobileSubtype2, mobileSubtype3, mobileSubtype4, mobileSubtype5, mobileSubtype6, mobileSubtype7, mobileSubtype8, mobileSubtype9, mobileSubtype10, mobileSubtype11, mobileSubtype12, mobileSubtype13, mobileSubtype14, mobileSubtype15, mobileSubtype16, mobileSubtype17, mobileSubtype18, mobileSubtype19, mobileSubtype20, new MobileSubtype(C0000.decode(new byte[]{112, 119, 44, 32, 42, 125, 117, 37}, "38abc30a72d7", false), 20)};
            SparseArray sparseArray = new SparseArray();
            valueMap = sparseArray;
            sparseArray.put(0, mobileSubtype);
            sparseArray.put(1, mobileSubtype2);
            sparseArray.put(2, mobileSubtype3);
            sparseArray.put(3, mobileSubtype4);
            sparseArray.put(4, mobileSubtype5);
            sparseArray.put(5, mobileSubtype6);
            sparseArray.put(6, mobileSubtype7);
            sparseArray.put(7, mobileSubtype8);
            sparseArray.put(8, mobileSubtype9);
            sparseArray.put(9, mobileSubtype10);
            sparseArray.put(10, mobileSubtype11);
            sparseArray.put(11, mobileSubtype12);
            sparseArray.put(12, mobileSubtype13);
            sparseArray.put(13, mobileSubtype14);
            sparseArray.put(14, mobileSubtype15);
            sparseArray.put(15, mobileSubtype16);
            sparseArray.put(16, mobileSubtype17);
            sparseArray.put(17, mobileSubtype18);
            sparseArray.put(18, mobileSubtype19);
            sparseArray.put(19, mobileSubtype20);
        }

        public static MobileSubtype valueOf(String str) {
            return (MobileSubtype) Enum.valueOf(MobileSubtype.class, str);
        }

        public static MobileSubtype[] values() {
            return (MobileSubtype[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public final class NetworkType {
        public static final /* synthetic */ NetworkType[] $VALUES;
        public static final SparseArray valueMap;

        /* JADX INFO: Fake field, exist only in values array */
        NetworkType EF1;

        static {
            NetworkType networkType = new NetworkType(C0000.decode(new byte[]{123, 124, 32, 113, 126, 112}, "63b82589c5b45e", 0.0f), 0);
            NetworkType networkType2 = new NetworkType(C0000.decode(new byte[]{101, 45, 117, 40}, "2d3a3349", 1), 1);
            NetworkType networkType3 = new NetworkType(C0000.decode(new byte[]{121, 120, 38, 47, 40, 112, 103, 123, 121, 100}, "47dfd586", 1), 2);
            NetworkType networkType4 = new NetworkType(C0000.decode(new byte[]{41, 125, 39, 126, 41, 125, 61, 49, 52, 100, 124}, "d2e7e8bba403"), 3);
            NetworkType networkType5 = new NetworkType(C0000.decode(new byte[]{123, 124, 117, 45, 125, 119, 103, 33, 51, 45}, "637d128efc4c", true), 4);
            NetworkType networkType6 = new NetworkType(C0000.decode(new byte[]{127, 124, 119, 122, 126, 114, 60, 122, 43, 102, 97, 121}, "235327c2b630a4"), 5);
            NetworkType networkType7 = new NetworkType(C0000.decode(new byte[]{52, 121, 117, 112, 111}, "c081702b87", 0.0f), 6);
            NetworkType networkType8 = new NetworkType(C0000.decode(new byte[]{116, 40, 96, 117, 98, 46, 41, 101, 126}, "6d506af1", true), 7);
            NetworkType networkType9 = new NetworkType(C0000.decode(new byte[]{33, 109, 121, 44, 105}, "e84a0d6022", false), 8);
            NetworkType networkType10 = new NetworkType(C0000.decode(new byte[]{124, 96, 121, 39, 97, 118, 124, 96}, "941b38", false), 9);
            NetworkType networkType11 = new NetworkType(C0000.decode(new byte[]{116, 126, 122, 43, 42, 116, 106, 115, 118, 101, 121}, "918bf155", 6), 10);
            NetworkType networkType12 = new NetworkType(C0000.decode(new byte[]{116, 126, 113, 121, 124, 32, 106, 43, 47, 102}, "91300e5bb56106", 0.0f), 11);
            NetworkType networkType13 = new NetworkType(C0000.decode(new byte[]{116, 124, 118, 123, 125, 118, 61, 32, 123, 96}, "934213bc"), 12);
            NetworkType networkType14 = new NetworkType(C0000.decode(new byte[]{98, 44, 36, 113, 111, 100, 3, 103}, "5eb80417", 4), 13);
            NetworkType networkType15 = new NetworkType(C0000.decode(new byte[]{44, 126, 112, 47, 120, 114, 57, 127, 36}, "a12f47f6eff7a51a", 2), 14);
            NetworkType networkType16 = new NetworkType(C0000.decode(new byte[]{116, 122, 123, 42, 127, 32, 104, 117, 120, 119, 101, 37, 38, 123, 114, 110}, "959c3e70527bc517", 0.0f), 15);
            NetworkType networkType17 = new NetworkType(C0000.decode(new byte[]{52, 99, 41, 105, 108}, "d1f15538db", 5), 16);
            NetworkType networkType18 = new NetworkType(C0000.decode(new byte[]{52, 102, 124}, "b62917", 0), 17);
            NetworkType networkType19 = new NetworkType(C0000.decode(new byte[]{43, 121, 40, 39}, "e6fbf1c5c7d8", 2), 18);
            $VALUES = new NetworkType[]{networkType, networkType2, networkType3, networkType4, networkType5, networkType6, networkType7, networkType8, networkType9, networkType10, networkType11, networkType12, networkType13, networkType14, networkType15, networkType16, networkType17, networkType18, networkType19};
            SparseArray sparseArray = new SparseArray();
            valueMap = sparseArray;
            sparseArray.put(0, networkType);
            sparseArray.put(1, networkType2);
            sparseArray.put(2, networkType3);
            sparseArray.put(3, networkType4);
            sparseArray.put(4, networkType5);
            sparseArray.put(5, networkType6);
            sparseArray.put(6, networkType7);
            sparseArray.put(7, networkType8);
            sparseArray.put(8, networkType9);
            sparseArray.put(9, networkType10);
            sparseArray.put(10, networkType11);
            sparseArray.put(11, networkType12);
            sparseArray.put(12, networkType13);
            sparseArray.put(13, networkType14);
            sparseArray.put(14, networkType15);
            sparseArray.put(15, networkType16);
            sparseArray.put(16, networkType17);
            sparseArray.put(17, networkType18);
            sparseArray.put(-1, networkType19);
        }

        public static NetworkType valueOf(String str) {
            return (NetworkType) Enum.valueOf(NetworkType.class, str);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }
    }
}
