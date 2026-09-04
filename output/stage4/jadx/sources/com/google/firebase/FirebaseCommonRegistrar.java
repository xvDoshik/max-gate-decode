package com.google.firebase;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.tracing.Trace;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.AutoValue_LibraryVersion;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.KotlinVersion;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static String safeValue(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(Qualified.unqualified(DefaultUserAgentPublisher.class));
        for (Class cls : new Class[0]) {
            Trace.checkNotNull(cls, "Null interface");
            hashSet.add(Qualified.unqualified(cls));
        }
        Dependency dependency = new Dependency(AutoValue_LibraryVersion.class, 2, 0);
        if (hashSet.contains(dependency.anInterface)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        hashSet2.add(dependency);
        arrayList.add(new Component(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new TransportImpl$$ExternalSyntheticLambda0(19), hashSet3));
        Qualified qualified = new Qualified(Background.class, Executor.class);
        Component.Builder builder = new Component.Builder(DefaultHeartBeatController.class, new Class[]{HeartBeatController.class, HeartBeatInfo.class});
        builder.add(Dependency.required(Context.class));
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(new Dependency(ProfileInstaller$2.class, 2, 0));
        builder.add(new Dependency(DefaultUserAgentPublisher.class, 1, 1));
        builder.add(new Dependency(qualified, 1, 0));
        builder.factory = new CctTransportBackend$$ExternalSyntheticLambda0(9, qualified);
        arrayList.add(builder.build());
        arrayList.add(CloseableKt.create("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(CloseableKt.create("fire-core", "20.4.2"));
        arrayList.add(CloseableKt.create("device-name", safeValue(Build.PRODUCT)));
        arrayList.add(CloseableKt.create("device-model", safeValue(Build.DEVICE)));
        arrayList.add(CloseableKt.create("device-brand", safeValue(Build.BRAND)));
        arrayList.add(CloseableKt.fromContext("android-target-sdk", new TransportImpl$$ExternalSyntheticLambda0(2)));
        arrayList.add(CloseableKt.fromContext("android-min-sdk", new TransportImpl$$ExternalSyntheticLambda0(3)));
        arrayList.add(CloseableKt.fromContext("android-platform", new TransportImpl$$ExternalSyntheticLambda0(4)));
        arrayList.add(CloseableKt.fromContext("android-installer", new TransportImpl$$ExternalSyntheticLambda0(5)));
        try {
            KotlinVersion.CURRENT.getClass();
            str = "1.9.10";
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(CloseableKt.create("kotlin", str));
        }
        return arrayList;
    }
}
