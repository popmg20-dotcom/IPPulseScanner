package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gm0 extends y61 {
    public static final gm0 A;
    public kf0 z;

    static {
        int i = bb4.c;
        int i2 = bb4.d;
        long j = bb4.e;
        String str = bb4.a;
        gm0 gm0Var = new gm0();
        gm0Var.z = new kf0(i, i2, j, str);
        A = gm0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // defpackage.ef0
    public final void j0(cf0 cf0Var, Runnable runnable) {
        kf0.s(this.z, runnable, 6);
    }

    @Override // defpackage.ef0
    public final void n0(cf0 cf0Var, Runnable runnable) {
        kf0.s(this.z, runnable, 2);
    }

    @Override // defpackage.ef0
    public final ef0 r0(int i) {
        vf2.d(1);
        return 1 >= bb4.c ? this : super.r0(1);
    }

    @Override // defpackage.ef0
    public final String toString() {
        return "Dispatchers.Default";
    }
}
