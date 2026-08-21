package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ie4 implements dl3 {
    public final long b;
    public final dl3 c;

    public ie4(long j, dl3 dl3Var) {
        r25.f(j >= 0, "Timeout must be non-negative.");
        this.b = j;
        this.c = dl3Var;
    }

    @Override // defpackage.dl3
    public final long a() {
        return this.b;
    }

    @Override // defpackage.dl3
    public final cl3 b(xz xzVar) {
        cl3 cl3VarB = this.c.b(xzVar);
        long j = this.b;
        return (j <= 0 || xzVar.b < j - cl3VarB.a) ? cl3VarB : cl3.d;
    }
}
