package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class me3 extends du1 implements q61 {
    public final ab4 b;
    public final em3 c;
    public final Socket d;
    public final Socket e;
    public final zq1 f;
    public final ba3 g;
    public final ed4 h;
    public fu1 i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final ArrayList p;
    public long q;

    public me3(ab4 ab4Var, oe3 oe3Var, em3 em3Var, Socket socket, Socket socket2, zq1 zq1Var, ba3 ba3Var, ed4 ed4Var) {
        ab4Var.getClass();
        em3Var.getClass();
        socket.getClass();
        socket2.getClass();
        ba3Var.getClass();
        ed4Var.getClass();
        this.b = ab4Var;
        this.c = em3Var;
        this.d = socket;
        this.e = socket2;
        this.f = zq1Var;
        this.g = ba3Var;
        this.h = ed4Var;
        this.o = 1;
        this.p = new ArrayList();
        this.q = Long.MAX_VALUE;
    }

    public static void c(lu2 lu2Var, em3 em3Var, IOException iOException) {
        lu2Var.getClass();
        em3Var.getClass();
        iOException.getClass();
        if (em3Var.b.type() != Proxy.Type.DIRECT) {
            a6 a6Var = em3Var.a;
            a6Var.h.connectFailed(a6Var.i.i(), em3Var.b.address(), iOException);
        }
        wn1 wn1Var = lu2Var.C;
        synchronized (wn1Var) {
            ((LinkedHashSet) wn1Var.f).add(em3Var);
        }
    }

    @Override // defpackage.du1
    public final void a(fu1 fu1Var, gu3 gu3Var) {
        gu3Var.getClass();
        synchronized (this) {
            this.o = (gu3Var.a & 8) != 0 ? gu3Var.b[3] : ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        }
    }

    @Override // defpackage.du1
    public final void b(mu1 mu1Var) {
        mu1Var.d(t51.REFUSED_STREAM, null);
    }

    @Override // defpackage.q61
    public final void cancel() {
        jz4.c(this.d);
    }

    @Override // defpackage.q61
    public final void d() {
        synchronized (this) {
            this.j = true;
        }
    }

    @Override // defpackage.q61
    public final void e(le3 le3Var, IOException iOException) {
        synchronized (this) {
            try {
                if (!(iOException instanceof x34)) {
                    if (!(this.i != null) || (iOException instanceof bb0)) {
                        this.j = true;
                        if (this.m == 0) {
                            if (iOException != null) {
                                c(le3Var.b, this.c, iOException);
                            }
                            this.l++;
                        }
                    }
                } else if (((x34) iOException).b == t51.REFUSED_STREAM) {
                    int i = this.n + 1;
                    this.n = i;
                    if (i > 1) {
                        this.j = true;
                        this.l++;
                    }
                } else if (((x34) iOException).b != t51.CANCEL || !le3Var.G0) {
                    this.j = true;
                    this.l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        synchronized (this) {
            this.m++;
        }
    }

    @Override // defpackage.q61
    public final em3 g() {
        return this.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(defpackage.a6 r9, java.util.List r10) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.me3.h(a6, java.util.List):boolean");
    }

    public final boolean i(boolean z) {
        long j;
        TimeZone timeZone = jz4.a;
        long jNanoTime = System.nanoTime();
        if (this.d.isClosed() || this.e.isClosed() || this.e.isInputShutdown() || this.e.isOutputShutdown()) {
            return false;
        }
        fu1 fu1Var = this.i;
        if (fu1Var != null) {
            return fu1Var.s(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.q;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        Socket socket = this.e;
        he3 he3Var = (he3) this.h.z;
        socket.getClass();
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !he3Var.g();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final void j() throws SocketException {
        this.q = System.nanoTime();
        ba3 ba3Var = this.g;
        if (ba3Var == ba3.HTTP_2 || ba3Var == ba3.H2_PRIOR_KNOWLEDGE) {
            this.e.setSoTimeout(0);
            k01 k01Var = k01.f;
            bg1 bg1Var = bg1.a;
            ab4 ab4Var = this.b;
            ab4Var.getClass();
            v92 v92Var = new v92();
            v92Var.b = ab4Var;
            v92Var.A = du1.a;
            v92Var.X = bg1.a;
            ed4 ed4Var = this.h;
            String str = this.c.a.i.d;
            ed4Var.getClass();
            str.getClass();
            v92Var.f = ed4Var;
            v92Var.z = jz4.b + ' ' + str;
            v92Var.A = this;
            v92Var.X = bg1Var;
            fu1 fu1Var = new fu1(v92Var);
            this.i = fu1Var;
            gu3 gu3Var = fu1.Q0;
            this.o = (gu3Var.a & 8) != 0 ? gu3Var.b[3] : ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
            nu1 nu1Var = fu1Var.N0;
            synchronized (nu1Var) {
                try {
                    if (nu1Var.A) {
                        throw new IOException("closed");
                    }
                    Logger logger = nu1.Y;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(jz4.d(">> CONNECTION " + xt1.a.e(), new Object[0]));
                    }
                    nu1Var.b.A0(xt1.a);
                    nu1Var.b.flush();
                } catch (Throwable th) {
                    throw th;
                }
            }
            fu1Var.N0.M(fu1Var.H0);
            if (fu1Var.H0.a() != 65535) {
                fu1Var.N0.N(0, r6 - 65535);
            }
            za4.c(fu1Var.Z.d(), fu1Var.z, fu1Var.O0);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        em3 em3Var = this.c;
        sb.append(em3Var.a.i.d);
        sb.append(':');
        sb.append(em3Var.a.i.e);
        sb.append(", proxy=");
        sb.append(em3Var.b);
        sb.append(" hostAddress=");
        sb.append(em3Var.c);
        sb.append(" cipherSuite=");
        zq1 zq1Var = this.f;
        sb.append(zq1Var != null ? zq1Var.b : "none");
        sb.append(" protocol=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
