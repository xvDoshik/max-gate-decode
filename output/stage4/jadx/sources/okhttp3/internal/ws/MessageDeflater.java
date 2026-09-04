package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.DeflaterSink;
import okio.InflaterSource;
import okio.RealBufferedSource;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class MessageDeflater implements Closeable {
    public final /* synthetic */ int $r8$classId;
    public final Buffer deflatedBytes;
    public final Object deflater;
    public final Closeable deflaterSink;
    public final boolean noContextTakeover;

    public MessageDeflater(int i, boolean z) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.noContextTakeover = z;
                Buffer buffer = new Buffer();
                this.deflatedBytes = buffer;
                Inflater inflater = new Inflater(true);
                this.deflater = inflater;
                this.deflaterSink = new InflaterSource(new RealBufferedSource(buffer), inflater);
                break;
            default:
                this.noContextTakeover = z;
                Buffer buffer2 = new Buffer();
                this.deflatedBytes = buffer2;
                Deflater deflater = new Deflater(-1, true);
                this.deflater = deflater;
                this.deflaterSink = new DeflaterSink(buffer2, deflater);
                break;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                ((DeflaterSink) this.deflaterSink).close();
                break;
            default:
                ((InflaterSource) this.deflaterSink).close();
                break;
        }
    }
}
