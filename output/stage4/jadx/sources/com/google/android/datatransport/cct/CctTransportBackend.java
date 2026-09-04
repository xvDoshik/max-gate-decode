package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import androidx.tracing.Trace;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$ClientInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$LogEventEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$LogRequestEncoder;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import okhttp3.ConnectionPool;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CctTransportBackend implements TransportBackend {
    public final Context applicationContext;
    public final ConnectivityManager connectivityManager;
    public final ConnectionPool dataEncoder;
    public final URL endPoint;
    public final int readTimeout;
    public final Clock uptimeClock;
    public final Clock wallTimeClock;

    public final class HttpResponse {
        public final int code;
        public final long nextRequestMillis;
        public final URL redirectUrl;

        public HttpResponse(int i, URL url, long j) {
            this.code = i;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder autoBatchedLogRequestEncoder$BatchedLogRequestEncoder = AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(BatchedLogRequest.class, autoBatchedLogRequestEncoder$BatchedLogRequestEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_BatchedLogRequest.class, autoBatchedLogRequestEncoder$BatchedLogRequestEncoder);
        AutoBatchedLogRequestEncoder$LogRequestEncoder autoBatchedLogRequestEncoder$LogRequestEncoder = AutoBatchedLogRequestEncoder$LogRequestEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(LogRequest.class, autoBatchedLogRequestEncoder$LogRequestEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_LogRequest.class, autoBatchedLogRequestEncoder$LogRequestEncoder);
        AutoBatchedLogRequestEncoder$ClientInfoEncoder autoBatchedLogRequestEncoder$ClientInfoEncoder = AutoBatchedLogRequestEncoder$ClientInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(ClientInfo.class, autoBatchedLogRequestEncoder$ClientInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_ClientInfo.class, autoBatchedLogRequestEncoder$ClientInfoEncoder);
        AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder autoBatchedLogRequestEncoder$AndroidClientInfoEncoder = AutoBatchedLogRequestEncoder$AndroidClientInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(AndroidClientInfo.class, autoBatchedLogRequestEncoder$AndroidClientInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_AndroidClientInfo.class, autoBatchedLogRequestEncoder$AndroidClientInfoEncoder);
        AutoBatchedLogRequestEncoder$LogEventEncoder autoBatchedLogRequestEncoder$LogEventEncoder = AutoBatchedLogRequestEncoder$LogEventEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(LogEvent.class, autoBatchedLogRequestEncoder$LogEventEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_LogEvent.class, autoBatchedLogRequestEncoder$LogEventEncoder);
        AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder = AutoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder.INSTANCE;
        jsonDataEncoderBuilder.registerEncoder(NetworkConnectionInfo.class, autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder);
        jsonDataEncoderBuilder.registerEncoder(AutoValue_NetworkConnectionInfo.class, autoBatchedLogRequestEncoder$NetworkConnectionInfoEncoder);
        jsonDataEncoderBuilder.ignoreNullValues = true;
        this.dataEncoder = new ConnectionPool(20, jsonDataEncoderBuilder);
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService(C0000.decode(new byte[]{0, 10, 8, 13, 80, 81, 70, 15, 65, 92, 68, 77}, "cefc522f7504e8"));
        this.endPoint = parseUrlOrThrow(CCTDestination.DEFAULT_END_POINT);
        this.uptimeClock = clock2;
        this.wallTimeClock = clock;
        this.readTimeout = 130000;
    }

    public static URL parseUrlOrThrow(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{40, 93, 23, 84, 94, 11, 86, 19, 64, 74, 95, 13, 65}, "a3a52b235837") + str, e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0149  */
    /* JADX WARN: Code duplicated, block: B:29:0x020c  */
    public final AutoValue_EventInternal decorate(AutoValue_EventInternal autoValue_EventInternal) {
        int type;
        int subtype;
        HashMap map;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        Request builder = autoValue_EventInternal.toBuilder();
        int i = Build.VERSION.SDK_INT;
        HashMap map2 = (HashMap) builder.lazyCacheControl;
        String strDecode = C0000.decode(new byte[]{97, 65, 94, 73, 92, 23, 22, 77, 22, 20, 0, 20, 66, 12, 124, 86, 69, 88, 93, 4, 22, 85, 20, 22, 9, 0, 69, 67, 95, 92, 69, 25, 91, 0, 7, 90, 22, 69, 4, 21}, "13199eb466aa6c", 0.0f);
        if (map2 == null) {
            throw new IllegalStateException(strDecode);
        }
        map2.put(C0000.decode(new byte[]{68, 81, 9, 72, 19, 87, 17, 18, 93, 90, 89}, "75bee2ca4572", 0.0f), String.valueOf(i));
        builder.addMetadata(C0000.decode(new byte[]{14, 92, 6, 0, 15}, "c3becb685df6c3"), Build.MODEL);
        builder.addMetadata(C0000.decode(new byte[]{95, 2, 20, 5, 69, 88, 67, 82}, "7cfa2917abe5", 0.0f), Build.HARDWARE);
        builder.addMetadata(C0000.decode(new byte[]{0, 92, 21, 91, 5, 6}, "d9c2fc98", 6), Build.DEVICE);
        builder.addMetadata(C0000.decode(new byte[]{64, 20, 10, 81, 65, 87, 68}, "0fe544"), Build.PRODUCT);
        builder.addMetadata(C0000.decode(new byte[]{10, 71, 26, 19, 81, 8, 85}, "e47f8d19bc6800", 0.0f), Build.ID);
        builder.addMetadata(C0000.decode(new byte[]{9, 3, 88, 68, 95, 82, 5, 22, 20, 74, 80, 16}, "db6193fba85b8f"), Build.MANUFACTURER);
        builder.addMetadata(C0000.decode(new byte[]{0, 11, 11, 95, 86, 17, 17, 71, 95, 92, 77}, "fbe83ca5629b", false), Build.FINGERPRINT);
        Calendar.getInstance();
        long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
        HashMap map3 = (HashMap) builder.lazyCacheControl;
        if (map3 == null) {
            throw new IllegalStateException(strDecode);
        }
        map3.put(C0000.decode(new byte[]{66, 67, 79, 88, 95, 82, 68, 7, 66}, "69b7947b"), String.valueOf(offset));
        int i2 = -1;
        if (activeNetworkInfo == null) {
            SparseArray sparseArray = NetworkConnectionInfo.NetworkType.valueMap;
            type = -1;
        } else {
            type = activeNetworkInfo.getType();
        }
        HashMap map4 = (HashMap) builder.lazyCacheControl;
        if (map4 == null) {
            throw new IllegalStateException(strDecode);
        }
        map4.put(C0000.decode(new byte[]{93, 82, 64, 75, 67, 78, 68, 85}, "374f7740", 5), String.valueOf(type));
        if (activeNetworkInfo != null) {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                SparseArray sparseArray2 = NetworkConnectionInfo.MobileSubtype.valueMap;
                subtype = 100;
            } else if (((NetworkConnectionInfo.MobileSubtype) NetworkConnectionInfo.MobileSubtype.valueMap.get(subtype)) == null) {
            }
            map = (HashMap) builder.lazyCacheControl;
            if (map != null) {
                throw new IllegalStateException(strDecode);
            }
            map.put(C0000.decode(new byte[]{11, 88, 4, 89, 9, 82, 72, 68, 77, 86, 68, 75, 17, 85}, "f7f0e7e78402a03b"), String.valueOf(subtype));
            builder.addMetadata(C0000.decode(new byte[]{91, 90, 71, 91, 68, 69, 75}, "85250726b6176a29", 0.0f), Locale.getDefault().getCountry());
            builder.addMetadata(C0000.decode(new byte[]{85, 10, 90, 85, 9, 6}, "9e94ec8aab3c3418", false), Locale.getDefault().getLanguage());
            String strDecode2 = C0000.decode(new byte[]{67, 88, 11, 94, 86}, "30d03dfceb", 4);
            Context context = this.applicationContext;
            builder.addMetadata(C0000.decode(new byte[]{88, 84, 81, 111, 93, 11, 82}, "57200e160696ef", 3), ((TelephonyManager) context.getSystemService(strDecode2)).getSimOperator());
            try {
                i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Trace.getTag(C0000.decode(new byte[]{33, 87, 67, 100, 19, 5, 87, 18, 18, 91, 69, 68, 35, 5, 90, 10, 7, 90, 83}, "b470ad9a", 0.0f));
            }
            builder.addMetadata(C0000.decode(new byte[]{89, 69, 68, 85, 93, 85, 2, 69, 11, 90, 86, 106, 86, 76, 93, 90, 7}, "854946c1b5", 6), Integer.toString(i2));
            return builder.build();
        }
        SparseArray sparseArray3 = NetworkConnectionInfo.MobileSubtype.valueMap;
        subtype = 0;
        map = (HashMap) builder.lazyCacheControl;
        if (map != null) {
            throw new IllegalStateException(strDecode);
        }
        map.put(C0000.decode(new byte[]{11, 88, 4, 89, 9, 82, 72, 68, 77, 86, 68, 75, 17, 85}, "f7f0e7e78402a03b"), String.valueOf(subtype));
        builder.addMetadata(C0000.decode(new byte[]{91, 90, 71, 91, 68, 69, 75}, "85250726b6176a29", 0.0f), Locale.getDefault().getCountry());
        builder.addMetadata(C0000.decode(new byte[]{85, 10, 90, 85, 9, 6}, "9e94ec8aab3c3418", false), Locale.getDefault().getLanguage());
        String strDecode3 = C0000.decode(new byte[]{67, 88, 11, 94, 86}, "30d03dfceb", 4);
        Context context2 = this.applicationContext;
        builder.addMetadata(C0000.decode(new byte[]{88, 84, 81, 111, 93, 11, 82}, "57200e160696ef", 3), ((TelephonyManager) context2.getSystemService(strDecode3)).getSimOperator());
        i2 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
        builder.addMetadata(C0000.decode(new byte[]{89, 69, 68, 85, 93, 85, 2, 69, 11, 90, 86, 106, 86, 76, 93, 90, 7}, "854946c1b5", 6), Integer.toString(i2));
        return builder.build();
    }
}
