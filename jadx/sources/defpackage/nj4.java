package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nj4 extends vo implements w62, Serializable, Type {
    public static final qj4 T0 = qj4.Z;
    public final Class L0;
    public final int M0;
    public final Object N0;
    public final Object O0;
    public final boolean P0;
    public final nj4 Q0;
    public final nj4[] R0;
    public final qj4 S0;

    public nj4(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr, int i, Object obj, Object obj2, boolean z) {
        this.L0 = cls;
        this.M0 = cls.hashCode() + (i * 31);
        this.N0 = obj;
        this.O0 = obj2;
        this.P0 = z;
        this.S0 = qj4Var == null ? T0 : qj4Var;
        this.Q0 = nj4Var;
        this.R0 = nj4VarArr;
    }

    public static void T(Class cls, StringBuilder sb, boolean z) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = name.charAt(i);
                if (cCharAt == '.') {
                    cCharAt = '/';
                }
                sb.append(cCharAt);
            }
            if (z) {
                sb.append(';');
                return;
            }
            return;
        }
        if (cls == Boolean.TYPE) {
            sb.append('Z');
            return;
        }
        if (cls == Byte.TYPE) {
            sb.append('B');
            return;
        }
        if (cls == Short.TYPE) {
            sb.append('S');
            return;
        }
        if (cls == Character.TYPE) {
            sb.append('C');
            return;
        }
        if (cls == Integer.TYPE) {
            sb.append('I');
            return;
        }
        if (cls == Long.TYPE) {
            sb.append('J');
            return;
        }
        if (cls == Float.TYPE) {
            sb.append('F');
            return;
        }
        if (cls == Double.TYPE) {
            sb.append('D');
        } else if (cls == Void.TYPE) {
            sb.append('V');
        } else {
            xe.q("Unrecognized primitive type: ".concat(cls.getName()));
        }
    }

    public final boolean U(int i) {
        return this.L0.getTypeParameters().length == i;
    }

    public String V() {
        return this.L0.getName();
    }

    public final nj4 W(Class cls) {
        nj4 nj4VarW;
        nj4[] nj4VarArr;
        if (cls == this.L0) {
            return this;
        }
        if (cls.isInterface() && (nj4VarArr = this.R0) != null) {
            for (nj4 nj4Var : nj4VarArr) {
                nj4 nj4VarW2 = nj4Var.W(cls);
                if (nj4VarW2 != null) {
                    return nj4VarW2;
                }
            }
        }
        nj4 nj4Var2 = this.Q0;
        if (nj4Var2 == null || (nj4VarW = nj4Var2.W(cls)) == null) {
            return null;
        }
        return nj4VarW;
    }

    public qj4 X() {
        return this.S0;
    }

    public nj4 Y() {
        return null;
    }

    public abstract StringBuilder Z(StringBuilder sb);

    public abstract StringBuilder a0(StringBuilder sb);

    public nj4 b0() {
        return null;
    }

    @Override // defpackage.vo
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public nj4 u() {
        return null;
    }

    public nj4 d0() {
        return this.Q0;
    }

    public boolean e0() {
        return this.S0.f.length > 0;
    }

    public abstract boolean equals(Object obj);

    public boolean f0() {
        return (this.O0 == null && this.N0 == null) ? false : true;
    }

    public final boolean g0(Class cls) {
        return this.L0 == cls;
    }

    public abstract boolean h0();

    public int hashCode() {
        return this.M0;
    }

    public final boolean i0() {
        Annotation[] annotationArr = n50.a;
        return Enum.class.isAssignableFrom(this.L0);
    }

    public final boolean j0() {
        return this.L0 == Object.class;
    }

    public final boolean k0(Class cls) {
        Class cls2 = this.L0;
        return cls2 == cls || cls.isAssignableFrom(cls2);
    }

    public abstract nj4 l0(Class cls, qj4 qj4Var, nj4 nj4Var, nj4[] nj4VarArr);

    public final String m0() {
        return V();
    }

    public abstract nj4 n0(nj4 nj4Var);

    public abstract nj4 o0(ak4 ak4Var);

    public nj4 p0(nj4 nj4Var) {
        Object obj = nj4Var.O0;
        nj4 nj4VarR0 = obj != this.O0 ? r0(obj) : this;
        Object obj2 = nj4Var.N0;
        return obj2 != this.N0 ? nj4VarR0.s0(obj2) : nj4VarR0;
    }

    public abstract nj4 q0();

    public abstract nj4 r0(Object obj);

    public abstract nj4 s0(Object obj);
}
