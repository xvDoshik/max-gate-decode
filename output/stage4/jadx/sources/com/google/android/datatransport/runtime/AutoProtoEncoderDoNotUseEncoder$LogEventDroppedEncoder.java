package com.google.android.datatransport.runtime;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder();
    public static final FieldDescriptor EVENTSDROPPEDCOUNT_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{4, 64, 3, 94, 16, 64, 37, 68, 9, 64, 20, 86, 5, 117, 9, 69, 10, 71}, "a6f0d3", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));
    public static final FieldDescriptor REASON_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{17, 87, 89, 75, 94, 87}, "c288196e56a2", 4), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(3))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        LogEventDropped logEventDropped = (LogEventDropped) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(EVENTSDROPPEDCOUNT_DESCRIPTOR, logEventDropped.events_dropped_count_);
        objectEncoderContext.add(REASON_DESCRIPTOR, logEventDropped.reason_);
    }
}
