package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yf2 implements ll2 {
    public ll2[] a;

    @Override // defpackage.ll2
    public final qd3 a(Class cls) {
        for (ll2 ll2Var : this.a) {
            if (ll2Var.b(cls)) {
                return ll2Var.a(cls);
            }
        }
        vp1.n("No factory is available for message type: ".concat(cls.getName()));
        return null;
    }

    @Override // defpackage.ll2
    public final boolean b(Class cls) {
        for (ll2 ll2Var : this.a) {
            if (ll2Var.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
