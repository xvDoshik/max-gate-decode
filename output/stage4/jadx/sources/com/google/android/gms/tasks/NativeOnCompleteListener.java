package com.google.android.gms.tasks;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public class NativeOnCompleteListener implements OnCompleteListener {
    public native void nativeOnComplete(long j, Object obj, boolean z, boolean z2, String str);

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        Object result;
        String message;
        Exception exception;
        if (task.isSuccessful()) {
            result = task.getResult();
            message = null;
        } else if (((zzw) task).zzd || (exception = task.getException()) == null) {
            result = null;
            message = null;
        } else {
            message = exception.getMessage();
            result = null;
        }
        nativeOnComplete(0L, result, task.isSuccessful(), ((zzw) task).zzd, message);
    }
}
