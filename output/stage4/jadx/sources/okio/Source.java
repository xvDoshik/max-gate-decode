package okio;

import java.io.Closeable;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Source extends Closeable {
    long read(long j, Buffer buffer);

    Timeout timeout();
}
