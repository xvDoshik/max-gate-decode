package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage2/classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0006"}, d2 = {"constructMessage", "", "file", "Ljava/io/File;", "other", "reason", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExceptionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String constructMessage(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(C0000.decode(new byte[]{19, 75, 9, 68}, "3f7d02112033efc9", 4) + file2);
        }
        if (str != null) {
            sb.append(C0000.decode(new byte[]{91, 66}, "ab196a", 0.0f) + str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, C0000.decode(new byte[]{66, 87, 100, 68, 20, 13, 92, 84, 30, 24, 25, 76, 31}, "6870fd23667b", true));
        return string;
    }
}
