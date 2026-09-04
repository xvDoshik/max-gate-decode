package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DefaultUserAgentPublisher {
    public final ConnectionPool gamesSDKRegistrar;
    public final String javaSDKVersionUserAgent;

    public DefaultUserAgentPublisher(Set set, ConnectionPool connectionPool) {
        this.javaSDKVersionUserAgent = toUserAgent(set);
        this.gamesSDKRegistrar = connectionPool;
    }

    public static String toUserAgent(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AutoValue_LibraryVersion autoValue_LibraryVersion = (AutoValue_LibraryVersion) it.next();
            sb.append(autoValue_LibraryVersion.libraryName);
            sb.append('/');
            sb.append(autoValue_LibraryVersion.version);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public final String getUserAgent() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        String str = this.javaSDKVersionUserAgent;
        ConnectionPool connectionPool = this.gamesSDKRegistrar;
        synchronized (((HashSet) connectionPool.delegate)) {
            setUnmodifiableSet = Collections.unmodifiableSet((HashSet) connectionPool.delegate);
        }
        if (setUnmodifiableSet.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        synchronized (((HashSet) connectionPool.delegate)) {
            setUnmodifiableSet2 = Collections.unmodifiableSet((HashSet) connectionPool.delegate);
        }
        sb.append(toUserAgent(setUnmodifiableSet2));
        return sb.toString();
    }
}
