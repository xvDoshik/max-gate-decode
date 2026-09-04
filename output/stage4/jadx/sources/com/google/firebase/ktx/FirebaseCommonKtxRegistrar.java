package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component> getComponents() {
        Component.Builder builder = Component.builder(new Qualified(Background.class, CoroutineDispatcher.class));
        builder.add(new Dependency(new Qualified(Background.class, Executor.class), 1, 0));
        builder.factory = FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.INSTANCE;
        Component componentBuild = builder.build();
        Component.Builder builder2 = Component.builder(new Qualified(Lightweight.class, CoroutineDispatcher.class));
        builder2.add(new Dependency(new Qualified(Lightweight.class, Executor.class), 1, 0));
        builder2.factory = FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.INSTANCE$1;
        Component componentBuild2 = builder2.build();
        Component.Builder builder3 = Component.builder(new Qualified(Blocking.class, CoroutineDispatcher.class));
        builder3.add(new Dependency(new Qualified(Blocking.class, Executor.class), 1, 0));
        builder3.factory = FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.INSTANCE$2;
        Component componentBuild3 = builder3.build();
        Component.Builder builder4 = Component.builder(new Qualified(UiThread.class, CoroutineDispatcher.class));
        builder4.add(new Dependency(new Qualified(UiThread.class, Executor.class), 1, 0));
        builder4.factory = FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1.INSTANCE$3;
        return CollectionsKt__CollectionsKt.listOf(componentBuild, componentBuild2, componentBuild3, builder4.build());
    }
}
