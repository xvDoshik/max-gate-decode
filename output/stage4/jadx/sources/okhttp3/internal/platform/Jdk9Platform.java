package okhttp3.internal.platform;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import okhttp3.Protocol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Jdk9Platform extends Platform {
    public static final boolean isAvailable;

    static {
        String property = System.getProperty(C0000.decode(new byte[]{88, 84, 78, 82, 31, 68, 65, 93, 81, 92, 94, 90, 82, 86, 69, 81, 93, 91, 22, 69, 84, 69, 66, 81, 93, 91}, "25831718"));
        Integer intOrNull = property != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(property) : null;
        boolean z = false;
        if (intOrNull == null) {
            try {
                SSLSocket.class.getMethod(C0000.decode(new byte[]{4, 81, 69, 120, 17, 65, 15, 12, 6, 4, 67, 12, 92, 13, 51, 70, 94, 77, 14, 82, 12, 9}, "c419a1ceee7e3c"), null);
                z = true;
            } catch (NoSuchMethodException unused) {
            }
        } else if (intOrNull.intValue() >= 9) {
            z = true;
        }
        isAvailable = z;
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Protocol) obj) != Protocol.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((Protocol) obj2).protocol);
        }
        sSLParameters.setApplicationProtocols((String[]) arrayList2.toArray(new String[0]));
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
