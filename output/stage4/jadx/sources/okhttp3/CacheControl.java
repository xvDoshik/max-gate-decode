package okhttp3;

import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CacheControl {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String headerValue;
    public final boolean immutable;
    public final boolean isPrivate;
    public final boolean isPublic;
    public final int maxAgeSeconds;
    public final int maxStaleSeconds;
    public final int minFreshSeconds;
    public final boolean mustRevalidate;
    public final boolean noCache;
    public final boolean noStore;
    public final boolean noTransform;
    public final boolean onlyIfCached;
    public final int sMaxAgeSeconds;

    static {
        TimeUnit.SECONDS.toSeconds(Integer.MAX_VALUE);
    }

    public CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    public final String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append(C0000.decode(new byte[]{88, 12, 25, 2, 87, 85, 95, 81, 26, 67}, "6c4a6674", 0.0f));
        }
        if (this.noStore) {
            sb.append(C0000.decode(new byte[]{12, 12, 31, 70, 65, 95, 64, 6, 25, 22}, "bc25502c56ec1354"));
        }
        int i = this.maxAgeSeconds;
        String strDecode = C0000.decode(new byte[]{78, 65}, "ba5e8b", 0.0f);
        if (i != -1) {
            sb.append(C0000.decode(new byte[]{12, 81, 75, 20, 0, 4, 1, 94}, "a039acdc", 4));
            sb.append(i);
            sb.append(strDecode);
        }
        int i2 = this.sMaxAgeSeconds;
        if (i2 != -1) {
            sb.append(C0000.decode(new byte[]{64, 24, 14, 0, 65, 88, 4, 0, 9}, "35ca99ce4aba", false));
            sb.append(i2);
            sb.append(strDecode);
        }
        if (this.isPrivate) {
            sb.append(C0000.decode(new byte[]{66, 69, 8, 69, 85, 77, 80, 28, 18}, "27a34950", 0));
        }
        if (this.isPublic) {
            sb.append(C0000.decode(new byte[]{67, 64, 80, 93, 93, 82, 21, 22}, "35214196cee48cb1", 0.0f));
        }
        if (this.mustRevalidate) {
            sb.append(C0000.decode(new byte[]{89, 68, 22, 77, 26, 16, 82, 65, 85, 93, 12, 93, 86, 22, 82, 27, 20}, "41e97b77", 0));
        }
        int i3 = this.maxStaleSeconds;
        if (i3 != -1) {
            sb.append(C0000.decode(new byte[]{11, 3, 28, 78, 69, 21, 7, 14, 1, 94}, "fbdc6a", 4));
            sb.append(i3);
            sb.append(strDecode);
        }
        int i4 = this.minFreshSeconds;
        if (i4 != -1) {
            sb.append(C0000.decode(new byte[]{12, 94, 91, 26, 4, 66, 92, 74, 92, 94}, "a757b0994c79", 0));
            sb.append(i4);
            sb.append(strDecode);
        }
        if (this.onlyIfCached) {
            sb.append(C0000.decode(new byte[]{86, 92, 90, 75, 73, 12, 85, 26, 91, 81, 82, 81, 93, 86, 29, 70}, "9262de378019821f"));
        }
        if (this.noTransform) {
            sb.append(C0000.decode(new byte[]{11, 92, 73, 23, 74, 80, 91, 22, 83, 10, 23, 94, 72, 67}, "e3dc815e5e"));
        }
        if (this.immutable) {
            sb.append(C0000.decode(new byte[]{15, 90, 95, 64, 65, 85, 91, 88, 92, 26, 21}, "f72554949655858c", 2));
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        this.headerValue = string;
        return string;
    }
}
