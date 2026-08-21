package defpackage;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lj0 implements qi0 {
    public final av A;
    public final n84 B0;
    public final iv1 C0;
    public int Y;
    public z14 Z;
    public final be1 b;
    public final wn1 f;
    public final lf0 z;
    public final iv1 z0;
    public final yn2 X = new yn2();
    public final w7 y0 = new w7(20);
    public final n84 A0 = new n84(new vi0(this, 1));

    public lj0(be1 be1Var, List list, wn1 wn1Var, lf0 lf0Var) {
        this.b = be1Var;
        this.f = wn1Var;
        this.z = lf0Var;
        ge0 ge0Var = null;
        this.A = new av(7, new uf(this, ge0Var, 5));
        this.z0 = new iv1(this, list);
        int i = 0;
        this.B0 = new n84(new vi0(this, i));
        this.C0 = new iv1(lf0Var, new ij0(i, this), new hj(this, ge0Var, 12));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ie0 ie0Var) {
        zi0 zi0Var;
        yn2 yn2Var;
        if (ie0Var instanceof zi0) {
            zi0Var = (zi0) ie0Var;
            int i = zi0Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                zi0Var.y0 = i - Integer.MIN_VALUE;
            } else {
                zi0Var = new zi0(this, ie0Var);
            }
        }
        Object obj = zi0Var.Y;
        int i2 = zi0Var.y0;
        if (i2 == 0) {
            n12.S(obj);
            zi0Var.A = this;
            yn2Var = this.X;
            zi0Var.X = yn2Var;
            zi0Var.y0 = 1;
            Object objG = yn2Var.g(zi0Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            yn2 yn2Var2 = zi0Var.X;
            lj0 lj0Var = zi0Var.A;
            n12.S(obj);
            yn2Var = yn2Var2;
            this = lj0Var;
        }
        try {
            int i3 = this.Y - 1;
            this.Y = i3;
            if (i3 == 0) {
                z14 z14Var = this.Z;
                if (z14Var != null) {
                    z14Var.g(null);
                }
                this.Z = null;
            }
            yn2Var.n(null);
            return xl4.a;
        } catch (Throwable th) {
            yn2Var.n(null);
            throw th;
        }
    }

    @Override // defpackage.qi0
    public final Object b(Function2 function2, hj hjVar) {
        cf0 cf0Var = hjVar.f;
        cf0Var.getClass();
        cn4 cn4Var = (cn4) cf0Var.Z(wl3.z0);
        if (cn4Var != null) {
            cn4Var.a(this);
        }
        return ji0.b0(new cn4(cn4Var, this), new uf(this, function2, null, 6), hjVar);
    }

    public final nx3 c() {
        return (nx3) this.B0.getValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:4|(1:6)(1:7))(0)|8|(8:68|(1:(1:(2:18|19))(3:20|21|22))|13|14|62|(1:64)(1:65)|66|67)(5:23|73|24|(3:26|71|27)(3:37|(1:39)(1:40)|(2:42|(2:44|(1:46))(2:53|54))(2:55|(2:57|58)(2:59|60)))|50)|47|69|48) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b3, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v0, types: [lj0] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12, types: [e42, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [lj0] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(kl2 kl2Var, ie0 ie0Var) {
        aj0 aj0Var;
        o80 o80Var;
        ?? r9;
        Object objB;
        ?? r92;
        if (ie0Var instanceof aj0) {
            aj0Var = (aj0) ie0Var;
            int i = aj0Var.z0;
            if ((i & Integer.MIN_VALUE) != 0) {
                aj0Var.z0 = i - Integer.MIN_VALUE;
            } else {
                aj0Var = new aj0(this, ie0Var);
            }
        }
        Object tk3Var = aj0Var.Z;
        int i2 = aj0Var.z0;
        boolean z = true;
        mf0 mf0Var = mf0.b;
        if (i2 != 0) {
            try {
                if (i2 != 1) {
                    if (i2 == 2) {
                        o80 o80Var2 = aj0Var.Y;
                        lj0 lj0Var = aj0Var.X;
                        kl2 kl2Var2 = (kl2) aj0Var.A;
                        n12.S(tk3Var);
                        o80Var = o80Var2;
                        r9 = lj0Var;
                        kl2Var = kl2Var2;
                    } else if (i2 != 3) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                }
                o80 o80Var3 = (o80) aj0Var.A;
                n12.S(tk3Var);
                r92 = o80Var3;
            } catch (Throwable th) {
                th = th;
                tk3Var = new tk3(th);
                r92 = this;
            }
            Throwable thA = uk3.a(tk3Var);
            if (thA == null) {
                r92.S(tk3Var);
            } else {
                r92.getClass();
                r92.S(new r80(thA, false));
            }
            return xl4.a;
        }
        n12.S(tk3Var);
        o80Var = kl2Var.b;
        try {
            j24 j24VarS = this.y0.s();
            if (j24VarS instanceof fi0) {
                Function2 function2 = kl2Var.a;
                cf0 cf0Var = kl2Var.d;
                aj0Var.A = o80Var;
                aj0Var.z0 = 1;
                try {
                    objB = c().b(new hj0((lj0) this, cf0Var, function2, (ge0) null), aj0Var);
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    this = o80Var;
                    tk3Var = new tk3(th);
                    r92 = this;
                }
            } else {
                if (!(j24VarS instanceof wd3)) {
                    z = j24VarS instanceof yk4;
                }
                if (!z) {
                    if (j24VarS instanceof qe1) {
                        throw ((qe1) j24VarS).b;
                    }
                    throw new t80();
                }
                if (j24VarS != kl2Var.c) {
                    j24VarS.getClass();
                    throw ((wd3) j24VarS).b;
                }
                aj0Var.A = kl2Var;
                aj0Var.X = this;
                aj0Var.Y = o80Var;
                aj0Var.z0 = 2;
                Object objF = f(aj0Var);
                this = this;
                if (objF == mf0Var) {
                }
            }
            return mf0Var;
        } catch (Throwable th3) {
            th = th3;
            this = o80Var;
            tk3Var = new tk3(th);
            r92 = this;
        }
        Function2 function22 = kl2Var.a;
        cf0 cf0Var2 = kl2Var.d;
        aj0Var.A = o80Var;
        aj0Var.X = null;
        aj0Var.Y = null;
        aj0Var.z0 = 3;
        objB = r9.c().b(new hj0((lj0) r9, cf0Var2, function22, (ge0) null), aj0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(ie0 ie0Var) {
        bj0 bj0Var;
        yn2 yn2Var;
        if (ie0Var instanceof bj0) {
            bj0Var = (bj0) ie0Var;
            int i = bj0Var.y0;
            if ((i & Integer.MIN_VALUE) != 0) {
                bj0Var.y0 = i - Integer.MIN_VALUE;
            } else {
                bj0Var = new bj0(this, ie0Var);
            }
        }
        Object obj = bj0Var.Y;
        int i2 = bj0Var.y0;
        int i3 = 1;
        ge0 ge0Var = null;
        if (i2 == 0) {
            n12.S(obj);
            bj0Var.A = this;
            yn2Var = this.X;
            bj0Var.X = yn2Var;
            bj0Var.y0 = 1;
            Object objG = yn2Var.g(bj0Var);
            mf0 mf0Var = mf0.b;
            if (objG == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            yn2 yn2Var2 = bj0Var.X;
            lj0 lj0Var = bj0Var.A;
            n12.S(obj);
            yn2Var = yn2Var2;
            this = lj0Var;
        }
        try {
            int i4 = this.Y + 1;
            this.Y = i4;
            if (i4 == 1) {
                this.Z = ji0.B(this.z, null, null, new wi0(this, ge0Var, i3), 3);
            }
            yn2Var.n(null);
            return xl4.a;
        } catch (Throwable th) {
            yn2Var.n(null);
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if (r1.B(r0) == r4) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(ie0 ie0Var) throws Throwable {
        cj0 cj0Var;
        int iIntValue;
        lj0 lj0Var;
        int i;
        Throwable th;
        if (ie0Var instanceof cj0) {
            cj0Var = (cj0) ie0Var;
            int i2 = cj0Var.y0;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cj0Var.y0 = i2 - Integer.MIN_VALUE;
            } else {
                cj0Var = new cj0(this, ie0Var);
            }
        }
        Object objA = cj0Var.Y;
        int i3 = cj0Var.y0;
        Object obj = mf0.b;
        try {
            if (i3 == 0) {
                n12.S(objA);
                nx3 nx3VarC = c();
                cj0Var.A = this;
                cj0Var.y0 = 1;
                objA = nx3VarC.a();
                if (objA != obj) {
                }
                return obj;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i = cj0Var.X;
                lj0Var = cj0Var.A;
                try {
                    n12.S(objA);
                    return xl4.a;
                } catch (Throwable th2) {
                    th = th2;
                    lj0Var.y0.x(new wd3(th, i));
                    throw th;
                }
            }
            this = cj0Var.A;
            n12.S(objA);
            iv1 iv1Var = this.z0;
            cj0Var.A = this;
            cj0Var.X = iIntValue;
            cj0Var.y0 = 2;
        } catch (Throwable th3) {
            lj0Var = this;
            i = iIntValue;
            th = th3;
            lj0Var.y0.x(new wd3(th, i));
            throw th;
        }
        iIntValue = ((Number) objA).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(boolean z, ge0 ge0Var) throws Throwable {
        dj0 dj0Var;
        lj0 lj0Var;
        j24 j24Var;
        lj0 lj0Var2;
        e03 e03Var;
        if (ge0Var instanceof dj0) {
            dj0Var = (dj0) ge0Var;
            int i = dj0Var.z0;
            if ((i & Integer.MIN_VALUE) != 0) {
                dj0Var.z0 = i - Integer.MIN_VALUE;
            } else {
                dj0Var = new dj0(this, ge0Var);
            }
        }
        Object objC = dj0Var.Z;
        int i2 = dj0Var.z0;
        ge0 ge0Var2 = null;
        mf0 mf0Var = mf0.b;
        if (i2 == 0) {
            n12.S(objC);
            j24 j24VarS = this.y0.s();
            if (j24VarS instanceof yk4) {
                xe.q("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                return null;
            }
            nx3 nx3VarC = c();
            dj0Var.A = this;
            dj0Var.X = j24VarS;
            dj0Var.Y = z;
            dj0Var.z0 = 1;
            Integer numA = nx3VarC.a();
            if (numA != mf0Var) {
                lj0Var = this;
                j24Var = j24VarS;
                objC = numA;
            }
            return mf0Var;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                lj0Var2 = dj0Var.A;
                n12.S(objC);
                e03Var = (e03) objC;
                j24 j24Var2 = (j24) e03Var.b;
                if (((Boolean) e03Var.f).booleanValue()) {
                }
                return j24Var2;
            }
            if (i2 != 3) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lj0Var2 = dj0Var.A;
            n12.S(objC);
            e03Var = (e03) objC;
            j24 j24Var22 = (j24) e03Var.b;
            if (((Boolean) e03Var.f).booleanValue()) {
                lj0Var2.y0.x(j24Var22);
            }
            return j24Var22;
        }
        z = dj0Var.Y;
        j24Var = dj0Var.X;
        lj0Var = dj0Var.A;
        n12.S(objC);
        int iIntValue = ((Number) objC).intValue();
        boolean z2 = j24Var instanceof fi0;
        int i3 = z2 ? j24Var.a : -1;
        if (z2 && iIntValue == i3) {
            return j24Var;
        }
        if (z) {
            nx3 nx3VarC2 = lj0Var.c();
            ej0 ej0Var = new ej0(lj0Var, null);
            dj0Var.A = lj0Var;
            dj0Var.X = null;
            dj0Var.z0 = 2;
            objC = nx3VarC2.b(ej0Var, dj0Var);
            if (objC != mf0Var) {
                lj0Var2 = lj0Var;
                e03Var = (e03) objC;
                j24 j24Var222 = (j24) e03Var.b;
                if (((Boolean) e03Var.f).booleanValue()) {
                }
                return j24Var222;
            }
        } else {
            nx3 nx3VarC3 = lj0Var.c();
            fj0 fj0Var = new fj0(lj0Var, i3, ge0Var2, 0);
            dj0Var.A = lj0Var;
            dj0Var.X = null;
            dj0Var.z0 = 3;
            objC = nx3VarC3.c(fj0Var, dj0Var);
            if (objC != mf0Var) {
                lj0Var2 = lj0Var;
                e03Var = (e03) objC;
                j24 j24Var2222 = (j24) e03Var.b;
                if (((Boolean) e03Var.f).booleanValue()) {
                }
                return j24Var2222;
            }
        }
        return mf0Var;
    }

    @Override // defpackage.qi0
    public final zf1 getData() {
        return this.A;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab A[Catch: sf0 -> 0x005e, TryCatch #1 {sf0 -> 0x005e, blocks: (B:19:0x0059, B:54:0x0108, B:24:0x0067, B:51:0x00eb, B:32:0x0084, B:40:0x00ab, B:42:0x00b1, B:36:0x008e, B:48:0x00d9), top: B:79:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149 A[Catch: all -> 0x0175, TryCatch #0 {all -> 0x0175, blocks: (B:61:0x0137, B:63:0x0149, B:64:0x0151), top: B:78:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0151 A[Catch: all -> 0x0175, TRY_LEAVE, TryCatch #0 {all -> 0x0175, blocks: (B:61:0x0137, B:63:0x0149, B:64:0x0151), top: B:78:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(boolean z, ie0 ie0Var) {
        gj0 gj0Var;
        bh3 bh3Var;
        sf0 sf0Var;
        lj0 lj0Var;
        boolean z2;
        bh3 bh3Var2;
        sf0 sf0Var2;
        Object objB;
        zg3 zg3Var;
        bh3 bh3Var3;
        Integer numA;
        lj0 lj0Var2;
        int i;
        Object obj;
        if (ie0Var instanceof gj0) {
            gj0Var = (gj0) ie0Var;
            int i2 = gj0Var.C0;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                gj0Var.C0 = i2 - Integer.MIN_VALUE;
            } else {
                gj0Var = new gj0(this, ie0Var);
            }
        }
        Object objA = gj0Var.A0;
        int i3 = gj0Var.C0;
        int i4 = 1;
        ge0 ge0Var = null;
        mf0 mf0Var = mf0.b;
        try {
        } catch (sf0 e) {
            e = e;
        }
        switch (i3) {
            case 0:
                n12.S(objA);
                if (z) {
                    gj0Var.A = this;
                    gj0Var.y0 = z;
                    gj0Var.C0 = 1;
                    objA = ((ee1) this.A0.getValue()).a(new xi0(3, (ge0) null), gj0Var);
                    if (objA != mf0Var) {
                        int iHashCode = objA == null ? objA.hashCode() : 0;
                        nx3 nx3VarC = this.c();
                        gj0Var.A = this;
                        gj0Var.X = objA;
                        gj0Var.y0 = z;
                        gj0Var.z0 = iHashCode;
                        gj0Var.C0 = 2;
                        numA = nx3VarC.a();
                        if (numA != mf0Var) {
                            lj0Var2 = this;
                            i = iHashCode;
                            obj = objA;
                            objA = numA;
                            return new fi0(i, ((Number) objA).intValue(), obj);
                        }
                    }
                } else {
                    nx3 nx3VarC2 = c();
                    gj0Var.A = this;
                    gj0Var.y0 = z;
                    gj0Var.C0 = 3;
                    objA = nx3VarC2.a();
                    if (objA != mf0Var) {
                        int iIntValue = ((Number) objA).intValue();
                        nx3 nx3VarC3 = this.c();
                        fj0 fj0Var = new fj0(this, iIntValue, ge0Var, i4);
                        gj0Var.A = this;
                        gj0Var.y0 = z;
                        gj0Var.C0 = 4;
                        objA = nx3VarC3.c(fj0Var, gj0Var);
                        if (objA == mf0Var) {
                        }
                        return (fi0) objA;
                    }
                }
                return mf0Var;
            case 1:
                z = gj0Var.y0;
                this = (lj0) gj0Var.A;
                n12.S(objA);
                if (objA == null) {
                }
                nx3 nx3VarC4 = this.c();
                gj0Var.A = this;
                gj0Var.X = objA;
                gj0Var.y0 = z;
                gj0Var.z0 = iHashCode;
                gj0Var.C0 = 2;
                numA = nx3VarC4.a();
                if (numA != mf0Var) {
                }
                return mf0Var;
            case 2:
                i = gj0Var.z0;
                z = gj0Var.y0;
                obj = gj0Var.X;
                lj0Var2 = (lj0) gj0Var.A;
                try {
                    n12.S(objA);
                    return new fi0(i, ((Number) objA).intValue(), obj);
                } catch (sf0 e2) {
                    e = e2;
                    this = lj0Var2;
                    bh3Var = new bh3();
                    wn1 wn1Var = this.f;
                    gj0Var.A = this;
                    gj0Var.X = e;
                    gj0Var.Y = bh3Var;
                    gj0Var.Z = bh3Var;
                    gj0Var.y0 = z;
                    gj0Var.C0 = 5;
                    Object objG = ((a32) wn1Var.f).g(e);
                    if (objG != mf0Var) {
                        sf0Var = e;
                        objA = objG;
                        lj0Var = this;
                        z2 = z;
                        bh3Var2 = bh3Var;
                        bh3Var2.b = objA;
                        zg3 zg3Var2 = new zg3();
                        try {
                            hj0 hj0Var = new hj0(bh3Var, lj0Var, zg3Var2, (ge0) null);
                            gj0Var.A = sf0Var;
                            gj0Var.X = bh3Var;
                            gj0Var.Y = zg3Var2;
                            gj0Var.Z = null;
                            gj0Var.C0 = 6;
                            if (z2) {
                            }
                            if (objB != mf0Var) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            sf0Var2 = sf0Var;
                            ek0.b(sf0Var2, th);
                            throw sf0Var2;
                        }
                    }
                    return mf0Var;
                }
            case 3:
                z = gj0Var.y0;
                this = (lj0) gj0Var.A;
                n12.S(objA);
                int iIntValue2 = ((Number) objA).intValue();
                nx3 nx3VarC32 = this.c();
                fj0 fj0Var2 = new fj0(this, iIntValue2, ge0Var, i4);
                gj0Var.A = this;
                gj0Var.y0 = z;
                gj0Var.C0 = 4;
                objA = nx3VarC32.c(fj0Var2, gj0Var);
                if (objA == mf0Var) {
                }
                return (fi0) objA;
            case 4:
                boolean z3 = gj0Var.y0;
                n12.S(objA);
                return (fi0) objA;
            case 5:
                z2 = gj0Var.y0;
                bh3Var2 = gj0Var.Z;
                bh3Var = (bh3) gj0Var.Y;
                sf0Var = (sf0) gj0Var.X;
                lj0Var = (lj0) gj0Var.A;
                n12.S(objA);
                bh3Var2.b = objA;
                zg3 zg3Var22 = new zg3();
                hj0 hj0Var2 = new hj0(bh3Var, lj0Var, zg3Var22, (ge0) null);
                gj0Var.A = sf0Var;
                gj0Var.X = bh3Var;
                gj0Var.Y = zg3Var22;
                gj0Var.Z = null;
                gj0Var.C0 = 6;
                if (z2) {
                    objB = lj0Var.c().b(new ni0(hj0Var2, ge0Var, i4), gj0Var);
                } else {
                    lj0Var.getClass();
                    objB = hj0Var2.g(gj0Var);
                }
                if (objB != mf0Var) {
                    zg3Var = zg3Var22;
                    bh3Var3 = bh3Var;
                    Object obj2 = bh3Var3.b;
                    return new fi0(obj2 != null ? obj2.hashCode() : 0, zg3Var.b, obj2);
                }
                return mf0Var;
            case 6:
                zg3Var = (zg3) gj0Var.Y;
                bh3Var3 = (bh3) gj0Var.X;
                sf0Var2 = (sf0) gj0Var.A;
                try {
                    n12.S(objA);
                    Object obj22 = bh3Var3.b;
                    return new fi0(obj22 != null ? obj22.hashCode() : 0, zg3Var.b, obj22);
                } catch (Throwable th2) {
                    th = th2;
                    ek0.b(sf0Var2, th);
                    throw sf0Var2;
                }
            default:
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(Object obj, boolean z, ie0 ie0Var) throws IOException {
        jj0 jj0Var;
        zg3 zg3Var;
        if (ie0Var instanceof jj0) {
            jj0Var = (jj0) ie0Var;
            int i = jj0Var.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                jj0Var.Z = i - Integer.MIN_VALUE;
            } else {
                jj0Var = new jj0(this, ie0Var);
            }
        }
        Object obj2 = jj0Var.X;
        int i2 = jj0Var.Z;
        if (i2 == 0) {
            n12.S(obj2);
            zg3 zg3Var2 = new zg3();
            ee1 ee1Var = (ee1) this.A0.getValue();
            kj0 kj0Var = new kj0(zg3Var2, this, obj, z, null);
            jj0Var.A = zg3Var2;
            jj0Var.Z = 1;
            Object objB = ee1Var.b(kj0Var, jj0Var);
            mf0 mf0Var = mf0.b;
            if (objB == mf0Var) {
                return mf0Var;
            }
            zg3Var = zg3Var2;
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            zg3Var = jj0Var.A;
            n12.S(obj2);
        }
        return new Integer(zg3Var.b);
    }
}
