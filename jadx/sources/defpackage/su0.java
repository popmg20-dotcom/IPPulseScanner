package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class su0 extends oo0 {
    public int m;

    public su0(nt4 nt4Var) {
        super(nt4Var);
        if (nt4Var instanceof ks1) {
            this.e = 2;
        } else {
            this.e = 3;
        }
    }

    @Override // defpackage.oo0
    public final void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (io0 io0Var : this.k) {
            io0Var.a(io0Var);
        }
    }
}
