package okhttp3;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Address {
    public final CertificatePinner certificatePinner;
    public final List connectionSpecs;
    public final HttpUrl.Companion dns;
    public final HostnameVerifier hostnameVerifier;
    public final List protocols;
    public final HttpUrl.Companion proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactory;
    public final HttpUrl url;

    public Address(String str, int i, HttpUrl.Companion companion, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, HttpUrl.Companion companion2, List list, List list2, ProxySelector proxySelector) {
        this.dns = companion;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = companion2;
        this.proxySelector = proxySelector;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String strDecode = C0000.decode(new byte[]{10, 64, 23, 19}, "b4ccc2", 0.0f);
        String strDecode2 = C0000.decode(new byte[]{91, 16, 68, 70, 21}, "3d06f5fb5605", true);
        String str2 = sSLSocketFactory != null ? strDecode2 : strDecode;
        if (str2.equalsIgnoreCase(strDecode)) {
            builder.scheme = strDecode;
        } else {
            if (!str2.equalsIgnoreCase(strDecode2)) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{66, 87, 80, 65, 73, 82, 82, 18, 83, 1, 25, 74, 84, 81, 80, 84, 92, 13, 17}, "7959971f6e99", 0.0f).concat(str2));
            }
            builder.scheme = strDecode2;
        }
        String canonicalHost = ExceptionsKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(str, 0, 0, 7));
        if (canonicalHost == null) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{64, 13, 81, 25, 64, 83, 91, 71, 83, 87, 17, 88, 11, 22, 17, 91, 21}, "5c4a06836310deea", true).concat(str));
        }
        builder.host = canonicalHost;
        if (1 > i || i >= 65536) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{23, 93, 6, 29, 65, 92, 0, 64, 81, 81, 19, 22, 10, 70, 22, 9, 67}, "b3ce19c4453fe4"), i).toString());
        }
        builder.port = i;
        this.url = builder.build();
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        this.protocols = Collections.unmodifiableList(new ArrayList(list));
        this.connectionSpecs = Collections.unmodifiableList(new ArrayList(list2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return Intrinsics.areEqual(this.url, address.url) && equalsNonHost$okhttp(address);
    }

    public final boolean equalsNonHost$okhttp(Address address) {
        return Intrinsics.areEqual(this.dns, address.dns) && Intrinsics.areEqual(this.proxyAuthenticator, address.proxyAuthenticator) && Intrinsics.areEqual(this.protocols, address.protocols) && Intrinsics.areEqual(this.connectionSpecs, address.connectionSpecs) && Intrinsics.areEqual(this.proxySelector, address.proxySelector) && Intrinsics.areEqual(this.sslSocketFactory, address.sslSocketFactory) && Intrinsics.areEqual(this.hostnameVerifier, address.hostnameVerifier) && Intrinsics.areEqual(this.certificatePinner, address.certificatePinner) && this.url.port == address.url.port;
    }

    public final int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects.hashCode(this.sslSocketFactory) + ((this.proxySelector.hashCode() + ((this.connectionSpecs.hashCode() + ((this.protocols.hashCode() + ((this.proxyAuthenticator.hashCode() + ((this.dns.hashCode() + NetworkType$EnumUnboxingLocalUtility.m(this.url.url, 527, 31)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{32, 7, 7, 19, 86, 70, 18, 77}, "acca35a6f9", true));
        HttpUrl httpUrl = this.url;
        sb.append(httpUrl.host);
        sb.append(':');
        sb.append(httpUrl.port);
        sb.append(C0000.decode(new byte[]{74, 22}, "f66ecad1b37675", 0.0f));
        StringBuilder sb2 = new StringBuilder(C0000.decode(new byte[]{66, 66, 13, 27, 28, 103, 87, 92, 7, 0, 17, 91, 64, 13}, "20bce4", false));
        sb2.append(this.proxySelector);
        sb.append(sb2.toString());
        sb.append('}');
        return sb.toString();
    }
}
