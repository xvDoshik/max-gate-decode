package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class LocaleListCompat {

    public abstract class Api24Impl {
        public static LocaleList createLocaleList(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }

    static {
        Api24Impl.createLocaleList(new Locale[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocaleListCompat) {
            throw null;
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        throw null;
    }
}
