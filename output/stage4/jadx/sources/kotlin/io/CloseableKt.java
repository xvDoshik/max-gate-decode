package kotlin.io;

import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.tracing.Trace;
import androidx.work.SystemClock;
import androidx.work.impl.Api21Impl;
import androidx.work.impl.WorkDatabasePathHelperKt;
import androidx.work.impl.utils.futures.AbstractFuture;
import com.base.template.services.StealthVpnService;
import com.google.android.datatransport.cct.CctTransportBackend$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.platforminfo.AutoValue_LibraryVersion;
import com.google.firebase.tracing.ComponentMonitor$$ExternalSyntheticLambda0;
import java.io.Closeable;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.TlsVersion;
import okio.Buffer;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CloseableKt {
    public static void appendElement(StringBuilder sb, Object obj, Function1 function1) {
        if (function1 != null) {
            sb.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) String.valueOf(obj));
        }
    }

    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }

    public static Component create(String str, String str2) {
        AutoValue_LibraryVersion autoValue_LibraryVersion = new AutoValue_LibraryVersion(str, str2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(Qualified.unqualified(AutoValue_LibraryVersion.class));
        return new Component(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new CctTransportBackend$$ExternalSyntheticLambda0(8, autoValue_LibraryVersion), hashSet3);
    }

    public static boolean defaultValueEquals(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < str.length()) {
                char cCharAt = str.charAt(i);
                int i4 = i3 + 1;
                if (i3 != 0 || cCharAt == '(') {
                    if (cCharAt == '(') {
                        i2++;
                    } else if (cCharAt != ')' || (i2 = i2 - 1) != 0 || i3 == str.length() - 1) {
                    }
                    i++;
                    i3 = i4;
                }
            }
            if (i2 == 0) {
                return Intrinsics.areEqual(StringsKt.trim(str.substring(1, str.length() - 1)).toString(), str2);
            }
        }
        return false;
    }

    public static TlsVersion forJavaName(String str) {
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals(C0000.decode(new byte[]{99, 45, 106, 70, 84, 76, 80}, "7a90ebaa50"))) {
                            return TlsVersion.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (str.equals(C0000.decode(new byte[]{98, 126, 53, 64, 87, 29, 5}, "62f6f377c24fcb8e"))) {
                            return TlsVersion.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (str.equals(C0000.decode(new byte[]{99, 121, 53, 16, 1, 24, 4}, "75ff06707a", 6))) {
                            return TlsVersion.TLS_1_3;
                        }
                        break;
                }
            } else if (str.equals(C0000.decode(new byte[]{101, 123, 106, 79, 9}, "17998b0a6d", 0.0f))) {
                return TlsVersion.TLS_1_0;
            }
        } else if (str.equals(C0000.decode(new byte[]{54, 54, 42, 69, 87}, "eef3d65f"))) {
            return TlsVersion.SSL_3_0;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{52, 95, 3, 76, 66, 84, 84, 18, 83, 83, 21, 98, 120, 103, 65, 71, 3, 70, 65, 88, 88, 8, 12, 23}, "a1f4217f675644", true).concat(str));
    }

    public static Component fromContext(String str, TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(Qualified.unqualified(AutoValue_LibraryVersion.class));
        for (Class cls : new Class[0]) {
            Trace.checkNotNull(cls, C0000.decode(new byte[]{40, 65, 10, 13, 25, 8, 86, 77, 85, 75, 80, 88, 5, 81}, "f4fa9a890969", 0.0f));
            hashSet.add(Qualified.unqualified(cls));
        }
        Dependency dependencyRequired = Dependency.required(Context.class);
        if (hashSet.contains(dependencyRequired.anInterface)) {
            throw new IllegalArgumentException(C0000.decode(new byte[]{115, 91, 9, 65, 87, 86, 87, 10, 67, 17, 65, 80, 66, 85, 16, 90, 11, 69, 24, 89, 94, 8, 88, 21, 4, 85, 16, 68, 95, 20, 0, 84, 72, 93, 92, 0, 23, 13, 15, 17, 89, 94, 68, 81, 22, 87, 89, 91, 87, 23, 23, 22, 9, 84, 73, 16, 68, 92, 1, 92, 75, 93, 94, 18, 82, 17, 65, 65, 66, 95, 70, 93, 0, 84, 22}, "04d1882d7ba100", true));
        }
        hashSet2.add(dependencyRequired);
        return new Component(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 1, new ComponentMonitor$$ExternalSyntheticLambda0(str, 6, transportImpl$$ExternalSyntheticLambda0), hashSet3);
    }

    public static int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static void markEnabled(Context context) {
        context.getSharedPreferences(C0000.decode(new byte[]{70, 21, 68, 87}, "5c497499dd048a", 0.0f), 0).edit().putBoolean(C0000.decode(new byte[]{66, 67, 21, 93, 110, 93, 10}, "15e312da8331", 0.0f), true).apply();
    }

    public static final void migrateDatabase(Context context) {
        Map mapSingletonMap;
        String strDecode = C0000.decode(new byte[]{87, 8, 0, 66, 11, 15, 83, 74, 26, 66, 88, 66, 93, 72, 19, 95, 22, 13, 83, 80}, "6fd0df724570");
        if (context.getDatabasePath(strDecode).exists()) {
            SystemClock systemClock = SystemClock.get();
            String[] strArr = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
            systemClock.getClass();
            File databasePath = context.getDatabasePath(strDecode);
            File file = new File(Api21Impl.INSTANCE.getNoBackupFilesDir(context), strDecode);
            String[] strArr2 = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
            int iMapCapacity = mapCapacity(strArr2.length);
            if (iMapCapacity < 16) {
                iMapCapacity = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
            for (String str : strArr2) {
                linkedHashMap.put(new File(databasePath.getPath() + str), new File(file.getPath() + str));
            }
            if (linkedHashMap.isEmpty()) {
                mapSingletonMap = Collections.singletonMap(databasePath, file);
            } else {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
                linkedHashMap2.put(databasePath, file);
                mapSingletonMap = linkedHashMap2;
            }
            for (Map.Entry entry : mapSingletonMap.entrySet()) {
                File file2 = (File) entry.getKey();
                File file3 = (File) entry.getValue();
                if (file2.exists()) {
                    if (file3.exists()) {
                        SystemClock systemClock2 = SystemClock.get();
                        String[] strArr3 = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
                        file3.toString();
                        systemClock2.getClass();
                    }
                    if (file2.renameTo(file3)) {
                        file2.toString();
                        file3.toString();
                    } else {
                        file2.toString();
                        file3.toString();
                    }
                    SystemClock systemClock3 = SystemClock.get();
                    String[] strArr4 = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
                    systemClock3.getClass();
                }
            }
        }
    }

    public static void startIfReady(Context context) {
        if (StealthVpnService.isRunning) {
            return;
        }
        try {
            if (VpnService.prepare(context) == null) {
                try {
                    context.startForegroundService(new Intent(context, (Class<?>) StealthVpnService.class));
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void toggleMask(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        long j;
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i2 = unsafeCursor.start;
            int i3 = unsafeCursor.end;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            j = unsafeCursor.offset;
            if (j == unsafeCursor.buffer.size) {
                throw new IllegalStateException(C0000.decode(new byte[]{93, 91, 25, 94, 12, 20, 92, 21, 3, 79, 71, 81, 74}, "3493cf95a6", false));
            }
        } while (unsafeCursor.seek(j == -1 ? 0L : j + ((long) (unsafeCursor.end - unsafeCursor.start))) != -1);
    }

    public static void writeBundle(Parcel parcel, int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeBundle(bundle);
        zzb(parcel, iZza);
    }

    public static void writeParcelable(Parcel parcel, int i, Parcelable parcelable, int i2) {
        if (parcelable == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        zzb(parcel, iZza);
    }

    public static void writeString(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeString(str);
        zzb(parcel, iZza);
    }

    public static void writeTypedArray(Parcel parcel, int i, Parcelable[] parcelableArr, int i2) {
        if (parcelableArr == null) {
            return;
        }
        int iZza = zza(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i2);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        zzb(parcel, iZza);
    }

    public static int zza(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void zzb(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void zzc(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    public abstract boolean casListeners(AbstractFuture abstractFuture, AbstractFuture.Listener listener, AbstractFuture.Listener listener2);

    public abstract boolean casValue(AbstractFuture abstractFuture, Object obj, Object obj2);

    public abstract boolean casWaiters(AbstractFuture abstractFuture, AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2);

    public abstract void putNext(AbstractFuture.Waiter waiter, AbstractFuture.Waiter waiter2);

    public abstract void putThread(AbstractFuture.Waiter waiter, Thread thread);
}
