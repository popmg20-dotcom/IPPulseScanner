package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ue4 extends l34 {
    public final /* synthetic */ int z = 1;

    public /* synthetic */ ue4(Class cls) {
        super(cls);
    }

    @Override // defpackage.b72
    public boolean c(gt3 gt3Var, Object obj) {
        switch (this.z) {
            case 2:
                return o(obj).isEmpty();
            default:
                return super.c(gt3Var, obj);
        }
    }

    @Override // defpackage.b72
    public void e(Object obj, i52 i52Var, gt3 gt3Var) {
        i52Var.G0(o(obj));
    }

    @Override // defpackage.b72
    public void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        switch (this.z) {
            case 1:
                e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(obj, g72.Z));
                e(obj, i52Var, gt3Var);
                zj4Var.f(i52Var, e10VarE);
                break;
            case 2:
                e10 e10VarE2 = zj4Var.e(i52Var, zj4Var.d(obj, g72.Z));
                e(obj, i52Var, gt3Var);
                zj4Var.f(i52Var, e10VarE2);
                break;
            default:
                super.f(obj, i52Var, gt3Var, zj4Var);
                break;
        }
    }

    public abstract String o(Object obj);

    public /* synthetic */ ue4(Class cls, int i) {
        super(cls, i);
    }
}
