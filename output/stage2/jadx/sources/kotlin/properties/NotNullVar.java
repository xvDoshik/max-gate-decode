package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0096\u0002¢\u0006\u0002\u0010\fJ,\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkotlin/properties/NotNullVar;", "T", "", "Lkotlin/properties/ReadWriteProperty;", "<init>", "()V", "value", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class NotNullVar<T> implements ReadWriteProperty<Object, T> {
    private T value;

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, C0000.decode(new byte[]{19, 17, 95, 72, 0, 67, 21, 26}, "cc08e1ac7b"));
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{100, 66, 13, 66, 92, 17, 76, 31, 24}, "40b29c8f8921", 0.0f) + property.getName() + C0000.decode(new byte[]{65, 71, 93, 11, 65, 8, 87, 68, 6, 86, 17, 91, 8, 8, 21, 93, 84, 8, 93, 30, 86, 0, 68, 81, 84, 84, 9, 19, 4, 20, 82, 1, 64, 74}, "a45d4d3dd312fa", false));
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object thisRef, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, C0000.decode(new byte[]{73, 66, 9, 22, 7, 22, 77, 73}, "90ffbd", false));
        Intrinsics.checkNotNullParameter(value, C0000.decode(new byte[]{68, 88, 93, 77, 81}, "291840eae6f786c6", 0.0f));
        this.value = value;
    }

    public String toString() {
        return C0000.decode(new byte[]{122, 87, 16, 123, 68, 10, 85, 103, 17, 11, 70, 87, 64, 67, 77, 16}, "48d51f97cd6227", 1) + (this.value != null ? C0000.decode(new byte[]{19, 82, 90, 66, 93, 9}, "e367846dc2a9b6fb", 0) + this.value : C0000.decode(new byte[]{78, 82, 14, 69, 92, 22, 86, 92, 22, 16, 80, 88, 81, 71, 11, 81, 85, 95, 66, 86, 6, 16, 64, 83, 76}, "83b096", 0)) + ')';
    }
}
