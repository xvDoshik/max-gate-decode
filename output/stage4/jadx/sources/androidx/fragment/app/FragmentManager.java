package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class FragmentManager {
    public static final int[] Fragment = {R.attr.name, R.attr.id, R.attr.tag};

    public Fragment instantiate(Context context, String str, Bundle bundle) {
        return Fragment.instantiate(context, str, bundle);
    }

    public abstract View onFindViewById(int i);

    public abstract boolean onHasView();
}
