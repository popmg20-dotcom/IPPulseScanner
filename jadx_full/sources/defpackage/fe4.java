package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fe4 extends iq3 implements Runnable {
    public final long X;

    public fe4(long j, ie0 ie0Var) {
        super(ie0Var, ie0Var.j());
        this.X = j;
    }

    @Override // defpackage.e42
    public final String U() {
        return super.U() + "(timeMillis=" + this.X + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        gb4.J(this.z);
        q(new ee4("Timed out waiting for " + this.X + " ms", this));
    }
}
