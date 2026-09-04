package androidx.work;

import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract /* synthetic */ class NetworkType$EnumUnboxingLocalUtility {
    public static final boolean _isFinished(int i) {
        return i == 3 || i == 4 || i == 6;
    }

    public static int m(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static /* synthetic */ String stringValueOf(int i) {
        switch (i) {
            case 1:
                return C0000.decode(new byte[]{43, 122, 108, 104, 101, 125, 48, 96, 40, 100, 119, 37}, "e58778a5a62a", 3);
            case 2:
                return C0000.decode(new byte[]{38, 127, 125, 118, 33, 122, 53, 117, 33}, "e038d9a0", 5);
            case 3:
                return C0000.decode(new byte[]{103, 122, 40, 124, 97, 39, 48, 33, 124}, "24e95bbd8b", false);
            case 4:
                return C0000.decode(new byte[]{125, 121, 50, 104, 96, 123, 115, 116, 123, 120, 116}, "36f724292631", 0.0f);
            case 5:
                return C0000.decode(new byte[]{124, 118, 55, 114, 100, 39, 118}, "13c76b2e8f", 4);
            case 6:
                return C0000.decode(new byte[]{53, 36, 40, 103, 123, 49, 32, 51, 44, 123, 109, 60, 52, 47, 40, 114, 96, 38, 51, 36, 33}, "aae74c");
            default:
                return C0000.decode(new byte[]{89, 68, 8, 13}, "71dabdd6753ab8", 6);
        }
    }

    public static String m(int i, int i2, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        return sb.toString();
    }

    public static String m(String str, int i) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        return sb.toString();
    }

    public static String m(String str, String str2, int i) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb.toString();
    }

    public static String m(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static HashMap m(Class cls, AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl) {
        HashMap map = new HashMap();
        map.put(cls, atProtobuf$ProtobufImpl);
        return map;
    }

    public static Map m(HashMap map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static /* synthetic */ void m(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }
}
