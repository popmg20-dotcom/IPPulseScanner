package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class d54 implements ag1 {
    public final ag1 b;
    public final uf f;

    public d54(ag1 ag1Var, uf ufVar) {
        this.b = ag1Var;
        this.f = ufVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ie0 ie0Var) throws Throwable {
        c54 c54Var;
        Throwable th;
        mo3 mo3Var;
        d54 d54Var;
        ag1 ag1Var;
        if (ie0Var instanceof c54) {
            c54Var = (c54) ie0Var;
            int i = c54Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                c54Var.y0 = i - Integer.MIN_VALUE;
            } else {
                c54Var = new c54(this, ie0Var);
            }
        }
        Object obj = c54Var.Y;
        int i2 = c54Var.y0;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    n12.S(obj);
                    return xl4Var;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            mo3Var = c54Var.X;
            d54Var = c54Var.A;
            try {
                n12.S(obj);
                mo3Var.q();
                ag1Var = d54Var.b;
                if (ag1Var instanceof d54) {
                    c54Var.A = null;
                    c54Var.X = null;
                    c54Var.y0 = 2;
                    if (((d54) ag1Var).a(c54Var) == mf0Var) {
                    }
                }
                return xl4Var;
            } catch (Throwable th2) {
                th = th2;
                mo3Var.q();
                throw th;
            }
        }
        n12.S(obj);
        cf0 cf0Var = c54Var.f;
        cf0Var.getClass();
        mo3 mo3Var2 = new mo3(this.b, cf0Var);
        try {
            uf ufVar = this.f;
            c54Var.A = this;
            c54Var.X = mo3Var2;
            c54Var.y0 = 1;
            if (ufVar.k(mo3Var2, c54Var) != mf0Var) {
                d54Var = this;
                mo3Var = mo3Var2;
                mo3Var.q();
                ag1Var = d54Var.b;
                if (ag1Var instanceof d54) {
                }
                return xl4Var;
            }
        } catch (Throwable th3) {
            th = th3;
            mo3Var = mo3Var2;
            mo3Var.q();
            throw th;
        }
        return mf0Var;
    }

    @Override // defpackage.ag1
    public final Object h(Object obj, ge0 ge0Var) {
        return this.b.h(obj, ge0Var);
    }
}
