package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cv extends v74 implements em1 {
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ Object Z;
    public /* synthetic */ Object y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cv(int i, ge0 ge0Var, int i2) {
        super(i, ge0Var);
        this.X = i2;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        int i2 = 3;
        switch (i) {
            case 0:
                cv cvVar = new cv(i2, (ge0) obj3, 0);
                cvVar.Z = (gn2) obj;
                cvVar.y0 = (gn2) obj2;
                return cvVar.p(xl4Var);
            default:
                cv cvVar2 = new cv(i2, (ge0) obj3, 1);
                cvVar2.Z = (ag1) obj;
                cvVar2.y0 = (Object[]) obj2;
                return cvVar2.p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        qc0 qc0Var;
        int i = this.X;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        qc0 qc0Var2 = null;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 != 0) {
                    if (i2 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    gn2 gn2Var = (gn2) this.Z;
                    n12.S(obj);
                    return gn2Var;
                }
                n12.S(obj);
                gn2 gn2Var2 = (gn2) this.Z;
                gn2 gn2Var3 = (gn2) this.y0;
                this.Z = gn2Var3;
                this.Y = 1;
                ((z14) gn2Var2.b.A).g(null);
                return xl4Var == mf0Var ? mf0Var : gn2Var3;
            default:
                int i3 = this.Y;
                if (i3 != 0) {
                    if (i3 == 1) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj);
                ag1 ag1Var = (ag1) this.Z;
                qc0[] qc0VarArr = (qc0[]) ((Object[]) this.y0);
                int length = qc0VarArr.length;
                int i4 = 0;
                while (true) {
                    qc0Var = oc0.a;
                    if (i4 < length) {
                        qc0 qc0Var3 = qc0VarArr[i4];
                        if (n12.c(qc0Var3, qc0Var)) {
                            i4++;
                        } else {
                            qc0Var2 = qc0Var3;
                        }
                    }
                }
                if (qc0Var2 != null) {
                    qc0Var = qc0Var2;
                }
                this.Y = 1;
                return ag1Var.h(qc0Var, this) == mf0Var ? mf0Var : xl4Var;
        }
    }
}
