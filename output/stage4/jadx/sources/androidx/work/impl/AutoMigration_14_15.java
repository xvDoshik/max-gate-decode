package androidx.work.impl;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import androidx.profileinstaller.ProfileInstaller$2;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.gms.common.zzj;
import com.google.android.gms.common.zzk;
import com.google.android.gms.common.zzm;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.tracing.ComponentMonitor$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import okhttp3.Protocol;
import okio.Buffer;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class AutoMigration_14_15 implements Factory {
    public static AutoMigration_14_15 zza;

    public static ArrayList alpnProtocolNames(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Protocol) obj) != Protocol.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((Protocol) obj2).protocol);
        }
        return arrayList2;
    }

    public static byte[] concatLengthPrefixed(List list) {
        Buffer buffer = new Buffer();
        ArrayList arrayListAlpnProtocolNames = alpnProtocolNames(list);
        int size = arrayListAlpnProtocolNames.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListAlpnProtocolNames.get(i);
            i++;
            String str = (String) obj;
            buffer.m23writeByte(str.length());
            buffer.writeUtf8(str, 0, str.length());
        }
        return buffer.readByteArray(buffer.size);
    }

    public static boolean isAndroid() {
        return C0000.decode(new byte[]{112, 89, 8, 21, 8, 14}, "48dcae49", 0.0f).equals(System.getProperty(C0000.decode(new byte[]{92, 5, 18, 88, 29, 67, 95, 74, 88, 5, 9, 92}, "6dd9352d", true)));
    }

    public static final zzj zza(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzjVarArr.length; i++) {
            if (zzjVarArr[i].equals(zzkVar)) {
                return zzjVarArr[i];
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo;
        boolean z = packageInfo == null || !((C0000.decode(new byte[]{87, 12, 93, 76, 3, 13, 2, 68, 92, 80, 80, 77, 70, 7, 12, 7, 15, 88, 84}, "4c0bbcf639", 0.0f).equals(packageInfo.packageName) || C0000.decode(new byte[]{1, 94, 11, 30, 6, 10, 95, 82, 10, 81, 76, 80, 8, 84, 19, 10, 89, 81, 72, 83, 15, 66}, "b1f0ae05f4").equals(packageInfo.packageName)) && ((applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 129) == 0));
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? zza(packageInfo, zzm.zza) : zza(packageInfo, zzm.zza[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.inject.Provider
    public Object get() {
        ProfileInstaller$2 profileInstaller$2 = new ProfileInstaller$2();
        HashMap map = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(Priority.DEFAULT, new AutoValue_SchedulerConfig_ConfigValue(30000L, 86400000L, set));
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(Priority.HIGHEST, new AutoValue_SchedulerConfig_ConfigValue(1000L, 86400000L, set));
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(SchedulerConfig$Flag.DEVICE_IDLE)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(Priority.VERY_LOW, new AutoValue_SchedulerConfig_ConfigValue(86400000L, 86400000L, setUnmodifiableSet));
        if (map.keySet().size() < Priority.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new AutoValue_SchedulerConfig(profileInstaller$2, map);
    }

    public List processRegistrar(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (Component component : componentRegistrar.getComponents()) {
            String str = component.name;
            if (str != null) {
                component = new Component(str, component.providedInterfaces, component.dependencies, component.instantiation, component.type, new ComponentMonitor$$ExternalSyntheticLambda0(str, 0, component), component.publishedEvents);
            }
            arrayList.add(component);
        }
        return arrayList;
    }
}
