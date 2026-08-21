package com.getsurfboard.ui.activity;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.AppThemeConfigActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.materialswitch.MaterialSwitch;
import defpackage.ca;
import defpackage.cd4;
import defpackage.de0;
import defpackage.g;
import defpackage.ih0;
import defpackage.jd;
import defpackage.kd;
import defpackage.ke0;
import defpackage.kz0;
import defpackage.l72;
import defpackage.ld;
import defpackage.ma;
import defpackage.mp4;
import defpackage.n12;
import defpackage.nd;
import defpackage.t23;
import defpackage.v9;
import defpackage.vf2;
import defpackage.wp4;
import defpackage.y3;
import defpackage.zo2;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

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
    */
    public final void onCreate(final Bundle bundle) {
        Context de0Var;
        View viewInflate;
        int i;
        l72.H(this);
        v9.e(getWindow());
        super.onCreate(bundle);
        final int i2 = 0;
        View viewInflate2 = getLayoutInflater().inflate(R.layout.activity_app_theme_config, (ViewGroup) null, false);
        int i3 = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate2, R.id.appbar)) != null) {
            i3 = R.id.auto;
            MaterialCardView materialCardView = (MaterialCardView) vf2.l(viewInflate2, R.id.auto);
            if (materialCardView != null) {
                i3 = R.id.dark;
                MaterialCardView materialCardView2 = (MaterialCardView) vf2.l(viewInflate2, R.id.dark);
                if (materialCardView2 != null) {
                    i3 = R.id.dark_mode_scroll_view;
                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) vf2.l(viewInflate2, R.id.dark_mode_scroll_view);
                    if (horizontalScrollView != null) {
                        i3 = R.id.light;
                        MaterialCardView materialCardView3 = (MaterialCardView) vf2.l(viewInflate2, R.id.light);
                        if (materialCardView3 != null) {
                            i3 = R.id.pure_dark_switch;
                            MaterialSwitch materialSwitch = (MaterialSwitch) vf2.l(viewInflate2, R.id.pure_dark_switch);
                            if (materialSwitch != null) {
                                i3 = R.id.scroll_view;
                                NestedScrollView nestedScrollView = (NestedScrollView) vf2.l(viewInflate2, R.id.scroll_view);
                                if (nestedScrollView != null) {
                                    i3 = R.id.theme_palette_container;
                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) vf2.l(viewInflate2, R.id.theme_palette_container);
                                    if (linearLayoutCompat != null) {
                                        i3 = R.id.theme_palette_scroll_view;
                                        HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) vf2.l(viewInflate2, R.id.theme_palette_scroll_view);
                                        if (horizontalScrollView2 != null) {
                                            i3 = R.id.toolbar;
                                            Toolbar toolbar = (Toolbar) vf2.l(viewInflate2, R.id.toolbar);
                                            if (toolbar != null) {
                                                i3 = R.id.toolbar_divider;
                                                MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate2, R.id.toolbar_divider);
                                                if (materialDivider != null) {
                                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate2;
                                                    this.S0 = new y3(coordinatorLayout, materialCardView, materialCardView2, horizontalScrollView, materialCardView3, materialSwitch, nestedScrollView, linearLayoutCompat, horizontalScrollView2, toolbar, materialDivider);
                                                    setContentView(coordinatorLayout);
                                                    y3 y3Var = this.S0;
                                                    if (y3Var == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((Toolbar) y3Var.c).setNavigationOnClickListener(new View.OnClickListener(this) { // from class: id
                                                        public final /* synthetic */ AppThemeConfigActivity f;

                                                        {
                                                            this.f = this;
                                                        }

                                                        @Override // android.view.View.OnClickListener
                                                        public final void onClick(View view) {
                                                            int i4 = i2;
                                                            AppThemeConfigActivity appThemeConfigActivity = this.f;
                                                            switch (i4) {
                                                                case 0:
                                                                    int i5 = AppThemeConfigActivity.T0;
                                                                    appThemeConfigActivity.b().d();
                                                                    break;
                                                                case 1:
                                                                    AppThemeConfigActivity.x(appThemeConfigActivity);
                                                                    break;
                                                                case 2:
                                                                    AppThemeConfigActivity.y(appThemeConfigActivity);
                                                                    break;
                                                                default:
                                                                    AppThemeConfigActivity.z(appThemeConfigActivity);
                                                                    break;
                                                            }
                                                        }
                                                    });
                                                    y3 y3Var2 = this.S0;
                                                    if (y3Var2 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var2.a;
                                                    jd jdVar = new jd(0, this);
                                                    WeakHashMap weakHashMap = wp4.a;
                                                    mp4.c(coordinatorLayout2, jdVar);
                                                    y3 y3Var3 = this.S0;
                                                    if (y3Var3 == null) {
                                                        n12.T("binding");
                                                        throw null;
                                                    }
                                                    ((NestedScrollView) y3Var3.j).getViewTreeObserver().addOnScrollChangedListener(new nd(this, 0));
                                                    cd4 cd4VarG = t23.g();
                                                    Iterator it = ke0.j().entrySet().iterator();
                                                    while (true) {
                                                        boolean z = true;
                                                        boolean z2 = true;
                                                        if (!it.hasNext()) {
                                                            String string = t23.l().getString("dark_mode", "AUTO");
                                                            string.getClass();
                                                            int iOrdinal = ih0.valueOf(string).ordinal();
                                                            final int i4 = 2;
                                                            if (iOrdinal == 0) {
                                                                y3 y3Var4 = this.S0;
                                                                if (y3Var4 == null) {
                                                                    n12.T("binding");
                                                                    throw null;
                                                                }
                                                                ((MaterialCardView) y3Var4.d).setChecked(true);
                                                            } else if (iOrdinal == 1) {
                                                                y3 y3Var5 = this.S0;
                                                                if (y3Var5 == null) {
                                                                    n12.T("binding");
                                                                    throw null;
                                                                }
                                                                ((MaterialCardView) y3Var5.f).setChecked(true);
                                                            } else {
                                                                if (iOrdinal != 2) {
                                                                    g.d();
                                                                    return;
                                                                }
                                                                y3 y3Var6 = this.S0;
                                                                if (y3Var6 == null) {
                                                                    n12.T("binding");
                                                                    throw null;
                                                                }
                                                                ((MaterialCardView) y3Var6.e).setChecked(true);
                                                            }
                                                            y3 y3Var7 = this.S0;
                                                            if (y3Var7 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            MaterialCardView materialCardView4 = (MaterialCardView) y3Var7.d;
                                                            final boolean z3 = z2 ? 1 : 0;
                                                            materialCardView4.setOnClickListener(new View.OnClickListener(this) { // from class: id
                                                                public final /* synthetic */ AppThemeConfigActivity f;

                                                                {
                                                                    this.f = this;
                                                                }

                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    int i42 = z3;
                                                                    AppThemeConfigActivity appThemeConfigActivity = this.f;
                                                                    switch (i42) {
                                                                        case 0:
                                                                            int i5 = AppThemeConfigActivity.T0;
                                                                            appThemeConfigActivity.b().d();
                                                                            break;
                                                                        case 1:
                                                                            AppThemeConfigActivity.x(appThemeConfigActivity);
                                                                            break;
                                                                        case 2:
                                                                            AppThemeConfigActivity.y(appThemeConfigActivity);
                                                                            break;
                                                                        default:
                                                                            AppThemeConfigActivity.z(appThemeConfigActivity);
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            y3 y3Var8 = this.S0;
                                                            if (y3Var8 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((MaterialCardView) y3Var8.f).setOnClickListener(new View.OnClickListener(this) { // from class: id
                                                                public final /* synthetic */ AppThemeConfigActivity f;

                                                                {
                                                                    this.f = this;
                                                                }

                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    int i42 = i4;
                                                                    AppThemeConfigActivity appThemeConfigActivity = this.f;
                                                                    switch (i42) {
                                                                        case 0:
                                                                            int i5 = AppThemeConfigActivity.T0;
                                                                            appThemeConfigActivity.b().d();
                                                                            break;
                                                                        case 1:
                                                                            AppThemeConfigActivity.x(appThemeConfigActivity);
                                                                            break;
                                                                        case 2:
                                                                            AppThemeConfigActivity.y(appThemeConfigActivity);
                                                                            break;
                                                                        default:
                                                                            AppThemeConfigActivity.z(appThemeConfigActivity);
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            y3 y3Var9 = this.S0;
                                                            if (y3Var9 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            final int i5 = 3;
                                                            ((MaterialCardView) y3Var9.e).setOnClickListener(new View.OnClickListener(this) { // from class: id
                                                                public final /* synthetic */ AppThemeConfigActivity f;

                                                                {
                                                                    this.f = this;
                                                                }

                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    int i42 = i5;
                                                                    AppThemeConfigActivity appThemeConfigActivity = this.f;
                                                                    switch (i42) {
                                                                        case 0:
                                                                            int i52 = AppThemeConfigActivity.T0;
                                                                            appThemeConfigActivity.b().d();
                                                                            break;
                                                                        case 1:
                                                                            AppThemeConfigActivity.x(appThemeConfigActivity);
                                                                            break;
                                                                        case 2:
                                                                            AppThemeConfigActivity.y(appThemeConfigActivity);
                                                                            break;
                                                                        default:
                                                                            AppThemeConfigActivity.z(appThemeConfigActivity);
                                                                            break;
                                                                    }
                                                                }
                                                            });
                                                            y3 y3Var10 = this.S0;
                                                            if (y3Var10 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((MaterialSwitch) y3Var10.i).setChecked(t23.d("pure_dark", false));
                                                            y3 y3Var11 = this.S0;
                                                            if (y3Var11 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((MaterialSwitch) y3Var11.i).jumpDrawablesToCurrentState();
                                                            y3 y3Var12 = this.S0;
                                                            if (y3Var12 == null) {
                                                                n12.T("binding");
                                                                throw null;
                                                            }
                                                            ((MaterialSwitch) y3Var12.i).setOnCheckedChangeListener(new ld(this, 0));
                                                            if (bundle != null) {
                                                                y3 y3Var13 = this.S0;
                                                                if (y3Var13 == null) {
                                                                    n12.T("binding");
                                                                    throw null;
                                                                }
                                                                ((HorizontalScrollView) y3Var13.h).post(new Runnable(this) { // from class: md
                                                                    public final /* synthetic */ AppThemeConfigActivity f;

                                                                    {
                                                                        this.f = this;
                                                                    }

                                                                    @Override // java.lang.Runnable
                                                                    public final void run() {
                                                                        int i6 = i2;
                                                                        Bundle bundle2 = bundle;
                                                                        AppThemeConfigActivity appThemeConfigActivity = this.f;
                                                                        switch (i6) {
                                                                            case 0:
                                                                                y3 y3Var14 = appThemeConfigActivity.S0;
                                                                                if (y3Var14 != null) {
                                                                                    ((HorizontalScrollView) y3Var14.h).setScrollX(bundle2.getInt("theme_palette_scroll_x", 0));
                                                                                    return;
                                                                                } else {
                                                                                    n12.T("binding");
                                                                                    throw null;
                                                                                }
                                                                            default:
                                                                                y3 y3Var15 = appThemeConfigActivity.S0;
                                                                                if (y3Var15 != null) {
                                                                                    ((HorizontalScrollView) y3Var15.g).setScrollX(bundle2.getInt("dark_mode_scroll_x", 0));
                                                                                    return;
                                                                                } else {
                                                                                    n12.T("binding");
                                                                                    throw null;
                                                                                }
                                                                        }
                                                                    }
                                                                });
                                                                y3 y3Var14 = this.S0;
                                                                if (y3Var14 == null) {
                                                                    n12.T("binding");
                                                                    throw null;
                                                                }
                                                                HorizontalScrollView horizontalScrollView3 = (HorizontalScrollView) y3Var14.g;
                                                                final boolean z4 = z ? 1 : 0;
                                                                horizontalScrollView3.post(new Runnable(this) { // from class: md
                                                                    public final /* synthetic */ AppThemeConfigActivity f;

                                                                    {
                                                                        this.f = this;
                                                                    }

                                                                    @Override // java.lang.Runnable
                                                                    public final void run() {
                                                                        int i6 = z4;
                                                                        Bundle bundle2 = bundle;
                                                                        AppThemeConfigActivity appThemeConfigActivity = this.f;
                                                                        switch (i6) {
                                                                            case 0:
                                                                                y3 y3Var142 = appThemeConfigActivity.S0;
                                                                                if (y3Var142 != null) {
                                                                                    ((HorizontalScrollView) y3Var142.h).setScrollX(bundle2.getInt("theme_palette_scroll_x", 0));
                                                                                    return;
                                                                                } else {
                                                                                    n12.T("binding");
                                                                                    throw null;
                                                                                }
                                                                            default:
                                                                                y3 y3Var15 = appThemeConfigActivity.S0;
                                                                                if (y3Var15 != null) {
                                                                                    ((HorizontalScrollView) y3Var15.g).setScrollX(bundle2.getInt("dark_mode_scroll_x", 0));
                                                                                    return;
                                                                                } else {
                                                                                    n12.T("binding");
                                                                                    throw null;
                                                                                }
                                                                        }
                                                                    }
                                                                });
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        Map.Entry entry = (Map.Entry) it.next();
                                                        Object key = entry.getKey();
                                                        cd4 cd4Var = cd4.b;
                                                        if (key != cd4Var || !kz0.a()) {
                                                            de0Var = new de0(this, ((Number) entry.getValue()).intValue());
                                                        } else if (kz0.a()) {
                                                            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(kz0.a);
                                                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                                                            typedArrayObtainStyledAttributes.recycle();
                                                            if (resourceId != 0) {
                                                                de0Var = new ContextThemeWrapper(this, resourceId);
                                                            }
                                                        } else {
                                                            de0Var = this;
                                                        }
                                                        LayoutInflater layoutInflaterFrom = LayoutInflater.from(de0Var);
                                                        y3 y3Var15 = this.S0;
                                                        if (y3Var15 == null) {
                                                            n12.T("binding");
                                                            throw null;
                                                        }
                                                        viewInflate = layoutInflaterFrom.inflate(R.layout.item_theme_palette, (ViewGroup) y3Var15.b, false);
                                                        i = R.id.checked;
                                                        ImageView imageView = (ImageView) vf2.l(viewInflate, R.id.checked);
                                                        if (imageView == null) {
                                                            break;
                                                        }
                                                        i = R.id.colorize;
                                                        ImageView imageView2 = (ImageView) vf2.l(viewInflate, R.id.colorize);
                                                        if (imageView2 == null) {
                                                            break;
                                                        }
                                                        MaterialCardView materialCardView5 = (MaterialCardView) viewInflate;
                                                        imageView2.setVisibility((entry.getKey() == cd4Var && kz0.a()) ? 0 : 8);
                                                        imageView.setVisibility(entry.getKey() == cd4VarG ? 0 : 8);
                                                        materialCardView5.setChecked(entry.getKey() == cd4VarG);
                                                        materialCardView5.setOnClickListener(new kd(0, entry, this));
                                                        y3 y3Var16 = this.S0;
                                                        if (y3Var16 == null) {
                                                            n12.T("binding");
                                                            throw null;
                                                        }
                                                        ((LinearLayoutCompat) y3Var16.b).addView(materialCardView5);
                                                    }
                                                    zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i3)));
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
