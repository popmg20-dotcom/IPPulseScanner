package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j34 extends l34 {
    public transient ke0 z;

    public j34() {
        super(String.class, 0);
        this.z = z83.e;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        Class<?> cls = obj.getClass();
        ke0 ke0Var = this.z;
        b72 b72VarA = ke0Var.A(cls);
        if (b72VarA == null) {
            if (cls == Object.class) {
                b72VarA = new i34(8, cls);
                this.z = ke0Var.n(cls, b72VarA);
            } else {
                b72VarA = gt3Var.k(gt3Var.b.c(cls), null);
                ke0 ke0VarN = ke0Var.n(cls, b72VarA);
                if (ke0Var != ke0VarN) {
                    this.z = ke0VarN;
                }
            }
        }
        b72VarA.e(obj, i52Var, gt3Var);
    }
}
