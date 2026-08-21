package defpackage;

import io.netty.util.internal.StringUtil;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bt3 extends zg2 {
    public static final dm0 D0;
    public static final int E0;
    public final g43 B0;
    public final int C0;

    static {
        int i = g43.N;
        dm0 dm0Var = new dm0();
        dm0Var.b = cm0.b;
        dm0Var.f = ol0.A;
        dm0Var.z = new ft3(" ");
        dm0Var.X = dw2.r(':', 4);
        dm0Var.Y = dw2.r(StringUtil.COMMA, 1);
        dm0Var.Z = " ";
        dm0Var.y0 = dw2.r(StringUtil.COMMA, 1);
        dm0Var.z0 = " ";
        D0 = dm0Var;
        E0 = yg2.b(dt3.class);
    }

    public bt3(jl jlVar, m34 m34Var, dx3 dx3Var, o82 o82Var, ma0 ma0Var, tj0 tj0Var) {
        super(jlVar, m34Var, dx3Var, o82Var, ma0Var, tj0Var);
        this.C0 = E0;
        this.B0 = D0;
    }

    @Override // defpackage.yg2
    public final boolean e(rj0 rj0Var) {
        tj0 tj0Var = this.y0;
        tj0Var.getClass();
        int iB = rj0Var.b();
        if (iB == 0) {
            return rj0Var.a(tj0Var.b);
        }
        if (iB == 1) {
            return rj0Var.a(tj0Var.f);
        }
        int i = zo4.a;
        zo2.w("Internal error: this code path should never get executed");
        return false;
    }

    public final ul g(nj4 nj4Var) {
        ((wl) this.f.f).getClass();
        ul ulVarS = wl.S(this, nj4Var);
        Class cls = nj4Var.L0;
        if (ulVarS == null) {
            ulVarS = (!nj4Var.h0() || (nj4Var instanceof ne) || !n50.p(cls) || !(Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) || cls.toString().indexOf(36) > 0) ? null : ul.d(this, nj4Var, x8.F(this, nj4Var, this));
            if (ulVarS == null) {
                w8 w8VarF = x8.F(this, nj4Var, this);
                by2 by2Var = new by2(this, nj4Var, w8VarF, n50.s(cls) ? new tk0(this, w8VarF) : new b10(this, "set"));
                ul ulVar = new ul(by2Var.c);
                ulVar.c = by2Var;
                bt3 bt3Var = by2Var.a;
                ulVar.d = bt3Var;
                ulVar.e = bt3Var.d();
                w8 w8Var = by2Var.d;
                ulVar.f = w8Var;
                cu2 cu2Var = by2Var.f;
                vt2 vt2VarP = cu2Var.p(w8Var);
                if (vt2VarP != null) {
                    vt2VarP = cu2Var.q(w8Var, vt2VarP);
                }
                ulVar.i = vt2VarP;
                return ulVar;
            }
        }
        return ulVarS;
    }

    public final boolean h(dt3 dt3Var) {
        return (this.C0 & dt3Var.f) != 0;
    }

    public bt3(bt3 bt3Var, long j, int i) {
        super(bt3Var, j);
        this.C0 = i;
        this.B0 = bt3Var.B0;
    }
}
