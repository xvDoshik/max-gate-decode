package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder INSTANCE = new AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder();
    public static final FieldDescriptor SDKVERSION_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{21, 1, 88, 55, 4, 20, 17, 10, 95, 11}, "fe3aafbc0e5a", true));
    public static final FieldDescriptor MODEL_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{11, 14, 2, 93, 15}, "faf8c7ac01a9", 0.0f));
    public static final FieldDescriptor HARDWARE_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{94, 80, 70, 92, 64, 85, 75, 86}, "61487493085987d5"));
    public static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{87, 86, 18, 92, 87, 86}, "33d543dd10", true));
    public static final FieldDescriptor PRODUCT_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{71, 17, 9, 84, 69, 91, 67}, "7cf00875"));
    public static final FieldDescriptor OSBUILD_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{14, 69, 118, 69, 81, 88, 81}, "a64084548b"));
    public static final FieldDescriptor MANUFACTURER_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{90, 5, 10, 69, 94, 86, 0, 17, 20, 69, 3, 71}, "7dd087cea7f5"));
    public static final FieldDescriptor FINGERPRINT_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{83, 90, 12, 86, 4, 67, 69, 65, 11, 95, 21}, "53b1a1", false));
    public static final FieldDescriptor LOCALE_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{14, 13, 80, 3, 88, 84}, "bb3b4197b7b4", 0.0f));
    public static final FieldDescriptor COUNTRY_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{5, 14, 70, 94, 16, 22, 27}, "fa30ddbfe3fd4597", true));
    public static final FieldDescriptor MCCMNC_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{95, 90, 86, 125, 94, 90}, "295009bb8c89b9d3", false));
    public static final FieldDescriptor APPLICATIONBUILD_DESCRIPTOR = FieldDescriptor.of(C0000.decode(new byte[]{4, 21, 64, 89, 8, 0, 7, 68, 90, 13, 11, 39, 69, 92, 13, 7}, "ee05acf03b", false));

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_AndroidClientInfo autoValue_AndroidClientInfo = (AutoValue_AndroidClientInfo) ((AndroidClientInfo) obj);
        objectEncoderContext.add(SDKVERSION_DESCRIPTOR, autoValue_AndroidClientInfo.sdkVersion);
        objectEncoderContext.add(MODEL_DESCRIPTOR, autoValue_AndroidClientInfo.model);
        objectEncoderContext.add(HARDWARE_DESCRIPTOR, autoValue_AndroidClientInfo.hardware);
        objectEncoderContext.add(DEVICE_DESCRIPTOR, autoValue_AndroidClientInfo.device);
        objectEncoderContext.add(PRODUCT_DESCRIPTOR, autoValue_AndroidClientInfo.product);
        objectEncoderContext.add(OSBUILD_DESCRIPTOR, autoValue_AndroidClientInfo.osBuild);
        objectEncoderContext.add(MANUFACTURER_DESCRIPTOR, autoValue_AndroidClientInfo.manufacturer);
        objectEncoderContext.add(FINGERPRINT_DESCRIPTOR, autoValue_AndroidClientInfo.fingerprint);
        objectEncoderContext.add(LOCALE_DESCRIPTOR, autoValue_AndroidClientInfo.locale);
        objectEncoderContext.add(COUNTRY_DESCRIPTOR, autoValue_AndroidClientInfo.country);
        objectEncoderContext.add(MCCMNC_DESCRIPTOR, autoValue_AndroidClientInfo.mccMnc);
        objectEncoderContext.add(APPLICATIONBUILD_DESCRIPTOR, autoValue_AndroidClientInfo.applicationBuild);
    }
}
