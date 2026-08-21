package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h5 extends ui1 {
    public final kz b;
    public final uy c;

    public h5(kz kzVar, uy uyVar) {
        super(kzVar);
        this.b = kzVar;
        this.c = uyVar;
        zf2 zf2Var = (zf2) uyVar;
        zf2Var.m0();
        int i = ty.a;
        pg pgVar = uy.j;
        Boolean bool = Boolean.FALSE;
        ((Boolean) ((sw2) zf2Var.m()).p(pgVar, bool)).getClass();
        ((Boolean) ((sw2) zf2Var.m()).p(uy.k, bool)).getClass();
    }

    @Override // defpackage.ui1, defpackage.kz
    public final yc2 e() {
        return this.b.e();
    }

    @Override // defpackage.ui1, defpackage.kz
    public final kz getImplementation() {
        return this.b;
    }

    @Override // defpackage.ui1, defpackage.kz
    public final boolean m() {
        return this.b.m();
    }
}
