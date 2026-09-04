package com.google.firebase.installations;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class RandomFidGenerator {
    public static final byte FID_4BIT_PREFIX = Byte.parseByte(C0000.decode(new byte[]{0, 5, 6, 9, 0, 83, 2, 0}, "04780c20fec2", 7), 2);
    public static final byte REMOVE_PREFIX_MASK = Byte.parseByte(C0000.decode(new byte[]{0, 81, 6, 81, 4, 84, 87, 87}, "0a6a5eff16403ab9", 5), 2);

    public static String createRandomFid() {
        UUID uuidRandomUUID = UUID.randomUUID();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[17]);
        byteBufferWrap.putLong(uuidRandomUUID.getMostSignificantBits());
        byteBufferWrap.putLong(uuidRandomUUID.getLeastSignificantBits());
        byte[] bArrArray = byteBufferWrap.array();
        byte b = bArrArray[0];
        bArrArray[16] = b;
        bArrArray[0] = (byte) ((b & REMOVE_PREFIX_MASK) | FID_4BIT_PREFIX);
        return new String(Base64.encode(bArrArray, 11), Charset.defaultCharset()).substring(0, 22);
    }
}
