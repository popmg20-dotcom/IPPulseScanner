package io.sentry.util;

import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import defpackage.bv4;
import defpackage.cm2;
import defpackage.mu2;
import defpackage.n12;
import defpackage.t02;
import defpackage.yu4;
import io.sentry.c4;
import io.sentry.d1;
import io.sentry.x3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements c4, mu2 {
    public final /* synthetic */ Object b;

    public /* synthetic */ q(Object obj) {
        this.b = obj;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) this.b;
        int i = ProfileEditorActivity.Y0;
        view.getClass();
        yu4 yu4Var = bv4Var.a;
        t02 t02VarH = yu4Var.h(519);
        t02VarH.getClass();
        t02 t02VarH2 = yu4Var.h(8);
        t02VarH2.getClass();
        int i2 = t02VarH2.d;
        cm2 cm2Var = profileEditorActivity.S0;
        if (cm2Var == null) {
            n12.T("binding");
            throw null;
        }
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) cm2Var.Y;
        horizontalScrollView.setPadding(horizontalScrollView.getPaddingLeft(), horizontalScrollView.getPaddingTop(), horizontalScrollView.getPaddingRight(), t02VarH.d);
        cm2 cm2Var2 = profileEditorActivity.S0;
        if (cm2Var2 == null) {
            n12.T("binding");
            throw null;
        }
        Object tag = ((ConstraintLayout) cm2Var2.f).getTag(R.id.tag_ime_animating);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (!(bool != null ? bool.booleanValue() : false)) {
            cm2 cm2Var3 = profileEditorActivity.S0;
            if (cm2Var3 == null) {
                n12.T("binding");
                throw null;
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) cm2Var3.f;
            constraintLayout.getClass();
            constraintLayout.setPadding(constraintLayout.getPaddingLeft(), constraintLayout.getPaddingTop(), constraintLayout.getPaddingRight(), i2);
            if (i2 > 0) {
                cm2 cm2Var4 = profileEditorActivity.S0;
                if (cm2Var4 == null) {
                    n12.T("binding");
                    throw null;
                }
                HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) cm2Var4.Y;
                horizontalScrollView2.setPadding(horizontalScrollView2.getPaddingLeft(), horizontalScrollView2.getPaddingTop(), horizontalScrollView2.getPaddingRight(), 0);
                return bv4Var;
            }
        }
        return bv4Var;
    }

    @Override // io.sentry.c4
    public void a(x3 x3Var) {
        ((d1) this.b).L(new x3());
    }
}
