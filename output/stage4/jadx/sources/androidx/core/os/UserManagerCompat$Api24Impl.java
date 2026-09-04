package androidx.core.os;

import android.content.Context;
import android.os.UserManager;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class UserManagerCompat$Api24Impl {
    public static boolean isUserUnlocked(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }
}
