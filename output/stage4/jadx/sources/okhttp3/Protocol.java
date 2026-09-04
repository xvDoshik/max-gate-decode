package okhttp3;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public enum Protocol {
    HTTP_1_0(0),
    HTTP_1_1(1),
    SPDY_3(2),
    HTTP_2(3),
    H2_PRIOR_KNOWLEDGE(4),
    QUIC(5);

    public final String protocol;

    Protocol(int i) {
        this.protocol = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.protocol;
    }
}
