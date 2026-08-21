package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class k5 extends f5 {
    public long b;
    public long c;
    public final /* synthetic */ l5 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k5(l5 l5Var, j5 j5Var) {
        super(j5Var);
        this.d = l5Var;
        this.b = l5Var.l;
        long j = l5Var.m;
        this.c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final void n(Object obj) {
        long j = this.b;
        if (j != 0) {
            this.b = j - 1;
            return;
        }
        long j2 = this.c;
        if (j2 > 0) {
            this.c = j2 - 1;
            this.a.n(obj);
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final void c(long j) {
        this.a.c(t3.y(j, this.d.l, this.c));
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final boolean e() {
        return this.c == 0 || this.a.e();
    }
}
