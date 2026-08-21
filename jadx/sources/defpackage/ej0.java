package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ej0 extends v74 implements am1 {
    public final /* synthetic */ int X;
    public int Y;
    public Object Z;
    public final /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ej0(Object obj, Object obj2, ge0 ge0Var, int i) {
        super(1, ge0Var);
        this.X = i;
        this.Z = obj;
        this.y0 = obj2;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        Object obj2 = this.y0;
        ge0 ge0Var = (ge0) obj;
        switch (i) {
            case 0:
                return new ej0((lj0) obj2, ge0Var).p(xl4Var);
            case 1:
                return new ej0((ag1) this.Z, (bh3) obj2, ge0Var, 1).p(xl4Var);
            default:
                return new ej0((rf) this.Z, (kz2) obj2, ge0Var, 2).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        Throwable th;
        j24 wd3Var;
        int i = this.X;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        Object obj2 = this.y0;
        switch (i) {
            case 0:
                lj0 lj0Var = (lj0) obj2;
                int i2 = this.Y;
                try {
                } catch (Throwable th2) {
                    nx3 nx3VarC = lj0Var.c();
                    this.Z = th2;
                    this.Y = 2;
                    Integer numA = nx3VarC.a();
                    if (numA == mf0Var) {
                        return mf0Var;
                    }
                    obj = numA;
                    th = th2;
                }
                if (i2 == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    obj = lj0Var.h(true, this);
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        th = (Throwable) this.Z;
                        n12.S(obj);
                        wd3Var = new wd3(th, ((Number) obj).intValue());
                        return new e03(wd3Var, Boolean.TRUE);
                    }
                    n12.S(obj);
                }
                wd3Var = (j24) obj;
                return new e03(wd3Var, Boolean.TRUE);
            case 1:
                bh3 bh3Var = (bh3) obj2;
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    ag1 ag1Var = (ag1) this.Z;
                    Object obj3 = bh3Var.b;
                    if (obj3 == at2.a) {
                        obj3 = null;
                    }
                    this.Y = 1;
                    if (ag1Var.h(obj3, this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                bh3Var.b = null;
                return xl4Var;
            default:
                kz2 kz2Var = (kz2) obj2;
                rf rfVar = (rf) this.Z;
                int i4 = this.Y;
                if (i4 != 0) {
                    if (i4 == 1) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                v62 v62Var = kz2Var.b;
                wk4 wk4Var = rfVar.c;
                rfVar.c = v62Var;
                zf1 zf1Var = kz2Var.a;
                tf tfVar = new tf(5, rfVar, kz2Var);
                this.Y = 1;
                return zf1Var.a(tfVar, this) == mf0Var ? mf0Var : xl4Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej0(lj0 lj0Var, ge0 ge0Var) {
        super(1, ge0Var);
        this.X = 0;
        this.y0 = lj0Var;
    }
}
