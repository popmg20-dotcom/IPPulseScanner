package defpackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vf0 {
    public final fe0 a;
    public final uf0 b;
    public final uf0 c;
    public final xi3 d;
    public final gg4 e;

    public vf0(vf0 vf0Var, List list) {
        fe0 fe0Var = vf0Var.a;
        this.a = new fe0(list, fe0Var.z0, fe0Var.y0, new HashMap(fe0Var.Z));
        this.b = new uf0(vf0Var.b, list);
        this.c = new uf0(vf0Var.c, list);
        xi3 xi3Var = vf0Var.d;
        this.d = new xi3(list, xi3Var.z0, xi3Var.y0, xi3Var.A0, xi3Var.B0, new HashMap(xi3Var.Z), xi3Var.C0);
        gg4 gg4Var = vf0Var.e;
        this.e = new gg4(gg4Var.Z, gg4Var.y0, gg4Var.z0, gg4Var.A0, gg4Var.B0, gg4Var.C0, gg4Var.D0, gg4Var.E0, gg4Var.F0, gg4Var.G0, gg4Var.H0, gg4Var.I0, gg4Var.J0, gg4Var.K0, gg4Var.L0, gg4Var.M0, gg4Var.N0, gg4Var.O0);
    }

    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(" [ ");
            xt2 xt2Var = new xt2();
            ma0 ma0Var = xt2Var.f;
            s52 s52Var = s52.f;
            t52 t52Var = t52.X;
            ma0Var.f = new t52(s52Var, s52Var, null, null);
            s52 s52Var2 = s52.z;
            ma0Var.f = new t52(s52Var2, s52Var2, null, null);
            xt2Var.b(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS);
            sb.append(xt2Var.d(this));
            sb.append(" ]");
            return sb.toString();
        } catch (IOException e) {
            vp1.p(e);
            return null;
        }
    }

    @fj2
    public vf0(@n62("continent") @gj2(name = "continent") fe0 fe0Var, @n62("country") @gj2(name = "country") uf0 uf0Var, @n62("maxmind") @gj2(name = "maxmind") ej2 ej2Var, @n62("registered_country") @gj2(name = "registered_country") uf0 uf0Var2, @n62("represented_country") @gj2(name = "represented_country") xi3 xi3Var, @n62("traits") @v22("traits") @gj2(name = "traits") gg4 gg4Var) {
        this.a = fe0Var != null ? fe0Var : new fe0((List) null, (String) null, (Integer) null, (Map) null);
        this.b = uf0Var != null ? uf0Var : new uf0();
        this.c = uf0Var2 != null ? uf0Var2 : new uf0();
        if (ej2Var == null) {
            new ej2(null);
        }
        this.d = xi3Var != null ? xi3Var : new xi3((List) null, (Integer) null, (Integer) null, false, (String) null, (Map) null, (String) null);
        this.e = gg4Var != null ? gg4Var : new gg4(null, null, 0, null, false, false, false, false, false, false, false, false, false, null, null, null, null, null);
    }
}
