package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzag;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class ErrorDialogFragment extends DialogFragment {
    public Dialog zaa;
    public DialogInterface.OnCancelListener zab;
    public AlertDialog zac;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zab;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.zaa;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.zac == null) {
            Activity activity = getActivity();
            zzag.checkNotNull(activity);
            this.zac = new AlertDialog.Builder(activity).create();
        }
        return this.zac;
    }
}
