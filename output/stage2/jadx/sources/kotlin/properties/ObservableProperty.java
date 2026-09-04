package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u00020\u00112\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\u00028\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0096\u0002¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0007\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001a"}, d2 = {"Lkotlin/properties/ObservableProperty;", "V", "Lkotlin/properties/ReadWriteProperty;", "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "value", "Ljava/lang/Object;", "beforeChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "afterChange", "", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "getValue", "thisRef", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ObservableProperty<V> implements ReadWriteProperty<Object, V> {
    private V value;

    protected void afterChange(KProperty<?> property, V oldValue, V newValue) {
        Intrinsics.checkNotNullParameter(property, C0000.decode(new byte[]{18, 20, 14, 72, 82, 65, 22, 31}, "bfa873", 3));
    }

    protected boolean beforeChange(KProperty<?> property, V oldValue, V newValue) {
        Intrinsics.checkNotNullParameter(property, C0000.decode(new byte[]{66, 23, 92, 70, 83, 20, 76, 65}, "2e366f88", 3));
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, C0000.decode(new byte[]{71, 20, 91, 70, 93, 75, 66, 28}, "7f46896e5f5af3", 3));
        return this.value;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object thisRef, KProperty<?> property, V value) {
        Intrinsics.checkNotNullParameter(property, C0000.decode(new byte[]{21, 64, 93, 19, 4, 64, 17, 77}, "e22ca2e456309de3", 0.0f));
        V v = this.value;
        if (beforeChange(property, v, value)) {
            this.value = value;
            afterChange(property, v, value);
        }
    }

    public String toString() {
        return C0000.decode(new byte[]{46, 87, 75, 4, 16, 67, 89, 80, 13, 80, 104, 19, 13, 69, 93, 64, 21, 76, 16, 23, 3, 89, 77, 87, 92}, "a58ab582", 0.0f) + this.value + ')';
    }

    public ObservableProperty(V v) {
        this.value = v;
    }
}
