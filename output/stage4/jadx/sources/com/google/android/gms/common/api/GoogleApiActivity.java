package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.internal.base.zaq;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
@KeepName
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int zaa = 0;

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra(C0000.decode(new byte[]{91, 92, 66, 94, 83, 26, 62, 84, 2, 94, 83, 6, 82, 75}, "53675ca9c02a7914", 7), true);
            this.zaa = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                GoogleApiManager googleApiManagerZam = GoogleApiManager.zam(this);
                if (i2 == -1) {
                    zaq zaqVar = googleApiManagerZam.zat;
                    zaqVar.sendMessage(zaqVar.obtainMessage(3));
                } else if (i2 == 0) {
                    googleApiManagerZam.zaz(new ConnectionResult(13, null), getIntent().getIntExtra(C0000.decode(new byte[]{0, 83, 13, 10, 93, 13, 95, 61, 2, 85, 8, 83, 92, 64, 108, 10, 2}, "f2df4c8ba9a6243c", 5), -1));
                }
            }
        } else if (i == 2) {
            this.zaa = 0;
            setResult(i2, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zaa = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        GoogleApiActivity googleApiActivity;
        super.onCreate(bundle);
        if (bundle != null) {
            this.zaa = bundle.getInt(C0000.decode(new byte[]{64, 85, 23, 92, 94, 17, 18, 91, 95, 15}, "20d32df20a", 0.0f));
        }
        if (this.zaa == 1) {
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get(C0000.decode(new byte[]{19, 82, 94, 1, 80, 10, 85, 105, 10, 89, 68, 0, 87, 16}, "c70e9d26", 0.0f));
        Integer num = (Integer) extras.get(C0000.decode(new byte[]{83, 74, 20, 86, 68, 60, 7, 93, 5, 85}, "68f96cd2a0832e82", 0.0f));
        if (pendingIntent == null && num == null) {
            finish();
            return;
        }
        if (pendingIntent == null) {
            zzag.checkNotNull(num);
            GoogleApiAvailability.zab.showErrorDialogFragment(this, num.intValue(), this);
            this.zaa = 1;
            return;
        }
        try {
            googleApiActivity = this;
            try {
                googleApiActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                googleApiActivity.zaa = 1;
            } catch (ActivityNotFoundException unused) {
                if (extras.getBoolean(C0000.decode(new byte[]{87, 87, 23, 12, 83, 77, 60, 14, 87, 15, 3, 85, 92, 74}, "98ce54cc6ab2"), true)) {
                    GoogleApiManager.zam(this).zaz(new ConnectionResult(22, null), getIntent().getIntExtra(C0000.decode(new byte[]{80, 82, 91, 13, 91, 88, 81, 108, 81, 13, 91, 83, 88, 71, 109, 8, 86}, "632a26", 7), -1));
                } else {
                    String string = pendingIntent.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 36);
                    sb.append(C0000.decode(new byte[]{37, 82, 69, 91, 71, 13, 67, 26, 70, 88, 11, 69, 17, 84, 94, 17, 89, 7, 70, 65, 12, 88, 93, 87, 17, 8, 86, 22, 8, 85, 12, 88, 95, 85, 17}, "d1121d7cf6"));
                    sb.append(string);
                    sb.append(C0000.decode(new byte[]{72}, "f6a90e18", 0.0f));
                    String string2 = sb.toString();
                    if (Build.FINGERPRINT.contains(C0000.decode(new byte[]{85, 6, 90, 84, 20, 12, 81}, "2c41fe", false))) {
                        string2.concat(C0000.decode(new byte[]{19, 98, 95, 94, 67, 17, 94, 87, 78, 23, 95, 82, 80, 67, 69, 23, 71, 89, 86, 88, 23, 69, 85, 66, 92, 90, 65, 94, 94, 86, 19, 113, 88, 88, 87, 93, 86, 22, 103, 91, 81, 72, 19, 69, 82, 69, 70, 88, 80, 83, 68, 23, 83, 94, 93, 88, 82, 84, 68, 88, 92, 88, 23, 94, 67, 66, 70, 83, 68, 23, 95, 95, 19, 83, 90, 66, 92, 80, 71, 89, 69, 68, 16, 70, 90, 66, 95, 23, 119, 94, 92, 81, 91, 82, 16, 112, 99, 127, 68, 23, 82, 68, 71, 22, 89, 88, 68, 17, 116, 89, 88, 80, 92, 84, 19, 102, 91, 86, 73, 17, 96, 66, 88, 69, 85, 31}, "367701"));
                    }
                }
                googleApiActivity.zaa = 1;
                finish();
            } catch (IntentSender.SendIntentException unused2) {
                finish();
            }
        } catch (ActivityNotFoundException unused3) {
            googleApiActivity = this;
        } catch (IntentSender.SendIntentException unused4) {
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(C0000.decode(new byte[]{74, 82, 23, 93, 10, 76, 23, 8, 14, 13}, "87d2f9caac83", 3), this.zaa);
        super.onSaveInstanceState(bundle);
    }
}
