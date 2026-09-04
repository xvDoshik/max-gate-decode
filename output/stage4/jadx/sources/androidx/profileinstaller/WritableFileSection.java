package androidx.profileinstaller;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WritableFileSection {
    public final byte[] mContents;
    public final boolean mNeedsCompression;
    public final int mType;

    public WritableFileSection(int i, byte[] bArr, boolean z) {
        this.mType = i;
        this.mContents = bArr;
        this.mNeedsCompression = z;
    }
}
