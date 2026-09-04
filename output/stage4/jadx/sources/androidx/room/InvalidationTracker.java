package androidx.room;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Worker;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.EventBus;
import com.google.firebase.events.Subscriber;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class InvalidationTracker {
    public static final String[] TRIGGERS = {C0000.decode(new byte[]{55, 97, 38, 121, 96, 35}, "b1b84f6ddd8bdb", 0.0f), C0000.decode(new byte[]{125, 35, 46, 113, 98, 33}, "9fb46d1d"), C0000.decode(new byte[]{113, 122, 48, 35, 103, 101}, "84cf51b24c", 0.0f)};
    public volatile FrameworkSQLiteStatement cleanupStatement;
    public final WorkDatabase_Impl database;
    public volatile boolean initialized;
    public final ObservedTableTracker observedTableTracker;
    public final SafeIterableMap observerMap;
    public final AtomicBoolean pendingRefresh = new AtomicBoolean(false);
    public final Worker.AnonymousClass1 refreshRunnable;
    public final HashMap shadowTablesMap;
    public final Object syncTriggersLock;
    public final LinkedHashMap tableIdLookup;
    public final String[] tablesNames;
    public final Object trackerLock;

    public abstract class ObserverWrapper {
        public abstract void notifyByTableInvalidStatus$room_runtime_release(Set set);
    }

    public InvalidationTracker(WorkDatabase_Impl workDatabase_Impl, HashMap map, HashMap map2, String... strArr) {
        this.database = workDatabase_Impl;
        this.shadowTablesMap = map;
        this.observedTableTracker = new ObservedTableTracker(strArr.length);
        Collections.newSetFromMap(new IdentityHashMap());
        this.observerMap = new SafeIterableMap();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str2 = (String) this.shadowTablesMap.get(strArr[i]);
            String lowerCase2 = str2 != null ? str2.toLowerCase(locale) : null;
            if (lowerCase2 != null) {
                lowerCase = lowerCase2;
            }
            strArr2[i] = lowerCase;
        }
        this.tablesNames = strArr2;
        for (Map.Entry entry : this.shadowTablesMap.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase3 = str3.toLowerCase(locale2);
            if (this.tableIdLookup.containsKey(lowerCase3)) {
                String lowerCase4 = ((String) entry.getKey()).toLowerCase(locale2);
                LinkedHashMap linkedHashMap = this.tableIdLookup;
                Object obj = linkedHashMap.get(lowerCase3);
                if (obj == null && !linkedHashMap.containsKey(lowerCase3)) {
                    throw new NoSuchElementException(C0000.decode(new byte[]{114, 86, 79, 16}, "9360107a3793930f", 0.0f) + ((Object) lowerCase3) + C0000.decode(new byte[]{18, 10, 65, 17, 11, 11, 67, 17, 95, 95, 95, 21, 91, 13, 18, 69, 14, 7, 16, 15, 87, 65, 22}, "2c21fb0b6185", 0.0f));
                }
                linkedHashMap.put(lowerCase4, obj);
            }
        }
        this.refreshRunnable = new Worker.AnonymousClass1(5, this);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = this.database.mDatabase;
        if (!Intrinsics.areEqual(frameworkSQLiteDatabase != null ? Boolean.valueOf(frameworkSQLiteDatabase.delegate.isOpen()) : null, Boolean.TRUE)) {
            return false;
        }
        if (!this.initialized) {
            SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.database.internalOpenHelper;
            if (supportSQLiteOpenHelper == null) {
                supportSQLiteOpenHelper = null;
            }
            supportSQLiteOpenHelper.getWritableDatabase();
        }
        return this.initialized;
    }

    public final void startTrackingTable(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i) {
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{123, 119, 49, 32, 48, 109, 17, 41, 107, 22, 112, 116, 124, 118, 48, 32, 66, 112, 127, 50, 118, 22, 75, 92, 93, 84, 61, 17, 3, 91, 93, 3, 102, 91, 86, 87, 91, 95, 11, 6, 3, 77, 88, 9, 87, 105, 85, 92, 85, 25, 52, 36, 46, 108, 116, 53, 17}, "29beb91f9693", 0.0f) + i + C0000.decode(new byte[]{78, 19, 85, 30}, "b3e7df"));
        String str = this.tablesNames[i];
        for (int i2 = 0; i2 < 3; i2++) {
            String str2 = TRIGGERS[i2];
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{34, 52, 118, 118, 53, 116, 19, 55, 124, 116, 50, 18, 50, 102, 43, 117, 38, 35, 97, 23, 40, 119, 19, 45, 118, 109, 66, 119, 62, 125, 49, 102, 50, 70}, "af37a13c99b2f4b2"));
            sb.append(C0000.decode(new byte[]{89, 70, 10, 86, 91, 61, 21, 89, 91, 88, 0, 102, 91, 13, 5, 81, 95, 93, 6, 88, 66, 11, 14, 86, 102, 64, 23, 80, 81, 5, 4, 74, 102}, "94e96ba8", true) + str + '_' + str2 + '`');
            sb.append(C0000.decode(new byte[]{17, 118, 117, 96, 36, 96, 67}, "1734a2c9d7", false));
            sb.append(str2);
            sb.append(C0000.decode(new byte[]{20, 42, 40, 20, 85}, "4ef452b8", 3));
            sb.append(str);
            sb.append(C0000.decode(new byte[]{89, 23, 117, 118, 116, 120, 124, 24, 98, 101, 34, 113, 109, 114, 23, 65, 92, 94, 95, 103, 67, 84, 4, 92, 92, 104, 90, 92, 87, 88, 84, 81, 84, 84, 18, 89, 86, 89, 104, 95, 92, 86, 18, 107, 114, 97, 70, 89, 87, 65, 86, 95, 90, 85, 83, 76, 82, 81, 70, 13, 25, 6, 23, 100, 123, 116, 96, 125, 23, 65, 7, 82, 85, 82, 104, 90, 87, 17, 15, 24}, "9773312875f0", false));
            sb.append(i);
            sb.append(C0000.decode(new byte[]{66, 112, 47, 125, 68, 88, 89, 79, 85, 91, 93, 86, 4, 64, 7, 85, 65, 4, 68, 1, 12, 25, 113, 121, 112}, "b1a9d1794742e4", true));
            frameworkSQLiteDatabase.execSQL(sb.toString());
        }
    }

    public final void syncTriggers$room_runtime_release(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        if (frameworkSQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            ReentrantReadWriteLock.ReadLock lock = this.database.readWriteLock.readLock();
            lock.lock();
            try {
                synchronized (this.syncTriggersLock) {
                    try {
                        int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                        if (tablesToSync != null) {
                            if (frameworkSQLiteDatabase.isWriteAheadLoggingEnabled()) {
                                frameworkSQLiteDatabase.beginTransactionNonExclusive();
                            } else {
                                frameworkSQLiteDatabase.beginTransaction();
                            }
                            try {
                                int length = tablesToSync.length;
                                int i = 0;
                                int i2 = 0;
                                while (i < length) {
                                    int i3 = tablesToSync[i];
                                    int i4 = i2 + 1;
                                    if (i3 == 1) {
                                        startTrackingTable(frameworkSQLiteDatabase, i2);
                                    } else if (i3 == 2) {
                                        String str = this.tablesNames[i2];
                                        String[] strArr = TRIGGERS;
                                        for (int i5 = 0; i5 < 3; i5++) {
                                            String str2 = strArr[i5];
                                            StringBuilder sb = new StringBuilder("DROP TRIGGER IF EXISTS ");
                                            sb.append("`room_table_modification_trigger_" + str + '_' + str2 + '`');
                                            frameworkSQLiteDatabase.execSQL(sb.toString());
                                        }
                                    }
                                    i++;
                                    i2 = i4;
                                }
                                frameworkSQLiteDatabase.setTransactionSuccessful();
                                frameworkSQLiteDatabase.endTransaction();
                            } catch (Throwable th) {
                                frameworkSQLiteDatabase.endTransaction();
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                lock.unlock();
            } catch (Throwable th3) {
                lock.unlock();
                throw th3;
            }
        } catch (SQLiteException | IllegalStateException unused) {
        }
    }

    public final class ObservedTableTracker {
        public boolean needsSync;
        public final Object tableObservers;
        public final Object triggerStateChanges;
        public Serializable triggerStates;

        public ObservedTableTracker(FirebaseMessaging firebaseMessaging, Subscriber subscriber) {
            this.triggerStateChanges = firebaseMessaging;
            this.tableObservers = subscriber;
        }

        public int[] getTablesToSync() {
            synchronized (this) {
                try {
                    if (!this.needsSync) {
                        return null;
                    }
                    long[] jArr = (long[]) this.tableObservers;
                    int length = jArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        int i3 = i2 + 1;
                        int i4 = 1;
                        boolean z = jArr[i] > 0;
                        boolean[] zArr = (boolean[]) this.triggerStates;
                        if (z != zArr[i2]) {
                            int[] iArr = (int[]) this.triggerStateChanges;
                            if (!z) {
                                i4 = 2;
                            }
                            iArr[i2] = i4;
                        } else {
                            ((int[]) this.triggerStateChanges)[i2] = 0;
                        }
                        zArr[i2] = z;
                        i++;
                        i2 = i3;
                    }
                    this.needsSync = false;
                    return (int[]) ((int[]) this.triggerStateChanges).clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public synchronized boolean isEnabled() {
            boolean z;
            boolean zBooleanValue;
            try {
                synchronized (this) {
                    try {
                        if (!this.needsSync) {
                            Boolean enabled = readEnabled();
                            this.triggerStates = enabled;
                            if (enabled == null) {
                                ((EventBus) ((Subscriber) this.tableObservers)).subscribe(new TransportImpl$$ExternalSyntheticLambda0(15));
                            }
                            this.needsSync = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zBooleanValue;
            } catch (Throwable th2) {
                throw th2;
            }
            Boolean bool = (Boolean) this.triggerStates;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                FirebaseApp firebaseApp = ((FirebaseMessaging) this.triggerStateChanges).firebaseApp;
                firebaseApp.checkNotDeleted();
                DataCollectionConfigStorage dataCollectionConfigStorage = (DataCollectionConfigStorage) firebaseApp.dataCollectionConfigStorage.get();
                synchronized (dataCollectionConfigStorage) {
                    z = dataCollectionConfigStorage.dataCollectionDefaultEnabled;
                }
                zBooleanValue = z;
            }
            return zBooleanValue;
        }

        public Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            String strDecode = C0000.decode(new byte[]{94, 8, 75, 81, 0, 88, 22, 86, 110, 88, 92, 64, 75, 0, 94, 93, 12, 94, 58, 82, 68, 65, 86, 108, 81, 15, 80, 64, 61, 92, 11, 82, 83, 89, 92, 87}, "8a94b9e31593", false);
            FirebaseApp firebaseApp = ((FirebaseMessaging) this.triggerStateChanges).firebaseApp;
            firebaseApp.checkNotDeleted();
            Context context = firebaseApp.applicationContext;
            SharedPreferences sharedPreferences = context.getSharedPreferences(C0000.decode(new byte[]{7, 12, 91, 24, 86, 91, 11, 5, 8, 6, 24, 80, 88, 70, 1, 0, 5, 16, 83, 24, 92, 81, 23, 17, 5, 4, 95, 88, 86}, "dc6614db", false), 0);
            String strDecode2 = C0000.decode(new byte[]{4, 68, 23, 13, 58, 10, 90, 92, 23}, "e1cbec45c6e46e", true);
            if (sharedPreferences.contains(strDecode2)) {
                return Boolean.valueOf(sharedPreferences.getBoolean(strDecode2, false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(strDecode)) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(strDecode));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [boolean[], java.io.Serializable] */
        public ObservedTableTracker(int i) {
            this.tableObservers = new long[i];
            this.triggerStates = new boolean[i];
            this.triggerStateChanges = new int[i];
        }
    }
}
