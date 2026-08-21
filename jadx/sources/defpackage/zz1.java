package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zz1 implements lz3 {
    public boolean A;
    public final he3 b;
    public final Inflater f;
    public int z;

    public zz1(he3 he3Var, Inflater inflater) {
        this.b = he3Var;
        this.f = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.A) {
            return;
        }
        this.f.end();
        this.A = true;
        this.b.close();
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.b.b.i();
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) throws IOException {
        long j2;
        hpVar.getClass();
        while (j >= 0) {
            if (this.A) {
                xe.q("closed");
                return 0L;
            }
            he3 he3Var = this.b;
            Inflater inflater = this.f;
            if (j == 0) {
                j2 = 0;
            } else {
                try {
                    rr3 rr3VarG0 = hpVar.G0(1);
                    int iMin = (int) Math.min(j, 8192 - rr3VarG0.c);
                    if (inflater.needsInput() && !he3Var.g()) {
                        rr3 rr3Var = he3Var.f.b;
                        rr3Var.getClass();
                        int i = rr3Var.c;
                        int i2 = rr3Var.b;
                        int i3 = i - i2;
                        this.z = i3;
                        inflater.setInput(rr3Var.a, i2, i3);
                    }
                    int iInflate = inflater.inflate(rr3VarG0.a, rr3VarG0.c, iMin);
                    int i4 = this.z;
                    if (i4 != 0) {
                        int remaining = i4 - inflater.getRemaining();
                        this.z -= remaining;
                        he3Var.Z(remaining);
                    }
                    if (iInflate > 0) {
                        rr3VarG0.c += iInflate;
                        j2 = iInflate;
                        hpVar.f += j2;
                    } else {
                        if (rr3VarG0.b == rr3VarG0.c) {
                            hpVar.b = rr3VarG0.a();
                            tr3.a(rr3VarG0);
                        }
                        j2 = 0;
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            if (j2 > 0) {
                return j2;
            }
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
            if (he3Var.g()) {
                throw new EOFException("source exhausted prematurely");
            }
        }
        e04.f(ha0.j(j, "byteCount < 0: "));
        return 0L;
    }
}
