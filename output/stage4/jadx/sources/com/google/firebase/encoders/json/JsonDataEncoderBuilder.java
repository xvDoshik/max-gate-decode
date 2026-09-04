package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig {
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda1 BOOLEAN_ENCODER;
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda1 STRING_ENCODER;
    public final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 fallbackEncoder;
    public boolean ignoreNullValues;
    public final HashMap objectEncoders;
    public final HashMap valueEncoders;
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 DEFAULT_FALLBACK_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda0(0);
    public static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder();

    public final class TimestampEncoder implements ValueEncoder {
        public static final SimpleDateFormat rfc339;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(C0000.decode(new byte[]{28, 24, 76, 29, 20, 120, 43, 72, 83, 5, 69, 49, 69, 112, 45, 91, 88, 9, 3, 70, 21, 75, 100, 50, 49, 66, 56, 31}, "ea5d95fe7abeb8", 1), Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(C0000.decode(new byte[]{51, 50, 123}, "ff8658", 1)));
        }

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).add(rfc339.format((Date) obj));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda1] */
    static {
        final int i = 0;
        STRING_ENCODER = new ValueEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda1
            @Override // com.google.firebase.encoders.Encoder
            public final void encode(Object obj, Object obj2) {
                switch (i) {
                    case 0:
                        ((ValueEncoderContext) obj2).add((String) obj);
                        break;
                    default:
                        ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i2 = 1;
        BOOLEAN_ENCODER = new ValueEncoder() { // from class: com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda1
            @Override // com.google.firebase.encoders.Encoder
            public final void encode(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        ((ValueEncoderContext) obj2).add((String) obj);
                        break;
                    default:
                        ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public JsonDataEncoderBuilder() {
        HashMap map = new HashMap();
        this.objectEncoders = map;
        HashMap map2 = new HashMap();
        this.valueEncoders = map2;
        this.fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
        this.ignoreNullValues = false;
        map2.put(String.class, STRING_ENCODER);
        map.remove(String.class);
        map2.put(Boolean.class, BOOLEAN_ENCODER);
        map.remove(Boolean.class);
        map2.put(Date.class, TIMESTAMP_ENCODER);
        map.remove(Date.class);
    }

    public final EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        this.objectEncoders.put(cls, objectEncoder);
        this.valueEncoders.remove(cls);
        return this;
    }
}
