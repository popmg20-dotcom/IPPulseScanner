package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xi0 extends v74 implements em1 {
    public final /* synthetic */ int X = 1;
    public int Y;
    public /* synthetic */ Object Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xi0(lj0 lj0Var, ge0 ge0Var) {
        super(3, ge0Var);
        this.Z = lj0Var;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return new xi0((lj0) this.Z, (ge0) obj3).p(xl4Var);
            default:
                ((Boolean) obj2).getClass();
                xi0 xi0Var = new xi0(3, (ge0) obj3);
                xi0Var.Z = (xd1) obj;
                return xi0Var.p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) throws IOException {
        int i = this.X;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    lj0 lj0Var = (lj0) this.Z;
                    this.Y = 1;
                    if (lj0Var.a(this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i2 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
            default:
                int i3 = this.Y;
                if (i3 != 0) {
                    if (i3 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                xd1 xd1Var = (xd1) this.Z;
                this.Y = 1;
                xd1Var.getClass();
                Object objA = xd1.a(xd1Var, this);
                return objA == mf0Var ? mf0Var : objA;
        }
    }

    public /* synthetic */ xi0(int i, ge0 ge0Var) {
        super(i, ge0Var);
    }
}
