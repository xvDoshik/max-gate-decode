package androidx.work;

import com.google.android.gms.common.api.internal.zam;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Configuration {
    public final Object clock;
    public int contentUriTriggerWorkersLimit;
    public final Object executor;
    public Object inputMergerFactory;
    public int maxJobSchedulerId;
    public int maxSchedulerLimit;
    public Object runnableScheduler;
    public final Object taskExecutor;
    public Object workerFactory;

    public Configuration() {
        final boolean z = false;
        final boolean z2 = true;
        this.executor = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1
            public final AtomicInteger threadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, (z ? C0000.decode(new byte[]{50, 124, 24, 69, 88, 71, 10, 26}, "e16194a73fa40521", 4) : C0000.decode(new byte[]{81, 93, 1, 67, 88, 11, 84, 75, 75, 70, 88, 16, 91, 30}, "03e17b", 0.0f)) + this.threadCount.incrementAndGet());
            }
        });
        this.taskExecutor = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1
            public final AtomicInteger threadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, (z2 ? C0000.decode(new byte[]{50, 124, 24, 69, 88, 71, 10, 26}, "e16194a73fa40521", 4) : C0000.decode(new byte[]{81, 93, 1, 67, 88, 11, 84, 75, 75, 70, 88, 16, 91, 30}, "03e17b", 0.0f)) + this.threadCount.incrementAndGet());
            }
        });
        this.clock = new SystemClock();
        this.workerFactory = new WorkerFactory$1();
        this.inputMergerFactory = SystemClock.INSTANCE;
        this.runnableScheduler = new ConnectionPool(8);
        this.maxJobSchedulerId = Integer.MAX_VALUE;
        this.maxSchedulerLimit = 20;
        this.contentUriTriggerWorkersLimit = 8;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0290  */
    /* JADX WARN: Code duplicated, block: B:127:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:129:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:130:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:132:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:141:0x031c  */
    /* JADX WARN: Code duplicated, block: B:142:0x032c  */
    /* JADX WARN: Code duplicated, block: B:184:0x032d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x0302 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x03a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x039a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x0394 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x007e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Code duplicated, block: B:37:0x008b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0090  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:58:0x0100  */
    /* JADX WARN: Code duplicated, block: B:72:0x0162  */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object, java.util.List] */
    public RealConnection findHealthyConnection(int i, int i2, int i3, boolean z, boolean z2) throws IOException {
        Route route;
        zam zamVar;
        RouteSelector routeSelector;
        ArrayList arrayList;
        zam zamVar2;
        Address address;
        Proxy proxy;
        String hostName;
        int port;
        List arrayList2;
        List listSingletonList;
        boolean zContains;
        RealConnection realConnection;
        ConnectionPool connectionPool;
        Socket socketReleaseConnectionNoEvents$okhttp;
        while (!((RealCall) this.clock).canceled) {
            RealConnection realConnection2 = ((RealCall) this.clock).connection;
            if (realConnection2 != null) {
                synchronized (realConnection2) {
                    try {
                        if (!realConnection2.noNewExchanges) {
                            HttpUrl httpUrl = realConnection2.route.address.url;
                            HttpUrl httpUrl2 = ((Address) this.taskExecutor).url;
                            socketReleaseConnectionNoEvents$okhttp = !(httpUrl.port == httpUrl2.port && Intrinsics.areEqual(httpUrl.host, httpUrl2.host)) ? ((RealCall) this.clock).releaseConnectionNoEvents$okhttp() : null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (((RealCall) this.clock).connection == null) {
                    if (socketReleaseConnectionNoEvents$okhttp != null) {
                        Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                    }
                    this.maxJobSchedulerId = 0;
                    this.contentUriTriggerWorkersLimit = 0;
                    this.maxSchedulerLimit = 0;
                    if (((RealConnectionPool) this.executor).callAcquirePooledConnection((Address) this.taskExecutor, (RealCall) this.clock, null, false)) {
                        realConnection2 = ((RealCall) this.clock).connection;
                    } else {
                        route = (Route) this.runnableScheduler;
                        try {
                            if (route != null) {
                                this.runnableScheduler = null;
                            } else {
                                zamVar = (zam) this.workerFactory;
                                if (zamVar == null && zamVar.hasNext()) {
                                    zam zamVar3 = (zam) this.workerFactory;
                                    if (!zamVar3.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    ArrayList arrayList3 = (ArrayList) zamVar3.zab;
                                    int i4 = zamVar3.zaa;
                                    zamVar3.zaa = i4 + 1;
                                    route = (Route) arrayList3.get(i4);
                                } else {
                                    routeSelector = (RouteSelector) this.inputMergerFactory;
                                    if (routeSelector == null) {
                                        Address address2 = (Address) this.taskExecutor;
                                        RealCall realCall = (RealCall) this.clock;
                                        routeSelector = new RouteSelector(address2, realCall.client.routeDatabase, realCall);
                                        this.inputMergerFactory = routeSelector;
                                    }
                                    if (routeSelector.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    arrayList = new ArrayList();
                                    while (routeSelector.nextProxyIndex < ((List) routeSelector.proxies).size()) {
                                        address = (Address) routeSelector.address;
                                        if (routeSelector.nextProxyIndex < ((List) routeSelector.proxies).size()) {
                                            throw new SocketException("No route to " + address.url.host + "; exhausted proxy configurations: " + ((List) routeSelector.proxies));
                                        }
                                        List list = (List) routeSelector.proxies;
                                        int i5 = routeSelector.nextProxyIndex;
                                        routeSelector.nextProxyIndex = i5 + 1;
                                        proxy = (Proxy) list.get(i5);
                                        ArrayList arrayList4 = new ArrayList();
                                        routeSelector.inetSocketAddresses = arrayList4;
                                        if (proxy.type() != Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            HttpUrl httpUrl3 = address.url;
                                            hostName = httpUrl3.host;
                                            port = httpUrl3.port;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            InetAddress address3 = inetSocketAddress.getAddress();
                                            hostName = address3 == null ? inetSocketAddress.getHostName() : address3.getHostAddress();
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 <= port || port >= 65536) {
                                            throw new SocketException("No route to " + hostName + ':' + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList4.add(InetSocketAddress.createUnresolved(hostName, port));
                                        } else {
                                            if (((Pattern) Util.VERIFY_AS_IP_ADDRESS.nativePattern).matcher(hostName).matches()) {
                                                listSingletonList = Collections.singletonList(InetAddress.getByName(hostName));
                                            } else {
                                                address.dns.getClass();
                                                try {
                                                    InetAddress[] allByName = InetAddress.getAllByName(hostName);
                                                    int length = allByName.length;
                                                    if (length != 0) {
                                                        arrayList2 = length != 1 ? new ArrayList(new ArrayAsCollection(allByName, false)) : Collections.singletonList(allByName[0]);
                                                    } else {
                                                        arrayList2 = EmptyList.INSTANCE;
                                                    }
                                                    if (arrayList2.isEmpty()) {
                                                        throw new UnknownHostException(address.dns + " returned no addresses for " + hostName);
                                                    }
                                                    listSingletonList = arrayList2;
                                                } catch (NullPointerException e) {
                                                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostName));
                                                    unknownHostException.initCause(e);
                                                    throw unknownHostException;
                                                }
                                            }
                                            Iterator it = listSingletonList.iterator();
                                            while (it.hasNext()) {
                                                arrayList4.add(new InetSocketAddress((InetAddress) it.next(), port));
                                            }
                                        }
                                        Iterator it2 = routeSelector.inetSocketAddresses.iterator();
                                        while (it2.hasNext()) {
                                            Route route2 = new Route((Address) routeSelector.address, proxy, (InetSocketAddress) it2.next());
                                            ConnectionPool connectionPool2 = (ConnectionPool) routeSelector.routeDatabase;
                                            synchronized (connectionPool2) {
                                                zContains = ((LinkedHashSet) connectionPool2.delegate).contains(route2);
                                            }
                                            if (zContains) {
                                                ((ArrayList) routeSelector.postponedRoutes).add(route2);
                                            } else {
                                                arrayList.add(route2);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        CollectionsKt__MutableCollectionsKt.addAll(arrayList, (ArrayList) routeSelector.postponedRoutes);
                                        ((ArrayList) routeSelector.postponedRoutes).clear();
                                    }
                                    zamVar2 = new zam(arrayList);
                                    this.workerFactory = zamVar2;
                                    if (!((RealCall) this.clock).canceled) {
                                        throw new IOException("Canceled");
                                    }
                                    if (((RealConnectionPool) this.executor).callAcquirePooledConnection((Address) this.taskExecutor, (RealCall) this.clock, arrayList, false)) {
                                        realConnection2 = ((RealCall) this.clock).connection;
                                    } else {
                                        if (zamVar2.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        int i6 = zamVar2.zaa;
                                        zamVar2.zaa = i6 + 1;
                                        route = (Route) arrayList.get(i6);
                                        realConnection = new RealConnection(route);
                                        ((RealCall) this.clock).connectionToCancel = realConnection;
                                        realConnection.connect(i, i2, i3, z, (RealCall) this.clock);
                                        ((RealCall) this.clock).connectionToCancel = null;
                                        connectionPool = ((RealCall) this.clock).client.routeDatabase;
                                        synchronized (connectionPool) {
                                            ((LinkedHashSet) connectionPool.delegate).remove(route);
                                        }
                                        if (((RealConnectionPool) this.executor).callAcquirePooledConnection((Address) this.taskExecutor, (RealCall) this.clock, arrayList, true)) {
                                            RealConnection realConnection3 = ((RealCall) this.clock).connection;
                                            this.runnableScheduler = route;
                                            Util.closeQuietly(realConnection.socket);
                                            realConnection2 = realConnection3;
                                        } else {
                                            synchronized (realConnection) {
                                                RealConnectionPool realConnectionPool = (RealConnectionPool) this.executor;
                                                realConnectionPool.getClass();
                                                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                                                realConnectionPool.connections.add(realConnection);
                                                realConnectionPool.cleanupQueue.schedule(realConnectionPool.cleanupTask, 0L);
                                                ((RealCall) this.clock).acquireConnectionNoEvents(realConnection);
                                            }
                                            realConnection2 = realConnection;
                                        }
                                    }
                                }
                            }
                            realConnection.connect(i, i2, i3, z, (RealCall) this.clock);
                            ((RealCall) this.clock).connectionToCancel = null;
                            connectionPool = ((RealCall) this.clock).client.routeDatabase;
                            synchronized (connectionPool) {
                                ((LinkedHashSet) connectionPool.delegate).remove(route);
                                if (((RealConnectionPool) this.executor).callAcquirePooledConnection((Address) this.taskExecutor, (RealCall) this.clock, arrayList, true)) {
                                    RealConnection realConnection4 = ((RealCall) this.clock).connection;
                                    this.runnableScheduler = route;
                                    Util.closeQuietly(realConnection.socket);
                                    realConnection2 = realConnection4;
                                } else {
                                    synchronized (realConnection) {
                                        RealConnectionPool realConnectionPool2 = (RealConnectionPool) this.executor;
                                        realConnectionPool2.getClass();
                                        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                                        realConnectionPool2.connections.add(realConnection);
                                        realConnectionPool2.cleanupQueue.schedule(realConnectionPool2.cleanupTask, 0L);
                                        ((RealCall) this.clock).acquireConnectionNoEvents(realConnection);
                                        realConnection2 = realConnection;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            ((RealCall) this.clock).connectionToCancel = null;
                            throw th2;
                        }
                        arrayList = null;
                        realConnection = new RealConnection(route);
                        ((RealCall) this.clock).connectionToCancel = realConnection;
                    }
                } else if (socketReleaseConnectionNoEvents$okhttp != null) {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                this.maxJobSchedulerId = 0;
                this.contentUriTriggerWorkersLimit = 0;
                this.maxSchedulerLimit = 0;
                if (((RealConnectionPool) this.executor).callAcquirePooledConnection((Address) this.taskExecutor, (RealCall) this.clock, null, false)) {
                    realConnection2 = ((RealCall) this.clock).connection;
                } else {
                    route = (Route) this.runnableScheduler;
                    if (route != null) {
                        this.runnableScheduler = null;
                    } else {
                        zamVar = (zam) this.workerFactory;
                        if (zamVar == null) {
                        }
                        routeSelector = (RouteSelector) this.inputMergerFactory;
                        if (routeSelector == null) {
                            Address address4 = (Address) this.taskExecutor;
                            RealCall realCall2 = (RealCall) this.clock;
                            routeSelector = new RouteSelector(address4, realCall2.client.routeDatabase, realCall2);
                            this.inputMergerFactory = routeSelector;
                        }
                        if (routeSelector.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        arrayList = new ArrayList();
                        while (routeSelector.nextProxyIndex < ((List) routeSelector.proxies).size()) {
                            address = (Address) routeSelector.address;
                            if (routeSelector.nextProxyIndex < ((List) routeSelector.proxies).size()) {
                                throw new SocketException("No route to " + address.url.host + "; exhausted proxy configurations: " + ((List) routeSelector.proxies));
                            }
                            List list2 = (List) routeSelector.proxies;
                            int i7 = routeSelector.nextProxyIndex;
                            routeSelector.nextProxyIndex = i7 + 1;
                            proxy = (Proxy) list2.get(i7);
                            ArrayList arrayList5 = new ArrayList();
                            routeSelector.inetSocketAddresses = arrayList5;
                            if (proxy.type() != Proxy.Type.DIRECT) {
                                HttpUrl httpUrl4 = address.url;
                                hostName = httpUrl4.host;
                                port = httpUrl4.port;
                            } else {
                                HttpUrl httpUrl5 = address.url;
                                hostName = httpUrl5.host;
                                port = httpUrl5.port;
                            }
                            if (1 <= port) {
                            }
                            throw new SocketException("No route to " + hostName + ':' + port + "; port is out of range");
                        }
                        if (arrayList.isEmpty()) {
                            CollectionsKt__MutableCollectionsKt.addAll(arrayList, (ArrayList) routeSelector.postponedRoutes);
                            ((ArrayList) routeSelector.postponedRoutes).clear();
                        }
                        zamVar2 = new zam(arrayList);
                        this.workerFactory = zamVar2;
                        if (!((RealCall) this.clock).canceled) {
                            throw new IOException("Canceled");
                        }
                        if (((RealConnectionPool) this.executor).callAcquirePooledConnection((Address) this.taskExecutor, (RealCall) this.clock, arrayList, false)) {
                            realConnection2 = ((RealCall) this.clock).connection;
                        } else {
                            if (zamVar2.hasNext()) {
                                throw new NoSuchElementException();
                            }
                            int i8 = zamVar2.zaa;
                            zamVar2.zaa = i8 + 1;
                            route = (Route) arrayList.get(i8);
                            realConnection = new RealConnection(route);
                            ((RealCall) this.clock).connectionToCancel = realConnection;
                            realConnection.connect(i, i2, i3, z, (RealCall) this.clock);
                            ((RealCall) this.clock).connectionToCancel = null;
                            connectionPool = ((RealCall) this.clock).client.routeDatabase;
                            synchronized (connectionPool) {
                                ((LinkedHashSet) connectionPool.delegate).remove(route);
                                if (((RealConnectionPool) this.executor).callAcquirePooledConnection((Address) this.taskExecutor, (RealCall) this.clock, arrayList, true)) {
                                    RealConnection realConnection5 = ((RealCall) this.clock).connection;
                                    this.runnableScheduler = route;
                                    Util.closeQuietly(realConnection.socket);
                                    realConnection2 = realConnection5;
                                } else {
                                    synchronized (realConnection) {
                                        RealConnectionPool realConnectionPool3 = (RealConnectionPool) this.executor;
                                        realConnectionPool3.getClass();
                                        byte[] bArr3 = Util.EMPTY_BYTE_ARRAY;
                                        realConnectionPool3.connections.add(realConnection);
                                        realConnectionPool3.cleanupQueue.schedule(realConnectionPool3.cleanupTask, 0L);
                                        ((RealCall) this.clock).acquireConnectionNoEvents(realConnection);
                                        realConnection2 = realConnection;
                                    }
                                }
                            }
                        }
                    }
                    arrayList = null;
                    realConnection = new RealConnection(route);
                    ((RealCall) this.clock).connectionToCancel = realConnection;
                    realConnection.connect(i, i2, i3, z, (RealCall) this.clock);
                    ((RealCall) this.clock).connectionToCancel = null;
                    connectionPool = ((RealCall) this.clock).client.routeDatabase;
                    synchronized (connectionPool) {
                        ((LinkedHashSet) connectionPool.delegate).remove(route);
                        if (((RealConnectionPool) this.executor).callAcquirePooledConnection((Address) this.taskExecutor, (RealCall) this.clock, arrayList, true)) {
                            RealConnection realConnection6 = ((RealCall) this.clock).connection;
                            this.runnableScheduler = route;
                            Util.closeQuietly(realConnection.socket);
                            realConnection2 = realConnection6;
                        } else {
                            synchronized (realConnection) {
                                RealConnectionPool realConnectionPool4 = (RealConnectionPool) this.executor;
                                realConnectionPool4.getClass();
                                byte[] bArr4 = Util.EMPTY_BYTE_ARRAY;
                                realConnectionPool4.connections.add(realConnection);
                                realConnectionPool4.cleanupQueue.schedule(realConnectionPool4.cleanupTask, 0L);
                                ((RealCall) this.clock).acquireConnectionNoEvents(realConnection);
                                realConnection2 = realConnection;
                            }
                        }
                    }
                }
            }
            if (realConnection2.isHealthy(z2)) {
                return realConnection2;
            }
            realConnection2.noNewExchanges$okhttp();
            if (((Route) this.runnableScheduler) == null) {
                zam zamVar4 = (zam) this.workerFactory;
                if (zamVar4 != null ? zamVar4.hasNext() : true) {
                    continue;
                } else {
                    RouteSelector routeSelector2 = (RouteSelector) this.inputMergerFactory;
                    if (!(routeSelector2 != null ? routeSelector2.hasNext() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public void trackFailure(IOException iOException) {
        this.runnableScheduler = null;
        if ((iOException instanceof StreamResetException) && ((StreamResetException) iOException).errorCode == 8) {
            this.maxJobSchedulerId++;
        } else if (iOException instanceof ConnectionShutdownException) {
            this.contentUriTriggerWorkersLimit++;
        } else {
            this.maxSchedulerLimit++;
        }
    }

    public Configuration(RealConnectionPool realConnectionPool, Address address, RealCall realCall) {
        this.executor = realConnectionPool;
        this.taskExecutor = address;
        this.clock = realCall;
    }
}
