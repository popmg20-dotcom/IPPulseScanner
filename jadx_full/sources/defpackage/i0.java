package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 extends e42 implements ge0, lf0 {
    public final cf0 z;

    public i0(cf0 cf0Var, boolean z) {
        super(z);
        L((v32) cf0Var.Z(pr1.X));
        this.z = cf0Var.X(this);
    }

    @Override // defpackage.lf0
    public final cf0 I() {
        return this.z;
    }

    @Override // defpackage.e42
    public final void K(t80 t80Var) {
        r25.E(this.z, t80Var);
    }

    @Override // defpackage.e42
    public final void Y(Object obj) {
        if (!(obj instanceof r80)) {
            k0(obj);
        } else {
            r80 r80Var = (r80) obj;
            j0(r80Var.a, re.a.getIntVolatile(r80Var, r80.b) == 1);
        }
    }

    @Override // defpackage.ge0
    public final void d(Object obj) {
        Throwable thA = uk3.a(obj);
        if (thA != null) {
            obj = new r80(thA, false);
        }
        Object objT = T(obj);
        if (objT == f42.b) {
            return;
        }
        p(objT);
    }

    @Override // defpackage.ge0
    public final cf0 j() {
        return this.z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l0(of0 of0Var, i0 i0Var, Function2 function2) {
        int iOrdinal = of0Var.ordinal();
        xl4 xl4Var = xl4.a;
        if (iOrdinal == 0) {
            try {
                mv0.a(p95.u(((kk) function2).n(this, i0Var)), xl4Var);
                return;
            } finally {
                th = th;
                if (th instanceof kv0) {
                    th = ((kv0) th).b;
                }
                d(new tk3(th));
            }
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                p95.u(((kk) function2).n(this, i0Var)).d(xl4Var);
                return;
            }
            if (iOrdinal != 3) {
                g.d();
                return;
            }
            try {
                cf0 cf0Var = this.z;
                Object objC = nd4.c(cf0Var, null);
                try {
                    tj4.c(2, function2);
                    Object objK = function2.k(i0Var, this);
                    if (objK != mf0.b) {
                        d(objK);
                    }
                } finally {
                    nd4.a(cf0Var, objC);
                }
            } catch (Throwable th) {
                th = th;
            }
        }
    }

    @Override // defpackage.e42
    public final String u() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public void k0(Object obj) {
    }

    public void j0(Throwable th, boolean z) {
    }
}
