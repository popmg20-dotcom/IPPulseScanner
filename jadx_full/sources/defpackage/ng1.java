package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ng1 implements zf1 {
    public final /* synthetic */ zf1 b;
    public final /* synthetic */ em1 f;

    public ng1(zf1 zf1Var, em1 em1Var) {
        this.b = zf1Var;
        this.f = em1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.zf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ag1 ag1Var, ge0 ge0Var) throws Throwable {
        mg1 mg1Var;
        mo3 mo3Var;
        mo3 mo3Var2;
        if (ge0Var instanceof mg1) {
            mg1Var = (mg1) ge0Var;
            int i = mg1Var.X;
            if ((i & Integer.MIN_VALUE) != 0) {
                mg1Var.X = i - Integer.MIN_VALUE;
            } else {
                mg1Var = new mg1(this, ge0Var);
            }
        }
        Object obj = mg1Var.A;
        int i2 = mg1Var.X;
        mf0 mf0Var = mf0.b;
        try {
        } catch (Throwable th) {
            ng1 ng1Var = this;
            zd4 zd4Var = new zd4(th);
            em1 em1Var = ng1Var.f;
            mg1Var.Z = th;
            mg1Var.y0 = null;
            mg1Var.X = 2;
            if (xb5.D(zd4Var, em1Var, th, mg1Var) != mf0Var) {
                throw th;
            }
        }
        try {
            if (i2 == 0) {
                n12.S(obj);
                zf1 zf1Var = this.b;
                mg1Var.Z = this;
                mg1Var.y0 = ag1Var;
                mg1Var.X = 1;
                if (zf1Var.a(ag1Var, mg1Var) != mf0Var) {
                }
                return mf0Var;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    Throwable th2 = (Throwable) mg1Var.Z;
                    n12.S(obj);
                    throw th2;
                }
                if (i2 != 3) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mo3Var2 = (mo3) mg1Var.Z;
                try {
                    n12.S(obj);
                    mo3Var2.q();
                    return xl4.a;
                } catch (Throwable th3) {
                    th = th3;
                    mo3Var2.q();
                    throw th;
                }
            }
            ag1Var = mg1Var.y0;
            this = (ng1) mg1Var.Z;
            n12.S(obj);
            em1 em1Var2 = this.f;
            mg1Var.Z = mo3Var;
            mg1Var.y0 = null;
            mg1Var.X = 3;
            if (em1Var2.e(mo3Var, null, mg1Var) != mf0Var) {
                mo3Var2 = mo3Var;
                mo3Var2.q();
                return xl4.a;
            }
            return mf0Var;
        } catch (Throwable th4) {
            th = th4;
            mo3Var2 = mo3Var;
            mo3Var2.q();
            throw th;
        }
        cf0 cf0Var = mg1Var.f;
        cf0Var.getClass();
        mo3Var = new mo3(ag1Var, cf0Var);
    }
}
