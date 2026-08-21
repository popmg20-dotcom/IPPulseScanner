package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class te extends ak4 {
    public static final te d = new te(null, 0 == true ? 1 : 0, 0);
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ te(sj4 sj4Var, nm nmVar, int i) {
        super(sj4Var, nmVar);
        this.c = i;
    }

    @Override // defpackage.zj4
    public zj4 a(nm nmVar) {
        switch (this.c) {
            case 0:
                return this;
            case 1:
                return g(nmVar);
            default:
                return this.b == nmVar ? this : new te(this.a, nmVar, 2);
        }
    }

    @Override // defpackage.zj4
    public j72 c() {
        switch (this.c) {
            case 0:
                return j72.X;
            case 1:
                return j72.z;
            default:
                return j72.f;
        }
    }

    @Override // defpackage.ak4, defpackage.zj4
    public e10 e(i52 i52Var, e10 e10Var) throws t34 {
        switch (this.c) {
            case 0:
                if (((g72) e10Var.Z).z) {
                    i52Var.getClass();
                    i52Var.I0(e10Var);
                }
                break;
            default:
                super.e(i52Var, e10Var);
                break;
        }
        return e10Var;
    }

    @Override // defpackage.ak4, defpackage.zj4
    public e10 f(i52 i52Var, e10 e10Var) {
        switch (this.c) {
            case 0:
                if (e10Var == null) {
                    return null;
                }
                i52Var.J0(e10Var);
                return e10Var;
            default:
                return super.f(i52Var, e10Var);
        }
    }

    public te g(nm nmVar) {
        return this.b == nmVar ? this : new te(this.a, nmVar, 1);
    }
}
