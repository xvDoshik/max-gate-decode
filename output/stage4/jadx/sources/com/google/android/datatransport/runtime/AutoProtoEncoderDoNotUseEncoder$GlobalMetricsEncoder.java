package com.google.android.datatransport.runtime;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder();
    public static final FieldDescriptor STORAGEMETRICS_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{64, 70, 95, 65, 0, 94, 4, 125, 86, 70, 66, 90, 2, 74}, "3203a9a0"), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ((ObjectEncoderContext) obj2).add(STORAGEMETRICS_DESCRIPTOR, ((GlobalMetrics) obj).storage_metrics_);
    }
}
