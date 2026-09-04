package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ProtobufValueEncoderContext implements ValueEncoderContext {
    public FieldDescriptor field;
    public final ProtobufDataEncoderContext objEncoderCtx;
    public boolean encoded = false;
    public boolean skipDefault = false;

    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) {
        if (this.encoded) {
            throw new EncodingException(C0000.decode(new byte[]{123, 82, 95, 8, 92, 77, 22, 84, 86, 80, 94, 2, 86, 25, 87, 17, 75, 86, 82, 9, 93, 93, 22, 71, 89, 95, 68, 3, 19, 80, 88, 17, 76, 91, 84, 70, 101, 88, 90, 68, 93, 118, 95, 5, 92, 93, 83, 67, 123, 92, 95, 18, 86, 65, 66}, "831f3961", 1));
        }
        this.encoded = true;
        this.objEncoderCtx.add(this.field, str, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) {
        if (this.encoded) {
            throw new EncodingException(C0000.decode(new byte[]{116, 4, 15, 11, 10, 64, 23, 7, 86, 91, 90, 7, 82, 69, 0, 69, 22, 81, 84, 13, 86, 92, 21, 21, 86, 9, 20, 0, 69, 93, 89, 66, 76, 80, 80, 67, 97, 4, 13, 16, 0, 113, 89, 1, 87, 92, 80, 17, 116, 10, 15, 17, 0, 76, 67}, "7eaee47b885c", 0.0f));
        }
        this.encoded = true;
        this.objEncoderCtx.add(this.field, z ? 1 : 0, this.skipDefault);
        return this;
    }
}
