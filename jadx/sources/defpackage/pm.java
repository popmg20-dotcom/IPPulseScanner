package defpackage;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class pm implements nm, Serializable {
    public final nj4 A;
    public b72 A0;
    public b72 B0;
    public zj4 C0;
    public transient ke0 D0;
    public final boolean E0;
    public final Object F0;
    public final Class[] G0;
    public final transient HashMap H0;
    public final nj4 X;
    public nj4 Y;
    public final c9 Z;
    public final o83 b;
    public final ft3 f;
    public final transient Method y0;
    public final p83 z;
    public final transient Field z0;

    public pm(om omVar, c9 c9Var, o9 o9Var, nj4 nj4Var, b72 b72Var, ak4 ak4Var, nj4 nj4Var2, boolean z, Object obj, Class[] clsArr) {
        o83 o83VarI = omVar.i();
        this.b = o83VarI == null ? o83.y0 : o83VarI;
        this.Z = c9Var;
        this.f = new ft3(omVar.getName());
        omVar.m();
        this.z = null;
        this.A = nj4Var;
        this.A0 = b72Var;
        this.D0 = b72Var == null ? z83.e : null;
        this.C0 = ak4Var;
        this.X = nj4Var2;
        if (c9Var instanceof a9) {
            this.y0 = null;
            this.z0 = ((a9) c9Var).D0;
        } else if (c9Var instanceof d9) {
            this.y0 = ((d9) c9Var).E0;
            this.z0 = null;
        } else {
            this.y0 = null;
            this.z0 = null;
        }
        this.E0 = z;
        this.F0 = obj;
        this.B0 = null;
        this.G0 = clsArr;
    }

    @Override // defpackage.nm
    public final c9 a() {
        return this.Z;
    }

    @Override // defpackage.nm
    public final e52 b(yg2 yg2Var, Class cls) {
        ((zg2) yg2Var).getClass();
        e52 e52Var = e52.y0;
        cu2 cu2VarD = yg2Var.d();
        c9 c9VarA = a();
        e52 e52VarH = c9VarA != null ? cu2VarD.h(c9VarA) : null;
        return e52Var == null ? e52VarH == null ? nm.c : e52VarH : e52VarH == null ? e52Var : e52Var.d(e52VarH);
    }

    public b72 c(ke0 ke0Var, Class cls, gt3 gt3Var) {
        v62 v62Var;
        nj4 nj4Var = this.Y;
        boolean z = false;
        int i = 18;
        if (nj4Var != null) {
            nj4 nj4VarE = gt3Var.e(nj4Var, cls);
            ke0Var.getClass();
            b72 b72VarM = gt3Var.m(nj4VarE, this);
            v62Var = new v62(i, b72VarM, ke0Var.n(nj4VarE.L0, b72VarM), z);
        } else {
            ke0Var.getClass();
            b72 b72VarN = gt3Var.n(cls, this);
            v62Var = new v62(i, b72VarN, ke0Var.n(cls, b72VarN), z);
        }
        ke0 ke0Var2 = (ke0) v62Var.z;
        if (ke0Var != ke0Var2) {
            this.D0 = ke0Var2;
        }
        return (b72) v62Var.f;
    }

    @Override // defpackage.nm
    public final t52 d(yg2 yg2Var, Class cls) {
        cu2 cu2VarD = yg2Var.d();
        c9 c9VarA = a();
        if (c9VarA == null) {
            return (t52) ((zg2) yg2Var).Z.f;
        }
        c9VarA.u();
        return ((t52) ((zg2) yg2Var).Z.f).a(cu2VarD.x(c9VarA));
    }

    public final boolean e(i52 i52Var, gt3 gt3Var, b72 b72Var) throws o12 {
        if (b72Var.h()) {
            return false;
        }
        if (gt3Var.b.h(dt3.FAIL_ON_SELF_REFERENCES)) {
            if (!(b72Var instanceof rm)) {
                return false;
            }
            gt3Var.A("Direct self-reference leading to cycle");
            throw null;
        }
        if (!gt3Var.b.h(dt3.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this.B0 != null) {
            if (((eo1) i52Var).X.b != 1) {
                i52Var.N(this.f);
            }
            this.B0.e(null, i52Var, gt3Var);
        }
        return true;
    }

    public void f(b72 b72Var) {
        b72 b72Var2 = this.B0;
        if (b72Var2 == null || b72Var2 == b72Var) {
            this.B0 = b72Var;
        } else {
            xe.q(fw.u("Cannot override _nullSerializer: had a ", n50.e(b72Var2), ", trying to set to ", n50.e(b72Var)));
        }
    }

    public void g(b72 b72Var) {
        b72 b72Var2 = this.A0;
        if (b72Var2 == null || b72Var2 == b72Var) {
            this.A0 = b72Var;
        } else {
            xe.q(fw.u("Cannot override _serializer: had a ", n50.e(b72Var2), ", trying to set to ", n50.e(b72Var)));
        }
    }

    public void h(bt3 bt3Var) {
        boolean zF = bt3Var.f(ah2.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
        Member memberQ = this.Z.Q();
        if (memberQ != null) {
            n50.d(memberQ, zF);
        }
    }

    public pm i(po2 po2Var) {
        ft3 ft3Var = this.f;
        String strA = po2Var.a(ft3Var.b);
        return strA.equals(ft3Var.b) ? this : new pm(this, p83.a(strA));
    }

    public void j(Object obj, i52 i52Var, gt3 gt3Var) {
        Method method = this.y0;
        Object objInvoke = method == null ? this.z0.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            b72 b72Var = this.B0;
            if (b72Var != null) {
                b72Var.e(null, i52Var, gt3Var);
                return;
            } else {
                i52Var.U();
                return;
            }
        }
        b72 b72VarC = this.A0;
        if (b72VarC == null) {
            Class<?> cls = objInvoke.getClass();
            ke0 ke0Var = this.D0;
            b72 b72VarA = ke0Var.A(cls);
            b72VarC = b72VarA == null ? c(ke0Var, cls, gt3Var) : b72VarA;
        }
        Object obj2 = this.F0;
        if (obj2 != null) {
            if (s52.z == obj2) {
                if (b72VarC.c(gt3Var, objInvoke)) {
                    l(i52Var, gt3Var);
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                l(i52Var, gt3Var);
                return;
            }
        }
        if (objInvoke == obj && e(i52Var, gt3Var, b72VarC)) {
            return;
        }
        zj4 zj4Var = this.C0;
        if (zj4Var == null) {
            b72VarC.e(objInvoke, i52Var, gt3Var);
        } else {
            b72VarC.f(objInvoke, i52Var, gt3Var, zj4Var);
        }
    }

    public void k(Object obj, i52 i52Var, gt3 gt3Var) {
        Method method = this.y0;
        Object objInvoke = method == null ? this.z0.get(obj) : method.invoke(obj, null);
        ft3 ft3Var = this.f;
        Object obj2 = this.F0;
        if (objInvoke == null) {
            if ((obj2 == null || !gt3Var.x(obj2)) && this.B0 != null) {
                i52Var.N(ft3Var);
                this.B0.e(null, i52Var, gt3Var);
                return;
            }
            return;
        }
        b72 b72VarC = this.A0;
        if (b72VarC == null) {
            Class<?> cls = objInvoke.getClass();
            ke0 ke0Var = this.D0;
            b72 b72VarA = ke0Var.A(cls);
            b72VarC = b72VarA == null ? c(ke0Var, cls, gt3Var) : b72VarA;
        }
        if (obj2 != null) {
            if (s52.z == obj2) {
                if (b72VarC.c(gt3Var, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && e(i52Var, gt3Var, b72VarC)) {
            return;
        }
        i52Var.N(ft3Var);
        zj4 zj4Var = this.C0;
        if (zj4Var == null) {
            b72VarC.e(objInvoke, i52Var, gt3Var);
        } else {
            b72VarC.f(objInvoke, i52Var, gt3Var, zj4Var);
        }
    }

    public final void l(i52 i52Var, gt3 gt3Var) {
        b72 b72Var = this.B0;
        if (b72Var != null) {
            b72Var.e(null, i52Var, gt3Var);
        } else {
            i52Var.U();
        }
    }

    public final String toString() {
        StringBuilder sbB = fw.B(40, "property '");
        sbB.append(this.f.b);
        sbB.append("' (");
        Method method = this.y0;
        if (method != null) {
            sbB.append("via method ");
            sbB.append(method.getDeclaringClass().getName());
            sbB.append("#");
            sbB.append(method.getName());
        } else {
            Field field = this.z0;
            if (field != null) {
                sbB.append("field \"");
                sbB.append(field.getDeclaringClass().getName());
                sbB.append("#");
                sbB.append(field.getName());
            } else {
                sbB.append("virtual");
            }
        }
        b72 b72Var = this.A0;
        if (b72Var == null) {
            sbB.append(", no static serializer");
        } else {
            sbB.append(", static serializer of type ".concat(b72Var.getClass().getName()));
        }
        sbB.append(')');
        return sbB.toString();
    }

    public pm(pm pmVar, p83 p83Var) {
        this(pmVar, false);
        this.f = new ft3(p83Var.b);
        this.z = pmVar.z;
        this.A = pmVar.A;
        this.Z = pmVar.Z;
        this.y0 = pmVar.y0;
        this.z0 = pmVar.z0;
        this.A0 = pmVar.A0;
        this.B0 = pmVar.B0;
        if (pmVar.H0 != null) {
            this.H0 = new HashMap(pmVar.H0);
        }
        this.X = pmVar.X;
        this.D0 = z83.e;
        this.E0 = pmVar.E0;
        this.F0 = pmVar.F0;
        this.G0 = pmVar.G0;
        this.C0 = pmVar.C0;
        this.Y = pmVar.Y;
    }

    public pm(pm pmVar, ft3 ft3Var) {
        this(pmVar, false);
        this.f = ft3Var;
        this.z = pmVar.z;
        this.Z = pmVar.Z;
        this.A = pmVar.A;
        this.y0 = pmVar.y0;
        this.z0 = pmVar.z0;
        this.A0 = pmVar.A0;
        this.B0 = pmVar.B0;
        if (pmVar.H0 != null) {
            this.H0 = new HashMap(pmVar.H0);
        }
        this.X = pmVar.X;
        this.D0 = z83.e;
        this.E0 = pmVar.E0;
        this.F0 = pmVar.F0;
        this.G0 = pmVar.G0;
        this.C0 = pmVar.C0;
        this.Y = pmVar.Y;
    }

    public pm(pm pmVar, boolean z) {
        this.b = pmVar.b;
    }

    public pm(pm pmVar) {
        this(pmVar, pmVar.f);
    }
}
