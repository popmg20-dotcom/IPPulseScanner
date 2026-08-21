package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class j8 extends d5 implements o8 {
    public long b;
    public boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ i8 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j8(i8 i8Var, j5 j5Var, boolean z) {
        super(j5Var);
        this.e = i8Var;
        this.d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // j$.util.stream.h5, java.util.function.IntConsumer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void accept(int i) {
        boolean z;
        if (!this.c) {
            boolean zTest = this.e.m.test(i);
            this.c = !zTest;
            z = !zTest;
        }
        boolean z2 = this.d;
        if (z2 && !z) {
            this.b++;
        }
        if (z2 || z) {
            this.a.accept(i);
        }
    }

    @Override // j$.util.stream.o8
    public final long h() {
        return this.b;
    }
}
