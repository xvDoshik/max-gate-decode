package okhttp3.internal.http2;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 extends Http2Connection.Listener {
    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void onStream(Http2Stream http2Stream) {
        http2Stream.close(8, null);
    }
}
