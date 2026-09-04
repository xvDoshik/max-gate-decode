package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.SystemClock;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;
import androidx.work.impl.utils.IdGenerator$$ExternalSyntheticLambda0;
import okhttp3.Dispatcher;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Alarms {
    public static final /* synthetic */ int $r8$clinit = 0;

    public abstract class Api19Impl {
        public static void setExact(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
            alarmManager.setExact(i, j, pendingIntent);
        }
    }

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{119, 13, 3, 65, 93, 65}, "6ab302", 0.0f));
    }

    public static void cancelExactAlarm(Context context, WorkGenerationalId workGenerationalId, int i) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(C0000.decode(new byte[]{80, 9, 2, 19, 93}, "1eca07d4bd22", 0.0f));
        int i2 = CommandHandler.$r8$clinit;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction(C0000.decode(new byte[]{116, 123, 54, 125, 124, 44, 60, 34, 112, 116, 35, 109, 108, 47, 38, 50}, "58b43bcf", true));
        CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
        PendingIntent service = PendingIntent.getService(context, i, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        SystemClock systemClock = SystemClock.get();
        workGenerationalId.toString();
        systemClock.getClass();
        alarmManager.cancel(service);
    }

    public static void setAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId, long j) {
        Dispatcher dispatcherSystemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = dispatcherSystemIdInfoDao.getSystemIdInfo(workGenerationalId);
        String strDecode = C0000.decode(new byte[]{115, 122, 98, 123, 120, 121, 110, 118, 39, 125, 118, 109, 111, 44, 125, 99}, "29627712b1740a87");
        String strDecode2 = C0000.decode(new byte[]{89, 8, 85, 64, 11}, "8d42f3");
        if (systemIdInfo != null) {
            int i = systemIdInfo.systemId;
            cancelExactAlarm(context, workGenerationalId, i);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(strDecode2);
            int i2 = CommandHandler.$r8$clinit;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction(strDecode);
            CommandHandler.writeWorkGenerationalId(intent, workGenerationalId);
            PendingIntent service = PendingIntent.getService(context, i, intent, 201326592);
            if (alarmManager != null) {
                Api19Impl.setExact(alarmManager, 0, j, service);
                return;
            }
            return;
        }
        int iIntValue = ((Number) workDatabase.runInTransaction(new IdGenerator$$ExternalSyntheticLambda0(0, new IdGenerator(workDatabase)))).intValue();
        dispatcherSystemIdInfoDao.insertSystemIdInfo(new SystemIdInfo(workGenerationalId.workSpecId, workGenerationalId.generation, iIntValue));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService(strDecode2);
        int i3 = CommandHandler.$r8$clinit;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction(strDecode);
        CommandHandler.writeWorkGenerationalId(intent2, workGenerationalId);
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, intent2, 201326592);
        if (alarmManager2 != null) {
            Api19Impl.setExact(alarmManager2, 0, j, service2);
        }
    }
}
