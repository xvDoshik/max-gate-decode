package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder INSTANCE = new AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder();
    public static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{8, 90, 85, 100, 80, 16, 65, 0, 23, 65}, "d5265a4e", 3));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ((ObjectEncoderContext) obj2).add(LOGREQUEST_DESCRIPTOR, ((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
    }
}
