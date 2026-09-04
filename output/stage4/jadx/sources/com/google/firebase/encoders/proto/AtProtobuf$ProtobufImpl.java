package com.google.firebase.encoders.proto;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AtProtobuf$ProtobufImpl implements Protobuf {
    public final int tag;

    public AtProtobuf$ProtobufImpl(int i) {
        this.tag = i;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return Protobuf.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Protobuf)) {
            return false;
        }
        if (this.tag != ((AtProtobuf$ProtobufImpl) ((Protobuf) obj)).tag) {
            return false;
        }
        Object obj2 = Protobuf.IntEncoding.DEFAULT;
        return obj2.equals(obj2);
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (14552422 ^ this.tag) + (Protobuf.IntEncoding.DEFAULT.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{118, 81, 89, 91, 27, 84, 10, 88, 3, 8, 83, 28, 80, 95, 71, 86, 7, 86, 23, 1, 24, 87, 88, 85, 90, 87, 0, 69, 23, 74, 70, 64, 89, 66, 90, 29, 53, 69, 11, 16, 89, 80, 67, 80, 29, 71, 4, 80, 89}, "626653e7dd", 5));
        sb.append(this.tag);
        sb.append(C0000.decode(new byte[]{91, 91, 68, 38, 10, 83, 93, 81, 89, 13, 3, 13}, "250cd0"));
        sb.append(Protobuf.IntEncoding.DEFAULT);
        sb.append(')');
        return sb.toString();
    }
}
