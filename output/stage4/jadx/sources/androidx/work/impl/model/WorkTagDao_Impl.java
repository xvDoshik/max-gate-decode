package androidx.work.impl.model;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.startup.StartupException;
import androidx.tracing.Trace;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.Processor$$ExternalSyntheticLambda1;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.cloudmessaging.zzac;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.proto.ProtobufDataEncoderContext;
import com.google.firebase.messaging.ProtoEncoderDoNotUse;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;
import okhttp3.Headers;
import okhttp3.Request;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class WorkTagDao_Impl {
    public Object __db;
    public Object __insertionAdapterOfWorkTag;
    public Object __preparedStmtOfDeleteByWorkSpecId;

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkTagDao_Impl$1, reason: invalid class name */
    public final class AnonymousClass1 extends WorkRequest.Builder {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(WorkDatabase workDatabase, int i) {
            super(workDatabase);
            this.$r8$classId = i;
        }

        public final void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, Object obj) throws Throwable {
            int i;
            switch (this.$r8$classId) {
                case 0:
                    WorkTag workTag = (WorkTag) obj;
                    String str = workTag.tag;
                    if (str == null) {
                        frameworkSQLiteStatement.bindNull(1);
                    } else {
                        frameworkSQLiteStatement.bindString(str, 1);
                    }
                    String str2 = workTag.workSpecId;
                    if (str2 == null) {
                        frameworkSQLiteStatement.bindNull(2);
                        return;
                    } else {
                        frameworkSQLiteStatement.bindString(str2, 2);
                        return;
                    }
                case 1:
                    Dependency dependency = (Dependency) obj;
                    String str3 = dependency.workSpecId;
                    if (str3 == null) {
                        frameworkSQLiteStatement.bindNull(1);
                    } else {
                        frameworkSQLiteStatement.bindString(str3, 1);
                    }
                    String str4 = dependency.prerequisiteId;
                    if (str4 == null) {
                        frameworkSQLiteStatement.bindNull(2);
                        return;
                    } else {
                        frameworkSQLiteStatement.bindString(str4, 2);
                        return;
                    }
                case 2:
                    Preference preference = (Preference) obj;
                    frameworkSQLiteStatement.bindString(preference.key, 1);
                    frameworkSQLiteStatement.bindLong(2, preference.value.longValue());
                    return;
                case 3:
                    SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
                    String str5 = systemIdInfo.workSpecId;
                    if (str5 == null) {
                        frameworkSQLiteStatement.bindNull(1);
                    } else {
                        frameworkSQLiteStatement.bindString(str5, 1);
                    }
                    frameworkSQLiteStatement.bindLong(2, systemIdInfo.generation);
                    frameworkSQLiteStatement.bindLong(3, systemIdInfo.systemId);
                    return;
                case 4:
                    WorkName workName = (WorkName) obj;
                    String str6 = workName.name;
                    if (str6 == null) {
                        frameworkSQLiteStatement.bindNull(1);
                    } else {
                        frameworkSQLiteStatement.bindString(str6, 1);
                    }
                    String str7 = workName.workSpecId;
                    if (str7 == null) {
                        frameworkSQLiteStatement.bindNull(2);
                        return;
                    } else {
                        frameworkSQLiteStatement.bindString(str7, 2);
                        return;
                    }
                case 5:
                    obj.getClass();
                    throw new ClassCastException();
                default:
                    WorkSpec workSpec = (WorkSpec) obj;
                    String str8 = workSpec.id;
                    int i2 = 1;
                    if (str8 == null) {
                        frameworkSQLiteStatement.bindNull(1);
                    } else {
                        frameworkSQLiteStatement.bindString(str8, 1);
                    }
                    frameworkSQLiteStatement.bindLong(2, Headers.Companion.stateToInt(workSpec.state));
                    String str9 = workSpec.workerClassName;
                    if (str9 == null) {
                        frameworkSQLiteStatement.bindNull(3);
                    } else {
                        frameworkSQLiteStatement.bindString(str9, 3);
                    }
                    String str10 = workSpec.inputMergerClassName;
                    if (str10 == null) {
                        frameworkSQLiteStatement.bindNull(4);
                    } else {
                        frameworkSQLiteStatement.bindString(str10, 4);
                    }
                    byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                    if (byteArrayInternal == null) {
                        frameworkSQLiteStatement.bindNull(5);
                    } else {
                        frameworkSQLiteStatement.bindBlob(5, byteArrayInternal);
                    }
                    byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                    if (byteArrayInternal2 == null) {
                        frameworkSQLiteStatement.bindNull(6);
                    } else {
                        frameworkSQLiteStatement.bindBlob(6, byteArrayInternal2);
                    }
                    frameworkSQLiteStatement.bindLong(7, workSpec.initialDelay);
                    frameworkSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                    frameworkSQLiteStatement.bindLong(9, workSpec.flexDuration);
                    frameworkSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
                    int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(workSpec.backoffPolicy);
                    if (iOrdinal == 0) {
                        i = 0;
                    } else {
                        if (iOrdinal != 1) {
                            throw new StartupException();
                        }
                        i = 1;
                    }
                    frameworkSQLiteStatement.bindLong(11, i);
                    frameworkSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                    frameworkSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                    frameworkSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                    frameworkSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                    frameworkSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
                    int iOrdinal2 = FileSectionType$EnumUnboxingLocalUtility.ordinal(workSpec.outOfQuotaPolicy);
                    if (iOrdinal2 == 0) {
                        i2 = 0;
                    } else if (iOrdinal2 != 1) {
                        throw new StartupException();
                    }
                    frameworkSQLiteStatement.bindLong(17, i2);
                    frameworkSQLiteStatement.bindLong(18, workSpec.periodCount);
                    frameworkSQLiteStatement.bindLong(19, workSpec.generation);
                    frameworkSQLiteStatement.bindLong(20, workSpec.nextScheduleTimeOverride);
                    frameworkSQLiteStatement.bindLong(21, workSpec.nextScheduleTimeOverrideGeneration);
                    frameworkSQLiteStatement.bindLong(22, workSpec.stopReason);
                    Constraints constraints = workSpec.constraints;
                    if (constraints != null) {
                        frameworkSQLiteStatement.bindLong(23, Headers.Companion.networkTypeToInt(constraints.requiredNetworkType));
                        frameworkSQLiteStatement.bindLong(24, constraints.requiresCharging ? 1L : 0L);
                        frameworkSQLiteStatement.bindLong(25, constraints.requiresDeviceIdle ? 1L : 0L);
                        frameworkSQLiteStatement.bindLong(26, constraints.requiresBatteryNotLow ? 1L : 0L);
                        frameworkSQLiteStatement.bindLong(27, constraints.requiresStorageNotLow ? 1L : 0L);
                        frameworkSQLiteStatement.bindLong(28, constraints.contentTriggerUpdateDelayMillis);
                        frameworkSQLiteStatement.bindLong(29, constraints.contentTriggerMaxDelayMillis);
                        frameworkSQLiteStatement.bindBlob(30, Headers.Companion.setOfTriggersToByteArray(constraints.contentUriTriggers));
                        return;
                    }
                    frameworkSQLiteStatement.bindNull(23);
                    frameworkSQLiteStatement.bindNull(24);
                    frameworkSQLiteStatement.bindNull(25);
                    frameworkSQLiteStatement.bindNull(26);
                    frameworkSQLiteStatement.bindNull(27);
                    frameworkSQLiteStatement.bindNull(28);
                    frameworkSQLiteStatement.bindNull(29);
                    frameworkSQLiteStatement.bindNull(30);
                    return;
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final String createQuery() {
            switch (this.$r8$classId) {
                case 0:
                    return C0000.decode(new byte[]{43, 42, 54, 33, 49, 98, 19, 126, 51, 69, 127, 114, 44, 43, 55, 33, 67, 127, 125, 101, 46, 69, 86, 98, 13, 22, 14, 48, 2, 81, 83, 17, 73, 5, 66, 84, 5, 4, 73, 4, 20, 89, 65, 90, 62, 22, 70, 80, 1, 59, 12, 0, 3, 31, 19, 103, 32, 41, 99, 112, 49, 68, 77, 91, 79, 9, 26}, "bdedc631ae65", false);
                case 1:
                    return C0000.decode(new byte[]{47, 118, 48, 39, 54, 48, 22, 125, 99, 66, 47, 127, 45, 45, 54, 33, 22, 123, 127, 54, 41, 24, 3, 38, 1, 20, 83, 92, 85, 7, 8, 91, 26, 2, 68, 76, 86, 69, 94, 16, 13, 103, 16, 18, 1, 7, 105, 91, 85, 2, 74, 88, 19, 16, 1, 22, 83, 67, 68, 11, 21, 81, 23, 7, 59, 13, 82, 82, 24, 66, 48, 121, 47, 55, 33, 55, 22, 26, 14, 78, 89, 17}, "f8cbdd621b", 0.0f);
                case 2:
                    return C0000.decode(new byte[]{127, 45, 102, 118, 51, 100, 66, 123, 101, 65, 51, 124, 97, 45, 119, 32, 112, 19, 40, 126, 54, 123, 23, 1, 49, 75, 84, 7, 83, 17, 80, 93, 2, 85, 2, 20, 31, 1, 10, 92, 72, 1, 26, 3, 89, 92, 15, 87, 61, 66, 86, 13, 20, 92, 81, 72, 22, 53, 116, 127, 52, 117, 49, 20, 31, 94, 77, 6, 24}, "6c53a0b47aa91a", 2);
                case 3:
                    return C0000.decode(new byte[]{42, 124, 96, 36, 101, 55, 18, 127, 49, 18, 97, 36, 103, 47, 115, 115, 38, 18, 122, 47, 99, 44, 18, 80, 48, 75, 64, 21, 82, 14, 123, 84, 42, 92, 85, 14, 87, 67, 26, 80, 20, 93, 65, 10, 104, 16, 66, 85, 0, 109, 90, 5, 87, 79, 82, 87, 6, 92, 86, 19, 86, 23, 91, 95, 13, 82, 31, 1, 68, 26, 65, 68, 6, 95, 108, 8, 83, 3, 27, 16, 53, 115, 127, 52, 114, 48, 18, 24, 92, 30, 12, 77, 8, 74}, "c23a7c20", true);
                case 4:
                    return C0000.decode(new byte[]{44, 43, 48, 32, 107, 109, 17, 123, 107, 65, 42, 33, 43, 42, 49, 32, 25, 112, 127, 96, 118, 65, 3, 49, 10, 23, 8, 43, 88, 84, 84, 84, 25, 73, 3, 8, 4, 8, 6, 5, 21, 89, 70, 91, 75, 10, 60, 21, 21, 0, 0, 58, 80, 93, 81, 29, 25, 55, 34, 42, 48, 32, 48, 69, 17, 6, 29, 11, 16}, "eece99149acf");
                case 5:
                    return C0000.decode(new byte[]{122, 127, 106, 32, 106, 97, 19, 126, 107, 69, 106, 112, 99, 125, 120, 38, 125, 21, 122, 127, 109, 42, 24, 85, 100, 94, 75, 14, 104, 71, 92, 86, 75, 0, 75, 70, 83, 17, 17, 5, 79, 90, 65, 90, 102, 22, 72, 80, 80, 110, 80, 1, 88, 25, 83, 65, 75, 10, 95, 71, 86, 66, 74, 5, 17, 21, 101, 112, 117, 48, 125, 102, 19, 25, 6, 73, 7, 28}, "319e85", 1);
                default:
                    return C0000.decode(new byte[]{125, 43, 50, 35, 97, 49, 65, 126, 102, 69, 40, 33, 125, 42, 51, 116, 20, 44, 47, 50, 124, 69, 1, 102, 91, 23, 10, 53, 67, 0, 2, 81, 20, 77, 1, 15, 87, 5, 77, 81, 71, 17, 0, 18, 86, 5, 77, 81, 67, 10, 19, 13, 86, 23, 62, 82, 88, 4, 18, 21, 108, 11, 0, 92, 81, 5, 77, 6, 90, 11, 17, 68, 64, 58, 12, 3, 65, 2, 4, 67, 107, 6, 13, 7, 64, 22, 62, 95, 85, 8, 4, 6, 31, 5, 8, 95, 68, 16, 21, 6, 31, 5, 14, 68, 64, 21, 20, 18, 83, 73, 1, 88, 90, 12, 21, 15, 82, 9, 62, 85, 81, 9, 0, 31, 83, 73, 1, 88, 90, 17, 4, 20, 69, 4, 13, 110, 80, 16, 19, 7, 71, 12, 14, 95, 84, 73, 1, 0, 95, 0, 25, 110, 80, 16, 19, 7, 71, 12, 14, 95, 84, 73, 1, 20, 70, 11, 62, 80, 64, 17, 4, 11, 67, 17, 62, 82, 91, 16, 15, 18, 83, 73, 1, 83, 85, 6, 10, 9, 85, 3, 62, 65, 91, 9, 8, 5, 74, 5, 77, 81, 86, 4, 2, 13, 92, 3, 7, 110, 80, 0, 13, 7, 74, 58, 5, 68, 70, 4, 21, 15, 92, 11, 1, 29, 84, 9, 0, 21, 71, 58, 4, 95, 69, 16, 4, 19, 86, 58, 21, 88, 89, 0, 1, 74, 83, 8, 8, 95, 93, 8, 20, 11, 108, 23, 4, 69, 81, 11, 21, 15, 92, 11, 62, 85, 65, 23, 0, 18, 90, 10, 15, 81, 24, 5, 18, 5, 91, 0, 5, 68, 88, 0, 62, 20, 86, 20, 20, 84, 71, 17, 4, 2, 108, 4, 21, 81, 24, 5, 19, 19, 93, 58, 8, 95, 107, 3, 14, 20, 86, 2, 19, 94, 65, 11, 5, 6, 31, 5, 14, 68, 64, 58, 14, 0, 108, 20, 20, 94, 64, 4, 62, 22, 92, 9, 8, 82, 77, 5, 77, 6, 67, 0, 19, 88, 91, 1, 62, 5, 92, 16, 15, 69, 84, 73, 1, 1, 86, 11, 4, 67, 85, 17, 8, 9, 93, 5, 77, 81, 90, 0, 25, 18, 108, 22, 2, 89, 81, 1, 20, 10, 86, 58, 21, 88, 89, 0, 62, 9, 69, 0, 19, 67, 93, 1, 4, 6, 31, 5, 15, 84, 76, 17, 62, 21, 80, 13, 4, 85, 65, 9, 4, 57, 71, 12, 12, 84, 107, 10, 23, 3, 65, 23, 8, 85, 81, 58, 6, 3, 93, 0, 19, 80, 64, 12, 14, 8, 83, 73, 1, 66, 64, 10, 17, 57, 65, 0, 0, 66, 91, 11, 1, 74, 83, 23, 4, 64, 65, 12, 19, 3, 87, 58, 15, 84, 64, 18, 14, 20, 88, 58, 21, 72, 68, 0, 1, 74, 83, 23, 4, 64, 65, 12, 19, 3, 64, 58, 2, 89, 85, 23, 6, 15, 93, 2, 1, 29, 84, 23, 4, 23, 70, 12, 19, 84, 71, 58, 5, 3, 69, 12, 2, 84, 107, 12, 5, 10, 86, 5, 77, 81, 70, 0, 16, 19, 90, 23, 4, 66, 107, 7, 0, 18, 71, 0, 19, 72, 107, 11, 14, 18, 108, 9, 14, 70, 84, 73, 1, 20, 86, 20, 20, 88, 70, 0, 18, 57, 64, 17, 14, 67, 85, 2, 4, 57, 93, 10, 21, 110, 88, 10, 22, 6, 31, 5, 21, 67, 93, 2, 6, 3, 65, 58, 2, 94, 90, 17, 4, 8, 71, 58, 20, 65, 80, 4, 21, 3, 108, 1, 4, 93, 85, 28, 1, 74, 83, 17, 19, 88, 83, 2, 4, 20, 108, 8, 0, 73, 107, 6, 14, 8, 71, 0, 15, 69, 107, 1, 4, 10, 82, 28, 1, 29, 84, 6, 14, 8, 71, 0, 15, 69, 107, 16, 19, 15, 108, 17, 19, 88, 83, 2, 4, 20, 64, 5, 72, 17, 98, 36, 45, 51, 118, 54, 65, 25, 11, 73, 94, 74, 12, 73, 94, 29, 11, 73, 94, 74, 12, 73, 94, 29, 11, 73, 94, 74, 12, 73, 94, 29, 11, 73, 94, 74, 12, 73, 94, 29, 11, 73, 94, 74, 12, 73, 94, 29, 11, 73, 94, 74, 12, 73, 94, 29, 11, 73, 94, 74, 12, 73, 94, 29, 11, 73, 94, 79}, "4eaf3ea1", true);
            }
        }

        public final void insert(Object obj) {
            FrameworkSQLiteStatement frameworkSQLiteStatementAcquire = acquire();
            try {
                bind(frameworkSQLiteStatementAcquire, obj);
                frameworkSQLiteStatementAcquire.delegate.executeInsert();
            } finally {
                release(frameworkSQLiteStatementAcquire);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkTagDao_Impl$2, reason: invalid class name */
    public final class AnonymousClass2 extends WorkRequest.Builder {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(WorkDatabase workDatabase, int i) {
            super(workDatabase);
            this.$r8$classId = i;
        }

        public void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, Object obj) throws Throwable {
            int i;
            WorkSpec workSpec = (WorkSpec) obj;
            String str = workSpec.id;
            int i2 = 1;
            if (str == null) {
                frameworkSQLiteStatement.bindNull(1);
            } else {
                frameworkSQLiteStatement.bindString(str, 1);
            }
            frameworkSQLiteStatement.bindLong(2, Headers.Companion.stateToInt(workSpec.state));
            String str2 = workSpec.workerClassName;
            if (str2 == null) {
                frameworkSQLiteStatement.bindNull(3);
            } else {
                frameworkSQLiteStatement.bindString(str2, 3);
            }
            String str3 = workSpec.inputMergerClassName;
            if (str3 == null) {
                frameworkSQLiteStatement.bindNull(4);
            } else {
                frameworkSQLiteStatement.bindString(str3, 4);
            }
            byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
            if (byteArrayInternal == null) {
                frameworkSQLiteStatement.bindNull(5);
            } else {
                frameworkSQLiteStatement.bindBlob(5, byteArrayInternal);
            }
            byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
            if (byteArrayInternal2 == null) {
                frameworkSQLiteStatement.bindNull(6);
            } else {
                frameworkSQLiteStatement.bindBlob(6, byteArrayInternal2);
            }
            frameworkSQLiteStatement.bindLong(7, workSpec.initialDelay);
            frameworkSQLiteStatement.bindLong(8, workSpec.intervalDuration);
            frameworkSQLiteStatement.bindLong(9, workSpec.flexDuration);
            frameworkSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
            int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(workSpec.backoffPolicy);
            if (iOrdinal == 0) {
                i = 0;
            } else {
                if (iOrdinal != 1) {
                    throw new StartupException();
                }
                i = 1;
            }
            frameworkSQLiteStatement.bindLong(11, i);
            frameworkSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
            frameworkSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
            frameworkSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
            frameworkSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
            frameworkSQLiteStatement.bindLong(16, workSpec.expedited ? 1L : 0L);
            int iOrdinal2 = FileSectionType$EnumUnboxingLocalUtility.ordinal(workSpec.outOfQuotaPolicy);
            if (iOrdinal2 == 0) {
                i2 = 0;
            } else if (iOrdinal2 != 1) {
                throw new StartupException();
            }
            frameworkSQLiteStatement.bindLong(17, i2);
            frameworkSQLiteStatement.bindLong(18, workSpec.periodCount);
            frameworkSQLiteStatement.bindLong(19, workSpec.generation);
            frameworkSQLiteStatement.bindLong(20, workSpec.nextScheduleTimeOverride);
            frameworkSQLiteStatement.bindLong(21, workSpec.nextScheduleTimeOverrideGeneration);
            frameworkSQLiteStatement.bindLong(22, workSpec.stopReason);
            Constraints constraints = workSpec.constraints;
            if (constraints != null) {
                frameworkSQLiteStatement.bindLong(23, Headers.Companion.networkTypeToInt(constraints.requiredNetworkType));
                frameworkSQLiteStatement.bindLong(24, constraints.requiresCharging ? 1L : 0L);
                frameworkSQLiteStatement.bindLong(25, constraints.requiresDeviceIdle ? 1L : 0L);
                frameworkSQLiteStatement.bindLong(26, constraints.requiresBatteryNotLow ? 1L : 0L);
                frameworkSQLiteStatement.bindLong(27, constraints.requiresStorageNotLow ? 1L : 0L);
                frameworkSQLiteStatement.bindLong(28, constraints.contentTriggerUpdateDelayMillis);
                frameworkSQLiteStatement.bindLong(29, constraints.contentTriggerMaxDelayMillis);
                frameworkSQLiteStatement.bindBlob(30, Headers.Companion.setOfTriggersToByteArray(constraints.contentUriTriggers));
            } else {
                frameworkSQLiteStatement.bindNull(23);
                frameworkSQLiteStatement.bindNull(24);
                frameworkSQLiteStatement.bindNull(25);
                frameworkSQLiteStatement.bindNull(26);
                frameworkSQLiteStatement.bindNull(27);
                frameworkSQLiteStatement.bindNull(28);
                frameworkSQLiteStatement.bindNull(29);
                frameworkSQLiteStatement.bindNull(30);
            }
            if (str == null) {
                frameworkSQLiteStatement.bindNull(31);
            } else {
                frameworkSQLiteStatement.bindString(str, 31);
            }
        }

        @Override // androidx.work.WorkRequest.Builder
        public final String createQuery() {
            switch (this.$r8$classId) {
                case 0:
                    return C0000.decode(new byte[]{37, 124, 46, 117, 99, 35, 70, 117, 102, 46, 116, 16, 64, 14, 19, 82, 22, 81, 80, 70, 49, 123, 113, 51, 124, 16, 64, 14, 19, 82, 61, 67, 71, 3, 5, 108, 93, 5, 4, 15}, "a9b07ff34a907a");
                case 1:
                    return C0000.decode(new byte[]{124, 116, 125, 124, 54, 119, 24, 119, 99, 118, 47, 18, 107, 72, 66, 77, 7, 95, 113, 85, 120, 87, 4, 93, 24, 70, 89, 92, 16, 87, 24, 70, 94, 75, 9, 109, 75, 65, 84, 90, 61, 91, 92, 12, 14, 25, 35, 124, 124, 17, 86, 92, 12, 87, 74, 80, 69, 80, 13, 92, 5, 14}, "8119b2", 0.0f);
                case 2:
                    return C0000.decode(new byte[]{113, 125, 116, 119, 54, 35, 67, 116, 99, 125, 123, 69, 102, 65, 75, 70, 7, 11, 42, 86, 120, 92, 80, 10, 21, 79, 80, 87, 16, 3, 67, 69, 94, 64, 93, 58, 70, 72, 93, 81, 61, 15, 7, 15, 14}, "5882bfc2126e", false);
                case 3:
                    return C0000.decode(new byte[]{117, 114, 46, 115, 109, 39, 17, 81, 16, 89, 84, 66, 102, 88, 16, 93, 105, 16, 94, 80, 16, 83, 74, 17, 17, 64, 10, 83, 75, 7, 17, 64, 13, 68, 82, 61, 66, 71, 7, 85, 102, 11, 85, 10, 93}, "17b69b", 0.0f);
                case 4:
                    return C0000.decode(new byte[]{124, 38, 41, 114, 54, 119, 20, 126, 54, 127, 40, 18, 101, 90, 74, 8, 53, 69, 13, 85, 70, 93, 23, 67}, "8ce7b248d0e225", true);
                case 5:
                    return C0000.decode(new byte[]{52, 102, 34, 112, 99, 118, 66, 20, 14, 68, 13, 66, 71, 86, 1, 67, 50, 115, 50, 17, 69, 70, 12, 60, 0, 66, 18, 84, 90, 67, 22, 60, 2, 89, 19, 95, 67, 14, 82, 67, 54, 126, 35, 99, 114, 19, 11, 7, 92, 9}, "a6f173bc");
                case 6:
                    return C0000.decode(new byte[]{55, 97, 113, 117, 109, 36, 18, 22, 90, 68, 9, 66, 69, 81, 90, 65, 97, 36, 97, 22, 12, 84, 77, 64, 102, 18, 81, 9, 80, 82, 23, 93, 80, 107, 77, 8, 95, 4, 106, 89, 20, 84, 71, 70, 80, 5, 87, 92, 10, 22, 53, 121, 112, 102, 124, 65, 91, 5, 8, 9}, "b1549a2a56", false);
                case 7:
                    return C0000.decode(new byte[]{109, 98, 32, 113, 54, 116, 66, 79, 87, 64, 15, 67, 18, 84, 1, 24, 107, 119, 48, 16, 12, 84, 26, 76, 103, 65, 7, 88, 7, 85, 23, 84, 93, 109, 16, 89, 15, 84, 61, 87, 78, 87, 22, 66, 11, 85, 7, 5, 1, 0, 86, 3, 81, 6, 80, 8, 11, 4, 92, 5, 86, 6, 85, 13, 0, 2, 83, 16, 53, 121, 39, 106, 125, 18, 76, 89, 6, 12, 93, 24, 121, 124, 32, 16, 12, 84, 26, 76, 103, 65, 7, 88, 7, 85, 23, 84, 93, 109, 16, 89, 15, 84, 61, 87, 78, 87, 22, 66, 11, 85, 7, 103, 95, 87, 10, 85, 16, 80, 22, 81, 87, 92, 89, 15, 75}, "82d0b1b8", 0.0f);
                case 8:
                    return C0000.decode(new byte[]{99, 49, 117, 115, 48, 36, 20, 65, 87, 17, 89, 67, 20, 7, 85, 65, 98, 119, 48, 65, 71, 85, 80, 6, 86, 69, 8, 7, 105, 19, 84, 67, 17, 4, 71, 66, 93, 7, 109, 81, 16, 95, 9, 65, 102, 122, 33, 51, 113, 22, 81, 7, 15, 15}, "6a12da468c20db", 0.0f);
                case 9:
                    return C0000.decode(new byte[]{99, 103, 116, 121, 49, 35, 22, 64, 95, 74, 14, 21, 70, 82, 83, 24, 54, 35, 98, 23, 67, 91, 13, 3, 82, 66, 92, 93, 58, 20, 83, 70, 69, 93, 22, 18, 83, 83, 111, 89, 17, 91, 27, 6, 16, 111, 45, 35, 100, 114, 16, 75, 17, 7, 66, 82, 16, 118, 42, 50, 22, 126, 126, 24, 77, 84, 26, 23, 3, 20, 69, 83, 31}, "6708ef", 0.0f);
                case 10:
                    return C0000.decode(new byte[]{114, 39, 123, 114, 55, 116, 16, 39, 100, 120, 127, 23, 65, 13, 69, 92, 16, 65, 85, 2, 22, 96, 122, 114, 100, 39, 23, 68, 23, 80, 68, 4, 22, 126, 124, 23, 30, 80, 27, 23, 80, 29, 16, 84, 31, 23, 115, 121, 114, 66, 31, 100, 38, 125, 117, 34, 98, 23, 113, 120, 99, 44, 99, 31, 73, 24, 13, 81, 22, 113, 96, 120, 123, 66, 83, 82, 19, 84, 94, 5, 83, 89, 81, 78, 22, 53, 127, 114, 49, 116, 16, 65, 22, 23, 18, 71, 68, 7, 69, 82, 18, 68, 89, 18, 95, 67, 87, 104, 95, 6, 10, 94, 7, 17, 113, 47, 114, 23, 18, 23, 22, 66, 64, 88, 17, 90, 111, 18, 70, 82, 81, 104, 95, 6, 23, 121, 44, 101, 16, 40, 120, 23, 18, 23, 22, 66, 23, 23, 67, 17, 24, 50, 115, 123, 119, 116, 98, 66, 94, 83, 67, 119, 98, 46, 123, 23, 69, 88, 68, 9, 68, 71, 6, 82, 16, 54, 126, 114, 96, 114, 22, 17, 67, 86, 23, 84, 16, 40, 120, 23, 26, 5, 26, 66, 4, 27, 67, 4, 25, 72, 31}, "6b77c10a6727", 6);
                case 11:
                    return C0000.decode(new byte[]{98, 51, 117, 32, 48, 125, 23, 20, 94, 19, 15, 75, 71, 6, 82, 65, 55, 125, 99, 67, 86, 4, 10, 93, 69, 2, 69, 8, 11, 86, 10, 4, 84, 15, 1, 74, 86, 23, 88, 14, 10, 19, 6, 67, 102, 41, 33, 106, 114, 67, 88, 5, 89, 7}, "7c1ad8");
                case 12:
                    return C0000.decode(new byte[]{103, 96, 116, 32, 50, 119, 25, 21, 93, 71, 9, 66, 68, 4, 81, 16, 99, 36, 50, 18, 74, 22, 93, 69, 61, 67, 81, 0, 65, 95, 94, 92, 89, 18, 110, 42, 119, 103, 39, 17, 93, 5, 15, 15}, "200af29b25b14a", 0.0f);
                case 13:
                    return C0000.decode(new byte[]{51, 52, 38, 36, 96, 32, 68, 44, 52, 68, 35, 39, 123, 55, 48, 67, 6, 51, 13, 23, 95, 54, 20, 6, 5, 4, 66, 54, 113, 49, 68, 3, 15, 0, 2, 69, 9, 69, 91, 79, 6, 23, 22, 4, 64, 0, 4, 67, 91, 68, 93, 73, 84, 18, 11, 17, 13, 1, 16, 58, 87, 9, 5, 16, 21, 59, 12, 4, 89, 0, 4, 67, 91, 68, 93, 73, 84, 12, 10, 19, 19, 16, 61, 8, 81, 23, 3, 6, 20, 59, 1, 9, 85, 22, 23, 60, 8, 5, 15, 0, 84, 69, 89, 67, 89, 72, 2, 12, 90, 21, 17, 23, 6, 68, 95, 69, 11, 73, 4, 12, 19, 16, 18, 16, 64, 5, 68, 94, 70, 91, 78, 5, 93, 11, 13, 23, 15, 5, 14, 58, 80, 0, 8, 2, 31, 4, 66, 88, 20, 90, 72, 3, 15, 10, 22, 0, 70, 19, 5, 15, 57, 0, 23, 23, 85, 17, 13, 12, 8, 4, 66, 88, 20, 90, 72, 3, 0, 8, 7, 29, 107, 1, 17, 17, 7, 16, 11, 10, 90, 5, 68, 94, 70, 91, 78, 5, 70, 16, 10, 60, 7, 16, 22, 0, 89, 21, 16, 60, 5, 11, 23, 11, 64, 5, 68, 94, 70, 91, 78, 5, 86, 4, 7, 8, 9, 2, 4, 58, 68, 10, 8, 10, 5, 29, 2, 69, 9, 69, 91, 79, 6, 6, 3, 6, 95, 10, 2, 5, 57, 0, 7, 9, 85, 28, 59, 7, 19, 22, 3, 17, 93, 10, 10, 3, 70, 89, 66, 90, 24, 5, 8, 2, 21, 16, 61, 0, 90, 20, 17, 6, 19, 1, 61, 17, 93, 8, 1, 3, 70, 89, 66, 90, 24, 5, 9, 10, 8, 13, 15, 16, 89, 58, 22, 6, 18, 1, 12, 17, 93, 10, 10, 60, 2, 17, 16, 4, 64, 12, 11, 13, 6, 68, 95, 69, 11, 73, 4, 16, 5, 12, 7, 1, 65, 9, 1, 60, 20, 1, 19, 16, 81, 22, 16, 6, 2, 59, 3, 17, 84, 69, 89, 67, 89, 72, 2, 23, 65, 11, 59, 10, 8, 59, 4, 10, 70, 0, 3, 17, 9, 17, 12, 1, 84, 69, 89, 67, 89, 72, 2, 10, 65, 17, 59, 12, 0, 59, 19, 16, 91, 17, 5, 60, 22, 11, 14, 12, 87, 28, 4, 67, 91, 68, 93, 73, 84, 21, 1, 17, 15, 11, 6, 58, 87, 10, 17, 13, 18, 4, 66, 88, 20, 90, 72, 3, 1, 1, 12, 0, 70, 4, 16, 10, 9, 10, 2, 69, 9, 69, 91, 79, 6, 10, 7, 29, 64, 58, 23, 0, 14, 1, 6, 16, 88, 0, 59, 23, 15, 9, 7, 58, 91, 19, 1, 17, 20, 13, 6, 0, 84, 69, 89, 67, 89, 72, 2, 11, 81, 29, 16, 60, 21, 7, 10, 0, 80, 16, 8, 6, 57, 16, 11, 8, 81, 58, 11, 21, 3, 22, 16, 12, 80, 0, 59, 4, 3, 10, 7, 23, 85, 17, 13, 12, 8, 4, 66, 88, 20, 90, 72, 3, 21, 16, 13, 21, 107, 23, 1, 2, 21, 11, 12, 5, 20, 88, 68, 92, 74, 4, 16, 0, 69, 16, 13, 17, 3, 0, 61, 11, 81, 17, 19, 12, 20, 15, 61, 17, 77, 21, 1, 3, 70, 89, 66, 90, 24, 5, 22, 6, 23, 17, 11, 23, 81, 22, 59, 0, 14, 5, 16, 2, 93, 11, 3, 3, 70, 89, 66, 90, 24, 5, 22, 6, 23, 17, 11, 23, 81, 22, 59, 7, 3, 18, 11, 6, 81, 58, 13, 7, 10, 1, 2, 69, 9, 69, 91, 79, 6, 22, 7, 20, 65, 12, 22, 6, 21, 59, 0, 4, 64, 17, 1, 17, 31, 59, 12, 10, 64, 58, 8, 12, 17, 4, 66, 88, 20, 90, 72, 3, 20, 1, 19, 16, 93, 23, 1, 16, 57, 23, 22, 10, 70, 4, 3, 6, 57, 10, 13, 17, 107, 9, 11, 20, 6, 68, 95, 69, 11, 73, 4, 23, 20, 13, 5, 2, 81, 23, 59, 0, 9, 10, 22, 0, 90, 17, 59, 22, 22, 0, 3, 17, 81, 58, 0, 6, 10, 5, 27, 5, 20, 88, 68, 92, 74, 4, 22, 23, 93, 2, 3, 6, 20, 59, 15, 4, 76, 58, 7, 12, 8, 16, 7, 11, 64, 58, 0, 6, 10, 5, 27, 5, 20, 88, 68, 92, 74, 4, 1, 10, 90, 17, 1, 13, 18, 59, 23, 23, 93, 58, 16, 17, 15, 3, 5, 0, 70, 22, 4, 67, 91, 68, 93, 69, 99, 45, 33, 49, 35, 68, 2, 12, 80, 5, 68, 94, 70, 91}, "fdbe4edc", true);
                case 14:
                    return C0000.decode(new byte[]{114, 117, 125, 118, 53, 39, 70, 116, 55, 118, 123, 16, 70, 92, 19, 9, 21, 66, 0, 90, 22, 103, 121, 118, 51, 39, 70, 91, 1, 4, 9}, "6013abf2e9", 0.0f);
                case 15:
                    return C0000.decode(new byte[]{52, 99, 33, 116, 55, 32, 68, 18, 91, 70, 89, 65, 17, 6, 2, 19, 54, 112, 55, 69, 23, 17, 85, 64, 87, 15, 94, 67, 54, 123, 32, 103, 38, 69, 13, 1, 9, 11}, "a3e5cede4422ac", 2);
                case 16:
                    return C0000.decode(new byte[]{49, 103, 39, 120, 96, 114, 19, 20, 14, 64, 88, 17, 20, 82, 0, 25, 103, 114, 103, 67, 18, 70, 92, 18, 59, 69, 6, 88, 71, 88, 93, 67, 92, 18, 112, 35, 55, 114, 67, 110, 124, 114, 125, 67, 18, 70, 82, 22, 1, 10, 82, 25, 96, 127, 118, 45, 65, 3, 19, 39, 40, 100, 38, 25, 25, 5, 6, 85, 65, 119, 125, 38, 72, 23, 16, 77, 85, 67, 86, 94, 84, 18, 100, 42, 33, 101, 38, 25, 93, 83, 14, 92}, "d7c9473ca23b");
                case 17:
                    return C0000.decode(new byte[]{52, 97, 118, 113, 102, 38, 69, 20, 92, 65, 94, 66, 17, 84, 81, 16, 97, 38, 49, 67, 67, 86, 71, 88, 14, 85, 109, 83, 93, 22, 11, 23, 14, 67, 80, 67, 8, 94, 86, 111, 81, 12, 16, 13, 71, 24, 4, 17, 54, 121, 119, 98, 119, 67, 12, 7, 14, 12}, "a1202cec3351", 0.0f);
                case 18:
                    return C0000.decode(new byte[]{98, 51, 112, 116, 54, 125, 70, 79, 92, 65, 83, 64, 18, 6, 2, 23, 100, 38, 96, 21, 13, 77, 18, 72, 70, 71, 5, 12, 66, 52, 41, 114, 101, 38, 20, 92, 6, 5, 89}, "7c45b8f83383bca7", 0);
                case 19:
                    return C0000.decode(new byte[]{108, 99, 115, 39, 100, 32, 19, 19, 94, 68, 82, 64, 71, 3, 83, 69, 96, 33, 101, 22, 85, 82, 68, 18, 111, 0, 93, 21, 68, 83, 76, 86, 104, 18, 89, 8, 86, 89, 14, 22, 110, 123, 114, 52, 117, 69, 90, 0, 12, 9}, "937f0e3d16", 6);
                default:
                    return C0000.decode(new byte[]{102, 51, 118, 121, 55, 38, 69, 19, 92, 69, 94, 23, 64, 82, 80, 67, 97, 125, 55, 67, 23, 17, 93, 104, 84, 16, 68, 82, 94, 19, 70, 103, 0, 12, 16, 10, 71, 10, 71, 17, 94, 104, 82, 23, 70, 93, 14, 19, 17, 59, 80, 88, 64, 10, 68, 28, 2, 67, 101, 112, 38, 49, 32, 68, 90, 83, 8, 91}, "3c28cced375d07", true);
            }
        }
    }

    public /* synthetic */ WorkTagDao_Impl(Object obj, Object obj2, Object obj3) {
        this.__db = obj;
        this.__insertionAdapterOfWorkTag = obj2;
        this.__preparedStmtOfDeleteByWorkSpecId = obj3;
    }

    public void encode(Object obj, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap map = (HashMap) this.__db;
        ProtobufDataEncoderContext protobufDataEncoderContext = new ProtobufDataEncoderContext(byteArrayOutputStream, map, (HashMap) this.__insertionAdapterOfWorkTag, (ObjectEncoder) this.__preparedStmtOfDeleteByWorkSpecId);
        ObjectEncoder objectEncoder = (ObjectEncoder) map.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, protobufDataEncoderContext);
        } else {
            throw new EncodingException(C0000.decode(new byte[]{45, 13, 16, 80, 91, 6, 12, 6, 85, 71, 21, 3, 12, 16, 16}, "cb055e", 0.0f) + obj.getClass());
        }
    }

    public ArrayList getTagsForWorkSpecId(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{48, 115, 40, 119, 34, 54, 21, 115, 42, 101, 48, 123, 47, 33, 97, 23, 23, 87, 3, 18, 39, 48, 122, 122, 67, 65, 11, 64, 10, 22, 84, 80, 67, 97, 44, 119, 51, 39, 21, 64, 12, 68, 15, 109, 18, 18, 80, 84, 60, 95, 0, 15, 94}, "c6d2ab57"), 1);
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

    public void insertTags(String str, Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            WorkTag workTag = new WorkTag((String) it.next(), str);
            WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.__db;
            workDatabase_Impl.assertNotSuspendingTransaction();
            workDatabase_Impl.beginTransaction();
            try {
                ((AnonymousClass1) this.__insertionAdapterOfWorkTag).insert(workTag);
                workDatabase_Impl.setTransactionSuccessful();
                workDatabase_Impl.internalEndTransaction();
            } catch (Throwable th) {
                workDatabase_Impl.internalEndTransaction();
                throw th;
            }
        }
    }

    public void schedule(AutoValue_TransportContext autoValue_TransportContext, int i, boolean z) {
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) this.__preparedStmtOfDeleteByWorkSpecId;
        Context context = (Context) this.__db;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(C0000.decode(new byte[]{82, 93, 91, 64, 1, 92, 83, 84, 71, 89, 85, 65}, "8293b4602503", true));
        Adler32 adler32 = new Adler32();
        String packageName = context.getPackageName();
        String strDecode = C0000.decode(new byte[]{96, 98, 34, 73, 12}, "56dd4888b701de");
        adler32.update(packageName.getBytes(Charset.forName(strDecode)));
        String str = autoValue_TransportContext.backendName;
        String str2 = autoValue_TransportContext.backendName;
        adler32.update(str.getBytes(Charset.forName(strDecode)));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        Priority priority = autoValue_TransportContext.priority;
        adler32.update(byteBufferAllocate.putInt(PriorityMapping.toInt(priority)).array());
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        String strDecode2 = C0000.decode(new byte[]{123, 92, 0, 113, 10, 85, 90, 98, 82, 91, 7, 92, 17, 95, 80, 67}, "13b8d351", 0);
        String strDecode3 = C0000.decode(new byte[]{3, 67, 65, 86, 85, 19, 70, 126, 20, 8, 83, 82, 70}, "b7538c20ae1749", 6);
        if (!z) {
            for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                int i2 = jobInfo.getExtras().getInt(strDecode3);
                if (jobInfo.getId() == value) {
                    if (i2 < i) {
                        break;
                    }
                    Trace.d(strDecode2, C0000.decode(new byte[]{96, 21, 15, 95, 82, 1, 21, 81, 90, 65, 21, 6, 12, 94, 71, 0, 77, 67, 21, 22, 70, 69, 10, 67, 19, 4, 89, 69, 80, 82, 81, 28, 67, 67, 80, 13, 80, 83, 64, 95, 80, 1, 77, 16, 97, 0, 65, 66, 71, 93, 92, 11, 4, 30, 29, 75}, "5ec03e5753"), autoValue_TransportContext);
                    return;
                }
            }
        }
        Cursor cursorRawQuery = ((SQLiteEventStore) ((EventStore) this.__insertionAdapterOfWorkTag)).getDb().rawQuery(C0000.decode(new byte[]{50, 32, 45, 39, 116, 102, 70, 94, 3, 77, 21, 58, 19, 7, 70, 71, 3, 67, 18, 106, 12, 22, 65, 36, 101, 125, 43, 16, 18, 71, 0, 11, 18, 18, 88, 64, 18, 111, 5, 90, 15, 17, 4, 26, 67, 65, 70, 103, 46, 112, 51, 32, 65, 0, 86, 81, 13, 85, 8, 81, 62, 11, 0, 15, 82, 18, 91, 16, 89, 21, 0, 11, 5, 66, 71, 64, 15, 95, 20, 92, 21, 28, 65, 95, 23, 13}, "aeab72f0f5", false), new String[]{str2, String.valueOf(PriorityMapping.toInt(priority))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(autoValue_SchedulerConfig.getScheduleDelay(priority, jLongValue, i));
            Set set = ((AutoValue_SchedulerConfig_ConfigValue) autoValue_SchedulerConfig.values.get(priority)).flags;
            if (set.contains(SchedulerConfig$Flag.NETWORK_UNMETERED)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_CHARGING)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_IDLE)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt(strDecode3, i);
            persistableBundle.putString(C0000.decode(new byte[]{83, 4, 6, 90, 93, 88, 83, 121, 88, 95, 1}, "1ee1867792d6"), str2);
            persistableBundle.putInt(C0000.decode(new byte[]{18, 17, 90, 91, 70, 89, 67, 65}, "bc344078d4", 1), PriorityMapping.toInt(priority));
            if (bArr != null) {
                persistableBundle.putString(C0000.decode(new byte[]{80, 30, 23, 71, 84, 17}, "5fc55b", 7), Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {autoValue_TransportContext, Integer.valueOf(value), Long.valueOf(autoValue_SchedulerConfig.getScheduleDelay(priority, jLongValue, i)), lValueOf, Integer.valueOf(i)};
            if (Log.isLoggable(C0000.decode(new byte[]{99, 98, 16, 88, 76, 92, 90, 85, 75}, "70e685", 0.0f).concat(strDecode2), 3)) {
                String.format(C0000.decode(new byte[]{98, 7, 10, 86, 82, 64, 93, 13, 12, 84, 22, 64, 65, 8, 13, 82, 82, 21, 87, 11, 16, 19, 85, 90, 95, 16, 7, 75, 66, 21, 20, 23, 66, 68, 95, 65, 89, 68, 8, 92, 84, 124, 85, 89, 71, 87, 22, 92, 95, 68, 71, 87, 91, 70, 25, 38, 3, 80, 93, 80, 95, 0, 66, 93, 83, 77, 69, 68, 1, 82, 90, 89, 17, 16, 11, 94, 83, 70, 69, 5, 15, 67, 22, 16, 85, 77, 76, 19, 119, 65, 69, 1, 15, 67, 66, 21, 20, 0}, "1db365"), objArr);
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    public void send(AutoValue_Event autoValue_Event) {
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(0);
        TransportRuntime transportRuntime = (TransportRuntime) this.__preparedStmtOfDeleteByWorkSpecId;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.__db;
        Encoding encoding = (Encoding) this.__insertionAdapterOfWorkTag;
        Scheduler scheduler = transportRuntime.scheduler;
        zzac zzacVarBuilder = AutoValue_TransportContext.builder();
        zzacVarBuilder.setBackendName(autoValue_TransportContext.backendName);
        zzacVarBuilder.zzc = Priority.DEFAULT;
        zzacVarBuilder.zza = autoValue_TransportContext.extras;
        AutoValue_TransportContext autoValue_TransportContextBuild = zzacVarBuilder.build();
        Request request = new Request();
        request.lazyCacheControl = new HashMap();
        request.body = Long.valueOf(transportRuntime.eventClock.getTime());
        request.tags = Long.valueOf(transportRuntime.uptimeClock.getTime());
        request.method = C0000.decode(new byte[]{119, 38, 47, 109, 33, 121, 43, 32, 118, 108, 105, 36, 53, 36, 44, 96, 110, 41, 45, 117, 37, 124, 44, 34}, "1eb2b5be886acab4", false);
        MessagingClientEventExtension messagingClientEventExtension = autoValue_Event.payload;
        WorkTagDao_Impl workTagDao_Impl = ProtoEncoderDoNotUse.ENCODER;
        workTagDao_Impl.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            workTagDao_Impl.encode(messagingClientEventExtension, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        request.headers = new EncodedPayload(encoding, byteArrayOutputStream.toByteArray());
        request.url = null;
        DefaultScheduler defaultScheduler = (DefaultScheduler) scheduler;
        defaultScheduler.executor.execute(new Processor$$ExternalSyntheticLambda1(defaultScheduler, autoValue_TransportContextBuild, transportImpl$$ExternalSyntheticLambda0, request.build()));
    }
}
