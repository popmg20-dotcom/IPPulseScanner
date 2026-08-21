package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nz3 extends j62 {
    public final fx3 b;
    public boolean f;
    public final cq z;

    public nz3(cq cqVar, fx3 fx3Var) {
        this.b = fx3Var;
        this.z = cqVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f = true;
        cq cqVar = this.z;
        if (cqVar != null) {
            j.a(cqVar);
        }
    }

    @Override // defpackage.j62
    public final fx3 g() {
        return this.b;
    }

    @Override // defpackage.j62
    public final synchronized cq n() {
        cq cqVar;
        try {
            if (this.f) {
                throw new IllegalStateException("closed");
            }
            cqVar = this.z;
            if (cqVar == null) {
                x72 x72Var = ge1.b;
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return cqVar;
    }
}
