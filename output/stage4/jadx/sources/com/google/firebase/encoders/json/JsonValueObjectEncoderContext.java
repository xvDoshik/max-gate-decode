package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {
    public final boolean active = true;
    public final ObjectEncoder fallbackEncoder;
    public final boolean ignoreNullValues;
    public final JsonWriter jsonWriter;
    public final Map objectEncoders;
    public final Map valueEncoders;

    public JsonValueObjectEncoderContext(BufferedWriter bufferedWriter, HashMap map, HashMap map2, JsonDataEncoderBuilder$$ExternalSyntheticLambda0 jsonDataEncoderBuilder$$ExternalSyntheticLambda0, boolean z) {
        this.jsonWriter = new JsonWriter(bufferedWriter);
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = jsonDataEncoderBuilder$$ExternalSyntheticLambda0;
        this.ignoreNullValues = z;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        String str = fieldDescriptor.name;
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(i);
        return this;
    }

    public final JsonValueObjectEncoderContext add(Object obj) throws IOException {
        JsonWriter jsonWriter = this.jsonWriter;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    add(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        add(entry.getValue(), (String) key);
                    } catch (ClassCastException e) {
                        throw new EncodingException(String.format(C0000.decode(new byte[]{118, 10, 91, 31, 68, 98, 67, 19, 10, 88, 94, 68, 92, 3, 29, 66, 23, 0, 17, 83, 25, 7, 66, 20, 22, 84, 89, 21, 15, 79, 25, 23, 66, 22, 20, 94, 69, 21, 6, 82, 25, 13, 89, 70, 9, 80, 71, 18, 79, 22, 94, 11, 67, 70, 65, 66, 23, 14, 5, 22, 77, 29, 71, 3, 68, 20, 68, 65, 10, 88, 74, 16, 82, 7, 0, 31}, "9d7fd17ac6", 0.0f), key, key.getClass()), e);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            ObjectEncoder objectEncoder = (ObjectEncoder) this.objectEncoders.get(obj.getClass());
            if (objectEncoder != null) {
                jsonWriter.beginObject();
                objectEncoder.encode(obj, this);
                jsonWriter.endObject();
                return this;
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.valueEncoders.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.encode(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                String strName = ((Enum) obj).name();
                maybeUnNest();
                jsonWriter.value(strName);
                return this;
            }
            jsonWriter.beginObject();
            this.fallbackEncoder.encode(obj, this);
            jsonWriter.endObject();
            return this;
        }
        if (obj instanceof byte[]) {
            maybeUnNest();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        int i = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i < length) {
                jsonWriter.value(iArr[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                maybeUnNest();
                jsonWriter.value(j);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                jsonWriter.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                jsonWriter.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i < length5) {
                add(numberArr[i]);
                i++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i < length6) {
                add(objArr[i]);
                i++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final void maybeUnNest() {
        if (!this.active) {
            throw new IllegalStateException(C0000.decode(new byte[]{52, 84, 66, 87, 90, 68, 20, 81, 90, 94, 69, 4, 28, 65, 16, 71, 71, 85, 80, 18, 70, 89, 95, 2, 1, 21, 68, 90, 93, 67, 20, 81, 90, 94, 69, 4, 28, 65, 16, 69, 85, 67, 20, 81, 71, 85, 80, 21, 1, 81, 30, 18, 119, 81, 90, 92, 90, 68, 17, 20, 23, 80, 16, 70, 92, 89, 71, 18, 86, 95, 95, 21, 1, 77, 68, 18, 85, 94, 77, 95, 90, 66, 84, 79}, "d5024042501a", true));
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        String str = fieldDescriptor.name;
        maybeUnNest();
        JsonWriter jsonWriter = this.jsonWriter;
        jsonWriter.name(str);
        maybeUnNest();
        jsonWriter.value(j);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        add(obj, fieldDescriptor.name);
        return this;
    }

    public final JsonValueObjectEncoderContext add(Object obj, String str) throws IOException {
        boolean z = this.ignoreNullValues;
        JsonWriter jsonWriter = this.jsonWriter;
        if (z) {
            if (obj == null) {
                return this;
            }
            maybeUnNest();
            jsonWriter.name(str);
            add(obj);
            return this;
        }
        maybeUnNest();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        add(obj);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(String str) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(str);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    public final ValueEncoderContext add(boolean z) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(z);
        return this;
    }
}
