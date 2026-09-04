package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzag;
import com.google.firebase.AutoValue_StartupTime;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.StartupTime;
import java.util.concurrent.atomic.AtomicBoolean;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class FirebaseInitProvider extends ContentProvider {
    static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = C0000.decode(new byte[]{1, 87, 15, 74, 83, 89, 92, 84, 91, 80, 79, 5, 11, 64, 7, 90, 3, 23, 81, 24, 85, 90, 69, 80, 3, 2, 17, 87, 11, 86, 11, 16, 68, 68, 92, 69, 94, 81, 4, 17}, "b8bd463375acb2", false);
    private static final String TAG = C0000.decode(new byte[]{37, 88, 70, 87, 86, 82, 16, 81, 40, 91, 80, 77, 96, 23, 94, 64, 10, 85, 81, 64}, "c14243c4a5990e16", 2);
    private static StartupTime startupTime = new AutoValue_StartupTime(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    private static AtomicBoolean currentlyInitializing = new AtomicBoolean(false);

    private static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        zzag.checkNotNull(providerInfo, C0000.decode(new byte[]{116, 90, 68, 80, 86, 87, 17, 81, 123, 93, 95, 67, 98, 65, 89, 67, 93, 82, 7, 70, 18, 99, 68, 88, 68, 90, 82, 80, 70, 127, 12, 82, 93, 19, 85, 86, 92, 93, 89, 65, 20, 84, 7, 20, 92, 70, 90, 91, 28}, "236546b42367", false));
        if (C0000.decode(new byte[]{86, 10, 92, 28, 87, 95, 92, 95, 89, 0, 31, 84, 89, 66, 86, 90, 84, 22, 84, 28, 86, 89, 65, 93, 87, 4, 66, 87, 89, 94, 90, 76, 69, 23, 94, 68, 89, 84, 86, 74}, "5e120038", true).equals(providerInfo.authority)) {
            throw new IllegalStateException(C0000.decode(new byte[]{123, 15, 7, 12, 74, 69, 87, 2, 16, 67, 72, 69, 93, 23, 13, 7, 93, 69, 18, 0, 17, 23, 80, 88, 64, 8, 16, 26, 24, 94, 92, 65, 9, 2, 86, 94, 84, 4, 23, 23, 22, 23, 127, 14, 23, 23, 24, 91, 91, 10, 1, 15, 65, 23, 86, 20, 1, 67, 76, 88, 18, 0, 68, 14, 81, 68, 65, 8, 10, 4, 24, 86, 66, 17, 8, 10, 91, 86, 70, 8, 11, 13, 113, 83, 18, 23, 5, 17, 81, 86, 80, 13, 1, 67, 81, 89, 18, 0, 20, 19, 84, 94, 81, 0, 16, 10, 87, 89, 21, 18, 68, 1, 77, 94, 94, 5, 74, 4, 74, 86, 86, 13, 1, 77}, "2adc87", false));
        }
    }

    public static StartupTime getStartupTime() {
        return startupTime;
    }

    public static boolean isCurrentlyInitializing() {
        return currentlyInitializing.get();
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        checkContentProviderAuthority(providerInfo);
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            currentlyInitializing.set(true);
            Context context = getContext();
            synchronized (FirebaseApp.LOCK) {
                try {
                    if (FirebaseApp.INSTANCES.containsKey(C0000.decode(new byte[]{56, 33, 112, 112, 112, 54, 127, 55, 63}, "ce561c3cbd7c70", 0.0f))) {
                        FirebaseApp.getInstance();
                    } else {
                        FirebaseOptions firebaseOptionsFromResource = FirebaseOptions.fromResource(context);
                        if (firebaseOptionsFromResource != null) {
                            FirebaseApp.initializeApp(context, firebaseOptionsFromResource);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            currentlyInitializing.set(false);
            return false;
        } catch (Throwable th2) {
            currentlyInitializing.set(false);
            throw th2;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
