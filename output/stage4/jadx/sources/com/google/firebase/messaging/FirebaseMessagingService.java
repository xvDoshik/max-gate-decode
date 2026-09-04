package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.AutoValue_ProductData;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportFactoryImpl;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.android.gms.cloudmessaging.zzq;
import com.google.android.gms.cloudmessaging.zzs;
import com.google.android.gms.cloudmessaging.zzu;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ExceptionsKt;
import kotlin.text.CharsKt;
import okhttp3.ConnectionPool;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class FirebaseMessagingService extends EnhancedIntentService {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = C0000.decode(new byte[]{0, 93, 15, 72, 82, 91, 12, 85, 14, 3, 27, 82, 10, 64, 7, 4, 84, 71, 6, 28, 15, 3, 70, 71, 2, 85, 11, 8, 82, 26, 49, 119, 33, 35, 124, 98, 38, 109, 38, 47, 103, 113, 32, 102, 61, 36, 122, 123, 55}, "c2bf54", 5);
    static final String ACTION_NEW_TOKEN = C0000.decode(new byte[]{5, 90, 89, 25, 4, 94, 94, 81, 10, 80, 26, 81, 10, 67, 84, 84, 7, 70, 81, 25, 14, 84, 66, 69, 7, 82, 93, 89, 4, 31, 127, 115, 49, 106, 96, 120, 40, 116, 127}, "f547c116");
    static final String ACTION_REMOTE_INTENT = C0000.decode(new byte[]{7, 10, 89, 23, 81, 86, 14, 81, 8, 0, 26, 88, 88, 93, 19, 89, 13, 1, 26, 90, 4, 93, 12, 24, 13, 11, 64, 92, 88, 77, 79, 100, 33, 38, 113, 112, 96, 124}, "de4969a6", 1);
    static final String EXTRA_TOKEN = C0000.decode(new byte[]{17, 92, 92, 85, 88}, "e3706e45ba", 0.0f);
    private static final int RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE = 10;
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE);
    private Rpc rpc;

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (queue.contains(str)) {
            return true;
        }
        if (queue.size() >= RECENTLY_RECEIVED_MESSAGE_IDS_MAX_SIZE) {
            queue.remove();
        }
        queue.add(str);
        return false;
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove(C0000.decode(new byte[]{83, 94, 5, 22, 93, 8, 83, 30, 25, 85, 86, 95, 70, 85, 15, 16, 28, 22, 86, 13, 82, 90, 86, 82, 89, 89, 5}, "20ad2a7f7691", true));
        if (ConnectionPool.isNotification(extras)) {
            ConnectionPool connectionPool = new ConnectionPool(extras);
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory(C0000.decode(new byte[]{39, 12, 67, 93, 6, 80, 69, 0, 30, 44, 86, 17, 18, 4, 86, 81, 10, 86, 27, 43, 86, 21, 68, 13, 19, 14, 28, 113, 11}, "ae18d16e3a3b")));
            try {
                if (new zzac(this, connectionPool, executorServiceNewSingleThreadExecutor).handleNotification()) {
                    executorServiceNewSingleThreadExecutor.shutdown();
                    return;
                } else {
                    executorServiceNewSingleThreadExecutor.shutdown();
                    if (CharsKt.shouldUploadScionMetrics(intent)) {
                        CharsKt.logToScion(C0000.decode(new byte[]{105, 91, 3}, "65ec74d7c663", false), intent.getExtras());
                    }
                }
            } catch (Throwable th) {
                executorServiceNewSingleThreadExecutor.shutdown();
                throw th;
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra(C0000.decode(new byte[]{4, 91, 95, 82, 14, 87, 24, 84, 84, 66, 16, 85, 87, 80, 61, 91, 82}, "c405b26911", 0.0f));
        return stringExtra == null ? intent.getStringExtra(C0000.decode(new byte[]{92, 0, 69, 69, 81, 95, 84, 58, 95, 82}, "1e6608", false)) : stringExtra;
    }

    private Rpc getRpc(Context context) {
        if (this.rpc == null) {
            this.rpc = new Rpc(context.getApplicationContext());
        }
        return this.rpc;
    }

    private void handleMessageIntent(Intent intent) {
        int i;
        String strDecode = C0000.decode(new byte[]{82, 14, 94, 3, 95, 4, 27, 17, 67, 11, 87, 20, 86, 21, 110, 13, 87}, "5a1d3a");
        String strDecode2 = C0000.decode(new byte[]{2, 13, 14, 94, 8, 86, 75, 95, 3, 65, 70, 0, 95, 93, 58, 11, 5}, "eba9d3e2f25a88", 6);
        if (!alreadyReceivedMessage(intent.getStringExtra(strDecode2))) {
            passMessageIntentToSdk(intent);
        }
        Rpc rpc = getRpc(this);
        if (rpc.zzg.zza() < 233700000) {
            new zzw().zza(new IOException(C0000.decode(new byte[]{102, 117, 52, 96, 124, 33, 36, 103, 124, 121, 102, 57, 37, 100, 116, 121, 42, 119, 119, 46, 36}, "50f65ba8262fd2", false)));
            return;
        }
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra(strDecode2);
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra(C0000.decode(new byte[]{9, 4, 16, 70, 84, 85, 86, 107, 90, 0}, "dac552343d", 0.0f));
        }
        bundle.putString(strDecode2, stringExtra);
        Integer numValueOf = intent.hasExtra(strDecode) ? Integer.valueOf(intent.getIntExtra(strDecode, 0)) : null;
        if (numValueOf != null) {
            bundle.putInt(strDecode, numValueOf.intValue());
        }
        zzu zzuVarZzb = zzu.zzb(rpc.zzf);
        synchronized (zzuVarZzb) {
            i = zzuVarZzb.zze;
            zzuVarZzb.zze = i + 1;
        }
        zzuVarZzb.zzg(new zzq(i, 3, bundle, 0));
    }

    /* JADX WARN: Code duplicated, block: B:116:0x033b  */
    /* JADX WARN: Code duplicated, block: B:118:0x035c A[Catch: NumberFormatException -> 0x037f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {NumberFormatException -> 0x037f, blocks: (B:118:0x035c, B:126:0x038a), top: B:156:0x035a }] */
    /* JADX WARN: Code duplicated, block: B:120:0x0361  */
    /* JADX WARN: Code duplicated, block: B:123:0x0381  */
    /* JADX WARN: Code duplicated, block: B:126:0x038a A[Catch: NumberFormatException -> 0x037f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {NumberFormatException -> 0x037f, blocks: (B:118:0x035c, B:126:0x038a), top: B:156:0x035a }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0336 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x012c  */
    private void passMessageIntentToSdk(Intent intent) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        boolean z;
        TransportFactory transportFactory;
        long j;
        FirebaseApp firebaseApp;
        FirebaseOptions firebaseOptions;
        String str;
        String str2;
        String[] strArrSplit;
        String str3;
        String stringExtra = intent.getStringExtra(C0000.decode(new byte[]{90, 4, 71, 17, 88, 4, 92, 106, 70, 26, 65, 84}, "7a4b9c952c118176"));
        String strDecode = C0000.decode(new byte[]{80, 90, 8}, "79e54d39");
        if (stringExtra == null) {
            stringExtra = strDecode;
        }
        int iIntValue = 0;
        byte b = -1;
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals(C0000.decode(new byte[]{84, 1, 8, 1, 69, 86, 7, 107, 88, 86, 67, 23, 5, 3, 84, 64}, "0ddd13c453", true))) {
                    b = 0;
                }
                break;
            case 102161:
                if (stringExtra.equals(strDecode)) {
                    b = 1;
                }
                break;
            case 814694033:
                if (stringExtra.equals(C0000.decode(new byte[]{17, 86, 11, 5, 108, 84, 19, 64, 10, 16}, "b3ea31a2eb4c"))) {
                    b = 2;
                }
                break;
            case 814800675:
                if (stringExtra.equals(C0000.decode(new byte[]{21, 0, 93, 82, 109, 84, 16, 0, 93, 66}, "fe3621", 0.0f))) {
                    b = 3;
                }
                break;
        }
        String strDecode2 = C0000.decode(new byte[]{95, 89, 93, 3, 93, 84, 31, 90, 93, 69, 65, 5, 86, 84, 110, 94, 92}, "862d1117");
        switch (b) {
            case 0:
                onDeletedMessages();
                return;
            case 1:
                if (CharsKt.shouldUploadScionMetrics(intent)) {
                    CharsKt.logToScion(C0000.decode(new byte[]{110, 89, 66}, "170f9a", 0.0f), intent.getExtras());
                }
                if (C0000.decode(new byte[]{87, 92, 8, 29, 86, 92, 94, 5, 94, 82, 30, 81, 93, 65, 0, 81, 80, 64, 84, 76, 95, 82, 67, 68, 85, 84, 12, 93, 86, 29, 99, 39, 113, 114, 121, 97, 113, 108, 33, 122, 99, 118, 114, 54, 109, 117, 127, 120, 96}, "43e3131b2707").equals(intent.getAction())) {
                    z = false;
                } else {
                    String strDecode3 = C0000.decode(new byte[]{5, 6, 89, 95, 69, 86, 71, 24, 108, 11, 4, 23, 71, 95, 80, 64, 106, 4, 75, 22, 14, 17, 65, 83, 87, 108, 65, 14, 108, 4, 8, 4, 106, 71, 70, 86, 71, 24, 108, 3, 15, 2, 87, 90, 86, 87}, "ac56335a3f", true);
                    try {
                        FirebaseApp.getInstance();
                        FirebaseApp firebaseApp2 = FirebaseApp.getInstance();
                        firebaseApp2.checkNotDeleted();
                        Context context = firebaseApp2.applicationContext;
                        SharedPreferences sharedPreferences = context.getSharedPreferences(C0000.decode(new byte[]{84, 14, 88, 77, 83, 88, 10, 80, 9, 3, 29, 84, 81, 22, 82, 3, 84, 16, 81, 25, 8, 82, 22, 21, 82, 85, 81, 10, 80}, "7a5c47e7ef328d", 3), 0);
                        String strDecode4 = C0000.decode(new byte[]{6, 30, 19, 87, 17, 76, 103, 64, 12, 57, 1, 81, 4, 103, 73, 65, 6, 20, 26}, "cfc8c884", true);
                        if (sharedPreferences.contains(strDecode4)) {
                            z = sharedPreferences.getBoolean(strDecode4, false);
                        } else {
                            PackageManager packageManager = context.getPackageManager();
                            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(strDecode3)) {
                                z = false;
                            } else {
                                z = applicationInfo.metaData.getBoolean(strDecode3, false);
                            }
                        }
                    } catch (PackageManager.NameNotFoundException | IllegalStateException unused) {
                    }
                }
                if (z && (transportFactory = FirebaseMessaging.transportFactory) != null) {
                    Bundle extras = intent.getExtras();
                    if (extras == null) {
                        extras = Bundle.EMPTY;
                    }
                    Object obj = extras.get(C0000.decode(new byte[]{5, 11, 9, 84, 92, 83, 29, 66, 67, 15}, "bdf306367c4986"));
                    if (obj instanceof Integer) {
                        iIntValue = ((Integer) obj).intValue();
                    } else if (obj instanceof String) {
                        try {
                            iIntValue = Integer.parseInt((String) obj);
                            break;
                        } catch (NumberFormatException unused2) {
                        }
                    }
                    int i = iIntValue;
                    String string = extras.getString(C0000.decode(new byte[]{87, 90, 87, 2, 95, 3, 76, 22, 13}, "058e3fbbbfc2fddb"));
                    if (TextUtils.isEmpty(string)) {
                        try {
                            FirebaseApp firebaseApp3 = FirebaseApp.getInstance();
                            Object obj2 = FirebaseInstallations.lockGenerateFid;
                            firebaseApp3.checkNotDeleted();
                            string = (String) ExceptionsKt.await(((FirebaseInstallations) firebaseApp3.componentRuntime.get(FirebaseInstallationsApi.class)).getId());
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    String str4 = string;
                    FirebaseApp firebaseApp4 = FirebaseApp.getInstance();
                    firebaseApp4.checkNotDeleted();
                    String packageName = firebaseApp4.applicationContext.getPackageName();
                    MessagingClientEvent.MessageType messageType = ConnectionPool.isNotification(extras) ? MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION : MessagingClientEvent.MessageType.DATA_MESSAGE;
                    String string2 = extras.getString(strDecode2);
                    if (string2 == null) {
                        string2 = extras.getString(C0000.decode(new byte[]{12, 80, 17, 69, 87, 1, 83, 104, 80, 2}, "a5b66f679f"));
                    }
                    String str5 = string2 != null ? string2 : "";
                    String string3 = extras.getString(C0000.decode(new byte[]{80, 68, 87, 94}, "66837066b0e3", true));
                    if (string3 == null || !string3.startsWith(C0000.decode(new byte[]{75, 17, 14, 17, 15, 91, 23, 74}, "deaaf8"))) {
                        string3 = null;
                    }
                    String str6 = string3 != null ? string3 : "";
                    String string4 = extras.getString(C0000.decode(new byte[]{83, 86, 14, 90, 2, 66, 67, 92, 103, 83, 82, 79}, "09b6c2098876b1", 3));
                    String str7 = string4 != null ? string4 : "";
                    String string5 = extras.getString(C0000.decode(new byte[]{84, 94, 92, 95, 94, 85, 23, 91, 29, 80, 29, 85, 109, 92}, "31382098", 3));
                    String str8 = string5 != null ? string5 : "";
                    String string6 = extras.getString(C0000.decode(new byte[]{94, 91, 92, 1, 9, 82, 23, 87, 29, 7, 75, 84, 102, 88}, "943fe7", 1));
                    String str9 = string6 != null ? string6 : "";
                    String strDecode5 = C0000.decode(new byte[]{3, 90, 89, 82, 89, 87, 74, 83, 74, 70, 83, 91, 81, 87, 22, 30, 13, 81}, "d56552d0", false);
                    if (!extras.containsKey(strDecode5)) {
                        firebaseApp = FirebaseApp.getInstance();
                        firebaseOptions = firebaseApp.options;
                        firebaseApp.checkNotDeleted();
                        str = firebaseOptions.gcmSenderId;
                        if (str != null) {
                            firebaseApp.checkNotDeleted();
                            str2 = firebaseOptions.applicationId;
                            if (str2.startsWith(C0000.decode(new byte[]{87, 15}, "f568db", 2))) {
                                strArrSplit = str2.split(C0000.decode(new byte[]{14}, "458988cd9b", true));
                                if (strArrSplit.length >= 2) {
                                    str3 = strArrSplit[1];
                                    if (!str3.isEmpty()) {
                                        j = Long.parseLong(str3);
                                    }
                                }
                                j = 0;
                            } else {
                                j = Long.parseLong(str2);
                            }
                        } else {
                            j = Long.parseLong(str);
                        }
                        break;
                    } else {
                        try {
                            j = Long.parseLong(extras.getString(strDecode5));
                            break;
                        } catch (NumberFormatException unused3) {
                            firebaseApp = FirebaseApp.getInstance();
                            firebaseOptions = firebaseApp.options;
                            firebaseApp.checkNotDeleted();
                            str = firebaseOptions.gcmSenderId;
                            if (str != null) {
                                firebaseApp.checkNotDeleted();
                                str2 = firebaseOptions.applicationId;
                                if (str2.startsWith(C0000.decode(new byte[]{87, 15}, "f568db", 2))) {
                                    j = Long.parseLong(str2);
                                } else {
                                    strArrSplit = str2.split(C0000.decode(new byte[]{14}, "458988cd9b", true));
                                    if (strArrSplit.length >= 2) {
                                        str3 = strArrSplit[1];
                                        if (!str3.isEmpty()) {
                                            j = Long.parseLong(str3);
                                        }
                                    }
                                    j = 0;
                                }
                                break;
                            } else {
                                try {
                                    j = Long.parseLong(str);
                                    break;
                                } catch (NumberFormatException unused4) {
                                    firebaseApp.checkNotDeleted();
                                    str2 = firebaseOptions.applicationId;
                                    try {
                                        if (str2.startsWith(C0000.decode(new byte[]{87, 15}, "f568db", 2))) {
                                            j = Long.parseLong(str2);
                                        } else {
                                            strArrSplit = str2.split(C0000.decode(new byte[]{14}, "458988cd9b", true));
                                            if (strArrSplit.length >= 2) {
                                                str3 = strArrSplit[1];
                                                if (!str3.isEmpty()) {
                                                    j = Long.parseLong(str3);
                                                }
                                            }
                                            j = 0;
                                        }
                                        break;
                                    } catch (NumberFormatException unused5) {
                                    }
                                }
                            }
                        }
                    }
                    MessagingClientEvent messagingClientEvent = new MessagingClientEvent(j > 0 ? j : 0L, str5, str4, messageType, packageName, str7, i, str6, str8, str9);
                    try {
                        AutoValue_ProductData autoValue_ProductData = new AutoValue_ProductData(Integer.valueOf(intent.getIntExtra(C0000.decode(new byte[]{6, 92, 95, 84, 15, 82, 27, 19, 75, 12, 5, 70, 83, 71, 60, 94, 81}, "a303c75c9c"), 111881503)));
                        Encoding encoding = new Encoding(C0000.decode(new byte[]{72, 19, 9, 67, 12}, "8af7c7eeec319c6e", true));
                        new TransportImpl$$ExternalSyntheticLambda0(18);
                        TransportFactoryImpl transportFactoryImpl = (TransportFactoryImpl) transportFactory;
                        Set set = transportFactoryImpl.supportedPayloadEncodings;
                        if (!set.contains(encoding)) {
                            throw new IllegalArgumentException(String.format(C0000.decode(new byte[]{18, 67, 22, 13, 21, 68, 94, 91, 68, 17, 65, 65, 20, 73, 88, 66, 66, 1, 2, 68, 82, 77, 68, 17, 70, 92, 13, 74, 23, 86, 87, 7, 18, 11, 66, 77, 30, 17, 97, 65, 20, 73, 88, 66, 66, 1, 2, 68, 85, 90, 83, 94, 86, 93, 10, 94, 68, 16, 87, 22, 3, 94, 16, 17, 67, 31}, "706dfd040124d9"), encoding, set));
                        }
                        AutoValue_TransportContext autoValue_TransportContext = transportFactoryImpl.transportContext;
                        TransportRuntime transportRuntime = transportFactoryImpl.transportInternal;
                        WorkTagDao_Impl workTagDao_Impl = new WorkTagDao_Impl();
                        workTagDao_Impl.__db = autoValue_TransportContext;
                        workTagDao_Impl.__insertionAdapterOfWorkTag = encoding;
                        workTagDao_Impl.__preparedStmtOfDeleteByWorkSpecId = transportRuntime;
                        workTagDao_Impl.send(new AutoValue_Event(new MessagingClientEventExtension(messagingClientEvent), autoValue_ProductData));
                    } catch (RuntimeException unused6) {
                    }
                    break;
                }
                dispatchMessage(intent);
                return;
            case 2:
                String messageId = getMessageId(intent);
                String stringExtra2 = intent.getStringExtra(C0000.decode(new byte[]{93, 70, 20, 90, 16}, "84f5bac933e45a14"));
                zzs zzsVar = new zzs(stringExtra2);
                if (stringExtra2 != null) {
                    stringExtra2.toLowerCase(Locale.US).getClass();
                }
                onSendError(messageId, zzsVar);
                return;
            case 3:
                onMessageSent(intent.getStringExtra(strDecode2));
                return;
            default:
                return;
        }
    }

    public static void resetForTesting() {
        recentlyReceivedMessageIds.clear();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public Intent getStartCommandIntent(Intent intent) {
        return (Intent) ((ArrayDeque) ServiceStarter.getInstance().messagingEvents).poll();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if (C0000.decode(new byte[]{83, 13, 84, 79, 87, 13, 91, 84, 92, 7, 23, 0, 94, 6, 70, 92, 89, 6, 23, 2, 2, 6, 89, 29, 89, 12, 77, 4, 94, 22, 26, 97, 117, 33, 124, 40, 102, 39}, "0b9a0b43").equals(action) || C0000.decode(new byte[]{83, 89, 85, 72, 87, 92, 90, 6, 9, 81, 79, 0, 8, 19, 0, 90, 81, 69, 93, 72, 93, 86, 70, 18, 4, 83, 8, 8, 6, 79, 55, 125, 115, 115, 113, 48, 117, 108, 113, 40, 55, 113, 34, 50, 62, 35, 42, 119, 100}, "068f035ae4afaae8", true).equals(action)) {
            handleMessageIntent(intent);
        } else if (C0000.decode(new byte[]{6, 90, 94, 25, 86, 95, 14, 84, 85, 82, 24, 0, 12, 71, 86, 85, 80, 67, 4, 29, 84, 82, 69, 21, 4, 82, 90, 89, 86, 30, 47, 118, 110, 104, 98, 41, 46, 112, 125}, "e53710a3976f", 0.0f).equals(action)) {
            onNewToken(intent.getStringExtra(C0000.decode(new byte[]{21, 10, 88, 3, 87}, "ae3f971a16", 7)));
        } else {
            intent.getAction();
        }
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onSendError(String str, Exception exc) {
    }

    public void setRpcForTesting(Rpc rpc) {
        this.rpc = rpc;
    }
}
