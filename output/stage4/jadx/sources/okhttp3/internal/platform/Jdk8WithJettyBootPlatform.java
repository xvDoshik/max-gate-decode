package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {
    public final Class clientProviderClass;
    public final Method getMethod;
    public final Method putMethod;
    public final Method removeMethod;
    public final Class serverProviderClass;

    public final class AlpnProvider implements InvocationHandler {
        public final ArrayList protocols;
        public String selected;
        public boolean unsupported;

        public AlpnProvider(ArrayList arrayList) {
            this.protocols = arrayList;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (Intrinsics.areEqual(name, C0000.decode(new byte[]{64, 16, 67, 66, 87, 75, 67, 22}, "3e32897e44d3", false)) && Intrinsics.areEqual(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (Intrinsics.areEqual(name, C0000.decode(new byte[]{70, 10, 68, 65, 64, 22, 92, 22, 67, 81, 84}, "3d740f", 7)) && Intrinsics.areEqual(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            }
            boolean zAreEqual = Intrinsics.areEqual(name, C0000.decode(new byte[]{68, 23, 93, 70, 88, 6, 90, 84, 18}, "4e227e58a788", true));
            ArrayList arrayList = this.protocols;
            if (zAreEqual && objArr.length == 0) {
                return arrayList;
            }
            if ((Intrinsics.areEqual(name, C0000.decode(new byte[]{23, 81, 9, 82, 1, 23, 96, 20, 95, 67, 11, 87, 10, 91}, "d4e7bc0f07", true)) || Intrinsics.areEqual(name, C0000.decode(new byte[]{17, 92, 84, 93, 82, 69}, "b988117263ee"))) && String.class.equals(returnType) && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    List list = (List) obj2;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            String str = (String) list.get(i);
                            if (arrayList.contains(str)) {
                                this.selected = str;
                                return str;
                            }
                            if (i != size) {
                                i++;
                            }
                        }
                    }
                    String str2 = (String) arrayList.get(0);
                    this.selected = str2;
                    return str2;
                }
            }
            if ((!Intrinsics.areEqual(name, C0000.decode(new byte[]{64, 65, 86, 68, 10, 86, 91, 91, 96, 81, 92, 86, 90, 68, 0, 81}, "0390e54734", 4)) && !Intrinsics.areEqual(name, C0000.decode(new byte[]{22, 87, 8, 80, 83, 77, 0, 7}, "e2d509ec69", 0))) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            this.selected = (String) objArr[0];
            return null;
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    @Override // okhttp3.internal.platform.Platform
    public final void afterHandshake(SSLSocket sSLSocket) {
        String strDecode = C0000.decode(new byte[]{3, 89, 10, 91, 80, 6, 22, 66, 90, 16, 67, 1, 8, 87, 21, 82, 21, 35, 122, 102, 123}, "e8c75b66501d", 5);
        try {
            this.removeMethod.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError(strDecode, e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError(strDecode, e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
        String strDecode = C0000.decode(new byte[]{2, 89, 10, 90, 7, 84, 69, 16, 11, 17, 23, 93, 23, 22, 35, 124, 53, 42}, "d8c6b0edd1", 6);
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
        try {
            this.putMethod.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(arrayList2)));
        } catch (IllegalAccessException e) {
            throw new AssertionError(strDecode, e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError(strDecode, e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        String strDecode = C0000.decode(new byte[]{85, 86, 93, 89, 82, 7, 19, 67, 91, 21, 80, 6, 71, 23, 117, 121, 103, 45, 19, 68, 81, 89, 82, 0, 71, 82, 80, 21, 71, 17, 92, 67, 91, 86, 88, 15}, "37457c", 6);
        try {
            AlpnProvider alpnProvider = (AlpnProvider) Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
            boolean z = alpnProvider.unsupported;
            if (!z && alpnProvider.selected == null) {
                Platform.log(C0000.decode(new byte[]{32, 120, 51, 45, 66, 87, 84, 10, 93, 87, 85, 0, 88, 20, 5, 70, 12, 19, 18, 81, 81, 92, 17, 125, 96, 55, 99, 27, 83, 20, 10, 16, 66, 80, 92, 21, 80, 87, 88, 6, 87, 26, 65, 125, 16, 67, 3, 88, 69, 8, 28, 87, 91, 12, 71, 20, 14, 90, 67, 23, 10, 81, 21, 4, 94, 90, 64, 67, 80, 88, 0, 71, 16, 67, 18, 85, 65, 14, 14}, "a4ccb45f154c34", 1), 4, null);
                return null;
            }
            if (z) {
                return null;
            }
            return alpnProvider.selected;
        } catch (IllegalAccessException e) {
            throw new AssertionError(strDecode, e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError(strDecode, e2);
        }
    }
}
