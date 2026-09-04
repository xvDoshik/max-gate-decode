package androidx.sqlite.db.framework;

import androidx.sqlite.db.SupportSQLiteQuery;
import kotlin.Function;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FrameworkSQLiteDatabase$query$cursorFactory$1 extends Lambda implements Function {
    public final /* synthetic */ SupportSQLiteQuery $query;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteDatabase$query$cursorFactory$1(SupportSQLiteQuery supportSQLiteQuery) {
        super(4);
        this.$query = supportSQLiteQuery;
    }
}
