package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.SystemClock;
import java.util.Objects;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ConstraintProxy extends BroadcastReceiver {
    public static final /* synthetic */ int $r8$clinit = 0;

    public class BatteryChargingProxy extends ConstraintProxy {
    }

    public class BatteryNotLowProxy extends ConstraintProxy {
    }

    public class NetworkStateProxy extends ConstraintProxy {
    }

    public class StorageNotLowProxy extends ConstraintProxy {
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{113, 94, 86, 64, 23, 19, 86, 80, 12, 17, 97, 23, 12, 73, 77}, "2183ca79be1ec14d", false));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        SystemClock systemClock = SystemClock.get();
        Objects.toString(intent);
        systemClock.getClass();
        int i = CommandHandler.$r8$clinit;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction(C0000.decode(new byte[]{120, 117, 96, 112, 44, 120, 102, 117, 123, 119, 48, 98, 107, 119, 125, 119, 55, 101, 102, 117, 124, 120, 45, 113, 124, 114}, "9649c6", true));
        context.startService(intent2);
    }
}
