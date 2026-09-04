package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    public static final TreeMap queryPool = new TreeMap();
    public int argCount;
    public final int[] bindingTypes;
    public final byte[][] blobBindings;
    public final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    public volatile String query;
    public final String[] stringBindings;

    public RoomSQLiteQuery(int i) {
        this.capacity = i;
        int i2 = i + 1;
        this.bindingTypes = new int[i2];
        this.longBindings = new long[i2];
        this.doubleBindings = new double[i2];
        this.stringBindings = new String[i2];
        this.blobBindings = new byte[i2][];
    }

    public static final RoomSQLiteQuery acquire(String str, int i) {
        TreeMap treeMap = queryPool;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (entryCeilingEntry == null) {
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i);
                roomSQLiteQuery.query = str;
                roomSQLiteQuery.argCount = i;
                return roomSQLiteQuery;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            RoomSQLiteQuery roomSQLiteQuery2 = (RoomSQLiteQuery) entryCeilingEntry.getValue();
            roomSQLiteQuery2.query = str;
            roomSQLiteQuery2.argCount = i;
            return roomSQLiteQuery2;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int i, byte[] bArr) {
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = bArr;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i, double d) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(String str, int i) {
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        int i = this.argCount;
        if (1 > i) {
            return;
        }
        int i2 = 1;
        while (true) {
            int i3 = this.bindingTypes[i2];
            if (i3 == 1) {
                supportSQLiteProgram.bindNull(i2);
            } else if (i3 == 2) {
                supportSQLiteProgram.bindLong(i2, this.longBindings[i2]);
            } else if (i3 != 3) {
                String strDecode = C0000.decode(new byte[]{98, 83, 21, 19, 94, 65, 85, 82, 68, 16, 86, 95, 69, 83, 68, 17, 86, 64, 16, 88, 17, 10, 91, 29}, "06df73", 0.0f);
                if (i3 == 4) {
                    String str = this.stringBindings[i2];
                    if (str == null) {
                        throw new IllegalArgumentException(strDecode);
                    }
                    supportSQLiteProgram.bindString(str, i2);
                } else if (i3 == 5) {
                    byte[] bArr = this.blobBindings[i2];
                    if (bArr == null) {
                        throw new IllegalArgumentException(strDecode);
                    }
                    supportSQLiteProgram.bindBlob(i2, bArr);
                }
            } else {
                supportSQLiteProgram.bindDouble(i2, this.doubleBindings[i2]);
            }
            if (i2 == i) {
                return;
            } else {
                i2++;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException(C0000.decode(new byte[]{98, 92, 68, 23, 80, 74, 80, 1, 16, 66, 81, 85, 64, 7, 25, 79, 84, 22, 16, 90, 69, 85, 89, 76}, "095b985e04", 0.0f));
    }

    public final void release() {
        TreeMap treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i;
                }
            }
        }
    }
}
