package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iz2 extends fb2 {
    public final /* synthetic */ xq4 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iz2(xq4 xq4Var, Context context) {
        super(context);
        this.q = xq4Var;
    }

    @Override // defpackage.fb2
    public final float d(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // defpackage.fb2
    public final int e(int i) {
        return Math.min(100, super.e(i));
    }

    @Override // defpackage.fb2
    public final void h(View view, lg3 lg3Var) {
        xq4 xq4Var = this.q;
        int[] iArrA = xq4Var.a(xq4Var.a.getLayoutManager(), view);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int iCeil = (int) Math.ceil(((double) e(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
        if (iCeil > 0) {
            lg3Var.a = i;
            lg3Var.b = i2;
            lg3Var.c = iCeil;
            lg3Var.e = this.j;
            lg3Var.f = true;
        }
    }
}
