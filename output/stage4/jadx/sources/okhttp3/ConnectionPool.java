package okhttp3;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.fragment.app.FragmentActivity;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.profileinstaller.ProfileInstaller$2;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import androidx.room.migration.Migration;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.CoroutineWorker$$ExternalSyntheticLambda0;
import androidx.work.Data;
import androidx.work.SystemClock;
import androidx.work.impl.constraints.WorkConstraintsTracker$areAllConstraintsMet$1;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker24;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.concurrent.DelegatingScheduledFuture;
import com.google.firebase.messaging.ServiceStarter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util$$ExternalSyntheticLambda1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConnectionPool implements ProfileInstaller$DiagnosticsCallback, Factory, OnSuccessListener, OnFailureListener, OnCanceledListener {
    public static volatile ConnectionPool INSTANCE;
    public final /* synthetic */ int $r8$classId;
    public Object delegate;

    public /* synthetic */ ConnectionPool(int i, Object obj) {
        this.$r8$classId = i;
        this.delegate = obj;
    }

    public static void createAllTables(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{113, 102, 119, 117, 55, 112, 25, 100, 36, 118, 40, 115, 25, 127, 116, 20, 124, 123, 55, 21, 124, 104, 44, 103, 48, 101, 25, 86, 118, 81, 66, 81, 13, 81, 92, 94, 6, 77, 4, 22, 17, 86, 69, 91, 64, 95, 60, 70, 73, 85, 6, 107, 13, 82, 89, 22, 102, 113, 106, 96, 67, 123, 118, 100, 69, 122, 49, 122, 117, 26, 18, 84, 66, 70, 6, 71, 92, 65, 16, 93, 23, 95, 77, 83, 109, 93, 86, 84, 67, 97, 124, 104, 49, 20, 42, 121, 109, 22, 124, 97, 126, 120, 79, 21, 105, 98, 44, 121, 37, 100, 96, 22, 121, 113, 107, 28, 3, 66, 86, 66, 14, 107, 23, 70, 92, 85, 109, 93, 86, 84, 79, 21, 89, 64, 23, 81, 22, 83, 72, 67, 91, 71, 91, 64, 6, 106, 80, 84, 5, 29, 72, 22, 127, 121, 96, 113, 123, 115, 45, 21, 114, 117, 60, 28, 4, 65, 86, 68, 89, 107, 65, 68, 6, 86, 102, 89, 1, 84, 77, 22, 107, 115, 116, 113, 96, 113, 45, 118, 124, 99, 69, 84, 51, 89, 75, 93, 97, 68, 87, 87, 3, 29, 89, 89, 1, 84, 77, 22, 118, 120, 18, 97, 98, 112, 34, 97, 124, 16, 38, 117, 55, 117, 120, 114, 119, 20, 125, 122, 67, 113, 124, 124, 32, 96, 33, 22, 122, 119, 97, 119, 115, 112, 38, 21, 21, 16, 35, 123, 54, 115, 112, 113, 124, 20, 121, 113, 58, 29, 89, 64, 23, 81, 22, 83, 72, 67, 91, 71, 91, 64, 6, 106, 80, 84, 5, 29, 68, 100, 124, 112, 119, 102, 119, 122, 32, 112, 106, 16, 5, 99, 11, 68, 82, 101, 66, 81, 81, 84, 75, 85, 80, 84, 5, 29, 68, 121, 119, 22, 103, 100, 118, 117, 55, 112, 25, 115, 36, 103, 39, 119, 125, 115, 18, 123, 124, 20, 39, 112, 117, 117, 49, 113, 68, 117, 120, 101, 113, 117, 118, 113, 67, 28}, "2424c590e4d696"));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{39, 99, 38, 115, 97, 36, 24, 45, 44, 39, 118, 110, 70, 45, 34, 17, 45, 125, 97, 65, 125, 60, 43, 48, 103, 101, 70, 4, 13, 95, 7, 87, 77, 62, 124, 1, 18, 6, 93, 82, 3, 10, 7, 72, 60, 69, 90, 19, 83, 59, 17, 19, 86, 85, 57, 13, 0, 81, 67, 125, 123, 65, 88, 32, 7, 19, 86, 88, 2, 1, 10, 82, 26, 82, 21, 73, 88, 19, 13, 17, 88, 105, 21, 20, 1, 82, 60, 91, 81, 1, 17}, "d1c25a8dbc36fd"));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{33, 98, 114, 35, 96, 115, 66, 121, 121, 38, 113, 110, 66, 121, 113, 66, 122, 121, 54, 16, 114, 58, 125, 101, 54, 99, 23, 2, 93, 88, 6, 85, 79, 61, 112, 83, 18, 85, 89, 6, 81, 88, 1, 73, 104, 18, 70, 83, 16, 85, 70, 23, 93, 69, 11, 68, 82, 61, 93, 82, 2, 16, 120, 44, 20, 86, 38, 85, 71, 7, 90, 82, 7, 94, 84, 27, 84, 22, 74, 80, 71, 16, 81, 68, 7, 65, 66, 11, 71, 95, 22, 85, 104, 11, 80, 86, 75}, "b07b46", 0.0f));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{32, 55, 119, 112, 50, 125, 17, 97, 119, 32, 47, 32, 18, 120, 32, 24, 127, 122, 98, 66, 38, 61, 123, 98, 50, 107, 17, 85, 97, 13, 17, 14, 97, 65, 3, 91, 81, 21, 30, 2, 10, 1, 82, 17, 50, 125, 105, 97, 22, 44, 44, 49, 18, 127, 51, 116, 125, 25, 22, 2, 16, 17, 83, 69, 3, 88, 17, 124, 120, 54, 38, 34, 119, 99, 70, 118, 126, 97, 22, 44, 54, 41, 126, 29, 70, 88, 70, 90, 68, 9, 6, 23, 109, 82, 10, 89, 66, 70, 105, 12, 2, 8, 87, 81, 70, 108, 116, 109, 98, 66, 45, 42, 102, 17, 40, 109, 125, 121, 26, 66, 3, 12, 92, 65, 19, 76, 110, 88, 83, 16, 4, 0, 64, 110, 5, 84, 80, 70, 69, 61, 13, 4, 95, 84, 6, 24, 101, 112, 110, 54, 67, 43, 125, 101, 70, 118, 100, 121, 122, 78, 67, 5, 91, 95, 22, 77, 69, 85, 22, 32, 47, 42, 112, 17, 40, 119, 101, 21, 120, 55, 47, 41, 30, 17, 6, 87, 68, 65, 70, 23, 23, 5, 18, 115, 42, 119, 115, 21, 120, 45, 55, 69, 124, 100, 42, 116, 29, 21, 86, 11, 13, 12, 70, 88, 7, 84, 110, 81, 83, 14, 2, 28, 82, 17, 47, 118, 101, 112, 113, 39, 49, 69, 124, 126, 50, 24, 127, 96, 122, 46, 79, 69, 82, 88, 8, 76, 84, 71, 64, 3, 15, 58, 86, 68, 20, 89, 69, 92, 89, 12, 3, 69, 123, 127, 50, 125, 118, 112, 100, 66, 45, 42, 102, 17, 40, 109, 125, 121, 26, 66, 3, 3, 94, 84, 30, 103, 85, 64, 68, 3, 23, 12, 93, 95, 6, 24, 120, 123, 98, 39, 36, 32, 96, 17, 40, 119, 101, 21, 120, 55, 47, 41, 30, 17, 6, 74, 68, 91, 105, 3, 23, 17, 87, 92, 22, 76, 110, 86, 89, 23, 13, 17, 82, 17, 47, 118, 101, 112, 113, 39, 49, 69, 124, 126, 50, 24, 127, 96, 122, 46, 79, 69, 82, 83, 7, 91, 90, 90, 80, 4, 60, 21, 93, 93, 15, 91, 72, 85, 22, 43, 45, 49, 119, 118, 35, 106, 17, 123, 121, 54, 67, 43, 103, 125, 42, 20, 17, 85, 84, 3, 0, 14, 93, 87, 0, 103, 85, 80, 90, 3, 26, 58, 86, 68, 20, 89, 69, 92, 89, 12, 3, 69, 123, 127, 50, 125, 118, 112, 100, 66, 45, 42, 102, 17, 40, 109, 125, 121, 26, 66, 3, 9, 83, 66, 18, 103, 84, 91, 71, 23, 6, 16, 87, 110, 18, 81, 92, 80, 86, 66, 42, 43, 102, 116, 33, 125, 99, 21, 120, 45, 55, 69, 124, 100, 42, 116, 17, 113, 115, 36, 34, 48, 126, 101, 70, 21, 0, 25, 22, 2, 14, 12, 92, 88, 11, 77, 92, 106, 68, 7, 23, 0, 92, 69, 15, 87, 95, 106, 82, 23, 17, 4, 70, 88, 9, 86, 81, 21, 127, 44, 55, 32, 117, 116, 52, 24, 127, 122, 98, 66, 45, 48, 126, 125, 74, 24, 81, 70, 85, 10, 6, 1, 71, 93, 3, 103, 67, 80, 71, 23, 6, 22, 70, 84, 2, 103, 80, 65, 86, 66, 42, 43, 102, 116, 33, 125, 99, 21, 120, 45, 55, 69, 124, 100, 42, 116, 29, 21, 86, 16, 22, 11, 109, 88, 8, 103, 87, 90, 68, 7, 4, 23, 93, 68, 8, 92, 81, 21, 127, 44, 55, 32, 117, 116, 52, 24, 127, 122, 98, 66, 45, 48, 126, 125, 74, 24, 81, 90, 67, 22, 60, 10, 84, 110, 23, 77, 94, 65, 87, 61, 19, 10, 94, 88, 5, 65, 81, 21, 127, 44, 55, 32, 117, 116, 52, 24, 127, 122, 98, 66, 45, 48, 126, 125, 74, 24, 81, 69, 83, 16, 10, 10, 86, 110, 5, 87, 68, 91, 66, 2, 67, 44, 124, 101, 35, 127, 116, 103, 22, 44, 44, 49, 18, 127, 51, 116, 125, 21, 114, 39, 37, 36, 103, 125, 50, 24, 1, 25, 22, 2, 4, 0, 92, 84, 20, 89, 69, 92, 89, 12, 3, 69, 123, 127, 50, 125, 118, 112, 100, 66, 45, 42, 102, 17, 40, 109, 125, 121, 22, 38, 38, 35, 115, 100, 42, 108, 17, 5, 26, 66, 3, 11, 87, 73, 18, 103, 66, 86, 94, 7, 7, 16, 94, 84, 57, 76, 88, 88, 83, 61, 12, 19, 87, 67, 20, 81, 85, 80, 86, 66, 42, 43, 102, 116, 33, 125, 99, 21, 120, 45, 55, 69, 124, 100, 42, 116, 17, 113, 115, 36, 34, 48, 126, 101, 70, 1, 3, 7, 5, 81, 84, 87, 2, 2, 80, 0, 4, 1, 1, 85, 86, 93, 2, 6, 74, 24, 81, 91, 83, 26, 23, 58, 65, 82, 14, 93, 85, 64, 90, 7, 60, 17, 91, 92, 3, 103, 94, 67, 83, 16, 17, 12, 86, 84, 57, 95, 84, 91, 83, 16, 2, 17, 91, 94, 8, 88, 17, 124, 120, 54, 38, 34, 119, 99, 70, 118, 126, 97, 22, 44, 54, 41, 126, 17, 34, 125, 119, 116, 99, 46, 55, 69, 2, 29, 70, 88, 66, 65, 89, 18, 60, 23, 87, 80, 21, 87, 95, 85, 22, 43, 45, 49, 119, 118, 35, 106, 17, 123, 121, 54, 67, 43, 103, 125, 42, 24, 117, 112, 112, 35, 54, 41, 102, 17, 75, 10, 4, 3, 26, 66, 3, 23, 87, 64, 19, 81, 67, 80, 82, 61, 13, 0, 70, 70, 9, 74, 90, 106, 66, 27, 19, 0, 82, 17, 47, 118, 101, 112, 113, 39, 49, 69, 124, 126, 50, 24, 127, 96, 122, 46, 79, 69, 82, 67, 3, 73, 68, 92, 68, 7, 16, 58, 81, 89, 7, 74, 86, 92, 88, 5, 3, 69, 123, 127, 50, 125, 118, 112, 100, 66, 45, 42, 102, 17, 40, 109, 125, 121, 26, 66, 
        3, 23, 87, 64, 19, 81, 67, 80, 69, 61, 7, 0, 68, 88, 5, 93, 110, 92, 82, 14, 6, 5, 18, 120, 40, 108, 116, 114, 115, 48, 67, 43, 125, 101, 70, 118, 100, 121, 122, 78, 67, 5, 64, 84, 23, 77, 88, 71, 83, 17, 60, 7, 83, 69, 18, 93, 67, 76, 105, 12, 12, 17, 109, 93, 9, 79, 81, 21, 127, 44, 55, 32, 117, 116, 52, 24, 127, 122, 98, 66, 45, 48, 126, 125, 74, 24, 81, 71, 83, 19, 22, 12, 64, 84, 21, 103, 66, 65, 89, 16, 2, 2, 87, 110, 8, 87, 69, 106, 90, 13, 20, 5, 18, 120, 40, 108, 116, 114, 115, 48, 67, 43, 125, 101, 70, 118, 100, 121, 122, 78, 67, 5, 70, 67, 15, 95, 86, 80, 68, 61, 0, 10, 92, 69, 3, 86, 69, 106, 67, 18, 7, 4, 70, 84, 57, 92, 84, 89, 87, 27, 3, 69, 123, 127, 50, 125, 118, 112, 100, 66, 45, 42, 102, 17, 40, 109, 125, 121, 26, 66, 3, 17, 64, 88, 1, 95, 84, 71, 105, 15, 2, 29, 109, 82, 9, 86, 69, 80, 88, 22, 60, 1, 87, 93, 7, 65, 81, 21, 127, 44, 55, 32, 117, 116, 52, 24, 127, 122, 98, 66, 45, 48, 126, 125, 74, 24, 81, 86, 89, 12, 23, 0, 92, 69, 57, 77, 67, 92, 105, 22, 17, 12, 85, 86, 3, 74, 66, 85, 22, 32, 47, 42, 112, 17, 40, 119, 101, 21, 120, 55, 47, 41, 30, 17, 54, 106, 120, 120, 119, 48, 58, 69, 121, 116, 63, 16, 81, 92, 82, 2, 74, 76}, "ce21f8156b", 1));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{39, 100, 116, 117, 96, 39, 22, 45, 42, 115, 112, 110, 68, 127, 119, 20, 122, 45, 98, 68, 33, 111, 124, 101, 48, 101, 17, 84, 93, 12, 82, 1, 28, 104, 98, 89, 22, 93, 98, 68, 81, 1, 105, 23, 7, 95, 80, 82, 17, 90, 84, 107, 70, 7, 71, 17, 1, 68, 65, 83, 0, 105, 80, 64, 84, 66, 121, 42, 68, 87, 98, 89, 22, 93, 98, 68, 81, 1, 86, 68, 76, 87, 70, 85, 12, 83, 85, 65, 88, 7, 105, 22, 1, 70, 64, 83, 23, 66, 84, 80, 107, 3, 66, 4, 77}, "d6144b6dd756", 0.0f));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{115, 55, 118, 120, 100, 124, 21, 113, 126, 33, 118, 97, 16, 112, 115, 24, 126, 42, 103, 25, 117, 97, 124, 107, 100, 54, 19, 89, 89, 87, 81, 93, 72, 58, 100, 86, 66, 82, 102, 72, 85, 6, 108, 85, 81, 74, 65, 103, 85, 11, 66, 76, 85, 76, 80, 103, 68, 12, 94, 92, 80, 25, 122, 118, 16, 5, 100, 86, 66, 82, 102, 72, 85, 6, 83, 25, 24, 89, 89, 89, 67, 17, 108, 92, 94, 72, 64, 93, 69, 0, 108, 77, 89, 84, 80, 88, 25}, "0e390958", false));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{115, 106, 113, 113, 109, 35, 67, 54, 113, 116, 124, 125, 20, 121, 127, 70, 45, 45, 100, 22, 117, 96, 125, 99, 109, 53, 67, 2, 103, 89, 66, 83, 96, 81, 94, 6, 67, 74, 80, 66, 81, 95, 84, 16, 109, 35, 59, 54, 16, 120, 127, 108, 20, 126, 108, 42, 47, 78, 16, 86, 71, 87, 70, 91, 102, 21, 19, 7, 83, 105, 89, 92, 84, 16, 109, 35, 59, 54, 16, 120, 127, 108, 20, 126, 108, 42, 47, 78, 16, 102, 98, 113, 121, 113, 107, 63, 67, 41, 117, 111, 24, 88, 64, 81, 94, 6, 79, 66, 80, 65, 95, 74, 95, 111, 74, 22, 6, 1, 111, 95, 84, 88, 29, 28, 25, 32, 44, 48, 117, 127, 119, 118, 20, 123, 124, 63, 75, 2, 71, 89, 66, 83, 107, 67, 73, 3, 0, 61, 89, 82, 80, 17, 20, 98, 124, 32, 38, 48, 117, 120, 115, 125, 103, 16, 89, 49, 12, 16, 91, 101, 64, 93, 87, 80, 17, 6, 10, 6, 80, 31, 16, 119, 122, 16, 108, 54, 39, 35, 100, 115, 16, 123, 117, 99, 122, 39, 39, 39, 16, 121, 126, 24, 112, 117, 117, 35, 55, 39, 16, 117, 113, 107, 119, 113, 125, 35, 67, 75}, "08409fcb06", 0.0f));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{34, 55, 115, 120, 109, 113, 22, 121, 125, 39, 119, 58, 16, 127, 39, 18, 47, 42, 98, 25, 124, 108, 127, 99, 103, 48, 18, 2, 89, 88, 5, 87, 25, 58, 97, 86, 75, 95, 98, 81, 84, 60, 69, 13, 66, 93, 62, 65, 17, 0, 85, 102, 80, 80, 86, 16, 124, 45, 18, 2, 103, 89, 19, 89, 53, 4, 81, 89, 25, 28, 86, 71, 92, 17, 89, 61, 67, 70, 4, 81, 62, 12, 82, 89, 16}, "ae6994603c2b06a2", true));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{114, 102, 114, 117, 96, 118, 17, 96, 118, 118, 120, 118, 17, 125, 113, 20, 122, 124, 101, 20, 114, 108, 125, 96, 101, 103, 23, 84, 103, 74, 66, 64, 82, 89, 125, 87, 120, 90, 81, 91, 84, 19, 25, 84, 64, 91, 70, 88, 110, 71, 71, 81, 87, 108, 88, 80, 87, 20, 96, 118, 105, 96, 23, 122, 123, 103, 17, 122, 98, 120, 120, 31, 17, 84, 80, 81, 90, 86, 67, 85, 67, 93, 91, 93, 81, 20, 126, 122, 96, 118, 118, 113, 101, 20, 122, 124, 101, 20, 121, 97, 120, 127, 17, 112, 114, 114, 117, 102, 125, 96, 23, 4, 24, 19, 81, 71, 78, 71, 64, 86, 92, 107, 94, 80, 84, 19, 120, 122, 99, 113, 115, 118, 99, 20, 121, 123, 96, 19, 127, 97, 123, 120, 24, 19, 97, 102, 126, 121, 117, 97, 104, 20, 124, 113, 109, 27, 81, 67, 88, 70, 95, 108, 66, 68, 82, 87, 107, 90, 85, 84, 27, 20, 84, 84, 84, 90, 82, 70, 85, 71, 88, 91, 89, 84, 29, 31, 17, 114, 120, 102, 113, 122, 118, 122, 23, 127, 113, 106, 25, 84, 64, 91, 70, 88, 110, 71, 71, 81, 87, 108, 88, 80, 87, 29, 20, 97, 116, 114, 114, 102, 113, 125, 114, 113, 100, 20, 84, 100, 94, 70, 92, 103, 68, 86, 82, 84, 31, 84, 93, 87, 81, 29, 23, 123, 122, 19, 100, 100, 115, 117, 96, 118, 17, 119, 118, 103, 119, 114, 117, 113, 23, 123, 122, 19, 117, 113, 123, 113, 96, 118, 17, 119, 118, 103, 119, 114, 117, 113, 23, 29}, "147443", 6));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{39, 100, 36, 117, 55, 118, 16, 103, 37, 116, 45, 113, 67, 122, 118, 19, 42, 121, 53, 20, 38, 107, 121, 96, 48, 101, 65, 84, 52, 92, 66, 88, 42, 87, 12, 81, 3, 19, 24, 83, 10, 87, 12, 81, 3, 19, 100, 118, 60, 98, 65, 122, 44, 103, 16, 125, 49, 122, 45, 24, 67, 83, 71, 92, 22, 93, 62, 71, 19, 86, 83, 108, 13, 82, 1, 20, 55, 118, 104, 103, 68, 120, 46, 96, 67, 125, 101, 127, 40, 26, 65, 100, 49, 122, 125, 114, 54, 111, 65, 127, 38, 106, 24, 83, 10, 87, 12, 81, 3, 31, 16, 83, 19, 89, 19, 95, 60, 64, 64, 86, 7, 105, 8, 80, 3, 26, 28, 19, 34, 121, 51, 113, 42, 116, 126, 19, 47, 115, 56, 28, 3, 68, 95, 65, 15, 105, 18, 68, 6, 80, 111, 90, 0, 86, 72, 20, 49, 118, 118, 118, 54, 115, 47, 119, 38, 96, 16, 83, 51, 89, 19, 95, 48, 67, 85, 80, 4, 30, 1, 93, 7, 83, 25, 19, 43, 120, 65, 97, 51, 119, 113, 103, 33, 22, 34, 117, 48, 112, 113, 119, 33, 22, 46, 122, 67, 119, 117, 127, 33, 98, 36, 20, 32, 114, 99, 112, 37, 114, 36, 20, 74}, "d6a4c303", 0.0f));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{115, 106, 119, 118, 100, 116, 18, 127, 124, 116, 33, 60, 16, 113, 116, 23, 126, 126, 102, 22, 119, 104, 45, 55, 100, 107, 18, 87, 89, 95, 86, 83, 74, 111, 51, 11, 66, 83, 124, 86, 93, 84, 109, 65, 93, 66, 15, 59, 67, 72, 87, 84, 111, 88, 86, 86, 18, 127, 42, 68, 80, 111, 93, 69, 91, 127, 83, 91, 87, 80, 68, 76, 80, 79, 93, 69, 91, 110, 65, 70, 87, 83, 59, 13, 84, 88, 27}, "0827012620dd"));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{118, 101, 38, 35, 109, 116, 23, 108, 36, 36, 121, 114, 67, 43, 127, 17, 121, 119, 49, 70, 112, 111, 42, 49, 109, 98, 23, 88, 50, 9, 71, 92, 51, 16, 86, 86, 69, 93, 22, 21, 85, 23, 75, 2, 78, 94, 69, 83, 58, 21, 69, 82, 0, 61, 80, 85, 87, 24, 49, 35, 109, 99, 67, 44, 118, 101, 23, 118, 48, 42, 121, 27, 67, 2, 73, 67, 88, 95, 23, 3, 70, 68, 3, 66, 123, 125, 120, 122, 69, 40, 122, 99, 67, 44, 108, 125, 123, 20, 69, 54, 103, 126, 46, 35, 107, 104, 23, 115, 32, 63, 29, 87, 20, 13, 75, 90, 104, 75, 21, 3, 86, 104, 10, 6, 89, 24, 27, 24, 35, 41, 103, 114, 42, 37, 119, 17, 124, 125, 60, 78, 85, 64, 12, 16, 82, 110, 68, 72, 0, 5, 106, 94, 7, 2, 16, 17, 101, 125, 35, 35, 103, 114, 45, 33, 124, 98, 23, 88, 50, 9, 71, 92, 48, 18, 92, 82, 87, 16, 5, 15, 81, 87, 74, 66, 118, 127, 23, 109, 53, 34, 116, 99, 38, 66, 122, 112, 100, 123, 36, 34, 112, 23, 44, 44, 25, 117, 114, 116, 32, 50, 112, 23, 32, 35, 106, 114, 118, 124, 32, 70, 28}, "57cb9178ef", false));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{37, 54, 35, 121, 97, 119, 70, 102, 121, 116, 117, 115, 67, 113, 112, 23, 40, 43, 50, 24, 112, 106, 47, 97, 108, 101, 25, 86, 51, 74, 83, 81, 3, 22, 3, 86, 86, 87, 6, 18, 16, 86, 82, 83, 26, 88, 22, 99, 35, 60, 50, 24, 123, 125, 50, 18, 118, 99, 117, 122, 79, 24, 86, 91, 9, 10, 1, 103, 67, 83, 10, 71, 93, 86, 25, 127, 45, 108, 115, 112, 35, 54, 74, 24, 101, 96, 47, 127, 121, 100, 96, 22, 40, 125, 111, 31, 6, 15, 3, 65, 85, 27, 79}, "fdf852f28696c867", 0.0f));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{122, 101, 33, 121, 96, 118, 20, 96, 37, 35, 120, 117, 18, 126, 115, 20, 119, 120, 48, 24, 113, 107, 125, 103, 48, 50, 20, 66, 93, 88, 88, 107, 84, 86, 23, 76, 81, 65, 107, 64, 5, 3, 88, 85, 18, 31, 92, 80, 25, 126, 42, 108, 113, 116, 113, 102, 68, 49, 102, 121, 127, 118, 103, 109, 25, 124, 33, 97, 24, 90, 80, 81, 10, 21, 93, 68, 75, 104, 93, 85, 74, 95, 68, 108, 113, 107, 96, 29}, "97d84344da402754"));
        frameworkSQLiteDatabase.execSQL(C0000.decode(new byte[]{127, 120, 106, 125, 48, 108, 68, 120, 55, 69, 100, 115, 105, 116, 35, 123, 33, 23, 44, 43, 98, 121, 25, 74, 13, 87, 9, 104, 8, 4, 69, 66, 92, 74, 61, 76, 5, 85, 9, 0, 22, 30, 80, 92, 78, 81, 0, 82, 11, 17, 95, 66, 64, 103, 10, 89, 23, 95, 76, 69, 96, 119, 117, 109, 39, 107, 76, 3, 87, 73, 22, 17, 14, 92, 85, 11, 0, 5, 84, 3, 7, 84, 93, 0, 80, 91, 93, 82, 80, 87, 0, 14, 91, 14, 6, 91, 2, 14, 3, 1, 83, 4, 90, 90, 69, 17}, "6698b8d7ee", 0.0f));
    }

    public static boolean isNotification(Bundle bundle) {
        String strDecode = C0000.decode(new byte[]{80, 2, 9, 25, 89, 77, 6}, "7ad77cc479b4f2", 0.0f);
        String string = bundle.getString(strDecode);
        String strDecode2 = C0000.decode(new byte[]{0}, "1dc3c2b586b1", true);
        return strDecode2.equals(string) || strDecode2.equals(bundle.getString(strDecode.replace(C0000.decode(new byte[]{2, 86, 93, 22, 94, 30}, "e508008752fcfafe"), C0000.decode(new byte[]{87, 90, 8, 26, 8, 11, 71, 80, 86, 80, 6, 85, 18, 13, 92, 87, 30}, "09e4fd39", true))));
    }

    public static zzu onValidateSchema(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        HashMap map = new HashMap(2);
        TableInfo.Column column = new TableInfo.Column(C0000.decode(new byte[]{22, 87, 16, 95, 60, 16, 70, 93, 81, 105, 15, 83}, "a8b4cc6826f7", 5), C0000.decode(new byte[]{103, 32, 106, 109}, "3e29e623c1e99fd7"), true, 1, null, 1);
        String strDecode = C0000.decode(new byte[]{20, 95, 64, 91, 108, 64, 20, 0, 82, 107, 94, 5}, "c02033de147a4c", 0.0f);
        map.put(strDecode, column);
        TableInfo.Column column2 = new TableInfo.Column(C0000.decode(new byte[]{69, 20, 80, 69, 92, 65, 65, 10, 75, 91, 64, 92, 104, 13, 82}, "5f57904c82497d6d"), C0000.decode(new byte[]{99, 112, 104, 50}, "750f1f948f", 0.0f), true, 2, null, 1);
        String strDecode2 = C0000.decode(new byte[]{64, 22, 83, 16, 83, 68, 66, 13, 16, 13, 68, 1, 105, 11, 82}, "0d6b657dcd", true);
        map.put(strDecode2, column2);
        HashSet hashSet = new HashSet(2);
        List listAsList = Arrays.asList(strDecode);
        String strDecode3 = C0000.decode(new byte[]{94, 93}, "79494f935be7", true);
        hashSet.add(new TableInfo.ForeignKey(C0000.decode(new byte[]{54, 92, 20, 14, 53, 20, 86, 84}, "a3fefd3738cb03", 6), C0000.decode(new byte[]{117, 118, 48, 39, 37, 32, 113}, "67cddd49", true), C0000.decode(new byte[]{37, 112, 98, 33, 118, 117, 124}, "f11b719f", 0), listAsList, Arrays.asList(strDecode3)));
        hashSet.add(new TableInfo.ForeignKey(C0000.decode(new byte[]{51, 91, 69, 10, 50, 65, 83, 82}, "d47aa1611091fb"), C0000.decode(new byte[]{114, 118, 54, 116, 37, 124, 116}, "17e7d812", 0.0f), "CASCADE", Arrays.asList(strDecode2), Arrays.asList(strDecode3)));
        HashSet hashSet2 = new HashSet(2);
        List listAsList2 = Arrays.asList(strDecode);
        String strDecode4 = C0000.decode(new byte[]{116, 102, 38}, "55e00399ce42", 1);
        hashSet2.add(new TableInfo.Index(C0000.decode(new byte[]{90, 11, 87, 6, 30, 104, 33, 85, 69, 0, 87, 5, 93, 87, 80, 28, 108, 18, 92, 17, 13, 104, 22, 64, 80, 6, 102, 8, 92}, "3e3cf7e05e9a893e", 0.0f), false, listAsList2, Arrays.asList(strDecode4)));
        hashSet2.add(new TableInfo.Index(C0000.decode(new byte[]{80, 87, 81, 1, 74, 60, 125, 92, 69, 1, 92, 7, 92, 87, 86, 29, 109, 19, 75, 92, 71, 1, 67, 22, 80, 74, 92, 16, 87, 60, 80, 93}, "995d2c", true), false, Arrays.asList(strDecode2), Arrays.asList(strDecode4)));
        String strDecode5 = C0000.decode(new byte[]{115, 4, 66, 4, 93, 5, 92, 8, 84, 24}, "7a2a3a9f", 0.0f);
        TableInfo tableInfo = new TableInfo(strDecode5, map, hashSet, hashSet2);
        TableInfo tableInfo2 = TableInfo.read(frameworkSQLiteDatabase, strDecode5);
        boolean zEquals = tableInfo.equals(tableInfo2);
        String strDecode6 = C0000.decode(new byte[]{56, 69, 126, 91, 23, 12, 83, 92, 108}, "2e84bb7ff340", true);
        if (!zEquals) {
            return new zzu(false, C0000.decode(new byte[]{33, 85, 67, 3, 15, 93, 83, 86, 81, 29, 16, 86, 8, 2, 23, 95, 90, 2, 25, 23, 65, 87, 64, 15, 22, 94, 11, 22, 9, 30, 94, 9, 5, 92, 90, 22, 118, 1, 72, 82, 8, 2, 0, 94, 80, 31, 72, 23, 60, 24, 119, 28, 72, 82, 5, 18, 0, 84, 9, 108}, "e03fa9682d87ff", false) + tableInfo + strDecode6 + tableInfo2);
        }
        HashMap map2 = new HashMap(30);
        map2.put(strDecode3, new TableInfo.Column(C0000.decode(new byte[]{11, 93}, "b9ef3071", 3), "TEXT", true, 1, null, 1));
        map2.put(C0000.decode(new byte[]{69, 66, 5, 21, 7}, "66dab6ba", false), new TableInfo.Column("state", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{71, 91, 16, 9, 3, 65, 58, 2, 95, 87, 70, 71, 103, 87, 80, 12, 85}, "04bbf3ea3654891a", 0.0f), new TableInfo.Column("worker_class_name", "TEXT", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{88, 15, 20, 69, 69, 57, 89, 7, 75, 81, 84, 19, 59, 83, 93, 7, 71, 17, 102, 88, 80, 12, 1}, "1ad01f4b96", 0.0f), new TableInfo.Column(C0000.decode(new byte[]{15, 94, 66, 70, 68, 109, 89, 93, 20, 87, 87, 65, 111, 81, 88, 89, 21, 67, 109, 93, 81, 95, 81}, "f0230248", true), "TEXT", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{93, 11, 65, 17, 17}, "4e1de9c7a5c750", 0), new TableInfo.Column("input", "BLOB", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{93, 16, 21, 64, 68, 70}, "2ea012bb4c3fba1a"), new TableInfo.Column("output", "BLOB", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{88, 94, 8, 23, 92, 82, 89, 62, 92, 93, 93, 81, 24}, "10ac535a88", 0.0f), new TableInfo.Column(C0000.decode(new byte[]{92, 93, 91, 66, 92, 85, 94, 59, 80, 0, 88, 81, 77}, "5326542d4e4044", 0.0f), "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{88, 94, 17, 87, 71, 23, 86, 14, 110, 84, 16, 64, 84, 21, 94, 13, 95}, "10e25a7b", 3), new TableInfo.Column("interval_duration", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{87, 95, 4, 27, 103, 87, 64, 16, 80, 18, 10, 91, 90}, "13ac835b1fc44a", true), new TableInfo.Column("flex_duration", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{74, 67, 91, 102, 89, 22, 71, 80, 85, 18, 64, 102, 91, 89, 64, 87, 76}, "86598b358b49", 0.0f), new TableInfo.Column(C0000.decode(new byte[]{19, 64, 12, 62, 85, 77, 71, 7, 11, 20, 67, 58, 2, 90, 23, 15, 64}, "a5ba493bfd7e", 2), "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{4, 83, 90, 89, 88, 81, 83, 62, 67, 11, 85, 11, 80, 76}, "f292775a3d9b35a5", 7), new TableInfo.Column("backoff_policy", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{91, 3, 83, 90, 9, 87, 4, 62, 93, 1, 93, 0, 64, 60, 92, 70, 75, 3, 68, 88, 9, 95}, "9b01f1ba9d1a9c83", false), new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, null, 1));
        TableInfo.Column column3 = new TableInfo.Column(C0000.decode(new byte[]{88, 5, 71, 66, 62, 81, 15, 70, 20, 83, 23, 4, 57, 18, 12, 8, 81}, "4d46a4a7a6baffee", 2), "INTEGER", true, 0, "-1", 1);
        String strDecode7 = C0000.decode(new byte[]{91, 88, 17, 71, 110, 4, 89, 67, 17, 1, 22, 92, 57, 77, 93, 12, 82}, "79b31a72ddc9f94a");
        map2.put(strDecode7, column3);
        map2.put(C0000.decode(new byte[]{90, 91, 8, 89, 84, 23, 9, 57, 74, 87, 22, 4, 94, 77, 8, 93, 89, 109, 2, 69, 75, 3, 16, 15, 87, 92}, "72f09bdf82ba09a2"), new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, null, 1));
        TableInfo.Column column4 = new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, null, 1);
        String strDecode8 = C0000.decode(new byte[]{22, 87, 91, 82, 82, 17, 15, 93, 58, 70, 86, 70, 67, 1, 16, 76, 0, 80, 108, 86, 66}, "e4376dc8", true);
        map2.put(strDecode8, column4);
        map2.put(C0000.decode(new byte[]{75, 16, 91, 104, 90, 90, 110, 85, 86, 23, 80, 80, 65, 91, 68, 93, 93}, "9e573413", 0.0f), new TableInfo.Column(C0000.decode(new byte[]{22, 71, 87, 59, 94, 10, 103, 80, 95, 17, 93, 4, 22, 88, 16, 15, 0}, "d29d7d860c8cd7ea", 4), "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{89, 64, 66, 110, 12, 84, 105, 19, 20, 90, 66, 84, 105, 65, 12, 94, 95, 1, 24}, "6561c26ba5", true), new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{69, 81, 20, 11, 11, 0, 106, 87, 9, 23, 10, 16}, "54fbdd", 7), new TableInfo.Column("period_count", "INTEGER", true, 0, "0", 1));
        TableInfo.Column column5 = new TableInfo.Column(C0000.decode(new byte[]{3, 6, 86, 7, 19, 85, 16, 10, 87, 12}, "dc8ba4", 0.0f), "INTEGER", true, 0, "0", 1);
        String strDecode9 = C0000.decode(new byte[]{2, 87, 87, 92, 64, 5, 68, 8, 10, 92}, "e2992d0a", 6);
        map2.put(strDecode9, column5);
        map2.put(C0000.decode(new byte[]{91, 81, 74, 76, 58, 64, 86, 92, 87, 92, 16, 95, 80, 107, 70, 81, 8, 86, 106, 91, 68, 93, 23, 65, 92, 80, 87}, "5428e3", 6), new TableInfo.Column("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
        map2.put(C0000.decode(new byte[]{91, 82, 28, 69, 109, 75, 86, 95, 1, 85, 71, 84, 80, 104, 16, 88, 95, 93, 106, 88, 18, 84, 64, 74, 92, 83, 1, 110, 85, 93, 91, 82, 22, 80, 70, 81, 90, 89}, "57d128", 0.0f), new TableInfo.Column("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
        map2.put(C0000.decode(new byte[]{22, 68, 87, 67, 103, 74, 4, 80, 64, 89, 11}, "e08388a136", 0.0f), new TableInfo.Column(C0000.decode(new byte[]{69, 68, 13, 22, 57, 68, 1, 7, 74, 13, 90}, "60bff6df9b4079", false), "INTEGER", true, 0, "-256", 1));
        map2.put(C0000.decode(new byte[]{16, 85, 20, 76, 91, 68, 1, 5, 61, 94, 0, 77, 69, 89, 22, 10, 61, 68, 28, 73, 87}, "b0e926da"), new TableInfo.Column("required_network_type", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{68, 3, 67, 70, 15, 17, 81, 67, 103, 90, 90, 89, 22, 5, 95, 95, 81}, "6f23fc408928db61", 0.0f), new TableInfo.Column("requires_charging", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{17, 93, 68, 71, 80, 64, 84, 18, 60, 92, 80, 68, 80, 81, 84, 62, 10, 92, 89, 87}, "c852921a"), new TableInfo.Column(C0000.decode(new byte[]{23, 81, 70, 70, 90, 65, 86, 21, 110, 6, 93, 71, 80, 87, 93, 109, 12, 80, 91, 86}, "e473333f1b819482", 0.0f), "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{23, 3, 66, 22, 11, 74, 87, 22, 102, 87, 80, 65, 17, 3, 65, 26, 61, 86, 93, 17, 102, 89, 94, 66}, "ef3cb82e9515", 6), new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{19, 83, 69, 64, 95, 23, 80, 70, 61, 74, 17, 89, 66, 7, 6, 83, 107, 91, 89, 17, 106, 89, 13, 78}, "a6456e55b9e60f"), new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{17, 22, 94, 80, 85, 82, 70, 105, 83, 95, 13, 16, 7, 95, 17, 59, 66, 71, 86, 86, 64, 83, 111, 84, 6, 8, 3, 72}, "ed77274600cdb1", false), new TableInfo.Column(C0000.decode(new byte[]{17, 19, 80, 82, 87, 83, 64, 105, 90, 11, 11, 21, 92, 91, 68, 105, 71, 70, 93, 5, 17, 4, 102, 81, 85, 90, 83, 79}, "ea9506269d"), "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{76, 71, 8, 86, 2, 6, 74, 106, 12, 80, 29, 60, 91, 90, 15, 69, 0, 13, 76, 106, 5, 84, 9, 2, 65}, "85a1ec", 0.0f), new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
        map2.put(C0000.decode(new byte[]{85, 13, 15, 23, 84, 87, 21, 106, 23, 74, 15, 105, 18, 17, 95, 5, 6, 6, 67, 74}, "6bac19a5b8f6fc", 7), new TableInfo.Column("content_uri_triggers", "BLOB", true, 0, null, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new TableInfo.Index(C0000.decode(new byte[]{11, 89, 0, 80, 72, 58, 98, 14, 16, 92, 55, 69, 85, 6, 106, 18, 1, 95, 1, 81, 69, 9, 80, 62, 16, 82, 21, 64, 85, 22, 65, 4, 6, 104, 5, 65}, "b7d50e5a", true), false, Arrays.asList(strDecode8), Arrays.asList(strDecode4)));
        hashSet4.add(new TableInfo.Index(C0000.decode(new byte[]{80, 93, 85, 0, 75, 58, 53, 14, 20, 95, 55, 19, 87, 90, 102, 95, 80, 22, 71, 58, 7, 15, 23, 65, 1, 22, 87, 102, 77, 90, 92, 0}, "931e3ebaf4dc29", 5), false, Arrays.asList(strDecode7), Arrays.asList(strDecode4)));
        String strDecode10 = C0000.decode(new byte[]{54, 88, 22, 90, 97, 17, 6, 82}, "a7d12ac1aa87f01a", 0.0f);
        TableInfo tableInfo3 = new TableInfo(strDecode10, map2, hashSet3, hashSet4);
        TableInfo tableInfo4 = TableInfo.read(frameworkSQLiteDatabase, strDecode10);
        if (!tableInfo3.equals(tableInfo4)) {
            return new zzu(false, C0000.decode(new byte[]{100, 11, 22, 92, 100, 71, 92, 84, 30, 84, 88, 0, 75, 92, 90, 0, 28, 25, 64, 88, 75, 92, 24, 92, 91, 20, 85, 29, 94, 11, 0, 82, 91, 25, 110, 88, 68, 94, 101, 20, 92, 80, 26, 74, 110, 23, 114, 79, 73, 82, 85, 65, 83, 0, 3, 57}, "3dd77797656d93") + tableInfo3 + strDecode6 + tableInfo4);
        }
        HashMap map3 = new HashMap(2);
        map3.put(C0000.decode(new byte[]{69, 5, 6}, "1daa72a5"), new TableInfo.Column(C0000.decode(new byte[]{23, 86, 1}, "c7f4d4ebd3", 0.0f), "TEXT", true, 1, null, 1));
        map3.put(strDecode, new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new TableInfo.ForeignKey(C0000.decode(new byte[]{111, 11, 70, 94, 97, 72, 6, 84}, "8d4528c7", 7), "CASCADE", "CASCADE", Arrays.asList(strDecode), Arrays.asList(strDecode3)));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new TableInfo.Index(C0000.decode(new byte[]{93, 10, 84, 0, 72, 103, 53, 89, 70, 15, 100, 4, 87, 103, 21, 89, 70, 15, 111, 22, 64, 93, 1, 105, 93, 0}, "4d0e08b6", true), false, Arrays.asList(strDecode), Arrays.asList(strDecode4)));
        String strDecode11 = C0000.decode(new byte[]{99, 90, 74, 14, 100, 2, 84}, "458e0c30f9a4");
        TableInfo tableInfo5 = new TableInfo(strDecode11, map3, hashSet5, hashSet6);
        TableInfo tableInfo6 = TableInfo.read(frameworkSQLiteDatabase, strDecode11);
        if (!tableInfo5.equals(tableInfo6)) {
            return new zzu(false, C0000.decode(new byte[]{51, 86, 17, 9, 97, 85, 3, 30, 5, 92, 2, 16, 90, 13, 0, 65, 77, 21, 90, 70, 15, 24, 13, 95, 22, 14, 27, 9, 11, 93, 6, 14, 27, 99, 11, 68, 15, 102, 7, 5, 28, 74, 110, 25, 38, 26, 69, 81, 7, 66, 1, 86, 92, 104}, "d9cb54d6d2fb5d", false) + tableInfo5 + strDecode6 + tableInfo6);
        }
        HashMap map4 = new HashMap(3);
        map4.put(strDecode, new TableInfo.Column(C0000.decode(new byte[]{18, 90, 74, 13, 62, 16, 19, 82, 80, 103, 88, 93}, "e58facc7381909", 1), "TEXT", true, 1, null, 1));
        map4.put(strDecode9, new TableInfo.Column("generation", "INTEGER", true, 2, "0", 1));
        map4.put(C0000.decode(new byte[]{21, 77, 22, 22, 4, 94, 59, 11, 5}, "f4eba3dbab6b", 0.0f), new TableInfo.Column("system_id", "INTEGER", true, 0, null, 1));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new TableInfo.ForeignKey(C0000.decode(new byte[]{97, 91, 16, 91, 48, 68, 6, 5}, "64b0c4cf1fd7", 0.0f), "CASCADE", "CASCADE", Arrays.asList(strDecode), Arrays.asList(strDecode3)));
        HashSet hashSet8 = new HashSet(0);
        String strDecode12 = C0000.decode(new byte[]{106, 72, 65, 70, 84, 91, 47, 93, 113, 93, 2, 88}, "912216f983d79e03", false);
        TableInfo tableInfo7 = new TableInfo(strDecode12, map4, hashSet7, hashSet8);
        TableInfo tableInfo8 = TableInfo.read(frameworkSQLiteDatabase, strDecode12);
        if (!tableInfo7.equals(tableInfo8)) {
            return new zzu(false, C0000.decode(new byte[]{101, 29, 67, 71, 3, 15, 45, 7, 42, 11, 84, 13, 28, 85, 88, 0, 66, 92, 15, 6, 28, 77, 20, 10, 64, 9, 26, 93, 91, 20, 92, 29, 11, 13, 0, 6, 15, 75, 97, 27, 71, 64, 83, 9, 121, 87, 47, 12, 2, 12, 74, 75, 56, 66, 113, 76, 70, 1, 83, 71, 3, 6, 94, 105}, "6d03fbdcce2b44", true) + tableInfo7 + strDecode6 + tableInfo8);
        }
        HashMap map5 = new HashMap(2);
        map5.put(C0000.decode(new byte[]{11, 83, 8, 1}, "e2ed11a1", 0.0f), new TableInfo.Column(C0000.decode(new byte[]{12, 3, 14, 86}, "bbc392", 0.0f), "TEXT", true, 1, null, 1));
        map5.put(strDecode, new TableInfo.Column("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new TableInfo.ForeignKey(C0000.decode(new byte[]{96, 12, 67, 14, 98, 70, 92, 80}, "7c1e16930f0e86b4", 1), "CASCADE", "CASCADE", Arrays.asList(strDecode), Arrays.asList(strDecode3)));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new TableInfo.Index(C0000.decode(new byte[]{90, 8, 82, 6, 28, 107, 96, 88, 65, 93, 126, 2, 84, 85, 108, 17, 89, 17, 15, 107, 68, 71, 86, 85, 111, 10, 93}, "3f6cd477360c90", 0.0f), false, Arrays.asList(strDecode), Arrays.asList(strDecode4)));
        String strDecode13 = C0000.decode(new byte[]{101, 93, 17, 93, 126, 89, 95, 87}, "22c608", 0.0f);
        TableInfo tableInfo9 = new TableInfo(strDecode13, map5, hashSet9, hashSet10);
        TableInfo tableInfo10 = TableInfo.read(frameworkSQLiteDatabase, strDecode13);
        if (!tableInfo9.equals(tableInfo10)) {
            return new zzu(false, C0000.decode(new byte[]{103, 12, 71, 93, 118, 2, 95, 6, 74, 85, 93, 87, 66, 12, 92, 82, 64, 77, 69, 12, 16, 95, 29, 90, 93, 19, 89, 24, 85, 12, 86, 6, 14, 26, 100, 92, 66, 8, 123, 87, 85, 6, 27, 77, 104, 20, 118, 75, 64, 6, 86, 66, 93, 7, 8, 105}, "0c568c2cb433") + tableInfo9 + strDecode6 + tableInfo10);
        }
        HashMap map6 = new HashMap(2);
        map6.put(strDecode, new TableInfo.Column(C0000.decode(new byte[]{71, 12, 68, 15, 104, 18, 18, 0, 90, 103, 89, 7}, "0c6d7abe98", 0), "TEXT", true, 1, null, 1));
        map6.put(C0000.decode(new byte[]{67, 68, 10, 85, 70, 7, 64, 69}, "36e24b", false), new TableInfo.Column("progress", "BLOB", true, 0, null, 1));
        HashSet hashSet11 = new HashSet(1);
        hashSet11.add(new TableInfo.ForeignKey(C0000.decode(new byte[]{99, 93, 65, 92, 55, 19, 1, 91}, "4237dcd8", 4), "CASCADE", "CASCADE", Arrays.asList(strDecode), Arrays.asList(strDecode3)));
        HashSet hashSet12 = new HashSet(0);
        String strDecode14 = C0000.decode(new byte[]{111, 94, 17, 13, 97, 69, 91, 2, 17, 86, 75, 70}, "81cf174ec38569bb", true);
        TableInfo tableInfo11 = new TableInfo(strDecode14, map6, hashSet11, hashSet12);
        TableInfo tableInfo12 = TableInfo.read(frameworkSQLiteDatabase, strDecode14);
        if (!tableInfo11.equals(tableInfo12)) {
            return new zzu(false, C0000.decode(new byte[]{50, 10, 16, 95, 100, 20, 10, 2, 16, 81, 71, 21, 77, 4, 12, 80, 70, 9, 12, 1, 26, 26, 67, 9, 23, 14, 76, 93, 89, 22, 9, 75, 15, 91, 80, 3, 9, 75, 53, 91, 70, 13, 53, 23, 13, 83, 70, 3, 22, 22, 75, 26, 62, 70, 32, 29, 18, 81, 87, 18, 0, 1, 88, 62}, "eeb44f") + tableInfo11 + strDecode6 + tableInfo12);
        }
        HashMap map7 = new HashMap(2);
        map7.put(C0000.decode(new byte[]{94, 92, 31}, "59f14d77a7", 0.0f), new TableInfo.Column(C0000.decode(new byte[]{92, 83, 29}, "76d0a5ae945d93", false), "TEXT", true, 1, null, 1));
        map7.put(C0000.decode(new byte[]{10, 14, 95, 6, 103, 66, 7, 10, 19, 4}, "fa1a84ff", false), new TableInfo.Column("long_value", "INTEGER", false, 0, null, 1));
        HashSet hashSet13 = new HashSet(0);
        HashSet hashSet14 = new HashSet(0);
        String strDecode15 = C0000.decode(new byte[]{52, 64, 83, 4, 84, 71, 1, 92, 85, 7}, "d26b15", 5);
        TableInfo tableInfo13 = new TableInfo(strDecode15, map7, hashSet13, hashSet14);
        TableInfo tableInfo14 = TableInfo.read(frameworkSQLiteDatabase, strDecode15);
        if (tableInfo13.equals(tableInfo14)) {
            return new zzu(true, (String) null);
        }
        return new zzu(false, C0000.decode(new byte[]{52, 16, 1, 94, 7, 22, 3, 86, 90, 1, 31, 80, 95, 1, 66, 92, 13, 6, 28, 22, 21, 11, 20, 83, 23, 13, 90, 65, 93, 75, 93, 92, 0, 7, 8, 22, 50, 22, 3, 94, 92, 22, 82, 95, 82, 0, 25, 29, 110, 66, 33, 64, 18, 1, 5, 76, 92, 0, 13, 59}, "dbd8bdf89d711e03", 5) + tableInfo13 + strDecode6 + tableInfo14);
    }

    public static void userFriendlyKey(String str) {
        if (str.startsWith(C0000.decode(new byte[]{87, 5, 14, 76, 11, 28}, "0fcbe23ddf7ac536", true))) {
            str.substring(6);
        }
    }

    public void addMigrations(Migration... migrationArr) {
        for (Migration migration : migrationArr) {
            int i = migration.startVersion;
            int i2 = migration.endVersion;
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.delegate;
            Integer numValueOf = Integer.valueOf(i);
            Object treeMap = linkedHashMap.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                linkedHashMap.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i2))) {
                Objects.toString(treeMap2.get(Integer.valueOf(i2)));
                migration.toString();
            }
            treeMap2.put(Integer.valueOf(i2), migration);
        }
    }

    public boolean areAllConstraintsMet(WorkSpec workSpec) {
        List list = (List) this.delegate;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            ConstraintController constraintController = (ConstraintController) obj;
            if (constraintController.hasConstraint(workSpec) && constraintController.isConstrained(constraintController.tracker.readSystemState())) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            SystemClock systemClock = SystemClock.get();
            int i = WorkConstraintsTrackerKt.$r8$clinit;
            CollectionsKt.joinToString$default(arrayList, null, WorkConstraintsTracker$areAllConstraintsMet$1.INSTANCE, 31);
            systemClock.getClass();
        }
        return arrayList.isEmpty();
    }

    public Headers build() {
        return new Headers((String[]) ((ArrayList) this.delegate).toArray(new String[0]));
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 11:
                return new WorkTagDao_Impl((Context) ((ConnectionPool) this.delegate).delegate, new ProfileInstaller$2(), new ByteString.Companion());
            default:
                return this.delegate;
        }
    }

    public boolean getBoolean(String str) {
        String string = getString(str);
        return C0000.decode(new byte[]{83}, "b5e6574c33763af3", false).equals(string) || Boolean.parseBoolean(string);
    }

    public Integer getInteger(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException unused) {
            userFriendlyKey(str);
            return null;
        }
    }

    public JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONArray(string);
        } catch (JSONException unused) {
            userFriendlyKey(str);
            return null;
        }
    }

    public String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String[] strArr;
        String string = getString(str2);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strDecode = C0000.decode(new byte[]{107, 85, 94, 80, 59, 95, 84, 64}, "4913d4192032", 0.0f);
        String string2 = getString(str2.concat(strDecode));
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        int identifier = resources.getIdentifier(string2, C0000.decode(new byte[]{70, 76, 19, 88, 13, 2}, "58a1cedf20aac2dc", 7), str);
        if (identifier == 0) {
            userFriendlyKey(str2.concat(strDecode));
            return null;
        }
        JSONArray jSONArray = getJSONArray(str2.concat(C0000.decode(new byte[]{106, 13, 95, 1, 109, 80, 64, 5, 22}, "5a0b212be6", false)));
        if (jSONArray == null) {
            strArr = null;
        } else {
            int length = jSONArray.length();
            strArr = new String[length];
            for (int i = 0; i < length; i++) {
                strArr[i] = jSONArray.optString(i);
            }
        }
        if (strArr == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, strArr);
        } catch (MissingFormatArgumentException unused) {
            userFriendlyKey(str2);
            Arrays.toString(strArr);
            return null;
        }
    }

    public String getString(String str) {
        Bundle bundle = (Bundle) this.delegate;
        if (!bundle.containsKey(str)) {
            String strDecode = C0000.decode(new byte[]{6, 90, 91, 24, 89, 24}, "a966762dcf5288f2", 6);
            if (str.startsWith(strDecode)) {
                String strReplace = !str.startsWith(strDecode) ? str : str.replace(strDecode, C0000.decode(new byte[]{80, 85, 85, 75, 95, 90, 70, 80, 86, 8, 7, 4, 69, 95, 88, 86, 25}, "768e15290ade1678", false));
                if (bundle.containsKey(strReplace)) {
                    str = strReplace;
                }
            }
        }
        return bundle.getString(str);
    }

    public void noteStateNotSaved() {
        ((FragmentActivity.HostCallbacks) this.delegate).mFragmentManager.noteStateNotSaved();
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public void onCanceled() {
        ((CountDownLatch) this.delegate).countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        ((CountDownLatch) this.delegate).countDown();
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
        if (i == 6 || i == 7 || i == 8) {
        }
        ((ProfileInstallReceiver) this.delegate).setResultCode(i);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((CountDownLatch) this.delegate).countDown();
    }

    public Bundle paramsForAnalyticsIntent() {
        Bundle bundle = (Bundle) this.delegate;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith(C0000.decode(new byte[]{5, 86, 13, 6, 14, 6, 27, 87, 25, 85, 22}, "b9babc5474854b1f", 0.0f)) && !str.equals(C0000.decode(new byte[]{4, 69, 14, 90}, "b7a7c9", true))) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }

    public void putAll(HashMap map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            HashMap map2 = (HashMap) this.delegate;
            if (value == null) {
                map2.put(str, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    map2.put(str, value);
                } else {
                    int i = 0;
                    if (cls == boolean[].class) {
                        boolean[] zArr = (boolean[]) value;
                        Data data = Data.EMPTY;
                        Boolean[] boolArr = new Boolean[zArr.length];
                        while (i < zArr.length) {
                            boolArr[i] = Boolean.valueOf(zArr[i]);
                            i++;
                        }
                        map2.put(str, boolArr);
                    } else if (cls == byte[].class) {
                        byte[] bArr = (byte[]) value;
                        Data data2 = Data.EMPTY;
                        Byte[] bArr2 = new Byte[bArr.length];
                        while (i < bArr.length) {
                            bArr2[i] = Byte.valueOf(bArr[i]);
                            i++;
                        }
                        map2.put(str, bArr2);
                    } else if (cls == int[].class) {
                        int[] iArr = (int[]) value;
                        Data data3 = Data.EMPTY;
                        Integer[] numArr = new Integer[iArr.length];
                        while (i < iArr.length) {
                            numArr[i] = Integer.valueOf(iArr[i]);
                            i++;
                        }
                        map2.put(str, numArr);
                    } else if (cls == long[].class) {
                        long[] jArr = (long[]) value;
                        Data data4 = Data.EMPTY;
                        Long[] lArr = new Long[jArr.length];
                        while (i < jArr.length) {
                            lArr[i] = Long.valueOf(jArr[i]);
                            i++;
                        }
                        map2.put(str, lArr);
                    } else if (cls == float[].class) {
                        float[] fArr = (float[]) value;
                        Data data5 = Data.EMPTY;
                        Float[] fArr2 = new Float[fArr.length];
                        while (i < fArr.length) {
                            fArr2[i] = Float.valueOf(fArr[i]);
                            i++;
                        }
                        map2.put(str, fArr2);
                    } else {
                        if (cls != double[].class) {
                            throw new IllegalArgumentException(C0000.decode(new byte[]{114, 86, 75, 24}, "932832", 0.0f) + str + C0000.decode(new byte[]{20, 12, 86, 66, 24, 90, 13, 66, 85, 8, 94, 85, 24, 71, 26, 68, 81, 68}, "4d7183c4", false) + cls);
                        }
                        double[] dArr = (double[]) value;
                        Data data6 = Data.EMPTY;
                        Double[] dArr2 = new Double[dArr.length];
                        while (i < dArr.length) {
                            dArr2[i] = Double.valueOf(dArr[i]);
                            i++;
                        }
                        map2.put(str, dArr2);
                    }
                }
            }
        }
    }

    public void removeAll(String str) {
        ArrayList arrayList = (ArrayList) this.delegate;
        int i = 0;
        while (i < arrayList.size()) {
            if (str.equalsIgnoreCase((String) arrayList.get(i))) {
                arrayList.remove(i);
                arrayList.remove(i);
                i -= 2;
            }
            i += 2;
        }
    }

    public void set(String str, String str2) {
        Headers.Companion.checkName(str);
        Headers.Companion.checkValue(str2, str);
        removeAll(str);
        ArrayList arrayList = (ArrayList) this.delegate;
        arrayList.add(str);
        arrayList.add(StringsKt.trim(str2).toString());
    }

    public void setException(Exception exc) {
        DelegatingScheduledFuture delegatingScheduledFuture = (DelegatingScheduledFuture) this.delegate;
        if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(delegatingScheduledFuture, null, new AbstractResolvableFuture.Failure(exc))) {
            AbstractResolvableFuture.complete(delegatingScheduledFuture);
        }
    }

    public ConnectionPool(int i) {
        Handler handler;
        Handler handlerCreateAsync;
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.delegate = new HashSet();
                return;
            case 5:
                this.delegate = new LinkedHashMap();
                return;
            case 6:
                this.delegate = null;
                return;
            case 7:
                this.delegate = new HashMap();
                return;
            case 8:
                Looper mainLooper = Looper.getMainLooper();
                if (Build.VERSION.SDK_INT < 28) {
                    try {
                        handler = (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(mainLooper, null, Boolean.TRUE);
                    } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
                        handler = new Handler(mainLooper);
                    } catch (InvocationTargetException e) {
                        Throwable cause = e.getCause();
                        if (cause instanceof RuntimeException) {
                            throw ((RuntimeException) cause);
                        }
                        if (!(cause instanceof Error)) {
                            throw new RuntimeException(cause);
                        }
                        throw ((Error) cause);
                    }
                    handlerCreateAsync = handler;
                    break;
                } else {
                    handlerCreateAsync = Handler.createAsync(mainLooper);
                }
                this.delegate = handlerCreateAsync;
                return;
            case 13:
                return;
            case 18:
                this.delegate = new CountDownLatch(1);
                return;
            case 23:
                this.delegate = new ArrayList(20);
                return;
            case 25:
                this.delegate = new LinkedHashSet();
                return;
            default:
                TimeUnit timeUnit = TimeUnit.MINUTES;
                this.delegate = new RealConnectionPool(TaskRunner.INSTANCE);
                return;
        }
    }

    public ConnectionPool(Bundle bundle) {
        this.$r8$classId = 22;
        this.delegate = new Bundle(bundle);
    }

    public ConnectionPool(CoroutineWorker$$ExternalSyntheticLambda0 coroutineWorker$$ExternalSyntheticLambda0) {
        this.$r8$classId = 2;
        this.delegate = new CopyOnWriteArrayList();
        new HashMap();
    }

    public ConnectionPool(ServiceStarter serviceStarter) {
        this.$r8$classId = 10;
        BatteryNotLowController batteryNotLowController = new BatteryNotLowController((BatteryNotLowTracker) serviceStarter.firebaseMessagingServiceClassName, 1);
        BatteryNotLowController batteryNotLowController2 = new BatteryNotLowController((BatteryNotLowTracker) serviceStarter.hasWakeLockPermission, 0);
        BatteryNotLowController batteryNotLowController3 = new BatteryNotLowController((BatteryNotLowTracker) serviceStarter.messagingEvents, 4);
        NetworkStateTracker24 networkStateTracker24 = (NetworkStateTracker24) serviceStarter.hasAccessNetworkStatePermission;
        this.delegate = CollectionsKt__CollectionsKt.listOf(batteryNotLowController, batteryNotLowController2, batteryNotLowController3, new BatteryNotLowController(networkStateTracker24, 2), new BatteryNotLowController(networkStateTracker24, 3), new NetworkNotRoamingController(networkStateTracker24), new NetworkMeteredController(networkStateTracker24));
    }

    public ConnectionPool(Util$$ExternalSyntheticLambda1 util$$ExternalSyntheticLambda1) {
        this.$r8$classId = 24;
        this.delegate = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), util$$ExternalSyntheticLambda1);
    }
}
