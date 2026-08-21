package defpackage;

import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class kx2 implements vx3 {
    public final FileOutputStream b;
    public final de4 f;

    public kx2(FileOutputStream fileOutputStream, de4 de4Var) {
        this.b = fileOutputStream;
        this.f = de4Var;
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) throws IOException {
        l72.f(hpVar.f, 0L, j);
        while (j > 0) {
            this.f.f();
            rr3 rr3Var = hpVar.b;
            rr3Var.getClass();
            int iMin = (int) Math.min(j, rr3Var.c - rr3Var.b);
            this.b.write(rr3Var.a, rr3Var.b, iMin);
            int i = rr3Var.b + iMin;
            rr3Var.b = i;
            long j2 = iMin;
            j -= j2;
            hpVar.f -= j2;
            if (i == rr3Var.c) {
                hpVar.b = rr3Var.a();
                tr3.a(rr3Var);
            }
        }
    }

    @Override // defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    @Override // defpackage.vx3, java.io.Flushable
    public final void flush() throws IOException {
        this.b.flush();
    }

    @Override // defpackage.vx3
    public final de4 i() {
        return this.f;
    }

    public final String toString() {
        return "sink(" + this.b + ')';
    }
}
