package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    private final boolean syntheticJavaProperty;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public KProperty getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException(C0000.decode(new byte[]{122, 11, 17, 14, 95, 91, 17, 16, 0, 5, 84, 92, 82, 16, 12, 13, 88, 21, 88, 17, 69, 13, 87, 77, 17, 29, 0, 22, 22, 70, 68, 18, 21, 12, 74, 77, 84, 0, 69, 4, 89, 71, 17, 17, 28, 13, 76, 81, 84, 16, 12, 1, 22, ByteCompanionObject.MAX_VALUE, 80, 20, 4, 67, 72, 75, 94, 20, 0, 16, 66, 92, 84, 17, 75, 67, 104, 85, 84, 5, 22, 7, 22, 83, 94, 14, 9, 12, 79, 22, 68, 20, 19, 13, 66, 80, 17, 10, 17, 23, 72, 74, 11, 75, 74, 27, 89, 64, 69, 16, 4, 0, 83, 23, 91, 1, 17, 0, 68, 84, 88, 12, 22, 77, 91, 86, 92, 75, 12, 17, 69, 64, 84, 77, 46, 55, 21, 12, 4, 93, 93, 82}, "1deb651bec89", 3));
        }
        return (KProperty) super.getReflected();
    }

    public String toString() {
        KCallable kCallableCompute = compute();
        return kCallableCompute != this ? kCallableCompute.toString() : C0000.decode(new byte[]{20, 20, 12, 18, 93, 70, 77, 77, 22}, "dfcb84946e727d") + getName() + C0000.decode(new byte[]{69, 76, 40, 86, 65, 9, 12, 10, 67, 75, 80, 3, 9, 1, 0, 77, 92, 10, 11, 68, 10, 74, 21, 11, 10, 16, 67, 88, 67, 4, 12, 8, 2, 91, 89, 0, 76}, "edc95e", true);
    }

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = (i & 2) == 2;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public KCallable compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && Intrinsics.areEqual(getBoundReceiver(), propertyReference.getBoundReceiver());
        }
        if (obj instanceof KProperty) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }
}
