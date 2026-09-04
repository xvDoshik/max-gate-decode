package androidx.room.util;

import android.database.Cursor;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class TableInfo {
    public final Object columns;
    public final Set foreignKeys;
    public final Set indices;
    public final String name;

    public final class Column {
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public Column(String str, String str2, boolean z, int i, String str3, int i2) {
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
            this.defaultValue = str3;
            this.createdFrom = i2;
            String upperCase = str2.toUpperCase(Locale.US);
            this.affinity = StringsKt.contains$default(upperCase, C0000.decode(new byte[]{45, 43, 97}, "de5169e30d136bb5")) ? 3 : (StringsKt.contains$default(upperCase, C0000.decode(new byte[]{38, 42, 32, 107}, "eba90c0aa1", 0.0f)) || StringsKt.contains$default(upperCase, C0000.decode(new byte[]{116, 117, 118, 118}, "799465de")) || StringsKt.contains$default(upperCase, C0000.decode(new byte[]{108, 35, 109, 103}, "8f53f24069", false))) ? 2 : StringsKt.contains$default(upperCase, C0000.decode(new byte[]{32, 120, 46, 33}, "b4acb6", 4)) ? 5 : (StringsKt.contains$default(upperCase, C0000.decode(new byte[]{54, 125, 120, 40}, "d89d39", 0.0f)) || StringsKt.contains$default(upperCase, C0000.decode(new byte[]{112, 40, 126, 37}, "6d1db34c446cf7c8", 0.0f)) || StringsKt.contains$default(upperCase, C0000.decode(new byte[]{112, 120, 109, 38}, "478d0b56d724f152", true))) ? 4 : 1;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof Column)) {
                    return false;
                }
                Column column = (Column) obj;
                if (this.primaryKeyPosition != column.primaryKeyPosition) {
                    return false;
                }
                int i = column.createdFrom;
                String str = column.defaultValue;
                if (!Intrinsics.areEqual(this.name, column.name) || this.notNull != column.notNull) {
                    return false;
                }
                String str2 = this.defaultValue;
                int i2 = this.createdFrom;
                if (i2 == 1 && i == 2 && str2 != null && !CloseableKt.defaultValueEquals(str2, str)) {
                    return false;
                }
                if (i2 == 2 && i == 1 && str != null && !CloseableKt.defaultValueEquals(str, str2)) {
                    return false;
                }
                if (i2 != 0 && i2 == i) {
                    if (str2 != null) {
                        if (!CloseableKt.defaultValueEquals(str2, str)) {
                            return false;
                        }
                    } else if (str != null) {
                        return false;
                    }
                }
                if (this.affinity != column.affinity) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{112, 94, 95, 77, 90, 93, 74, 93, 82, 92, 86, 5, 16}, "31387313", 4));
            sb.append(this.name);
            sb.append(C0000.decode(new byte[]{19, 24, 66, 67, 27, 19, 4, 8, 66}, "44b7bca5eb321b4a", false));
            sb.append(this.type);
            sb.append(C0000.decode(new byte[]{66, 73, 18, 89, 87, 86, 12, 11, 91, 76, 72, 13, 66}, "ee2810", true));
            sb.append(this.affinity);
            sb.append(C0000.decode(new byte[]{18, 73, 68, 13, 94, 69, 127, 19, 88, 10, 12}, "5edc111f4f11d28f", 7));
            sb.append(this.notNull);
            sb.append(C0000.decode(new byte[]{20, 67, 70, 20, 11, 11, 84, 17, 75, 47, 81, 76, 104, 87, 64, 80, 76, 10, 89, 8, 95}, "8c6fbf5c2d458839"));
            sb.append(this.primaryKeyPosition);
            sb.append(C0000.decode(new byte[]{29, 19, 93, 81, 87, 85, 70, 8, 23, 55, 5, 88, 69, 84, 11, 31}, "1394143dcad40168"));
            String strDecode = this.defaultValue;
            if (strDecode == null) {
                strDecode = C0000.decode(new byte[]{23, 90, 82, 87, 84, 94, 12, 7, 6}, "b46227bb");
            }
            return FileSectionType$EnumUnboxingLocalUtility.m(sb, strDecode, C0000.decode(new byte[]{19, 75}, "464d8194033d", false));
        }
    }

    public final class ForeignKey {
        public final List columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List list, List list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (Intrinsics.areEqual(this.referenceTable, foreignKey.referenceTable) && Intrinsics.areEqual(this.onDelete, foreignKey.onDelete) && Intrinsics.areEqual(this.onUpdate, foreignKey.onUpdate) && Intrinsics.areEqual(this.columnNames, foreignKey.columnNames)) {
                return Intrinsics.areEqual(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return false;
        }

        public final int hashCode() {
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + NetworkType$EnumUnboxingLocalUtility.m(this.onUpdate, NetworkType$EnumUnboxingLocalUtility.m(this.onDelete, this.referenceTable.hashCode() * 31, 31), 31)) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{37, 9, 23, 82, 13, 94, 13, 45, 0, 78, 31, 75, 6, 0, 0, 69, 1, 87, 0, 3, 49, 86, 6, 85, 6, 91, 66}, "cfe7d9", true));
            sb.append(this.referenceTable);
            sb.append(C0000.decode(new byte[]{70, 25, 18, 93, 13, 37, 1, 10, 93, 22, 84, 88, 70}, "a522cadf8b1ea0", 4));
            sb.append(this.onDelete);
            sb.append(C0000.decode(new byte[]{18, 26, 20, 20, 65, 94, 95, 52, 18, 85, 89, 23, 87, 12, 20}, "2138a11ab18c", true));
            sb.append(this.onUpdate);
            sb.append(C0000.decode(new byte[]{69, 79, 19, 90, 14, 14, 16, 90, 95, 123, 3, 14, 86, 74, 92}, "bc39abe715"));
            sb.append(this.columnNames);
            sb.append(C0000.decode(new byte[]{79, 65, 64, 0, 84, 7, 70, 1, 13, 2, 87, 38, 93, 14, 65, 9, 13, 47, 83, 8, 87, 17, 9}, "ca2e2b4d", false));
            sb.append(this.referenceColumnNames);
            sb.append('}');
            return sb.toString();
        }
    }

    public final class ForeignKeyWithSequence implements Comparable {
        public final String from;
        public final int id;
        public final int sequence;
        public final String to;

        public ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            this.id = i;
            this.sequence = i2;
            this.from = str;
            this.to = str2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj;
            int i = this.id - foreignKeyWithSequence.id;
            return i == 0 ? this.sequence - foreignKeyWithSequence.sequence : i;
        }
    }

    public final class Index {
        public final List columns;
        public final String name;
        public final List orders;
        public final boolean unique;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList] */
        public Index(String str, boolean z, List list, List list2) {
            this.name = str;
            this.unique = z;
            this.columns = list;
            this.orders = list2;
            if (list2.isEmpty()) {
                int size = list.size();
                list2 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    list2.add(C0000.decode(new byte[]{37, 49, 37}, "dbf283f62c", true));
                }
            }
            this.orders = list2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Index)) {
                return false;
            }
            Index index = (Index) obj;
            String str = index.name;
            if (this.unique != index.unique || !Intrinsics.areEqual(this.columns, index.columns) || !Intrinsics.areEqual(this.orders, index.orders)) {
                return false;
            }
            String str2 = this.name;
            String strDecode = C0000.decode(new byte[]{11, 86, 5, 6, 78, 108}, "b8ac63a8", 1);
            return str2.startsWith(strDecode) ? str.startsWith(strDecode) : str2.equals(str);
        }

        public final int hashCode() {
            String strDecode = C0000.decode(new byte[]{11, 89, 7, 6, 29, 59}, "b7ccedc303d2");
            String str = this.name;
            return this.orders.hashCode() + ((this.columns.hashCode() + ((((str.startsWith(strDecode) ? -1184239155 : str.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31)) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{47, 87, 2, 83, 76, 76, 92, 4, 11, 92, 91, 17}, "f9f6472e", false));
            sb.append(this.name);
            sb.append(C0000.decode(new byte[]{30, 28, 20, 64, 15, 89, 73, 76, 82, 92}, "9045a0897a3da0", 0));
            sb.append(this.unique);
            sb.append(C0000.decode(new byte[]{30, 19, 1, 10, 84, 77, 90, 89, 65, 14}, "23be8877", false));
            sb.append(this.columns);
            sb.append(C0000.decode(new byte[]{74, 23, 11, 75, 81, 3, 64, 74, 4}, "f7d95f299e", 0.0f));
            sb.append(this.orders);
            sb.append(C0000.decode(new byte[]{18, 68}, "5946fdd222", 0.0f));
            return sb.toString();
        }
    }

    public TableInfo(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        this.name = str;
        this.columns = map;
        this.foreignKeys = abstractSet;
        this.indices = abstractSet2;
    }

    public static final TableInfo read(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str) throws IOException {
        Map map;
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{100, 96, 120, 126, 125, 113, 65, 77, 5, 86, 90, 83, 107, 91, 87, 95, 95, 24, 1}, "429900a9d466", 1));
        sb.append(str);
        String strDecode = C0000.decode(new byte[]{5, 26}, "e3b9d510ea");
        sb.append(strDecode);
        Cursor cursorQuery = frameworkSQLiteDatabase.query(sb.toString());
        try {
            int columnCount = cursorQuery.getColumnCount();
            String strDecode2 = C0000.decode(new byte[]{11, 89, 12, 81}, "e8a4410f", true);
            if (columnCount <= 0) {
                map = EmptyMap.INSTANCE;
                cursorQuery.close();
            } else {
                int columnIndex = cursorQuery.getColumnIndex(strDecode2);
                int columnIndex2 = cursorQuery.getColumnIndex(C0000.decode(new byte[]{23, 65, 72, 80}, "c885affb0a20", 0));
                int columnIndex3 = cursorQuery.getColumnIndex(C0000.decode(new byte[]{94, 90, 18, 11, 77, 94, 93}, "05fe8216d869", 0.0f));
                int columnIndex4 = cursorQuery.getColumnIndex(C0000.decode(new byte[]{17, 15}, "ad3faf", 0.0f));
                int columnIndex5 = cursorQuery.getColumnIndex(C0000.decode(new byte[]{82, 84, 92, 76, 102, 70, 85, 84, 65, 80}, "6208904845fcabd1"));
                MapBuilder mapBuilder = new MapBuilder();
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndex);
                    mapBuilder.put(string, new Column(string, cursorQuery.getString(columnIndex2), cursorQuery.getInt(columnIndex3) != 0, cursorQuery.getInt(columnIndex4), cursorQuery.getString(columnIndex5), 2));
                }
                mapBuilder.checkIsMutable$kotlin_stdlib();
                mapBuilder.isReadOnly = true;
                map = mapBuilder.size > 0 ? mapBuilder : MapBuilder.Empty;
                cursorQuery.close();
            }
            Cursor cursorQuery2 = frameworkSQLiteDatabase.query(C0000.decode(new byte[]{52, 97, 37, 34, 123, 112, 23, 95, 13, 19, 7, 12, 3, 93, 59, 14, 83, 72, 104, 85, 11, 18, 22, 77, 4}, "d3de6179babe") + str + strDecode);
            try {
                int columnIndex6 = cursorQuery2.getColumnIndex(C0000.decode(new byte[]{13, 85}, "d1af3b88682c", 5));
                int columnIndex7 = cursorQuery2.getColumnIndex(C0000.decode(new byte[]{64, 1, 72}, "3d9e56", true));
                int columnIndex8 = cursorQuery2.getColumnIndex(C0000.decode(new byte[]{23, 86, 80, 8, 7}, "c72db4f2"));
                int columnIndex9 = cursorQuery2.getColumnIndex(C0000.decode(new byte[]{89, 94, 105, 5, 87, 92, 6, 21, 80}, "606a20ca5b", true));
                int columnIndex10 = cursorQuery2.getColumnIndex(C0000.decode(new byte[]{89, 91, 105, 71, 21, 86, 87, 65, 83}, "6562e2"));
                List foreignKeyFieldMappings = ExceptionsKt.readForeignKeyFieldMappings(cursorQuery2);
                cursorQuery2.moveToPosition(-1);
                SetBuilder setBuilder = new SetBuilder();
                while (cursorQuery2.moveToNext()) {
                    if (cursorQuery2.getInt(columnIndex7) == 0) {
                        int i = cursorQuery2.getInt(columnIndex6);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        int i2 = columnIndex6;
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj : foreignKeyFieldMappings) {
                            int i3 = columnIndex7;
                            List list = foreignKeyFieldMappings;
                            if (((ForeignKeyWithSequence) obj).id == i) {
                                arrayList3.add(obj);
                            }
                            columnIndex7 = i3;
                            foreignKeyFieldMappings = list;
                        }
                        int i4 = columnIndex7;
                        List list2 = foreignKeyFieldMappings;
                        int i5 = 0;
                        for (int size = arrayList3.size(); i5 < size; size = size) {
                            Object obj2 = arrayList3.get(i5);
                            i5++;
                            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj2;
                            arrayList.add(foreignKeyWithSequence.from);
                            arrayList2.add(foreignKeyWithSequence.to);
                        }
                        setBuilder.add(new ForeignKey(cursorQuery2.getString(columnIndex8), cursorQuery2.getString(columnIndex9), cursorQuery2.getString(columnIndex10), arrayList, arrayList2));
                        columnIndex6 = i2;
                        columnIndex7 = i4;
                        foreignKeyFieldMappings = list2;
                    }
                }
                SetBuilder setBuilderBuild = ExceptionsKt.build(setBuilder);
                cursorQuery2.close();
                Cursor cursorQuery3 = frameworkSQLiteDatabase.query(C0000.decode(new byte[]{50, 107, 37, 127, 126, 118, 68, 15, 89, 93, 82, 79, 61, 85, 13, 75, 71, 31, 4}, "b9d837df7977", 0.0f) + str + strDecode);
                try {
                    int columnIndex11 = cursorQuery3.getColumnIndex(strDecode2);
                    int columnIndex12 = cursorQuery3.getColumnIndex(C0000.decode(new byte[]{11, 74, 92, 87, 91, 12}, "d8502b1a35ba", 0.0f));
                    int columnIndex13 = cursorQuery3.getColumnIndex(C0000.decode(new byte[]{70, 91, 80, 70, 68, 85}, "3597100b", 1));
                    SetBuilder setBuilderBuild2 = null;
                    if (columnIndex11 == -1 || columnIndex12 == -1 || columnIndex13 == -1) {
                        cursorQuery3.close();
                    } else {
                        SetBuilder setBuilder2 = new SetBuilder();
                        while (cursorQuery3.moveToNext()) {
                            if (C0000.decode(new byte[]{6}, "ef757f3f763c", 0.0f).equals(cursorQuery3.getString(columnIndex12))) {
                                Index index = ExceptionsKt.readIndex(frameworkSQLiteDatabase, cursorQuery3.getString(columnIndex11), cursorQuery3.getInt(columnIndex13) == 1);
                                if (index == null) {
                                    cursorQuery3.close();
                                } else {
                                    setBuilder2.add(index);
                                }
                            }
                        }
                        setBuilderBuild2 = ExceptionsKt.build(setBuilder2);
                        cursorQuery3.close();
                    }
                    return new TableInfo(str, map, setBuilderBuild, setBuilderBuild2);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery3, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(cursorQuery2, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(cursorQuery, th5);
                throw th6;
            }
        }
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!this.name.equals(tableInfo.name) || !this.columns.equals(tableInfo.columns) || !Intrinsics.areEqual(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set set2 = this.indices;
        if (set2 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.foreignKeys.hashCode() + ((this.columns.hashCode() + (this.name.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{101, 80, 83, 13, 82, 126, 10, 86, 92, 74, 95, 80, 92, 4, 10, 16}, "111a77d031", true));
        sb.append(this.name);
        sb.append(C0000.decode(new byte[]{22, 26, 67, 82, 93, 10, 17, 14, 89, 18, 8}, "16c12fdc7a50"));
        sb.append(this.columns);
        sb.append(C0000.decode(new byte[]{26, 69, 82, 14, 64, 85, 95, 1, 89, 127, 93, 77, 23, 91}, "6e4a206f7484df00"));
        sb.append(this.foreignKeys);
        sb.append(C0000.decode(new byte[]{78, 17, 88, 13, 2, 90, 82, 93, 70, 12}, "b11cf31851"));
        sb.append(this.indices);
        sb.append('}');
        return sb.toString();
    }
}
