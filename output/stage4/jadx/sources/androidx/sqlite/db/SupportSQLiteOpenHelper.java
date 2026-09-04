package androidx.sqlite.db;

import android.content.Context;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.io.Closeable;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    public final class Configuration {
        public final boolean allowDataLossOnRecovery;
        public final RoomOpenHelper callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        public Configuration(Context context, String str, RoomOpenHelper roomOpenHelper, boolean z, boolean z2) {
            this.context = context;
            this.name = str;
            this.callback = roomOpenHelper;
            this.useNoBackupDirectory = z;
            this.allowDataLossOnRecovery = z2;
        }
    }

    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    FrameworkSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);
}
