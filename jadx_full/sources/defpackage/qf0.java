package defpackage;

import androidx.work.CoroutineWorker;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qf0 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ CoroutineWorker Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qf0(CoroutineWorker coroutineWorker, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = coroutineWorker;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                ((qf0) n(ge0Var, lf0Var)).p(xl4Var);
                return xl4Var;
            default:
                return ((qf0) n(ge0Var, lf0Var)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        CoroutineWorker coroutineWorker = this.Z;
        switch (i) {
            case 0:
                return new qf0(coroutineWorker, ge0Var, 0);
            default:
                return new qf0(coroutineWorker, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        switch (this.X) {
            case 0:
                int i = this.Y;
                if (i == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    xe.q("Not implemented");
                } else {
                    if (i == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                }
                return null;
            default:
                int i2 = this.Y;
                if (i2 != 0) {
                    if (i2 == 1) {
                        n12.S(obj);
                        return obj;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                this.Y = 1;
                Object objC = this.Z.c(this);
                mf0 mf0Var = mf0.b;
                return objC == mf0Var ? mf0Var : objC;
        }
    }
}
