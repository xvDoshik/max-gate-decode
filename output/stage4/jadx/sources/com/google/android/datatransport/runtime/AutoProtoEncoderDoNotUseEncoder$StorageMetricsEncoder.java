package com.google.android.datatransport.runtime;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder();
    public static final FieldDescriptor CURRENTCACHESIZEBYTES_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{84, 22, 19, 16, 86, 12, 16, 112, 86, 0, 9, 7, 96, 11, 30, 86, 117, 26, 21, 7, 64}, "7cab3bd3", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));
    public static final FieldDescriptor MAXCACHESIZEBYTES_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{91, 4, 79, 112, 89, 80, 92, 82, 99, 90, 31, 86, 116, 28, 67, 86, 75}, "6e73834703e3", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        StorageMetrics storageMetrics = (StorageMetrics) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(CURRENTCACHESIZEBYTES_DESCRIPTOR, storageMetrics.current_cache_size_bytes_);
        objectEncoderContext.add(MAXCACHESIZEBYTES_DESCRIPTOR, storageMetrics.max_cache_size_bytes_);
    }
}
