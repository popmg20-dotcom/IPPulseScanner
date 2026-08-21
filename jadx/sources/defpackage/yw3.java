package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yw3 extends om {
    public static final /* synthetic */ int Y = 0;
    public final p83 A;
    public final t52 X;
    public final c9 f;
    public final o83 z;

    public yw3(cu2 cu2Var, c9 c9Var, p83 p83Var, o83 o83Var, t52 t52Var) {
        this.f = c9Var;
        this.A = p83Var;
        this.z = o83Var == null ? o83.Z : o83Var;
        this.X = t52Var;
    }

    @Override // defpackage.om
    public final t52 b() {
        return this.X;
    }

    @Override // defpackage.om
    public final h9 f() {
        c9 c9Var = this.f;
        if (c9Var instanceof h9) {
            return (h9) c9Var;
        }
        return null;
    }

    @Override // defpackage.om
    public final a9 g() {
        c9 c9Var = this.f;
        if (c9Var instanceof a9) {
            return (a9) c9Var;
        }
        return null;
    }

    @Override // defpackage.om
    public final String getName() {
        return this.A.b;
    }

    @Override // defpackage.om
    public final d9 h() {
        c9 c9Var = this.f;
        if (!(c9Var instanceof d9)) {
            return null;
        }
        d9 d9Var = (d9) c9Var;
        if (d9Var.V() == 0) {
            return d9Var;
        }
        return null;
    }

    @Override // defpackage.om
    public final o83 i() {
        return this.z;
    }

    @Override // defpackage.om
    public final nj4 j() {
        return this.f.x();
    }

    @Override // defpackage.om
    public final Class k() {
        return this.f.u();
    }

    @Override // defpackage.om
    public final d9 l() {
        c9 c9Var = this.f;
        if (!(c9Var instanceof d9)) {
            return null;
        }
        d9 d9Var = (d9) c9Var;
        if (d9Var.V() == 1) {
            return d9Var;
        }
        return null;
    }

    @Override // defpackage.om
    public final boolean n() {
        return false;
    }

    @Override // defpackage.om
    public final void m() {
    }
}
