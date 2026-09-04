package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ConfigurationCompat$Api24Impl {
    public static LocaleList getLocales(Configuration configuration) {
        return configuration.getLocales();
    }

    public static void setLocales(Configuration configuration, LocaleListCompat localeListCompat) {
        localeListCompat.getClass();
        configuration.setLocales(null);
    }
}
