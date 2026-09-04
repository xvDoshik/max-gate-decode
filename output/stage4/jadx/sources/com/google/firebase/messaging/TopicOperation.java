package com.google.firebase.messaging;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.util.Arrays;
import java.util.regex.Pattern;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TopicOperation {
    public static final Pattern TOPIC_NAME_REGEXP = Pattern.compile(C0000.decode(new byte[]{110, 5, 31, 74, 121, 25, 60, 85, 30, 15, 25, 58, 30, 27, 16, 57, 73, 1, 20, 13, 86, 85, 78}, "5d2084fe364e0e", 3));
    public final String operation;
    public final String serializedString;
    public final String topic;

    public TopicOperation(String str, String str2) {
        String strSubstring = (str2 == null || !str2.startsWith(C0000.decode(new byte[]{29, 17, 87, 73, 10, 87, 68, 78}, "2e89c47a5abe7e"))) ? str2 : str2.substring(8);
        if (strSubstring == null || !TOPIC_NAME_REGEXP.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{122, 95, 79, 80, 10, 11, 87, 67, 76, 12, 70, 94, 80, 17, 87, 80, 11, 7, 9, 67}, "3191fb3c8c67", 0.0f), strSubstring, C0000.decode(new byte[]{70, 1, 92, 3, 75, 18, 15, 86, 21, 18, 11, 83, 18, 6, 91, 70, 76, 90, 4, 25, 0, 94, 10, 93, 17, 0, 87, 70, 94, 93, 19, 84, 0, 70, 70, 105, 7, 72, 73, 39, 21, 104, 81, 20, 88, 31, 57, 28, 24, 64, 110, 29, 9, 30, 88, 9, 81, 79, 72}, "fe3f82a9a2f2", 7)));
        }
        this.topic = strSubstring;
        this.operation = str;
        this.serializedString = str + C0000.decode(new byte[]{23}, "6b6f78", 5) + str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TopicOperation)) {
            return false;
        }
        TopicOperation topicOperation = (TopicOperation) obj;
        return this.topic.equals(topicOperation.topic) && this.operation.equals(topicOperation.operation);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.operation, this.topic});
    }
}
