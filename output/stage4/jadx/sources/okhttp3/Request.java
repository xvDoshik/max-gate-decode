package okhttp3;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.arch.core.executor.ArchTaskExecutor$$ExternalSyntheticLambda0;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.room.RoomOpenHelper;
import androidx.startup.StartupException;
import androidx.tracing.Trace;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.cloudmessaging.zzq;
import com.google.android.gms.cloudmessaging.zzu;
import com.google.android.gms.cloudmessaging.zzx;
import com.google.android.gms.cloudmessaging.zzy;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Qualified;
import com.google.firebase.components.RestrictedComponentContainer$RestrictedPublisher;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.AutoValue_InstallationTokenResult;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Metadata;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.inject.Provider;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.ArrayIterator;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Huffman;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Request {
    public final /* synthetic */ int $r8$classId;
    public Object body;
    public Object headers;
    public Object lazyCacheControl;
    public Object method;
    public Object tags;
    public Object url;

    public final class Builder implements Factory, ComponentContainer {
        public Object body;
        public Object url;
        public Object tags = new LinkedHashMap();
        public Object method = C0000.decode(new byte[]{127, 112, 100}, "850e33", 0.0f);
        public Object headers = new ConnectionPool(23);

        public static Builder createInstance(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            String strDecode = C0000.decode(new byte[]{64, 10, 72, 90, 91, 59, 92, 66, 85, 74, 3, 17, 93, 10, 86, 108, 73, 17, 86, 71, 85}, "4e838d3208be", 0.0f);
            String strDecode2 = C0000.decode(new byte[]{25}, "5e161f8de93333");
            Builder builder = new Builder();
            builder.body = new ArrayDeque();
            builder.url = sharedPreferences;
            builder.method = strDecode;
            builder.headers = strDecode2;
            builder.tags = scheduledThreadPoolExecutor;
            synchronized (((ArrayDeque) builder.body)) {
                try {
                    ((ArrayDeque) builder.body).clear();
                    String string = ((SharedPreferences) builder.url).getString((String) builder.method, "");
                    if (!TextUtils.isEmpty(string) && string.contains((String) builder.headers)) {
                        String[] strArrSplit = string.split((String) builder.headers, -1);
                        int length = strArrSplit.length;
                        for (String str : strArrSplit) {
                            if (!TextUtils.isEmpty(str)) {
                                ((ArrayDeque) builder.body).add(str);
                            }
                        }
                        return builder;
                    }
                    return builder;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public Request build() {
            HttpUrl httpUrl = (HttpUrl) this.url;
            if (httpUrl == null) {
                throw new IllegalStateException(C0000.decode(new byte[]{19, 20, 89, 70, 12, 95, 68, 10, 66, 94, 10}, "ff5f1bdd72f11505"));
            }
            String str = (String) this.method;
            Headers headersBuild = ((ConnectionPool) this.headers).build();
            RoomOpenHelper roomOpenHelper = (RoomOpenHelper) this.body;
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.tags;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            return new Request(httpUrl, str, headersBuild, roomOpenHelper, linkedHashMap.isEmpty() ? EmptyMap.INSTANCE : Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap)));
        }

        @Override // javax.inject.Provider
        public Object get() {
            return new DefaultScheduler((Executor) ((Provider) this.url).get(), (MetadataBackendRegistry) ((Provider) this.method).get(), (WorkTagDao_Impl) ((zzac) this.headers).get(), (EventStore) ((Provider) this.body).get(), (SynchronizationGuard) ((Provider) this.tags).get());
        }

        @Override // com.google.firebase.components.ComponentContainer
        public Object get(Qualified qualified) {
            if (((Set) this.url).contains(qualified)) {
                return ((ComponentContainer) this.tags).get(qualified);
            }
            throw new StartupException(C0000.decode(new byte[]{121, 22, 76, 6, 15, 71, 17, 93, 86, 5, 24, 23, 13, 23, 23, 81, 73, 23, 93, 16, 22, 23, 4, 90, 24, 23, 86, 7, 7, 84, 9, 85, 74, 7, 92, 67, 6, 82, 21, 81, 86, 6, 93, 13, 1, 78, 69}, "8b8cb7e4", 0.0f) + qualified + C0000.decode(new byte[]{29}, "3e08e022", 1));
        }

        @Override // com.google.firebase.components.ComponentContainer
        public Object get(Class cls) {
            if (!((Set) this.url).contains(Qualified.unqualified(cls))) {
                throw new StartupException(C0000.decode(new byte[]{114, 68, 16, 86, 88, 20, 22, 90, 93, 87, 68, 71, 90, 68, 16, 86, 66, 69, 1, 64, 65, 68, 3, 93, 19, 69, 10, 87, 80, 7, 14, 82, 65, 85, 0, 19, 81, 1, 18, 86, 93, 84, 1, 93, 86, 29, 66}, "30d35db3", 0.0f) + cls + C0000.decode(new byte[]{77}, "c28e736fd3", 0));
            }
            Object obj = ((ComponentContainer) this.tags).get(cls);
            if (!cls.equals(Publisher.class)) {
                return obj;
            }
            return new RestrictedComponentContainer$RestrictedPublisher();
        }

        @Override // com.google.firebase.components.ComponentContainer
        public com.google.firebase.inject.Provider getProvider(Qualified qualified) {
            if (((Set) this.method).contains(qualified)) {
                return ((ComponentContainer) this.tags).getProvider(qualified);
            }
            throw new StartupException(C0000.decode(new byte[]{35, 76, 23, 85, 9, 69, 68, 81, 13, 85, 18, 18, 13, 24, 17, 85, 21, 64, 85, 75, 23, 18, 83, 8, 66, 77, 13, 84, 1, 86, 92, 89, 17, 87, 86, 70, 6, 93, 19, 85, 10, 81, 85, 86, 0, 75, 18, 54, 16, 87, 21, 89, 0, 80, 66, 4}, "b8c0d508c22f", 0.0f) + qualified + C0000.decode(new byte[]{14, 79}, "0a3b218381b8", 0.0f));
        }

        @Override // com.google.firebase.components.ComponentContainer
        public com.google.firebase.inject.Provider getProvider(Class cls) {
            return getProvider(Qualified.unqualified(cls));
        }

        public void header(String str, String str2) {
            ((ConnectionPool) this.headers).set(str, str2);
        }

        public void method(String str, RoomOpenHelper roomOpenHelper) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{14, 82, 64, 89, 93, 87, 24, 88, 16, 114, 89, 65, 70, 74, 30, 24, 67, 10, 9, 17, 70, 65, 67, 84}, "c7412361", true));
            }
            String strDecode = C0000.decode(new byte[]{9, 81, 69, 88, 90, 83, 66}, "d41057b788ab92", 0.0f);
            if (roomOpenHelper == null) {
                if (str.equals(C0000.decode(new byte[]{54, 41, 103, 49}, "ff4e62b7171bd30e")) || str.equals(C0000.decode(new byte[]{98, 51, 55}, "2fccea8655ab667c", false)) || str.equals(C0000.decode(new byte[]{102, 35, 53, 32, 42}, "6bacbf", true)) || str.equals(C0000.decode(new byte[]{101, 98, 45, 105, 103, 121, 108, 114, 127}, "50b9788175", false)) || str.equals(C0000.decode(new byte[]{106, 38, 105, 126, 96, 54}, "8c912b17", 1))) {
                    throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(strDecode, str, C0000.decode(new byte[]{16, 88, 16, 18, 18, 66, 88, 84, 19, 4, 70, 3, 16, 71, 0, 16, 19, 7, 67, 65, 69, 3, 9, 6, 73, 27}, "05eafb", 0.0f)).toString());
                }
            } else if (!Trace.permitsRequestBody(str)) {
                throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(strDecode, str, C0000.decode(new byte[]{66, 14, 70, 66, 64, 20, 92, 11, 22, 67, 91, 80, 66, 81, 18, 5, 66, 17, 86, 64, 65, 81, 65, 16, 66, 1, 92, 85, 77, 26}, "bc31442d", 0.0f)).toString());
            }
            this.method = str;
            this.body = roomOpenHelper;
        }

        public void removeHeader(String str) {
            ((ConnectionPool) this.headers).removeAll(str);
        }

        @Override // com.google.firebase.components.ComponentContainer
        public Set setOf(Qualified qualified) {
            if (((Set) this.headers).contains(qualified)) {
                return ((ComponentContainer) this.tags).setOf(qualified);
            }
            throw new StartupException(C0000.decode(new byte[]{116, 22, 69, 80, 8, 73, 64, 81, 91, 5, 17, 65, 10, 25, 70, 93, 68, 23, 84, 70, 17, 25, 85, 86, 21, 23, 95, 81, 0, 90, 88, 89, 71, 7, 85, 21, 1, 92, 68, 93, 91, 6, 84, 91, 6, 64, 20, 107, 80, 22, 13}, "5b15e948") + qualified + C0000.decode(new byte[]{14, 22}, "08e26cc84ea075c2", false));
        }

        @Override // com.google.firebase.components.ComponentContainer
        public com.google.firebase.inject.Provider setOfProvider(Qualified qualified) {
            if (((Set) this.body).contains(qualified)) {
                return ((ComponentContainer) this.tags).setOfProvider(qualified);
            }
            throw new StartupException(C0000.decode(new byte[]{118, 70, 77, 1, 95, 69, 17, 92, 15, 1, 23, 70, 86, 68, 64, 80, 20, 64, 4, 21, 67, 18, 88, 10, 18, 64, 11, 81, 4, 5, 91, 83, 75, 1, 86, 21, 1, 80, 17, 3, 89, 86, 92, 10, 81, 76, 69, 101, 19, 9, 65, 91, 93, 1, 64, 9, 54, 80, 21, 90}, "729d25e5af", 5) + qualified + C0000.decode(new byte[]{93, 12, 22}, "c2871e35edc2", 0.0f));
        }

        public void url(String str) {
            String strConcat;
            if (str.regionMatches(true, 0, C0000.decode(new byte[]{21, 67, 14}, "b0455e181ea422"), 0, 3)) {
                strConcat = C0000.decode(new byte[]{94, 23, 21, 19, 9}, "6cac36").concat(str.substring(3));
            } else if (str.regionMatches(true, 0, C0000.decode(new byte[]{21, 74, 74, 9}, "b993a1f69b3a18"), 0, 4)) {
                strConcat = C0000.decode(new byte[]{12, 68, 18, 18, 67, 95}, "d0fb0e2e").concat(str.substring(4));
            } else {
                strConcat = str;
            }
            HttpUrl.Builder builder = new HttpUrl.Builder();
            builder.parse$okhttp(null, strConcat);
            this.url = builder.build();
        }
    }

    public /* synthetic */ Request() {
        this.$r8$classId = 1;
    }

    public void addMetadata(String str, String str2) {
        HashMap map = (HashMap) this.lazyCacheControl;
        if (map == null) {
            throw new IllegalStateException(C0000.decode(new byte[]{100, 70, 93, 22, 86, 17, 70, 73, 66, 70, 83, 71, 21, 91, 121, 81, 70, 7, 87, 2, 70, 81, 64, 68, 90, 83, 18, 20, 90, 91, 70, 70, 81, 6, 87, 94, 66, 23, 87, 70}, "442f3c20bd22a4"));
        }
        map.put(str, str2);
    }

    public AutoValue_EventInternal build() {
        String strDecode = ((String) this.method) == null ? C0000.decode(new byte[]{69, 70, 75, 84, 15, 70, 69, 10, 23, 64, 120, 81, 8, 87}, "e295a55ee460", true) : "";
        if (((EncodedPayload) this.headers) == null) {
            strDecode = strDecode.concat(C0000.decode(new byte[]{18, 81, 11, 1, 89, 87, 87, 80, 53, 3, 79, 95, 93, 85, 1}, "24eb63"));
        }
        if (((Long) this.body) == null) {
            strDecode = strDecode + C0000.decode(new byte[]{20, 6, 67, 80, 91, 77, 124, 94, 90, 92, 15, 23}, "4c55591760fdcc", 7);
        }
        if (((Long) this.tags) == null) {
            strDecode = strDecode + C0000.decode(new byte[]{17, 19, 20, 66, 93, 90, 84, 43, 13, 90, 88, 94, 66}, "1fd647", 0.0f);
        }
        if (((HashMap) this.lazyCacheControl) == null) {
            strDecode = strDecode + C0000.decode(new byte[]{25, 88, 69, 18, 90, 127, 92, 77, 81, 2, 84, 70, 88}, "990f52", 0.0f);
        }
        if (strDecode.isEmpty()) {
            return new AutoValue_EventInternal((String) this.method, (Integer) this.url, (EncodedPayload) this.headers, ((Long) this.body).longValue(), ((Long) this.tags).longValue(), (HashMap) this.lazyCacheControl);
        }
        throw new IllegalStateException(C0000.decode(new byte[]{117, 8, 17, 69, 15, 93, 84, 22, 20, 1, 73, 20, 11, 68, 3, 87, 19, 70, 20, 11, 72, 4, 16, 66, 15, 86, 64, 12}, "8ab6f336fd", 0).concat(strDecode));
    }

    public zzw extractResponseWhenComplete(zzw zzwVar) {
        return zzwVar.continueWith(new ArchTaskExecutor$$ExternalSyntheticLambda0(1), new TransportImpl$$ExternalSyntheticLambda0(this));
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.tags = new LinkedHashMap();
        builder.url = (HttpUrl) this.url;
        builder.method = (String) this.method;
        builder.body = (RoomOpenHelper) this.body;
        Map map = (Map) this.tags;
        builder.tags = map.isEmpty() ? new LinkedHashMap() : new LinkedHashMap(map);
        builder.headers = ((Headers) this.headers).newBuilder();
        return builder;
    }

    public void setDefaultAttributesToBundle(String str, String str2, Bundle bundle) {
        int i;
        String str3;
        String strDecode;
        boolean zShouldSendSdkHeartBeat;
        int i2;
        PackageInfo packageInfo;
        bundle.putString(C0000.decode(new byte[]{66, 86, 90, 64, 81}, "1550403cb718b6", 0.0f), str2);
        bundle.putString(C0000.decode(new byte[]{66, 3, 92, 92, 4, 64}, "1f28a2f28fa4", 3), str);
        bundle.putString(C0000.decode(new byte[]{68, 22, 83, 65, 29, 67, 0}, "7c15d3ea97e14c"), str);
        String strDecode2 = C0000.decode(new byte[]{95, 91, 18, 109, 2, 22, 20, 107, 90, 86}, "86b2cfd432", 1);
        FirebaseApp firebaseApp = (FirebaseApp) this.url;
        firebaseApp.checkNotDeleted();
        bundle.putString(strDecode2, firebaseApp.options.applicationId);
        String strDecode3 = C0000.decode(new byte[]{83, 9, 65, 70}, "4d206f", false);
        Metadata metadata = (Metadata) this.method;
        synchronized (metadata) {
            try {
                if (metadata.gmsVersionCode == 0) {
                    try {
                        packageInfo = metadata.context.getPackageManager().getPackageInfo(C0000.decode(new byte[]{0, 14, 94, 77, 5, 95, 13, 3, 88, 0, 77, 0, 93, 7, 16, 95, 11, 0, 26, 2, 14, 18}, "ca3cb0bd4e", 0.0f), 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.toString();
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        metadata.gmsVersionCode = packageInfo.versionCode;
                    }
                }
                i = metadata.gmsVersionCode;
            } catch (Throwable th) {
                throw th;
            }
        }
        bundle.putString(strDecode3, Integer.toString(i));
        bundle.putString(C0000.decode(new byte[]{12, 75, 66}, "c840c78793ba4ff3", 0.0f), Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString(C0000.decode(new byte[]{89, 65, 17, 58, 71, 85, 16}, "81ae10b127", true), ((Metadata) this.method).getAppVersionCode());
        String strDecode4 = C0000.decode(new byte[]{83, 66, 67, 111, 16, 93, 70, 105, 90, 86, 94, 4}, "2230f846473a", 5);
        Metadata metadata2 = (Metadata) this.method;
        synchronized (metadata2) {
            try {
                if (metadata2.appVersionName == null) {
                    metadata2.populateAppVersionInfo();
                }
                str3 = metadata2.appVersionName;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bundle.putString(strDecode4, str3);
        String strDecode5 = C0000.decode(new byte[]{95, 11, 22, 86, 0, 85, 64, 0, 20, 3, 20, 67, 79, 90, 82, 8, 92, 79, 12, 82, 17, 92}, "9bd3b43e", 2);
        FirebaseApp firebaseApp2 = (FirebaseApp) this.url;
        firebaseApp2.checkNotDeleted();
        try {
            strDecode = Base64.encodeToString(MessageDigest.getInstance(C0000.decode(new byte[]{55, 124, 119, 26, 82}, "d467c72a10e7aa")).digest(firebaseApp2.name.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            strDecode = C0000.decode(new byte[]{108, 42, 115, 107, 125, 72, 116, 100, 49, 119, 54, 59}, "7b285e16c8dfd4be");
        }
        bundle.putString(strDecode5, strDecode);
        try {
            String str4 = ((AutoValue_InstallationTokenResult) ExceptionsKt.await(((FirebaseInstallations) ((FirebaseInstallationsApi) this.lazyCacheControl)).getToken())).token;
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString(C0000.decode(new byte[]{126, 90, 87, 6, 72, 112, 11, 19, 3, 0, 89, 64, 82, 78, 122, 90, 74, 65, 89, 13, 9, 87, 22, 8, 9, 12, 75, 30, 118, 22, 71, 92}, "958ae6bafb837c34", true), str4);
            }
        } catch (InterruptedException | ExecutionException unused2) {
        }
        bundle.putString(C0000.decode(new byte[]{80, 65, 72, 80, 86}, "11892fe6", false), (String) ExceptionsKt.await(((FirebaseInstallations) ((FirebaseInstallationsApi) this.lazyCacheControl)).getId()));
        bundle.putString(C0000.decode(new byte[]{85, 91, 94, 66}, "67746c", 0.0f), C0000.decode(new byte[]{82, 90, 14, 21, 2, 6, 26, 13, 77, 9}, "49c805", true));
        HeartBeatInfo heartBeatInfo = (HeartBeatInfo) ((com.google.firebase.inject.Provider) this.tags).get();
        DefaultUserAgentPublisher defaultUserAgentPublisher = (DefaultUserAgentPublisher) ((com.google.firebase.inject.Provider) this.body).get();
        if (heartBeatInfo == null || defaultUserAgentPublisher == null) {
            return;
        }
        DefaultHeartBeatController defaultHeartBeatController = (DefaultHeartBeatController) heartBeatInfo;
        synchronized (defaultHeartBeatController) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Store store = (Store) defaultHeartBeatController.storageProvider.get();
            synchronized (store) {
                zShouldSendSdkHeartBeat = store.shouldSendSdkHeartBeat(jCurrentTimeMillis);
            }
            if (zShouldSendSdkHeartBeat) {
                synchronized (store) {
                    String formattedDate = store.getFormattedDate(System.currentTimeMillis());
                    store.store.edit().putString(C0000.decode(new byte[]{84, 82, 16, 65, 76, 64, 75, 86, 7, 24, 5, 84, 76, 86}, "83c5a5"), formattedDate).commit();
                    store.removeStoredDate(formattedDate);
                }
                i2 = 3;
            } else {
                i2 = 1;
            }
        }
        if (i2 != 1) {
            bundle.putString(C0000.decode(new byte[]{34, 8, 22, 84, 84, 5, 71, 86, 29, 122, 8, 8, 1, 95, 66, 73, 120, 92, 87, 20, 48, 24, 20, 84}, "dad16d4309", true), Integer.toString(FileSectionType$EnumUnboxingLocalUtility.ordinal(i2)));
            bundle.putString(C0000.decode(new byte[]{116, 92, 68, 85, 3, 84, 21, 1, 24, 118, 94, 92, 83, 94, 21}, "2560a5fd55", 0.0f), defaultUserAgentPublisher.getUserAgent());
        }
    }

    public zzw startRpc(String str, String str2, Bundle bundle) {
        int i;
        try {
            setDefaultAttributesToBundle(str, str2, bundle);
            Rpc rpc = (Rpc) this.headers;
            zzy zzyVar = zzy.zza;
            Huffman.Node node = rpc.zzg;
            if (node.zza() >= 12000000) {
                zzu zzuVarZzb = zzu.zzb(rpc.zzf);
                synchronized (zzuVarZzb) {
                    i = zzuVarZzb.zze;
                    zzuVarZzb.zze = i + 1;
                }
                return zzuVarZzb.zzg(new zzq(i, 1, bundle, 1)).continueWith(zzyVar, zzx.zza$1);
            }
            if (node.zzb() != 0) {
                return rpc.zze(bundle).continueWithTask(zzyVar, new WorkLauncherImpl(rpc, bundle));
            }
            IOException iOException = new IOException(C0000.decode(new byte[]{125, 127, 50, 100, 42, 47, 38, 109, 113, 121, 101, 97, 113, 120, 34, 114, 42, 37, 62, 97, 125, 101, 96, 124, 115, 115}, "06a7caa28765", true));
            zzw zzwVar = new zzw();
            zzwVar.zza(iOException);
            return zzwVar;
        } catch (InterruptedException | ExecutionException e) {
            zzw zzwVar2 = new zzw();
            zzwVar2.zza(e);
            return zzwVar2;
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                Map map = (Map) this.tags;
                StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{52, 84, 72, 68, 83, 65, 23, 75, 95, 1, 76, 93, 89, 0, 11}, "f19162c02d856d64", 0.0f));
                sb.append((String) this.method);
                sb.append(C0000.decode(new byte[]{74, 18, 66, 75, 91, 14}, "f27973", 0.0f));
                sb.append((HttpUrl) this.url);
                Headers headers = (Headers) this.headers;
                if (headers.size() != 0) {
                    sb.append(C0000.decode(new byte[]{78, 69, 11, 82, 0, 5, 0, 69, 67, 4, 57}, "bec7aae709", 2));
                    Iterator it = headers.iterator();
                    int i = 0;
                    while (true) {
                        ArrayIterator arrayIterator = (ArrayIterator) it;
                        if (arrayIterator.hasNext()) {
                            Object next = arrayIterator.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                throw new ArithmeticException(C0000.decode(new byte[]{45, 13, 81, 86, 79, 24, 95, 78, 86, 75, 0, 89, 91, 65, 67, 89, 5, 16, 21, 91, 86, 72, 64, 93, 93, 92, 2, 27}, "dc53780839f546c1", 0.0f));
                            }
                            Pair pair = (Pair) next;
                            String str = (String) pair.first;
                            String str2 = (String) pair.second;
                            if (i > 0) {
                                sb.append(C0000.decode(new byte[]{26, 17}, "61e317"));
                            }
                            sb.append(str);
                            sb.append(':');
                            sb.append(str2);
                            i = i2;
                        } else {
                            sb.append(']');
                        }
                    }
                }
                if (!map.isEmpty()) {
                    sb.append(C0000.decode(new byte[]{28, 16, 76, 82, 2, 21, 13}, "0083ef"));
                    sb.append(map);
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public Request(HttpUrl httpUrl, String str, Headers headers, RoomOpenHelper roomOpenHelper, Map map) {
        this.$r8$classId = 0;
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = roomOpenHelper;
        this.tags = map;
    }

    public Request(FirebaseApp firebaseApp, Metadata metadata, com.google.firebase.inject.Provider provider, com.google.firebase.inject.Provider provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.$r8$classId = 2;
        firebaseApp.checkNotDeleted();
        Rpc rpc = new Rpc(firebaseApp.applicationContext);
        this.url = firebaseApp;
        this.method = metadata;
        this.headers = rpc;
        this.body = provider;
        this.tags = provider2;
        this.lazyCacheControl = firebaseInstallationsApi;
    }

    public Request(TaskRunner taskRunner) {
        this.$r8$classId = 3;
        this.url = taskRunner;
        this.lazyCacheControl = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
    }
}
