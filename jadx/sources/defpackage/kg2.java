package defpackage;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kg2 extends hd0 implements ee0 {
    public final boolean A;
    public ke0 A0;
    public final Object B0;
    public final boolean C0;
    public final nj4 X;
    public final nj4 Y;
    public final b72 Z;
    public final b72 y0;
    public final nm z;
    public final zj4 z0;

    public kg2(kg2 kg2Var, b72 b72Var, b72 b72Var2, Object obj, boolean z) {
        super(Map.class, 0);
        this.X = kg2Var.X;
        this.Y = kg2Var.Y;
        this.A = kg2Var.A;
        this.z0 = kg2Var.z0;
        this.Z = b72Var;
        this.y0 = b72Var2;
        this.A0 = z83.e;
        this.z = kg2Var.z;
        this.B0 = obj;
        this.C0 = z;
    }

    @Override // defpackage.ee0
    public final b72 a(gt3 gt3Var, nm nmVar) {
        b72 b72VarD;
        b72 b72VarD2;
        boolean zX;
        boolean z;
        Object obj;
        t52 t52VarD;
        s52 s52Var;
        bt3 bt3Var = gt3Var.b;
        cu2 cu2VarD = bt3Var.d();
        Object objB = null;
        c9 c9VarA = nmVar == null ? null : nmVar.a();
        if (c9VarA != null) {
            Object objK = cu2VarD.k(c9VarA);
            b72VarD2 = objK != null ? gt3Var.D(c9VarA, objK) : null;
            Object objC = cu2VarD.c(c9VarA);
            b72VarD = objC != null ? gt3Var.D(c9VarA, objC) : null;
        } else {
            b72VarD = null;
            b72VarD2 = null;
        }
        if (b72VarD == null) {
            b72VarD = this.y0;
        }
        b72 b72VarJ = l34.j(gt3Var, nmVar, b72VarD);
        nj4 nj4Var = this.Y;
        if (b72VarJ == null && this.A && !nj4Var.j0()) {
            b72VarJ = gt3Var.i(nj4Var, nmVar);
        }
        b72 b72Var = b72VarJ;
        if (b72VarD2 == null) {
            b72VarD2 = this.Z;
        }
        b72 b72VarK = b72VarD2 == null ? gt3Var.k(this.X, nmVar) : gt3Var.v(b72VarD2, nmVar);
        if (nmVar != null && (t52VarD = nmVar.d(bt3Var, null)) != null && (s52Var = t52VarD.f) != s52.X) {
            int iOrdinal = s52Var.ordinal();
            zX = true;
            if (iOrdinal != 1) {
                s52 s52Var2 = s52.z;
                if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        z = true;
                        obj = s52Var2;
                    } else if (iOrdinal == 4) {
                        objB = tj4.B(nj4Var);
                        if (objB != null && objB.getClass().isArray()) {
                            objB = ji0.s(objB);
                        }
                    } else if (iOrdinal != 5) {
                        zX = false;
                    } else {
                        objB = gt3Var.w(t52VarD.A);
                        if (objB != null) {
                            zX = gt3Var.x(objB);
                        }
                    }
                } else if (nj4Var.B()) {
                    objB = s52Var2;
                }
            }
            return new kg2(this, b72VarK, b72Var, obj, z);
        }
        objB = this.B0;
        zX = this.C0;
        z = zX;
        obj = objB;
        return new kg2(this, b72VarK, b72Var, obj, z);
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        Object value = ((Map.Entry) obj).getValue();
        if (value == null) {
            return this.C0;
        }
        Object obj2 = this.B0;
        if (obj2 == null) {
            return false;
        }
        b72 b72Var = this.y0;
        if (b72Var == null) {
            Class<?> cls = value.getClass();
            b72 b72VarA = this.A0.A(cls);
            if (b72VarA == null) {
                try {
                    ke0 ke0Var = this.A0;
                    nm nmVar = this.z;
                    ke0Var.getClass();
                    b72 b72VarJ = gt3Var.j(cls, nmVar);
                    ke0 ke0VarN = ke0Var.n(cls, b72VarJ);
                    if (ke0Var != ke0VarN) {
                        this.A0 = ke0VarN;
                    }
                    b72Var = b72VarJ;
                } catch (a62 unused) {
                    return false;
                }
            } else {
                b72Var = b72VarA;
            }
        }
        return obj2 == s52.z ? b72Var.c(gt3Var, value) : obj2.equals(value);
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) throws IOException {
        Map.Entry entry = (Map.Entry) obj;
        i52Var.z0(entry);
        p(entry, i52Var, gt3Var);
        i52Var.M();
    }

    @Override // defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) throws IOException {
        Map.Entry entry = (Map.Entry) obj;
        i52Var.s(entry);
        e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(entry, g72.A));
        p(entry, i52Var, gt3Var);
        zj4Var.f(i52Var, e10VarE);
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        return new kg2(this, this.Z, this.y0, this.B0, this.C0);
    }

    public final void p(Map.Entry entry, i52 i52Var, gt3 gt3Var) throws IOException {
        b72 b72Var;
        Object key = entry.getKey();
        b72 b72Var2 = key == null ? gt3Var.Z : this.Z;
        Object value = entry.getValue();
        if (value != null) {
            b72Var = this.y0;
            if (b72Var == null) {
                Class<?> cls = value.getClass();
                b72 b72VarA = this.A0.A(cls);
                if (b72VarA == null) {
                    nj4 nj4Var = this.Y;
                    boolean zE0 = nj4Var.e0();
                    ke0 ke0Var = this.A0;
                    nm nmVar = this.z;
                    if (zE0) {
                        v62 v62VarG = ke0Var.g(gt3Var.e(nj4Var, cls), gt3Var, nmVar);
                        ke0 ke0Var2 = (ke0) v62VarG.z;
                        if (ke0Var != ke0Var2) {
                            this.A0 = ke0Var2;
                        }
                        b72Var = (b72) v62VarG.f;
                    } else {
                        ke0Var.getClass();
                        b72VarA = gt3Var.j(cls, nmVar);
                        ke0 ke0VarN = ke0Var.n(cls, b72VarA);
                        if (ke0Var != ke0VarN) {
                            this.A0 = ke0VarN;
                        }
                        b72Var = b72VarA;
                    }
                } else {
                    b72Var = b72VarA;
                }
            }
            Object obj = this.B0;
            if (obj != null) {
                if (obj == s52.z) {
                    if (b72Var.c(gt3Var, value)) {
                        return;
                    }
                } else if (obj.equals(value)) {
                    return;
                }
            }
        } else if (this.C0) {
            return;
        } else {
            b72Var = gt3Var.Y;
        }
        b72Var2.e(key, i52Var, gt3Var);
        zj4 zj4Var = this.z0;
        try {
            if (zj4Var == null) {
                b72Var.e(value, i52Var, gt3Var);
            } else {
                b72Var.f(value, i52Var, gt3Var, zj4Var);
            }
        } catch (Exception e) {
            l34.n(gt3Var, e, entry, "" + key);
            throw null;
        }
    }

    public kg2(nj4 nj4Var, nj4 nj4Var2, nj4 nj4Var3, boolean z, ak4 ak4Var, nm nmVar) {
        super(nj4Var);
        this.X = nj4Var2;
        this.Y = nj4Var3;
        this.A = z;
        this.z0 = ak4Var;
        this.z = nmVar;
        this.A0 = z83.e;
        this.B0 = null;
        this.C0 = false;
    }
}
