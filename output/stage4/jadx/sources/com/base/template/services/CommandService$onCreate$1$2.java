package com.base.template.services;

import com.base.template.NativeBridge;
import com.base.template.network.WsPersistManager$$ExternalSyntheticLambda2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CommandService$onCreate$1$2 extends Lambda implements Function0 {
    public static final CommandService$onCreate$1$2 INSTANCE;
    public static final CommandService$onCreate$1$2 INSTANCE$1;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 0;
        INSTANCE = new CommandService$onCreate$1$2(i, 0);
        INSTANCE$1 = new CommandService$onCreate$1$2(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommandService$onCreate$1$2(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                NativeBridge.setWsConnected(true);
                new Thread(new WsPersistManager$$ExternalSyntheticLambda2(1)).start();
                break;
            default:
                NativeBridge.setWsConnected(false);
                break;
        }
        return Unit.INSTANCE;
    }
}
