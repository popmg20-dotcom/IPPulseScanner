package defpackage;

import android.content.Context;
import android.view.View;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l3 extends al2 {
    public final /* synthetic */ int l = 0;
    public final /* synthetic */ q3 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(q3 q3Var, Context context, b54 b54Var, View view) {
        super(context, b54Var, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.m = q3Var;
        if ((b54Var.B.x & 32) != 32) {
            View view2 = q3Var.A0;
            this.e = view2 == null ? (View) q3Var.y0 : view2;
        }
        w7 w7Var = q3Var.O0;
        this.h = w7Var;
        yk2 yk2Var = this.i;
        if (yk2Var != null) {
            yk2Var.i(w7Var);
        }
    }

    @Override // defpackage.al2
    public final void c() {
        int i = this.l;
        q3 q3Var = this.m;
        switch (i) {
            case 0:
                q3Var.L0 = null;
                q3Var.P0 = 0;
                super.c();
                break;
            default:
                nk2 nk2Var = q3Var.z;
                if (nk2Var != null) {
                    nk2Var.c(true);
                }
                q3Var.K0 = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(q3 q3Var, Context context, nk2 nk2Var, View view) {
        super(context, nk2Var, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.m = q3Var;
        this.f = 8388613;
        w7 w7Var = q3Var.O0;
        this.h = w7Var;
        yk2 yk2Var = this.i;
        if (yk2Var != null) {
            yk2Var.i(w7Var);
        }
    }
}
