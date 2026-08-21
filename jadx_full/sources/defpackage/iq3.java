package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class iq3 extends i0 implements nf0 {
    public final ge0 A;

    public iq3(ge0 ge0Var, cf0 cf0Var) {
        super(cf0Var, true);
        this.A = ge0Var;
    }

    @Override // defpackage.e42
    public final boolean R() {
        return true;
    }

    @Override // defpackage.nf0
    public final nf0 c() {
        ge0 ge0Var = this.A;
        if (ge0Var instanceof nf0) {
            return (nf0) ge0Var;
        }
        return null;
    }

    @Override // defpackage.e42
    public void o(Object obj) {
        mv0.a(p95.u(this.A), ke0.y(obj));
    }

    @Override // defpackage.e42
    public void p(Object obj) {
        this.A.d(ke0.y(obj));
    }

    public void m0() {
    }
}
