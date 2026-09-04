package com.google.firebase.messaging;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.regex.Pattern;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TopicsStore {
    public static WeakReference topicsStoreWeakReference;
    public Request.Builder topicOperationsQueue;

    public final synchronized TopicOperation getNextTopicOperation() {
        String str;
        TopicOperation topicOperation;
        Request.Builder builder = this.topicOperationsQueue;
        synchronized (((ArrayDeque) builder.body)) {
            str = (String) ((ArrayDeque) builder.body).peek();
        }
        Pattern pattern = TopicOperation.TOPIC_NAME_REGEXP;
        topicOperation = null;
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split(C0000.decode(new byte[]{23}, "6ac7dae3", 0.0f), -1);
            if (strArrSplit.length == 2) {
                topicOperation = new TopicOperation(strArrSplit[0], strArrSplit[1]);
            }
        }
        return topicOperation;
    }
}
