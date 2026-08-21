package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class q02 implements lz3 {
    public final InputStream b;
    public final de4 f;

    public q02(InputStream inputStream, de4 de4Var) {
        inputStream.getClass();
        this.b = inputStream;
        this.f = de4Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.close();
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.f;
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) {
        hpVar.getClass();
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        try {
            this.f.f();
            rr3 rr3VarG0 = hpVar.G0(1);
            int i = this.b.read(rr3VarG0.a, rr3VarG0.c, (int) Math.min(j, 8192 - rr3VarG0.c));
            if (i != -1) {
                rr3VarG0.c += i;
                long j2 = i;
                hpVar.f += j2;
                return j2;
            }
            if (rr3VarG0.b != rr3VarG0.c) {
                return -1L;
            }
            hpVar.b = rr3VarG0.a();
            tr3.a(rr3VarG0);
            return -1L;
        } catch (AssertionError e) {
            if (gz4.a(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    public final String toString() {
        return "source(" + this.b + ')';
    }
}
