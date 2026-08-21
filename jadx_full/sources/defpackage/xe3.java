package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xe3 extends ok3 {
    public final long A;
    public final he3 X;
    public final String z;

    public xe3(String str, long j, he3 he3Var) {
        this.z = str;
        this.A = j;
        this.X = he3Var;
    }

    @Override // defpackage.ok3
    public final long n() {
        return this.A;
    }

    @Override // defpackage.ok3
    public final pj2 s() {
        String str = this.z;
        if (str != null) {
            uh3 uh3Var = pj2.e;
            try {
                return p95.n(str);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    @Override // defpackage.ok3
    public final cq x() {
        return this.X;
    }
}
