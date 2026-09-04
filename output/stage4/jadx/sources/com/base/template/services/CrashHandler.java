package com.base.template.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import kotlin.ExceptionsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    public final Context context;
    public final Thread.UncaughtExceptionHandler defaultHandler;

    public CrashHandler(Context context) {
        this.context = context;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.defaultHandler = defaultUncaughtExceptionHandler instanceof CrashHandler ? ((CrashHandler) defaultUncaughtExceptionHandler).defaultHandler : defaultUncaughtExceptionHandler;
    }

    public final void scheduleRestartAlarm() {
        Context context = this.context;
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(C0000.decode(new byte[]{86, 89, 2, 67, 11}, "75c1fa3c", false));
            Intent intent = new Intent(context, (Class<?>) CommandService.class);
            intent.setAction(C0000.decode(new byte[]{122, 99, 117, 48, 126, 106, 54, 119, 107, 49, 35, 51, 96}, "914c65d28eba41", 0.0f));
            alarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 5000, PendingIntent.getService(context, 7777, intent, 201326592));
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        String strDecode = C0000.decode(new byte[]{18}, "f48ed2d2800ab071");
        Context context = this.context;
        String strDecode2 = C0000.decode(new byte[]{2}, "ae6fd81be981b606");
        try {
            thread.getName();
            SharedPreferences sharedPreferences = context.getSharedPreferences(C0000.decode(new byte[]{83, 23, 87, 70, 10}, "0e65b3"), 0);
            int i = sharedPreferences.getInt(strDecode2, 0);
            long j = sharedPreferences.getLong(strDecode, 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - j > 120000) {
                sharedPreferences.edit().putInt(strDecode2, 1).putLong(strDecode, jCurrentTimeMillis).apply();
                scheduleRestartAlarm();
            } else if (i < 3) {
                sharedPreferences.edit().putInt(strDecode2, i + 1).apply();
                scheduleRestartAlarm();
            }
            ExceptionsKt.pingNow(context);
        } catch (Exception unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
