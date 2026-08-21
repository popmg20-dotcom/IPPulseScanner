package defpackage;

import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yn extends ue4 implements ee0 {
    public final /* synthetic */ int A;
    public final boolean X;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yn(boolean z, int i) {
        super(z ? Boolean.TYPE : Boolean.class);
        this.A = i;
        switch (i) {
            case 1:
                super(z ? Boolean.TYPE : Boolean.class);
                this.X = z;
                break;
            case 2:
                super(InetAddress.class);
                this.X = z;
                break;
            default:
                this.X = z;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    @Override // defpackage.ee0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.b72 a(defpackage.gt3 r6, defpackage.nm r7) {
        /*
            r5 = this;
            int r0 = r5.A
            r1 = 1
            java.lang.Class r2 = r5.b
            boolean r3 = r5.X
            r4 = 0
            switch(r0) {
                case 0: goto L46;
                case 1: goto L28;
                default: goto Lb;
            }
        Lb:
            e52 r6 = defpackage.l34.k(r6, r7, r2)
            if (r6 == 0) goto L1e
            d52 r6 = r6.f
            boolean r7 = r6.a()
            if (r7 != 0) goto L1f
            d52 r7 = defpackage.d52.A
            if (r6 != r7) goto L1e
            goto L1f
        L1e:
            r1 = r4
        L1f:
            if (r1 == r3) goto L27
            yn r5 = new yn
            r6 = 2
            r5.<init>(r1, r6)
        L27:
            return r5
        L28:
            e52 r6 = defpackage.l34.k(r6, r7, r2)
            if (r6 == 0) goto L45
            d52 r6 = r6.f
            boolean r7 = r6.a()
            if (r7 == 0) goto L3c
            yn r5 = new yn
            r5.<init>(r3, r4)
            goto L45
        L3c:
            d52 r7 = defpackage.d52.z0
            if (r6 != r7) goto L45
            et2 r5 = new et2
            r5.<init>(r2, r4)
        L45:
            return r5
        L46:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            e52 r6 = defpackage.l34.k(r6, r7, r0)
            if (r6 == 0) goto L5b
            d52 r6 = r6.f
            boolean r6 = r6.a()
            if (r6 != 0) goto L5b
            yn r5 = new yn
            r5.<init>(r3, r1)
        L5b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yn.a(gt3, nm):b72");
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        switch (this.A) {
            case 0:
                i52Var.c0(!Boolean.FALSE.equals(obj) ? 1 : 0);
                break;
            case 1:
                i52Var.F(Boolean.TRUE.equals(obj));
                break;
            default:
                p((InetAddress) obj, i52Var);
                break;
        }
    }

    @Override // defpackage.ue4, defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        switch (this.A) {
            case 0:
                i52Var.F(Boolean.TRUE.equals(obj));
                break;
            case 1:
                i52Var.F(Boolean.TRUE.equals(obj));
                break;
            default:
                InetAddress inetAddress = (InetAddress) obj;
                e10 e10VarD = zj4Var.d(inetAddress, g72.Z);
                e10VarD.A = InetAddress.class;
                e10 e10VarE = zj4Var.e(i52Var, e10VarD);
                p(inetAddress, i52Var);
                zj4Var.f(i52Var, e10VarE);
                break;
        }
    }

    public void p(InetAddress inetAddress, i52 i52Var) {
        String strTrim;
        if (this.X) {
            strTrim = inetAddress.getHostAddress();
        } else {
            strTrim = inetAddress.toString().trim();
            int iIndexOf = strTrim.indexOf(47);
            if (iIndexOf >= 0) {
                strTrim = iIndexOf == 0 ? strTrim.substring(1) : strTrim.substring(0, iIndexOf);
            }
        }
        i52Var.G0(strTrim);
    }
}
