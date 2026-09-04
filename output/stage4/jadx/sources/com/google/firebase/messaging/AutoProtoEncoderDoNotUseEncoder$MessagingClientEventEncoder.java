package com.google.firebase.messaging;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoProtoEncoderDoNotUseEncoder$MessagingClientEventEncoder implements ObjectEncoder {
    public static final AutoProtoEncoderDoNotUseEncoder$MessagingClientEventEncoder INSTANCE = new AutoProtoEncoderDoNotUseEncoder$MessagingClientEventEncoder();
    public static final FieldDescriptor PROJECTNUMBER_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{22, 66, 9, 9, 82, 2, 77, 119, 19, 93, 4, 6, 69}, "f0fc7a99", true), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));
    public static final FieldDescriptor MESSAGEID_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{90, 81, 65, 66, 7, 95, 0, 123, 80}, "7421f8e242", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2))));
    public static final FieldDescriptor INSTANCEID_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{94, 95, 75, 67, 0, 13, 1, 93, 125, 81}, "7187acb845ed78", false), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(3))));
    public static final FieldDescriptor MESSAGETYPE_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{94, 81, 74, 18, 88, 82, 86, 96, 64, 17, 92}, "349a95", 1), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(4))));
    public static final FieldDescriptor SDKPLATFORM_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{23, 5, 14, 49, 93, 84, 65, 0, 11, 19, 8}, "daea155f", false), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(5))));
    public static final FieldDescriptor PACKAGENAME_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{22, 82, 81, 93, 0, 2, 3, 125, 83, 91, 4}, "f326ae", false), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(6))));
    public static final FieldDescriptor COLLAPSEKEY_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{83, 88, 89, 92, 87, 68, 23, 3, 47, 83, 73}, "075064dfd6", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(7))));
    public static final FieldDescriptor PRIORITY_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{21, 75, 13, 95, 75, 90, 66, 73}, "e9d0936045", false), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(8))));
    public static final FieldDescriptor TTL_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{67, 16, 13}, "7da9e570a79c"), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(9))));
    public static final FieldDescriptor TOPIC_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{18, 88, 22, 94, 7}, "f7f7de", 0), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(10))));
    public static final FieldDescriptor BULKID_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{3, 68, 93, 88, 126, 82}, "a11376", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(11))));
    public static final FieldDescriptor EVENT_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{4, 19, 93, 12, 21}, "ae8ba1560040cf"), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(12))));
    public static final FieldDescriptor ANALYTICSLABEL_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{83, 88, 82, 84, 27, 17, 11, 0, 65, 122, 82, 90, 7, 9}, "2638bebc", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(13))));
    public static final FieldDescriptor CAMPAIGNID_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{7, 89, 85, 19, 5, 13, 4, 86, 45, 92}, "d88cddc8", 7), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(14))));
    public static final FieldDescriptor COMPOSERLABEL_DESCRIPTOR = new FieldDescriptor(C0000.decode(new byte[]{2, 86, 9, 69, 86, 70, 4, 75, 40, 84, 91, 80, 13}, "a9d595"), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(15))));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        MessagingClientEvent messagingClientEvent = (MessagingClientEvent) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(PROJECTNUMBER_DESCRIPTOR, messagingClientEvent.project_number_);
        objectEncoderContext.add(MESSAGEID_DESCRIPTOR, messagingClientEvent.message_id_);
        objectEncoderContext.add(INSTANCEID_DESCRIPTOR, messagingClientEvent.instance_id_);
        objectEncoderContext.add(MESSAGETYPE_DESCRIPTOR, messagingClientEvent.message_type_);
        objectEncoderContext.add(SDKPLATFORM_DESCRIPTOR, MessagingClientEvent.SDKPlatform.ANDROID);
        objectEncoderContext.add(PACKAGENAME_DESCRIPTOR, messagingClientEvent.package_name_);
        objectEncoderContext.add(COLLAPSEKEY_DESCRIPTOR, messagingClientEvent.collapse_key_);
        objectEncoderContext.add(PRIORITY_DESCRIPTOR, 0);
        objectEncoderContext.add(TTL_DESCRIPTOR, messagingClientEvent.ttl_);
        objectEncoderContext.add(TOPIC_DESCRIPTOR, messagingClientEvent.topic_);
        objectEncoderContext.add(BULKID_DESCRIPTOR, 0L);
        objectEncoderContext.add(EVENT_DESCRIPTOR, MessagingClientEvent.Event.MESSAGE_DELIVERED);
        objectEncoderContext.add(ANALYTICSLABEL_DESCRIPTOR, messagingClientEvent.analytics_label_);
        objectEncoderContext.add(CAMPAIGNID_DESCRIPTOR, 0L);
        objectEncoderContext.add(COMPOSERLABEL_DESCRIPTOR, messagingClientEvent.composer_label_);
    }
}
