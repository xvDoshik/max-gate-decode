package kotlin.enums;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0010\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00070\u0006H\u0001\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"enumEntries", "Lkotlin/enums/EnumEntries;", "T", "", "E", "entriesProvider", "Lkotlin/Function0;", "", "entries", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EnumEntriesKt {
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(Function0<E[]> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{7, 92, 66, 68, 11, 93, 66, 96, 16, 93, 64, 95, 6, 93, 67}, "b266b810", 0.0f));
        return new EnumEntriesList(function0.invoke());
    }

    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, C0000.decode(new byte[]{87, 8, 68, 69, 80, 7, 70}, "2f079b54b275", false));
        return new EnumEntriesList(eArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends Enum<T>> EnumEntries<T> enumEntries() {
        throw new NotImplementedError(null, 1, 0 == true ? 1 : 0);
    }
}
