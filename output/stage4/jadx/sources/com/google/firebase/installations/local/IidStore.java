package com.google.firebase.installations.local;

import android.content.SharedPreferences;
import android.util.Base64;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class IidStore {
    public static final String[] ALLOWABLE_SCOPES = {C0000.decode(new byte[]{24}, "2e4374c1fd2024a3", 2), C0000.decode(new byte[]{113, 38, 126}, "7e39a5fc", false), C0000.decode(new byte[]{34, 39, 44}, "eda7f2bafe57de", 0.0f), ""};
    public final String defaultSenderId;
    public final SharedPreferences iidPrefs;

    /* JADX WARN: Code duplicated, block: B:12:0x0073  */
    public IidStore(FirebaseApp firebaseApp) {
        firebaseApp.checkNotDeleted();
        this.iidPrefs = firebaseApp.applicationContext.getSharedPreferences(C0000.decode(new byte[]{2, 90, 12, 22, 84, 92, 95, 2, 15, 83, 72, 3, 15, 81, 19, 87, 90, 87, 30, 2, 14, 69, 72, 3, 17, 69, 8, 92}, "a5a8330ec6fb", true), 0);
        firebaseApp.checkNotDeleted();
        FirebaseOptions firebaseOptions = firebaseApp.options;
        String str = firebaseOptions.gcmSenderId;
        if (str == null) {
            firebaseApp.checkNotDeleted();
            str = firebaseOptions.applicationId;
            if (str.startsWith(C0000.decode(new byte[]{83, 11}, "b14b9e3b3053ad0d", false)) || str.startsWith(C0000.decode(new byte[]{83, 94}, "ad835a99a8720d22"))) {
                String[] strArrSplit = str.split(C0000.decode(new byte[]{94}, "d2a3445798", 0.0f));
                if (strArrSplit.length != 4) {
                    str = null;
                } else {
                    str = strArrSplit[1];
                    if (str.isEmpty()) {
                        str = null;
                    }
                }
            }
        }
        this.defaultSenderId = str;
    }

    public final String readPublicKeyFromLocalStorageAndCalculateInstanceId() {
        PublicKey publicKeyGeneratePublic;
        synchronized (this.iidPrefs) {
            String strEncodeToString = null;
            String string = this.iidPrefs.getString(C0000.decode(new byte[]{29, 106, 79, 72, 97, 24}, "a9341d39768abd64"), null);
            if (string == null) {
                return null;
            }
            try {
                publicKeyGeneratePublic = KeyFactory.getInstance(C0000.decode(new byte[]{98, 106, 118}, "097817")).generatePublic(new X509EncodedKeySpec(Base64.decode(string, 8)));
            } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
                e.toString();
                publicKeyGeneratePublic = null;
            }
            if (publicKeyGeneratePublic == null) {
                return null;
            }
            try {
                byte[] bArrDigest = MessageDigest.getInstance(C0000.decode(new byte[]{103, 125, 121, 1}, "4580a56e681847e4")).digest(publicKeyGeneratePublic.getEncoded());
                bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
                strEncodeToString = Base64.encodeToString(bArrDigest, 0, 8, 11);
            } catch (NoSuchAlgorithmException unused) {
            }
            return strEncodeToString;
        }
    }
}
