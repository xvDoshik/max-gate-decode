package okhttp3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.room.RoomOpenHelper;
import androidx.startup.StartupException;
import androidx.work.Constraints;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.base.template.services.CommandService;
import com.google.firebase.messaging.ByteStreams$LimitedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.DispatchedContinuation;
import okhttp3.internal.Util;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class Headers implements Iterable {
    public final String[] namesAndValues;

    public abstract class Companion {
        public static boolean sActionBarFieldsFetched;
        public static Method sActionBarOnMenuKeyMethod;

        public static final LinkedHashSet byteArrayToSetOfTriggers(byte[] bArr) throws IOException {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (bArr.length == 0) {
                return linkedHashSet;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        int i = objectInputStream.readInt();
                        for (int i2 = 0; i2 < i; i2++) {
                            linkedHashSet.add(new Constraints.ContentUriTrigger(Uri.parse(objectInputStream.readUTF()), objectInputStream.readBoolean()));
                        }
                        objectInputStream.close();
                        byteArrayInputStream.close();
                        return linkedHashSet;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(objectInputStream, th);
                            throw th2;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(byteArrayInputStream, th3);
                    throw th4;
                }
            }
        }

        public static void checkName(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{11, 0, 84, 93, 67, 10, 17, 16, 3, 9, 69, 66, 74}, "ea98ccb0fd563f", false));
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.format(C0000.decode(new byte[]{102, 95, 93, 65, 67, 81, 90, 22, 0, 87, 25, 2, 91, 88, 23, 21, 22, 18, 8, 13, 75, 20, 88, 22, 69, 22, 93, 65, 90, 87, 69, 93, 86, 80, 92, 92, 65, 20, 87, 3, 8, 86, 3, 65, 22, 74}, "3189349be39a39e5", 4), Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        public static void checkValue(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(Util.format(C0000.decode(new byte[]{101, 86, 1, 26, 72, 1, 87, 16, 0, 82, 23, 87, 88, 89, 22, 66, 29, 71, 4, 80, 29, 22, 86, 64, 16, 29, 0, 66, 81, 10, 20, 65, 22, 22, 65, 85, 92, 77, 1}, "08db8d4de674", 2), Integer.valueOf(cCharAt), Integer.valueOf(i), str2));
                    sb.append(Util.isSensitiveHeader(str2) ? "" : C0000.decode(new byte[]{9, 67}, "3c29fa", 0.0f).concat(str));
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }

        public static byte[] combineBuffers(ArrayDeque arrayDeque, int i) {
            if (arrayDeque.isEmpty()) {
                return new byte[0];
            }
            byte[] bArr = (byte[]) arrayDeque.remove();
            if (bArr.length == i) {
                return bArr;
            }
            int length = i - bArr.length;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
            while (length > 0) {
                byte[] bArr2 = (byte[]) arrayDeque.remove();
                int iMin = Math.min(length, bArr2.length);
                System.arraycopy(bArr2, 0, bArrCopyOf, i - length, iMin);
                length -= iMin;
            }
            return bArrCopyOf;
        }

        public static final void copyOfRangeToIndexCheck(int i, int i2) {
            if (i <= i2) {
                return;
            }
            throw new IndexOutOfBoundsException(C0000.decode(new byte[]{17, 88, 127, 12, 80, 7, 79, 70, 77}, "e76b4b7f", 0) + i + C0000.decode(new byte[]{24, 66, 90, 71, 17, 85, 23, 83, 3, 77, 84, 16, 19, 64, 89, 83, 11, 22, 17, 80, 75, 7, 19, 28}, "1b3412e6b9", 5) + i2 + C0000.decode(new byte[]{79, 22}, "f8819e21f459ce", 2));
        }

        public static boolean dispatchBeforeHierarchy(View view, KeyEvent keyEvent) {
            ArrayList arrayList;
            int size;
            int iIndexOfKey;
            int i = ViewCompat.$r8$clinit;
            if (Build.VERSION.SDK_INT >= 28) {
                return false;
            }
            ArrayList arrayList2 = ViewCompat.UnhandledKeyEventManager.sViewsWithListeners;
            ViewCompat.UnhandledKeyEventManager unhandledKeyEventManager = (ViewCompat.UnhandledKeyEventManager) view.getTag(2131099738);
            WeakReference weakReference = null;
            if (unhandledKeyEventManager == null) {
                unhandledKeyEventManager = new ViewCompat.UnhandledKeyEventManager();
                unhandledKeyEventManager.mViewsContainingListeners = null;
                unhandledKeyEventManager.mCapturedKeys = null;
                unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = null;
                view.setTag(2131099738, unhandledKeyEventManager);
            }
            WeakReference weakReference2 = unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            unhandledKeyEventManager.mLastDispatchedPreViewKeyEvent = new WeakReference(keyEvent);
            if (unhandledKeyEventManager.mCapturedKeys == null) {
                unhandledKeyEventManager.mCapturedKeys = new SparseArray();
            }
            SparseArray sparseArray = unhandledKeyEventManager.mCapturedKeys;
            if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
                sparseArray.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view2 = (View) weakReference.get();
            if (view2 == null || !ViewCompat.Api19Impl.isAttachedToWindow(view2) || (arrayList = (ArrayList) view2.getTag(2131099739)) == null || (size = arrayList.size() - 1) < 0) {
                return true;
            }
            arrayList.get(size).getClass();
            throw new ClassCastException();
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0077  */
        /* JADX WARN: Code duplicated, block: B:27:0x0078  */
        /* JADX WARN: Code duplicated, block: B:30:0x0083 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x002f, B:24:0x0067, B:28:0x007b, B:30:0x0083, B:32:0x0089, B:34:0x008f, B:37:0x00a0, B:39:0x00a8, B:40:0x00bc, B:41:0x00be, B:42:0x00bf, B:43:0x00d5, B:20:0x0056, B:23:0x005d), top: B:58:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:32:0x0089 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x002f, B:24:0x0067, B:28:0x007b, B:30:0x0083, B:32:0x0089, B:34:0x008f, B:37:0x00a0, B:39:0x00a8, B:40:0x00bc, B:41:0x00be, B:42:0x00bf, B:43:0x00d5, B:20:0x0056, B:23:0x005d), top: B:58:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:34:0x008f A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x002f, B:24:0x0067, B:28:0x007b, B:30:0x0083, B:32:0x0089, B:34:0x008f, B:37:0x00a0, B:39:0x00a8, B:40:0x00bc, B:41:0x00be, B:42:0x00bf, B:43:0x00d5, B:20:0x0056, B:23:0x005d), top: B:58:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x00a0 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x002f, B:24:0x0067, B:28:0x007b, B:30:0x0083, B:32:0x0089, B:34:0x008f, B:37:0x00a0, B:39:0x00a8, B:40:0x00bc, B:41:0x00be, B:42:0x00bf, B:43:0x00d5, B:20:0x0056, B:23:0x005d), top: B:58:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:39:0x00a8 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x002f, B:24:0x0067, B:28:0x007b, B:30:0x0083, B:32:0x0089, B:34:0x008f, B:37:0x00a0, B:39:0x00a8, B:40:0x00bc, B:41:0x00be, B:42:0x00bf, B:43:0x00d5, B:20:0x0056, B:23:0x005d), top: B:58:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x00bf A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:13:0x002f, B:24:0x0067, B:28:0x007b, B:30:0x0083, B:32:0x0089, B:34:0x008f, B:37:0x00a0, B:39:0x00a8, B:40:0x00bc, B:41:0x00be, B:42:0x00bf, B:43:0x00d5, B:20:0x0056, B:23:0x005d), top: B:58:0x0021 }] */
        /* JADX WARN: Code duplicated, block: B:44:0x00d6 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:45:0x00d8  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
        
            if (r1.emit(r14, r0) == r5) goto L36;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009d -> B:14:0x0032). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final java.lang.Object emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector r11, kotlinx.coroutines.channels.ProducerCoroutine r12, boolean r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
            /*
                Method dump skipped, instruction units count: 351
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Headers.Companion.emitAllImpl$FlowKt__ChannelsKt(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ProducerCoroutine, boolean, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
        }

        public static final int intToBackoffPolicy(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{114, 93, 66, 92, 5, 18, 15, 87, 18, 18, 82, 93, 89, 70, 4, 64, 21, 24}, "1270a2a8f2", 0.0f), C0000.decode(new byte[]{21, 23, 89, 19, 39, 88, 80, 88, 90, 5, 80, 99, 10, 85, 90, 80, 76}, "5c63e933"), i));
        }

        public static final int intToNetworkType(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 3;
            }
            if (i == 3) {
                return 4;
            }
            if (i == 4) {
                return 5;
            }
            if (Build.VERSION.SDK_INT < 30 || i != 5) {
                throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{113, 87, 16, 15, 87, 65, 91, 9, 64, 24, 81, 87, 11, 21, 86, 19, 65, 70}, "28ec3a5f48", 6), C0000.decode(new byte[]{69, 23, 87, 17, 125, 4, 77, 66, 12, 65, 82, 96, 28, 19, 93}, "ec813a95c394", 0.0f), i));
            }
            return 6;
        }

        public static final int intToOutOfQuotaPolicy(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{122, 90, 77, 9, 92, 18, 8, 91, 77, 21, 91, 10, 86, 68, 3, 70, 77, 21}, "958e82f4"), C0000.decode(new byte[]{22, 22, 86, 66, 125, 16, 68, 122, 85, 97, 19, 92, 67, 83, 102, 13, 85, 11, 81, 28}, "6b9b2e0530f372", false), i));
        }

        public static final int intToState(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 2;
            }
            if (i == 2) {
                return 3;
            }
            if (i == 3) {
                return 4;
            }
            if (i == 4) {
                return 5;
            }
            if (i == 5) {
                return 6;
            }
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{117, 88, 65, 85, 83, 65, 13, 91, 71, 70, 84, 13, 92, 23, 83, 69, 64, 25}, "67497ac43f7b2a", 0), C0000.decode(new byte[]{19, 64, 12, 22, 49, 66, 84, 70, 93}, "34c6b652833b0998", true), i));
        }

        public static Continuation intercepted(Continuation continuation) {
            ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
            if (continuationImpl == null || (continuation = continuationImpl.intercepted) != null) {
                return continuation;
            }
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) continuationImpl._context.get(ContinuationInterceptor$Key.$$INSTANCE);
            Continuation dispatchedContinuation = coroutineDispatcher != null ? new DispatchedContinuation(coroutineDispatcher, continuationImpl) : continuationImpl;
            continuationImpl.intercepted = dispatchedContinuation;
            return dispatchedContinuation;
        }

        public static final int networkTypeToInt(int i) {
            int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(i);
            if (iOrdinal == 0) {
                return 0;
            }
            int i2 = 1;
            if (iOrdinal != 1) {
                i2 = 2;
                if (iOrdinal != 2) {
                    i2 = 3;
                    if (iOrdinal != 3) {
                        i2 = 4;
                        if (iOrdinal != 4) {
                            if (Build.VERSION.SDK_INT >= 30 && i == 6) {
                                return 5;
                            }
                            throw new IllegalArgumentException(C0000.decode(new byte[]{114, 14, 70, 92, 85, 21, 93, 88, 69, 65, 80, 95, 95, 67, 86, 69, 69, 65}, "1a301537") + NetworkType$EnumUnboxingLocalUtility.stringValueOf(i) + C0000.decode(new byte[]{69, 71, 14, 69, 15, 93, 69}, "e3aef31276e9a8", 0.0f));
                        }
                    }
                }
            }
            return i2;
        }

        public static Headers of(String... strArr) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException(C0000.decode(new byte[]{32, 75, 22, 81, 90, 65, 0, 81, 23, 7, 89, 68, 6, 74, 11, 82, 18, 93, 87, 82, 69, 93, 82, 7, 81, 85, 17, 24, 11, 82, 11, 81, 74, 21, 4, 91, 83, 70, 67, 81, 15, 77, 0, 64}, "e3f495e57f50c8", false));
            }
            String[] strArr2 = (String[]) strArr.clone();
            int length = strArr2.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr2[i2];
                if (str == null) {
                    throw new IllegalArgumentException(C0000.decode(new byte[]{122, 80, 7, 87, 80, 74, 16, 21, 1, 80, 93, 95, 89, 65, 18, 87, 3, 19, 91, 77, 15, 89}, "25f358c5b13165", false));
                }
                strArr2[i2] = StringsKt.trim(str).toString();
            }
            int progressionLastElement = CharsKt.getProgressionLastElement(0, strArr2.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    String str2 = strArr2[i];
                    String str3 = strArr2[i + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                }
            }
            return new Headers(strArr2);
        }

        public static RoomOpenHelper parse(String str) throws ProtocolException {
            int i;
            String strSubstring;
            boolean zStartsWith = str.startsWith(C0000.decode(new byte[]{46, 96, 48, 104, 31, 87, 27}, "f4d80f54a33660ef", 6));
            Protocol protocol = Protocol.HTTP_1_0;
            String strDecode = C0000.decode(new byte[]{108, 88, 87, 27, 71, 87, 90, 69, 7, 82, 25, 69, 70, 2, 67, 71, 74, 17, 14, 95, 87, 83, 8, 67}, "962c7291b6", 0.0f);
            if (zStartsWith) {
                i = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException(strDecode.concat(str));
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt != 0) {
                    if (iCharAt != 1) {
                        throw new ProtocolException(strDecode.concat(str));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!str.startsWith(C0000.decode(new byte[]{127, 32, 109, 65}, "6c4a9760", 6))) {
                    throw new ProtocolException(strDecode.concat(str));
                }
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() < i2) {
                throw new ProtocolException(strDecode.concat(str));
            }
            try {
                int i3 = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i2) != ' ') {
                        throw new ProtocolException(strDecode.concat(str));
                    }
                    strSubstring = str.substring(i + 4);
                }
                return new RoomOpenHelper(protocol, i3, strSubstring, 3);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(strDecode.concat(str));
            }
        }

        public static void safeStartService(Context context, String str) {
            try {
                Intent intent = new Intent(context, (Class<?>) CommandService.class);
                intent.setAction(str);
                context.startForegroundService(intent);
            } catch (Exception e) {
                e.getMessage();
                try {
                    Runtime.getRuntime().exec(new String[]{C0000.decode(new byte[]{26, 22, 79, 65, 16, 3, 94, 74, 4, 80, 10, 26, 89, 95}, "5e62df3ef9d582", 0.0f), C0000.decode(new byte[]{74, 22, 3, 64, 22, 20, 95, 95, 66, 83, 94, 16, 13, 71, 12, 93, 20, 67, 85, 68, 79, 11, 1, 87}, "9bb2b99006", 0.0f), C0000.decode(new byte[]{20, 94}, "90ad5325", 0.0f), context.getPackageName() + C0000.decode(new byte[]{76, 85, 91, 94, 23, 7, 2, 69, 81, 29, 77, 0, 14, 70, 88, 82, 77, 0, 77, 69, 81, 65, 79, 12, 0, 83, 71, 29, 122, 10, 14, 91, 85, 93, 93, 54, 6, 68, 66, 90, 90, 0}, "c6439e", 0.0f), C0000.decode(new byte[]{72, 30, 83, 74}, "e3696288", 2), C0000.decode(new byte[]{106, 68, 67, 6}, "571e7861", 4), str});
                } catch (Exception unused) {
                }
            }
        }

        public static final byte[] setOfTriggersToByteArray(Set set) throws IOException {
            if (set.isEmpty()) {
                return new byte[0];
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeInt(set.size());
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        Constraints.ContentUriTrigger contentUriTrigger = (Constraints.ContentUriTrigger) it.next();
                        objectOutputStream.writeUTF(contentUriTrigger.uri.toString());
                        objectOutputStream.writeBoolean(contentUriTrigger.isTriggeredForDescendants);
                    }
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(objectOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(byteArrayOutputStream, th3);
                    throw th4;
                }
            }
        }

        public static final int stateToInt(int i) {
            int iOrdinal = FileSectionType$EnumUnboxingLocalUtility.ordinal(i);
            if (iOrdinal == 0) {
                return 0;
            }
            int i2 = 1;
            if (iOrdinal != 1) {
                i2 = 2;
                if (iOrdinal != 2) {
                    i2 = 3;
                    if (iOrdinal != 3) {
                        i2 = 4;
                        if (iOrdinal != 4) {
                            if (iOrdinal == 5) {
                                return 5;
                            }
                            throw new StartupException();
                        }
                    }
                }
            }
            return i2;
        }

        public static byte[] toByteArray(ByteStreams$LimitedInputStream byteStreams$LimitedInputStream) throws IOException {
            ArrayDeque arrayDeque = new ArrayDeque(20);
            int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(0) * 2));
            int i = 0;
            while (i < 2147483639) {
                int iMin2 = Math.min(iMin, 2147483639 - i);
                byte[] bArr = new byte[iMin2];
                arrayDeque.add(bArr);
                int i2 = 0;
                while (i2 < iMin2) {
                    int i3 = byteStreams$LimitedInputStream.read(bArr, i2, iMin2 - i2);
                    if (i3 == -1) {
                        return combineBuffers(arrayDeque, i);
                    }
                    i2 += i3;
                    i += i3;
                }
                long j = ((long) iMin) * ((long) (iMin < 4096 ? 4 : 2));
                if (j > 2147483647L) {
                    iMin = Integer.MAX_VALUE;
                } else {
                    iMin = j < -2147483648L ? Integer.MIN_VALUE : (int) j;
                }
            }
            if (byteStreams$LimitedInputStream.read() == -1) {
                return combineBuffers(arrayDeque, 2147483639);
            }
            throw new OutOfMemoryError(C0000.decode(new byte[]{88, 91, 65, 65, 77, 68, 80, 21, 17, 65, 94, 91, 25, 8, 88, 20, 86, 80, 17, 64, 86, 68, 95, 15, 69, 21, 88, 90, 25, 5, 25, 4, 72, 65, 84, 20, 88, 22, 75, 7, 72}, "15149d9f", true));
        }
    }

    public Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Headers) {
            return Arrays.equals(this.namesAndValues, ((Headers) obj).namesAndValues);
        }
        return false;
    }

    public final String get(String str) {
        String[] strArr = this.namesAndValues;
        int length = strArr.length - 2;
        int progressionLastElement = CharsKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement > length) {
            return null;
        }
        while (!StringsKt__StringsJVMKt.equals(str, strArr[length])) {
            if (length == progressionLastElement) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = new Pair(name(i), value(i));
        }
        return new ArrayIterator(0, pairArr);
    }

    public final String name(int i) {
        return this.namesAndValues[i * 2];
    }

    public final ConnectionPool newBuilder() {
        ConnectionPool connectionPool = new ConnectionPool(23);
        ((ArrayList) connectionPool.delegate).addAll(Arrays.asList(this.namesAndValues));
        return connectionPool;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strName = name(i);
            String strValue = value(i);
            sb.append(strName);
            sb.append(C0000.decode(new byte[]{89, 25}, "c99a8b753945", true));
            if (Util.isSensitiveHeader(strName)) {
                strValue = C0000.decode(new byte[]{-48, -90, -23, -44, -95, -71}, "20a671fd76", 0.0f);
            }
            sb.append(strValue);
            sb.append(C0000.decode(new byte[]{104}, "b1d031", 0));
        }
        return sb.toString();
    }

    public final String value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }
}
