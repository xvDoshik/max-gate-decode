package com.google.firebase.encoders.proto;

import p000.C0000;

/* JADX WARN: Method from annotation default annotation not found: intEncoding */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public @interface Protobuf {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public final class IntEncoding {
        public static final /* synthetic */ IntEncoding[] $VALUES;
        public static final IntEncoding DEFAULT;

        static {
            IntEncoding intEncoding = new IntEncoding(C0000.decode(new byte[]{125, 112, 119, 32, 48, 125, 102}, "951ae126fa", 0.0f), 0);
            DEFAULT = intEncoding;
            $VALUES = new IntEncoding[]{intEncoding, new IntEncoding(C0000.decode(new byte[]{53, 125, 37, 43, 114, 114}, "f4be765c"), 1), new IntEncoding(C0000.decode(new byte[]{35, 123, 61, 113, 37}, "e2e4aa", 0), 2)};
        }

        public static IntEncoding valueOf(String str) {
            return (IntEncoding) Enum.valueOf(IntEncoding.class, str);
        }

        public static IntEncoding[] values() {
            return (IntEncoding[]) $VALUES.clone();
        }
    }
}
