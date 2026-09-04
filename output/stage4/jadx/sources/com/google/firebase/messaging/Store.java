package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat$Api21Impl;
import com.google.firebase.heartbeatinfo.AutoValue_HeartBeatResult;
import java.io.File;
import java.io.IOException;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Store {
    public final SharedPreferences store;

    public final class Token {
        public static final /* synthetic */ int $r8$clinit = 0;
        public static final long REFRESH_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(7);
        public final String appVersion;
        public final long timestamp;
        public final String token;

        public Token(String str, String str2, long j) {
            this.token = str;
            this.appVersion = str2;
            this.timestamp = j;
        }

        public static Token parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith(C0000.decode(new byte[]{77}, "6ca91962", 6))) {
                return new Token(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Token(jSONObject.getString(C0000.decode(new byte[]{69, 91, 92, 3, 13}, "147fc9042e1134e4", 7)), jSONObject.getString(C0000.decode(new byte[]{0, 67, 72, 51, 93, 71, 64, 91, 90, 91}, "a38e853255", 1)), jSONObject.getLong(C0000.decode(new byte[]{18, 92, 94, 1, 68, 64, 2, 11, 64}, "f53d74cf03837e36", false)));
            } catch (JSONException e) {
                e.toString();
                return null;
            }
        }
    }

    public Store(Context context) {
        boolean zIsEmpty;
        SharedPreferences sharedPreferences = context.getSharedPreferences(C0000.decode(new byte[]{84, 89, 92, 23, 87, 88, 89, 4, 85, 84, 25, 87, 95, 93, 66, 88, 95, 7, 23, 86, 90, 69, 31, 88, 64, 71, 95, 7}, "7619076c91", true), 0);
        this.store = sharedPreferences;
        File file = new File(ContextCompat$Api21Impl.getNoBackupFilesDir(context), C0000.decode(new byte[]{80, 14, 85, 25, 85, 94, 92, 6, 84, 82, 28, 80, 93, 5, 74, 88, 91, 85, 29, 6, 85, 68, 28, 80, 67, 17, 81, 83, 31, 95, 92, 76, 90, 86, 81, 90, 70, 17}, "3a8721", 3));
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    zIsEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (zIsEmpty) {
                    return;
                }
                synchronized (this) {
                    sharedPreferences.edit().clear().commit();
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable(C0000.decode(new byte[]{126, 93, 66, 84, 82, 5, 70, 82, 40, 86, 18, 23, 84, 95, 81, 90, 87}, "84010d57e3ad58"), 3)) {
                e.getMessage();
            }
        }
    }

    public Store(Context context, String str) {
        this.store = context.getSharedPreferences(C0000.decode(new byte[]{36, 10, 16, 84, 82, 3, 17, 3, 112, 84, 3, 17, 22, 115, 85, 3, 22}, "bcb10bbf81", false) + str, 0);
    }

    public synchronized void cleanUpStoredHeartBeats() {
        try {
            long j = this.store.getLong(C0000.decode(new byte[]{82, 89, 68, 81, 27, 5, 10, 64, 10, 71}, "40646fe5d3bc76"), 0L);
            String key = "";
            String str = null;
            for (Map.Entry<String, ?> entry : this.store.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str2 : (Set) entry.getValue()) {
                        if (str == null || str.compareTo(str2) > 0) {
                            key = entry.getKey();
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet(this.store.getStringSet(key, new HashSet()));
            hashSet.remove(str);
            this.store.edit().putStringSet(key, hashSet).putLong(C0000.decode(new byte[]{0, 91, 22, 81, 27, 91, 87, 76, 13, 21}, "f2d46889ca249e"), j - 1).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void deleteAllHeartBeats() {
        try {
            SharedPreferences.Editor editorEdit = this.store.edit();
            int i = 0;
            for (Map.Entry<String, ?> entry : this.store.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    String formattedDate = getFormattedDate(System.currentTimeMillis());
                    String key = entry.getKey();
                    if (set.contains(formattedDate)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(formattedDate);
                        i++;
                        editorEdit.putStringSet(key, hashSet);
                    } else {
                        editorEdit.remove(key);
                    }
                }
            }
            if (i == 0) {
                editorEdit.remove(C0000.decode(new byte[]{85, 80, 68, 6, 73, 90, 86, 70, 93, 77}, "396cd993"));
            } else {
                editorEdit.putLong(C0000.decode(new byte[]{4, 88, 16, 80, 30, 84, 13, 68, 12, 65}, "b1b537", 3), i);
            }
            editorEdit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ArrayList getAllHeartBeats() {
        try {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, ?> entry : this.store.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(getFormattedDate(System.currentTimeMillis()));
                    if (!hashSet.isEmpty()) {
                        arrayList.add(new AutoValue_HeartBeatResult(entry.getKey(), new ArrayList(hashSet)));
                    }
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                this.store.edit().putLong(C0000.decode(new byte[]{87, 93, 74, 85, 21, 85, 15, 89, 90, 81, 93}, "148082c6801441", 1), jCurrentTimeMillis).commit();
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized String getFormattedDate(long j) {
        return new Date(j).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public synchronized String getStoredUserAgentString(String str) {
        for (Map.Entry<String, ?> entry : this.store.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public synchronized void removeStoredDate(String str) {
        try {
            String storedUserAgentString = getStoredUserAgentString(str);
            if (storedUserAgentString == null) {
                return;
            }
            HashSet hashSet = new HashSet(this.store.getStringSet(storedUserAgentString, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                this.store.edit().remove(storedUserAgentString).commit();
            } else {
                this.store.edit().putStringSet(storedUserAgentString, hashSet).commit();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean shouldSendSdkHeartBeat(long j) {
        String strDecode = C0000.decode(new byte[]{81, 80, 67, 81, 78, 95, 14, 92, 87, 87, 9}, "7914c8b356ef");
        synchronized (this) {
            if (!this.store.contains(strDecode)) {
                this.store.edit().putLong(strDecode, j).commit();
                return true;
            }
            long j2 = this.store.getLong(strDecode, -1L);
            synchronized (this) {
                boolean zEquals = getFormattedDate(j2).equals(getFormattedDate(j));
                if (zEquals) {
                    return false;
                }
                this.store.edit().putLong(strDecode, j).commit();
                return true;
            }
        }
    }

    public synchronized void storeHeartBeat(long j, String str) {
        String formattedDate = getFormattedDate(j);
        if (this.store.getString(C0000.decode(new byte[]{84, 0, 66, 68, 76, 77, 70, 87, 85, 28, 6, 84, 69, 3}, "8a10a85211b51f"), "").equals(formattedDate)) {
            String storedUserAgentString = getStoredUserAgentString(formattedDate);
            if (storedUserAgentString == null) {
                return;
            }
            if (storedUserAgentString.equals(str)) {
                return;
            }
            updateStoredUserAgent(str, formattedDate);
            return;
        }
        long j2 = this.store.getLong(C0000.decode(new byte[]{3, 91, 23, 82, 76, 6, 14, 17, 11, 70}, "e2e7aead"), 0L);
        if (j2 + 1 == 30) {
            cleanUpStoredHeartBeats();
            j2 = this.store.getLong(C0000.decode(new byte[]{80, 8, 70, 85, 72, 81, 89, 20, 90, 68}, "6a40e2"), 0L);
        }
        HashSet hashSet = new HashSet(this.store.getStringSet(str, new HashSet()));
        hashSet.add(formattedDate);
        this.store.edit().putStringSet(str, hashSet).putLong(C0000.decode(new byte[]{83, 94, 23, 1, 75, 81, 14, 71, 88, 67}, "57edf2a2678e"), j2 + 1).putString(C0000.decode(new byte[]{15, 86, 16, 69, 20, 66, 16, 82, 7, 28, 93, 86, 23, 82}, "c7c197"), formattedDate).commit();
    }

    public synchronized void updateStoredUserAgent(String str, String str2) {
        removeStoredDate(str2);
        HashSet hashSet = new HashSet(this.store.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.store.edit().putStringSet(str, hashSet).commit();
    }
}
