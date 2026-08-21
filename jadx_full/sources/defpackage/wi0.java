package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wi0 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ lj0 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ wi0(lj0 lj0Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = lj0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((wi0) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            case 1:
                return ((wi0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((wi0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        lj0 lj0Var = this.Z;
        switch (i) {
            case 0:
                return new wi0(lj0Var, ge0Var, 0);
            case 1:
                return new wi0(lj0Var, ge0Var, 1);
            default:
                return new wi0(lj0Var, ge0Var, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r10 == r6) goto L22;
     */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) throws Throwable {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        lj0 lj0Var = this.Z;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    return lj0Var.e(this) == mf0Var ? mf0Var : xl4Var;
                }
                if (i2 == 1) {
                    n12.S(obj);
                    return xl4Var;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            case 1:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    iv1 iv1Var = lj0Var.z0;
                    this.Y = 1;
                    Object objJ0 = ((o80) iv1Var.z).j0(this);
                    if (objJ0 != mf0Var) {
                        objJ0 = xl4Var;
                    }
                    if (objJ0 != mf0Var) {
                    }
                    return mf0Var;
                }
                if (i3 != 1) {
                    if (i3 == 2) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                zf1 zf1VarB = p95.b(lj0Var.c().c, -1);
                xu xuVar = new xu(4, lj0Var);
                this.Y = 2;
                if (zf1VarB.a(xuVar, this) != mf0Var) {
                    return xl4Var;
                }
                return mf0Var;
            default:
                w7 w7Var = lj0Var.y0;
                int i4 = this.Y;
                try {
                    if (i4 == 0) {
                        n12.S(obj);
                        if (w7Var.s() instanceof qe1) {
                            return w7Var.s();
                        }
                        this.Y = 1;
                        if (lj0Var.f(this) != mf0Var) {
                        }
                        return mf0Var;
                    }
                    if (i4 != 1) {
                        if (i4 == 2) {
                            n12.S(obj);
                            return (j24) obj;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                    this.Y = 2;
                    obj = lj0Var.g(false, this);
                } catch (Throwable th) {
                    return new wd3(th, -1);
                }
                break;
        }
    }
}
