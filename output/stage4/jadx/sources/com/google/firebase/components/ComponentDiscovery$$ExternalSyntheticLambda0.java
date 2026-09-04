package com.google.firebase.components;

import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.local.IidStore;
import java.lang.reflect.InvocationTargetException;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class ComponentDiscovery$$ExternalSyntheticLambda0 implements Provider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComponentDiscovery$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                String str = (String) this.f$0;
                String strDecode = C0000.decode(new byte[]{31}, "1bd79e59ffdf0c", false);
                String strDecode2 = C0000.decode(new byte[]{32, 14, 76, 93, 83, 69, 12, 12, 23, 65, 80, 95, 68, 17, 3, 13, 23, 8, 88, 69, 82, 69}, "ca917ebc", true);
                String strDecode3 = C0000.decode(new byte[]{69, 91, 70, 24, 95, 88, 17, 18, 84, 86, 17, 94, 11, 65, 65, 89, 95, 84, 0, 18, 90, 94, 17, 84, 10, 95, 27, 95, 94, 88, 2, 94, 80, 22, 87, 94, 23, 87, 87, 89, 66, 82, 75, 81, 90, 85, 65, 88, 11, 87, 91, 76, 66, 25, 38, 93, 88, 72, 94, 89, 0, 92, 65, 106, 84, 80, 12, 65, 65, 74, 80, 69}, "e25817");
                String strDecode4 = C0000.decode(new byte[]{116, 91, 4, 17, 64, 69}, "77eb3e34b0", 0.0f);
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new InvalidRegistrarException(strDecode4 + str + strDecode3);
                } catch (ClassNotFoundException unused) {
                    return null;
                } catch (IllegalAccessException e) {
                    throw new InvalidRegistrarException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, str, strDecode), e);
                } catch (InstantiationException e2) {
                    throw new InvalidRegistrarException(NetworkType$EnumUnboxingLocalUtility.m(strDecode2, str, strDecode), e2);
                } catch (NoSuchMethodException e3) {
                    throw new InvalidRegistrarException(strDecode2 + str, e3);
                } catch (InvocationTargetException e4) {
                    throw new InvalidRegistrarException(strDecode2 + str, e4);
                }
            case 1:
                return (ComponentRegistrar) this.f$0;
            default:
                return new IidStore((FirebaseApp) this.f$0);
        }
    }
}
