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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q() {
        /*
            Method dump skipped, instruction units count: 2317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kc0.Q():void");
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
