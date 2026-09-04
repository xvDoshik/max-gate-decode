package com.google.firebase.installations.remote;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import androidx.room.RoomOpenHelper;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FirebaseInstallationServiceClient {
    public static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile(C0000.decode(new byte[]{108, 4, 78, 0, 100, 77, 65}, "74c99f233506", false));
    public static final Charset UTF_8 = Charset.forName(C0000.decode(new byte[]{98, 102, 32, 30, 90}, "72f3b99d3be040d6", 0.0f));
    public final Context context;
    public final Provider heartBeatProvider;
    public final RequestLimiter requestLimiter = new RequestLimiter();

    public FirebaseInstallationServiceClient(Context context, Provider provider) {
        this.context = context;
        this.heartBeatProvider = provider;
    }

    public static URL getFullyQualifiedRequestUri(String str) {
        try {
            return new URL(C0000.decode(new byte[]{13, 21, 67, 65, 65, 12, 24, 29, 5, 10, 17, 81, 84, 7, 22, 4, 94, 95, 65, 66, 86, 94, 15, 2, 23, 93, 89, 8, 22, 79, 80, 94, 93, 81, 91, 87, 2, 19, 10, 71, 24, 5, 10, 12, 24, 71, 3, 25}, "ea712672ccc46f") + str);
        } catch (MalformedURLException e) {
            throw new FirebaseInstallationsException(e.getMessage());
        }
    }

    public static void logFisCommunicationError(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, UTF_8));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append('\n');
                }
                str4 = String.format(C0000.decode(new byte[]{33, 64, 66, 95, 23, 16, 64, 81, 1, 92, 16, 83, 10, 93, 90, 76, 10, 91, 83, 81, 17, 89, 89, 94, 68, 69, 89, 68, 13, 16, 67, 81, 1, 18, 118, 89, 23, 85, 85, 88, 23, 87, 16, 121, 11, 67, 67, 88, 8, 94, 81, 68, 12, 95, 89, 74, 68, 65, 85, 66, 19, 85, 69, 25, 37, 98, 121, 30, 69, 120, 99, 109, 52, 18, 66, 85, 22, 64, 88, 87, 23, 87, 10, 16, 62, 21, 83, 25, 65, 65, 10, 16, 64, 67, 106}, "d200e079"), Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str)) {
            return;
        }
        new StringBuilder(C0000.decode(new byte[]{77, 20}, "a45a437c", true)).append(str);
    }

    public static long parseTokenExpirationTimestamp(String str) {
        if (!EXPIRATION_TIMESTAMP_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{47, 8, 79, 84, 93, 91, 80, 17, 125, 28, 64, 12, 20, 80, 64, 90, 9, 8, 25, 97, 88, 95, 81, 66, 76, 5, 93, 21, 72}, "ff9512418d0ef143", true));
        }
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    public static AutoValue_InstallationResponse readCreateResponse(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, UTF_8));
        RoomOpenHelper roomOpenHelperBuilder = AutoValue_TokenResult.builder();
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        String strNextString3 = null;
        AutoValue_TokenResult autoValue_TokenResult = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(C0000.decode(new byte[]{94, 85, 91, 92}, "04697040df", 0.0f))) {
                strNextString = jsonReader.nextString();
            } else if (strNextName.equals(C0000.decode(new byte[]{7, 95, 93}, "a69b6c61e18eba", 0.0f))) {
                strNextString2 = jsonReader.nextString();
            } else if (strNextName.equals(C0000.decode(new byte[]{67, 82, 7, 65, 87, 75, 89, 102, 92, 92, 82, 15}, "17a32812377a", 0.0f))) {
                strNextString3 = jsonReader.nextString();
            } else if (strNextName.equals(C0000.decode(new byte[]{7, 17, 23, 11, 99, 88, 13, 1, 13}, "fdcc77", true))) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals(C0000.decode(new byte[]{16, 88, 90, 93, 86}, "d718898c0bcb9d", 6))) {
                        roomOpenHelperBuilder.configuration = jsonReader.nextString();
                    } else if (strNextName2.equals(C0000.decode(new byte[]{7, 29, 69, 81, 19, 85, 69, 113, 87}, "be58a0689fad", 1))) {
                        roomOpenHelperBuilder.delegate = Long.valueOf(parseTokenExpirationTimestamp(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                AutoValue_TokenResult autoValue_TokenResultBuild = roomOpenHelperBuilder.build();
                jsonReader.endObject();
                autoValue_TokenResult = autoValue_TokenResultBuild;
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return new AutoValue_InstallationResponse(strNextString, strNextString2, strNextString3, autoValue_TokenResult, 1);
    }

    public static AutoValue_TokenResult readGenerateAuthTokenResponse(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, UTF_8));
        RoomOpenHelper roomOpenHelperBuilder = AutoValue_TokenResult.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals(C0000.decode(new byte[]{66, 12, 92, 81, 13}, "6c74cd1479"))) {
                roomOpenHelperBuilder.configuration = jsonReader.nextString();
            } else if (strNextName.equals(C0000.decode(new byte[]{87, 73, 66, 10, 17, 86, 22, 45, 8}, "212cc3edf69adc", 1))) {
                roomOpenHelperBuilder.delegate = Long.valueOf(parseTokenExpirationTimestamp(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        roomOpenHelperBuilder.version = 1;
        return roomOpenHelperBuilder.build();
    }

    public static void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C0000.decode(new byte[]{0, 95, 87}, "f63bede93990f068"), str);
            jSONObject.put(C0000.decode(new byte[]{89, 19, 65, 112, 87}, "8c1934"), str2);
            jSONObject.put(C0000.decode(new byte[]{84, 70, 68, 91, 53, 84, 17, 21, 92, 92, 94}, "5303c1cf", true), C0000.decode(new byte[]{112, 126, 97, 103, 69, 1}, "67283357f1", 0.0f));
            jSONObject.put(C0000.decode(new byte[]{71, 2, 89, 99, 3, 70, 69, 88, 91, 8}, "4f25f461", false), C0000.decode(new byte[]{2, 2, 5, 86, 30, 10, 72, 82}, "c84a08fb0dcb", true));
            writeRequestBodyToOutputStream(httpURLConnection, jSONObject.toString().getBytes(C0000.decode(new byte[]{109, 96, 114, 21, 89}, "8448a1e9b607", true)));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C0000.decode(new byte[]{70, 80, 92, 97, 85, 65, 67, 8, 95, 12}, "5477030a0bb8", 6), C0000.decode(new byte[]{85, 10, 83, 81, 24, 81, 24, 86}, "40bf6c6fbfdd3c90"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C0000.decode(new byte[]{12, 11, 18, 65, 7, 95, 89, 0, 66, 91, 87, 8}, "eea5f35a628fd0", 0.0f), jSONObject);
            writeRequestBodyToOutputStream(httpURLConnection, jSONObject2.toString().getBytes(C0000.decode(new byte[]{99, 49, 118, 21, 14}, "6e0860a618bf", 0.0f)));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void writeRequestBodyToOutputStream(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException(C0000.decode(new byte[]{38, 87, 89, 13, 11, 68, 69, 69, 82, 13, 0, 16, 23, 83, 70, 22, 1, 67, 17, 22, 67, 12, 68, 118, 44, 101, 23, 16, 1, 66, 19, 83, 69, 16, 74, 16, 43, 89, 23, 44, 17, 68, 21, 67, 67, 48, 16, 66, 0, 87, 90, 67, 5, 70, 4, 95, 91, 2, 6, 92, 0, 24}, "e67cd0"));
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:5:0x00b0
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
        */
    public final java.net.HttpURLConnection openHttpURLConnection(java.net.URL r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 569
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.remote.FirebaseInstallationServiceClient.openHttpURLConnection(java.net.URL, java.lang.String):java.net.HttpURLConnection");
    }
}
