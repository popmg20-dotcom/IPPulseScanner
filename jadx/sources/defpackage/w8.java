package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.ed4 O() {
        /*
            Method dump skipped, instruction units count: 924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w8.O():ed4");
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
