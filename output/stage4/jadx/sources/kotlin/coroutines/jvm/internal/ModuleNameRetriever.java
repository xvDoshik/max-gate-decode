package kotlin.coroutines.jvm.internal;

import androidx.work.impl.model.WorkTagDao_Impl;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ModuleNameRetriever {
    public static WorkTagDao_Impl cache;
    public static final WorkTagDao_Impl notOnJava9;

    static {
        Object obj = null;
        notOnJava9 = new WorkTagDao_Impl(obj, obj, obj);
    }
}
