package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wd extends kn1 {
    public int X;
    public zt Y = zt.z;

    @Override // defpackage.kn1
    public final vn1 L() {
        vn1 vn1Var = bf4.Z0;
        vn1Var.a(xd.class, wd.class);
        return vn1Var;
    }

    @Override // defpackage.a1, defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final xd q() {
        xd xdVar = new xd(this);
        xdVar.X = zt.z;
        xdVar.Y = (byte) -1;
        int i = this.X;
        if (i != 0 && (i & 1) != 0) {
            xdVar.X = this.Y;
        }
        R();
        return xdVar;
    }

    public final void V(xd xdVar) {
        if (xdVar == xd.Z) {
            return;
        }
        if (!xdVar.X.isEmpty()) {
            zt ztVar = xdVar.X;
            ztVar.getClass();
            this.Y = ztVar;
            this.X |= 1;
            S();
        }
        A(xdVar.z);
        S();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void y(m60 m60Var, o91 o91Var) {
        o91Var.getClass();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iS = m60Var.s();
                    if (iS != 0) {
                        if (iS == 10) {
                            this.Y = m60Var.h();
                            this.X |= 1;
                        } else if (!u().t(iS, m60Var)) {
                        }
                    }
                    z = true;
                } catch (s12 e) {
                    throw e.c();
                }
            } finally {
                S();
            }
        }
    }

    @Override // defpackage.ol2
    public final c1 a() {
        return xd.Z;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: build */
    public final nl2 p() {
        xd xdVarQ = q();
        if (xdVarQ.c()) {
            return xdVarQ;
        }
        throw a1.C(xdVarQ);
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    @Override // defpackage.a1, defpackage.ql2
    public final ws0 f() {
        return bf4.Y0;
    }

    @Override // defpackage.a1
    public final c1 p() {
        xd xdVarQ = q();
        if (xdVarQ.c()) {
            return xdVarQ;
        }
        throw a1.C(xdVarQ);
    }

    @Override // defpackage.a1
    public final a1 v(c1 c1Var) {
        if (c1Var instanceof xd) {
            V((xd) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: w */
    public final /* bridge */ /* synthetic */ a1 M(m60 m60Var, o91 o91Var) {
        y(m60Var, o91Var);
        return this;
    }

    @Override // defpackage.a1
    public final a1 x(c1 c1Var) {
        if (c1Var instanceof xd) {
            V((xd) c1Var);
            return this;
        }
        super.v(c1Var);
        return this;
    }
}
