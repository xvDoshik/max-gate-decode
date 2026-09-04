package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import androidx.work.impl.AutoMigration_14_15;
import com.base.template.network.SmsFastSend$$ExternalSyntheticLambda1;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ProfileInstallerInitializer implements Initializer {

    public abstract class Choreographer16Impl {
        public static void postFrameCallback(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    runnable.run();
                }
            });
        }
    }

    public abstract class Handler28Impl {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @Override // androidx.startup.Initializer
    public final Object create(Context context) {
        Choreographer16Impl.postFrameCallback(new SmsFastSend$$ExternalSyntheticLambda1(this, context.getApplicationContext()));
        return new AutoMigration_14_15();
    }

    @Override // androidx.startup.Initializer
    public final void dependencies() {
        List list = Collections.EMPTY_LIST;
    }
}
