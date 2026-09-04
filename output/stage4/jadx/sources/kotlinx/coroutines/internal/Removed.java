package kotlinx.coroutines.internal;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Removed {
    public final LockFreeLinkedListNode ref;

    public Removed(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.ref = lockFreeLinkedListNode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{54, 1, 9, 86, 20, 92, 1, 107}, "ddd9b9e01f8f496a", 0.0f));
        sb.append(this.ref);
        sb.append(']');
        return sb.toString();
    }
}
