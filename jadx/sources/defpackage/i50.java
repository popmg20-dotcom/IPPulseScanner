package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class i50 extends sj4 implements Serializable {
    public final Set z;

    public i50(nj4 nj4Var, rj4 rj4Var, Collection collection) {
        super(nj4Var, rj4Var);
        Set hashSet = null;
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                uo2 uo2Var = (uo2) it.next();
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add(uo2Var.b.getName());
            }
        }
        this.z = hashSet == null ? Collections.EMPTY_SET : hashSet;
    }

    @Override // defpackage.sj4
    public String b(Object obj) {
        return d(obj, obj.getClass(), this.b);
    }

    @Override // defpackage.sj4
    public String c(Object obj, Class cls) {
        return d(obj, cls, this.b);
    }

    public final String d(Object obj, Class cls, rj4 rj4Var) {
        Class declaringClass;
        qj4 qj4Var;
        Class declaringClass2;
        qj4 qj4Var2;
        Class clsA = sj4.a(cls);
        String name = clsA.getName();
        if (name.startsWith("java.util.")) {
            if (obj instanceof EnumSet) {
                EnumSet enumSet = (EnumSet) obj;
                Annotation[] annotationArr = n50.a;
                if (enumSet.isEmpty()) {
                    m50 m50Var = m50.e;
                    Field field = m50Var.a;
                    if (field == null) {
                        zo2.v(m50Var.c, "Cannot figure out type parameter for `EnumSet` (odd JDK platform?), problem: ");
                        return null;
                    }
                    try {
                        declaringClass2 = (Class) field.get(enumSet);
                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                } else {
                    declaringClass2 = ((Enum) enumSet.iterator().next()).getDeclaringClass();
                }
                nj4 nj4VarC = rj4Var.c(null, declaringClass2, rj4.A);
                String[] strArr = qj4.X;
                TypeVariable[] typeParameters = EnumSet.class.getTypeParameters();
                int length = typeParameters == null ? 0 : typeParameters.length;
                if (length == 0) {
                    qj4Var2 = qj4.Z;
                } else {
                    if (length != 1) {
                        e04.e(length, EnumSet.class.getName(), " with 1 type parameter: class expects ");
                        return null;
                    }
                    qj4Var2 = new qj4(new String[]{typeParameters[0].getName()}, new nj4[]{nj4VarC}, null);
                }
                a70 a70Var = (a70) rj4Var.c(null, EnumSet.class, qj4Var2);
                if (qj4Var2.f()) {
                    nj4 nj4VarY = a70Var.W(Collection.class).Y();
                    if (!nj4VarY.equals(nj4VarC)) {
                        zo2.p("Non-generic Collection class %s did not resolve to something with element type %s but %s ", new Object[]{n50.t(EnumSet.class), nj4VarC, nj4VarY});
                        return null;
                    }
                }
                return a70Var.V();
            }
            if (obj instanceof EnumMap) {
                EnumMap enumMap = (EnumMap) obj;
                Annotation[] annotationArr2 = n50.a;
                if (enumMap.isEmpty()) {
                    m50 m50Var2 = m50.e;
                    Field field2 = m50Var2.b;
                    if (field2 == null) {
                        zo2.v(m50Var2.d, "Cannot figure out type parameter for `EnumMap` (odd JDK platform?), problem: ");
                        return null;
                    }
                    try {
                        declaringClass = (Class) field2.get(enumMap);
                    } catch (Exception e2) {
                        throw new IllegalArgumentException(e2);
                    }
                } else {
                    declaringClass = ((Enum) enumMap.keySet().iterator().next()).getDeclaringClass();
                }
                qj4 qj4Var3 = rj4.A;
                nj4 nj4VarC2 = rj4Var.c(null, declaringClass, qj4Var3);
                nj4 nj4VarC3 = rj4Var.c(null, Object.class, qj4Var3);
                nj4[] nj4VarArr = {nj4VarC2, nj4VarC3};
                String[] strArr2 = qj4.X;
                TypeVariable[] typeParameters2 = EnumMap.class.getTypeParameters();
                if (typeParameters2 == null || typeParameters2.length == 0) {
                    qj4Var = qj4.Z;
                } else {
                    int length2 = typeParameters2.length;
                    String[] strArr3 = new String[length2];
                    for (int i = 0; i < length2; i++) {
                        strArr3[i] = typeParameters2[i].getName();
                    }
                    if (length2 != 2) {
                        e04.e(length2, EnumMap.class.getName(), " with 2 type parameters: class expects ");
                        return null;
                    }
                    qj4Var = new qj4(strArr3, nj4VarArr, null);
                }
                wg2 wg2Var = (wg2) rj4Var.c(null, EnumMap.class, qj4Var);
                if (qj4Var.f()) {
                    nj4 nj4VarW = wg2Var.W(Map.class);
                    nj4 nj4VarB0 = nj4VarW.b0();
                    if (!nj4VarB0.equals(nj4VarC2)) {
                        zo2.p("Non-generic Map class %s did not resolve to something with key type %s but %s ", new Object[]{n50.t(EnumMap.class), nj4VarC2, nj4VarB0});
                        return null;
                    }
                    nj4 nj4VarY2 = nj4VarW.Y();
                    if (!nj4VarY2.equals(nj4VarC3)) {
                        zo2.p("Non-generic Map class %s did not resolve to something with value type %s but %s ", new Object[]{n50.t(EnumMap.class), nj4VarC3, nj4VarY2});
                        return null;
                    }
                }
                return wg2Var.V();
            }
        } else if (name.indexOf(36) >= 0 && n50.l(clsA) != null) {
            nj4 nj4Var = this.f;
            if (n50.l(nj4Var.L0) == null) {
                return nj4Var.L0.getName();
            }
        }
        return name;
    }
}
