package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jt extends fg3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ jt(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.fg3
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int i3 = this.a;
        Object obj = this.b;
        switch (i3) {
            case 0:
                BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) obj;
                if (i2 < 0) {
                    y3 y3Var = bypassConfigActivity.S0;
                    if (y3Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    if (!((ExtendedFloatingActionButton) y3Var.k).isShown()) {
                        y3 y3Var2 = bypassConfigActivity.S0;
                        if (y3Var2 != null) {
                            ((ExtendedFloatingActionButton) y3Var2.k).v(0);
                            return;
                        } else {
                            n12.T("binding");
                            throw null;
                        }
                    }
                }
                if (i2 > 0) {
                    y3 y3Var3 = bypassConfigActivity.S0;
                    if (y3Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    if (((ExtendedFloatingActionButton) y3Var3.k).isShown()) {
                        y3 y3Var4 = bypassConfigActivity.S0;
                        if (y3Var4 != null) {
                            ((ExtendedFloatingActionButton) y3Var4.k).v(1);
                            return;
                        } else {
                            n12.T("binding");
                            throw null;
                        }
                    }
                    return;
                }
                return;
            case 1:
                cc1 cc1Var = (cc1) obj;
                int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int i4 = cc1Var.a;
                int iComputeVerticalScrollRange = cc1Var.s.computeVerticalScrollRange();
                int i5 = cc1Var.r;
                cc1Var.t = iComputeVerticalScrollRange - i5 > 0 && i5 >= i4;
                int iComputeHorizontalScrollRange = cc1Var.s.computeHorizontalScrollRange();
                int i6 = cc1Var.q;
                boolean z = iComputeHorizontalScrollRange - i6 > 0 && i6 >= i4;
                cc1Var.u = z;
                boolean z2 = cc1Var.t;
                if (!z2 && !z) {
                    if (cc1Var.v != 0) {
                        cc1Var.l(0);
                        return;
                    }
                    return;
                }
                if (z2) {
                    float f = i5;
                    cc1Var.l = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
                    cc1Var.k = Math.min(i5, (i5 * i5) / iComputeVerticalScrollRange);
                }
                if (cc1Var.u) {
                    float f2 = iComputeHorizontalScrollOffset;
                    float f3 = i6;
                    cc1Var.o = (int) ((((f3 / 2.0f) + f2) * f3) / iComputeHorizontalScrollRange);
                    cc1Var.n = Math.min(i6, (i6 * i6) / iComputeHorizontalScrollRange);
                }
                int i7 = cc1Var.v;
                if (i7 == 0 || i7 == 1) {
                    cc1Var.l(1);
                    return;
                }
                return;
            default:
                ((zb1) obj).run();
                return;
        }
    }
}
