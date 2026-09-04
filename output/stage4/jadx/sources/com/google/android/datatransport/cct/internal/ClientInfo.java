package com.google.android.datatransport.cct.internal;

import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class ClientInfo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public final class ClientType {
        public static final /* synthetic */ ClientType[] $VALUES;
        public static final ClientType ANDROID_FIREBASE;

        /* JADX INFO: Fake field, exist only in values array */
        ClientType EF0;

        static {
            ClientType clientType = new ClientType(C0000.decode(new byte[]{101, 120, 125, 127, 126, 111, 118}, "0661188c6582c4c2"), 0);
            ClientType clientType2 = new ClientType(C0000.decode(new byte[]{113, 126, 118, 100, 124, 40, 116, 111, 116, 127, 97, 36, 114, 113, 97, 115}, "00263a", 0.0f), 1);
            ANDROID_FIREBASE = clientType2;
            $VALUES = new ClientType[]{clientType, clientType2};
        }

        public static ClientType valueOf(String str) {
            return (ClientType) Enum.valueOf(ClientType.class, str);
        }

        public static ClientType[] values() {
            return (ClientType[]) $VALUES.clone();
        }
    }
}
