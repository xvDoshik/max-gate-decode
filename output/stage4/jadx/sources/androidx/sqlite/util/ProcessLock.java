package androidx.sqlite.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ProcessLock {
    public static final HashMap threadLocksMap = new HashMap();
    public FileChannel lockChannel;
    public final File lockFile;
    public final boolean processLock;
    public final Lock threadLock;

    public ProcessLock(String str, File file, boolean z) {
        Lock lock;
        this.processLock = z;
        File file2 = new File(file, str.concat(C0000.decode(new byte[]{27, 84, 0, 8}, "58cc1ce647e9cd", false)));
        this.lockFile = file2;
        String absolutePath = file2.getAbsolutePath();
        HashMap map = threadLocksMap;
        synchronized (map) {
            try {
                Object reentrantLock = map.get(absolutePath);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(absolutePath, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.threadLock = lock;
    }

    public final void lock(boolean z) {
        File file = this.lockFile;
        this.threadLock.lock();
        if (z) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.lockChannel = channel;
            } catch (IOException unused) {
                this.lockChannel = null;
            }
        }
    }

    public final void unlock() {
        try {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.threadLock.unlock();
    }
}
