package com.google.firebase.messaging;

import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.firebase.encoders.proto.ProtobufEncoder$Builder;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.util.HashMap;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ProtoEncoderDoNotUse {
    public static final WorkTagDao_Impl ENCODER;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map.put(ProtoEncoderDoNotUse.class, AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder.INSTANCE);
        map2.remove(ProtoEncoderDoNotUse.class);
        map.put(MessagingClientEventExtension.class, AutoProtoEncoderDoNotUseEncoder$MessagingClientEventExtensionEncoder.INSTANCE);
        map2.remove(MessagingClientEventExtension.class);
        map.put(MessagingClientEvent.class, AutoProtoEncoderDoNotUseEncoder$MessagingClientEventEncoder.INSTANCE);
        map2.remove(MessagingClientEvent.class);
        ENCODER = new WorkTagDao_Impl(new HashMap(map), new HashMap(map2), ProtobufEncoder$Builder.DEFAULT_FALLBACK_ENCODER);
    }
}
