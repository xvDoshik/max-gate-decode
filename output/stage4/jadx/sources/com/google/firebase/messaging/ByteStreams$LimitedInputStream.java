package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ByteStreams$LimitedInputStream extends FilterInputStream {
    public long left;
    public long mark;

    public ByteStreams$LimitedInputStream(InputStream inputStream) {
        super(inputStream);
        this.mark = -1L;
        this.left = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.left);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.mark = this.left;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.left == 0) {
            return -1;
        }
        int i = ((FilterInputStream) this).in.read();
        if (i != -1) {
            this.left--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException(C0000.decode(new byte[]{117, 84, 64, 90, 22, 94, 9, 77, 22, 64, 16, 72, 72, 90, 64, 69, 83, 84}, "852160f963e8", true));
        }
        if (this.mark == -1) {
            throw new IOException(C0000.decode(new byte[]{122, 7, 22, 15, 25, 91, 88, 65, 21, 70, 87, 65}, "7fdd95755525", true));
        }
        ((FilterInputStream) this).in.reset();
        this.left = this.mark;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j, this.left));
        this.left -= jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.left;
        if (j == 0) {
            return -1;
        }
        int i3 = ((FilterInputStream) this).in.read(bArr, i, (int) Math.min(i2, j));
        if (i3 != -1) {
            this.left -= (long) i3;
        }
        return i3;
    }
}
