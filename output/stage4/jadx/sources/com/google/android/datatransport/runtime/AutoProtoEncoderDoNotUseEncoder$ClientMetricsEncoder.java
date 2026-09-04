package com.google.android.datatransport.runtime;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder();
    public static final FieldDescriptor WINDOW_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{79, 92, 11, 80, 14, 79}, "85e4a869ef223f", 7), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));
    public static final FieldDescriptor LOGSOURCEMETRICS_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{88, 14, 86, 55, 86, 64, 70, 2, 84, 41, 92, 65, 70, 8, 82, 23}, "4a1d95"), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2))));
    public static final FieldDescriptor GLOBALMETRICS_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{5, 84, 92, 4, 87, 91, 117, 1, 64, 74, 90, 84, 70}, "b83f678d483759", 3), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(3))));
    public static final FieldDescriptor APPNAMESPACE_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{86, 72, 73, 43, 80, 85, 82, 22, 73, 88, 86, 81}, "789e187e995423f5"), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(4))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ClientMetrics clientMetrics = (ClientMetrics) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(WINDOW_DESCRIPTOR, clientMetrics.window_);
        objectEncoderContext.add(LOGSOURCEMETRICS_DESCRIPTOR, clientMetrics.log_source_metrics_);
        objectEncoderContext.add(GLOBALMETRICS_DESCRIPTOR, clientMetrics.global_metrics_);
        objectEncoderContext.add(APPNAMESPACE_DESCRIPTOR, clientMetrics.app_namespace_);
    }
}
