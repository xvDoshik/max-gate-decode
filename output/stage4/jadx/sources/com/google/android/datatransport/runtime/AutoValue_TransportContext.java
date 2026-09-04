package com.google.android.datatransport.runtime;

import android.util.Base64;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import com.google.android.datatransport.Priority;
import com.google.android.gms.cloudmessaging.zzac;
import java.util.Arrays;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoValue_TransportContext {
    public final String backendName;
    public final byte[] extras;
    public final Priority priority;

    public AutoValue_TransportContext(String str, byte[] bArr, Priority priority) {
        this.backendName = str;
        this.extras = bArr;
        this.priority = priority;
    }

    public static zzac builder() {
        zzac zzacVar = new zzac();
        zzacVar.zzc = Priority.DEFAULT;
        return zzacVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_TransportContext) {
            AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) obj;
            if (this.backendName.equals(autoValue_TransportContext.backendName) && Arrays.equals(this.extras, autoValue_TransportContext.extras) && this.priority.equals(autoValue_TransportContext.priority)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.backendName.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras)) * 1000003) ^ this.priority.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.extras;
        String strEncodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{108, 66, 89, 88, 16, 64, 87, 66, 76, 117, 12, 94, 76, 85, 64, 66, 75}, "8086c0", true));
        sb.append(this.backendName);
        String strDecode = C0000.decode(new byte[]{77, 25}, "a9a4d5c43a0605");
        sb.append(strDecode);
        sb.append(this.priority);
        sb.append(strDecode);
        return FileSectionType$EnumUnboxingLocalUtility.m(sb, strEncodeToString, C0000.decode(new byte[]{72}, "a5215d", false));
    }
}
