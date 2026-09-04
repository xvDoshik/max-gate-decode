package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, d2 = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "mode", "Lkotlin/LazyThreadSafetyMode;", "lock", "", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/LazyKt")
public class LazyKt__LazyJVMKt {

    /* JADX INFO: compiled from: LazyJVM.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            try {
                iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final <T> Lazy<T> lazy(Object obj, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{94, 94, 90, 76, 90, 87, 91, 89, 73, 93, 65}, "703836", 0.0f));
        return new SynchronizedLazyImpl(function0, obj);
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, C0000.decode(new byte[]{94, 94, 80, 4}, "314ad278ad05935a", true));
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{12, 89, 95, 68, 95, 88, 92, 81, 79, 1, 66}, "e76069085d0a", 0));
        int i = WhenMappings.$EnumSwitchMapping$0[lazyThreadSafetyMode.ordinal()];
        int i2 = 2;
        if (i == 1) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new SynchronizedLazyImpl(function0, defaultConstructorMarker, i2, defaultConstructorMarker);
        }
        if (i == 2) {
            return new SafePublicationLazyImpl(function0);
        }
        if (i == 3) {
            return new UnsafeLazyImpl(function0);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, C0000.decode(new byte[]{92, 8, 94, 18, 92, 3, 93, 15, 31, 87, 23}, "5f7f5b1fe2e6", 7));
        DefaultConstructorMarker defaultConstructorMarker = null;
        return new SynchronizedLazyImpl(function0, defaultConstructorMarker, 2, defaultConstructorMarker);
    }
}
