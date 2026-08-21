package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vg3 extends rj2 {
    public final Object m;
    public final s53 n;
    public yc2 o;
    public final Object p;

    public vg3(Object obj) {
        s53 s53Var = new s53(10);
        this.m = obj;
        this.n = s53Var;
        this.p = obj;
    }

    public static final void o(vg3 vg3Var, yc2 yc2Var) {
        super.m(yc2Var, new zn(4, new f0(11, vg3Var)));
    }

    @Override // defpackage.yc2
    public final Object d() {
        yc2 yc2Var = this.o;
        if (yc2Var == null) {
            return this.m;
        }
        Object objD = yc2Var.d();
        this.n.getClass();
        return objD;
    }

    @Override // defpackage.rj2
    public final void m(yc2 yc2Var, hu2 hu2Var) {
        throw null;
    }

    public final void n(on2 on2Var) {
        qj2 qj2Var;
        on2Var.getClass();
        yc2 yc2Var = this.o;
        if (yc2Var != null && (qj2Var = (qj2) this.l.b(yc2Var)) != null) {
            qj2Var.a();
        }
        this.o = on2Var;
        co4.S(new xy0(9, this, on2Var));
    }
}
