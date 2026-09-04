package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \r*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\rB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/enums/EnumEntriesSerializationProxy;", "E", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "entries", "", "<init>", "([Ljava/lang/Enum;)V", "c", "Ljava/lang/Class;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {
    private static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private final Class<E> c;

    public EnumEntriesSerializationProxy(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, C0000.decode(new byte[]{7, 88, 77, 16, 95, 6, 64}, "b69b6c370869", false));
        Class<E> cls = (Class<E>) eArr.getClass().getComponentType();
        Intrinsics.checkNotNull(cls);
        this.c = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.c.getEnumConstants();
        Intrinsics.checkNotNullExpressionValue(enumConstants, C0000.decode(new byte[]{86, 87, 66, 32, 90, 76, 85, 116, 86, 87, 22, 67, 83, 15, 69, 65, 30, 75, 26, 23, 17}, "126e498799e72a", true));
        return EnumEntriesKt.enumEntries(enumConstants);
    }

    /* JADX INFO: compiled from: EnumEntriesSerializationProxy.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/enums/EnumEntriesSerializationProxy$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
