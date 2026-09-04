package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.internal.base.zaq;
import java.util.regex.Matcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zzad extends zaq {
    public final /* synthetic */ Rpc zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzad(Rpc rpc, Looper looper) {
        super(looper);
        this.zza = rpc;
        Looper.getMainLooper();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String str;
        String strDecode;
        Rpc rpc = this.zza;
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzd());
                if (intent.hasExtra(C0000.decode(new byte[]{2, 88, 86, 5, 85, 7, 75, 90, 92, 17, 74, 7, 11, 80, 92, 16}, "e79b9b", 0.0f))) {
                    Parcelable parcelableExtra = intent.getParcelableExtra(C0000.decode(new byte[]{5, 12, 90, 87, 94, 7, 26, 90, 7, 16, 70, 85, 92, 5, 81, 69}, "bc502b47", 0.0f));
                    if (parcelableExtra instanceof zze) {
                        rpc.zzk = (zze) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.zzj = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                String strDecode2 = C0000.decode(new byte[]{7, 11, 8, 25, 5, 92, 11, 3, 9, 82, 76, 82, 10, 0, 23, 88, 11, 87, 74, 7, 87, 83, 15, 29, 13, 10, 17, 82, 12, 71, 74, 54, 32, 112, 43, 96, 48, 54, 36, 99, 43, 124, 42}, "dde7b3", 0.0f);
                if (action != strDecode2 && (action == null || !action.equals(strDecode2))) {
                    if (Log.isLoggable(C0000.decode(new byte[]{52, 64, 83}, "f00a4816b9f856b8"), 3)) {
                        C0000.decode(new byte[]{98, 12, 93, 75, 17, 0, 91, 67, 87, 0, 23, 16, 93, 64, 17, 10, 86, 68, 87, 68, 86, 1, 76, 90, 14, 11, 2, 23}, "7b83ae872d", 0.0f).concat(String.valueOf(action));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra(C0000.decode(new byte[]{65, 93, 85, 8, 74, 71, 19, 2, 16, 92, 12, 11, 108, 81, 86}, "382a93acd5ce", 0.0f));
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra(C0000.decode(new byte[]{77, 89, 65, 7, 5, 92, 16, 68, 93, 69, 86, 6}, "873bb5c0", true));
                }
                if (stringExtra != null) {
                    Matcher matcher = Rpc.zzd.matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable(C0000.decode(new byte[]{54, 71, 80}, "d7339c0c20", true), 3)) {
                            C0000.decode(new byte[]{52, 87, 84, 26, 68, 87, 2, 77, 84, 6, 20, 64, 4, 74, 65, 13, 90, 65, 4, 25, 66, 22, 70, 91, 15, 94, 11, 66}, "a91b42").concat(stringExtra);
                            return;
                        }
                        return;
                    }
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString(C0000.decode(new byte[]{23, 86, 83, 11, 75, 64, 19, 80, 69, 88, 89, 95, 57, 93, 1}, "e34b84a11161f4", 0.0f), strGroup2);
                        rpc.zzh(strGroup, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra(C0000.decode(new byte[]{93, 19, 75, 10, 19}, "8a9ea7"));
                if (stringExtra2 == null) {
                    C0000.decode(new byte[]{48, 88, 80, 76, 67, 1, 87, 21, 80, 83, 69, 68, 80, 71, 67, 11, 90, 18, 80, 27, 69, 88, 90, 20, 86, 22, 70, 14, 71, 23, 10, 68, 21, 70, 86, 3, 93, 18, 65, 69, 4, 66, 92, 91, 93, 68, 93, 5, 21}, "e6543d4a57").concat(String.valueOf(intent2.getExtras()));
                    return;
                }
                if (Log.isLoggable(C0000.decode(new byte[]{102, 65, 1}, "41b4f0fee1ec3a", 2), 3)) {
                    C0000.decode(new byte[]{97, 4, 2, 3, 95, 70, 85, 85, 23, 40, 13, 16, 71, 0, 15, 5, 83, 121, 116, 17, 82, 19, 17, 12, 65, 65}, "3aaf60017acc", 0.0f).concat(stringExtra2);
                }
                if (!stringExtra2.startsWith(C0000.decode(new byte[]{31}, "c12da3c812b4", 0.0f))) {
                    synchronized (rpc.zze) {
                        int i = 0;
                        while (true) {
                            try {
                                SimpleArrayMap simpleArrayMap = rpc.zze;
                                if (i < simpleArrayMap.mSize) {
                                    rpc.zzh((String) simpleArrayMap.mArray[i << 1], intent2.getExtras());
                                    i++;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split(C0000.decode(new byte[]{57, 24}, "ed798050", true));
                if (strArrSplit.length <= 2 || ((str = strArrSplit[1]) != (strDecode = C0000.decode(new byte[]{125, 124}, "48d2075b8a")) && (str == null || !str.equals(strDecode)))) {
                    C0000.decode(new byte[]{108, 89, 4, 76, 68, 80, 91, 23, 92, 83, 65, 71, 64, 71, 77, 0, 77, 66, 19, 81, 80, 21, 74, 6, 74, 71, 14, 90, 71, 80, 24}, "97a4458c", 0.0f).concat(stringExtra2);
                    return;
                }
                String str2 = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(C0000.decode(new byte[]{91}, "af946463", 0.0f))) {
                    strSubstring = strSubstring.substring(1);
                }
                rpc.zzh(str2, intent2.putExtra(C0000.decode(new byte[]{3, 17, 23, 92, 19}, "fce3adbb"), strSubstring).getExtras());
            }
        }
    }
}
