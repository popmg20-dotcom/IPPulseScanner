package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tl2 implements gq3 {
    public final d1 a;
    public final em4 b;
    public final q91 c;

    public tl2(em4 em4Var, q91 q91Var, d1 d1Var) {
        this.b = em4Var;
        q91Var.getClass();
        this.c = q91Var;
        this.a = d1Var;
    }

    @Override // defpackage.gq3
    public final void a(Object obj, Object obj2) {
        hq3.k(this.b, obj, obj2);
    }

    @Override // defpackage.gq3
    public final void b(Object obj) {
        this.b.getClass();
        dm4 dm4Var = ((co1) obj).unknownFields;
        if (dm4Var.e) {
            dm4Var.e = false;
        }
        this.c.getClass();
        dw2.I(obj);
        throw null;
    }

    @Override // defpackage.gq3
    public final boolean c(Object obj) {
        this.c.getClass();
        dw2.I(obj);
        throw null;
    }

    @Override // defpackage.gq3
    public final void d(Object obj, zf2 zf2Var) {
        this.c.getClass();
        dw2.I(obj);
        throw null;
    }

    @Override // defpackage.gq3
    public final boolean e(co1 co1Var, co1 co1Var2) {
        this.b.getClass();
        return co1Var.unknownFields.equals(co1Var2.unknownFields);
    }

    @Override // defpackage.gq3
    public final int f(co1 co1Var) {
        this.b.getClass();
        return co1Var.unknownFields.hashCode();
    }

    @Override // defpackage.gq3
    public final int g(co1 co1Var) {
        this.b.getClass();
        dm4 dm4Var = co1Var.unknownFields;
        int i = dm4Var.d;
        if (i != -1) {
            return i;
        }
        int iF = 0;
        for (int i2 = 0; i2 < dm4Var.a; i2++) {
            int i3 = dm4Var.b[i2] >>> 3;
            iF += r60.f(3, (au) dm4Var.c[i2]) + r60.i(i3) + r60.h(2) + (r60.h(1) * 2);
        }
        dm4Var.d = iF;
        return iF;
    }

    @Override // defpackage.gq3
    public final void h(Object obj, r02 r02Var, p91 p91Var) {
        this.b.getClass();
        em4.a(obj);
        this.c.getClass();
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // defpackage.gq3
    public final co1 i() {
        d1 d1Var = this.a;
        return d1Var instanceof co1 ? ((co1) d1Var).i() : ((ao1) ((co1) d1Var).c(5)).b();
    }
}
