package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bt0 extends it0 implements g12 {
    public static final e1 Z = new e1(10);
    public static final at0 y0 = new at0(0);
    public volatile op0 A;
    public final String X;
    public final zs0 Y;
    public final int f;
    public final lp0 z;

    public bt0(zs0 zs0Var, Integer num) {
        String str = "UNKNOWN_ENUM_VALUE_" + zs0Var.f.H() + "_" + num;
        kp0 kp0VarU = lp0.A0.u();
        kp0VarU.Y = str;
        kp0VarU.X |= 1;
        kp0VarU.S();
        kp0VarU.Z = num.intValue();
        kp0VarU.X |= 2;
        kp0VarU.S();
        lp0 lp0VarI = kp0VarU.I();
        if (!lp0VarI.c()) {
            throw a1.C(lp0VarI);
        }
        this.f = -1;
        this.z = lp0VarI;
        this.Y = zs0Var;
        this.X = zs0Var.z + '.' + lp0VarI.H();
    }

    @Override // defpackage.g12
    public final int a() {
        return this.z.Z;
    }

    @Override // defpackage.it0
    public final gt0 c() {
        return this.Y.c();
    }

    @Override // defpackage.it0
    public final String d() {
        return this.X;
    }

    @Override // defpackage.it0
    public final it0 e() {
        return this.Y;
    }

    @Override // defpackage.it0
    public final String getName() {
        return this.z.H();
    }

    @Override // defpackage.it0
    public final c1 h() {
        return this.z;
    }

    public final op0 j() {
        if (this.A == null) {
            op0 op0VarJ = this.z.J();
            if (op0VarJ.P()) {
                np0 np0VarU = op0VarJ.u();
                np0VarU.Y &= -3;
                np0VarU.y0 = null;
                ue1 ue1Var = np0VarU.z0;
                if (ue1Var != null) {
                    ue1Var.b = null;
                    np0VarU.z0 = null;
                }
                np0VarU.S();
                op0VarJ = np0VarU.q();
                if (!op0VarJ.c()) {
                    throw a1.C(op0VarJ);
                }
            }
            synchronized (this) {
                try {
                    if (this.A == null) {
                        this.A = op0VarJ;
                    }
                } finally {
                }
            }
        }
        return this.A;
    }

    public final String toString() {
        return this.z.H();
    }

    public bt0(lp0 lp0Var, zs0 zs0Var, int i) throws xs0 {
        this.f = i;
        this.z = lp0Var;
        this.Y = zs0Var;
        this.X = zs0Var.z + '.' + lp0Var.H();
        zs0Var.A.c().z0.e(this);
    }
}
