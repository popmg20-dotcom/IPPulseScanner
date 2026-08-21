package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class h8 extends d5 {
    public boolean b;
    public final /* synthetic */ i8 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h8(i8 i8Var, j5 j5Var) {
        super(j5Var);
        this.c = i8Var;
        this.b = true;
    }

    @Override // j$.util.stream.h5, java.util.function.IntConsumer
    public final void accept(int i) {
        if (this.b) {
            boolean zTest = this.c.m.test(i);
            this.b = zTest;
            if (zTest) {
                this.a.accept(i);
            }
        }
    }

    @Override // j$.util.stream.d5, j$.util.stream.j5
    public final void c(long j) {
        this.a.c(-1L);
    }

    @Override // j$.util.stream.d5, j$.util.stream.j5
    public final boolean e() {
        return !this.b || this.a.e();
    }
}
