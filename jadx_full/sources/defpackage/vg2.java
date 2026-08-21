package defpackage;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vg2 extends hd0 implements ee0 {
    public static final jx3 I0 = rj4.J0;
    public static final s52 J0 = s52.z;
    public final boolean A;
    public ke0 A0;
    public final Set B0;
    public final Set C0;
    public final Object D0;
    public final Object E0;
    public final boolean F0;
    public final l9 G0;
    public final boolean H0;
    public final nj4 X;
    public final nj4 Y;
    public final b72 Z;
    public final b72 y0;
    public final nm z;
    public final zj4 z0;

    public vg2(vg2 vg2Var, nm nmVar, b72 b72Var, b72 b72Var2, Set set, Set set2) {
        super(Map.class, 0);
        l9 l9Var = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this.B0 = set;
        this.C0 = set2;
        this.X = vg2Var.X;
        this.Y = vg2Var.Y;
        this.A = vg2Var.A;
        this.z0 = vg2Var.z0;
        this.Z = b72Var;
        this.y0 = b72Var2;
        this.A0 = z83.e;
        this.z = nmVar;
        this.D0 = vg2Var.D0;
        this.H0 = vg2Var.H0;
        this.E0 = vg2Var.E0;
        this.F0 = vg2Var.F0;
        if (set2 != null || (set != null && !set.isEmpty())) {
            l9Var = new l9(set, set2);
        }
        this.G0 = l9Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static vg2 q(Set set, Set set2, nj4 nj4Var, boolean z, ak4 ak4Var, b72 b72Var, b72 b72Var2, Object obj) {
        nj4 nj4VarY;
        nj4 nj4Var2;
        boolean z2;
        if (nj4Var == null) {
            nj4Var2 = I0;
            nj4VarY = nj4Var2;
        } else {
            nj4 nj4VarB0 = nj4Var.b0();
            nj4VarY = nj4Var.g0(Properties.class) ? rj4.J0 : nj4Var.Y();
            nj4Var2 = nj4VarB0;
        }
        if (z) {
            if (nj4VarY.L0 == Object.class) {
                z2 = false;
            }
            vg2 vg2Var = new vg2(set, set2, nj4Var2, nj4VarY, z2, ak4Var, b72Var, b72Var2);
            if (obj != null) {
                return vg2Var;
            }
            n50.w(vg2.class, vg2Var, "withFilterId");
            return new vg2(vg2Var, obj, false);
        }
        z = nj4VarY != null && Modifier.isFinal(nj4VarY.L0.getModifiers());
        z2 = z;
        vg2 vg2Var2 = new vg2(set, set2, nj4Var2, nj4VarY, z2, ak4Var, b72Var, b72Var2);
        if (obj != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012a  */
    @Override // defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b72 a(gt3 gt3Var, nm nmVar) {
        b72 b72VarD;
        b72 b72VarD2;
        b72 b72VarJ;
        nj4 nj4Var;
        Set set;
        Set set2;
        boolean zBooleanValue;
        e52 e52VarK;
        boolean z;
        vg2 vg2Var;
        t52 t52VarD;
        s52 s52Var;
        Object objB;
        Object objG;
        Boolean boolB;
        bt3 bt3Var = gt3Var.b;
        cu2 cu2VarD = bt3Var.d();
        c9 c9VarA = nmVar == null ? null : nmVar.a();
        if (c9VarA != null) {
            Object objK = cu2VarD.k(c9VarA);
            b72VarD = objK != null ? gt3Var.D(c9VarA, objK) : null;
            Object objC = cu2VarD.c(c9VarA);
            b72VarD2 = objC != null ? gt3Var.D(c9VarA, objC) : null;
            if (b72VarD2 == null) {
                b72VarD2 = this.y0;
            }
            b72VarJ = l34.j(gt3Var, nmVar, b72VarD2);
            nj4Var = this.Y;
            if (b72VarJ == null && this.A && !nj4Var.j0()) {
                b72VarJ = gt3Var.i(nj4Var, nmVar);
            }
            b72 b72Var = b72VarJ;
            if (b72VarD == null) {
                b72VarD = this.Z;
            }
            b72 b72VarK = b72VarD != null ? gt3Var.k(this.X, nmVar) : gt3Var.v(b72VarD, nmVar);
            boolean zX = false;
            Set hashSet = this.B0;
            Set hashSet2 = this.C0;
            if (c9VarA == null) {
                p52 p52VarV = cu2VarD.v(c9VarA);
                Set set3 = p52VarV.z ? Collections.EMPTY_SET : p52VarV.b;
                if (set3 != null && !set3.isEmpty()) {
                    hashSet = hashSet == null ? new HashSet() : new HashSet(hashSet);
                    Iterator it = set3.iterator();
                    while (it.hasNext()) {
                        hashSet.add((String) it.next());
                    }
                }
                Set set4 = cu2VarD.y(c9VarA).b;
                if (set4 != null) {
                    hashSet2 = hashSet2 == null ? new HashSet() : new HashSet(hashSet2);
                    Iterator it2 = set4.iterator();
                    while (it2.hasNext()) {
                        hashSet2.add((String) it2.next());
                    }
                }
                Set set5 = hashSet2;
                set2 = hashSet;
                zBooleanValue = Boolean.TRUE.equals(cu2VarD.G(c9VarA));
                set = set5;
            } else {
                set = hashSet2;
                set2 = hashSet;
                zBooleanValue = false;
            }
            e52VarK = l34.k(gt3Var, nmVar, Map.class);
            if (e52VarK != null && (boolB = e52VarK.b(b52.f)) != null) {
                zBooleanValue = boolB.booleanValue();
            }
            z = zBooleanValue;
            n50.w(vg2.class, this, "withResolved");
            vg2Var = new vg2(this, nmVar, b72VarK, b72Var, set2, set);
            if (z != vg2Var.H0) {
                vg2Var = new vg2(vg2Var, this.D0, z);
            }
            if (c9VarA != null && (objG = cu2VarD.g(c9VarA)) != null && vg2Var.D0 != objG) {
                n50.w(vg2.class, vg2Var, "withFilterId");
                vg2Var = new vg2(vg2Var, objG, vg2Var.H0);
            }
            t52VarD = nmVar == null ? nmVar.d(bt3Var, Map.class) : (t52) bt3Var.Z.f;
            if (t52VarD == null && (s52Var = t52VarD.f) != s52.X) {
                int iOrdinal = s52Var.ordinal();
                if (iOrdinal != 1) {
                    s52 s52Var2 = J0;
                    if (iOrdinal != 2) {
                        if (iOrdinal == 3) {
                            zX = true;
                            objB = s52Var2;
                        } else if (iOrdinal == 4) {
                            objB = tj4.B(nj4Var);
                            if (objB != null && objB.getClass().isArray()) {
                                objB = ji0.s(objB);
                            }
                        } else if (iOrdinal == 5) {
                            objB = gt3Var.w(t52VarD.A);
                            if (objB != null) {
                                zX = gt3Var.x(objB);
                            }
                        }
                        return vg2Var.t(objB, zX);
                    }
                    objB = nj4Var.B() ? s52Var2 : null;
                    zX = true;
                    return vg2Var.t(objB, zX);
                }
                zX = true;
                objB = null;
                return vg2Var.t(objB, zX);
            }
        }
        b72VarD = null;
        if (b72VarD2 == null) {
        }
        b72VarJ = l34.j(gt3Var, nmVar, b72VarD2);
        nj4Var = this.Y;
        if (b72VarJ == null) {
            b72VarJ = gt3Var.i(nj4Var, nmVar);
        }
        b72 b72Var2 = b72VarJ;
        if (b72VarD == null) {
        }
        b72 b72VarK2 = b72VarD != null ? gt3Var.k(this.X, nmVar) : gt3Var.v(b72VarD, nmVar);
        boolean zX2 = false;
        Set hashSet3 = this.B0;
        Set hashSet22 = this.C0;
        if (c9VarA == null) {
        }
        e52VarK = l34.k(gt3Var, nmVar, Map.class);
        if (e52VarK != null) {
            zBooleanValue = boolB.booleanValue();
        }
        z = zBooleanValue;
        n50.w(vg2.class, this, "withResolved");
        vg2Var = new vg2(this, nmVar, b72VarK2, b72Var2, set2, set);
        if (z != vg2Var.H0) {
        }
        if (c9VarA != null) {
            n50.w(vg2.class, vg2Var, "withFilterId");
            vg2Var = new vg2(vg2Var, objG, vg2Var.H0);
        }
        if (nmVar == null) {
        }
        return t52VarD == null ? vg2Var : vg2Var;
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        Map map = (Map) obj;
        if (!map.isEmpty()) {
            boolean z = this.F0;
            Object obj2 = this.E0;
            if (obj2 != null || z) {
                boolean z2 = J0 == obj2;
                b72 b72Var = this.y0;
                if (b72Var != null) {
                    for (Object obj3 : map.values()) {
                        if (obj3 == null) {
                            if (z) {
                            }
                        } else if (z2) {
                            if (!b72Var.c(gt3Var, obj3)) {
                            }
                        } else if (obj2 == null || !obj2.equals(map)) {
                        }
                    }
                } else {
                    for (Object obj4 : map.values()) {
                        if (obj4 != null) {
                            try {
                                b72 b72VarP = p(gt3Var, obj4);
                                if (z2) {
                                    if (!b72VarP.c(gt3Var, obj4)) {
                                    }
                                } else if (obj2 == null || !obj2.equals(map)) {
                                }
                            } catch (a62 unused) {
                            }
                        } else if (z) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        Map map = (Map) obj;
        i52Var.z0(map);
        s(map, i52Var, gt3Var);
        i52Var.M();
    }

    @Override // defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        Map map = (Map) obj;
        i52Var.s(map);
        e10 e10VarE = zj4Var.e(i52Var, zj4Var.d(map, g72.A));
        s(map, i52Var, gt3Var);
        zj4Var.f(i52Var, e10VarE);
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        if (this.z0 == zj4Var) {
            return this;
        }
        n50.w(vg2.class, this, "_withValueTypeSerializer");
        return new vg2(this, zj4Var, this.E0, this.F0);
    }

    public final b72 p(gt3 gt3Var, Object obj) {
        Class<?> cls = obj.getClass();
        b72 b72VarA = this.A0.A(cls);
        if (b72VarA != null) {
            return b72VarA;
        }
        nj4 nj4Var = this.Y;
        boolean zE0 = nj4Var.e0();
        ke0 ke0Var = this.A0;
        nm nmVar = this.z;
        if (zE0) {
            v62 v62VarG = ke0Var.g(gt3Var.e(nj4Var, cls), gt3Var, nmVar);
            ke0 ke0Var2 = (ke0) v62VarG.z;
            if (ke0Var != ke0Var2) {
                this.A0 = ke0Var2;
            }
            return (b72) v62VarG.f;
        }
        ke0Var.getClass();
        b72 b72VarJ = gt3Var.j(cls, nmVar);
        ke0 ke0VarN = ke0Var.n(cls, b72VarJ);
        if (ke0Var != ke0VarN) {
            this.A0 = ke0VarN;
        }
        return b72VarJ;
    }

    public final void r(Map map, i52 i52Var, gt3 gt3Var, Object obj) throws IOException {
        b72 b72Var;
        b72 b72VarP;
        boolean z = J0 == obj;
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                b72Var = gt3Var.Z;
            } else {
                l9 l9Var = this.G0;
                if (l9Var == null || !l9Var.f(key)) {
                    b72Var = this.Z;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                b72VarP = this.y0;
                if (b72VarP == null) {
                    b72VarP = p(gt3Var, value);
                }
                if (z) {
                    if (b72VarP.c(gt3Var, value)) {
                        continue;
                    } else {
                        b72Var.e(key, i52Var, gt3Var);
                        b72VarP.f(value, i52Var, gt3Var, this.z0);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    b72Var.e(key, i52Var, gt3Var);
                    b72VarP.f(value, i52Var, gt3Var, this.z0);
                }
            } else if (this.F0) {
                continue;
            } else {
                b72VarP = gt3Var.Y;
                b72Var.e(key, i52Var, gt3Var);
                try {
                    b72VarP.f(value, i52Var, gt3Var, this.z0);
                } catch (Exception e) {
                    l34.n(gt3Var, e, map, String.valueOf(key));
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x01e9 A[EXC_TOP_SPLITTER, PHI: r15
      0x01e9: PHI (r15v1 b72) = (r15v0 b72), (r15v3 b72), (r15v3 b72), (r15v3 b72) binds: [B:134:0x01cc, B:140:0x01dd, B:142:0x01e0, B:144:0x01e6] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s(Map map, i52 i52Var, gt3 gt3Var) {
        TreeMap treeMap;
        b72 b72Var;
        b72 b72VarP;
        Object key;
        Map map2 = map;
        if (map2.isEmpty()) {
            return;
        }
        boolean z = this.H0;
        Object obj = J0;
        Object obj2 = this.E0;
        boolean z2 = this.F0;
        b72 b72Var2 = this.y0;
        if (!z) {
            if (gt3Var.b.h(dt3.ORDER_MAP_ENTRIES_BY_KEYS)) {
                if (!(map2 instanceof SortedMap) && !map2.isEmpty()) {
                    Object next = map2.keySet().iterator().next();
                    if (Comparable.class.isInstance(next)) {
                        if ((map2 instanceof HashMap) && map2.containsKey(null)) {
                            treeMap = new TreeMap();
                            for (Map.Entry entry : map2.entrySet()) {
                                Object key2 = entry.getKey();
                                if (key2 == null) {
                                    Object value = entry.getValue();
                                    zs2 zs2Var = gt3Var.Z;
                                    if (value == null) {
                                        if (z2) {
                                        }
                                        try {
                                            zs2Var.e(null, i52Var, gt3Var);
                                            throw null;
                                        } catch (Exception e) {
                                            l34.n(gt3Var, e, value, "");
                                            throw null;
                                        }
                                    }
                                    b72 b72VarP2 = b72Var2 == null ? p(gt3Var, value) : b72Var2;
                                    if (obj2 == obj) {
                                        if (b72VarP2.c(gt3Var, value)) {
                                        }
                                        zs2Var.e(null, i52Var, gt3Var);
                                        throw null;
                                    }
                                    if (obj2 != null && obj2.equals(value)) {
                                    }
                                    zs2Var.e(null, i52Var, gt3Var);
                                    throw null;
                                }
                                treeMap.put(key2, entry.getValue());
                            }
                        } else {
                            treeMap = new TreeMap(map2);
                        }
                        map2 = treeMap;
                    } else if (gt3Var.b.h(dt3.FAIL_ON_ORDER_MAP_BY_INCOMPARABLE_KEY)) {
                        Class<?> cls = next == null ? Object.class : next.getClass();
                        gt3Var.z(cls, "Cannot order Map entries by key of incomparable type " + n50.e(next) + ", consider disabling `SerializationFeature.FAIL_ON_ORDER_MAP_BY_INCOMPARABLE_KEY` to simply skip sorting");
                        throw null;
                    }
                }
            }
        }
        Object obj3 = this.D0;
        if (obj3 != null) {
            l(gt3Var, obj3);
            throw null;
        }
        l9 l9Var = this.G0;
        zj4 zj4Var = this.z0;
        b72 b72Var3 = this.Z;
        if (obj2 != null || z2) {
            if (zj4Var != null) {
                r(map2, i52Var, gt3Var, obj2);
                return;
            }
            boolean z3 = obj == obj2;
            for (Map.Entry entry2 : map2.entrySet()) {
                Object key3 = entry2.getKey();
                if (key3 == null) {
                    b72Var = gt3Var.Z;
                } else if (l9Var == null || !l9Var.f(key3)) {
                    b72Var = b72Var3;
                }
                Object value2 = entry2.getValue();
                if (value2 != null) {
                    b72VarP = b72Var2 == null ? p(gt3Var, value2) : b72Var2;
                    if (z3) {
                        if (b72VarP.c(gt3Var, value2)) {
                            continue;
                        } else {
                            b72Var.e(key3, i52Var, gt3Var);
                            b72VarP.e(value2, i52Var, gt3Var);
                        }
                    } else if (obj2 == null || !obj2.equals(value2)) {
                    }
                } else if (z2) {
                    continue;
                } else {
                    b72VarP = gt3Var.Y;
                    try {
                        b72Var.e(key3, i52Var, gt3Var);
                        b72VarP.e(value2, i52Var, gt3Var);
                    } catch (Exception e2) {
                        l34.n(gt3Var, e2, map2, String.valueOf(key3));
                        throw null;
                    }
                }
            }
            return;
        }
        if (b72Var2 != null) {
            for (Map.Entry entry3 : map2.entrySet()) {
                Object key4 = entry3.getKey();
                if (l9Var == null || !l9Var.f(key4)) {
                    if (key4 == null) {
                        gt3Var.Z.e(null, i52Var, gt3Var);
                        throw null;
                    }
                    b72Var3.e(key4, i52Var, gt3Var);
                    Object value3 = entry3.getValue();
                    if (value3 == null) {
                        gt3Var.h(i52Var);
                    } else if (zj4Var == null) {
                        try {
                            b72Var2.e(value3, i52Var, gt3Var);
                        } catch (Exception e3) {
                            l34.n(gt3Var, e3, map2, String.valueOf(key4));
                            throw null;
                        }
                    } else {
                        b72Var2.f(value3, i52Var, gt3Var, zj4Var);
                    }
                }
            }
            return;
        }
        if (zj4Var != null) {
            r(map2, i52Var, gt3Var, null);
            return;
        }
        try {
            key = null;
            for (Map.Entry entry4 : map2.entrySet()) {
                try {
                    Object value4 = entry4.getValue();
                    key = entry4.getKey();
                    if (key == null) {
                        gt3Var.Z.e(null, i52Var, gt3Var);
                        throw null;
                    }
                    if (l9Var == null || !l9Var.f(key)) {
                        b72Var3.e(key, i52Var, gt3Var);
                        if (value4 == null) {
                            gt3Var.h(i52Var);
                        } else {
                            (b72Var2 == null ? p(gt3Var, value4) : b72Var2).e(value4, i52Var, gt3Var);
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    l34.n(gt3Var, e, map2, String.valueOf(key));
                    throw null;
                }
            }
        } catch (Exception e5) {
            e = e5;
            key = null;
        }
    }

    public final vg2 t(Object obj, boolean z) {
        if (obj == this.E0 && z == this.F0) {
            return this;
        }
        n50.w(vg2.class, this, "withContentInclusion");
        return new vg2(this, this.z0, obj, z);
    }

    public vg2(Set set, Set set2, nj4 nj4Var, nj4 nj4Var2, boolean z, zj4 zj4Var, b72 b72Var, b72 b72Var2) {
        super(Map.class, 0);
        l9 l9Var = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this.B0 = set;
        this.C0 = set2;
        this.X = nj4Var;
        this.Y = nj4Var2;
        this.A = z;
        this.z0 = zj4Var;
        this.Z = b72Var;
        this.y0 = b72Var2;
        this.A0 = z83.e;
        this.z = null;
        this.D0 = null;
        this.H0 = false;
        this.E0 = null;
        this.F0 = false;
        if (set2 != null || (set != null && !set.isEmpty())) {
            l9Var = new l9(set, set2);
        }
        this.G0 = l9Var;
    }

    public vg2(vg2 vg2Var, zj4 zj4Var, Object obj, boolean z) {
        super(Map.class, 0);
        this.B0 = vg2Var.B0;
        this.C0 = vg2Var.C0;
        this.X = vg2Var.X;
        this.Y = vg2Var.Y;
        this.A = vg2Var.A;
        this.z0 = zj4Var;
        this.Z = vg2Var.Z;
        this.y0 = vg2Var.y0;
        this.A0 = vg2Var.A0;
        this.z = vg2Var.z;
        this.D0 = vg2Var.D0;
        this.H0 = vg2Var.H0;
        this.E0 = obj;
        this.F0 = z;
        this.G0 = vg2Var.G0;
    }

    public vg2(vg2 vg2Var, Object obj, boolean z) {
        super(Map.class, 0);
        this.B0 = vg2Var.B0;
        this.C0 = vg2Var.C0;
        this.X = vg2Var.X;
        this.Y = vg2Var.Y;
        this.A = vg2Var.A;
        this.z0 = vg2Var.z0;
        this.Z = vg2Var.Z;
        this.y0 = vg2Var.y0;
        this.A0 = z83.e;
        this.z = vg2Var.z;
        this.D0 = obj;
        this.H0 = z;
        this.E0 = vg2Var.E0;
        this.F0 = vg2Var.F0;
        this.G0 = vg2Var.G0;
    }
}
