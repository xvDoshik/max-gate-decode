package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.NaturalOrderComparator;
import kotlin.io.CloseableKt;
import okhttp3.internal.Util;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT;
    public static final ConnectionSpec MODERN_TLS;
    public final String[] cipherSuitesAsString;
    public final boolean isTls;
    public final boolean supportsTlsExtensions;
    public final String[] tlsVersionsAsString;

    public final class Builder {
        public String[] cipherSuites;
        public boolean supportsTlsExtensions;
        public boolean tls = true;
        public String[] tlsVersions;

        public final ConnectionSpec build() {
            return new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
        }

        public final void cipherSuites(String... strArr) {
            if (!this.tls) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{8, 86, 18, 81, 15, 67, 81, 85, 64, 20, 22, 77, 94, 16, 3, 66, 70, 95, 93, 64, 70, 80, 85, 85, 83, 70, 17, 93, 79, 16, 70, 82, 9, 87, 92, 87, 5, 71, 80, 95, 92, 71}, "f922f39024e87df1", 3));
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{36, 64, 25, 84, 6, 0, 75, 23, 19, 92, 15, 85, 25, 84, 12, 68, 81, 93, 17, 65, 75, 22, 90, 71, 4, 16, 80, 68, 69, 70, 92, 73, 22, 8, 74, 6, 87}, "e498ca8c33a097", 0.0f));
            }
            this.cipherSuites = (String[]) strArr.clone();
        }

        public final void cipherSuites(CipherSuite... cipherSuiteArr) {
            if (!this.tls) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{86, 11, 68, 91, 80, 70, 11, 0, 20, 70, 18, 64, 91, 66, 87, 70, 24, 2, 11, 74, 25, 85, 15, 0, 7, 20, 21, 80, 74, 66, 18, 86, 87, 10, 10, 93, 90, 66, 10, 10, 8, 21}, "8dd896ceffa52625"));
            }
            ArrayList arrayList = new ArrayList(cipherSuiteArr.length);
            for (CipherSuite cipherSuite : cipherSuiteArr) {
                arrayList.add(cipherSuite.javaName);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            cipherSuites((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final void tlsVersions(String... strArr) {
            if (!this.tls) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{87, 11, 68, 48, 125, 53, 22, 21, 92, 22, 23, 13, 94, 8, 69, 67, 95, 11, 22, 68, 82, 10, 83, 2, 75, 16, 1, 28, 69, 70, 85, 12, 87, 10, 1, 7, 69, 15, 89, 13, 74}, "9ddd1f6c", true));
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{115, 64, 23, 84, 80, 5, 65, 64, 23, 87, 91, 1, 18, 96, 123, 107, 21, 18, 87, 70, 68, 81, 90, 10, 18, 93, 68, 24, 71, 1, 67, 65, 94, 74, 80, 0}, "24785d"));
            }
            this.tlsVersions = (String[]) strArr.clone();
        }

        public final void tlsVersions(TlsVersion... tlsVersionArr) {
            if (!this.tls) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{93, 95, 21, 101, 125, 48, 16, 68, 6, 67, 75, 91, 92, 94, 70, 17, 87, 12, 66, 18, 0, 93, 93, 83, 65, 68, 80, 73, 69, 67, 83, 93, 13, 95, 93, 81, 71, 89, 90, 95, 66}, "30511c02c182", 0.0f));
            }
            ArrayList arrayList = new ArrayList(tlsVersionArr.length);
            for (TlsVersion tlsVersion : tlsVersionArr) {
                arrayList.add(tlsVersion.javaName);
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            tlsVersions((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    static {
        CipherSuite cipherSuite = CipherSuite.TLS_AES_128_GCM_SHA256;
        CipherSuite cipherSuite2 = CipherSuite.TLS_AES_256_GCM_SHA384;
        CipherSuite cipherSuite3 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite4 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite5 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        CipherSuite cipherSuite6 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite7 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        CipherSuite cipherSuite8 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite cipherSuite9 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        CipherSuite[] cipherSuiteArr = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9};
        CipherSuite[] cipherSuiteArr2 = {cipherSuite, cipherSuite2, cipherSuite3, cipherSuite4, cipherSuite5, cipherSuite6, cipherSuite7, cipherSuite8, cipherSuite9, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        Builder builder = new Builder();
        builder.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr, 9));
        TlsVersion tlsVersion = TlsVersion.TLS_1_3;
        TlsVersion tlsVersion2 = TlsVersion.TLS_1_2;
        builder.tlsVersions(tlsVersion, tlsVersion2);
        builder.supportsTlsExtensions = true;
        builder.build();
        Builder builder2 = new Builder();
        builder2.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, 16));
        builder2.tlsVersions(tlsVersion, tlsVersion2);
        builder2.supportsTlsExtensions = true;
        MODERN_TLS = builder2.build();
        Builder builder3 = new Builder();
        builder3.cipherSuites((CipherSuite[]) Arrays.copyOf(cipherSuiteArr2, 16));
        builder3.tlsVersions(tlsVersion, tlsVersion2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        builder3.supportsTlsExtensions = true;
        builder3.build();
        CLEARTEXT = new ConnectionSpec(false, false, null, null);
    }

    public ConnectionSpec(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.isTls = z;
        this.supportsTlsExtensions = z2;
        this.cipherSuitesAsString = strArr;
        this.tlsVersionsAsString = strArr2;
    }

    public final List cipherSuites() {
        String[] strArr = this.cipherSuitesAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CipherSuite.Companion.forJavaName(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = connectionSpec.isTls;
        boolean z2 = this.isTls;
        if (z2 != z) {
            return false;
        }
        if (z2) {
            return Arrays.equals(this.cipherSuitesAsString, connectionSpec.cipherSuitesAsString) && Arrays.equals(this.tlsVersionsAsString, connectionSpec.tlsVersionsAsString) && this.supportsTlsExtensions == connectionSpec.supportsTlsExtensions;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.isTls) {
            return 17;
        }
        String[] strArr = this.cipherSuitesAsString;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.tlsVersionsAsString;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.supportsTlsExtensions ? 1 : 0);
    }

    public final boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.isTls) {
            return false;
        }
        String[] strArr = this.tlsVersionsAsString;
        if (strArr != null && !Util.hasIntersection(strArr, sSLSocket.getEnabledProtocols(), NaturalOrderComparator.INSTANCE)) {
            return false;
        }
        String[] strArr2 = this.cipherSuitesAsString;
        return strArr2 == null || Util.hasIntersection(strArr2, sSLSocket.getEnabledCipherSuites(), CipherSuite.ORDER_BY_NAME);
    }

    public final List tlsVersions() {
        String[] strArr = this.tlsVersionsAsString;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(CloseableKt.forJavaName(str));
        }
        return CollectionsKt.toList(arrayList);
    }

    public final String toString() {
        if (!this.isTls) {
            return C0000.decode(new byte[]{39, 89, 92, 87, 0, 2, 76, 12, 13, 95, 54, 67, 84, 81, 31, 77}, "d629ea8eb1e3127d", false);
        }
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{114, 91, 91, 92, 87, 91, 64, 15, 88, 10, 98, 68, 80, 81, 26, 91, 93, 22, 95, 1, 67, 103, 64, 91, 70, 93, 71, 91}, "1452284f7d", 2));
        List listCipherSuites = cipherSuites();
        String strDecode = C0000.decode(new byte[]{99, 4, 95, 92, 16, 83, 88, 7, 90, 9, 86, 84, 109}, "8e30066f", true);
        sb.append(Objects.toString(listCipherSuites, strDecode));
        sb.append(C0000.decode(new byte[]{26, 22, 21, 93, 16, 103, 84, 20, 71, 81, 89, 88, 18, 12}, "66a1c11f48"));
        sb.append(Objects.toString(tlsVersions(), strDecode));
        sb.append(C0000.decode(new byte[]{78, 17, 22, 16, 64, 17, 95, 22, 22, 66, 49, 9, 67, 36, 72, 16, 7, 95, 22, 12, 95, 15, 67, 89}, "b1ee0a0d", 0.0f));
        sb.append(this.supportsTlsExtensions);
        sb.append(')');
        return sb.toString();
    }
}
