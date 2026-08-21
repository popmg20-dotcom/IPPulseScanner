package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nt2 extends le {
    public final boolean X;
    public final nj4 Y;
    public final zj4 Z;
    public final b72 y0;
    public ke0 z0;

    public nt2(nt2 nt2Var, nm nmVar, zj4 zj4Var, b72 b72Var, Boolean bool) {
        super(nt2Var, nmVar, bool);
        this.Y = nt2Var.Y;
        this.Z = zj4Var;
        this.X = nt2Var.X;
        this.z0 = z83.e;
        this.y0 = b72Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // defpackage.le, defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b72 a(defpackage.gt3 r9, defpackage.nm r10) {
        /*
            r8 = this;
            zj4 r0 = r8.Z
            if (r0 == 0) goto La
            zj4 r1 = r0.g(r10)
            r5 = r1
            goto Lb
        La:
            r5 = r0
        Lb:
            r1 = 0
            if (r10 == 0) goto L25
            c9 r2 = r10.a()
            bt3 r3 = r9.b
            cu2 r3 = r3.d()
            if (r2 == 0) goto L25
            java.lang.Object r3 = r3.c(r2)
            if (r3 == 0) goto L25
            b72 r2 = r9.D(r2, r3)
            goto L26
        L25:
            r2 = r1
        L26:
            java.lang.Class r3 = r8.b
            e52 r3 = defpackage.l34.k(r9, r10, r3)
            if (r3 == 0) goto L34
            b52 r1 = defpackage.b52.b
            java.lang.Boolean r1 = r3.b(r1)
        L34:
            r7 = r1
            b72 r1 = r8.y0
            if (r2 != 0) goto L3a
            r2 = r1
        L3a:
            b72 r2 = defpackage.l34.j(r9, r10, r2)
            if (r2 != 0) goto L52
            nj4 r3 = r8.Y
            if (r3 == 0) goto L52
            boolean r4 = r8.X
            if (r4 == 0) goto L52
            boolean r4 = r3.j0()
            if (r4 != 0) goto L52
            b72 r2 = r9.i(r3, r10)
        L52:
            r6 = r2
            nm r9 = r8.z
            if (r9 != r10) goto L64
            if (r6 != r1) goto L64
            if (r0 != r5) goto L64
            java.lang.Boolean r9 = r8.A
            boolean r9 = j$.util.Objects.equals(r9, r7)
            if (r9 == 0) goto L64
            return r8
        L64:
            nt2 r2 = new nt2
            r3 = r8
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nt2.a(gt3, nm):b72");
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((Object[]) obj).length == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // defpackage.b72
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r4, defpackage.i52 r5, defpackage.gt3 r6) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            int r0 = r4.length
            r1 = 1
            if (r0 != r1) goto L1c
            java.lang.Boolean r0 = r3.A
            if (r0 != 0) goto L14
            dt3 r1 = defpackage.dt3.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            bt3 r2 = r6.b
            boolean r1 = r2.h(r1)
            if (r1 != 0) goto L18
        L14:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            if (r0 != r1) goto L1c
        L18:
            r3.r(r4, r5, r6)
            return
        L1c:
            r5.r0(r4)
            r3.r(r4, r5, r6)
            r5.I()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nt2.e(java.lang.Object, i52, gt3):void");
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        return new nt2(this.Y, this.X, zj4Var, this.y0);
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new nt2(this, nmVar, this.Z, this.y0, bool);
    }

    @Override // defpackage.le
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void r(Object[] objArr, i52 i52Var, gt3 gt3Var) throws IOException {
        Object obj;
        Object obj2;
        ke0 ke0VarN;
        nj4 nj4Var = this.Y;
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        int i = 0;
        b72 b72Var = this.y0;
        zj4 zj4Var = this.Z;
        if (b72Var != null) {
            int length2 = objArr.length;
            Object obj3 = null;
            while (i < length2) {
                try {
                    obj3 = objArr[i];
                    if (obj3 == null) {
                        gt3Var.h(i52Var);
                    } else if (zj4Var == null) {
                        b72Var.e(obj3, i52Var, gt3Var);
                    } else {
                        b72Var.f(obj3, i52Var, gt3Var, zj4Var);
                    }
                    i++;
                } catch (Exception e) {
                    l34.m(gt3Var, e, obj3, i);
                    throw null;
                }
            }
            return;
        }
        nm nmVar = this.z;
        if (zj4Var != null) {
            int length3 = objArr.length;
            try {
                ke0 ke0Var = this.z0;
                obj2 = null;
                while (i < length3) {
                    try {
                        obj2 = objArr[i];
                        if (obj2 == null) {
                            gt3Var.h(i52Var);
                        } else {
                            Class<?> cls = obj2.getClass();
                            b72 b72VarA = ke0Var.A(cls);
                            if (b72VarA == null && ke0Var != (ke0VarN = ke0Var.n(cls, (b72VarA = gt3Var.j(cls, nmVar))))) {
                                this.z0 = ke0VarN;
                            }
                            b72VarA.f(obj2, i52Var, gt3Var, zj4Var);
                        }
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                        l34.m(gt3Var, e, obj2, i);
                        throw null;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                obj2 = null;
            }
        } else {
            try {
                ke0 ke0Var2 = this.z0;
                obj = null;
                while (i < length) {
                    try {
                        obj = objArr[i];
                        if (obj == null) {
                            gt3Var.h(i52Var);
                        } else {
                            Class<?> cls2 = obj.getClass();
                            b72 b72VarA2 = ke0Var2.A(cls2);
                            if (b72VarA2 == null) {
                                if (nj4Var.e0()) {
                                    v62 v62VarG = ke0Var2.g(gt3Var.e(nj4Var, cls2), gt3Var, nmVar);
                                    ke0 ke0Var3 = (ke0) v62VarG.z;
                                    if (ke0Var2 != ke0Var3) {
                                        this.z0 = ke0Var3;
                                    }
                                    b72VarA2 = (b72) v62VarG.f;
                                } else {
                                    b72VarA2 = gt3Var.j(cls2, nmVar);
                                    ke0 ke0VarN2 = ke0Var2.n(cls2, b72VarA2);
                                    if (ke0Var2 != ke0VarN2) {
                                        this.z0 = ke0VarN2;
                                    }
                                }
                            }
                            b72VarA2.e(obj, i52Var, gt3Var);
                        }
                        i++;
                    } catch (Exception e4) {
                        e = e4;
                        l34.m(gt3Var, e, obj, i);
                        throw null;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                obj = null;
            }
        }
    }

    public nt2(nj4 nj4Var, boolean z, zj4 zj4Var, b72 b72Var) {
        super(Object[].class);
        this.Y = nj4Var;
        this.X = z;
        this.Z = zj4Var;
        this.z0 = z83.e;
        this.y0 = b72Var;
    }
}
