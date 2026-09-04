package com.google.android.gms.common.internal;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.common.api.GoogleApiActivity;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class zad implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Intent zaa;
    public final /* synthetic */ Object zab;

    public /* synthetic */ zad(Intent intent, Object obj, int i) {
        this.$r8$classId = i;
        this.zaa = intent;
        this.zab = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            zaa();
        } catch (ActivityNotFoundException unused) {
            Build.FINGERPRINT.contains(C0000.decode(new byte[]{87, 7, 90, 85, 20, 12, 83}, "0b40fe", 0.0f));
        } finally {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.gms.common.api.internal.LifecycleFragment, java.lang.Object] */
    public final void zaa() {
        switch (this.$r8$classId) {
            case 0:
                Intent intent = this.zaa;
                if (intent != null) {
                    ((GoogleApiActivity) this.zab).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.zaa;
                if (intent2 != null) {
                    this.zab.startActivityForResult(intent2, 2);
                }
                break;
        }
    }
}
