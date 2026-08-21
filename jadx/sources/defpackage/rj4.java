package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rj4 implements Serializable {
    public static final Class A0;
    public static final Class B0;
    public static final Class C0;
    public static final Class D0;
    public static final jx3 E0;
    public static final jx3 F0;
    public static final jx3 G0;
    public static final jx3 H0;
    public static final jx3 I0;
    public static final jx3 J0;
    public static final jx3 K0;
    public static final jx3 L0;
    public static final jx3 M0;
    public final o82 b = new o82(16, 200);
    public static final nj4[] f = new nj4[0];
    public static final rj4 z = new rj4();
    public static final qj4 A = qj4.Z;
    public static final Class X = String.class;
    public static final Class Y = Object.class;
    public static final Class Z = Comparable.class;
    public static final Class y0 = Enum.class;
    public static final Class z0 = d62.class;

    static {
        Class cls = Boolean.TYPE;
        A0 = cls;
        Class cls2 = Double.TYPE;
        B0 = cls2;
        Class cls3 = Integer.TYPE;
        C0 = cls3;
        Class cls4 = Long.TYPE;
        D0 = cls4;
        E0 = new jx3(cls);
        F0 = new jx3(cls2);
        G0 = new jx3(cls3);
        H0 = new jx3(cls4);
        I0 = new jx3(String.class);
        J0 = new jx3(Object.class);
        K0 = new jx3(Comparable.class);
        L0 = new jx3(Enum.class);
        M0 = new jx3(d62.class);
    }

    public static jx3 a(Class cls) {
        if (!cls.isPrimitive()) {
            if (cls == X) {
                return I0;
            }
            if (cls == Y) {
                return J0;
            }
            if (cls == z0) {
                return M0;
            }
            return null;
        }
        if (cls == A0) {
            return E0;
        }
        if (cls == C0) {
            return G0;
        }
        if (cls == D0) {
            return H0;
        }
        if (cls == B0) {
            return F0;
        }
        return null;
    }

    public static boolean e(nj4 nj4Var, nj4 nj4Var2) {
        if (nj4Var2 instanceof g13) {
            ((g13) nj4Var2).V0 = nj4Var;
            return true;
        }
        if (nj4Var.L0 == nj4Var2.L0) {
            List listE = nj4Var.X().e();
            List listE2 = nj4Var2.X().e();
            int size = listE.size();
            for (int i = 0; i < size; i++) {
                if (e((nj4) listE.get(i), (nj4) listE2.get(i))) {
                }
            }
            return true;
        }
        return false;
    }

    public static nj4 f(nj4 nj4Var, Class cls) {
        Class cls2 = nj4Var.L0;
        if (cls2 == cls) {
            return nj4Var;
        }
        nj4 nj4VarW = nj4Var.W(cls);
        if (nj4VarW == null) {
            nj4VarW = null;
            if (!cls.isAssignableFrom(cls2)) {
                zo2.p("Class %s not a super-type of %s", new Object[]{cls.getName(), nj4Var});
                return null;
            }
            zo2.p("Internal error: class %s not included as super-type for %s", new Object[]{cls.getName(), nj4Var});
        }
        return nj4VarW;
    }

    public static nj4[] h(nj4 nj4Var, Class cls) {
        nj4 nj4VarW = nj4Var.W(cls);
        return nj4VarW == null ? f : nj4VarW.X().f;
    }

    public final nj4 b(ed4 ed4Var, Type type, qj4 qj4Var) {
        Type[] bounds;
        nj4 nj4Var;
        qj4 qj4VarC;
        if (type instanceof Class) {
            return c(ed4Var, (Class) type, A);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            if (cls == y0) {
                return L0;
            }
            if (cls == Z) {
                return K0;
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
            if (length == 0) {
                qj4VarC = A;
            } else {
                nj4[] nj4VarArr = new nj4[length];
                for (int i = 0; i < length; i++) {
                    nj4VarArr[i] = b(ed4Var, actualTypeArguments[i], qj4Var);
                }
                qj4VarC = qj4.c(cls, nj4VarArr);
            }
            return c(ed4Var, cls, qj4VarC);
        }
        if (type instanceof nj4) {
            return (nj4) type;
        }
        if (type instanceof GenericArrayType) {
            nj4 nj4VarB = b(ed4Var, ((GenericArrayType) type).getGenericComponentType(), qj4Var);
            int i2 = ne.W0;
            return new ne(nj4VarB, qj4Var, Array.newInstance((Class<?>) nj4VarB.L0, 0), null, null, false);
        }
        if (!(type instanceof TypeVariable)) {
            if (type instanceof WildcardType) {
                return b(ed4Var, ((WildcardType) type).getUpperBounds()[0], qj4Var);
            }
            StringBuilder sb = new StringBuilder("Unrecognized Type: ");
            sb.append(type == null ? "[null]" : type.toString());
            throw new IllegalArgumentException(sb.toString());
        }
        TypeVariable typeVariable = (TypeVariable) type;
        String name = typeVariable.getName();
        nj4 nj4Var2 = null;
        if (qj4Var == null) {
            xe.k(ha0.o("Null `bindings` passed (type variable \"", name, "\")"));
            return null;
        }
        String[] strArr = qj4Var.b;
        int length2 = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                break;
            }
            if (name.equals(strArr[i3])) {
                nj4Var2 = qj4Var.f[i3];
                if ((nj4Var2 instanceof xj3) && (nj4Var = ((xj3) nj4Var2).U0) != null) {
                    nj4Var2 = nj4Var;
                }
            } else {
                i3++;
            }
        }
        if (nj4Var2 != null) {
            return nj4Var2;
        }
        String[] strArr2 = qj4Var.z;
        if (strArr2 != null) {
            int length3 = strArr2.length;
            do {
                length3--;
                if (length3 >= 0) {
                }
            } while (!name.equals(strArr2[length3]));
            return J0;
        }
        String[] strArr3 = qj4Var.z;
        int length4 = strArr3 == null ? 0 : strArr3.length;
        String[] strArr4 = length4 == 0 ? new String[1] : (String[]) Arrays.copyOf(strArr3, length4 + 1);
        strArr4[length4] = name;
        qj4 qj4Var2 = new qj4(qj4Var.b, qj4Var.f, strArr4);
        synchronized (typeVariable) {
            bounds = typeVariable.getBounds();
        }
        return b(ed4Var, bounds[0], qj4Var2);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.nj4 c(defpackage.ed4 r20, java.lang.Class r21, defpackage.qj4 r22) {
        /*
            Method dump skipped, instruction units count: 687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rj4.c(ed4, java.lang.Class, qj4):nj4");
    }

    public final nj4[] d(ed4 ed4Var, Class cls, qj4 qj4Var) {
        Annotation[] annotationArr = n50.a;
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return f;
        }
        int length = genericInterfaces.length;
        nj4[] nj4VarArr = new nj4[length];
        for (int i = 0; i < length; i++) {
            nj4VarArr[i] = b(ed4Var, genericInterfaces[i], qj4Var);
        }
        return nj4VarArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
    
        if (r3 == java.util.EnumSet.class) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x010c, code lost:
    
        r23 = java.lang.String.format("Type parameter #%d/%d differs; can not specialize %s with %s", java.lang.Integer.valueOf(r12 + 1), java.lang.Integer.valueOf(r11), r14.V(), r15.V());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.nj4 g(defpackage.nj4 r25, java.lang.Class r26, boolean r27) {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rj4.g(nj4, java.lang.Class, boolean):nj4");
    }
}
