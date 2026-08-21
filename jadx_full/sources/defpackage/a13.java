package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class a13 implements lz3 {
    public int A;
    public boolean X;
    public long Y;
    public final cq b;
    public final hp f;
    public rr3 z;

    public a13(cq cqVar) {
        this.b = cqVar;
        hp hpVarH = cqVar.h();
        this.f = hpVarH;
        rr3 rr3Var = hpVarH.b;
        this.z = rr3Var;
        this.A = rr3Var != null ? rr3Var.b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.X = true;
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.b.i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r3 == r5.b) goto L15;
     */
    @Override // defpackage.lz3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long t0(hp hpVar, long j) {
        rr3 rr3Var;
        hpVar.getClass();
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.X) {
            xe.q("closed");
            return 0L;
        }
        rr3 rr3Var2 = this.z;
        hp hpVar2 = this.f;
        if (rr3Var2 != null) {
            rr3 rr3Var3 = hpVar2.b;
            if (rr3Var2 == rr3Var3) {
                int i = this.A;
                rr3Var3.getClass();
            }
            xe.q("Peek source is invalid because upstream source was used");
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.b.request(this.Y + 1)) {
            return -1L;
        }
        if (this.z == null && (rr3Var = hpVar2.b) != null) {
            this.z = rr3Var;
            this.A = rr3Var.b;
        }
        long jMin = Math.min(j, hpVar2.f - this.Y);
        this.f.n(hpVar, this.Y, jMin);
        this.Y += jMin;
        return jMin;
    }
}
