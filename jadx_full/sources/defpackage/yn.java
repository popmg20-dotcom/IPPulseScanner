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
    */
    public final b72 a(gt3 gt3Var, nm nmVar) {
        int i = this.A;
        boolean z = true;
        Class cls = this.b;
        boolean z2 = this.X;
        switch (i) {
            case 0:
                e52 e52VarK = l34.k(gt3Var, nmVar, Boolean.class);
                return (e52VarK == null || e52VarK.f.a()) ? this : new yn(z2, 1);
            case 1:
                e52 e52VarK2 = l34.k(gt3Var, nmVar, cls);
                if (e52VarK2 == null) {
                    return this;
                }
                d52 d52Var = e52VarK2.f;
                return d52Var.a() ? new yn(z2, 0) : d52Var == d52.z0 ? new et2(cls, 0) : this;
            default:
                e52 e52VarK3 = l34.k(gt3Var, nmVar, cls);
                if (e52VarK3 != null) {
                    d52 d52Var2 = e52VarK3.f;
                    if (!d52Var2.a() && d52Var2 != d52.A) {
                        z = false;
                    }
                }
                return z != z2 ? new yn(z, 2) : this;
        }
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
