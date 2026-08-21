package com.getsurfboard.ui.activity;

import android.app.UiModeManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.HorizontalScrollView;
import com.google.android.material.card.MaterialCardView;
import defpackage.ca;
import defpackage.ih0;
import defpackage.ma;
import defpackage.n12;
import defpackage.t23;
import defpackage.y3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AppThemeConfigActivity extends ca {
    public static final /* synthetic */ int T0 = 0;
    public y3 S0;

    public static final void x(AppThemeConfigActivity appThemeConfigActivity) {
        t23.A(ih0.b);
        y3 y3Var = appThemeConfigActivity.S0;
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var.d).setChecked(true);
        y3 y3Var2 = appThemeConfigActivity.S0;
        if (y3Var2 == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var2.f).setChecked(false);
        y3 y3Var3 = appThemeConfigActivity.S0;
        if (y3Var3 == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var3.e).setChecked(false);
        ma.n(-1);
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = appThemeConfigActivity.getSystemService("uimode");
            UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
            if (uiModeManager != null) {
                uiModeManager.setApplicationNightMode(0);
            }
        }
    }

    public static final void y(AppThemeConfigActivity appThemeConfigActivity) {
        t23.A(ih0.f);
        y3 y3Var = appThemeConfigActivity.S0;
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var.d).setChecked(false);
        y3 y3Var2 = appThemeConfigActivity.S0;
        if (y3Var2 == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var2.f).setChecked(true);
        y3 y3Var3 = appThemeConfigActivity.S0;
        if (y3Var3 == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var3.e).setChecked(false);
        ma.n(1);
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = appThemeConfigActivity.getSystemService("uimode");
            UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
            if (uiModeManager != null) {
                uiModeManager.setApplicationNightMode(1);
            }
        }
    }

    public static final void z(AppThemeConfigActivity appThemeConfigActivity) {
        t23.A(ih0.z);
        y3 y3Var = appThemeConfigActivity.S0;
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var.d).setChecked(false);
        y3 y3Var2 = appThemeConfigActivity.S0;
        if (y3Var2 == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var2.f).setChecked(false);
        y3 y3Var3 = appThemeConfigActivity.S0;
        if (y3Var3 == null) {
            n12.T("binding");
            throw null;
        }
        ((MaterialCardView) y3Var3.e).setChecked(true);
        ma.n(2);
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = appThemeConfigActivity.getSystemService("uimode");
            UiModeManager uiModeManager = systemService instanceof UiModeManager ? (UiModeManager) systemService : null;
            if (uiModeManager != null) {
                uiModeManager.setApplicationNightMode(2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x012e  */
    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(final android.os.Bundle r21) {
        /*
            Method dump skipped, instruction units count: 724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.ui.activity.AppThemeConfigActivity.onCreate(android.os.Bundle):void");
    }

    @Override // defpackage.i90, defpackage.h90, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        y3 y3Var = this.S0;
        if (y3Var == null) {
            n12.T("binding");
            throw null;
        }
        bundle.putInt("theme_palette_scroll_x", ((HorizontalScrollView) y3Var.h).getScrollX());
        y3 y3Var2 = this.S0;
        if (y3Var2 != null) {
            bundle.putInt("dark_mode_scroll_x", ((HorizontalScrollView) y3Var2.g).getScrollX());
        } else {
            n12.T("binding");
            throw null;
        }
    }
}
