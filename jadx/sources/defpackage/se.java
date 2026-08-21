package defpackage;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b72 a(defpackage.gt3 r8, defpackage.nm r9) {
        /*
            r7 = this;
            zj4 r0 = r7.Z
            if (r0 == 0) goto L9
            zj4 r1 = r0.g(r9)
            goto La
        L9:
            r1 = r0
        La:
            r2 = 0
            if (r9 == 0) goto L24
            bt3 r3 = r8.b
            cu2 r3 = r3.d()
            c9 r4 = r9.a()
            if (r4 == 0) goto L24
            java.lang.Object r3 = r3.c(r4)
            if (r3 == 0) goto L24
            b72 r3 = r8.D(r4, r3)
            goto L25
        L24:
            r3 = r2
        L25:
            java.lang.Class r4 = r7.b
            e52 r4 = defpackage.l34.k(r8, r9, r4)
            if (r4 == 0) goto L33
            b52 r2 = defpackage.b52.b
            java.lang.Boolean r2 = r4.b(r2)
        L33:
            b72 r4 = r7.y0
            if (r3 != 0) goto L38
            r3 = r4
        L38:
            b72 r3 = defpackage.l34.j(r8, r9, r3)
            if (r3 != 0) goto L50
            nj4 r5 = r7.z
            if (r5 == 0) goto L50
            boolean r6 = r7.X
            if (r6 == 0) goto L50
            boolean r6 = r5.j0()
            if (r6 != 0) goto L50
            b72 r3 = r8.i(r5, r9)
        L50:
            if (r3 != r4) goto L62
            nm r8 = r7.A
            if (r9 != r8) goto L62
            if (r0 != r1) goto L62
            java.lang.Boolean r8 = r7.Y
            boolean r8 = j$.util.Objects.equals(r8, r2)
            if (r8 != 0) goto L61
            goto L62
        L61:
            return r7
        L62:
            se r7 = r7.r(r9, r1, r3, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.se.a(gt3, nm):b72");
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
