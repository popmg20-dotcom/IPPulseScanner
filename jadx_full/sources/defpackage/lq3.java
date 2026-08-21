package defpackage;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lq3 extends View {
    public Window b;
    public kq3 f;

    private float getBrightness() {
        Window window = this.b;
        if (window != null) {
            return window.getAttributes().screenBrightness;
        }
        ez4.q("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness(float f) {
        if (this.b == null) {
            ez4.q("ScreenFlashView", "setBrightness: mScreenFlashWindow is null!");
            return;
        }
        if (Float.isNaN(f)) {
            ez4.q("ScreenFlashView", "setBrightness: value is NaN!");
            return;
        }
        WindowManager.LayoutParams attributes = this.b.getAttributes();
        attributes.screenBrightness = f;
        this.b.setAttributes(attributes);
        ez4.o("ScreenFlashView", "Brightness set to " + attributes.screenBrightness);
    }

    private void setScreenFlashUiInfo(vx1 vx1Var) {
        ez4.o("ScreenFlashView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public vx1 getScreenFlash() {
        return this.f;
    }

    public long getVisibilityRampUpAnimationDurationMillis() {
        return 1000L;
    }

    public void setController(yy yyVar) {
        co4.h();
    }

    public void setScreenFlashWindow(Window window) {
        co4.h();
        StringBuilder sb = new StringBuilder("updateScreenFlash: is new window null = ");
        sb.append(window == null);
        sb.append(",  is new window same as previous = ");
        sb.append(window == this.b);
        ez4.o("ScreenFlashView", sb.toString());
        if (this.b != window) {
            this.f = window == null ? null : new kq3(this);
        }
        this.b = window;
        setScreenFlashUiInfo(getScreenFlash());
    }
}
