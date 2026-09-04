package com.google.firebase.installations;

import androidx.annotation.Keep;
import androidx.profileinstaller.ProfileInstaller$2;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.concurrent.SequentialExecutor;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = C0000.decode(new byte[]{94, 81, 67, 81, 27, 94, 91, 67, 70, 5, 88, 89, 89, 76, 88, 91, 88, 68}, "881467502d45");

    /* JADX INFO: Access modifiers changed from: private */
    public static FirebaseInstallationsApi lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseInstallations((FirebaseApp) componentContainer.get(FirebaseApp.class), componentContainer.getProvider(HeartBeatController.class), (ExecutorService) componentContainer.get(new Qualified(Background.class, ExecutorService.class)), new SequentialExecutor((Executor) componentContainer.get(new Qualified(Blocking.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component> getComponents() {
        Component.Builder builder = new Component.Builder(FirebaseInstallationsApi.class, new Class[0]);
        String strDecode = C0000.decode(new byte[]{83, 81, 20, 85, 21, 91, 90, 17, 66, 85, 89, 84, 7, 68, 81, 93, 90, 17}, "58f0824b64");
        builder.name = strDecode;
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(new Dependency(HeartBeatController.class, 0, 1));
        builder.add(new Dependency(new Qualified(Background.class, ExecutorService.class), 1, 0));
        builder.add(new Dependency(new Qualified(Blocking.class, Executor.class), 1, 0));
        builder.factory = new TransportImpl$$ExternalSyntheticLambda0(12);
        Component componentBuild = builder.build();
        ProfileInstaller$2 profileInstaller$2 = new ProfileInstaller$2();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(Qualified.unqualified(ProfileInstaller$2.class));
        return Arrays.asList(componentBuild, new Component(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new CctTransportBackend$$ExternalSyntheticLambda0(8, profileInstaller$2), hashSet3), CloseableKt.create(strDecode, C0000.decode(new byte[]{82, 4, 24, 87, 22, 3}, "c36e83")));
    }
}
