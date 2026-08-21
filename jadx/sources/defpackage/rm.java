package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class rm extends l34 implements ee0 {
    public static final pm[] A0;
    public final pm[] A;
    public final pm[] X;
    public final Object Y;
    public final c9 Z;
    public final wt2 y0;
    public final nj4 z;
    public final d52 z0;

    static {
        new p83("#object-ref", null);
        A0 = new pm[0];
    }

    public rm(rm rmVar, Set set, Set set2) {
        super(rmVar.b);
        this.z = rmVar.z;
        pm[] pmVarArr = rmVar.A;
        pm[] pmVarArr2 = rmVar.X;
        int length = pmVarArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = pmVarArr2 == null ? null : new ArrayList(length);
        for (int i = 0; i < length; i++) {
            pm pmVar = pmVarArr[i];
            if (!vf2.C(pmVar.f.b, set, set2)) {
                arrayList.add(pmVar);
                if (pmVarArr2 != null) {
                    arrayList2.add(pmVarArr2[i]);
                }
            }
        }
        this.A = (pm[]) arrayList.toArray(new pm[arrayList.size()]);
        this.X = arrayList2 != null ? (pm[]) arrayList2.toArray(new pm[arrayList2.size()]) : null;
        this.Z = rmVar.Z;
        this.y0 = rmVar.y0;
        this.Y = rmVar.Y;
        this.z0 = rmVar.z0;
    }

    public static final pm[] s(pm[] pmVarArr, po2 po2Var) {
        if (pmVarArr == null || pmVarArr.length == 0 || po2Var == null || po2Var == po2.b) {
            return pmVarArr;
        }
        int length = pmVarArr.length;
        pm[] pmVarArr2 = new pm[length];
        for (int i = 0; i < length; i++) {
            pm pmVar = pmVarArr[i];
            if (pmVar != null) {
                pmVarArr2[i] = pmVar.i(po2Var);
            }
        }
        return pmVarArr2;
    }

    @Override // defpackage.ee0
    public final b72 a(gt3 gt3Var, nm nmVar) throws o12 {
        d52 d52Var;
        Object obj;
        d52 d52Var2;
        int i;
        d52 d52Var3;
        wt2 wt2VarB;
        int i2;
        Object objG;
        Set set;
        Set set2;
        pm[] pmVarArr;
        Class cls;
        nj4 nj4VarB;
        vt2 vt2VarQ;
        d52 d52Var4;
        rm rmVarX = this;
        bt3 bt3Var = gt3Var.b;
        cu2 cu2VarD = bt3Var.d();
        c9 c9VarA = nmVar != null ? nmVar.a() : null;
        Class cls2 = rmVarX.b;
        e52 e52VarK = l34.k(gt3Var, nmVar, cls2);
        d52 d52Var5 = rmVarX.z0;
        if (e52VarK == null || (d52Var = e52VarK.f) == (d52Var4 = d52.b)) {
            d52Var = null;
        } else if (d52Var != d52Var4 && d52Var != d52Var5) {
            nj4 nj4Var = rmVarX.z;
            if (nj4Var.i0()) {
                int iOrdinal = d52Var.ordinal();
                if (iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 8) {
                    ((wl) bt3Var.f.f).getClass();
                    ul ulVarS = wl.S(bt3Var, nj4Var);
                    if (ulVarS == null) {
                        ulVarS = ul.d(bt3Var, nj4Var, x8.F(bt3Var, nj4Var, bt3Var));
                    }
                    return gt3Var.u(n51.q(nj4Var.L0, bt3Var, ulVarS, e52VarK), nmVar);
                }
            } else if (d52Var == d52.f && ((!(nj4Var instanceof wg2) || !Map.class.isAssignableFrom(cls2)) && Map.Entry.class.isAssignableFrom(cls2))) {
                nj4 nj4VarW = nj4Var.W(Map.Entry.class);
                nj4 nj4VarD = nj4VarW.S0.d(0);
                if (nj4VarD == null) {
                    nj4VarD = rj4.J0;
                }
                nj4 nj4Var2 = nj4VarD;
                nj4 nj4VarD2 = nj4VarW.S0.d(1);
                if (nj4VarD2 == null) {
                    nj4VarD2 = rj4.J0;
                }
                return gt3Var.u(new kg2(rmVarX.z, nj4Var2, nj4VarD2, false, null, nmVar), nmVar);
            }
        }
        pm[] pmVarArr2 = rmVarX.A;
        wt2 wt2Var = rmVarX.y0;
        if (c9VarA != null) {
            p52 p52VarV = cu2VarD.v(c9VarA);
            set = p52VarV.z ? Collections.EMPTY_SET : p52VarV.b;
            set2 = cu2VarD.y(c9VarA).b;
            vt2 vt2VarP = cu2VarD.p(c9VarA);
            if (vt2VarP == null) {
                if (wt2Var == null || (vt2VarQ = cu2VarD.q(c9VarA, null)) == null) {
                    obj = null;
                    wt2VarB = wt2Var;
                } else {
                    boolean z = vt2VarQ.e;
                    wt2VarB = z == wt2Var.c ? wt2Var : new wt2((nj4) wt2Var.b, (ft3) wt2Var.d, (m83) wt2Var.e, (b72) wt2Var.a, z);
                    obj = null;
                }
                d52Var2 = d52Var5;
                i2 = 0;
                i = 0;
                d52Var3 = d52Var;
            } else {
                vt2 vt2VarQ2 = cu2VarD.q(c9VarA, vt2VarP);
                Class cls3 = vt2VarQ2.b;
                i = 0;
                boolean z2 = vt2VarQ2.e;
                p83 p83Var = vt2VarQ2.a;
                if (cls3 == null) {
                    cls = cls2;
                    d52Var2 = d52Var5;
                    d52Var3 = d52Var;
                    nj4VarB = null;
                } else {
                    cls = cls2;
                    d52Var2 = d52Var5;
                    d52Var3 = d52Var;
                    nj4VarB = gt3Var.s().b(null, cls3, rj4.A);
                }
                gt3Var.s().getClass();
                nj4 nj4Var3 = rj4.h(nj4VarB, tt2.class)[0];
                if (cls3 == m83.class) {
                    String str = p83Var.b;
                    int length = pmVarArr2.length;
                    i2 = 0;
                    while (i2 != length) {
                        pm pmVar = pmVarArr2[i2];
                        if (str.equals(pmVar.f.b)) {
                            wt2VarB = wt2.b(pmVar.A, null, new m83(vt2VarQ2.d, pmVar), z2);
                            obj = null;
                        } else {
                            i2++;
                        }
                    }
                    gt3Var.A("Invalid Object Id definition for " + n50.t(cls) + ": cannot find property with name " + (str == null ? "[null]" : n50.c(str)));
                    throw null;
                }
                obj = null;
                wt2VarB = wt2.b(nj4Var3, p83Var, gt3Var.y(vt2VarQ2), z2);
                i2 = 0;
            }
            objG = cu2VarD.g(c9VarA);
            if (objG == null || objG.equals(rmVarX.Y)) {
                objG = obj;
            }
        } else {
            obj = null;
            d52Var2 = d52Var5;
            i = 0;
            d52Var3 = d52Var;
            wt2VarB = wt2Var;
            i2 = 0;
            objG = null;
            set = null;
            set2 = null;
        }
        if (i2 > 0) {
            pm[] pmVarArr3 = (pm[]) Arrays.copyOf(pmVarArr2, pmVarArr2.length);
            pm pmVar2 = pmVarArr3[i2];
            int i3 = i;
            System.arraycopy(pmVarArr3, i3, pmVarArr3, 1, i2);
            pmVarArr3[i3] = pmVar2;
            pm[] pmVarArr4 = rmVarX.X;
            if (pmVarArr4 == null) {
                pmVarArr = obj;
            } else {
                pm[] pmVarArr5 = (pm[]) Arrays.copyOf(pmVarArr4, pmVarArr4.length);
                pm pmVar3 = pmVarArr5[i2];
                System.arraycopy(pmVarArr5, i3, pmVarArr5, 1, i2);
                pmVarArr5[i3] = pmVar3;
                pmVarArr = pmVarArr5;
            }
            rmVarX = rmVarX.z(pmVarArr3, pmVarArr);
        }
        if (wt2VarB != null) {
            wt2 wt2Var2 = new wt2((nj4) wt2VarB.b, (ft3) wt2VarB.d, (m83) wt2VarB.e, gt3Var.p((nj4) wt2VarB.b, nmVar), wt2VarB.c);
            if (wt2Var2 != wt2Var) {
                rmVarX = rmVarX.y(wt2Var2);
            }
        }
        if ((set != null && !set.isEmpty()) || set2 != null) {
            rmVarX = rmVarX.w(set, set2);
        }
        if (objG != null) {
            rmVarX = rmVarX.x(objG);
        }
        return (d52Var3 == null ? d52Var2 : d52Var3) == d52.A ? rmVarX.r() : rmVarX;
    }

    @Override // defpackage.b72
    public void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        if (this.y0 != null) {
            o(obj, i52Var, gt3Var, zj4Var);
            return;
        }
        e10 e10VarQ = q(zj4Var, obj, g72.A);
        zj4Var.e(i52Var, e10VarQ);
        i52Var.s(obj);
        if (this.Y != null) {
            v(obj, i52Var, gt3Var);
            throw null;
        }
        u(obj, i52Var, gt3Var);
        zj4Var.f(i52Var, e10VarQ);
    }

    @Override // defpackage.b72
    public final boolean h() {
        return this.y0 != null;
    }

    public final void o(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        wt2 wt2Var = this.y0;
        m83 m83Var = (m83) wt2Var.e;
        boolean z = wt2Var.c;
        b72 b72Var = (b72) wt2Var.a;
        cy4 cy4VarL = gt3Var.l(obj, m83Var);
        if (cy4VarL.b != null && (cy4VarL.c || z)) {
            i52Var.getClass();
            b72Var.e(cy4VarL.b, i52Var, gt3Var);
            return;
        }
        Object objA = cy4VarL.a(obj);
        if (z) {
            b72Var.e(objA, i52Var, gt3Var);
            return;
        }
        e10 e10VarQ = q(zj4Var, obj, g72.A);
        zj4Var.e(i52Var, e10VarQ);
        i52Var.s(obj);
        cy4VarL.c = true;
        ft3 ft3Var = (ft3) wt2Var.d;
        if (ft3Var != null) {
            i52Var.N(ft3Var);
            b72Var.e(cy4VarL.b, i52Var, gt3Var);
        }
        if (this.Y != null) {
            v(obj, i52Var, gt3Var);
            throw null;
        }
        u(obj, i52Var, gt3Var);
        zj4Var.f(i52Var, e10VarQ);
    }

    public final void p(Object obj, i52 i52Var, gt3 gt3Var, boolean z) {
        wt2 wt2Var = this.y0;
        m83 m83Var = (m83) wt2Var.e;
        boolean z2 = wt2Var.c;
        b72 b72Var = (b72) wt2Var.a;
        cy4 cy4VarL = gt3Var.l(obj, m83Var);
        Object obj2 = cy4VarL.b;
        if (obj2 != null && (cy4VarL.c || z2)) {
            b72Var.e(obj2, i52Var, gt3Var);
            return;
        }
        Object objA = cy4VarL.a(obj);
        if (z2) {
            b72Var.e(objA, i52Var, gt3Var);
            return;
        }
        if (z) {
            i52Var.z0(obj);
        }
        cy4VarL.c = true;
        ft3 ft3Var = (ft3) wt2Var.d;
        if (ft3Var != null) {
            i52Var.N(ft3Var);
            b72Var.e(cy4VarL.b, i52Var, gt3Var);
        }
        if (this.Y != null) {
            v(obj, i52Var, gt3Var);
            throw null;
        }
        u(obj, i52Var, gt3Var);
        if (z) {
            i52Var.M();
        }
    }

    public final e10 q(zj4 zj4Var, Object obj, g72 g72Var) {
        c9 c9Var = this.Z;
        if (c9Var == null) {
            return zj4Var.d(obj, g72Var);
        }
        Object objR = c9Var.R(obj);
        if (objR == null) {
            objR = "";
        }
        e10 e10VarD = zj4Var.d(obj, g72Var);
        e10VarD.X = objR;
        return e10VarD;
    }

    public abstract rm r();

    /* JADX WARN: Removed duplicated region for block: B:39:0x0069 A[PHI: r6
      0x0069: PHI (r6v5 nj4) = (r6v4 nj4), (r6v10 nj4) binds: [B:31:0x0049, B:33:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(defpackage.gt3 r10) {
        /*
            r9 = this;
            r0 = 0
            pm[] r1 = r9.X
            if (r1 != 0) goto L7
            r2 = r0
            goto L8
        L7:
            int r2 = r1.length
        L8:
            pm[] r9 = r9.A
            int r3 = r9.length
            r4 = r0
        Lc:
            if (r4 >= r3) goto L98
            r5 = r9[r4]
            boolean r6 = r5.E0
            c9 r7 = r5.Z
            if (r6 != 0) goto L2b
            b72 r6 = r5.B0
            if (r6 == 0) goto L1b
            goto L2b
        L1b:
            b72 r6 = r10.Y
            if (r6 == 0) goto L2b
            r5.f(r6)
            if (r4 >= r2) goto L2b
            r8 = r1[r4]
            if (r8 == 0) goto L2b
            r8.f(r6)
        L2b:
            b72 r6 = r5.A0
            if (r6 == 0) goto L30
            goto L94
        L30:
            bt3 r6 = r10.b
            cu2 r6 = r6.d()
            if (r7 == 0) goto L47
            java.lang.Object r6 = r6.E(r7)
            if (r6 != 0) goto L3f
            goto L47
        L3f:
            r10.f(r6)
            r10.s()
            r9 = 0
            throw r9
        L47:
            nj4 r6 = r5.X
            if (r6 != 0) goto L69
            nj4 r6 = r5.A
            java.lang.Class r7 = r6.L0
            int r7 = r7.getModifiers()
            boolean r7 = java.lang.reflect.Modifier.isFinal(r7)
            if (r7 != 0) goto L69
            boolean r7 = r6.h0()
            if (r7 != 0) goto L66
            qj4 r7 = r6.S0
            nj4[] r7 = r7.f
            int r7 = r7.length
            if (r7 <= 0) goto L94
        L66:
            r5.Y = r6
            goto L94
        L69:
            b72 r7 = r10.p(r6, r5)
            boolean r8 = r6.h0()
            if (r8 == 0) goto L87
            nj4 r6 = r6.Y()
            java.lang.Object r6 = r6.O0
            zj4 r6 = (defpackage.zj4) r6
            if (r6 == 0) goto L87
            boolean r8 = r7 instanceof defpackage.hd0
            if (r8 == 0) goto L87
            hd0 r7 = (defpackage.hd0) r7
            hd0 r7 = r7.o(r6)
        L87:
            if (r4 >= r2) goto L91
            r6 = r1[r4]
            if (r6 == 0) goto L91
            r6.g(r7)
            goto L94
        L91:
            r5.g(r7)
        L94:
            int r4 = r4 + 1
            goto Lc
        L98:
            int r1 = r9.length
            if (r0 >= r1) goto Lbc
            r1 = r9[r0]
            boolean r2 = r1 instanceof defpackage.r9
            if (r2 == 0) goto Lb9
            r9 r1 = (defpackage.r9) r1
            b72 r2 = r1.K0
            boolean r3 = r2 instanceof defpackage.ee0
            if (r3 == 0) goto Lb9
            l9 r3 = r1.I0
            b72 r2 = r10.u(r2, r3)
            r1.K0 = r2
            boolean r3 = r2 instanceof defpackage.vg2
            if (r3 == 0) goto Lb9
            vg2 r2 = (defpackage.vg2) r2
            r1.L0 = r2
        Lb9:
            int r0 = r0 + 1
            goto L98
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rm.t(gt3):void");
    }

    public final void u(Object obj, i52 i52Var, gt3 gt3Var) {
        if (this.X != null) {
            gt3Var.getClass();
        }
        pm[] pmVarArr = this.A;
        int i = 0;
        try {
            int length = pmVarArr.length;
            while (i < length) {
                pm pmVar = pmVarArr[i];
                if (pmVar != null) {
                    pmVar.k(obj, i52Var, gt3Var);
                }
                i++;
            }
        } catch (Exception e) {
            l34.n(gt3Var, e, obj, i != pmVarArr.length ? pmVarArr[i].f.b : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            a62 a62Var = new a62(i52Var, "Infinite recursion (StackOverflowError)", e2);
            z52 z52Var = new z52(obj, i != pmVarArr.length ? pmVarArr[i].f.b : "[anySetter]");
            LinkedList linkedList = a62Var.b;
            if (linkedList == null) {
                linkedList = new LinkedList();
                a62Var.b = linkedList;
            }
            if (linkedList.size() >= 1000) {
                throw a62Var;
            }
            a62Var.b.addFirst(z52Var);
            throw a62Var;
        }
    }

    public final void v(Object obj, i52 i52Var, gt3 gt3Var) {
        if (this.X != null) {
            gt3Var.getClass();
        }
        l(gt3Var, this.Y);
        throw null;
    }

    public abstract rm w(Set set, Set set2);

    public abstract rm x(Object obj);

    public abstract rm y(wt2 wt2Var);

    public abstract rm z(pm[] pmVarArr, pm[] pmVarArr2);

    public rm(rm rmVar, pm[] pmVarArr, pm[] pmVarArr2) {
        super(rmVar.b);
        this.z = rmVar.z;
        this.A = pmVarArr;
        this.X = pmVarArr2;
        this.Z = rmVar.Z;
        this.y0 = rmVar.y0;
        this.Y = rmVar.Y;
        this.z0 = rmVar.z0;
    }

    public rm(rm rmVar, wt2 wt2Var, Object obj) {
        super(rmVar.b);
        this.z = rmVar.z;
        this.A = rmVar.A;
        this.X = rmVar.X;
        this.Z = rmVar.Z;
        this.y0 = wt2Var;
        this.Y = obj;
        this.z0 = rmVar.z0;
    }

    public rm(nj4 nj4Var, r90 r90Var, pm[] pmVarArr, pm[] pmVarArr2) {
        super(nj4Var);
        this.z = nj4Var;
        this.A = pmVarArr;
        this.X = pmVarArr2;
        this.Z = (c9) r90Var.f;
        this.Y = r90Var.e;
        this.y0 = (wt2) r90Var.g;
        this.z0 = ((ul) r90Var.a).b().f;
    }
}
