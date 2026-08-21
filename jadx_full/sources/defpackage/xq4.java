package defpackage;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import io.netty.channel.internal.ChannelUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xq4 extends dg3 {
    public yq4 a;
    public final ry3 b = new ry3(this);
    public tw2 c;
    public tw2 d;
    public final /* synthetic */ ViewPager2 e;

    public xq4(ViewPager2 viewPager2) {
        this.e = viewPager2;
    }

    public static int b(View view, h31 h31Var) {
        return ((h31Var.e(view) / 2) + h31Var.g(view)) - ((h31Var.n() / 2) + h31Var.m());
    }

    public static View c(ag3 ag3Var, h31 h31Var) {
        int iV = ag3Var.v();
        View view = null;
        if (iV == 0) {
            return null;
        }
        int iN = (h31Var.n() / 2) + h31Var.m();
        int i = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = ag3Var.u(i2);
            int iAbs = Math.abs(((h31Var.e(viewU) / 2) + h31Var.g(viewU)) - iN);
            if (iAbs < i) {
                view = viewU;
                i = iAbs;
            }
        }
        return view;
    }

    public final int[] a(ag3 ag3Var, View view) {
        int[] iArr = new int[2];
        if (ag3Var.d()) {
            iArr[0] = b(view, e(ag3Var));
        } else {
            iArr[0] = 0;
        }
        if (ag3Var.e()) {
            iArr[1] = b(view, f(ag3Var));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public final View d(ag3 ag3Var) {
        Object obj = this.e.H0.f;
        if (ag3Var.e()) {
            return c(ag3Var, f(ag3Var));
        }
        if (ag3Var.d()) {
            return c(ag3Var, e(ag3Var));
        }
        return null;
    }

    public final h31 e(ag3 ag3Var) {
        tw2 tw2Var = this.d;
        if (tw2Var != null && ((ag3) tw2Var.b) == ag3Var) {
            return tw2Var;
        }
        tw2 tw2Var2 = new tw2(ag3Var, 0);
        this.d = tw2Var2;
        return tw2Var2;
    }

    public final h31 f(ag3 ag3Var) {
        tw2 tw2Var = this.c;
        if (tw2Var != null && ((ag3) tw2Var.b) == ag3Var) {
            return tw2Var;
        }
        tw2 tw2Var2 = new tw2(ag3Var, 1);
        this.c = tw2Var2;
        return tw2Var2;
    }

    public final void g() {
        ag3 layoutManager;
        View viewD;
        yq4 yq4Var = this.a;
        if (yq4Var == null || (layoutManager = yq4Var.getLayoutManager()) == null || (viewD = d(layoutManager)) == null) {
            return;
        }
        int[] iArrA = a(layoutManager, viewD);
        int i = iArrA[0];
        if (i == 0 && iArrA[1] == 0) {
            return;
        }
        this.a.n0(i, iArrA[1], false);
    }
}
