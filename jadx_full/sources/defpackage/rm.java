package defpackage;

import java.lang.reflect.Modifier;
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
    */
    public final void t(gt3 gt3Var) {
        pm pmVar;
        zj4 zj4Var;
        Object objE;
        b72 b72Var;
        pm pmVar2;
        pm[] pmVarArr = this.X;
        int length = pmVarArr == null ? 0 : pmVarArr.length;
        pm[] pmVarArr2 = this.A;
        int length2 = pmVarArr2.length;
        for (int i = 0; i < length2; i++) {
            pm pmVar3 = pmVarArr2[i];
            boolean z = pmVar3.E0;
            c9 c9Var = pmVar3.Z;
            if (!z && pmVar3.B0 == null && (b72Var = gt3Var.Y) != null) {
                pmVar3.f(b72Var);
                if (i < length && (pmVar2 = pmVarArr[i]) != null) {
                    pmVar2.f(b72Var);
                }
            }
            if (pmVar3.A0 == null) {
                cu2 cu2VarD = gt3Var.b.d();
                if (c9Var != null && (objE = cu2VarD.E(c9Var)) != null) {
                    gt3Var.f(objE);
                    gt3Var.s();
                    throw null;
                }
                nj4 nj4Var = pmVar3.X;
                if (nj4Var == null) {
                    nj4Var = pmVar3.A;
                    if (Modifier.isFinal(nj4Var.L0.getModifiers())) {
                        b72 b72VarP = gt3Var.p(nj4Var, pmVar3);
                        if (nj4Var.h0() && (zj4Var = (zj4) nj4Var.Y().O0) != null && (b72VarP instanceof hd0)) {
                            b72VarP = ((hd0) b72VarP).o(zj4Var);
                        }
                        if (i >= length || (pmVar = pmVarArr[i]) == null) {
                            pmVar3.g(b72VarP);
                        } else {
                            pmVar.g(b72VarP);
                        }
                    } else if (nj4Var.h0() || nj4Var.S0.f.length > 0) {
                        pmVar3.Y = nj4Var;
                    }
                }
            }
        }
        for (pm pmVar4 : pmVarArr2) {
            if (pmVar4 instanceof r9) {
                r9 r9Var = (r9) pmVar4;
                b72 b72Var2 = r9Var.K0;
                if (b72Var2 instanceof ee0) {
                    b72 b72VarU = gt3Var.u(b72Var2, r9Var.I0);
                    r9Var.K0 = b72VarU;
                    if (b72VarU instanceof vg2) {
                        r9Var.L0 = (vg2) b72VarU;
                    }
                }
            }
        }
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
