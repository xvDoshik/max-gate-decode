package okhttp3.internal.connection;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher$Api33Impl;
import androidx.activity.OnBackPressedDispatcher$Api34Impl;
import androidx.work.Configuration;
import androidx.work.Worker;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Exchange {
    public final Object call;
    public final Object codec;
    public Object connection;
    public final Object finder;
    public boolean hasFailure;

    public final class RequestBodySink implements Sink {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public final Sink delegate;

        public RequestBodySink(Sink sink, long j) {
            this.delegate = sink;
            this.contentLength = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException(C0000.decode(new byte[]{69, 91, 86, 77, 21, 81, 85, 64, 1, 81, 16, 80, 93, 81, 69, 91, 80, 20, 23, 65, 66, 80, 82, 88}, "0535e464d5", true));
            }
            try {
                close$okio$ForwardingSink();
                complete$1(null);
            } catch (IOException e) {
                throw complete$1(e);
            }
        }

        public final void close$okio$ForwardingSink() {
            this.delegate.close();
        }

        public final IOException complete$1(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(false, true, iOException);
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            try {
                flush$okio$ForwardingSink();
            } catch (IOException e) {
                throw complete$1(e);
            }
        }

        public final void flush$okio$ForwardingSink() {
            this.delegate.flush();
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return this.delegate.timeout();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(RequestBodySink.class.getSimpleName());
            sb.append('(');
            sb.append(this.delegate);
            sb.append(')');
            return sb.toString();
        }

        @Override // okio.Sink
        public final void write(long j, Buffer buffer) throws IOException {
            if (this.closed) {
                throw new IllegalStateException(C0000.decode(new byte[]{2, 89, 94, 74, 85, 81}, "a5190511b441"));
            }
            long j2 = this.contentLength;
            if (j2 == -1 || this.bytesReceived + j <= j2) {
                try {
                    this.delegate.write(j, buffer);
                    this.bytesReceived += j;
                    return;
                } catch (IOException e) {
                    throw complete$1(e);
                }
            }
            throw new ProtocolException(C0000.decode(new byte[]{82, 65, 73, 1, 82, 65, 85, 83, 68}, "799d1507d0", 0.0f) + j2 + C0000.decode(new byte[]{65, 84, 28, 69, 87, 16, 65, 84, 16, 69, 18, 17, 4, 85, 0, 88, 68, 6, 5, 22}, "a6e12c") + (this.bytesReceived + j));
        }
    }

    public final class ResponseBodySource implements Source {
        public long bytesReceived;
        public boolean closed;
        public boolean completed;
        public final long contentLength;
        public final Source delegate;
        public boolean invokeStartEvent = true;

        public ResponseBodySource(Source source, long j) {
            this.delegate = source;
            this.contentLength = j;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                close$okio$ForwardingSource();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public final void close$okio$ForwardingSource() throws IOException {
            this.delegate.close();
        }

        public final IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            if (iOException == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
            }
            return Exchange.this.bodyComplete(true, false, iOException);
        }

        @Override // okio.Source
        public final long read(long j, Buffer buffer) throws IOException {
            String strDecode = C0000.decode(new byte[]{83, 74, 19, 84, 80, 17, 3, 1, 65}, "62c13efea624b7cb", 0);
            if (this.closed) {
                throw new IllegalStateException(C0000.decode(new byte[]{84, 92, 13, 17, 86, 87}, "70bb3341bb2da3", 1));
            }
            try {
                long j2 = this.delegate.read(8192L, buffer);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                }
                if (j2 == -1) {
                    complete(null);
                    return -1L;
                }
                long j3 = this.bytesReceived + j2;
                long j4 = this.contentLength;
                if (j4 == -1 || j3 <= j4) {
                    this.bytesReceived = j3;
                    if (j3 == j4) {
                        complete(null);
                    }
                    return j2;
                }
                throw new ProtocolException(strDecode + j4 + C0000.decode(new byte[]{22, 0, 31, 70, 80, 23, 22, 0, 19, 70, 21, 22, 83, 1, 3, 91, 67, 1, 82, 66}, "6bf25d", 6) + j3);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.delegate.timeout();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ResponseBodySource.class.getSimpleName());
            sb.append('(');
            sb.append(this.delegate);
            sb.append(')');
            return sb.toString();
        }
    }

    public Exchange(RealCall realCall, Configuration configuration, ExchangeCodec exchangeCodec) {
        this.call = realCall;
        this.finder = configuration;
        this.codec = exchangeCodec;
        this.connection = exchangeCodec.getConnection();
    }

    public IOException bodyComplete(boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            trackFailure(iOException);
        }
        return ((RealCall) this.call).messageDone$okhttp(this, z2, z, iOException);
    }

    public void onBackPressed() {
        ArrayDeque arrayDeque = (ArrayDeque) this.finder;
        ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
        if (listIterator.hasPrevious()) {
            listIterator.previous().getClass();
            throw new ClassCastException();
        }
        ((Worker.AnonymousClass1) this.call).run();
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder responseHeaders = ((ExchangeCodec) this.codec).readResponseHeaders(z);
            if (responseHeaders == null) {
                return responseHeaders;
            }
            responseHeaders.exchange = this;
            return responseHeaders;
        } catch (IOException e) {
            trackFailure(e);
            throw e;
        }
    }

    public void trackFailure(IOException iOException) {
        this.hasFailure = true;
        ((Configuration) this.finder).trackFailure(iOException);
        RealConnection connection = ((ExchangeCodec) this.codec).getConnection();
        RealCall realCall = (RealCall) this.call;
        synchronized (connection) {
            try {
                if (!(iOException instanceof StreamResetException)) {
                    if (!(connection.http2Connection != null) || (iOException instanceof ConnectionShutdownException)) {
                        connection.noNewExchanges = true;
                        if (connection.successCount == 0) {
                            RealConnection.connectFailed$okhttp(realCall.client, connection.route, iOException);
                            connection.routeFailureCount++;
                        }
                    }
                } else if (((StreamResetException) iOException).errorCode == 8) {
                    int i = connection.refusedStreamCount + 1;
                    connection.refusedStreamCount = i;
                    if (i > 1) {
                        connection.noNewExchanges = true;
                        connection.routeFailureCount++;
                    }
                } else if (((StreamResetException) iOException).errorCode != 9 || !realCall.canceled) {
                    connection.noNewExchanges = true;
                    connection.routeFailureCount++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Exchange(Worker.AnonymousClass1 anonymousClass1) {
        OnBackInvokedCallback onBackInvokedCallbackCreateOnBackInvokedCallback;
        this.call = anonymousClass1;
        this.finder = new ArrayDeque();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                final int i2 = 0;
                final int i3 = 1;
                final int i4 = 0;
                final int i5 = 1;
                onBackInvokedCallbackCreateOnBackInvokedCallback = OnBackPressedDispatcher$Api34Impl.INSTANCE.createOnBackAnimationCallback(new Function1(this) { // from class: androidx.activity.OnBackPressedDispatcher$1
                    public final /* synthetic */ Exchange this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i2) {
                            case 0:
                                ArrayDeque arrayDeque = (ArrayDeque) this.this$0.finder;
                                ListIterator listIterator = arrayDeque.listIterator(arrayDeque.getSize());
                                if (!listIterator.hasPrevious()) {
                                    return Unit.INSTANCE;
                                }
                                listIterator.previous().getClass();
                                throw new ClassCastException();
                            default:
                                ArrayDeque arrayDeque2 = (ArrayDeque) this.this$0.finder;
                                ListIterator listIterator2 = arrayDeque2.listIterator(arrayDeque2.getSize());
                                if (!listIterator2.hasPrevious()) {
                                    return Unit.INSTANCE;
                                }
                                listIterator2.previous().getClass();
                                throw new ClassCastException();
                        }
                    }
                }, new Function1(this) { // from class: androidx.activity.OnBackPressedDispatcher$1
                    public final /* synthetic */ Exchange this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i3) {
                            case 0:
                                ArrayDeque arrayDeque = (ArrayDeque) this.this$0.finder;
                                ListIterator listIterator = arrayDeque.listIterator(arrayDeque.getSize());
                                if (!listIterator.hasPrevious()) {
                                    return Unit.INSTANCE;
                                }
                                listIterator.previous().getClass();
                                throw new ClassCastException();
                            default:
                                ArrayDeque arrayDeque2 = (ArrayDeque) this.this$0.finder;
                                ListIterator listIterator2 = arrayDeque2.listIterator(arrayDeque2.getSize());
                                if (!listIterator2.hasPrevious()) {
                                    return Unit.INSTANCE;
                                }
                                listIterator2.previous().getClass();
                                throw new ClassCastException();
                        }
                    }
                }, new Function0(this) { // from class: androidx.activity.OnBackPressedDispatcher$3
                    public final /* synthetic */ Exchange this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i4) {
                            case 0:
                                this.this$0.onBackPressed();
                                return Unit.INSTANCE;
                            case 1:
                                ArrayDeque arrayDeque = (ArrayDeque) this.this$0.finder;
                                ListIterator listIterator = arrayDeque.listIterator(arrayDeque.getSize());
                                if (!listIterator.hasPrevious()) {
                                    return Unit.INSTANCE;
                                }
                                listIterator.previous().getClass();
                                throw new ClassCastException();
                            default:
                                this.this$0.onBackPressed();
                                return Unit.INSTANCE;
                        }
                    }
                }, new Function0(this) { // from class: androidx.activity.OnBackPressedDispatcher$3
                    public final /* synthetic */ Exchange this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i5) {
                            case 0:
                                this.this$0.onBackPressed();
                                return Unit.INSTANCE;
                            case 1:
                                ArrayDeque arrayDeque = (ArrayDeque) this.this$0.finder;
                                ListIterator listIterator = arrayDeque.listIterator(arrayDeque.getSize());
                                if (!listIterator.hasPrevious()) {
                                    return Unit.INSTANCE;
                                }
                                listIterator.previous().getClass();
                                throw new ClassCastException();
                            default:
                                this.this$0.onBackPressed();
                                return Unit.INSTANCE;
                        }
                    }
                });
            } else {
                final int i6 = 2;
                onBackInvokedCallbackCreateOnBackInvokedCallback = OnBackPressedDispatcher$Api33Impl.INSTANCE.createOnBackInvokedCallback(new Function0(this) { // from class: androidx.activity.OnBackPressedDispatcher$3
                    public final /* synthetic */ Exchange this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i6) {
                            case 0:
                                this.this$0.onBackPressed();
                                return Unit.INSTANCE;
                            case 1:
                                ArrayDeque arrayDeque = (ArrayDeque) this.this$0.finder;
                                ListIterator listIterator = arrayDeque.listIterator(arrayDeque.getSize());
                                if (!listIterator.hasPrevious()) {
                                    return Unit.INSTANCE;
                                }
                                listIterator.previous().getClass();
                                throw new ClassCastException();
                            default:
                                this.this$0.onBackPressed();
                                return Unit.INSTANCE;
                        }
                    }
                });
            }
            this.codec = onBackInvokedCallbackCreateOnBackInvokedCallback;
        }
    }
}
