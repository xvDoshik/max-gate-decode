package kotlin.jvm.internal;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {
    public final Class jClass;

    public PackageReference(Class cls) {
        this.jClass = cls;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PackageReference) {
            return Intrinsics.areEqual(this.jClass, ((PackageReference) obj).jClass);
        }
        return false;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class getJClass() {
        return this.jClass;
    }

    public final int hashCode() {
        return this.jClass.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.jClass.toString());
        sb.append(C0000.decode(new byte[]{16, 76, 122, 93, 70, 85, 11, 15, 16, 17, 85, 2, 93, 87, 81, 77, 11, 14, 94, 67, 89, 23, 17, 92, 93, 77, 66, 0, 70, 2, 89, 8, 80, 80, 94, 92, 75}, "0d1229ba0c", 6));
        return sb.toString();
    }
}
