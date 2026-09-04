package kotlinx.coroutines;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Empty implements Incomplete {
    public final boolean isActive;

    public Empty(boolean z) {
        this.isActive = z;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return this.isActive;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{113, 15, 70, 23, 74, 72}, "4b6c33", false));
        sb.append(this.isActive ? C0000.decode(new byte[]{113, 91, 71, 80, 69, 81}, "08393433a84581f7", 0.0f) : C0000.decode(new byte[]{47, 7, 79}, "ab895f0740070a39", 0.0f));
        sb.append('}');
        return sb.toString();
    }
}
