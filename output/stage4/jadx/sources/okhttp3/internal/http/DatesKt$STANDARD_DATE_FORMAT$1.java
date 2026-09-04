package okhttp3.internal.http;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;
import okhttp3.internal.Util;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DatesKt$STANDARD_DATE_FORMAT$1 extends ThreadLocal {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ DatesKt$STANDARD_DATE_FORMAT$1(int i) {
        this.$r8$classId = i;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.$r8$classId) {
            case 0:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(C0000.decode(new byte[]{125, 115, 36, 77, 16, 80, 93, 70, 124, 124, 123, 20, 65, 79, 24, 24, 16, 124, 113, 92, 92, 92, 12, 71, 75, 22, 70, 38, 125, 96, 30}, "86aa049f1164", 0.0f), Locale.US);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.setTimeZone(Util.UTC);
                return simpleDateFormat;
            default:
                return new Random();
        }
    }
}
