package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class kv0 extends Exception {
    public final Throwable b;

    public kv0(Throwable th, ef0 ef0Var, cf0 cf0Var) {
        super("Coroutine dispatcher " + ef0Var + " threw an exception, context = " + cf0Var, th);
        this.b = th;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.b;
    }
}
