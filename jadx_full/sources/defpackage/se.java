package defpackage;

import j$.util.Objects;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class se extends hd0 implements ee0 {
    public final nm A;
    public final boolean X;
    public final Boolean Y;
    public final zj4 Z;
    public final b72 y0;
    public final nj4 z;
    public ke0 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se(Class cls, nj4 nj4Var, boolean z, zj4 zj4Var, b72 b72Var) {
        super(cls, 0);
        boolean z2 = false;
        this.z = nj4Var;
        if (z || (nj4Var != null && Modifier.isFinal(nj4Var.L0.getModifiers()))) {
            z2 = true;
        }
        this.X = z2;
        this.Z = zj4Var;
        this.A = null;
        this.y0 = b72Var;
        this.z0 = z83.e;
        this.Y = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    @Override // defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b72 a(gt3 gt3Var, nm nmVar) {
        b72 b72VarD;
        nj4 nj4Var;
        Object objC;
        zj4 zj4Var = this.Z;
        zj4 zj4VarG = zj4Var != null ? zj4Var.g(nmVar) : zj4Var;
        if (nmVar != null) {
            cu2 cu2VarD = gt3Var.b.d();
            c9 c9VarA = nmVar.a();
            b72VarD = (c9VarA == null || (objC = cu2VarD.c(c9VarA)) == null) ? null : gt3Var.D(c9VarA, objC);
        }
        e52 e52VarK = l34.k(gt3Var, nmVar, this.b);
        Boolean boolB = e52VarK != null ? e52VarK.b(b52.b) : null;
        b72 b72Var = this.y0;
        if (b72VarD == null) {
            b72VarD = b72Var;
        }
        b72 b72VarJ = l34.j(gt3Var, nmVar, b72VarD);
        if (b72VarJ == null && (nj4Var = this.z) != null && this.X && !nj4Var.j0()) {
            b72VarJ = gt3Var.i(nj4Var, nmVar);
        }
        return (b72VarJ == b72Var && nmVar == this.A && zj4Var == zj4VarG && Objects.equals(this.Y, boolB)) ? this : r(nmVar, zj4VarG, b72VarJ, boolB);
    }

    @Override // defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(obj, g72.X));
        i52Var.s(obj);
        q(obj, i52Var, gt3Var);
        zj4Var.f(i52Var, e10VarE);
    }

    public final b72 p(ke0 ke0Var, nj4 nj4Var, gt3 gt3Var) {
        v62 v62VarG = ke0Var.g(nj4Var, gt3Var, this.A);
        ke0 ke0Var2 = (ke0) v62VarG.z;
        if (ke0Var != ke0Var2) {
            this.z0 = ke0Var2;
        }
        return (b72) v62VarG.f;
    }

    public abstract void q(Object obj, i52 i52Var, gt3 gt3Var);

    public abstract se r(nm nmVar, zj4 zj4Var, b72 b72Var, Boolean bool);

    public se(se seVar, nm nmVar, zj4 zj4Var, b72 b72Var, Boolean bool) {
        super(seVar.b, 0);
        this.z = seVar.z;
        this.X = seVar.X;
        this.Z = zj4Var;
        this.A = nmVar;
        this.y0 = b72Var;
        this.z0 = z83.e;
        this.Y = bool;
    }
}
