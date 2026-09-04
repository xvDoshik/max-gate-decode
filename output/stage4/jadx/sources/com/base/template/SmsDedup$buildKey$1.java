package com.base.template;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SmsDedup$buildKey$1 extends Lambda implements Function1 {
    public static final SmsDedup$buildKey$1 INSTANCE;
    public static final SmsDedup$buildKey$1 INSTANCE$1;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 1;
        INSTANCE = new SmsDedup$buildKey$1(i, 0);
        INSTANCE$1 = new SmsDedup$buildKey$1(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmsDedup$buildKey$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return String.format(C0000.decode(new byte[]{18, 6, 0, 73}, "76215dd5", 0.0f), Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
            default:
                return String.format(C0000.decode(new byte[]{20, 81, 87, 76}, "1ae4c4f40c75", 0.0f), Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
        }
    }
}
