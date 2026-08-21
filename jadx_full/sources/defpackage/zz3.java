package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zz3 {
    public final String a;
    public final t53 b;
    public final na3 c;
    public final Map d;
    public final fm1 e;
    public final boolean f;
    public final String g;
    public final String h;
    public final int i;
    public final ce0 j;

    public zz3(String str, t53 t53Var, na3 na3Var, HashMap map, fm1 fm1Var, boolean z) {
        t53Var.getClass();
        map.getClass();
        this.a = str;
        this.b = t53Var;
        this.c = na3Var;
        this.d = map;
        this.e = fm1Var;
        this.f = z;
        this.g = t53Var.z0;
        gm0 gm0Var = qv0.a;
        r54 r54VarD = gb4.d();
        gm0Var.getClass();
        this.j = p95.a(tj4.W(gm0Var, r54VarD));
        boolean z2 = na3Var instanceof ma3;
        Integer num = null;
        String str2 = z2 ? ((ma3) na3Var).Z : na3Var instanceof ia3 ? ((ia3) na3Var).Z : null;
        if (z2) {
            num = ((ma3) na3Var).A0;
        } else if (na3Var instanceof ia3) {
            num = ((ia3) na3Var).z0;
        }
        this.h = str2 == null ? t53Var.y0 : str2;
        this.i = num != null ? num.intValue() : t53Var.A0;
    }

    public static void a(f82 f82Var, pn0 pn0Var) {
        ConcurrentHashMap concurrentHashMap = b04.a;
        f82Var.getClass();
        pn0Var.getClass();
        b04.a.put(f82Var, pn0Var);
        Iterator it = b04.b.iterator();
        while (it.hasNext()) {
            b04.c.post(new b0(14, (ya3) it.next(), f82Var, pn0Var));
        }
    }

    public final void b(f82 f82Var, nn0 nn0Var) {
        ArrayList arrayList = a04.a;
        synchronized (arrayList) {
            arrayList.remove(this);
        }
        String name = this.c.getName();
        LinkedHashMap linkedHashMap = this.b.H0;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((na3) entry.getValue()).w().contains(name)) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap2.keySet().iterator();
        while (it.hasNext()) {
            a(new f82(this.b.b, (String) it.next(), this.c.getName()), nn0Var == null ? ln0.a : nn0Var);
        }
        fm1 fm1Var = this.e;
        String str = this.b.b;
        String name2 = this.c.getName();
        String str2 = f82Var != null ? f82Var.z : null;
        if (!ha0.w(nn0Var)) {
            nn0Var = null;
        }
        fm1Var.i(str, name2, str2, nn0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(ie0 ie0Var) {
        xz3 xz3Var;
        zz3 zz3Var;
        ConcurrentHashMap concurrentHashMap;
        String strA;
        ea3 ea3VarL;
        Object next;
        long j;
        long j2;
        if (ie0Var instanceof xz3) {
            xz3Var = (xz3) ie0Var;
            int i = xz3Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                xz3Var.Z = i - Integer.MIN_VALUE;
            } else {
                xz3Var = new xz3(this, ie0Var);
            }
        }
        Object obj = xz3Var.X;
        int i2 = xz3Var.Z;
        t53 t53Var = this.b;
        na3 na3Var = this.c;
        if (i2 == 0) {
            n12.S(obj);
            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
            Iterator it = na3Var.w().iterator();
            while (it.hasNext()) {
                f82 f82Var = new f82(t53Var.b, na3Var.getName(), (String) it.next());
                mn0 mn0Var = mn0.a;
                concurrentHashMap2.put(f82Var, mn0Var);
                a(f82Var, mn0Var);
            }
            LinkedHashSet linkedHashSetW = na3Var.w();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : linkedHashSetW) {
                Map map = this.d;
                ea3 ea3VarL2 = t53Var.l((String) obj2, map);
                if (ea3VarL2 == null || (ea3VarL2 instanceof tu0)) {
                    strA = null;
                } else {
                    String strQ = ea3VarL2.q();
                    if (strQ == null || (ea3VarL = t53Var.l(strQ, map)) == null || (strA = lb3.a(ea3VarL)) == null) {
                        strA = lb3.a(ea3VarL2);
                    }
                }
                Object arrayList = linkedHashMap.get(strA);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(strA, arrayList);
                }
                ((List) arrayList).add(obj2);
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                zz3 zz3Var2 = this;
                arrayList2.add(ji0.B(zz3Var2.j, null, null, new hd(zz3Var2, (String) entry.getKey(), (List) entry.getValue(), concurrentHashMap2, null, 14), 3));
                this = zz3Var2;
            }
            zz3Var = this;
            xz3Var.A = concurrentHashMap2;
            xz3Var.Z = 1;
            Object objP = yr2.P(arrayList2, xz3Var);
            mf0 mf0Var = mf0.b;
            if (objP == mf0Var) {
                return mf0Var;
            }
            concurrentHashMap = concurrentHashMap2;
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            concurrentHashMap = xz3Var.A;
            n12.S(obj);
            zz3Var = this;
        }
        if (na3Var instanceof ia3) {
            ia3 ia3Var = (ia3) na3Var;
            Iterator it2 = ia3Var.f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    zz3Var.b(null, null);
                    break;
                }
                f82 f82Var2 = new f82(t53Var.b, ia3Var.b, (String) it2.next());
                pn0 pn0Var = (pn0) concurrentHashMap.get(f82Var2);
                if (pn0Var instanceof nn0) {
                    zz3Var.b(f82Var2, (nn0) pn0Var);
                    break;
                }
            }
        } else {
            Set setEntrySet = concurrentHashMap.entrySet();
            setEntrySet.getClass();
            Iterator it3 = setEntrySet.iterator();
            if (it3.hasNext()) {
                next = it3.next();
                if (it3.hasNext()) {
                    Object value = ((Map.Entry) next).getValue();
                    value.getClass();
                    pn0 pn0Var2 = (pn0) value;
                    if (pn0Var2 instanceof nn0) {
                        j = ((nn0) pn0Var2).a;
                    } else if (pn0Var2 instanceof mn0) {
                        j = 9223372036854775806L;
                    } else {
                        if (!(pn0Var2 instanceof ln0)) {
                            g.d();
                            return null;
                        }
                        j = Long.MAX_VALUE;
                    }
                    do {
                        Object next2 = it3.next();
                        Object value2 = ((Map.Entry) next2).getValue();
                        value2.getClass();
                        pn0 pn0Var3 = (pn0) value2;
                        if (pn0Var3 instanceof nn0) {
                            j2 = ((nn0) pn0Var3).a;
                        } else if (pn0Var3 instanceof mn0) {
                            j2 = 9223372036854775806L;
                        } else {
                            if (!(pn0Var3 instanceof ln0)) {
                                g.d();
                                return null;
                            }
                            j2 = Long.MAX_VALUE;
                        }
                        if (j > j2) {
                            next = next2;
                            j = j2;
                        }
                    } while (it3.hasNext());
                }
            } else {
                next = null;
            }
            Map.Entry entry2 = (Map.Entry) next;
            pn0 pn0Var4 = entry2 != null ? (pn0) entry2.getValue() : null;
            if (pn0Var4 instanceof nn0) {
                zz3Var.b((f82) entry2.getKey(), (nn0) pn0Var4);
            } else {
                zz3Var.b(null, null);
            }
        }
        return xl4.a;
    }

    public final boolean d() {
        ArrayList arrayList = a04.a;
        synchronized (arrayList) {
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((zz3) it.next()).a.equals(this.a)) {
                        return false;
                    }
                }
            }
            a04.a.add(this);
            ji0.B(this.j, null, null, new mt(this, null, 18), 3);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        if (defpackage.ji0.b0(r2, r3, r6) == r9) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
    
        if (defpackage.yr2.P(r10, r6) == r9) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
    
        return r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b A[LOOP:0: B:29:0x0075->B:31:0x007b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(String str, List list, ConcurrentHashMap concurrentHashMap, ie0 ie0Var) {
        yz3 yz3Var;
        List list2;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        Iterator it;
        if (ie0Var instanceof yz3) {
            yz3Var = (yz3) ie0Var;
            int i = yz3Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                yz3Var.y0 = i - Integer.MIN_VALUE;
            } else {
                yz3Var = new yz3(this, ie0Var);
            }
        }
        yz3 yz3Var2 = yz3Var;
        Object obj = yz3Var2.Y;
        int i2 = yz3Var2.y0;
        int i3 = 10;
        ge0 ge0Var = null;
        mf0 mf0Var = mf0.b;
        if (i2 == 0) {
            n12.S(obj);
            if (this.f || str == null) {
                list2 = list;
                concurrentHashMap2 = concurrentHashMap;
                ArrayList arrayList = new ArrayList(f70.Q(10, list2));
                it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(ji0.B(this.j, null, null, new hd(this, (String) it.next(), concurrentHashMap2, ge0Var, 15), 3));
                }
                yz3Var2.A = null;
                yz3Var2.X = null;
                yz3Var2.y0 = 2;
            } else {
                try {
                    gm0 gm0Var = qv0.a;
                    pl0 pl0Var = pl0.z;
                    w53 w53Var = new w53(this, str, ge0Var, i3);
                    yz3Var2.A = list;
                    yz3Var2.X = concurrentHashMap;
                    yz3Var2.y0 = 1;
                } catch (Exception unused) {
                }
            }
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    n12.S(obj);
                    return xl4.a;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ConcurrentHashMap concurrentHashMap4 = yz3Var2.X;
            List list3 = yz3Var2.A;
            try {
                n12.S(obj);
            } catch (Exception unused2) {
            }
            concurrentHashMap3 = concurrentHashMap4;
            list2 = list3;
        }
        concurrentHashMap2 = concurrentHashMap3;
        ArrayList arrayList2 = new ArrayList(f70.Q(10, list2));
        it = list2.iterator();
        while (it.hasNext()) {
        }
        yz3Var2.A = null;
        yz3Var2.X = null;
        yz3Var2.y0 = 2;
        list2 = list;
        concurrentHashMap3 = concurrentHashMap;
        concurrentHashMap2 = concurrentHashMap3;
        ArrayList arrayList22 = new ArrayList(f70.Q(10, list2));
        it = list2.iterator();
        while (it.hasNext()) {
        }
        yz3Var2.A = null;
        yz3Var2.X = null;
        yz3Var2.y0 = 2;
    }
}
