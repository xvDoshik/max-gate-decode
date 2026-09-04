package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ListenableWorker {
    public final Context mAppContext;
    public volatile int mStopReason = -256;
    public boolean mUsed;
    public final WorkerParameters mWorkerParams;

    public abstract class Result {

        public final class Failure extends Result {
            public final Data mOutputData = Data.EMPTY;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Failure) obj).mOutputData);
            }

            public final int hashCode() {
                return this.mOutputData.hashCode() + 846803280;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{34, 3, 13, 84, 77, 66, 92, 16, 72, 11, 127, 76, 69, 71, 17, 22, 32, 89, 76, 81, 4}, "dbd880903f0917", 0.0f));
                sb.append(this.mOutputData);
                sb.append('}');
                return sb.toString();
            }
        }

        public final class Retry extends Result {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public final int hashCode() {
                return 25945934;
            }

            public final String toString() {
                return C0000.decode(new byte[]{52, 0, 76, 67, 64}, "fe81959850f9", 0.0f);
            }
        }

        public final class Success extends Result {
            public final Data mOutputData;

            public Success(Data data) {
                this.mOutputData = data;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.mOutputData.equals(((Success) obj).mOutputData);
            }

            public final int hashCode() {
                return this.mOutputData.hashCode() - 1876823561;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{97, 76, 90, 6, 93, 66, 23, 22, 24, 15, 126, 71, 17, 69, 16, 71, 118, 88, 77, 4, 5}, "299e81d6cb12e5e3", 0));
                sb.append(this.mOutputData);
                sb.append('}');
                return sb.toString();
            }
        }
    }

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{39, 20, 66, 91, 89, 87, 83, 77, 89, 10, 86, 21, 37, 11, 92, 67, 85, 76, 70, 25, 89, 22, 24, 91, 19, 8, 94}, "fd2704290e85", 4));
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{110, 90, 65, 13, 7, 19, 54, 2, 66, 84, 88, 92, 65, 87, 74, 68, 25, 92, 64, 70, 12, 20, 10, 15}, "953fbafc05595287", 5));
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    public ListenableFuture getForegroundInfoAsync() {
        SettableFuture settableFuture = new SettableFuture();
        settableFuture.setException(new IllegalStateException(C0000.decode(new byte[]{35, 78, 68, 84, 82, 89, 71, 86, 2, 22, 99, 94, 68, 91, 97, 86, 23, 67, 81, 66, 66, 67, 19, 65, 3, 71, 65, 88, 68, 85, 19, 82, 70, 122, 93, 66, 66, 85, 93, 82, 4, 90, 81, 102, 89, 66, 88, 86, 20, 22, 64, 94, 22, 64, 65, 92, 16, 95, 80, 84, 22, 81, 93, 19, 15, 91, 68, 93, 83, 93, 86, 93, 18, 87, 64, 88, 89, 94, 19, 85, 9, 68, 20, 81, 81, 85, 71, 117, 9, 68, 81, 86, 68, 95, 70, 93, 2, 127, 90, 87, 89, 113, 64, 74, 8, 85, 28, 24, 86}, "f6416033", 2)));
        return settableFuture;
    }

    public void onStopped() {
    }

    public abstract SettableFuture startWork();

    public final void stop(int i) {
        this.mStopReason = i;
        onStopped();
    }
}
