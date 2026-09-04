package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/text/SystemProperties;", "", "<init>", "()V", "LINE_SEPARATOR", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SystemProperties {
    public static final SystemProperties INSTANCE = new SystemProperties();
    public static final String LINE_SEPARATOR;

    static {
        String property = System.getProperty(C0000.decode(new byte[]{94, 94, 10, 84, 22, 18, 83, 66, 4, 16, 83, 67, 11, 67}, "27d18a62eb", false));
        Intrinsics.checkNotNull(property);
        LINE_SEPARATOR = property;
    }

    private SystemProperties() {
    }
}
