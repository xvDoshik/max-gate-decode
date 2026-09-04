package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.text.Regex;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.platform.Platform;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $settings$inlined;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(String str, Object obj, Object obj2, int i) {
        super(str, true);
        this.$r8$classId = i;
        this.this$0 = obj;
        this.$settings$inlined = obj2;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        int i;
        long initialWindowSize;
        Http2Stream[] http2StreamArr;
        switch (this.$r8$classId) {
            case 0:
                Http2Connection.ReaderRunnable readerRunnable = (Http2Connection.ReaderRunnable) this.this$0;
                Settings settings = (Settings) this.$settings$inlined;
                int i2 = 1;
                Regex regex = new Regex(1);
                Http2Connection http2Connection = Http2Connection.this;
                synchronized (http2Connection.writer) {
                    try {
                        synchronized (http2Connection) {
                            try {
                                Settings settings2 = http2Connection.peerSettings;
                                Settings settings3 = new Settings();
                                for (int i3 = 0; i3 < 10; i3++) {
                                    if (((1 << i3) & settings2.set) != 0) {
                                        settings3.set(i3, settings2.values[i3]);
                                    }
                                }
                                for (int i4 = 0; i4 < 10; i4++) {
                                    if (((1 << i4) & settings.set) != 0) {
                                        settings3.set(i4, settings.values[i4]);
                                    }
                                }
                                regex.nativePattern = settings3;
                                initialWindowSize = ((long) settings3.getInitialWindowSize()) - ((long) settings2.getInitialWindowSize());
                                http2StreamArr = (initialWindowSize == 0 || http2Connection.streams.isEmpty()) ? null : (Http2Stream[]) http2Connection.streams.values().toArray(new Http2Stream[0]);
                                http2Connection.peerSettings = (Settings) regex.nativePattern;
                                http2Connection.settingsListenerQueue.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(http2Connection.connectionName + C0000.decode(new byte[]{19, 91, 93, 107, 7, 71, 16, 89, 94, 2, 21}, "3438b3d00efc", true), http2Connection, regex, i2), 0L);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        try {
                            http2Connection.writer.applyAndAckSettings((Settings) regex.nativePattern);
                        } catch (IOException e) {
                            http2Connection.close$okhttp(2, 2, e);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                if (http2StreamArr != null) {
                    for (Http2Stream http2Stream : http2StreamArr) {
                        synchronized (http2Stream) {
                            http2Stream.writeBytesMaximum += initialWindowSize;
                            if (initialWindowSize > 0) {
                                http2Stream.notifyAll();
                            }
                            break;
                        }
                    }
                }
                return -1L;
            case 1:
                ((Http2Connection) this.this$0).listener.onSettings((Settings) ((Regex) this.$settings$inlined).nativePattern);
                return -1L;
            default:
                try {
                    ((Http2Connection) this.this$0).listener.onStream((Http2Stream) this.$settings$inlined);
                    break;
                } catch (IOException e2) {
                    Platform platform = Platform.platform;
                    Platform platform2 = Platform.platform;
                    String str = C0000.decode(new byte[]{42, 67, 16, 20, 11, 115, 10, 12, 13, 87, 1, 67, 13, 11, 87, 30, 41, 11, 16, 70, 7, 89, 1, 22, 25, 86, 4, 11, 15, 71, 16, 82, 68, 2, 86, 66, 69}, "b7dd90ebc2") + ((Http2Connection) this.this$0).connectionName;
                    platform2.getClass();
                    Platform.log(str, 4, e2);
                    try {
                        ((Http2Stream) this.$settings$inlined).close(2, e2);
                        break;
                    } catch (IOException unused) {
                    }
                }
                return -1L;
        }
    }
}
