package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException(C0000.decode(new byte[]{120, 86, 67, 18, 81, 84, 14, 93, 64, 0, 7, 28}, "697208b27ec2a2", 0.0f));
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        throw new IllegalStateException(C0000.decode(new byte[]{121, 91, 71, 68, 83, 92, 91, 91, 68, 1, 86, 30}, "743d20"));
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException(C0000.decode(new byte[]{44, 11, 17, 67, 3, 89, 14, 11, 18, 6, 6, 27}, "bdecb5"));
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x005c */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onCreate() {
        /*
            r8 = this;
            android.content.Context r0 = r8.getContext()
            if (r0 == 0) goto L6b
            android.content.Context r1 = r0.getApplicationContext()
            if (r1 == 0) goto L69
            androidx.startup.AppInitializer r1 = androidx.startup.AppInitializer.sInstance
            if (r1 != 0) goto L25
            java.lang.Object r1 = androidx.startup.AppInitializer.sLock
            monitor-enter(r1)
            androidx.startup.AppInitializer r2 = androidx.startup.AppInitializer.sInstance     // Catch: java.lang.Throwable -> L1f
            if (r2 != 0) goto L21
            androidx.startup.AppInitializer r2 = new androidx.startup.AppInitializer     // Catch: java.lang.Throwable -> L1f
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1f
            androidx.startup.AppInitializer.sInstance = r2     // Catch: java.lang.Throwable -> L1f
            goto L21
        L1f:
            r0 = move-exception
            goto L23
        L21:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1f
            goto L25
        L23:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1f
            throw r0
        L25:
            androidx.startup.AppInitializer r0 = androidx.startup.AppInitializer.sInstance
            android.content.Context r1 = r0.mContext
            r5 = 7
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            r5 = {x0082: FILL_ARRAY_DATA , data: [48, 21, 89, 68, 21, 71, 19} // fill-array     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            java.lang.String r2 = "ca86a2"
            r7 = 7
            java.lang.String r2 = p000.C0000.decode(r5, r2, r7)     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            android.os.Trace.beginSection(r2)     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            java.lang.String r3 = r1.getPackageName()     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            java.lang.Class<androidx.startup.InitializationProvider> r4 = androidx.startup.InitializationProvider.class
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ProviderInfo r1 = r1.getProviderInfo(r2, r3)     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            android.os.Bundle r1 = r1.metaData     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            r0.discoverAndInitialize(r1)     // Catch: java.lang.Throwable -> L5c android.content.pm.PackageManager.NameNotFoundException -> L5e
            android.os.Trace.endSection()
            goto L69
        L5c:
            r0 = move-exception
            goto L65
        L5e:
            r0 = move-exception
            androidx.startup.StartupException r1 = new androidx.startup.StartupException     // Catch: java.lang.Throwable -> L5c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L5c
            throw r1     // Catch: java.lang.Throwable -> L5c
        L65:
            android.os.Trace.endSection()
            throw r0
        L69:
            r0 = 1
            return r0
        L6b:
            androidx.startup.StartupException r0 = new androidx.startup.StartupException
            r5 = 22
            byte[] r5 = new byte[r5]
            r5 = {x008a: FILL_ARRAY_DATA , data: [118, 90, 8, 71, 1, 29, 17, 66, 1, 80, 86, 10, 90, 65, 70, 81, 1, 69, 11, 23, 14, 93} // fill-array
            java.lang.String r1 = "55f3deebb18d"
            r7 = 4
            java.lang.String r1 = p000.C0000.decode(r5, r1, r7)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.startup.InitializationProvider.onCreate():boolean");
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException(C0000.decode(new byte[]{126, 86, 77, 19, 3, 90, 13, 95, 65, 85, 84, 23}, "0993b6a060"));
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException(C0000.decode(new byte[]{125, 9, 66, 21, 5, 84, 95, 9, 65, 80, 0, 22}, "3f65d8"));
    }
}
