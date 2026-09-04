package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0087\n¢\u0006\u0002\u0010\n\u001aO\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u000b\b\u0001\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0087\n¢\u0006\u0004\b\f\u0010\n\u001aF\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u000f\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"getValue", "V1", "V", "", "", "Lkotlin/internal/Exact;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "getVar", "setValue", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MapAccessorsKt {
    private static final <V, V1 extends V> V1 getValue(Map<? super String, ? extends V> map, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{10, 18, 90, 94, 21, 91}, "6f27fe1d4e5a39", 0.0f));
        Intrinsics.checkNotNullParameter(kProperty, C0000.decode(new byte[]{73, 67, 13, 66, 82, 16, 66, 78}, "91b27b676ce5"));
        return (V1) MapsKt.getOrImplicitDefaultNullable(map, kProperty.getName());
    }

    private static final <V, V1 extends V> V1 getVar(Map<? super String, ? extends V> map, Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{15, 66, 95, 88, 67, 6}, "36710872", 7));
        Intrinsics.checkNotNullParameter(kProperty, C0000.decode(new byte[]{65, 65, 90, 73, 80, 70, 23, 26}, "135954cc", false));
        return (V1) MapsKt.getOrImplicitDefaultNullable(map, kProperty.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <V> void setValue(Map<? super String, ? super V> map, Object obj, KProperty<?> kProperty, V v) {
        Intrinsics.checkNotNullParameter(map, C0000.decode(new byte[]{11, 22, 9, 81, 68, 93}, "7ba87c5508de"));
        Intrinsics.checkNotNullParameter(kProperty, C0000.decode(new byte[]{20, 23, 95, 22, 7, 65, 66, 26}, "de0fb36cc0"));
        map.put(kProperty.getName(), v);
    }
}
