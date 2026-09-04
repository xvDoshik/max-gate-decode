package com.google.firebase.encoders.proto;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder$$ExternalSyntheticLambda0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    public final ObjectEncoder fallbackEncoder;
    public final HashMap objectEncoders;
    public OutputStream output;
    public final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    public final HashMap valueEncoders;
    public static final Charset UTF_8 = Charset.forName(C0000.decode(new byte[]{108, 109, 34, 76, 15}, "99da7f09a6ad", false));
    public static final FieldDescriptor MAP_KEY_DESC = new FieldDescriptor(C0000.decode(new byte[]{89, 6, 24}, "2ca0672a17dd87", 4), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(1))));
    public static final FieldDescriptor MAP_VALUE_DESC = new FieldDescriptor(C0000.decode(new byte[]{20, 0, 90, 69, 84}, "ba601ffe", 0.0f), NetworkType$EnumUnboxingLocalUtility.m(NetworkType$EnumUnboxingLocalUtility.m(Protobuf.class, new AtProtobuf$ProtobufImpl(2))));
    public static final JsonDataEncoderBuilder$$ExternalSyntheticLambda0 DEFAULT_MAP_ENCODER = new JsonDataEncoderBuilder$$ExternalSyntheticLambda0(1);

    public ProtobufDataEncoderContext(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, ObjectEncoder objectEncoder) {
        this.output = byteArrayOutputStream;
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    public static int getTag(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf != null) {
            return ((AtProtobuf$ProtobufImpl) protobuf).tag;
        }
        throw new EncodingException(C0000.decode(new byte[]{39, 92, 85, 89, 1, 20, 92, 86, 21, 20, 88, 89, 16, 118, 49, 71, 95, 65, 10, 86, 65, 81, 70, 87, 89, 88, 86, 95, 6}, "a505e447f46606"));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) {
        add(fieldDescriptor, i, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        if (j == 0) {
            return this;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf == null) {
            throw new EncodingException(C0000.decode(new byte[]{117, 80, 93, 15, 85, 25, 13, 80, 69, 17, 89, 88, 19, 121, 104, 17, 94, 77, 10, 83, 67, 87, 23, 84, 92, 87, 94, 10, 86}, "398c19e16177"));
        }
        writeVarInt32(((AtProtobuf$ProtobufImpl) protobuf).tag << 3);
        writeVarInt64(j);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        add(fieldDescriptor, obj, true);
        return this;
    }

    public final void add(FieldDescriptor fieldDescriptor, int i, boolean z) {
        if (z && i == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf == null) {
            throw new EncodingException(C0000.decode(new byte[]{35, 8, 0, 92, 6, 19, 81, 7, 18, 17, 11, 14, 69, 112, 50, 65, 86, 18, 14, 83, 16, 7, 69, 83, 13, 93, 95, 15, 6}, "eae0b39fa1", 3));
        }
        writeVarInt32(((AtProtobuf$ProtobufImpl) protobuf).tag << 3);
        writeVarInt32(i);
    }

    public final void add(FieldDescriptor fieldDescriptor, Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(UTF_8);
            writeVarInt32(bytes.length);
            this.output.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                add(fieldDescriptor, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                doEncode(DEFAULT_MAP_ENCODER, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (z && dDoubleValue == 0.0d) {
                return;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 1);
            this.output.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(dDoubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z && fFloatValue == 0.0f) {
                return;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
            this.output.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if (z && jLongValue == 0) {
                return;
            }
            Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
            if (protobuf == null) {
                throw new EncodingException(C0000.decode(new byte[]{115, 95, 84, 14, 81, 70, 90, 4, 23, 18, 93, 91, 69, 116, 52, 70, 90, 66, 94, 0, 64, 0, 18, 6, 11, 92, 85, 93, 2}, "561b5f2ed234e4d4", 0.0f));
            }
            writeVarInt32(((AtProtobuf$ProtobufImpl) protobuf).tag << 3);
            writeVarInt64(jLongValue);
            return;
        }
        if (obj instanceof Boolean) {
            add(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            writeVarInt32(bArr.length);
            this.output.write(bArr);
            return;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.objectEncoders.get(obj.getClass());
        if (objectEncoder != null) {
            doEncode(objectEncoder, fieldDescriptor, obj, z);
            return;
        }
        ValueEncoder valueEncoder = (ValueEncoder) this.valueEncoders.get(obj.getClass());
        if (valueEncoder != null) {
            ProtobufValueEncoderContext protobufValueEncoderContext = this.valueEncoderContext;
            protobufValueEncoderContext.encoded = false;
            protobufValueEncoderContext.field = fieldDescriptor;
            protobufValueEncoderContext.skipDefault = z;
            valueEncoder.encode(obj, protobufValueEncoderContext);
            return;
        }
        if (obj instanceof ProtoEnum) {
            add(fieldDescriptor, ((ProtoEnum) obj).getNumber(), true);
        } else if (obj instanceof Enum) {
            add(fieldDescriptor, ((Enum) obj).ordinal(), true);
        } else {
            doEncode(this.fallbackEncoder, fieldDescriptor, obj, z);
        }
    }

    public final void doEncode(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        lengthCountingOutputStream.length = 0L;
        try {
            OutputStream outputStream = this.output;
            this.output = lengthCountingOutputStream;
            try {
                objectEncoder.encode(obj, this);
                this.output = outputStream;
                long j = lengthCountingOutputStream.length;
                lengthCountingOutputStream.close();
                if (z && j == 0) {
                    return;
                }
                writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
                writeVarInt64(j);
                objectEncoder.encode(obj, this);
            } catch (Throwable th) {
                this.output = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void writeVarInt32(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.output.write((i & 127) | 128);
            i >>>= 7;
        }
        this.output.write(i & 127);
    }

    public final void writeVarInt64(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.output.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.output.write(((int) j) & 127);
    }
}
