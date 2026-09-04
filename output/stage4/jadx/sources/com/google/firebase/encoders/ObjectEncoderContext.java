package com.google.firebase.encoders;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj);
}
