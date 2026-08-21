package defpackage;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r22 extends cu2 {
    public transient o82 b;
    public boolean f;
    public static final Class[] z = {z62.class, t72.class, f52.class, n72.class, q62.class, q72.class, t42.class, y52.class};
    public static final Class[] A = {x42.class, t72.class, f52.class, n72.class, q72.class, t42.class, y52.class, b62.class};

    static {
        try {
            int i = z22.a;
        } catch (Throwable th) {
            v02.A(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static n34 d0(yg2 yg2Var, xb5 xb5Var) {
        n34 n34Var;
        i72 i72Var;
        j72 j72Var;
        Class cls;
        j72 j72Var2;
        n72 n72Var = (n72) xb5Var.m(n72.class);
        sj4 sj4Var = null;
        m72 m72VarA = n72Var == null ? null : m72.a(n72Var.use(), n72Var.include(), n72Var.property(), n72Var.defaultImpl(), n72Var.visible(), n72Var.requireTypeIdForSubtypes().a());
        p72 p72Var = (p72) xb5Var.m(p72.class);
        if (p72Var != null) {
            if (m72VarA != null) {
                Class clsValue = p72Var.value();
                yg2Var.getClass();
                n34Var = (n34) n50.f(clsValue, yg2Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS));
                i72Var = (i72) xb5Var.m(i72.class);
                if (i72Var != null) {
                    Class clsValue2 = i72Var.value();
                    yg2Var.getClass();
                    sj4Var = (sj4) n50.f(clsValue2, yg2Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS));
                }
                j72Var = m72VarA.f;
                if (j72Var == j72.A && (xb5Var instanceof w8) && (j72Var2 = j72.b) != j72Var) {
                    m72VarA = new m72(m72VarA.b, j72Var2, m72VarA.z, m72VarA.A, m72VarA.X, m72VarA.Y);
                }
                cls = m72VarA.A;
                if (cls != null && cls != l72.class) {
                    cls.isAnnotation();
                }
                n34Var.d = sj4Var;
                n34Var.b(m72VarA);
                return n34Var;
            }
            return null;
        }
        if (m72VarA != null) {
            k72 k72Var = m72VarA.b;
            k72 k72Var2 = k72.NONE;
            if (k72Var == k72Var2) {
                m72 m72VarA2 = m72.a(k72Var2, null, null, null, false, null);
                n34 n34Var2 = new n34();
                n34Var2.b(m72VarA2);
                return n34Var2;
            }
            n34Var = new n34();
            n34Var.b(m72VarA);
            i72Var = (i72) xb5Var.m(i72.class);
            if (i72Var != null) {
            }
            j72Var = m72VarA.f;
            if (j72Var == j72.A) {
                m72VarA = new m72(m72VarA.b, j72Var2, m72VarA.z, m72VarA.A, m72VarA.X, m72VarA.Y);
            }
            cls = m72VarA.A;
            if (cls != null) {
                cls.isAnnotation();
            }
            n34Var.d = sj4Var;
            n34Var.b(m72VarA);
            return n34Var;
        }
        return null;
    }

    public static boolean e0(Class cls, Class cls2) {
        return cls.isPrimitive() ? cls == n50.u(cls2) : cls2.isPrimitive() && cls2 == n50.u(cls);
    }

    @Override // defpackage.cu2
    public final n34 A(yg2 yg2Var, c9 c9Var, nj4 nj4Var) {
        if (nj4Var.h0() || nj4Var.B()) {
            return null;
        }
        return d0(yg2Var, c9Var);
    }

    @Override // defpackage.cu2
    public final ue2 B(c9 c9Var) {
        y52 y52Var = (y52) c9Var.m(y52.class);
        if (y52Var != null) {
            y52Var.value();
            return new ue2(1, false);
        }
        t42 t42Var = (t42) c9Var.m(t42.class);
        if (t42Var == null) {
            return null;
        }
        t42Var.value();
        return new ue2(2, false);
    }

    @Override // defpackage.cu2
    public final p83 C(w8 w8Var) {
        t62 t62Var = (t62) w8Var.K0.get(t62.class);
        if (t62Var == null) {
            return null;
        }
        String strNamespace = t62Var.namespace();
        return p83.b(t62Var.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
    }

    @Override // defpackage.cu2
    public final Object D(c9 c9Var) {
        z62 z62Var = (z62) c9Var.m(z62.class);
        if (z62Var == null) {
            return null;
        }
        Class clsContentConverter = z62Var.contentConverter();
        if (clsContentConverter == null || n50.o(clsContentConverter)) {
            clsContentConverter = null;
        }
        if (clsContentConverter == null || clsContentConverter == ke0.class) {
            return null;
        }
        return clsContentConverter;
    }

    @Override // defpackage.cu2
    public final Object E(xb5 xb5Var) {
        z62 z62Var = (z62) xb5Var.m(z62.class);
        if (z62Var == null) {
            return null;
        }
        Class clsConverter = z62Var.converter();
        if (clsConverter == null || n50.o(clsConverter)) {
            clsConverter = null;
        }
        if (clsConverter == null || clsConverter == ke0.class) {
            return null;
        }
        return clsConverter;
    }

    @Override // defpackage.cu2
    public final String[] F(w8 w8Var) {
        p62 p62Var = (p62) w8Var.K0.get(p62.class);
        if (p62Var == null) {
            return null;
        }
        return p62Var.value();
    }

    @Override // defpackage.cu2
    public final Boolean G(xb5 xb5Var) {
        p62 p62Var = (p62) xb5Var.m(p62.class);
        if (p62Var == null || !p62Var.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // defpackage.cu2
    public final y62 H(xb5 xb5Var) {
        z62 z62Var = (z62) xb5Var.m(z62.class);
        if (z62Var == null) {
            return null;
        }
        return z62Var.typing();
    }

    @Override // defpackage.cu2
    public final Object I(xb5 xb5Var) {
        Class clsUsing;
        z62 z62Var = (z62) xb5Var.m(z62.class);
        if (z62Var != null && (clsUsing = z62Var.using()) != a72.class) {
            return clsUsing;
        }
        q62 q62Var = (q62) xb5Var.m(q62.class);
        if (q62Var == null || !q62Var.value()) {
            return null;
        }
        return new zs2(0, 5, xb5Var.u());
    }

    @Override // defpackage.cu2
    public final List J(xb5 xb5Var) {
        f72 f72Var = (f72) xb5Var.m(f72.class);
        List list = null;
        if (f72Var == null) {
            return null;
        }
        e72[] e72VarArrValue = f72Var.value();
        if (!f72Var.failOnRepeatedNames()) {
            ArrayList arrayList = new ArrayList(e72VarArrValue.length);
            for (e72 e72Var : e72VarArrValue) {
                arrayList.add(new uo2(e72Var.value(), e72Var.name()));
                for (String str : e72Var.names()) {
                    arrayList.add(new uo2(e72Var.value(), str));
                }
            }
            return arrayList;
        }
        String strQ = xb5Var.q();
        ArrayList arrayList2 = new ArrayList(e72VarArrValue.length);
        HashSet hashSet = new HashSet();
        int length = e72VarArrValue.length;
        int i = 0;
        while (i < length) {
            e72 e72Var2 = e72VarArrValue[i];
            String strName = e72Var2.name();
            if (!strName.isEmpty() && hashSet.contains(strName)) {
                xe.k(fw.v("Annotated type [", strQ, "] got repeated subtype name [", strName, "]"));
                return list;
            }
            hashSet.add(strName);
            arrayList2.add(new uo2(e72Var2.value(), strName));
            String[] strArrNames = e72Var2.names();
            int length2 = strArrNames.length;
            int i2 = 0;
            while (i2 < length2) {
                String str2 = strArrNames[i2];
                if (!str2.isEmpty() && hashSet.contains(str2)) {
                    xe.k(fw.v("Annotated type [", strQ, "] got repeated subtype name [", str2, "]"));
                    return list;
                }
                hashSet.add(str2);
                arrayList2.add(new uo2(e72Var2.value(), str2));
                i2++;
                list = null;
            }
            i++;
            list = null;
        }
        return arrayList2;
    }

    @Override // defpackage.cu2
    public final String K(w8 w8Var) {
        o72 o72Var = (o72) w8Var.K0.get(o72.class);
        if (o72Var == null) {
            return null;
        }
        return o72Var.value();
    }

    @Override // defpackage.cu2
    public final n34 L(bt3 bt3Var, w8 w8Var, nj4 nj4Var) {
        return d0(bt3Var, w8Var);
    }

    @Override // defpackage.cu2
    public final po2 M(c9 c9Var) {
        q72 q72Var = (q72) c9Var.m(q72.class);
        if (q72Var == null || !q72Var.enabled()) {
            return null;
        }
        String strPrefix = q72Var.prefix();
        String strSuffix = q72Var.suffix();
        boolean z2 = (strPrefix == null || strPrefix.isEmpty()) ? false : true;
        boolean z3 = (strSuffix == null || strSuffix.isEmpty()) ? false : true;
        return z2 ? z3 ? new lo2(strPrefix, strSuffix) : new mo2(strPrefix, 0) : z3 ? new mo2(strSuffix, 1) : po2.b;
    }

    @Override // defpackage.cu2
    public final Class[] N(xb5 xb5Var) {
        t72 t72Var = (t72) xb5Var.m(t72.class);
        if (t72Var == null) {
            return null;
        }
        return t72Var.value();
    }

    @Override // defpackage.cu2
    public final Boolean O(c9 c9Var) {
        l42 l42Var = (l42) c9Var.m(l42.class);
        if (l42Var == null) {
            return null;
        }
        return Boolean.valueOf(l42Var.enabled());
    }

    @Override // defpackage.cu2
    public final boolean P(d9 d9Var) {
        HashMap map;
        cp1 cp1Var = d9Var.C0;
        if (cp1Var == null || (map = (HashMap) cp1Var.f) == null) {
            return false;
        }
        return map.containsKey(l42.class);
    }

    @Override // defpackage.cu2
    public final Boolean Q(c9 c9Var) {
        m42 m42Var = (m42) c9Var.m(m42.class);
        if (m42Var == null) {
            return null;
        }
        return Boolean.valueOf(m42Var.enabled());
    }

    @Override // defpackage.cu2
    public final Boolean R(c9 c9Var) {
        x52 x52Var = (x52) c9Var.m(x52.class);
        if (x52Var == null) {
            return null;
        }
        return Boolean.valueOf(x52Var.value());
    }

    @Override // defpackage.cu2
    public final Boolean S(c9 c9Var) {
        r72 r72Var = (r72) c9Var.m(r72.class);
        if (r72Var == null) {
            return null;
        }
        return Boolean.valueOf(r72Var.value());
    }

    @Override // defpackage.cu2
    public final boolean T(d9 d9Var) {
        r72 r72Var = (r72) d9Var.m(r72.class);
        return r72Var != null && r72Var.value();
    }

    @Override // defpackage.cu2
    public final boolean U(c9 c9Var) {
        o52 o52Var = (o52) c9Var.m(o52.class);
        if (o52Var != null) {
            return o52Var.value();
        }
        return false;
    }

    @Override // defpackage.cu2
    public final Boolean V(c9 c9Var) {
        n62 n62Var = (n62) c9Var.m(n62.class);
        if (n62Var == null) {
            return null;
        }
        jw2 jw2VarIsRequired = n62Var.isRequired();
        return jw2VarIsRequired != jw2.f ? jw2VarIsRequired.a() : Boolean.valueOf(n62Var.required());
    }

    @Override // defpackage.cu2
    public final boolean W(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        String name = clsAnnotationType.getName();
        o82 o82Var = this.b;
        Boolean bool = (Boolean) ((i53) o82Var.b).get(name);
        if (bool == null) {
            Boolean boolValueOf = Boolean.valueOf(clsAnnotationType.getAnnotation(s22.class) != null);
            ((i53) o82Var.b).f(name, boolValueOf, true);
            bool = boolValueOf;
        }
        return bool.booleanValue();
    }

    @Override // defpackage.cu2
    public final Boolean X(w8 w8Var) {
        r52 r52Var = (r52) w8Var.K0.get(r52.class);
        if (r52Var == null) {
            return null;
        }
        return Boolean.valueOf(r52Var.value());
    }

    @Override // defpackage.cu2
    public final Boolean Z(c9 c9Var) {
        HashMap map;
        cp1 cp1Var = c9Var.C0;
        boolean zContainsKey = false;
        if (cp1Var != null && (map = (HashMap) cp1Var.f) != null) {
            zContainsKey = map.containsKey(h72.class);
        }
        return Boolean.valueOf(zContainsKey);
    }

    @Override // defpackage.cu2
    public final void a(yg2 yg2Var, w8 w8Var, ArrayList arrayList) {
        s52 s52Var;
        t52 t52Var;
        t52 t52Var2;
        o9 o9Var = w8Var.K0;
        Class cls = w8Var.C0;
        p42 p42Var = (p42) o9Var.get(p42.class);
        if (p42Var == null) {
            return;
        }
        boolean zPrepend = p42Var.prepend();
        n42[] n42VarArrAttrs = p42Var.attrs();
        int length = n42VarArrAttrs.length;
        nj4 nj4VarC = null;
        int i = 0;
        while (true) {
            s52Var = s52.X;
            if (i >= length) {
                break;
            }
            if (nj4VarC == null) {
                nj4VarC = yg2Var.c(Object.class);
            }
            n42 n42Var = n42VarArrAttrs[i];
            o83 o83Var = n42Var.required() ? o83.Y : o83.Z;
            String strValue = n42Var.value();
            String strPropName = n42Var.propName();
            String strPropNamespace = n42Var.propNamespace();
            p83 p83VarA = strPropName.isEmpty() ? p83.A : (strPropNamespace == null || strPropNamespace.isEmpty()) ? p83.a(strPropName) : p83.b(strPropName, strPropNamespace);
            if (p83VarA.b.isEmpty()) {
                p83VarA = p83.a(strValue);
            }
            p83 p83Var = p83VarA;
            cs4 cs4Var = new cs4(w8Var, cls, strValue, nj4VarC);
            s52 s52VarInclude = n42Var.include();
            int i2 = yw3.Y;
            if (s52VarInclude == null || s52VarInclude == s52Var) {
                t52Var2 = om.b;
            } else {
                t52 t52Var3 = t52.X;
                t52Var2 = s52VarInclude != s52Var ? new t52(s52VarInclude, null, null, null) : t52.X;
            }
            zf zfVar = new zf(strValue, new yw3(yg2Var.d(), cs4Var, p83Var, o83Var, t52Var2), w8Var.K0, nj4VarC);
            if (zPrepend) {
                arrayList.add(i, zfVar);
            } else {
                arrayList.add(zfVar);
            }
            i++;
        }
        o42[] o42VarArrProps = p42Var.props();
        if (o42VarArrProps.length > 0) {
            o42 o42Var = o42VarArrProps[0];
            o83 o83Var2 = o42Var.required() ? o83.Y : o83.Z;
            String strName = o42Var.name();
            String strNamespace = o42Var.namespace();
            p83 p83VarA2 = strName.isEmpty() ? p83.A : (strNamespace == null || strNamespace.isEmpty()) ? p83.a(strName) : p83.b(strName, strNamespace);
            cs4 cs4Var2 = new cs4(w8Var, cls, p83VarA2.b, yg2Var.c(o42Var.type()));
            s52 s52VarInclude2 = o42Var.include();
            int i3 = yw3.Y;
            if (s52VarInclude2 == null || s52VarInclude2 == s52Var) {
                t52Var = om.b;
            } else {
                t52 t52Var4 = t52.X;
                t52Var = s52VarInclude2 != s52Var ? new t52(s52VarInclude2, null, null, null) : t52.X;
            }
            new yw3(yg2Var.d(), cs4Var2, p83VarA2, o83Var2, t52Var);
            ((zf) n50.f(o42Var.value(), yg2Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS))).getClass();
            xe.q("Should not be called on this type");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00f2 A[PHI: r1
      0x00f2: PHI (r1v2 nj4) = (r1v1 nj4), (r1v1 nj4), (r1v16 nj4) binds: [B:32:0x009b, B:41:0x00b3, B:59:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // defpackage.cu2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final nj4 a0(yg2 yg2Var, xb5 xb5Var, nj4 nj4Var) throws a62 {
        Class<?> clsAs;
        char c;
        char c2;
        boolean z2;
        Class<?> clsContentAs;
        nj4 nj4VarQ0;
        Class<?> clsKeyAs;
        char c3;
        char c4;
        char c5;
        nj4 nj4VarQ02 = nj4Var;
        rj4 rj4Var = yg2Var.f.b;
        z62 z62Var = (z62) xb5Var.m(z62.class);
        if (z62Var == null || (clsAs = z62Var.as()) == null || n50.o(clsAs)) {
            clsAs = null;
        }
        if (clsAs != null) {
            if (nj4VarQ02.g0(clsAs)) {
                nj4VarQ02 = nj4VarQ02.q0();
            } else {
                Class<?> cls = nj4VarQ02.L0;
                try {
                    if (clsAs.isAssignableFrom(cls)) {
                        rj4Var.getClass();
                        nj4VarQ02 = rj4.f(nj4VarQ02, clsAs);
                    } else if (cls.isAssignableFrom(clsAs)) {
                        nj4VarQ02 = rj4Var.g(nj4VarQ02, clsAs, false);
                    } else {
                        if (!e0(cls, clsAs)) {
                            throw new a62(null, String.format("Cannot refine serialization type %s into %s; types not related", nj4VarQ02, clsAs.getName()));
                        }
                        nj4VarQ02 = nj4VarQ02.q0();
                    }
                } catch (IllegalArgumentException e) {
                    throw new a62(null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", nj4VarQ02, clsAs.getName(), xb5Var.q(), e.getMessage()), e);
                }
            }
        }
        nj4VarQ02.getClass();
        if (nj4VarQ02 instanceof wg2) {
            wg2 wg2Var = (wg2) nj4VarQ02;
            nj4 nj4Var2 = wg2Var.U0;
            if (z62Var == null || (clsKeyAs = z62Var.keyAs()) == null || n50.o(clsKeyAs)) {
                clsKeyAs = null;
            }
            if (clsKeyAs == null) {
                c = 3;
                c2 = 1;
                z2 = false;
            } else {
                if (nj4Var2.g0(clsKeyAs)) {
                    nj4VarQ02 = nj4Var2.q0();
                } else {
                    Class<?> cls2 = nj4Var2.L0;
                    try {
                        if (clsKeyAs.isAssignableFrom(cls2)) {
                            rj4Var.getClass();
                            nj4VarQ02 = rj4.f(nj4Var2, clsKeyAs);
                        } else if (cls2.isAssignableFrom(clsKeyAs)) {
                            nj4VarQ02 = rj4Var.g(nj4Var2, clsKeyAs, false);
                        } else {
                            if (!e0(cls2, clsKeyAs)) {
                                c3 = 3;
                                c4 = 1;
                                c5 = 0;
                                try {
                                    throw new a62(null, String.format("Cannot refine serialization key type %s into %s; types not related", nj4Var2, clsKeyAs.getName()));
                                } catch (IllegalArgumentException e2) {
                                    e = e2;
                                    String name = clsKeyAs.getName();
                                    String strQ = xb5Var.q();
                                    String message = e.getMessage();
                                    Object[] objArr = new Object[4];
                                    objArr[c5] = nj4VarQ02;
                                    objArr[c4] = name;
                                    objArr[2] = strQ;
                                    objArr[c3] = message;
                                    throw new a62(null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", objArr), e);
                                }
                            }
                            nj4VarQ02 = nj4Var2.q0();
                        }
                    } catch (IllegalArgumentException e3) {
                        e = e3;
                        c3 = 3;
                        c4 = 1;
                        c5 = 0;
                    }
                }
                if (nj4VarQ02 == nj4Var2) {
                    nj4VarQ02 = wg2Var;
                    c = 3;
                    c2 = 1;
                    z2 = false;
                } else {
                    c = 3;
                    c2 = 1;
                    z2 = false;
                    nj4VarQ02 = new wg2(wg2Var.L0, wg2Var.S0, wg2Var.Q0, wg2Var.R0, nj4VarQ02, wg2Var.V0, wg2Var.N0, wg2Var.O0, wg2Var.P0);
                }
            }
        }
        nj4 nj4VarY = nj4VarQ02.Y();
        if (nj4VarY != null) {
            if (z62Var == null || (clsContentAs = z62Var.contentAs()) == null || n50.o(clsContentAs)) {
                clsContentAs = null;
            }
            if (clsContentAs != null) {
                if (nj4VarY.g0(clsContentAs)) {
                    nj4VarQ0 = nj4VarY.q0();
                } else {
                    Class<?> cls3 = nj4VarY.L0;
                    try {
                        if (clsContentAs.isAssignableFrom(cls3)) {
                            rj4Var.getClass();
                            nj4VarQ0 = rj4.f(nj4VarY, clsContentAs);
                        } else if (cls3.isAssignableFrom(clsContentAs)) {
                            nj4VarQ0 = rj4Var.g(nj4VarY, clsContentAs, z2);
                        } else {
                            if (!e0(cls3, clsContentAs)) {
                                String name2 = clsContentAs.getName();
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = nj4VarY;
                                objArr2[c2] = name2;
                                throw new a62(null, String.format("Cannot refine serialization content type %s into %s; types not related", objArr2));
                            }
                            nj4VarQ0 = nj4VarY.q0();
                        }
                    } catch (IllegalArgumentException e4) {
                        String name3 = clsContentAs.getName();
                        String strQ2 = xb5Var.q();
                        String message2 = e4.getMessage();
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = nj4VarQ02;
                        objArr3[c2] = name3;
                        objArr3[2] = strQ2;
                        objArr3[c] = message2;
                        throw new a62(null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", objArr3), e4);
                    }
                }
                return nj4VarQ02.n0(nj4VarQ0);
            }
        }
        return nj4VarQ02;
    }

    @Override // defpackage.cu2
    public final ls4 b(w8 w8Var, ls4 ls4Var) {
        s42 s42Var = (s42) w8Var.K0.get(s42.class);
        if (s42Var == null) {
            return ls4Var;
        }
        r42 r42Var = ls4Var.b;
        r42 r42Var2 = ls4Var.X;
        r42 r42Var3 = ls4Var.A;
        r42 r42Var4 = ls4Var.z;
        r42 r42Var5 = ls4Var.f;
        r42 r42Var6 = s42Var.getterVisibility();
        r42 r42Var7 = r42.A;
        r42 r42Var8 = r42Var6 == r42Var7 ? r42Var : r42Var6;
        r42 r42VarIsGetterVisibility = s42Var.isGetterVisibility();
        r42 r42Var9 = r42VarIsGetterVisibility == r42Var7 ? r42Var5 : r42VarIsGetterVisibility;
        r42 r42Var10 = s42Var.setterVisibility();
        r42 r42Var11 = r42Var10 == r42Var7 ? r42Var4 : r42Var10;
        r42 r42VarCreatorVisibility = s42Var.creatorVisibility();
        r42 r42Var12 = r42VarCreatorVisibility == r42Var7 ? r42Var3 : r42VarCreatorVisibility;
        r42 r42VarFieldVisibility = s42Var.fieldVisibility();
        r42 r42Var13 = r42VarFieldVisibility == r42Var7 ? r42Var2 : r42VarFieldVisibility;
        return (r42Var8 == ls4Var.b && r42Var9 == r42Var5 && r42Var11 == r42Var4 && r42Var12 == r42Var3 && r42Var13 == r42Var2) ? ls4Var : new ls4(r42Var8, r42Var9, r42Var11, r42Var12, r42Var13);
    }

    @Override // defpackage.cu2
    public final d9 b0(d9 d9Var, d9 d9Var2) {
        Class clsX = d9Var.X(0);
        Class clsX2 = d9Var2.X(0);
        if (!clsX.isPrimitive()) {
            if (!clsX2.isPrimitive()) {
                if (clsX == String.class) {
                    if (clsX2 == String.class) {
                        return null;
                    }
                } else if (clsX2 != String.class) {
                    return null;
                }
            }
            return d9Var2;
        }
        if (clsX2.isPrimitive()) {
            return null;
        }
        return d9Var;
    }

    @Override // defpackage.cu2
    public final Object c(xb5 xb5Var) {
        Class clsContentUsing;
        z62 z62Var = (z62) xb5Var.m(z62.class);
        if (z62Var == null || (clsContentUsing = z62Var.contentUsing()) == a72.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // defpackage.cu2
    public final u42 d(bt3 bt3Var, i9 i9Var) {
        u42 u42VarMode;
        v42 v42Var = (v42) i9Var.m(v42.class);
        if (v42Var == null) {
            u42VarMode = null;
        } else {
            u42VarMode = v42Var.mode();
            if (u42VarMode != u42.b) {
                return u42VarMode;
            }
        }
        if (this.f) {
            bt3Var.f(ah2.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES);
        }
        return u42VarMode;
    }

    @Override // defpackage.cu2
    public final Object e(w8 w8Var) {
        l51 l51Var = (l51) w8Var.K0.get(l51.class);
        if (l51Var == null) {
            return null;
        }
        return l51Var.value();
    }

    @Override // defpackage.cu2
    public final String[] f(w8 w8Var, Enum[] enumArr, String[] strArr) {
        String strValue;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (a9 a9Var : w8Var.P()) {
            n62 n62Var = (n62) a9Var.m(n62.class);
            if (n62Var != null && (strValue = n62Var.value()) != null) {
                linkedHashMap.put(a9Var.D0.getName(), strValue);
            }
        }
        int length = enumArr.length;
        for (int i = 0; i < length; i++) {
            String str = (String) linkedHashMap.get(enumArr[i].name());
            if (str != null) {
                strArr[i] = str;
            }
        }
        return strArr;
    }

    @Override // defpackage.cu2
    public final Object g(xb5 xb5Var) {
        a52 a52Var = (a52) xb5Var.m(a52.class);
        if (a52Var == null) {
            return null;
        }
        String strValue = a52Var.value();
        if (strValue.isEmpty()) {
            return null;
        }
        return strValue;
    }

    @Override // defpackage.cu2
    public final e52 h(xb5 xb5Var) {
        f52 f52Var = (f52) xb5Var.m(f52.class);
        if (f52Var == null) {
            return null;
        }
        String strPattern = f52Var.pattern();
        d52 d52VarShape = f52Var.shape();
        String strLocale = f52Var.locale();
        String strTimezone = f52Var.timezone();
        b52[] b52VarArrWith = f52Var.with();
        b52[] b52VarArrWithout = f52Var.without();
        int iOrdinal = 0;
        for (b52 b52Var : b52VarArrWith) {
            iOrdinal |= 1 << b52Var.ordinal();
        }
        int iOrdinal2 = 0;
        for (b52 b52Var2 : b52VarArrWithout) {
            iOrdinal2 |= 1 << b52Var2.ordinal();
        }
        return new e52(strPattern, d52VarShape, strLocale, strTimezone, new c52(iOrdinal, iOrdinal2), f52Var.lenient().a());
    }

    @Override // defpackage.cu2
    public final u22 i(c9 c9Var) {
        String name;
        v22 v22Var = (v22) c9Var.m(v22.class);
        if (v22Var == null) {
            return null;
        }
        String strValue = v22Var.value();
        Boolean boolA = v22Var.useInput().a();
        String str = "".equals(strValue) ? null : strValue;
        u22 u22Var = (str == null && boolA == null) ? u22.z : new u22(str, boolA);
        Object obj = u22Var.b;
        if (obj == null) {
            if (c9Var instanceof d9) {
                d9 d9Var = (d9) c9Var;
                name = d9Var.V() == 0 ? d9Var.E0.getReturnType().getName() : d9Var.X(0).getName();
            } else {
                name = c9Var.u().getName();
            }
            if (!name.equals(obj)) {
                return new u22(name, u22Var.f);
            }
        }
        return u22Var;
    }

    @Override // defpackage.cu2
    public final Object j(c9 c9Var) {
        u22 u22VarI = i(c9Var);
        if (u22VarI == null) {
            return null;
        }
        return u22VarI.b;
    }

    @Override // defpackage.cu2
    public final Object k(xb5 xb5Var) {
        Class clsKeyUsing;
        z62 z62Var = (z62) xb5Var.m(z62.class);
        if (z62Var == null || (clsKeyUsing = z62Var.keyUsing()) == a72.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // defpackage.cu2
    public final p83 l(c9 c9Var) {
        boolean z2;
        c72 c72Var = (c72) c9Var.m(c72.class);
        if (c72Var != null) {
            String strValue = c72Var.value();
            if (!strValue.isEmpty()) {
                return p83.a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        n62 n62Var = (n62) c9Var.m(n62.class);
        if (n62Var != null) {
            String strNamespace = n62Var.namespace();
            return p83.b(n62Var.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (z2 || c9Var.S(A)) {
            return p83.A;
        }
        return null;
    }

    @Override // defpackage.cu2
    public final p83 m(c9 c9Var) {
        boolean z2;
        k52 k52Var = (k52) c9Var.m(k52.class);
        if (k52Var != null) {
            String strValue = k52Var.value();
            if (!strValue.isEmpty()) {
                return p83.a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        n62 n62Var = (n62) c9Var.m(n62.class);
        if (n62Var != null) {
            String strNamespace = n62Var.namespace();
            return p83.b(n62Var.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (z2 || c9Var.S(z)) {
            return p83.A;
        }
        return null;
    }

    @Override // defpackage.cu2
    public final Object n(w8 w8Var) {
        c62 c62Var = (c62) w8Var.K0.get(c62.class);
        if (c62Var == null) {
            return null;
        }
        return c62Var.value();
    }

    @Override // defpackage.cu2
    public final Object o(c9 c9Var) {
        Class clsNullsUsing;
        z62 z62Var = (z62) c9Var.m(z62.class);
        if (z62Var == null || (clsNullsUsing = z62Var.nullsUsing()) == a72.class) {
            return null;
        }
        return clsNullsUsing;
    }

    @Override // defpackage.cu2
    public final vt2 p(xb5 xb5Var) {
        m52 m52Var = (m52) xb5Var.m(m52.class);
        if (m52Var == null || m52Var.generator() == ut2.class) {
            return null;
        }
        return new vt2(p83.a(m52Var.property()), m52Var.scope(), m52Var.generator(), false, m52Var.resolver());
    }

    @Override // defpackage.cu2
    public final vt2 q(xb5 xb5Var, vt2 vt2Var) {
        n52 n52Var = (n52) xb5Var.m(n52.class);
        if (n52Var == null) {
            return vt2Var;
        }
        if (vt2Var == null) {
            vt2Var = vt2.f;
        }
        boolean zAlwaysAsId = n52Var.alwaysAsId();
        return vt2Var.e == zAlwaysAsId ? vt2Var : new vt2(vt2Var.a, vt2Var.d, vt2Var.b, zAlwaysAsId, vt2Var.c);
    }

    @Override // defpackage.cu2
    public final m62 r(xb5 xb5Var) {
        n62 n62Var = (n62) xb5Var.m(n62.class);
        if (n62Var != null) {
            return n62Var.access();
        }
        return null;
    }

    @Override // defpackage.cu2
    public final n34 s(yg2 yg2Var, c9 c9Var, nj4 nj4Var) {
        if (nj4Var.Y() != null) {
            return d0(yg2Var, c9Var);
        }
        st4.p("Must call method with a container or reference type (got ", nj4Var, ")");
        return null;
    }

    @Override // defpackage.cu2
    public final String t(c9 c9Var) {
        n62 n62Var = (n62) c9Var.m(n62.class);
        if (n62Var != null) {
            String strDefaultValue = n62Var.defaultValue();
            if (!strDefaultValue.isEmpty()) {
                return strDefaultValue;
            }
        }
        return null;
    }

    @Override // defpackage.cu2
    public final String u(c9 c9Var) {
        o62 o62Var = (o62) c9Var.m(o62.class);
        if (o62Var == null) {
            return null;
        }
        return o62Var.value();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set] */
    @Override // defpackage.cu2
    public final p52 v(xb5 xb5Var) {
        ?? hashSet;
        q52 q52Var = (q52) xb5Var.m(q52.class);
        if (q52Var == null) {
            return p52.Y;
        }
        p52 p52Var = p52.Y;
        String[] strArrValue = q52Var.value();
        if (strArrValue == null || strArrValue.length == 0) {
            hashSet = Collections.EMPTY_SET;
        } else {
            hashSet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                hashSet.add(str);
            }
        }
        ?? r1 = hashSet;
        boolean zIgnoreUnknown = q52Var.ignoreUnknown();
        boolean zAllowGetters = q52Var.allowGetters();
        boolean zAllowSetters = q52Var.allowSetters();
        p52 p52Var2 = p52.Y;
        return (zIgnoreUnknown == p52Var2.f && zAllowGetters == p52Var2.z && zAllowSetters == p52Var2.A && !p52Var2.X && (r1 == 0 || r1.size() == 0)) ? p52Var2 : new p52(r1, zIgnoreUnknown, zAllowGetters, zAllowSetters, false);
    }

    @Override // defpackage.cu2
    public final p52 w(xb5 xb5Var) {
        return v(xb5Var);
    }

    @Override // defpackage.cu2
    public final t52 x(xb5 xb5Var) {
        t52 t52Var;
        z62 z62Var;
        u52 u52Var = (u52) xb5Var.m(u52.class);
        s52 s52Var = s52.X;
        if (u52Var == null) {
            t52Var = t52.X;
        } else {
            t52 t52Var2 = t52.X;
            s52 s52VarValue = u52Var.value();
            s52 s52VarContent = u52Var.content();
            if (s52VarValue == s52Var && s52VarContent == s52Var) {
                t52Var = t52Var2;
            } else {
                Class clsValueFilter = u52Var.valueFilter();
                if (clsValueFilter == Void.class) {
                    clsValueFilter = null;
                }
                Class clsContentFilter = u52Var.contentFilter();
                t52Var = new t52(s52VarValue, s52VarContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
            }
        }
        if (t52Var.b != s52Var || (z62Var = (z62) xb5Var.m(z62.class)) == null) {
            return t52Var;
        }
        int iOrdinal = z62Var.include().ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? t52Var : t52Var.b(s52.z) : t52Var.b(s52.A) : t52Var.b(s52.f) : t52Var.b(s52.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashSet] */
    @Override // defpackage.cu2
    public final v52 y(xb5 xb5Var) {
        ?? hashSet;
        w52 w52Var = (w52) xb5Var.m(w52.class);
        if (w52Var == null) {
            return v52.f;
        }
        String[] strArrValue = w52Var.value();
        if (strArrValue == null || strArrValue.length == 0) {
            hashSet = Collections.EMPTY_SET;
        } else {
            hashSet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                hashSet.add(str);
            }
        }
        return new v52(hashSet);
    }

    @Override // defpackage.cu2
    public final Integer z(c9 c9Var) {
        int iIndex;
        n62 n62Var = (n62) c9Var.m(n62.class);
        if (n62Var == null || (iIndex = n62Var.index()) == -1) {
            return null;
        }
        return Integer.valueOf(iIndex);
    }
}
