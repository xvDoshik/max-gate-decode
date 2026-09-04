package androidx.work.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.cloudmessaging.zzs;
import com.google.android.gms.cloudmessaging.zzx;
import com.google.android.gms.cloudmessaging.zzy;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnection$newWebSocketStreams$1;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketExtensions;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkLauncherImpl implements WorkLauncher, Factory, Continuation {
    public Object processor;
    public final Object workTaskExecutor;

    public /* synthetic */ WorkLauncherImpl(Object obj, Object obj2) {
        this.processor = obj;
        this.workTaskExecutor = obj2;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new MetadataBackendRegistry((Context) ((ConnectionPool) this.processor).delegate, (WorkTagDao_Impl) ((ConnectionPool) this.workTaskExecutor).get());
    }

    public File getDataFile() {
        String strDecode = C0000.decode(new byte[]{96, 80, 71, 22, 95, 22, 70, 81, 87, 44, 95, 74, 22, 7, 90, 89, 81, 65, 92, 10, 88, 75}, "055e6e243e19bf65");
        if (((File) this.processor) == null) {
            synchronized (this) {
                try {
                    if (((File) this.processor) == null) {
                        FirebaseApp firebaseApp = (FirebaseApp) this.workTaskExecutor;
                        firebaseApp.checkNotDeleted();
                        this.processor = new File(firebaseApp.applicationContext.getFilesDir(), strDecode + ((FirebaseApp) this.workTaskExecutor).getPersistenceKey() + C0000.decode(new byte[]{76, 94, 22, 89, 92}, "b4e62be263ef", 0.0f));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (File) this.processor;
    }

    public String getString(String str) {
        Resources resources = (Resources) this.processor;
        int identifier = resources.getIdentifier(str, C0000.decode(new byte[]{64, 18, 19, 90, 89, 5}, "3fa37b3e", false), (String) this.workTaskExecutor);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }

    public void insertOrUpdatePersistedInstallationEntry(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C0000.decode(new byte[]{36, 8, 82}, "ba6a475c0170af88", false), autoValue_PersistedInstallationEntry.firebaseInstallationId);
            jSONObject.put(C0000.decode(new byte[]{49, 66, 5, 68, 22, 68}, "b6d0c7", 0.0f), FileSectionType$EnumUnboxingLocalUtility.ordinal(autoValue_PersistedInstallationEntry.registrationStatus));
            jSONObject.put(C0000.decode(new byte[]{34, 77, 17, 80, 99, 93, 14, 82, 91}, "c8e872e7516b", 0.0f), autoValue_PersistedInstallationEntry.authToken);
            jSONObject.put(C0000.decode(new byte[]{49, 7, 83, 65, 6, 70, 9, 98, 86, 82, 3, 87}, "cb53c5a699f99dd4"), autoValue_PersistedInstallationEntry.refreshToken);
            jSONObject.put(C0000.decode(new byte[]{53, 10, 92, 7, 11, 32, 71, 92, 0, 17, 94, 13, 11, 38, 69, 86, 2, 13, 126, 12, 54, 6, 86, 74}, "ae7bec59"), autoValue_PersistedInstallationEntry.tokenCreationEpochInSecs);
            jSONObject.put(C0000.decode(new byte[]{119, 72, 70, 15, 22, 6, 74, 45, 15, 54, 87, 87, 71}, "206fdc9dae244648"), autoValue_PersistedInstallationEntry.expiresInSecs);
            jSONObject.put(C0000.decode(new byte[]{36, 88, 67, 119, 19, 16, 14, 75}, "b102aba97e79", true), autoValue_PersistedInstallationEntry.fisError);
            String strDecode = C0000.decode(new byte[]{96, 3, 64, 67, 93, 70, 77, 3, 2, 40, 89, 69, 21, 86, 92, 10, 83, 68, 93, 90, 87}, "0f20459ffa76a7");
            String strDecode2 = C0000.decode(new byte[]{71, 9, 17}, "3da306d904f17097", 0.0f);
            FirebaseApp firebaseApp = (FirebaseApp) this.workTaskExecutor;
            firebaseApp.checkNotDeleted();
            File fileCreateTempFile = File.createTempFile(strDecode, strDecode2, firebaseApp.applicationContext.getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes(C0000.decode(new byte[]{54, 98, 34, 26, 1}, "c6d797ed1359cd5a", 5)));
            fileOutputStream.close();
            if (fileCreateTempFile.renameTo(getDataFile())) {
            } else {
                throw new IOException(C0000.decode(new byte[]{76, 89, 80, 3, 92, 92, 25, 67, 94, 65, 66, 92, 87, 86, 92, 4, 16, 77, 81, 82, 17, 21, 93, 73, 95, 94, 93, 4, 16, 77, 86, 23, 97, 4, 66, 74, 80, 68, 69, 4, 84, 112, 87, 68, 69, 0, 92, 85, 88, 67, 88, 14, 94}, "971a09"));
            }
        } catch (IOException | JSONException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0134 A[PHI: r12 r14 r16
      0x0134: PHI (r12v4 java.lang.Integer) = (r12v3 java.lang.Integer), (r12v8 java.lang.Integer) binds: [B:55:0x018d, B:37:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0134: PHI (r14v7 java.lang.Integer) = (r14v5 java.lang.Integer), (r14v3 java.lang.Integer) binds: [B:55:0x018d, B:37:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0134: PHI (r16v15 ??) = (r16v9 ??), (r16v18 ??) binds: [B:55:0x018d, B:37:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v24 */
    /* JADX WARN: Type inference failed for: r16v25 */
    /* JADX WARN: Type inference failed for: r16v26 */
    /* JADX WARN: Type inference failed for: r16v27 */
    /* JADX WARN: Type inference failed for: r16v28 */
    /* JADX WARN: Type inference failed for: r16v29 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v30 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    public void onResponse(Response response) {
        String strTrimSubstring;
        Exchange exchange = response.exchange;
        int i = 1;
        try {
            ((RealWebSocket) this.processor).checkUpgradeSuccess$okhttp(response, exchange);
            RealCall realCall = (RealCall) exchange.call;
            if (realCall.timeoutEarlyExit) {
                throw new IllegalStateException(C0000.decode(new byte[]{116, 89, 1, 86, 89, 16, 81, 80, 13, 89, 87, 84, 25}, "71d520"));
            }
            realCall.timeoutEarlyExit = true;
            realCall.timeout.exit();
            RealConnection connection = ((ExchangeCodec) exchange.codec).getConnection();
            Socket socket = connection.socket;
            RealBufferedSource realBufferedSource = connection.source;
            RealBufferedSink realBufferedSink = connection.sink;
            int i2 = 0;
            socket.setSoTimeout(0);
            connection.noNewExchanges$okhttp();
            RealConnection$newWebSocketStreams$1 realConnection$newWebSocketStreams$1 = new RealConnection$newWebSocketStreams$1(realBufferedSource, realBufferedSink, exchange);
            Headers headers = response.headers;
            int size = headers.size();
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            ?? r16 = 0;
            Integer intOrNull = null;
            Integer intOrNull2 = null;
            while (i3 < size) {
                if (StringsKt__StringsJVMKt.equals(headers.name(i3), C0000.decode(new byte[]{101, 85, 5, 30, 110, 81, 87, 53, 91, 84, 93, 85, 18, 30, 124, 76, 65, 3, 90, 68, 95, 95, 8, 64}, "60f3945f47", 0.0f))) {
                    String strValue = headers.value(i3);
                    int i4 = i2;
                    while (i4 < strValue.length()) {
                        int iDelimiterOffset$default = Util.delimiterOffset$default(strValue, ',', i4, i2, 4);
                        char c = ';';
                        int iDelimiterOffset = Util.delimiterOffset(strValue, ';', i4, iDelimiterOffset$default);
                        String strTrimSubstring2 = Util.trimSubstring(strValue, i4, iDelimiterOffset);
                        int i5 = iDelimiterOffset + i;
                        int i6 = i;
                        if (strTrimSubstring2.equalsIgnoreCase(C0000.decode(new byte[]{19, 92, 19, 84, 92, 75, 16, 88, 6, 92, 20, 92, 6, 95, 13, 88, 77, 93}, "c9a998", true))) {
                            if (z) {
                                r16 = i6;
                            }
                            i4 = i5;
                            r16 = r16;
                            while (i4 < iDelimiterOffset$default) {
                                int iDelimiterOffset2 = Util.delimiterOffset(strValue, c, i4, iDelimiterOffset$default);
                                int iDelimiterOffset3 = Util.delimiterOffset(strValue, '=', i4, iDelimiterOffset2);
                                String strTrimSubstring3 = Util.trimSubstring(strValue, i4, iDelimiterOffset3);
                                if (iDelimiterOffset3 < iDelimiterOffset2) {
                                    strTrimSubstring = Util.trimSubstring(strValue, iDelimiterOffset3 + 1, iDelimiterOffset2);
                                    String strDecode = C0000.decode(new byte[]{23}, "535db33b", false);
                                    headers = headers;
                                    if (strTrimSubstring.length() >= 2 && strTrimSubstring.startsWith(strDecode) && strTrimSubstring.endsWith(strDecode)) {
                                        strTrimSubstring = strTrimSubstring.substring(i6, strTrimSubstring.length() - 1);
                                    }
                                } else {
                                    headers = headers;
                                    strTrimSubstring = null;
                                }
                                i4 = iDelimiterOffset2 + 1;
                                ?? r17 = r16;
                                if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{5, 13, 15, 85, 95, 64, 60, 93, 80, 30, 104, 19, 12, 10, 2, 14, 17, 111, 83, 93, 23, 67}, "faf014c01f7ded", 0.0f))) {
                                    if (intOrNull != null) {
                                        r17 = 1;
                                    }
                                    intOrNull = strTrimSubstring != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(strTrimSubstring) : null;
                                    if (intOrNull == null) {
                                        r17 = r16;
                                        r17 = r16;
                                        r17 = r16;
                                        c = ';';
                                        r17 = 1;
                                    } else {
                                        c = ';';
                                    }
                                } else if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{5, 10, 8, 7, 8, 68, 57, 8, 14, 61, 5, 95, 8, 18, 4, 26, 18, 111, 18, 7, 10, 7, 9, 70, 3, 20}, "ffabf0"))) {
                                    if (z2) {
                                        r17 = 1;
                                    }
                                    if (strTrimSubstring != null) {
                                        r17 = 1;
                                    }
                                    c = ';';
                                    z2 = true;
                                } else {
                                    if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{21, 6, 22, 66, 4, 70, 60, 9, 80, 74, 62, 22, 95, 12, 80, 88, 17, 60, 6, 93, 21, 71}, "fcd4a4cd12aa6b47", false))) {
                                        if (intOrNull2 != null) {
                                            r17 = 1;
                                        }
                                        intOrNull2 = strTrimSubstring != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(strTrimSubstring) : null;
                                        if (intOrNull2 != null) {
                                            c = ';';
                                        }
                                    } else if (strTrimSubstring3.equalsIgnoreCase(C0000.decode(new byte[]{74, 87, 75, 69, 0, 71, 62, 13, 87, 102, 90, 93, 87, 71, 0, 77, 21, 60, 76, 88, 82, 87, 86, 69, 0, 71}, "9293e5ac89"))) {
                                        if (z3) {
                                            r17 = 1;
                                        }
                                        if (strTrimSubstring != null) {
                                            r17 = 1;
                                        }
                                        c = ';';
                                        z3 = true;
                                    }
                                    r17 = r16;
                                    r17 = r16;
                                    r17 = r16;
                                    c = ';';
                                    r17 = 1;
                                }
                                i6 = 1;
                                r16 = r17;
                            }
                            i = 1;
                            i2 = 0;
                            z = true;
                        } else {
                            i4 = i5;
                            i = 1;
                            i2 = 0;
                            r16 = 1;
                        }
                    }
                }
                i3++;
                headers = headers;
                i = 1;
                i2 = 0;
                r16 = r16;
            }
            ((RealWebSocket) this.processor).extensions = new WebSocketExtensions(z, intOrNull, z2, intOrNull2, z3, r16);
            if (r16 != 0 || intOrNull != null || (intOrNull2 != null && !new IntRange(8, 15, 1).contains(intOrNull2.intValue()))) {
                RealWebSocket realWebSocket = (RealWebSocket) this.processor;
                synchronized (realWebSocket) {
                    realWebSocket.messageAndCloseQueue.clear();
                    realWebSocket.close(C0000.decode(new byte[]{16, 11, 83, 78, 67, 87, 86, 16, 3, 86, 69, 54, 83, 85, 30, 101, 80, 6, 53, 93, 6, 14, 83, 66, 30, 119, 77, 16, 3, 92, 22, 12, 89, 88, 64, 18, 92, 10, 70, 64, 0, 22, 70, 89, 93, 65, 80, 68, 14, 87, 4, 1, 83, 68}, "ee66325df2", true), 1010);
                }
            }
            try {
                ((RealWebSocket) this.processor).initReaderAndWriter(Util.okHttpName + C0000.decode(new byte[]{70, 110, 80, 3, 96, 13, 84, 83, 3, 77, 70}, "f95a3b78f9", false) + ((HttpUrl) ((Request) this.workTaskExecutor).url).redact(), realConnection$newWebSocketStreams$1);
                RealWebSocket realWebSocket2 = (RealWebSocket) this.processor;
                realWebSocket2.listener.onOpen(realWebSocket2);
                ((RealWebSocket) this.processor).loopReader();
            } catch (Exception e) {
                ((RealWebSocket) this.processor).failWebSocket(e);
            }
        } catch (IOException e2) {
            ((RealWebSocket) this.processor).failWebSocket(e2);
            Util.closeQuietly(response);
            if (exchange != null) {
                exchange.bodyComplete(true, true, null);
            }
        }
    }

    public AutoValue_PersistedInstallationEntry readPersistedInstallationEntryValue() {
        JSONObject jSONObject;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(getDataFile());
            while (true) {
                try {
                    int i = fileInputStream.read(bArr, 0, 16384);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            jSONObject = new JSONObject(byteArrayOutputStream.toString());
            fileInputStream.close();
        } catch (IOException | JSONException unused) {
            jSONObject = new JSONObject();
        }
        String strOptString = jSONObject.optString(C0000.decode(new byte[]{114, 13, 5}, "4da86b809803"), null);
        int iOptInt = jSONObject.optInt(C0000.decode(new byte[]{53, 17, 86, 77, 71, 70}, "fe79256f"), 0);
        String strOptString2 = jSONObject.optString(C0000.decode(new byte[]{117, 20, 70, 81, 109, 11, 91, 92, 12}, "4a299d09b254a3b7"), null);
        String strOptString3 = jSONObject.optString(C0000.decode(new byte[]{107, 80, 85, 68, 83, 65, 95, 103, 89, 8, 92, 91}, "953662736c"), null);
        long jOptLong = jSONObject.optLong(C0000.decode(new byte[]{98, 88, 90, 92, 92, 112, 67, 84, 4, 67, 95, 88, 95, 124, 66, 92, 82, 89, 44, 89, 101, 82, 82, 74}, "67192311e7"), 0L);
        long jOptLong2 = jSONObject.optLong(C0000.decode(new byte[]{36, 64, 70, 11, 68, 80, 22, 47, 15, 107, 83, 1, 69}, "a86b65ef"), 0L);
        String strOptString4 = jSONObject.optString(C0000.decode(new byte[]{34, 13, 71, 35, 74, 66, 11, 22}, "dd4f80"), null);
        int i2 = FileSectionType$EnumUnboxingLocalUtility.values(5)[iOptInt];
        if (i2 == 0) {
            throw new NullPointerException(C0000.decode(new byte[]{125, 20, 90, 9, 22, 19, 83, 95, 91, 18, 22, 22, 82, 69, 90, 14, 88, 54, 66, 0, 66, 77, 65}, "3a6e6a682abd31"));
        }
        String strDecode = i2 == 0 ? C0000.decode(new byte[]{25, 68, 82, 85, 90, 70, 67, 23, 3, 23, 92, 94, 92, 101, 71, 0, 77, 67, 68}, "9672357ebc51263a") : "";
        if (strDecode.isEmpty()) {
            return new AutoValue_PersistedInstallationEntry(strOptString, i2, strOptString2, strOptString3, jOptLong2, jOptLong, strOptString4);
        }
        throw new IllegalStateException(C0000.decode(new byte[]{44, 89, 17, 64, 93, 90, 95, 70, 19, 85, 19, 70, 93, 70, 93, 2, 65, 64, 16, 92, 68, 81, 74, 18, 8, 85, 17, 9}, "a0b3448f").concat(strDecode));
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Bundle bundle;
        Rpc rpc = (Rpc) this.processor;
        Bundle bundle2 = (Bundle) this.workTaskExecutor;
        rpc.getClass();
        return (task.isSuccessful() && (bundle = (Bundle) task.getResult()) != null && bundle.containsKey(C0000.decode(new byte[]{4, 87, 11, 94, 94, 81, 79, 90, 6, 75, 23, 92, 92, 83, 4, 69}, "c8d924a7"))) ? rpc.zze(bundle2).onSuccessTask(zzy.zza, zzx.zza) : task;
    }

    public void zah(boolean z, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (((Map) this.processor)) {
            map = new HashMap((Map) this.processor);
        }
        synchronized (((Map) this.workTaskExecutor)) {
            map2 = new HashMap((Map) this.workTaskExecutor);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                entry.getKey().getClass();
                throw new ClassCastException();
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new zzs(status));
            }
        }
    }

    public WorkLauncherImpl() {
        this.processor = Collections.synchronizedMap(new WeakHashMap());
        this.workTaskExecutor = Collections.synchronizedMap(new WeakHashMap());
    }

    public WorkLauncherImpl(Context context) {
        zzag.checkNotNull(context);
        Resources resources = context.getResources();
        this.processor = resources;
        this.workTaskExecutor = resources.getResourcePackageName(2131427345);
    }

    public WorkLauncherImpl(WorkDatabase_Impl workDatabase_Impl) {
        this.processor = workDatabase_Impl;
        this.workTaskExecutor = new WorkTagDao_Impl.AnonymousClass1(workDatabase_Impl, 4);
    }

    public WorkLauncherImpl(FirebaseApp firebaseApp) {
        this.workTaskExecutor = firebaseApp;
    }
}
