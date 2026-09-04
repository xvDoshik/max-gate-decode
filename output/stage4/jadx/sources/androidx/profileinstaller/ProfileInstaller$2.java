package androidx.profileinstaller;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.gms.tasks.zzu;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ProfileInstaller$2 implements ProfileInstaller$DiagnosticsCallback, SupportSQLiteOpenHelper.Factory, Factory, Clock {
    public static ProfileInstaller$2 singleton;

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback, configuration.useNoBackupDirectory, configuration.allowDataLossOnRecovery);
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new zzu(2, Executors.newSingleThreadExecutor());
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return System.currentTimeMillis();
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
        if (i == 6 || i == 7 || i == 8) {
        }
    }
}
