package com.base.template.network;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SmsFastSend$signKotlin$1 extends Lambda implements Function1 {
    public static final SmsFastSend$signKotlin$1 INSTANCE = new SmsFastSend$signKotlin$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return String.format(C0000.decode(new byte[]{17, 9, 83, 64}, "49a804af08c285", false), Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
    }
}
