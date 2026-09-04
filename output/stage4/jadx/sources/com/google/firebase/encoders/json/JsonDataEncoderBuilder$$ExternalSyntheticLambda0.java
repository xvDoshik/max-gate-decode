package com.google.firebase.encoders.json;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.ProtobufDataEncoderContext;
import java.util.Map;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class JsonDataEncoderBuilder$$ExternalSyntheticLambda0 implements ObjectEncoder {
    public final /* synthetic */ int $r8$classId;

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                throw new EncodingException(C0000.decode(new byte[]{117, 90, 23, 89, 87, 12, 17, 65, 66, 83, 90, 12, 82, 21, 7, 91, 80, 13, 82, 80, 16, 21, 85, 13, 68, 21, 22, 76, 67, 7, 22}, "65b53b", true) + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
                objectEncoderContext.add(ProtobufDataEncoderContext.MAP_KEY_DESC, entry.getKey());
                objectEncoderContext.add(ProtobufDataEncoderContext.MAP_VALUE_DESC, entry.getValue());
                return;
            default:
                throw new EncodingException(C0000.decode(new byte[]{38, 87, 17, 95, 0, 11, 30, 65, 69, 94, 13, 93, 0, 69, 92, 91, 6, 87, 0, 86, 22, 69, 95, 90, 23, 24, 16, 74, 20, 0, 25}, "e8d3de95", 0.0f) + obj.getClass().getCanonicalName());
        }
    }
}
