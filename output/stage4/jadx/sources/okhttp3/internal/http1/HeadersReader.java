package okhttp3.internal.http1;

import java.util.ArrayList;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okio.BufferedSource;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class HeadersReader {
    public long headerLimit = 262144;
    public final BufferedSource source;

    public HeadersReader(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    public final Headers readHeaders() {
        ArrayList arrayList = new ArrayList(20);
        while (true) {
            String utf8LineStrict = this.source.readUtf8LineStrict(this.headerLimit);
            this.headerLimit -= (long) utf8LineStrict.length();
            if (utf8LineStrict.length() == 0) {
                return new Headers((String[]) arrayList.toArray(new String[0]));
            }
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) utf8LineStrict, ':', 1, 4);
            if (iIndexOf$default != -1) {
                String strSubstring = utf8LineStrict.substring(0, iIndexOf$default);
                String strSubstring2 = utf8LineStrict.substring(iIndexOf$default + 1);
                arrayList.add(strSubstring);
                arrayList.add(StringsKt.trim(strSubstring2).toString());
            } else if (utf8LineStrict.charAt(0) == ':') {
                String strSubstring3 = utf8LineStrict.substring(1);
                arrayList.add("");
                arrayList.add(StringsKt.trim(strSubstring3).toString());
            } else {
                arrayList.add("");
                arrayList.add(StringsKt.trim(utf8LineStrict).toString());
            }
        }
    }
}
