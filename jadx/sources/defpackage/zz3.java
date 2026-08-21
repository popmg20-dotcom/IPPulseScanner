package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(defpackage.ie0 r14) {
        /*
            Method dump skipped, instruction units count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zz3.c(ie0):java.lang.Object");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.String r13, java.util.List r14, j$.util.concurrent.ConcurrentHashMap r15, defpackage.ie0 r16) {
        /*
            r12 = this;
            r2 = r16
            boolean r3 = r2 instanceof defpackage.yz3
            if (r3 == 0) goto L16
            r3 = r2
            yz3 r3 = (defpackage.yz3) r3
            int r4 = r3.y0
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L16
            int r4 = r4 - r5
            r3.y0 = r4
        L14:
            r6 = r3
            goto L1c
        L16:
            yz3 r3 = new yz3
            r3.<init>(r12, r2)
            goto L14
        L1c:
            java.lang.Object r2 = r6.Y
            int r3 = r6.y0
            r4 = 10
            r7 = 2
            r5 = 1
            r8 = 0
            mf0 r9 = defpackage.mf0.b
            if (r3 == 0) goto L43
            if (r3 == r5) goto L39
            if (r3 != r7) goto L32
            defpackage.n12.S(r2)
            goto La4
        L32:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r0)
            r0 = 0
            return r0
        L39:
            j$.util.concurrent.ConcurrentHashMap r0 = r6.X
            java.util.List r3 = r6.A
            defpackage.n12.S(r2)     // Catch: java.lang.Exception -> L40
        L40:
            r10 = r0
            r0 = r3
            goto L64
        L43:
            defpackage.n12.S(r2)
            boolean r2 = r12.f
            if (r2 != 0) goto L66
            if (r13 == 0) goto L66
            gm0 r2 = defpackage.qv0.a     // Catch: java.lang.Exception -> L62
            pl0 r2 = defpackage.pl0.z     // Catch: java.lang.Exception -> L62
            w53 r3 = new w53     // Catch: java.lang.Exception -> L62
            r3.<init>(r12, r13, r8, r4)     // Catch: java.lang.Exception -> L62
            r6.A = r14     // Catch: java.lang.Exception -> L62
            r6.X = r15     // Catch: java.lang.Exception -> L62
            r6.y0 = r5     // Catch: java.lang.Exception -> L62
            java.lang.Object r2 = defpackage.ji0.b0(r2, r3, r6)     // Catch: java.lang.Exception -> L62
            if (r2 != r9) goto L62
            goto La3
        L62:
            r0 = r14
            r10 = r15
        L64:
            r3 = r10
            goto L68
        L66:
            r0 = r14
            r3 = r15
        L68:
            java.util.ArrayList r10 = new java.util.ArrayList
            int r2 = defpackage.f70.Q(r4, r0)
            r10.<init>(r2)
            java.util.Iterator r11 = r0.iterator()
        L75:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L96
            java.lang.Object r0 = r11.next()
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            hd r0 = new hd
            r5 = 15
            r1 = r12
            r4 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r2 = 3
            ce0 r5 = r12.j
            z14 r0 = defpackage.ji0.B(r5, r4, r4, r0, r2)
            r10.add(r0)
            goto L75
        L96:
            r4 = r8
            r6.A = r4
            r6.X = r4
            r6.y0 = r7
            java.lang.Object r0 = defpackage.yr2.P(r10, r6)
            if (r0 != r9) goto La4
        La3:
            return r9
        La4:
            xl4 r0 = defpackage.xl4.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zz3.e(java.lang.String, java.util.List, j$.util.concurrent.ConcurrentHashMap, ie0):java.lang.Object");
    }
}
