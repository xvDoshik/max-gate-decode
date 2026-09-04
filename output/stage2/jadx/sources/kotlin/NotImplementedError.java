package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "<init>", "(Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotImplementedError extends Error {
    /* JADX WARN: Multi-variable type inference failed */
    public NotImplementedError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, C0000.decode(new byte[]{95, 1, 70, 17, 5, 81, 93}, "2d5bd68eac1484", 1));
    }

    public /* synthetic */ NotImplementedError(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C0000.decode(new byte[]{114, 12, 66, 9, 67, 1, 65, 3, 22, 15, 92, 10, 19, 11, 17, 70, 93, 11, 71, 66, 11, 11, 67, 8, 86, 15, 7, 8, 71, 1, 87, 76}, "3bbf3d") : str);
    }
}
