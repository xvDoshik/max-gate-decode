package androidx.startup;

import android.os.Parcel;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class StartupException extends RuntimeException {
    public StartupException(String str, Parcel parcel) {
        super(str + C0000.decode(new byte[]{25, 98, 87, 20, 87, 0, 95, 88, 20, 69, 92, 65, 4}, "926f4e3b4532", 0.0f) + parcel.dataPosition() + C0000.decode(new byte[]{19, 74, 89, 72, 3, 88}, "3902fe5b93") + parcel.dataSize());
    }
}
