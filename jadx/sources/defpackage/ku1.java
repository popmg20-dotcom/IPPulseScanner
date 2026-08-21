package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ku1 implements lz3 {
    public boolean X;
    public final /* synthetic */ mu1 Y;
    public final long b;
    public boolean f;
    public final hp z = new hp();
    public final hp A = new hp();

    public ku1(mu1 mu1Var, long j, boolean z) {
        this.Y = mu1Var;
        this.b = j;
        this.f = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        long j;
        mu1 mu1Var = this.Y;
        synchronized (mu1Var) {
            this.X = true;
            hp hpVar = this.A;
            j = hpVar.f;
            hpVar.z0(j);
            mu1Var.notifyAll();
        }
        if (j > 0) {
            mu1 mu1Var2 = this.Y;
            TimeZone timeZone = jz4.a;
            mu1Var2.f.F(j);
        }
        this.Y.b();
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.Y.A0;
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) throws Throwable {
        boolean z;
        Throwable x34Var;
        long j2;
        long jT0;
        hpVar.getClass();
        long j3 = 0;
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        while (true) {
            mu1 mu1Var = this.Y;
            synchronized (mu1Var) {
                mu1Var.f.getClass();
                ju1 ju1Var = mu1Var.z0;
                z = true;
                boolean z2 = ju1Var.z || ju1Var.b;
                if (z2) {
                    mu1Var.A0.h();
                }
                try {
                    if (mu1Var.g() == null || this.f) {
                        x34Var = null;
                    } else {
                        x34Var = mu1Var.D0;
                        if (x34Var == null) {
                            t51 t51VarG = mu1Var.g();
                            t51VarG.getClass();
                            x34Var = new x34(t51VarG);
                        }
                    }
                    if (this.X) {
                        throw new IOException("stream closed");
                    }
                    hp hpVar2 = this.A;
                    long j4 = hpVar2.f;
                    if (j4 > j3) {
                        jT0 = hpVar2.t0(hpVar, Math.min(j, j4));
                        bi4.c(mu1Var.z, jT0, 0L, 2);
                        long jB = mu1Var.z.b();
                        if (x34Var == null) {
                            j2 = j3;
                            if (jB >= mu1Var.f.H0.a() / 2) {
                                mu1Var.f.N(mu1Var.b, jB);
                                bi4.c(mu1Var.z, 0L, jB, 1);
                            }
                        } else {
                            j2 = j3;
                        }
                        z = false;
                    } else {
                        j2 = j3;
                        if (this.f || x34Var != null) {
                            z = false;
                        } else {
                            try {
                                mu1Var.wait();
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw new InterruptedIOException();
                            }
                        }
                        jT0 = -1;
                    }
                } finally {
                    if (z2) {
                        mu1Var.A0.k();
                    }
                }
            }
            this.Y.f.G0.getClass();
            if (!z) {
                if (jT0 != -1) {
                    return jT0;
                }
                if (x34Var == null) {
                    return -1L;
                }
                throw x34Var;
            }
            j3 = j2;
        }
    }
}
