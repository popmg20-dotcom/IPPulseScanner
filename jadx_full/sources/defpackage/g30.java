package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class g30 implements ag1 {
    public final /* synthetic */ ag1 A;
    public final /* synthetic */ bh3 b;
    public final /* synthetic */ lf0 f;
    public final /* synthetic */ h30 z;

    public g30(bh3 bh3Var, lf0 lf0Var, h30 h30Var, ag1 ag1Var) {
        this.b = bh3Var;
        this.f = lf0Var;
        this.z = h30Var;
        this.A = ag1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        f30 f30Var;
        if (ge0Var instanceof f30) {
            f30Var = (f30) ge0Var;
            int i = f30Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                f30Var.y0 = i - Integer.MIN_VALUE;
            } else {
                f30Var = new f30(this, ge0Var);
            }
        }
        Object obj2 = f30Var.Y;
        int i2 = f30Var.y0;
        if (i2 == 0) {
            n12.S(obj2);
            v32 v32Var = (v32) this.b.b;
            if (v32Var != null) {
                v32Var.g(new e40("Child of the scoped flow was cancelled"));
                f30Var.A = this;
                f30Var.X = obj;
                f30Var.y0 = 1;
                Object objI0 = v32Var.i0(f30Var);
                mf0 mf0Var = mf0.b;
                if (objI0 == mf0Var) {
                    return mf0Var;
                }
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            obj = f30Var.X;
            this = f30Var.A;
            n12.S(obj2);
        }
        this.b.b = ji0.B(this.f, null, of0.A, new e30(this.z, this.A, obj, null), 1);
        return xl4.a;
    }
}
