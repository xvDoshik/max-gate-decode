package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.ResolvableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ProfileVerifier {
    public static final ResolvableFuture sFuture = new ResolvableFuture();
    public static final Object SYNC_OBJ = new Object();
    public static ByteString.Companion sCompilationStatus = null;

    public abstract class Api33Impl {
        public static PackageInfo getPackageInfo(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    public final class Cache {
        public final long mInstalledCurrentProfileSize;
        public final long mPackageLastUpdateTime;
        public final int mResultCode;
        public final int mSchema;

        public Cache(int i, int i2, long j, long j2) {
            this.mSchema = i;
            this.mResultCode = i2;
            this.mPackageLastUpdateTime = j;
            this.mInstalledCurrentProfileSize = j2;
        }

        public static Cache readFromFile(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Cache)) {
                Cache cache = (Cache) obj;
                if (this.mResultCode == cache.mResultCode && this.mPackageLastUpdateTime == cache.mPackageLastUpdateTime && this.mSchema == cache.mSchema && this.mInstalledCurrentProfileSize == cache.mInstalledCurrentProfileSize) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize));
        }

        public final void writeOnFile(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.mSchema);
                dataOutputStream.writeInt(this.mResultCode);
                dataOutputStream.writeLong(this.mPackageLastUpdateTime);
                dataOutputStream.writeLong(this.mInstalledCurrentProfileSize);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static long getPackageLastUpdateTime(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.getPackageInfo(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static ByteString.Companion setCompilationStatus() {
        ByteString.Companion companion = new ByteString.Companion();
        sCompilationStatus = companion;
        ResolvableFuture resolvableFuture = sFuture;
        resolvableFuture.getClass();
        if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(resolvableFuture, null, companion)) {
            AbstractResolvableFuture.complete(resolvableFuture);
        }
        return sCompilationStatus;
    }

    public static void writeProfileVerification(Context context, boolean z) {
        Cache fromFile;
        int i;
        if (z || sCompilationStatus == null) {
            synchronized (SYNC_OBJ) {
                if (!z) {
                    try {
                        if (sCompilationStatus != null) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 28 && i2 != 30) {
                    File file = new File(new File(C0000.decode(new byte[]{26, 6, 85, 76, 84, 29, 11, 8, 68, 80, 22, 65, 71, 13, 82, 81, 89, 87, 21, 78, 69, 86, 95, 30}, "5b4852fa7391"), context.getPackageName()), C0000.decode(new byte[]{72, 23, 90, 95, 83, 64, 29, 27, 17, 17, 94, 85}, "8e3222d5ac133d", 0.0f));
                    long length = file.length();
                    int i3 = 0;
                    boolean z2 = file.exists() && length > 0;
                    File file2 = new File(new File(C0000.decode(new byte[]{26, 87, 89, 21, 88, 24, 88, 90, 75, 2, 22, 71, 71, 92, 94, 8, 85, 82, 70, 28, 91, 20, 75, 24, 5, 28}, "538a97", 0.0f), context.getPackageName()), C0000.decode(new byte[]{19, 68, 12, 15, 2, 19, 26, 28, 70, 67, 86, 80}, "c6ebcac26196", true));
                    long length2 = file2.length();
                    boolean z3 = file2.exists() && length2 > 0;
                    try {
                        long packageLastUpdateTime = getPackageLastUpdateTime(context);
                        File file3 = new File(context.getFilesDir(), C0000.decode(new byte[]{20, 19, 12, 0, 12, 91, 81, 47, 10, 18, 23, 7, 9, 91, 81, 2}, "dacfe74f", 0.0f));
                        if (file3.exists()) {
                            try {
                                fromFile = Cache.readFromFile(file3);
                            } catch (IOException unused) {
                                setCompilationStatus();
                                return;
                            }
                        } else {
                            fromFile = null;
                        }
                        if (fromFile != null && fromFile.mPackageLastUpdateTime == packageLastUpdateTime && (i = fromFile.mResultCode) != 2) {
                            i3 = i;
                        } else if (z2) {
                            i3 = 1;
                        } else if (z3) {
                            i3 = 2;
                        }
                        if (z && z3 && i3 != 1) {
                            i3 = 2;
                        }
                        if (fromFile != null && fromFile.mResultCode == 2 && i3 == 1 && length < fromFile.mInstalledCurrentProfileSize) {
                            i3 = 3;
                        }
                        Cache cache = new Cache(1, i3, packageLastUpdateTime, length2);
                        if (fromFile == null || !fromFile.equals(cache)) {
                            try {
                                cache.writeOnFile(file3);
                            } catch (IOException unused2) {
                            }
                        }
                        setCompilationStatus();
                        return;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        setCompilationStatus();
                        return;
                    }
                }
                setCompilationStatus();
            }
        }
    }
}
