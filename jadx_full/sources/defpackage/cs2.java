package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cs2 extends es2 {
    public es2 a;

    @Override // defpackage.es2
    public final String getName() {
        return "ROOT";
    }

    @Override // defpackage.es2
    public final void setChild(es2 es2Var) {
        es2Var.parent = this;
        this.a = es2Var;
    }

    @Override // defpackage.es2
    public final String toString(int i) {
        return "\n" + es2.pad(this.a, 1);
    }
}
