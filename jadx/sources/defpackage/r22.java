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
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.n34 d0(defpackage.yg2 r10, defpackage.xb5 r11) {
        /*
            java.lang.Class<n72> r0 = defpackage.n72.class
            java.lang.annotation.Annotation r0 = r11.m(r0)
            n72 r0 = (defpackage.n72) r0
            r1 = 0
            if (r0 != 0) goto Ld
            r0 = r1
            goto L2d
        Ld:
            k72 r2 = r0.use()
            j72 r3 = r0.include()
            java.lang.String r4 = r0.property()
            java.lang.Class r5 = r0.defaultImpl()
            boolean r6 = r0.visible()
            jw2 r0 = r0.requireTypeIdForSubtypes()
            java.lang.Boolean r7 = r0.a()
            m72 r0 = defpackage.m72.a(r2, r3, r4, r5, r6, r7)
        L2d:
            java.lang.Class<p72> r2 = defpackage.p72.class
            java.lang.annotation.Annotation r2 = r11.m(r2)
            p72 r2 = (defpackage.p72) r2
            if (r2 == 0) goto L4e
            if (r0 != 0) goto L3a
            goto L50
        L3a:
            java.lang.Class r2 = r2.value()
            r10.getClass()
            ah2 r3 = defpackage.ah2.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r3 = r10.f(r3)
            java.lang.Object r2 = defpackage.n50.f(r2, r3)
            n34 r2 = (defpackage.n34) r2
            goto L71
        L4e:
            if (r0 != 0) goto L51
        L50:
            return r1
        L51:
            k72 r2 = r0.b
            k72 r3 = defpackage.k72.NONE
            if (r2 != r3) goto L69
            r7 = 0
            r8 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            m72 r10 = defpackage.m72.a(r3, r4, r5, r6, r7, r8)
            n34 r11 = new n34
            r11.<init>()
            r11.b(r10)
            return r11
        L69:
            n34 r2 = new n34
            r2.<init>()
            r2.b(r0)
        L71:
            java.lang.Class<i72> r3 = defpackage.i72.class
            java.lang.annotation.Annotation r3 = r11.m(r3)
            i72 r3 = (defpackage.i72) r3
            if (r3 != 0) goto L7c
            goto L90
        L7c:
            java.lang.Class r1 = r3.value()
            r10.getClass()
            ah2 r3 = defpackage.ah2.CAN_OVERRIDE_ACCESS_MODIFIERS
            boolean r10 = r10.f(r3)
            java.lang.Object r10 = defpackage.n50.f(r1, r10)
            r1 = r10
            sj4 r1 = (defpackage.sj4) r1
        L90:
            j72 r10 = r0.f
            j72 r3 = defpackage.j72.A
            if (r10 != r3) goto Laf
            boolean r11 = r11 instanceof defpackage.w8
            if (r11 == 0) goto Laf
            j72 r5 = defpackage.j72.b
            if (r5 != r10) goto L9f
            goto Laf
        L9f:
            m72 r3 = new m72
            k72 r4 = r0.b
            java.lang.String r6 = r0.z
            java.lang.Class r7 = r0.A
            boolean r8 = r0.X
            java.lang.Boolean r9 = r0.Y
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0 = r3
        Laf:
            java.lang.Class r10 = r0.A
            if (r10 == 0) goto Lbb
            java.lang.Class<l72> r11 = defpackage.l72.class
            if (r10 == r11) goto Lbb
            boolean r10 = r10.isAnnotation()
        Lbb:
            r2.d = r1
            r2.b(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r22.d0(yg2, xb5):n34");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.nj4 a0(defpackage.yg2 r24, defpackage.xb5 r25, defpackage.nj4 r26) throws defpackage.a62 {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r22.a0(yg2, xb5, nj4):nj4");
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
