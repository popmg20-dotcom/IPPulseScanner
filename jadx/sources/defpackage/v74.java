package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class v74 extends ie0 implements lm1 {
    public final int A;

    public v74(int i, ge0 ge0Var) {
        super(ge0Var);
        this.A = i;
    }

    @Override // defpackage.lm1
    public final int b() {
        return this.A;
    }

    @Override // defpackage.kk
    public final String toString() {
        if (this.b != null) {
            return super.toString();
        }
        dh3.a.getClass();
        return eh3.a(this);
    }
}
