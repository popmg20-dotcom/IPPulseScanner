package defpackage;

import j$.util.stream.BaseStream;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

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
    */
    public final nj4 c(ed4 ed4Var, Class cls, qj4 qj4Var) {
        Object obj;
        ed4 ed4Var2;
        ed4 ed4Var3;
        nj4 nj4VarB;
        nj4[] nj4VarArrD;
        nj4[] nj4VarArr;
        nj4 nj4VarL0;
        nj4 nj4Var;
        qj4 qj4Var2;
        nj4 nj4Var2;
        Class cls2;
        qj4 qj4Var3;
        Class cls3;
        qj4 qj4Var4;
        nj4 nj4Var3;
        oj4 oj4Var;
        Class cls4 = cls;
        i53 i53Var = (i53) this.b.b;
        jx3 jx3VarA = a(cls4);
        if (jx3VarA != null) {
            return jx3VarA;
        }
        int i = 0;
        if (qj4Var == null || qj4Var.f()) {
            obj = cls4;
        } else {
            nj4[] nj4VarArr2 = qj4Var.f;
            int length = nj4VarArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    oj4Var = new oj4(cls4, nj4VarArr2, qj4Var.A);
                    break;
                }
                if (nj4VarArr2[i2] instanceof dx1) {
                    oj4Var = null;
                    break;
                }
                i2++;
            }
            obj = oj4Var;
        }
        nj4 nj4Var4 = obj == null ? null : (nj4) i53Var.get(obj);
        if (nj4Var4 != null) {
            return nj4Var4;
        }
        if (ed4Var == null) {
            ed4Var3 = new ed4((ed4) null, cls4);
        } else {
            if (((Class) ed4Var.A) != cls4) {
                Object obj2 = ed4Var.z;
                while (true) {
                    ed4 ed4Var4 = (ed4) obj2;
                    if (ed4Var4 == null) {
                        ed4Var2 = null;
                        break;
                    }
                    if (((Class) ed4Var4.A) == cls4) {
                        ed4Var2 = ed4Var4;
                        break;
                    }
                    obj2 = ed4Var4.z;
                }
            } else {
                ed4Var2 = ed4Var;
            }
            if (ed4Var2 != null) {
                xj3 xj3Var = new xj3(cls, A, null, null, 0, null, null, false);
                ArrayList arrayList = (ArrayList) ed4Var2.f;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    ed4Var2.f = arrayList;
                }
                arrayList.add(xj3Var);
                return xj3Var;
            }
            ed4Var3 = new ed4(ed4Var, cls4);
        }
        if (cls4.isArray()) {
            nj4 nj4VarB2 = b(ed4Var3, cls4.getComponentType(), qj4Var);
            int i3 = ne.W0;
            nj4VarL0 = new ne(nj4VarB2, qj4Var, Array.newInstance((Class<?>) nj4VarB2.L0, 0), null, null, false);
            nj4Var2 = null;
        } else {
            if (cls4.isInterface()) {
                nj4VarArrD = d(ed4Var3, cls4, qj4Var);
                nj4VarB = null;
            } else {
                Annotation[] annotationArr = n50.a;
                Type genericSuperclass = cls4.getGenericSuperclass();
                nj4VarB = genericSuperclass == null ? null : b(ed4Var3, genericSuperclass, qj4Var);
                nj4VarArrD = d(ed4Var3, cls4, qj4Var);
            }
            nj4 nj4Var5 = I0;
            if (cls4 == Properties.class) {
                nj4VarArr = nj4VarArrD;
                nj4Var = nj4VarB;
                nj4Var2 = null;
                cls2 = Properties.class;
                nj4VarL0 = new wg2(cls4, qj4Var, nj4Var, nj4VarArr, nj4Var5, nj4Var5, null, null, false);
                cls4 = cls4;
                qj4Var2 = qj4Var;
            } else {
                nj4 nj4Var6 = nj4Var4;
                nj4VarArr = nj4VarArrD;
                nj4VarL0 = nj4Var6;
                nj4Var = nj4VarB;
                qj4Var2 = qj4Var;
                nj4Var2 = null;
                cls2 = Properties.class;
                if (nj4Var != null) {
                    nj4VarL0 = nj4Var.l0(cls4, qj4Var2, nj4Var, nj4VarArr);
                }
            }
            if (nj4VarL0 == null) {
                qj4 qj4Var5 = qj4Var2 == null ? A : qj4Var2;
                nj4 nj4Var7 = J0;
                if (cls4 == Map.class) {
                    if (cls4 == cls2) {
                        qj4Var4 = qj4Var5;
                    } else {
                        List listE = qj4Var5.e();
                        int size = listE.size();
                        if (size == 0) {
                            qj4Var4 = qj4Var5;
                            nj4Var5 = nj4Var7;
                        } else {
                            if (size != 2) {
                                throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", n50.t(cls4), Integer.valueOf(size), size == 1 ? "" : "s", qj4Var5));
                            }
                            nj4 nj4Var8 = (nj4) listE.get(0);
                            nj4Var3 = (nj4) listE.get(1);
                            nj4Var5 = nj4Var8;
                            qj4Var4 = qj4Var5;
                            qj4Var3 = qj4Var2;
                            cls3 = cls;
                            nj4VarL0 = new wg2(cls3, qj4Var4, nj4Var, nj4VarArr, nj4Var5, nj4Var3, null, null, false);
                        }
                    }
                    nj4Var3 = nj4Var5;
                    qj4Var3 = qj4Var2;
                    cls3 = cls;
                    nj4VarL0 = new wg2(cls3, qj4Var4, nj4Var, nj4VarArr, nj4Var5, nj4Var3, null, null, false);
                } else {
                    qj4Var3 = qj4Var2;
                    cls3 = cls4;
                    qj4 qj4Var6 = qj4Var5;
                    if (cls3 == Collection.class) {
                        List listE2 = qj4Var6.e();
                        if (!listE2.isEmpty()) {
                            if (listE2.size() != 1) {
                                xe.r("Strange Collection type ", cls3.getName(), ": cannot determine type parameters");
                                return nj4Var2;
                            }
                            nj4Var7 = (nj4) listE2.get(0);
                        }
                        nj4VarL0 = new a70(cls3, qj4Var6, nj4Var, nj4VarArr, nj4Var7, null, null, false);
                    } else if (cls3 == AtomicReference.class) {
                        List listE3 = qj4Var6.e();
                        if (!listE3.isEmpty()) {
                            if (listE3.size() != 1) {
                                xe.r("Strange Reference type ", cls3.getName(), ": cannot determine type parameters");
                                return nj4Var2;
                            }
                            nj4Var7 = (nj4) listE3.get(0);
                        }
                        nj4VarL0 = new ch3(cls3, qj4Var6, nj4Var, nj4VarArr, nj4Var7, null, null, null, false);
                    } else if (cls3 == Iterator.class || cls3 == Stream.class) {
                        List listE4 = qj4Var6.e();
                        if (!listE4.isEmpty()) {
                            if (listE4.size() != 1) {
                                xe.r("Strange Iteration type ", cls.getName(), ": cannot determine type parameters");
                                return nj4Var2;
                            }
                            nj4Var7 = (nj4) listE4.get(0);
                        }
                        cls3 = cls;
                        nj4VarL0 = new l22(cls3, qj4Var6, nj4Var, nj4VarArr, nj4Var7, null, null, false);
                    } else if (!BaseStream.class.isAssignableFrom(cls3)) {
                        cls3 = cls;
                        nj4VarL0 = nj4Var2;
                    } else if (DoubleStream.class.isAssignableFrom(cls3)) {
                        nj4VarL0 = new l22(cls3, qj4Var6, nj4Var, nj4VarArr, F0, null, null, false);
                    } else if (IntStream.class.isAssignableFrom(cls3)) {
                        nj4VarL0 = new l22(cls3, qj4Var6, nj4Var, nj4VarArr, G0, null, null, false);
                    } else if (LongStream.class.isAssignableFrom(cls3)) {
                        nj4VarL0 = new l22(cls3, qj4Var6, nj4Var, nj4VarArr, H0, null, null, false);
                        cls3 = cls;
                    }
                }
                if (nj4VarL0 == null) {
                    int length2 = nj4VarArr.length;
                    while (true) {
                        if (i >= length2) {
                            nj4VarL0 = nj4Var2;
                            break;
                        }
                        nj4 nj4VarL02 = nj4VarArr[i].l0(cls3, qj4Var3, nj4Var, nj4VarArr);
                        if (nj4VarL02 != null) {
                            nj4VarL0 = nj4VarL02;
                            break;
                        }
                        i++;
                    }
                    if (nj4VarL0 == null) {
                        nj4VarL0 = new jx3(cls3, qj4Var3, nj4Var, nj4VarArr);
                    }
                }
            }
        }
        ArrayList<xj3> arrayList2 = (ArrayList) ed4Var3.f;
        if (arrayList2 != null) {
            for (xj3 xj3Var2 : arrayList2) {
                if (xj3Var2.U0 != null) {
                    s53.m("Trying to re-set self reference; old value = ", xj3Var2.U0, ", new = ", nj4VarL0);
                    return nj4Var2;
                }
                xj3Var2.U0 = nj4VarL0;
            }
        }
        if (obj != null && !nj4VarL0.f0()) {
            i53Var.f(obj, nj4VarL0, true);
        }
        return nj4VarL0;
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
    */
    public final nj4 g(nj4 nj4Var, Class cls, boolean z2) {
        int length;
        jx3 jx3Var;
        nj4 nj4Var2;
        int i;
        Object obj;
        nj4 nj4VarC;
        Class cls2;
        Class cls3 = nj4Var.L0;
        if (cls3 != cls) {
            qj4 qj4Var = A;
            nj4 nj4Var3 = null;
            if (cls3 == Object.class) {
                nj4VarC = c(null, cls, qj4Var);
            } else {
                if (!cls3.isAssignableFrom(cls)) {
                    xe.k(fw.u("Class ", n50.t(cls), " not subtype of ", n50.m(nj4Var)));
                    return null;
                }
                if (nj4Var.h0()) {
                    if (nj4Var instanceof wg2) {
                        if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                            wg2 wg2Var = (wg2) nj4Var;
                            nj4VarC = c(null, cls, qj4.b(cls, wg2Var.U0, wg2Var.V0));
                        }
                    } else if (nj4Var instanceof a70) {
                        if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                            nj4VarC = c(null, cls, qj4.a(((a70) nj4Var).U0, cls));
                        }
                    }
                } else if (nj4Var.X().f() || (length = cls.getTypeParameters().length) == 0) {
                    nj4VarC = c(null, cls, qj4Var);
                } else {
                    g13[] g13VarArr = new g13[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        g13VarArr[i2] = new g13(i2);
                    }
                    nj4 nj4VarW = c(null, cls, qj4.c(cls, g13VarArr)).W(cls3);
                    if (nj4VarW == null) {
                        xe.k(fw.u("Internal error: unable to locate supertype (", cls3.getName(), ") from resolved subtype ", cls.getName()));
                        return null;
                    }
                    List listE = nj4Var.X().e();
                    List listE2 = nj4VarW.X().e();
                    int size = listE2.size();
                    int size2 = listE.size();
                    int i3 = 0;
                    while (true) {
                        jx3Var = J0;
                        if (i3 >= size2) {
                            nj4Var2 = nj4Var3;
                            i = 0;
                            obj = nj4Var2;
                            break;
                        }
                        nj4 nj4Var4 = (nj4) listE.get(i3);
                        nj4 nj4Var5 = i3 < size ? (nj4) listE2.get(i3) : jx3Var;
                        if (!e(nj4Var4, nj4Var5)) {
                            boolean zG0 = nj4Var4.g0(Object.class);
                            i = 0;
                            Class cls4 = nj4Var4.L0;
                            if (!zG0) {
                                nj4Var2 = nj4Var3;
                                if ((i3 != 0 || !(nj4Var instanceof wg2) || !nj4Var5.g0(Object.class)) && (!cls4.isInterface() || (cls4 != (cls2 = nj4Var5.L0) && !cls4.isAssignableFrom(cls2)))) {
                                    break;
                                }
                            } else {
                                nj4Var2 = nj4Var3;
                            }
                        } else {
                            nj4Var2 = nj4Var3;
                        }
                        i3++;
                        nj4Var3 = nj4Var2;
                    }
                    if (obj != null && !z2) {
                        a71.i("Failed to specialize base type ", nj4Var.V(), " as ", cls.getName(), ", problem: ", obj);
                        return nj4Var2;
                    }
                    nj4[] nj4VarArr = new nj4[length];
                    for (int i4 = i; i4 < length; i4++) {
                        nj4 nj4Var6 = g13VarArr[i4].V0;
                        if (nj4Var6 == null) {
                            nj4Var6 = jx3Var;
                        }
                        nj4VarArr[i4] = nj4Var6;
                    }
                    nj4VarC = c(nj4Var2, cls, qj4.c(cls, nj4VarArr));
                }
            }
            return nj4VarC.p0(nj4Var);
        }
        return nj4Var;
    }
}
