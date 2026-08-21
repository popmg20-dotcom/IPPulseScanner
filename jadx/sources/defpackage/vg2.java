package defpackage;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.vg2 q(java.util.Set r11, java.util.Set r12, defpackage.nj4 r13, boolean r14, defpackage.ak4 r15, defpackage.b72 r16, defpackage.b72 r17, java.lang.Object r18) {
        /*
            r0 = r18
            if (r13 != 0) goto L9
            jx3 r13 = defpackage.vg2.I0
            r5 = r13
            r6 = r5
            goto L1f
        L9:
            nj4 r1 = r13.b0()
            java.lang.Class<java.util.Properties> r2 = java.util.Properties.class
            boolean r2 = r13.g0(r2)
            if (r2 == 0) goto L1a
            jx3 r13 = defpackage.rj4.J0
        L17:
            r6 = r13
            r5 = r1
            goto L1f
        L1a:
            nj4 r13 = r13.Y()
            goto L17
        L1f:
            r13 = 0
            if (r14 != 0) goto L35
            if (r6 == 0) goto L32
            java.lang.Class r14 = r6.L0
            int r14 = r14.getModifiers()
            boolean r14 = java.lang.reflect.Modifier.isFinal(r14)
            if (r14 == 0) goto L32
            r14 = 1
            goto L33
        L32:
            r14 = r13
        L33:
            r7 = r14
            goto L3c
        L35:
            java.lang.Class r1 = r6.L0
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            if (r1 != r2) goto L33
            r7 = r13
        L3c:
            vg2 r2 = new vg2
            r3 = r11
            r4 = r12
            r8 = r15
            r9 = r16
            r10 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 == 0) goto L57
            java.lang.String r11 = "withFilterId"
            java.lang.Class<vg2> r12 = defpackage.vg2.class
            defpackage.n50.w(r12, r2, r11)
            vg2 r11 = new vg2
            r11.<init>(r2, r0, r13)
            return r11
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vg2.q(java.util.Set, java.util.Set, nj4, boolean, ak4, b72, b72, java.lang.Object):vg2");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b72 a(defpackage.gt3 r18, defpackage.nm r19) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vg2.a(gt3, nm):b72");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(java.util.Map r18, defpackage.i52 r19, defpackage.gt3 r20) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vg2.s(java.util.Map, i52, gt3):void");
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
