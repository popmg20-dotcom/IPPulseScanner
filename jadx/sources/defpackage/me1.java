package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class me1 extends pm {
    public final /* synthetic */ int I0;
    public final pm J0;
    public final Serializable K0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ me1(pm pmVar, Serializable serializable, int i) {
        super(pmVar);
        this.I0 = i;
        this.J0 = pmVar;
        this.K0 = serializable;
    }

    @Override // defpackage.pm
    public final void f(b72 b72Var) {
        switch (this.I0) {
            case 0:
                this.J0.f(b72Var);
                break;
            default:
                this.J0.f(b72Var);
                break;
        }
    }

    @Override // defpackage.pm
    public final void g(b72 b72Var) {
        switch (this.I0) {
            case 0:
                this.J0.g(b72Var);
                break;
            default:
                this.J0.g(b72Var);
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Serializable, java.lang.Class[]] */
    @Override // defpackage.pm
    public final pm i(po2 po2Var) {
        int i = this.I0;
        Object obj = this.K0;
        pm pmVar = this.J0;
        switch (i) {
            case 0:
                return new me1(pmVar.i(po2Var), (Class[]) obj, 0);
            default:
                return new me1(pmVar.i(po2Var), (Class) obj, 1);
        }
    }

    @Override // defpackage.pm
    public final void j(Object obj, i52 i52Var, gt3 gt3Var) {
        int i = this.I0;
        pm pmVar = this.J0;
        switch (i) {
            case 0:
                gt3Var.getClass();
                pmVar.j(obj, i52Var, gt3Var);
                break;
            default:
                gt3Var.getClass();
                pmVar.j(obj, i52Var, gt3Var);
                break;
        }
    }

    @Override // defpackage.pm
    public final void k(Object obj, i52 i52Var, gt3 gt3Var) {
        int i = this.I0;
        pm pmVar = this.J0;
        switch (i) {
            case 0:
                gt3Var.getClass();
                pmVar.k(obj, i52Var, gt3Var);
                break;
            default:
                gt3Var.getClass();
                pmVar.k(obj, i52Var, gt3Var);
                break;
        }
    }
}
