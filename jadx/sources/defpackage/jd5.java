package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jd5 implements sd5 {
    public final va5 a;
    public final q84 b;

    public jd5(q84 q84Var, va5 va5Var) {
        l74 l74Var = sb5.a;
        this.b = q84Var;
        this.a = va5Var;
    }

    @Override // defpackage.sd5
    public final dc5 a() {
        va5 va5Var = this.a;
        if (va5Var instanceof dc5) {
            return (dc5) ((dc5) va5Var).m(4);
        }
        zb5 zb5Var = (zb5) ((dc5) va5Var).m(5);
        boolean zD = zb5Var.f.d();
        dc5 dc5Var = zb5Var.f;
        if (!zD) {
            return dc5Var;
        }
        dc5Var.getClass();
        od5.c.a(dc5Var.getClass()).g(dc5Var);
        dc5Var.e();
        return zb5Var.f;
    }

    @Override // defpackage.sd5
    public final int b(dc5 dc5Var) {
        return dc5Var.zzc.hashCode();
    }

    @Override // defpackage.sd5
    public final void c(Object obj, Object obj2) {
        ud5.b(obj, obj2);
    }

    @Override // defpackage.sd5
    public final void d(Object obj, ub4 ub4Var) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.sd5
    public final boolean e(dc5 dc5Var, dc5 dc5Var2) {
        return dc5Var.zzc.equals(dc5Var2.zzc);
    }

    @Override // defpackage.sd5
    public final boolean f(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.sd5
    public final void g(Object obj) {
        this.b.getClass();
        fe5 fe5Var = ((dc5) obj).zzc;
        if (fe5Var.e) {
            fe5Var.e = false;
        }
        l74 l74Var = sb5.a;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.sd5
    public final int h(va5 va5Var) {
        fe5 fe5Var = ((dc5) va5Var).zzc;
        int i = fe5Var.d;
        if (i != -1) {
            return i;
        }
        int iO = 0;
        for (int i2 = 0; i2 < fe5Var.a; i2++) {
            int i3 = fe5Var.b[i2] >>> 3;
            hb5 hb5Var = (hb5) fe5Var.c[i2];
            int iR = kb5.r(8);
            int iR2 = kb5.r(i3) + kb5.r(16);
            int iR3 = kb5.r(24);
            int iC = hb5Var.c();
            iO += iR + iR + iR2 + qe4.o(iC, iC, iR3);
        }
        fe5Var.d = iO;
        return iO;
    }

    @Override // defpackage.sd5
    public final void i(Object obj, byte[] bArr, int i, int i2, za5 za5Var) {
        dc5 dc5Var = (dc5) obj;
        if (dc5Var.zzc == fe5.f) {
            dc5Var.zzc = fe5.a();
        }
        obj.getClass();
        throw new ClassCastException();
    }
}
