package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zi1 implements vx3 {
    public final vx3 b;

    public zi1(vx3 vx3Var) {
        vx3Var.getClass();
        this.b = vx3Var;
    }

    @Override // defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    @Override // defpackage.vx3, java.io.Flushable
    public void flush() {
        this.b.flush();
    }

    @Override // defpackage.vx3
    public final de4 i() {
        return this.b.i();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.b + ')';
    }
}
