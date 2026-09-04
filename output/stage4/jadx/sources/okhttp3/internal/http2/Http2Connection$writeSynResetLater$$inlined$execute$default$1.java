package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.concurrent.Task;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http2Connection$writeSynResetLater$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ int $errorCode$inlined;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Http2Connection$writeSynResetLater$$inlined$execute$default$1(String str, Http2Connection http2Connection, int i, int i2, int i3) {
        super(str, true);
        this.$r8$classId = i3;
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$errorCode$inlined = i2;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        switch (this.$r8$classId) {
            case 0:
                Http2Connection http2Connection = this.this$0;
                try {
                    http2Connection.writer.rstStream(this.$streamId$inlined, this.$errorCode$inlined);
                } catch (IOException e) {
                    http2Connection.close$okhttp(2, 2, e);
                    return -1L;
                }
                break;
            default:
                Http2Connection http2Connection2 = this.this$0;
                try {
                    http2Connection2.writer.ping(true, this.$streamId$inlined, this.$errorCode$inlined);
                } catch (IOException e2) {
                    http2Connection2.close$okhttp(2, 2, e2);
                    return -1L;
                }
                break;
        }
        return -1L;
    }
}
