package com.google.firebase.encoders;

import java.util.Collections;
import java.util.Map;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FieldDescriptor {
    public final String name;
    public final Map properties;

    public FieldDescriptor(String str, Map map) {
        this.name = str;
        this.properties = map;
    }

    public static FieldDescriptor of(String str) {
        return new FieldDescriptor(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.name.equals(fieldDescriptor.name) && this.properties.equals(fieldDescriptor.properties);
    }

    public final int hashCode() {
        return this.properties.hashCode() + (this.name.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{118, 13, 80, 10, 7, 115, 85, 23, 86, 20, 10, 71, 68, 11, 71, 29, 13, 86, 93, 1, 8}, "0d5fc7", 2));
        sb.append(this.name);
        sb.append(C0000.decode(new byte[]{74, 18, 64, 19, 93, 71, 92, 67, 21, 90, 3, 65, 13}, "f20a2791a3", 0.0f));
        sb.append(this.properties.values());
        sb.append(C0000.decode(new byte[]{77}, "0762590b31aa", false));
        return sb.toString();
    }
}
