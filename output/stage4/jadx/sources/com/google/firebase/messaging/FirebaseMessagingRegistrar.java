package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import java.util.Arrays;
import java.util.List;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = C0000.decode(new byte[]{3, 91, 23, 93, 27, 94, 91, 93}, "e2e86880572b", false);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(ComponentContainer componentContainer) {
        FirebaseApp firebaseApp = (FirebaseApp) componentContainer.get(FirebaseApp.class);
        if (componentContainer.get(FirebaseInstanceIdInternal.class) == null) {
            return new FirebaseMessaging(firebaseApp, componentContainer.getProvider(DefaultUserAgentPublisher.class), componentContainer.getProvider(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.get(FirebaseInstallationsApi.class), (TransportFactory) componentContainer.get(TransportFactory.class), (Subscriber) componentContainer.get(Subscriber.class));
        }
        throw new ClassCastException();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<Component> getComponents() {
        Component.Builder builder = new Component.Builder(FirebaseMessaging.class, new Class[0]);
        String strDecode = C0000.decode(new byte[]{83, 15, 69, 6, 28, 5, 86, 11}, "5f7c1c");
        builder.name = strDecode;
        builder.add(Dependency.required(FirebaseApp.class));
        builder.add(new Dependency(FirebaseInstanceIdInternal.class, 0, 0));
        builder.add(new Dependency(DefaultUserAgentPublisher.class, 0, 1));
        builder.add(new Dependency(HeartBeatInfo.class, 0, 1));
        builder.add(new Dependency(TransportFactory.class, 0, 0));
        builder.add(Dependency.required(FirebaseInstallationsApi.class));
        builder.add(Dependency.required(Subscriber.class));
        builder.factory = new TransportImpl$$ExternalSyntheticLambda0(16);
        if (!(builder.instantiation == 0)) {
            throw new IllegalStateException(C0000.decode(new byte[]{121, 11, 71, 65, 85, 15, 18, 81, 81, 17, 93, 90, 90, 65, 18, 65, 64, 0, 20, 93, 85, 18, 70, 89, 92, 23, 81, 84, 80, 24, 70, 90, 85, 0, 90, 21, 71, 4, 18, 22}, "0e454af8", 3));
        }
        builder.instantiation = 1;
        return Arrays.asList(builder.build(), CloseableKt.create(strDecode, C0000.decode(new byte[]{1, 2, 30, 7, 31, 83}, "31031b", 0.0f)));
    }
}
