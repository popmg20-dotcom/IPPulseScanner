package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class aj1 implements lz3 {
    public final lz3 b;

    public aj1(lz3 lz3Var) {
        lz3Var.getClass();
        this.b = lz3Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.b.i();
    }

    @Override // defpackage.lz3
    public long t0(hp hpVar, long j) {
        hpVar.getClass();
        return this.b.t0(hpVar, j);
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.b + ')';
    }
}
