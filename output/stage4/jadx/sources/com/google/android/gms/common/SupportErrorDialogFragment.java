package com.google.android.gms.common;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentManagerImpl.PopBackStackState;
import androidx.work.NetworkType$EnumUnboxingLocalUtility;
import com.google.android.gms.common.internal.zzag;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class SupportErrorDialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public int mBackStackId;
    public boolean mCancelable;
    public Dialog mDialog;
    public boolean mDismissed;
    public boolean mShownByMe;
    public boolean mShowsDialog;
    public int mStyle;
    public int mTheme;
    public boolean mViewDestroyed;
    public Dialog zaa;
    public DialogInterface.OnCancelListener zab;
    public AlertDialog zac;

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        this.mCalled = true;
        if (this.mShowsDialog) {
            FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
            FragmentActivity fragmentActivity = hostCallbacks == null ? null : hostCallbacks.mActivity;
            if (fragmentActivity != null) {
                this.mDialog.setOwnerActivity(fragmentActivity);
            }
            this.mDialog.setCancelable(this.mCancelable);
            this.mDialog.setOnCancelListener(this);
            this.mDialog.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle(C0000.decode(new byte[]{4, 10, 7, 69, 94, 92, 1, 3, 74, 89, 19, 1, 7, 115, 88, 84, 9, 86, 94, 107, 17, 5, 23, 82}, "edc715e998", 0.0f))) == null) {
                return;
            }
            this.mDialog.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zab;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        FragmentManagerImpl fragmentManagerImpl = this.mChildFragmentManager;
        if (fragmentManagerImpl != null && fragmentManagerImpl.mCurState < 1) {
            fragmentManagerImpl.mStateSaved = false;
            fragmentManagerImpl.mStopped = false;
            fragmentManagerImpl.dispatchStateChange(1);
        }
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt(C0000.decode(new byte[]{89, 90, 5, 75, 94, 90, 85, 95, 18, 23, 65, 88, 4}, "84a9131eac", 0.0f), 0);
            this.mTheme = bundle.getInt(C0000.decode(new byte[]{5, 86, 6, 20, 94, 90, 84, 92, 64, 94, 85, 11, 6}, "d8bf130f460fc054", 7), 0);
            this.mCancelable = bundle.getBoolean(C0000.decode(new byte[]{7, 10, 87, 67, 13, 8, 85, 91, 5, 2, 87, 85, 92, 9, 84, 7, 10, 1}, "fd31ba1afc969e5e", true), true);
            this.mShowsDialog = bundle.getBoolean(C0000.decode(new byte[]{87, 15, 92, 20, 11, 10, 81, 3, 23, 92, 89, 22, 75, 34, 13, 2, 89, 86, 3}, "6a8fdc59d4"), this.mShowsDialog);
            this.mBackStackId = bundle.getInt(C0000.decode(new byte[]{0, 11, 85, 75, 12, 88, 87, 2, 86, 81, 90, 83, 49, 23, 0, 6, 90, 112, 7}, "ae19c1384098bc"), -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.mCalled = true;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.dismiss();
            this.mDialog = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        this.mCalled = true;
        if (this.mShownByMe || this.mDismissed) {
            return;
        }
        this.mDismissed = true;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.mViewDestroyed || this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mViewDestroyed = true;
        int i = this.mBackStackId;
        if (i < 0) {
            FragmentManagerImpl fragmentManagerImpl = this.mFragmentManager;
            fragmentManagerImpl.getClass();
            BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
            backStackRecord.addOp(new BackStackRecord.Op(3, this));
            backStackRecord.commitInternal(true);
            return;
        }
        FragmentManagerImpl fragmentManagerImpl2 = this.mFragmentManager;
        fragmentManagerImpl2.getClass();
        if (i < 0) {
            throw new IllegalArgumentException(NetworkType$EnumUnboxingLocalUtility.m(C0000.decode(new byte[]{33, 3, 82, 21, 90, 86, 9, 17}, "cb65323171c1ae2c"), i));
        }
        fragmentManagerImpl2.enqueueAction(fragmentManagerImpl2.new PopBackStackState(i), false);
        this.mBackStackId = -1;
    }

    @Override // androidx.fragment.app.Fragment
    public final LayoutInflater onGetLayoutInflater(Bundle bundle) {
        if (!this.mShowsDialog) {
            return super.onGetLayoutInflater(bundle);
        }
        Dialog dialog = this.zaa;
        if (dialog == null) {
            this.mShowsDialog = false;
            if (this.zac == null) {
                FragmentActivity.HostCallbacks hostCallbacks = this.mHost;
                FragmentActivity fragmentActivity = hostCallbacks == null ? null : hostCallbacks.mContext;
                zzag.checkNotNull(fragmentActivity);
                this.zac = new AlertDialog.Builder(fragmentActivity).create();
            }
            dialog = this.zac;
        }
        this.mDialog = dialog;
        String strDecode = C0000.decode(new byte[]{88, 88, 76, 90, 23, 67, 59, 12, 89, 2, 85, 4, 64, 92, 71}, "4955b7de7d9e", 7);
        if (dialog == null) {
            return (LayoutInflater) this.mHost.mContext.getSystemService(strDecode);
        }
        int i = this.mStyle;
        if (i == 1 || i == 2) {
            dialog.requestWindowFeature(1);
        } else if (i == 3) {
            dialog.getWindow().addFlags(24);
            dialog.requestWindowFeature(1);
        }
        return (LayoutInflater) this.mDialog.getContext().getSystemService(strDecode);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Bundle bundleOnSaveInstanceState;
        Dialog dialog = this.mDialog;
        if (dialog != null && (bundleOnSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle(C0000.decode(new byte[]{2, 12, 87, 20, 90, 90, 6, 95, 70, 0, 19, 85, 7, 37, 10, 3, 95, 9, 82, 96, 22, 4, 65, 4}, "cb3f53be5ae0ca", 0.0f), bundleOnSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt(C0000.decode(new byte[]{88, 92, 87, 65, 87, 91, 81, 3, 74, 68, 64, 94, 86}, "9233825990"), i);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt(C0000.decode(new byte[]{83, 86, 81, 64, 11, 11, 84, 9, 65, 14, 87, 85, 80}, "2852db035f", 0.0f), i2);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean(C0000.decode(new byte[]{86, 13, 2, 70, 10, 91, 7, 9, 0, 7, 95, 81, 0, 8, 4, 1, 91, 6}, "7cf4e2c3cf12edec"), z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean(C0000.decode(new byte[]{4, 91, 5, 70, 93, 8, 1, 15, 18, 92, 93, 22, 22, 113, 8, 85, 94, 14, 2}, "e5a42a", 3), z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt(C0000.decode(new byte[]{87, 90, 81, 22, 94, 80, 0, 11, 81, 2, 87, 14, 48, 66, 87, 87, 94, 45, 85}, "645d19d13c4ec6", true), i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        this.mCalled = true;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        this.mCalled = true;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }
}
