package com.google.firebase.heartbeatinfo;

import android.content.Context;
import androidx.core.os.UserManagerCompat$Api24Impl;
import androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda0;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp$$ExternalSyntheticLambda0;
import com.google.firebase.inject.Provider;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {
    public final Context applicationContext;
    public final Executor backgroundExecutor;
    public final Set consumers;
    public final FirebaseApp$$ExternalSyntheticLambda0 storageProvider;
    public final Provider userAgentProvider;

    public DefaultHeartBeatController(Context context, String str, Set set, Provider provider, Executor executor) {
        this.storageProvider = new FirebaseApp$$ExternalSyntheticLambda0(context, str);
        this.consumers = set;
        this.backgroundExecutor = executor;
        this.userAgentProvider = provider;
        this.applicationContext = context;
    }

    public final zzw getHeartBeatsHeader() {
        if (!UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext)) {
            return ExceptionsKt.forResult("");
        }
        return ExceptionsKt.call(this.backgroundExecutor, new IdGenerator$$ExternalSyntheticLambda0(1, this));
    }

    public final void registerHeartBeat() {
        if (this.consumers.size() <= 0) {
            ExceptionsKt.forResult(null);
        } else if (!UserManagerCompat$Api24Impl.isUserUnlocked(this.applicationContext)) {
            ExceptionsKt.forResult(null);
        } else {
            ExceptionsKt.call(this.backgroundExecutor, new IdGenerator$$ExternalSyntheticLambda0(2, this));
        }
    }
}
