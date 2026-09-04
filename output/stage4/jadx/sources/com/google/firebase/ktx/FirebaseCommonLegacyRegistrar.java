package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Collections;
import java.util.List;
import kotlin.io.CloseableKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@Keep
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component> getComponents() {
        return Collections.singletonList(CloseableKt.create(C0000.decode(new byte[]{94, 94, 66, 84, 21, 1, 88, 17, 4, 21, 13, 17, 28}, "87018b7ca8fed674"), C0000.decode(new byte[]{4, 9, 22, 2, 23, 10}, "698698c0fc3c", 3)));
    }
}
