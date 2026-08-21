package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class km4 extends ok3 implements lz3 {
    public final long A;
    public final pj2 z;

    public km4(pj2 pj2Var, long j) {
        this.z = pj2Var;
        this.A = j;
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return de4.d;
    }

    @Override // defpackage.ok3
    public final long n() {
        return this.A;
    }

    @Override // defpackage.ok3
    public final pj2 s() {
        return this.z;
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) {
        hpVar.getClass();
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override // defpackage.ok3
    public final cq x() {
        return new he3(this);
    }

    @Override // defpackage.ok3, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
