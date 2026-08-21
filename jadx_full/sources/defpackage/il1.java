package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class il1 extends RuntimeException {
    public final jl1 b;
    public final Throwable f;

    public il1(jl1 jl1Var, Throwable th) {
        super(th);
        this.b = jl1Var;
        this.f = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f;
    }
}
