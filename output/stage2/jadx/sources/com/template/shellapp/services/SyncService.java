package com.template.shellapp.services;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
public class SyncService extends Service {
    private static final String CH_ID = C0000.decode(new byte[]{16, 103, 0, 95}, "c8c7ff7bffe0");

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        String strDecode = C0000.decode(new byte[]{106, 77, 92, 2}, "942a9193ac973515");
        String strDecode2 = C0000.decode(new byte[]{69, 111, 87, 88}, "6040c5485a4a", false);
        NotificationChannel notificationChannel = new NotificationChannel(strDecode2, strDecode, 2);
        notificationChannel.setShowBadge(false);
        notificationChannel.setSound(null, null);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        startForeground(1, new Notification.Builder(this, strDecode2).setSmallIcon(R.drawable.ic_menu_info_details).build());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
