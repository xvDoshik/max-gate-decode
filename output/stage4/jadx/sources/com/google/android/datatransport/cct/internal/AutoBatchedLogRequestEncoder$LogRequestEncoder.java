package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoBatchedLogRequestEncoder$LogRequestEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$LogRequestEncoder INSTANCE = new AutoBatchedLogRequestEncoder$LogRequestEncoder();
    public static final FieldDescriptor REQUESTTIMEMS_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{17, 93, 19, 76, 82, 68, 16, 96, 11, 14, 86, 117, 64}, "c8b977d4bc383b", 0.0f));
    public static final FieldDescriptor REQUESTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{16, 6, 68, 22, 82, 70, 23, 101, 71, 16, 89, 92, 85, 47, 16}, "bc5c75c07d010bcb"));
    public static final FieldDescriptor CLIENTINFO_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{82, 14, 93, 7, 87, 64, 127, 95, 94, 90}, "1b4b946185"));
    public static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{10, 10, 82, 55, 9, 69, 20, 6, 80}, "fe5df0", 5));
    public static final FieldDescriptor LOGSOURCENAME_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{93, 95, 5, 106, 10, 69, 74, 84, 3, 118, 2, 94, 84}, "10b9e087f8c3"));
    public static final FieldDescriptor LOGEVENT_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{14, 90, 82, 33, 21, 85, 10, 76}, "b55dc0d8e5", 0.0f));
    public static final FieldDescriptor QOSTIER_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{69, 89, 21, 108, 8, 93, 16}, "46f8a8be2088"));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_LogRequest autoValue_LogRequest = (AutoValue_LogRequest) ((LogRequest) obj);
        objectEncoderContext.add(REQUESTTIMEMS_DESCRIPTOR, autoValue_LogRequest.requestTimeMs);
        objectEncoderContext.add(REQUESTUPTIMEMS_DESCRIPTOR, autoValue_LogRequest.requestUptimeMs);
        objectEncoderContext.add(CLIENTINFO_DESCRIPTOR, autoValue_LogRequest.clientInfo);
        objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, autoValue_LogRequest.logSource);
        objectEncoderContext.add(LOGSOURCENAME_DESCRIPTOR, autoValue_LogRequest.logSourceName);
        objectEncoderContext.add(LOGEVENT_DESCRIPTOR, autoValue_LogRequest.logEvents);
        objectEncoderContext.add(QOSTIER_DESCRIPTOR, QosTier.DEFAULT);
    }
}
