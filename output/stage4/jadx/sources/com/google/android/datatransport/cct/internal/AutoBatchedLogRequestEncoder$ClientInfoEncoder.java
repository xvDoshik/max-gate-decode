package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoBatchedLogRequestEncoder$ClientInfoEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$ClientInfoEncoder INSTANCE = new AutoBatchedLogRequestEncoder$ClientInfoEncoder();
    public static final FieldDescriptor CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{2, 15, 95, 7, 88, 68, 50, 64, 22, 84}, "ac6b60f9f1de5e6c", 0.0f));
    public static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{5, 10, 5, 67, 90, 8, 86, 39, 88, 80, 4, 87, 77, 112, 86, 3, 11}, "dda15a2d49a9998e", 0.0f));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_ClientInfo autoValue_ClientInfo = (AutoValue_ClientInfo) ((ClientInfo) obj);
        autoValue_ClientInfo.getClass();
        objectEncoderContext.add(CLIENTTYPE_DESCRIPTOR, ClientInfo.ClientType.ANDROID_FIREBASE);
        objectEncoderContext.add(ANDROIDCLIENTINFO_DESCRIPTOR, autoValue_ClientInfo.androidClientInfo);
    }
}
