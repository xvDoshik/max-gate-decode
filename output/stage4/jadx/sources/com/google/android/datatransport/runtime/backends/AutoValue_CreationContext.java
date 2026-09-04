package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.runtime.time.Clock;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_CreationContext extends CreationContext {
    public final Context applicationContext;
    public final String backendName;
    public final Clock monotonicClock;
    public final Clock wallClock;

    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context == null) {
            throw new NullPointerException(C0000.decode(new byte[]{127, 20, 8, 14, 24, 88, 18, 20, 93, 8, 7, 3, 76, 80, 13, 10, 114, 14, 10, 22, 93, 65, 22}, "1adb89bd"));
        }
        this.applicationContext = context;
        if (clock == null) {
            throw new NullPointerException(C0000.decode(new byte[]{47, 69, 90, 84, 17, 64, 88, 9, 94, 119, 93, 95, 2, 91}, "a068179e2410", true));
        }
        this.wallClock = clock;
        if (clock2 == null) {
            throw new NullPointerException(C0000.decode(new byte[]{119, 23, 89, 85, 23, 11, 86, 12, 90, 77, 88, 8, 80, 1, 118, 85, 88, 5, 82}, "9b597f"));
        }
        this.monotonicClock = clock2;
        if (str == null) {
            throw new NullPointerException(C0000.decode(new byte[]{44, 76, 8, 89, 18, 3, 85, 83, 91, 81, 90, 93, 42, 3, 8, 84}, "b9d52a400449dbe1", 0.0f));
        }
        this.backendName = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreationContext) {
            AutoValue_CreationContext autoValue_CreationContext = (AutoValue_CreationContext) ((CreationContext) obj);
            if (this.applicationContext.equals(autoValue_CreationContext.applicationContext) && this.wallClock.equals(autoValue_CreationContext.wallClock) && this.monotonicClock.equals(autoValue_CreationContext.monotonicClock) && this.backendName.equals(autoValue_CreationContext.backendName)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.applicationContext.hashCode() ^ 1000003) * 1000003) ^ this.wallClock.hashCode()) * 1000003) ^ this.monotonicClock.hashCode()) * 1000003) ^ this.backendName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{118, 22, 84, 3, 76, 93, 13, 94, 116, 90, 93, 66, 1, 64, 71, 31, 84, 20, 65, 14, 81, 87, 3, 68, 94, 90, 93, 117, 11, 86, 71, 1, 77, 16, 12}, "5d1b84b07536d83d", 7));
        sb.append(this.applicationContext);
        sb.append(C0000.decode(new byte[]{29, 66, 22, 81, 84, 9, 32, 15, 14, 80, 90, 95}, "1ba08ecca3", true));
        sb.append(this.wallClock);
        sb.append(C0000.decode(new byte[]{78, 17, 91, 89, 90, 91, 64, 87, 12, 94, 5, 117, 14, 94, 85, 93, 9}, "b1664448b7f6"));
        sb.append(this.monotonicClock);
        sb.append(C0000.decode(new byte[]{77, 24, 3, 81, 82, 10, 4, 86, 5, 126, 80, 12, 4, 5}, "a8a01a"));
        return FileSectionType$EnumUnboxingLocalUtility.m(sb, this.backendName, C0000.decode(new byte[]{72}, "567a3b"));
    }
}
