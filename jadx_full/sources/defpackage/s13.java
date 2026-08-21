package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s13 implements io3 {
    public final io3 b;
    public final long f;
    public final /* synthetic */ z13 z;

    public s13(z13 z13Var, io3 io3Var) {
        io3Var.getClass();
        this.z = z13Var;
        this.b = io3Var;
        this.f = tj4.u();
    }

    @Override // defpackage.io3
    public final boolean C0() {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            return this.b.C0();
        }
        ez4.Y(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // defpackage.io3
    public final void K(int i, String str) {
        str.getClass();
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            this.b.K(i, str);
        } else {
            ez4.Y(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // defpackage.io3
    public final boolean L() {
        return getLong(0) != 0;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws Exception {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            this.b.close();
        } else {
            ez4.Y(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // defpackage.io3
    public final String e0(int i) {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            return this.b.e0(i);
        }
        ez4.Y(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // defpackage.io3
    public final byte[] getBlob(int i) {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            return this.b.getBlob(i);
        }
        ez4.Y(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // defpackage.io3
    public final int getColumnCount() {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            return this.b.getColumnCount();
        }
        ez4.Y(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // defpackage.io3
    public final String getColumnName(int i) {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            return this.b.getColumnName(i);
        }
        ez4.Y(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // defpackage.io3
    public final long getLong(int i) {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            return this.b.getLong(i);
        }
        ez4.Y(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // defpackage.io3
    public final boolean isNull(int i) {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            return this.b.isNull(i);
        }
        ez4.Y(21, "Attempted to use statement on a different thread");
        throw null;
    }

    @Override // defpackage.io3
    public final void j(int i, long j) {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            this.b.j(i, j);
        } else {
            ez4.Y(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // defpackage.io3
    public final void k(int i, byte[] bArr) {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            this.b.k(i, bArr);
        } else {
            ez4.Y(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // defpackage.io3
    public final void l(int i) {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            this.b.l(i);
        } else {
            ez4.Y(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // defpackage.io3
    public final void reset() {
        if (this.z.d.get()) {
            ez4.Y(21, "Statement is recycled");
            throw null;
        }
        if (this.f == tj4.u()) {
            this.b.reset();
        } else {
            ez4.Y(21, "Attempted to use statement on a different thread");
            throw null;
        }
    }

    @Override // defpackage.io3
    public final int v0() {
        return (int) getLong(0);
    }
}
