package com.google.android.datatransport.runtime;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder();
    public static final FieldDescriptor STARTMS_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{65, 67, 4, 74, 22, 44, 64}, "27e8ba31d0", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));
    public static final FieldDescriptor ENDMS_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{4, 10, 6, 123, 64}, "adb63a510cd1", false), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        TimeWindow timeWindow = (TimeWindow) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(STARTMS_DESCRIPTOR, timeWindow.start_ms_);
        objectEncoderContext.add(ENDMS_DESCRIPTOR, timeWindow.end_ms_);
    }
}
