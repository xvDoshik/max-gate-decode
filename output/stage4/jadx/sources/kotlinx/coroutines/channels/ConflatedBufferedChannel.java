package kotlinx.coroutines.channels;

import androidx.profileinstaller.FileSectionType$EnumUnboxingLocalUtility;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ConflatedBufferedChannel extends BufferedChannel {
    public final int onBufferOverflow;

    public ConflatedBufferedChannel(int i, int i2) {
        String str;
        super(i);
        this.onBufferOverflow = i2;
        if (i2 != 1) {
            if (i < 1) {
                throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{33, 20, 0, 87, 83, 16, 1, 82, 18, 6, 11, 0, 8, 95, 83, 14, 68, 85, 83, 21, 2, 2, 15, 69, 79, 66, 9, 67, 65, 17, 67, 3, 3, 17, 87, 22, 68, 90, 87, 4, 16, 21, 70, 0, 26, 66, 6, 67, 70, 69}, "caf16bd62e", 0.0f), C0000.decode(new byte[]{65, 21, 7, 69, 70, 75, 22, 3, 2, 11, 0, 95, 3, 92}, "abf6f8ff"), i).toString());
            }
            return;
        }
        StringBuilder sb = new StringBuilder(C0000.decode(new byte[]{96, 94, 15, 22, 22, 95, 85, 73, 85, 92, 89, 83, 8, 17, 87, 66, 81, 86, 87, 25, 80, 89, 3, 22, 22, 88, 87, 77, 25, 74, 65, 70, 22, 10, 68, 66, 24, 74, 76, 74, 68, 83, 8, 22, 95, 89, 86, 25, 95, 86, 70, 22, 21, 0, 88, 82, 93, 75, 74, 21, 20, 67, 21, 0, 22}, "46fe668999", 0.0f));
        Reflection.factory.getClass();
        LinkedHashMap linkedHashMap = ClassReference.simpleNames;
        String simpleName = null;
        if (!BufferedChannel.class.isAnonymousClass()) {
            if (BufferedChannel.class.isLocalClass()) {
                simpleName = BufferedChannel.class.getSimpleName();
                Method enclosingMethod = BufferedChannel.class.getEnclosingMethod();
                if (enclosingMethod == null) {
                    Constructor<?> enclosingConstructor = BufferedChannel.class.getEnclosingConstructor();
                    if (enclosingConstructor == null) {
                        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) simpleName, '$', 0, 6);
                        if (iIndexOf$default != -1) {
                            simpleName = simpleName.substring(iIndexOf$default + 1, simpleName.length());
                        }
                    } else {
                        simpleName = StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + '$');
                    }
                } else {
                    simpleName = StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + '$');
                }
            } else if (BufferedChannel.class.isArray()) {
                Class<?> componentType = BufferedChannel.class.getComponentType();
                boolean zIsPrimitive = componentType.isPrimitive();
                String strDecode = C0000.decode(new byte[]{113, 22, 19, 2, 79}, "0dac6952", 6);
                if (zIsPrimitive && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                    simpleName = str.concat(strDecode);
                }
                if (simpleName == null) {
                    simpleName = strDecode;
                }
            } else {
                simpleName = (String) linkedHashMap.get(BufferedChannel.class.getName());
                if (simpleName == null) {
                    simpleName = BufferedChannel.class.getSimpleName();
                }
            }
        }
        throw new IllegalArgumentException(FileSectionType$EnumUnboxingLocalUtility.m(sb, simpleName, C0000.decode(new byte[]{22, 88, 12, 69, 66, 7, 4, 83}, "61b66be7a9ebd1d2", false)).toString());
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean isConflatedDropOldest() {
        return this.onBufferOverflow == 2;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object send(IndexedValue indexedValue, CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1) throws Throwable {
        if (m18trySendImplMj0NB7M(indexedValue, true) instanceof ChannelResult.Closed) {
            throw getSendException();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public final Object mo17trySendJP2dKIU(Object obj) {
        return m18trySendImplMj0NB7M(obj, false);
    }

    /* JADX INFO: renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    public final Object m18trySendImplMj0NB7M(Object obj, boolean z) {
        Unit unit = Unit.INSTANCE;
        if (this.onBufferOverflow == 3) {
            Object objMo17trySendJP2dKIU = super.mo17trySendJP2dKIU(obj);
            return (!(objMo17trySendJP2dKIU instanceof ChannelResult.Failed) || (objMo17trySendJP2dKIU instanceof ChannelResult.Closed)) ? objMo17trySendJP2dKIU : unit;
        }
        SupportSQLiteQuery supportSQLiteQuery = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment = (ChannelSegment) BufferedChannel.sendSegment$FU.get(this);
        while (true) {
            long andIncrement = BufferedChannel.sendersAndCloseStatus$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosed = isClosed(andIncrement, false);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = i;
            long j3 = j / j2;
            int i2 = (int) (j % j2);
            if (channelSegment.id != j3) {
                ChannelSegment channelSegmentAccess$findSegmentSend = BufferedChannel.access$findSegmentSend(this, j3, channelSegment);
                if (channelSegmentAccess$findSegmentSend != null) {
                    channelSegment = channelSegmentAccess$findSegmentSend;
                } else if (zIsClosed) {
                    return new ChannelResult.Closed(getSendException());
                }
            }
            int iAccess$updateCellSend = BufferedChannel.access$updateCellSend(this, channelSegment, i2, obj, j, supportSQLiteQuery, zIsClosed);
            if (iAccess$updateCellSend == 0) {
                channelSegment.cleanPrev();
                return unit;
            }
            if (iAccess$updateCellSend != 1) {
                if (iAccess$updateCellSend != 2) {
                    if (iAccess$updateCellSend == 3) {
                        throw new IllegalStateException(C0000.decode(new byte[]{70, 95, 0, 76, 22, 83, 87, 76, 81, 81}, "31e4f64845", 0.0f));
                    }
                    if (iAccess$updateCellSend == 4) {
                        if (j < BufferedChannel.receivers$FU.get(this)) {
                            channelSegment.cleanPrev();
                        }
                        return new ChannelResult.Closed(getSendException());
                    }
                    if (iAccess$updateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                } else {
                    if (zIsClosed) {
                        channelSegment.onSlotCleaned();
                        return new ChannelResult.Closed(getSendException());
                    }
                    Waiter waiter = supportSQLiteQuery instanceof Waiter ? (Waiter) supportSQLiteQuery : null;
                    if (waiter != null) {
                        waiter.invokeOnCancellation(channelSegment, i2 + i);
                    }
                    dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((channelSegment.id * j2) + ((long) i2));
                }
            }
            return unit;
        }
    }
}
