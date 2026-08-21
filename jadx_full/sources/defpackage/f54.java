package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class f54 implements ev3 {
    public final hv3 b;
    public final uf f;

    public f54(hv3 hv3Var, uf ufVar) {
        this.b = hv3Var;
        this.f = ufVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.zf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ag1 ag1Var, ge0 ge0Var) {
        e54 e54Var;
        if (ge0Var instanceof e54) {
            e54Var = (e54) ge0Var;
            int i = e54Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                e54Var.Y = i - Integer.MIN_VALUE;
            } else {
                e54Var = new e54(this, ge0Var);
            }
        }
        Object obj = e54Var.A;
        int i2 = e54Var.Y;
        if (i2 != 0) {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(obj);
            throw new t80();
        }
        n12.S(obj);
        d54 d54Var = new d54(ag1Var, this.f);
        e54Var.Y = 1;
        this.b.a(d54Var, e54Var);
        return mf0.b;
    }
}
