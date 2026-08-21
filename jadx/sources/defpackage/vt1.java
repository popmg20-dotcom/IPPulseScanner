package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vt1 extends qt1 {
    public boolean X;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.z) {
            return;
        }
        if (!this.X) {
            g(wt1.f);
        }
        this.z = true;
    }

    @Override // defpackage.qt1, defpackage.lz3
    public final long t0(hp hpVar, long j) {
        hpVar.getClass();
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.z) {
            xe.q("closed");
            return 0L;
        }
        if (this.X) {
            return -1L;
        }
        long jT0 = super.t0(hpVar, j);
        if (jT0 != -1) {
            return jT0;
        }
        this.X = true;
        g(lr1.f);
        return -1L;
    }
}
