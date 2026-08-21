package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class y70 extends v74 implements Function2 {
    public int X;
    public final /* synthetic */ zf1[] Y;
    public final /* synthetic */ int Z;
    public final /* synthetic */ AtomicInteger y0;
    public final /* synthetic */ xp z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y70(zf1[] zf1VarArr, int i, AtomicInteger atomicInteger, xp xpVar, ge0 ge0Var) {
        super(2, ge0Var);
        this.Y = zf1VarArr;
        this.Z = i;
        this.y0 = atomicInteger;
        this.z0 = xpVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((y70) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new y70(this.Y, this.Z, this.y0, this.z0, ge0Var);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        AtomicInteger atomicInteger = this.y0;
        xp xpVar = this.z0;
        try {
            if (i == 0) {
                n12.S(obj);
                zf1[] zf1VarArr = this.Y;
                int i2 = this.Z;
                zf1 zf1Var = zf1VarArr[i2];
                x70 x70Var = new x70(i2, 0, xpVar);
                this.X = 1;
                Object objA = zf1Var.a(x70Var, this);
                mf0 mf0Var = mf0.b;
                if (objA == mf0Var) {
                    return mf0Var;
                }
            } else {
                if (i != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                xpVar.b(null);
            }
            return xl4.a;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                xpVar.b(null);
            }
        }
    }
}
