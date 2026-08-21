package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ak4 extends zj4 {
    public final sj4 a;
    public final nm b;

    public ak4(sj4 sj4Var, nm nmVar) {
        this.a = sj4Var;
        this.b = nmVar;
    }

    @Override // defpackage.zj4
    public String b() {
        return null;
    }

    @Override // defpackage.zj4
    public e10 e(i52 i52Var, e10 e10Var) throws t34 {
        Object objB = e10Var.X;
        if (objB == null) {
            Object obj = e10Var.z;
            Class cls = (Class) e10Var.A;
            sj4 sj4Var = this.a;
            objB = cls == null ? sj4Var.b(obj) : sj4Var.c(obj, cls);
            e10Var.X = objB;
        }
        if (objB != null) {
            i52Var.I0(e10Var);
            return e10Var;
        }
        g72 g72Var = (g72) e10Var.Z;
        e10Var.f = false;
        if (g72Var == g72.A) {
            i52Var.z0(e10Var.z);
            return e10Var;
        }
        if (g72Var == g72.X) {
            i52Var.q0(e10Var.z);
        }
        return e10Var;
    }

    @Override // defpackage.zj4
    public e10 f(i52 i52Var, e10 e10Var) {
        if (e10Var != null) {
            i52Var.J0(e10Var);
            return e10Var;
        }
        g72 g72Var = (g72) e10Var.Z;
        if (g72Var == g72.A) {
            i52Var.M();
            return e10Var;
        }
        if (g72Var == g72.X) {
            i52Var.I();
        }
        return e10Var;
    }
}
