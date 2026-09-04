package androidx.work;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Data {
    public static final Data EMPTY;
    public final HashMap mValues;

    static {
        SystemClock.tagWithPrefix(C0000.decode(new byte[]{32, 82, 70, 85}, "d324824f7e7e", 0.0f));
        Data data = new Data(new HashMap());
        toByteArrayInternal(data);
        EMPTY = data;
    }

    public Data(Data data) {
        this.mValues = new HashMap(data.mValues);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:29:0x0030
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static androidx.work.Data fromByteArray(byte[] r8) {
        /*
            int r0 = r8.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L4c
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r8)
            r8 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L34 java.lang.Throwable -> L40
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L34 java.lang.Throwable -> L40
            int r8 = r2.readInt()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
        L19:
            if (r8 <= 0) goto L2d
            java.lang.String r3 = r2.readUTF()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            java.lang.Object r4 = r2.readObject()     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            r0.put(r3, r4)     // Catch: java.lang.Throwable -> L29 java.lang.Throwable -> L2b
            int r8 = r8 + (-1)
            goto L19
        L29:
            r8 = move-exception
            goto L37
        L2b:
            r8 = r2
            goto L40
        L2d:
            r2.close()     // Catch: java.io.IOException -> L30
        L30:
            r1.close()     // Catch: java.io.IOException -> L46
            goto L46
        L34:
            r0 = move-exception
            r2 = r8
            r8 = r0
        L37:
            if (r2 == 0) goto L3c
            r2.close()     // Catch: java.io.IOException -> L3c
        L3c:
            r1.close()     // Catch: java.io.IOException -> L3f
        L3f:
            throw r8
        L40:
            if (r8 == 0) goto L30
            r8.close()     // Catch: java.io.IOException -> L30
            goto L30
        L46:
            androidx.work.Data r8 = new androidx.work.Data
            r8.<init>(r0)
            return r8
        L4c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r5 = 56
            byte[] r5 = new byte[r5]
            r5 = {x0060: FILL_ARRAY_DATA , data: [114, 88, 17, 87, 69, 83, 80, 95, 91, 95, 66, 25, 10, 85, 6, 69, 65, 72, 21, 93, 89, 75, 0, 22, 17, 88, 80, 95, 21, 1, 6, 11, 81, 6, 69, 82, 72, 69, 80, 67, 22, 78, 13, 83, 11, 16, 66, 84, 71, 89, 87, 85, 12, 76, 0, 84} // fill-array
            java.lang.String r0 = "69e6e01150"
            r7 = 0
            java.lang.String r0 = p000.C0000.decode(r5, r0, r7)
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    public static byte[] toByteArrayInternal(Data data) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(data.mValues.size());
                    for (Map.Entry entry : data.mValues.entrySet()) {
                        objectOutputStream2.writeUTF((String) entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    if (byteArrayOutputStream.size() <= 10240) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    throw new IllegalStateException(C0000.decode(new byte[]{112, 87, 69, 7, 17, 82, 5, 94, 91, 93, 22, 66, 13, 90, 87, 67, 65, 31, 17, 92, 11, 66, 80, 18, 22, 10, 3, 87, 20, 7, 1, 84, 5, 1, 68, 82, 76, 70, 7, 17, 66, 78, 92, 83, 95, 70, 66, 84, 22, 89, 84, 94, 11, 24, 7, 93}, "461f11d052bbb9", 0.0f));
                } catch (IOException unused3) {
                    objectOutputStream = objectOutputStream2;
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused5) {
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException unused7) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused8) {
        }
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && Data.class == obj.getClass()) {
                HashMap map = ((Data) obj).mValues;
                HashMap map2 = this.mValues;
                Set<String> setKeySet = map2.keySet();
                if (setKeySet.equals(map.keySet())) {
                    for (String str : setKeySet) {
                        Object obj2 = map2.get(str);
                        Object obj3 = map.get(str);
                        if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{119, 4, 16, 2, 25, 79}, "3edc948a2b3a22dd"));
        HashMap map = this.mValues;
        if (!map.isEmpty()) {
            for (String str : map.keySet()) {
                sb.append(str);
                sb.append(C0000.decode(new byte[]{68, 9, 24}, "d3855d79cba6e2", 4));
                Object obj = map.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(C0000.decode(new byte[]{20, 16}, "8010b61a"));
            }
        }
        sb.append(C0000.decode(new byte[]{72}, "5bd373b68dc7"));
        return sb.toString();
    }

    public Data(HashMap map) {
        this.mValues = new HashMap(map);
    }
}
