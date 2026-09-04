package androidx.work.impl.utils;

import android.util.Base64OutputStream;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import com.google.firebase.heartbeatinfo.AutoValue_HeartBeatResult;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class IdGenerator$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ IdGenerator$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String string;
        switch (this.$r8$classId) {
            case 0:
                WorkDatabase workDatabase = ((IdGenerator) this.f$0).workDatabase;
                String strDecode = C0000.decode(new byte[]{93, 1, 79, 76, 61, 89, 95, 5, 69, 85, 61, 85, 82, 10, 86, 95, 7, 74, 108, 13, 83}, "3d78b8", 0.0f);
                Long longValue = workDatabase.preferenceDao().getLongValue(strDecode);
                int iLongValue = longValue != null ? (int) longValue.longValue() : 0;
                workDatabase.preferenceDao().insertPreference(new Preference(strDecode, Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                return Integer.valueOf(iLongValue);
            case 1:
                DefaultHeartBeatController defaultHeartBeatController = (DefaultHeartBeatController) this.f$0;
                synchronized (defaultHeartBeatController) {
                    try {
                        Store store = (Store) defaultHeartBeatController.storageProvider.get();
                        ArrayList allHeartBeats = store.getAllHeartBeats();
                        store.deleteAllHeartBeats();
                        JSONArray jSONArray = new JSONArray();
                        for (int i = 0; i < allHeartBeats.size(); i++) {
                            AutoValue_HeartBeatResult autoValue_HeartBeatResult = (AutoValue_HeartBeatResult) allHeartBeats.get(i);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(C0000.decode(new byte[]{3, 86, 80, 90, 65}, "b15453ce", 3), autoValue_HeartBeatResult.userAgent);
                            jSONObject.put(C0000.decode(new byte[]{84, 89, 66, 4, 17}, "086abb6057", 3), new JSONArray((Collection) autoValue_HeartBeatResult.usedDates));
                            jSONArray.put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(C0000.decode(new byte[]{9, 6, 88, 22, 69, 83, 92, 82, 18, 70}, "ac9d1193f5", 0.0f), jSONArray);
                        jSONObject2.put(C0000.decode(new byte[]{65, 86, 20, 22, 13, 90, 89}, "73fed5", true), C0000.decode(new byte[]{1}, "35a1f3e9dc0cd0"));
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                        try {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                            try {
                                gZIPOutputStream.write(jSONObject2.toString().getBytes(C0000.decode(new byte[]{52, 55, 127, 26, 9}, "ac971910d9")));
                                gZIPOutputStream.close();
                                base64OutputStream.close();
                                string = byteArrayOutputStream.toString(C0000.decode(new byte[]{102, 109, 113, 28, 91}, "3971ca42609ae74e", 0.0f));
                            } catch (Throwable th) {
                                try {
                                    gZIPOutputStream.close();
                                    break;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            try {
                                base64OutputStream.close();
                                break;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        throw th5;
                    }
                }
                return string;
            default:
                DefaultHeartBeatController defaultHeartBeatController2 = (DefaultHeartBeatController) this.f$0;
                synchronized (defaultHeartBeatController2) {
                    ((Store) defaultHeartBeatController2.storageProvider.get()).storeHeartBeat(System.currentTimeMillis(), ((DefaultUserAgentPublisher) defaultHeartBeatController2.userAgentProvider.get()).getUserAgent());
                    break;
                }
                return null;
        }
    }
}
