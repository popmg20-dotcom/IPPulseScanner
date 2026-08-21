package defpackage;

import java.lang.reflect.Member;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r9 extends pm {
    public final l9 I0;
    public final c9 J0;
    public b72 K0;
    public vg2 L0;

    public r9(pm pmVar, l9 l9Var, c9 c9Var, b72 b72Var) {
        super(pmVar);
        this.J0 = c9Var;
        this.I0 = l9Var;
        this.K0 = b72Var;
        if (b72Var instanceof vg2) {
            this.L0 = (vg2) b72Var;
        }
    }

    @Override // defpackage.pm
    public final void h(bt3 bt3Var) {
        boolean zF = bt3Var.f(ah2.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
        Member memberQ = this.J0.Q();
        if (memberQ != null) {
            n50.d(memberQ, zF);
        }
    }

    @Override // defpackage.pm
    public final void k(Object obj, i52 i52Var, gt3 gt3Var) throws o12 {
        c9 c9Var = this.J0;
        Object objR = c9Var.R(obj);
        if (objR == null) {
            return;
        }
        if (objR instanceof Map) {
            vg2 vg2Var = this.L0;
            if (vg2Var != null) {
                vg2Var.s((Map) objR, i52Var, gt3Var);
                return;
            } else {
                this.K0.e(objR, i52Var, gt3Var);
                return;
            }
        }
        gt3Var.A("Value returned by 'any-getter' " + c9Var.q() + "() not java.util.Map but " + objR.getClass().getName());
        throw null;
    }
}
