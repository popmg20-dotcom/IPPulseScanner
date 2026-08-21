package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public abstract class g2 implements e2 {
    public final e2 a;
    public final e2 b;
    public final long c;

    public g2(e2 e2Var, e2 e2Var2) {
        this.a = e2Var;
        this.b = e2Var2;
        this.c = e2Var2.count() + e2Var.count();
    }

    @Override // j$.util.stream.e2
    public final e2 a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            return this.b;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.e2
    public final long count() {
        return this.c;
    }

    @Override // j$.util.stream.e2
    public final int o() {
        return 2;
    }

    @Override // j$.util.stream.e2
    public /* bridge */ /* synthetic */ d2 a(int i) {
        return (d2) a(i);
    }
}
