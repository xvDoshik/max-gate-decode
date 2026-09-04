package com.base.template.sync;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class StubAuthenticator extends AbstractAccountAuthenticator {
    public StubAuthenticator(Context context) {
        super(context);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Void addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Void confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Void editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Void getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Void getAuthTokenLabel(String str) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Void hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public Void updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        return null;
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public /* bridge */ /* synthetic */ Bundle addAccount(AccountAuthenticatorResponse accountAuthenticatorResponse, String str, String str2, String[] strArr, Bundle bundle) {
        return (Bundle) addAccount(accountAuthenticatorResponse, str, str2, strArr, bundle);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public /* bridge */ /* synthetic */ Bundle confirmCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, Bundle bundle) {
        return (Bundle) confirmCredentials(accountAuthenticatorResponse, account, bundle);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public /* bridge */ /* synthetic */ Bundle editProperties(AccountAuthenticatorResponse accountAuthenticatorResponse, String str) {
        return (Bundle) editProperties(accountAuthenticatorResponse, str);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public /* bridge */ /* synthetic */ Bundle getAuthToken(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        return (Bundle) getAuthToken(accountAuthenticatorResponse, account, str, bundle);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public /* bridge */ /* synthetic */ String getAuthTokenLabel(String str) {
        return (String) getAuthTokenLabel(str);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public /* bridge */ /* synthetic */ Bundle hasFeatures(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String[] strArr) {
        return (Bundle) hasFeatures(accountAuthenticatorResponse, account, strArr);
    }

    @Override // android.accounts.AbstractAccountAuthenticator
    public /* bridge */ /* synthetic */ Bundle updateCredentials(AccountAuthenticatorResponse accountAuthenticatorResponse, Account account, String str, Bundle bundle) {
        return (Bundle) updateCredentials(accountAuthenticatorResponse, account, str, bundle);
    }
}
