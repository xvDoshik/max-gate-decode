package com.google.android.datatransport.runtime;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder();

    static {
        FieldDescriptor.of(C0000.decode(new byte[]{85, 10, 8, 84, 11, 18, 127, 86, 17, 74, 8, 81, 75}, "6fa1ef23e8a280"));
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        obj.getClass();
        throw new ClassCastException();
    }
}
