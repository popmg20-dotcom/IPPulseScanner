package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class th implements t00 {
    public final sh[] b;

    public th(sh[] shVarArr) {
        this.b = shVarArr;
    }

    public final void a() {
        for (sh shVar : this.b) {
            zv0 zv0Var = shVar.Y;
            if (zv0Var == null) {
                n12.T("handle");
                throw null;
            }
            zv0Var.c();
        }
    }

    @Override // defpackage.t00
    public final void b(Throwable th) {
        a();
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.b + ']';
    }
}
