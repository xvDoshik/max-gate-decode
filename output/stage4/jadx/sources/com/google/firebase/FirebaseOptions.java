package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkLauncherImpl;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.Strings;
import java.util.Arrays;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FirebaseOptions {
    public final String apiKey;
    public final String applicationId;
    public final String databaseUrl;
    public final String gaTrackingId;
    public final String gcmSenderId;
    public final String projectId;
    public final String storageBucket;

    public FirebaseOptions(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = Strings.$r8$clinit;
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalStateException(C0000.decode(new byte[]{112, 17, 19, 91, 95, 0, 0, 71, 88, 14, 13, 126, 82, 67, 12, 70, 66, 21, 67, 85, 83, 67, 18, 86, 69, 79}, "1ac76ca3", 0.0f));
        }
        this.applicationId = str;
        this.apiKey = str2;
        this.databaseUrl = str3;
        this.gaTrackingId = str4;
        this.gcmSenderId = str5;
        this.storageBucket = str6;
        this.projectId = str7;
    }

    public static FirebaseOptions fromResource(Context context) {
        WorkLauncherImpl workLauncherImpl = new WorkLauncherImpl(context);
        String string = workLauncherImpl.getString(C0000.decode(new byte[]{2, 11, 92, 1, 10, 1, 62, 82, 72, 19, 57, 12, 87}, "ed3ffda38cfe3e", 0.0f));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new FirebaseOptions(string, workLauncherImpl.getString(C0000.decode(new byte[]{83, 12, 89, 5, 91, 93, 102, 7, 66, 95, 103, 88, 80, 72}, "4c6b789f268351", 0.0f)), workLauncherImpl.getString(C0000.decode(new byte[]{83, 80, 75, 0, 7, 4, 74, 86, 106, 93, 88, 17, 4, 7, 88, 64, 80, 102, 76, 23, 9}, "599eee93", false)), workLauncherImpl.getString(C0000.decode(new byte[]{1, 0, 105, 21, 66, 88, 1, 14, 91, 10, 94, 45, 82}, "fa6a09be2d9d6ab9", 0.0f)), workLauncherImpl.getString(C0000.decode(new byte[]{80, 86, 11, 110, 83, 7, 94, 5, 17, 90, 17, 98, 82, 91, 2, 84, 69, 43, 92}, "75f17b8dd6e1", true)), workLauncherImpl.getString(C0000.decode(new byte[]{82, 10, 89, 87, 84, 83, 111, 71, 23, 89, 20, 7, 83, 83, 108, 7, 64, 6, 93, 85, 76}, "5e608604c6ff463e")), workLauncherImpl.getString(C0000.decode(new byte[]{68, 19, 90, 8, 87, 80, 21, 104, 93, 5}, "4a5b23a7", 5)));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return zzag.equal(this.applicationId, firebaseOptions.applicationId) && zzag.equal(this.apiKey, firebaseOptions.apiKey) && zzag.equal(this.databaseUrl, firebaseOptions.databaseUrl) && zzag.equal(this.gaTrackingId, firebaseOptions.gaTrackingId) && zzag.equal(this.gcmSenderId, firebaseOptions.gcmSenderId) && zzag.equal(this.storageBucket, firebaseOptions.storageBucket) && zzag.equal(this.projectId, firebaseOptions.projectId);
    }

    public final int hashCode() {
        String str = this.storageBucket;
        String str2 = this.projectId;
        return Arrays.hashCode(new Object[]{this.applicationId, this.apiKey, this.databaseUrl, this.gaTrackingId, this.gcmSenderId, str, str2});
    }

    public final String toString() {
        OperationImpl operationImpl = new OperationImpl(this);
        operationImpl.add(this.applicationId, C0000.decode(new byte[]{5, 67, 22, 92, 81, 2, 82, 67, 90, 13, 15, 124, 0}, "d3f08a373ba5", 5));
        operationImpl.add(this.apiKey, C0000.decode(new byte[]{83, 71, 8, 123, 84, 28}, "27a01e0b", 7));
        operationImpl.add(this.databaseUrl, C0000.decode(new byte[]{85, 3, 77, 5, 81, 82, 66, 7, 108, 22, 95}, "1b9d33", 4));
        operationImpl.add(this.gcmSenderId, C0000.decode(new byte[]{87, 5, 94, 55, 1, 87, 7, 93, 17, 40, 7}, "0f3dd9c8cac8"));
        operationImpl.add(this.storageBucket, C0000.decode(new byte[]{69, 76, 86, 74, 87, 83, 1, 33, 19, 80, 95, 93, 68}, "689864dcf34808", 3));
        operationImpl.add(this.projectId, C0000.decode(new byte[]{18, 17, 88, 95, 86, 91, 22, 42, 83}, "bc7538", true));
        return operationImpl.toString();
    }
}
