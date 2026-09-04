package okhttp3;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.DatesKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Cookie {
    public final String domain;
    public final long expiresAt;
    public final boolean hostOnly;
    public final boolean httpOnly;
    public final String name;
    public final String path;
    public final boolean persistent;
    public final boolean secure;
    public final String value;
    public static final Pattern YEAR_PATTERN = Pattern.compile(C0000.decode(new byte[]{29, 58, 85, 67, 2, 27, 82, 25, 16, 57, 59, 108, 87, 101, 31}, "5f1807fd9be038", true));
    public static final Pattern MONTH_PATTERN = Pattern.compile(C0000.decode(new byte[]{17, 94, 93, 76, 16, 9, 0, 88, 73, 86, 84, 91, 69, 12, 85, 23, 68, 2, 17, 68, 73, 93, 80, 64, 69, 11, 65, 11, 68, 9, 20, 90, 73, 81, 68, 94, 69, 18, 81, 21, 68, 12, 2, 66, 73, 94, 94, 79, 69, 5, 81, 6, 17, 77, 75}, "9a4e8ca65019", 0.0f));
    public static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile(C0000.decode(new byte[]{73, 107, 81, 30, 5, 79, 80, 68, 76, 62, 105, 61, 7, 109, 75}, "a75e4cb9ee7ac0aa", true));
    public static final Pattern TIME_PATTERN = Pattern.compile(C0000.decode(new byte[]{16, 109, 83, 78, 3, 77, 81, 73, 76, 94, 30, 104, 92, 74, 6, 25, 0, 28, 74, 14, 77, 56, 82, 79, 9, 29, 5, 72, 27, 58, 61, 104, 1, 57, 28}, "81752ac4ed64"));

    public Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return Intrinsics.areEqual(cookie.name, this.name) && Intrinsics.areEqual(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual(cookie.domain, this.domain) && Intrinsics.areEqual(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.hostOnly) + ((Boolean.hashCode(this.persistent) + ((Boolean.hashCode(this.httpOnly) + ((Boolean.hashCode(this.secure) + NetworkType$EnumUnboxingLocalUtility.m(this.path, NetworkType$EnumUnboxingLocalUtility.m(this.domain, (Long.hashCode(this.expiresAt) + NetworkType$EnumUnboxingLocalUtility.m(this.value, NetworkType$EnumUnboxingLocalUtility.m(this.name, 527, 31), 31)) * 31, 31), 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            long j = this.expiresAt;
            if (j == Long.MIN_VALUE) {
                sb.append(C0000.decode(new byte[]{15, 16, 11, 85, 27, 73, 7, 3, 3, 9, 8}, "40f4cdfdf480af"));
            } else {
                sb.append(C0000.decode(new byte[]{8, 16, 87, 28, 73, 93, 65, 85, 65, 89}, "302d94", 0.0f));
                sb.append(((DateFormat) DatesKt.STANDARD_DATE_FORMAT.get()).format(new Date(j)));
            }
        }
        if (!this.hostOnly) {
            sb.append(C0000.decode(new byte[]{11, 68, 85, 88, 90, 5, 11, 10, 12}, "0d177dbd1746c78b"));
            sb.append(this.domain);
        }
        sb.append(C0000.decode(new byte[]{10, 65, 73, 3, 76, 93, 12}, "1a9b85", true));
        sb.append(this.path);
        if (this.secure) {
            sb.append(C0000.decode(new byte[]{15, 66, 70, 83, 85, 22, 64, 80}, "4b566c25c9968178", false));
        }
        if (this.httpOnly) {
            sb.append(C0000.decode(new byte[]{11, 25, 11, 18, 76, 22, 10, 12, 88, 75}, "09cf8feb4241e63f", true));
        }
        return sb.toString();
    }
}
