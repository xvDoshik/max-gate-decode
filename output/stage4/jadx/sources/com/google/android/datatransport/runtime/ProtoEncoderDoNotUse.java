package com.google.android.datatransport.runtime;

import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.proto.ProtobufEncoder$Builder;
import java.util.HashMap;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ProtoEncoderDoNotUse {
    public static final WorkTagDao_Impl ENCODER;

    static {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map.put(ProtoEncoderDoNotUse.class, AutoProtoEncoderDoNotUseEncoder$ProtoEncoderDoNotUseEncoder.INSTANCE);
        map2.remove(ProtoEncoderDoNotUse.class);
        map.put(ClientMetrics.class, AutoProtoEncoderDoNotUseEncoder$ClientMetricsEncoder.INSTANCE);
        map2.remove(ClientMetrics.class);
        map.put(TimeWindow.class, AutoProtoEncoderDoNotUseEncoder$TimeWindowEncoder.INSTANCE);
        map2.remove(TimeWindow.class);
        map.put(LogSourceMetrics.class, AutoProtoEncoderDoNotUseEncoder$LogSourceMetricsEncoder.INSTANCE);
        map2.remove(LogSourceMetrics.class);
        map.put(LogEventDropped.class, AutoProtoEncoderDoNotUseEncoder$LogEventDroppedEncoder.INSTANCE);
        map2.remove(LogEventDropped.class);
        map.put(GlobalMetrics.class, AutoProtoEncoderDoNotUseEncoder$GlobalMetricsEncoder.INSTANCE);
        map2.remove(GlobalMetrics.class);
        map.put(StorageMetrics.class, AutoProtoEncoderDoNotUseEncoder$StorageMetricsEncoder.INSTANCE);
        map2.remove(StorageMetrics.class);
        ENCODER = new WorkTagDao_Impl(new HashMap(map), new HashMap(map2), ProtobufEncoder$Builder.DEFAULT_FALLBACK_ENCODER);
    }
}
