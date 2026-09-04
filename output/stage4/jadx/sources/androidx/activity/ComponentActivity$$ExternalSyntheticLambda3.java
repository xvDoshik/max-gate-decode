package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda3 {
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda3(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    public final void onContextAvailable() {
        ComponentActivity componentActivity = this.f$0;
        Bundle bundleConsumeRestoredStateForKey = ((SavedStateRegistry) componentActivity.mSavedStateRegistryController.zzb).consumeRestoredStateForKey(C0000.decode(new byte[]{89, 13, 1, 64, 11, 8, 86, 95, 75, 22, 21, 66, 11, 19, 70, 95, 89, 0, 17, 91, 18, 8, 70, 28, 21, 17, 0, 65, 17, 13, 70}, "8ce2da2e", false));
        if (bundleConsumeRestoredStateForKey != null) {
            ComponentActivity.AnonymousClass1 anonymousClass1 = componentActivity.mActivityResultRegistry;
            HashMap map = anonymousClass1.mRcToKey;
            Bundle bundle = anonymousClass1.mPendingResults;
            HashMap map2 = anonymousClass1.mKeyToRc;
            ArrayList<Integer> integerArrayList = bundleConsumeRestoredStateForKey.getIntegerArrayList(C0000.decode(new byte[]{47, 118, 104, 106, 122, 118, 41, 99, 126, 123, 124, 119, 48, 108, 112, 118, 109, 112, 50, 122, 101, 108, 102, 107, 33, 116, 120, 102, 109, 124, 54, 118, 117, 106, 107, 122, 55}, "d31599", false));
            ArrayList<String> stringArrayList = bundleConsumeRestoredStateForKey.getStringArrayList(C0000.decode(new byte[]{124, 114, 59, 105, 39, 119, 41, 103, 120, 121, 39, 120, 48, 103, 37, 116, 99, 126, 52, 127, 48, 97, 59, 101, 114, 112, 43, 101, 48, 125, 54, 114, 115, 104, 41, 115, 61, 107}, "77b6d8d7", 3));
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            anonymousClass1.mLaunchedKeys = bundleConsumeRestoredStateForKey.getStringArrayList(C0000.decode(new byte[]{121, 35, 56, 105, 38, 46, 127, 54, 46, 120, 32, 47, 102, 57, 32, 117, 49, 40, 100, 47, 53, 111, 58, 45, 115, 51, 47, 117, 45, 36, 118, 57, 42, 115, 60, 50}, "2fa6ea", 0.0f));
            bundle.putAll(bundleConsumeRestoredStateForKey.getBundle(C0000.decode(new byte[]{40, 116, 61, 111, 118, 122, 127, 97, 121, 120, 112, 121, 108, 106, 34, 114, 48, 121, 99, 124, 102, 104, 105, 102, 112, 121, 124, 124, 45, 118, 59, 98, 112, 102, 103, 125, 98}, "c1d05521665785", 0.0f)));
            for (int i = 0; i < stringArrayList.size(); i++) {
                String str = stringArrayList.get(i);
                if (map2.containsKey(str)) {
                    Integer num = (Integer) map2.remove(str);
                    if (!bundle.containsKey(str)) {
                        map.remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i);
                num2.getClass();
                String str2 = stringArrayList.get(i);
                map.put(num2, str2);
                map2.put(str2, num2);
            }
        }
    }
}
