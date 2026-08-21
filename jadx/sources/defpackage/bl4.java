package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class bl4 extends iq3 {
    public final ThreadLocal X;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public bl4(ge0 ge0Var, cf0 cf0Var) {
        cl4 cl4Var = cl4.b;
        super(ge0Var, cf0Var.Z(cl4Var) == null ? cf0Var.X(cl4Var) : cf0Var);
        this.X = new ThreadLocal();
        if (ge0Var.j().Z(pr1.f) instanceof ef0) {
            return;
        }
        Object objC = nd4.c(cf0Var, null);
        nd4.a(cf0Var, objC);
        p0(cf0Var, objC);
    }

    @Override // defpackage.iq3
    public final void m0() {
        o0();
    }

    public final boolean n0() {
        boolean z = this.threadLocalIsSet && this.X.get() == null;
        this.X.remove();
        return !z;
    }

    public final void o0() {
        if (this.threadLocalIsSet) {
            e03 e03Var = (e03) this.X.get();
            if (e03Var != null) {
                nd4.a((cf0) e03Var.b, e03Var.f);
            }
            this.X.remove();
        }
    }

    @Override // defpackage.iq3, defpackage.e42
    public final void p(Object obj) {
        o0();
        Object objY = ke0.y(obj);
        ge0 ge0Var = this.A;
        cf0 cf0VarJ = ge0Var.j();
        Object objC = nd4.c(cf0VarJ, null);
        bl4 bl4VarC0 = objC != nd4.a ? co4.c0(ge0Var, cf0VarJ, objC) : null;
        try {
            ge0Var.d(objY);
            if (bl4VarC0 == null || bl4VarC0.n0()) {
                nd4.a(cf0VarJ, objC);
            }
        } catch (Throwable th) {
            if (bl4VarC0 == null || bl4VarC0.n0()) {
                nd4.a(cf0VarJ, objC);
            }
            throw th;
        }
    }

    public final void p0(cf0 cf0Var, Object obj) {
        this.threadLocalIsSet = true;
        this.X.set(new e03(cf0Var, obj));
    }
}
