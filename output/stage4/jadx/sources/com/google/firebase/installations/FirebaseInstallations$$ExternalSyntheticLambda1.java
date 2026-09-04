package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.work.impl.OperationImpl;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import java.io.IOException;
import java.util.Iterator;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class FirebaseInstallations$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ FirebaseInstallations f$0;

    public /* synthetic */ FirebaseInstallations$$ExternalSyntheticLambda1(FirebaseInstallations firebaseInstallations, int i) {
        this.$r8$classId = i;
        this.f$0 = firebaseInstallations;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AutoValue_PersistedInstallationEntry persistedInstallationEntryValue;
        AutoValue_PersistedInstallationEntry autoValue_PersistedInstallationEntryRegisterFidWithServer;
        switch (this.$r8$classId) {
            case 0:
                this.f$0.doRegistrationOrRefresh();
                return;
            case 1:
                FirebaseInstallations firebaseInstallations = this.f$0;
                Object obj = FirebaseInstallations.lockGenerateFid;
                synchronized (obj) {
                    try {
                        FirebaseApp firebaseApp = firebaseInstallations.firebaseApp;
                        firebaseApp.checkNotDeleted();
                        OperationImpl operationImplAcquire = OperationImpl.acquire(firebaseApp.applicationContext);
                        try {
                            persistedInstallationEntryValue = firebaseInstallations.persistedInstallation.readPersistedInstallationEntryValue();
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
                try {
                    int i = persistedInstallationEntryValue.registrationStatus;
                    if (i == 5) {
                        autoValue_PersistedInstallationEntryRegisterFidWithServer = firebaseInstallations.registerFidWithServer(persistedInstallationEntryValue);
                    } else {
                        if (i == 3) {
                            autoValue_PersistedInstallationEntryRegisterFidWithServer = firebaseInstallations.registerFidWithServer(persistedInstallationEntryValue);
                        } else if (!firebaseInstallations.utils.isAuthTokenExpired(persistedInstallationEntryValue)) {
                            return;
                        } else {
                            autoValue_PersistedInstallationEntryRegisterFidWithServer = firebaseInstallations.fetchAuthTokenFromServer(persistedInstallationEntryValue);
                        }
                    }
                    synchronized (obj) {
                        try {
                            FirebaseApp firebaseApp2 = firebaseInstallations.firebaseApp;
                            firebaseApp2.checkNotDeleted();
                            OperationImpl operationImplAcquire2 = OperationImpl.acquire(firebaseApp2.applicationContext);
                            try {
                                firebaseInstallations.persistedInstallation.insertOrUpdatePersistedInstallationEntry(autoValue_PersistedInstallationEntryRegisterFidWithServer);
                                if (operationImplAcquire2 != null) {
                                    operationImplAcquire2.releaseAndClose();
                                }
                            } catch (Throwable th3) {
                                if (operationImplAcquire2 != null) {
                                    operationImplAcquire2.releaseAndClose();
                                }
                                throw th3;
                            }
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                    synchronized (firebaseInstallations) {
                        try {
                            if (firebaseInstallations.fidListeners.size() != 0 && !TextUtils.equals(persistedInstallationEntryValue.firebaseInstallationId, autoValue_PersistedInstallationEntryRegisterFidWithServer.firebaseInstallationId)) {
                                Iterator it = firebaseInstallations.fidListeners.iterator();
                                if (it.hasNext()) {
                                    if (it.next() != null) {
                                        throw new ClassCastException();
                                    }
                                    throw null;
                                }
                            }
                        } catch (Throwable th5) {
                            throw th5;
                        }
                    }
                    if (autoValue_PersistedInstallationEntryRegisterFidWithServer.registrationStatus == 4) {
                        String str = autoValue_PersistedInstallationEntryRegisterFidWithServer.firebaseInstallationId;
                        synchronized (firebaseInstallations) {
                            firebaseInstallations.cachedFid = str;
                        }
                    }
                    int i2 = autoValue_PersistedInstallationEntryRegisterFidWithServer.registrationStatus;
                    if (i2 == 5) {
                        firebaseInstallations.triggerOnException(new FirebaseInstallationsException());
                        return;
                    } else if (i2 == 2 || i2 == 1) {
                        firebaseInstallations.triggerOnException(new IOException(C0000.decode(new byte[]{47, 95, 22, 67, 83, 85, 92, 5, 76, 80, 9, 95, 69, 126, 118, 25, 83, 11, 77, 85, 2, 17, 11, 88, 70, 25, 82, 1, 24, 79, 7, 93, 12, 83, 83, 77, 85, 0, 24, 78, 15, 69, 13, 23, 70, 81, 85, 68, 126, 80, 20, 84, 7, 86, 65, 92, 16, 23, 93, 75, 16, 84, 23, 68, 18, 17, 93, 5, 65, 91, 3, 17, 12, 67, 18, 78, 81, 23, 24, 93, 3, 93, 0, 67, 87, 93, 25, 74, 24, 127, 15, 67, 0, 85, 83, 74, 85, 68, 113, 87, 21, 69, 4, 91, 94, 88, 68, 13, 87, 87, 21, 17, 18, 94, 94, 85, 16, 10, 93, 92, 2, 17, 17, 88, 18, 90, 66, 1, 89, 77, 3, 17, 4, 23, 92, 92, 71, 68, 113, 87, 21, 69, 4, 91, 94, 88, 68, 13, 87, 87, 70, 120, 33, 23, 83, 87, 84, 68, 89, 76, 18, 89, 69, 67, 93, 82, 85, 10, 22, 25, 54, 93, 0, 86, 65, 92, 16, 22, 93, 77, 20, 72, 69, 78, 93, 76, 66, 68, 84, 88, 21, 69, 69, 69, 87, 72, 69, 1, 75, 77, 72}, "f1e7290d89", false)));
                        return;
                    } else {
                        firebaseInstallations.triggerOnStateReached(autoValue_PersistedInstallationEntryRegisterFidWithServer);
                        return;
                    }
                } catch (FirebaseInstallationsException e) {
                    firebaseInstallations.triggerOnException(e);
                    return;
                }
            default:
                this.f$0.doRegistrationOrRefresh();
                return;
        }
    }
}
