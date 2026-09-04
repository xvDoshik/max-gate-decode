package okio;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface Sink extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    Timeout timeout();

    void write(long j, Buffer buffer);
}
