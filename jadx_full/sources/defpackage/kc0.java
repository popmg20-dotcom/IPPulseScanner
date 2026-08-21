package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kc0 extends jc0 {
    public p20[] A0;
    public p20[] B0;
    public int C0;
    public boolean D0;
    public boolean E0;
    public WeakReference F0;
    public WeakReference G0;
    public WeakReference H0;
    public WeakReference I0;
    public final HashSet J0;
    public final zl K0;
    public ArrayList p0 = new ArrayList();
    public final ed4 q0 = new ed4(this);
    public final no0 r0;
    public int s0;
    public rb0 t0;
    public boolean u0;
    public final gb2 v0;
    public int w0;
    public int x0;
    public int y0;
    public int z0;

    public kc0() {
        no0 no0Var = new no0();
        no0Var.b = true;
        no0Var.c = true;
        no0Var.f = new ArrayList();
        new ArrayList();
        no0Var.h = null;
        no0Var.i = new zl();
        no0Var.g = new ArrayList();
        no0Var.d = this;
        no0Var.e = this;
        this.r0 = no0Var;
        this.t0 = null;
        this.u0 = false;
        this.v0 = new gb2();
        this.y0 = 0;
        this.z0 = 0;
        this.A0 = new p20[4];
        this.B0 = new p20[4];
        this.C0 = 257;
        this.D0 = false;
        this.E0 = false;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = new HashSet();
        this.K0 = new zl();
    }

    public static void R(jc0 jc0Var, rb0 rb0Var, zl zlVar) {
        int i;
        int i2;
        if (rb0Var == null) {
            return;
        }
        int i3 = jc0Var.f0;
        int[] iArr = jc0Var.t;
        if (i3 == 8 || (jc0Var instanceof nq1) || (jc0Var instanceof wj)) {
            zlVar.e = 0;
            zlVar.f = 0;
            return;
        }
        int[] iArr2 = jc0Var.o0;
        zlVar.a = iArr2[0];
        zlVar.b = iArr2[1];
        zlVar.c = jc0Var.o();
        zlVar.d = jc0Var.i();
        zlVar.i = false;
        zlVar.j = 0;
        boolean z = zlVar.a == 3;
        boolean z2 = zlVar.b == 3;
        boolean z3 = z && jc0Var.V > 0.0f;
        boolean z4 = z2 && jc0Var.V > 0.0f;
        if (z && jc0Var.r(0) && jc0Var.r == 0 && !z3) {
            zlVar.a = 2;
            if (z2 && jc0Var.s == 0) {
                zlVar.a = 1;
            }
            z = false;
        }
        if (z2 && jc0Var.r(1) && jc0Var.s == 0 && !z4) {
            zlVar.b = 2;
            if (z && jc0Var.r == 0) {
                zlVar.b = 1;
            }
            z2 = false;
        }
        if (jc0Var.y()) {
            zlVar.a = 1;
            z = false;
        }
        if (jc0Var.z()) {
            zlVar.b = 1;
            z2 = false;
        }
        if (z3) {
            if (iArr[0] == 4) {
                zlVar.a = 1;
            } else if (!z2) {
                if (zlVar.b == 1) {
                    i2 = zlVar.d;
                } else {
                    zlVar.a = 2;
                    rb0Var.b(jc0Var, zlVar);
                    i2 = zlVar.f;
                }
                zlVar.a = 1;
                zlVar.c = (int) (jc0Var.V * i2);
            }
        }
        if (z4) {
            if (iArr[1] == 4) {
                zlVar.b = 1;
            } else if (!z) {
                if (zlVar.a == 1) {
                    i = zlVar.c;
                } else {
                    zlVar.b = 2;
                    rb0Var.b(jc0Var, zlVar);
                    i = zlVar.e;
                }
                zlVar.b = 1;
                int i4 = jc0Var.W;
                float f = jc0Var.V;
                if (i4 == -1) {
                    zlVar.d = (int) (i / f);
                } else {
                    zlVar.d = (int) (f * i);
                }
            }
        }
        rb0Var.b(jc0Var, zlVar);
        jc0Var.K(zlVar.e);
        jc0Var.H(zlVar.f);
        jc0Var.E = zlVar.h;
        int i5 = zlVar.g;
        jc0Var.Z = i5;
        jc0Var.E = i5 > 0;
        zlVar.j = 0;
    }

    @Override // defpackage.jc0
    public final void A() {
        this.v0.t();
        this.w0 = 0;
        this.x0 = 0;
        this.p0.clear();
        super.A();
    }

    @Override // defpackage.jc0
    public final void C(ed4 ed4Var) {
        super.C(ed4Var);
        int size = this.p0.size();
        for (int i = 0; i < size; i++) {
            ((jc0) this.p0.get(i)).C(ed4Var);
        }
    }

    @Override // defpackage.jc0
    public final void L(boolean z, boolean z2) {
        super.L(z, z2);
        int size = this.p0.size();
        for (int i = 0; i < size; i++) {
            ((jc0) this.p0.get(i)).L(z, z2);
        }
    }

    public final void N(jc0 jc0Var, int i) {
        if (i == 0) {
            int i2 = this.y0 + 1;
            p20[] p20VarArr = this.B0;
            if (i2 >= p20VarArr.length) {
                p20VarArr = (p20[]) Arrays.copyOf(p20VarArr, p20VarArr.length * 2);
                this.B0 = p20VarArr;
            }
            int i3 = this.y0;
            p20VarArr[i3] = new p20(jc0Var, 0, this.u0);
            this.y0 = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.z0 + 1;
            p20[] p20VarArr2 = this.A0;
            if (i4 >= p20VarArr2.length) {
                p20VarArr2 = (p20[]) Arrays.copyOf(p20VarArr2, p20VarArr2.length * 2);
                this.A0 = p20VarArr2;
            }
            int i5 = this.z0;
            p20VarArr2[i5] = new p20(jc0Var, 1, this.u0);
            this.z0 = i5 + 1;
        }
    }

    public final void O(gb2 gb2Var) {
        kc0 kc0Var;
        gb2 gb2Var2;
        boolean zS = S(64);
        b(gb2Var, zS);
        int size = this.p0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            jc0 jc0Var = (jc0) this.p0.get(i);
            boolean[] zArr = jc0Var.R;
            zArr[0] = false;
            zArr[1] = false;
            if (jc0Var instanceof wj) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                jc0 jc0Var2 = (jc0) this.p0.get(i2);
                if (jc0Var2 instanceof wj) {
                    wj wjVar = (wj) jc0Var2;
                    for (int i3 = 0; i3 < wjVar.q0; i3++) {
                        jc0 jc0Var3 = wjVar.p0[i3];
                        if (wjVar.s0 || jc0Var3.c()) {
                            int i4 = wjVar.r0;
                            if (i4 == 0 || i4 == 1) {
                                jc0Var3.R[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                jc0Var3.R[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.J0;
        hashSet.clear();
        for (int i5 = 0; i5 < size; i5++) {
            jc0 jc0Var4 = (jc0) this.p0.get(i5);
            jc0Var4.getClass();
            if (jc0Var4 instanceof nq1) {
                jc0Var4.b(gb2Var, zS);
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            if (it.hasNext()) {
                ((jc0) it.next()).getClass();
                st4.n();
                return;
            } else if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((jc0) it2.next()).b(gb2Var, zS);
                }
                hashSet.clear();
            }
        }
        if (gb2.q) {
            HashSet<jc0> hashSet2 = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                jc0 jc0Var5 = (jc0) this.p0.get(i6);
                jc0Var5.getClass();
                if (!(jc0Var5 instanceof nq1)) {
                    hashSet2.add(jc0Var5);
                }
            }
            kc0Var = this;
            gb2Var2 = gb2Var;
            kc0Var.a(this, gb2Var2, hashSet2, this.o0[0] == 2 ? 0 : 1, false);
            for (jc0 jc0Var6 : hashSet2) {
                ye.e(kc0Var, gb2Var2, jc0Var6);
                jc0Var6.b(gb2Var2, zS);
            }
        } else {
            kc0Var = this;
            gb2Var2 = gb2Var;
            for (int i7 = 0; i7 < size; i7++) {
                jc0 jc0Var7 = (jc0) kc0Var.p0.get(i7);
                if (jc0Var7 instanceof kc0) {
                    int[] iArr = jc0Var7.o0;
                    int i8 = iArr[0];
                    int i9 = iArr[1];
                    if (i8 == 2) {
                        jc0Var7.I(1);
                    }
                    if (i9 == 2) {
                        jc0Var7.J(1);
                    }
                    jc0Var7.b(gb2Var2, zS);
                    if (i8 == 2) {
                        jc0Var7.I(i8);
                    }
                    if (i9 == 2) {
                        jc0Var7.J(i9);
                    }
                } else {
                    ye.e(kc0Var, gb2Var2, jc0Var7);
                    if (!(jc0Var7 instanceof nq1)) {
                        jc0Var7.b(gb2Var2, zS);
                    }
                }
            }
        }
        if (kc0Var.y0 > 0) {
            n12.b(kc0Var, gb2Var2, null, 0);
        }
        if (kc0Var.z0 > 0) {
            n12.b(kc0Var, gb2Var2, null, 1);
        }
    }

    public final boolean P(int i, boolean z) {
        boolean z2;
        no0 no0Var = this.r0;
        ArrayList<nt4> arrayList = (ArrayList) no0Var.f;
        kc0 kc0Var = (kc0) no0Var.d;
        boolean z3 = false;
        int iH = kc0Var.h(0);
        int iH2 = kc0Var.h(1);
        int iP = kc0Var.p();
        int iQ = kc0Var.q();
        if (z && (iH == 2 || iH2 == 2)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                nt4 nt4Var = (nt4) it.next();
                if (nt4Var.f == i && !nt4Var.k()) {
                    z = false;
                    break;
                }
            }
            if (i == 0) {
                if (z && iH == 2) {
                    kc0Var.I(1);
                    kc0Var.K(no0Var.d(kc0Var, 0));
                    kc0Var.d.e.d(kc0Var.o());
                }
            } else if (z && iH2 == 2) {
                kc0Var.J(1);
                kc0Var.H(no0Var.d(kc0Var, 1));
                kc0Var.e.e.d(kc0Var.i());
            }
        }
        int[] iArr = kc0Var.o0;
        if (i == 0) {
            int i2 = iArr[0];
            if (i2 == 1 || i2 == 4) {
                int iO = kc0Var.o() + iP;
                kc0Var.d.i.d(iO);
                kc0Var.d.e.d(iO - iP);
                z2 = true;
            }
            z2 = false;
        } else {
            int i3 = iArr[1];
            if (i3 == 1 || i3 == 4) {
                int i4 = kc0Var.i() + iQ;
                kc0Var.e.i.d(i4);
                kc0Var.e.e.d(i4 - iQ);
                z2 = true;
            }
            z2 = false;
        }
        no0Var.g();
        for (nt4 nt4Var2 : arrayList) {
            if (nt4Var2.f == i && (nt4Var2.b != kc0Var || nt4Var2.g)) {
                nt4Var2.e();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z3 = true;
                break;
            }
            nt4 nt4Var3 = (nt4) it2.next();
            if (nt4Var3.f == i && (z2 || nt4Var3.b != kc0Var)) {
                if (!nt4Var3.h.j || !nt4Var3.i.j || (!(nt4Var3 instanceof q20) && !nt4Var3.e.j)) {
                    break;
                }
            }
        }
        kc0Var.I(iH);
        kc0Var.J(iH2);
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:352:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x066f A[EDGE_INSN: B:151:0x0267->B:384:0x066f BREAK  A[LOOP:9: B:155:0x027e->B:159:0x02a1], PHI: r31
      0x066f: PHI (r31v1 lb0) = (r31v0 lb0), (r31v11 lb0), (r31v11 lb0) binds: [B:151:0x0267, B:336:0x05d8, B:368:0x063e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:469:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x081b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0828 A[LOOP:33: B:488:0x0826->B:489:0x0828, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:492:0x085d  */
    /* JADX WARN: Removed duplicated region for block: B:501:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0899  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x08b4  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:521:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x08f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c  */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v88 */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARN: Type inference failed for: r0v92 */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v44 */
    /* JADX WARN: Type inference failed for: r13v45 */
    /* JADX WARN: Type inference failed for: r13v46 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r33v0, types: [jc0, kc0] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v126, types: [int] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v68 */
    /* JADX WARN: Type inference failed for: r3v94, types: [int] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v66, types: [int] */
    /* JADX WARN: Type inference failed for: r6v79, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q() {
        boolean[] zArr;
        ?? r21;
        lb0 lb0Var;
        int i;
        boolean z;
        char c;
        boolean z2;
        lb0 lb0Var2;
        boolean z3;
        boolean z4;
        int iMax;
        ?? r10;
        ?? r17;
        boolean z5;
        int iMax2;
        ?? r0;
        boolean z6;
        boolean z7;
        ?? r02;
        ?? r13;
        int i2;
        boolean z8;
        int i3;
        int iMax3;
        boolean z9;
        int iB;
        int i4;
        ArrayList arrayList;
        mt4 mt4Var;
        mt4 mt4Var2;
        boolean z10;
        ArrayList arrayList2;
        ArrayList arrayList3;
        rb0 rb0Var;
        ArrayList arrayList4;
        int i5;
        boolean z11;
        boolean[] zArr2 = ye.c;
        this.X = 0;
        this.Y = 0;
        this.D0 = false;
        this.E0 = false;
        int size = this.p0.size();
        int iMax4 = Math.max(0, o());
        int iMax5 = Math.max(0, i());
        int[] iArr = this.o0;
        int i6 = iArr[1];
        int i7 = iArr[0];
        int i8 = this.s0;
        lb0 lb0Var3 = this.I;
        lb0 lb0Var4 = this.H;
        if (i8 == 0 && ye.k(this.C0, 1)) {
            rb0 rb0Var2 = this.t0;
            int i9 = iArr[0];
            int i10 = iArr[1];
            B();
            ArrayList arrayList5 = this.p0;
            int size2 = arrayList5.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((jc0) arrayList5.get(i11)).B();
            }
            boolean z12 = this.u0;
            zArr = zArr2;
            if (i9 == 1) {
                F(0, o());
            } else {
                lb0Var4.i(0);
                this.X = 0;
            }
            int i12 = 0;
            boolean z13 = false;
            boolean z14 = false;
            while (i12 < size2) {
                int i13 = i12;
                jc0 jc0Var = (jc0) arrayList5.get(i12);
                int[] iArr2 = iArr;
                if (jc0Var instanceof nq1) {
                    nq1 nq1Var = (nq1) jc0Var;
                    z11 = z13;
                    if (nq1Var.t0 == 1) {
                        int i14 = nq1Var.q0;
                        if (i14 != -1) {
                            nq1Var.N(i14);
                        } else if (nq1Var.r0 != -1 && y()) {
                            nq1Var.N(o() - nq1Var.r0);
                        } else if (y()) {
                            nq1Var.N((int) ((nq1Var.p0 * o()) + 0.5f));
                        }
                        z11 = true;
                    }
                } else {
                    z11 = z13;
                    if ((jc0Var instanceof wj) && ((wj) jc0Var).P() == 0) {
                        z13 = z11;
                        z14 = true;
                    }
                    i12 = i13 + 1;
                    iArr = iArr2;
                }
                z13 = z11;
                i12 = i13 + 1;
                iArr = iArr2;
            }
            r21 = iArr;
            if (z13) {
                for (int i15 = 0; i15 < size2; i15 = i5 + 1) {
                    jc0 jc0Var2 = (jc0) arrayList5.get(i15);
                    if (jc0Var2 instanceof nq1) {
                        nq1 nq1Var2 = (nq1) jc0Var2;
                        i5 = i15;
                        if (nq1Var2.t0 == 1) {
                            ye.B(0, rb0Var2, nq1Var2, z12);
                        }
                    } else {
                        i5 = i15;
                    }
                }
            }
            ye.B(0, rb0Var2, this, z12);
            if (z14) {
                for (int i16 = 0; i16 < size2; i16++) {
                    jc0 jc0Var3 = (jc0) arrayList5.get(i16);
                    if (jc0Var3 instanceof wj) {
                        wj wjVar = (wj) jc0Var3;
                        if (wjVar.P() == 0 && wjVar.O()) {
                            ye.B(1, rb0Var2, wjVar, z12);
                        }
                    }
                }
            }
            if (i10 == 1) {
                G(0, i());
            } else {
                lb0Var3.i(0);
                this.Y = 0;
            }
            int i17 = 0;
            boolean z15 = false;
            boolean z16 = false;
            while (i17 < size2) {
                jc0 jc0Var4 = (jc0) arrayList5.get(i17);
                int i18 = i17;
                if (jc0Var4 instanceof nq1) {
                    nq1 nq1Var3 = (nq1) jc0Var4;
                    if (nq1Var3.t0 == 0) {
                        int i19 = nq1Var3.q0;
                        if (i19 != -1) {
                            nq1Var3.N(i19);
                        } else if (nq1Var3.r0 != -1 && z()) {
                            nq1Var3.N(i() - nq1Var3.r0);
                        } else if (z()) {
                            nq1Var3.N((int) ((nq1Var3.p0 * i()) + 0.5f));
                        }
                        z15 = true;
                    }
                } else if ((jc0Var4 instanceof wj) && ((wj) jc0Var4).P() == 1) {
                    z16 = true;
                }
                i17 = i18 + 1;
            }
            if (z15) {
                for (int i20 = 0; i20 < size2; i20++) {
                    jc0 jc0Var5 = (jc0) arrayList5.get(i20);
                    if (jc0Var5 instanceof nq1) {
                        nq1 nq1Var4 = (nq1) jc0Var5;
                        if (nq1Var4.t0 == 0) {
                            ye.M(1, rb0Var2, nq1Var4);
                        }
                    }
                }
            }
            ye.M(0, rb0Var2, this);
            if (z16) {
                for (int i21 = 0; i21 < size2; i21++) {
                    jc0 jc0Var6 = (jc0) arrayList5.get(i21);
                    if (jc0Var6 instanceof wj) {
                        wj wjVar2 = (wj) jc0Var6;
                        if (wjVar2.P() == 1 && wjVar2.O()) {
                            ye.M(1, rb0Var2, wjVar2);
                        }
                    }
                }
            }
            for (int i22 = 0; i22 < size2; i22++) {
                jc0 jc0Var7 = (jc0) arrayList5.get(i22);
                if (jc0Var7.x() && ye.c(jc0Var7)) {
                    R(jc0Var7, rb0Var2, ye.b);
                    if (!(jc0Var7 instanceof nq1)) {
                        ye.B(0, rb0Var2, jc0Var7, z12);
                        ye.M(0, rb0Var2, jc0Var7);
                    } else if (((nq1) jc0Var7).t0 == 0) {
                        ye.M(0, rb0Var2, jc0Var7);
                    } else {
                        ye.B(0, rb0Var2, jc0Var7, z12);
                    }
                }
            }
            for (int i23 = 0; i23 < size; i23++) {
                jc0 jc0Var8 = (jc0) this.p0.get(i23);
                if (jc0Var8.x() && !(jc0Var8 instanceof nq1) && !(jc0Var8 instanceof wj)) {
                    int iH = jc0Var8.h(0);
                    int iH2 = jc0Var8.h(1);
                    if (iH != 3 || jc0Var8.r == 1 || iH2 != 3 || jc0Var8.s == 1) {
                        R(jc0Var8, this.t0, new zl());
                    }
                }
            }
        } else {
            zArr = zArr2;
            r21 = iArr;
        }
        gb2 gb2Var = this.v0;
        if (size <= 2 || !((i7 == 2 || i6 == 2) && ye.k(this.C0, 1024))) {
            lb0Var = lb0Var4;
            i = iMax4;
            z = false;
        } else {
            rb0 rb0Var3 = this.t0;
            ArrayList arrayList6 = this.p0;
            int size3 = arrayList6.size();
            int i24 = 0;
            while (i24 < size3) {
                jc0 jc0Var9 = (jc0) arrayList6.get(i24);
                ?? r3 = r21[0];
                ?? r6 = r21[1];
                int[] iArr3 = jc0Var9.o0;
                int i25 = i24;
                if (!vf2.D(r3, r6, iArr3[0], iArr3[1])) {
                    lb0Var = lb0Var4;
                    break;
                }
                i24 = i25 + 1;
            }
            int i26 = 0;
            ArrayList arrayList7 = null;
            ArrayList arrayList8 = null;
            ArrayList arrayList9 = null;
            ArrayList<wj> arrayList10 = null;
            ArrayList arrayList11 = null;
            ArrayList arrayList12 = null;
            while (i26 < size3) {
                int i27 = i26;
                jc0 jc0Var10 = (jc0) arrayList6.get(i26);
                ArrayList arrayList13 = arrayList7;
                ?? r32 = r21[0];
                ArrayList arrayList14 = arrayList8;
                ?? r62 = r21[1];
                ArrayList arrayList15 = arrayList9;
                int[] iArr4 = jc0Var10.o0;
                lb0 lb0Var5 = lb0Var4;
                if (!vf2.D(r32, r62, iArr4[0], iArr4[1])) {
                    R(jc0Var10, rb0Var3, this.K0);
                }
                boolean z17 = jc0Var10 instanceof nq1;
                if (z17) {
                    nq1 nq1Var5 = (nq1) jc0Var10;
                    if (nq1Var5.t0 == 0) {
                        arrayList9 = arrayList15 == null ? new ArrayList() : arrayList15;
                        arrayList9.add(nq1Var5);
                    } else {
                        arrayList9 = arrayList15;
                    }
                    z10 = z17;
                    if (nq1Var5.t0 == 1) {
                        arrayList2 = arrayList13 == null ? new ArrayList() : arrayList13;
                        arrayList2.add(nq1Var5);
                    } else {
                        arrayList2 = arrayList13;
                    }
                } else {
                    z10 = z17;
                    arrayList2 = arrayList13;
                    arrayList9 = arrayList15;
                }
                if (!(jc0Var10 instanceof wj)) {
                    arrayList3 = arrayList2;
                    rb0Var = rb0Var3;
                    arrayList8 = arrayList14;
                } else if (jc0Var10 instanceof wj) {
                    wj wjVar3 = (wj) jc0Var10;
                    if (wjVar3.P() == 0) {
                        arrayList4 = arrayList14 == null ? new ArrayList() : arrayList14;
                        arrayList4.add(wjVar3);
                    } else {
                        arrayList4 = arrayList14;
                    }
                    arrayList3 = arrayList2;
                    rb0Var = rb0Var3;
                    if (wjVar3.P() == 1) {
                        ArrayList arrayList16 = arrayList10 == null ? new ArrayList() : arrayList10;
                        arrayList16.add(wjVar3);
                        arrayList10 = arrayList16;
                    }
                    arrayList8 = arrayList4;
                } else {
                    arrayList3 = arrayList2;
                    rb0Var = rb0Var3;
                    wj wjVar4 = (wj) jc0Var10;
                    arrayList8 = arrayList14 == null ? new ArrayList() : arrayList14;
                    arrayList8.add(wjVar4);
                    if (arrayList10 == null) {
                        arrayList10 = new ArrayList();
                    }
                    ArrayList arrayList17 = arrayList10;
                    arrayList17.add(wjVar4);
                    arrayList10 = arrayList17;
                }
                if (jc0Var10.H.f == null && jc0Var10.J.f == null && !z10 && !(jc0Var10 instanceof wj)) {
                    if (arrayList11 == null) {
                        arrayList11 = new ArrayList();
                    }
                    ArrayList arrayList18 = arrayList11;
                    arrayList18.add(jc0Var10);
                    arrayList11 = arrayList18;
                }
                if (jc0Var10.I.f == null && jc0Var10.K.f == null && jc0Var10.L.f == null && !z10 && !(jc0Var10 instanceof wj)) {
                    if (arrayList12 == null) {
                        arrayList12 = new ArrayList();
                    }
                    ArrayList arrayList19 = arrayList12;
                    arrayList19.add(jc0Var10);
                    arrayList12 = arrayList19;
                }
                i26 = i27 + 1;
                arrayList7 = arrayList3;
                lb0Var4 = lb0Var5;
                rb0Var3 = rb0Var;
            }
            ArrayList arrayList20 = arrayList7;
            ArrayList<wj> arrayList21 = arrayList8;
            lb0Var = lb0Var4;
            ArrayList arrayList22 = arrayList9;
            ArrayList<mt4> arrayList23 = new ArrayList();
            if (arrayList20 != null) {
                Iterator it = arrayList20.iterator();
                while (it.hasNext()) {
                    vf2.m((nq1) it.next(), 0, arrayList23, null);
                }
            }
            mt4 mt4Var3 = null;
            int i28 = 0;
            if (arrayList21 != null) {
                for (wj wjVar5 : arrayList21) {
                    mt4 mt4VarM = vf2.m(wjVar5, i28, arrayList23, mt4Var3);
                    wjVar5.N(i28, mt4VarM, arrayList23);
                    mt4VarM.a(arrayList23);
                    mt4Var3 = null;
                    i28 = 0;
                }
            }
            HashSet hashSet = g(2).a;
            if (hashSet != null) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    vf2.m(((lb0) it2.next()).d, 0, arrayList23, null);
                }
            }
            HashSet hashSet2 = g(4).a;
            if (hashSet2 != null) {
                Iterator it3 = hashSet2.iterator();
                while (it3.hasNext()) {
                    vf2.m(((lb0) it3.next()).d, 0, arrayList23, null);
                }
            }
            HashSet hashSet3 = g(7).a;
            if (hashSet3 != null) {
                Iterator it4 = hashSet3.iterator();
                while (it4.hasNext()) {
                    vf2.m(((lb0) it4.next()).d, 0, arrayList23, null);
                }
            }
            mt4 mt4Var4 = null;
            if (arrayList11 != null) {
                Iterator it5 = arrayList11.iterator();
                while (it5.hasNext()) {
                    vf2.m((jc0) it5.next(), 0, arrayList23, null);
                }
            }
            if (arrayList22 != null) {
                Iterator it6 = arrayList22.iterator();
                while (it6.hasNext()) {
                    vf2.m((nq1) it6.next(), 1, arrayList23, null);
                }
            }
            int i29 = 1;
            if (arrayList10 != null) {
                for (wj wjVar6 : arrayList10) {
                    mt4 mt4VarM2 = vf2.m(wjVar6, i29, arrayList23, mt4Var4);
                    wjVar6.N(i29, mt4VarM2, arrayList23);
                    mt4VarM2.a(arrayList23);
                    mt4Var4 = null;
                    i29 = 1;
                }
            }
            HashSet hashSet4 = g(3).a;
            if (hashSet4 != null) {
                Iterator it7 = hashSet4.iterator();
                while (it7.hasNext()) {
                    vf2.m(((lb0) it7.next()).d, 1, arrayList23, null);
                }
            }
            HashSet hashSet5 = g(6).a;
            if (hashSet5 != null) {
                Iterator it8 = hashSet5.iterator();
                while (it8.hasNext()) {
                    vf2.m(((lb0) it8.next()).d, 1, arrayList23, null);
                }
            }
            HashSet hashSet6 = g(5).a;
            if (hashSet6 != null) {
                Iterator it9 = hashSet6.iterator();
                while (it9.hasNext()) {
                    vf2.m(((lb0) it9.next()).d, 1, arrayList23, null);
                }
            }
            HashSet hashSet7 = g(7).a;
            if (hashSet7 != null) {
                Iterator it10 = hashSet7.iterator();
                while (it10.hasNext()) {
                    vf2.m(((lb0) it10.next()).d, 1, arrayList23, null);
                }
            }
            boolean z18 = true;
            if (arrayList12 != null) {
                Iterator it11 = arrayList12.iterator();
                while (it11.hasNext()) {
                    vf2.m((jc0) it11.next(), 1, arrayList23, null);
                }
            }
            int i30 = 0;
            while (i30 < size3) {
                jc0 jc0Var11 = (jc0) arrayList6.get(i30);
                int[] iArr5 = jc0Var11.o0;
                boolean z19 = z18;
                if (iArr5[0] == 3 && iArr5[z19 ? 1 : 0] == 3) {
                    int i31 = jc0Var11.m0;
                    int size4 = arrayList23.size();
                    int i32 = 0;
                    while (true) {
                        if (i32 >= size4) {
                            i4 = i30;
                            arrayList = arrayList6;
                            mt4Var = null;
                            break;
                        }
                        i4 = i30;
                        mt4Var = (mt4) arrayList23.get(i32);
                        arrayList = arrayList6;
                        if (i31 == mt4Var.b) {
                            break;
                        }
                        i32++;
                        arrayList6 = arrayList;
                        i30 = i4;
                    }
                    int i33 = jc0Var11.n0;
                    int size5 = arrayList23.size();
                    int i34 = 0;
                    while (true) {
                        if (i34 >= size5) {
                            mt4Var2 = null;
                            break;
                        }
                        mt4Var2 = (mt4) arrayList23.get(i34);
                        if (i33 == mt4Var2.b) {
                            break;
                        } else {
                            i34++;
                        }
                    }
                    if (mt4Var != null && mt4Var2 != null) {
                        mt4Var.c(0, mt4Var2);
                        mt4Var2.c = 2;
                        arrayList23.remove(mt4Var);
                    }
                } else {
                    i4 = i30;
                    arrayList = arrayList6;
                }
                i30 = i4 + 1;
                arrayList6 = arrayList;
                z18 = true;
            }
            if (arrayList23.size() <= 1) {
                i = iMax4;
                z = false;
            } else {
                int i35 = 0;
                if (r21[0] == 2) {
                    int i36 = 0;
                    mt4 mt4Var5 = null;
                    for (mt4 mt4Var6 : arrayList23) {
                        if (mt4Var6.c != 1) {
                            int iB2 = mt4Var6.b(gb2Var, i35);
                            if (iB2 > i36) {
                                mt4Var5 = mt4Var6;
                                i36 = iB2;
                            }
                            i35 = 0;
                        }
                    }
                    if (mt4Var5 != null) {
                        I(1);
                        K(i36);
                    } else {
                        mt4Var5 = null;
                    }
                    if (r21[1] == 2) {
                        int i37 = 0;
                        mt4 mt4Var7 = null;
                        for (mt4 mt4Var8 : arrayList23) {
                            if (mt4Var8.c != 0 && (iB = mt4Var8.b(gb2Var, 1)) > i37) {
                                mt4Var7 = mt4Var8;
                                i37 = iB;
                            }
                        }
                        if (mt4Var7 != null) {
                            J(1);
                            H(i37);
                        } else {
                            mt4Var7 = null;
                        }
                        if (mt4Var5 != null || mt4Var7 != null) {
                            if (i7 == 2) {
                                if (iMax4 >= o() || iMax4 <= 0) {
                                    iMax4 = o();
                                } else {
                                    K(iMax4);
                                    this.D0 = true;
                                }
                            }
                            if (i6 == 2) {
                                if (iMax5 >= i() || iMax5 <= 0) {
                                    iMax5 = i();
                                } else {
                                    H(iMax5);
                                    this.E0 = true;
                                }
                            }
                            i = iMax4;
                            z = true;
                        }
                    }
                }
            }
        }
        boolean z20 = S(64) || S(128);
        gb2Var.getClass();
        gb2Var.h = false;
        if (this.C0 == 0 || !z20) {
            c = 1;
        } else {
            c = 1;
            gb2Var.h = true;
        }
        ArrayList arrayList24 = this.p0;
        boolean z21 = r21[0] == 2 || r21[c] == 2;
        this.y0 = 0;
        this.z0 = 0;
        for (int i38 = 0; i38 < size; i38++) {
            jc0 jc0Var12 = (jc0) this.p0.get(i38);
            if (jc0Var12 instanceof kc0) {
                ((kc0) jc0Var12).Q();
            }
        }
        boolean zS = S(64);
        ?? r132 = z;
        int i39 = 0;
        boolean z22 = true;
        while (z22) {
            int i40 = i39 + 1;
            try {
                gb2Var.t();
                this.y0 = 0;
                this.z0 = 0;
                e(gb2Var);
                for (int i41 = 0; i41 < size; i41++) {
                    ((jc0) this.p0.get(i41)).e(gb2Var);
                }
                O(gb2Var);
                try {
                    WeakReference weakReference = this.F0;
                    if (weakReference == null || weakReference.get() == null) {
                        z2 = z21;
                    } else {
                        z2 = z21;
                        try {
                            gb2Var.f(gb2Var.k((lb0) this.F0.get()), gb2Var.k(lb0Var3), 0, 5);
                            this.F0 = null;
                        } catch (Exception e) {
                            e = e;
                            z9 = true;
                            e.printStackTrace();
                            lb0Var2 = lb0Var3;
                            System.out.println("EXCEPTION : " + e);
                            z3 = z9;
                            if (z3) {
                            }
                            if (z2) {
                            }
                            iMax = Math.max(this.a0, o());
                            if (iMax > o()) {
                            }
                            iMax2 = Math.max(this.b0, i());
                            if (iMax2 > i()) {
                            }
                            if (r0 == 0) {
                            }
                            r13 = r02;
                            i2 = 8;
                            z8 = z7;
                            if (i40 <= i2) {
                            }
                            i39 = i40;
                            z21 = z2;
                            lb0Var3 = lb0Var2;
                            r132 = r13;
                            z22 = z8;
                        }
                    }
                    WeakReference weakReference2 = this.H0;
                    if (weakReference2 != null && weakReference2.get() != null) {
                        gb2Var.f(gb2Var.k(this.K), gb2Var.k((lb0) this.H0.get()), 0, 5);
                        this.H0 = null;
                    }
                    WeakReference weakReference3 = this.G0;
                    if (weakReference3 != null && weakReference3.get() != null) {
                        lb0 lb0Var6 = lb0Var;
                        try {
                            lb0Var = lb0Var6;
                            gb2Var.f(gb2Var.k((lb0) this.G0.get()), gb2Var.k(lb0Var6), 0, 5);
                            this.G0 = null;
                        } catch (Exception e2) {
                            e = e2;
                            lb0Var = lb0Var6;
                            z9 = true;
                            e.printStackTrace();
                            lb0Var2 = lb0Var3;
                            System.out.println("EXCEPTION : " + e);
                            z3 = z9;
                            if (z3) {
                            }
                            if (z2) {
                                int iMax6 = 0;
                                int iMax7 = 0;
                                while (i3 < size) {
                                }
                                int iMax8 = Math.max(this.a0, iMax7);
                                iMax3 = Math.max(this.b0, iMax6);
                                r132 = r132;
                                z4 = z4;
                                if (i7 == 2) {
                                }
                                if (i6 == 2) {
                                    H(iMax3);
                                    r21[1] = 2;
                                    r132 = 1;
                                    z4 = true;
                                }
                            }
                            iMax = Math.max(this.a0, o());
                            if (iMax > o()) {
                            }
                            iMax2 = Math.max(this.b0, i());
                            if (iMax2 > i()) {
                            }
                            if (r0 == 0) {
                            }
                            r13 = r02;
                            i2 = 8;
                            z8 = z7;
                            if (i40 <= i2) {
                            }
                            i39 = i40;
                            z21 = z2;
                            lb0Var3 = lb0Var2;
                            r132 = r13;
                            z22 = z8;
                        }
                    }
                    WeakReference weakReference4 = this.I0;
                    if (weakReference4 != null && weakReference4.get() != null) {
                        try {
                        } catch (Exception e3) {
                            e = e3;
                        }
                        try {
                            gb2Var.f(gb2Var.k(this.J), gb2Var.k((lb0) this.I0.get()), 0, 5);
                        } catch (Exception e4) {
                            e = e4;
                            z9 = true;
                            e.printStackTrace();
                            lb0Var2 = lb0Var3;
                            System.out.println("EXCEPTION : " + e);
                            z3 = z9;
                        }
                        try {
                            this.I0 = null;
                        } catch (Exception e5) {
                            e = e5;
                            z9 = true;
                            e.printStackTrace();
                            lb0Var2 = lb0Var3;
                            System.out.println("EXCEPTION : " + e);
                            z3 = z9;
                        }
                    }
                    gb2Var.p();
                    lb0Var2 = lb0Var3;
                    z3 = true;
                } catch (Exception e6) {
                    e = e6;
                    z2 = z21;
                }
            } catch (Exception e7) {
                e = e7;
                z2 = z21;
                z9 = z22;
            }
            if (z3) {
                zArr[2] = false;
                boolean zS2 = S(64);
                M(gb2Var, zS2);
                int size6 = this.p0.size();
                int i42 = 0;
                boolean z23 = false;
                while (i42 < size6) {
                    jc0 jc0Var13 = (jc0) this.p0.get(i42);
                    jc0Var13.M(gb2Var, zS2);
                    boolean z24 = zS2;
                    int i43 = size6;
                    if (jc0Var13.h != -1 || jc0Var13.i != -1) {
                        z23 = true;
                    }
                    i42++;
                    zS2 = z24;
                    size6 = i43;
                    z23 = z23;
                }
                z4 = z23;
            } else {
                M(gb2Var, zS);
                for (int i44 = 0; i44 < size; i44++) {
                    ((jc0) this.p0.get(i44)).M(gb2Var, zS);
                }
                z4 = false;
            }
            if (z2 && i40 < 8 && zArr[2]) {
                int iMax62 = 0;
                int iMax72 = 0;
                for (i3 = 0; i3 < size; i3++) {
                    jc0 jc0Var14 = (jc0) this.p0.get(i3);
                    iMax72 = Math.max(iMax72, jc0Var14.o() + jc0Var14.X);
                    iMax62 = Math.max(iMax62, jc0Var14.i() + jc0Var14.Y);
                }
                int iMax82 = Math.max(this.a0, iMax72);
                iMax3 = Math.max(this.b0, iMax62);
                r132 = r132;
                z4 = z4;
                if (i7 == 2) {
                    r132 = r132;
                    z4 = z4;
                    if (o() < iMax82) {
                        K(iMax82);
                        r21[0] = 2;
                        r132 = 1;
                        z4 = true;
                    }
                }
                if (i6 == 2 && i() < iMax3) {
                    H(iMax3);
                    r21[1] = 2;
                    r132 = 1;
                    z4 = true;
                }
            }
            iMax = Math.max(this.a0, o());
            if (iMax > o()) {
                K(iMax);
                r10 = 1;
                r21[0] = 1;
                z5 = true;
                r17 = 1;
            } else {
                r10 = 1;
                r17 = r132;
                z5 = z4;
            }
            iMax2 = Math.max(this.b0, i());
            if (iMax2 > i()) {
                H(iMax2);
                r21[r10] = r10;
                ?? r03 = r10;
                z6 = r03 == true ? 1 : 0;
                r0 = r03;
            } else {
                r0 = r17;
                z6 = z5;
            }
            if (r0 == 0) {
                ?? r04 = r0;
                r04 = r0;
                boolean z25 = z6;
                z25 = z6;
                if (r21[0] == 2 && i > 0) {
                    r04 = r0;
                    z25 = z6;
                    if (o() > i) {
                        this.D0 = r10;
                        r21[0] = r10;
                        K(i);
                        ?? r05 = r10;
                        z25 = r05 == true ? 1 : 0;
                        r04 = r05;
                    }
                }
                r02 = r04;
                r02 = r04;
                z7 = z25;
                z7 = z25;
                if (r21[r10] == 2 && iMax5 > 0) {
                    r02 = r04;
                    z7 = z25;
                    if (i() > iMax5) {
                        this.E0 = r10;
                        r21[r10] = r10;
                        H(iMax5);
                        i2 = 8;
                        r13 = 1;
                        z8 = true;
                    }
                }
                if (i40 <= i2) {
                    z8 = false;
                }
                i39 = i40;
                z21 = z2;
                lb0Var3 = lb0Var2;
                r132 = r13;
                z22 = z8;
            } else {
                r02 = r0;
                z7 = z6;
            }
            r13 = r02;
            i2 = 8;
            z8 = z7;
            if (i40 <= i2) {
            }
            i39 = i40;
            z21 = z2;
            lb0Var3 = lb0Var2;
            r132 = r13;
            z22 = z8;
        }
        this.p0 = arrayList24;
        if (r132 != 0) {
            r21[0] = i7;
            r21[1] = i6;
        }
        C(gb2Var.m);
    }

    public final boolean S(int i) {
        return (this.C0 & i) == i;
    }

    @Override // defpackage.jc0
    public final void l(StringBuilder sb) {
        sb.append(this.j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.T);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.U);
        sb.append("\n");
        Iterator it = this.p0.iterator();
        while (it.hasNext()) {
            ((jc0) it.next()).l(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
