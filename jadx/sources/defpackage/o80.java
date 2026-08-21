package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class o80 extends e42 implements fn0 {
    public final Object j0(ie0 ie0Var) throws Throwable {
        Object objH;
        do {
            objH = H();
            if (!(objH instanceof oz1)) {
                if (objH instanceof r80) {
                    throw ((r80) objH).a;
                }
                return f42.a(objH);
            }
        } while (e0(objH) < 0);
        a42 a42Var = new a42(p95.u(ie0Var), this);
        a42Var.w();
        a42Var.z(new s00(2, je.K(this, true, new yk3(a42Var))));
        return a42Var.u();
    }
}
