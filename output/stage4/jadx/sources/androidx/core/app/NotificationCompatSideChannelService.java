package androidx.core.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        intent.getAction().equals(C0000.decode(new byte[]{83, 12, 83, 74, 10, 93, 86, 76, 68, 77, 21, 68, 93, 16, 67, 22, 39, 125, 124, 38, 104, 118, 42, 96, 123, 36, 126, 123, 36, 96, 123, 45, 121, 103, 54, 125, 118, 39, 104, 123, 45, 117, 124, 44, 114, 116}, "2b78e4", 4));
        return null;
    }
}
