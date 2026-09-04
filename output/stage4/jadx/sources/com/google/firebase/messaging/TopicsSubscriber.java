package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.zzw;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.ExceptionsKt;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TopicsSubscriber {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    public final Context context;
    public final FirebaseMessaging firebaseMessaging;
    public final Metadata metadata;
    public final Request rpc;
    public final TopicsStore store;
    public final ScheduledThreadPoolExecutor syncExecutor;
    public final ArrayMap pendingOperations = new ArrayMap();
    public boolean syncScheduledOrRunning = false;

    public TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, Request request, Context context, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.firebaseMessaging = firebaseMessaging;
        this.metadata = metadata;
        this.store = topicsStore;
        this.rpc = request;
        this.context = context;
        this.syncExecutor = scheduledThreadPoolExecutor;
    }

    public static void awaitTask(zzw zzwVar) throws IOException {
        try {
            ExceptionsKt.await(zzwVar, 30L, TimeUnit.SECONDS);
        } catch (InterruptedException | TimeoutException e) {
            throw new IOException(C0000.decode(new byte[]{49, 117, 97, 55, 126, 39, 125, 108, 120, 43, 99, 102, 35, 102, 114, 40, 123, 37, 122, 127, 115}, "b03a7d836d79", 0.0f), e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (!(cause instanceof RuntimeException)) {
                throw new IOException(e2);
            }
            throw ((RuntimeException) cause);
        }
    }

    public final void blockingSubscribeToTopic(String str) throws IOException {
        String strBlockingGetToken = this.firebaseMessaging.blockingGetToken();
        Bundle bundle = new Bundle();
        String strDecode = C0000.decode(new byte[]{28, 65, 95, 69, 91, 90, 17, 77}, "350529bb56790eb2");
        bundle.putString(C0000.decode(new byte[]{4, 80, 11, 74, 22, 89, 19, 90, 5}, "c3fdb6", 0.0f), strDecode + str);
        StringBuilder sb = new StringBuilder(strDecode);
        sb.append(str);
        String string = sb.toString();
        Request request = this.rpc;
        awaitTask(request.extractResponseWhenComplete(request.startRpc(strBlockingGetToken, string, bundle)));
    }

    public final void blockingUnsubscribeFromTopic(String str) throws IOException {
        String strBlockingGetToken = this.firebaseMessaging.blockingGetToken();
        Bundle bundle = new Bundle();
        String strDecode = C0000.decode(new byte[]{75, 71, 86, 19, 95, 91, 70, 74}, "d39c685e94", 3);
        bundle.putString(C0000.decode(new byte[]{84, 90, 88, 74, 18, 91, 65, 13, 1}, "395df41db6473d80", false), strDecode + str);
        bundle.putString(C0000.decode(new byte[]{82, 0, 94, 87, 76, 4}, "6e228aabf6ee1fdd", 0.0f), C0000.decode(new byte[]{4}, "5ad1b4b362ed4c", 1));
        String str2 = strDecode + str;
        Request request = this.rpc;
        awaitTask(request.extractResponseWhenComplete(request.startRpc(strBlockingGetToken, str2, bundle)));
    }

    public final synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00b3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean syncTopics() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    public final void syncWithDelaySecondsInternal(long j) {
        TopicsSyncTask topicsSyncTask = new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30L, 2 * j), MAX_DELAY_SEC));
        this.syncExecutor.schedule(topicsSyncTask, j, TimeUnit.SECONDS);
        setSyncScheduledOrRunning(true);
    }
}
