package com.getsurfboard.ui.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.a;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import defpackage.ca;
import defpackage.cd4;
import defpackage.cp1;
import defpackage.dr1;
import defpackage.ez4;
import defpackage.fy4;
import defpackage.ga1;
import defpackage.gb4;
import defpackage.ge0;
import defpackage.hj;
import defpackage.i04;
import defpackage.ji0;
import defpackage.ke0;
import defpackage.kz0;
import defpackage.le2;
import defpackage.mp4;
import defpackage.mt;
import defpackage.n12;
import defpackage.of2;
import defpackage.p95;
import defpackage.s63;
import defpackage.t23;
import defpackage.t74;
import defpackage.tf2;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vi2;
import defpackage.wp4;
import defpackage.x8;
import defpackage.zo2;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends ca {
    public static final /* synthetic */ int T0 = 0;
    public cp1 S0;

    @Override // androidx.fragment.app.p, defpackage.i90, defpackage.h90, android.app.Activity
    public final void onCreate(Bundle bundle) {
        if (t74.c) {
            super.onCreate(bundle);
            p95.C(R.string.missing_library, new Object[0]);
            finish();
            return;
        }
        int i = Build.VERSION.SDK_INT;
        x8 i04Var = i >= 31 ? new i04(this) : new x8(this);
        i04Var.z();
        cd4 cd4VarG = t23.g();
        Object obj = ke0.j().get(cd4VarG);
        obj.getClass();
        setTheme(((Number) obj).intValue());
        getWindow().requestFeature(13);
        v9.e(getWindow());
        setExitSharedElementCallback(new vi2());
        getWindow().setSharedElementsUseOverlay(false);
        super.onCreate(bundle);
        if (cd4VarG == cd4.b && kz0.a() && kz0.a()) {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(kz0.a);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            gb4.i(this, resourceId);
            ez4.a(this, dr1.a());
        }
        if (t23.d("pure_dark", false) && (getResources().getConfiguration().uiMode & 48) == 32) {
            getTheme().applyStyle(R.style.PureDarkOverlay, true);
        }
        if (i >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        }
        i04Var.J(new of2(this));
        getWindow().setBackgroundDrawable(new ColorDrawable(ContextUtilsKt.d(this, R.attr.colorSurface)));
        ge0 ge0Var = null;
        View viewInflate = getLayoutInflater().inflate(R.layout.activity_main, (ViewGroup) null, false);
        if (viewInflate == null) {
            zo2.n("rootView");
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        this.S0 = new cp1(3, frameLayout);
        setContentView(frameLayout);
        cp1 cp1Var = this.S0;
        if (cp1Var == null) {
            n12.T("binding");
            throw null;
        }
        FrameLayout frameLayout2 = (FrameLayout) cp1Var.f;
        of2 of2Var = new of2(this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(frameLayout2, of2Var);
        if (bundle == null) {
            a aVar = new a(u());
            aVar.g(R.id.container, new tf2(), "main", 1);
            aVar.l(false, new ga1(12, this));
            aVar.e();
        } else {
            x(getIntent());
        }
        ji0.B(uf2.t(this), null, null, new mt(this, ge0Var, 10), 3);
    }

    @Override // defpackage.i90, android.app.Activity
    public final void onNewIntent(Intent intent) {
        intent.getClass();
        super.onNewIntent(intent);
        String str = "onNewIntent() called with: intent = " + intent;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "MainActivity", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("MainActivity", str, null);
        }
        x(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(Intent intent) {
        tf2 tf2Var = (tf2) u().D("main");
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (intent != null && intent.getBooleanExtra("grant_permission", false)) {
            if (tf2Var != null) {
                ji0.B(uf2.t(tf2Var), null, null, new mt(tf2Var, objArr3 == true ? 1 : 0, 11), 3);
                return;
            }
            return;
        }
        if ((intent != null ? intent.getData() : null) == null) {
            if (!n12.c(intent != null ? intent.getStringExtra("tab") : null, "dashboard") || tf2Var == null) {
                return;
            }
            tf2Var.l(R.id.navigation_dashboard);
            return;
        }
        Uri data = intent.getData();
        data.getClass();
        String scheme = data.getScheme();
        String path = data.getPath();
        if ((n12.c(scheme, "surfboard") || n12.c(scheme, "surge") || n12.c(scheme, "surge3")) && n12.c(path, "/install-config")) {
            String string = data.toString();
            string.getClass();
            String strH = s63.h(string);
            if (!strH.equals(data.toString())) {
                if (tf2Var != null) {
                    ji0.B(uf2.t(tf2Var), null, null, new hj(tf2Var, strH, objArr == true ? 1 : 0, 21), 3);
                    return;
                }
                return;
            }
        }
        if (tf2Var != null) {
            ji0.B(uf2.t(tf2Var), null, null, new hj(tf2Var, data, objArr2 == true ? 1 : 0, 20), 3);
        }
    }
}
