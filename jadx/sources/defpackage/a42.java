package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class a42 extends z00 {
    public final o80 z0;

    public a42(ge0 ge0Var, o80 o80Var) {
        super(1, ge0Var);
        this.z0 = o80Var;
    }

    @Override // defpackage.z00
    public final String C() {
        return "AwaitContinuation";
    }

    @Override // defpackage.z00
    public final Throwable t(e42 e42Var) {
        Throwable thC;
        Object objH = this.z0.H();
        return (!(objH instanceof c42) || (thC = ((c42) objH).c()) == null) ? objH instanceof r80 ? ((r80) objH).a : e42Var.F() : thC;
    }
}
