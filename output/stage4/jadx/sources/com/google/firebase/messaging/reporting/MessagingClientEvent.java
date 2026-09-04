package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtoEnum;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MessagingClientEvent {
    public final String analytics_label_;
    public final String collapse_key_;
    public final String composer_label_;
    public final String instance_id_;
    public final String message_id_;
    public final MessageType message_type_;
    public final String package_name_;
    public final long project_number_;
    public final String topic_;
    public final int ttl_;

    public enum Event implements ProtoEnum {
        /* JADX INFO: Fake field, exist only in values array */
        EF0(0),
        MESSAGE_DELIVERED(1),
        /* JADX INFO: Fake field, exist only in values array */
        EF64(2);

        public final int number_;

        Event(int i) {
            this.number_ = i;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public final int getNumber() {
            return this.number_;
        }
    }

    public enum MessageType implements ProtoEnum {
        /* JADX INFO: Fake field, exist only in values array */
        EF0(0),
        DATA_MESSAGE(1),
        /* JADX INFO: Fake field, exist only in values array */
        EF2(2),
        DISPLAY_NOTIFICATION(3);

        public final int number_;

        MessageType(int i) {
            this.number_ = i;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public final int getNumber() {
            return this.number_;
        }
    }

    public enum SDKPlatform implements ProtoEnum {
        /* JADX INFO: Fake field, exist only in values array */
        EF0(0),
        ANDROID(1),
        /* JADX INFO: Fake field, exist only in values array */
        EF67(2),
        /* JADX INFO: Fake field, exist only in values array */
        EF90(3);

        public final int number_;

        SDKPlatform(int i) {
            this.number_ = i;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public final int getNumber() {
            return this.number_;
        }
    }

    public MessagingClientEvent(long j, String str, String str2, MessageType messageType, String str3, String str4, int i, String str5, String str6, String str7) {
        this.project_number_ = j;
        this.message_id_ = str;
        this.instance_id_ = str2;
        this.message_type_ = messageType;
        this.package_name_ = str3;
        this.collapse_key_ = str4;
        this.ttl_ = i;
        this.topic_ = str5;
        this.analytics_label_ = str6;
        this.composer_label_ = str7;
    }
}
