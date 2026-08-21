package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fu1 implements Closeable {
    public static final gu3 Q0;
    public int A;
    public final za4 A0;
    public final t60 B0;
    public long C0;
    public long D0;
    public long E0;
    public long F0;
    public final bg1 G0;
    public final gu3 H0;
    public gu3 I0;
    public final bi4 J0;
    public long K0;
    public long L0;
    public final ed4 M0;
    public final nu1 N0;
    public final kt O0;
    public final LinkedHashSet P0;
    public int X;
    public boolean Y;
    public final ab4 Z;
    public final du1 b;
    public final LinkedHashMap f = new LinkedHashMap();
    public final za4 y0;
    public final String z;
    public final za4 z0;

    static {
        gu3 gu3Var = new gu3();
        gu3Var.b(4, 65535);
        gu3Var.b(5, 16384);
        Q0 = gu3Var;
    }

    public fu1(v92 v92Var) {
        this.b = (du1) v92Var.A;
        String str = (String) v92Var.z;
        if (str == null) {
            n12.T("connectionName");
            throw null;
        }
        this.z = str;
        this.X = 3;
        ab4 ab4Var = (ab4) v92Var.b;
        this.Z = ab4Var;
        this.y0 = ab4Var.d();
        this.z0 = ab4Var.d();
        this.A0 = ab4Var.d();
        this.B0 = t60.z0;
        this.G0 = (bg1) v92Var.X;
        gu3 gu3Var = new gu3();
        gu3Var.b(4, 16777216);
        this.H0 = gu3Var;
        this.I0 = Q0;
        this.J0 = new bi4(0);
        this.L0 = r0.a();
        ed4 ed4Var = (ed4) v92Var.f;
        if (ed4Var == null) {
            n12.T("socket");
            throw null;
        }
        this.M0 = ed4Var;
        this.N0 = new nu1((ge3) ed4Var.A);
        this.O0 = new kt(this, new iu1((he3) ed4Var.z));
        this.P0 = new LinkedHashSet();
    }

    public final void C(t51 t51Var) {
        synchronized (this.N0) {
            synchronized (this) {
                if (this.Y) {
                    return;
                }
                this.Y = true;
                this.N0.x(this.A, t51Var, hz4.a);
            }
        }
    }

    public final void F(long j) {
        synchronized (this) {
            try {
                bi4.c(this.J0, j, 0L, 2);
                long jB = this.J0.b();
                if (jB >= this.H0.a() / 2) {
                    N(0, jB);
                    bi4.c(this.J0, 0L, jB, 1);
                }
                bg1 bg1Var = this.G0;
                bi4 bi4Var = this.J0;
                bg1Var.getClass();
                bi4Var.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.N0.z);
        r6 = r2;
        r8.K0 += r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I(int i, boolean z, hp hpVar, long j) {
        int iMin;
        long j2;
        if (j == 0) {
            this.N0.n(z, i, hpVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            long j3 = this.K0;
                            long j4 = this.L0;
                            if (j3 < j4) {
                                break;
                            } else {
                                if (!this.f.containsKey(Integer.valueOf(i))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            j -= j2;
            this.N0.n(z && j == 0, i, hpVar, iMin);
        }
    }

    public final void M(final int i, final t51 t51Var) {
        za4.c(this.y0, this.z + '[' + i + "] writeSynReset", new pl1() { // from class: zt1
            @Override // defpackage.pl1
            public final Object a() {
                fu1 fu1Var = this.b;
                try {
                    fu1Var.N0.I(i, t51Var);
                } catch (IOException e) {
                    t51 t51Var2 = t51.PROTOCOL_ERROR;
                    fu1Var.g(t51Var2, t51Var2, e);
                }
                return xl4.a;
            }
        });
    }

    public final void N(final int i, final long j) {
        za4.c(this.y0, this.z + '[' + i + "] windowUpdate", new pl1() { // from class: yt1
            @Override // defpackage.pl1
            public final Object a() {
                fu1 fu1Var = this.b;
                try {
                    fu1Var.N0.N(i, j);
                } catch (IOException e) {
                    t51 t51Var = t51.PROTOCOL_ERROR;
                    fu1Var.g(t51Var, t51Var, e);
                }
                return xl4.a;
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        g(t51.NO_ERROR, t51.CANCEL, null);
    }

    public final void flush() {
        this.N0.flush();
    }

    public final void g(t51 t51Var, t51 t51Var2, IOException iOException) {
        int i;
        Object[] array;
        TimeZone timeZone = jz4.a;
        try {
            C(t51Var);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.f.isEmpty()) {
                array = null;
            } else {
                array = this.f.values().toArray(new mu1[0]);
                this.f.clear();
            }
        }
        mu1[] mu1VarArr = (mu1[]) array;
        if (mu1VarArr != null) {
            for (mu1 mu1Var : mu1VarArr) {
                try {
                    mu1Var.d(t51Var2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.N0.close();
        } catch (IOException unused3) {
        }
        try {
            ((Socket) ((iv1) this.M0.f).f).close();
        } catch (IOException unused4) {
        }
        this.y0.f();
        this.z0.f();
        this.A0.f();
    }

    public final mu1 n(int i) {
        mu1 mu1Var;
        synchronized (this) {
            mu1Var = (mu1) this.f.get(Integer.valueOf(i));
        }
        return mu1Var;
    }

    public final boolean s(long j) {
        synchronized (this) {
            if (this.Y) {
                return false;
            }
            if (this.E0 < this.D0) {
                if (j >= this.F0) {
                    return false;
                }
            }
            return true;
        }
    }

    public final mu1 x(int i) {
        mu1 mu1Var;
        synchronized (this) {
            mu1Var = (mu1) this.f.remove(Integer.valueOf(i));
            notifyAll();
        }
        return mu1Var;
    }
}
