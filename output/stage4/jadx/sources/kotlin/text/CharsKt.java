package kotlin.text;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.room.RoomSQLiteQuery;
import androidx.startup.StartupException;
import androidx.work.Configuration;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.model.WorkSpecDao_Impl;
import com.base.template.services.GuardianService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.Incomplete;
import kotlinx.coroutines.IncompleteStateBox;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.MediaType;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class CharsKt {
    public static final void checkContentUriTriggerWorkerLimits(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl workContinuationImpl) {
        int i;
        ArrayList arrayListMutableListOf = CollectionsKt__CollectionsKt.mutableListOf(workContinuationImpl);
        int i2 = 0;
        while (!arrayListMutableListOf.isEmpty()) {
            if (arrayListMutableListOf.isEmpty()) {
                throw new NoSuchElementException(C0000.decode(new byte[]{40, 12, 71, 23, 69, 90, 22, 18, 82, 9, 20, 65, 29, 75}, "de4ce3e27dd5", 6));
            }
            List list = ((WorkContinuationImpl) arrayListMutableListOf.remove(CollectionsKt__CollectionsKt.getLastIndex(arrayListMutableListOf))).mWork;
            if (list.isEmpty()) {
                i = 0;
            } else {
                Iterator it = list.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (!((WorkRequest) it.next()).workSpec.constraints.contentUriTriggers.isEmpty() && (i = i + 1) < 0) {
                        throw new ArithmeticException(C0000.decode(new byte[]{113, 10, 65, 88, 22, 20, 93, 19, 81, 68, 4, 88, 93, 18, 20, 94, 3, 71, 18, 13, 85, 70, 18, 81, 92, 0, 80, 24}, "2e46b4", 0.0f));
                    }
                }
            }
            i2 += i;
        }
        if (i2 == 0) {
            return;
        }
        WorkSpecDao_Impl workSpecDao_ImplWorkSpecDao = workDatabase.workSpecDao();
        workSpecDao_ImplWorkSpecDao.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(C0000.decode(new byte[]{49, 85, 8, 83, 85, 64, 17, 114, 120, 103, 44, 109, 76, 19, 75, 16, 34, 100, 121, 121, 17, 70, 88, 64, 9, 74, 20, 92, 1, 16, 51, 126, 115, 102, 116, 17, 123, 119, 44, 126, 48, 113, 74, 83, 11, 88, 66, 81, 95, 69, 104, 71, 16, 80, 59, 77, 16, 89, 3, 81, 83, 70, 66, 24, 11, 12, 82, 25, 37, 119, 38, 16, 23, 66, 87, 64, 84, 17, 121, 125, 54, 25, 45, 119, 66, 24, 86, 26, 22, 7, 29, 17, 2, 27}, "b0d6641172b9d9", false), 0);
        WorkDatabase_Impl workDatabase_Impl = workSpecDao_ImplWorkSpecDao.__db;
        workDatabase_Impl.assertNotSuspendingTransaction();
        Cursor cursorQuery = workDatabase_Impl.query(roomSQLiteQueryAcquire);
        try {
            int i3 = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            int i4 = configuration.contentUriTriggerWorkersLimit;
            if (i3 + i2 <= i4) {
                return;
            }
            throw new IllegalArgumentException(C0000.decode(new byte[]{55, 95, 92, 65, 84, 7, 86, 31, 67, 71, 92, 19, 82, 3, 74, 21, 67, 71, 90, 21, 81, 70, 91, 9, 13, 68, 86, 15, 77, 51, 74, 15, 55, 66, 90, 6, 94, 3, 74, 21, 67, 81, 65, 4, 25, 3, 86, 23, 22, 85, 70, 4, 93, 92, 50, 5, 12, 94, 71, 4, 87, 18, 109, 20, 10, 100, 65, 8, 94, 1, 93, 20, 67, 71, 92, 19, 82, 3, 74, 21, 67, 92, 90, 12, 80, 18, 2, 70}, "c03a9f8f") + i4 + C0000.decode(new byte[]{8, 108, 4, 90, 66, 92, 85, 87, 73, 24, 86, 15, 66, 65, 86, 19, 0, 82, 16, 90, 91, 70, 94, 76, 9, 65}, "3fe60943083a34") + i3 + C0000.decode(new byte[]{10, 108, 91, 77, 16, 74, 84, 8, 76, 24, 7, 86, 64, 19, 93, 77, 7, 24, 94, 22, 93, 74, 3, 76, 88, 9, 86, 24, 1, 87, 68, 8, 76, 2, 66}, "1f88b8", false) + i2 + C0000.decode(new byte[]{26, 111, 54, 95, 16, 4, 0, 84, 20, 80, 16, 17, 20, 17, 10, 89, 67, 69, 13, 67, 21, 64, 6, 66, 77, 10, 23, 16, 83, 4, 10, 10, 70, 63, 82, 76, 20, 0, 12, 65, 69, 0, 17, 85, 70, 89, 6, 17, 71, 69, 21, 95, 66, 14, 1, 66, 21, 21, 12, 16, 20, 7, 3, 68, 83, 13, 68, 67, 9, 88, 6, 66, 91, 3, 66, 71, 95, 23, 15, 85, 20, 70, 67, 21, 93, 17, 10, 16, 83, 10, 10, 68, 3, 91, 23, 66, 65, 23, 11, 16, 68, 23, 13, 87, 1, 80, 17, 17, 20, 17, 13, 87, 85, 17, 12, 85, 20, 14, 105, 80, 26, 69, 11, 94, 83, 23, 1, 81, 21, 80, 67, 14, 93, 8, 11, 68, 16, 19, 13, 81, 70, 118, 12, 12, 82, 12, 5, 69, 66, 4, 16, 89, 9, 91, 77, 32, 65, 12, 14, 84, 85, 23, 74, 67, 3, 65, 32, 13, 90, 17, 7, 94, 68, 48, 22, 89, 50, 71, 10, 5, 83, 0, 16, 103, 95, 23, 15, 85, 20, 70, 47, 11, 89, 12, 22, 11, 58, 53, 8, 85, 7, 70, 6, 66, 86, 0, 21, 81, 66, 0, 68, 68, 14, 84, 23, 66, 67, 10, 16, 91, 85, 23, 23, 16, 17, 92, 23, 10, 20, 6, 13, 94, 68, 0, 10, 68, 70, 64, 17, 11, 20, 17, 16, 89, 87, 2, 1, 66, 21, 21, 10, 15, 89, 0, 6, 89, 81, 17, 1, 92, 31, 21, 12, 1, 87, 16, 18, 73, 16, 22, 8, 95, 18, 70, 67, 11, 90, 69, 40, 95, 82, 54, 7, 88, 3, 81, 22, 14, 81, 23, 66, 67, 95, 69, 10, 95, 70, 64, 19, 6, 85, 17, 7, 67, 16, 17, 11, 16, 5, 90, 13, 22, 81, 11, 22, 16, 69, 23, 13, 67, 70, 84, 17, 7, 20, 8, 11, 67, 67, 0, 0, 30}, "4eb00ed0f5cb", 7));
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    public static void checkRadix(int i) {
        if (new IntRange(2, 36, 1).contains(i)) {
            return;
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{68, 82, 7, 93, 26, 24}, "63c4b8f7ab1a128b", 3) + i + C0000.decode(new byte[]{17, 20, 3, 71, 20, 92, 93, 69, 17, 10, 12, 20, 66, 83, 94, 88, 85, 67, 16, 85, 90, 85, 87, 17}, "1cb44221", 0.0f) + new IntRange(2, 36, 1));
    }

    public static Bundle createBundle(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + size);
        return bundle;
    }

    public static Parcelable createParcelable(Parcel parcel, int i, Parcelable.Creator creator) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + size);
        return parcelable;
    }

    public static String createString(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + size);
        return string;
    }

    public static Object[] createTypedArray(Parcel parcel, int i, Parcelable.Creator creator) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + size);
        return objArrCreateTypedArray;
    }

    public static void ensureAtEnd(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new StartupException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{44, 23, 93, 75, 17, 85, 83, 85, 69, 89, 8, 90, 92, 66, 83, 7, 67, 18, 81, 67, 6, 16, 87, 95, 1, 5}, "ca89c021e8d6356c", true), i), parcel);
        }
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static MediaType get(String str) {
        Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException((C0000.decode(new byte[]{124, 89, 70, 75, 70, 86, 64, 75, 66, 83, 70, 94, 92, 65, 90, 86, 18, 80, 9, 74, 9, 20, 22}, "26f83442", false) + str + '\"').toString());
        }
        String strGroup = matcher.group(1);
        Locale locale = Locale.US;
        strGroup.toLowerCase(locale);
        matcher.group(2).toLowerCase(locale);
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = MediaType.PARAMETER.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException((C0000.decode(new byte[]{103, 81, 68, 80, 12, 7, 17, 1, 20, 19, 12, 65, 23, 94, 89, 69, 65, 4, 10, 22, 11, 82, 17, 70, 82, 84, 22, 82, 14, 16, 23, 1, 5, 71, 9, 75, 13, 16, 20}, "7061abedf3e2", 0.0f) + str.substring(iEnd) + C0000.decode(new byte[]{26, 23, 86, 86, 20, 13, 20, 16}, "8709f742fbc90500") + str + '\"').toString());
            }
            String strGroup2 = matcher2.group(1);
            if (strGroup2 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else {
                    String strDecode = C0000.decode(new byte[]{22}, "181676a0", 0.0f);
                    if (strGroup3.startsWith(strDecode) && strGroup3.endsWith(strDecode) && strGroup3.length() > 2) {
                        strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                    }
                }
                arrayList.add(strGroup2);
                arrayList.add(strGroup3);
                iEnd = matcher2.end();
            }
        }
        return new MediaType(str, (String[]) arrayList.toArray(new String[0]));
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String strDecode;
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex(C0000.decode(new byte[]{89}, "95f5a51434", true) + str + '`');
            if (columnIndex < 0) {
                columnIndex = -1;
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            String strDecode2 = C0000.decode(new byte[]{24, 20}, "449673");
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "");
            int i = 0;
            for (String str2 : columnNames) {
                i++;
                if (i > 1) {
                    sb.append((CharSequence) strDecode2);
                }
                CloseableKt.appendElement(sb, str2, null);
            }
            sb.append((CharSequence) "");
            strDecode = sb.toString();
        } catch (Exception unused) {
            strDecode = C0000.decode(new byte[]{76, 13, 89, 93, 88, 18, 15}, "9c237ea79ffee047");
        }
        throw new IllegalArgumentException(C0000.decode(new byte[]{80, 87, 91, 67, 91, 91, 18, 20}, "38766523", true) + str + C0000.decode(new byte[]{18, 68, 87, 93, 92, 64, 21, 90, 90, 76, 65, 93, 77, 13, 64, 70, 23, 19, 116, 66, 84, 81, 13, 89, 87, 8, 86, 18, 90, 92, 89, 65, 88, 86, 18, 2, 21}, "5d32935458a8") + strDecode);
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                if (i4 < 0) {
                    i4 += i3;
                }
                int i5 = i % i3;
                if (i5 < 0) {
                    i5 += i3;
                }
                int i6 = (i4 - i5) % i3;
                if (i6 < 0) {
                    i6 += i3;
                }
                return i2 - i6;
            }
        } else {
            if (i3 >= 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{101, 68, 84, 20, 25, 81, 75, 68, 76, 80, 22, 94, 30}, "601d988d65d100"));
            }
            if (i > i2) {
                int i7 = -i3;
                int i8 = i % i7;
                if (i8 < 0) {
                    i8 += i7;
                }
                int i9 = i2 % i7;
                if (i9 < 0) {
                    i9 += i7;
                }
                int i10 = (i8 - i9) % i7;
                if (i10 < 0) {
                    i10 += i7;
                }
                return i10 + i2;
            }
        }
        return i2;
    }

    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:27:0x010d
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:280)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:79)
        */
    public static void logToScion(java.lang.String r7, android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.CharsKt.logToScion(java.lang.String, android.os.Bundle):void");
    }

    public static boolean readBoolean(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int readInt(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        return parcel.readInt();
    }

    public static int readSize(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static boolean shouldUploadScionMetrics(Intent intent) {
        Bundle extras;
        if (intent == null || C0000.decode(new byte[]{81, 90, 92, 23, 2, 14, 88, 85, 94, 80, 31, 95, 12, 19, 82, 80, 83, 70, 84, 23, 8, 4, 68, 65, 83, 82, 88, 87, 2, 79, 101, 119, 113, 112, 120, 111, 32, 62, 115, 123, 96, 112, 114, 109, 58, 35, 120, 125, 102}, "2519ea72", 4).equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            return false;
        }
        return C0000.decode(new byte[]{80}, "ad28e46810eb").equals(extras.getString(C0000.decode(new byte[]{86, 13, 86, 1, 88, 86, 22, 84, 31, 3, 23, 3}, "1b9f4387", false)));
    }

    public static void skipUnknownField(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i));
    }

    public static void start(Context context) {
        try {
            Intent intent = new Intent(context, (Class<?>) GuardianService.class);
            intent.putExtra(C0000.decode(new byte[]{102, 89, 3, 11, 95, 108, 21, 81, 82}, "94bb13e86b", 0.0f), Process.myPid());
            context.startForegroundService(intent);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static final Object startUndispatchedOrReturn(ScopeCoroutine scopeCoroutine, ScopeCoroutine scopeCoroutine2, Function2 function2) throws Throwable {
        Object completedExceptionally;
        Object objMakeCompletingOnce$kotlinx_coroutines_core;
        Incomplete incomplete;
        try {
            Intrinsics.beforeCheckcastToFunctionOfArity(2, function2);
            completedExceptionally = function2.invoke(scopeCoroutine2, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (completedExceptionally == coroutineSingletons || (objMakeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) == BuildersKt.COMPLETING_WAITING_CHILDREN) {
            return coroutineSingletons;
        }
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objMakeCompletingOnce$kotlinx_coroutines_core).cause;
        }
        IncompleteStateBox incompleteStateBox = objMakeCompletingOnce$kotlinx_coroutines_core instanceof IncompleteStateBox ? (IncompleteStateBox) objMakeCompletingOnce$kotlinx_coroutines_core : null;
        return (incompleteStateBox == null || (incomplete = incompleteStateBox.state) == null) ? objMakeCompletingOnce$kotlinx_coroutines_core : incomplete;
    }

    public static int validateObjectHeader(Parcel parcel) {
        int i = parcel.readInt();
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (((char) i) != 20293) {
            throw new StartupException(C0000.decode(new byte[]{119, 79, 17, 1, 90, 66, 7, 7, 18, 88, 3, 14, 92, 85, 22, 67, 90, 82, 0, 0, 92, 68, 76, 67, 117, 88, 21, 68, 9, 78}, "27ad96bc", 5).concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
        int i2 = size + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new StartupException(NetworkType$EnumUnboxingLocalUtility.m(iDataPosition, i2, C0000.decode(new byte[]{98, 13, 66, 0, 16, 65, 92, 81, 85, 24, 88, 23, 17, 13, 86, 19, 81, 95, 80, 84, 17, 75, 69, 5, 67, 16, 5}, "1d8e0390181d", false), C0000.decode(new byte[]{20, 4, 90, 84, 88}, "4a40e3b097f82141", 7)), parcel);
        }
        return i2;
    }

    public static void zzb(Parcel parcel, int i, int i2) {
        int size = readSize(parcel, i);
        if (size == i2) {
            return;
        }
        String hexString = Integer.toHexString(size);
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{119, 74, 18, 4, 90, 21, 87, 86, 66, 18, 80, 27, 87, 18}, "22ba9a"));
        sb.append(i2);
        sb.append(C0000.decode(new byte[]{24, 5, 89, 77, 69}, "8b69ea41fe465c88", false));
        sb.append(size);
        sb.append(C0000.decode(new byte[]{24, 25, 9, 76}, "819441", true));
        throw new StartupException(FileSectionType$EnumUnboxingLocalUtility.m(sb, hexString, C0000.decode(new byte[]{75}, "bfd355b63084", 0.0f)), parcel);
    }

    public abstract List clean(String str, List list);
}
