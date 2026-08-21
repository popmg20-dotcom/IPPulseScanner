package defpackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hm0 extends gt3 implements Serializable {
    public transient AbstractMap D0;
    public transient ArrayList E0;
    public transient dy4 F0;

    public static IOException E(dy4 dy4Var, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String strG = n50.g(exc);
        if (strG == null) {
            strG = "[no message for " + exc.getClass().getName() + "]";
        }
        return new a62(dy4Var, strG, exc);
    }

    @Override // defpackage.gt3
    public final b72 D(xb5 xb5Var, Object obj) throws o12 {
        b72 b72Var;
        if (obj instanceof b72) {
            b72Var = (b72) obj;
        } else {
            if (!(obj instanceof Class)) {
                xb5Var.x();
                A("AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
                throw null;
            }
            Class cls = (Class) obj;
            if (cls == a72.class || n50.o(cls)) {
                return null;
            }
            if (!b72.class.isAssignableFrom(cls)) {
                xb5Var.x();
                A("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
                throw null;
            }
            bt3 bt3Var = this.b;
            bt3Var.getClass();
            b72Var = (b72) n50.f(cls, bt3Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        if (b72Var instanceof rm) {
            ((rm) b72Var).t(this);
        }
        return b72Var;
    }

    public final void F(dy4 dy4Var, Object obj) throws IOException {
        this.F0 = dy4Var;
        Class<?> cls = obj.getClass();
        b72 b72VarO = o(cls);
        bt3 bt3Var = this.b;
        bt3Var.getClass();
        if (!bt3Var.h(dt3.WRAP_ROOT_VALUE)) {
            try {
                b72VarO.e(obj, dy4Var, this);
                return;
            } catch (Exception e) {
                throw E(dy4Var, e);
            }
        }
        o82 o82Var = bt3Var.Y;
        h50 h50Var = new h50();
        h50Var.f = cls;
        String name = cls.getName();
        h50Var.b = name;
        h50Var.z = name.hashCode();
        o82 o82Var2 = (o82) o82Var.b;
        p83 p83VarC = (p83) ((i53) o82Var2.b).get(h50Var);
        if (p83VarC == null) {
            nj4 nj4VarC = bt3Var.c(cls);
            ((wl) bt3Var.f.f).getClass();
            ul ulVarS = wl.S(bt3Var, nj4VarC);
            if (ulVarS == null) {
                ulVarS = ul.d(bt3Var, nj4VarC, x8.F(bt3Var, nj4VarC, bt3Var));
            }
            p83VarC = bt3Var.d().C((w8) ulVarS.f);
            if (p83VarC == null || p83VarC.b.isEmpty()) {
                p83VarC = p83.a(cls.getSimpleName());
            }
            ((i53) o82Var2.b).f(h50Var, p83VarC, false);
        }
        try {
            dy4Var.x0();
            String str = p83VarC.b;
            ft3 ft3Var = p83VarC.z;
            if (ft3Var == null) {
                ft3Var = bt3Var == null ? new ft3(str) : new ft3(str);
                p83VarC.z = ft3Var;
            }
            dy4Var.N(ft3Var);
            b72VarO.e(obj, dy4Var, this);
            dy4Var.M();
        } catch (Exception e2) {
            throw E(dy4Var, e2);
        }
    }

    @Override // defpackage.gt3
    public final cy4 l(Object obj, m83 m83Var) {
        tt2 tt2Var;
        tt2 tt2Var2;
        AbstractMap abstractMap = this.D0;
        if (abstractMap == null) {
            this.D0 = this.b.h(dt3.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap() : new IdentityHashMap();
        } else {
            cy4 cy4Var = (cy4) abstractMap.get(obj);
            if (cy4Var != null) {
                return cy4Var;
            }
        }
        ArrayList arrayList = this.E0;
        if (arrayList == null) {
            this.E0 = new ArrayList(8);
        } else {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                tt2Var = (tt2) this.E0.get(i);
                m83 m83Var2 = (m83) tt2Var;
                m83Var2.getClass();
                if (m83Var.b == m83Var2.b && m83Var.f == m83Var2.f) {
                    break;
                }
            }
        }
        tt2Var = null;
        if (tt2Var == null) {
            this.E0.add(m83Var);
            tt2Var2 = m83Var;
        } else {
            tt2Var2 = tt2Var;
        }
        cy4 cy4Var2 = new cy4(tt2Var2);
        this.D0.put(obj, cy4Var2);
        return cy4Var2;
    }

    @Override // defpackage.gt3
    public final Object w(Class cls) {
        if (cls == null) {
            return null;
        }
        bt3 bt3Var = this.b;
        bt3Var.getClass();
        return n50.f(cls, bt3Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS));
    }

    @Override // defpackage.gt3
    public final boolean x(Object obj) throws o12 {
        if (obj == null) {
            return true;
        }
        try {
            return obj.equals(null);
        } catch (Exception e) {
            String name = obj.getClass().getName();
            String name2 = e.getClass().getName();
            String strG = n50.g(e);
            StringBuilder sbE = fw.E("Problem determining whether filter of type '", name, "' should filter out `null` values: (", name2, ") ");
            sbE.append(strG);
            String string = sbE.toString();
            Class<?> cls = obj.getClass();
            dy4 dy4Var = this.F0;
            this.s().b(null, cls, rj4.A);
            o12 o12Var = new o12(dy4Var, string);
            o12Var.initCause(e);
            throw o12Var;
        }
    }
}
