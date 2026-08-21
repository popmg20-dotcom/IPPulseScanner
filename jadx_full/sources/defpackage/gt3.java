package defpackage;

import java.text.DateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class gt3 {
    public static final zs2 B0 = new zs2(3);
    public static final fm4 C0 = new fm4(0, 8, Object.class);
    public transient uf2 A;
    public final boolean A0;
    public final fm4 X;
    public final b72 Y;
    public final zs2 Z;
    public final bt3 b;
    public final vf2 f;
    public final xd3 y0;
    public final v62 z;
    public DateFormat z0;

    public gt3(gt3 gt3Var, bt3 bt3Var, vf2 vf2Var) {
        this.X = C0;
        this.Y = zs2.A;
        zs2 zs2Var = B0;
        this.Z = zs2Var;
        this.f = vf2Var;
        this.b = bt3Var;
        v62 v62Var = gt3Var.z;
        this.z = v62Var;
        this.X = gt3Var.X;
        b72 b72Var = gt3Var.Y;
        this.Y = b72Var;
        this.Z = gt3Var.Z;
        this.A0 = b72Var == zs2Var;
        bt3Var.getClass();
        this.A = bt3Var.X;
        xd3 xd3Var = (xd3) ((AtomicReference) v62Var.z).get();
        if (xd3Var == null) {
            synchronized (v62Var) {
                xd3Var = (xd3) ((AtomicReference) v62Var.z).get();
                if (xd3Var == null) {
                    xd3 xd3Var2 = new xd3((o82) v62Var.f);
                    ((AtomicReference) v62Var.z).set(xd3Var2);
                    xd3Var = xd3Var2;
                }
            }
        }
        this.y0 = xd3Var;
    }

    public final Object A(String str) throws o12 {
        throw new o12(((hm0) this).F0, str);
    }

    public final void B(ul ulVar, om omVar, String str, Object... objArr) throws o12 {
        String strO;
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        String name = omVar.getName();
        if (name != null) {
            if (name.length() > 500) {
                name = name.substring(0, 500) + "]...[" + name.substring(name.length() - 500);
            }
            strO = ha0.o("\"", name, "\"");
        } else {
            strO = "[N/A]";
        }
        StringBuilder sbE = fw.E("Invalid definition for property ", strO, " (of type ", n50.t(((nj4) ulVar.b).L0), "): ");
        sbE.append(str);
        throw new o12(((hm0) this).F0, sbE.toString());
    }

    public final void C(ul ulVar, String str, Object... objArr) throws o12 {
        String strT = n50.t(((nj4) ulVar.b).L0);
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new o12(((hm0) this).F0, fw.u("Invalid type definition for type ", strT, ": ", str));
    }

    public abstract b72 D(xb5 xb5Var, Object obj);

    public final b72 a(nj4 nj4Var) throws a62 {
        try {
            b72 b72VarC = c(nj4Var);
            if (b72VarC == null) {
                return b72VarC;
            }
            v62 v62Var = this.z;
            synchronized (v62Var) {
                try {
                    o82 o82Var = (o82) v62Var.f;
                    if (((i53) o82Var.b).f(new uj4(nj4Var), b72VarC, false) == null) {
                        ((AtomicReference) v62Var.z).set(null);
                    }
                    if (b72VarC instanceof rm) {
                        ((rm) b72VarC).t(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return b72VarC;
        } catch (IllegalArgumentException e) {
            throw new a62(((hm0) this).F0, n50.g(e), e);
        }
    }

    public final b72 b(Class cls) throws o12 {
        nj4 nj4VarC = this.b.c(cls);
        try {
            b72 b72VarC = c(nj4VarC);
            if (b72VarC == null) {
                return b72VarC;
            }
            v62 v62Var = this.z;
            synchronized (v62Var) {
                try {
                    o82 o82Var = (o82) v62Var.f;
                    Object objF = ((i53) o82Var.b).f(new uj4(cls, false), b72VarC, false);
                    o82 o82Var2 = (o82) v62Var.f;
                    Object objF2 = ((i53) o82Var2.b).f(new uj4(nj4VarC), b72VarC, false);
                    if (objF == null || objF2 == null) {
                        ((AtomicReference) v62Var.z).set(null);
                    }
                    if (b72VarC instanceof rm) {
                        ((rm) b72VarC).t(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return b72VarC;
        } catch (IllegalArgumentException e) {
            A(n50.g(e));
            throw null;
        }
    }

    public final b72 c(nj4 nj4Var) throws o12 {
        Class cls;
        tm tmVar = (tm) this.f;
        tmVar.getClass();
        bt3 bt3Var = this.b;
        ul ulVarG = bt3Var.g(nj4Var);
        w8 w8Var = (w8) ulVarG.f;
        b72 b72VarK = fm.K(this, w8Var);
        if (b72VarK != null) {
            return b72VarK;
        }
        boolean z = false;
        try {
            nj4 nj4VarA0 = bt3Var.d().a0(bt3Var, w8Var, nj4Var);
            if (nj4VarA0 != nj4Var) {
                z = true;
                if (!nj4VarA0.g0(nj4Var.L0)) {
                    ulVarG = bt3Var.g(nj4VarA0);
                }
            }
            cu2 cu2Var = (cu2) ulVarG.e;
            if (cu2Var != null) {
                Object objE = cu2Var.E((w8) ulVarG.f);
                yg2 yg2Var = (yg2) ulVarG.d;
                if (objE != null && (cls = (Class) objE) != ke0.class && !n50.o(cls)) {
                    if (!le0.class.isAssignableFrom(cls)) {
                        xe.l("AnnotationIntrospector returned Class ", cls.getName(), "; expected Class<Converter>");
                        return null;
                    }
                    yg2Var.getClass();
                    if (n50.f(cls, yg2Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS)) != null) {
                        st4.n();
                        return null;
                    }
                }
            }
            return tmVar.M(this, nj4VarA0, ulVarG, z);
        } catch (a62 e) {
            C(ulVarG, e.c(), new Object[0]);
            throw null;
        }
    }

    public final DateFormat d() {
        DateFormat dateFormat = this.z0;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.b.f.X.clone();
        this.z0 = dateFormat2;
        return dateFormat2;
    }

    public final nj4 e(nj4 nj4Var, Class cls) {
        return nj4Var.g0(cls) ? nj4Var : this.b.f.b.g(nj4Var, cls, true);
    }

    public final void f(Object obj) {
        if (!(obj instanceof Class)) {
            xe.l("AnnotationIntrospector returned Converter definition of type ", obj.getClass().getName(), "; expected type Converter or Class<Converter> instead");
            return;
        }
        Class cls = (Class) obj;
        if (cls == ke0.class || n50.o(cls)) {
            return;
        }
        if (!le0.class.isAssignableFrom(cls)) {
            xe.l("AnnotationIntrospector returned Class ", cls.getName(), "; expected Class<Converter>");
            return;
        }
        bt3 bt3Var = this.b;
        bt3Var.getClass();
        if (n50.f(cls, bt3Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS)) == null) {
            return;
        }
        st4.n();
    }

    public final void g(String str, Object obj, i52 i52Var) {
        i52Var.Q(str);
        if (obj != null) {
            o(obj.getClass()).e(obj, i52Var, this);
        } else if (this.A0) {
            i52Var.U();
        } else {
            this.Y.e(null, i52Var, this);
        }
    }

    public final void h(i52 i52Var) {
        if (this.A0) {
            i52Var.U();
        } else {
            this.Y.e(null, i52Var, this);
        }
    }

    public final b72 i(nj4 nj4Var, nm nmVar) {
        b72 b72VarA = this.y0.a(nj4Var);
        return (b72VarA == null && (b72VarA = this.z.Q(nj4Var)) == null && (b72VarA = a(nj4Var)) == null) ? t(nj4Var.L0) : v(b72VarA, nmVar);
    }

    public final b72 j(Class cls, nm nmVar) {
        b72 b72VarB = this.y0.b(cls);
        if (b72VarB == null) {
            v62 v62Var = this.z;
            b72 b72VarR = v62Var.R(cls);
            if (b72VarR == null) {
                b72VarB = v62Var.Q(this.b.c(cls));
                if (b72VarB == null && (b72VarB = b(cls)) == null) {
                    return t(cls);
                }
            } else {
                b72VarB = b72VarR;
            }
        }
        return v(b72VarB, nmVar);
    }

    public final b72 k(nj4 nj4Var, nm nmVar) {
        b72 b72VarJ = this.f.j(this, nj4Var);
        if (b72VarJ instanceof rm) {
            ((rm) b72VarJ).t(this);
        }
        return v(b72VarJ, nmVar);
    }

    public abstract cy4 l(Object obj, m83 m83Var);

    public final b72 m(nj4 nj4Var, nm nmVar) {
        b72 b72VarA = this.y0.a(nj4Var);
        return (b72VarA == null && (b72VarA = this.z.Q(nj4Var)) == null && (b72VarA = a(nj4Var)) == null) ? t(nj4Var.L0) : u(b72VarA, nmVar);
    }

    public final b72 n(Class cls, nm nmVar) {
        b72 b72VarB = this.y0.b(cls);
        if (b72VarB == null) {
            v62 v62Var = this.z;
            b72 b72VarR = v62Var.R(cls);
            if (b72VarR == null) {
                b72VarB = v62Var.Q(this.b.c(cls));
                if (b72VarB == null && (b72VarB = b(cls)) == null) {
                    return t(cls);
                }
            } else {
                b72VarB = b72VarR;
            }
        }
        return u(b72VarB, nmVar);
    }

    public final b72 o(Class cls) {
        b72 b72Var;
        b72 b72Var2;
        xd3 xd3Var = this.y0;
        wt2 wt2Var = xd3Var.a[xd3Var.b & (cls.getName().hashCode() + 1)];
        if (wt2Var == null) {
            b72Var = null;
        } else if (((Class) wt2Var.e) != cls || !wt2Var.c) {
            while (true) {
                wt2Var = (wt2) wt2Var.d;
                if (wt2Var == null) {
                    break;
                }
                if (((Class) wt2Var.e) == cls && wt2Var.c) {
                    b72Var = (b72) wt2Var.a;
                    break;
                }
            }
        } else {
            b72Var = (b72) wt2Var.a;
        }
        if (b72Var != null) {
            return b72Var;
        }
        v62 v62Var = this.z;
        synchronized (v62Var) {
            b72Var2 = (b72) ((i53) ((o82) v62Var.f).b).get(new uj4(cls, true));
        }
        if (b72Var2 != null) {
            return b72Var2;
        }
        b72 b72VarQ = q(cls, null);
        vf2 vf2Var = this.f;
        bt3 bt3Var = this.b;
        ak4 ak4VarK = vf2Var.k(bt3Var, bt3Var.c(cls));
        if (ak4VarK != null) {
            b72VarQ = new ck4(ak4VarK.g(null), b72VarQ);
        }
        this.z.p(cls, b72VarQ);
        return b72VarQ;
    }

    public final b72 p(nj4 nj4Var, nm nmVar) throws a62 {
        if (nj4Var == null) {
            throw new a62(((hm0) this).F0, "Null passed for `valueType` of `findValueSerializer()`", null);
        }
        b72 b72VarA = this.y0.a(nj4Var);
        return (b72VarA == null && (b72VarA = this.z.Q(nj4Var)) == null && (b72VarA = a(nj4Var)) == null) ? t(nj4Var.L0) : v(b72VarA, nmVar);
    }

    public final b72 q(Class cls, nm nmVar) {
        b72 b72VarB = this.y0.b(cls);
        if (b72VarB == null) {
            v62 v62Var = this.z;
            b72 b72VarR = v62Var.R(cls);
            if (b72VarR == null) {
                b72VarB = v62Var.Q(this.b.c(cls));
                if (b72VarB == null && (b72VarB = b(cls)) == null) {
                    return t(cls);
                }
            } else {
                b72VarB = b72VarR;
            }
        }
        return v(b72VarB, nmVar);
    }

    public final Object r(Object obj) {
        Object obj2;
        HashMap map = ((zd0) this.A).B0;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return Collections.EMPTY_MAP.get(obj);
        }
        if (obj2 == zd0.D0) {
            return null;
        }
        return obj2;
    }

    public final rj4 s() {
        return this.b.f.b;
    }

    public final b72 t(Class cls) {
        return cls == Object.class ? this.X : new fm4(0, 8, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b72 u(b72 b72Var, nm nmVar) {
        return (b72Var == 0 || !(b72Var instanceof ee0)) ? b72Var : ((ee0) b72Var).a(this, nmVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b72 v(b72 b72Var, nm nmVar) {
        return (b72Var == 0 || !(b72Var instanceof ee0)) ? b72Var : ((ee0) b72Var).a(this, nmVar);
    }

    public abstract Object w(Class cls);

    public abstract boolean x(Object obj);

    public final m83 y(vt2 vt2Var) {
        Class cls = vt2Var.b;
        bt3 bt3Var = this.b;
        bt3Var.getClass();
        tt2 tt2Var = (tt2) n50.f(cls, bt3Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS));
        Class cls2 = vt2Var.d;
        m83 m83Var = (m83) tt2Var;
        return cls2 == m83Var.b ? m83Var : new m83(cls2, m83Var.f);
    }

    public final Object z(Class cls, String str) {
        if (cls != null) {
            s().b(null, cls, rj4.A);
        }
        A(str);
        throw null;
    }

    public gt3() {
        this.X = C0;
        this.Y = zs2.A;
        this.Z = B0;
        this.b = null;
        this.f = null;
        this.z = new v62(25);
        this.y0 = null;
        this.A = null;
        this.A0 = true;
    }
}
