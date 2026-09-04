package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/io/ExposingBufferByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "size", "", "<init>", "(I)V", "buffer", "", "getBuffer", "()[B", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ExposingBufferByteArrayOutputStream extends ByteArrayOutputStream {
    public final byte[] getBuffer() {
        byte[] bArr = this.buf;
        Intrinsics.checkNotNullExpressionValue(bArr, C0000.decode(new byte[]{90, 20, 86}, "8a0b99", 6));
        return bArr;
    }

    public ExposingBufferByteArrayOutputStream(int i) {
        super(i);
    }
}
