package com.google.firebase.components;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Qualified {
    public final Class qualifier;
    public final Class type;

    public @interface Unqualified {
    }

    public Qualified(Class cls, Class cls2) {
        this.qualifier = cls;
        this.type = cls2;
    }

    public static Qualified unqualified(Class cls) {
        return new Qualified(Unqualified.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (this.type.equals(qualified.type)) {
            return this.qualifier.equals(qualified.qualifier);
        }
        return false;
    }

    public final int hashCode() {
        return this.qualifier.hashCode() + (this.type.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.type;
        Class cls2 = this.qualifier;
        if (cls2 == Unqualified.class) {
            return cls.getName();
        }
        return C0000.decode(new byte[]{37}, "e4ace5921fea78", 0.0f) + cls2.getName() + C0000.decode(new byte[]{25}, "9787f0d62702ee16", 0.0f) + cls.getName();
    }
}
