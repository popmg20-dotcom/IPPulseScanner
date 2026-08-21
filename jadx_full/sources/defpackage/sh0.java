package defpackage;

import android.appwidget.AppWidgetManager;
import androidx.appcompat.widget.Toolbar;
import com.getsurfboard.R;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sh0 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ xh0 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sh0(xh0 xh0Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = xh0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                ((sh0) n(ge0Var, lf0Var)).p(xl4Var);
                return mf0.b;
            default:
                return ((sh0) n(ge0Var, lf0Var)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        xh0 xh0Var = this.Z;
        switch (i) {
            case 0:
                return new sh0(xh0Var, ge0Var, 0);
            default:
                return new sh0(xh0Var, ge0Var, 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        int i = this.X;
        xh0 xh0Var = this.Z;
        mf0 mf0Var = mf0.b;
        int i2 = 1;
        switch (i) {
            case 0:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(xh0Var.getContext());
                    gm0 gm0Var = qv0.a;
                    rh0 rh0Var = new rh0(appWidgetManager, null);
                    this.Y = 1;
                    obj = ji0.b0(gm0Var, rh0Var, this);
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                        throw new t80();
                    }
                    n12.S(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    j80 j80Var = xh0Var.b;
                    j80Var.getClass();
                    ((Toolbar) j80Var.g).getMenu().findItem(R.id.add_widgets).setVisible(false);
                }
                hv3 hv3Var = pe4.a;
                xu xuVar = new xu(3, xh0Var);
                this.Y = 2;
                hv3Var.a(xuVar, this);
                return mf0Var;
            default:
                int i4 = this.Y;
                if (i4 != 0) {
                    if (i4 == 1) {
                        n12.S(obj);
                        return xl4.a;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                r92 lifecycle = xh0Var.getLifecycle();
                gm0 gm0Var2 = qv0.a;
                tq1 tq1Var = qf2.a.X;
                cf0 cf0Var = this.f;
                cf0Var.getClass();
                boolean zQ0 = tq1Var.q0(cf0Var);
                q92 q92Var = q92.X;
                if (zQ0) {
                    cj cjVar = new cj(i2, xh0Var);
                    this.Y = 1;
                    if (ji0.V(lifecycle, q92Var, zQ0, tq1Var, cjVar, this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (lifecycle.b() == q92.b) {
                        vp1.m();
                        return null;
                    }
                    if (lifecycle.b().compareTo(q92Var) >= 0) {
                        wh2 wh2Var = new wh2(xh0Var.requireContext());
                        wh2Var.x(R.string.abnormal_traffic);
                        ((p6) wh2Var.z).g = vo.p(63, xh0Var.getString(R.string.tls_handshake_time_error));
                        wh2Var.w(R.string.check_system_time, new uh0(0, xh0Var));
                        wh2Var.u(R.string.i_got_it, null);
                        u6 u6VarH = wh2Var.h();
                        u6VarH.setOnShowListener(new vh0(xh0Var));
                        u6VarH.show();
                    }
                }
                return xl4.a;
        }
    }
}
