package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoBatchedLogRequestEncoder$LogEventEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$LogEventEncoder INSTANCE = new AutoBatchedLogRequestEncoder$LogEventEncoder();
    public static final FieldDescriptor EVENTTIMEMS_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{85, 20, 86, 90, 23, 101, 10, 14, 80, 47, 71}, "0b34c1cc5b49fa", true));
    public static final FieldDescriptor EVENTCODE_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{4, 67, 3, 12, 21, 117, 14, 81, 3}, "a5fba6", false));
    public static final FieldDescriptor EVENTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{92, 70, 92, 11, 67, 108, 71, 69, 8, 92, 3, 126, 69}, "909e7971a1f36be7", false));
    public static final FieldDescriptor SOURCEEXTENSION_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{64, 13, 64, 66, 85, 86, 124, 26, 70, 81, 91, 70, 90, 13, 91}, "3b50639b2455", true));
    public static final FieldDescriptor SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{66, 90, 70, 70, 2, 92, 115, 79, 23, 84, 90, 66, 81, 10, 95, 127, 64, 91, 15, 105, 68, 88, 23, 94, 7}, "1534a967c1418e", false));
    public static final FieldDescriptor TIMEZONEOFFSETSECONDS_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{17, 12, 84, 83, 30, 89, 12, 7, 119, 86, 83, 21, 85, 67, 54, 0, 90, 89, 10, 82, 17}, "ee96d6bb805f07", 1));
    public static final FieldDescriptor NETWORKCONNECTIONINFO_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{95, 1, 21, 21, 88, 66, 15, 32, 13, 86, 90, 0, 82, 16, 8, 13, 89, 121, 10, 5, 13}, "1dab70dcb84e", true));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_LogEvent autoValue_LogEvent = (AutoValue_LogEvent) ((LogEvent) obj);
        objectEncoderContext.add(EVENTTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventTimeMs);
        objectEncoderContext.add(EVENTCODE_DESCRIPTOR, autoValue_LogEvent.eventCode);
        objectEncoderContext.add(EVENTUPTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventUptimeMs);
        objectEncoderContext.add(SOURCEEXTENSION_DESCRIPTOR, autoValue_LogEvent.sourceExtension);
        objectEncoderContext.add(SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR, autoValue_LogEvent.sourceExtensionJsonProto3);
        objectEncoderContext.add(TIMEZONEOFFSETSECONDS_DESCRIPTOR, autoValue_LogEvent.timezoneOffsetSeconds);
        objectEncoderContext.add(NETWORKCONNECTIONINFO_DESCRIPTOR, autoValue_LogEvent.networkConnectionInfo);
    }
}
