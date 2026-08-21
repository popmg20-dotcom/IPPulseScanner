package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class by2 {
    public final bt3 a;
    public final b10 b;
    public final nj4 c;
    public final w8 d;
    public final ls4 e;
    public final cu2 f;
    public final boolean g;
    public final boolean h;
    public boolean i;
    public LinkedHashMap j;
    public List k;
    public v62 l;
    public LinkedList m;
    public LinkedList n;
    public LinkedList o;
    public LinkedList p;
    public LinkedList q;
    public LinkedList r;
    public LinkedHashMap s;
    public e52 t;

    public by2(bt3 bt3Var, nj4 nj4Var, w8 w8Var, b10 b10Var) {
        ls4 ls4Var;
        this.a = bt3Var;
        this.c = nj4Var;
        this.d = w8Var;
        this.h = n50.s(nj4Var.L0);
        if (bt3Var.f(ah2.USE_ANNOTATIONS)) {
            this.g = true;
            this.f = bt3Var.d();
        } else {
            this.g = false;
            this.f = ns2.b;
        }
        Class cls = nj4Var.L0;
        if (n50.p(cls)) {
            ls4Var = ls4.Z;
        } else {
            long j = bt3Var.b;
            long j2 = zg2.A0;
            long j3 = j & j2;
            r42 r42Var = r42.b;
            ls4 ls4Var2 = ls4.Y;
            if (j3 != j2) {
                boolean zF = bt3Var.f(ah2.AUTO_DETECT_FIELDS);
                r42 r42Var2 = r42.z;
                if (!zF) {
                    r42 r42Var3 = r42.f;
                    ls4Var2 = new ls4(r42Var3, r42Var3, r42Var, r42Var, r42Var2);
                }
                if (!bt3Var.f(ah2.AUTO_DETECT_GETTERS) && ls4Var2.b != r42Var2) {
                    ls4Var2 = new ls4(r42Var2, ls4Var2.f, ls4Var2.z, ls4Var2.A, ls4Var2.X);
                }
                if (!bt3Var.f(ah2.AUTO_DETECT_IS_GETTERS) && ls4Var2.f != r42Var2) {
                    ls4 ls4Var3 = new ls4(ls4Var2.b, r42Var2, ls4Var2.z, ls4Var2.A, ls4Var2.X);
                    r42Var2 = r42Var2;
                    ls4Var2 = ls4Var3;
                }
                if (!bt3Var.f(ah2.AUTO_DETECT_SETTERS) && ls4Var2.z != r42Var2) {
                    r42 r42Var4 = r42Var2;
                    r42Var2 = r42Var4;
                    ls4Var2 = new ls4(ls4Var2.b, ls4Var2.f, r42Var4, ls4Var2.A, ls4Var2.X);
                }
                if (!bt3Var.f(ah2.AUTO_DETECT_CREATORS) && ls4Var2.A != r42Var2) {
                    ls4Var2 = new ls4(ls4Var2.b, ls4Var2.f, ls4Var2.z, r42Var2, ls4Var2.X);
                }
            }
            if (n50.s(cls) && bt3Var.f(ah2.AUTO_DETECT_CREATORS) && ls4Var2.A != r42Var) {
                ls4 ls4Var4 = ls4Var2;
                ls4Var2 = new ls4(ls4Var4.b, ls4Var4.f, ls4Var4.z, r42Var, ls4Var4.X);
            }
            ls4Var = ls4Var2;
        }
        this.e = bt3Var.d().b(w8Var, ls4Var);
        this.b = b10Var;
    }

    public static boolean g(LinkedList linkedList) {
        do {
            c9 c9Var = (c9) linkedList.get(0);
            c9 c9Var2 = (c9) linkedList.get(1);
            if (c9Var instanceof a9) {
                if (!(c9Var2 instanceof d9)) {
                    return false;
                }
                linkedList.remove(0);
            } else {
                if (!(c9Var instanceof d9) || !(c9Var2 instanceof a9)) {
                    return false;
                }
                linkedList.remove(1);
            }
        } while (linkedList.size() > 1);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(v62 v62Var, List list, LinkedHashMap linkedHashMap, boolean z) {
        cu2 cu2Var;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k23 k23Var = (k23) it.next();
            if (k23Var.b) {
                it.remove();
                int iOrdinal = k23Var.c.ordinal();
                boolean zA = false;
                bt3 bt3Var = this.a;
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        i9 i9Var = k23Var.a;
                        i9Var.V();
                        k23Var.b(bt3Var);
                        int length = k23Var.e.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                LinkedList linkedList = this.r;
                                if (linkedList == null || linkedList.isEmpty()) {
                                    if (i9Var.V() == 1) {
                                        p83 p83Var = k23Var.d[0];
                                        if (p83Var == null) {
                                            cu2Var = this.f;
                                            if (cu2Var != null && cu2Var.i(i9Var.U(0)) != null) {
                                                break;
                                            }
                                        } else {
                                            cy2 cy2Var = (cy2) linkedHashMap.get(p83Var.b);
                                            if (cy2Var == null) {
                                                for (cy2 cy2Var2 : linkedHashMap.values()) {
                                                    if (cy2Var2.C() && !cy2Var2.B() && (cy2.y(cy2Var2.Y, p83Var) || cy2.y(cy2Var2.y0, p83Var) || cy2.y(cy2Var2.z0, p83Var) || cy2.y(cy2Var2.Z, p83Var))) {
                                                        break;
                                                    }
                                                }
                                                cu2Var = this.f;
                                                if (cu2Var != null) {
                                                }
                                            } else if (!cy2Var.C() || cy2Var.B()) {
                                            }
                                        }
                                    } else {
                                        zA = k23Var.a(bt3Var);
                                    }
                                }
                            } else if (k23Var.e[i] != null) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        zA = true;
                    } else {
                        zA = true;
                    }
                }
                if (!zA) {
                    ArrayList arrayList = (ArrayList) v62Var.z;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        v62Var.z = arrayList;
                    }
                    arrayList.add(k23Var);
                } else if (!z) {
                    v62Var.N(bt3Var, k23Var, "explicit");
                }
            }
        }
    }

    public final List c(List list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i9 i9Var = (i9) it.next();
            arrayList.add(new k23(i9Var, this.g ? this.f.d(this.a, i9Var) : null));
        }
        return arrayList;
    }

    public final void d(u22 u22Var, c9 c9Var) {
        if (u22Var == null) {
            return;
        }
        Object obj = u22Var.b;
        LinkedHashMap linkedHashMap = this.s;
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap();
            this.s = linkedHashMap;
        }
        c9 c9Var2 = (c9) linkedHashMap.put(obj, c9Var);
        if (c9Var2 == null || c9Var2.getClass() != c9Var.getClass()) {
            return;
        }
        i("Duplicate injectable value with id '%s' (of type %s)", obj, n50.e(obj));
        throw null;
    }

    public final cy2 e(LinkedHashMap linkedHashMap, p83 p83Var) {
        String str = p83Var.b;
        cy2 cy2Var = (cy2) linkedHashMap.get(str);
        if (cy2Var != null) {
            return cy2Var;
        }
        cy2 cy2Var2 = new cy2(this.a, this.f, p83Var, p83Var);
        linkedHashMap.put(str, cy2Var2);
        return cy2Var2;
    }

    public final cy2 f(LinkedHashMap linkedHashMap, String str) {
        cy2 cy2Var = (cy2) linkedHashMap.get(str);
        if (cy2Var != null) {
            return cy2Var;
        }
        cu2 cu2Var = this.f;
        p83 p83VarA = p83.a(str);
        cy2 cy2Var2 = new cy2(this.a, cu2Var, p83VarA, p83VarA);
        linkedHashMap.put(str, cy2Var2);
        return cy2Var2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:335:0x05de, code lost:
    
        if (r2.a(r6) == false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x05e1, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0611, code lost:
    
        if (r7.B() != false) goto L357;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0584  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x07b7  */
    /* JADX WARN: Removed duplicated region for block: B:740:0x043f A[EDGE_INSN: B:740:0x043f->B:224:0x043f BREAK  A[LOOP:2: B:219:0x0429->B:742:0x0429], SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h() {
        ls4 ls4Var;
        Object[] objArr;
        cu2 cu2Var;
        boolean z;
        Collection<cy2> collectionValues;
        Class cls;
        ha haVar;
        ha haVar2;
        m62 m62VarR;
        m62 m62VarR2;
        int i;
        int i2;
        Iterator it;
        boolean zHasNext;
        u42 u42Var;
        Iterator it2;
        Iterator it3;
        Iterator it4;
        Iterator it5;
        k23 k23Var;
        cy2 cy2VarE;
        ArrayList arrayList;
        i9 i9Var;
        int iOrdinal;
        ArrayList arrayList2;
        ArrayList arrayList3;
        LinkedList linkedList;
        Class clsX;
        eg0[] eg0VarArr;
        Class cls2;
        y8 y8Var;
        boolean z2;
        boolean z3;
        String strC;
        boolean zA;
        String strD;
        p83 p83Var;
        boolean z4;
        boolean z5;
        boolean zA2;
        boolean z6;
        boolean z7;
        w8 w8Var = this.d;
        Class cls3 = w8Var.C0;
        boolean z8 = false;
        this.l = new v62(13, z8);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ah2 ah2Var = ah2.PROPAGATE_TRANSIENT_MARKER;
        bt3 bt3Var = this.a;
        boolean zF = bt3Var.f(ah2Var);
        Iterator it6 = w8Var.P().iterator();
        while (true) {
            boolean zHasNext2 = it6.hasNext();
            ls4Var = this.e;
            objArr = null;
            cu2Var = this.f;
            if (!zHasNext2) {
                break;
            }
            a9 a9Var = (a9) it6.next();
            Boolean bool = Boolean.TRUE;
            if (bool.equals(cu2Var.R(a9Var))) {
                LinkedList linkedList2 = this.q;
                if (linkedList2 == null) {
                    linkedList2 = new LinkedList();
                    this.q = linkedList2;
                }
                linkedList2.add(a9Var);
            }
            if (bool.equals(cu2Var.S(a9Var))) {
                LinkedList linkedList3 = this.r;
                if (linkedList3 == null) {
                    linkedList3 = new LinkedList();
                    this.r = linkedList3;
                }
                linkedList3.add(a9Var);
            } else {
                boolean zEquals = bool.equals(cu2Var.O(a9Var));
                boolean zEquals2 = bool.equals(cu2Var.Q(a9Var));
                if (zEquals || zEquals2) {
                    if (zEquals) {
                        LinkedList linkedList4 = this.n;
                        if (linkedList4 == null) {
                            linkedList4 = new LinkedList();
                            this.n = linkedList4;
                        }
                        linkedList4.add(a9Var);
                    }
                    if (zEquals2) {
                        LinkedList linkedList5 = this.p;
                        if (linkedList5 == null) {
                            linkedList5 = new LinkedList();
                            this.p = linkedList5;
                        }
                        linkedList5.add(a9Var);
                    }
                }
                String name = a9Var.D0.getName();
                if (name != null) {
                    p83.b(name, null);
                    p83 p83VarM = cu2Var.m(a9Var);
                    boolean z9 = p83VarM != null;
                    if (z9 && p83VarM.c()) {
                        p83VarM = p83.b(name, null);
                        z6 = false;
                    } else {
                        z6 = z9;
                    }
                    p83 p83Var2 = p83VarM;
                    boolean zA3 = p83Var2 != null;
                    if (!zA3) {
                        ls4Var.getClass();
                        zA3 = ls4Var.X.a(a9Var.D0);
                    }
                    boolean z10 = zA3;
                    boolean zU = cu2Var.U(a9Var);
                    if (Modifier.isTransient(a9Var.D0.getModifiers()) && !z9) {
                        if (zF) {
                            z7 = true;
                            cy2 cy2VarF = f(linkedHashMap, name);
                            cy2VarF.Y = new ha(a9Var, cy2VarF.Y, p83Var2, z6, z10, z7);
                        } else if (!zU) {
                        }
                    }
                    z7 = zU;
                    cy2 cy2VarF2 = f(linkedHashMap, name);
                    cy2VarF2.Y = new ha(a9Var, cy2VarF2.Y, p83Var2, z6, z10, z7);
                }
            }
        }
        for (d9 d9Var : w8Var.Q()) {
            int iV = d9Var.V();
            Method method = d9Var.E0;
            b10 b10Var = this.b;
            if (iV == 0) {
                Class<?> returnType = method.getReturnType();
                if (returnType == Void.TYPE || (returnType == Void.class && !bt3Var.f(ah2.ALLOW_VOID_VALUED_PROPERTIES))) {
                    z3 = z8;
                } else {
                    Boolean bool2 = Boolean.TRUE;
                    if (bool2.equals(cu2Var.O(d9Var))) {
                        LinkedList linkedList6 = this.m;
                        if (linkedList6 == null) {
                            linkedList6 = new LinkedList();
                            this.m = linkedList6;
                        }
                        linkedList6.add(d9Var);
                    } else {
                        if (bool2.equals(cu2Var.R(d9Var))) {
                            LinkedList linkedList7 = this.q;
                            if (linkedList7 == null) {
                                linkedList7 = new LinkedList();
                                this.q = linkedList7;
                            }
                            linkedList7.add(d9Var);
                        } else if (bool2.equals(cu2Var.S(d9Var))) {
                            LinkedList linkedList8 = this.r;
                            if (linkedList8 == null) {
                                linkedList8 = new LinkedList();
                                this.r = linkedList8;
                            }
                            linkedList8.add(d9Var);
                        }
                        z3 = z8;
                    }
                    p83 p83VarM2 = cu2Var.m(d9Var);
                    boolean z11 = p83VarM2 != null ? true : z8;
                    if (z11) {
                        z3 = z8;
                        strD = b10Var.d(d9Var, method.getName());
                        if (strD == null) {
                            strD = b10Var.b(d9Var, method.getName());
                        }
                        if (strD == null) {
                            strD = method.getName();
                        }
                        if (p83VarM2.c()) {
                            p83VarM2 = p83.b(strD, null);
                            z11 = z3;
                        }
                        p83Var = p83VarM2;
                        z4 = z11;
                        z5 = true;
                    } else {
                        z3 = z8;
                        strD = b10Var.d(d9Var, method.getName());
                        if (strD == null) {
                            strD = b10Var.b(d9Var, method.getName());
                            if (strD != null) {
                                ls4Var.getClass();
                                zA2 = ls4Var.f.a(method);
                            }
                        } else {
                            ls4Var.getClass();
                            zA2 = ls4Var.b.a(method);
                        }
                        p83Var = p83VarM2;
                        z4 = z11;
                        z5 = zA2;
                    }
                    String strB = b(strD);
                    boolean zU2 = cu2Var.U(d9Var);
                    cy2 cy2VarF3 = f(linkedHashMap, strB);
                    cy2VarF3.y0 = new ha(d9Var, cy2VarF3.y0, p83Var, z4, z5, zU2);
                }
            } else {
                z3 = z8;
                if (iV == 1) {
                    p83 p83VarL = cu2Var.l(d9Var);
                    boolean z12 = p83VarL != null ? true : z3;
                    if (z12) {
                        strC = b10Var.c(method.getName());
                        if (strC == null) {
                            strC = method.getName();
                        }
                        if (p83VarL.c()) {
                            p83VarL = p83.b(strC, null);
                            z12 = z3;
                        }
                        zA = true;
                    } else {
                        strC = b10Var.c(method.getName());
                        if (strC != null) {
                            ls4Var.getClass();
                            zA = ls4Var.z.a(method);
                        }
                    }
                    p83 p83Var3 = p83VarL;
                    boolean z13 = z12;
                    String strB2 = b(strC);
                    boolean zU3 = cu2Var.U(d9Var);
                    cy2 cy2VarF4 = f(linkedHashMap, strB2);
                    cy2VarF4.z0 = new ha(d9Var, cy2VarF4.z0, p83Var3, z13, zA, zU3);
                } else if (iV == 2 && Boolean.TRUE.equals(cu2Var.Q(d9Var))) {
                    LinkedList linkedList9 = this.o;
                    if (linkedList9 == null) {
                        linkedList9 = new LinkedList();
                        this.o = linkedList9;
                    }
                    linkedList9.add(d9Var);
                }
            }
            z8 = z3;
        }
        boolean z14 = z8;
        Boolean boolValueOf = w8Var.O0;
        if (boolValueOf == null) {
            Annotation[] annotationArr = n50.a;
            if (Modifier.isStatic(cls3.getModifiers())) {
                z2 = z14 ? 1 : 0;
                boolValueOf = Boolean.valueOf(z2);
                w8Var.O0 = boolValueOf;
            } else {
                if ((n50.r(cls3) ? null : cls3.getEnclosingClass()) != null) {
                    z2 = true;
                }
                boolValueOf = Boolean.valueOf(z2);
                w8Var.O0 = boolValueOf;
            }
        }
        if (!boolValueOf.booleanValue()) {
            v62 v62Var = this.l;
            List<k23> listC = c((List) w8Var.O().z);
            List listC2 = c((List) w8Var.O().A);
            if (this.h) {
                RuntimeException runtimeException = n22.e;
                if (runtimeException != null) {
                    throw runtimeException;
                }
                n22 n22Var = n22.d;
                i = 2;
                Object[] objArrA = n22Var.a(cls3);
                if (objArrA == null) {
                    eg0VarArr = null;
                    i2 = 1;
                } else {
                    eg0VarArr = new eg0[objArrA.length];
                    i2 = 1;
                    int i3 = z14 ? 1 : 0;
                    while (i3 < objArrA.length) {
                        try {
                            cls2 = cls3;
                        } catch (Exception e) {
                            e = e;
                            cls2 = cls3;
                        }
                        try {
                            try {
                                eg0[] eg0VarArr2 = eg0VarArr;
                                eg0VarArr2[i3] = new eg0(29, (Class) n22Var.c.invoke(objArrA[i3], objArr), (String) n22Var.b.invoke(objArrA[i3], objArr));
                                i3++;
                                cls3 = cls2;
                                eg0VarArr = eg0VarArr2;
                                objArr = null;
                            } catch (Exception e2) {
                                Integer numValueOf = Integer.valueOf(i3);
                                Integer numValueOf2 = Integer.valueOf(objArrA.length);
                                String strT = n50.t(cls2);
                                Object[] objArr2 = new Object[3];
                                objArr2[z14 ? 1 : 0] = numValueOf;
                                objArr2[1] = numValueOf2;
                                objArr2[2] = strT;
                                throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", objArr2), e2);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            Integer numValueOf3 = Integer.valueOf(i3);
                            Integer numValueOf4 = Integer.valueOf(objArrA.length);
                            String strT2 = n50.t(cls2);
                            Object[] objArr3 = new Object[3];
                            objArr3[z14 ? 1 : 0] = numValueOf3;
                            objArr3[1] = numValueOf4;
                            objArr3[2] = strT2;
                            throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", objArr3), e);
                        }
                    }
                }
                if (eg0VarArr != null) {
                    int length = eg0VarArr.length;
                    if (length != 0 || (y8Var = (y8) w8Var.O().f) == null) {
                        for (k23 k23Var2 : listC) {
                            i9 i9Var2 = k23Var2.a;
                            if (i9Var2.V() == length) {
                                int i4 = z14 ? 1 : 0;
                                while (i4 < length) {
                                    eg0[] eg0VarArr3 = eg0VarArr;
                                    if (i9Var2.X(i4).equals((Class) eg0VarArr3[i4].f)) {
                                        i4++;
                                        eg0VarArr = eg0VarArr3;
                                    } else {
                                        eg0VarArr = eg0VarArr3;
                                    }
                                }
                                eg0[] eg0VarArr4 = eg0VarArr;
                                p83[] p83VarArr = new p83[length];
                                for (int i5 = z14 ? 1 : 0; i5 < length; i5++) {
                                    p83VarArr[i5] = p83.a((String) eg0VarArr4[i5].z);
                                }
                                if (k23Var2.d == null) {
                                    int iV2 = i9Var2.V();
                                    if (iV2 == 0) {
                                        p83[] p83VarArr2 = k23.f;
                                        k23Var2.e = p83VarArr2;
                                        k23Var2.d = p83VarArr2;
                                    } else {
                                        k23Var2.e = new p83[iV2];
                                        k23Var2.d = p83VarArr;
                                        cu2 cu2VarD = bt3Var.d();
                                        for (int i6 = z14 ? 1 : 0; i6 < iV2; i6++) {
                                            p83 p83VarL2 = cu2VarD.l(i9Var2.U(i6));
                                            if (p83VarL2 != null && !p83VarL2.c()) {
                                                k23Var2.e[i6] = p83VarL2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        xe.k("Failed to find the canonical Record constructor of type ".concat(n50.m(w8Var.B0)));
                        return;
                    }
                    k23Var2 = new k23(y8Var, null);
                }
                it = listC.iterator();
                while (true) {
                    zHasNext = it.hasNext();
                    u42Var = u42.f;
                    if (zHasNext) {
                        break;
                    } else if (((k23) it.next()).c == u42Var) {
                        it.remove();
                    }
                }
                it2 = listC2.iterator();
                while (it2.hasNext()) {
                    if (((k23) it2.next()).c == u42Var) {
                        it2.remove();
                    }
                }
                Class cls4 = this.c.L0;
                it3 = listC2.iterator();
                while (it3.hasNext()) {
                    k23 k23Var3 = (k23) it3.next();
                    boolean z15 = k23Var3.b;
                    i9 i9Var3 = k23Var3.a;
                    if (!z15 && k23Var2 != k23Var3) {
                        if (cls4.isAssignableFrom(i9Var3.u()) && i9Var3.V() == i2) {
                            String strQ = i9Var3.q();
                            if ("valueOf".equals(strQ)) {
                                i2 = 1;
                            } else {
                                if (!"fromString".equals(strQ) || ((clsX = i9Var3.X((z14 ? 1 : 0) == true ? 1 : 0)) != String.class && !CharSequence.class.isAssignableFrom(clsX))) {
                                }
                                i2 = 1;
                                z14 = false;
                            }
                        }
                        it3.remove();
                        i2 = 1;
                        z14 = false;
                    }
                }
                if (this.g) {
                    a(v62Var, listC, linkedHashMap, false);
                    a(v62Var, listC2, linkedHashMap, ((k23) v62Var.f) != null);
                }
                if (((k23) v62Var.f) == null) {
                    Iterator it7 = listC.iterator();
                    List arrayList4 = null;
                    while (it7.hasNext()) {
                        k23 k23Var4 = (k23) it7.next();
                        k23Var4.b(bt3Var);
                        int length2 = k23Var4.e.length;
                        int i7 = 0;
                        while (true) {
                            if (i7 < length2) {
                                Iterator it8 = it7;
                                if (k23Var4.e[i7] != null) {
                                    it8.remove();
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList(4);
                                    }
                                    arrayList4.add(k23Var4);
                                    it7 = it8;
                                } else {
                                    i7++;
                                    it7 = it8;
                                }
                            }
                        }
                    }
                    if (arrayList4 == null) {
                        arrayList4 = Collections.EMPTY_LIST;
                    }
                    if (k23Var2 == null || !arrayList4.contains(k23Var2)) {
                        Iterator it9 = arrayList4.iterator();
                        while (it9.hasNext()) {
                            v62Var.N(bt3Var, (k23) it9.next(), "implicit");
                        }
                    } else {
                        v62Var.N(bt3Var, k23Var2, "implicit");
                    }
                }
                if (k23Var2 != null && (listC.remove(k23Var2) || listC2.remove(k23Var2))) {
                    iOrdinal = k23Var2.c.ordinal();
                    if (iOrdinal != 1 || (iOrdinal != i && iOrdinal != 3 && k23Var2.a.V() == 1 && (linkedList = this.r) != null && !linkedList.isEmpty())) {
                        arrayList2 = (ArrayList) v62Var.z;
                        if (arrayList2 != null || arrayList2.isEmpty()) {
                            arrayList3 = (ArrayList) v62Var.z;
                            if (arrayList3 == null) {
                                arrayList3 = new ArrayList();
                                v62Var.z = arrayList3;
                            }
                            arrayList3.add(k23Var2);
                        }
                    } else if (((k23) v62Var.f) == null) {
                        v62Var.N(bt3Var, k23Var2, "Primary");
                    }
                }
                if (((k23) v62Var.f) == null && (((arrayList = (ArrayList) v62Var.z) == null || arrayList.isEmpty()) && ((y8) w8Var.O().f) == null && listC.size() == 1)) {
                    k23 k23Var5 = (k23) listC.get(0);
                    i9Var = k23Var5.a;
                    ls4Var.getClass();
                    if (ls4Var.A.a(i9Var.Q())) {
                        k23Var5.b(bt3Var);
                        if (i9Var.V() == 1) {
                            if (cu2Var == null || cu2Var.i(i9Var.U(0)) == null) {
                                p83 p83Var4 = k23Var5.d[0];
                                Object obj = p83Var4 == null ? null : p83Var4.b;
                                if (obj != null) {
                                    cy2 cy2Var = (cy2) linkedHashMap.get(obj);
                                    if (cy2Var != null) {
                                        if (cy2Var.C()) {
                                        }
                                    }
                                }
                            } else {
                                int i8 = 0;
                                listC.remove(i8);
                                v62Var.N(bt3Var, k23Var5, "implicit");
                            }
                        }
                    }
                }
                it4 = listC.iterator();
                while (it4.hasNext()) {
                    i9 i9Var4 = ((k23) it4.next()).a;
                    ls4Var.getClass();
                    if (!ls4Var.A.a(i9Var4.Q())) {
                        it4.remove();
                    }
                }
                it5 = listC2.iterator();
                while (it5.hasNext()) {
                    i9 i9Var5 = ((k23) it5.next()).a;
                    ls4Var.getClass();
                    if (!ls4Var.A.a(i9Var5.Q())) {
                        it5.remove();
                    }
                }
                k23Var = (k23) v62Var.f;
                if (k23Var != null) {
                    this.k = Collections.EMPTY_LIST;
                } else {
                    i9 i9Var6 = k23Var.a;
                    ArrayList arrayList5 = new ArrayList();
                    this.k = arrayList5;
                    int iV3 = i9Var6.V();
                    for (int i9 = 0; i9 < iV3; i9++) {
                        h9 h9VarU = i9Var6.U(i9);
                        p83 p83Var5 = k23Var.e[i9];
                        p83 p83VarA = k23Var.d[i9];
                        boolean z16 = p83Var5 != null;
                        if (z16 || p83VarA != null) {
                            if (p83VarA != null) {
                                p83VarA = p83.a(b(p83VarA.b));
                            }
                            cy2 cy2VarE2 = p83VarA == null ? e(linkedHashMap, p83Var5) : e(linkedHashMap, p83VarA);
                            cy2VarE2.Z = new ha(h9VarU, cy2VarE2.Z, z16 ? p83Var5 : p83VarA, z16, true, false);
                            cy2VarE = cy2VarE2;
                        } else if (cu2Var.M(h9VarU) != null) {
                            p83 p83Var6 = new p83(dw2.A(h9VarU.F0, "@JsonUnwrapped/"), null);
                            cy2VarE = e(linkedHashMap, p83Var6);
                            cy2VarE.Z = new ha(h9VarU, cy2VarE.Z, p83Var6, false, true, false);
                        } else {
                            cy2VarE = null;
                        }
                        arrayList5.add(cy2VarE);
                    }
                }
            } else {
                i = 2;
                i2 = 1;
                cu2Var.getClass();
            }
            k23Var2 = null;
            it = listC.iterator();
            while (true) {
                zHasNext = it.hasNext();
                u42Var = u42.f;
                if (zHasNext) {
                }
            }
            it2 = listC2.iterator();
            while (it2.hasNext()) {
            }
            Class cls42 = this.c.L0;
            it3 = listC2.iterator();
            while (it3.hasNext()) {
            }
            if (this.g) {
            }
            if (((k23) v62Var.f) == null) {
            }
            if (k23Var2 != null) {
                iOrdinal = k23Var2.c.ordinal();
                if (iOrdinal != 1) {
                    arrayList2 = (ArrayList) v62Var.z;
                    if (arrayList2 != null) {
                        arrayList3 = (ArrayList) v62Var.z;
                        if (arrayList3 == null) {
                        }
                        arrayList3.add(k23Var2);
                    }
                }
            }
            if (((k23) v62Var.f) == null) {
                k23 k23Var52 = (k23) listC.get(0);
                i9Var = k23Var52.a;
                ls4Var.getClass();
                if (ls4Var.A.a(i9Var.Q())) {
                }
            }
            it4 = listC.iterator();
            while (it4.hasNext()) {
            }
            it5 = listC2.iterator();
            while (it5.hasNext()) {
            }
            k23Var = (k23) v62Var.f;
            if (k23Var != null) {
            }
        }
        Iterator it10 = linkedHashMap.values().iterator();
        while (it10.hasNext()) {
            cy2 cy2Var2 = (cy2) it10.next();
            if (!cy2Var2.C()) {
                it10.remove();
            } else if (cy2Var2.B()) {
                if (!cy2.q(cy2Var2.Y) && !cy2.q(cy2Var2.y0) && !cy2.q(cy2Var2.z0)) {
                    for (ha haVar3 = cy2Var2.Z; haVar3 != null; haVar3 = (ha) haVar3.b) {
                        if (haVar3.f || ((p83) haVar3.c) == null || !haVar3.d) {
                        }
                    }
                    it10.remove();
                    cy2Var2.getName();
                }
                ha haVarG = cy2Var2.Y;
                if (haVarG != null) {
                    haVarG = haVarG.g();
                }
                cy2Var2.Y = haVarG;
                ha haVarG2 = cy2Var2.y0;
                if (haVarG2 != null) {
                    haVarG2 = haVarG2.g();
                }
                cy2Var2.y0 = haVarG2;
                ha haVarG3 = cy2Var2.z0;
                if (haVarG3 != null) {
                    haVarG3 = haVarG3.g();
                }
                cy2Var2.z0 = haVarG3;
                ha haVarG4 = cy2Var2.Z;
                if (haVarG4 != null) {
                    haVarG4 = haVarG4.g();
                }
                cy2Var2.Z = haVarG4;
                if (!cy2Var2.a()) {
                    cy2Var2.getName();
                }
            }
        }
        boolean zF2 = bt3Var.f(ah2.INFER_PROPERTY_MUTATORS);
        for (cy2 cy2Var3 : linkedHashMap.values()) {
            cy2Var3.getClass();
            cu2 cu2Var2 = cy2Var3.z;
            m62 m62Var = m62.b;
            if (cu2Var2 != null) {
                ha haVar4 = cy2Var3.y0;
                if ((haVar4 == null || (m62VarR2 = cu2Var2.r((c9) haVar4.g)) == null || m62VarR2 == m62Var) && (((haVar = cy2Var3.Y) == null || (m62VarR2 = cu2Var2.r((c9) haVar.g)) == null || m62VarR2 == m62Var) && ((haVar2 = cy2Var3.Z) == null || (m62VarR2 = cu2Var2.r((c9) haVar2.g)) == null || m62VarR2 == m62Var))) {
                    ha haVar5 = cy2Var3.z0;
                    m62VarR2 = (haVar5 == null || (m62VarR = cu2Var2.r((c9) haVar5.g)) == null || m62VarR == m62Var) ? null : m62VarR;
                }
            }
            if (cy2Var3.f.f(ah2.INVERSE_READ_WRITE_ACCESS)) {
                m62 m62Var2 = m62.z;
                m62 m62Var3 = m62.f;
                if (m62VarR2 == m62Var3) {
                    m62VarR2 = m62Var2;
                } else if (m62VarR2 == m62Var2) {
                    m62VarR2 = m62Var3;
                }
            }
            if (m62VarR2 != null) {
                m62Var = m62VarR2;
            }
            int iOrdinal2 = m62Var.ordinal();
            if (iOrdinal2 == 1) {
                cy2Var3.z0 = null;
                cy2Var3.Z = null;
            } else if (iOrdinal2 == 2) {
                cy2Var3.y0 = null;
                cy2Var3.Y = null;
            } else if (iOrdinal2 != 3) {
                ha haVarI = cy2Var3.y0;
                if (haVarI != null) {
                    haVarI = haVarI.i();
                }
                cy2Var3.y0 = haVarI;
                ha haVarI2 = cy2Var3.Z;
                if (haVarI2 != null) {
                    haVarI2 = haVarI2.i();
                }
                cy2Var3.Z = haVarI2;
                if (!zF2 || cy2Var3.y0 == null) {
                    ha haVarI3 = cy2Var3.Y;
                    if (haVarI3 != null) {
                        haVarI3 = haVarI3.i();
                    }
                    cy2Var3.Y = haVarI3;
                    ha haVarI4 = cy2Var3.z0;
                    if (haVarI4 != null) {
                        haVarI4 = haVarI4.i();
                    }
                    cy2Var3.z0 = haVarI4;
                }
            }
        }
        Iterator it11 = linkedHashMap.entrySet().iterator();
        LinkedList<cy2> linkedList10 = null;
        while (it11.hasNext()) {
            cy2 cy2Var4 = (cy2) ((Map.Entry) it11.next()).getValue();
            Set setV = cy2.v(cy2Var4.Z, cy2.v(cy2Var4.z0, cy2.v(cy2Var4.y0, cy2.v(cy2Var4.Y, null))));
            if (setV == null) {
                setV = Collections.EMPTY_SET;
            }
            if (!setV.isEmpty()) {
                it11.remove();
                if (linkedList10 == null) {
                    linkedList10 = new LinkedList();
                }
                if (setV.size() == 1) {
                    linkedList10.add(new cy2(cy2Var4, (p83) setV.iterator().next()));
                } else {
                    HashMap map = new HashMap();
                    cy2Var4.u(setV, map, cy2Var4.Y);
                    cy2Var4.u(setV, map, cy2Var4.y0);
                    cy2Var4.u(setV, map, cy2Var4.z0);
                    cy2Var4.u(setV, map, cy2Var4.Z);
                    linkedList10.addAll(map.values());
                }
            }
        }
        if (linkedList10 != null) {
            for (cy2 cy2Var5 : linkedList10) {
                String name2 = cy2Var5.getName();
                cy2 cy2Var6 = (cy2) linkedHashMap.get(name2);
                if (cy2Var6 == null) {
                    linkedHashMap.put(name2, cy2Var5);
                } else {
                    ha haVarA = cy2Var6.Y;
                    ha haVar6 = cy2Var5.Y;
                    if (haVarA == null) {
                        haVarA = haVar6;
                    } else if (haVar6 != null) {
                        haVarA = haVarA.a(haVar6);
                    }
                    cy2Var6.Y = haVarA;
                    ha haVarA2 = cy2Var6.Z;
                    ha haVar7 = cy2Var5.Z;
                    if (haVarA2 == null) {
                        haVarA2 = haVar7;
                    } else if (haVar7 != null) {
                        haVarA2 = haVarA2.a(haVar7);
                    }
                    cy2Var6.Z = haVarA2;
                    ha haVarA3 = cy2Var6.y0;
                    ha haVar8 = cy2Var5.y0;
                    if (haVarA3 == null) {
                        haVarA3 = haVar8;
                    } else if (haVar8 != null) {
                        haVarA3 = haVarA3.a(haVar8);
                    }
                    cy2Var6.y0 = haVarA3;
                    ha haVarA4 = cy2Var6.z0;
                    ha haVar9 = cy2Var5.z0;
                    if (haVarA4 == null) {
                        haVarA4 = haVar9;
                    } else if (haVar9 != null) {
                        haVarA4 = haVarA4.a(haVar9);
                    }
                    cy2Var6.z0 = haVarA4;
                }
                List list = this.k;
                h9 h9VarF = cy2Var5.f();
                if (list != null && h9VarF != null) {
                    int size = list.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        }
                        cy2 cy2Var7 = (cy2) list.get(i10);
                        if (cy2Var7 != null && cy2Var7.f() == h9VarF) {
                            list.set(i10, cy2Var5);
                            break;
                        }
                        i10++;
                    }
                }
            }
        }
        for (c9 c9Var : w8Var.P()) {
            d(cu2Var.i(c9Var), c9Var);
        }
        for (d9 d9Var2 : w8Var.Q()) {
            if (d9Var2.V() == 1) {
                d(cu2Var.i(d9Var2), d9Var2);
            }
        }
        for (cy2 cy2Var8 : linkedHashMap.values()) {
            ha haVar10 = cy2Var8.y0;
            ha haVar11 = cy2Var8.Y;
            if (haVar10 != null) {
                cy2Var8.y0 = cy2.t(cy2Var8.y0, cy2.z(0, haVar10, haVar11, cy2Var8.Z, cy2Var8.z0));
            } else if (haVar11 != null) {
                cy2Var8.Y = cy2.t(cy2Var8.Y, cy2.z(0, haVar11, cy2Var8.Z, cy2Var8.z0));
            }
        }
        Object objN = cu2Var.n(w8Var);
        if (objN != null && (cls = (Class) objN) != q83.class) {
            if (!q83.class.isAssignableFrom(cls)) {
                i("AnnotationIntrospector returned Class %s; expected `Class<PropertyNamingStrategy>`", n50.e(cls));
                throw null;
            }
            if (n50.f(cls, bt3Var.f(ah2.CAN_OVERRIDE_ACCESS_MODIFIERS)) != null) {
                st4.n();
                return;
            }
        }
        for (cy2 cy2Var9 : linkedHashMap.values()) {
            ha haVarE = cy2Var9.Y;
            if (haVarE != null) {
                haVarE = haVarE.e();
            }
            cy2Var9.Y = haVarE;
            ha haVarE2 = cy2Var9.y0;
            if (haVarE2 != null) {
                haVarE2 = haVarE2.e();
            }
            cy2Var9.y0 = haVarE2;
            ha haVarE3 = cy2Var9.z0;
            if (haVarE3 != null) {
                haVarE3 = haVarE3.e();
            }
            cy2Var9.z0 = haVarE3;
            ha haVarE4 = cy2Var9.Z;
            if (haVarE4 != null) {
                haVarE4 = haVarE4.e();
            }
            cy2Var9.Z = haVarE4;
        }
        if (bt3Var.f(ah2.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            Iterator it12 = linkedHashMap.entrySet().iterator();
            while (it12.hasNext()) {
                ((cy2) ((Map.Entry) it12.next()).getValue()).e();
            }
        }
        Boolean boolG = cu2Var.G(w8Var);
        boolean zF3 = boolG == null ? bt3Var.f(ah2.SORT_PROPERTIES_ALPHABETICALLY) : boolG.booleanValue();
        Iterator it13 = linkedHashMap.values().iterator();
        while (true) {
            if (it13.hasNext()) {
                if (((cy2) it13.next()).i().f != null) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        String[] strArrF = cu2Var.F(w8Var);
        if (zF3 || z || this.k != null || strArrF != null) {
            int size2 = linkedHashMap.size();
            Map treeMap = zF3 ? new TreeMap() : new LinkedHashMap(size2 + size2);
            for (cy2 cy2Var10 : linkedHashMap.values()) {
                treeMap.put(cy2Var10.getName(), cy2Var10);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(size2 + size2);
            if (strArrF != null) {
                for (String name3 : strArrF) {
                    cy2 cy2Var11 = (cy2) treeMap.remove(name3);
                    if (cy2Var11 == null) {
                        Iterator it14 = linkedHashMap.values().iterator();
                        while (true) {
                            if (!it14.hasNext()) {
                                break;
                            }
                            cy2 cy2Var12 = (cy2) it14.next();
                            if (name3.equals(cy2Var12.X.b)) {
                                name3 = cy2Var12.getName();
                                cy2Var11 = cy2Var12;
                                break;
                            }
                        }
                    }
                    if (cy2Var11 != null) {
                        linkedHashMap2.put(name3, cy2Var11);
                    }
                }
            }
            if (z) {
                TreeMap treeMap2 = new TreeMap();
                Iterator it15 = treeMap.entrySet().iterator();
                while (it15.hasNext()) {
                    cy2 cy2Var13 = (cy2) ((Map.Entry) it15.next()).getValue();
                    Integer num = cy2Var13.i().f;
                    if (num != null) {
                        treeMap2.put(num, cy2Var13);
                        it15.remove();
                    }
                }
                for (cy2 cy2Var14 : treeMap2.values()) {
                    linkedHashMap2.put(cy2Var14.getName(), cy2Var14);
                }
            }
            if (this.k != null && (!zF3 || bt3Var.f(ah2.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (!zF3 || bt3Var.f(ah2.SORT_CREATOR_PROPERTIES_BY_DECLARATION_ORDER)) {
                    collectionValues = this.k;
                } else {
                    TreeMap treeMap3 = new TreeMap();
                    for (cy2 cy2Var15 : this.k) {
                        if (cy2Var15 != null) {
                            treeMap3.put(cy2Var15.getName(), cy2Var15);
                        }
                    }
                    collectionValues = treeMap3.values();
                }
                for (cy2 cy2Var16 : collectionValues) {
                    if (cy2Var16 != null) {
                        String name4 = cy2Var16.getName();
                        if (treeMap.containsKey(name4)) {
                            linkedHashMap2.put(name4, cy2Var16);
                        }
                    }
                }
            }
            linkedHashMap2.putAll(treeMap);
            linkedHashMap.clear();
            linkedHashMap.putAll(linkedHashMap2);
        }
        this.j = linkedHashMap;
        this.i = true;
    }

    public final void i(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.d + ": " + str);
    }

    public final String b(String str) {
        return str;
    }
}
