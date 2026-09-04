package com.google.android.datatransport.cct.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_LogResponse {
    public final long nextRequestWaitMillis;

    public AutoValue_LogResponse(long j) {
        this.nextRequestWaitMillis = j;
    }

    public static AutoValue_LogResponse fromJson(BufferedReader bufferedReader) throws IOException {
        JsonReader jsonReader = new JsonReader(bufferedReader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals(C0000.decode(new byte[]{92, 87, 75, 64, 98, 84, 65, 66, 92, 18, 16, 51, 80, 88, 70, 127, 90, 88, 92, 88, 67}, "223401079add11", 1))) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        AutoValue_LogResponse autoValue_LogResponse = new AutoValue_LogResponse(Long.parseLong(jsonReader.nextString()));
                        jsonReader.close();
                        return autoValue_LogResponse;
                    }
                    AutoValue_LogResponse autoValue_LogResponse2 = new AutoValue_LogResponse(jsonReader.nextLong());
                    jsonReader.close();
                    return autoValue_LogResponse2;
                }
                jsonReader.skipValue();
            }
            throw new IOException(C0000.decode(new byte[]{49, 1, 75, 70, 86, 90, 75, 87, 18, 92, 18, 24, 14, 15, 16, 23, 81, 88, 94, 20, 86, 87, 74, 65, 51, 93, 18, 19, 6, 23, 76, 97, 88, 93, 76, 127, 91, 89, 13, 81, 16, 70, 5, 13, 93, 90, 93, 26}, "cd86948225a8cf", 0.0f));
        } catch (Throwable th) {
            jsonReader.close();
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AutoValue_LogResponse) && this.nextRequestWaitMillis == ((AutoValue_LogResponse) obj).nextRequestWaitMillis;
    }

    public final int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((int) ((j >>> 32) ^ j)) ^ 1000003;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{126, 9, 5, 102, 3, 65, 67, 10, 11, 21, 6, 25, 95, 4, 74, 18, 48, 81, 23, 71, 86, 22, 17, 49, 2, 11, 69, 44, 91, 10, 14, 93, 21, 15}, "2fb4f23eefcb1a", 0));
        sb.append(this.nextRequestWaitMillis);
        sb.append(C0000.decode(new byte[]{78}, "3df51f"));
        return sb.toString();
    }
}
