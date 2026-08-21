package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class m14 implements ge0, nf0 {
    public final ge0 b;
    public final cf0 f;

    public m14(ge0 ge0Var, cf0 cf0Var) {
        this.b = ge0Var;
        this.f = cf0Var;
    }

    @Override // defpackage.nf0
    public final nf0 c() {
        ge0 ge0Var = this.b;
        if (ge0Var instanceof nf0) {
            return (nf0) ge0Var;
        }
        return null;
    }

    @Override // defpackage.ge0
    public final void d(Object obj) {
        this.b.d(obj);
    }

    @Override // defpackage.ge0
    public final cf0 j() {
        return this.f;
    }
}
