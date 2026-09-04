package okhttp3;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateHandleSupport$DEFAULT_ARGS_KEY$1;
import androidx.lifecycle.SavedStateHandlesVM;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras$Empty;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.constraints.ConstraintsState;
import java.io.File;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Handshake {
    public final CipherSuite cipherSuite;
    public final List localCertificates;
    public final SynchronizedLazyImpl peerCertificates$delegate;
    public final TlsVersion tlsVersion;

    /* JADX INFO: renamed from: okhttp3.Handshake$peerCertificates$2, reason: invalid class name */
    public final class AnonymousClass2 extends Lambda implements Function0 {
        public final /* synthetic */ Object $peerCertificatesFn;
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(int i, Object obj) {
            super(0);
            this.$r8$classId = i;
            this.$peerCertificatesFn = obj;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            switch (this.$r8$classId) {
                case 0:
                    try {
                        return (List) ((Lambda) this.$peerCertificatesFn).invoke();
                    } catch (SSLPeerUnverifiedException unused) {
                        return EmptyList.INSTANCE;
                    }
                case 1:
                    ComponentActivity componentActivity = (ComponentActivity) this.$peerCertificatesFn;
                    ArrayList arrayList = new ArrayList();
                    Reflection.factory.getClass();
                    arrayList.add(new ViewModelInitializer(new ClassReference(SavedStateHandlesVM.class).getJClass()));
                    ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) arrayList.toArray(new ViewModelInitializer[0]);
                    ViewModelInitializer[] viewModelInitializerArr2 = (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length);
                    ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                    CreationExtras$Empty creationExtras$Empty = CreationExtras$Empty.INSTANCE;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.putAll((LinkedHashMap) creationExtras$Empty.mBuilder);
                    if (componentActivity.getApplication() != null) {
                        linkedHashMap.put(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE, componentActivity.getApplication());
                    }
                    linkedHashMap.put(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, componentActivity);
                    linkedHashMap.put(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, componentActivity);
                    if (componentActivity.getIntent() != null && componentActivity.getIntent().getExtras() != null) {
                        linkedHashMap.put(SavedStateHandleSupport.DEFAULT_ARGS_KEY, componentActivity.getIntent().getExtras());
                    }
                    LinkedHashMap linkedHashMap2 = viewModelStore.map;
                    String strDecode = C0000.decode(new byte[]{0, 87, 0, 75, 95, 81, 93, 27, 22, 14, 8, 95, 1, 90, 73, 91, 85, 6, 22, 11, 15, 77, 1, 75, 94, 89, 85, 77, 107, 3, 23, 92, 0, 106, 68, 89, 77, 6, 112, 3, 15, 93, 8, 92, 67, 110, 116}, "a9d9089c8b");
                    ViewModel viewModel = (ViewModel) linkedHashMap2.get(strDecode);
                    if (!SavedStateHandlesVM.class.isInstance(viewModel)) {
                        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                        linkedHashMap3.putAll(linkedHashMap);
                        linkedHashMap3.put(SavedStateHandleSupport$DEFAULT_ARGS_KEY$1.INSTANCE$1, strDecode);
                        try {
                            SavedStateHandlesVM savedStateHandlesVM = null;
                            for (ViewModelInitializer viewModelInitializer : viewModelInitializerArr2) {
                                if (Intrinsics.areEqual(viewModelInitializer.clazz, SavedStateHandlesVM.class)) {
                                    savedStateHandlesVM = new SavedStateHandlesVM();
                                }
                            }
                            if (savedStateHandlesVM == null) {
                                throw new IllegalArgumentException(C0000.decode(new byte[]{119, 10, 24, 80, 15, 93, 67, 88, 87, 10, 15, 28, 84, 75, 25, 22, 93, 77, 65, 82, 88, 67, 22, 1, 15, 16, 84, 87, 25, 6, 84, 88, 18, 71, 23}, "9e89a4716fff19", 0).concat(SavedStateHandlesVM.class.getName()));
                            }
                            ViewModel viewModel2 = (ViewModel) viewModelStore.map.put(strDecode, savedStateHandlesVM);
                            if (viewModel2 != null) {
                                viewModel2.onCleared();
                            }
                            viewModel = savedStateHandlesVM;
                        } catch (AbstractMethodError unused2) {
                            throw new UnsupportedOperationException(C0000.decode(new byte[]{127, 85, 5, 64, 94, 69, 74, 26, 91, 69, 7, 5, 64, 6, 29, 102, 77, 70, 15, 90, 86, 30, 19, 93, 75, 23, 23, 10, 71, 22, 69, 69, 86, 70, 18, 81, 85, 25, 19, 20, 108, 95, 11, 23, 20, 37, 84, 86, 77, 91, 20, 77, 17, 69, 86, 69, 77, 94, 16, 1, 71, 67, 85, 118, 75, 81, 7, 64, 88, 88, 93, 113, 64, 67, 16, 5, 71, 3, 21, 65, 86, 20, 4, 81, 17, 71, 82, 71, 75, 82, 6, 68, 93, 13, 65, 90, 25, 84, 5, 70, 84, 86, 71, 81, 88, 23, 15, 1, 64, 11, 90, 81, 23}, "94f4173487bd4c55"));
                        }
                    }
                    return (SavedStateHandlesVM) viewModel;
                case 2:
                    WorkRequest.Builder builder = (WorkRequest.Builder) this.$peerCertificatesFn;
                    String strCreateQuery = builder.createQuery();
                    WorkDatabase workDatabase = (WorkDatabase) builder.id;
                    workDatabase.assertNotMainThread();
                    workDatabase.assertNotSuspendingTransaction();
                    SupportSQLiteOpenHelper supportSQLiteOpenHelper = workDatabase.internalOpenHelper;
                    if (supportSQLiteOpenHelper == null) {
                        supportSQLiteOpenHelper = null;
                    }
                    return supportSQLiteOpenHelper.getWritableDatabase().compileStatement(strCreateQuery);
                case 3:
                    FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = (FrameworkSQLiteOpenHelper) this.$peerCertificatesFn;
                    RoomOpenHelper roomOpenHelper = frameworkSQLiteOpenHelper.callback;
                    String str = frameworkSQLiteOpenHelper.name;
                    FrameworkSQLiteOpenHelper.OpenHelper openHelper = (str == null || !frameworkSQLiteOpenHelper.useNoBackupDirectory) ? new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.context, frameworkSQLiteOpenHelper.name, new ConnectionPool(6), roomOpenHelper, frameworkSQLiteOpenHelper.allowDataLossOnRecovery) : new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.context, new File(frameworkSQLiteOpenHelper.context.getNoBackupFilesDir(), str).getAbsolutePath(), new ConnectionPool(6), roomOpenHelper, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
                    openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.writeAheadLoggingEnabled);
                    return openHelper;
                case 4:
                    return new ConstraintsState[((Flow[]) this.$peerCertificatesFn).length];
                default:
                    return (List) this.$peerCertificatesFn;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function0 function0) {
            super(0);
            this.$r8$classId = 0;
            this.$peerCertificatesFn = (Lambda) function0;
        }
    }

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List list, Function0 function0) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = new SynchronizedLazyImpl(new AnonymousClass2(function0));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.tlsVersion == this.tlsVersion && Intrinsics.areEqual(handshake.cipherSuite, this.cipherSuite) && Intrinsics.areEqual(handshake.peerCertificates(), peerCertificates()) && Intrinsics.areEqual(handshake.localCertificates, this.localCertificates);
    }

    public final int hashCode() {
        return this.localCertificates.hashCode() + ((peerCertificates().hashCode() + ((this.cipherSuite.hashCode() + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final String toString() {
        List<Certificate> listPeerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listPeerCertificates));
        for (Certificate certificate : listPeerCertificates) {
            arrayList.add(certificate instanceof X509Certificate ? ((X509Certificate) certificate).getSubjectDN().toString() : certificate.getType());
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{126, 80, 90, 1, 65, 11, 87, 90, 81, 30, 70, 15, 69, 103, 81, 23, 65, 10, 89, 95, 9}, "614e2c", 3));
        sb.append(this.tlsVersion);
        sb.append(C0000.decode(new byte[]{21, 2, 94, 70, 90, 82, 65, 107, 65, 90, 65, 4, 10}, "5a76273843"));
        sb.append(this.cipherSuite);
        sb.append(C0000.decode(new byte[]{69, 19, 81, 1, 22, 118, 1, 20, 77, 12, 3, 10, 87, 5, 16, 80, 23, 91}, "ec4dd5df9e", 0.0f));
        sb.append(string);
        sb.append(C0000.decode(new byte[]{20, 93, 92, 83, 81, 90, 39, 83, 70, 69, 90, 86, 89, 85, 5, 66, 81, 66, 14}, "413006d6"));
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list));
        for (Certificate certificate2 : list) {
            arrayList2.add(certificate2 instanceof X509Certificate ? ((X509Certificate) certificate2).getSubjectDN().toString() : certificate2.getType());
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
