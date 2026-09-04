package kotlinx.coroutines.internal;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Symbol implements SupportSQLiteQuery {
    public final /* synthetic */ int $r8$classId;
    public final String symbol;

    public /* synthetic */ Symbol(String str, int i) {
        this.$r8$classId = i;
        this.symbol = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.symbol;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return C0000.decode(new byte[]{11}, "7934ed785ca43161", true) + this.symbol + '>';
            default:
                return super.toString();
        }
    }
}
