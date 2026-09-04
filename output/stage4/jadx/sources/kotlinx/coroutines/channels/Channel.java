package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.AtomicKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Channel extends SendChannel, ReceiveChannel {
    public static final Factory Factory = Factory.$$INSTANCE;

    public final class Factory {
        public static final /* synthetic */ Factory $$INSTANCE = new Factory();
        public static final int CHANNEL_DEFAULT_CAPACITY = (int) AtomicKt.systemProp(C0000.decode(new byte[]{94, 12, 64, 13, 80, 89, 74, 74, 87, 10, 22, 87, 16, 18, 89, 93, 80, 16, 26, 2, 81, 86, 92, 10, 81, 9, 23, 22, 1, 3, 86, 82, 64, 15, 64, 35, 76, 81, 84, 1, 70}, "5c4a972d4ed8ef03"), 64, 1, 2147483646);
    }
}
