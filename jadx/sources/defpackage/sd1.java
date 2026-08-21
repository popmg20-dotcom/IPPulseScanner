package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sd1 extends j62 {
    public final Closeable A;
    public boolean X;
    public he3 Y;
    public final u03 b;
    public final ge1 f;
    public final String z;

    public sd1(u03 u03Var, ge1 ge1Var, String str, Closeable closeable) {
        this.b = u03Var;
        this.f = ge1Var;
        this.z = str;
        this.A = closeable;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            this.X = true;
            he3 he3Var = this.Y;
            if (he3Var != null) {
                j.a(he3Var);
            }
            Closeable closeable = this.A;
            if (closeable != null) {
                j.a(closeable);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.j62
    public final fx3 g() {
        return null;
    }

    @Override // defpackage.j62
    public final synchronized cq n() {
        if (this.X) {
            throw new IllegalStateException("closed");
        }
        he3 he3Var = this.Y;
        if (he3Var != null) {
            return he3Var;
        }
        lz3 lz3VarX = this.f.X(this.b);
        lz3VarX.getClass();
        he3 he3Var2 = new he3(lz3VarX);
        this.Y = he3Var2;
        return he3Var2;
    }
}
