package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public abstract class Task {
    public abstract zzw addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener);

    public abstract zzw addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener);

    public abstract Exception getException();

    public abstract Object getResult();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();
}
