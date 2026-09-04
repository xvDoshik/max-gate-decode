package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.tracing.Trace;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportFactoryImpl;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = C0000.decode(new byte[]{4, 10, 68, 82, 20, 22, 16, 2, 88, 68, 73, 13, 16, 23}, "bc679b", true);

    /* JADX INFO: Access modifiers changed from: private */
    public static TransportFactory lambda$getComponents$0(ComponentContainer componentContainer) {
        byte[] bytes;
        TransportRuntime.initialize((Context) componentContainer.get(Context.class));
        TransportRuntime transportRuntime = TransportRuntime.getInstance();
        CCTDestination cCTDestination = CCTDestination.LEGACY_INSTANCE;
        transportRuntime.getClass();
        Set setUnmodifiableSet = cCTDestination != null ? Collections.unmodifiableSet(CCTDestination.SUPPORTED_ENCODINGS) : Collections.singleton(new Encoding(C0000.decode(new byte[]{70, 69, 88, 69, 9}, "6771ff2743ecce")));
        zzac zzacVarBuilder = AutoValue_TransportContext.builder();
        cCTDestination.getClass();
        zzacVarBuilder.zzb = C0000.decode(new byte[]{90, 81, 68}, "92040b62e20801", 0.0f);
        String str = cCTDestination.endPoint;
        String str2 = cCTDestination.apiKey;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = (C0000.decode(new byte[]{6, 16}, "74008a9354b00a75", 0.0f) + str + C0000.decode(new byte[]{111}, "39f50b2b60", 5) + str2).getBytes(Charset.forName(C0000.decode(new byte[]{51, 99, 32, 79, 13}, "f7fb5942cc4c147c")));
        }
        zzacVarBuilder.zza = bytes;
        return new TransportFactoryImpl(setUnmodifiableSet, zzacVarBuilder.build(), transportRuntime);
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component> getComponents() {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(Qualified.unqualified(TransportFactory.class));
        for (Class cls : new Class[0]) {
            Trace.checkNotNull(cls, C0000.decode(new byte[]{125, 76, 15, 91, 20, 92, 15, 16, 86, 75, 5, 86, 87, 80}, "39c745ad"));
            hashSet.add(Qualified.unqualified(cls));
        }
        Dependency dependencyRequired = Dependency.required(Context.class);
        if (hashSet.contains(dependencyRequired.anInterface)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{117, 11, 91, 68, 86, 86, 82, 89, 68, 18, 18, 81, 16, 92, 17, 8, 89, 16, 22, 85, 85, 84, 88, 64, 85, 5, 18, 68, 13, 25, 85, 3, 70, 1, 88, 80, 25, 87, 89, 23, 89, 15, 70, 85, 16, 95, 80, 5, 83, 23, 22, 64, 81, 93, 78, 23, 68, 9, 87, 93, 17, 92, 93, 16, 83, 23, 22, 68, 75, 87, 65, 94, 84, 4, 28}, "6d6498770a20b91f", 0.0f));
        }
        hashSet2.add(dependencyRequired);
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(11);
        HashSet hashSet4 = new HashSet(hashSet);
        HashSet hashSet5 = new HashSet(hashSet2);
        String strDecode = C0000.decode(new byte[]{0, 12, 20, 82, 31, 66, 66, 2, 95, 64, 22, 10, 20, 67}, "fef7260c13", true);
        return Arrays.asList(new Component(strDecode, hashSet4, hashSet5, 0, 0, transportImpl$$ExternalSyntheticLambda0, hashSet3), CloseableKt.create(strDecode, C0000.decode(new byte[]{9, 0, 27, 0, 31, 81}, "88511fd762", 0.0f)));
    }
}
