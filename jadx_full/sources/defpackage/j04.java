package defpackage;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.window.SplashScreenView;
import com.getsurfboard.ui.activity.MainActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j04 extends v62 {
    public SplashScreenView A;

    @Override // defpackage.v62
    public final ViewGroup C() {
        SplashScreenView splashScreenView = this.A;
        if (splashScreenView != null) {
            return splashScreenView;
        }
        n12.T("platformView");
        throw null;
    }

    @Override // defpackage.v62
    public final void M() {
        SplashScreenView splashScreenView = this.A;
        if (splashScreenView == null) {
            n12.T("platformView");
            throw null;
        }
        splashScreenView.remove();
        MainActivity mainActivity = (MainActivity) this.f;
        Resources.Theme theme = mainActivity.getTheme();
        theme.getClass();
        View decorView = mainActivity.getWindow().getDecorView();
        decorView.getClass();
        hd4.b(theme, decorView, new TypedValue());
    }

    @Override // defpackage.v62
    public final void t() {
    }
}
