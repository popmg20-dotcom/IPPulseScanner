package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k64 extends l64 {
    public final nl1 A;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k64(gl1 gl1Var, String str) {
        super(gl1Var, str);
        gl1Var.getClass();
        str.getClass();
        this.A = gl1Var.s(str);
    }

    @Override // defpackage.io3
    public final boolean C0() {
        g();
        this.A.f.execute();
        return false;
    }

    @Override // defpackage.io3
    public final void K(int i, String str) {
        str.getClass();
        g();
        this.A.r(i, str);
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A.close();
        this.z = true;
    }

    @Override // defpackage.io3
    public final String e0(int i) {
        g();
        ez4.Y(21, "no row");
        throw null;
    }

    @Override // defpackage.io3
    public final byte[] getBlob(int i) {
        g();
        ez4.Y(21, "no row");
        throw null;
    }

    @Override // defpackage.io3
    public final int getColumnCount() {
        g();
        return 0;
    }

    @Override // defpackage.io3
    public final String getColumnName(int i) {
        g();
        ez4.Y(21, "no row");
        throw null;
    }

    @Override // defpackage.io3
    public final long getLong(int i) {
        g();
        ez4.Y(21, "no row");
        throw null;
    }

    @Override // defpackage.io3
    public final boolean isNull(int i) {
        g();
        ez4.Y(21, "no row");
        throw null;
    }

    @Override // defpackage.io3
    public final void j(int i, long j) {
        g();
        this.A.j(i, j);
    }

    @Override // defpackage.io3
    public final void k(int i, byte[] bArr) {
        g();
        this.A.k(i, bArr);
    }

    @Override // defpackage.io3
    public final void l(int i) {
        g();
        this.A.l(i);
    }

    @Override // defpackage.io3
    public final void reset() {
    }
}
