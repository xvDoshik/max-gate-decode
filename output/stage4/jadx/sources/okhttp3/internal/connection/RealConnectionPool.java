package okhttp3.internal.connection;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RealConnectionPool {
    public final TaskQueue cleanupQueue;
    public final long keepAliveDurationNs = TimeUnit.MINUTES.toNanos(5);
    public final TaskQueue$execute$1 cleanupTask = new TaskQueue$execute$1(this, FileSectionType$EnumUnboxingLocalUtility.m(new StringBuilder(), Util.okHttpName, C0000.decode(new byte[]{65, 112, 92, 91, 10, 93, 2, 71, 90, 90, 10, 104, 14, 92, 95}, "a335d8", 0)));
    public final ConcurrentLinkedQueue connections = new ConcurrentLinkedQueue();

    public RealConnectionPool(TaskRunner taskRunner) {
        this.cleanupQueue = taskRunner.newQueue();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x002c A[SYNTHETIC] */
    public final boolean callAcquirePooledConnection(Address address, RealCall realCall, ArrayList arrayList, boolean z) {
        Iterator it = this.connections.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            RealConnection realConnection = (RealConnection) it.next();
            synchronized (realConnection) {
                if (z) {
                    try {
                        if (!(realConnection.http2Connection != null)) {
                            continue;
                        } else if (realConnection.isEligible$okhttp(address, arrayList)) {
                            realCall.acquireConnectionNoEvents(realConnection);
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else if (realConnection.isEligible$okhttp(address, arrayList)) {
                    realCall.acquireConnectionNoEvents(realConnection);
                    return true;
                }
            }
        }
    }

    public final int pruneAndGetAllocationCount(RealConnection realConnection, long j) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = realConnection.calls;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = C0000.decode(new byte[]{112, 68, 6, 13, 13, 11, 85, 85, 70, 81, 94, 10, 69, 22, 12, 69}, "1debce0628", 1) + realConnection.route.address.url + C0000.decode(new byte[]{68, 69, 88, 64, 68, 84, 87, 86, 10, 80, 0, 28, 25, 119, 13, 92, 18, 78, 14, 64, 68, 84, 86, 65, 3, 93, 70, 23, 21, 90, 68, 81, 85, 92, 23, 93, 18, 86, 65, 71, 1, 65, 73, 92, 10, 75, 87, 23, 3, 90, 0, 75, 6}, "d293d827a5");
                Platform platform = Platform.platform;
                Platform.platform.logCloseableLeak(((RealCall.CallReference) reference).callStackTrace, str);
                arrayList.remove(i);
                realConnection.noNewExchanges = true;
                if (arrayList.isEmpty()) {
                    realConnection.idleAtNs = j - this.keepAliveDurationNs;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
