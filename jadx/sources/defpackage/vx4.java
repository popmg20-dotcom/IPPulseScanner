package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vx4 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ yx4 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vx4(yx4 yx4Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = yx4Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((vx4) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        yx4 yx4Var = this.Z;
        switch (i) {
            case 0:
                return new vx4(yx4Var, ge0Var, 0);
            default:
                return new vx4(yx4Var, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        Object rx4Var;
        int i = this.X;
        mf0 mf0Var = mf0.b;
        yx4 yx4Var = this.Z;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    Object objC = yx4Var.c(this);
                    return objC == mf0Var ? mf0Var : objC;
                }
                if (i2 == 1) {
                    n12.S(obj);
                    return obj;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            default:
                int i3 = this.Y;
                try {
                    if (i3 == 0) {
                        n12.S(obj);
                        x32 x32Var = yx4Var.l;
                        vx4 vx4Var = new vx4(yx4Var, ge0Var, 0);
                        this.Y = 1;
                        obj = ji0.b0(x32Var, vx4Var, this);
                        if (obj == mf0Var) {
                            return mf0Var;
                        }
                    } else {
                        if (i3 != 1) {
                            xe.q("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        n12.S(obj);
                    }
                    rx4Var = (ux4) obj;
                    break;
                } catch (nx4 e) {
                    rx4Var = new tx4(e.b);
                } catch (CancellationException unused) {
                    rx4Var = new rx4();
                } catch (Throwable th) {
                    ue2.g().f(zx4.a, "Unexpected error in WorkerWrapper", th);
                    rx4Var = new rx4();
                }
                Object objP = yx4Var.g.p(new fn(18, new ft4(2, rx4Var, yx4Var)));
                objP.getClass();
                return objP;
        }
    }
}
