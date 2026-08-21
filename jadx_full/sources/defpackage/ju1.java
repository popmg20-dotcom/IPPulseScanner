package defpackage;

import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import java.io.InterruptedIOException;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ju1 implements vx3 {
    public final /* synthetic */ mu1 A;
    public final boolean b;
    public final hp f = new hp();
    public boolean z;

    public ju1(mu1 mu1Var, boolean z) {
        this.A = mu1Var;
        this.b = z;
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) {
        TimeZone timeZone = jz4.a;
        hp hpVar2 = this.f;
        hpVar2.a0(hpVar, j);
        while (hpVar2.f >= DefaultHttpDataFactory.MINSIZE) {
            g(false);
        }
    }

    @Override // defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        mu1 mu1Var = this.A;
        TimeZone timeZone = jz4.a;
        synchronized (mu1Var) {
            if (this.z) {
                return;
            }
            boolean z = mu1Var.g() == null;
            mu1 mu1Var2 = this.A;
            if (!mu1Var2.z0.b) {
                if (this.f.f > 0) {
                    while (this.f.f > 0) {
                        g(true);
                    }
                } else if (z) {
                    mu1Var2.f.I(mu1Var2.b, true, null, 0L);
                }
            }
            mu1 mu1Var3 = this.A;
            synchronized (mu1Var3) {
                this.z = true;
                mu1Var3.notifyAll();
            }
            this.A.f.flush();
            this.A.b();
        }
    }

    @Override // defpackage.vx3, java.io.Flushable
    public final void flush() {
        mu1 mu1Var = this.A;
        TimeZone timeZone = jz4.a;
        synchronized (mu1Var) {
            mu1Var.c();
        }
        while (this.f.f > 0) {
            g(false);
            this.A.f.flush();
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void g(boolean z) {
        long jMin;
        boolean z2;
        mu1 mu1Var = this.A;
        synchronized (mu1Var) {
            mu1Var.B0.h();
            while (mu1Var.A >= mu1Var.X && !this.b && !this.z && mu1Var.g() == null) {
                try {
                    try {
                        mu1Var.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                } catch (Throwable th) {
                    mu1Var.B0.k();
                    throw th;
                }
            }
            mu1Var.B0.k();
            mu1Var.c();
            jMin = Math.min(mu1Var.X - mu1Var.A, this.f.f);
            mu1Var.A += jMin;
            z2 = z && jMin == this.f.f;
        }
        this.A.B0.h();
        try {
            mu1 mu1Var2 = this.A;
            mu1Var2.f.I(mu1Var2.b, z2, this.f, jMin);
        } finally {
            this.A.B0.k();
        }
    }

    @Override // defpackage.vx3
    public final de4 i() {
        return this.A.B0;
    }
}
