package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0001¢\u0006\u0002\b\u0003\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002\u001a\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r*\u00020\u0002H\u0001¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getStackTraceElement", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "getLabel", "", "checkDebugMetadataVersion", "", "expected", "actual", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "COROUTINES_DEBUG_METADATA_VERSION", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION = 1;

    private static final void checkDebugMetadataVersion(int i, int i2) {
        if (i2 > i) {
            throw new IllegalStateException((C0000.decode(new byte[]{39, 83, 6, 16, 1, 65, 88, 84, 67, 0, 80, 84, 23, 87, 68, 19, 3, 19, 70, 88, 88, 15, 20, 88, 10, 69, 9, 4, 18, 2, 93, 31, 23, 36, 76, 69, 6, 85, 16, 0, 2, 91, 21}, "c6defa517a45", false) + i + C0000.decode(new byte[]{30, 19, 82, 91, 76, 19}, "2354834f") + i2 + C0000.decode(new byte[]{75, 18, 102, 95, 86, 81, 68, 93, 22, 23, 68, 7, 82, 76, 83, 23, 17, 90, 83, 19, 120, 95, 67, 84, 95, 12, 20, 16, 71, 89, 88, 83, 4, 64, 82, 19, 95, 89, 85, 74, 87, 16, 77, 77}, "e26330786b4c3867")).toString());
        }
    }

    private static final int getLabel(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField(C0000.decode(new byte[]{91, 86, 4, 4, 10}, "77faf864e83979", 0.0f));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, C0000.decode(new byte[]{88, 68, 11, 93, 18, 6}, "d0c4a8982fe82f71", 1));
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        checkDebugMetadataVersion(1, debugMetadataAnnotation.v());
        ArrayList arrayList = new ArrayList();
        int label = getLabel(baseContinuationImpl);
        int[] iArrI = debugMetadataAnnotation.i();
        int length = iArrI.length;
        for (int i = 0; i < length; i++) {
            if (iArrI[i] == label) {
                arrayList.add(debugMetadataAnnotation.s()[i]);
                arrayList.add(debugMetadataAnnotation.n()[i]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, C0000.decode(new byte[]{11, 22, 81, 91, 69, 11}, "7b926572a8af6a", 7));
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        checkDebugMetadataVersion(1, debugMetadataAnnotation.v());
        int label = getLabel(baseContinuationImpl);
        int i = label < 0 ? -1 : debugMetadataAnnotation.l()[label];
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(baseContinuationImpl);
        return new StackTraceElement(moduleName == null ? debugMetadataAnnotation.c() : moduleName + '/' + debugMetadataAnnotation.c(), debugMetadataAnnotation.m(), debugMetadataAnnotation.f(), i);
    }

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }
}
