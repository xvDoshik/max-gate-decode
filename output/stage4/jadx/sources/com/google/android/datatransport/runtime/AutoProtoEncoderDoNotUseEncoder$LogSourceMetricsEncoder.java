package com.google.android.datatransport.runtime;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder();
    public static final FieldDescriptor LOGSOURCE_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{10, 14, 3, 54, 10, 77, 22, 82, 87}, "fadee8d12acfb931"), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));
    public static final FieldDescriptor LOGEVENTDROPPED_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{90, 13, 80, 117, 16, 83, 12, 22, 115, 16, 12, 66, 18, 4, 82}, "6b70f6bb7bc2ba"), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        LogSourceMetrics logSourceMetrics = (LogSourceMetrics) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, logSourceMetrics.log_source_);
        objectEncoderContext.add(LOGEVENTDROPPED_DESCRIPTOR, logSourceMetrics.log_event_dropped_);
    }
}
