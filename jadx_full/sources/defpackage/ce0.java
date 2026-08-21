package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ce0 implements lf0 {
    public final cf0 b;

    public ce0(cf0 cf0Var) {
        this.b = cf0Var;
    }

    @Override // defpackage.lf0
    public final cf0 I() {
        return this.b;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.b + ')';
    }
}
