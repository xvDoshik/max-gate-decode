package com.google.android.gms.common.api;

import android.database.Cursor;
import android.util.SparseIntArray;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.room.RoomSQLiteQuery;
import androidx.work.impl.AutoMigration_14_15;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.service.zan;
import java.util.ArrayList;
import java.util.Set;
import javax.inject.Provider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import okhttp3.ConnectionPool;
import okio.ByteString;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Api implements FlowCollector, Factory {
    public final /* synthetic */ int $r8$classId;
    public final Object zaa;
    public final Object zac;

    public interface Client {
        void connect(zabu zabuVar);

        void disconnect();

        void disconnect(String str);

        Feature[] getAvailableFeatures();

        void getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(IAccountAccessor iAccountAccessor, Set set);

        Set getScopesForConnectionlessNonSignIn();

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(ConnectionPool connectionPool);

        boolean requiresSignIn();
    }

    public Api(zan zanVar, AutoMigration_14_15 autoMigration_14_15) {
        this.$r8$classId = 0;
        this.zac = C0000.decode(new byte[]{114, 89, 81, 4, 92, 65, 102, 93, 15, 93, 14, 82, 17, 69, 78, 28, 112, 101, 113}, "158a2528c8c7e772", true);
        this.zaa = zanVar;
    }

    public /* synthetic */ Api(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.zac = obj;
        this.zaa = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(Object obj, ContinuationImpl continuationImpl) {
        DistinctFlowImpl$collect$2$emit$1 distinctFlowImpl$collect$2$emit$1;
        switch (this.$r8$classId) {
            case 3:
                ((OnConstraintsStateChangedListener) this.zaa).onConstraintsStateChanged((WorkSpec) this.zac, (ConstraintsState) obj);
                return Unit.INSTANCE;
            default:
                Regex regex = (Regex) this.zaa;
                if (continuationImpl instanceof DistinctFlowImpl$collect$2$emit$1) {
                    distinctFlowImpl$collect$2$emit$1 = (DistinctFlowImpl$collect$2$emit$1) continuationImpl;
                    int i = distinctFlowImpl$collect$2$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        distinctFlowImpl$collect$2$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuationImpl);
                    }
                } else {
                    distinctFlowImpl$collect$2$emit$1 = new DistinctFlowImpl$collect$2$emit$1(this, continuationImpl);
                }
                Object obj2 = distinctFlowImpl$collect$2$emit$1.result;
                int i2 = distinctFlowImpl$collect$2$emit$1.label;
                Unit unit = Unit.INSTANCE;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException(C0000.decode(new byte[]{87, 86, 94, 93, 19, 16, 91, 23, 21, 67, 86, 23, 65, 90, 87, 22, 19, 6, 81, 81, 93, 67, 86, 68, 19, 94, 92, 71, 92, 15, 81, 16, 18, 70, 90, 16, 92, 23, 81, 94, 65, 11, 65, 67, 91, 95, 86}, "47213d", 7));
                    }
                    ResultKt.throwOnFailure(obj2);
                    return unit;
                }
                ResultKt.throwOnFailure(obj2);
                Object obj3 = regex.nativePattern;
                if (obj3 != NullSurrogateKt.NULL && Intrinsics.areEqual(obj3, obj)) {
                    return unit;
                }
                regex.nativePattern = obj;
                FlowCollector flowCollector = (FlowCollector) this.zac;
                distinctFlowImpl$collect$2$emit$1.label = 1;
                Object objEmit = flowCollector.emit(obj, distinctFlowImpl$collect$2$emit$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                return objEmit == coroutineSingletons ? coroutineSingletons : unit;
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        ProfileInstaller$2 profileInstaller$2 = new ProfileInstaller$2();
        ByteString.Companion companion = new ByteString.Companion();
        Object obj = ((Provider) this.zaa).get();
        return new SQLiteEventStore(profileInstaller$2, companion, AutoValue_EventStoreConfig.DEFAULT, (SchemaManager) obj, (Provider) this.zac);
    }

    public ArrayList getDependentWorkIds(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.zaa;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{97, 112, 126, 125, 33, 48, 17, 68, 10, 74, 89, 106, 65, 72, 7, 7, 110, 90, 1, 24, 116, 103, 125, 117, 66, 0, 84, 67, 0, 86, 86, 80, 92, 91, 27, 68, 102, 123, 32, 106, 119, 21, 66, 74, 7, 22, 84, 66, 16, 81, 65, 92, 70, 93, 61, 13, 85, 14, 90}, "2528bd13e8"), 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(str, 1);
        }
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public /* synthetic */ Api(Object obj, Object obj2, int i, boolean z) {
        this.$r8$classId = i;
        this.zaa = obj;
        this.zac = obj2;
    }

    public Api(DistinctFlowImpl distinctFlowImpl, Regex regex, FlowCollector flowCollector) {
        this.$r8$classId = 7;
        this.zaa = regex;
        this.zac = flowCollector;
    }

    public Api() {
        this.$r8$classId = 6;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        this.zaa = new SparseIntArray();
        this.zac = googleApiAvailability;
    }

    public Api(WorkDatabase_Impl workDatabase_Impl) {
        this.$r8$classId = 1;
        this.zaa = workDatabase_Impl;
        this.zac = new WorkTagDao_Impl.AnonymousClass1(workDatabase_Impl, 1);
    }
}
