package defpackage;

import android.R;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.Window;
import android.window.SplashScreen;
import android.window.SplashScreenView;
import com.getsurfboard.ui.activity.MainActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i04 extends x8 {
    public boolean Z;
    public final h04 y0;

    public i04(MainActivity mainActivity) {
        super(mainActivity);
        this.Z = true;
        this.y0 = new h04(this, mainActivity);
    }

    public static final void M(i04 i04Var, of2 of2Var, SplashScreenView splashScreenView) {
        splashScreenView.getClass();
        TypedValue typedValue = new TypedValue();
        MainActivity mainActivity = (MainActivity) i04Var.b;
        Resources.Theme theme = mainActivity.getTheme();
        Window window = mainActivity.getWindow();
        if (theme.resolveAttribute(R.attr.statusBarColor, typedValue, true)) {
            window.setStatusBarColor(typedValue.data);
        }
        if (theme.resolveAttribute(R.attr.navigationBarColor, typedValue, true)) {
            window.setNavigationBarColor(typedValue.data);
        }
        if (theme.resolveAttribute(R.attr.windowDrawsSystemBarBackgrounds, typedValue, true)) {
            if (typedValue.data != 0) {
                window.addFlags(Integer.MIN_VALUE);
            } else {
                window.clearFlags(Integer.MIN_VALUE);
            }
        }
        if (theme.resolveAttribute(R.attr.enforceNavigationBarContrast, typedValue, true)) {
            window.setNavigationBarContrastEnforced(typedValue.data != 0);
        }
        if (theme.resolveAttribute(R.attr.enforceStatusBarContrast, typedValue, true)) {
            window.setStatusBarContrastEnforced(typedValue.data != 0);
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        hd4.b(theme, viewGroup, typedValue);
        viewGroup.setOnHierarchyChangeListener(null);
        window.setDecorFitsSystemWindows(i04Var.Z);
        wn1 wn1Var = new wn1(mainActivity);
        ((j04) ((v62) wn1Var.f)).A = splashScreenView;
        of2Var.a(wn1Var);
    }

    @Override // defpackage.x8
    public final void J(final of2 of2Var) {
        ((MainActivity) this.b).getSplashScreen().setOnExitAnimationListener(new SplashScreen.OnExitAnimationListener() { // from class: g04
            @Override // android.window.SplashScreen.OnExitAnimationListener
            public final void onSplashScreenExit(SplashScreenView splashScreenView) {
                i04.M(this.a, of2Var, splashScreenView);
            }
        });
    }

    @Override // defpackage.x8
    public final void z() {
        int i;
        MainActivity mainActivity = (MainActivity) this.b;
        Resources.Theme theme = mainActivity.getTheme();
        theme.getClass();
        TypedValue typedValue = new TypedValue();
        if (theme.resolveAttribute(com.getsurfboard.R.attr.postSplashScreenTheme, typedValue, true) && (i = typedValue.resourceId) != 0) {
            mainActivity.setTheme(i);
        }
        ((ViewGroup) mainActivity.getWindow().getDecorView()).setOnHierarchyChangeListener(this.y0);
    }
}
