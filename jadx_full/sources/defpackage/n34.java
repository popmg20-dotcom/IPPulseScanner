package defpackage;

import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n34 {
    public k72 a;
    public j72 b;
    public String c;
    public sj4 d;

    public final ak4 a(bt3 bt3Var, nj4 nj4Var, ArrayList arrayList) {
        int iLastIndexOf;
        nm nmVar = null;
        if (this.a == k72.NONE || nj4Var.L0.isPrimitive()) {
            return null;
        }
        if (this.a == k72.DEDUCTION) {
            return te.d;
        }
        rj4 rj4Var = bt3Var.f.b;
        bt3Var.f(ah2.BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES);
        sj4 i50Var = this.d;
        int i = 2;
        int i2 = 1;
        if (i50Var == null) {
            k72 k72Var = this.a;
            if (k72Var == null) {
                xe.q("Cannot build, 'init()' not yet called");
                return null;
            }
            int iOrdinal = k72Var.ordinal();
            if (iOrdinal == 0) {
                i50Var = null;
            } else if (iOrdinal == 1) {
                i50Var = new i50(nj4Var, rj4Var, arrayList);
            } else if (iOrdinal == 2) {
                i50Var = new im2(nj4Var, rj4Var, arrayList);
            } else if (iOrdinal == 3) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                bt3Var.f(ah2.ACCEPT_CASE_INSENSITIVE_VALUES);
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        uo2 uo2Var = (uo2) it.next();
                        Class cls = uo2Var.b;
                        String name = uo2Var.z;
                        if (name == null && (iLastIndexOf = (name = cls.getName()).lastIndexOf(46)) >= 0) {
                            name = name.substring(iLastIndexOf + 1);
                        }
                        concurrentHashMap.put(cls.getName(), name);
                    }
                }
                i50Var = new vj4(bt3Var, nj4Var, concurrentHashMap, null);
            } else if (iOrdinal != 4) {
                if (iOrdinal != 5) {
                    zo2.v(this.a, "Do not know how to construct standard type id resolver for idType: ");
                    return null;
                }
                i50Var = new i50(nj4Var, rj4Var, arrayList);
            } else {
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                bt3Var.f(ah2.ACCEPT_CASE_INSENSITIVE_VALUES);
                if (arrayList != null) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        uo2 uo2Var2 = (uo2) it2.next();
                        Class cls2 = uo2Var2.b;
                        String name2 = uo2Var2.z;
                        if (name2 == null) {
                            name2 = cls2.getName();
                            int iMax = Math.max(name2.lastIndexOf(46), name2.lastIndexOf(36));
                            if (iMax >= 0) {
                                name2 = name2.substring(iMax + 1);
                            }
                        }
                        concurrentHashMap2.put(cls2.getName(), name2);
                    }
                }
                i50Var = new ex3(bt3Var, nj4Var, concurrentHashMap2, null);
            }
        }
        int iOrdinal2 = this.b.ordinal();
        if (iOrdinal2 == 0) {
            return new we(i50Var, null, this.c);
        }
        if (iOrdinal2 == 1) {
            return new te(i50Var, nmVar, i);
        }
        if (iOrdinal2 == 2) {
            return new te(i50Var, nmVar, i2);
        }
        if (iOrdinal2 == 3) {
            return new ve(i50Var, null, this.c);
        }
        if (iOrdinal2 == 4) {
            return new ue(i50Var, null, this.c);
        }
        zo2.v(this.b, "Do not know how to construct standard type serializer for inclusion type: ");
        return null;
    }

    public final void b(m72 m72Var) {
        k72 k72Var = m72Var.b;
        Objects.requireNonNull(k72Var);
        this.a = k72Var;
        this.b = m72Var.f;
        String str = m72Var.z;
        if (str == null || str.isEmpty()) {
            str = k72Var.b;
        }
        this.c = str;
    }
}
