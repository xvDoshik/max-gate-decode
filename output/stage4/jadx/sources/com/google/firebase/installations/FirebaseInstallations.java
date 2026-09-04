package com.google.firebase.installations;

import android.net.TrafficStats;
import android.text.TextUtils;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.room.RoomOpenHelper;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.WorkLauncherImpl;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentDiscovery$$ExternalSyntheticLambda0;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.SequentialExecutor;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse;
import com.google.firebase.installations.remote.AutoValue_TokenResult;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.RequestLimiter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import kotlin.ExceptionsKt;
import org.json.JSONException;
import org.json.JSONObject;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class FirebaseInstallations implements FirebaseInstallationsApi {
    public static final Object lockGenerateFid = new Object();
    public final ExecutorService backgroundExecutor;
    public String cachedFid;
    public final RandomFidGenerator fidGenerator;
    public final HashSet fidListeners;
    public final FirebaseApp firebaseApp;
    public final Lazy iidStore;
    public final ArrayList listeners;
    public final Object lock;
    public final SequentialExecutor networkExecutor;
    public final WorkLauncherImpl persistedInstallation;
    public final FirebaseInstallationServiceClient serviceClient;
    public final Utils utils;

    static {
        new AtomicInteger(1);
    }

    public FirebaseInstallations(FirebaseApp firebaseApp, Provider provider, ExecutorService executorService, SequentialExecutor sequentialExecutor) {
        firebaseApp.checkNotDeleted();
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = new FirebaseInstallationServiceClient(firebaseApp.applicationContext, provider);
        WorkLauncherImpl workLauncherImpl = new WorkLauncherImpl(firebaseApp);
        if (ProfileInstaller$2.singleton == null) {
            ProfileInstaller$2.singleton = new ProfileInstaller$2();
        }
        ProfileInstaller$2 profileInstaller$2 = ProfileInstaller$2.singleton;
        if (Utils.singleton == null) {
            Utils.singleton = new Utils(profileInstaller$2);
        }
        Utils utils = Utils.singleton;
        Lazy lazy = new Lazy(new ComponentDiscovery$$ExternalSyntheticLambda0(2, firebaseApp));
        RandomFidGenerator randomFidGenerator = new RandomFidGenerator();
        this.lock = new Object();
        this.fidListeners = new HashSet();
        this.listeners = new ArrayList();
        this.firebaseApp = firebaseApp;
        this.serviceClient = firebaseInstallationServiceClient;
        this.persistedInstallation = workLauncherImpl;
        this.utils = utils;
        this.iidStore = lazy;
        this.fidGenerator = randomFidGenerator;
        this.backgroundExecutor = executorService;
        this.networkExecutor = sequentialExecutor;
    }

    public final void doRegistrationOrRefresh() {
        AutoValue_PersistedInstallationEntry persistedInstallationEntryValue;
        synchronized (lockGenerateFid) {
            try {
                FirebaseApp firebaseApp = this.firebaseApp;
                firebaseApp.checkNotDeleted();
                OperationImpl operationImplAcquire = OperationImpl.acquire(firebaseApp.applicationContext);
                try {
                    persistedInstallationEntryValue = this.persistedInstallation.readPersistedInstallationEntryValue();
                    int i = persistedInstallationEntryValue.registrationStatus;
                    boolean z = true;
                    if (i != 2 && i != 1) {
                        z = false;
                    }
                    if (z) {
                        String existingIidOrCreateFid = readExistingIidOrCreateFid(persistedInstallationEntryValue);
                        WorkLauncherImpl workLauncherImpl = this.persistedInstallation;
                        AutoValue_PersistedInstallationEntry.Builder builder = persistedInstallationEntryValue.toBuilder();
                        builder.firebaseInstallationId = existingIidOrCreateFid;
                        builder.registrationStatus = 3;
                        persistedInstallationEntryValue = builder.build();
                        workLauncherImpl.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntryValue);
                    }
                    if (operationImplAcquire != null) {
                        operationImplAcquire.releaseAndClose();
                    }
                } catch (Throwable th) {
                    if (operationImplAcquire != null) {
                        operationImplAcquire.releaseAndClose();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        triggerOnStateReached(persistedInstallationEntryValue);
        this.networkExecutor.execute(new FirebaseInstallations$$ExternalSyntheticLambda1(this, 1));
    }

    public final AutoValue_PersistedInstallationEntry fetchAuthTokenFromServer(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) throws FirebaseInstallationsException {
        HttpURLConnection httpURLConnectionOpenHttpURLConnection;
        AutoValue_TokenResult generateAuthTokenResponse;
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.serviceClient;
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        String str = firebaseApp.options.apiKey;
        String str2 = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        String str3 = firebaseApp2.options.projectId;
        String str4 = autoValue_PersistedInstallationEntry.refreshToken;
        String strDecode = C0000.decode(new byte[]{116, 94, 23, 93, 80, 87, 65, 82, 69, 113, 92, 69, 70, 86, 9, 84, 83, 66, 91, 88, 11, 75, 18, 101, 87, 69, 19, 81, 81, 83, 18, 94, 22, 24, 71, 88, 83, 65, 4, 81, 94, 87, 80, 91, 0, 22, 18, 102, 94, 82, 4, 75, 87, 22, 70, 69, 28, 24, 83, 81, 83, 94, 11, 24, 94, 87, 70, 82, 23, 22}, "27e826", 0.0f);
        RequestLimiter requestLimiter = firebaseInstallationServiceClient.requestLimiter;
        if (!requestLimiter.isRequestAllowed()) {
            throw new FirebaseInstallationsException(strDecode);
        }
        URL fullyQualifiedRequestUri = FirebaseInstallationServiceClient.getFullyQualifiedRequestUri(C0000.decode(new byte[]{70, 20, 95, 89, 7, 80, 71, 64, 25}, "6f03b333") + str3 + C0000.decode(new byte[]{31, 11, 8, 67, 67, 89, 15, 92, 3, 66, 89, 13, 8, 67, 24}, "0bf078c0b6", 0.0f) + str2 + C0000.decode(new byte[]{25, 3, 20, 77, 14, 53, 95, 15, 86, 13, 74, 89, 95, 93, 88, 7, 19, 88, 18, 4}, "6ba9fa0d3c9c88"));
        int i = 0;
        while (true) {
            if (i > 1) {
                throw new FirebaseInstallationsException(strDecode);
            }
            TrafficStats.setThreadStatsTag(32771);
            httpURLConnectionOpenHttpURLConnection = firebaseInstallationServiceClient.openHttpURLConnection(fullyQualifiedRequestUri, str);
            try {
                try {
                    httpURLConnectionOpenHttpURLConnection.setRequestMethod(C0000.decode(new byte[]{54, 120, 97, 103}, "f72324fb", 3));
                    httpURLConnectionOpenHttpURLConnection.addRequestProperty(C0000.decode(new byte[]{35, 23, 18, 14, 94, 17, 12, 27, 3, 21, 11, 13, 8}, "bbff1ceaba", 4), C0000.decode(new byte[]{116, 42, 48, 107, 64, 3, 19}, "2cc4613f", false) + str4);
                    httpURLConnectionOpenHttpURLConnection.setDoOutput(true);
                    FirebaseInstallationServiceClient.writeGenerateAuthTokenRequestBodyToOutputStream(httpURLConnectionOpenHttpURLConnection);
                    int responseCode = httpURLConnectionOpenHttpURLConnection.getResponseCode();
                    requestLimiter.setNextRequestTime(responseCode);
                    if (responseCode >= 200 && responseCode < 300) {
                        generateAuthTokenResponse = FirebaseInstallationServiceClient.readGenerateAuthTokenResponse(httpURLConnectionOpenHttpURLConnection);
                        break;
                    }
                    FirebaseInstallationServiceClient.logFisCommunicationError(httpURLConnectionOpenHttpURLConnection, null, str, str3);
                    if (responseCode == 401 || responseCode == 404) {
                        RoomOpenHelper roomOpenHelperBuilder = AutoValue_TokenResult.builder();
                        roomOpenHelperBuilder.version = 3;
                        generateAuthTokenResponse = roomOpenHelperBuilder.build();
                        break;
                    }
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException(C0000.decode(new byte[]{36, 8, 69, 87, 82, 3, 67, 87, 66, 64, 7, 19, 65, 87, 66, 17, 16, 90, 3, 69, 7, 65, 69, 87, 83, 7, 89, 68, 7, 87, 66, 21, 88, 93, 16, 15, 81, 92, 27, 19, 16, 4, 70, 71, 85, 17, 68, 65, 66, 85, 16, 14, 90, 18, 68, 10, 89, 65, 66, 80, 14, 8, 82, 92, 68, 66, 89, 92, 66, 82, 66, 18, 95, 93, 66, 22, 16, 66, 7, 65, 11, 14, 83, 18, 95, 4, 16, 70, 11, 94, 7, 79, 23, 98, 92, 7, 81, 65, 7, 19, 22, 19, 78, 18, 81, 5, 81, 91, 12, 19, 14, 0, 67, 87, 66, 76}, "ba720b02b3"));
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        RoomOpenHelper roomOpenHelperBuilder2 = AutoValue_TokenResult.builder();
                        roomOpenHelperBuilder2.version = 2;
                        generateAuthTokenResponse = roomOpenHelperBuilder2.build();
                        break;
                    }
                    httpURLConnectionOpenHttpURLConnection.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i++;
                } catch (IOException | AssertionError unused) {
                }
            } catch (Throwable th) {
                httpURLConnectionOpenHttpURLConnection.disconnect();
                TrafficStats.clearThreadStatsTag();
                throw th;
            }
        }
        httpURLConnectionOpenHttpURLConnection.disconnect();
        TrafficStats.clearThreadStatsTag();
        int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(generateAuthTokenResponse.responseCode);
        if (iOrdinal == 0) {
            String str5 = generateAuthTokenResponse.token;
            long j = generateAuthTokenResponse.tokenExpirationTimestamp;
            Utils utils = this.utils;
            utils.getClass();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            utils.clock.getClass();
            long seconds = timeUnit.toSeconds(System.currentTimeMillis());
            AutoValue_PersistedInstallationEntry.Builder builder = autoValue_PersistedInstallationEntry.toBuilder();
            builder.authToken = str5;
            builder.expiresInSecs = Long.valueOf(j);
            builder.tokenCreationEpochInSecs = Long.valueOf(seconds);
            return builder.build();
        }
        if (iOrdinal == 1) {
            String strDecode2 = C0000.decode(new byte[]{39, 120, 37, 23, 119, 46, 126, 114, 44, 113}, "e9a74a04e6", true);
            AutoValue_PersistedInstallationEntry.Builder builder2 = autoValue_PersistedInstallationEntry.toBuilder();
            builder2.fisError = strDecode2;
            builder2.registrationStatus = 5;
            return builder2.build();
        }
        if (iOrdinal != 2) {
            throw new FirebaseInstallationsException(strDecode);
        }
        synchronized (this) {
            this.cachedFid = null;
        }
        AutoValue_PersistedInstallationEntry.Builder builder3 = autoValue_PersistedInstallationEntry.toBuilder();
        builder3.registrationStatus = 2;
        return builder3.build();
    }

    public final zzw getId() {
        String str;
        preConditionChecks();
        synchronized (this) {
            str = this.cachedFid;
        }
        if (str != null) {
            return ExceptionsKt.forResult(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetIdListener getIdListener = new GetIdListener(taskCompletionSource);
        synchronized (this.lock) {
            this.listeners.add(getIdListener);
        }
        zzw zzwVar = taskCompletionSource.zza;
        this.backgroundExecutor.execute(new FirebaseInstallations$$ExternalSyntheticLambda1(this, 0));
        return zzwVar;
    }

    public final zzw getToken() {
        preConditionChecks();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GetAuthTokenListener getAuthTokenListener = new GetAuthTokenListener(this.utils, taskCompletionSource);
        synchronized (this.lock) {
            this.listeners.add(getAuthTokenListener);
        }
        zzw zzwVar = taskCompletionSource.zza;
        this.backgroundExecutor.execute(new FirebaseInstallations$$ExternalSyntheticLambda1(this, 2));
        return zzwVar;
    }

    public final void preConditionChecks() {
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        String str = firebaseApp.options.applicationId;
        String strDecode = C0000.decode(new byte[]{51, 14, 93, 81, 71, 4, 23, 70, 6, 22, 24, 73, 91, 20, 69, 21, 34, 18, 72, 92, 93, 2, 86, 65, 10, 13, 86, 16, 125, 37, 25, 21, 34, 66, 78, 81, 88, 8, 83, 21, 37, 11, 74, 85, 86, 0, 68, 80, 67, 35, 72, 64, 20, 40, 115, 21, 10, 17, 24, 66, 81, 16, 66, 92, 17, 7, 92, 16, 64, 14, 23, 86, 12, 15, 85, 69, 90, 8, 84, 84, 23, 7, 24, 71, 93, 21, 95, 21, 37, 11, 74, 85, 86, 0, 68, 80, 67, 17, 93, 66, 66, 4, 69, 21, 34, 50, 113, 67, 14, 65, 126, 65, 67, 11, 92, 85, 90, 21, 94, 83, 10, 7, 75, 16, 77, 14, 66, 71, 67, 3, 72, 64, 88, 8, 84, 84, 23, 11, 87, 94, 20, 22, 94, 65, 11, 66, 126, 89, 70, 4, 85, 84, 16, 7, 22, 96, 88, 4, 86, 70, 6, 66, 74, 85, 82, 4, 69, 21, 23, 13, 24, 88, 64, 21, 71, 70, 89, 77, 23, 86, 93, 19, 82, 87, 2, 17, 93, 30, 83, 14, 88, 82, 15, 7, 22, 83, 91, 12, 24, 70, 22, 18, 72, 95, 70, 21, 24, 69, 17, 11, 78, 81, 87, 24, 24, 92, 13, 11, 76, 29, 91, 17, 67, 92, 12, 12, 75, 30}, "cb804a75", 3);
        zzag.checkNotEmpty(str, strDecode);
        firebaseApp.checkNotDeleted();
        zzag.checkNotEmpty(firebaseApp.options.projectId, C0000.decode(new byte[]{50, 95, 85, 85, 21, 3, 66, 17, 83, 71, 66, 78, 13, 70, 66, 20, 54, 20, 13, 8, 83, 80, 22, 23, 43, 119, 30, 20, 39, 70, 20, 3, 90, 90, 6, 23, 36, 90, 66, 81, 4, 7, 17, 7, 22, 99, 16, 88, 8, 86, 83, 64, 70, 47, 38, 66, 95, 64, 66, 69, 7, 66, 69, 93, 20, 3, 6, 66, 66, 92, 66, 84, 13, 94, 93, 65, 8, 15, 1, 3, 66, 86, 66, 64, 11, 71, 88, 20, 32, 15, 16, 7, 84, 82, 17, 82, 66, 64, 85, 70, 16, 3, 16, 66, 119, 99, 43, 68, 88, 19, 121, 64, 70, 15, 6, 7, 88, 71, 11, 81, 11, 86, 67, 20, 31, 9, 23, 16, 22, 82, 18, 71, 14, 90, 83, 85, 18, 15, 13, 12, 22, 68, 11, 67, 10, 19, 118, 93, 20, 3, 0, 3, 69, 86, 76, 103, 14, 86, 81, 71, 3, 70, 16, 7, 80, 86, 16, 23, 22, 92, 16, 92, 18, 18, 18, 17, 12, 28, 77, 81, 11, 65, 85, 86, 7, 21, 7, 76, 81, 92, 13, 80, 14, 86, 30, 87, 9, 11, 77, 17, 67, 67, 18, 88, 16, 71, 31, 68, 20, 15, 20, 3, 85, 74, 77, 94, 12, 90, 68, 25, 9, 22, 22, 11, 89, 93, 17, 25}, "b304ffbb63b7"));
        firebaseApp.checkNotDeleted();
        String str2 = firebaseApp.options.apiKey;
        String strDecode2 = C0000.decode(new byte[]{52, 9, 0, 88, 69, 84, 23, 64, 80, 77, 67, 3, 68, 19, 4, 85, 95, 85, 23, 114, 101, 112, 67, 9, 1, 28, 75, 25, 119, 17, 113, 90, 71, 92, 1, 3, 23, 0, 69, 120, 102, 120, 23, 88, 80, 64, 67, 11, 23, 69, 23, 92, 71, 68, 94, 65, 80, 93, 67, 22, 11, 69, 6, 86, 91, 92, 66, 93, 92, 90, 2, 22, 1, 69, 18, 80, 66, 89, 23, 117, 92, 75, 6, 0, 5, 22, 0, 25, 69, 84, 69, 69, 80, 75, 67, 35, 52, 44, 22, 3, 22, 120, 67, 19, 84, 76, 23, 10, 1, 11, 17, 80, 85, 80, 67, 86, 70, 25, 26, 13, 17, 23, 69, 73, 68, 94, 93, 86, 86, 77, 67, 21, 13, 17, 13, 25, 113, 94, 88, 84, 89, 92, 77, 50, 8, 0, 4, 74, 83, 17, 69, 86, 83, 92, 17, 66, 16, 10, 69, 81, 66, 69, 71, 64, 15, 22, 76, 4, 13, 23, 0, 91, 87, 66, 82, 29, 82, 86, 12, 5, 8, 0, 75, 90, 89, 92, 24, 64, 64, 73, 19, 13, 22, 17, 74, 73, 68, 88, 65, 82, 86, 64, 76, 11, 10, 12, 17, 20, 89, 65, 67, 90, 90, 87, 16, 76}, "dee9617359cb", 0.0f);
        zzag.checkNotEmpty(str2, strDecode2);
        firebaseApp.checkNotDeleted();
        String str3 = firebaseApp.options.applicationId;
        Pattern pattern = Utils.API_KEY_FORMAT;
        if (!str3.contains(C0000.decode(new byte[]{88}, "bb148dfb2e87", false))) {
            throw new IllegalArgumentException(strDecode);
        }
        firebaseApp.checkNotDeleted();
        if (!Utils.API_KEY_FORMAT.matcher(firebaseApp.options.apiKey).matches()) {
            throw new IllegalArgumentException(strDecode2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0067 A[Catch: all -> 0x0069, DONT_GENERATE, TRY_ENTER, TryCatch #1 {all -> 0x0069, blocks: (B:10:0x004b, B:11:0x004d, B:15:0x0067, B:19:0x006b, B:20:0x006f, B:28:0x0083, B:12:0x004e, B:13:0x0064), top: B:35:0x004b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x006b A[Catch: all -> 0x0069, TryCatch #1 {all -> 0x0069, blocks: (B:10:0x004b, B:11:0x004d, B:15:0x0067, B:19:0x006b, B:20:0x006f, B:28:0x0083, B:12:0x004e, B:13:0x0064), top: B:35:0x004b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0076  */
    /* JADX WARN: Code duplicated, block: B:25:0x0080 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x003b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0040  */
    public final String readExistingIidOrCreateFid(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        IidStore iidStore;
        String string;
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        if (!firebaseApp.name.equals(C0000.decode(new byte[]{113, 125, 127, 122, 33, 105, 36, 40, 114, 102, 125, 124, 114, 104, 55, 114, 46}, "2567d6ef64", 7))) {
            FirebaseApp firebaseApp2 = this.firebaseApp;
            String strDecode = C0000.decode(new byte[]{106, 38, 115, 119, 36, 52, 127, 99, 106}, "1b61ea3772", 7);
            firebaseApp2.checkNotDeleted();
            if (strDecode.equals(firebaseApp2.name)) {
                if (autoValue_PersistedInstallationEntry.registrationStatus == 1) {
                    iidStore = (IidStore) this.iidStore.get();
                    synchronized (iidStore.iidPrefs) {
                        try {
                            synchronized (iidStore.iidPrefs) {
                                string = iidStore.iidPrefs.getString(C0000.decode(new byte[]{73, 107, 69, 10, 81}, "589c5012aa287b42", 0.0f), null);
                            }
                            if (string != null) {
                                string = iidStore.readPublicKeyFromLocalStorageAndCalculateInstanceId();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (TextUtils.isEmpty(string)) {
                        return string;
                    }
                    this.fidGenerator.getClass();
                    return RandomFidGenerator.createRandomFid();
                }
            }
        } else if (autoValue_PersistedInstallationEntry.registrationStatus == 1) {
            iidStore = (IidStore) this.iidStore.get();
            synchronized (iidStore.iidPrefs) {
                synchronized (iidStore.iidPrefs) {
                    string = iidStore.iidPrefs.getString(C0000.decode(new byte[]{73, 107, 69, 10, 81}, "589c5012aa287b42", 0.0f), null);
                    if (string != null) {
                        string = iidStore.readPublicKeyFromLocalStorageAndCalculateInstanceId();
                    }
                    if (TextUtils.isEmpty(string)) {
                        return string;
                    }
                    this.fidGenerator.getClass();
                    return RandomFidGenerator.createRandomFid();
                }
            }
        }
        this.fidGenerator.getClass();
        return RandomFidGenerator.createRandomFid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.firebase.installations.remote.FirebaseInstallationServiceClient] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.google.firebase.installations.remote.AutoValue_InstallationResponse] */
    public final AutoValue_PersistedInstallationEntry registerFidWithServer(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) throws FirebaseInstallationsException {
        String str = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        String string = null;
        if (str != null && str.length() == 11) {
            IidStore iidStore = (IidStore) this.iidStore.get();
            synchronized (iidStore.iidPrefs) {
                try {
                    String[] strArr = IidStore.ALLOWABLE_SCOPES;
                    int i = 0;
                    while (true) {
                        if (i >= 4) {
                            break;
                        }
                        String str2 = strArr[i];
                        String string2 = iidStore.iidPrefs.getString(C0000.decode(new byte[]{74, 108, 31}, "68c92f", 4) + iidStore.defaultSenderId + C0000.decode(new byte[]{72}, "49287ed7c64b710b") + str2, null);
                        if (string2 != null && !string2.isEmpty()) {
                            if (string2.startsWith(C0000.decode(new byte[]{78}, "53daa5be16"))) {
                                try {
                                    string = new JSONObject(string2).getString(C0000.decode(new byte[]{76, 10, 9, 82, 95}, "8eb715bc", true));
                                } catch (JSONException unused) {
                                }
                            } else {
                                string = string2;
                            }
                            break;
                        }
                        i++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        FirebaseInstallationServiceClient firebaseInstallationServiceClient = this.serviceClient;
        FirebaseApp firebaseApp = this.firebaseApp;
        firebaseApp.checkNotDeleted();
        String str3 = firebaseApp.options.apiKey;
        String str4 = autoValue_PersistedInstallationEntry.firebaseInstallationId;
        FirebaseApp firebaseApp2 = this.firebaseApp;
        firebaseApp2.checkNotDeleted();
        String str5 = firebaseApp2.options.projectId;
        FirebaseApp firebaseApp3 = this.firebaseApp;
        firebaseApp3.checkNotDeleted();
        String str6 = firebaseApp3.options.applicationId;
        String strDecode = C0000.decode(new byte[]{32, 13, 23, 4, 84, 84, 66, 82, 67, 43, 8, 69, 21, 83, 10, 8, 4, 21, 95, 90, 95, 68, 67, 49, 3, 68, 23, 91, 5, 1, 69, 8, 69, 21, 68, 89, 2, 20, 7, 95, 13, 83, 4, 8, 0, 79, 22, 101, 93, 82, 2, 17, 3, 22, 21, 64, 31, 68, 4, 6, 87, 92, 95, 23, 15, 3, 18, 83, 19, 28}, "fdea6517cbf6a2", 0.0f);
        RequestLimiter requestLimiter = firebaseInstallationServiceClient.requestLimiter;
        if (!requestLimiter.isRequestAllowed()) {
            throw new FirebaseInstallationsException(strDecode);
        }
        URL fullyQualifiedRequestUri = FirebaseInstallationServiceClient.getFullyQualifiedRequestUri(C0000.decode(new byte[]{69, 19, 10, 89, 80, 91, 65, 18, 74}, "5ae358", 1) + str5 + C0000.decode(new byte[]{77, 11, 93, 69, 16, 3, 8, 92, 88, 18, 90, 91, 95, 22}, "bb36dbd09f341e42", 0.0f));
        int i2 = 0;
        AutoValue_InstallationResponse autoValue_InstallationResponse = firebaseInstallationServiceClient;
        while (i2 <= 1) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionOpenHttpURLConnection = autoValue_InstallationResponse.openHttpURLConnection(fullyQualifiedRequestUri, str3);
            try {
                try {
                    httpURLConnectionOpenHttpURLConnection.setRequestMethod(C0000.decode(new byte[]{99, 123, 103, 101}, "3441bcd1", 5));
                    httpURLConnectionOpenHttpURLConnection.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionOpenHttpURLConnection.addRequestProperty(C0000.decode(new byte[]{78, 20, 4, 93, 95, 84, 20, 87, 94, 66, 27, 88, 13, 86, 66, 92, 80, 85, 26, 88, 95, 93, 78, 95, 89, 84, 75, 80, 67, 88, 89, 87, 78, 83, 69, 71, 81}, "69c2039171", true), string);
                    }
                    FirebaseInstallationServiceClient.writeFIDCreateRequestBodyToOutputStream(httpURLConnectionOpenHttpURLConnection, str4, str6);
                    int responseCode = httpURLConnectionOpenHttpURLConnection.getResponseCode();
                    requestLimiter.setNextRequestTime(responseCode);
                    if (responseCode >= 200 && responseCode < 300) {
                        AutoValue_InstallationResponse createResponse = FirebaseInstallationServiceClient.readCreateResponse(httpURLConnectionOpenHttpURLConnection);
                        httpURLConnectionOpenHttpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        autoValue_InstallationResponse = createResponse;
                    } else {
                        try {
                            FirebaseInstallationServiceClient.logFisCommunicationError(httpURLConnectionOpenHttpURLConnection, str6, str3, str5);
                            if (responseCode == 429) {
                                throw new FirebaseInstallationsException(C0000.decode(new byte[]{118, 95, 75, 85, 90, 88, 23, 81, 24, 16, 85, 68, 79, 85, 74, 74, 68, 92, 89, 21, 85, 22, 75, 85, 91, 92, 13, 66, 93, 7, 16, 66, 86, 95, 24, 84, 5, 90, 65, 67, 66, 83, 72, 69, 93, 74, 16, 71, 24, 5, 66, 89, 84, 16, 76, 81, 13, 71, 24, 0, 92, 95, 92, 94, 76, 25, 13, 90, 24, 2, 16, 69, 81, 95, 74, 77, 68, 68, 93, 17, 89, 89, 93, 16, 87, 95, 68, 64, 81, 14, 85, 24, 25, 96, 84, 92, 5, 71, 93, 67, 68, 68, 64, 16, 89, 94, 5, 93, 86, 67, 92, 87, 77, 85, 74, 23}, "069089d48c", 0.0f));
                            }
                            if (responseCode < 500 || responseCode >= 600) {
                                AutoValue_InstallationResponse autoValue_InstallationResponse2 = new AutoValue_InstallationResponse(null, null, null, null, 2);
                                httpURLConnectionOpenHttpURLConnection.disconnect();
                                TrafficStats.clearThreadStatsTag();
                                autoValue_InstallationResponse = autoValue_InstallationResponse2;
                            } else {
                                httpURLConnectionOpenHttpURLConnection.disconnect();
                                TrafficStats.clearThreadStatsTag();
                                i2++;
                                autoValue_InstallationResponse = autoValue_InstallationResponse;
                            }
                        } catch (IOException | AssertionError unused2) {
                            httpURLConnectionOpenHttpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                        }
                        httpURLConnectionOpenHttpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        i2++;
                        autoValue_InstallationResponse = autoValue_InstallationResponse;
                    }
                    int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(autoValue_InstallationResponse.responseCode);
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            throw new FirebaseInstallationsException(C0000.decode(new byte[]{35, 94, 66, 86, 85, 2, 21, 87, 24, 122, 92, 68, 17, 86, 92, 95, 86, 23, 15, 93, 86, 64, 18, 100, 0, 69, 70, 90, 84, 6, 70, 91, 75, 19, 71, 89, 4, 65, 81, 90, 91, 2, 4, 94, 93, 29, 18, 103, 9, 82, 81, 64, 82, 67, 18, 64, 65, 19, 83, 80, 4, 94, 94, 19, 91, 2, 18, 87, 74, 29}, "e7037cf28327"));
                        }
                        String strDecode2 = C0000.decode(new byte[]{38, 34, 119, 22, 113, 127, 118, 114, 127, 117}, "dc36208462fd", 5);
                        AutoValue_PersistedInstallationEntry.Builder builder = autoValue_PersistedInstallationEntry.toBuilder();
                        builder.fisError = strDecode2;
                        builder.registrationStatus = 5;
                        return builder.build();
                    }
                    String str7 = autoValue_InstallationResponse.fid;
                    String str8 = autoValue_InstallationResponse.refreshToken;
                    Utils utils = this.utils;
                    utils.getClass();
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    utils.clock.getClass();
                    long seconds = timeUnit.toSeconds(System.currentTimeMillis());
                    AutoValue_TokenResult autoValue_TokenResult = autoValue_InstallationResponse.authToken;
                    String str9 = autoValue_TokenResult.token;
                    long j = autoValue_TokenResult.tokenExpirationTimestamp;
                    AutoValue_PersistedInstallationEntry.Builder builder2 = autoValue_PersistedInstallationEntry.toBuilder();
                    builder2.firebaseInstallationId = str7;
                    builder2.registrationStatus = 4;
                    builder2.authToken = str9;
                    builder2.refreshToken = str8;
                    builder2.expiresInSecs = Long.valueOf(j);
                    builder2.tokenCreationEpochInSecs = Long.valueOf(seconds);
                    return builder2.build();
                } catch (IOException | AssertionError unused3) {
                }
            } catch (Throwable th2) {
                httpURLConnectionOpenHttpURLConnection.disconnect();
                TrafficStats.clearThreadStatsTag();
                throw th2;
            }
        }
        throw new FirebaseInstallationsException(strDecode);
    }

    public final void triggerOnException(Exception exc) {
        synchronized (this.lock) {
            try {
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    if (((StateListener) it.next()).onException(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void triggerOnStateReached(AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntry) {
        synchronized (this.lock) {
            try {
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    if (((StateListener) it.next()).onStateReached(autoValue_PersistedInstallationEntry)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
