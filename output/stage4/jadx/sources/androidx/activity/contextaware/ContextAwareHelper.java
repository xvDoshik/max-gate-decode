package androidx.activity.contextaware;

import androidx.activity.ComponentActivity;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ContextAwareHelper {
    public volatile ComponentActivity context;
    public final CopyOnWriteArraySet listeners = new CopyOnWriteArraySet();
}
