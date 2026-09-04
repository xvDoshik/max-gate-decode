package okhttp3;

import java.io.Closeable;
import okhttp3.internal.Util;
import okio.BufferedSource;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ResponseBody implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();
}
