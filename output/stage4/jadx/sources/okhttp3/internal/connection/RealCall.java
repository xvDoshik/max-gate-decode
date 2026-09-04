package okhttp3.internal.connection;

import androidx.work.Configuration;
import androidx.work.impl.WorkLauncherImpl;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.ws.RealWebSocket;
import okio.AsyncTimeout;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealCall implements Cloneable {
    public Object callStackTrace;
    public volatile boolean canceled;
    public final OkHttpClient client;
    public RealConnection connection;
    public final RealConnectionPool connectionPool;
    public volatile RealConnection connectionToCancel;
    public volatile Exchange exchange;
    public Configuration exchangeFinder;
    public final AtomicBoolean executed;
    public boolean expectMoreExchanges;
    public final boolean forWebSocket;
    public Exchange interceptorScopedExchange;
    public final Request originalRequest;
    public boolean requestBodyOpen;
    public boolean responseBodyOpen;
    public final RealCall$timeout$1 timeout;
    public boolean timeoutEarlyExit;

    public final class AsyncCall implements Runnable {
        public volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        public final WorkLauncherImpl responseCallback;

        public AsyncCall(WorkLauncherImpl workLauncherImpl) {
            this.responseCallback = workLauncherImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OkHttpClient okHttpClient;
            String strDecode = C0000.decode(new byte[]{115, 0, 91, 91, 81, 84, 5, 91, 25, 3, 82, 91, 10, 16, 66, 4, 23, 81, 92, 71, 70}, "0a7735f09e32fe", false);
            String strDecode2 = C0000.decode(new byte[]{84, 88, 93, 7, 87, 13, 6, 2, 68, 5, 17, 81, 70, 76, 88, 25}, "793d2acfdad4f8");
            String strConcat = C0000.decode(new byte[]{42, 15, 42, 16, 17, 20, 19}, "edbded31033cac4b", true).concat(((HttpUrl) RealCall.this.originalRequest.url).redact());
            RealCall realCall = RealCall.this;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(strConcat);
            try {
                realCall.timeout.enter();
                boolean z = false;
                try {
                    try {
                        try {
                            this.responseCallback.onResponse(realCall.getResponseWithInterceptorChain$okhttp());
                            okHttpClient = realCall.client;
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (z) {
                                Platform platform = Platform.platform;
                                Platform platform2 = Platform.platform;
                                String str = strDecode + RealCall.access$toLoggableString(realCall);
                                platform2.getClass();
                                Platform.log(str, 4, e);
                            } else {
                                ((RealWebSocket) this.responseCallback.processor).failWebSocket(e);
                            }
                            okHttpClient = realCall.client;
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            realCall.cancel();
                            if (!z) {
                                IOException iOException = new IOException(strDecode2 + th);
                                ExceptionsKt.addSuppressed(iOException, th);
                                ((RealWebSocket) this.responseCallback.processor).failWebSocket(iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        realCall.client.dispatcher.finished$okhttp(this);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
                okHttpClient.dispatcher.finished$okhttp(this);
                threadCurrentThread.setName(name);
            } catch (Throwable th4) {
                threadCurrentThread.setName(name);
                throw th4;
            }
        }
    }

    public final class CallReference extends WeakReference {
        public final Object callStackTrace;

        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            this.callStackTrace = obj;
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [okhttp3.internal.connection.RealCall$timeout$1, okio.Timeout] */
    public RealCall(OkHttpClient okHttpClient, Request request, boolean z) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z;
        this.connectionPool = (RealConnectionPool) okHttpClient.connectionPool.delegate;
        okHttpClient.eventListenerFactory.getClass();
        ?? r2 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            public final void timedOut() {
                this.this$0.cancel();
            }
        };
        r2.timeout(0, TimeUnit.MILLISECONDS);
        this.timeout = r2;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public static final String access$toLoggableString(RealCall realCall) {
        StringBuilder sb = new StringBuilder();
        sb.append(realCall.canceled ? C0000.decode(new byte[]{82, 80, 86, 82, 1, 10, 93, 0, 21}, "1181df8d55") : "");
        sb.append(realCall.forWebSocket ? C0000.decode(new byte[]{21, 87, 80, 20, 67, 94, 87, 82, 3, 17}, "b2240149fe623141", false) : C0000.decode(new byte[]{1, 87, 84, 15}, "b68cf1f5e1fa"));
        sb.append(C0000.decode(new byte[]{68, 77, 91, 70}, "d94f7a57c429", true));
        sb.append(((HttpUrl) realCall.originalRequest.url).redact());
        return sb.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        if (this.connection != null) {
            throw new IllegalStateException(C0000.decode(new byte[]{33, 80, 82, 7, 93, 16, 4, 89, 94, 8, 83, 84, 76}, "b87d60", 0.0f));
        }
        this.connection = realConnection;
        realConnection.calls.add(new CallReference(this, this.callStackTrace));
    }

    public final IOException callDone(IOException iOException) {
        Socket socketReleaseConnectionNoEvents$okhttp;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            synchronized (realConnection) {
                socketReleaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                }
            } else if (socketReleaseConnectionNoEvents$okhttp != null) {
                throw new IllegalStateException(C0000.decode(new byte[]{38, 94, 80, 87, 10, 17, 2, 0, 8, 90, 4, 87, 74}, "e654a1daa6a3d4", 2));
            }
        }
        if (this.timeoutEarlyExit || !exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException(C0000.decode(new byte[]{17, 13, 91, 85, 11, 69, 22}, "ed60d0bbdec68b5e", 0.0f));
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void cancel() {
        Socket socket;
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            ((ExchangeCodec) exchange.codec).cancel();
        }
        RealConnection realConnection = this.connectionToCancel;
        if (realConnection == null || (socket = realConnection.rawSocket) == null) {
            return;
        }
        Util.closeQuietly(socket);
    }

    public final Object clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    public final Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
            throw new IllegalStateException(C0000.decode(new byte[]{114, 93, 74, 7, 80, 7, 76, 21, 118, 73, 93, 1, 68, 23, 80, 81}, "318b1c55", true));
        }
        enter();
        Platform platform = Platform.platform;
        this.callStackTrace = Platform.platform.getStackTraceForCloseable();
        try {
            Dispatcher dispatcher = this.client.dispatcher;
            synchronized (dispatcher) {
                ((ArrayDeque) dispatcher.runningSyncCalls).add(this);
            }
            Response responseWithInterceptorChain$okhttp = getResponseWithInterceptorChain$okhttp();
            Dispatcher dispatcher2 = this.client.dispatcher;
            dispatcher2.finished((ArrayDeque) dispatcher2.runningSyncCalls, this);
            return responseWithInterceptorChain$okhttp;
        } catch (Throwable th) {
            Dispatcher dispatcher3 = this.client.dispatcher;
            dispatcher3.finished((ArrayDeque) dispatcher3.runningSyncCalls, this);
            throw th;
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Exchange exchange;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException(C0000.decode(new byte[]{75, 92, 84, 0, 3, 69, 92, 81}, "998eb695", false));
            }
        }
        if (z && (exchange = this.exchange) != null) {
            ((ExchangeCodec) exchange.codec).cancel();
            ((RealCall) exchange.call).messageDone$okhttp(exchange, true, true, null);
        }
        this.interceptorScopedExchange = null;
    }

    public final Response getResponseWithInterceptorChain$okhttp() {
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.client.interceptors);
        arrayList.add(new BridgeInterceptor(1, this.client));
        arrayList.add(new BridgeInterceptor(0, this.client.cookieJar));
        arrayList.add(new CacheInterceptor());
        arrayList.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.client.networkInterceptors);
        }
        arrayList.add(new CallServerInterceptor(this.forWebSocket));
        Request request = this.originalRequest;
        OkHttpClient okHttpClient = this.client;
        try {
            try {
                Response responseProceed = new RealInterceptorChain(this, arrayList, 0, null, request, okHttpClient.connectTimeoutMillis, okHttpClient.readTimeoutMillis, okHttpClient.writeTimeoutMillis).proceed(request);
                if (this.canceled) {
                    Util.closeQuietly(responseProceed);
                    throw new IOException(C0000.decode(new byte[]{122, 82, 13, 83, 80, 95, 92, 87}, "93c053", 0.0f));
                }
                noMoreExchanges$okhttp(null);
                return responseProceed;
            } catch (IOException e) {
                throw noMoreExchanges$okhttp(e);
            }
        } catch (Throwable th) {
            if (0 == 0) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x001d A[Catch: all -> 0x0013, TryCatch #1 {all -> 0x0013, blocks: (B:8:0x000e, B:17:0x001d, B:19:0x0021, B:20:0x0023, B:22:0x0027, B:27:0x0030, B:29:0x0034, B:14:0x0017), top: B:53:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0021 A[Catch: all -> 0x0013, TryCatch #1 {all -> 0x0013, blocks: (B:8:0x000e, B:17:0x001d, B:19:0x0021, B:20:0x0023, B:22:0x0027, B:27:0x0030, B:29:0x0034, B:14:0x0017), top: B:53:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:25:0x002d  */
    public final IOException messageDone$okhttp(Exchange exchange, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (exchange.equals(this.exchange)) {
            synchronized (this) {
                z3 = false;
                if (z) {
                    try {
                        if (this.requestBodyOpen) {
                            if (z) {
                                this.requestBodyOpen = false;
                            }
                            if (z2) {
                                this.responseBodyOpen = false;
                            }
                            z5 = this.requestBodyOpen;
                            if (z5) {
                                z6 = false;
                            } else {
                                z6 = false;
                            }
                            if (!z5) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        } else if (z2 || !this.responseBodyOpen) {
                            z4 = false;
                        } else {
                            if (z) {
                                this.requestBodyOpen = false;
                            }
                            if (z2) {
                                this.responseBodyOpen = false;
                            }
                            z5 = this.requestBodyOpen;
                            if (z5 || this.responseBodyOpen) {
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            if (!z5 && !this.responseBodyOpen && !this.expectMoreExchanges) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z2) {
                    }
                    z4 = false;
                }
            }
            if (z3) {
                this.exchange = null;
                RealConnection realConnection = this.connection;
                if (realConnection != null) {
                    synchronized (realConnection) {
                        realConnection.successCount++;
                    }
                }
            }
            if (z4) {
                return callDone(iOException);
            }
        }
        return iOException;
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
        }
        return z ? callDone(iOException) : iOException;
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = realConnection.calls;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = -1;
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            if (Intrinsics.areEqual(((Reference) obj).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException(C0000.decode(new byte[]{118, 90, 1, 83, 9, 24, 82, 2, 89, 14, 92, 93, 27}, "52d0b84c0b99", true));
        }
        arrayList.remove(i);
        this.connection = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        realConnection.idleAtNs = System.nanoTime();
        RealConnectionPool realConnectionPool = this.connectionPool;
        ConcurrentLinkedQueue concurrentLinkedQueue = realConnectionPool.connections;
        TaskQueue taskQueue = realConnectionPool.cleanupQueue;
        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
        if (!realConnection.noNewExchanges) {
            taskQueue.schedule(realConnectionPool.cleanupTask, 0L);
            return null;
        }
        realConnection.noNewExchanges = true;
        concurrentLinkedQueue.remove(realConnection);
        if (concurrentLinkedQueue.isEmpty()) {
            taskQueue.cancelAll();
        }
        return realConnection.socket;
    }
}
