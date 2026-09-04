package com.google.firebase.ktx;

import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import java.util.concurrent.Executor;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import okhttp3.Request;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1 implements ComponentFactory {
    public static final FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1 INSTANCE = new FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1(0);
    public static final FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1 INSTANCE$1 = new FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1(1);
    public static final FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1 INSTANCE$2 = new FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1(2);
    public static final FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1 INSTANCE$3 = new FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1(3);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(Request.Builder builder) {
        switch (this.$r8$classId) {
            case 0:
                return new ExecutorCoroutineDispatcherImpl((Executor) builder.get(new Qualified(Background.class, Executor.class)));
            case 1:
                return new ExecutorCoroutineDispatcherImpl((Executor) builder.get(new Qualified(Lightweight.class, Executor.class)));
            case 2:
                return new ExecutorCoroutineDispatcherImpl((Executor) builder.get(new Qualified(Blocking.class, Executor.class)));
            default:
                return new ExecutorCoroutineDispatcherImpl((Executor) builder.get(new Qualified(UiThread.class, Executor.class)));
        }
    }
}
