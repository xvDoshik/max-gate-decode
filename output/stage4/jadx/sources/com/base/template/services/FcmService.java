package com.base.template.services;

import android.os.PowerManager;
import androidx.collection.SimpleArrayMap;
import androidx.work.impl.Processor$$ExternalSyntheticLambda2;
import com.base.template.NativeBridge;
import com.base.template.network.WsPersistManager;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FcmService extends FirebaseMessagingService {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onMessageReceived(RemoteMessage remoteMessage) {
        PowerManager.WakeLock wakeLockNewWakeLock;
        super.onMessageReceived(remoteMessage);
        try {
            wakeLockNewWakeLock = ((PowerManager) getSystemService(C0000.decode(new byte[]{66, 10, 18, 86, 23}, "2ee3eb0a75"))).newWakeLock(1, C0000.decode(new byte[]{0, 65, 20, 15, 7, 84, 90, 111, 22, 80, 15, 80}, "a1d5a770", 0));
            wakeLockNewWakeLock.acquire(30000L);
        } catch (Exception unused) {
            wakeLockNewWakeLock = null;
        }
        try {
            try {
                Headers.Companion.safeStartService(this, C0000.decode(new byte[]{115, 32, 46, 105, 111, 37, 42, 116, 103, 97}, "5cc68da1211dae71", false));
                Object data = remoteMessage.getData();
                String strDecode = (String) ((SimpleArrayMap) data).get(C0000.decode(new byte[]{65, 74, 85, 87, 90, 81, 72}, "4822421e6b5f47", 0.0f));
                if (strDecode == null) {
                    strDecode = C0000.decode(new byte[]{92, 94, 68, 88, 5, 9}, "2165de8b0ea9");
                }
                if (Intrinsics.areEqual(((SimpleArrayMap) data).get(C0000.decode(new byte[]{22, 83, 64, 69, 87, 22, 22, 62, 23, 83, 65, 71, 95, 7, 7}, "d6316dba")), C0000.decode(new byte[]{70, 71, 70, 1}, "253d21d95121eca0", true)) || strDecode.equals(C0000.decode(new byte[]{11, 13, 81, 81}, "cd690fd712edba2c", true)) || strDecode.equals(C0000.decode(new byte[]{85, 66, 12, 17, 95, 0, 87, 92}, "60ee6c", 2))) {
                    new Thread(new Processor$$ExternalSyntheticLambda2(this, 10, wakeLockNewWakeLock)).start();
                } else if (wakeLockNewWakeLock != null) {
                    wakeLockNewWakeLock.release();
                }
            } catch (Exception e) {
                e.getMessage();
                if (wakeLockNewWakeLock != null) {
                    wakeLockNewWakeLock.release();
                }
            }
        } catch (Exception unused2) {
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onNewToken(String str) {
        super.onNewToken(str);
        getSharedPreferences(C0000.decode(new byte[]{84}, "223e31"), 0).edit().putString(C0000.decode(new byte[]{65}, "56a1c8"), str).apply();
        try {
            NativeBridge.triggerHeartbeat();
        } catch (Exception unused) {
        }
        try {
            Object obj = WsPersistManager.lock;
            WsPersistManager.sendHeartbeat(getApplicationContext());
        } catch (Exception unused2) {
        }
    }
}
