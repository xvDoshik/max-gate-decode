package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class DeviceProfileWriter {
    public final String mApkName;
    public final File mCurProfile;
    public final byte[] mDesiredVersion;
    public boolean mDeviceSupportsAotProfile = false;
    public final ProfileInstaller$DiagnosticsCallback mDiagnostics;
    public final Executor mExecutor;
    public DexProfileData[] mProfile;
    public byte[] mTranscodedProfile;

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback, String str, File file) {
        this.mExecutor = executor;
        this.mDiagnostics = profileInstaller$DiagnosticsCallback;
        this.mApkName = str;
        this.mCurProfile = file;
        int i = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i <= 33) {
            switch (i) {
                case 26:
                    bArr = Encoding.V005_O;
                    break;
                case 27:
                    bArr = Encoding.V009_O_MR1;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = Encoding.V010_P;
                    break;
                case 31:
                case 32:
                case 33:
                    bArr = Encoding.V015_S;
                    break;
            }
        }
        this.mDesiredVersion = bArr;
    }

    public final FileInputStream openStreamFromAssets(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null) {
                return null;
            }
            message.contains(C0000.decode(new byte[]{7, 9, 91, 22, 67, 3, 69, 69, 83, 0}, "df6f1f666dd5"));
            return null;
        }
    }

    public final void result(final int i, final Serializable serializable) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.mDiagnostics.onResultReceived(i, serializable);
            }
        });
    }
}
