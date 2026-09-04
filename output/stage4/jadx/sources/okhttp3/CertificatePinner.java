package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT;
    public final CharsKt certificateChainCleaner;
    public final Set pins;

    static {
        Set setSingleton;
        ArrayList arrayList = new ArrayList();
        int size = arrayList.size();
        if (size != 0) {
            int i = 0;
            if (size != 1) {
                setSingleton = new LinkedHashSet(CloseableKt.mapCapacity(arrayList.size()));
                int size2 = arrayList.size();
                while (i < size2) {
                    Object obj = arrayList.get(i);
                    i++;
                    setSingleton.add(obj);
                }
            } else {
                setSingleton = Collections.singleton(arrayList.get(0));
            }
        } else {
            setSingleton = EmptySet.INSTANCE;
        }
        DEFAULT = new CertificatePinner(setSingleton, null);
    }

    public CertificatePinner(Set set, CharsKt charsKt) {
        this.pins = set;
        this.certificateChainCleaner = charsKt;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return Intrinsics.areEqual(certificatePinner.pins, this.pins) && Intrinsics.areEqual(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    public final int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        CharsKt charsKt = this.certificateChainCleaner;
        return iHashCode + (charsKt != null ? charsKt.hashCode() : 0);
    }
}
