package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lv0 extends ov0 implements nf0, ge0 {
    public static final /* synthetic */ long y0 = re.a.objectFieldOffset(lv0.class.getDeclaredField("_reusableCancellableContinuation$volatile"));
    public final ef0 A;
    public final ie0 X;
    public Object Y;
    public final Object Z;
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    public lv0(ef0 ef0Var, ie0 ie0Var) {
        super(-1);
        this.A = ef0Var;
        this.X = ie0Var;
        this.Y = mv0.a;
        this.Z = nd4.b(ie0Var.j());
    }

    @Override // defpackage.nf0
    public final nf0 c() {
        return this.X;
    }

    @Override // defpackage.ge0
    public final void d(Object obj) {
        Throwable thA = uk3.a(obj);
        Object r80Var = thA == null ? obj : new r80(thA, false);
        ie0 ie0Var = this.X;
        cf0 cf0VarJ = ie0Var.j();
        ef0 ef0Var = this.A;
        if (mv0.c(ef0Var, cf0VarJ)) {
            this.Y = r80Var;
            this.z = 0;
            mv0.b(ef0Var, ie0Var.j(), this);
            return;
        }
        b61 b61VarA = qd4.a();
        if (b61VarA.z >= 4294967296L) {
            this.Y = r80Var;
            this.z = 0;
            b61VarA.z0(this);
            return;
        }
        b61VarA.F0(true);
        try {
            cf0 cf0VarJ2 = ie0Var.j();
            Object objC = nd4.c(cf0VarJ2, this.Z);
            try {
                ie0Var.d(obj);
                while (b61VarA.H0()) {
                }
            } finally {
                nd4.a(cf0VarJ2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // defpackage.ge0
    public final cf0 j() {
        return this.X.j();
    }

    @Override // defpackage.ov0
    public final Object k() {
        Object obj = this.Y;
        this.Y = mv0.a;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.A + ", " + ek0.H(this.X) + ']';
    }

    @Override // defpackage.ov0
    public final ge0 e() {
        return this;
    }
}
