package com.google.firebase.messaging;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$MessagingClientEventExtensionEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$MessagingClientEventExtensionEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$MessagingClientEventExtensionEncoder();
    public static final FieldDescriptor MESSAGINGCLIENTEVENT_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{14, 6, 66, 75, 85, 3, 10, 93, 4, 34, 89, 94, 85, 89, 65, 125, 21, 6, 95, 76}, "cc184dc3ca570758", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ((ObjectEncoderContext) obj2).add(MESSAGINGCLIENTEVENT_DESCRIPTOR, ((MessagingClientEventExtension) obj).messaging_client_event_);
    }
}
