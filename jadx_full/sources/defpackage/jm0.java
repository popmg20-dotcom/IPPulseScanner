package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class jm0 implements vx3 {
    public final OutputStream b;
    public final yy3 f;
    public final /* synthetic */ iv1 z;

    public jm0(iv1 iv1Var) {
        this.z = iv1Var;
        Socket socket = (Socket) iv1Var.f;
        this.b = socket.getOutputStream();
        this.f = new yy3(socket);
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) throws IOException {
        l72.f(hpVar.f, 0L, j);
        while (j > 0) {
            yy3 yy3Var = this.f;
            yy3Var.f();
            rr3 rr3Var = hpVar.b;
            rr3Var.getClass();
            int iMin = (int) Math.min(j, rr3Var.c - rr3Var.b);
            yy3Var.h();
            try {
                try {
                    this.b.write(rr3Var.a, rr3Var.b, iMin);
                    if (yy3Var.i()) {
                        throw yy3Var.k(null);
                    }
                    int i = rr3Var.b + iMin;
                    rr3Var.b = i;
                    long j2 = iMin;
                    j -= j2;
                    hpVar.f -= j2;
                    if (i == rr3Var.c) {
                        hpVar.b = rr3Var.a();
                        tr3.a(rr3Var);
                    }
                } catch (IOException e) {
                    if (!yy3Var.i()) {
                        throw e;
                    }
                    throw yy3Var.k(e);
                }
            } catch (Throwable th) {
                yy3Var.i();
                throw th;
            }
        }
    }

    @Override // defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i;
        OutputStream outputStream = this.b;
        iv1 iv1Var = this.z;
        yy3 yy3Var = this.f;
        yy3Var.h();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) iv1Var.z;
            Socket socket = (Socket) iv1Var.f;
            atomicInteger.getClass();
            while (true) {
                int i2 = atomicInteger.get();
                if ((i2 & 1) != 0) {
                    i = 0;
                    break;
                }
                int i3 = i2 | 1;
                if (atomicInteger.compareAndSet(i2, i3)) {
                    i = i3;
                    break;
                }
            }
            if (i != 0) {
                if (i != 3) {
                    if (!socket.isClosed() && !socket.isOutputShutdown()) {
                        outputStream.flush();
                        try {
                            socket.shutdownOutput();
                        } catch (UnsupportedOperationException unused) {
                            outputStream.close();
                        }
                    }
                    return;
                }
                socket.close();
                if (yy3Var.i()) {
                    throw yy3Var.k(null);
                }
            }
        } catch (IOException e) {
            if (!yy3Var.i()) {
                throw e;
            }
            throw yy3Var.k(e);
        } finally {
            yy3Var.i();
        }
    }

    @Override // defpackage.vx3, java.io.Flushable
    public final void flush() throws IOException {
        yy3 yy3Var = this.f;
        yy3Var.h();
        try {
            this.b.flush();
            if (yy3Var.i()) {
                throw yy3Var.k(null);
            }
        } catch (IOException e) {
            if (!yy3Var.i()) {
                throw e;
            }
            throw yy3Var.k(e);
        } finally {
            yy3Var.i();
        }
    }

    @Override // defpackage.vx3
    public final de4 i() {
        return this.f;
    }

    public final String toString() {
        return "sink(" + ((Socket) this.z.f) + ')';
    }
}
