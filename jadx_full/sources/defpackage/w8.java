package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w8 extends xb5 implements yj4 {
    public static final ed4 P0;
    public final nj4 B0;
    public final Class C0;
    public final qj4 D0;
    public final List E0;
    public final cu2 F0;
    public final rj4 G0;
    public final g50 H0;
    public final Class I0;
    public final boolean J0;
    public final o9 K0;
    public ed4 L0;
    public g9 M0;
    public List N0;
    public transient Boolean O0;

    static {
        List list = Collections.EMPTY_LIST;
        P0 = new ed4(3, (Object) null, list, list);
    }

    public w8(Class cls) {
        this.B0 = null;
        this.C0 = cls;
        this.E0 = Collections.EMPTY_LIST;
        this.I0 = null;
        this.K0 = ke0.a;
        this.D0 = qj4.Z;
        this.F0 = null;
        this.H0 = null;
        this.G0 = null;
        this.J0 = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x021e A[EDGE_INSN: B:241:0x021e->B:120:0x021e BREAK  A[LOOP:9: B:125:0x0241->B:172:0x02e1], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ed4 O() {
        l50 l50Var;
        ArrayList arrayList;
        int i;
        List list;
        nj4 nj4Var;
        Class cls;
        nj4 nj4Var2;
        int i2;
        Class cls2;
        ArrayList arrayList2;
        List list2;
        int i3;
        ArrayList arrayList3;
        Class cls3;
        qj4 qj4Var;
        TypeVariable<Method>[] typeVariableArr;
        nj4 nj4Var3;
        TypeVariable<Method> typeVariable;
        Method[] methodArr;
        ed4 ed4Var = this.L0;
        if (ed4Var == null) {
            nj4 nj4Var4 = this.B0;
            if (nj4Var4 == null) {
                ed4Var = P0;
            } else {
                Class cls4 = this.I0;
                boolean z = (cls4 != null) | this.J0;
                cu2 cu2Var = this.F0;
                z8 z8Var = new z8(cu2Var, this, z);
                w8 w8Var = (w8) z8Var.Y;
                boolean zI0 = nj4Var4.i0();
                Class cls5 = nj4Var4.L0;
                if (zI0) {
                    l50Var = null;
                    arrayList = null;
                } else {
                    l50Var = null;
                    arrayList = null;
                    for (l50 l50Var2 : n50.k(cls5)) {
                        if (!l50Var2.a.isSynthetic()) {
                            if (l50Var2.a() == 0) {
                                l50Var = l50Var2;
                            } else {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(l50Var2);
                            }
                        }
                    }
                }
                if (arrayList == null) {
                    list = Collections.EMPTY_LIST;
                    if (l50Var == null) {
                        nj4Var = nj4Var4;
                        cls = cls4;
                        arrayList2 = null;
                        for (Method method : n50.j(cls5)) {
                            if (!Modifier.isStatic(method.getModifiers()) ? false : !method.isSynthetic()) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(method);
                            }
                        }
                        if (arrayList2 != null) {
                            list2 = Collections.EMPTY_LIST;
                        } else {
                            int size = arrayList2.size();
                            ArrayList arrayList4 = new ArrayList(size);
                            for (int i4 = 0; i4 < size; i4++) {
                                arrayList4.add(null);
                            }
                            if (cls != null) {
                                Method[] declaredMethods = cls.getDeclaredMethods();
                                int length = declaredMethods.length;
                                sj2[] sj2VarArr = null;
                                int i5 = 0;
                                while (i5 < length) {
                                    Method method2 = declaredMethods[i5];
                                    if (!Modifier.isStatic(method2.getModifiers()) ? false : !method2.isSynthetic()) {
                                        if (sj2VarArr == null) {
                                            sj2VarArr = new sj2[size];
                                            int i6 = 0;
                                            while (i6 < size) {
                                                sj2VarArr[i6] = new sj2((Method) arrayList2.get(i6));
                                                i6++;
                                                declaredMethods = declaredMethods;
                                            }
                                        }
                                        methodArr = declaredMethods;
                                        sj2 sj2Var = new sj2(method2);
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= size) {
                                                break;
                                            }
                                            if (sj2Var.equals(sj2VarArr[i7])) {
                                                arrayList4.set(i7, z8Var.Z0((Method) arrayList2.get(i7), w8Var, method2));
                                                break;
                                            }
                                            i7++;
                                        }
                                    } else {
                                        methodArr = declaredMethods;
                                    }
                                    i5++;
                                    declaredMethods = methodArr;
                                }
                            }
                            int i8 = 0;
                            while (i8 < size) {
                                if (((d9) arrayList4.get(i8)) == null) {
                                    Method method3 = (Method) arrayList2.get(i8);
                                    TypeVariable<Method>[] typeParameters = method3.getTypeParameters();
                                    if (typeParameters.length == 0 || nj4Var.X().f()) {
                                        i3 = size;
                                    } else {
                                        Type genericReturnType = method3.getGenericReturnType();
                                        if (genericReturnType instanceof ParameterizedType) {
                                            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
                                            if (cls5.equals(parameterizedType.getRawType())) {
                                                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                                                ArrayList arrayList5 = new ArrayList(typeParameters.length);
                                                ArrayList arrayList6 = new ArrayList(typeParameters.length);
                                                i3 = size;
                                                int i9 = 0;
                                                while (true) {
                                                    if (i9 < actualTypeArguments.length) {
                                                        TypeVariable typeVariableD = ji0.D(actualTypeArguments[i9]);
                                                        if (typeVariableD != null) {
                                                            String name = typeVariableD.getName();
                                                            if (name == null) {
                                                                break;
                                                            }
                                                            arrayList3 = arrayList2;
                                                            qj4 qj4VarX = nj4Var.X();
                                                            if (i9 >= 0) {
                                                                nj4[] nj4VarArr = qj4VarX.f;
                                                                cls3 = cls5;
                                                                if (i9 < nj4VarArr.length) {
                                                                    nj4Var3 = nj4VarArr[i9];
                                                                }
                                                                if (nj4Var3 != null) {
                                                                    break;
                                                                }
                                                                int length2 = typeParameters.length;
                                                                typeVariableArr = typeParameters;
                                                                int i10 = 0;
                                                                while (true) {
                                                                    if (i10 >= length2) {
                                                                        typeVariable = null;
                                                                        break;
                                                                    }
                                                                    typeVariable = typeVariableArr[i10];
                                                                    int i11 = length2;
                                                                    if (name.equals(typeVariable.getName())) {
                                                                        break;
                                                                    }
                                                                    i10++;
                                                                    length2 = i11;
                                                                }
                                                                if (typeVariable == null) {
                                                                    break;
                                                                }
                                                                Type[] bounds = typeVariable.getBounds();
                                                                int length3 = bounds.length;
                                                                int i12 = 0;
                                                                while (true) {
                                                                    if (i12 >= length3) {
                                                                        int iIndexOf = arrayList5.indexOf(name);
                                                                        if (iIndexOf != -1) {
                                                                            nj4 nj4Var5 = (nj4) arrayList6.get(iIndexOf);
                                                                            if (!nj4Var3.equals(nj4Var5)) {
                                                                                boolean zK0 = nj4Var5.k0(nj4Var3.L0);
                                                                                boolean zK02 = nj4Var3.k0(nj4Var5.L0);
                                                                                if (!zK0 && !zK02) {
                                                                                    break;
                                                                                }
                                                                                if ((zK0 ^ zK02) && zK02) {
                                                                                    arrayList6.set(iIndexOf, nj4Var3);
                                                                                }
                                                                            } else {
                                                                                continue;
                                                                            }
                                                                        } else {
                                                                            arrayList5.add(name);
                                                                            arrayList6.add(nj4Var3);
                                                                        }
                                                                    } else {
                                                                        int i13 = i12;
                                                                        if (!ji0.K(w8Var, nj4Var3, bounds[i13])) {
                                                                            break;
                                                                        }
                                                                        i12 = i13 + 1;
                                                                    }
                                                                }
                                                            } else {
                                                                cls3 = cls5;
                                                                qj4VarX.getClass();
                                                            }
                                                            nj4Var3 = null;
                                                            if (nj4Var3 != null) {
                                                            }
                                                        } else {
                                                            arrayList3 = arrayList2;
                                                            cls3 = cls5;
                                                            typeVariableArr = typeParameters;
                                                        }
                                                        i9++;
                                                        arrayList2 = arrayList3;
                                                        cls5 = cls3;
                                                        typeParameters = typeVariableArr;
                                                    } else {
                                                        arrayList3 = arrayList2;
                                                        cls3 = cls5;
                                                        if (arrayList5.isEmpty()) {
                                                            break;
                                                        }
                                                        qj4Var = (arrayList5.isEmpty() || arrayList6.isEmpty()) ? qj4.Z : new qj4((String[]) arrayList5.toArray(qj4.X), (nj4[]) arrayList6.toArray(qj4.Y), null);
                                                    }
                                                }
                                                arrayList4.set(i8, z8Var.Z0(method3, qj4Var != null ? w8Var : new e24(12, this.G0, qj4Var, false), null));
                                            }
                                        } else {
                                            i3 = size;
                                        }
                                    }
                                    arrayList3 = arrayList2;
                                    cls3 = cls5;
                                    qj4Var = null;
                                    arrayList4.set(i8, z8Var.Z0(method3, qj4Var != null ? w8Var : new e24(12, this.G0, qj4Var, false), null));
                                } else {
                                    i3 = size;
                                    arrayList3 = arrayList2;
                                    cls3 = cls5;
                                }
                                i8++;
                                size = i3;
                                arrayList2 = arrayList3;
                                cls5 = cls3;
                            }
                            list2 = arrayList4;
                        }
                        if (z8Var.X) {
                            y8 y8Var = (y8) z8Var.Z;
                            if (y8Var != null && cu2Var.U(y8Var)) {
                                z8Var.Z = null;
                            }
                            int size2 = list.size();
                            while (true) {
                                size2--;
                                if (size2 < 0) {
                                    break;
                                }
                                if (cu2Var.U((c9) list.get(size2))) {
                                    list.remove(size2);
                                }
                            }
                            int size3 = list2.size();
                            while (true) {
                                size3--;
                                if (size3 < 0) {
                                    break;
                                }
                                if (cu2Var.U((c9) list2.get(size3))) {
                                    list2.remove(size3);
                                }
                            }
                        }
                        ed4Var = new ed4(3, (y8) z8Var.Z, list, list2);
                    } else {
                        i = 0;
                    }
                } else {
                    int size4 = arrayList.size();
                    ArrayList arrayList7 = new ArrayList(size4);
                    for (int i14 = 0; i14 < size4; i14++) {
                        arrayList7.add(null);
                    }
                    i = size4;
                    list = arrayList7;
                }
                cp1[] cp1VarArr = k70.z;
                if (cls4 != null) {
                    l50[] l50VarArrK = n50.k(cls4);
                    int length4 = l50VarArrK.length;
                    sj2[] sj2VarArr2 = null;
                    int i15 = 0;
                    while (i15 < length4) {
                        l50 l50Var3 = l50VarArrK[i15];
                        if (l50Var3.a() == 0) {
                            nj4Var2 = nj4Var4;
                            if (l50Var != null) {
                                i2 = i15;
                                z8Var.Z = new y8(w8Var, l50Var.a, z8Var.X0(l50Var, l50Var3), cp1VarArr);
                                cls2 = cls4;
                                l50Var = null;
                            } else {
                                i2 = i15;
                                cls2 = cls4;
                            }
                        } else {
                            nj4Var2 = nj4Var4;
                            i2 = i15;
                            if (arrayList == null) {
                                cls2 = cls4;
                            } else {
                                if (sj2VarArr2 == null) {
                                    sj2[] sj2VarArr3 = new sj2[i];
                                    int i16 = 0;
                                    while (true) {
                                        sj2VarArr2 = sj2VarArr3;
                                        if (i16 >= i) {
                                            break;
                                        }
                                        int i17 = i16;
                                        sj2VarArr2[i17] = new sj2(((l50) arrayList.get(i16)).a);
                                        i16 = i17 + 1;
                                        sj2VarArr3 = sj2VarArr2;
                                    }
                                }
                                sj2 sj2Var2 = new sj2(l50Var3.a);
                                int i18 = 0;
                                while (i18 < i) {
                                    cls2 = cls4;
                                    if (sj2Var2.equals(sj2VarArr2[i18])) {
                                        list.set(i18, z8Var.a1((l50) arrayList.get(i18), l50Var3));
                                        break;
                                    }
                                    i18++;
                                    cls4 = cls2;
                                }
                                cls2 = cls4;
                            }
                        }
                        i15 = i2 + 1;
                        nj4Var4 = nj4Var2;
                        cls4 = cls2;
                    }
                }
                nj4Var = nj4Var4;
                cls = cls4;
                if (l50Var != null) {
                    z8Var.Z = new y8(w8Var, l50Var.a, z8Var.X0(l50Var, null), cp1VarArr);
                }
                for (int i19 = 0; i19 < i; i19++) {
                    if (((y8) list.get(i19)) == null) {
                        list.set(i19, z8Var.a1((l50) arrayList.get(i19), null));
                    }
                }
                arrayList2 = null;
                while (i < r3) {
                }
                if (arrayList2 != null) {
                }
                if (z8Var.X) {
                }
                ed4Var = new ed4(3, (y8) z8Var.Z, list, list2);
            }
            this.L0 = ed4Var;
        }
        return ed4Var;
    }

    public final List P() {
        Map mapW0;
        List list = this.N0;
        if (list == null) {
            nj4 nj4Var = this.B0;
            if (nj4Var == null || (mapW0 = new z8(this.F0, this.G0, this.H0, this.J0).W0(this, nj4Var)) == null) {
                list = Collections.EMPTY_LIST;
            } else {
                ArrayList arrayList = new ArrayList(mapW0.size());
                for (b9 b9Var : mapW0.values()) {
                    arrayList.add(new a9(b9Var.a, b9Var.b, b9Var.c.c()));
                }
                list = arrayList;
            }
            this.N0 = list;
        }
        return list;
    }

    public final g9 Q() {
        g50 g50Var;
        Class clsA;
        g9 g9Var = this.M0;
        if (g9Var == null) {
            nj4 nj4Var = this.B0;
            if (nj4Var == null) {
                g9Var = new g9();
            } else {
                Class cls = nj4Var.L0;
                f9 f9Var = new f9(this.F0, this.H0, this.J0);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                f9Var.W0(this, cls, linkedHashMap, this.I0);
                Iterator it = this.E0.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    g50Var = f9Var.X;
                    Class clsA2 = null;
                    if (!zHasNext) {
                        break;
                    }
                    nj4 nj4Var2 = (nj4) it.next();
                    if (g50Var != null) {
                        clsA2 = g50Var.a(nj4Var2.L0);
                    }
                    f9Var.W0(new e24(12, this.G0, nj4Var2.X(), false), nj4Var2.L0, linkedHashMap, clsA2);
                }
                if (g50Var != null && (clsA = g50Var.a(Object.class)) != null) {
                    f9Var.X0(this, cls, linkedHashMap, clsA);
                    if (((cu2) f9Var.f) != null && !linkedHashMap.isEmpty()) {
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            sj2 sj2Var = (sj2) entry.getKey();
                            if ("hashCode".equals(sj2Var.a) && sj2Var.b.length == 0) {
                                try {
                                    Method declaredMethod = Object.class.getDeclaredMethod(sj2Var.a, null);
                                    e9 e9Var = (e9) entry.getValue();
                                    e9Var.c = f9Var.I0(e9Var.c, declaredMethod.getDeclaredAnnotations());
                                    e9Var.b = declaredMethod;
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    g9Var = new g9();
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        e9 e9Var2 = (e9) entry2.getValue();
                        Method method = e9Var2.b;
                        d9 d9Var = method == null ? null : new d9(e9Var2.a, method, e9Var2.c.c(), null);
                        if (d9Var != null) {
                            linkedHashMap2.put(entry2.getKey(), d9Var);
                        }
                    }
                    g9 g9Var2 = new g9();
                    g9Var2.b = linkedHashMap2;
                    g9Var = g9Var2;
                }
            }
            this.M0 = g9Var;
        }
        return g9Var;
    }

    @Override // defpackage.yj4
    public final nj4 a(Type type) {
        return this.G0.b(null, type, this.D0);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return n50.n(obj, w8.class) && ((w8) obj).C0 == this.C0;
    }

    public final int hashCode() {
        return this.C0.hashCode();
    }

    @Override // defpackage.xb5
    public final Annotation m(Class cls) {
        return this.K0.get(cls);
    }

    @Override // defpackage.xb5
    public final int p() {
        return this.C0.getModifiers();
    }

    @Override // defpackage.xb5
    public final String q() {
        return this.C0.getName();
    }

    public final String toString() {
        return "[AnnotedClass " + this.C0.getName() + "]";
    }

    @Override // defpackage.xb5
    public final Class u() {
        return this.C0;
    }

    @Override // defpackage.xb5
    public final nj4 x() {
        return this.B0;
    }

    public w8(nj4 nj4Var, Class cls, List list, Class cls2, o9 o9Var, qj4 qj4Var, cu2 cu2Var, g50 g50Var, rj4 rj4Var, boolean z) {
        this.B0 = nj4Var;
        this.C0 = cls;
        this.E0 = list;
        this.I0 = cls2;
        this.K0 = o9Var;
        this.D0 = qj4Var;
        this.F0 = cu2Var;
        this.H0 = g50Var;
        this.G0 = rj4Var;
        this.J0 = z;
    }
}
