package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder INSTANCE = new AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder();
    public static final FieldDescriptor NETWORKTYPE_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{15, 1, 76, 64, 93, 74, 10, 48, 65, 71, 87}, "ad8728", 7));
    public static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{88, 13, 7, 94, 14, 82, 53, 65, 7, 70, 76, 18, 0}, "5be7b7f4e2", 1));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo = (AutoValue_NetworkConnectionInfo) ((NetworkConnectionInfo) obj);
        objectEncoderContext.add(NETWORKTYPE_DESCRIPTOR, autoValue_NetworkConnectionInfo.networkType);
        objectEncoderContext.add(MOBILESUBTYPE_DESCRIPTOR, autoValue_NetworkConnectionInfo.mobileSubtype);
    }
}
