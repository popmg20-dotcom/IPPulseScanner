package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class mo3 extends ie0 implements ag1 {
    public final ag1 A;
    public final cf0 X;
    public final int Y;
    public cf0 Z;
    public ge0 y0;

    public mo3(ag1 ag1Var, cf0 cf0Var) {
        super(q80.z, c41.b);
        this.A = ag1Var;
        this.X = cf0Var;
        this.Y = ((Number) cf0Var.c0(0, new dt(9))).intValue();
    }

    @Override // defpackage.kk, defpackage.nf0
    public final nf0 c() {
        ge0 ge0Var = this.y0;
        if (ge0Var instanceof nf0) {
            return (nf0) ge0Var;
        }
        return null;
    }

    @Override // defpackage.ag1
    public final Object h(Object obj, ge0 ge0Var) {
        try {
            Object objR = r(ge0Var, obj);
            return objR == mf0.b ? objR : xl4.a;
        } catch (Throwable th) {
            this.Z = new mx0(ge0Var.j(), th);
            throw th;
        }
    }

    @Override // defpackage.ie0, defpackage.ge0
    public final cf0 j() {
        cf0 cf0Var = this.Z;
        return cf0Var == null ? c41.b : cf0Var;
    }

    @Override // defpackage.kk
    public final StackTraceElement o() {
        return null;
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        Throwable thA = uk3.a(obj);
        if (thA != null) {
            this.Z = new mx0(j(), thA);
        }
        ge0 ge0Var = this.y0;
        if (ge0Var != null) {
            ge0Var.d(obj);
        }
        return mf0.b;
    }

    public final Object r(ge0 ge0Var, Object obj) {
        cf0 cf0VarJ = ge0Var.j();
        je.A(cf0VarJ);
        cf0 cf0Var = this.Z;
        if (cf0Var != cf0VarJ) {
            if (cf0Var instanceof mx0) {
                throw new IllegalStateException(q44.b0("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((mx0) cf0Var).f + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
            }
            if (((Number) cf0VarJ.c0(0, new cd(6, this))).intValue() != this.Y) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.X + ",\n\t\tbut emission happened in " + cf0VarJ + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.Z = cf0VarJ;
        }
        this.y0 = ge0Var;
        em1 em1Var = oo3.a;
        ag1 ag1Var = this.A;
        ag1Var.getClass();
        Object objE = em1Var.e(ag1Var, obj, this);
        if (!n12.c(objE, mf0.b)) {
            this.y0 = null;
        }
        return objE;
    }
}
