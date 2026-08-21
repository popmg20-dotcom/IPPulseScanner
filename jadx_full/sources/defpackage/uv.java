package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class uv extends b30 {
    public final Function2 A;
    public final Function2 X;

    public uv(Function2 function2, cf0 cf0Var, int i, jp jpVar) {
        super(cf0Var, i, jpVar);
        this.A = function2;
        this.X = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.b30
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(q53 q53Var, ge0 ge0Var) {
        tv tvVar;
        if (ge0Var instanceof tv) {
            tvVar = (tv) ge0Var;
            int i = tvVar.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                tvVar.Z = i - Integer.MIN_VALUE;
            } else {
                tvVar = new tv(this, (ie0) ge0Var);
            }
        }
        Object obj = tvVar.X;
        int i2 = tvVar.Z;
        xl4 xl4Var = xl4.a;
        if (i2 == 0) {
            n12.S(obj);
            tvVar.A = q53Var;
            tvVar.Z = 1;
            Object objK = this.A.k(q53Var, tvVar);
            mf0 mf0Var = mf0.b;
            if (objK != mf0Var) {
                objK = xl4Var;
            }
            if (objK == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            q53Var = tvVar.A;
            n12.S(obj);
        }
        if (q53Var.A.y()) {
            return xl4Var;
        }
        xe.q("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
        return null;
    }

    @Override // defpackage.b30
    public final b30 e(cf0 cf0Var, int i, jp jpVar) {
        return new uv(this.X, cf0Var, i, jpVar);
    }

    @Override // defpackage.b30
    public final String toString() {
        return "block[" + this.A + "] -> " + super.toString();
    }
}
