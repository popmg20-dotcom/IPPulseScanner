package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class km0 implements lz3 {
    public final InputStream b;
    public final yy3 f;
    public final /* synthetic */ iv1 z;

    public km0(iv1 iv1Var) {
        this.z = iv1Var;
        Socket socket = (Socket) iv1Var.f;
        this.b = socket.getInputStream();
        this.f = new yy3(socket);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        int i;
        iv1 iv1Var = this.z;
        yy3 yy3Var = this.f;
        yy3Var.h();
        try {
            AtomicInteger atomicInteger = (AtomicInteger) iv1Var.z;
            Socket socket = (Socket) iv1Var.f;
            atomicInteger.getClass();
            while (true) {
                int i2 = atomicInteger.get();
                if ((i2 & 2) != 0) {
                    i = 0;
                    break;
                }
                int i3 = i2 | 2;
                if (atomicInteger.compareAndSet(i2, i3)) {
                    i = i3;
                    break;
                }
            }
            if (i != 0) {
                if (i == 3) {
                    socket.close();
                } else {
                    if (socket.isClosed() || socket.isInputShutdown()) {
                        return;
                    }
                    try {
                        socket.shutdownInput();
                    } catch (UnsupportedOperationException unused) {
                        this.b.close();
                    }
                }
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

    @Override // defpackage.lz3
    public final de4 i() {
        return this.f;
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) throws IOException {
        hpVar.getClass();
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        yy3 yy3Var = this.f;
        yy3Var.f();
        rr3 rr3VarG0 = hpVar.G0(1);
        int iMin = (int) Math.min(j, 8192 - rr3VarG0.c);
        try {
            yy3Var.h();
            try {
                int i = this.b.read(rr3VarG0.a, rr3VarG0.c, iMin);
                if (yy3Var.i()) {
                    throw yy3Var.k(null);
                }
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
            } catch (IOException e) {
                if (yy3Var.i()) {
                    throw yy3Var.k(e);
                }
                throw e;
            } finally {
                yy3Var.i();
            }
        } catch (AssertionError e2) {
            if (gz4.a(e2)) {
                throw new IOException(e2);
            }
            throw e2;
        }
    }

    public final String toString() {
        return "source(" + ((Socket) this.z.f) + ')';
    }
}
