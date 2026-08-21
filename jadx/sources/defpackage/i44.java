package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i44 extends le {
    public static final i44 Y;
    public final b72 X;

    static {
        rj4.z.getClass();
        qj4 qj4Var = rj4.A;
        if (!qj4Var.f() || rj4.a(String.class) == null) {
            new jx3(String.class, qj4Var, null, null);
        }
        Y = new i44();
    }

    public i44() {
        super(String[].class);
        this.X = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // defpackage.le, defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b72 a(defpackage.gt3 r5, defpackage.nm r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L1a
            bt3 r1 = r5.b
            cu2 r1 = r1.d()
            c9 r2 = r6.a()
            if (r2 == 0) goto L1a
            java.lang.Object r1 = r1.c(r2)
            if (r1 == 0) goto L1a
            b72 r1 = r5.D(r2, r1)
            goto L1b
        L1a:
            r1 = r0
        L1b:
            java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
            e52 r2 = defpackage.l34.k(r5, r6, r2)
            if (r2 == 0) goto L2a
            b52 r3 = defpackage.b52.b
            java.lang.Boolean r2 = r2.b(r3)
            goto L2b
        L2a:
            r2 = r0
        L2b:
            b72 r3 = r4.X
            if (r1 != 0) goto L30
            r1 = r3
        L30:
            b72 r1 = defpackage.l34.j(r5, r6, r1)
            if (r1 != 0) goto L3c
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            b72 r1 = r5.j(r1, r6)
        L3c:
            boolean r5 = defpackage.n50.q(r1)
            if (r5 == 0) goto L43
            goto L44
        L43:
            r0 = r1
        L44:
            if (r0 != r3) goto L4f
            java.lang.Boolean r5 = r4.A
            boolean r5 = j$.util.Objects.equals(r2, r5)
            if (r5 == 0) goto L4f
            return r4
        L4f:
            i44 r5 = new i44
            r5.<init>(r4, r6, r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i44.a(gt3, nm):b72");
    }

    @Override // defpackage.b72
    public final boolean c(gt3 gt3Var, Object obj) {
        return ((String[]) obj).length == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        if (r0 == java.lang.Boolean.TRUE) goto L10;
     */
    @Override // defpackage.b72
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.lang.Object r4, defpackage.i52 r5, defpackage.gt3 r6) {
        /*
            r3 = this;
            java.lang.String[] r4 = (java.lang.String[]) r4
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i44.e(java.lang.Object, i52, gt3):void");
    }

    @Override // defpackage.le
    public final b72 q(nm nmVar, Boolean bool) {
        return new i44(this, nmVar, this.X, bool);
    }

    @Override // defpackage.le
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void r(String[] strArr, i52 i52Var, gt3 gt3Var) {
        int length = strArr.length;
        if (length == 0) {
            return;
        }
        int i = 0;
        b72 b72Var = this.X;
        if (b72Var == null) {
            while (i < length) {
                String str = strArr[i];
                if (str == null) {
                    i52Var.U();
                } else {
                    i52Var.G0(str);
                }
                i++;
            }
            return;
        }
        int length2 = strArr.length;
        while (i < length2) {
            String str2 = strArr[i];
            if (str2 == null) {
                gt3Var.h(i52Var);
            } else {
                b72Var.e(str2, i52Var, gt3Var);
            }
            i++;
        }
    }

    public i44(i44 i44Var, nm nmVar, b72 b72Var, Boolean bool) {
        super(i44Var, nmVar, bool);
        this.X = b72Var;
    }

    @Override // defpackage.hd0
    public final hd0 o(zj4 zj4Var) {
        return this;
    }
}
