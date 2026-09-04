package androidx.work.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.lifecycle.MutableLiveData;
import androidx.room.RoomSQLiteQuery;
import androidx.work.Operation;
import androidx.work.Operation$State$FAILURE;
import androidx.work.Operation$State$SUCCESS;
import androidx.work.Worker;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.android.datatransport.cct.CctBackendFactory;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import com.google.android.gms.cloudmessaging.zze;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class OperationImpl implements Operation, OnCompleteListener {
    public final /* synthetic */ int $r8$classId;
    public Object mOperationFuture;
    public final Object mOperationState;

    public OperationImpl(IBinder iBinder) throws RemoteException {
        this.$r8$classId = 3;
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        String strDecode = C0000.decode(new byte[]{85, 90, 92, 23, 11, 89, 80, 31, 13, 22, 29, 126, 121, 81, 75, 22, 1, 94, 83, 84, 16}, "448ed041be37", 0.0f);
        if (interfaceDescriptor == strDecode || (interfaceDescriptor != null && interfaceDescriptor.equals(strDecode))) {
            this.mOperationState = new Messenger(iBinder);
            this.mOperationFuture = null;
            return;
        }
        String strDecode2 = C0000.decode(new byte[]{90, 86, 88, 75, 95, 87, 9, 94, 94, 80, 26, 82, 87, 93, 71, 10, 81, 92, 72, 94, 95, 70, 26, 90, 80, 93, 27, 44, 117, 93, 21, 74, 87, 91, 83, 86, 75, 122, 90, 8, 72, 89, 18}, "995e88f92543");
        if (interfaceDescriptor == strDecode2 || (interfaceDescriptor != null && interfaceDescriptor.equals(strDecode2))) {
            this.mOperationFuture = new zze(iBinder);
            this.mOperationState = null;
        } else {
            C0000.decode(new byte[]{45, 91, 19, 85, 91, 93, 86, 67, 13, 91, 17, 81, 69, 82, 83, 0, 1, 21, 1, 81, 68, 87, 64, 10, 20, 65, 10, 70, 13, 20}, "d5e4742c", true).concat(String.valueOf(interfaceDescriptor));
            throw new RemoteException();
        }
    }

    public OperationImpl(WorkLauncherImpl workLauncherImpl, TaskCompletionSource taskCompletionSource) {
        this.$r8$classId = 4;
        this.mOperationFuture = workLauncherImpl;
        this.mOperationState = taskCompletionSource;
    }

    public static OperationImpl acquire(Context context) {
        FileChannel channel;
        FileLock fileLockLock;
        try {
            channel = new RandomAccessFile(new File(context.getFilesDir(), C0000.decode(new byte[]{83, 6, 15, 85, 22, 81, 69, 83, 82, 10, 5, 30, 8, 95, 82, 93}, "4ca0d016", 3)), C0000.decode(new byte[]{20, 20}, "fcfe52c67f9e", 5)).getChannel();
            try {
                fileLockLock = channel.lock();
                try {
                    return new OperationImpl(channel, fileLockLock, 6);
                } catch (IOException | Error | OverlappingFileLockException unused) {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (IOException | Error | OverlappingFileLockException unused4) {
                fileLockLock = null;
            }
        } catch (IOException | Error | OverlappingFileLockException unused5) {
            channel = null;
            fileLockLock = null;
        }
    }

    public void add(Object obj, String str) {
        ArrayList arrayList = (ArrayList) this.mOperationState;
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(C0000.decode(new byte[]{95}, "b4be25"));
        sb.append(strValueOf);
        arrayList.add(sb.toString());
    }

    public CctBackendFactory get(String str) {
        Bundle bundle;
        Map map;
        ServiceInfo serviceInfo;
        String strDecode = C0000.decode(new byte[]{27}, "594e3415a5");
        String strDecode2 = C0000.decode(new byte[]{37, 94, 23, 89, 1, 22, 10, 12, 17, 22, 88, 10, 66, 18, 0, 93, 18, 88, 3, 65, 0, 22}, "f1b5e6dce61d1fa3");
        if (((Map) this.mOperationFuture) == null) {
            Context context = (Context) this.mOperationState;
            try {
                PackageManager packageManager = context.getPackageManager();
                bundle = (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128)) == null) ? null : serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (bundle == null) {
                map = Collections.EMPTY_MAP;
            } else {
                HashMap map2 = new HashMap();
                for (String str2 : bundle.keySet()) {
                    Object obj = bundle.get(str2);
                    if ((obj instanceof String) && str2.startsWith(C0000.decode(new byte[]{7, 85, 83, 92, 3, 89, 86, 15}, "e407f725"))) {
                        for (String str3 : ((String) obj).split(C0000.decode(new byte[]{30}, "2c999513e10560cf"), -1)) {
                            String strTrim = str3.trim();
                            if (!strTrim.isEmpty()) {
                                map2.put(strTrim, str2.substring(8));
                            }
                        }
                    }
                }
                map = map2;
            }
            this.mOperationFuture = map;
        }
        String str4 = (String) ((Map) this.mOperationFuture).get(str);
        if (str4 == null) {
            return null;
        }
        try {
            return (CctBackendFactory) Class.forName(str4).asSubclass(CctBackendFactory.class).getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException unused2) {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{116, 13, 5, 18, 70, 25}, "7ada59"));
            sb.append(str4);
            sb.append(C0000.decode(new byte[]{70, 90, 21, 25, 93, 14, 70, 65, 4, 91, 68, 93, 2, 29}, "f3f93a2ab413"));
            return null;
        } catch (IllegalAccessException unused3) {
            StringBuilder sb2 = new StringBuilder(strDecode2);
            sb2.append(str4);
            sb2.append(strDecode);
            return null;
        } catch (InstantiationException unused4) {
            StringBuilder sb3 = new StringBuilder(strDecode2);
            sb3.append(str4);
            sb3.append(strDecode);
            return null;
        } catch (NoSuchMethodException unused5) {
            strDecode2.concat(str4);
            return null;
        } catch (InvocationTargetException unused6) {
            strDecode2.concat(str4);
            return null;
        }
    }

    public Long getLongValue(String str) {
        WorkDatabase workDatabase = (WorkDatabase) this.mOperationState;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{97, 113, 122, 33, 34, 49, 24, 91, 88, 93, 86, 60, 68, 85, 90, 17, 4, 69, 126, 101, 120, 126, 17, 51, 64, 81, 80, 1, 19, 0, 86, 84, 82, 19, 70, 11, 87, 70, 83, 68, 1, 14, 93, 78, 87, 14, 14}, "246dae87731c", 0.0f), 1);
        roomSQLiteQueryAcquire.bindString(str, 1);
        workDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase.query(roomSQLiteQueryAcquire);
        try {
            Long lValueOf = null;
            if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                lValueOf = Long.valueOf(cursorQuery.getLong(0));
            }
            return lValueOf;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public void insertPreference(Preference preference) {
        WorkDatabase workDatabase = (WorkDatabase) this.mOperationState;
        workDatabase.assertNotSuspendingTransaction();
        workDatabase.beginTransaction();
        try {
            ((WorkTagDao_Impl.AnonymousClass1) this.mOperationFuture).insert(preference);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.internalEndTransaction();
        }
    }

    public void markState(Headers.Companion companion) {
        boolean z;
        MutableLiveData mutableLiveData = (MutableLiveData) this.mOperationState;
        synchronized (mutableLiveData.mDataLock) {
            z = mutableLiveData.mPendingData == MutableLiveData.NOT_SET;
            mutableLiveData.mPendingData = companion;
        }
        if (z) {
            ArchTaskExecutor archTaskExecutor = ArchTaskExecutor.getInstance();
            Worker.AnonymousClass1 anonymousClass1 = mutableLiveData.mPostValueRunnable;
            DefaultTaskExecutor defaultTaskExecutor = archTaskExecutor.mDelegate;
            if (defaultTaskExecutor.mMainHandler == null) {
                synchronized (defaultTaskExecutor.mLock) {
                    try {
                        if (defaultTaskExecutor.mMainHandler == null) {
                            defaultTaskExecutor.mMainHandler = DefaultTaskExecutor.createAsync(Looper.getMainLooper());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            defaultTaskExecutor.mMainHandler.post(anonymousClass1);
        }
        if (companion instanceof Operation$State$SUCCESS) {
            ((SettableFuture) this.mOperationFuture).set((Operation$State$SUCCESS) companion);
        } else if (companion instanceof Operation$State$FAILURE) {
            ((SettableFuture) this.mOperationFuture).setException(((Operation$State$FAILURE) companion).mThrowable);
        }
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((Map) ((WorkLauncherImpl) this.mOperationFuture).workTaskExecutor).remove((TaskCompletionSource) this.mOperationState);
    }

    public void releaseAndClose() {
        try {
            ((FileLock) this.mOperationFuture).release();
            ((FileChannel) this.mOperationState).close();
        } catch (IOException unused) {
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 5:
                StringBuilder sb = new StringBuilder(100);
                sb.append(this.mOperationFuture.getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.mOperationState;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(C0000.decode(new byte[]{79, 16}, "c06dfea3", false));
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ OperationImpl(Object obj, AutoCloseable autoCloseable, int i) {
        this.$r8$classId = i;
        this.mOperationState = obj;
        this.mOperationFuture = autoCloseable;
    }

    public /* synthetic */ OperationImpl(Object obj) {
        this.$r8$classId = 5;
        this.mOperationFuture = obj;
        this.mOperationState = new ArrayList();
    }

    public OperationImpl(WorkDatabase workDatabase) {
        this.$r8$classId = 1;
        this.mOperationState = workDatabase;
        this.mOperationFuture = new WorkTagDao_Impl.AnonymousClass1(workDatabase, 2);
    }

    public OperationImpl() {
        this.$r8$classId = 0;
        this.mOperationState = new MutableLiveData();
        this.mOperationFuture = new SettableFuture();
        markState(Operation.IN_PROGRESS);
    }

    public OperationImpl(Context context) {
        this.$r8$classId = 2;
        this.mOperationFuture = null;
        this.mOperationState = context;
    }
}
